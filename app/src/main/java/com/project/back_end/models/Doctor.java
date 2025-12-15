package com.project.back_end.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "doctors",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_doctor_email", columnNames = "email")
        })
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Doctor name cannot be blank")
    @Size(min = 3, max = 100, message = "Name must be 3-100 characters")
    @Column(nullable = false, length = 100)
    private String name;

    @NotBlank(message = "Specialty cannot be blank")
    @Size(min = 3, max = 50, message = "Specialty must be 3-50 characters")
    @Column(nullable = false, length = 50)
    private String specialty;

    @Email(message = "Email must be valid")
    @NotBlank(message = "Email cannot be blank")
    @Column(nullable = false, length = 255)
    private String email;

    @NotBlank(message = "Password cannot be blank")
    @Size(min = 6, max = 255)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "password_hash", nullable = false, length = 255)
    private String password;

    @Pattern(regexp = "^[0-9+\\-() ]{7,20}$", message = "Phone number format is invalid")
    @Column(length = 30)
    private String phone;

    @ElementCollection
    @CollectionTable(
            name = "doctor_available_times",
            joinColumns = @JoinColumn(name = "doctor_id")
    )
    @Column(name = "available_time", nullable = false, length = 30)
    private List<String> availableTimes = new ArrayList<>();

    public Doctor() {}

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getSpecialty() { return specialty; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getPhone() { return phone; }
    public List<String> getAvailableTimes() { return availableTimes; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setSpecialty(String specialty) { this.specialty = specialty; }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setAvailableTimes(List<String> availableTimes) { this.availableTimes = availableTimes; }
}
