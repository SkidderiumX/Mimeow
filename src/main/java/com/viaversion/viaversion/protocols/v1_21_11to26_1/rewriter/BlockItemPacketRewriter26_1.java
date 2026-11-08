/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_21_11to26_1.rewriter;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.EitherHolder;
import com.viaversion.viaversion.api.minecraft.Holder;
import com.viaversion.viaversion.api.minecraft.HolderSet;
import com.viaversion.viaversion.api.minecraft.chunks.Chunk;
import com.viaversion.viaversion.api.minecraft.chunks.ChunkSection;
import com.viaversion.viaversion.api.minecraft.chunks.DataPalette;
import com.viaversion.viaversion.api.minecraft.chunks.PaletteType;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataContainer;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.api.minecraft.data.version.StructuredDataKeys1_21_11;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.minecraft.item.StructuredItem;
import com.viaversion.viaversion.api.minecraft.item.data.BlocksAttacks;
import com.viaversion.viaversion.api.minecraft.item.data.DamageResistant1_21_2;
import com.viaversion.viaversion.api.minecraft.item.data.DamageResistant26_1;
import com.viaversion.viaversion.api.minecraft.item.data.DamageType;
import com.viaversion.viaversion.api.minecraft.item.data.JukeboxPlayable;
import com.viaversion.viaversion.api.minecraft.item.data.ProvidesBannerPatterns;
import com.viaversion.viaversion.api.minecraft.item.data.ProvidesTrimMaterial;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.type.types.version.Types1_20_5;
import com.viaversion.viaversion.protocols.v1_21_11to26_1.Protocol1_21_11To26_1;
import com.viaversion.viaversion.protocols.v1_21_11to26_1.packet.ServerboundPacket26_1;
import com.viaversion.viaversion.protocols.v1_21_9to1_21_11.packet.ClientboundPacket1_21_11;
import com.viaversion.viaversion.protocols.v1_21_9to1_21_11.packet.ClientboundPackets1_21_11;
import com.viaversion.viaversion.rewriter.StructuredItemRewriter;
import com.viaversion.viaversion.util.Either;
import com.viaversion.viaversion.util.Key;
import org.checkerframework.checker.nullness.qual.Nullable;

