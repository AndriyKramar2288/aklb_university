package com.banew.aklb_university.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Entity
@NoArgsConstructor
public class Publication {
    @Id
    @GeneratedValue
    private Integer id;
    private String title;
    private Timestamp date = new Timestamp(System.currentTimeMillis());
    @Column(name = "contentView")
    private String contentView;
}
