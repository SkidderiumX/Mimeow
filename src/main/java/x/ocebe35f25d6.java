/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.awt.Color;
import java.nio.Buffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import x.J;
import x.N;
import x.oc03d1b35e89;
import x.oc0af730cc9f;
import x.oc0e37bc27e8;
import x.oc10354c7bb8;
import x.oc1378bc114d;
import x.oc192c7e4083;
import x.oc1ce8db3bf9;
import x.oc24a0a5bddf;
import x.oc2c25634a7e;
import x.oc2cf3d80e17;
import x.oc2ec6a95e5c;
import x.oc30aea91d28;
import x.oc321b4679dd;
import x.oc33f4d4e69a;
import x.oc3beae5cb21;
import x.oc4cf31984d9;
import x.oc4d46a99983;
import x.oc5b72b56d37;
import x.oc5bc92c04e9;
import x.oc5f2027353d;
import x.oc65014da549;
import x.oc69da1aa7f5;
import x.oc6a43806f12;
import x.oc6af36febc3;
import x.oc6beef1c60b;
import x.oc6c12eede72;
import x.oc6c40e19ed3;
import x.oc74d4657d04;
import x.oc7ab2161b9f;
import x.oc81019d75fb;
import x.oc8d36772412;
import x.oc9953295ed5;
import x.oca9cc61aada;
import x.ocada7dda290;
import x.ocb23d192a35;
import x.ocbc9c7a1e51;
import x.ocbd4917c4b1;
import x.occ2f8dff8d8;
import x.occc831eff22;
import x.ocdd0f49ff2f;
import x.oce1bd2fa256;
import x.oce4cea752dd;
import x.ocf1568fef75;
import x.ocf22d09661d;
import x.ocf94e69dfc3;
import x.ocfd4ff6075d;

