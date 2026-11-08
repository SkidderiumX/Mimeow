/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_20_5to1_20_3.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.api.rewriters.BackwardsFullStructuredItemRewriter;
import com.viaversion.viabackwards.api.rewriters.StructuredEnchantmentRewriter;
import com.viaversion.viabackwards.protocol.v1_20_5to1_20_3.Protocol1_20_5To1_20_3;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.ProtocolInfo;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.item.ItemHasher;
import com.viaversion.viaversion.api.minecraft.Holder;
import com.viaversion.viaversion.api.minecraft.Particle;
import com.viaversion.viaversion.api.minecraft.SoundEvent;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataContainer;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.minecraft.item.StructuredItem;
import com.viaversion.viaversion.api.minecraft.item.data.FireworkExplosion;
import com.viaversion.viaversion.api.minecraft.item.data.Fireworks;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.Types1_20_3;
import com.viaversion.viaversion.api.type.types.version.VersionedTypes;
import com.viaversion.viaversion.protocols.v1_20_2to1_20_3.packet.ServerboundPacket1_20_3;
import com.viaversion.viaversion.protocols.v1_20_2to1_20_3.packet.ServerboundPackets1_20_3;
import com.viaversion.viaversion.protocols.v1_20_2to1_20_3.rewriter.RecipeRewriter1_20_3;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.Protocol1_20_3To1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ClientboundPacket1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ClientboundPackets1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.rewriter.StructuredDataConverter;
import com.viaversion.viaversion.rewriter.ParticleRewriter;
import com.viaversion.viaversion.rewriter.text.ComponentRewriterBase;
import com.viaversion.viaversion.util.Key;
import org.checkerframework.checker.nullness.qual.Nullable;

