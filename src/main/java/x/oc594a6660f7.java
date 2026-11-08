/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.client.Minecraft;
import org.apache.commons.lang3.RandomUtils;
import org.lwjgl.input.Keyboard;
import x.oc110d7f376c;
import x.oc52918cda9d;
import x.oc66fa4f2195;
import x.oc69da1aa7f5;
import x.oc7ab2161b9f;
import x.oc7fbc83d9b3;
import x.oc84f20a0bc5;
import x.oc9adb807c19;
import x.oca9cc61aada;
import x.ocb15e077143;
import x.occ2f8dff8d8;
import x.occc831eff22;
import x.ocd84af7ddf8;
import x.oce4cea752dd;

public class oc594a6660f7
extends oc69da1aa7f5 {
    private static final Minecraft \u0498 = Minecraft.getMinecraft();
    private int \u0432 = 0;
    public final oca9cc61aada \u0578 = new oca9cc61aada("Min delay", " ticks", 2.0, 0.0, 10.0, 1.0);
    public final oca9cc61aada \u0225 = new oca9cc61aada("Max delay", " ticks", 3.0, 0.0, 10.0, 1.0);
    private final occc831eff22 \u047f = new occc831eff22("Condition");
    public final occ2f8dff8d8 \u00da = new occ2f8dff8d8(this.\u047f, "Direction check", true);
    public final occ2f8dff8d8 \u044b = new occ2f8dff8d8(this.\u047f, "Jump check", true);
    public final occ2f8dff8d8 \u0210 = new occ2f8dff8d8(this.\u047f, "Pitch check", true);
    public final occ2f8dff8d8 \u01b0 = new occ2f8dff8d8(this.\u047f, "Blocks only", true);
    public final occ2f8dff8d8 \u0103 = new occ2f8dff8d8(this.\u047f, "Sneaking only", false);
    public static boolean \u0386;

    public oc594a6660f7() {
        super("Eagle", oce4cea752dd.\u0437);
        this.\u0105("Automatically sneaks for you when you are near the edge of a block.");
        this.\u028c(this.\u0578);
        this.\u028c(this.\u0225);
        this.\u028c(this.\u047f);
        this.\u028c(this.\u00da);
        this.\u028c(this.\u044b);
        this.\u028c(this.\u0210);
        this.\u028c(this.\u01b0);
        this.\u028c(this.\u0103);
    }

    @Override
    public String getInfo() {
        Object object;
        block6: {
            int n;
            int n2;
            block4: {
                int n3;
                block5: {
                    n3 = (int)this.\u0578.\u04c1();
                    n2 = (int)this.\u0225.\u04c1();
                    int n4 = oc84f20a0bc5.\u0117;
                    n = n3;
                    if (n4 != 0) break block4;
                    if (n != n2) break block5;
                    object = Integer.toString(n3);
                    break block6;
                }
                n = n3;
            }
            object = n + "-" + n2;
        }
        return object;
    }

    @Override
    public void z$1sehylui0i4ix(oca9cc61aada oca9cc61aada2) {
        block20: {
            oca9cc61aada oca9cc61aada3;
            block22: {
                int n;
                block21: {
                    block18: {
                        block19: {
                            n = oc84f20a0bc5.\u0117;
                            oca9cc61aada3 = oca9cc61aada2;
                            if (n != 0) break block18;
                            if (oca9cc61aada3 != this.\u0578) break block19;
                            oca9cc61aada3 = this.\u0578;
                            if (n != 0) break block18;
                            if (!(oca9cc61aada3.\u04c1() > this.\u0225.\u04c1())) break block19;
                            this.\u0225.\u021e(this.\u0578.\u04c1());
                            if (n == 0) break block20;
                        }
                        oca9cc61aada3 = oca9cc61aada2;
                    }
                    if (n != 0) break block21;
                    if (oca9cc61aada3 != this.\u0225) break block20;
                    oca9cc61aada3 = this.\u0225;
                }
                if (n != 0) break block22;
                if (!(oca9cc61aada3.\u04c1() < this.\u0578.\u04c1())) break block20;
                oca9cc61aada3 = this.\u0578;
            }
            oca9cc61aada3.\u021e(this.\u0225.\u04c1());
        }
    }

    @Override
    public void onDisable() {
        this.\u0432 = 0;
    }

    private boolean g() {
        double[] dArray = ocb15e077143.\u00f3();
        return ocd84af7ddf8.\u00d8(oc594a6660f7.\u0498.thePlayer.motionX + dArray[0], oc594a6660f7.\u0498.thePlayer.motionZ + dArray[1]);
    }

    private boolean \u00c7() {
        int n;
        block57: {
            block56: {
                int n2;
                block54: {
                    block55: {
                        block53: {
                            oc594a6660f7 oc594a6660f72;
                            block51: {
                                block52: {
                                    int n3;
                                    block50: {
                                        occ2f8dff8d8 occ2f8dff8d82;
                                        block48: {
                                            block49: {
                                                boolean bl;
                                                block47: {
                                                    oc594a6660f7 oc594a6660f73;
                                                    block45: {
                                                        block46: {
                                                            boolean bl2;
                                                            block44: {
                                                                block42: {
                                                                    block43: {
                                                                        n2 = oc84f20a0bc5.\u0117;
                                                                        oc594a6660f73 = this;
                                                                        if (n2 != 0) break block42;
                                                                        if (!oc594a6660f73.\u00da.\u01ed()) break block43;
                                                                        bl2 = oc594a6660f7.\u0498.gameSettings.keyBindForward.isKeyDown();
                                                                        if (n2 != 0) break block44;
                                                                        if (!bl2) break block43;
                                                                        return false;
                                                                    }
                                                                    oc594a6660f73 = this;
                                                                }
                                                                if (n2 != 0) break block45;
                                                                bl2 = oc594a6660f73.\u044b.\u01ed();
                                                            }
                                                            if (!bl2) break block46;
                                                            bl = oc594a6660f7.\u0498.gameSettings.keyBindJump.isKeyDown();
                                                            if (n2 != 0) break block47;
                                                            if (!bl) break block46;
                                                            return false;
                                                        }
                                                        oc594a6660f73 = this;
                                                    }
                                                    occ2f8dff8d82 = oc594a6660f73.\u0210;
                                                    if (n2 != 0) break block48;
                                                    bl = occ2f8dff8d82.\u01ed();
                                                }
                                                if (!bl) break block49;
                                                float f = oc594a6660f7.\u0498.thePlayer.rotationPitch - 69.0f;
                                                n3 = f == 0.0f ? 0 : (f < 0.0f ? -1 : 1);
                                                if (n2 != 0) break block50;
                                                if (n3 >= 0) break block49;
                                                return false;
                                            }
                                            oc594a6660f72 = this;
                                            if (n2 != 0) break block51;
                                            occ2f8dff8d82 = oc594a6660f72.\u0103;
                                        }
                                        n3 = occ2f8dff8d82.\u01ed();
                                    }
                                    if (n3 == 0) break block52;
                                    n = oc594a6660f7.\u0498.gameSettings.keyBindSneak.getKeyCode();
                                    if (n2 != 0) break block53;
                                    if (Keyboard.isKeyDown(n)) break block52;
                                    return false;
                                }
                                oc594a6660f72 = this;
                            }
                            n = oc594a6660f72.\u01b0.\u01ed();
                        }
                        if (n2 != 0) break block54;
                        if (n == 0) break block55;
                        n = oc7fbc83d9b3.\u0145() ? 1 : 0;
                        if (n2 != 0) break block54;
                        if (n == 0) break block56;
                    }
                    n = oc594a6660f7.\u0498.thePlayer.onGround ? 1 : 0;
                }
                if (n2 != 0) break block57;
                if (n == 0) break block56;
                n = 1;
                break block57;
            }
            n = 0;
        }
        return n != 0;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @oc66fa4f2195
    public void \u02a0(oc9adb807c19 oc9adb807c192) {
        block23: {
            oc594a6660f7 oc594a6660f72;
            int n;
            block22: {
                block20: {
                    block21: {
                        block19: {
                            boolean bl;
                            block18: {
                                n = oc84f20a0bc5.\u0117;
                                bl = this.z$3rzb3dil7uydr();
                                if (n != 0) break block18;
                                if (!bl) return;
                                bl = oc7ab2161b9f.\u00d0();
                            }
                            if (bl && oc9adb807c192.\u04b0 == oc110d7f376c.START) break block19;
                            return;
                        }
                        oc594a6660f72 = this;
                        if (n != 0) break block20;
                        if (oc594a6660f72.\u0432 <= 0) break block21;
                        --this.\u0432;
                    }
                    oc594a6660f72 = this;
                }
                if (n != 0) break block22;
                if (oc594a6660f72.\u0432 != 0) return;
                oc594a6660f72 = this;
            }
            if (n != 0) break block23;
            if (!oc594a6660f72.g()) return;
            oc594a6660f72 = this;
        }
        oc594a6660f72.\u0432 = RandomUtils.nextInt((int)this.\u0578.\u04c1(), (int)this.\u0225.\u04c1() + 1);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @oc66fa4f2195
    public void \u0178(oc52918cda9d oc52918cda9d2) {
        block33: {
            oc594a6660f7 oc594a6660f72;
            block32: {
                int n;
                block31: {
                    boolean bl;
                    block30: {
                        block27: {
                            Minecraft minecraft;
                            block29: {
                                block28: {
                                    n = oc84f20a0bc5.\u0117;
                                    boolean bl2 = this.z$3rzb3dil7uydr();
                                    if (n == 0) {
                                        if (!bl2) return;
                                        bl2 = oc7ab2161b9f.\u00d0();
                                    }
                                    if (!bl2) return;
                                    if (oc594a6660f7.\u0498.currentScreen != null) {
                                        return;
                                    }
                                    bl = this.\u0103.\u01ed();
                                    if (n != 0) break block27;
                                    if (!bl) break block28;
                                    minecraft = \u0498;
                                    if (n != 0) break block29;
                                    if (!Keyboard.isKeyDown(minecraft.gameSettings.keyBindSneak.getKeyCode())) break block28;
                                    bl = this.\u00c7();
                                    if (n != 0) break block27;
                                    if (bl) {
                                        oc594a6660f7.\u0498.thePlayer.movementInput.sneak = false;
                                        oc594a6660f7.\u0498.thePlayer.movementInput.moveForward /= 0.3f;
                                        oc594a6660f7.\u0498.thePlayer.movementInput.moveStrafe /= 0.3f;
                                    }
                                }
                                minecraft = \u0498;
                            }
                            bl = minecraft.thePlayer.movementInput.sneak;
                        }
                        if (n != 0) break block30;
                        if (bl) return;
                        oc594a6660f72 = this;
                        if (n != 0) break block31;
                        bl = oc594a6660f72.\u00c7();
                    }
                    if (!bl) return;
                    oc594a6660f72 = this;
                }
                if (n != 0) break block32;
                if (oc594a6660f72.\u0432 > 0) break block33;
                oc594a6660f72 = this;
            }
            if (!oc594a6660f72.g()) return;
        }
        oc594a6660f7.\u0498.thePlayer.movementInput.sneak = true;
        oc594a6660f7.\u0498.thePlayer.movementInput.moveStrafe *= 0.3f;
        oc594a6660f7.\u0498.thePlayer.movementInput.moveForward *= 0.3f;
    }

    public int \u04b1() {
        return this.\u0432;
    }
}

