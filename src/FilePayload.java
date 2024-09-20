

	import io.restassured.RestAssured;
	import io.restassured.path.json.JsonPath;
	import io.restassured.response.ValidatableResponse;

	import static io.restassured.RestAssured.*;
	import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;

	import files.Payload;
	import files.ReusableMethods;


	public class FilePayload {
		public static void main(String[] args) throws IOException {
			// passing payload json through the external file and body() accepts only string format
			// To convert the content of the file to string, need to follow below steps
			// 1. Read the content of the file nd convert into bytes
			// 2. Covert byte data to string
			System.out.println("add Place");
			RestAssured.baseURI="https://rahulshettyacademy.com";
			
			String response = given()
					.log().all()
					.queryParam("key", "qaclick123")
					.header("Content-Type","application/json")
					.body(new String(Files.readAllBytes(Paths.get("C:\\Users\\deecm\\Desktop\\addplace.json"))))
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
			
			System.out.println("Result" + response);
			
		}
	}


