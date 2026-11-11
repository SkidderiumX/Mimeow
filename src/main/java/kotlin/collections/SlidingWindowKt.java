package kotlin.collections;

import org.jetbrains.annotations.*;
import kotlin.jvm.internal.*;
import java.util.*;
import kotlin.jvm.functions.*;
import kotlin.coroutines.*;
import kotlin.*;
import kotlin.sequences.*;

@Metadata(mv = { 1, 9, 0 }, k = 2, xi = 48, d1 = { "\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0000\u001aH\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00070\u0006\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\u00062\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0000\u001aD\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00070\u000e\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\u000e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0000¨\u0006\u000f" }, d2 = { "checkWindowSizeStep", "", "size", "", "step", "windowedIterator", "", "", "T", "iterator", "partialWindows", "", "reuseBuffer", "windowedSequence", "Lkotlin/sequences/Sequence;", "kotlin-stdlib" })
public class SlidingWindowKt
{
    public static final void checkWindowSizeStep(final int n, final int i) {
        if (n <= 0 || i <= 0) {
            throw new IllegalArgumentException(((n != i) ? ("Both size " + n + " and step " + i + " must be greater than zero.") : ("size " + n + " must be greater than zero.")).toString());
        }
    }
    
    @NotNull
    public static final <T> Sequence<List<T>> windowedSequence(@NotNull final Sequence<? extends T> sequence, final int n, final int n2, final boolean b, final boolean b2) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        checkWindowSizeStep(n, n2);
        return (Sequence<List<T>>)new Sequence<List<? extends T>>(sequence, n, n2, b, b2) {
            @NotNull
            @Override
            public Iterator<List<? extends T>> iterator() {
                return SlidingWindowKt.windowedIterator(this.$this_windowedSequence$inlined.iterator(), this.$size$inlined, this.$step$inlined, this.$partialWindows$inlined, this.$reuseBuffer$inlined);
            }
        };
    }
    
    @NotNull
    public static final <T> Iterator<List<T>> windowedIterator(@NotNull final Iterator<?> iterator, final int n, final int n2, final boolean b, final boolean b2) {
        Intrinsics.checkNotNullParameter(iterator, "iterator");
        if (!iterator.hasNext()) {
            return EmptyIterator.INSTANCE;
        }
        return SequencesKt__SequenceBuilderKt.iterator((Function2<? super SequenceScope<? super List<T>>, ? super Continuation<? super Unit>, ?>)new SlidingWindowKt$windowedIterator.SlidingWindowKt$windowedIterator$1(n, n2, (Iterator)iterator, b2, b, (Continuation)null));
    }
}
