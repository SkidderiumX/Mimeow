/*
 * Decompiled with CFR 0.152.
 */
package kotlin.io.path;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.io.path.ExperimentalPathApi;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 9, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2={"Lkotlin/io/path/OnErrorResult;", "", "(Ljava/lang/String;I)V", "SKIP_SUBTREE", "TERMINATE", "kotlin-stdlib-jdk7"})
@ExperimentalPathApi
@SinceKotlin(version="1.8")
public enum OnErrorResult {
    SKIP_SUBTREE, TERMINATE;
    private static final OnErrorResult[] $VALUES_REF;

    
    private static final /* synthetic */ EnumEntries $ENTRIES;



    @NotNull
    public static EnumEntries<OnErrorResult> getEntries() {
        return $ENTRIES;
    }

    static {
        $VALUES_REF = new OnErrorResult[]{OnErrorResult.SKIP_SUBTREE, OnErrorResult.TERMINATE};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES_REF);
    }
}

