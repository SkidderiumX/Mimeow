/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.util;

import java.io.Serializable;
import org.lwjgl.util.ReadableDimension;
import org.lwjgl.util.ReadablePoint;
import org.lwjgl.util.ReadableRectangle;
import org.lwjgl.util.WritableDimension;
import org.lwjgl.util.WritablePoint;
import org.lwjgl.util.WritableRectangle;

public class Rectangle
implements ReadableRectangle,
WritableRectangle,
Serializable {
    static final long serialVersionUID = 1L;
    private int x;
    private int y;
    private int width;
    private int height;

    public Rectangle() {
    }

    public Rectangle(int n, int n2, int n3, int n4) {
        this.x = n;
        this.y = n2;
        this.width = n3;
        this.height = n4;
    }

    public Rectangle(ReadablePoint readablePoint, ReadableDimension readableDimension) {
        this.x = readablePoint.getX();
        this.y = readablePoint.getY();
        this.width = readableDimension.getWidth();
        this.height = readableDimension.getHeight();
    }

    public Rectangle(ReadableRectangle readableRectangle) {
        this.x = readableRectangle.getX();
        this.y = readableRectangle.getY();
        this.width = readableRectangle.getWidth();
        this.height = readableRectangle.getHeight();
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
    public void setSize(int n, int n2) {
        this.width = n;
        this.height = n2;
    }

    @Override
    public void setSize(ReadableDimension readableDimension) {
        this.width = readableDimension.getWidth();
        this.height = readableDimension.getHeight();
    }

    @Override
    public void setBounds(int n, int n2, int n3, int n4) {
        this.x = n;
        this.y = n2;
        this.width = n3;
        this.height = n4;
    }

    @Override
    public void setBounds(ReadablePoint readablePoint, ReadableDimension readableDimension) {
        this.x = readablePoint.getX();
        this.y = readablePoint.getY();
        this.width = readableDimension.getWidth();
        this.height = readableDimension.getHeight();
    }

    @Override
    public void setBounds(ReadableRectangle readableRectangle) {
        this.x = readableRectangle.getX();
        this.y = readableRectangle.getY();
        this.width = readableRectangle.getWidth();
        this.height = readableRectangle.getHeight();
    }

    @Override
    public void getBounds(WritableRectangle writableRectangle) {
        writableRectangle.setBounds(this.x, this.y, this.width, this.height);
    }

    @Override
    public void getLocation(WritablePoint writablePoint) {
        writablePoint.setLocation(this.x, this.y);
    }

    @Override
    public void getSize(WritableDimension writableDimension) {
        writableDimension.setSize(this.width, this.height);
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

    public boolean contains(ReadablePoint readablePoint) {
        return this.contains(readablePoint.getX(), readablePoint.getY());
    }

    public boolean contains(int n, int n2) {
        int n3 = this.width;
        int n4 = this.height;
        if ((n3 | n4) < 0) {
            return false;
        }
        int n5 = this.x;
        int n6 = this.y;
        if (n < n5 || n2 < n6) {
            return false;
        }
        n4 += n6;
        return !((n3 += n5) >= n5 && n3 <= n || n4 >= n6 && n4 <= n2);
    }

    public boolean contains(ReadableRectangle readableRectangle) {
        return this.contains(readableRectangle.getX(), readableRectangle.getY(), readableRectangle.getWidth(), readableRectangle.getHeight());
    }

    public boolean contains(int n, int n2, int n3, int n4) {
        int n5 = this.width;
        int n6 = this.height;
        if ((n5 | n6 | n3 | n4) < 0) {
            return false;
        }
        int n7 = this.x;
        int n8 = this.y;
        if (n < n7 || n2 < n8) {
            return false;
        }
        n5 += n7;
        if ((n3 += n) <= n ? n5 >= n7 || n3 > n5 : n5 >= n7 && n3 > n5) {
            return false;
        }
        n6 += n8;
        return !((n4 += n2) <= n2 ? n6 >= n8 || n4 > n6 : n6 >= n8 && n4 > n6);
    }

    public boolean intersects(ReadableRectangle readableRectangle) {
        int n = this.width;
        int n2 = this.height;
        int n3 = readableRectangle.getWidth();
        int n4 = readableRectangle.getHeight();
        if (n3 <= 0 || n4 <= 0 || n <= 0 || n2 <= 0) {
            return false;
        }
        int n5 = this.x;
        int n6 = this.y;
        int n7 = readableRectangle.getX();
        int n8 = readableRectangle.getY();
        n4 += n8;
        n += n5;
        n2 += n6;
        return !((n3 += n7) >= n7 && n3 <= n5 || n4 >= n8 && n4 <= n6 || n >= n5 && n <= n7 || n2 >= n6 && n2 <= n8);
    }

    public Rectangle intersection(ReadableRectangle readableRectangle, Rectangle rectangle) {
        int n = this.x;
        int n2 = this.y;
        int n3 = readableRectangle.getX();
        int n4 = readableRectangle.getY();
        long l = n;
        l += (long)this.width;
        long l2 = n2;
        l2 += (long)this.height;
        long l3 = n3;
        l3 += (long)readableRectangle.getWidth();
        long l4 = n4;
        l4 += (long)readableRectangle.getHeight();
        if (n < n3) {
            n = n3;
        }
        if (n2 < n4) {
            n2 = n4;
        }
        if (l > l3) {
            l = l3;
        }
        if (l2 > l4) {
            l2 = l4;
        }
        l2 -= (long)n2;
        if ((l -= (long)n) < Integer.MIN_VALUE) {
            l = Integer.MIN_VALUE;
        }
        if (l2 < Integer.MIN_VALUE) {
            l2 = Integer.MIN_VALUE;
        }
        if (rectangle == null) {
            rectangle = new Rectangle(n, n2, (int)l, (int)l2);
        } else {
            rectangle.setBounds(n, n2, (int)l, (int)l2);
        }
        return rectangle;
    }

    public WritableRectangle union(ReadableRectangle readableRectangle, WritableRectangle writableRectangle) {
        int n = Math.min(this.x, readableRectangle.getX());
        int n2 = Math.max(this.x + this.width, readableRectangle.getX() + readableRectangle.getWidth());
        int n3 = Math.min(this.y, readableRectangle.getY());
        int n4 = Math.max(this.y + this.height, readableRectangle.getY() + readableRectangle.getHeight());
        writableRectangle.setBounds(n, n3, n2 - n, n4 - n3);
        return writableRectangle;
    }

    public void add(int n, int n2) {
        int n3 = Math.min(this.x, n);
        int n4 = Math.max(this.x + this.width, n);
        int n5 = Math.min(this.y, n2);
        int n6 = Math.max(this.y + this.height, n2);
        this.x = n3;
        this.y = n5;
        this.width = n4 - n3;
        this.height = n6 - n5;
    }

    public void add(ReadablePoint readablePoint) {
        this.add(readablePoint.getX(), readablePoint.getY());
    }

    public void add(ReadableRectangle readableRectangle) {
        int n = Math.min(this.x, readableRectangle.getX());
        int n2 = Math.max(this.x + this.width, readableRectangle.getX() + readableRectangle.getWidth());
        int n3 = Math.min(this.y, readableRectangle.getY());
        int n4 = Math.max(this.y + this.height, readableRectangle.getY() + readableRectangle.getHeight());
        this.x = n;
        this.y = n3;
        this.width = n2 - n;
        this.height = n4 - n3;
    }

    public void grow(int n, int n2) {
        this.x -= n;
        this.y -= n2;
        this.width += n * 2;
        this.height += n2 * 2;
    }

    public boolean isEmpty() {
        return this.width <= 0 || this.height <= 0;
    }

    public boolean equals(Object object) {
        if (object instanceof Rectangle) {
            Rectangle rectangle = (Rectangle)object;
            return this.x == rectangle.x && this.y == rectangle.y && this.width == rectangle.width && this.height == rectangle.height;
        }
        return super.equals(object);
    }

    public String toString() {
        return this.getClass().getName() + "[x=" + this.x + ",y=" + this.y + ",width=" + this.width + ",height=" + this.height + "]";
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public void setHeight(int n) {
        this.height = n;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public void setWidth(int n) {
        this.width = n;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public void setX(int n) {
        this.x = n;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public void setY(int n) {
        this.y = n;
    }
}

