package com.confroom.service;

import com.confroom.models.ConfRoom;
import com.confroom.models.Slot;

import java.util.List;

public interface ConfRoomService {
    ConfRoom addConfRoom(Long id, String name, Boolean isAvailable, List<Slot> slots);
}
