console.log("JavaScript loaded!");

const getData = async () => {

    const input = document.getElementById("input");
    const message = document.getElementById("message");

    if (input.value) {
        if (true) {
            message.textContent = "Please wait for results...";

            const url = "http://localhost:8080/json?location="+input.value.replace(/ /g,"-");
            console.log(url);
            const response = await fetch(url);

            let data = await response.json();
            console.log(data);

            message.textContent = "";

            document.getElementById("results").style.display = "initial";
            document.getElementById("place-name").textContent = data.place_name;
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

    }

    else {
        message.textContent = "Please fill in the input!"
    }
    
}

document.getElementById("submit").addEventListener("click",getData);