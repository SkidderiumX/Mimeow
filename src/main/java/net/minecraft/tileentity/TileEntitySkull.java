/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.tileentity;

import com.google.common.collect.Iterables;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.StringUtils;

public class TileEntitySkull
extends TileEntity {
    private int skullType;
    private int skullRotation;
    private GameProfile playerProfile = null;

    @Override
    public void writeToNBT(NBTTagCompound nBTTagCompound) {
        super.writeToNBT(nBTTagCompound);
        nBTTagCompound.setByte("SkullType", (byte)(this.skullType & 0xFF));
        nBTTagCompound.setByte("Rot", (byte)(this.skullRotation & 0xFF));
        if (this.playerProfile != null) {
            NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
            NBTUtil.writeGameProfile(nBTTagCompound2, this.playerProfile);
            nBTTagCompound.setTag("Owner", nBTTagCompound2);
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound nBTTagCompound) {
        super.readFromNBT(nBTTagCompound);
        this.skullType = nBTTagCompound.getByte("SkullType");
        this.skullRotation = nBTTagCompound.getByte("Rot");
        if (this.skullType == 3) {
            String string;
            if (nBTTagCompound.hasKey("Owner", 10)) {
                this.playerProfile = NBTUtil.readGameProfileFromNBT(nBTTagCompound.getCompoundTag("Owner"));
            } else if (nBTTagCompound.hasKey("ExtraType", 8) && !StringUtils.isNullOrEmpty(string = nBTTagCompound.getString("ExtraType"))) {
                this.playerProfile = new GameProfile(null, string);
                this.updatePlayerProfile();
            }
        }
    }

    public GameProfile getPlayerProfile() {
        return this.playerProfile;
    }

    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound nBTTagCompound = new NBTTagCompound();
        this.writeToNBT(nBTTagCompound);
        return new S35PacketUpdateTileEntity(this.pos, 4, nBTTagCompound);
    }

    public void setType(int n) {
        this.skullType = n;
        this.playerProfile = null;
    }

    public void setPlayerProfile(GameProfile gameProfile) {
        this.skullType = 3;
        this.playerProfile = gameProfile;
        this.updatePlayerProfile();
    }

    private void updatePlayerProfile() {
        this.playerProfile = TileEntitySkull.updateGameprofile(this.playerProfile);
        this.markDirty();
    }

    public static GameProfile updateGameprofile(GameProfile gameProfile) {
        if (gameProfile != null && !StringUtils.isNullOrEmpty(gameProfile.getName())) {
            if (gameProfile.isComplete() && gameProfile.getProperties().containsKey("textures")) {
                return gameProfile;
            }
            if (MinecraftServer.getServer() == null) {
                return gameProfile;
            }
            GameProfile gameProfile2 = MinecraftServer.getServer().getPlayerProfileCache().getGameProfileForUsername(gameProfile.getName());
            if (gameProfile2 == null) {
                return gameProfile;
            }
            Property property = Iterables.getFirst(gameProfile2.getProperties().get("textures"), null);
            if (property == null) {
                gameProfile2 = MinecraftServer.getServer().getMinecraftSessionService().fillProfileProperties(gameProfile2, true);
            }
            return gameProfile2;
        }
        return gameProfile;
    }

    public int getSkullType() {
        return this.skullType;
    }

    public int getSkullRotation() {
        return this.skullRotation;
    }

    public void setSkullRotation(int n) {
        this.skullRotation = n;
    }
}

