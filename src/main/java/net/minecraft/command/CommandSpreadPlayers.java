/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.command;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.CommandResultStats;
import net.minecraft.command.EntityNotFoundException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.PlayerNotFoundException;
import net.minecraft.command.PlayerSelector;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.scoreboard.Team;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class CommandSpreadPlayers
extends CommandBase {
    @Override
    public String getCommandName() {
        return "spreadplayers";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "commands.spreadplayers.usage";
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] stringArray) throws CommandException {
        if (stringArray.length < 6) {
            throw new WrongUsageException("commands.spreadplayers.usage", new Object[0]);
        }
        int n = 0;
        BlockPos blockPos = iCommandSender.getPosition();
        double d = CommandSpreadPlayers.parseDouble(blockPos.getX(), stringArray[n++], true);
        double d2 = CommandSpreadPlayers.parseDouble(blockPos.getZ(), stringArray[n++], true);
        double d3 = CommandSpreadPlayers.parseDouble(stringArray[n++], 0.0);
        double d4 = CommandSpreadPlayers.parseDouble(stringArray[n++], d3 + 1.0);
        boolean bl = CommandSpreadPlayers.parseBoolean(stringArray[n++]);
        ArrayList<Entity> arrayList = Lists.newArrayList();
        while (n < stringArray.length) {
            Object object;
            String string;
            if (PlayerSelector.hasArguments(string = stringArray[n++])) {
                object = PlayerSelector.matchEntities(iCommandSender, string, Entity.class);
                if (object.size() == 0) {
                    throw new EntityNotFoundException();
                }
                arrayList.addAll((Collection<Entity>)object);
                continue;
            }
            object = MinecraftServer.getServer().getConfigurationManager().getPlayerByUsername(string);
            if (object == null) {
                throw new PlayerNotFoundException();
            }
            arrayList.add((Entity)object);
        }
        iCommandSender.setCommandStat(CommandResultStats.Type.AFFECTED_ENTITIES, arrayList.size());
        if (arrayList.isEmpty()) {
            throw new EntityNotFoundException();
        }
        iCommandSender.addChatMessage(new ChatComponentTranslation("commands.spreadplayers.spreading." + (bl ? "teams" : "players"), arrayList.size(), d4, d, d2, d3));
        this.func_110669_a(iCommandSender, arrayList, new Position(d, d2), d3, d4, ((Entity)arrayList.get((int)0)).worldObj, bl);
    }

    private void func_110669_a(ICommandSender iCommandSender, List<Entity> list, Position position, double d, double d2, World world2, boolean bl) throws CommandException {
        Random random = new Random();
        double d3 = position.field_111101_a - d2;
        double d4 = position.field_111100_b - d2;
        double d5 = position.field_111101_a + d2;
        double d6 = position.field_111100_b + d2;
        Position[] positionArray = this.func_110670_a(random, bl ? this.func_110667_a(list) : list.size(), d3, d4, d5, d6);
        int n = this.func_110668_a(position, d, world2, random, d3, d4, d5, d6, positionArray, bl);
        double d7 = this.func_110671_a(list, world2, positionArray, bl);
        CommandSpreadPlayers.notifyOperators(iCommandSender, (ICommand)this, "commands.spreadplayers.success." + (bl ? "teams" : "players"), positionArray.length, position.field_111101_a, position.field_111100_b);
        if (positionArray.length > 1) {
            iCommandSender.addChatMessage(new ChatComponentTranslation("commands.spreadplayers.info." + (bl ? "teams" : "players"), String.format("%.2f", d7), n));
        }
    }

    private int func_110667_a(List<Entity> list) {
        HashSet<Team> hashSet = Sets.newHashSet();
        for (Entity entity : list) {
            if (entity instanceof EntityPlayer) {
                hashSet.add(((EntityPlayer)entity).getTeam());
                continue;
            }
            hashSet.add(null);
        }
        return hashSet.size();
    }

    private int func_110668_a(Position position, double d, World world2, Random random, double d2, double d3, double d4, double d5, Position[] positionArray, boolean bl) throws CommandException {
        int n;
        boolean bl2 = true;
        double d6 = 3.4028234663852886E38;
        for (n = 0; n < 10000 && bl2; ++n) {
            bl2 = false;
            d6 = 3.4028234663852886E38;
            for (int i = 0; i < positionArray.length; ++i) {
                Position position2 = positionArray[i];
                int n2 = 0;
                Position position3 = new Position();
                for (int j = 0; j < positionArray.length; ++j) {
                    if (i == j) continue;
                    Position position4 = positionArray[j];
                    double d7 = position2.func_111099_a(position4);
                    d6 = Math.min(d7, d6);
                    if (!(d7 < d)) continue;
                    ++n2;
                    position3.field_111101_a += position4.field_111101_a - position2.field_111101_a;
                    position3.field_111100_b += position4.field_111100_b - position2.field_111100_b;
                }
                if (n2 > 0) {
                    position3.field_111101_a /= (double)n2;
                    position3.field_111100_b /= (double)n2;
                    double d8 = position3.func_111096_b();
                    if (d8 > 0.0) {
                        position3.func_111095_a();
                        position2.func_111094_b(position3);
                    } else {
                        position2.func_111097_a(random, d2, d3, d4, d5);
                    }
                    bl2 = true;
                }
                if (!position2.func_111093_a(d2, d3, d4, d5)) continue;
                bl2 = true;
            }
            if (bl2) continue;
            for (Position position3 : positionArray) {
                if (position3.func_111098_b(world2)) continue;
                position3.func_111097_a(random, d2, d3, d4, d5);
                bl2 = true;
            }
        }
        if (n >= 10000) {
            throw new CommandException("commands.spreadplayers.failure." + (bl ? "teams" : "players"), positionArray.length, position.field_111101_a, position.field_111100_b, String.format("%.2f", d6));
        }
        return n;
    }

    private double func_110671_a(List<Entity> list, World world2, Position[] positionArray, boolean bl) {
        double d = 0.0;
        int n = 0;
        HashMap<Team, Position> hashMap = Maps.newHashMap();
        for (int i = 0; i < list.size(); ++i) {
            Position position;
            Entity entity = list.get(i);
            if (bl) {
                Team team;
                Team team2 = team = entity instanceof EntityPlayer ? ((EntityPlayer)entity).getTeam() : null;
                if (!hashMap.containsKey(team)) {
                    hashMap.put(team, positionArray[n++]);
                }
                position = (Position)hashMap.get(team);
            } else {
                position = positionArray[n++];
            }
            entity.setPositionAndUpdate((float)MathHelper.floor_double(position.field_111101_a) + 0.5f, position.func_111092_a(world2), (double)MathHelper.floor_double(position.field_111100_b) + 0.5);
            double d2 = Double.MAX_VALUE;
            for (int j = 0; j < positionArray.length; ++j) {
                if (position == positionArray[j]) continue;
                double d3 = position.func_111099_a(positionArray[j]);
                d2 = Math.min(d3, d2);
            }
            d += d2;
        }
        return d /= (double)list.size();
    }

    private Position[] func_110670_a(Random random, int n, double d, double d2, double d3, double d4) {
        Position[] positionArray = new Position[n];
        for (int i = 0; i < positionArray.length; ++i) {
            Position position = new Position();
            position.func_111097_a(random, d, d2, d3, d4);
            positionArray[i] = position;
        }
        return positionArray;
    }

    @Override
    public List<String> addTabCompletionOptions(ICommandSender iCommandSender, String[] stringArray, BlockPos blockPos) {
        return stringArray.length >= 1 && stringArray.length <= 2 ? CommandSpreadPlayers.func_181043_b(stringArray, 0, blockPos) : null;
    }

    public static class Position {
        double field_111101_a;
        double field_111100_b;

        Position() {
        }

        Position(double d, double d2) {
            this.field_111101_a = d;
            this.field_111100_b = d2;
        }

        double func_111099_a(Position position) {
            double d = this.field_111101_a - position.field_111101_a;
            double d2 = this.field_111100_b - position.field_111100_b;
            return Math.sqrt(d * d + d2 * d2);
        }

        void func_111095_a() {
            double d = this.func_111096_b();
            this.field_111101_a /= d;
            this.field_111100_b /= d;
        }

        float func_111096_b() {
            return MathHelper.sqrt_double(this.field_111101_a * this.field_111101_a + this.field_111100_b * this.field_111100_b);
        }

        public void func_111094_b(Position position) {
            this.field_111101_a -= position.field_111101_a;
            this.field_111100_b -= position.field_111100_b;
        }

        public boolean func_111093_a(double d, double d2, double d3, double d4) {
            boolean bl = false;
            if (this.field_111101_a < d) {
                this.field_111101_a = d;
                bl = true;
            } else if (this.field_111101_a > d3) {
                this.field_111101_a = d3;
                bl = true;
            }
            if (this.field_111100_b < d2) {
                this.field_111100_b = d2;
                bl = true;
            } else if (this.field_111100_b > d4) {
                this.field_111100_b = d4;
                bl = true;
            }
            return bl;
        }

        public int func_111092_a(World world2) {
            BlockPos blockPos = new BlockPos(this.field_111101_a, 256.0, this.field_111100_b);
            while (blockPos.getY() > 0) {
                if (world2.getBlockState(blockPos = blockPos.down()).getBlock().getMaterial() == Material.air) continue;
                return blockPos.getY() + 1;
            }
            return 257;
        }

        public boolean func_111098_b(World world2) {
            BlockPos blockPos = new BlockPos(this.field_111101_a, 256.0, this.field_111100_b);
            while (blockPos.getY() > 0) {
                Material material = world2.getBlockState(blockPos = blockPos.down()).getBlock().getMaterial();
                if (material == Material.air) continue;
                return !material.isLiquid() && material != Material.fire;
            }
            return false;
        }

        public void func_111097_a(Random random, double d, double d2, double d3, double d4) {
            this.field_111101_a = MathHelper.getRandomDoubleInRange(random, d, d3);
            this.field_111100_b = MathHelper.getRandomDoubleInRange(random, d2, d4);
        }
    }
}

