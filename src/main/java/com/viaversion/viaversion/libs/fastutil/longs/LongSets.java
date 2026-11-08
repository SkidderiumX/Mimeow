/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.longs;

import com.viaversion.viaversion.libs.fastutil.longs.AbstractLongSet;
import com.viaversion.viaversion.libs.fastutil.longs.LongArraySet;
import com.viaversion.viaversion.libs.fastutil.longs.LongArrays;
import com.viaversion.viaversion.libs.fastutil.longs.LongCollection;
import com.viaversion.viaversion.libs.fastutil.longs.LongCollections;
import com.viaversion.viaversion.libs.fastutil.longs.LongIterator;
import com.viaversion.viaversion.libs.fastutil.longs.LongIterators;
import com.viaversion.viaversion.libs.fastutil.longs.LongListIterator;
import com.viaversion.viaversion.libs.fastutil.longs.LongSet;
import com.viaversion.viaversion.libs.fastutil.longs.LongSets;
import com.viaversion.viaversion.libs.fastutil.longs.LongSpliterator;
import com.viaversion.viaversion.libs.fastutil.longs.LongSpliterators;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.LongConsumer;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

public class LongSets {
    static final int ARRAY_SET_CUTOFF = 4;
    public static final EmptySet EMPTY_SET = new EmptySet();
    static final LongSet UNMODIFIABLE_EMPTY_SET = LongSets.unmodifiable(new LongArraySet(LongArrays.EMPTY_ARRAY));

    private LongSets() {
    }

    public static LongSet emptySet() {
        return EMPTY_SET;
    }

    public static LongSet singleton(long l) {
        return new Singleton(l);
    }

    public static LongSet singleton(Long l) {
        return new Singleton(l);
    }

    public static LongSet synchronize(LongSet longSet) {
        return new SynchronizedSet(longSet);
    }

    public static LongSet synchronize(LongSet longSet, Object object) {
        return new SynchronizedSet(longSet, object);
    }

    public static LongSet unmodifiable(LongSet longSet) {
        return new UnmodifiableSet(longSet);
    }

    public static LongSet fromTo(final long l, final long l2) {
        return new AbstractLongSet(){

            @Override
            public boolean contains(long l3) {
                return l3 >= l && l3 < l2;
            }

            @Override
            public LongIterator iterator() {
                return LongIterators.fromTo(l, l2);
            }

            @Override
            public int size() {
                long l3 = l2 - l;
                return l3 >= 0L && l3 <= Integer.MAX_VALUE ? (int)l3 : Integer.MAX_VALUE;
            }
        };
    }

    public static LongSet from(final long l) {
        return new AbstractLongSet(){

            @Override
            public boolean contains(long l2) {
                return l2 >= l;
            }

            @Override
            public LongIterator iterator() {
                return LongIterators.concat(LongIterators.fromTo(l, Long.MAX_VALUE), LongSets.singleton(Long.MAX_VALUE).iterator());
            }

            @Override
            public int size() {
                long l2 = Long.MAX_VALUE - l + 1L;
                return l2 >= 0L && l2 <= Integer.MAX_VALUE ? (int)l2 : Integer.MAX_VALUE;
            }
        };
    }

    public static LongSet m1d9a9f8780(final long l) {
        return new AbstractLongSet(){

            @Override
            public boolean contains(long l2) {
                return l2 < l;
            }

            @Override
            public LongIterator iterator() {
                return LongIterators.fromTo(Long.MIN_VALUE, l);
            }

            @Override
            public int size() {
                long l2 = l - Long.MIN_VALUE;
                return l2 >= 0L && l2 <= Integer.MAX_VALUE ? (int)l2 : Integer.MAX_VALUE;
            }
        };
    }

    public static class EmptySet
    extends LongCollections.EmptyCollection
    implements LongSet,
    Serializable,
    Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptySet() {
        }

        @Override
        public boolean remove(long l) {
            throw new UnsupportedOperationException();
        }

        public Object clone() {
            return EMPTY_SET;
        }

        @Override
        public boolean equals(Object object) {
            return object instanceof Set && ((Set)object).isEmpty();
        }

        @Override
        @Deprecated
        public boolean rem(long l) {
            return super.rem(l);
        }

        private Object readResolve() {
            return EMPTY_SET;
        }
    }

    public static class Singleton
    extends AbstractLongSet
    implements Serializable,
    Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        protected final long element;

        protected Singleton(long l) {
            this.element = l;
        }

        @Override
        public boolean contains(long l) {
            return l == this.element;
        }

        @Override
        public boolean remove(long l) {
            throw new UnsupportedOperationException();
        }

        @Override
        public LongListIterator iterator() {
            return LongIterators.singleton(this.element);
        }

        @Override
        public LongSpliterator spliterator() {
            return LongSpliterators.singleton(this.element);
        }

        @Override
        public int size() {
            return 1;
        }

        @Override
        public long[] toLongArray() {
            return new long[]{this.element};
        }

        @Override
        @Deprecated
        public void forEach(Consumer<? super Long> consumer) {
            consumer.accept((Long)this.element);
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
            throw new UnsupportedOperationException();
        }

        @Override
        public void forEach(LongConsumer longConsumer) {
            longConsumer.accept(this.element);
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
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public Object[] toArray() {
            return new Object[]{this.element};
        }

        public Object clone() {
            return this;
        }
    }

	public static class SynchronizedSet extends LongCollections.SynchronizedCollection implements LongSet, java.io.Serializable {
		private static final long serialVersionUID = -7046029254386353129L;

		protected SynchronizedSet(final LongSet s, final Object sync) {
			super(s, sync);
		}

		protected SynchronizedSet(final LongSet s) {
			super(s);
		}

		@Override
		public boolean remove(final long k) {
			synchronized (sync) {
				return collection.rem(k);
			}
		}

		@Deprecated
		@Override
		public boolean rem(final long k) {
			return super.rem(k);
		}
	}

	public static class UnmodifiableSet extends LongCollections.UnmodifiableCollection implements LongSet, java.io.Serializable {
		private static final long serialVersionUID = -7046029254386353129L;

		protected UnmodifiableSet(final LongSet s) {
			super(s);
		}

		@Override
		public boolean remove(final long k) {
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

		@Deprecated
		@Override
		public boolean rem(final long k) {
			return super.rem(k);
		}
	}
}

