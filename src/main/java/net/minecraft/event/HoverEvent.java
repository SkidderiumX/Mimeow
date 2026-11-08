/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.event;

import com.google.common.collect.Maps;
import java.util.Map;
import net.minecraft.util.IChatComponent;

public class HoverEvent {
    private final Action action;
    private final IChatComponent value;

    public HoverEvent(Action action, IChatComponent iChatComponent) {
        this.action = action;
        this.value = iChatComponent;
    }

    public Action getAction() {
        return this.action;
    }

    public IChatComponent getValue() {
        return this.value;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null && this.getClass() == object.getClass()) {
            HoverEvent hoverEvent = (HoverEvent)object;
            if (this.action != hoverEvent.action) {
                return false;
            }
            return !(this.value != null ? !this.value.equals(hoverEvent.value) : hoverEvent.value != null);
        }
        return false;
    }

    public String toString() {
        return "HoverEvent{action=" + String.valueOf((Object)this.action) + ", value='" + String.valueOf(this.value) + "'}";
    }

    public int hashCode() {
        int n = this.action.hashCode();
        n = 31 * n + (this.value != null ? this.value.hashCode() : 0);
        return n;
    }

    public static enum Action {
        SHOW_TEXT("show_text", true),
        SHOW_ACHIEVEMENT("show_achievement", true),
        SHOW_ITEM("show_item", true),
        SHOW_ENTITY("show_entity", true);

        private static final Map<String, Action> nameMapping;
        private final boolean allowedInChat;
        private final String canonicalName;

        private Action(String string2, boolean bl) {
            this.canonicalName = string2;
            this.allowedInChat = bl;
        }

        public boolean shouldAllowInChat() {
            return this.allowedInChat;
        }

        public String getCanonicalName() {
            return this.canonicalName;
        }

        public static Action getValueByCanonicalName(String string) {
            return nameMapping.get(string);
        }

        static {
            nameMapping = Maps.newHashMap();
            for (Action action : Action.values()) {
                nameMapping.put(action.getCanonicalName(), action);
            }
        }
    }
}

