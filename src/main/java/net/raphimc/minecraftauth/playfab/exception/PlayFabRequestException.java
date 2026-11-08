/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.playfab.exception;

import net.lenni0451.commons.httpclient.HttpResponse;
import net.raphimc.minecraftauth.util.http.exception.ApiHttpRequestException;

public class PlayFabRequestException
extends ApiHttpRequestException {
    public PlayFabRequestException(HttpResponse httpResponse, String string, String string2) {
        super(httpResponse, string, string2);
    }
}

