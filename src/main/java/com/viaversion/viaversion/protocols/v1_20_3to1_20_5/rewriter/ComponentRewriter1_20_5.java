/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_20_3to1_20_5.rewriter;

import com.google.common.base.Preconditions;
import com.viaversion.nbt.tag.ByteTag;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.FloatTag;
import com.viaversion.nbt.tag.IntArrayTag;
import com.viaversion.nbt.tag.IntTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.NumberTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.GameProfile;
import com.viaversion.viaversion.api.minecraft.GlobalBlockPosition;
import com.viaversion.viaversion.api.minecraft.Holder;
import com.viaversion.viaversion.api.minecraft.HolderSet;
import com.viaversion.viaversion.api.minecraft.SoundEvent;
import com.viaversion.viaversion.api.minecraft.data.StructuredData;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataContainer;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.api.minecraft.item.DataItem;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.minecraft.item.StructuredItem;
import com.viaversion.viaversion.api.minecraft.item.data.AdventureModePredicate;
import com.viaversion.viaversion.api.minecraft.item.data.ArmorTrim;
import com.viaversion.viaversion.api.minecraft.item.data.ArmorTrimMaterial;
import com.viaversion.viaversion.api.minecraft.item.data.ArmorTrimPattern;
import com.viaversion.viaversion.api.minecraft.item.data.AttributeModifiers1_20_5;
import com.viaversion.viaversion.api.minecraft.item.data.BannerPattern;
import com.viaversion.viaversion.api.minecraft.item.data.BannerPatternLayer;
import com.viaversion.viaversion.api.minecraft.item.data.Bee;
import com.viaversion.viaversion.api.minecraft.item.data.BlockPredicate;
import com.viaversion.viaversion.api.minecraft.item.data.BlockStateProperties;
import com.viaversion.viaversion.api.minecraft.item.data.DebugStickState;
import com.viaversion.viaversion.api.minecraft.item.data.DyedColor;
import com.viaversion.viaversion.api.minecraft.item.data.Enchantments;
import com.viaversion.viaversion.api.minecraft.item.data.FilterableComponent;
import com.viaversion.viaversion.api.minecraft.item.data.FilterableString;
import com.viaversion.viaversion.api.minecraft.item.data.FireworkExplosion;
import com.viaversion.viaversion.api.minecraft.item.data.Fireworks;
import com.viaversion.viaversion.api.minecraft.item.data.FoodProperties1_20_5;
import com.viaversion.viaversion.api.minecraft.item.data.Instrument1_20_5;
import com.viaversion.viaversion.api.minecraft.item.data.LodestoneTracker;
import com.viaversion.viaversion.api.minecraft.item.data.PotDecorations;
import com.viaversion.viaversion.api.minecraft.item.data.PotionContents;
import com.viaversion.viaversion.api.minecraft.item.data.PotionEffect;
import com.viaversion.viaversion.api.minecraft.item.data.PotionEffectData;
import com.viaversion.viaversion.api.minecraft.item.data.StatePropertyMatcher;
import com.viaversion.viaversion.api.minecraft.item.data.SuspiciousStewEffect;
import com.viaversion.viaversion.api.minecraft.item.data.ToolProperties;
import com.viaversion.viaversion.api.minecraft.item.data.ToolRule;
import com.viaversion.viaversion.api.minecraft.item.data.Unbreakable;
import com.viaversion.viaversion.api.minecraft.item.data.WritableBook;
import com.viaversion.viaversion.api.minecraft.item.data.WrittenBook;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.api.type.types.item.StructuredDataType;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntMap;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntOpenHashMap;
import com.viaversion.viaversion.libs.fastutil.objects.Reference2ObjectOpenHashMap;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.Protocol1_20_3To1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.data.ArmorMaterials1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.data.Attributes1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.data.BannerPatterns1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.data.DyeColors;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.data.Enchantments1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.data.EquipmentSlots1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.data.Instruments1_20_3;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.data.PotionEffects1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.data.Potions1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.rewriter.BlockItemPacketRewriter1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.storage.ArmorTrimStorage;
import com.viaversion.viaversion.rewriter.text.ComponentRewriterBase;
import com.viaversion.viaversion.rewriter.text.JsonNBTComponentRewriter;
import com.viaversion.viaversion.util.Either;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.MathUtil;
import com.viaversion.viaversion.util.SerializerVersion;
import com.viaversion.viaversion.util.StringUtil;
import com.viaversion.viaversion.util.UUIDUtil;
import com.viaversion.viaversion.util.Unit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;
import org.checkerframework.checker.nullness.qual.Nullable;

