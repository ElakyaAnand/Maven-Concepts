package exampleunirest;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class ApimethodsusingUniRest {




	public void getmethod() throws UnirestException
	{
		HttpResponse<JsonNode> jsonresponse=  Unirest.get("http://localhost:3000/employees").asJson();

		System.out.println("The status code is "+ jsonresponse.getStatus());
		System.out.println("The message  is "+ jsonresponse.getStatusText());
		System.out.println("The body "+ jsonresponse.getBody());

	}


	public void postmethod() throws UnirestException
	{
		HttpResponse<JsonNode> jsonresponse= 	Unirest.post("http://localhost:3000/employees").header("content-type", "application/json")
				.body("{ \"first_name\": \"Dayalan\", \"last_name\": \"Vembuli\", \"email\": \"dayalan@codingthesmartway.com\"}")
				.asJson();


		System.out.println("The status code is "+ jsonresponse.getStatus());
		System.out.println("The message  is "+ jsonresponse.getStatusText());
		System.out.println("The body "+ jsonresponse.getBody());
	}


	
	public void putmethod() throws UnirestException
	{
		HttpResponse<JsonNode> jsonresponse= 	Unirest.put("http://localhost:3000/employees/7").header("content-type", "application/json")
				.body("{ \"first_name\": \"Dayalan\", \"last_name\": \"Vembuli\", \"email\": \"dayalanvembuli@codingthesmartway.com\"}")
				.asJson();


		System.out.println("The status code is "+ jsonresponse.getStatus());
		System.out.println("The message  is "+ jsonresponse.getStatusText());
		System.out.println("The body "+ jsonresponse.getBody());
	}
	
	
	
	public void deletemethod() throws UnirestException
	{
		HttpResponse<JsonNode> jsonresponse= 	Unirest.delete("http://localhost:3000/employees/7").header("content-type", "application/json")
				.body("{ \"first_name\": \"Dayalan\", \"last_name\": \"Vembuli\", \"email\": \"dayalanvembuli@codingthesmartway.com\"}")
				.asJson();


		System.out.println("The status code is "+ jsonresponse.getStatus());
		System.out.println("The message  is "+ jsonresponse.getStatusText());
		System.out.println("The body "+ jsonresponse.getBody());
	}
	
	
	
	public static void main(String[] args) throws UnirestException {

		ApimethodsusingUniRest apiUniRest=new ApimethodsusingUniRest();
		//apiUniRest.getmethod();
		//apiUniRest.putmethod();
		//apiUniRest.putmethod();		
		apiUniRest.deletemethod();

	}

}
