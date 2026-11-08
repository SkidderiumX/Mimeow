/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.authlib;

import com.mojang.authlib.BaseAuthenticationService;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.Validate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class HttpAuthenticationService
extends BaseAuthenticationService {
    private static final Logger LOGGER = LogManager.getLogger();
    private final Proxy proxy;

    protected HttpAuthenticationService(Proxy proxy) {
        Validate.notNull(proxy);
        this.proxy = proxy;
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    protected HttpURLConnection createUrlConnection(URL uRL) throws IOException {
        Validate.notNull(uRL);
        LOGGER.debug("Opening connection to " + uRL);
        HttpURLConnection httpURLConnection = (HttpURLConnection)uRL.openConnection(this.proxy);
        httpURLConnection.setConnectTimeout(15000);
        httpURLConnection.setReadTimeout(15000);
        httpURLConnection.setUseCaches(false);
        return httpURLConnection;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String performPostRequest(URL uRL, String string, String string2) throws IOException {
        Validate.notNull(uRL);
        Validate.notNull(string);
        Validate.notNull(string2);
        HttpURLConnection httpURLConnection = this.createUrlConnection(uRL);
        byte[] byArray = string.getBytes(Charsets.UTF_8);
        httpURLConnection.setRequestProperty("Content-Type", string2 + "; charset=utf-8");
        httpURLConnection.setRequestProperty("Content-Length", "" + byArray.length);
        httpURLConnection.setDoOutput(true);
        LOGGER.debug("Writing POST data to " + uRL + ": " + string);
        OutputStream outputStream2 = null;
        try {
            outputStream2 = httpURLConnection.getOutputStream();
            IOUtils.write(byArray, outputStream2);
        }
        finally {
            IOUtils.closeQuietly(outputStream2);
        }
        LOGGER.debug("Reading data from " + uRL);
        InputStream inputStream2 = null;
        try {
            inputStream2 = httpURLConnection.getInputStream();
            String string3 = IOUtils.toString(inputStream2, Charsets.UTF_8);
            LOGGER.debug("Successful read, server response was " + httpURLConnection.getResponseCode());
            LOGGER.debug("Response: " + string3);
            String string4 = string3;
            return string4;
        }
        catch (IOException iOException) {
            IOUtils.closeQuietly(inputStream2);
            inputStream2 = httpURLConnection.getErrorStream();
            if (inputStream2 != null) {
                LOGGER.debug("Reading error page from " + uRL);
                String string5 = IOUtils.toString(inputStream2, Charsets.UTF_8);
                LOGGER.debug("Successful read, server response was " + httpURLConnection.getResponseCode());
                LOGGER.debug("Response: " + string5);
                String string6 = string5;
                return string6;
            }
            LOGGER.debug("Request failed", (Throwable)iOException);
            throw iOException;
        }
        finally {
            IOUtils.closeQuietly(inputStream2);
        }
    }

    public String performGetRequest(URL uRL) throws IOException {
        Validate.notNull(uRL);
        HttpURLConnection httpURLConnection = this.createUrlConnection(uRL);
        LOGGER.debug("Reading data from " + uRL);
        InputStream inputStream2 = null;
        try {
            inputStream2 = httpURLConnection.getInputStream();
            String string = IOUtils.toString(inputStream2, Charsets.UTF_8);
            LOGGER.debug("Successful read, server response was " + httpURLConnection.getResponseCode());
            LOGGER.debug("Response: " + string);
            String string2 = string;
            return string2;
        }
        catch (IOException iOException) {
            IOUtils.closeQuietly(inputStream2);
            inputStream2 = httpURLConnection.getErrorStream();
            if (inputStream2 != null) {
                LOGGER.debug("Reading error page from " + uRL);
                String string = IOUtils.toString(inputStream2, Charsets.UTF_8);
                LOGGER.debug("Successful read, server response was " + httpURLConnection.getResponseCode());
                LOGGER.debug("Response: " + string);
                String string3 = string;
                return string3;
            }
            LOGGER.debug("Request failed", (Throwable)iOException);
            throw iOException;
        }
        finally {
            IOUtils.closeQuietly(inputStream2);
        }
    }

    public static URL constantURL(String string) {
        try {
            return new URL(string);
        }
        catch (MalformedURLException malformedURLException) {
            throw new Error("Couldn't create constant for " + string, malformedURLException);
        }
    }

    public static String buildQuery(Map<String, Object> map) {
        if (map == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append('&');
            }
            try {
                stringBuilder.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                LOGGER.error("Unexpected exception building query", (Throwable)unsupportedEncodingException);
            }
            if (entry.getValue() == null) continue;
            stringBuilder.append('=');
            try {
                stringBuilder.append(URLEncoder.encode(entry.getValue().toString(), "UTF-8"));
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                LOGGER.error("Unexpected exception building query", (Throwable)unsupportedEncodingException);
            }
        }
        return stringBuilder.toString();
    }

    public static URL concatenateURL(URL uRL, String string) {
        try {
            if (uRL.getQuery() != null && uRL.getQuery().length() > 0) {
                return new URL(uRL.getProtocol(), uRL.getHost(), uRL.getPort(), uRL.getFile() + "&" + string);
            }
            return new URL(uRL.getProtocol(), uRL.getHost(), uRL.getPort(), uRL.getFile() + "?" + string);
        }
        catch (MalformedURLException malformedURLException) {
            throw new IllegalArgumentException("Could not concatenate given URL with GET arguments!", malformedURLException);
        }
    }
}

