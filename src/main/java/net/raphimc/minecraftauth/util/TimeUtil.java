/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.util;

import java.time.Duration;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import net.lenni0451.commons.httpclient.HttpClient;
import net.lenni0451.commons.httpclient.HttpResponse;
import net.lenni0451.commons.httpclient.requests.impl.GetRequest;
import net.raphimc.minecraftauth.MinecraftAuth;
import net.raphimc.minecraftauth.msa.data.MsaEnvironment;

public class TimeUtil {
    private static Duration CLIENT_TIME_OFFSET = null;

    public static synchronized Duration getClientTimeOffset() {
        if (CLIENT_TIME_OFFSET == null) {
            HttpClient httpClient = MinecraftAuth.createHttpClient();
            httpClient.getRetryHandler().setMaxConnectRetries(3);
            try {
                HttpResponse httpResponse = httpClient.execute(new GetRequest(MsaEnvironment.LIVE.getBaseUrl()));
                Instant instant = Instant.now();
                Instant instant2 = httpResponse.getFirstHeader("Date").map(string -> DateTimeFormatter.RFC_1123_DATE_TIME.parse((CharSequence)string, Instant::from)).get();
                CLIENT_TIME_OFFSET = Duration.between(instant, instant2);
            }
            catch (Throwable throwable) {
                new RuntimeException("Failed to get client time offset. This may cause issues with authentication if the local clock is wrong", throwable).printStackTrace();
                CLIENT_TIME_OFFSET = Duration.ZERO;
            }
        }
        return CLIENT_TIME_OFFSET;
    }
}

