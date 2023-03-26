package com.example.StudentManagement.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Table(name = "enrollment")
@Entity
@TypeDefs({
        @TypeDef(name = "json", typeClass =  JsonType.class)
})
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "enrollment_id",length = 45,unique = true)
    private int enrollmentID;

    @Column(name = "enrollment_date")
    private Date date;

    @Column(name = "active_state")
    private boolean active_state;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToOne(mappedBy="enrollment")
    private Payment payment;

}
