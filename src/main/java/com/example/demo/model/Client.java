package com.example.demo.model;

import java.time.LocalDateTime;

public class Client {

    private Integer id;
    private String firstName;
    private String lastName;
    private String gmail;
    private LocalDateTime registrationDate;

    public Client() {
    }

    public Client(Integer id, String firstName, String lastName, String gmail, LocalDateTime registrationDate ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gmail = gmail;
        this.registrationDate = registrationDate;
    }


    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getGmail() { return gmail; }
    public void setGmail(String gmail) { this.gmail = gmail; }

    public LocalDateTime getRegistrationDate() { return registrationDate; }
    public void setRegistrationDate(LocalDateTime registrationDate) { this.registrationDate = registrationDate; }

}