/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.longs;

import com.viaversion.viaversion.libs.fastutil.longs.LongBidirectionalIterator;
import com.viaversion.viaversion.libs.fastutil.longs.LongComparator;
import com.viaversion.viaversion.libs.fastutil.longs.LongIterators;
import com.viaversion.viaversion.libs.fastutil.longs.LongSets;
import com.viaversion.viaversion.libs.fastutil.longs.LongSortedSet;
import com.viaversion.viaversion.libs.fastutil.longs.LongSortedSets;
import com.viaversion.viaversion.libs.fastutil.longs.LongSpliterator;
import com.viaversion.viaversion.libs.fastutil.longs.LongSpliterators;
import java.io.Serializable;
import java.util.NoSuchElementException;

public class LongSortedSets {
    public static final EmptySet EMPTY_SET = new EmptySet();

    private LongSortedSets() {
    }

    public static LongSortedSet singleton(long l) {
        return new Singleton(l);
    }

    public static LongSortedSet singleton(long l, LongComparator longComparator) {
        return new Singleton(l, longComparator);
    }

    public static LongSortedSet singleton(Object object) {
        return new Singleton((Long)object);
    }

    public static LongSortedSet singleton(Object object, LongComparator longComparator) {
        return new Singleton((Long)object, longComparator);
    }

    public static LongSortedSet synchronize(LongSortedSet longSortedSet) {
        return new SynchronizedSortedSet(longSortedSet);
    }

    public static LongSortedSet synchronize(LongSortedSet longSortedSet, Object object) {
        return new SynchronizedSortedSet(longSortedSet, object);
    }

    public static LongSortedSet unmodifiable(LongSortedSet longSortedSet) {
        return new UnmodifiableSortedSet(longSortedSet);
    }

    public static class Singleton
    extends LongSets.Singleton
    implements LongSortedSet,
    Serializable,
    Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        final LongComparator comparator;

        protected Singleton(long l, LongComparator longComparator) {
            super(l);
            this.comparator = longComparator;
        }

        Singleton(long l) {
            this(l, null);
        }

        final int compare(long l, long l2) {
            return this.comparator == null ? Long.compare(l, l2) : this.comparator.compare(l, l2);
        }

        @Override
        public LongBidirectionalIterator iterator(long l) {
            LongBidirectionalIterator longBidirectionalIterator = this.iterator();
            if (this.compare(this.element, l) <= 0) {
                longBidirectionalIterator.nextLong();
            }
            return longBidirectionalIterator;
        }

        @Override
        public LongComparator comparator() {
            return this.comparator;
        }

        @Override
        public LongSpliterator spliterator() {
            return LongSpliterators.singleton(this.element, this.comparator);
        }

        @Override
        public LongSortedSet subSet(long l, long l2) {
            if (this.compare(l, this.element) <= 0 && this.compare(this.element, l2) < 0) {
                return this;
            }
            return EMPTY_SET;
        }

        @Override
        public LongSortedSet headSet(long l) {
            if (this.compare(this.element, l) < 0) {
                return this;
            }
            return EMPTY_SET;
        }

        @Override
        public LongSortedSet tailSet(long l) {
            if (this.compare(l, this.element) <= 0) {
                return this;
            }
            return EMPTY_SET;
        }

        @Override
        public long firstLong() {
            return this.element;
        }

        @Override
        public long lastLong() {
            return this.element;
        }

        @Override
        @Deprecated
        public LongSortedSet subSet(Long l, Long l2) {
            return this.subSet((long)l, (long)l2);
        }

        @Override
        @Deprecated
        public LongSortedSet headSet(Long l) {
            return this.headSet((long)l);
        }

        @Override
        @Deprecated
        public LongSortedSet tailSet(Long l) {
            return this.tailSet((long)l);
        }

        @Override
        @Deprecated
        public Long first() {
            return this.element;
        }

