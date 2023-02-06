package com.example.StudentManagement.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.ArrayList;

@Table(name = "learner")
@Entity
@TypeDefs({
        @TypeDef(name = "json", typeClass =  JsonType.class)
})
public class Learner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "learner_id",length = 45,unique = true)
    private int learnerID;

    @Column(name = "first_name",length = 100,nullable = false)
    private String firstName;

    @Column(name = "last_name",length = 100,nullable = false)
    private String lastName;

    @Column(name = "email")
    private String email;

    @Type(type = "json")
    @Column(name = "phone_number", columnDefinition = "json")
    private ArrayList phoneNumber;

    @Column(name = "active_state", columnDefinition = "TINYINT default 1")
    private boolean activeState;

    public Learner(int learnerID, String firstName, String lastName, String email, ArrayList phoneNumber, boolean activeState) {
        this.learnerID = learnerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.activeState = activeState;
    }

    public Learner(String firstName, String lastName, String email, ArrayList phoneNumber, boolean activeState) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.activeState = activeState;
    }

    public Learner(String firstName, String lastName, String email, ArrayList phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Learner() {
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
        return "Learner{" +
                "learnerID=" + learnerID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", activeState=" + activeState +
                '}';
    }
}
