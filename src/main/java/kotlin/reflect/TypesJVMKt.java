package kotlin.reflect;

import org.jetbrains.annotations.*;
import kotlin.jvm.internal.*;
import kotlin.internal.*;
import kotlin.jvm.*;
import kotlin.*;
import kotlin.collections.*;
import java.lang.reflect.*;
import java.util.*;
import kotlin.jvm.functions.*;
import kotlin.sequences.*;
import kotlin.text.*;

@Metadata(mv = { 1, 9, 0 }, k = 2, xi = 48, d1 = { "\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u001a\"\u0010\n\u001a\u00020\u00012\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eH\u0003\u001a\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0001H\u0002\u001a\u0016\u0010\u0012\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0003\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00078BX\u0083\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\b\u001a\u0004\b\u0005\u0010\t¨\u0006\u0015" }, d2 = { "javaType", "Ljava/lang/reflect/Type;", "Lkotlin/reflect/KType;", "getJavaType$annotations", "(Lkotlin/reflect/KType;)V", "getJavaType", "(Lkotlin/reflect/KType;)Ljava/lang/reflect/Type;", "Lkotlin/reflect/KTypeProjection;", "(Lkotlin/reflect/KTypeProjection;)V", "(Lkotlin/reflect/KTypeProjection;)Ljava/lang/reflect/Type;", "createPossiblyInnerType", "jClass", "Ljava/lang/Class;", "arguments", "", "typeToString", "", "type", "computeJavaType", "forceWrapper", "", "kotlin-stdlib" })
@SourceDebugExtension({ "SMAP\nTypesJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypesJVM.kt\nkotlin/reflect/TypesJVMKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,230:1\n1#2:231\n1549#3:232\n1620#3,3:233\n1549#3:236\n1620#3,3:237\n1549#3:240\n1620#3,3:241\n*S KotlinDebug\n*F\n+ 1 TypesJVM.kt\nkotlin/reflect/TypesJVMKt\n*L\n69#1:232\n69#1:233,3\n71#1:236\n71#1:237,3\n77#1:240\n77#1:241,3\n*E\n" })
public class TypesJVMKt
{
    @NotNull
    public static final Type getJavaType(@NotNull final KType kType) {
        Intrinsics.checkNotNullParameter(kType, "<this>");
        if (kType instanceof KTypeBase) {
            final Type javaType = ((KTypeBase)kType).getJavaType();
            if (javaType != null) {
                return javaType;
            }
        }
        return computeJavaType$default(kType, false, 1, null);
    }
    
    @ExperimentalStdlibApi
    private static final Type computeJavaType(final KType kType, final boolean b) {
        final KClassifier classifier = kType.getClassifier();
        if (classifier instanceof KTypeParameter) {
            return new TypeVariableImpl((KTypeParameter)classifier);
        }
        if (!(classifier instanceof KClass)) {
            throw new UnsupportedOperationException("Unsupported type classifier: " + kType);
        }
        final Class<Object> clazz = b ? JvmClassMappingKt.getJavaObjectType((KClass<Object>)classifier) : JvmClassMappingKt.getJavaClass((KClass<Object>)classifier);
        final List<KTypeProjection> arguments = kType.getArguments();
        if (arguments.isEmpty()) {
            return clazz;
        }
        if (!clazz.isArray()) {
            return createPossiblyInnerType(clazz, arguments);
        }
        if (clazz.getComponentType().isPrimitive()) {
            return clazz;
        }
        final KTypeProjection kTypeProjection = CollectionsKt___CollectionsKt.singleOrNull((List<? extends KTypeProjection>)arguments);
        if (kTypeProjection == null) {
            throw new IllegalArgumentException("kotlin.Array must have exactly one type argument: " + kType);
        }
        final KTypeProjection kTypeProjection2 = kTypeProjection;
        final KVariance component1 = kTypeProjection2.component1();
        final KType component2 = kTypeProjection2.component2();
        final KVariance kVariance = component1;
        return switch ((kVariance == null) ? -1 : WhenMappings.$EnumSwitchMapping$0[kVariance.ordinal()]) {
            case -1,  1 -> clazz;
            case 2,  3 -> {
                final KType kType2 = component2;
                Intrinsics.checkNotNull(kType2);
                final Type computeJavaType$default = computeJavaType$default(kType2, false, 1, null);
                yield (computeJavaType$default instanceof Class) ? clazz : new GenericArrayTypeImpl(computeJavaType$default);
            }
            default -> throw new NoWhenBranchMatchedException();
        };
    }
    
