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



 public class HTTPRequestsAuthors {
	 
	 @Test(priority=0)
	 public void getAllPosts() {
	 RestAssured.baseURI="https://fakerestapi.azurewebsites.net/";
		
		given()
        .when()
            .get("/api/v1/Authors")
        .then()
            .statusCode(200)
		
		.log().all();
	 }
	 @Test(priority=1)
	 public void getid() {
	 RestAssured.baseURI="https://fakerestapi.azurewebsites.net/";
		
		given()
        .when()
            .get("/api/v1/Authors/authors/books/0")
        .then()
            .statusCode(200)
		
		.log().all();
	 }
	 @Test(priority=1)
	 public void getAuthors() {
	 RestAssured.baseURI="https://fakerestapi.azurewebsites.net/";
		
		given()
        .when()
            .get("/api/v1/Authors/441")
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
  "idBook": 0,
  "firstName": "string",
  "lastName": "string"
}
	            """;

	        RestAssured
	            .given()
	                .contentType(ContentType.JSON)
	                .body(requestBody)
	            .when()
	                .post("/api/v1/Authors")
	            .then()
	                .statusCode(201)
	                .body("firstName", equalTo("string"))
	                .body("lastName", equalTo("string"))
	                .body("Id", equalTo(0)).log().all();
	    }
	 @Test(priority = 2)
	    public void put() {
		 RestAssured.baseURI="https://fakerestapi.azurewebsites.net/";
	        String requestBody = """
	            {
	               "id": 0,
  "idBook": 0,
  "firstName": "vinita",
  "lastName": "kumawat"
	            }
	            """;

	        RestAssured
	            .given()
	                .contentType(ContentType.JSON)
	                .body(requestBody)
	            .when()
	                .put("/api/v1/Authors/0")
	            .then()
	                .statusCode(200)
	                .body("firstName", equalTo("vinita"))
	                .body("lastName", equalTo("kumawat"))
	                .body("Id",equalTo(null)).log().all();
	    }
	 @Test(priority = 3)
	    public void deletePost() {
	        RestAssured.baseURI = "https://fakerestapi.azurewebsites.net/";

	        RestAssured
	            .given()
	            .when()
	                .delete("/api/v1/Authors/440")
	            .then()
	                .statusCode(200);
	
	 }
	
	
}
