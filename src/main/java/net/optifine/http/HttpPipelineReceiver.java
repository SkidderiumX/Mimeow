/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.http;

import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import net.minecraft.src.Config;
import net.optifine.http.HttpPipelineConnection;
import net.optifine.http.HttpPipelineRequest;
import net.optifine.http.HttpResponse;

public class HttpPipelineReceiver
extends Thread {
    private HttpPipelineConnection httpPipelineConnection = null;
    private static final Charset ASCII = Charset.forName("ASCII");
    private static final String HEADER_CONTENT_LENGTH = "Content-Length";
    private static final char CR = '\r';
    private static final char LF = '\n';

    public HttpPipelineReceiver(HttpPipelineConnection httpPipelineConnection) {
        super("HttpPipelineReceiver");
        this.httpPipelineConnection = httpPipelineConnection;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            HttpPipelineRequest httpPipelineRequest = null;
            try {
                httpPipelineRequest = this.httpPipelineConnection.getNextRequestReceive();
                InputStream inputStream2 = this.httpPipelineConnection.getInputStream();
                HttpResponse httpResponse = this.readResponse(inputStream2);
                this.httpPipelineConnection.onResponseReceived(httpPipelineRequest, httpResponse);
            }
            catch (InterruptedException interruptedException) {
                return;
            }
            catch (Exception exception) {
                this.httpPipelineConnection.onExceptionReceive(httpPipelineRequest, exception);
            }
        }
    }

    private HttpResponse readResponse(InputStream inputStream2) throws IOException {
        String string = this.readLine(inputStream2);
        String[] stringArray = Config.tokenize(string, " ");
        if (stringArray.length < 3) {
            throw new IOException("Invalid status line: " + string);
        }
        String string2 = stringArray[0];
        int n = Config.parseInt(stringArray[1], 0);
        String string3 = stringArray[2];
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();
        while (true) {
            String string4;
            String string5;
            String string6;
            if ((string6 = this.readLine(inputStream2)).length() <= 0) {
                byte[] byArray = null;
                string5 = (String)linkedHashMap.get(HEADER_CONTENT_LENGTH);
                if (string5 != null) {
                    int n2 = Config.parseInt(string5, -1);
                    if (n2 > 0) {
                        byArray = new byte[n2];
                        this.readFull(byArray, inputStream2);
                    }
                } else {
                    string4 = (String)linkedHashMap.get("Transfer-Encoding");
                    if (Config.equals(string4, "chunked")) {
                        byArray = this.readContentChunked(inputStream2);
                    }
                }
                return new HttpResponse(n, string, linkedHashMap, byArray);
            }
            int n3 = string6.indexOf(":");
            if (n3 <= 0) continue;
            string5 = string6.substring(0, n3).trim();
            string4 = string6.substring(n3 + 1).trim();
            linkedHashMap.put(string5, string4);
        }
    }

    private byte[] readContentChunked(InputStream inputStream2) throws IOException {
        int n;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        do {
            String string = this.readLine(inputStream2);
            String[] stringArray = Config.tokenize(string, "; ");
            n = Integer.parseInt(stringArray[0], 16);
            byte[] byArray = new byte[n];
            this.readFull(byArray, inputStream2);
            byteArrayOutputStream.write(byArray);
            this.readLine(inputStream2);
        } while (n != 0);
        return byteArrayOutputStream.toByteArray();
    }

    private void readFull(byte[] byArray, InputStream inputStream2) throws IOException {
        int n;
        for (int i = 0; i < byArray.length; i += n) {
            n = inputStream2.read(byArray, i, byArray.length - i);
            if (n >= 0) continue;
            throw new EOFException();
        }
    }

    private String readLine(InputStream inputStream2) throws IOException {
        int n;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int n2 = -1;
        boolean bl = false;
        while ((n = inputStream2.read()) >= 0) {
            byteArrayOutputStream.write(n);
            if (n2 == 13 && n == 10) {
                bl = true;
                break;
            }
            n2 = n;
        }
        byte[] byArray = byteArrayOutputStream.toByteArray();
        String string = new String(byArray, ASCII);
        if (bl) {
            string = string.substring(0, string.length() - 2);
        }
        return string;
    }
}

