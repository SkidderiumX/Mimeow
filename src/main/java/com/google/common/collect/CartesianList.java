/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.math.IntMath;
import java.util.AbstractList;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import javax.annotation.Nullable;

@GwtCompatible
public class CartesianList<E>
extends AbstractList<List<E>>
implements RandomAccess {
    private final transient ImmutableList<List<E>> axes;
    private final transient int[] axesSizeProduct;

    static <E> List<List<E>> create(List<? extends List<? extends E>> list) {
        ImmutableList.Builder builder = new ImmutableList.Builder(list.size());
        for (List<E> list2 : list) {
            ImmutableList<E> immutableList = ImmutableList.copyOf(list2);
            if (immutableList.isEmpty()) {
                return ImmutableList.of();
            }
            builder.add(immutableList);
        }
        return new CartesianList<E>(builder.build());
    }

    CartesianList(ImmutableList<List<E>> immutableList) {
        this.axes = immutableList;
        int[] nArray = new int[immutableList.size() + 1];
        nArray[immutableList.size()] = 1;
        try {
            for (int i = immutableList.size() - 1; i >= 0; --i) {
                nArray[i] = IntMath.checkedMultiply(nArray[i + 1], ((List)immutableList.get(i)).size());
            }
        }
        catch (ArithmeticException arithmeticException) {
            throw new IllegalArgumentException("Cartesian product too large; must have size at most Integer.MAX_VALUE");
        }
        this.axesSizeProduct = nArray;
    }

    private int getAxisIndexForProductIndex(int n, int n2) {
        return n / this.axesSizeProduct[n2 + 1] % ((List)this.axes.get(n2)).size();
    }

    @Override
    public ImmutableList<E> get(final int n) {
        Preconditions.checkElementIndex(n, this.size());
        return new ImmutableList<E>(){

            @Override
            public int size() {
                return CartesianList.this.axes.size();
            }

            @Override
            public E get(int n3) {
                Preconditions.checkElementIndex(n3, this.size());
                int n2 = CartesianList.this.getAxisIndexForProductIndex(n, n3);
                return ((List)CartesianList.this.axes.get(n3)).get(n2);
            }

            @Override
            boolean isPartialView() {
                return true;
            }
        };
    }

    @Override
    public int size() {
        return this.axesSizeProduct[0];
    }

    @Override
    public boolean contains(@Nullable Object object) {
        if (!(object instanceof List)) {
            return false;
        }
        List list = (List)object;
        if (list.size() != this.axes.size()) {
            return false;
        }
        ListIterator listIterator2 = list.listIterator();
        while (listIterator2.hasNext()) {
            int n = listIterator2.nextIndex();
            if (((List)this.axes.get(n)).contains(listIterator2.next())) continue;
            return false;
        }
        return true;
    }
}

