/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.List;
import keystrokesmod.script.Manager;
import x.oc1cb76bf763;
import x.oc2cf3d80e17;
import x.oc38495530cc;
import x.oc4f21845252;
import x.oc69da1aa7f5;
import x.oc8628def51e;
import x.oc8aaacef5d6;
import x.oc9755810e45;
import x.occ2f8dff8d8;
import x.oce01b50832c;
import x.oce4cea752dd;

public class ocb37f88aec5
extends oc38495530cc {
    private static final String[] \u020d;
    private final oce01b50832c \u01be;
    private final oc8628def51e \u021b;
    private String E = "Left click to toggle | Right click for settings | Middle click to bind";
    private int \u0415;

    ocb37f88aec5(oc1cb76bf763 oc1cb76bf7632) {
        super(oc1cb76bf7632);
        this.\u01be = new oce01b50832c("Script name", "Type a script name...", oc1cb76bf7632, () -> this.\u0474("Create"));
        this.\u021b = new oc8628def51e(oc1cb76bf7632);
    }

    @Override
    void z$ohfkdtvsjxqf() {
        this.\u01a0();
    }

    void \u01a0() {
        List<oc69da1aa7f5> list = oc2cf3d80e17.\u013c == null ? List.of() : oc2cf3d80e17.\u013c.\u0249(oce4cea752dd.\u057c).stream().filter(oc69da1aa7f52 -> !(oc69da1aa7f52 instanceof Manager)).toList();
        this.\u0415 = list.size();
        this.\u021b.\u03bb(list);
    }

    @Override
    void z$1h526f5jynsva(oc8aaacef5d6 oc8aaacef5d62, float f, float f2) {
        this.\u047f(oc8aaacef5d62, "Script Manager", "\ue86f", this.\u0415 + (this.\u0415 == 1 ? " script" : " scripts"));
        float f3 = (this.\u03bc - 20.0f - (float)((0x75962328 ^ 0x7596232C) * (\u020d.length - 1))) / (float)\u020d.length;
        for (int i = 0; i < \u020d.length; ++i) {
            oc38495530cc.\u0138(oc8aaacef5d62, \u020d[i], this.\u00e3 + 10.0f + (float)i * (f3 + 4.0f), this.\u04b4 + 34.0f, f3, 20.0f, f, f2, i == 0);
        }
        this.\u01be.C(oc8aaacef5d62, this.\u00e3 + 10.0f, this.\u04b4 + 62.0f, this.\u03bc - 20.0f, f, f2);
        float f4 = this.\u04b4 + 98.0f;
        if (this.\u0212() != null) {
            float f5 = (this.\u03bc - 24.0f) / 2.0f;
            this.\u0275(oc8aaacef5d62, "HTTP requests", Manager.enableHttpRequests, this.\u00e3 + 10.0f, f5, f, f2);
            this.\u0275(oc8aaacef5d62, "WebSockets", Manager.enableWebSockets, this.\u00e3 + 14.0f + f5, f5, f, f2);
            f4 += 26.0f;
        }
        this.\u021b.\u04f9(oc8aaacef5d62, this.\u00e3 + 10.0f, f4, this.\u03bc - 20.0f, this.\u04b4 + this.\u0514 - 26.0f - f4, f, f2);
        this.\u041e(oc8aaacef5d62, this.E);
    }

    private void \u0275(oc8aaacef5d6 oc8aaacef5d62, String string, occ2f8dff8d8 occ2f8dff8d82, float f, float f2, float f3, float f4) {
        oc38495530cc.\u0138(oc8aaacef5d62, string + (occ2f8dff8d82.\u01ed() ? ": On" : ": Off"), f, this.\u04b4 + 96.0f, f2, 18.0f, f3, f4, occ2f8dff8d82.\u01ed());
    }

    @Override
    void z$10zmr5yjmvvef(float f, float f2, int n) {
        if (n == 0) {
            float f3 = (this.\u03bc - 20.0f - (float)((0x1819FFBB ^ 0x1819FFBF) * (\u020d.length - 1))) / (float)\u020d.length;
            for (int i = 0; i < \u020d.length; ++i) {
                if (!oc4f21845252.\u0392(f, f2, this.\u00e3 + 10.0f + (float)i * (f3 + 4.0f), this.\u04b4 + 34.0f, f3, 20.0f)) continue;
                this.\u0474(\u020d[i]);
                return;
            }
            if (this.\u01be.\u00c0(f, f2)) {
                this.\u01be.z$3iwy342velf2h(f, f2, n);
                return;
            }
            Manager manager = this.\u0212();
            if (manager != null) {
                float f4 = (this.\u03bc - 24.0f) / 2.0f;
                occ2f8dff8d8[] occ2f8dff8d8Array = new occ2f8dff8d8[0x1819FFBD ^ 0x1819FFBF];
                occ2f8dff8d8Array[0] = Manager.enableHttpRequests;
                occ2f8dff8d8Array[1] = Manager.enableWebSockets;
                occ2f8dff8d8[] occ2f8dff8d8Array2 = occ2f8dff8d8Array;
                for (int i = 0; i < occ2f8dff8d8Array2.length; ++i) {
                    if (!oc4f21845252.\u0392(f, f2, this.\u00e3 + 10.0f + (float)i * (f4 + 4.0f), this.\u04b4 + 96.0f, f4, 18.0f)) continue;
                    occ2f8dff8d8Array2[i].\u045d();
                    manager.guiButtonToggled(occ2f8dff8d8Array2[i]);
                    return;
                }
            }
        }
        this.\u021b.\u03bc(f, f2, n);
    }

    private Manager \u0212() {
        return oc2cf3d80e17.\u013c == null ? null : oc9755810e45.\u0159;
    }

    /*
     * Exception decompiling
     */
    private void \u0474(String var1_1) {
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

    @Override
    void z$1zwd02zrw5ico(float f, float f2, float f3) {
        this.\u021b.\u024f(f, f2, f3);
    }

    @Override
    void z$3mqeupmq4p81d() {
        this.\u01be.z$21n2hyuutt37u();
        this.\u021b.\u0540();
    }

    static {
        String[] stringArray = new String[0xE2C9ED16 ^ 0xE2C9ED13];
        stringArray[0] = "Create";
        stringArray[1] = "Edit";
        stringArray[0xE2C9ED11 ^ 0xE2C9ED13] = "Load";
        stringArray[0xE2C9ED10 ^ 0xE2C9ED13] = "Folder";
        stringArray[0xE2C9ED17 ^ 0xE2C9ED13] = "Docs";
        \u020d = stringArray;
    }
}

