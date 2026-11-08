/*
 * Decompiled with CFR 0.152.
 */
package net.lenni0451.commons.httpclient;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import net.lenni0451.commons.httpclient.model.HttpHeader;

public abstract class HeaderStore<T extends HeaderStore<T>> {
    private final Map<String, List<String>> headers = new HashMap<String, List<String>>();

    public HeaderStore() {
    }

    public HeaderStore(Map<String, List<String>> map) {
        map.forEach((string, list) -> this.headers.put(string.toLowerCase(Locale.ROOT), new ArrayList(list)));
    }

    public Map<String, List<String>> getHeaders() {
        return Collections.unmodifiableMap(this.headers.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, entry -> new ArrayList((Collection)entry.getValue()))));
    }

    public List<String> getHeader(String string) {
        return this.headers.get(string.toLowerCase());
    }

    public Optional<String> getFirstHeader(String string) {
        List<String> list = this.headers.get(string.toLowerCase(Locale.ROOT));
        if (list == null || list.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(list.get(0));
    }

    public Optional<String> getLastHeader(String string) {
        List<String> list = this.headers.get(string.toLowerCase(Locale.ROOT));
        if (list == null || list.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(list.get(list.size() - 1));
    }

    public T appendHeader(String string2, String string3) {
        this.headers.computeIfAbsent(string2.toLowerCase(Locale.ROOT), string -> new ArrayList()).add(string3);
        return (T)this;
    }

    public T appendHeader(HttpHeader ... httpHeaderArray) {
        for (HttpHeader httpHeader : httpHeaderArray) {
            this.appendHeader(httpHeader.getName(), httpHeader.getValue());
        }
        return (T)this;
    }

    public T appendHeader(Collection<HttpHeader> collection) {
        for (HttpHeader httpHeader : collection) {
            this.appendHeader(httpHeader.getName(), httpHeader.getValue());
        }
        return (T)this;
    }

    public T setHeader(String string, String string2) {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add(string2);
        this.headers.put(string.toLowerCase(Locale.ROOT), arrayList);
        return (T)this;
    }

    public T setHeader(HttpHeader ... httpHeaderArray) {
        for (HttpHeader httpHeader : httpHeaderArray) {
            this.setHeader(httpHeader.getName(), httpHeader.getValue());
        }
        return (T)this;
    }

    public T setHeader(Collection<HttpHeader> collection) {
        for (HttpHeader httpHeader : collection) {
            this.setHeader(httpHeader.getName(), httpHeader.getValue());
        }
        return (T)this;
    }

    public T removeHeader(String string) {
        this.headers.remove(string.toLowerCase(Locale.ROOT));
        return (T)this;
    }

    public T clearHeaders() {
        this.headers.clear();
        return (T)this;
    }

    public boolean hasHeader(String string) {
        return this.headers.containsKey(string.toLowerCase(Locale.ROOT));
    }

    public boolean hasHeader(String string, String string2) {
        return this.headers.get(string.toLowerCase(Locale.ROOT)).contains(string2);
    }

    public boolean hasHeader(HttpHeader httpHeader) {
        return this.hasHeader(httpHeader.getName(), httpHeader.getValue());
    }

    public T forEachHeader(BiConsumer<String, String> biConsumer) {
        for (Map.Entry<String, List<String>> entry : this.headers.entrySet()) {
            for (String string : entry.getValue()) {
                biConsumer.accept(entry.getKey(), string);
            }
        }
        return (T)this;
    }
}

