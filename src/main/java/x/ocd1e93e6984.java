/*
 * Decompiled with CFR 0.152.
 */
package x;
import net.minecraft.network.Packet;

public class ocd1e93e6984
{
    private final Packet<?> \u015d;
    private final long \u028f;

    private ocd1e93e6984(Packet<?> packet, long l) {
        this.\u015d = packet;
        this.\u028f = l;
    }

    public Packet<?> \u015c() {
        return this.\u015d;
    }

    public long \u028f() {
        return this.\u028f;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        ocd1e93e6984 other = (ocd1e93e6984)object;
        return java.util.Arrays.deepEquals(new Object[]{this.\u015d, this.\u028f}, new Object[]{other.\u015d, other.\u028f});
    }

    @Override
    public int hashCode() {
        return java.util.Arrays.deepHashCode(new Object[]{this.\u015d, this.\u028f});
    }

    @Override
    public String toString() {
        return "ocd1e93e6984[\u015d" + java.util.Arrays.deepToString(new Object[]{this.\u015d}) + ", \u028f" + java.util.Arrays.deepToString(new Object[]{this.\u028f}) + "]";
    }
}

