/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.awt.Color;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import x.oc66fa4f2195;
import x.oc69da1aa7f5;
import x.oc746a23b244;
import x.oc7ab2161b9f;
import x.oca9cc61aada;
import x.ocadfd5cc157;
import x.ocbd4917c4b1;
import x.occ2f8dff8d8;
import x.occb1ed1ed8f;
import x.oce4cea752dd;
import x.oce6044968f8;

public class oc8b850eaefc
extends oc69da1aa7f5 {
    private oca9cc61aada \u0100;
    private oca9cc61aada \u042c;
    private occ2f8dff8d8 \u03f3;
    private occ2f8dff8d8 \u03b9;
    private occ2f8dff8d8 \u03bc;
    private occ2f8dff8d8 \u011d;
    private occ2f8dff8d8 \u0551;
    private occ2f8dff8d8 \u046b;
    private occ2f8dff8d8 \u03aa;
    private occ2f8dff8d8 \u056b;
    private occ2f8dff8d8 \u021c;
    private final Set<BlockPos> i = ConcurrentHashMap.newKeySet();
    private long \u0212 = 0L;
    private boolean \u01af;
    private int \u04cf;
    private int \u01ff;
    private int \u0575;
    private int \u0268;
    private int \u02e2;
    private int \u04d5;
    private int \u0399;
    public static boolean \u0390;

    public oc8b850eaefc() {
        super("Xray", oce4cea752dd.\u014e);
        this.\u0105("Highlights ores.");
        this.\u0100 = new oca9cc61aada("Range", 20.0, 5.0, 50.0, 1.0);
        this.\u028c(this.\u0100);
        this.\u042c = new oca9cc61aada("Rate", " second", 0.5, 0.1, 3.0, 0.1);
        this.\u028c(this.\u042c);
        this.\u03aa = new occ2f8dff8d8("Coal", true);
        this.\u028c(this.\u03aa);
        this.\u03bc = new occ2f8dff8d8("Diamond", true);
        this.\u028c(this.\u03bc);
        this.\u011d = new occ2f8dff8d8("Emerald", true);
        this.\u028c(this.\u011d);
        this.\u03b9 = new occ2f8dff8d8("Gold", true);
        this.\u028c(this.\u03b9);
        this.\u03f3 = new occ2f8dff8d8("Iron", true);
        this.\u028c(this.\u03f3);
        this.\u0551 = new occ2f8dff8d8("Lapis", true);
        this.\u028c(this.\u0551);
        this.\u021c = new occ2f8dff8d8("Obsidian", true);
        this.\u028c(this.\u021c);
        this.\u046b = new occ2f8dff8d8("Redstone", true);
        this.\u028c(this.\u046b);
        this.\u056b = new occ2f8dff8d8("Spawner", true);
        this.\u028c(this.\u056b);
    }

    @Override
    public void onDisable() {
        this.i.clear();
        this.\u01af = false;
        this.\u0212 = 0L;
    }

    @Override
    public void z$1m9j3ewef9s() {
        boolean bl;
        block28: {
            int n;
            long l;
            block27: {
                bl = oce6044968f8.\u0452;
                if (!oc7ab2161b9f.\u00d0()) {
                    this.\u01af = false;
                    return;
                }
                l = System.currentTimeMillis();
                n = this.\u01af;
                if (bl) break block27;
                if (n != 0) break block28;
                double d = (double)(l - this.\u0212) - this.\u042c.\u04c1() * 1000.0;
                n = d == 0.0 ? 0 : (d < 0.0 ? -1 : 1);
            }
            if (n < 0) {
                return;
            }
            this.\u0212 = l;
            this.\u04cf = (int)this.\u0100.\u04c1();
            this.\u02e2 = (int)oc69da1aa7f5.\u0151.thePlayer.posX;
            this.\u04d5 = (int)oc69da1aa7f5.\u0151.thePlayer.posY;
            this.\u0399 = (int)oc69da1aa7f5.\u0151.thePlayer.posZ;
            this.\u01ff = -this.\u04cf;
            this.\u0575 = this.\u04cf;
            this.\u0268 = -this.\u04cf;
            this.\u01af = true;
        }
        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
        int n = 0x60A6BC40 ^ 0x60A6AC40;
        while (this.\u01af) {
            block30: {
                oc8b850eaefc oc8b850eaefc2;
                block32: {
                    block31: {
                        int n2;
                        block29: {
                            n2 = n--;
                            if (bl) break block29;
                            if (n2 <= 0) break;
                            n2 = this.\u04d5 + this.\u0575;
                        }
                        int n3 = n2;
                        if (bl) break block30;
                        if (n3 < 0) break block31;
                        mutableBlockPos.set(this.\u02e2 + this.\u01ff, n3, this.\u0399 + this.\u0268);
                        if (bl) break block30;
                        if (this.i.contains(mutableBlockPos)) break block31;
                        Block block = occb1ed1ed8f.\u03db(mutableBlockPos);
                        if (bl) break block30;
                        if (block == null) break block31;
                        oc8b850eaefc2 = this;
                        if (bl) break block32;
                        if (!oc8b850eaefc2.\u0258(block)) break block31;
                        this.i.add(new BlockPos(mutableBlockPos.getX(), mutableBlockPos.getY(), mutableBlockPos.getZ()));
                    }
                    oc8b850eaefc2 = this;
                }
                oc8b850eaefc2.\u0521();
            }
            if (!bl) continue;
        }
    }

    private void \u0521() {
        block17: {
            int n;
            block16: {
                oc8b850eaefc oc8b850eaefc2;
                int n2;
                block15: {
                    oc8b850eaefc oc8b850eaefc3;
                    oc8b850eaefc oc8b850eaefc4;
                    int n3;
                    boolean bl;
                    block13: {
                        block14: {
                            bl = oce6044968f8.\u0452;
                            n3 = this.\u0268 = this.\u0268 + 1;
                            oc8b850eaefc4 = this;
                            if (bl) break block13;
                            if (n3 > oc8b850eaefc4.\u04cf) break block14;
                            return;
                        }
                        this.\u0268 = -this.\u04cf;
                        oc8b850eaefc oc8b850eaefc5 = this;
                        oc8b850eaefc3 = oc8b850eaefc5;
                        n2 = oc8b850eaefc5.\u01ff + 1;
                        if (bl) break block15;
                        n3 = oc8b850eaefc3.\u01ff = n2;
                        oc8b850eaefc4 = this;
                    }
                    if (n3 <= oc8b850eaefc4.\u04cf) {
                        return;
                    }
                    oc8b850eaefc2 = this;
                    n = this.\u04cf;
                    if (bl) break block16;
                    oc8b850eaefc2.\u01ff = -n;
                    oc8b850eaefc oc8b850eaefc6 = this;
                    oc8b850eaefc3 = oc8b850eaefc6;
                    n2 = oc8b850eaefc6.\u0575 - 1;
                }
                oc8b850eaefc3.\u0575 = n2;
                if (n2 >= Math.max(-this.\u04cf, -this.\u04d5)) break block17;
                oc8b850eaefc2 = this;
                n = 0;
            }
            oc8b850eaefc2.\u01af = n;
        }
    }

    @oc66fa4f2195
    public void \u0519(ocadfd5cc157 ocadfd5cc1572) {
        if (ocadfd5cc1572.\u0426 == oc69da1aa7f5.\u0151.thePlayer) {
            this.i.clear();
            this.\u01af = false;
            this.\u0212 = 0L;
        }
    }

    @oc66fa4f2195
    public void \u0213(oc746a23b244 oc746a23b2442) {
        block21: {
            oc8b850eaefc oc8b850eaefc2;
            boolean bl;
            block16: {
                boolean bl2;
                block14: {
                    block15: {
                        bl = oce6044968f8.\u0452;
                        bl2 = oc7ab2161b9f.\u00d0();
                        if (bl) break block14;
                        if (bl2) break block15;
                        return;
                    }
                    oc8b850eaefc2 = this;
                    if (bl) break block16;
                    bl2 = oc8b850eaefc2.i.isEmpty();
                }
                if (bl2) break block21;
                oc8b850eaefc2 = this;
            }
            Iterator<BlockPos> iterator2 = oc8b850eaefc2.i.iterator();
            while (iterator2.hasNext()) {
                oc8b850eaefc oc8b850eaefc3;
                BlockPos blockPos;
                block19: {
                    block20: {
                        block17: {
                            block18: {
                                blockPos = iterator2.next();
                                Block block = occb1ed1ed8f.\u03db(blockPos);
                                if (bl) break block17;
                                if (block == null) break block18;
                                oc8b850eaefc3 = this;
                                if (bl) break block19;
                                if (oc8b850eaefc3.\u0258(block)) break block20;
                            }
                            iterator2.remove();
                        }
                        if (!bl) continue;
                    }
                    oc8b850eaefc3 = this;
                }
                oc8b850eaefc3.\u013f(blockPos);
                if (!bl) continue;
            }
        }
    }

    private void \u013f(BlockPos blockPos) {
        if (blockPos == null) {
            return;
        }
        int[] nArray = this.\u047d(occb1ed1ed8f.\u03db(blockPos));
        if (nArray[0] + nArray[1] + nArray[0xE84B0A84 ^ 0xE84B0A86] != 0) {
            ocbd4917c4b1.\u044c(blockPos, new Color(nArray[0], nArray[1], nArray[0xE84B0A84 ^ 0xE84B0A86]).getRGB(), false, true);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private int[] \u047d(Block block) {
        int n;
        int n2;
        int n3;
        int n4;
        block26: {
            block15: {
                Block block2;
                Block block3;
                boolean bl;
                block24: {
                    block25: {
                        block22: {
                            block23: {
                                block20: {
                                    block21: {
                                        block18: {
                                            block19: {
                                                Block block4;
                                                block16: {
                                                    block17: {
                                                        block13: {
                                                            block14: {
                                                                n4 = 0;
                                                                n3 = 0;
                                                                n2 = 0;
                                                                bl = oce6044968f8.\u0452;
                                                                block3 = block;
                                                                if (bl) break block13;
                                                                if (!block3.equals(Blocks.iron_ore)) break block14;
                                                                n4 = 0x6ECC1112 ^ 0x6ECC11ED;
                                                                n3 = 0x6ECC1112 ^ 0x6ECC11ED;
                                                                n2 = 0x6ECC1112 ^ 0x6ECC11ED;
                                                                if (!bl) break block15;
                                                            }
                                                            block3 = block;
                                                        }
                                                        block4 = Blocks.gold_ore;
                                                        if (bl) break block16;
                                                        if (!block3.equals(block4)) break block17;
                                                        n4 = 0x6ECC1112 ^ 0x6ECC11ED;
                                                        n3 = 0x6ECC1112 ^ 0x6ECC11ED;
                                                        if (!bl) break block15;
                                                    }
                                                    block3 = block;
                                                    if (bl) break block18;
                                                    block4 = Blocks.diamond_ore;
                                                }
                                                if (!block3.equals(block4)) break block19;
                                                n3 = 0x6ECC1131 ^ 0x6ECC11ED;
                                                n2 = 0x6ECC1112 ^ 0x6ECC11ED;
                                                if (!bl) break block15;
                                            }
                                            block3 = block;
                                        }
                                        if (bl) break block20;
                                        if (!block3.equals(Blocks.emerald_ore)) break block21;
                                        n4 = 0x6ECC11CE ^ 0x6ECC11ED;
                                        n3 = 0x6ECC1112 ^ 0x6ECC11ED;
                                        if (!bl) break block15;
                                    }
                                    block3 = block;
                                }
                                if (bl) break block22;
                                if (!block3.equals(Blocks.lapis_ore)) break block23;
                                n3 = 0x6ECC11DF ^ 0x6ECC11ED;
                                n2 = 0x6ECC1112 ^ 0x6ECC11ED;
                                if (!bl) break block15;
                            }
                            block3 = block;
                        }
                        block2 = Blocks.redstone_ore;
                        if (bl) break block24;
                        if (!block3.equals(block2)) break block25;
                        n4 = 0x6ECC1112 ^ 0x6ECC11ED;
                        if (!bl) break block15;
                    }
                    block3 = block;
                    block2 = Blocks.mob_spawner;
                }
                n = block3.equals(block2);
                if (bl) break block26;
                if (n != 0) {
                    n4 = 0x6ECC11F3 ^ 0x6ECC11ED;
                    n2 = 0x6ECC116A ^ 0x6ECC11ED;
                }
            }
            n = 0x6ECC11EE ^ 0x6ECC11ED;
        }
        int[] nArray = new int[n];
        nArray[0] = n4;
        nArray[1] = n3;
        nArray[0x6ECC11EF ^ 0x6ECC11ED] = n2;
        return nArray;
    }

    public boolean \u0258(Block block) {
        boolean bl;
        block62: {
            block79: {
                block63: {
                    boolean bl2;
                    block78: {
                        occ2f8dff8d8 occ2f8dff8d82;
                        block76: {
                            block77: {
                                block74: {
                                    block75: {
                                        oc8b850eaefc oc8b850eaefc2;
                                        block72: {
                                            block73: {
                                                occ2f8dff8d8 occ2f8dff8d83;
                                                block70: {
                                                    block71: {
                                                        block68: {
                                                            block69: {
                                                                oc8b850eaefc oc8b850eaefc3;
                                                                block66: {
                                                                    block67: {
                                                                        occ2f8dff8d8 occ2f8dff8d84;
                                                                        block64: {
                                                                            block65: {
                                                                                oc8b850eaefc oc8b850eaefc4;
                                                                                block60: {
                                                                                    block61: {
                                                                                        bl2 = oce6044968f8.\u0452;
                                                                                        oc8b850eaefc4 = this;
                                                                                        if (bl2) break block60;
                                                                                        if (!oc8b850eaefc4.\u03f3.\u01ed()) break block61;
                                                                                        bl = block.equals(Blocks.iron_ore);
                                                                                        if (bl2) break block62;
                                                                                        if (bl) break block63;
                                                                                    }
                                                                                    oc8b850eaefc4 = this;
                                                                                }
                                                                                occ2f8dff8d84 = oc8b850eaefc4.\u03b9;
                                                                                if (bl2) break block64;
                                                                                if (!occ2f8dff8d84.\u01ed()) break block65;
                                                                                bl = block.equals(Blocks.gold_ore);
                                                                                if (bl2) break block62;
                                                                                if (bl) break block63;
                                                                            }
                                                                            oc8b850eaefc3 = this;
                                                                            if (bl2) break block66;
                                                                            occ2f8dff8d84 = oc8b850eaefc3.\u03bc;
                                                                        }
                                                                        if (!occ2f8dff8d84.\u01ed()) break block67;
                                                                        bl = block.equals(Blocks.diamond_ore);
                                                                        if (bl2) break block62;
                                                                        if (bl) break block63;
                                                                    }
                                                                    oc8b850eaefc3 = this;
                                                                }
                                                                occ2f8dff8d83 = oc8b850eaefc3.\u011d;
                                                                if (bl2) break block68;
                                                                if (!occ2f8dff8d83.\u01ed()) break block69;
                                                                bl = block.equals(Blocks.emerald_ore);
                                                                if (bl2) break block62;
                                                                if (bl) break block63;
                                                            }
                                                            occ2f8dff8d83 = this.\u0551;
                                                            if (bl2) break block70;
                                                        }
                                                        if (!occ2f8dff8d83.\u01ed()) break block71;
                                                        bl = block.equals(Blocks.lapis_ore);
                                                        if (bl2) break block62;
                                                        if (bl) break block63;
                                                    }
                                                    oc8b850eaefc2 = this;
                                                    if (bl2) break block72;
                                                    occ2f8dff8d83 = oc8b850eaefc2.\u046b;
                                                }
                                                if (!occ2f8dff8d83.\u01ed()) break block73;
                                                bl = block.equals(Blocks.redstone_ore);
                                                if (bl2) break block62;
                                                if (bl) break block63;
                                            }
                                            oc8b850eaefc2 = this;
                                        }
                                        occ2f8dff8d82 = oc8b850eaefc2.\u03aa;
                                        if (bl2) break block74;
                                        if (!occ2f8dff8d82.\u01ed()) break block75;
                                        bl = block.equals(Blocks.coal_ore);
                                        if (bl2) break block62;
                                        if (bl) break block63;
                                    }
                                    occ2f8dff8d82 = this.\u056b;
                                    if (bl2) break block76;
                                }
                                if (!occ2f8dff8d82.\u01ed()) break block77;
                                bl = block.equals(Blocks.mob_spawner);
                                if (bl2) break block62;
                                if (bl) break block63;
                            }
                            occ2f8dff8d82 = this.\u021c;
                        }
                        bl = occ2f8dff8d82.\u01ed();
                        if (bl2) break block78;
                        if (!bl) break block79;
                        bl = block.equals(Blocks.obsidian);
                    }
                    if (bl2) break block62;
                    if (!bl) break block79;
                }
                bl = true;
                break block62;
            }
            bl = false;
        }
        return bl;
    }
}

