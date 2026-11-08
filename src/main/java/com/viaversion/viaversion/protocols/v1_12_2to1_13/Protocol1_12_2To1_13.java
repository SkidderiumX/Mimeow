/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_12_2to1_13;

import com.google.common.collect.Sets;
import com.google.common.primitives.Ints;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.api.minecraft.ClientWorld;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_13;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.platform.providers.ViaProviders;
import com.viaversion.viaversion.api.protocol.AbstractProtocol;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.packet.State;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandler;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.protocol.remapper.ValueTransformer;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.misc.ParticleType;
import com.viaversion.viaversion.api.type.types.version.Types1_13;
import com.viaversion.viaversion.data.entity.EntityTrackerBase;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonObject;
import com.viaversion.viaversion.libs.gson.JsonParseException;
import com.viaversion.viaversion.protocols.base.ClientboundStatusPackets;
import com.viaversion.viaversion.protocols.base.ServerboundLoginPackets;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections.ConnectionData;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections.providers.BlockConnectionProvider;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections.providers.PacketBlockConnectionProvider;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.data.BlockIdData;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.data.MappingData1_13;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.data.RecipeData;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.data.StatisticData;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.data.StatisticMappings1_13;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.packet.ClientboundPackets1_13;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.packet.ServerboundPackets1_13;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.provider.BlockEntityProvider;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.provider.PaintingProvider;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.provider.PlayerLookTargetProvider;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.rewriter.ComponentRewriter1_13;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.rewriter.EntityPacketRewriter1_13;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.rewriter.ItemPacketRewriter1_13;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.rewriter.WorldPacketRewriter1_13;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.storage.BlockConnectionStorage;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.storage.BlockStorage;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.storage.TabCompleteTracker;
import com.viaversion.viaversion.protocols.v1_12to1_12_1.packet.ClientboundPackets1_12_1;
import com.viaversion.viaversion.protocols.v1_12to1_12_1.packet.ServerboundPackets1_12_1;
import com.viaversion.viaversion.util.ChatColorUtil;
import com.viaversion.viaversion.util.ComponentUtil;
import com.viaversion.viaversion.util.GsonUtil;
import com.viaversion.viaversion.util.IdAndData;
import com.viaversion.viaversion.util.ProtocolLogger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;

