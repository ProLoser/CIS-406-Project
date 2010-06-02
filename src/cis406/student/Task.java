/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cis406.student;

import cis406.Database;
import cis406.TableModel;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

/**
 *
 * @author Oscar
 */
public class Task {

    //attributed
    private int id;
    private int category;
    private String name;
    private String taskTitle;
    private String description;
    private String enterDate;
    private String dueDate;
    private String completeDate;
    private int completed;

    public Task() {
        id = 0;
        category = 0;
        name = "";
        taskTitle = "";
        description = "";
        enterDate = null;
        dueDate = null;
        completeDate = null;
        completed = 0;

    }

    public Task(int recordID) {
        ResultSet data = Database.read("task", recordID);
        try {
            data.next();
            id = data.getInt("task_id");
            category = data.getInt("task_category");
            name = data.getString("t_name");
            taskTitle = data.getString("task_title");
            description = data.getString("description");
            enterDate = data.getString("start_date");
            dueDate = data.getString("due_date");
            completeDate = data.getString("complete_date");
            completed = data.getInt("completed");

        } catch (Exception e) {
            System.out.println("Failed to locate a record");
            System.out.println(e.getMessage());
        }

    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean confirm) {
        if (confirm) {
            this.completed = 1;
        } else {
            this.completed = 0;
        }
    }

    public Boolean save() {
        java.sql.Date sqlStartDate;
        java.sql.Date sqlDueDate;
        java.sql.Date sqlCompleteDate;
        Database db = new Database("task");
        db.addField("description", description);
        db.addField("start_date", enterDate);
        db.addField("due_date", dueDate);
        if (completeDate != null) {
            db.addField("complete_date", completeDate);
        }
        db.addField("task_title", taskTitle);
        db.addField("t_name", name);
        db.addField("completed", completed);
        db.addField("task_category", category);
        try {
            if (id == 0) {
                db.insert();
            } else {
                db.update(id);

            }
            return true;
        } catch (Exception e) {
            System.out.println("Failed to save the task");
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static Boolean delete(int id) {
        Boolean success = false;
        if (Database.delete("task", id) > 0) {
            success = true;
        } else {
            System.out.println("The task could not be found");
        }

        return success;
    }

    static public TableModel generateTable() {
        Database db = new Database("task");
        TableModel table = null;
        Vector<String> fields = new Vector<String>();
        fields.add("due_date AS DueDate");
        fields.add("task_title AS TaskTitle");
        fields.add("t_name AS Name");
        fields.add("task_category AS TaskCategory");
        fields.add("start_date AS StartDate");
        db.setOrderBy("due_date ASC, task_title ASC");
        try {
            // Generate the table from the query
            table = new TableModel(db.select(fields));
            table.parseData();
        } catch (Exception e) {
            System.out.println("Failed to load the task table");
            System.out.println(e.getMessage());
        }
        return table;
    }

    static public TableModel generateReportTable() {
        Database db = new Database("task");
        TableModel table = null;
        Vector<String> fields = new Vector<String>();
        fields.add("due_date AS DueDate");
        fields.add("task_title AS TaskTitle");
        fields.add("t_name AS Name");
        fields.add("task_category AS TaskCategory");
        fields.add("start_date AS StartDate");
        fields.add("description AS Description");
        fields.add("completed AS Completed");
        fields.add("complete_date As DateCompleted");
        try {
            // Generate the table from the query
            table = new TableModel(db.select(fields));
            table.parseData();
        } catch (Exception e) {
            System.out.println("Failed to load the task table");
            System.out.println(e.getMessage());
        }
        return table;
    }

    public String getCompleteDate() {
        if (completeDate != null) {
            return completeDate;
        } else {
            return null;
        }
    }

    public Boolean setCompletionDate(String completionDate) {
        this.completeDate = completionDate;
        return true;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDueDate() {
        if (dueDate != null) {
            return dueDate;
        } else {
            return null;
        }
    }

    public Boolean setDueDate(String dueDate) {

        this.dueDate = dueDate;
        return true;
    }

    public String getEnterDate() {
        if (enterDate != null) {
            return enterDate;
        } else {
            return null;
        }
    }

    public Boolean setEnterDate(String enterDate) {

        this.enterDate = enterDate;
        return true;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }
}
