package com.confroom.models;

import java.util.List;

public class Floor {
    private Long id;
    private String floorName;
    private List<ConfRoom> confRoomList;

    public Floor(Long id, String floorName, List<ConfRoom> confRoomList) {
        this.id = id;
        this.floorName = floorName;
        this.confRoomList = confRoomList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFloorName() {
        return floorName;
    }

    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }

    public List<ConfRoom> getConfRoomList() {
        return confRoomList;
    }

    public void setConfRoomList(List<ConfRoom> confRoomList) {
        this.confRoomList = confRoomList;
    }

    @Override
    public String toString() {
        return "Floor{" +
                "id=" + id +
                ", floorName='" + floorName + '\'' +
                ", confRoomList=" + confRoomList +
                '}';
    }
}
