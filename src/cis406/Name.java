package cis406;



public class Name 
{
	String firstName; 
	String lastName;
	String middleInitial;
	
	//methods
	public Name()
	{
		firstName = "";
		lastName = "";
		middleInitial = "";
		
	}
	
	public Name(String lastN, String firstN, String middleN)
	{
		this.firstName = firstN;
		this.lastName = lastN;
		this.middleInitial = middleN;
	}

	@Override
	public String toString() 
	{
		String classDescription = getClass().getName() + "[";
		classDescription += "firstName" + "=";
		classDescription += firstName;
		classDescription += ", ";
		classDescription += "middleInitial" + "=";
		classDescription += middleInitial;
		classDescription += ", ";
		classDescription += "lastName" + "=";
		classDescription += lastName;
		classDescription += "]";
		return classDescription;
	}
	
	public String getFullName()
	{
		String fullName = this.firstName + " " + this.middleInitial + " " + this.lastName;
		return fullName;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleInitial() {
		return middleInitial;
	}

	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}
}


