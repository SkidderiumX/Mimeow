/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.util.http.exception;

import net.lenni0451.commons.httpclient.HttpResponse;
import net.lenni0451.commons.httpclient.exceptions.HttpRequestException;

public class InformativeHttpRequestException
extends HttpRequestException {
    public InformativeHttpRequestException(HttpResponse httpResponse, String string) {
        super(httpResponse, "status: " + httpResponse.getStatusCode() + " " + httpResponse.getStatusMessage() + ", message: " + string);
    }
}

