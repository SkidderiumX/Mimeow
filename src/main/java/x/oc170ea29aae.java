/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.nio.IntBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL14;
import x.oc040fe9e89e;

public class oc170ea29aae {
    private static final long[] \u03d9 = new long[oc040fe9e89e.values().length];
    private static final ArrayDeque<oc040fe9e89e> \u042a = new ArrayDeque();
    private static oc040fe9e89e \u04a1 = oc040fe9e89e.t;
    private static Thread \u0155;
    private static int \u0474;
    private static long \u0279;
    private static List<String> \u0450;
    public static boolean \u0406;

    private oc170ea29aae() {
    }

    public static void \u03ec(boolean bl) {
        block18: {
            block17: {
                int n;
                long l;
                block19: {
                    boolean bl2;
                    block15: {
                        block16: {
                            bl2 = \u0406;
                            if (!bl) {
                                \u0155 = null;
                                \u042a.clear();
                                \u0450 = Collections.emptyList();
                                return;
                            }
                            l = System.nanoTime();
                            if (bl2) break block15;
                            if (\u0155 == Thread.currentThread()) break block16;
                            \u0155 = Thread.currentThread();
                            Arrays.fill(\u03d9, 0L);
                            \u0474 = 0;
                            \u0279 = l;
                            \u0450 = Collections.singletonList("Draw calls: ...");
                            if (!bl2) break block17;
                        }
                        ++\u0474;
                        if (bl2) break block18;
                    }
                    if (l - \u0279 < (0x4DF58AB889CC9A22L ^ 0x4DF58AB8B2565022L)) break block17;
                    n = \u0474;
                    if (bl2) break block19;
                    if (n <= 0) break block17;
                    \u0450 = oc170ea29aae.\u0122(\u0474);
                    Arrays.fill(\u03d9, 0L);
                    n = 0;
                }
                \u0474 = n;
                \u0279 = l;
            }
            \u042a.clear();
            \u04a1 = oc040fe9e89e.t;
        }
    }

    public static void \u0376(String string) {
        block6: {
            oc040fe9e89e oc040fe9e89e2;
            block5: {
                boolean bl = \u0406;
                if (\u0155 != Thread.currentThread()) {
                    return;
                }
                \u042a.push(\u04a1);
                oc040fe9e89e oc040fe9e89e3 = oc170ea29aae.\u03a4(string);
                oc040fe9e89e2 = oc040fe9e89e3;
                if (bl) break block5;
                if (oc040fe9e89e2 == null) break block6;
                oc040fe9e89e2 = oc040fe9e89e3;
            }
            \u04a1 = oc040fe9e89e2;
        }
    }

    public static void \u011f() {
        block6: {
            Object object;
            block7: {
                boolean bl = \u0406;
                if (\u0155 != Thread.currentThread()) break block6;
                object = \u042a;
                if (bl) break block7;
                if (object.isEmpty()) break block6;
                object = \u042a.pop();
            }
            \u04a1 = (oc040fe9e89e)((Object)object);
        }
    }

    public static oc040fe9e89e \u03c7(oc040fe9e89e oc040fe9e89e2) {
        oc040fe9e89e oc040fe9e89e3 = \u04a1;
        if (\u0155 == Thread.currentThread()) {
            \u04a1 = oc040fe9e89e2;
        }
        return oc040fe9e89e3;
    }

    public static void \u03c9(oc040fe9e89e oc040fe9e89e2) {
        if (\u0155 == Thread.currentThread()) {
            \u04a1 = oc040fe9e89e2;
        }
    }

