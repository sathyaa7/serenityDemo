Meta:

Narrative:
As a google user
I want to use google translator
So that I can get to see the translated strings

Meta:
@translate
Scenario: Verifying translated strings in google translator
Given I navigate to google translate
When I provide a input string
Then the detected language and translated string should be correct
