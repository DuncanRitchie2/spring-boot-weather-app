console.log("JavaScript loaded!");

const getData = async () => {
    const response = await fetch("http://localhost:8080/json");
    // console.log(response);

    const data = await response.json();
    console.log(data);

    document.getElementById("summary").textContent = data.daily.summary;
}

document.getElementById("submit").addEventListener("click",getData);