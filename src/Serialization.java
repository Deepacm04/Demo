import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojo.AddPlace;
import pojo.Location;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

// creating a POJO class based on the payload json, which in turns converts POJO java object to the actual json - serialisation
// Restassured serializes from java object to json
public class Serialization {

	public static void main(String[] args) {
		// passing value to setters
		AddPlace p = new AddPlace();
		p.setAccuracy(30);
		p.setAddress("29, side layout, cohen 09");
		p.setLanguage("French-IN");
		//creating object of location class
		Location l = new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		p.setLocation(l);
		p.setName("Frontline house");
		//create object for List class, as setType is expecting the list of string object, where we are passing values through array
		List<String> myList = new ArrayList<String>();
		myList.add("test1");
		myList.add("test2");
		p.setTypes(myList);
		p.setWebsite("http://google.com");
		RestAssured.baseURI= "https://pscode.lioncloud.net/qe-specialized-program";
		Response response = given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json")
		.body(p)
		.when()
		.post("/maps/api/place/add/json")
		.then().log().all()
		.assertThat()
        .statusCode(200)
		.extract().response();
		
		System.out.println("eresult" +response);
		
		String responseString = response.asString();
		System.out.println(responseString);
		
	}

}
