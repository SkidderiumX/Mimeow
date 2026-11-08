/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import net.minecraft.item.ItemStack;
import x.L;
import x.oc057476a9f5;
import x.oc1e7298eef6;
import x.oc6928adbdaa;
import x.oc9bcf1497a7;
import x.ocad69c23202;
import x.ocd9db3ede42;

public class ocac488f5520 {
    private final List<oc6928adbdaa> \u045e = new ArrayList<oc6928adbdaa>();
    private boolean \u0570;
    private float[] \u0438;
    private final Deque<float[]> \u00f4;

    public ocac488f5520() {
        float[] fArray = new float[0xAC5CB88B ^ 0xAC5CB88D];
        fArray[0] = 1.0f;
        fArray[1] = 0.0f;
        fArray[0xAC5CB88F ^ 0xAC5CB88D] = 0.0f;
        fArray[0xAC5CB88E ^ 0xAC5CB88D] = 1.0f;
        fArray[0xAC5CB889 ^ 0xAC5CB88D] = 0.0f;
        fArray[0xAC5CB888 ^ 0xAC5CB88D] = 0.0f;
        this.\u0438 = fArray;
        this.\u00f4 = new ArrayDeque<float[]>();
    }

    public ocac488f5520 \u019a() {
        this.\u0570 = true;
        return this;
    }

    public List<oc6928adbdaa> t() {
        return Collections.unmodifiableList(this.\u045e);
    }

    public ocac488f5520 B(String string, float ... fArray) {
        this.\u045e.add(new oc6928adbdaa(string, null, fArray));
        return this;
    }

    public ocac488f5520 \u0566() {
        this.\u00f4.push((float[])this.\u0438.clone());
        return this.B("push", new float[0]);
    }

    public ocac488f5520 \u0408() {
        this.\u0438 = this.\u00f4.pop();
        return this.B("pop", new float[0]);
    }

    public ocac488f5520 \u03e8(float f, float f2, float f3) {
        this.\u0438[0x2F1ABCD0 ^ 0x2F1ABCD4] = f * this.\u0438[0] + f2 * this.\u0438[0x2F1ABCD6 ^ 0x2F1ABCD4] + this.\u0438[0x2F1ABCD0 ^ 0x2F1ABCD4];
        this.\u0438[0x2F1ABCD1 ^ 0x2F1ABCD4] = f * this.\u0438[1] + f2 * this.\u0438[0x2F1ABCD7 ^ 0x2F1ABCD4] + this.\u0438[0x2F1ABCD1 ^ 0x2F1ABCD4];
        float[] fArray = new float[0x2F1ABCD7 ^ 0x2F1ABCD4];
        fArray[0] = f;
        fArray[1] = f2;
        fArray[0x2F1ABCD6 ^ 0x2F1ABCD4] = f3;
        return this.B("translate", fArray);
    }

    public ocac488f5520 \u042e(float f, float f2, float f3) {
        this.\u0438[0] = this.\u0438[0] * f;
        this.\u0438[1] = this.\u0438[1] * f;
        this.\u0438[0x43832A1A ^ 0x43832A18] = this.\u0438[0x43832A1A ^ 0x43832A18] * f2;
        this.\u0438[0x43832A1B ^ 0x43832A18] = this.\u0438[0x43832A1B ^ 0x43832A18] * f2;
        float[] fArray = new float[0x43832A1B ^ 0x43832A18];
        fArray[0] = f;
        fArray[1] = f2;
        fArray[0x43832A1A ^ 0x43832A18] = f3;
        return this.B("scale", fArray);
    }

    public ocac488f5520 \u047c(float f, float f2, float f3, float f4) {
        float[] fArray = new float[0x82B8DFEF ^ 0x82B8DFEB];
        fArray[0] = f;
        fArray[1] = f2;
        fArray[0x82B8DFE9 ^ 0x82B8DFEB] = f3;
        fArray[0x82B8DFE8 ^ 0x82B8DFEB] = f4;
        return this.B("rotate", fArray);
    }

    public ocac488f5520 \u04a2(oc057476a9f5 oc057476a9f52, float f) {
        float[] fArray = new float[0xC01F9F2A ^ 0xC01F9F2E];
        fArray[0] = oc057476a9f52.\u0130;
        fArray[1] = oc057476a9f52.\u0562;
        fArray[0xC01F9F2C ^ 0xC01F9F2E] = oc057476a9f52.\u01b8;
        fArray[0xC01F9F2D ^ 0xC01F9F2E] = f;
        return this.B("color", fArray);
    }

