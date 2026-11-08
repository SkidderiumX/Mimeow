/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.awt.Font;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;
import java.util.stream.Stream;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import x.oc05d664c647;
import x.oc1378bc114d;
import x.oc191281ba00;
import x.oc32cfaf85ae;
import x.oc4ec81be012;
import x.oc5ed2c4b1b7;
import x.oc9dc7529f0e;
import x.ocbfcb9603cb;
import x.occ2ae1bdc88;

public class oc3ebac73392 {
    private static final String \u00da = "Minecraft";
    private static final String \u0553 = "/assets/idle.miau/fonts/";
    private static final int \u03ec = 48;
    private static final float \u04e0 = 10.0f;
    private static final float \u0523 = 9.0f;
    private static final float \u0449 = 9.0f;
    private static final float \u04c7 = 9.0f;
    static final float \u03bf = 4.0f;
    private static final float \u0291 = 8.0f;
    private static final oc32cfaf85ae[] \u0137;
    private static final oc32cfaf85ae[] \u01cc;
    private static final String[] \u04a0;
    private static final Map<String, oc32cfaf85ae> \u056f;
    private static final Map<String, Font> \u0577;
    private static final Map<String, oc1378bc114d> \u027a;

    private oc3ebac73392() {
    }

    public static String[] \u037a() {
        return (String[])\u04a0.clone();
    }

    public static oc1378bc114d \u022f(String string, float f) {
        float f2 = Math.max(0.5f, Math.min(4.0f, f));
        return oc3ebac73392.\u027d(string, 10.0f * f2, 4.0f);
    }

    public static oc1378bc114d \u04c2(String string, float f) {
        return oc3ebac73392.\u022f(string, oc05d664c647.\u04e8(f));
    }

    public static oc1378bc114d \u0395(String string) {
        return oc3ebac73392.\u03f2(string, 9.0f);
    }

    public static oc1378bc114d \u013a(String string) {
        return oc3ebac73392.\u03f2(string, 9.0f);
    }

    public static oc1378bc114d \u00db() {
        return oc3ebac73392.\u03f2("ProductSans", 9.0f);
    }

    public static oc1378bc114d \u038c() {
        return oc3ebac73392.\u03f2("ProductSans", 10.0f);
    }

    public static oc1378bc114d \u04c0() {
        return oc3ebac73392.\u03f2("ProductSans", 9.0f);
    }

    public static oc1378bc114d \u0122(float f) {
        return oc3ebac73392.\u00e7("Sf-Bold", f, 4.0f);
    }

    public static oc1378bc114d \u0440() {
        String string = "RinbounceHotbar#" + oc3ebac73392.\u0215() + "#4.0";
        return oc3ebac73392.\u04d7(string, new oc191281ba00());
    }

    public static oc1378bc114d \u00ee(String string) {
        float f = 9.0f;
        if (string == null || oc3ebac73392.\u03de(string)) {
            return oc3ebac73392.\u053b(f);
        }
        oc32cfaf85ae oc32cfaf85ae2 = \u056f.get(string);
        if (oc32cfaf85ae2 == null) {
            return oc3ebac73392.\u053b(f);
        }
        int n = oc3ebac73392.\u0215();
        float f2 = oc3ebac73392.\u022a(f);
        String string2 = string;
        String string3 = "nametag#" + string2 + "#" + f2 + "#" + n + "#8.0";
        return oc3ebac73392.\u04d7(string3, new occ2ae1bdc88(oc32cfaf85ae2, f));
    }

    private static oc1378bc114d \u027d(String string, float f, float f2) {
        float f3 = Math.max(1.0f, f);
        if (string == null || oc3ebac73392.\u03de(string)) {
            return oc3ebac73392.\u053b(f3);
        }
        oc32cfaf85ae oc32cfaf85ae2 = \u056f.get(string);
        if (oc32cfaf85ae2 == null) {
            return oc3ebac73392.\u053b(f3);
        }
        String string2 = string + "#" + oc3ebac73392.\u022a(f3) + "#" + oc3ebac73392.\u0215() + "#" + oc3ebac73392.\u022a(f2);
        return oc3ebac73392.\u04d7(string2, new ocbfcb9603cb(oc32cfaf85ae2, f3, f2));
    }

    private static oc1378bc114d \u03f2(String string, float f) {
        return oc3ebac73392.\u00e7(string, f, 2.0f);
    }

