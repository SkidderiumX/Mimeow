/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.reflect.Invokable;
import com.google.common.reflect.TypeToken;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import javax.annotation.Nullable;

@Beta
public class Parameter
implements AnnotatedElement {
    private final Invokable<?, ?> declaration;
    private final int position;
    private final TypeToken<?> type;
    private final ImmutableList<Annotation> annotations;

    Parameter(Invokable<?, ?> invokable, int n, TypeToken<?> typeToken, Annotation[] annotationArray) {
        this.declaration = invokable;
        this.position = n;
        this.type = typeToken;
        this.annotations = ImmutableList.copyOf(annotationArray);
    }

    public TypeToken<?> getType() {
        return this.type;
    }

    public Invokable<?, ?> getDeclaringInvokable() {
        return this.declaration;
    }

    @Override
    public boolean isAnnotationPresent(Class<? extends Annotation> clazz) {
        return this.getAnnotation((Class)clazz) != null;
    }

    @Nullable
    public <A extends Annotation> A getAnnotation(Class<A> clazz) {
        Preconditions.checkNotNull(clazz);
        for (Annotation annotation : this.annotations) {
            if (!clazz.isInstance(annotation)) continue;
            return (A)((Annotation)clazz.cast(annotation));
        }
        return null;
    }

    @Override
    public Annotation[] getAnnotations() {
        return this.getDeclaredAnnotations();
    }

    @Override
    public Annotation[] getDeclaredAnnotations() {
        return this.annotations.toArray(new Annotation[this.annotations.size()]);
    }

    public boolean equals(@Nullable Object object) {
        if (object instanceof Parameter) {
            Parameter parameter = (Parameter)object;
            return this.position == parameter.position && this.declaration.equals(parameter.declaration);
        }
        return false;
    }

    public int hashCode() {
        return this.position;
    }

    public String toString() {
        return this.type + " arg" + this.position;
    }
}

