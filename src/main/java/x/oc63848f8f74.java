/*
 * Decompiled with CFR 0.152.
 */
package x;

public class oc63848f8f74
{
    private final String \u046b;
    private final String \u03d9;

    oc63848f8f74(String string, String string2) {
        this.\u046b = string;
        this.\u03d9 = string2;
    }

    public String \u046a() {
        return this.\u046b;
    }

    public String \u03d9() {
        return this.\u03d9;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        oc63848f8f74 other = (oc63848f8f74)object;
        return java.util.Arrays.deepEquals(new Object[]{this.\u046b, this.\u03d9}, new Object[]{other.\u046b, other.\u03d9});
    }

    @Override
    public int hashCode() {
        return java.util.Arrays.deepHashCode(new Object[]{this.\u046b, this.\u03d9});
    }

    @Override
    public String toString() {
        return "oc63848f8f74[\u046b" + java.util.Arrays.deepToString(new Object[]{this.\u046b}) + ", \u03d9" + java.util.Arrays.deepToString(new Object[]{this.\u03d9}) + "]";
    }
}

