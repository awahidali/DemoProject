package com.miro.apiCalls;

import com.aventstack.extentreports.Status;
import com.miro.common.ExtentTestManager;
import com.jayway.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import static com.jayway.restassured.RestAssured.given;

public class APIsCall {

    public static String action;

    public static boolean createBoard() {
        boolean flag = true;
        try {
            Response response = given()
                    .header("authority", "miro.com")
                    .header("accept", "application/json")
                    .header("origin", "https://miro.com")
                    .header("referer", "https://miro.com/app/dashboard/")
                    .header("x-csrf-token", "wcpmbrFyMrPjqVbUWLLuNFjO")
                    .header("x-user-debug", "3458764523629858225")
                    .header("cookie", "session=cc85fde9ea0f7bbf21be0476fe5883ec; detectedCountry=IN; userLocale=en; X-MR-Browser-ID=6261207ce3d107.56751709; csrf-token=5jhm604lytc044c44swocw4c8cs48gc; nonce=abb9f2rmzdsg40oowc8gwkkkwg440os; ajs_anonymous_id=\"6013ff86-42f7-43c0-96a8-92c916360df7\"; mr-anon-id-1=\"6013ff86-42f7-43c0-96a8-92c916360df7\"; ajs_user_id=null; ajs_group_id=null; pageviewCount=1; __pdst=b2e7bd6efccf43acb5df63419c59324e; _gcl_au=1.1.321069708.1650532479; _hjSessionUser_763128=eyJpZCI6Ijg4MzIxZmUwLTA2MTYtNWU4Yi05NDc1LTk5OGVkZDBiMjhlNSIsImNyZWF0ZWQiOjE2NTA1MzI0Nzg5OTMsImV4aXN0aW5nIjpmYWxzZX0=; _hjFirstSeen=1; _hjSession_763128=eyJpZCI6IjBlMDAxNzllLWEwYzAtNDc5Mi04NDI5LWVjNzBlY2U4NzU3NyIsImNyZWF0ZWQiOjE2NTA1MzI0NzkwOTAsImluU2FtcGxlIjpmYWxzZX0=; _hjAbsoluteSessionInProgress=0; _uetsid=78944b30c15311eca52bd121f2939186; _uetvid=7894cac0c15311ecb2e56d69b261620a; _fbp=fb.1.1650532479341.256939804; cb_user_id=null; cb_group_id=null; cb_anonymous_id=\"aad3bafb-6aab-4e5a-b99e-a95dfaab7806\"; _clck=lvfl1d|1|f0t|0; _clsk=1a6xo7x|1650532481118|1|0|a.clarity.ms/collect; __hstc=18393318.d67cb5e3545290969da8172a35039033.1650532481219.1650532481219.1650532481219.1; hubspotutk=d67cb5e3545290969da8172a35039033; __hssrc=1; __hssc=18393318.1.1650532481220; fbp_tracked=fb.1.1650532479341.256939804; _ga=GA1.2.1161376714.1650532481; _gid=GA1.2.1485545696.1650532481; userInfo={\"id\":\"3458764523629858225\",\"betaUser\":false,\"domainGroup\":\"PERSONAL\"}; prevUserId=3458764523629858225; isRegistered=1; token=M8JTwz16qISXQulyM6nC2PdLD0lf5GPhFtLSaz2cmI8NW5Z7nTZ58cR1VTFlCFkz; workspaces=app; mr-ab=eyJ6b29tX2hvbWVwYWdlX2Jhbm5lcl9SVEJfODI0NTIiOiJzaG93X2Jhbm5lciIsInVzZV9jYXNlX3ZzX3RlbXBsYXRlX2NhdGVnb3J5X1JUQl84MzAzOSI6InJlZGlyZWN0X3RvX2NoYWxsZW5nZXIiLCJ1c2VfY2FzZV92c190ZW1wbGF0ZV9wYWdlX1JUQl84MzAzOSI6ImRlZmF1bHQiLCJydGJfODQ5NjJfaG9tZXBhZ2VfbW9iaWxlX2V4cGVyaW1lbnQiOiJnZXRfYXBwIiwicnRiXzg4NzAxX2VkdWNhdGlvbl93aGl0ZWJvYXJkX2V4cGVyaW1lbnQiOiJscC1idWlsZGVyLXBhZ2UtMSJ9; ajs_anonymous_id=\"6013ff86-42f7-43c0-96a8-92c916360df7\"; ajs_user_id=\"3458764523629858225\"; AWSELB=53891BDF1614A34BF7BB8D80766D0256C19DAC6ED7F361E9AC75F3309560B18E375B97B64F7CDA156C219CD2391BF01A1996A795EBE399BC2EACB8574AA1C4859A285E2D57; NPS_17eee59d_last_seen=1650532489398; OptanonConsent=isGpcEnabled=0&datestamp=Thu+Apr+21+2022+14:44:54+GMT+0530+(India+Standard+Time)&version=6.24.0&isIABGlobal=false&hosts=&consentId=ac8e8e9c-63c2-4b76-9bdb-22417aa76acc&interactionCount=1&landingPath=NotLandingPage&groups=C0001:1,C0002:0,C0003:0,C0004:0&AwaitingReconsent=false; NPS_17eee59d_throttle=1650575696815")
                    .log().all()
                    .when()
                    .post("https://miro.com/api/v1/boards/?accountId=3458764523629097685")
                    .then()
                    .log().ifStatusCodeIsEqualTo(201)
                    .extract().response();

            String responseInfo = response.andReturn().asString();
            JSONObject obj = new JSONObject(responseInfo);


            String id=obj.getString("id");
            action = id.replace("=","%3D");
            ExtentTestManager.getTest().log(Status.PASS, "New blank board is created");
            ExtentTestManager.getTest().log(Status.INFO,response.andReturn().asString());
        } catch (Exception e) {
            flag = false;
        }
        return flag;


    }

