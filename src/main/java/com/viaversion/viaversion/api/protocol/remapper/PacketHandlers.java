/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.protocol.remapper;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandler;
import com.viaversion.viaversion.api.protocol.remapper.TypeRemapper;
import com.viaversion.viaversion.api.protocol.remapper.ValueReader;
import com.viaversion.viaversion.api.protocol.remapper.ValueTransformer;
import com.viaversion.viaversion.api.protocol.remapper.ValueWriter;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.exception.InformativeException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.logging.Level;

public abstract class PacketHandlers
implements PacketHandler {
    private final List<PacketHandler> packetHandlers = new ArrayList<PacketHandler>();

    protected PacketHandlers() {
        this.register();
    }

    static PacketHandler fromRemapper(List<PacketHandler> list) {
        PacketHandlers packetHandlers = new PacketHandlers(){

            @Override
            public void register() {
            }
        };
        packetHandlers.packetHandlers.addAll(list);
        return packetHandlers;
    }

    public <T> void map(Type<T> type) {
        this.handler(packetWrapper -> packetWrapper.passthrough(type));
    }

    public void map(Type<?> type, Type<?> type2) {
        this.handler(packetWrapper -> packetWrapper.passthroughAndMap(type, type2));
    }

    public <T1, T2> void map(Type<T1> type, Type<T2> type2, final Function<T1, T2> function) {
        this.map(type, new ValueTransformer<T1, T2>(type2){

            @Override
            public T2 transform(PacketWrapper packetWrapper, T1 T1) {
                return function.apply(T1);
            }
        });
    }

    public <T1, T2> void map(ValueTransformer<T1, T2> valueTransformer) {
        if (valueTransformer.getInputType() == null) {
            throw new IllegalArgumentException("Use map(Type<T1>, ValueTransformer<T1, T2>) for value transformers without specified input type!");
        }
        this.map(valueTransformer.getInputType(), valueTransformer);
    }

    public <T1, T2> void map(Type<T1> type, ValueTransformer<T1, T2> valueTransformer) {
        this.map(new TypeRemapper<T1>(type), valueTransformer);
    }

    public <T> void map(ValueReader<T> valueReader, ValueWriter<T> valueWriter) {
        this.handler(packetWrapper -> valueWriter.write(packetWrapper, valueReader.read(packetWrapper)));
    }

    public void handler(PacketHandler packetHandler) {
        this.packetHandlers.add(packetHandler);
    }

    public void handlerSoftFail(PacketHandler packetHandler) {
        this.packetHandlers.add(packetWrapper -> {
            try {
                packetHandler.handle(packetWrapper);
            }
            catch (Exception exception) {
                if (Via.getConfig().logOtherConversionWarnings()) {
                    Via.getPlatform().getLogger().log(Level.WARNING, "Failed to handle packet", exception);
                }
                packetWrapper.cancel();
            }
        });
    }

    public <T> void create(Type<T> type, T t) {
        this.handler(packetWrapper -> packetWrapper.write(type, t));
    }

    public void read(Type<?> type) {
        this.handler(packetWrapper -> packetWrapper.read(type));
    }

    protected abstract void register();

    @Override
    public final void handle(PacketWrapper packetWrapper) throws InformativeException {
        for (PacketHandler packetHandler : this.packetHandlers) {
            packetHandler.handle(packetWrapper);
        }
    }

    public int handlersSize() {
        return this.packetHandlers.size();
    }
}

