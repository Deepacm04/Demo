import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.Payload;
import files.ReusableMethods;
//sending parameters to payload from test


public class DynamicJson {
	@Test(dataProvider="BookData")
	public void addBook(String isbn, String aisle) {
		RestAssured.baseURI = "https://rahulshettyacademy.com";

		String response = given().log().all().header("Content-Type", "application/json")
				.body(Payload.AddBook(isbn, aisle)).// for multiple paramter use dataprovider annotation
		//.body(Payload.AddBook("asds", "45908")) -> for single parameter
				
		when().post("/Library/Addbook.php").
		then().log().all().assertThat().statusCode(200)
		.extract().response().asString();
		
		JsonPath js = ReusableMethods.rawToJson(response);
		//System.out.println("test " + response1);
		String Id = js.get("ID");
		System.out.println(Id);
		//deletebook
		
	}
	
	@DataProvider(name = "BookData")
	// Array - collection of elements
	// multidimensional array - collection of arrays
	public Object[][] getdata() {
		//creating and initializing the array
		return new Object[][] {{"test","56788"}, {"test233", "56900"}, {"test33", "5890"}};

}
		}
