/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.extra.realms.request;

import java.io.IOException;
import java.net.MalformedURLException;
import net.lenni0451.commons.gson.elements.GsonObject;
import net.lenni0451.commons.httpclient.HttpResponse;
import net.lenni0451.commons.httpclient.requests.impl.GetRequest;
import net.raphimc.minecraftauth.extra.realms.model.RealmsJoinInformation;
import net.raphimc.minecraftauth.extra.realms.model.RealmsServer;
import net.raphimc.minecraftauth.extra.realms.responsehandler.RealmsResponseHandler;

public class JavaRealmsWorldJoinRequest
extends GetRequest
implements RealmsResponseHandler<RealmsJoinInformation> {
    public JavaRealmsWorldJoinRequest(RealmsServer realmsServer) throws MalformedURLException {
        super("https://pc.realms.minecraft.net/worlds/v1/" + realmsServer.getId() + "/join/pc");
    }

    @Override
    public RealmsJoinInformation handle(HttpResponse httpResponse, GsonObject gsonObject) throws IOException {
        return RealmsJoinInformation.fromApiJson(gsonObject);
    }
}

