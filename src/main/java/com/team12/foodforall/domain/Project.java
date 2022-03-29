package com.team12.foodforall.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author: Heng Gao
 * @date: 22/03/2022 11:59
 **/
@Data
@Entity(name="projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    String title;

    @Column(name = "content")
    String content;

    @Column(name = "img")
    String img;  // '/Foodforall.jpeg',


    String progress; //60,

    String positionName; // 'UK',

    Float Lat;

    Float Lng; // <12.22, 23.55>

    String charity; // 'UK-Charity',

    String price; //'8.99',

    String currency; //"$"

    @ManyToOne
    @JoinColumn(name = "user_id")
    @NotNull(message = "The project has no userId")
    User user;

}
