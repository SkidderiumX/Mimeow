/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.command;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.CommandResultStats;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.NextTickListEntry;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;

public class CommandClone
extends CommandBase {
    @Override
    public String getCommandName() {
        return "clone";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "commands.clone.usage";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public void processCommand(ICommandSender iCommandSender, String[] stringArray) throws CommandException {
        Object object;
        if (stringArray.length < 9) {
            throw new WrongUsageException("commands.clone.usage", new Object[0]);
        }
        iCommandSender.setCommandStat(CommandResultStats.Type.AFFECTED_BLOCKS, 0);
        BlockPos blockPos = CommandClone.parseBlockPos(iCommandSender, stringArray, 0, false);
        BlockPos blockPos2 = CommandClone.parseBlockPos(iCommandSender, stringArray, 3, false);
        BlockPos blockPos3 = CommandClone.parseBlockPos(iCommandSender, stringArray, 6, false);
        StructureBoundingBox structureBoundingBox = new StructureBoundingBox(blockPos, blockPos2);
        StructureBoundingBox structureBoundingBox2 = new StructureBoundingBox(blockPos3, blockPos3.add(structureBoundingBox.func_175896_b()));
        int n = structureBoundingBox.getXSize() * structureBoundingBox.getYSize() * structureBoundingBox.getZSize();
        if (n > 32768) {
            throw new CommandException("commands.clone.tooManyBlocks", n, 32768);
        }
        boolean bl = false;
        Block block = null;
        int n2 = -1;
        if ((stringArray.length < 11 || !stringArray[10].equals("force") && !stringArray[10].equals("move")) && structureBoundingBox.intersectsWith(structureBoundingBox2)) {
            throw new CommandException("commands.clone.noOverlap", new Object[0]);
        }
        if (stringArray.length >= 11 && stringArray[10].equals("move")) {
            bl = true;
        }
        if (structureBoundingBox.minY < 0 || structureBoundingBox.maxY >= 256 || structureBoundingBox2.minY < 0 || structureBoundingBox2.maxY >= 256) throw new CommandException("commands.clone.outOfWorld", new Object[0]);
        World world2 = iCommandSender.getEntityWorld();
        if (!world2.isAreaLoaded(structureBoundingBox) || !world2.isAreaLoaded(structureBoundingBox2)) throw new CommandException("commands.clone.outOfWorld", new Object[0]);
        boolean bl2 = false;
        if (stringArray.length >= 10) {
            if (stringArray[9].equals("masked")) {
                bl2 = true;
            } else if (stringArray[9].equals("filtered")) {
                if (stringArray.length < 12) {
                    throw new WrongUsageException("commands.clone.usage", new Object[0]);
                }
                block = CommandClone.getBlockByText(iCommandSender, stringArray[11]);
                if (stringArray.length >= 13) {
                    n2 = CommandClone.parseInt(stringArray[12], 0, 15);
                }
            }
        }
        ArrayList<StaticCloneData> arrayList = Lists.newArrayList();
        ArrayList<StaticCloneData> arrayList2 = Lists.newArrayList();
        ArrayList<StaticCloneData> arrayList3 = Lists.newArrayList();
        LinkedList<BlockPos> linkedList = Lists.newLinkedList();
        BlockPos blockPos4 = new BlockPos(structureBoundingBox2.minX - structureBoundingBox.minX, structureBoundingBox2.minY - structureBoundingBox.minY, structureBoundingBox2.minZ - structureBoundingBox.minZ);
        for (int i = structureBoundingBox.minZ; i <= structureBoundingBox.maxZ; ++i) {
            for (int j = structureBoundingBox.minY; j <= structureBoundingBox.maxY; ++j) {
                for (int k = structureBoundingBox.minX; k <= structureBoundingBox.maxX; ++k) {
                    BlockPos blockPos5 = new BlockPos(k, j, i);
                    BlockPos blockPos6 = blockPos5.add(blockPos4);
                    object = world2.getBlockState(blockPos5);
                    if (bl2 && object.getBlock() == Blocks.air || block != null && (object.getBlock() != block || n2 >= 0 && object.getBlock().getMetaFromState((IBlockState)object) != n2)) continue;
                    TileEntity tileEntity = world2.getTileEntity(blockPos5);
                    if (tileEntity != null) {
                        NBTTagCompound nBTTagCompound = new NBTTagCompound();
                        tileEntity.writeToNBT(nBTTagCompound);
                        arrayList2.add(new StaticCloneData(blockPos6, (IBlockState)object, nBTTagCompound));
                        linkedList.addLast(blockPos5);
                        continue;
                    }
                    if (!object.getBlock().isFullBlock() && !object.getBlock().isFullCube()) {
                        arrayList3.add(new StaticCloneData(blockPos6, (IBlockState)object, null));
                        linkedList.addFirst(blockPos5);
                        continue;
                    }
                    arrayList.add(new StaticCloneData(blockPos6, (IBlockState)object, null));
                    linkedList.addLast(blockPos5);
                }
            }
        }
        if (bl) {
            for (BlockPos blockPos7 : linkedList) {
                TileEntity tileEntity = world2.getTileEntity(blockPos7);
                if (tileEntity instanceof IInventory) {
                    ((IInventory)((Object)tileEntity)).clear();
                }
                world2.setBlockState(blockPos7, Blocks.barrier.getDefaultState(), 2);
            }
            for (BlockPos blockPos8 : linkedList) {
                world2.setBlockState(blockPos8, Blocks.air.getDefaultState(), 3);
            }
        }
        ArrayList<StaticCloneData> arrayList4 = Lists.newArrayList();
        arrayList4.addAll(arrayList);
        arrayList4.addAll(arrayList2);
        arrayList4.addAll(arrayList3);
        List list = Lists.reverse(arrayList4);
        for (StaticCloneData staticCloneData : list) {
            TileEntity tileEntity = world2.getTileEntity(staticCloneData.pos);
            if (tileEntity instanceof IInventory) {
                ((IInventory)((Object)tileEntity)).clear();
            }
            world2.setBlockState(staticCloneData.pos, Blocks.barrier.getDefaultState(), 2);
        }
        n = 0;
        for (StaticCloneData staticCloneData : arrayList4) {
            if (!world2.setBlockState(staticCloneData.pos, staticCloneData.blockState, 2)) continue;
            ++n;
        }
        for (StaticCloneData staticCloneData : arrayList2) {
            TileEntity tileEntity = world2.getTileEntity(staticCloneData.pos);
            if (staticCloneData.compound != null && tileEntity != null) {
                staticCloneData.compound.setInteger("x", staticCloneData.pos.getX());
                staticCloneData.compound.setInteger("y", staticCloneData.pos.getY());
                staticCloneData.compound.setInteger("z", staticCloneData.pos.getZ());
                tileEntity.readFromNBT(staticCloneData.compound);
                tileEntity.markDirty();
            }
            world2.setBlockState(staticCloneData.pos, staticCloneData.blockState, 2);
        }
        for (StaticCloneData staticCloneData : list) {
            world2.notifyNeighborsRespectDebug(staticCloneData.pos, staticCloneData.blockState.getBlock());
        }
        List<NextTickListEntry> list2 = world2.func_175712_a(structureBoundingBox, false);
        if (list2 != null) {
            for (NextTickListEntry nextTickListEntry : list2) {
                if (!structureBoundingBox.isVecInside(nextTickListEntry.position)) continue;
                object = nextTickListEntry.position.add(blockPos4);
                world2.scheduleBlockUpdate((BlockPos)object, nextTickListEntry.getBlock(), (int)(nextTickListEntry.scheduledTime - world2.getWorldInfo().getWorldTotalTime()), nextTickListEntry.priority);
            }
        }
        if (n <= 0) {
            throw new CommandException("commands.clone.failed", new Object[0]);
        }
        iCommandSender.setCommandStat(CommandResultStats.Type.AFFECTED_BLOCKS, n);
        CommandClone.notifyOperators(iCommandSender, (ICommand)this, "commands.clone.success", n);
    }

    @Override
    public List<String> addTabCompletionOptions(ICommandSender iCommandSender, String[] stringArray, BlockPos blockPos) {
        return stringArray.length > 0 && stringArray.length <= 3 ? CommandClone.func_175771_a(stringArray, 0, blockPos) : (stringArray.length > 3 && stringArray.length <= 6 ? CommandClone.func_175771_a(stringArray, 3, blockPos) : (stringArray.length > 6 && stringArray.length <= 9 ? CommandClone.func_175771_a(stringArray, 6, blockPos) : (stringArray.length == 10 ? CommandClone.getListOfStringsMatchingLastWord(stringArray, "replace", "masked", "filtered") : (stringArray.length == 11 ? CommandClone.getListOfStringsMatchingLastWord(stringArray, "normal", "force", "move") : (stringArray.length == 12 && "filtered".equals(stringArray[9]) ? CommandClone.getListOfStringsMatchingLastWord(stringArray, Block.blockRegistry.getKeys()) : null)))));
    }

    public static class StaticCloneData {
        public final BlockPos pos;
        public final IBlockState blockState;
        public final NBTTagCompound compound;

        public StaticCloneData(BlockPos blockPos, IBlockState iBlockState, NBTTagCompound nBTTagCompound) {
            this.pos = blockPos;
            this.blockState = iBlockState;
            this.compound = nBTTagCompound;
        }
    }
}

