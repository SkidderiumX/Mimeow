/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.ints;

import com.viaversion.viaversion.libs.fastutil.ints.AbstractIntList;
import com.viaversion.viaversion.libs.fastutil.ints.IntCollection;
import com.viaversion.viaversion.libs.fastutil.ints.IntCollections;
import com.viaversion.viaversion.libs.fastutil.ints.IntComparator;
import com.viaversion.viaversion.libs.fastutil.ints.IntIterators;
import com.viaversion.viaversion.libs.fastutil.ints.IntList;
import com.viaversion.viaversion.libs.fastutil.ints.IntListIterator;
import com.viaversion.viaversion.libs.fastutil.ints.IntLists;
import com.viaversion.viaversion.libs.fastutil.ints.IntSpliterator;
import com.viaversion.viaversion.libs.fastutil.ints.IntSpliterators;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.RandomAccess;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class IntLists {
    public static final EmptyList EMPTY_LIST = new EmptyList();

    private IntLists() {
    }

    public static IntList shuffle(IntList intList, Random random) {
        int n = intList.size();
        while (n-- != 0) {
            int n2 = random.nextInt(n + 1);
            int n3 = intList.getInt(n);
            intList.set(n, intList.getInt(n2));
            intList.set(n2, n3);
        }
        return intList;
    }

    public static IntList emptyList() {
        return EMPTY_LIST;
    }

    public static IntList singleton(int n) {
        return new Singleton(n);
    }

    public static IntList singleton(Object object) {
        return new Singleton((Integer)object);
    }

    public static IntList synchronize(IntList intList) {
        return intList instanceof RandomAccess ? new SynchronizedRandomAccessList(intList) : new SynchronizedList(intList);
    }

    public static IntList synchronize(IntList intList, Object object) {
        return intList instanceof RandomAccess ? new SynchronizedRandomAccessList(intList, object) : new SynchronizedList(intList, object);
    }

    public static IntList unmodifiable(IntList intList) {
        return intList instanceof RandomAccess ? new UnmodifiableRandomAccessList(intList) : new UnmodifiableList(intList);
    }

    public static class EmptyList
    extends IntCollections.EmptyCollection
    implements IntList,
    RandomAccess,
    Serializable,
    Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;

        protected EmptyList() {
        }

        @Override
        public int getInt(int n) {
            throw new IndexOutOfBoundsException();
        }

        @Override
        public boolean rem(int n) {
            throw new UnsupportedOperationException();
        }

        @Override
        public int removeInt(int n) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void add(int n, int n2) {
            throw new UnsupportedOperationException();
        }

        @Override
        public int set(int n, int n2) {
            throw new UnsupportedOperationException();
        }

        @Override
        public int indexOf(int n) {
            return -1;
        }

        @Override
        public int lastIndexOf(int n) {
            return -1;
        }

        @Override
        public boolean addAll(int n, Collection<? extends Integer> collection) {
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public void replaceAll(UnaryOperator<Integer> unaryOperator) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void replaceAll(IntUnaryOperator intUnaryOperator) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean addAll(IntList intList) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean addAll(int n, IntCollection intCollection) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean addAll(int n, IntList intList) {
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public void add(int n, Integer n2) {
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public Integer get(int n) {
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public boolean add(Integer n) {
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public Integer set(int n, Integer n2) {
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public Integer remove(int n) {
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
        public void sort(IntComparator intComparator) {
        }

        @Override
        public void unstableSort(IntComparator intComparator) {
        }

        @Override
        @Deprecated
        public void sort(Comparator<? super Integer> comparator) {
        }

        @Override
        @Deprecated
        public void unstableSort(Comparator<? super Integer> comparator) {
        }

        @Override
        public IntListIterator listIterator() {
            return IntIterators.EMPTY_ITERATOR;
        }

        @Override
        public IntListIterator iterator() {
            return IntIterators.EMPTY_ITERATOR;
        }

        @Override
        public IntListIterator listIterator(int n) {
            if (n == 0) {
                return IntIterators.EMPTY_ITERATOR;
            }
            throw new IndexOutOfBoundsException(String.valueOf(n));
        }

        @Override
        public IntList subList(int n, int n2) {
            if (n == 0 && n2 == 0) {
                return this;
            }
            throw new IndexOutOfBoundsException();
        }

        @Override
        public void getElements(int n, int[] nArray, int n2, int n3) {
            if (n == 0 && n3 == 0 && n2 >= 0 && n2 <= nArray.length) {
                return;
            }
            throw new IndexOutOfBoundsException();
        }

        @Override
        public void removeElements(int n, int n2) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void addElements(int n, int[] nArray, int n2, int n3) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void addElements(int n, int[] nArray) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void setElements(int[] nArray) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void setElements(int n, int[] nArray) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void setElements(int n, int[] nArray, int n2, int n3) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void size(int n) {
            throw new UnsupportedOperationException();
        }

        @Override
        public int compareTo(List<? extends Integer> list) {
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
    extends AbstractIntList
    implements RandomAccess,
    Serializable,
    Cloneable {
        private static final long serialVersionUID = -7046029254386353129L;
        private final int element;

        protected Singleton(int n) {
            this.element = n;
        }

        @Override
        public int getInt(int n) {
            if (n == 0) {
                return this.element;
            }
            throw new IndexOutOfBoundsException();
        }

        @Override
        public boolean rem(int n) {
            throw new UnsupportedOperationException();
        }

        @Override
        public int removeInt(int n) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean contains(int n) {
            return n == this.element;
        }

        @Override
        public int indexOf(int n) {
            return n == this.element ? 0 : -1;
        }

        @Override
        public int[] toIntArray() {
            return new int[]{this.element};
        }

        @Override
        public IntListIterator listIterator() {
            return IntIterators.singleton(this.element);
        }

        @Override
        public IntListIterator iterator() {
            return this.listIterator();
        }

        @Override
        public IntSpliterator spliterator() {
            return IntSpliterators.singleton(this.element);
        }

        @Override
        public IntListIterator listIterator(int n) {
            if (n > 1 || n < 0) {
                throw new IndexOutOfBoundsException();
            }
            IntListIterator intListIterator = this.listIterator();
            if (n == 1) {
                intListIterator.nextInt();
            }
            return intListIterator;
        }

        @Override
        public IntList subList(int n, int n2) {
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
        public void forEach(Consumer<? super Integer> consumer) {
            consumer.accept((Integer)this.element);
        }

        @Override
        public boolean addAll(int n, Collection<? extends Integer> collection) {
            throw new UnsupportedOperationException();
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
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public void replaceAll(UnaryOperator<Integer> unaryOperator) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void replaceAll(IntUnaryOperator intUnaryOperator) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void forEach(IntConsumer intConsumer) {
            intConsumer.accept(this.element);
        }

        @Override
        public boolean addAll(IntList intList) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean addAll(int n, IntList intList) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean addAll(int n, IntCollection intCollection) {
            throw new UnsupportedOperationException();
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
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public Object[] toArray() {
            return new Object[]{this.element};
        }

        @Override
        public void sort(IntComparator intComparator) {
        }

        @Override
        public void unstableSort(IntComparator intComparator) {
        }

        @Override
        @Deprecated
        public void sort(Comparator<? super Integer> comparator) {
        }

        @Override
        @Deprecated
        public void unstableSort(Comparator<? super Integer> comparator) {
        }

        @Override
        public void getElements(int n, int[] nArray, int n2, int n3) {
            if (n2 < 0) {
                throw new ArrayIndexOutOfBoundsException("Offset (" + n2 + ") is negative");
            }
            if (n2 + n3 > nArray.length) {
                throw new ArrayIndexOutOfBoundsException("End index (" + (n2 + n3) + ") is greater than array length (" + nArray.length + ")");
            }
            if (n + n3 > this.size()) {
                throw new IndexOutOfBoundsException("End index (" + (n + n3) + ") is greater than list size (" + this.size() + ")");
            }
            if (n3 <= 0) {
                return;
            }
            nArray[n2] = this.element;
        }

        @Override
        public void removeElements(int n, int n2) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void addElements(int n, int[] nArray) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void addElements(int n, int[] nArray, int n2, int n3) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void setElements(int[] nArray) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void setElements(int n, int[] nArray) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void setElements(int n, int[] nArray, int n2, int n3) {
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
    extends AbstractIntList
    implements IntList {
        ImmutableListBase() {
        }

        @Override
        @Deprecated
        public final void add(int n, int n2) {
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public final boolean add(int n) {
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public final boolean addAll(Collection<? extends Integer> collection) {
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public final boolean addAll(int n, Collection<? extends Integer> collection) {
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public final int removeInt(int n) {
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public final boolean rem(int n) {
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
        public final boolean removeIf(Predicate<? super Integer> predicate) {
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public final boolean removeIf(IntPredicate intPredicate) {
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public final void replaceAll(UnaryOperator<Integer> unaryOperator) {
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public final void replaceAll(IntUnaryOperator intUnaryOperator) {
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public final void add(int n, Integer n2) {
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public final boolean add(Integer n) {
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public final Integer remove(int n) {
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public final boolean remove(Object object) {
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public final Integer set(int n, Integer n2) {
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public final boolean addAll(IntCollection intCollection) {
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public final boolean addAll(IntList intList) {
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public final boolean addAll(int n, IntCollection intCollection) {
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public final boolean addAll(int n, IntList intList) {
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public final boolean removeAll(IntCollection intCollection) {
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public final boolean retainAll(IntCollection intCollection) {
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public final int set(int n, int n2) {
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
        public final void addElements(int n, int[] nArray, int n2, int n3) {
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public final void setElements(int n, int[] nArray, int n2, int n3) {
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public final void sort(IntComparator intComparator) {
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public final void unstableSort(IntComparator intComparator) {
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public final void sort(Comparator<? super Integer> comparator) {
            throw new UnsupportedOperationException();
        }

        @Override
        @Deprecated
        public final void unstableSort(Comparator<? super Integer> comparator) {
            throw new UnsupportedOperationException();
        }
    }

	public static class SynchronizedList extends IntCollections.SynchronizedCollection implements IntList, java.io.Serializable {
		private static final long serialVersionUID = -7046029254386353129L;
		protected final IntList list; 
										

		protected SynchronizedList(final IntList l, final Object sync) {
			super(l, sync);
			this.list = l;
		}

		protected SynchronizedList(final IntList l) {
			super(l);
			this.list = l;
		}

		@Override
		public int getInt(final int i) {
			synchronized (sync) {
				return list.getInt(i);
			}
		}

		@Override
		public int set(final int i, final int k) {
			synchronized (sync) {
				return list.set(i, k);
			}
		}

		@Override
		public void add(final int i, final int k) {
			synchronized (sync) {
				list.add(i, k);
			}
		}

		@Override
		public int removeInt(final int i) {
			synchronized (sync) {
				return list.removeInt(i);
			}
		}

		@Override
		public int indexOf(final int k) {
			synchronized (sync) {
				return list.indexOf(k);
			}
		}

		@Override
		public int lastIndexOf(final int k) {
			synchronized (sync) {
				return list.lastIndexOf(k);
			}
		}

		@Override
		public boolean removeIf(final java.util.function.IntPredicate filter) {
			synchronized (sync) {
				return list.removeIf(filter);
			}
		}

		@Override
		public void replaceAll(final java.util.function.IntUnaryOperator operator) {
			synchronized (sync) {
				list.replaceAll(operator);
			}
		}

		@Override
		public boolean addAll(final int index, final Collection<? extends Integer> c) {
			synchronized (sync) {
				return list.addAll(index, c);
			}
		}

		@Override
		public void getElements(final int from, final int a[], final int offset, final int length) {
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
		public void addElements(int index, final int a[], int offset, int length) {
			synchronized (sync) {
				list.addElements(index, a, offset, length);
			}
		}

		@Override
		public void addElements(int index, final int a[]) {
			synchronized (sync) {
				list.addElements(index, a);
			}
		}

		@Override
		public void setElements(final int a[]) {
			synchronized (sync) {
				list.setElements(a);
			}
		}

		@Override
		public void setElements(int index, final int a[]) {
			synchronized (sync) {
				list.setElements(index, a);
			}
		}

		@Override
		public void setElements(int index, final int a[], int offset, int length) {
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
		public IntListIterator listIterator() {
			return list.listIterator();
		}

		@Override
		public IntListIterator iterator() {
			return listIterator();
		}

		@Override
		public IntListIterator listIterator(final int i) {
			return list.listIterator(i);
		}

		@Override
		public IntList subList(final int from, final int to) {
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
		public int compareTo(final List<? extends Integer> o) {
			synchronized (sync) {
				return list.compareTo(o);
			}
		}

		@Override
		public boolean addAll(final int index, final IntCollection c) {
			synchronized (sync) {
				return list.addAll(index, c);
			}
		}

		@Override
		public boolean addAll(final int index, IntList l) {
			synchronized (sync) {
				return list.addAll(index, l);
			}
		}

		@Override
		public boolean addAll(IntList l) {
			synchronized (sync) {
				return list.addAll(l);
			}
		}

		
		@Deprecated
		@Override
		public Integer get(final int i) {
			synchronized (sync) {
				return list.get(i);
			}
		}

		
		@Deprecated
		@Override
		public void add(final int i, Integer k) {
			synchronized (sync) {
				list.add(i, k);
			}
		}

		
		@Deprecated
		@Override
		public Integer set(final int index, Integer k) {
			synchronized (sync) {
				return list.set(index, k);
			}
		}

		
		@Deprecated
		@Override
		public Integer remove(final int i) {
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
		public void sort(final IntComparator comparator) {
			synchronized (sync) {
				list.sort(comparator);
			}
		}

		@Override
		public void unstableSort(final IntComparator comparator) {
			synchronized (sync) {
				list.unstableSort(comparator);
			}
		}

		@Deprecated
		@Override
		public void sort(final java.util.Comparator<? super Integer> comparator) {
			synchronized (sync) {
				list.sort(comparator);
			}
		}

		@Deprecated
		@Override
		public void unstableSort(final java.util.Comparator<? super Integer> comparator) {
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

		protected SynchronizedRandomAccessList(final IntList l, final Object sync) {
			super(l, sync);
		}

		protected SynchronizedRandomAccessList(final IntList l) {
			super(l);
		}

		@Override
		public IntList subList(final int from, final int to) {
			synchronized (sync) {
				return new SynchronizedRandomAccessList(list.subList(from, to), sync);
			}
		}
	}

	public static class UnmodifiableList extends IntCollections.UnmodifiableCollection implements IntList, java.io.Serializable {
		private static final long serialVersionUID = -7046029254386353129L;
		protected final IntList list; 
										

		protected UnmodifiableList(final IntList l) {
			super(l);
			this.list = l;
		}

		@Override
		public int getInt(final int i) {
			return list.getInt(i);
		}

		@Override
		public int set(final int i, final int k) {
			throw new UnsupportedOperationException();
		}

		@Override
		public void add(final int i, final int k) {
			throw new UnsupportedOperationException();
		}

		@Override
		public int removeInt(final int i) {
			throw new UnsupportedOperationException();
		}

		@Override
		public int indexOf(final int k) {
			return list.indexOf(k);
		}

		@Override
		public int lastIndexOf(final int k) {
			return list.lastIndexOf(k);
		}

		@Override
		public boolean addAll(final int index, final Collection<? extends Integer> c) {
			throw new UnsupportedOperationException();
		}

		@Deprecated
		@Override
		public void replaceAll(final java.util.function.UnaryOperator<Integer> operator) {
			throw new UnsupportedOperationException();
		}

		@Override
		public void getElements(final int from, final int a[], final int offset, final int length) {
			list.getElements(from, a, offset, length);
		}

		@Override
		public void removeElements(final int from, final int to) {
			throw new UnsupportedOperationException();
		}

		@Override
		public void addElements(int index, final int a[], int offset, int length) {
			throw new UnsupportedOperationException();
		}

		@Override
		public void addElements(int index, final int a[]) {
			throw new UnsupportedOperationException();
		}

		@Override
		public void setElements(final int a[]) {
			throw new UnsupportedOperationException();
		}

		@Override
		public void setElements(int index, final int a[]) {
			throw new UnsupportedOperationException();
		}

		@Override
		public void setElements(int index, final int a[], int offset, int length) {
			throw new UnsupportedOperationException();
		}

		@Override
		public void size(final int size) {
			list.size(size);
		}

		@Override
		public IntListIterator listIterator() {
			return IntIterators.unmodifiable(list.listIterator());
		}

		@Override
		public IntListIterator iterator() {
			return listIterator();
		}

		@Override
		public IntListIterator listIterator(final int i) {
			return IntIterators.unmodifiable(list.listIterator(i));
		}

		@Override
		public IntList subList(final int from, final int to) {
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
		public int compareTo(final List<? extends Integer> o) {
			return list.compareTo(o);
		}

		@Override
		public boolean addAll(final int index, final IntCollection c) {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean addAll(final IntList l) {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean addAll(final int index, final IntList l) {
			throw new UnsupportedOperationException();
		}

		@Override
		public void replaceAll(final java.util.function.IntUnaryOperator operator) {
			throw new UnsupportedOperationException();
		}

		
		@Deprecated
		@Override
		public Integer get(final int i) {
			return list.get(i);
		}

		
		@Deprecated
		@Override
		public void add(final int i, Integer k) {
			throw new UnsupportedOperationException();
		}

		
		@Deprecated
		@Override
		public Integer set(final int index, Integer k) {
			throw new UnsupportedOperationException();
		}

		
		@Deprecated
		@Override
		public Integer remove(final int i) {
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
		public void sort(final IntComparator comparator) {
			throw new UnsupportedOperationException();
		}

		@Override
		public void unstableSort(final IntComparator comparator) {
			throw new UnsupportedOperationException();
		}

		@Deprecated
		@Override
		public void sort(final java.util.Comparator<? super Integer> comparator) {
			throw new UnsupportedOperationException();
		}

		@Deprecated
		@Override
		public void unstableSort(final java.util.Comparator<? super Integer> comparator) {
			throw new UnsupportedOperationException();
		}
	}

	public static class UnmodifiableRandomAccessList extends UnmodifiableList implements RandomAccess, java.io.Serializable {
		private static final long serialVersionUID = 0L;

		protected UnmodifiableRandomAccessList(final IntList l) {
			super(l);
		}

		@Override
		public IntList subList(final int from, final int to) {
			return new UnmodifiableRandomAccessList(list.subList(from, to));
		}
	}
}

