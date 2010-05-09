package cis406;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Student {
//attributes

    String broncoNum;
    Name studName;
    String email;
    String phone;
    int gradeLevel;
    int relocate;
    Date updateDate;
    String interests;
    int clubMissa;
    int clubFast;
    int clubIwdsa;
    int clubSwift;
    int clubOther;
    String major;
    String minor;
    String gradDate;
    String lastCISCourse;

    //constructor
    public Student() {
        broncoNum = "";
        studName = null;
        email = "";
        phone = "";
        gradeLevel = 0;
        relocate = 0;
        updateDate = null;
        interests = "";
        clubMissa = 0;
        clubFast = 0;
        clubIwdsa = 0;
        clubSwift = 0;
        clubOther = 0;
        major = "";
        minor = "";
        gradDate = "";
        lastCISCourse = "";
    }

    /*constructor with params
    *
     * 17 total params
     * @param broncoNum
     * @param studName
     * @param email
     * @param phone
     * @param gradeLevel
     * @param relocate
     * @param updateDate
     * @param interests
     * @param clubMissa
     * @param clubFast
     * @param clubIwdsa
     * @param clubSwift
     * @param clubOther
     * @param major
     * @param minor
     * @param gradDate
     * @param lastCISCourse
     *
     */
    public Student(String broncoNum, Name studName, String email, String phone, int gradeLevel, int relocate, Date updateDate, String interests, int clubMissa, int clubFast, int clubIwdsa, int clubSwift, int clubOther, String major, String minor, String gradDate, String lastCISCourse) {
        //this.studID = studID;
        this.broncoNum = broncoNum;
        this.studName = studName;
        this.email = email;
        this.phone = phone;
        this.gradeLevel = gradeLevel;
        this.relocate = relocate;
        this.updateDate = updateDate;
        this.interests = interests;
        this.clubMissa = clubMissa;
        this.clubFast = clubFast;
        this.clubIwdsa = clubIwdsa;
        this.clubSwift = clubSwift;
        this.clubOther = clubOther;
        this.major = major;
        this.minor = minor;
        this.gradDate = gradDate;
        this.lastCISCourse = lastCISCourse;
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

    public int getClubFast() {
        return clubFast;
    }

    public void setClubFast(int clubFast) {
        this.clubFast = clubFast;
    }

    public int getClubIwdsa() {
        return clubIwdsa;
    }

    public void setClubIwdsa(int clubIwdsa) {
        this.clubIwdsa = clubIwdsa;
    }

    public int getClubMissa() {
        return clubMissa;
    }

    public void setClubMissa(int clubMissa) {
        this.clubMissa = clubMissa;
    }

    public int getClubOther() {
        return clubOther;
    }

    public void setClubOther(int clubOther) {
        this.clubOther = clubOther;
    }

    public int getClubSwift() {
        return clubSwift;
    }

    public void setClubSwift(int clubSwift) {
        this.clubSwift = clubSwift;
    }

    public int getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(int gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRelocate() {
        return relocate;
    }

    public void setRelocate(int relocate) {
        this.relocate = relocate;
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

    public void save(){
        Map<String, String> fields = new HashMap();
        fields.put("bronco_id", broncoNum);
        fields.put("last_name", studName.lastName);
        fields.put("first_name", studName.firstName);
        fields.put("email", email);
        fields.put("phone", phone);
        fields.put("class_standing", Integer.toString(gradeLevel));
        String now = updateDate.toString();
        fields.put("last_update", now);
        fields.put("interest", interests);
        fields.put("major", major);
        fields.put("minor", minor);
        fields.put("expected_graduation_quarter", gradDate);
        fields.put("relocate", Integer.toString(relocate));
        fields.put("missa_club", Integer.toString(clubMissa));
        fields.put("fast_club", Integer.toString(clubFast));
        fields.put("iwdsa_club", Integer.toString(clubIwdsa));
        fields.put("swift_club", Integer.toString(clubSwift));
        fields.put("other_club", Integer.toString(clubOther));
        Database.write("student", fields);
    }

    @Override
    public String toString() {
        String classDescription = getClass().getName() + "[";
        //classDescription +="studID" + "=";
        //classDescription +=studID;
        classDescription += "broncoNumber" + "=";
        classDescription += broncoNum;
        classDescription += "Name" + "=";
        classDescription += studName;
        classDescription += "email" + "=";
        classDescription += email;
        classDescription += "phone" + "=";
        classDescription += phone;
        classDescription += "gradeLevel" + "=";
        classDescription += gradeLevel;
        classDescription += "relocate" + "=";
        classDescription += relocate;
        classDescription += "updateDate" + "=";
        classDescription += updateDate;
        classDescription += "interests" + "=";
        classDescription += interests;
        classDescription += "clubMissa" + "=";
        classDescription += clubMissa;
        classDescription += "clubFast" + "=";
        classDescription += clubFast;
        classDescription += "clubIwdsa" + "=";
        classDescription += clubIwdsa;
        classDescription += "clubOther" + "=";
        classDescription += clubOther;
        classDescription += "major" + "=";
        classDescription += major;
        classDescription += "minor" + "=";
        classDescription += minor;
        classDescription += "gradDate" + "=";
        classDescription += gradDate;
        classDescription += "lastCISCourse" + "=";
        classDescription += lastCISCourse;
        classDescription += "email" + "=";
        classDescription += email;
        classDescription += "]";
        return classDescription;
    }
}
