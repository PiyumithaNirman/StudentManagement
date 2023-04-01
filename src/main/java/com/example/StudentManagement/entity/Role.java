package com.example.StudentManagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name = "role")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_Id",length = 45,unique = true)
    private int roleId;

    @Column(name = "role_name",length = 100)
    private String roleName;

    @Column(name = "description",length = 100)
    private String description;

//    @ManyToMany(mappedBy = "role", cascade = {CascadeType.DETACH, CascadeType.MERGE})
//    private Set<User> users = new HashSet<>();


//    @OneToMany(mappedBy = "role")
//    Set<UserRole> userRoles;

    public Role(String roleName,String description){
        this.roleName = roleName;
        this.description = description;
    }

}
