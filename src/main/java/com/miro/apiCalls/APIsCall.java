package com.miro.apiCalls;

import com.aventstack.extentreports.Status;
import com.miro.common.ExtentTestManager;
import com.jayway.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import static com.jayway.restassured.RestAssured.given;

public class APIsCall {

    public static String cookies = "session=9d89b807dd71ca2de781513eefa8e22e; detectedCountry=IN; userLocale=en; X-MR-Browser-ID=6262372f140fd4.12456398; csrf-token=fnmad9xuq28s0w80o44k00swk0k4sks; nonce=8abamyktz4kcgo8sck4csssw0g4c4ss; ajs_anonymous_id=%22400d1a24-960b-4d5e-a00e-85870b9e3519%22; mr-anon-id-1=%22400d1a24-960b-4d5e-a00e-85870b9e3519%22; ajs_user_id=null; ajs_group_id=null; _hjSessionUser_763128=eyJpZCI6ImU3YmMyMjliLThmMmYtNTcxZC05OTY4LTMyYjA2NmFhYzRkMiIsImNyZWF0ZWQiOjE2NTA2MDM4MjM2MDUsImV4aXN0aW5nIjpmYWxzZX0=; _hjFirstSeen=1; _hjSession_763128=eyJpZCI6ImZlNDY0NTAyLWFjZjAtNGU4OS1hNDM5LTdiODY5Yjg4N2U2MSIsImNyZWF0ZWQiOjE2NTA2MDM4MjM2MzAsImluU2FtcGxlIjpmYWxzZX0=; _hjAbsoluteSessionInProgress=0; pageviewCount=1; __pdst=454817aceeaa44598be4e215d34af06c; _fbp=fb.1.1650603824083.506578746; _gcl_au=1.1.2081930801.1650603824; _uetsid=95a70fa0c1f911ecb11beb9bb0b3917b; _uetvid=95a77380c1f911ecb1cb474ea8873f87; cb_user_id=null; cb_group_id=null; cb_anonymous_id=%2263536e32-ab22-4fa2-8578-f3d9e9e2355f%22; _clck=1p5y5y1|1|f0u|0; __hstc=18393318.f95ac604166b4c1a971d0cbe06ffb7c7.1650603825799.1650603825799.1650603825799.1; hubspotutk=f95ac604166b4c1a971d0cbe06ffb7c7; __hssrc=1; __hssc=18393318.1.1650603825800; fbp_tracked=fb.1.1650603824083.506578746; _ga=GA1.2.1178944377.1650603826; _gid=GA1.2.1361463818.1650603826; _clsk=9atz1q|1650603826107|1|0|a.clarity.ms/collect; OptanonAlertBoxClosed=2022-04-22T05:03:46.941Z; userInfo=%7B%22id%22%3A%223458764523629858225%22%2C%22betaUser%22%3Afalse%2C%22domainGroup%22%3A%22PERSONAL%22%7D; prevUserId=3458764523629858225; isRegistered=1; token=PesFMS6qLMazmAO9MAIqjgAZksIM2F31qX5Ydk5VWJuPx3OWPHTs8uqL2ixumFMK; workspaces=app; mr-ab=eyJ6b29tX2hvbWVwYWdlX2Jhbm5lcl9SVEJfODI0NTIiOiJzaG93X2Jhbm5lciIsInVzZV9jYXNlX3ZzX3RlbXBsYXRlX2NhdGVnb3J5X1JUQl84MzAzOSI6ImRlZmF1bHQiLCJ1c2VfY2FzZV92c190ZW1wbGF0ZV9wYWdlX1JUQl84MzAzOSI6InJlZGlyZWN0X3RvX2NoYWxsZW5nZXIiLCJydGJfODQ5NjJfaG9tZXBhZ2VfbW9iaWxlX2V4cGVyaW1lbnQiOiJnb190b19hcHBzX3BhZ2UiLCJydGJfODg3MDFfZWR1Y2F0aW9uX3doaXRlYm9hcmRfZXhwZXJpbWVudCI6ImxwLWJ1aWxkZXItcGFnZS0yIn0%3D; ajs_anonymous_id=%22400d1a24-960b-4d5e-a00e-85870b9e3519%22; ajs_user_id=%223458764523629858225%22; AWSELB=53891BDF1614A34BF7BB8D80766D0256C19DAC6ED749FAB9A4F1C71AF747A72F6BE66E12EA22F55DB13E7F3DA913011AB2254ECEE2FDF7371BD517EF4AEDDA69567BABBD89; NPS_17eee59d_last_seen=1650603834363; OptanonConsent=isGpcEnabled=0&datestamp=Fri+Apr+22+2022+10%3A33%3A59+GMT%2B0530+(India+Standard+Time)&version=6.24.0&isIABGlobal=false&hosts=&consentId=227bf58e-737d-44be-aad8-3691c605b464&interactionCount=2&landingPath=NotLandingPage&groups=C0001%3A1%2CC0002%3A1%2CC0003%3A1%2CC0004%3A1&geolocation=IN%3BDL&AwaitingReconsent=false";
    public static String token = "FRorhe4usWMg11Zgp37Ku8ZR";
    public static String boardId;

