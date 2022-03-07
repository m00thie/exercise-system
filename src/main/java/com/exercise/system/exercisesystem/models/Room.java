package com.exercise.system.exercisesystem.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long roomId;
    private String name;
    @OneToMany
    @JoinColumn(name = "users", referencedColumnName = "roomId")
    private Set<User> users = new HashSet<>();

    public Room(String name, Set<User> users) {
        this.name = name;
        this.users = users;
    }
}