public class ComponentRewriter1_20_5<C extends ClientboundPacketType>
extends JsonNBTComponentRewriter<C> {
    protected final Map<StructuredDataKey<?>, ConverterPair<?>> converters = new Reference2ObjectOpenHashMap();
    protected final StructuredDataType structuredDataType;

    public ComponentRewriter1_20_5(Protocol<C, ?, ?, ?> protocol, StructuredDataType structuredDataType) {
        super(protocol, ComponentRewriterBase.ReadType.NBT);
        this.structuredDataType = structuredDataType;
        this.register(StructuredDataKey.CUSTOM_DATA, this::customDataToTag, this::customDataFromTag);
        this.register(StructuredDataKey.MAX_STACK_SIZE, this::maxStackSizeToTag, this::maxStackSizeFromTag);
        this.register(StructuredDataKey.MAX_DAMAGE, this::maxDamageToTag, this::maxDamageFromTag);
        this.register(StructuredDataKey.DAMAGE, this::damageToTag, this::damageFromTag);
        this.register(StructuredDataKey.UNBREAKABLE1_20_5, this::unbreakableToTag, this::unbreakableFromTag);
        this.register(StructuredDataKey.CUSTOM_NAME, this::customNameToTag, this::customNameFromTag);
        this.register(StructuredDataKey.ITEM_NAME, this::itemNameToTag, this::itemNameFromTag);
        this.register(StructuredDataKey.LORE, this::loreToTag, this::loreFromTag);
        this.register(StructuredDataKey.RARITY, this::rarityToTag, this::rarityFromTag);
        this.register(StructuredDataKey.ENCHANTMENTS1_20_5, this::enchantmentsToTag, this::enchantmentsFromTag);
        this.register(StructuredDataKey.CAN_PLACE_ON1_20_5, this::canPlaceOnToTag, this::canPlaceOnFromTag);
        this.register(StructuredDataKey.CAN_BREAK1_20_5, this::canBreakToTag, this::canBreakFromTag);
        this.register(StructuredDataKey.ATTRIBUTE_MODIFIERS1_20_5, this::attributeModifiersToTag, this::attributeModifiersFromTag);
        this.register(StructuredDataKey.CUSTOM_MODEL_DATA1_20_5, this::customModelDataToTag, this::customModelDataFromTag);
        this.register(StructuredDataKey.HIDE_ADDITIONAL_TOOLTIP, this::hideAdditionalTooltipToTag, this::hideAdditionalTooltipFromTag);
        this.register(StructuredDataKey.HIDE_TOOLTIP, this::hideTooltipToTag, this::hideTooltipFromTag);
        this.register(StructuredDataKey.REPAIR_COST, this::repairCostToTag, this::repairCostFromTag);
        this.register(StructuredDataKey.ENCHANTMENT_GLINT_OVERRIDE, this::enchantmentGlintOverrideToTag, this::enchantmentGlintOverrideFromTag);
        this.registerEmpty(StructuredDataKey.CREATIVE_SLOT_LOCK);
        this.register(StructuredDataKey.INTANGIBLE_PROJECTILE, this::intangibleProjectileToTag, this::intangibleProjectileFromTag);
        this.register(StructuredDataKey.FOOD1_20_5, this::foodToTag, this::foodFromTag);
        this.register(StructuredDataKey.FIRE_RESISTANT, this::fireResistantToTag, this::fireResistantFromTag);
        this.register(StructuredDataKey.TOOL1_20_5, this::toolToTag, this::toolFromTag);
        this.register(StructuredDataKey.STORED_ENCHANTMENTS1_20_5, this::storedEnchantmentsToTag, this::storedEnchantmentsFromTag);
        this.register(StructuredDataKey.DYED_COLOR1_20_5, this::dyedColorToTag, this::dyedColorFromTag);
        this.register(StructuredDataKey.MAP_COLOR, this::mapColorToTag, this::mapColorFromTag);
        this.register(StructuredDataKey.MAP_ID, this::mapIdToTag, this::mapIdFromTag);
        this.register(StructuredDataKey.MAP_DECORATIONS, this::mapDecorationsToTag, this::mapDecorationsFromTag);
        this.registerEmpty(StructuredDataKey.MAP_POST_PROCESSING);
        this.register(StructuredDataKey.V1_20_5.chargedProjectiles, this::chargedProjectilesToTag, this::chargedProjectilesFromTag);
        this.register(StructuredDataKey.V1_20_5.bundleContents, this::bundleContentsToTag, this::bundleContentsFromTag);
        this.register(StructuredDataKey.POTION_CONTENTS1_20_5, this::potionContentsToTag, this::potionContentsFromTag);
        this.register(StructuredDataKey.SUSPICIOUS_STEW_EFFECTS, this::suspiciousStewEffectsToTag, this::suspiciousStewEffectsFromTag);
        this.register(StructuredDataKey.WRITABLE_BOOK_CONTENT, this::writableBookContentToTag, this::writableBookContentFromTag);
        this.register(StructuredDataKey.WRITTEN_BOOK_CONTENT, this::writtenBookContentToTag, this::writtenBookContentFromTag);
        this.register(StructuredDataKey.TRIM1_20_5, this::trimToTag, this::trimFromTag);
        this.register(StructuredDataKey.DEBUG_STICK_STATE, this::debugStickStateToTag, this::debugStickStateFromTag);
        this.register(StructuredDataKey.ENTITY_DATA1_20_5, this::entityDataToTag, this::entityDataFromTag);
        this.register(StructuredDataKey.BUCKET_ENTITY_DATA, this::bucketEntityDataToTag, this::bucketEntityDataFromTag);
        this.register(StructuredDataKey.BLOCK_ENTITY_DATA1_20_5, this::blockEntityDataToTag, this::blockEntityDataFromTag);
        this.register(StructuredDataKey.INSTRUMENT1_20_5, this::instrumentToTag, this::instrumentFromTag);
        this.register(StructuredDataKey.OMINOUS_BOTTLE_AMPLIFIER, this::ominousBottleAmplifierToTag, this::ominousBottleAmplifierFromTag);
        this.register(StructuredDataKey.RECIPES, this::recipesToTag, this::recipesFromTag);
        this.register(StructuredDataKey.LODESTONE_TRACKER, this::lodestoneTrackerToTag, this::lodestoneTrackerFromTag);
        this.register(StructuredDataKey.FIREWORK_EXPLOSION, this::fireworkExplosionToTag, this::fireworkExplosionFromTag);
        this.register(StructuredDataKey.FIREWORKS, this::fireworksToTag, this::fireworksFromTag);
        this.register(StructuredDataKey.PROFILE1_20_5, this::profileToTag, this::profileFromTag);
        this.register(StructuredDataKey.NOTE_BLOCK_SOUND, this::noteBlockSoundToTag, this::noteBlockSoundFromTag);
        this.register(StructuredDataKey.BANNER_PATTERNS, this::bannerPatternsToTag, this::bannerPatternsFromTag);
        this.register(StructuredDataKey.BASE_COLOR, this::baseColorToTag, this::baseColorFromTag);
        this.register(StructuredDataKey.POT_DECORATIONS, this::potDecorationsToTag, this::potDecorationsFromTag);
        this.register(StructuredDataKey.V1_20_5.container, this::containerToTag, this::containerFromTag);
        this.register(StructuredDataKey.BLOCK_STATE, this::blockStateToTag, this::blockStateFromTag);
        this.register(StructuredDataKey.BEES1_20_5, this::beesToTag, this::beesFromTag);
        this.register(StructuredDataKey.LOCK1_20_5, this::lockToTag, this::lockFromTag);
        this.register(StructuredDataKey.CONTAINER_LOOT, this::containerLootToTag, this::containerLootFromTag);
    }

    @Override
    protected void handleHoverEvent(UserConnection userConnection, CompoundTag compoundTag) {
        super.handleHoverEvent(userConnection, compoundTag);
        StringTag stringTag = compoundTag.getStringTag("action");
        if (stringTag == null) {
            return;
        }
        if (stringTag.getValue().equals("show_entity")) {
            CompoundTag compoundTag2 = compoundTag.getCompoundTag("contents");
            if (compoundTag2 == null) {
                return;
            }
            if (this.protocol.getMappingData().getEntityMappings().mappedId(compoundTag2.getString("type")) == -1) {
                compoundTag2.put("type", new StringTag("pig"));
            }
        }
    }

    @Override
    protected void handleShowItem(UserConnection userConnection, CompoundTag compoundTag, @Nullable CompoundTag compoundTag2) {
        Object object;
        Item item;
        CompoundTag compoundTag3;
        super.handleShowItem(userConnection, compoundTag, compoundTag2);
        StringTag stringTag = compoundTag.getStringTag("id");
        if (stringTag == null) {
            return;
        }
        int n = Protocol1_20_3To1_20_5.MAPPINGS.getFullItemMappings().id(stringTag.getValue());
        if (n == -1) {
            n = 1;
        }
        StringTag stringTag2 = (StringTag)compoundTag.remove("tag");
        try {
            compoundTag3 = stringTag2 != null ? (CompoundTag)this.inputSerializerVersion().toTag(stringTag2.getValue()) : null;
        }
        catch (Exception exception) {
            if (Via.getConfig().logTextComponentConversionErrors()) {
                this.protocol.getLogger().log(Level.WARNING, "Error reading NBT in show_item: " + StringUtil.forLogging(compoundTag), exception);
            }
            return;
        }
        DataItem dataItem = new DataItem();
        dataItem.setIdentifier(n);
        if (compoundTag3 != null) {
            dataItem.setTag(compoundTag3);
        }
        if ((item = this.protocol.getItemRewriter().handleItemToClient(userConnection, dataItem)).amount() < 1) {
            item.setAmount(1);
        }
        if (item.identifier() != 0) {
            object = this.mappedIdentifier(item.identifier());
            if (object != null) {
                compoundTag.putString("id", (String)object);
            }
        } else {
            compoundTag.putString("id", "minecraft:stone");
        }
        object = item.dataContainer().data();
        if (!object.isEmpty()) {
            CompoundTag compoundTag4;
            try {
                compoundTag4 = this.toTag(userConnection, (Map<StructuredDataKey<?>, StructuredData<?>>)object);
            }
            catch (Exception exception) {
                if (Via.getConfig().logTextComponentConversionErrors()) {
                    this.protocol.getLogger().log(Level.WARNING, "Error writing components in show_item!", exception);
                }
                return;
            }
            compoundTag.put("components", compoundTag4);
        }
    }

    public CompoundTag toTag(UserConnection userConnection, Map<StructuredDataKey<?>, StructuredData<?>> map) {
        CompoundTag compoundTag = new CompoundTag();
        for (Map.Entry<StructuredDataKey<?>, StructuredData<?>> entry : map.entrySet()) {
            StructuredDataKey<?> structuredDataKey = entry.getKey();
            String string = structuredDataKey.identifier();
            ConverterPair<?> converterPair = this.converters.get(structuredDataKey);
            if (converterPair == null) {
                Via.getPlatform().getLogger().severe("No converter found for data component: " + string);
                continue;
            }
            StructuredData<?> structuredData = entry.getValue();
            if (structuredData.isEmpty()) {
                compoundTag.put("!" + string, new CompoundTag());
                continue;
            }
            Tag tag = converterPair.dataConverter.convert(userConnection, structuredData.value());
            if (tag == null) continue;
            compoundTag.put(string, tag);
        }
        return compoundTag;
    }

    public List<StructuredData<?>> toData(UserConnection userConnection, CompoundTag compoundTag) {
        ArrayList arrayList = new ArrayList();
        if (compoundTag != null) {
            for (Map.Entry<String, Tag> entry : compoundTag.entrySet()) {
                StructuredData<?> structuredData = this.readFromTag(userConnection, entry.getKey(), entry.getValue());
                arrayList.add(structuredData);
            }
        }
        return arrayList;
    }

    private StructuredData<?> readFromTag(UserConnection userConnection, String string, Tag tag) {
        int n;
        boolean bl = string.startsWith("!");
        if (bl) {
            string = string.substring(1);
        }
        Preconditions.checkArgument((n = this.protocol.getMappingData().getDataComponentSerializerMappings().mappedId(string)) != -1, "Unknown data component: %s", string);
        StructuredDataKey<?> structuredDataKey = this.structuredDataType.key(n);
        if (bl) {
            return StructuredData.empty(structuredDataKey, n);
        }
        return this.readFromTag(userConnection, structuredDataKey, n, tag);
    }

    protected <T> StructuredData<T> readFromTag(UserConnection userConnection, StructuredDataKey<T> structuredDataKey, int n, Tag tag) {
        TagConverter<T> tagConverter = this.tagConverter(structuredDataKey);
        Preconditions.checkNotNull(tagConverter, "No converter found for: %s", structuredDataKey);
        return StructuredData.of(structuredDataKey, tagConverter.convert(userConnection, tag), n);
    }

    private String mappedIdentifier(int n) {
        return Protocol1_20_3To1_20_5.MAPPINGS.getFullItemMappings().mappedIdentifier(n);
    }

    private int mappedId(String string) {
        return Protocol1_20_3To1_20_5.MAPPINGS.getFullItemMappings().mappedId(string);
    }

    protected CompoundTag customDataToTag(CompoundTag compoundTag) {
        return compoundTag;
    }

    protected CompoundTag customDataFromTag(Tag tag) {
        return (CompoundTag)tag;
    }

    protected IntTag maxStackSizeToTag(Integer n) {
        return this.intRangeToTag(n, 1, 99);
    }

    protected Integer maxStackSizeFromTag(Tag tag) {
        return this.checkIntRange(1, 99, this.asInt(tag));
    }

    protected IntTag maxDamageToTag(Integer n) {
        return this.positiveIntToTag(n);
    }

    protected Integer maxDamageFromTag(Tag tag) {
        return this.checkPositiveInt(this.asInt(tag));
    }

    protected IntTag damageToTag(Integer n) {
        return this.nonNegativeIntToTag(n);
    }

    protected Integer damageFromTag(Tag tag) {
        return this.checkNonNegativeInt(this.asInt(tag));
    }

    protected CompoundTag unbreakableToTag(Unbreakable unbreakable) {
        CompoundTag compoundTag = new CompoundTag();
        if (!unbreakable.showInTooltip()) {
            compoundTag.putBoolean("show_in_tooltip", false);
        }
        return compoundTag;
    }

    protected Unbreakable unbreakableFromTag(Tag tag) {
        if (tag instanceof CompoundTag) {
            CompoundTag compoundTag = (CompoundTag)tag;
            return new Unbreakable(compoundTag.getBoolean("show_in_tooltip", true));
        }
        return null;
    }

    protected StringTag customNameToTag(Tag tag) {
        return this.componentToTag(tag);
    }

    protected Tag customNameFromTag(Tag tag) {
        return this.componentFromTag(tag);
    }

    protected StringTag itemNameToTag(Tag tag) {
        return this.componentToTag(tag);
    }

    protected Tag itemNameFromTag(Tag tag) {
        return this.componentFromTag(tag);
    }

    protected ListTag<StringTag> loreToTag(Tag[] tagArray) {
        return this.componentsToTag(tagArray, 256);
    }

    protected Tag[] loreFromTag(Tag tag) {
        return this.componentsFromTag(tag, 256);
    }

    protected StringTag rarityToTag(Integer n) {
        return this.enumEntryToTag(n, "common", "uncommon", "rare", "epic");
    }

    protected Integer rarityFromTag(Tag tag) {
        if (tag instanceof StringTag) {
            StringTag stringTag = (StringTag)tag;
            return this.enumEntryFromTag(stringTag, "common", "uncommon", "rare", "epic");
        }
        return null;
    }

    protected CompoundTag enchantmentsToTag(Enchantments enchantments) {
        CompoundTag compoundTag = new CompoundTag();
        CompoundTag compoundTag2 = new CompoundTag();
        for (Int2IntMap.Entry entry : enchantments.enchantments().int2IntEntrySet()) {
            int n = this.checkIntRange(0, 255, entry.getIntValue());
            compoundTag2.putInt(Enchantments1_20_5.idToKey(entry.getIntKey()), n);
        }
        compoundTag.put("levels", compoundTag2);
        if (!enchantments.showInTooltip()) {
            compoundTag.putBoolean("show_in_tooltip", false);
        }
        return compoundTag;
    }

    protected Enchantments enchantmentsFromTag(Tag tag) {
        CompoundTag compoundTag = (CompoundTag)tag;
        Int2IntOpenHashMap int2IntOpenHashMap = new Int2IntOpenHashMap();
        CompoundTag compoundTag2 = compoundTag.getCompoundTag("levels");
        if (compoundTag2 == null) {
            return null;
        }
        for (Map.Entry<String, Tag> entry : compoundTag2) {
            int n = Enchantments1_20_5.keyToId(entry.getKey());
            if (n == -1) continue;
            int2IntOpenHashMap.put(n, this.checkIntRange(0, 255, this.asInt(entry.getValue())));
        }
        return new Enchantments(int2IntOpenHashMap, compoundTag.getBoolean("show_in_tooltip", true));
    }

    protected CompoundTag canPlaceOnToTag(AdventureModePredicate adventureModePredicate) {
        return this.blockPredicateToTag(adventureModePredicate);
    }

    protected CompoundTag canBreakToTag(AdventureModePredicate adventureModePredicate) {
        return this.blockPredicateToTag(adventureModePredicate);
    }

    protected CompoundTag blockPredicateToTag(AdventureModePredicate adventureModePredicate) {
        CompoundTag compoundTag = new CompoundTag();
        ListTag<CompoundTag> listTag = new ListTag<CompoundTag>(CompoundTag.class);
        for (BlockPredicate blockPredicate : adventureModePredicate.predicates()) {
            CompoundTag compoundTag2 = new CompoundTag();
            if (blockPredicate.holderSet() != null) {
                this.holderSetToTag(compoundTag2, "blocks", blockPredicate.holderSet());
            }
            if (blockPredicate.propertyMatchers() != null) {
                compoundTag2.put("state", this.createState(blockPredicate));
            }
            if (blockPredicate.tag() != null) {
                compoundTag2.put("nbt", blockPredicate.tag());
            }
            listTag.add(compoundTag2);
        }
        compoundTag.put("predicates", listTag);
        if (!adventureModePredicate.showInTooltip()) {
            compoundTag.putBoolean("show_in_tooltip", false);
        }
        return compoundTag;
    }

    protected AdventureModePredicate canPlaceOnFromTag(Tag tag) {
        return this.blockPredicateFromTag(tag);
    }

    protected AdventureModePredicate canBreakFromTag(Tag tag) {
        return this.blockPredicateFromTag(tag);
    }

    protected AdventureModePredicate blockPredicateFromTag(Tag tag) {
        CompoundTag compoundTag = (CompoundTag)tag;
        boolean bl = compoundTag.getBoolean("show_in_tooltip", true);
        ListTag<CompoundTag> listTag = compoundTag.getListTag("predicates", CompoundTag.class);
        ArrayList<BlockPredicate> arrayList = new ArrayList<BlockPredicate>();
        if (listTag != null) {
            for (CompoundTag compoundTag2 : listTag) {
                HolderSet holderSet = this.holderSetFromTag(compoundTag2, "blocks");
                StatePropertyMatcher[] statePropertyMatcherArray = this.fromState(compoundTag2.getCompoundTag("state"));
                arrayList.add(new BlockPredicate(holderSet, statePropertyMatcherArray, compoundTag2.getCompoundTag("nbt")));
            }
        }
        return new AdventureModePredicate((BlockPredicate[])arrayList.toArray(BlockPredicate[]::new), bl);
    }

    protected CompoundTag createState(BlockPredicate blockPredicate) {
        CompoundTag compoundTag = new CompoundTag();
        for (StatePropertyMatcher statePropertyMatcher : blockPredicate.propertyMatchers()) {
            Either<String, StatePropertyMatcher.RangedMatcher> either = statePropertyMatcher.matcher();
            if (either.isLeft()) {
                compoundTag.putString(statePropertyMatcher.name(), either.left());
                continue;
            }
            StatePropertyMatcher.RangedMatcher rangedMatcher = either.right();
            CompoundTag compoundTag2 = new CompoundTag();
            if (rangedMatcher.minValue() != null) {
                compoundTag2.putString("min", rangedMatcher.minValue());
            }
            if (rangedMatcher.maxValue() != null) {
                compoundTag2.putString("max", rangedMatcher.maxValue());
            }
            compoundTag.put(statePropertyMatcher.name(), compoundTag2);
        }
        return compoundTag;
    }

    protected StatePropertyMatcher @Nullable [] fromState(CompoundTag compoundTag) {
        if (compoundTag == null) {
            return null;
        }
        ArrayList<StatePropertyMatcher> arrayList = new ArrayList<StatePropertyMatcher>();
        for (Map.Entry<String, Tag> entry : compoundTag.entrySet()) {
            String string = entry.getKey();
            Tag tag = entry.getValue();
            if (tag instanceof StringTag) {
                StringTag stringTag = (StringTag)tag;
                arrayList.add(new StatePropertyMatcher(string, Either.left(stringTag.getValue())));
                continue;
            }
            if (!(tag instanceof CompoundTag)) continue;
            CompoundTag compoundTag2 = (CompoundTag)tag;
            String string2 = compoundTag2.getString("min");
            String string3 = compoundTag2.getString("max");
            arrayList.add(new StatePropertyMatcher(string, Either.right(new StatePropertyMatcher.RangedMatcher(string2, string3))));
        }
        return (StatePropertyMatcher[])arrayList.toArray(StatePropertyMatcher[]::new);
    }

    protected CompoundTag attributeModifiersToTag(AttributeModifiers1_20_5 attributeModifiers1_20_5) {
        CompoundTag compoundTag = new CompoundTag();
        ListTag<CompoundTag> listTag = new ListTag<CompoundTag>(CompoundTag.class);
        for (AttributeModifiers1_20_5.AttributeModifier attributeModifier : attributeModifiers1_20_5.modifiers()) {
            CompoundTag compoundTag2 = new CompoundTag();
            String string = Attributes1_20_5.idToKey(attributeModifier.attribute());
            if (string == null) {
                throw new IllegalArgumentException("Unknown attribute type: " + attributeModifier.attribute());
            }
            compoundTag2.putString("type", string);
            this.modifierDataToTag(compoundTag2, attributeModifier.modifier());
            if (attributeModifier.slotType() != 0) {
                String string2 = EquipmentSlots1_20_5.idToKey(attributeModifier.slotType());
                Preconditions.checkNotNull(string2, "Unknown slot type %s", attributeModifier.slotType());
                compoundTag2.putString("slot", string2);
            }
            listTag.add(compoundTag2);
        }
        compoundTag.put("modifiers", listTag);
        if (!attributeModifiers1_20_5.showInTooltip()) {
            compoundTag.putBoolean("show_in_tooltip", false);
        }
        return compoundTag;
    }

    protected AttributeModifiers1_20_5 attributeModifiersFromTag(Tag tag) {
        CompoundTag compoundTag = (CompoundTag)tag;
        boolean bl = compoundTag.getBoolean("show_in_tooltip", true);
        ListTag<CompoundTag> listTag = compoundTag.getListTag("modifiers", CompoundTag.class);
        ArrayList<AttributeModifiers1_20_5.AttributeModifier> arrayList = new ArrayList<AttributeModifiers1_20_5.AttributeModifier>();
        if (listTag != null) {
            for (CompoundTag compoundTag2 : listTag) {
                int n = Attributes1_20_5.keyToId(compoundTag2.getString("type"));
                AttributeModifiers1_20_5.ModifierData modifierData = this.modifierDataFromTag(compoundTag2);
                int n2 = EquipmentSlots1_20_5.keyToId(compoundTag2.getString("slot", "any"));
                arrayList.add(new AttributeModifiers1_20_5.AttributeModifier(n, modifierData, n2));
            }
        }
        return new AttributeModifiers1_20_5((AttributeModifiers1_20_5.AttributeModifier[])arrayList.toArray(AttributeModifiers1_20_5.AttributeModifier[]::new), bl);
    }

    protected IntTag customModelDataToTag(Integer n) {
        return new IntTag(n);
    }

    protected Integer customModelDataFromTag(Tag tag) {
        return this.asInt(tag);
    }

    protected CompoundTag hideAdditionalTooltipToTag(Unit unit) {
        return this.unitToTag();
    }

    protected Unit hideAdditionalTooltipFromTag(Tag tag) {
        return Unit.INSTANCE;
    }

    protected CompoundTag hideTooltipToTag(Unit unit) {
        return this.unitToTag();
    }

    protected Unit hideTooltipFromTag(Tag tag) {
        return Unit.INSTANCE;
    }

    protected IntTag repairCostToTag(Integer n) {
        return this.intRangeToTag(n, 0, Integer.MAX_VALUE);
    }

    protected Integer repairCostFromTag(Tag tag) {
        return this.checkIntRange(0, Integer.MAX_VALUE, this.asInt(tag));
    }

    protected ByteTag enchantmentGlintOverrideToTag(Boolean bl) {
        return new ByteTag(bl);
    }

    protected Boolean enchantmentGlintOverrideFromTag(Tag tag) {
        return this.asBoolean(tag);
    }

    protected CompoundTag intangibleProjectileToTag(Tag tag) {
        return this.unitToTag();
    }

    protected Tag intangibleProjectileFromTag(Tag tag) {
        return tag;
    }

    protected CompoundTag foodToTag(FoodProperties1_20_5 foodProperties1_20_5) {
        CompoundTag compoundTag = new CompoundTag();
        compoundTag.put("nutrition", this.nonNegativeIntToTag(foodProperties1_20_5.nutrition()));
        compoundTag.putFloat("saturation", foodProperties1_20_5.saturationModifier());
        if (foodProperties1_20_5.canAlwaysEat()) {
            compoundTag.putBoolean("can_always_eat", true);
        }
        if (foodProperties1_20_5.eatSeconds() != 1.6f) {
            compoundTag.put("eat_seconds", this.positiveFloatToTag(Float.valueOf(foodProperties1_20_5.eatSeconds())));
        }
        if (foodProperties1_20_5.possibleEffects().length > 0) {
            ListTag<CompoundTag> listTag = new ListTag<CompoundTag>(CompoundTag.class);
            for (FoodProperties1_20_5.FoodEffect foodEffect : foodProperties1_20_5.possibleEffects()) {
                CompoundTag compoundTag2 = new CompoundTag();
                CompoundTag compoundTag3 = new CompoundTag();
                this.potionEffectToTag(compoundTag3, foodEffect.effect());
                compoundTag2.put("effect", compoundTag3);
                if (foodEffect.probability() == 1.0f) continue;
                compoundTag2.putFloat("probability", foodEffect.probability());
            }
            compoundTag.put("effects", listTag);
        }
        return compoundTag;
    }

    protected FoodProperties1_20_5 foodFromTag(Tag tag) {
        CompoundTag compoundTag = (CompoundTag)tag;
        int n = this.checkNonNegativeInt(compoundTag.getInt("nutrition"));
        float f = compoundTag.getFloat("saturation");
        boolean bl = compoundTag.getBoolean("can_always_eat", false);
        float f2 = this.checkPositiveFloat(Float.valueOf(compoundTag.getFloat("eat_seconds", 1.6f))).floatValue();
        ListTag<CompoundTag> listTag = compoundTag.getListTag("effects", CompoundTag.class);
        ArrayList<FoodProperties1_20_5.FoodEffect> arrayList = new ArrayList<FoodProperties1_20_5.FoodEffect>();
        if (listTag != null) {
            for (CompoundTag compoundTag2 : listTag) {
                PotionEffect potionEffect = this.potionEffectFromTag(compoundTag2.getCompoundTag("effect"));
                float f3 = compoundTag2.getFloat("probability", 1.0f);
                arrayList.add(new FoodProperties1_20_5.FoodEffect(potionEffect, f3));
            }
        }
        return new FoodProperties1_20_5(n, f, bl, f2, null, (FoodProperties1_20_5.FoodEffect[])arrayList.toArray(FoodProperties1_20_5.FoodEffect[]::new));
    }

    protected CompoundTag fireResistantToTag(Unit unit) {
        return this.unitToTag();
    }

    protected Unit fireResistantFromTag(Tag tag) {
        return Unit.INSTANCE;
    }

    protected CompoundTag toolToTag(ToolProperties toolProperties) {
        CompoundTag compoundTag = new CompoundTag();
        ListTag<CompoundTag> listTag = new ListTag<CompoundTag>(CompoundTag.class);
        for (ToolRule toolRule : toolProperties.rules()) {
            CompoundTag compoundTag2 = new CompoundTag();
            this.holderSetToTag(compoundTag2, "blocks", toolRule.blocks());
            if (toolRule.speed() != null) {
                compoundTag2.putFloat("speed", toolRule.speed().floatValue());
            }
            if (toolRule.correctForDrops() != null) {
                compoundTag2.putBoolean("correct_for_drops", toolRule.correctForDrops());
            }
            listTag.add(compoundTag2);
        }
        compoundTag.put("rules", listTag);
        if (toolProperties.defaultMiningSpeed() != 1.0f) {
            compoundTag.putFloat("default_mining_speed", toolProperties.defaultMiningSpeed());
        }
        if (toolProperties.damagePerBlock() != 1) {
            compoundTag.put("damage_per_block", this.nonNegativeIntToTag(toolProperties.damagePerBlock()));
        }
        return compoundTag;
    }

    protected ToolProperties toolFromTag(Tag tag) {
        CompoundTag compoundTag = (CompoundTag)tag;
        ListTag<CompoundTag> listTag = compoundTag.getListTag("rules", CompoundTag.class);
        ArrayList<ToolRule> arrayList = new ArrayList<ToolRule>();
        if (listTag != null) {
            for (CompoundTag compoundTag2 : listTag) {
                HolderSet holderSet = this.holderSetFromTag(compoundTag2, "blocks");
                Float f = Float.valueOf(compoundTag2.getFloat("speed", 0.0f));
                Boolean bl = compoundTag2.getBoolean("correct_for_drops", false);
                arrayList.add(new ToolRule(holderSet, f, bl));
            }
        }
        float f = compoundTag.getFloat("default_mining_speed", 1.0f);
        int n = this.checkNonNegativeInt(compoundTag.getInt("damage_per_block", 1));
        return new ToolProperties((ToolRule[])arrayList.toArray(ToolRule[]::new), f, n);
    }

    protected CompoundTag storedEnchantmentsToTag(Enchantments enchantments) {
        return this.enchantmentsToTag(enchantments);
    }

    protected Enchantments storedEnchantmentsFromTag(Tag tag) {
        return this.enchantmentsFromTag(tag);
    }

    protected CompoundTag dyedColorToTag(DyedColor dyedColor) {
        CompoundTag compoundTag = new CompoundTag();
        compoundTag.putInt("rgb", dyedColor.rgb());
        if (!dyedColor.showInTooltip()) {
            compoundTag.putBoolean("show_in_tooltip", false);
        }
        return compoundTag;
    }

    protected DyedColor dyedColorFromTag(Tag tag) {
        CompoundTag compoundTag = (CompoundTag)tag;
        int n = compoundTag.getInt("rgb");
        boolean bl = compoundTag.getBoolean("show_in_tooltip", true);
        return new DyedColor(n, bl);
    }

    protected IntTag mapColorToTag(Integer n) {
        return new IntTag(n);
    }

    protected Integer mapColorFromTag(Tag tag) {
        return this.asInt(tag);
    }

    protected IntTag mapIdToTag(Integer n) {
        return new IntTag(n);
    }

    protected Integer mapIdFromTag(Tag tag) {
        return this.asInt(tag);
    }

    protected CompoundTag mapDecorationsToTag(CompoundTag compoundTag) {
        return compoundTag;
    }

    protected CompoundTag mapDecorationsFromTag(Tag tag) {
        return (CompoundTag)tag;
    }

    protected ListTag<CompoundTag> chargedProjectilesToTag(UserConnection userConnection, Item[] itemArray) {
        return this.itemArrayToTag(userConnection, itemArray);
    }

    protected Item[] chargedProjectilesFromTag(UserConnection userConnection, Tag tag) {
        ListTag listTag = (ListTag)tag;
        return this.itemArrayFromTag(userConnection, listTag);
    }

    protected ListTag<CompoundTag> bundleContentsToTag(UserConnection userConnection, Item[] itemArray) {
        return this.itemArrayToTag(userConnection, itemArray);
    }

    protected Item[] bundleContentsFromTag(UserConnection userConnection, Tag tag) {
        ListTag listTag = (ListTag)tag;
        return this.itemArrayFromTag(userConnection, listTag);
    }

    protected CompoundTag potionContentsToTag(PotionContents potionContents) {
        Object object;
        CompoundTag compoundTag = new CompoundTag();
        if (potionContents.potion() != null && (object = Potions1_20_5.idToKey(potionContents.potion())) != null) {
            compoundTag.putString("potion", (String)object);
        }
        if (potionContents.customColor() != null) {
            compoundTag.putInt("custom_color", potionContents.customColor());
        }
        object = new ListTag<CompoundTag>(CompoundTag.class);
        for (PotionEffect potionEffect : potionContents.customEffects()) {
            CompoundTag compoundTag2 = new CompoundTag();
            this.potionEffectToTag(compoundTag2, potionEffect);
            ((ListTag)object).add(compoundTag2);
        }
        if (!((ListTag)object).isEmpty()) {
            compoundTag.put("custom_effects", (Tag)object);
        }
        if (potionContents.customName() != null) {
            compoundTag.putString("custom_name", potionContents.customName());
        }
        return compoundTag;
    }

    protected PotionContents potionContentsFromTag(Tag tag) {
        CompoundTag compoundTag = (CompoundTag)tag;
        int n = Potions1_20_5.keyToId(compoundTag.getString("potion", ""));
        IntTag intTag = compoundTag.getIntTag("custom_color");
        ListTag<CompoundTag> listTag = compoundTag.getListTag("custom_effects", CompoundTag.class);
        ArrayList<PotionEffect> arrayList = new ArrayList<PotionEffect>();
        if (listTag != null) {
            for (CompoundTag compoundTag2 : listTag) {
                arrayList.add(this.potionEffectFromTag(compoundTag2));
            }
        }
        return new PotionContents(n != -1 ? Integer.valueOf(n) : null, intTag != null ? Integer.valueOf(intTag.asInt()) : null, (PotionEffect[])arrayList.toArray(PotionEffect[]::new));
    }

    protected ListTag<CompoundTag> suspiciousStewEffectsToTag(SuspiciousStewEffect[] suspiciousStewEffectArray) {
        ListTag<CompoundTag> listTag = new ListTag<CompoundTag>(CompoundTag.class);
        for (SuspiciousStewEffect suspiciousStewEffect : suspiciousStewEffectArray) {
            CompoundTag compoundTag = new CompoundTag();
            String string = PotionEffects1_20_5.idToKey(suspiciousStewEffect.mobEffect());
            if (string != null) {
                compoundTag.putString("id", string);
            }
            if (suspiciousStewEffect.duration() != 160) {
                compoundTag.putInt("duration", suspiciousStewEffect.duration());
            }
            listTag.add(compoundTag);
        }
        return listTag;
    }

    protected SuspiciousStewEffect[] suspiciousStewEffectsFromTag(Tag tag) {
        ListTag listTag = (ListTag)tag;
        ArrayList<SuspiciousStewEffect> arrayList = new ArrayList<SuspiciousStewEffect>();
        for (CompoundTag compoundTag : listTag) {
            int n = PotionEffects1_20_5.keyToId(compoundTag.getString("id", ""));
            int n2 = compoundTag.getInt("duration", 160);
            arrayList.add(new SuspiciousStewEffect(n, n2));
        }
        return (SuspiciousStewEffect[])arrayList.toArray(SuspiciousStewEffect[]::new);
    }

    protected CompoundTag writableBookContentToTag(WritableBook writableBook) {
        CompoundTag compoundTag = new CompoundTag();
        if (writableBook == null) {
            return compoundTag;
        }
        if (writableBook.pages().length > 100) {
            throw new IllegalArgumentException("Too many pages: " + writableBook.pages().length);
        }
        ListTag<CompoundTag> listTag = new ListTag<CompoundTag>(CompoundTag.class);
        for (FilterableString filterableString : writableBook.pages()) {
            CompoundTag compoundTag2 = new CompoundTag();
            this.filterableStringToTag(compoundTag2, filterableString, 1024);
            listTag.add(compoundTag2);
        }
        compoundTag.put("pages", listTag);
        return compoundTag;
    }

    protected WritableBook writableBookContentFromTag(Tag tag) {
        CompoundTag compoundTag = (CompoundTag)tag;
        ListTag<CompoundTag> listTag = compoundTag.getListTag("pages", CompoundTag.class);
        if (listTag == null) {
            return null;
        }
        FilterableString[] filterableStringArray = new FilterableString[listTag.size()];
        for (int i = 0; i < listTag.size(); ++i) {
            filterableStringArray[i] = this.filterableStringFromTag(listTag.get(i));
        }
        return new WritableBook(filterableStringArray);
    }

    protected CompoundTag writtenBookContentToTag(WrittenBook writtenBook) {
        CompoundTag compoundTag = new CompoundTag();
        CompoundTag compoundTag2 = new CompoundTag();
        this.filterableStringToTag(compoundTag2, writtenBook.title(), 32);
        compoundTag.put("title", compoundTag2);
        compoundTag.putString("author", writtenBook.author());
        if (writtenBook.generation() != 0) {
            compoundTag.put("generation", this.intRangeToTag(writtenBook.generation(), 0, 3));
        }
        ListTag<CompoundTag> listTag = new ListTag<CompoundTag>(CompoundTag.class);
        for (FilterableComponent filterableComponent : writtenBook.pages()) {
            CompoundTag compoundTag3 = new CompoundTag();
            this.filterableComponentToTag(compoundTag3, filterableComponent);
            listTag.add(compoundTag3);
        }
        if (!listTag.isEmpty()) {
            compoundTag.put("pages", listTag);
        }
        if (writtenBook.resolved()) {
            compoundTag.putBoolean("resolved", true);
        }
        return compoundTag;
    }

    protected WrittenBook writtenBookContentFromTag(Tag tag) {
        CompoundTag compoundTag = (CompoundTag)tag;
        FilterableString filterableString = this.filterableStringFromTag(compoundTag.getCompoundTag("title"));
        String string = compoundTag.getString("author");
        int n = this.checkIntRange(0, 3, compoundTag.getInt("generation", 0));
        ListTag<CompoundTag> listTag = compoundTag.getListTag("pages", CompoundTag.class);
        ArrayList<FilterableComponent> arrayList = new ArrayList<FilterableComponent>();
        if (listTag != null) {
            for (CompoundTag compoundTag2 : listTag) {
                arrayList.add(this.filterableComponentFromTag(compoundTag2));
            }
        }
        boolean bl = compoundTag.getBoolean("resolved", false);
        return new WrittenBook(filterableString, string, n, (FilterableComponent[])arrayList.toArray(FilterableComponent[]::new), bl);
    }

    protected CompoundTag trimToTag(UserConnection userConnection, ArmorTrim armorTrim) {
        Object object;
        Object object2;
        Object object3;
        Holder<ArmorTrimPattern> holder;
        CompoundTag compoundTag = new CompoundTag();
        Holder<ArmorTrimMaterial> holder2 = armorTrim.material();
        ArmorTrimStorage armorTrimStorage = userConnection.get(ArmorTrimStorage.class);
        if (holder2.hasId()) {
            holder = armorTrimStorage.trimMaterials().idToKey(holder2.id());
            compoundTag.putString("material", (String)((Object)holder));
        } else {
            holder = holder2.value();
            object3 = new CompoundTag();
            object2 = Protocol1_20_3To1_20_5.MAPPINGS.getFullItemMappings().identifier(((ArmorTrimMaterial)((Object)holder)).itemId());
            if (object2 == null) {
                throw new IllegalArgumentException("Unknown item: " + ((ArmorTrimMaterial)((Object)holder)).itemId());
            }
            object = new CompoundTag();
            for (Map.Entry<String, String> entry : ((ArmorTrimMaterial)((Object)holder)).overrideArmorMaterials().entrySet()) {
                String string = ArmorMaterials1_20_5.idToKey(Integer.parseInt(entry.getKey()));
                if (string == null) continue;
                ((CompoundTag)object).putString(string, entry.getValue());
            }
            ((CompoundTag)object3).putString("asset_name", ((ArmorTrimMaterial)((Object)holder)).assetName());
            ((CompoundTag)object3).putString("ingredient", (String)object2);
            ((CompoundTag)object3).putFloat("item_model_index", ((ArmorTrimMaterial)((Object)holder)).itemModelIndex());
            ((CompoundTag)object3).put("override_armor_materials", (Tag)object);
            ((CompoundTag)object3).put("description", ((ArmorTrimMaterial)((Object)holder)).description());
            compoundTag.put("material", (Tag)object3);
        }
        holder = armorTrim.pattern();
        if (holder.hasId()) {
            compoundTag.putString("pattern", armorTrimStorage.trimPatterns().idToKey(holder.id()));
        } else {
            object3 = holder.value();
            object2 = new CompoundTag();
            object = Protocol1_20_3To1_20_5.MAPPINGS.getFullItemMappings().identifier(((ArmorTrimPattern)object3).itemId());
            if (object == null) {
                throw new IllegalArgumentException("Unknown item: " + ((ArmorTrimPattern)object3).itemId());
            }
            ((CompoundTag)object2).put("asset_id", this.identifierToTag(((ArmorTrimPattern)object3).assetName()));
            ((CompoundTag)object2).putString("template_item", (String)object);
            ((CompoundTag)object2).put("description", ((ArmorTrimPattern)object3).description());
            if (((ArmorTrimPattern)object3).decal()) {
                ((CompoundTag)object2).putBoolean("decal", true);
            }
            compoundTag.put("pattern", (Tag)object2);
        }
        if (!armorTrim.showInTooltip()) {
            compoundTag.putBoolean("show_in_tooltip", false);
        }
        return compoundTag;
    }

    protected ArmorTrim trimFromTag(UserConnection userConnection, Tag tag) {
        Tag tag2;
        Object object;
        Holder<ArmorTrimPattern> holder;
        Holder<Object> holder2;
        Tag tag3;
        CompoundTag compoundTag = (CompoundTag)tag;
        Tag tag4 = compoundTag.get("material");
        ArmorTrimStorage armorTrimStorage = userConnection.get(ArmorTrimStorage.class);
        if (tag4 instanceof StringTag) {
            tag3 = (StringTag)tag4;
            holder2 = Holder.of(armorTrimStorage.trimMaterials().keyToId(tag3.getValue()));
        } else {
            holder = (CompoundTag)tag4;
            object = this.identifierFromTag(((CompoundTag)((Object)holder)).getStringTag("asset_name"));
            int n = Protocol1_20_3To1_20_5.MAPPINGS.getFullItemMappings().mappedId(((CompoundTag)((Object)holder)).getString("ingredient"));
            float f = ((CompoundTag)((Object)holder)).getFloat("item_model_index");
            HashMap<String, String> hashMap = new HashMap<String, String>();
            tag2 = ((CompoundTag)((Object)holder)).getCompoundTag("override_armor_materials");
            if (tag2 != null) {
                for (Map.Entry entry : tag2.entrySet()) {
                    hashMap.put((String)entry.getKey(), ((StringTag)entry.getValue()).getValue());
                }
            }
            Tag tag5 = ((CompoundTag)((Object)holder)).get("description");
            holder2 = Holder.of(new ArmorTrimMaterial((String)object, n, f, hashMap, tag5));
        }
        tag3 = compoundTag.get("pattern");
        if (tag3 instanceof StringTag) {
            object = tag3;
            holder = Holder.of(armorTrimStorage.trimPatterns().keyToId(((StringTag)object).getValue()));
        } else {
            CompoundTag compoundTag2 = (CompoundTag)tag3;
            String string = this.identifierFromTag(compoundTag2.getStringTag("asset_id"));
            int n = Protocol1_20_3To1_20_5.MAPPINGS.getFullItemMappings().mappedId(compoundTag2.getString("template_item"));
            tag2 = compoundTag2.get("description");
            boolean bl = compoundTag2.getBoolean("decal", false);
            holder = Holder.of(new ArmorTrimPattern(string, n, tag2, bl));
        }
        boolean bl = compoundTag.getBoolean("show_in_tooltip", true);
        return new ArmorTrim(holder2, holder, bl);
    }

    protected CompoundTag debugStickStateToTag(DebugStickState debugStickState) {
        return debugStickState.tag();
    }

    protected DebugStickState debugStickStateFromTag(Tag tag) {
        return new DebugStickState((CompoundTag)tag);
    }

    protected CompoundTag entityDataToTag(CompoundTag compoundTag) {
        return this.nbtWithIdToTag(compoundTag);
    }

    protected CompoundTag entityDataFromTag(Tag tag) {
        return (CompoundTag)tag;
    }

    protected CompoundTag bucketEntityDataToTag(CompoundTag compoundTag) {
        return this.nbtToTag(compoundTag);
    }

    protected CompoundTag bucketEntityDataFromTag(Tag tag) {
        return (CompoundTag)tag;
    }

    protected CompoundTag blockEntityDataToTag(CompoundTag compoundTag) {
        return this.nbtWithIdToTag(compoundTag);
    }

    protected CompoundTag blockEntityDataFromTag(Tag tag) {
        return (CompoundTag)tag;
    }

    protected Tag instrumentToTag(Holder<Instrument1_20_5> holder) {
        if (holder.hasId()) {
            return new StringTag(Instruments1_20_3.idToKey(holder.id()));
        }
        Instrument1_20_5 instrument1_20_5 = holder.value();
        CompoundTag compoundTag = new CompoundTag();
        Holder<SoundEvent> holder2 = instrument1_20_5.soundEvent();
        if (holder2.hasId()) {
            compoundTag.putString("sound_event", Protocol1_20_3To1_20_5.MAPPINGS.soundName(holder2.id()));
        } else {
            SoundEvent soundEvent = holder2.value();
            CompoundTag compoundTag2 = new CompoundTag();
            compoundTag2.put("sound_id", this.identifierToTag(soundEvent.identifier()));
            if (soundEvent.fixedRange() != null) {
                compoundTag2.putFloat("range", soundEvent.fixedRange().floatValue());
            }
            compoundTag.put("sound_event", compoundTag2);
        }
        compoundTag.put("use_duration", this.positiveIntToTag(instrument1_20_5.useDuration()));
        compoundTag.put("range", this.positiveFloatToTag(Float.valueOf(instrument1_20_5.range())));
        return compoundTag;
    }

    protected Holder<Instrument1_20_5> instrumentFromTag(Tag tag) {
        if (tag instanceof StringTag) {
            StringTag stringTag = (StringTag)tag;
            return Holder.of(Instruments1_20_3.keyToId(stringTag.getValue()));
        }
        CompoundTag compoundTag = (CompoundTag)tag;
        Holder<Object> holder = null;
        Tag tag2 = compoundTag.get("sound_event");
        if (tag2 instanceof StringTag) {
            StringTag stringTag = (StringTag)tag2;
            holder = Holder.of(Protocol1_20_3To1_20_5.MAPPINGS.soundId(stringTag.getValue()));
        } else if (tag2 instanceof CompoundTag) {
            CompoundTag compoundTag2 = (CompoundTag)tag2;
            String string = this.identifierFromTag(compoundTag2.getStringTag("sound_id"));
            Float f = Float.valueOf(compoundTag2.getFloat("range", 0.0f));
            holder = Holder.of(new SoundEvent(string, f));
        }
        int n = this.checkPositiveInt(compoundTag.getInt("use_duration"));
        float f = this.checkPositiveFloat(Float.valueOf(compoundTag.getFloat("range"))).floatValue();
        return Holder.of(new Instrument1_20_5(holder, n, f));
    }

    protected IntTag ominousBottleAmplifierToTag(Integer n) {
        return this.intRangeToTag(n, 0, 4);
    }

    protected Integer ominousBottleAmplifierFromTag(Tag tag) {
        return this.checkIntRange(0, 4, this.asInt(tag));
    }

    protected Tag recipesToTag(Tag tag) {
        return tag;
    }

    protected Tag recipesFromTag(Tag tag) {
        return tag;
    }

    protected CompoundTag lodestoneTrackerToTag(LodestoneTracker lodestoneTracker) {
        CompoundTag compoundTag = new CompoundTag();
        if (lodestoneTracker.position() != null) {
            this.globalPosToTag(compoundTag, lodestoneTracker.position());
        }
        if (!lodestoneTracker.tracked()) {
            compoundTag.putBoolean("tracked", false);
        }
        return compoundTag;
    }

    protected LodestoneTracker lodestoneTrackerFromTag(Tag tag) {
        CompoundTag compoundTag = (CompoundTag)tag;
        GlobalBlockPosition globalBlockPosition = this.globalPosFromTag(compoundTag);
        boolean bl = compoundTag.getBoolean("tracked", true);
        return new LodestoneTracker(globalBlockPosition, bl);
    }

    protected CompoundTag fireworkExplosionToTag(FireworkExplosion fireworkExplosion) {
        CompoundTag compoundTag = new CompoundTag();
        compoundTag.put("shape", this.enumEntryToTag(fireworkExplosion.shape(), "small_ball", "large_ball", "star", "creeper", "burst"));
        if (fireworkExplosion.colors().length > 0) {
            compoundTag.put("colors", new IntArrayTag(fireworkExplosion.colors()));
        }
        if (fireworkExplosion.fadeColors().length > 0) {
            compoundTag.put("fade_colors", new IntArrayTag(fireworkExplosion.fadeColors()));
        }
        if (fireworkExplosion.hasTrail()) {
            compoundTag.putBoolean("trail", true);
        }
        if (fireworkExplosion.hasTwinkle()) {
            compoundTag.putBoolean("twinkle", true);
        }
        return compoundTag;
    }

    protected FireworkExplosion fireworkExplosionFromTag(Tag tag) {
        CompoundTag compoundTag = (CompoundTag)tag;
        int n = this.enumEntryFromTag(compoundTag.getStringTag("shape"), "small_ball", "large_ball", "star", "creeper", "burst");
        IntArrayTag intArrayTag = compoundTag.getIntArrayTag("colors");
        IntArrayTag intArrayTag2 = compoundTag.getIntArrayTag("fade_colors");
        boolean bl = compoundTag.getBoolean("trail", false);
        boolean bl2 = compoundTag.getBoolean("twinkle", false);
        return new FireworkExplosion(n, intArrayTag == null ? new int[]{} : intArrayTag.getValue(), intArrayTag2 == null ? new int[]{} : intArrayTag2.getValue(), bl, bl2);
    }

    protected CompoundTag fireworksToTag(Fireworks fireworks) {
        CompoundTag compoundTag = new CompoundTag();
        if (fireworks.flightDuration() != 0) {
            compoundTag.put("flight_duration", this.unsignedByteToTag((byte)fireworks.flightDuration()));
        }
        ListTag<CompoundTag> listTag = new ListTag<CompoundTag>(CompoundTag.class);
        if (fireworks.explosions().length > 256) {
            throw new IllegalArgumentException("Too many explosions: " + fireworks.explosions().length);
        }
        for (FireworkExplosion fireworkExplosion : fireworks.explosions()) {
            listTag.add(this.fireworkExplosionToTag(fireworkExplosion));
        }
        compoundTag.put("explosions", listTag);
        return compoundTag;
    }

    protected Fireworks fireworksFromTag(Tag tag) {
        CompoundTag compoundTag = (CompoundTag)tag;
        short s = compoundTag.getShort("flight_duration");
        ListTag<CompoundTag> listTag = compoundTag.getListTag("explosions", CompoundTag.class);
        FireworkExplosion[] fireworkExplosionArray = new FireworkExplosion[listTag != null ? listTag.size() : 0];
        for (int i = 0; i < fireworkExplosionArray.length; ++i) {
            fireworkExplosionArray[i] = this.fireworkExplosionFromTag(listTag.get(i));
        }
        return new Fireworks(s, fireworkExplosionArray);
    }

    protected CompoundTag profileToTag(GameProfile gameProfile) {
        CompoundTag compoundTag = new CompoundTag();
        if (gameProfile.name() != null) {
            compoundTag.putString("name", gameProfile.name());
        }
        if (gameProfile.id() != null) {
            compoundTag.put("id", new IntArrayTag(UUIDUtil.toIntArray(gameProfile.id())));
        }
        if (gameProfile.properties().length > 0) {
            this.propertiesToTag(compoundTag, gameProfile.properties());
        }
        return compoundTag;
    }

    protected GameProfile profileFromTag(Tag tag) {
        CompoundTag compoundTag = (CompoundTag)tag;
        String string = compoundTag.getString("name");
        IntArrayTag intArrayTag = compoundTag.getIntArrayTag("id");
        UUID uUID = intArrayTag == null ? null : UUIDUtil.fromIntArray(intArrayTag.getValue());
        GameProfile.Property[] propertyArray = this.propertiesFromTag(compoundTag);
        return new GameProfile(string, uUID, propertyArray);
    }

    protected StringTag noteBlockSoundToTag(Key key) {
        return new StringTag(key.original());
    }

    protected Key noteBlockSoundFromTag(Tag tag) {
        return Key.of(((StringTag)tag).getValue());
    }

    protected ListTag<CompoundTag> bannerPatternsToTag(BannerPatternLayer[] bannerPatternLayerArray) {
        ListTag<CompoundTag> listTag = new ListTag<CompoundTag>(CompoundTag.class);
        for (BannerPatternLayer bannerPatternLayer : bannerPatternLayerArray) {
            CompoundTag compoundTag = new CompoundTag();
            this.bannerPatternToTag(compoundTag, bannerPatternLayer.pattern());
            compoundTag.put("color", this.dyeColorToTag(bannerPatternLayer.dyeColor()));
            listTag.add(compoundTag);
        }
        return listTag;
    }

    protected BannerPatternLayer[] bannerPatternsFromTag(Tag tag) {
        ListTag listTag = (ListTag)tag;
        BannerPatternLayer[] bannerPatternLayerArray = new BannerPatternLayer[listTag.size()];
        for (int i = 0; i < listTag.size(); ++i) {
            CompoundTag compoundTag = (CompoundTag)listTag.get(i);
            Holder<BannerPattern> holder = this.bannerPatternFromTag(compoundTag.get("pattern"));
            int n = this.dyeColorFromTag(compoundTag.get("color"));
            bannerPatternLayerArray[i] = new BannerPatternLayer(holder, n);
        }
        return bannerPatternLayerArray;
    }

    protected StringTag baseColorToTag(Integer n) {
        return this.dyeColorToTag(n);
    }

    protected Integer baseColorFromTag(Tag tag) {
        return this.dyeColorFromTag(tag);
    }

    protected ListTag<StringTag> potDecorationsToTag(PotDecorations potDecorations) {
        ListTag<StringTag> listTag = new ListTag<StringTag>(StringTag.class);
        for (int n : potDecorations.itemIds()) {
            String string = this.mappedIdentifier(n);
            if (string == null) {
                throw new IllegalArgumentException("Unknown item: " + n);
            }
            listTag.add(new StringTag(string));
        }
        return listTag;
    }

    protected PotDecorations potDecorationsFromTag(Tag tag) {
        ListTag listTag = (ListTag)tag;
        int[] nArray = new int[listTag.size()];
        for (int i = 0; i < listTag.size(); ++i) {
            String string = ((StringTag)listTag.get(i)).getValue();
            int n = this.mappedId(string);
            if (n == -1) {
                throw new IllegalArgumentException("Unknown item: " + string);
            }
            nArray[i] = n;
        }
        return new PotDecorations(nArray);
    }

    protected ListTag<CompoundTag> containerToTag(UserConnection userConnection, Item[] itemArray) {
        ListTag<CompoundTag> listTag = new ListTag<CompoundTag>(CompoundTag.class);
        for (int i = 0; i < itemArray.length; ++i) {
            Item item = itemArray[i];
            if (item.isEmpty()) continue;
            CompoundTag compoundTag = new CompoundTag();
            CompoundTag compoundTag2 = new CompoundTag();
            this.itemToTag(userConnection, compoundTag2, item);
            compoundTag.putInt("slot", i);
            compoundTag.put("item", compoundTag2);
            listTag.add(compoundTag);
        }
        return listTag;
    }

    protected Item[] containerFromTag(UserConnection userConnection, Tag tag) {
        int n;
        Item item;
        ListTag listTag = (ListTag)tag;
        int n2 = 0;
        int n3 = Math.min(listTag.size(), 256);
        for (int i = 0; i < n3; ++i) {
            CompoundTag compoundTag = (CompoundTag)listTag.get(i);
            item = this.itemFromTag(userConnection, compoundTag);
            if (item.isEmpty()) continue;
            n = compoundTag.getInt("slot");
            n2 = MathUtil.clamp(n, n2, 255);
        }
        Item[] itemArray = new Item[n2 + 1];
        for (CompoundTag compoundTag : listTag) {
            item = this.itemFromTag(userConnection, compoundTag.getCompoundTag("item"));
            if (item.isEmpty() || (n = compoundTag.getInt("slot")) < 0 || n >= itemArray.length) continue;
            itemArray[n] = item;
        }
        return itemArray;
    }

    protected CompoundTag blockStateToTag(BlockStateProperties blockStateProperties) {
        CompoundTag compoundTag = new CompoundTag();
        for (Map.Entry<String, String> entry : blockStateProperties.properties().entrySet()) {
            compoundTag.putString(entry.getKey(), entry.getValue());
        }
        return compoundTag;
    }

    protected BlockStateProperties blockStateFromTag(Tag tag) {
        CompoundTag compoundTag = (CompoundTag)tag;
        HashMap<String, String> hashMap = new HashMap<String, String>();
        for (Map.Entry<String, Tag> entry : compoundTag.entrySet()) {
            hashMap.put(entry.getKey(), ((StringTag)entry.getValue()).getValue());
        }
        return new BlockStateProperties(hashMap);
    }

    protected ListTag<CompoundTag> beesToTag(Bee[] beeArray) {
        ListTag<CompoundTag> listTag = new ListTag<CompoundTag>(CompoundTag.class);
        for (Bee bee : beeArray) {
            CompoundTag compoundTag = new CompoundTag();
            if (!bee.entityData().tag().isEmpty()) {
                compoundTag.put("entity_data", this.nbtToTag(bee.entityData().tag()));
            }
            compoundTag.putInt("ticks_in_hive", bee.ticksInHive());
            compoundTag.putInt("min_ticks_in_hive", bee.minTicksInHive());
        }
        return listTag;
    }

    protected Bee[] beesFromTag(Tag tag) {
        ListTag listTag = (ListTag)tag;
        Bee[] beeArray = new Bee[listTag.size()];
        for (int i = 0; i < listTag.size(); ++i) {
            CompoundTag compoundTag = (CompoundTag)listTag.get(i);
            CompoundTag compoundTag2 = compoundTag.getCompoundTag("entity_data");
            int n = compoundTag.getInt("ticks_in_hive");
            int n2 = compoundTag.getInt("min_ticks_in_hive");
            beeArray[i] = new Bee(compoundTag2 != null ? compoundTag2 : new CompoundTag(), n, n2);
        }
        return beeArray;
    }

    protected StringTag lockToTag(Tag tag) {
        return (StringTag)tag;
    }

    protected Tag lockFromTag(Tag tag) {
        return tag;
    }

    protected CompoundTag containerLootToTag(CompoundTag compoundTag) {
        return compoundTag;
    }

    protected CompoundTag containerLootFromTag(Tag tag) {
        return (CompoundTag)tag;
    }

    protected void modifierDataToTag(CompoundTag compoundTag, AttributeModifiers1_20_5.ModifierData modifierData) {
        compoundTag.put("uuid", new IntArrayTag(UUIDUtil.toIntArray(modifierData.uuid())));
        compoundTag.putString("name", modifierData.name());
        compoundTag.putDouble("amount", modifierData.amount());
        compoundTag.putString("operation", BlockItemPacketRewriter1_20_5.ATTRIBUTE_OPERATIONS[modifierData.operation()]);
    }

    protected AttributeModifiers1_20_5.ModifierData modifierDataFromTag(CompoundTag compoundTag) {
        int n;
        UUID uUID = UUIDUtil.fromIntArray(compoundTag.getIntArrayTag("uuid").getValue());
        String string = compoundTag.getString("name");
        double d = compoundTag.getDouble("amount");
        String string2 = compoundTag.getString("operation");
        for (n = 0; n < BlockItemPacketRewriter1_20_5.ATTRIBUTE_OPERATIONS.length && !BlockItemPacketRewriter1_20_5.ATTRIBUTE_OPERATIONS[n].equals(string2); ++n) {
        }
        return new AttributeModifiers1_20_5.ModifierData(uUID, string, d, n);
    }

    protected void potionEffectToTag(CompoundTag compoundTag, PotionEffect potionEffect) {
        String string = PotionEffects1_20_5.idToKey(potionEffect.effect());
        if (string == null) {
            throw new IllegalArgumentException("Unknown potion effect: " + potionEffect.effect());
        }
        compoundTag.putString("id", string);
        this.potionEffectDataToTag(compoundTag, potionEffect.effectData());
    }

    protected PotionEffect potionEffectFromTag(CompoundTag compoundTag) {
        int n = PotionEffects1_20_5.keyToId(compoundTag.getString("id"));
        if (n == -1) {
            return null;
        }
        PotionEffectData potionEffectData = this.potionEffectDataFromTag(compoundTag);
        return new PotionEffect(n, potionEffectData);
    }

    protected void potionEffectDataToTag(CompoundTag compoundTag, PotionEffectData potionEffectData) {
        if (potionEffectData.amplifier() != 0) {
            compoundTag.putInt("amplifier", potionEffectData.amplifier());
        }
        if (potionEffectData.duration() != 0) {
            compoundTag.putInt("duration", potionEffectData.duration());
        }
        if (potionEffectData.ambient()) {
            compoundTag.putBoolean("ambient", true);
        }
        if (!potionEffectData.showParticles()) {
            compoundTag.putBoolean("show_particles", false);
        }
        compoundTag.putBoolean("show_icon", potionEffectData.showIcon());
        if (potionEffectData.hiddenEffect() != null) {
            CompoundTag compoundTag2 = new CompoundTag();
            this.potionEffectDataToTag(compoundTag2, potionEffectData.hiddenEffect());
            compoundTag.put("hidden_effect", compoundTag2);
        }
    }

    protected PotionEffectData potionEffectDataFromTag(CompoundTag compoundTag) {
        int n = compoundTag.getInt("amplifier", 0);
        int n2 = compoundTag.getInt("duration", 0);
        boolean bl = compoundTag.getBoolean("ambient", false);
        boolean bl2 = compoundTag.getBoolean("show_particles", true);
        boolean bl3 = compoundTag.getBoolean("show_icon", true);
        CompoundTag compoundTag2 = compoundTag.getCompoundTag("hidden_effect");
        PotionEffectData potionEffectData = compoundTag2 != null ? this.potionEffectDataFromTag(compoundTag2) : null;
        return new PotionEffectData(n, n2, bl, bl2, bl3, potionEffectData);
    }

    protected void holderSetToTag(CompoundTag compoundTag, String string, HolderSet holderSet) {
        if (holderSet.hasTagKey()) {
            compoundTag.putString(string, holderSet.tagKey());
        } else {
            ListTag<StringTag> listTag = new ListTag<StringTag>(StringTag.class);
            for (int n : holderSet.ids()) {
                String string2 = Protocol1_20_3To1_20_5.MAPPINGS.blockName(n);
                if (string2 == null) continue;
                listTag.add(new StringTag(string2));
            }
            compoundTag.put(string, listTag);
        }
    }

    protected HolderSet holderSetFromTag(CompoundTag compoundTag, String string) {
        Tag tag = compoundTag.get(string);
        if (tag instanceof StringTag) {
            StringTag stringTag = (StringTag)tag;
            return HolderSet.of(stringTag.getValue());
        }
        if (tag instanceof ListTag) {
            ListTag listTag;
            ListTag listTag2 = listTag = (ListTag)tag;
            int[] nArray = new int[listTag2.size()];
            for (int i = 0; i < listTag2.size(); ++i) {
                String string2 = ((StringTag)listTag2.get(i)).getValue();
                int n = Protocol1_20_3To1_20_5.MAPPINGS.blockId(string2);
                if (n == -1) continue;
                nArray[i] = n;
            }
            return HolderSet.of(nArray);
        }
        return null;
    }

    protected ListTag<CompoundTag> itemArrayToTag(UserConnection userConnection, Item[] itemArray) {
        ListTag<CompoundTag> listTag = new ListTag<CompoundTag>(CompoundTag.class);
        for (Item item : itemArray) {
            CompoundTag compoundTag = new CompoundTag();
            this.itemToTag(userConnection, compoundTag, item);
            listTag.add(compoundTag);
        }
        return listTag;
    }

    protected Item[] itemArrayFromTag(UserConnection userConnection, ListTag<CompoundTag> listTag) {
        int n = Math.min(listTag.size(), 1024);
        Item[] itemArray = new Item[n];
        for (int i = 0; i < n; ++i) {
            itemArray[i] = this.itemFromTag(userConnection, listTag.get(i));
        }
        return itemArray;
    }

    protected void itemToTag(UserConnection userConnection, CompoundTag compoundTag, Item item) {
        String string = this.mappedIdentifier(item.identifier());
        if (string == null) {
            throw new IllegalArgumentException("Unknown item: " + item.identifier());
        }
        compoundTag.putString("id", string);
        try {
            compoundTag.put("count", this.positiveIntToTag(item.amount()));
        }
        catch (IllegalArgumentException illegalArgumentException) {
            compoundTag.putInt("count", 1);
        }
        Map<StructuredDataKey<?>, StructuredData<?>> map = item.dataContainer().data();
        CompoundTag compoundTag2 = this.toTag(userConnection, map);
        if (!compoundTag2.isEmpty()) {
            compoundTag.put("components", compoundTag2);
        }
    }

    protected Item itemFromTag(UserConnection userConnection, CompoundTag compoundTag) {
        int n = this.mappedId(compoundTag.getString("id", ""));
        int n2 = this.checkPositiveInt(compoundTag.getInt("count", 1));
        List<StructuredData<?>> list = this.toData(userConnection, compoundTag.getCompoundTag("components"));
        return new StructuredItem(n, n2, new StructuredDataContainer((StructuredData[])list.toArray(StructuredData[]::new)));
    }

    protected void filterableStringToTag(CompoundTag compoundTag, FilterableString filterableString, int n) {
        compoundTag.put("raw", this.stringToTag((String)filterableString.raw(), 0, n));
        if (filterableString.filtered() != null) {
            compoundTag.put("filtered", this.stringToTag((String)filterableString.filtered(), 0, n));
        }
    }

    protected FilterableString filterableStringFromTag(CompoundTag compoundTag) {
        if (compoundTag == null) {
            return null;
        }
        String string = this.checkStringRange(0, 1024, compoundTag.getString("raw"));
        StringTag stringTag = compoundTag.getStringTag("filtered");
        if (stringTag == null) {
            return new FilterableString(string, null);
        }
        return new FilterableString(string, this.checkStringRange(0, 1024, stringTag.getValue()));
    }

    protected void filterableComponentToTag(CompoundTag compoundTag, FilterableComponent filterableComponent) {
        compoundTag.put("raw", this.componentToTag((Tag)filterableComponent.raw()));
        if (filterableComponent.filtered() != null) {
            compoundTag.put("filtered", this.componentToTag((Tag)filterableComponent.filtered()));
        }
    }

    protected FilterableComponent filterableComponentFromTag(CompoundTag compoundTag) {
        if (compoundTag == null) {
            return null;
        }
        Tag tag = this.componentFromTag(compoundTag.get("raw"));
        Tag tag2 = this.componentFromTag(compoundTag.get("filtered"));
        return new FilterableComponent(tag, tag2);
    }

    protected void globalPosToTag(CompoundTag compoundTag, GlobalBlockPosition globalBlockPosition) {
        CompoundTag compoundTag2 = new CompoundTag();
        compoundTag2.putString("dimension", globalBlockPosition.dimension());
        compoundTag2.put("pos", new IntArrayTag(new int[]{globalBlockPosition.x(), globalBlockPosition.y(), globalBlockPosition.z()}));
        compoundTag.put("target", compoundTag2);
    }

    protected GlobalBlockPosition globalPosFromTag(CompoundTag compoundTag) {
        CompoundTag compoundTag2 = compoundTag.getCompoundTag("target");
        if (compoundTag2 == null) {
            return null;
        }
        String string = compoundTag2.getString("dimension");
        int[] nArray = compoundTag2.getIntArrayTag("pos").getValue();
        return new GlobalBlockPosition(string, nArray[0], nArray[1], nArray[2]);
    }

    protected void propertiesToTag(CompoundTag compoundTag, GameProfile.Property[] propertyArray) {
        ListTag<CompoundTag> listTag = new ListTag<CompoundTag>(CompoundTag.class);
        for (GameProfile.Property property : propertyArray) {
            CompoundTag compoundTag2 = new CompoundTag();
            compoundTag2.putString("name", property.name());
            compoundTag2.putString("value", property.value());
            if (property.signature() != null) {
                compoundTag2.putString("signature", property.signature());
            }
            listTag.add(compoundTag2);
        }
        compoundTag.put("properties", listTag);
    }

    protected GameProfile.Property[] propertiesFromTag(CompoundTag compoundTag) {
        ListTag<CompoundTag> listTag = compoundTag.getListTag("properties", CompoundTag.class);
        if (listTag == null) {
            return new GameProfile.Property[0];
        }
        GameProfile.Property[] propertyArray = new GameProfile.Property[listTag.size()];
        for (int i = 0; i < listTag.size(); ++i) {
            CompoundTag compoundTag2 = listTag.get(i);
            String string = compoundTag2.getString("name");
            String string2 = compoundTag2.getString("value");
            String string3 = compoundTag2.getString("signature", null);
            propertyArray[i] = new GameProfile.Property(string, string2, string3);
        }
        return propertyArray;
    }

    protected void bannerPatternToTag(CompoundTag compoundTag, Holder<BannerPattern> holder) {
        if (holder.hasId()) {
            compoundTag.putString("pattern", BannerPatterns1_20_5.idToKey(holder.id()));
            return;
        }
        BannerPattern bannerPattern = holder.value();
        CompoundTag compoundTag2 = new CompoundTag();
        compoundTag2.put("asset_id", this.identifierToTag(bannerPattern.assetId()));
        compoundTag2.putString("translation_key", bannerPattern.translationKey());
        compoundTag.put("pattern", compoundTag2);
    }

    protected Holder<BannerPattern> bannerPatternFromTag(Tag tag) {
        if (tag instanceof StringTag) {
            StringTag stringTag = (StringTag)tag;
            return Holder.of(BannerPatterns1_20_5.keyToId(stringTag.getValue()));
        }
        if (tag instanceof CompoundTag) {
            CompoundTag compoundTag = (CompoundTag)tag;
            String string = this.identifierFromTag(compoundTag.getStringTag("asset_id"));
            String string2 = compoundTag.getString("translation_key");
            return Holder.of(new BannerPattern(string, string2));
        }
        return null;
    }

    protected Integer asInt(Tag tag) {
        return ((NumberTag)tag).asInt();
    }

    protected Boolean asBoolean(Tag tag) {
        return ((ByteTag)tag).asByte() != 0;
    }

    protected Short asUnsignedByte(Tag tag) {
        return ((ByteTag)tag).asShort();
    }

    protected IntTag positiveIntToTag(Integer n) {
        return this.intRangeToTag(n, 1, Integer.MAX_VALUE);
    }

    protected Integer checkPositiveInt(Integer n) {
        return this.checkIntRange(1, Integer.MAX_VALUE, n);
    }

    protected IntTag nonNegativeIntToTag(Integer n) {
        return this.intRangeToTag(n, 0, Integer.MAX_VALUE);
    }

    protected Integer checkNonNegativeInt(Integer n) {
        return this.checkIntRange(0, Integer.MAX_VALUE, n);
    }

    protected IntTag intRangeToTag(Integer n, int n2, int n3) {
        return new IntTag(this.checkIntRange(n2, n3, n));
    }

    protected FloatTag positiveFloatToTag(Float f) {
        return this.floatRangeToTag(f, 0.0f, Float.MAX_VALUE);
    }

    protected FloatTag floatRangeToTag(Float f, float f2, float f3) {
        return new FloatTag(this.checkFloatRange(f2, f3, f.floatValue()));
    }

    protected Float checkPositiveFloat(Float f) {
        return Float.valueOf(this.checkFloatRange(0.0f, Float.MAX_VALUE, f.floatValue()));
    }

    protected StringTag stringToTag(String string, int n, int n2) {
        return new StringTag(this.checkStringRange(n, n2, string));
    }

    protected ByteTag unsignedByteToTag(byte by) {
        if (by > 255) {
            throw new IllegalArgumentException("Value out of range: " + by);
        }
        return new ByteTag(by);
    }

    protected StringTag componentToTag(Tag tag) {
        return this.componentToTag(tag, Integer.MAX_VALUE);
    }

    protected Tag componentFromTag(Tag tag) {
        return this.componentFromTag(tag, Integer.MAX_VALUE);
    }

    protected StringTag componentToTag(Tag tag, int n) {
        String string = this.outputSerializerVersion().toString(this.outputSerializerVersion().toComponent(tag));
        return new StringTag(this.checkStringRange(0, n, string));
    }

    protected Tag componentFromTag(Tag tag, int n) {
        if (tag instanceof StringTag) {
            StringTag stringTag = (StringTag)tag;
            String string = this.checkStringRange(0, n, stringTag.getValue());
            return this.inputSerializerVersion().toTag(this.inputSerializerVersion().toComponent(string));
        }
        return null;
    }

    protected ListTag<StringTag> componentsToTag(Tag[] tagArray, int n) {
        this.checkIntRange(0, n, tagArray.length);
        ListTag<StringTag> listTag = new ListTag<StringTag>(StringTag.class);
        for (Tag tag : tagArray) {
            String string = this.outputSerializerVersion().toString(this.outputSerializerVersion().toComponent(tag));
            listTag.add(new StringTag(string));
        }
        return listTag;
    }

    protected Tag[] componentsFromTag(Tag tag, int n) {
        ListTag listTag = (ListTag)tag;
        this.checkIntRange(0, n, listTag.size());
        Tag[] tagArray = new Tag[listTag.size()];
        for (int i = 0; i < listTag.size(); ++i) {
            tagArray[i] = this.inputSerializerVersion().toTag(this.inputSerializerVersion().toComponent(((StringTag)listTag.get(i)).getValue()));
        }
        return tagArray;
    }

    protected StringTag enumEntryToTag(Integer n, String ... stringArray) {
        Preconditions.checkArgument(n >= 0 && n < stringArray.length, "Enum value out of range: " + n);
        return new StringTag(stringArray[n]);
    }

    protected Integer enumEntryFromTag(StringTag stringTag, String ... stringArray) {
        String string = stringTag.getValue();
        for (int i = 0; i < stringArray.length; ++i) {
            if (!stringArray[i].equals(string)) continue;
            return i;
        }
        throw new IllegalArgumentException("Unknown enum value: " + string);
    }

    protected CompoundTag unitToTag() {
        return new CompoundTag();
    }

    protected CompoundTag nbtToTag(CompoundTag compoundTag) {
        return compoundTag;
    }

    protected CompoundTag nbtWithIdToTag(CompoundTag compoundTag) {
        if (compoundTag.getStringTag("id") == null) {
            throw new IllegalArgumentException("Missing id tag in nbt: " + String.valueOf(compoundTag));
        }
        return compoundTag;
    }

    protected StringTag identifierToTag(String string) {
        if (!Key.isValid(string)) {
            throw new IllegalArgumentException("Invalid identifier: " + string);
        }
        return new StringTag(string);
    }

    protected String identifierFromTag(StringTag stringTag) {
        String string = stringTag.getValue();
        if (!Key.isValid(string)) {
            throw new IllegalArgumentException("Invalid identifier: " + string);
        }
        return string;
    }

    protected StringTag dyeColorToTag(Integer n) {
        return new StringTag(DyeColors.idToKey(n));
    }

    protected Integer dyeColorFromTag(Tag tag) {
        return DyeColors.keyToId(((StringTag)tag).getValue());
    }

    protected int checkIntRange(int n, int n2, int n3) {
        Preconditions.checkArgument(n3 >= n && n3 <= n2, "Value out of range: " + n3);
        return n3;
    }

    protected float checkFloatRange(float f, float f2, float f3) {
        Preconditions.checkArgument(f3 >= f && f3 <= f2, "Value out of range: " + f3);
        return f3;
    }

    protected String checkStringRange(int n, int n2, String string) {
        int n3 = string.length();
        Preconditions.checkArgument(n3 >= n && n3 <= n2, "Value out of range: " + string);
        return string;
    }

    protected <T> void registerEmpty(StructuredDataKey<T> structuredDataKey) {
        this.converters.put(structuredDataKey, new ConverterPair(null, null));
    }

    protected <T> void register(StructuredDataKey<T> structuredDataKey, SimpleDataConverter<T> simpleDataConverter, SimpleTagConverter<T> simpleTagConverter) {
        DataConverter<Object> dataConverter = (userConnection, object) -> simpleDataConverter.convert(object);
        this.converters.put(structuredDataKey, new ConverterPair<Object>(dataConverter, (userConnection, tag) -> simpleTagConverter.convert(tag)));
    }

    protected <T> void register(StructuredDataKey<T> structuredDataKey, DataConverter<T> dataConverter, TagConverter<T> tagConverter) {
        this.converters.put(structuredDataKey, new ConverterPair<T>(dataConverter, tagConverter));
    }

    protected <T> @Nullable DataConverter<T> dataConverter(StructuredDataKey<T> structuredDataKey) {
        ConverterPair<?> converterPair = this.converters.get(structuredDataKey);
        return converterPair != null ? converterPair.dataConverter : null;
    }

    protected <T> @Nullable TagConverter<T> tagConverter(StructuredDataKey<T> structuredDataKey) {
        ConverterPair<?> converterPair = this.converters.get(structuredDataKey);
        return converterPair != null ? converterPair.tagConverter : null;
    }

    @Override
    protected @Nullable SerializerVersion inputSerializerVersion() {
        return SerializerVersion.V1_20_3;
    }

    @Override
    protected @Nullable SerializerVersion outputSerializerVersion() {
        return SerializerVersion.V1_20_5;
    }

    @FunctionalInterface
    protected static interface SimpleDataConverter<T> {
        public Tag convert(T var1);
    }

    @FunctionalInterface
    protected static interface SimpleTagConverter<T> {
        public T convert(Tag var1);
    }

    @FunctionalInterface
    protected static interface DataConverter<T> {
        public Tag convert(UserConnection var1, T var2);
    }

    @FunctionalInterface
    protected static interface TagConverter<T> {
        public T convert(UserConnection var1, Tag var2);
    }

    protected record ConverterPair<T>(DataConverter<T> dataConverter, TagConverter<T> tagConverter) {
    }
}