    public static void invite(String user) {
        Map<String, String> body = new HashMap<>();
        body.put("emails", user);
        body.put("role", "EDITOR");
        body.put("message", "");
        String operation = "https://miro.com/app/board/"+action+"/share";
        String requestedURL = operation.replace("25","");
        try {
            Response response = given()
                    .header("authority", "miro.com")
                    .header("accept", "application/json")
                    .header("origin", "https://miro.com")
                    .header("referer", "https://miro.com/app/board/"+action)
                    .header("x-csrf-token", "GRwAXkowXTKgxHdwT0wOVq0a")
                    .header("x-user-debug", "3458764523629858225")
                    .contentType("application/json")
                    .header("cookie", "session=9f30685761f852781e854d940212aa3d; detectedCountry=IN; userLocale=en; X-MR-Browser-ID=626101bc3783e1.86713689; csrf-token=9inl2yjbgkcg4k0cw488csgsog4kkc0; ajs_anonymous_id=%220365dcdc-e0f8-4a66-9676-b04d80ec1c97%22; mr-anon-id-1=%220365dcdc-e0f8-4a66-9676-b04d80ec1c97%22; ajs_user_id=null; ajs_group_id=null; _hjSessionUser_763128=eyJpZCI6IjMyYTY3Mzk2LTI1NjUtNTM4ZC04MGE1LTM3OTJlZWY4MTFjZiIsImNyZWF0ZWQiOjE2NTA1MjQ2MDUwNjUsImV4aXN0aW5nIjpmYWxzZX0=; pageviewCount=1; fbp_tracked=undefined; __pdst=3fe74385c063438aac26a417350c4a9f; _uetsid=23c114e0c14111ec8ce3b9bcd6651b28; _uetvid=23c13790c14111ec989ca7c997f06dac; __hstc=18393318.ee90fc47ba80b6ad48f1deec68c38165.1650524605876.1650524605876.1650524605876.1; hubspotutk=ee90fc47ba80b6ad48f1deec68c38165; __hssrc=1; _gcl_au=1.1.792361349.1650524606; _ga=GA1.2.1502015985.1650524606; _gid=GA1.2.1123552604.1650524606; cb_user_id=null; cb_group_id=null; cb_anonymous_id=%2208a4b4cd-7c62-4e26-b1a3-8a315248a5f0%22; userInfo=%7B%22id%22%3A%223458764523629858225%22%2C%22betaUser%22%3Afalse%2C%22domainGroup%22%3A%22PERSONAL%22%7D; prevUserId=3458764523629858225; isRegistered=1; token=STA5MbfGStTU3pGpN5eg068HZ0iGYEJENGh9iuiFgTWAUDYMjN2i0pVsPmLfcuwg; workspaces=app; _clck=zcqsxp|1|f0t|0; _fbp=fb.1.1650524606806.2023860694; mr-ab=eyJ6b29tX2hvbWVwYWdlX2Jhbm5lcl9SVEJfODI0NTIiOiJzaG93X2Jhbm5lciIsInVzZV9jYXNlX3ZzX3RlbXBsYXRlX2NhdGVnb3J5X1JUQl84MzAzOSI6ImRlZmF1bHQiLCJ1c2VfY2FzZV92c190ZW1wbGF0ZV9wYWdlX1JUQl84MzAzOSI6ImRlZmF1bHQiLCJydGJfODQ5NjJfaG9tZXBhZ2VfbW9iaWxlX2V4cGVyaW1lbnQiOiJnZXRfYXBwIiwicnRiXzg4NzAxX2VkdWNhdGlvbl93aGl0ZWJvYXJkX2V4cGVyaW1lbnQiOiJscC1idWlsZGVyLXBhZ2UtMiJ9; ajs_anonymous_id=%220365dcdc-e0f8-4a66-9676-b04d80ec1c97%22; ajs_user_id=%223458764523629858225%22; NPS_17eee59d_last_seen=1650524610821; NPS_17eee59d_throttle=1650567811345; OptanonConsent=isGpcEnabled=0&datestamp=Thu+Apr+21+2022+12%3A51%3A41+GMT%2B0530+(India+Standard+Time)&version=6.24.0&isIABGlobal=false&hosts=&consentId=2d1721ab-11f4-41b1-bc44-8238ea3cc99f&interactionCount=1&landingPath=NotLandingPage&groups=C0001%3A1%2CC0002%3A0%2CC0003%3A0%2CC0004%3A0&AwaitingReconsent=false; AWSELB=53891BDF1614A34BF7BB8D80766D0256C19DAC6ED749FAB9A4F1C71AF747A72F6BE66E12EAEA01A885D074D7C6DC8B0646E0531EA0F8F1DEA3CD72B8036CBFE1C804B70F2D")
                    .queryParam("fields","data{boardConnection{accountConnection{id,organizationConnection{role,license},user{id}}}}")
                    .body(body)
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
