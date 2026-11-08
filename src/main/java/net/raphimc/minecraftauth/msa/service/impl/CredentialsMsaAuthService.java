/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.msa.service.impl;

import com.google.gson.stream.JsonReader;
import java.io.IOException;
import java.io.StringReader;
import java.net.CookieManager;
import java.net.URL;
import java.util.HashMap;
import java.util.Optional;
import net.lenni0451.commons.gson.GsonParser;
import net.lenni0451.commons.gson.elements.GsonObject;
import net.lenni0451.commons.httpclient.HeaderStore;
import net.lenni0451.commons.httpclient.HttpClient;
import net.lenni0451.commons.httpclient.HttpResponse;
import net.lenni0451.commons.httpclient.constants.ContentTypes;
import net.lenni0451.commons.httpclient.content.impl.URLEncodedFormContent;
import net.lenni0451.commons.httpclient.exceptions.HttpRequestException;
import net.lenni0451.commons.httpclient.requests.HttpContentRequest;
import net.lenni0451.commons.httpclient.requests.HttpRequest;
import net.lenni0451.commons.httpclient.requests.impl.GetRequest;
import net.lenni0451.commons.httpclient.requests.impl.PostRequest;
import net.lenni0451.commons.httpclient.utils.URLWrapper;
import net.raphimc.minecraftauth.msa.exception.MsaRequestException;
import net.raphimc.minecraftauth.msa.model.MsaApplicationConfig;
import net.raphimc.minecraftauth.msa.model.MsaCredentials;
import net.raphimc.minecraftauth.msa.model.MsaToken;
import net.raphimc.minecraftauth.msa.request.MsaAuthCodeTokenRequest;
import net.raphimc.minecraftauth.msa.service.MsaAuthService;
import net.raphimc.minecraftauth.util.http.exception.InformativeHttpRequestException;

