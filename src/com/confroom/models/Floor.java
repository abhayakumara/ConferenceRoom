package com.confroom.models;

import java.util.List;

public class Floor {
    private Long id;
    private String floorName;
    private Long buildingId;
    private List<ConfRoom> confRoomList;

    public Floor(Long id, String floorName, Long buildingId, List<ConfRoom> confRoomList) {
        this.id = id;
        this.floorName = floorName;
        this.buildingId = buildingId;
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

    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }

    public List<ConfRoom> getConfRoomList() {
        return confRoomList;
    }

    public void setConfRoomList(List<ConfRoom> confRoomList) {
        this.confRoomList = confRoomList;
    }
}
