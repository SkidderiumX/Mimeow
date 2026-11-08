/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.network.play.server.S38PacketPlayerListItem;

public class oc9f46b676cd {
    static final int[] \u0414 = new int[S38PacketPlayerListItem.Action.values().length];

    static {
        try {
            oc9f46b676cd.\u0414[S38PacketPlayerListItem.Action.ADD_PLAYER.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            oc9f46b676cd.\u0414[S38PacketPlayerListItem.Action.REMOVE_PLAYER.ordinal()] = 0x4453BF7B ^ 0x4453BF79;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            oc9f46b676cd.\u0414[S38PacketPlayerListItem.Action.UPDATE_LATENCY.ordinal()] = 0x4453BF7A ^ 0x4453BF79;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            oc9f46b676cd.\u0414[S38PacketPlayerListItem.Action.UPDATE_GAME_MODE.ordinal()] = 0x4453BF7D ^ 0x4453BF79;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            oc9f46b676cd.\u0414[S38PacketPlayerListItem.Action.UPDATE_DISPLAY_NAME.ordinal()] = 0x4453BF7C ^ 0x4453BF79;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}

