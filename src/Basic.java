import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import files.Payload;
import files.ReusableMethods;


public class Basic {

	public static void main(String[] args) {
		// Validating Add Place
		//Given - all input details(parameter, header, body)
		//When - Submit Api - (resource, http method)
		//Then - Validate response
		
		// Add place ->update place with new address -> Get place to validate if new address is present in response ->

		
		// 1. Add Place
		System.out.println("add Place");
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		String response = given()
				.log().all()
				.queryParam("key", "qaclick123")
				.headers("Content-Type","application/json")
				.body(Payload.addPlace())
				.when()
				.post("/maps/api/place/add/json")
		        .then()
		        .log().all()
		        .assertThat()
		        .statusCode(200)
		        .body("scope", equalTo("APP"))
		        .header("server","Apache/2.4.52 (Ubuntu)")
		        .extract()
		        .response()
		        .asString();
		
		System.out.println(response);
		
		//2. Update place with new address
		// Retriving place id from the above response
		// converting above response which is in string format to Json
		JsonPath js = new JsonPath(response); // parsing json
		String placeId = js.getString("place_id");
		System.out.println(placeId);
		
		// updating place
		System.out.println("update Place");
String newAddress = "70 winter walk, USA";
		 given()
		 .log().all()
		 .queryParam("key", "qaclick123")
		 .header("Content-Type","application/json")
		 .body("{\r\n"
		 		+ "\"place_id\":\""+placeId+"\",\r\n"
		 		+ "\"address\":\""+newAddress+"\",\r\n"
		 		+ "\"key\":\"qaclick123\"\r\n"
		 		+ "}")
		 .when().put("/maps/api/place/update/json")
		 .then()
		 .assertThat()
		 .statusCode(200)
		 .body("msg", equalTo("Address successfully updated"));
		 
		 //3. Get address
			System.out.println("retrive Place");
			
		 String updatedAddress= given()
		 .queryParam("key", "qaclick123")
		 .queryParam("place_id", placeId )
		 .header("Content-Type","application/json")
		 .when().get("/maps/api/place/get/json")
		 .then()
		 .assertThat()
		 .statusCode(200)
		 .extract()
		 .response()
		 .asString();
		 
		 JsonPath js1 = ReusableMethods.rawToJson(updatedAddress); // parsing json
			String addressResponse = js1.getString("address");
			System.out.println(addressResponse);
			//testng assertion
			Assert.assertEquals(newAddress, addressResponse);
		 
		}

}
