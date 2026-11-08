/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.lang.reflect.Field;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import x.I;
import x.oc02a3730b27;
import x.oc30e402796f;
import x.oc33e2bcdd33;
import x.oc497d0cdf29;
import x.oc6111f05032;
import x.ocb3a2e541bd;
import x.occc82079da8;

public class ocb683e2d821 {
    private static int \u015b;
    private static int A;
    private static float \u02af;
    private static float \u0377;
    private static float \u0572;
    private static float \u0403;
    private static float \u0156;
    private static float \u0508;
    private static float \u04ea;
    private static float \u026e;
    private static float \u0497;
    private static float \u04e2;
    private static float \u0212;
    private static float \u04c4;
    private static float \u053a;
    private static boolean \u0155;
    private static boolean \u016a;
    private static boolean \u0275;
    private static boolean \u025a;
    private static boolean \u01ed;
    private static boolean \u00df;
    private static int \u0146;
    private static KeyBinding[] \u027a;
    private static Entity \u023c;
    private static final ocb3a2e541bd \u0427;
    private static final ocb3a2e541bd \u0499;
    private static final Field \u023b;
    public static boolean \u04fe;

    private ocb683e2d821() {
    }

    public static void \u051d(oc6111f05032 oc6111f050322, double d, float f) {
        block12: {
            int n;
            block13: {
                block14: {
                    oc6111f05032 oc6111f050323;
                    int n2;
                    block10: {
                        block11: {
                            n2 = oc02a3730b27.\u0166;
                            oc6111f050323 = oc6111f050322;
                            if (n2 != 0) break block10;
                            if (oc6111f050323.\u0544()) break block11;
                            ocb683e2d821.\u0250(oc6111f050322);
                            if (n2 == 0) break block12;
                        }
                        oc6111f050323 = oc6111f050322;
                    }
                    float f2 = oc6111f050323.\u0128().gameSettings.mouseSensitivity * 0.6f + 0.2f;
                    \u02af = f2 * f2 * f2 * 8.0f * 0.15f;
                    int n3 = A++;
                    n = n3;
                    if (n2 != 0) break block13;
                    if (n <= 0) break block14;
                    \u0572 = 0.0f;
                    \u0377 = 0.0f;
                }
                n = 0;
            }
            \u015b = n;
        }
    }

    public static boolean \u04dc(int n) {
        int n2;
        block4: {
            block5: {
                int n3 = oc02a3730b27.\u0166;
                n2 = n;
                if (n3 != 0) break block4;
                if (Integer.compareUnsigned(n2, \u015b) >= 0) break block5;
                return false;
            }
            \u015b = n;
            n2 = 1;
        }
        return n2 != 0;
    }

    public static boolean \u029d() {
        return \u0155;
    }

    public static float \u0548() {
        return \u026e;
    }

    public static float O() {
        return \u0497;
    }

    public static float \u0524() {
        return \u0508;
    }

    public static float \u020a() {
        return \u04ea;
    }

    public static float \u00dc() {
        return \u0377;
    }

    public static float \u026f() {
        return \u0572;
    }

    public static float \u0100() {
        return \u0403;
    }

    public static float \u04f9() {
        return \u0156;
    }

    public static void \u029a() {
        \u0156 = 0.0f;
        \u0403 = 0.0f;
    }

    public static void \u00fc(oc6111f05032 oc6111f050322, boolean bl, float f, float f2) {
        block8: {
            block9: {
                oc6111f05032 oc6111f050323;
                block10: {
                    int n = oc02a3730b27.\u0166;
                    ocb683e2d821.\u0446(oc6111f050322);
                    if (n != 0) break block8;
                    if (\u0155) break block9;
                    oc6111f050323 = oc6111f050322;
                    if (n != 0) break block10;
                    if (oc6111f050323.\u016d() == null) break block9;
                    \u0155 = true;
                    \u0508 = oc6111f050322.\u016d().rotationYaw;
                    oc6111f050323 = oc6111f050322;
                }
                \u04ea = oc6111f050323.\u016d().rotationPitch;
            }
            \u016a = bl;
            \u026e = f;
            \u0497 = f2;
            \u0275 = false;
        }
    }

