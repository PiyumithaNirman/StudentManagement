package com.example.StudentManagement.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.*;
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
    @NotBlank(message = "First name should not be null")
    @NotNull
    private String firstName;

    @Column(name = "last_name",length = 100)
    @NotBlank(message = "Last name should not be null")
    @NotNull
    private String lastName;

    @Column(name = "password",length = 100)
//    @Size(min=8, max=20)
//    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")
    @NotBlank(message = "Password should not be null")
    @NotNull
    private String password;

    @Column(name = "user_name", nullable = false)
    @Email
    @NotBlank(message = "Email should not be null")
    @NotNull
    private String userName;

//    @Type(type = "json")
//    @Column(name = "phone_number", columnDefinition = "json")
    @NotBlank(message = "Phone Number should not be null")
    @NotNull
    @Pattern(regexp = "(\\+94|0)[0-9]{9}",message = "Phone number format is invalid")
    private String phoneNumber;

    @Column(name = "user_age", nullable = false)
    @Min(18)
    @Max(80)
    @NotNull
    private int age;

    @Column(name = "active_state", columnDefinition = "TINYINT default 1")
    private boolean activeState;

//    @OneToMany(mappedBy="user")
//    private Set<Address> addresses;

//    @OneToMany(mappedBy="user")
//    private Set<Course> courses;
//
    @OneToMany(mappedBy = "user")
    Set<Enrollment> enrollments;

   // @ManyToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
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

    public User(String firstName, String lastName, String password, String userName, String phoneNumber, int age, boolean activeState) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.activeState = activeState;
    }

}
