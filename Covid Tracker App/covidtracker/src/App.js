
import { MenuItem, FormControl, Select, Card, CardContent  } from '@material-ui/core';
import  InfoBox from "./InfoBox";
import React, { useEffect, useState } from 'react';
import Map from './Map';
import Table from './Table';
import './App.css';
import { sortData, prettyPrintStat } from './util';
import LineGraph from './LineGraph';
import "leaflet/dist/leaflet.css";




function App() { //BEM Naming convention
  //https://disease.sh/v3/covid-19/countries 

  const [countries, setCountries] = useState(['USA', 'UK', 'INDIA']);
  const [country, setCountry] = useState( "worldwide");
  const [countryInfo, setCountryInfo] = useState({});
  const [tableData, setTableData] = useState([]);
  const [mapCenter, setMapCenter] = useState({lat:34.80746, lng:-40.4796});
  const [mapZoom, setMapZoom] = useState(3);
  const [mapCountries, setMapCountries] = useState([]);
  const [casesType, setCasesType] = useState("cases");

  useEffect(() => {
    fetch("https://disease.sh/v3/covid-19/all")
    .then(response => response.json())
    .then((data) => {
      setCountryInfo(data);
    });
  },[]);  
  
  useEffect( () => {                                                                         //USEEFFECT = Runs a piece of Code based on a given condition 
                                                                                             //The code inside here will run once when the component loads and not once again. :1:14:20    // we run here async code - why because it pings/ sends request to a server, and we need to wait for the response,  //which is in he json format. 
    const getCountriesData = async () => {
      await fetch("https://disease.sh/v3/covid-19/countries")                   //await says, wait for the website to respond.
      .then( (response) => response.json() )                                    // once you received response than do this  
      .then( (data) => {
          const countries = data.map( (country) => ({                              // working of Map function , Map vs ForEach =  1:21:00
            name:country.country,                                               //United states, India
            value: country.countryInfo.iso2                                     //UK, USA, IN
          }));
        const sortedData = sortData(data);  
        setTableData(sortedData);  
        setMapCountries(data);
        setCountries(countries);
      });
    };
    getCountriesData();   
  }, [] );
                                                                                                  
    const onCountryChange = async (event) => {                                               {/* this below function listens , whatever option we choose from the */}
    const countryCode = event.target.value;
    console.log("Output Here", countryCode);
    setCountry(countryCode);

    const url = 
      countryCode === 'worldwide' 
      ? 'https://disease.sh/v3/covid-19/all' 
      : `https://disease.sh/v3/covid-19/countries/${countryCode}`;

      await fetch(url)
      .then(response => response.json())
      .then((data) => {
        setCountry(countryCode);
        setCountryInfo(data);
        setMapCenter([data.countryInfo.lat, data.countryInfo.long]);
        setMapZoom(4);
      });
  };

  //console.log("Country Info >>>", countryInfo);


  return (
    <div className="app"> 

      <div className="app__left">  
          {/*left side of the webapp Begins here   */}
          <div className="app__header">
            
            <h1>COVID-19 TRACKER</h1>
            <FormControl className="app__dropdown">
              <Select variant = "outlined" onChange={onCountryChange} value={country} >                                  {/* This is where we have our drop down menu*/}
                {/* {loop through all the countries and show drop don list of that in options} */}
                
                <MenuItem value="worldwide">WorldWide</MenuItem>
                {
                  countries.map( 
                    (country) => (
                    <MenuItem value={country.value}>{country.name}</MenuItem>
                    )
                  )
                }
                {/* <MenuItem value=""> Option 1</MenuItem>
                <MenuItem value=""> Option 2</MenuItem>
                <MenuItem value=""> Option 3</MenuItem>
                <MenuItem value=""> Option 4</MenuItem> */}

              </Select>
            </FormControl>
          </div>              

          <div className="app__stats">
              {/* Infobox title="coronavirus cases" */}
              <InfoBox 
              isRed
              active={casesType==="cases"}
              onClick={(e)=> setCasesType("cases")}
              title="Today's Covid Cases"
              cases= {prettyPrintStat(countryInfo.todayCases)} 
              total={prettyPrintStat(countryInfo.cases)}
              />  
              
              {/* Infobox title="CoronaVirus recovered Cases" */}
              <InfoBox 
              active={casesType==="recovered"}
              onClick={(e)=> setCasesType("recovered")}
              title="Today's Recovered"  
              cases= {prettyPrintStat(countryInfo.todayRecovered)} 
              total={prettyPrintStat(countryInfo.recovered)}
              />

              {/* Infobox title="Deaths" */}
              <InfoBox 
              isRed
              active={casesType==="deaths"}
              onClick={(e)=> setCasesType("deaths")} 
              title=" Today's Deaths" 
              cases= {prettyPrintStat(countryInfo.todayDeaths)} 
              total={prettyPrintStat(countryInfo.deaths)}
              />
          </div>        
          
          {/* Map */}
          <Map 
            casesType={casesType}
            countries={mapCountries}
            center={mapCenter}
            zoom={mapZoom}
          />
            
      </div> {/* App__left section Ends here  */}

      <Card className="app__right">
        <CardContent>
          {/* table */}
          <div className="app__information">

          <h3>Live Cases by Country</h3>
          <Table countries = {tableData}/>
          {/* graph */}
          <h3 className="graph-style">WorldWide New {casesType}</h3>
          <LineGraph className="app_graph" casesType={casesType}/>
          </div>
        </CardContent>
      </Card>

  
    </div>
  );
}

export default App;
