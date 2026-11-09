/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.Arrays;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import net.minecraft.util.StringUtils;
import x.N;
import x.oc24a0a5bddf;
import x.oc321b4679dd;
import x.oc69da1aa7f5;
import x.oca9cc61aada;
import x.ocada7dda290;
import x.occ2f8dff8d8;
import x.occc831eff22;
import x.oce4cea752dd;
import x.oce6044968f8;

public class oc93499ec6de {
    private static final double[] \u027b;
    private static final int[] \u0262;
    final Map<String, N> \u03ed = new LinkedHashMap<String, N>();
    private occc831eff22 \u0503;
    final occc831eff22 \u01b4 = this.\u0388("colorsGroup", "Client colors");
    final oca9cc61aada \u046b;
    final occ2f8dff8d8 \u02e4;
    final oca9cc61aada \u0229;
    final oca9cc61aada \u024a;
    final oca9cc61aada \u0202;
    final oca9cc61aada \u056d;
    final oca9cc61aada \u0237;
    final oca9cc61aada \u0386;
    final occc831eff22 \u050c;
    final oca9cc61aada \u011b;
    final oca9cc61aada \u0282;
    final occ2f8dff8d8 \u04bc;
    final oca9cc61aada \u026f;
    final oca9cc61aada \u018c;
    final oca9cc61aada \u039d;
    final oca9cc61aada \u027f;
    final oca9cc61aada \u044f;
    final oca9cc61aada \u049b;
    final oca9cc61aada \u040e;
    final occ2f8dff8d8 \u016e;
    final ocada7dda290 \u0278;
    final occc831eff22 \u0222;
    final oca9cc61aada \u046a;
    final occc831eff22 \u03d3;
    final occ2f8dff8d8 \u00c9;
    final oca9cc61aada \u00e3;
    final oc24a0a5bddf \u00e4;
    final occ2f8dff8d8 \u03e7;
    final oca9cc61aada \u025f;
    final oca9cc61aada \u04d2;
    final oca9cc61aada \u013b;
    final occc831eff22 p;
    final oca9cc61aada \u03b4;
    final oc321b4679dd \u0184;
    final oca9cc61aada \u016b;
    final oca9cc61aada \u03b2;
    final oc24a0a5bddf \u057f;
    final oca9cc61aada \u03d7;
    final occc831eff22 \u0493;
    final oca9cc61aada \u01ba;
    final oca9cc61aada \u01c7;
    final oca9cc61aada \u029f;
    final oca9cc61aada \u0254;
    final oc24a0a5bddf \u044a;
    final oc24a0a5bddf \u0377;
    final oca9cc61aada \u019d;
    final oca9cc61aada \u03a8;
    final occ2f8dff8d8 \u0109;
    final oca9cc61aada \u02b8;
    final oca9cc61aada \u00db;
    final oca9cc61aada \u03f7;
    final occc831eff22 \u01e5;
    final oca9cc61aada \u04f1;
    final oca9cc61aada \u018b;
    final oca9cc61aada \u045d;
    final oca9cc61aada \u019a;
    final oc24a0a5bddf \u045f;
    final oca9cc61aada \u00d9;
    final occc831eff22 \u03d8;
    final oca9cc61aada \u02a4;
    final oca9cc61aada \u0465;
    final oca9cc61aada \u0512;
    final oc24a0a5bddf \u01fb;
    final oca9cc61aada \u0405;
    final oca9cc61aada c;
    final oca9cc61aada \u03fe;
    final oca9cc61aada \u03ec;
    final oca9cc61aada \u0517;

