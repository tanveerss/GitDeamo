import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class AddAPI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		given().log().all().queryParam("Key", "qaclick123").
		header("Content-Type","application/json").body(Payload.addAPI()).
		when().post("/maps/api/place/add/json").
		then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP")).
		header("Content-Type","application/json;charset=UTF-8");

	}

}
