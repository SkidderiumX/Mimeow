/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocol.packet;

import com.google.common.base.Preconditions;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.protocol.ProtocolPathEntry;
import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.api.protocol.packet.Direction;
import com.viaversion.viaversion.api.protocol.packet.PacketType;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.packet.ServerboundPacketType;
import com.viaversion.viaversion.api.protocol.packet.VersionedPacketTransformer;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import com.viaversion.viaversion.exception.CancelException;
import com.viaversion.viaversion.exception.InformativeException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.checkerframework.checker.nullness.qual.Nullable;

public class VersionedPacketTransformerImpl<C extends ClientboundPacketType, S extends ServerboundPacketType>
implements VersionedPacketTransformer<C, S> {
    private final ProtocolVersion inputProtocolVersion;
    private final Class<C> clientboundPacketsClass;
    private final Class<S> serverboundPacketsClass;

    public VersionedPacketTransformerImpl(ProtocolVersion protocolVersion, @Nullable Class<C> clazz, @Nullable Class<S> clazz2) {
        Preconditions.checkNotNull(protocolVersion);
        Preconditions.checkArgument(clazz != null || clazz2 != null, "Either the clientbound or serverbound packets class has to be non-null");
        this.inputProtocolVersion = protocolVersion;
        this.clientboundPacketsClass = clazz;
        this.serverboundPacketsClass = clazz2;
    }

    @Override
    public boolean send(PacketWrapper packetWrapper) throws InformativeException {
        this.validatePacket(packetWrapper);
        return this.transformAndSendPacket(packetWrapper, true);
    }

    @Override
    public boolean send(UserConnection userConnection, C c, Consumer<PacketWrapper> consumer) throws InformativeException {
        return this.createAndSend(userConnection, (PacketType)c, consumer);
    }

    @Override
    public boolean send(UserConnection userConnection, S s, Consumer<PacketWrapper> consumer) throws InformativeException {
        return this.createAndSend(userConnection, (PacketType)s, consumer);
    }

    @Override
    public boolean scheduleSend(PacketWrapper packetWrapper) throws InformativeException {
        this.validatePacket(packetWrapper);
        return this.transformAndSendPacket(packetWrapper, false);
    }

    @Override
    public boolean scheduleSend(UserConnection userConnection, C c, Consumer<PacketWrapper> consumer) throws InformativeException {
        return this.scheduleCreateAndSend(userConnection, (PacketType)c, consumer);
    }

    @Override
    public boolean scheduleSend(UserConnection userConnection, S s, Consumer<PacketWrapper> consumer) throws InformativeException {
        return this.scheduleCreateAndSend(userConnection, (PacketType)s, consumer);
    }

    @Override
    public @Nullable PacketWrapper transform(PacketWrapper packetWrapper) {
        this.validatePacket(packetWrapper);
        this.transformPacket(packetWrapper);
        return packetWrapper.isCancelled() ? null : packetWrapper;
    }

    @Override
    public @Nullable PacketWrapper transform(UserConnection userConnection, C c, Consumer<PacketWrapper> consumer) {
        return this.createAndTransform(userConnection, (PacketType)c, consumer);
    }

    @Override
    public @Nullable PacketWrapper transform(UserConnection userConnection, S s, Consumer<PacketWrapper> consumer) {
        return this.createAndTransform(userConnection, (PacketType)s, consumer);
    }

    private void validatePacket(PacketWrapper packetWrapper) {
        Class<Object> clazz;
        if (packetWrapper.user() == null) {
            throw new IllegalArgumentException("PacketWrapper does not have a targeted UserConnection");
        }
        if (packetWrapper.getPacketType() == null) {
            throw new IllegalArgumentException("PacketWrapper does not have a valid packet type");
        }
        Class<Object> clazz2 = clazz = packetWrapper.getPacketType().direction() == Direction.CLIENTBOUND ? this.clientboundPacketsClass : this.serverboundPacketsClass;
        if (packetWrapper.getPacketType().getClass() != clazz) {
            throw new IllegalArgumentException("PacketWrapper packet type is of the wrong packet class");
        }
    }

    private boolean transformAndSendPacket(PacketWrapper packetWrapper, boolean bl) throws InformativeException {
        this.transformPacket(packetWrapper);
        if (packetWrapper.isCancelled()) {
            return false;
        }
        if (bl) {
            if (packetWrapper.getPacketType().direction() == Direction.CLIENTBOUND) {
                packetWrapper.sendRaw();
            } else {
                packetWrapper.sendToServerRaw();
            }
        } else if (packetWrapper.getPacketType().direction() == Direction.CLIENTBOUND) {
            packetWrapper.scheduleSendRaw();
        } else {
            packetWrapper.scheduleSendToServerRaw();
        }
        return true;
    }

    private void transformPacket(PacketWrapper packetWrapper) {
        UserConnection userConnection = packetWrapper.user();
        PacketType packetType = packetWrapper.getPacketType();
        boolean bl = packetType.direction() == Direction.CLIENTBOUND;
        ProtocolVersion protocolVersion = bl ? this.inputProtocolVersion : userConnection.getProtocolInfo().serverProtocolVersion();
        ProtocolVersion protocolVersion2 = bl ? userConnection.getProtocolInfo().protocolVersion() : this.inputProtocolVersion;
        List<ProtocolPathEntry> list = Via.getManager().getProtocolManager().getProtocolPath(protocolVersion2, protocolVersion);
        if (list == null) {
            if (protocolVersion != protocolVersion2) {
                throw new RuntimeException("No protocol path between client version " + String.valueOf(protocolVersion2) + " and server version " + String.valueOf(protocolVersion));
            }
            return;
        }
        ArrayList<Protocol> arrayList = new ArrayList<Protocol>(list.size());
        if (bl) {
            for (int i = list.size() - 1; i >= 0; --i) {
                arrayList.add(list.get(i).protocol());
            }
        } else {
            for (ProtocolPathEntry protocolPathEntry : list) {
                arrayList.add(protocolPathEntry.protocol());
            }
        }
        packetWrapper.resetReader();
        try {
            packetWrapper.apply(packetType.direction(), packetType.state(), arrayList);
        }
        catch (CancelException cancelException) {
        }
        catch (Exception exception) {
            throw new RuntimeException("Exception trying to transform packet between client version " + String.valueOf(protocolVersion2) + " and server version " + String.valueOf(protocolVersion) + ". Are you sure you used the correct input version and packet write types?", exception);
        }
    }

    private boolean createAndSend(UserConnection userConnection, PacketType packetType, Consumer<PacketWrapper> consumer) throws InformativeException {
        PacketWrapper packetWrapper = PacketWrapper.create(packetType, userConnection);
        consumer.accept(packetWrapper);
        return this.send(packetWrapper);
    }

    private boolean scheduleCreateAndSend(UserConnection userConnection, PacketType packetType, Consumer<PacketWrapper> consumer) throws InformativeException {
        PacketWrapper packetWrapper = PacketWrapper.create(packetType, userConnection);
        consumer.accept(packetWrapper);
        return this.scheduleSend(packetWrapper);
    }

    private @Nullable PacketWrapper createAndTransform(UserConnection userConnection, PacketType packetType, Consumer<PacketWrapper> consumer) {
        PacketWrapper packetWrapper = PacketWrapper.create(packetType, userConnection);
        consumer.accept(packetWrapper);
        return this.transform(packetWrapper);
    }
}

