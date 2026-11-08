package com.viaversion.viaversion.rewriter;

import com.viaversion.viaversion.api.minecraft.*;
import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.util.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.libs.fastutil.ints.*;
import java.util.*;
import com.viaversion.viaversion.api.data.*;
import com.viaversion.viaversion.api.rewriter.*;
import com.viaversion.viaversion.exception.*;

public class TagRewriter<C extends ClientboundPacketType> implements com.viaversion.viaversion.api.rewriter.TagRewriter
{
    private static final int[] EMPTY_ARRAY;
    private final Map<RegistryType, List<TagData>> toAdd;
    private final Map<RegistryType, Map<String, String>> toRename;
    private final Map<RegistryType, Set<String>> toRemove;
    private final Set<String> toRemoveRegistries;
    private final Protocol<C, ?, ?, ?> protocol;
    
    public TagRewriter(final Protocol<C, ?, ?, ?> protocol) {
        this.toAdd = new EnumMap<RegistryType, List<TagData>>(RegistryType.class);
        this.toRename = new EnumMap<RegistryType, Map<String, String>>(RegistryType.class);
        this.toRemove = new EnumMap<RegistryType, Set<String>>(RegistryType.class);
        this.toRemoveRegistries = new HashSet<String>();
        this.protocol = protocol;
    }
    
    @Override
    public void onMappingDataLoaded() {
        if (this.protocol.getMappingData() == null) {
            return;
        }
        for (final RegistryType registryType : RegistryType.getValues()) {
            final List<TagData> tags = this.protocol.getMappingData().getTags(registryType);
            if (tags != null) {
                this.getOrComputeNewTags(registryType).addAll(tags);
            }
        }
    }
    
    @Override
    public void removeTags(final String s) {
        this.toRemoveRegistries.add(Key.stripMinecraftNamespace(s));
    }
    
    @Override
    public void removeTag(final RegistryType key, final String s) {
        this.toRemove.computeIfAbsent(key, p0 -> new HashSet()).add(Key.stripMinecraftNamespace(s));
    }
    
    @Override
    public void renameTag(final RegistryType key, final String s, final String s2) {
        this.toRename.computeIfAbsent(key, p0 -> new HashMap()).put(Key.stripMinecraftNamespace(s), s2);
    }
    
    @Override
    public void addEmptyTag(final RegistryType registryType, final String s) {
        this.getOrComputeNewTags(registryType).add(new TagData(s, TagRewriter.EMPTY_ARRAY));
    }
    
    @Override
    public void addEmptyTags(final RegistryType registryType, final String... array) {
        final List<TagData> orComputeNewTags = this.getOrComputeNewTags(registryType);
        for (int length = array.length, i = 0; i < length; ++i) {
            orComputeNewTags.add(new TagData(array[i], TagRewriter.EMPTY_ARRAY));
        }
    }
    
    @Override
    public void addEntityTag(final String s, final EntityType... array) {
        final int[] array2 = new int[array.length];
        for (int i = 0; i < array.length; ++i) {
            array2[i] = array[i].getId();
        }
        this.addTagRaw(RegistryType.ENTITY, s, array2);
    }
    
    @Override
    public void addTag(final RegistryType registryType, final String s, final int... array) {
        final List<TagData> orComputeNewTags = this.getOrComputeNewTags(registryType);
        final IdRewriteFunction rewriter = this.getRewriter(registryType);
        if (rewriter != null) {
            for (int i = 0; i < array.length; ++i) {
                array[i] = rewriter.rewrite(array[i]);
            }
        }
        orComputeNewTags.add(new TagData(s, array));
    }
    
    @Override
    public void addTagRaw(final RegistryType registryType, final String s, final int... array) {
        this.getOrComputeNewTags(registryType).add(new TagData(s, array));
    }
    
    public void register(final C c, final RegistryType registryType) {
        this.protocol.registerClientbound(c, this.getHandler(registryType));
    }
    
    public void registerGeneric(final C c) {
        this.protocol.registerClientbound(c, this::handleGeneric);
    }
    
    public PacketHandler getHandler(final RegistryType registryType) {
        return packetWrapper2 -> {
            RegistryType.getValues();
            final RegistryType[] array;
            final int length = array.length;
            int i = 0;
            while (i < length) {
                final RegistryType registryType3 = array[i];
                this.handle(packetWrapper2, registryType3);
                if (registryType3 == registryType2) {
                    break;
                }
                else {
                    ++i;
                }
            }
        };
    }
    
    public void handleGeneric(final PacketWrapper packetWrapper) {
        int intValue;
        final int n = intValue = packetWrapper.passthrough((Type<Integer>)Types.VAR_INT);
        final EnumSet<RegistryType> none = EnumSet.noneOf(RegistryType.class);
        for (int i = 0; i < n; ++i) {
            final String s = packetWrapper.read(Types.STRING);
            final String stripMinecraftNamespace = Key.stripMinecraftNamespace(s);
            if (this.shouldRemoveRegistry(stripMinecraftNamespace)) {
                --intValue;
                for (int intValue2 = packetWrapper.read((Type<Integer>)Types.VAR_INT), j = 0; j < intValue2; ++j) {
                    packetWrapper.read(Types.STRING);
                    packetWrapper.read(Types.VAR_INT_ARRAY_PRIMITIVE);
                }
            }
            else {
                packetWrapper.write(Types.STRING, s);
                final RegistryType byKey = RegistryType.getByKey(stripMinecraftNamespace);
                if (byKey != null) {
                    this.handle(packetWrapper, byKey);
                    none.add(byKey);
                }
                else {
                    this.handle(packetWrapper, null, null, null, null);
                }
            }
        }
        for (final Map.Entry entry : this.toAdd.entrySet()) {
            if (none.contains(entry.getKey())) {
                continue;
            }
            packetWrapper.write(Types.STRING, ((RegistryType)entry.getKey()).identifier());
            this.appendNewTags(packetWrapper, (RegistryType)entry.getKey());
            ++intValue;
        }
        if (n != intValue) {
            packetWrapper.set(Types.VAR_INT, 0, intValue);
        }
    }
    
