/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_20_3to1_20_5.rewriter;

import com.google.common.base.Preconditions;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.FloatTag;
import com.viaversion.nbt.tag.IntArrayTag;
import com.viaversion.nbt.tag.IntTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.GameProfile;
import com.viaversion.viaversion.api.minecraft.HolderSet;
import com.viaversion.viaversion.api.minecraft.SoundEvent;
import com.viaversion.viaversion.api.minecraft.data.StructuredData;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.minecraft.item.data.AdventureModePredicate;
import com.viaversion.viaversion.api.minecraft.item.data.ArmorTrimMaterial;
import com.viaversion.viaversion.api.minecraft.item.data.ArmorTrimPattern;
import com.viaversion.viaversion.api.minecraft.item.data.AttributeModifiers1_20_5;
import com.viaversion.viaversion.api.minecraft.item.data.BannerPattern;
import com.viaversion.viaversion.api.minecraft.item.data.BannerPatternLayer;
import com.viaversion.viaversion.api.minecraft.item.data.Bee;
import com.viaversion.viaversion.api.minecraft.item.data.BlockPredicate;
import com.viaversion.viaversion.api.minecraft.item.data.Enchantments;
import com.viaversion.viaversion.api.minecraft.item.data.FilterableComponent;
import com.viaversion.viaversion.api.minecraft.item.data.FilterableString;
import com.viaversion.viaversion.api.minecraft.item.data.FireworkExplosion;
import com.viaversion.viaversion.api.minecraft.item.data.FoodProperties1_20_5;
import com.viaversion.viaversion.api.minecraft.item.data.Instrument1_20_5;
import com.viaversion.viaversion.api.minecraft.item.data.PotionEffect;
import com.viaversion.viaversion.api.minecraft.item.data.PotionEffectData;
import com.viaversion.viaversion.api.minecraft.item.data.StatePropertyMatcher;
import com.viaversion.viaversion.api.minecraft.item.data.SuspiciousStewEffect;
import com.viaversion.viaversion.api.minecraft.item.data.ToolRule;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntMap;
import com.viaversion.viaversion.libs.fastutil.objects.Reference2ObjectOpenHashMap;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.Protocol1_20_3To1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.data.Attributes1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.data.BannerPatterns1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.data.Enchantments1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.data.EquipmentSlots1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.data.Instruments1_20_3;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.data.MapDecorations1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.data.PotionEffects1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.data.Potions1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.rewriter.BlockItemPacketRewriter1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.storage.ArmorTrimStorage;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.storage.BannerPatternStorage;
import com.viaversion.viaversion.util.ComponentUtil;
import com.viaversion.viaversion.util.UUIDUtil;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.Nullable;

public class StructuredDataConverter {
    static final int HIDE_ENCHANTMENTS = 1;
    static final int HIDE_ATTRIBUTES = 2;
    static final int HIDE_UNBREAKABLE = 4;
    static final int HIDE_CAN_DESTROY = 8;
    static final int HIDE_CAN_PLACE_ON = 16;
    static final int HIDE_ADDITIONAL = 32;
    static final int HIDE_DYE_COLOR = 64;
    static final int HIDE_ARMOR_TRIM = 128;
    private static final String BACKUP_TAG_KEY = "VV|DataComponents";
    private static final String ITEM_BACKUP_TAG_KEY = "VV|Id";
    private final Map<StructuredDataKey<?>, DataConverter<?>> rewriters = new Reference2ObjectOpenHashMap();
    private final boolean backupInconvertibleData;

