package com.duncanritchie.SpringBootWeatherApp;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class CodeFromMark {
        private static final String USER_AGENT = "Mozilla/5.0";
        private static final String GET_URL = Url.getDarkSkyUrl();
//        private static final String POST_URL = "http://localhost:8080";
//        private static final String POST_PARAMS = "userName=Admin";
        public static void main(String[] args) throws IOException {
            System.out.println("Running CodeFromMark.main()");
            sendGET();
            System.out.println("GET DONE");
//            sendPOST();
//            System.out.println("POST DONE");
        }
        private static void sendGET() throws IOException {
            System.out.println("Running sendGET()");
            URL obj = new URL(GET_URL);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", USER_AGENT);
            int responseCode = con.getResponseCode();
            System.out.println("GET Response Code :: " + responseCode);
            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                // print result
                System.out.println(response.toString());
            } else {
                System.out.println("GET request not worked");
            }
        }
//        private static void sendPOST() throws IOException {
//            System.out.println("Running sendPOST()");
//            URL obj = new URL(POST_URL);
//            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
//            con.setRequestMethod("POST");
//            con.setRequestProperty("User-Agent", USER_AGENT);
//            // For POST only - START
//            con.setDoOutput(true);
//            OutputStream os = con.getOutputStream();
//            os.write(POST_PARAMS.getBytes());
//            os.flush();
//            os.close();
//            // For POST only - END
//            int responseCode = con.getResponseCode();
//            System.out.println("POST Response Code :: " + responseCode);
//            if (responseCode == HttpURLConnection.HTTP_OK) { //success
//                BufferedReader in = new BufferedReader(new InputStreamReader(
//                        con.getInputStream()));
//                String inputLine;
//                StringBuffer response = new StringBuffer();
//                while ((inputLine = in.readLine()) != null) {
//                    response.append(inputLine);
//                }
//                in.close();
//                // print result
//                System.out.println(response.toString());
////                try {
////                    // parsing
//////                    Object jsonObj = new JSONParser().parse(response);
//////                    System.out.println(jsonObj);
////
//////                    // typecasting obj to JSONObject
//////                    JSONObject jo = (JSONObject) obj;
//////
//////                    Object currently = jo.get("currently");
//////                    String summary = jo.get("summary").toString();
//////
//////                    System.out.println(summary);
////                } catch (ParseException e) {
////                    e.printStackTrace();
////                } finally {}
//            } else {
//                System.out.println("POST request not worked");
//            }
//        }
}
