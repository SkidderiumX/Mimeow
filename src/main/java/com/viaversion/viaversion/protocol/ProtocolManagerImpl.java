/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocol;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Range;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.MappingDataLoader;
import com.viaversion.viaversion.api.protocol.AbstractProtocol;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.protocol.ProtocolManager;
import com.viaversion.viaversion.api.protocol.ProtocolPathEntry;
import com.viaversion.viaversion.api.protocol.ProtocolPathKey;
import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.api.protocol.packet.Direction;
import com.viaversion.viaversion.api.protocol.packet.PacketType;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.packet.ServerboundPacketType;
import com.viaversion.viaversion.api.protocol.packet.VersionedPacketTransformer;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import com.viaversion.viaversion.api.protocol.version.ServerProtocolVersion;
import com.viaversion.viaversion.api.protocol.version.VersionType;
import com.viaversion.viaversion.libs.fastutil.objects.Object2ObjectMap;
import com.viaversion.viaversion.libs.fastutil.objects.Object2ObjectOpenHashMap;
import com.viaversion.viaversion.libs.fastutil.objects.Reference2ObjectOpenHashMap;
import com.viaversion.viaversion.protocol.ProtocolPathEntryImpl;
import com.viaversion.viaversion.protocol.ProtocolPathKeyImpl;
import com.viaversion.viaversion.protocol.ServerProtocolVersionSingleton;
import com.viaversion.viaversion.protocol.packet.PacketWrapperImpl;
import com.viaversion.viaversion.protocol.packet.VersionedPacketTransformerImpl;
import com.viaversion.viaversion.protocol.shared_registration.def.DefaultRegistrations;
import com.viaversion.viaversion.protocols.base.InitialBaseProtocol;
import com.viaversion.viaversion.protocols.base.v1_16.ClientboundBaseProtocol1_16;
import com.viaversion.viaversion.protocols.base.v1_7.ClientboundBaseProtocol1_7;
import com.viaversion.viaversion.protocols.base.v1_7.ServerboundBaseProtocol1_7;
import com.viaversion.viaversion.protocols.v1_10to1_11.Protocol1_10To1_11;
import com.viaversion.viaversion.protocols.v1_11_1to1_12.Protocol1_11_1To1_12;
import com.viaversion.viaversion.protocols.v1_11to1_11_1.Protocol1_11To1_11_1;
import com.viaversion.viaversion.protocols.v1_12_1to1_12_2.Protocol1_12_1To1_12_2;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.Protocol1_12_2To1_13;
import com.viaversion.viaversion.protocols.v1_12to1_12_1.Protocol1_12To1_12_1;
import com.viaversion.viaversion.protocols.v1_13_1to1_13_2.Protocol1_13_1To1_13_2;
import com.viaversion.viaversion.protocols.v1_13_2to1_14.Protocol1_13_2To1_14;
import com.viaversion.viaversion.protocols.v1_13to1_13_1.Protocol1_13To1_13_1;
import com.viaversion.viaversion.protocols.v1_14_1to1_14_2.Protocol1_14_1To1_14_2;
import com.viaversion.viaversion.protocols.v1_14_2to1_14_3.Protocol1_14_2To1_14_3;
import com.viaversion.viaversion.protocols.v1_14_3to1_14_4.Protocol1_14_3To1_14_4;
import com.viaversion.viaversion.protocols.v1_14_4to1_15.Protocol1_14_4To1_15;
import com.viaversion.viaversion.protocols.v1_14to1_14_1.Protocol1_14To1_14_1;
import com.viaversion.viaversion.protocols.v1_15_1to1_15_2.Protocol1_15_1To1_15_2;
import com.viaversion.viaversion.protocols.v1_15_2to1_16.Protocol1_15_2To1_16;
import com.viaversion.viaversion.protocols.v1_15to1_15_1.Protocol1_15To1_15_1;
import com.viaversion.viaversion.protocols.v1_16_1to1_16_2.Protocol1_16_1To1_16_2;
import com.viaversion.viaversion.protocols.v1_16_2to1_16_3.Protocol1_16_2To1_16_3;
import com.viaversion.viaversion.protocols.v1_16_3to1_16_4.Protocol1_16_3To1_16_4;
import com.viaversion.viaversion.protocols.v1_16_4to1_17.Protocol1_16_4To1_17;
import com.viaversion.viaversion.protocols.v1_16to1_16_1.Protocol1_16To1_16_1;
import com.viaversion.viaversion.protocols.v1_17_1to1_18.Protocol1_17_1To1_18;
import com.viaversion.viaversion.protocols.v1_17to1_17_1.Protocol1_17To1_17_1;
import com.viaversion.viaversion.protocols.v1_18_2to1_19.Protocol1_18_2To1_19;
import com.viaversion.viaversion.protocols.v1_18to1_18_2.Protocol1_18To1_18_2;
import com.viaversion.viaversion.protocols.v1_19_1to1_19_3.Protocol1_19_1To1_19_3;
import com.viaversion.viaversion.protocols.v1_19_3to1_19_4.Protocol1_19_3To1_19_4;
import com.viaversion.viaversion.protocols.v1_19_4to1_20.Protocol1_19_4To1_20;
import com.viaversion.viaversion.protocols.v1_19to1_19_1.Protocol1_19To1_19_1;
import com.viaversion.viaversion.protocols.v1_20_2to1_20_3.Protocol1_20_2To1_20_3;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.Protocol1_20_3To1_20_5;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.Protocol1_20_5To1_21;
import com.viaversion.viaversion.protocols.v1_20to1_20_2.Protocol1_20To1_20_2;
import com.viaversion.viaversion.protocols.v1_21_11to26_1.Protocol1_21_11To26_1;
import com.viaversion.viaversion.protocols.v1_21_2to1_21_4.Protocol1_21_2To1_21_4;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.Protocol1_21_4To1_21_5;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.Protocol1_21_5To1_21_6;
import com.viaversion.viaversion.protocols.v1_21_6to1_21_7.Protocol1_21_6To1_21_7;
import com.viaversion.viaversion.protocols.v1_21_7to1_21_9.Protocol1_21_7To1_21_9;
import com.viaversion.viaversion.protocols.v1_21_9to1_21_11.Protocol1_21_9To1_21_11;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.Protocol1_21To1_21_2;
import com.viaversion.viaversion.protocols.v1_8to1_9.Protocol1_8To1_9;
import com.viaversion.viaversion.protocols.v1_9_1to1_9_3.Protocol1_9_1To1_9_3;
import com.viaversion.viaversion.protocols.v1_9_3to1_10.Protocol1_9_3To1_10;
import com.viaversion.viaversion.protocols.v1_9to1_9_1.Protocol1_9To1_9_1;
import com.viaversion.viaversion.protocols.v26_1to26_2.Protocol26_1To26_2;
import com.viaversion.viaversion.util.MathUtil;
import com.viaversion.viaversion.util.Pair;
import io.netty.buffer.ByteBuf;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinWorkerThread;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Level;
import org.checkerframework.checker.nullness.qual.Nullable;