    public static void \u021c(oc6111f05032 oc6111f050322) {
        ocb683e2d821.\u0544(oc6111f050322, false);
    }

    public static void \u0544(oc6111f05032 oc6111f050322, boolean bl) {
        block18: {
            oc6111f05032 oc6111f050323;
            float f;
            float f2;
            block23: {
                float f3;
                float f4;
                int n;
                block22: {
                    float f5;
                    float f6;
                    block20: {
                        float f7;
                        block21: {
                            float f8;
                            block19: {
                                n = oc02a3730b27.\u0166;
                                if (oc6111f050322.\u016d() == null) break block18;
                                f8 = \u02af;
                                if (n != 0) break block19;
                                if (f8 == 0.0f) break block18;
                                f8 = ocb683e2d821.\u03ee(\u0377, \u02af);
                            }
                            f7 = f8;
                            f4 = ocb683e2d821.\u03ee(\u0572, \u02af);
                            f6 = \u0377;
                            f5 = f7;
                            if (n != 0) break block20;
                            \u0377 = f6 - f5;
                            \u0572 -= f4;
                            if (f7 != 0.0f) break block21;
                            f3 = f4;
                            if (n != 0) break block22;
                            if (f3 == 0.0f) break block18;
                        }
                        f6 = f7;
                        f5 = oc6111f050322.\u016d().rotationYaw;
                    }
                    f3 = f6 + f5;
                }
                f2 = f3;
                f = f4 + oc6111f050322.\u016d().rotationPitch;
                oc6111f050323 = oc6111f050322;
                if (n != 0) break block23;
                ocb683e2d821.\u01a0(oc6111f050323.\u016d(), f2, f, true);
                if (!bl) break block18;
                oc6111f050323 = oc6111f050322;
            }
            ocb683e2d821.\u03ec(oc6111f050323, f2, f);
        }
    }

    public static void \u0264(float f, float f2) {
        \u0377 += f;
        \u0572 += f2;
        A = 0;
    }

    public static void \u0567(float f, float f2) {
        \u0403 += f;
        \u0156 += f2;
    }

    public static boolean \u03b7(Entity entity, oc6111f05032 oc6111f050322, float f, float f2) {
        return false;
    }

    public static void \u0389(oc6111f05032 oc6111f050322) {
        block11: {
            boolean bl;
            EntityPlayerSP entityPlayerSP;
            block14: {
                int n;
                block12: {
                    block13: {
                        block10: {
                            ocb683e2d821.\u03a1();
                            n = oc02a3730b27.\u0166;
                            entityPlayerSP = oc6111f050322.\u016d();
                            if (n != 0) break block10;
                            if (entityPlayerSP == null) break block11;
                            \u04e2 = entityPlayerSP.rotationYaw;
                            \u0212 = entityPlayerSP.rotationPitch;
                        }
                        bl = \u01ed;
                        if (n != 0) break block12;
                        if (!bl) break block13;
                        \u01ed = false;
                        ocb683e2d821.\u01a0(entityPlayerSP, \u0508, \u04ea, true);
                    }
                    bl = \u0155;
                }
                if (n != 0) break block14;
                if (!bl) break block11;
                bl = true;
            }
            \u00df = bl;
            \u023c = entityPlayerSP;
            ocb683e2d821.\u01a0(entityPlayerSP, \u0508, \u04ea, false);
        }
    }

    private static void \u0221(Entity entity) {
        block8: {
            Entity entity2;
            block9: {
                block10: {
                    int n = oc02a3730b27.\u0166;
                    if (!\u00df) break block8;
                    entity2 = entity;
                    if (n != 0) break block9;
                    if (entity2 == \u023c) break block10;
                    ocb683e2d821.\u03a1();
                    if (n == 0) break block8;
                }
                \u0508 = entity.rotationYaw;
                entity2 = entity;
            }
            \u04ea = entity2.rotationPitch;
            ocb683e2d821.\u03a1();
        }
    }

    private static void \u03a1() {
        block5: {
            Entity entity;
            block4: {
                int n = oc02a3730b27.\u0166;
                Entity entity2 = \u00df ? \u023c : null;
                Entity entity3 = entity2;
                \u00df = false;
                \u023c = null;
                entity = entity3;
                if (n != 0) break block4;
                if (entity == null) break block5;
                entity = entity3;
            }
            ocb683e2d821.\u01a0(entity, \u04e2, \u0212, true);
        }
    }

