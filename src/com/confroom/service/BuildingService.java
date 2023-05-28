package com.confroom.service;

import com.confroom.models.Building;
import com.confroom.models.Floor;

import java.util.List;

public interface BuildingService {
    Building addBuilding(Long id, String buildingName, List<Floor> floors);
}
