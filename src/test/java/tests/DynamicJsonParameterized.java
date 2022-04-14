package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.Payload;
import files.ReusableUtilities;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class DynamicJsonParameterized {

	@Test(dataProvider = "BooksData")
	public void addBook(String isbn, String aisle) {
		
		RestAssured.baseURI = "http://216.10.245.166";
		
		String response = given().header("Content-Type", "application/json")
		.body(Payload.addBook(isbn, aisle))
		.when()
		.post("Library/Addbook.php")
		.then()
		.assertThat().statusCode(200)
		.extract().response().asString();
	
		JsonPath js = ReusableUtilities.rawToJson(response);
		String bookId = js.getString("ID");
		System.out.println(bookId);
		
	}
	
	@DataProvider(name = "BooksData")
	public Object[][] getData(){
		
		return new Object[][] {{"0001","A"}, {"0002","B"},{"0003","C"}};
	}
}
