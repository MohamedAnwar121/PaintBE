package com.example.paintbe.Service.Shapes;

public class Square extends Polygon{
    public int getSideLength() {
        return sideLength;
    }

    public void setSideLength(int sideLength) {
        this.sideLength = sideLength;
    }

    private int sideLength;
}
