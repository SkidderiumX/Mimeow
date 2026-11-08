/*
 * Decompiled with CFR 0.152.
 */
package net.lenni0451.commons.httpclient.retry.handlers;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;
import javax.annotation.Nullable;
import net.lenni0451.commons.httpclient.HttpResponse;
import net.lenni0451.commons.httpclient.retry.RetryAction;
import net.lenni0451.commons.httpclient.retry.RetryHandler;

public class RetryAfterRetryHandler
implements RetryHandler {
    @Override
    public RetryAction shouldRetry(HttpResponse httpResponse) {
        Long l;
        Optional<String> optional = httpResponse.getFirstHeader("Retry-After");
        if (optional.isPresent() && (l = this.parseSecondsOrHttpDate(optional.get())) != null && l > 0L) {
            return RetryAction.waitFor(l);
        }
        return RetryAction.NO_RETRY;
    }

    @Nullable
    private Long parseSecondsOrHttpDate(String string) {
        try {
            Instant instant = Instant.from(DateTimeFormatter.RFC_1123_DATE_TIME.parse(string));
            return instant.toEpochMilli() - Instant.now().toEpochMilli();
        }
        catch (DateTimeParseException dateTimeParseException) {
            try {
                int n = Integer.parseInt(string);
                return (long)n * 1000L;
            }
            catch (NumberFormatException numberFormatException) {
                return null;
            }
        }
    }
}

