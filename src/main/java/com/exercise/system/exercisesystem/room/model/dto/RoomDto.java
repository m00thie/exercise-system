package com.exercise.system.exercisesystem.room.model.dto;

import com.exercise.system.exercisesystem.room.model.domain.Room;

public record RoomDto(Long roomId, String name, String description) {
    public static RoomDto ofEntity(Room entity) {
        return new RoomDto(
                entity.getRoomId(),
                entity.getName(),
                entity.getDescription());
    }
}