/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import x.oc69da1aa7f5;
import x.oc9755810e45;
import x.oca9cc61aada;
import x.oce4cea752dd;
import x.oce6044968f8;

public class ocf1c26cb57f
extends oc69da1aa7f5 {
    private static final int \u00f0 = 0;
    private static final String[] U;
    private final oca9cc61aada \u0215 = new oca9cc61aada("Mode", 0, U);
    public static int \u0214;

    public ocf1c26cb57f() {
        super("NoArmorOverlay", oce4cea752dd.\u014e);
        this.\u028c(this.\u0215);
    }

    public static boolean \u019e(EntityLivingBase entityLivingBase) {
        boolean bl;
        block8: {
            block7: {
                ocf1c26cb57f ocf1c26cb57f2;
                boolean bl2;
                ocf1c26cb57f ocf1c26cb57f3;
                block6: {
                    ocf1c26cb57f3 = oc9755810e45.\u00ef;
                    bl2 = oce6044968f8.\u0452;
                    ocf1c26cb57f2 = ocf1c26cb57f3;
                    if (bl2) break block6;
                    if (ocf1c26cb57f2 == null) break block7;
                    ocf1c26cb57f2 = ocf1c26cb57f3;
                }
                boolean bl3 = ocf1c26cb57f2.z$3rzb3dil7uydr();
                int n = (int)ocf1c26cb57f3.\u0215.\u04c1();
                boolean bl4 = entityLivingBase instanceof EntityPlayer;
                boolean bl5 = entityLivingBase == Minecraft.getMinecraft().thePlayer;
                bl = ocf1c26cb57f.\u049a(bl3, n, bl4, bl5);
                if (bl2) break block8;
                if (!bl) break block7;
                bl = true;
                break block8;
            }
            bl = false;
        }
        return bl;
    }

    static boolean \u049a(boolean n, int n2, boolean bl, boolean bl2) {
        int n3;
        block13: {
            block11: {
                block14: {
                    boolean bl3;
                    block12: {
                        block10: {
                            bl3 = oce6044968f8.\u0452;
                            n3 = n;
                            if (bl3) break block10;
                            if (n3 == 0) break block11;
                            n3 = bl ? 1 : 0;
                        }
                        if (bl3) break block12;
                        if (n3 == 0) break block11;
                        n3 = n2;
                    }
                    if (bl3) break block13;
                    if (n3 == 0) break block14;
                    n3 = bl2 ? 1 : 0;
                    if (bl3) break block13;
                    if (n3 == 0) break block11;
                }
                n3 = 1;
                break block13;
            }
            n3 = 0;
        }
        return n3 != 0;
    }

    static {
        String[] stringArray = new String[0xEA1DFC40 ^ 0xEA1DFC42];
        stringArray[0] = "All";
        stringArray[1] = "Self";
        U = stringArray;
    }
}

