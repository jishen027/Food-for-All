package com.team12.foodforall.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author: Heng Gao
 * @date: 22/03/2022 11:59
 **/
@Data
@Entity
public class Project {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    String title;
}
