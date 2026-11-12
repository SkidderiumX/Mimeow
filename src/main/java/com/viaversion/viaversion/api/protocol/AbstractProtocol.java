/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.protocol;

import com.google.common.base.Preconditions;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.entity.EntityTracker;
import com.viaversion.viaversion.api.data.item.ItemHasher;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.api.protocol.packet.Direction;
import com.viaversion.viaversion.api.protocol.packet.PacketType;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.packet.ServerboundPacketType;
import com.viaversion.viaversion.api.protocol.packet.State;
import com.viaversion.viaversion.api.protocol.packet.mapping.PacketMapping;
import com.viaversion.viaversion.api.protocol.packet.mapping.PacketMappings;
import com.viaversion.viaversion.api.protocol.packet.provider.PacketTypeMap;
import com.viaversion.viaversion.api.protocol.packet.provider.PacketTypesProvider;
import com.viaversion.viaversion.api.protocol.packet.provider.SimplePacketTypesProvider;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandler;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import com.viaversion.viaversion.api.rewriter.MappingDataListener;
import com.viaversion.viaversion.api.rewriter.Rewriter;
import com.viaversion.viaversion.data.entity.EntityTrackerBase;
import com.viaversion.viaversion.data.item.ItemHasherBase;
import com.viaversion.viaversion.exception.CancelException;
import com.viaversion.viaversion.exception.InformativeException;
import com.viaversion.viaversion.protocol.shared_registration.SharedRegistrations;
import com.viaversion.viaversion.rewriter.BlockRewriter;
import com.viaversion.viaversion.rewriter.RecipeDisplayRewriter;
import com.viaversion.viaversion.util.ProtocolLogger;
import com.viaversion.viaversion.util.ProtocolUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.logging.Level;
import org.checkerframework.checker.nullness.qual.Nullable;

