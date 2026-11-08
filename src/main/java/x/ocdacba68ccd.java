/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.awt.Color;
import net.minecraft.client.Minecraft;
import x.N;
import x.oc110d7f376c;
import x.oc25aa89b91f;
import x.oc2f61de30bc;
import x.oc44d28ffc47;
import x.oc47731c13e2;
import x.oc47f1ce248c;
import x.oc58525a3389;
import x.oc6031c5c531;
import x.oc66fa4f2195;
import x.oc69da1aa7f5;
import x.oc6c7463093f;
import x.oc746a23b244;
import x.oc7ab2161b9f;
import x.oc8ce2882092;
import x.oc9d4393f3ce;
import x.oc9fb3e9bae3;
import x.oca0802ec324;
import x.oca9cc61aada;
import x.ocbab3c9954b;
import x.ocbd4917c4b1;
import x.occ2f8dff8d8;
import x.occ4cc45f579;
import x.ocd28580117c;
import x.oce4cea752dd;
import x.oce79181588d;
import x.ocf923d5a814;

public abstract class ocdacba68ccd
extends oc69da1aa7f5 {
    private static final String[] \u03bb;
    private final oca9cc61aada \u03e6;
    private final oca9cc61aada \u0432;
    private final oca9cc61aada \u04ca;
    private final oca9cc61aada \u04c8;
    private final occ2f8dff8d8 \u01ec;
    private final occ2f8dff8d8 \u04a1;
    private final occ2f8dff8d8 \u048a;
    private final oc6031c5c531[] \u0376;
    private oc6031c5c531 \u0386;
    private boolean \u0191;
    private double \u0226;
    private boolean \u010b;
    public static int \u020b;

    protected ocdacba68ccd() {
        super("Fly", oce4cea752dd.\u0495, 0);
        this.\u0105("Lets you fly using the selected movement mode.");
        this.\u03e6 = new oca9cc61aada("Fly", 0, \u03bb);
        this.z$1k81rl22ylo65(this.\u03e6, "setting.mode");
        this.\u0432 = new oca9cc61aada("Horizontal speed", 2.0, 1.0, 9.0, 0.1);
        this.z$1k81rl22ylo65(this.\u0432, "setting.horizontalSpeed");
        this.\u04ca = new oca9cc61aada("Vertical speed", 2.0, 1.0, 9.0, 0.1);
        this.z$1k81rl22ylo65(this.\u04ca, "setting.verticalSpeed");
        occ4cc45f579 occ4cc45f5792 = new occ4cc45f579(this);
        oc44d28ffc47 oc44d28ffc472 = new oc44d28ffc47(this);
        oc9fb3e9bae3 oc9fb3e9bae32 = new oc9fb3e9bae3(this);
        oc47f1ce248c oc47f1ce248c2 = new oc47f1ce248c(this);
        oca0802ec324 oca0802ec3242 = new oca0802ec324(this);
        oc47731c13e2 oc47731c13e22 = new oc47731c13e2(this);
        ocd28580117c ocd28580117c2 = new ocd28580117c(this);
        oc6031c5c531[] oc6031c5c531Array = new oc6031c5c531[0x3C18F989 ^ 0x3C18F98E];
        oc6031c5c531Array[0] = occ4cc45f5792;
        oc6031c5c531Array[1] = oc44d28ffc472;
        oc6031c5c531Array[0x3C18F98C ^ 0x3C18F98E] = oc9fb3e9bae32;
        oc6031c5c531Array[0x3C18F98D ^ 0x3C18F98E] = oc47f1ce248c2;
        oc6031c5c531Array[0x3C18F98A ^ 0x3C18F98E] = oca0802ec3242;
        oc6031c5c531Array[0x3C18F98B ^ 0x3C18F98E] = oc47731c13e22;
        oc6031c5c531Array[0x3C18F988 ^ 0x3C18F98E] = ocd28580117c2;
        this.\u0376 = oc6031c5c531Array;
        this.\u04c8 = new oca9cc61aada("MaxFlyTicks", 15.0, 5.0, 30.0, 1.0);
        this.z$1k81rl22ylo65(this.\u04c8, "setting.maxFlyTicks");
        this.\u01ec = new occ2f8dff8d8("Show BPS", false);
        this.z$1k81rl22ylo65(this.\u01ec, "setting.showBPS");
        this.\u04a1 = new occ2f8dff8d8("Stop motion", false);
        this.z$1k81rl22ylo65(this.\u04a1, "setting.stopMotion");
        this.z$1k81rl22ylo65(oc47f1ce248c2.\u0460, "setting.keepY");
        this.\u048a = new occ2f8dff8d8("Mark", true);
        this.z$1k81rl22ylo65(this.\u048a, "setting.mark");
        this.z$1k81rl22ylo65(oca0802ec3242.\u043c, "setting.intaveMotionMode");
        this.z$1k81rl22ylo65(oc47731c13e22.\u03ca, "setting.intaveGlideLoops");
        this.z$1k81rl22ylo65(ocd28580117c2.\u04c9, "setting.grimFireBallMode");
        this.z$1k81rl22ylo65(ocd28580117c2.\u01b3, "setting.grimGlideLoops");
        this.\u00c3();
        this.z$2u87utkr1isxg();
    }

    public final boolean \u050d(String string) {
        return this.\u0575().\u0533().equals(string);
    }

    public final double \u0421() {
        return this.\u0432.\u04c1();
    }

    public final double \u0428() {
        return this.\u04ca.\u04c1();
    }

    public final int M() {
        return (int)this.\u04c8.\u04c1();
    }

    @Override
    public String getInfo() {
        this.\u00c3();
        return this.\u0386.\u0533();
    }

    @Override
    public void z$2u87utkr1isxg() {
        boolean bl;
        occ2f8dff8d8 occ2f8dff8d82;
        int n;
        block13: {
            block12: {
                ocdacba68ccd ocdacba68ccd2;
                block11: {
                    this.\u00c3();
                    n = oc6031c5c531.\u01ca;
                    this.\u0432.\u0209(this.\u0386.z$sdj84ne38bfn(), this);
                    this.\u04ca.\u0209(this.\u0386.z$sdj84ne38bfn(), this);
                    this.\u04c8.\u0209(this.\u0386.z$3hzq8op22ljmt(), this);
                    occ2f8dff8d82 = this.\u04a1;
                    ocdacba68ccd2 = this;
                    if (n != 0) break block11;
                    if (!ocdacba68ccd2.\u0386.z$th2zwshf7gtl()) break block12;
                    ocdacba68ccd2 = this;
                }
                bl = ocdacba68ccd2.\u050d("IntaveFlagFly");
                if (n != 0) break block13;
                if (bl) break block12;
                bl = true;
                break block13;
            }
            bl = false;
        }
        occ2f8dff8d82.\u0209(bl, this);
        this.\u048a.\u0209(true, this);
        for (oc6031c5c531 oc6031c5c5312 : this.\u0376) {
            oc6031c5c531 oc6031c5c5313 = oc6031c5c5312;
            boolean bl2 = oc6031c5c5312 == this.\u0386;
            oc6031c5c5313.z$3g18l332rzhcd(bl2);
            if (n == 0) continue;
            boolean bl3 = !false;
            oc69da1aa7f5.\u04ac = bl3;
            break;
        }
    }

    @Override
    public void guiButtonToggled(occ2f8dff8d8 occ2f8dff8d82) {
        super.guiButtonToggled(occ2f8dff8d82);
        this.\u0386.R(occ2f8dff8d82);
        this.z$2u87utkr1isxg();
    }

    @Override
    public void z$1sehylui0i4ix(oca9cc61aada oca9cc61aada2) {
        this.\u00c3();
        this.\u0386.\u0567(oca9cc61aada2);
        this.z$2u87utkr1isxg();
    }

    @Override
    public void z$3tl278wzjcayb(N n) {
        this.\u00c3();
        this.\u0386.\u0567(n);
        this.z$2u87utkr1isxg();
    }

    @Override
    public void onEnable() {
        int n;
        block11: {
            block9: {
                block10: {
                    n = oc6031c5c531.\u01ca;
                    this.\u00c3();
                    if (n != 0) break block9;
                    this.\u0191 = true;
                    if (oc69da1aa7f5.\u0151 == null) break block10;
                    if (oc69da1aa7f5.\u0151.thePlayer != null) break block11;
                }
                this.z$2u87utkr1isxg();
            }
            return;
        }
        this.\u0226 = oc69da1aa7f5.\u0151.thePlayer.posY;
        this.\u010b = oc69da1aa7f5.\u0151.thePlayer.capabilities.isFlying;
        this.\u0386.z$30uo8shdqe5to();
        this.z$2u87utkr1isxg();
        if (false) {
            oc6031c5c531.\u01ca = ++n;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void onDisable() {
        block28: {
            block30: {
                Minecraft minecraft;
                int n;
                block29: {
                    ocdacba68ccd ocdacba68ccd2;
                    block27: {
                        ocdacba68ccd ocdacba68ccd3;
                        block21: {
                            block22: {
                                Minecraft minecraft2;
                                block25: {
                                    block26: {
                                        block24: {
                                            block23: {
                                                n = oc6031c5c531.\u01ca;
                                                ocdacba68ccd3 = this;
                                                if (n == 0) {
                                                    if (ocdacba68ccd3.\u0386 == null) {
                                                        this.\u0191 = false;
                                                        return;
                                                    }
                                                    ocdacba68ccd3 = this;
                                                }
                                                if (n != 0) break block21;
                                                if (!(ocdacba68ccd3.\u0386 instanceof oc9fb3e9bae3)) break block22;
                                                minecraft2 = oc69da1aa7f5.\u0151;
                                                if (n != 0) break block23;
                                                if (minecraft2 == null) break block24;
                                                minecraft2 = oc69da1aa7f5.\u0151;
                                            }
                                            if (n != 0) break block25;
                                            if (minecraft2.thePlayer != null) break block26;
                                        }
                                        this.\u0191 = false;
                                        return;
                                    }
                                    oc69da1aa7f5.\u0151.thePlayer.motionX = 0.0;
                                    oc69da1aa7f5.\u0151.thePlayer.motionY = 0.0;
                                    oc69da1aa7f5.\u0151.thePlayer.motionZ = 0.0;
                                    oc69da1aa7f5.\u0151.thePlayer.capabilities.isFlying = this.\u010b;
                                    oc69da1aa7f5.\u0151.getTimer().timerSpeed = 1.0f;
                                    minecraft2 = oc69da1aa7f5.\u0151;
                                }
                                minecraft2.thePlayer.setSpeedInAir(0.02f);
                                this.\u0386.z$1q0da71f8mrae();
                                this.\u0191 = false;
                                return;
                            }
                            this.\u0386.z$1q0da71f8mrae();
                            ocdacba68ccd2 = this;
                            if (n != 0) break block27;
                            ocdacba68ccd2.\u0191 = false;
                            ocdacba68ccd3 = this;
                        }
                        if (!ocdacba68ccd3.\u0386.z$th2zwshf7gtl()) break block28;
                        ocdacba68ccd2 = this;
                    }
                    if (!ocdacba68ccd2.\u04a1.\u01ed()) break block28;
                    minecraft = oc69da1aa7f5.\u0151;
                    if (n != 0) break block29;
                    if (minecraft == null) break block28;
                    minecraft = oc69da1aa7f5.\u0151;
                }
                if (n != 0) break block30;
                if (minecraft.thePlayer == null) break block28;
                oc69da1aa7f5.\u0151.thePlayer.motionX = 0.0;
                oc69da1aa7f5.\u0151.thePlayer.motionY = 0.0;
                minecraft = oc69da1aa7f5.\u0151;
            }
            minecraft.thePlayer.motionZ = 0.0;
        }
    }

    @Override
    public void z$1m9j3ewef9s() {
        this.\u00c3();
        this.\u0386.z$16gekk6u5hb3u();
    }

    @oc66fa4f2195
    public void \u02a9(oc2f61de30bc oc2f61de30bc2) {
        this.\u00c3();
        this.\u0386.z$2chcnix6dewx9(oc2f61de30bc2);
    }

    @oc66fa4f2195(priority=oc8ce2882092.LOWEST)
    public void \u044c(oc25aa89b91f oc25aa89b91f2) {
        this.\u00c3();
        this.\u0386.z$f8mk1haurfvq(oc25aa89b91f2);
    }

    @oc66fa4f2195
    public void \u0575(oc58525a3389 oc58525a33892) {
        this.\u00c3();
        this.\u0386.z$1ofn7mpfow52n(oc58525a33892);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @oc66fa4f2195(priority=oc8ce2882092.HIGHEST, receiveCanceled=true)
    public void \u04a4(oce79181588d oce79181588d2) {
        Minecraft minecraft;
        block5: {
            int n = oc6031c5c531.\u01ca;
            minecraft = oc69da1aa7f5.\u0151;
            if (n != 0) break block5;
            if (minecraft == null) return;
            minecraft = oc69da1aa7f5.\u0151;
        }
        if (minecraft.thePlayer == null) {
            return;
        }
        this.\u00c3();
        this.\u0386.z$28gl8df6dqh8o(oce79181588d2);
    }

    @oc66fa4f2195(priority=oc8ce2882092.HIGHEST, receiveCanceled=true)
    public void \u0401(oc9d4393f3ce oc9d4393f3ce2) {
        this.\u00c3();
        this.\u0386.z$eqd7gcilc76w(oc9d4393f3ce2);
    }

    @oc66fa4f2195
    public void \u0228(oc6c7463093f oc6c7463093f2) {
        this.\u00c3();
        this.\u0386.z$1ygb8gyji3zuv(oc6c7463093f2);
    }

    @oc66fa4f2195
    public void \u03c2(oc746a23b244 oc746a23b2442) {
        ocdacba68ccd ocdacba68ccd2;
        block15: {
            block16: {
                block13: {
                    boolean bl;
                    block14: {
                        int n;
                        block12: {
                            this.\u00c3();
                            n = oc6031c5c531.\u01ca;
                            bl = this.\u048a.\u01ed();
                            if (n != 0) break block12;
                            if (!bl) break block13;
                            bl = oc7ab2161b9f.\u00d0();
                        }
                        if (n != 0) break block14;
                        if (!bl) break block13;
                        ocdacba68ccd2 = this;
                        if (n != 0) break block15;
                        bl = ocdacba68ccd2.\u050d("Vanilla");
                    }
                    if (!bl) break block16;
                }
                return;
            }
            ocdacba68ccd2 = this;
        }
        double d = ocdacba68ccd2.\u0226 + 2.0;
        Color color = oc69da1aa7f5.\u0151.thePlayer.getEntityBoundingBox().maxY < d ? new Color(0, 0x487A436 ^ 0x487A4C9, 0, 0x487A493 ^ 0x487A4C9) : new Color(0x487A436 ^ 0x487A4C9, 0, 0, 0x487A493 ^ 0x487A4C9);
        Color color2 = color;
        ocbd4917c4b1.f(d, color2, 1.0);
        this.\u0386.\u0229(oc746a23b2442);
    }

    @oc66fa4f2195
    public void \u0505(ocf923d5a814 ocf923d5a8142) {
        boolean bl;
        block16: {
            block17: {
                block15: {
                    Minecraft minecraft;
                    int n;
                    block14: {
                        block13: {
                            block12: {
                                n = oc6031c5c531.\u01ca;
                                if (!this.\u01ec.\u01ed() || ocf923d5a8142.\u04b0 != oc110d7f376c.END) break block12;
                                if (oc7ab2161b9f.\u00d0()) break block13;
                            }
                            return;
                        }
                        minecraft = oc69da1aa7f5.\u0151;
                        if (n != 0) break block14;
                        if (minecraft.currentScreen != null) break block15;
                        minecraft = oc69da1aa7f5.\u0151;
                    }
                    bl = minecraft.gameSettings.showDebugInfo;
                    if (n != 0) break block16;
                    if (!bl) break block17;
                }
                return;
            }
            bl = true;
        }
        ocbd4917c4b1.\u0245(bl, false);
    }

    @oc66fa4f2195
    public void \u024a(ocbab3c9954b ocbab3c9954b2) {
        block5: {
            ocdacba68ccd ocdacba68ccd2;
            block4: {
                int n = oc6031c5c531.\u01ca;
                ocdacba68ccd2 = this;
                if (n != 0) break block4;
                if (ocdacba68ccd2.\u0386 == null) break block5;
                ocdacba68ccd2 = this;
            }
            ocdacba68ccd2.\u0386.z$rvfg1nz4abtc(ocbab3c9954b2);
        }
    }

    private oc6031c5c531 \u0575() {
        int n = Math.max(0, Math.min(this.\u0376.length - 1, (int)this.\u03e6.\u04c1()));
        return this.\u0376[n];
    }

    private void \u00c3() {
        block18: {
            ocdacba68ccd ocdacba68ccd2;
            block17: {
                ocdacba68ccd ocdacba68ccd3;
                block15: {
                    int n;
                    oc6031c5c531 oc6031c5c5312;
                    block16: {
                        oc6031c5c5312 = this.\u0575();
                        n = oc6031c5c531.\u01ca;
                        if (oc6031c5c5312 == this.\u0386) {
                            return;
                        }
                        ocdacba68ccd3 = this;
                        if (n != 0) break block15;
                        if (!ocdacba68ccd3.\u0191) break block16;
                        ocdacba68ccd3 = this;
                        if (n != 0) break block15;
                        if (ocdacba68ccd3.\u0386 == null) break block16;
                        this.\u0386.z$1q0da71f8mrae();
                    }
                    ocdacba68ccd2 = this;
                    if (n != 0) break block17;
                    ocdacba68ccd2.\u0386 = oc6031c5c5312;
                    ocdacba68ccd3 = this;
                }
                if (!ocdacba68ccd3.\u0191) break block18;
                ocdacba68ccd2 = this;
            }
            ocdacba68ccd2.\u0386.z$30uo8shdqe5to();
        }
    }

    static {
        String[] stringArray = new String[0xAB5B2F7E ^ 0xAB5B2F79];
        stringArray[0] = "Vanilla";
        stringArray[1] = "Fast";
        stringArray[0xAB5B2F7B ^ 0xAB5B2F79] = "IntaveFlagFly";
        stringArray[0xAB5B2F7A ^ 0xAB5B2F79] = "Walk";
        stringArray[0xAB5B2F7D ^ 0xAB5B2F79] = "IntaveFireBall";
        stringArray[0xAB5B2F7C ^ 0xAB5B2F79] = "IntaveFireBall2";
        stringArray[0xAB5B2F7F ^ 0xAB5B2F79] = "GrimFireBall";
        \u03bb = stringArray;
    }
}

