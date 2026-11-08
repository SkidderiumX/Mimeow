/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data.Button;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data.input.BooleanInput;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data.input.NumberRangeInput;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data.input.SingleOptionInput;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data.input.TextInput;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data.widget.ItemWidget;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data.widget.TextWidget;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data.widget.Widget;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.storage.RegistryAndTags;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.storage.ServerLinks;
import com.viaversion.viaversion.util.Key;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.Nullable;

public class Dialog
implements Widget {
    private final List<Widget> widgets = new ArrayList<Widget>();
    private final Tag title;
    private final @Nullable Tag externalTitle;
    private final boolean canCloseWithEscape;
    private final AfterAction afterAction;
    private @Nullable Button actionButton;
    private @Nullable Button yesButton;
    private @Nullable Button noButton;
    private int columns;
    private int buttonWidth;

    public Dialog(RegistryAndTags registryAndTags, ServerLinks serverLinks, CompoundTag compoundTag) {
        ListTag<CompoundTag> listTag;
        String string = compoundTag.getString("type");
        if (string == null) {
            throw new IllegalArgumentException("Dialog type is missing in tag: " + String.valueOf(compoundTag));
        }
        this.title = compoundTag.get("title");
        this.externalTitle = compoundTag.get("external_title");
        this.canCloseWithEscape = compoundTag.getBoolean("can_close_with_escape", true);
        this.afterAction = AfterAction.valueOf(compoundTag.getString("after_action", "close").toUpperCase(Locale.ROOT));
        ListTag<CompoundTag> listTag2 = compoundTag.getListTag("body", CompoundTag.class);
        if (listTag2 == null && (listTag = compoundTag.getCompoundTag("body")) != null) {
            listTag2 = new ListTag<CompoundTag>(CompoundTag.class);
            listTag2.add((CompoundTag)((Object)listTag));
        }
        if (listTag2 != null) {
            listTag = listTag2.iterator();
            while (listTag.hasNext()) {
                Object object = (CompoundTag)listTag.next();
                this.fillBodyWidget((CompoundTag)object);
            }
        }
        if ((listTag = compoundTag.getListTag("inputs", CompoundTag.class)) != null) {
            for (CompoundTag compoundTag2 : listTag) {
                this.fillInputWidget(compoundTag2);
            }
        }
        switch (Key.stripMinecraftNamespace(string)) {
            case "notice": {
                this.fillNoticeDialog(compoundTag);
                break;
            }
            case "server_links": {
                this.fillServerLinksDialog(serverLinks, compoundTag);
                break;
            }
            case "dialog_list": {
                this.fillDialogList(registryAndTags, serverLinks, compoundTag);
                break;
            }
            case "multi_action": {
                this.fillMultiActionDialog(compoundTag);
                break;
            }
            case "confirmation": {
                this.fillConfirmationDialog(compoundTag);
                break;
            }
            default: {
                throw new IllegalArgumentException("Unknown dialog type: " + string + " in tag: " + String.valueOf(compoundTag));
            }
        }
    }

    private void fillBodyWidget(CompoundTag compoundTag) {
        String string = compoundTag.getString("type");
        if (string == null) {
            throw new IllegalArgumentException("Dialog type is missing in tag: " + String.valueOf(compoundTag));
        }
        if (Key.stripMinecraftNamespace(string).equals("plain_message")) {
            this.widgets.add(new TextWidget(compoundTag));
        } else if (Key.stripMinecraftNamespace(string).equals("item")) {
            this.widgets.add(new ItemWidget(compoundTag));
        } else {
            throw new IllegalArgumentException("Unknown dialog body type: " + string + " in tag: " + String.valueOf(compoundTag));
        }
    }

    private void fillInputWidget(CompoundTag compoundTag) {
        String string = compoundTag.getString("type");
        if (string == null) {
            throw new IllegalArgumentException("Dialog type is missing in tag: " + String.valueOf(compoundTag));
        }
        this.widgets.add(switch (Key.stripMinecraftNamespace(string)) {
            case "boolean" -> new BooleanInput(compoundTag);
            case "number_range" -> new NumberRangeInput(compoundTag);
            case "single_option" -> new SingleOptionInput(compoundTag);
            case "text" -> new TextInput(compoundTag);
            default -> throw new IllegalArgumentException("Unknown dialog input type: " + string + " in tag: " + String.valueOf(compoundTag));
        });
    }

    private void fillNoticeDialog(CompoundTag compoundTag) {
        CompoundTag compoundTag2 = compoundTag.getCompoundTag("action");
        this.actionButton = compoundTag2 == null ? Button.DEFAULT : new Button(this, compoundTag2);
    }

    private void fillServerLinksDialog(ServerLinks serverLinks, CompoundTag compoundTag) {
        this.fillDialogBase(compoundTag);
        this.buttonWidth = compoundTag.getInt("button_width", 150);
        if (serverLinks == null) {
            return;
        }
        for (Map.Entry entry : serverLinks.links().entrySet()) {
            Tag tag = (Tag)entry.getKey();
            String string = (String)entry.getValue();
            this.widgets.add(Button.openUrl(tag, string));
        }
    }

    private void fillDialogList(RegistryAndTags registryAndTags, ServerLinks serverLinks, CompoundTag compoundTag2) {
        ListTag<CompoundTag> listTag = compoundTag2.getListTag("dialogs", CompoundTag.class);
        if (listTag == null) {
            CompoundTag compoundTag3 = compoundTag2.getCompoundTag("dialogs");
            if (compoundTag3 != null) {
                listTag = new ListTag<CompoundTag>(CompoundTag.class);
                listTag.add(compoundTag3);
            }
            ListTag<StringTag> listTag2 = compoundTag2.getListTag("dialogs", StringTag.class);
            StringTag stringTag = compoundTag2.getStringTag("dialogs");
            if (stringTag != null) {
                listTag2 = new ListTag<StringTag>(StringTag.class);
                listTag2.add(stringTag);
            }
            if (listTag2 != null) {
                listTag = new ListTag<CompoundTag>(CompoundTag.class);
                for (StringTag stringTag2 : listTag2) {
                    String string = stringTag2.getValue();
                    if (string.startsWith("#")) {
                        for (CompoundTag compoundTag4 : registryAndTags.fromRegistryKey(string.substring(1))) {
                            listTag.add(compoundTag4);
                        }
                        continue;
                    }
                    listTag.add(registryAndTags.fromRegistry(string));
                }
            }
        }
        this.widgets.addAll(listTag.stream().map(compoundTag -> new Dialog(registryAndTags, serverLinks, (CompoundTag)compoundTag)).toList());
        this.fillDialogBase(compoundTag2);
        this.buttonWidth = compoundTag2.getInt("button_width", 150);
    }

    private void fillDialogBase(CompoundTag compoundTag) {
        CompoundTag compoundTag2 = compoundTag.getCompoundTag("exit_action");
        this.actionButton = compoundTag2 == null ? null : new Button(this, compoundTag2);
        int n = compoundTag.getInt("columns", 2);
        if (n < 1) {
            throw new IllegalArgumentException("Columns must be non-negative, got: " + n);
        }
        this.columns = n;
    }

    private void fillMultiActionDialog(CompoundTag compoundTag2) {
        ListTag<CompoundTag> listTag = compoundTag2.getListTag("actions", CompoundTag.class);
        if (listTag == null || listTag.isEmpty()) {
            throw new IllegalArgumentException("Actions must not be empty in tag: " + String.valueOf(compoundTag2));
        }
        this.widgets.addAll(listTag.stream().map(compoundTag -> new Button(this, (CompoundTag)compoundTag)).toList());
        this.fillDialogBase(compoundTag2);
    }

    private void fillConfirmationDialog(CompoundTag compoundTag) {
        this.yesButton = new Button(this, compoundTag.getCompoundTag("yes"));
        this.noButton = new Button(this, compoundTag.getCompoundTag("no"));
    }

    public Tag title() {
        return this.title;
    }

    public @Nullable Tag externalTitle() {
        return this.externalTitle;
    }

    public boolean canCloseWithEscape() {
        return this.canCloseWithEscape;
    }

    public AfterAction afterAction() {
        return this.afterAction;
    }

    public @Nullable Button actionButton() {
        return this.actionButton;
    }

    public @Nullable Button yesButton() {
        return this.yesButton;
    }

    public @Nullable Button noButton() {
        return this.noButton;
    }

    public int columns() {
        return this.columns;
    }

    public int buttonWidth() {
        return this.buttonWidth;
    }

    public List<Widget> widgets() {
        return this.widgets;
    }

    public static enum AfterAction {
        CLOSE,
        NONE,
        WAIT_FOR_RESPONSE;

    }
}

