package com.company.app.model;

import com.company.app.model.storedDataModel.City;
import com.company.app.model.storedDataModel.Genre;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    @JsonIgnore
    private City city;

    private Date birthDate;

    @ManyToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Genre> genre;
}
