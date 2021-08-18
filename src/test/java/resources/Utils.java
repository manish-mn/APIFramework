package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
/**

@author -- Manish Nair[MN]

*/
public class Utils 
{
   public static RequestSpecification req;
   public RequestSpecification requestSpecBuilder() throws IOException
   {
	   if(req==null) 
	   {
	 PrintStream stream=new PrintStream(new FileOutputStream("logs.txt"));
	 req=new RequestSpecBuilder().setBaseUri(getGlobalProperties("baseURL")).setContentType(ContentType.JSON).addFilter(RequestLoggingFilter.logRequestTo(stream))
	     .addFilter(ResponseLoggingFilter.logResponseTo(stream)).build();
	 return req;
	   }
	 return req;
   }
   
   public String getGlobalProperties(String key) throws IOException
   {
       Properties pr=new Properties();
	   FileInputStream file=new FileInputStream("C:\\Users\\nmani\\Desktop\\java\\workspace\\BooksAPIFramework\\src\\test\\java\\resources\\global.properties");
	   pr.load(file);
	   return pr.getProperty(key);
   }
   public Object getJSONValue(Response res,String key)
   {
	   String responseAsString=res.asString();
	   System.out.println(responseAsString);
	   JsonPath jp=new JsonPath(responseAsString);
	   return jp.get(key);
   }
}
