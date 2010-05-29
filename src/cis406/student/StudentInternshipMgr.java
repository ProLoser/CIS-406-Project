    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cis406.student;
import cis406.internship.*;
/**
 *
 * @author Oscar
 */
public class StudentInternshipMgr {
    Student aStudent = new Student();
    Internship aInternship = new Internship();

    public StudentInternshipMgr() {
        aStudent = null;
        aInternship = null;
    }

    public void assignInternship(){
        
    }

    public void assignInternship(Internship aInternship){

    }

    public void assignInternship(Student aStudent, Internship aInternship){

    }


    public Internship getaInternship() {
        return aInternship;
    }

    public void setaInternship(Internship aInternship) {
        this.aInternship = aInternship;
    }

    public Student getaStudent() {
        return aStudent;
    }

    public void setaStudent(Student aStudent) {
        this.aStudent = aStudent;
    }

}
