package resources;

public enum APIResources 
{
	AddBookAPI("Addbook.php"),
	DeleteBookAPI("DeleteBook.php");

	private String resource;
	APIResources(String resource) 
	{
	   this.resource=resource;	
	}
	
	public String getResource()
	{
		return resource;
	}
	
	

}
