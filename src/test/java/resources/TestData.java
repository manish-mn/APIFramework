package resources;

import pojo.AddBook;

public class TestData 
{
	public AddBook addBookPayload(String name, String isbn,String aisle,String author)
	{
		AddBook ab=new AddBook();
		ab.setName(name);
		ab.setIsbn(isbn);
		ab.setAisle(aisle);
		ab.setAuthor(author);
		return ab;
	}
	
	public String deleteBookPayload(String ID)
	{
		
		return "{\r\n"
				+ "\r\n"
				+ "\"ID\" : \""+ID+"\"\r\n"
				+ "\r\n"
				+ "}";
	}

}