    public void handle(final PacketWrapper packetWrapper, final String s) {
        final RegistryType byKey = RegistryType.getByKey(s);
        if (byKey != null) {
            this.handle(packetWrapper, byKey);
        }
        else {
            this.handle(packetWrapper, null, null, null, null);
        }
    }
    
    public void handle(final PacketWrapper packetWrapper, final RegistryType registryType) {
        this.handle(packetWrapper, this.getRewriter(registryType), this.getNewTags(registryType), this.toRename.get(registryType), this.toRemove.get(registryType));
    }
    
    protected void handle(final PacketWrapper packetWrapper, final IdRewriteFunction idRewriteFunction, final List<TagData> list, final Map<String, String> map, final Set<String> set) {
        final int intValue = packetWrapper.read((Type<Integer>)Types.VAR_INT);
        final ArrayList list2 = new ArrayList((list != null) ? (intValue + list.size()) : intValue);
        final HashSet set2 = new HashSet(intValue);
        for (int i = 0; i < intValue; ++i) {
            String s = packetWrapper.read(Types.STRING);
            if (map != null) {
                final String s2 = map.get(Key.stripMinecraftNamespace(s));
                if (s2 != null) {
                    s = s2;
                }
            }
            int[] array = packetWrapper.read(Types.VAR_INT_ARRAY_PRIMITIVE);
            if (idRewriteFunction != null) {
                final IntArrayList list3 = new IntArrayList(array.length);
                final int[] array2 = array;
                for (int length = array2.length, j = 0; j < length; ++j) {
                    final int rewrite = idRewriteFunction.rewrite(array2[j]);
                    if (rewrite != -1) {
                        list3.add(rewrite);
                    }
                }
                array = list3.toArray(TagRewriter.EMPTY_ARRAY);
            }
            list2.add((Object)new TagData(s, array));
            set2.add((Object)Key.stripMinecraftNamespace(s));
        }
        if (set != null) {
            list2.removeIf(tagData3 -> set3.contains(Key.stripMinecraftNamespace(tagData3.identifier())));
        }
        if (list != null) {
            for (final TagData tagData : list) {
                if (!set2.contains(Key.stripMinecraftNamespace(tagData.identifier()))) {
                    list2.add((Object)tagData);
                }
            }
        }
        packetWrapper.write(Types.VAR_INT, list2.size());
        for (final TagData tagData2 : list2) {
            packetWrapper.write(Types.STRING, tagData2.identifier());
            packetWrapper.write(Types.VAR_INT_ARRAY_PRIMITIVE, tagData2.entries());
        }
    }
    
    public void appendNewTags(final PacketWrapper packetWrapper, final RegistryType registryType) {
        final List<TagData> newTags = this.getNewTags(registryType);
        if (newTags != null) {
            packetWrapper.write(Types.VAR_INT, newTags.size());
            for (final TagData tagData : newTags) {
                packetWrapper.write(Types.STRING, tagData.identifier());
                packetWrapper.write(Types.VAR_INT_ARRAY_PRIMITIVE, tagData.entries().clone());
            }
        }
        else {
            packetWrapper.write(Types.VAR_INT, 0);
        }
    }
    
    @Override
    public List<TagData> getNewTags(final RegistryType registryType) {
        return this.toAdd.get(registryType);
    }
    
    @Override
    public List<TagData> getOrComputeNewTags(final RegistryType key) {
        return this.toAdd.computeIfAbsent(key, p0 -> new ArrayList());
    }
    
    public boolean shouldRemoveRegistry(final String s) {
        return (this.protocol.getRegistryDataRewriter() != null && this.protocol.getRegistryDataRewriter().shouldRemoveRegistry(s)) || this.toRemoveRegistries.contains(s);
    }
    
    public IdRewriteFunction getRewriter(final RegistryType registryType) {
        final MappingData mappingData = this.protocol.getMappingData();
        return switch (registryType) {
            default -> throw new IncompatibleClassChangeError();
            case BLOCK -> {
                if (mappingData != null && !Mappings.isIntIdIdentity(mappingData.getBlockMappings())) {
                    final MappingData obj = mappingData;
                    Objects.requireNonNull(obj);
                    yield obj::getNewBlockId;
                }
                yield null;
            }
            case ITEM -> {
                if (mappingData != null && !Mappings.isIntIdIdentity(mappingData.getItemMappings())) {
                    final MappingData obj2 = mappingData;
                    Objects.requireNonNull(obj2);
                    yield obj2::getNewItemId;
                }
                yield null;
            }
            case ENCHANTMENT -> {
                if (mappingData != null && !Mappings.isIntIdIdentity(mappingData.getEnchantmentMappings())) {
                    final Mappings enchantmentMappings = mappingData.getEnchantmentMappings();
                    Objects.requireNonNull(enchantmentMappings);
                    yield enchantmentMappings::getNewId;
                }
                yield null;
            }
            case ENTITY -> {
                if (this.protocol.getEntityRewriter() != null) {
                    final EntityRewriter<?> entityRewriter = this.protocol.getEntityRewriter();
                    Objects.requireNonNull(entityRewriter);
                    yield entityRewriter::newEntityId;
                }
                yield null;
            }
            case FLUID,  GAME_EVENT,  DAMAGE_TYPE,  BANNER_PATTERN -> null;
        };
    }
    
    static {
        EMPTY_ARRAY = new int[0];
    }
}
