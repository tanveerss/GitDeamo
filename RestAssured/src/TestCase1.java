
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PayloadFiles.libraryAPIPayloads;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import jsonPathHandler.JSONPathHandler;

import static io.restassured.RestAssured.*;

public class TestCase1 {
	
@Test(dataProvider = "Addbooks")
	public void postBook(String isbn,String aisle)
	{
		RestAssured.baseURI = "http://216.10.245.166";
		Response response  = given().log().all().header("Content-Type","application/json").body(libraryAPIPayloads.addBook(isbn,aisle)).
		when().post("/Library/Addbook.php").
		then().log().all().assertThat().statusCode(200).extract().response();
		String res  = response.asString();
	    JsonPath js = 	JSONPathHandler.rawToJson(res);
	    String id = js.getString("ID");
	    System.out.println(id);
	}
@DataProvider(name="Addbooks")
public Object[][] bookDataSet()
{
	return new Object[][] {{"Tan","122"},{"Tanv","567"},{"Gourav","567"}};
}

}