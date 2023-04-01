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

@Table(name = "address")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id",length = 45,unique = true)
    private int addressID;

    @Column(name = "street",length = 100,nullable = false)
    private String street;

    @Column(name = "city",length = 100,nullable = false)
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "zip_code",length = 100,nullable = false)
    private int zipCode;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    public Address(String street, String city, String state, int zipCode, User user) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.user = user;
    }
}
