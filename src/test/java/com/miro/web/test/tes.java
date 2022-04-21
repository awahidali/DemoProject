package com.miro.web.test;

import org.apache.commons.codec.binary.Base64;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class tes {
    public static void main(String[] args) {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("D:\\DemoProject\\src\\test\\resources\\credentials.json")) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray userList = (JSONArray) obj;

            System.out.println(userList);
            JSONObject user1 = (JSONObject) ((JSONObject) userList.get(0)).get("user");
            String username1 = (String)user1.get("username");
            String password1 = (String)user1.get("password");
            JSONObject user2 = (JSONObject) ((JSONObject) userList.get(1)).get("user");
            String username2 = (String)user1.get("username");
            String password2 = (String)user1.get("password");

            System.out.println(username1+":"+password1);
            System.out.println(username2+":"+password2);

            //Iterate over employee array
           // userList.forEach(usn -> parseEmployeeObject((JSONObject) usn));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }




    private static void parseEmployeeObject(JSONObject employee) {
        //Get employee object within list
        JSONObject employeeObject = (JSONObject) employee.get("user");

        //Get employee first name
        String username = (String) employeeObject.get("username");
        System.out.println(username);

        //Get employee last name
        String password = (String) employeeObject.get("password");
        System.out.println(password);

    }
}

