/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth;

import net.lenni0451.commons.httpclient.HttpClient;
import net.lenni0451.commons.httpclient.constants.ContentTypes;
import net.lenni0451.commons.httpclient.retry.RetryConfig;

public class MinecraftAuth {
    public static final String VERSION = "5.0.2";
    public static final String IMPL_VERSION = "5.0.2+1f61b49";

    public static HttpClient createHttpClient() {
        return MinecraftAuth.createHttpClient("MinecraftAuth/5.0.2");
    }

    public static HttpClient createHttpClient(String string) {
        return (HttpClient)((HttpClient)((HttpClient)new HttpClient().setConnectTimeout(5000).setReadTimeout(30000).setCookieManager(null).setFollowRedirects(false).setRetryHandler(new RetryConfig(0, 50)).setHeader("Accept", ContentTypes.APPLICATION_JSON.toString())).setHeader("Accept-Language", "en-US,en")).setHeader("User-Agent", string);
    }
}

