/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v26_1to1_21_11;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viabackwards.api.data.BackwardsMappingData;
import com.viaversion.viabackwards.api.rewriters.BackwardsRegistryRewriter;
import com.viaversion.viabackwards.api.rewriters.text.NBTComponentRewriter;
import com.viaversion.viabackwards.protocol.v26_1to1_21_11.rewriter.BlockItemPacketRewriter26_1;
import com.viaversion.viabackwards.protocol.v26_1to1_21_11.rewriter.ComponentRewriter26_1;
import com.viaversion.viabackwards.protocol.v26_1to1_21_11.rewriter.EntityPacketRewriter26_1;
import com.viaversion.viabackwards.protocol.v26_1to1_21_11.storage.DayTimeStorage;
import com.viaversion.viabackwards.protocol.v26_1to1_21_11.storage.GameModeStorage;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.RegistryType;
import com.viaversion.viaversion.api.minecraft.data.version.StructuredDataKeys1_21_11;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_21_11;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_21_11;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes26_1;
import com.viaversion.viaversion.api.protocol.packet.provider.PacketTypesProvider;
import com.viaversion.viaversion.api.protocol.packet.provider.SimplePacketTypesProvider;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_21_5;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType26_1;
import com.viaversion.viaversion.api.type.types.version.Types1_20_5;
import com.viaversion.viaversion.api.type.types.version.Types26_1;
import com.viaversion.viaversion.api.type.types.version.VersionedTypes;
import com.viaversion.viaversion.data.entity.EntityTrackerBase;
import com.viaversion.viaversion.data.item.ItemHasherBase;
import com.viaversion.viaversion.protocols.v1_21_11to26_1.Protocol1_21_11To26_1;
import com.viaversion.viaversion.protocols.v1_21_11to26_1.packet.ClientboundPacket26_1;
import com.viaversion.viaversion.protocols.v1_21_11to26_1.packet.ClientboundPackets26_1;
import com.viaversion.viaversion.protocols.v1_21_11to26_1.packet.ServerboundPacket26_1;
import com.viaversion.viaversion.protocols.v1_21_11to26_1.packet.ServerboundPackets26_1;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.rewriter.RecipeDisplayRewriter1_21_5;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.packet.ServerboundPackets1_21_6;
import com.viaversion.viaversion.protocols.v1_21_7to1_21_9.packet.ClientboundConfigurationPackets1_21_9;
import com.viaversion.viaversion.protocols.v1_21_7to1_21_9.packet.ServerboundConfigurationPackets1_21_9;
import com.viaversion.viaversion.protocols.v1_21_7to1_21_9.packet.ServerboundPacket1_21_9;
import com.viaversion.viaversion.protocols.v1_21_9to1_21_11.packet.ClientboundPacket1_21_11;
import com.viaversion.viaversion.protocols.v1_21_9to1_21_11.packet.ClientboundPackets1_21_11;
import com.viaversion.viaversion.rewriter.BlockRewriter;
import com.viaversion.viaversion.rewriter.ParticleRewriter;
import com.viaversion.viaversion.rewriter.RecipeDisplayRewriter;
import com.viaversion.viaversion.rewriter.TagRewriter;
import com.viaversion.viaversion.rewriter.block.BlockRewriter1_21_5;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.ProtocolUtil;
import com.viaversion.viaversion.util.TagUtil;

