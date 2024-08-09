package com.microservice.Image.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FileDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    @Lob
    private byte[] data;
    private Long phoneId;

    public FileDB(String name, String type, byte[] data, Long phoneId) {
        this.name = name;
        this.type = type;
        this.phoneId = phoneId;
        this.data = data;
    }
}
