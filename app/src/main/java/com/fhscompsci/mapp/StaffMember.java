package com.fhscompsci.mapp;

/**
 * Created by Evan on 6/8/16.
 */
public class StaffMember {
    public String firstName;
    public String lastName;
    public String phoneNumber;
    public String email;
    public String department;
    public int officeNumber;

    public StaffMember(String firstName, String lastName, String phoneNumber, String email, int officeNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.officeNumber = officeNumber;
    }

    public StaffMember(String firstName, String lastName, String phoneNumber, String email, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.department = department;
    }

    public String toString() {
        return firstName + " " + lastName + ", phone: " + phoneNumber + ", email: " + phoneNumber + ", officeNumber: " + officeNumber + ", in department: " + department;
    }
}
