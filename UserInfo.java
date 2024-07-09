
public class UserInfo 
{
	private String name ;
	private String userID;
	
	public UserInfo(String name)
	{
		this.name = name;
		setUserID(name);

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		setUserID(name);

	}

	public void setUserID(String name) {
		
		
		if(name != null && name.contains(" "))
		{
			String [] namepart =  name.split(" ");
			char Firstname = namepart[0].toUpperCase().charAt(0);
			String Capitalize_lastname = namepart[namepart.length- 1].substring(0,1).toUpperCase();
			String after_lastname = namepart[namepart.length- 1].substring(1);
			userID = (Firstname + Capitalize_lastname + after_lastname);
			//System.out.println(this.userID);
		}
		else	userID = "guest";
		
	}
	public String getUserID()
	{
		return userID;
	}
	public String toString()
	{
		return getUserID();
	}
}
