/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cis406.internship;

import cis406.Database;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Dean
 */
public class StudentInternship {

    private int id = 0;
    private int studentId;
    private int internshipId;
    private Date dateSecured;
    private int courseCredit = 0;
    private Date dateAssigned;

    public StudentInternship() {
    }

    public int getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(int courseCredit) {
        this.courseCredit = courseCredit;
    }

    public String getDateAssigned() {
        if (dateAssigned == null) {
            return null;
        }
        return dateAssigned.toString();
    }

    public boolean setDateAssigned(String dateAssigned) {
        DateFormat df = new SimpleDateFormat("yyyy-M-d");
        try {
            this.dateAssigned = df.parse(dateAssigned);
            return true;
        } catch (Exception e) {
            System.out.println("Failed to convert the expiration date");
            return false;
        }
    }

    public String getDateSecured() {
        if (dateAssigned == null) {
            return null;
        }
        return dateAssigned.toString();
    }

    public boolean setDateSecured(String dateSecured) {
        DateFormat df = new SimpleDateFormat("yyyy-M-d");
        try {
            this.dateSecured = df.parse(dateSecured);
            return true;
        } catch (Exception e) {
            System.out.println("Failed to convert the expiration date");
            return false;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInternshipId() {
        return internshipId;
    }

    public void setInternshipId(int internshipId) {
        this.internshipId = internshipId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public boolean save() {
        Database db = new Database("student_internship");
        db.addField("student_id", studentId);
        db.addField("internship_id", internshipId);
        if (dateSecured != null) {
            db.addField("date_secured", dateSecured);
        }

        db.addField("course_credit", courseCredit);

        if (dateSecured != null) {
            db.addField("date_assigned", dateAssigned);
        }
        try {
            if (id == 0) {
                id = db.insert();
            } else {
                db.update(id);
            }
            return true;
        } catch (Exception e) {
            System.out.println("Failed to assign a student to the internship");
            System.out.println(e.getMessage());
            return false;
        }
    }
}
