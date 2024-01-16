package com.simbirsoft.performer.model;

import com.simbirsoft.performer.model.storedDataModel.Genre;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "song")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Time duration;

    @Column
    private String lyrics;

    @Column(nullable = false, columnDefinition = "date DEFAULT current_date")
    private Date releaseDate;

    @ManyToOne()
    @JoinColumn(name = "album_id", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Album album;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "song_performer",
            joinColumns = @JoinColumn(name = "song_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "performer_id", referencedColumnName = "id")
    )
    @OnDelete(action = OnDeleteAction.CASCADE)
    @Column(nullable = false)
    private List<Performer> performers;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "song_featuring",
            joinColumns = @JoinColumn(name = "song_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "performer_id", referencedColumnName = "id")
    )
    private List<Performer> featuring;

    @ManyToOne()
    @JoinColumn(name = "genre_id", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private Genre genre;
}
