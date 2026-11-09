/*
 * Decompiled with CFR 0.152.
 */
package x;

public class occb76dd375e
{
    private final String \u0491;
    private final float \u03c4;
    private final float \u024b;
    private final float \u03e1;

    private occb76dd375e(String string, float f, float f2, float f3) {
        this.\u0491 = string;
        this.\u03c4 = f;
        this.\u024b = f2;
        this.\u03e1 = f3;
    }

    public String \u0490() {
        return this.\u0491;
    }

    public float \u03c4() {
        return this.\u03c4;
    }

    public float \u024a() {
        return this.\u024b;
    }

    public float \u03e1() {
        return this.\u03e1;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        occb76dd375e other = (occb76dd375e)object;
        return java.util.Arrays.deepEquals(new Object[]{this.\u0491, this.\u03c4, this.\u024b, this.\u03e1}, new Object[]{other.\u0491, other.\u03c4, other.\u024b, other.\u03e1});
    }

    @Override
    public int hashCode() {
        return java.util.Arrays.deepHashCode(new Object[]{this.\u0491, this.\u03c4, this.\u024b, this.\u03e1});
    }

    @Override
    public String toString() {
        return "occb76dd375e[\u0491" + java.util.Arrays.deepToString(new Object[]{this.\u0491}) + ", \u03c4" + java.util.Arrays.deepToString(new Object[]{this.\u03c4}) + ", \u024b" + java.util.Arrays.deepToString(new Object[]{this.\u024b}) + ", \u03e1" + java.util.Arrays.deepToString(new Object[]{this.\u03e1}) + "]";
    }
}