    public static List<String> \u03ae() {
        return \u0450;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static oc040fe9e89e \u03a4(String string) {
        int n;
        block75: {
            String string2 = string;
            int n2 = -1;
            boolean bl = \u0406;
            n = string2.hashCode();
            if (bl) break block75;
            switch (n) {
                case -1423437003: {
                    n = string2.equals("terrain") ? 1 : 0;
                    if (!bl) {
                        if (n == 0) break;
                        n2 = 0;
                        if (!bl) break;
                    }
                    break block75;
                }
                case 1608037619: {
                    n = string2.equals("terrain_setup") ? 1 : 0;
                    if (!bl) {
                        if (n == 0) break;
                        n2 = 1;
                        if (!bl) break;
                    }
                    break block75;
                }
                case 1053837986: {
                    n = string2.equals("render_SOLID") ? 1 : 0;
                    if (!bl) {
                        if (n == 0) break;
                        n2 = 0xD878224D ^ 0xD878224F;
                        if (!bl) break;
                    }
                    break block75;
                }
                case -2143041387: {
                    n = string2.equals("render_CUTOUT") ? 1 : 0;
                    if (!bl) {
                        if (n == 0) break;
                        n2 = 0xD878224C ^ 0xD878224F;
                        if (!bl) break;
                    }
                    break block75;
                }
                case -931544795: {
                    n = string2.equals("render_CUTOUT_MIPPED") ? 1 : 0;
                    if (!bl) {
                        if (n == 0) break;
                        n2 = 0xD878224B ^ 0xD878224F;
                        if (!bl) break;
                    }
                    break block75;
                }
                case -1546419696: {
                    n = string2.equals("render_TRANSLUCENT") ? 1 : 0;
                    if (!bl) {
                        if (n == 0) break;
                        n2 = 0xD878224A ^ 0xD878224F;
                        if (!bl) break;
                    }
                    break block75;
                }
                case 113953: {
                    n = string2.equals("sky") ? 1 : 0;
                    if (!bl) {
                        if (n == 0) break;
                        n2 = 0xD8782249 ^ 0xD878224F;
                        if (!bl) break;
                    }
                    break block75;
                }
                case -1357518626: {
                    n = string2.equals("clouds") ? 1 : 0;
                    if (!bl) {
                        if (n == 0) break;
                        n2 = 0xD8782248 ^ 0xD878224F;
                        if (!bl) break;
                    }
                    break block75;
                }
                case 1223440372: {
                    n = string2.equals("weather") ? 1 : 0;
                    if (!bl) {
                        if (n == 0) break;
                        n2 = 0xD8782247 ^ 0xD878224F;
                        if (!bl) break;
                    }
                    break block75;
                }
                case -2102114367: {
                    n = string2.equals("entities") ? 1 : 0;
                    if (!bl) {
                        if (n == 0) break;
                        n2 = 0xD8782246 ^ 0xD878224F;
                        if (!bl) break;
                    }
                    break block75;
                }
                case -192629388: {
                    n = string2.equals("entityOutlines") ? 1 : 0;
                    if (!bl) {
                        if (n == 0) break;
                        n2 = 0xD8782245 ^ 0xD878224F;
                        if (!bl) break;
                    }
                    break block75;
                }
                case 267988814: {
                    n = string2.equals("blockentities") ? 1 : 0;
                    if (!bl) {
                        if (n == 0) break;
                        n2 = 0xD8782244 ^ 0xD878224F;
                        if (!bl) break;
                    }
                    break block75;
                }
                case 237623766: {
                    n = string2.equals("litParticles") ? 1 : 0;
                    if (!bl) {
                        if (n == 0) break;
                        n2 = 0xD8782243 ^ 0xD878224F;
                        if (!bl) break;
                    }
                    break block75;
                }
                case -1800314195: {
                    n = string2.equals("particles") ? 1 : 0;
                    if (!bl) {
                        if (n == 0) break;
                        n2 = 0xD8782242 ^ 0xD878224F;
                        if (!bl) break;
                    }
                    break block75;
                }
                case 102715: {
                    n = string2.equals("gui") ? 1 : 0;
                    if (!bl) {
                        if (n == 0) break;
                        n2 = 0xD8782241 ^ 0xD878224F;
                        if (!bl) break;
                    }
                    break block75;
                }
                case 95458899: {
                    n = string2.equals("debug") ? 1 : 0;
                    if (bl) break block75;
                    if (n == 0) break;
                    n2 = 0xD8782240 ^ 0xD878224F;
                }
            }
            n = n2;
        }
        switch (n) {
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: {
                return oc040fe9e89e.\u04eb;
            }
            case 6: 
            case 7: 
            case 8: {
                return oc040fe9e89e.\u03be;
            }
            case 9: 
            case 10: {
                return oc040fe9e89e.K;
            }
            case 11: {
                return oc040fe9e89e.\u0217;
            }
            case 12: 
            case 13: {
                return oc040fe9e89e.\u03d4;
            }
            case 14: 
            case 15: {
                return oc040fe9e89e.\u04d8;
            }
        }
        return null;
    }

    private static void \u00dc() {
        if (\u0155 == Thread.currentThread()) {
            int n = \u04a1.ordinal();
            \u03d9[n] = \u03d9[n] + 1L;
        }
    }

    private static List<String> \u0122(int n) {
        long l = 0L;
        Object object = \u03d9;
        int n2 = ((long[])object).length;
        boolean bl = \u0406;
        for (int i = 0; i < n2; ++i) {
            long l2 = object[i];
            l += l2;
            if (!bl) continue;
        }
        object = new ArrayList(0xA22516B ^ 0xA225168);
        object.add("Draw calls: " + Math.round((double)l / (double)n) + "/frame");
        oc040fe9e89e[] oc040fe9e89eArray = new oc040fe9e89e[0xA22516C ^ 0xA225168];
        oc040fe9e89eArray[0] = oc040fe9e89e.\u04eb;
        oc040fe9e89eArray[1] = oc040fe9e89e.\u03be;
        oc040fe9e89eArray[0xA22516A ^ 0xA225168] = oc040fe9e89e.K;
        oc040fe9e89eArray[0xA22516B ^ 0xA225168] = oc040fe9e89e.\u0217;
        object.add(oc170ea29aae.\u02a8(n, oc040fe9e89eArray));
        oc040fe9e89e[] oc040fe9e89eArray2 = new oc040fe9e89e[0xA22516C ^ 0xA225168];
        oc040fe9e89eArray2[0] = oc040fe9e89e.\u03d4;
        oc040fe9e89eArray2[1] = oc040fe9e89e.\u0291;
        oc040fe9e89eArray2[0xA22516A ^ 0xA225168] = oc040fe9e89e.\u04d8;
        oc040fe9e89eArray2[0xA22516B ^ 0xA225168] = oc040fe9e89e.t;
        object.add(oc170ea29aae.\u02a8(n, oc040fe9e89eArray2));
        return object;
    }

    private static String \u02a8(int n, oc040fe9e89e ... oc040fe9e89eArray) {
        StringBuilder stringBuilder = new StringBuilder(" ");
        boolean bl = \u0406;
        for (int i = 0; i < oc040fe9e89eArray.length; ++i) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            oc040fe9e89e oc040fe9e89e2 = oc040fe9e89eArray[i];
            stringBuilder.append(oc040fe9e89e2.\u021f).append((char)(0xECD760E7 ^ 0xECD760C7)).append(Math.round((double)\u03d9[oc040fe9e89e2.ordinal()] / (double)n));
            if (!bl) continue;
        }
        return stringBuilder.toString();
    }

    public static void \u03ad(int n, int n2, int n3) {
        oc170ea29aae.\u00dc();
        GL11.glDrawArrays(n, n2, n3);
    }

    public static void \u0146(int n) {
        oc170ea29aae.\u00dc();
        GL11.glCallList(n);
    }

    public static void \u01b8(IntBuffer intBuffer) {
        oc170ea29aae.\u00dc();
        GL11.glCallLists(intBuffer);
    }

    public static void \u0446(int n, IntBuffer intBuffer, IntBuffer intBuffer2) {
        oc170ea29aae.\u00dc();
        GL14.glMultiDrawArrays(n, intBuffer, intBuffer2);
    }

    public static void \u0177() {
        oc170ea29aae.\u00dc();
        GL11.glEnd();
    }

    static {
        \u0450 = Collections.emptyList();
    }
}

