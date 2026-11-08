/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.util;

import net.minecraft.src.Config;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.tileentity.TileEntityBrewingStand;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.tileentity.TileEntityEnchantmentTable;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.tileentity.TileEntityHopper;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.IWorldNameable;
import net.optifine.reflect.Reflector;
import net.optifine.util.IntegratedServerUtils;

public class TileEntityUtils {
    public static String getTileEntityName(IBlockAccess iBlockAccess, BlockPos blockPos) {
        TileEntity tileEntity = iBlockAccess.getTileEntity(blockPos);
        return TileEntityUtils.getTileEntityName(tileEntity);
    }

    public static String getTileEntityName(TileEntity tileEntity) {
        if (!(tileEntity instanceof IWorldNameable)) {
            return null;
        }
        IWorldNameable iWorldNameable = (IWorldNameable)((Object)tileEntity);
        TileEntityUtils.updateTileEntityName(tileEntity);
        return !iWorldNameable.hasCustomName() ? null : iWorldNameable.getName();
    }

    public static void updateTileEntityName(TileEntity tileEntity) {
        BlockPos blockPos = tileEntity.getPos();
        String string = TileEntityUtils.getTileEntityRawName(tileEntity);
        if (string == null) {
            String string2 = TileEntityUtils.getServerTileEntityRawName(blockPos);
            string2 = Config.normalize(string2);
            TileEntityUtils.setTileEntityRawName(tileEntity, string2);
        }
    }

    public static String getServerTileEntityRawName(BlockPos blockPos) {
        TileEntity tileEntity = IntegratedServerUtils.getTileEntity(blockPos);
        return tileEntity == null ? null : TileEntityUtils.getTileEntityRawName(tileEntity);
    }

    public static String getTileEntityRawName(TileEntity tileEntity) {
        IWorldNameable iWorldNameable;
        if (tileEntity instanceof TileEntityBeacon) {
            return (String)Reflector.getFieldValue(tileEntity, Reflector.TileEntityBeacon_customName);
        }
        if (tileEntity instanceof TileEntityBrewingStand) {
            return (String)Reflector.getFieldValue(tileEntity, Reflector.TileEntityBrewingStand_customName);
        }
        if (tileEntity instanceof TileEntityEnchantmentTable) {
            return (String)Reflector.getFieldValue(tileEntity, Reflector.TileEntityEnchantmentTable_customName);
        }
        if (tileEntity instanceof TileEntityFurnace) {
            return (String)Reflector.getFieldValue(tileEntity, Reflector.TileEntityFurnace_customName);
        }
        if (tileEntity instanceof IWorldNameable && (iWorldNameable = (IWorldNameable)((Object)tileEntity)).hasCustomName()) {
            return iWorldNameable.getName();
        }
        return null;
    }

    public static boolean setTileEntityRawName(TileEntity tileEntity, String string) {
        if (tileEntity instanceof TileEntityBeacon) {
            return Reflector.setFieldValue(tileEntity, Reflector.TileEntityBeacon_customName, string);
        }
        if (tileEntity instanceof TileEntityBrewingStand) {
            return Reflector.setFieldValue(tileEntity, Reflector.TileEntityBrewingStand_customName, string);
        }
        if (tileEntity instanceof TileEntityEnchantmentTable) {
            return Reflector.setFieldValue(tileEntity, Reflector.TileEntityEnchantmentTable_customName, string);
        }
        if (tileEntity instanceof TileEntityFurnace) {
            return Reflector.setFieldValue(tileEntity, Reflector.TileEntityFurnace_customName, string);
        }
        if (tileEntity instanceof TileEntityChest) {
            ((TileEntityChest)tileEntity).setCustomName(string);
            return true;
        }
        if (tileEntity instanceof TileEntityDispenser) {
            ((TileEntityDispenser)tileEntity).setCustomName(string);
            return true;
        }
        if (tileEntity instanceof TileEntityHopper) {
            ((TileEntityHopper)tileEntity).setCustomName(string);
            return true;
        }
        return false;
    }
}

