/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.events.click.types;

import com.viaversion.viaversion.libs.mcstructs.core.utils.ToString;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.ClickEvent;
import com.viaversion.viaversion.libs.mcstructs.text.events.click.ClickEventAction;
import java.net.URI;
import lombok.Generated;

public class OpenUrlClickEvent
extends ClickEvent {
    private UrlHolder url;

    public OpenUrlClickEvent(String string) {
        super(ClickEventAction.OPEN_URL);
        try {
            this.url = new UriHolder(new URI(string));
        }
        catch (Throwable throwable) {
            this.url = new StringHolder(string);
        }
    }

    public OpenUrlClickEvent(URI uRI) {
        super(ClickEventAction.OPEN_URL);
        this.url = new UriHolder(uRI);
    }

    public UrlHolder getHolder() {
        return this.url;
    }

    public OpenUrlClickEvent setHolder(UrlHolder urlHolder) {
        this.url = urlHolder;
        return this;
    }

    public String asString() {
        if (this.url instanceof StringHolder) {
            return ((StringHolder)this.url).getUrl();
        }
        return ((UriHolder)this.url).getUri().toString();
    }

    public URI asUri() throws IllegalArgumentException {
        if (this.url instanceof StringHolder) {
            return URI.create(((StringHolder)this.url).getUrl());
        }
        return ((UriHolder)this.url).getUri();
    }

    public OpenUrlClickEvent setUrl(String string) {
        this.url = new StringHolder(string);
        return this;
    }

    public OpenUrlClickEvent setUrl(URI uRI) {
        this.url = new UriHolder(uRI);
        return this;
    }

    @Override
    public String toString() {
        return ToString.of(this).add("action", this.action).add("url", this.url).toString();
    }

    @Override
    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof OpenUrlClickEvent)) {
            return false;
        }
        OpenUrlClickEvent openUrlClickEvent = (OpenUrlClickEvent)object;
        if (!openUrlClickEvent.canEqual(this)) {
            return false;
        }
        UrlHolder urlHolder = this.url;
        UrlHolder urlHolder2 = openUrlClickEvent.url;
        return !(urlHolder == null ? urlHolder2 != null : !urlHolder.equals(urlHolder2));
    }

    @Generated
    protected boolean canEqual(Object object) {
        return object instanceof OpenUrlClickEvent;
    }

    @Override
    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = 1;
        UrlHolder urlHolder = this.url;
        n2 = n2 * 59 + (urlHolder == null ? 43 : urlHolder.hashCode());
        return n2;
    }

    public static class UriHolder
    implements UrlHolder {
        private final URI uri;

        public String toString() {
            return this.uri.toString();
        }

        @Generated
        public URI getUri() {
            return this.uri;
        }

        @Generated
        public boolean equals(Object object) {
            if (object == this) {
                return true;
            }
            if (!(object instanceof UriHolder)) {
                return false;
            }
            UriHolder uriHolder = (UriHolder)object;
            if (!uriHolder.canEqual(this)) {
                return false;
            }
            URI uRI = this.getUri();
            URI uRI2 = uriHolder.getUri();
            return !(uRI == null ? uRI2 != null : !((Object)uRI).equals(uRI2));
        }

        @Generated
        protected boolean canEqual(Object object) {
            return object instanceof UriHolder;
        }

        @Generated
        public int hashCode() {
            int n = 59;
            int n2 = 1;
            URI uRI = this.getUri();
            n2 = n2 * 59 + (uRI == null ? 43 : ((Object)uRI).hashCode());
            return n2;
        }

        @Generated
        public UriHolder(URI uRI) {
            this.uri = uRI;
        }
    }

    public static class StringHolder
    implements UrlHolder {
        private final String url;

        public String toString() {
            return this.url;
        }

        @Generated
        public String getUrl() {
            return this.url;
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
            String string = this.getUrl();
            String string2 = stringHolder.getUrl();
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
            String string = this.getUrl();
            n2 = n2 * 59 + (string == null ? 43 : string.hashCode());
            return n2;
        }

        @Generated
        public StringHolder(String string) {
            this.url = string;
        }
    }

    public static interface UrlHolder {
    }
}

