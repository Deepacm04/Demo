import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.Location;
// If there are common reuest and response stpes u can use Request and Response builder
public class SpecBuilder {
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
		p.setWebsite("https://rahulshettyacademy.com");
		
		//adding common request parameters
		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
		.addQueryParam("key","qaclick123")
		.setContentType(ContentType.JSON).build();
		
		System.out.println("-------------"+req);
		
		//adding common response parameters
		ResponseSpecification resspec = new
				 ResponseSpecBuilder().expectStatusCode(200).
				 expectContentType(ContentType.JSON).build();
		 
		
		
		
		 
		 ///RestAssured.baseURI= "https://pscode.lioncloud.net/qe-specialized-program";
		 RequestSpecification res = given().spec(req) .body(p);
		 
		 System.out.println("-----------"+res);
		 
			Response response = res.when().post("/maps/api/place/add/json")
					.then().log().all().spec(resspec).extract().response();
			

String responseString = response.asString();
		 
		 
		 
		 
		  System.out.println(responseString);
		 
		
	}
	

}
