/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.Collection;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import x.oc04eaeaf97f;
import x.oc1cb76bf763;
import x.oc26930a666f;
import x.oc2cf3d80e17;
import x.oc38495530cc;
import x.oc41720aed4a;
import x.oc4f21845252;
import x.oc69da1aa7f5;
import x.oc7ab2161b9f;
import x.oc8628def51e;
import x.oc8aaacef5d6;
import x.oc939d6f1e71;
import x.oc9e5a7eeec6;
import x.oce01b50832c;

public class oc0c3f0511db
extends oc38495530cc {
    private static final String[] \u0289;
    private final oc26930a666f \u0152 = new oc26930a666f();
    private final Map<oc9e5a7eeec6, oc939d6f1e71> \u02a2 = new EnumMap<oc9e5a7eeec6, oc939d6f1e71>(oc9e5a7eeec6.class);
    private final oc8628def51e \u03ad;
    private final oce01b50832c \u0569;
    private oc04eaeaf97f \u03b8 = oc04eaeaf97f.j;
    private String \u0565 = "Click a config to load";
    private boolean \u00c6;
    private float \u00c9;
    private float \u0206;

    oc0c3f0511db(oc1cb76bf763 oc1cb76bf7632) {
        super(oc1cb76bf7632);
        for (oc9e5a7eeec6 oc9e5a7eeec62 : oc9e5a7eeec6.values()) {
            this.\u02a2.put(oc9e5a7eeec62, new oc939d6f1e71());
        }
        this.\u03ad = new oc8628def51e(oc1cb76bf7632);
        this.\u0569 = new oce01b50832c("Config name", "Type a config name...", oc1cb76bf7632, () -> this.\u01d8("Create"));
    }

    @Override
    void z$ohfkdtvsjxqf() {
        this.\u04d2();
        if (this.\u03b8 != oc04eaeaf97f.\u02a7) {
            this.\u0133(this.\u03b8.\u0291);
        }
    }

    void \u04d2() {
        List<oc69da1aa7f5> list = oc2cf3d80e17.\u00c1 == null ? List.of() : oc2cf3d80e17.\u00c1.\u01f9.stream().map(oc151419fdfe2 -> oc151419fdfe2.\u01da()).toList();
        this.\u03ad.\u03bb(list);
    }

    @Override
    void z$1h526f5jynsva(oc8aaacef5d6 oc8aaacef5d62, float f, float f2) {
        String string = oc2cf3d80e17.\u0115 == null ? "No active config" : oc2cf3d80e17.\u0115.\u0120();
        this.\u047f(oc8aaacef5d62, "Config Manager", "\ue8b8", oc8aaacef5d62.\u0398("productsans-medium", string, 8.0f, this.\u03bc / 2.0f));
        float f3 = (this.\u03bc - 24.0f) / 3.0f;
        Object object = oc04eaeaf97f.values();
        int n = ((oc04eaeaf97f[])object).length;
        for (int i = 0; i < n; ++i) {
            oc04eaeaf97f oc04eaeaf97f2 = object[i];
            oc38495530cc.\u0138(oc8aaacef5d62, oc04eaeaf97f2.\u0445, this.\u00e3 + 10.0f + (float)oc04eaeaf97f2.ordinal() * (f3 + 2.0f), this.\u04b4 + 34.0f, f3, 20.0f, f, f2, oc04eaeaf97f2 == this.\u03b8);
        }
        if (this.\u03b8 == oc04eaeaf97f.\u02a7) {
            this.\u0569.C(oc8aaacef5d62, this.\u00e3 + 10.0f, this.\u04b4 + 62.0f, this.\u03bc - 20.0f, f, f2);
            float f4 = (this.\u03bc - 32.0f) / (float)\u0289.length;
            for (n = 0; n < \u0289.length; ++n) {
                oc38495530cc.\u0138(oc8aaacef5d62, \u0289[n], this.\u00e3 + 10.0f + (float)n * (f4 + 4.0f), this.\u04b4 + 94.0f, f4, 20.0f, f, f2, n == 0);
            }
            this.\u00c9 = this.\u04b4 + 122.0f;
        } else {
            object = this.\u02a2.get((Object)this.\u03b8.\u0291);
            oc8aaacef5d62.\u0456("productsans-medium", (String)(object.\u0154 ? "Loading configs..." : object.\u0273.size() + " configs available"), this.\u00e3 + 10.0f, this.\u04b4 + 75.0f, 8.0f, 0x6F535DB4 ^ 0x90F9F71E);
            oc38495530cc.\u0138(oc8aaacef5d62, "Refresh", this.\u00e3 + this.\u03bc - 68.0f, this.\u04b4 + 62.0f, 58.0f, 20.0f, f, f2, false);
            this.\u00c9 = this.\u04b4 + 90.0f;
        }
        this.\u0206 = Math.max(0.0f, this.\u04b4 + this.\u0514 - 26.0f - this.\u00c9);
        if (this.\u03b8 == oc04eaeaf97f.\u02a7) {
            this.\u03ad.\u04f9(oc8aaacef5d62, this.\u00e3 + 10.0f, this.\u00c9, this.\u03bc - 20.0f, this.\u0206, f, f2);
        } else {
            this.a(oc8aaacef5d62, this.\u02a2.get((Object)this.\u03b8.\u0291), f, f2);
        }
        this.\u041e(oc8aaacef5d62, this.\u03b8 == oc04eaeaf97f.\u02a7 && this.\u0565.equals("Click a config to load") ? "Left click to load | Right click to manage | Middle click to bind" : this.\u0565);
    }

    private void a(oc8aaacef5d6 oc8aaacef5d62, oc939d6f1e71 oc939d6f1e712, float f, float f2) {
        oc939d6f1e712.\u0141(this.\u0206);
        float f3 = Math.min(oc939d6f1e712.\u03df(this.\u0206), Math.max(0.0f, oc939d6f1e712.\u0148.\u047f()));
        oc8aaacef5d62.\u023a(this.\u00e3 + 10.0f, this.\u00c9, this.\u03bc - 20.0f, this.\u0206, () -> {
            if (!oc939d6f1e712.\u0546.isEmpty()) {
                oc8aaacef5d62.\u0456("productsans-medium", oc8aaacef5d62.\u0398("productsans-medium", oc939d6f1e712.\u0546, 9.0f, this.\u03bc - 40.0f), this.\u00e3 + 20.0f, this.\u00c9 + 18.0f, 9.0f, 0x7BE1B011 ^ 0x844B1ABB);
            } else {
                for (int i = 0; i < oc939d6f1e712.\u0273.size(); ++i) {
                    float f4;
                    oc41720aed4a oc41720aed4a2 = oc939d6f1e712.\u0273.get(i);
                    oc8aaacef5d62.\u027e(this.\u00e3 + 10.0f, f4, this.\u03bc - 26.0f, 42.0f, 3.0f, oc4f21845252.\u0392(f, f2, this.\u00e3 + 10.0f, f4 = this.\u00c9 + (float)(i * (0x844B1A97 ^ 0x844B1ABB)) - f3, this.\u03bc - 26.0f, 42.0f) ? 0xA1B4E544 ^ 0x844B1ABB : 0xC44B1ABB ^ 0x844B1ABB);
                    oc8aaacef5d62.\u0456("productsans-bold", oc8aaacef5d62.\u0398("productsans-bold", oc41720aed4a2.\u00d6(), 9.0f, this.\u03bc - 82.0f), this.\u00e3 + 20.0f, f4 + 14.0f, 9.0f, -1);
                    String string = oc41720aed4a2.\u00db() + "  |  " + oc41720aed4a2.\u016a();
                    if (!oc41720aed4a2.\u0260().isEmpty()) {
                        string = oc41720aed4a2.\u0260() + "  |  " + oc41720aed4a2.\u00db();
                    }
                    oc8aaacef5d62.\u0456("productsans-medium", oc8aaacef5d62.\u0398("productsans-medium", string, 8.0f, this.\u03bc - 82.0f), this.\u00e3 + 20.0f, f4 + 30.0f, 8.0f, 0x7BE1B011 ^ 0x844B1ABB);
                    oc8aaacef5d62.\u0456("materialicons-outlined", "\ue2c4", this.\u00e3 + this.\u03bc - 38.0f, f4 + 25.0f, 13.0f, oc8aaacef5d6.\u012d());
                }
            }
        });
        oc38495530cc.u(oc8aaacef5d62, this.\u00e3 + this.\u03bc - 12.0f, this.\u00c9, this.\u0206, oc939d6f1e712.\u0273.size() * (0x4AFBA6D4 ^ 0x4AFBA6F8), f3);
    }

    @Override
    void z$10zmr5yjmvvef(float f, float f2, int n) {
        float f3;
        if (n == 0) {
            f3 = (this.\u03bc - 24.0f) / 3.0f;
            for (oc04eaeaf97f oc04eaeaf97f2 : oc04eaeaf97f.values()) {
                if (!oc4f21845252.\u0392(f, f2, this.\u00e3 + 10.0f + (float)oc04eaeaf97f2.ordinal() * (f3 + 2.0f), this.\u04b4 + 34.0f, f3, 20.0f)) continue;
                this.z$3mqeupmq4p81d();
                this.\u03b8 = oc04eaeaf97f2;
                if (oc04eaeaf97f2 == oc04eaeaf97f.\u02a7) {
                    this.\u04d2();
                } else {
                    this.\u0133(oc04eaeaf97f2.\u0291);
                }
                return;
            }
        }
        if (this.\u03b8 == oc04eaeaf97f.\u02a7) {
            if (n == 0) {
                if (this.\u0569.\u00c0(f, f2)) {
                    this.\u0569.z$3iwy342velf2h(f, f2, n);
                    return;
                }
                f3 = (this.\u03bc - 32.0f) / (float)\u0289.length;
                for (int i = 0; i < \u0289.length; ++i) {
                    if (!oc4f21845252.\u0392(f, f2, this.\u00e3 + 10.0f + (float)i * (f3 + 4.0f), this.\u04b4 + 94.0f, f3, 20.0f)) continue;
                    this.\u01d8(\u0289[i]);
                    return;
                }
            }
            this.\u03ad.\u03bc(f, f2, n);
            return;
        }
        if (n != 0) {
            return;
        }
        if (oc4f21845252.\u0392(f, f2, this.\u00e3 + this.\u03bc - 68.0f, this.\u04b4 + 62.0f, 58.0f, 20.0f)) {
            this.\u0414(this.\u03b8.\u0291);
            return;
        }
        oc939d6f1e71 oc939d6f1e712 = this.\u02a2.get((Object)this.\u03b8.\u0291);
        if (oc939d6f1e712.\u0154 || !oc939d6f1e712.\u0546.isEmpty() || !oc4f21845252.\u0392(f, f2, this.\u00e3 + 10.0f, this.\u00c9, this.\u03bc - 26.0f, this.\u0206)) {
            return;
        }
        float f4 = Math.min(oc939d6f1e712.\u03df(this.\u0206), Math.max(0.0f, oc939d6f1e712.\u0148.\u047f()));
        int n2 = (int)((f2 - this.\u00c9 + f4) / 44.0f);
        if (n2 >= 0 && n2 < oc939d6f1e712.\u0273.size()) {
            this.\u03ff(oc939d6f1e712.\u0273.get(n2), this.\u03b8.\u0291);
        }
    }

    /*
     * Exception decompiling
     */
    private void \u01d8(String var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter$TooOptimisticMatchException
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.getInt(SwitchStringRewriter.java:417)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.access$700(SwitchStringRewriter.java:53)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter$SwitchStringMatchResultCollector.collectMatches(SwitchStringRewriter.java:368)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.ResetAfterTest.match(ResetAfterTest.java:24)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.KleeneN.match(KleeneN.java:24)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.MatchSequence.match(MatchSequence.java:26)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.matchutil.ResetAfterTest.match(ResetAfterTest.java:23)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.rewriteComplex(SwitchStringRewriter.java:201)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.SwitchStringRewriter.rewrite(SwitchStringRewriter.java:73)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:881)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    private void \u0133(oc9e5a7eeec6 oc9e5a7eeec62) {
        oc939d6f1e71 oc939d6f1e712 = this.\u02a2.get((Object)oc9e5a7eeec62);
        if (!(oc939d6f1e712.\u0154 || oc9e5a7eeec62 != oc9e5a7eeec6.\u044d && oc939d6f1e712.\u018c)) {
            this.\u0414(oc9e5a7eeec62);
        }
    }

    private void \u0414(oc9e5a7eeec6 oc9e5a7eeec62) {
        oc939d6f1e71 oc939d6f1e712 = this.\u02a2.get((Object)oc9e5a7eeec62);
        if (oc939d6f1e712.\u0154) {
            return;
        }
        oc939d6f1e712.\u0154 = true;
        oc939d6f1e712.\u018c = false;
        oc939d6f1e712.\u0546 = "Loading configs...";
        this.\u0152.\u04e6(oc9e5a7eeec62, list -> {
            oc939d6f1e712.\u0273.clear();
            oc939d6f1e712.\u0273.addAll((Collection<oc41720aed4a>)list);
            oc939d6f1e712.\u0273.sort(Comparator.comparing(oc41720aed4a::\u00d6, String.CASE_INSENSITIVE_ORDER));
            oc939d6f1e712.\u0546 = list.isEmpty() ? "No configs found" : "";
            oc939d6f1e712.\u0154 = false;
            oc939d6f1e712.\u018c = true;
        }, string -> {
            oc939d6f1e712.\u0546 = "Failed: " + string;
            oc939d6f1e712.\u0154 = false;
        });
    }

    private void \u03ff(oc41720aed4a oc41720aed4a2, oc9e5a7eeec6 oc9e5a7eeec62) {
        if (this.\u00c6) {
            return;
        }
        this.\u00c6 = true;
        this.\u0565 = "Loading " + oc41720aed4a2.\u00d6() + "...";
        this.\u0152.\u0160(oc9e5a7eeec62, oc41720aed4a2, bl -> {
            this.\u00c6 = false;
            String string = this.\u0565 = bl != false ? "Loaded config: " + oc41720aed4a2.\u00d6() : "Failed to apply config";
            if (bl.booleanValue()) {
                oc7ab2161b9f.\u00fd("&7Loaded " + oc9e5a7eeec62.\u04f2() + " config: &b" + oc41720aed4a2.\u00d6());
                this.\u04d2();
            }
        }, string -> {
            this.\u00c6 = false;
            this.\u0565 = "Failed: " + string;
        });
    }

    @Override
    void z$1zwd02zrw5ico(float f, float f2, float f3) {
        if (this.\u03b8 == oc04eaeaf97f.\u02a7) {
            this.\u03ad.\u024f(f, f2, f3);
        } else if (oc4f21845252.\u0392(f, f2, this.\u00e3 + 10.0f, this.\u00c9, this.\u03bc - 20.0f, this.\u0206)) {
            oc939d6f1e71 oc939d6f1e712 = this.\u02a2.get((Object)this.\u03b8.\u0291);
            oc939d6f1e712.\u03cf -= f3 * 44.0f;
            oc939d6f1e712.\u0141(this.\u0206);
            oc939d6f1e712.\u0148.\u0540(oc939d6f1e712.\u03cf);
        }
    }

    @Override
    void z$3mqeupmq4p81d() {
        this.\u0569.z$21n2hyuutt37u();
        this.\u03ad.\u0540();
    }

    static {
        String[] stringArray = new String[0x41F6CDE5 ^ 0x41F6CDE1];
        stringArray[0] = "Create";
        stringArray[1] = "Save";
        stringArray[0x41F6CDE3 ^ 0x41F6CDE1] = "Refresh";
        stringArray[0x41F6CDE2 ^ 0x41F6CDE1] = "Folder";
        \u0289 = stringArray;
    }
}

