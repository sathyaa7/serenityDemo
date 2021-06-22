Meta:

Narrative:
As a user
I should be able to utilize the resources in server using api


Scenario: Verifying API get call
Meta:
@API
When I hit an endpoint of API for performing GET call
Then the resources should be fetched from api successfully

Scenario: Verifying API post call
Meta:
@API
When I hit an endpoint of API for performing POST call
Then the resource should be created successfully