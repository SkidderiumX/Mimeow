/*
 * Decompiled with CFR 0.152.
 */
package keystrokesmod.script.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import keystrokesmod.script.Manager;
import keystrokesmod.script.model.Response;
import x.oc7ab2161b9f;

public class Request {
    public String method;
    public String url;
    public List<String[]> headers = new ArrayList<String[]>();
    public String userAgent;
    public int connectionTimeout;
    public int readTimeout;
    public String content = "";

    public Request(String string, String string2) {
        this.method = string.equals("POST") || string.equals("GET") ? string : "GET";
        this.url = string2;
        this.userAgent = "";
        this.readTimeout = 0x2E0ACD2E ^ 0x2E0ADEA6;
        this.connectionTimeout = 0x2E0ACD2E ^ 0x2E0ADEA6;
    }

    public void addHeader(String string, String string2) {
        String[] stringArray = new String[0xAD0580F3 ^ 0xAD0580F1];
        stringArray[0] = string;
        stringArray[1] = string2;
        this.headers.add(stringArray);
    }

    public void setUserAgent(String string) {
        this.userAgent = string;
    }

    public void setConnectTimeout(int n) {
        this.connectionTimeout = n;
    }

    public void setReadTimeout(int n) {
        this.readTimeout = n;
    }

    public void setContent(String string) {
        this.content = string;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Response fetch() {
        if (!Manager.enableHttpRequests.\u01ed()) {
            oc7ab2161b9f.\u00fd("&cFailed to send http request, http requests are not enabled.");
            return new Response(0x162C701D ^ 0x162C7189, "");
        }
        if (this.url.isEmpty()) {
            return null;
        }
        HttpURLConnection httpURLConnection = null;
        try {
            Object object;
            Object object2;
            block32: {
                Map.Entry<String, List<String>> entry;
                URL uRL = new URL(this.url);
                httpURLConnection = (HttpURLConnection)uRL.openConnection();
                httpURLConnection.setRequestMethod(this.method);
                httpURLConnection.setConnectTimeout(this.connectionTimeout);
                httpURLConnection.setReadTimeout(this.readTimeout);
                httpURLConnection.setRequestProperty("User-Agent", this.userAgent.isEmpty() ? "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36" : this.userAgent);
                for (String[] object32 : this.headers) {
                    httpURLConnection.setRequestProperty(object32[0], object32[1]);
                }
                if (this.method.equals("POST") && !this.content.isEmpty()) {
                    httpURLConnection.setDoOutput(true);
                    object2 = this.content.getBytes(StandardCharsets.UTF_8);
                    httpURLConnection.setFixedLengthStreamingMode(((Object)object2).length);
                    httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
                    httpURLConnection.connect();
                    try (OutputStream iOException = httpURLConnection.getOutputStream();){
                        iOException.write((byte[])object2);
                    }
                }
                object2 = "";
                try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));){
                    object = new StringBuilder();
                    while ((entry = bufferedReader.readLine()) != null) {
                        ((StringBuilder)object).append((String)((Object)entry));
                    }
                    object2 = ((StringBuilder)object).toString();
                }
                catch (IOException iOException) {
                    object = httpURLConnection.getErrorStream();
                    if (object == null) break block32;
                    entry = new BufferedReader(new InputStreamReader((InputStream)object));
                    try {
                        String string;
                        StringBuilder stringBuilder = new StringBuilder();
                        while ((string = ((BufferedReader)((Object)entry)).readLine()) != null) {
                            stringBuilder.append(string);
                        }
                        object2 = stringBuilder.toString();
                    }
                    finally {
                        ((BufferedReader)((Object)entry)).close();
                    }
                }
            }
            ArrayList<String[]> arrayList = new ArrayList<String[]>();
            for (Map.Entry<String, List<String>> entry : httpURLConnection.getHeaderFields().entrySet()) {
                if (entry.getKey() == null) continue;
                for (String string : entry.getValue()) {
                    String[] stringArray = new String[0x162C718B ^ 0x162C7189];
                    stringArray[0] = entry.getKey();
                    stringArray[1] = string;
                    arrayList.add(stringArray);
                }
            }
            object = new Response(httpURLConnection.getResponseCode(), (String)object2, arrayList);
            return object;
        }
        catch (IOException iOException) {
        }
        finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
        return null;
    }

    public String toString() {
        return "Request(" + this.method + "," + this.url + ")";
    }
}

