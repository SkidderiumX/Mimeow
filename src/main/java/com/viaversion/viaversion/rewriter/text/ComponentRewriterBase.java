/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.rewriter.text;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.FullMappings;
import com.viaversion.viaversion.api.data.Mappings;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.api.minecraft.item.data.ChatType;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.packet.State;
import com.viaversion.viaversion.api.rewriter.ComponentRewriter;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.libs.gson.JsonArray;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonObject;
import com.viaversion.viaversion.libs.gson.JsonParser;
import com.viaversion.viaversion.libs.gson.JsonPrimitive;
import com.viaversion.viaversion.libs.gson.JsonSyntaxException;
import com.viaversion.viaversion.protocols.base.ClientboundLoginPackets;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.TagUtil;
import java.util.BitSet;
import java.util.Collection;
import org.checkerframework.checker.nullness.qual.Nullable;

public abstract class ComponentRewriterBase<C extends ClientboundPacketType>
implements ComponentRewriter {
    protected final Protocol<C, ?, ?, ?> protocol;
    protected final ReadType type;

    protected ComponentRewriterBase(Protocol<C, ?, ?, ?> protocol, ReadType readType) {
        this.protocol = protocol;
        this.type = readType;
    }

    public void registerComponentPacket(C c) {
        this.protocol.registerClientbound(c, this::passthroughAndProcess);
    }

    public void registerBossEvent(C c) {
        this.protocol.registerClientbound(c, packetWrapper -> {
            packetWrapper.passthrough(Types.UUID);
            int n = packetWrapper.passthrough(Types.VAR_INT);
            if (n == 0 || n == 3) {
                this.passthroughAndProcess(packetWrapper);
            }
        });
    }

    public void registerLoginDisconnect() {
        this.protocol.registerClientbound(State.LOGIN, ClientboundLoginPackets.LOGIN_DISCONNECT, packetWrapper -> this.processText(packetWrapper.user(), packetWrapper.passthrough(Types.COMPONENT)));
    }

    public void registerOpenScreen1_14(C c) {
        this.protocol.registerClientbound(c, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.VAR_INT);
        });
    }

    public void registerTabList(C c) {
        this.protocol.registerClientbound(c, packetWrapper -> {
            this.passthroughAndProcess(packetWrapper);
            this.passthroughAndProcess(packetWrapper);
        });
    }

    public void registerSetObjective(C c) {
        this.protocol.registerClientbound(c, packetWrapper -> {
            packetWrapper.passthrough(Types.STRING);
            byte by = packetWrapper.passthrough(Types.BYTE);
            if (by == 0 || by == 2) {
                this.passthroughAndProcess(packetWrapper);
            }
        });
    }

    public void registerSetScore1_20_3(C c) {
        this.protocol.registerClientbound(c, packetWrapper -> {
            packetWrapper.passthrough(Types.STRING);
            packetWrapper.passthrough(Types.STRING);
            packetWrapper.passthrough(Types.VAR_INT);
            this.passthroughAndProcessOptional(packetWrapper);
            if (packetWrapper.passthrough(Types.BOOLEAN).booleanValue()) {
                int n = packetWrapper.passthrough(Types.VAR_INT);
                if (n == 1) {
                    this.passthroughAndProcess(packetWrapper);
                } else if (n == 2) {
                    this.passthroughAndProcess(packetWrapper);
                }
            }
        });
    }

    public void registerSetPlayerTeam1_13(C c) {
        this.protocol.registerClientbound(c, packetWrapper -> {
            packetWrapper.passthrough(Types.STRING);
            byte by = packetWrapper.passthrough(Types.BYTE);
            if (by == 0 || by == 2) {
                this.passthroughAndProcess(packetWrapper);
                packetWrapper.passthrough(Types.BYTE);
                packetWrapper.passthrough(Types.STRING);
                packetWrapper.passthrough(Types.STRING);
                packetWrapper.passthrough(Types.VAR_INT);
                this.passthroughAndProcess(packetWrapper);
                this.passthroughAndProcess(packetWrapper);
            }
        });
    }

    public void registerSetPlayerTeam1_21_5(C c) {
        this.protocol.registerClientbound(c, packetWrapper -> {
            packetWrapper.passthrough(Types.STRING);
            byte by = packetWrapper.passthrough(Types.BYTE);
            if (by == 0 || by == 2) {
                this.passthroughAndProcess(packetWrapper);
                packetWrapper.passthrough(Types.BYTE);
                packetWrapper.passthrough(Types.VAR_INT);
                packetWrapper.passthrough(Types.VAR_INT);
                packetWrapper.passthrough(Types.VAR_INT);
                this.passthroughAndProcess(packetWrapper);
                this.passthroughAndProcess(packetWrapper);
            }
        });
    }

    public void registerSetPlayerTeam26_2(C c) {
        this.protocol.registerClientbound(c, packetWrapper -> {
            packetWrapper.passthrough(Types.STRING);
            byte by = packetWrapper.passthrough(Types.BYTE);
            if (by == 0 || by == 2) {
                this.passthroughAndProcess(packetWrapper);
                this.passthroughAndProcess(packetWrapper);
                this.passthroughAndProcess(packetWrapper);
                packetWrapper.passthrough(Types.VAR_INT);
                packetWrapper.passthrough(Types.VAR_INT);
                packetWrapper.passthrough(Types.OPTIONAL_VAR_INT);
                packetWrapper.passthrough(Types.BYTE);
            }
        });
    }

    public void registerPlayerInfoUpdate1_21_4(C c) {
        this.protocol.registerClientbound(c, packetWrapper -> {
            BitSet bitSet = packetWrapper.passthrough(Types.PROFILE_ACTIONS_ENUM1_21_4);
            if (!bitSet.get(5)) {
                return;
            }
            int n = packetWrapper.passthrough(Types.VAR_INT);
            for (int i = 0; i < n; ++i) {
                packetWrapper.passthrough(Types.UUID);
                if (bitSet.get(0)) {
                    packetWrapper.passthrough(Types.STRING);
                    packetWrapper.passthrough(Types.PROFILE_PROPERTY_ARRAY);
                }
                if (bitSet.get(1) && packetWrapper.passthrough(Types.BOOLEAN).booleanValue()) {
                    packetWrapper.passthrough(Types.UUID);
                    packetWrapper.passthrough(Types.PROFILE_KEY);
                }
                if (bitSet.get(2)) {
                    packetWrapper.passthrough(Types.VAR_INT);
                }
                if (bitSet.get(3)) {
                    packetWrapper.passthrough(Types.BOOLEAN);
                }
                if (bitSet.get(4)) {
                    packetWrapper.passthrough(Types.VAR_INT);
                }
                this.processTag(packetWrapper.user(), packetWrapper.passthrough(Types.TRUSTED_OPTIONAL_TAG));
                if (bitSet.get(6)) {
                    packetWrapper.passthrough(Types.VAR_INT);
                }
                if (!bitSet.get(7)) continue;
                packetWrapper.passthrough(Types.BOOLEAN);
            }
        });
    }

    public void registerPlayerCombatKill1_20(C c) {
        this.protocol.registerClientbound(c, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            this.passthroughAndProcess(packetWrapper);
        });
    }

    public void registerDisguisedChat(C c) {
        this.protocol.registerClientbound(c, packetWrapper -> {
            this.passthroughAndProcess(packetWrapper);
            packetWrapper.passthrough(ChatType.TYPE);
            this.passthroughAndProcess(packetWrapper);
            this.passthroughAndProcessOptional(packetWrapper);
        });
    }

    @Override
    public void passthroughAndProcess(PacketWrapper packetWrapper) {
        switch (this.type) {
            case JSON: {
                this.processText(packetWrapper.user(), packetWrapper.passthrough(Types.COMPONENT));
                break;
            }
            case NBT: {
                this.processTag(packetWrapper.user(), packetWrapper.passthrough(Types.TRUSTED_TAG));
            }
        }
    }

    public void passthroughAndProcessOptional(PacketWrapper packetWrapper) {
        switch (this.type) {
            case JSON: {
                this.processText(packetWrapper.user(), packetWrapper.passthrough(Types.OPTIONAL_COMPONENT));
                break;
            }
            case NBT: {
                this.processTag(packetWrapper.user(), packetWrapper.passthrough(Types.TRUSTED_OPTIONAL_TAG));
            }
        }
    }

    @Override
    public JsonElement processText(UserConnection userConnection, String string) {
        try {
            JsonElement jsonElement = JsonParser.parseString(string);
            this.processText(userConnection, jsonElement);
            return jsonElement;
        }
        catch (JsonSyntaxException jsonSyntaxException) {
            if (Via.getManager().isDebug()) {
                this.protocol.getLogger().severe("Error when trying to parse json: " + string);
                throw jsonSyntaxException;
            }
            return new JsonPrimitive(string);
        }
    }

    @Override
    public void processText(UserConnection userConnection, JsonElement jsonElement) {
        if (jsonElement == null || jsonElement.isJsonNull()) {
            return;
        }
        if (jsonElement.isJsonArray()) {
            this.processJsonArray(userConnection, jsonElement.getAsJsonArray());
        } else if (jsonElement.isJsonObject()) {
            this.processJsonObject(userConnection, jsonElement.getAsJsonObject());
        }
    }

    protected void processJsonArray(UserConnection userConnection, JsonArray jsonArray) {
        for (JsonElement jsonElement : jsonArray) {
            this.processText(userConnection, jsonElement);
        }
    }

    protected void processJsonObject(UserConnection userConnection, JsonObject jsonObject) {
        JsonElement jsonElement;
        JsonElement jsonElement2;
        JsonElement jsonElement3 = jsonObject.get("translate");
        if (jsonElement3 != null && jsonElement3.isJsonPrimitive()) {
            this.handleTranslate(jsonObject, jsonElement3.getAsString());
            jsonElement2 = jsonObject.get("with");
            if (jsonElement2 != null && jsonElement2.isJsonArray()) {
                this.processJsonArray(userConnection, jsonElement2.getAsJsonArray());
            }
        }
        if ((jsonElement2 = jsonObject.get("extra")) != null && jsonElement2.isJsonArray()) {
            this.processJsonArray(userConnection, jsonElement2.getAsJsonArray());
        }
        if ((jsonElement = jsonObject.get(this.hoverEventKey())) != null && jsonElement.isJsonObject()) {
            this.handleHoverEvent(userConnection, jsonElement.getAsJsonObject());
        }
    }

    protected abstract void handleHoverEvent(UserConnection var1, JsonObject var2);

    protected void handleTranslate(JsonObject jsonObject, String string) {
    }

    @Override
    public void processTag(UserConnection userConnection, @Nullable Tag tag) {
        if (tag == null) {
            return;
        }
        if (tag instanceof ListTag) {
            this.processListTag(userConnection, (ListTag)tag);
        } else if (tag instanceof CompoundTag) {
            this.processCompoundTag(userConnection, (CompoundTag)tag);
        }
    }

    private void processListTag(UserConnection userConnection, ListTag<?> listTag) {
        for (Tag tag : listTag) {
            this.processTag(userConnection, tag);
        }
    }

    protected void processCompoundTag(UserConnection userConnection, CompoundTag compoundTag) {
        CompoundTag compoundTag2;
        ListTag<?> listTag;
        StringTag stringTag = compoundTag.getStringTag("translate");
        if (stringTag != null) {
            this.handleTranslate(userConnection, compoundTag, stringTag);
            listTag = compoundTag.getListTag("with");
            if (listTag != null) {
                this.processListTag(userConnection, listTag);
            }
        }
        if ((listTag = compoundTag.getListTag("extra")) != null) {
            this.processListTag(userConnection, listTag);
        }
        if ((compoundTag2 = compoundTag.getCompoundTag(this.hoverEventKey())) != null) {
            this.handleHoverEvent(userConnection, compoundTag2);
        }
    }

    protected void handleTranslate(UserConnection userConnection, CompoundTag compoundTag, StringTag stringTag) {
    }

    protected abstract void handleHoverEvent(UserConnection var1, CompoundTag var2);

    @Override
    public final void handleShowItem(UserConnection userConnection, CompoundTag compoundTag) {
        this.handleShowItem(userConnection, compoundTag, compoundTag.getCompoundTag("components"));
    }

    protected void handleShowItem(UserConnection userConnection, CompoundTag compoundTag, @Nullable CompoundTag compoundTag2) {
        StringTag stringTag = compoundTag.getStringTag("id");
        String string = this.protocol.getMappingData().getFullItemMappings().mappedIdentifier(stringTag.getValue());
        if (string != null) {
            stringTag.setValue(string);
        }
        if (compoundTag2 == null) {
            return;
        }
        this.handleNestedComponent(userConnection, TagUtil.getNamespacedTag(compoundTag2, "item_name"));
        this.handleNestedComponent(userConnection, TagUtil.getNamespacedTag(compoundTag2, "custom_name"));
        this.handleLore(userConnection, compoundTag2);
        this.handleWrittenBookContents(userConnection, compoundTag2);
        this.handleAttributeModifiers(compoundTag2);
        this.handleContainerContents(userConnection, compoundTag2);
        this.handleItemArrayContents(userConnection, compoundTag2, "bundle_contents");
        this.handleItemArrayContents(userConnection, compoundTag2, "charged_projectiles");
        CompoundTag compoundTag3 = TagUtil.getNamespacedCompoundTag(compoundTag2, "use_remainder");
        if (compoundTag3 != null) {
            this.handleShowItem(userConnection, compoundTag3);
        }
        this.removeDataComponents(compoundTag2, "lock", "debug_stick_state");
    }

    protected void handleAttributeModifiers(CompoundTag compoundTag2) {
        FullMappings fullMappings = this.protocol.getMappingData().getAttributeMappings();
        if (Mappings.isFullIdentity(fullMappings)) {
            return;
        }
        ListTag<CompoundTag> listTag = TagUtil.getNamespacedCompoundTagList(compoundTag2, "attribute_modifiers");
        if (listTag == null) {
            return;
        }
        listTag.getValue().removeIf(compoundTag -> {
            StringTag stringTag = compoundTag.getStringTag("type");
            if (stringTag == null) {
                return false;
            }
            String string = fullMappings.mappedIdentifier(stringTag.getValue());
            if (string != null) {
                stringTag.setValue(string);
                return false;
            }
            return true;
        });
    }

    protected void handleContainerContents(UserConnection userConnection, CompoundTag compoundTag) {
        ListTag<CompoundTag> listTag = TagUtil.getNamespacedCompoundTagList(compoundTag, "container");
        if (listTag == null) {
            return;
        }
        for (CompoundTag compoundTag2 : listTag) {
            this.handleShowItem(userConnection, compoundTag2.getCompoundTag("item"));
        }
    }

    protected void handleLore(UserConnection userConnection, CompoundTag compoundTag) {
        ListTag<? extends Tag> listTag = TagUtil.getNamespacedTagList(compoundTag, "lore");
        if (listTag == null) {
            return;
        }
        for (Tag tag : listTag) {
            this.handleNestedComponent(userConnection, tag);
        }
    }

    protected void handleWrittenBookContents(UserConnection userConnection, CompoundTag compoundTag) {
        CompoundTag compoundTag2 = TagUtil.getNamespacedCompoundTag(compoundTag, "written_book_content");
        if (compoundTag2 == null) {
            return;
        }
        ListTag<CompoundTag> listTag = compoundTag2.getListTag("pages", CompoundTag.class);
        if (listTag == null) {
            return;
        }
        for (CompoundTag compoundTag3 : listTag) {
            this.handleNestedComponent(userConnection, compoundTag3.get("raw"));
            this.handleNestedComponent(userConnection, compoundTag3.get("filtered"));
        }
    }

    protected void handleItemArrayContents(UserConnection userConnection, CompoundTag compoundTag, String string) {
        ListTag<CompoundTag> listTag = TagUtil.getNamespacedCompoundTagList(compoundTag, string);
        if (listTag == null) {
            return;
        }
        for (CompoundTag compoundTag2 : listTag) {
            this.handleShowItem(userConnection, compoundTag2);
        }
    }

    protected void removeDataComponents(CompoundTag compoundTag, Collection<StructuredDataKey<?>> collection) {
        for (StructuredDataKey<?> structuredDataKey : collection) {
            this.removeDataComponent(compoundTag, structuredDataKey.identifier());
        }
    }

    protected void removeDataComponents(CompoundTag compoundTag, StructuredDataKey<?> ... structuredDataKeyArray) {
        for (StructuredDataKey<?> structuredDataKey : structuredDataKeyArray) {
            this.removeDataComponent(compoundTag, structuredDataKey.identifier());
        }
    }

    protected void removeDataComponents(CompoundTag compoundTag, String ... stringArray) {
        for (String string : stringArray) {
            this.removeDataComponent(compoundTag, string);
        }
    }

    private boolean removeDataComponent(CompoundTag compoundTag, String string) {
        return TagUtil.removeNamespaced(compoundTag, string) || compoundTag.remove("!" + Key.namespaced(string)) != null || compoundTag.remove("!" + Key.stripMinecraftNamespace(string)) != null;
    }

    protected abstract void handleNestedComponent(UserConnection var1, @Nullable Tag var2);

    protected abstract String hoverEventKey();

    public static enum ReadType {
        JSON,
        NBT;

    }
}

