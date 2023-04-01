package com.example.StudentManagement.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

@Table(name = "course")
@Entity
@TypeDefs({
        @TypeDef(name = "json", typeClass =  JsonType.class)
})
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "course_id",length = 45,unique = true)
    private int courseID;

    @Column(name = "course_name",length = 100)
    @NotBlank(message = "Course name should not be null")
    @NotNull
    private String courseName;

    @Column(name = "course_description",length = 100)
    @NotBlank(message = "Course description should not be null")
    @NotNull
    private String courseDescription;

    @Column(name = "active_state", columnDefinition = "TINYINT default 1")
    private boolean activeState;

    @Column(name = "start_date")
    @NotNull(message = "Start date should not be null")
    private Date startDate;

    @Column(name = "end_date")
    @NotNull(message = "End date should not be null")
    private Date endDate;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @OneToMany(mappedBy = "course")
    Set<Enrollment> enrollments;

    public Course(String courseName, String courseDescription, boolean activeState, Date startDate, Date endDate) {

        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.activeState = activeState;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
