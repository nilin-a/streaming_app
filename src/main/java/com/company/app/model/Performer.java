package com.company.app.model;

import com.company.app.model.storedDataModel.City;
import com.company.app.model.storedDataModel.Genre;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.swing.*;
import java.sql.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table
public class Performer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String information;

    @ManyToOne()
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private City city;

    @Column
    private Date birthDate;
//(mappedBy = "performers")
    @ManyToMany
    @JoinTable(
            name = "performer_genre",
            joinColumns = @JoinColumn(name = "performer_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id", referencedColumnName = "id")
    )
    private List<Genre> genre;
}
