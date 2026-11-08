/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import x.L;
import x.oc116f3f7aec;
import x.oc3004491957;
import x.oc62a465bc97;
import x.oc98904eb9e7;
import x.ocd9db3ede42;
import x.oce4a4c32971;

public class oc35e4c54bd4 {
    public int \u00fa;
    public int \u0107;
    public int \u04c5;
    public boolean \u01db;
    public boolean \u00c7;
    public boolean \u0113;
    public boolean \u03ef;
    public boolean \u043c;
    public boolean \u0263;
    public float \u0220;
    public float \u0226;
    public float \u024e;
    public float \u04b8;
    public float \u0102;
    public float \u0119;
    public float \u0455;
    public float \u01f6;
    public float \u0464;
    public float \u0544;
    public float \u041f;
    public float \u0180;
    public double \u0460;
    public double \u00c9;
    public double \u057a;
    public Object \u0580;
    public oc116f3f7aec \u0183;
    public IntConsumer \u01ea;
    public Consumer<String> D;
    public Runnable b;
    public final StringBuilder \u02c0 = new StringBuilder();
    public String \u0127;
    public String \u00ca;
    public float[] \u0373;
    public float[] \u015d;
    public final float[][] G = new float[0xE006A362 ^ 0xE006A36A][0xE006A369 ^ 0xE006A36A];
    public int \u0262;
    public List<String> \u00f3 = Collections.emptyList();
    public final List<Integer> \u054e = new ArrayList<Integer>();
    public int \u00ec;
    public double \u03f5;
    public final Deque<oce4a4c32971> \u0500 = new ArrayDeque<oce4a4c32971>();
    public int \u01d3;
    public boolean[] \u03fa = new boolean[0xE006A369 ^ 0xE006A36A];
    public boolean R;
    private Consumer<Integer> \u03ad;

    public void \u0278(double d) {
        this.\u01f6 = 0.0f;
        this.\u0119 = this.\u0102;
        this.\u0460 = d;
    }

    public oce4a4c32971 \u0164(ocd9db3ede42 ocd9db3ede422, float f, float f2, boolean bl) {
        Object object;
        ocd9db3ede42 ocd9db3ede423 = ocd9db3ede422;
        if (!this.\u0500.isEmpty()) {
            object = this.\u0500.peek().\u04e0;
            float f3 = ((ocd9db3ede42)object).\u00c8 > ocd9db3ede422.\u00c8 ? ((ocd9db3ede42)object).\u00c8 : ocd9db3ede422.\u00c8;
            float f4 = ((ocd9db3ede42)object).\u0151 > ocd9db3ede422.\u0151 ? ((ocd9db3ede42)object).\u0151 : ocd9db3ede422.\u0151;
            float f5 = ocd9db3ede422.\u0423;
            float f6 = ocd9db3ede422.\u0462;
            if (f5 + f3 > ((ocd9db3ede42)object).\u00c8 + ((ocd9db3ede42)object).\u0423 && 0.0f > (f5 = ((ocd9db3ede42)object).\u00c8 + ((ocd9db3ede42)object).\u0423 - f3)) {
                f5 = 0.0f;
            }
            if (f6 + f4 > ((ocd9db3ede42)object).\u0151 + ((ocd9db3ede42)object).\u0462 && 0.0f > (f6 = ((ocd9db3ede42)object).\u0151 + ((ocd9db3ede42)object).\u0462 - f4)) {
                f6 = 0.0f;
            }
            ocd9db3ede423 = new ocd9db3ede42(f3, f4, f5, f6);
        }
        object = new oce4a4c32971(ocd9db3ede423.\u0427(f2), f, f2);
        ((oce4a4c32971)object).\u0198 = bl;
        if (bl) {
            ((oce4a4c32971)object).\u040e = oc98904eb9e7.\u03aa(ocd9db3ede422).\u0427(f);
        }
        this.\u0500.push((oce4a4c32971)object);
        return object;
    }

    public float \u0217() {
        oce4a4c32971 oce4a4c329712 = this.\u0500.pop();
        float f = oce4a4c329712.\u054b();
        if (oce4a4c329712.\u0527 > (float)this.\u01d3) {
            this.\u01d3 = oc3004491957.\u0182(oce4a4c329712.\u0527);
        }
        return f;
    }

