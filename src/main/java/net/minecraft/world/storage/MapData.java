/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.storage;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S34PacketMaps;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3i;
import net.minecraft.util.Vec4b;
import net.minecraft.world.World;
import net.minecraft.world.WorldSavedData;

public class MapData
extends WorldSavedData {
    public int xCenter;
    public int zCenter;
    public byte dimension;
    public byte scale;
    public byte[] colors = new byte[16384];
    public List<MapInfo> playersArrayList = Lists.newArrayList();
    private Map<EntityPlayer, MapInfo> playersHashMap = Maps.newHashMap();
    public Map<String, Vec4b> mapDecorations = Maps.newLinkedHashMap();

    public MapData(String string) {
        super(string);
    }

    public void calculateMapCenter(double d, double d2, int n) {
        int n2 = 128 * (1 << n);
        int n3 = MathHelper.floor_double((d + 64.0) / (double)n2);
        int n4 = MathHelper.floor_double((d2 + 64.0) / (double)n2);
        this.xCenter = n3 * n2 + n2 / 2 - 64;
        this.zCenter = n4 * n2 + n2 / 2 - 64;
    }

    @Override
    public void readFromNBT(NBTTagCompound nBTTagCompound) {
        this.dimension = nBTTagCompound.getByte("dimension");
        this.xCenter = nBTTagCompound.getInteger("xCenter");
        this.zCenter = nBTTagCompound.getInteger("zCenter");
        this.scale = nBTTagCompound.getByte("scale");
        this.scale = (byte)MathHelper.clamp_int(this.scale, 0, 4);
        int n = nBTTagCompound.getShort("width");
        int n2 = nBTTagCompound.getShort("height");
        if (n == 128 && n2 == 128) {
            this.colors = nBTTagCompound.getByteArray("colors");
        } else {
            byte[] byArray = nBTTagCompound.getByteArray("colors");
            this.colors = new byte[16384];
            int n3 = (128 - n) / 2;
            int n4 = (128 - n2) / 2;
            for (int i = 0; i < n2; ++i) {
                int n5 = i + n4;
                if (n5 < 0 && n5 >= 128) continue;
                for (int j = 0; j < n; ++j) {
                    int n6 = j + n3;
                    if (n6 < 0 && n6 >= 128) continue;
                    this.colors[n6 + n5 * 128] = byArray[j + i * n];
                }
            }
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound nBTTagCompound) {
        nBTTagCompound.setByte("dimension", this.dimension);
        nBTTagCompound.setInteger("xCenter", this.xCenter);
        nBTTagCompound.setInteger("zCenter", this.zCenter);
        nBTTagCompound.setByte("scale", this.scale);
        nBTTagCompound.setShort("width", (short)128);
        nBTTagCompound.setShort("height", (short)128);
        nBTTagCompound.setByteArray("colors", this.colors);
    }

    public void updateVisiblePlayers(EntityPlayer entityPlayer, ItemStack itemStack) {
        Object object;
        if (!this.playersHashMap.containsKey(entityPlayer)) {
            MapInfo mapInfo = new MapInfo(entityPlayer);
            this.playersHashMap.put(entityPlayer, mapInfo);
            this.playersArrayList.add(mapInfo);
        }
        if (!entityPlayer.inventory.hasItemStack(itemStack)) {
            this.mapDecorations.remove(entityPlayer.getName());
        }
        for (int i = 0; i < this.playersArrayList.size(); ++i) {
            object = this.playersArrayList.get(i);
            if (!((MapInfo)object).entityplayerObj.isDead && (((MapInfo)object).entityplayerObj.inventory.hasItemStack(itemStack) || itemStack.isOnItemFrame())) {
                if (itemStack.isOnItemFrame() || ((MapInfo)object).entityplayerObj.dimension != this.dimension) continue;
                this.updateDecorations(0, ((MapInfo)object).entityplayerObj.worldObj, ((MapInfo)object).entityplayerObj.getName(), ((MapInfo)object).entityplayerObj.posX, ((MapInfo)object).entityplayerObj.posZ, ((MapInfo)object).entityplayerObj.rotationYaw);
                continue;
            }
            this.playersHashMap.remove(((MapInfo)object).entityplayerObj);
            this.playersArrayList.remove(object);
        }
        if (itemStack.isOnItemFrame()) {
            EntityItemFrame entityItemFrame = itemStack.getItemFrame();
            object = entityItemFrame.getHangingPosition();
            this.updateDecorations(1, entityPlayer.worldObj, "frame-" + entityItemFrame.getEntityId(), ((Vec3i)object).getX(), ((Vec3i)object).getZ(), entityItemFrame.facingDirection.getHorizontalIndex() * 90);
        }
        if (itemStack.hasTagCompound() && itemStack.getTagCompound().hasKey("Decorations", 9)) {
            NBTTagList nBTTagList = itemStack.getTagCompound().getTagList("Decorations", 10);
            for (int i = 0; i < nBTTagList.tagCount(); ++i) {
                NBTTagCompound nBTTagCompound = nBTTagList.getCompoundTagAt(i);
                if (this.mapDecorations.containsKey(nBTTagCompound.getString("id"))) continue;
                this.updateDecorations(nBTTagCompound.getByte("type"), entityPlayer.worldObj, nBTTagCompound.getString("id"), nBTTagCompound.getDouble("x"), nBTTagCompound.getDouble("z"), nBTTagCompound.getDouble("rot"));
            }
        }
    }

    private void updateDecorations(int n, World world2, String string, double d, double d2, double d3) {
        byte by;
        int n2 = 1 << this.scale;
        float f = (float)(d - (double)this.xCenter) / (float)n2;
        float f2 = (float)(d2 - (double)this.zCenter) / (float)n2;
        byte by2 = (byte)((double)(f * 2.0f) + 0.5);
        byte by3 = (byte)((double)(f2 * 2.0f) + 0.5);
        int n3 = 63;
        if (f >= (float)(-n3) && f2 >= (float)(-n3) && f <= (float)n3 && f2 <= (float)n3) {
            by = (byte)((d3 += d3 < 0.0 ? -8.0 : 8.0) * 16.0 / 360.0);
            if (this.dimension < 0) {
                int n4 = (int)(world2.getWorldInfo().getWorldTime() / 10L);
                by = (byte)(n4 * n4 * 34187121 + n4 * 121 >> 15 & 0xF);
            }
        } else {
            if (Math.abs(f) >= 320.0f || Math.abs(f2) >= 320.0f) {
                this.mapDecorations.remove(string);
                return;
            }
            n = 6;
            by = 0;
            if (f <= (float)(-n3)) {
                by2 = (byte)((double)(n3 * 2) + 2.5);
            }
            if (f2 <= (float)(-n3)) {
                by3 = (byte)((double)(n3 * 2) + 2.5);
            }
            if (f >= (float)n3) {
                by2 = (byte)(n3 * 2 + 1);
            }
            if (f2 >= (float)n3) {
                by3 = (byte)(n3 * 2 + 1);
            }
        }
        this.mapDecorations.put(string, new Vec4b((byte)n, by2, by3, by));
    }

    public Packet getMapPacket(ItemStack itemStack, World world2, EntityPlayer entityPlayer) {
        MapInfo mapInfo = this.playersHashMap.get(entityPlayer);
        return mapInfo == null ? null : mapInfo.getPacket(itemStack);
    }

    public void updateMapData(int n, int n2) {
        super.markDirty();
        for (MapInfo mapInfo : this.playersArrayList) {
            mapInfo.update(n, n2);
        }
    }

    public MapInfo getMapInfo(EntityPlayer entityPlayer) {
        MapInfo mapInfo = this.playersHashMap.get(entityPlayer);
        if (mapInfo == null) {
            mapInfo = new MapInfo(entityPlayer);
            this.playersHashMap.put(entityPlayer, mapInfo);
            this.playersArrayList.add(mapInfo);
        }
        return mapInfo;
    }

    public class MapInfo {
        public final EntityPlayer entityplayerObj;
        private boolean field_176105_d = true;
        private int minX = 0;
        private int minY = 0;
        private int maxX = 127;
        private int maxY = 127;
        private int field_176109_i;
        public int field_82569_d;

        public MapInfo(EntityPlayer entityPlayer) {
            this.entityplayerObj = entityPlayer;
        }

        public Packet getPacket(ItemStack itemStack) {
            if (this.field_176105_d) {
                this.field_176105_d = false;
                return new S34PacketMaps(itemStack.getMetadata(), MapData.this.scale, MapData.this.mapDecorations.values(), MapData.this.colors, this.minX, this.minY, this.maxX + 1 - this.minX, this.maxY + 1 - this.minY);
            }
            return this.field_176109_i++ % 5 == 0 ? new S34PacketMaps(itemStack.getMetadata(), MapData.this.scale, MapData.this.mapDecorations.values(), MapData.this.colors, 0, 0, 0, 0) : null;
        }

        public void update(int n, int n2) {
            if (this.field_176105_d) {
                this.minX = Math.min(this.minX, n);
                this.minY = Math.min(this.minY, n2);
                this.maxX = Math.max(this.maxX, n);
                this.maxY = Math.max(this.maxY, n2);
            } else {
                this.field_176105_d = true;
                this.minX = n;
                this.minY = n2;
                this.maxX = n;
                this.maxY = n2;
            }
        }
    }
}

