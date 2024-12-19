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


    // public void setId(Integer id) {
    //     this.id = id;
    // }

    // public void setContentView(String contentView) {
    //     this.contentView = contentView;
    // }

    // public void setDate(Timestamp date) {
    //     this.date = date;
    // }

    // public void setTitle(String title) {
    //     this.title = title;
    // }

    // public Integer getId() {
    //     return id;
    // }

    // public String getContentView() {
    //     return contentView;
    // }

    // public String getTitle() {
    //     return title;
    // }

    // public Timestamp getDate() {
    //     return date;
    // }

    // public Publication() {

    // }
}
