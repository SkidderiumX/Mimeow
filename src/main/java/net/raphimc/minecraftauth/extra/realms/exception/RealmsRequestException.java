/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.extra.realms.exception;

import lombok.Generated;
import net.lenni0451.commons.httpclient.HttpResponse;
import net.raphimc.minecraftauth.util.http.exception.ApiHttpRequestException;

public class RealmsRequestException
extends ApiHttpRequestException {
    public static final int ERROR_TOS_NOT_ACCEPTED = 6002;
    private final int errorCode;

    public RealmsRequestException(HttpResponse httpResponse, int n, String string) {
        super(httpResponse, String.valueOf(n), string);
        this.errorCode = n;
    }

    @Generated
    public int getErrorCode() {
        return this.errorCode;
    }
}

