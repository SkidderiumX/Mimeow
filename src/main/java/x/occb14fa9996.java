/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityEnderChest;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import org.lwjgl.opengl.GL11;
import x.oc110d7f376c;
import x.oc24a0a5bddf;
import x.oc66fa4f2195;
import x.oc69da1aa7f5;
import x.oc746a23b244;
import x.oc7ab2161b9f;
import x.oc9755810e45;
import x.oc9adb807c19;
import x.oca9cc61aada;
import x.ocbd4917c4b1;
import x.occ2f8dff8d8;
import x.occc831eff22;
import x.oce4cea752dd;
import x.oce6044968f8;
import x.oce9af919ff5;
import x.ocff2534ad6d;

public class occb14fa9996
extends oc69da1aa7f5 {
    private static final int \u046d = 1;
    private static final oce9af919ff5[] \u01ac;
    private static final ThreadLocal<Boolean> e;
    private final EnumMap<oce9af919ff5, ocff2534ad6d> \u0450 = new EnumMap(oce9af919ff5.class);
    private final EnumMap<oce9af919ff5, List<BlockPos>> \u0390 = new EnumMap(oce9af919ff5.class);
    private final oca9cc61aada \u01ea;
    public static int \u02e2;

    public occb14fa9996() {
        super("ChestESP", oce4cea752dd.\u014e, 0);
        this.\u0105("Highlights nearby chests through walls.");
        this.\u0450.put(oce9af919ff5.\u022c, this.\u018a("Chest", 0x966311D8 ^ 0x9663111E, 0x9663119A ^ 0x9663111E, 0x96631126 ^ 0x9663111E));
        this.\u0450.put(oce9af919ff5.\u014a, this.\u018a("Trapped chest", 0x966311AE ^ 0x9663111E, 0x9663115E ^ 0x9663111E, 0x9663115E ^ 0x9663111E));
        this.\u0450.put(oce9af919ff5.\u04c3, this.\u018a("Ender chest", 0x9663119E ^ 0x9663111E, 0x9663115E ^ 0x9663111E, 0x966311DE ^ 0x9663111E));
        this.\u01ea = new oca9cc61aada("Max distance", 128.0, 32.0, 256.0, 8.0);
        this.\u028c(this.\u01ea);
    }

    @Override
    public void z$2u87utkr1isxg() {
        oce9af919ff5[] oce9af919ff5Array = \u01ac;
        int n = oce9af919ff5Array.length;
        boolean bl = oce6044968f8.\u0452;
        for (int i = 0; i < n; ++i) {
            oce9af919ff5 oce9af919ff52 = oce9af919ff5Array[i];
            this.\u053a(oce9af919ff52).\u04b6(this);
            if (!bl) continue;
        }
    }

    public static void \u0208(TileEntity tileEntity) {
        int n;
        block6: {
            block7: {
                block5: {
                    occb14fa9996 occb14fa99962;
                    boolean bl;
                    block4: {
                        occb14fa9996 occb14fa99963 = occb14fa9996.\u0583();
                        bl = oce6044968f8.\u0452;
                        occb14fa99962 = occb14fa99963;
                        if (bl) break block4;
                        if (occb14fa99962 == null) break block5;
                        occb14fa99962 = occb14fa99963;
                    }
                    n = occb14fa99962.\u02c0(tileEntity);
                    if (bl) break block6;
                    if (n != 0) break block7;
                }
                return;
            }
            n = 0xD45119FD ^ 0xD45199CA;
        }
        GL11.glEnable(n);
        GL11.glPolygonOffset(1.0f, -1100000.0f);
        e.set(true);
    }

    public static void \u03f5() {
        int n;
        block2: {
            block3: {
                boolean bl = oce6044968f8.\u0452;
                n = Boolean.TRUE.equals(e.get());
                if (bl) break block2;
                if (n != 0) break block3;
                return;
            }
            e.set(false);
            GL11.glPolygonOffset(1.0f, 1100000.0f);
            n = 0x838658AD ^ 0x8386D89A;
        }
        GL11.glDisable(n);
    }

    private static occb14fa9996 \u0583() {
        occb14fa9996 occb14fa99962;
        block11: {
            block9: {
                oc69da1aa7f5 oc69da1aa7f52;
                block10: {
                    boolean bl;
                    oc69da1aa7f5 oc69da1aa7f53;
                    block8: {
                        oc69da1aa7f53 = oc9755810e45.\u02ac(occb14fa9996.class);
                        bl = oce6044968f8.\u0452;
                        oc69da1aa7f52 = oc69da1aa7f53;
                        if (bl) break block8;
                        if (!(oc69da1aa7f52 instanceof occb14fa9996)) break block9;
                        oc69da1aa7f52 = oc69da1aa7f53;
                    }
                    if (bl) break block10;
                    if (!oc69da1aa7f52.z$3rzb3dil7uydr()) break block9;
                    oc69da1aa7f52 = oc69da1aa7f53;
                }
                occb14fa99962 = (occb14fa9996)oc69da1aa7f52;
                break block11;
            }
            occb14fa99962 = null;
        }
        return occb14fa99962;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean \u02c0(TileEntity tileEntity) {
        occb14fa9996 occb14fa99962;
        boolean bl;
        ocff2534ad6d ocff2534ad6d2;
        block12: {
            boolean bl2;
            block11: {
                ocff2534ad6d ocff2534ad6d3;
                block10: {
                    ocff2534ad6d2 = this.\u053a(this.\u02b5(tileEntity));
                    bl = oce6044968f8.\u0452;
                    ocff2534ad6d3 = ocff2534ad6d2;
                    if (bl) break block10;
                    if (ocff2534ad6d3 == null) return false;
                    ocff2534ad6d3 = ocff2534ad6d2;
                }
                bl2 = ocff2534ad6d3.\u0166();
                if (bl) break block11;
                if (!bl2) return false;
                occb14fa99962 = this;
                if (bl) break block12;
                bl2 = occb14fa99962.\u038e(tileEntity);
            }
            if (!bl2) return false;
            occb14fa99962 = this;
        }
        boolean bl3 = occb14fa99962.\u022c(ocff2534ad6d2, tileEntity);
        if (bl) return bl3;
        if (bl3) return false;
        return true;
    }

    private oce9af919ff5 \u02b5(TileEntity tileEntity) {
        block13: {
            TileEntity tileEntity2;
            block12: {
                boolean bl;
                block10: {
                    block11: {
                        bl = oce6044968f8.\u0452;
                        tileEntity2 = tileEntity;
                        if (bl) break block10;
                        if (!(tileEntity2 instanceof TileEntityEnderChest)) break block11;
                        return oce9af919ff5.\u04c3;
                    }
                    tileEntity2 = tileEntity;
                }
                if (bl) break block12;
                if (!(tileEntity2 instanceof TileEntityChest)) break block13;
                tileEntity2 = tileEntity;
            }
            oce9af919ff5 oce9af919ff52 = ((TileEntityChest)tileEntity2).getChestType() == 1 ? oce9af919ff5.\u014a : oce9af919ff5.\u022c;
            return oce9af919ff52;
        }
        return oce9af919ff5.h;
    }

    private ocff2534ad6d \u018a(String string, int n, int n2, int n3) {
        occc831eff22 occc831eff222 = new occc831eff22(string);
        this.\u028c(occc831eff222);
        occ2f8dff8d8 occ2f8dff8d82 = new occ2f8dff8d8(occc831eff222, "Outline", false);
        this.\u028c(occ2f8dff8d82);
        oc24a0a5bddf oc24a0a5bddf2 = new oc24a0a5bddf(occc831eff222, "Outline color", n, n2, n3, 0x2F13F255 ^ 0x2F13F2AA);
        this.\u028c(oc24a0a5bddf2);
        occ2f8dff8d8 occ2f8dff8d83 = new occ2f8dff8d8(occc831eff222, "Shade", false);
        this.\u028c(occ2f8dff8d83);
        oc24a0a5bddf oc24a0a5bddf3 = new oc24a0a5bddf(occc831eff222, "Shade color", n, n2, n3, 0x2F13F255 ^ 0x2F13F2AA);
        this.\u028c(oc24a0a5bddf3);
        occ2f8dff8d8 occ2f8dff8d84 = new occ2f8dff8d8(occc831eff222, "Chams", false);
        this.\u028c(occ2f8dff8d84);
        occ2f8dff8d8 occ2f8dff8d85 = new occ2f8dff8d8(occc831eff222, "Disable if opened", false);
        this.\u028c(occ2f8dff8d85);
        return new ocff2534ad6d(occ2f8dff8d82, oc24a0a5bddf2, occ2f8dff8d83, oc24a0a5bddf3, occ2f8dff8d84, occ2f8dff8d85);
    }

    private ocff2534ad6d \u053a(oce9af919ff5 oce9af919ff52) {
        return this.\u0450.get((Object)oce9af919ff52);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean \u022c(ocff2534ad6d ocff2534ad6d2, TileEntity tileEntity) {
        TileEntity tileEntity2;
        boolean bl;
        block24: {
            block21: {
                block22: {
                    float f;
                    block23: {
                        boolean bl2;
                        block19: {
                            block20: {
                                ocff2534ad6d ocff2534ad6d3;
                                block18: {
                                    bl = oce6044968f8.\u0452;
                                    ocff2534ad6d3 = ocff2534ad6d2;
                                    if (bl) break block18;
                                    if (ocff2534ad6d3 == null) return false;
                                    ocff2534ad6d3 = ocff2534ad6d2;
                                }
                                bl2 = ocff2534ad6d3.\u02b7();
                                if (bl) break block19;
                                if (bl2) break block20;
                                return false;
                            }
                            tileEntity2 = tileEntity;
                            if (bl) break block21;
                            bl2 = tileEntity2 instanceof TileEntityChest;
                        }
                        if (!bl2) break block22;
                        float f2 = ((TileEntityChest)tileEntity).lidAngle - 0.0f;
                        f = f2 == 0.0f ? 0 : (f2 > 0.0f ? 1 : -1);
                        if (bl) return (boolean)f;
                        if (f <= 0) break block23;
                        f = 1.0f;
                        return (boolean)f;
                    }
                    f = 0.0f;
                    return (boolean)f;
                }
                tileEntity2 = tileEntity;
            }
            if (bl) break block24;
            if (!(tileEntity2 instanceof TileEntityEnderChest)) return 0 != 0;
            tileEntity2 = tileEntity;
        }
        float f = ((TileEntityEnderChest)tileEntity2).lidAngle - 0.0f;
        int n = f == 0.0f ? 0 : (f > 0.0f ? 1 : -1);
        if (bl) return n != 0;
        if (n <= 0) return 0 != 0;
        return 1 != 0;
    }

    private boolean \u011e() {
        boolean bl;
        block8: {
            oce9af919ff5[] oce9af919ff5Array = \u01ac;
            int n = oce9af919ff5Array.length;
            boolean bl2 = oce6044968f8.\u0452;
            int n2 = 0;
            while (n2 < n) {
                block7: {
                    block9: {
                        oce9af919ff5 oce9af919ff52 = oce9af919ff5Array[n2];
                        if (bl2) break block7;
                        bl = this.\u053a(oce9af919ff52).\u049b();
                        if (bl2) break block8;
                        if (!bl) break block9;
                        return true;
                    }
                    ++n2;
                }
                if (!bl2) continue;
            }
            bl = false;
        }
        return bl;
    }

    private boolean \u038e(TileEntity tileEntity) {
        double d = this.\u01ea.\u04c1() * this.\u01ea.\u04c1();
        return ocbd4917c4b1.\u04f9(tileEntity.getPos(), d);
    }

    private AxisAlignedBB \u0291(BlockPos blockPos) {
        return new AxisAlignedBB(blockPos.getX(), blockPos.getY(), blockPos.getZ(), blockPos.getX() + 1, blockPos.getY() + 1, blockPos.getZ() + 1);
    }

    @oc66fa4f2195
    public void \u045f(oc9adb807c19 oc9adb807c192) {
        if (oc9adb807c192.\u04b0 != oc110d7f376c.END) {
            return;
        }
        this.\u012c();
    }

    @oc66fa4f2195
    public void \u0395(oc746a23b244 oc746a23b2442) {
        boolean bl;
        block37: {
            block30: {
                boolean bl2;
                block29: {
                    bl = oce6044968f8.\u0452;
                    bl2 = oc7ab2161b9f.\u00d0();
                    if (bl) break block29;
                    if (!bl2) break block30;
                    bl2 = this.\u0390.isEmpty();
                }
                if (!bl2) break block37;
            }
            return;
        }
        oce9af919ff5[] oce9af919ff5Array = \u01ac;
        int n = oce9af919ff5Array.length;
        int n2 = 0;
        while (n2 < n) {
            List<BlockPos> list;
            oce9af919ff5 oce9af919ff52 = oce9af919ff5Array[n2];
            List<BlockPos> list2 = list = this.\u0390.get((Object)oce9af919ff52);
            block25: while (!bl) {
                block31: {
                    ArrayList<BlockPos> arrayList;
                    ocff2534ad6d ocff2534ad6d2;
                    block35: {
                        ArrayList<BlockPos> arrayList2;
                        block36: {
                            block33: {
                                block32: {
                                    if (list == null) break block31;
                                    if (!list.isEmpty()) break block32;
                                    if (!bl) break block31;
                                }
                                ocff2534ad6d2 = this.\u053a(oce9af919ff52);
                                if (bl) break;
                                if (ocff2534ad6d2 == null) break block31;
                                if (ocff2534ad6d2.\u049b()) break block33;
                                if (!bl) break block31;
                            }
                            arrayList2 = new ArrayList<BlockPos>();
                            Iterator<BlockPos> iterator2 = list.iterator();
                            while (iterator2.hasNext()) {
                                block34: {
                                    list2 = iterator2;
                                    if (bl) continue block25;
                                    BlockPos blockPos = (BlockPos)list2.next();
                                    boolean bl3 = ocbd4917c4b1.\u04e5(this.\u0291(blockPos));
                                    if (bl || !bl3) break block34;
                                    bl3 = arrayList2.add(blockPos);
                                }
                                if (!bl) continue;
                            }
                            arrayList = arrayList2;
                            if (bl) break block35;
                            if (!arrayList.isEmpty()) break block36;
                            if (!bl) break block31;
                        }
                        arrayList = arrayList2;
                    }
                    ocbd4917c4b1.\u01bc(arrayList, ocff2534ad6d2.\u027b(), ocff2534ad6d2.l(), ocff2534ad6d2.\u0176(), ocff2534ad6d2.\u03e6());
                }
                ++n2;
                break;
            }
            if (!bl) continue;
        }
    }

    private void \u012c() {
        List<BlockPos> list;
        Object object;
        occb14fa9996 occb14fa99962;
        boolean bl;
        block31: {
            block32: {
                block30: {
                    this.\u0390.clear();
                    bl = oce6044968f8.\u0452;
                    if (!oc7ab2161b9f.\u00d0() || oc69da1aa7f5.\u0151.theWorld == null) break block30;
                    occb14fa99962 = this;
                    if (bl) break block31;
                    if (occb14fa99962.\u011e()) break block32;
                }
                return;
            }
            occb14fa99962 = this;
        }
        double d = occb14fa99962.\u01ea.\u04c1() * this.\u01ea.\u04c1();
        oce9af919ff5[] oce9af919ff5Array = \u01ac;
        int n = oce9af919ff5Array.length;
        int n2 = 0;
        while (n2 < n) {
            block33: {
                block34: {
                    object = oce9af919ff5Array[n2];
                    list = this.\u053a((oce9af919ff5)((Object)object));
                    if (bl) break block33;
                    if (list == null) break block34;
                    Object object2 = list;
                    if (bl) break block34;
                    if (!((ocff2534ad6d)object2).\u049b()) break block34;
                    object2 = this.\u0390.put((oce9af919ff5)((Object)object), new ArrayList());
                }
                ++n2;
            }
            if (!bl) continue;
        }
        for (TileEntity tileEntity : oc69da1aa7f5.\u0151.theWorld.loadedTileEntityList) {
            block40: {
                List list2;
                block39: {
                    List<BlockPos> list3;
                    block37: {
                        oce9af919ff5 oce9af919ff52;
                        block38: {
                            boolean bl2;
                            block36: {
                                Object object3;
                                block35: {
                                    oce9af919ff52 = this.\u02b5(tileEntity);
                                    object = this.\u053a(oce9af919ff52);
                                    object3 = object;
                                    if (bl) break block35;
                                    if (object3 == null) continue;
                                    object3 = object;
                                }
                                bl2 = ((ocff2534ad6d)object3).\u049b();
                                if (bl) break block36;
                                if (!bl2) continue;
                                bl2 = this.\u022c((ocff2534ad6d)object, tileEntity);
                            }
                            if (bl2 && !bl) continue;
                            list = tileEntity.getPos();
                            list3 = list;
                            if (bl) break block37;
                            if (ocbd4917c4b1.\u04f9((BlockPos)((Object)list3), d)) break block38;
                            if (!bl) continue;
                        }
                        list3 = this.\u0390.get((Object)oce9af919ff52);
                    }
                    List list4 = list3;
                    list2 = list4;
                    if (bl) break block39;
                    if (list2 == null) break block40;
                    list2 = list4;
                }
                list2.add(list);
            }
            if (!bl) continue;
        }
    }

    static {
        oce9af919ff5[] oce9af919ff5Array = new oce9af919ff5[0x7878B80E ^ 0x7878B80D];
        oce9af919ff5Array[0] = oce9af919ff5.\u022c;
        oce9af919ff5Array[1] = oce9af919ff5.\u014a;
        oce9af919ff5Array[0x7878B80F ^ 0x7878B80D] = oce9af919ff5.\u04c3;
        \u01ac = oce9af919ff5Array;
        e = ThreadLocal.withInitial(() -> false);
    }
}

