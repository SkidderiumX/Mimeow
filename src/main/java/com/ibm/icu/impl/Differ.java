/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.impl;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class Differ<T> {
    private int STACKSIZE;
    private int EQUALSIZE;
    private T[] a;
    private T[] b;
    private T last = null;
    private T next = null;
    private int aCount = 0;
    private int bCount = 0;
    private int aLine = 1;
    private int bLine = 1;
    private int maxSame = 0;
    private int aTop = 0;
    private int bTop = 0;

    public Differ(int n, int n2) {
        this.STACKSIZE = n;
        this.EQUALSIZE = n2;
        this.a = new Object[n + n2];
        this.b = new Object[n + n2];
    }

    public void add(T t, T t2) {
        this.addA(t);
        this.addB(t2);
    }

    public void addA(T t) {
        this.flush();
        this.a[this.aCount++] = t;
    }

    public void addB(T t) {
        this.flush();
        this.b[this.bCount++] = t;
    }

    public int getALine(int n) {
        return this.aLine + this.maxSame + n;
    }

    public T getA(int n) {
        if (n < 0) {
            return this.last;
        }
        if (n > this.aTop - this.maxSame) {
            return this.next;
        }
        return this.a[n];
    }

    public int getACount() {
        return this.aTop - this.maxSame;
    }

    public int getBCount() {
        return this.bTop - this.maxSame;
    }

    public int getBLine(int n) {
        return this.bLine + this.maxSame + n;
    }

    public T getB(int n) {
        if (n < 0) {
            return this.last;
        }
        if (n > this.bTop - this.maxSame) {
            return this.next;
        }
        return this.b[n];
    }

    public void checkMatch(boolean bl) {
        int n;
        int n2 = this.aCount;
        if (n2 > this.bCount) {
            n2 = this.bCount;
        }
        for (n = 0; n < n2 && this.a[n].equals(this.b[n]); ++n) {
        }
        this.aTop = this.bTop = (this.maxSame = n);
        if (this.maxSame > 0) {
            this.last = this.a[this.maxSame - 1];
        }
        this.next = null;
        if (bl) {
            this.aTop = this.aCount;
            this.bTop = this.bCount;
            this.next = null;
            return;
        }
        if (this.aCount - this.maxSame < this.EQUALSIZE || this.bCount - this.maxSame < this.EQUALSIZE) {
            return;
        }
        int n3 = this.find(this.a, this.aCount - this.EQUALSIZE, this.aCount, this.b, this.maxSame, this.bCount);
        if (n3 != -1) {
            this.aTop = this.aCount - this.EQUALSIZE;
            this.bTop = n3;
            this.next = this.a[this.aTop];
            return;
        }
        n3 = this.find(this.b, this.bCount - this.EQUALSIZE, this.bCount, this.a, this.maxSame, this.aCount);
        if (n3 != -1) {
            this.bTop = this.bCount - this.EQUALSIZE;
            this.aTop = n3;
            this.next = this.b[this.bTop];
            return;
        }
        if (this.aCount >= this.STACKSIZE || this.bCount >= this.STACKSIZE) {
            this.aCount = (this.aCount + this.maxSame) / 2;
            this.bCount = (this.bCount + this.maxSame) / 2;
            this.next = null;
        }
    }

    public int find(T[] TArray, int n, int n2, T[] TArray2, int n3, int n4) {
        int n5 = n2 - n;
        int n6 = n4 - n5;
        block0: for (int i = n3; i <= n6; ++i) {
            for (int j = 0; j < n5; ++j) {
                if (!TArray2[i + j].equals(TArray[n + j])) continue block0;
            }
            return i;
        }
        return -1;
    }

    private void flush() {
        int n;
        if (this.aTop != 0) {
            n = this.aCount - this.aTop;
            System.arraycopy(this.a, this.aTop, this.a, 0, n);
            this.aCount = n;
            this.aLine += this.aTop;
            this.aTop = 0;
        }
        if (this.bTop != 0) {
            n = this.bCount - this.bTop;
            System.arraycopy(this.b, this.bTop, this.b, 0, n);
            this.bCount = n;
            this.bLine += this.bTop;
            this.bTop = 0;
        }
    }
}

