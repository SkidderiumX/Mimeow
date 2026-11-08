/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_13_2to1_14.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.item.DataItem;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.libs.gson.JsonArray;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonObject;
import com.viaversion.viaversion.protocols.v1_13_2to1_14.Protocol1_13_2To1_14;
import com.viaversion.viaversion.rewriter.text.ComponentRewriterBase;
import com.viaversion.viaversion.rewriter.text.JsonNBTComponentRewriter;
import com.viaversion.viaversion.util.ComponentUtil;
import com.viaversion.viaversion.util.SerializerVersion;
import com.viaversion.viaversion.util.StringUtil;
import java.util.logging.Level;

public class ComponentRewriter1_14<C extends ClientboundPacketType>
extends JsonNBTComponentRewriter<C> {
    public ComponentRewriter1_14(Protocol<C, ?, ?, ?> protocol) {
        super(protocol, ComponentRewriterBase.ReadType.JSON);
    }

    @Override
    protected void handleHoverEvent(UserConnection userConnection, JsonObject jsonObject) {
        block8: {
            CompoundTag compoundTag;
            super.handleHoverEvent(userConnection, jsonObject);
            String string = jsonObject.getAsJsonPrimitive("action").getAsString();
            if (!string.equals("show_item")) {
                return;
            }
            JsonElement jsonElement = jsonObject.get("value");
            if (jsonElement == null) {
                return;
            }
            try {
                compoundTag = ComponentUtil.deserializeLegacyShowItem(jsonElement, SerializerVersion.V1_13);
            }
            catch (Exception exception) {
                if (Via.getConfig().logTextComponentConversionErrors()) {
                    Protocol1_13_2To1_14.LOGGER.log(Level.WARNING, "Error reading NBT in show_item: " + StringUtil.forLogging(jsonElement), exception);
                }
                return;
            }
            CompoundTag compoundTag2 = compoundTag.getCompoundTag("tag");
            DataItem dataItem = new DataItem();
            dataItem.setTag(compoundTag2);
            this.protocol.getItemRewriter().handleItemToClient(null, dataItem);
            if (compoundTag2 != null) {
                compoundTag.put("tag", compoundTag2);
            }
            JsonArray jsonArray = new JsonArray();
            JsonObject jsonObject2 = new JsonObject();
            jsonArray.add(jsonObject2);
            try {
                jsonObject2.addProperty("text", SerializerVersion.V1_14.toSNBT(compoundTag));
                jsonObject.add("value", jsonArray);
            }
            catch (Exception exception) {
                if (!Via.getConfig().logTextComponentConversionErrors()) break block8;
                Protocol1_13_2To1_14.LOGGER.log(Level.WARNING, "Error writing NBT in show_item: " + StringUtil.forLogging(jsonElement), exception);
            }
        }
    }
}

