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
    @NotNull(message = "content is necessary")
    String content;

    @Column(name = "img")
    String img;  // '/Foodforall.jpeg',

    int achievedmeals;

    int targetmeals;

    float progress; //60,

    String positionName; // 'UK',

    Float Lat;

    Float Lng; // <12.22, 23.55>

    String price; //'8.99',

    String currency; //"$"

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

}
