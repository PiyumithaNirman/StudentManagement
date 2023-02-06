package com.example.StudentManagement.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.ArrayList;

@Table(name = "teacher")
@Entity
@TypeDefs({
        @TypeDef(name = "json", typeClass =  JsonType.class)
})
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "teacher_id",length = 45,unique = true)
    private int teacherID;

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

    public Teacher(String firstName, String lastName, String email, ArrayList phoneNumber, boolean activeState) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.activeState = activeState;
    }
}
