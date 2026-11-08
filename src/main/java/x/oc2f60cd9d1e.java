/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.EnumSet;
import java.util.Set;
import java.util.function.Consumer;
import net.minecraft.network.Packet;
import net.minecraft.network.ThreadQuickExitException;
import org.jetbrains.annotations.NotNull;
import x.oc7ab2161b9f;
import x.ocda171fe5d8;

public enum oc2f60cd9d1e {
    \u01b8(packet -> {
        try {
            packet.processPacket(ocda171fe5d8.\u01d4.getNetHandler());
        }
        catch (ThreadQuickExitException threadQuickExitException) {
        }
        catch (Exception exception) {
            oc7ab2161b9f.\u057a("error while handling packet: " + packet.getClass().getSimpleName());
        }
    }),
    \u00fb(packet -> ocda171fe5d8.\u01d4.getNetHandler().addToSendQueue((Packet)packet));
    private static final oc2f60cd9d1e[] $VALUES_REF;


    @NotNull
    public static final Set<oc2f60cd9d1e> \u01cc;
    @NotNull
    public static final Set<oc2f60cd9d1e> \u054d;
    @NotNull
    public static final Set<oc2f60cd9d1e> \u0497;
    @NotNull
    private final Consumer<Packet<?>> \u0176;
    private static final /* synthetic */ oc2f60cd9d1e[] \u054f;
    public static int \u0414;



    private oc2f60cd9d1e(Consumer<Packet<?>> consumer) {
        this.\u0176 = consumer;
    }

    public void \u0265(@NotNull Packet<?> packet) {
        this.\u0176.accept(packet);
    }

    private static /* synthetic */ oc2f60cd9d1e[] \u00c8() {
        oc2f60cd9d1e[] oc2f60cd9d1eArray = new oc2f60cd9d1e[0x6D67CB45 ^ 0x6D67CB47];
        oc2f60cd9d1eArray[0] = \u01b8;
        oc2f60cd9d1eArray[1] = \u00fb;
        return oc2f60cd9d1eArray;
    }

    static {
        \u054f = oc2f60cd9d1e.\u00c8();
        \u01cc = EnumSet.of(\u01b8);
        \u054d = EnumSet.of(\u00fb);
        \u0497 = EnumSet.allOf(oc2f60cd9d1e.class);
    }
}

