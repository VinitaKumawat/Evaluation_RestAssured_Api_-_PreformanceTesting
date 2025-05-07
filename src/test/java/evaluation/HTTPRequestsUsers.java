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



 public class HTTPRequestsUsers {
	 
	 @Test(priority=0)
	 public void getAllPosts() {
	 RestAssured.baseURI="https://fakerestapi.azurewebsites.net/";
		
		given()
        .when()
            .get("/api/v1/Users")
        .then()
            .statusCode(200)
		
		.log().all();
	 }
	 @Test(priority=1)
	 public void getid() {
	 RestAssured.baseURI="https://fakerestapi.azurewebsites.net/";
		
		given()
        .when()
            .get("/api/v1/Users/3")
        .then()
            .statusCode(200)
		
		.log().all();
	 }
	 
	 @Test(priority = 2)
	    public void createPost() {
		 RestAssured.baseURI="https://fakerestapi.azurewebsites.net/";
	        String requestBody = """
	         
  {
  "id": 0,
  "userName": "string",
  "password": "string"
}

	            """;

	        RestAssured
	            .given()
	                .contentType(ContentType.JSON)
	                .body(requestBody)
	            .when()
	                .post("/api/v1/Users")
	            .then()
	                .statusCode(201)
	                .body("password", equalTo("string"))
	                .body("userName", equalTo("string"))
	                .body("Id", equalTo(0)).log().all();
	    }
	 @Test(priority = 2)
	    public void put() {
		 RestAssured.baseURI="https://fakerestapi.azurewebsites.net/";
	        String requestBody = """
	            {
	            "id": 0,
  "userName": "vinita",
  "password": "vini123"
	            }
	            """;

	        RestAssured
	            .given()
	                .contentType(ContentType.JSON)
	                .body(requestBody)
	            .when()
	                .put("/api/v1/Users/7")
	            .then()
	                .statusCode(200)
	                .body("password", equalTo("vini123"))
	                .body("userName", equalTo("vinita"))
	                .body("Id", equalTo(null)).log().all();
	    }
	 @Test(priority = 3)
	    public void deletePost() {
	        RestAssured.baseURI = "https://fakerestapi.azurewebsites.net/";

	        RestAssured
	            .given()
	            .when()
	                .delete("/api/v1/Users/8")
	            .then()
	                .statusCode(200);
	
	 }
	
	
}