    oc93499ec6de() {
        String[] stringArray = new String[0x21909C6F ^ 0x21909C6C];
        stringArray[0] = "Vertical";
        stringArray[1] = "Horizontal";
        stringArray[0x21909C6E ^ 0x21909C6C] = "Diagonal";
        this.\u046b = this.\u013d("colorDirection", "Color direction", 0x21909C6E ^ 0x21909C6C, stringArray);
        this.\u02e4 = this.\u0230("reverseColors", "Reverse color direction", false);
        this.\u0229 = this.\u051b("colorSpread", "Color spread", 1.0, 0.0, 4.0, 0.1);
        this.\u024a = this.\u051b("colorSpeed", "Color speed", 1.0, 0.0, 5.0, 0.1);
        this.\u0202 = this.\u051b("colorOffset", "Color offset", 0.0, 0.0, 360.0, 1.0);
        this.\u056d = this.\u051b("rainbowSaturation", "Rainbow saturation", 0.6, 0.0, 1.0, 0.01);
        this.\u0237 = this.\u051b("rainbowBrightness", "Rainbow brightness", 1.0, 0.1, 1.0, 0.01);
        this.\u0386 = this.\u051b("breatheMinimum", "Breathe brightness", 0.55, 0.1, 1.0, 0.01);
        this.\u050c = this.\u0388("layoutGroup", "Layout");
        String[] stringArray2 = new String[0x21909C6E ^ 0x21909C6C];
        stringArray2[0] = "Right";
        stringArray2[1] = "Left";
        this.\u011b = this.\u013d("alignment", "Alignment", 0, stringArray2);
        String[] stringArray3 = new String[0x21909C6E ^ 0x21909C6C];
        stringArray3[0] = "Down";
        stringArray3[1] = "Up";
        this.\u0282 = this.\u013d("growth", "List direction", 0, stringArray3);
        this.\u04bc = this.\u0230("lockPosition", "Lock position", false);
        String[] stringArray4 = new String[0x21909C6E ^ 0x21909C6C];
        stringArray4[0] = "Content";
        stringArray4[1] = "Uniform";
        this.\u026f = this.\u013d("widthMode", "Row width", 0, stringArray4);
        this.\u018c = this.\u051b("minimumWidth", "Minimum row width", 0.0, 0.0, 300.0, 1.0);
        String[] stringArray5 = new String[0x21909C68 ^ 0x21909C6C];
        stringArray5[0] = "Follow edge";
        stringArray5[1] = "Left";
        stringArray5[0x21909C6E ^ 0x21909C6C] = "Center";
        stringArray5[0x21909C6F ^ 0x21909C6C] = "Right";
        this.\u039d = this.\u013d("textAlignment", "Text alignment", 0, stringArray5);
        this.\u027f = this.\u051b("horizontalPadding", "Horizontal padding", 3.0, 0.0, 20.0, 0.5);
        this.\u044f = this.\u051b("verticalPadding", "Vertical padding", 1.0, 0.0, 12.0, 0.5);
        this.\u049b = this.\u051b("rowGap", "Row spacing", 0.0, 0.0, 20.0, 0.5);
        String[] stringArray6 = new String[0x21909C6E ^ 0x21909C6C];
        stringArray6[0] = "Width";
        stringArray6[1] = "Alphabetical";
        this.\u040e = this.\u013d("sorting", "Sort by", 0, stringArray6);
        this.\u016e = this.\u0230("reverseSort", "Reverse sorting", false);
        this.\u0278 = this.\u0443("hiddenCategories", new ocada7dda290("Hidden categories", (String[])Arrays.stream(oce4cea752dd.values()).map(oc93499ec6de::\u03e2).toArray(String[]::new), new String[0]));
        this.\u0222 = this.\u0388("animationGroup", "Animation settings");
        this.\u046a = this.\u051b("animationDuration", "Animation duration", 250.0, 50.0, 1000.0, 10.0);
        this.\u03d3 = this.\u0388("textGroup", "Text settings");
        this.\u00c9 = this.\u0230("removeSpaces", "Remove name spaces", false);
        String[] stringArray7 = new String[0x21909C6F ^ 0x21909C6C];
        stringArray7[0] = "Theme";
        stringArray7[1] = "White";
        stringArray7[0x21909C6E ^ 0x21909C6C] = "Custom";
        this.\u00e3 = this.\u013d("textColorMode", "Text color", 0, stringArray7);
        this.\u00e4 = this.\u043e("textColor", "Custom text color", 0x21909C93 ^ 0x21909C6C, 0x21909C93 ^ 0x21909C6C, 0x21909C93 ^ 0x21909C6C);
        this.\u03e7 = this.\u0230("gradientText", "Gradient across text", false);
        this.\u025f = this.\u051b("textOpacity", "Text opacity", 255.0, 0.0, 255.0, 1.0);
        this.\u04d2 = this.\u051b("textOffsetX", "Text offset X", 0.0, -10.0, 10.0, 0.5);
        this.\u013b = this.\u051b("textOffsetY", "Text offset Y", 0.0, -10.0, 10.0, 0.5);
        this.p = this.\u0388("suffixGroup", "Suffix settings");
        String[] stringArray8 = new String[0x21909C6B ^ 0x21909C6C];
        stringArray8[0] = "Space";
        stringArray8[1] = "Dash";
        stringArray8[0x21909C6E ^ 0x21909C6C] = "Brackets";
        stringArray8[0x21909C6F ^ 0x21909C6C] = "Parentheses";
        stringArray8[0x21909C68 ^ 0x21909C6C] = "Angle brackets";
        stringArray8[0x21909C69 ^ 0x21909C6C] = "Pipe";
        stringArray8[0x21909C6A ^ 0x21909C6C] = "Custom";
        this.\u03b4 = this.\u013d("suffixStyle", "Suffix style", 0, stringArray8);
        this.\u0184 = this.\u0443("suffixFormat", new oc321b4679dd("Suffix format", " {info}", " {info}", 0x21909C2C ^ 0x21909C6C));
        this.\u016b = this.\u051b("suffixGap", "Suffix spacing", 3.0, 0.0, 20.0, 0.5);
        String[] stringArray9 = new String[0x21909C68 ^ 0x21909C6C];
        stringArray9[0] = "Gray";
        stringArray9[1] = "Theme";
        stringArray9[0x21909C6E ^ 0x21909C6C] = "White";
        stringArray9[0x21909C6F ^ 0x21909C6C] = "Custom";
        this.\u03b2 = this.\u013d("suffixColorMode", "Suffix color", 0, stringArray9);
        this.\u057f = this.\u043e("suffixColor", "Custom suffix color", 0x21909CC6 ^ 0x21909C6C, 0x21909CC6 ^ 0x21909C6C, 0x21909CC6 ^ 0x21909C6C);
        this.\u03d7 = this.\u051b("suffixOpacity", "Suffix opacity", 255.0, 0.0, 255.0, 1.0);
        this.\u0493 = this.\u0388("backgroundGroup", "Background settings");
        String[] stringArray10 = new String[0x21909C68 ^ 0x21909C6C];
        stringArray10[0] = "None";
        stringArray10[1] = "Dark";
        stringArray10[0x21909C6E ^ 0x21909C6C] = "Tinted";
        stringArray10[0x21909C6F ^ 0x21909C6C] = "Gradient";
        this.\u01ba = this.\u013d("background", "Background", 1, stringArray10);
        this.\u01c7 = this.\u051b("backgroundAlpha", "Background opacity", 110.0, 0.0, 255.0, 1.0);
        this.\u029f = this.\u051b("rounding", "Corner radius", 0.0, 0.0, 12.0, 0.5);
        String[] stringArray11 = new String[0x21909C6E ^ 0x21909C6C];
        stringArray11[0] = "Theme";
        stringArray11[1] = "Custom";
        this.\u0254 = this.\u013d("backgroundGradient", "Gradient colors", 0, stringArray11);
        this.\u044a = this.\u043e("backgroundColor", "Background color", 0x21909C60 ^ 0x21909C6C, 0x21909C60 ^ 0x21909C6C, 0x21909C7C ^ 0x21909C6C);
        this.\u0377 = this.\u043e("backgroundColor2", "Second background color", 0x21909C72 ^ 0x21909C6C, 0x21909C72 ^ 0x21909C6C, 0x21909C41 ^ 0x21909C6C);
        this.\u019d = this.\u051b("backgroundTint", "Background tint", 20.0, 0.0, 100.0, 1.0);
        String[] stringArray12 = new String[0x21909C6A ^ 0x21909C6C];
        stringArray12[0] = "Left to right";
        stringArray12[1] = "Right to left";
        stringArray12[0x21909C6E ^ 0x21909C6C] = "Top to bottom";
        stringArray12[0x21909C6F ^ 0x21909C6C] = "Bottom to top";
        stringArray12[0x21909C68 ^ 0x21909C6C] = "Diagonal";
        stringArray12[0x21909C69 ^ 0x21909C6C] = "Reverse diagonal";
        this.\u03a8 = this.\u013d("gradientDirection", "Gradient direction", 0, stringArray12);
        this.\u0109 = this.\u0230("blur", "Background blur", true);
        String[] stringArray13 = new String[0x21909C69 ^ 0x21909C6C];
        stringArray13[0] = "Custom";
        stringArray13[1] = "Soft";
        stringArray13[0x21909C6E ^ 0x21909C6C] = "Balanced";
        stringArray13[0x21909C6F ^ 0x21909C6C] = "Strong";
        stringArray13[0x21909C68 ^ 0x21909C6C] = "Ultra";
        this.\u02b8 = this.\u013d("blurPreset", "Blur preset", 0, stringArray13);
        this.\u00db = this.\u051b("blurRadius", "Blur radius", 2.5, 0.5, 8.0, 0.5);
        this.\u03f7 = this.\u051b("blurPasses", "Blur passes", 2.0, 1.0, 4.0, 1.0);
        this.\u01e5 = this.\u0388("outlineGroup", "Outline settings");
        String[] stringArray14 = new String[0x21909C6A ^ 0x21909C6C];
        stringArray14[0] = "None";
        stringArray14[1] = "Sidebar";
        stringArray14[0x21909C6E ^ 0x21909C6C] = "Steps";
        stringArray14[0x21909C6F ^ 0x21909C6C] = "Full";
        stringArray14[0x21909C68 ^ 0x21909C6C] = "Top";
        stringArray14[0x21909C69 ^ 0x21909C6C] = "Bottom";
        String[] stringArray15 = new String[0x21909C6E ^ 0x21909C6C];
        stringArray15[0] = "Modern outline";
        stringArray15[1] = "Outline settings.Modern outline";
        this.\u04f1 = this.\u0443("outline", new oca9cc61aada("Outline", 0x21909C6F ^ 0x21909C6C, stringArray14, stringArray15));
        String[] stringArray16 = new String[0x21909C6F ^ 0x21909C6C];
        stringArray16[0] = "Outer";
        stringArray16[1] = "Inner";
        stringArray16[0x21909C6E ^ 0x21909C6C] = "Both";
        this.\u018b = this.\u013d("sidebar", "Sidebar position", 1, stringArray16);
        this.\u045d = this.\u051b("outlineWidth", "Outline width", 1.0, 0.5, 3.0, 0.5);
        String[] stringArray17 = new String[0x21909C6F ^ 0x21909C6C];
        stringArray17[0] = "Theme";
        stringArray17[1] = "White";
        stringArray17[0x21909C6E ^ 0x21909C6C] = "Custom";
        this.\u019a = this.\u013d("outlineColorMode", "Outline color", 0, stringArray17);
        this.\u045f = this.\u043e("outlineColor", "Custom outline color", 0x21909C93 ^ 0x21909C6C, 0x21909C93 ^ 0x21909C6C, 0x21909C93 ^ 0x21909C6C);
        this.\u00d9 = this.\u051b("outlineOpacity", "Outline opacity", 255.0, 0.0, 255.0, 1.0);
        this.\u03d8 = this.\u0388("shaderGroup", "Shader settings");
        String[] stringArray18 = new String[0x21909C6F ^ 0x21909C6C];
        stringArray18[0] = "None";
        stringArray18[1] = "Shadow";
        stringArray18[0x21909C6E ^ 0x21909C6C] = "Glow";
        this.\u02a4 = this.\u013d("effect", "Shader effect", 1, stringArray18);
        String[] stringArray19 = new String[0x21909C68 ^ 0x21909C6C];
        stringArray19[0] = "Background";
        stringArray19[1] = "Text";
        stringArray19[0x21909C6E ^ 0x21909C6C] = "Outline";
        stringArray19[0x21909C6F ^ 0x21909C6C] = "All";
        this.\u0465 = this.\u013d("effectTarget", "Shader target", 0, stringArray19);
        String[] stringArray20 = new String[0x21909C6F ^ 0x21909C6C];
        stringArray20[0] = "Auto";
        stringArray20[1] = "Theme";
        stringArray20[0x21909C6E ^ 0x21909C6C] = "Custom";
        this.\u0512 = this.\u013d("effectColorMode", "Shader color", 0, stringArray20);
        this.\u01fb = this.\u043e("effectColor", "Custom shader color", 0, 0, 0);
        this.\u0405 = this.\u051b("effectOpacity", "Shader opacity", 100.0, 0.0, 255.0, 1.0);
        this.c = this.\u051b("effectOffsetX", "Shader offset X", 0.0, -15.0, 15.0, 0.5);
        this.\u03fe = this.\u051b("effectOffsetY", "Shader offset Y", 0.0, -15.0, 15.0, 0.5);
        this.\u03ec = this.\u051b("effectRadius", "Shader radius", 2.5, 0.5, 8.0, 0.5);
        this.\u0517 = this.\u051b("effectPasses", "Shader passes", 3.0, 1.0, 4.0, 1.0);
    }

