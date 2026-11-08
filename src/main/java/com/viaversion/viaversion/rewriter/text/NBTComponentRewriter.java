/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.rewriter.text;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.item.data.ChatType;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.api.rewriter.RegistryDataRewriter;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.libs.gson.JsonObject;
import com.viaversion.viaversion.rewriter.text.ComponentRewriterBase;
import org.checkerframework.checker.nullness.qual.Nullable;

public class NBTComponentRewriter<C extends ClientboundPacketType>
extends ComponentRewriterBase<C> {
    public NBTComponentRewriter(Protocol<C, ?, ?, ?> protocol) {
        super(protocol, ComponentRewriterBase.ReadType.NBT);
    }

    @Override
    protected void processCompoundTag(UserConnection userConnection, CompoundTag compoundTag) {
        super.processCompoundTag(userConnection, compoundTag);
        CompoundTag compoundTag2 = compoundTag.getCompoundTag("click_event");
        if (compoundTag2 != null) {
            this.handleClickEvent(userConnection, compoundTag2);
        }
    }

    @Override
    protected void handleHoverEvent(UserConnection userConnection, JsonObject jsonObject) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    protected void handleHoverEvent(UserConnection userConnection, CompoundTag compoundTag) {
        StringTag stringTag = compoundTag.getStringTag("action");
        if (stringTag == null) {
            return;
        }
        String string = stringTag.getValue();
        if (string.equals("show_text")) {
            this.processTag(userConnection, compoundTag.get("value"));
        } else if (string.equals("show_entity")) {
            this.processTag(userConnection, compoundTag.get("name"));
            StringTag stringTag2 = compoundTag.getStringTag("id");
            if (stringTag2 != null && this.protocol.getEntityRewriter() != null) {
                stringTag2.setValue(this.protocol.getEntityRewriter().mappedEntityIdentifier(stringTag2.getValue()));
            }
        } else if (string.equals("show_item")) {
            CompoundTag compoundTag2 = compoundTag.getCompoundTag("components");
            this.handleShowItem(userConnection, compoundTag, compoundTag2);
        }
    }

    protected void handleClickEvent(UserConnection userConnection, CompoundTag compoundTag) {
        StringTag stringTag = compoundTag.getStringTag("action");
        if (stringTag == null) {
            return;
        }
        String string = stringTag.getValue();
        if (!string.equals("show_dialog")) {
            return;
        }
        CompoundTag compoundTag2 = compoundTag.getCompoundTag("dialog");
        if (compoundTag2 == null) {
            return;
        }
        RegistryDataRewriter registryDataRewriter = this.protocol.getRegistryDataRewriter();
        if (registryDataRewriter != null) {
            registryDataRewriter.updateDialog(userConnection, compoundTag2);
        }
    }

    @Override
    protected void handleNestedComponent(UserConnection userConnection, @Nullable Tag tag) {
        this.processTag(userConnection, tag);
    }

    @Override
    protected String hoverEventKey() {
        return "hover_event";
    }

    public void registerPlayerChat1_21_5(C c) {
        this.protocol.registerClientbound(c, packetWrapper -> {
            int n;
            packetWrapper.passthrough(Types.VAR_INT);
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
            packetWrapper.passthrough(ChatType.TYPE);
            this.processTag(packetWrapper.user(), packetWrapper.passthrough(Types.TRUSTED_TAG));
            this.processTag(packetWrapper.user(), packetWrapper.passthrough(Types.TRUSTED_OPTIONAL_TAG));
        });
    }
}

