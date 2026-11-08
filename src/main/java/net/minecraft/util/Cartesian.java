/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.UnmodifiableIterator;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Cartesian {
    public static <T> Iterable<T[]> cartesianProduct(Class<T> clazz, Iterable<? extends Iterable<? extends T>> iterable) {
        return new Product<T>(clazz, Cartesian.toArray(Iterable.class, iterable));
    }

    public static <T> Iterable<List<T>> cartesianProduct(Iterable<? extends Iterable<? extends T>> iterable) {
        return Cartesian.arraysAsLists(Cartesian.cartesianProduct(Object.class, iterable));
    }

    private static <T> Iterable<List<T>> arraysAsLists(Iterable<Object[]> iterable) {
        return Iterables.transform(iterable, new GetList());
    }

    private static <T> T[] toArray(Class<? super T> clazz, Iterable<? extends T> iterable) {
        ArrayList<T> arrayList = Lists.newArrayList();
        for (T t : iterable) {
            arrayList.add(t);
        }
        return arrayList.toArray(Cartesian.createArray(clazz, arrayList.size()));
    }

    private static <T> T[] createArray(Class<? super T> clazz, int n) {
        return (Object[])Array.newInstance(clazz, n);
    }

    public static class Product<T>
    implements Iterable<T[]> {
        private final Class<T> clazz;
        private final Iterable<? extends T>[] iterables;

        private Product(Class<T> clazz, Iterable<? extends T>[] iterableArray) {
            this.clazz = clazz;
            this.iterables = iterableArray;
        }

        @Override
        public Iterator<T[]> iterator() {
            return this.iterables.length <= 0 ? Collections.singletonList(Cartesian.createArray(this.clazz, 0)).iterator() : new ProductIterator<T>(this.clazz, this.iterables);
        }

        public static class ProductIterator<T>
        extends UnmodifiableIterator<T[]> {
            private int index = -2;
            private final Iterable<? extends T>[] iterables;
            private final Iterator<? extends T>[] iterators;
            private final T[] results;

            private ProductIterator(Class<T> clazz, Iterable<? extends T>[] iterableArray) {
                this.iterables = iterableArray;
                this.iterators = Cartesian.createArray(Iterator.class, this.iterables.length);
                for (int i = 0; i < this.iterables.length; ++i) {
                    this.iterators[i] = iterableArray[i].iterator();
                }
                this.results = Cartesian.createArray(clazz, this.iterators.length);
            }

            private void endOfData() {
                this.index = -1;
                Arrays.fill(this.iterators, null);
                Arrays.fill(this.results, null);
            }

            @Override
            public boolean hasNext() {
                if (this.index == -2) {
                    this.index = 0;
                    for (Iterator<T> iterator2 : this.iterators) {
                        if (iterator2.hasNext()) continue;
                        this.endOfData();
                        break;
                    }
                    return true;
                }
                if (this.index >= this.iterators.length) {
                    Iterator<T> iterator3;
                    this.index = this.iterators.length - 1;
                    while (this.index >= 0 && !(iterator3 = this.iterators[this.index]).hasNext()) {
                        if (this.index == 0) {
                            this.endOfData();
                            break;
                        }
                        iterator3 = this.iterables[this.index].iterator();
                        this.iterators[this.index] = iterator3;
                        if (!iterator3.hasNext()) {
                            this.endOfData();
                            break;
                        }
                        --this.index;
                    }
                }
                return this.index >= 0;
            }

            @Override
            public T[] next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                while (this.index < this.iterators.length) {
                    this.results[this.index] = this.iterators[this.index].next();
                    ++this.index;
                }
                return (Object[])this.results.clone();
            }
        }
    }

    public static class GetList<T>
    implements Function<Object[], List<T>> {
        private GetList() {
        }

        @Override
        public List<T> apply(Object[] objectArray) {
            return Arrays.asList(objectArray);
        }
    }
}

