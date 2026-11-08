/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.tileentity;

import com.google.gson.JsonParseException;
import net.minecraft.command.CommandException;
import net.minecraft.command.CommandResultStats;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.event.ClickEvent;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S33PacketUpdateSign;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentProcessor;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class TileEntitySign
extends TileEntity {
    public final IChatComponent[] signText = new IChatComponent[]{new ChatComponentText(""), new ChatComponentText(""), new ChatComponentText(""), new ChatComponentText("")};
    public int lineBeingEdited = -1;
    private boolean isEditable = true;
    private EntityPlayer player;
    private final CommandResultStats stats = new CommandResultStats();

    @Override
    public void writeToNBT(NBTTagCompound nBTTagCompound) {
        super.writeToNBT(nBTTagCompound);
        for (int i = 0; i < 4; ++i) {
            String string = IChatComponent.Serializer.componentToJson(this.signText[i]);
            nBTTagCompound.setString("Text" + (i + 1), string);
        }
        this.stats.writeStatsToNBT(nBTTagCompound);
    }

    @Override
    public void readFromNBT(NBTTagCompound nBTTagCompound) {
        this.isEditable = false;
        super.readFromNBT(nBTTagCompound);
        ICommandSender iCommandSender = new ICommandSender(){

            @Override
            public String getName() {
                return "Sign";
            }

            @Override
            public IChatComponent getDisplayName() {
                return new ChatComponentText(this.getName());
            }

            @Override
            public void addChatMessage(IChatComponent iChatComponent) {
            }

            @Override
            public boolean canCommandSenderUseCommand(int n, String string) {
                return true;
            }

            @Override
            public BlockPos getPosition() {
                return TileEntitySign.this.pos;
            }

            @Override
            public Vec3 getPositionVector() {
                return new Vec3((double)TileEntitySign.this.pos.getX() + 0.5, (double)TileEntitySign.this.pos.getY() + 0.5, (double)TileEntitySign.this.pos.getZ() + 0.5);
            }

            @Override
            public World getEntityWorld() {
                return TileEntitySign.this.worldObj;
            }

            @Override
            public Entity getCommandSenderEntity() {
                return null;
            }

            @Override
            public boolean sendCommandFeedback() {
                return false;
            }

            @Override
            public void setCommandStat(CommandResultStats.Type type, int n) {
            }
        };
        for (int i = 0; i < 4; ++i) {
            String string = nBTTagCompound.getString("Text" + (i + 1));
            try {
                IChatComponent iChatComponent = IChatComponent.Serializer.jsonToComponent(string);
                try {
                    this.signText[i] = ChatComponentProcessor.processComponent(iCommandSender, iChatComponent, null);
                }
                catch (CommandException commandException) {
                    this.signText[i] = iChatComponent;
                }
                continue;
            }
            catch (JsonParseException jsonParseException) {
                this.signText[i] = new ChatComponentText(string);
            }
        }
        this.stats.readStatsFromNBT(nBTTagCompound);
    }

    @Override
    public Packet getDescriptionPacket() {
        IChatComponent[] iChatComponentArray = new IChatComponent[4];
        System.arraycopy(this.signText, 0, iChatComponentArray, 0, 4);
        return new S33PacketUpdateSign(this.worldObj, this.pos, iChatComponentArray);
    }

    @Override
    public boolean func_183000_F() {
        return true;
    }

    public boolean getIsEditable() {
        return this.isEditable;
    }

    public void setEditable(boolean bl) {
        this.isEditable = bl;
        if (!bl) {
            this.player = null;
        }
    }

    public void setPlayer(EntityPlayer entityPlayer) {
        this.player = entityPlayer;
    }

    public EntityPlayer getPlayer() {
        return this.player;
    }

    public boolean executeCommand(final EntityPlayer entityPlayer) {
        ICommandSender iCommandSender = new ICommandSender(){

            @Override
            public String getName() {
                return entityPlayer.getName();
            }

            @Override
            public IChatComponent getDisplayName() {
                return entityPlayer.getDisplayName();
            }

            @Override
            public void addChatMessage(IChatComponent iChatComponent) {
            }

            @Override
            public boolean canCommandSenderUseCommand(int n, String string) {
                return n <= 2;
            }

            @Override
            public BlockPos getPosition() {
                return TileEntitySign.this.pos;
            }

            @Override
            public Vec3 getPositionVector() {
                return new Vec3((double)TileEntitySign.this.pos.getX() + 0.5, (double)TileEntitySign.this.pos.getY() + 0.5, (double)TileEntitySign.this.pos.getZ() + 0.5);
            }

            @Override
            public World getEntityWorld() {
                return entityPlayer.getEntityWorld();
            }

            @Override
            public Entity getCommandSenderEntity() {
                return entityPlayer;
            }

            @Override
            public boolean sendCommandFeedback() {
                return false;
            }

            @Override
            public void setCommandStat(CommandResultStats.Type type, int n) {
                TileEntitySign.this.stats.setCommandStatScore(this, type, n);
            }
        };
        for (int i = 0; i < this.signText.length; ++i) {
            ClickEvent clickEvent;
            ChatStyle chatStyle;
            ChatStyle chatStyle2 = chatStyle = this.signText[i] == null ? null : this.signText[i].getChatStyle();
            if (chatStyle == null || chatStyle.getChatClickEvent() == null || (clickEvent = chatStyle.getChatClickEvent()).getAction() != ClickEvent.Action.RUN_COMMAND) continue;
            MinecraftServer.getServer().getCommandManager().executeCommand(iCommandSender, clickEvent.getValue());
        }
        return true;
    }

    public CommandResultStats getStats() {
        return this.stats;
    }
}

