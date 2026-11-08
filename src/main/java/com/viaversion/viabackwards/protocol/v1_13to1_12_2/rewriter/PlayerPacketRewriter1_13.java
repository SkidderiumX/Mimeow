/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_13to1_12_2.rewriter;

import com.google.common.base.Joiner;
import com.viaversion.viabackwards.ViaBackwards;
import com.viaversion.viabackwards.protocol.v1_13to1_12_2.Protocol1_13To1_12_2;
import com.viaversion.viabackwards.protocol.v1_13to1_12_2.data.ParticleIdMappings1_12_2;
import com.viaversion.viabackwards.protocol.v1_13to1_12_2.storage.TabCompleteStorage;
import com.viaversion.viabackwards.utils.ChatUtil;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.packet.State;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.rewriter.RewriterBase;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.protocols.base.ClientboundLoginPackets;
import com.viaversion.viaversion.protocols.base.ServerboundLoginPackets;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.packet.ClientboundPackets1_13;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.packet.ServerboundPackets1_13;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.rewriter.ItemPacketRewriter1_13;
import com.viaversion.viaversion.protocols.v1_12to1_12_1.packet.ClientboundPackets1_12_1;
import com.viaversion.viaversion.protocols.v1_12to1_12_1.packet.ServerboundPackets1_12_1;
import com.viaversion.viaversion.rewriter.CommandRewriter;
import com.viaversion.viaversion.util.Key;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class PlayerPacketRewriter1_13
extends RewriterBase<Protocol1_13To1_12_2> {
    private final CommandRewriter<ClientboundPackets1_13> commandRewriter;

    public PlayerPacketRewriter1_13(Protocol1_13To1_12_2 protocol1_13To1_12_2) {
        super(protocol1_13To1_12_2);
        this.commandRewriter = new CommandRewriter(this.protocol);
    }

    @Override
    protected void registerPackets() {
        ((Protocol1_13To1_12_2)this.protocol).registerClientbound(State.LOGIN, ClientboundLoginPackets.CUSTOM_QUERY.getId(), -1, new PacketHandlers(){

            @Override
            public void register() {
                this.handler(packetWrapper -> {
                    packetWrapper.cancel();
                    packetWrapper.create(ServerboundLoginPackets.CUSTOM_QUERY_ANSWER.getId(), packetWrapper2 -> {
                        packetWrapper2.write(Types.VAR_INT, packetWrapper.read(Types.VAR_INT));
                        packetWrapper2.write(Types.BOOLEAN, false);
                    }).sendToServer(Protocol1_13To1_12_2.class);
                });
            }
        });
        ((Protocol1_13To1_12_2)this.protocol).registerClientbound(ClientboundPackets1_13.CUSTOM_PAYLOAD, packetWrapper -> {
            String string = packetWrapper.read(Types.STRING);
            if (string.equals("minecraft:trader_list")) {
                packetWrapper.write(Types.STRING, "MC|TrList");
                ((Protocol1_13To1_12_2)this.protocol).getItemRewriter().handleTradeList(packetWrapper);
            } else {
                String string2 = ItemPacketRewriter1_13.getOldPluginChannelId(string);
                if (string2 == null) {
                    if (Via.getConfig().logOtherConversionWarnings()) {
                        ((Protocol1_13To1_12_2)this.protocol).getLogger().warning("Ignoring clientbound plugin message with channel: " + string);
                    }
                    packetWrapper.cancel();
                    return;
                }
                packetWrapper.write(Types.STRING, string2);
                if (string2.equals("REGISTER") || string2.equals("UNREGISTER")) {
                    String[] stringArray = new String(packetWrapper.read(Types.REMAINING_BYTES), StandardCharsets.UTF_8).split("\u0000");
                    ArrayList<String> arrayList = new ArrayList<String>();
                    for (String string3 : stringArray) {
                        String string4 = ItemPacketRewriter1_13.getOldPluginChannelId(string3);
                        if (string4 != null) {
                            arrayList.add(string4);
                            continue;
                        }
                        if (!Via.getConfig().logOtherConversionWarnings()) continue;
                        ((Protocol1_13To1_12_2)this.protocol).getLogger().warning("Ignoring plugin channel in clientbound " + string2 + ": " + string3);
                    }
                    packetWrapper.write(Types.REMAINING_BYTES, Joiner.on('\u0000').join(arrayList).getBytes(StandardCharsets.UTF_8));
                }
            }
        });
        ((Protocol1_13To1_12_2)this.protocol).registerClientbound(ClientboundPackets1_13.LEVEL_PARTICLES, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.map(Types.BOOLEAN);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.INT);
                this.handler(packetWrapper -> {
                    ParticleIdMappings1_12_2.ParticleData particleData = ParticleIdMappings1_12_2.getMapping(packetWrapper.get(Types.INT, 0));
                    packetWrapper.set(Types.INT, 0, particleData.getHistoryId());
                    int[] nArray = particleData.rewriteData((Protocol1_13To1_12_2)PlayerPacketRewriter1_13.this.protocol, packetWrapper);
                    if (nArray != null) {
                        if (particleData.getHandler().isBlockHandler() && nArray[0] == 0) {
                            packetWrapper.cancel();
                            return;
                        }
                        for (int n : nArray) {
                            packetWrapper.write(Types.VAR_INT, n);
                        }
                    }
                });
            }
        });
        ((Protocol1_13To1_12_2)this.protocol).registerClientbound(ClientboundPackets1_13.PLAYER_INFO, new PacketHandlers(){

            @Override
            public void register() {
                this.handler(packetWrapper -> {
                    TabCompleteStorage tabCompleteStorage = packetWrapper.user().get(TabCompleteStorage.class);
                    int n = packetWrapper.passthrough(Types.VAR_INT);
                    int n2 = packetWrapper.passthrough(Types.VAR_INT);
                    for (int i = 0; i < n2; ++i) {
                        UUID uUID = packetWrapper.passthrough(Types.UUID);
                        if (n == 0) {
                            String string = packetWrapper.passthrough(Types.STRING);
                            tabCompleteStorage.usernames().put(uUID, string);
                            packetWrapper.passthrough(Types.PROFILE_PROPERTY_ARRAY);
                            packetWrapper.passthrough(Types.VAR_INT);
                            packetWrapper.passthrough(Types.VAR_INT);
                            packetWrapper.passthrough(Types.OPTIONAL_COMPONENT);
                            continue;
                        }
                        if (n == 1) {
                            packetWrapper.passthrough(Types.VAR_INT);
                            continue;
                        }
                        if (n == 2) {
                            packetWrapper.passthrough(Types.VAR_INT);
                            continue;
                        }
                        if (n == 3) {
                            packetWrapper.passthrough(Types.OPTIONAL_COMPONENT);
                            continue;
                        }
                        if (n != 4) continue;
                        tabCompleteStorage.usernames().remove(uUID);
                    }
                });
            }
        });
        ((Protocol1_13To1_12_2)this.protocol).registerClientbound(ClientboundPackets1_13.SET_OBJECTIVE, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.map(Types.BYTE);
                this.handler(packetWrapper -> {
                    byte by = packetWrapper.get(Types.BYTE, 0);
                    if (by == 0 || by == 2) {
                        JsonElement jsonElement = packetWrapper.read(Types.COMPONENT);
                        String string = ((Protocol1_13To1_12_2)PlayerPacketRewriter1_13.this.protocol).jsonToLegacy(packetWrapper.user(), jsonElement);
                        packetWrapper.write(Types.STRING, ChatUtil.fromLegacy(string, 'f', 32));
                        int n = packetWrapper.read(Types.VAR_INT);
                        packetWrapper.write(Types.STRING, n == 1 ? "hearts" : "integer");
                    }
                });
            }
        });
        ((Protocol1_13To1_12_2)this.protocol).registerClientbound(ClientboundPackets1_13.SET_PLAYER_TEAM, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.map(Types.BYTE);
                this.handler(packetWrapper -> {
                    byte by = packetWrapper.get(Types.BYTE, 0);
                    if (by == 0 || by == 2) {
                        JsonElement jsonElement = packetWrapper.read(Types.COMPONENT);
                        String string = ((Protocol1_13To1_12_2)PlayerPacketRewriter1_13.this.protocol).jsonToLegacy(packetWrapper.user(), jsonElement);
                        packetWrapper.write(Types.STRING, ChatUtil.fromLegacy(string, 'f', 32));
                        byte by2 = packetWrapper.read(Types.BYTE);
                        String string2 = packetWrapper.read(Types.STRING);
                        String string3 = packetWrapper.read(Types.STRING);
                        int n = packetWrapper.read(Types.VAR_INT);
                        if (n == 21) {
                            n = -1;
                        }
                        JsonElement jsonElement2 = packetWrapper.read(Types.COMPONENT);
                        JsonElement jsonElement3 = packetWrapper.read(Types.COMPONENT);
                        Object object = ((Protocol1_13To1_12_2)PlayerPacketRewriter1_13.this.protocol).jsonToLegacy(packetWrapper.user(), jsonElement2);
                        if (ViaBackwards.getConfig().addTeamColorTo1_13Prefix()) {
                            object = (String)object + "\u00a7" + (n > -1 && n <= 15 ? Integer.toHexString(n) : "r");
                        }
                        String string4 = ((Protocol1_13To1_12_2)PlayerPacketRewriter1_13.this.protocol).jsonToLegacy(packetWrapper.user(), jsonElement3);
                        packetWrapper.write(Types.STRING, ChatUtil.fromLegacyPrefix((String)object, 'f', 16));
                        packetWrapper.write(Types.STRING, ChatUtil.fromLegacy(string4, '\u0000', 16));
                        packetWrapper.write(Types.BYTE, by2);
                        packetWrapper.write(Types.STRING, string2);
                        packetWrapper.write(Types.STRING, string3);
                        packetWrapper.write(Types.BYTE, (byte)n);
                    }
                    if (by == 0 || by == 3 || by == 4) {
                        packetWrapper.passthrough(Types.STRING_ARRAY);
                    }
                });
            }
        });
        ((Protocol1_13To1_12_2)this.protocol).registerClientbound(ClientboundPackets1_13.COMMANDS, null, packetWrapper -> {
            packetWrapper.cancel();
            TabCompleteStorage tabCompleteStorage = packetWrapper.user().get(TabCompleteStorage.class);
            if (!tabCompleteStorage.commands().isEmpty()) {
                tabCompleteStorage.commands().clear();
            }
            int n = packetWrapper.read(Types.VAR_INT);
            boolean bl = true;
            for (int i = 0; i < n; ++i) {
                byte by = packetWrapper.read(Types.BYTE);
                packetWrapper.read(Types.VAR_INT_ARRAY_PRIMITIVE);
                if ((by & 8) != 0) {
                    packetWrapper.read(Types.VAR_INT);
                }
                byte by2 = (byte)(by & 3);
                if (bl && by2 == 2) {
                    bl = false;
                }
                if (by2 == 1 || by2 == 2) {
                    String string = packetWrapper.read(Types.STRING);
                    if (by2 == 1 && bl) {
                        tabCompleteStorage.commands().add("/" + string);
                    }
                }
                if (by2 == 2) {
                    this.commandRewriter.handleArgument(packetWrapper, packetWrapper.read(Types.STRING));
                }
                if ((by & 0x10) == 0) continue;
                packetWrapper.read(Types.STRING);
            }
        });
        ((Protocol1_13To1_12_2)this.protocol).registerClientbound(ClientboundPackets1_13.COMMAND_SUGGESTIONS, packetWrapper -> {
            TabCompleteStorage tabCompleteStorage = packetWrapper.user().get(TabCompleteStorage.class);
            if (tabCompleteStorage.lastRequest() == null) {
                packetWrapper.cancel();
                return;
            }
            if (tabCompleteStorage.lastId() != packetWrapper.read(Types.VAR_INT).intValue()) {
                packetWrapper.cancel();
            }
            int n = packetWrapper.read(Types.VAR_INT);
            int n2 = packetWrapper.read(Types.VAR_INT);
            int n3 = tabCompleteStorage.lastRequest().lastIndexOf(32) + 1;
            if (n3 != n) {
                packetWrapper.cancel();
            }
            if (n2 != tabCompleteStorage.lastRequest().length() - n3) {
                packetWrapper.cancel();
            }
            int n4 = packetWrapper.passthrough(Types.VAR_INT);
            for (int i = 0; i < n4; ++i) {
                String string = packetWrapper.read(Types.STRING);
                packetWrapper.write(Types.STRING, (n == 0 && !tabCompleteStorage.isLastAssumeCommand() ? "/" : "") + string);
                packetWrapper.read(Types.OPTIONAL_COMPONENT);
            }
        });
        ((Protocol1_13To1_12_2)this.protocol).registerServerbound(ServerboundPackets1_12_1.COMMAND_SUGGESTION, packetWrapper -> {
            Object object;
            TabCompleteStorage tabCompleteStorage = packetWrapper.user().get(TabCompleteStorage.class);
            ArrayList<String> arrayList = new ArrayList<String>();
            String string = packetWrapper.read(Types.STRING);
            boolean bl = packetWrapper.read(Types.BOOLEAN);
            packetWrapper.read(Types.OPTIONAL_POSITION1_8);
            if (!bl && !string.startsWith("/")) {
                object = string.substring(string.lastIndexOf(32) + 1);
                for (String string2 : tabCompleteStorage.usernames().values()) {
                    if (!PlayerPacketRewriter1_13.startsWithIgnoreCase(string2, (String)object)) continue;
                    arrayList.add(string2);
                }
            } else if (!tabCompleteStorage.commands().isEmpty() && !string.contains(" ")) {
                for (String string3 : tabCompleteStorage.commands()) {
                    if (!PlayerPacketRewriter1_13.startsWithIgnoreCase(string3, string)) continue;
                    arrayList.add(string3);
                }
            }
            if (!arrayList.isEmpty()) {
                packetWrapper.cancel();
                object = packetWrapper.create(ClientboundPackets1_12_1.COMMAND_SUGGESTIONS);
                object.write(Types.VAR_INT, arrayList.size());
                for (String string4 : arrayList) {
                    object.write(Types.STRING, string4);
                }
                object.scheduleSend(Protocol1_13To1_12_2.class);
                tabCompleteStorage.setLastRequest(null);
                return;
            }
            if (!bl && string.startsWith("/")) {
                string = string.substring(1);
            }
            int n = ThreadLocalRandom.current().nextInt();
            packetWrapper.write(Types.VAR_INT, n);
            packetWrapper.write(Types.STRING, string);
            tabCompleteStorage.setLastId(n);
            tabCompleteStorage.setLastAssumeCommand(bl);
            tabCompleteStorage.setLastRequest(string);
        });
        ((Protocol1_13To1_12_2)this.protocol).registerServerbound(ServerboundPackets1_12_1.CUSTOM_PAYLOAD, packetWrapper -> {
            String string;
            switch (string = packetWrapper.read(Types.STRING)) {
                case "MC|BSign": 
                case "MC|BEdit": {
                    packetWrapper.setPacketType(ServerboundPackets1_13.EDIT_BOOK);
                    Item item = packetWrapper.read(Types.ITEM1_8);
                    packetWrapper.write(Types.ITEM1_13, ((Protocol1_13To1_12_2)this.protocol).getItemRewriter().handleItemToServer(packetWrapper.user(), item));
                    boolean bl = string.equals("MC|BSign");
                    packetWrapper.write(Types.BOOLEAN, bl);
                    break;
                }
                case "MC|ItemName": {
                    packetWrapper.setPacketType(ServerboundPackets1_13.RENAME_ITEM);
                    break;
                }
                case "MC|AdvCmd": {
                    byte by = packetWrapper.read(Types.BYTE);
                    if (by == 0) {
                        packetWrapper.setPacketType(ServerboundPackets1_13.SET_COMMAND_BLOCK);
                        packetWrapper.cancel();
                        if (!Via.getConfig().logOtherConversionWarnings()) break;
                        ((Protocol1_13To1_12_2)this.protocol).getLogger().warning("Client send MC|AdvCmd custom payload to update command block, weird!");
                        break;
                    }
                    if (by == 1) {
                        packetWrapper.setPacketType(ServerboundPackets1_13.SET_COMMAND_MINECART);
                        packetWrapper.write(Types.VAR_INT, packetWrapper.read(Types.INT));
                        packetWrapper.passthrough(Types.STRING);
                        packetWrapper.passthrough(Types.BOOLEAN);
                        break;
                    }
                    packetWrapper.cancel();
                    break;
                }
                case "MC|AutoCmd": {
                    String string2;
                    packetWrapper.setPacketType(ServerboundPackets1_13.SET_COMMAND_BLOCK);
                    int n = packetWrapper.read(Types.INT);
                    int n2 = packetWrapper.read(Types.INT);
                    int n3 = packetWrapper.read(Types.INT);
                    packetWrapper.write(Types.BLOCK_POSITION1_8, new BlockPosition(n, (short)n2, n3));
                    packetWrapper.passthrough(Types.STRING);
                    byte by = 0;
                    if (packetWrapper.read(Types.BOOLEAN).booleanValue()) {
                        by = (byte)(by | 1);
                    }
                    int n4 = (string2 = packetWrapper.read(Types.STRING)).equals("SEQUENCE") ? 0 : (string2.equals("AUTO") ? 1 : 2);
                    packetWrapper.write(Types.VAR_INT, n4);
                    if (packetWrapper.read(Types.BOOLEAN).booleanValue()) {
                        by = (byte)(by | 2);
                    }
                    if (packetWrapper.read(Types.BOOLEAN).booleanValue()) {
                        by = (byte)(by | 4);
                    }
                    packetWrapper.write(Types.BYTE, by);
                    break;
                }
                case "MC|Struct": {
                    packetWrapper.setPacketType(ServerboundPackets1_13.SET_STRUCTURE_BLOCK);
                    int n = packetWrapper.read(Types.INT);
                    int n5 = packetWrapper.read(Types.INT);
                    int n6 = packetWrapper.read(Types.INT);
                    packetWrapper.write(Types.BLOCK_POSITION1_8, new BlockPosition(n, (short)n5, n6));
                    packetWrapper.write(Types.VAR_INT, packetWrapper.read(Types.BYTE) - 1);
                    String string3 = packetWrapper.read(Types.STRING);
                    int n7 = string3.equals("SAVE") ? 0 : (string3.equals("LOAD") ? 1 : (string3.equals("CORNER") ? 2 : 3));
                    packetWrapper.write(Types.VAR_INT, n7);
                    packetWrapper.passthrough(Types.STRING);
                    packetWrapper.write(Types.BYTE, packetWrapper.read(Types.INT).byteValue());
                    packetWrapper.write(Types.BYTE, packetWrapper.read(Types.INT).byteValue());
                    packetWrapper.write(Types.BYTE, packetWrapper.read(Types.INT).byteValue());
                    packetWrapper.write(Types.BYTE, packetWrapper.read(Types.INT).byteValue());
                    packetWrapper.write(Types.BYTE, packetWrapper.read(Types.INT).byteValue());
                    packetWrapper.write(Types.BYTE, packetWrapper.read(Types.INT).byteValue());
                    String string4 = packetWrapper.read(Types.STRING);
                    int n8 = string3.equals("NONE") ? 0 : (string3.equals("LEFT_RIGHT") ? 1 : 2);
                    String string5 = packetWrapper.read(Types.STRING);
                    int n9 = string3.equals("NONE") ? 0 : (string3.equals("CLOCKWISE_90") ? 1 : (string3.equals("CLOCKWISE_180") ? 2 : 3));
                    packetWrapper.passthrough(Types.STRING);
                    byte by = 0;
                    if (packetWrapper.read(Types.BOOLEAN).booleanValue()) {
                        by = (byte)(by | 1);
                    }
                    if (packetWrapper.read(Types.BOOLEAN).booleanValue()) {
                        by = (byte)(by | 2);
                    }
                    if (packetWrapper.read(Types.BOOLEAN).booleanValue()) {
                        by = (byte)(by | 4);
                    }
                    packetWrapper.passthrough(Types.FLOAT);
                    packetWrapper.passthrough(Types.VAR_LONG);
                    packetWrapper.write(Types.BYTE, by);
                    break;
                }
                case "MC|Beacon": {
                    packetWrapper.setPacketType(ServerboundPackets1_13.SET_BEACON);
                    packetWrapper.write(Types.VAR_INT, packetWrapper.read(Types.INT));
                    packetWrapper.write(Types.VAR_INT, packetWrapper.read(Types.INT));
                    break;
                }
                case "MC|TrSel": {
                    packetWrapper.setPacketType(ServerboundPackets1_13.SELECT_TRADE);
                    packetWrapper.write(Types.VAR_INT, packetWrapper.read(Types.INT));
                    break;
                }
                case "MC|PickItem": {
                    packetWrapper.setPacketType(ServerboundPackets1_13.PICK_ITEM);
                    break;
                }
                default: {
                    String string6 = ItemPacketRewriter1_13.getNewPluginChannelId(string);
                    if (string6 == null) {
                        if (Via.getConfig().logOtherConversionWarnings()) {
                            ((Protocol1_13To1_12_2)this.protocol).getLogger().warning("Ignoring serverbound plugin message with channel: " + string);
                        }
                        packetWrapper.cancel();
                        return;
                    }
                    packetWrapper.write(Types.STRING, string6);
                    if (!string6.equals("minecraft:register") && !string6.equals("minecraft:unregister")) break;
                    String[] stringArray = new String(packetWrapper.read(Types.SERVERBOUND_CUSTOM_PAYLOAD_DATA), StandardCharsets.UTF_8).split("\u0000");
                    ArrayList<String> arrayList = new ArrayList<String>();
                    for (String string7 : stringArray) {
                        String string8 = ItemPacketRewriter1_13.getNewPluginChannelId(string7);
                        if (string8 != null) {
                            arrayList.add(string8);
                            continue;
                        }
                        if (!Via.getConfig().logOtherConversionWarnings()) continue;
                        ((Protocol1_13To1_12_2)this.protocol).getLogger().warning("Ignoring plugin channel in serverbound " + Key.stripMinecraftNamespace(string6).toUpperCase(Locale.ROOT) + ": " + string7);
                    }
                    if (!arrayList.isEmpty()) {
                        packetWrapper.write(Types.SERVERBOUND_CUSTOM_PAYLOAD_DATA, Joiner.on('\u0000').join(arrayList).getBytes(StandardCharsets.UTF_8));
                        break;
                    }
                    packetWrapper.cancel();
                }
            }
        });
        ((Protocol1_13To1_12_2)this.protocol).replaceClientbound(ClientboundPackets1_13.AWARD_STATS, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.handler(packetWrapper -> {
                    int n;
                    int n2 = n = packetWrapper.get(Types.VAR_INT, 0).intValue();
                    block4: for (int i = 0; i < n; ++i) {
                        int n3 = packetWrapper.read(Types.VAR_INT);
                        int n4 = packetWrapper.read(Types.VAR_INT);
                        String string = "";
                        switch (n3) {
                            case 0: 
                            case 1: 
                            case 2: 
                            case 3: 
                            case 4: 
                            case 5: 
                            case 6: 
                            case 7: {
                                packetWrapper.read(Types.VAR_INT);
                                --n2;
                                continue block4;
                            }
                            case 8: {
                                string = (String)((Protocol1_13To1_12_2)PlayerPacketRewriter1_13.this.protocol).getMappingData().getStatisticMappings().get(n4);
                                if (string == null) {
                                    packetWrapper.read(Types.VAR_INT);
                                    --n2;
                                    continue block4;
                                }
                            }
                            default: {
                                packetWrapper.write(Types.STRING, string);
                                packetWrapper.passthrough(Types.VAR_INT);
                            }
                        }
                    }
                    if (n2 != n) {
                        packetWrapper.set(Types.VAR_INT, 0, n2);
                    }
                });
            }
        });
    }

    private static boolean startsWithIgnoreCase(String string, String string2) {
        if (string.length() < string2.length()) {
            return false;
        }
        return string.regionMatches(true, 0, string2, 0, string2.length());
    }
}

