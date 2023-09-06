package com.veera.app.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("/getstudent")
    public String getStudent(){
        return "koppineedi Veera Venkat Lakshmi";
    }

    @PutMapping("/updatestudent")
    public String updateStudent(){
        return "Updated Student Successfully!!";
    }

    @DeleteMapping("/deletestudent")
    public String deleteStudent(){
        return "Deleted Student Successfully";
    }
}
