/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.network.play.client.C13PacketPlayerAbilities;
import x.ocb5eb238adf;
import x.occ0b63c0426;

public class oc72c3e9656a
extends ocb5eb238adf {
    public boolean \u0203;
    public boolean \u0276;
    public boolean d;
    public boolean \u0397;
    public float \u0287;
    public float \u03e8;
    public static boolean \u0429;

    public oc72c3e9656a(boolean bl, boolean bl2, boolean bl3, boolean bl4, float f, float f2) {
        this(oc72c3e9656a.\u013e(bl, bl2, bl3, bl4, f, f2));
    }

    public oc72c3e9656a(C13PacketPlayerAbilities c13PacketPlayerAbilities) {
        super(c13PacketPlayerAbilities);
        this.\u0203 = c13PacketPlayerAbilities != null && c13PacketPlayerAbilities.isInvulnerable();
        this.\u0276 = c13PacketPlayerAbilities != null && c13PacketPlayerAbilities.isFlying();
        this.d = c13PacketPlayerAbilities != null && c13PacketPlayerAbilities.isAllowFlying();
        this.\u0397 = c13PacketPlayerAbilities != null && c13PacketPlayerAbilities.isCreativeMode();
        this.\u0287 = 0.05f;
        this.\u03e8 = 0.1f;
    }

    public C13PacketPlayerAbilities z$3uoime2rixgf9() {
        C13PacketPlayerAbilities c13PacketPlayerAbilities;
        block6: {
            block5: {
                oc72c3e9656a oc72c3e9656a2;
                block4: {
                    int n = occ0b63c0426.\u039f;
                    oc72c3e9656a2 = this;
                    if (n != 0) break block4;
                    if (!(oc72c3e9656a2.\u03e3 instanceof C13PacketPlayerAbilities)) break block5;
                    oc72c3e9656a2 = this;
                }
                c13PacketPlayerAbilities = (C13PacketPlayerAbilities)oc72c3e9656a2.\u03e3;
                break block6;
            }
            c13PacketPlayerAbilities = null;
        }
        return c13PacketPlayerAbilities;
    }

    private static C13PacketPlayerAbilities \u013e(boolean bl, boolean bl2, boolean bl3, boolean bl4, float f, float f2) {
        PlayerCapabilities playerCapabilities = new PlayerCapabilities();
        playerCapabilities.disableDamage = bl;
        playerCapabilities.isFlying = bl2;
        playerCapabilities.allowFlying = bl3;
        playerCapabilities.isCreativeMode = bl4;
        playerCapabilities.setFlySpeed(f);
        playerCapabilities.setPlayerWalkSpeed(f2);
        return new C13PacketPlayerAbilities(playerCapabilities);
    }
}

