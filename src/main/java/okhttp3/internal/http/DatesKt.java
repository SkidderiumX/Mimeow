/*
 * Decompiled with CFR 0.152.
 */
package okhttp3.internal.http;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=2, xi=48, d1={"\u0000+\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\n\u001a\u000e\u0010\f\u001a\u0004\u0018\u00010\r*\u00020\u0005H\u0000\u001a\f\u0010\u000e\u001a\u00020\u0005*\u00020\rH\u0000\"\u0018\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0003\"\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00050\u0001X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0006\"\u000e\u0010\u0007\u001a\u00020\bX\u0080T\u00a2\u0006\u0002\n\u0000\"\u0010\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u000b\u00a8\u0006\u000f"}, d2={"BROWSER_COMPATIBLE_DATE_FORMATS", "", "Ljava/text/DateFormat;", "[Ljava/text/DateFormat;", "BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS", "", "[Ljava/lang/String;", "MAX_DATE", "", "STANDARD_DATE_FORMAT", "okhttp3/internal/http/DatesKt$STANDARD_DATE_FORMAT$1", "Lokhttp3/internal/http/DatesKt$STANDARD_DATE_FORMAT$1;", "toHttpDateOrNull", "Ljava/util/Date;", "toHttpDateString", "okhttp"})
public class DatesKt {
    public static final long MAX_DATE = 253402300799999L;
    @NotNull
    private static final ThreadLocal<DateFormat> STANDARD_DATE_FORMAT = new ThreadLocal<DateFormat>(){

        @NotNull
        protected DateFormat initialValue() {
            SimpleDateFormat simpleDateFormat;
            SimpleDateFormat simpleDateFormat2 = simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            boolean bl = false;
            simpleDateFormat2.setLenient(false);
            simpleDateFormat2.setTimeZone(Util.UTC);
            return simpleDateFormat;
        }
    };
    @NotNull
    private static final String[] BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS;
    @NotNull
    private static final DateFormat[] BROWSER_COMPATIBLE_DATE_FORMATS;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Nullable
    public static final Date toHttpDateOrNull(@NotNull String string) {
        Intrinsics.checkNotNullParameter(string, "<this>");
        if (((CharSequence)string).length() == 0) {
            return null;
        }
        boolean bl = false;
        if (bl) {
            return null;
        }
        ParsePosition parsePosition = new ParsePosition(0);
        Date date = null;
        date = ((DateFormat)STANDARD_DATE_FORMAT.get()).parse(string, parsePosition);
        if (parsePosition.getIndex() == string.length()) {
            return date;
        }
        String[] stringArray = BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS;
        synchronized (stringArray) {
            boolean bl2 = false;
            int n = 0;
            int n2 = BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS.length;
            while (true) {
                if (n >= n2) {
                    Unit unit = Unit.INSTANCE;
                    return null;
                }
                DateFormat dateFormat = BROWSER_COMPATIBLE_DATE_FORMATS[n];
                if (dateFormat == null) {
                    SimpleDateFormat simpleDateFormat;
                    SimpleDateFormat simpleDateFormat2 = simpleDateFormat = new SimpleDateFormat(BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS[n], Locale.US);
                    boolean bl3 = false;
                    simpleDateFormat2.setTimeZone(Util.UTC);
                    DatesKt.BROWSER_COMPATIBLE_DATE_FORMATS[n] = dateFormat = (DateFormat)simpleDateFormat;
                }
                parsePosition.setIndex(0);
                date = dateFormat.parse(string, parsePosition);
                if (parsePosition.getIndex() != 0) {
                    return date;
                }
                ++n;
            }
        }
    }

    @NotNull
    public static final String toHttpDateString(@NotNull Date date) {
        Intrinsics.checkNotNullParameter(date, "<this>");
        String string = ((DateFormat)STANDARD_DATE_FORMAT.get()).format(date);
        Intrinsics.checkNotNullExpressionValue(string, "STANDARD_DATE_FORMAT.get().format(this)");
        return string;
    }

    static {
        String[] stringArray = new String[]{"EEE, dd MMM yyyy HH:mm:ss zzz", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};
        BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS = stringArray;
        BROWSER_COMPATIBLE_DATE_FORMATS = new DateFormat[BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS.length];
    }
}

