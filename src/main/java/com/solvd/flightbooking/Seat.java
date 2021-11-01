package com.solvd.flightbooking;

public class Seat {

    public  Type type;
    private String model;
    private Integer height;
    private Integer width;
    private Integer length;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

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

    public enum Type {
        ECONOMY("economy"),
        PREMIUM_ECONOMY("premium economy"),
        BUSINESS("business"),
        FIRST_CLASS("first class");

        private String t;

        Type(String t) {
            this.t = t;
        }

        public static Type takeSeat(String t) {
            for (Type type : Type.values()) {
                if (type.getT().equals(t)) {
                    return type;
                }
            }
            return null;
        }

        public String getT() {
            return t;
        }

        public void setT(String t) {
            this.t = t;
        }
    }
}
