package com.google.demo.steps;

import com.google.demo.tests.GoogleTranslatorTests;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class GoogleTranslatorSteps {
    @Steps
    GoogleTranslatorTests googleTranslatorTests;

    @Given("I navigate to google translate")
    public void navigateToGoogleTranslator()
    {
        googleTranslatorTests.navigateToGoogleTranslator();
    }

    @When("I provide a input String")
    public void searchForString()
    {
        googleTranslatorTests.searchForString();
    }

    @Then("the detectedLanguage should be correct")
    public void verifyDetectedLanguage()
    {
        googleTranslatorTests.verifyDetectedLanguage();
    }

    @Then("the translatedString should be correct")
    public void verifyTranslatedString()
    {
        googleTranslatorTests.verifyTranslatedString();
    }
}
