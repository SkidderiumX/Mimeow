/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.msa.exception;

import net.lenni0451.commons.httpclient.HttpResponse;
import net.raphimc.minecraftauth.util.http.exception.ApiHttpRequestException;

public class MsaRequestException
extends ApiHttpRequestException {
    public MsaRequestException(HttpResponse httpResponse, String string, String string2) {
        super(httpResponse, string, string2);
    }
}

