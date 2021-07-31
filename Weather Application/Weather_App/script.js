let weather = {
    "apiKey": "c7ea76f1e383156fe9116f9a37e059a1",
    fetchWeather: function(city){
        fetch("http://api.openweathermap.org/data/2.5/weather?q="
        + city 
        +"&appid=" 
        + this.apiKey
        ).then((response) => response.json())
        .then((data) => console.log(data));
    },

    displayWeather: function(data)
    {
        const {name }=  data;
        const {icon, description} = data.weather;
        const{temperature, humidity} = data.main;
        const {speed} = data.wind;
        console.log(name, icon, description, temp, humidity)
    }
}

console.log(typeof(weather));