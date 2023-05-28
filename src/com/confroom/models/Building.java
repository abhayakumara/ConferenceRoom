package com.confroom.models;

import java.util.List;

public class Building {
    private Long id;
    private String buildingName;
    private List<Floor> floors;

    public Building(Long id, String buildingName, List<Floor> floors) {
        this.id = id;
        this.buildingName = buildingName;
        this.floors = floors;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }

    @Override
    public String toString() {
        return "Building{" +
                "id=" + id +
                ", buildingName='" + buildingName + '\'' +
                ", floors=" + floors +
                '}';
    }
}
