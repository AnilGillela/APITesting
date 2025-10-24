package Tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ConfirmationOfCountries {

	 @Test(description = "Verify that the total number of countries returned by the API is 195")
	    public void verifyTotalNumberOfCountries() {
	        // Base URL
	        RestAssured.baseURI = "https://restcountries.com";

	        // Send GET request
	        Response response =
	                given()
	                    .when()
	                        .get("/v3.1/all/?fields=country")
	                    .then()
	                        .assertThat()
	                        .statusCode(200)
	                        .extract().response();
	     // Convert response to a list and get the count of items
	        int countryCount = response.jsonPath().getList("$").size();

	        System.out.println("Total countries returned by API: " + countryCount);

	        // Assert that there are exactly 195 countries
	        Assert.assertEquals(countryCount, 195,
	                "Country count mismatch! Expected 195 but got " + countryCount);

	        System.out.println("Country count validation successful. Total: " + countryCount);
	    }
	
}
