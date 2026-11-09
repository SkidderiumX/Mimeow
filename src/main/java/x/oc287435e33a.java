/*
 * Decompiled with CFR 0.152.
 */
package x;
import net.minecraft.potion.Potion;

public class oc287435e33a
{
    private final Potion \u04ed;
    private final String \u04e3;
    private final String \u03b6;
    private final float \u0571;
    private final float \u0499;

    private oc287435e33a(Potion potion, String string, String string2, float f, float f2) {
        this.\u04ed = potion;
        this.\u04e3 = string;
        this.\u03b6 = string2;
        this.\u0571 = f;
        this.\u0499 = f2;
    }

    public Potion \u04ec() {
        return this.\u04ed;
    }

    public String \u04e2() {
        return this.\u04e3;
    }

    public String \u0396() {
        return this.\u03b6;
    }

    public float \u0571() {
        return this.\u0571;
    }

    public float \u0498() {
        return this.\u0499;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        oc287435e33a other = (oc287435e33a)object;
        return java.util.Arrays.deepEquals(new Object[]{this.\u04ed, this.\u04e3, this.\u03b6, this.\u0571, this.\u0499}, new Object[]{other.\u04ed, other.\u04e3, other.\u03b6, other.\u0571, other.\u0499});
    }

    @Override
    public int hashCode() {
        return java.util.Arrays.deepHashCode(new Object[]{this.\u04ed, this.\u04e3, this.\u03b6, this.\u0571, this.\u0499});
    }

    @Override
    public String toString() {
        return "oc287435e33a[\u04ed" + java.util.Arrays.deepToString(new Object[]{this.\u04ed}) + ", \u04e3" + java.util.Arrays.deepToString(new Object[]{this.\u04e3}) + ", \u03b6" + java.util.Arrays.deepToString(new Object[]{this.\u03b6}) + ", \u0571" + java.util.Arrays.deepToString(new Object[]{this.\u0571}) + ", \u0499" + java.util.Arrays.deepToString(new Object[]{this.\u0499}) + "]";
    }
}

