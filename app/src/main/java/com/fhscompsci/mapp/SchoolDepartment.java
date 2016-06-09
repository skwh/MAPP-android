package com.fhscompsci.mapp;

import java.util.ArrayList;

/**
 * Created by Evan on 6/8/16.
 */
public class SchoolDepartment {
    public String departmentName;
    public ArrayList<StaffMember> members;

    public SchoolDepartment(String departmentName, ArrayList<StaffMember> members) {
        this.departmentName = departmentName;
        this.members = members;
    }

    public void addMember(StaffMember member) {
        this.members.add(member);
    }

    public void removeMember(StaffMember member) {
        this.members.remove(member);
    }

    public StaffMember getMember(int index) {
        return this.members.get(index);
    }
}