    public void \u0212() {
        this.\u0500.clear();
        this.\u01d3 = 0;
    }

    public boolean \u0518(ocd9db3ede42 ocd9db3ede422) {
        return !(this.\u0107 != 0 && !this.\u043c || !ocd9db3ede422.\u011e(this.\u0220, this.\u0226) || this.\u00fa != 0 && this.\u00fa != (0xF6C150DB ^ 0xF6C150D8));
    }

    public boolean f(ocd9db3ede42 ocd9db3ede422) {
        if (this.\u0518(ocd9db3ede422) && this.\u01db && !this.\u00c7) {
            this.\u00c7 = true;
            return true;
        }
        return false;
    }

    public void \u00df() {
        if (this.\u01db && !this.\u00c7) {
            this.\u00c7 = true;
        }
        this.\u00c7 = this.\u01db;
    }

    public void \u04f7(Object object, IntConsumer intConsumer) {
        this.\u00fa = 1;
        this.\u0580 = object;
        this.\u01ea = intConsumer;
    }

    public void \u00da(Object object, oc116f3f7aec oc116f3f7aec2) {
        if ((this.\u00fa & (0xD78B8A42 ^ 0x287475BC)) != (0x287475BE ^ 0x287475BC) || this.\u0580 != object) {
            this.\u00fa = 0x287475BE ^ 0x287475BC;
            this.\u02c0.setLength(0);
            this.\u0263 = false;
            this.\u0580 = object;
            this.\u0183 = oc116f3f7aec2;
        }
    }

    public boolean \u0469(Object object) {
        return (this.\u00fa & (0xE45BB076 ^ 0x1BA44F88)) == (0x1BA44F8A ^ 0x1BA44F88) && this.\u0580 == object;
    }

    public void \u0236() {
        if (this.\u00fa == (0x4D9E19B9 ^ 0x4D9E19BB)) {
            this.\u00fa = 0x4D9E19B8 ^ 0x4D9E19BB;
        }
    }

    public String \u0177() {
        if ((this.\u00fa & (0xFDA1EB47 ^ 0x25E14B9)) == (0x25E14BB ^ 0x25E14B9) && this.\u0263) {
            this.\u00fa = 0;
            this.\u0263 = false;
            return this.\u02c0.toString();
        }
        return null;
    }

    public void \u03fc() {
        this.\u00fa = 0;
        this.\u01db = false;
    }

    public boolean \u024e(int n, int n2, int n3, int n4, float f, boolean bl, byte[] byArray) {
        if (n == 1) {
            this.\u024e = n3;
            this.\u04b8 = n4;
            return false;
        }
        if (n == (0x67D531DA ^ 0x67D531D9)) {
            if (this.\u0107 == 0) {
                this.\u0119 = oc62a465bc97.\u0496(0.0f, this.\u0455, f * oc98904eb9e7.\u0132(0x67C139A9 ^ 0x67D531D9) + this.\u0119);
            }
            return false;
        }
        if (n != (0x67D531DB ^ 0x67D531D9)) {
            return false;
        }
        if (bl) {
            if ((this.\u00fa & (0x982ACE27 ^ 0x67D531D9)) == (0x67D531DB ^ 0x67D531D9)) {
                if (n2 == 1 && this.\u00fa != (0x67D531DA ^ 0x67D531D9)) {
                    this.\u00fa = 0;
                    return true;
                }
                if (n2 == (0x67D5318A ^ 0x67D531D9)) {
                    if (this.\u02c0.length() > 0) {
                        this.\u02c0.setLength(this.\u02c0.offsetByCodePoints(this.\u02c0.length(), -1));
                    }
                    return true;
                }
                if (n2 == (0x67D5318C ^ 0x67D531D9)) {
                    if (this.\u02c0.length() > 0 || this.\u0107 == 1) {
                        this.\u0263 = true;
                    }
                    return true;
                }
                if (n2 == (0x67D5318E ^ 0x67D531D9)) {
                    this.\u00fa = 0;
                    return true;
                }
                if (n2 != 1) {
                    int n5;
                    for (n5 = 0; n5 < Math.min(0x67D531DD ^ 0x67D531D9, byArray.length) && byArray[n5] != 0; ++n5) {
                    }
                    new String(byArray, 0, n5, StandardCharsets.UTF_8).codePoints().forEach(this::q31jwxuxn512qy);
                    return true;
                }
            } else {
                if (this.\u00fa == 1) {
                    this.\u01ea.accept(n2 != 1 && n2 != (0x67D5318E ^ 0x67D531D9) ? n2 : 0);
                    this.\u00fa = 0;
                    return true;
                }
                if (this.\u00fa == 0 && this.\u0107 != 0 && n2 == (0x67D5318E ^ 0x67D531D9)) {
                    this.\u04b7(true);
                    return true;
                }
            }
        }
        if (n2 == (0x67D531BD ^ 0x67D531D9) || n2 == (0x67D531BC ^ 0x67D531D9)) {
            this.\u0113 = bl;
        } else if (n2 == 1) {
            this.\u01db = bl;
        }
        return false;
    }

