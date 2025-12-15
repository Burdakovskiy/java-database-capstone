package com.project.back_end.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "prescriptions")
public class Prescription {

    @Id
    private String id;

    @NotBlank(message = "Patient name cannot be blank")
    @Size(min = 3, max = 100)
    private String patientName;

    @NotNull(message = "Appointment ID is required")
    private Long appointmentId;

    @NotBlank(message = "Medication cannot be blank")
    @Size(min = 3, max = 100)
    private String medication;

    @Size(max = 200, message = "Doctor notes must be <= 200 characters")
    private String doctorNotes;

    public Prescription() {}

    public String getId() { return id; }
    public String getPatientName() { return patientName; }
    public Long getAppointmentId() { return appointmentId; }
    public String getMedication() { return medication; }
    public String getDoctorNotes() { return doctorNotes; }

    public void setId(String id) { this.id = id; }
    public void setPatientName(String patientName) { this.patientName = patientName; }
    public void setAppointmentId(Long appointmentId) { this.appointmentId = appointmentId; }
    public void setMedication(String medication) { this.medication = medication; }
    public void setDoctorNotes(String doctorNotes) { this.doctorNotes = doctorNotes; }
}
