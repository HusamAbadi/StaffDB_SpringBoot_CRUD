package com.cwr.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cwr.crud.Staff;
import com.cwr.crud.service.StaffService;

import javax.validation.Valid;
import org.springframework.validation.BindingResult;

// Staff Controller (Presentation Layer) => StaffService (Business Layer) => StaffRepository (Data Access Layer)

@Controller
public class StaffController {

    StaffService staffService = new StaffService();

    // Staff Model
    @GetMapping("/")
    public String addNewStaff(Model model, @RequestParam(required = false) String id) {

        model.addAttribute("newStaff", staffService.getStaffByID(id));

        // Staff View
        return "addnewstaff";
    }

    @PostMapping("/dataSubmitForm")
    public String dataSubmitForm(@Valid @ModelAttribute("newStaff") Staff staff, BindingResult result) {
        if (result.hasErrors())
            return "addnewstaff";

        staffService.submitStaff(staff);

        return "redirect:/getAllStaff";
    }

    @GetMapping("/getAllStaff")
    public String getAllStaff(Model model) {
        model.addAttribute("allStaff", staffService.getAllStaff());
        return "getallstaff";
    }
}