public class BlockItemPacketRewriter26_1
extends StructuredItemRewriter<ClientboundPacket1_21_11, ServerboundPacket26_1, Protocol1_21_11To26_1> {
    public BlockItemPacketRewriter26_1(Protocol1_21_11To26_1 protocol1_21_11To26_1) {
        super(protocol1_21_11To26_1);
    }

    @Override
    public void registerPackets() {
        ((Protocol1_21_11To26_1)this.protocol).replaceClientbound(ClientboundPackets1_21_11.LEVEL_CHUNK_WITH_LIGHT, packetWrapper -> {
            Chunk chunk = ((Protocol1_21_11To26_1)this.protocol).getBlockRewriter().handleChunk1_18(packetWrapper);
            for (ChunkSection chunkSection : chunk.getSections()) {
                if (chunkSection.getNonAirBlocksCount() == 0) continue;
                DataPalette dataPalette = chunkSection.palette(PaletteType.BLOCKS);
                dataPalette.forEachMatchingCoordinate(n -> Protocol1_21_11To26_1.MAPPINGS.fluidBlockStates().contains(n), n -> chunkSection.setFluidCount(chunkSection.getFluidCount() + 1));
            }
            ((Protocol1_21_11To26_1)this.protocol).getBlockRewriter().handleBlockEntities(chunk, packetWrapper.user());
        });
    }

    @Override
    protected void handleItemDataComponentsToClient(UserConnection userConnection, Item item, StructuredDataContainer structuredDataContainer) {
        BlockItemPacketRewriter26_1.upgradeData(this.protocol, userConnection, (StructuredDataKeys1_21_11)((Types1_20_5)((Protocol1_21_11To26_1)this.protocol).types()).structuredDataKeys(), structuredDataContainer);
        super.handleItemDataComponentsToClient(userConnection, item, structuredDataContainer);
    }

    public static void upgradeData(Protocol<?, ?, ?, ?> protocol, UserConnection userConnection, StructuredDataKeys1_21_11 structuredDataKeys1_21_11, StructuredDataContainer structuredDataContainer) {
        structuredDataContainer.replace(StructuredDataKey.JUKEBOX_PLAYABLE1_21_5, StructuredDataKey.JUKEBOX_PLAYABLE26_1, jukeboxPlayable -> BlockItemPacketRewriter26_1.upgradeHolder(protocol, userConnection, jukeboxPlayable.song(), "jukebox_song"));
        structuredDataContainer.replace(StructuredDataKey.INSTRUMENT1_21_5, StructuredDataKey.INSTRUMENT26_1, eitherHolder -> BlockItemPacketRewriter26_1.upgradeHolder(protocol, userConnection, eitherHolder, "instrument"));
        structuredDataContainer.replace(StructuredDataKey.PROVIDES_TRIM_MATERIAL1_21_5, StructuredDataKey.PROVIDES_TRIM_MATERIAL26_1, providesTrimMaterial -> BlockItemPacketRewriter26_1.upgradeHolder(protocol, userConnection, providesTrimMaterial.material(), "trim_material"));
        structuredDataContainer.replace(StructuredDataKey.CHICKEN_VARIANT1_21_5, StructuredDataKey.CHICKEN_VARIANT26_1, either -> BlockItemPacketRewriter26_1.upgradeEitherVariant(protocol, userConnection, either, "chicken_variant"));
        structuredDataContainer.replace(StructuredDataKey.ZOMBIE_NAUTILUS_VARIANT1_21_11, StructuredDataKey.ZOMBIE_NAUTILUS_VARIANT26_1, either -> BlockItemPacketRewriter26_1.upgradeEitherVariant(protocol, userConnection, either, "zombie_nautilus_variant"));
        structuredDataContainer.replace(StructuredDataKey.DAMAGE_TYPE1_21_11, StructuredDataKey.DAMAGE_TYPE26_1, damageType -> BlockItemPacketRewriter26_1.upgradeEitherVariant(protocol, userConnection, damageType.id(), "damage_type"));
        structuredDataContainer.replace(StructuredDataKey.PROVIDES_BANNER_PATTERNS1_21_5, StructuredDataKey.PROVIDES_BANNER_PATTERNS26_1, key -> new ProvidesBannerPatterns(HolderSet.of(key.original())));
        structuredDataContainer.replace(StructuredDataKey.DAMAGE_RESISTANT1_21_2, StructuredDataKey.DAMAGE_RESISTANT26_1, damageResistant1_21_2 -> new DamageResistant26_1(HolderSet.of(damageResistant1_21_2.typesTagKey().original())));
        structuredDataContainer.replaceKey(StructuredDataKey.BLOCKS_ATTACKS1_21_5, StructuredDataKey.BLOCKS_ATTACKS26_1);
        Item[] itemArray = (Item[])structuredDataContainer.get(structuredDataKeys1_21_11.container);
        if (itemArray != null) {
            for (int i = 0; i < itemArray.length; ++i) {
                if (!itemArray[i].isEmpty()) continue;
                itemArray[i] = null;
            }
        }
    }

    private static @Nullable Integer upgradeEitherVariant(Protocol<?, ?, ?, ?> protocol, UserConnection userConnection, Either<Integer, String> either, String string) {
        return either.isLeft() ? either.left() : BlockItemPacketRewriter26_1.registryIdOrNull(protocol, userConnection, string, either.right());
    }

    private static <T> @Nullable Holder<T> upgradeHolder(Protocol<?, ?, ?, ?> protocol, UserConnection userConnection, EitherHolder<T> eitherHolder, String string) {
        if (eitherHolder.hasHolder()) {
            return eitherHolder.holder();
        }
        Integer n = BlockItemPacketRewriter26_1.registryIdOrNull(protocol, userConnection, string, eitherHolder.key());
        return n != null ? Holder.of(n.intValue()) : null;
    }

    private static @Nullable Integer registryIdOrNull(Protocol<?, ?, ?, ?> protocol, UserConnection userConnection, String string, String string2) {
        int n = protocol.getEntityRewriter().tracker(userConnection).registryKeys(string).keyToId(string2);
        return n != -1 ? Integer.valueOf(n) : null;
    }

    @Override
    protected void handleItemDataComponentsToServer(UserConnection userConnection, Item item, StructuredDataContainer structuredDataContainer) {
        BlockItemPacketRewriter26_1.downgradeData((StructuredDataKeys1_21_11)((Types1_20_5)((Protocol1_21_11To26_1)this.protocol).mappedTypes()).structuredDataKeys(), structuredDataContainer);
        super.handleItemDataComponentsToServer(userConnection, item, structuredDataContainer);
    }

    public static void downgradeData(StructuredDataKeys1_21_11 structuredDataKeys1_21_11, StructuredDataContainer structuredDataContainer) {
        structuredDataContainer.replace(StructuredDataKey.JUKEBOX_PLAYABLE26_1, StructuredDataKey.JUKEBOX_PLAYABLE1_21_5, holder -> new JukeboxPlayable((Holder<JukeboxPlayable.JukeboxSong>)holder, true));
        structuredDataContainer.replace(StructuredDataKey.INSTRUMENT26_1, StructuredDataKey.INSTRUMENT1_21_5, EitherHolder::of);
        structuredDataContainer.replace(StructuredDataKey.PROVIDES_TRIM_MATERIAL26_1, StructuredDataKey.PROVIDES_TRIM_MATERIAL1_21_5, holder -> new ProvidesTrimMaterial(EitherHolder.of(holder)));
        structuredDataContainer.replace(StructuredDataKey.CHICKEN_VARIANT26_1, StructuredDataKey.CHICKEN_VARIANT1_21_5, Either::left);
        structuredDataContainer.replace(StructuredDataKey.ZOMBIE_NAUTILUS_VARIANT26_1, StructuredDataKey.ZOMBIE_NAUTILUS_VARIANT1_21_11, Either::left);
        structuredDataContainer.replace(StructuredDataKey.DAMAGE_TYPE26_1, StructuredDataKey.DAMAGE_TYPE1_21_11, n -> new DamageType(Either.left(n)));
        structuredDataContainer.replace(StructuredDataKey.PROVIDES_BANNER_PATTERNS26_1, StructuredDataKey.PROVIDES_BANNER_PATTERNS1_21_5, providesBannerPatterns -> BlockItemPacketRewriter26_1.tagOrNull(providesBannerPatterns.patterns()));
        structuredDataContainer.replace(StructuredDataKey.DAMAGE_RESISTANT26_1, StructuredDataKey.DAMAGE_RESISTANT1_21_2, damageResistant26_1 -> {
            Key key = BlockItemPacketRewriter26_1.tagOrNull(damageResistant26_1.types());
            return key != null ? new DamageResistant1_21_2(key) : null;
        });
        structuredDataContainer.replace(StructuredDataKey.BLOCKS_ATTACKS26_1, StructuredDataKey.BLOCKS_ATTACKS1_21_5, blocksAttacks -> {
            if (blocksAttacks.bypassedBy() == null) {
                return blocksAttacks;
            }
            return new BlocksAttacks(blocksAttacks.blockDelaySeconds(), blocksAttacks.disableCooldownScale(), blocksAttacks.damageReductions(), blocksAttacks.itemDamage(), null, blocksAttacks.blockSound(), blocksAttacks.disableSound());
        });
        structuredDataContainer.remove(StructuredDataKey.ADDITIONAL_TRADE_COST);
        structuredDataContainer.remove(StructuredDataKey.DYE);
        structuredDataContainer.remove(StructuredDataKey.CAT_SOUND_VARIANT);
        structuredDataContainer.remove(StructuredDataKey.CHICKEN_SOUND_VARIANT);
        structuredDataContainer.remove(StructuredDataKey.COW_SOUND_VARIANT);
        structuredDataContainer.remove(StructuredDataKey.PIG_SOUND_VARIANT);
        Item[] itemArray = (Item[])structuredDataContainer.get(structuredDataKeys1_21_11.container);
        if (itemArray != null) {
            for (int i = 0; i < itemArray.length; ++i) {
                if (itemArray[i] != null) continue;
                itemArray[i] = StructuredItem.empty();
            }
        }
    }

    private static @Nullable Key tagOrNull(HolderSet holderSet) {
        return holderSet.hasTagKey() ? Key.of(holderSet.tagKey()) : null;
    }
}

