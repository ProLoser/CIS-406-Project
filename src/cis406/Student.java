package cis406;


import java.util.Date;


public class Student 
{
//attributes
	Name studName;
	String broncoNum;
	String email;
	String homeLocation;
	String gradeLevel;
	String lastCISCourse;
	String interests;
	String priorInternship;
	Boolean relocate;
	String clubs;
	String minor;
	String gradDate;
	Date updateDate;
        
	
	//constructor
	public Student()
	{
		studName=null;
		broncoNum=null;
		email=null;
		homeLocation=null;
		gradeLevel=null;
		lastCISCourse=null;
		interests=null;
		priorInternship=null;
		relocate=null;
		clubs=null;
		minor=null;
		gradDate=null;
		updateDate=null;
	}
	
	//constructor with params
	public Student(Name studName, String broncoNum, String email, String homeLocation, String gradeLevel, String lastCISCourse, String interests, String priorInternship, Boolean relocate, String clubs, String minor, String gradDate, Date updateDate)
	{
		//this.studID = studID;
		this.studName=studName;
		this.broncoNum=broncoNum;
		this.email=email;
		this.homeLocation=homeLocation;
		this.gradeLevel=gradeLevel;
		this.lastCISCourse=lastCISCourse;
		this.interests=interests;
		this.priorInternship=priorInternship;
		this.relocate=relocate;
		this.clubs=clubs;
		this.minor=minor;
		this.gradDate=gradDate;
		this.updateDate=updateDate;
	}

	//public String getStudID() {
	//	return studID;
	//}

	//public void setStudID(String studID) {
	//	this.studID = studID;
	//}

	public Name getStudName() {
		return studName;
	}

	public void setStudName(Name studName) {
		this.studName = studName;
	}

	public String getBroncoNum() {
		return broncoNum;
	}

	public void setBroncoNum(String broncoNum) {
		this.broncoNum = broncoNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHomeLocation() {
		return homeLocation;
	}

	public void setHomeLocation(String homeLocation) {
		this.homeLocation = homeLocation;
	}

	public String getGradeLevel() {
		return gradeLevel;
	}

	public void setGradeLevel(String gradeLevel) {
		this.gradeLevel = gradeLevel;
	}

	public String getLastCISCourse() {
		return lastCISCourse;
	}

	public void setLastCISCourse(String lastCISCourse) {
		this.lastCISCourse = lastCISCourse;
	}

	public String getInterests() {
		return interests;
	}

	public void setInterests(String interests) {
		this.interests = interests;
	}

	public String getPriorInternship() {
		return priorInternship;
	}

	public void setPriorInternship(String priorInternship) {
		this.priorInternship = priorInternship;
	}

	public Boolean getRelocate() {
		return relocate;
	}

	public void setRelocate(Boolean relocate) {
		this.relocate = relocate;
	}

	public String getClubs() {
		return clubs;
	}

	public void setClubs(String clubs) {
		this.clubs = clubs;
	}

	public String getMinor() {
		return minor;
	}

	public void setMinor(String minor) {
		this.minor = minor;
	}

	public String getGradDate() {
		return gradDate;
	}

	public void setGradDate(String gradDate) {
		this.gradDate = gradDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
    @Override
	public String toString() 
	{
		String classDescription = getClass().getName() + "[";
		//classDescription +="studID" + "=";
		//classDescription +=studID;
		classDescription +="Name" + "=";
		classDescription +=studName;
		classDescription +="broncoNumber" +"=";
		classDescription +=broncoNum;
		classDescription +="email" + "=";
		classDescription +=email;
		classDescription +="homeLocation" + "=";
		classDescription +="gradeLevel" + "=";
		classDescription +=gradeLevel;
		classDescription +="lastCISCourse" + "=";
		classDescription +=lastCISCourse;
		classDescription +="interests" + "=";
		classDescription +=interests;
		classDescription +="priorInternship" + "=";
		classDescription +=priorInternship;
		classDescription +="relocate" + "=";
		classDescription +=relocate;
		classDescription +="clubs" + "=";
		classDescription +=clubs;
		classDescription +="minor" + '=';
		classDescription +=minor;
		classDescription +="gradDate" + "=";
		classDescription +=gradDate;
		classDescription +="updateDate" + "=";
		classDescription +=updateDate;
		classDescription += "]";
		return classDescription;
	}
}
