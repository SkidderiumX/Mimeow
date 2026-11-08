/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types.misc;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.data.FullMappings;
import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.api.minecraft.Particle;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.misc.DynamicType;
import com.viaversion.viaversion.util.Key;
import io.netty.buffer.ByteBuf;

public class ParticleType
extends DynamicType<Particle> {
    public ParticleType() {
        super(Particle.class);
    }

    @Override
    public void write(ByteBuf byteBuf, Particle particle) {
        Types.VAR_INT.writePrimitive(byteBuf, particle.id());
        for (Particle.ParticleData<?> particleData : particle.getArguments()) {
            particleData.write(byteBuf);
        }
    }

    @Override
    public Particle read(ByteBuf byteBuf) {
        int n = Types.VAR_INT.readPrimitive(byteBuf);
        Particle particle = new Particle(n);
        this.readData(byteBuf, particle);
        return particle;
    }

    @Override
    protected FullMappings mappings(Protocol<?, ?, ?, ?> protocol) {
        return protocol.getMappingData().getParticleMappings();
    }

    public static final class Fillers {
        public static DynamicType.DataFiller fill1_13_2(Protocol<?, ?, ?, ?> protocol, ParticleType particleType, boolean bl) {
            return particleType.filler(protocol, bl).reader("item", Readers.item(protocol.getItemRewriter().mappedItemType())).reader("block", Readers.BLOCK).reader("dust", Readers.DUST).reader("falling_dust", Readers.BLOCK);
        }

        public static DynamicType.DataFiller fill1_17(Protocol<?, ?, ?, ?> protocol, ParticleType particleType) {
            return Fillers.fill1_13_2(protocol, particleType, true).reader("dust_color_transition", Readers.DUST_TRANSITION).reader("vibration", Readers.VIBRATION);
        }

        public static void fill1_18(Protocol<?, ?, ?, ?> protocol, ParticleType particleType) {
            Fillers.fill1_17(protocol, particleType).reader("block_marker", Readers.BLOCK);
        }

        public static void fill1_19(Protocol<?, ?, ?, ?> protocol, ParticleType particleType) {
            particleType.filler(protocol).reader("item", Readers.item(protocol.getItemRewriter().mappedItemType())).reader("block", Readers.BLOCK).reader("block_marker", Readers.BLOCK).reader("dust", Readers.DUST).reader("falling_dust", Readers.BLOCK).reader("dust_color_transition", Readers.DUST_TRANSITION).reader("vibration", Readers.VIBRATION1_19).reader("sculk_charge", Readers.SCULK_CHARGE).reader("shriek", Readers.SHRIEK);
        }

        public static DynamicType.DataFiller fill1_20_3(Protocol<?, ?, ?, ?> protocol, ParticleType particleType) {
            return particleType.filler(protocol).reader("item", Readers.item(protocol.getItemRewriter().mappedItemType())).reader("block", Readers.BLOCK).reader("block_marker", Readers.BLOCK).reader("dust", Readers.DUST).reader("falling_dust", Readers.BLOCK).reader("dust_color_transition", Readers.DUST_TRANSITION).reader("vibration", Readers.VIBRATION1_20_3).reader("sculk_charge", Readers.SCULK_CHARGE).reader("shriek", Readers.SHRIEK);
        }

        public static void fill1_20_5(Protocol<?, ?, ?, ?> protocol, ParticleType particleType) {
            Fillers.fill1_20_3(protocol, particleType).reader("dust_pillar", Readers.BLOCK).reader("entity_effect", Readers.COLOR);
        }

        public static void fill1_21_2(Protocol<?, ?, ?, ?> protocol) {
            protocol.mappedTypes().particle().filler(protocol).reader("item", Readers.item(protocol.getItemRewriter().mappedItemType())).reader("block", Readers.BLOCK).reader("block_marker", Readers.BLOCK).reader("dust_pillar", Readers.BLOCK).reader("falling_dust", Readers.BLOCK).reader("block_crumble", Readers.BLOCK).reader("dust", Readers.DUST1_21_2).reader("dust_color_transition", Readers.DUST_TRANSITION1_21_2).reader("vibration", Readers.VIBRATION1_20_3).reader("sculk_charge", Readers.SCULK_CHARGE).reader("shriek", Readers.SHRIEK).reader("entity_effect", Readers.COLOR).reader("trail", Readers.TRAIL1_21_2);
        }

        public static DynamicType.DataFiller fill1_21_4(Protocol<?, ?, ?, ?> protocol) {
            return protocol.mappedTypes().particle().filler(protocol).reader("item", Readers.item(protocol.getItemRewriter().mappedItemTemplateType())).reader("block", Readers.BLOCK).reader("block_marker", Readers.BLOCK).reader("dust_pillar", Readers.BLOCK).reader("falling_dust", Readers.BLOCK).reader("block_crumble", Readers.BLOCK).reader("dust", Readers.DUST1_21_2).reader("dust_color_transition", Readers.DUST_TRANSITION1_21_2).reader("vibration", Readers.VIBRATION1_20_3).reader("sculk_charge", Readers.SCULK_CHARGE).reader("shriek", Readers.SHRIEK).reader("entity_effect", Readers.COLOR).reader("trail", Readers.TRAIL1_21_4);
        }

        public static DynamicType.DataFiller fill1_21_5(Protocol<?, ?, ?, ?> protocol) {
            return Fillers.fill1_21_4(protocol).reader("tinted_leaves", Readers.COLOR);
        }

        public static DynamicType.DataFiller fill1_21_9(Protocol<?, ?, ?, ?> protocol) {
            return Fillers.fill1_21_5(protocol).reader("dragon_breath", Readers.POWER).reader("effect", Readers.SPELL).reader("instant_effect", Readers.SPELL).reader("flash", Readers.COLOR);
        }

        public static void fill26_2(Protocol<?, ?, ?, ?> protocol) {
            Fillers.fill1_21_9(protocol).reader("geyser", Readers.GEYSER).reader("geyser_base", Readers.GEYSER_BASE).reader("geyser_poof", Readers.GEYSER_BASE).reader("geyser_plume", Readers.GEYSER);
        }
    }

    public static final class Readers {
        public static final DynamicType.DataReader<Particle> BLOCK = (byteBuf, particle) -> particle.add(Types.VAR_INT, Types.VAR_INT.readPrimitive(byteBuf));
        public static final DynamicType.DataReader<Particle> ITEM1_13 = Readers.item(Types.ITEM1_13);
        public static final DynamicType.DataReader<Particle> ITEM1_13_2 = Readers.item(Types.ITEM1_13_2);
        public static final DynamicType.DataReader<Particle> DUST = (byteBuf, particle) -> {
            particle.add(Types.FLOAT, Float.valueOf(Types.FLOAT.readPrimitive(byteBuf)));
            particle.add(Types.FLOAT, Float.valueOf(Types.FLOAT.readPrimitive(byteBuf)));
            particle.add(Types.FLOAT, Float.valueOf(Types.FLOAT.readPrimitive(byteBuf)));
            particle.add(Types.FLOAT, Float.valueOf(Types.FLOAT.readPrimitive(byteBuf)));
        };
        public static final DynamicType.DataReader<Particle> DUST1_21_2 = (byteBuf, particle) -> {
            particle.add(Types.INT, Types.INT.readPrimitive(byteBuf));
            particle.add(Types.FLOAT, Float.valueOf(Types.FLOAT.readPrimitive(byteBuf)));
        };
        public static final DynamicType.DataReader<Particle> DUST_TRANSITION = (byteBuf, particle) -> {
            particle.add(Types.FLOAT, Float.valueOf(Types.FLOAT.readPrimitive(byteBuf)));
            particle.add(Types.FLOAT, Float.valueOf(Types.FLOAT.readPrimitive(byteBuf)));
            particle.add(Types.FLOAT, Float.valueOf(Types.FLOAT.readPrimitive(byteBuf)));
            particle.add(Types.FLOAT, Float.valueOf(Types.FLOAT.readPrimitive(byteBuf)));
            particle.add(Types.FLOAT, Float.valueOf(Types.FLOAT.readPrimitive(byteBuf)));
            particle.add(Types.FLOAT, Float.valueOf(Types.FLOAT.readPrimitive(byteBuf)));
            particle.add(Types.FLOAT, Float.valueOf(Types.FLOAT.readPrimitive(byteBuf)));
        };
        public static final DynamicType.DataReader<Particle> DUST_TRANSITION1_21_2 = (byteBuf, particle) -> {
            particle.add(Types.INT, Types.INT.readPrimitive(byteBuf));
            particle.add(Types.INT, Types.INT.readPrimitive(byteBuf));
            particle.add(Types.FLOAT, Float.valueOf(Types.FLOAT.readPrimitive(byteBuf)));
        };
        public static final DynamicType.DataReader<Particle> VIBRATION = (byteBuf, particle) -> {
            particle.add(Types.BLOCK_POSITION1_14, (BlockPosition)Types.BLOCK_POSITION1_14.read(byteBuf));
            String string = (String)Types.STRING.read(byteBuf);
            particle.add(Types.STRING, string);
            string = Key.stripMinecraftNamespace(string);
            if (string.equals("block")) {
                particle.add(Types.BLOCK_POSITION1_14, (BlockPosition)Types.BLOCK_POSITION1_14.read(byteBuf));
            } else if (string.equals("entity")) {
                particle.add(Types.VAR_INT, Types.VAR_INT.readPrimitive(byteBuf));
            } else {
                Via.getPlatform().getLogger().warning("Unknown vibration path position source type: " + string);
            }
            particle.add(Types.VAR_INT, Types.VAR_INT.readPrimitive(byteBuf));
        };
        public static final DynamicType.DataReader<Particle> VIBRATION1_19 = (byteBuf, particle) -> {
            String string = (String)Types.STRING.read(byteBuf);
            particle.add(Types.STRING, string);
            string = Key.stripMinecraftNamespace(string);
            if (string.equals("block")) {
                particle.add(Types.BLOCK_POSITION1_14, (BlockPosition)Types.BLOCK_POSITION1_14.read(byteBuf));
            } else if (string.equals("entity")) {
                particle.add(Types.VAR_INT, Types.VAR_INT.readPrimitive(byteBuf));
                particle.add(Types.FLOAT, Float.valueOf(Types.FLOAT.readPrimitive(byteBuf)));
            } else {
                Via.getPlatform().getLogger().warning("Unknown vibration path position source type: " + string);
            }
            particle.add(Types.VAR_INT, Types.VAR_INT.readPrimitive(byteBuf));
        };
        public static final DynamicType.DataReader<Particle> VIBRATION1_20_3 = (byteBuf, particle) -> {
            int n = Types.VAR_INT.readPrimitive(byteBuf);
            particle.add(Types.VAR_INT, n);
            if (n == 0) {
                particle.add(Types.BLOCK_POSITION1_14, (BlockPosition)Types.BLOCK_POSITION1_14.read(byteBuf));
            } else if (n == 1) {
                particle.add(Types.VAR_INT, Types.VAR_INT.readPrimitive(byteBuf));
                particle.add(Types.FLOAT, Float.valueOf(Types.FLOAT.readPrimitive(byteBuf)));
            } else {
                Via.getPlatform().getLogger().warning("Unknown vibration path position source type: " + n);
            }
            particle.add(Types.VAR_INT, Types.VAR_INT.readPrimitive(byteBuf));
        };
        public static final DynamicType.DataReader<Particle> SCULK_CHARGE = (byteBuf, particle) -> particle.add(Types.FLOAT, Float.valueOf(Types.FLOAT.readPrimitive(byteBuf)));
        public static final DynamicType.DataReader<Particle> SHRIEK = (byteBuf, particle) -> particle.add(Types.VAR_INT, Types.VAR_INT.readPrimitive(byteBuf));
        public static final DynamicType.DataReader<Particle> COLOR = (byteBuf, particle) -> particle.add(Types.INT, Types.INT.readPrimitive(byteBuf));
        public static final DynamicType.DataReader<Particle> TRAIL1_21_2 = (byteBuf, particle) -> {
            particle.add(Types.DOUBLE, Types.DOUBLE.readPrimitive(byteBuf));
            particle.add(Types.DOUBLE, Types.DOUBLE.readPrimitive(byteBuf));
            particle.add(Types.DOUBLE, Types.DOUBLE.readPrimitive(byteBuf));
            particle.add(Types.INT, Types.INT.readPrimitive(byteBuf));
        };
        public static final DynamicType.DataReader<Particle> TRAIL1_21_4 = (byteBuf, particle) -> {
            particle.add(Types.DOUBLE, Types.DOUBLE.readPrimitive(byteBuf));
            particle.add(Types.DOUBLE, Types.DOUBLE.readPrimitive(byteBuf));
            particle.add(Types.DOUBLE, Types.DOUBLE.readPrimitive(byteBuf));
            particle.add(Types.INT, Types.INT.readPrimitive(byteBuf));
            particle.add(Types.VAR_INT, Types.VAR_INT.readPrimitive(byteBuf));
        };
        public static final DynamicType.DataReader<Particle> POWER = (byteBuf, particle) -> particle.add(Types.FLOAT, Float.valueOf(Types.FLOAT.readPrimitive(byteBuf)));
        public static final DynamicType.DataReader<Particle> SPELL = (byteBuf, particle) -> {
            particle.add(Types.INT, Types.INT.readPrimitive(byteBuf));
            particle.add(Types.FLOAT, Float.valueOf(Types.FLOAT.readPrimitive(byteBuf)));
        };
        public static final DynamicType.DataReader<Particle> GEYSER_BASE = (byteBuf, particle) -> {
            particle.add(Types.INT, Types.INT.readPrimitive(byteBuf));
            particle.add(Types.FLOAT, Float.valueOf(Types.FLOAT.readPrimitive(byteBuf)));
        };
        public static final DynamicType.DataReader<Particle> GEYSER = (byteBuf, particle) -> particle.add(Types.INT, Types.INT.readPrimitive(byteBuf));

        public static DynamicType.DataReader<Particle> item(Type<Item> type) {
            return (byteBuf, particle) -> particle.add(type, (Item)type.read(byteBuf));
        }
    }
}

