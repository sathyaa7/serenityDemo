package com.google.demo.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import java.util.List;

public class GoogleTranslatorPage extends GooglePage {

    @FindBy(xpath = "//textarea")
    private WebElementFacade input;

    @FindBy(xpath = "//button[@role=\"tab\"]//span")
    private WebElementFacade detectedLanguage;

    @FindBy(className = "VIiyi")
    private WebElementFacade translatedString;

    @FindBy(xpath = "//textarea//preceding::span[@class=\"zQ0atf\"][1]")
    private WebElementFacade downArrow;

    public void navigateToGoogleTranslator() {
        getDriver().get("https://translate.google.co.in/");
    }

    public void searchForString(String searchString, String targetLanguage) {
        input.clear();
        input.sendKeys(searchString);
        downArrow.click();
        actionSendKeys(targetLanguage);
    }

    public String verifyDetectedLanguage() {
        waitForTextToDisappear("DETECT LANGUAGE");
        return detectedLanguage.getAttribute("innerText");
    }

    public String verifyTranslatedString(String inputText) {
        return translatedString.getText();
    }
}
