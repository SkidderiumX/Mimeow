/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.eventbus;

import com.google.common.base.Objects;
import com.google.common.base.Throwables;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.EventSubscriber;
import com.google.common.eventbus.Subscribe;
import com.google.common.eventbus.SubscriberFindingStrategy;
import com.google.common.eventbus.SynchronizedEventSubscriber;
import com.google.common.reflect.TypeToken;
import com.google.common.util.concurrent.UncheckedExecutionException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;

public class AnnotatedSubscriberFinder
implements SubscriberFindingStrategy {
    private static final LoadingCache<Class<?>, ImmutableList<Method>> subscriberMethodsCache = CacheBuilder.newBuilder().weakKeys().build(new CacheLoader<Class<?>, ImmutableList<Method>>(){

        @Override
        public ImmutableList<Method> load(Class<?> clazz) throws Exception {
            return AnnotatedSubscriberFinder.getAnnotatedMethodsInternal(clazz);
        }
    });

    AnnotatedSubscriberFinder() {
    }

    @Override
    public Multimap<Class<?>, EventSubscriber> findAllSubscribers(Object object) {
        HashMultimap<Class<?>, EventSubscriber> hashMultimap = HashMultimap.create();
        Class<?> clazz = object.getClass();
        for (Method method : AnnotatedSubscriberFinder.getAnnotatedMethods(clazz)) {
            Class<?>[] classArray = method.getParameterTypes();
            Class<?> clazz2 = classArray[0];
            EventSubscriber eventSubscriber = AnnotatedSubscriberFinder.makeSubscriber(object, method);
            hashMultimap.put(clazz2, eventSubscriber);
        }
        return hashMultimap;
    }

    private static ImmutableList<Method> getAnnotatedMethods(Class<?> clazz) {
        try {
            return subscriberMethodsCache.getUnchecked(clazz);
        }
        catch (UncheckedExecutionException uncheckedExecutionException) {
            throw Throwables.propagate(uncheckedExecutionException.getCause());
        }
    }

    private static ImmutableList<Method> getAnnotatedMethodsInternal(Class<?> clazz) {
        Set set = TypeToken.of(clazz).getTypes().rawTypes();
        HashMap<MethodIdentifier, Method> hashMap = Maps.newHashMap();
        for (Class clazz2 : set) {
            for (Method method : clazz2.getMethods()) {
                if (!method.isAnnotationPresent(Subscribe.class)) continue;
                Class<?>[] classArray = method.getParameterTypes();
                if (classArray.length != 1) {
                    throw new IllegalArgumentException("Method " + method + " has @Subscribe annotation, but requires " + classArray.length + " arguments.  Event subscriber methods must require a single argument.");
                }
                MethodIdentifier methodIdentifier = new MethodIdentifier(method);
                if (hashMap.containsKey(methodIdentifier)) continue;
                hashMap.put(methodIdentifier, method);
            }
        }
        return ImmutableList.copyOf(hashMap.values());
    }

    private static EventSubscriber makeSubscriber(Object object, Method method) {
        EventSubscriber eventSubscriber = AnnotatedSubscriberFinder.methodIsDeclaredThreadSafe(method) ? new EventSubscriber(object, method) : new SynchronizedEventSubscriber(object, method);
        return eventSubscriber;
    }

    private static boolean methodIsDeclaredThreadSafe(Method method) {
        return method.getAnnotation(AllowConcurrentEvents.class) != null;
    }

    private static final class MethodIdentifier {
        private final String name;
        private final List<Class<?>> parameterTypes;

        MethodIdentifier(Method method) {
            this.name = method.getName();
            this.parameterTypes = Arrays.asList(method.getParameterTypes());
        }

        public int hashCode() {
            return Objects.hashCode(this.name, this.parameterTypes);
        }

        public boolean equals(@Nullable Object object) {
            if (object instanceof MethodIdentifier) {
                MethodIdentifier methodIdentifier = (MethodIdentifier)object;
                return this.name.equals(methodIdentifier.name) && this.parameterTypes.equals(methodIdentifier.parameterTypes);
            }
            return false;
        }
    }
}

