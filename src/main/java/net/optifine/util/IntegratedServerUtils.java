/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.util;

import java.util.UUID;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.Entity;
import net.minecraft.server.integrated.IntegratedServer;
import net.minecraft.src.Config;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldServer;
import net.minecraft.world.chunk.Chunk;

public class IntegratedServerUtils {
    public static WorldServer getWorldServer() {
        Minecraft minecraft = Config.getMinecraft();
        WorldClient worldClient = minecraft.theWorld;
        if (worldClient == null) {
            return null;
        }
        if (!minecraft.isIntegratedServerRunning()) {
            return null;
        }
        IntegratedServer integratedServer = minecraft.getIntegratedServer();
        if (integratedServer == null) {
            return null;
        }
        WorldProvider worldProvider = worldClient.provider;
        if (worldProvider == null) {
            return null;
        }
        int n = worldProvider.getDimensionId();
        try {
            WorldServer worldServer = integratedServer.worldServerForDimension(n);
            return worldServer;
        }
        catch (NullPointerException nullPointerException) {
            return null;
        }
    }

    public static Entity getEntity(UUID uUID) {
        WorldServer worldServer = IntegratedServerUtils.getWorldServer();
        if (worldServer == null) {
            return null;
        }
        Entity entity = worldServer.getEntityFromUuid(uUID);
        return entity;
    }

    public static TileEntity getTileEntity(BlockPos blockPos) {
        WorldServer worldServer = IntegratedServerUtils.getWorldServer();
        if (worldServer == null) {
            return null;
        }
        Chunk chunk = worldServer.getChunkProvider().provideChunk(blockPos.getX() >> 4, blockPos.getZ() >> 4);
        if (chunk == null) {
            return null;
        }
        TileEntity tileEntity = chunk.getTileEntity(blockPos, Chunk.EnumCreateEntityType.CHECK);
        return tileEntity;
    }
}

