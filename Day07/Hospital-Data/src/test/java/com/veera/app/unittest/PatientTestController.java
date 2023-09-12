package com.veera.app.unittest;

import com.veera.app.controller.PatientController;
import com.veera.app.model.Patient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@RunWith(MockitoJUnitRunner.class)
public class PatientTestController {

    @InjectMocks
    PatientController patientController =new PatientController();

    @Test
    public void test_SavePatient() {
        Patient patient = new Patient("abc", 123, "holi", "yyy");
        Patient result = patientController.Addpatient(patient);
        assertEquals("abc", result.getPatientname());
        assertEquals(123, result.getPatientid());
        assertEquals("holi", result.getHospitalname());
        assertEquals("yyy", result.getDisease());
    }

    @Test
    public void test_getPatient(){
            Patient patient=new Patient("abc",123,"holi","yyy");
            patientController.Addpatient(patient);
            Patient result=patientController.getPatient("abc");
            assertEquals("abc",result.getPatientname());
            assertEquals(123,result.getPatientid());
            assertEquals("holi",result.getHospitalname());
            assertEquals("yyy",result.getDisease());

    }

    @Test
    public void test_updatePatient() {
        Patient patient = new Patient("abc", 123, "holi", "yyy");
        patientController.Addpatient(patient);
        Patient result = patientController.updatePatient("abc", "sandhya");
        assertEquals("abc", result.getPatientname());
        assertEquals(123, result.getPatientid());
        assertEquals("sandhya", result.getHospitalname());
        assertEquals("yyy", result.getDisease());
    }

    @Test
    public void test_deletePatient() {
        Patient patient = new Patient();
        patient.setPatientname("abc");
        patient.setPatientid(123);
        patient.setPatientname("holi");
        patient.setDisease("yyy");
        patientController.Addpatient(patient);
        patientController.deletePatient("abc");
        Patient result=patientController.getPatient("abc");
        assertNull(result);
    }

}