    public long \u0578(long l, long l2, int n, int n2, int n3, int n4, float f, boolean bl, byte[] byArray) {
        long l3 = l;
        if (n == (0xE1D5F796 ^ 0xE1D5F794) && bl && Integer.compareUnsigned(this.\u00fa, 1) <= 0) {
            l3 = l2;
        }
        return this.\u024e(n, n2, n3, n4, f, bl, byArray) ? l3 & (0xE3F8F408B0723BFEL ^ 0xE3F8F4084F8DC4FEL) | 1L : 0L;
    }

    public void \u0183(String string, Object object, oc116f3f7aec oc116f3f7aec2, Consumer<String> consumer, double d) {
        this.\u04b7(true);
        this.\u0107 = 1;
        this.\u0127 = string;
        this.\u00c9 = d;
        this.\u041f = 0.0f;
        this.\u0544 = 0.0f;
        this.D = consumer;
        this.b = () -> oc35e4c54bd4.q1njbpuxx14c0c(consumer);
        this.\u00da(object, oc116f3f7aec2);
    }

    public void \u04c4(String string, Runnable runnable2, double d) {
        this.\u04b7(true);
        this.\u0107 = 0x60136B ^ 0x601368;
        this.\u0127 = L.\u00f2(0x741C2C ^ 0x601368);
        this.\u00ca = oc98904eb9e7.\u0410(string, 0x60130C ^ 0x601368);
        this.b = runnable2;
        this.\u00c9 = d;
        this.\u041f = 0.0f;
        this.\u0544 = 0.0f;
    }

    public void \u04e9(float[] fArray, Consumer<float[]> consumer, double d) {
        this.\u026c("Color", fArray, consumer, d);
    }

    public void \u026c(String string, float[] fArray, Consumer<float[]> consumer, double d) {
        this.\u04b7(true);
        this.\u0107 = 0x7B88A6AF ^ 0x7B88A6AD;
        this.\u0127 = string;
        this.\u0373 = (float[])fArray.clone();
        this.\u015d = oc98904eb9e7.\u04f7(this.\u0373, false, false);
        this.b = () -> this.q19mqe8ongoq0z(consumer);
        this.\u00c9 = d;
        this.\u041f = 0.0f;
        this.\u0544 = 0.0f;
        Arrays.fill(this.\u03fa, false);
    }

    public void \u0471(String string, List<String> list, Consumer<Integer> consumer, double d) {
        this.\u04b7(true);
        this.\u0107 = 0xD4F7CB68 ^ 0xD4F7CB6C;
        this.\u0127 = string;
        this.\u00f3 = new ArrayList<String>(list);
        this.b = () -> oc35e4c54bd4.q1uz9i89mk07jj(consumer);
        this.\u03ad = consumer;
        this.\u00c9 = d;
        this.\u041f = 0.0f;
        this.\u0544 = 0.0f;
        this.\u054e.clear();
        this.\u00ec = 0;
        this.\u03f5 = 0.0;
        this.\u00da(this, oc98904eb9e7::\u01d3);
        this.\u0236();
    }

