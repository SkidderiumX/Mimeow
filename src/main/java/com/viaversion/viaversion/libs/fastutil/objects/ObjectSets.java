/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.objects;

import com.viaversion.viaversion.libs.fastutil.objects.AbstractObjectSet;
import com.viaversion.viaversion.libs.fastutil.objects.ObjectArraySet;
import com.viaversion.viaversion.libs.fastutil.objects.ObjectArrays;
import com.viaversion.viaversion.libs.fastutil.objects.ObjectCollections;
import com.viaversion.viaversion.libs.fastutil.objects.ObjectIterators;
import com.viaversion.viaversion.libs.fastutil.objects.ObjectListIterator;
import com.viaversion.viaversion.libs.fastutil.objects.ObjectSet;
import com.viaversion.viaversion.libs.fastutil.objects.ObjectSets;
import com.viaversion.viaversion.libs.fastutil.objects.ObjectSpliterator;
import com.viaversion.viaversion.libs.fastutil.objects.ObjectSpliterators;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ObjectSets {
    static final int ARRAY_SET_CUTOFF = 4;
    public static final EmptySet EMPTY_SET = new EmptySet();
    static final ObjectSet UNMODIFIABLE_EMPTY_SET = ObjectSets.unmodifiable(new ObjectArraySet(ObjectArrays.EMPTY_ARRAY));

    private ObjectSets() {
    }

    public static <K> ObjectSet<K> emptySet() {
        return EMPTY_SET;
    }

    public static <K> ObjectSet<K> singleton(K k) {
        return new Singleton<K>(k);
    }

    public static <K> ObjectSet<K> synchronize(ObjectSet<K> objectSet) {
        return new SynchronizedSet(objectSet);
    }

    public static <K> ObjectSet<K> synchronize(ObjectSet<K> objectSet, Object object) {
        return new SynchronizedSet(objectSet, object);
    }

    public static <K> ObjectSet<K> unmodifiable(ObjectSet<? extends K> objectSet) {
        return new UnmodifiableSet(objectSet);
    }

    public static class EmptySet<K>
    extends ObjectCollections.EmptyCollection<K>
    implements ObjectSet<K>,
    Serializable,
    Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySet() {
        }

        @Override
        public boolean remove(Object object) {
            throw new UnsupportedOperationException();
        }

        public Object clone() {
            return EMPTY_SET;
        }

        @Override
        public boolean equals(Object object) {
            return object instanceof Set && ((Set)object).isEmpty();
        }

        private Object readResolve() {
            return EMPTY_SET;
        }
    }

    public static class Singleton<K>
    extends AbstractObjectSet<K>
    implements Serializable,
    Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final K element;

        protected Singleton(K k) {
            this.element = k;
        }

        @Override
        public boolean contains(Object object) {
            return Objects.equals(object, this.element);
        }

        @Override
        public boolean remove(Object object) {
            throw new UnsupportedOperationException();
        }

        @Override
        public ObjectListIterator<K> iterator() {
            return ObjectIterators.singleton(this.element);
        }

        @Override
        public ObjectSpliterator<K> spliterator() {
            return ObjectSpliterators.singleton(this.element);
        }

        @Override
        public int size() {
            return 1;
        }

        @Override
        public Object[] toArray() {
            return new Object[]{this.element};
        }

        @Override
        public void forEach(Consumer<? super K> consumer) {
            consumer.accept(this.element);
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
            throw new UnsupportedOperationException();
        }

        public Object clone() {
            return this;
        }
    }

	public static class SynchronizedSet<K> extends ObjectCollections.SynchronizedCollection<K> implements ObjectSet<K>, java.io.Serializable {
		private static final long serialVersionUID = -7046029254386353129L;

		protected SynchronizedSet(final ObjectSet<K> s, final Object sync) {
			super(s, sync);
		}

		protected SynchronizedSet(final ObjectSet<K> s) {
			super(s);
		}

		@Override
		public boolean remove(final Object k) {
			synchronized (sync) {
				return collection.remove(k);
			}
		}
	}

	public static class UnmodifiableSet<K> extends ObjectCollections.UnmodifiableCollection<K> implements ObjectSet<K>, java.io.Serializable {
		private static final long serialVersionUID = -7046029254386353129L;

		protected UnmodifiableSet(final ObjectSet<? extends K> s) {
			super(s);
		}

		@Override
		public boolean remove(final Object k) {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean equals(final Object o) {
			if (o == this) return true;
			return collection.equals(o);
		}

		@Override
		public int hashCode() {
			return collection.hashCode();
		}
	}
}

