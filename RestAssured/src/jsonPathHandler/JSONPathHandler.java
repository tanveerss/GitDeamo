package jsonPathHandler;

import io.restassured.path.json.JsonPath;

public class JSONPathHandler {
	public static JsonPath rawToJson(String response)
	{
		
		JsonPath  js  = new JsonPath(response);
		return js;
		
	}
}