    public ocac488f5520 \u0104(float f, float f2, float f3, float f4) {
        float[] fArray = new float[0x8751DBAB ^ 0x8751DBAF];
        fArray[0] = f;
        fArray[1] = f2;
        fArray[0x8751DBAD ^ 0x8751DBAF] = f3;
        fArray[0x8751DBAC ^ 0x8751DBAF] = f4;
        return this.B("color", fArray);
    }

    public ocac488f5520 \u0297(float f) {
        return this.B("lineWidth", f);
    }

    public ocac488f5520 \u04cb(int n, int n2, int n3, int n4, int n5) {
        float[] fArray = new float[1 + n5 * n2];
        fArray[0] = n;
        for (int i = 0; i < n5; ++i) {
            int n6 = L.\u0473(n4 + i * (0xD109767D ^ 0xD109767F));
            for (int j = 0; j < n2; ++j) {
                fArray[1 + i * n2 + j] = L.\u026d(n3 + (n6 * n2 + j) * (0xD109767B ^ 0xD109767F));
            }
        }
        this.\u045e.add(new oc6928adbdaa("vertices" + n2, null, fArray));
        return this;
    }

    public ocac488f5520 \u00ba(int n) {
        int n2;
        int n3;
        int n4;
        int n5;
        int n6 = switch (n) {
            case 168960 -> {
                n5 = 0x881EA4FE ^ 0x881EA4FB;
                n4 = 0x881EA4F5 ^ 0x881EA4FB;
                n3 = 0x880A58EB ^ 0x881EA4FB;
                n2 = 0x880A588B ^ 0x881EA4FB;
                yield 0x881EA4F8 ^ 0x881EA4FB;
            }
            case 169008 -> {
                n5 = 1;
                n4 = 0x881EA4E3 ^ 0x881EA4FB;
                n3 = 0x880A58EB ^ 0x881EA4FB;
                n2 = 0x880A587B ^ 0x881EA4FB;
                yield 0x881EA4F8 ^ 0x881EA4FB;
            }
            case 169120 -> {
                n5 = 0x881EA4FE ^ 0x881EA4FB;
                n4 = 0x881EA4FF ^ 0x881EA4FB;
                n3 = 0x880A585B ^ 0x881EA4FB;
                n2 = 0x880A583B ^ 0x881EA4FB;
                yield 0x881EA4F9 ^ 0x881EA4FB;
            }
            case 169168 -> {
                n5 = 0x881EA4F9 ^ 0x881EA4FB;
                n4 = 0x881EA4FF ^ 0x881EA4FB;
                n3 = 0x880A585B ^ 0x881EA4FB;
                n2 = 0x880A583F ^ 0x881EA4FB;
                yield 0x881EA4F9 ^ 0x881EA4FB;
            }
            case 169280 -> {
                n5 = 0x881EA4FD ^ 0x881EA4FB;
                n4 = 0x881EA4FF ^ 0x881EA4FB;
                n3 = 0x880A582B ^ 0x881EA4FB;
                n2 = 0x880A580B ^ 0x881EA4FB;
                yield 0x881EA4F9 ^ 0x881EA4FB;
            }
            case 169328 -> {
                n5 = 0x881EA4F9 ^ 0x881EA4FB;
                n4 = 0x881EA4FF ^ 0x881EA4FB;
                n3 = 0x880A582B ^ 0x881EA4FB;
                n2 = 0x880A580F ^ 0x881EA4FB;
                yield 0x881EA4F9 ^ 0x881EA4FB;
            }
            default -> throw new IllegalArgumentException("Unknown recovered draw helper");
        };
        float[] fArray = new float[1 + n4 * n6];
        fArray[0] = n5;
        for (int i = 0; i < n4; ++i) {
            int n7 = L.\u0497(n2 + (i & (0x77E15B07 ^ 0x881EA4FB))) >>> (i & (0x881EA4F8 ^ 0x881EA4FB)) * (0x881EA4F3 ^ 0x881EA4FB) & (0x881EA404 ^ 0x881EA4FB);
            for (int j = 0; j < n6; ++j) {
                fArray[1 + i * n6 + j] = L.\u026d(n3 + (n7 * n6 + j) * (0x881EA4FF ^ 0x881EA4FB));
            }
        }
        this.\u045e.add(new oc6928adbdaa("vertices" + n6, null, fArray));
        return this;
    }

    public ocac488f5520 \u0197(int n, int n2, float ... fArray) {
        float[] fArray2 = new float[fArray.length + 1];
        fArray2[0] = n;
        System.arraycopy(fArray, 0, fArray2, 1, fArray.length);
        this.\u045e.add(new oc6928adbdaa("vertices" + n2, null, fArray2));
        return this;
    }

