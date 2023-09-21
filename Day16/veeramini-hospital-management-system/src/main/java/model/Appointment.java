package model;

import org.springframework.stereotype.Component;

@Component
public class Appointment {

    private String appointmentId;
    private String patientName;
    private String doctorName;
    private String date;
    private Prescription prescription;



}
