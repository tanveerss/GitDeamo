package builders;

import java.util.ArrayList;
import java.util.List;
import io.restassured.response.Response;
import PostPlaceWithPOJO.Serialization;
import PostPlaceWithPOJO.location;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.*;
public class TestCaseWithBuilders {

	public static void main(String []a)
	{
		Serialization s = new Serialization();
		s.setAccuracy(50);
		s.setAddress("Jammu");
		s.setLanguage("English");
		s.setName("Gourav");
		s.setWebsite("Tanveer@asda");
		location loc =new location();
		loc.setLat(255.455);
		loc.setLng(122.45);
		s.setLocation(loc);
		s.setPhone_number("91 56200 565 5555");
		List<String> l = new ArrayList<String>();
		l.add("Shoe");
		l.add("gherkins");
		s.setTypes(l);
		 
		RequestSpecification reqspec = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123").setContentType(ContentType.JSON).build();
		ResponseSpecification resspec  = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	
		RequestSpecification request  = given().log().all().spec(reqspec).body(s);
		Response response  = request.when().post("/maps/api/place/add/json")
		.then().log().all().spec(resspec).extract().response();
	
	}
}