public class BlockItemPacketRewriter1_20_5
extends BackwardsFullStructuredItemRewriter<ClientboundPacket1_20_5, ServerboundPacket1_20_3, Protocol1_20_5To1_20_3> {
    private static final StructuredDataConverter DATA_CONVERTER = new StructuredDataConverter(true);
    private final Protocol1_20_3To1_20_5 vvProtocol = Via.getManager().getProtocolManager().getProtocol(Protocol1_20_3To1_20_5.class);
    private final StructuredEnchantmentRewriter enchantmentRewriter = new StructuredEnchantmentRewriter(this);

    public BlockItemPacketRewriter1_20_5(Protocol1_20_5To1_20_3 protocol1_20_5To1_20_3) {
        super(protocol1_20_5To1_20_3);
        this.enchantmentRewriter.setRewriteIds(false);
    }

    @Override
    public void registerPackets() {
        ((Protocol1_20_5To1_20_3)this.protocol).replaceClientbound(ClientboundPackets1_20_5.BLOCK_ENTITY_DATA, packetWrapper -> {
            packetWrapper.passthrough(Types.BLOCK_POSITION1_14);
            packetWrapper.passthrough(Types.VAR_INT);
            CompoundTag compoundTag = packetWrapper.passthrough(Types.TRUSTED_COMPOUND_TAG);
            ((Protocol1_20_5To1_20_3)this.protocol).getBlockRewriter().updateBlockEntityTag(compoundTag);
        });
        ((Protocol1_20_5To1_20_3)this.protocol).registerServerbound(ServerboundPackets1_20_3.CONTAINER_BUTTON_CLICK, packetWrapper -> {
            int n = packetWrapper.read(Types.BYTE) & 0xFF;
            int n2 = packetWrapper.read(Types.BYTE) & 0xFF;
            packetWrapper.write(Types.VAR_INT, n);
            packetWrapper.write(Types.VAR_INT, n2);
        });
        ((Protocol1_20_5To1_20_3)this.protocol).replaceClientbound(ClientboundPackets1_20_5.LEVEL_PARTICLES, packetWrapper -> {
            packetWrapper.write(Types.VAR_INT, 0);
            packetWrapper.passthrough(Types.BOOLEAN);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.FLOAT);
            packetWrapper.passthrough(Types.FLOAT);
            packetWrapper.passthrough(Types.FLOAT);
            float f = packetWrapper.passthrough(Types.FLOAT).floatValue();
            packetWrapper.passthrough(Types.INT);
            Particle particle = packetWrapper.read(VersionedTypes.V1_20_5.particle());
            ((ParticleRewriter)((Protocol1_20_5To1_20_3)this.protocol).getParticleRewriter()).rewriteParticle(packetWrapper.user(), particle);
            if (particle.id() == ((Protocol1_20_5To1_20_3)this.protocol).getMappingData().getParticleMappings().mappedId("entity_effect")) {
                int n = (Integer)particle.removeArgument(0).getValue();
                if (f == 0.0f) {
                    packetWrapper.set(Types.FLOAT, 3, Float.valueOf(n));
                }
            } else if (particle.id() == ((Protocol1_20_5To1_20_3)this.protocol).getMappingData().getParticleMappings().mappedId("dust_color_transition")) {
                particle.add(3, Types.FLOAT, (Float)particle.removeArgument(6).getValue());
            }
            packetWrapper.set(Types.VAR_INT, 0, particle.id());
            for (Particle.ParticleData<?> particleData : particle.getArguments()) {
                particleData.write(packetWrapper);
            }
        });
        ((Protocol1_20_5To1_20_3)this.protocol).replaceClientbound(ClientboundPackets1_20_5.EXPLODE, packetWrapper -> {
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
            Particle particle = packetWrapper.passthroughAndMap(VersionedTypes.V1_20_5.particle(), Types1_20_3.PARTICLE);
            Particle particle2 = packetWrapper.passthroughAndMap(VersionedTypes.V1_20_5.particle(), Types1_20_3.PARTICLE);
            ((ParticleRewriter)((Protocol1_20_5To1_20_3)this.protocol).getParticleRewriter()).rewriteParticle(packetWrapper.user(), particle);
            ((ParticleRewriter)((Protocol1_20_5To1_20_3)this.protocol).getParticleRewriter()).rewriteParticle(packetWrapper.user(), particle2);
            Holder holder = (Holder)((Object)packetWrapper.read(Types.SOUND_EVENT));
            if (holder.isDirect()) {
                SoundEvent soundEvent = (SoundEvent)holder.value();
                packetWrapper.write(Types.STRING, soundEvent.identifier());
                packetWrapper.write(Types.OPTIONAL_FLOAT, soundEvent.fixedRange());
            } else {
                int n2 = ((Protocol1_20_5To1_20_3)this.protocol).getMappingData().getSoundMappings().getNewId(holder.id());
                String string = Protocol1_20_3To1_20_5.MAPPINGS.soundName(n2);
                packetWrapper.write(Types.STRING, string != null ? string : "minecraft:entity.generic.explode");
                packetWrapper.write(Types.OPTIONAL_FLOAT, null);
            }
        });
        ((Protocol1_20_5To1_20_3)this.protocol).replaceClientbound(ClientboundPackets1_20_5.MERCHANT_OFFERS, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            int n = packetWrapper.passthrough(Types.VAR_INT);
            for (int i = 0; i < n; ++i) {
                Item item = this.handleItemToClient(packetWrapper.user(), packetWrapper.read(VersionedTypes.V1_20_5.itemCost()));
                this.cleanInput(item);
                packetWrapper.write(Types.ITEM1_20_2, item);
                Item item2 = this.handleItemToClient(packetWrapper.user(), packetWrapper.read(VersionedTypes.V1_20_5.item()));
                packetWrapper.write(Types.ITEM1_20_2, item2);
                Item item3 = packetWrapper.read(VersionedTypes.V1_20_5.optionalItemCost());
                if (item3 != null) {
                    item3 = this.handleItemToClient(packetWrapper.user(), item3);
                    this.cleanInput(item3);
                }
                packetWrapper.write(Types.ITEM1_20_2, item3);
                packetWrapper.passthrough(Types.BOOLEAN);
                packetWrapper.passthrough(Types.INT);
                packetWrapper.passthrough(Types.INT);
                packetWrapper.passthrough(Types.INT);
                packetWrapper.passthrough(Types.INT);
                packetWrapper.passthrough(Types.FLOAT);
                packetWrapper.passthrough(Types.INT);
            }
        });
        ((Protocol1_20_5To1_20_3)this.protocol).registerClientbound(ClientboundPackets1_20_5.MAP_ITEM_DATA, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.BYTE);
            packetWrapper.passthrough(Types.BOOLEAN);
            if (packetWrapper.passthrough(Types.BOOLEAN).booleanValue()) {
                int n = packetWrapper.passthrough(Types.VAR_INT);
                for (int i = 0; i < n; ++i) {
                    int n2 = packetWrapper.read(Types.VAR_INT);
                    packetWrapper.write(Types.VAR_INT, n2 == 34 ? 32 : n2);
                    packetWrapper.passthrough(Types.BYTE);
                    packetWrapper.passthrough(Types.BYTE);
                    packetWrapper.passthrough(Types.BYTE);
                    packetWrapper.passthrough(Types.TRUSTED_OPTIONAL_TAG);
                }
            }
        });
        RecipeRewriter1_20_3 recipeRewriter1_20_3 = new RecipeRewriter1_20_3(this.protocol);
        ((Protocol1_20_5To1_20_3)this.protocol).registerClientbound(ClientboundPackets1_20_5.UPDATE_RECIPES, packetWrapper -> {
            int n = packetWrapper.passthrough(Types.VAR_INT);
            for (int i = 0; i < n; ++i) {
                String string = packetWrapper.read(Types.STRING);
                int n2 = packetWrapper.read(Types.VAR_INT);
                String string2 = ((Protocol1_20_5To1_20_3)this.protocol).getMappingData().getRecipeSerializerMappings().mappedIdentifier(n2);
                packetWrapper.write(Types.STRING, string2);
                packetWrapper.write(Types.STRING, string);
                recipeRewriter1_20_3.handleRecipeType(packetWrapper, Key.stripMinecraftNamespace(string2));
            }
        });
    }

    private void cleanInput(@Nullable Item item) {
        if (item == null || item.tag() == null) {
            return;
        }
        CompoundTag compoundTag = item.tag();
        StructuredDataConverter.removeBackupTag(compoundTag);
        CompoundTag compoundTag2 = compoundTag.getCompoundTag("display");
        if (compoundTag2 != null) {
            this.removeEmptyList(compoundTag2, "Lore");
            if (compoundTag2.isEmpty()) {
                compoundTag.remove("display");
            }
        }
        this.removeEmptyList(compoundTag, "Enchantments");
        this.removeEmptyList(compoundTag, "AttributeModifiers");
        if (compoundTag.getInt("RepairCost", -1) == 0) {
            compoundTag.remove("RepairCost");
        }
        if (compoundTag.isEmpty()) {
            item.setTag(null);
        }
    }

    private void removeEmptyList(CompoundTag compoundTag, String string) {
        ListTag<?> listTag = compoundTag.getListTag(string);
        if (listTag != null && listTag.isEmpty()) {
            compoundTag.remove(string);
        }
    }

    @Override
    public @Nullable Item handleItemToClient(UserConnection userConnection, Item item) {
        Object object;
        if (item.isEmpty()) {
            return null;
        }
        StructuredDataContainer structuredDataContainer = item.dataContainer();
        item.dataContainer().setIdLookup(this.protocol, true);
        this.enchantmentRewriter.handleToClient(item);
        item = super.handleItemToClient(userConnection, item);
        this.updateTextComponent(userConnection, item, StructuredDataKey.ITEM_NAME, "item_name");
        this.updateTextComponent(userConnection, item, StructuredDataKey.CUSTOM_NAME, "custom_name");
        Tag[] tagArray = structuredDataContainer.get(StructuredDataKey.LORE);
        if (tagArray != null) {
            object = tagArray;
            int n = ((Tag[])object).length;
            for (int i = 0; i < n; ++i) {
                Tag tag = object[i];
                ((ComponentRewriterBase)((Protocol1_20_5To1_20_3)this.protocol).getComponentRewriter()).processTag(userConnection, tag);
            }
        }
        if (item.identifier() == 1105 && !structuredDataContainer.has(StructuredDataKey.FIREWORKS)) {
            structuredDataContainer.set(StructuredDataKey.FIREWORKS, new Fireworks(1, new FireworkExplosion[0]));
        }
        if ((object = structuredDataContainer.get(StructuredDataKey.CUSTOM_DATA)) != null) {
            object = ((CompoundTag)object).copy();
        }
        Item item2 = this.vvProtocol.getItemRewriter().toOldItem(userConnection, item, DATA_CONVERTER);
        if (object != null) {
            if (item2.tag() == null) {
                item2.setTag(new CompoundTag());
            }
            item2.tag().put(this.nbtTagName(), (Tag)object);
        } else if (item2.tag() != null && item2.tag().isEmpty()) {
            item2.setTag(null);
        }
        return item2;
    }

    @Override
    protected void handleItemDataComponentsToClient(UserConnection userConnection, Item item, StructuredDataContainer structuredDataContainer) {
    }

    @Override
    protected void handleItemDataComponentsToServer(UserConnection userConnection, Item item, StructuredDataContainer structuredDataContainer) {
    }

    @Override
    protected void handleRewritablesToClient(UserConnection userConnection, StructuredDataContainer structuredDataContainer, @Nullable ItemHasher itemHasher) {
    }

    @Override
    protected void handleRewritablesToServer(UserConnection userConnection, StructuredDataContainer structuredDataContainer) {
    }

    @Override
    public Item handleItemToServer(UserConnection userConnection, @Nullable Item item) {
        Tag tag;
        if (item == null) {
            return StructuredItem.empty();
        }
        CompoundTag compoundTag = this.checkStoredHash(userConnection, item);
        Item item2 = this.vvProtocol.getItemRewriter().toStructuredItem(userConnection, item);
        if (item.tag() != null && (tag = item.tag().get(this.nbtTagName())) instanceof CompoundTag) {
            CompoundTag compoundTag2 = (CompoundTag)tag;
            item2.dataContainer().set(StructuredDataKey.CUSTOM_DATA, compoundTag2);
        }
        if (compoundTag != null) {
            item2.dataContainer().set(StructuredDataKey.CUSTOM_DATA, compoundTag);
        }
        item2.dataContainer().setIdLookup(this.protocol, false);
        this.enchantmentRewriter.handleToServer(item2);
        return super.handleItemToServer(userConnection, item2);
    }

    private @Nullable CompoundTag checkStoredHash(UserConnection userConnection, Item item) {
        ProtocolInfo protocolInfo = userConnection.getProtocolInfo();
        CompoundTag compoundTag = item.tag();
        if (compoundTag == null || protocolInfo.serverProtocolVersion().olderThan(ProtocolVersion.v1_21_5) || ((Protocol1_20_5To1_20_3)this.protocol).getEntityRewriter().tracker(userConnection).canInstaBuild()) {
            return null;
        }
        CompoundTag compoundTag2 = compoundTag.getCompoundTag("VV|original_hashes");
        if (compoundTag2 == null) {
            item.setTag(null);
            return null;
        }
        CompoundTag compoundTag3 = new CompoundTag();
        compoundTag3.put("VV|original_hashes", compoundTag2);
        item.setTag(compoundTag3);
        return compoundTag3;
    }
}

