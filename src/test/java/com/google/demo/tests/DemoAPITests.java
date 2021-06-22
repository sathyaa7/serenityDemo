package com.google.demo.tests;

import com.google.demo.objects.Person;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import static net.serenitybdd.rest.SerenityRest.given;

public class DemoAPITests {

    private Response response;
    private Person person=new Person();

    @Step("Hitting the endpoint")
    public void hitTheEndpoint()
    {
        System.out.println(System.getProperty("baseurl"));
        response=SerenityRest.with().given().when().get(System.getProperty("baseurl"));
    }

    @Step("Fetching the resources")
    public void getResouces()
    {
        Assert.assertTrue("Verifying response code for get",response.getStatusCode()==200);
    }

    @Step("Performing post req")
    public void performPostCall()
    {
        person.setName("David");
        person.setJob("Tester");
        response=SerenityRest.with().given().contentType("Application/json").when().body(person).post(System.getProperty("baseurl"));

    }

    @Step("Verifying post req")
    public void verifyPOST()
    {
        Assert.assertTrue("Verifying response code for post",response.getStatusCode()==201);
        Person responseBody=response.as(Person.class);
        // Verifying name , job and id is created
        Assert.assertTrue("Verifying response body",(responseBody.getJob().equals(person.getJob()) &&
                responseBody.getName().equals(person.getName())&& response.getBody().jsonPath().get("key")!=null));
    }
}
