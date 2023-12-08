package ru.mts.dto;

public class House {
    public int number;
    protected String address;
    int floors;
    private String material;

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
