/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.rewriter;

import com.viaversion.viaversion.api.data.FullMappings;
import com.viaversion.viaversion.api.data.MappingData;
import com.viaversion.viaversion.api.minecraft.HolderSet;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.rewriter.ItemRewriter;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.util.Key;
import java.util.HashMap;
import java.util.Map;

public class RecipeDisplayRewriter<C extends ClientboundPacketType> {
    protected final Map<String, SlotDisplayConsumer> slotDisplayHandlers = new HashMap<String, SlotDisplayConsumer>();
    protected final Protocol<C, ?, ?, ?> protocol;

    public RecipeDisplayRewriter(Protocol<C, ?, ?, ?> protocol) {
        this.protocol = protocol;
        this.slotDisplayHandlers.put("with_any_potion", this::handleSlotDisplay);
        this.slotDisplayHandlers.put("only_with_component", this::handleOnlyWithComponentSlotDisplay);
        this.slotDisplayHandlers.put("item", this::handleItemId);
        this.slotDisplayHandlers.put("item_stack", this::handleItem);
        this.slotDisplayHandlers.put("tag", packetWrapper -> packetWrapper.passthrough(Types.STRING));
        this.slotDisplayHandlers.put("dyed", this::handleDyedSlotDisplay);
        this.slotDisplayHandlers.put("smithing_trim", this::handleSmithingTrimSlotDisplay);
        this.slotDisplayHandlers.put("with_remainder", this::handleWithRemainderSlotDisplay);
        this.slotDisplayHandlers.put("composite", this::handleSlotDisplayList);
    }

    public void registerUpdateRecipes(C c) {
        this.protocol.registerClientbound(c, packetWrapper -> {
            int n;
            int n2 = packetWrapper.passthrough(Types.VAR_INT);
            for (n = 0; n < n2; ++n) {
                packetWrapper.passthrough(Types.STRING);
                this.rewriteItemIds(packetWrapper.passthrough(Types.VAR_INT_ARRAY_PRIMITIVE));
            }
            n = packetWrapper.passthrough(Types.VAR_INT);
            for (int i = 0; i < n; ++i) {
                this.handleIngredient(packetWrapper);
                this.handleSlotDisplay(packetWrapper);
            }
        });
    }

    public void registerRecipeBookAdd(C c) {
        this.protocol.registerClientbound(c, packetWrapper -> {
            int n = packetWrapper.passthrough(Types.VAR_INT);
            for (int i = 0; i < n; ++i) {
                packetWrapper.passthrough(Types.VAR_INT);
                this.handleRecipeDisplay(packetWrapper);
                packetWrapper.passthrough(Types.OPTIONAL_VAR_INT);
                packetWrapper.passthrough(Types.VAR_INT);
                if (packetWrapper.passthrough(Types.BOOLEAN).booleanValue()) {
                    int n2 = packetWrapper.passthrough(Types.VAR_INT);
                    for (int j = 0; j < n2; ++j) {
                        this.handleIngredient(packetWrapper);
                    }
                }
                packetWrapper.passthrough(Types.BYTE);
            }
        });
    }

