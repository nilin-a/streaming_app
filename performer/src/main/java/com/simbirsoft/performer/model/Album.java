package com.simbirsoft.performer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "album")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Column(nullable = false)
    private String title;

    @Column
    private String description;

    @Column(nullable = false, columnDefinition = "date DEFAULT current_date")
    private LocalDate releaseDate;

    @ManyToMany()
    @Column(nullable = false)
    @JoinTable(
            name = "album_performer",
            joinColumns = @JoinColumn(name = "album_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "performer_id", referencedColumnName = "id")
    )
    private List<Performer> performers;

    @OneToMany(mappedBy = "album")
    @JsonIgnore
    private List<Song> songs;
}
