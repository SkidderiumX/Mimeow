/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_21to1_21_2.rewriter;

import com.viaversion.viaversion.api.connection.StorableObject;
import com.viaversion.viaversion.api.minecraft.HolderSet;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.VersionedTypes;
import com.viaversion.viaversion.libs.fastutil.ints.IntOpenHashSet;
import com.viaversion.viaversion.libs.fastutil.ints.IntSet;
import com.viaversion.viaversion.libs.fastutil.objects.Object2IntMap;
import com.viaversion.viaversion.libs.fastutil.objects.Object2IntOpenHashMap;
import com.viaversion.viaversion.libs.fastutil.objects.Object2ObjectArrayMap;
import com.viaversion.viaversion.protocols.v1_20_2to1_20_3.rewriter.RecipeRewriter1_20_3;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundPacket1_21;
import com.viaversion.viaversion.util.Key;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.Nullable;

public class RecipeRewriter1_21_2
extends RecipeRewriter1_20_3<ClientboundPacket1_21>
implements StorableObject {
    private static final int[] EMPTY_ARRAY = new int[0];
    private final List<StoneCutterRecipe> stoneCutterRecipes = new ArrayList<StoneCutterRecipe>();
    private final Object2IntMap<String> recipeGroups = new Object2IntOpenHashMap<String>();
    private final Map<String, Recipe> recipesByKey = new HashMap<String, Recipe>();
    private final Map<String, IntSet> recipeInputs = new Object2ObjectArrayMap<String, IntSet>();
    private final List<Recipe> recipes = new ArrayList<Recipe>();
    private String currentRecipeIdentifier;

    public void setCurrentRecipeIdentifier(String string) {
        this.currentRecipeIdentifier = Key.stripMinecraftNamespace(string);
    }

    RecipeRewriter1_21_2(Protocol<ClientboundPacket1_21, ?, ?, ?> protocol) {
        super(protocol);
        this.recipeGroups.defaultReturnValue(-1);
        this.recipeHandlers.put("smelting", packetWrapper -> this.handleSmelting("furnace_input", packetWrapper));
        this.recipeHandlers.put("blasting", packetWrapper -> this.handleSmelting("blast_furnace_input", packetWrapper));
        this.recipeHandlers.put("smoking", packetWrapper -> this.handleSmelting("smoker_input", packetWrapper));
        this.recipeHandlers.put("campfire_cooking", packetWrapper -> this.handleSmelting("campfire_input", packetWrapper));
    }

    @Override
    public void handleSimpleRecipe(PacketWrapper packetWrapper) {
        int n = packetWrapper.read(Types.VAR_INT);
    }

    @Override
    public void handleStonecutting(PacketWrapper packetWrapper) {
        int n = this.readRecipeGroup(packetWrapper);
        Item[] itemArray = this.readIngredient(packetWrapper);
        Item item = this.rewrite(packetWrapper.user(), packetWrapper.read(this.itemType()));
        StoneCutterRecipe stoneCutterRecipe = new StoneCutterRecipe(this.currentRecipeIdentifier, n, itemArray, item);
        this.stoneCutterRecipes.add(stoneCutterRecipe);
    }

    private void addRecipe(Recipe recipe) {
        this.recipes.add(recipe);
        this.recipesByKey.put(this.currentRecipeIdentifier, recipe);
    }

    @Override
    public void handleSmithingTransform(PacketWrapper packetWrapper) {
        this.readRecipeInputs("smithing_template", packetWrapper);
        this.readRecipeInputs("smithing_base", packetWrapper);
        this.readRecipeInputs("smithing_addition", packetWrapper);
        packetWrapper.read(this.itemType());
    }

    @Override
    public void handleSmithingTrim(PacketWrapper packetWrapper) {
        this.readRecipeInputs("smithing_template", packetWrapper);
        this.readRecipeInputs("smithing_base", packetWrapper);
        this.readRecipeInputs("smithing_addition", packetWrapper);
    }

    @Override
    public void handleCraftingShaped(PacketWrapper packetWrapper) {
        int n = this.readRecipeGroup(packetWrapper);
        int n2 = packetWrapper.read(Types.VAR_INT);
        int n3 = packetWrapper.read(Types.VAR_INT);
        int n4 = packetWrapper.read(Types.VAR_INT);
        int n5 = n3 * n4;
        Item[][] itemArray = new Item[n5][];
        for (int i = 0; i < n5; ++i) {
            itemArray[i] = this.readIngredient(packetWrapper);
        }
        Item item = this.rewrite(packetWrapper.user(), packetWrapper.read(this.itemType()));
        boolean bl = packetWrapper.read(Types.BOOLEAN);
        ShapedRecipe shapedRecipe = new ShapedRecipe(this.recipesByKey.size(), this.currentRecipeIdentifier, n, n2, n3, n4, itemArray, item, bl);
        this.addRecipe(shapedRecipe);
    }

    @Override
    public void handleCraftingShapeless(PacketWrapper packetWrapper) {
        int n = this.readRecipeGroup(packetWrapper);
        int n2 = packetWrapper.read(Types.VAR_INT);
        int n3 = packetWrapper.read(Types.VAR_INT);
        Item[][] itemArray = new Item[n3][];
        for (int i = 0; i < n3; ++i) {
            itemArray[i] = this.readIngredient(packetWrapper);
        }
        Item item = this.rewrite(packetWrapper.user(), packetWrapper.read(this.itemType()));
        ShapelessRecipe shapelessRecipe = new ShapelessRecipe(this.recipesByKey.size(), this.currentRecipeIdentifier, n, n2, itemArray, item);
        this.addRecipe(shapelessRecipe);
    }

    public void handleSmelting(String string, PacketWrapper packetWrapper) {
        int n = this.readRecipeGroup(packetWrapper);
        int n2 = packetWrapper.read(Types.VAR_INT);
        Item[] itemArray = this.readRecipeInputs(string, packetWrapper);
        Item item = this.rewrite(packetWrapper.user(), packetWrapper.read(this.itemType()));
        float f = packetWrapper.read(Types.FLOAT).floatValue();
        int n3 = packetWrapper.read(Types.VAR_INT);
        FurnaceRecipe furnaceRecipe = new FurnaceRecipe(this.recipesByKey.size(), this.currentRecipeIdentifier, n, n2, itemArray, item, n3, f);
        this.addRecipe(furnaceRecipe);
    }

    private int readRecipeGroup(PacketWrapper packetWrapper) {
        String string = Key.stripMinecraftNamespace(packetWrapper.read(Types.STRING));
        if (string.isEmpty()) {
            return -1;
        }
        if (this.recipeGroups.containsKey(string)) {
            return this.recipeGroups.getInt(string);
        }
        int n = this.recipeGroups.size();
        this.recipeGroups.put(string, n);
        return n;
    }

    private Item[] readIngredient(PacketWrapper packetWrapper) {
        Item[] itemArray = packetWrapper.read(this.itemArrayType());
        for (int i = 0; i < itemArray.length; ++i) {
            Item item = itemArray[i];
            itemArray[i] = this.rewrite(packetWrapper.user(), item);
        }
        return itemArray;
    }

    public HolderSet toHolderSet(Item[] itemArray) {
        int[] nArray = new int[itemArray.length];
        for (int i = 0; i < itemArray.length; ++i) {
            nArray[i] = itemArray[i].identifier();
        }
        return HolderSet.of(nArray);
    }

    public @Nullable Recipe recipe(String string) {
        return this.recipesByKey.get(Key.stripMinecraftNamespace(string));
    }

    public @Nullable Recipe recipe(int n) {
        return n >= 0 && n < this.recipes.size() ? this.recipes.get(n) : null;
    }

    public void finalizeRecipes() {
        this.stoneCutterRecipes.sort(Comparator.comparing(stoneCutterRecipe -> stoneCutterRecipe.identifier));
    }

    public void writeUpdateRecipeInputs(PacketWrapper packetWrapper) {
        packetWrapper.write(Types.VAR_INT, this.recipeInputs.size());
        for (Map.Entry<String, IntSet> object : this.recipeInputs.entrySet()) {
            packetWrapper.write(Types.STRING, object.getKey());
            packetWrapper.write(Types.VAR_INT_ARRAY_PRIMITIVE, object.getValue().toArray(EMPTY_ARRAY));
        }
        packetWrapper.write(Types.VAR_INT, this.stoneCutterRecipes.size());
        for (StoneCutterRecipe stoneCutterRecipe : this.stoneCutterRecipes) {
            HolderSet holderSet = this.toHolderSet(stoneCutterRecipe.ingredient());
            packetWrapper.write(Types.HOLDER_SET, holderSet);
            RecipeRewriter1_21_2.writeItemDisplay(packetWrapper, stoneCutterRecipe.result());
        }
    }

    private Item[] readRecipeInputs(String string2, PacketWrapper packetWrapper) {
        Item[] itemArray = this.readIngredient(packetWrapper);
        IntSet intSet = this.recipeInputs.computeIfAbsent(string2, string -> new IntOpenHashSet(itemArray.length));
        for (Item item : itemArray) {
            intSet.add(item.identifier());
        }
        return itemArray;
    }

    private static void writeIngredientsDisplay(PacketWrapper packetWrapper, Item[][] itemArray) {
        packetWrapper.write(Types.VAR_INT, itemArray.length);
        for (Item[] itemArray2 : itemArray) {
            RecipeRewriter1_21_2.writeIngredientDisplay(packetWrapper, itemArray2);
        }
    }

    private static void writeIngredientDisplay(PacketWrapper packetWrapper, Item[] itemArray) {
        if (itemArray.length == 0) {
            packetWrapper.write(Types.VAR_INT, 0);
            return;
        }
        if (itemArray.length == 1) {
            RecipeRewriter1_21_2.writeItemDisplay(packetWrapper, itemArray[0]);
            return;
        }
        packetWrapper.write(Types.VAR_INT, 7);
        packetWrapper.write(Types.VAR_INT, itemArray.length);
        for (Item item : itemArray) {
            RecipeRewriter1_21_2.writeItemDisplay(packetWrapper, item);
        }
    }

    private static void writeItemDisplay(PacketWrapper packetWrapper, Item item) {
        packetWrapper.write(Types.VAR_INT, 3);
        packetWrapper.write(VersionedTypes.V1_21_2.item, item.copy());
    }

    private static void writeCraftingStationDisplay(PacketWrapper packetWrapper) {
        packetWrapper.write(Types.VAR_INT, 0);
    }

    public record StoneCutterRecipe(String identifier, int group, Item[] ingredient, Item result) {
        public int recipeDisplayId() {
            return 3;
        }

        public void writeRecipeDisplay(PacketWrapper packetWrapper) {
            RecipeRewriter1_21_2.writeIngredientDisplay(packetWrapper, this.ingredient);
            RecipeRewriter1_21_2.writeItemDisplay(packetWrapper, this.result);
            RecipeRewriter1_21_2.writeCraftingStationDisplay(packetWrapper);
        }
    }

    public record ShapedRecipe(int index, String identifier, int group, int category, int width, int height, Item[][] ingredients, Item result, boolean showNotification) implements Recipe
    {
        @Override
        public int recipeDisplayId() {
            return 1;
        }

        @Override
        public void writeRecipeDisplay(PacketWrapper packetWrapper) {
            packetWrapper.write(Types.VAR_INT, this.width);
            packetWrapper.write(Types.VAR_INT, this.height);
            RecipeRewriter1_21_2.writeIngredientsDisplay(packetWrapper, this.ingredients);
            RecipeRewriter1_21_2.writeItemDisplay(packetWrapper, this.result);
            RecipeRewriter1_21_2.writeCraftingStationDisplay(packetWrapper);
        }
    }

    public static interface Recipe {
        public static final int SLOT_DISPLAY_EMPTY = 0;
        public static final int SLOT_DISPLAY_ANY_FUEL = 1;
        public static final int SLOT_DISPLAY_ITEM = 3;
        public static final int SLOT_DISPLAY_COMPOSITE = 7;

        public int index();

        public String identifier();

        public int recipeDisplayId();

        default public Item @Nullable [][] ingredients() {
            Item[][] itemArrayArray;
            Item[] itemArray = this.ingredient();
            if (itemArray == null) {
                itemArrayArray = null;
            } else {
                Item[][] itemArrayArray2 = new Item[1][];
                itemArrayArray = itemArrayArray2;
                itemArrayArray2[0] = itemArray;
            }
            return itemArrayArray;
        }

        default public Item @Nullable [] ingredient() {
            return null;
        }

        default public int group() {
            return -1;
        }

        default public boolean showNotification() {
            return true;
        }

        public int category();

        public void writeRecipeDisplay(PacketWrapper var1);
    }

    public record ShapelessRecipe(int index, String identifier, int group, int category, Item[][] ingredients, Item result) implements Recipe
    {
        @Override
        public int recipeDisplayId() {
            return 0;
        }

        @Override
        public void writeRecipeDisplay(PacketWrapper packetWrapper) {
            RecipeRewriter1_21_2.writeIngredientsDisplay(packetWrapper, this.ingredients);
            RecipeRewriter1_21_2.writeItemDisplay(packetWrapper, this.result);
            RecipeRewriter1_21_2.writeCraftingStationDisplay(packetWrapper);
        }
    }

    public record FurnaceRecipe(int index, String identifier, int group, int category, Item[] ingredient, Item result, int duration, float experience) implements Recipe
    {
        @Override
        public int recipeDisplayId() {
            return 2;
        }

        @Override
        public void writeRecipeDisplay(PacketWrapper packetWrapper) {
            RecipeRewriter1_21_2.writeIngredientDisplay(packetWrapper, this.ingredient);
            packetWrapper.write(Types.VAR_INT, 1);
            RecipeRewriter1_21_2.writeItemDisplay(packetWrapper, this.result);
            RecipeRewriter1_21_2.writeCraftingStationDisplay(packetWrapper);
            packetWrapper.write(Types.VAR_INT, this.duration);
            packetWrapper.write(Types.FLOAT, Float.valueOf(this.experience));
        }
    }
}

