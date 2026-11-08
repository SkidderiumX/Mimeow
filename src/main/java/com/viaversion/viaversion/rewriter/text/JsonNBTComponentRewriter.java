/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.rewriter.text;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonObject;
import com.viaversion.viaversion.libs.gson.JsonPrimitive;
import com.viaversion.viaversion.rewriter.text.ComponentRewriterBase;
import com.viaversion.viaversion.util.ComponentUtil;
import com.viaversion.viaversion.util.SerializerVersion;
import java.util.BitSet;
import org.checkerframework.checker.nullness.qual.Nullable;

public class JsonNBTComponentRewriter<C extends ClientboundPacketType>
extends ComponentRewriterBase<C> {
    public JsonNBTComponentRewriter(Protocol<C, ?, ?, ?> protocol, ComponentRewriterBase.ReadType readType) {
        super(protocol, readType);
    }

    public void registerPlayerCombat(C c) {
        this.protocol.registerClientbound(c, packetWrapper -> {
            if (packetWrapper.passthrough(Types.VAR_INT) == 2) {
                packetWrapper.passthrough(Types.VAR_INT);
                packetWrapper.passthrough(Types.INT);
                this.processText(packetWrapper.user(), packetWrapper.passthrough(Types.COMPONENT));
            }
        });
    }

    public void registerTitle(C c) {
        this.protocol.registerClientbound(c, packetWrapper -> {
            int n = packetWrapper.passthrough(Types.VAR_INT);
            if (n >= 0 && n <= 2) {
                this.processText(packetWrapper.user(), packetWrapper.passthrough(Types.COMPONENT));
            }
        });
    }

    public void registerLegacyOpenWindow(C c) {
        this.protocol.registerClientbound(c, packetWrapper -> {
            packetWrapper.passthrough(Types.UNSIGNED_BYTE);
            packetWrapper.passthrough(Types.STRING);
            this.processText(packetWrapper.user(), packetWrapper.passthrough(Types.COMPONENT));
        });
    }

    public void registerPlayerCombatKill(C c) {
        this.protocol.registerClientbound(c, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.INT);
            this.processText(packetWrapper.user(), packetWrapper.passthrough(Types.COMPONENT));
        });
    }

    public void registerPlayerInfoUpdate1_20_3(C c) {
        this.protocol.registerClientbound(c, packetWrapper -> {
            BitSet bitSet = packetWrapper.passthrough(Types.PROFILE_ACTIONS_ENUM1_19_3);
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
            }
        });
    }

    public void registerPlayerChat(C c, Type<?> type) {
        this.protocol.registerClientbound(c, packetWrapper -> {
            int n;
            packetWrapper.passthrough(Types.UUID);
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.OPTIONAL_SIGNATURE_BYTES);
            packetWrapper.passthrough(Types.STRING);
            packetWrapper.passthrough(Types.LONG);
            packetWrapper.passthrough(Types.LONG);
            int n2 = packetWrapper.passthrough(Types.VAR_INT);
            for (n = 0; n < n2; ++n) {
                int n3 = packetWrapper.passthrough(Types.VAR_INT);
                if (n3 != 0) continue;
                packetWrapper.passthrough(Types.SIGNATURE_BYTES);
            }
            this.processTag(packetWrapper.user(), packetWrapper.passthrough(Types.TRUSTED_OPTIONAL_TAG));
            n = packetWrapper.passthrough(Types.VAR_INT);
            if (n == 2) {
                packetWrapper.passthrough(Types.LONG_ARRAY_PRIMITIVE);
            }
            packetWrapper.passthrough(type);
            this.processTag(packetWrapper.user(), packetWrapper.passthrough(Types.TRUSTED_TAG));
            this.processTag(packetWrapper.user(), packetWrapper.passthrough(Types.TRUSTED_OPTIONAL_TAG));
        });
    }

    @Override
    protected void handleHoverEvent(UserConnection userConnection, JsonObject jsonObject) {
        JsonElement jsonElement;
        JsonPrimitive jsonPrimitive = jsonObject.getAsJsonPrimitive("action");
        if (!jsonPrimitive.isString()) {
            return;
        }
        String string = jsonPrimitive.getAsString();
        if (string.equals("show_text")) {
            JsonElement jsonElement2 = jsonObject.get("value");
            this.processText(userConnection, jsonElement2 != null ? jsonElement2 : jsonObject.get("contents"));
        } else if (string.equals("show_entity") && (jsonElement = jsonObject.get("contents")) != null && jsonElement.isJsonObject()) {
            this.processText(userConnection, jsonElement.getAsJsonObject().get("name"));
        }
    }

    @Override
    protected void handleHoverEvent(UserConnection userConnection, CompoundTag compoundTag) {
        StringTag stringTag = compoundTag.getStringTag("action");
        if (stringTag == null) {
            return;
        }
        String string = stringTag.getValue();
        if (string.equals("show_text")) {
            Tag tag = compoundTag.get("value");
            this.processTag(userConnection, tag != null ? tag : compoundTag.get("contents"));
        } else if (string.equals("show_entity")) {
            this.convertLegacyEntityContents(compoundTag);
            CompoundTag compoundTag2 = compoundTag.getCompoundTag("contents");
            if (compoundTag2 != null) {
                this.processTag(userConnection, compoundTag2.get("name"));
                StringTag stringTag2 = compoundTag2.getStringTag("type");
                if (stringTag2 != null && this.protocol.getEntityRewriter() != null) {
                    stringTag2.setValue(this.protocol.getEntityRewriter().mappedEntityIdentifier(stringTag2.getValue()));
                }
            }
        } else if (string.equals("show_item")) {
            this.convertLegacyItemContents(compoundTag);
            CompoundTag compoundTag3 = compoundTag.getCompoundTag("contents");
            if (compoundTag3 != null) {
                CompoundTag compoundTag4 = compoundTag3.getCompoundTag("components");
                this.handleShowItem(userConnection, compoundTag3, compoundTag4);
            }
        }
    }

    @Override
    protected void handleNestedComponent(UserConnection userConnection, @Nullable Tag tag) {
        if (!(tag instanceof StringTag)) {
            return;
        }
        StringTag stringTag = (StringTag)tag;
        SerializerVersion serializerVersion = this.inputSerializerVersion();
        SerializerVersion serializerVersion2 = this.outputSerializerVersion();
        Tag tag2 = serializerVersion.toTag(serializerVersion.toComponent(stringTag.getValue()));
        this.processTag(userConnection, tag2);
        stringTag.setValue(serializerVersion2.toString(serializerVersion2.toComponent(tag2)));
    }

    @Override
    protected void handleWrittenBookContents(UserConnection userConnection, CompoundTag compoundTag) {
        if (this.inputSerializerVersion() != null) {
            super.handleWrittenBookContents(userConnection, compoundTag);
        }
    }

    @Override
    protected String hoverEventKey() {
        return "hoverEvent";
    }

    protected @Nullable SerializerVersion inputSerializerVersion() {
        return null;
    }

    protected @Nullable SerializerVersion outputSerializerVersion() {
        return this.inputSerializerVersion();
    }

    protected void convertLegacyEntityContents(CompoundTag compoundTag) {
        if (this.inputSerializerVersion() == null) {
            return;
        }
        Tag tag = compoundTag.remove("value");
        if (tag != null) {
            CompoundTag compoundTag2 = ComponentUtil.deserializeShowItem(tag, this.inputSerializerVersion());
            CompoundTag compoundTag3 = new CompoundTag();
            compoundTag3.put("type", compoundTag2.getStringTag("type"));
            compoundTag3.put("id", compoundTag2.getStringTag("id"));
            compoundTag3.put("name", this.outputSerializerVersion().toTag(this.outputSerializerVersion().toComponent(compoundTag2.getString("name"))));
            compoundTag.put("contents", compoundTag3);
        }
    }

    protected void convertLegacyItemContents(CompoundTag compoundTag) {
        if (this.inputSerializerVersion() == null) {
            return;
        }
        Tag tag = compoundTag.remove("value");
        if (tag != null) {
            CompoundTag compoundTag2 = ComponentUtil.deserializeShowItem(tag, this.inputSerializerVersion());
            CompoundTag compoundTag3 = new CompoundTag();
            compoundTag3.put("id", compoundTag2.getStringTag("id"));
            compoundTag3.put("count", compoundTag2.getIntTag("count"));
            if (compoundTag2.get("tag") instanceof CompoundTag) {
                compoundTag3.putString("tag", this.outputSerializerVersion().toSNBT(compoundTag2.getCompoundTag("tag")));
            }
            compoundTag.put("contents", compoundTag3);
        }
    }
}

