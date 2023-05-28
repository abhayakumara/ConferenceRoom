package com.confroom.controller;

import com.confroom.dao.Storage;
import com.confroom.models.ConfRoom;
import com.confroom.service.ConfRoomService;
import com.confroom.service.ConfRoomServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class ConfRoomController {
    private ConfRoomService confRoomService;

    public ConfRoomController(ConfRoomServiceImpl confRoomService) {
        this.confRoomService = confRoomService;
    }

    public ConfRoom addConfRoom(Long id, String name, Long floorId, Long buildingId, Integer startTime, Integer endTime) {
        return confRoomService.addConfRoom(id,name, floorId, buildingId, startTime, endTime);
    }

    public List<ConfRoom> getAllConfRooms(Long buildingId) {
        List<ConfRoom> confRoomList = new ArrayList<>();
        Storage.buildingsMap.get(buildingId).getFloors().forEach(floor -> confRoomList.addAll(floor.getConfRoomList()));
        return confRoomList;
    }

    public Boolean isValid(Integer startTime, Integer endTime) {
        if((startTime < 0 || endTime > 25) && (endTime - startTime) < 13 ) {
            return false;
        }
        return true;
    }


    public void bookRoom(Long id, Integer startTime, Integer endTime) {
        if(!Storage.confRoomMap.containsKey(id)){
            System.out.println("Conference room with id " + id + " not available");
        }
        ConfRoom confRoom = Storage.confRoomMap.get(id);

        if(confRoom.getAvailable() && isValid(startTime,endTime)) {
           confRoom.setStartTime(startTime);
           confRoom.setEndTime(endTime);
           confRoom.setAvailable(false);
        }

    }
}
