/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.command;

import com.google.common.base.Functions;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.primitives.Doubles;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import net.minecraft.block.Block;
import net.minecraft.command.CommandException;
import net.minecraft.command.EntityNotFoundException;
import net.minecraft.command.IAdminCommand;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.NumberInvalidException;
import net.minecraft.command.PlayerNotFoundException;
import net.minecraft.command.PlayerSelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.ResourceLocation;

public abstract class CommandBase
implements ICommand {
    private static IAdminCommand theAdmin;

    public int getRequiredPermissionLevel() {
        return 4;
    }

    @Override
    public List<String> getCommandAliases() {
        return Collections.emptyList();
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender iCommandSender) {
        return iCommandSender.canCommandSenderUseCommand(this.getRequiredPermissionLevel(), this.getCommandName());
    }

    @Override
    public List<String> addTabCompletionOptions(ICommandSender iCommandSender, String[] stringArray, BlockPos blockPos) {
        return null;
    }

    public static int parseInt(String string) throws NumberInvalidException {
        try {
            return Integer.parseInt(string);
        }
        catch (NumberFormatException numberFormatException) {
            throw new NumberInvalidException("commands.generic.num.invalid", string);
        }
    }

    public static int parseInt(String string, int n) throws NumberInvalidException {
        return CommandBase.parseInt(string, n, Integer.MAX_VALUE);
    }

    public static int parseInt(String string, int n, int n2) throws NumberInvalidException {
        int n3 = CommandBase.parseInt(string);
        if (n3 < n) {
            throw new NumberInvalidException("commands.generic.num.tooSmall", n3, n);
        }
        if (n3 > n2) {
            throw new NumberInvalidException("commands.generic.num.tooBig", n3, n2);
        }
        return n3;
    }

    public static long parseLong(String string) throws NumberInvalidException {
        try {
            return Long.parseLong(string);
        }
        catch (NumberFormatException numberFormatException) {
            throw new NumberInvalidException("commands.generic.num.invalid", string);
        }
    }

    public static long parseLong(String string, long l, long l2) throws NumberInvalidException {
        long l3 = CommandBase.parseLong(string);
        if (l3 < l) {
            throw new NumberInvalidException("commands.generic.num.tooSmall", l3, l);
        }
        if (l3 > l2) {
            throw new NumberInvalidException("commands.generic.num.tooBig", l3, l2);
        }
        return l3;
    }

    public static BlockPos parseBlockPos(ICommandSender iCommandSender, String[] stringArray, int n, boolean bl) throws NumberInvalidException {
        BlockPos blockPos = iCommandSender.getPosition();
        return new BlockPos(CommandBase.parseDouble(blockPos.getX(), stringArray[n], -30000000, 30000000, bl), CommandBase.parseDouble(blockPos.getY(), stringArray[n + 1], 0, 256, false), CommandBase.parseDouble(blockPos.getZ(), stringArray[n + 2], -30000000, 30000000, bl));
    }

    public static double parseDouble(String string) throws NumberInvalidException {
        try {
            double d = Double.parseDouble(string);
            if (!Doubles.isFinite(d)) {
                throw new NumberInvalidException("commands.generic.num.invalid", string);
            }
            return d;
        }
        catch (NumberFormatException numberFormatException) {
            throw new NumberInvalidException("commands.generic.num.invalid", string);
        }
    }

    public static double parseDouble(String string, double d) throws NumberInvalidException {
        return CommandBase.parseDouble(string, d, Double.MAX_VALUE);
    }

    public static double parseDouble(String string, double d, double d2) throws NumberInvalidException {
        double d3 = CommandBase.parseDouble(string);
        if (d3 < d) {
            throw new NumberInvalidException("commands.generic.double.tooSmall", d3, d);
        }
        if (d3 > d2) {
            throw new NumberInvalidException("commands.generic.double.tooBig", d3, d2);
        }
        return d3;
    }

    public static boolean parseBoolean(String string) throws CommandException {
        if (!string.equals("true") && !string.equals("1")) {
            if (!string.equals("false") && !string.equals("0")) {
                throw new CommandException("commands.generic.boolean.invalid", string);
            }
            return false;
        }
        return true;
    }

    public static EntityPlayerMP getCommandSenderAsPlayer(ICommandSender iCommandSender) throws PlayerNotFoundException {
        if (iCommandSender instanceof EntityPlayerMP) {
            return (EntityPlayerMP)iCommandSender;
        }
        throw new PlayerNotFoundException("You must specify which player you wish to perform this action on.", new Object[0]);
    }

    public static EntityPlayerMP getPlayer(ICommandSender iCommandSender, String string) throws PlayerNotFoundException {
        EntityPlayerMP entityPlayerMP = PlayerSelector.matchOnePlayer(iCommandSender, string);
        if (entityPlayerMP == null) {
            try {
                entityPlayerMP = MinecraftServer.getServer().getConfigurationManager().getPlayerByUUID(UUID.fromString(string));
            }
            catch (IllegalArgumentException illegalArgumentException) {
                // empty catch block
            }
        }
        if (entityPlayerMP == null) {
            entityPlayerMP = MinecraftServer.getServer().getConfigurationManager().getPlayerByUsername(string);
        }
        if (entityPlayerMP == null) {
            throw new PlayerNotFoundException();
        }
        return entityPlayerMP;
    }

    public static Entity getEntity(ICommandSender iCommandSender, String string) throws EntityNotFoundException {
        return CommandBase.getEntity(iCommandSender, string, Entity.class);
    }

    public static <T extends Entity> T getEntity(ICommandSender iCommandSender, String string, Class<? extends T> clazz) throws EntityNotFoundException {
        Object object = PlayerSelector.matchOneEntity(iCommandSender, string, clazz);
        MinecraftServer minecraftServer = MinecraftServer.getServer();
        if (object == null) {
            object = minecraftServer.getConfigurationManager().getPlayerByUsername(string);
        }
        if (object == null) {
            try {
                UUID uUID = UUID.fromString(string);
                object = minecraftServer.getEntityFromUuid(uUID);
                if (object == null) {
                    object = minecraftServer.getConfigurationManager().getPlayerByUUID(uUID);
                }
            }
            catch (IllegalArgumentException illegalArgumentException) {
                throw new EntityNotFoundException("commands.generic.entity.invalidUuid", new Object[0]);
            }
        }
        if (object != null && clazz.isAssignableFrom(object.getClass())) {
            return (T)object;
        }
        throw new EntityNotFoundException();
    }

    public static List<Entity> func_175763_c(ICommandSender iCommandSender, String string) throws EntityNotFoundException {
        return PlayerSelector.hasArguments(string) ? PlayerSelector.matchEntities(iCommandSender, string, Entity.class) : Lists.newArrayList(CommandBase.getEntity(iCommandSender, string));
    }

    public static String getPlayerName(ICommandSender iCommandSender, String string) throws PlayerNotFoundException {
        try {
            return CommandBase.getPlayer(iCommandSender, string).getName();
        }
        catch (PlayerNotFoundException playerNotFoundException) {
            if (PlayerSelector.hasArguments(string)) {
                throw playerNotFoundException;
            }
            return string;
        }
    }

    public static String getEntityName(ICommandSender iCommandSender, String string) throws EntityNotFoundException {
        try {
            return CommandBase.getPlayer(iCommandSender, string).getName();
        }
        catch (PlayerNotFoundException playerNotFoundException) {
            try {
                return CommandBase.getEntity(iCommandSender, string).getUniqueID().toString();
            }
            catch (EntityNotFoundException entityNotFoundException) {
                if (PlayerSelector.hasArguments(string)) {
                    throw entityNotFoundException;
                }
                return string;
            }
        }
    }

    public static IChatComponent getChatComponentFromNthArg(ICommandSender iCommandSender, String[] stringArray, int n) throws CommandException, PlayerNotFoundException {
        return CommandBase.getChatComponentFromNthArg(iCommandSender, stringArray, n, false);
    }

    public static IChatComponent getChatComponentFromNthArg(ICommandSender iCommandSender, String[] stringArray, int n, boolean bl) throws PlayerNotFoundException {
        ChatComponentText chatComponentText = new ChatComponentText("");
        for (int i = n; i < stringArray.length; ++i) {
            if (i > n) {
                chatComponentText.appendText(" ");
            }
            IChatComponent iChatComponent = new ChatComponentText(stringArray[i]);
            if (bl) {
                IChatComponent iChatComponent2 = PlayerSelector.matchEntitiesToChatComponent(iCommandSender, stringArray[i]);
                if (iChatComponent2 == null) {
                    if (PlayerSelector.hasArguments(stringArray[i])) {
                        throw new PlayerNotFoundException();
                    }
                } else {
                    iChatComponent = iChatComponent2;
                }
            }
            chatComponentText.appendSibling(iChatComponent);
        }
        return chatComponentText;
    }

    public static String buildString(String[] stringArray, int n) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = n; i < stringArray.length; ++i) {
            if (i > n) {
                stringBuilder.append(" ");
            }
            String string = stringArray[i];
            stringBuilder.append(string);
        }
        return stringBuilder.toString();
    }

    public static CoordinateArg parseCoordinate(double d, String string, boolean bl) throws NumberInvalidException {
        return CommandBase.parseCoordinate(d, string, -30000000, 30000000, bl);
    }

    public static CoordinateArg parseCoordinate(double d, String string, int n, int n2, boolean bl) throws NumberInvalidException {
        boolean bl2 = string.startsWith("~");
        if (bl2 && Double.isNaN(d)) {
            throw new NumberInvalidException("commands.generic.num.invalid", d);
        }
        double d2 = 0.0;
        if (!bl2 || string.length() > 1) {
            boolean bl3 = string.contains(".");
            if (bl2) {
                string = string.substring(1);
            }
            d2 += CommandBase.parseDouble(string);
            if (!bl3 && !bl2 && bl) {
                d2 += 0.5;
            }
        }
        if (n != 0 || n2 != 0) {
            if (d2 < (double)n) {
                throw new NumberInvalidException("commands.generic.double.tooSmall", d2, n);
            }
            if (d2 > (double)n2) {
                throw new NumberInvalidException("commands.generic.double.tooBig", d2, n2);
            }
        }
        return new CoordinateArg(d2 + (bl2 ? d : 0.0), d2, bl2);
    }

    public static double parseDouble(double d, String string, boolean bl) throws NumberInvalidException {
        return CommandBase.parseDouble(d, string, -30000000, 30000000, bl);
    }

    public static double parseDouble(double d, String string, int n, int n2, boolean bl) throws NumberInvalidException {
        double d2;
        boolean bl2 = string.startsWith("~");
        if (bl2 && Double.isNaN(d)) {
            throw new NumberInvalidException("commands.generic.num.invalid", d);
        }
        double d3 = d2 = bl2 ? d : 0.0;
        if (!bl2 || string.length() > 1) {
            boolean bl3 = string.contains(".");
            if (bl2) {
                string = string.substring(1);
            }
            d2 += CommandBase.parseDouble(string);
            if (!bl3 && !bl2 && bl) {
                d2 += 0.5;
            }
        }
        if (n != 0 || n2 != 0) {
            if (d2 < (double)n) {
                throw new NumberInvalidException("commands.generic.double.tooSmall", d2, n);
            }
            if (d2 > (double)n2) {
                throw new NumberInvalidException("commands.generic.double.tooBig", d2, n2);
            }
        }
        return d2;
    }

    public static Item getItemByText(ICommandSender iCommandSender, String string) throws NumberInvalidException {
        ResourceLocation resourceLocation = new ResourceLocation(string);
        Item item = Item.itemRegistry.getObject(resourceLocation);
        if (item == null) {
            throw new NumberInvalidException("commands.give.item.notFound", resourceLocation);
        }
        return item;
    }

    public static Block getBlockByText(ICommandSender iCommandSender, String string) throws NumberInvalidException {
        ResourceLocation resourceLocation = new ResourceLocation(string);
        if (!Block.blockRegistry.containsKey(resourceLocation)) {
            throw new NumberInvalidException("commands.give.block.notFound", resourceLocation);
        }
        Block block = Block.blockRegistry.getObject(resourceLocation);
        if (block == null) {
            throw new NumberInvalidException("commands.give.block.notFound", resourceLocation);
        }
        return block;
    }

    public static String joinNiceString(Object[] objectArray) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < objectArray.length; ++i) {
            String string = objectArray[i].toString();
            if (i > 0) {
                if (i == objectArray.length - 1) {
                    stringBuilder.append(" and ");
                } else {
                    stringBuilder.append(", ");
                }
            }
            stringBuilder.append(string);
        }
        return stringBuilder.toString();
    }

    public static IChatComponent join(List<IChatComponent> list) {
        ChatComponentText chatComponentText = new ChatComponentText("");
        for (int i = 0; i < list.size(); ++i) {
            if (i > 0) {
                if (i == list.size() - 1) {
                    chatComponentText.appendText(" and ");
                } else if (i > 0) {
                    chatComponentText.appendText(", ");
                }
            }
            chatComponentText.appendSibling(list.get(i));
        }
        return chatComponentText;
    }

    public static String joinNiceStringFromCollection(Collection<String> collection) {
        return CommandBase.joinNiceString(collection.toArray(new String[collection.size()]));
    }

    public static List<String> func_175771_a(String[] stringArray, int n, BlockPos blockPos) {
        String string;
        if (blockPos == null) {
            return null;
        }
        int n2 = stringArray.length - 1;
        if (n2 == n) {
            string = Integer.toString(blockPos.getX());
        } else if (n2 == n + 1) {
            string = Integer.toString(blockPos.getY());
        } else {
            if (n2 != n + 2) {
                return null;
            }
            string = Integer.toString(blockPos.getZ());
        }
        return Lists.newArrayList(string);
    }

    public static List<String> func_181043_b(String[] stringArray, int n, BlockPos blockPos) {
        String string;
        if (blockPos == null) {
            return null;
        }
        int n2 = stringArray.length - 1;
        if (n2 == n) {
            string = Integer.toString(blockPos.getX());
        } else {
            if (n2 != n + 1) {
                return null;
            }
            string = Integer.toString(blockPos.getZ());
        }
        return Lists.newArrayList(string);
    }

    public static boolean doesStringStartWith(String string, String string2) {
        return string2.regionMatches(true, 0, string, 0, string.length());
    }

    public static List<String> getListOfStringsMatchingLastWord(String[] stringArray, String ... stringArray2) {
        return CommandBase.getListOfStringsMatchingLastWord(stringArray, Arrays.asList(stringArray2));
    }

    public static List<String> getListOfStringsMatchingLastWord(String[] stringArray, Collection<?> collection) {
        String string = stringArray[stringArray.length - 1];
        ArrayList<String> arrayList = Lists.newArrayList();
        if (!collection.isEmpty()) {
            for (String string2 : Iterables.transform(collection, Functions.toStringFunction())) {
                if (!CommandBase.doesStringStartWith(string, string2)) continue;
                arrayList.add(string2);
            }
            if (arrayList.isEmpty()) {
                for (String string2 : collection) {
                    if (!(string2 instanceof ResourceLocation) || !CommandBase.doesStringStartWith(string, ((ResourceLocation)((Object)string2)).getResourcePath())) continue;
                    arrayList.add(String.valueOf(string2));
                }
            }
        }
        return arrayList;
    }

    @Override
    public boolean isUsernameIndex(String[] stringArray, int n) {
        return false;
    }

    public static void notifyOperators(ICommandSender iCommandSender, ICommand iCommand, String string, Object ... objectArray) {
        CommandBase.notifyOperators(iCommandSender, iCommand, 0, string, objectArray);
    }

    public static void notifyOperators(ICommandSender iCommandSender, ICommand iCommand, int n, String string, Object ... objectArray) {
        if (theAdmin != null) {
            theAdmin.notifyOperators(iCommandSender, iCommand, n, string, objectArray);
        }
    }

    public static void setAdminCommander(IAdminCommand iAdminCommand) {
        theAdmin = iAdminCommand;
    }

    @Override
    public int compareTo(ICommand iCommand) {
        return this.getCommandName().compareTo(iCommand.getCommandName());
    }

    public static class CoordinateArg {
        private final double field_179633_a;
        private final double field_179631_b;
        private final boolean field_179632_c;

        protected CoordinateArg(double d, double d2, boolean bl) {
            this.field_179633_a = d;
            this.field_179631_b = d2;
            this.field_179632_c = bl;
        }

        public double func_179628_a() {
            return this.field_179633_a;
        }

        public double func_179629_b() {
            return this.field_179631_b;
        }

        public boolean func_179630_c() {
            return this.field_179632_c;
        }
    }
}

