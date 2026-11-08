/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.eventbus;

import com.google.common.base.Preconditions;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.annotation.Nullable;

public class EventSubscriber {
    private final Object target;
    private final Method method;

    EventSubscriber(Object object, Method method) {
        Preconditions.checkNotNull(object, "EventSubscriber target cannot be null.");
        Preconditions.checkNotNull(method, "EventSubscriber method cannot be null.");
        this.target = object;
        this.method = method;
        method.setAccessible(true);
    }

    public void handleEvent(Object object) throws InvocationTargetException {
        Preconditions.checkNotNull(object);
        try {
            this.method.invoke(this.target, object);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            throw new Error("Method rejected target/argument: " + object, illegalArgumentException);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new Error("Method became inaccessible: " + object, illegalAccessException);
        }
        catch (InvocationTargetException invocationTargetException) {
            if (invocationTargetException.getCause() instanceof Error) {
                throw (Error)invocationTargetException.getCause();
            }
            throw invocationTargetException;
        }
    }

    public String toString() {
        return "[wrapper " + this.method + "]";
    }

    public int hashCode() {
        int n = 31;
        return (31 + this.method.hashCode()) * 31 + System.identityHashCode(this.target);
    }

    public boolean equals(@Nullable Object object) {
        if (object instanceof EventSubscriber) {
            EventSubscriber eventSubscriber = (EventSubscriber)object;
            return this.target == eventSubscriber.target && this.method.equals(eventSubscriber.method);
        }
        return false;
    }

    public Object getSubscriber() {
        return this.target;
    }

    public Method getMethod() {
        return this.method;
    }
}

