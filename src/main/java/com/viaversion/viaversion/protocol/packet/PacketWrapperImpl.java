/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocol.packet;

import com.google.common.base.Preconditions;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.ProtocolInfo;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.protocol.packet.Direction;
import com.viaversion.viaversion.api.protocol.packet.PacketType;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.packet.State;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandler;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.TypeConverter;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.exception.CancelException;
import com.viaversion.viaversion.exception.InformativeException;
import com.viaversion.viaversion.util.ArrayUtil;
import com.viaversion.viaversion.util.PipelineUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.Nullable;

public class PacketWrapperImpl
implements PacketWrapper {
    private final Deque<PacketValue<?>> readableObjects = new ArrayDeque();
    private final List<PacketValue<?>> packetValues = new ArrayList();
    private final ByteBuf inputBuffer;
    private final UserConnection userConnection;
    private boolean send = true;
    private PacketType packetType;
    private boolean allActionsRead;
    private int id;

    public PacketWrapperImpl(int n, @Nullable ByteBuf byteBuf, UserConnection userConnection) {
        this.id = n;
        this.inputBuffer = byteBuf;
        this.userConnection = userConnection;
    }

    public PacketWrapperImpl(@Nullable PacketType packetType, @Nullable ByteBuf byteBuf, UserConnection userConnection) {
        this.packetType = packetType;
        this.id = packetType != null ? packetType.getId() : -1;
        this.inputBuffer = byteBuf;
        this.userConnection = userConnection;
    }

    @Override
    public <T> T get(Type<T> type, int n) throws InformativeException {
        int n2 = 0;
        for (PacketValue<?> packetValue : this.packetValues) {
            if (packetValue.type() != type) continue;
            if (n2 == n) {
                return (T)packetValue.value();
            }
            ++n2;
        }
        throw this.createInformativeException(new ArrayIndexOutOfBoundsException("Could not find type " + type.getTypeName() + " at " + n), type, n);
    }

    @Override
    public boolean is(Type type, int n) {
        int n2 = 0;
        for (PacketValue<?> packetValue : this.packetValues) {
            if (packetValue.type() != type) continue;
            if (n2 == n) {
                return true;
            }
            ++n2;
        }
        return false;
    }

    @Override
    public boolean isReadable(Type type, int n) {
        int n2 = 0;
        for (PacketValue<?> packetValue : this.readableObjects) {
            if (packetValue.type().getBaseClass() != type.getBaseClass()) continue;
            if (n2 == n) {
                return true;
            }
            ++n2;
        }
        return false;
    }

    @Override
    public <T> void set(Type<T> type, int n, @Nullable T t) throws InformativeException {
        int n2 = 0;
        for (PacketValue<?> packetValue : this.packetValues) {
            if (packetValue.type() != type) continue;
            if (n2 == n) {
                packetValue.setValue(t);
                return;
            }
            ++n2;
        }
        throw this.createInformativeException(new ArrayIndexOutOfBoundsException("Could not find type " + type.getTypeName() + " at " + n), type, n);
    }

    @Override
    public <T> T read(Type<T> type) {
        return this.readableObjects.isEmpty() ? this.readFromBuffer(type) : this.pollReadableObject(type).value;
    }

    private <T> T readFromBuffer(Type<T> type) {
        Preconditions.checkNotNull(this.inputBuffer, "This packet does not have an input buffer.");
        try {
            return type.read(this.inputBuffer);
        }
        catch (Exception exception) {
            throw this.createInformativeException(exception, type, this.packetValues.size() + 1);
        }
    }

    private <T> PacketValue<T> pollReadableObject(Type<T> type) {
        PacketValue<?> packetValue = this.readableObjects.poll();
        Type<?> type2 = packetValue.type();
        if (type2 == type || type.getBaseClass() == type2.getBaseClass() && type.getOutputClass() == type2.getOutputClass()) {
            return packetValue;
        }
        throw this.createInformativeException(new IOException("Unable to read type " + type.getTypeName() + ", found " + packetValue.type().getTypeName()), type, this.readableObjects.size());
    }

    @Override
    public <T> void write(Type<T> type, T t) {
        this.addPacketValue(new PacketValue<T>(type, t));
    }

    private <T> @Nullable T attemptTransform(Type<T> type, @Nullable Object object) {
        if (object != null && !type.getOutputClass().isAssignableFrom(object.getClass())) {
            if (type instanceof TypeConverter) {
                return ((TypeConverter)((Object)type)).from(object);
            }
            Via.getPlatform().getLogger().warning("Possible type mismatch: " + object.getClass().getName() + " -> " + String.valueOf(type.getOutputClass()));
        }
        return (T)object;
    }

    @Override
    public <T> T passthrough(Type<T> type) throws InformativeException {
        if (this.readableObjects.isEmpty()) {
            T t = this.readFromBuffer(type);
            this.addPacketValue(new PacketValue<T>(type, t));
            return t;
        }
        PacketValue<T> packetValue = this.pollReadableObject(type);
        this.addPacketValue(packetValue);
        return packetValue.value;
    }

    private void addPacketValue(PacketValue<?> packetValue) {
        if (!this.allActionsRead) {
            this.packetValues.add(packetValue);
        }
    }

    @Override
    public <T> T passthroughAndMap(Type<?> type, Type<T> type2) throws InformativeException {
        if (type == type2) {
            return this.passthrough(type2);
        }
        Object obj = this.read(type);
        T t = this.attemptTransform(type2, obj);
        this.write(type2, t);
        return t;
    }

    @Override
    public void passthroughAll() throws InformativeException {
        this.packetValues.addAll(this.readableObjects);
        this.readableObjects.clear();
        if (this.inputBuffer.isReadable()) {
            this.passthrough(Types.REMAINING_BYTES);
        }
    }

    @Override
    public void writeToBuffer(ByteBuf byteBuf) throws InformativeException {
        this.writeProcessedValues(byteBuf);
        if (this.inputBuffer != null) {
            byteBuf.writeBytes(this.inputBuffer);
        }
    }

    public boolean areStoredPacketValuesEmpty() {
        return this.packetValues.isEmpty() && this.readableObjects.isEmpty();
    }

    public void writeProcessedValues(ByteBuf byteBuf) throws InformativeException {
        if (this.id != -1) {
            Types.VAR_INT.writePrimitive(byteBuf, this.id);
        }
        if (!this.readableObjects.isEmpty()) {
            this.packetValues.addAll(this.readableObjects);
            this.readableObjects.clear();
        }
        for (int i = 0; i < this.packetValues.size(); ++i) {
            PacketValue<?> packetValue = this.packetValues.get(i);
            try {
                packetValue.write(byteBuf);
                continue;
            }
            catch (Exception exception) {
                throw this.createInformativeException(exception, packetValue.type(), i);
            }
        }
    }

    private InformativeException createInformativeException(Exception exception, Type<?> type, int n) {
        ProtocolInfo protocolInfo = this.user().getProtocolInfo();
        return new InformativeException(exception).set("Packet Type", this.packetType).set("Client Protocol", protocolInfo.protocolVersion().getName()).set("Server Protocol", protocolInfo.serverProtocolVersion().getName()).set("Index", n).set("Type", type.getTypeName()).set("Data", this.packetValues).set("Packet ID", this.id);
    }

    @Override
    public void clearInputBuffer() {
        if (this.inputBuffer != null) {
            this.inputBuffer.clear();
        }
        this.readableObjects.clear();
    }

    @Override
    public void clearPacket() {
        this.clearInputBuffer();
        this.packetValues.clear();
    }

    @Override
    public void send(Class<? extends Protocol> clazz, boolean bl) throws InformativeException {
        this.send0(clazz, bl, true);
    }

    @Override
    public void scheduleSend(Class<? extends Protocol> clazz, boolean bl) throws InformativeException {
        this.send0(clazz, bl, false);
    }

    private void send0(Class<? extends Protocol> clazz, boolean bl, boolean bl2) throws InformativeException {
        if (this.isCancelled()) {
            return;
        }
        UserConnection userConnection = this.user();
        if (bl2) {
            this.sendNow(clazz, bl);
        } else {
            userConnection.getChannel().eventLoop().execute(() -> this.sendNow(clazz, bl));
        }
    }

    private void sendNow(Class<? extends Protocol> clazz, boolean bl) throws InformativeException {
        block4: {
            try {
                ByteBuf byteBuf = this.constructPacket(clazz, bl, Direction.CLIENTBOUND);
                this.user().sendRawPacket(byteBuf);
            }
            catch (InformativeException informativeException) {
                throw informativeException;
            }
            catch (CancelException cancelException) {
            }
            catch (Exception exception) {
                if (PipelineUtil.containsCause(exception, CancelException.class)) break block4;
                throw new InformativeException(exception);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private ByteBuf constructPacket(@Nullable Class<? extends Protocol> clazz, boolean bl, Direction direction) throws InformativeException, CancelException {
        this.resetReader();
        ProtocolInfo protocolInfo = this.user().getProtocolInfo();
        List<Protocol> list = protocolInfo.getPipeline().pipes(clazz, bl, direction);
        State state = this.packetType != null ? this.packetType.state() : protocolInfo.getState(direction);
        this.apply(direction, state, list);
        ByteBuf byteBuf = this.allocateOutputBuffer();
        try {
            this.writeToBuffer(byteBuf);
            ByteBuf byteBuf2 = byteBuf.retain();
            return byteBuf2;
        }
        finally {
            byteBuf.release();
        }
    }

    @Override
    public ChannelFuture sendFuture(Class<? extends Protocol> clazz) throws InformativeException {
        if (!this.isCancelled()) {
            ByteBuf byteBuf;
            try {
                byteBuf = this.constructPacket(clazz, true, Direction.CLIENTBOUND);
            }
            catch (CancelException cancelException) {
                return this.user().getChannel().newFailedFuture(new RuntimeException("Cancelled packet"));
            }
            return this.user().sendRawPacketFuture(byteBuf);
        }
        return this.cancelledFuture();
    }

    @Override
    public void sendRaw() throws InformativeException {
        this.sendRaw(true);
    }

    @Override
    public ChannelFuture sendFutureRaw() throws InformativeException {
        if (this.isCancelled()) {
            return this.cancelledFuture();
        }
        ByteBuf byteBuf = this.allocateOutputBuffer();
        try {
            this.writeToBuffer(byteBuf);
            ChannelFuture channelFuture = this.user().sendRawPacketFuture(byteBuf.retain());
            return channelFuture;
        }
        finally {
            byteBuf.release();
        }
    }

    @Override
    public void scheduleSendRaw() throws InformativeException {
        this.sendRaw(false);
    }

    private void sendRaw(boolean bl) throws InformativeException {
        if (this.isCancelled()) {
            return;
        }
        ByteBuf byteBuf = this.allocateOutputBuffer();
        try {
            this.writeToBuffer(byteBuf);
            if (bl) {
                this.user().sendRawPacket(byteBuf.retain());
            } else {
                this.user().scheduleSendRawPacket(byteBuf.retain());
            }
        }
        finally {
            byteBuf.release();
        }
    }

    private ByteBuf allocateOutputBuffer() {
        if (this.inputBuffer == null) {
            return this.user().getChannel().alloc().buffer();
        }
        return this.inputBuffer.alloc().buffer(Math.max(this.inputBuffer.readableBytes(), 256));
    }

    private ChannelFuture cancelledFuture() {
        return this.user().getChannel().newFailedFuture(new RuntimeException("Tried to send cancelled packet"));
    }

    @Override
    public PacketWrapperImpl create(int n) {
        return new PacketWrapperImpl(n, null, this.user());
    }

    @Override
    public PacketWrapperImpl create(int n, PacketHandler packetHandler) throws InformativeException {
        PacketWrapperImpl packetWrapperImpl = this.create(n);
        packetHandler.handle(packetWrapperImpl);
        return packetWrapperImpl;
    }

    @Override
    public PacketWrapperImpl create(PacketType packetType) {
        return new PacketWrapperImpl(packetType, null, this.user());
    }

    @Override
    public PacketWrapperImpl create(PacketType packetType, PacketHandler packetHandler) throws InformativeException {
        PacketWrapperImpl packetWrapperImpl = this.create(packetType);
        packetHandler.handle(packetWrapperImpl);
        return packetWrapperImpl;
    }

    @Override
    public void apply(Direction direction, State state, List<Protocol> list) throws InformativeException, CancelException {
        int n = list.size();
        for (int i = 0; i < n; ++i) {
            Protocol protocol = list.get(i);
            protocol.transform(direction, state, this);
            this.resetReader();
            if (this.packetType == null) continue;
            state = this.packetType.state();
        }
    }

    @Override
    public boolean isCancelled() {
        return !this.send;
    }

    @Override
    public void setCancelled(boolean bl) {
        this.send = !bl;
    }

    @Override
    public UserConnection user() {
        return this.userConnection;
    }

    @Override
    public void resetReader() {
        for (int i = this.packetValues.size() - 1; i >= 0; --i) {
            this.readableObjects.addFirst(this.packetValues.get(i));
        }
        this.packetValues.clear();
    }

    @Override
    public void rewindReader(int n) {
        if (this.allActionsRead) {
            return;
        }
        int n2 = this.packetValues.size();
        Preconditions.checkArgument(n <= n2, "Tried resetting more values than there are readable values");
        for (int i = n2 - 1; i >= n2 - n; --i) {
            this.readableObjects.addFirst(this.packetValues.remove(i));
        }
    }

    @Override
    public void sendToServerRaw() throws InformativeException {
        this.sendToServerRaw(true);
    }

    @Override
    public void scheduleSendToServerRaw() throws InformativeException {
        this.sendToServerRaw(false);
    }

    private void sendToServerRaw(boolean bl) throws InformativeException {
        if (this.isCancelled()) {
            return;
        }
        ByteBuf byteBuf = this.allocateOutputBuffer();
        try {
            this.writeToBuffer(byteBuf);
            if (bl) {
                this.user().sendRawPacketToServer(byteBuf.retain());
            } else {
                this.user().scheduleSendRawPacketToServer(byteBuf.retain());
            }
        }
        finally {
            byteBuf.release();
        }
    }

    @Override
    public void sendToServer(Class<? extends Protocol> clazz, boolean bl) throws InformativeException {
        this.sendToServer0(clazz, bl, true);
    }

    @Override
    public void scheduleSendToServer(Class<? extends Protocol> clazz, boolean bl) throws InformativeException {
        this.sendToServer0(clazz, bl, false);
    }

    private void sendToServer0(Class<? extends Protocol> clazz, boolean bl, boolean bl2) throws InformativeException {
        if (this.isCancelled()) {
            return;
        }
        UserConnection userConnection = this.user();
        if (bl2) {
            block6: {
                try {
                    ByteBuf byteBuf = this.constructPacket(clazz, bl, Direction.SERVERBOUND);
                    userConnection.sendRawPacketToServer(byteBuf);
                }
                catch (InformativeException informativeException) {
                    throw informativeException;
                }
                catch (CancelException cancelException) {
                }
                catch (Exception exception) {
                    if (PipelineUtil.containsCause(exception, CancelException.class)) break block6;
                    throw new InformativeException(exception);
                }
            }
            return;
        }
        userConnection.getChannel().eventLoop().execute(() -> {
            block4: {
                try {
                    ByteBuf byteBuf = this.constructPacket(clazz, bl, Direction.SERVERBOUND);
                    userConnection.sendRawPacketToServer(byteBuf);
                }
                catch (InformativeException informativeException) {
                    throw informativeException;
                }
                catch (CancelException cancelException) {
                }
                catch (Exception exception) {
                    if (PipelineUtil.containsCause(exception, CancelException.class)) break block4;
                    throw new InformativeException(exception);
                }
            }
        });
    }

    @Override
    public @Nullable PacketType getPacketType() {
        return this.packetType;
    }

    @Override
    public void setPacketType(PacketType packetType) {
        this.packetType = packetType;
        this.id = packetType != null ? packetType.getId() : -1;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    @Deprecated
    public void setId(int n) {
        this.packetType = null;
        this.id = n;
    }

    public @Nullable ByteBuf getInputBuffer() {
        return this.inputBuffer;
    }

    public void setAllActionsRead(boolean bl) {
        this.allActionsRead = bl;
    }

    @Override
    public void consumeReadsOnly(Runnable runnable2) {
        boolean bl = this.allActionsRead;
        this.allActionsRead = true;
        try {
            runnable2.run();
        }
        finally {
            this.allActionsRead = bl;
        }
    }

    public String toString() {
        return "PacketWrapper{type=" + String.valueOf(this.packetType) + ", id=" + this.id + ", values=" + String.valueOf(this.packetValues) + ", readable=" + String.valueOf(this.readableObjects) + "}";
    }

    public static final class PacketValue<T> {
        private final Type<T> type;
        private T value;

        private PacketValue(Type<T> type, @Nullable T t) {
            this.type = type;
            this.value = t;
        }

        public Type<T> type() {
            return this.type;
        }

        public @Nullable Object value() {
            return this.value;
        }

        public void write(ByteBuf byteBuf) throws Exception {
            this.type.write(byteBuf, this.value);
        }

        public void setValue(@Nullable T t) {
            this.value = t;
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object == null || this.getClass() != object.getClass()) {
                return false;
            }
            PacketValue packetValue = (PacketValue)object;
            if (!this.type.equals(packetValue.type)) {
                return false;
            }
            return Objects.equals(this.value, packetValue.value);
        }

        public int hashCode() {
            int n = this.type.hashCode();
            n = 31 * n + (this.value != null ? this.value.hashCode() : 0);
            return n;
        }

        public String toString() {
            return "{" + String.valueOf(this.type) + ": " + ArrayUtil.toString(this.value) + "}";
        }
    }
}

