/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.bedrock.exception;

import lombok.Generated;
import net.lenni0451.commons.httpclient.HttpResponse;
import net.raphimc.minecraftauth.util.http.exception.ApiHttpRequestException;

public class MinecraftServicesRequestException
extends ApiHttpRequestException {
    private final String namespace;

    public MinecraftServicesRequestException(HttpResponse httpResponse, String string, String string2, String string3) {
        super(httpResponse, string2, string3);
        this.namespace = string;
    }

    @Generated
    public String getNamespace() {
        return this.namespace;
    }
}

