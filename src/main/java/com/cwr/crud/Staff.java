package com.cwr.crud;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;

public class Staff {
    @NotBlank(message = "Name cannot be blank")
    private String staffName;
    @NotBlank(message = "Title cannot be blank")
    private String staffTitle;
    // @NotBlank(message = "Salary cannot be blank")
    private int staffSalary;
    private String ID;

    public Staff(String staffName, String staffTitle, int staffSalary, String ID) {
        this.staffName = staffName;
        this.staffTitle = staffTitle;
        this.staffSalary = staffSalary;
        this.ID = ID;
    }

    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        ID = iD;
    }

    public Staff() {
        this.ID = UUID.randomUUID().toString();
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffTitle() {
        return staffTitle;
    }

    public void setStaffTitle(String staffTitle) {
        this.staffTitle = staffTitle;
    }

    public int getStaffSalary() {
        return staffSalary;
    }

    public void setStaffSalary(int staffSalary) {
        this.staffSalary = staffSalary;
    }

}
