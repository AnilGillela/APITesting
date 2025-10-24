package Tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class ValidateLanguages {
	
	@Test(description = "Verify that South African Sign Language (SASL) is included among South Africa's official languages")
    public void verifySASLInSouthAfricaLanguages() {

        // Base URL
        RestAssured.baseURI = "https://restcountries.com";

        // Send GET request for South Africa
        Response response =
                given()
                    .when()
                        .get("/v3.1/name/South Africa")
                    .then()
                        .assertThat()
                        .statusCode(200)
                        .extract().response();
        
     // Extract the "languages" object from the first element in the response array
        Map<String, String> languages = response.jsonPath().getMap("[0].languages");

        System.out.println("Official Languages of South Africa:");
        for (Map.Entry<String, String> entry : languages.entrySet()) {
            System.out.println(" - " + entry.getValue());
        }

        // Check if SASL is present in the list of languages
        boolean hasSASL = languages.containsValue("South African Sign Language");

        // Print and Assert
        if (hasSASL) {
            System.out.println("SASL (South African Sign Language) is officially recognized!");
        } else {
            System.out.println("SASL (South African Sign Language) is NOT listed among official languages!");
        }

        Assert.assertTrue(hasSASL,
                "Validation failed: SASL is not found among South Africa's official languages.");
    }
        

}
