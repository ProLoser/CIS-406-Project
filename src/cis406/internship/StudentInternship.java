/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cis406.internship;

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
    private int courseCredit;
    private Date dateAssigned;

    public StudentInternship() {
    }

    public int getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(int courseCredit) {
        this.courseCredit = courseCredit;
    }

    public Date getDateAssigned() {
        return dateAssigned;
    }

    public void setDateAssigned(Date dateAssigned) {
        this.dateAssigned = dateAssigned;
    }

    public Date getDateSecured() {
        return dateSecured;
    }

    public void setDateSecured(Date dateSecured) {
        this.dateSecured = dateSecured;
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
        return false;
    }
}
