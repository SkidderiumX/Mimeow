/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocol;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.ProtocolInfo;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.debug.DebugHandler;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.protocol.ProtocolPipeline;
import com.viaversion.viaversion.api.protocol.packet.Direction;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.packet.State;
import com.viaversion.viaversion.exception.CancelException;
import com.viaversion.viaversion.exception.InformativeException;
import com.viaversion.viaversion.util.ProtocolUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.logging.Level;
import org.checkerframework.checker.nullness.qual.Nullable;

public class ProtocolPipelineImpl
implements ProtocolPipeline {
    private final List<Protocol> protocolList = new ArrayList<Protocol>();
    private final Set<Class<? extends Protocol>> protocolSet = new HashSet<Class<? extends Protocol>>();
    private final UserConnection userConnection;
    private List<Protocol> reversedProtocolList = new ArrayList<Protocol>();
    private int baseProtocols;

    public ProtocolPipelineImpl(UserConnection userConnection) {
        this.userConnection = userConnection;
        userConnection.getProtocolInfo().setPipeline(this);
        this.add(Via.getManager().getProtocolManager().getBaseProtocol());
    }

    @Override
    public void add(Protocol protocol) {
        this.reversedProtocolList.add(this.baseProtocols, protocol);
        if (protocol.isBaseProtocol()) {
            this.protocolList.add(this.baseProtocols, protocol);
            ++this.baseProtocols;
        } else {
            this.protocolList.add(protocol);
        }
        this.protocolSet.add(protocol.getClass());
        protocol.init(this.userConnection);
    }

    @Override
    public void add(Collection<Protocol> collection) {
        for (Protocol protocol : collection) {
            if (protocol.isBaseProtocol()) {
                throw new UnsupportedOperationException("Base protocols cannot be added in bulk");
            }
            protocol.init(this.userConnection);
            this.protocolSet.add(protocol.getClass());
        }
        this.protocolList.addAll(collection);
        this.refreshReversedList();
    }

    private void refreshReversedList() {
        int n;
        ArrayList<Protocol> arrayList = new ArrayList<Protocol>(this.protocolList.size());
        for (n = 0; n < this.baseProtocols; ++n) {
            arrayList.add(this.protocolList.get(n));
        }
        for (n = this.protocolList.size() - 1; n >= this.baseProtocols; --n) {
            arrayList.add(this.protocolList.get(n));
        }
        this.reversedProtocolList = arrayList;
    }

    @Override
    public void transform(Direction direction, State state, PacketWrapper packetWrapper) throws InformativeException, CancelException {
        int n = packetWrapper.getId();
        DebugHandler debugHandler = Via.getManager().debugHandler();
        boolean bl = debugHandler.enabled();
        if (bl && debugHandler.logPrePacketTransform() && debugHandler.shouldLog(packetWrapper, direction)) {
            this.logPacket(direction, state, packetWrapper, n, false);
        }
        packetWrapper.apply(direction, state, this.protocolListFor(direction));
        if (bl && debugHandler.logPostPacketTransform() && debugHandler.shouldLog(packetWrapper, direction)) {
            this.logPacket(direction, state, packetWrapper, n, true);
        }
    }

    private List<Protocol> protocolListFor(Direction direction) {
        return direction == Direction.SERVERBOUND ? this.protocolList : this.reversedProtocolList;
    }

    private void logPacket(Direction direction, State state, PacketWrapper packetWrapper, int n, boolean bl) {
        String string = bl ? "POST" : "PRE ";
        ProtocolInfo protocolInfo = this.userConnection.getProtocolInfo();
        String string2 = protocolInfo.getUsername();
        Object object = string2 != null ? string2 + " " : "";
        Via.getPlatform().getLogger().log(Level.INFO, "{0}: {1}{2} {3}: {4} ({5}) -> {6} ({7}) [{8}] {9}", new Object[]{string, object, direction, state, n, ProtocolUtil.toNiceHex(n), packetWrapper.getId(), ProtocolUtil.toNiceHex(packetWrapper.getId()), protocolInfo.protocolVersion().getName(), packetWrapper});
    }

    @Override
    public boolean contains(Class<? extends Protocol> clazz) {
        return this.protocolSet.contains(clazz);
    }

    @Override
    public <P extends Protocol> @Nullable P getProtocol(Class<P> clazz) {
        for (Protocol protocol : this.protocolList) {
            if (protocol.getClass() != clazz) continue;
            return (P)protocol;
        }
        return null;
    }

    @Override
    public List<Protocol> pipes(@Nullable Class<? extends Protocol> clazz, boolean bl, Direction direction) {
        int n;
        List<Protocol> list = this.protocolListFor(direction);
        int n2 = this.indexOf(clazz, bl, list);
        ArrayList<Protocol> arrayList = new ArrayList<Protocol>(this.baseProtocols + list.size() - n2);
        int n3 = Math.min(n2, this.baseProtocols);
        for (n = 0; n < n3; ++n) {
            arrayList.add(list.get(n));
        }
        n3 = list.size();
        for (n = n2; n < n3; ++n) {
            arrayList.add(list.get(n));
        }
        return arrayList;
    }

    private int indexOf(@Nullable Class<? extends Protocol> clazz, boolean bl, List<Protocol> list) {
        if (clazz == null) {
            return 0;
        }
        int n = -1;
        for (int i = 0; i < list.size(); ++i) {
            if (list.get(i).getClass() != clazz) continue;
            n = i;
            break;
        }
        if (n == -1) {
            throw new NoSuchElementException(clazz.getCanonicalName());
        }
        if (bl) {
            n = Math.min(n + 1, list.size());
        }
        return n;
    }

    @Override
    public List<Protocol> pipes() {
        return Collections.unmodifiableList(this.protocolList);
    }

    @Override
    public List<Protocol> reversedPipes() {
        return Collections.unmodifiableList(this.reversedProtocolList);
    }

    @Override
    public int baseProtocolCount() {
        return this.baseProtocols;
    }

    @Override
    public boolean hasNonBaseProtocols() {
        return this.protocolList.size() > this.baseProtocols;
    }

    @Override
    public void cleanPipes() {
        this.protocolList.clear();
        this.reversedProtocolList.clear();
        this.protocolSet.clear();
        this.baseProtocols = 0;
        this.add(Via.getManager().getProtocolManager().getBaseProtocol());
    }

    public String toString() {
        return "ProtocolPipelineImpl{protocolList=" + String.valueOf(this.protocolList) + "}";
    }
}

