/*
 * Decompiled with CFR 0.152.
 */
package kotlin.annotation;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 9, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2={"Lkotlin/annotation/AnnotationRetention;", "", "(Ljava/lang/String;I)V", "SOURCE", "BINARY", "RUNTIME", "kotlin-stdlib"})
public enum AnnotationRetention {
    SOURCE, BINARY, RUNTIME;
    private static final AnnotationRetention[] $VALUES_REF;


    
    private static final /* synthetic */ EnumEntries $ENTRIES;



    @NotNull
    public static EnumEntries<AnnotationRetention> getEntries() {
        return $ENTRIES;
    }

    static {
        $VALUES_REF = new AnnotationRetention[]{AnnotationRetention.SOURCE, AnnotationRetention.BINARY, AnnotationRetention.RUNTIME};
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES_REF);
    }
}

