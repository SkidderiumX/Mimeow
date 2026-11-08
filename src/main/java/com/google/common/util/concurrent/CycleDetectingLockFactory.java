/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.MapMaker;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@Beta
@ThreadSafe
public class CycleDetectingLockFactory {
    private static final ConcurrentMap<Class<? extends Enum>, Map<? extends Enum, LockGraphNode>> lockGraphNodesPerType = new MapMaker().weakKeys().makeMap();
    private static final Logger logger = Logger.getLogger(CycleDetectingLockFactory.class.getName());
    final Policy policy;
    private static final ThreadLocal<ArrayList<LockGraphNode>> acquiredLocks = new ThreadLocal<ArrayList<LockGraphNode>>(){

        @Override
        protected ArrayList<LockGraphNode> initialValue() {
            return Lists.newArrayListWithCapacity(3);
        }
    };

    public static CycleDetectingLockFactory newInstance(Policy policy) {
        return new CycleDetectingLockFactory(policy);
    }

    public ReentrantLock newReentrantLock(String string) {
        return this.newReentrantLock(string, false);
    }

    public ReentrantLock newReentrantLock(String string, boolean bl) {
        return this.policy == Policies.DISABLED ? new ReentrantLock(bl) : new CycleDetectingReentrantLock(new LockGraphNode(string), bl);
    }

    public ReentrantReadWriteLock newReentrantReadWriteLock(String string) {
        return this.newReentrantReadWriteLock(string, false);
    }

    public ReentrantReadWriteLock newReentrantReadWriteLock(String string, boolean bl) {
        return this.policy == Policies.DISABLED ? new ReentrantReadWriteLock(bl) : new CycleDetectingReentrantReadWriteLock(new LockGraphNode(string), bl);
    }

    public static <E extends Enum<E>> WithExplicitOrdering<E> newInstanceWithExplicitOrdering(Class<E> clazz, Policy policy) {
        Preconditions.checkNotNull(clazz);
        Preconditions.checkNotNull(policy);
        Map<? extends Enum, LockGraphNode> map = CycleDetectingLockFactory.getOrCreateNodes(clazz);
        return new WithExplicitOrdering<Enum>(policy, map);
    }

    private static Map<? extends Enum, LockGraphNode> getOrCreateNodes(Class<? extends Enum> clazz) {
        Map<? extends Enum, LockGraphNode> map = (Map<? extends Enum, LockGraphNode>)lockGraphNodesPerType.get(clazz);
        if (map != null) {
            return map;
        }
        Map<? extends Enum, LockGraphNode> map2 = CycleDetectingLockFactory.createNodes(clazz);
        map = lockGraphNodesPerType.putIfAbsent(clazz, map2);
        return Objects.firstNonNull(map, map2);
    }

    @VisibleForTesting
    static <E extends Enum<E>> Map<E, LockGraphNode> createNodes(Class<E> clazz) {
        int n;
        EnumMap<E, LockGraphNode> enumMap = Maps.newEnumMap(clazz);
        Enum[] enumArray = (Enum[])clazz.getEnumConstants();
        int n2 = enumArray.length;
        ArrayList<LockGraphNode> arrayList = Lists.newArrayListWithCapacity(n2);
        for (Enum enum_ : enumArray) {
            LockGraphNode lockGraphNode = new LockGraphNode(CycleDetectingLockFactory.getLockName(enum_));
            arrayList.add(lockGraphNode);
            enumMap.put(enum_, lockGraphNode);
        }
        for (n = 1; n < n2; ++n) {
            ((LockGraphNode)arrayList.get(n)).checkAcquiredLocks(Policies.THROW, arrayList.subList(0, n));
        }
        for (n = 0; n < n2 - 1; ++n) {
            ((LockGraphNode)arrayList.get(n)).checkAcquiredLocks(Policies.DISABLED, arrayList.subList(n + 1, n2));
        }
        return Collections.unmodifiableMap(enumMap);
    }

    private static String getLockName(Enum<?> enum_) {
        return enum_.getDeclaringClass().getSimpleName() + "." + enum_.name();
    }

    private CycleDetectingLockFactory(Policy policy) {
        this.policy = Preconditions.checkNotNull(policy);
    }

    private void aboutToAcquire(CycleDetectingLock cycleDetectingLock) {
        if (!cycleDetectingLock.isAcquiredByCurrentThread()) {
            ArrayList<LockGraphNode> arrayList = acquiredLocks.get();
            LockGraphNode lockGraphNode = cycleDetectingLock.getLockGraphNode();
            lockGraphNode.checkAcquiredLocks(this.policy, arrayList);
            arrayList.add(lockGraphNode);
        }
    }

