package com.fhscompsci.mapp;

/**
 * Created by Evan on 6/8/16.
 */
public class StaffMember {
    public String firstName;
    public String lastName;
    public String phoneNumber;
    public String email;
    public int officeNumber;

    public StaffMember(String firstName, String lastName, String phoneNumber, String email, int officeNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.officeNumber = officeNumber;
    }

    public StaffMember(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
