/*
 * Decompiled with CFR 0.152.
 */
package keystrokesmod.script.model;

import java.util.Collections;
import java.util.List;
import keystrokesmod.script.model.Json;

public class Response {
    private final int responseCode;
    private final String contents;
    private final List<String[]> headers;

    public Response(int n, String string, List<String[]> list) {
        this.responseCode = n;
        this.contents = string;
        this.headers = list == null ? Collections.emptyList() : list;
    }

    public Response(int n, String string) {
        this(n, string, null);
    }

    public int code() {
        return this.responseCode;
    }

    public String string() {
        return this.contents;
    }

    public Json json() {
        return this.contents == null ? null : Json.parse(this.contents);
    }

    public List<String[]> headers() {
        return this.headers;
    }

    public String toString() {
        return "Response(" + this.responseCode + ")";
    }
}