    public StructuredDataConverter(boolean bl) {
        this.backupInconvertibleData = bl;
        this.register(StructuredDataKey.CUSTOM_DATA, (T compoundTag, CompoundTag compoundTag2) -> {});
        this.register(StructuredDataKey.DAMAGE, (T n, CompoundTag compoundTag) -> compoundTag.putInt("Damage", (int)n));
        this.register(StructuredDataKey.UNBREAKABLE1_20_5, (T unbreakable, CompoundTag compoundTag) -> {
            compoundTag.putBoolean("Unbreakable", true);
            if (!unbreakable.showInTooltip()) {
                this.putHideFlag(compoundTag, 4);
            }
        });
        this.register(StructuredDataKey.CUSTOM_NAME, (T tag, CompoundTag compoundTag) -> StructuredDataConverter.getDisplayTag(compoundTag).putString("Name", ComponentUtil.tagToJsonString(tag)));
        this.register(StructuredDataKey.ITEM_NAME, (T tag, CompoundTag compoundTag) -> {
            CompoundTag compoundTag2 = StructuredDataConverter.getDisplayTag(compoundTag);
            if (!compoundTag2.contains("Name")) {
                CompoundTag compoundTag3 = new CompoundTag();
                compoundTag3.putBoolean("italic", false);
                compoundTag3.putString("text", "");
                compoundTag3.put("extra", new ListTag<Tag>(Collections.singletonList(tag)));
                compoundTag2.putString("Name", ComponentUtil.tagToJsonString(compoundTag3));
            }
        });
        this.register(StructuredDataKey.LORE, (T tagArray, CompoundTag compoundTag) -> {
            ListTag<StringTag> listTag = new ListTag<StringTag>(StringTag.class);
            for (Tag tag : tagArray) {
                listTag.add(new StringTag(ComponentUtil.tagToJsonString(tag)));
            }
            StructuredDataConverter.getDisplayTag(compoundTag).put("Lore", listTag);
        });
        this.register(StructuredDataKey.ENCHANTMENTS1_20_5, (T enchantments, CompoundTag compoundTag) -> this.convertEnchantments((Enchantments)enchantments, compoundTag, false));
        this.register(StructuredDataKey.STORED_ENCHANTMENTS1_20_5, (T enchantments, CompoundTag compoundTag) -> this.convertEnchantments((Enchantments)enchantments, compoundTag, true));
        this.register(StructuredDataKey.ATTRIBUTE_MODIFIERS1_20_5, (T attributeModifiers1_20_5, CompoundTag compoundTag) -> {
            ListTag<CompoundTag> listTag = new ListTag<CompoundTag>(CompoundTag.class);
            for (int i = 0; i < attributeModifiers1_20_5.modifiers().length; ++i) {
                AttributeModifiers1_20_5.AttributeModifier attributeModifier = attributeModifiers1_20_5.modifiers()[i];
                String string = Attributes1_20_5.idToKey(attributeModifier.attribute());
                if (string == null) continue;
                CompoundTag compoundTag2 = new CompoundTag();
                compoundTag2.put("UUID", new IntArrayTag(UUIDUtil.toIntArray(attributeModifier.modifier().uuid())));
                compoundTag2.putString("AttributeName", string.equals("generic.jump_strength") ? "horse.jump_strength" : string);
                compoundTag2.putString("Name", attributeModifier.modifier().name());
                compoundTag2.putDouble("Amount", attributeModifier.modifier().amount());
                if (attributeModifier.slotType() != 0) {
                    compoundTag2.putString("Slot", EquipmentSlots1_20_5.idToKey(attributeModifier.slotType()));
                }
                compoundTag2.putInt("Operation", attributeModifier.modifier().operation());
                listTag.add(compoundTag2);
            }
            compoundTag.put("AttributeModifiers", listTag);
            if (!attributeModifiers1_20_5.showInTooltip()) {
                this.putHideFlag(compoundTag, 2);
            }
        });
        this.register(StructuredDataKey.CUSTOM_MODEL_DATA1_20_5, (T n, CompoundTag compoundTag) -> compoundTag.putInt("CustomModelData", (int)n));
        this.register(StructuredDataKey.HIDE_ADDITIONAL_TOOLTIP, (T unit, CompoundTag compoundTag) -> this.putHideFlag(compoundTag, 32));
        this.register(StructuredDataKey.REPAIR_COST, (T n, CompoundTag compoundTag) -> compoundTag.putInt("RepairCost", (int)n));
        this.register(StructuredDataKey.DYED_COLOR1_20_5, (T dyedColor, CompoundTag compoundTag) -> {
            StructuredDataConverter.getDisplayTag(compoundTag).putInt("color", dyedColor.rgb());
            if (!dyedColor.showInTooltip()) {
                this.putHideFlag(compoundTag, 64);
            }
        });
        this.register(StructuredDataKey.MAP_COLOR, (T n, CompoundTag compoundTag) -> StructuredDataConverter.getDisplayTag(compoundTag).putInt("MapColor", (int)n));
        this.register(StructuredDataKey.MAP_ID, (T n, CompoundTag compoundTag) -> compoundTag.putInt("map", (int)n));
        this.register(StructuredDataKey.MAP_DECORATIONS, (T compoundTag, CompoundTag compoundTag2) -> {
            ListTag<CompoundTag> listTag = new ListTag<CompoundTag>(CompoundTag.class);
            for (Map.Entry<String, Tag> entry : compoundTag.entrySet()) {
                CompoundTag compoundTag3 = (CompoundTag)entry.getValue();
                int n = MapDecorations1_20_5.keyToId(compoundTag3.getString("type"));
                if (n == -1) continue;
                CompoundTag compoundTag4 = new CompoundTag();
                compoundTag4.putString("id", entry.getKey());
                compoundTag4.putInt("type", n);
                compoundTag4.putDouble("x", compoundTag3.getDouble("x"));
                compoundTag4.putDouble("z", compoundTag3.getDouble("z"));
                compoundTag4.putFloat("rot", compoundTag3.getFloat("rotation"));
                listTag.add(compoundTag4);
            }
            compoundTag2.put("Decorations", listTag);
        });
        this.register(StructuredDataKey.WRITABLE_BOOK_CONTENT, (T writableBook, CompoundTag compoundTag) -> {
            ListTag<StringTag> listTag = new ListTag<StringTag>(StringTag.class);
            CompoundTag compoundTag2 = new CompoundTag();
            for (int i = 0; i < writableBook.pages().length; ++i) {
                FilterableString filterableString = writableBook.pages()[i];
                listTag.add(new StringTag((String)filterableString.raw()));
                if (filterableString.filtered() == null) continue;
                compoundTag2.putString(Integer.toString(i), (String)filterableString.filtered());
            }
            compoundTag.put("pages", listTag);
            compoundTag.put("filtered_pages", compoundTag2);
        });
        this.register(StructuredDataKey.WRITTEN_BOOK_CONTENT, (T writtenBook, CompoundTag compoundTag) -> {
            ListTag<StringTag> listTag = new ListTag<StringTag>(StringTag.class);
            CompoundTag compoundTag2 = new CompoundTag();
            for (int i = 0; i < writtenBook.pages().length; ++i) {
                FilterableComponent filterableComponent = writtenBook.pages()[i];
                listTag.add(new StringTag(ComponentUtil.tagToJsonString((Tag)filterableComponent.raw())));
                if (filterableComponent.filtered() == null) continue;
                compoundTag2.putString(Integer.toString(i), ComponentUtil.tagToJsonString((Tag)filterableComponent.filtered()));
            }
            compoundTag.put("pages", listTag);
            compoundTag.put("filtered_pages", compoundTag2);
            compoundTag.putString("author", writtenBook.author());
            compoundTag.putInt("generation", writtenBook.generation());
            compoundTag.putBoolean("resolved", writtenBook.resolved());
            compoundTag.putString("title", (String)writtenBook.title().raw());
            if (writtenBook.title().filtered() != null) {
                compoundTag.putString("filtered_title", (String)writtenBook.title().filtered());
            }
        });
        this.register(StructuredDataKey.BASE_COLOR, (T n, CompoundTag compoundTag) -> StructuredDataConverter.getBlockEntityTag(compoundTag).putInt("Base", (int)n));
        this.register(StructuredDataKey.V1_20_5.chargedProjectiles, (UserConnection userConnection, T itemArray, CompoundTag compoundTag) -> {
            this.convertItemList(userConnection, (Item[])itemArray, compoundTag, "ChargedProjectiles");
            if (((Item[])itemArray).length != 0) {
                compoundTag.putBoolean("Charged", true);
            }
        });
        this.register(StructuredDataKey.V1_20_5.bundleContents, (UserConnection userConnection, T itemArray, CompoundTag compoundTag) -> this.convertItemList(userConnection, (Item[])itemArray, compoundTag, "Items"));
        this.register(StructuredDataKey.LODESTONE_TRACKER, (T lodestoneTracker, CompoundTag compoundTag) -> {
            compoundTag.putBoolean("LodestoneTracked", lodestoneTracker.tracked());
            if (lodestoneTracker.position() != null) {
                CompoundTag compoundTag2 = new CompoundTag();
                compoundTag2.putInt("X", lodestoneTracker.position().x());
                compoundTag2.putInt("Y", lodestoneTracker.position().y());
                compoundTag2.putInt("Z", lodestoneTracker.position().z());
                compoundTag.put("LodestonePos", compoundTag2);
                compoundTag.putString("LodestoneDimension", lodestoneTracker.position().dimension());
            } else {
                compoundTag.putString("LodestoneDimension", "viaversion:viaversion");
            }
        });
        this.register(StructuredDataKey.FIREWORKS, (T fireworks, CompoundTag compoundTag) -> {
            CompoundTag compoundTag2 = new CompoundTag();
            compoundTag2.putByte("Flight", (byte)fireworks.flightDuration());
            compoundTag.put("Fireworks", compoundTag2);
            if (fireworks.explosions().length > 0) {
                ListTag<CompoundTag> listTag = new ListTag<CompoundTag>(CompoundTag.class);
                for (FireworkExplosion fireworkExplosion : fireworks.explosions()) {
                    listTag.add(this.convertExplosion(fireworkExplosion));
                }
                compoundTag2.put("Explosions", listTag);
            }
        });
        this.register(StructuredDataKey.FIREWORK_EXPLOSION, (T fireworkExplosion, CompoundTag compoundTag) -> compoundTag.put("Explosion", this.convertExplosion((FireworkExplosion)fireworkExplosion)));
        this.register(StructuredDataKey.PROFILE1_20_5, (T gameProfile, CompoundTag compoundTag) -> {
            if (gameProfile.name() != null && gameProfile.id() == null && gameProfile.properties().length == 0) {
                compoundTag.putString("SkullOwner", gameProfile.name());
                return;
            }
            CompoundTag compoundTag2 = new CompoundTag();
            compoundTag.put("SkullOwner", compoundTag2);
            if (gameProfile.name() != null) {
                compoundTag2.putString("Name", gameProfile.name());
            }
            if (gameProfile.id() != null) {
                compoundTag2.put("Id", new IntArrayTag(UUIDUtil.toIntArray(gameProfile.id())));
            }
            CompoundTag compoundTag3 = new CompoundTag();
            for (GameProfile.Property property : gameProfile.properties()) {
                ListTag<CompoundTag> listTag = compoundTag3.getListTag(property.name(), CompoundTag.class);
                if (listTag == null) {
                    listTag = new ListTag<CompoundTag>(CompoundTag.class);
                }
                CompoundTag compoundTag4 = new CompoundTag();
                compoundTag4.putString("Value", property.value());
                if (property.signature() != null) {
                    compoundTag4.putString("Signature", property.signature());
                }
                listTag.add(compoundTag4);
                compoundTag3.put(property.name(), listTag);
            }
            compoundTag2.put("Properties", compoundTag3);
        });
        this.register(StructuredDataKey.INSTRUMENT1_20_5, (T holder, CompoundTag compoundTag) -> {
            if (!holder.hasId()) {
                if (bl) {
                    CompoundTag compoundTag2 = new CompoundTag();
                    Instrument1_20_5 instrument1_20_5 = (Instrument1_20_5)holder.value();
                    if (instrument1_20_5.soundEvent().hasId()) {
                        compoundTag2.putInt("sound_event", instrument1_20_5.soundEvent().id());
                    } else {
                        CompoundTag compoundTag3 = new CompoundTag();
                        SoundEvent soundEvent = instrument1_20_5.soundEvent().value();
                        compoundTag3.putString("identifier", soundEvent.identifier());
                        if (soundEvent.fixedRange() != null) {
                            compoundTag3.putFloat("fixed_range", soundEvent.fixedRange().floatValue());
                        }
                        compoundTag2.put("sound_event", compoundTag3);
                    }
                    compoundTag2.putInt("use_duration", instrument1_20_5.useDuration());
                    compoundTag2.putFloat("range", instrument1_20_5.range());
                    StructuredDataConverter.getBackupTag(compoundTag).put("instrument", compoundTag2);
                }
                return;
            }
            String string = Instruments1_20_3.idToKey(holder.id());
            if (string != null) {
                compoundTag.putString("instrument", string);
            }
        });
        this.register(StructuredDataKey.BEES1_20_5, (T beeArray, CompoundTag compoundTag) -> {
            ListTag<CompoundTag> listTag = new ListTag<CompoundTag>(CompoundTag.class);
            for (Bee bee : beeArray) {
                CompoundTag compoundTag2 = new CompoundTag();
                compoundTag2.put("EntityData", bee.entityData().tag());
                compoundTag2.putInt("TicksInHive", bee.ticksInHive());
                compoundTag2.putInt("MinOccupationTicks", bee.minTicksInHive());
                listTag.add(compoundTag2);
            }
            this.getBlockEntityTag(compoundTag, "beehive").put("Bees", listTag);
        });
        this.register(StructuredDataKey.LOCK1_20_5, (T tag, CompoundTag compoundTag) -> StructuredDataConverter.getBlockEntityTag(compoundTag).put("Lock", (Tag)tag));
        this.register(StructuredDataKey.NOTE_BLOCK_SOUND, (T key, CompoundTag compoundTag) -> this.getBlockEntityTag(compoundTag, "player_head").putString("note_block_sound", key.original()));
        this.register(StructuredDataKey.POT_DECORATIONS, (T potDecorations, CompoundTag compoundTag) -> {
            IntArrayTag intArrayTag = null;
            ListTag<StringTag> listTag = new ListTag<StringTag>(StringTag.class);
            for (int n : potDecorations.itemIds()) {
                String string = this.toMappedItemName(n);
                if (string.isEmpty()) {
                    if (!bl || intArrayTag != null) continue;
                    intArrayTag = new IntArrayTag(potDecorations.itemIds());
                    continue;
                }
                listTag.add(new StringTag(string));
            }
            if (intArrayTag != null) {
                StructuredDataConverter.getBackupTag(compoundTag).put("pot_decorations", intArrayTag);
            }
            this.getBlockEntityTag(compoundTag, "decorated_pot").put("sherds", listTag);
        });
        this.register(StructuredDataKey.DEBUG_STICK_STATE, (T debugStickState, CompoundTag compoundTag) -> compoundTag.put("DebugProperty", debugStickState.tag()));
        this.register(StructuredDataKey.RECIPES, (T tag, CompoundTag compoundTag) -> compoundTag.put("Recipes", (Tag)tag));
        this.register(StructuredDataKey.ENTITY_DATA1_20_5, (T compoundTag, CompoundTag compoundTag2) -> compoundTag2.put("EntityTag", (Tag)compoundTag));
        this.register(StructuredDataKey.BUCKET_ENTITY_DATA, (T compoundTag, CompoundTag compoundTag2) -> {
            for (String string : BlockItemPacketRewriter1_20_5.MOB_TAGS) {
                if (!compoundTag.contains(string)) continue;
                compoundTag2.put(string, compoundTag.get(string));
            }
        });
        this.register(StructuredDataKey.BLOCK_ENTITY_DATA1_20_5, (T compoundTag, CompoundTag compoundTag2) -> {
            CompoundTag compoundTag3 = compoundTag2.getCompoundTag("BlockEntityTag");
            if (compoundTag3 != null) {
                compoundTag3.putAll((CompoundTag)compoundTag);
            } else {
                compoundTag2.put("BlockEntityTag", (Tag)compoundTag);
            }
        });
        this.register(StructuredDataKey.CONTAINER_LOOT, (T compoundTag, CompoundTag compoundTag2) -> {
            Tag tag;
            Tag tag2 = compoundTag.get("loot_table");
            if (tag2 != null) {
                StructuredDataConverter.getBlockEntityTag(compoundTag2).put("LootTable", tag2);
            }
            if ((tag = compoundTag.get("loot_table_seed")) != null) {
                StructuredDataConverter.getBlockEntityTag(compoundTag2).put("LootTableSeed", tag);
            }
        });
        this.register(StructuredDataKey.ENCHANTMENT_GLINT_OVERRIDE, (T bl2, CompoundTag compoundTag) -> {
            if (bl) {
                StructuredDataConverter.getBackupTag(compoundTag).putBoolean("enchantment_glint_override", (boolean)bl2);
            }
            if (!bl2.booleanValue()) {
                return;
            }
            ListTag<CompoundTag> listTag = compoundTag.getListTag("Enchantments", CompoundTag.class);
            if (listTag == null) {
                listTag = new ListTag<CompoundTag>(CompoundTag.class);
                compoundTag.put("Enchantments", listTag);
            } else if (!listTag.isEmpty()) {
                return;
            }
            CompoundTag compoundTag2 = new CompoundTag();
            compoundTag2.putString("id", "");
            listTag.add(compoundTag2);
        });
        this.register(StructuredDataKey.POTION_CONTENTS1_20_5, (T potionContents, CompoundTag compoundTag) -> {
            Object object;
            if (potionContents.potion() != null && (object = Potions1_20_5.idToKey(potionContents.potion())) != null) {
                compoundTag.putString("Potion", (String)object);
            }
            if (potionContents.customColor() != null) {
                compoundTag.putInt("CustomPotionColor", potionContents.customColor());
            }
            object = new ListTag<CompoundTag>(CompoundTag.class);
            for (PotionEffect potionEffect : potionContents.customEffects()) {
                CompoundTag compoundTag2 = new CompoundTag();
                String string = PotionEffects1_20_5.idToKey(potionEffect.effect());
                if (string != null) {
                    compoundTag2.putString("id", string);
                }
                PotionEffectData potionEffectData = potionEffect.effectData();
                compoundTag2.putByte("amplifier", (byte)potionEffectData.amplifier());
                compoundTag2.putInt("duration", potionEffectData.duration());
                compoundTag2.putBoolean("ambient", potionEffectData.ambient());
                compoundTag2.putBoolean("show_particles", potionEffectData.showParticles());
                compoundTag2.putBoolean("show_icon", potionEffectData.showIcon());
                ((ListTag)object).add(compoundTag2);
            }
            if (!((ListTag)object).isEmpty()) {
                compoundTag.put("custom_potion_effects", (Tag)object);
            }
        });
        this.register(StructuredDataKey.SUSPICIOUS_STEW_EFFECTS, (T suspiciousStewEffectArray, CompoundTag compoundTag) -> {
            ListTag<CompoundTag> listTag = new ListTag<CompoundTag>(CompoundTag.class);
            for (SuspiciousStewEffect suspiciousStewEffect : suspiciousStewEffectArray) {
                CompoundTag compoundTag2 = new CompoundTag();
                String string = PotionEffects1_20_5.idToKey(suspiciousStewEffect.mobEffect());
                if (string != null) {
                    compoundTag2.putString("id", string);
                }
                compoundTag2.putInt("duration", suspiciousStewEffect.duration());
                listTag.add(compoundTag2);
            }
            compoundTag.put("effects", listTag);
        });
        this.register(StructuredDataKey.BANNER_PATTERNS, (UserConnection userConnection, T bannerPatternLayerArray, CompoundTag compoundTag) -> {
            Object object;
            Object object2;
            ListTag<CompoundTag> listTag;
            BannerPatternStorage bannerPatternStorage = userConnection.get(BannerPatternStorage.class);
            if (bl && Arrays.stream(bannerPatternLayerArray).anyMatch(bannerPatternLayer -> {
                if (bannerPatternLayer.pattern().isDirect()) {
                    return true;
                }
                int n = bannerPatternLayer.pattern().id();
                String string = bannerPatternStorage != null ? bannerPatternStorage.pattern(n) : BannerPatterns1_20_5.idToKey(n);
                return string == null || string.equals("flow") || string.equals("guster");
            })) {
                listTag = new ListTag<CompoundTag>(CompoundTag.class);
                for (BannerPatternLayer bannerPatternLayer2 : bannerPatternLayerArray) {
                    CompoundTag compoundTag2 = new CompoundTag();
                    if (bannerPatternLayer2.pattern().isDirect()) {
                        object2 = new CompoundTag();
                        object = bannerPatternLayer2.pattern().value();
                        ((CompoundTag)object2).putString("asset_id", ((BannerPattern)object).assetId());
                        ((CompoundTag)object2).putString("translation_key", ((BannerPattern)object).translationKey());
                        compoundTag2.put("pattern", (Tag)object2);
                    } else {
                        compoundTag2.putInt("pattern", bannerPatternLayer2.pattern().id());
                    }
                    compoundTag2.putInt("dye_color", bannerPatternLayer2.dyeColor());
                    listTag.add(compoundTag2);
                }
                StructuredDataConverter.getBackupTag(compoundTag).put("banner_patterns", listTag);
            }
            listTag = new ListTag<CompoundTag>(CompoundTag.class);
            for (BannerPatternLayer bannerPatternLayer2 : bannerPatternLayerArray) {
                if (bannerPatternLayer2.pattern().isDirect()) continue;
                int n = bannerPatternLayer2.pattern().id();
                Object object3 = object2 = bannerPatternStorage != null ? bannerPatternStorage.pattern(n) : BannerPatterns1_20_5.idToKey(n);
                if (object2 == null || (object = BannerPatterns1_20_5.fullIdToCompact((String)object2)) == null) continue;
                CompoundTag compoundTag3 = new CompoundTag();
                compoundTag3.putString("Pattern", (String)object);
                compoundTag3.putInt("Color", bannerPatternLayer2.dyeColor());
                listTag.add(compoundTag3);
            }
            this.getBlockEntityTag(compoundTag, "banner").put("Patterns", listTag);
        });
        this.register(StructuredDataKey.V1_20_5.container, (UserConnection userConnection, T itemArray, CompoundTag compoundTag) -> this.convertItemList(userConnection, (Item[])itemArray, StructuredDataConverter.getBlockEntityTag(compoundTag), "Items"));
        this.register(StructuredDataKey.CAN_PLACE_ON1_20_5, (T adventureModePredicate, CompoundTag compoundTag) -> this.convertBlockPredicates(compoundTag, (AdventureModePredicate)adventureModePredicate, "CanPlaceOn", 16));
        this.register(StructuredDataKey.CAN_BREAK1_20_5, (T adventureModePredicate, CompoundTag compoundTag) -> this.convertBlockPredicates(compoundTag, (AdventureModePredicate)adventureModePredicate, "CanDestroy", 8));
        this.register(StructuredDataKey.TRIM1_20_5, (UserConnection userConnection, T armorTrim, CompoundTag compoundTag) -> {
            String string;
            Record record;
            Object object;
            CompoundTag compoundTag2 = new CompoundTag();
            ArmorTrimStorage armorTrimStorage = userConnection.get(ArmorTrimStorage.class);
            if (armorTrim.material().isDirect()) {
                object = new CompoundTag();
                record = armorTrim.material().value();
                ((CompoundTag)object).putString("asset_name", ((ArmorTrimMaterial)record).assetName());
                string = this.toMappedItemName(((ArmorTrimMaterial)record).itemId());
                if (bl && string.isEmpty()) {
                    StructuredDataConverter.getBackupTag((CompoundTag)object).putInt(ITEM_BACKUP_TAG_KEY, ((ArmorTrimMaterial)record).itemId());
                }
                ((CompoundTag)object).putString("ingredient", string);
                ((CompoundTag)object).put("item_model_index", new FloatTag(((ArmorTrimMaterial)record).itemModelIndex()));
                CompoundTag compoundTag3 = new CompoundTag();
                if (!((ArmorTrimMaterial)record).overrideArmorMaterials().isEmpty()) {
                    for (Map.Entry<String, String> entry : ((ArmorTrimMaterial)record).overrideArmorMaterials().entrySet()) {
                        compoundTag3.put(entry.getKey(), new StringTag(entry.getValue()));
                    }
                    ((CompoundTag)object).put("override_armor_materials", compoundTag3);
                }
                ((CompoundTag)object).put("description", ((ArmorTrimMaterial)record).description());
                compoundTag2.put("material", (Tag)object);
            } else {
                object = armorTrimStorage.trimMaterials().idToKey(armorTrim.material().id());
                if (object != null) {
                    compoundTag2.putString("material", (String)object);
                }
            }
            if (armorTrim.pattern().isDirect()) {
                object = new CompoundTag();
                record = armorTrim.pattern().value();
                ((CompoundTag)object).putString("assetId", ((ArmorTrimPattern)record).assetName());
                string = this.toMappedItemName(((ArmorTrimPattern)record).itemId());
                if (bl && string.isEmpty()) {
                    StructuredDataConverter.getBackupTag((CompoundTag)object).putInt(ITEM_BACKUP_TAG_KEY, ((ArmorTrimPattern)record).itemId());
                }
                ((CompoundTag)object).putString("templateItem", string);
                ((CompoundTag)object).put("description", ((ArmorTrimPattern)record).description());
                ((CompoundTag)object).putBoolean("decal", ((ArmorTrimPattern)record).decal());
                compoundTag2.put("pattern", (Tag)object);
            } else {
                object = armorTrimStorage.trimPatterns().idToKey(armorTrim.pattern().id());
                if (object != null) {
                    compoundTag2.putString("pattern", (String)object);
                }
            }
            compoundTag.put("Trim", compoundTag2);
            if (!armorTrim.showInTooltip()) {
                this.putHideFlag(compoundTag, 128);
            }
        });
        this.register(StructuredDataKey.BLOCK_STATE, (T blockStateProperties, CompoundTag compoundTag) -> {
            CompoundTag compoundTag2 = new CompoundTag();
            compoundTag.put("BlockStateTag", compoundTag2);
            for (Map.Entry<String, String> entry : blockStateProperties.properties().entrySet()) {
                compoundTag2.putString(entry.getKey(), entry.getValue());
            }
        });
        this.register(StructuredDataKey.HIDE_TOOLTIP, (T unit, CompoundTag compoundTag) -> {
            this.putHideFlag(compoundTag, 255);
            if (bl) {
                StructuredDataConverter.getBackupTag(compoundTag).putBoolean("hide_tooltip", true);
            }
        });
        this.register(StructuredDataKey.INTANGIBLE_PROJECTILE, (T tag, CompoundTag compoundTag) -> {
            if (bl) {
                StructuredDataConverter.getBackupTag(compoundTag).put("intangible_projectile", (Tag)tag);
            }
        });
        this.register(StructuredDataKey.MAX_STACK_SIZE, (T n, CompoundTag compoundTag) -> {
            if (bl) {
                StructuredDataConverter.getBackupTag(compoundTag).putInt("max_stack_size", (int)n);
            }
        });
        this.register(StructuredDataKey.MAX_DAMAGE, (T n, CompoundTag compoundTag) -> {
            if (bl) {
                StructuredDataConverter.getBackupTag(compoundTag).putInt("max_damage", (int)n);
            }
        });
        this.register(StructuredDataKey.RARITY, (T n, CompoundTag compoundTag) -> {
            if (bl) {
                StructuredDataConverter.getBackupTag(compoundTag).putInt("rarity", (int)n);
            }
        });
        this.register(StructuredDataKey.FOOD1_20_5, (T foodProperties1_20_5, CompoundTag compoundTag) -> {
            if (bl) {
                CompoundTag compoundTag2 = new CompoundTag();
                compoundTag2.putInt("nutrition", foodProperties1_20_5.nutrition());
                compoundTag2.putFloat("saturation_modifier", foodProperties1_20_5.saturationModifier());
                compoundTag2.putBoolean("can_always_eat", foodProperties1_20_5.canAlwaysEat());
                compoundTag2.putFloat("eat_seconds", foodProperties1_20_5.eatSeconds());
                ListTag<CompoundTag> listTag = new ListTag<CompoundTag>(CompoundTag.class);
                for (FoodProperties1_20_5.FoodEffect foodEffect : foodProperties1_20_5.possibleEffects()) {
                    CompoundTag compoundTag3 = new CompoundTag();
                    PotionEffect potionEffect = foodEffect.effect();
                    CompoundTag compoundTag4 = new CompoundTag();
                    compoundTag4.putInt("effect", potionEffect.effect());
                    compoundTag4.put("effect_data", this.convertPotionEffectData(potionEffect.effectData()));
                    compoundTag3.putFloat("probability", foodEffect.probability());
                    compoundTag3.put("effect", compoundTag4);
                    listTag.add(compoundTag3);
                }
                compoundTag2.put("possible_effects", listTag);
                StructuredDataConverter.getBackupTag(compoundTag).put("food", compoundTag2);
            }
        });
        this.register(StructuredDataKey.FIRE_RESISTANT, (T unit, CompoundTag compoundTag) -> {
            if (bl) {
                StructuredDataConverter.getBackupTag(compoundTag).putBoolean("fire_resistant", true);
            }
        });
        this.register(StructuredDataKey.TOOL1_20_5, (T toolProperties, CompoundTag compoundTag) -> {
            if (bl) {
                CompoundTag compoundTag2 = new CompoundTag();
                ListTag<CompoundTag> listTag = new ListTag<CompoundTag>(CompoundTag.class);
                for (ToolRule toolRule : toolProperties.rules()) {
                    CompoundTag compoundTag3 = new CompoundTag();
                    HolderSet holderSet = toolRule.blocks();
                    if (holderSet.hasTagKey()) {
                        compoundTag3.putString("blocks", holderSet.tagKey());
                    } else {
                        compoundTag3.put("blocks", new IntArrayTag(holderSet.ids()));
                    }
                    if (toolRule.speed() != null) {
                        compoundTag3.putFloat("speed", toolRule.speed().floatValue());
                    }
                    if (toolRule.correctForDrops() != null) {
                        compoundTag3.putBoolean("correct_for_drops", toolRule.correctForDrops());
                    }
                    listTag.add(compoundTag3);
                }
                compoundTag2.put("rules", listTag);
                compoundTag2.putFloat("default_mining_speed", toolProperties.defaultMiningSpeed());
                compoundTag2.putInt("damage_per_block", toolProperties.damagePerBlock());
                StructuredDataConverter.getBackupTag(compoundTag).put("tool", compoundTag2);
            }
        });
        this.register(StructuredDataKey.OMINOUS_BOTTLE_AMPLIFIER, (T n, CompoundTag compoundTag) -> {
            if (bl) {
                StructuredDataConverter.getBackupTag(compoundTag).putInt("ominous_bottle_amplifier", (int)n);
            }
        });
        this.register(StructuredDataKey.MAP_POST_PROCESSING, (T n, CompoundTag compoundTag) -> {});
        this.register(StructuredDataKey.CREATIVE_SLOT_LOCK, (T unit, CompoundTag compoundTag) -> {});
    }

