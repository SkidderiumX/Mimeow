/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.util;

import java.io.Serializable;
import org.lwjgl.util.ReadablePoint;
import org.lwjgl.util.WritablePoint;

public class Point
implements ReadablePoint,
WritablePoint,
Serializable {
    static final long serialVersionUID = 1L;
    private int x;
    private int y;

    public Point() {
    }

    public Point(int n, int n2) {
        this.setLocation(n, n2);
    }

    public Point(ReadablePoint readablePoint) {
        this.setLocation(readablePoint);
    }

    @Override
    public void setLocation(int n, int n2) {
        this.x = n;
        this.y = n2;
    }

    @Override
    public void setLocation(ReadablePoint readablePoint) {
        this.x = readablePoint.getX();
        this.y = readablePoint.getY();
    }

    @Override
    public void setX(int n) {
        this.x = n;
    }

    @Override
    public void setY(int n) {
        this.y = n;
    }

    public void translate(int n, int n2) {
        this.x += n;
        this.y += n2;
    }

    public void translate(ReadablePoint readablePoint) {
        this.x += readablePoint.getX();
        this.y += readablePoint.getY();
    }

    public void untranslate(ReadablePoint readablePoint) {
        this.x -= readablePoint.getX();
        this.y -= readablePoint.getY();
    }

    public boolean equals(Object object) {
        if (object instanceof Point) {
            Point point = (Point)object;
            return this.x == point.x && this.y == point.y;
        }
        return super.equals(object);
    }

    public String toString() {
        return this.getClass().getName() + "[x=" + this.x + ",y=" + this.y + "]";
    }

    public int hashCode() {
        int n = this.x + this.y;
        return n * (n + 1) / 2 + this.x;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public void getLocation(WritablePoint writablePoint) {
        writablePoint.setLocation(this.x, this.y);
    }
}

