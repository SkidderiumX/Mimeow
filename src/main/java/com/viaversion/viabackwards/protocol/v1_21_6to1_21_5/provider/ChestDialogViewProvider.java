/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.provider;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.ViaBackwards;
import com.viaversion.viabackwards.api.DialogStyleConfig;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.Protocol1_21_6To1_21_5;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data.Button;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data.Dialog;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data.input.BooleanInput;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data.input.NumberRangeInput;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data.input.SingleOptionInput;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data.input.TextInput;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data.widget.ItemWidget;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data.widget.TextWidget;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data.widget.Widget;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.provider.DialogViewProvider;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.storage.ChestDialogStorage;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.storage.ClickEvents;
import com.viaversion.viabackwards.utils.ChatUtil;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataContainer;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.minecraft.item.StructuredItem;
import com.viaversion.viaversion.api.minecraft.item.data.TooltipDisplay;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.packet.State;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.VersionedTypes;
import com.viaversion.viaversion.libs.fastutil.ints.IntSortedSets;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.packet.ClientboundPackets1_21_5;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.packet.ServerboundPackets1_21_6;
import com.viaversion.viaversion.rewriter.text.ComponentRewriterBase;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.MathUtil;
import java.util.ArrayList;
import java.util.List;
import org.checkerframework.checker.nullness.qual.Nullable;

