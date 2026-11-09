/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_21to1_20_5.rewriter;

import com.viaversion.nbt.tag.ByteTag;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.api.rewriters.BackwardsFullStructuredItemRewriter;
import com.viaversion.viabackwards.api.rewriters.StructuredEnchantmentRewriter;
import com.viaversion.viabackwards.protocol.v1_21to1_20_5.Protocol1_21To1_20_5;
import com.viaversion.viabackwards.protocol.v1_21to1_20_5.storage.EnchantmentsPaintingsStorage;
import com.viaversion.viabackwards.protocol.v1_21to1_20_5.storage.OpenScreenStorage;
import com.viaversion.viabackwards.protocol.v1_21to1_20_5.storage.PlayerRotationStorage;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.EitherHolder;
import com.viaversion.viaversion.api.minecraft.Holder;
import com.viaversion.viaversion.api.minecraft.SoundEvent;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataContainer;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.minecraft.item.data.AttributeModifiers1_21;
import com.viaversion.viaversion.api.minecraft.item.data.Enchantments;
import com.viaversion.viaversion.api.minecraft.item.data.JukeboxPlayable;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntMap;
import com.viaversion.viaversion.libs.mcstructs.text.TextComponent;
import com.viaversion.viaversion.libs.mcstructs.text.TextFormatting;
import com.viaversion.viaversion.libs.mcstructs.text.components.StringComponent;
import com.viaversion.viaversion.libs.mcstructs.text.components.TranslationComponent;
import com.viaversion.viaversion.protocols.v1_20_2to1_20_3.rewriter.RecipeRewriter1_20_3;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.data.Enchantments1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ServerboundPacket1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ServerboundPackets1_20_5;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundPacket1_21;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundPackets1_21;
import com.viaversion.viaversion.rewriter.IdRewriteFunction;
import com.viaversion.viaversion.rewriter.text.ComponentRewriterBase;
import com.viaversion.viaversion.util.SerializerVersion;
import java.util.ArrayList;

