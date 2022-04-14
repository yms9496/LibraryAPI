 package files;

public class Payload {

	public static String addBook(String aisle, String isbn) {
		
		return "{\r\n"
				+ "\"name\":\"Learn API Automation with PostName\",\r\n"
				+ "\"isbn\":\""+isbn+"\",\r\n"
				+ "\"aisle\":\""+aisle+"\",\r\n"
				+ "\"author\":\"PG Bhia\"\r\n"
				+ "}";
	}
}
