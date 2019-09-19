console.log("JavaScript loaded!");

const getData = async () => {

    const inputLat = document.getElementById("inputLat");
    const inputLon = document.getElementById("inputLon");

    if (inputLat.value && inputLon.value) {
        const response = await fetch("http://localhost:8080/json?lat="+inputLat.value+"&lon="+inputLon.value);

        let data = await response.json();
        console.log(data);

        document.getElementById("summary").textContent = data.daily.summary;

        const currentlyKeys = [
            {
                key: "temperature",
                english: "temperature",
                units: "&deg;C"
            },
            {
                key: "summary",
                english: "summary",
                units: ""
            },
            {
                key: "windSpeed",
                english: "wind speed",
                units: "mph"
            },
            {
                key: "windBearing",
                english: "wind bearing",
                units: "&deg;"
            },
            {
                key: "precipProbability",
                english: "probability of precipitation",
                units: "%"
            },
            {
                key: "precipIntensity",
                english: "intensity of precipitation",
                units: ""
            }
        ]

        data.currently.precipProbability *= 100;

        document.getElementById("current-conditions").textContent = "";
        for (let i = 0; i < currentlyKeys.length; i++) {
            document.getElementById("current-conditions").innerHTML += "\n<p>The "+currentlyKeys[i].english+" is <strong>"+(""+data.currently[currentlyKeys[i].key]).toLowerCase()+"</strong>"+currentlyKeys[i].units+".</p>";
        }
    }

    else {
        document.getElementById('summary').textContent = "Please fill in both inputs!"
    }
    
}

document.getElementById("submit").addEventListener("click",getData);