/*
 * Decompiled with CFR 0.152.
 */
package io.netty.util;

import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Recycler<T> {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(Recycler.class);
    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(Integer.MIN_VALUE);
    private static final int OWN_THREAD_ID = ID_GENERATOR.getAndIncrement();
    private static final int DEFAULT_MAX_CAPACITY;
    private static final int INITIAL_CAPACITY;
    private final int maxCapacity;
    private final FastThreadLocal<Stack<T>> threadLocal = new FastThreadLocal<Stack<T>>(){

        @Override
        protected Stack<T> initialValue() {
            return new Stack(Recycler.this, Thread.currentThread(), Recycler.this.maxCapacity);
        }
    };
    private static final FastThreadLocal<Map<Stack<?>, WeakOrderQueue>> DELAYED_RECYCLED;

    protected Recycler() {
        this(DEFAULT_MAX_CAPACITY);
    }

    protected Recycler(int n) {
        this.maxCapacity = Math.max(0, n);
    }

    public final T get() {
        Stack<T> stack = this.threadLocal.get();
        DefaultHandle defaultHandle = stack.pop();
        if (defaultHandle == null) {
            defaultHandle = stack.newHandle();
            defaultHandle.value = this.newObject(defaultHandle);
        }
        return (T)defaultHandle.value;
    }

    public final boolean recycle(T t, Handle handle) {
        DefaultHandle defaultHandle = (DefaultHandle)handle;
        if (((DefaultHandle)defaultHandle).stack.parent != this) {
            return false;
        }
        if (t != defaultHandle.value) {
            throw new IllegalArgumentException("o does not belong to handle");
        }
        defaultHandle.recycle();
        return true;
    }

    protected abstract T newObject(Handle var1);

    static /* synthetic */ AtomicInteger access$400() {
        return ID_GENERATOR;
    }

    static {
        int n = SystemPropertyUtil.getInt("io.netty.recycler.maxCapacity.default", 0);
        if (n <= 0) {
            n = 262144;
        }
        DEFAULT_MAX_CAPACITY = n;
        if (logger.isDebugEnabled()) {
            logger.debug("-Dio.netty.recycler.maxCapacity.default: {}", (Object)DEFAULT_MAX_CAPACITY);
        }
        INITIAL_CAPACITY = Math.min(DEFAULT_MAX_CAPACITY, 256);
        DELAYED_RECYCLED = new FastThreadLocal<Map<Stack<?>, WeakOrderQueue>>(){

            @Override
            protected Map<Stack<?>, WeakOrderQueue> initialValue() {
                return new WeakHashMap();
            }
        };
    }

    public static final class Stack<T> {
        final Recycler<T> parent;
        final Thread thread;
        private DefaultHandle[] elements;
        private final int maxCapacity;
        private int size;
        private volatile WeakOrderQueue head;
        private WeakOrderQueue cursor;
        private WeakOrderQueue prev;

        Stack(Recycler<T> recycler, Thread thread2, int n) {
            this.parent = recycler;
            this.thread = thread2;
            this.maxCapacity = n;
            this.elements = new DefaultHandle[INITIAL_CAPACITY];
        }

        DefaultHandle pop() {
            DefaultHandle defaultHandle;
            int n = this.size;
            if (n == 0) {
                if (!this.scavenge()) {
                    return null;
                }
                n = this.size;
            }
            if ((defaultHandle = this.elements[--n]).lastRecycledId != defaultHandle.recycleId) {
                throw new IllegalStateException("recycled multiple times");
            }
            defaultHandle.recycleId = 0;
            defaultHandle.lastRecycledId = 0;
            this.size = n;
            return defaultHandle;
        }

        boolean scavenge() {
            if (this.scavengeSome()) {
                return true;
            }
            this.prev = null;
            this.cursor = this.head;
            return false;
        }

        boolean scavengeSome() {
            boolean bl = false;
            WeakOrderQueue weakOrderQueue = this.cursor;
            WeakOrderQueue weakOrderQueue2 = this.prev;
            while (weakOrderQueue != null) {
                if (weakOrderQueue.transfer(this)) {
                    bl = true;
                    break;
                }
                WeakOrderQueue weakOrderQueue3 = weakOrderQueue.next;
                if (weakOrderQueue.owner.get() == null) {
                    if (weakOrderQueue.hasFinalData()) {
                        while (weakOrderQueue.transfer(this)) {
                        }
                    }
                    if (weakOrderQueue2 != null) {
                        weakOrderQueue2.next = weakOrderQueue3;
                    }
                } else {
                    weakOrderQueue2 = weakOrderQueue;
                }
                weakOrderQueue = weakOrderQueue3;
            }
            this.prev = weakOrderQueue2;
            this.cursor = weakOrderQueue;
            return bl;
        }

        void push(DefaultHandle defaultHandle) {
            if ((defaultHandle.recycleId | defaultHandle.lastRecycledId) != 0) {
                throw new IllegalStateException("recycled already");
            }
            defaultHandle.recycleId = (defaultHandle.lastRecycledId = OWN_THREAD_ID);
            int n = this.size;
            if (n == this.elements.length) {
                if (n == this.maxCapacity) {
                    return;
                }
                this.elements = Arrays.copyOf(this.elements, n << 1);
            }
            this.elements[n] = defaultHandle;
            this.size = n + 1;
        }

        DefaultHandle newHandle() {
            return new DefaultHandle(this);
        }

        static /* synthetic */ DefaultHandle[] access$1202(Stack stack, DefaultHandle[] defaultHandleArray) {
            stack.elements = defaultHandleArray;
            return defaultHandleArray;
        }
    }

    private static final class WeakOrderQueue {
        private static final int LINK_CAPACITY = 16;
        private Link head;
        private Link tail;
        private WeakOrderQueue next;
        private final WeakReference<Thread> owner;
        private final int id = Recycler.access$400().getAndIncrement();

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        WeakOrderQueue(Stack<?> stack, Thread thread2) {
            this.head = this.tail = new Link();
            this.owner = new WeakReference<Thread>(thread2);
            Stack<?> stack2 = stack;
            synchronized (stack2) {
                this.next = ((Stack)stack).head;
                ((Stack)stack).head = this;
            }
        }

        void add(DefaultHandle defaultHandle) {
            defaultHandle.lastRecycledId = this.id;
            Link link = this.tail;
            int n = link.get();
            if (n == 16) {
                this.tail = link = (link.next = new Link());
                n = link.get();
            }
            ((Link)link).elements[n] = defaultHandle;
            defaultHandle.stack = null;
            link.lazySet(n + 1);
        }

        boolean hasFinalData() {
            return this.tail.readIndex != this.tail.get();
        }

        boolean transfer(Stack<?> stack) {
            int n;
            int n2;
            Link link = this.head;
            if (link == null) {
                return false;
            }
            if (link.readIndex == 16) {
                if (link.next == null) {
                    return false;
                }
                this.head = link = link.next;
            }
            if ((n2 = link.readIndex) == (n = link.get())) {
                return false;
            }
            int n3 = n - n2;
            if (((Stack)stack).size + n3 > ((Stack)stack).elements.length) {
                Stack.access$1202(stack, Arrays.copyOf(((Stack)stack).elements, (((Stack)stack).size + n3) * 2));
            }
            DefaultHandle[] defaultHandleArray = link.elements;
            DefaultHandle[] defaultHandleArray2 = ((Stack)stack).elements;
            int n4 = ((Stack)stack).size;
            while (n2 < n) {
                DefaultHandle defaultHandle = defaultHandleArray[n2];
                if (defaultHandle.recycleId == 0) {
                    defaultHandle.recycleId = defaultHandle.lastRecycledId;
                } else if (defaultHandle.recycleId != defaultHandle.lastRecycledId) {
                    throw new IllegalStateException("recycled already");
                }
                defaultHandle.stack = stack;
                defaultHandleArray2[n4++] = defaultHandle;
                defaultHandleArray[n2++] = null;
            }
            ((Stack)stack).size = n4;
            if (n == 16 && link.next != null) {
                this.head = link.next;
            }
            link.readIndex = n;
            return true;
        }

        private static final class Link
        extends AtomicInteger {
            private final DefaultHandle[] elements = new DefaultHandle[16];
            private int readIndex;
            private Link next;

            private Link() {
            }
        }
    }

    public static final class DefaultHandle
    implements Handle {
        private int lastRecycledId;
        private int recycleId;
        private Stack<?> stack;
        private Object value;

        DefaultHandle(Stack<?> stack) {
            this.stack = stack;
        }

        public void recycle() {
            Thread thread2 = Thread.currentThread();
            if (thread2 == this.stack.thread) {
                this.stack.push(this);
                return;
            }
            Map map = (Map)DELAYED_RECYCLED.get();
            WeakOrderQueue weakOrderQueue = (WeakOrderQueue)map.get(this.stack);
            if (weakOrderQueue == null) {
                weakOrderQueue = new WeakOrderQueue(this.stack, thread2);
                map.put(this.stack, weakOrderQueue);
            }
            weakOrderQueue.add(this);
        }
    }

    public static interface Handle {
    }
}

