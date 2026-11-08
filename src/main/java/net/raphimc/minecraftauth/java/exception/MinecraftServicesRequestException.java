/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.java.exception;

import net.lenni0451.commons.httpclient.HttpResponse;
import net.raphimc.minecraftauth.util.http.exception.ApiHttpRequestException;

public class MinecraftServicesRequestException
extends ApiHttpRequestException {
    public MinecraftServicesRequestException(HttpResponse httpResponse, String string, String string2) {
        super(httpResponse, string, string2);
    }
}

