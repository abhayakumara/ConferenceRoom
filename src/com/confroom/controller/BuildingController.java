package com.confroom.controller;

import com.confroom.dao.Storage;
import com.confroom.models.Building;
import com.confroom.models.ConfRoom;
import com.confroom.models.Floor;
import com.confroom.service.BuildingService;
import com.confroom.service.BuildingServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class BuildingController {
    private BuildingService buildingService;

    public BuildingController(BuildingServiceImpl buildingService) {
        this.buildingService = buildingService;
    }

    public Building addBuilding(Long id, String buildingName, List<Floor> floors) {
        return this.buildingService.addBuilding(id, buildingName, floors);
    }

    public List<ConfRoom> getAllTheBookings(){
        List<ConfRoom> confRoomList = new ArrayList<>();
        Storage.buildingsMap.values().forEach(building -> building.getFloors().forEach(floor -> floor.getConfRoomList().forEach(confRoom -> {
            if(confRoom.getAvailable()) {
                confRoomList.add(confRoom);
            }
        })));
        return confRoomList;
    }
}