public class ProtocolManagerImpl
implements ProtocolManager {
    private static final Protocol BASE_PROTOCOL = new InitialBaseProtocol();
    private final Object2ObjectMap<ProtocolVersion, Object2ObjectMap<ProtocolVersion, Protocol>> registryMap = new Object2ObjectOpenHashMap<ProtocolVersion, Object2ObjectMap<ProtocolVersion, Protocol>>(32);
    private final Map<Class<? extends Protocol>, Protocol<?, ?, ?, ?>> protocols = new Reference2ObjectOpenHashMap(64);
    private final Map<ProtocolPathKey, List<ProtocolPathEntry>> pathCache = new ConcurrentHashMap<ProtocolPathKey, List<ProtocolPathEntry>>();
    private final Set<ProtocolVersion> supportedVersions = new HashSet<ProtocolVersion>();
    private final List<Pair<Range<ProtocolVersion>, Protocol>> serverboundBaseProtocols = Lists.newCopyOnWriteArrayList();
    private final List<Pair<Range<ProtocolVersion>, Protocol>> clientboundBaseProtocols = Lists.newCopyOnWriteArrayList();
    private final ReadWriteLock mappingLoaderLock = new ReentrantReadWriteLock();
    private Map<Class<? extends Protocol>, CompletableFuture<Void>> mappingLoaderFutures = new Reference2ObjectOpenHashMap<Class<? extends Protocol>, CompletableFuture<Void>>();
    private ExecutorService mappingLoaderExecutor;
    private boolean mappingsLoaded;
    private ServerProtocolVersion serverProtocolVersion = new ServerProtocolVersionSingleton(ProtocolVersion.unknown);
    private int maxPathDeltaIncrease;
    private int maxProtocolPathSize = 50;

    public ProtocolManagerImpl() {
        int n = MathUtil.clamp(Runtime.getRuntime().availableProcessors(), 2, 12);
        AtomicInteger atomicInteger = new AtomicInteger(0);
        this.mappingLoaderExecutor = new ForkJoinPool(n, forkJoinPool -> {
            ForkJoinWorkerThread forkJoinWorkerThread = ForkJoinPool.defaultForkJoinWorkerThreadFactory.newThread(forkJoinPool);
            forkJoinWorkerThread.setName("Via-Mappingloader-" + atomicInteger.incrementAndGet());
            return forkJoinWorkerThread;
        }, ForkJoinWorkerThread.getDefaultUncaughtExceptionHandler(), true);
        DefaultRegistrations.apply();
    }

    public void registerProtocols() {
        BASE_PROTOCOL.initialize();
        BASE_PROTOCOL.register(Via.getManager().getProviders());
        this.registerBaseProtocol(Direction.CLIENTBOUND, new ClientboundBaseProtocol1_7(), Range.closedOpen(ProtocolVersion.v1_7_2, ProtocolVersion.v1_16));
        this.registerBaseProtocol(Direction.CLIENTBOUND, new ClientboundBaseProtocol1_16(), Range.atLeast(ProtocolVersion.v1_16));
        this.registerBaseProtocol(Direction.SERVERBOUND, new ServerboundBaseProtocol1_7(), Range.atLeast(ProtocolVersion.v1_7_2));
        this.registerProtocol((Protocol)new Protocol1_8To1_9(), ProtocolVersion.v1_9, ProtocolVersion.v1_8);
        this.registerProtocol((Protocol)new Protocol1_9To1_9_1(), Arrays.asList(ProtocolVersion.v1_9_1, ProtocolVersion.v1_9_2), ProtocolVersion.v1_9);
        this.registerProtocol((Protocol)new Protocol1_9_1To1_9_3(), ProtocolVersion.v1_9_3, ProtocolVersion.v1_9_2);
        this.registerProtocol((Protocol)new Protocol1_9_3To1_10(), ProtocolVersion.v1_10, ProtocolVersion.v1_9_3);
        this.registerProtocol((Protocol)new Protocol1_10To1_11(), ProtocolVersion.v1_11, ProtocolVersion.v1_10);
        this.registerProtocol((Protocol)new Protocol1_11To1_11_1(), ProtocolVersion.v1_11_1, ProtocolVersion.v1_11);
        this.registerProtocol((Protocol)new Protocol1_11_1To1_12(), ProtocolVersion.v1_12, ProtocolVersion.v1_11_1);
        this.registerProtocol((Protocol)new Protocol1_12To1_12_1(), ProtocolVersion.v1_12_1, ProtocolVersion.v1_12);
        this.registerProtocol((Protocol)new Protocol1_12_1To1_12_2(), ProtocolVersion.v1_12_2, ProtocolVersion.v1_12_1);
        this.registerProtocol((Protocol)new Protocol1_12_2To1_13(), ProtocolVersion.v1_13, ProtocolVersion.v1_12_2);
        this.registerProtocol((Protocol)new Protocol1_13To1_13_1(), ProtocolVersion.v1_13_1, ProtocolVersion.v1_13);
        this.registerProtocol((Protocol)new Protocol1_13_1To1_13_2(), ProtocolVersion.v1_13_2, ProtocolVersion.v1_13_1);
        this.registerProtocol((Protocol)new Protocol1_13_2To1_14(), ProtocolVersion.v1_14, ProtocolVersion.v1_13_2);
        this.registerProtocol((Protocol)new Protocol1_14To1_14_1(), ProtocolVersion.v1_14_1, ProtocolVersion.v1_14);
        this.registerProtocol((Protocol)new Protocol1_14_1To1_14_2(), ProtocolVersion.v1_14_2, ProtocolVersion.v1_14_1);
        this.registerProtocol((Protocol)new Protocol1_14_2To1_14_3(), ProtocolVersion.v1_14_3, ProtocolVersion.v1_14_2);
        this.registerProtocol((Protocol)new Protocol1_14_3To1_14_4(), ProtocolVersion.v1_14_4, ProtocolVersion.v1_14_3);
        this.registerProtocol((Protocol)new Protocol1_14_4To1_15(), ProtocolVersion.v1_15, ProtocolVersion.v1_14_4);
        this.registerProtocol((Protocol)new Protocol1_15To1_15_1(), ProtocolVersion.v1_15_1, ProtocolVersion.v1_15);
        this.registerProtocol((Protocol)new Protocol1_15_1To1_15_2(), ProtocolVersion.v1_15_2, ProtocolVersion.v1_15_1);
        this.registerProtocol((Protocol)new Protocol1_15_2To1_16(), ProtocolVersion.v1_16, ProtocolVersion.v1_15_2);
        this.registerProtocol((Protocol)new Protocol1_16To1_16_1(), ProtocolVersion.v1_16_1, ProtocolVersion.v1_16);
        this.registerProtocol((Protocol)new Protocol1_16_1To1_16_2(), ProtocolVersion.v1_16_2, ProtocolVersion.v1_16_1);
        this.registerProtocol((Protocol)new Protocol1_16_2To1_16_3(), ProtocolVersion.v1_16_3, ProtocolVersion.v1_16_2);
        this.registerProtocol((Protocol)new Protocol1_16_3To1_16_4(), ProtocolVersion.v1_16_4, ProtocolVersion.v1_16_3);
        this.registerProtocol((Protocol)new Protocol1_16_4To1_17(), ProtocolVersion.v1_17, ProtocolVersion.v1_16_4);
        this.registerProtocol((Protocol)new Protocol1_17To1_17_1(), ProtocolVersion.v1_17_1, ProtocolVersion.v1_17);
        this.registerProtocol((Protocol)new Protocol1_17_1To1_18(), ProtocolVersion.v1_18, ProtocolVersion.v1_17_1);
        this.registerProtocol((Protocol)new Protocol1_18To1_18_2(), ProtocolVersion.v1_18_2, ProtocolVersion.v1_18);
        this.registerProtocol((Protocol)new Protocol1_18_2To1_19(), ProtocolVersion.v1_19, ProtocolVersion.v1_18_2);
        this.registerProtocol((Protocol)new Protocol1_19To1_19_1(), ProtocolVersion.v1_19_1, ProtocolVersion.v1_19);
        this.registerProtocol((Protocol)new Protocol1_19_1To1_19_3(), ProtocolVersion.v1_19_3, ProtocolVersion.v1_19_1);
        this.registerProtocol((Protocol)new Protocol1_19_3To1_19_4(), ProtocolVersion.v1_19_4, ProtocolVersion.v1_19_3);
        this.registerProtocol((Protocol)new Protocol1_19_4To1_20(), ProtocolVersion.v1_20, ProtocolVersion.v1_19_4);
        this.registerProtocol((Protocol)new Protocol1_20To1_20_2(), ProtocolVersion.v1_20_2, ProtocolVersion.v1_20);
        this.registerProtocol((Protocol)new Protocol1_20_2To1_20_3(), ProtocolVersion.v1_20_3, ProtocolVersion.v1_20_2);
        this.registerProtocol((Protocol)new Protocol1_20_3To1_20_5(), ProtocolVersion.v1_20_5, ProtocolVersion.v1_20_3);
        this.registerProtocol((Protocol)new Protocol1_20_5To1_21(), ProtocolVersion.v1_21, ProtocolVersion.v1_20_5);
        this.registerProtocol((Protocol)new Protocol1_21To1_21_2(), ProtocolVersion.v1_21_2, ProtocolVersion.v1_21);
        this.registerProtocol((Protocol)new Protocol1_21_2To1_21_4(), ProtocolVersion.v1_21_4, ProtocolVersion.v1_21_2);
        this.registerProtocol((Protocol)new Protocol1_21_4To1_21_5(), ProtocolVersion.v1_21_5, ProtocolVersion.v1_21_4);
        this.registerProtocol((Protocol)new Protocol1_21_5To1_21_6(), ProtocolVersion.v1_21_6, ProtocolVersion.v1_21_5);
        this.registerProtocol((Protocol)new Protocol1_21_6To1_21_7(), ProtocolVersion.v1_21_7, ProtocolVersion.v1_21_6);
        this.registerProtocol((Protocol)new Protocol1_21_7To1_21_9(), ProtocolVersion.v1_21_9, ProtocolVersion.v1_21_7);
        this.registerProtocol((Protocol)new Protocol1_21_9To1_21_11(), ProtocolVersion.v1_21_11, ProtocolVersion.v1_21_9);
        this.registerProtocol((Protocol)new Protocol1_21_11To26_1(), ProtocolVersion.v26_1, ProtocolVersion.v1_21_11);
        this.registerProtocol((Protocol)new Protocol26_1To26_2(), ProtocolVersion.v26_2, ProtocolVersion.v26_1);
    }

    @Override
    public void registerProtocol(Protocol protocol, ProtocolVersion protocolVersion, ProtocolVersion protocolVersion2) {
        this.registerProtocol(protocol, Collections.singletonList(protocolVersion), protocolVersion2);
    }

    @Override
    public void registerProtocol(Protocol protocol, List<ProtocolVersion> list, ProtocolVersion protocolVersion) {
        if (protocol instanceof AbstractProtocol) {
            AbstractProtocol abstractProtocol = (AbstractProtocol)protocol;
            abstractProtocol.setServerVersion(protocolVersion);
            abstractProtocol.setClientVersion((ProtocolVersion)list.stream().max(ProtocolVersion::compareTo).orElseThrow());
        }
        if (!this.pathCache.isEmpty()) {
            this.pathCache.clear();
        }
        this.protocols.put(protocol.getClass(), protocol);
        for (ProtocolVersion protocolVersion2 : list) {
            Preconditions.checkArgument(!protocolVersion2.equals(protocolVersion));
            Object2ObjectMap object2ObjectMap = this.registryMap.computeIfAbsent(protocolVersion2, object -> new Object2ObjectOpenHashMap(2));
            object2ObjectMap.put(protocolVersion, protocol);
        }
        protocol.register(Via.getManager().getProviders());
        if (Via.getManager().isInitialized()) {
            this.refreshVersions();
        }
        if (!protocol.hasMappingDataToLoad()) {
            protocol.initialize();
            return;
        }
        if (this.mappingLoaderExecutor != null) {
            if (protocol.dependsOn() != null) {
                this.addMappingLoaderFuture(protocol.getClass(), protocol.dependsOn(), protocol::loadMappingData);
            } else {
                this.addMappingLoaderFuture(protocol.getClass(), protocol::loadMappingData);
            }
        } else {
            protocol.loadMappingData();
        }
    }

    @Override
    public void registerBaseProtocol(Direction direction, Protocol protocol, Range<ProtocolVersion> range) {
        Preconditions.checkArgument(protocol.isBaseProtocol(), "Protocol is not a base protocol");
        ProtocolVersion protocolVersion = range.hasLowerBound() ? range.lowerEndpoint() : null;
        ProtocolVersion protocolVersion2 = range.hasUpperBound() ? range.upperEndpoint() : null;
        Preconditions.checkArgument(protocolVersion == null || protocolVersion.getVersionType() != VersionType.SPECIAL, "Base protocol versions cannot contain a special version");
        Preconditions.checkArgument(protocolVersion2 == null || protocolVersion2.getVersionType() != VersionType.SPECIAL, "Base protocol versions cannot contain a special version");
        protocol.initialize();
        if (direction == Direction.SERVERBOUND) {
            this.serverboundBaseProtocols.add(new Pair<Range<ProtocolVersion>, Protocol>(range, protocol));
        } else {
            this.clientboundBaseProtocols.add(new Pair<Range<ProtocolVersion>, Protocol>(range, protocol));
        }
        protocol.register(Via.getManager().getProviders());
        if (Via.getManager().isInitialized()) {
            this.refreshVersions();
        }
    }

    public void refreshVersions() {
        this.supportedVersions.clear();
        this.supportedVersions.add(this.serverProtocolVersion.lowestSupportedProtocolVersion());
        for (ProtocolVersion protocolVersion : ProtocolVersion.getProtocols()) {
            List<ProtocolPathEntry> list = this.getProtocolPath(protocolVersion, this.serverProtocolVersion.lowestSupportedProtocolVersion());
            if (list == null) continue;
            this.supportedVersions.add(protocolVersion);
            for (ProtocolPathEntry protocolPathEntry : list) {
                this.supportedVersions.add(protocolPathEntry.outputProtocolVersion());
            }
        }
    }

    @Override
    public @Nullable List<ProtocolPathEntry> getProtocolPath(ProtocolVersion protocolVersion, ProtocolVersion protocolVersion2) {
        if (protocolVersion == protocolVersion2) {
            return null;
        }
        ProtocolPathKeyImpl protocolPathKeyImpl = new ProtocolPathKeyImpl(protocolVersion, protocolVersion2);
        List<ProtocolPathEntry> list = this.pathCache.get(protocolPathKeyImpl);
        if (list != null) {
            return list.isEmpty() ? null : list;
        }
        List<ProtocolPathEntry> list2 = this.calculateProtocolPath(protocolVersion, protocolVersion2);
        if (list2 == null) {
            this.pathCache.put(protocolPathKeyImpl, List.of());
            return null;
        }
        this.pathCache.put(protocolPathKeyImpl, list2);
        return list2;
    }

    @Override
    public <C extends ClientboundPacketType, S extends ServerboundPacketType> VersionedPacketTransformer<C, S> createPacketTransformer(ProtocolVersion protocolVersion, @Nullable Class<C> clazz, @Nullable Class<S> clazz2) {
        Preconditions.checkArgument(clazz != ClientboundPacketType.class && clazz2 != ServerboundPacketType.class);
        return new VersionedPacketTransformerImpl<C, S>(protocolVersion, clazz, clazz2);
    }

    private @Nullable List<ProtocolPathEntry> calculateProtocolPath(ProtocolVersion protocolVersion, ProtocolVersion protocolVersion2) {
        PathNode pathNode;
        HashSet<ProtocolVersion> hashSet = new HashSet<ProtocolVersion>();
        hashSet.add(protocolVersion);
        ArrayDeque<PathNode> arrayDeque = new ArrayDeque<PathNode>();
        arrayDeque.add(new PathNode(null, protocolVersion, null, 0));
        while ((pathNode = (PathNode)arrayDeque.poll()) != null) {
            Object2ObjectMap object2ObjectMap;
            if (pathNode.depth() > this.maxProtocolPathSize || (object2ObjectMap = (Object2ObjectMap)this.registryMap.get(pathNode.version())) == null) continue;
            Protocol protocol = (Protocol)object2ObjectMap.get(protocolVersion2);
            if (protocol != null) {
                return this.reconstructPath(new PathNode(pathNode, protocolVersion2, protocol, pathNode.depth() + 1));
            }
            for (Map.Entry entry : object2ObjectMap.entrySet()) {
                int n;
                ProtocolVersion protocolVersion3 = (ProtocolVersion)entry.getKey();
                if (hashSet.contains(protocolVersion3) || this.maxPathDeltaIncrease != -1 && protocolVersion3.getVersionType() == pathNode.version().getVersionType() && (n = Math.abs(protocolVersion2.getVersion() - protocolVersion3.getVersion()) - Math.abs(protocolVersion2.getVersion() - pathNode.version().getVersion())) > this.maxPathDeltaIncrease) continue;
                hashSet.add(protocolVersion3);
                arrayDeque.add(new PathNode(pathNode, protocolVersion3, (Protocol)entry.getValue(), pathNode.depth() + 1));
            }
        }
        return null;
    }

    private List<ProtocolPathEntry> reconstructPath(PathNode pathNode) {
        ProtocolPathEntry[] protocolPathEntryArray = new ProtocolPathEntry[pathNode.depth()];
        PathNode pathNode2 = pathNode;
        while (pathNode2.protocol() != null) {
            protocolPathEntryArray[pathNode2.depth() - 1] = new ProtocolPathEntryImpl(pathNode2.version(), pathNode2.protocol());
            pathNode2 = pathNode2.parent();
        }
        return List.of(protocolPathEntryArray);
    }

    @Override
    public <T extends Protocol> @Nullable T getProtocol(Class<T> clazz) {
        return (T)this.protocols.get(clazz);
    }

    @Override
    public @Nullable Protocol getProtocol(ProtocolVersion protocolVersion, ProtocolVersion protocolVersion2) {
        Object2ObjectMap object2ObjectMap = (Object2ObjectMap)this.registryMap.get(protocolVersion);
        return object2ObjectMap != null ? (Protocol)object2ObjectMap.get(protocolVersion2) : null;
    }

    @Override
    public List<Protocol> getBaseProtocols(@Nullable ProtocolVersion protocolVersion, @Nullable ProtocolVersion protocolVersion2) {
        ArrayList<Protocol> arrayList = new ArrayList<Protocol>();
        if (protocolVersion != null) {
            for (Pair<Range<ProtocolVersion>, Protocol> pair : this.serverboundBaseProtocols) {
                if (!pair.key().contains(protocolVersion)) continue;
                arrayList.add(pair.value());
            }
        }
        if (protocolVersion2 != null) {
            for (Pair<Range<ProtocolVersion>, Protocol> pair : this.clientboundBaseProtocols) {
                if (!pair.key().contains(protocolVersion2)) continue;
                arrayList.add(pair.value());
            }
        }
        return arrayList;
    }

    @Override
    public Collection<Protocol<?, ?, ?, ?>> getProtocols() {
        return Collections.unmodifiableCollection(this.protocols.values());
    }

    @Override
    public ServerProtocolVersion getServerProtocolVersion() {
        return this.serverProtocolVersion;
    }

    public void setServerProtocol(ServerProtocolVersion serverProtocolVersion) {
        this.serverProtocolVersion = serverProtocolVersion;
    }

    @Override
    public boolean isWorkingPipe() {
        for (Object2ObjectMap object2ObjectMap : this.registryMap.values()) {
            for (ProtocolVersion protocolVersion : this.serverProtocolVersion.supportedProtocolVersions()) {
                if (!object2ObjectMap.containsKey(protocolVersion)) continue;
                return true;
            }
        }
        return false;
    }

    @Override
    public SortedSet<ProtocolVersion> getSupportedVersions() {
        return Collections.unmodifiableSortedSet(new TreeSet<ProtocolVersion>(this.supportedVersions));
    }

    @Override
    public void setMaxPathDeltaIncrease(int n) {
        this.maxPathDeltaIncrease = Math.max(-1, n);
    }

    @Override
    public int getMaxPathDeltaIncrease() {
        return this.maxPathDeltaIncrease;
    }

    @Override
    public int getMaxProtocolPathSize() {
        return this.maxProtocolPathSize;
    }

    @Override
    public void setMaxProtocolPathSize(int n) {
        this.maxProtocolPathSize = n;
    }

    @Override
    public Protocol getBaseProtocol() {
        return BASE_PROTOCOL;
    }

    @Override
    public void completeMappingDataLoading(Class<? extends Protocol> clazz) {
        if (this.mappingsLoaded) {
            return;
        }
        CompletableFuture<Void> completableFuture = this.getMappingLoaderFuture(clazz);
        if (completableFuture != null) {
            completableFuture.join();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean checkForMappingCompletion(boolean bl) {
        this.mappingLoaderLock.readLock().lock();
        try {
            if (this.mappingsLoaded) {
                boolean bl2 = false;
                return bl2;
            }
            for (CompletableFuture<Void> completableFuture : this.mappingLoaderFutures.values()) {
                if (!completableFuture.isDone()) {
                    boolean bl3 = false;
                    return bl3;
                }
                if (!bl) continue;
                completableFuture.join();
            }
            this.shutdownLoaderExecutor();
            boolean bl4 = true;
            return bl4;
        }
        finally {
            this.mappingLoaderLock.readLock().unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void addMappingLoaderFuture(Class<? extends Protocol> clazz, Runnable runnable2) {
        CompletionStage completionStage = CompletableFuture.runAsync(runnable2, this.mappingLoaderExecutor).whenComplete((void_, throwable) -> this.logIfErrored(clazz, (Throwable)throwable));
        this.mappingLoaderLock.writeLock().lock();
        try {
            this.mappingLoaderFutures.put(clazz, (CompletableFuture<Void>)completionStage);
        }
        finally {
            this.mappingLoaderLock.writeLock().unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void addMappingLoaderFuture(Class<? extends Protocol> clazz, Class<? extends Protocol> clazz2, Runnable runnable2) {
        CompletionStage completionStage = ((CompletableFuture)this.getMappingLoaderFuture(clazz2).thenRunAsync(runnable2, this.mappingLoaderExecutor)).whenComplete((void_, throwable) -> this.logIfErrored(clazz, (Throwable)throwable));
        this.mappingLoaderLock.writeLock().lock();
        try {
            this.mappingLoaderFutures.put(clazz, (CompletableFuture<Void>)completionStage);
        }
        finally {
            this.mappingLoaderLock.writeLock().unlock();
        }
    }

    @Override
    public @Nullable CompletableFuture<Void> getMappingLoaderFuture(Class<? extends Protocol> clazz) {
        this.mappingLoaderLock.readLock().lock();
        try {
            CompletableFuture<Void> completableFuture = this.mappingsLoaded ? null : this.mappingLoaderFutures.get(clazz);
            return completableFuture;
        }
        finally {
            this.mappingLoaderLock.readLock().unlock();
        }
    }

    @Override
    public PacketWrapper createPacketWrapper(@Nullable PacketType packetType, @Nullable ByteBuf byteBuf, UserConnection userConnection) {
        return new PacketWrapperImpl(packetType, byteBuf, userConnection);
    }

    @Override
    @Deprecated
    public PacketWrapper createPacketWrapper(int n, @Nullable ByteBuf byteBuf, UserConnection userConnection) {
        return new PacketWrapperImpl(n, byteBuf, userConnection);
    }

    @Override
    public boolean hasLoadedMappings() {
        return this.mappingsLoaded;
    }

    public void shutdownLoaderExecutor() {
        Preconditions.checkArgument(!this.mappingsLoaded);
        Via.getPlatform().getLogger().info("Finished mapping loading, shutting down loader executor.");
        this.mappingsLoaded = true;
        this.mappingLoaderExecutor.shutdown();
        this.mappingLoaderExecutor = null;
        this.mappingLoaderFutures.clear();
        this.mappingLoaderFutures = null;
        MappingDataLoader.INSTANCE.clearCache();
    }

    private void logIfErrored(Class<? extends Protocol> clazz, @Nullable Throwable throwable) {
        if (throwable != null) {
            Via.getPlatform().getLogger().log(Level.SEVERE, "Error during loading of " + clazz.getSimpleName(), throwable);
        }
    }

    private record PathNode(@Nullable PathNode parent, ProtocolVersion version, @Nullable Protocol protocol, int depth) {
    }
}

