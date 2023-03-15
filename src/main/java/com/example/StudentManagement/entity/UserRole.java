//package com.example.StudentManagement.entity;
//
//import com.vladmihalcea.hibernate.type.json.JsonType;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.hibernate.annotations.TypeDef;
//import org.hibernate.annotations.TypeDefs;
//
//import javax.persistence.*;
//
//@Table(name = "user_role")
//@Entity
//@TypeDefs({
//        @TypeDef(name = "json", typeClass =  JsonType.class)
//})
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class UserRole {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "user_role_id",length = 45,unique = true)
//    private int userRoleID;
//
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_name")
//    private User user;
//
//    @ManyToOne
//    @JoinColumn(name = "role_id")
//    private Role role;
//
//    public UserRole(User user, Role role) {
//        this.user = user;
//        this.role = role;
//    }
//}
