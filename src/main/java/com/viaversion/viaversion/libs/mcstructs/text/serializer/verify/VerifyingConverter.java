/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.serializer.verify;

import com.viaversion.viaversion.libs.mcstructs.converter.DataConverter;
import com.viaversion.viaversion.libs.mcstructs.converter.impl.DelegatingConverter;
import com.viaversion.viaversion.libs.mcstructs.converter.model.Result;
import com.viaversion.viaversion.libs.mcstructs.text.serializer.verify.TextVerifier;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class VerifyingConverter<T>
extends DelegatingConverter<T> {
    private final TextVerifier textVerifier;

    public static <T, V extends TextVerifier> BiFunction<DataConverter<?>, T, Result<Void>> verify(Class<V> clazz, BiPredicate<V, T> biPredicate, String string) {
        return VerifyingConverter.verify(clazz, (object, textVerifier) -> {
            if (biPredicate.test(textVerifier, object)) {
                return null;
            }
            return Result.error(string + ": " + object);
        });
    }

    public static <T, V extends TextVerifier> BiFunction<DataConverter<?>, T, Result<Void>> verify(Class<V> clazz, BiFunction<T, V, Result<Void>> biFunction) {
        return (dataConverter, object) -> {
            if (!(dataConverter instanceof VerifyingConverter)) {
                return null;
            }
            VerifyingConverter verifyingConverter = (VerifyingConverter)dataConverter;
            if (!clazz.isInstance(verifyingConverter.textVerifier)) {
                throw new IllegalStateException("Invalid verifier. Expected " + clazz.getName() + " but got " + verifyingConverter.textVerifier.getClass().getName());
            }
            return (Result)biFunction.apply(object, verifyingConverter.textVerifier);
        };
    }

    public static <T, V extends TextVerifier> boolean isValid(DataConverter<?> dataConverter, T t, Class<V> clazz, BiPredicate<V, T> biPredicate) {
        if (!(dataConverter instanceof VerifyingConverter)) {
            return true;
        }
        VerifyingConverter verifyingConverter = (VerifyingConverter)dataConverter;
        if (!clazz.isInstance(verifyingConverter.textVerifier)) {
            throw new IllegalStateException("Invalid verifier. Expected " + clazz.getName() + " but got " + verifyingConverter.textVerifier.getClass().getName());
        }
        return biPredicate.test((V)verifyingConverter.textVerifier, (TextVerifier)t);
    }

    public VerifyingConverter(DataConverter<T> dataConverter, TextVerifier textVerifier) {
        super(dataConverter instanceof VerifyingConverter ? ((VerifyingConverter)dataConverter).getDelegate() : dataConverter);
        this.textVerifier = textVerifier;
    }

    public TextVerifier getTextVerifier() {
        return this.textVerifier;
    }
}

