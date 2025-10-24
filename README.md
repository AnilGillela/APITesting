BACK-END AUTOMATION TASK

Actually below endpoint is not working due to we must select one of the {"message":"'fields' query not specified","status":400}
https://restcountries.com/v3.1/all/ 
You must specify the fields you need (up to 10 fields) when calling the all endpoints, otherwise you’ll get a bad request response. Please see this issue for more information. This applies to all versions.
Hence adjusted endponts as per below scenarios - 
https://restcountries.com/v3.1/name/{name} - (Search by country name. If you want to get an exact match, use the next endpoint. It can be the common or official value)

## Scenario 1: Schema Validation
#Objective
This project validates the schema of the REST Countries API endpoint:
Ensures that the response from the API conforms to a predefined JSON schema.
Expected Output
1. Test passes if the JSON response matches the schema.
2. Any missing or mismatched field will cause the test to fail and show details in the report.

Let’s go step by step on how to do this professionally using Java + Rest Assured + TestNG — the most common and industry-standard stack for API automation.
Tech Stack:
Java 17+
Maven (for dependencies)
Rest Assured (for API testing)
TestNG or JUnit 5 (for running tests)
JSON Schema Validator (for schema validation)
Allure Report or Extent Report (for test reporting)

Example of project structure would be

Entire process - 
1. pom.xml (Dependencies)
2. Test Class Example (SchemaValidationTest.java)
3. JSON Schema Example (countries-schema.json)
4. Running the Test
5. Report Generation
   
Scenario 2: Confirmation of Countries

Since below endpoint is not working due to updated with fields - https://restcountries.com/v3.1/all/ 
Updated one is https://restcountries.com//v3.1/all/?fields=country - when I hit this endpoint the total countires are returned 250 and not 195
Objective:
Validate that https://restcountries.com/v3.1/all/ returns exactly 195 country objects in its JSON array response.

Total countries returned by API: 250

Process -
Sends a GET request to https://restcountries.com//v3.1/all/?fields=country
Extracts the response body as a JSON array
Counts how many items (countries) are present
Asserts that the count equals 195
Prints the result in the test report (and console)

Scenario - 3 # Validate Languages
When I hit this below endpoint,  SASL is not picked up only 11 languages are retuned - 
https://restcountries.com//v3.1/name/South Africa
Official Languages of South Africa:
 - Afrikaans
 - English
 - Southern Ndebele
 - Northern Sotho
 - Southern Sotho
 - Swazi
 - Tswana
 - Tsonga
 - Venda
 - Xhosa
 - Zulu


