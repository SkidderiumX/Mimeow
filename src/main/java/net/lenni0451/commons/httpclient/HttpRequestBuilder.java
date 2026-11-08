/*
 * Decompiled with CFR 0.152.
 */
package net.lenni0451.commons.httpclient;

import java.net.MalformedURLException;
import java.net.URL;
import net.lenni0451.commons.httpclient.requests.HttpContentRequest;
import net.lenni0451.commons.httpclient.requests.HttpRequest;
import net.lenni0451.commons.httpclient.requests.impl.DeleteRequest;
import net.lenni0451.commons.httpclient.requests.impl.GetRequest;
import net.lenni0451.commons.httpclient.requests.impl.HeadRequest;
import net.lenni0451.commons.httpclient.requests.impl.PostRequest;
import net.lenni0451.commons.httpclient.requests.impl.PutRequest;

public interface HttpRequestBuilder {
    default public <T extends HttpRequest> T bind(T t) {
        return t;
    }

    default public GetRequest get(String string) throws MalformedURLException {
        return this.bind(new GetRequest(string));
    }

    default public GetRequest get(URL uRL) {
        return this.bind(new GetRequest(uRL));
    }

    default public HeadRequest head(String string) throws MalformedURLException {
        return this.bind(new HeadRequest(string));
    }

    default public HeadRequest head(URL uRL) {
        return this.bind(new HeadRequest(uRL));
    }

    default public DeleteRequest delete(String string) throws MalformedURLException {
        return this.bind(new DeleteRequest(string));
    }

    default public DeleteRequest delete(URL uRL) {
        return this.bind(new DeleteRequest(uRL));
    }

    default public PostRequest post(String string) throws MalformedURLException {
        return this.bind(new PostRequest(string));
    }

    default public PostRequest post(URL uRL) {
        return this.bind(new PostRequest(uRL));
    }

    default public PutRequest put(String string) throws MalformedURLException {
        return this.bind(new PutRequest(string));
    }

    default public PutRequest put(URL uRL) {
        return this.bind(new PutRequest(uRL));
    }

    default public HttpRequest request(String string, String string2) throws MalformedURLException {
        return this.bind(new HttpRequest(string, string2));
    }

    default public HttpRequest request(String string, URL uRL) {
        return this.bind(new HttpRequest(string, uRL));
    }

    default public HttpContentRequest contentRequest(String string, String string2) throws MalformedURLException {
        return this.bind(new HttpContentRequest(string, string2));
    }

    default public HttpContentRequest contentRequest(String string, URL uRL) {
        return this.bind(new HttpContentRequest(string, uRL));
    }
}

