/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cis406;

/**
 *
 * @author Dean Sofer
 */
public class Person {

    public String firstName;
    public String lastName;
    public String middleInitial;
    public String email;
    public String phone;

    public Person() {
        this.firstName = "";
        this.lastName = "";
        this.middleInitial = "";
        this.email = "";
        this.phone = "";
    }

    public Person(String firstName, String lastName, String middleInitial, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleInitial = middleInitial;
        this.email = email;
        this.phone = phone;
    }

    public String getFullName() {
        // Since there are no passed params, you don't need this.var to tell the difference
        // although it doesn't hurt to add anyways.
        String fullName = firstName + " " + middleInitial + " " + lastName;
        return fullName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        // the only time you use this.var is when there are 2 variables with the same name
        // 1 variable being passed in the params, and the other being a class attribute
        // this.var refers to the class attribute, and without it refers to the passed param
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


}
