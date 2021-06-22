package com.google.demo.tests;

import com.google.demo.pages.GoogleTranslatorPage;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class GoogleTranslatorTests {

    GoogleTranslatorPage googleTranslatorPage;

    private JSONArray arrayOfTestData=new JSONArray();
    private Map<Integer, List<String>> testDataMap=new LinkedHashMap<>();
    //private List<String> testData=new ArrayList<>();

    @Step("Navigating to google translator")
    public void navigateToGoogleTranslator() {
        JSONParser jsonParser = new JSONParser();
        try {
            FileReader reader = new FileReader("src/test/java/com/google/demo/TestData.json");
            Object object = jsonParser.parse(reader);
            arrayOfTestData = (JSONArray) object;
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        googleTranslatorPage.navigateToGoogleTranslator();
    }

    @Step("Verifying translated strings by giving different outputs")
    public void searchForString() {
        for(int i=0;i<arrayOfTestData.size();i++){
            JSONObject test=(JSONObject)((JSONObject)arrayOfTestData.get(i)).get("Test");
            List<String> testData=new ArrayList<>();
            testData.add(test.get("Input").toString());
            testData.add(test.get("Output").toString());
            testData.add(test.get("DetectedLanguage").toString());
            testData.add(test.get("OutputLanguage").toString());
            testDataMap.put(i+1, testData);
            //testData.removeAll(testData);
        }
    }

    @Step("Verifying detected language and translated string")
    public void verifyTranslation() {

        testDataMap.forEach((key, test) ->
        {
            //Passing the input and desired output language
            googleTranslatorPage.searchForString(test.get(0), test.get(3));
            //Asserting if detected language and the translated string is correct
            String UIDetectedLanguage=googleTranslatorPage.verifyDetectedLanguage();
            String expectedDetectedLanguage=test.get(2).toString();
            System.out.println(UIDetectedLanguage+" "+expectedDetectedLanguage);
            Assert.assertTrue("Detected language is correct",UIDetectedLanguage.contains(expectedDetectedLanguage));
            System.out.println("Checking the translation");
            String UItranslatedString=googleTranslatorPage.verifyTranslatedString(test.get(0));
            String expectedTranslatedString=test.get(1).toString();
            System.out.println(UItranslatedString+" "+expectedTranslatedString);
            Assert.assertTrue("Translation is correct",UItranslatedString.equalsIgnoreCase(expectedTranslatedString));
        });
    }

}
