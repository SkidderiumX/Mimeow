/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.client.Minecraft;
import x.oc66fa4f2195;
import x.oc69da1aa7f5;
import x.oc70db705765;
import x.oc7ab2161b9f;
import x.oc8ce2882092;
import x.oce4cea752dd;

public class oc08521b8182
extends oc69da1aa7f5 {
    private boolean \u011e;
    private boolean \u0197;
    private boolean \u0522;
    private boolean \u0437;
    private int \u0244;
    private int \u04b5;
    public static boolean \u00fd;

    public oc08521b8182() {
        super("NullMove", oce4cea752dd.\u0495, 0);
        this.\u0105("Allows you to instantly switch directions when pressing multiple movement keys.");
    }

    @Override
    public void onDisable() {
        this.\u011e = false;
        this.\u0197 = false;
        this.\u0522 = false;
        this.\u0437 = false;
        this.\u0244 = 0;
        this.\u04b5 = 0;
    }

    @oc66fa4f2195(priority=oc8ce2882092.HIGH)
    public void \u0553(oc70db705765 oc70db7057652) {
        boolean bl;
        boolean bl2;
        boolean bl3;
        boolean bl4;
        block73: {
            float f;
            oc70db705765 oc70db7057653;
            block75: {
                block74: {
                    boolean bl5;
                    block72: {
                        boolean bl6;
                        block68: {
                            block69: {
                                float f2;
                                oc70db705765 oc70db7057654;
                                block71: {
                                    block70: {
                                        block66: {
                                            block67: {
                                                block64: {
                                                    block65: {
                                                        block62: {
                                                            block63: {
                                                                block60: {
                                                                    block61: {
                                                                        Minecraft minecraft;
                                                                        block58: {
                                                                            block59: {
                                                                                block76: {
                                                                                    block57: {
                                                                                        boolean bl7;
                                                                                        block56: {
                                                                                            bl6 = false;
                                                                                            bl7 = this.z$3rzb3dil7uydr();
                                                                                            if (bl6) break block56;
                                                                                            if (!bl7) break block57;
                                                                                            bl7 = oc7ab2161b9f.\u00d0();
                                                                                        }
                                                                                        if (bl7) break block76;
                                                                                    }
                                                                                    return;
                                                                                }
                                                                                minecraft = oc69da1aa7f5.\u0151;
                                                                                if (bl6) break block58;
                                                                                if (minecraft.currentScreen == null) break block59;
                                                                                return;
                                                                            }
                                                                            minecraft = oc69da1aa7f5.\u0151;
                                                                        }
                                                                        bl4 = minecraft.gameSettings.keyBindForward.isKeyDown();
                                                                        bl3 = oc69da1aa7f5.\u0151.gameSettings.keyBindBack.isKeyDown();
                                                                        bl2 = oc69da1aa7f5.\u0151.gameSettings.keyBindLeft.isKeyDown();
                                                                        bl = oc69da1aa7f5.\u0151.gameSettings.keyBindRight.isKeyDown();
                                                                        bl5 = bl4;
                                                                        if (bl6) break block60;
                                                                        if (!bl5) break block61;
                                                                        bl5 = this.\u011e;
                                                                        if (bl6) break block60;
                                                                        if (bl5) break block61;
                                                                        this.\u0244 = 1;
                                                                    }
                                                                    bl5 = bl3;
                                                                }
                                                                if (bl6) break block62;
                                                                if (!bl5) break block63;
                                                                bl5 = this.\u0197;
                                                                if (bl6) break block62;
                                                                if (bl5) break block63;
                                                                this.\u0244 = -1;
                                                            }
                                                            bl5 = bl2;
                                                        }
                                                        if (bl6) break block64;
                                                        if (!bl5) break block65;
                                                        bl5 = this.\u0522;
                                                        if (bl6) break block64;
                                                        if (bl5) break block65;
                                                        this.\u04b5 = 1;
                                                    }
                                                    bl5 = bl;
                                                }
                                                if (bl6) break block66;
                                                if (!bl5) break block67;
                                                bl5 = this.\u0437;
                                                if (bl6) break block66;
                                                if (bl5) break block67;
                                                this.\u04b5 = -1;
                                            }
                                            bl5 = bl4;
                                        }
                                        if (bl6) break block68;
                                        if (!bl5) break block69;
                                        bl5 = bl3;
                                        if (bl6) break block68;
                                        if (!bl5) break block69;
                                        oc70db7057654 = oc70db7057652;
                                        if (this.\u0244 < 0) break block70;
                                        f2 = 1.0f;
                                        break block71;
                                    }
                                    f2 = -1.0f;
                                }
                                oc70db7057654.\u010f(f2);
                            }
                            bl5 = bl2;
                        }
                        if (bl6) break block72;
                        if (!bl5) break block73;
                        bl5 = bl;
                    }
                    if (!bl5) break block73;
                    oc70db7057653 = oc70db7057652;
                    if (this.\u04b5 < 0) break block74;
                    f = 1.0f;
                    break block75;
                }
                f = -1.0f;
            }
            oc70db7057653.\u0524(f);
        }
        this.\u011e = bl4;
        this.\u0197 = bl3;
        this.\u0522 = bl2;
        this.\u0437 = bl;
    }
}

