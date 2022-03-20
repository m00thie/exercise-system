package com.exercise.system.exercisesystem.post.model.domain;

import com.exercise.system.exercisesystem.room.model.domain.Room;
import com.exercise.system.exercisesystem.user.model.domain.User;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(indexes = @Index(columnList = "room_id"))
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long postId;
    @ManyToOne
    @JoinColumn(name = "author_id")
    User author;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    boolean visible;
    String content;
    int likes;
    int dislikes;
    @ManyToOne
    @JoinColumn(name = "room_id")
    Room room;

}
