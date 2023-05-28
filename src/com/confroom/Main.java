package com.confroom;

import com.confroom.controller.BuildingController;
import com.confroom.controller.ConfRoomController;
import com.confroom.controller.FloorController;
import com.confroom.dao.Storage;
import com.confroom.models.ConfRoom;
import com.confroom.models.Floor;
import com.confroom.models.Slot;
import com.confroom.service.BuildingServiceImpl;
import com.confroom.service.ConfRoomServiceImpl;
import com.confroom.service.FloorServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static BuildingServiceImpl buildingService = new BuildingServiceImpl();
    private static BuildingController buildingController = new BuildingController(buildingService);

    private static FloorServiceImpl floorService = new FloorServiceImpl();
    private static FloorController floorController = new FloorController(floorService);

    private static ConfRoomServiceImpl confRoomService = new ConfRoomServiceImpl();
    private static ConfRoomController confRoomController = new ConfRoomController(confRoomService);


    public static void main(String[] args) {
        // write your code here

        confRoomController.addConfRoom(1L,"FirstConfRoom", true, new ArrayList<>());
        confRoomController.addConfRoom(2L,"SecondConfRoom", true, new ArrayList<>());
        confRoomController.addConfRoom(3L,"3rdConfRoom",  true, new ArrayList<>());
        confRoomController.addConfRoom(4L,"4thConfRoom", true, new ArrayList<>());

        List<ConfRoom> confRoomList = new ArrayList<>();
        confRoomList.addAll(Storage.confRoomMap.values());
        floorController.addFloor(1L,"firstFloor", confRoomList);
        List<Floor> floors = new ArrayList<>();
        floors.addAll(Storage.floorMap.values());
        buildingController.addBuilding(1L,"Mybuilding",floors);


        //Get all conf rooms in a building
        confRoomController.getAllConfRooms(1L).stream().forEach(confRoom -> System.out.println("Name:" + confRoom.getName()+ " id:" + confRoom.getId()));

        confRoomController.bookRoom(1L,1L,4L, new Slot(1,3));
        confRoomController.bookRoom(1L,1L,3L, new Slot(1,8));
        confRoomController.bookRoom(1L,1L,4L, new Slot(-1,3));
        confRoomController.bookRoom(1L,1L,4L, new Slot(1,25));
        confRoomController.bookRoom(1L,1L,2L,new Slot(1,8));
        confRoomController.bookRoom(1L,1L,2L,new Slot(9,16));
        confRoomController.bookRoom(1L,1L,2L,new Slot(17,24));
        confRoomController.bookRoom(1L,1L,2L,new Slot(18,20));

        Storage.buildingsMap.forEach((k,v) -> System.out.println("Building: "+ v));

        //get all the available confrooms
        buildingController.getAllTheBookings().stream().forEach(confRoom -> System.out.println("Name:" + confRoom.getName()+ " id:" + confRoom.getId()));

    }
}
