/*
 * Decompiled with CFR 0.152.
 */
package okio;

import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import okio.InflaterSource;
import okio.Source;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 9, 0}, k=2, xi=48, d1={"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0086\b\u00a8\u0006\u0005"}, d2={"inflate", "Lokio/InflaterSource;", "Lokio/Source;", "inflater", "Ljava/util/zip/Inflater;", "okio"})
@JvmName(name="DInflaterSourceExtensions")
public class DInflaterSourceExtensions {
    @NotNull
    public static final InflaterSource inflate(@NotNull Source source2, @NotNull Inflater inflater) {
        Intrinsics.checkNotNullParameter(source2, "<this>");
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        boolean bl = false;
        return new InflaterSource(source2, inflater);
    }

    public static /* synthetic */ InflaterSource inflate$default(Source source2, Inflater inflater, int n, Object object) {
        if ((n & 1) != 0) {
            inflater = new Inflater();
        }
        Intrinsics.checkNotNullParameter(source2, "<this>");
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        n = 0;
        return new InflaterSource(source2, inflater);
    }
}

