/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.extra.realms.request;

import java.io.IOException;
import java.net.MalformedURLException;
import net.lenni0451.commons.gson.elements.GsonObject;
import net.lenni0451.commons.httpclient.HttpResponse;
import net.lenni0451.commons.httpclient.requests.impl.PostRequest;
import net.raphimc.minecraftauth.extra.realms.responsehandler.RealmsResponseHandler;

public class JavaRealmsTosAgreedRequest
extends PostRequest
implements RealmsResponseHandler<Void> {
    public JavaRealmsTosAgreedRequest() throws MalformedURLException {
        super("https://pc.realms.minecraft.net/mco/tos/agreed");
    }

    @Override
    public Void handle(HttpResponse httpResponse, GsonObject gsonObject) throws IOException {
        throw new UnsupportedOperationException("This request is not supposed to return any data");
    }
}

