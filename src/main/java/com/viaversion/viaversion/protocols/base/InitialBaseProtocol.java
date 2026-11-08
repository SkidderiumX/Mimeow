/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.base;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.ProtocolInfo;
import com.viaversion.viaversion.api.platform.providers.ViaProviders;
import com.viaversion.viaversion.api.protocol.AbstractProtocol;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.protocol.ProtocolManager;
import com.viaversion.viaversion.api.protocol.ProtocolPathEntry;
import com.viaversion.viaversion.api.protocol.ProtocolPipeline;
import com.viaversion.viaversion.api.protocol.packet.Direction;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.packet.State;
import com.viaversion.viaversion.api.protocol.packet.provider.PacketTypesProvider;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import com.viaversion.viaversion.api.protocol.version.VersionProvider;
import com.viaversion.viaversion.api.protocol.version.VersionType;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.exception.CancelException;
import com.viaversion.viaversion.exception.InformativeException;
import com.viaversion.viaversion.protocol.SpecialProtocolVersion;
import com.viaversion.viaversion.protocol.version.BaseVersionProvider;
import com.viaversion.viaversion.protocols.base.ServerboundHandshakePackets;
import com.viaversion.viaversion.protocols.base.packet.BaseClientboundPacket;
import com.viaversion.viaversion.protocols.base.packet.BasePacketTypesProvider;
import com.viaversion.viaversion.protocols.base.packet.BaseServerboundPacket;
import java.util.ArrayList;
import java.util.List;

public class InitialBaseProtocol
extends AbstractProtocol<BaseClientboundPacket, BaseClientboundPacket, BaseServerboundPacket, BaseServerboundPacket> {
    private static final int STATUS_INTENT = 1;
    private static final int LOGIN_INTENT = 2;
    private static final int TRANSFER_INTENT = 3;

    public InitialBaseProtocol() {
        super(BaseClientboundPacket.class, BaseClientboundPacket.class, BaseServerboundPacket.class, BaseServerboundPacket.class);
    }

    @Override
    protected void registerPackets() {
        this.registerServerbound(ServerboundHandshakePackets.CLIENT_INTENTION, packetWrapper -> {
            ArrayList<Object> arrayList;
            ProtocolVersion protocolVersion;
            int n = packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.STRING);
            packetWrapper.passthrough(Types.UNSIGNED_SHORT);
            int n2 = packetWrapper.passthrough(Types.VAR_INT);
            VersionProvider versionProvider = Via.getManager().getProviders().get(VersionProvider.class);
            if (versionProvider == null) {
                packetWrapper.user().setActive(false);
                return;
            }
            ProtocolInfo protocolInfo = packetWrapper.user().getProtocolInfo();
            protocolInfo.setProtocolVersion(ProtocolVersion.getProtocol(n));
            ProtocolVersion protocolVersion2 = versionProvider.getClientProtocol(packetWrapper.user());
            if (protocolVersion2 != null) {
                protocolInfo.setProtocolVersion(protocolVersion2);
            }
            try {
                protocolVersion = versionProvider.getClosestServerProtocol(packetWrapper.user());
            }
            catch (Exception exception) {
                throw new RuntimeException("Error getting server protocol", exception);
            }
            protocolInfo.setServerProtocolVersion(protocolVersion);
            ProtocolManager protocolManager = Via.getManager().getProtocolManager();
            List<ProtocolPathEntry> list = protocolManager.getProtocolPath(protocolInfo.protocolVersion(), protocolVersion);
            ProtocolPipeline protocolPipeline = protocolInfo.getPipeline();
            ArrayList<Protocol> arrayList2 = new ArrayList<Protocol>(protocolPipeline.pipes());
            ProtocolVersion protocolVersion3 = null;
            if (protocolVersion.getVersionType() != VersionType.SPECIAL) {
                protocolVersion3 = protocolVersion;
            } else if (protocolVersion instanceof SpecialProtocolVersion) {
                arrayList = (SpecialProtocolVersion)protocolVersion;
                protocolVersion3 = ((SpecialProtocolVersion)((Object)arrayList)).getBaseProtocolVersion();
            }
            for (Protocol object : protocolManager.getBaseProtocols(protocolInfo.protocolVersion(), protocolVersion3)) {
                protocolPipeline.add(object);
            }
            if (list != null) {
                arrayList = new ArrayList(list.size());
                for (ProtocolPathEntry protocolPathEntry : list) {
                    arrayList.add(protocolPathEntry.protocol());
                    protocolManager.completeMappingDataLoading(protocolPathEntry.protocol().getClass());
                }
                protocolPipeline.add(arrayList);
                packetWrapper.set(Types.VAR_INT, 0, protocolVersion.getOriginalVersion());
            }
            if (n2 == 3 && protocolVersion.olderThan(ProtocolVersion.v1_20_5)) {
                packetWrapper.set(Types.VAR_INT, 1, 2);
            }
            try {
                arrayList = new ArrayList<Protocol>(protocolPipeline.pipes());
                arrayList.removeAll(arrayList2);
                packetWrapper.resetReader();
                packetWrapper.apply(Direction.SERVERBOUND, State.HANDSHAKE, arrayList);
            }
            catch (CancelException cancelException) {
                packetWrapper.cancel();
            }
            if (Via.getManager().isDebug()) {
                Via.getPlatform().getLogger().info("User connected with protocol: " + String.valueOf(protocolInfo.protocolVersion()) + " and serverProtocol: " + String.valueOf(protocolInfo.serverProtocolVersion()));
                Via.getPlatform().getLogger().info("Protocol pipeline: " + String.valueOf(protocolPipeline.pipes()));
            }
            if (n2 == 1) {
                protocolInfo.setState(State.STATUS);
            } else if (n2 == 2 || n2 == 3) {
                protocolInfo.setState(State.LOGIN);
            }
        });
    }

    @Override
    public boolean isBaseProtocol() {
        return true;
    }

    @Override
    public void register(ViaProviders viaProviders) {
        viaProviders.register(VersionProvider.class, new BaseVersionProvider());
    }

    @Override
    public void transform(Direction direction, State state, PacketWrapper packetWrapper) throws InformativeException, CancelException {
        super.transform(direction, state, packetWrapper);
        if (direction == Direction.SERVERBOUND && state == State.HANDSHAKE && packetWrapper.getId() != 0) {
            packetWrapper.user().setActive(false);
        }
    }

    @Override
    protected PacketTypesProvider<BaseClientboundPacket, BaseClientboundPacket, BaseServerboundPacket, BaseServerboundPacket> createPacketTypesProvider() {
        return BasePacketTypesProvider.INSTANCE;
    }
}

