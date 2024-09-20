import files.Payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public static void main(String[] args) {
		// Creating mock data with dummy json 
		
		JsonPath js = new JsonPath(Payload.CoursePrice());
		
		//print no of courses returned by API
		// size() is applied on array
		int count = js.getInt("courses.size()");
		System.out.println(count);
		
		// print purchase amount
		int amount = js.getInt("dashboard.purchaseAmount");
		System.out.println(amount);
		
		//print title of the first course
		String firstCourseTitle = js.getString("courses[0].title");
		System.out.println(firstCourseTitle);
		
		//print all course title and their respective prices
		for(int i = 0; i<count; i++) {
			String title = js.get("courses["+i+"].title");
			System.out.println(title);
			System.out.println( js.get("courses["+i+"].price").toString());
			
			
		}
		
		//print number of copies sold by RPA course
		System.out.println("print number of copies sold by RPA course");

		for(int i = 0; i<count; i++) {
			String title = js.get("courses["+i+"].title");
			if(title.equalsIgnoreCase("RPA")) {
				int counts = js.get("courses["+i+"].copies");
				System.out.println(counts);
				break;
			}
			
			
		}

	}

}
