package POJO;

import java.util.List;

public class Courses {

	private List<webAutomationJSONArray> webAutomation;
	private List<apiJSONArray> api;
	private List<mobileapiJSONArray> mobile;
	
	public List<webAutomationJSONArray> getWebAutomation() {
		return webAutomation;
	}
	public void setWebAutomation(List<webAutomationJSONArray> webAutomation) {
		this.webAutomation = webAutomation;
	}
	public List<apiJSONArray> getApi() {
		return api;
	}
	public void setApi(List<apiJSONArray> api) {
		this.api = api;
	}
	public List<mobileapiJSONArray> getMobile() {
		return mobile;
	}
	public void setMobile(List<mobileapiJSONArray> mobile) {
		this.mobile = mobile;
	}
	
	
}
