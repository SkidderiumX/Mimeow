/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.rewriter;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.FullMappings;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.util.Key;
import java.util.HashMap;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.Nullable;

public class RecipeRewriter<C extends ClientboundPacketType> {
    protected final Protocol<C, ?, ?, ?> protocol;
    protected final Map<String, RecipeConsumer> recipeHandlers = new HashMap<String, RecipeConsumer>();

    public RecipeRewriter(Protocol<C, ?, ?, ?> protocol) {
        this.protocol = protocol;
        this.recipeHandlers.put("crafting_shapeless", this::handleCraftingShapeless);
        this.recipeHandlers.put("crafting_shaped", this::handleCraftingShaped);
        this.recipeHandlers.put("smelting", this::handleSmelting);
        this.recipeHandlers.put("blasting", this::handleSmelting);
        this.recipeHandlers.put("smoking", this::handleSmelting);
        this.recipeHandlers.put("campfire_cooking", this::handleSmelting);
        this.recipeHandlers.put("stonecutting", this::handleStonecutting);
        this.recipeHandlers.put("smithing", this::handleSmithing);
        this.recipeHandlers.put("smithing_transform", this::handleSmithingTransform);
        this.recipeHandlers.put("smithing_trim", this::handleSmithingTrim);
        this.recipeHandlers.put("crafting_decorated_pot", this::handleSimpleRecipe);
    }

    public void handleRecipeType(PacketWrapper packetWrapper, String string) {
        RecipeConsumer recipeConsumer = this.recipeHandlers.get(Key.stripMinecraftNamespace(string));
        if (recipeConsumer != null) {
            recipeConsumer.accept(packetWrapper);
        }
    }

    public void register(C c) {
        this.protocol.registerClientbound(c, packetWrapper -> {
            int n = packetWrapper.passthrough(Types.VAR_INT);
            for (int i = 0; i < n; ++i) {
                String string = packetWrapper.passthrough(Types.STRING);
                packetWrapper.passthrough(Types.STRING);
                this.handleRecipeType(packetWrapper, string);
            }
        });
    }

    public void register1_20_5(C c) {
        this.protocol.registerClientbound(c, packetWrapper -> {
            int n;
            int n2 = n = packetWrapper.passthrough(Types.VAR_INT).intValue();
            for (int i = 0; i < n; ++i) {
                int n3;
                String string = packetWrapper.read(Types.STRING);
                FullMappings fullMappings = this.protocol.getMappingData().getRecipeSerializerMappings();
                int n4 = fullMappings.getNewId(n3 = packetWrapper.read(Types.VAR_INT).intValue());
                if (n4 != -1) {
                    packetWrapper.write(Types.STRING, string);
                    packetWrapper.write(Types.VAR_INT, n4);
                } else {
                    packetWrapper.set(Types.VAR_INT, 0, --n2);
                }
                this.handleRecipeType(packetWrapper, Key.stripMinecraftNamespace(fullMappings.identifier(n3)));
            }
        });
    }

    public void handleCraftingShaped(PacketWrapper packetWrapper) {
        int n = packetWrapper.passthrough(Types.VAR_INT) * packetWrapper.passthrough(Types.VAR_INT);
        packetWrapper.passthrough(Types.STRING);
        for (int i = 0; i < n; ++i) {
            this.handleIngredient(packetWrapper);
        }
        this.handleResult(packetWrapper);
    }

    public void handleCraftingShapeless(PacketWrapper packetWrapper) {
        packetWrapper.passthrough(Types.STRING);
        this.handleIngredients(packetWrapper);
        this.handleResult(packetWrapper);
    }

    public void handleSmelting(PacketWrapper packetWrapper) {
        packetWrapper.passthrough(Types.STRING);
        this.handleIngredient(packetWrapper);
        this.handleResult(packetWrapper);
        packetWrapper.passthrough(Types.FLOAT);
        packetWrapper.passthrough(Types.VAR_INT);
    }

    public void handleStonecutting(PacketWrapper packetWrapper) {
        packetWrapper.passthrough(Types.STRING);
        this.handleIngredient(packetWrapper);
        this.handleResult(packetWrapper);
    }

    public void handleSmithing(PacketWrapper packetWrapper) {
        this.handleIngredient(packetWrapper);
        this.handleIngredient(packetWrapper);
        this.handleResult(packetWrapper);
    }

    public void handleSimpleRecipe(PacketWrapper packetWrapper) {
        packetWrapper.passthrough(Types.VAR_INT);
    }

    public void handleSmithingTransform(PacketWrapper packetWrapper) {
        this.handleIngredient(packetWrapper);
        this.handleIngredient(packetWrapper);
        this.handleIngredient(packetWrapper);
        this.handleResult(packetWrapper);
    }

    public void handleSmithingTrim(PacketWrapper packetWrapper) {
        this.handleIngredient(packetWrapper);
        this.handleIngredient(packetWrapper);
        this.handleIngredient(packetWrapper);
    }

    protected int rewrite(int n) {
        if (this.protocol.getMappingData() != null && this.protocol.getItemRewriter() != null) {
            return this.protocol.getMappingData().getNewItemId(n);
        }
        return n;
    }

    protected @Nullable Item rewrite(UserConnection userConnection, @Nullable Item item) {
        if (this.protocol.getItemRewriter() != null) {
            return this.protocol.getItemRewriter().handleItemToClient(userConnection, item);
        }
        return item;
    }

    protected void handleIngredient(PacketWrapper packetWrapper) {
        Item[] itemArray = packetWrapper.passthroughAndMap(this.itemArrayType(), this.mappedItemArrayType());
        for (int i = 0; i < itemArray.length; ++i) {
            Item item = itemArray[i];
            itemArray[i] = this.rewrite(packetWrapper.user(), item);
        }
    }

    protected void handleIngredients(PacketWrapper packetWrapper) {
        int n = packetWrapper.passthrough(Types.VAR_INT);
        for (int i = 0; i < n; ++i) {
            this.handleIngredient(packetWrapper);
        }
    }

    protected void handleResult(PacketWrapper packetWrapper) {
        Item item = this.rewrite(packetWrapper.user(), packetWrapper.read(this.itemType()));
        packetWrapper.write(this.mappedItemType(), item);
    }

    protected Type<Item> itemType() {
        return Types.ITEM1_13_2;
    }

    protected Type<Item[]> itemArrayType() {
        return Types.ITEM1_13_2_ARRAY;
    }

    protected Type<Item> mappedItemType() {
        return this.itemType();
    }

    protected Type<Item[]> mappedItemArrayType() {
        return this.itemArrayType();
    }

    @FunctionalInterface
    public static interface RecipeConsumer {
        public void accept(PacketWrapper var1);
    }
}

