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
restcountries-backend-automation/
│
├── src/
│   ├── main/
│   └── test/
│       ├── java/
│       │   └── tests/
│       │       └── SchemaValidationTest.java
│       └── resources/
│           └── schemas/
│               └── countries-schema.json
│
├── pom.xml
└── README.md
Entire process - 
1. pom.xml (Dependencies)
2. Test Class Example (SchemaValidationTest.java)
3. JSON Schema Example (countries-schema.json)
4. Running the Test
5. Report Generation
Scenario 2: Confirmation of Countries