    private static oc1378bc114d \u00e7(String string, float f, float f2) {
        float f3 = Math.max(1.0f, f);
        if (string == null || oc3ebac73392.\u03de(string)) {
            return oc3ebac73392.\u053b(f3);
        }
        oc32cfaf85ae oc32cfaf85ae2 = \u056f.get(string);
        if (oc32cfaf85ae2 == null) {
            return oc3ebac73392.\u053b(f3);
        }
        float f4 = oc3ebac73392.\u022a(f2);
        int n = oc3ebac73392.\u0215();
        float f5 = oc3ebac73392.\u022a(f3);
        String string2 = string + "#height#" + f5 + "#" + n + "#" + f4;
        return oc3ebac73392.\u04d7(string2, new oc5ed2c4b1b7(oc32cfaf85ae2, f3, f2));
    }

    private static oc1378bc114d \u027c(Font font, float f, float f2) {
        float f3;
        float f4;
        float f5 = f;
        oc9dc7529f0e oc9dc7529f0e2 = new oc9dc7529f0e(font.deriveFont(f5), true, f2, oc3ebac73392.\u0289());
        for (int i = 0; i < (0xA2D762B8 ^ 0xA2D762BA) && !((f4 = Math.abs((f3 = Math.max(1.0f, (float)oc9dc7529f0e2.z$1tqmx4tpnr6lq())) - f)) <= 0.5f); ++i) {
            oc9dc7529f0e oc9dc7529f0e3 = oc9dc7529f0e2;
            f5 = Math.max(1.0f, f5 * (f / f3));
            oc9dc7529f0e2 = new oc9dc7529f0e(font.deriveFont(f5), true, f2, oc3ebac73392.\u0289());
            oc9dc7529f0e3.z$2l4c667g0mutb();
        }
        return oc9dc7529f0e2;
    }

    private static oc1378bc114d \u053b(float f) {
        float f2 = Math.max(1.0f, (float)Minecraft.getMinecraft().fontRendererObj.FONT_HEIGHT);
        float f3 = Math.max(0.5f, Math.min(2.0f, f / f2));
        String string = "Minecraft#" + oc3ebac73392.\u022a(f3);
        return oc3ebac73392.\u04d7(string, new oc4ec81be012(f3));
    }

    public static boolean \u03de(String string) {
        return string == null || "Minecraft".equalsIgnoreCase(string);
    }

    private static String[] L() {
        String[] stringArray = new String[\u0137.length + 1];
        stringArray[0] = "Minecraft";
        for (int i = 0; i < \u0137.length; ++i) {
            stringArray[i + 1] = oc3ebac73392.\u0137[i].\u049c;
        }
        return stringArray;
    }

    private static Map<String, oc32cfaf85ae> \u0234() {
        LinkedHashMap<String, oc32cfaf85ae> linkedHashMap = new LinkedHashMap<String, oc32cfaf85ae>();
        for (oc32cfaf85ae oc32cfaf85ae2 : \u0137) {
            linkedHashMap.put(oc32cfaf85ae2.\u049c, oc32cfaf85ae2);
        }
        for (oc32cfaf85ae oc32cfaf85ae2 : \u01cc) {
            linkedHashMap.put(oc32cfaf85ae2.\u049c, oc32cfaf85ae2);
        }
        return linkedHashMap;
    }

    public static int \u0460(int n) {
        if (n <= 1) {
            return Math.max(0, n);
        }
        return 0x92BDEA17 ^ 0x92BDEA15;
    }

    private static Font[] \u0289() {
        String[] stringArray = new String[0x6F8E9C89 ^ 0x6F8E9C8A];
        stringArray[0] = "HarmonyOS_Sans_SC_Regular.ttf";
        stringArray[1] = "LINESeedJP_TTF_Rg.ttf";
        stringArray[0x6F8E9C88 ^ 0x6F8E9C8A] = "LINESeedKR-Rg.ttf";
        Stream<Font> stream = Stream.of(stringArray).map(string -> \u0577.computeIfAbsent((String)string, oc3ebac73392::\u024d)).filter(Objects::nonNull);
        return (Font[])Stream.concat(stream, Stream.of(new Font("Dialog", 0, 1))).toArray(Font[]::new);
    }

    private static Font \u024d(String string) {
        byte[] byArray = oc3ebac73392.\u0216(string);
        if (byArray == null) {
            return null;
        }
        try {
            return Font.createFont(0, new ByteArrayInputStream(byArray));
        }
        catch (Exception exception) {
            try {
                return Font.createFont(1, new ByteArrayInputStream(byArray));
            }
            catch (Exception exception2) {
                return null;
            }
        }
    }

