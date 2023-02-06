package com.example.StudentManagement.dto;

import java.util.ArrayList;

public class LearnerDTO {

    private int learnerID;
    private String firstName;
    private String lastName;
    private String email;
    private ArrayList phoneNumber;
    private boolean activeState;

    public LearnerDTO(int learnerID, String firstName, String lastName, String email, ArrayList phoneNumber, boolean activeState) {
        this.learnerID = learnerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.activeState = activeState;
    }

    public LearnerDTO(String firstName, String lastName, String email, ArrayList phoneNumber, boolean activeState) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.activeState = activeState;
    }

    public LearnerDTO() {
    }

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

    public boolean isActiveState() {
        return activeState;
    }

    public void setActiveState(boolean activeState) {
        this.activeState = activeState;
    }

    @Override
    public String toString() {
        return "LearnerDTO{" +
                "learnerID=" + learnerID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", activeState=" + activeState +
                '}';
    }
}
