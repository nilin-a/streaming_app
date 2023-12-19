package com.company.app.model;

import com.company.app.model.storedDataModel.City;
import com.company.app.model.storedDataModel.Genre;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Performer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    private String information;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    private City city;

    private Date birthDate;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Genre> genre;

}
