package kotlin.collections;

import kotlin.jvm.internal.*;
import kotlin.internal.*;
import org.jetbrains.annotations.*;
import kotlin.ranges.*;
import kotlin.jvm.functions.*;
import kotlin.random.*;
import kotlin.comparisons.*;
import java.util.*;
import kotlin.*;

@Metadata(mv = { 1, 9, 0 }, k = 5, xi = 49, d1 = { "\u0000\u0088\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aC\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00070\b\"\u0004\b\u0000\u0010\u00072\u0006\u0010\f\u001a\u00020\u00062!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u0002H\u00070\u000eH\u0087\b\u00f8\u0001\u0000\u001aC\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0013\"\u0004\b\u0000\u0010\u00072\u0006\u0010\f\u001a\u00020\u00062!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u0002H\u00070\u000eH\u0087\b\u00f8\u0001\u0000\u001a\u001f\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u0002H\u00070\u0015j\b\u0012\u0004\u0012\u0002H\u0007`\u0016\"\u0004\b\u0000\u0010\u0007H\u0087\b\u001a5\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u0002H\u00070\u0015j\b\u0012\u0004\u0012\u0002H\u0007`\u0016\"\u0004\b\u0000\u0010\u00072\u0012\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00070\u0018\"\u0002H\u0007¢\u0006\u0002\u0010\u0019\u001aN\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u001b0\b\"\u0004\b\u0000\u0010\u001b2\u0006\u0010\u001c\u001a\u00020\u00062\u001f\b\u0001\u0010\u001d\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001b0\u0013\u0012\u0004\u0012\u00020\u001e0\u000e¢\u0006\u0002\b\u001fH\u0087\b\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001aF\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u001b0\b\"\u0004\b\u0000\u0010\u001b2\u001f\b\u0001\u0010\u001d\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001b0\u0013\u0012\u0004\u0012\u00020\u001e0\u000e¢\u0006\u0002\b\u001fH\u0087\b\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a\u0012\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u00070\b\"\u0004\b\u0000\u0010\u0007\u001a\u0015\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u00070\b\"\u0004\b\u0000\u0010\u0007H\u0087\b\u001a+\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u00070\b\"\u0004\b\u0000\u0010\u00072\u0012\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00070\u0018\"\u0002H\u0007¢\u0006\u0002\u0010\"\u001a%\u0010#\u001a\b\u0012\u0004\u0012\u0002H\u00070\b\"\b\b\u0000\u0010\u0007*\u00020$2\b\u0010%\u001a\u0004\u0018\u0001H\u0007¢\u0006\u0002\u0010&\u001a3\u0010#\u001a\b\u0012\u0004\u0012\u0002H\u00070\b\"\b\b\u0000\u0010\u0007*\u00020$2\u0016\u0010\u0017\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u0001H\u00070\u0018\"\u0004\u0018\u0001H\u0007¢\u0006\u0002\u0010\"\u001a\u0015\u0010'\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0013\"\u0004\b\u0000\u0010\u0007H\u0087\b\u001a+\u0010'\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0013\"\u0004\b\u0000\u0010\u00072\u0012\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00070\u0018\"\u0002H\u0007¢\u0006\u0002\u0010\"\u001a%\u0010(\u001a\u00020\u001e2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u0006H\u0002¢\u0006\u0002\b+\u001a\b\u0010,\u001a\u00020\u001eH\u0001\u001a\b\u0010-\u001a\u00020\u001eH\u0001\u001a%\u0010.\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0002\"\u0004\b\u0000\u0010\u0007*\n\u0012\u0006\b\u0001\u0012\u0002H\u00070\u0018H\u0000¢\u0006\u0002\u0010/\u001aS\u00100\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\b2\u0006\u0010%\u001a\u0002H\u00072\u001a\u00101\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u000702j\n\u0012\u0006\b\u0000\u0012\u0002H\u0007`32\b\b\u0002\u0010)\u001a\u00020\u00062\b\b\u0002\u0010*\u001a\u00020\u0006¢\u0006\u0002\u00104\u001a>\u00100\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\b2\b\b\u0002\u0010)\u001a\u00020\u00062\b\b\u0002\u0010*\u001a\u00020\u00062\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u00020\u00060\u000e\u001aE\u00100\u001a\u00020\u0006\"\u000e\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u000706*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00070\b2\b\u0010%\u001a\u0004\u0018\u0001H\u00072\b\b\u0002\u0010)\u001a\u00020\u00062\b\b\u0002\u0010*\u001a\u00020\u0006¢\u0006\u0002\u00107\u001ag\u00108\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007\"\u000e\b\u0001\u00109*\b\u0012\u0004\u0012\u0002H906*\b\u0012\u0004\u0012\u0002H\u00070\b2\b\u0010:\u001a\u0004\u0018\u0001H92\b\b\u0002\u0010)\u001a\u00020\u00062\b\b\u0002\u0010*\u001a\u00020\u00062\u0016\b\u0004\u0010;\u001a\u0010\u0012\u0004\u0012\u0002H\u0007\u0012\u0006\u0012\u0004\u0018\u0001H90\u000eH\u0086\b\u00f8\u0001\u0000¢\u0006\u0002\u0010<\u001a,\u0010=\u001a\u00020>\"\t\b\u0000\u0010\u0007¢\u0006\u0002\b?*\b\u0012\u0004\u0012\u0002H\u00070\u00022\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0002H\u0087\b\u001a;\u0010@\u001a\u0002HA\"\u0010\b\u0000\u0010B*\u0006\u0012\u0002\b\u00030\u0002*\u0002HA\"\u0004\b\u0001\u0010A*\u0002HB2\f\u0010C\u001a\b\u0012\u0004\u0012\u0002HA0DH\u0087\b\u00f8\u0001\u0000¢\u0006\u0002\u0010E\u001a\u0019\u0010F\u001a\u00020>\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u0002H\u0087\b\u001a,\u0010G\u001a\u00020>\"\u0004\b\u0000\u0010\u0007*\n\u0012\u0004\u0012\u0002H\u0007\u0018\u00010\u0002H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a\u001e\u0010H\u001a\b\u0012\u0004\u0012\u0002H\u00070\b\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\bH\u0000\u001a!\u0010I\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0002\"\u0004\b\u0000\u0010\u0007*\n\u0012\u0004\u0012\u0002H\u0007\u0018\u00010\u0002H\u0087\b\u001a!\u0010I\u001a\b\u0012\u0004\u0012\u0002H\u00070\b\"\u0004\b\u0000\u0010\u0007*\n\u0012\u0004\u0012\u0002H\u0007\u0018\u00010\bH\u0087\b\u001a&\u0010J\u001a\b\u0012\u0004\u0012\u0002H\u00070\b\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070K2\u0006\u0010L\u001a\u00020MH\u0007\"\u0019\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"!\u0010\u0005\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006N" }, d2 = { "indices", "Lkotlin/ranges/IntRange;", "", "getIndices", "(Ljava/util/Collection;)Lkotlin/ranges/IntRange;", "lastIndex", "", "T", "", "getLastIndex", "(Ljava/util/List;)I", "List", "size", "init", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "index", "MutableList", "", "arrayListOf", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "elements", "", "([Ljava/lang/Object;)Ljava/util/ArrayList;", "buildList", "E", "capacity", "builderAction", "", "Lkotlin/ExtensionFunctionType;", "emptyList", "listOf", "([Ljava/lang/Object;)Ljava/util/List;", "listOfNotNull", "", "element", "(Ljava/lang/Object;)Ljava/util/List;", "mutableListOf", "rangeCheck", "fromIndex", "toIndex", "rangeCheck$CollectionsKt__CollectionsKt", "throwCountOverflow", "throwIndexOverflow", "asCollection", "([Ljava/lang/Object;)Ljava/util/Collection;", "binarySearch", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Ljava/util/List;Ljava/lang/Object;Ljava/util/Comparator;II)I", "comparison", "", "(Ljava/util/List;Ljava/lang/Comparable;II)I", "binarySearchBy", "K", "key", "selector", "(Ljava/util/List;Ljava/lang/Comparable;IILkotlin/jvm/functions/Function1;)I", "containsAll", "", "Lkotlin/internal/OnlyInputTypes;", "ifEmpty", "R", "C", "defaultValue", "Lkotlin/Function0;", "(Ljava/util/Collection;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isNotEmpty", "isNullOrEmpty", "optimizeReadOnlyList", "orEmpty", "shuffled", "", "random", "Lkotlin/random/kotlin.random.Random;", "kotlin-stdlib" }, xs = "kotlin/collections/CollectionsKt")
@SourceDebugExtension({ "SMAP\nCollections.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Collections.kt\nkotlin/collections/CollectionsKt__CollectionsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,481:1\n404#1:483\n1#2:482\n*S KotlinDebug\n*F\n+ 1 Collections.kt\nkotlin/collections/CollectionsKt__CollectionsKt\n*L\n398#1:483\n*E\n" })
public class CollectionsKt__CollectionsKt extends CollectionsKt__CollectionsJVMKt
{
    @NotNull
    public static final <T> Collection<T> asCollection(@NotNull final T[] array) {
        Intrinsics.checkNotNullParameter(array, "<this>");
        return new ArrayAsCollection<T>(array, false);
    }
    
    @NotNull
    public static final <T> List<T> emptyList() {
        return EmptyList.INSTANCE;
    }
    
    @NotNull
    public static final <T> List<T> listOf(@NotNull final T... array) {
        Intrinsics.checkNotNullParameter(array, "elements");
        return (array.length > 0) ? ArraysKt___ArraysJvmKt.asList(array) : emptyList();
    }
    
    @InlineOnly
    private static final <T> List<T> listOf() {
        return (List<T>)emptyList();
    }
    
    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <T> List<T> mutableListOf() {
        return new ArrayList<T>();
    }
    
    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <T> ArrayList<T> arrayListOf() {
        return new ArrayList<T>();
    }
    
    @NotNull
    public static final <T> List<T> mutableListOf(@NotNull final T... array) {
        Intrinsics.checkNotNullParameter(array, "elements");
        return (array.length == 0) ? new ArrayList<T>() : ((List)new ArrayList<T>((Collection<? extends T>)new ArrayAsCollection<T>((T[])array, true)));
    }
    
    @NotNull
    public static final <T> ArrayList<T> arrayListOf(@NotNull final T... array) {
        Intrinsics.checkNotNullParameter(array, "elements");
        return (array.length == 0) ? new ArrayList<T>() : new ArrayList<T>((Collection<? extends T>)new ArrayAsCollection<T>((T[])array, true));
    }
    
    @NotNull
    public static final <T> List<T> listOfNotNull(@Nullable final T t) {
        return (t != null) ? CollectionsKt__CollectionsJVMKt.listOf(t) : emptyList();
    }
    
    @NotNull
    public static final <T> List<T> listOfNotNull(@NotNull final T... array) {
        Intrinsics.checkNotNullParameter(array, "elements");
        return ArraysKt___ArraysKt.filterNotNull(array);
    }
    
    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <T> List<T> List(final int initialCapacity, final Function1<? super Integer, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(function1, "init");
        final ArrayList list = new ArrayList(initialCapacity);
        for (int i = 0; i < initialCapacity; ++i) {
            list.add(function1.invoke(i));
        }
        return list;
    }
    
    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final <T> List<T> MutableList(final int initialCapacity, final Function1<? super Integer, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(function1, "init");
        final ArrayList list = new ArrayList(initialCapacity);
        for (int i = 0; i < initialCapacity; ++i) {
            list.add(function1.invoke(i));
        }
        return list;
    }
    
    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = { ExperimentalStdlibApi.class })
    @InlineOnly
    private static final <E> List<E> buildList(@BuilderInference final Function1<? super List<E>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "builderAction");
        final List<Object> listBuilder = (List<Object>)CollectionsKt__CollectionsJVMKt.createListBuilder();
        function1.invoke(listBuilder);
        return CollectionsKt__CollectionsJVMKt.build((List<E>)listBuilder);
    }
    
    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = { ExperimentalStdlibApi.class })
    @InlineOnly
    private static final <E> List<E> buildList(final int n, @BuilderInference final Function1<? super List<E>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "builderAction");
        final List<Object> listBuilder = (List<Object>)CollectionsKt__CollectionsJVMKt.createListBuilder(n);
        function1.invoke(listBuilder);
        return CollectionsKt__CollectionsJVMKt.build((List<E>)listBuilder);
    }
    
    @NotNull
    public static final IntRange getIndices(@NotNull final Collection<?> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        return new IntRange(0, collection.size() - 1);
    }
    
    public static final <T> int getLastIndex(@NotNull final List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return list.size() - 1;
    }
    
    @InlineOnly
    private static final <T> boolean isNotEmpty(final Collection<? extends T> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        return !collection.isEmpty();
    }
    
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T> boolean isNullOrEmpty(final Collection<? extends T> collection) {
        return collection == null || collection.isEmpty();
    }
    
    @InlineOnly
    private static final <T> Collection<T> orEmpty(final Collection<? extends T> collection) {
        Collection<T> collection2 = (Collection<T>)collection;
        if (collection == null) {
            collection2 = (Collection)emptyList();
        }
        return collection2;
    }
    
    @InlineOnly
    private static final <T> List<T> orEmpty(final List<? extends T> list) {
        List<T> emptyList = (List<T>)list;
        if (list == null) {
            emptyList = emptyList();
        }
        return emptyList;
    }
    
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <C extends Collection<?> & R, R> R ifEmpty(final C c, final Function0<? extends R> function0) {
        Intrinsics.checkNotNullParameter(function0, "defaultValue");
        return c.isEmpty() ? function0.invoke() : c;
    }
    
    @InlineOnly
    private static final <T> boolean containsAll(final Collection<? extends T> collection, final Collection<? extends T> collection2) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(collection2, "elements");
        return collection.containsAll(collection2);
    }
    
    @SinceKotlin(version = "1.3")
    @NotNull
    public static final <T> List<T> shuffled(@NotNull final Iterable<? extends T> iterable, @NotNull final kotlin.random.Random random) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        final List<Object> mutableList = (List<Object>)CollectionsKt___CollectionsKt.toMutableList(iterable);
        CollectionsKt___CollectionsKt.shuffle((List<T>)mutableList, random);
        return (List<T>)mutableList;
    }
    
    @NotNull
    public static final <T> List<T> optimizeReadOnlyList(@NotNull final List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return switch (list.size()) {
            case 0 -> emptyList();
            case 1 -> CollectionsKt__CollectionsJVMKt.listOf(list.get(0));
            default -> list;
        };
    }
    
    public static final <T extends Comparable<? super T>> int binarySearch(@NotNull final List<? extends T> list, @Nullable final T t, final int n, final int n2) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        rangeCheck$CollectionsKt__CollectionsKt(list.size(), n, n2);
        int i = n;
        int n3 = n2 - 1;
        while (i <= n3) {
            final int n4 = i + n3 >>> 1;
            final int compareValues = ComparisonsKt__ComparisonsKt.compareValues(list.get(n4), t);
            if (compareValues < 0) {
                i = n4 + 1;
            }
            else {
                if (compareValues <= 0) {
                    return n4;
                }
                n3 = n4 - 1;
            }
        }
        return -(i + 1);
    }
    
    public static final <T> int binarySearch(@NotNull final List<? extends T> list, final T t, @NotNull final Comparator<? super T> comparator, final int n, final int n2) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        rangeCheck$CollectionsKt__CollectionsKt(list.size(), n, n2);
        int i = n;
        int n3 = n2 - 1;
        while (i <= n3) {
            final int n4 = i + n3 >>> 1;
            final int compare = comparator.compare(list.get(n4), t);
            if (compare < 0) {
                i = n4 + 1;
            }
            else {
                if (compare <= 0) {
                    return n4;
                }
                n3 = n4 - 1;
            }
        }
        return -(i + 1);
    }
    
    public static final <T, K extends Comparable<? super K>> int binarySearchBy(@NotNull final List<? extends T> list, @Nullable final K k, final int n, final int n2, @NotNull final Function1<? super T, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        return binarySearch((List<?>)list, n, n2, (Function1<? super Object, Integer>)new CollectionsKt__CollectionsKt$binarySearchBy.CollectionsKt__CollectionsKt$binarySearchBy$1((Function1)function1, (Comparable)k));
    }
    
    public static final <T> int binarySearch(@NotNull final List<? extends T> list, final int n, final int n2, @NotNull final Function1<? super T, Integer> function1) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(function1, "comparison");
        rangeCheck$CollectionsKt__CollectionsKt(list.size(), n, n2);
        int i = n;
        int n3 = n2 - 1;
        while (i <= n3) {
            final int n4 = i + n3 >>> 1;
            final int intValue = function1.invoke(list.get(n4)).intValue();
            if (intValue < 0) {
                i = n4 + 1;
            }
            else {
                if (intValue <= 0) {
                    return n4;
                }
                n3 = n4 - 1;
            }
        }
        return -(i + 1);
    }
    
    private static final void rangeCheck$CollectionsKt__CollectionsKt(final int i, final int n, final int n2) {
        if (n > n2) {
            throw new IllegalArgumentException("fromIndex (" + n + ") is greater than toIndex (" + n2 + ").");
        }
        if (n < 0) {
            throw new IndexOutOfBoundsException("fromIndex (" + n + ") is less than zero.");
        }
        if (n2 > i) {
            throw new IndexOutOfBoundsException("toIndex (" + n2 + ") is greater than size (" + i + ").");
        }
    }
    
    @PublishedApi
    @SinceKotlin(version = "1.3")
    public static final void throwIndexOverflow() {
        throw new ArithmeticException("Index overflow has happened.");
    }
    
    @PublishedApi
    @SinceKotlin(version = "1.3")
    public static final void throwCountOverflow() {
        throw new ArithmeticException("Count overflow has happened.");
    }
}
