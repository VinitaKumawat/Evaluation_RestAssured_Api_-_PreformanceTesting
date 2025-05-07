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



 public class HTTPRequestsCoverPhotos {
	 
	 @Test(priority=0)
	 public void getAllPosts() {
	 RestAssured.baseURI="https://fakerestapi.azurewebsites.net/";
		
		given()
        .when()
            .get("/api/v1/CoverPhotos")
        .then()
            .statusCode(200)
		
		.log().all();
	 }
	 @Test(priority=1)
	 public void getid() {
	 RestAssured.baseURI="https://fakerestapi.azurewebsites.net/";
		
		given()
        .when()
            .get("/api/v1/CoverPhotos/books/covers/169")
        .then()
            .statusCode(200)
		
		.log().all();
	 }
	 @Test(priority=1)
	 public void getCoverPhoto() {
	 RestAssured.baseURI="https://fakerestapi.azurewebsites.net/";
		
		given()
        .when()
            .get("/api/v1/CoverPhotos/169")
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
    "url": "string"
  }

	            """;

	        RestAssured
	            .given()
	                .contentType(ContentType.JSON)
	                .body(requestBody)
	            .when()
	                .post("/api/v1/CoverPhotos")
	            .then()
	                .statusCode(201)
	                .body("IdBook", equalTo(0))
	                .body("url", equalTo("string"))
	                .body("Id", equalTo(0)).log().all();
	    }
	 @Test(priority = 2)
	    public void put() {
		 RestAssured.baseURI="https://fakerestapi.azurewebsites.net/";
	        String requestBody = """
	            {
	               "id": 0,
    "idBook": 0,
    "url": "vinita"
	            }
	            """;

	        RestAssured
	            .given()
	                .contentType(ContentType.JSON)
	                .body(requestBody)
	            .when()
	                .put("//api/v1/CoverPhotos/169")
	            .then()
	                .statusCode(200)
	                .body("IdBook", equalTo(null))
	                .body("url", equalTo("vinita"))
	                .body("Id", equalTo(null)).log().all();
	    }
	 @Test(priority = 3)
	    public void deletePost() {
	        RestAssured.baseURI = "https://fakerestapi.azurewebsites.net/";

	        RestAssured
	            .given()
	            .when()
	                .delete("/api/v1/CoverPhotos/168")
	            .then()
	                .statusCode(200);
	
	 }
	
	
}
