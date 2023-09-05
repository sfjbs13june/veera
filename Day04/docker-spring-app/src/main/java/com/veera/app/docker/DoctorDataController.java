package com.veera.app.docker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoctorDataController {

    @GetMapping("/name")
    public String getName(){
        return "Koppineedi Veera Venkata Lakshmi";
    }
    @GetMapping("/age")
    public int getAge(){
        return 25;
    }
    @GetMapping("/address")
    public String getAddress(){

        return "KPHB colony, Kukatpally, Hyderabad - 500072";
    }
    @GetMapping("/id")
    public String getId(){

        return "so2024009";
    }

}
