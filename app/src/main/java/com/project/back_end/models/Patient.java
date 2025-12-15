package com.project.back_end.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "patients",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_patient_email", columnNames = "email")
        })
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Patient name cannot be blank")
    @Size(min = 3, max = 100)
    @Column(nullable = false, length = 100)
    private String name;

    @Email(message = "Email must be valid")
    @NotBlank(message = "Email cannot be blank")
    @Column(nullable = false, length = 255)
    private String email;

    @NotBlank(message = "Address cannot be blank")
    @Size(min = 5, max = 255)
    @Column(nullable = false, length = 255)
    private String address;

    @NotBlank(message = "Password cannot be blank")
    @Size(min = 6, max = 255)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "password_hash", nullable = false, length = 255)
    private String password;

    public Patient() {}

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getAddress() { return address; }
    public String getPassword() { return password; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setAddress(String address) { this.address = address; }
    public void setPassword(String password) { this.password = password; }
}
