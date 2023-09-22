package com.veeraminiproduct.app.controller;

import controller.PrescriptionController;
import model.Prescription;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import repository.PrescriptionRepository;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class PrescriptionTestController {

    @InjectMocks
    private PrescriptionController prescriptionController;

    @Mock
    private PrescriptionRepository prescriptionRepository;

    @Mock
    private Prescription prescription;


    @Test
    public void saveprescription() {
        Prescription prescription = new Prescription();
        prescription.setPrescriptionId("pre1001");
        prescription.setAppointmentId("app999001");
        prescription.setDescription("fever");
        prescription.setDoctorName("Sandy");
        prescription.setPatientName("Latha");
        when(prescriptionRepository.save(prescription)).thenReturn(prescription);
        Prescription result =prescriptionController.saveprescription(prescription);
        assertEquals("pre1001", result.getPrescriptionId());
        assertEquals("app999001", result.getAppointmentId());
        assertEquals("fever", result.getDescription());
        assertEquals("Latha", result.getPatientName());
        assertEquals("Sandy", result.getDoctorName());
    }
    @Test
    public void getPrescriptionTest() {
        Prescription prescription = new Prescription("pre1001", "app999001", "fever", "Latha", "Sandy");
        when(prescriptionRepository.findBypatientName(anyString())).thenReturn(prescription);
        Prescription result = prescriptionController.getprescription("Latha");
        assertEquals("pre1001", result.getPrescriptionId());
        assertEquals("app999001", result.getAppointmentId());
        assertEquals("fever", result.getDescription());
        assertEquals("Latha", result.getPatientName());
        assertEquals("Sandy", result.getDoctorName());
    }



}
