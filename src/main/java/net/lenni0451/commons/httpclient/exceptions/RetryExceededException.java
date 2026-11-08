/*
 * Decompiled with CFR 0.152.
 */
package net.lenni0451.commons.httpclient.exceptions;

import net.lenni0451.commons.httpclient.HttpResponse;
import net.lenni0451.commons.httpclient.exceptions.HttpRequestException;

public class RetryExceededException
extends HttpRequestException {
    public RetryExceededException(HttpResponse httpResponse) {
        super(httpResponse, "Maximum retry count exceeded");
    }

    public RetryExceededException(HttpResponse httpResponse, String string) {
        super(httpResponse, string);
    }
}

