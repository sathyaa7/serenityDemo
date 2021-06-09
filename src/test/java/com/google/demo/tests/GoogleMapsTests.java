package com.google.demo.tests;

import com.google.demo.pages.GoogleMapsPages;
import net.thucydides.core.annotations.Step;

public class GoogleMapsTests {

    GoogleMapsPages googleMapsPages;

    private String requestedRating;

    @Step("Navigating to google maps")
    public void navigateToGoogleMaps() {
        googleMapsPages.navigateToGoogleMaps();
    }

    @Step("Searching for the place")
    public void searchForTerm(String searchTerm) {
        googleMapsPages.searchForTerm(searchTerm);
    }

    @Step("Verifying details of the requested place")
    public void verifyDetails(String searchTerm) {
        boolean detailsArePresent = googleMapsPages.verifyDetails(searchTerm);
    }

    @Step("Searching for amenities")
    public void searchForAmenity(String amenity, String rating) {
        requestedRating = rating;
        googleMapsPages.searchForAmenity(amenity, rating);
    }

    @Step("Verifying amenities listed")
    public void verifyAmenities() {
        googleMapsPages.verifyAmenities(requestedRating);
    }
}
