package com.confroom.models;

public class ConfRoom {
    private Long id;
    private String name;
    private Long floorId;
    private Long buildingId;
    private Boolean isAvailable;
    private Integer startTime;
    private Integer endTime;

    public ConfRoom(Long id, String name, Long floorId, Long buildingId, Integer startTime, Integer endTime) {
        this.id = id;
        this.name = name;
        this.floorId = floorId;
        this.buildingId = buildingId;
        this.isAvailable = true;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getFloorId() {
        return floorId;
    }

    public void setFloorId(Long floorId) {
        this.floorId = floorId;
    }

    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }
}
