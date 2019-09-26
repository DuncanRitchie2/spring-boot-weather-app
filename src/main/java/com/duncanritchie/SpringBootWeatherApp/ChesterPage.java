package com.duncanritchie.SpringBootWeatherApp;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChesterPage {

    // This returns a HTML string from localhost:8080/chester

    @RequestMapping("/chester")
    public static String index() {
        double latitude = 53.1921;
        double longitude = -2.8803;
        System.out.println("Hello from HelloWorld.index()!");

        JsonElement jsonTree = Request.requestToJson(latitude, longitude);

        if (jsonTree.isJsonObject()) {
//            System.out.println("jsonTree is a Json object!");
            JsonObject jsonObject = jsonTree.getAsJsonObject();
            JsonElement currently = jsonObject.get("currently");
            System.out.println(currently);
            if (currently.isJsonObject()) {
//                System.out.println("currently is a Json object!");
                String outputMessage = "<h1 style='margin-top: 0;'>Duncan&rsquo;s Weather Page (for Chester only)</h1>" +
                        "<p>(If you want to type your own place in, see <a href='./' title='Duncan&rsquo;s Weather Page with an input'>my page with an input</a>.)</p>" +
                        "<p>Greetings from Chester!</p>";
                String[] keys = {"temperature","summary","windSpeed","windBearing","precipProbability","precipIntensity"};
                String[] english = {"temperature","summary","wind speed","wind bearing","probability of precipitation","intensity of precipitation"};
                String[] units = {"&deg;C",""," mph","&deg;","%",""};

                JsonObject currentlyObj =  currently.getAsJsonObject();
                for (int i = 0; i < keys.length; i++) {
                    outputMessage += "\n<p>The "+english[i]+" is <strong>"+currentlyObj.get(keys[i])+"</strong>"+units[i]+".</p>";
                }
//                System.out.println(outputMessage);

                String footer = "<footer style='position: absolute; bottom: 0; width: 100%; margin: 0; padding: 12px; border-top: 3px solid rosybrown; background-color: rgba(255,255,225,0.83);'>" +
                        "<ul style='width: 100%;\n" +
                        "    display: flex;\n" +
                        "    list-style: none;\n" +
                        "    justify-content: space-evenly;\n" +
                        "    flex-wrap: wrap;\n" +
                        "    padding: 0;\n" +
                        "    margin: 0;'>" +
                        "<li>Made by <a href='https://www.duncanritchie.co.uk' title='My website'>Duncan Ritchie</a> using Java Spring.</li>" +
                        "<li> Powered by the <a href='https://mapbox.com/about/maps' title='Mapbox'>Mapbox</a> and <a href='https://darksky.net/poweredby/' title='Dark Sky'>Dark Sky</a> APIs.</li>" +
                        "<li><a href='https://github.com/DuncanRitchie2/spring-boot-weather-app' title='My code on GitHub'>See the code.</a></li>" +
                        "</ul>" +
                        "</footer>";

//                System.out.println(currentlyObj.get("summary").toString());

                String htmlOutput = "<!DOCTYPE html>\n" +
                        "<html lang='en' style='height: 100%;'>\n" +
                        "  <head>\n" +
                        "    <meta charset='utf-8' />\n" +
                        "    <link rel='shortcut icon' href='https://www.duncanritchie.co.uk/favicon.ico' />\n" +
                        "    <meta\n" +
                        "      name='viewport'\n" +
                        "      content='width=device-width, initial-scale=1, shrink-to-fit=no'\n" +
                        "    /><title>Duncan&rsquo;s Weather Page (for Chester only)</title>" +
                        "<link href='https://fonts.googleapis.com/css?family=Alegreya&display=swap' rel='stylesheet'>" +
                        "</head>" +
                        "<body style='text-align: center; font-family: \"Alegreya\", serif; padding: 0; margin: 0; height: calc(100% - 24px); background-image: url(" +
                        PhotoFromSummary.getUrl(currentlyObj.get("summary").toString().replace("\"",""))+
                        ");" +
                        "    background-position: center center;" +
                        "    background-size: cover;" +
                        "    background-repeat: no-repeat;" +
                        "'>" +
                        "<div id='main' style='background: rgba(255,255,225,0.92); border-top: 3px solid saddlebrown; border-bottom: 3px solid saddlebrown; margin-top: 24px; padding: 12px'>" +
                        outputMessage +
                        "</div>" +
                        footer +
                        "</body></html>" ;

                return htmlOutput;
            }
            // If currently is not a Json object.
            return currently.toString();
        }
        // If jsonTree is not a Json object.
        return jsonTree.toString();
    }
}
