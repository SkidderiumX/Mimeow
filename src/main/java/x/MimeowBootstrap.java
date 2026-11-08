/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import net.minecraft.client.main.Main;
import x.ClientNativeBridge;
import x.oc019d1ae7a9;
import x.oc099368a591;
import x.oc69da1aa7f5;

public class MimeowBootstrap {
    private static final String[][] \u01d1;
    public static boolean \u049e;

    private MimeowBootstrap() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void main(String[] stringArray) {
        block10: {
            int n;
            block9: {
                boolean bl = oc019d1ae7a9.\u051e;
                n = MimeowBootstrap.\u049d();
                if (bl) break block9;
                if (n < (0x1C364DCC ^ 0x1C364DDD)) {
                    throw new IllegalStateException("Mimeow requires Java 17 or newer");
                }
                oc099368a591.\u0177();
                if (bl) break block10;
                oc019d1ae7a9.\u0267();
                n = MimeowBootstrap.\u012c() ? 1 : 0;
            }
            if (n != 0) {
                try {
                    ClientNativeBridge.\u04bd(0x517F0C88 ^ 0x1C364DDD, MimeowBootstrap.\u049d(), System.nanoTime());
                }
                catch (LinkageError linkageError) {
                    // empty catch block
                }
            }
            Main.main(MimeowBootstrap.\u04d9(stringArray));
        }
    }

    private static boolean \u012c() {
        return System.getProperty("os.name", "").toLowerCase(Locale.ROOT).contains("win");
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static int \u049d() {
        int n;
        String string;
        block8: {
            String string2;
            boolean bl;
            block6: {
                block7: {
                    string = System.getProperty("java.specification.version", "0");
                    bl = oc019d1ae7a9.\u051e;
                    string2 = string;
                    if (bl) break block6;
                    if (!string2.startsWith("1.")) break block7;
                    string = string.substring(0xFAFD30A0 ^ 0xFAFD30A2);
                }
                string2 = string;
            }
            int n2 = string2.indexOf(0xFAFD308C ^ 0xFAFD30A2);
            n = n2;
            if (bl) return n;
            if (n < 0) break block8;
            string = string.substring(0, n2);
        }
        try {
            n = Integer.parseInt(string);
            return n;
        }
        catch (NumberFormatException numberFormatException) {
            return 0;
        }
    }

    static String[] \u04d9(String[] stringArray) {
        String[][] stringArray2;
        block14: {
            List<String> list;
            boolean bl;
            block13: {
                String[] stringArray3;
                block11: {
                    block12: {
                        bl = oc019d1ae7a9.\u051e;
                        stringArray3 = stringArray;
                        if (bl) break block11;
                        if (stringArray3 != null) break block12;
                        list = Collections.emptyList();
                        break block13;
                    }
                    stringArray3 = stringArray;
                }
                list = Arrays.asList(stringArray3);
            }
            List<String> list2 = list;
            ArrayList<String> arrayList = new ArrayList<String>(list2);
            String[][] stringArray4 = \u01d1;
            int n = stringArray4.length;
            int n2 = 0;
            while (n2 < n) {
                block15: {
                    block16: {
                        stringArray2 = stringArray4;
                        if (bl) break block14;
                        String[] stringArray5 = stringArray2[n2];
                        if (bl) break block15;
                        if (!list2.stream().noneMatch(string -> {
                            boolean bl;
                            block6: {
                                block8: {
                                    block7: {
                                        boolean bl2 = oc019d1ae7a9.\u051e;
                                        bl = string.equals(stringArray5[0]);
                                        if (bl2) break block6;
                                        if (bl) break block7;
                                        bl = string.startsWith(stringArray5[0] + "=");
                                        if (bl2) break block6;
                                        if (!bl) break block8;
                                    }
                                    bl = true;
                                    break block6;
                                }
                                bl = false;
                            }
                            return bl;
                        })) break block16;
                        arrayList.add(0, stringArray5[1]);
                        arrayList.add(0, stringArray5[0]);
                    }
                    ++n2;
                }
                if (!bl) continue;
                boolean bl2 = !false;
                oc69da1aa7f5.\u04ac = bl2;
                break;
            }
            stringArray2 = arrayList.toArray(new String[0]);
        }
        return (String[])stringArray2;
    }

    static {
        String[][] stringArrayArray = new String[0xBACD1C87 ^ 0xBACD1C82][];
        String[] stringArray = new String[0xBACD1C80 ^ 0xBACD1C82];
        stringArray[0] = "--version";
        stringArray[1] = "Miau";
        stringArrayArray[0] = stringArray;
        String[] stringArray2 = new String[0xBACD1C80 ^ 0xBACD1C82];
        stringArray2[0] = "--accessToken";
        stringArray2[1] = "0";
        stringArrayArray[1] = stringArray2;
        String[] stringArray3 = new String[0xBACD1C80 ^ 0xBACD1C82];
        stringArray3[0] = "--assetsDir";
        stringArray3[1] = "assets";
        stringArrayArray[0xBACD1C80 ^ 0xBACD1C82] = stringArray3;
        String[] stringArray4 = new String[0xBACD1C80 ^ 0xBACD1C82];
        stringArray4[0] = "--assetIndex";
        stringArray4[1] = "1.8";
        stringArrayArray[0xBACD1C81 ^ 0xBACD1C82] = stringArray4;
        String[] stringArray5 = new String[0xBACD1C80 ^ 0xBACD1C82];
        stringArray5[0] = "--userProperties";
        stringArray5[1] = "{}";
        stringArrayArray[0xBACD1C86 ^ 0xBACD1C82] = stringArray5;
        \u01d1 = stringArrayArray;
    }
}

