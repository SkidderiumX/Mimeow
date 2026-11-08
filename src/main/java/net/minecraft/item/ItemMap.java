/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.item;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multisets;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockStone;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemMapBase;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.storage.MapData;

public class ItemMap
extends ItemMapBase {
    protected ItemMap() {
        this.setHasSubtypes(true);
    }

    public static MapData loadMapData(int n, World world2) {
        String string = "map_" + n;
        MapData mapData = (MapData)world2.loadItemData(MapData.class, string);
        if (mapData == null) {
            mapData = new MapData(string);
            world2.setItemData(string, mapData);
        }
        return mapData;
    }

    public MapData getMapData(ItemStack itemStack, World world2) {
        String string = "map_" + itemStack.getMetadata();
        MapData mapData = (MapData)world2.loadItemData(MapData.class, string);
        if (mapData == null && !world2.isRemote) {
            itemStack.setItemDamage(world2.getUniqueDataId("map"));
            string = "map_" + itemStack.getMetadata();
            mapData = new MapData(string);
            mapData.scale = (byte)3;
            mapData.calculateMapCenter(world2.getWorldInfo().getSpawnX(), world2.getWorldInfo().getSpawnZ(), mapData.scale);
            mapData.dimension = (byte)world2.provider.getDimensionId();
            mapData.markDirty();
            world2.setItemData(string, mapData);
        }
        return mapData;
    }

    public void updateMapData(World world2, Entity entity, MapData mapData) {
        if (world2.provider.getDimensionId() == mapData.dimension && entity instanceof EntityPlayer) {
            int n = 1 << mapData.scale;
            int n2 = mapData.xCenter;
            int n3 = mapData.zCenter;
            int n4 = MathHelper.floor_double(entity.posX - (double)n2) / n + 64;
            int n5 = MathHelper.floor_double(entity.posZ - (double)n3) / n + 64;
            int n6 = 128 / n;
            if (world2.provider.getHasNoSky()) {
                n6 /= 2;
            }
            MapData.MapInfo mapInfo = mapData.getMapInfo((EntityPlayer)entity);
            ++mapInfo.field_82569_d;
            boolean bl = false;
            for (int i = n4 - n6 + 1; i < n4 + n6; ++i) {
                if ((i & 0xF) != (mapInfo.field_82569_d & 0xF) && !bl) continue;
                bl = false;
                double d = 0.0;
                for (int j = n5 - n6 - 1; j < n5 + n6; ++j) {
                    byte by;
                    MapColor mapColor;
                    int n7;
                    int n8;
                    if (i < 0 || j < -1 || i >= 128 || j >= 128) continue;
                    int n9 = i - n4;
                    int n10 = j - n5;
                    boolean bl2 = n9 * n9 + n10 * n10 > (n6 - 2) * (n6 - 2);
                    int n11 = (n2 / n + i - 64) * n;
                    int n12 = (n3 / n + j - 64) * n;
                    HashMultiset<MapColor> hashMultiset = HashMultiset.create();
                    Chunk chunk = world2.getChunkFromBlockCoords(new BlockPos(n11, 0, n12));
                    if (chunk.isEmpty()) continue;
                    int n13 = n11 & 0xF;
                    int n14 = n12 & 0xF;
                    int n15 = 0;
                    double d2 = 0.0;
                    if (world2.provider.getHasNoSky()) {
                        int n16 = n11 + n12 * 231871;
                        if (((n16 = n16 * n16 * 31287121 + n16 * 11) >> 20 & 1) == 0) {
                            hashMultiset.add(Blocks.dirt.getMapColor(Blocks.dirt.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.DIRT)), 10);
                        } else {
                            hashMultiset.add(Blocks.stone.getMapColor(Blocks.stone.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.STONE)), 100);
                        }
                        d2 = 100.0;
                    } else {
                        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
                        for (int k = 0; k < n; ++k) {
                            for (n8 = 0; n8 < n; ++n8) {
                                int n17 = chunk.getHeightValue(k + n13, n8 + n14) + 1;
                                IBlockState iBlockState = Blocks.air.getDefaultState();
                                if (n17 > 1) {
                                    while ((iBlockState = chunk.getBlockState(mutableBlockPos.set(k + n13, --n17, n8 + n14))).getBlock().getMapColor(iBlockState) == MapColor.airColor && n17 > 0) {
                                    }
                                    if (n17 > 0 && iBlockState.getBlock().getMaterial().isLiquid()) {
                                        Block block;
                                        n7 = n17 - 1;
                                        do {
                                            block = chunk.getBlock(k + n13, n7--, n8 + n14);
                                            ++n15;
                                        } while (n7 > 0 && block.getMaterial().isLiquid());
                                    }
                                }
                                d2 += (double)n17 / (double)(n * n);
                                hashMultiset.add(iBlockState.getBlock().getMapColor(iBlockState));
                            }
                        }
                    }
                    n15 /= n * n;
                    double d3 = (d2 - d) * 4.0 / (double)(n + 4) + ((double)(i + j & 1) - 0.5) * 0.4;
                    n8 = 1;
                    if (d3 > 0.6) {
                        n8 = 2;
                    }
                    if (d3 < -0.6) {
                        n8 = 0;
                    }
                    if ((mapColor = Iterables.getFirst(Multisets.copyHighestCountFirst(hashMultiset), MapColor.airColor)) == MapColor.waterColor) {
                        d3 = (double)n15 * 0.1 + (double)(i + j & 1) * 0.2;
                        n8 = 1;
                        if (d3 < 0.5) {
                            n8 = 2;
                        }
                        if (d3 > 0.9) {
                            n8 = 0;
                        }
                    }
                    d = d2;
                    if (j < 0 || n9 * n9 + n10 * n10 >= n6 * n6 || bl2 && (i + j & 1) == 0 || (by = mapData.colors[i + j * 128]) == (n7 = (int)((byte)(mapColor.colorIndex * 4 + n8)))) continue;
                    mapData.colors[i + j * 128] = n7;
                    mapData.updateMapData(i, j);
                    bl = true;
                }
            }
        }
    }

    @Override
    public void onUpdate(ItemStack itemStack, World world2, Entity entity, int n, boolean bl) {
        if (!world2.isRemote) {
            MapData mapData = this.getMapData(itemStack, world2);
            if (entity instanceof EntityPlayer) {
                EntityPlayer entityPlayer = (EntityPlayer)entity;
                mapData.updateVisiblePlayers(entityPlayer, itemStack);
            }
            if (bl) {
                this.updateMapData(world2, entity, mapData);
            }
        }
    }

    @Override
    public Packet createMapDataPacket(ItemStack itemStack, World world2, EntityPlayer entityPlayer) {
        return this.getMapData(itemStack, world2).getMapPacket(itemStack, world2, entityPlayer);
    }

    @Override
    public void onCreated(ItemStack itemStack, World world2, EntityPlayer entityPlayer) {
        if (itemStack.hasTagCompound() && itemStack.getTagCompound().getBoolean("map_is_scaling")) {
            MapData mapData = Items.filled_map.getMapData(itemStack, world2);
            itemStack.setItemDamage(world2.getUniqueDataId("map"));
            MapData mapData2 = new MapData("map_" + itemStack.getMetadata());
            mapData2.scale = (byte)(mapData.scale + 1);
            if (mapData2.scale > 4) {
                mapData2.scale = (byte)4;
            }
            mapData2.calculateMapCenter(mapData.xCenter, mapData.zCenter, mapData2.scale);
            mapData2.dimension = mapData.dimension;
            mapData2.markDirty();
            world2.setItemData("map_" + itemStack.getMetadata(), mapData2);
        }
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List<String> list, boolean bl) {
        MapData mapData = this.getMapData(itemStack, entityPlayer.worldObj);
        if (bl) {
            if (mapData == null) {
                list.add("Unknown map");
            } else {
                list.add("Scaling at 1:" + (1 << mapData.scale));
                list.add("(Level " + mapData.scale + "/4)");
            }
        }
    }
}