    public static void \u0430() {
        ocb683e2d821.\u051e();
        ocb683e2d821.\u027e();
        ocb683e2d821.\u03a1();
    }

    public static void \u02a9(oc6111f05032 oc6111f050322) {
        block9: {
            float f;
            float f2;
            block10: {
                oc6111f05032 oc6111f050323;
                int n;
                block8: {
                    n = oc02a3730b27.\u0166;
                    oc6111f050323 = oc6111f050322;
                    if (n != 0) break block8;
                    if (!oc6111f050323.\u0544()) break block9;
                    oc6111f050323 = oc6111f050322;
                }
                float f3 = oc6111f050323.\u016d().rotationYaw - \u04c4;
                f2 = oc6111f050322.\u016d().rotationPitch - \u053a;
                f = f3;
                if (n != 0) break block10;
                if (((Float.floatToRawIntBits(f) | Float.floatToRawIntBits(f2)) & (0x53D10092 ^ 0x2C2EFF6D)) == 0) break block9;
                f = f3;
            }
            ocb683e2d821.\u0567(f, f2);
        }
    }

    public static void \u026c(oc6111f05032 oc6111f050322) {
        block5: {
            oc6111f05032 oc6111f050323;
            block4: {
                int n = oc02a3730b27.\u0166;
                oc6111f050323 = oc6111f050322;
                if (n != 0) break block4;
                if (!oc6111f050323.\u0544()) break block5;
                \u04c4 = oc6111f050322.\u016d().rotationYaw;
                oc6111f050323 = oc6111f050322;
            }
            \u053a = oc6111f050323.\u016d().rotationPitch;
        }
    }

    public static void \u03a9(float f, float f2) {
        \u0508 = oc497d0cdf29.\u0538(f - \u0508) + \u0508;
        \u04ea = f2;
        \u01ed = true;
    }

