package kotlin.jvm;

import kotlin.reflect.*;
import java.io.*;
import org.jetbrains.annotations.*;
import kotlin.jvm.internal.*;
import java.lang.annotation.*;
import kotlin.*;
import kotlin.internal.*;

@Metadata(mv = { 1, 9, 0 }, k = 2, xi = 48, d1 = { "\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0010\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\u0010\u0011\n\u0002\b\u0002\u001a\u001f\u0010\u001f\u001a\u00020 \"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0014*\u0006\u0012\u0002\b\u00030!¢\u0006\u0002\u0010\"\"'\u0010\u0000\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0002H\u00028F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\";\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u000e\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\t*\b\u0012\u0004\u0012\u0002H\b0\t8\u00c6\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"-\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00018G¢\u0006\f\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"&\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\"\b\b\u0000\u0010\u0002*\u00020\u0014*\u0002H\u00028\u00c6\u0002¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0015\";\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0007\"\b\b\u0000\u0010\u0002*\u00020\u0014*\b\u0012\u0004\u0012\u0002H\u00020\u00018\u00c7\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0012\"+\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\"\b\b\u0000\u0010\u0002*\u00020\u0014*\b\u0012\u0004\u0012\u0002H\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0012\"-\u0010\u001a\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0007\"\b\b\u0000\u0010\u0002*\u00020\u0014*\b\u0012\u0004\u0012\u0002H\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0012\"+\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0014*\b\u0012\u0004\u0012\u0002H\u00020\u00078G¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006#" }, d2 = { "annotationClass", "Lkotlin/reflect/KClass;", "T", "", "getAnnotationClass", "(Ljava/lang/annotation/Annotation;)Lkotlin/reflect/KClass;", "declaringJavaClass", "Ljava/lang/Class;", "E", "", "getDeclaringJavaClass$annotations", "(Ljava/lang/Enum;)V", "getDeclaringJavaClass", "(Ljava/lang/Enum;)Ljava/lang/Class;", "java", "getJavaClass$annotations", "(Lkotlin/reflect/KClass;)V", "getJavaClass", "(Lkotlin/reflect/KClass;)Ljava/lang/Class;", "javaClass", "", "(Ljava/lang/Object;)Ljava/lang/Class;", "getRuntimeClassOfKClassInstance$annotations", "getRuntimeClassOfKClassInstance", "javaObjectType", "getJavaObjectType", "javaPrimitiveType", "getJavaPrimitiveType", "kotlin", "getKotlinClass", "(Ljava/lang/Class;)Lkotlin/reflect/KClass;", "isArrayOf", "", "", "([Ljava/lang/Object;)Z", "kotlin-stdlib" })
@JvmName(name = "JvmClassMappingKt")
public class JvmClassMappingKt
{
    @JvmName(name = "getJavaClass")
    @NotNull
    public static final <T> Class<T> getJavaClass(@NotNull final KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        final Class<?> jClass = ((ClassBasedDeclarationContainer)kClass).getJClass();
        Intrinsics.checkNotNull(jClass, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
        return (Class<T>)jClass;
    }
    
    @Nullable
    public static final <T> Class<T> getJavaPrimitiveType(@NotNull final KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        final Class<?> jClass = ((ClassBasedDeclarationContainer)kClass).getJClass();
        if (jClass.isPrimitive()) {
            Intrinsics.checkNotNull(jClass, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaPrimitiveType>>");
            return (Class<T>)jClass;
        }
        final String name = jClass.getName();
        if (name != null) {
            switch (name) {
                case "java.lang.Float": {
                    final Serializable s = Float.TYPE;
                    return (Class<T>)s;
                }
                case "java.lang.Void": {
                    final Serializable s = Void.TYPE;
                    return (Class<T>)s;
                }
                case "java.lang.Character": {
                    final Serializable s = Character.TYPE;
                    return (Class<T>)s;
                }
                case "java.lang.Long": {
                    final Serializable s = Long.TYPE;
                    return (Class<T>)s;
                }
                case "java.lang.Double": {
                    final Serializable s = Double.TYPE;
                    return (Class<T>)s;
                }
                case "java.lang.Short": {
                    final Serializable s = Short.TYPE;
                    return (Class<T>)s;
                }
                case "java.lang.Boolean": {
                    final Serializable s = Boolean.TYPE;
                    return (Class<T>)s;
                }
                case "java.lang.Byte": {
                    final Serializable s = Byte.TYPE;
                    return (Class<T>)s;
                }
                case "java.lang.Integer": {
                    final Serializable s = Integer.TYPE;
                    return (Class<T>)s;
                }
                default:
                    break;
            }
        }
        final Serializable s = null;
        return (Class<T>)s;
    }
    
    @NotNull
    public static final <T> Class<T> getJavaObjectType(@NotNull final KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        final Class<?> jClass = ((ClassBasedDeclarationContainer)kClass).getJClass();
        if (!jClass.isPrimitive()) {
            Intrinsics.checkNotNull(jClass, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
            return (Class<T>)jClass;
        }
        final String name = jClass.getName();
        Serializable s2 = null;
        Serializable s = null;
        Label_0282: {
            if (name != null) {
                switch (name) {
                    case "boolean": {
                        s = (s2 = Boolean.class);
                        break Label_0282;
                    }
                    case "void": {
                        s = (s2 = Void.class);
                        break Label_0282;
                    }
                    case "byte": {
                        s = (s2 = Byte.class);
                        break Label_0282;
                    }
                    case "double": {
                        s = (s2 = Double.class);
                        break Label_0282;
                    }
                    case "char": {
                        s = (s2 = Character.class);
                        break Label_0282;
                    }
                    case "short": {
                        s = (s2 = Short.class);
                        break Label_0282;
                    }
                    case "float": {
                        s = (s2 = Float.class);
                        break Label_0282;
                    }
                    case "int": {
                        s = (s2 = Integer.class);
                        break Label_0282;
                    }
                    case "long": {
                        s = (s2 = Long.class);
                        break Label_0282;
                    }
                    default:
                        break;
                }
            }
            s = (s2 = jClass);
        }
        Intrinsics.checkNotNull(s2, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
        return (Class<T>)s;
    }
    
    @JvmName(name = "getKotlinClass")
    @NotNull
    public static final <T> KClass<T> getKotlinClass(@NotNull final Class<T> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "<this>");
        return Reflection.getOrCreateKotlinClass(clazz);
    }
    
    @NotNull
    public static final <T> Class<T> getJavaClass(@NotNull final T t) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        final Class<?> class1 = t.getClass();
        Intrinsics.checkNotNull(class1, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaClass>>");
        return (Class<T>)class1;
    }
    
    @JvmName(name = "getRuntimeClassOfKClassInstance")
    @NotNull
    @java.lang.Deprecated
    public static final <T> Class<KClass<T>> getRuntimeClassOfKClassInstance(@NotNull final KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        final Class<?> class1 = kClass.getClass();
        Intrinsics.checkNotNull(class1, "null cannot be cast to non-null type java.lang.Class<kotlin.reflect.KClass<T of kotlin.jvm.JvmClassMappingKt.<get-javaClass>>>");
        return (Class<KClass<T>>)class1;
    }
    
    @NotNull
    public static final <T extends Annotation> KClass<? extends T> getAnnotationClass(@NotNull final T t) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        final Class<? extends Annotation> annotationType = t.annotationType();
        Intrinsics.checkNotNullExpressionValue(annotationType, "this as java.lang.annota\u2026otation).annotationType()");
        final KClass<Object> kotlinClass = getKotlinClass((Class<Object>)annotationType);
        Intrinsics.checkNotNull(kotlinClass, "null cannot be cast to non-null type kotlin.reflect.KClass<out T of kotlin.jvm.JvmClassMappingKt.<get-annotationClass>>");
        return (KClass<? extends T>)kotlinClass;
    }
    
    private static final <E extends Enum<E>> Class<E> getDeclaringJavaClass(final Enum<E> enum1) {
        Intrinsics.checkNotNullParameter(enum1, "<this>");
        final Class<E> declaringClass = enum1.getDeclaringClass();
        Intrinsics.checkNotNullExpressionValue(declaringClass, "this as java.lang.Enum<E>).declaringClass");
        return declaringClass;
    }
}
