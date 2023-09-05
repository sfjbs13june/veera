package com.veera.app.veera;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

    @GetMapping("/name")
    public String  getName(){

        return "Lakshmi Koppineedi";
    }
    @GetMapping("/age")
    public int age(){

        return 25;
    }
    @GetMapping("/address")
    public String Address(){

        return "Kukatpally ,Hyderabad";
    }


}