    private int unmappedItemId(int n) {
        return Protocol1_20_3To1_20_5.MAPPINGS.getOldItemId(n);
    }

    private String toMappedItemName(int n) {
        int n2 = this.unmappedItemId(n);
        return n2 != -1 ? Protocol1_20_3To1_20_5.MAPPINGS.getFullItemMappings().identifier(n2) : "";
    }

    private static CompoundTag getBlockEntityTag(CompoundTag compoundTag) {
        return StructuredDataConverter.getOrCreate(compoundTag, "BlockEntityTag");
    }

    private CompoundTag getBlockEntityTag(CompoundTag compoundTag, String string) {
        CompoundTag compoundTag2 = StructuredDataConverter.getOrCreate(compoundTag, "BlockEntityTag");
        if (!compoundTag2.contains("id")) {
            compoundTag2.putString("id", string);
        }
        return compoundTag2;
    }

    private static CompoundTag getDisplayTag(CompoundTag compoundTag) {
        return StructuredDataConverter.getOrCreate(compoundTag, "display");
    }

    private static CompoundTag getBackupTag(CompoundTag compoundTag) {
        return StructuredDataConverter.getOrCreate(compoundTag, BACKUP_TAG_KEY);
    }

    private static CompoundTag getOrCreate(CompoundTag compoundTag, String string) {
        CompoundTag compoundTag2 = compoundTag.getCompoundTag(string);
        if (compoundTag2 == null) {
            compoundTag2 = new CompoundTag();
            compoundTag.put(string, compoundTag2);
        }
        return compoundTag2;
    }

