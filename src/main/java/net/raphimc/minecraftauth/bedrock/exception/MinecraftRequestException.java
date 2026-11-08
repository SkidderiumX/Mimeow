/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.bedrock.exception;

import net.lenni0451.commons.httpclient.HttpResponse;
import net.raphimc.minecraftauth.util.http.exception.ApiHttpRequestException;

public class MinecraftRequestException
extends ApiHttpRequestException {
    public MinecraftRequestException(HttpResponse httpResponse, String string, String string2) {
        super(httpResponse, string, string2);
    }
}

