package com.google.demo.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GooglePage extends PageObject {
    WebDriverWait wait = new WebDriverWait(getDriver(), 15);
    Actions actions=new Actions(getDriver());
    JavascriptExecutor javascriptExecutor=(JavascriptExecutor)getDriver();

    public WebElement explicitlyWait(WebElement element) {
        WebElement searchElement = wait.until(ExpectedConditions.visibilityOf(element));
        return searchElement;
    }

    public void actionsClick(WebElement element)
    {
        actions.click(element).build().perform();
    }

    public void scrollDown(int pixels)
    {
        javascriptExecutor.executeScript("scroll(0,"+pixels+")");
    }

    public void scrollDown(WebElement element)
    {
        javascriptExecutor.executeScript("arguments[0].scrollIntoView()",element);
    }

    public void actionSendKeys(String targetString)
    {
        actions.sendKeys(targetString).sendKeys(Keys.ENTER).build().perform();
    }
}
