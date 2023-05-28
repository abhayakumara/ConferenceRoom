package com.confroom.service;

import com.confroom.dao.Storage;
import com.confroom.models.ConfRoom;
import com.confroom.models.Floor;

import java.util.List;

public class FloorServiceImpl implements FloorService{

    @Override
    public Floor addFloor(Long id, String floorName, Long buildingId, List<ConfRoom> confRoomList) {
        Floor floor = new Floor(id, floorName, buildingId,confRoomList);
        Storage.floorMap.put(floor.getId(), floor);
        return floor;
    }
}