    public static @Nullable CompoundTag removeBackupTag(CompoundTag compoundTag) {
        CompoundTag compoundTag2 = compoundTag.getCompoundTag(BACKUP_TAG_KEY);
        if (compoundTag2 != null) {
            compoundTag.remove(BACKUP_TAG_KEY);
        }
        return compoundTag2;
    }

    static int removeItemBackupTag(CompoundTag compoundTag, int n) {
        IntTag intTag = compoundTag.getIntTag(ITEM_BACKUP_TAG_KEY);
        if (intTag != null) {
            compoundTag.remove(ITEM_BACKUP_TAG_KEY);
            return intTag.asInt();
        }
        return n;
    }

    private void convertBlockPredicates(CompoundTag compoundTag, AdventureModePredicate adventureModePredicate, String string, int n) {
        ListTag<StringTag> listTag = new ListTag<StringTag>(StringTag.class);
        for (BlockPredicate blockPredicate : adventureModePredicate.predicates()) {
            HolderSet holderSet = blockPredicate.holderSet();
            if (holderSet == null) {
                if (!this.backupInconvertibleData) continue;
                continue;
            }
            if (holderSet.hasTagKey()) {
                String string2 = "#" + holderSet.tagKey();
                listTag.add(this.serializeBlockPredicate(blockPredicate, string2));
                continue;
            }
            for (int n2 : holderSet.ids()) {
                String string3 = Protocol1_20_3To1_20_5.MAPPINGS.blockName(n2);
                if (string3 == null) {
                    if (!this.backupInconvertibleData) continue;
                    continue;
                }
                listTag.add(this.serializeBlockPredicate(blockPredicate, string3));
            }
        }
        compoundTag.put(string, listTag);
        if (!adventureModePredicate.showInTooltip()) {
            this.putHideFlag(compoundTag, n);
        }
    }

