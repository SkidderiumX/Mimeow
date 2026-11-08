/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.lang.reflect.Field;
import net.minecraft.network.play.server.S14PacketEntity;
import net.minecraft.network.play.server.S19PacketEntityStatus;
import x.occc82079da8;

public class oc756c7feb5c {
    private static final Field \u03c7;
    private static final Field \u03eb;
    public static int \u0504;

    private oc756c7feb5c() {
    }

    public static int \u00d3(S19PacketEntityStatus s19PacketEntityStatus) {
        return oc756c7feb5c.\u0448(\u03c7, s19PacketEntityStatus);
    }

    public static int \u018d(S14PacketEntity s14PacketEntity) {
        return oc756c7feb5c.\u0448(\u03eb, s14PacketEntity);
    }

    private static int \u0448(Field field, Object object) {
        try {
            return field.getInt(object);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new IllegalStateException(illegalAccessException);
        }
    }

    static {
        String[] stringArray = new String[0x717FADC7 ^ 0x717FADC5];
        stringArray[0] = "entityId";
        stringArray[1] = "field_149164_a";
        \u03c7 = occc82079da8.\u00d0(S19PacketEntityStatus.class, stringArray);
        String[] stringArray2 = new String[0x717FADC7 ^ 0x717FADC5];
        stringArray2[0] = "entityId";
        stringArray2[1] = "field_149074_a";
        \u03eb = occc82079da8.\u00d0(S14PacketEntity.class, stringArray2);
    }
}

