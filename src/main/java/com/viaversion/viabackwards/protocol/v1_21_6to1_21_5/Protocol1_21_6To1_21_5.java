/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_21_6to1_21_5;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.ViaBackwards;
import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viabackwards.api.data.BackwardsMappingData;
import com.viaversion.viabackwards.api.rewriters.BackwardsRegistryRewriter;
import com.viaversion.viabackwards.api.rewriters.text.NBTComponentRewriter;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data.Dialog;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.provider.ChestDialogViewProvider;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.provider.DialogViewProvider;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.rewriter.BlockItemPacketRewriter1_21_6;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.rewriter.ComponentRewriter1_21_6;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.rewriter.EntityPacketRewriter1_21_6;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.rewriter.RegistryDataRewriter1_21_6;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.storage.ChestDialogStorage;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.storage.ClickEvents;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.storage.RegistryAndTags;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.storage.ServerLinks;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.Holder;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_21_6;
import com.viaversion.viaversion.api.platform.providers.ViaProviders;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.packet.provider.PacketTypesProvider;
import com.viaversion.viaversion.api.protocol.packet.provider.SimplePacketTypesProvider;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_21_5;
import com.viaversion.viaversion.api.type.types.version.VersionedTypes;
import com.viaversion.viaversion.api.type.types.version.VersionedTypesHolder;
import com.viaversion.viaversion.data.entity.EntityTrackerBase;
import com.viaversion.viaversion.data.item.ItemHasherBase;
import com.viaversion.viaversion.protocols.v1_19_3to1_19_4.rewriter.CommandRewriter1_19_4;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ServerboundConfigurationPackets1_20_5;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundConfigurationPackets1_21;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.packet.ClientboundPacket1_21_5;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.packet.ClientboundPackets1_21_5;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.packet.ServerboundPacket1_21_5;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.packet.ServerboundPackets1_21_5;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.rewriter.RecipeDisplayRewriter1_21_5;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.Protocol1_21_5To1_21_6;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.packet.ClientboundConfigurationPackets1_21_6;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.packet.ClientboundPacket1_21_6;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.packet.ClientboundPackets1_21_6;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.packet.ServerboundConfigurationPackets1_21_6;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.packet.ServerboundPacket1_21_6;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.packet.ServerboundPackets1_21_6;
import com.viaversion.viaversion.rewriter.BlockRewriter;
import com.viaversion.viaversion.rewriter.ParticleRewriter;
import com.viaversion.viaversion.rewriter.RecipeDisplayRewriter;
import com.viaversion.viaversion.rewriter.TagRewriter;
import com.viaversion.viaversion.rewriter.block.BlockRewriter1_21_5;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.ProtocolUtil;

