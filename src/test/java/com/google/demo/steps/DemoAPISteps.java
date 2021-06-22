package com.google.demo.steps;

import com.google.demo.tests.DemoAPITests;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class DemoAPISteps {

    @Steps
    DemoAPITests demoAPITests;

    @When("I hit an endpoint of API for performing GET call")
    public void hitTheEndpoint() {
        demoAPITests
                .hitTheEndpoint();
    }

    @Then("the resources should be fetched from api successfully")
    public void getResouces() {
        demoAPITests.getResouces();
    }

    @When("I hit an endpoint of API for performing POST call")
    public void performPostCall()
    {

    }

    @Then("the resource should be created successfully")
    public void verifyPOST()
    {

    }
}
