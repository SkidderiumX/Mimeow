/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.data;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.IntArrayTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.data.BiMappings;
import com.viaversion.viaversion.api.data.FullMappings;
import com.viaversion.viaversion.api.data.FullMappingsBase;
import com.viaversion.viaversion.api.data.IdentityMappings;
import com.viaversion.viaversion.api.data.MappingData;
import com.viaversion.viaversion.api.data.MappingDataLoader;
import com.viaversion.viaversion.api.data.Mappings;
import com.viaversion.viaversion.api.data.ParticleMappings;
import com.viaversion.viaversion.api.minecraft.RegistryType;
import com.viaversion.viaversion.api.minecraft.TagData;
import com.viaversion.viaversion.libs.fastutil.ints.IntOpenHashSet;
import com.viaversion.viaversion.libs.fastutil.ints.IntSet;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.checkerframework.checker.nullness.qual.Nullable;

public class MappingDataBase
implements MappingData {
    protected final String unmappedVersion;
    protected final String mappedVersion;
    protected FullMappings argumentTypeMappings;
    protected FullMappings entityMappings;
    protected FullMappings recipeSerializerMappings;
    protected FullMappings itemDataSerializerMappings;
    protected FullMappings slotDisplayMappings;
    protected FullMappings attributeMappings;
    protected FullMappings blockEntityMappings;
    protected ParticleMappings particleMappings;
    protected BiMappings itemMappings;
    protected BiMappings blockMappings;
    protected Mappings blockStateMappings;
    protected Mappings soundMappings;
    protected Mappings statisticsMappings;
    protected Mappings enchantmentMappings;
    protected Mappings paintingMappings;
    protected Mappings menuMappings;
    protected Map<RegistryType, List<TagData>> tags;
    protected IntSet changedBlocks;
    protected Set<String> changedEnvironmentAttributes;

    public MappingDataBase(String string, String string2) {
        this.unmappedVersion = string;
        this.mappedVersion = string2;
    }

    @Override
    public void load() {
        ListTag<StringTag> listTag;
        Object object;
        Object object2;
        if (Via.getManager().isDebug()) {
            this.getLogger().info("Loading " + this.unmappedVersion + " -> " + this.mappedVersion + " mappings...");
        }
        CompoundTag compoundTag = this.readMappingsFile("mappings-" + this.unmappedVersion + "to" + this.mappedVersion + ".nbt");
        this.blockStateMappings = this.loadMappings(compoundTag, "blockstates");
        this.statisticsMappings = this.loadMappings(compoundTag, "statistics");
        this.menuMappings = this.loadMappings(compoundTag, "menus");
        this.enchantmentMappings = this.loadMappings(compoundTag, "enchantments");
        this.paintingMappings = this.loadMappings(compoundTag, "paintings");
        CompoundTag compoundTag2 = this.readUnmappedIdentifiersFile("identifiers-" + this.unmappedVersion + ".nbt");
        CompoundTag compoundTag3 = this.readMappedIdentifiersFile("identifiers-" + this.mappedVersion + ".nbt");
        if (compoundTag2 != null && compoundTag3 != null) {
            this.itemMappings = this.loadFullOrBiMappings(compoundTag, compoundTag2, compoundTag3, "items");
            this.blockMappings = this.loadFullOrBiMappings(compoundTag, compoundTag2, compoundTag3, "blocks");
            this.soundMappings = this.loadFullOrBiMappings(compoundTag, compoundTag2, compoundTag3, "sounds");
            this.entityMappings = this.loadFullMappings(compoundTag, compoundTag2, compoundTag3, "entities");
            this.argumentTypeMappings = this.loadFullMappings(compoundTag, compoundTag2, compoundTag3, "argumenttypes");
            this.slotDisplayMappings = this.loadFullMappings(compoundTag, compoundTag2, compoundTag3, "slot_displays");
            this.recipeSerializerMappings = this.loadFullMappings(compoundTag, compoundTag2, compoundTag3, "recipe_serializers");
            this.itemDataSerializerMappings = this.loadFullMappings(compoundTag, compoundTag2, compoundTag3, "data_component_type");
            this.attributeMappings = this.loadFullMappings(compoundTag, compoundTag2, compoundTag3, "attributes");
            this.blockEntityMappings = this.loadFullMappings(compoundTag, compoundTag2, compoundTag3, "blockentities");
            object2 = this.identifiersFromGlobalIds(compoundTag2, compoundTag3, "particles");
            if (object2 != null) {
                object = this.loadMappings(compoundTag, "particles");
                if (object == null) {
                    object = new IdentityMappings(((MappingDataLoader.IdentifiersPair)object2).unmapped().size(), ((MappingDataLoader.IdentifiersPair)object2).mapped().size());
                }
                this.particleMappings = new ParticleMappings((MappingDataLoader.IdentifiersPair)object2, (Mappings)object);
            }
        } else {
            this.itemMappings = this.loadBiMappings(compoundTag, "items");
            this.blockMappings = this.loadBiMappings(compoundTag, "blocks");
            this.soundMappings = this.loadMappings(compoundTag, "sounds");
        }
        object2 = compoundTag.getCompoundTag("tags");
        if (object2 != null) {
            this.tags = new EnumMap<RegistryType, List<TagData>>(RegistryType.class);
            this.loadTags(RegistryType.ITEM, (CompoundTag)object2);
            this.loadTags(RegistryType.BLOCK, (CompoundTag)object2);
            this.loadTags(RegistryType.ENTITY, (CompoundTag)object2);
            this.loadTags(RegistryType.FLUID, (CompoundTag)object2);
        }
        if ((object = compoundTag.getIntArrayTag("changed_blocks")) != null) {
            this.changedBlocks = new IntOpenHashSet(((IntArrayTag)object).getValue());
        }
        if ((listTag = compoundTag.getListTag("changed_environment_attributes", StringTag.class)) != null) {
            this.changedEnvironmentAttributes = listTag.stream().map(StringTag::getValue).collect(Collectors.toSet());
        }
        this.loadExtras(compoundTag);
    }

    protected @Nullable List<String> identifiersFromGlobalIds(CompoundTag compoundTag, String string) {
        return MappingDataLoader.INSTANCE.identifiersFromGlobalIds(compoundTag, string);
    }

    protected @Nullable MappingDataLoader.IdentifiersPair identifiersFromGlobalIds(CompoundTag compoundTag, CompoundTag compoundTag2, String string) {
        return MappingDataLoader.INSTANCE.identifiersFromGlobalIds(compoundTag, compoundTag2, string);
    }

    protected @Nullable CompoundTag readMappingsFile(String string) {
        return MappingDataLoader.INSTANCE.loadNBT(string);
    }

    protected @Nullable CompoundTag readUnmappedIdentifiersFile(String string) {
        return MappingDataLoader.INSTANCE.loadNBT(string, true);
    }

    protected @Nullable CompoundTag readMappedIdentifiersFile(String string) {
        return MappingDataLoader.INSTANCE.loadNBT(string, true);
    }

    protected @Nullable Mappings loadMappings(CompoundTag compoundTag, String string) {
        return MappingDataLoader.INSTANCE.loadMappings(compoundTag, string);
    }

    protected @Nullable BiMappings loadFullOrBiMappings(CompoundTag compoundTag, CompoundTag compoundTag2, CompoundTag compoundTag3, String string) {
        FullMappings fullMappings = this.loadFullMappings(compoundTag, compoundTag2, compoundTag3, string);
        return fullMappings != null ? fullMappings : this.loadBiMappings(compoundTag, string);
    }

    protected @Nullable FullMappings loadFullMappings(CompoundTag compoundTag, CompoundTag compoundTag2, CompoundTag compoundTag3, String string) {
        if (!compoundTag2.contains(string) || !compoundTag3.contains(string)) {
            return null;
        }
        MappingDataLoader.IdentifiersPair identifiersPair = this.identifiersFromGlobalIds(compoundTag2, compoundTag3, string);
        Mappings mappings = this.loadBiMappings(compoundTag, string);
        if (mappings == null) {
            mappings = new IdentityMappings(identifiersPair.unmapped().size(), identifiersPair.mapped().size());
        }
        return this.createFullMappings(identifiersPair, mappings);
    }

    protected FullMappings createFullMappings(MappingDataLoader.IdentifiersPair identifiersPair, Mappings mappings) {
        return FullMappingsBase.of(identifiersPair, mappings);
    }

    protected @Nullable BiMappings loadBiMappings(CompoundTag compoundTag, String string) {
        Mappings mappings = this.loadMappings(compoundTag, string);
        return mappings != null ? BiMappings.of(mappings) : null;
    }

    private void loadTags(RegistryType registryType, CompoundTag compoundTag) {
        CompoundTag compoundTag2 = compoundTag.getCompoundTag(registryType.identifier());
        if (compoundTag2 == null) {
            return;
        }
        ArrayList<TagData> arrayList = new ArrayList<TagData>(this.tags.size());
        for (Map.Entry<String, Tag> entry : compoundTag2.entrySet()) {
            IntArrayTag intArrayTag = (IntArrayTag)entry.getValue();
            arrayList.add(new TagData(entry.getKey(), intArrayTag.getValue()));
        }
        this.tags.put(registryType, arrayList);
    }

    @Override
    public int getNewBlockStateId(int n) {
        return this.checkValidity(n, this.blockStateMappings.getNewId(n), "blockstate");
    }

    @Override
    public int getNewBlockId(int n) {
        return this.checkValidity(n, this.blockMappings.getNewId(n), "block");
    }

    @Override
    public int getOldBlockId(int n) {
        return this.blockMappings.inverse().getNewIdOrDefault(n, 1);
    }

    @Override
    public int getNewItemId(int n) {
        return this.checkValidity(n, this.itemMappings.getNewId(n), "item");
    }

    @Override
    public int getOldItemId(int n) {
        return this.itemMappings.inverse().getNewIdOrDefault(n, 1);
    }

    @Override
    public int getNewParticleId(int n) {
        return this.checkValidity(n, this.particleMappings.getNewId(n), "particles");
    }

    @Override
    public int getNewAttributeId(int n) {
        return this.checkValidity(n, this.attributeMappings.getNewId(n), "attributes");
    }

    @Override
    public int getNewSoundId(int n) {
        return this.checkValidity(n, this.soundMappings.getNewId(n), "sound");
    }

    @Override
    public int getOldSoundId(int n) {
        return this.soundMappings.inverse().getNewIdOrDefault(n, 0);
    }

    @Override
    public @Nullable List<TagData> getTags(RegistryType registryType) {
        return this.tags != null ? this.tags.get(registryType) : null;
    }

    @Override
    public @Nullable BiMappings getItemMappings() {
        return this.itemMappings;
    }

    @Override
    public @Nullable FullMappings getFullItemMappings() {
        BiMappings biMappings = this.itemMappings;
        if (biMappings instanceof FullMappings) {
            FullMappings fullMappings = (FullMappings)biMappings;
            return fullMappings;
        }
        return null;
    }

    @Override
    public @Nullable ParticleMappings getParticleMappings() {
        return this.particleMappings;
    }

    @Override
    public @Nullable Mappings getBlockMappings() {
        return this.blockMappings;
    }

    @Override
    public @Nullable FullMappings getFullBlockMappings() {
        BiMappings biMappings = this.blockMappings;
        if (biMappings instanceof FullMappings) {
            FullMappings fullMappings = (FullMappings)biMappings;
            return fullMappings;
        }
        return null;
    }

    @Override
    public @Nullable FullMappings getBlockEntityMappings() {
        return this.blockEntityMappings;
    }

    @Override
    public @Nullable Mappings getBlockStateMappings() {
        return this.blockStateMappings;
    }

    @Override
    public @Nullable Mappings getSoundMappings() {
        return this.soundMappings;
    }

    @Override
    public @Nullable FullMappings getFullSoundMappings() {
        Mappings mappings = this.soundMappings;
        if (mappings instanceof FullMappings) {
            FullMappings fullMappings = (FullMappings)mappings;
            return fullMappings;
        }
        return null;
    }

    @Override
    public @Nullable Mappings getStatisticsMappings() {
        return this.statisticsMappings;
    }

    @Override
    public @Nullable Mappings getMenuMappings() {
        return this.menuMappings;
    }

    @Override
    public @Nullable Mappings getEnchantmentMappings() {
        return this.enchantmentMappings;
    }

    @Override
    public @Nullable FullMappings getAttributeMappings() {
        return this.attributeMappings;
    }

    @Override
    public @Nullable FullMappings getEntityMappings() {
        return this.entityMappings;
    }

    @Override
    public @Nullable FullMappings getArgumentTypeMappings() {
        return this.argumentTypeMappings;
    }

    @Override
    public @Nullable FullMappings getDataComponentSerializerMappings() {
        return this.itemDataSerializerMappings;
    }

    @Override
    public @Nullable Mappings getPaintingMappings() {
        return this.paintingMappings;
    }

    @Override
    public @Nullable FullMappings getRecipeSerializerMappings() {
        return this.recipeSerializerMappings;
    }

    @Override
    public @Nullable FullMappings getSlotDisplayMappings() {
        return this.slotDisplayMappings;
    }

    @Override
    public @Nullable IntSet changedBlocks() {
        return this.changedBlocks;
    }

    @Override
    public @Nullable Set<String> changedEnvironmentAttributes() {
        return this.changedEnvironmentAttributes;
    }

    protected Logger getLogger() {
        return Via.getPlatform().getLogger();
    }

    protected int checkValidity(int n, int n2, String string) {
        if (n2 == -1) {
            if (Via.getConfig().logOtherConversionWarnings()) {
                this.getLogger().warning(String.format("Missing %s %s for %s %s %d", this.mappedVersion, string, this.unmappedVersion, string, n));
            }
            return 0;
        }
        return n2;
    }

    protected void loadExtras(CompoundTag compoundTag) {
    }
}

