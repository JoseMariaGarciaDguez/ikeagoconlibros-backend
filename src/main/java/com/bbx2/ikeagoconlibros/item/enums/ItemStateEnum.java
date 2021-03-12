package com.bbx2.ikeagoconlibros.item.enums;

public enum ItemStateEnum {

    DISCONTINUED(0, "Discontinued"),
    ACTIVE(1, "Active");

     Integer id;
     String state;

    ItemStateEnum(Integer id, String state) {
        this.id = id;
        this.state = state;
    }

    ItemStateEnum(Integer id){

    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "ItemState{" +
                "id=" + id +
                ", state='" + state + '\'' +
                '}';
    }
}
