/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

public class Throwables {
    private Throwables() {
    }

    public static <X extends Throwable> void propagateIfInstanceOf(@Nullable Throwable throwable, Class<X> clazz) throws X {
        if (throwable != null && clazz.isInstance(throwable)) {
            throw (Throwable)clazz.cast(throwable);
        }
    }

    public static void propagateIfPossible(@Nullable Throwable throwable) {
        Throwables.propagateIfInstanceOf(throwable, Error.class);
        Throwables.propagateIfInstanceOf(throwable, RuntimeException.class);
    }

    public static <X extends Throwable> void propagateIfPossible(@Nullable Throwable throwable, Class<X> clazz) throws X {
        Throwables.propagateIfInstanceOf(throwable, clazz);
        Throwables.propagateIfPossible(throwable);
    }

    public static <X1 extends Throwable, X2 extends Throwable> void propagateIfPossible(@Nullable Throwable throwable, Class<X1> clazz, Class<X2> clazz2) throws X1, X2 {
        Preconditions.checkNotNull(clazz2);
        Throwables.propagateIfInstanceOf(throwable, clazz);
        Throwables.propagateIfPossible(throwable, clazz2);
    }

    public static RuntimeException propagate(Throwable throwable) {
        Throwables.propagateIfPossible(Preconditions.checkNotNull(throwable));
        throw new RuntimeException(throwable);
    }

    public static Throwable getRootCause(Throwable throwable) {
        Throwable throwable2;
        while ((throwable2 = throwable.getCause()) != null) {
            throwable = throwable2;
        }
        return throwable;
    }

    @Beta
    public static List<Throwable> getCausalChain(Throwable throwable) {
        Preconditions.checkNotNull(throwable);
        ArrayList<Throwable> arrayList = new ArrayList<Throwable>(4);
        while (throwable != null) {
            arrayList.add(throwable);
            throwable = throwable.getCause();
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static String getStackTraceAsString(Throwable throwable) {
        StringWriter stringWriter = new StringWriter();
        throwable.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }
}

