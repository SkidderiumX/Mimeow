package kotlin.sequences;

import kotlin.jvm.internal.*;
import kotlin.collections.*;
import kotlin.coroutines.*;
import kotlin.jvm.functions.*;
import kotlin.jvm.*;
import java.util.*;
import kotlin.*;
import kotlin.random.*;
import org.jetbrains.annotations.*;
import kotlin.internal.*;

@Metadata(mv = { 1, 9, 0 }, k = 5, xi = 49, d1 = { "\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u001c\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\u001a.\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0014\b\u0004\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004H\u0087\b\u00f8\u0001\u0000\u001a\u0012\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002\u001ab\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\b0\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\t\"\u0004\b\u0002\u0010\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\t0\f2\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u0002H\t\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00050\u000eH\u0000\u001a&\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00102\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0004\u001a<\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00102\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u00042\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u000e\u001a=\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u0001H\u00022\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u000eH\u0007¢\u0006\u0002\u0010\u0014\u001a+\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0017\"\u0002H\u0002¢\u0006\u0002\u0010\u0018\u001a\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0005\u001a\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001\u001aC\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\b0\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\b*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00050\u000eH\u0002¢\u0006\u0002\b\u001c\u001a)\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u001d0\u0001H\u0007¢\u0006\u0002\b\u001e\u001a\"\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0001\u001a2\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0004H\u0007\u001a!\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001H\u0087\b\u001a\u001e\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0007\u001a&\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010#\u001a\u00020$H\u0007\u001a@\u0010%\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0'0&\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\b*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\b0&0\u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006(" }, d2 = { "Sequence", "Lkotlin/sequences/Sequence;", "T", "iterator", "Lkotlin/Function0;", "", "emptySequence", "flatMapIndexed", "R", "C", "source", "transform", "Lkotlin/Function2;", "", "Lkotlin/Function1;", "generateSequence", "", "nextFunction", "seedFunction", "seed", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;", "sequenceOf", "elements", "", "([Ljava/lang/Object;)Lkotlin/sequences/Sequence;", "asSequence", "constrainOnce", "flatten", "flatten$SequencesKt__SequencesKt", "", "flattenSequenceOfIterable", "ifEmpty", "defaultValue", "orEmpty", "shuffled", "random", "Lkotlin/random/kotlin.random.Random;", "unzip", "Lkotlin/Pair;", "", "kotlin-stdlib" }, xs = "kotlin/sequences/SequencesKt")
public class SequencesKt__SequencesKt extends SequencesKt__SequencesJVMKt
{
    @InlineOnly
    private static final <T> Sequence<T> Sequence(final Function0<? extends Iterator<? extends T>> function0) {
        Intrinsics.checkNotNullParameter(function0, "iterator");
        return (Sequence<T>)new SequencesKt__SequencesKt$Sequence.SequencesKt__SequencesKt$Sequence$1((Function0)function0);
    }
    
    @NotNull
    public static final <T> Sequence<T> asSequence(@NotNull final Iterator<? extends T> iterator) {
        Intrinsics.checkNotNullParameter(iterator, "<this>");
        return constrainOnce((Sequence<? extends T>)new Sequence<T>(iterator) {
            @NotNull
            @Override
            public Iterator<T> iterator() {
                return this.$this_asSequence$inlined;
            }
        });
    }
    
    @NotNull
    public static final <T> Sequence<T> sequenceOf(@NotNull final T... array) {
        Intrinsics.checkNotNullParameter(array, "elements");
        return (array.length == 0) ? emptySequence() : ArraysKt___ArraysKt.asSequence(array);
    }
    
    @NotNull
    public static final <T> Sequence<T> emptySequence() {
        return EmptySequence.INSTANCE;
    }
    
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T> Sequence<T> orEmpty(final Sequence<? extends T> sequence) {
        Sequence<T> emptySequence = (Sequence<T>)sequence;
        if (sequence == null) {
            emptySequence = emptySequence();
        }
        return emptySequence;
    }
    
    @SinceKotlin(version = "1.3")
    @NotNull
    public static final <T> Sequence<T> ifEmpty(@NotNull final Sequence<? extends T> sequence, @NotNull final Function0<? extends Sequence<? extends T>> function0) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(function0, "defaultValue");
        return SequencesKt__SequenceBuilderKt.sequence((Function2<? super SequenceScope<? super T>, ? super Continuation<? super Unit>, ?>)new SequencesKt__SequencesKt$ifEmpty.SequencesKt__SequencesKt$ifEmpty$1((Sequence)sequence, (Function0)function0, (Continuation)null));
    }
    
    @NotNull
    public static final <T> Sequence<T> flatten(@NotNull final Sequence<? extends Sequence<? extends T>> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return flatten$SequencesKt__SequencesKt((Sequence<?>)sequence, (Function1<? super Object, ? extends Iterator<? extends T>>)SequencesKt__SequencesKt$flatten.SequencesKt__SequencesKt$flatten$1.INSTANCE);
    }
    
    @JvmName(name = "flattenSequenceOfIterable")
    @NotNull
    public static final <T> Sequence<T> flattenSequenceOfIterable(@NotNull final Sequence<? extends Iterable<? extends T>> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return flatten$SequencesKt__SequencesKt((Sequence<?>)sequence, (Function1<? super Object, ? extends Iterator<? extends T>>)SequencesKt__SequencesKt$flatten.SequencesKt__SequencesKt$flatten$2.INSTANCE);
    }
    
    private static final <T, R> Sequence<R> flatten$SequencesKt__SequencesKt(final Sequence<? extends T> sequence, final Function1<? super T, ? extends Iterator<? extends R>> function1) {
        if (sequence instanceof TransformingSequence) {
            return ((TransformingSequence<Object, Object>)sequence).flatten$kotlin_stdlib((Function1<? super Object, ? extends Iterator<? extends R>>)function1);
        }
        return new FlatteningSequence<Object, Object, R>(sequence, (Function1<?, ?>)SequencesKt__SequencesKt$flatten.SequencesKt__SequencesKt$flatten$3.INSTANCE, function1);
    }
    
    @NotNull
    public static final <T, R> Pair<List<T>, List<R>> unzip(@NotNull final Sequence<? extends Pair<? extends T, ? extends R>> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        final ArrayList list = new ArrayList();
        final ArrayList list2 = new ArrayList();
        for (final Pair pair : sequence) {
            list.add(pair.getFirst());
            list2.add(pair.getSecond());
        }
        return (Pair<List<T>, List<R>>)TuplesKt.mcc4e6a6012(list, list2);
    }
    
    @SinceKotlin(version = "1.4")
    @NotNull
    public static final <T> Sequence<T> shuffled(@NotNull final Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return shuffled(sequence, (kotlin.random.Random)kotlin.random.Random.Default);
    }
    
    @SinceKotlin(version = "1.4")
    @NotNull
    public static final <T> Sequence<T> shuffled(@NotNull final Sequence<? extends T> sequence, @NotNull final kotlin.random.Random random) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        return SequencesKt__SequenceBuilderKt.sequence((Function2<? super SequenceScope<? super T>, ? super Continuation<? super Unit>, ?>)new SequencesKt__SequencesKt$shuffled.SequencesKt__SequencesKt$shuffled$1((Sequence)sequence, random, (Continuation)null));
    }
    
    @NotNull
    public static final <T, C, R> Sequence<R> flatMapIndexed(@NotNull final Sequence<? extends T> sequence, @NotNull final Function2<? super Integer, ? super T, ? extends C> function2, @NotNull final Function1<? super C, ? extends Iterator<? extends R>> function3) {
        Intrinsics.checkNotNullParameter(sequence, "source");
        Intrinsics.checkNotNullParameter(function2, "transform");
        Intrinsics.checkNotNullParameter(function3, "iterator");
        return SequencesKt__SequenceBuilderKt.sequence((Function2<? super SequenceScope<? super R>, ? super Continuation<? super Unit>, ?>)new SequencesKt__SequencesKt$flatMapIndexed.SequencesKt__SequencesKt$flatMapIndexed$1((Sequence)sequence, (Function2)function2, (Function1)function3, (Continuation)null));
    }
    
    @NotNull
    public static final <T> Sequence<T> constrainOnce(@NotNull final Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return (Sequence<T>)((sequence instanceof ConstrainedOnceSequence) ? sequence : new ConstrainedOnceSequence<T>(sequence));
    }
    
    @NotNull
    public static final <T> Sequence<T> generateSequence(@NotNull final Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, "nextFunction");
        return constrainOnce((Sequence<? extends T>)new GeneratorSequence<T>(function0, (Function1<? super T, ? extends T>)new SequencesKt__SequencesKt$generateSequence.SequencesKt__SequencesKt$generateSequence$1((Function0)function0)));
    }
    
    @LowPriorityInOverloadResolution
    @NotNull
    public static final <T> Sequence<T> generateSequence(@Nullable final T t, @NotNull final Function1<? super T, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(function1, "nextFunction");
        return (t == null) ? EmptySequence.INSTANCE : ((Sequence)new GeneratorSequence<T>((Function0<? extends T>)new SequencesKt__SequencesKt$generateSequence.SequencesKt__SequencesKt$generateSequence$2((Object)t), function1));
    }
    
    @NotNull
    public static final <T> Sequence<T> generateSequence(@NotNull final Function0<? extends T> function0, @NotNull final Function1<? super T, ? extends T> function2) {
        Intrinsics.checkNotNullParameter(function0, "seedFunction");
        Intrinsics.checkNotNullParameter(function2, "nextFunction");
        return new GeneratorSequence<T>(function0, function2);
    }
}