    private void lockStateChanged(CycleDetectingLock cycleDetectingLock) {
        if (!cycleDetectingLock.isAcquiredByCurrentThread()) {
            ArrayList<LockGraphNode> arrayList = acquiredLocks.get();
            LockGraphNode lockGraphNode = cycleDetectingLock.getLockGraphNode();
            for (int i = arrayList.size() - 1; i >= 0; --i) {
                if (arrayList.get(i) != lockGraphNode) continue;
                arrayList.remove(i);
                break;
            }
        }
    }

    private class CycleDetectingReentrantWriteLock
    extends ReentrantReadWriteLock.WriteLock {
        final CycleDetectingReentrantReadWriteLock readWriteLock;

        CycleDetectingReentrantWriteLock(CycleDetectingReentrantReadWriteLock cycleDetectingReentrantReadWriteLock) {
            super(cycleDetectingReentrantReadWriteLock);
            this.readWriteLock = cycleDetectingReentrantReadWriteLock;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public void lock() {
            CycleDetectingLockFactory.this.aboutToAcquire(this.readWriteLock);
            try {
                super.lock();
            }
            finally {
                CycleDetectingLockFactory.this.lockStateChanged(this.readWriteLock);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public void lockInterruptibly() throws InterruptedException {
            CycleDetectingLockFactory.this.aboutToAcquire(this.readWriteLock);
            try {
                super.lockInterruptibly();
            }
            finally {
                CycleDetectingLockFactory.this.lockStateChanged(this.readWriteLock);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public boolean tryLock() {
            CycleDetectingLockFactory.this.aboutToAcquire(this.readWriteLock);
            try {
                boolean bl = super.tryLock();
                return bl;
            }
            finally {
                CycleDetectingLockFactory.this.lockStateChanged(this.readWriteLock);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public boolean tryLock(long l, TimeUnit timeUnit) throws InterruptedException {
            CycleDetectingLockFactory.this.aboutToAcquire(this.readWriteLock);
            try {
                boolean bl = super.tryLock(l, timeUnit);
                return bl;
            }
            finally {
                CycleDetectingLockFactory.this.lockStateChanged(this.readWriteLock);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public void unlock() {
            try {
                super.unlock();
            }
            finally {
                CycleDetectingLockFactory.this.lockStateChanged(this.readWriteLock);
            }
        }
    }

    private class CycleDetectingReentrantReadLock
    extends ReentrantReadWriteLock.ReadLock {
        final CycleDetectingReentrantReadWriteLock readWriteLock;

        CycleDetectingReentrantReadLock(CycleDetectingReentrantReadWriteLock cycleDetectingReentrantReadWriteLock) {
            super(cycleDetectingReentrantReadWriteLock);
            this.readWriteLock = cycleDetectingReentrantReadWriteLock;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public void lock() {
            CycleDetectingLockFactory.this.aboutToAcquire(this.readWriteLock);
            try {
                super.lock();
            }
            finally {
                CycleDetectingLockFactory.this.lockStateChanged(this.readWriteLock);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public void lockInterruptibly() throws InterruptedException {
            CycleDetectingLockFactory.this.aboutToAcquire(this.readWriteLock);
            try {
                super.lockInterruptibly();
            }
            finally {
                CycleDetectingLockFactory.this.lockStateChanged(this.readWriteLock);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public boolean tryLock() {
            CycleDetectingLockFactory.this.aboutToAcquire(this.readWriteLock);
            try {
                boolean bl = super.tryLock();
                return bl;
            }
            finally {
                CycleDetectingLockFactory.this.lockStateChanged(this.readWriteLock);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public boolean tryLock(long l, TimeUnit timeUnit) throws InterruptedException {
            CycleDetectingLockFactory.this.aboutToAcquire(this.readWriteLock);
            try {
                boolean bl = super.tryLock(l, timeUnit);
                return bl;
            }
            finally {
                CycleDetectingLockFactory.this.lockStateChanged(this.readWriteLock);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public void unlock() {
            try {
                super.unlock();
            }
            finally {
                CycleDetectingLockFactory.this.lockStateChanged(this.readWriteLock);
            }
        }
    }

    public final class CycleDetectingReentrantReadWriteLock
    extends ReentrantReadWriteLock
    implements CycleDetectingLock {
        private final CycleDetectingReentrantReadLock readLock;
        private final CycleDetectingReentrantWriteLock writeLock;
        private final LockGraphNode lockGraphNode;

        private CycleDetectingReentrantReadWriteLock(LockGraphNode lockGraphNode, boolean bl) {
            super(bl);
            this.readLock = new CycleDetectingReentrantReadLock(this);
            this.writeLock = new CycleDetectingReentrantWriteLock(this);
            this.lockGraphNode = Preconditions.checkNotNull(lockGraphNode);
        }

        @Override
        public ReentrantReadWriteLock.ReadLock readLock() {
            return this.readLock;
        }

        @Override
        public ReentrantReadWriteLock.WriteLock writeLock() {
            return this.writeLock;
        }

        @Override
        public LockGraphNode getLockGraphNode() {
            return this.lockGraphNode;
        }

        @Override
        public boolean isAcquiredByCurrentThread() {
            return this.isWriteLockedByCurrentThread() || this.getReadHoldCount() > 0;
        }
    }

    public final class CycleDetectingReentrantLock
    extends ReentrantLock
    implements CycleDetectingLock {
        private final LockGraphNode lockGraphNode;

        private CycleDetectingReentrantLock(LockGraphNode lockGraphNode, boolean bl) {
            super(bl);
            this.lockGraphNode = Preconditions.checkNotNull(lockGraphNode);
        }

        @Override
        public LockGraphNode getLockGraphNode() {
            return this.lockGraphNode;
        }

        @Override
        public boolean isAcquiredByCurrentThread() {
            return this.isHeldByCurrentThread();
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public void lock() {
            CycleDetectingLockFactory.this.aboutToAcquire(this);
            try {
                super.lock();
            }
            finally {
                CycleDetectingLockFactory.this.lockStateChanged(this);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public void lockInterruptibly() throws InterruptedException {
            CycleDetectingLockFactory.this.aboutToAcquire(this);
            try {
                super.lockInterruptibly();
            }
            finally {
                CycleDetectingLockFactory.this.lockStateChanged(this);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public boolean tryLock() {
            CycleDetectingLockFactory.this.aboutToAcquire(this);
            try {
                boolean bl = super.tryLock();
                return bl;
            }
            finally {
                CycleDetectingLockFactory.this.lockStateChanged(this);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public boolean tryLock(long l, TimeUnit timeUnit) throws InterruptedException {
            CycleDetectingLockFactory.this.aboutToAcquire(this);
            try {
                boolean bl = super.tryLock(l, timeUnit);
                return bl;
            }
            finally {
                CycleDetectingLockFactory.this.lockStateChanged(this);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public void unlock() {
            try {
                super.unlock();
            }
            finally {
                CycleDetectingLockFactory.this.lockStateChanged(this);
            }
        }
    }

    private static class LockGraphNode {
        final Map<LockGraphNode, ExampleStackTrace> allowedPriorLocks = new MapMaker().weakKeys().makeMap();
        final Map<LockGraphNode, PotentialDeadlockException> disallowedPriorLocks = new MapMaker().weakKeys().makeMap();
        final String lockName;

        LockGraphNode(String string) {
            this.lockName = Preconditions.checkNotNull(string);
        }

        String getLockName() {
            return this.lockName;
        }

        void checkAcquiredLocks(Policy policy, List<LockGraphNode> list) {
            int n = list.size();
            for (int i = 0; i < n; ++i) {
                this.checkAcquiredLock(policy, list.get(i));
            }
        }

        void checkAcquiredLock(Policy policy, LockGraphNode lockGraphNode) {
            Preconditions.checkState(this != lockGraphNode, "Attempted to acquire multiple locks with the same rank " + lockGraphNode.getLockName());
            if (this.allowedPriorLocks.containsKey(lockGraphNode)) {
                return;
            }
            PotentialDeadlockException potentialDeadlockException = this.disallowedPriorLocks.get(lockGraphNode);
            if (potentialDeadlockException != null) {
                PotentialDeadlockException potentialDeadlockException2 = new PotentialDeadlockException(lockGraphNode, this, potentialDeadlockException.getConflictingStackTrace());
                policy.handlePotentialDeadlock(potentialDeadlockException2);
                return;
            }
            Set<LockGraphNode> set = Sets.newIdentityHashSet();
            ExampleStackTrace exampleStackTrace = lockGraphNode.findPathTo(this, set);
            if (exampleStackTrace == null) {
                this.allowedPriorLocks.put(lockGraphNode, new ExampleStackTrace(lockGraphNode, this));
            } else {
                PotentialDeadlockException potentialDeadlockException3 = new PotentialDeadlockException(lockGraphNode, this, exampleStackTrace);
                this.disallowedPriorLocks.put(lockGraphNode, potentialDeadlockException3);
                policy.handlePotentialDeadlock(potentialDeadlockException3);
            }
        }

        @Nullable
        private ExampleStackTrace findPathTo(LockGraphNode lockGraphNode, Set<LockGraphNode> set) {
            if (!set.add(this)) {
                return null;
            }
            ExampleStackTrace exampleStackTrace = this.allowedPriorLocks.get(lockGraphNode);
            if (exampleStackTrace != null) {
                return exampleStackTrace;
            }
            for (Map.Entry<LockGraphNode, ExampleStackTrace> entry : this.allowedPriorLocks.entrySet()) {
                LockGraphNode lockGraphNode2 = entry.getKey();
                exampleStackTrace = lockGraphNode2.findPathTo(lockGraphNode, set);
                if (exampleStackTrace == null) continue;
                ExampleStackTrace exampleStackTrace2 = new ExampleStackTrace(lockGraphNode2, this);
                exampleStackTrace2.setStackTrace(entry.getValue().getStackTrace());
                exampleStackTrace2.initCause(exampleStackTrace);
                return exampleStackTrace2;
            }
            return null;
        }
    }

    private static interface CycleDetectingLock {
        public LockGraphNode getLockGraphNode();

        public boolean isAcquiredByCurrentThread();
    }

    @Beta
    public static final class PotentialDeadlockException
    extends ExampleStackTrace {
        private final ExampleStackTrace conflictingStackTrace;

        private PotentialDeadlockException(LockGraphNode lockGraphNode, LockGraphNode lockGraphNode2, ExampleStackTrace exampleStackTrace) {
            super(lockGraphNode, lockGraphNode2);
            this.conflictingStackTrace = exampleStackTrace;
            this.initCause(exampleStackTrace);
        }

        public ExampleStackTrace getConflictingStackTrace() {
            return this.conflictingStackTrace;
        }

        @Override
        public String getMessage() {
            StringBuilder stringBuilder = new StringBuilder(super.getMessage());
            for (Throwable throwable = this.conflictingStackTrace; throwable != null; throwable = throwable.getCause()) {
                stringBuilder.append(", ").append(throwable.getMessage());
            }
            return stringBuilder.toString();
        }
    }

    private static class ExampleStackTrace
    extends IllegalStateException {
        static final StackTraceElement[] EMPTY_STACK_TRACE = new StackTraceElement[0];
        static Set<String> EXCLUDED_CLASS_NAMES = ImmutableSet.of(CycleDetectingLockFactory.class.getName(), ExampleStackTrace.class.getName(), LockGraphNode.class.getName());

        ExampleStackTrace(LockGraphNode lockGraphNode, LockGraphNode lockGraphNode2) {
            super(lockGraphNode.getLockName() + " -> " + lockGraphNode2.getLockName());
            StackTraceElement[] stackTraceElementArray = this.getStackTrace();
            int n = stackTraceElementArray.length;
            for (int i = 0; i < n; ++i) {
                if (WithExplicitOrdering.class.getName().equals(stackTraceElementArray[i].getClassName())) {
                    this.setStackTrace(EMPTY_STACK_TRACE);
                    break;
                }
                if (EXCLUDED_CLASS_NAMES.contains(stackTraceElementArray[i].getClassName())) continue;
                this.setStackTrace(Arrays.copyOfRange(stackTraceElementArray, i, n));
                break;
            }
        }
    }

    @Beta
    public static final class WithExplicitOrdering<E extends Enum<E>>
    extends CycleDetectingLockFactory {
        private final Map<E, LockGraphNode> lockGraphNodes;

        @VisibleForTesting
        WithExplicitOrdering(Policy policy, Map<E, LockGraphNode> map) {
            super(policy);
            this.lockGraphNodes = map;
        }

        public ReentrantLock newReentrantLock(E e) {
            return this.newReentrantLock(e, false);
        }

        public ReentrantLock newReentrantLock(E e, boolean bl) {
            return this.policy == Policies.DISABLED ? new ReentrantLock(bl) : new CycleDetectingReentrantLock(this.lockGraphNodes.get(e), bl);
        }

        public ReentrantReadWriteLock newReentrantReadWriteLock(E e) {
            return this.newReentrantReadWriteLock(e, false);
        }

        public ReentrantReadWriteLock newReentrantReadWriteLock(E e, boolean bl) {
            return this.policy == Policies.DISABLED ? new ReentrantReadWriteLock(bl) : new CycleDetectingReentrantReadWriteLock(this.lockGraphNodes.get(e), bl);
        }
    }

    @Beta
    public static enum Policies implements Policy
    {
        THROW{

            @Override
            public void handlePotentialDeadlock(PotentialDeadlockException potentialDeadlockException) {
                throw potentialDeadlockException;
            }
        }
        ,
        WARN{

            @Override
            public void handlePotentialDeadlock(PotentialDeadlockException potentialDeadlockException) {
                logger.log(Level.SEVERE, "Detected potential deadlock", potentialDeadlockException);
            }
        }
        ,
        DISABLED{

            @Override
            public void handlePotentialDeadlock(PotentialDeadlockException potentialDeadlockException) {
            }
        };

    }

    @Beta
    @ThreadSafe
    public static interface Policy {
        public void handlePotentialDeadlock(PotentialDeadlockException var1);
    }
}

