/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.eventbus;

import com.google.common.eventbus.EventSubscriber;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SynchronizedEventSubscriber
extends EventSubscriber {
    public SynchronizedEventSubscriber(Object object, Method method) {
        super(object, method);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void handleEvent(Object object) throws InvocationTargetException {
        SynchronizedEventSubscriber synchronizedEventSubscriber = this;
        synchronized (synchronizedEventSubscriber) {
            super.handleEvent(object);
        }
    }
}

