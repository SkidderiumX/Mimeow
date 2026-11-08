/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.util.glu.tessellation;

import org.lwjgl.util.glu.tessellation.PriorityQ;
import org.lwjgl.util.glu.tessellation.PriorityQHeap;

public class PriorityQSort
extends PriorityQ {
    PriorityQHeap heap;
    Object[] keys;
    int[] order;
    int size;
    int max;
    boolean initialized;
    PriorityQ.Leq leq;

    PriorityQSort(PriorityQ.Leq leq) {
        this.heap = new PriorityQHeap(leq);
        this.keys = new Object[32];
        this.size = 0;
        this.max = 32;
        this.initialized = false;
        this.leq = leq;
    }

    @Override
    void pqDeletePriorityQ() {
        if (this.heap != null) {
            this.heap.pqDeletePriorityQ();
        }
        this.order = null;
        this.keys = null;
    }

    private static boolean LT(PriorityQ.Leq leq, Object object, Object object2) {
        return !PriorityQSort.LEQ(leq, object2, object);
    }

    private static boolean GT(PriorityQ.Leq leq, Object object, Object object2) {
        return !PriorityQSort.LEQ(leq, object, object2);
    }

    private static void Swap(int[] nArray, int n, int n2) {
        int n3 = nArray[n];
        nArray[n] = nArray[n2];
        nArray[n2] = n3;
    }

    @Override
    boolean pqInit() {
        int n;
        int n2;
        Stack[] stackArray = new Stack[50];
        for (n2 = 0; n2 < stackArray.length; ++n2) {
            stackArray[n2] = new Stack();
        }
        n2 = 0;
        int n3 = 2016473283;
        this.order = new int[this.size + 1];
        int n4 = 0;
        int n5 = this.size - 1;
        int n6 = 0;
        for (n = n4; n <= n5; ++n) {
            this.order[n] = n6++;
        }
        stackArray[n2].p = n4;
        stackArray[n2].r = n5;
        ++n2;
        while (--n2 >= 0) {
            int n7;
            n4 = stackArray[n2].p;
            n5 = stackArray[n2].r;
            while (n5 > n4 + 10) {
                n3 = Math.abs(n3 * 1539415821 + 1);
                n = n4 + n3 % (n5 - n4 + 1);
                n6 = this.order[n];
                this.order[n] = this.order[n4];
                this.order[n4] = n6;
                n = n4 - 1;
                n7 = n5 + 1;
                while (true) {
                    if (PriorityQSort.GT(this.leq, this.keys[this.order[++n]], this.keys[n6])) {
                        continue;
                    }
                    while (PriorityQSort.LT(this.leq, this.keys[this.order[--n7]], this.keys[n6])) {
                    }
                    PriorityQSort.Swap(this.order, n, n7);
                    if (n >= n7) break;
                }
                PriorityQSort.Swap(this.order, n, n7);
                if (n - n4 < n5 - n7) {
                    stackArray[n2].p = n7 + 1;
                    stackArray[n2].r = n5;
                    ++n2;
                    n5 = n - 1;
                    continue;
                }
                stackArray[n2].p = n4;
                stackArray[n2].r = n - 1;
                ++n2;
                n4 = n7 + 1;
            }
            for (n = n4 + 1; n <= n5; ++n) {
                n6 = this.order[n];
                for (n7 = n; n7 > n4 && PriorityQSort.LT(this.leq, this.keys[this.order[n7 - 1]], this.keys[n6]); --n7) {
                    this.order[n7] = this.order[n7 - 1];
                }
                this.order[n7] = n6;
            }
        }
        this.max = this.size;
        this.initialized = true;
        this.heap.pqInit();
        return true;
    }

    @Override
    int pqInsert(Object object) {
        if (this.initialized) {
            return this.heap.pqInsert(object);
        }
        int n = this.size++;
        if (this.size >= this.max) {
            Object[] objectArray = this.keys;
            this.max <<= 1;
            Object[] objectArray2 = new Object[this.max];
            System.arraycopy(this.keys, 0, objectArray2, 0, this.keys.length);
            this.keys = objectArray2;
            if (this.keys == null) {
                this.keys = objectArray;
                return Integer.MAX_VALUE;
            }
        }
        assert (n != Integer.MAX_VALUE);
        this.keys[n] = object;
        return -(n + 1);
    }

    @Override
    Object pqExtractMin() {
        Object object;
        if (this.size == 0) {
            return this.heap.pqExtractMin();
        }
        Object object2 = this.keys[this.order[this.size - 1]];
        if (!this.heap.pqIsEmpty() && PriorityQSort.LEQ(this.leq, object = this.heap.pqMinimum(), object2)) {
            return this.heap.pqExtractMin();
        }
        do {
            --this.size;
        } while (this.size > 0 && this.keys[this.order[this.size - 1]] == null);
        return object2;
    }

    @Override
    Object pqMinimum() {
        Object object;
        if (this.size == 0) {
            return this.heap.pqMinimum();
        }
        Object object2 = this.keys[this.order[this.size - 1]];
        if (!this.heap.pqIsEmpty() && PriorityQSort.LEQ(this.leq, object = this.heap.pqMinimum(), object2)) {
            return object;
        }
        return object2;
    }

    @Override
    boolean pqIsEmpty() {
        return this.size == 0 && this.heap.pqIsEmpty();
    }

    @Override
    void pqDelete(int n) {
        if (n >= 0) {
            this.heap.pqDelete(n);
            return;
        }
        n = -(n + 1);
        assert (n < this.max && this.keys[n] != null);
        this.keys[n] = null;
        while (this.size > 0 && this.keys[this.order[this.size - 1]] == null) {
            --this.size;
        }
    }

    private static class Stack {
        int p;
        int r;

        private Stack() {
        }
    }
}

