/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.util.http.exception;

import lombok.Generated;
import net.lenni0451.commons.httpclient.HttpResponse;
import net.lenni0451.commons.httpclient.exceptions.HttpRequestException;

public class ApiHttpRequestException
extends HttpRequestException {
    private final String error;
    private final String errorMessage;

    public ApiHttpRequestException(HttpResponse httpResponse, String string, String string2) {
        super(httpResponse, "status: " + httpResponse.getStatusCode() + " " + httpResponse.getStatusMessage() + ", error: " + string + ", error message: " + string2);
        this.error = string;
        this.errorMessage = string2;
    }

    @Generated
    public String getError() {
        return this.error;
    }

    @Generated
    public String getErrorMessage() {
        return this.errorMessage;
    }
}

