/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.hash.AbstractStreamingHashFunction;
import com.google.common.hash.Funnel;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;
import java.nio.charset.Charset;

public abstract class AbstractCompositeHashFunction
extends AbstractStreamingHashFunction {
    final HashFunction[] functions;
    private static final long serialVersionUID = 0L;

    AbstractCompositeHashFunction(HashFunction ... hashFunctionArray) {
        for (HashFunction hashFunction : hashFunctionArray) {
            Preconditions.checkNotNull(hashFunction);
        }
        this.functions = hashFunctionArray;
    }

    abstract HashCode makeHash(Hasher[] var1);

    @Override
    public Hasher newHasher() {
        final Hasher[] hasherArray = new Hasher[this.functions.length];
        for (int i = 0; i < hasherArray.length; ++i) {
            hasherArray[i] = this.functions[i].newHasher();
        }
        return new Hasher(){

            @Override
            public Hasher putByte(byte by) {
                for (Hasher hasher : hasherArray) {
                    hasher.putByte(by);
                }
                return this;
            }

            @Override
            public Hasher putBytes(byte[] byArray) {
                for (Hasher hasher : hasherArray) {
                    hasher.putBytes(byArray);
                }
                return this;
            }

            @Override
            public Hasher putBytes(byte[] byArray, int n, int n2) {
                for (Hasher hasher : hasherArray) {
                    hasher.putBytes(byArray, n, n2);
                }
                return this;
            }

            @Override
            public Hasher putShort(short s) {
                for (Hasher hasher : hasherArray) {
                    hasher.putShort(s);
                }
                return this;
            }

            @Override
            public Hasher putInt(int n) {
                for (Hasher hasher : hasherArray) {
                    hasher.putInt(n);
                }
                return this;
            }

            @Override
            public Hasher putLong(long l) {
                for (Hasher hasher : hasherArray) {
                    hasher.putLong(l);
                }
                return this;
            }

            @Override
            public Hasher putFloat(float f) {
                for (Hasher hasher : hasherArray) {
                    hasher.putFloat(f);
                }
                return this;
            }

            @Override
            public Hasher putDouble(double d) {
                for (Hasher hasher : hasherArray) {
                    hasher.putDouble(d);
                }
                return this;
            }

            @Override
            public Hasher putBoolean(boolean bl) {
                for (Hasher hasher : hasherArray) {
                    hasher.putBoolean(bl);
                }
                return this;
            }

            @Override
            public Hasher putChar(char c) {
                for (Hasher hasher : hasherArray) {
                    hasher.putChar(c);
                }
                return this;
            }

            @Override
            public Hasher putUnencodedChars(CharSequence charSequence) {
                for (Hasher hasher : hasherArray) {
                    hasher.putUnencodedChars(charSequence);
                }
                return this;
            }

            @Override
            public Hasher putString(CharSequence charSequence, Charset charset) {
                for (Hasher hasher : hasherArray) {
                    hasher.putString(charSequence, charset);
                }
                return this;
            }

            @Override
            public <T> Hasher putObject(T t, Funnel<? super T> funnel) {
                for (Hasher hasher : hasherArray) {
                    hasher.putObject(t, funnel);
                }
                return this;
            }

            @Override
            public HashCode hash() {
                return AbstractCompositeHashFunction.this.makeHash(hasherArray);
            }
        };
    }
}

