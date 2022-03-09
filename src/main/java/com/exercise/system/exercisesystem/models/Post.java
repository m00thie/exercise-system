package com.exercise.system.exercisesystem.models;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String description;
    private LocalDateTime createdDate;
    @ManyToOne(optional = false)
    @JoinColumn(name = "room", referencedColumnName = "roomId")
    private Room room;
    @ManyToOne(optional = false)
    @JoinColumn(name = "activeUser", referencedColumnName = "userId")
    private User activeUser;

    public Post(String title, String description, Room room, User user) {
        this.title = title;
        this.description = description;
        this.createdDate = LocalDateTime.now();
        this.room = room;
        this.activeUser = user;
    }
}