public class ocebe35f25d6
extends oc6c12eede72 {
    public oc69da1aa7f5 \u0523;
    public oc192c7e4083 \u02a4;
    public float \u0182;
    public ArrayList<oc6c12eede72> \u0376;
    public boolean \u0224;
    private boolean \u0282;
    private oc5f2027353d \u0389;
    private boolean \u0275;
    private oc5f2027353d \u02b7;
    private float \u021f = 16.0f;
    private float \u0541 = 16.0f;
    private float \u0208 = 16.0f;
    private static final IntBuffer \u00e6 = BufferUtils.createIntBuffer(0xA2853AEE ^ 0xA2853AFE);
    private static final float \u01e3 = 6.0f;
    private static final int \u0287 = 120;
    private static final int I = new Color(0, 0, 0, 0xA2853A86 ^ 0xA2853AFE).getRGB();
    private static final int \u0231 = new Color(0xA2853A8C ^ 0xA2853AFE, 0xA2853A42 ^ 0xA2853AFE, 0xA2853A04 ^ 0xA2853AFE).getRGB();
    private static final int \u044b = new Color(0xA2853A01 ^ 0xA2853AFE, 0xA2853AAE ^ 0xA2853AFE, 0xA2853AAE ^ 0xA2853AFE).getRGB();
    private static final int \u04a2 = new Color(0xA2853AE6 ^ 0xA2853AFE, 0xA2853A64 ^ 0xA2853AFE, 0xA2853A01 ^ 0xA2853AFE).getRGB();
    private static final int \u0203 = new Color(0xA2853A3E ^ 0xA2853AFE, 0xA2853A3E ^ 0xA2853AFE, 0xA2853A3E ^ 0xA2853AFE).getRGB();
    private final boolean \u0427;
    private final Map<oc6c12eede72, oc33f4d4e69a> \u01a3 = new IdentityHashMap<oc6c12eede72, oc33f4d4e69a>();
    private final Map<String, oc33f4d4e69a> \u012e = new HashMap<String, oc33f4d4e69a>();
    private static final int \u010d = 4;
    private final int[][] \u03dc = new int[0xF400ED26 ^ 0xF400ED22][0xF400ED27 ^ 0xF400ED22];
    private int \u01eb = 0;

    public ocebe35f25d6(oc69da1aa7f5 oc69da1aa7f52, oc192c7e4083 oc192c7e40832, float f) {
        float f2;
        this.\u0523 = oc69da1aa7f52;
        this.\u02a4 = oc192c7e40832;
        this.\u0182 = f;
        this.\u0376 = new ArrayList();
        this.\u0224 = this.\u0427 = oc69da1aa7f52 instanceof oc4cf31984d9;
        this.\u021f = f2 = this.\u01de();
        this.\u0541 = f2;
        this.\u0208 = f2;
        this.\u0272();
    }

    private void \u0272() {
        this.\u0376 = new ArrayList();
        float f = this.\u0182 + this.\u00e0();
        if (this.\u0523 != null) {
            for (N n : this.\u0523.\u02b7()) {
                oc6c12eede72 oc6c12eede722;
                Object object;
                if (!n.\u04c0) continue;
                if (n instanceof ocada7dda290) {
                    object = new oc65014da549((ocada7dda290)n, this, f);
                    this.\u0376.add((oc6c12eede72)object);
                    f += ((oc65014da549)object).z$2rmsdj781vrn2();
                    continue;
                }
                if (n instanceof oca9cc61aada && ((oca9cc61aada)n).\u00c6) {
                    object = new oc65014da549((oca9cc61aada)n, this, f);
                    this.\u0376.add((oc6c12eede72)object);
                    f += ((oc65014da549)object).z$2rmsdj781vrn2();
                    continue;
                }
                if (n instanceof oca9cc61aada) {
                    object = (oca9cc61aada)n;
                    oc6c12eede722 = new oc6beef1c60b((oca9cc61aada)object, this, f);
                    this.\u0376.add(oc6c12eede722);
                    f += 12.0f;
                    continue;
                }
                if (n instanceof ocf1568fef75) {
                    object = new oc5bc92c04e9((ocf1568fef75)n, this, f);
                    this.\u0376.add((oc6c12eede72)object);
                    f += 16.0f;
                    continue;
                }
                if (n instanceof occ2f8dff8d8) {
                    object = (occ2f8dff8d8)n;
                    oc6c12eede722 = new oc1ce8db3bf9(this.\u0523, (occ2f8dff8d8)object, this, f);
                    this.\u0376.add(oc6c12eede722);
                    f += 12.0f;
                    continue;
                }
                if (n instanceof oc4d46a99983) {
                    object = (oc4d46a99983)n;
                    oc6c12eede722 = new oc5b72b56d37((oc4d46a99983)object, this, f);
                    this.\u0376.add(oc6c12eede722);
                    f += 12.0f;
                    continue;
                }
                if (n instanceof ocb23d192a35) {
                    object = (ocb23d192a35)n;
                    oc6c12eede722 = new oc9953295ed5(this, (ocb23d192a35)object, f);
                    this.\u0376.add(oc6c12eede722);
                    f += 12.0f;
                    continue;
                }
                if (n instanceof occc831eff22) {
                    object = (occc831eff22)n;
                    oc6c12eede722 = new oc33f4d4e69a((occc831eff22)object, this, f);
                    this.\u0376.add(oc6c12eede722);
                    f += 12.0f;
                    continue;
                }
                if (n instanceof oc24a0a5bddf) {
                    object = (oc24a0a5bddf)n;
                    oc6c12eede722 = new oc74d4657d04((oc24a0a5bddf)object, this, f);
                    this.\u0376.add(oc6c12eede722);
                    f += 12.0f;
                    continue;
                }
                if (n instanceof oc0af730cc9f) {
                    object = (oc0af730cc9f)n;
                    oc6c12eede722 = new oc3beae5cb21((oc0af730cc9f)object, this, f);
                    this.\u0376.add(oc6c12eede722);
                    f += 12.0f;
                    continue;
                }
                if (n instanceof ocbc9c7a1e51) {
                    object = (ocbc9c7a1e51)n;
                    oc6c12eede722 = new oc6c40e19ed3((ocbc9c7a1e51)object, this, f);
                    this.\u0376.add(oc6c12eede722);
                    f += 12.0f;
                    continue;
                }
                if (n instanceof oc2ec6a95e5c) {
                    object = (oc2ec6a95e5c)n;
                    oc6c12eede722 = new ocf94e69dfc3((oc2ec6a95e5c)object, this, f);
                    this.\u0376.add(oc6c12eede722);
                    f += 12.0f;
                    continue;
                }
                if (n instanceof oce1bd2fa256) {
                    object = (oce1bd2fa256)n;
                    oc6c12eede722 = new oc0e37bc27e8((oce1bd2fa256)object, this, f);
                    this.\u0376.add(oc6c12eede722);
                    f += ((oc0e37bc27e8)oc6c12eede722).z$2rmsdj781vrn2();
                    continue;
                }
                if (n instanceof oc6af36febc3) {
                    object = (oc6af36febc3)n;
                    oc6c12eede722 = new oc03d1b35e89((oc6af36febc3)object, this, f);
                    this.\u0376.add(oc6c12eede722);
                    f += ((oc03d1b35e89)oc6c12eede722).z$2rmsdj781vrn2();
                    continue;
                }
                if (n instanceof oc10354c7bb8) {
                    object = (oc10354c7bb8)n;
                    oc6c12eede722 = new J((oc10354c7bb8)object, this, f);
                    this.\u0376.add(oc6c12eede722);
                    f += 12.0f;
                    continue;
                }
                if (!(n instanceof oc321b4679dd)) continue;
                object = (oc321b4679dd)n;
                oc6c12eede722 = new ocf22d09661d((oc321b4679dd)object, this, f);
                this.\u0376.add(oc6c12eede722);
                f += ((ocfd4ff6075d)oc6c12eede722).z$2rmsdj781vrn2();
            }
        }
        if (!this.\u0427 && !(this.\u0523 instanceof oc8d36772412)) {
            this.\u0376.add(new oc9953295ed5(this, f));
        }
        this.\u0239();
    }

    public void \u049a() {
        oc6c12eede72 oc6c12eede722;
        boolean bl = this.\u0224;
        HashMap<oca9cc61aada, Boolean> hashMap = new HashMap<oca9cc61aada, Boolean>();
        HashMap<oc24a0a5bddf, Boolean> hashMap2 = new HashMap<oc24a0a5bddf, Boolean>();
        IdentityHashMap<N, Boolean> identityHashMap = new IdentityHashMap<N, Boolean>();
        for (oc6c12eede72 oc6c12eede723 : this.\u0376) {
            if (oc6c12eede723 instanceof oc6beef1c60b) {
                oc6c12eede722 = (oc6beef1c60b)oc6c12eede723;
                hashMap.put(((oc6beef1c60b)oc6c12eede722).\u050d, ((oc6beef1c60b)oc6c12eede722).\u0161);
                continue;
            }
            if (oc6c12eede723 instanceof oc74d4657d04) {
                oc6c12eede722 = (oc74d4657d04)oc6c12eede723;
                hashMap2.put(((oc74d4657d04)oc6c12eede722).\u0565, ((oc74d4657d04)oc6c12eede722).\u0583);
                continue;
            }
            if (!(oc6c12eede723 instanceof oc65014da549)) continue;
            oc6c12eede722 = (oc65014da549)oc6c12eede723;
            identityHashMap.put(((oc65014da549)oc6c12eede722).\u0502, ((oc65014da549)oc6c12eede722).\u0150);
        }
        this.\u0272();
        for (oc6c12eede72 oc6c12eede723 : this.\u0376) {
            Boolean bl2;
            if (oc6c12eede723 instanceof oc6beef1c60b) {
                oc6c12eede722 = (oc6beef1c60b)oc6c12eede723;
                bl2 = (Boolean)hashMap.get(((oc6beef1c60b)oc6c12eede722).\u050d);
                if (bl2 == null) continue;
                ((oc6beef1c60b)oc6c12eede722).\u0161 = bl2;
                continue;
            }
            if (oc6c12eede723 instanceof oc74d4657d04) {
                oc6c12eede722 = (oc74d4657d04)oc6c12eede723;
                bl2 = (Boolean)hashMap2.get(((oc74d4657d04)oc6c12eede722).\u0565);
                if (bl2 == null) continue;
                ((oc74d4657d04)oc6c12eede722).\u0506(bl2);
                continue;
            }
            if (!(oc6c12eede723 instanceof oc65014da549)) continue;
            oc6c12eede722 = (oc65014da549)oc6c12eede723;
            bl2 = (Boolean)identityHashMap.get(((oc65014da549)oc6c12eede722).\u0502);
            if (bl2 == null) continue;
            ((oc65014da549)oc6c12eede722).\u03c6(bl2);
        }
        this.\u0567(bl);
        this.\u01e3();
    }

    public void \u0567(boolean bl) {
        float f;
        this.\u0224 = this.\u0427 || bl;
        this.\u02b7 = null;
        this.\u021f = f = this.\u0224 ? this.z$2rmsdj781vrn2() : this.\u01de();
        this.\u0541 = f;
        this.\u0208 = f;
    }

    public void \u056d() {
        if (this.\u02b7 != null) {
            if (System.currentTimeMillis() - this.\u02b7.\u0445 >= (0xBB197E64641E6680L ^ 0xBB197E64641E6798L)) {
                this.\u02b7 = null;
                this.\u021f = this.\u0208;
                this.\u0541 = this.\u0208;
            } else {
                this.\u021f = this.\u02b7.\u01df(this.\u0541, this.\u0208, 1);
                if (this.\u021f == this.\u0208) {
                    this.\u02b7 = null;
                    this.\u0541 = this.\u0208;
                }
            }
        }
    }

    @Override
    public void z$18gzyyc94suow(float f) {
        this.\u0182 = f;
        float f2 = this.\u0182 + this.\u01de();
        int n = 0;
        while (n < this.\u0376.size()) {
            float f3;
            oc33f4d4e69a oc33f4d4e69a2;
            oc6c12eede72 oc6c12eede722 = this.\u0376.get(n);
            if (!this.\u010c(oc6c12eede722)) {
                ++n;
                continue;
            }
            if (oc6c12eede722 instanceof oc33f4d4e69a) {
                oc33f4d4e69a2 = (oc33f4d4e69a)oc6c12eede722;
                f3 = oc33f4d4e69a2.\u042c();
                oc6c12eede722.z$18gzyyc94suow(f2);
                float f4 = f2;
                ++n;
                float f5 = f2 += this.\u0480(oc6c12eede722);
                float f6 = 0.0f;
                while (n < this.\u0376.size()) {
                    oc6c12eede72 oc6c12eede723 = this.\u0376.get(n);
                    if (!this.\u010c(oc6c12eede723)) {
                        ++n;
                        continue;
                    }
                    if (this.\u00f0(oc6c12eede723) != oc33f4d4e69a2) break;
                    oc6c12eede723.z$18gzyyc94suow(f5);
                    float f7 = this.\u0480(oc6c12eede723);
                    f5 += f7;
                    f6 += f7;
                    if (oc6c12eede723 instanceof oc6beef1c60b) {
                        ((oc6beef1c60b)oc6c12eede723).\u03cc = 6.0f;
                    } else if (oc6c12eede723 instanceof oc5bc92c04e9) {
                        ((oc5bc92c04e9)oc6c12eede723).\u0169 = 6.0f;
                    } else if (oc6c12eede723 instanceof oc65014da549) {
                        ((oc65014da549)oc6c12eede723).\u057a = 6.0f;
                    } else if (oc6c12eede723 instanceof oc1ce8db3bf9) {
                        ((oc1ce8db3bf9)oc6c12eede723).\u0191 = 6.0f;
                    } else if (oc6c12eede723 instanceof oc9953295ed5 && ((oc9953295ed5)oc6c12eede723).\u0565 != null) {
                        ((oc9953295ed5)oc6c12eede723).\u042e = 6.0f;
                    } else if (oc6c12eede723 instanceof oc74d4657d04) {
                        ((oc74d4657d04)oc6c12eede723).\u04d9 = 6.0f;
                    } else if (oc6c12eede723 instanceof ocfd4ff6075d) {
                        ((ocfd4ff6075d)oc6c12eede723).\u0463(6.0f);
                    }
                    ++n;
                }
                f2 = f4 + this.\u0480(oc33f4d4e69a2) + f6 * f3;
                continue;
            }
            oc6c12eede722.z$18gzyyc94suow(f2);
            oc33f4d4e69a2 = this.\u00f0(oc6c12eede722);
            float f8 = f3 = oc33f4d4e69a2 != null ? 6.0f : 0.0f;
            if (oc6c12eede722 instanceof oc6beef1c60b) {
                ((oc6beef1c60b)oc6c12eede722).\u03cc = f3;
            } else if (oc6c12eede722 instanceof oc5bc92c04e9) {
                ((oc5bc92c04e9)oc6c12eede722).\u0169 = f3;
            } else if (oc6c12eede722 instanceof oc65014da549) {
                ((oc65014da549)oc6c12eede722).\u057a = f3;
            } else if (oc6c12eede722 instanceof oc1ce8db3bf9) {
                ((oc1ce8db3bf9)oc6c12eede722).\u0191 = f3;
            } else if (oc6c12eede722 instanceof oc9953295ed5 && ((oc9953295ed5)oc6c12eede722).\u0565 != null) {
                ((oc9953295ed5)oc6c12eede722).\u042e = f3;
            } else if (oc6c12eede722 instanceof oc74d4657d04) {
                ((oc74d4657d04)oc6c12eede722).\u04d9 = f3;
            } else if (oc6c12eede722 instanceof ocfd4ff6075d) {
                ((ocfd4ff6075d)oc6c12eede722).\u0463(f3);
            }
            f2 += this.\u0480(oc6c12eede722);
            ++n;
        }
    }

    @Override
    public void z$1wkvejfd36e8w() {
        int n;
        if (this.\u01e7() && (this.\u0282 || this.\u0389 != null)) {
            double d;
            double d2 = this.\u0282 && this.\u0389 != null ? (double)this.\u0389.\u01df(0.0f, 120.0f, 1) : (d = this.\u0389 != null && !this.\u0282 ? (double)(120.0f - this.\u0389.\u01df(0.0f, 120.0f, 1)) : 120.0);
            if (d == 0.0) {
                this.\u0389 = null;
            }
            ocbd4917c4b1.\u04da(this.\u02a4.\u01a9(), this.\u02a4.\u0406() + this.\u0182, this.\u02a4.\u01a9() + this.\u02a4.\u0232(), this.\u02a4.\u0406() + 16.0f + this.\u0182, 8.0f, oc7ab2161b9f.\u04ac(I, (int)d));
        }
        int n2 = n = this.\u0523.z$3rzb3dil7uydr() ? \u04a2 : \u0203;
        if (this.\u0523.\u044a() == oce4cea752dd.\u051d && !(this.\u0523 instanceof oc4cf31984d9) && !((ocdd0f49ff2f)this.\u0523).\u018b && oc2cf3d80e17.\u0115 != null && oc2cf3d80e17.\u0115.\u01da() == this.\u0523) {
            n = \u0231;
        }
        boolean bl = this.\u02b7 != null;
        oc1378bc114d oc1378bc114d2 = oc6a43806f12.\u0109();
        if (this.\u01e7()) {
            float f = this.\u02a4.\u01a9() + this.\u02a4.\u0232() / 2.0f - (float)oc1378bc114d2.z$toz8pt08w0nc(this.\u0523.getDisplayName()) / 2.0f;
            float f2 = this.\u02a4.\u0406() + this.\u0182 + 4.0f;
            oc1378bc114d2.z$ao2ykh4tuw6w(this.\u0523.getDisplayName(), f, f2, n, true);
        }
        if (bl) {
            ScaledResolution scaledResolution = new ScaledResolution(Minecraft.getMinecraft());
            int n3 = scaledResolution.getScaleFactor();
            double d = oc2c25634a7e.\u0196();
            float f = this.\u02a4.\u0523() - this.\u02a4.\u0406();
            int n4 = (int)Math.floor((double)(this.\u02a4.\u01a9() - 2.0f) * d * (double)n3);
            int n5 = (int)Math.floor(((double)scaledResolution.getScaledHeight() - (double)(this.\u02a4.\u0406() + this.\u0182 + this.\u021f + f) * d) * (double)n3);
            int n6 = (int)Math.ceil((double)(this.\u02a4.\u0232() + 4.0f) * d * (double)n3);
            int n7 = (int)Math.ceil((double)this.\u021f * d * (double)n3);
            this.\u0587(n4, n5, n6, n7);
        }
        if (this.\u0224 || this.\u02b7 != null) {
            this.\u00ca();
        }
        if (bl) {
            this.\u016e();
        }
    }

    @Override
    public float z$2rmsdj781vrn2() {
        if (this.\u02b7 != null) {
            return this.\u021f;
        }
        if (!this.\u0224) {
            return this.\u01de();
        }
        float f = this.\u01de();
        for (oc6c12eede72 oc6c12eede722 : this.\u0376) {
            f += this.\u0520(oc6c12eede722);
        }
        return f;
    }

    @Override
    public int z$1lb9sjzihunat() {
        return Math.round(this.z$2rmsdj781vrn2());
    }

    public void \u00d0() {
        for (oc6c12eede72 oc6c12eede722 : this.\u0376) {
            if (!(oc6c12eede722 instanceof oc6beef1c60b)) continue;
            ((oc6beef1c60b)oc6c12eede722).\u0215();
        }
    }

    public float \u0454() {
        if (this.\u0224 || this.\u02b7 != null && this.\u0208 > 16.0f) {
            float f = this.\u01de();
            for (oc6c12eede72 oc6c12eede722 : this.\u0376) {
                if (!this.\u010c(oc6c12eede722)) continue;
                oc33f4d4e69a oc33f4d4e69a2 = this.\u00f0(oc6c12eede722);
                float f2 = oc33f4d4e69a2 != null ? oc33f4d4e69a2.\u042c() : 1.0f;
                float f3 = oc33f4d4e69a2 != null && oc33f4d4e69a2.\u04c4 ? Math.max(f2, 1.0f) : f2;
                f += this.\u0480(oc6c12eede722) * f3;
            }
            return f;
        }
        return this.z$2rmsdj781vrn2();
    }

    @Override
    public void z$3dv8qdlj15ex7(int n, int n2) {
        for (oc6c12eede72 oc6c12eede722 : this.\u0376) {
            oc6c12eede722.z$3dv8qdlj15ex7(n, n2);
        }
        if (this.\u01e7() && this.k(n, n2) && this.\u02a4.\u00de) {
            this.\u0282 = true;
            if (this.\u0389 == null) {
                this.\u0389 = new oc5f2027353d(75.0f);
                this.\u0389.\u039e();
                this.\u0275 = true;
            }
        } else {
            if (this.\u0282 && this.\u0275) {
                this.\u0389 = new oc5f2027353d(75.0f);
                this.\u0389.\u039e();
            }
            this.\u0275 = false;
            this.\u0282 = false;
        }
    }

    @Override
    public boolean z$1qf5sz783tgla(int n, int n2, int n3) {
        if (this.\u01e7() && this.k(n, n2) && n3 == 0 && this.\u0523.canBeEnabled()) {
            this.\u0523.z$11p1yfisf2riw();
            return true;
        }
        if (this.\u01e7() && this.k(n, n2) && n3 == 1) {
            float f;
            float f2;
            this.\u0541 = f2 = this.\u02b7 != null ? this.\u021f : (this.\u0224 ? this.z$2rmsdj781vrn2() : 16.0f);
            boolean bl = this.\u0224 = !this.\u0224;
            if (this.\u0224) {
                float f3 = this.\u01de();
                for (oc6c12eede72 oc6c12eede722 : this.\u0376) {
                    f3 += this.\u0520(oc6c12eede722);
                }
                f = f3;
            } else {
                f = this.\u01de();
            }
            this.\u0208 = f;
            this.\u02b7 = new oc5f2027353d(250.0f);
            this.\u02b7.\u039e();
            return true;
        }
        for (oc6c12eede72 oc6c12eede723 : this.\u0376) {
            if (!oc6c12eede723.z$1qf5sz783tgla(n, n2, n3)) continue;
            return true;
        }
        return false;
    }

    @Override
    public void z$1n0m425nu1zvd(int n, int n2, int n3) {
        for (oc6c12eede72 oc6c12eede722 : this.\u0376) {
            oc6c12eede722.z$1n0m425nu1zvd(n, n2, n3);
        }
    }

    @Override
    public void z$zr5dl604ndgu(char c, int n) {
        for (oc6c12eede72 oc6c12eede722 : this.\u0376) {
            oc6c12eede722.z$zr5dl604ndgu(c, n);
        }
    }

    @Override
    public void z$vm4dmbdypoel(int n) {
        for (oc6c12eede72 oc6c12eede722 : this.\u0376) {
            oc6c12eede722.z$vm4dmbdypoel(n);
        }
    }

    @Override
    public void z$19sxbvum8v80h() {
        float f;
        for (oc6c12eede72 oc6c12eede722 : this.\u0376) {
            oc6c12eede722.z$19sxbvum8v80h();
        }
        this.\u02b7 = null;
        this.\u0389 = null;
        this.\u021f = f = this.\u0224 ? this.z$2rmsdj781vrn2() : this.\u01de();
        this.\u0541 = f;
        this.\u0208 = f;
    }

    public boolean k(int n, int n2) {
        if (!this.\u01e7()) {
            return false;
        }
        return (float)n > this.\u02a4.\u01a9() && (float)n < this.\u02a4.\u01a9() + this.\u02a4.\u0232() && (float)n2 > this.\u02a4.\u0523() + this.\u0182 && (float)n2 < this.\u02a4.\u0523() + 16.0f + this.\u0182;
    }

    public void \u01e3() {
        this.\u02a4.\u0415();
    }

    public boolean \u047c(oc6c12eede72 oc6c12eede722) {
        if (!this.\u010c(oc6c12eede722)) {
            return false;
        }
        oc33f4d4e69a oc33f4d4e69a2 = this.\u00f0(oc6c12eede722);
        if (oc33f4d4e69a2 == null) {
            return true;
        }
        return oc33f4d4e69a2.\u042c() > 0.0f;
    }

    private oc33f4d4e69a \u00f0(oc6c12eede72 oc6c12eede722) {
        return this.\u01a3.get(oc6c12eede722);
    }

    private String \u0144(oc6c12eede72 oc6c12eede722) {
        if (oc6c12eede722 instanceof oc6beef1c60b && ((oc6beef1c60b)oc6c12eede722).\u050d.\u026c != null) {
            return ((oc6beef1c60b)oc6c12eede722).\u050d.\u026c.z$18nrktuqeiysv();
        }
        if (oc6c12eede722 instanceof oc5bc92c04e9 && ((oc5bc92c04e9)oc6c12eede722).\u03ff.\u0415 != null) {
            return ((oc5bc92c04e9)oc6c12eede722).\u03ff.\u0415.z$18nrktuqeiysv();
        }
        if (oc6c12eede722 instanceof oc65014da549) {
            N n = ((oc65014da549)oc6c12eede722).\u0502;
            if (n instanceof oca9cc61aada && ((oca9cc61aada)n).\u026c != null) {
                return ((oca9cc61aada)n).\u026c.z$18nrktuqeiysv();
            }
            if (n instanceof ocada7dda290 && ((ocada7dda290)n).\u0467 != null) {
                return ((ocada7dda290)n).\u0467.z$18nrktuqeiysv();
            }
        }
        if (oc6c12eede722 instanceof oc1ce8db3bf9 && ((oc1ce8db3bf9)oc6c12eede722).\u00dc.\u03e1 != null) {
            return ((oc1ce8db3bf9)oc6c12eede722).\u00dc.\u03e1.z$18nrktuqeiysv();
        }
        if (oc6c12eede722 instanceof oc9953295ed5 && ((oc9953295ed5)oc6c12eede722).\u0565 != null && ((oc9953295ed5)oc6c12eede722).\u0565.\u044d != null) {
            return ((oc9953295ed5)oc6c12eede722).\u0565.\u044d.z$18nrktuqeiysv();
        }
        if (oc6c12eede722 instanceof oc74d4657d04 && ((oc74d4657d04)oc6c12eede722).\u0565.a != null) {
            return ((oc74d4657d04)oc6c12eede722).\u0565.a.z$18nrktuqeiysv();
        }
        if (oc6c12eede722 instanceof ocfd4ff6075d) {
            return ((ocfd4ff6075d)oc6c12eede722).z$181tlwmlg110c();
        }
        return "";
    }

    private void \u0239() {
        Object object;
        this.\u01a3.clear();
        this.\u012e.clear();
        for (oc6c12eede72 oc6c12eede722 : this.\u0376) {
            if (!(oc6c12eede722 instanceof oc33f4d4e69a)) continue;
            object = (oc33f4d4e69a)oc6c12eede722;
            this.\u012e.put(((oc33f4d4e69a)object).\u018d.z$18nrktuqeiysv(), (oc33f4d4e69a)object);
        }
        for (oc6c12eede72 oc6c12eede722 : this.\u0376) {
            oc33f4d4e69a oc33f4d4e69a2;
            object = this.\u0144(oc6c12eede722);
            if (((String)object).isEmpty() || (oc33f4d4e69a2 = this.\u012e.get(object)) == null) continue;
            this.\u01a3.put(oc6c12eede722, oc33f4d4e69a2);
        }
    }

    private float \u0480(oc6c12eede72 oc6c12eede722) {
        if (oc6c12eede722 instanceof oc6beef1c60b) {
            return 16.0f;
        }
        if (oc6c12eede722 instanceof oc5bc92c04e9) {
            return 16.0f;
        }
        if (oc6c12eede722 instanceof oc65014da549) {
            return oc6c12eede722.z$2rmsdj781vrn2();
        }
        if (oc6c12eede722 instanceof oc74d4657d04) {
            oc74d4657d04 oc74d4657d042 = (oc74d4657d04)oc6c12eede722;
            float f = oc74d4657d042.\u01e2();
            return 12.0f + (oc74d4657d042.\u019d() - 12.0f) * f;
        }
        if (oc6c12eede722 instanceof oc81019d75fb || oc6c12eede722 instanceof ocf22d09661d || oc6c12eede722 instanceof oc0e37bc27e8 || oc6c12eede722 instanceof oc03d1b35e89) {
            return oc6c12eede722.z$2rmsdj781vrn2();
        }
        return 12.0f;
    }

    private float \u0520(oc6c12eede72 oc6c12eede722) {
        if (!this.\u010c(oc6c12eede722)) {
            return 0.0f;
        }
        float f = this.\u0480(oc6c12eede722);
        oc33f4d4e69a oc33f4d4e69a2 = this.\u00f0(oc6c12eede722);
        float f2 = oc33f4d4e69a2 != null ? oc33f4d4e69a2.\u042c() : 1.0f;
        return f * f2;
    }

    private void \u00ca() {
        oc6c12eede72 oc6c12eede722;
        oc6c12eede72 oc6c12eede723;
        int n = 0;
        block0: while (n < this.\u0376.size()) {
            oc6c12eede723 = this.\u0376.get(n);
            if (!this.\u010c(oc6c12eede723)) {
                ++n;
                continue;
            }
            if (oc6c12eede723 instanceof oc33f4d4e69a) {
                ((oc33f4d4e69a)oc6c12eede723).z$1wkvejfd36e8w();
                ++n;
                while (n < this.\u0376.size()) {
                    oc6c12eede722 = this.\u0376.get(n);
                    if (!this.\u010c(oc6c12eede722)) {
                        ++n;
                        continue;
                    }
                    if (this.\u00f0(oc6c12eede722) != oc6c12eede723) continue block0;
                    ++n;
                }
                continue;
            }
            oc6c12eede723.z$1wkvejfd36e8w();
            ++n;
        }
        n = 0;
        while (n < this.\u0376.size()) {
            oc6c12eede723 = this.\u0376.get(n);
            if (!this.\u010c(oc6c12eede723)) {
                ++n;
                continue;
            }
            if (oc6c12eede723 instanceof oc33f4d4e69a) {
                oc6c12eede722 = (oc33f4d4e69a)oc6c12eede723;
                float f = ((oc33f4d4e69a)oc6c12eede722).\u042c();
                float f2 = this.\u02a4.\u0523() + ((oc33f4d4e69a)oc6c12eede722).z$d6ehueststre() + this.\u0480(oc6c12eede722);
                float f3 = 0.0f;
                int n2 = ++n;
                while (n2 < this.\u0376.size()) {
                    oc6c12eede72 oc6c12eede724 = this.\u0376.get(n2);
                    if (!this.\u010c(oc6c12eede724)) {
                        ++n2;
                        continue;
                    }
                    if (this.\u00f0(oc6c12eede724) != oc6c12eede722) break;
                    f3 += this.\u0480(oc6c12eede724);
                    ++n2;
                }
                if (f > 0.0f && f3 > 0.0f) {
                    float f4 = f3 * f;
                    ScaledResolution scaledResolution = new ScaledResolution(Minecraft.getMinecraft());
                    int n3 = scaledResolution.getScaleFactor();
                    double d = oc2c25634a7e.\u0196();
                    double d2 = scaledResolution.getScaledHeight();
                    float f5 = this.\u02a4.\u01a9();
                    float f6 = this.\u02a4.\u0232() + 4.0f;
                    int n4 = (int)Math.floor((double)f5 * d * (double)n3);
                    int n5 = (int)Math.ceil((double)(f5 + f6) * d * (double)n3);
                    int n6 = Math.max(0, n5 - n4);
                    int n7 = (int)Math.floor((d2 - (double)(f2 + f4) * d) * (double)n3);
                    int n8 = (int)Math.ceil((d2 - (double)f2 * d) * (double)n3);
                    int n9 = Math.max(0, n8 - n7);
                    this.\u0587(n4, n7, n6, n9);
                    while (n < n2) {
                        oc6c12eede72 oc6c12eede725 = this.\u0376.get(n);
                        if (this.\u010c(oc6c12eede725) && this.\u00f0(oc6c12eede725) == oc6c12eede722) {
                            oc6c12eede725.z$1wkvejfd36e8w();
                        }
                        ++n;
                    }
                    this.\u016e();
                    continue;
                }
                n = n2;
                continue;
            }
            ++n;
        }
    }

    private void \u0587(int n, int n2, int n3, int n4) {
        boolean bl = GL11.glIsEnabled(0x79136C50 ^ 0x79136041);
        int[] nArray = this.\u03dc[this.\u01eb++];
        if (bl) {
            ((Buffer)\u00e6).clear();
            oc30aea91d28.\u0539(0x79136C51 ^ 0x79136041, \u00e6);
            nArray[0] = 1;
            nArray[1] = \u00e6.get(0);
            nArray[0x79136043 ^ 0x79136041] = \u00e6.get(1);
            nArray[0x79136042 ^ 0x79136041] = \u00e6.get(0x79136043 ^ 0x79136041);
            nArray[0x79136045 ^ 0x79136041] = \u00e6.get(0x79136042 ^ 0x79136041);
            int n5 = Math.max(nArray[1], n);
            int n6 = Math.max(nArray[0x79136043 ^ 0x79136041], n2);
            int n7 = Math.max(0, Math.min(nArray[1] + nArray[0x79136042 ^ 0x79136041], n + n3) - n5);
            int n8 = Math.max(0, Math.min(nArray[0x79136043 ^ 0x79136041] + nArray[0x79136045 ^ 0x79136041], n2 + n4) - n6);
            GL11.glScissor(n5, n6, n7, n8);
        } else {
            nArray[0] = 0;
            GL11.glEnable(0x79136C50 ^ 0x79136041);
            GL11.glScissor(n, n2, n3, n4);
        }
    }

    private void \u016e() {
        int[] nArray;
        if ((nArray = this.\u03dc[--this.\u01eb])[0] == 1) {
            GL11.glScissor(nArray[1], nArray[0x5120884 ^ 0x5120886], nArray[0x5120885 ^ 0x5120886], nArray[0x5120882 ^ 0x5120886]);
        } else {
            GL11.glDisable(0x5120497 ^ 0x5120886);
        }
    }

    private boolean \u010c(oc6c12eede72 oc6c12eede722) {
        return oc6c12eede722.z$2c04w2bvpwmu9();
    }

    private boolean \u01e7() {
        return !this.\u0427;
    }

    private float \u01de() {
        return this.\u01e7() ? 16.0f : 0.0f;
    }

    private float \u00e0() {
        return this.\u01e7() ? 12.0f : 0.0f;
    }
}