    void \u0207(oc69da1aa7f5 oc69da1aa7f52, boolean bl, int n, boolean bl2, boolean bl3) {
        int n2;
        oca9cc61aada oca9cc61aada2;
        IdentityHashMap<N, Boolean> identityHashMap;
        boolean bl4;
        IdentityHashMap<N, Boolean> identityHashMap2;
        block226: {
            block227: {
                boolean bl5;
                oca9cc61aada oca9cc61aada3;
                IdentityHashMap<N, Boolean> identityHashMap3;
                block224: {
                    block225: {
                        boolean bl6;
                        oca9cc61aada oca9cc61aada4;
                        IdentityHashMap<N, Boolean> identityHashMap4;
                        block222: {
                            block223: {
                                boolean bl7;
                                occ2f8dff8d8 occ2f8dff8d82;
                                IdentityHashMap<N, Boolean> identityHashMap5;
                                block220: {
                                    block221: {
                                        boolean bl8;
                                        oca9cc61aada oca9cc61aada5;
                                        IdentityHashMap<N, Boolean> identityHashMap6;
                                        block218: {
                                            block219: {
                                                boolean bl9;
                                                oca9cc61aada oca9cc61aada6;
                                                IdentityHashMap<N, Boolean> identityHashMap7;
                                                block216: {
                                                    block217: {
                                                        boolean bl10;
                                                        oca9cc61aada oca9cc61aada7;
                                                        IdentityHashMap<N, Boolean> identityHashMap8;
                                                        block214: {
                                                            block215: {
                                                                boolean bl11;
                                                                oca9cc61aada oca9cc61aada8;
                                                                IdentityHashMap<N, Boolean> identityHashMap9;
                                                                block212: {
                                                                    block213: {
                                                                        boolean bl12;
                                                                        oc321b4679dd oc321b4679dd2;
                                                                        IdentityHashMap<N, Boolean> identityHashMap10;
                                                                        block211: {
                                                                            block209: {
                                                                                block210: {
                                                                                    block208: {
                                                                                        boolean bl13;
                                                                                        oca9cc61aada oca9cc61aada9;
                                                                                        IdentityHashMap<N, Boolean> identityHashMap11;
                                                                                        block207: {
                                                                                            block206: {
                                                                                                block205: {
                                                                                                    boolean bl14;
                                                                                                    oca9cc61aada oca9cc61aada10;
                                                                                                    IdentityHashMap<N, Boolean> identityHashMap12;
                                                                                                    block204: {
                                                                                                        block203: {
                                                                                                            block202: {
                                                                                                                boolean bl15;
                                                                                                                oca9cc61aada oca9cc61aada11;
                                                                                                                IdentityHashMap<N, Boolean> identityHashMap13;
                                                                                                                block201: {
                                                                                                                    block200: {
                                                                                                                        block199: {
                                                                                                                            boolean bl16;
                                                                                                                            oc24a0a5bddf oc24a0a5bddf2;
                                                                                                                            IdentityHashMap<N, Boolean> identityHashMap14;
                                                                                                                            block198: {
                                                                                                                                block196: {
                                                                                                                                    block197: {
                                                                                                                                        block195: {
                                                                                                                                            boolean bl17;
                                                                                                                                            oca9cc61aada oca9cc61aada12;
                                                                                                                                            IdentityHashMap<N, Boolean> identityHashMap15;
                                                                                                                                            block194: {
                                                                                                                                                block193: {
                                                                                                                                                    block192: {
                                                                                                                                                        double d;
                                                                                                                                                        occ2f8dff8d8 occ2f8dff8d83;
                                                                                                                                                        IdentityHashMap<N, Boolean> identityHashMap16;
                                                                                                                                                        block190: {
                                                                                                                                                            block191: {
                                                                                                                                                                double d2;
                                                                                                                                                                oc24a0a5bddf oc24a0a5bddf3;
                                                                                                                                                                IdentityHashMap<N, Boolean> identityHashMap17;
                                                                                                                                                                block188: {
                                                                                                                                                                    block189: {
                                                                                                                                                                        double d3;
                                                                                                                                                                        oca9cc61aada oca9cc61aada13;
                                                                                                                                                                        IdentityHashMap<N, Boolean> identityHashMap18;
                                                                                                                                                                        block186: {
                                                                                                                                                                            block187: {
                                                                                                                                                                                double d4;
                                                                                                                                                                                oc24a0a5bddf oc24a0a5bddf4;
                                                                                                                                                                                IdentityHashMap<N, Boolean> identityHashMap19;
                                                                                                                                                                                block185: {
                                                                                                                                                                                    block184: {
                                                                                                                                                                                        double d5;
                                                                                                                                                                                        block183: {
                                                                                                                                                                                            double d6;
                                                                                                                                                                                            oca9cc61aada oca9cc61aada14;
                                                                                                                                                                                            IdentityHashMap<N, Boolean> identityHashMap20;
                                                                                                                                                                                            block181: {
                                                                                                                                                                                                block182: {
                                                                                                                                                                                                    double d7;
                                                                                                                                                                                                    oca9cc61aada oca9cc61aada15;
                                                                                                                                                                                                    IdentityHashMap<N, Boolean> identityHashMap21;
                                                                                                                                                                                                    block179: {
                                                                                                                                                                                                        block180: {
                                                                                                                                                                                                            int n3;
                                                                                                                                                                                                            oca9cc61aada oca9cc61aada16;
                                                                                                                                                                                                            IdentityHashMap<N, Boolean> identityHashMap22;
                                                                                                                                                                                                            block177: {
                                                                                                                                                                                                                block178: {
                                                                                                                                                                                                                    int n4;
                                                                                                                                                                                                                    oc24a0a5bddf oc24a0a5bddf5;
                                                                                                                                                                                                                    IdentityHashMap<N, Boolean> identityHashMap23;
                                                                                                                                                                                                                    int n5;
                                                                                                                                                                                                                    block176: {
                                                                                                                                                                                                                        block175: {
                                                                                                                                                                                                                            block174: {
                                                                                                                                                                                                                                double d8;
                                                                                                                                                                                                                                oca9cc61aada oca9cc61aada17;
                                                                                                                                                                                                                                IdentityHashMap<N, Boolean> identityHashMap24;
                                                                                                                                                                                                                                block170: {
                                                                                                                                                                                                                                    block173: {
                                                                                                                                                                                                                                        block171: {
                                                                                                                                                                                                                                            block172: {
                                                                                                                                                                                                                                                int n6;
                                                                                                                                                                                                                                                oca9cc61aada oca9cc61aada18;
                                                                                                                                                                                                                                                IdentityHashMap<N, Boolean> identityHashMap25;
                                                                                                                                                                                                                                                double d9;
                                                                                                                                                                                                                                                block167: {
                                                                                                                                                                                                                                                    block166: {
                                                                                                                                                                                                                                                        block168: {
                                                                                                                                                                                                                                                            double d10;
                                                                                                                                                                                                                                                            double d11;
                                                                                                                                                                                                                                                            block169: {
                                                                                                                                                                                                                                                                block165: {
                                                                                                                                                                                                                                                                    int n7;
                                                                                                                                                                                                                                                                    oc24a0a5bddf oc24a0a5bddf6;
                                                                                                                                                                                                                                                                    IdentityHashMap<N, Boolean> identityHashMap26;
                                                                                                                                                                                                                                                                    int n8;
                                                                                                                                                                                                                                                                    block164: {
                                                                                                                                                                                                                                                                        block163: {
                                                                                                                                                                                                                                                                            block162: {
                                                                                                                                                                                                                                                                                double d12;
                                                                                                                                                                                                                                                                                block160: {
                                                                                                                                                                                                                                                                                    block161: {
                                                                                                                                                                                                                                                                                        boolean bl18;
                                                                                                                                                                                                                                                                                        oca9cc61aada oca9cc61aada19;
                                                                                                                                                                                                                                                                                        IdentityHashMap<N, Boolean> identityHashMap27;
                                                                                                                                                                                                                                                                                        block159: {
                                                                                                                                                                                                                                                                                            block158: {
                                                                                                                                                                                                                                                                                                block157: {
                                                                                                                                                                                                                                                                                                    double d13;
                                                                                                                                                                                                                                                                                                    block155: {
                                                                                                                                                                                                                                                                                                        block156: {
                                                                                                                                                                                                                                                                                                            double d14;
                                                                                                                                                                                                                                                                                                            block154: {
                                                                                                                                                                                                                                                                                                                block153: {
                                                                                                                                                                                                                                                                                                                    Object object;
                                                                                                                                                                                                                                                                                                                    N[] nArray;
                                                                                                                                                                                                                                                                                                                    N[] nArray2;
                                                                                                                                                                                                                                                                                                                    block150: {
                                                                                                                                                                                                                                                                                                                        block149: {
                                                                                                                                                                                                                                                                                                                            Object object2;
                                                                                                                                                                                                                                                                                                                            identityHashMap2 = new IdentityHashMap<N, Boolean>();
                                                                                                                                                                                                                                                                                                                            nArray2 = this.\u03ed.values().iterator();
                                                                                                                                                                                                                                                                                                                            bl4 = oce6044968f8.\u0452;
                                                                                                                                                                                                                                                                                                                            while (nArray2.hasNext()) {
                                                                                                                                                                                                                                                                                                                                object2 = nArray2;
                                                                                                                                                                                                                                                                                                                                if (!bl4) {
                                                                                                                                                                                                                                                                                                                                    N n9 = object2.next();
                                                                                                                                                                                                                                                                                                                                    identityHashMap2.put(n9, bl);
                                                                                                                                                                                                                                                                                                                                    if (!bl4) continue;
                                                                                                                                                                                                                                                                                                                                    boolean bl19 = !false;
                                                                                                                                                                                                                                                                                                                                    oc69da1aa7f5.\u04ac = bl19;
                                                                                                                                                                                                                                                                                                                                    break;
                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                break block149;
                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                            identityHashMap2.put(this.\u01b4, true);
                                                                                                                                                                                                                                                                                                                            identityHashMap2.put(this.\u050c, true);
                                                                                                                                                                                                                                                                                                                            identityHashMap2.put(this.\u0222, true);
                                                                                                                                                                                                                                                                                                                            identityHashMap2.put(this.\u03d3, true);
                                                                                                                                                                                                                                                                                                                            identityHashMap2.put(this.p, true);
                                                                                                                                                                                                                                                                                                                            identityHashMap2.put(this.\u0493, true);
                                                                                                                                                                                                                                                                                                                            object2 = identityHashMap2.put(this.\u01e5, true);
                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                        occc831eff22[] occc831eff22Array = new occc831eff22[0xEF8A5221 ^ 0xEF8A5224];
                                                                                                                                                                                                                                                                                                                        occc831eff22Array[0] = this.\u01b4;
                                                                                                                                                                                                                                                                                                                        occc831eff22Array[1] = this.\u03d3;
                                                                                                                                                                                                                                                                                                                        occc831eff22Array[0xEF8A5226 ^ 0xEF8A5224] = this.\u0493;
                                                                                                                                                                                                                                                                                                                        occc831eff22Array[0xEF8A5227 ^ 0xEF8A5224] = this.\u01e5;
                                                                                                                                                                                                                                                                                                                        occc831eff22Array[0xEF8A5220 ^ 0xEF8A5224] = this.\u03d8;
                                                                                                                                                                                                                                                                                                                        nArray2 = occc831eff22Array;
                                                                                                                                                                                                                                                                                                                        n5 = nArray2.length;
                                                                                                                                                                                                                                                                                                                        n8 = 0;
                                                                                                                                                                                                                                                                                                                        while (n8 < n5) {
                                                                                                                                                                                                                                                                                                                            block151: {
                                                                                                                                                                                                                                                                                                                                nArray = nArray2;
                                                                                                                                                                                                                                                                                                                                if (bl4) break block150;
                                                                                                                                                                                                                                                                                                                                object = nArray[n8];
                                                                                                                                                                                                                                                                                                                                identityHashMap2.put((N)object, true);
                                                                                                                                                                                                                                                                                                                                for (N n9 : this.\u03ed.values()) {
                                                                                                                                                                                                                                                                                                                                    block152: {
                                                                                                                                                                                                                                                                                                                                        if (bl4) break block151;
                                                                                                                                                                                                                                                                                                                                        Object object3 = n9;
                                                                                                                                                                                                                                                                                                                                        if (bl4) break block152;
                                                                                                                                                                                                                                                                                                                                        if (!((N)object3).z$3lm3x0je4b2zv().startsWith(((N)object).z$18nrktuqeiysv() + ".")) break block152;
                                                                                                                                                                                                                                                                                                                                        object3 = identityHashMap2.put(n9, true);
                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                    if (!bl4) continue;
                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                n8 += 1;
                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                            if (!bl4) continue;
                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                        N[] nArray3 = new N[0xEF8A522E ^ 0xEF8A5224];
                                                                                                                                                                                                                                                                                                                        nArray3[0] = this.\u00e3;
                                                                                                                                                                                                                                                                                                                        nArray3[1] = this.\u03e7;
                                                                                                                                                                                                                                                                                                                        nArray3[0xEF8A5226 ^ 0xEF8A5224] = this.\u025f;
                                                                                                                                                                                                                                                                                                                        nArray3[0xEF8A5227 ^ 0xEF8A5224] = this.\u04d2;
                                                                                                                                                                                                                                                                                                                        nArray3[0xEF8A5220 ^ 0xEF8A5224] = this.\u013b;
                                                                                                                                                                                                                                                                                                                        nArray3[0xEF8A5221 ^ 0xEF8A5224] = this.\u01ba;
                                                                                                                                                                                                                                                                                                                        nArray3[0xEF8A5222 ^ 0xEF8A5224] = this.\u0109;
                                                                                                                                                                                                                                                                                                                        nArray3[0xEF8A5223 ^ 0xEF8A5224] = this.\u02b8;
                                                                                                                                                                                                                                                                                                                        nArray3[0xEF8A522C ^ 0xEF8A5224] = this.\u04f1;
                                                                                                                                                                                                                                                                                                                        nArray3[0xEF8A522D ^ 0xEF8A5224] = this.\u02a4;
                                                                                                                                                                                                                                                                                                                        nArray2 = nArray3;
                                                                                                                                                                                                                                                                                                                        nArray = nArray2;
                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                    n5 = nArray.length;
                                                                                                                                                                                                                                                                                                                    for (n8 = 0; n8 < n5; n8 += 1) {
                                                                                                                                                                                                                                                                                                                        object = nArray2[n8];
                                                                                                                                                                                                                                                                                                                        identityHashMap2.put((N)object, true);
                                                                                                                                                                                                                                                                                                                        if (!bl4) {
                                                                                                                                                                                                                                                                                                                            if (!bl4) continue;
                                                                                                                                                                                                                                                                                                                            break;
                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                        break block153;
                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                    double d14_r = this.\u01ba.\u04c1() - 0.0;
                                                                                                                                                                                                                                                                                                                    d14_r = d14_r == 0.0 ? 0 : (d14_r > 0.0 ? 1 : -1);
                                                                                                                                                                                                                                                                                                                    if (bl4) break block154;
                                                                                                                                                                                                                                                                                                                    if (d14_r == false) break block153;
                                                                                                                                                                                                                                                                                                                    d14_r = 1.0;
                                                                                                                                                                                                                                                                                                                    break block154;
                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                d14 = 0.0;
                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                            d9 = d14;
                                                                                                                                                                                                                                                                                                            double d13_r = this.\u02a4.\u04c1() - 0.0;
                                                                                                                                                                                                                                                                                                            d13_r = d13_r == 0.0 ? 0 : (d13_r > 0.0 ? 1 : -1);
                                                                                                                                                                                                                                                                                                            if (bl4) break block155;
                                                                                                                                                                                                                                                                                                            if (d13_r == false) break block156;
                                                                                                                                                                                                                                                                                                            d13_r = 1.0;
                                                                                                                                                                                                                                                                                                            break block155;
                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                        d13 = 0.0;
                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                    n5 = (int)d13;
                                                                                                                                                                                                                                                                                                    identityHashMap27 = identityHashMap2;
                                                                                                                                                                                                                                                                                                    oca9cc61aada19 = this.\u046a;
                                                                                                                                                                                                                                                                                                    bl18 = bl;
                                                                                                                                                                                                                                                                                                    if (bl4) break block157;
                                                                                                                                                                                                                                                                                                    if (!bl18) break block158;
                                                                                                                                                                                                                                                                                                    bl18 = bl3;
                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                if (bl4) break block159;
                                                                                                                                                                                                                                                                                                if (!bl18) break block158;
                                                                                                                                                                                                                                                                                                bl18 = true;
                                                                                                                                                                                                                                                                                                break block159;
                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                            bl18 = false;
                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                        identityHashMap27.put(oca9cc61aada19, bl18);
                                                                                                                                                                                                                                                                                        identityHashMap2.put(this.\u044a, (boolean)d9);
                                                                                                                                                                                                                                                                                        identityHashMap2.put(this.\u01c7, (boolean)d9);
                                                                                                                                                                                                                                                                                        double d12_r = this.\u01ba.\u04c1() - 3.0;
                                                                                                                                                                                                                                                                                        d12_r = d12_r == 0.0 ? 0 : (d12_r > 0.0 ? 1 : -1);
                                                                                                                                                                                                                                                                                        if (bl4) break block160;
                                                                                                                                                                                                                                                                                        if (d12_r != false) break block161;
                                                                                                                                                                                                                                                                                        d12_r = 1.0;
                                                                                                                                                                                                                                                                                        break block160;
                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                    d12 = 0.0;
                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                n8 = (int)d12;
                                                                                                                                                                                                                                                                                identityHashMap2.put(this.\u0254, n8 != 0);
                                                                                                                                                                                                                                                                                identityHashMap26 = identityHashMap2;
                                                                                                                                                                                                                                                                                oc24a0a5bddf6 = this.\u0377;
                                                                                                                                                                                                                                                                                n7 = n8;
                                                                                                                                                                                                                                                                                if (bl4) break block162;
                                                                                                                                                                                                                                                                                if (!n7) break block163;
                                                                                                                                                                                                                                                                                double d18 = this.\u0254.\u04c1() - 1.0;
                                                                                                                                                                                                                                                                                n7 = d18 == 0.0 ? 0 : (d18 > 0.0 ? 1 : -1);
                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                            if (bl4) break block164;
                                                                                                                                                                                                                                                                            if (n7) break block163;
                                                                                                                                                                                                                                                                            n7 = 1;
                                                                                                                                                                                                                                                                            break block164;
                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                        n7 = 0;
                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                    identityHashMap26.put(oc24a0a5bddf6, n7 != 0);
                                                                                                                                                                                                                                                                    identityHashMap25 = identityHashMap2;
                                                                                                                                                                                                                                                                    oca9cc61aada18 = this.\u03a8;
                                                                                                                                                                                                                                                                    n6 = n8;
                                                                                                                                                                                                                                                                    if (bl4) break block165;
                                                                                                                                                                                                                                                                    identityHashMap25.put(oca9cc61aada18, n6 != 0);
                                                                                                                                                                                                                                                                    identityHashMap25 = identityHashMap2;
                                                                                                                                                                                                                                                                    oca9cc61aada18 = this.\u019d;
                                                                                                                                                                                                                                                                    if (d9 == false) break block166;
                                                                                                                                                                                                                                                                    double d19 = this.\u01ba.\u04c1() - 2.0;
                                                                                                                                                                                                                                                                    n6 = d19 == 0.0 ? 0 : (d19 > 0.0 ? 1 : -1);
                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                if (bl4) break block167;
                                                                                                                                                                                                                                                                if (!n6) break block168;
                                                                                                                                                                                                                                                                double d10_r2 = this.\u01ba.\u04c1();
                                                                                                                                                                                                                                                                d10_r2 = 3.0;
                                                                                                                                                                                                                                                                if (bl4) break block169;
                                                                                                                                                                                                                                                                if (d11 != d10_r2) break block166;
                                                                                                                                                                                                                                                                double d10_r = this.\u0254.\u04c1();
                                                                                                                                                                                                                                                                d10_r = 0.0;
                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                            double d20 = d11 - d10;
                                                                                                                                                                                                                                                            n6 = d20 == 0.0 ? 0 : (d20 > 0.0 ? 1 : -1);
                                                                                                                                                                                                                                                            if (bl4) break block167;
                                                                                                                                                                                                                                                            if (n6) break block166;
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                        n6 = 1;
                                                                                                                                                                                                                                                        break block167;
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                    n6 = 0;
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                identityHashMap25.put(oca9cc61aada18, n6 != 0);
                                                                                                                                                                                                                                                identityHashMap24 = identityHashMap2;
                                                                                                                                                                                                                                                oca9cc61aada17 = this.\u029f;
                                                                                                                                                                                                                                                double d8_r3 = this.\u04f1.\u04c1() - 0.0;
                                                                                                                                                                                                                                                d8_r3 = d8_r3 == 0.0 ? 0 : (d8_r3 > 0.0 ? 1 : -1);
                                                                                                                                                                                                                                                if (bl4) break block170;
                                                                                                                                                                                                                                                if (d8_r3 != false) break block171;
                                                                                                                                                                                                                                                d8_r3 = d9;
                                                                                                                                                                                                                                                if (bl4) break block170;
                                                                                                                                                                                                                                                if (d8_r3 != false) break block171;
                                                                                                                                                                                                                                                d8_r3 = (double)this.\u0102();
                                                                                                                                                                                                                                                if (bl4) break block170;
                                                                                                                                                                                                                                                if (d8_r3 != false) break block171;
                                                                                                                                                                                                                                                d8_r3 = n5;
                                                                                                                                                                                                                                                if (bl4) break block172;
                                                                                                                                                                                                                                                if (d8_r3 == false) break block173;
                                                                                                                                                                                                                                                double d8_r2 = this.\u0465.\u04c1() - 0.0;
                                                                                                                                                                                                                                                d8_r2 = d8_r2 == 0.0 ? 0 : (d8_r2 > 0.0 ? 1 : -1);
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                            if (bl4) break block170;
                                                                                                                                                                                                                                            if (d8 == false) break block171;
                                                                                                                                                                                                                                            double d8_r = this.\u0465.\u04c1() - 3.0;
                                                                                                                                                                                                                                            d8_r = d8_r == 0.0 ? 0 : (d8_r > 0.0 ? 1 : -1);
                                                                                                                                                                                                                                            if (bl4) break block170;
                                                                                                                                                                                                                                            if (d8_r != false) break block173;
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                        d8 = 1.0;
                                                                                                                                                                                                                                        break block170;
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                    d8 = 0.0;
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                identityHashMap24.put(oca9cc61aada17, (boolean)d8);
                                                                                                                                                                                                                                identityHashMap2.put(this.\u00db, this.\u0102());
                                                                                                                                                                                                                                identityHashMap2.put(this.\u03f7, this.\u0102());
                                                                                                                                                                                                                                identityHashMap2.put(this.\u0465, n5 != 0);
                                                                                                                                                                                                                                identityHashMap2.put(this.\u0405, n5 != 0);
                                                                                                                                                                                                                                identityHashMap2.put(this.\u03ec, n5 != 0);
                                                                                                                                                                                                                                identityHashMap2.put(this.\u0517, n5 != 0);
                                                                                                                                                                                                                                identityHashMap2.put(this.\u0512, n5 != 0);
                                                                                                                                                                                                                                identityHashMap23 = identityHashMap2;
                                                                                                                                                                                                                                oc24a0a5bddf5 = this.\u01fb;
                                                                                                                                                                                                                                n4 = n5;
                                                                                                                                                                                                                                if (bl4) break block174;
                                                                                                                                                                                                                                if (!n4) break block175;
                                                                                                                                                                                                                                double d24 = this.\u0512.\u04c1() - 2.0;
                                                                                                                                                                                                                                n4 = d24 == 0.0 ? 0 : (d24 > 0.0 ? 1 : -1);
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                            if (bl4) break block176;
                                                                                                                                                                                                                            if (n4) break block175;
                                                                                                                                                                                                                            n4 = 1;
                                                                                                                                                                                                                            break block176;
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                        n4 = 0;
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                    identityHashMap23.put(oc24a0a5bddf5, n4 != 0);
                                                                                                                                                                                                                    identityHashMap2.put(this.c, n5 != 0);
                                                                                                                                                                                                                    identityHashMap22 = identityHashMap2;
                                                                                                                                                                                                                    oca9cc61aada16 = this.\u03fe;
                                                                                                                                                                                                                    n3 = n5;
                                                                                                                                                                                                                    if (bl4) break block177;
                                                                                                                                                                                                                    identityHashMap22.put(oca9cc61aada16, n3 != 0);
                                                                                                                                                                                                                    identityHashMap22 = identityHashMap2;
                                                                                                                                                                                                                    oca9cc61aada16 = this.\u018b;
                                                                                                                                                                                                                    if (this.\u04f1.\u04c1() != 1.0) break block178;
                                                                                                                                                                                                                    n3 = 1;
                                                                                                                                                                                                                    break block177;
                                                                                                                                                                                                                }
                                                                                                                                                                                                                n3 = 0;
                                                                                                                                                                                                            }
                                                                                                                                                                                                            identityHashMap22.put(oca9cc61aada16, n3 != 0);
                                                                                                                                                                                                            identityHashMap21 = identityHashMap2;
                                                                                                                                                                                                            oca9cc61aada15 = this.\u045d;
                                                                                                                                                                                                            double d7_r = this.\u04f1.\u04c1() - 0.0;
                                                                                                                                                                                                            d7_r = d7_r == 0.0 ? 0 : (d7_r > 0.0 ? 1 : -1);
                                                                                                                                                                                                            if (bl4) break block179;
                                                                                                                                                                                                            if (d7_r == false) break block180;
                                                                                                                                                                                                            d7_r = 1.0;
                                                                                                                                                                                                            break block179;
                                                                                                                                                                                                        }
                                                                                                                                                                                                        d7 = 0.0;
                                                                                                                                                                                                    }
                                                                                                                                                                                                    identityHashMap21.put(oca9cc61aada15, (boolean)d7);
                                                                                                                                                                                                    identityHashMap20 = identityHashMap2;
                                                                                                                                                                                                    oca9cc61aada14 = this.\u019a;
                                                                                                                                                                                                    double d6_r = this.\u04f1.\u04c1() - 0.0;
                                                                                                                                                                                                    d6_r = d6_r == 0.0 ? 0 : (d6_r > 0.0 ? 1 : -1);
                                                                                                                                                                                                    if (bl4) break block181;
                                                                                                                                                                                                    if (d6_r == false) break block182;
                                                                                                                                                                                                    d6_r = 1.0;
                                                                                                                                                                                                    break block181;
                                                                                                                                                                                                }
                                                                                                                                                                                                d6 = 0.0;
                                                                                                                                                                                            }
                                                                                                                                                                                            identityHashMap20.put(oca9cc61aada14, (boolean)d6);
                                                                                                                                                                                            identityHashMap19 = identityHashMap2;
                                                                                                                                                                                            oc24a0a5bddf4 = this.\u045f;
                                                                                                                                                                                            d5 = this.\u04f1.\u04c1();
                                                                                                                                                                                            if (bl4) break block183;
                                                                                                                                                                                            if (d5 == 0.0) break block184;
                                                                                                                                                                                            d5 = this.\u019a.\u04c1();
                                                                                                                                                                                        }
                                                                                                                                                                                        double d4_r = d5 - 2.0;
                                                                                                                                                                                        d4_r = d4_r == 0.0 ? 0 : (d4_r > 0.0 ? 1 : -1);
                                                                                                                                                                                        if (bl4) break block185;
                                                                                                                                                                                        if (d4_r != false) break block184;
                                                                                                                                                                                        d4_r = 1.0;
                                                                                                                                                                                        break block185;
                                                                                                                                                                                    }
                                                                                                                                                                                    d4 = 0.0;
                                                                                                                                                                                }
                                                                                                                                                                                identityHashMap19.put(oc24a0a5bddf4, (boolean)d4);
                                                                                                                                                                                identityHashMap18 = identityHashMap2;
                                                                                                                                                                                oca9cc61aada13 = this.\u00d9;
                                                                                                                                                                                double d3_r = this.\u04f1.\u04c1() - 0.0;
                                                                                                                                                                                d3_r = d3_r == 0.0 ? 0 : (d3_r > 0.0 ? 1 : -1);
                                                                                                                                                                                if (bl4) break block186;
                                                                                                                                                                                if (d3_r == false) break block187;
                                                                                                                                                                                d3_r = 1.0;
                                                                                                                                                                                break block186;
                                                                                                                                                                            }
                                                                                                                                                                            d3 = 0.0;
                                                                                                                                                                        }
                                                                                                                                                                        identityHashMap18.put(oca9cc61aada13, (boolean)d3);
                                                                                                                                                                        identityHashMap17 = identityHashMap2;
                                                                                                                                                                        oc24a0a5bddf3 = this.\u00e4;
                                                                                                                                                                        double d2_r = this.\u00e3.\u04c1() - 2.0;
                                                                                                                                                                        d2_r = d2_r == 0.0 ? 0 : (d2_r > 0.0 ? 1 : -1);
                                                                                                                                                                        if (bl4) break block188;
                                                                                                                                                                        if (d2_r != false) break block189;
                                                                                                                                                                        d2_r = 1.0;
                                                                                                                                                                        break block188;
                                                                                                                                                                    }
                                                                                                                                                                    d2 = 0.0;
                                                                                                                                                                }
                                                                                                                                                                identityHashMap17.put(oc24a0a5bddf3, (boolean)d2);
                                                                                                                                                                identityHashMap16 = identityHashMap2;
                                                                                                                                                                occ2f8dff8d83 = this.\u03e7;
                                                                                                                                                                double d_r = this.\u00e3.\u04c1() - 0.0;
                                                                                                                                                                d_r = d_r == 0.0 ? 0 : (d_r > 0.0 ? 1 : -1);
                                                                                                                                                                if (bl4) break block190;
                                                                                                                                                                if (d_r != false) break block191;
                                                                                                                                                                d_r = 1.0;
                                                                                                                                                                break block190;
                                                                                                                                                            }
                                                                                                                                                            d = 0.0;
                                                                                                                                                        }
                                                                                                                                                        identityHashMap16.put(occ2f8dff8d83, (boolean)d);
                                                                                                                                                        identityHashMap15 = identityHashMap2;
                                                                                                                                                        oca9cc61aada12 = this.\u03b2;
                                                                                                                                                        bl17 = bl;
                                                                                                                                                        if (bl4) break block192;
                                                                                                                                                        if (!bl17) break block193;
                                                                                                                                                        bl17 = bl2;
                                                                                                                                                    }
                                                                                                                                                    if (bl4) break block194;
                                                                                                                                                    if (!bl17) break block193;
                                                                                                                                                    bl17 = true;
                                                                                                                                                    break block194;
                                                                                                                                                }
                                                                                                                                                bl17 = false;
                                                                                                                                            }
                                                                                                                                            identityHashMap15.put(oca9cc61aada12, bl17);
                                                                                                                                            identityHashMap14 = identityHashMap2;
                                                                                                                                            oc24a0a5bddf2 = this.\u057f;
                                                                                                                                            bl16 = bl;
                                                                                                                                            if (bl4) break block195;
                                                                                                                                            if (!bl16) break block196;
                                                                                                                                            bl16 = bl2;
                                                                                                                                        }
                                                                                                                                        if (bl4) break block197;
                                                                                                                                        if (!bl16) break block196;
                                                                                                                                        double d = this.\u03b2.\u04c1() - 3.0;
                                                                                                                                        bl16 = d == 0.0 ? 0 : (d > 0.0 ? 1 : -1);
                                                                                                                                    }
                                                                                                                                    if (bl4) break block198;
                                                                                                                                    if (bl16) break block196;
                                                                                                                                    bl16 = true;
                                                                                                                                    break block198;
                                                                                                                                }
                                                                                                                                bl16 = false;
                                                                                                                            }
                                                                                                                            identityHashMap14.put(oc24a0a5bddf2, bl16);
                                                                                                                            identityHashMap13 = identityHashMap2;
                                                                                                                            oca9cc61aada11 = this.\u03b4;
                                                                                                                            bl15 = bl;
                                                                                                                            if (bl4) break block199;
                                                                                                                            if (!bl15) break block200;
                                                                                                                            bl15 = bl2;
                                                                                                                        }
                                                                                                                        if (bl4) break block201;
                                                                                                                        if (!bl15) break block200;
                                                                                                                        bl15 = true;
                                                                                                                        break block201;
                                                                                                                    }
                                                                                                                    bl15 = false;
                                                                                                                }
                                                                                                                identityHashMap13.put(oca9cc61aada11, bl15);
                                                                                                                identityHashMap12 = identityHashMap2;
                                                                                                                oca9cc61aada10 = this.\u016b;
                                                                                                                bl14 = bl;
                                                                                                                if (bl4) break block202;
                                                                                                                if (!bl14) break block203;
                                                                                                                bl14 = bl2;
                                                                                                            }
                                                                                                            if (bl4) break block204;
                                                                                                            if (!bl14) break block203;
                                                                                                            bl14 = true;
                                                                                                            break block204;
                                                                                                        }
                                                                                                        bl14 = false;
                                                                                                    }
                                                                                                    identityHashMap12.put(oca9cc61aada10, bl14);
                                                                                                    identityHashMap11 = identityHashMap2;
                                                                                                    oca9cc61aada9 = this.\u03d7;
                                                                                                    bl13 = bl;
                                                                                                    if (bl4) break block205;
                                                                                                    if (!bl13) break block206;
                                                                                                    bl13 = bl2;
                                                                                                }
                                                                                                if (bl4) break block207;
                                                                                                if (!bl13) break block206;
                                                                                                bl13 = true;
                                                                                                break block207;
                                                                                            }
                                                                                            bl13 = false;
                                                                                        }
                                                                                        identityHashMap11.put(oca9cc61aada9, bl13);
                                                                                        identityHashMap10 = identityHashMap2;
                                                                                        oc321b4679dd2 = this.\u0184;
                                                                                        bl12 = bl;
                                                                                        if (bl4) break block208;
                                                                                        if (!bl12) break block209;
                                                                                        bl12 = bl2;
                                                                                    }
                                                                                    if (bl4) break block210;
                                                                                    if (!bl12) break block209;
                                                                                    double d = this.\u03b4.\u04c1() - 6.0;
                                                                                    bl12 = d == 0.0 ? 0 : (d > 0.0 ? 1 : -1);
                                                                                }
                                                                                if (bl4) break block211;
                                                                                if (bl12) break block209;
                                                                                bl12 = true;
                                                                                break block211;
                                                                            }
                                                                            bl12 = false;
                                                                        }
                                                                        identityHashMap10.put(oc321b4679dd2, bl12);
                                                                        identityHashMap9 = identityHashMap2;
                                                                        oca9cc61aada8 = this.\u024a;
                                                                        bl11 = n;
                                                                        if (bl4) break block212;
                                                                        if (!bl11) break block213;
                                                                        bl11 = true;
                                                                        break block212;
                                                                    }
                                                                    bl11 = false;
                                                                }
                                                                identityHashMap9.put(oca9cc61aada8, bl11);
                                                                identityHashMap8 = identityHashMap2;
                                                                oca9cc61aada7 = this.\u0229;
                                                                bl10 = n;
                                                                if (bl4) break block214;
                                                                if (!bl10) break block215;
                                                                bl10 = true;
                                                                break block214;
                                                            }
                                                            bl10 = false;
                                                        }
                                                        identityHashMap8.put(oca9cc61aada7, bl10);
                                                        identityHashMap7 = identityHashMap2;
                                                        oca9cc61aada6 = this.\u0202;
                                                        bl9 = n;
                                                        if (bl4) break block216;
                                                        if (!bl9) break block217;
                                                        bl9 = true;
                                                        break block216;
                                                    }
                                                    bl9 = false;
                                                }
                                                identityHashMap7.put(oca9cc61aada6, bl9);
                                                identityHashMap6 = identityHashMap2;
                                                oca9cc61aada5 = this.\u046b;
                                                bl8 = n;
                                                if (bl4) break block218;
                                                if (!bl8) break block219;
                                                bl8 = true;
                                                break block218;
                                            }
                                            bl8 = false;
                                        }
                                        identityHashMap6.put(oca9cc61aada5, bl8);
                                        identityHashMap5 = identityHashMap2;
                                        occ2f8dff8d82 = this.\u02e4;
                                        bl7 = n;
                                        if (bl4) break block220;
                                        if (!bl7) break block221;
                                        bl7 = true;
                                        break block220;
                                    }
                                    bl7 = false;
                                }
                                identityHashMap5.put(occ2f8dff8d82, bl7);
                                identityHashMap4 = identityHashMap2;
                                oca9cc61aada4 = this.\u056d;
                                bl6 = n;
                                if (bl4) break block222;
                                if (bl6 != (0xEF8A5226 ^ 0xEF8A5224)) break block223;
                                bl6 = true;
                                break block222;
                            }
                            bl6 = false;
                        }
                        identityHashMap4.put(oca9cc61aada4, bl6);
                        identityHashMap3 = identityHashMap2;
                        oca9cc61aada3 = this.\u0237;
                        bl5 = n;
                        if (bl4) break block224;
                        if (bl5 != (0xEF8A5226 ^ 0xEF8A5224)) break block225;
                        bl5 = true;
                        break block224;
                    }
                    bl5 = false;
                }
                identityHashMap3.put(oca9cc61aada3, bl5);
                identityHashMap = identityHashMap2;
                oca9cc61aada2 = this.\u0386;
                n2 = n;
                if (bl4) break block226;
                if (n2 != (0xEF8A5227 ^ 0xEF8A5224)) break block227;
                n2 = 1;
                break block226;
            }
            n2 = 0;
        }
        identityHashMap.put(oca9cc61aada2, n2 != 0);
        for (N n10 : this.\u03ed.values()) {
            n10.\u0209((Boolean)identityHashMap2.get(n10), oc69da1aa7f52);
            if (!bl4) continue;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    void \u00eb() {
        int n;
        int n2;
        block5: {
            n2 = (int)this.\u02b8.\u04c1();
            boolean bl = oce6044968f8.\u0452;
            n = n2;
            if (bl) break block5;
            if (n <= 0) return;
            n = n2;
        }
        if (n >= \u027b.length) {
            return;
        }
        this.\u0109.\u0229();
        this.\u00db.\u021e(\u027b[n2]);
        this.\u03f7.\u021e(\u0262[n2]);
    }

    boolean \u0102() {
        boolean bl;
        block8: {
            block7: {
                oc93499ec6de oc93499ec6de2;
                boolean bl2;
                block6: {
                    bl2 = oce6044968f8.\u0452;
                    oc93499ec6de2 = this;
                    if (bl2) break block6;
                    if (oc93499ec6de2.\u02a4.\u04c1() == 0.0) break block7;
                    oc93499ec6de2 = this;
                }
                bl = oc93499ec6de2.\u0109.\u01ed();
                if (bl2) break block8;
                if (!bl) break block7;
                bl = true;
                break block8;
            }
            bl = false;
        }
        return bl;
    }

    boolean \u028d() {
        double d;
        block8: {
            block7: {
                double d2;
                double d3;
                boolean bl;
                block6: {
                    bl = oce6044968f8.\u0452;
                    d3 = this.\u02a4.\u04c1();
                    d2 = 0.0;
                    if (bl) break block6;
                    if (d3 == d2) break block7;
                    d3 = this.\u0405.\u04c1();
                    d2 = 0.0;
                }
                double d4 = d3 - d2;
                d = d4 == 0.0 ? 0 : (d4 > 0.0 ? 1 : -1);
                if (bl) break block8;
                if (d <= 0) break block7;
                d = 1.0;
                break block8;
            }
            d = 0.0;
        }
        return (boolean)d;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    String \u0565(String string) {
        boolean bl = oce6044968f8.\u0452;
        String string2 = string;
        if (bl) return string2;
        if (string2 == null) return "";
        int n = string.isEmpty();
        if (!bl) {
            if (n != 0) {
                return "";
            }
            n = (int)this.\u03b4.\u04c1();
        }
        switch (n) {
            case 1: {
                return " - " + string;
            }
            case 2: {
                return " [" + string + "]";
            }
            case 3: {
                return " (" + string + ")";
            }
            case 4: {
                return " <" + string + ">";
            }
            case 5: {
                return " | " + string;
            }
            case 6: {
                return StringUtils.stripControlCodes(this.\u0184.\u00ca()).replace("{info}", string);
            }
        }
        return " " + string;
    }

    boolean \u0121(oce4cea752dd oce4cea752dd2) {
        boolean bl;
        block5: {
            block4: {
                boolean bl2 = oce6044968f8.\u0452;
                if (oce4cea752dd2 == null) break block4;
                bl = this.\u0278.\u01e9(oc93499ec6de.\u03e2(oce4cea752dd2));
                if (bl2) break block5;
                if (!bl) break block4;
                bl = true;
                break block5;
            }
            bl = false;
        }
        return bl;
    }

    private static String \u03e2(oce4cea752dd oce4cea752dd2) {
        String string = oce4cea752dd2.name().replace((char)(0xB5E29929 ^ 0xB5E29976), (char)(0xB5E29956 ^ 0xB5E29976));
        return string.substring(0, 1).toUpperCase(Locale.ROOT) + string.substring(1);
    }

    private occc831eff22 \u0388(String string, String string2) {
        this.\u0503 = new occc831eff22(string2);
        this.\u03ed.put(string, this.\u0503);
        return this.\u0503;
    }

    private oca9cc61aada \u013d(String string, String string2, int n, String ... stringArray) {
        return this.\u0443(string, new oca9cc61aada(string2, n, stringArray));
    }

    private oca9cc61aada \u051b(String string, String string2, double d, double d2, double d3, double d4) {
        return this.\u0443(string, new oca9cc61aada(string2, d, d2, d3, d4));
    }

    private occ2f8dff8d8 \u0230(String string, String string2, boolean bl) {
        return this.\u0443(string, new occ2f8dff8d8(string2, bl));
    }

    private oc24a0a5bddf \u043e(String string, String string2, int n, int n2, int n3) {
        return this.\u0443(string, new oc24a0a5bddf(string2, n, n2, n3));
    }

    private <T extends N> T \u0443(String string, T t) {
        oc93499ec6de.\u04ac(t, this.\u0503);
        this.\u03ed.put(string, t);
        return t;
    }

    static void \u04ac(N n, occc831eff22 occc831eff222) {
        if (n instanceof oca9cc61aada) {
            oca9cc61aada oca9cc61aada2 = (oca9cc61aada)n;
            oca9cc61aada2.\u026c = occc831eff222;
        } else if (n instanceof occ2f8dff8d8) {
            occ2f8dff8d8 occ2f8dff8d82 = (occ2f8dff8d8)n;
            occ2f8dff8d82.\u03e1 = occc831eff222;
        } else if (n instanceof oc24a0a5bddf) {
            oc24a0a5bddf oc24a0a5bddf2 = (oc24a0a5bddf)n;
            oc24a0a5bddf2.a = occc831eff222;
        } else if (n instanceof oc321b4679dd) {
            oc321b4679dd oc321b4679dd2 = (oc321b4679dd)n;
            oc321b4679dd2.\u01e1 = occc831eff222;
        } else if (n instanceof ocada7dda290) {
            ocada7dda290 ocada7dda2902 = (ocada7dda290)n;
            ocada7dda2902.\u0467 = occc831eff222;
        }
    }

    static {
        double[] dArray = new double[0xE29445CA ^ 0xE29445CF];
        dArray[0] = 0.0;
        dArray[1] = 1.5;
        dArray[0xE29445CD ^ 0xE29445CF] = 2.5;
        dArray[0xE29445CC ^ 0xE29445CF] = 4.0;
        dArray[0xE29445CB ^ 0xE29445CF] = 6.0;
        \u027b = dArray;
        int[] nArray = new int[0xE29445CA ^ 0xE29445CF];
        nArray[0] = 0;
        nArray[1] = 1;
        nArray[0xE29445CD ^ 0xE29445CF] = 0xE29445CD ^ 0xE29445CF;
        nArray[0xE29445CC ^ 0xE29445CF] = 0xE29445CC ^ 0xE29445CF;
        nArray[0xE29445CB ^ 0xE29445CF] = 0xE29445CB ^ 0xE29445CF;
        \u0262 = nArray;
    }
}

