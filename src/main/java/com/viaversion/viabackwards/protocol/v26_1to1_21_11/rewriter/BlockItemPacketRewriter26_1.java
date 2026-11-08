/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v26_1to1_21_11.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.api.rewriters.BackwardsStructuredItemRewriter;
import com.viaversion.viabackwards.protocol.v26_1to1_21_11.Protocol26_1To1_21_11;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataContainer;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.api.minecraft.data.version.StructuredDataKeys1_21_11;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.type.types.version.Types1_20_5;
import com.viaversion.viaversion.protocols.v1_21_11to26_1.packet.ClientboundPacket26_1;
import com.viaversion.viaversion.protocols.v1_21_7to1_21_9.packet.ServerboundPacket1_21_9;

public class BlockItemPacketRewriter26_1
extends BackwardsStructuredItemRewriter<ClientboundPacket26_1, ServerboundPacket1_21_9, Protocol26_1To1_21_11> {
    public BlockItemPacketRewriter26_1(Protocol26_1To1_21_11 protocol26_1To1_21_11) {
        super(protocol26_1To1_21_11);
    }

    @Override
    protected void handleItemDataComponentsToClient(UserConnection userConnection, Item item, StructuredDataContainer structuredDataContainer) {
        super.handleItemDataComponentsToClient(userConnection, item, structuredDataContainer);
        com.viaversion.viaversion.protocols.v1_21_11to26_1.rewriter.BlockItemPacketRewriter26_1.downgradeData((StructuredDataKeys1_21_11)((Types1_20_5)((Protocol26_1To1_21_11)this.protocol).mappedTypes()).structuredDataKeys(), structuredDataContainer);
    }

    @Override
    protected void handleItemDataComponentsToServer(UserConnection userConnection, Item item, StructuredDataContainer structuredDataContainer) {
        super.handleItemDataComponentsToServer(userConnection, item, structuredDataContainer);
        com.viaversion.viaversion.protocols.v1_21_11to26_1.rewriter.BlockItemPacketRewriter26_1.upgradeData(this.protocol, userConnection, (StructuredDataKeys1_21_11)((Types1_20_5)((Protocol26_1To1_21_11)this.protocol).types()).structuredDataKeys(), structuredDataContainer);
    }

    @Override
    protected void restoreBackupData(Item item, StructuredDataContainer structuredDataContainer, CompoundTag compoundTag) {
        super.restoreBackupData(item, structuredDataContainer, compoundTag);
        Tag tag = compoundTag.remove(this.nbtTagName("backup"));
        if (!(tag instanceof CompoundTag)) {
            return;
        }
        CompoundTag compoundTag2 = (CompoundTag)tag;
        this.restoreIntData(StructuredDataKey.ADDITIONAL_TRADE_COST, structuredDataContainer, compoundTag2);
        this.restoreIntData(StructuredDataKey.DYE, structuredDataContainer, compoundTag2);
        this.restoreIntData(StructuredDataKey.CAT_SOUND_VARIANT, structuredDataContainer, compoundTag2);
        this.restoreIntData(StructuredDataKey.CHICKEN_SOUND_VARIANT, structuredDataContainer, compoundTag2);
        this.restoreIntData(StructuredDataKey.COW_SOUND_VARIANT, structuredDataContainer, compoundTag2);
        this.restoreIntData(StructuredDataKey.PIG_SOUND_VARIANT, structuredDataContainer, compoundTag2);
    }

    @Override
    protected void backupInconvertibleData(UserConnection userConnection, Item item, StructuredDataContainer structuredDataContainer, CompoundTag compoundTag) {
        super.backupInconvertibleData(userConnection, item, structuredDataContainer, compoundTag);
        this.saveIntData(StructuredDataKey.ADDITIONAL_TRADE_COST, structuredDataContainer, compoundTag);
        this.saveIntData(StructuredDataKey.DYE, structuredDataContainer, compoundTag);
        this.saveIntData(StructuredDataKey.CAT_SOUND_VARIANT, structuredDataContainer, compoundTag);
        this.saveIntData(StructuredDataKey.CHICKEN_SOUND_VARIANT, structuredDataContainer, compoundTag);
        this.saveIntData(StructuredDataKey.COW_SOUND_VARIANT, structuredDataContainer, compoundTag);
        this.saveIntData(StructuredDataKey.PIG_SOUND_VARIANT, structuredDataContainer, compoundTag);
    }
}

