/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.lang.reflect.Field;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.network.play.client.C03PacketPlayer;
import x.N;
import x.oc25aa89b91f;
import x.oc5e549848f3;
import x.oc6111f05032;
import x.oc66fa4f2195;
import x.oc69da1aa7f5;
import x.oc70db705765;
import x.oc7ab2161b9f;
import x.oc9755810e45;
import x.oc9d4393f3ce;
import x.oca59cf41fac;
import x.oca9cc61aada;
import x.ocbab3c9954b;
import x.occ2f8dff8d8;
import x.occ48acb5d22;
import x.occc831eff22;
import x.ocdd342096f8;
import x.oce4cea752dd;
import x.oce4fccf5a38;
import x.ocf873985fc3;

public class oc714cf0262c
extends oc69da1aa7f5 {
    private static final int \u00ca = 2;
    private static final int \u0159 = 3;
    private final oca9cc61aada \u03f5;
    private final oca9cc61aada \u051c;
    private final oca9cc61aada \u0296;
    private final oca9cc61aada \u012f;
    private final oca9cc61aada \u0536;
    private final oca9cc61aada \u047a;
    private final occc831eff22 \u01ff;
    private final occ2f8dff8d8 \u0584;
    private final occ2f8dff8d8 J;
    private static final String[] \u03e7;
    private long \u0149 = 0L;
    private final oca59cf41fac \u024a = new oca59cf41fac();
    public static int \u015c;

    public oc714cf0262c() {
        super("Criticals", oce4cea752dd.\u0201);
        this.\u0105("Increase the damage of your hits.");
        this.\u03f5 = new oca9cc61aada("Mode", 0, \u03e7);
        this.\u028c(this.\u03f5);
        this.\u051c = new oca9cc61aada("Delay", 0.0, 0.0, 500.0, 1.0);
        this.\u028c(this.\u051c);
        this.\u0296 = new oca9cc61aada("HurtTime", 10.0, 0.0, 10.0, 1.0);
        this.\u028c(this.\u0296);
        this.\u012f = new oca9cc61aada("Chance", "%", 100.0, 0.0, 100.0, 1.0);
        this.\u028c(this.\u012f);
        this.\u0536 = new oca9cc61aada("Timer speed", "x", 0.85, 0.5, 1.0, 0.01);
        this.\u028c(this.\u0536);
        this.\u047a = new oca9cc61aada("Boost", "ms", 0.0, 0.0, 250.0, 50.0);
        this.\u028c(this.\u047a);
        this.\u01ff = new occc831eff22("Conditions");
        this.\u028c(this.\u01ff);
        this.\u0584 = new occ2f8dff8d8(this.\u01ff, "Holding weapon", false);
        this.\u028c(this.\u0584);
        this.J = new occ2f8dff8d8(this.\u01ff, "Mouse pressed", false);
        this.\u028c(this.J);
        this.z$2u87utkr1isxg();
    }

    @Override
    public String getInfo() {
        return \u03e7[(int)this.\u03f5.\u04c1()];
    }

    @Override
    public void z$2u87utkr1isxg() {
        boolean bl;
        oca9cc61aada oca9cc61aada2;
        boolean bl2;
        block25: {
            block24: {
                int n;
                block23: {
                    boolean bl3;
                    oca9cc61aada oca9cc61aada3;
                    boolean bl4;
                    block22: {
                        block21: {
                            block20: {
                                boolean bl5;
                                block18: {
                                    block19: {
                                        int n2;
                                        block16: {
                                            block17: {
                                                n = oc5e549848f3.\u0130;
                                                n2 = (int)this.\u03f5.\u04c1();
                                                if (n != 0) break block16;
                                                if (n2 != (0x597C9427 ^ 0x597C9425)) break block17;
                                                n2 = 1;
                                                break block16;
                                            }
                                            n2 = 0;
                                        }
                                        bl4 = n2;
                                        bl5 = (boolean)this.\u03f5.\u04c1();
                                        if (n != 0) break block18;
                                        if (bl5 != (0x597C9426 ^ 0x597C9425)) break block19;
                                        bl5 = true;
                                        break block18;
                                    }
                                    bl5 = false;
                                }
                                bl2 = bl5;
                                oca9cc61aada3 = this.\u051c;
                                bl3 = bl4;
                                if (n != 0) break block20;
                                if (bl3) break block21;
                                bl3 = bl2;
                            }
                            if (n != 0) break block22;
                            if (bl3) break block21;
                            bl3 = true;
                            break block22;
                        }
                        bl3 = false;
                    }
                    oca9cc61aada3.\u0209(bl3, this);
                    oca9cc61aada2 = this.\u0296;
                    bl = bl4;
                    if (n != 0) break block23;
                    if (bl) break block24;
                    bl = bl2;
                }
                if (n != 0) break block25;
                if (bl) break block24;
                bl = true;
                break block25;
            }
            bl = false;
        }
        oca9cc61aada2.\u0209(bl, this);
        this.\u012f.\u0209(bl2, this);
        this.\u0536.\u0209(bl2, this);
        this.\u047a.\u0209(bl2, this);
        this.\u01ff.\u0209(true, this);
    }

    @Override
    public void z$1sehylui0i4ix(oca9cc61aada oca9cc61aada2) {
        block10: {
            oc714cf0262c oc714cf0262c2;
            block11: {
                oca9cc61aada oca9cc61aada3;
                block9: {
                    int n = oc5e549848f3.\u0130;
                    oca9cc61aada3 = oca9cc61aada2;
                    if (n != 0) break block9;
                    if (oca9cc61aada3 != this.\u03f5) break block10;
                    oc714cf0262c2 = this;
                    if (n != 0) break block11;
                    oca9cc61aada3 = oc714cf0262c2.\u03f5;
                }
                if ((int)oca9cc61aada3.\u04c1() != (0x2492B3A2 ^ 0x2492B3A1)) {
                    this.\u04f9();
                }
                oc714cf0262c2 = this;
            }
            oc714cf0262c2.z$2u87utkr1isxg();
        }
    }

    @Override
    public void z$3tl278wzjcayb(N n) {
        block6: {
            oc714cf0262c oc714cf0262c2;
            block7: {
                block8: {
                    int n2 = oc5e549848f3.\u0130;
                    if (n != this.\u03f5) break block6;
                    oc714cf0262c2 = this;
                    if (n2 != 0) break block7;
                    if ((int)oc714cf0262c2.\u03f5.\u04c1() == (0xEFD7D726 ^ 0xEFD7D725)) break block8;
                    this.\u04f9();
                }
                oc714cf0262c2 = this;
            }
            oc714cf0262c2.z$2u87utkr1isxg();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void onEnable() {
        block9: {
            Minecraft minecraft;
            block8: {
                int n = oc5e549848f3.\u0130;
                minecraft = oc69da1aa7f5.\u0151;
                if (n != 0) break block8;
                if (minecraft.thePlayer == null) break block9;
                minecraft = oc69da1aa7f5.\u0151;
            }
            if (minecraft.theWorld != null) {
                int n = (int)this.\u03f5.\u04c1();
                if (n != 1) return;
                oc69da1aa7f5.\u0151.thePlayer.jump();
                return;
            }
        }
        this.z$1ca1cmv0s357();
    }

    @Override
    public void onDisable() {
        this.\u024a.\u0538(oc69da1aa7f5.\u0151);
    }

    public boolean \u0454() {
        int n;
        block10: {
            block9: {
                oc714cf0262c oc714cf0262c2;
                int n2;
                block8: {
                    n2 = oc5e549848f3.\u0130;
                    oc714cf0262c2 = this;
                    if (n2 != 0) break block8;
                    if (!oc714cf0262c2.z$3rzb3dil7uydr()) break block9;
                    oc714cf0262c2 = this;
                }
                n = (int)oc714cf0262c2.\u03f5.\u04c1();
                if (n2 != 0) break block10;
                if (n != (0x4349A5CB ^ 0x4349A5C8)) break block9;
                n = 1;
                break block10;
            }
            n = false;
        }
        return n != 0;
    }

    public synchronized void \u01d8(oc6111f05032 oc6111f050322) {
        this.\u024a.\u03e5(oc6111f050322, (float)(this.\u012f.\u04c1() / 100.0), this.J.\u01ed(), this.\u0584.\u01ed());
    }

    public synchronized void \u00ca(double d) {
        this.\u024a.\u0507(oc69da1aa7f5.\u0151, d, (float)this.\u0536.\u04c1(), (float)(this.\u047a.\u04c1() / 50.0));
    }

    static double A(double d, float f, double d2, float f2) {
        return oca59cf41fac.\u00cd(d, f, d2, f2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean \u04b2() {
        EntityPlayerSP entityPlayerSP = null;
        int n = 0xD2095027 ^ 0x4980E2D3;
        int n2 = oc5e549848f3.\u0130;
        block20: while (true) {
            switch (n) {
                default: {
                    throw null;
                }
                case 2106961817: {
                    return false;
                }
                case -1685474572: {
                    entityPlayerSP = oc69da1aa7f5.\u0151.thePlayer;
                    if (n2 == 0) {
                        if (entityPlayerSP != null) {
                            n = 0x4B3C76C7 ^ 0x4980E2D3;
                            if (n2 == 0) continue block20;
                        }
                        n = 0x3E673290 ^ 0x4980E2D3;
                    }
                    if (n2 == 0) continue block20;
                }
                case 598704556: {
                    return true;
                }
                case -1614040257: {
                    if (oc69da1aa7f5.\u0151.gameSettings != null) {
                        n = 0x99A579BC ^ 0x4980E2D3;
                        if (n2 == 0) continue block20;
                    }
                    n = 0x34154D4A ^ 0x4980E2D3;
                    if (n2 == 0) continue block20;
                }
                case -162261470: {
                    int n3 = this.\u0584.\u01ed();
                    if (n2 == 0) {
                        if (n3 != 0) {
                            n = 0xADF7E51A ^ 0x4980E2D3;
                            if (n2 == 0) continue block20;
                        }
                        n3 = 0x6A2F637F ^ 0x4980E2D3;
                    }
                    n = n3;
                    if (n2 == 0) continue block20;
                }
                case -1800621909: {
                    int n4 = oc7ab2161b9f.\u0576(oc69da1aa7f5.\u0151.gameSettings.keyBindAttack);
                    if (n2 == 0) {
                        if (n4 == 0) {
                            n = 0x34154D4A ^ 0x4980E2D3;
                            if (n2 == 0) continue block20;
                        }
                        n4 = 0xBFD4F4F1 ^ 0x4980E2D3;
                    }
                    n = n4;
                    if (n2 == 0) continue block20;
                }
                case -461961271: {
                    int n5 = oc7ab2161b9f.\u016d(entityPlayerSP);
                    if (n2 == 0) {
                        if (n5 != 0) {
                            n = 0x6A2F637F ^ 0x4980E2D3;
                            if (n2 == 0) continue block20;
                        }
                        n5 = 0x2CDCAA88 ^ 0x4980E2D3;
                    }
                    n = n5;
                    if (n2 == 0) continue block20;
                }
                case 2011680835: {
                    return false;
                }
                case 45913108: {
                    int n6 = oc69da1aa7f5.\u0151.inGameHasFocus;
                    if (n2 == 0) {
                        if (n6 == 0) {
                            n = 0x3E673290 ^ 0x4980E2D3;
                            if (n2 == 0) continue block20;
                        }
                        n6 = 0x6499BAA ^ 0x4980E2D3;
                    }
                    n = n6;
                    if (n2 == 0) continue block20;
                }
                case 1338603897: {
                    int n7 = this.J.\u01ed();
                    if (n2 == 0) {
                        if (n7 != 0) {
                            n = 0xD64B51EC ^ 0x4980E2D3;
                            if (n2 == 0) continue block20;
                        }
                        n7 = 0xBFD4F4F1 ^ 0x4980E2D3;
                    }
                    n = n7;
                    if (n2 == 0) continue block20;
                }
                case 1700546651: {
                    return false;
                }
                case -802841745: 
            }
            if (oc69da1aa7f5.\u0151.gameSettings.keyBindAttack != null) {
                n = 0xDD2C5278 ^ 0x4980E2D3;
                if (n2 == 0) continue;
            }
            n = 0x34154D4A ^ 0x4980E2D3;
        }
    }

    private void \u04f9() {
        this.\u024a.\u049b(oc69da1aa7f5.\u0151);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @oc66fa4f2195
    public void \u0513(occ48acb5d22 occ48acb5d222) {
        block42: {
            EntityLivingBase entityLivingBase;
            int n;
            int n2;
            block59: {
                block50: {
                    int n3;
                    block58: {
                        long l;
                        block57: {
                            ocf873985fc3 ocf873985fc32;
                            block56: {
                                EntityLivingBase entityLivingBase2;
                                block55: {
                                    Minecraft minecraft;
                                    block54: {
                                        block53: {
                                            EntityPlayerSP entityPlayerSP;
                                            block52: {
                                                block51: {
                                                    block49: {
                                                        block48: {
                                                            block47: {
                                                                int n4;
                                                                block46: {
                                                                    block45: {
                                                                        block44: {
                                                                            Minecraft minecraft2;
                                                                            block43: {
                                                                                n2 = oc5e549848f3.\u0130;
                                                                                if (!(occ48acb5d222.\u01fa instanceof EntityLivingBase)) break block42;
                                                                                minecraft2 = oc69da1aa7f5.\u0151;
                                                                                if (n2 != 0) break block43;
                                                                                if (minecraft2.thePlayer == null) break block44;
                                                                                minecraft2 = oc69da1aa7f5.\u0151;
                                                                            }
                                                                            if (minecraft2.theWorld != null) break block45;
                                                                        }
                                                                        return;
                                                                    }
                                                                    oc714cf0262c oc714cf0262c2 = this;
                                                                    if (n2 == 0) {
                                                                        if (!oc714cf0262c2.\u04b2()) {
                                                                            return;
                                                                        }
                                                                        oc714cf0262c2 = this;
                                                                    }
                                                                    n4 = n = (int)oc714cf0262c2.\u03f5.\u04c1();
                                                                    if (n2 != 0) break block46;
                                                                    if (n4 == (0x813C73DC ^ 0x813C73DE)) break block47;
                                                                    n4 = n;
                                                                }
                                                                if (n4 != (0x813C73DD ^ 0x813C73DE)) break block48;
                                                            }
                                                            return;
                                                        }
                                                        entityLivingBase = (EntityLivingBase)occ48acb5d222.\u01fa;
                                                        entityPlayerSP = oc69da1aa7f5.\u0151.thePlayer;
                                                        if (n2 != 0) break block49;
                                                        if (!entityPlayerSP.onGround) break block50;
                                                        entityPlayerSP = oc69da1aa7f5.\u0151.thePlayer;
                                                    }
                                                    if (n2 != 0) break block51;
                                                    if (entityPlayerSP.isOnLadder()) break block50;
                                                    entityPlayerSP = oc69da1aa7f5.\u0151.thePlayer;
                                                }
                                                if (n2 != 0) break block52;
                                                if (entityPlayerSP.getIsInWeb()) break block50;
                                                minecraft = oc69da1aa7f5.\u0151;
                                                if (n2 != 0) break block53;
                                                entityPlayerSP = minecraft.thePlayer;
                                            }
                                            if (entityPlayerSP.isInWater()) break block50;
                                            minecraft = oc69da1aa7f5.\u0151;
                                        }
                                        if (n2 != 0) break block54;
                                        if (minecraft.thePlayer.isInLava()) break block50;
                                        minecraft = oc69da1aa7f5.\u0151;
                                    }
                                    entityLivingBase2 = minecraft.thePlayer;
                                    if (n2 != 0) break block55;
                                    if (entityLivingBase2.ridingEntity != null) break block50;
                                    entityLivingBase2 = entityLivingBase;
                                }
                                if (entityLivingBase2.hurtTime > (int)this.\u0296.\u04c1()) break block50;
                                ocf873985fc32 = oc9755810e45.\u01a3;
                                if (n2 != 0) break block56;
                                if (ocf873985fc32 == null) break block57;
                                ocf873985fc32 = oc9755810e45.\u01a3;
                            }
                            n3 = ocf873985fc32.z$3rzb3dil7uydr();
                            if (n2 != 0) break block58;
                            if (n3 != 0) break block50;
                        }
                        n3 = (l = System.currentTimeMillis() - this.\u0149 - (long)this.\u051c.\u04c1()) == 0L ? 0 : (l < 0L ? -1 : 1);
                    }
                    if (n3 >= 0) break block59;
                }
                return;
            }
            double d = oc69da1aa7f5.\u0151.thePlayer.posX;
            double d2 = oc69da1aa7f5.\u0151.thePlayer.posY;
            double d3 = oc69da1aa7f5.\u0151.thePlayer.posZ;
            if (n2 == 0) {
                switch (n) {
                    case 0: {
                        oc69da1aa7f5.\u0151.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer.C04PacketPlayerPosition(d, d2 + 0.0625, d3, true));
                        oc69da1aa7f5.\u0151.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer.C04PacketPlayerPosition(d, d2, d3, false));
                        oc69da1aa7f5.\u0151.thePlayer.onCriticalHit(entityLivingBase);
                        break;
                    }
                }
            }
            this.\u0149 = System.currentTimeMillis();
        }
    }

    @oc66fa4f2195
    public void \u0271(oc70db705765 oc70db7057652) {
        block16: {
            ocdd342096f8 ocdd342096f82;
            block18: {
                boolean bl;
                int n;
                block17: {
                    n = oc5e549848f3.\u0130;
                    if ((int)this.\u03f5.\u04c1() != (0xBF713CB4 ^ 0xBF713CB6) || oc69da1aa7f5.\u0151.thePlayer == null) break block16;
                    bl = this.\u04b2();
                    if (n != 0) break block17;
                    if (!bl) break block16;
                    bl = oc69da1aa7f5.\u0151.thePlayer.onGround;
                }
                if (!bl) break block16;
                ocdd342096f82 = oc9755810e45.\u00ff;
                if (n != 0) break block18;
                if (ocdd342096f82 == null) break block16;
                ocdd342096f82 = oc9755810e45.\u00ff;
            }
            if (!ocdd342096f82.z$3rzb3dil7uydr() || ocdd342096f8.f == null) break block16;
            oc70db7057652.\u0243(true);
        }
    }

    @oc66fa4f2195
    public void \u0455(oc25aa89b91f oc25aa89b91f2) {
        block16: {
            ocdd342096f8 ocdd342096f82;
            block18: {
                boolean bl;
                int n;
                block17: {
                    n = oc5e549848f3.\u0130;
                    if ((int)this.\u03f5.\u04c1() != (0x1F8208B2 ^ 0x1F8208B0) || oc69da1aa7f5.\u0151.thePlayer == null) break block16;
                    bl = this.\u04b2();
                    if (n != 0) break block17;
                    if (!bl) break block16;
                    bl = oc69da1aa7f5.\u0151.thePlayer.isSwingInProgress;
                }
                if (!bl) break block16;
                ocdd342096f82 = oc9755810e45.\u00ff;
                if (n != 0) break block18;
                if (ocdd342096f82 == null) break block16;
                ocdd342096f82 = oc9755810e45.\u00ff;
            }
            if (!ocdd342096f82.z$3rzb3dil7uydr() || ocdd342096f8.f == null) break block16;
            oc69da1aa7f5.\u0151.thePlayer.onCriticalHit(ocdd342096f8.f);
        }
    }

    @oc66fa4f2195
    public void \u04b6(oc9d4393f3ce oc9d4393f3ce2) {
        block19: {
            int n;
            block18: {
                oc714cf0262c oc714cf0262c2;
                int n2;
                block16: {
                    block17: {
                        block15: {
                            n2 = oc5e549848f3.\u0130;
                            if (this.z$3rzb3dil7uydr() && oc69da1aa7f5.\u0151.thePlayer != null) break block15;
                            return;
                        }
                        oc714cf0262c2 = this;
                        if (n2 != 0) break block16;
                        if (oc714cf0262c2.\u04b2()) break block17;
                        return;
                    }
                    oc714cf0262c2 = this;
                }
                int n3 = (int)oc714cf0262c2.\u03f5.\u04c1();
                n = n3;
                if (n2 != 0) break block18;
                if (n != 1) break block19;
                n = oc9d4393f3ce2.\u025f() instanceof C03PacketPlayer;
            }
            if (n != 0) {
                this.m(oc9d4393f3ce2.\u025f(), false);
            }
        }
    }

    @oc66fa4f2195
    public void \u04d3(oce4fccf5a38 oce4fccf5a382) {
        this.\u04f9();
    }

    @oc66fa4f2195
    public void \u04bd(ocbab3c9954b ocbab3c9954b2) {
        this.\u04f9();
    }

    private void m(Object object, boolean bl) {
        try {
            Field field = C03PacketPlayer.class.getDeclaredField("onGround");
            field.setAccessible(true);
            field.setBoolean(object, bl);
        }
        catch (Exception exception) {
            try {
                Field field = C03PacketPlayer.class.getDeclaredField("field_149474_g");
                field.setAccessible(true);
                field.setBoolean(object, bl);
            }
            catch (Exception exception2) {
                // empty catch block
            }
        }
    }

    static {
        String[] stringArray = new String[0x35F6A7FB ^ 0x35F6A7FF];
        stringArray[0] = "Packet";
        stringArray[1] = "NoGround";
        stringArray[0x35F6A7FD ^ 0x35F6A7FF] = "Legit";
        stringArray[0x35F6A7FC ^ 0x35F6A7FF] = "Timer";
        \u03e7 = stringArray;
    }
}

