Meta:

Narrative:
As a google user
I want to use google maps product
So that I can explore the places around the globe

Meta:
@maps
Scenario: Explore the places using google map
Given I navigate to google maps
When I search for <searchTerm>
Then I should be able to see the details of <searchTerm>
When I explore <amenities> with rating <rating> nearby
Then the appropriate amenities should be listed

Examples:
|searchTerm|amenities|rating|
|London eye|restaurants|4.5|
|Statue of Liberty|hotels|4.0|