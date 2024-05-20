package com.cwr.crud;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;

// Staff Controller

@Controller
public class StaffController {

    List<Staff> allStaff = new ArrayList<>();

    // Staff Model
    @GetMapping("/")
    public String addNewStaff(Model model, @RequestParam(required = false) String id) {

        Staff myStaff = new Staff();

        int index = getStaffIndex(id);

        model.addAttribute("newStaff", index == Constants.NO_MATCH ? myStaff : allStaff.get(index));

        // Staff View
        return "addnewstaff";
    }

    private int getStaffIndex(String id) {
        for (int i = 0; i < allStaff.size(); i++) {
            if (allStaff.get(i).getID().equals(id))
                return i;
        }
        return Constants.NO_MATCH;
    }

    @PostMapping("/dataSubmitForm")
    public String dataSubmitForm(@Valid @ModelAttribute("newStaff") Staff staff, BindingResult result) {
        if (result.hasErrors())
            return "addnewstaff";

        int index = getStaffIndex(staff.getID());

        if (index == Constants.NO_MATCH) {
            allStaff.add(staff);
        } else {
            allStaff.set(index, staff);
            // arrayListName.set(index, element): Replaces the element at the specified
            // position in this list with the specified element (optional operation).
        }
        return "redirect:/getAllStaff";
    }

    @GetMapping("/getAllStaff")
    public String getAllStaff(Model model) {
        model.addAttribute("allStaff", allStaff);
        return "getallstaff";
    }

}
