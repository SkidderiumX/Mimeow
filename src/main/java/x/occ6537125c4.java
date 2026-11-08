/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemEnderPearl;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.util.Vec3;
import x.oc02e6d57a60;
import x.oc2f61de30bc;
import x.oc66fa4f2195;
import x.oc69da1aa7f5;
import x.oc746a23b244;
import x.oc7ab2161b9f;
import x.oc9755810e45;
import x.oc9d4393f3ce;
import x.oca4f99d2d44;
import x.ocadfd5cc157;
import x.ocbd4917c4b1;
import x.occ2f8dff8d8;
import x.oce21f48fe00;
import x.oce4cea752dd;
import x.ocfa11b18c57;

public class occ6537125c4
extends oc69da1aa7f5 {
    public occ2f8dff8d8 \u01e0;
    public occ2f8dff8d8 \u051c;
    public occ2f8dff8d8 \u020b;
    public final Map<EntityPlayer, Long> \u04d4 = new HashMap<EntityPlayer, Long>();
    private final Map<String, ocfa11b18c57> \u044a = new LinkedHashMap<String, ocfa11b18c57>();
    private final Map<Vec3, Long> \u042c = new LinkedHashMap<Vec3, Long>();
    public final List<Integer> x = new ArrayList<Integer>();
    private static final int \u00d4 = new Color(0x57FA7F88 ^ 0x57FA7F77, 0, 0).getRGB();
    private static final int \u01f1 = new Color(0x57FA7FA5 ^ 0x57FA7F77, 0, 0x57FA7F88 ^ 0x57FA7F77, 0x57FA7F37 ^ 0x57FA7F77).getRGB();
    private static final String[] \u0250;
    private boolean \u017e;
    public static boolean \u0534;
    public static boolean \u018f;

    public occ6537125c4() {
        super("Sky Wars", oce4cea752dd.\u0502);
        this.\u0105("Some Utils for SkyWars.");
        this.\u051c = new occ2f8dff8d8("Only aura hostile mobs", true);
        this.\u028c(this.\u051c);
        this.\u020b = new occ2f8dff8d8("Render time warp", true);
        this.\u028c(this.\u020b);
        this.\u01e0 = new occ2f8dff8d8("Strength indicator", true);
        this.\u028c(this.\u01e0);
    }

    @Override
    public void onDisable() {
        this.\u04ea();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @oc66fa4f2195
    public void \u0402(oc2f61de30bc oc2f61de30bc2) {
        int n;
        int n2;
        block38: {
            block39: {
                block36: {
                    int n3;
                    block37: {
                        int n4;
                        block34: {
                            block35: {
                                block33: {
                                    block32: {
                                        block31: {
                                            n2 = ocfa11b18c57.\u0117;
                                            n4 = this.\u01e0.\u01ed();
                                            if (n2 != 0) break block31;
                                            if (n4 == 0) return;
                                            n4 = oc7ab2161b9f.\u00d0();
                                        }
                                        if (n2 != 0) break block32;
                                        if (n4 == 0) return;
                                        n4 = this.\u04d4.isEmpty();
                                    }
                                    if (n2 != 0) break block33;
                                    if (n4 != 0) return;
                                    n4 = oc7ab2161b9f.\u042c();
                                }
                                if (n2 != 0) break block34;
                                if (n4 == (0x8B87A8EA ^ 0x8B87A8E8)) break block35;
                                return;
                            }
                            n4 = this.\u0570();
                        }
                        n3 = n4;
                        n = n3;
                        if (n2 != 0) break block36;
                        if (n != (0x8B87A8EA ^ 0x8B87A8E8)) break block37;
                        return;
                    }
                    n = n3;
                }
                if (n2 != 0) break block38;
                if (n != 1) break block39;
                n = 1;
                break block38;
            }
            n = 0;
        }
        \u0534 = n;
        long l = \u0534 ? 0x1010C1D3C8732C41L ^ 0x1010C1D3C8732B91L : 0x1010C1D3C8733819L ^ 0x1010C1D3C8732B91L;
        long l2 = l;
        ArrayList<EntityPlayer> arrayList = new ArrayList<EntityPlayer>(this.\u04d4.keySet());
        for (EntityPlayer entityPlayer : arrayList) {
            block40: {
                Object object;
                block41: {
                    long l3 = this.\u04d4.get(entityPlayer);
                    long l4 = System.currentTimeMillis() - l3;
                    if (n2 != 0) break block40;
                    if (l4 >= l2) break block41;
                    object = entityPlayer;
                    if (n2 != 0) break block40;
                    if (oca4f99d2d44.\u039b((Entity)object)) break block41;
                    if (n2 == 0) continue;
                }
                object = this.\u04d4.remove(entityPlayer);
            }
            if (n2 == 0) continue;
        }
    }

    @oc66fa4f2195
    public void \u04a9(oc02e6d57a60 oc02e6d57a602) {
        block58: {
            String[] stringArray;
            String[] stringArray2;
            int n;
            block63: {
                int n2;
                String string;
                block62: {
                    block60: {
                        block61: {
                            block59: {
                                block57: {
                                    block54: {
                                        occ6537125c4 occ6537125c42;
                                        block56: {
                                            block55: {
                                                String string2;
                                                block52: {
                                                    block53: {
                                                        block68: {
                                                            block51: {
                                                                byte by;
                                                                block50: {
                                                                    n = ocfa11b18c57.\u0117;
                                                                    by = oc02e6d57a602.\u03c1;
                                                                    if (n != 0) break block50;
                                                                    if (by == (0x10D80A3 ^ 0x10D80A1)) break block51;
                                                                    by = (byte)(oc7ab2161b9f.\u00d0() ? 1 : 0);
                                                                }
                                                                if (by != 0) break block68;
                                                            }
                                                            return;
                                                        }
                                                        string = oc7ab2161b9f.\u045b(oc02e6d57a602.\u01eb.getUnformattedText());
                                                        string2 = string;
                                                        if (n != 0) break block52;
                                                        if (!string2.isEmpty()) break block53;
                                                        return;
                                                    }
                                                    string2 = string;
                                                }
                                                n2 = string2.equals("You will be warped back in 3 seconds!");
                                                if (n != 0) break block54;
                                                if (n2 == 0) break block55;
                                                occ6537125c42 = this;
                                                if (n != 0) break block56;
                                                if (!occ6537125c42.\u017e) break block55;
                                                this.\u042c.put(new Vec3(oc69da1aa7f5.\u0151.thePlayer.lastTickPosX, oc69da1aa7f5.\u0151.thePlayer.lastTickPosY, oc69da1aa7f5.\u0151.thePlayer.lastTickPosZ), System.currentTimeMillis());
                                                this.\u017e = false;
                                                return;
                                            }
                                            occ6537125c42 = this;
                                        }
                                        n2 = occ6537125c42.\u01e0.\u01ed();
                                    }
                                    if (n != 0) break block57;
                                    if (n2 == 0) break block58;
                                    n2 = oc7ab2161b9f.\u042c();
                                }
                                if (n != 0) break block59;
                                if (n2 != (0x10D80A3 ^ 0x10D80A1)) break block58;
                                n2 = this.\u0570();
                            }
                            if (n != 0) break block60;
                            if (n2 != (0x10D80A3 ^ 0x10D80A1)) break block61;
                            return;
                        }
                        n2 = string.endsWith(".") ? 1 : 0;
                    }
                    if (n != 0) break block62;
                    if (n2 == 0) break block58;
                    stringArray2 = \u0250;
                    if (n != 0) break block63;
                    n2 = Arrays.stream(stringArray2).anyMatch(string::contains) ? 1 : 0;
                }
                if (n2 == 0) break block58;
                stringArray2 = string.split(" ");
            }
            block46: for (String string : stringArray = stringArray2) {
                Iterator iterator2;
                String string3;
                block64: {
                    block65: {
                        string3 = string;
                        if (n != 0) break block64;
                        if (string3.endsWith(".")) break block65;
                        if (n == 0) continue;
                    }
                    string3 = string.substring(0, string.length() - 1);
                }
                String string4 = string3;
                Iterator iterator3 = iterator2 = oc69da1aa7f5.\u0151.theWorld.playerEntities.iterator();
                while (iterator2.hasNext()) {
                    Object object;
                    EntityPlayer entityPlayer;
                    block67: {
                        block66: {
                            iterator3 = iterator2;
                            if (n != 0) continue;
                            entityPlayer = (EntityPlayer)iterator3.next();
                            object = entityPlayer;
                            if (n != 0) break block66;
                            if (!((EntityPlayer)object).getName().trim().equals(string4)) continue;
                            object = entityPlayer;
                        }
                        if (n != 0) continue block46;
                        if (object != oc69da1aa7f5.\u0151.thePlayer) break block67;
                        if (n == 0) continue;
                    }
                    object = this.\u04d4.put(entityPlayer, System.currentTimeMillis());
                    continue block46;
                }
                if (n == 0) continue;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @oc66fa4f2195
    public void \u04e3(oc746a23b244 oc746a23b2442) {
        block35: {
            Iterator<Object> iterator2;
            Iterator<Object> iterator3;
            int n;
            block28: {
                occ6537125c4 occ6537125c42;
                block34: {
                    block33: {
                        int n2;
                        block31: {
                            block32: {
                                block30: {
                                    block29: {
                                        n = ocfa11b18c57.\u0117;
                                        n2 = oc7ab2161b9f.\u00d0();
                                        if (n != 0) break block29;
                                        if (n2 == 0) break block30;
                                        n2 = oc7ab2161b9f.\u042c();
                                    }
                                    if (n != 0) break block31;
                                    if (n2 == (0xB9427A3A ^ 0xB9427A38)) break block32;
                                }
                                return;
                            }
                            occ6537125c42 = this;
                            if (n != 0) break block33;
                            n2 = occ6537125c42.\u01e0.\u01ed() ? 1 : 0;
                        }
                        if (n2 != 0) {
                            iterator3 = this.\u04d4.keySet().iterator();
                            while (iterator3.hasNext()) {
                                iterator2 = iterator3;
                                if (n == 0) {
                                    EntityPlayer entityPlayer = (EntityPlayer)iterator2.next();
                                    if (n == 0) {
                                        if (oca4f99d2d44.\u039b(entityPlayer) && n == 0) continue;
                                        ocbd4917c4b1.\u01a8(entityPlayer, 0xB9427A3A ^ 0xB9427A38, 0.0, 0.0, \u00d4, false);
                                    }
                                    if (n == 0) continue;
                                }
                                break block28;
                            }
                        }
                        occ6537125c42 = this;
                    }
                    if (n != 0) break block34;
                    if (!occ6537125c42.\u020b.\u01ed()) break block35;
                    occ6537125c42 = this;
                }
                iterator2 = occ6537125c42.\u042c.entrySet().iterator();
            }
            iterator3 = iterator2;
            long l = System.currentTimeMillis();
            while (iterator3.hasNext()) {
                block38: {
                    Vec3 vec3;
                    block37: {
                        block36: {
                            Map.Entry entry = (Map.Entry)iterator3.next();
                            vec3 = (Vec3)entry.getKey();
                            long l2 = (Long)entry.getValue();
                            if (n != 0) break block36;
                            if (l - l2 < (0xE225B1B9C72A4EE0L ^ 0xE225B1B9C72A450AL)) break block37;
                            iterator3.remove();
                        }
                        if (n == 0) break block38;
                    }
                    ocbd4917c4b1.\u0111(vec3, \u01f1);
                }
                if (n == 0) continue;
            }
        }
    }

    @oc66fa4f2195
    public void \u0125(ocadfd5cc157 ocadfd5cc1572) {
        block24: {
            occ6537125c4 occ6537125c42;
            block29: {
                int n;
                block28: {
                    ocfa11b18c57 ocfa11b18c572;
                    String string;
                    int n2;
                    block30: {
                        block27: {
                            double d;
                            block26: {
                                block25: {
                                    ocadfd5cc157 ocadfd5cc1573;
                                    block22: {
                                        block23: {
                                            n2 = ocfa11b18c57.\u0117;
                                            ocadfd5cc1573 = ocadfd5cc1572;
                                            if (n2 != 0) break block22;
                                            if (ocadfd5cc1573.\u0426 != oc69da1aa7f5.\u0151.thePlayer) break block23;
                                            this.\u04ea();
                                            if (n2 == 0) break block24;
                                        }
                                        ocadfd5cc1573 = ocadfd5cc1572;
                                    }
                                    if (ocadfd5cc1573.\u0426 == null) break block24;
                                    if (oc7ab2161b9f.\u042c() == (0x2682DBCB ^ 0x2682DBC9)) break block25;
                                    return;
                                }
                                string = ocadfd5cc1572.\u0426.getClass().getSimpleName();
                                if (!this.\u044a.containsKey(string)) break block24;
                                Vec3 vec3 = new Vec3(ocadfd5cc1572.\u0426.posX, ocadfd5cc1572.\u0426.posY, ocadfd5cc1572.\u0426.posZ);
                                ocfa11b18c572 = this.\u044a.get(string);
                                double d2 = ocfa11b18c572.\u03a0.distanceTo(vec3) - 3.0;
                                d = d2 == 0.0 ? 0 : (d2 > 0.0 ? 1 : -1);
                                if (n2 != 0) break block26;
                                if (d > 0) break block27;
                                n = oc69da1aa7f5.\u0151.thePlayer.ticksExisted;
                                if (n2 != 0) break block28;
                                long l = oc7ab2161b9f.\u048a(n, ocfa11b18c572.\u020d) - (0x3CAA9ADCDE8762D4L ^ 0x3CAA9ADCDE8762E8L);
                                d = l == 0L ? 0 : (l < 0L ? -1 : 1);
                            }
                            if (d <= 0) break block30;
                        }
                        return;
                    }
                    occ6537125c42 = this;
                    if (n2 != 0) break block29;
                    n = occ6537125c42.\u044a.remove(string, ocfa11b18c572) ? 1 : 0;
                }
                if (n == 0) {
                    return;
                }
                occ6537125c42 = this;
            }
            occ6537125c42.x.add(ocadfd5cc1572.\u0426.getEntityId());
        }
    }

    @oc66fa4f2195
    public void \u00d3(oc9d4393f3ce oc9d4393f3ce2) {
        block23: {
            Object object;
            Class<? extends Entity> clazz;
            C08PacketPlayerBlockPlacement c08PacketPlayerBlockPlacement;
            block29: {
                C08PacketPlayerBlockPlacement c08PacketPlayerBlockPlacement2;
                int n;
                block27: {
                    block28: {
                        block26: {
                            block25: {
                                block24: {
                                    oc9d4393f3ce oc9d4393f3ce3;
                                    block22: {
                                        n = ocfa11b18c57.\u0117;
                                        oc9d4393f3ce3 = oc9d4393f3ce2;
                                        if (n != 0) break block22;
                                        if (!(oc9d4393f3ce3.\u025f() instanceof C08PacketPlayerBlockPlacement)) break block23;
                                        oc9d4393f3ce3 = oc9d4393f3ce2;
                                    }
                                    c08PacketPlayerBlockPlacement = (C08PacketPlayerBlockPlacement)oc9d4393f3ce3.\u025f();
                                    c08PacketPlayerBlockPlacement2 = c08PacketPlayerBlockPlacement;
                                    if (n != 0) break block24;
                                    if (c08PacketPlayerBlockPlacement2.getPlacedBlockDirection() == (0x2C7955FB ^ 0x2C795504)) break block23;
                                    c08PacketPlayerBlockPlacement2 = c08PacketPlayerBlockPlacement;
                                }
                                if (n != 0) break block25;
                                if (c08PacketPlayerBlockPlacement2.getStack() == null) break block23;
                                c08PacketPlayerBlockPlacement2 = c08PacketPlayerBlockPlacement;
                            }
                            if (n != 0) break block26;
                            if (c08PacketPlayerBlockPlacement2.getStack().getItem() == null) break block23;
                            c08PacketPlayerBlockPlacement2 = c08PacketPlayerBlockPlacement;
                        }
                        if (n != 0) break block27;
                        if (c08PacketPlayerBlockPlacement2.getStack().getItem() instanceof ItemMonsterPlacer) break block28;
                        return;
                    }
                    c08PacketPlayerBlockPlacement2 = c08PacketPlayerBlockPlacement;
                }
                clazz = EntityList.getClassFromID(c08PacketPlayerBlockPlacement2.getStack().getMetadata());
                object = clazz;
                if (n != 0) break block23;
                if (object != null) break block29;
                return;
            }
            object = this.\u044a.put(clazz.getSimpleName(), new ocfa11b18c57(c08PacketPlayerBlockPlacement.getPosition(), oc69da1aa7f5.\u0151.thePlayer.ticksExisted));
        }
    }

    @oc66fa4f2195
    public void \u0504(oce21f48fe00 oce21f48fe002) {
        block27: {
            int n;
            int n2;
            block28: {
                oce21f48fe00 oce21f48fe003;
                block26: {
                    n2 = ocfa11b18c57.\u0117;
                    oce21f48fe003 = oce21f48fe002;
                    if (n2 != 0) break block26;
                    if (oce21f48fe003.\u01d3 == null) break block27;
                    oce21f48fe003 = oce21f48fe002;
                }
                n = oce21f48fe003.\u01d3.getItem() instanceof ItemEnderPearl;
                if (n2 != 0) break block28;
                if (n == 0) break block27;
                n = oc7ab2161b9f.\u042c();
            }
            if (n == (0xBFCFE150 ^ 0xBFCFE152)) {
                Object object;
                block33: {
                    List<String> list;
                    block32: {
                        ItemStack itemStack;
                        block31: {
                            String string;
                            String string2;
                            ItemStack itemStack2;
                            block29: {
                                block30: {
                                    itemStack2 = oce21f48fe002.\u01d3;
                                    string2 = oc7ab2161b9f.\u0211(itemStack2.getDisplayName());
                                    string = "Time Warp Pearl";
                                    if (n2 != 0) break block29;
                                    if (!string2.equals(string)) break block30;
                                    this.\u017e = true;
                                    if (n2 == 0) break block27;
                                }
                                itemStack = itemStack2;
                                if (n2 != 0) break block31;
                                string2 = itemStack.getDisplayName();
                                string = "\u00a7b\u00a7l";
                            }
                            if (!string2.startsWith(string)) break block27;
                            itemStack = itemStack2;
                        }
                        list = itemStack.getTooltip(oc69da1aa7f5.\u0151.thePlayer, true);
                        object = list;
                        if (n2 != 0) break block32;
                        if (object == null) break block27;
                        object = list;
                    }
                    if (n2 != 0) break block33;
                    if (object.size() <= 1) break block27;
                    object = list.get(1);
                }
                if (oc7ab2161b9f.\u0211((String)object).contains("Teleports you back to your")) {
                    this.\u017e = true;
                }
            }
        }
    }

    private void \u04ea() {
        this.\u04d4.clear();
        this.x.clear();
        this.\u044a.clear();
        this.\u042c.clear();
        this.\u017e = false;
    }

    public static boolean \u04a9() {
        int n;
        block16: {
            block13: {
                int n2;
                block15: {
                    occ6537125c4 occ6537125c42;
                    block14: {
                        block12: {
                            n2 = ocfa11b18c57.\u0117;
                            occ6537125c42 = oc9755810e45.\u0195;
                            if (n2 != 0) break block12;
                            if (occ6537125c42 == null) break block13;
                            occ6537125c42 = oc9755810e45.\u0195;
                        }
                        if (n2 != 0) break block14;
                        if (!occ6537125c42.z$3rzb3dil7uydr()) break block13;
                        occ6537125c42 = oc9755810e45.\u0195;
                    }
                    n = occ6537125c42.\u051c.\u01ed();
                    if (n2 != 0) break block15;
                    if (n == 0) break block13;
                    n = oc7ab2161b9f.\u042c();
                }
                if (n2 != 0) break block16;
                if (n != (0xBDF1CBA3 ^ 0xBDF1CBA1)) break block13;
                n = 1;
                break block16;
            }
            n = 0;
        }
        return n != 0;
    }

    public int \u0570() {
        int n;
        block20: {
            List<String> list;
            int n2;
            block17: {
                List<String> list2;
                block18: {
                    list2 = oc7ab2161b9f.\u0570();
                    n2 = ocfa11b18c57.\u0117;
                    list = list2;
                    if (n2 != 0) break block17;
                    if (!list.isEmpty()) break block18;
                    return -1;
                }
                list = list2;
            }
            for (String string : list) {
                block24: {
                    int n3;
                    block22: {
                        block23: {
                            String string2;
                            block19: {
                                block21: {
                                    string = oc7ab2161b9f.\u045b(string);
                                    string2 = string;
                                    if (n2 != 0) break block19;
                                    n = string2.startsWith("Teams left: ") ? 1 : 0;
                                    if (n2 != 0) break block20;
                                    if (n == 0) break block21;
                                    return 1;
                                }
                                string2 = string;
                            }
                            n3 = string2.startsWith("Lab: ");
                            if (n2 != 0) break block22;
                            if (n3 != 0) break block23;
                            n3 = string.startsWith("Mode: Mini") ? 1 : 0;
                            if (n2 != 0) break block22;
                            if (n3 == 0) break block24;
                        }
                        n3 = 0x5ACE7653 ^ 0x5ACE7651;
                    }
                    return n3;
                }
                if (n2 == 0) continue;
            }
            n = -1;
        }
        return n;
    }

    static {
        String[] stringArray = new String[0x57FA7F70 ^ 0x57FA7F77];
        stringArray[0] = " by ";
        stringArray[1] = " to ";
        stringArray[0x57FA7F75 ^ 0x57FA7F77] = " with ";
        stringArray[0x57FA7F74 ^ 0x57FA7F77] = " of ";
        stringArray[0x57FA7F73 ^ 0x57FA7F77] = " from ";
        stringArray[0x57FA7F72 ^ 0x57FA7F77] = " knight ";
        stringArray[0x57FA7F71 ^ 0x57FA7F77] = " for ";
        \u0250 = stringArray;
        \u0534 = false;
    }
}

