package com.example.StudentManagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Table(name = "role")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Role {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "role_id",length = 45,unique = true)
//    private int roleID;


    @Id
    @Column(name = "role_name",length = 100)
    private String roleName;

    @Column(name = "description",length = 100)
    private String description;

//    @OneToMany(mappedBy = "role")
//    Set<UserRole> userRoles;

//    public Role(String roleName,String description){
//        this.roleName = roleName;
//        this.description = description;
//    }

}
