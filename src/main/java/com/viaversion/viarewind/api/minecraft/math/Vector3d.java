/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viarewind.api.minecraft.math;

import java.util.Objects;

public class Vector3d {
    double x;
    double y;
    double z;

    public Vector3d(double d, double d2, double d3) {
        this.x = d;
        this.y = d2;
        this.z = d3;
    }

    public Vector3d() {
    }

    public void set(Vector3d vector3d) {
        this.x = vector3d.x;
        this.y = vector3d.y;
        this.z = vector3d.z;
    }

    public Vector3d set(double d, double d2, double d3) {
        this.x = d;
        this.y = d2;
        this.z = d3;
        return this;
    }

    public Vector3d multiply(double d) {
        this.x *= d;
        this.y *= d;
        this.z *= d;
        return this;
    }

    public Vector3d add(Vector3d vector3d) {
        this.x += vector3d.x;
        this.y += vector3d.y;
        this.z += vector3d.z;
        return this;
    }

    public Vector3d substract(Vector3d vector3d) {
        this.x -= vector3d.x;
        this.y -= vector3d.y;
        this.z -= vector3d.z;
        return this;
    }

    public double length() {
        return Math.sqrt(this.lengthSquared());
    }

    public double lengthSquared() {
        return this.x * this.x + this.y * this.y + this.z * this.z;
    }

    public Vector3d normalize() {
        double d = this.length();
        this.multiply(1.0 / d);
        return this;
    }

    public Vector3d clone() {
        return new Vector3d(this.x, this.y, this.z);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        Vector3d vector3d = (Vector3d)object;
        return Double.compare(vector3d.x, this.x) == 0 && Double.compare(vector3d.y, this.y) == 0 && Double.compare(vector3d.z, this.z) == 0;
    }

    public int hashCode() {
        return Objects.hash(this.x, this.y, this.z);
    }

    public String toString() {
        return "Vector3d{x=" + this.x + ", y=" + this.y + ", z=" + this.z + "}";
    }

    public double getX() {
        return this.x;
    }

    public void setX(double d) {
        this.x = d;
    }

    public double getY() {
        return this.y;
    }

    public void setY(double d) {
        this.y = d;
    }

    public double getZ() {
        return this.z;
    }

    public void setZ(double d) {
        this.z = d;
    }
}

