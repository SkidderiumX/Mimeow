/*
 * Decompiled with CFR 0.152.
 */
package x;

public class oc2e4efea860
{
    private final String \u057a;
    private final String \u04f7;
    private final byte[] \u0373;
    private final byte[] \u03f8;

    private oc2e4efea860(String string, String string2, byte[] byArray, byte[] byArray2) {
        this.\u057a = string;
        this.\u04f7 = string2;
        this.\u0373 = byArray;
        this.\u03f8 = byArray2;
    }

    public String \u054a() {
        return this.\u057a;
    }

    public String \u04f6() {
        return this.\u04f7;
    }

    public byte[] \u0372() {
        return this.\u0373;
    }

    public byte[] \u03f7() {
        return this.\u03f8;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        oc2e4efea860 other = (oc2e4efea860)object;
        return java.util.Arrays.deepEquals(new Object[]{this.\u057a, this.\u04f7, this.\u0373, this.\u03f8}, new Object[]{other.\u057a, other.\u04f7, other.\u0373, other.\u03f8});
    }

    @Override
    public int hashCode() {
        return java.util.Arrays.deepHashCode(new Object[]{this.\u057a, this.\u04f7, this.\u0373, this.\u03f8});
    }

    @Override
    public String toString() {
        return "oc2e4efea860[\u057a" + java.util.Arrays.deepToString(new Object[]{this.\u057a}) + ", \u04f7" + java.util.Arrays.deepToString(new Object[]{this.\u04f7}) + ", \u0373" + java.util.Arrays.deepToString(new Object[]{this.\u0373}) + ", \u03f8" + java.util.Arrays.deepToString(new Object[]{this.\u03f8}) + "]";
    }
}

