package PayloadFiles;

public class POJOPracticeResponsePayload {
	public  static String  responsePayload()
	{
		return "{ \"instructor\": \"RahulShetty\", \"url\": \"rahulshettycademy.com\", \"services\": \"projectSupport\", \"expertise\": \"Automation\",\r\n" + 
				"\"courses\": { \"webAutomation\": [ { \"courseTitle\": \"Selenium Webdriver Java\", \"price\": \"50\" }, { \"courseTitle\": \"Cypress\",\r\n" + 
				"\"price\": \"40\"\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"courseTitle\": \"Protractor\",\r\n" + 
				"\"price\": \"40\"\r\n" + 
				"}\r\n" + 
				"],\r\n" + 
				"\"api\": [\r\n" + 
				"{\r\n" + 
				"\"courseTitle\": \"Rest Assured Automation using Java\",\r\n" + 
				"\"price\": \"50\"\r\n" + 
				"},\r\n" + 
				"{\r\n" + 
				"\"courseTitle\": \"SoapUI Webservices testing\",\r\n" + 
				"\"price\": \"40\"\r\n" + 
				"}\r\n" + 
				"],\r\n" + 
				"\"mobile\": [\r\n" + 
				"{\r\n" + 
				"\"courseTitle\": \"Appium-Mobile Automation using Java\",\r\n" + 
				"\"price\": \"50\"\r\n" + 
				"}\r\n" + 
				"]\r\n" + 
				"},\r\n" + 
				"\"linkedIn\": \"https://www.linkedin.com/in/rahul-shetty-trainer/\"\r\n" + 
				"}";
	}
}
