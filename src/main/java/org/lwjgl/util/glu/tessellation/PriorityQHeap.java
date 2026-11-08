/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.util.glu.tessellation;

import org.lwjgl.util.glu.tessellation.PriorityQ;

public class PriorityQHeap
extends PriorityQ {
    PriorityQ.PQnode[] nodes = new PriorityQ.PQnode[33];
    PriorityQ.PQhandleElem[] handles;
    int size = 0;
    int max = 32;
    int freeList;
    boolean initialized;
    PriorityQ.Leq leq;

    PriorityQHeap(PriorityQ.Leq leq) {
        int n;
        for (n = 0; n < this.nodes.length; ++n) {
            this.nodes[n] = new PriorityQ.PQnode();
        }
        this.handles = new PriorityQ.PQhandleElem[33];
        for (n = 0; n < this.handles.length; ++n) {
            this.handles[n] = new PriorityQ.PQhandleElem();
        }
        this.initialized = false;
        this.freeList = 0;
        this.leq = leq;
        this.nodes[1].handle = 1;
        this.handles[1].key = null;
    }

    @Override
    void pqDeletePriorityQ() {
        this.handles = null;
        this.nodes = null;
    }

    void FloatDown(int n) {
        PriorityQ.PQnode[] pQnodeArray = this.nodes;
        PriorityQ.PQhandleElem[] pQhandleElemArray = this.handles;
        int n2 = pQnodeArray[n].handle;
        while (true) {
            int n3;
            if ((n3 = n << 1) < this.size && PriorityQHeap.LEQ(this.leq, pQhandleElemArray[pQnodeArray[n3 + 1].handle].key, pQhandleElemArray[pQnodeArray[n3].handle].key)) {
                ++n3;
            }
            assert (n3 <= this.max);
            int n4 = pQnodeArray[n3].handle;
            if (n3 > this.size || PriorityQHeap.LEQ(this.leq, pQhandleElemArray[n2].key, pQhandleElemArray[n4].key)) break;
            pQnodeArray[n].handle = n4;
            pQhandleElemArray[n4].node = n;
            n = n3;
        }
        pQnodeArray[n].handle = n2;
        pQhandleElemArray[n2].node = n;
    }

    void FloatUp(int n) {
        PriorityQ.PQnode[] pQnodeArray = this.nodes;
        PriorityQ.PQhandleElem[] pQhandleElemArray = this.handles;
        int n2 = pQnodeArray[n].handle;
        while (true) {
            int n3 = n >> 1;
            int n4 = pQnodeArray[n3].handle;
            if (n3 == 0 || PriorityQHeap.LEQ(this.leq, pQhandleElemArray[n4].key, pQhandleElemArray[n2].key)) break;
            pQnodeArray[n].handle = n4;
            pQhandleElemArray[n4].node = n;
            n = n3;
        }
        pQnodeArray[n].handle = n2;
        pQhandleElemArray[n2].node = n;
    }

    @Override
    boolean pqInit() {
        for (int i = this.size; i >= 1; --i) {
            this.FloatDown(i);
        }
        this.initialized = true;
        return true;
    }

    @Override
    int pqInsert(Object object) {
        int n;
        int n2;
        if ((n2 = ++this.size) * 2 > this.max) {
            PriorityQ.PQnode[] pQnodeArray = this.nodes;
            PriorityQ.PQhandleElem[] pQhandleElemArray = this.handles;
            this.max <<= 1;
            PriorityQ.PQnode[] pQnodeArray2 = new PriorityQ.PQnode[this.max + 1];
            System.arraycopy(this.nodes, 0, pQnodeArray2, 0, this.nodes.length);
            for (int i = this.nodes.length; i < pQnodeArray2.length; ++i) {
                pQnodeArray2[i] = new PriorityQ.PQnode();
            }
            this.nodes = pQnodeArray2;
            if (this.nodes == null) {
                this.nodes = pQnodeArray;
                return Integer.MAX_VALUE;
            }
            PriorityQ.PQhandleElem[] pQhandleElemArray2 = new PriorityQ.PQhandleElem[this.max + 1];
            System.arraycopy(this.handles, 0, pQhandleElemArray2, 0, this.handles.length);
            for (int i = this.handles.length; i < pQhandleElemArray2.length; ++i) {
                pQhandleElemArray2[i] = new PriorityQ.PQhandleElem();
            }
            this.handles = pQhandleElemArray2;
            if (this.handles == null) {
                this.handles = pQhandleElemArray;
                return Integer.MAX_VALUE;
            }
        }
        if (this.freeList == 0) {
            n = n2;
        } else {
            n = this.freeList;
            this.freeList = this.handles[n].node;
        }
        this.nodes[n2].handle = n;
        this.handles[n].node = n2;
        this.handles[n].key = object;
        if (this.initialized) {
            this.FloatUp(n2);
        }
        assert (n != Integer.MAX_VALUE);
        return n;
    }

    @Override
    Object pqExtractMin() {
        PriorityQ.PQnode[] pQnodeArray = this.nodes;
        PriorityQ.PQhandleElem[] pQhandleElemArray = this.handles;
        int n = pQnodeArray[1].handle;
        Object object = pQhandleElemArray[n].key;
        if (this.size > 0) {
            pQnodeArray[1].handle = pQnodeArray[this.size].handle;
            pQhandleElemArray[pQnodeArray[1].handle].node = 1;
            pQhandleElemArray[n].key = null;
            pQhandleElemArray[n].node = this.freeList;
            this.freeList = n;
            if (--this.size > 0) {
                this.FloatDown(1);
            }
        }
        return object;
    }

    @Override
    void pqDelete(int n) {
        PriorityQ.PQnode[] pQnodeArray = this.nodes;
        PriorityQ.PQhandleElem[] pQhandleElemArray = this.handles;
        assert (n >= 1 && n <= this.max && pQhandleElemArray[n].key != null);
        int n2 = pQhandleElemArray[n].node;
        pQnodeArray[n2].handle = pQnodeArray[this.size].handle;
        pQhandleElemArray[pQnodeArray[n2].handle].node = n2;
        if (n2 <= --this.size) {
            if (n2 <= 1 || PriorityQHeap.LEQ(this.leq, pQhandleElemArray[pQnodeArray[n2 >> 1].handle].key, pQhandleElemArray[pQnodeArray[n2].handle].key)) {
                this.FloatDown(n2);
            } else {
                this.FloatUp(n2);
            }
        }
        pQhandleElemArray[n].key = null;
        pQhandleElemArray[n].node = this.freeList;
        this.freeList = n;
    }

    @Override
    Object pqMinimum() {
        return this.handles[this.nodes[1].handle].key;
    }

    @Override
    boolean pqIsEmpty() {
        return this.size == 0;
    }
}

