package com.example.StudentManagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "image")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageData  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "image_id",length = 45,unique = true)
    private int imageId;
    private String name;
    private String type;
    @Lob
    private byte[] imageData;

    @OneToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    public ImageData(String originalFilename, String contentType, byte[] bytes, User user) {

        this.name = originalFilename;
        this.type = contentType;
        this.imageData = bytes;
        this.user = user;
    }
}
