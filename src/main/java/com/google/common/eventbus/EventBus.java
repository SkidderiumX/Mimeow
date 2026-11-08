/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.eventbus;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.SetMultimap;
import com.google.common.eventbus.AnnotatedSubscriberFinder;
import com.google.common.eventbus.DeadEvent;
import com.google.common.eventbus.EventSubscriber;
import com.google.common.eventbus.SubscriberExceptionContext;
import com.google.common.eventbus.SubscriberExceptionHandler;
import com.google.common.eventbus.SubscriberFindingStrategy;
import com.google.common.reflect.TypeToken;
import com.google.common.util.concurrent.UncheckedExecutionException;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Level;
import java.util.logging.Logger;

@Beta
public class EventBus {
    private static final LoadingCache<Class<?>, Set<Class<?>>> flattenHierarchyCache = CacheBuilder.newBuilder().weakKeys().build(new CacheLoader<Class<?>, Set<Class<?>>>(){

        @Override
        public Set<Class<?>> load(Class<?> clazz) {
            return TypeToken.of(clazz).getTypes().rawTypes();
        }
    });
    private final SetMultimap<Class<?>, EventSubscriber> subscribersByType = HashMultimap.create();
    private final ReadWriteLock subscribersByTypeLock = new ReentrantReadWriteLock();
    private final SubscriberFindingStrategy finder = new AnnotatedSubscriberFinder();
    private final ThreadLocal<Queue<EventWithSubscriber>> eventsToDispatch = new ThreadLocal<Queue<EventWithSubscriber>>(){

        @Override
        protected Queue<EventWithSubscriber> initialValue() {
            return new LinkedList<EventWithSubscriber>();
        }
    };
    private final ThreadLocal<Boolean> isDispatching = new ThreadLocal<Boolean>(){

        @Override
        protected Boolean initialValue() {
            return false;
        }
    };
    private SubscriberExceptionHandler subscriberExceptionHandler;

    public EventBus() {
        this("default");
    }

    public EventBus(String string) {
        this(new LoggingSubscriberExceptionHandler(string));
    }

    public EventBus(SubscriberExceptionHandler subscriberExceptionHandler) {
        this.subscriberExceptionHandler = Preconditions.checkNotNull(subscriberExceptionHandler);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void register(Object object) {
        Multimap<Class<?>, EventSubscriber> multimap = this.finder.findAllSubscribers(object);
        this.subscribersByTypeLock.writeLock().lock();
        try {
            this.subscribersByType.putAll(multimap);
        }
        finally {
            this.subscribersByTypeLock.writeLock().unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void unregister(Object object) {
        Multimap<Class<?>, EventSubscriber> multimap = this.finder.findAllSubscribers(object);
        for (Map.Entry<Class<?>, Collection<EventSubscriber>> entry : multimap.asMap().entrySet()) {
            Class<?> clazz = entry.getKey();
            Collection<EventSubscriber> collection = entry.getValue();
            this.subscribersByTypeLock.writeLock().lock();
            try {
                Set<EventSubscriber> set = this.subscribersByType.get(clazz);
                if (!set.containsAll(collection)) {
                    throw new IllegalArgumentException("missing event subscriber for an annotated method. Is " + object + " registered?");
                }
                set.removeAll(collection);
            }
            finally {
                this.subscribersByTypeLock.writeLock().unlock();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void post(Object object) {
        Set<Class<?>> set = this.flattenHierarchy(object.getClass());
        boolean bl = false;
        for (Class<?> clazz : set) {
            this.subscribersByTypeLock.readLock().lock();
            try {
                Set<EventSubscriber> set2 = this.subscribersByType.get(clazz);
                if (set2.isEmpty()) continue;
                bl = true;
                for (EventSubscriber eventSubscriber : set2) {
                    this.enqueueEvent(object, eventSubscriber);
                }
            }
            finally {
                this.subscribersByTypeLock.readLock().unlock();
            }
        }
        if (!bl && !(object instanceof DeadEvent)) {
            this.post(new DeadEvent(this, object));
        }
        this.dispatchQueuedEvents();
    }

    void enqueueEvent(Object object, EventSubscriber eventSubscriber) {
        this.eventsToDispatch.get().offer(new EventWithSubscriber(object, eventSubscriber));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void dispatchQueuedEvents() {
        if (this.isDispatching.get().booleanValue()) {
            return;
        }
        this.isDispatching.set(true);
        try {
            EventWithSubscriber eventWithSubscriber;
            Queue<EventWithSubscriber> queue = this.eventsToDispatch.get();
            while ((eventWithSubscriber = queue.poll()) != null) {
                this.dispatch(eventWithSubscriber.event, eventWithSubscriber.subscriber);
            }
        }
        finally {
            this.isDispatching.remove();
            this.eventsToDispatch.remove();
        }
    }

    void dispatch(Object object, EventSubscriber eventSubscriber) {
        try {
            eventSubscriber.handleEvent(object);
        }
        catch (InvocationTargetException invocationTargetException) {
            try {
                this.subscriberExceptionHandler.handleException(invocationTargetException.getCause(), new SubscriberExceptionContext(this, object, eventSubscriber.getSubscriber(), eventSubscriber.getMethod()));
            }
            catch (Throwable throwable) {
                Logger.getLogger(EventBus.class.getName()).log(Level.SEVERE, String.format("Exception %s thrown while handling exception: %s", throwable, invocationTargetException.getCause()), throwable);
            }
        }
    }

    @VisibleForTesting
    Set<Class<?>> flattenHierarchy(Class<?> clazz) {
        try {
            return flattenHierarchyCache.getUnchecked(clazz);
        }
        catch (UncheckedExecutionException uncheckedExecutionException) {
            throw Throwables.propagate(uncheckedExecutionException.getCause());
        }
    }

    public static class EventWithSubscriber {
        final Object event;
        final EventSubscriber subscriber;

        public EventWithSubscriber(Object object, EventSubscriber eventSubscriber) {
            this.event = Preconditions.checkNotNull(object);
            this.subscriber = Preconditions.checkNotNull(eventSubscriber);
        }
    }

    private static final class LoggingSubscriberExceptionHandler
    implements SubscriberExceptionHandler {
        private final Logger logger;

        public LoggingSubscriberExceptionHandler(String string) {
            this.logger = Logger.getLogger(EventBus.class.getName() + "." + Preconditions.checkNotNull(string));
        }

        @Override
        public void handleException(Throwable throwable, SubscriberExceptionContext subscriberExceptionContext) {
            this.logger.log(Level.SEVERE, "Could not dispatch event: " + subscriberExceptionContext.getSubscriber() + " to " + subscriberExceptionContext.getSubscriberMethod(), throwable.getCause());
        }
    }
}