public class CredentialsMsaAuthService
extends MsaAuthService {
    private final MsaCredentials credentials;

    public CredentialsMsaAuthService(HttpClient httpClient, MsaApplicationConfig msaApplicationConfig, MsaCredentials msaCredentials) {
        super(httpClient, msaApplicationConfig);
        this.credentials = msaCredentials;
    }

    @Override
    public MsaToken acquireToken() throws IOException {
        return this.acquireToken(this.credentials);
    }

    public MsaToken acquireToken(MsaCredentials msaCredentials) throws IOException {
        CookieManager cookieManager = new CookieManager();
        PostRequest postRequest = this.prepareLoginRequest(msaCredentials, cookieManager);
        HttpResponse httpResponse = this.sendLoginRequest(postRequest);
        String string = httpResponse.getFirstHeader("Location").orElseThrow(() -> new IllegalStateException("Failed to get redirect url"));
        String string2 = URLWrapper.ofURI(string).wrapQueryParameters().getFirstValue("code").orElseThrow(() -> new IllegalStateException("Failed to extract auth code from redirect url"));
        return (MsaToken)this.httpClient.executeAndHandle(new MsaAuthCodeTokenRequest(this.applicationConfig, string2));
    }

    private PostRequest prepareLoginRequest(MsaCredentials msaCredentials, CookieManager cookieManager) throws IOException {
        Object object;
        String string;
        URL uRL = URLWrapper.ofURL(this.applicationConfig.getEnvironment().getAuthorizeUrl()).wrapQueryParameters().addParameters(this.applicationConfig.getAuthCodeParameters()).apply().toURL();
        GetRequest getRequest = new GetRequest(uRL);
        getRequest.setCookieManager(cookieManager);
        getRequest.setHeader("Accept", ContentTypes.TEXT_HTML.getMimeType());
        GsonObject gsonObject = this.httpClient.execute(getRequest, httpResponse -> {
            if (httpResponse.getStatusCode() >= 300) {
                Optional<String> optional = httpResponse.getFirstHeader("Location");
                if (optional.isPresent()) {
                    URLWrapper.QueryParametersWrapper queryParametersWrapper = URLWrapper.ofURI(optional.get()).wrapQueryParameters();
                    Optional<String> optional2 = queryParametersWrapper.getFirstValue("error");
                    Optional<String> optional3 = queryParametersWrapper.getFirstValue("error_description");
                    if (optional2.isPresent() && optional3.isPresent()) {
                        throw new MsaRequestException(httpResponse, optional2.get(), optional3.get());
                    }
                }
                throw new HttpRequestException(httpResponse);
            }
            return this.extractConfig(httpResponse.getContent().getAsString());
        });
        HashMap<String, String> hashMap = new HashMap<String, String>();
        switch (this.applicationConfig.getEnvironment()) {
            case LIVE: {
                string = gsonObject.reqString("urlPost");
                object = gsonObject.reqString("sFTTag");
                String string2 = ((String)object).substring(((String)object).indexOf("value=\"") + 7);
                string2 = string2.substring(0, string2.indexOf("\""));
                String string3 = ((String)object).substring(((String)object).indexOf("name=\"") + 6);
                string3 = string3.substring(0, string3.indexOf("\""));
                hashMap.put("login", msaCredentials.getEmail());
                hashMap.put("loginfmt", msaCredentials.getEmail());
                hashMap.put("passwd", msaCredentials.getPassword());
                hashMap.put(string3, string2);
                break;
            }
            case MICROSOFT_ONLINE_COMMON: 
            case MICROSOFT_ONLINE_CONSUMERS: {
                string = URLWrapper.ofURI(gsonObject.reqString("urlPost")).setProtocol(uRL.getProtocol()).setHost(uRL.getHost()).toURL().toString();
                hashMap.put("login", msaCredentials.getEmail());
                hashMap.put("loginfmt", msaCredentials.getEmail());
                hashMap.put("passwd", msaCredentials.getPassword());
                hashMap.put("ctx", gsonObject.reqString("sCtx"));
                hashMap.put(gsonObject.reqString("sFTName"), gsonObject.reqString("sFT"));
                break;
            }
            default: {
                throw new IllegalStateException("Unsupported MsaEnvironment: " + (Object)((Object)this.applicationConfig.getEnvironment()));
            }
        }
        object = new PostRequest(string);
        ((HttpRequest)object).setCookieManager(cookieManager);
        ((HeaderStore)object).setHeader("Accept", ContentTypes.TEXT_HTML.getMimeType());
        ((HttpContentRequest)object).setContent(new URLEncodedFormContent(hashMap));
        return object;
    }

    private HttpResponse sendLoginRequest(HttpRequest httpRequest) throws IOException {
        HttpResponse httpResponse = this.httpClient.execute(httpRequest);
        if (httpResponse.getStatusCode() != 302) {
            if (!httpResponse.getContent().getType().getMimeType().equals(ContentTypes.TEXT_HTML.getMimeType())) {
                throw new InformativeHttpRequestException(httpResponse, "Wrong content type");
            }
            String string = httpResponse.getContent().getAsString();
            if (string.contains("<body onload=\"javascript:DoSubmit();\">")) {
                String string2 = string.substring(string.indexOf("action=\"") + 8);
                String string3 = URLWrapper.ofURL(string2 = string2.substring(0, string2.indexOf("\""))).wrapQueryParameters().getFirstValue("ru").orElse(null);
                if (string3 == null) {
                    throw new IllegalStateException("Failed to extract return url from html");
                }
                GetRequest getRequest = new GetRequest(string3);
                getRequest.setCookieManager(httpRequest.getCookieManager());
                getRequest.setHeader("Accept", ContentTypes.TEXT_HTML.getMimeType());
                return this.sendLoginRequest(getRequest);
            }
            GsonObject gsonObject = this.extractConfig(string);
            switch (this.applicationConfig.getEnvironment()) {
                case LIVE: {
                    if (!gsonObject.hasString("sErrorCode") || !gsonObject.hasString("sErrTxt")) break;
                    throw new MsaRequestException(httpResponse, gsonObject.reqString("sErrorCode"), gsonObject.reqString("sErrTxt"));
                }
                case MICROSOFT_ONLINE_COMMON: 
                case MICROSOFT_ONLINE_CONSUMERS: {
                    if (!gsonObject.hasString("iErrorCode") || !gsonObject.hasString("strServiceExceptionMessage")) break;
                    throw new MsaRequestException(httpResponse, gsonObject.reqString("iErrorCode"), gsonObject.reqString("strServiceExceptionMessage"));
                }
                default: {
                    throw new IllegalStateException("Unsupported MsaEnvironment: " + (Object)((Object)this.applicationConfig.getEnvironment()));
                }
            }
            throw new IllegalStateException("Failed to extract config from html. This most likely indicates that the application config or credentials are not valid");
        }
        return httpResponse;
    }

    private GsonObject extractConfig(String string) {
        String string2;
        switch (this.applicationConfig.getEnvironment()) {
            case LIVE: {
                int n = string.indexOf("var ServerData = ");
                if (n == -1) {
                    throw new IllegalStateException("Failed to find config start in html");
                }
                string2 = string.substring(n + 17);
                break;
            }
            case MICROSOFT_ONLINE_COMMON: 
            case MICROSOFT_ONLINE_CONSUMERS: {
                int n = string.indexOf("$Config=");
                if (n == -1) {
                    throw new IllegalStateException("Failed to find config start in html");
                }
                string2 = string.substring(n + 8);
                break;
            }
            default: {
                throw new IllegalStateException("Unsupported MsaEnvironment: " + (Object)((Object)this.applicationConfig.getEnvironment()));
            }
        }
        try {
            JsonReader jsonReader = new JsonReader(new StringReader(string2));
            jsonReader.setLenient(true);
            return GsonParser.parse(jsonReader).asObject();
        }
        catch (Throwable throwable) {
            throw new IllegalStateException("Failed to extract config from html. This most likely indicates that the application config or credentials are not valid", throwable);
        }
    }
}