    public ocac488f5520 \u0138(float f, float f2, float f3, float f4) {
        if (this.\u0570) {
            float[] fArray = new float[0x6270B13E ^ 0x6270B13B];
            fArray[0] = 1.0f;
            fArray[1] = f;
            fArray[0x6270B139 ^ 0x6270B13B] = f2;
            fArray[0x6270B138 ^ 0x6270B13B] = f3;
            fArray[0x6270B13F ^ 0x6270B13B] = f4;
            this.\u045e.add(new oc6928adbdaa("vertices2", Boolean.TRUE, fArray));
            return this;
        }
        float[] fArray = new float[0x6270B13F ^ 0x6270B13B];
        fArray[0] = f;
        fArray[1] = f2;
        fArray[0x6270B139 ^ 0x6270B13B] = f3;
        fArray[0x6270B138 ^ 0x6270B13B] = f4;
        return this.\u0197(1, 0x6270B139 ^ 0x6270B13B, fArray);
    }

    public ocac488f5520 \u051b(String string, float f, float f2, int n, boolean bl, float f3) {
        float[] fArray = new float[0x78ABC708 ^ 0x78ABC70D];
        fArray[0] = f;
        fArray[1] = f2;
        fArray[0x78ABC70F ^ 0x78ABC70D] = Float.intBitsToFloat(n);
        fArray[0x78ABC70E ^ 0x78ABC70D] = bl ? 1.0f : 0.0f;
        fArray[0x78ABC709 ^ 0x78ABC70D] = f3;
        this.\u045e.add(new oc6928adbdaa("text", string, fArray));
        return this;
    }

    public float \u00ff(String string, float f, float f2, int n, float f3, int n2) {
        return this.\u03ad(string, f, f2, n, f3, n2, 0);
    }

    public float \u03ad(String string, float f, float f2, int n, float f3, int n2, int n3) {
        ocad69c23202 ocad69c232022 = oc1e7298eef6.\u0532(string, f, f2, f3, n2, this.\u0438, n3);
        float[] fArray = new float[0x8D979CD3 ^ 0x8D979CD6];
        fArray[0] = f;
        fArray[1] = f2;
        fArray[0x8D979CD4 ^ 0x8D979CD6] = Float.intBitsToFloat(n);
        fArray[0x8D979CD5 ^ 0x8D979CD6] = 0.0f;
        fArray[0x8D979CD2 ^ 0x8D979CD6] = f3;
        this.\u045e.add(new oc6928adbdaa("text", ocad69c232022, fArray));
        return ocad69c232022.\u02a6;
    }

    public ocac488f5520 \u01ff(int n, int n2, int n3, byte[] byArray, List<float[]> list, int n4) {
        oc9bcf1497a7 oc9bcf1497a72 = new oc9bcf1497a7(n, n2, n3, byArray, list);
        ocad69c23202 ocad69c232022 = new ocad69c23202("", Collections.singletonList(oc9bcf1497a72), 0.0f);
        float[] fArray = new float[0xC4ACA1A7 ^ 0xC4ACA1A2];
        fArray[0] = 0.0f;
        fArray[1] = 0.0f;
        fArray[0xC4ACA1A0 ^ 0xC4ACA1A2] = Float.intBitsToFloat(n4);
        fArray[0xC4ACA1A1 ^ 0xC4ACA1A2] = 0.0f;
        fArray[0xC4ACA1A6 ^ 0xC4ACA1A2] = 0.0f;
        this.\u045e.add(new oc6928adbdaa("text", ocad69c232022, fArray));
        return this;
    }

    public ocac488f5520 \u03e1(ItemStack itemStack, float f, float f2) {
        float[] fArray = new float[0xD3B4E61B ^ 0xD3B4E619];
        fArray[0] = f;
        fArray[1] = f2;
        this.\u045e.add(new oc6928adbdaa("item", itemStack, fArray));
        return this;
    }

    public ocac488f5520 \u0217(float f, float f2, float f3, float f4, float f5) {
        float[] fArray = new float[0xA05DCACE ^ 0xA05DCACB];
        fArray[0] = f;
        fArray[1] = f2;
        fArray[0xA05DCAC9 ^ 0xA05DCACB] = f3;
        fArray[0xA05DCAC8 ^ 0xA05DCACB] = f4;
        fArray[0xA05DCACF ^ 0xA05DCACB] = f5;
        return this.B("roundedRect", fArray);
    }

    public ocac488f5520 \u04d2(float f, float f2, float f3, float f4) {
        float[] fArray = new float[0xF30B49F6 ^ 0xF30B49F2];
        fArray[0] = f;
        fArray[1] = f2;
        fArray[0xF30B49F0 ^ 0xF30B49F2] = f3;
        fArray[0xF30B49F1 ^ 0xF30B49F2] = f4;
        return this.B("screenClip", fArray);
    }

