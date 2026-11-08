/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.impl;

import com.ibm.icu.impl.Utility;
import com.ibm.icu.util.Freezable;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class Row<C0, C1, C2, C3, C4>
implements Comparable,
Cloneable,
Freezable<Row<C0, C1, C2, C3, C4>> {
    protected Object[] items;
    protected boolean frozen;

    public static <C0, C1> R2<C0, C1> of(C0 C0, C1 C1) {
        return new R2<C0, C1>(C0, C1);
    }

    public static <C0, C1, C2> R3<C0, C1, C2> of(C0 C0, C1 C1, C2 C2) {
        return new R3<C0, C1, C2>(C0, C1, C2);
    }

    public static <C0, C1, C2, C3> R4<C0, C1, C2, C3> of(C0 C0, C1 C1, C2 C2, C3 C3) {
        return new R4<C0, C1, C2, C3>(C0, C1, C2, C3);
    }

    public static <C0, C1, C2, C3, C4> R5<C0, C1, C2, C3, C4> of(C0 C0, C1 C1, C2 C2, C3 C3, C4 C4) {
        return new R5<C0, C1, C2, C3, C4>(C0, C1, C2, C3, C4);
    }

    public Row<C0, C1, C2, C3, C4> set0(C0 C0) {
        return this.set(0, C0);
    }

    public C0 get0() {
        return (C0)this.items[0];
    }

    public Row<C0, C1, C2, C3, C4> set1(C1 C1) {
        return this.set(1, C1);
    }

    public C1 get1() {
        return (C1)this.items[1];
    }

    public Row<C0, C1, C2, C3, C4> set2(C2 C2) {
        return this.set(2, C2);
    }

    public C2 get2() {
        return (C2)this.items[2];
    }

    public Row<C0, C1, C2, C3, C4> set3(C3 C3) {
        return this.set(3, C3);
    }

    public C3 get3() {
        return (C3)this.items[3];
    }

    public Row<C0, C1, C2, C3, C4> set4(C4 C4) {
        return this.set(4, C4);
    }

    public C4 get4() {
        return (C4)this.items[4];
    }

    protected Row<C0, C1, C2, C3, C4> set(int n, Object object) {
        if (this.frozen) {
            throw new UnsupportedOperationException("Attempt to modify frozen object");
        }
        this.items[n] = object;
        return this;
    }

    public int hashCode() {
        int n = this.items.length;
        for (Object object : this.items) {
            n = n * 37 + Utility.checkHash(object);
        }
        return n;
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (this == object) {
            return true;
        }
        try {
            Row row = (Row)object;
            if (this.items.length != row.items.length) {
                return false;
            }
            int n = 0;
            for (Object object2 : this.items) {
                if (Utility.objectEquals(object2, row.items[n++])) continue;
                return false;
            }
            return true;
        }
        catch (Exception exception) {
            return false;
        }
    }

    public int compareTo(Object object) {
        Row row = (Row)object;
        int n = this.items.length - row.items.length;
        if (n != 0) {
            return n;
        }
        int n2 = 0;
        for (Object object2 : this.items) {
            if ((n = Utility.checkCompare((Comparable)object2, (Comparable)row.items[n2++])) == 0) continue;
            return n;
        }
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        boolean bl = true;
        for (Object object : this.items) {
            if (bl) {
                bl = false;
            } else {
                stringBuilder.append(", ");
            }
            stringBuilder.append(object);
        }
        return stringBuilder.append("]").toString();
    }

    @Override
    public boolean isFrozen() {
        return this.frozen;
    }

    @Override
    public Row<C0, C1, C2, C3, C4> freeze() {
        this.frozen = true;
        return this;
    }

    public Object clone() {
        if (this.frozen) {
            return this;
        }
        try {
            Row row = (Row)super.clone();
            this.items = (Object[])this.items.clone();
            return row;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            return null;
        }
    }

    @Override
    public Row<C0, C1, C2, C3, C4> cloneAsThawed() {
        try {
            Row row = (Row)super.clone();
            this.items = (Object[])this.items.clone();
            row.frozen = false;
            return row;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            return null;
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static class R5<C0, C1, C2, C3, C4>
    extends Row<C0, C1, C2, C3, C4> {
        public R5(C0 C0, C1 C1, C2 C2, C3 C3, C4 C4) {
            this.items = new Object[]{C0, C1, C2, C3, C4};
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static class R4<C0, C1, C2, C3>
    extends Row<C0, C1, C2, C3, C3> {
        public R4(C0 C0, C1 C1, C2 C2, C3 C3) {
            this.items = new Object[]{C0, C1, C2, C3};
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static class R3<C0, C1, C2>
    extends Row<C0, C1, C2, C2, C2> {
        public R3(C0 C0, C1 C1, C2 C2) {
            this.items = new Object[]{C0, C1, C2};
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static class R2<C0, C1>
    extends Row<C0, C1, C1, C1, C1> {
        public R2(C0 C0, C1 C1) {
            this.items = new Object[]{C0, C1};
        }
    }
}

