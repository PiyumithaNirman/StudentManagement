package com.example.StudentManagement.dto.Response;

import com.example.StudentManagement.entity.Enrollment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentGetDTO {

    private int amount;
    private Date paymentDate;
    private Enrollment enrollment;
}
