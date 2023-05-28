package com.confroom.controller;

import com.confroom.dao.Storage;
import com.confroom.models.Building;
import com.confroom.models.ConfRoom;
import com.confroom.models.Floor;
import com.confroom.models.Slot;
import com.confroom.service.ConfRoomService;
import com.confroom.service.ConfRoomServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class ConfRoomController {
    private ConfRoomService confRoomService;

    public ConfRoomController(ConfRoomServiceImpl confRoomService) {
        this.confRoomService = confRoomService;
    }

    public ConfRoom addConfRoom(Long id, String name, Boolean isAvailable, List<Slot> slots) {
        return confRoomService.addConfRoom(id,name, isAvailable, slots);
    }

    public List<ConfRoom> getAllConfRooms(Long buildingId) {
        List<ConfRoom> confRoomList = new ArrayList<>();
        Storage.buildingsMap.get(buildingId).getFloors().forEach(floor -> confRoomList.addAll(floor.getConfRoomList()));
        return confRoomList;
    }

    public Boolean isValid(Integer startTime, Integer endTime) {
        return startTime >= 1 && endTime <= 24;
    }


    public void bookRoom(Long buildingId, Long floorId, Long confRoomId, Slot slot) {
        int[] allBookedSlots = new int[24];

        if(!isValid(slot.getStartTime(), slot.getEndTime())) {
            System.out.println("Invalid Slot Given: Slot " + slot.toString());
            return;
        }

        if(slot.getEndTime() - slot.getStartTime() > 12) {
            System.out.println("Slot duration crossed the limit for give slot: "+ slot.toString());
            return;
        }

        if(!Storage.buildingsMap.containsKey(buildingId)){
            System.out.println("building with id " + buildingId + " not available");
        }if(!Storage.floorMap.containsKey(floorId)){
            System.out.println("Conference room with id " + floorId + " not available");
        }if(!Storage.confRoomMap.containsKey(confRoomId)){
            System.out.println("Conference room with id " + confRoomId + " not available");
        }

        Building building = Storage.buildingsMap.get(buildingId);
        List<Floor> floors = building.getFloors();
        Floor floor = null;
        for(Floor f : floors) {
            if(f.getId() == floorId) {
                floor = f;
                break;
            }
        }
        List<ConfRoom> confRoomList = floor.getConfRoomList();
        ConfRoom confRoom = null;
        for(ConfRoom c :confRoomList) {
            if(c.getId() == confRoomId) {
                confRoom = c;
                break;
            }
        }

        List<Slot> slots = confRoom.getSlots();

        for(Slot s : slots) {
            for(int i = s.getStartTime() -1; i < s.getEndTime(); i++) {
                allBookedSlots[i] = 1;
            }
        }
        boolean isGivenSlotAvailable = true;
        for (int i = slot.getStartTime() -1; i < slot.getEndTime(); i++) {
            if(allBookedSlots[i] != 0) {
                System.out.println("Requested Slot :"+ slot.toString() + " For Conference Room ID: " + confRoom.getId() + " is NOT Available");
                isGivenSlotAvailable = false;
                break;
            }
        }


        if(isGivenSlotAvailable) {
            for (int i = slot.getStartTime() -1; i < slot.getEndTime(); i++) {
                allBookedSlots[i] = 1;
            }
            int count = 0;
            for (int i = 0; i < allBookedSlots.length; i++) {
                if(allBookedSlots[i] == 0) {
                    confRoom.setAvailable(true);
                    break;
                } else {
                    count++;
                }
            }

            if(count == 24) confRoom.setAvailable(false);

            //Store the updated information in DataBase
            confRoom.getSlots().add(slot);
            Storage.confRoomMap.put(confRoom.getId(), confRoom);
            for(ConfRoom c : confRoomList) {
                if(c.getId() == confRoom.getId()) {
                    confRoomList.remove(c);
                    break;
                }
            }
            confRoomList.add(confRoom);

            floor.setConfRoomList(confRoomList);
            Storage.floorMap.put(floor.getId(), floor);
            for (Floor f : floors) {
                if(f.getId() == floor.getId()) {
                    floors.remove(f);
                    break;
                }
            }
            floors.add(floor);

            building.setFloors(floors);
        }
    }
}
