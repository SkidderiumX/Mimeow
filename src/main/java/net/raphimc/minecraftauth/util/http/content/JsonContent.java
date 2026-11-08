/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.util.http.content;

import com.google.gson.JsonObject;
import net.lenni0451.commons.gson.elements.GsonObject;
import net.lenni0451.commons.httpclient.constants.ContentTypes;
import net.lenni0451.commons.httpclient.content.impl.StringContent;

public class JsonContent
extends StringContent {
    public JsonContent(GsonObject gsonObject) {
        this(gsonObject.getJsonObject());
    }

    public JsonContent(JsonObject jsonObject) {
        super(ContentTypes.APPLICATION_JSON, jsonObject.toString());
    }
}

