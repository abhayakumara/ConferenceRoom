package com.confroom.models;

import java.util.List;

public class ConfRoom {
    private Long id;
    private String name;
    private Boolean isAvailable;
    private List<Slot> slots;

    public ConfRoom(Long id, String name, Boolean isAvailable, List<Slot> slots) {
        this.id = id;
        this.name = name;
        this.isAvailable = isAvailable;
        this.slots = slots;
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

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public void setSlots(List<Slot> slots) {
        this.slots = slots;
    }

    @Override
    public String toString() {
        return "ConfRoom{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isAvailable=" + isAvailable +
                ", slots=" + slots +
                '}';
    }
}