public class BlockItemPacketRewriter1_21
extends BackwardsFullStructuredItemRewriter<ClientboundPacket1_21, ServerboundPacket1_20_5, Protocol1_21To1_20_5> {
    private final StructuredEnchantmentRewriter enchantmentRewriter = new StructuredEnchantmentRewriter(this);

    public BlockItemPacketRewriter1_21(Protocol1_21To1_20_5 protocol1_21To1_20_5) {
        super(protocol1_21To1_20_5);
    }

    @Override
    public void registerPackets() {
        ((Protocol1_21To1_20_5)this.protocol).replaceClientbound(ClientboundPackets1_21.OPEN_SCREEN, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            int n = packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.user().get(OpenScreenStorage.class).setMenuType(n);
            ((ComponentRewriterBase)((Protocol1_21To1_20_5)this.protocol).getComponentRewriter()).passthroughAndProcess(packetWrapper);
        });
        ((Protocol1_21To1_20_5)this.protocol).registerClientbound(ClientboundPackets1_21.CONTAINER_SET_DATA, packetWrapper -> {
            packetWrapper.passthrough(Types.UNSIGNED_BYTE);
            short s = packetWrapper.passthrough(Types.SHORT);
            if (s >= 4 && s <= 6) {
                OpenScreenStorage openScreenStorage = packetWrapper.user().get(OpenScreenStorage.class);
                if (openScreenStorage.menuType() != 13) {
                    return;
                }
                short s2 = packetWrapper.read(Types.SHORT);
                EnchantmentsPaintingsStorage enchantmentsPaintingsStorage = packetWrapper.user().get(EnchantmentsPaintingsStorage.class);
                String string = enchantmentsPaintingsStorage.enchantments().idToKey(s2);
                int n = string != null ? Enchantments1_20_5.keyToId(string) : -1;
                packetWrapper.write(Types.SHORT, (short)n);
            }
        });
        ((Protocol1_21To1_20_5)this.protocol).registerClientbound(ClientboundPackets1_21.HORSE_SCREEN_OPEN, packetWrapper -> {
            packetWrapper.passthrough(Types.UNSIGNED_BYTE);
            int n = packetWrapper.read(Types.VAR_INT);
            packetWrapper.write(Types.VAR_INT, n * 3 + 1);
        });
        ((Protocol1_21To1_20_5)this.protocol).replaceClientbound(ClientboundPackets1_21.LEVEL_EVENT, packetWrapper -> {
            int n = packetWrapper.passthrough(Types.INT);
            packetWrapper.passthrough(Types.BLOCK_POSITION1_14);
            int n2 = packetWrapper.read(Types.INT);
            if (n == 1010) {
                int n3 = packetWrapper.user().get(EnchantmentsPaintingsStorage.class).jubeboxSongToItem(n2);
                if (n3 == -1) {
                    packetWrapper.cancel();
                    return;
                }
                packetWrapper.write(Types.INT, n3);
            } else if (n == 2001) {
                packetWrapper.write(Types.INT, ((Protocol1_21To1_20_5)this.protocol).getMappingData().getNewBlockStateId(n2));
            } else {
                packetWrapper.write(Types.INT, n2);
            }
        });
        ((Protocol1_21To1_20_5)this.protocol).registerServerbound(ServerboundPackets1_20_5.USE_ITEM, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.VAR_INT);
            PlayerRotationStorage playerRotationStorage = packetWrapper.user().get(PlayerRotationStorage.class);
            packetWrapper.write(Types.FLOAT, Float.valueOf(playerRotationStorage.yaw()));
            packetWrapper.write(Types.FLOAT, Float.valueOf(playerRotationStorage.pitch()));
        });
        new RecipeRewriter1_20_3<ClientboundPackets1_21>(this.protocol).register1_20_5(ClientboundPackets1_21.UPDATE_RECIPES);
    }

    @Override
    public Item handleItemToClient(UserConnection userConnection, Item item) {
        boolean bl;
        if (item.isEmpty()) {
            return item;
        }
        StructuredDataContainer structuredDataContainer = item.dataContainer();
        structuredDataContainer.setIdLookup(this.protocol, true);
        EnchantmentsPaintingsStorage enchantmentsPaintingsStorage = userConnection.get(EnchantmentsPaintingsStorage.class);
        IdRewriteFunction idRewriteFunction = n -> {
            String string = enchantmentsPaintingsStorage.enchantments().idToKey(n);
            return string != null ? Enchantments1_20_5.keyToId(string) : -1;
        };
        StructuredEnchantmentRewriter.DescriptionSupplier descriptionSupplier = (n, n2) -> {
            Tag tag = enchantmentsPaintingsStorage.enchantmentDescription(n);
            if (tag == null) {
                return new StringTag("Unknown enchantment");
            }
            TextComponent textComponent = SerializerVersion.V1_20_5.toComponent(tag);
            textComponent.getStyle().setItalic(false);
            textComponent.getStyle().setFormatting(TextFormatting.GRAY);
            if (n2 != 1 || enchantmentsPaintingsStorage.enchantmentMaxLevel(n) != 1) {
                textComponent.getSiblings().add(new StringComponent(" "));
                textComponent.getSiblings().add(new TranslationComponent("enchantment.level.%s".formatted(n2), new Object[0]));
            }
            return SerializerVersion.V1_20_5.toTag(textComponent);
        };
        this.enchantmentRewriter.rewriteEnchantmentsToClient(structuredDataContainer, StructuredDataKey.ENCHANTMENTS1_20_5, idRewriteFunction, descriptionSupplier, false);
        this.enchantmentRewriter.rewriteEnchantmentsToClient(structuredDataContainer, StructuredDataKey.STORED_ENCHANTMENTS1_20_5, idRewriteFunction, descriptionSupplier, true);
        int n3 = item.identifier();
        this.backupInconvertibleData(item);
        item = super.handleItemToClient(userConnection, item);
        com.viaversion.viaversion.protocols.v1_20_5to1_21.rewriter.BlockItemPacketRewriter1_21.downgradeItemData(item);
        if (structuredDataContainer.has(StructuredDataKey.RARITY)) {
            return item;
        }
        boolean bl2 = bl = n3 == 1188;
        if (bl || n3 == 1200) {
            structuredDataContainer.set(StructuredDataKey.RARITY, bl ? 3 : 1);
            this.saveTag(this.createCustomTag(item), new ByteTag(true), "rarity");
        }
        return item;
    }

    @Override
    public Item handleItemToServer(UserConnection userConnection, Item item) {
        if (item.isEmpty()) {
            return item;
        }
        StructuredDataContainer structuredDataContainer = item.dataContainer();
        structuredDataContainer.setIdLookup(this.protocol, false);
        EnchantmentsPaintingsStorage enchantmentsPaintingsStorage = userConnection.get(EnchantmentsPaintingsStorage.class);
        this.rewriteEnchantmentToServer(enchantmentsPaintingsStorage, item, StructuredDataKey.ENCHANTMENTS1_20_5);
        this.rewriteEnchantmentToServer(enchantmentsPaintingsStorage, item, StructuredDataKey.STORED_ENCHANTMENTS1_20_5);
        this.enchantmentRewriter.handleToServer(item);
        item = super.handleItemToServer(userConnection, item);
        com.viaversion.viaversion.protocols.v1_20_5to1_21.rewriter.BlockItemPacketRewriter1_21.updateItemData(item);
        this.restoreInconvertibleData(item);
        CompoundTag compoundTag = structuredDataContainer.get(StructuredDataKey.CUSTOM_DATA);
        if (compoundTag == null) {
            return item;
        }
        if (compoundTag.remove(this.nbtTagName("rarity")) != null) {
            structuredDataContainer.remove(StructuredDataKey.RARITY);
            this.removeCustomTag(structuredDataContainer, compoundTag);
        }
        return item;
    }

    private void rewriteEnchantmentToServer(EnchantmentsPaintingsStorage enchantmentsPaintingsStorage, Item item, StructuredDataKey<Enchantments> structuredDataKey) {
        Enchantments enchantments = item.dataContainer().get(structuredDataKey);
        if (enchantments == null) {
            return;
        }
        ArrayList<PendingIdChange> arrayList = new ArrayList<PendingIdChange>();
        for (Int2IntMap.Entry object : enchantments.enchantments().int2IntEntrySet()) {
            int n;
            int n2 = object.getIntKey();
            String string = Enchantments1_20_5.idToKey(n2);
            if (string == null || n2 == (n = enchantmentsPaintingsStorage.enchantments().keyToId(string))) continue;
            int n3 = object.getIntValue();
            arrayList.add(new PendingIdChange(n2, n, n3));
        }
        for (PendingIdChange pendingIdChange : arrayList) {
            enchantments.remove(pendingIdChange.id);
        }
        for (PendingIdChange pendingIdChange : arrayList) {
            enchantments.add(pendingIdChange.mappedId, pendingIdChange.level);
        }
    }

    private void backupInconvertibleData(Item item) {
        Object object;
        Object object2;
        StructuredDataContainer structuredDataContainer = item.dataContainer();
        structuredDataContainer.setIdLookup(this.protocol, true);
        CompoundTag compoundTag2 = new CompoundTag();
        JukeboxPlayable jukeboxPlayable = structuredDataContainer.get(StructuredDataKey.JUKEBOX_PLAYABLE1_21);
        if (jukeboxPlayable != null) {
            object2 = new CompoundTag();
            if (jukeboxPlayable.song().hasHolder()) {
                object = jukeboxPlayable.song().holder();
                ((CompoundTag)object2).put("song", this.holderToTag(object, (jukeboxSong, compoundTag) -> {
                    this.saveSoundEventHolder((CompoundTag)compoundTag, jukeboxSong.soundEvent());
                    compoundTag.put("description", jukeboxSong.description());
                    compoundTag.putFloat("length_in_seconds", jukeboxSong.lengthInSeconds());
                    compoundTag.putInt("comparator_output", jukeboxSong.comparatorOutput());
                }));
            } else {
                ((CompoundTag)object2).putString("song_identifier", jukeboxPlayable.song().key());
            }
            ((CompoundTag)object2).putBoolean("show_in_tooltip", jukeboxPlayable.showInTooltip());
            compoundTag2.put("jukebox_playable", (Tag)object2);
        }
        if ((object2 = structuredDataContainer.get(StructuredDataKey.ATTRIBUTE_MODIFIERS1_21)) != null) {
            object = new ListTag<StringTag>(StringTag.class);
            for (AttributeModifiers1_21.AttributeModifier attributeModifier : ((AttributeModifiers1_21)object2).modifiers()) {
                ((ListTag)object).add(new StringTag(attributeModifier.modifier().id()));
            }
            compoundTag2.put("attribute_modifiers", (Tag)object);
        }
        if (!compoundTag2.isEmpty()) {
            this.saveTag(this.createCustomTag(item), compoundTag2, "inconvertible_data");
        }
    }

    private void restoreInconvertibleData(Item item) {
        EitherHolder<JukeboxPlayable.JukeboxSong> eitherHolder;
        Object object;
        Tag tag;
        StructuredDataContainer structuredDataContainer = item.dataContainer();
        CompoundTag compoundTag2 = structuredDataContainer.get(StructuredDataKey.CUSTOM_DATA);
        if (compoundTag2 == null || !((tag = compoundTag2.remove(this.nbtTagName("inconvertible_data"))) instanceof CompoundTag)) {
            return;
        }
        CompoundTag compoundTag3 = (CompoundTag)tag;
        tag = compoundTag3.getCompoundTag("jukebox_playable");
        if (tag != null) {
            object = compoundTag3.getString("song_identifier");
            eitherHolder = object != null ? EitherHolder.of((String)object) : EitherHolder.of(this.restoreHolder((CompoundTag)tag, "song", compoundTag -> {
                Holder<SoundEvent> holder = this.restoreSoundEventHolder((CompoundTag)compoundTag);
                Tag tag_r = compoundTag.get("description");
                float f = compoundTag.getFloat("length_in_seconds");
                int n = compoundTag.getInt("comparator_output");
                return new JukeboxPlayable.JukeboxSong(holder, tag_r, f, n);
            }));
            JukeboxPlayable jukeboxPlayable = new JukeboxPlayable(eitherHolder, compoundTag3.getBoolean("show_in_tooltip"));
            structuredDataContainer.set(StructuredDataKey.JUKEBOX_PLAYABLE1_21, jukeboxPlayable);
        }
        eitherHolder = compoundTag3.getListTag("attribute_modifiers", StringTag.class);
        object = structuredDataContainer.get(StructuredDataKey.ATTRIBUTE_MODIFIERS1_21);
        if (eitherHolder != null && object != null && ((ListTag)((Object)eitherHolder)).size() == ((AttributeModifiers1_21)object).modifiers().length) {
            for (int i = 0; i < ((ListTag)((Object)eitherHolder)).size(); ++i) {
                String string = ((StringTag)((ListTag)((Object)eitherHolder)).get(i)).getValue();
                AttributeModifiers1_21.AttributeModifier attributeModifier = ((AttributeModifiers1_21)object).modifiers()[i];
                AttributeModifiers1_21.ModifierData modifierData = new AttributeModifiers1_21.ModifierData(string, attributeModifier.modifier().amount(), attributeModifier.modifier().operation());
                ((AttributeModifiers1_21)object).modifiers()[i] = new AttributeModifiers1_21.AttributeModifier(attributeModifier.attribute(), modifierData, attributeModifier.slotType());
            }
        }
        this.removeCustomTag(structuredDataContainer, compoundTag2);
    }

    private record PendingIdChange(int id, int mappedId, int level) {
    }
}

