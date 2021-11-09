package OAuth;

import static io.restassured.RestAssured.given;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import POJO.Deserialization;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;

public class test {
	
	public static void main(String[] args) throws InterruptedException
	{
		//https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php
		String url ="https://rahulshettyacademy.com/getCourse.php?code=4%2F0AX4XfWgLyVI4ZDOqMm26ZDB9D7zOOKHbRfnguW4roODtybgPXRAUg-XCxvonr_yhcuyUGQ&scope=email+openid+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&authuser=5&prompt=none";
		String partialcode=url.split("code=")[1];
		String code=partialcode.split("&scope")[0];
		System.out.println("CODE IS"+code);
		String accessTokenResponse =	given().log().all().urlEncodingEnabled(false)
				.queryParams("code",code)
				.queryParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
				.queryParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
				.queryParams("grant_type", "authorization_code")
				.queryParams("state", "verifyfjdss")
				.queryParams("session_state", "ff4a89d1f7011eb34eef8cf02ce4353316d9744b..7eb8")
				.queryParam("scope", "email+openid+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email")
				.queryParams("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
				.when().log().all().post("https://www.googleapis.com/oauth2/v4/token").asString();
		System.out.println(accessTokenResponse);
			JsonPath js =new JsonPath(accessTokenResponse);
			String access_token = js.getString("access_token");
		System.out.println(access_token);
		
		Deserialization r2=   given()
			.queryParams("access_token", access_token).expect().defaultParser(Parser.JSON)
			.when()
			.get("https://rahulshettyacademy.com/getCourse.php").as(POJO.Deserialization.class);
			
			System.out.println(r2.getLinkedIn());
			System.out.println(r2.getExpertise());
			System.out.println(r2.getInstructor());
}
}
