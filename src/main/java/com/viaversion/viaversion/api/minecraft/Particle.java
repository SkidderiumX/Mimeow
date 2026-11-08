/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft;

import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.util.Copyable;
import com.viaversion.viaversion.util.IdHolder;
import io.netty.buffer.ByteBuf;
import java.util.ArrayList;
import java.util.List;

public class Particle
implements IdHolder,
Copyable {
    private final List<ParticleData<?>> arguments = new ArrayList(4);
    private int id;

    public Particle(int n) {
        this.id = n;
    }

    @Override
    public int id() {
        return this.id;
    }

    public void setId(int n) {
        this.id = n;
    }

    public <T> ParticleData<T> getArgument(int n) {
        return this.arguments.get(n);
    }

    public <T> ParticleData<T> removeArgument(int n) {
        return this.arguments.remove(n);
    }

    public List<ParticleData<?>> getArguments() {
        return this.arguments;
    }

    public <T> void add(Type<T> type, T t) {
        this.arguments.add(new ParticleData<T>(type, t));
    }

    public <T> void add(int n, Type<T> type, T t) {
        this.arguments.add(n, new ParticleData<T>(type, t));
    }

    public <T> void set(int n, Type<T> type, T t) {
        this.arguments.set(n, new ParticleData<T>(type, t));
    }

    @Override
    public Particle copy() {
        Particle particle = new Particle(this.id);
        for (ParticleData<?> particleData : this.arguments) {
            particle.arguments.add((ParticleData<?>)particleData.copy());
        }
        return particle;
    }

    public String toString() {
        return "Particle{arguments=" + String.valueOf(this.arguments) + ", id=" + this.id + "}";
    }

    public static final class ParticleData<T>
    implements Copyable {
        private final Type<T> type;
        private T value;

        public ParticleData(Type<T> type, T t) {
            this.type = type;
            this.value = t;
        }

        public Type<T> getType() {
            return this.type;
        }

        public T getValue() {
            return this.value;
        }

        public void setValue(T t) {
            this.value = t;
        }

        public void write(ByteBuf byteBuf) {
            this.type.write(byteBuf, this.value);
        }

        public void write(PacketWrapper packetWrapper) {
            packetWrapper.write(this.type, this.value);
        }

        @Override
        public ParticleData<T> copy() {
            return new ParticleData<T>(this.type, Copyable.copy(this.value));
        }

        public String toString() {
            return "ParticleData{type=" + String.valueOf(this.type) + ", value=" + String.valueOf(this.value) + "}";
        }
    }
}

