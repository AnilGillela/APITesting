package Tests;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class JSONSchemaValidator {
	@Test(description = "Validate that the API response conforms to the expected schema")
    public void validateCountriesSchema() {
        RestAssured.baseURI = "https://restcountries.com";

        given()
            .when()
                .get("/v3.1/name/India?fullText=true")
            .then()
                .assertThat()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema.json"));

        System.out.println("Schema validation passed successfully!");
    }

}
