/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import x.oc161f4adba4;
import x.oc17aaf5d285;
import x.oc24b4725b15;
import x.oc5a7218f48b;
import x.oc66fa4f2195;
import x.oc746a23b244;
import x.oc7ab2161b9f;
import x.oc8ce2882092;
import x.oc9755810e45;
import x.oca4f99d2d44;
import x.ocaae9de8508;
import x.ocbab3c9954b;
import x.ocbd4917c4b1;
import x.ocda171fe5d8;
import x.ocea775c9d5c;

public class oc2d40324eb2
extends oc161f4adba4 {
    public final List<EntityPlayer> \u03b3;
    public static boolean \u01eb;

    public oc2d40324eb2() {
        String[] stringArray = new String[0xB30A3B5F ^ 0xB30A3B5D];
        stringArray[0] = "track <name>";
        stringArray[1] = "track clear";
        super("track", "Track players with an ESP marker.", oc17aaf5d285.\u01e5, stringArray, new String[0]);
        this.\u03b3 = new ArrayList<EntityPlayer>();
        ocea775c9d5c.\u0173.register(this);
    }

    @Override
    public void z$2uoow1halcq2f(ocaae9de8508 ocaae9de85082) {
        oc2d40324eb2 oc2d40324eb22;
        String string;
        block41: {
            EntityPlayer entityPlayer;
            block42: {
                EntityPlayer entityPlayer2;
                int n;
                block39: {
                    block40: {
                        block36: {
                            String string2;
                            int n2;
                            oc2d40324eb2 oc2d40324eb23;
                            block38: {
                                block37: {
                                    ocaae9de8508 ocaae9de85083;
                                    block34: {
                                        block35: {
                                            block30: {
                                                block31: {
                                                    oc2d40324eb2 oc2d40324eb24;
                                                    block32: {
                                                        block33: {
                                                            n = oc24b4725b15.\u0395;
                                                            ocaae9de85083 = ocaae9de85082;
                                                            if (n != 0) break block30;
                                                            if (ocaae9de85083.\u04fe() != 0) break block31;
                                                            oc2d40324eb24 = this;
                                                            if (n != 0) break block32;
                                                            if (!oc2d40324eb24.\u03b3.isEmpty()) break block33;
                                                            this.\u0247("&b0 &7players tracked.");
                                                            return;
                                                        }
                                                        oc2d40324eb24 = this;
                                                    }
                                                    int n3 = this.\u03b3.size();
                                                    String string3 = this.\u03b3.size() == 1 ? "" : "s";
                                                    oc2d40324eb24.\u0247("&7Tracking &b" + n3 + " &7player" + string3 + ".");
                                                    for (EntityPlayer entityPlayer3 : this.\u03b3) {
                                                        this.\u0247(" &b" + entityPlayer3.getName());
                                                        if (n == 0) continue;
                                                    }
                                                    return;
                                                }
                                                ocaae9de85083 = ocaae9de85082;
                                            }
                                            if (n != 0) break block34;
                                            if (ocaae9de85083.\u04fe() == 1) break block35;
                                            this.\u01fb();
                                            return;
                                        }
                                        ocaae9de85083 = ocaae9de85082;
                                    }
                                    string = ocaae9de85083.\u044c(0);
                                    if (!"clear".equalsIgnoreCase(string)) break block36;
                                    oc2d40324eb23 = this;
                                    n2 = this.\u03b3.size();
                                    if (this.\u03b3.size() != 1) break block37;
                                    string2 = "";
                                    break block38;
                                }
                                string2 = "s";
                            }
                            oc2d40324eb23.\u0247("&b" + n2 + " &7player" + string2 + " cleared.");
                            this.\u03b3.clear();
                            return;
                        }
                        entityPlayer = ocda171fe5d8.\u01d4.theWorld.getPlayerEntityByName(string);
                        entityPlayer2 = entityPlayer;
                        if (n != 0) break block39;
                        if (entityPlayer2 != ocda171fe5d8.\u01d4.thePlayer) break block40;
                        this.\u0247("&cYou cannot track yourself.");
                        return;
                    }
                    entityPlayer2 = entityPlayer;
                }
                if (entityPlayer2 == null) {
                    this.\u0247("&b" + string + " &7not found.");
                    return;
                }
                oc2d40324eb22 = this;
                if (n != 0) break block41;
                if (!oc2d40324eb22.\u03b3.contains(entityPlayer)) break block42;
                this.\u03b3.remove(entityPlayer);
                this.\u0247("&7Stopped tracking &b" + string);
                return;
            }
            this.\u03b3.add(entityPlayer);
            oc2d40324eb22 = this;
        }
        oc2d40324eb22.\u0247("&7Started tracking &b" + string);
    }

    @oc66fa4f2195
    public void \u0545(ocbab3c9954b ocbab3c9954b2) {
        this.\u03b3.clear();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @oc66fa4f2195(priority=oc8ce2882092.HIGHEST)
    public void \u03bf(oc746a23b244 oc746a23b2442) {
        int n;
        block26: {
            block25: {
                boolean bl;
                block24: {
                    n = oc24b4725b15.\u0395;
                    bl = oc7ab2161b9f.\u00d0();
                    if (n != 0) break block24;
                    if (!bl) break block25;
                    bl = this.\u03b3.isEmpty();
                }
                if (!bl) break block26;
            }
            return;
        }
        Iterator<EntityPlayer> iterator2 = new ArrayList<EntityPlayer>(this.\u03b3).iterator();
        while (iterator2.hasNext()) {
            block32: {
                EntityPlayer entityPlayer;
                block30: {
                    oc5a7218f48b oc5a7218f48b2;
                    block31: {
                        block29: {
                            block28: {
                                EntityPlayer entityPlayer2;
                                block27: {
                                    EntityPlayer entityPlayer3 = entityPlayer = iterator2.next();
                                    if (n == 0) {
                                        if (entityPlayer3 == null) continue;
                                        entityPlayer3 = entityPlayer;
                                    }
                                    if (n == 0) {
                                        if (entityPlayer3.isDead) continue;
                                        entityPlayer3 = entityPlayer;
                                    }
                                    if (entityPlayer3.deathTime != 0 && n == 0) continue;
                                    entityPlayer2 = ocda171fe5d8.\u01d4.thePlayer;
                                    if (n != 0) break block27;
                                    if (entityPlayer2 == entityPlayer) break block28;
                                    entityPlayer2 = entityPlayer;
                                }
                                if (oca4f99d2d44.\u039b(entityPlayer2) && n == 0) continue;
                            }
                            oc5a7218f48b2 = oc9755810e45.\u04f3;
                            if (n != 0) break block29;
                            if (oc5a7218f48b2 == null) break block30;
                            oc5a7218f48b2 = oc9755810e45.\u04f3;
                        }
                        if (n != 0) break block31;
                        if (!oc5a7218f48b2.z$3rzb3dil7uydr()) break block30;
                        oc5a7218f48b2 = oc9755810e45.\u04f3;
                    }
                    if (!oc5a7218f48b2.\u00ff()) break block32;
                }
                ocbd4917c4b1.\u01a8(entityPlayer, 0x80E94B05 ^ 0x80E94B07, 0.0, 0.0, Color.RED.getRGB(), false);
            }
            if (n == 0) continue;
        }
    }
}

