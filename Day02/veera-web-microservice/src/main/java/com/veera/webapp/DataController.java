package com.veera.webapp;

import org.springframework.web.bind.annotation.*;

@RestController
public class DataController {


     @PostMapping("/add")
     public String saveData(){
        return "Saved Successfully";
    }

    @GetMapping("/get")
    public String getData(){
        return " User Data";
    }

    @PutMapping("/Modify")
    public String AlterData(){
        return "modified Successfully";
    }

    @DeleteMapping("/delete")
    public String removeData(){
        return "removed Successfully";
    }
}
