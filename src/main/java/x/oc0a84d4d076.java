/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiInventory;
import x.N;
import x.oc2293828463;
import x.oc2922be51da;
import x.oc38b953058a;
import x.oc583347ab0c;
import x.oc66fa4f2195;
import x.oc69da1aa7f5;
import x.oc84f20a0bc5;
import x.oca6aec23846;
import x.oca9cc61aada;
import x.ocb23d192a35;
import x.ocbab3c9954b;
import x.ocbdbdd50a41;
import x.ocbe2a32e326;
import x.occ2f8dff8d8;
import x.ocd299de7725;
import x.oce4cea752dd;
import x.ocf5b7e839f8;

public class oc0a84d4d076
extends oc69da1aa7f5 {
    private final ocb23d192a35 \u0407;
    private final occ2f8dff8d8 \u0408;
    private final occ2f8dff8d8 \u049b;
    private final oca9cc61aada \u0547;
    private final oca9cc61aada S;
    private final oca9cc61aada \u0196;
    private final oca9cc61aada \u0464;
    private final occ2f8dff8d8 \u0225;
    private final oc2293828463 \u0275 = new oc2293828463();
    private final ocd299de7725 l = new ocd299de7725();
    private final ocd299de7725 \u047a = new ocd299de7725();
    private final ocd299de7725 \u0193 = new ocd299de7725();
    private final ocd299de7725 \u00ff = new ocd299de7725();
    private final ocd299de7725 \u016f = new ocd299de7725();
    private final ocd299de7725 \u0222 = new ocd299de7725();
    private final ocbdbdd50a41 \u01e0 = new ocbdbdd50a41();
    private boolean \u010b;
    private boolean \u04c1;
    private boolean \u025c;
    private boolean \u053c;
    private boolean \u04db;
    public static boolean A;

    public oc0a84d4d076() {
        super("Refill", oce4cea752dd.\u0437);
        this.\u0105("Automatically refill items in your inventory.");
        this.\u0407 = new ocb23d192a35("Active Keybind", 0);
        this.\u028c(this.\u0407);
        this.\u0408 = new occ2f8dff8d8("Potions", true);
        this.\u028c(this.\u0408);
        this.\u049b = new occ2f8dff8d8("Soups", true);
        this.\u028c(this.\u049b);
        this.\u0547 = new oca9cc61aada("Open Delay", 2.0, 0.0, 10.0, 0.1);
        this.\u028c(this.\u0547);
        this.S = new oca9cc61aada("Close Delay", 1.0, 0.0, 5.0, 0.1);
        this.\u028c(this.S);
        this.\u0196 = new oca9cc61aada("Min Speed", 1.5, 1.0, 10.0, 0.1);
        this.\u028c(this.\u0196);
        this.\u0464 = new oca9cc61aada("Max Speed", 2.5, 1.0, 10.0, 0.1);
        this.\u028c(this.\u0464);
        this.\u0225 = new occ2f8dff8d8("Dynamic", true);
        this.\u028c(this.\u0225);
        this.z$2u87utkr1isxg();
    }

    @Override
    public void guiButtonToggled(occ2f8dff8d8 occ2f8dff8d82) {
        this.z$2u87utkr1isxg();
    }

    @Override
    public void z$3tl278wzjcayb(N n) {
        if (n instanceof oca9cc61aada) {
            this.z$1sehylui0i4ix((oca9cc61aada)n);
        }
        this.z$2u87utkr1isxg();
    }

    @Override
    public void z$1sehylui0i4ix(oca9cc61aada oca9cc61aada2) {
        block21: {
            oca9cc61aada oca9cc61aada3;
            block23: {
                int n;
                block22: {
                    oc0a84d4d076 oc0a84d4d0762;
                    block18: {
                        block20: {
                            block19: {
                                n = oc84f20a0bc5.\u0117;
                                oca9cc61aada3 = oca9cc61aada2;
                                oc0a84d4d0762 = this;
                                if (n != 0) break block18;
                                if (oca9cc61aada3 != oc0a84d4d0762.\u0196) break block19;
                                oca9cc61aada3 = this.\u0196;
                                if (n != 0) break block20;
                                if (!(oca9cc61aada3.\u04c1() > this.\u0464.\u04c1())) break block19;
                                this.\u0464.\u021e(this.\u0196.\u04c1());
                                if (n == 0) break block21;
                            }
                            oca9cc61aada3 = oca9cc61aada2;
                        }
                        if (n != 0) break block22;
                        oc0a84d4d0762 = this;
                    }
                    if (oca9cc61aada3 != oc0a84d4d0762.\u0464) break block21;
                    oca9cc61aada3 = this.\u0464;
                }
                if (n != 0) break block23;
                if (!(oca9cc61aada3.\u04c1() < this.\u0196.\u04c1())) break block21;
                oca9cc61aada3 = this.\u0196;
            }
            oca9cc61aada3.\u021e(this.\u0464.\u04c1());
        }
    }

    @Override
    public void onEnable() {
        this.\u0275.\u01b2();
        this.\u010b = false;
        this.\u04c1 = false;
        this.\u025c = false;
        this.\u053c = false;
        this.\u04db = false;
    }

    @Override
    public void onDisable() {
        this.\u0129();
        this.\u0275.\u01b2();
        this.\u04c1 = false;
        this.\u04db = false;
    }

    private void \u0129() {
        block22: {
            oc0a84d4d076 oc0a84d4d0762;
            block20: {
                block21: {
                    int n;
                    block18: {
                        block19: {
                            n = oc84f20a0bc5.\u0117;
                            oc0a84d4d0762 = this;
                            if (n != 0) break block18;
                            if (!oc0a84d4d0762.\u053c) break block19;
                            if (oc69da1aa7f5.\u0151.thePlayer == null) break block19;
                            oc0a84d4d0762 = this;
                            if (n != 0) break block18;
                            if (!oc0a84d4d0762.\u054c(0, 0x8C93B6B1 ^ 0x8C93B6B8)) break block19;
                            this.\u04db = false;
                        }
                        oc0a84d4d0762 = this;
                    }
                    if (n != 0) break block20;
                    if (!oc0a84d4d0762.\u025c) break block21;
                    oc2922be51da.\u023d(oc69da1aa7f5.\u0151.gameSettings.keyBindInventory, 0);
                    if (n != 0) break block22;
                    if (!(oc69da1aa7f5.\u0151.currentScreen instanceof GuiInventory)) break block21;
                    oc2922be51da.\u0446(oc69da1aa7f5.\u0151.currentScreen);
                }
                this.\u010b = false;
                this.\u025c = false;
                this.\u053c = false;
                oc0a84d4d0762 = this;
            }
            ocf5b7e839f8.\u0130(oc0a84d4d0762);
        }
    }

    @Override
    public void z$2u87utkr1isxg() {
        boolean bl;
        oca9cc61aada oca9cc61aada2;
        block6: {
            block7: {
                boolean bl2;
                oca9cc61aada oca9cc61aada3;
                int n;
                block4: {
                    block5: {
                        n = oc84f20a0bc5.\u0117;
                        oca9cc61aada3 = this.\u0196;
                        bl2 = this.\u0225.\u01ed();
                        if (n != 0) break block4;
                        if (bl2) break block5;
                        bl2 = true;
                        break block4;
                    }
                    bl2 = false;
                }
                oca9cc61aada3.\u0209(bl2, this);
                oca9cc61aada2 = this.\u0464;
                bl = this.\u0225.\u01ed();
                if (n != 0) break block6;
                if (bl) break block7;
                bl = true;
                break block6;
            }
            bl = false;
        }
        oca9cc61aada2.\u0209(bl, this);
    }

    private boolean \u0433() {
        int n;
        block19: {
            int n2;
            int n3;
            block17: {
                int n4;
                block18: {
                    boolean bl;
                    block15: {
                        block16: {
                            n3 = oc84f20a0bc5.\u0117;
                            bl = this.\u049b.\u01ed();
                            if (n3 != 0) break block15;
                            if (!bl) break block16;
                            bl = this.\u054c(0, 0x1B2CBE41 ^ 0x1B2CBE48);
                            if (n3 != 0) break block15;
                            if (bl) break block16;
                            n4 = this.\u054c(0x1B2CBE41 ^ 0x1B2CBE48, 0x1B2CBE6C ^ 0x1B2CBE48);
                            if (n3 != 0) break block17;
                            if (n4 != 0) break block18;
                        }
                        bl = false;
                    }
                    return bl;
                }
                n4 = n2 = 0;
            }
            while (n2 < (0x1B2CBE41 ^ 0x1B2CBE48)) {
                block21: {
                    boolean bl;
                    block20: {
                        n = oc2922be51da.\u0446(oc69da1aa7f5.\u0151.thePlayer.inventory.getStackInSlot(n2));
                        if (n3 != 0) break block19;
                        if (n3 != 0) break block20;
                        if (n != 0) break block21;
                        bl = true;
                    }
                    return bl;
                }
                ++n2;
                if (n3 == 0) continue;
            }
            n = 0;
        }
        return n != 0;
    }

    private boolean \u054c(int n, int n2) {
        int n3;
        block7: {
            int n4 = oc84f20a0bc5.\u0117;
            for (int i = n; i < n2; ++i) {
                boolean bl;
                block8: {
                    n3 = oc2922be51da.\u0446(oc69da1aa7f5.\u0151.thePlayer.inventory.getStackInSlot(i));
                    if (n4 != 0) break block7;
                    if (n4 != 0) break block8;
                    if (!ocbe2a32e326.\u0206(n3)) continue;
                    bl = true;
                }
                return bl;
            }
            n3 = 0;
        }
        return n3 != 0;
    }

    private static double \u0420(float f, float f2) {
        double d;
        block4: {
            block5: {
                double d2 = (double)f - (double)f2;
                int n = oc84f20a0bc5.\u0117;
                d = d2;
                if (n != 0) break block4;
                if (!(d > 0.0)) break block5;
                d = d2;
                break block4;
            }
            d = 0.0;
        }
        return d;
    }

    @oc66fa4f2195
    public void \u0166(oca6aec23846 oca6aec238462) {
        boolean bl;
        boolean bl2;
        oc583347ab0c oc583347ab0c2;
        oc38b953058a oc38b953058a2;
        oc2293828463 oc22938284632;
        block68: {
            block67: {
                oc0a84d4d076 oc0a84d4d0762;
                int n;
                block66: {
                    block53: {
                        boolean bl3;
                        block65: {
                            oc0a84d4d076 oc0a84d4d0763;
                            block69: {
                                block63: {
                                    boolean bl4;
                                    block60: {
                                        block64: {
                                            block61: {
                                                boolean bl5;
                                                block62: {
                                                    block58: {
                                                        boolean bl6;
                                                        block59: {
                                                            boolean bl7;
                                                            block57: {
                                                                block56: {
                                                                    oc0a84d4d076 oc0a84d4d0764;
                                                                    block55: {
                                                                        block54: {
                                                                            boolean bl8;
                                                                            block52: {
                                                                                boolean bl9;
                                                                                boolean bl10;
                                                                                block51: {
                                                                                    block50: {
                                                                                        block49: {
                                                                                            bl10 = this.\u0407.\u0190();
                                                                                            n = oc84f20a0bc5.\u0117;
                                                                                            bl9 = bl10;
                                                                                            if (n != 0) break block49;
                                                                                            if (!bl9) break block50;
                                                                                            bl9 = this.\u04c1;
                                                                                        }
                                                                                        if (n != 0) break block51;
                                                                                        if (bl9) break block50;
                                                                                        bl9 = true;
                                                                                        break block51;
                                                                                    }
                                                                                    bl9 = false;
                                                                                }
                                                                                bl6 = bl9;
                                                                                this.\u04c1 = bl10;
                                                                                bl8 = this.\u010b;
                                                                                if (n != 0) break block52;
                                                                                if (bl8) break block53;
                                                                                bl8 = oc2922be51da.\u047c();
                                                                            }
                                                                            if (bl8 && oc69da1aa7f5.\u0151.currentScreen == null) break block54;
                                                                            return;
                                                                        }
                                                                        oc0a84d4d0764 = this;
                                                                        if (n != 0) break block55;
                                                                        if (oc0a84d4d0764.\u0407.\u01fa() != 0) break block56;
                                                                        oc0a84d4d0764 = this;
                                                                    }
                                                                    bl7 = oc0a84d4d0764.\u0433();
                                                                    if (n != 0) break block57;
                                                                    if (!bl7) break block56;
                                                                    bl7 = true;
                                                                    break block57;
                                                                }
                                                                bl7 = false;
                                                            }
                                                            bl3 = bl7;
                                                            bl4 = bl3;
                                                            if (n != 0) break block58;
                                                            if (bl4) break block59;
                                                            this.\u04db = false;
                                                        }
                                                        bl4 = bl6;
                                                    }
                                                    if (n != 0) break block60;
                                                    if (bl4) break block61;
                                                    bl5 = bl3;
                                                    if (n != 0) break block62;
                                                    if (!bl5) break block63;
                                                    oc0a84d4d0763 = this;
                                                    if (n != 0) break block64;
                                                    bl5 = oc0a84d4d0763.\u04db;
                                                }
                                                if (bl5) break block63;
                                            }
                                            oc0a84d4d0763 = this;
                                        }
                                        if (n != 0) break block65;
                                        bl4 = ocf5b7e839f8.\u04e1(oc0a84d4d0763);
                                    }
                                    if (bl4) break block69;
                                }
                                return;
                            }
                            this.\u0275.\u01b2();
                            this.\u010b = true;
                            this.\u053c = bl3;
                            oc0a84d4d0763 = this;
                        }
                        oc0a84d4d0763.\u04db = bl3;
                    }
                    oc38b953058a oc38b953058a3 = new oc38b953058a(this);
                    oc22938284632 = this.\u0275;
                    oc38b953058a2 = oc38b953058a3;
                    oc583347ab0c2 = new oc583347ab0c(this);
                    bl2 = this.\u049b.\u01ed();
                    oc0a84d4d0762 = this;
                    if (n != 0) break block66;
                    if (!oc0a84d4d0762.\u0408.\u01ed()) break block67;
                    oc0a84d4d0762 = this;
                }
                bl = oc0a84d4d0762.\u053c;
                if (n != 0) break block68;
                if (bl) break block67;
                bl = true;
                break block68;
            }
            bl = false;
        }
        if (oc22938284632.\u025f(oc38b953058a2, oc583347ab0c2, bl2, bl, (float)this.\u0547.\u04c1(), (float)this.S.\u04c1(), (float)this.\u0196.\u04c1(), (float)this.\u0464.\u04c1(), this.\u0225.\u01ed())) {
            oc2922be51da.\u04bb();
        }
    }

    @oc66fa4f2195
    public void \u0253(ocbab3c9954b ocbab3c9954b2) {
        this.\u0129();
        this.\u0275.\u01b2();
        this.\u04c1 = false;
        this.\u04db = false;
    }

    static /* synthetic */ Minecraft \u03e4() {
        return oc69da1aa7f5.\u0151;
    }

    static /* synthetic */ Minecraft \u00ee() {
        return oc69da1aa7f5.\u0151;
    }

    static /* synthetic */ Minecraft \u0389() {
        return oc69da1aa7f5.\u0151;
    }

    static /* synthetic */ Minecraft \u0427() {
        return oc69da1aa7f5.\u0151;
    }

    static /* synthetic */ Minecraft \u045c() {
        return oc69da1aa7f5.\u0151;
    }

    static /* synthetic */ Minecraft \u04a1() {
        return oc69da1aa7f5.\u0151;
    }

    static /* synthetic */ Minecraft \u0248() {
        return oc69da1aa7f5.\u0151;
    }
}

