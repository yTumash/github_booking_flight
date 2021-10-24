package com.reservation.flightbooking;

public class Seat {

    private String model;
    private Integer height;
    private Integer width;
    private Integer length;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Characteristics" +
                "Model: " + getModel() +
                "Height:" + getHeight() +
                "Width: " + getWidth() +
                "Length: " + getLength();
    }
}
