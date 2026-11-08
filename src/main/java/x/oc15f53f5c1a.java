/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oc046a8f0d16;
import x.oc33e2bcdd33;
import x.oc6111f05032;
import x.oc66fa4f2195;
import x.oc69da1aa7f5;
import x.oc7b49c3b6cf;
import x.oc84f20a0bc5;
import x.oc86de9e2892;
import x.oc8ce2882092;
import x.oca6eae151db;
import x.oca9cc61aada;
import x.ocb683e2d821;
import x.ocbab3c9954b;
import x.occ2f8dff8d8;
import x.ocd5cc9ffddf;
import x.oce3ec53c616;
import x.oce4cea752dd;

public class oc15f53f5c1a
extends oc69da1aa7f5 {
    private static final float \u02b0 = 20.0f;
    private final oc7b49c3b6cf \u04bd = new oc7b49c3b6cf();
    private final oca9cc61aada \u02a5 = new oca9cc61aada("Range", 7.0, 1.0, 7.0, 1.0);
    private final oca9cc61aada F = new oca9cc61aada("FOV", 360.0, 50.0, 360.0, 0.001);
    private final oca9cc61aada \u0404 = new oca9cc61aada("Minimum height", 4.0, 1.0, 10.0, 1.0);
    private final oca9cc61aada \u018f = new oca9cc61aada("Aim speed", "", 600.0, 400.0, 3600.0, 20.0, "Base speed");
    private final oca9cc61aada \u0193 = new oca9cc61aada("Aim boost", "", 0.5, 0.3, 1.0, 0.001, "Acceleration");
    private final oca9cc61aada \u0179 = new oca9cc61aada("Aim boost amount", "%", 30.0, 0.0, 100.0, 0.1, "Acceleration strength");
    private final occ2f8dff8d8 \u01e7 = new occ2f8dff8d8("Flexible", false, "Multipoint");
    private final oca9cc61aada \u0445 = new oca9cc61aada("Return view delay", "ms", 300.0, 50.0, 500.0, 50.0, "Delay");
    private final oca9cc61aada \u0552 = new oca9cc61aada("Return view time", "ms", 200.0, 50.0, 500.0, 50.0, "Duration");
    private final occ2f8dff8d8 J = new occ2f8dff8d8("Return view on jump", false, "Keep jump direction");
    private final occ2f8dff8d8 \u04b1 = new occ2f8dff8d8("Auto disable", false, "Disable afterwards");
    private final occ2f8dff8d8 d;
    private final occ2f8dff8d8 \u0432;
    public static boolean \u02b3;

    public oc15f53f5c1a() {
        super("Clutch", oce4cea752dd.\u0437);
        String[] stringArray = new String[0x8536CFBD ^ 0x8536CFBF];
        stringArray[0] = "In air";
        stringArray[1] = "In Air";
        this.d = new occ2f8dff8d8("Only Fall", true, stringArray);
        this.\u0432 = new occ2f8dff8d8("Damaged", false);
        this.\u0105("Auto places blocks to save you from fall.");
        this.\u028c(this.\u02a5);
        this.\u028c(this.F);
        this.\u028c(this.\u0404);
        this.\u028c(this.\u018f);
        this.\u028c(this.\u0193);
        this.\u028c(this.\u0179);
        this.\u028c(this.\u01e7);
        this.\u028c(this.\u0445);
        this.\u028c(this.\u0552);
        this.\u028c(this.J);
        this.\u028c(this.\u04b1);
        this.\u028c(this.d);
        this.\u028c(this.\u0432);
    }

    private oc046a8f0d16 \u00d9() {
        oc046a8f0d16 oc046a8f0d162 = new oc046a8f0d16();
        oc046a8f0d162.\u0292 = (float)this.\u02a5.\u04c1();
        oc046a8f0d162.\u02a7 = (float)this.F.\u04c1();
        oc046a8f0d162.\u0181 = (float)this.\u0404.\u04c1();
        oc046a8f0d162.\u0459 = 20.0f;
        oc046a8f0d162.\u03de = 0.5f;
        oc046a8f0d162.z = (float)(this.\u018f.\u04c1() / 20.0);
        oc046a8f0d162.\u0370 = (float)this.\u0193.\u04c1();
        oc046a8f0d162.\u03a3 = (float)(this.\u0179.\u04c1() / 100.0);
        oc046a8f0d162.V = (float)(this.\u0445.\u04c1() / 50.0);
        oc046a8f0d162.\u0506 = (float)(this.\u0552.\u04c1() / 50.0);
        oc046a8f0d162.\u0155 = 0x2181DEFE ^ 0x2181DEFC;
        oc046a8f0d162.\u010a = false;
        oc046a8f0d162.\u04b2 = this.\u01e7.\u01ed();
        oc046a8f0d162.\u01d5 = this.J.\u01ed();
        oc046a8f0d162.\u0503 = this.\u04b1.\u01ed();
        oc046a8f0d162.\u0139 = this.d.\u01ed();
        oc046a8f0d162.\u0549 = this.\u0432.\u01ed();
        oc046a8f0d162.\u0249 = false;
        return oc046a8f0d162;
    }

    public void \u01e1(oc6111f05032 oc6111f050322) {
        this.\u04bd.\u0137(new oce3ec53c616(oc6111f050322, this), 20.0f);
    }

    public void \u00cd(oc6111f05032 oc6111f050322) {
        this.\u04bd.\u0100(new oce3ec53c616(oc6111f050322, this), this.\u00d9(), oca6eae151db.\u0151, oca6eae151db.\u03ea());
    }

    public boolean \u0545() {
        return this.\u04bd.\u024d;
    }

    @oc66fa4f2195(priority=oc8ce2882092.LOWEST)
    public void \u025e(oc86de9e2892 oc86de9e28922) {
        block10: {
            oc86de9e2892 oc86de9e28923;
            block12: {
                boolean bl;
                block11: {
                    int n = oc84f20a0bc5.\u0117;
                    if (oc69da1aa7f5.\u0151.thePlayer == null) break block10;
                    bl = ocb683e2d821.\u029d();
                    if (n != 0) break block11;
                    if (!bl) break block10;
                    oc86de9e28923 = oc86de9e28922;
                    if (n != 0) break block12;
                    bl = oc86de9e28923.\u043b(this, 0xEF1ABB60 ^ 0xEF1AB888, Float.valueOf(oc69da1aa7f5.\u0151.thePlayer.rotationYaw), Float.valueOf(oc69da1aa7f5.\u0151.thePlayer.rotationPitch));
                }
                if (!bl) break block10;
                oc86de9e28922.\u0290(true);
                oc86de9e28923 = oc86de9e28922;
            }
            oc86de9e28923.\u0224(false);
        }
    }

    @Override
    public void onDisable() {
        this.\u04bd.M();
        ocd5cc9ffddf.\u0143(this);
        oc6111f05032 oc6111f050322 = new oc6111f05032(oc69da1aa7f5.\u0151);
        oc33e2bcdd33 oc33e2bcdd332 = new oc33e2bcdd33(0x52547BA8 ^ 0x52547BA5);
        oc33e2bcdd332.\u00e4 = false;
        ocb683e2d821.W(oc6111f050322, oc33e2bcdd332);
        ocb683e2d821.\u0250(oc6111f050322);
    }

    @oc66fa4f2195
    public void \u03d0(ocbab3c9954b ocbab3c9954b2) {
        this.onDisable();
        ocd5cc9ffddf.\u0156();
    }
}

