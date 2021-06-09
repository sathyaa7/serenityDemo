package com.google.demo.objects;

public class Language {

    String input;
    String outputLanguage;
    String output;
    String  detectedLanguage;

    public String getInput() {
        return input;
    }

    public String getOutputLanguage() {
        return outputLanguage;
    }

    public void setOutputLanguage(String outputLanguage) {
        this.outputLanguage = outputLanguage;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getDetectedLanguage() {
        return detectedLanguage;
    }

    public void setDetectedLanguage(String detectedLanguage) {
        this.detectedLanguage = detectedLanguage;
    }

    public void setInput(String input) {
        this.input = input;
    }
}
