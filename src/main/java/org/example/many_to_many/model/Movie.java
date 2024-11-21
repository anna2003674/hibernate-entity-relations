package org.example.many_to_many.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Movie")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Movie {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "year_of_production")
    private int year0fProduction;

    @ManyToMany(mappedBy = "movies")
    private List<Actor> actors;

    public Movie(String name, int year0fProduction) {
        this.name = name;
        this.year0fProduction = year0fProduction;
    }
}