    public void J(int n) {
        this.\u03ad.accept(n);
        this.\u04b7(false);
    }

    public void \u04b7(boolean bl) {
        this.\u00fa = 0;
        int n = this.\u0107;
        if ((n == 1 || n == (0xD7D8BF7D ^ 0xD7D8BF7F) || n == (0xD7D8BF7B ^ 0xD7D8BF7F)) && bl && this.b != null) {
            this.b.run();
        }
        if (n == (0xD7D8BF7D ^ 0xD7D8BF7F) && this.\u0373 != null) {
            boolean bl2 = false;
            for (int i = 0xD7D8BF77 ^ 0xD7D8BF7F; i > 0; --i) {
                int n2 = this.\u0262 >= i ? this.\u0262 - i : this.\u0262 + (0xD7D8BF77 ^ 0xD7D8BF7F) - i;
                float[] fArray = this.G[n2];
                if (this.\u0373[0] != fArray[0] || this.\u0373[1] != fArray[1] || this.\u0373[0xD7D8BF7D ^ 0xD7D8BF7F] != fArray[0xD7D8BF7D ^ 0xD7D8BF7F]) continue;
                bl2 = true;
                break;
            }
            if (!bl2) {
                this.\u0262 = this.\u0262 >= 1 ? this.\u0262 - 1 : 0xD7D8BF78 ^ 0xD7D8BF7F;
                this.G[this.\u0262] = (float[])this.\u0373.clone();
            }
        }
        if (n == (0xD7D8BF7B ^ 0xD7D8BF7F)) {
            this.\u054e.clear();
            this.\u00ec = 0;
        }
        if (n != 0) {
            this.\u0107 = 0;
        }
    }

    public void \u03fa() {
        if (this.b != null) {
            this.b.run();
        }
        this.\u04b7(false);
    }

    public void \u049b() {
        String string = this.\u0177();
        if (string != null) {
            Consumer<String> consumer = this.D;
            this.\u04b7(false);
            consumer.accept(string);
        }
    }

    public void \u0279(double d) {
        if (!(oc98904eb9e7.\u0442(0xEDDA5A62 ^ 0xEDCE54B2) > d - this.\u03f5)) {
            this.\u054e.clear();
            this.\u00ec = 0;
            byte[] byArray = oc98904eb9e7.\u0547(this.\u02c0.toString());
            for (int i = 0; i < this.\u00f3.size(); ++i) {
                byte[] byArray2 = oc98904eb9e7.\u0547(this.\u00f3.get(i));
                if (byArray2.length < byArray.length || !oc98904eb9e7.\u017c(byArray2, byArray)) continue;
                if (this.\u054e.size() >= (0xEDCE54AC ^ 0xEDCE54B2)) {
                    ++this.\u00ec;
                    continue;
                }
                this.\u054e.add(i);
            }
            this.\u03f5 = d;
        }
    }

    public boolean \u03df(ocd9db3ede42 ocd9db3ede422, int n, float f) {
        if (this.f(ocd9db3ede422)) {
            this.\u03fa[n] = true;
        } else {
            if (!this.\u01db) {
                this.\u03fa[n] = false;
                return false;
            }
            if (!this.\u03fa[n]) {
                return false;
            }
        }
        this.\u015d[n] = oc62a465bc97.\u0496(0.0f, oc98904eb9e7.\u0132(0xF88C27E9 ^ 0xF89828A9), (this.\u0220 - ocd9db3ede422.\u00c8 - f) / (ocd9db3ede422.\u0423 - 2.0f * f));
        this.\u0373 = oc98904eb9e7.\u04c3(this.\u015d[0], this.\u015d[1], this.\u015d[0xF89828AB ^ 0xF89828A9], 0xF8982856 ^ 0xF89828A9);
        return true;
    }

