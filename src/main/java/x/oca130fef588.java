/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.HashSet;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;
import x.oc66fa4f2195;
import x.oc69da1aa7f5;
import x.oc7ab2161b9f;
import x.oca4f99d2d44;
import x.ocbc0df1f744;
import x.occ2f8dff8d8;
import x.occc831eff22;
import x.ocd056cee4b3;
import x.oce4cea752dd;
import x.oce6044968f8;

public class oca130fef588
extends oc69da1aa7f5 {
    private final occc831eff22 \u01d1 = new occc831eff22("Targets");
    private occ2f8dff8d8 \u017d;
    private occ2f8dff8d8 \u028b;
    private occ2f8dff8d8 \u04c1;
    private occ2f8dff8d8 \u0520;
    private HashSet<Entity> \u0265 = new HashSet();
    public static boolean \u025f;

    public oca130fef588() {
        super("Chams", oce4cea752dd.\u014e, 0);
        this.\u0105("Changes player rendering to show them through walls.");
        this.\u028c(this.\u01d1);
        this.\u017d = new occ2f8dff8d8(this.\u01d1, "Ignore bots", false);
        this.\u028c(this.\u017d);
        this.\u028b = new occ2f8dff8d8(this.\u01d1, "Render self", false);
        this.\u028c(this.\u028b);
        this.\u0520 = new occ2f8dff8d8(this.\u01d1, "Show Teammate", true);
        this.\u028c(this.\u0520);
        this.\u04c1 = new occ2f8dff8d8("Hide players", false);
        this.\u028c(this.\u04c1);
    }

    @oc66fa4f2195
    public void \u0432(ocbc0df1f744 ocbc0df1f7442) {
        int n;
        block41: {
            block42: {
                boolean bl;
                AbstractClientPlayer abstractClientPlayer;
                block43: {
                    occ2f8dff8d8 occ2f8dff8d82;
                    boolean bl2;
                    block38: {
                        block39: {
                            block40: {
                                boolean bl3;
                                block37: {
                                    block36: {
                                        block35: {
                                            AbstractClientPlayer abstractClientPlayer2;
                                            block32: {
                                                block33: {
                                                    block34: {
                                                        abstractClientPlayer = ocbc0df1f7442.\u04c5;
                                                        bl2 = oce6044968f8.\u0452;
                                                        abstractClientPlayer2 = abstractClientPlayer;
                                                        if (bl2) break block32;
                                                        if (abstractClientPlayer2 != oc69da1aa7f5.\u0151.thePlayer) break block33;
                                                        if (!this.\u028b.\u01ed()) break block34;
                                                        if (oc69da1aa7f5.\u0151.currentScreen == null) break block33;
                                                    }
                                                    return;
                                                }
                                                abstractClientPlayer2 = abstractClientPlayer;
                                            }
                                            if (abstractClientPlayer2 == oc69da1aa7f5.\u0151.thePlayer) break block35;
                                            occ2f8dff8d82 = this.\u0520;
                                            if (bl2) break block36;
                                            if (occ2f8dff8d82.\u01ed()) break block35;
                                            bl3 = oc7ab2161b9f.\u04e5(abstractClientPlayer);
                                            if (bl2) break block37;
                                            if (!bl3) break block35;
                                            return;
                                        }
                                        occ2f8dff8d82 = this.\u04c1;
                                    }
                                    if (bl2) break block38;
                                    bl3 = occ2f8dff8d82.\u01ed();
                                }
                                if (!bl3) break block39;
                                if (abstractClientPlayer != oc69da1aa7f5.\u0151.thePlayer) break block40;
                                occ2f8dff8d82 = this.\u028b;
                                if (bl2) break block38;
                                if (occ2f8dff8d82.\u01ed()) break block39;
                            }
                            ocbc0df1f7442.setCanceled(true);
                            return;
                        }
                        occ2f8dff8d82 = this.\u017d;
                    }
                    n = occ2f8dff8d82.\u01ed();
                    if (bl2) break block41;
                    if (n == 0) break block42;
                    bl = oca4f99d2d44.\u039b(abstractClientPlayer);
                    if (bl2) break block42;
                    if (!bl) break block43;
                    return;
                }
                bl = this.\u0265.add(abstractClientPlayer);
            }
            n = 0x4C05073F ^ 0x4C058708;
        }
        GL11.glEnable(n);
        GL11.glPolygonOffset(1.0f, -4000000.0f);
    }

    @oc66fa4f2195
    public void \u0474(ocd056cee4b3 ocd056cee4b32) {
        int n;
        block43: {
            block44: {
                AbstractClientPlayer abstractClientPlayer;
                HashSet<Entity> hashSet;
                block45: {
                    AbstractClientPlayer abstractClientPlayer2;
                    block46: {
                        oca130fef588 oca130fef5882;
                        boolean bl;
                        block40: {
                            block41: {
                                block42: {
                                    boolean bl2;
                                    block39: {
                                        occ2f8dff8d8 occ2f8dff8d82;
                                        block38: {
                                            block37: {
                                                AbstractClientPlayer abstractClientPlayer3;
                                                block34: {
                                                    block35: {
                                                        block36: {
                                                            abstractClientPlayer2 = ocd056cee4b32.\u04c5;
                                                            bl = oce6044968f8.\u0452;
                                                            abstractClientPlayer3 = abstractClientPlayer2;
                                                            if (bl) break block34;
                                                            if (abstractClientPlayer3 != oc69da1aa7f5.\u0151.thePlayer) break block35;
                                                            if (!this.\u028b.\u01ed()) break block36;
                                                            if (oc69da1aa7f5.\u0151.currentScreen == null) break block35;
                                                        }
                                                        return;
                                                    }
                                                    abstractClientPlayer3 = abstractClientPlayer2;
                                                }
                                                if (abstractClientPlayer3 == oc69da1aa7f5.\u0151.thePlayer) break block37;
                                                occ2f8dff8d82 = this.\u0520;
                                                if (bl) break block38;
                                                if (occ2f8dff8d82.\u01ed()) break block37;
                                                bl2 = oc7ab2161b9f.\u04e5(abstractClientPlayer2);
                                                if (bl) break block39;
                                                if (!bl2) break block37;
                                                return;
                                            }
                                            oca130fef5882 = this;
                                            if (bl) break block40;
                                            occ2f8dff8d82 = oca130fef5882.\u04c1;
                                        }
                                        bl2 = occ2f8dff8d82.\u01ed();
                                    }
                                    if (!bl2) break block41;
                                    if (abstractClientPlayer2 != oc69da1aa7f5.\u0151.thePlayer) break block42;
                                    oca130fef5882 = this;
                                    if (bl) break block40;
                                    if (oca130fef5882.\u028b.\u01ed()) break block41;
                                }
                                return;
                            }
                            oca130fef5882 = this;
                        }
                        n = oca130fef5882.\u017d.\u01ed();
                        if (bl) break block43;
                        if (n == 0) break block44;
                        hashSet = this.\u0265;
                        abstractClientPlayer = abstractClientPlayer2;
                        if (bl) break block45;
                        if (hashSet.contains(abstractClientPlayer)) break block46;
                        return;
                    }
                    hashSet = this.\u0265;
                    abstractClientPlayer = abstractClientPlayer2;
                }
                hashSet.remove(abstractClientPlayer);
            }
            n = 0x40086AEC ^ 0x4008EADB;
        }
        GL11.glDisable(n);
        GL11.glPolygonOffset(1.0f, 4000000.0f);
    }

    @Override
    public void onDisable() {
        this.\u0265.clear();
    }
}

