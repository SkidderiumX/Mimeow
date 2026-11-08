/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.ints;

import com.viaversion.viaversion.libs.fastutil.ints.AbstractIntCollection;
import com.viaversion.viaversion.libs.fastutil.ints.IntIterator;
import com.viaversion.viaversion.libs.fastutil.ints.IntSet;
import java.util.Set;

public abstract class AbstractIntSet
extends AbstractIntCollection
implements Cloneable,
IntSet {
    protected AbstractIntSet() {
    }

    @Override
    public abstract IntIterator iterator();

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Set)) {
            return false;
        }
        Set set = (Set)object;
        if (set.size() != this.size()) {
            return false;
        }
        if (set instanceof IntSet) {
            return this.containsAll((IntSet)set);
        }
        return this.containsAll(set);
    }

    @Override
    public int hashCode() {
        int n = 0;
        int n2 = this.size();
        IntIterator intIterator = this.iterator();
        while (n2-- != 0) {
            int n3 = intIterator.nextInt();
            n += n3;
        }
        return n;
    }

    @Override
    public boolean remove(int n) {
        return super.rem(n);
    }

    @Override
    @Deprecated
    public boolean rem(int n) {
        return this.remove(n);
    }
}

