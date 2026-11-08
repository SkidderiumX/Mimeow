/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.longs;

import com.viaversion.viaversion.libs.fastutil.longs.AbstractLongList;
import com.viaversion.viaversion.libs.fastutil.longs.LongCollection;
import com.viaversion.viaversion.libs.fastutil.longs.LongCollections;
import com.viaversion.viaversion.libs.fastutil.longs.LongComparator;
import com.viaversion.viaversion.libs.fastutil.longs.LongIterators;
import com.viaversion.viaversion.libs.fastutil.longs.LongList;
import com.viaversion.viaversion.libs.fastutil.longs.LongListIterator;
import com.viaversion.viaversion.libs.fastutil.longs.LongLists;
import com.viaversion.viaversion.libs.fastutil.longs.LongSpliterator;
import com.viaversion.viaversion.libs.fastutil.longs.LongSpliterators;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.RandomAccess;
import java.util.function.Consumer;
import java.util.function.LongConsumer;
import java.util.function.LongPredicate;
import java.util.function.LongUnaryOperator;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class LongLists {
    public static final EmptyList EMPTY_LIST = new EmptyList();

    private LongLists() {
    }

    public static LongList shuffle(LongList longList, Random random) {
        int n = longList.size();
        while (n-- != 0) {
            int n2 = random.nextInt(n + 1);
            long l = longList.getLong(n);
            longList.set(n, longList.getLong(n2));
            longList.set(n2, l);
        }
        return longList;
    }

    public static LongList emptyList() {
        return EMPTY_LIST;
    }

    public static LongList singleton(long l) {
        return new Singleton(l);
    }

    public static LongList singleton(Object object) {
        return new Singleton((Long)object);
    }

    public static LongList synchronize(LongList longList) {
        return longList instanceof RandomAccess ? new SynchronizedRandomAccessList(longList) : new SynchronizedList(longList);
    }

    public static LongList synchronize(LongList longList, Object object) {
        return longList instanceof RandomAccess ? new SynchronizedRandomAccessList(longList, object) : new SynchronizedList(longList, object);
    }

    public static LongList unmodifiable(LongList longList) {
        return longList instanceof RandomAccess ? new UnmodifiableRandomAccessList(longList) : new UnmodifiableList(longList);
    }

    public static class EmptyList
    extends LongCollections.EmptyCollection
    implements LongList,
    RandomAccess,
    Serializable,
    Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptyList() {
        }

        @Override
        public long getLong(int n) {
            throw new IndexOutOfBoundsException();
        }

        @Override
        public boolean rem(long l) {
            throw new UnsupportedOperationException();
        }

        @Override
        public long removeLong(int n) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void add(int n, long l) {
            throw new UnsupportedOperationException();
        }

        @Override
        public long set(int n, long l) {
            throw new UnsupportedOperationException();
        }

        @Override
        public int indexOf(long l) {
            return -1;
        }

        @Override
        public int lastIndexOf(long l) {
            return -1;
        }

        @Override
        public boolean addAll(int n, Collection<? extends Long> collection) {
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public void replaceAll(UnaryOperator<Long> unaryOperator) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void replaceAll(LongUnaryOperator longUnaryOperator) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean addAll(LongList longList) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean addAll(int n, LongCollection longCollection) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean addAll(int n, LongList longList) {
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public void add(int n, Long l) {
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public Long get(int n) {
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public boolean add(Long l) {
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public Long set(int n, Long l) {
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public Long remove(int n) {
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public int indexOf(Object object) {
            return -1;
        }

        @Override
        @Deprecated
        public int lastIndexOf(Object object) {
            return -1;
        }

        @Override
        public void sort(LongComparator longComparator) {
        }

        @Override
        public void unstableSort(LongComparator longComparator) {
        }

        @Override
        @Deprecated
        public void sort(Comparator<? super Long> comparator) {
        }

        @Override
        @Deprecated
        public void unstableSort(Comparator<? super Long> comparator) {
        }

        @Override
        public LongListIterator listIterator() {
            return LongIterators.EMPTY_ITERATOR;
        }

        @Override
        public LongListIterator iterator() {
            return LongIterators.EMPTY_ITERATOR;
        }

        @Override
        public LongListIterator listIterator(int n) {
            if (n == 0) {
                return LongIterators.EMPTY_ITERATOR;
            }
            throw new IndexOutOfBoundsException(String.valueOf(n));
        }

        @Override
        public LongList subList(int n, int n2) {
            if (n == 0 && n2 == 0) {
                return this;
            }
            throw new IndexOutOfBoundsException();
        }

        @Override
        public void getElements(int n, long[] lArray, int n2, int n3) {
            if (n == 0 && n3 == 0 && n2 >= 0 && n2 <= lArray.length) {
                return;
            }
            throw new IndexOutOfBoundsException();
        }

        @Override
        public void removeElements(int n, int n2) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void addElements(int n, long[] lArray, int n2, int n3) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void addElements(int n, long[] lArray) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void setElements(long[] lArray) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void setElements(int n, long[] lArray) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void setElements(int n, long[] lArray, int n2, int n3) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void size(int n) {
            throw new UnsupportedOperationException();
        }

        @Override
        public int compareTo(List<? extends Long> list) {
            if (list == this) {
                return 0;
            }
            return list.isEmpty() ? 0 : -1;
        }

        public Object clone() {
            return EMPTY_LIST;
        }

        @Override
        public int hashCode() {
            return 1;
        }

        @Override
        public boolean equals(Object object) {
            return object instanceof List && ((List)object).isEmpty();
        }

        @Override
        public String toString() {
            return "[]";
        }

        private Object readResolve() {
            return EMPTY_LIST;
        }
    }

    public static class Singleton
    extends AbstractLongList
    implements RandomAccess,
    Serializable,
    Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        private final long element;

        protected Singleton(long l) {
            this.element = l;
        }

        @Override
        public long getLong(int n) {
            if (n == 0) {
                return this.element;
            }
            throw new IndexOutOfBoundsException();
        }

        @Override
        public boolean rem(long l) {
            throw new UnsupportedOperationException();
        }

        @Override
        public long removeLong(int n) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean contains(long l) {
            return l == this.element;
        }

        @Override
        public int indexOf(long l) {
            return l == this.element ? 0 : -1;
        }

        @Override
        public long[] toLongArray() {
            return new long[]{this.element};
        }

        @Override
        public LongListIterator listIterator() {
            return LongIterators.singleton(this.element);
        }

        @Override
        public LongListIterator iterator() {
            return this.listIterator();
        }

        @Override
        public LongSpliterator spliterator() {
            return LongSpliterators.singleton(this.element);
        }

        @Override
        public LongListIterator listIterator(int n) {
            if (n > 1 || n < 0) {
                throw new IndexOutOfBoundsException();
            }
            LongListIterator longListIterator = this.listIterator();
            if (n == 1) {
                longListIterator.nextLong();
            }
            return longListIterator;
        }

        @Override
        public LongList subList(int n, int n2) {
            this.ensureIndex(n);
            this.ensureIndex(n2);
            if (n > n2) {
                throw new IndexOutOfBoundsException("Start index (" + n + ") is greater than end index (" + n2 + ")");
            }
            if (n != 0 || n2 != 1) {
                return EMPTY_LIST;
            }
            return this;
        }

        @Override
        @Deprecated
        public void forEach(Consumer<? super Long> consumer) {
            consumer.accept((Long)this.element);
        }

        @Override
        public boolean addAll(int n, Collection<? extends Long> collection) {
            throw new UnsupportedOperationException();
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
        @Deprecated
        public void replaceAll(UnaryOperator<Long> unaryOperator) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void replaceAll(LongUnaryOperator longUnaryOperator) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void forEach(LongConsumer longConsumer) {
            longConsumer.accept(this.element);
        }

        @Override
        public boolean addAll(LongList longList) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean addAll(int n, LongList longList) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean addAll(int n, LongCollection longCollection) {
            throw new UnsupportedOperationException();
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

        @Override
        public void sort(LongComparator longComparator) {
        }

        @Override
        public void unstableSort(LongComparator longComparator) {
        }

        @Override
        @Deprecated
        public void sort(Comparator<? super Long> comparator) {
        }

        @Override
        @Deprecated
        public void unstableSort(Comparator<? super Long> comparator) {
        }

        @Override
        public void getElements(int n, long[] lArray, int n2, int n3) {
            if (n2 < 0) {
                throw new ArrayIndexOutOfBoundsException("Offset (" + n2 + ") is negative");
            }
            if (n2 + n3 > lArray.length) {
                throw new ArrayIndexOutOfBoundsException("End index (" + (n2 + n3) + ") is greater than array length (" + lArray.length + ")");
            }
            if (n + n3 > this.size()) {
                throw new IndexOutOfBoundsException("End index (" + (n + n3) + ") is greater than list size (" + this.size() + ")");
            }
            if (n3 <= 0) {
                return;
            }
            lArray[n2] = this.element;
        }

        @Override
        public void removeElements(int n, int n2) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void addElements(int n, long[] lArray) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void addElements(int n, long[] lArray, int n2, int n3) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void setElements(long[] lArray) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void setElements(int n, long[] lArray) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void setElements(int n, long[] lArray, int n2, int n3) {
            throw new UnsupportedOperationException();
        }

        @Override
        public int size() {
            return 1;
        }

        @Override
        public void size(int n) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void clear() {
            throw new UnsupportedOperationException();
        }

        public Object clone() {
            return this;
        }
    }

    public static abstract class ImmutableListBase
    extends AbstractLongList
    implements LongList {
        ImmutableListBase() {
        }

        @Override
        @Deprecated
        public final void add(int n, long l) {
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public final boolean add(long l) {
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public final boolean addAll(Collection<? extends Long> collection) {
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public final boolean addAll(int n, Collection<? extends Long> collection) {
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public final long removeLong(int n) {
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public final boolean rem(long l) {
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public final boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public final boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public final boolean removeIf(Predicate<? super Long> predicate) {
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public final boolean removeIf(LongPredicate longPredicate) {
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public final void replaceAll(UnaryOperator<Long> unaryOperator) {
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public final void replaceAll(LongUnaryOperator longUnaryOperator) {
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public final void add(int n, Long l) {
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public final boolean add(Long l) {
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public final Long remove(int n) {
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public final boolean remove(Object object) {
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public final Long set(int n, Long l) {
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public final boolean addAll(LongCollection longCollection) {
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public final boolean addAll(LongList longList) {
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public final boolean addAll(int n, LongCollection longCollection) {
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public final boolean addAll(int n, LongList longList) {
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public final boolean removeAll(LongCollection longCollection) {
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public final boolean retainAll(LongCollection longCollection) {
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public final long set(int n, long l) {
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public final void clear() {
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public final void size(int n) {
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public final void removeElements(int n, int n2) {
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public final void addElements(int n, long[] lArray, int n2, int n3) {
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public final void setElements(int n, long[] lArray, int n2, int n3) {
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public final void sort(LongComparator longComparator) {
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public final void unstableSort(LongComparator longComparator) {
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public final void sort(Comparator<? super Long> comparator) {
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public final void unstableSort(Comparator<? super Long> comparator) {
            throw new UnsupportedOperationException();
        }
    }

	public static class SynchronizedList extends LongCollections.SynchronizedCollection implements LongList, java.io.Serializable {
		private static final long serialVersionUID = -7046029254386353129L;
		protected final LongList list; 
										

		protected SynchronizedList(final LongList l, final Object sync) {
			super(l, sync);
			this.list = l;
		}

		protected SynchronizedList(final LongList l) {
			super(l);
			this.list = l;
		}

		@Override
		public long getLong(final int i) {
			synchronized (sync) {
				return list.getLong(i);
			}
		}

		@Override
		public long set(final int i, final long k) {
			synchronized (sync) {
				return list.set(i, k);
			}
		}

		@Override
		public void add(final int i, final long k) {
			synchronized (sync) {
				list.add(i, k);
			}
		}

		@Override
		public long removeLong(final int i) {
			synchronized (sync) {
				return list.removeLong(i);
			}
		}

		@Override
		public int indexOf(final long k) {
			synchronized (sync) {
				return list.indexOf(k);
			}
		}

		@Override
		public int lastIndexOf(final long k) {
			synchronized (sync) {
				return list.lastIndexOf(k);
			}
		}

		@Override
		public boolean removeIf(final java.util.function.LongPredicate filter) {
			synchronized (sync) {
				return list.removeIf(filter);
			}
		}

		@Override
		public void replaceAll(final java.util.function.LongUnaryOperator operator) {
			synchronized (sync) {
				list.replaceAll(operator);
			}
		}

		@Override
		public boolean addAll(final int index, final Collection<? extends Long> c) {
			synchronized (sync) {
				return list.addAll(index, c);
			}
		}

		@Override
		public void getElements(final int from, final long a[], final int offset, final int length) {
			synchronized (sync) {
				list.getElements(from, a, offset, length);
			}
		}

		@Override
		public void removeElements(final int from, final int to) {
			synchronized (sync) {
				list.removeElements(from, to);
			}
		}

		@Override
		public void addElements(int index, final long a[], int offset, int length) {
			synchronized (sync) {
				list.addElements(index, a, offset, length);
			}
		}

		@Override
		public void addElements(int index, final long a[]) {
			synchronized (sync) {
				list.addElements(index, a);
			}
		}

		@Override
		public void setElements(final long a[]) {
			synchronized (sync) {
				list.setElements(a);
			}
		}

		@Override
		public void setElements(int index, final long a[]) {
			synchronized (sync) {
				list.setElements(index, a);
			}
		}

		@Override
		public void setElements(int index, final long a[], int offset, int length) {
			synchronized (sync) {
				list.setElements(index, a, offset, length);
			}
		}

		@Override
		public void size(final int size) {
			synchronized (sync) {
				list.size(size);
			}
		}

		@Override
		public LongListIterator listIterator() {
			return list.listIterator();
		}

		@Override
		public LongListIterator iterator() {
			return listIterator();
		}

		@Override
		public LongListIterator listIterator(final int i) {
			return list.listIterator(i);
		}

		@Override
		public LongList subList(final int from, final int to) {
			synchronized (sync) {
				return new SynchronizedList(list.subList(from, to), sync);
			}
		}

		@Override
		public boolean equals(final Object o) {
			if (o == this) return true;
			synchronized (sync) {
				return collection.equals(o);
			}
		}

		@Override
		public int hashCode() {
			synchronized (sync) {
				return collection.hashCode();
			}
		}

		@Override
		public int compareTo(final List<? extends Long> o) {
			synchronized (sync) {
				return list.compareTo(o);
			}
		}

		@Override
		public boolean addAll(final int index, final LongCollection c) {
			synchronized (sync) {
				return list.addAll(index, c);
			}
		}

		@Override
		public boolean addAll(final int index, LongList l) {
			synchronized (sync) {
				return list.addAll(index, l);
			}
		}

		@Override
		public boolean addAll(LongList l) {
			synchronized (sync) {
				return list.addAll(l);
			}
		}

		
		@Deprecated
		@Override
		public Long get(final int i) {
			synchronized (sync) {
				return list.get(i);
			}
		}

		
		@Deprecated
		@Override
		public void add(final int i, Long k) {
			synchronized (sync) {
				list.add(i, k);
			}
		}

		
		@Deprecated
		@Override
		public Long set(final int index, Long k) {
			synchronized (sync) {
				return list.set(index, k);
			}
		}

		
		@Deprecated
		@Override
		public Long remove(final int i) {
			synchronized (sync) {
				return list.remove(i);
			}
		}

		
		@Deprecated
		@Override
		public int indexOf(final Object o) {
			synchronized (sync) {
				return list.indexOf(o);
			}
		}

		
		@Deprecated
		@Override
		public int lastIndexOf(final Object o) {
			synchronized (sync) {
				return list.lastIndexOf(o);
			}
		}

		@Override
		public void sort(final LongComparator comparator) {
			synchronized (sync) {
				list.sort(comparator);
			}
		}

		@Override
		public void unstableSort(final LongComparator comparator) {
			synchronized (sync) {
				list.unstableSort(comparator);
			}
		}

		@Deprecated
		@Override
		public void sort(final java.util.Comparator<? super Long> comparator) {
			synchronized (sync) {
				list.sort(comparator);
			}
		}

		@Deprecated
		@Override
		public void unstableSort(final java.util.Comparator<? super Long> comparator) {
			synchronized (sync) {
				list.unstableSort(comparator);
			}
		}

		private void writeObject(java.io.ObjectOutputStream s) throws java.io.IOException {
			synchronized (sync) {
				s.defaultWriteObject();
			}
		}
	}

	public static class SynchronizedRandomAccessList extends SynchronizedList implements RandomAccess, java.io.Serializable {
		private static final long serialVersionUID = 0L;

		protected SynchronizedRandomAccessList(final LongList l, final Object sync) {
			super(l, sync);
		}

		protected SynchronizedRandomAccessList(final LongList l) {
			super(l);
		}

		@Override
		public LongList subList(final int from, final int to) {
			synchronized (sync) {
				return new SynchronizedRandomAccessList(list.subList(from, to), sync);
			}
		}
	}

	public static class UnmodifiableList extends LongCollections.UnmodifiableCollection implements LongList, java.io.Serializable {
		private static final long serialVersionUID = -7046029254386353129L;
		protected final LongList list; 
										

		protected UnmodifiableList(final LongList l) {
			super(l);
			this.list = l;
		}

		@Override
		public long getLong(final int i) {
			return list.getLong(i);
		}

		@Override
		public long set(final int i, final long k) {
			throw new UnsupportedOperationException();
		}

		@Override
		public void add(final int i, final long k) {
			throw new UnsupportedOperationException();
		}

		@Override
		public long removeLong(final int i) {
			throw new UnsupportedOperationException();
		}

		@Override
		public int indexOf(final long k) {
			return list.indexOf(k);
		}

		@Override
		public int lastIndexOf(final long k) {
			return list.lastIndexOf(k);
		}

		@Override
		public boolean addAll(final int index, final Collection<? extends Long> c) {
			throw new UnsupportedOperationException();
		}

		@Deprecated
		@Override
		public void replaceAll(final java.util.function.UnaryOperator<Long> operator) {
			throw new UnsupportedOperationException();
		}

		@Override
		public void getElements(final int from, final long a[], final int offset, final int length) {
			list.getElements(from, a, offset, length);
		}

		@Override
		public void removeElements(final int from, final int to) {
			throw new UnsupportedOperationException();
		}

		@Override
		public void addElements(int index, final long a[], int offset, int length) {
			throw new UnsupportedOperationException();
		}

		@Override
		public void addElements(int index, final long a[]) {
			throw new UnsupportedOperationException();
		}

		@Override
		public void setElements(final long a[]) {
			throw new UnsupportedOperationException();
		}

		@Override
		public void setElements(int index, final long a[]) {
			throw new UnsupportedOperationException();
		}

		@Override
		public void setElements(int index, final long a[], int offset, int length) {
			throw new UnsupportedOperationException();
		}

		@Override
		public void size(final int size) {
			list.size(size);
		}

		@Override
		public LongListIterator listIterator() {
			return LongIterators.unmodifiable(list.listIterator());
		}

		@Override
		public LongListIterator iterator() {
			return listIterator();
		}

		@Override
		public LongListIterator listIterator(final int i) {
			return LongIterators.unmodifiable(list.listIterator(i));
		}

		@Override
		public LongList subList(final int from, final int to) {
			return new UnmodifiableList(list.subList(from, to));
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

		@Override
		public int compareTo(final List<? extends Long> o) {
			return list.compareTo(o);
		}

		@Override
		public boolean addAll(final int index, final LongCollection c) {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean addAll(final LongList l) {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean addAll(final int index, final LongList l) {
			throw new UnsupportedOperationException();
		}

		@Override
		public void replaceAll(final java.util.function.LongUnaryOperator operator) {
			throw new UnsupportedOperationException();
		}

		
		@Deprecated
		@Override
		public Long get(final int i) {
			return list.get(i);
		}

		
		@Deprecated
		@Override
		public void add(final int i, Long k) {
			throw new UnsupportedOperationException();
		}

		
		@Deprecated
		@Override
		public Long set(final int index, Long k) {
			throw new UnsupportedOperationException();
		}

		
		@Deprecated
		@Override
		public Long remove(final int i) {
			throw new UnsupportedOperationException();
		}

		
		@Deprecated
		@Override
		public int indexOf(final Object o) {
			return list.indexOf(o);
		}

		
		@Deprecated
		@Override
		public int lastIndexOf(final Object o) {
			return list.lastIndexOf(o);
		}

		@Override
		public void sort(final LongComparator comparator) {
			throw new UnsupportedOperationException();
		}

		@Override
		public void unstableSort(final LongComparator comparator) {
			throw new UnsupportedOperationException();
		}

		@Deprecated
		@Override
		public void sort(final java.util.Comparator<? super Long> comparator) {
			throw new UnsupportedOperationException();
		}

		@Deprecated
		@Override
		public void unstableSort(final java.util.Comparator<? super Long> comparator) {
			throw new UnsupportedOperationException();
		}
	}

	public static class UnmodifiableRandomAccessList extends UnmodifiableList implements RandomAccess, java.io.Serializable {
		private static final long serialVersionUID = 0L;

		protected UnmodifiableRandomAccessList(final LongList l) {
			super(l);
		}

		@Override
		public LongList subList(final int from, final int to) {
			return new UnmodifiableRandomAccessList(list.subList(from, to));
		}
	}
}