    private StringTag serializeBlockPredicate(BlockPredicate blockPredicate, String string) {
        StringBuilder stringBuilder = new StringBuilder(string);
        if (blockPredicate.propertyMatchers() != null) {
            for (StatePropertyMatcher statePropertyMatcher : blockPredicate.propertyMatchers()) {
                if (!statePropertyMatcher.matcher().isLeft()) continue;
                stringBuilder.append(statePropertyMatcher.name()).append('=');
                stringBuilder.append(statePropertyMatcher.matcher().left());
            }
        }
        if (blockPredicate.tag() != null) {
            stringBuilder.append(blockPredicate.tag());
        }
        return new StringTag(stringBuilder.toString());
    }

    private CompoundTag convertExplosion(FireworkExplosion fireworkExplosion) {
        CompoundTag compoundTag = new CompoundTag();
        compoundTag.putInt("Type", fireworkExplosion.shape());
        compoundTag.put("Colors", new IntArrayTag((int[])fireworkExplosion.colors().clone()));
        compoundTag.put("FadeColors", new IntArrayTag((int[])fireworkExplosion.fadeColors().clone()));
        compoundTag.putBoolean("Trail", fireworkExplosion.hasTrail());
        compoundTag.putBoolean("Flicker", fireworkExplosion.hasTwinkle());
        return compoundTag;
    }

