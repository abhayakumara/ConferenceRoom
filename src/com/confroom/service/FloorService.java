package com.confroom.service;

import com.confroom.models.ConfRoom;
import com.confroom.models.Floor;

import java.util.List;

public interface FloorService {

    Floor addFloor(Long id, String floorName, Long buildingId, List<ConfRoom> confRoomList);
}
