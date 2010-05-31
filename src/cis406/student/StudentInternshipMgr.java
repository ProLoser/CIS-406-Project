    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cis406.student;
import cis406.Database;
import cis406.TableModel;
import cis406.internship.*;
import java.util.Vector;
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
public static TableModel generateTable() {
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
