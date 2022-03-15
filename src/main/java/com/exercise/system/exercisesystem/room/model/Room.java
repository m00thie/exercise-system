package com.exercise.system.exercisesystem.room.model;

import com.exercise.system.exercisesystem.user.model.User;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long roomId;
    String name;
    String description;
    LocalDateTime createdAt;
    @ManyToOne
    @JoinColumn(name = "created_by")
    User createdBy;
    LocalDateTime updatedAt;
    @ManyToOne
    @JoinColumn(name = "updated_by")
    User updatedBy;
    boolean privateRoom;
    @ManyToMany
    @JoinTable(
            name = "private_room_users",
            joinColumns = @JoinColumn(name = "room_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    Set<User> privateRoomUsers;
}
