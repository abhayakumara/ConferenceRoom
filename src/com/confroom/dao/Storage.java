package com.confroom.dao;

import com.confroom.models.Building;
import com.confroom.models.ConfRoom;
import com.confroom.models.Floor;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    //Create a private constructor to use this class as utility class
    private Storage() {
    }

    //Building Id , Building
    public static final Map<Long, Building> buildingsMap = new HashMap<>();
    //Floor id, floor
    public static final Map<Long, Floor>  floorMap= new HashMap<>();
    //Conf room id, conf room
    public static final Map<Long, ConfRoom> confRoomMap = new HashMap<>();
}
