package postRequestTests;

import groovy.json.JsonException;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;

import org.testng.annotations.Test;

public class ValidateRegisterUser {


    @Test
    public void validateRegistrationOfUsersTest()
    {
        RequestSpecification request = RestAssured.given();

        request.header("Content-Type" , "Application/json");

        JSONObject requestJSon = new JSONObject();

        try {

            requestJSon.put("email", "sydney@fife");
            requestJSon.put("password", "pistol");
        }
        catch(JsonException e)
        {
            e.printStackTrace();
        }

        request.body(requestJSon.toString());
        Response requestResponse =  request.post("https://reqres.in/api/register");
        System.out.println(requestResponse.getBody().prettyPrint());
        Assert.assertEquals(requestResponse.getStatusCode(), 201);


    }

    @Test
    public void RegisterUnSuccessfulTest() {


        RequestSpecification request = RestAssured.given();

        request.header("Content-Type" , "Application/json");

        JSONObject requestJSon = new JSONObject();

        try {

            requestJSon.put("email", "sydney@fife");
            requestJSon.put("password", "pistol");
        }
        catch(JsonException e)
        {
            e.printStackTrace();
        }

        request.body(requestJSon.toString());
        Response requestResponse =  request.post("https://reqres.in/api/register");
        System.out.println(requestResponse.getBody().prettyPrint());
        Assert.assertEquals(requestResponse.getStatusCode(), 201);

    }
}
