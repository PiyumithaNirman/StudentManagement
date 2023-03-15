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
import java.util.Set;

@Table(name = "user")
@Entity
@TypeDefs({
        @TypeDef(name = "json", typeClass =  JsonType.class)
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_Id",length = 45,unique = true)
    private int userId;

    @Column(name = "first_name",length = 100)
    private String firstName;

    @Column(name = "last_name",length = 100)
    private String lastName;

    @Column(name = "password",length = 100)
    private String password;

    @Column(name = "user_name")
    private String userName;

    @Type(type = "json")
    @Column(name = "phone_number", columnDefinition = "json")
    private ArrayList phoneNumber;

    @Column(name = "active_state", columnDefinition = "TINYINT default 1")
    private boolean activeState;

    @OneToMany(mappedBy="user")
    private Set<Address> addresses;

    @OneToMany(mappedBy="user")
    private Set<Course> courses;

    @OneToMany(mappedBy = "user")
    Set<Enrollment> enrollments;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "USER_ROLE",
               joinColumns = {
                        @JoinColumn(name = "USER_ID")
               },
               inverseJoinColumns = {
                        @JoinColumn(name = "ROLE_ID")
               }
               )
    private Set<Role> role;

//    @OneToMany(mappedBy = "user")
//    Set<UserRole> userRoles;

    public User(String firstName, String lastName, String password, String userName, ArrayList phoneNumber, boolean activeState) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.activeState = activeState;
    }

    public User(String firstName, String lastName, String userName, ArrayList phoneNumber, boolean activeState, Set<Address> addresses, Set<Course> courses, Set<Enrollment> enrollments, Set<Role> role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.activeState = activeState;
        this.addresses = addresses;
        this.courses = courses;
        this.enrollments = enrollments;
        this.role = role;
    }
}
