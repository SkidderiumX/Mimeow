/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.converter.model;

import java.util.function.Function;
import javax.annotation.Nonnull;
import lombok.Generated;

public interface Either<L, R> {
    public static <L, R> Either<L, R> left(@Nonnull L l) {
        return new Left(l);
    }

    public static <L, R> Either<L, R> right(@Nonnull R r) {
        return new Right(r);
    }

    public static <T> T unwrap(Either<? extends T, ? extends T> either) {
        return either.isLeft() ? either.getLeft() : either.getRight();
    }

    public L getLeft();

    public R getRight();

    public boolean isLeft();

    public boolean isRight();

    public <ML, MR> Either<ML, MR> map(Function<L, ML> var1, Function<R, MR> var2);

    public <T> T xmap(Function<L, T> var1, Function<R, T> var2);

    public Either<R, L> swap();

    public String toString();

    public boolean equals(Object var1);

    public int hashCode();

    public static class Right<L, R>
    implements Either<L, R> {
        private final R right;

        private Right(R r) {
            this.right = r;
        }

        @Override
        public L getLeft() {
            return null;
        }

        @Override
        public R getRight() {
            return this.right;
        }

        @Override
        public boolean isLeft() {
            return false;
        }

        @Override
        public boolean isRight() {
            return true;
        }

        @Override
        public <ML, MR> Either<ML, MR> map(Function<L, ML> function, Function<R, MR> function2) {
            return Either.right(function2.apply(this.right));
        }

        @Override
        public <T> T xmap(Function<L, T> function, Function<R, T> function2) {
            return function2.apply(this.right);
        }

        @Override
        public Either<R, L> swap() {
            return Either.left(this.right);
        }

        @Override
        public String toString() {
            return "Right{" + this.getRight() + "}";
        }

        @Override
        @Generated
        public boolean equals(Object object) {
            if (object == this) {
                return true;
            }
            if (!(object instanceof Right)) {
                return false;
            }
            Right right = (Right)object;
            if (!right.canEqual(this)) {
                return false;
            }
            R r = this.getRight();
            R r2 = right.getRight();
            return !(r == null ? r2 != null : !r.equals(r2));
        }

        @Generated
        protected boolean canEqual(Object object) {
            return object instanceof Right;
        }

        @Override
        @Generated
        public int hashCode() {
            int n = 59;
            int n2 = 1;
            R r = this.getRight();
            n2 = n2 * 59 + (r == null ? 43 : r.hashCode());
            return n2;
        }
    }

    public static class Left<L, R>
    implements Either<L, R> {
        private final L left;

        private Left(L l) {
            this.left = l;
        }

        @Override
        public L getLeft() {
            return this.left;
        }

        @Override
        public R getRight() {
            return null;
        }

        @Override
        public boolean isLeft() {
            return true;
        }

        @Override
        public boolean isRight() {
            return false;
        }

        @Override
        public <ML, MR> Either<ML, MR> map(Function<L, ML> function, Function<R, MR> function2) {
            return Either.left(function.apply(this.getLeft()));
        }

        @Override
        public <T> T xmap(Function<L, T> function, Function<R, T> function2) {
            return function.apply(this.getLeft());
        }

        @Override
        public Either<R, L> swap() {
            return Either.right(this.left);
        }

        @Override
        public String toString() {
            return "Left{" + this.getLeft() + "}";
        }

        @Override
        @Generated
        public boolean equals(Object object) {
            if (object == this) {
                return true;
            }
            if (!(object instanceof Left)) {
                return false;
            }
            Left left = (Left)object;
            if (!left.canEqual(this)) {
                return false;
            }
            L l = this.getLeft();
            L l2 = left.getLeft();
            return !(l == null ? l2 != null : !l.equals(l2));
        }

        @Generated
        protected boolean canEqual(Object object) {
            return object instanceof Left;
        }

        @Override
        @Generated
        public int hashCode() {
            int n = 59;
            int n2 = 1;
            L l = this.getLeft();
            n2 = n2 * 59 + (l == null ? 43 : l.hashCode());
            return n2;
        }
    }
}

