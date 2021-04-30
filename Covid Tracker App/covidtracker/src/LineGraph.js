import React, {useState, useEffect} from 'react';
import {Line} from 'react-chartjs-2';
import numeral from "numeral";
import './LineGraph.css';


const options = {
    legend: {
        display:false,
    },
    
    elements: {
        point: {
            radius:0,
        },
    },
    maintainAspectRatio: false, 
    tooltips: {
        mode:"index",
        intersect: false,
        callbacks: {
            label:function(tooltipItem , data) {
                return numeral (tooltipItem.value).format("+0,0");
            },
        },
    },

    scales: {
        xAxes: [
            {
                type: "time",
                time: {
                    format: "MM/DD/YY",
                    tooltipFormat: "ll",
                },
            },
        ],
        yAxes: [
            {
               gridLines: {
                   display: false,
               },

               ticks: {
                   //include a dollar sign in the ticks.
                   callback: function (value, index, values) {
                       return numeral(value).format("0a");
                   },
               } ,
            },
        ],
    },
};



//writing a function to extract 'cases' from the object array. 
const build_Chart_Data = (data, casesType) => {
    let chartData = [];
    let lastDataPoint;
    for(let date in data.cases) {
        if(lastDataPoint) {
            let newDataPoint = {
                x:date,
                y: data[casesType][date] - lastDataPoint,             //to get the difference and see the cases on particular day!
            };
            chartData.push(newDataPoint);
        }
        lastDataPoint = data[casesType][date];
    }
    return chartData;
};

function LineGraph({casesType="cases", ...props}) {
    const [data, setData] = useState({});                                         //URL: https://disease.sh/v3/covid-19/historical?lastdays=120

    
    useEffect(()=> {
        const fecthedData = async() => {
            // console.log("Inside the LineGraph File ")
            await fetch('https://disease.sh/v3/covid-19/historical/all?lastdays=120')
            .then((response) => {
                return response.json();
                })
            .then( (data) => {
                // clever stuff - what to do with Data ??
                // console.log(data);
                let chartData = build_Chart_Data(data, casesType);
                setData(chartData);
                //console.log(chartData);
            });
        };
        fecthedData();
    },[casesType]);

    

    return (
        <div classname={props.className}>

        {/* <h1>I am a Graph!</h1> */}
         {data?.length >0 && (        //(data?.length is similr to data && data.length)
             <Line 
                options={options}
                data = {{
                    datasets: [
                        {
                        backgroundColor: "rgba(150, 16,52,0.2)",
                        borderColor: "#CC1034",
                        data:data,
                        },
                    ],
                }} 
                
            />
         )}   
            
        </div>
    )
}

export default LineGraph;