public class Protocol26_1To1_21_11
extends BackwardsProtocol<ClientboundPacket26_1, ClientboundPacket1_21_11, ServerboundPacket26_1, ServerboundPacket1_21_9> {
    public static final BackwardsMappingData MAPPINGS = new BackwardsMappingData("26.1", "1.21.11", Protocol1_21_11To26_1.class);
    private final EntityPacketRewriter26_1 entityRewriter = new EntityPacketRewriter26_1(this);
    private final BlockItemPacketRewriter26_1 itemRewriter = new BlockItemPacketRewriter26_1(this);
    private final ParticleRewriter<ClientboundPacket26_1> particleRewriter = new ParticleRewriter<ClientboundPacket26_1>(this);
    private final NBTComponentRewriter<ClientboundPacket26_1> translatableRewriter = new ComponentRewriter26_1(this);
    private final TagRewriter<ClientboundPacket26_1> tagRewriter = new TagRewriter<ClientboundPacket26_1>(this);
    private final BackwardsRegistryRewriter registryDataRewriter = new BackwardsRegistryRewriter(this);
    private final BlockRewriter<ClientboundPacket26_1> blockRewriter = new BlockRewriter1_21_5<ClientboundPacket26_1>(this, ChunkType26_1::new, ChunkType1_21_5::new);
    private final RecipeDisplayRewriter<ClientboundPacket26_1> recipeRewriter = new RecipeDisplayRewriter1_21_5<ClientboundPacket26_1>(this);

    public Protocol26_1To1_21_11() {
        super(ClientboundPacket26_1.class, ClientboundPacket1_21_11.class, ServerboundPacket26_1.class, ServerboundPacket1_21_9.class);
    }

    @Override
    protected void registerPackets() {
        super.registerPackets();
        this.registryDataRewriter.addHandler("dimension_type", (string, compoundTag) -> {
            CompoundTag compoundTag2 = compoundTag.getCompoundTag("attributes");
            if (compoundTag2 != null) {
                TagUtil.removeNamespaced(compoundTag2, "visual/block_light_tint");
                TagUtil.removeNamespaced(compoundTag2, "visual/night_vision_color");
                TagUtil.removeNamespaced(compoundTag2, "visual/ambient_light_color");
            }
        });
        this.registryDataRewriter.addHandler("wolf_sound_variant", (string, compoundTag) -> {
            CompoundTag compoundTag2 = compoundTag.getCompoundTag("adult_sounds");
            compoundTag.remove("baby_sounds");
            compoundTag.putAll(compoundTag2);
        });
        this.registryDataRewriter.addHandler("frog_variant", (string, compoundTag) -> this.swapEntityNameAffix("frog", (CompoundTag)compoundTag));
        this.registryDataRewriter.addHandler("chicken_variant", (string, compoundTag) -> this.swapEntityNameAffix("chicken", (CompoundTag)compoundTag));
        this.registryDataRewriter.addHandler("cow_variant", (string, compoundTag) -> this.swapEntityNameAffix("cow", (CompoundTag)compoundTag));
        this.registryDataRewriter.addHandler("pig_variant", (string, compoundTag) -> this.swapEntityNameAffix("pig", (CompoundTag)compoundTag));
        this.registryDataRewriter.addHandler("cat_variant", (string, compoundTag) -> this.removeEntityNamePrefix("cat", (CompoundTag)compoundTag));
        this.registryDataRewriter.remove("world_clock");
        this.registryDataRewriter.remove("cat_sound_variant");
        this.registryDataRewriter.remove("cow_sound_variant");
        this.registryDataRewriter.remove("pig_sound_variant");
        this.registryDataRewriter.remove("chicken_sound_variant");
        this.tagRewriter.addEmptyTags(RegistryType.BLOCK, "big_dripleaf_placeable", "small_dripleaf_placeable", "mushroom_grow_block", "bamboo_plantable_on");
        this.cancelClientbound(ClientboundPackets26_1.LOW_DISK_SPACE_WARNING);
        this.cancelClientbound(ClientboundPackets26_1.GAME_RULE_VALUES);
        this.registerClientbound(ClientboundPackets26_1.SET_TIME, packetWrapper -> {
            long l = packetWrapper.passthrough(Types.LONG);
            Long l2 = null;
            boolean bl = true;
            int n = packetWrapper.read(Types.VAR_INT);
            for (int i = 0; i < n; ++i) {
                int n2 = packetWrapper.read(Types.VAR_INT);
                long l3 = packetWrapper.read(Types.VAR_LONG);
                packetWrapper.read(Types.FLOAT);
                float f = packetWrapper.read(Types.FLOAT).floatValue();
                if (!Key.equals(this.entityRewriter.tracker(packetWrapper.user()).registryKeys("world_clock").idToKey(n2), "overworld")) continue;
                l2 = l3;
                bl = f != 0.0f;
            }
            DayTimeStorage dayTimeStorage = packetWrapper.user().get(DayTimeStorage.class);
            if (l2 == null) {
                l2 = dayTimeStorage.setGameTimeAndUpdateDayTime(l);
                bl = dayTimeStorage.advanceTime();
            } else {
                dayTimeStorage.setGameTime(l);
                dayTimeStorage.setDayTime(l2);
                dayTimeStorage.setAdvanceTime(bl);
            }
            packetWrapper.write(Types.LONG, l2);
            packetWrapper.write(Types.BOOLEAN, bl);
        });
    }

    private void removeEntityNamePrefix(String string, CompoundTag compoundTag) {
        StringTag stringTag = compoundTag.getStringTag("asset_id");
        String string2 = stringTag.getValue();
        stringTag.setValue(string2.replace(string + "_", ""));
    }

    private void swapEntityNameAffix(String string, CompoundTag compoundTag) {
        StringTag stringTag = compoundTag.getStringTag("asset_id");
        String string2 = stringTag.getValue();
        if (string2.contains(string + "_")) {
            stringTag.setValue(string2.replace(string + "_", "") + "_" + string);
        }
    }

    @Override
    public void init(UserConnection userConnection) {
        this.addEntityTracker(userConnection, new EntityTrackerBase(userConnection, EntityTypes1_21_11.PLAYER));
        userConnection.addItemHasher(this.getClass(), new ItemHasherBase(this, userConnection));
        userConnection.put(new DayTimeStorage());
        userConnection.put(new GameModeStorage());
    }

    @Override
    public BackwardsMappingData getMappingData() {
        return MAPPINGS;
    }

    public EntityPacketRewriter26_1 getEntityRewriter() {
        return this.entityRewriter;
    }

    public BlockItemPacketRewriter26_1 getItemRewriter() {
        return this.itemRewriter;
    }

    @Override
    public BlockRewriter<ClientboundPacket26_1> getBlockRewriter() {
        return this.blockRewriter;
    }

    @Override
    public BackwardsRegistryRewriter getRegistryDataRewriter() {
        return this.registryDataRewriter;
    }

    @Override
    public RecipeDisplayRewriter<ClientboundPacket26_1> getRecipeRewriter() {
        return this.recipeRewriter;
    }

    @Override
    public ParticleRewriter<ClientboundPacket26_1> getParticleRewriter() {
        return this.particleRewriter;
    }

    @Override
    public NBTComponentRewriter<ClientboundPacket26_1> getComponentRewriter() {
        return this.translatableRewriter;
    }

    @Override
    public TagRewriter<ClientboundPacket26_1> getTagRewriter() {
        return this.tagRewriter;
    }

    @Override
    public Types26_1<StructuredDataKeys1_21_11, EntityDataTypes26_1> types() {
        return VersionedTypes.V26_1;
    }

    @Override
    public Types1_20_5<StructuredDataKeys1_21_11, EntityDataTypes1_21_11> mappedTypes() {
        return VersionedTypes.V1_21_11;
    }

    @Override
    protected PacketTypesProvider<ClientboundPacket26_1, ClientboundPacket1_21_11, ServerboundPacket26_1, ServerboundPacket1_21_9> createPacketTypesProvider() {
        return new SimplePacketTypesProvider<ClientboundPacket26_1, ClientboundPacket1_21_11, ServerboundPacket26_1, ServerboundPacket1_21_9>(ProtocolUtil.packetTypeMap(this.unmappedClientboundPacketType, ClientboundPackets26_1.class, ClientboundConfigurationPackets1_21_9.class), ProtocolUtil.packetTypeMap(this.mappedClientboundPacketType, ClientboundPackets1_21_11.class, ClientboundConfigurationPackets1_21_9.class), ProtocolUtil.packetTypeMap(this.mappedServerboundPacketType, ServerboundPackets26_1.class, ServerboundConfigurationPackets1_21_9.class), ProtocolUtil.packetTypeMap(this.unmappedServerboundPacketType, ServerboundPackets1_21_6.class, ServerboundConfigurationPackets1_21_9.class));
    }
}

