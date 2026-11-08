/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.awt.Color;
import java.util.Set;
import net.minecraft.client.Minecraft;
import net.minecraft.util.Vec3;
import x.oc2cf3d80e17;
import x.oc2f60cd9d1e;
import x.oc2f61de30bc;
import x.oc3d1d10e2c1;
import x.oc4d46a99983;
import x.oc5b52533f96;
import x.oc66fa4f2195;
import x.oc69da1aa7f5;
import x.oc746a23b244;
import x.oc7ab2161b9f;
import x.oc84f20a0bc5;
import x.oca9cc61aada;
import x.ocbd4917c4b1;
import x.occ2f8dff8d8;
import x.ocd47efa9be3;
import x.oce4cea752dd;

public class oc748fdbd6c0
extends oc69da1aa7f5 {
    private static final String[] \u01d4;
    private oca9cc61aada \u0539;
    private oca9cc61aada \u04a4;
    private occ2f8dff8d8 \u00e7;
    private occ2f8dff8d8 \u039b;
    private occ2f8dff8d8 \u02a9;
    private Vec3 \u01ff;
    private int \u0491 = new Color(0, 0x99C67168 ^ 0x99C67197, 0, 0x99C671EF ^ 0x99C67197).getRGB();
    private int \u01f9;
    private long \u04a1;
    private oc3d1d10e2c1 \u0109;
    public static boolean \u03a0;

    public oc748fdbd6c0() {
        super("Blink", oce4cea752dd.\u0437);
        this.\u0539 = new oca9cc61aada("Mode", 1, \u01d4);
        this.\u028c(this.\u0539);
        this.\u00e7 = new occ2f8dff8d8("Max duration", false);
        this.\u028c(this.\u00e7);
        this.\u04a4 = new oca9cc61aada("Disable after", "ms", 500.0, 50.0, 20000.0, 50.0);
        this.\u028c(this.\u04a4);
        this.\u028c(new oc4d46a99983("Disable on"));
        this.\u039b = new occ2f8dff8d8("Attack", false);
        this.\u028c(this.\u039b);
        this.\u02a9 = new occ2f8dff8d8("Show initial position", true);
        this.\u028c(this.\u02a9);
    }

    @Override
    public void z$2u87utkr1isxg() {
        this.\u04a4.\u0209(this.\u00e7.\u01ed(), this);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void onEnable() {
        block8: {
            Minecraft minecraft;
            block7: {
                int n = oc84f20a0bc5.\u0117;
                minecraft = oc69da1aa7f5.\u0151;
                if (n != 0) break block7;
                if (minecraft.thePlayer == null) break block8;
                minecraft = oc69da1aa7f5.\u0151;
            }
            if (minecraft.theWorld != null) {
                this.\u01ff = new Vec3(oc69da1aa7f5.\u0151.thePlayer.posX, oc69da1aa7f5.\u0151.thePlayer.posY, oc69da1aa7f5.\u0151.thePlayer.posZ);
                this.\u01f9 = 0;
                this.\u04a1 = System.currentTimeMillis();
                this.\u0109 = new oc3d1d10e2c1(this.\u03ec(), new oc5b52533f96(this));
                oc2cf3d80e17.\u0230.\u0295(this.\u0109);
                return;
            }
        }
        this.z$1ca1cmv0s357();
    }

    @Override
    public void onDisable() {
        block4: {
            oc748fdbd6c0 oc748fdbd6c02;
            block5: {
                int n = oc84f20a0bc5.\u0117;
                oc748fdbd6c02 = this;
                if (n != 0) break block4;
                if (oc748fdbd6c02.\u0109 == null) break block5;
                this.\u0109.\u0220().\u00e5();
                this.\u0109 = null;
            }
            this.\u01ff = null;
            this.\u01f9 = 0;
            oc748fdbd6c02 = this;
        }
        oc748fdbd6c02.\u04a1 = 0L;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Set<oc2f60cd9d1e> \u03ec() {
        switch ((int)this.\u0539.\u04c1()) {
            case 0: {
                return oc2f60cd9d1e.\u01cc;
            }
            case 2: {
                return oc2f60cd9d1e.\u0497;
            }
        }
        return oc2f60cd9d1e.\u054d;
    }

    public boolean \u040e() {
        int n;
        block8: {
            block10: {
                block9: {
                    int n2 = (int)this.\u0539.\u04c1();
                    int n3 = oc84f20a0bc5.\u0117;
                    n = n2;
                    if (n3 != 0) break block8;
                    if (n == 0) break block9;
                    n = n2;
                    if (n3 != 0) break block8;
                    if (n != (0xE5BEA9FC ^ 0xE5BEA9FE)) break block10;
                }
                n = 1;
                break block8;
            }
            n = 0;
        }
        return n != 0;
    }

    @Override
    public String getInfo() {
        return String.valueOf(this.\u01f9);
    }

    @oc66fa4f2195
    public void \u0118(oc2f61de30bc oc2f61de30bc2) {
        ++this.\u01f9;
        if (!this.\u00e7.\u01ed()) {
            return;
        }
        long l = System.currentTimeMillis() - this.\u04a1;
        if (l >= (long)((int)this.\u04a4.\u04c1())) {
            this.z$1ca1cmv0s357();
        }
    }

    @oc66fa4f2195
    public void \u01f7(ocd47efa9be3 ocd47efa9be32) {
        block16: {
            block14: {
                boolean bl;
                block15: {
                    oc748fdbd6c0 oc748fdbd6c02;
                    int n;
                    block13: {
                        n = oc84f20a0bc5.\u0117;
                        oc748fdbd6c02 = this;
                        if (n != 0) break block13;
                        if (!oc748fdbd6c02.z$3rzb3dil7uydr()) break block14;
                        oc748fdbd6c02 = this;
                    }
                    bl = oc748fdbd6c02.\u039b.\u01ed();
                    if (n != 0) break block15;
                    if (!bl) break block14;
                    bl = oc7ab2161b9f.\u00d0();
                }
                if (bl) break block16;
            }
            return;
        }
        if (ocd47efa9be32.\u03b2 != oc69da1aa7f5.\u0151.thePlayer) {
            return;
        }
        this.z$1ca1cmv0s357();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @oc66fa4f2195
    public void \u0571(oc746a23b244 oc746a23b2442) {
        oc748fdbd6c0 oc748fdbd6c02;
        block11: {
            block12: {
                int n;
                block10: {
                    n = oc84f20a0bc5.\u0117;
                    if (!oc7ab2161b9f.\u00d0()) return;
                    oc748fdbd6c02 = this;
                    if (n != 0) break block10;
                    if (oc748fdbd6c02.\u01ff == null) return;
                    oc748fdbd6c02 = this;
                }
                if (n != 0) break block11;
                if (oc748fdbd6c02.\u02a9.\u01ed()) break block12;
                return;
            }
            oc748fdbd6c02 = this;
        }
        ocbd4917c4b1.\u0111(oc748fdbd6c02.\u01ff, this.\u0491);
    }

    static {
        String[] stringArray = new String[0xE38D97C7 ^ 0xE38D97C4];
        stringArray[0] = "Inbound";
        stringArray[1] = "Outbound";
        stringArray[0xE38D97C6 ^ 0xE38D97C4] = "Both";
        \u01d4 = stringArray;
    }
}

