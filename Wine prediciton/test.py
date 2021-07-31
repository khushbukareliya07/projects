#importing Libraries
#import findspark
#findspark.init()
import time
from pyspark.sql import DataFrame
from pyspark import SparkContext, SQLContext, SparkConf
from pyspark.ml import Pipeline
from pyspark.ml.feature import StringIndexer, VectorIndexer
from pyspark.ml.evaluation import MulticlassClassificationEvaluator
from pyspark.sql import SparkSession
from pyspark.ml.feature import Imputer
from pyspark.sql.functions import when
from pyspark.ml.feature import VectorAssembler
from pyspark.ml.feature import StandardScaler
from pyspark.ml.classification import RandomForestClassificationModel
from pyspark.mllib.evaluation import MulticlassMetrics
from prettytable import PrettyTable

##--------------------------------------         code to create spark session                ------------------------##
sc = SparkContext()
spark_session = SparkSession.builder.master("local").appName("wineClasssification").getOrCreate()

print("\nProgram has started : \n")

##--------------------------------------         code to read dataset               ------------------------##
testDataframe = spark_session.read.csv('TestDataset.csv',header='true', inferSchema='true', sep=';')
feature = [c for c in testDataframe.columns if (c not in 'quality')]
assembler_test = VectorAssembler(inputCols=feature, outputCol="features")
test_trans = assembler_test.transform(testDataframe)

##--------------------------------------         code to load model                ------------------------##
model= RandomForestClassificationModel.load("model")

##--------------------------------------         code to predict                ------------------------##
predictions = model.transform(test_trans)

##--------------------------------------         code to print accuracy                ------------------------##
accuracy = MulticlassClassificationEvaluator(
    labelCol="quality", predictionCol="prediction", metricName="accuracy").evaluate(predictions)
print("Testing- Accuracy Error = %g" % (1.0 - accuracy))

transformed_data = model.transform(test_trans)
print(MulticlassClassificationEvaluator(
    labelCol="quality", predictionCol="prediction", metricName="accuracy").getMetricName(), 'accuracy:', MulticlassClassificationEvaluator(
    labelCol="quality", predictionCol="prediction", metricName="accuracy").evaluate(transformed_data))
	
y = PrettyTable()
y.field_names = ["Accuracy test error", "Accuracy"]
y.add_row(["%g" % (1.0 - accuracy),MulticlassClassificationEvaluator(
    labelCol="quality"   , predictionCol="prediction", metricName="accuracy").evaluate(transformed_data)])
print(y)
print("\n")

##--------------------------------------         code to print F1 score                ------------------------##
accuracy = MulticlassClassificationEvaluator(
    labelCol="quality", predictionCol="prediction", metricName="f1").evaluate(predictions)
print("Testing- F1 Error = %g" % (1.0 - accuracy))
transformed_data = model.transform(test_trans)
print(MulticlassClassificationEvaluator(
    labelCol="quality", predictionCol="prediction", metricName="f1").getMetricName(), 'accuracy :', MulticlassClassificationEvaluator(
    labelCol="quality", predictionCol="prediction", metricName="f1").evaluate(transformed_data))

x = PrettyTable()
x.field_names = ["F1 test error", "F1"]
x.add_row(["%g" % (1.0 - accuracy), MulticlassClassificationEvaluator(
    labelCol="quality", predictionCol="prediction", metricName="f1").evaluate(transformed_data)])
print(x)
print("\n")