    private static int \u0215() {
        try {
            return Math.max(1, new ScaledResolution(Minecraft.getMinecraft()).getScaleFactor());
        }
        catch (Exception exception) {
            return 1;
        }
    }

    private static float \u022a(float f) {
        return (float)Math.round(f * 100.0f) / 100.0f;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static byte[] \u0216(String string) {
        try (InputStream inputStream2 = oc3ebac73392.class.getResourceAsStream("/assets/idle.miau/fonts/" + string);){
            int n;
            if (inputStream2 == null) {
                byte[] byArray2 = null;
                return byArray2;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] byArray3 = new byte[0x54879647 ^ 0x54878647];
            while ((n = inputStream2.read(byArray3)) != -1) {
                byteArrayOutputStream.write(byArray3, 0, n);
            }
            byte[] byArray = byteArrayOutputStream.toByteArray();
            return byArray;
        }
        catch (IOException iOException) {
            return null;
        }
    }

    private static synchronized oc1378bc114d \u04d7(String string, Supplier<oc1378bc114d> supplier) {
        oc1378bc114d oc1378bc114d2 = \u027a.get(string);
        if (oc1378bc114d2 != null) {
            return oc1378bc114d2;
        }
        oc1378bc114d2 = supplier.get();
        \u027a.put(string, oc1378bc114d2);
        oc3ebac73392.\u0397();
        return oc1378bc114d2;
    }

    private static void \u0397() {
        while (\u027a.size() > (0xEA5A9E22 ^ 0xEA5A9E12)) {
            Iterator<Map.Entry<String, oc1378bc114d>> iterator2 = \u027a.entrySet().iterator();
            if (!iterator2.hasNext()) {
                return;
            }
            Map.Entry<String, oc1378bc114d> entry = iterator2.next();
            iterator2.remove();
            if (entry.getValue() == null) continue;
            entry.getValue().z$2l4c667g0mutb();
        }
    }

    static {
        oc32cfaf85ae[] oc32cfaf85aeArray = new oc32cfaf85ae[0xD4AFADD6 ^ 0xD4AFADDC];
        oc32cfaf85aeArray[0] = new oc32cfaf85ae("Sf-Bold", "Sf-Bold.ttf");
        oc32cfaf85aeArray[1] = new oc32cfaf85ae("ProductSans", "product_sans_regular.ttf");
        oc32cfaf85aeArray[0xD4AFADDE ^ 0xD4AFADDC] = new oc32cfaf85ae("ProductSans-Medium", "product_sans_medium.ttf");
        oc32cfaf85aeArray[0xD4AFADDF ^ 0xD4AFADDC] = new oc32cfaf85ae("ProductSans-Bold", "product_sans_bold.ttf");
        oc32cfaf85aeArray[0xD4AFADD8 ^ 0xD4AFADDC] = new oc32cfaf85ae("ProductSans-Light", "product_sans_light.ttf");
        oc32cfaf85aeArray[0xD4AFADD9 ^ 0xD4AFADDC] = new oc32cfaf85ae("ProductSans-Italic", "product_sans_italic.ttf");
        oc32cfaf85aeArray[0xD4AFADDA ^ 0xD4AFADDC] = new oc32cfaf85ae("ProductSans-BoldItalic", "product_sans_bold_italic.ttf");
        oc32cfaf85aeArray[0xD4AFADDB ^ 0xD4AFADDC] = new oc32cfaf85ae("HarmonyOS", "HarmonyOS_Sans_SC_Regular.ttf");
        oc32cfaf85aeArray[0xD4AFADD4 ^ 0xD4AFADDC] = new oc32cfaf85ae("LINESeed-JP", "LINESeedJP_TTF_Rg.ttf");
        oc32cfaf85aeArray[0xD4AFADD5 ^ 0xD4AFADDC] = new oc32cfaf85ae("LINESeed-KR", "LINESeedKR-Rg.ttf");
        \u0137 = oc32cfaf85aeArray;
        \u01cc = new oc32cfaf85ae[]{new oc32cfaf85ae("MetalGothic", "MetalGothic-DemoVersion-Regular.ttf")};
        \u04a0 = oc3ebac73392.L();
        \u056f = oc3ebac73392.\u0234();
        \u0577 = new ConcurrentHashMap<String, Font>();
        \u027a = new LinkedHashMap<String, oc1378bc114d>(0xD4AFADCC ^ 0xD4AFADDC, 0.75f, true);
    }
}