public abstract class AbstractProtocol<CU extends ClientboundPacketType, CM extends ClientboundPacketType, SM extends ServerboundPacketType, SU extends ServerboundPacketType>
implements Protocol<CU, CM, SM, SU> {
    protected final Class<CU> unmappedClientboundPacketType;
    protected final Class<CM> mappedClientboundPacketType;
    protected final Class<SM> mappedServerboundPacketType;
    protected final Class<SU> unmappedServerboundPacketType;
    protected final PacketTypesProvider<CU, CM, SM, SU> packetTypesProvider;
    protected final PacketMappings clientboundMappings;
    protected final PacketMappings serverboundMappings;
    private final Map<Class<?>, Object> storedObjects = new HashMap();
    private boolean initialized;
    private ProtocolLogger logger;
    private ProtocolVersion serverVersion;
    private ProtocolVersion clientVersion;

    @Deprecated
    protected AbstractProtocol() {
        this(null, null, null, null);
    }

    protected AbstractProtocol(@Nullable Class<CU> clazz, @Nullable Class<CM> clazz2, @Nullable Class<SM> clazz3, @Nullable Class<SU> clazz4) {
        this.unmappedClientboundPacketType = clazz;
        this.mappedClientboundPacketType = clazz2;
        this.mappedServerboundPacketType = clazz3;
        this.unmappedServerboundPacketType = clazz4;
        this.packetTypesProvider = this.createPacketTypesProvider();
        this.clientboundMappings = this.createClientboundPacketMappings();
        this.serverboundMappings = this.createServerboundPacketMappings();
    }

    @Override
    public final void initialize() {
        Preconditions.checkArgument(!this.initialized, "Protocol has already been initialized");
        this.initialized = true;
        if (this.logger == null) {
            this.logger = this.createLogger();
        }
        this.applySharedRegistrations();
        this.registerPackets();
        if (this.unmappedClientboundPacketType != null && this.mappedClientboundPacketType != null && this.unmappedClientboundPacketType != this.mappedClientboundPacketType) {
            this.registerPacketIdChanges(this.packetTypesProvider.unmappedClientboundPacketTypes(), this.packetTypesProvider.mappedClientboundPacketTypes(), this::hasRegisteredClientbound, this::registerClientbound);
        }
        if (this.mappedServerboundPacketType != null && this.unmappedServerboundPacketType != null && this.mappedServerboundPacketType != this.unmappedServerboundPacketType) {
            this.registerPacketIdChanges(this.packetTypesProvider.unmappedServerboundPacketTypes(), this.packetTypesProvider.mappedServerboundPacketTypes(), this::hasRegisteredServerbound, this::registerServerbound);
        }
    }

    protected void applySharedRegistrations() {
        SharedRegistrations.defaultRegistrations().applyMatching(this);
    }

    protected ProtocolLogger createLogger() {
        return new ProtocolLogger(this.getClass());
    }

    @Override
    public void appendClientbound(CU CU, PacketHandler packetHandler) {
        PacketMapping packetMapping = this.clientboundMappings.mappedPacket(CU.state(), CU.getId());
        if (packetMapping != null) {
            packetMapping.appendHandler(packetHandler);
        } else {
            this.registerClientbound(CU, packetHandler);
        }
    }

    @Override
    public void appendServerbound(SU SU, PacketHandler packetHandler) {
        PacketMapping packetMapping = this.serverboundMappings.mappedPacket(SU.state(), SU.getId());
        if (packetMapping != null) {
            packetMapping.appendHandler(packetHandler);
        } else {
            this.registerServerbound(SU, packetHandler);
        }
    }

    @Override
    public void replaceClientbound(CU CU, @Nullable PacketHandler packetHandler) {
        PacketMapping packetMapping = this.clientboundMappings.mappedPacket(CU.state(), CU.getId());
        Preconditions.checkNotNull(packetMapping, "Packet %s has no handler to replace", CU);
        packetMapping.setHandler(packetHandler);
    }

    @Override
    public void replaceServerbound(SU SU, @Nullable PacketHandler packetHandler) {
        PacketMapping packetMapping = this.serverboundMappings.mappedPacket(SU.state(), SU.getId());
        Preconditions.checkNotNull(packetMapping, "Packet %s has no handler to replace", SU);
        packetMapping.setHandler(packetHandler);
    }

    private <U extends PacketType, M extends PacketType> void registerPacketIdChanges(Map<State, PacketTypeMap<U>> map, Map<State, PacketTypeMap<M>> map2, Predicate<U> predicate, BiConsumer<U, M> biConsumer) {
        for (Map.Entry<State, PacketTypeMap<M>> entry : map2.entrySet()) {
            PacketTypeMap<M> packetTypeMap = entry.getValue();
            PacketTypeMap<U> packetTypeMap2 = map.get((Object)entry.getKey());
            for (PacketType packetType : packetTypeMap2.types()) {
                M m = packetTypeMap.typeByName(packetType.getName());
                if (m == null) {
                    Preconditions.checkArgument(predicate.test(packetType), "Packet %s in %s has no mapping - it needs to be manually cancelled or remapped", packetType, this.getClass());
                    continue;
                }
                if (packetType.getId() == m.getId() || predicate.test(packetType)) continue;
                biConsumer.accept(packetType, m);
            }
        }
    }

    @Override
    public final void loadMappingData() {
        this.getMappingData().load();
        this.initialize();
        this.onMappingDataLoaded();
    }

    protected void registerPackets() {
        this.callRegister(this.getEntityRewriter());
        this.callRegister(this.getItemRewriter());
    }

    protected void onMappingDataLoaded() {
        this.callOnMappingDataLoaded(this.getEntityRewriter());
        this.callOnMappingDataLoaded(this.getItemRewriter());
        this.callOnMappingDataLoaded(this.getTagRewriter());
    }

    private void callRegister(@Nullable Rewriter<?> rewriter) {
        if (rewriter != null) {
            rewriter.register();
        }
    }

    private void callOnMappingDataLoaded(@Nullable MappingDataListener mappingDataListener) {
        if (mappingDataListener != null) {
            mappingDataListener.onMappingDataLoaded();
        }
    }

    protected void addEntityTracker(UserConnection userConnection) {
        EntityType entityType = this.getEntityRewriter().typeFromId("player");
        Preconditions.checkNotNull(entityType, "Player entity type not found");
        userConnection.addEntityTracker(this.getClass(), new EntityTrackerBase(userConnection, entityType));
    }

    protected void addEntityTracker(UserConnection userConnection, EntityTracker entityTracker) {
        userConnection.addEntityTracker(this.getClass(), entityTracker);
    }

    protected void addItemHasher(UserConnection userConnection) {
        userConnection.addItemHasher(this.getClass(), new ItemHasherBase(this, userConnection));
    }

    @java.lang.Deprecated(forRemoval=true)
    protected void addItemHasher(UserConnection userConnection, ItemHasher itemHasher) {
        userConnection.addItemHasher(this.getClass(), itemHasher);
    }

    protected PacketTypesProvider<CU, CM, SM, SU> createPacketTypesProvider() {
        return new SimplePacketTypesProvider<CU, CM, SM, SU>(ProtocolUtil.packetTypeMap(this.unmappedClientboundPacketType, this.unmappedClientboundPacketType), ProtocolUtil.packetTypeMap(this.mappedClientboundPacketType, this.mappedClientboundPacketType), ProtocolUtil.packetTypeMap(this.mappedServerboundPacketType, this.mappedServerboundPacketType), ProtocolUtil.packetTypeMap(this.unmappedServerboundPacketType, this.unmappedServerboundPacketType));
    }

    protected PacketMappings createClientboundPacketMappings() {
        return PacketMappings.arrayMappings();
    }

    protected PacketMappings createServerboundPacketMappings() {
        return PacketMappings.arrayMappings();
    }

    public @Nullable ProtocolVersion getServerVersion() {
        return this.serverVersion;
    }

    public void setServerVersion(ProtocolVersion protocolVersion) {
        this.serverVersion = protocolVersion;
    }

    public @Nullable ProtocolVersion getClientVersion() {
        return this.clientVersion;
    }

    public void setClientVersion(ProtocolVersion protocolVersion) {
        this.clientVersion = protocolVersion;
    }

    @Override
    public void registerServerbound(State state, int n, int n2, PacketHandler packetHandler, boolean bl) {
        Preconditions.checkArgument(n != -1, "Unmapped packet id cannot be -1");
        PacketMapping packetMapping = PacketMapping.of(n2, packetHandler);
        if (!bl && this.serverboundMappings.hasMapping(state, n)) {
            Via.getPlatform().getLogger().log(Level.WARNING, n + " already registered! If this override is intentional, use replaceServerbound instead. Stacktrace: ", new Exception());
        }
        this.serverboundMappings.addMapping(state, n, packetMapping);
    }

    @Override
    public void cancelServerbound(State state, int n) {
        this.registerServerbound(state, n, n, PacketWrapper::cancel);
    }

    @Override
    public void registerClientbound(State state, int n, int n2, PacketHandler packetHandler, boolean bl) {
        Preconditions.checkArgument(n != -1, "Unmapped packet id cannot be -1");
        PacketMapping packetMapping = PacketMapping.of(n2, packetHandler);
        if (!bl && this.clientboundMappings.hasMapping(state, n)) {
            Via.getPlatform().getLogger().log(Level.WARNING, n + " already registered! If override is intentional, use replaceClientbound instead. Stacktrace: ", new Exception());
        }
        this.clientboundMappings.addMapping(state, n, packetMapping);
    }

    @Override
    public void cancelClientbound(State state, int n) {
        this.registerClientbound(state, n, n, PacketWrapper::cancel);
    }

    @Override
    public void registerClientbound(CU CU, @Nullable PacketHandler packetHandler) {
        PacketTypeMap<CM> packetTypeMap = this.packetTypesProvider.mappedClientboundPacketTypes().get((Object)CU.state());
        ClientboundPacketType clientboundPacketType = (ClientboundPacketType)AbstractProtocol.mappedPacketType(CU, packetTypeMap, this.unmappedClientboundPacketType, this.mappedClientboundPacketType);
        this.registerClientbound(CU, clientboundPacketType, packetHandler);
    }

    @Override
    public void registerClientbound(CU CU, @Nullable CM CM, @Nullable PacketHandler packetHandler, boolean bl) {
        this.register(this.clientboundMappings, (PacketType)CU, (PacketType)CM, (Class<? extends PacketType>)this.unmappedClientboundPacketType, (Class<? extends PacketType>)this.mappedClientboundPacketType, packetHandler, bl);
    }

    @Override
    public void cancelClientbound(CU CU) {
        this.registerClientbound(CU, null, PacketWrapper::cancel);
    }

    @Override
    public void registerServerbound(SU SU, @Nullable PacketHandler packetHandler) {
        PacketTypeMap<SM> packetTypeMap = this.packetTypesProvider.mappedServerboundPacketTypes().get((Object)SU.state());
        ServerboundPacketType serverboundPacketType = (ServerboundPacketType)AbstractProtocol.mappedPacketType(SU, packetTypeMap, this.unmappedServerboundPacketType, this.mappedServerboundPacketType);
        this.registerServerbound(SU, serverboundPacketType, packetHandler);
    }

    @Override
    public void registerServerbound(SU SU, @Nullable SM SM2, @Nullable PacketHandler packetHandler, boolean bl) {
        this.register(this.serverboundMappings, (PacketType)SU, (PacketType)SM2, (Class<? extends PacketType>)this.unmappedServerboundPacketType, (Class<? extends PacketType>)this.mappedServerboundPacketType, packetHandler, bl);
    }

    @Override
    public void cancelServerbound(SU SU) {
        this.registerServerbound(SU, null, PacketWrapper::cancel);
    }

    private void register(PacketMappings packetMappings, PacketType packetType, @Nullable PacketType packetType2, Class<? extends PacketType> clazz, Class<? extends PacketType> clazz2, @Nullable PacketHandler packetHandler, boolean bl) {
        AbstractProtocol.checkPacketType(packetType, clazz == null || clazz.isInstance(packetType));
        if (packetType2 != null) {
            AbstractProtocol.checkPacketType(packetType2, clazz2 == null || clazz2.isInstance(packetType2));
            Preconditions.checkArgument(packetType.state() == packetType2.state(), "Packet type state does not match mapped packet type state");
            Preconditions.checkArgument(packetType.direction() == packetType2.direction(), "Packet type direction does not match mapped packet type state");
        }
        PacketMapping packetMapping = PacketMapping.of(packetType2, packetHandler);
        if (!bl && packetMappings.hasMapping(packetType)) {
            throw new IllegalArgumentException("Packet type " + String.valueOf(packetType) + " already registered! If override is intentional, use " + (packetType.direction() == Direction.SERVERBOUND ? "replaceServerbound" : "replaceClientbound") + " instead.");
        }
        packetMappings.addMapping(packetType, packetMapping);
    }

    private static <U extends PacketType, M extends PacketType> M mappedPacketType(U u, PacketTypeMap<M> packetTypeMap, Class<U> clazz, Class<M> clazz2) {
        Preconditions.checkNotNull(u);
        AbstractProtocol.checkPacketType(u, clazz == null || clazz.isInstance(u));
        if (clazz == clazz2) {
            return (M)u;
        }
        Preconditions.checkNotNull(packetTypeMap, "Mapped packet types not provided for state %s of type class %s", new Object[]{u.state(), clazz2});
        M m = packetTypeMap.typeByName(u.getName());
        if (m != null) {
            return m;
        }
        throw new IllegalArgumentException("Packet type " + String.valueOf(u) + " in " + u.getClass().getSimpleName() + " could not be automatically mapped!");
    }

    @Override
    public boolean hasRegisteredClientbound(State state, int n) {
        return this.clientboundMappings.hasMapping(state, n);
    }

    @Override
    public boolean hasRegisteredServerbound(State state, int n) {
        return this.serverboundMappings.hasMapping(state, n);
    }

    @Override
    public void transform(Direction direction, State state, PacketWrapper packetWrapper) throws InformativeException, CancelException {
        int n;
        PacketMappings packetMappings = direction == Direction.CLIENTBOUND ? this.clientboundMappings : this.serverboundMappings;
        PacketMapping packetMapping = packetMappings.mappedPacket(state, n = packetWrapper.getId());
        if (packetMapping == null) {
            return;
        }
        packetMapping.applyType(packetWrapper);
        PacketHandler packetHandler = packetMapping.handler();
        if (packetHandler != null) {
            try {
                packetHandler.handle(packetWrapper);
            }
            catch (InformativeException informativeException) {
                informativeException.addSource(packetHandler.getClass());
                this.printRemapError(direction, state, n, packetWrapper.getId(), informativeException);
                throw informativeException;
            }
            catch (Exception exception) {
                InformativeException informativeException = new InformativeException(exception);
                informativeException.addSource(packetHandler.getClass());
                this.printRemapError(direction, state, n, packetWrapper.getId(), informativeException);
                throw informativeException;
            }
            if (packetWrapper.isCancelled()) {
                throw CancelException.generate();
            }
        }
    }

    @Override
    public ProtocolLogger getLogger() {
        return this.logger;
    }

    public @Nullable BlockRewriter<CU> getBlockRewriter() {
        return null;
    }

    public @Nullable RecipeDisplayRewriter<CU> getRecipeRewriter() {
        return null;
    }

    private void printRemapError(Direction direction, State state, int n, int n2, InformativeException informativeException) {
        Object object;
        if (state != State.PLAY && direction == Direction.SERVERBOUND && !Via.getManager().debugHandler().enabled()) {
            informativeException.setShouldBePrinted(false);
            return;
        }
        Object object2 = object = direction == Direction.CLIENTBOUND ? this.packetTypesProvider.unmappedClientboundType(state, n) : this.packetTypesProvider.unmappedServerboundType(state, n);
        if (object != null) {
            Via.getPlatform().getLogger().warning("ERROR IN " + this.getClass().getSimpleName() + " IN REMAP OF " + String.valueOf(object) + " (" + ProtocolUtil.toNiceHex(n) + ")");
        } else {
            Via.getPlatform().getLogger().warning("ERROR IN " + this.getClass().getSimpleName() + " IN REMAP OF " + String.valueOf((Object)state) + " " + ProtocolUtil.toNiceHex(n) + "->" + ProtocolUtil.toNiceHex(n2));
        }
    }

    private static void checkPacketType(PacketType packetType, boolean bl) {
        if (!bl) {
            throw new IllegalArgumentException("Packet type " + String.valueOf(packetType) + " in " + packetType.getClass().getSimpleName() + " is taken from the wrong packet types class");
        }
    }

    @Override
    public final PacketTypesProvider<CU, CM, SM, SU> getPacketTypesProvider() {
        return this.packetTypesProvider;
    }

    @Override
    public <T> @Nullable T get(Class<T> clazz) {
        return (T)this.storedObjects.get(clazz);
    }

    @Override
    public void put(Object object) {
        this.storedObjects.put(object.getClass(), object);
    }

    public String toString() {
        return "Protocol:" + this.getClass().getSimpleName();
    }
}

