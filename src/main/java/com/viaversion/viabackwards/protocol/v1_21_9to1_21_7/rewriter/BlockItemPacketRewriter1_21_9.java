/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_21_9to1_21_7.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.api.rewriters.BackwardsStructuredItemRewriter;
import com.viaversion.viabackwards.protocol.v1_21_9to1_21_7.Protocol1_21_9To1_21_7;
import com.viaversion.viabackwards.protocol.v1_21_9to1_21_7.storage.DimensionScaleStorage;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.GameProfile;
import com.viaversion.viaversion.api.minecraft.ResolvableProfile;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataContainer;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.packet.ServerboundPacket1_21_6;
import com.viaversion.viaversion.protocols.v1_21_7to1_21_9.packet.ClientboundPacket1_21_9;
import com.viaversion.viaversion.protocols.v1_21_7to1_21_9.packet.ClientboundPackets1_21_9;

public class BlockItemPacketRewriter1_21_9
extends BackwardsStructuredItemRewriter<ClientboundPacket1_21_9, ServerboundPacket1_21_6, Protocol1_21_9To1_21_7> {
    public BlockItemPacketRewriter1_21_9(Protocol1_21_9To1_21_7 protocol1_21_9To1_21_7) {
        super(protocol1_21_9To1_21_7);
    }

    @Override
    public void registerPackets() {
        ((Protocol1_21_9To1_21_7)this.protocol).registerClientbound(ClientboundPackets1_21_9.INITIALIZE_BORDER, this::updateBorderCenter);
        ((Protocol1_21_9To1_21_7)this.protocol).registerClientbound(ClientboundPackets1_21_9.SET_BORDER_CENTER, this::updateBorderCenter);
    }

    @Override
    protected void handleItemDataComponentsToClient(UserConnection userConnection, Item item, StructuredDataContainer structuredDataContainer) {
        super.handleItemDataComponentsToClient(userConnection, item, structuredDataContainer);
        com.viaversion.viaversion.protocols.v1_21_7to1_21_9.rewriter.BlockItemPacketRewriter1_21_9.downgradeData(item, structuredDataContainer);
    }

    @Override
    protected void handleItemDataComponentsToServer(UserConnection userConnection, Item item, StructuredDataContainer structuredDataContainer) {
        super.handleItemDataComponentsToServer(userConnection, item, structuredDataContainer);
        com.viaversion.viaversion.protocols.v1_21_7to1_21_9.rewriter.BlockItemPacketRewriter1_21_9.upgradeData(item, structuredDataContainer);
    }

    @Override
    protected void backupInconvertibleData(UserConnection userConnection, Item item, StructuredDataContainer structuredDataContainer, CompoundTag compoundTag) {
        super.backupInconvertibleData(userConnection, item, structuredDataContainer, compoundTag);
        ResolvableProfile resolvableProfile = structuredDataContainer.get(StructuredDataKey.PROFILE1_21_9);
        if (resolvableProfile != null) {
            CompoundTag compoundTag2 = new CompoundTag();
            if (resolvableProfile.bodyTexture() != null) {
                compoundTag2.putString("body_texture", resolvableProfile.bodyTexture());
            }
            if (resolvableProfile.capeTexture() != null) {
                compoundTag2.putString("cape_texture", resolvableProfile.capeTexture());
            }
            if (resolvableProfile.elytraTexture() != null) {
                compoundTag2.putString("elytra_texture", resolvableProfile.elytraTexture());
            }
            if (resolvableProfile.modelType() != null) {
                compoundTag2.putBoolean("model", resolvableProfile.modelType() == 0);
            }
            if (!compoundTag2.isEmpty()) {
                compoundTag.put("profile", compoundTag2);
            }
        }
    }

    @Override
    protected void restoreBackupData(Item item, StructuredDataContainer structuredDataContainer, CompoundTag compoundTag) {
        super.restoreBackupData(item, structuredDataContainer, compoundTag);
        Tag tag = compoundTag.remove(this.nbtTagName("backup"));
        if (!(tag instanceof CompoundTag)) {
            return;
        }
        CompoundTag compoundTag2 = (CompoundTag)tag;
        tag = compoundTag2.getCompoundTag("profile");
        if (tag != null) {
            structuredDataContainer.replace(StructuredDataKey.PROFILE1_20_5, StructuredDataKey.PROFILE1_21_9, arg_0 -> BlockItemPacketRewriter1_21_9.lambda$restoreBackupData$0((CompoundTag)tag, arg_0));
        }
    }

    private void updateBorderCenter(PacketWrapper packetWrapper) {
        double d = packetWrapper.read(Types.DOUBLE);
        double d2 = packetWrapper.read(Types.DOUBLE);
        Object e = ((Protocol1_21_9To1_21_7)this.protocol).getEntityRewriter().tracker(packetWrapper.user());
        if (e.currentDimensionId() != -1) {
            double d3 = packetWrapper.user().get(DimensionScaleStorage.class).getScale(e.currentDimensionId());
            d *= d3;
            d2 *= d3;
        }
        packetWrapper.write(Types.DOUBLE, d);
        packetWrapper.write(Types.DOUBLE, d2);
    }

    private static /* synthetic */ ResolvableProfile lambda$restoreBackupData$0(CompoundTag compoundTag, GameProfile gameProfile) {
        return new ResolvableProfile(gameProfile, compoundTag.getString("body_texture"), compoundTag.getString("cape_texture"), compoundTag.getString("elytra_texture"), compoundTag.contains("model") ? Integer.valueOf(compoundTag.getBoolean("model") ? 0 : 1) : null);
    }
}

