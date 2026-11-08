/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import x.oc2cf3d80e17;
import x.oc66fa4f2195;
import x.oc69da1aa7f5;
import x.oc7ab2161b9f;
import x.oc9755810e45;
import x.oca9cc61aada;
import x.ocadfd5cc157;
import x.occ2f8dff8d8;
import x.oce4cea752dd;

public class oca4f99d2d44
extends oc69da1aa7f5 {
    private static final HashMap<EntityPlayer, Long> \u057e = new HashMap();
    private static oca9cc61aada \u017e;
    private static oca9cc61aada \u0199;
    private static occ2f8dff8d8 \u0474;
    private occ2f8dff8d8 \u01d9;
    public static int \u0564;

    public oca4f99d2d44() {
        super("AntiBot", oce4cea752dd.\u04b6, 0);
        \u017e = new oca9cc61aada("Delay", " second", true, -1.0, 0.5, 15.0, 0.5);
        this.\u028c(\u017e);
        \u0199 = new oca9cc61aada("Pit spawn", true, -1.0, 70.0, 120.0, 1.0);
        this.\u028c(\u0199);
        \u0474 = new occ2f8dff8d8("Tab list", false);
        this.\u028c(\u0474);
        this.\u01d9 = new occ2f8dff8d8("Print world join", false);
        this.\u028c(this.\u01d9);
        this.\u026e = true;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @oc66fa4f2195
    public void \u01be(ocadfd5cc157 ocadfd5cc1572) {
        int n;
        block21: {
            double d;
            block24: {
                block22: {
                    block23: {
                        ocadfd5cc157 ocadfd5cc1573;
                        block20: {
                            n = oc69da1aa7f5.\u04fe;
                            ocadfd5cc1573 = ocadfd5cc1572;
                            if (n != 0) break block20;
                            if (!(ocadfd5cc1573.\u0426 instanceof EntityPlayer) && !oc2cf3d80e17.\u0125) break block21;
                            ocadfd5cc1573 = ocadfd5cc1572;
                        }
                        if (ocadfd5cc1573.\u0426 == oc69da1aa7f5.\u0151.thePlayer) break block21;
                        double d2 = \u017e.\u04c1() - -1.0;
                        d = d2 == 0.0 ? 0 : (d2 > 0.0 ? 1 : -1);
                        if (n != 0) break block22;
                        if (d == false) break block23;
                        d = (double)(ocadfd5cc1572.\u0426 instanceof EntityPlayer);
                        if (n != 0) break block22;
                        if (d != false) {
                            \u057e.put((EntityPlayer)ocadfd5cc1572.\u0426, System.currentTimeMillis());
                        }
                    }
                    d = (double)this.\u01d9.\u01ed();
                }
                if (n != 0) break block24;
                if (d == false) break block21;
                d = ocadfd5cc1572.\u0426.getEntityId();
            }
            oc7ab2161b9f.\u00fd("&7Entity &b" + (int)d + " &7joined: &r" + ocadfd5cc1572.\u0426.getDisplayName().getFormattedText());
        }
        if (n != 0) {
            boolean bl = true;
            oc69da1aa7f5.\u04ac = bl;
        }
    }

    @Override
    public void z$1m9j3ewef9s() {
        block9: {
            HashMap<EntityPlayer, Long> hashMap;
            block10: {
                double d;
                block8: {
                    int n = oc69da1aa7f5.\u04fe;
                    double d2 = \u017e.\u04c1() - -1.0;
                    d = d2 == 0.0 ? 0 : (d2 > 0.0 ? 1 : -1);
                    if (n != 0) break block8;
                    if (d == false) break block9;
                    hashMap = \u057e;
                    if (n != 0) break block10;
                    d = (double)hashMap.isEmpty();
                }
                if (d != false) break block9;
                hashMap = \u057e;
            }
            hashMap.values().removeIf(l -> {
                long l2;
                block2: {
                    block3: {
                        int n = oc69da1aa7f5.\u04fe;
                        long l3 = l - (System.currentTimeMillis() - (long)(\u017e.\u04c1() * 1000.0));
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
        }
    }

    @Override
    public void onDisable() {
        \u057e.clear();
    }

    public static boolean \u039b(Entity entity) {
        block76: {
            Object object;
            EntityPlayer entityPlayer;
            block77: {
                block80: {
                    block79: {
                        block78: {
                            block75: {
                                block74: {
                                    block73: {
                                        block72: {
                                            block71: {
                                                block70: {
                                                    if (oc9755810e45.\u01f4 != null && oc9755810e45.\u01f4.z$3rzb3dil7uydr()) break block70;
                                                    return false;
                                                }
                                                if (entity != null && entity instanceof EntityPlayer) break block71;
                                                return true;
                                            }
                                            entityPlayer = (EntityPlayer)entity;
                                            if (\u017e.\u04c1() == -1.0 || \u057e.isEmpty()) break block72;
                                            if (!\u057e.containsKey(entityPlayer)) break block72;
                                            return true;
                                        }
                                        if (entityPlayer.isDead) {
                                            return true;
                                        }
                                        if (entityPlayer.getName().isEmpty()) {
                                            return true;
                                        }
                                        if (!\u0474.\u01ed() || oca4f99d2d44.\u0224().contains(entityPlayer.getName())) break block73;
                                        return true;
                                    }
                                    if (entityPlayer.getHealth() == 20.0f || !entityPlayer.getName().startsWith("\u00a7c")) break block74;
                                    return true;
                                }
                                if (\u0199.\u04c1() == -1.0 || !(entityPlayer.posY >= \u0199.\u04c1())) break block75;
                                if (!(entityPlayer.posY <= 130.0)) break block75;
                                if (!(entityPlayer.getDistance(0.0, 114.0, 0.0) <= 25.0)) break block75;
                                if (!oc7ab2161b9f.\u054f()) break block75;
                                object = oc7ab2161b9f.\u0570();
                                if (object.isEmpty() || !oc7ab2161b9f.\u045b((String)object.get(0)).contains("THE HYPIXEL PIT")) break block75;
                                return true;
                            }
                            if (entityPlayer.maxHurtTime != 0) break block76;
                            if (entityPlayer.getHealth() != 20.0f) break block77;
                            object = entityPlayer.getDisplayName().getUnformattedText();
                            if (((String)object).length() != (0x80DAA24C ^ 0x80DAA246) || ((String)object).charAt(0) == (0x80DAA2E1 ^ 0x80DAA246)) break block78;
                            return true;
                        }
                        if (((String)object).length() != (0x80DAA24A ^ 0x80DAA246) || !entityPlayer.isPlayerSleeping()) break block79;
                        if (((String)object).charAt(0) != (0x80DAA2E1 ^ 0x80DAA246)) break block79;
                        return true;
                    }
                    if (((String)object).length() < (0x80DAA241 ^ 0x80DAA246) || ((String)object).charAt(0x80DAA244 ^ 0x80DAA246) != (0x80DAA21D ^ 0x80DAA246)) break block80;
                    if (((String)object).charAt(0x80DAA245 ^ 0x80DAA246) != (0x80DAA208 ^ 0x80DAA246)) break block80;
                    if (((String)object).charAt(0x80DAA240 ^ 0x80DAA246) != (0x80DAA21B ^ 0x80DAA246)) break block80;
                    return true;
                }
                if (entityPlayer.getName().contains(" ")) {
                    return true;
                }
                break block76;
            }
            if (entityPlayer.isInvisible()) {
                object = entityPlayer.getDisplayName().getUnformattedText();
                if (((String)object).length() < (0x80DAA245 ^ 0x80DAA246) || ((String)object).charAt(0) != (0x80DAA2E1 ^ 0x80DAA246)) break block76;
                if (((String)object).charAt(1) != (0x80DAA225 ^ 0x80DAA246)) break block76;
                return true;
            }
        }
        return false;
    }

    private static List<String> \u0224() {
        ArrayList<String> arrayList = new ArrayList<String>();
        for (NetworkPlayerInfo networkPlayerInfo : oc7ab2161b9f.\u02e0(true)) {
            if (networkPlayerInfo == null) {
                continue;
            }
            arrayList.add(networkPlayerInfo.getGameProfile().getName());
        }
        return arrayList;
    }
}

