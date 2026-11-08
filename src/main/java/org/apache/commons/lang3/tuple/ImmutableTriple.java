/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.tuple;

import org.apache.commons.lang3.tuple.Triple;

public class ImmutableTriple<L, M, R>
extends Triple<L, M, R> {
    private static final long serialVersionUID = 1L;
    public final L left;
    public final M middle;
    public final R right;

    public static <L, M, R> ImmutableTriple<L, M, R> of(L l, M m, R r) {
        return new ImmutableTriple<L, M, R>(l, m, r);
    }

    public ImmutableTriple(L l, M m, R r) {
        this.left = l;
        this.middle = m;
        this.right = r;
    }

    @Override
    public L getLeft() {
        return this.left;
    }

    @Override
    public M getMiddle() {
        return this.middle;
    }

    @Override
    public R getRight() {
        return this.right;
    }
}

