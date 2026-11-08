/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.ints;

import com.viaversion.viaversion.libs.fastutil.ints.AbstractIntCollection;
import com.viaversion.viaversion.libs.fastutil.ints.IntArrays;
import com.viaversion.viaversion.libs.fastutil.ints.IntBidirectionalIterator;
import com.viaversion.viaversion.libs.fastutil.ints.IntCollection;
import com.viaversion.viaversion.libs.fastutil.ints.IntCollections;
import com.viaversion.viaversion.libs.fastutil.ints.IntIterable;
import com.viaversion.viaversion.libs.fastutil.ints.IntIterator;
import com.viaversion.viaversion.libs.fastutil.ints.IntIterators;
import com.viaversion.viaversion.libs.fastutil.ints.IntSpliterator;
import com.viaversion.viaversion.libs.fastutil.ints.IntSpliterators;
import com.viaversion.viaversion.libs.fastutil.objects.ObjectArrays;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class IntCollections {
    private IntCollections() {
    }

    public static IntCollection synchronize(IntCollection intCollection) {
        return new SynchronizedCollection(intCollection);
    }

    public static IntCollection synchronize(IntCollection intCollection, Object object) {
        return new SynchronizedCollection(intCollection, object);
    }

    public static IntCollection unmodifiable(IntCollection intCollection) {
        return new UnmodifiableCollection(intCollection);
    }

    public static IntCollection asCollection(IntIterable intIterable) {
        if (intIterable instanceof IntCollection) {
            return (IntCollection)intIterable;
        }
        return new IterableCollection(intIterable);
    }

    public static class IterableCollection
    extends AbstractIntCollection
    implements Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final IntIterable iterable;

        protected IterableCollection(IntIterable intIterable) {
            this.iterable = Objects.requireNonNull(intIterable);
        }

        @Override
        public int size() {
            long l = this.iterable.spliterator().getExactSizeIfKnown();
            if (l >= 0L) {
                return (int)Math.min(Integer.MAX_VALUE, l);
            }
            int n = 0;
            IntIterator intIterator = this.iterator();
            while (intIterator.hasNext()) {
                intIterator.nextInt();
                ++n;
            }
            return n;
        }

        @Override
        public boolean isEmpty() {
            return !this.iterable.iterator().hasNext();
        }

        @Override
        public IntIterator iterator() {
            return this.iterable.iterator();
        }

        @Override
        public IntSpliterator spliterator() {
            return this.iterable.spliterator();
        }

        @Override
        public IntIterator intIterator() {
            return this.iterable.intIterator();
        }

        @Override
        public IntSpliterator intSpliterator() {
            return this.iterable.intSpliterator();
        }
    }

    public static class SizeDecreasingSupplier<C extends IntCollection>
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
            return (C)((IntCollection)this.builder.apply(n));
        }
    }

    public static abstract class EmptyCollection
    extends AbstractIntCollection {
        protected EmptyCollection() {
        }

        @Override
        public boolean contains(int n) {
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
        public IntBidirectionalIterator iterator() {
            return IntIterators.EMPTY_ITERATOR;
        }

        @Override
        public IntSpliterator spliterator() {
            return IntSpliterators.EMPTY_SPLITERATOR;
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
        public void forEach(Consumer<? super Integer> consumer) {
        }

        @Override
        public boolean containsAll(Collection<?> collection) {
            return collection.isEmpty();
        }

        @Override
        public boolean addAll(Collection<? extends Integer> collection) {
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
        public boolean removeIf(Predicate<? super Integer> predicate) {
            Objects.requireNonNull(predicate);
            return false;
        }

        @Override
        public int[] toIntArray() {
            return IntArrays.EMPTY_ARRAY;
        }

        @Override
        @Deprecated
        public int[] toIntArray(int[] nArray) {
            return nArray;
        }

        @Override
        public void forEach(IntConsumer intConsumer) {
        }

        @Override
        public boolean containsAll(IntCollection intCollection) {
            return intCollection.isEmpty();
        }

        @Override
        public boolean addAll(IntCollection intCollection) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean removeAll(IntCollection intCollection) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean retainAll(IntCollection intCollection) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean removeIf(IntPredicate intPredicate) {
            Objects.requireNonNull(intPredicate);
            return false;
        }
    }

	static class SynchronizedCollection implements IntCollection, java.io.Serializable {
		private static final long serialVersionUID = -7046029254386353129L;
		protected final IntCollection collection;
		protected final Object sync;

		protected SynchronizedCollection(final IntCollection c, final Object sync) {
			this.collection = Objects.requireNonNull(c);
			this.sync = sync;
		}

		protected SynchronizedCollection(final IntCollection c) {
			this.collection = Objects.requireNonNull(c);
			this.sync = this;
		}

		@Override
		public boolean add(final int k) {
			synchronized (sync) {
				return collection.add(k);
			}
		}

		@Override
		public boolean contains(final int k) {
			synchronized (sync) {
				return collection.contains(k);
			}
		}

		@Override
		public boolean rem(final int k) {
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
		public int[] toIntArray() {
			synchronized (sync) {
				return collection.toIntArray();
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
		public int[] toIntArray(final int[] a) {
			return toArray(a);
		}

		@Override
		public int[] toArray(final int[] a) {
			synchronized (sync) {
				return collection.toArray(a);
			}
		}

		@Override
		public boolean addAll(final IntCollection c) {
			synchronized (sync) {
				return collection.addAll(c);
			}
		}

		@Override
		public boolean containsAll(final IntCollection c) {
			synchronized (sync) {
				return collection.containsAll(c);
			}
		}

		@Override
		public boolean removeAll(final IntCollection c) {
			synchronized (sync) {
				return collection.removeAll(c);
			}
		}

		@Override
		public boolean retainAll(final IntCollection c) {
			synchronized (sync) {
				return collection.retainAll(c);
			}
		}

		@Override
		@Deprecated
		public boolean add(final Integer k) {
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
		public IntIterator intIterator() {
			return collection.intIterator();
		}

		@Override
		public IntSpliterator intSpliterator() {
			return collection.intSpliterator();
		}

		@Override
		public java.util.stream.IntStream intStream() {
			return collection.intStream();
		}

		@Override
		public java.util.stream.IntStream intParallelStream() {
			return collection.intParallelStream();
		}

		@Override
		public <T> T[] toArray(final T[] a) {
			synchronized (sync) {
				return collection.toArray(a);
			}
		}

		@Override
		public IntIterator iterator() {
			return collection.iterator();
		}

		@Override
		public IntSpliterator spliterator() {
			return collection.spliterator();
		}

		@Deprecated
		@Override
		public java.util.stream.Stream<Integer> stream() {
			return collection.stream();
		}

		@Deprecated
		@Override
		public java.util.stream.Stream<Integer> parallelStream() {
			return collection.parallelStream();
		}

		@Override
		public void forEach(final java.util.function.IntConsumer action) {
			synchronized (sync) {
				collection.forEach(action);
			}
		}

		@Override
		public boolean addAll(final Collection<? extends Integer> c) {
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
		public boolean removeIf(final java.util.function.IntPredicate filter) {
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

	static class UnmodifiableCollection implements IntCollection, java.io.Serializable {
		private static final long serialVersionUID = -7046029254386353129L;
		protected final IntCollection collection;

		protected UnmodifiableCollection(final IntCollection c) {
			this.collection = Objects.requireNonNull(c);
		}

		@Override
		public boolean add(final int k) {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean rem(final int k) {
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
		public boolean contains(final int o) {
			return collection.contains(o);
		}

		@Override
		public IntIterator iterator() {
			return IntIterators.unmodifiable(collection.iterator());
		}

		@Override
		public IntSpliterator spliterator() {
			return collection.spliterator();
		}

		@Deprecated
		@Override
		public java.util.stream.Stream<Integer> stream() {
			return collection.stream();
		}

		@Deprecated
		@Override
		public java.util.stream.Stream<Integer> parallelStream() {
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
		public void forEach(final java.util.function.IntConsumer action) {
			collection.forEach(action);
		}

		@Override
		public boolean containsAll(Collection<?> c) {
			return collection.containsAll(c);
		}

		@Override
		public boolean addAll(Collection<? extends Integer> c) {
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
		public boolean removeIf(final java.util.function.IntPredicate filter) {
			throw new UnsupportedOperationException();
		}

		@Override
		@Deprecated
		public boolean add(final Integer k) {
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
		public int[] toIntArray() {
			return collection.toIntArray();
		}

		
		@Deprecated
		@Override
		public int[] toIntArray(final int[] a) {
			return toArray(a);
		}

		@Override
		public int[] toArray(final int[] a) {
			return collection.toArray(a);
		}

		@Override
		public boolean containsAll(IntCollection c) {
			return collection.containsAll(c);
		}

		@Override
		public boolean addAll(IntCollection c) {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean removeAll(IntCollection c) {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean retainAll(IntCollection c) {
			throw new UnsupportedOperationException();
		}

		@Override
		public IntIterator intIterator() {
			return collection.intIterator();
		}

		@Override
		public IntSpliterator intSpliterator() {
			return collection.intSpliterator();
		}

		@Override
		public java.util.stream.IntStream intStream() {
			return collection.intStream();
		}

		@Override
		public java.util.stream.IntStream intParallelStream() {
			return collection.intParallelStream();
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