    public static float \u03ee(float f, float f2) {
        float f3;
        block12: {
            block13: {
                float f4;
                block14: {
                    block15: {
                        int n = oc02a3730b27.\u0166;
                        f3 = f2;
                        if (n != 0) break block12;
                        if (f3 == 0.0f) break block13;
                        f4 = -f2;
                        if (n != 0) break block14;
                        if (f4 >= f) break block15;
                        f3 = f;
                        if (n != 0) break block12;
                        if (!(f3 >= f2)) break block13;
                    }
                    f4 = f / f2;
                }
                float f5 = f4;
                float f6 = I.\u011f(f5);
                return f6 * f2;
            }
            f3 = 0.0f;
        }
        return f3;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void W(oc6111f05032 oc6111f050322, oc33e2bcdd33 oc33e2bcdd332) {
        block17: {
            boolean bl;
            block20: {
                int n;
                block18: {
                    block19: {
                        boolean bl2;
                        boolean bl3;
                        block16: {
                            ocb683e2d821.\u0446(oc6111f050322);
                            n = oc02a3730b27.\u0166;
                            bl3 = oc6111f050322.\u0544();
                            if (n != 0) break block16;
                            if (!bl3) break block17;
                            bl3 = oc33e2bcdd332.\u00e4;
                        }
                        bl = bl2 = bl3;
                        if (n != 0) break block18;
                        if (!bl) break block19;
                        boolean bl4 = \u0155;
                        if (n == 0) {
                            if (!bl4) {
                                \u0508 = oc6111f050322.\u016d().rotationYaw;
                                \u04ea = oc6111f050322.\u016d().rotationPitch;
                            }
                            \u0155 = true;
                            \u016a = oc33e2bcdd332.\u0430;
                            \u026e = oc33e2bcdd332.\u0538;
                            \u0497 = oc33e2bcdd332.\u04b8;
                            bl4 = \u0275 = oc33e2bcdd332.T;
                        }
                        if (n == 0) break block17;
                    }
                    bl = \u0155;
                }
                if (n != 0) break block20;
                if (!bl) break block17;
                \u0155 = false;
                bl = \u016a;
            }
            float f = bl ? \u026e : \u0508;
            float f2 = \u016a ? \u0497 : \u04ea;
            f = oc497d0cdf29.\u0538(f - oc6111f050322.\u016d().rotationYaw) + oc6111f050322.\u016d().rotationYaw;
            ocb683e2d821.\u01a0(oc6111f050322.\u016d(), f, f2, true);
            ocb683e2d821.\u03ec(oc6111f050322, f, f2);
        }
    }

    public static int \u00b5(int n, float f) {
        int n2;
        block32: {
            block38: {
                int n3;
                block36: {
                    int n4;
                    block37: {
                        block34: {
                            block35: {
                                block30: {
                                    int n5;
                                    block31: {
                                        block33: {
                                            block28: {
                                                block29: {
                                                    n5 = (n & 1) - (n >>> 1 & 1);
                                                    n4 = (n >>> (0xCE0CF67D ^ 0xCE0CF67F) & 1) - (n >>> (0xCE0CF67C ^ 0xCE0CF67F) & 1);
                                                    n3 = oc02a3730b27.\u0166;
                                                    n2 = n5;
                                                    if (n3 != 0) break block28;
                                                    if (n2 != 0) break block29;
                                                    n2 = n4;
                                                    if (n3 != 0) break block28;
                                                    if (n2 != 0) break block29;
                                                    return 0;
                                                }
                                                n2 = n5;
                                            }
                                            if (n3 != 0) break block30;
                                            if (n2 != 0) break block31;
                                            n2 = n4;
                                            if (n3 != 0) break block32;
                                            if (n2 != 1) break block33;
                                            n2 = 0xCE0CF67D ^ 0xCE0CF67F;
                                            break block32;
                                        }
                                        n2 = 0xCE0CF679 ^ 0xCE0CF67F;
                                        break block32;
                                    }
                                    n2 = n5;
                                }
                                if (n3 != 0) break block34;
                                if (n2 != -1) break block35;
                                n2 = (0xCE0CF67A ^ 0xCE0CF67F) - (n4 + 1);
                                break block32;
                            }
                            n2 = n4;
                        }
                        if (n3 != 0) break block36;
                        if (n2 != 1) break block37;
                        n2 = 1;
                        break block32;
                    }
                    n2 = n4;
                }
                if (n3 != 0) break block32;
                if (n2 != -1) break block38;
                n2 = 0xCE0CF678 ^ 0xCE0CF67F;
                break block32;
            }
            n2 = 0;
        }
        int n6 = n2;
        float f2 = oc497d0cdf29.\u0538(f) / 45.0f;
        float f3 = I.X(f2);
        int[] nArray = new int[0xCE0CF677 ^ 0xCE0CF67F];
        nArray[0] = 1;
        nArray[1] = 0xCE0CF67A ^ 0xCE0CF67F;
        nArray[0xCE0CF67D ^ 0xCE0CF67F] = 0xCE0CF67B ^ 0xCE0CF67F;
        nArray[0xCE0CF67C ^ 0xCE0CF67F] = 0xCE0CF679 ^ 0xCE0CF67F;
        nArray[0xCE0CF67B ^ 0xCE0CF67F] = 0xCE0CF67D ^ 0xCE0CF67F;
        nArray[0xCE0CF67A ^ 0xCE0CF67F] = 0xCE0CF675 ^ 0xCE0CF67F;
        nArray[0xCE0CF679 ^ 0xCE0CF67F] = 0xCE0CF677 ^ 0xCE0CF67F;
        nArray[0xCE0CF678 ^ 0xCE0CF67F] = 0xCE0CF676 ^ 0xCE0CF67F;
        int[] nArray2 = nArray;
        return nArray2[oc30e402796f.\u00fd(f3) + n6 & (0xCE0CF678 ^ 0xCE0CF67F)];
    }

    private static KeyBinding[] \u0417(oc6111f05032 oc6111f050322) {
        GameSettings gameSettings = oc6111f050322.\u0128().gameSettings;
        KeyBinding[] keyBindingArray = new KeyBinding[0x3D3CB8D1 ^ 0x3D3CB8D5];
        keyBindingArray[0] = gameSettings.keyBindForward;
        keyBindingArray[1] = gameSettings.keyBindBack;
        keyBindingArray[0x3D3CB8D7 ^ 0x3D3CB8D5] = gameSettings.keyBindLeft;
        keyBindingArray[0x3D3CB8D6 ^ 0x3D3CB8D5] = gameSettings.keyBindRight;
        return keyBindingArray;
    }

    public static void \u0222(oc6111f05032 oc6111f050322) {
        block11: {
            boolean bl;
            block13: {
                block14: {
                    int n;
                    block12: {
                        block10: {
                            n = oc02a3730b27.\u0166;
                            bl = \u0275;
                            if (n != 0) break block10;
                            if (!bl) break block11;
                            bl = \u025a;
                        }
                        if (n != 0) break block12;
                        if (bl) break block11;
                        bl = oc6111f050322.\u044f();
                    }
                    if (n != 0) break block13;
                    if (!bl) break block14;
                    ocb683e2d821.\u0470(ocb683e2d821.\u0417(oc6111f050322), oc6111f050322.\u016d().rotationYaw - \u026e);
                }
                bl = true;
            }
            \u025a = bl;
        }
    }

    private static void \u0470(KeyBinding[] keyBindingArray, float f) {
        block7: {
            int n;
            \u027a = keyBindingArray;
            \u0146 = 0;
            int n2 = oc02a3730b27.\u0166;
            for (n = 0; n < (0xAD6EA8DD ^ 0xAD6EA8D9); ++n) {
                int n3;
                block8: {
                    if (n2 != 0) break block7;
                    n3 = keyBindingArray[n].isKeyDown();
                    if (n2 != 0) break block8;
                    if (n3 == 0) continue;
                    n3 = \u0146 | 1 << n;
                }
                \u0146 = n3;
                if (n2 == 0) continue;
            }
            n = ocb683e2d821.\u00b5(\u0146, f);
            ocb683e2d821.\u0438(keyBindingArray, n);
            \u025a = true;
        }
    }

    public static void \u0446(oc6111f05032 oc6111f050322) {
        block15: {
            boolean bl;
            block18: {
                block17: {
                    oc6111f05032 oc6111f050323;
                    int n;
                    block16: {
                        block12: {
                            block14: {
                                KeyBinding[] keyBindingArray;
                                block13: {
                                    n = oc02a3730b27.\u0166;
                                    if (oc6111f050322 != null) break block12;
                                    keyBindingArray = \u027a;
                                    if (n != 0) break block13;
                                    if (keyBindingArray == null) break block14;
                                    keyBindingArray = \u027a;
                                }
                                ocb683e2d821.\u0438(keyBindingArray, \u0146);
                            }
                            \u027a = null;
                        }
                        if (!\u025a) break block15;
                        oc6111f050323 = oc6111f050322;
                        if (n != 0) break block16;
                        if (oc6111f050323 == null) break block17;
                        oc6111f050323 = oc6111f050322;
                    }
                    bl = oc6111f050323.\u044f();
                    if (n != 0) break block18;
                    if (!bl) break block17;
                    ocb683e2d821.\u0438(ocb683e2d821.\u0417(oc6111f050322), \u0146);
                    \u027a = null;
                }
                \u0275 = false;
                bl = false;
            }
            \u025a = bl;
        }
    }

    public static void \u04ef(oc6111f05032 oc6111f050322) {
        block20: {
            oc6111f05032 oc6111f050323;
            block22: {
                block23: {
                    int n;
                    block21: {
                        boolean bl;
                        block18: {
                            block19: {
                                n = oc02a3730b27.\u0166;
                                bl = \u00df;
                                if (n != 0) break block18;
                                if (!bl) break block19;
                                if (\u023c == oc6111f050322.\u016d()) break block19;
                                ocb683e2d821.\u03a1();
                            }
                            bl = \u0155;
                        }
                        if (!bl || ocb683e2d821.\u0427.\u02a9 != null) break block20;
                        oc6111f050323 = oc6111f050322;
                        if (n != 0) break block21;
                        if (oc6111f050323.\u016d() == null) break block20;
                        oc6111f050323 = oc6111f050322;
                    }
                    if (n != 0) break block22;
                    if (oc6111f050323.\u0128().renderGlobal == null) break block23;
                    oc6111f050322.\u0128().renderGlobal.setDisplayListEntitiesDirty();
                }
                ocb683e2d821.\u0221(oc6111f050322.\u016d());
                oc6111f050323 = oc6111f050322;
            }
            ocb683e2d821.\u019d(oc6111f050323.\u016d());
        }
    }

    private static void \u019d(Entity entity) {
        \u0427.\u04c2(entity);
    }

    public static void \u027e() {
        \u0427.\u0444();
    }

    public static void \u03e7(oc6111f05032 oc6111f050322) {
        block6: {
            ocb3a2e541bd ocb3a2e541bd2;
            block7: {
                int n = oc02a3730b27.\u0166;
                if (!\u0155) break block6;
                ocb3a2e541bd2 = \u0499;
                if (n != 0) break block7;
                if (ocb3a2e541bd2.\u02a9 != null) break block6;
                ocb3a2e541bd2 = \u0499;
            }
            ocb3a2e541bd2.\u04c2(oc6111f050322.\u016d());
        }
    }

    public static void \u051e() {
        \u0499.\u0444();
    }

    public static float \u0100(float f) {
        float f2 = \u0155 ? \u04ea : f;
        return f2;
    }

    public static float \u020d(float f) {
        float f2 = \u0155 ? \u0508 : f;
        return f2;
    }

    private static void \u01a0(Entity entity, float f, float f2, boolean bl) {
        block5: {
            float f3;
            block4: {
                entity.rotationYaw = f;
                int n = oc02a3730b27.\u0166;
                Entity entity2 = entity;
                f3 = -90.0f;
                if (n != 0) break block4;
                entity2.rotationPitch = oc497d0cdf29.\u053c(f3, 90.0f, f2);
                if (!bl) break block5;
                entity.prevRotationYaw = f;
                entity2 = entity;
                f3 = entity.rotationPitch;
            }
            entity2.prevRotationPitch = f3;
        }
    }

    private static void \u03ec(oc6111f05032 oc6111f050322, float f, float f2) {
        oc6111f050322.\u016d().prevRenderArmYaw = f;
        oc6111f050322.\u016d().prevRenderArmPitch = f2;
        oc6111f050322.\u016d().renderArmYaw = f;
        oc6111f050322.\u016d().renderArmPitch = f2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void \u0438(KeyBinding[] keyBindingArray, int n) {
        int n2 = oc02a3730b27.\u0166;
        try {
            int i = 0;
            do {
                if (i >= (0xF8478DDD ^ 0xF8478DD9)) return;
                if (n2 != 0) return;
                KeyBinding keyBinding = keyBindingArray[i];
                int n3 = n;
                if (n2 == 0) {
                    n3 = (n3 & 1 << i) != 0 ? 1 : 0;
                }
                \u023b.setBoolean(keyBinding, n3 != 0);
                ++i;
            } while (n2 == 0);
            return;
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new IllegalStateException(illegalAccessException);
        }
    }

    public static void \u0250(oc6111f05032 oc6111f050322) {
        ocb683e2d821.\u0430();
        ocb683e2d821.\u0446(null);
        \u0275 = false;
        \u016a = false;
        \u0155 = false;
        A = 0;
        \u015b = 0;
        \u02af = 0.0f;
        \u00df = false;
        \u01ed = false;
        \u023c = null;
        \u0156 = 0.0f;
        \u0403 = 0.0f;
        \u0572 = 0.0f;
        \u0377 = 0.0f;
        int n = oc02a3730b27.\u0166;
        \u053a = 0.0f;
        \u04c4 = 0.0f;
        \u0497 = 0.0f;
        \u026e = 0.0f;
        \u04ea = 0.0f;
        \u0508 = 0.0f;
        \u0212 = 0.0f;
        \u04e2 = 0.0f;
        \u0146 = 0;
        if (false) {
            oc02a3730b27.\u0166 = ++n;
        }
    }

    static {
        \u0427 = new ocb3a2e541bd();
        \u0499 = new ocb3a2e541bd();
        String[] stringArray = new String[0x3C4A7684 ^ 0x3C4A7686];
        stringArray[0] = "pressed";
        stringArray[1] = "field_74513_e";
        \u023b = occc82079da8.\u00d0(KeyBinding.class, stringArray);
    }
}

