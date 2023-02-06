package com.example.StudentManagement.dto.Request;

import java.util.ArrayList;

public class LearnerUpdateDTO {

    private int learnerID;
    private String firstName;
    private String lastName;
    private String email;
    private ArrayList phoneNumber;

    public int getLearnerID() {
        return learnerID;
    }

    public void setLearnerID(int learnerID) {
        this.learnerID = learnerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(ArrayList phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LearnerUpdateDTO(int learnerID, String firstName, String lastName, String email, ArrayList phoneNumber) {
        this.learnerID = learnerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public LearnerUpdateDTO(String firstName, String lastName, String email, ArrayList phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public LearnerUpdateDTO() {
    }

    @Override
    public String toString() {
        return "LearnerUpdateDTO{" +
                "learnerID=" + learnerID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
