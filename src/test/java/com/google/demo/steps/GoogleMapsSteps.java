package com.google.demo.steps;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.google.demo.tests.GoogleMapsTests;

public class GoogleMapsSteps {

    @Steps
    GoogleMapsTests googleMapsTest;

    @Given("I navigate to google maps")
    public void navigateToGoogleMaps() {
        googleMapsTest.navigateToGoogleMaps();
    }

    @When("I search for $searchTerm")
    public void searchForTerm(String searchTerm) {
        googleMapsTest.searchForTerm(searchTerm);
    }

    @Then("I should be able to see the details of $searchTerm")
    public void verifyDetails(String searchTerm) {
        googleMapsTest.verifyDetails(searchTerm);
    }

    @When("I explore $amenities with rating $rating nearby")
    public void searchForAmenity(String amenity,String rating)
    {
        googleMapsTest.searchForAmenity(amenity,rating);
    }

    @Then("the appropriate amenities should be listed")
    public void verifyAmenities()
    {
        googleMapsTest.verifyAmenities();
    }
}
