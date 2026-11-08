/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.impl;

import com.ibm.icu.impl.Trie;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CharTrie
extends Trie {
    private char m_initialValue_;
    private char[] m_data_;

    public CharTrie(InputStream inputStream2, Trie.DataManipulate dataManipulate) throws IOException {
        super(inputStream2, dataManipulate);
        if (!this.isCharTrie()) {
            throw new IllegalArgumentException("Data given does not belong to a char trie.");
        }
    }

    public CharTrie(int n, int n2, Trie.DataManipulate dataManipulate) {
        super(new char[2080], 512, dataManipulate);
        int n3;
        int n4 = 256;
        int n5 = 256;
        if (n2 != n) {
            n5 += 32;
        }
        this.m_data_ = new char[n5];
        this.m_dataLength_ = n5;
        this.m_initialValue_ = (char)n;
        for (n3 = 0; n3 < n4; ++n3) {
            this.m_data_[n3] = (char)n;
        }
        if (n2 != n) {
            char c = (char)(n4 >> 2);
            int n6 = 1760;
            for (n3 = 1728; n3 < n6; ++n3) {
                this.m_index_[n3] = c;
            }
            n6 = n4 + 32;
            for (n3 = n4; n3 < n6; ++n3) {
                this.m_data_[n3] = (char)n2;
            }
        }
    }

    public final char getCodePointValue(int n) {
        if (0 <= n && n < 55296) {
            int n2 = (this.m_index_[n >> 5] << 2) + (n & 0x1F);
            return this.m_data_[n2];
        }
        int n3 = this.getCodePointOffset(n);
        return n3 >= 0 ? this.m_data_[n3] : this.m_initialValue_;
    }

    public final char getLeadValue(char c) {
        return this.m_data_[this.getLeadOffset(c)];
    }

    public final char getBMPValue(char c) {
        return this.m_data_[this.getBMPOffset(c)];
    }

    public final char getSurrogateValue(char c, char c2) {
        int n = this.getSurrogateOffset(c, c2);
        if (n > 0) {
            return this.m_data_[n];
        }
        return this.m_initialValue_;
    }

    public final char getTrailValue(int n, char c) {
        if (this.m_dataManipulate_ == null) {
            throw new NullPointerException("The field DataManipulate in this Trie is null");
        }
        int n2 = this.m_dataManipulate_.getFoldingOffset(n);
        if (n2 > 0) {
            return this.m_data_[this.getRawOffset(n2, (char)(c & 0x3FF))];
        }
        return this.m_initialValue_;
    }

    public final char getLatin1LinearValue(char c) {
        return this.m_data_[32 + this.m_dataOffset_ + c];
    }

    public boolean equals(Object object) {
        boolean bl = super.equals(object);
        if (bl && object instanceof CharTrie) {
            CharTrie charTrie = (CharTrie)object;
            return this.m_initialValue_ == charTrie.m_initialValue_;
        }
        return false;
    }

    public int hashCode() {
        assert (false) : "hashCode not designed";
        return 42;
    }

    protected final void unserialize(InputStream inputStream2) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(inputStream2);
        int n = this.m_dataOffset_ + this.m_dataLength_;
        this.m_index_ = new char[n];
        for (int i = 0; i < n; ++i) {
            this.m_index_[i] = dataInputStream.readChar();
        }
        this.m_data_ = this.m_index_;
        this.m_initialValue_ = this.m_data_[this.m_dataOffset_];
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
}