public class ChestDialogViewProvider
implements DialogViewProvider {
    private static final int INVENTORY_SIZE = 27;
    private static final int INVENTORY_LAST_ROW = 18;
    private final Protocol1_21_6To1_21_5 protocol;

    public ChestDialogViewProvider(Protocol1_21_6To1_21_5 protocol1_21_6To1_21_5) {
        this.protocol = protocol1_21_6To1_21_5;
    }

    @Override
    public void openDialog(UserConnection userConnection, Dialog dialog) {
        State state = userConnection.getProtocolInfo().getClientState();
        if (state == State.CONFIGURATION) {
            return;
        }
        ArrayList<Tag> arrayList = new ArrayList<Tag>();
        for (Widget object2 : new ArrayList<Widget>(dialog.widgets())) {
            if (object2 instanceof TextWidget) {
                TextWidget textWidget = (TextWidget)object2;
                arrayList.add(textWidget.label());
                dialog.widgets().remove(textWidget);
                continue;
            }
            if (arrayList.isEmpty()) continue;
            dialog.widgets().add(dialog.widgets().indexOf(object2), new MultiTextWidget((Tag[])arrayList.toArray(Tag[]::new)));
            arrayList.clear();
        }
        if (!arrayList.isEmpty()) {
            dialog.widgets().add(new MultiTextWidget((Tag[])arrayList.toArray(Tag[]::new)));
            arrayList.clear();
        }
        ChestDialogStorage chestDialogStorage = userConnection.get(ChestDialogStorage.class);
        ChestDialogStorage chestDialogStorage2 = new ChestDialogStorage(this, dialog);
        if (chestDialogStorage != null) {
            chestDialogStorage2.setPreviousDialog(chestDialogStorage.dialog());
        }
        userConnection.put(chestDialogStorage2);
        this.openChestView(userConnection, chestDialogStorage2, ChestDialogStorage.Phase.DIALOG_VIEW);
    }

    public void openChestView(UserConnection userConnection, ChestDialogStorage chestDialogStorage, ChestDialogStorage.Phase phase) {
        chestDialogStorage.setPhase(userConnection, phase);
        PacketWrapper packetWrapper = PacketWrapper.create(ClientboundPackets1_21_5.OPEN_SCREEN, userConnection);
        packetWrapper.write(Types.VAR_INT, chestDialogStorage.containerId());
        packetWrapper.write(Types.VAR_INT, 2);
        packetWrapper.write(Types.TRUSTED_TAG, this.handleTag(userConnection, chestDialogStorage.dialog().title()));
        packetWrapper.send(Protocol1_21_6To1_21_5.class);
        this.updateDialog(userConnection, chestDialogStorage.dialog());
    }

    @Override
    public void closeDialog(UserConnection userConnection) {
        State state = userConnection.getProtocolInfo().getClientState();
        if (state == State.CONFIGURATION) {
            return;
        }
        ChestDialogStorage chestDialogStorage = userConnection.get(ChestDialogStorage.class);
        if (chestDialogStorage == null) {
            return;
        }
        PacketWrapper packetWrapper = PacketWrapper.create(ClientboundPackets1_21_5.CONTAINER_CLOSE, userConnection);
        packetWrapper.write(Types.VAR_INT, chestDialogStorage.containerId());
        packetWrapper.send(Protocol1_21_6To1_21_5.class);
        if (chestDialogStorage.previousDialog() != null) {
            this.openDialog(userConnection, chestDialogStorage.previousDialog());
        } else {
            userConnection.remove(ChestDialogStorage.class);
        }
    }

    public boolean clickDialog(UserConnection userConnection, int n, int n2, byte by, int n3) {
        Object object;
        List<Widget> list;
        ChestDialogStorage chestDialogStorage = userConnection.get(ChestDialogStorage.class);
        if (chestDialogStorage == null || chestDialogStorage.containerId() != n) {
            return false;
        }
        if (n3 != 0 || n2 < 0 || n2 >= 27) {
            this.updateDialog(userConnection, chestDialogStorage.dialog());
            return true;
        }
        if (chestDialogStorage.phase() == ChestDialogStorage.Phase.ANVIL_VIEW) {
            this.openChestView(userConnection, chestDialogStorage, ChestDialogStorage.Phase.DIALOG_VIEW);
            return true;
        }
        if (chestDialogStorage.phase() == ChestDialogStorage.Phase.WAITING_FOR_RESPONSE) {
            if (n2 == chestDialogStorage.actionIndex() && chestDialogStorage.closeButtonEnabled()) {
                this.closeDialog(userConnection);
            } else {
                this.updateDialog(userConnection, chestDialogStorage.dialog());
            }
            return true;
        }
        if (n2 == 26) {
            int n4 = MathUtil.ceil((float)chestDialogStorage.items().length / 18.0f);
            if (by == 0) {
                ++chestDialogStorage.page;
            } else if (by == 1) {
                --chestDialogStorage.page;
            }
            chestDialogStorage.page = MathUtil.clamp(chestDialogStorage.page, 0, n4 - 1);
        }
        if ((n2 += chestDialogStorage.page * 18) < (list = chestDialogStorage.dialog().widgets()).size()) {
            object = list.get(n2);
            if (object instanceof BooleanInput) {
                BooleanInput booleanInput = (BooleanInput)object;
                this.clickBooleanInput(booleanInput);
            } else if (object instanceof NumberRangeInput) {
                NumberRangeInput numberRangeInput = (NumberRangeInput)object;
                this.clickNumberRangeInput(numberRangeInput, by);
            } else if (object instanceof TextInput) {
                TextInput textInput = (TextInput)object;
                this.clickTextInput(userConnection, textInput);
            } else if (object instanceof SingleOptionInput) {
                SingleOptionInput singleOptionInput = (SingleOptionInput)object;
                this.clickSingleOptionInput(singleOptionInput);
            } else if (object instanceof Button) {
                Button button = (Button)object;
                this.clickButton(userConnection, chestDialogStorage.dialog().afterAction(), button);
            } else if (object instanceof Dialog) {
                Dialog dialog = (Dialog)object;
                this.clickDialogButton(userConnection, dialog);
            }
        }
        if (n2 == chestDialogStorage.confirmationYesIndex() && (object = chestDialogStorage.dialog().yesButton()) != null) {
            this.clickButton(userConnection, chestDialogStorage.dialog().afterAction(), (Button)object);
        }
        if (n2 == chestDialogStorage.confirmationNoIndex() && (object = chestDialogStorage.dialog().noButton()) != null) {
            this.clickButton(userConnection, chestDialogStorage.dialog().afterAction(), (Button)object);
        }
        if (n2 == chestDialogStorage.actionIndex() && (object = chestDialogStorage.dialog().actionButton()) != null) {
            this.clickButton(userConnection, chestDialogStorage.dialog().afterAction(), (Button)object);
        }
        if ((object = userConnection.get(ChestDialogStorage.class)) == chestDialogStorage && userConnection.has(ChestDialogStorage.class) && chestDialogStorage.phase() == ChestDialogStorage.Phase.DIALOG_VIEW) {
            this.updateDialog(userConnection, chestDialogStorage.dialog());
        }
        return true;
    }

    public void updateDialog(UserConnection userConnection, Dialog dialog) {
        ChestDialogStorage chestDialogStorage = userConnection.get(ChestDialogStorage.class);
        PacketWrapper packetWrapper = PacketWrapper.create(ClientboundPackets1_21_5.CONTAINER_SET_CONTENT, userConnection);
        packetWrapper.write(Types.VAR_INT, chestDialogStorage.containerId());
        packetWrapper.write(Types.VAR_INT, 0);
        packetWrapper.write(VersionedTypes.V1_21_5.itemArray, this.getItems(userConnection, chestDialogStorage, dialog));
        packetWrapper.write(VersionedTypes.V1_21_5.item, StructuredItem.empty());
        packetWrapper.send(Protocol1_21_6To1_21_5.class);
    }

    protected Item createPageNavigationItem() {
        DialogStyleConfig dialogStyleConfig = ViaBackwards.getConfig().dialogStyleConfig();
        return this.createItem("minecraft:arrow", (Tag)ChatUtil.translate(dialogStyleConfig.pageNavigationTitle()), dialogStyleConfig.pageNavigationNext(), dialogStyleConfig.pageNavigationPrevious());
    }

    protected Item createActionButtonItem(UserConnection userConnection, Button button) {
        Tag tag = this.handleTag(userConnection, button.label());
        if (button.tooltip() == null) {
            return this.createItem("minecraft:oak_button", tag);
        }
        return this.createItem("minecraft:oak_button", tag, this.handleTag(userConnection, button.tooltip()));
    }

    protected Item createCloseButtonItem(Tag tag) {
        return this.createItem("minecraft:oak_button", tag);
    }

    protected Item getItemWidget(UserConnection userConnection, ItemWidget itemWidget) {
        String string = itemWidget.item().getString("id");
        int n = itemWidget.item().getInt("count", 1);
        CompoundTag compoundTag = ChatUtil.translate(Key.stripMinecraftNamespace(string));
        Item item = this.createItem(string, compoundTag);
        item.setAmount(n);
        if (itemWidget.description() != null) {
            item.dataContainer().set(StructuredDataKey.LORE, new Tag[]{this.handleTag(userConnection, ChatUtil.fixStyle(itemWidget.description().label()))});
        }
        if (!itemWidget.showTooltip()) {
            item.dataContainer().set(StructuredDataKey.TOOLTIP_DISPLAY, new TooltipDisplay(true, IntSortedSets.EMPTY_SET));
        }
        return item;
    }

    protected Item getMultiTextWidget(UserConnection userConnection, MultiTextWidget multiTextWidget) {
        ArrayList<Tag> arrayList = new ArrayList<Tag>();
        for (Tag tag : multiTextWidget.labels()) {
            Tag[] tagArray;
            for (Tag tag2 : tagArray = ChatUtil.split(ChatUtil.fixStyle(tag), "\n")) {
                arrayList.add(this.handleTag(userConnection, tag2));
            }
        }
        Tag[] tagArray = new Tag[arrayList.size() - 1];
        for (int i = 1; i < arrayList.size(); ++i) {
            tagArray[i - 1] = (Tag)arrayList.get(i);
        }
        return this.createItem("minecraft:paper", (Tag)arrayList.get(0), tagArray);
    }

    protected Item getBooleanInput(UserConnection userConnection, BooleanInput booleanInput) {
        DialogStyleConfig dialogStyleConfig = ViaBackwards.getConfig().dialogStyleConfig();
        String string = booleanInput.value() ? "minecraft:lime_dye" : "minecraft:gray_dye";
        Tag[] tagArray = ChatUtil.split(booleanInput.label(), "\n");
        if (tagArray.length == 1) {
            return this.createItem(string, this.handleTag(userConnection, booleanInput.label()), ChatUtil.translate(dialogStyleConfig.toggleValue()));
        }
        Tag[] tagArray2 = new Tag[tagArray.length];
        for (int i = 1; i < tagArray.length; ++i) {
            tagArray2[i - 1] = this.handleTag(userConnection, ChatUtil.fixStyle(tagArray[i]));
        }
        tagArray2[tagArray2.length - 1] = ChatUtil.translate(dialogStyleConfig.toggleValue());
        return this.createItem(string, this.handleTag(userConnection, tagArray[0]), tagArray2);
    }

    protected void clickBooleanInput(BooleanInput booleanInput) {
        booleanInput.setValue(!booleanInput.value());
    }

    protected Item getNumberRangeInput(UserConnection userConnection, NumberRangeInput numberRangeInput) {
        DialogStyleConfig dialogStyleConfig = ViaBackwards.getConfig().dialogStyleConfig();
        Tag tag = this.handleTag(userConnection, numberRangeInput.displayName());
        return this.createItem("minecraft:clock", tag, String.format(dialogStyleConfig.increaseValue(), Float.valueOf(numberRangeInput.step())), String.format(dialogStyleConfig.decreaseValue(), Float.valueOf(numberRangeInput.step())), String.format(dialogStyleConfig.valueRange(), Float.valueOf(numberRangeInput.start()), Float.valueOf(numberRangeInput.end())));
    }

    protected void clickNumberRangeInput(NumberRangeInput numberRangeInput, int n) {
        float f = numberRangeInput.value();
        if (n == 0) {
            f += numberRangeInput.step();
        } else if (n == 1) {
            f -= numberRangeInput.step();
        }
        numberRangeInput.setClampedValue(f);
    }

    protected Item getTextInput(UserConnection userConnection, TextInput textInput) {
        DialogStyleConfig dialogStyleConfig = ViaBackwards.getConfig().dialogStyleConfig();
        CompoundTag compoundTag = ChatUtil.translate(String.format(dialogStyleConfig.currentValue(), textInput.value()));
        if (textInput.label() == null) {
            return this.createItem("minecraft:writable_book", compoundTag);
        }
        Tag tag = this.handleTag(userConnection, textInput.label());
        return this.createItem("minecraft:writable_book", tag, compoundTag, ChatUtil.translate(dialogStyleConfig.editValue()));
    }

    protected void clickTextInput(UserConnection userConnection, TextInput textInput) {
        ChestDialogStorage chestDialogStorage = userConnection.get(ChestDialogStorage.class);
        this.openAnvilView(userConnection, chestDialogStorage, ChatUtil.translate("\u00a77Edit text"), textInput.value(), textInput);
    }

    protected Item getSingleOptionInput(UserConnection userConnection, SingleOptionInput singleOptionInput) {
        DialogStyleConfig dialogStyleConfig = ViaBackwards.getConfig().dialogStyleConfig();
        Tag tag = singleOptionInput.options()[singleOptionInput.value()].computeDisplay();
        Tag tag2 = singleOptionInput.label() != null ? ChatUtil.translate("options.generic_value", singleOptionInput.label(), tag) : tag;
        return this.createItem("minecraft:bookshelf", this.handleTag(userConnection, tag2), dialogStyleConfig.nextOption(), dialogStyleConfig.previousOption());
    }

    protected void clickSingleOptionInput(SingleOptionInput singleOptionInput) {
        singleOptionInput.setClampedValue(singleOptionInput.value() + 1);
    }

    protected Item getButton(UserConnection userConnection, Button button) {
        return this.createItem("minecraft:oak_button", this.handleTag(userConnection, button.label()));
    }

    public void clickButton(UserConnection userConnection, Dialog.AfterAction afterAction, @Nullable Button button) {
        String string;
        ChestDialogStorage chestDialogStorage = userConnection.get(ChestDialogStorage.class);
        switch (afterAction) {
            case CLOSE: {
                this.closeDialog(userConnection);
                break;
            }
            case WAIT_FOR_RESPONSE: {
                chestDialogStorage.setPhase(null, ChestDialogStorage.Phase.WAITING_FOR_RESPONSE);
            }
        }
        if (button == null || button.clickEvent() == null) {
            return;
        }
        CompoundTag compoundTag = button.clickEvent();
        switch (string = Key.stripMinecraftNamespace(compoundTag.getString("action"))) {
            case "open_url": {
                String string2 = compoundTag.getString("url");
                this.openAnvilView(userConnection, chestDialogStorage, ChatUtil.translate("Open URL"), string2, null);
                break;
            }
            case "run_command": {
                PacketWrapper packetWrapper = PacketWrapper.create(ServerboundPackets1_21_6.CHAT_COMMAND, userConnection);
                String string3 = compoundTag.getString("command");
                if (string3.startsWith("/")) {
                    string3 = string3.substring(1);
                }
                packetWrapper.write(Types.STRING, string3);
                packetWrapper.sendToServer(Protocol1_21_6To1_21_5.class);
                break;
            }
            case "copy_to_clipboard": {
                String string4 = compoundTag.getString("value");
                this.openAnvilView(userConnection, chestDialogStorage, ChatUtil.translate("Copy to clipboard"), string4, null);
            }
        }
        ClickEvents.handleClickEvent(userConnection, compoundTag);
    }

    protected Item createTextInputItem(String string) {
        DialogStyleConfig dialogStyleConfig = ViaBackwards.getConfig().dialogStyleConfig();
        return this.createItem("minecraft:paper", (Tag)ChatUtil.translate(string), dialogStyleConfig.setText());
    }

    protected Item createTextCopyItem(String string) {
        DialogStyleConfig dialogStyleConfig = ViaBackwards.getConfig().dialogStyleConfig();
        return this.createItem("minecraft:paper", (Tag)ChatUtil.translate(string), dialogStyleConfig.close());
    }

    protected void openAnvilView(UserConnection userConnection, ChestDialogStorage chestDialogStorage, Tag tag, String string, TextInput textInput) {
        chestDialogStorage.setPhase(userConnection, ChestDialogStorage.Phase.ANVIL_VIEW);
        PacketWrapper packetWrapper = PacketWrapper.create(ClientboundPackets1_21_5.OPEN_SCREEN, userConnection);
        packetWrapper.write(Types.VAR_INT, chestDialogStorage.containerId());
        packetWrapper.write(Types.VAR_INT, 8);
        packetWrapper.write(Types.TRUSTED_TAG, tag);
        packetWrapper.send(Protocol1_21_6To1_21_5.class);
        Item[] itemArray = new Item[]{textInput != null ? this.createTextInputItem(string) : this.createTextCopyItem(string)};
        chestDialogStorage.setCurrentTextInput(textInput);
        PacketWrapper packetWrapper2 = PacketWrapper.create(ClientboundPackets1_21_5.CONTAINER_SET_CONTENT, userConnection);
        packetWrapper2.write(Types.VAR_INT, chestDialogStorage.containerId());
        packetWrapper2.write(Types.VAR_INT, 0);
        packetWrapper2.write(VersionedTypes.V1_21_5.itemArray, itemArray);
        packetWrapper2.write(VersionedTypes.V1_21_5.item, StructuredItem.empty());
        packetWrapper2.send(Protocol1_21_6To1_21_5.class);
    }

    public void updateAnvilText(UserConnection userConnection, String string) {
        if (string.isEmpty()) {
            return;
        }
        ChestDialogStorage chestDialogStorage = userConnection.get(ChestDialogStorage.class);
        if (chestDialogStorage.currentTextInput() != null) {
            chestDialogStorage.currentTextInput().setClampedValue(string);
        }
    }

    protected Item getDialog(UserConnection userConnection, Dialog dialog) {
        Tag tag = dialog.externalTitle() != null ? dialog.externalTitle() : dialog.title();
        return this.createItem("minecraft:command_block", this.handleTag(userConnection, tag));
    }

    protected void clickDialogButton(UserConnection userConnection, Dialog dialog) {
        this.closeDialog(userConnection);
        this.openDialog(userConnection, dialog);
    }

    protected Item getItem(UserConnection userConnection, Widget widget) {
        if (widget instanceof ItemWidget) {
            ItemWidget itemWidget = (ItemWidget)widget;
            return this.getItemWidget(userConnection, itemWidget);
        }
        if (widget instanceof MultiTextWidget) {
            MultiTextWidget multiTextWidget = (MultiTextWidget)widget;
            return this.getMultiTextWidget(userConnection, multiTextWidget);
        }
        if (widget instanceof BooleanInput) {
            BooleanInput booleanInput = (BooleanInput)widget;
            return this.getBooleanInput(userConnection, booleanInput);
        }
        if (widget instanceof NumberRangeInput) {
            NumberRangeInput numberRangeInput = (NumberRangeInput)widget;
            return this.getNumberRangeInput(userConnection, numberRangeInput);
        }
        if (widget instanceof TextInput) {
            TextInput textInput = (TextInput)widget;
            return this.getTextInput(userConnection, textInput);
        }
        if (widget instanceof SingleOptionInput) {
            SingleOptionInput singleOptionInput = (SingleOptionInput)widget;
            return this.getSingleOptionInput(userConnection, singleOptionInput);
        }
        if (widget instanceof Button) {
            Button button = (Button)widget;
            return this.getButton(userConnection, button);
        }
        if (widget instanceof Dialog) {
            Dialog dialog = (Dialog)widget;
            return this.getDialog(userConnection, dialog);
        }
        throw new IllegalArgumentException("Unknown widget type: " + widget.getClass().getName());
    }

    protected Item[] getItems(UserConnection userConnection, ChestDialogStorage chestDialogStorage, Dialog dialog) {
        Item[] itemArray = StructuredItem.emptyArray(27);
        int n = -1;
        int n2 = -1;
        int n3 = -1;
        if (chestDialogStorage.phase() == ChestDialogStorage.Phase.WAITING_FOR_RESPONSE) {
            n3 = 13;
            itemArray[n3] = this.createCloseButtonItem(chestDialogStorage.closeButtonLabel());
            chestDialogStorage.setItems(itemArray, n, n2, n3);
            return itemArray;
        }
        List<Widget> list = dialog.widgets();
        if (list.size() > 18) {
            int n4 = chestDialogStorage.page * 18;
            int n5 = Math.min((chestDialogStorage.page + 1) * 18, list.size());
            for (int i = 0; i < n5 - n4; ++i) {
                itemArray[i] = this.getItem(userConnection, list.get(n4 + i));
            }
            itemArray[26] = this.createPageNavigationItem();
        } else {
            for (int i = 0; i < list.size(); ++i) {
                itemArray[i] = this.getItem(userConnection, list.get(i));
            }
        }
        if (dialog.yesButton() != null && dialog.noButton() != null) {
            n = list.isEmpty() ? 11 : 20;
            n2 = list.isEmpty() ? 15 : 24;
            itemArray[n] = this.createActionButtonItem(userConnection, dialog.yesButton());
            itemArray[n2] = this.createActionButtonItem(userConnection, dialog.noButton());
        }
        if (dialog.actionButton() != null) {
            n3 = list.isEmpty() ? 13 : 18;
            itemArray[n3] = this.createActionButtonItem(userConnection, dialog.actionButton());
        }
        chestDialogStorage.setItems(itemArray, n, n2, n3);
        return itemArray;
    }

    protected @Nullable Tag handleTag(UserConnection userConnection, @Nullable Tag tag) {
        if (tag == null) {
            return null;
        }
        ((ComponentRewriterBase)this.protocol.getComponentRewriter()).processTag(userConnection, tag);
        return tag;
    }

    protected Item createItem(String string, Tag tag) {
        return this.createItem(string, tag, new String[0]);
    }

    protected Item createItem(String string, Tag tag, Tag ... tagArray) {
        int n = this.protocol.getMappingData().getFullItemMappings().mappedId(string);
        StructuredDataContainer structuredDataContainer = new StructuredDataContainer();
        structuredDataContainer.setIdLookup(this.protocol, true);
        structuredDataContainer.set(StructuredDataKey.ITEM_NAME, tag);
        if (tagArray != null) {
            structuredDataContainer.set(StructuredDataKey.LORE, tagArray);
        }
        return new StructuredItem(n, 1, structuredDataContainer);
    }

    protected Item createItem(String string, Tag tag, String ... stringArray) {
        int n = this.protocol.getMappingData().getFullItemMappings().mappedId(string);
        StructuredDataContainer structuredDataContainer = new StructuredDataContainer();
        structuredDataContainer.setIdLookup(this.protocol, true);
        structuredDataContainer.set(StructuredDataKey.ITEM_NAME, tag);
        if (stringArray.length > 0) {
            ArrayList<CompoundTag> arrayList = new ArrayList<CompoundTag>();
            for (String string2 : stringArray) {
                arrayList.add(ChatUtil.translate(string2));
            }
            structuredDataContainer.set(StructuredDataKey.LORE, arrayList.toArray(new Tag[0]));
        }
        return new StructuredItem(n, 1, structuredDataContainer);
    }

    public record MultiTextWidget(Tag[] labels) implements Widget
    {
    }
}