    public void registerPlaceGhostRecipe(C c) {
        this.protocol.registerClientbound(c, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            this.handleRecipeDisplay(packetWrapper);
        });
    }

    protected void handleShapeless(PacketWrapper packetWrapper) {
        this.handleSlotDisplayList(packetWrapper);
        this.handleSlotDisplay(packetWrapper);
        this.handleSlotDisplay(packetWrapper);
    }

    protected void handleShaped(PacketWrapper packetWrapper) {
        packetWrapper.passthrough(Types.VAR_INT);
        packetWrapper.passthrough(Types.VAR_INT);
        this.handleSlotDisplayList(packetWrapper);
        this.handleSlotDisplay(packetWrapper);
        this.handleSlotDisplay(packetWrapper);
    }

    protected void handleFurnace(PacketWrapper packetWrapper) {
        this.handleSlotDisplay(packetWrapper);
        this.handleSlotDisplay(packetWrapper);
        this.handleSlotDisplay(packetWrapper);
        this.handleSlotDisplay(packetWrapper);
        packetWrapper.passthrough(Types.VAR_INT);
        packetWrapper.passthrough(Types.FLOAT);
    }

    protected void handleStoneCutter(PacketWrapper packetWrapper) {
        this.handleSlotDisplay(packetWrapper);
        this.handleSlotDisplay(packetWrapper);
        this.handleSlotDisplay(packetWrapper);
    }

    protected void handleSmithing(PacketWrapper packetWrapper) {
        this.handleSlotDisplay(packetWrapper);
        this.handleSlotDisplay(packetWrapper);
        this.handleSlotDisplay(packetWrapper);
        this.handleSlotDisplay(packetWrapper);
        this.handleSlotDisplay(packetWrapper);
    }

    protected void handleRecipeDisplay(PacketWrapper packetWrapper) {
        int n = packetWrapper.passthrough(Types.VAR_INT);
        switch (n) {
            case 0: {
                this.handleShapeless(packetWrapper);
                break;
            }
            case 1: {
                this.handleShaped(packetWrapper);
                break;
            }
            case 2: {
                this.handleFurnace(packetWrapper);
                break;
            }
            case 3: {
                this.handleStoneCutter(packetWrapper);
                break;
            }
            case 4: {
                this.handleSmithing(packetWrapper);
            }
        }
    }

    protected void handleSlotDisplay(PacketWrapper packetWrapper) {
        int n;
        FullMappings fullMappings = this.protocol.getMappingData().getSlotDisplayMappings();
        int n2 = fullMappings.getNewId(n = packetWrapper.read(Types.VAR_INT).intValue());
        if (n2 != -1) {
            packetWrapper.write(Types.VAR_INT, n2);
            this.runSlotDisplayHandler(packetWrapper, fullMappings, n);
        } else {
            packetWrapper.write(Types.VAR_INT, 0);
            packetWrapper.consumeReadsOnly(() -> this.runSlotDisplayHandler(packetWrapper, fullMappings, n));
        }
    }

    private void runSlotDisplayHandler(PacketWrapper packetWrapper, FullMappings fullMappings, int n) {
        String string = fullMappings.identifier(n);
        SlotDisplayConsumer slotDisplayConsumer = this.slotDisplayHandlers.get(Key.stripMinecraftNamespace(string));
        if (slotDisplayConsumer != null) {
            slotDisplayConsumer.accept(packetWrapper);
        }
    }

    protected void handleSlotDisplayList(PacketWrapper packetWrapper) {
        int n = packetWrapper.passthrough(Types.VAR_INT);
        for (int i = 0; i < n; ++i) {
            this.handleSlotDisplay(packetWrapper);
        }
    }

    protected void handleSmithingTrimSlotDisplay(PacketWrapper packetWrapper) {
        this.handleSlotDisplay(packetWrapper);
        this.handleSlotDisplay(packetWrapper);
        this.handleSlotDisplay(packetWrapper);
    }

    protected void handleWithRemainderSlotDisplay(PacketWrapper packetWrapper) {
        this.handleSlotDisplay(packetWrapper);
        this.handleSlotDisplay(packetWrapper);
    }

    protected void handleOnlyWithComponentSlotDisplay(PacketWrapper packetWrapper) {
        this.handleSlotDisplay(packetWrapper);
        int n = this.protocol.getMappingData().getDataComponentSerializerMappings().getNewIdOrDefault(packetWrapper.read(Types.VAR_INT), 0);
        packetWrapper.write(Types.VAR_INT, n);
    }

    protected void handleDyedSlotDisplay(PacketWrapper packetWrapper) {
        this.handleSlotDisplay(packetWrapper);
        this.handleSlotDisplay(packetWrapper);
    }

    protected void handleIngredient(PacketWrapper packetWrapper) {
        HolderSet holderSet = packetWrapper.passthrough(Types.HOLDER_SET);
        if (holderSet.hasTagKey()) {
            return;
        }
        int[] nArray = holderSet.ids();
        for (int i = 0; i < nArray.length; ++i) {
            nArray[i] = this.rewriteItemId(nArray[i]);
        }
    }

    protected void handleItemId(PacketWrapper packetWrapper) {
        int n = packetWrapper.read(Types.VAR_INT);
        packetWrapper.write(Types.VAR_INT, this.rewriteItemId(n));
    }

    protected void handleItem(PacketWrapper packetWrapper) {
        ItemRewriter<?> itemRewriter = this.protocol.getItemRewriter();
        Item item = packetWrapper.read(itemRewriter.itemTemplateType());
        itemRewriter.handleItemToClient(packetWrapper.user(), item);
        packetWrapper.write(itemRewriter.mappedItemTemplateType(), item);
    }

    protected int rewriteItemId(int n) {
        MappingData mappingData = this.protocol.getMappingData();
        if (mappingData != null && mappingData.getItemMappings() != null) {
            return mappingData.getItemMappings().getNewIdOrDefault(n, n);
        }
        return n;
    }

    protected void rewriteItemIds(int[] nArray) {
        for (int i = 0; i < nArray.length; ++i) {
            int n = nArray[i];
            nArray[i] = this.rewriteItemId(n);
        }
    }

    @FunctionalInterface
    public static interface SlotDisplayConsumer {
        public void accept(PacketWrapper var1);
    }
}