public class Protocol1_12_2To1_13
extends AbstractProtocol<ClientboundPackets1_12_1, ClientboundPackets1_13, ServerboundPackets1_12_1, ServerboundPackets1_13> {
    public static final MappingData1_13 MAPPINGS = new MappingData1_13();
    public static final ProtocolLogger LOGGER = new ProtocolLogger(Protocol1_12_2To1_13.class);
    private static final Map<Character, Character> SCOREBOARD_TEAM_NAME_REWRITE = new HashMap<Character, Character>();
    private static final Set<Character> FORMATTING_CODES = Sets.newHashSet(Character.valueOf('k'), Character.valueOf('l'), Character.valueOf('m'), Character.valueOf('n'), Character.valueOf('o'), Character.valueOf('r'));
    private final EntityPacketRewriter1_13 entityRewriter = new EntityPacketRewriter1_13(this);
    private final ItemPacketRewriter1_13 itemRewriter = new ItemPacketRewriter1_13(this);
    private final ComponentRewriter1_13<ClientboundPackets1_12_1> componentRewriter = new ComponentRewriter1_13<ClientboundPackets1_12_1>(this);
    public static final PacketHandler POS_TO_3_INT;
    public static final PacketHandler SEND_DECLARE_COMMANDS_AND_TAGS;

    public Protocol1_12_2To1_13() {
        super(ClientboundPackets1_12_1.class, ClientboundPackets1_13.class, ServerboundPackets1_12_1.class, ServerboundPackets1_13.class);
    }

    @Override
    protected void registerPackets() {
        super.registerPackets();
        WorldPacketRewriter1_13.register(this);
        this.registerClientbound(State.STATUS, ClientboundStatusPackets.STATUS_RESPONSE, (PacketHandler)new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.handler(packetWrapper -> {
                    String string = packetWrapper.get(Types.STRING, 0);
                    try {
                        JsonObject jsonObject = GsonUtil.getGson().fromJson(string, JsonObject.class);
                        if (jsonObject.has("favicon")) {
                            jsonObject.addProperty("favicon", jsonObject.get("favicon").getAsString().replace("\n", ""));
                        }
                        packetWrapper.set(Types.STRING, 0, GsonUtil.getGson().toJson(jsonObject));
                    }
                    catch (JsonParseException jsonParseException) {
                        LOGGER.log(Level.SEVERE, "Error transforming status response", jsonParseException);
                    }
                });
            }
        });
        this.registerClientbound(ClientboundPackets1_12_1.AWARD_STATS, packetWrapper -> {
            int n = packetWrapper.read(Types.VAR_INT);
            ArrayList<StatisticData> arrayList = new ArrayList<StatisticData>();
            for (int i = 0; i < n; ++i) {
                String object = packetWrapper.read(Types.STRING);
                String[] stringArray = object.split("\\.");
                int n2 = 0;
                int n3 = -1;
                int n4 = packetWrapper.read(Types.VAR_INT);
                if (stringArray.length == 2) {
                    n2 = 8;
                    var9_12 = StatisticMappings1_13.CUSTOM_STATS.get(object);
                    if (var9_12 != null) {
                        n3 = (Integer)var9_12;
                    } else {
                        LOGGER.warning("Could not find statistic mapping for " + object);
                    }
                } else if (stringArray.length > 2) {
                    switch (var9_12 = stringArray[1]) {
                        case "mineBlock": {
                            int n5 = 0;
                            break;
                        }
                        case "craftItem": {
                            int n5 = 1;
                            break;
                        }
                        case "useItem": {
                            int n5 = 2;
                            break;
                        }
                        case "breakItem": {
                            int n5 = 3;
                            break;
                        }
                        case "pickup": {
                            int n5 = 4;
                            break;
                        }
                        case "drop": {
                            int n5 = 5;
                            break;
                        }
                        case "killEntity": {
                            int n5 = 6;
                            break;
                        }
                        case "entityKilledBy": {
                            int n5 = 7;
                            break;
                        }
                        default: {
                            int n5 = n2 = n2;
                        }
                    }
                }
                if (n3 == -1) continue;
                arrayList.add(new StatisticData(n2, n3, n4));
            }
            packetWrapper.write(Types.VAR_INT, arrayList.size());
            for (StatisticData statisticData : arrayList) {
                packetWrapper.write(Types.VAR_INT, statisticData.categoryId());
                packetWrapper.write(Types.VAR_INT, statisticData.newId());
                packetWrapper.write(Types.VAR_INT, statisticData.value());
            }
        });
        this.registerClientbound(ClientboundPackets1_12_1.COMMAND_SUGGESTIONS, packetWrapper -> {
            int n;
            int n2;
            int n3;
            packetWrapper.write(Types.VAR_INT, packetWrapper.user().get(TabCompleteTracker.class).getTransactionId());
            String string = packetWrapper.user().get(TabCompleteTracker.class).getInput();
            if (string.endsWith(" ") || string.isEmpty()) {
                n3 = string.length();
                n2 = 0;
            } else {
                n3 = n = string.lastIndexOf(32) + 1;
                n2 = string.length() - n;
            }
            packetWrapper.write(Types.VAR_INT, n3);
            packetWrapper.write(Types.VAR_INT, n2);
            n = packetWrapper.passthrough(Types.VAR_INT);
            for (int i = 0; i < n; ++i) {
                String string2 = packetWrapper.read(Types.STRING);
                if (string2.startsWith("/") && n3 == 0) {
                    string2 = string2.substring(1);
                }
                packetWrapper.write(Types.STRING, string2);
                packetWrapper.write(Types.OPTIONAL_COMPONENT, null);
            }
        });
        this.registerClientbound(ClientboundPackets1_12_1.OPEN_SCREEN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.STRING);
                this.handler(packetWrapper -> Protocol1_12_2To1_13.this.componentRewriter.processText(packetWrapper.user(), packetWrapper.passthrough(Types.COMPONENT)));
            }
        });
        this.registerClientbound(ClientboundPackets1_12_1.COOLDOWN, packetWrapper -> {
            int n = packetWrapper.read(Types.VAR_INT);
            int n2 = packetWrapper.read(Types.VAR_INT);
            packetWrapper.cancel();
            if (n == 383) {
                int n3;
                for (int i = 0; i < 44 && (n3 = MAPPINGS.getItemMappings().getNewId(n << 16 | i)) != -1; ++i) {
                    PacketWrapper packetWrapper2 = packetWrapper.create(ClientboundPackets1_13.COOLDOWN);
                    packetWrapper2.write(Types.VAR_INT, n3);
                    packetWrapper2.write(Types.VAR_INT, n2);
                    packetWrapper2.send(Protocol1_12_2To1_13.class);
                }
            } else {
                int n4;
                for (int i = 0; i < 16 && (n4 = MAPPINGS.getItemMappings().getNewId(IdAndData.toRawData(n, i))) != -1; ++i) {
                    PacketWrapper packetWrapper3 = packetWrapper.create(ClientboundPackets1_13.COOLDOWN);
                    packetWrapper3.write(Types.VAR_INT, n4);
                    packetWrapper3.write(Types.VAR_INT, n2);
                    packetWrapper3.send(Protocol1_12_2To1_13.class);
                }
            }
        });
        this.registerClientbound(ClientboundPackets1_12_1.LEVEL_EVENT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.map(Types.BLOCK_POSITION1_8);
                this.map(Types.INT);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.INT, 0);
                    int n2 = packetWrapper.get(Types.INT, 1);
                    if (n == 1010) {
                        packetWrapper.set(Types.INT, 1, Protocol1_12_2To1_13.this.getMappingData().getItemMappings().getNewId(IdAndData.toRawData(n2)));
                    } else if (n == 2001) {
                        int n3 = n2 & 0xFFF;
                        int n4 = n2 >> 12;
                        packetWrapper.set(Types.INT, 1, WorldPacketRewriter1_13.toNewId(IdAndData.toRawData(n3, n4)));
                    }
                });
            }
        });
        this.registerClientbound(ClientboundPackets1_12_1.PLACE_GHOST_RECIPE, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BYTE);
                this.handler(packetWrapper -> packetWrapper.write(Types.STRING, "viaversion:legacy/" + String.valueOf(packetWrapper.read(Types.VAR_INT))));
            }
        });
        this.registerClientbound(ClientboundPackets1_12_1.MAP_ITEM_DATA, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.BYTE);
                this.map(Types.BOOLEAN);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.passthrough(Types.VAR_INT);
                    for (int i = 0; i < n; ++i) {
                        byte by = packetWrapper.read(Types.BYTE);
                        int n2 = (by & 0xF0) >> 4;
                        packetWrapper.write(Types.VAR_INT, n2);
                        packetWrapper.passthrough(Types.BYTE);
                        packetWrapper.passthrough(Types.BYTE);
                        byte by2 = (byte)(by & 0xF);
                        packetWrapper.write(Types.BYTE, by2);
                        packetWrapper.write(Types.OPTIONAL_COMPONENT, null);
                    }
                });
            }
        });
        this.registerClientbound(ClientboundPackets1_12_1.RECIPE, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.BOOLEAN);
                this.map(Types.BOOLEAN);
                this.handler(packetWrapper -> {
                    packetWrapper.write(Types.BOOLEAN, false);
                    packetWrapper.write(Types.BOOLEAN, false);
                });
                this.handler(packetWrapper2 -> {
                    int n = packetWrapper2.get(Types.VAR_INT, 0);
                    for (int i = 0; i < (n == 0 ? 2 : 1); ++i) {
                        int[] nArray = packetWrapper2.read(Types.VAR_INT_ARRAY_PRIMITIVE);
                        String[] stringArray = new String[nArray.length];
                        for (int j = 0; j < nArray.length; ++j) {
                            stringArray[j] = "viaversion:legacy/" + nArray[j];
                        }
                        packetWrapper2.write(Types.STRING_ARRAY, stringArray);
                    }
                    if (n == 0) {
                        packetWrapper2.create(ClientboundPackets1_13.UPDATE_RECIPES, packetWrapper -> Protocol1_12_2To1_13.this.writeDeclareRecipes(packetWrapper)).send(Protocol1_12_2To1_13.class);
                    }
                });
            }
        });
        this.registerClientbound(ClientboundPackets1_12_1.SET_OBJECTIVE, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.map(Types.BYTE);
                this.handler(packetWrapper -> {
                    byte by = packetWrapper.get(Types.BYTE, 0);
                    if (by == 0 || by == 2) {
                        String string = packetWrapper.read(Types.STRING);
                        packetWrapper.write(Types.COMPONENT, ComponentUtil.legacyToJson(string));
                        String string2 = packetWrapper.read(Types.STRING);
                        packetWrapper.write(Types.VAR_INT, string2.equals("integer") ? 0 : 1);
                    }
                });
            }
        });
        this.registerClientbound(ClientboundPackets1_12_1.SET_PLAYER_TEAM, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.map(Types.BYTE);
                this.handler(packetWrapper -> {
                    String[] stringArray;
                    byte by = packetWrapper.get(Types.BYTE, 0);
                    if (by == 0 || by == 2) {
                        stringArray = packetWrapper.read(Types.STRING);
                        packetWrapper.write(Types.COMPONENT, ComponentUtil.legacyToJson((String)stringArray));
                        String string = packetWrapper.read(Types.STRING);
                        Object object = packetWrapper.read(Types.STRING);
                        packetWrapper.passthrough(Types.BYTE);
                        packetWrapper.passthrough(Types.STRING);
                        packetWrapper.passthrough(Types.STRING);
                        int n = packetWrapper.read(Types.BYTE).intValue();
                        if (n == -1) {
                            n = 21;
                        }
                        if (Via.getConfig().is1_13TeamColourFix()) {
                            char c = Protocol1_12_2To1_13.this.getLastColorChar(string);
                            n = ChatColorUtil.getColorOrdinal(c);
                            object = "\u00a7" + Character.toString(c) + (String)object;
                        }
                        packetWrapper.write(Types.VAR_INT, n);
                        packetWrapper.write(Types.COMPONENT, ComponentUtil.legacyToJson(string));
                        packetWrapper.write(Types.COMPONENT, ComponentUtil.legacyToJson((String)object));
                    }
                    if (by == 0 || by == 3 || by == 4) {
                        stringArray = packetWrapper.read(Types.STRING_ARRAY);
                        for (int i = 0; i < stringArray.length; ++i) {
                            stringArray[i] = Protocol1_12_2To1_13.this.rewriteTeamMemberName(stringArray[i]);
                        }
                        packetWrapper.write(Types.STRING_ARRAY, stringArray);
                    }
                });
            }
        });
        this.registerClientbound(ClientboundPackets1_12_1.SET_SCORE, packetWrapper -> {
            String string = packetWrapper.read(Types.STRING);
            string = this.rewriteTeamMemberName(string);
            packetWrapper.write(Types.STRING, string);
        });
        this.registerClientbound(ClientboundPackets1_12_1.PLAYER_INFO, packetWrapper -> {
            int n = packetWrapper.passthrough(Types.VAR_INT);
            int n2 = packetWrapper.passthrough(Types.VAR_INT);
            for (int i = 0; i < n2; ++i) {
                Object object;
                packetWrapper.passthrough(Types.UUID);
                if (n == 0) {
                    object = packetWrapper.read(Types.STRING);
                    packetWrapper.write(Types.STRING, this.rewriteTeamMemberName((String)object));
                    packetWrapper.passthrough(Types.PROFILE_PROPERTY_ARRAY);
                    packetWrapper.passthrough(Types.VAR_INT);
                    packetWrapper.passthrough(Types.VAR_INT);
                    JsonElement jsonElement = packetWrapper.passthrough(Types.OPTIONAL_COMPONENT);
                    if (jsonElement == null) continue;
                    this.componentRewriter.processText(packetWrapper.user(), jsonElement);
                    continue;
                }
                if (n == 1 || n == 2) {
                    packetWrapper.passthrough(Types.VAR_INT);
                    continue;
                }
                if (n != 3 || (object = packetWrapper.passthrough(Types.OPTIONAL_COMPONENT)) == null) continue;
                this.componentRewriter.processText(packetWrapper.user(), (JsonElement)object);
            }
        });
        this.registerClientbound(ClientboundPackets1_12_1.UPDATE_ADVANCEMENTS, packetWrapper -> {
            packetWrapper.passthrough(Types.BOOLEAN);
            int n = packetWrapper.passthrough(Types.VAR_INT);
            for (int i = 0; i < n; ++i) {
                int n2;
                packetWrapper.passthrough(Types.STRING);
                packetWrapper.passthrough(Types.OPTIONAL_STRING);
                if (packetWrapper.passthrough(Types.BOOLEAN).booleanValue()) {
                    this.componentRewriter.processText(packetWrapper.user(), packetWrapper.passthrough(Types.COMPONENT));
                    this.componentRewriter.processText(packetWrapper.user(), packetWrapper.passthrough(Types.COMPONENT));
                    Item item = packetWrapper.read(Types.ITEM1_8);
                    this.itemRewriter.handleItemToClient(packetWrapper.user(), item);
                    packetWrapper.write(Types.ITEM1_13, item);
                    packetWrapper.passthrough(Types.VAR_INT);
                    n2 = packetWrapper.passthrough(Types.INT);
                    if ((n2 & 1) != 0) {
                        packetWrapper.passthrough(Types.STRING);
                    }
                    packetWrapper.passthrough(Types.FLOAT);
                    packetWrapper.passthrough(Types.FLOAT);
                }
                packetWrapper.passthrough(Types.STRING_ARRAY);
                int n3 = packetWrapper.passthrough(Types.VAR_INT);
                for (n2 = 0; n2 < n3; ++n2) {
                    packetWrapper.passthrough(Types.STRING_ARRAY);
                }
            }
        });
        this.cancelServerbound(State.LOGIN, ServerboundLoginPackets.CUSTOM_QUERY_ANSWER.getId());
        this.cancelServerbound(ServerboundPackets1_13.BLOCK_ENTITY_TAG_QUERY);
        this.registerServerbound(ServerboundPackets1_13.COMMAND_SUGGESTION, new PacketHandlers(){

            @Override
            public void register() {
                this.handler(packetWrapper -> {
                    if (Via.getConfig().isDisable1_13AutoComplete()) {
                        packetWrapper.cancel();
                    }
                    int n = packetWrapper.read(Types.VAR_INT);
                    packetWrapper.user().get(TabCompleteTracker.class).setTransactionId(n);
                });
                this.map(Types.STRING, new ValueTransformer<String, String>(Types.STRING){

                    @Override
                    public String transform(PacketWrapper packetWrapper, String string) {
                        packetWrapper.user().get(TabCompleteTracker.class).setInput(string);
                        return "/" + string;
                    }
                });
                this.handler(packetWrapper -> {
                    packetWrapper.write(Types.BOOLEAN, false);
                    BlockPosition blockPosition = Via.getManager().getProviders().get(PlayerLookTargetProvider.class).getPlayerLookTarget(packetWrapper.user());
                    packetWrapper.write(Types.OPTIONAL_POSITION1_8, blockPosition);
                    if (!packetWrapper.isCancelled() && Via.getConfig().get1_13TabCompleteDelay() > 0) {
                        TabCompleteTracker tabCompleteTracker = packetWrapper.user().get(TabCompleteTracker.class);
                        packetWrapper.cancel();
                        tabCompleteTracker.setTimeToSend(System.currentTimeMillis() + (long)Via.getConfig().get1_13TabCompleteDelay() * 50L);
                        tabCompleteTracker.setLastTabComplete(packetWrapper.get(Types.STRING, 0));
                    }
                });
            }
        });
        this.registerServerbound(ServerboundPackets1_13.EDIT_BOOK, ServerboundPackets1_12_1.CUSTOM_PAYLOAD, (PacketWrapper packetWrapper) -> {
            Item item = packetWrapper.read(Types.ITEM1_13);
            boolean bl = packetWrapper.read(Types.BOOLEAN);
            this.itemRewriter.handleItemToServer(packetWrapper.user(), item);
            packetWrapper.write(Types.STRING, bl ? "MC|BSign" : "MC|BEdit");
            packetWrapper.write(Types.ITEM1_8, item);
        });
        this.cancelServerbound(ServerboundPackets1_13.ENTITY_TAG_QUERY);
        this.registerServerbound(ServerboundPackets1_13.PICK_ITEM, ServerboundPackets1_12_1.CUSTOM_PAYLOAD, (PacketWrapper packetWrapper) -> packetWrapper.write(Types.STRING, "MC|PickItem"));
        this.registerServerbound(ServerboundPackets1_13.PLACE_RECIPE, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BYTE);
                this.handler(packetWrapper -> {
                    Integer n;
                    String string = packetWrapper.read(Types.STRING);
                    if (string.length() < 19 || (n = Ints.tryParse(string.substring(18))) == null) {
                        packetWrapper.cancel();
                        return;
                    }
                    packetWrapper.write(Types.VAR_INT, n);
                });
            }
        });
        this.registerServerbound(ServerboundPackets1_13.RECIPE_BOOK_UPDATE, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.VAR_INT, 0);
                    if (n == 0) {
                        Integer n2;
                        String string = packetWrapper.read(Types.STRING);
                        if (string.length() < 19 || (n2 = Ints.tryParse(string.substring(18))) == null) {
                            packetWrapper.cancel();
                            return;
                        }
                        packetWrapper.write(Types.INT, n2);
                    }
                    if (n == 1) {
                        packetWrapper.passthrough(Types.BOOLEAN);
                        packetWrapper.passthrough(Types.BOOLEAN);
                        packetWrapper.read(Types.BOOLEAN);
                        packetWrapper.read(Types.BOOLEAN);
                    }
                });
            }
        });
        this.registerServerbound(ServerboundPackets1_13.RENAME_ITEM, ServerboundPackets1_12_1.CUSTOM_PAYLOAD, (PacketWrapper packetWrapper) -> packetWrapper.write(Types.STRING, "MC|ItemName"));
        this.registerServerbound(ServerboundPackets1_13.SELECT_TRADE, ServerboundPackets1_12_1.CUSTOM_PAYLOAD, (PacketHandler)new PacketHandlers(){

            @Override
            public void register() {
                this.create(Types.STRING, "MC|TrSel");
                this.map(Types.VAR_INT, Types.INT);
            }
        });
        this.registerServerbound(ServerboundPackets1_13.SET_BEACON, ServerboundPackets1_12_1.CUSTOM_PAYLOAD, (PacketHandler)new PacketHandlers(){

            @Override
            public void register() {
                this.create(Types.STRING, "MC|Beacon");
                this.map(Types.VAR_INT, Types.INT);
                this.map(Types.VAR_INT, Types.INT);
            }
        });
        this.registerServerbound(ServerboundPackets1_13.SET_COMMAND_BLOCK, ServerboundPackets1_12_1.CUSTOM_PAYLOAD, (PacketHandler)new PacketHandlers(){

            @Override
            public void register() {
                this.create(Types.STRING, "MC|AutoCmd");
                this.handler(POS_TO_3_INT);
                this.map(Types.STRING);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.read(Types.VAR_INT);
                    byte by = packetWrapper.read(Types.BYTE);
                    String string = n == 0 ? "SEQUENCE" : (n == 1 ? "AUTO" : "REDSTONE");
                    packetWrapper.write(Types.BOOLEAN, (by & 1) != 0);
                    packetWrapper.write(Types.STRING, string);
                    packetWrapper.write(Types.BOOLEAN, (by & 2) != 0);
                    packetWrapper.write(Types.BOOLEAN, (by & 4) != 0);
                });
            }
        });
        this.registerServerbound(ServerboundPackets1_13.SET_COMMAND_MINECART, ServerboundPackets1_12_1.CUSTOM_PAYLOAD, (PacketHandler)new PacketHandlers(){

            @Override
            public void register() {
                this.handler(packetWrapper -> {
                    packetWrapper.write(Types.STRING, "MC|AdvCmd");
                    packetWrapper.write(Types.BYTE, (byte)1);
                });
                this.map(Types.VAR_INT, Types.INT);
            }
        });
        this.registerServerbound(ServerboundPackets1_13.SET_STRUCTURE_BLOCK, ServerboundPackets1_12_1.CUSTOM_PAYLOAD, (PacketHandler)new PacketHandlers(){

            @Override
            public void register() {
                this.create(Types.STRING, "MC|Struct");
                this.handler(POS_TO_3_INT);
                this.map(Types.VAR_INT, new ValueTransformer<Integer, Byte>((Type)Types.BYTE){

                    @Override
                    public Byte transform(PacketWrapper packetWrapper, Integer n) {
                        return (byte)(n + 1);
                    }
                });
                this.map(Types.VAR_INT, new ValueTransformer<Integer, String>(Types.STRING){

                    @Override
                    public String transform(PacketWrapper packetWrapper, Integer n) {
                        return n == 0 ? "SAVE" : (n == 1 ? "LOAD" : (n == 2 ? "CORNER" : "DATA"));
                    }
                });
                this.map(Types.STRING);
                this.map(Types.BYTE, Types.INT);
                this.map(Types.BYTE, Types.INT);
                this.map(Types.BYTE, Types.INT);
                this.map(Types.BYTE, Types.INT);
                this.map(Types.BYTE, Types.INT);
                this.map(Types.BYTE, Types.INT);
                this.map(Types.VAR_INT, new ValueTransformer<Integer, String>(Types.STRING){

                    @Override
                    public String transform(PacketWrapper packetWrapper, Integer n) {
                        return n == 0 ? "NONE" : (n == 1 ? "LEFT_RIGHT" : "FRONT_BACK");
                    }
                });
                this.map(Types.VAR_INT, new ValueTransformer<Integer, String>(Types.STRING){

                    @Override
                    public String transform(PacketWrapper packetWrapper, Integer n) {
                        return n == 0 ? "NONE" : (n == 1 ? "CLOCKWISE_90" : (n == 2 ? "CLOCKWISE_180" : "COUNTERCLOCKWISE_90"));
                    }
                });
                this.map(Types.STRING);
                this.handler(packetWrapper -> {
                    float f = packetWrapper.read(Types.FLOAT).floatValue();
                    long l = packetWrapper.read(Types.VAR_LONG);
                    byte by = packetWrapper.read(Types.BYTE);
                    packetWrapper.write(Types.BOOLEAN, (by & 1) != 0);
                    packetWrapper.write(Types.BOOLEAN, (by & 2) != 0);
                    packetWrapper.write(Types.BOOLEAN, (by & 4) != 0);
                    packetWrapper.write(Types.FLOAT, Float.valueOf(f));
                    packetWrapper.write(Types.VAR_LONG, l);
                });
            }
        });
    }

    private void writeDeclareRecipes(PacketWrapper packetWrapper) {
        packetWrapper.write(Types.VAR_INT, RecipeData.recipes.size());
        for (Map.Entry<String, RecipeData.Recipe> entry : RecipeData.recipes.entrySet()) {
            RecipeData.Recipe recipe = entry.getValue();
            packetWrapper.write(Types.STRING, entry.getKey());
            packetWrapper.write(Types.STRING, recipe.type());
            switch (recipe.type()) {
                case "crafting_shapeless": {
                    int n;
                    Item[] itemArray;
                    packetWrapper.write(Types.STRING, recipe.group());
                    packetWrapper.write(Types.VAR_INT, recipe.ingredients().length);
                    for (Item item : recipe.ingredients()) {
                        itemArray = new Item[((Item)item).length];
                        for (n = 0; n < ((Item)item).length; ++n) {
                            if (item[n] == null) continue;
                            itemArray[n] = item[n].copy();
                        }
                        packetWrapper.write(Types.ITEM1_13_ARRAY, itemArray);
                    }
                    packetWrapper.write(Types.ITEM1_13, recipe.result().copy());
                    break;
                }
                case "crafting_shaped": {
                    int n;
                    Item[] itemArray;
                    packetWrapper.write(Types.VAR_INT, recipe.width());
                    packetWrapper.write(Types.VAR_INT, recipe.height());
                    packetWrapper.write(Types.STRING, recipe.group());
                    for (Item item : recipe.ingredients()) {
                        itemArray = new Item[((Item)item).length];
                        for (n = 0; n < ((Item)item).length; ++n) {
                            if (item[n] == null) continue;
                            itemArray[n] = item[n].copy();
                        }
                        packetWrapper.write(Types.ITEM1_13_ARRAY, itemArray);
                    }
                    packetWrapper.write(Types.ITEM1_13, recipe.result().copy());
                    break;
                }
                case "smelting": {
                    packetWrapper.write(Types.STRING, recipe.group());
                    Item[] itemArray = new Item[recipe.ingredient().length];
                    for (int i = 0; i < itemArray.length; ++i) {
                        if (recipe.ingredient()[i] == null) continue;
                        itemArray[i] = recipe.ingredient()[i].copy();
                    }
                    packetWrapper.write(Types.ITEM1_13_ARRAY, itemArray);
                    packetWrapper.write(Types.ITEM1_13, recipe.result().copy());
                    packetWrapper.write(Types.FLOAT, Float.valueOf(recipe.experience()));
                    packetWrapper.write(Types.VAR_INT, recipe.cookingTime());
                }
            }
        }
    }

    @Override
    protected void onMappingDataLoaded() {
        ConnectionData.init();
        RecipeData.init();
        BlockIdData.init();
        Types1_13.PARTICLE.rawFiller().reader(3, ParticleType.Readers.BLOCK).reader(20, ParticleType.Readers.DUST).reader(11, ParticleType.Readers.DUST).reader(27, ParticleType.Readers.ITEM1_13);
        if (Via.getConfig().isServersideBlockConnections() && Via.getManager().getProviders().get(BlockConnectionProvider.class) instanceof PacketBlockConnectionProvider) {
            BlockConnectionStorage.init();
        }
        super.onMappingDataLoaded();
    }

    @Override
    public void init(UserConnection userConnection) {
        userConnection.addEntityTracker(this.getClass(), new EntityTrackerBase(userConnection, EntityTypes1_13.EntityType.PLAYER));
        userConnection.addClientWorld(this.getClass(), new ClientWorld());
        userConnection.put(new TabCompleteTracker());
        userConnection.put(new BlockStorage());
        if (Via.getConfig().isServersideBlockConnections() && Via.getManager().getProviders().get(BlockConnectionProvider.class) instanceof PacketBlockConnectionProvider) {
            userConnection.put(new BlockConnectionStorage());
        }
    }

    @Override
    public void register(ViaProviders viaProviders) {
        viaProviders.register(BlockEntityProvider.class, new BlockEntityProvider());
        viaProviders.register(PaintingProvider.class, new PaintingProvider());
        viaProviders.register(PlayerLookTargetProvider.class, new PlayerLookTargetProvider());
    }

    public char getLastColorChar(String string) {
        int n = string.length();
        for (int i = n - 1; i > -1; --i) {
            char c;
            char c2 = string.charAt(i);
            if (c2 != '\u00a7' || i >= n - 1 || !ChatColorUtil.isColorCode(c = string.charAt(i + 1)) || FORMATTING_CODES.contains(Character.valueOf(c))) continue;
            return c;
        }
        return 'r';
    }

    protected String rewriteTeamMemberName(String string) {
        if (ChatColorUtil.stripColor(string).isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 1; i < string.length(); i += 2) {
                char c = string.charAt(i);
                Character c2 = SCOREBOARD_TEAM_NAME_REWRITE.get(Character.valueOf(c));
                if (c2 == null) {
                    c2 = Character.valueOf(c);
                }
                stringBuilder.append('\u00a7').append(c2);
            }
            string = stringBuilder.toString();
        }
        return string;
    }

    @Override
    public MappingData1_13 getMappingData() {
        return MAPPINGS;
    }

    @Override
    public ProtocolLogger getLogger() {
        return LOGGER;
    }

    public EntityPacketRewriter1_13 getEntityRewriter() {
        return this.entityRewriter;
    }

    public ItemPacketRewriter1_13 getItemRewriter() {
        return this.itemRewriter;
    }

    @Override
    public ComponentRewriter1_13 getComponentRewriter() {
        return this.componentRewriter;
    }

    static {
        SCOREBOARD_TEAM_NAME_REWRITE.put(Character.valueOf('0'), Character.valueOf('g'));
        SCOREBOARD_TEAM_NAME_REWRITE.put(Character.valueOf('1'), Character.valueOf('h'));
        SCOREBOARD_TEAM_NAME_REWRITE.put(Character.valueOf('2'), Character.valueOf('i'));
        SCOREBOARD_TEAM_NAME_REWRITE.put(Character.valueOf('3'), Character.valueOf('j'));
        SCOREBOARD_TEAM_NAME_REWRITE.put(Character.valueOf('4'), Character.valueOf('p'));
        SCOREBOARD_TEAM_NAME_REWRITE.put(Character.valueOf('5'), Character.valueOf('q'));
        SCOREBOARD_TEAM_NAME_REWRITE.put(Character.valueOf('6'), Character.valueOf('s'));
        SCOREBOARD_TEAM_NAME_REWRITE.put(Character.valueOf('7'), Character.valueOf('t'));
        SCOREBOARD_TEAM_NAME_REWRITE.put(Character.valueOf('8'), Character.valueOf('u'));
        SCOREBOARD_TEAM_NAME_REWRITE.put(Character.valueOf('9'), Character.valueOf('v'));
        SCOREBOARD_TEAM_NAME_REWRITE.put(Character.valueOf('a'), Character.valueOf('w'));
        SCOREBOARD_TEAM_NAME_REWRITE.put(Character.valueOf('b'), Character.valueOf('x'));
        SCOREBOARD_TEAM_NAME_REWRITE.put(Character.valueOf('c'), Character.valueOf('y'));
        SCOREBOARD_TEAM_NAME_REWRITE.put(Character.valueOf('d'), Character.valueOf('z'));
        SCOREBOARD_TEAM_NAME_REWRITE.put(Character.valueOf('e'), Character.valueOf('!'));
        SCOREBOARD_TEAM_NAME_REWRITE.put(Character.valueOf('f'), Character.valueOf('?'));
        SCOREBOARD_TEAM_NAME_REWRITE.put(Character.valueOf('k'), Character.valueOf('#'));
        SCOREBOARD_TEAM_NAME_REWRITE.put(Character.valueOf('l'), Character.valueOf('('));
        SCOREBOARD_TEAM_NAME_REWRITE.put(Character.valueOf('m'), Character.valueOf(')'));
        SCOREBOARD_TEAM_NAME_REWRITE.put(Character.valueOf('n'), Character.valueOf(':'));
        SCOREBOARD_TEAM_NAME_REWRITE.put(Character.valueOf('o'), Character.valueOf(';'));
        SCOREBOARD_TEAM_NAME_REWRITE.put(Character.valueOf('r'), Character.valueOf('/'));
        POS_TO_3_INT = packetWrapper -> {
            BlockPosition blockPosition = packetWrapper.read(Types.BLOCK_POSITION1_8);
            packetWrapper.write(Types.INT, blockPosition.x());
            packetWrapper.write(Types.INT, blockPosition.y());
            packetWrapper.write(Types.INT, blockPosition.z());
        };
        SEND_DECLARE_COMMANDS_AND_TAGS = packetWrapper2 -> {
            packetWrapper2.create(ClientboundPackets1_13.COMMANDS, packetWrapper -> {
                packetWrapper.write(Types.VAR_INT, 2);
                packetWrapper.write(Types.BYTE, (byte)0);
                packetWrapper.write(Types.VAR_INT_ARRAY_PRIMITIVE, new int[]{1});
                packetWrapper.write(Types.BYTE, (byte)22);
                packetWrapper.write(Types.VAR_INT_ARRAY_PRIMITIVE, new int[0]);
                packetWrapper.write(Types.STRING, "args");
                packetWrapper.write(Types.STRING, "brigadier:string");
                packetWrapper.write(Types.VAR_INT, 2);
                packetWrapper.write(Types.STRING, "minecraft:ask_server");
                packetWrapper.write(Types.VAR_INT, 0);
            }).scheduleSend(Protocol1_12_2To1_13.class);
            PacketWrapper packetWrapper3 = packetWrapper2.create(ClientboundPackets1_13.UPDATE_TAGS, packetWrapper -> {
                packetWrapper.write(Types.VAR_INT, MAPPINGS.getBlockTags().size());
                for (Map.Entry<String, int[]> entry : MAPPINGS.getBlockTags().entrySet()) {
                    packetWrapper.write(Types.STRING, entry.getKey());
                    packetWrapper.write(Types.VAR_INT_ARRAY_PRIMITIVE, (int[])entry.getValue().clone());
                }
                packetWrapper.write(Types.VAR_INT, MAPPINGS.getItemTags().size());
                for (Map.Entry<String, int[]> entry : MAPPINGS.getItemTags().entrySet()) {
                    packetWrapper.write(Types.STRING, entry.getKey());
                    packetWrapper.write(Types.VAR_INT_ARRAY_PRIMITIVE, (int[])entry.getValue().clone());
                }
                packetWrapper.write(Types.VAR_INT, MAPPINGS.getFluidTags().size());
                for (Map.Entry<String, int[]> entry : MAPPINGS.getFluidTags().entrySet()) {
                    packetWrapper.write(Types.STRING, entry.getKey());
                    packetWrapper.write(Types.VAR_INT_ARRAY_PRIMITIVE, (int[])entry.getValue().clone());
                }
            });
            if (packetWrapper2.user().getProtocolInfo().protocolVersion().newerThanOrEqualTo(ProtocolVersion.v1_20_5)) {
                packetWrapper3.send(Protocol1_12_2To1_13.class);
            } else {
                packetWrapper3.scheduleSend(Protocol1_12_2To1_13.class);
            }
        };
    }
}

