/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.eventbus;

import com.google.common.collect.Multimap;
import com.google.common.eventbus.EventSubscriber;

public interface SubscriberFindingStrategy {
    public Multimap<Class<?>, EventSubscriber> findAllSubscribers(Object var1);
}

