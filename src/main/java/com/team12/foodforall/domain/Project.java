package com.team12.foodforall.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * @author: Heng Gao
 * @date: 22/03/2022 11:59
 **/
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity(name="projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", columnDefinition = "VARCHAR(255) default title", insertable = false)
    String title;

    @Column(name = "content")
    @NotNull(message = "content is necessary")
    String content;

    @Lob
    @Column(length = Integer.MAX_VALUE, name = "img")
    String img;  // '/Foodforall.jpeg',

    @Column(columnDefinition = "INT default 0", insertable = false)
    Integer achievedmeals;

    @NotNull(message = "target meals is necessary")
    @Column(columnDefinition = "INT default 0", insertable = false)
    Integer targetmeals;

    @Column(columnDefinition = "DOUBLE default 0", insertable = false)
    Double currentRevenue;

    @Column(columnDefinition = "FLOAT default 0", insertable = false)
    Float progress; //60,

    @NotNull(message = " meals is necessary")
    String positionName; // 'UK',

    Float Lat;

    Float Lng; // <12.22, 23.55>

    @NotNull
    @Column(columnDefinition = "FLOAT default 0" , insertable = false)
    Float price; //'8.99',

    String currency; //"$"

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    public boolean isCompleted(){
        return this.achievedmeals == this.targetmeals;
    }

    public void updateTotalRevenue(){
        if(this.getAchievedmeals() == 0){
            return;
        }

        currentRevenue = Double.valueOf(this.getAchievedmeals() * this.getPrice());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Project project = (Project) o;
        return id != null && Objects.equals(id, project.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
