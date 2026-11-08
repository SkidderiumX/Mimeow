package kotlin.internal;

import kotlin.*;
import kotlin.jvm.internal.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.regex.*;
import kotlin.text.*;
import org.jetbrains.annotations.*;
import kotlin.random.*;
import kotlin.jvm.*;
import kotlin.collections.*;

@Metadata(mv = { 1, 9, 0 }, k = 1, xi = 48, d1 = { "\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00112\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\u0013" }, d2 = { "Lkotlin/internal/PlatformImplementations;", "", "()V", "addSuppressed", "", "cause", "", "exception", "defaultPlatformRandom", "Lkotlin/random/kotlin.random.Random;", "getMatchResultNamedGroup", "Lkotlin/text/MatchGroup;", "matchResult", "Ljava/util/regex/MatchResult;", "name", "", "getSuppressed", "", "ReflectThrowable", "kotlin-stdlib" })
@SourceDebugExtension({ "SMAP\nPlatformImplementations.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlatformImplementations.kt\nkotlin/internal/PlatformImplementations\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,79:1\n1#2:80\n*E\n" })
public class PlatformImplementations
{
    public void addSuppressed(@NotNull final Throwable obj, @NotNull final Throwable t) {
        Intrinsics.checkNotNullParameter(obj, "cause");
        Intrinsics.checkNotNullParameter(t, "exception");
        final Method addSuppressed = ReflectThrowable.addSuppressed;
        if (addSuppressed != null) {
            addSuppressed.invoke(obj, t);
        }
    }
    
    @NotNull
    public List<Throwable> getSuppressed(@NotNull final Throwable obj) {
        Intrinsics.checkNotNullParameter(obj, "exception");
        final Method getSuppressed = ReflectThrowable.getSuppressed;
        if (getSuppressed != null) {
            final Object invoke = getSuppressed.invoke(obj, new Object[0]);
            final List<Object> list;
            if (invoke != null && (list = (List<Object>)ArraysKt___ArraysJvmKt.asList((Throwable[])invoke)) != null) {
                return (List<Throwable>)list;
            }
        }
        List<Object> list = CollectionsKt__CollectionsKt.emptyList();
        return (List<Throwable>)list;
    }
    
    @Nullable
    public MatchGroup getMatchResultNamedGroup(@NotNull final MatchResult matchResult, @NotNull final String s) {
        Intrinsics.checkNotNullParameter(matchResult, "matchResult");
        Intrinsics.checkNotNullParameter(s, "name");
        throw new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
    }
    
    @NotNull
    public kotlin.random.Random defaultPlatformRandom() {
        return new FallbackThreadLocalRandom();
    }
    
    @Metadata(mv = { 1, 9, 0 }, k = 1, xi = 48, d1 = { "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c2\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006" }, d2 = { "Lkotlin/internal/PlatformImplementations$ReflectThrowable;", "", "()V", "addSuppressed", "Ljava/lang/reflect/Method;", "getSuppressed", "kotlin-stdlib" })
    @SourceDebugExtension({ "SMAP\nPlatformImplementations.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlatformImplementations.kt\nkotlin/internal/PlatformImplementations$ReflectThrowable\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,79:1\n1#2:80\n*E\n" })
    private static final class ReflectThrowable
    {
        @NotNull
        public static final ReflectThrowable INSTANCE;
        @JvmField
        @Nullable
        public static final Method addSuppressed;
        @JvmField
        @Nullable
        public static final Method getSuppressed;
        
        static {
            INSTANCE = new ReflectThrowable();
            final Method[] methods = Throwable.class.getMethods();
            Method method2 = null;
            Method method3 = null;
            final int n = methods.length;
            for (int i = 0; i < n; ++i) {
                final Method method = methods[i];
                if (Intrinsics.areEqual(method.getName(), "addSuppressed")) {
                    final Class<?>[] parameterTypes = method.getParameterTypes();
                    Intrinsics.checkNotNullExpressionValue(parameterTypes, "it.parameterTypes");
                    if (parameterTypes.length == 1 && parameterTypes[0] == Throwable.class) {
                        method2 = method;
                    }
                }
                if (Intrinsics.areEqual(method.getName(), "getSuppressed")) {
                    method3 = method;
                }
            }
            addSuppressed = method2;
            getSuppressed = method3;
        }
    }
}
