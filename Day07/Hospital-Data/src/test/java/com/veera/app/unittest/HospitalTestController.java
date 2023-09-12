package com.veera.app.unittest;

import com.veera.app.controller.HospitalController;
import com.veera.app.model.Hospital;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@RunWith(MockitoJUnitRunner.class)
public class HospitalTestController {

    @InjectMocks
    HospitalController hospitalController = new HospitalController();

    @Test
    public void test_addHospital() {
        Hospital hospital = new Hospital("Lotus", "12345", "Punjagutta");
        Hospital result = hospitalController.Addhospital(hospital);
        assertEquals("Lotus", result.getHospitalname());
        assertEquals("12345", result.getHospitalid());
        assertEquals("Punjagutta", result.getAddress());

    }

    @Test
    public void test_getHospital() {
        Hospital hospital = new Hospital("Lotus", "12345", "Punjagutta");
        hospitalController.Addhospital(hospital);
        Hospital result = hospitalController.gethospital("Lotus");
        assertEquals("Lotus", result.getHospitalname());
        assertEquals("12345", result.getHospitalid());
        assertEquals("Punjagutta", result.getAddress());

    }

    @Test
    public void test_updateHospital() {
        Hospital hospital = new Hospital("Lotus", "12345", "Punjagutta");
        hospitalController.Addhospital(hospital);
        Hospital result = hospitalController.updatehospital("Lotus", "Ameerpet");
        assertEquals("Lotus", result.getHospitalname());
        assertEquals("12345", result.getHospitalid());
        assertEquals("Ameerpet", result.getAddress());

    }

    @Test
    public void test_deleteHospital() {
        Hospital hospital = new Hospital();
        hospital.setHospitalname("Lotus");
        hospital.setHospitalid("12354");
        hospital.setAddress("Punjagutta");
        hospitalController.deletehospital("Lotus");
        Hospital result = hospitalController.gethospital("Lotus");
        assertNull(result);


    }

}