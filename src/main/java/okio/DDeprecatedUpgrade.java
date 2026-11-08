package okio;

import kotlin.*;
import kotlin.jvm.*;
import org.jetbrains.annotations.*;

@Metadata(mv = { 1, 9, 0 }, k = 2, xi = 48, d1 = { "\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b" }, d2 = { "Okio", "Lokio/DDeprecatedOkio;", "getOkio", "()Lokio/DDeprecatedOkio;", "Utf8", "Lokio/DDeprecatedUtf8;", "getUtf8", "()Lokio/DDeprecatedUtf8;", "okio" })
@JvmName(name = "DDeprecatedUpgrade")
public class DDeprecatedUpgrade
{
    @NotNull
    private static final DDeprecatedOkio Okio;
    @NotNull
    private static final DDeprecatedUtf8 Utf8;
    
    @NotNull
    public static final DDeprecatedOkio getOkio() {
        return DDeprecatedUpgrade.Okio;
    }
    
    @NotNull
    public static final DDeprecatedUtf8 getUtf8() {
        return DDeprecatedUpgrade.Utf8;
    }
    
    static {
        Okio = DDeprecatedOkio.INSTANCE;
        Utf8 = DDeprecatedUtf8.INSTANCE;
    }
}
