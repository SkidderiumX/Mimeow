/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.objects;

import com.viaversion.viaversion.libs.fastutil.objects.AbstractReferenceCollection;
import com.viaversion.viaversion.libs.fastutil.objects.ObjectIterator;
import com.viaversion.viaversion.libs.fastutil.objects.ReferenceSet;
import java.util.Iterator;
import java.util.Set;

public abstract class AbstractReferenceSet<K>
extends AbstractReferenceCollection<K>
implements Cloneable,
ReferenceSet<K> {
    protected AbstractReferenceSet() {
    }

    @Override
    public abstract ObjectIterator<K> iterator();

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
        return this.containsAll(set);
    }

    @Override
    public int hashCode() {
        int n = 0;
        int n2 = this.size();
        Iterator iterator2 = this.iterator();
        while (n2-- != 0) {
            Object e = iterator2.next();
            n += System.identityHashCode(e);
        }
        return n;
    }
}

