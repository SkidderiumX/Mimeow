/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.xbl.model;

import com.google.gson.JsonObject;
import lombok.Generated;
import net.lenni0451.commons.gson.elements.GsonObject;
import net.raphimc.minecraftauth.xbl.model.XblTitleToken;
import net.raphimc.minecraftauth.xbl.model.XblUserToken;
import net.raphimc.minecraftauth.xbl.model.XblXstsToken;

public class XblSisuTokens {
    private final XblUserToken userToken;
    private final XblTitleToken titleToken;
    private final XblXstsToken xstsToken;

    public static XblSisuTokens fromJson(JsonObject jsonObject) {
        return XblSisuTokens.fromJson(new GsonObject(jsonObject));
    }

    public static XblSisuTokens fromJson(GsonObject gsonObject) {
        return new XblSisuTokens(XblUserToken.fromJson(gsonObject.getObject("userToken")), XblTitleToken.fromJson(gsonObject.getObject("titleToken")), XblXstsToken.fromJson(gsonObject.getObject("xstsToken")));
    }

    public static JsonObject toJson(XblSisuTokens xblSisuTokens) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("_saveVersion", 1);
        jsonObject.add("userToken", XblUserToken.toJson(xblSisuTokens.userToken));
        jsonObject.add("titleToken", XblTitleToken.toJson(xblSisuTokens.titleToken));
        jsonObject.add("xstsToken", XblXstsToken.toJson(xblSisuTokens.xstsToken));
        return jsonObject;
    }

    @Generated
    public XblSisuTokens(XblUserToken xblUserToken, XblTitleToken xblTitleToken, XblXstsToken xblXstsToken) {
        this.userToken = xblUserToken;
        this.titleToken = xblTitleToken;
        this.xstsToken = xblXstsToken;
    }

    @Generated
    public XblUserToken getUserToken() {
        return this.userToken;
    }

    @Generated
    public XblTitleToken getTitleToken() {
        return this.titleToken;
    }

    @Generated
    public XblXstsToken getXstsToken() {
        return this.xstsToken;
    }

    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof XblSisuTokens)) {
            return false;
        }
        XblSisuTokens xblSisuTokens = (XblSisuTokens)object;
        XblUserToken xblUserToken = this.getUserToken();
        XblUserToken xblUserToken2 = xblSisuTokens.getUserToken();
        if (xblUserToken == null ? xblUserToken2 != null : !((Object)xblUserToken).equals(xblUserToken2)) {
            return false;
        }
        XblTitleToken xblTitleToken = this.getTitleToken();
        XblTitleToken xblTitleToken2 = xblSisuTokens.getTitleToken();
        if (xblTitleToken == null ? xblTitleToken2 != null : !((Object)xblTitleToken).equals(xblTitleToken2)) {
            return false;
        }
        XblXstsToken xblXstsToken = this.getXstsToken();
        XblXstsToken xblXstsToken2 = xblSisuTokens.getXstsToken();
        return !(xblXstsToken == null ? xblXstsToken2 != null : !((Object)xblXstsToken).equals(xblXstsToken2));
    }

    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = 1;
        XblUserToken xblUserToken = this.getUserToken();
        n2 = n2 * 59 + (xblUserToken == null ? 43 : ((Object)xblUserToken).hashCode());
        XblTitleToken xblTitleToken = this.getTitleToken();
        n2 = n2 * 59 + (xblTitleToken == null ? 43 : ((Object)xblTitleToken).hashCode());
        XblXstsToken xblXstsToken = this.getXstsToken();
        n2 = n2 * 59 + (xblXstsToken == null ? 43 : ((Object)xblXstsToken).hashCode());
        return n2;
    }

    @Generated
    public String toString() {
        return "XblSisuTokens(userToken=" + this.getUserToken() + ", titleToken=" + this.getTitleToken() + ", xstsToken=" + this.getXstsToken() + ")";
    }
}

