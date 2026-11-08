/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_12_2to1_13.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.NumberTag;
import com.viaversion.nbt.tag.ShortTag;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.item.DataItem;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.libs.gson.JsonArray;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonObject;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.Protocol1_12_2To1_13;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.data.ItemIds1_12_2;
import com.viaversion.viaversion.protocols.v1_13to1_13_1.Protocol1_13To1_13_1;
import com.viaversion.viaversion.rewriter.text.ComponentRewriterBase;
import com.viaversion.viaversion.rewriter.text.JsonNBTComponentRewriter;
import com.viaversion.viaversion.util.ComponentUtil;
import com.viaversion.viaversion.util.SerializerVersion;
import com.viaversion.viaversion.util.StringUtil;
import java.util.logging.Level;

public class ComponentRewriter1_13<C extends ClientboundPacketType>
extends JsonNBTComponentRewriter<C> {
    public ComponentRewriter1_13(Protocol<C, ?, ?, ?> protocol) {
        super(protocol, ComponentRewriterBase.ReadType.JSON);
    }

    @Override
    protected void handleHoverEvent(UserConnection userConnection, JsonObject jsonObject) {
        block10: {
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
                compoundTag = ComponentUtil.deserializeLegacyShowItem(jsonElement, SerializerVersion.V1_12);
            }
            catch (Exception exception) {
                if (Via.getConfig().logTextComponentConversionErrors()) {
                    Protocol1_12_2To1_13.LOGGER.log(Level.WARNING, "Error reading NBT in show_item: " + StringUtil.forLogging(jsonElement), exception);
                }
                return;
            }
            String string2 = compoundTag.getString("id", "");
            CompoundTag compoundTag2 = compoundTag.getCompoundTag("tag");
            NumberTag numberTag = compoundTag.getNumberTag("Damage");
            int n = ItemIds1_12_2.getId(string2, 1);
            short s = numberTag != null ? numberTag.asShort() : (short)0;
            DataItem dataItem = new DataItem();
            dataItem.setIdentifier(n);
            dataItem.setData(s);
            dataItem.setTag(compoundTag2);
            this.protocol.getItemRewriter().handleItemToClient(null, dataItem);
            if (n != dataItem.identifier()) {
                compoundTag.putString("id", Protocol1_13To1_13_1.MAPPINGS.getFullItemMappings().identifier(dataItem.identifier()));
            }
            if (s != dataItem.data()) {
                compoundTag.put("Damage", new ShortTag(dataItem.data()));
            }
            if (compoundTag2 != null) {
                compoundTag.put("tag", compoundTag2);
            }
            JsonArray jsonArray = new JsonArray();
            JsonObject jsonObject2 = new JsonObject();
            jsonArray.add(jsonObject2);
            try {
                jsonObject2.addProperty("text", SerializerVersion.V1_13.toSNBT(compoundTag));
                jsonObject.add("value", jsonArray);
            }
            catch (Exception exception) {
                if (!Via.getConfig().logTextComponentConversionErrors()) break block10;
                Protocol1_12_2To1_13.LOGGER.log(Level.WARNING, "Error writing NBT in show_item: " + StringUtil.forLogging(jsonElement), exception);
            }
        }
    }

    @Override
    protected void handleTranslate(JsonObject jsonObject, String string) {
        super.handleTranslate(jsonObject, string);
        String string2 = Protocol1_12_2To1_13.MAPPINGS.getTranslateMapping().get(string);
        if (string2 == null) {
            string2 = Protocol1_12_2To1_13.MAPPINGS.getMojangTranslation().get(string);
        }
        if (string2 != null) {
            jsonObject.addProperty("translate", string2);
        }
    }
}

