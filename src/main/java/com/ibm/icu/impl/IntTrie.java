/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.impl;

import com.ibm.icu.impl.Trie;
import com.ibm.icu.text.UTF16;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class IntTrie
extends Trie {
    private int m_initialValue_;
    private int[] m_data_;

    public IntTrie(InputStream inputStream2, Trie.DataManipulate dataManipulate) throws IOException {
        super(inputStream2, dataManipulate);
        if (!this.isIntTrie()) {
            throw new IllegalArgumentException("Data given does not belong to a int trie.");
        }
    }

    public IntTrie(int n, int n2, Trie.DataManipulate dataManipulate) {
        super(new char[2080], 512, dataManipulate);
        int n3;
        int n4 = 256;
        int n5 = 256;
        if (n2 != n) {
            n5 += 32;
        }
        this.m_data_ = new int[n5];
        this.m_dataLength_ = n5;
        this.m_initialValue_ = n;
        for (n3 = 0; n3 < n4; ++n3) {
            this.m_data_[n3] = n;
        }
        if (n2 != n) {
            char c = (char)(n4 >> 2);
            int n6 = 1760;
            for (n3 = 1728; n3 < n6; ++n3) {
                this.m_index_[n3] = c;
            }
            n6 = n4 + 32;
            for (n3 = n4; n3 < n6; ++n3) {
                this.m_data_[n3] = n2;
            }
        }
    }

    public final int getCodePointValue(int n) {
        if (0 <= n && n < 55296) {
            int n2 = (this.m_index_[n >> 5] << 2) + (n & 0x1F);
            return this.m_data_[n2];
        }
        int n3 = this.getCodePointOffset(n);
        return n3 >= 0 ? this.m_data_[n3] : this.m_initialValue_;
    }

    public final int getLeadValue(char c) {
        return this.m_data_[this.getLeadOffset(c)];
    }

    public final int getBMPValue(char c) {
        return this.m_data_[this.getBMPOffset(c)];
    }

    public final int getSurrogateValue(char c, char c2) {
        if (!UTF16.isLeadSurrogate(c) || !UTF16.isTrailSurrogate(c2)) {
            throw new IllegalArgumentException("Argument characters do not form a supplementary character");
        }
        int n = this.getSurrogateOffset(c, c2);
        if (n > 0) {
            return this.m_data_[n];
        }
        return this.m_initialValue_;
    }

    public final int getTrailValue(int n, char c) {
        if (this.m_dataManipulate_ == null) {
            throw new NullPointerException("The field DataManipulate in this Trie is null");
        }
        int n2 = this.m_dataManipulate_.getFoldingOffset(n);
        if (n2 > 0) {
            return this.m_data_[this.getRawOffset(n2, (char)(c & 0x3FF))];
        }
        return this.m_initialValue_;
    }

    public final int getLatin1LinearValue(char c) {
        return this.m_data_[32 + c];
    }

    public boolean equals(Object object) {
        boolean bl = super.equals(object);
        if (bl && object instanceof IntTrie) {
            IntTrie intTrie = (IntTrie)object;
            return this.m_initialValue_ == intTrie.m_initialValue_ && Arrays.equals(this.m_data_, intTrie.m_data_);
        }
        return false;
    }

    public int hashCode() {
        assert (false) : "hashCode not designed";
        return 42;
    }

    protected final void unserialize(InputStream inputStream2) throws IOException {
        super.unserialize(inputStream2);
        this.m_data_ = new int[this.m_dataLength_];
        DataInputStream dataInputStream = new DataInputStream(inputStream2);
        for (int i = 0; i < this.m_dataLength_; ++i) {
            this.m_data_[i] = dataInputStream.readInt();
        }
        this.m_initialValue_ = this.m_data_[0];
    }

    protected final int getSurrogateOffset(char c, char c2) {
        if (this.m_dataManipulate_ == null) {
            throw new NullPointerException("The field DataManipulate in this Trie is null");
        }
        int n = this.m_dataManipulate_.getFoldingOffset(this.getLeadValue(c));
        if (n > 0) {
            return this.getRawOffset(n, (char)(c2 & 0x3FF));
        }
        return -1;
    }

    protected final int getValue(int n) {
        return this.m_data_[n];
    }

    protected final int getInitialValue() {
        return this.m_initialValue_;
    }

    IntTrie(char[] cArray, int[] nArray, int n, int n2, Trie.DataManipulate dataManipulate) {
        super(cArray, n2, dataManipulate);
        this.m_data_ = nArray;
        this.m_dataLength_ = this.m_data_.length;
        this.m_initialValue_ = n;
    }
}

