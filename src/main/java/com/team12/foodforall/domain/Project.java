package com.team12.foodforall.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * @author: Heng Gao
 * @date: 22/03/2022 11:59
 **/
@Data
@Entity
public class Project {
    @Id
    @Column(name = "project_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    String title;

    @Column(name = "content", nullable = false)
    String content;

    @Column(name = "img", nullable = false)
    String img;  // '/Foodforall.jpeg',


    String progress; //60,

    String positionName; // 'UK',

    Float Lat;

    Float Lng; // <12.22, 23.55>

    String charity; // 'UK-Charity',

    String price; //'8.99',

    String currency; //"$"

    Long userId; // L

}
