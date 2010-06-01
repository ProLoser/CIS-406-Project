package cis406.student;

import java.util.Date;
import cis406.*;
import cis406.Database;
import cis406.Person;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class Student extends Person {
//attributes

    int id;
    int broncoNum;
    int gradeLevel;
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
    int gradYr;
    int gradQtr;
    String lastCISCourse;
    int graduated;

    //constructor
    public Student() {
        super(); // runs the code in the Person constructor method
        // Then you proceed to run your own modifications
        id = 0;
        broncoNum = 0;
        gradeLevel = 0;
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
        gradYr = 0;
        gradQtr = 0;
        lastCISCourse = "";
        graduated = 0;
    }

    /*constructor with params
     *
     * 18 total params
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
     * @param gradQtr
     * @param gradYr
     * @param lastCISCourse
     *
     */
    public Student(int recordID) {
        ResultSet data = Database.read("student", recordID);
        try {
            data.next();
            id = data.getInt("student_id");
            broncoNum = data.getInt("bronco_id");
            firstName = data.getString("first_name");
            lastName = data.getString("last_name");
            email = data.getString("email");
            phone = data.getString("phone");
            gradeLevel = data.getInt("class_standing");
            relocate = data.getInt("relocate");
            updateDate = data.getDate("last_update");
            interests = data.getString("interest");
            clubMissa = data.getInt("missa_club");
            clubFast = data.getInt("fast_club");
            clubIwdsa = data.getInt("iwdsa_club");
            clubSwift = data.getInt("swift_club");
            clubOther = data.getInt("other_club");
            major = data.getInt("major_id");
            minor = data.getInt("minor_id");
            gradQtr = data.getInt("expected_graduation_quarter");
            gradYr = data.getInt("expected_graduation_year");
            lastCISCourse = data.getString("last_cis_class");
            graduated = data.getInt("graduated");

        } catch (Exception e) {
            System.out.println("Failed to locate a record");
            System.out.println(e.getMessage());
        }
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

    public Boolean setBroncoNum(String broncoNum) {
        try {
            this.broncoNum = Integer.parseInt(broncoNum);
            return true;
        } catch (Exception e) {
            return false;
        }
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

    public int getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(int gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public int getMajor() {
        return major;
    }

    public void setMajor(int major) {
        this.major = major;
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

    public String getUpdateDate() {
        return updateDate.toString();
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public int getGradQtr() {
        return gradQtr;
    }

    public void setGradQtr(int gradQtr) {
        this.gradQtr = gradQtr;
    }

    public int getGradYr() {
        return gradYr;
    }

    public void setGradYr(int gradYr) {
        this.gradYr = gradYr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGraduated() {
        return graduated;
    }

    public void setGraduated(Boolean confirm) {
        if (confirm) {
            this.graduated = 1;
        } else {
            this.graduated = 0;
        }
    }

    public Boolean save() {
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
        db.addField("expected_graduation_quarter", gradQtr);
        db.addField("expected_graduation_year", gradYr);
        db.addField("last_cis_class", lastCISCourse);
        db.addField("relocate", relocate);
        db.addField("missa_club", clubMissa);
        db.addField("fast_club", clubFast);
        db.addField("iwdsa_club", clubIwdsa);
        db.addField("swift_club", clubSwift);
        db.addField("other_club", clubOther);
        db.addField("graduated", graduated);
        try {
            if (id == 0) {
                db.insert();
            } else {
                db.update(id);

            }
            return true;
        } catch (Exception e) {
            System.out.println("Failed to save the student");
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static Boolean delete(int id) {
        Boolean success = false;
        if (Database.delete("student", id) > 0) {
            success = true;
        } else {
            System.out.println("The student could not be found");
        }

        return success;
    }

    static public TableModel generateTable() {
        Database db = new Database("student");
        TableModel table = null;
        Vector<String> fields = new Vector<String>();

        // Prepare the database query to be used to populate the table
        db.innerJoin("major");
        db.innerJoin("minor");
        // Populating a map of my fields so that I can choose which columns to
        // display and what labels to display them as. Use null to not alias.
        fields.add("bronco_id AS BroncoNumber");
        fields.add("last_name AS LastName");
        fields.add("first_name as FirstName");
        fields.add("last_update AS updated");
        // Use table.fieldname when querying multiple tables joined together
        fields.add("major.major_name AS major");
        fields.add("minor.minor_name AS minor");
        //fields.put("graduated","graduated");
        try {
            // Generate the table from the query
            table = new TableModel(db.select(fields));
            table.parseData();
        } catch (Exception e) {
            System.out.println("Failed to load the student table");
            System.out.println(e.getMessage());
        }
        return table;
    }

   
}
