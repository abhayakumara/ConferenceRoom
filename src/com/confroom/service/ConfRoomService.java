package com.confroom.service;

import com.confroom.models.ConfRoom;

public interface ConfRoomService {
    ConfRoom addConfRoom(Long id, String name, Long floorId, Long buildingId, Integer startTime, Integer endTime);
}
