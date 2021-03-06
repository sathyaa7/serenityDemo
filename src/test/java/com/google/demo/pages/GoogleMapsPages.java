package com.google.demo.pages;


import org.openqa.selenium.By;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.stream.Collectors;

import net.serenitybdd.core.annotations.findby.FindBy;

import org.openqa.selenium.WebElement;

import java.util.List;

public class GoogleMapsPages extends GooglePage {

    @FindBy(name = "q")
    private WebElementFacade searchField;

    @FindBy(xpath = "//div[@id=\"pane\"]//button[contains(@aria-label,\"Phone\")]")
    private WebElementFacade phoneNumber;

    @FindBy(xpath = "//div[@id=\"pane\"]//button[contains(@aria-label,\"nearby\")]")
    private WebElementFacade nearBy;

    @FindBy(xpath = "//span[contains(text(),\"Restaurants\")]")
    private WebElementFacade restaurants;

    @FindBy(xpath = "//span[contains(text(),\"Hotels\")]")
    private WebElementFacade hotels;

    @FindBy(xpath = "//span[text()=\"Rating\"]")
    private WebElementFacade restaurantRating;

    @FindBy(xpath = "//span[text()=\"Guest rating\"]")
    private WebElementFacade guestRating;

    @FindBy(xpath = "//span[contains(@aria-label,\"star\")]//span[1]")
    private List<WebElementFacade> amenitiesResult;

    public void navigateToGoogleMaps() {
        getDriver().get("https://www.google.nl/maps");
    }

    public void searchForTerm(String searchTerm) {
        searchField.typeAndEnter(searchTerm);
    }

    public boolean verifyDetails(String searchTerm) {
        boolean correctDetails = false;
        scrollDown(200);
        WebElement contactNumber = explicitlyWait(phoneNumber);
        //Hardcoded values can be replaced if we fetch the values from Google maps api
        switch (searchTerm) {
            case "London eye":
                correctDetails = contactNumber.getText().replaceAll(" ", "").equals("+442079678021");
                break;
            case "Statue of Liberty":
                correctDetails = contactNumber.getText().equals("+12123633200");
                break;
            default:
                System.out.println("Location not available for checking");
        }
        return correctDetails;
    }

    public void searchForAmenity(String amenity, String rating) {
        nearBy.click();
        amenity = amenity.toUpperCase();

        switch (amenity) {
            case "RESTAURANTS":
                explicitlyWait(restaurants).click();
                restaurantRating.click();
                break;
            case "HOTELS":
                explicitlyWait(hotels).click();
                guestRating.click();
                break;
        }
        actionsClick(explicitlyWait(getDriver().findElement(By.xpath("//span[text()=\'" + rating + "\']"))));
    }

    public boolean verifyAmenities(String ratingRequested) {
        boolean detailsAreCorrect = true;
        List<String> ratings = amenitiesResult.stream().map(amenity -> amenity.getText()).collect(Collectors.toList());
        for (String listedRating : ratings) {
            if (Double.valueOf(listedRating) < Double.valueOf(ratingRequested)) {
                detailsAreCorrect = false;
                break;
            }
        }
        return detailsAreCorrect;
    }
}