/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.command;

import com.google.common.collect.Lists;
import java.util.Iterator;
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
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTException;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class CommandFill
extends CommandBase {
    @Override
    public String getCommandName() {
        return "fill";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "commands.fill.usage";
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] stringArray) throws CommandException {
        int n;
        block24: {
            block19: {
                Object object;
                int n2;
                if (stringArray.length < 7) {
                    throw new WrongUsageException("commands.fill.usage", new Object[0]);
                }
                iCommandSender.setCommandStat(CommandResultStats.Type.AFFECTED_BLOCKS, 0);
                BlockPos blockPos = CommandFill.parseBlockPos(iCommandSender, stringArray, 0, false);
                BlockPos blockPos2 = CommandFill.parseBlockPos(iCommandSender, stringArray, 3, false);
                Block block = CommandBase.getBlockByText(iCommandSender, stringArray[6]);
                int n3 = 0;
                if (stringArray.length >= 8) {
                    n3 = CommandFill.parseInt(stringArray[7], 0, 15);
                }
                BlockPos blockPos3 = new BlockPos(Math.min(blockPos.getX(), blockPos2.getX()), Math.min(blockPos.getY(), blockPos2.getY()), Math.min(blockPos.getZ(), blockPos2.getZ()));
                BlockPos blockPos4 = new BlockPos(Math.max(blockPos.getX(), blockPos2.getX()), Math.max(blockPos.getY(), blockPos2.getY()), Math.max(blockPos.getZ(), blockPos2.getZ()));
                n = (blockPos4.getX() - blockPos3.getX() + 1) * (blockPos4.getY() - blockPos3.getY() + 1) * (blockPos4.getZ() - blockPos3.getZ() + 1);
                if (n > 32768) {
                    throw new CommandException("commands.fill.tooManyBlocks", n, 32768);
                }
                if (blockPos3.getY() < 0 || blockPos4.getY() >= 256) break block19;
                World world2 = iCommandSender.getEntityWorld();
                for (int i = blockPos3.getZ(); i < blockPos4.getZ() + 16; i += 16) {
                    for (n2 = blockPos3.getX(); n2 < blockPos4.getX() + 16; n2 += 16) {
                        if (world2.isBlockLoaded(new BlockPos(n2, blockPos4.getY() - blockPos3.getY(), i))) continue;
                        throw new CommandException("commands.fill.outOfWorld", new Object[0]);
                    }
                }
                NBTTagCompound nBTTagCompound = new NBTTagCompound();
                n2 = 0;
                if (stringArray.length >= 10 && block.hasTileEntity()) {
                    object = CommandFill.getChatComponentFromNthArg(iCommandSender, stringArray, 9).getUnformattedText();
                    try {
                        nBTTagCompound = JsonToNBT.getTagFromJson((String)object);
                        n2 = 1;
                    }
                    catch (NBTException nBTException) {
                        throw new CommandException("commands.fill.tagError", nBTException.getMessage());
                    }
                }
                object = Lists.newArrayList();
                n = 0;
                for (int i = blockPos3.getZ(); i <= blockPos4.getZ(); ++i) {
                    for (int j = blockPos3.getY(); j <= blockPos4.getY(); ++j) {
                        for (int k = blockPos3.getX(); k <= blockPos4.getX(); ++k) {
                            TileEntity tileEntity;
                            IBlockState iBlockState;
                            Object object2;
                            BlockPos blockPos5;
                            block20: {
                                block21: {
                                    block23: {
                                        block22: {
                                            blockPos5 = new BlockPos(k, j, i);
                                            if (stringArray.length < 9) break block20;
                                            if (stringArray[8].equals("outline") || stringArray[8].equals("hollow")) break block21;
                                            if (!stringArray[8].equals("destroy")) break block22;
                                            world2.destroyBlock(blockPos5, true);
                                            break block20;
                                        }
                                        if (!stringArray[8].equals("keep")) break block23;
                                        if (!world2.isAirBlock(blockPos5)) {
                                            continue;
                                        }
                                        break block20;
                                    }
                                    if (!stringArray[8].equals("replace") || block.hasTileEntity()) break block20;
                                    if (stringArray.length > 9) {
                                        object2 = CommandBase.getBlockByText(iCommandSender, stringArray[9]);
                                        if (world2.getBlockState(blockPos5).getBlock() != object2) continue;
                                    }
                                    if (stringArray.length <= 10) break block20;
                                    int n4 = CommandBase.parseInt(stringArray[10]);
                                    iBlockState = world2.getBlockState(blockPos5);
                                    if (iBlockState.getBlock().getMetaFromState(iBlockState) != n4) {
                                        continue;
                                    }
                                    break block20;
                                }
                                if (k != blockPos3.getX() && k != blockPos4.getX() && j != blockPos3.getY() && j != blockPos4.getY() && i != blockPos3.getZ() && i != blockPos4.getZ()) {
                                    if (!stringArray[8].equals("hollow")) continue;
                                    world2.setBlockState(blockPos5, Blocks.air.getDefaultState(), 2);
                                    object.add(blockPos5);
                                    continue;
                                }
                            }
                            if ((object2 = world2.getTileEntity(blockPos5)) != null) {
                                if (object2 instanceof IInventory) {
                                    ((IInventory)object2).clear();
                                }
                                world2.setBlockState(blockPos5, Blocks.barrier.getDefaultState(), block == Blocks.barrier ? 2 : 4);
                            }
                            if (!world2.setBlockState(blockPos5, iBlockState = block.getStateFromMeta(n3), 2)) continue;
                            object.add(blockPos5);
                            ++n;
                            if (n2 == 0 || (tileEntity = world2.getTileEntity(blockPos5)) == null) continue;
                            nBTTagCompound.setInteger("x", blockPos5.getX());
                            nBTTagCompound.setInteger("y", blockPos5.getY());
                            nBTTagCompound.setInteger("z", blockPos5.getZ());
                            tileEntity.readFromNBT(nBTTagCompound);
                        }
                    }
                }
                Iterator iterator2 = object.iterator();
                while (iterator2.hasNext()) {
                    BlockPos blockPos6 = (BlockPos)iterator2.next();
                    Block block2 = world2.getBlockState(blockPos6).getBlock();
                    world2.notifyNeighborsRespectDebug(blockPos6, block2);
                }
                if (n <= 0) {
                    throw new CommandException("commands.fill.failed", new Object[0]);
                }
                break block24;
            }
            throw new CommandException("commands.fill.outOfWorld", new Object[0]);
        }
        iCommandSender.setCommandStat(CommandResultStats.Type.AFFECTED_BLOCKS, n);
        CommandFill.notifyOperators(iCommandSender, (ICommand)this, "commands.fill.success", n);
    }

    @Override
    public List<String> addTabCompletionOptions(ICommandSender iCommandSender, String[] stringArray, BlockPos blockPos) {
        return stringArray.length > 0 && stringArray.length <= 3 ? CommandFill.func_175771_a(stringArray, 0, blockPos) : (stringArray.length > 3 && stringArray.length <= 6 ? CommandFill.func_175771_a(stringArray, 3, blockPos) : (stringArray.length == 7 ? CommandFill.getListOfStringsMatchingLastWord(stringArray, Block.blockRegistry.getKeys()) : (stringArray.length == 9 ? CommandFill.getListOfStringsMatchingLastWord(stringArray, "replace", "destroy", "keep", "hollow", "outline") : (stringArray.length == 10 && "replace".equals(stringArray[8]) ? CommandFill.getListOfStringsMatchingLastWord(stringArray, Block.blockRegistry.getKeys()) : null))));
    }
}

