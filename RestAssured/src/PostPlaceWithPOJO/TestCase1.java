package PostPlaceWithPOJO;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;
public class TestCase1 {

	public static void main(String a [])
	{
		Serialization s = new Serialization();
		s.setAccuracy(50);
		s.setAddress("Jammu");
		s.setLanguage("English");
		s.setName("Tanveer");
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
		
	RestAssured.baseURI = "https://rahulshettyacademy.com";
	Response res = given().log().all().queryParam("key", "qaclick123").header("Content-type","application/json").body(s)
	.when().post("/maps/api/place/add/json")
	.then().log().all().assertThat().statusCode(200).extract().response();
	String AddPlaceResponse = res.asString();
	//System.out.println(AddPlaceResponse);
}
}