    private CompoundTag convertPotionEffectData(PotionEffectData potionEffectData) {
        CompoundTag compoundTag = new CompoundTag();
        compoundTag.putInt("amplifier", potionEffectData.amplifier());
        compoundTag.putInt("duration", potionEffectData.duration());
        compoundTag.putBoolean("ambient", potionEffectData.ambient());
        compoundTag.putBoolean("show_particles", potionEffectData.showParticles());
        compoundTag.putBoolean("show_icon", potionEffectData.showIcon());
        if (potionEffectData.hiddenEffect() != null) {
            compoundTag.put("hidden_effect", this.convertPotionEffectData(potionEffectData.hiddenEffect()));
        }
        return compoundTag;
    }

    private void convertItemList(UserConnection userConnection, Item[] itemArray, CompoundTag compoundTag, String string) {
        ListTag<CompoundTag> listTag = new ListTag<CompoundTag>(CompoundTag.class);
        for (int i = 0; i < itemArray.length; ++i) {
            Item item = itemArray[i];
            CompoundTag compoundTag2 = this.itemToTag(userConnection, item);
            if (this.backupInconvertibleData) {
                compoundTag2.putByte("Slot", (byte)i);
            }
            listTag.add(compoundTag2);
        }
        compoundTag.put(string, listTag);
    }

