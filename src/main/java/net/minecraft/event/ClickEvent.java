/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.event;

import com.google.common.collect.Maps;
import java.util.Map;

public class ClickEvent {
    private final Action action;
    private final String value;

    public ClickEvent(Action action, String string) {
        this.action = action;
        this.value = string;
    }

    public Action getAction() {
        return this.action;
    }

    public String getValue() {
        return this.value;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null && this.getClass() == object.getClass()) {
            ClickEvent clickEvent = (ClickEvent)object;
            if (this.action != clickEvent.action) {
                return false;
            }
            return !(this.value != null ? !this.value.equals(clickEvent.value) : clickEvent.value != null);
        }
        return false;
    }

    public String toString() {
        return "ClickEvent{action=" + String.valueOf((Object)this.action) + ", value='" + this.value + "'}";
    }

    public int hashCode() {
        int n = this.action.hashCode();
        n = 31 * n + (this.value != null ? this.value.hashCode() : 0);
        return n;
    }

    public static enum Action {
        OPEN_URL("open_url", true),
        OPEN_FILE("open_file", false),
        RUN_COMMAND("run_command", true),
        SUGGEST_COMMAND("suggest_command", true),
        CHANGE_PAGE("change_page", true);

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

