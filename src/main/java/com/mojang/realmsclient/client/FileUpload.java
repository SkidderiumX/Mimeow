/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.realmsclient.client;

import com.google.gson.JsonParser;
import com.mojang.realmsclient.RealmsVersion;
import com.mojang.realmsclient.client.UploadStatus;
import com.mojang.realmsclient.dto.UploadInfo;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.TimeUnit;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.Args;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FileUpload {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String UPLOAD_PATH = "/upload";
    private volatile boolean cancelled = false;
    private volatile boolean finished = false;
    private HttpPost request;
    private int statusCode = -1;
    private String errorMessage;
    private RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout((int)TimeUnit.MINUTES.toMillis(10L)).setConnectTimeout((int)TimeUnit.SECONDS.toMillis(15L)).build();
    private Thread currentThread;

    public void upload(final File file, final long l, final int n, final UploadInfo uploadInfo, final String string, final String string2, final String string3, final UploadStatus uploadStatus) {
        if (this.currentThread != null) {
            return;
        }
        this.currentThread = new Thread(){

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            @Override
            public void run() {
                FileUpload.this.request = new HttpPost("http://" + uploadInfo.getUploadEndpoint() + ":" + String.valueOf(uploadInfo.getPort()) + FileUpload.UPLOAD_PATH + "/" + String.valueOf(l) + "/" + String.valueOf(n));
                CloseableHttpClient closeableHttpClient = null;
                try {
                    String string4;
                    closeableHttpClient = HttpClientBuilder.create().setDefaultRequestConfig(FileUpload.this.requestConfig).build();
                    String string22 = RealmsVersion.getVersion();
                    if (string22 != null) {
                        FileUpload.this.request.setHeader("Cookie", "sid=" + string + ";token=" + uploadInfo.getToken() + ";user=" + string2 + ";version=" + string3 + ";realms_version=" + string22);
                    } else {
                        FileUpload.this.request.setHeader("Cookie", "sid=" + string + ";token=" + uploadInfo.getToken() + ";user=" + string2 + ";version=" + string3);
                    }
                    uploadStatus.totalBytes = file.length();
                    CustomInputStreamEntity customInputStreamEntity = new CustomInputStreamEntity((InputStream)new FileInputStream(file), file.length(), uploadStatus);
                    customInputStreamEntity.setContentType("application/octet-stream");
                    FileUpload.this.request.setEntity(customInputStreamEntity);
                    CloseableHttpResponse closeableHttpResponse = closeableHttpClient.execute(FileUpload.this.request);
                    int n2 = closeableHttpResponse.getStatusLine().getStatusCode();
                    if (n2 == 401) {
                        LOGGER.debug("Realms server returned 401: " + closeableHttpResponse.getFirstHeader("WWW-Authenticate"));
                    }
                    FileUpload.this.statusCode = n2;
                    if (closeableHttpResponse.getEntity() != null && (string4 = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8")) != null) {
                        try {
                            JsonParser jsonParser = new JsonParser();
                            FileUpload.this.errorMessage = jsonParser.parse(string4).getAsJsonObject().get("errorMsg").getAsString();
                        }
                        catch (Exception exception) {
                            // empty catch block
                        }
                    }
                }
                catch (Exception exception) {
                    if (!FileUpload.this.cancelled) {
                        LOGGER.error("Caught exception while uploading: ", (Throwable)exception);
                    }
                }
                finally {
                    FileUpload.this.request.releaseConnection();
                    FileUpload.this.finished = true;
                    if (closeableHttpClient != null) {
                        try {
                            closeableHttpClient.close();
                        }
                        catch (IOException iOException) {
                            LOGGER.error("Failed to close Realms upload client");
                        }
                    }
                }
            }
        };
        this.currentThread.start();
    }

    public void cancel() {
        this.cancelled = true;
        if (this.request != null) {
            this.request.abort();
        }
    }

    public boolean isFinished() {
        return this.finished;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    private static class CustomInputStreamEntity
    extends InputStreamEntity {
        private final long length;
        private final InputStream content;
        private final UploadStatus uploadStatus;

        public CustomInputStreamEntity(InputStream inputStream2, long l, UploadStatus uploadStatus) {
            super(inputStream2);
            this.content = inputStream2;
            this.length = l;
            this.uploadStatus = uploadStatus;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public void writeTo(OutputStream outputStream2) throws IOException {
            block7: {
                Args.notNull(outputStream2, "Output stream");
                InputStream inputStream2 = this.content;
                try {
                    int n;
                    byte[] byArray = new byte[4096];
                    if (this.length < 0L) {
                        int n2;
                        while ((n2 = inputStream2.read(byArray)) != -1) {
                            outputStream2.write(byArray, 0, n2);
                            UploadStatus uploadStatus = this.uploadStatus;
                            Long.valueOf(uploadStatus.bytesWritten + (long)n2);
                            uploadStatus.bytesWritten = uploadStatus.bytesWritten;
                        }
                        break block7;
                    }
                    for (long i = this.length; i > 0L; i -= (long)n) {
                        n = inputStream2.read(byArray, 0, (int)Math.min(4096L, i));
                        if (n == -1) {
                            break;
                        }
                        outputStream2.write(byArray, 0, n);
                        UploadStatus uploadStatus = this.uploadStatus;
                        Long.valueOf(uploadStatus.bytesWritten + (long)n);
                        uploadStatus.bytesWritten = uploadStatus.bytesWritten;
                        outputStream2.flush();
                    }
                }
                finally {
                    inputStream2.close();
                }
            }
        }
    }
}

