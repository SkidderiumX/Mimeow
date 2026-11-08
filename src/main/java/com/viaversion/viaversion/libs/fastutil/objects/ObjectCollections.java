/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.objects;

import com.viaversion.viaversion.libs.fastutil.objects.AbstractObjectCollection;
import com.viaversion.viaversion.libs.fastutil.objects.ObjectArrays;
import com.viaversion.viaversion.libs.fastutil.objects.ObjectBidirectionalIterator;
import com.viaversion.viaversion.libs.fastutil.objects.ObjectCollection;
import com.viaversion.viaversion.libs.fastutil.objects.ObjectCollections;
import com.viaversion.viaversion.libs.fastutil.objects.ObjectIterable;
import com.viaversion.viaversion.libs.fastutil.objects.ObjectIterator;
import com.viaversion.viaversion.libs.fastutil.objects.ObjectIterators;
import com.viaversion.viaversion.libs.fastutil.objects.ObjectSpliterator;
import com.viaversion.viaversion.libs.fastutil.objects.ObjectSpliterators;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ObjectCollections {
    private ObjectCollections() {
    }

    public static <K> ObjectCollection<K> synchronize(ObjectCollection<K> objectCollection) {
        return new SynchronizedCollection(objectCollection);
    }

    public static <K> ObjectCollection<K> synchronize(ObjectCollection<K> objectCollection, Object object) {
        return new SynchronizedCollection(objectCollection, object);
    }

    public static <K> ObjectCollection<K> unmodifiable(ObjectCollection<? extends K> objectCollection) {
        return new UnmodifiableCollection(objectCollection);
    }

    public static <K> ObjectCollection<K> asCollection(ObjectIterable<K> objectIterable) {
        if (objectIterable instanceof ObjectCollection) {
            return (ObjectCollection)objectIterable;
        }
        return new IterableCollection<K>(objectIterable);
    }

    public static class IterableCollection<K>
    extends AbstractObjectCollection<K>
    implements Serializable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final ObjectIterable<K> iterable;

        protected IterableCollection(ObjectIterable<K> objectIterable) {
            this.iterable = Objects.requireNonNull(objectIterable);
        }

        @Override
        public int size() {
            long l = this.iterable.spliterator().getExactSizeIfKnown();
            if (l >= 0L) {
                return (int)Math.min(Integer.MAX_VALUE, l);
            }
            int n = 0;
            Iterator iterator2 = this.iterator();
            while (iterator2.hasNext()) {
                iterator2.next();
                ++n;
            }
            return n;
        }

        @Override
        public boolean isEmpty() {
            return !this.iterable.iterator().hasNext();
        }

        @Override
        public ObjectIterator<K> iterator() {
            return this.iterable.iterator();
        }

        @Override
        public ObjectSpliterator<K> spliterator() {
            return this.iterable.spliterator();
        }
    }

    public static class SizeDecreasingSupplier<K, C extends ObjectCollection<K>>
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
            return (C)((ObjectCollection)this.builder.apply(n));
        }
    }

    public static abstract class EmptyCollection<K>
    extends AbstractObjectCollection<K> {
        protected EmptyCollection() {
        }

        @Override
        public boolean contains(Object object) {
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
        public ObjectBidirectionalIterator<K> iterator() {
            return ObjectIterators.EMPTY_ITERATOR;
        }

        @Override
        public ObjectSpliterator<K> spliterator() {
            return ObjectSpliterators.EMPTY_SPLITERATOR;
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
        public void forEach(Consumer<? super K> consumer) {
        }

        @Override
        public boolean containsAll(Collection<?> collection) {
            return collection.isEmpty();
        }

        @Override
        public boolean addAll(Collection<? extends K> collection) {
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
        public boolean removeIf(Predicate<? super K> predicate) {
            Objects.requireNonNull(predicate);
            return false;
        }
    }

	static class SynchronizedCollection<K> implements ObjectCollection<K>, java.io.Serializable {
		private static final long serialVersionUID = -7046029254386353129L;
		protected final ObjectCollection<K> collection;
		protected final Object sync;

		protected SynchronizedCollection(final ObjectCollection<K> c, final Object sync) {
			this.collection = Objects.requireNonNull(c);
			this.sync = sync;
		}

		protected SynchronizedCollection(final ObjectCollection<K> c) {
			this.collection = Objects.requireNonNull(c);
			this.sync = this;
		}

		@Override
		public boolean add(final K k) {
			synchronized (sync) {
				return collection.add(k);
			}
		}

		@Override
		public boolean contains(final Object k) {
			synchronized (sync) {
				return collection.contains(k);
			}
		}

		@Override
		public boolean remove(final Object k) {
			synchronized (sync) {
				return collection.remove(k);
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
		public Object[] toArray() {
			synchronized (sync) {
				return collection.toArray();
			}
		}

		@Override
		public <T> T[] toArray(final T[] a) {
			synchronized (sync) {
				return collection.toArray(a);
			}
		}

		@Override
		public ObjectIterator<K> iterator() {
			return collection.iterator();
		}

		@Override
		public ObjectSpliterator<K> spliterator() {
			return collection.spliterator();
		}

		@Override
		public java.util.stream.Stream<K> stream() {
			return collection.stream();
		}

		@Override
		public java.util.stream.Stream<K> parallelStream() {
			return collection.parallelStream();
		}

		@Override
		public void forEach(final Consumer<? super K> action) {
			synchronized (sync) {
				collection.forEach(action);
			}
		}

		@Override
		public boolean addAll(final Collection<? extends K> c) {
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
		public boolean removeIf(final Predicate<? super K> filter) {
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

	static class UnmodifiableCollection<K> implements ObjectCollection<K>, java.io.Serializable {
		private static final long serialVersionUID = -7046029254386353129L;
		protected final ObjectCollection<? extends K> collection;

		protected UnmodifiableCollection(final ObjectCollection<? extends K> c) {
			this.collection = Objects.requireNonNull(c);
		}

		@Override
		public boolean add(final K k) {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean remove(final Object k) {
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
		public boolean contains(final Object o) {
			return collection.contains(o);
		}

		@Override
		public ObjectIterator<K> iterator() {
			return ObjectIterators.unmodifiable(collection.iterator());
		}

		@Override
		@SuppressWarnings("unchecked")
		public ObjectSpliterator<K> spliterator() {
			return (ObjectSpliterator<K>)collection.spliterator();
		}

		@Override
		@SuppressWarnings("unchecked")
		public java.util.stream.Stream<K> stream() {
			return (java.util.stream.Stream<K>)collection.stream();
		}

		@Override
		@SuppressWarnings("unchecked")
		public java.util.stream.Stream<K> parallelStream() {
			return (java.util.stream.Stream<K>)collection.parallelStream();
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
		public void forEach(final Consumer<? super K> action) {
			collection.forEach(action);
		}

		@Override
		public boolean containsAll(Collection<?> c) {
			return collection.containsAll(c);
		}

		@Override
		public boolean addAll(Collection<? extends K> c) {
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
		public boolean removeIf(final Predicate<? super K> filter) {
			throw new UnsupportedOperationException();
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

