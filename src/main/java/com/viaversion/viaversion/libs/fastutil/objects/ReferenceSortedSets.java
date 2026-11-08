/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.objects;

import com.viaversion.viaversion.libs.fastutil.objects.ObjectBidirectionalIterator;
import com.viaversion.viaversion.libs.fastutil.objects.ObjectIterators;
import com.viaversion.viaversion.libs.fastutil.objects.ObjectSpliterator;
import com.viaversion.viaversion.libs.fastutil.objects.ObjectSpliterators;
import com.viaversion.viaversion.libs.fastutil.objects.ReferenceSets;
import com.viaversion.viaversion.libs.fastutil.objects.ReferenceSortedSet;
import com.viaversion.viaversion.libs.fastutil.objects.ReferenceSortedSets;
import java.io.Serializable;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class ReferenceSortedSets {
    public static final EmptySet EMPTY_SET = new EmptySet();

    private ReferenceSortedSets() {
    }

    public static <K> ReferenceSortedSet<K> emptySet() {
        return EMPTY_SET;
    }

    public static <K> ReferenceSortedSet<K> singleton(K k) {
        return new Singleton<K>(k);
    }

    public static <K> ReferenceSortedSet<K> singleton(K k, Comparator<? super K> comparator) {
        return new Singleton<K>(k, comparator);
    }

    public static <K> ReferenceSortedSet<K> synchronize(ReferenceSortedSet<K> referenceSortedSet) {
        return new SynchronizedSortedSet(referenceSortedSet);
    }

    public static <K> ReferenceSortedSet<K> synchronize(ReferenceSortedSet<K> referenceSortedSet, Object object) {
        return new SynchronizedSortedSet(referenceSortedSet, object);
    }

    public static <K> ReferenceSortedSet<K> unmodifiable(ReferenceSortedSet<K> referenceSortedSet) {
        return new UnmodifiableSortedSet(referenceSortedSet);
    }

    public static class EmptySet<K>
    extends ReferenceSets.EmptySet<K>
    implements ReferenceSortedSet<K>,
    Serializable,
    Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySet() {
        }

        @Override
        public ObjectBidirectionalIterator<K> iterator(K k) {
            return ObjectIterators.EMPTY_ITERATOR;
        }

        @Override
        public ReferenceSortedSet<K> subSet(K k, K k2) {
            return EMPTY_SET;
        }

        @Override
        public ReferenceSortedSet<K> headSet(K k) {
            return EMPTY_SET;
        }

        @Override
        public ReferenceSortedSet<K> tailSet(K k) {
            return EMPTY_SET;
        }

        @Override
        public K first() {
            throw new NoSuchElementException();
        }

        @Override
        public K last() {
            throw new NoSuchElementException();
        }

        @Override
        public Comparator<? super K> comparator() {
            return null;
        }

        @Override
        public Object clone() {
            return EMPTY_SET;
        }

        private Object readResolve() {
            return EMPTY_SET;
        }
    }

    public static class Singleton<K>
    extends ReferenceSets.Singleton<K>
    implements ReferenceSortedSet<K>,
    Serializable,
    Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        final Comparator<? super K> comparator;

        protected Singleton(K k, Comparator<? super K> comparator) {
            super(k);
            this.comparator = comparator;
        }

        Singleton(K k) {
            this(k, null);
        }

        final int compare(K k, K k2) {
            return this.comparator == null ? ((Comparable)k).compareTo(k2) : this.comparator.compare(k, k2);
        }

        @Override
        public ObjectBidirectionalIterator<K> iterator(K k) {
            ObjectBidirectionalIterator objectBidirectionalIterator = this.iterator();
            if (this.compare(this.element, k) <= 0) {
                objectBidirectionalIterator.next();
            }
            return objectBidirectionalIterator;
        }

        @Override
        public Comparator<? super K> comparator() {
            return this.comparator;
        }

        @Override
        public ObjectSpliterator<K> spliterator() {
            return ObjectSpliterators.singleton(this.element, this.comparator);
        }

        @Override
        public ReferenceSortedSet<K> subSet(K k, K k2) {
            if (this.compare(k, this.element) <= 0 && this.compare(this.element, k2) < 0) {
                return this;
            }
            return EMPTY_SET;
        }

        @Override
        public ReferenceSortedSet<K> headSet(K k) {
            if (this.compare(this.element, k) < 0) {
                return this;
            }
            return EMPTY_SET;
        }

        @Override
        public ReferenceSortedSet<K> tailSet(K k) {
            if (this.compare(k, this.element) <= 0) {
                return this;
            }
            return EMPTY_SET;
        }

        @Override
        public K first() {
            return (K)this.element;
        }

        @Override
        public K last() {
            return (K)this.element;
        }
    }

	public static class SynchronizedSortedSet<K> extends ReferenceSets.SynchronizedSet<K> implements ReferenceSortedSet<K>, java.io.Serializable {
		private static final long serialVersionUID = -7046029254386353129L;
		protected final ReferenceSortedSet<K> sortedSet;

		protected SynchronizedSortedSet(final ReferenceSortedSet<K> s, final Object sync) {
			super(s, sync);
			sortedSet = s;
		}

		protected SynchronizedSortedSet(final ReferenceSortedSet<K> s) {
			super(s);
			sortedSet = s;
		}

		@Override
		public Comparator<? super K> comparator() {
			synchronized (sync) {
				return sortedSet.comparator();
			}
		}

		@Override
		public ReferenceSortedSet<K> subSet(final K from, final K to) {
			return new SynchronizedSortedSet<>(sortedSet.subSet(from, to), sync);
		}

		@Override
		public ReferenceSortedSet<K> headSet(final K to) {
			return new SynchronizedSortedSet<>(sortedSet.headSet(to), sync);
		}

		@Override
		public ReferenceSortedSet<K> tailSet(final K from) {
			return new SynchronizedSortedSet<>(sortedSet.tailSet(from), sync);
		}

		@Override
		public ObjectBidirectionalIterator<K> iterator() {
			return sortedSet.iterator();
		}

		@Override
		public ObjectBidirectionalIterator<K> iterator(final K from) {
			return sortedSet.iterator(from);
		}

		@Override
		public K first() {
			synchronized (sync) {
				return sortedSet.first();
			}
		}

		@Override
		public K last() {
			synchronized (sync) {
				return sortedSet.last();
			}
		}
	}

	public static class UnmodifiableSortedSet<K> extends ReferenceSets.UnmodifiableSet<K> implements ReferenceSortedSet<K>, java.io.Serializable {
		private static final long serialVersionUID = -7046029254386353129L;
		protected final ReferenceSortedSet<K> sortedSet;

		protected UnmodifiableSortedSet(final ReferenceSortedSet<K> s) {
			super(s);
			sortedSet = s;
		}

		@Override
		public Comparator<? super K> comparator() {
			return sortedSet.comparator();
		}

		@Override
		public ReferenceSortedSet<K> subSet(final K from, final K to) {
			return new UnmodifiableSortedSet<>(sortedSet.subSet(from, to));
		}

		@Override
		public ReferenceSortedSet<K> headSet(final K to) {
			return new UnmodifiableSortedSet<>(sortedSet.headSet(to));
		}

		@Override
		public ReferenceSortedSet<K> tailSet(final K from) {
			return new UnmodifiableSortedSet<>(sortedSet.tailSet(from));
		}

		@Override
		public ObjectBidirectionalIterator<K> iterator() {
			return ObjectIterators.unmodifiable(sortedSet.iterator());
		}

		@Override
		public ObjectBidirectionalIterator<K> iterator(final K from) {
			return ObjectIterators.unmodifiable(sortedSet.iterator(from));
		}

		@Override
		public K first() {
			return sortedSet.first();
		}

		@Override
		public K last() {
			return sortedSet.last();
		}
	}
}

