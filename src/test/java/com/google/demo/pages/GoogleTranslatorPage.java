package com.google.demo.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;

public class GoogleTranslatorPage extends GooglePage {

    @FindBy(xpath = "//textarea")
    private WebElementFacade input;

    @FindBy(xpath = "//button[@role=\"tab\"]//span")
    private WebElementFacade detectedLanguage;

    @FindBy(className = "VIiyi")
    private WebElementFacade translatedString;

    @FindBy(xpath = "//textarea//preceding::span[@class=\"zQ0atf\"][1]")
    private WebElementFacade downArrow;

    public void navigateToGoogleTranslator()
    {
      getDriver().get("https://translate.google.co.in/");
    }

    public void searchForString(String searchString)
    {
      input.sendKeys(searchString);
    }

    public String verifyDetectedLanguage()
    {
        return detectedLanguage.getText();
    }

    public String verifyTranslatedString()
    {
   return translatedString.getText();
    }
}
