/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.converter.model;

import com.viaversion.viaversion.libs.mcstructs.converter.model.CodecException;
import com.viaversion.viaversion.libs.mcstructs.converter.model.MergedCodecException;
import java.util.Collection;
import java.util.function.Function;
import lombok.Generated;

public interface Result<T> {
    public static <T> Result<T> success(T t) {
        return new Success(t);
    }

    public static <T> Result<T> error(String string) {
        return new Error(new CodecException(string));
    }

    public static <T> Result<T> error(Throwable throwable) {
        return new Error(new CodecException(throwable));
    }

    public static <T> Result<T> mergeErrors(String string, Collection<Result<?>> collection) {
        return new Error(new MergedCodecException(string, collection));
    }

    public static <T> Result<T> unexpected(Object object, Class<?> ... classArray) {
        String[] stringArray = new String[classArray.length];
        for (int i = 0; i < classArray.length; ++i) {
            stringArray[i] = classArray[i].getSimpleName();
        }
        return Result.unexpected(object, stringArray);
    }

    public static <T> Result<T> unexpected(Object object, String ... stringArray) {
        return Result.error("Expected " + String.join((CharSequence)"/", stringArray) + " but got " + (object == null ? "null" : object.getClass().getSimpleName()));
    }

    public T get();

    public CodecException getError();

    public T getOrThrow(Function<Throwable, ? extends Throwable> var1);

    public T orElse(T var1);

    public T orElseThrow(Function<Throwable, ? extends Throwable> var1);

    public <N> Result<N> map(Function<T, N> var1);

    public <N> Result<N> mapResult(Function<T, Result<N>> var1);

    public <N> Result<N> mapError();

    public boolean isSuccessful();

    public boolean isError();

    public String toString();

    public boolean equals(Object var1);

    public int hashCode();

    public static class Error<T>
    implements Result<T> {
        private final CodecException error;

        private Error(CodecException codecException) {
            this.error = codecException;
        }

        @Override
        public T get() {
            throw this.error;
        }

        @Override
        public CodecException getError() {
            return this.error;
        }

        @Override
        public T getOrThrow(Function<Throwable, ? extends Throwable> function) {
            throw function.apply(this.error);
        }

        @Override
        public T orElse(T t) {
            return t;
        }

        @Override
        public T orElseThrow(Function<Throwable, ? extends Throwable> function) {
            throw function.apply(this.error);
        }

        @Override
        public <N> Result<N> map(Function<T, N> function) {
            return this.mapError();
        }

        @Override
        public <N> Result<N> mapResult(Function<T, Result<N>> function) {
            return this.mapError();
        }

        @Override
        public <N> Result<N> mapError() {
            return this;
        }

        @Override
        public boolean isSuccessful() {
            return false;
        }

        @Override
        public boolean isError() {
            return true;
        }

        @Override
        public String toString() {
            return "Error{" + this.error.getMessage() + "}";
        }

        @Override
        @Generated
        public boolean equals(Object object) {
            if (object == this) {
                return true;
            }
            if (!(object instanceof Error)) {
                return false;
            }
            Error error = (Error)object;
            if (!error.canEqual(this)) {
                return false;
            }
            CodecException codecException = this.getError();
            CodecException codecException2 = error.getError();
            return !(codecException == null ? codecException2 != null : !codecException.equals(codecException2));
        }

        @Generated
        protected boolean canEqual(Object object) {
            return object instanceof Error;
        }

        @Override
        @Generated
        public int hashCode() {
            int n = 59;
            int n2 = 1;
            CodecException codecException = this.getError();
            n2 = n2 * 59 + (codecException == null ? 43 : codecException.hashCode());
            return n2;
        }
    }

    public static class Success<T>
    implements Result<T> {
        private final T result;

        private Success(T t) {
            this.result = t;
        }

        @Override
        public T get() {
            return this.result;
        }

        @Override
        public CodecException getError() {
            return null;
        }

        @Override
        public T getOrThrow(Function<Throwable, ? extends Throwable> function) {
            return this.result;
        }

        @Override
        public T orElse(T t) {
            return this.result;
        }

        @Override
        public T orElseThrow(Function<Throwable, ? extends Throwable> function) {
            return this.result;
        }

        @Override
        public <N> Result<N> map(Function<T, N> function) {
            return Result.success(function.apply(this.result));
        }

        @Override
        public <N> Result<N> mapResult(Function<T, Result<N>> function) {
            return function.apply(this.result);
        }

        @Override
        public <N> Result<N> mapError() {
            return Result.error("No error");
        }

        @Override
        public boolean isSuccessful() {
            return true;
        }

        @Override
        public boolean isError() {
            return false;
        }

        @Override
        public String toString() {
            return "Success{" + this.result + "}";
        }

        @Override
        @Generated
        public boolean equals(Object object) {
            if (object == this) {
                return true;
            }
            if (!(object instanceof Success)) {
                return false;
            }
            Success success = (Success)object;
            if (!success.canEqual(this)) {
                return false;
            }
            T t = this.result;
            T t2 = success.result;
            return !(t == null ? t2 != null : !t.equals(t2));
        }

        @Generated
        protected boolean canEqual(Object object) {
            return object instanceof Success;
        }

        @Override
        @Generated
        public int hashCode() {
            int n = 59;
            int n2 = 1;
            T t = this.result;
            n2 = n2 * 59 + (t == null ? 43 : t.hashCode());
            return n2;
        }
    }
}

