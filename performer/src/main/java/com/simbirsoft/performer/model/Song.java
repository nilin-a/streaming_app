package com.simbirsoft.performer.model;

import com.simbirsoft.performer.model.storedDataModel.Genre;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.sql.Time;

@Getter
@Setter
@Entity
@Table
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne()
    @JoinColumn(name = "performer_id", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Performer performer;

    @ManyToOne()
    @JoinColumn(name = "genre_id", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private Genre genre;

    @Column(nullable = false)
    private Time duration;
}
