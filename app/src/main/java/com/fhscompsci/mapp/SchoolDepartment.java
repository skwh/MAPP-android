package com.fhscompsci.mapp;

import java.util.ArrayList;

/**
 * Created by Evan on 6/8/16.
 */
public class SchoolDepartment {
    public String name;
    public ArrayList<StaffMember> members = new ArrayList<>();

    public SchoolDepartment(String departmentName, ArrayList<StaffMember> members) {
        this.name = departmentName;
        this.members = members;
    }

    public SchoolDepartment(String name) {
        this.name = name;
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

    public String toString() {
        return name + ", with " + members.size() + " members";
    }
}
