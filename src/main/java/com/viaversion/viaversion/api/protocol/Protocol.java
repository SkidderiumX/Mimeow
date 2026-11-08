/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.protocol;

import com.google.common.base.Preconditions;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.MappingData;
import com.viaversion.viaversion.api.platform.providers.ViaProviders;
import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.api.protocol.packet.Direction;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.packet.ServerboundPacketType;
import com.viaversion.viaversion.api.protocol.packet.State;
import com.viaversion.viaversion.api.protocol.packet.provider.PacketTypesProvider;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandler;
import com.viaversion.viaversion.api.rewriter.ComponentRewriter;
import com.viaversion.viaversion.api.rewriter.EntityRewriter;
import com.viaversion.viaversion.api.rewriter.ItemRewriter;
import com.viaversion.viaversion.api.rewriter.ParticleRewriter;
import com.viaversion.viaversion.api.rewriter.RegistryDataRewriter;
import com.viaversion.viaversion.api.rewriter.TagRewriter;
import com.viaversion.viaversion.api.type.types.version.VersionedTypesHolder;
import com.viaversion.viaversion.exception.CancelException;
import com.viaversion.viaversion.exception.InformativeException;
import com.viaversion.viaversion.util.ProtocolLogger;
import org.checkerframework.checker.nullness.qual.Nullable;

public interface Protocol<CU extends ClientboundPacketType, CM extends ClientboundPacketType, SM extends ServerboundPacketType, SU extends ServerboundPacketType> {
    default public void registerClientbound(State state, ClientboundPacketType clientboundPacketType, @Nullable PacketHandler packetHandler) {
        Preconditions.checkArgument(clientboundPacketType.state() == state);
        this.registerClientbound(state, clientboundPacketType.getId(), clientboundPacketType.getId(), packetHandler, false);
    }

    default public void registerServerbound(State state, ServerboundPacketType serverboundPacketType, @Nullable PacketHandler packetHandler) {
        Preconditions.checkArgument(serverboundPacketType.state() == state);
        this.registerServerbound(state, serverboundPacketType.getId(), serverboundPacketType.getId(), packetHandler, false);
    }

    default public void registerServerbound(State state, int n, int n2, @Nullable PacketHandler packetHandler) {
        this.registerServerbound(state, n, n2, packetHandler, false);
    }

    @Deprecated(forRemoval=true)
    public void registerServerbound(State var1, int var2, int var3, @Nullable PacketHandler var4, boolean var5);

    public void cancelServerbound(State var1, int var2);

    default public void registerClientbound(State state, int n, int n2, @Nullable PacketHandler packetHandler) {
        this.registerClientbound(state, n, n2, packetHandler, false);
    }

    public void cancelClientbound(State var1, int var2);

    @Deprecated(forRemoval=true)
    public void registerClientbound(State var1, int var2, int var3, @Nullable PacketHandler var4, boolean var5);

    public void registerClientbound(CU var1, @Nullable PacketHandler var2);

    default public void registerClientbound(CU CU, @Nullable CM CM) {
        this.registerClientbound(CU, CM, null);
    }

    default public void registerClientbound(CU CU, @Nullable CM CM, @Nullable PacketHandler packetHandler) {
        this.registerClientbound(CU, CM, packetHandler, false);
    }

    @Deprecated(forRemoval=true)
    public void registerClientbound(CU var1, @Nullable CM var2, @Nullable PacketHandler var3, boolean var4);

    public void cancelClientbound(CU var1);

    default public void registerServerbound(SU SU, @Nullable SM SM2) {
        this.registerServerbound(SU, SM2, null);
    }

    public void registerServerbound(SU var1, @Nullable PacketHandler var2);

    default public void registerServerbound(SU SU, @Nullable SM SM2, @Nullable PacketHandler packetHandler) {
        this.registerServerbound(SU, SM2, packetHandler, false);
    }

    @Deprecated(forRemoval=true)
    public void registerServerbound(SU var1, @Nullable SM var2, @Nullable PacketHandler var3, boolean var4);

    public void cancelServerbound(SU var1);

    default public boolean hasRegisteredClientbound(CU CU) {
        return this.hasRegisteredClientbound(CU.state(), CU.getId());
    }

    default public boolean hasRegisteredServerbound(SU SU) {
        return this.hasRegisteredServerbound(SU.state(), SU.getId());
    }

    public boolean hasRegisteredClientbound(State var1, int var2);

    public boolean hasRegisteredServerbound(State var1, int var2);

    public void appendClientbound(CU var1, PacketHandler var2);

    public void appendServerbound(SU var1, PacketHandler var2);

    public void replaceClientbound(CU var1, @Nullable PacketHandler var2);

    public void replaceServerbound(SU var1, @Nullable PacketHandler var2);

    public void transform(Direction var1, State var2, PacketWrapper var3) throws InformativeException, CancelException;

    public PacketTypesProvider<CU, CM, SM, SU> getPacketTypesProvider();

    @Deprecated
    public <T> @Nullable T get(Class<T> var1);

    @Deprecated
    public void put(Object var1);

    public void initialize();

    default public boolean hasMappingDataToLoad() {
        return this.getMappingData() != null;
    }

    public void loadMappingData();

    default public void register(ViaProviders viaProviders) {
    }

    default public void init(UserConnection userConnection) {
    }

    default public @Nullable MappingData getMappingData() {
        return null;
    }

    public ProtocolLogger getLogger();

    default public @Nullable EntityRewriter<?> getEntityRewriter() {
        return null;
    }

    default public @Nullable ItemRewriter<?> getItemRewriter() {
        return null;
    }

    default public @Nullable RegistryDataRewriter getRegistryDataRewriter() {
        return null;
    }

    default public @Nullable ParticleRewriter getParticleRewriter() {
        return null;
    }

    default public @Nullable TagRewriter getTagRewriter() {
        return null;
    }

    default public @Nullable ComponentRewriter getComponentRewriter() {
        return null;
    }

    default public @Nullable VersionedTypesHolder types() {
        return null;
    }

    default public @Nullable VersionedTypesHolder mappedTypes() {
        return null;
    }

    default public boolean isBaseProtocol() {
        return false;
    }

    default public @Nullable Class<? extends Protocol<?, ?, ?, ?>> dependsOn() {
        return null;
    }
}

