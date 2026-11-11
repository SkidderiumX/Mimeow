package okio;

import org.jetbrains.annotations.*;
import kotlin.jvm.internal.*;
import kotlin.*;

@kotlin.Deprecated(message = "changed in Okio 2.x")
@Metadata(mv = { 1, 9, 0 }, k = 1, xi = 48, d1 = { "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0007¨\u0006\n" }, d2 = { "Lokio/DDeprecatedUtf8;", "", "()V", "size", "", "string", "", "beginIndex", "", "endIndex", "okio" })
public class DDeprecatedUtf8
{
    @NotNull
    public static final DDeprecatedUtf8 INSTANCE;
    
    private DDeprecatedUtf8() {
    }
    
    @kotlin.Deprecated(message = "moved to extension function", replaceWith = @ReplaceWith(expression = "string.utf8Size()", imports = { "okio.utf8Size" }), level = DeprecationLevel.ERROR)
    @java.lang.Deprecated
    public final long size(@NotNull final String s) {
        Intrinsics.checkNotNullParameter(s, "string");
        return Utf8.size$default(s, 0, 0, 3, null);
    }
    
    @kotlin.Deprecated(message = "moved to extension function", replaceWith = @ReplaceWith(expression = "string.utf8Size(beginIndex, endIndex)", imports = { "okio.utf8Size" }), level = DeprecationLevel.ERROR)
    @java.lang.Deprecated
    public final long size(@NotNull final String s, final int n, final int n2) {
        Intrinsics.checkNotNullParameter(s, "string");
        return Utf8.size(s, n, n2);
    }
    
    static {
        INSTANCE = new DDeprecatedUtf8();
    }
}
