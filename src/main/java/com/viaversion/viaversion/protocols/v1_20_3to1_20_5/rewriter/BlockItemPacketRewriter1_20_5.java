/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_20_3to1_20_5.rewriter;

import com.viaversion.nbt.tag.ByteTag;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.IntArrayTag;
import com.viaversion.nbt.tag.IntTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.NumberTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.ParticleMappings;
import com.viaversion.viaversion.api.minecraft.GameProfile;
import com.viaversion.viaversion.api.minecraft.GlobalBlockPosition;
import com.viaversion.viaversion.api.minecraft.Holder;
import com.viaversion.viaversion.api.minecraft.HolderSet;
import com.viaversion.viaversion.api.minecraft.Particle;
import com.viaversion.viaversion.api.minecraft.SoundEvent;
import com.viaversion.viaversion.api.minecraft.blockentity.BlockEntity;
import com.viaversion.viaversion.api.minecraft.chunks.Chunk;
import com.viaversion.viaversion.api.minecraft.data.StructuredData;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataContainer;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.api.minecraft.item.DataItem;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.minecraft.item.StructuredItem;
import com.viaversion.viaversion.api.minecraft.item.data.AdventureModePredicate;
import com.viaversion.viaversion.api.minecraft.item.data.ArmorTrim;
import com.viaversion.viaversion.api.minecraft.item.data.ArmorTrimMaterial;
import com.viaversion.viaversion.api.minecraft.item.data.ArmorTrimPattern;
import com.viaversion.viaversion.api.minecraft.item.data.AttributeModifiers1_20_5;
import com.viaversion.viaversion.api.minecraft.item.data.BannerPattern;
import com.viaversion.viaversion.api.minecraft.item.data.BannerPatternLayer;
import com.viaversion.viaversion.api.minecraft.item.data.Bee;
import com.viaversion.viaversion.api.minecraft.item.data.BlockPredicate;
import com.viaversion.viaversion.api.minecraft.item.data.BlockStateProperties;
import com.viaversion.viaversion.api.minecraft.item.data.DebugStickState;
import com.viaversion.viaversion.api.minecraft.item.data.DyedColor;
import com.viaversion.viaversion.api.minecraft.item.data.Enchantments;
import com.viaversion.viaversion.api.minecraft.item.data.FilterableComponent;
import com.viaversion.viaversion.api.minecraft.item.data.FilterableString;
import com.viaversion.viaversion.api.minecraft.item.data.FireworkExplosion;
import com.viaversion.viaversion.api.minecraft.item.data.Fireworks;
import com.viaversion.viaversion.api.minecraft.item.data.FoodProperties1_20_5;
import com.viaversion.viaversion.api.minecraft.item.data.Instrument1_20_5;
import com.viaversion.viaversion.api.minecraft.item.data.LodestoneTracker;
import com.viaversion.viaversion.api.minecraft.item.data.PotDecorations;
import com.viaversion.viaversion.api.minecraft.item.data.PotionContents;
import com.viaversion.viaversion.api.minecraft.item.data.PotionEffect;
import com.viaversion.viaversion.api.minecraft.item.data.PotionEffectData;
import com.viaversion.viaversion.api.minecraft.item.data.StatePropertyMatcher;
import com.viaversion.viaversion.api.minecraft.item.data.SuspiciousStewEffect;
import com.viaversion.viaversion.api.minecraft.item.data.ToolProperties;
import com.viaversion.viaversion.api.minecraft.item.data.ToolRule;
import com.viaversion.viaversion.api.minecraft.item.data.Unbreakable;
import com.viaversion.viaversion.api.minecraft.item.data.WritableBook;
import com.viaversion.viaversion.api.minecraft.item.data.WrittenBook;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.Types1_20_3;
import com.viaversion.viaversion.api.type.types.version.VersionedTypes;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntOpenHashMap;
import com.viaversion.viaversion.libs.fastutil.objects.Object2ObjectArrayMap;
import com.viaversion.viaversion.protocols.v1_20_2to1_20_3.packet.ClientboundPacket1_20_3;
import com.viaversion.viaversion.protocols.v1_20_2to1_20_3.packet.ClientboundPackets1_20_3;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.Protocol1_20_3To1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.data.Attributes1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.data.BannerPatterns1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.data.DyeColors;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.data.Enchantments1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.data.EquipmentSlots1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.data.Instruments1_20_3;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.data.MapDecorations1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.data.MaxStackSize1_20_3;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.data.PotionEffects1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.data.Potions1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ServerboundPacket1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ServerboundPackets1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.rewriter.EntityPacketRewriter1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.rewriter.RecipeRewriter1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.rewriter.StructuredDataConverter;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.storage.ArmorTrimStorage;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.storage.BannerPatternStorage;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.storage.TagKeys;
import com.viaversion.viaversion.rewriter.ItemRewriter;
import com.viaversion.viaversion.rewriter.text.ComponentRewriterBase;
import com.viaversion.viaversion.util.ComponentUtil;
import com.viaversion.viaversion.util.Either;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.MathUtil;
import com.viaversion.viaversion.util.SerializerVersion;
import com.viaversion.viaversion.util.UUIDUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import org.checkerframework.checker.nullness.qual.Nullable;

