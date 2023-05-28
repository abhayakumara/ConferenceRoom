package com.confroom.service;

import com.confroom.dao.Storage;
import com.confroom.models.ConfRoom;
import com.confroom.models.Slot;

import java.util.List;

public class ConfRoomServiceImpl implements ConfRoomService{

    @Override
    public ConfRoom addConfRoom(Long id, String name, Boolean isAvailable, List<Slot> slots) {
        ConfRoom confRoom = new ConfRoom(id, name, isAvailable, slots);
        Storage.confRoomMap.put(confRoom.getId(), confRoom);
        return confRoom;
    }
}
