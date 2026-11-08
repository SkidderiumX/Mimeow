/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.extra.realms.request;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import net.lenni0451.commons.gson.elements.GsonElement;
import net.lenni0451.commons.gson.elements.GsonObject;
import net.lenni0451.commons.httpclient.HttpResponse;
import net.lenni0451.commons.httpclient.requests.impl.GetRequest;
import net.raphimc.minecraftauth.extra.realms.model.RealmsServer;
import net.raphimc.minecraftauth.extra.realms.responsehandler.RealmsResponseHandler;

public class RealmsWorldsRequest
extends GetRequest
implements RealmsResponseHandler<List<RealmsServer>> {
    public RealmsWorldsRequest(String string) throws MalformedURLException {
        super("https://" + string + "/worlds");
    }

    @Override
    public List<RealmsServer> handle(HttpResponse httpResponse, GsonObject gsonObject) throws IOException {
        ArrayList<RealmsServer> arrayList = new ArrayList<RealmsServer>();
        for (GsonElement gsonElement : gsonObject.reqArray("servers")) {
            arrayList.add(RealmsServer.fromApiJson(gsonElement.asObject()));
        }
        return arrayList;
    }
}

