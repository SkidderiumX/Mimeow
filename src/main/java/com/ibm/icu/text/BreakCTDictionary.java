/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.text;

import com.ibm.icu.impl.ICUBinary;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.CharacterIterator;

public class BreakCTDictionary {
    private CompactTrieHeader fData;
    private CompactTrieNodes[] nodes;
    private static final byte[] DATA_FORMAT_ID = new byte[]{84, 114, 68, 99};

    private CompactTrieNodes getCompactTrieNode(int n) {
        return this.nodes[n];
    }

    public BreakCTDictionary(InputStream inputStream2) throws IOException {
        ICUBinary.readHeader(inputStream2, DATA_FORMAT_ID, null);
        DataInputStream dataInputStream = new DataInputStream(inputStream2);
        this.fData = new CompactTrieHeader();
        this.fData.size = dataInputStream.readInt();
        this.fData.magic = dataInputStream.readInt();
        this.fData.nodeCount = dataInputStream.readShort();
        this.fData.root = dataInputStream.readShort();
        this.loadBreakCTDictionary(dataInputStream);
    }

    private void loadBreakCTDictionary(DataInputStream dataInputStream) throws IOException {
        int n;
        for (n = 0; n < this.fData.nodeCount; ++n) {
            dataInputStream.readInt();
        }
        this.nodes = new CompactTrieNodes[this.fData.nodeCount];
        this.nodes[0] = new CompactTrieNodes();
        for (n = 1; n < this.fData.nodeCount; ++n) {
            int n2;
            boolean bl;
            this.nodes[n] = new CompactTrieNodes();
            this.nodes[n].flagscount = dataInputStream.readShort();
            int n3 = this.nodes[n].flagscount & 0xFFF;
            if (n3 == 0) continue;
            boolean bl2 = bl = (this.nodes[n].flagscount & 0x1000) != 0;
            if (bl) {
                this.nodes[n].vnode = new CompactTrieVerticalNode();
                this.nodes[n].vnode.equal = dataInputStream.readShort();
                this.nodes[n].vnode.chars = new char[n3];
                for (n2 = 0; n2 < n3; ++n2) {
                    this.nodes[n].vnode.chars[n2] = dataInputStream.readChar();
                }
                continue;
            }
            this.nodes[n].hnode = new CompactTrieHorizontalNode[n3];
            for (n2 = 0; n2 < n3; ++n2) {
                this.nodes[n].hnode[n2] = new CompactTrieHorizontalNode(dataInputStream.readChar(), dataInputStream.readShort());
            }
        }
    }

    public int matches(CharacterIterator characterIterator, int n, int[] nArray, int[] nArray2, int n2) {
        CompactTrieNodes compactTrieNodes = this.getCompactTrieNode(this.fData.root);
        int n3 = 0;
        char c = characterIterator.current();
        int n4 = 0;
        boolean bl = false;
        block0: while (compactTrieNodes != null) {
            int n5;
            CompactTrieHorizontalNode[] compactTrieHorizontalNodeArray;
            int n6;
            if (n2 > 0 && (compactTrieNodes.flagscount & 0x2000) != 0) {
                nArray[n3++] = n4;
                --n2;
            }
            if (n4 >= n || (n6 = compactTrieNodes.flagscount & 0xFFF) == 0) break;
            if ((compactTrieNodes.flagscount & 0x1000) != 0) {
                compactTrieHorizontalNodeArray = compactTrieNodes.vnode;
                for (n5 = 0; n5 < n6 && n4 < n; ++n4, ++n5) {
                    if (c != compactTrieHorizontalNodeArray.chars[n5]) {
                        bl = true;
                        break;
                    }
                    characterIterator.next();
                    c = characterIterator.current();
                }
                if (bl) break;
                compactTrieNodes = this.getCompactTrieNode(compactTrieHorizontalNodeArray.equal);
                continue;
            }
            compactTrieHorizontalNodeArray = compactTrieNodes.hnode;
            n5 = 0;
            int n7 = n6 - 1;
            compactTrieNodes = null;
            while (n7 >= n5) {
                int n8 = n7 + n5 >>> 1;
                if (c == compactTrieHorizontalNodeArray[n8].ch) {
                    compactTrieNodes = this.getCompactTrieNode(compactTrieHorizontalNodeArray[n8].equal);
                    characterIterator.next();
                    c = characterIterator.current();
                    ++n4;
                    continue block0;
                }
                if (c < compactTrieHorizontalNodeArray[n8].ch) {
                    n7 = n8 - 1;
                    continue;
                }
                n5 = n8 + 1;
            }
        }
        nArray2[0] = n3;
        return n4;
    }

    public static class CompactTrieNodes {
        short flagscount = 0;
        CompactTrieHorizontalNode[] hnode = null;
        CompactTrieVerticalNode vnode = null;

        CompactTrieNodes() {
        }
    }

    public static class CompactTrieVerticalNode {
        int equal = 0;
        char[] chars = null;

        CompactTrieVerticalNode() {
        }
    }

    public static class CompactTrieHorizontalNode {
        char ch;
        int equal;

        CompactTrieHorizontalNode(char c, int n) {
            this.ch = c;
            this.equal = n;
        }
    }

    public static final class CompactTrieNodeFlags {
        static final int kVerticalNode = 4096;
        static final int kParentEndsWord = 8192;
        static final int kReservedFlag1 = 16384;
        static final int kReservedFlag2 = 32768;
        static final int kCountMask = 4095;
        static final int kFlagMask = 61440;

        CompactTrieNodeFlags() {
        }
    }

    public static class CompactTrieHeader {
        int size = 0;
        int magic = 0;
        int nodeCount = 0;
        int root = 0;
        int[] offset = null;

        CompactTrieHeader() {
        }
    }
}

