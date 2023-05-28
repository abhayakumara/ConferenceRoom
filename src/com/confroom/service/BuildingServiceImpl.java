package com.confroom.service;

import com.confroom.dao.Storage;
import com.confroom.models.Building;
import com.confroom.models.Floor;

import java.util.List;

public class BuildingServiceImpl implements BuildingService{
    @Override
    public Building addBuilding(Long id, String buildingName, List<Floor> floors) {
        Building building = new Building(id, buildingName, floors);
        Storage.buildingsMap.put(building.getId(), building);
        return building;
    }
}
