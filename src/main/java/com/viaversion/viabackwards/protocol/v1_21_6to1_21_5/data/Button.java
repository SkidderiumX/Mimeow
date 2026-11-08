/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data.Dialog;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data.Template;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data.input.Input;
import com.viaversion.viabackwards.protocol.v1_21_6to1_21_5.data.widget.Widget;
import com.viaversion.viaversion.util.Key;
import java.util.HashMap;
import org.checkerframework.checker.nullness.qual.Nullable;

public class Button
implements Widget {
    public static final Button DEFAULT = Button.defaulted();
    private static final String[] CLICK_EVENTS = new String[]{"open_url", "run_command", "suggest_command", "show_dialog", "change_page", "copy_to_clipboard", "custom"};
    private final Dialog dialog;
    private final Tag label;
    private final int width;
    private final @Nullable Tag tooltip;
    private @Nullable CompoundTag clickEvent;
    private @Nullable Template template;
    private @Nullable String id;
    private @Nullable CompoundTag additions;

    public Button(Dialog dialog, CompoundTag compoundTag) {
        this.dialog = dialog;
        this.label = compoundTag.get("label");
        this.tooltip = compoundTag.get("tooltip");
        int n = compoundTag.getInt("width", 150);
        if (n < 1 || n > 1024) {
            throw new IllegalArgumentException("Width must be between 1 and 1024, got: " + n);
        }
        this.width = n;
        CompoundTag compoundTag2 = compoundTag.getCompoundTag("action");
        if (compoundTag2 == null) {
            return;
        }
        String string = compoundTag2.getString("type");
        if (string == null) {
            throw new IllegalArgumentException("Action type is missing in tag: " + String.valueOf(compoundTag));
        }
        for (String string2 : CLICK_EVENTS) {
            if (!Key.stripMinecraftNamespace(string).equals(string2)) continue;
            this.clickEvent = compoundTag2.copy();
            this.clickEvent.put("action", this.clickEvent.remove("type"));
            return;
        }
        if (Key.stripMinecraftNamespace(string).equals("dynamic/run_command")) {
            this.template = Template.fromString(compoundTag2.getString("template"));
        } else if (Key.stripMinecraftNamespace(string).equals("dynamic/custom")) {
            this.id = compoundTag2.getString("id");
            this.additions = compoundTag2.getCompoundTag("additions");
        }
    }

    private static Button defaulted() {
        CompoundTag compoundTag = new CompoundTag();
        CompoundTag compoundTag2 = new CompoundTag();
        compoundTag.put("label", compoundTag2);
        compoundTag2.putString("translate", "gui.ok");
        return new Button(null, compoundTag);
    }

    public static Button openUrl(Tag tag, String string) {
        CompoundTag compoundTag = new CompoundTag();
        CompoundTag compoundTag2 = new CompoundTag();
        CompoundTag compoundTag3 = new CompoundTag();
        compoundTag.put("label", tag);
        compoundTag.put("action", compoundTag2);
        compoundTag2.putString("type", "open_url");
        compoundTag2.put("action", compoundTag3);
        compoundTag3.putString("url", string);
        return new Button(null, compoundTag);
    }

    public @Nullable CompoundTag clickEvent() {
        if (this.clickEvent != null) {
            return this.clickEvent;
        }
        if (this.dialog == null) {
            return null;
        }
        Input[] inputArray = (Input[])this.dialog.widgets().stream().filter(widget -> widget instanceof Input).toArray(Input[]::new);
        if (this.template != null) {
            HashMap<String, String> hashMap = new HashMap<String, String>();
            for (Input input : inputArray) {
                hashMap.put(input.key(), input.asCommandSubstitution());
            }
            CompoundTag compoundTag = new CompoundTag();
            compoundTag.putString("action", "run_command");
            compoundTag.putString("command", this.template.instantiate(hashMap));
            return compoundTag;
        }
        if (this.id != null) {
            CompoundTag compoundTag = this.additions != null ? this.additions.copy() : new CompoundTag();
            for (Input input : inputArray) {
                compoundTag.put(input.key(), input.asTag());
            }
            CompoundTag compoundTag2 = new CompoundTag();
            compoundTag2.putString("action", "custom");
            compoundTag2.putString("id", this.id);
            compoundTag2.put("payload", compoundTag);
            return compoundTag2;
        }
        return null;
    }

    public Tag label() {
        return this.label;
    }

    public @Nullable Tag tooltip() {
        return this.tooltip;
    }

    public int width() {
        return this.width;
    }
}

