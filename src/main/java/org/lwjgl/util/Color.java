/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.util;

import java.io.Serializable;
import java.nio.ByteBuffer;
import org.lwjgl.util.ReadableColor;
import org.lwjgl.util.WritableColor;

public class Color
implements ReadableColor,
Serializable,
WritableColor {
    static final long serialVersionUID = 1L;
    private byte red;
    private byte green;
    private byte blue;
    private byte alpha;

    public Color() {
        this(0, 0, 0, 255);
    }

    public Color(int n, int n2, int n3) {
        this(n, n2, n3, 255);
    }

    public Color(byte by, byte by2, byte by3) {
        this(by, by2, by3, -1);
    }

    public Color(int n, int n2, int n3, int n4) {
        this.set(n, n2, n3, n4);
    }

    public Color(byte by, byte by2, byte by3, byte by4) {
        this.set(by, by2, by3, by4);
    }

    public Color(ReadableColor readableColor) {
        this.setColor(readableColor);
    }

    @Override
    public void set(int n, int n2, int n3, int n4) {
        this.red = (byte)n;
        this.green = (byte)n2;
        this.blue = (byte)n3;
        this.alpha = (byte)n4;
    }

    @Override
    public void set(byte by, byte by2, byte by3, byte by4) {
        this.red = by;
        this.green = by2;
        this.blue = by3;
        this.alpha = by4;
    }

    @Override
    public void set(int n, int n2, int n3) {
        this.set(n, n2, n3, 255);
    }

    @Override
    public void set(byte by, byte by2, byte by3) {
        this.set(by, by2, by3, (byte)-1);
    }

    @Override
    public int getRed() {
        return this.red & 0xFF;
    }

    @Override
    public int getGreen() {
        return this.green & 0xFF;
    }

    @Override
    public int getBlue() {
        return this.blue & 0xFF;
    }

    @Override
    public int getAlpha() {
        return this.alpha & 0xFF;
    }

    @Override
    public void setRed(int n) {
        this.red = (byte)n;
    }

    @Override
    public void setGreen(int n) {
        this.green = (byte)n;
    }

    @Override
    public void setBlue(int n) {
        this.blue = (byte)n;
    }

    @Override
    public void setAlpha(int n) {
        this.alpha = (byte)n;
    }

    @Override
    public void setRed(byte by) {
        this.red = by;
    }

    @Override
    public void setGreen(byte by) {
        this.green = by;
    }

    @Override
    public void setBlue(byte by) {
        this.blue = by;
    }

    @Override
    public void setAlpha(byte by) {
        this.alpha = by;
    }

    public String toString() {
        return "Color [" + this.getRed() + ", " + this.getGreen() + ", " + this.getBlue() + ", " + this.getAlpha() + "]";
    }

    public boolean equals(Object object) {
        return object != null && object instanceof ReadableColor && ((ReadableColor)object).getRed() == this.getRed() && ((ReadableColor)object).getGreen() == this.getGreen() && ((ReadableColor)object).getBlue() == this.getBlue() && ((ReadableColor)object).getAlpha() == this.getAlpha();
    }

    public int hashCode() {
        return this.red << 24 | this.green << 16 | this.blue << 8 | this.alpha;
    }

    @Override
    public byte getAlphaByte() {
        return this.alpha;
    }

    @Override
    public byte getBlueByte() {
        return this.blue;
    }

    @Override
    public byte getGreenByte() {
        return this.green;
    }

    @Override
    public byte getRedByte() {
        return this.red;
    }

    @Override
    public void writeRGBA(ByteBuffer byteBuffer) {
        byteBuffer.put(this.red);
        byteBuffer.put(this.green);
        byteBuffer.put(this.blue);
        byteBuffer.put(this.alpha);
    }

    @Override
    public void writeRGB(ByteBuffer byteBuffer) {
        byteBuffer.put(this.red);
        byteBuffer.put(this.green);
        byteBuffer.put(this.blue);
    }

    @Override
    public void writeABGR(ByteBuffer byteBuffer) {
        byteBuffer.put(this.alpha);
        byteBuffer.put(this.blue);
        byteBuffer.put(this.green);
        byteBuffer.put(this.red);
    }

    @Override
    public void writeARGB(ByteBuffer byteBuffer) {
        byteBuffer.put(this.alpha);
        byteBuffer.put(this.red);
        byteBuffer.put(this.green);
        byteBuffer.put(this.blue);
    }

    @Override
    public void writeBGR(ByteBuffer byteBuffer) {
        byteBuffer.put(this.blue);
        byteBuffer.put(this.green);
        byteBuffer.put(this.red);
    }

    @Override
    public void writeBGRA(ByteBuffer byteBuffer) {
        byteBuffer.put(this.blue);
        byteBuffer.put(this.green);
        byteBuffer.put(this.red);
        byteBuffer.put(this.alpha);
    }

    @Override
    public void readRGBA(ByteBuffer byteBuffer) {
        this.red = byteBuffer.get();
        this.green = byteBuffer.get();
        this.blue = byteBuffer.get();
        this.alpha = byteBuffer.get();
    }

    @Override
    public void readRGB(ByteBuffer byteBuffer) {
        this.red = byteBuffer.get();
        this.green = byteBuffer.get();
        this.blue = byteBuffer.get();
    }

    @Override
    public void readARGB(ByteBuffer byteBuffer) {
        this.alpha = byteBuffer.get();
        this.red = byteBuffer.get();
        this.green = byteBuffer.get();
        this.blue = byteBuffer.get();
    }

    @Override
    public void readBGRA(ByteBuffer byteBuffer) {
        this.blue = byteBuffer.get();
        this.green = byteBuffer.get();
        this.red = byteBuffer.get();
        this.alpha = byteBuffer.get();
    }

    @Override
    public void readBGR(ByteBuffer byteBuffer) {
        this.blue = byteBuffer.get();
        this.green = byteBuffer.get();
        this.red = byteBuffer.get();
    }

    @Override
    public void readABGR(ByteBuffer byteBuffer) {
        this.alpha = byteBuffer.get();
        this.blue = byteBuffer.get();
        this.green = byteBuffer.get();
        this.red = byteBuffer.get();
    }

    @Override
    public void setColor(ReadableColor readableColor) {
        this.red = readableColor.getRedByte();
        this.green = readableColor.getGreenByte();
        this.blue = readableColor.getBlueByte();
        this.alpha = readableColor.getAlphaByte();
    }

    public void fromHSB(float f, float f2, float f3) {
        if (f2 == 0.0f) {
            this.green = this.blue = (byte)(f3 * 255.0f + 0.5f);
            this.red = this.blue;
        } else {
            float f4 = (f - (float)Math.floor(f)) * 6.0f;
            float f5 = f4 - (float)Math.floor(f4);
            float f6 = f3 * (1.0f - f2);
            float f7 = f3 * (1.0f - f2 * f5);
            float f8 = f3 * (1.0f - f2 * (1.0f - f5));
            switch ((int)f4) {
                case 0: {
                    this.red = (byte)(f3 * 255.0f + 0.5f);
                    this.green = (byte)(f8 * 255.0f + 0.5f);
                    this.blue = (byte)(f6 * 255.0f + 0.5f);
                    break;
                }
                case 1: {
                    this.red = (byte)(f7 * 255.0f + 0.5f);
                    this.green = (byte)(f3 * 255.0f + 0.5f);
                    this.blue = (byte)(f6 * 255.0f + 0.5f);
                    break;
                }
                case 2: {
                    this.red = (byte)(f6 * 255.0f + 0.5f);
                    this.green = (byte)(f3 * 255.0f + 0.5f);
                    this.blue = (byte)(f8 * 255.0f + 0.5f);
                    break;
                }
                case 3: {
                    this.red = (byte)(f6 * 255.0f + 0.5f);
                    this.green = (byte)(f7 * 255.0f + 0.5f);
                    this.blue = (byte)(f3 * 255.0f + 0.5f);
                    break;
                }
                case 4: {
                    this.red = (byte)(f8 * 255.0f + 0.5f);
                    this.green = (byte)(f6 * 255.0f + 0.5f);
                    this.blue = (byte)(f3 * 255.0f + 0.5f);
                    break;
                }
                case 5: {
                    this.red = (byte)(f3 * 255.0f + 0.5f);
                    this.green = (byte)(f6 * 255.0f + 0.5f);
                    this.blue = (byte)(f7 * 255.0f + 0.5f);
                }
            }
        }
    }

    public float[] toHSB(float[] fArray) {
        float f;
        int n;
        int n2;
        int n3 = this.getRed();
        int n4 = this.getGreen();
        int n5 = this.getBlue();
        if (fArray == null) {
            fArray = new float[3];
        }
        int n6 = n2 = n3 <= n4 ? n4 : n3;
        if (n5 > n2) {
            n2 = n5;
        }
        int n7 = n = n3 >= n4 ? n4 : n3;
        if (n5 < n) {
            n = n5;
        }
        float f2 = (float)n2 / 255.0f;
        float f3 = n2 != 0 ? (float)(n2 - n) / (float)n2 : 0.0f;
        if (f3 == 0.0f) {
            f = 0.0f;
        } else {
            float f4 = (float)(n2 - n3) / (float)(n2 - n);
            float f5 = (float)(n2 - n4) / (float)(n2 - n);
            float f6 = (float)(n2 - n5) / (float)(n2 - n);
            f = n3 == n2 ? f6 - f5 : (n4 == n2 ? 2.0f + f4 - f6 : 4.0f + f5 - f4);
            if ((f /= 6.0f) < 0.0f) {
                f += 1.0f;
            }
        }
        fArray[0] = f;
        fArray[1] = f3;
        fArray[2] = f2;
        return fArray;
    }
}

