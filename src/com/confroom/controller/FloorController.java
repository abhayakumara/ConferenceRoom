package com.confroom.controller;

import com.confroom.models.ConfRoom;
import com.confroom.models.Floor;
import com.confroom.service.FloorService;
import com.confroom.service.FloorServiceImpl;

import java.util.List;

public class FloorController {
    private FloorService floorService;

    public FloorController(FloorServiceImpl floorService) {
        this.floorService = floorService;
    }

    public Floor addFloor(Long id, String floorName, List<ConfRoom> confRoomList) {
        return this.floorService.addFloor(id, floorName, confRoomList);
    }

}
