package com.simbirsoft.performer.model.storedDataModel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.simbirsoft.performer.model.Song;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "genre")
    @JsonIgnore
    private List<Song> songs;
}
