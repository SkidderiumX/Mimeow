/*
 * Decompiled with CFR 0.152.
 */
package keystrokesmod.script.packet.clientbound;

import keystrokesmod.script.packet.clientbound.SPacket;
import net.minecraft.network.play.server.S06PacketUpdateHealth;

public class S06
extends SPacket {
    public float health;
    public float saturation;
    public int food;

    public S06(S06PacketUpdateHealth s06PacketUpdateHealth) {
        super(s06PacketUpdateHealth);
        this.health = s06PacketUpdateHealth.getHealth();
        this.saturation = s06PacketUpdateHealth.getSaturationLevel();
        this.food = s06PacketUpdateHealth.getFoodLevel();
    }

    public S06(float f, float f2, int n) {
        super(new S06PacketUpdateHealth(f, n, f2));
        this.health = f;
        this.saturation = f2;
        this.food = n;
    }
}

