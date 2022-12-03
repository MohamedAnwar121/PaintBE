package com.example.paintbe.Service.Shapes;

import java.awt.*;

public class LineSegment extends Shape{
    private Point[] points;
    private boolean closed;


    public Point[] getPoints() {
        return points;
    }

    public void setPoints(Point[] points) {
        this.points = points;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }
}
