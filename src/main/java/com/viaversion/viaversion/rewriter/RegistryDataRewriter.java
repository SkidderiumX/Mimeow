/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.FullMappings;
import com.viaversion.viaversion.api.data.MappingData;
import com.viaversion.viaversion.api.data.Mappings;
import com.viaversion.viaversion.api.data.entity.DimensionData;
import com.viaversion.viaversion.api.minecraft.RegistryEntry;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.packet.State;
import com.viaversion.viaversion.api.rewriter.ComponentRewriter;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.data.entity.DimensionDataImpl;
import com.viaversion.viaversion.libs.fastutil.objects.Object2ObjectArrayMap;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.KeyMappings;
import com.viaversion.viaversion.util.TagUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import org.checkerframework.checker.nullness.qual.Nullable;

public class RegistryDataRewriter
implements com.viaversion.viaversion.api.rewriter.RegistryDataRewriter {
    private final Map<String, BiConsumer<String, CompoundTag>> registryEntryHandlers = new Object2ObjectArrayMap<String, BiConsumer<String, CompoundTag>>();
    private final Map<String, Consumer<CompoundTag>> enchantmentEffectHandlers = new Object2ObjectArrayMap<String, Consumer<CompoundTag>>();
    private final Set<String> enchantmentEffectsToRemove = new HashSet<String>();
    private final Map<String, List<RegistryEntry>> toAdd = new Object2ObjectArrayMap<String, List<RegistryEntry>>();
    private final Set<String> toRemove = new HashSet<String>();
    protected final Protocol<?, ?, ?, ?> protocol;

    public RegistryDataRewriter(Protocol<?, ?, ?, ?> protocol) {
        this.protocol = protocol;
    }

    @Override
    public void handle(PacketWrapper packetWrapper) {
        String string = Key.stripMinecraftNamespace(packetWrapper.passthrough(Types.STRING));
        RegistryEntry[] registryEntryArray = packetWrapper.read(Types.REGISTRY_ENTRY_ARRAY);
        registryEntryArray = this.handle(packetWrapper.user(), string, registryEntryArray);
        packetWrapper.write(Types.REGISTRY_ENTRY_ARRAY, registryEntryArray);
        if (this.toRemove.contains(string)) {
            packetWrapper.cancel();
        }
    }

    public RegistryEntry[] handle(UserConnection userConnection, String string, RegistryEntry[] registryEntryArray) {
        List<RegistryEntry> list;
        string = Key.stripMinecraftNamespace(string);
        String[] stringArray = new String[registryEntryArray.length];
        for (int i = 0; i < registryEntryArray.length; ++i) {
            stringArray[i] = Key.stripMinecraftNamespace(registryEntryArray[i].key());
        }
        this.protocol.getEntityRewriter().tracker(userConnection).addRegistryKeys(string, new KeyMappings(stringArray));
        switch (string) {
            case "enchantment": {
                this.updateEnchantments(userConnection, registryEntryArray);
                break;
            }
            case "trim_material": {
                this.updateTrimMaterials(registryEntryArray);
                break;
            }
            case "jukebox_song": {
                this.updateJukeboxSongs(registryEntryArray);
                break;
            }
            case "worldgen/biome": {
                this.updateBiomes(registryEntryArray);
                break;
            }
            case "dimension_type": {
                this.updateDimensionTypes(registryEntryArray);
                break;
            }
            case "dialog": {
                this.updateDialogs(userConnection, registryEntryArray);
            }
        }
        Object object = this.registryEntryHandlers.get(string);
        if (object != null) {
            for (RegistryEntry registryEntry : registryEntryArray) {
                if (registryEntry.tag() == null) continue;
                RegistryEntry[] registryEntryArray2 = (RegistryEntry[])registryEntry.tag();
                object.accept(registryEntry.key(), registryEntryArray2);
            }
        }
        if ((list = this.toAdd.get(string)) != null) {
            HashSet<String> hashSet = new HashSet<String>();
            RegistryEntry[] registryEntryArray3 = new RegistryEntry[registryEntryArray.length + list.size()];
            int n = 0;
            for (RegistryEntry registryEntry : registryEntryArray) {
                registryEntryArray3[n++] = registryEntry;
                hashSet.add(Key.stripMinecraftNamespace(registryEntry.key()));
            }
            for (RegistryEntry registryEntry : list) {
                if (hashSet.contains(Key.stripMinecraftNamespace(registryEntry.key()))) continue;
                registryEntryArray3[n++] = registryEntry.copy();
            }
            registryEntryArray = n < registryEntryArray3.length ? Arrays.copyOf(registryEntryArray3, n) : registryEntryArray3;
        }
        this.trackDimensionAndBiomes(userConnection, string, registryEntryArray);
        return registryEntryArray;
    }

    public void addEntries(String string2, RegistryEntry ... registryEntryArray) {
        this.toAdd.computeIfAbsent(Key.stripMinecraftNamespace(string2), string -> new ArrayList()).addAll(List.of(registryEntryArray));
    }

    public void remove(String string) {
        this.toRemove.add(Key.stripMinecraftNamespace(string));
    }

    public void addHandler(String string, BiConsumer<String, CompoundTag> biConsumer) {
        this.registryEntryHandlers.put(Key.stripMinecraftNamespace(string), biConsumer);
    }

    @Override
    public void sendMissingRegistries(UserConnection userConnection) {
        Object e = this.protocol.getEntityRewriter().tracker(userConnection);
        for (Map.Entry<String, List<RegistryEntry>> entry : this.toAdd.entrySet()) {
            if (e.registryKeys(entry.getKey()) != null) continue;
            List<RegistryEntry> list = entry.getValue();
            RegistryEntry[] registryEntryArray = new RegistryEntry[list.size()];
            for (int i = 0; i < list.size(); ++i) {
                registryEntryArray[i] = list.get(i).copy();
            }
            Object obj = this.protocol.getPacketTypesProvider().mappedClientboundType(State.CONFIGURATION, "REGISTRY_DATA");
            PacketWrapper packetWrapper = PacketWrapper.create(obj, userConnection);
            packetWrapper.write(Types.STRING, entry.getKey());
            packetWrapper.write(Types.REGISTRY_ENTRY_ARRAY, registryEntryArray);
            packetWrapper.send(this.protocol.getClass());
        }
    }

    public void addEnchantmentEffectRewriter(String string, Consumer<CompoundTag> consumer) {
        this.enchantmentEffectHandlers.put(Key.stripMinecraftNamespace(string), consumer);
    }

    public void removeEnchantmentEffects(String ... stringArray) {
        for (String string : stringArray) {
            this.enchantmentEffectsToRemove.add(Key.stripMinecraftNamespace(string));
        }
    }

    public void trackDimensionAndBiomes(UserConnection userConnection, String string, RegistryEntry[] registryEntryArray) {
        if (string.equals("worldgen/biome")) {
            this.protocol.getEntityRewriter().tracker(userConnection).setBiomesSent(registryEntryArray.length);
        } else if (string.equals("dimension_type")) {
            HashMap<String, DimensionData> hashMap = new HashMap<String, DimensionData>(registryEntryArray.length);
            for (int i = 0; i < registryEntryArray.length; ++i) {
                RegistryEntry registryEntry = registryEntryArray[i];
                String string2 = Key.stripMinecraftNamespace(registryEntry.key());
                DimensionData dimensionData = registryEntry.tag() != null ? new DimensionDataImpl(i, (CompoundTag)registryEntry.tag()) : DimensionDataImpl.withDefaultsFor(string2, i);
                hashMap.put(string2, dimensionData);
            }
            this.protocol.getEntityRewriter().tracker(userConnection).setDimensions(hashMap);
        }
    }

    public void updateDialogs(UserConnection userConnection, RegistryEntry[] registryEntryArray) {
        if (this.protocol.getMappingData() != null && this.protocol.getMappingData().getFullItemMappings() == null) {
            return;
        }
        for (RegistryEntry registryEntry : registryEntryArray) {
            if (registryEntry.tag() == null) continue;
            this.updateDialog(userConnection, (CompoundTag)registryEntry.tag());
        }
    }

    @Override
    public void updateDialog(UserConnection userConnection, CompoundTag compoundTag2) {
        ListTag<CompoundTag> listTag;
        ListTag<CompoundTag> listTag3;
        ComponentRewriter componentRewriter = this.protocol.getComponentRewriter();
        if (componentRewriter != null) {
            componentRewriter.processTag(userConnection, compoundTag2.get("title"));
            componentRewriter.processTag(userConnection, compoundTag2.get("external_title"));
        }
        if ((listTag3 = compoundTag2.getListTag("inputs", CompoundTag.class)) != null && componentRewriter != null) {
            for (CompoundTag listTag22 : listTag3) {
                this.updateTextComponent(userConnection, listTag22, "label");
                String compoundTag4 = listTag22.getString("type");
                if (!Key.equals(compoundTag4, "single_option") || (listTag = listTag22.getListTag("options", CompoundTag.class)) == null) continue;
                listTag.forEach(compoundTag -> this.updateTextComponent(userConnection, (CompoundTag)compoundTag, "display"));
            }
        }
        String string = compoundTag2.getString("type");
        switch (Key.stripMinecraftNamespace(string)) {
            case "confirmation": {
                this.updateDialogAction(userConnection, compoundTag2.getCompoundTag("yes"));
                this.updateDialogAction(userConnection, compoundTag2.getCompoundTag("no"));
                break;
            }
            case "dialog_list": {
                this.updateDialogAction(userConnection, compoundTag2.getCompoundTag("exit_action"));
                listTag = compoundTag2.getListTag("dialogs", CompoundTag.class);
                if (listTag != null) {
                    listTag.forEach(compoundTag -> this.updateDialog(userConnection, (CompoundTag)compoundTag));
                    break;
                }
                CompoundTag compoundTag3 = compoundTag2.getCompoundTag("dialogs");
                if (compoundTag3 == null) break;
                this.updateDialog(userConnection, compoundTag3);
                break;
            }
            case "multi_action": {
                this.updateDialogAction(userConnection, compoundTag2.getCompoundTag("exit_action"));
                listTag = compoundTag2.getListTag("actions", CompoundTag.class);
                if (listTag == null) break;
                listTag.forEach(compoundTag -> this.updateDialogAction(userConnection, (CompoundTag)compoundTag));
                break;
            }
            case "notice": {
                this.updateDialogAction(userConnection, compoundTag2.getCompoundTag("action"));
                break;
            }
            case "server_links": {
                this.updateDialogAction(userConnection, compoundTag2.getCompoundTag("exit_action"));
            }
        }
        ListTag<CompoundTag> listTag2 = compoundTag2.getListTag("body", CompoundTag.class);
        if (listTag2 != null) {
            listTag2.forEach(compoundTag -> this.updateDialogBody(userConnection, (CompoundTag)compoundTag));
        } else {
            CompoundTag compoundTag4 = compoundTag2.getCompoundTag("body");
            if (compoundTag4 != null) {
                this.updateDialogBody(userConnection, compoundTag4);
            }
        }
    }

    public void updateDialogAction(UserConnection userConnection, CompoundTag compoundTag) {
        this.updateTextComponent(userConnection, compoundTag, "label");
        this.updateTextComponent(userConnection, compoundTag, "tooltip");
    }

    protected void updateTextComponent(UserConnection userConnection, @Nullable CompoundTag compoundTag, String string) {
        if (compoundTag != null && this.protocol.getComponentRewriter() != null) {
            this.protocol.getComponentRewriter().processTag(userConnection, compoundTag.get(string));
        }
    }

    public void updateDialogBody(UserConnection userConnection, CompoundTag compoundTag) {
        String string = compoundTag.getString("type");
        ComponentRewriter componentRewriter = this.protocol.getComponentRewriter();
        if (Key.equals(string, "plain_message")) {
            if (componentRewriter != null) {
                componentRewriter.processTag(userConnection, compoundTag.get("contents"));
            }
        } else if (Key.equals(string, "item")) {
            Object object;
            Tag tag;
            if (componentRewriter != null) {
                tag = compoundTag.get("description");
                componentRewriter.processTag(userConnection, tag);
                if (tag instanceof CompoundTag) {
                    object = (CompoundTag)tag;
                    componentRewriter.processTag(userConnection, ((CompoundTag)object).get("contents"));
                }
            }
            if ((tag = compoundTag.getStringTag("item")) != null) {
                object = this.protocol.getMappingData().getFullItemMappings().mappedIdentifier(((StringTag)tag).getValue());
                if (object != null) {
                    ((StringTag)tag).setValue((String)object);
                }
            } else if (componentRewriter != null) {
                componentRewriter.handleShowItem(userConnection, compoundTag.getCompoundTag("item"));
            }
        }
    }

    public void updateEnchantments(UserConnection userConnection, RegistryEntry[] registryEntryArray) {
        for (RegistryEntry registryEntry : registryEntryArray) {
            CompoundTag compoundTag;
            if (registryEntry.tag() == null) continue;
            CompoundTag compoundTag2 = (CompoundTag)registryEntry.tag();
            if (!Mappings.isFullIdentity(this.protocol.getMappingData().getFullItemMappings())) {
                this.updateItemList(compoundTag2.getListTag("supported_items", StringTag.class));
                this.updateItemList(compoundTag2.getListTag("primary_items", StringTag.class));
            }
            if ((compoundTag = compoundTag2.getCompoundTag("effects")) == null) continue;
            for (Map.Entry<String, Tag> entry : compoundTag.entrySet()) {
                ListTag listTag;
                Object object = entry.getValue();
                if (object instanceof CompoundTag) {
                    CompoundTag compoundTag3 = (CompoundTag)object;
                    this.updateNestedEffect(compoundTag3);
                    continue;
                }
                object = entry.getValue();
                if (!(object instanceof ListTag) || (listTag = (ListTag)object).getElementType() != CompoundTag.class) continue;
                for (Tag tag : listTag) {
                    this.updateNestedEffect((CompoundTag)tag);
                }
            }
            MappingData mappingData = this.protocol.getMappingData();
            if (mappingData == null || mappingData.getAttributeMappings() == null) continue;
            this.updateAttributesFields(compoundTag);
        }
    }

    public void updateTrimMaterials(RegistryEntry[] registryEntryArray) {
        if (Mappings.isFullIdentity(this.protocol.getMappingData().getFullItemMappings())) {
            return;
        }
        for (RegistryEntry registryEntry : registryEntryArray) {
            if (registryEntry.tag() == null) continue;
            StringTag stringTag = ((CompoundTag)registryEntry.tag()).getStringTag("ingredient");
            if (stringTag == null) {
                return;
            }
            this.updateItem(stringTag);
        }
    }

    public void updateJukeboxSongs(RegistryEntry[] registryEntryArray) {
    }

    public void updateDimensionTypes(RegistryEntry[] registryEntryArray) {
        for (RegistryEntry registryEntry : registryEntryArray) {
            CompoundTag compoundTag;
            if (registryEntry.tag() == null || (compoundTag = ((CompoundTag)registryEntry.tag()).getCompoundTag("attributes")) == null) continue;
            this.updateEnvironmentAttributes(compoundTag);
        }
    }

    public void updateBiomes(RegistryEntry[] registryEntryArray) {
        for (RegistryEntry registryEntry : registryEntryArray) {
            CompoundTag compoundTag;
            CompoundTag compoundTag2;
            if (registryEntry.tag() == null) continue;
            CompoundTag compoundTag3 = (CompoundTag)registryEntry.tag();
            CompoundTag compoundTag4 = compoundTag3.getCompoundTag("attributes");
            if (compoundTag4 != null) {
                this.updateEnvironmentAttributes(compoundTag4);
            }
            if ((compoundTag2 = compoundTag3.getCompoundTag("effects")) == null || (compoundTag = compoundTag2.getCompoundTag("particle")) == null) continue;
            this.handleParticleData(compoundTag.getCompoundTag("options"));
        }
    }

    protected void updateEnvironmentAttributes(CompoundTag compoundTag) {
        MappingData mappingData = this.protocol.getMappingData();
        if (mappingData == null || mappingData.changedEnvironmentAttributes() == null) {
            return;
        }
        for (String string : mappingData.changedEnvironmentAttributes()) {
            TagUtil.removeNamespaced(compoundTag, string);
        }
    }

    private void updateNestedEffect(CompoundTag compoundTag) {
        Tag tag;
        CompoundTag compoundTag2 = compoundTag.getCompoundTag("effect");
        if (compoundTag2 != null) {
            this.runEffectRewriters(compoundTag2);
            tag = compoundTag2.getListTag("effects", CompoundTag.class);
            if (tag != null) {
                Iterator iterator2 = ((ListTag)tag).iterator();
                while (iterator2.hasNext()) {
                    CompoundTag compoundTag3 = (CompoundTag)iterator2.next();
                    this.runEffectRewriters(compoundTag3);
                }
            }
        }
        if ((tag = compoundTag.getCompoundTag("requirements")) != null) {
            this.updateEnchantmentTerm((CompoundTag)tag);
        }
    }

    public void updateEnchantmentTerm(CompoundTag compoundTag) {
        String string = compoundTag.getString("condition");
        if (Key.equals(string, "inverted")) {
            CompoundTag compoundTag2 = compoundTag.getCompoundTag("term");
            if (compoundTag2 != null) {
                this.updateEnchantmentTerm(compoundTag2);
            }
        } else if (Key.equals(string, "entity_properties")) {
            CompoundTag compoundTag3 = compoundTag.getCompoundTag("predicate");
            if (compoundTag3 != null) {
                this.updateType(compoundTag3, "type", this.protocol.getMappingData().getEntityMappings());
                this.updateType(compoundTag3, "entity_type", this.protocol.getMappingData().getEntityMappings());
            }
        } else if (Key.equals(string, "block_state_property")) {
            this.updateType(compoundTag, "block", this.protocol.getMappingData().getFullBlockMappings());
        } else {
            ListTag<CompoundTag> listTag = compoundTag.getListTag("terms", CompoundTag.class);
            if (listTag != null) {
                for (CompoundTag compoundTag4 : listTag) {
                    this.updateEnchantmentTerm(compoundTag4);
                }
            }
        }
    }

    private void updateAttributesFields(CompoundTag compoundTag) {
        ListTag<CompoundTag> listTag = TagUtil.getNamespacedCompoundTagList(compoundTag, "attributes");
        if (listTag == null) {
            return;
        }
        for (CompoundTag compoundTag2 : listTag) {
            this.updateType(compoundTag2, "attribute", this.protocol.getMappingData().getAttributeMappings());
        }
    }

    protected void handleParticleData(CompoundTag compoundTag) {
        this.updateType(compoundTag, "type", this.protocol.getMappingData().getParticleMappings());
    }

    private void runEffectRewriters(CompoundTag compoundTag) {
        Object object;
        String string = compoundTag.getString("type");
        if (string == null) {
            return;
        }
        if (this.enchantmentEffectsToRemove.contains(string = Key.stripMinecraftNamespace(string))) {
            compoundTag.clear();
            compoundTag.putString("type", "minecraft:all_of");
            compoundTag.put("effects", new ListTag<CompoundTag>(CompoundTag.class));
            return;
        }
        if (string.equals("attribute")) {
            this.updateType(compoundTag, "attribute", this.protocol.getMappingData().getAttributeMappings());
        } else if (string.equals("spawn_particles") && (object = compoundTag.getCompoundTag("particle")) != null) {
            this.handleParticleData((CompoundTag)object);
        }
        object = this.enchantmentEffectHandlers.get(string);
        if (object != null) {
            object.accept(compoundTag);
        } else if (string.equals("play_sound")) {
            this.updateType(compoundTag, "sound", this.protocol.getMappingData().getFullSoundMappings());
        }
    }

    protected void updateType(CompoundTag compoundTag, String string, FullMappings fullMappings) {
        ListTag listTag;
        Tag tag = compoundTag.get(string);
        if (tag == null || Mappings.isFullIdentity(fullMappings)) {
            return;
        }
        if (tag instanceof StringTag) {
            StringTag stringTag = (StringTag)tag;
            this.setMappedOrDummyId(fullMappings, stringTag);
        } else if (tag instanceof ListTag && (listTag = (ListTag)tag).getElementType() == StringTag.class) {
            ListTag listTag2 = listTag;
            for (StringTag stringTag : listTag2) {
                this.setMappedOrDummyId(fullMappings, stringTag);
            }
        }
    }

    private void setMappedOrDummyId(FullMappings fullMappings, StringTag stringTag) {
        if (Key.stripMinecraftNamespace(stringTag.getValue()).startsWith("#")) {
            return;
        }
        String string = fullMappings.mappedIdentifier(stringTag.getValue());
        if (string == null) {
            string = fullMappings.mappedIdentifier(0);
        }
        stringTag.setValue(string);
    }

    private void updateItemList(ListTag<StringTag> listTag) {
        if (listTag == null) {
            return;
        }
        for (StringTag stringTag : listTag) {
            this.updateItem(stringTag);
        }
    }

    private void updateItem(StringTag stringTag) {
        String string = this.protocol.getMappingData().getFullItemMappings().mappedIdentifier(stringTag.getValue());
        if (string != null) {
            stringTag.setValue(string);
        }
    }

    public RegistryEntry[] entriesFromTag(CompoundTag compoundTag) {
        RegistryEntry[] registryEntryArray = new RegistryEntry[compoundTag.size()];
        int n = 0;
        for (Map.Entry<String, Tag> entry : compoundTag.entrySet()) {
            registryEntryArray[n++] = new RegistryEntry(entry.getKey(), entry.getValue());
        }
        return registryEntryArray;
    }

    @Override
    public boolean shouldRemoveRegistry(String string) {
        return this.toRemove.contains(Key.stripMinecraftNamespace(string));
    }

    @Override
    public boolean hasRegistriesToRemove() {
        return !this.toRemove.isEmpty();
    }
}

