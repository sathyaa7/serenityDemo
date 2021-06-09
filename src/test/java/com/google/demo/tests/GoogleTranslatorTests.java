package com.google.demo.tests;

import com.google.demo.objects.Language;
import com.google.demo.pages.GoogleTranslatorPage;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GoogleTranslatorTests {

    GoogleTranslatorPage googleTranslatorPage;

    @Step("Navigating to google translator")
    public void navigateToGoogleTranslator()
    {
        JSONParser jsonParser=new JSONParser();
        try {
            FileReader reader = new FileReader("..//src//test//java//com//google//demo//TestData.json");
            Object object=jsonParser.parse(reader);
            System.out.println(((JSONObject)object).get("input"));
        }
        catch(FileNotFoundException exception)
        {
            exception.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        googleTranslatorPage.navigateToGoogleTranslator();
    }

    @Step("Searching for a string")
    public void searchForString()
    {
        googleTranslatorPage.searchForString("Bonjour");
    }

    @Step("Verifying detected language")
    public void verifyDetectedLanguage()
    {

    }

    @Step("Verifying translated string")
    public void verifyTranslatedString()
    {

    }
}