        @Override
        @Deprecated
        public Long last() {
            return this.element;
        }
    }

    public static class EmptySet
    extends LongSets.EmptySet
    implements LongSortedSet,
    Serializable,
    Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySet() {
        }

        @Override
        public LongBidirectionalIterator iterator(long l) {
            return LongIterators.EMPTY_ITERATOR;
        }

        @Override
        public LongSortedSet subSet(long l, long l2) {
            return EMPTY_SET;
        }

        @Override
        public LongSortedSet headSet(long l) {
            return EMPTY_SET;
        }

        @Override
        public LongSortedSet tailSet(long l) {
            return EMPTY_SET;
        }

        @Override
        public long firstLong() {
            throw new NoSuchElementException();
        }

        @Override
        public long lastLong() {
            throw new NoSuchElementException();
        }

        @Override
        public LongComparator comparator() {
            return null;
        }

        @Override
        @Deprecated
        public LongSortedSet subSet(Long l, Long l2) {
            return EMPTY_SET;
        }

        @Override
        @Deprecated
        public LongSortedSet headSet(Long l) {
            return EMPTY_SET;
        }

        @Override
        @Deprecated
        public LongSortedSet tailSet(Long l) {
            return EMPTY_SET;
        }

        @Override
        @Deprecated
        public Long first() {
            throw new NoSuchElementException();
        }

        @Override
        @Deprecated
        public Long last() {
            throw new NoSuchElementException();
        }

        @Override
        public Object clone() {
            return EMPTY_SET;
        }

        private Object readResolve() {
            return EMPTY_SET;
        }
    }

	public static class SynchronizedSortedSet extends LongSets.SynchronizedSet implements LongSortedSet, java.io.Serializable {
		private static final long serialVersionUID = -7046029254386353129L;
		protected final LongSortedSet sortedSet;

		protected SynchronizedSortedSet(final LongSortedSet s, final Object sync) {
			super(s, sync);
			sortedSet = s;
		}

		protected SynchronizedSortedSet(final LongSortedSet s) {
			super(s);
			sortedSet = s;
		}

		@Override
		public LongComparator comparator() {
			synchronized (sync) {
				return sortedSet.comparator();
			}
		}

		@Override
		public LongSortedSet subSet(final long from, final long to) {
			return new SynchronizedSortedSet(sortedSet.subSet(from, to), sync);
		}

		@Override
		public LongSortedSet headSet(final long to) {
			return new SynchronizedSortedSet(sortedSet.headSet(to), sync);
		}

		@Override
		public LongSortedSet tailSet(final long from) {
			return new SynchronizedSortedSet(sortedSet.tailSet(from), sync);
		}

		@Override
		public LongBidirectionalIterator iterator() {
			return sortedSet.iterator();
		}

		@Override
		public LongBidirectionalIterator iterator(final long from) {
			return sortedSet.iterator(from);
		}

		@Override
		public long firstLong() {
			synchronized (sync) {
				return sortedSet.firstLong();
			}
		}

		@Override
		public long lastLong() {
			synchronized (sync) {
				return sortedSet.lastLong();
			}
		}

		
		@Deprecated
		@Override
		public Long first() {
			synchronized (sync) {
				return sortedSet.first();
			}
		}

		
		@Deprecated
		@Override
		public Long last() {
			synchronized (sync) {
				return sortedSet.last();
			}
		}

		
		@Deprecated
		@Override
		public LongSortedSet subSet(final Long from, final Long to) {
			return new SynchronizedSortedSet(sortedSet.subSet(from, to), sync);
		}

		
		@Deprecated
		@Override
		public LongSortedSet headSet(final Long to) {
			return new SynchronizedSortedSet(sortedSet.headSet(to), sync);
		}

		
		@Deprecated
		@Override
		public LongSortedSet tailSet(final Long from) {
			return new SynchronizedSortedSet(sortedSet.tailSet(from), sync);
		}
	}

	public static class UnmodifiableSortedSet extends LongSets.UnmodifiableSet implements LongSortedSet, java.io.Serializable {
		private static final long serialVersionUID = -7046029254386353129L;
		protected final LongSortedSet sortedSet;

		protected UnmodifiableSortedSet(final LongSortedSet s) {
			super(s);
			sortedSet = s;
		}

		@Override
		public LongComparator comparator() {
			return sortedSet.comparator();
		}

		@Override
		public LongSortedSet subSet(final long from, final long to) {
			return new UnmodifiableSortedSet(sortedSet.subSet(from, to));
		}

		@Override
		public LongSortedSet headSet(final long to) {
			return new UnmodifiableSortedSet(sortedSet.headSet(to));
		}

		@Override
		public LongSortedSet tailSet(final long from) {
			return new UnmodifiableSortedSet(sortedSet.tailSet(from));
		}

		@Override
		public LongBidirectionalIterator iterator() {
			return LongIterators.unmodifiable(sortedSet.iterator());
		}

		@Override
		public LongBidirectionalIterator iterator(final long from) {
			return LongIterators.unmodifiable(sortedSet.iterator(from));
		}

		@Override
		public long firstLong() {
			return sortedSet.firstLong();
		}

		@Override
		public long lastLong() {
			return sortedSet.lastLong();
		}

		
		@Deprecated
		@Override
		public Long first() {
			return sortedSet.first();
		}

		
		@Deprecated
		@Override
		public Long last() {
			return sortedSet.last();
		}

		
		@Deprecated
		@Override
		public LongSortedSet subSet(final Long from, final Long to) {
			return new UnmodifiableSortedSet(sortedSet.subSet(from, to));
		}

		
		@Deprecated
		@Override
		public LongSortedSet headSet(final Long to) {
			return new UnmodifiableSortedSet(sortedSet.headSet(to));
		}

		
		@Deprecated
		@Override
		public LongSortedSet tailSet(final Long from) {
			return new UnmodifiableSortedSet(sortedSet.tailSet(from));
		}
	}
}