    public ocac488f5520 \u021a() {
        return this.B("unclip", new float[0]);
    }

    public ocac488f5520 \u048f(float f, float f2, float f3, float f4, float f5) {
        float[] fArray = new float[0x41041189 ^ 0x4104118C];
        fArray[0] = f;
        fArray[1] = f2;
        fArray[0x4104118E ^ 0x4104118C] = f3;
        fArray[0x4104118F ^ 0x4104118C] = f4;
        fArray[0x41041188 ^ 0x4104118C] = f5;
        return this.B("roundedStroke", fArray);
    }

    public ocac488f5520 \u0176(float f) {
        return this.B("opacity", f);
    }

    public ocac488f5520 \u054d(ocd9db3ede42 ocd9db3ede422, float[] fArray, float[] fArray2) {
        float[] fArray3 = new float[0xC7BFB74 ^ 0xC7BFB78];
        fArray3[0] = ocd9db3ede422.\u00c8;
        fArray3[1] = ocd9db3ede422.\u0151;
        fArray3[0xC7BFB7A ^ 0xC7BFB78] = ocd9db3ede422.\u0423;
        fArray3[0xC7BFB7B ^ 0xC7BFB78] = ocd9db3ede422.\u0462;
        fArray3[0xC7BFB7C ^ 0xC7BFB78] = fArray[0];
        fArray3[0xC7BFB7D ^ 0xC7BFB78] = fArray[1];
        fArray3[0xC7BFB7E ^ 0xC7BFB78] = fArray[0xC7BFB7A ^ 0xC7BFB78];
        fArray3[0xC7BFB7F ^ 0xC7BFB78] = fArray[0xC7BFB7B ^ 0xC7BFB78];
        fArray3[0xC7BFB70 ^ 0xC7BFB78] = fArray2[0];
        fArray3[0xC7BFB71 ^ 0xC7BFB78] = fArray2[1];
        fArray3[0xC7BFB72 ^ 0xC7BFB78] = fArray2[0xC7BFB7A ^ 0xC7BFB78];
        fArray3[0xC7BFB73 ^ 0xC7BFB78] = fArray2[0xC7BFB7B ^ 0xC7BFB78];
        return this.B("gradient", fArray3);
    }

    public ocac488f5520 \u014e(ocd9db3ede42 ocd9db3ede422, float f, float[] ... fArray) {
        float[] fArray2 = new float[(0x3C62356 ^ 0x3C62353) + fArray.length * (0x3C62357 ^ 0x3C62353)];
        fArray2[0] = ocd9db3ede422.\u00c8;
        fArray2[1] = ocd9db3ede422.\u0151;
        fArray2[0x3C62351 ^ 0x3C62353] = ocd9db3ede422.\u0423;
        fArray2[0x3C62350 ^ 0x3C62353] = ocd9db3ede422.\u0462;
        fArray2[0x3C62357 ^ 0x3C62353] = f;
        for (int i = 0; i < fArray.length; ++i) {
            System.arraycopy(fArray[i], 0, fArray2, (0x3C62356 ^ 0x3C62353) + i * (0x3C62357 ^ 0x3C62353), 0x3C62357 ^ 0x3C62353);
        }
        return this.B("pillGradient", fArray2);
    }

    public ocac488f5520 \u056c(float f, float f2, float f3) {
        float[] fArray = new float[0xD8E3235E ^ 0xD8E3235D];
        fArray[0] = f;
        fArray[1] = f2;
        fArray[0xD8E3235F ^ 0xD8E3235D] = f3;
        return this.B("circleStroke", fArray);
    }

    public ocac488f5520 \u03bd(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        float[] fArray = new float[0xBC8371D4 ^ 0xBC8371DC];
        fArray[0] = f;
        fArray[1] = f2;
        fArray[0xBC8371DE ^ 0xBC8371DC] = f3;
        fArray[0xBC8371DF ^ 0xBC8371DC] = f4;
        fArray[0xBC8371D8 ^ 0xBC8371DC] = f5;
        fArray[0xBC8371D9 ^ 0xBC8371DC] = f6;
        fArray[0xBC8371DA ^ 0xBC8371DC] = f7;
        fArray[0xBC8371DB ^ 0xBC8371DC] = f8;
        return this.B("roundedRectVarying", fArray);
    }

    public ocac488f5520 \u03fd(int n) {
        return this.B("enable", n);
    }

    public ocac488f5520 \u016e(int n) {
        return this.B("disable", n);
    }
}

