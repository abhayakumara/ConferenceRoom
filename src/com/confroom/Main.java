package com.confroom;

import com.confroom.controller.BuildingController;
import com.confroom.controller.ConfRoomController;
import com.confroom.controller.FloorController;
import com.confroom.dao.Storage;
import com.confroom.models.ConfRoom;
import com.confroom.models.Floor;
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

        confRoomController.addConfRoom(1L,"FirstConfRoom",1L,1L, 0, 0);
        confRoomController.addConfRoom(2L,"SecondConfRoom",1L,1L, 0, 0);
        confRoomController.addConfRoom(3L,"3rdConfRoom",1L,1L, 0, 0);
        confRoomController.addConfRoom(4L,"4thConfRoom",1L,1L, 0, 0);

        List<ConfRoom> confRoomList = new ArrayList<>();
        confRoomList.addAll(Storage.confRoomMap.values());
        floorController.addFloor(1L,"firstFloor",1L, confRoomList);
        List<Floor> floors = new ArrayList<>();
        floors.addAll(Storage.floorMap.values());
        buildingController.addBuilding(1L,"Mybuilding",floors);


        //Get all conf rooms in a building
        confRoomController.getAllConfRooms(1L).stream().forEach(confRoom -> System.out.println("Name:" + confRoom.getName()+ " id:" + confRoom.getId()));

        confRoomController.bookRoom(4L, 1,3);
        confRoomController.bookRoom(3L, 1,8);
        confRoomController.bookRoom(4L, -1,3);
        confRoomController.bookRoom(4L, 1,25);

        //get all the available confrooms
        buildingController.getAllTheBookings().stream().forEach(confRoom -> System.out.println("Name:" + confRoom.getName()+ " id:" + confRoom.getId()));

    }
}