    private CompoundTag itemToTag(UserConnection userConnection, Item item) {
        CompoundTag compoundTag = new CompoundTag();
        if (item != null) {
            String string = this.toMappedItemName(item.identifier());
            compoundTag.putString("id", string);
            if (this.backupInconvertibleData && string.isEmpty()) {
                compoundTag.putInt(ITEM_BACKUP_TAG_KEY, item.identifier());
            }
            compoundTag.putByte("Count", (byte)item.amount());
            CompoundTag compoundTag2 = new CompoundTag();
            for (StructuredData<?> structuredData : item.dataContainer().data().values()) {
                this.writeToTag(userConnection, structuredData, compoundTag2);
            }
            compoundTag.put("tag", compoundTag2);
        } else {
            compoundTag.putString("id", "air");
        }
        return compoundTag;
    }

    private void convertEnchantments(Enchantments enchantments, CompoundTag compoundTag, boolean bl) {
        ListTag<CompoundTag> listTag = new ListTag<CompoundTag>(CompoundTag.class);
        for (Int2IntMap.Entry entry : enchantments.enchantments().int2IntEntrySet()) {
            int n = entry.getIntKey();
            String string = Enchantments1_20_5.idToKey(n);
            if (string == null || string.equals("density") || string.equals("breach") || string.equals("wind_burst")) continue;
            if (string.equals("sweeping_edge")) {
                string = "sweeping";
            }
            CompoundTag compoundTag2 = new CompoundTag();
            compoundTag2.putString("id", string);
            compoundTag2.putShort("lvl", (short)entry.getIntValue());
            listTag.add(compoundTag2);
        }
        compoundTag.put(bl ? "StoredEnchantments" : "Enchantments", listTag);
        if (!enchantments.showInTooltip()) {
            this.putHideFlag(compoundTag, bl ? 32 : 1);
        }
    }

