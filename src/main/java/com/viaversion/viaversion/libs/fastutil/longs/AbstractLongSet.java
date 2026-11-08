/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.longs;

import com.viaversion.viaversion.libs.fastutil.HashCommon;
import com.viaversion.viaversion.libs.fastutil.longs.AbstractLongCollection;
import com.viaversion.viaversion.libs.fastutil.longs.LongIterator;
import com.viaversion.viaversion.libs.fastutil.longs.LongSet;
import java.util.Set;

public abstract class AbstractLongSet
extends AbstractLongCollection
implements Cloneable,
LongSet {
    protected AbstractLongSet() {
    }

    @Override
    public abstract LongIterator iterator();

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
        if (set instanceof LongSet) {
            return this.containsAll((LongSet)set);
        }
        return this.containsAll(set);
    }

    @Override
    public int hashCode() {
        int n = 0;
        int n2 = this.size();
        LongIterator longIterator = this.iterator();
        while (n2-- != 0) {
            long l = longIterator.nextLong();
            n += HashCommon.long2int(l);
        }
        return n;
    }

    @Override
    public boolean remove(long l) {
        return super.rem(l);
    }

    @Override
    @Deprecated
    public boolean rem(long l) {
        return this.remove(l);
    }
}

