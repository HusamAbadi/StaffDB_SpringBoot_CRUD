package com.cwr.crud.service;

import com.cwr.crud.Constants;
import com.cwr.crud.Staff;
import com.cwr.crud.repository.StaffRepository;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

// Staff Service (Business Logic Layer)
@Service
public class StaffService {

    @Autowired
    StaffRepository staffRepository;

    public Staff geStaffByIndex(int index) {
        return staffRepository.geStaffByIndex(index);
    }

    public Staff getStaffByID(String id) {
        int index = getStaffIndex(id);
        return index == Constants.NO_MATCH ? new Staff() : geStaffByIndex(index);
    }

    public void addStaff(Staff staff) {
        staffRepository.addStaff(staff);
    }

    public void updateStaff(int index, Staff staff) {
        staffRepository.updateStaff(index, staff);
    }

    public List<Staff> getAllStaff() {
        return staffRepository.getAllStaff();
    }

    public int getStaffIndex(String id) {
        for (int i = 0; i < getAllStaff().size(); i++) {
            if (geStaffByIndex(i).getID().equals(id))
                return i;
        }
        return Constants.NO_MATCH;
    }

    public void submitStaff(Staff staff) {
        if (getStaffIndex(staff.getID()) == Constants.NO_MATCH)
            addStaff(staff);
        else
            updateStaff(getStaffIndex(staff.getID()), staff);
    }
}