    private void putHideFlag(CompoundTag compoundTag, int n) {
        compoundTag.putInt("HideFlags", compoundTag.getInt("HideFlags") | n);
    }

    public <T> void writeToTag(UserConnection userConnection, StructuredData<T> structuredData, CompoundTag compoundTag) {
        if (structuredData.isEmpty()) {
            return;
        }
        DataConverter<?> dataConverter = this.rewriters.get(structuredData.key());
        Preconditions.checkNotNull(dataConverter, "No converter for %s found", structuredData.key());
        dataConverter.convert(userConnection, structuredData.value(), compoundTag);
    }

    private <T> void register(StructuredDataKey<T> structuredDataKey, DataConverter<T> dataConverter) {
        this.rewriters.put(structuredDataKey, dataConverter);
    }

    private <T> void register(StructuredDataKey<T> structuredDataKey, SimpleDataConverter<T> simpleDataConverter) {
        DataConverter<Object> dataConverter = (userConnection, object, compoundTag) -> simpleDataConverter.convert(object, compoundTag);
        this.rewriters.put(structuredDataKey, dataConverter);
    }

    public boolean backupInconvertibleData() {
        return this.backupInconvertibleData;
    }

    @FunctionalInterface
    public static interface SimpleDataConverter<T> {
        public void convert(T var1, CompoundTag var2);
    }

    @FunctionalInterface
    public static interface DataConverter<T> {
        public void convert(UserConnection var1, T var2, CompoundTag var3);
    }
}

