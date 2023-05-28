package com.confroom.service;

import com.confroom.dao.Storage;
import com.confroom.models.ConfRoom;

public class ConfRoomServiceImpl implements ConfRoomService{

    @Override
    public ConfRoom addConfRoom(Long id, String name, Long floorId, Long buildingId, Integer startTime, Integer endTime) {
        ConfRoom confRoom = new ConfRoom(id, name, floorId, buildingId, startTime,endTime);
        Storage.confRoomMap.put(confRoom.getId(), confRoom);
        return confRoom;
    }
}