    public static boolean createBoard() {
        boolean flag = true;
        try {
            Response response = given()
                    .header("authority", "miro.com")
                    .header("accept", "application/json")
                    .header("origin", "https://miro.com")
                    .header("referer", "https://miro.com/app/dashboard/")
                    .header("x-csrf-token", token)
                    .header("x-user-debug", "3458764523629858225")
                    .header("cookie", cookies)
                    .log().all()
                    .when()
                    .post("https://miro.com/api/v1/boards/?accountId=3458764523629097685")
                    .then()
                    .log().ifStatusCodeIsEqualTo(201)
                    .extract().response();

            String responseInfo = response.andReturn().asString();
            JSONObject obj = new JSONObject(responseInfo);


            String id=obj.getString("id");
            boardId = id;//.replace("=","%3D");
            ExtentTestManager.getTest().log(Status.PASS, "New blank board is created");
            ExtentTestManager.getTest().log(Status.INFO,response.andReturn().asString());
        } catch (Exception e) {
            flag = false;
        }
        return flag;


    }

    public static void invite(String user) {
       
        String requestBody = "{\"emails\":[\""+user+"\"],\"role\":\"EDITOR\",\"message\":\"\"}";
        String operation = "https://miro.com/api/v1/boards/"+boardId+"/share";
       //String requestedURL = operation;
       String requestedURL = "https://miro.com/api/v1/boards/"+boardId+"/share";
       System.out.println(operation);
        try {
            Response response = given()
                    .header("authority", "miro.com")
                    .header("accept", "application/json")
                    .header("origin", "https://miro.com")
                    .header("referer", "https://miro.com/app/board/"+boardId)
                    .header("x-csrf-token", token)
                    .header("x-user-debug", "3458764523629858225")
                    .contentType("application/json")
                    .header("Accept-Encoding","gzip, deflate, br")
                    .header("Connection","keep-alive")
                    .header("accept-language","en-US,en;q=0.9")
                    .header("sec-ch-ua","\" Not A;Brand\";v=\"99\", \"Chromium\";v=\"100\", \"Google Chrome\";v=\"100\"")
                    .header("sec-ch-ua-platform","Windows")
                    .header("x-client-type","desktop")
                    .header("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/100.0.4896.127 Safari/537.36")
                    .header("x-client-version","1.14839.0")
                    .header("cookie", cookies)
                    .accept("*/*")
                    .queryParam("fields","data{boardConnection{accountConnection{id,organizationConnection{role,license},user{id}}}}")
                    .body(requestBody)
                    .log().all()
                    .when()
                    .post(requestedURL)
                    .then()
                    .log().ifStatusCodeIsEqualTo(200)
                    .extract().response();

            String s = response.andReturn().asString();
            System.out.println(s);
            ExtentTestManager.getTest().log(Status.PASS, "Invite has been send to the " + user);
            ExtentTestManager.getTest().log(Status.INFO,response.andReturn().asString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
