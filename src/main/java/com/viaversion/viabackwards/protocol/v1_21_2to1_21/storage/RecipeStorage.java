/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_21_2to1_21.storage;

import com.google.common.base.Preconditions;
import com.viaversion.viabackwards.protocol.v1_21_2to1_21.Protocol1_21_2To1_21;
import com.viaversion.viaversion.api.connection.StorableObject;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.HolderSet;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.minecraft.item.StructuredItem;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.VersionedTypes;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundPackets1_21;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class RecipeStorage
implements StorableObject {
    public static final int RECIPE_BOOK_SETTINGS = 8;
    private static final String[] EMPTY_STRINGS = new String[0];
    private final List<Recipe> recipes = new ArrayList<Recipe>();
    private final List<Recipe> tempRecipes = new ArrayList<Recipe>();
    private final List<StoneCutterRecipe> stoneCutterRecipes = new ArrayList<StoneCutterRecipe>();
    private boolean[] recipeBookSettings = new boolean[8];
    private final Protocol1_21_2To1_21 protocol;

    public RecipeStorage(Protocol1_21_2To1_21 protocol1_21_2To1_21) {
        this.protocol = protocol1_21_2To1_21;
    }

    public void sendRecipes(UserConnection userConnection) {
        if (!this.tempRecipes.isEmpty()) {
            this.recipes.addAll(this.tempRecipes);
            this.tempRecipes.clear();
        }
        int n = -1;
        for (Recipe object22 : this.recipes) {
            n = Math.max(n, object22.index);
        }
        ArrayList<Recipe> arrayList = new ArrayList<Recipe>(this.recipes);
        for (StoneCutterRecipe stoneCutterRecipe : this.stoneCutterRecipes) {
            stoneCutterRecipe.index = ++n;
            arrayList.add(stoneCutterRecipe);
        }
        arrayList.sort(Comparator.comparingInt(recipe -> recipe.index));
        PacketWrapper packetWrapper = PacketWrapper.create(ClientboundPackets1_21.UPDATE_RECIPES, userConnection);
        packetWrapper.write(Types.VAR_INT, arrayList.size());
        Iterator iterator2 = arrayList.iterator();
        while (iterator2.hasNext()) {
            Recipe recipe2 = (Recipe)iterator2.next();
            packetWrapper.write(Types.STRING, RecipeStorage.identifier(recipe2.index));
            recipe2.write(packetWrapper);
        }
        packetWrapper.send(Protocol1_21_2To1_21.class);
        this.sendUnlockedRecipes(userConnection, (List<Recipe>)arrayList);
    }

    private static String identifier(int n) {
        return String.format("%06d", n);
    }

    public void lockRecipes(PacketWrapper packetWrapper, int[] nArray) {
        for (int n : nArray) {
            this.recipes.removeIf(recipe -> recipe.index == n);
        }
        packetWrapper.write(Types.VAR_INT, 2);
        boolean[] blArray = this.recipeBookSettings;
        int n = blArray.length;
        for (int i = 0; i < n; ++i) {
            boolean bl = blArray[i];
            packetWrapper.write(Types.BOOLEAN, bl);
        }
        String[] stringArray = new String[nArray.length];
        for (n = 0; n < nArray.length; ++n) {
            stringArray[n] = RecipeStorage.identifier(nArray[n]);
        }
        packetWrapper.write(Types.STRING_ARRAY, stringArray);
    }

    private void sendUnlockedRecipes(UserConnection userConnection, List<Recipe> list) {
        int n;
        PacketWrapper packetWrapper = PacketWrapper.create(ClientboundPackets1_21.RECIPE, userConnection);
        packetWrapper.write(Types.VAR_INT, 0);
        boolean[] objectArray = this.recipeBookSettings;
        int arrayList = objectArray.length;
        for (n = 0; n < arrayList; ++n) {
            boolean bl = objectArray[n];
            packetWrapper.write(Types.BOOLEAN, bl);
        }
        String[] stringArray = new String[list.size()];
        ArrayList<String> arrayList2 = new ArrayList<String>();
        for (n = 0; n < list.size(); ++n) {
            stringArray[n] = RecipeStorage.identifier(list.get((int)n).index);
            if (!list.get((int)n).highlight) continue;
            arrayList2.add(stringArray[n]);
        }
        packetWrapper.write(Types.STRING_ARRAY, stringArray);
        packetWrapper.write(Types.STRING_ARRAY, arrayList2.toArray(EMPTY_STRINGS));
        packetWrapper.send(Protocol1_21_2To1_21.class);
    }

    public void readRecipe(PacketWrapper packetWrapper) {
        int n;
        int n2 = packetWrapper.read(Types.VAR_INT);
        int n3 = packetWrapper.passthrough(Types.VAR_INT);
        Recipe recipe = switch (n3) {
            case 0 -> this.readShapeless(packetWrapper);
            case 1 -> this.readShaped(packetWrapper);
            case 2 -> this.readFurnace(packetWrapper);
            case 3 -> this.readStoneCutter(packetWrapper);
            case 4 -> this.readSmithing(packetWrapper);
            default -> null;
        };
        Integer n4 = packetWrapper.read(Types.OPTIONAL_VAR_INT);
        int n5 = packetWrapper.read(Types.VAR_INT);
        if (packetWrapper.read(Types.BOOLEAN).booleanValue()) {
            n = packetWrapper.read(Types.VAR_INT);
            for (int i = 0; i < n; ++i) {
                packetWrapper.read(Types.HOLDER_SET);
            }
        }
        n = packetWrapper.read(Types.BYTE).byteValue();
        if (recipe != null) {
            recipe.index = n2;
            recipe.group = n4;
            recipe.category = n5;
            recipe.highlight = (n & 2) != 0;
        }
    }

    private Recipe readShapeless(PacketWrapper packetWrapper) {
        Item[][] itemArray = this.readSlotDisplayList(packetWrapper);
        Item item = this.readSingleSlotDisplay(packetWrapper);
        this.readSlotDisplay(packetWrapper);
        return this.add(new ShapelessRecipe(itemArray, item));
    }

    private Recipe readShaped(PacketWrapper packetWrapper) {
        int n = packetWrapper.passthrough(Types.VAR_INT);
        int n2 = packetWrapper.passthrough(Types.VAR_INT);
        Item[][] itemArray = this.readSlotDisplayList(packetWrapper);
        Item item = this.readSingleSlotDisplay(packetWrapper);
        this.readSlotDisplay(packetWrapper);
        return this.add(new ShapedRecipe(n, n2, itemArray, item));
    }

    private Recipe readFurnace(PacketWrapper packetWrapper) {
        Item[] itemArray = this.readSlotDisplay(packetWrapper);
        this.readSlotDisplay(packetWrapper);
        Item item = this.readSingleSlotDisplay(packetWrapper);
        this.readSlotDisplay(packetWrapper);
        int n = packetWrapper.read(Types.VAR_INT);
        float f = packetWrapper.read(Types.FLOAT).floatValue();
        return this.add(new FurnaceRecipe(itemArray, item, n, f));
    }

    private Recipe readStoneCutter(PacketWrapper packetWrapper) {
        this.readSlotDisplay(packetWrapper);
        this.readSlotDisplay(packetWrapper);
        this.readSlotDisplay(packetWrapper);
        return null;
    }

    private Recipe readSmithing(PacketWrapper packetWrapper) {
        this.readSlotDisplay(packetWrapper);
        this.readSlotDisplay(packetWrapper);
        this.readSlotDisplay(packetWrapper);
        this.readSlotDisplay(packetWrapper);
        this.readSlotDisplay(packetWrapper);
        return null;
    }

    private Recipe add(Recipe recipe) {
        this.tempRecipes.add(recipe);
        return recipe;
    }

    private Item[][] readSlotDisplayList(PacketWrapper packetWrapper) {
        int n = packetWrapper.passthrough(Types.VAR_INT);
        Item[][] itemArray = new Item[n][];
        for (int i = 0; i < n; ++i) {
            itemArray[i] = this.readSlotDisplay(packetWrapper);
        }
        return itemArray;
    }

    private Item readSingleSlotDisplay(PacketWrapper packetWrapper) {
        Item[] itemArray = this.readSlotDisplay(packetWrapper);
        return itemArray.length == 0 ? new StructuredItem(1, 1) : itemArray[0];
    }

    private Item[] readSlotDisplay(PacketWrapper packetWrapper) {
        Item[] itemArray;
        int n = packetWrapper.read(Types.VAR_INT);
        switch (n) {
            case 2: {
                int n2 = packetWrapper.read(Types.VAR_INT);
                if (n2 == 0) {
                    this.protocol.getLogger().warning("Empty item id in recipe");
                    itemArray = new Item[]{};
                    break;
                }
                Item[] itemArray2 = new Item[1];
                itemArray = itemArray2;
                itemArray2[0] = new StructuredItem(this.rewriteItemId(n2), 1);
                break;
            }
            case 3: {
                Item item = this.protocol.getItemRewriter().handleItemToClient(packetWrapper.user(), packetWrapper.read(VersionedTypes.V1_21_2.item()));
                if (item.isEmpty()) {
                    this.protocol.getLogger().warning("Empty item in recipe");
                    itemArray = new Item[]{};
                    break;
                }
                Item[] itemArray3 = new Item[1];
                itemArray = itemArray3;
                itemArray3[0] = item;
                break;
            }
            case 4: {
                packetWrapper.read(Types.STRING);
                itemArray = new Item[]{};
                break;
            }
            case 5: {
                this.readSlotDisplay(packetWrapper);
                this.readSlotDisplay(packetWrapper);
                this.readSlotDisplay(packetWrapper);
                itemArray = new Item[]{};
                break;
            }
            case 6: {
                this.readSlotDisplay(packetWrapper);
                this.readSlotDisplay(packetWrapper);
                itemArray = new Item[]{};
                break;
            }
            case 7: {
                itemArray = this.readSlotDisplayList(packetWrapper)[0];
                break;
            }
            default: {
                itemArray = new Item[]{};
            }
        }
        return itemArray;
    }

    private int rewriteItemId(int n) {
        return this.protocol.getMappingData().getNewItemId(n);
    }

    public void readStoneCutterRecipes(PacketWrapper packetWrapper) {
        this.stoneCutterRecipes.clear();
        int n = packetWrapper.read(Types.VAR_INT);
        for (int i = 0; i < n; ++i) {
            Item[] itemArray = this.readHolderSet(packetWrapper);
            Item item = this.readSingleSlotDisplay(packetWrapper);
            this.stoneCutterRecipes.add(new StoneCutterRecipe(itemArray, item));
        }
    }

    private Item[] readHolderSet(PacketWrapper packetWrapper) {
        HolderSet holderSet = packetWrapper.read(Types.HOLDER_SET);
        if (holderSet.hasTagKey()) {
            return new Item[]{new StructuredItem(1, 1)};
        }
        int[] nArray = holderSet.ids();
        for (int i = 0; i < nArray.length; ++i) {
            nArray[i] = this.rewriteItemId(nArray[i]);
        }
        Item[] itemArray = new Item[nArray.length];
        for (int i = 0; i < itemArray.length; ++i) {
            itemArray[i] = new StructuredItem(nArray[i], 1);
        }
        return itemArray;
    }

    public void setRecipeBookSettings(boolean[] blArray) {
        this.recipeBookSettings = blArray;
    }

    public void clearRecipes() {
        this.recipes.clear();
    }

    public static abstract class Recipe {
        private static final int FOOD_CRAFTING_BOOK_CATEGORY = 0;
        private static final int BLOCKS_CRAFTING_BOOK_CATEGORY = 1;
        private static final int MISC_CRAFTING_BOOK_CATEGORY = 2;
        protected int index;
        private Integer group;
        private int category;
        private boolean highlight;

        Recipe() {
        }

        abstract void write(PacketWrapper var1);

        void writeGroup(PacketWrapper packetWrapper) {
            packetWrapper.write(Types.STRING, this.group != null ? Integer.toString(this.group) : "");
        }

        void writeIngredients(PacketWrapper packetWrapper, Item[][] itemArray) {
            packetWrapper.write(Types.VAR_INT, itemArray.length);
            for (Item[] itemArray2 : itemArray) {
                this.writeIngredient(packetWrapper, itemArray2);
            }
        }

        void writeIngredient(PacketWrapper packetWrapper, Item[] itemArray) {
            Item[] itemArray2 = new Item[itemArray.length];
            for (int i = 0; i < itemArray.length; ++i) {
                itemArray2[i] = itemArray[i].copy();
            }
            packetWrapper.write(VersionedTypes.V1_21_2.itemArray(), itemArray2);
        }

        void writeResult(PacketWrapper packetWrapper, Item item) {
            packetWrapper.write(VersionedTypes.V1_21_2.item(), item.copy());
        }

        void writeCategory(PacketWrapper packetWrapper) {
            int n = switch (this.category) {
                case 4, 9, 12 -> 0;
                case 0, 5, 7, 10 -> 1;
                case 1, 2, 3, 6, 8, 11 -> 2;
                default -> 2;
            };
            packetWrapper.write(Types.VAR_INT, n);
        }

        int category() {
            return this.category;
        }
    }

    private static final class StoneCutterRecipe
    extends Recipe {
        private static final int SERIALIZER_ID = 19;
        private final Item[] ingredient;
        private final Item result;

        private StoneCutterRecipe(Item[] itemArray, Item item) {
            this.ingredient = itemArray;
            this.result = item;
        }

        @Override
        public void write(PacketWrapper packetWrapper) {
            packetWrapper.write(Types.VAR_INT, 19);
            this.writeGroup(packetWrapper);
            this.writeIngredient(packetWrapper, this.ingredient);
            this.writeResult(packetWrapper, this.result);
        }
    }

    private static final class ShapelessRecipe
    extends Recipe {
        private static final int SERIALIZER_ID = 1;
        private final Item[][] ingredients;
        private final Item result;

        private ShapelessRecipe(Item[][] itemArray, Item item) {
            this.ingredients = itemArray;
            this.result = item;
        }

        @Override
        public void write(PacketWrapper packetWrapper) {
            packetWrapper.write(Types.VAR_INT, 1);
            this.writeGroup(packetWrapper);
            this.writeCategory(packetWrapper);
            this.writeIngredients(packetWrapper, this.ingredients);
            this.writeResult(packetWrapper, this.result);
        }
    }

    private static final class ShapedRecipe
    extends Recipe {
        private static final int SERIALIZER_ID = 0;
        private final int width;
        private final int height;
        private final Item[][] ingredients;
        private final Item result;

        private ShapedRecipe(int n, int n2, Item[][] itemArray, Item item) {
            this.width = n;
            this.height = n2;
            this.ingredients = itemArray;
            this.result = item;
        }

        @Override
        public void write(PacketWrapper packetWrapper) {
            packetWrapper.write(Types.VAR_INT, 0);
            this.writeGroup(packetWrapper);
            this.writeCategory(packetWrapper);
            packetWrapper.write(Types.VAR_INT, this.width);
            packetWrapper.write(Types.VAR_INT, this.height);
            Preconditions.checkArgument(this.width * this.height == this.ingredients.length, "Invalid shaped recipe");
            for (Item[] itemArray : this.ingredients) {
                this.writeIngredient(packetWrapper, itemArray);
            }
            this.writeResult(packetWrapper, this.result);
            packetWrapper.write(Types.BOOLEAN, false);
        }
    }

    private static final class FurnaceRecipe
    extends Recipe {
        private final Item[] ingredient;
        private final Item result;
        private final float experience;
        private final int cookingTime;

        private FurnaceRecipe(Item[] itemArray, Item item, int n, float f) {
            this.ingredient = itemArray;
            this.result = item;
            this.experience = f;
            this.cookingTime = n;
        }

        @Override
        public void write(PacketWrapper packetWrapper) {
            packetWrapper.write(Types.VAR_INT, this.serializerId());
            this.writeGroup(packetWrapper);
            this.writeCategory(packetWrapper);
            this.writeIngredient(packetWrapper, this.ingredient);
            this.writeResult(packetWrapper, this.result);
            packetWrapper.write(Types.FLOAT, Float.valueOf(this.experience));
            packetWrapper.write(Types.VAR_INT, this.cookingTime);
        }

        private int serializerId() {
            return switch (this.category()) {
                case 4, 5, 6 -> 15;
                case 7, 8 -> 16;
                case 9 -> 17;
                case 12 -> 18;
                default -> 15;
            };
        }
    }
}

