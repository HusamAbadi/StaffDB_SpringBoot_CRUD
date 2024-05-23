package com.cwr.crud.repository;

import com.cwr.crud.Staff;

import java.util.ArrayList;
import java.util.List;

// Staff Repository (Data Access Layer) => StaffRepository (Data Access Layer) => StaffService (Business Logic Layer)

public class StaffRepository {
    private List<Staff> allStaff = new ArrayList<>();

    public Staff geStaffByIndex(int index) {
        return allStaff.get(index);
    }

    public void addStaff(Staff staff) {
        allStaff.add(staff);
    }

    public void updateStaff(int index, Staff staff) {
        allStaff.set(index, staff);
    }

    public List<Staff> getAllStaff() {
        return allStaff;
    }
}