public class Protocol1_21_6To1_21_5
extends BackwardsProtocol<ClientboundPacket1_21_6, ClientboundPacket1_21_5, ServerboundPacket1_21_6, ServerboundPacket1_21_5> {
    public static final BackwardsMappingData MAPPINGS = new BackwardsMappingData("1.21.6", "1.21.5", Protocol1_21_5To1_21_6.class);
    private final EntityPacketRewriter1_21_6 entityRewriter = new EntityPacketRewriter1_21_6(this);
    private final BlockItemPacketRewriter1_21_6 itemRewriter = new BlockItemPacketRewriter1_21_6(this);
    private final ParticleRewriter<ClientboundPacket1_21_6> particleRewriter = new ParticleRewriter<ClientboundPacket1_21_6>(this);
    private final NBTComponentRewriter<ClientboundPacket1_21_6> translatableRewriter = new ComponentRewriter1_21_6(this);
    private final TagRewriter<ClientboundPacket1_21_6> tagRewriter = new TagRewriter<ClientboundPacket1_21_6>(this);
    private final RecipeDisplayRewriter<ClientboundPacket1_21_6> recipeRewriter = new RecipeDisplayRewriter1_21_5<ClientboundPacket1_21_6>(this);
    private final BackwardsRegistryRewriter registryDataRewriter = new RegistryDataRewriter1_21_6(this);
    private final BlockRewriter<ClientboundPacket1_21_6> blockRewriter = new BlockRewriter1_21_5<ClientboundPacket1_21_6>(this, ChunkType1_21_5::new);

    public Protocol1_21_6To1_21_5() {
        super(ClientboundPacket1_21_6.class, ClientboundPacket1_21_5.class, ServerboundPacket1_21_6.class, ServerboundPacket1_21_5.class);
    }

    @Override
    protected void registerPackets() {
        super.registerPackets();
        this.replaceClientbound(ClientboundPackets1_21_6.UPDATE_TAGS, this::updateTags);
        this.replaceClientbound(ClientboundConfigurationPackets1_21_6.UPDATE_TAGS, this::updateTags);
        this.appendClientbound(ClientboundPackets1_21_6.SOUND, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            this.fixSoundSource(packetWrapper);
        });
        this.appendClientbound(ClientboundPackets1_21_6.SOUND_ENTITY, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            this.fixSoundSource(packetWrapper);
        });
        this.appendClientbound(ClientboundPackets1_21_6.STOP_SOUND, packetWrapper -> {
            byte by = packetWrapper.get(Types.BYTE, 0);
            if ((by & 1) != 0) {
                this.fixSoundSource(packetWrapper);
            }
        });
        CommandRewriter1_19_4<ClientboundPacket1_21_6> commandRewriter1_19_4 = new CommandRewriter1_19_4<ClientboundPacket1_21_6>((Protocol)this){

            @Override
            public void handleArgument(PacketWrapper packetWrapper, String string) {
                if (string.equals("minecraft:hex_color") || string.equals("minecraft:dialog")) {
                    packetWrapper.write(Types.VAR_INT, 0);
                } else {
                    super.handleArgument(packetWrapper, string);
                }
            }
        };
        this.replaceClientbound(ClientboundPackets1_21_6.COMMANDS, commandRewriter1_19_4::handle1_19);
        this.registerClientbound(ClientboundPackets1_21_6.CHANGE_DIFFICULTY, packetWrapper -> {
            int n = packetWrapper.read(Types.VAR_INT);
            packetWrapper.write(Types.UNSIGNED_BYTE, (short)n);
        });
        this.registerServerbound(ServerboundPackets1_21_5.CHANGE_DIFFICULTY, packetWrapper -> {
            short s = packetWrapper.read(Types.UNSIGNED_BYTE);
            packetWrapper.write(Types.VAR_INT, Integer.valueOf(s));
        });
        this.registerServerbound(ServerboundPackets1_21_5.CHAT_COMMAND, this::handleClickEvents);
        this.registerServerbound(ServerboundPackets1_21_5.CHAT_COMMAND_SIGNED, this::handleClickEvents);
        this.registerClientbound(ClientboundPackets1_21_6.SHOW_DIALOG, null, (PacketWrapper packetWrapper) -> {
            packetWrapper.cancel();
            if (!ViaBackwards.getConfig().dialogsViaChests()) {
                return;
            }
            RegistryAndTags registryAndTags = packetWrapper.user().get(RegistryAndTags.class);
            ServerLinks serverLinks = packetWrapper.user().get(ServerLinks.class);
            Holder holder = (Holder)((Object)packetWrapper.passthrough(Types.TRUSTED_COMPOUND_TAG_HOLDER));
            CompoundTag compoundTag = holder.isDirect() ? (CompoundTag)holder.value() : registryAndTags.fromRegistry(holder.id());
            DialogViewProvider dialogViewProvider = Via.getManager().getProviders().get(DialogViewProvider.class);
            dialogViewProvider.openDialog(packetWrapper.user(), new Dialog(registryAndTags, serverLinks, compoundTag));
        });
        this.registerClientbound(ClientboundConfigurationPackets1_21_6.SHOW_DIALOG, null, (PacketWrapper packetWrapper) -> {
            packetWrapper.cancel();
            if (!ViaBackwards.getConfig().dialogsViaChests()) {
                return;
            }
            RegistryAndTags registryAndTags = packetWrapper.user().get(RegistryAndTags.class);
            ServerLinks serverLinks = packetWrapper.user().get(ServerLinks.class);
            CompoundTag compoundTag = packetWrapper.read(Types.TRUSTED_COMPOUND_TAG);
            DialogViewProvider dialogViewProvider = Via.getManager().getProviders().get(DialogViewProvider.class);
            dialogViewProvider.openDialog(packetWrapper.user(), new Dialog(registryAndTags, serverLinks, compoundTag));
        });
        this.registerClientbound(ClientboundPackets1_21_6.CLEAR_DIALOG, null, this::clearDialog);
        this.registerClientbound(ClientboundConfigurationPackets1_21_6.CLEAR_DIALOG, null, this::clearDialog);
        this.registerClientbound(ClientboundPackets1_21_6.SERVER_LINKS, this::storeServerLinks);
        this.registerClientbound(ClientboundConfigurationPackets1_21_6.SERVER_LINKS, this::storeServerLinks);
        this.registerServerbound(ServerboundPackets1_21_5.CONTAINER_CLOSE, packetWrapper -> {
            ChestDialogStorage chestDialogStorage = packetWrapper.user().get(ChestDialogStorage.class);
            if (chestDialogStorage == null) {
                return;
            }
            ChestDialogViewProvider chestDialogViewProvider = (ChestDialogViewProvider)Via.getManager().getProviders().get(DialogViewProvider.class);
            if (chestDialogStorage.phase() == ChestDialogStorage.Phase.ANVIL_VIEW) {
                packetWrapper.cancel();
                chestDialogViewProvider.openChestView(packetWrapper.user(), chestDialogStorage, ChestDialogStorage.Phase.DIALOG_VIEW);
                return;
            }
            if (chestDialogStorage.phase() == ChestDialogStorage.Phase.WAITING_FOR_RESPONSE) {
                packetWrapper.cancel();
                if (chestDialogStorage.closeButtonEnabled()) {
                    chestDialogViewProvider.openChestView(packetWrapper.user(), chestDialogStorage, ChestDialogStorage.Phase.DIALOG_VIEW);
                } else {
                    chestDialogViewProvider.openChestView(packetWrapper.user(), chestDialogStorage, ChestDialogStorage.Phase.WAITING_FOR_RESPONSE);
                }
                return;
            }
            boolean bl = chestDialogStorage.allowClosing();
            if (!bl) {
                packetWrapper.cancel();
                if (chestDialogStorage.dialog().canCloseWithEscape()) {
                    chestDialogViewProvider.clickButton(packetWrapper.user(), Dialog.AfterAction.CLOSE, chestDialogStorage.dialog().actionButton());
                } else {
                    chestDialogViewProvider.openChestView(packetWrapper.user(), chestDialogStorage, ChestDialogStorage.Phase.DIALOG_VIEW);
                }
            }
            chestDialogStorage.setAllowClosing(false);
        });
        this.registerServerbound(ServerboundPackets1_21_5.RENAME_ITEM, packetWrapper -> {
            ChestDialogStorage chestDialogStorage = packetWrapper.user().get(ChestDialogStorage.class);
            if (chestDialogStorage == null || chestDialogStorage.phase() != ChestDialogStorage.Phase.ANVIL_VIEW) {
                return;
            }
            packetWrapper.cancel();
            String string = packetWrapper.read(Types.STRING);
            ChestDialogViewProvider chestDialogViewProvider = (ChestDialogViewProvider)Via.getManager().getProviders().get(DialogViewProvider.class);
            chestDialogViewProvider.updateAnvilText(packetWrapper.user(), string);
        });
        this.appendServerbound(ServerboundPackets1_21_5.CONTAINER_CLICK, packetWrapper -> {
            ChestDialogViewProvider chestDialogViewProvider = (ChestDialogViewProvider)Via.getManager().getProviders().get(DialogViewProvider.class);
            if (chestDialogViewProvider == null) {
                return;
            }
            int n = packetWrapper.get(Types.VAR_INT, 0);
            short s = packetWrapper.get(Types.SHORT, 0);
            byte by = packetWrapper.get(Types.BYTE, 0);
            int n2 = packetWrapper.get(Types.VAR_INT, 2);
            if (chestDialogViewProvider.clickDialog(packetWrapper.user(), n, s, by, n2)) {
                packetWrapper.cancel();
            }
        });
        this.cancelClientbound(ClientboundPackets1_21_6.TRACKED_WAYPOINT);
    }

    private void fixSoundSource(PacketWrapper packetWrapper) {
        int n = packetWrapper.get(Types.VAR_INT, 0);
        if (n == 10) {
            packetWrapper.set(Types.VAR_INT, 0, 0);
        }
    }

    private void updateTags(PacketWrapper packetWrapper) {
        RegistryAndTags registryAndTags = packetWrapper.user().get(RegistryAndTags.class);
        int n = packetWrapper.passthrough(Types.VAR_INT);
        for (int i = 0; i < n; ++i) {
            String string = packetWrapper.passthrough(Types.STRING);
            boolean bl = "dialog".equals(Key.stripMinecraftNamespace(string));
            int n2 = packetWrapper.passthrough(Types.VAR_INT);
            for (int j = 0; j < n2; ++j) {
                String string2 = packetWrapper.passthrough(Types.STRING);
                int[] nArray = packetWrapper.passthrough(Types.VAR_INT_ARRAY_PRIMITIVE);
                if (!bl) continue;
                registryAndTags.storeTags(string2, nArray);
            }
        }
        packetWrapper.resetReader();
        this.tagRewriter.handleGeneric(packetWrapper);
    }

    private void clearDialog(PacketWrapper packetWrapper) {
        packetWrapper.cancel();
        if (!ViaBackwards.getConfig().dialogsViaChests()) {
            return;
        }
        DialogViewProvider dialogViewProvider = Via.getManager().getProviders().get(DialogViewProvider.class);
        dialogViewProvider.closeDialog(packetWrapper.user());
    }

    private void storeServerLinks(PacketWrapper packetWrapper) {
        ServerLinks serverLinks = new ServerLinks();
        int n = packetWrapper.passthrough(Types.VAR_INT);
        for (int i = 0; i < n; ++i) {
            String string;
            if (packetWrapper.passthrough(Types.BOOLEAN).booleanValue()) {
                int n2 = packetWrapper.passthrough(Types.VAR_INT);
                string = packetWrapper.passthrough(Types.STRING);
                serverLinks.storeLink(n2, string);
                continue;
            }
            Tag tag = packetWrapper.passthrough(Types.TRUSTED_TAG);
            string = packetWrapper.passthrough(Types.STRING);
            serverLinks.storeLink(tag, string);
        }
        packetWrapper.user().put(serverLinks);
    }

    private void handleClickEvents(PacketWrapper packetWrapper) {
        String string = packetWrapper.passthrough(Types.STRING);
        ClickEvents clickEvents = packetWrapper.user().get(ClickEvents.class);
        if (clickEvents.handleChatCommand(packetWrapper.user(), string)) {
            packetWrapper.cancel();
        }
    }

    @Override
    public void init(UserConnection userConnection) {
        this.addEntityTracker(userConnection, new EntityTrackerBase(userConnection, EntityTypes1_21_6.PLAYER));
        userConnection.addItemHasher(this.getClass(), new ItemHasherBase(this, userConnection));
        userConnection.put(new RegistryAndTags());
        userConnection.put(new ClickEvents());
    }

    @Override
    public void register(ViaProviders viaProviders) {
        viaProviders.register(DialogViewProvider.class, new ChestDialogViewProvider(this));
    }

    @Override
    public BackwardsMappingData getMappingData() {
        return MAPPINGS;
    }

    public EntityPacketRewriter1_21_6 getEntityRewriter() {
        return this.entityRewriter;
    }

    public BlockItemPacketRewriter1_21_6 getItemRewriter() {
        return this.itemRewriter;
    }

    @Override
    public BlockRewriter<ClientboundPacket1_21_6> getBlockRewriter() {
        return this.blockRewriter;
    }

    @Override
    public BackwardsRegistryRewriter getRegistryDataRewriter() {
        return this.registryDataRewriter;
    }

    @Override
    public ParticleRewriter<ClientboundPacket1_21_6> getParticleRewriter() {
        return this.particleRewriter;
    }

    @Override
    public NBTComponentRewriter<ClientboundPacket1_21_6> getComponentRewriter() {
        return this.translatableRewriter;
    }

    @Override
    public TagRewriter<ClientboundPacket1_21_6> getTagRewriter() {
        return this.tagRewriter;
    }

    @Override
    public RecipeDisplayRewriter<ClientboundPacket1_21_6> getRecipeRewriter() {
        return this.recipeRewriter;
    }

    @Override
    public VersionedTypesHolder types() {
        return VersionedTypes.V1_21_6;
    }

    @Override
    public VersionedTypesHolder mappedTypes() {
        return VersionedTypes.V1_21_5;
    }

    @Override
    protected PacketTypesProvider<ClientboundPacket1_21_6, ClientboundPacket1_21_5, ServerboundPacket1_21_6, ServerboundPacket1_21_5> createPacketTypesProvider() {
        return new SimplePacketTypesProvider<ClientboundPacket1_21_6, ClientboundPacket1_21_5, ServerboundPacket1_21_6, ServerboundPacket1_21_5>(ProtocolUtil.packetTypeMap(this.unmappedClientboundPacketType, ClientboundPackets1_21_6.class, ClientboundConfigurationPackets1_21_6.class), ProtocolUtil.packetTypeMap(this.mappedClientboundPacketType, ClientboundPackets1_21_5.class, ClientboundConfigurationPackets1_21.class), ProtocolUtil.packetTypeMap(this.mappedServerboundPacketType, ServerboundPackets1_21_6.class, ServerboundConfigurationPackets1_21_6.class), ProtocolUtil.packetTypeMap(this.unmappedServerboundPacketType, ServerboundPackets1_21_5.class, ServerboundConfigurationPackets1_20_5.class));
    }
}

