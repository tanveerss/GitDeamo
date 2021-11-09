

//import PayloadFiles.Jsonpractice;
import io.restassured.path.json.JsonPath;

public class PracticeJson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
   JsonPath js = new JsonPath(Jsonpractice.mockJSON());
   System.out.println(js.getInt("courses.size()"));
   int count = js.getInt("courses.size()");
   for(int i =0;i<count;i++)
   {
	   System.out.println(js.getString("courses["+i+"].title"));
	   
   }
	}

}
