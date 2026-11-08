/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_21to1_20_5.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.api.rewriters.EntityRewriter;
import com.viaversion.viabackwards.protocol.v1_21to1_20_5.Protocol1_21To1_20_5;
import com.viaversion.viabackwards.protocol.v1_21to1_20_5.storage.EnchantmentsPaintingsStorage;
import com.viaversion.viabackwards.protocol.v1_21to1_20_5.storage.PlayerRotationStorage;
import com.viaversion.viaversion.api.minecraft.Holder;
import com.viaversion.viaversion.api.minecraft.PaintingVariant;
import com.viaversion.viaversion.api.minecraft.RegistryEntry;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_20_5;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_20_5;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_21;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.Types1_20_5;
import com.viaversion.viaversion.api.type.types.version.VersionedTypes;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ServerboundPackets1_20_5;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.data.Paintings1_20_5;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundConfigurationPackets1_21;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundPacket1_21;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.KeyMappings;
import java.util.HashMap;
import java.util.Map;

public class EntityPacketRewriter1_21
extends EntityRewriter<ClientboundPacket1_21, Protocol1_21To1_20_5> {
    private final Map<String, PaintingData> oldPaintings = new HashMap<String, PaintingData>();

    public EntityPacketRewriter1_21(Protocol1_21To1_20_5 protocol1_21To1_20_5) {
        super(protocol1_21To1_20_5, ((EntityDataTypes1_20_5)((Types1_20_5)protocol1_21To1_20_5.mappedTypes()).entityDataTypes()).optionalComponentType, ((EntityDataTypes1_20_5)((Types1_20_5)protocol1_21To1_20_5.mappedTypes()).entityDataTypes()).booleanType);
        for (int i = 0; i < Paintings1_20_5.PAINTINGS.length; ++i) {
            PaintingVariant paintingVariant = Paintings1_20_5.PAINTINGS[i];
            this.oldPaintings.put(paintingVariant.assetId(), new PaintingData(paintingVariant, i));
        }
    }

    @Override
    public void registerPackets() {
        ((Protocol1_21To1_20_5)this.protocol).replaceClientbound(ClientboundConfigurationPackets1_21.REGISTRY_DATA, packetWrapper -> {
            String string = Key.stripMinecraftNamespace(packetWrapper.passthrough(Types.STRING));
            RegistryEntry[] registryEntryArray = packetWrapper.passthrough(Types.REGISTRY_ENTRY_ARRAY);
            boolean bl = string.equals("painting_variant");
            boolean bl2 = string.equals("enchantment");
            if (bl || bl2 || string.equals("jukebox_song")) {
                String[] stringArray = new String[registryEntryArray.length];
                for (int i = 0; i < registryEntryArray.length; ++i) {
                    stringArray[i] = Key.stripMinecraftNamespace(registryEntryArray[i].key());
                }
                EnchantmentsPaintingsStorage enchantmentsPaintingsStorage = packetWrapper.user().get(EnchantmentsPaintingsStorage.class);
                if (bl) {
                    enchantmentsPaintingsStorage.setPaintings(new KeyMappings(stringArray), this.paintingMappingsForEntries(registryEntryArray));
                } else if (bl2) {
                    Tag[] tagArray = new Tag[registryEntryArray.length];
                    int[] nArray = new int[registryEntryArray.length];
                    for (int i = 0; i < registryEntryArray.length; ++i) {
                        RegistryEntry registryEntry = registryEntryArray[i];
                        Tag tag = registryEntry.tag();
                        if (!(tag instanceof CompoundTag)) continue;
                        CompoundTag compoundTag = (CompoundTag)tag;
                        tagArray[i] = compoundTag.get("description");
                        nArray[i] = compoundTag.getInt("max_level");
                    }
                    enchantmentsPaintingsStorage.setEnchantments(new KeyMappings(stringArray), tagArray, nArray);
                } else {
                    int[] nArray = new int[stringArray.length];
                    for (int i = 0; i < stringArray.length; ++i) {
                        int n;
                        nArray[i] = n = ((Protocol1_21To1_20_5)this.protocol).getMappingData().getFullItemMappings().mappedId("music_disc_" + stringArray[i]);
                    }
                    enchantmentsPaintingsStorage.setJubeboxSongsToItems(nArray);
                }
                packetWrapper.cancel();
            } else {
                ((Protocol1_21To1_20_5)this.protocol).getRegistryDataRewriter().trackDimensionAndBiomes(packetWrapper.user(), string, registryEntryArray);
            }
        });
        ((Protocol1_21To1_20_5)this.protocol).registerServerbound(ServerboundPackets1_20_5.MOVE_PLAYER_POS_ROT, packetWrapper -> {
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.DOUBLE);
            this.storePlayerRotation(packetWrapper);
        });
        ((Protocol1_21To1_20_5)this.protocol).registerServerbound(ServerboundPackets1_20_5.MOVE_PLAYER_ROT, this::storePlayerRotation);
    }

    private void storePlayerRotation(PacketWrapper packetWrapper) {
        float f = packetWrapper.passthrough(Types.FLOAT).floatValue();
        float f2 = packetWrapper.passthrough(Types.FLOAT).floatValue();
        packetWrapper.user().get(PlayerRotationStorage.class).setRotation(f, f2);
    }

    private int[] paintingMappingsForEntries(RegistryEntry[] registryEntryArray) {
        int[] nArray = new int[registryEntryArray.length];
        block0: for (int i = 0; i < registryEntryArray.length; ++i) {
            RegistryEntry registryEntry = registryEntryArray[i];
            PaintingData paintingData = this.oldPaintings.get(Key.stripMinecraftNamespace(registryEntry.key()));
            if (paintingData != null) {
                nArray[i] = paintingData.id;
                continue;
            }
            if (registryEntry.tag() == null) continue;
            CompoundTag compoundTag = (CompoundTag)registryEntry.tag();
            for (int j = 0; j < Paintings1_20_5.PAINTINGS.length; ++j) {
                PaintingVariant paintingVariant = Paintings1_20_5.PAINTINGS[j];
                if (paintingVariant.width() != compoundTag.getInt("width") || paintingVariant.height() != compoundTag.getInt("height")) continue;
                nArray[i] = j;
                continue block0;
            }
        }
        return nArray;
    }

    @Override
    protected void registerRewrites() {
        EntityDataTypes1_20_5 entityDataTypes1_20_5 = (EntityDataTypes1_20_5)VersionedTypes.V1_20_5.entityDataTypes;
        this.dataTypeMapper().skip(((EntityDataTypes1_21)VersionedTypes.V1_21.entityDataTypes).wolfVariantType).skip(((EntityDataTypes1_21)VersionedTypes.V1_21.entityDataTypes).paintingVariantType).register();
        this.filter().dataType(((EntityDataTypes1_21)VersionedTypes.V1_21.entityDataTypes).wolfVariantType).handler((entityDataHandlerEvent, entityData) -> {
            Holder holder = (Holder)entityData.value();
            if (holder.hasId()) {
                entityData.setTypeAndValue(entityDataTypes1_20_5.wolfVariantType, holder.id());
            } else {
                entityDataHandlerEvent.cancel();
            }
        });
        this.filter().dataType(((EntityDataTypes1_21)VersionedTypes.V1_21.entityDataTypes).paintingVariantType).handler((entityDataHandlerEvent, entityData) -> {
            Holder holder = (Holder)entityData.value();
            if (holder.hasId()) {
                EnchantmentsPaintingsStorage enchantmentsPaintingsStorage = entityDataHandlerEvent.user().get(EnchantmentsPaintingsStorage.class);
                int n = enchantmentsPaintingsStorage.mappedPainting(holder.id());
                entityData.setTypeAndValue(entityDataTypes1_20_5.paintingVariantType, n);
            } else {
                entityDataHandlerEvent.cancel();
            }
        });
        this.registerEntityDataTypeHandler1_20_3(entityDataTypes1_20_5.itemType, entityDataTypes1_20_5.blockStateType, entityDataTypes1_20_5.optionalBlockStateType, entityDataTypes1_20_5.particleType, entityDataTypes1_20_5.particlesType, entityDataTypes1_20_5.componentType, entityDataTypes1_20_5.optionalComponentType);
        this.registerBlockStateHandler(EntityTypes1_20_5.ABSTRACT_MINECART, 11);
    }

    @Override
    public EntityType typeFromId(int n) {
        return EntityTypes1_20_5.getTypeFromId(n);
    }

    private record PaintingData(PaintingVariant painting, int id) {
    }
}

