#importing Libraries
#import findspark
#findspark.init()
from pyspark.sql import DataFrame
from pyspark import SparkContext, SQLContext, SparkConf
from pyspark.ml import Pipeline
from pyspark.ml.feature import StringIndexer, VectorIndexer
from pyspark.ml.evaluation import MulticlassClassificationEvaluator
from pyspark.sql import SparkSession
from pyspark.sql.functions import when
from pyspark.ml.feature import Imputer
from pyspark.ml.feature import VectorAssembler
from pyspark.ml.feature import VectorAssembler
from pyspark.ml.feature import StandardScaler
from pyspark.mllib.util import MLUtils
from pyspark.mllib.evaluation import MulticlassMetrics
from pyspark.ml.classification import RandomForestClassifier
from prettytable import PrettyTable


##--------------------------------------         code to create spark session                ------------------------##
sc = SparkContext()
spark_session = SparkSession.builder.master("local").appName("WineQualityPrediction").config("spark.some.config.option","some-value").getOrCreate()


##--------------------------------------         code to read dataset                        ------------------------##
                                 
trainDataframe = spark_session.read.csv('TrainingDataset.csv',header='true', inferSchema='true', sep=';')                                       
##--------------------------------------         code to extract feature columns               ------------------------##
featureColumns = [c for c in trainDataframe.columns if (c not in 'quality')]
assembler_t = VectorAssembler(inputCols=featureColumns, outputCol="features")
train_trans = assembler_t.transform(trainDataframe)
train_trans.cache()

##--------------------------------------         code to read validation dataset               ------------------------##
valDataframe = spark_session.read.csv('ValidationDataset.csv',header='true', inferSchema='true', sep=';')                                      

##--------------------------------------      code to create vector assembler for validation dataset       ------------------------##
feature = [c for c in valDataframe.columns if (c not in 'quality')]
assembler_v = VectorAssembler(inputCols=feature, outputCol="features")
val_trans = assembler_v.transform(valDataframe)

random_forest = RandomForestClassifier(labelCol="quality", featuresCol="features", numTrees=10)

print("\nProgram has started : \n")

##--------------------------------------         code to create model               ------------------------##
model = random_forest.fit(train_trans)
model.write().overwrite().save("model")

##--------------------------------------         code to evaluate model               ------------------------##
predictions = model.transform(val_trans)

##--------------------------------------         code to calculate accuracy               ------------------------##
accuracy = MulticlassClassificationEvaluator(
    labelCol="quality", predictionCol="prediction", metricName="accuracy").evaluate(predictions)
print("Testing- Accuracy Error = %g" % (1.0 - accuracy))


transformed_data = model.transform(val_trans)
print(MulticlassClassificationEvaluator(
    labelCol="quality", predictionCol="prediction", metricName="accuracy").getMetricName(), 'accuracy:', MulticlassClassificationEvaluator(
    labelCol="quality", predictionCol="prediction", metricName="accuracy").evaluate(transformed_data))
	
##--------------------------------------         code to display accuracy in tabular form               ------------------------##
y = PrettyTable()
y.field_names = ["Accuracy test error", "Accuracy"]
y.add_row(["%g" % (1.0 - accuracy),MulticlassClassificationEvaluator(
    labelCol="quality"   , predictionCol="prediction", metricName="accuracy").evaluate(transformed_data)])
print(y)
print("\n")

##--------------------------------------         code to calculate f1 score               ------------------------##
accuracy = MulticlassClassificationEvaluator(
    labelCol="quality", predictionCol="prediction", metricName="f1").evaluate(predictions)
print("Testing- F1 Error = %g" % (1.0 - accuracy))
transformed_data = model.transform(val_trans)
print(MulticlassClassificationEvaluator(
    labelCol="quality", predictionCol="prediction", metricName="f1").getMetricName(), 'accuracy :', MulticlassClassificationEvaluator(
    labelCol="quality", predictionCol="prediction", metricName="f1").evaluate(transformed_data))
	
##--------------------------------------         code to display f1 in tabular form               ------------------------##
x = PrettyTable()
x.field_names = ["F1 test error", "F1"]
x.add_row(["%g" % (1.0 - accuracy), MulticlassClassificationEvaluator(
    labelCol="quality", predictionCol="prediction", metricName="f1").evaluate(transformed_data)])
print(x)
print("\n")
	
##--------------------------------------         code to stop spark session               ------------------------##
spark_session.stop()