    public void \u047c(String string) {
        if (string.length() > (0x49382099 ^ 0x4938209C)) {
            for (int i = 0; i < (0x4938209F ^ 0x4938209C); ++i) {
                int n = string.charAt((0x4938209E ^ 0x4938209C) * i) & (0x49382063 ^ 0x4938209C);
                int n2 = string.charAt((0x4938209E ^ 0x4938209C) * i + 1) & (0x49382063 ^ 0x4938209C);
                int n3 = n + ((byte)n >= (0x493820FD ^ 0x4938209C) ? 0x49382035 ^ 0x4938209C : 0x4938204C ^ 0x4938209C) & (0x49382063 ^ 0x4938209C);
                int n4 = n2 + ((byte)n2 >= (0x493820FD ^ 0x4938209C) ? 0x49382035 ^ 0x4938209C : 0x4938204C ^ 0x4938209C) & (0x49382063 ^ 0x4938209C);
                this.\u0373[i] = (float)((double)(n3 << (0x49382098 ^ 0x4938209C) | n4) / oc98904eb9e7.\u0442(0x492C2E64 ^ 0x4938209C));
            }
        }
        this.\u015d = oc98904eb9e7.\u04f7(this.\u0373, false, true);
    }

    public void \u04bd(int n) {
        this.\u0373 = (float[])this.G[n].clone();
        this.\u015d = oc98904eb9e7.\u04f7(this.\u0373, true, true);
    }

    public float \u046c(double d) {
        return (float)(d - this.\u0460);
    }

    public ocd9db3ede42 \u01f6(float f, float f2, float f3, boolean bl, double d) {
        this.\u0119 = oc62a465bc97.\u0496(0.0f, this.\u0455, this.\u0119);
        float f4 = Math.max(0.0f, this.\u046c(d));
        float f5 = (float)(-Math.expm1((double)(-f4) / 0.08));
        this.\u0102 = oc62a465bc97.\u0496(0.0f, this.\u0455, oc62a465bc97.\u0479(this.\u0102, this.\u0119, f5));
        if (Math.abs(this.\u0119 - this.\u0102) < 0.05f) {
            this.\u0102 = this.\u0119;
        }
        this.\u0220 = this.\u024e * (oc98904eb9e7.\u0132(0x7E3C8B4A ^ 0x7E28839A) / f3);
        this.\u0226 = this.\u04b8 * (oc98904eb9e7.\u0132(0x7E3C8B4A ^ 0x7E28839A) / f3) + this.\u0102;
        this.\u01f6 = oc62a465bc97.\u0517(oc98904eb9e7.\u0132(0x7E3C8B4A ^ 0x7E28839A), (float)((double)this.\u01f6 + (double)f4 / oc98904eb9e7.\u0442(0x7E3C8B6A ^ 0x7E28839A)));
        float f6 = oc62a465bc97.\u0517(f, oc98904eb9e7.\u0132(bl ? 0x7E3C8B5E ^ 0x7E28839A : 0x7E3C8B52 ^ 0x7E28839A));
        float f7 = (f - f6) * oc98904eb9e7.\u0132(0x7E3C8B56 ^ 0x7E28839A);
        this.\u0212();
        ocd9db3ede42 ocd9db3ede422 = new ocd9db3ede42(f7, 0.0f, f6, f2);
        this.\u0164(ocd9db3ede422, oc98904eb9e7.\u0132(0x7E3C8B62 ^ 0x7E28839A), oc98904eb9e7.\u0132(0x7E3C8B66 ^ 0x7E28839A), false).\u03b1(1);
        return ocd9db3ede422;
    }

    public void \u0573(float f, double d) {
        this.\u0455 = oc62a465bc97.\u057f(0.0f, (float)this.\u01d3 - f + oc98904eb9e7.\u0132(0x89F6E5A4 ^ 0x89E2ED58));
        this.\u00df();
        this.\u0460 = d;
    }

    private static void q1uz9i89mk07jj(Consumer consumer) {
        consumer.accept(null);
    }

    private void q19mqe8ongoq0z(Consumer consumer) {
        consumer.accept((float[])this.\u0373.clone());
    }

    private static void q1njbpuxx14c0c(Consumer consumer) {
        consumer.accept(null);
    }

    private void q31jwxuxn512qy(int n) {
        this.\u0183.z$hlvwjqhan03y(this.\u02c0, n);
    }
}

