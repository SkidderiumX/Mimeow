/*
 * Decompiled with CFR 0.152.
 */
package x;

public class oc99b8eeba10
{
    private final float \u04e9;
    private final float \u026a;
    private final float \u0167;
    private final float \u04ce;
    private final float \u01f9;
    private final Runnable \u0267;
    private final Runnable \u04b1;
    public static int \u053a;

    public oc99b8eeba10(float f, float f2, float f3, float f4, Runnable runnable2) {
        this(f, f2, f3, f4, 1.0f, runnable2, null);
    }

    public oc99b8eeba10(float f, float f2, float f3, float f4, float f5, Runnable runnable2, Runnable runnable3) {
        this.\u04e9 = f;
        this.\u026a = f2;
        this.\u0167 = f3;
        this.\u04ce = f4;
        this.\u01f9 = f5;
        this.\u0267 = runnable2;
        this.\u04b1 = runnable3;
    }

    public float \u04e8() {
        return this.\u04e9;
    }

    public float \u026a() {
        return this.\u026a;
    }

    public float \u0166() {
        return this.\u0167;
    }

    public float \u04cd() {
        return this.\u04ce;
    }

    public float \u01f9() {
        return this.\u01f9;
    }

    public Runnable \u0267() {
        return this.\u0267;
    }

    public Runnable \u04b0() {
        return this.\u04b1;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        oc99b8eeba10 other = (oc99b8eeba10)object;
        return java.util.Arrays.deepEquals(new Object[]{this.\u04e9, this.\u026a, this.\u0167, this.\u04ce, this.\u01f9, this.\u0267, this.\u04b1}, new Object[]{other.\u04e9, other.\u026a, other.\u0167, other.\u04ce, other.\u01f9, other.\u0267, other.\u04b1});
    }

    @Override
    public int hashCode() {
        return java.util.Arrays.deepHashCode(new Object[]{this.\u04e9, this.\u026a, this.\u0167, this.\u04ce, this.\u01f9, this.\u0267, this.\u04b1});
    }

    @Override
    public String toString() {
        return "oc99b8eeba10[\u04e9" + java.util.Arrays.deepToString(new Object[]{this.\u04e9}) + ", \u026a" + java.util.Arrays.deepToString(new Object[]{this.\u026a}) + ", \u0167" + java.util.Arrays.deepToString(new Object[]{this.\u0167}) + ", \u04ce" + java.util.Arrays.deepToString(new Object[]{this.\u04ce}) + ", \u01f9" + java.util.Arrays.deepToString(new Object[]{this.\u01f9}) + ", \u0267" + java.util.Arrays.deepToString(new Object[]{this.\u0267}) + ", \u04b1" + java.util.Arrays.deepToString(new Object[]{this.\u04b1}) + "]";
    }
}

