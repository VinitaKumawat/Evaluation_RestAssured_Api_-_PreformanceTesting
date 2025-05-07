package evaluation;

import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.util.JSONPObject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.json.simple.JSONObject;



 public class HTTPRequestsActivities {
	 
	 @Test(priority=1)
	 public void getAllPosts() {
	 RestAssured.baseURI="https://fakerestapi.azurewebsites.net/";
		
		given()
        .when()
            .get("/api/v1/Activities")
        .then()
            .statusCode(200)
		
		.log().all();
	 }
	 @Test(priority = 1)
	    public void createPost() {
		 RestAssured.baseURI="https://fakerestapi.azurewebsites.net/";
	        String requestBody = """
	            {
	              "title": "vinita",
	              "dueDate": "2025-05-07T07:07:01.098Z",
	              "Id": 31
	            }
	            """;

	        RestAssured
	            .given()
	                .contentType(ContentType.JSON)
	                .body(requestBody)
	            .when()
	                .post("/api/v1/Activities")
	            .then()
	                .statusCode(201)
	                .body("title", equalTo("vinita"))
	                .body("dueDate", equalTo("2025-05-07T07:07:01.098Z"))
	                .body("Id", equalTo(31)).log().all();
	    }
	 @Test(priority = 2)
	    public void put() {
		 RestAssured.baseURI="https://fakerestapi.azurewebsites.net/";
	        String requestBody = """
	            {
	              "title": "vini",
	              "dueDate": "2025-05-07T07:07:01.098Z",
	              "Id": 0
	            }
	            """;

	        RestAssured
	            .given()
	                .contentType(ContentType.JSON)
	                .body(requestBody)
	            .when()
	                .put("/api/v1/Activities/0")
	            .then()
	                .statusCode(200)
	                .body("title", equalTo("vini"))
	                .body("dueDate", equalTo("2025-05-07T07:07:01.098Z"))
	                .body("Id", equalTo(null)).log().all();
	    }
	 @Test(priority = 3)
	    public void deletePost() {
	        RestAssured.baseURI = "https://fakerestapi.azurewebsites.net/";

	        RestAssured
	            .given()
	            .when()
	                .delete("//api/v1/Activities/1")
	            .then()
	                .statusCode(200);
	
	 }
	
	
}
