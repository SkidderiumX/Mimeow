/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.storage;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.viabackwards.ViaBackwards;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.Protocol1_21_6To1_21_5;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data.Dialog;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.provider.DialogViewProvider;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.storage.RegistryAndTags;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.storage.ServerLinks;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.StorableObject;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.libs.fastutil.objects.Object2ObjectArrayMap;
import com.viaversion.viaversion.libs.fastutil.objects.Object2ObjectMap;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.packet.ServerboundPackets1_21_6;
import com.viaversion.viaversion.util.Key;
import java.util.UUID;

public class ClickEvents
implements StorableObject {
    private final Object2ObjectMap<String, CompoundTag> clickEvents = new Object2ObjectArrayMap<String, CompoundTag>();

    public String storeClickEvent(CompoundTag compoundTag) {
        String string = "vv_" + String.valueOf(UUID.randomUUID());
        if (this.clickEvents.containsKey(string)) {
            return this.storeClickEvent(compoundTag);
        }
        this.clickEvents.put(string, compoundTag);
        return string;
    }

    public boolean handleChatCommand(UserConnection userConnection, String string) {
        CompoundTag compoundTag = (CompoundTag)this.clickEvents.get(string);
        if (compoundTag != null) {
            ClickEvents.handleClickEvent(userConnection, compoundTag);
            return true;
        }
        return false;
    }

    public static void handleClickEvent(UserConnection userConnection, CompoundTag compoundTag) {
        String string = Key.stripMinecraftNamespace(compoundTag.getString("action"));
        if ("show_dialog".equals(string)) {
            Object object;
            if (!ViaBackwards.getConfig().dialogsViaChests()) {
                return;
            }
            RegistryAndTags registryAndTags = userConnection.get(RegistryAndTags.class);
            ServerLinks serverLinks = userConnection.get(ServerLinks.class);
            CompoundTag compoundTag2 = compoundTag.getCompoundTag("dialog");
            if (compoundTag2 == null && (object = compoundTag.getStringTag("dialog")) != null) {
                compoundTag2 = registryAndTags.fromRegistry(Key.stripMinecraftNamespace(((StringTag)object).getValue()));
            }
            object = Via.getManager().getProviders().get(DialogViewProvider.class);
            object.openDialog(userConnection, new Dialog(registryAndTags, serverLinks, compoundTag2));
        } else if ("custom".equals(string)) {
            String string2 = compoundTag.getString("id");
            CompoundTag compoundTag3 = compoundTag.getCompoundTag("payload");
            PacketWrapper packetWrapper = PacketWrapper.create(ServerboundPackets1_21_6.CUSTOM_CLICK_ACTION, userConnection);
            packetWrapper.write(Types.STRING, string2);
            packetWrapper.write(Types.CUSTOM_CLICK_ACTION_TAG, compoundTag3);
            packetWrapper.sendToServer(Protocol1_21_6To1_21_5.class);
        }
    }
}

