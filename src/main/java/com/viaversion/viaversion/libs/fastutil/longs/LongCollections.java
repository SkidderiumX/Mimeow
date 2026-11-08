/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.longs;

import com.viaversion.viaversion.libs.fastutil.longs.AbstractLongCollection;
import com.viaversion.viaversion.libs.fastutil.longs.LongArrays;
import com.viaversion.viaversion.libs.fastutil.longs.LongBidirectionalIterator;
import com.viaversion.viaversion.libs.fastutil.longs.LongCollection;
import com.viaversion.viaversion.libs.fastutil.longs.LongCollections;
import com.viaversion.viaversion.libs.fastutil.longs.LongIterable;
import com.viaversion.viaversion.libs.fastutil.longs.LongIterator;
import com.viaversion.viaversion.libs.fastutil.longs.LongIterators;
import com.viaversion.viaversion.libs.fastutil.longs.LongSpliterator;
import com.viaversion.viaversion.libs.fastutil.longs.LongSpliterators;
import com.viaversion.viaversion.libs.fastutil.objects.ObjectArrays;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.LongConsumer;
import java.util.function.LongPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LongCollections {
    private LongCollections() {
    }

    public static LongCollection synchronize(LongCollection longCollection) {
        return new SynchronizedCollection(longCollection);
    }

    public static LongCollection synchronize(LongCollection longCollection, Object object) {
        return new SynchronizedCollection(longCollection, object);
    }

    public static LongCollection unmodifiable(LongCollection longCollection) {
        return new UnmodifiableCollection(longCollection);
    }

    public static LongCollection asCollection(LongIterable longIterable) {
        if (longIterable instanceof LongCollection) {
            return (LongCollection)longIterable;
        }
        return new IterableCollection(longIterable);
    }

    public static class IterableCollection
    extends AbstractLongCollection
    implements Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final LongIterable iterable;

        protected IterableCollection(LongIterable longIterable) {
            this.iterable = Objects.requireNonNull(longIterable);
        }

        @Override
        public int size() {
            long l = this.iterable.spliterator().getExactSizeIfKnown();
            if (l >= 0L) {
                return (int)Math.min(Integer.MAX_VALUE, l);
            }
            int n = 0;
            LongIterator longIterator = this.iterator();
            while (longIterator.hasNext()) {
                longIterator.nextLong();
                ++n;
            }
            return n;
        }

        @Override
        public boolean isEmpty() {
            return !this.iterable.iterator().hasNext();
        }

        @Override
        public LongIterator iterator() {
            return this.iterable.iterator();
        }

        @Override
        public LongSpliterator spliterator() {
            return this.iterable.spliterator();
        }

        @Override
        public LongIterator longIterator() {
            return this.iterable.longIterator();
        }

        @Override
        public LongSpliterator longSpliterator() {
            return this.iterable.longSpliterator();
        }
    }

    public static class SizeDecreasingSupplier<C extends LongCollection>
    implements Supplier<C> {
        static final int RECOMMENDED_MIN_SIZE = 8;
        final AtomicInteger suppliedCount = new AtomicInteger(0);
        final int expectedFinalSize;
        final IntFunction<C> builder;

        SizeDecreasingSupplier(int n, IntFunction<C> intFunction) {
            this.expectedFinalSize = n;
            this.builder = intFunction;
        }

        @Override
        public C get() {
            int n = 1 + (this.expectedFinalSize - 1) / this.suppliedCount.incrementAndGet();
            if (n < 0) {
                n = 8;
            }
            return (C)((LongCollection)this.builder.apply(n));
        }
    }

    public static abstract class EmptyCollection
    extends AbstractLongCollection {
        protected EmptyCollection() {
        }

        @Override
        public boolean contains(long l) {
            return false;
        }

        @Override
        public Object[] toArray() {
            return ObjectArrays.EMPTY_ARRAY;
        }

        @Override
        public <T> T[] toArray(T[] TArray) {
            if (TArray.length > 0) {
                TArray[0] = null;
            }
            return TArray;
        }

        @Override
        public LongBidirectionalIterator iterator() {
            return LongIterators.EMPTY_ITERATOR;
        }

        @Override
        public LongSpliterator spliterator() {
            return LongSpliterators.EMPTY_SPLITERATOR;
        }

        @Override
        public int size() {
            return 0;
        }

        @Override
        public void clear() {
        }

        @Override
        public int hashCode() {
            return 0;
        }

        @Override
        public boolean equals(Object object) {
            if (object == this) {
                return true;
            }
            if (!(object instanceof Collection)) {
                return false;
            }
            return ((Collection)object).isEmpty();
        }

        @Override
        @Deprecated
        public void forEach(Consumer<? super Long> consumer) {
        }

        @Override
        public boolean containsAll(Collection<?> collection) {
            return collection.isEmpty();
        }

        @Override
        public boolean addAll(Collection<? extends Long> collection) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public boolean removeIf(Predicate<? super Long> predicate) {
            Objects.requireNonNull(predicate);
            return false;
        }

        @Override
        public long[] toLongArray() {
            return LongArrays.EMPTY_ARRAY;
        }

        @Override
        @Deprecated
        public long[] toLongArray(long[] lArray) {
            return lArray;
        }

        @Override
        public void forEach(LongConsumer longConsumer) {
        }

        @Override
        public boolean containsAll(LongCollection longCollection) {
            return longCollection.isEmpty();
        }

        @Override
        public boolean addAll(LongCollection longCollection) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean removeAll(LongCollection longCollection) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean retainAll(LongCollection longCollection) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean removeIf(LongPredicate longPredicate) {
            Objects.requireNonNull(longPredicate);
            return false;
        }
    }

	static class SynchronizedCollection implements LongCollection, java.io.Serializable {
		private static final long serialVersionUID = -7046029254386353129L;
		protected final LongCollection collection;
		protected final Object sync;

		protected SynchronizedCollection(final LongCollection c, final Object sync) {
			this.collection = Objects.requireNonNull(c);
			this.sync = sync;
		}

		protected SynchronizedCollection(final LongCollection c) {
			this.collection = Objects.requireNonNull(c);
			this.sync = this;
		}

		@Override
		public boolean add(final long k) {
			synchronized (sync) {
				return collection.add(k);
			}
		}

		@Override
		public boolean contains(final long k) {
			synchronized (sync) {
				return collection.contains(k);
			}
		}

		@Override
		public boolean rem(final long k) {
			synchronized (sync) {
				return collection.rem(k);
			}
		}

		@Override
		public int size() {
			synchronized (sync) {
				return collection.size();
			}
		}

		@Override
		public boolean isEmpty() {
			synchronized (sync) {
				return collection.isEmpty();
			}
		}

		@Override
		public long[] toLongArray() {
			synchronized (sync) {
				return collection.toLongArray();
			}
		}

		@Override
		public Object[] toArray() {
			synchronized (sync) {
				return collection.toArray();
			}
		}

		
		@Deprecated
		@Override
		public long[] toLongArray(final long[] a) {
			return toArray(a);
		}

		@Override
		public long[] toArray(final long[] a) {
			synchronized (sync) {
				return collection.toArray(a);
			}
		}

		@Override
		public boolean addAll(final LongCollection c) {
			synchronized (sync) {
				return collection.addAll(c);
			}
		}

		@Override
		public boolean containsAll(final LongCollection c) {
			synchronized (sync) {
				return collection.containsAll(c);
			}
		}

		@Override
		public boolean removeAll(final LongCollection c) {
			synchronized (sync) {
				return collection.removeAll(c);
			}
		}

		@Override
		public boolean retainAll(final LongCollection c) {
			synchronized (sync) {
				return collection.retainAll(c);
			}
		}

		@Override
		@Deprecated
		public boolean add(final Long k) {
			synchronized (sync) {
				return collection.add(k);
			}
		}

		@Override
		@Deprecated
		public boolean contains(final Object k) {
			synchronized (sync) {
				return collection.contains(k);
			}
		}

		@Override
		@Deprecated
		public boolean remove(final Object k) {
			synchronized (sync) {
				return collection.remove(k);
			}
		}

		@Override
		public LongIterator longIterator() {
			return collection.longIterator();
		}

		@Override
		public LongSpliterator longSpliterator() {
			return collection.longSpliterator();
		}

		@Override
		public java.util.stream.LongStream longStream() {
			return collection.longStream();
		}

		@Override
		public java.util.stream.LongStream longParallelStream() {
			return collection.longParallelStream();
		}

		@Override
		public <T> T[] toArray(final T[] a) {
			synchronized (sync) {
				return collection.toArray(a);
			}
		}

		@Override
		public LongIterator iterator() {
			return collection.iterator();
		}

		@Override
		public LongSpliterator spliterator() {
			return collection.spliterator();
		}

		@Deprecated
		@Override
		public java.util.stream.Stream<Long> stream() {
			return collection.stream();
		}

		@Deprecated
		@Override
		public java.util.stream.Stream<Long> parallelStream() {
			return collection.parallelStream();
		}

		@Override
		public void forEach(final java.util.function.LongConsumer action) {
			synchronized (sync) {
				collection.forEach(action);
			}
		}

		@Override
		public boolean addAll(final Collection<? extends Long> c) {
			synchronized (sync) {
				return collection.addAll(c);
			}
		}

		@Override
		public boolean containsAll(final Collection<?> c) {
			synchronized (sync) {
				return collection.containsAll(c);
			}
		}

		@Override
		public boolean removeAll(final Collection<?> c) {
			synchronized (sync) {
				return collection.removeAll(c);
			}
		}

		@Override
		public boolean retainAll(final Collection<?> c) {
			synchronized (sync) {
				return collection.retainAll(c);
			}
		}

		@Override
		public boolean removeIf(final java.util.function.LongPredicate filter) {
			synchronized (sync) {
				return collection.removeIf(filter);
			}
		}

		@Override
		public void clear() {
			synchronized (sync) {
				collection.clear();
			}
		}

		@Override
		public String toString() {
			synchronized (sync) {
				return collection.toString();
			}
		}

		@Override
		public int hashCode() {
			synchronized (sync) {
				return collection.hashCode();
			}
		}

		@Override
		public boolean equals(final Object o) {
			if (o == this) return true;
			synchronized (sync) {
				return collection.equals(o);
			}
		}

		private void writeObject(java.io.ObjectOutputStream s) throws java.io.IOException {
			synchronized (sync) {
				s.defaultWriteObject();
			}
		}
	}

	static class UnmodifiableCollection implements LongCollection, java.io.Serializable {
		private static final long serialVersionUID = -7046029254386353129L;
		protected final LongCollection collection;

		protected UnmodifiableCollection(final LongCollection c) {
			this.collection = Objects.requireNonNull(c);
		}

		@Override
		public boolean add(final long k) {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean rem(final long k) {
			throw new UnsupportedOperationException();
		}

		@Override
		public int size() {
			return collection.size();
		}

		@Override
		public boolean isEmpty() {
			return collection.isEmpty();
		}

		@Override
		public boolean contains(final long o) {
			return collection.contains(o);
		}

		@Override
		public LongIterator iterator() {
			return LongIterators.unmodifiable(collection.iterator());
		}

		@Override
		public LongSpliterator spliterator() {
			return collection.spliterator();
		}

		@Deprecated
		@Override
		public java.util.stream.Stream<Long> stream() {
			return collection.stream();
		}

		@Deprecated
		@Override
		public java.util.stream.Stream<Long> parallelStream() {
			return collection.parallelStream();
		}

		@Override
		public void clear() {
			throw new UnsupportedOperationException();
		}

		@Override
		public <T> T[] toArray(final T[] a) {
			return collection.toArray(a);
		}

		@Override
		public Object[] toArray() {
			return collection.toArray();
		}

		@Override
		public void forEach(final java.util.function.LongConsumer action) {
			collection.forEach(action);
		}

		@Override
		public boolean containsAll(Collection<?> c) {
			return collection.containsAll(c);
		}

		@Override
		public boolean addAll(Collection<? extends Long> c) {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean removeAll(Collection<?> c) {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean retainAll(Collection<?> c) {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean removeIf(final java.util.function.LongPredicate filter) {
			throw new UnsupportedOperationException();
		}

		@Override
		@Deprecated
		public boolean add(final Long k) {
			throw new UnsupportedOperationException();
		}

		@Override
		@Deprecated
		public boolean contains(final Object k) {
			return collection.contains(k);
		}

		@Override
		@Deprecated
		public boolean remove(final Object k) {
			throw new UnsupportedOperationException();
		}

		@Override
		public long[] toLongArray() {
			return collection.toLongArray();
		}

		
		@Deprecated
		@Override
		public long[] toLongArray(final long[] a) {
			return toArray(a);
		}

		@Override
		public long[] toArray(final long[] a) {
			return collection.toArray(a);
		}

		@Override
		public boolean containsAll(LongCollection c) {
			return collection.containsAll(c);
		}

		@Override
		public boolean addAll(LongCollection c) {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean removeAll(LongCollection c) {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean retainAll(LongCollection c) {
			throw new UnsupportedOperationException();
		}

		@Override
		public LongIterator longIterator() {
			return collection.longIterator();
		}

		@Override
		public LongSpliterator longSpliterator() {
			return collection.longSpliterator();
		}

		@Override
		public java.util.stream.LongStream longStream() {
			return collection.longStream();
		}

		@Override
		public java.util.stream.LongStream longParallelStream() {
			return collection.longParallelStream();
		}

		@Override
		public String toString() {
			return collection.toString();
		}

		@Override
		public int hashCode() {
			return collection.hashCode();
		}

		@Override
		public boolean equals(final Object o) {
			if (o == this) return true;
			return collection.equals(o);
		}
	}
}

