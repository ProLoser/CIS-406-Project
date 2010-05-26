package cis406.student;

import java.util.Date;
import cis406.*;
import cis406.Database;
import cis406.Person;

public class Student extends Person {
//attributes

    int broncoNum;
    String gradeLevel;
    int relocate;
    Date updateDate;
    String interests;
    int clubMissa;
    int clubFast;
    int clubIwdsa;
    int clubSwift;
    int clubOther;
    int major;
    int minor;
    String gradDate;
    String lastCISCourse;

    //constructor
    public Student() {
        super(); // runs the code in the Person constructor method
        // Then you proceed to run your own modifications
        broncoNum = 0;
        gradeLevel = "";
        relocate = 0;
        updateDate = null;
        interests = "";
        clubMissa = 0;
        clubFast = 0;
        clubIwdsa = 0;
        clubSwift = 0;
        clubOther = 0;
        major = 0;
        minor = 0;
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
    public Student(int broncoNum, String firstName, String lastName, String middleInitial, String email, String phone, String gradeLevel, int relocate, Date updateDate, String interests, int clubMissa, int clubFast, int clubIwdsa, int clubSwift, int clubOther, int major, int minor, String gradDate, String lastCISCourse) {
        super(firstName, lastName, middleInitial, email, phone);
        //this.studID = studID;
        this.broncoNum = broncoNum;
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

    public int getBroncoNum() {
        return broncoNum;
    }

    public void setBroncoNum(int broncoNum) {
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

    public void setClubFast(Boolean confirm) {
        if (confirm) {
            this.clubFast = 1;
        } else {
            this.clubFast = 0;
        }
     }

    public int getClubIwdsa() {
        return clubIwdsa;
    }

    public void setClubIwdsa(Boolean confirm) {
        if (confirm) {
            this.clubIwdsa = 1;
        } else {
            this.clubIwdsa = 0;
        }
    }

    public int getClubMissa() {
        return clubMissa;
    }

    public void setClubMissa(Boolean confirm) {
        if (confirm) {
            this.clubMissa = 1;
        } else {
            this.clubMissa = 0;
        }
    }

    public int getClubOther() {
        return clubOther;
    }

    public void setClubOther(Boolean confirm) {
        if (confirm) {
            this.clubOther = 1;
        } else {
            this.clubOther = 0;
        }
    }

    public int getClubSwift() {
        return clubSwift;
    }

    public void setClubSwift(Boolean confirm) {
        if (confirm) {
            this.clubSwift = 1;
        } else {
            this.clubSwift = 0;
        }
    }

    public String getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(String gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public int getMajor() {
        return major;
    }

    public void setMajor(int major) {
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

    public void setRelocate(Boolean confirm) {
        if (confirm) {
            this.relocate = 1;
        } else {
            this.relocate = 0;
        } 
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

    public int getMinor() {
        return minor;
    }

    public void setMinor(int minor) {
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
        java.sql.Date sqlDate;
        Database db = new Database("student");
        db.addField("bronco_id", broncoNum);
        db.addField("last_name", lastName);
        db.addField("first_name", firstName);
        db.addField("email", email);
        db.addField("phone", phone);
        db.addField("class_standing", gradeLevel);

        sqlDate = new java.sql.Date(updateDate.getTime());
        db.addField("last_update", sqlDate);
        db.addField("interest", interests);
        db.addField("major_id", major);
        db.addField("minor_id", minor);
        db.addField("expected_graduation_quarter", gradDate);
        db.addField("relocate", relocate);
        db.addField("missa_club", clubMissa);
        db.addField("fast_club", clubFast);
        db.addField("iwdsa_club", clubIwdsa);
        db.addField("swift_club", clubSwift);
        db.addField("other_club", clubOther);
        try {
            db.insert();
        } catch (Exception e) {
            System.out.println("Failed to save the student");
            e.printStackTrace();
        }
        //String sqlStr = "INSERT INTO student (swift_club, other_club, phone, minor, relocate, missa_club, bronco_id, first_name, last_update, email, interest, last_name, expected_graduation_quarter, iwdsa_club, fast_club, class_standing, major) VALUES (clubSwift, clubOther, phone, minor, relocate, clubMissa, broncoNum, firstName, updateDate, email, interests, lastName, gradDate, clubIwdsa, clubFast, gradeLevel, major)";
        //Database.executeWrite( sqlStr);
    }

    @Override
    public String toString() {
        String classDescription = getClass().getName() + "[";
        //classDescription +="studID" + "=";
        //classDescription +=studID;
        classDescription += "broncoNumber" + "=";
        classDescription += broncoNum;
        classDescription += "Name" + "=";
        classDescription += getFullName();
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