    static /* synthetic */ Type computeJavaType$default(final KType kType, boolean b, final int n, final Object o) {
        if ((n & 0x1) != 0x0) {
            b = false;
        }
        return computeJavaType(kType, b);
    }
    
    @ExperimentalStdlibApi
    private static final Type createPossiblyInnerType(final Class<?> clazz, final List<KTypeProjection> list) {
        final Class declaringClass = clazz.getDeclaringClass();
        if (declaringClass == null) {
            final Type type = null;
            final Iterable iterable = list;
            final Type type2 = type;
            final Iterable iterable2 = iterable;
            final Collection collection = new ArrayList<Type>(CollectionsKt__IterablesKt.collectionSizeOrDefault((Iterable<?>)iterable, 10));
            final Iterator iterator = iterable2.iterator();
            while (iterator.hasNext()) {
                collection.add(getJavaType((KTypeProjection)iterator.next()));
            }
            return new ParameterizedTypeImpl(clazz, type2, (List<? extends Type>)collection);
        }
        final Class clazz2 = declaringClass;
        if (Modifier.isStatic(clazz.getModifiers())) {
            final Type type3 = clazz2;
            final Iterable iterable3 = list;
            final Type type4 = type3;
            final Iterable iterable4 = iterable3;
            final Collection collection2 = new ArrayList<Type>(CollectionsKt__IterablesKt.collectionSizeOrDefault((Iterable<?>)iterable3, 10));
            final Iterator iterator2 = iterable4.iterator();
            while (iterator2.hasNext()) {
                collection2.add(getJavaType((KTypeProjection)iterator2.next()));
            }
            return new ParameterizedTypeImpl(clazz, type4, (List<? extends Type>)collection2);
        }
        final int length = clazz.getTypeParameters().length;
        final Type possiblyInnerType = createPossiblyInnerType(clazz2, list.subList(length, list.size()));
        final Iterable iterable5 = list.subList(0, length);
        final Type type5 = possiblyInnerType;
        final Iterable iterable6 = iterable5;
        final Collection collection3 = new ArrayList<Type>(CollectionsKt__IterablesKt.collectionSizeOrDefault((Iterable<?>)iterable5, 10));
        final Iterator iterator3 = iterable6.iterator();
        while (iterator3.hasNext()) {
            collection3.add(getJavaType((KTypeProjection)iterator3.next()));
        }
        return new ParameterizedTypeImpl(clazz, type5, (List<? extends Type>)collection3);
    }
    
    private static final Type getJavaType(final KTypeProjection kTypeProjection) {
        final KVariance variance = kTypeProjection.getVariance();
        if (variance == null) {
            return WildcardTypeImpl.Companion.getSTAR();
        }
        final KVariance kVariance = variance;
        final KType type = kTypeProjection.getType();
        Intrinsics.checkNotNull(type);
        final KType kType = type;
        return switch (WhenMappings.$EnumSwitchMapping$0[kVariance.ordinal()]) {
            case 2 -> computeJavaType(kType, true);
            case 1 -> new WildcardTypeImpl(null, computeJavaType(kType, true));
            case 3 -> new WildcardTypeImpl(computeJavaType(kType, true), null);
            default -> throw new NoWhenBranchMatchedException();
        };
    }
    
    private static final String typeToString(final Type type) {
        String string;
        if (type instanceof Class) {
            String s;
            if (((Class)type).isArray()) {
                final Sequence<Type> generateSequence = SequencesKt__SequencesKt.generateSequence(type, (Function1<? super Type, ? extends Type>)TypesJVMKt$typeToString$unwrap.TypesJVMKt$typeToString$unwrap$1.INSTANCE);
                s = SequencesKt___SequencesKt.last((Sequence<? extends Class>)generateSequence).getName() + StringsKt__StringsJVMKt.repeat("[]", SequencesKt___SequencesKt.count((Sequence<?>)generateSequence));
            }
            else {
                s = ((Class)type).getName();
            }
            final String s2 = s;
            Intrinsics.checkNotNullExpressionValue(s2, "{\n        if (type.isArr\u2026   } else type.name\n    }");
            string = s2;
        }
        else {
            string = type.toString();
        }
        return string;
    }
}
