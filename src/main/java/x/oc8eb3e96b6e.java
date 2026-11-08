/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import org.lwjgl.input.Mouse;
import x.MouseEvent;
import x.oc02a3730b27;
import x.oc2cf3d80e17;
import x.oc66fa4f2195;
import x.oc7ab2161b9f;

public class oc8eb3e96b6e {
    private static Minecraft s = Minecraft.getMinecraft();
    private static List<Long> \u011c = new ArrayList<Long>();
    private static List<Long> \u041f = new ArrayList<Long>();
    public static long \u04db = 0L;
    public static long \u011e = 0L;
    private static int \u03a7 = 0;
    private static boolean \u01f0 = false;
    public static boolean \u03fe;

    public static void \u040a() {
        \u03a7 = Mouse.getDWheel();
        \u01f0 = true;
    }

    public static boolean \u0533(int n) {
        int n2;
        block22: {
            block23: {
                boolean bl;
                block28: {
                    block29: {
                        int n3;
                        block24: {
                            block25: {
                                boolean bl2;
                                block26: {
                                    block27: {
                                        block20: {
                                            block21: {
                                                n3 = oc02a3730b27.\u0166;
                                                n2 = \u01f0;
                                                if (n3 != 0) break block20;
                                                if (n2 != 0) break block21;
                                                \u03a7 = Mouse.getDWheel();
                                                \u01f0 = true;
                                            }
                                            n2 = \u03a7;
                                        }
                                        if (n3 != 0) break block22;
                                        if (n2 == 0) break block23;
                                        n2 = n;
                                        if (n3 != 0) break block24;
                                        if (n2 != (0xA98A188 ^ 0xA98A5A5)) break block25;
                                        bl2 = \u03a7;
                                        if (n3 != 0) break block26;
                                        if (bl2 <= false) break block27;
                                        bl2 = true;
                                        break block26;
                                    }
                                    bl2 = false;
                                }
                                return bl2;
                            }
                            n2 = n;
                        }
                        if (n3 != 0) break block22;
                        if (n2 != (0xA98A18B ^ 0xA98A5A5)) break block23;
                        bl = \u03a7;
                        if (n3 != 0) break block28;
                        if (bl >= false) break block29;
                        bl = true;
                        break block28;
                    }
                    bl = false;
                }
                return bl;
            }
            n2 = 0;
        }
        return n2 != 0;
    }

    public static void \u0458() {
        \u01f0 = false;
        \u03a7 = 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @oc66fa4f2195
    public void \u0216(MouseEvent mouseEvent) {
        int n = oc02a3730b27.\u0166;
        MouseEvent mouseEvent2 = mouseEvent;
        if (n == 0) {
            if (!mouseEvent2.buttonstate) {
                return;
            }
            mouseEvent2 = mouseEvent;
        }
        if (n == 0) {
            if (mouseEvent2.button == 0) {
                Entity entity;
                oc8eb3e96b6e.\u0400();
                if (!oc2cf3d80e17.\u0125) return;
                Minecraft minecraft = s;
                if (n == 0) {
                    if (minecraft.objectMouseOver == null) return;
                    minecraft = s;
                }
                Entity entity2 = entity = minecraft.objectMouseOver.entityHit;
                if (n == 0) {
                    if (entity2 == null) return;
                    entity2 = entity;
                }
                if (n == 0) {
                    if (!(entity2 instanceof EntityLivingBase)) {
                        return;
                    }
                    entity2 = entity;
                }
                oc7ab2161b9f.\u015a((EntityLivingBase)entity2);
                if (n == 0) return;
            }
            mouseEvent2 = mouseEvent;
        }
        if (mouseEvent2.button != 1) return;
        oc8eb3e96b6e.\u044b();
    }

    public static void \u0400() {
        \u04db = System.currentTimeMillis();
        \u011c.add(\u04db);
    }

    public static void \u044b() {
        \u011e = System.currentTimeMillis();
        \u041f.add(\u011e);
    }

    public static int \u022c() {
        \u011c.removeIf(l -> {
            long l2;
            block2: {
                block3: {
                    int n = oc02a3730b27.\u0166;
                    long l3 = l - (System.currentTimeMillis() - (0x1EAAE0E44F8EA829L ^ 0x1EAAE0E44F8EABC1L));
                    l2 = l3 == 0L ? 0 : (l3 < 0L ? -1 : 1);
                    if (n != 0) break block2;
                    if (l2 >= 0) break block3;
                    l2 = 1;
                    break block2;
                }
                l2 = 0;
            }
            return (boolean)l2;
        });
        return \u011c.size();
    }

    public static int \u0424() {
        \u041f.removeIf(l -> {
            long l2;
            block2: {
                block3: {
                    int n = oc02a3730b27.\u0166;
                    long l3 = l - (System.currentTimeMillis() - (0xB07BF7A0C7232729L ^ 0xB07BF7A0C72324C1L));
                    l2 = l3 == 0L ? 0 : (l3 < 0L ? -1 : 1);
                    if (n != 0) break block2;
                    if (l2 >= 0) break block3;
                    l2 = 1;
                    break block2;
                }
                l2 = 0;
            }
            return (boolean)l2;
        });
        return \u041f.size();
    }
}

