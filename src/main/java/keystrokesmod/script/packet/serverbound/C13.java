/*
 * Decompiled with CFR 0.152.
 */
package keystrokesmod.script.packet.serverbound;

import keystrokesmod.script.packet.serverbound.CPacket;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.network.play.client.C13PacketPlayerAbilities;

public class C13
extends CPacket {
    public boolean invulnerable;
    public boolean flying;
    public boolean allowFlying;
    public boolean creativeMode;
    public float flySpeed;
    public float walkSpeed;

    public C13(boolean bl, boolean bl2, boolean bl3, boolean bl4, float f, float f2) {
        super(null);
        this.invulnerable = bl;
        this.flying = bl2;
        this.allowFlying = bl3;
        this.creativeMode = bl4;
        this.flySpeed = f;
        this.walkSpeed = f2;
    }

    public C13(C13PacketPlayerAbilities c13PacketPlayerAbilities) {
        super(c13PacketPlayerAbilities);
    }

    @Override
    public C13PacketPlayerAbilities convert() {
        PlayerCapabilities playerCapabilities = new PlayerCapabilities();
        playerCapabilities.disableDamage = this.invulnerable;
        playerCapabilities.isFlying = this.flying;
        playerCapabilities.allowFlying = this.allowFlying;
        playerCapabilities.isCreativeMode = this.creativeMode;
        playerCapabilities.setFlySpeed(this.flySpeed);
        playerCapabilities.setPlayerWalkSpeed(this.walkSpeed);
        return new C13PacketPlayerAbilities(playerCapabilities);
    }
}

