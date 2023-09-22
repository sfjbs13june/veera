package com.veeraminiproduct.app.controller;

import controller.DoctorController;
import model.Appointment;
import model.Prescription;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import repository.AppointmentRepository;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DoctorTestController {

    @InjectMocks
    private DoctorController doctorController;

    @Mock
    private AppointmentRepository appointmentRepository;

    @Mock
    private Appointment appointment;

    @Mock
    private Prescription prescription;

    @Test
    public void saveAppointmentTest() {
        Prescription prescription = new Prescription();
        prescription.setPrescriptionId("pre1001");
        prescription.setAppointmentId("app999001");
        prescription.setDescription("fever");
        prescription.setDoctorName("Sandy");
        prescription.setPatientName("Latha");
        Appointment appointment=new Appointment();
        appointment.setAppointmentId("app999001");
        appointment.setPatientName("Latha");
        appointment.setDoctorName("Sandy");
        appointment.setDate("22/09/2023");
        appointment.setPrescription(prescription);
        when(appointmentRepository.save(appointment)).thenReturn(appointment);
        Appointment result = doctorController.saveAppointment(appointment);
        assertEquals("app999001",result.getAppointmentId());
        assertEquals("Latha",result.getPatientName());
        assertEquals("Sandy",result.getDoctorName());
        assertEquals("22/09/2023",result.getDate());
        assertEquals(prescription,result.getPrescription());

    }

    @Test
    public void getAppointmentTest() {

        Prescription prescription = new Prescription("pre1001", "app999001", "fever", "Latha", "Sandy");
        Appointment appointment=new Appointment("app999001","Latha","Sandy","22/09/2023",prescription);
        when(appointmentRepository.findBydoctorName(anyString())).thenReturn(appointment);
        Appointment result = doctorController.getAppointment("Sandy");
        assertEquals("app999001",result.getAppointmentId());
        assertEquals("Latha",result.getPatientName());
        assertEquals("Sandy",result.getDoctorName());
        assertEquals("22/09/2023",result.getDate());
        assertEquals(prescription,result.getPrescription());
    }
}