public class BlockItemPacketRewriter1_20_5
extends ItemRewriter<ClientboundPacket1_20_3, ServerboundPacket1_20_5, Protocol1_20_3To1_20_5> {
    public static final String[] MOB_TAGS = new String[]{"NoAI", "Silent", "NoGravity", "Glowing", "Invulnerable", "Health", "Age", "Variant", "HuntingCooldown", "BucketVariantTag"};
    public static final String[] ATTRIBUTE_OPERATIONS = new String[]{"add_value", "add_multiplied_base", "add_multiplied_total"};
    private static final StructuredDataConverter DATA_CONVERTER = new StructuredDataConverter(false);
    private static final GameProfile.Property[] EMPTY_PROPERTIES = new GameProfile.Property[0];
    private static final StatePropertyMatcher[] EMPTY_PROPERTY_MATCHERS = new StatePropertyMatcher[0];

    public BlockItemPacketRewriter1_20_5(Protocol1_20_3To1_20_5 protocol1_20_3To1_20_5) {
        super(protocol1_20_3To1_20_5, Types.ITEM1_20_2, Types.ITEM1_20_2_ARRAY, VersionedTypes.V1_20_5.item, VersionedTypes.V1_20_5.itemArray);
    }

    @Override
    public void registerPackets() {
        ((Protocol1_20_3To1_20_5)this.protocol).replaceClientbound(ClientboundPackets1_20_3.LEVEL_CHUNK_WITH_LIGHT, packetWrapper -> {
            Chunk chunk = ((Protocol1_20_3To1_20_5)this.protocol).getBlockRewriter().handleChunk1_18(packetWrapper);
            for (int i = 0; i < chunk.blockEntities().size(); ++i) {
                BlockEntity blockEntity = chunk.blockEntities().get(i);
                if (this.isUnknownBlockEntity(blockEntity.typeId())) {
                    chunk.blockEntities().remove(i--);
                    continue;
                }
                this.updateBlockEntityTag(packetWrapper.user(), null, blockEntity.tag());
            }
        });
        ((Protocol1_20_3To1_20_5)this.protocol).replaceClientbound(ClientboundPackets1_20_3.BLOCK_ENTITY_DATA, packetWrapper -> {
            packetWrapper.passthrough(Types.BLOCK_POSITION1_14);
            int n = packetWrapper.passthrough(Types.VAR_INT);
            if (this.isUnknownBlockEntity(n)) {
                packetWrapper.cancel();
                return;
            }
            CompoundTag compoundTag = packetWrapper.read(Types.TRUSTED_COMPOUND_TAG);
            if (compoundTag != null) {
                this.updateBlockEntityTag(packetWrapper.user(), null, compoundTag);
            } else {
                compoundTag = new CompoundTag();
            }
            packetWrapper.write(Types.TRUSTED_COMPOUND_TAG, compoundTag);
        });
        ((Protocol1_20_3To1_20_5)this.protocol).registerServerbound(ServerboundPackets1_20_5.CONTAINER_BUTTON_CLICK, packetWrapper -> {
            byte by = packetWrapper.read(Types.VAR_INT).byteValue();
            byte by2 = packetWrapper.read(Types.VAR_INT).byteValue();
            packetWrapper.write(Types.BYTE, by);
            packetWrapper.write(Types.BYTE, by2);
        });
        ((Protocol1_20_3To1_20_5)this.protocol).replaceClientbound(ClientboundPackets1_20_3.UPDATE_ADVANCEMENTS, packetWrapper -> {
            packetWrapper.passthrough(Types.BOOLEAN);
            int n = packetWrapper.passthrough(Types.VAR_INT);
            for (int i = 0; i < n; ++i) {
                int n2;
                packetWrapper.passthrough(Types.STRING);
                packetWrapper.passthrough(Types.OPTIONAL_STRING);
                if (packetWrapper.passthrough(Types.BOOLEAN).booleanValue()) {
                    packetWrapper.passthrough(Types.TRUSTED_TAG);
                    packetWrapper.passthrough(Types.TRUSTED_TAG);
                    Item item = this.handleNonEmptyItemToClient(packetWrapper.user(), packetWrapper.read(this.itemType()));
                    packetWrapper.write(this.mappedItemType(), item);
                    packetWrapper.passthrough(Types.VAR_INT);
                    n2 = packetWrapper.passthrough(Types.INT);
                    if ((n2 & 1) != 0) {
                        packetWrapper.passthrough(Types.STRING);
                    }
                    packetWrapper.passthrough(Types.FLOAT);
                    packetWrapper.passthrough(Types.FLOAT);
                }
                int n3 = packetWrapper.passthrough(Types.VAR_INT);
                for (n2 = 0; n2 < n3; ++n2) {
                    packetWrapper.passthrough(Types.STRING_ARRAY);
                }
                packetWrapper.passthrough(Types.BOOLEAN);
            }
        });
        ((Protocol1_20_3To1_20_5)this.protocol).replaceClientbound(ClientboundPackets1_20_3.LEVEL_PARTICLES, packetWrapper -> {
            int n = packetWrapper.read(Types.VAR_INT);
            packetWrapper.passthrough(Types.BOOLEAN);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.DOUBLE);
            float f = packetWrapper.passthrough(Types.FLOAT).floatValue();
            float f2 = packetWrapper.passthrough(Types.FLOAT).floatValue();
            float f3 = packetWrapper.passthrough(Types.FLOAT).floatValue();
            float f4 = packetWrapper.passthrough(Types.FLOAT).floatValue();
            int n2 = packetWrapper.passthrough(Types.INT);
            ParticleMappings particleMappings = ((Protocol1_20_3To1_20_5)this.protocol).getMappingData().getParticleMappings();
            int n3 = particleMappings.getNewId(n);
            Particle particle = new Particle(n3);
            if (n3 == particleMappings.mappedId("entity_effect")) {
                int n4;
                if (f4 == 0.0f) {
                    n4 = 0;
                } else if (n2 != 0) {
                    n4 = ThreadLocalRandom.current().nextInt();
                } else {
                    int n5 = Math.round(f * 255.0f);
                    int n6 = Math.round(f2 * 255.0f);
                    int n7 = Math.round(f3 * 255.0f);
                    n4 = n5 << 16 | n6 << 8 | n7;
                }
                particle.add(Types.INT, EntityPacketRewriter1_20_5.withAlpha(n4));
            } else if (n == particleMappings.id("dust_color_transition")) {
                for (int i = 0; i < 7; ++i) {
                    particle.add(Types.FLOAT, packetWrapper.read(Types.FLOAT));
                }
                particle.add(Types.FLOAT, (Float)particle.removeArgument(3).getValue());
            } else if (particleMappings.isBlockParticle(n)) {
                int n8 = packetWrapper.read(Types.VAR_INT);
                particle.add(Types.VAR_INT, ((Protocol1_20_3To1_20_5)this.protocol).getMappingData().getNewBlockStateId(n8));
            } else if (particleMappings.isItemParticle(n)) {
                Item item = this.handleNonEmptyItemToClient(packetWrapper.user(), packetWrapper.read(Types.ITEM1_20_2));
                particle.add(VersionedTypes.V1_20_5.item, item);
            } else if (n == particleMappings.id("dust")) {
                for (int i = 0; i < 4; ++i) {
                    particle.add(Types.FLOAT, packetWrapper.read(Types.FLOAT));
                }
            } else if (n == particleMappings.id("vibration")) {
                int n9 = packetWrapper.read(Types.VAR_INT);
                particle.add(Types.VAR_INT, n9);
                if (n9 == 0) {
                    particle.add(Types.BLOCK_POSITION1_14, packetWrapper.read(Types.BLOCK_POSITION1_14));
                } else if (n9 == 1) {
                    particle.add(Types.VAR_INT, packetWrapper.read(Types.VAR_INT));
                    particle.add(Types.FLOAT, packetWrapper.read(Types.FLOAT));
                } else {
                    ((Protocol1_20_3To1_20_5)this.protocol).getLogger().warning("Unknown vibration path position source type: " + n9);
                }
                particle.add(Types.VAR_INT, packetWrapper.read(Types.VAR_INT));
            } else if (n == particleMappings.id("sculk_charge")) {
                particle.add(Types.FLOAT, packetWrapper.read(Types.FLOAT));
            } else if (n == particleMappings.id("shriek")) {
                particle.add(Types.VAR_INT, packetWrapper.read(Types.VAR_INT));
            }
            packetWrapper.write(VersionedTypes.V1_20_5.particle, particle);
        });
        ((Protocol1_20_3To1_20_5)this.protocol).registerClientbound(ClientboundPackets1_20_3.EXPLODE, packetWrapper -> {
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.FLOAT);
            int n = packetWrapper.passthrough(Types.VAR_INT);
            for (int i = 0; i < n; ++i) {
                packetWrapper.passthrough(Types.BYTE);
                packetWrapper.passthrough(Types.BYTE);
                packetWrapper.passthrough(Types.BYTE);
            }
            packetWrapper.passthrough(Types.FLOAT);
            packetWrapper.passthrough(Types.FLOAT);
            packetWrapper.passthrough(Types.FLOAT);
            packetWrapper.passthrough(Types.VAR_INT);
            Particle particle = packetWrapper.passthroughAndMap(Types1_20_3.PARTICLE, VersionedTypes.V1_20_5.particle);
            Particle particle2 = packetWrapper.passthroughAndMap(Types1_20_3.PARTICLE, VersionedTypes.V1_20_5.particle);
            ((Protocol1_20_3To1_20_5)this.protocol).getParticleRewriter().rewriteParticle(packetWrapper.user(), particle);
            ((Protocol1_20_3To1_20_5)this.protocol).getParticleRewriter().rewriteParticle(packetWrapper.user(), particle2);
            String string = packetWrapper.read(Types.STRING);
            Float f = packetWrapper.read(Types.OPTIONAL_FLOAT);
            packetWrapper.write(Types.SOUND_EVENT, Holder.of(new SoundEvent(string, f)));
        });
        ((Protocol1_20_3To1_20_5)this.protocol).replaceClientbound(ClientboundPackets1_20_3.MERCHANT_OFFERS, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            int n = packetWrapper.passthrough(Types.VAR_INT);
            for (int i = 0; i < n; ++i) {
                Item item = this.handleNonEmptyItemToClient(packetWrapper.user(), packetWrapper.read(Types.ITEM1_20_2));
                packetWrapper.write(VersionedTypes.V1_20_5.itemCost, item);
                Item item2 = this.handleNonEmptyItemToClient(packetWrapper.user(), packetWrapper.read(Types.ITEM1_20_2));
                packetWrapper.write(VersionedTypes.V1_20_5.item, item2);
                Item item3 = packetWrapper.read(Types.ITEM1_20_2);
                if (item3 != null && (item3 = this.handleItemToClient(packetWrapper.user(), item3)).isEmpty()) {
                    item3 = null;
                }
                packetWrapper.write(VersionedTypes.V1_20_5.optionalItemCost, item3);
                packetWrapper.passthrough(Types.BOOLEAN);
                packetWrapper.passthrough(Types.INT);
                packetWrapper.passthrough(Types.INT);
                packetWrapper.passthrough(Types.INT);
                packetWrapper.passthrough(Types.INT);
                packetWrapper.passthrough(Types.FLOAT);
                packetWrapper.passthrough(Types.INT);
            }
        });
        RecipeRewriter1_20_5 recipeRewriter1_20_5 = new RecipeRewriter1_20_5(this.protocol);
        ((Protocol1_20_3To1_20_5)this.protocol).registerClientbound(ClientboundPackets1_20_3.UPDATE_RECIPES, packetWrapper -> {
            int n = packetWrapper.passthrough(Types.VAR_INT);
            for (int i = 0; i < n; ++i) {
                String string = packetWrapper.read(Types.STRING);
                packetWrapper.passthrough(Types.STRING);
                packetWrapper.write(Types.VAR_INT, ((Protocol1_20_3To1_20_5)this.protocol).getMappingData().getRecipeSerializerMappings().mappedId(string));
                recipeRewriter1_20_5.handleRecipeType(packetWrapper, string);
            }
        });
        ((Protocol1_20_3To1_20_5)this.protocol).replaceServerbound(ServerboundPackets1_20_5.SET_CREATIVE_MODE_SLOT, packetWrapper -> {
            if (!((Protocol1_20_3To1_20_5)this.protocol).getEntityRewriter().tracker(packetWrapper.user()).canInstaBuild()) {
                packetWrapper.cancel();
                return;
            }
            packetWrapper.passthrough(Types.SHORT);
            packetWrapper.write(this.itemType(), this.handleItemToServer(packetWrapper.user(), packetWrapper.read(this.mappedItemType())));
        });
    }

    public Item handleNonEmptyItemToClient(UserConnection userConnection, @Nullable Item item) {
        if ((item = this.handleItemToClient(userConnection, item)).isEmpty()) {
            return new StructuredItem(1, 1);
        }
        return item;
    }

    @Override
    public Item handleItemToClient(UserConnection userConnection, @Nullable Item item) {
        if (item == null) {
            return StructuredItem.empty();
        }
        CompoundTag compoundTag = item.tag();
        Item item2 = this.toStructuredItem(userConnection, item);
        if (compoundTag != null) {
            compoundTag.putBoolean(this.nbtTagName(), true);
            item2.dataContainer().set(StructuredDataKey.CUSTOM_DATA, compoundTag);
        }
        this.appendItemDataFixComponents(userConnection, item2);
        if (Via.getConfig().handleInvalidItemCount() && item2.amount() > MaxStackSize1_20_3.getMaxStackSize(item2.identifier())) {
            item2.dataContainer().set(StructuredDataKey.MAX_STACK_SIZE, item2.amount());
        }
        return super.handleItemToClient(userConnection, item2);
    }

    @Override
    public @Nullable Item handleItemToServer(UserConnection userConnection, Item item) {
        if (item.isEmpty()) {
            return null;
        }
        super.handleItemToServer(userConnection, item);
        return this.toOldItem(userConnection, item, DATA_CONVERTER);
    }

    public Item toOldItem(UserConnection userConnection, Item item, StructuredDataConverter structuredDataConverter) {
        StructuredDataContainer structuredDataContainer = item.dataContainer();
        structuredDataContainer.setIdLookup(this.protocol, true);
        StructuredData<CompoundTag> structuredData = structuredDataContainer.getNonEmptyData(StructuredDataKey.CUSTOM_DATA);
        CompoundTag compoundTag = structuredData != null ? structuredData.value() : new CompoundTag();
        DataItem dataItem = new DataItem(item.identifier(), (byte)item.amount(), compoundTag);
        if (!structuredDataConverter.backupInconvertibleData() && structuredData != null && compoundTag.remove(this.nbtTagName()) != null) {
            return dataItem;
        }
        for (StructuredData<?> structuredData2 : structuredDataContainer.data().values()) {
            structuredDataConverter.writeToTag(userConnection, structuredData2, compoundTag);
        }
        if (compoundTag.isEmpty()) {
            dataItem.setTag(null);
        }
        return dataItem;
    }

    public Item toStructuredItem(UserConnection userConnection, Item item) {
        CompoundTag compoundTag;
        ListTag<StringTag> listTag;
        ListTag<CompoundTag> listTag2;
        Tag tag;
        boolean bl;
        int n;
        String string;
        Tag tag2;
        NumberTag numberTag;
        ListTag<StringTag> listTag3;
        CompoundTag compoundTag2;
        CompoundTag compoundTag3;
        Tag tag3;
        CompoundTag compoundTag4;
        CompoundTag compoundTag5;
        CompoundTag compoundTag6;
        CompoundTag compoundTag7;
        NumberTag numberTag2;
        NumberTag numberTag3;
        CompoundTag compoundTag8 = item.tag();
        StructuredItem structuredItem = new StructuredItem(item.identifier(), (byte)item.amount(), new StructuredDataContainer());
        StructuredDataContainer structuredDataContainer = structuredItem.dataContainer();
        structuredDataContainer.setIdLookup(this.protocol, true);
        if (compoundTag8 == null) {
            return structuredItem;
        }
        int n2 = compoundTag8.getInt("HideFlags");
        if ((n2 & 0x20) != 0) {
            structuredDataContainer.set(StructuredDataKey.HIDE_ADDITIONAL_TOOLTIP);
        }
        this.updateDisplay(userConnection, structuredDataContainer, compoundTag8.getCompoundTag("display"), n2);
        NumberTag numberTag4 = compoundTag8.getNumberTag("Damage");
        if (numberTag4 != null && numberTag4.asInt() > 0) {
            structuredDataContainer.set(StructuredDataKey.DAMAGE, numberTag4.asInt());
        }
        if ((numberTag3 = compoundTag8.getNumberTag("RepairCost")) != null && numberTag3.asInt() > 0) {
            structuredDataContainer.set(StructuredDataKey.REPAIR_COST, numberTag3.asInt());
        }
        if ((numberTag2 = compoundTag8.getNumberTag("CustomModelData")) != null) {
            structuredDataContainer.set(StructuredDataKey.CUSTOM_MODEL_DATA1_20_5, numberTag2.asInt());
        }
        if ((compoundTag7 = compoundTag8.getCompoundTag("BlockStateTag")) != null) {
            this.updateBlockState(structuredDataContainer, compoundTag7);
        }
        if ((compoundTag6 = compoundTag8.getCompoundTag("EntityTag")) != null) {
            if ((compoundTag6 = compoundTag6.copy()).contains("variant")) {
                compoundTag6.putString("id", "minecraft:painting");
            }
            if (compoundTag6.contains("id")) {
                structuredDataContainer.set(StructuredDataKey.ENTITY_DATA1_20_5, compoundTag6);
            }
        }
        if ((compoundTag5 = compoundTag8.getCompoundTag("BlockEntityTag")) != null) {
            compoundTag4 = compoundTag5.copy();
            this.updateBlockEntityTag(userConnection, structuredDataContainer, compoundTag4);
            tag3 = compoundTag4.getCompoundTag("SpawnData");
            if (tag3 == null) {
                tag3 = compoundTag4.getCompoundTag("spawn_data");
            }
            if (tag3 != null && (compoundTag3 = ((CompoundTag)tag3).getCompoundTag("entity")) != null && compoundTag3.getString("id") != null) {
                this.addBlockEntityId(compoundTag4, compoundTag4.contains("SpawnData") ? "mob_spawner" : "trial_spawner");
            }
            if (compoundTag4.contains("id")) {
                structuredItem.dataContainer().set(StructuredDataKey.BLOCK_ENTITY_DATA1_20_5, compoundTag4);
            }
        }
        if ((compoundTag4 = compoundTag8.getCompoundTag("DebugProperty")) != null) {
            structuredDataContainer.set(StructuredDataKey.DEBUG_STICK_STATE, new DebugStickState(compoundTag4.copy()));
        }
        if ((tag3 = compoundTag8.getNumberTag("Unbreakable")) != null && tag3.asBoolean()) {
            structuredDataContainer.set(StructuredDataKey.UNBREAKABLE1_20_5, new Unbreakable((n2 & 4) == 0));
        }
        if ((compoundTag3 = compoundTag8.getCompoundTag("Trim")) != null) {
            this.updateArmorTrim(userConnection, structuredDataContainer, compoundTag3, (n2 & 0x80) == 0);
        }
        if ((compoundTag2 = compoundTag8.getCompoundTag("Explosion")) != null) {
            structuredDataContainer.set(StructuredDataKey.FIREWORK_EXPLOSION, this.readExplosion(compoundTag2));
        }
        if ((listTag3 = compoundTag8.getListTag("Recipes", StringTag.class)) != null) {
            structuredDataContainer.set(StructuredDataKey.RECIPES, listTag3);
        }
        if ((numberTag = compoundTag8.getNumberTag("LodestoneTracked")) != null) {
            tag2 = compoundTag8.getCompoundTag("LodestonePos");
            string = compoundTag8.getString("LodestoneDimension");
            this.updateLodestoneTracker(numberTag.asBoolean(), (CompoundTag)tag2, string, structuredDataContainer);
        }
        if ((tag2 = compoundTag8.getListTag("effects", CompoundTag.class)) != null) {
            this.updateEffects((ListTag<CompoundTag>)tag2, structuredDataContainer);
        }
        if ((string = compoundTag8.getString("instrument")) != null && (n = Instruments1_20_3.keyToId(string)) != -1) {
            structuredDataContainer.set(StructuredDataKey.INSTRUMENT1_20_5, Holder.of(n));
        }
        ListTag<CompoundTag> listTag4 = compoundTag8.getListTag("AttributeModifiers", CompoundTag.class);
        boolean bl2 = bl = (n2 & 2) == 0;
        if (listTag4 != null) {
            this.updateAttributes(structuredDataContainer, listTag4, bl);
        } else if (!bl) {
            structuredDataContainer.set(StructuredDataKey.ATTRIBUTE_MODIFIERS1_20_5, new AttributeModifiers1_20_5(new AttributeModifiers1_20_5.AttributeModifier[0], false));
        }
        CompoundTag compoundTag9 = compoundTag8.getCompoundTag("Fireworks");
        if (compoundTag9 != null) {
            tag = compoundTag9.getListTag("Explosions", CompoundTag.class);
            this.updateFireworks(structuredDataContainer, compoundTag9, (ListTag<CompoundTag>)tag);
        }
        if (item.identifier() == 1085) {
            this.updateWritableBookPages(structuredDataContainer, compoundTag8);
        } else if (item.identifier() == 1086) {
            this.updateWrittenBookPages(userConnection, structuredDataContainer, compoundTag8);
        }
        this.updatePotionTags(structuredDataContainer, compoundTag8);
        this.updateMobTags(structuredDataContainer, compoundTag8);
        this.updateItemList(userConnection, structuredDataContainer, compoundTag8, "ChargedProjectiles", StructuredDataKey.V1_20_5.chargedProjectiles);
        if (item.identifier() == 927) {
            this.updateItemList(userConnection, structuredDataContainer, compoundTag8, "Items", StructuredDataKey.V1_20_5.bundleContents);
        }
        this.updateEnchantments(structuredDataContainer, compoundTag8, "Enchantments", StructuredDataKey.ENCHANTMENTS1_20_5, (n2 & 1) == 0);
        this.updateEnchantments(structuredDataContainer, compoundTag8, "StoredEnchantments", StructuredDataKey.STORED_ENCHANTMENTS1_20_5, (n2 & 0x20) == 0);
        tag = compoundTag8.getNumberTag("map");
        if (tag != null) {
            structuredDataContainer.set(StructuredDataKey.MAP_ID, tag.asInt());
        }
        if ((listTag2 = compoundTag8.getListTag("Decorations", CompoundTag.class)) != null) {
            this.updateMapDecorations(structuredDataContainer, listTag2);
        }
        this.updateProfile(structuredDataContainer, compoundTag8.get("SkullOwner"));
        ListTag<StringTag> listTag5 = compoundTag8.getListTag("CanPlaceOn", StringTag.class);
        if (listTag5 != null) {
            structuredDataContainer.set(StructuredDataKey.CAN_PLACE_ON1_20_5, this.updateBlockPredicates(userConnection, listTag5, (n2 & 0x10) == 0));
        }
        if ((listTag = compoundTag8.getListTag("CanDestroy", StringTag.class)) != null) {
            structuredDataContainer.set(StructuredDataKey.CAN_BREAK1_20_5, this.updateBlockPredicates(userConnection, listTag, (n2 & 8) == 0));
        }
        if ((compoundTag = StructuredDataConverter.removeBackupTag(compoundTag8)) != null) {
            this.restoreFromBackupTag(compoundTag, structuredDataContainer);
        }
        return structuredItem;
    }

    private void appendItemDataFixComponents(UserConnection userConnection, Item item) {
        ProtocolVersion protocolVersion = userConnection.getProtocolInfo().serverProtocolVersion();
        if (protocolVersion.olderThanOrEqualTo(ProtocolVersion.v1_17_1) && item.identifier() == 1182) {
            item.dataContainer().set(StructuredDataKey.MAX_DAMAGE, 326);
        }
    }

    private int unmappedItemId(String string) {
        return ((Protocol1_20_3To1_20_5)this.protocol).getMappingData().getFullItemMappings().id(string);
    }

    private int toMappedItemId(String string) {
        int n = this.unmappedItemId(string);
        return n != -1 ? ((Protocol1_20_3To1_20_5)this.protocol).getMappingData().getNewItemId(n) : -1;
    }

    private void restoreFromBackupTag(CompoundTag compoundTag, StructuredDataContainer structuredDataContainer) {
        ListTag<CompoundTag> listTag;
        IntTag intTag;
        CompoundTag compoundTag2;
        CompoundTag compoundTag3;
        IntTag intTag2;
        IntTag intTag3;
        IntTag intTag4;
        Tag tag;
        ByteTag byteTag;
        IntArrayTag intArrayTag;
        CompoundTag compoundTag4 = compoundTag.getCompoundTag("instrument");
        if (compoundTag4 != null) {
            this.restoreInstrumentFromBackup(compoundTag4, structuredDataContainer);
        }
        if ((intArrayTag = compoundTag.getIntArrayTag("pot_decorations")) != null && intArrayTag.getValue().length == 4) {
            structuredDataContainer.set(StructuredDataKey.POT_DECORATIONS, new PotDecorations(intArrayTag.getValue()));
        }
        if ((byteTag = compoundTag.getByteTag("enchantment_glint_override")) != null) {
            structuredDataContainer.set(StructuredDataKey.ENCHANTMENT_GLINT_OVERRIDE, byteTag.asBoolean());
        }
        if (compoundTag.contains("hide_tooltip")) {
            structuredDataContainer.set(StructuredDataKey.HIDE_TOOLTIP);
        }
        if ((tag = compoundTag.get("intangible_projectile")) != null) {
            structuredDataContainer.set(StructuredDataKey.INTANGIBLE_PROJECTILE, tag);
        }
        if ((intTag4 = compoundTag.getIntTag("max_stack_size")) != null) {
            structuredDataContainer.set(StructuredDataKey.MAX_STACK_SIZE, MathUtil.clamp(intTag4.asInt(), 1, 99));
        }
        if ((intTag3 = compoundTag.getIntTag("max_damage")) != null) {
            structuredDataContainer.set(StructuredDataKey.MAX_DAMAGE, Math.max(intTag3.asInt(), 1));
        }
        if ((intTag2 = compoundTag.getIntTag("rarity")) != null) {
            structuredDataContainer.set(StructuredDataKey.RARITY, intTag2.asInt());
        }
        if ((compoundTag3 = compoundTag.getCompoundTag("food")) != null) {
            this.restoreFoodFromBackup(compoundTag3, structuredDataContainer);
        }
        if (compoundTag.contains("fire_resistant")) {
            structuredDataContainer.set(StructuredDataKey.FIRE_RESISTANT);
        }
        if ((compoundTag2 = compoundTag.getCompoundTag("tool")) != null) {
            this.restoreToolFromBackup(compoundTag2, structuredDataContainer);
        }
        if ((intTag = compoundTag.getIntTag("ominous_bottle_amplifier")) != null) {
            structuredDataContainer.set(StructuredDataKey.OMINOUS_BOTTLE_AMPLIFIER, MathUtil.clamp(intTag.asInt(), 0, 4));
        }
        if ((listTag = compoundTag.getListTag("banner_patterns", CompoundTag.class)) != null) {
            this.restoreBannerPatternsFromBackup(listTag, structuredDataContainer);
        }
    }

    private void restoreInstrumentFromBackup(CompoundTag compoundTag, StructuredDataContainer structuredDataContainer) {
        Holder<Object> holder;
        int n = compoundTag.getInt("use_duration");
        float f = compoundTag.getFloat("range");
        CompoundTag compoundTag2 = compoundTag.getCompoundTag("sound_event");
        if (compoundTag2 != null) {
            StringTag stringTag = compoundTag2.getStringTag("identifier");
            if (stringTag == null) {
                return;
            }
            holder = Holder.of(new SoundEvent(stringTag.getValue(), compoundTag2.contains("fixed_range") ? Float.valueOf(compoundTag2.getFloat("fixed_range")) : null));
        } else {
            holder = Holder.of(compoundTag.getInt("sound_event"));
        }
        structuredDataContainer.set(StructuredDataKey.INSTRUMENT1_20_5, Holder.of(new Instrument1_20_5(holder, n, f)));
    }

    private void restoreFoodFromBackup(CompoundTag compoundTag, StructuredDataContainer structuredDataContainer) {
        int n = compoundTag.getInt("nutrition");
        float f = compoundTag.getFloat("saturation");
        boolean bl = compoundTag.getBoolean("can_always_eat");
        float f2 = compoundTag.getFloat("eat_seconds");
        ListTag<CompoundTag> listTag = compoundTag.getListTag("possible_effects", CompoundTag.class);
        if (listTag == null) {
            return;
        }
        ArrayList<FoodProperties1_20_5.FoodEffect> arrayList = new ArrayList<FoodProperties1_20_5.FoodEffect>();
        for (CompoundTag compoundTag2 : listTag) {
            CompoundTag compoundTag3 = compoundTag2.getCompoundTag("effect");
            if (compoundTag3 == null) continue;
            arrayList.add(new FoodProperties1_20_5.FoodEffect(new PotionEffect(compoundTag3.getInt("effect"), this.readPotionEffectData(compoundTag3)), compoundTag2.getFloat("probability")));
        }
        structuredDataContainer.set(StructuredDataKey.FOOD1_20_5, new FoodProperties1_20_5(n, f, bl, f2, null, arrayList.toArray(new FoodProperties1_20_5.FoodEffect[0])));
    }

    private void restoreToolFromBackup(CompoundTag compoundTag, StructuredDataContainer structuredDataContainer) {
        ListTag<CompoundTag> listTag = compoundTag.getListTag("rules", CompoundTag.class);
        if (listTag == null) {
            return;
        }
        ArrayList<ToolRule> arrayList = new ArrayList<ToolRule>();
        for (CompoundTag compoundTag2 : listTag) {
            HolderSet holderSet = null;
            Tag tag = compoundTag2.get("blocks");
            if (tag instanceof StringTag) {
                StringTag stringTag = (StringTag)tag;
                holderSet = HolderSet.of(stringTag.getValue());
            } else {
                tag = compoundTag2.getIntArrayTag("blocks");
                if (tag != null) {
                    holderSet = HolderSet.of(((IntArrayTag)tag).getValue());
                }
            }
            if (holderSet == null) continue;
            arrayList.add(new ToolRule(holderSet, compoundTag2.contains("speed") ? Float.valueOf(compoundTag2.getFloat("speed")) : null, compoundTag2.contains("correct_for_drops") ? Boolean.valueOf(compoundTag2.getBoolean("correct_for_drops")) : null));
        }
        structuredDataContainer.set(StructuredDataKey.TOOL1_20_5, new ToolProperties(arrayList.toArray(new ToolRule[0]), compoundTag.getFloat("default_mining_speed"), compoundTag.getInt("damage_per_block")));
    }

    private void restoreBannerPatternsFromBackup(ListTag<CompoundTag> listTag, StructuredDataContainer structuredDataContainer) {
        ArrayList<BannerPatternLayer> arrayList = new ArrayList<BannerPatternLayer>();
        for (CompoundTag compoundTag : listTag) {
            Holder<Object> holder;
            CompoundTag compoundTag2 = compoundTag.getCompoundTag("pattern");
            if (compoundTag2 != null) {
                String string = compoundTag2.getString("asset_id");
                String string2 = compoundTag2.getString("translation_key");
                holder = Holder.of(new BannerPattern(string, string2));
            } else {
                holder = Holder.of(compoundTag.getInt("pattern"));
            }
            int n = compoundTag.getInt("dye_color");
            arrayList.add(new BannerPatternLayer(holder, n));
        }
        structuredDataContainer.set(StructuredDataKey.BANNER_PATTERNS, arrayList.toArray(new BannerPatternLayer[0]));
    }

    private AdventureModePredicate updateBlockPredicates(UserConnection userConnection, ListTag<StringTag> listTag, boolean bl) {
        BlockPredicate[] blockPredicateArray = (BlockPredicate[])listTag.stream().map(StringTag::getValue).map(string -> this.deserializeBlockPredicate(userConnection, (String)string)).filter(Objects::nonNull).toArray(BlockPredicate[]::new);
        return new AdventureModePredicate(blockPredicateArray, bl);
    }

    private @Nullable BlockPredicate deserializeBlockPredicate(UserConnection userConnection, String string) {
        CompoundTag compoundTag;
        ArrayList<StatePropertyMatcher> arrayList;
        HolderSet holderSet;
        block11: {
            int n;
            String string2;
            int n2 = string.indexOf(91);
            int n3 = string.indexOf(123);
            int n4 = string.length();
            if (n2 != -1) {
                n4 = n2;
            }
            if (n3 != -1) {
                int n5 = n4 = n2 != -1 ? Math.min(n2, n3) : n3;
            }
            if (!(string2 = string.substring(0, n4)).startsWith("#")) {
                n = Protocol1_20_3To1_20_5.MAPPINGS.blockId(string2);
                if (n == -1) {
                    return null;
                }
                holderSet = HolderSet.of(new int[]{n});
            } else {
                String string3 = string2.substring(1);
                if (!userConnection.get(TagKeys.class).isValidIdentifier(string3)) {
                    return null;
                }
                holderSet = HolderSet.of(string3);
            }
            n = string.indexOf(93);
            arrayList = new ArrayList<StatePropertyMatcher>();
            if (n2 != -1 && n != -1) {
                for (String string4 : string.substring(n2 + 1, n).split(",")) {
                    int n6 = string4.indexOf(61);
                    if (n6 == -1) continue;
                    String string5 = string4.substring(0, n6).trim();
                    String string6 = string4.substring(n6 + 1).trim();
                    arrayList.add(new StatePropertyMatcher(string5, Either.left(string6)));
                }
            }
            int n7 = string.indexOf(125);
            compoundTag = null;
            if (n3 != -1 && n7 != -1) {
                try {
                    compoundTag = (CompoundTag)SerializerVersion.V1_20_3.toTag(string.substring(n3, n7 + 1));
                }
                catch (Exception exception) {
                    if (!Via.getManager().isDebug()) break block11;
                    Protocol1_20_3To1_20_5.LOGGER.log(Level.SEVERE, "Failed to parse block predicate tag: " + string.substring(n3, n7 + 1), exception);
                }
            }
        }
        return new BlockPredicate(holderSet, arrayList.isEmpty() ? null : arrayList.toArray(EMPTY_PROPERTY_MATCHERS), compoundTag);
    }

    private void updateAttributes(StructuredDataContainer structuredDataContainer, ListTag<CompoundTag> listTag, boolean bl) {
        ArrayList<AttributeModifiers1_20_5.AttributeModifier> arrayList = new ArrayList<AttributeModifiers1_20_5.AttributeModifier>();
        for (int i = 0; i < listTag.size(); ++i) {
            int n;
            int n2;
            int n3;
            CompoundTag compoundTag = listTag.get(i);
            String string = compoundTag.getString("AttributeName");
            String string2 = compoundTag.getString("Name");
            NumberTag numberTag = compoundTag.getNumberTag("Amount");
            IntArrayTag intArrayTag = compoundTag.getIntArrayTag("UUID");
            String string3 = compoundTag.getString("Slot", "any");
            if (string2 == null || string == null || numberTag == null || intArrayTag == null || (n3 = EquipmentSlots1_20_5.keyToId(string3)) == -1 || (n2 = compoundTag.getInt("Operation")) < 0 || n2 > 2 || (n = Attributes1_20_5.keyToId(string)) == -1) continue;
            arrayList.add(new AttributeModifiers1_20_5.AttributeModifier(n, new AttributeModifiers1_20_5.ModifierData(UUIDUtil.fromIntArray(intArrayTag.getValue()), string2, numberTag.asDouble(), n2), n3));
        }
        structuredDataContainer.set(StructuredDataKey.ATTRIBUTE_MODIFIERS1_20_5, new AttributeModifiers1_20_5(arrayList.toArray(new AttributeModifiers1_20_5.AttributeModifier[0]), bl));
    }

    private PotionEffectData readPotionEffectData(CompoundTag compoundTag) {
        byte by = compoundTag.getByte("amplifier");
        int n = compoundTag.getInt("duration");
        boolean bl = compoundTag.getBoolean("ambient");
        boolean bl2 = compoundTag.getBoolean("show_particles");
        boolean bl3 = compoundTag.getBoolean("show_icon");
        PotionEffectData potionEffectData = null;
        CompoundTag compoundTag2 = compoundTag.getCompoundTag("hidden_effect");
        if (compoundTag2 != null) {
            potionEffectData = this.readPotionEffectData(compoundTag2);
        }
        return new PotionEffectData(by, n, bl, bl2, bl3, potionEffectData);
    }

    private void updatePotionTags(StructuredDataContainer structuredDataContainer, CompoundTag compoundTag2) {
        int n;
        String string = compoundTag2.getString("Potion");
        Integer n2 = null;
        if (string != null && (n = Potions1_20_5.keyToId(string)) != -1) {
            n2 = n;
        }
        NumberTag numberTag = compoundTag2.getNumberTag("CustomPotionColor");
        ListTag<CompoundTag> listTag = compoundTag2.getListTag("custom_potion_effects", CompoundTag.class);
        PotionEffect[] potionEffectArray = null;
        if (listTag != null) {
            potionEffectArray = (PotionEffect[])listTag.stream().map(compoundTag -> {
                String string_r = compoundTag.getString("id");
                if (string_r == null) {
                    return null;
                }
                int n_r = PotionEffects1_20_5.keyToId(string_r);
                if (n_r == -1) {
                    return null;
                }
                return new PotionEffect(n_r, this.readPotionEffectData((CompoundTag)compoundTag));
            }).filter(Objects::nonNull).toArray(PotionEffect[]::new);
        }
        if (n2 != null || numberTag != null || potionEffectArray != null) {
            structuredDataContainer.set(StructuredDataKey.POTION_CONTENTS1_20_5, new PotionContents(n2, numberTag != null ? Integer.valueOf(numberTag.asInt()) : null, potionEffectArray != null ? potionEffectArray : new PotionEffect[]{}));
        }
    }

    private void updateArmorTrim(UserConnection userConnection, StructuredDataContainer structuredDataContainer, CompoundTag compoundTag, boolean bl) {
        Holder<Object> holder;
        Object object;
        Object object2;
        Object object3;
        Tag tag;
        Holder<Object> holder2;
        Tag tag2;
        Tag tag3 = compoundTag.get("material");
        ArmorTrimStorage armorTrimStorage = userConnection.get(ArmorTrimStorage.class);
        if (tag3 instanceof StringTag) {
            tag2 = (StringTag)tag3;
            int n = armorTrimStorage.trimMaterials().keyToId(((StringTag)tag2).getValue());
            if (n == -1) {
                return;
            }
            holder2 = Holder.of(n);
        } else if (tag3 instanceof CompoundTag) {
            CompoundTag compoundTag2 = (CompoundTag)tag3;
            StringTag stringTag = compoundTag2.getStringTag("asset_name");
            tag = compoundTag2.getStringTag("ingredient");
            if (stringTag == null || tag == null) {
                return;
            }
            int n = StructuredDataConverter.removeItemBackupTag(compoundTag2, this.toMappedItemId(((StringTag)tag).getValue()));
            if (n == -1) {
                return;
            }
            object3 = compoundTag2.getNumberTag("item_model_index");
            object2 = compoundTag2.getCompoundTag("override_armor_materials");
            Tag tag4 = compoundTag2.get("description");
            object = new Object2ObjectArrayMap();
            if (object2 != null) {
                for (Map.Entry<String, Tag> entry : ((CompoundTag)object2).entrySet()) {
                    Tag tag5 = entry.getValue();
                    if (!(tag5 instanceof StringTag)) continue;
                    StringTag stringTag2 = (StringTag)tag5;
                    object.put(entry.getKey(), stringTag2.getValue());
                }
            }
            holder2 = Holder.of(new ArmorTrimMaterial(stringTag.getValue(), n, object3 != null ? object3.asFloat() : 0.0f, (Map<String, String>)object, tag4));
        } else {
            return;
        }
        tag2 = compoundTag.get("pattern");
        if (tag2 instanceof StringTag) {
            Tag tag6 = tag2;
            int n = armorTrimStorage.trimPatterns().keyToId(((StringTag)tag6).getValue());
            if (n == -1) {
                return;
            }
            holder = Holder.of(n);
        } else if (tag2 instanceof CompoundTag) {
            tag = (CompoundTag)tag2;
            object3 = ((CompoundTag)tag).getString("assetId");
            object2 = ((CompoundTag)tag).getString("templateItem");
            if (object3 == null || object2 == null) {
                return;
            }
            int n = StructuredDataConverter.removeItemBackupTag((CompoundTag)tag, this.toMappedItemId((String)object2));
            if (n == -1) {
                return;
            }
            object = ((CompoundTag)tag).get("description");
            boolean bl2 = ((CompoundTag)tag).getBoolean("decal");
            holder = Holder.of(new ArmorTrimPattern((String)object3, n, (Tag)object, bl2));
        } else {
            return;
        }
        structuredDataContainer.set(StructuredDataKey.TRIM1_20_5, new ArmorTrim(holder2, holder, bl));
    }

    private void updateMobTags(StructuredDataContainer structuredDataContainer, CompoundTag compoundTag) {
        CompoundTag compoundTag2 = new CompoundTag();
        for (String string : MOB_TAGS) {
            Tag tag = compoundTag.get(string);
            if (tag == null) continue;
            compoundTag2.put(string, tag);
        }
        if (!compoundTag2.isEmpty()) {
            structuredDataContainer.set(StructuredDataKey.BUCKET_ENTITY_DATA, compoundTag2);
        }
    }

    private void updateBlockState(StructuredDataContainer structuredDataContainer, CompoundTag compoundTag) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        for (Map.Entry<String, Tag> entry : compoundTag.entrySet()) {
            Tag tag = entry.getValue();
            if (tag instanceof StringTag) {
                StringTag stringTag = (StringTag)tag;
                hashMap.put(entry.getKey(), stringTag.getValue());
                continue;
            }
            if (!(tag instanceof IntTag)) continue;
            IntTag intTag = (IntTag)tag;
            hashMap.put(entry.getKey(), Integer.toString(intTag.asInt()));
        }
        structuredDataContainer.set(StructuredDataKey.BLOCK_STATE, new BlockStateProperties(hashMap));
    }

    private void updateFireworks(StructuredDataContainer structuredDataContainer, CompoundTag compoundTag, ListTag<CompoundTag> listTag) {
        byte by = compoundTag.getByte("Flight");
        Fireworks fireworks = new Fireworks(by, listTag != null ? (FireworkExplosion[])listTag.stream().limit(256L).map(this::readExplosion).toArray(FireworkExplosion[]::new) : new FireworkExplosion[]{});
        structuredDataContainer.set(StructuredDataKey.FIREWORKS, fireworks);
    }

    private void updateEffects(ListTag<CompoundTag> listTag, StructuredDataContainer structuredDataContainer) {
        ArrayList<SuspiciousStewEffect> arrayList = new ArrayList<SuspiciousStewEffect>();
        for (int i = 0; i < listTag.size(); ++i) {
            CompoundTag compoundTag = listTag.get(i);
            String string = compoundTag.getString("id", "luck");
            int n = compoundTag.getInt("duration");
            int n2 = PotionEffects1_20_5.keyToId(string);
            if (n2 == -1) continue;
            SuspiciousStewEffect suspiciousStewEffect = new SuspiciousStewEffect(n2, n);
            arrayList.add(suspiciousStewEffect);
        }
        structuredDataContainer.set(StructuredDataKey.SUSPICIOUS_STEW_EFFECTS, (SuspiciousStewEffect[])arrayList.toArray(SuspiciousStewEffect[]::new));
    }

    private void updateLodestoneTracker(boolean bl, CompoundTag compoundTag, String string, StructuredDataContainer structuredDataContainer) {
        GlobalBlockPosition globalBlockPosition = null;
        if (compoundTag != null && string != null) {
            int n = compoundTag.getInt("X");
            int n2 = compoundTag.getInt("Y");
            int n3 = compoundTag.getInt("Z");
            globalBlockPosition = new GlobalBlockPosition(string, n, n2, n3);
        }
        structuredDataContainer.set(StructuredDataKey.LODESTONE_TRACKER, new LodestoneTracker(globalBlockPosition, bl));
    }

    private FireworkExplosion readExplosion(CompoundTag compoundTag) {
        int n = compoundTag.getInt("Type");
        IntArrayTag intArrayTag = compoundTag.getIntArrayTag("Colors");
        IntArrayTag intArrayTag2 = compoundTag.getIntArrayTag("FadeColors");
        boolean bl = compoundTag.getBoolean("Trail");
        boolean bl2 = compoundTag.getBoolean("Flicker");
        return new FireworkExplosion(n, intArrayTag != null ? intArrayTag.getValue() : new int[]{}, intArrayTag2 != null ? intArrayTag2.getValue() : new int[]{}, bl, bl2);
    }

    private void updateWritableBookPages(StructuredDataContainer structuredDataContainer, CompoundTag compoundTag) {
        ListTag<StringTag> listTag = compoundTag.getListTag("pages", StringTag.class);
        CompoundTag compoundTag2 = compoundTag.getCompoundTag("filtered_pages");
        if (listTag == null) {
            return;
        }
        ArrayList<FilterableString> arrayList = new ArrayList<FilterableString>();
        for (int i = 0; i < listTag.size(); ++i) {
            StringTag stringTag;
            StringTag stringTag2 = listTag.get(i);
            String string = null;
            if (compoundTag2 != null && (stringTag = compoundTag2.getStringTag(String.valueOf(i))) != null) {
                string = this.limit(stringTag.getValue(), 1024);
            }
            arrayList.add(new FilterableString(this.limit(stringTag2.getValue(), 1024), string));
            if (arrayList.size() == 100) break;
        }
        structuredDataContainer.set(StructuredDataKey.WRITABLE_BOOK_CONTENT, new WritableBook(arrayList.toArray(new FilterableString[0])));
    }

    private void updateWrittenBookPages(UserConnection userConnection, StructuredDataContainer structuredDataContainer, CompoundTag compoundTag) {
        Object object;
        int n;
        boolean bl;
        String string = compoundTag.getString("title");
        String string2 = compoundTag.getString("author");
        ListTag<StringTag> listTag = compoundTag.getListTag("pages", StringTag.class);
        boolean bl2 = bl = string2 != null && string != null && string.length() <= 32 && listTag != null;
        if (bl) {
            for (StringTag object22 : listTag) {
                if (object22.getValue().length() <= Short.MAX_VALUE) continue;
                bl = false;
                break;
            }
        }
        ArrayList arrayList = new ArrayList();
        if (bl) {
            CompoundTag compoundTag2 = compoundTag.getCompoundTag("filtered_pages");
            for (n = 0; n < listTag.size(); ++n) {
                Tag tag;
                StringTag stringTag = listTag.get(n);
                object = null;
                if (compoundTag2 != null && (tag = compoundTag2.getStringTag(String.valueOf(n))) != null) {
                    try {
                        object = this.jsonToTag(userConnection, (StringTag)tag);
                    }
                    catch (Exception exception) {
                        continue;
                    }
                }
                try {
                    tag = this.jsonToTag(userConnection, stringTag);
                }
                catch (Exception exception) {
                    continue;
                }
                arrayList.add(new FilterableComponent(tag, (Tag)object));
            }
        } else {
            CompoundTag compoundTag3 = new CompoundTag();
            compoundTag3.putString("text", "* Invalid book tag *");
            compoundTag3.putString("color", "#AA0000");
            arrayList.add(new FilterableComponent(compoundTag3, null));
        }
        String string3 = compoundTag.getString("filtered_title");
        n = compoundTag.getInt("generation");
        boolean bl3 = compoundTag.getBoolean("resolved");
        object = new WrittenBook(new FilterableString(this.limit(string == null ? "" : string, 32), this.limit(string3, 32)), string2 == null ? "" : string2, MathUtil.clamp(n, 0, 3), arrayList.toArray(new FilterableComponent[0]), bl3);
        structuredDataContainer.set(StructuredDataKey.WRITTEN_BOOK_CONTENT, object);
    }

    private Tag jsonToTag(UserConnection userConnection, StringTag stringTag) {
        Tag tag = ComponentUtil.jsonStringToTag(stringTag.getValue(), SerializerVersion.V1_20_3, SerializerVersion.V1_20_3);
        ((ComponentRewriterBase)((Protocol1_20_3To1_20_5)this.protocol).getComponentRewriter()).processTag(userConnection, tag);
        return tag;
    }

    private void updateItemList(UserConnection userConnection, StructuredDataContainer structuredDataContainer, CompoundTag compoundTag2, String string, StructuredDataKey<Item[]> structuredDataKey) {
        ListTag<CompoundTag> listTag = compoundTag2.getListTag(string, CompoundTag.class);
        if (listTag != null) {
            Item[] itemArray = (Item[])listTag.stream().limit(256L).map(compoundTag -> this.itemFromTag(userConnection, (CompoundTag)compoundTag)).filter(item -> !item.isEmpty()).toArray(Item[]::new);
            structuredDataContainer.set(structuredDataKey, itemArray);
        }
    }

    private Item itemFromTag(UserConnection userConnection, CompoundTag compoundTag) {
        String string = compoundTag.getString("id");
        if (string == null) {
            return StructuredItem.empty();
        }
        int n = StructuredDataConverter.removeItemBackupTag(compoundTag, this.unmappedItemId(string));
        if (n == -1) {
            return StructuredItem.empty();
        }
        byte by = compoundTag.getByte("Count", (byte)1);
        CompoundTag compoundTag2 = compoundTag.getCompoundTag("tag");
        return this.handleItemToClient(userConnection, new DataItem(n, by, compoundTag2));
    }

    private void updateEnchantments(StructuredDataContainer structuredDataContainer, CompoundTag compoundTag, String string, StructuredDataKey<Enchantments> structuredDataKey, boolean bl) {
        ListTag<CompoundTag> listTag = compoundTag.getListTag(string, CompoundTag.class);
        if (listTag == null) {
            return;
        }
        Enchantments enchantments = new Enchantments(new Int2IntOpenHashMap(), bl);
        for (CompoundTag compoundTag2 : listTag) {
            int n;
            String string2 = compoundTag2.getString("id");
            NumberTag numberTag = compoundTag2.getNumberTag("lvl");
            if (string2 == null || numberTag == null) continue;
            if (Key.stripMinecraftNamespace(string2).equals("sweeping")) {
                string2 = Key.namespaced("sweeping_edge");
            }
            if ((n = Enchantments1_20_5.keyToId(string2)) == -1) continue;
            enchantments.enchantments().put(n, MathUtil.clamp(numberTag.asInt(), 0, 255));
        }
        structuredDataContainer.set(structuredDataKey, enchantments);
        if (!listTag.isEmpty() && enchantments.size() == 0) {
            structuredDataContainer.set(StructuredDataKey.ENCHANTMENT_GLINT_OVERRIDE, true);
        }
    }

    private void updateProfile(StructuredDataContainer structuredDataContainer, Tag tag) {
        if (tag instanceof StringTag) {
            StringTag stringTag = (StringTag)tag;
            String string = stringTag.getValue();
            if (this.isValidName(string)) {
                structuredDataContainer.set(StructuredDataKey.PROFILE1_20_5, new GameProfile(string, null, EMPTY_PROPERTIES));
            }
        } else if (tag instanceof CompoundTag) {
            CompoundTag compoundTag = (CompoundTag)tag;
            String string = compoundTag.getString("Name", "");
            if (!this.isValidName(string)) {
                string = null;
            }
            IntArrayTag intArrayTag = compoundTag.getIntArrayTag("Id");
            UUID uUID = null;
            if (intArrayTag != null) {
                uUID = UUIDUtil.fromIntArray(intArrayTag.getValue());
            }
            ArrayList<GameProfile.Property> arrayList = new ArrayList<GameProfile.Property>(1);
            CompoundTag compoundTag2 = compoundTag.getCompoundTag("Properties");
            if (compoundTag2 != null) {
                this.updateProperties(compoundTag2, arrayList);
            }
            structuredDataContainer.set(StructuredDataKey.PROFILE1_20_5, new GameProfile(string, uUID, arrayList.toArray(EMPTY_PROPERTIES)));
        }
    }

    private @Nullable String limit(@Nullable String string, int n) {
        if (string == null) {
            return null;
        }
        return string.length() > n ? string.substring(0, n) : string;
    }

    private void updateBees(StructuredDataContainer structuredDataContainer, ListTag<CompoundTag> listTag) {
        Bee[] beeArray = (Bee[])listTag.stream().map(compoundTag -> {
            CompoundTag compoundTag2 = compoundTag.getCompoundTag("EntityData");
            if (compoundTag2 == null) {
                return null;
            }
            int n = compoundTag.getInt("TicksInHive");
            int n2 = compoundTag.getInt("MinOccupationTicks");
            return new Bee(compoundTag2, n, n2);
        }).filter(Objects::nonNull).toArray(Bee[]::new);
        structuredDataContainer.set(StructuredDataKey.BEES1_20_5, beeArray);
    }

    private void updateProperties(CompoundTag compoundTag, List<GameProfile.Property> list) {
        for (Map.Entry<String, Tag> entry : compoundTag.entrySet()) {
            Tag tag = entry.getValue();
            if (!(tag instanceof ListTag)) continue;
            ListTag listTag = (ListTag)tag;
            for (Tag tag2 : listTag) {
                if (!(tag2 instanceof CompoundTag)) continue;
                CompoundTag compoundTag2 = (CompoundTag)tag2;
                String string = compoundTag2.getString("Value", "");
                String string2 = compoundTag2.getString("Signature");
                list.add(new GameProfile.Property(this.limit(entry.getKey(), 64), string, this.limit(string2, 1024)));
                if (list.size() != 16) continue;
                return;
            }
        }
    }

    private void updateMapDecorations(StructuredDataContainer structuredDataContainer, ListTag<CompoundTag> listTag) {
        CompoundTag compoundTag = new CompoundTag();
        for (CompoundTag compoundTag2 : listTag) {
            String string = compoundTag2.getString("id", "");
            int n = compoundTag2.getInt("type");
            double d = compoundTag2.getDouble("x");
            double d2 = compoundTag2.getDouble("z");
            float f = compoundTag2.getFloat("rot");
            CompoundTag compoundTag3 = new CompoundTag();
            compoundTag3.putString("type", MapDecorations1_20_5.idToKey(n));
            compoundTag3.putDouble("x", d);
            compoundTag3.putDouble("z", d2);
            compoundTag3.putFloat("rotation", f);
            compoundTag.put(string, compoundTag3);
        }
        structuredDataContainer.set(StructuredDataKey.MAP_DECORATIONS, compoundTag);
    }

    private void updateDisplay(UserConnection userConnection, StructuredDataContainer structuredDataContainer, CompoundTag compoundTag, int n) {
        NumberTag numberTag;
        Tag tag;
        StringTag stringTag2;
        if (compoundTag == null) {
            return;
        }
        NumberTag numberTag2 = compoundTag.getNumberTag("MapColor");
        if (numberTag2 != null) {
            structuredDataContainer.set(StructuredDataKey.MAP_COLOR, numberTag2.asInt());
        }
        if ((stringTag2 = compoundTag.getStringTag("Name")) != null) {
            try {
                tag = this.jsonToTag(userConnection, stringTag2);
                structuredDataContainer.set(StructuredDataKey.CUSTOM_NAME, tag);
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        if ((tag = compoundTag.getListTag("Lore", StringTag.class)) != null) {
            try {
                structuredDataContainer.set(StructuredDataKey.LORE, (Tag[])((ListTag)tag).stream().limit(256L).map(stringTag -> this.jsonToTag(userConnection, (StringTag)stringTag)).toArray(Tag[]::new));
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        if ((numberTag = compoundTag.getNumberTag("color")) != null) {
            structuredDataContainer.set(StructuredDataKey.DYED_COLOR1_20_5, new DyedColor(numberTag.asInt(), (n & 0x40) == 0));
        }
    }

    private void addBlockEntityId(CompoundTag compoundTag, String string) {
        if (!compoundTag.contains("id")) {
            compoundTag.putString("id", string);
        }
    }

    private boolean isUnknownBlockEntity(int n) {
        return n < 0 || n > 42;
    }

    private void updateBlockEntityTag(UserConnection userConnection, @Nullable StructuredDataContainer structuredDataContainer, CompoundTag compoundTag) {
        BannerPatternLayer[] bannerPatternLayerArray;
        Object object;
        Tag tag;
        Tag tag2;
        if (compoundTag == null) {
            return;
        }
        if (structuredDataContainer != null) {
            Object object2;
            Object object3;
            Object object4;
            tag2 = compoundTag.getStringTag("Lock");
            if (tag2 != null) {
                structuredDataContainer.set(StructuredDataKey.LOCK1_20_5, tag2);
            }
            if ((tag = compoundTag.getListTag("Bees", CompoundTag.class)) != null) {
                this.updateBees(structuredDataContainer, (ListTag<CompoundTag>)tag);
                this.addBlockEntityId(compoundTag, "beehive");
            }
            if ((object = compoundTag.getListTag("sherds", StringTag.class)) != null && ((ListTag)object).size() == 4) {
                bannerPatternLayerArray = ((StringTag)((ListTag)object).get(0)).getValue();
                object4 = ((StringTag)((ListTag)object).get(1)).getValue();
                object3 = ((StringTag)((ListTag)object).get(2)).getValue();
                object2 = ((StringTag)((ListTag)object).get(3)).getValue();
                structuredDataContainer.set(StructuredDataKey.POT_DECORATIONS, new PotDecorations(this.toMappedItemId((String)bannerPatternLayerArray), this.toMappedItemId((String)object4), this.toMappedItemId((String)object3), this.toMappedItemId((String)object2)));
                this.addBlockEntityId(compoundTag, "decorated_pot");
            }
            if ((bannerPatternLayerArray = compoundTag.getStringTag("note_block_sound")) != null) {
                structuredDataContainer.set(StructuredDataKey.NOTE_BLOCK_SOUND, Key.of(bannerPatternLayerArray.getValue()));
                this.addBlockEntityId(compoundTag, "player_head");
            }
            if ((object4 = compoundTag.getStringTag("LootTable")) != null) {
                long l = compoundTag.getLong("LootTableSeed");
                CompoundTag compoundTag2 = new CompoundTag();
                compoundTag2.putString("loot_table", ((StringTag)object4).getValue());
                compoundTag2.putLong("loot_table_seed", l);
                structuredDataContainer.set(StructuredDataKey.CONTAINER_LOOT, compoundTag2);
            }
            if ((object3 = compoundTag.remove("Base")) instanceof NumberTag) {
                object2 = (NumberTag)object3;
                structuredDataContainer.set(StructuredDataKey.BASE_COLOR, object2.asInt());
            }
            if ((object2 = compoundTag.getListTag("Items", CompoundTag.class)) != null) {
                byte by;
                Item item;
                CompoundTag compoundTag3;
                int n = 0;
                int n2 = Math.min(((ListTag)object2).size(), 256);
                for (int i = 0; i < n2; ++i) {
                    compoundTag3 = (CompoundTag)((ListTag)object2).get(i);
                    item = this.itemFromTag(userConnection, compoundTag3);
                    if (item.isEmpty()) continue;
                    by = compoundTag3.getByte("Slot");
                    n = MathUtil.clamp(by, n, 255);
                }
                Object[] objectArray = new Item[n + 1];
                Arrays.fill(objectArray, StructuredItem.empty());
                Iterator iterator2 = ((ListTag)object2).iterator();
                while (iterator2.hasNext()) {
                    compoundTag3 = (CompoundTag)iterator2.next();
                    item = this.itemFromTag(userConnection, compoundTag3);
                    if (item.isEmpty() || (by = compoundTag3.getByte("Slot")) < 0 || by >= objectArray.length) continue;
                    objectArray[by] = item;
                }
                structuredDataContainer.set(StructuredDataKey.V1_20_5.container, objectArray);
                this.addBlockEntityId(compoundTag, "shulker_box");
            }
        }
        if ((tag2 = compoundTag.remove("SkullOwner")) instanceof StringTag) {
            tag = tag2;
            bannerPatternLayerArray = new CompoundTag();
            bannerPatternLayerArray.putString("name", ((StringTag)tag).getValue());
            compoundTag.put("profile", (Tag)bannerPatternLayerArray);
        } else if (tag2 instanceof CompoundTag) {
            object = (CompoundTag)tag2;
            this.updateSkullOwnerTag(compoundTag, (CompoundTag)object);
        }
        tag = compoundTag.getListTag("Patterns", CompoundTag.class);
        if (tag != null) {
            object = userConnection.get(BannerPatternStorage.class);
            bannerPatternLayerArray = (BannerPatternLayer[])((ListTag)tag).stream().map(arg_0 -> BlockItemPacketRewriter1_20_5.lambda$updateBlockEntityTag$22((BannerPatternStorage)object, arg_0)).filter(Objects::nonNull).toArray(BannerPatternLayer[]::new);
            compoundTag.remove("Patterns");
            compoundTag.put("patterns", tag);
            this.addBlockEntityId(compoundTag, "banner");
            if (structuredDataContainer != null) {
                structuredDataContainer.set(StructuredDataKey.BANNER_PATTERNS, bannerPatternLayerArray);
            }
        }
        this.removeEmptyItem(compoundTag, "item");
        this.removeEmptyItem(compoundTag, "RecordItem");
        this.removeEmptyItem(compoundTag, "Book");
    }

    private void removeEmptyItem(CompoundTag compoundTag, String string) {
        int n;
        CompoundTag compoundTag2 = compoundTag.getCompoundTag(string);
        if (compoundTag2 != null && (n = compoundTag2.getInt("id")) == 0) {
            compoundTag.remove(string);
        }
    }

    private void updateSkullOwnerTag(CompoundTag compoundTag, CompoundTag compoundTag2) {
        ListTag<CompoundTag> listTag;
        IntArrayTag intArrayTag;
        CompoundTag compoundTag3 = new CompoundTag();
        compoundTag.put("profile", compoundTag3);
        String string = compoundTag2.getString("Name");
        if (string != null && this.isValidName(string)) {
            compoundTag3.putString("name", string);
        }
        if ((intArrayTag = compoundTag2.getIntArrayTag("Id")) != null) {
            compoundTag3.put("id", intArrayTag);
        }
        if (!((listTag = compoundTag2.remove("Properties")) instanceof CompoundTag)) {
            return;
        }
        CompoundTag compoundTag4 = (CompoundTag)((Object)listTag);
        listTag = new ListTag<CompoundTag>(CompoundTag.class);
        for (Map.Entry<String, Tag> entry : compoundTag4.entrySet()) {
            Tag tag = entry.getValue();
            if (!(tag instanceof ListTag)) continue;
            ListTag listTag2 = (ListTag)tag;
            for (Tag tag2 : listTag2) {
                if (!(tag2 instanceof CompoundTag)) continue;
                CompoundTag compoundTag5 = (CompoundTag)tag2;
                CompoundTag compoundTag6 = new CompoundTag();
                String string2 = compoundTag5.getString("Value", "");
                String string3 = compoundTag5.getString("Signature");
                compoundTag6.putString("name", entry.getKey());
                compoundTag6.putString("value", string2);
                if (string3 != null) {
                    compoundTag6.putString("signature", string3);
                }
                listTag.add(compoundTag6);
            }
        }
        compoundTag3.put("properties", listTag);
    }

    private boolean isValidName(String string) {
        if (string.length() > 16) {
            return false;
        }
        int n = string.length();
        for (int i = 0; i < n; ++i) {
            char c = string.charAt(i);
            if (c >= '!' && c <= '~') continue;
            return false;
        }
        return true;
    }

    private static /* synthetic */ BannerPatternLayer lambda$updateBlockEntityTag$22(BannerPatternStorage bannerPatternStorage, CompoundTag compoundTag) {
        String string = compoundTag.getString("Pattern", "");
        int n = compoundTag.getInt("Color", -1);
        String string2 = BannerPatterns1_20_5.compactToFullId(string);
        if (string2 == null || n == -1) {
            return null;
        }
        compoundTag.remove("Pattern");
        compoundTag.remove("Color");
        compoundTag.putString("pattern", string2);
        compoundTag.putString("color", DyeColors.idToKey(n));
        int n2 = bannerPatternStorage != null ? bannerPatternStorage.bannerPatterns().keyToId(string2) : BannerPatterns1_20_5.keyToId(string2);
        return n2 != -1 ? new BannerPatternLayer(Holder.of(n2), n) : null;
    }
}

