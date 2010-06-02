    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cis406.student;

import cis406.Database;
import cis406.TableModel;
import cis406.internship.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

/**
 *
 * @author Oscar
 */
public class StudentInternshipMgr {

    private int id;
    private Student assignedStudent = new Student();
    private Internship assignedInternship = new Internship();
    private String assignDate;
    private String dateSecured;
    private int forCredit;


    /*This class allows to assign a student to an internship through
     * a dialog window from either the Student Edit Panel or through
     * the Internship Panel.  From the student panel, a student object
     * is passed to a dialog
     *
     *
     */
    public StudentInternshipMgr() {
        assignedStudent = null;
        assignedInternship = null;
        id = 0;
        assignDate = null;
        dateSecured = null;
        forCredit = 0;
    }

    public static TableModel generateInternshipTable() {
        Database db = new Database("internship");
        TableModel table = null;
        Vector<String> fields = new Vector<String>();

        // Prepare the database query to be used to populate the table
        db.innerJoin("company");
        db.innerJoin("career_path");
        // Populating a map of my fields so that I can choose which columns to
        // display and what labels to display them as.
        fields.add("title");
        fields.add("post_date AS posted");
        fields.add("expiration AS expires");
        fields.add("quantity AS positions");
        // Use table.fieldname when querying multiple tables joined together
        fields.add("career_path.name AS career_path");
        fields.add("company.name AS company");
        try {
            // Generate the table from the query
            table = new TableModel(db.select(fields));
            table.parseData();
        } catch (Exception e) {
            System.out.println("Failed to load the internship table");
            System.out.println(e.getMessage());
        }
        return table;
    }

    public String getAssignDate() {
        if (assignDate != null) {
            return (assignDate);
        } else {
            return null;
        }
    }

    public Boolean setAssignDate(String assignDate) {

        this.assignDate = (assignDate);
        return true;

    }

    public int getForCredit() {
        return forCredit;
    }

    public void setForCredit(Boolean forCredit) {
        if (forCredit) {
            this.forCredit = 1;
        } else {
            this.forCredit = 0;
        }
    }

    public String getDateSecured() {
        if (dateSecured != null) {
            return (dateSecured);
        } else {
            return null;
        }
    }

    public Boolean setDateSecured(String dateSecured) {

        this.dateSecured = (dateSecured);
        return true;

    }

    public Boolean assignInternship() {
        java.sql.Date sqlAssignDate;
        java.sql.Date sqlSecuredDate;
        Database db = new Database("student_internship");
        db.addField("course_credit", forCredit);
        db.addField("student_id", assignedStudent.getId());
        db.addField("internship_id", assignedInternship.getId());
        db.addField("date_secured", dateSecured);
        db.addField("date_assigned", assignDate);
        try {
            if (id == 0) {
                db.insert();
            } else {
                db.update(id);

            }
            return true;
        } catch (Exception e) {
            System.out.println("Failed to save the student-internship assignment");
            System.out.println(e.getMessage());
            return false;
        }
    }

    static public TableModel generateStudentTable() {
        Database db = new Database("student");
        TableModel table = null;
        Vector<String> fields = new Vector<String>();

        // Prepare the database query to be used to populate the table
        db.innerJoin("major");
        db.innerJoin("minor");
        // Populating a map of my fields so that I can choose which columns to
        // display and what labels to display them as. Use null to not alias.
        fields.add("last_name AS LastName");
        fields.add("first_name as FirstName");
        fields.add("student_id AS StudentID");
        fields.add("last_update AS updated");
        // Use table.fieldname when querying multiple tables joined together
        fields.add("major.major_name AS major");
        fields.add("minor.minor_name AS minor");
        db.setOrderBy("last_name ASC");
        fields.add("graduated AS Graduated");
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /*public void assignInternship(Internship aInternship){

    }

    public void assignInternship(Student aStudent, Internship aInternship){

    }

     */
    public Internship getaInternship() {
        return assignedInternship;
    }

    public void setAssignedInternship(Internship aInternship) {
        this.assignedInternship = aInternship;
    }

    public Student getAssignedStudent() {
        return assignedStudent;
    }

    public void setAssignedStudent(Student aStudent) {
        this.assignedStudent = aStudent;
    }
}
