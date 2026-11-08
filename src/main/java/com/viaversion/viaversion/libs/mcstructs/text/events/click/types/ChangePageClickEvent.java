/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.events.click.types;

import com.viaversion.viaversion.libs.mcstructs.core.utils.ToString;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.ClickEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.ClickEventAction;
import lombok.Generated;

public class ChangePageClickEvent
extends ClickEvent {
    private PageHolder page;

    public ChangePageClickEvent(String string) {
        super(ClickEventAction.CHANGE_PAGE);
        try {
            this.page = new IntHolder(Integer.parseInt(string));
        }
        catch (Throwable throwable) {
            this.page = new StringHolder(string);
        }
    }

    public ChangePageClickEvent(int n) {
        super(ClickEventAction.CHANGE_PAGE);
        this.page = new IntHolder(n);
    }

    public PageHolder getHolder() {
        return this.page;
    }

    public String asString() {
        if (this.page instanceof StringHolder) {
            return ((StringHolder)this.page).getPage();
        }
        return String.valueOf(((IntHolder)this.page).getPage());
    }

    public int asInt() throws NumberFormatException {
        if (this.page instanceof StringHolder) {
            return Integer.parseInt(((StringHolder)this.page).getPage());
        }
        return ((IntHolder)this.page).getPage();
    }

    public ChangePageClickEvent setPage(String string) {
        this.page = new StringHolder(string);
        return this;
    }

    public ChangePageClickEvent setPage(int n) {
        this.page = new IntHolder(n);
        return this;
    }

    @Override
    public String toString() {
        return ToString.of(this).add("action", this.action).add("page", this.page).toString();
    }

    @Override
    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof ChangePageClickEvent)) {
            return false;
        }
        ChangePageClickEvent changePageClickEvent = (ChangePageClickEvent)object;
        if (!changePageClickEvent.canEqual(this)) {
            return false;
        }
        PageHolder pageHolder = this.page;
        PageHolder pageHolder2 = changePageClickEvent.page;
        return !(pageHolder == null ? pageHolder2 != null : !pageHolder.equals(pageHolder2));
    }

    @Generated
    protected boolean canEqual(Object object) {
        return object instanceof ChangePageClickEvent;
    }

    @Override
    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = 1;
        PageHolder pageHolder = this.page;
        n2 = n2 * 59 + (pageHolder == null ? 43 : pageHolder.hashCode());
        return n2;
    }

    public static class IntHolder
    implements PageHolder {
        private int page;

        public String toString() {
            return String.valueOf(this.page);
        }

        @Generated
        public int getPage() {
            return this.page;
        }

        @Generated
        public void setPage(int n) {
            this.page = n;
        }

        @Generated
        public boolean equals(Object object) {
            if (object == this) {
                return true;
            }
            if (!(object instanceof IntHolder)) {
                return false;
            }
            IntHolder intHolder = (IntHolder)object;
            if (!intHolder.canEqual(this)) {
                return false;
            }
            return this.getPage() == intHolder.getPage();
        }

        @Generated
        protected boolean canEqual(Object object) {
            return object instanceof IntHolder;
        }

        @Generated
        public int hashCode() {
            int n = 59;
            int n2 = 1;
            n2 = n2 * 59 + this.getPage();
            return n2;
        }

        @Generated
        public IntHolder(int n) {
            this.page = n;
        }
    }

    public static class StringHolder
    implements PageHolder {
        private String page;

        public String toString() {
            return this.page;
        }

        @Generated
        public String getPage() {
            return this.page;
        }

        @Generated
        public void setPage(String string) {
            this.page = string;
        }

        @Generated
        public boolean equals(Object object) {
            if (object == this) {
                return true;
            }
            if (!(object instanceof StringHolder)) {
                return false;
            }
            StringHolder stringHolder = (StringHolder)object;
            if (!stringHolder.canEqual(this)) {
                return false;
            }
            String string = this.getPage();
            String string2 = stringHolder.getPage();
            return !(string == null ? string2 != null : !string.equals(string2));
        }

        @Generated
        protected boolean canEqual(Object object) {
            return object instanceof StringHolder;
        }

        @Generated
        public int hashCode() {
            int n = 59;
            int n2 = 1;
            String string = this.getPage();
            n2 = n2 * 59 + (string == null ? 43 : string.hashCode());
            return n2;
        }

        @Generated
        public StringHolder(String string) {
            this.page = string;
        }
    }

    public static interface PageHolder {
    }
}

