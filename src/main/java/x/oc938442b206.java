/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.client.Minecraft;
import x.oc49fb68d420;
import x.oc72ee500c19;
import x.oc7ab2161b9f;
import x.oc9341368218;
import x.oca9cc61aada;

public class oc938442b206
extends oc49fb68d420 {
    private final oca9cc61aada \u017e = new oca9cc61aada("MMC Value", 0.8, 0.75, 1.0, 0.01);
    public static boolean \u027e;

    public oc938442b206(oc72ee500c19 oc72ee500c192) {
        super("MMC", oc72ee500c192);
        this.\u023e(this.\u017e);
    }

    @Override
    public void z$fe4mfecqaowg() {
        this.\u017e.\u0209(this.\u03cc.\u04c2("MMC"), this.\u03cc);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public void z$1hfnjryfrqybj(oc9341368218 oc93413682182) {
        oc938442b206 oc938442b2062;
        block24: {
            Minecraft minecraft;
            block23: {
                Minecraft minecraft2;
                boolean bl;
                block21: {
                    block22: {
                        boolean bl2;
                        block20: {
                            bl = false;
                            bl2 = oc7ab2161b9f.\u00d0();
                            if (bl) break block20;
                            if (!bl2) return;
                            bl2 = this.\u0226();
                        }
                        if (bl2 || oc93413682182.\u04e0 != this.\u01f1.thePlayer) return;
                        minecraft2 = this.\u01f1;
                        if (bl) break block21;
                        if (minecraft2.thePlayer.hurtTime > 1) break block22;
                        return;
                    }
                    this.\u01f1.thePlayer.motionX *= this.\u017e.\u04c1();
                    minecraft = this.\u01f1;
                    if (bl) break block23;
                    minecraft.thePlayer.motionZ *= this.\u017e.\u04c1();
                    minecraft2 = this.\u01f1;
                }
                if (!minecraft2.thePlayer.onGround) return;
                oc938442b2062 = this;
                if (bl) break block24;
                minecraft = oc938442b2062.\u01f1;
            }
            if (minecraft.gameSettings.keyBindJump.isKeyDown()) return;
            oc938442b2062 = this;
        }
        oc938442b2062.\u01f1.thePlayer.jump();
    }
}

