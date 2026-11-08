/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.xbl.request;

import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.stream.Collectors;
import net.lenni0451.commons.gson.elements.GsonArray;
import net.lenni0451.commons.gson.elements.GsonElement;
import net.lenni0451.commons.gson.elements.GsonObject;
import net.lenni0451.commons.httpclient.HttpResponse;
import net.lenni0451.commons.httpclient.requests.impl.GetRequest;
import net.lenni0451.commons.httpclient.utils.URLCoder;
import net.raphimc.minecraftauth.xbl.model.XblUserProfile;
import net.raphimc.minecraftauth.xbl.model.XblXstsToken;
import net.raphimc.minecraftauth.xbl.responsehandler.XblResponseHandler;

public class XblUserProfileSettingsRequest
extends GetRequest
implements XblResponseHandler<XblUserProfile> {
    public XblUserProfileSettingsRequest(XblXstsToken xblXstsToken, String string, String ... stringArray) throws MalformedURLException {
        this(xblXstsToken, string, Arrays.asList(stringArray));
    }

    public XblUserProfileSettingsRequest(XblXstsToken xblXstsToken, String string, Iterable<String> iterable) throws MalformedURLException {
        super("https://profile.xboxlive.com/users/" + URLCoder.encode(string) + "/profile/settings?settings=" + URLCoder.encode(String.join((CharSequence)",", iterable)));
        this.setHeader("Authorization", xblXstsToken.getAuthorizationHeader());
        this.setHeader("x-xbl-contract-version", "3");
    }

    @Override
    public XblUserProfile handle(HttpResponse httpResponse, GsonObject gsonObject2) {
        GsonArray gsonArray = gsonObject2.reqArray("profileUsers");
        if (gsonArray.size() != 1) {
            throw new IllegalStateException("Expected 1 profile user, but got " + gsonArray.size());
        }
        GsonObject gsonObject3 = gsonArray.getObject(0);
        return new XblUserProfile(gsonObject3.reqString("id"), gsonObject3.reqArray("settings").stream().map(GsonElement::asObject).collect(Collectors.toMap(gsonObject -> gsonObject.reqString("id"), gsonObject -> gsonObject.reqString("value"))));
    }
}

