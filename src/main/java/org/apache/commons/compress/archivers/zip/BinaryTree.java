package org.apache.commons.compress.archivers.zip;

import java.util.*;
import java.io.*;

public class BinaryTree
{
    private static final int UNDEFINED = -1;
    private static final int NODE = -2;
    private final int[] tree;
    
    public BinaryTree(final int n) {
        Arrays.fill(this.tree = new int[(1 << n + 1) - 1], -1);
    }
    
    public void addLeaf(final int i, final int n, final int n2, final int n3) {
        if (n2 == 0) {
            if (this.tree[i] != -1) {
                throw new IllegalArgumentException("Tree value at index " + i + " has already been assigned (" + this.tree[i] + ")");
            }
            this.tree[i] = n3;
        }
        else {
            this.tree[i] = -2;
            this.addLeaf(2 * i + 1 + (n & 0x1), n >>> 1, n2 - 1, n3);
        }
    }
    
    public int read(final BitStream bitStream) throws IOException {
        int i = 0;
        while (true) {
            final int nextBit = bitStream.nextBit();
            if (nextBit == -1) {
                return -1;
            }
            final int n = 2 * i + 1 + nextBit;
            final int n2 = this.tree[n];
            if (n2 == -2) {
                i = n;
            }
            else {
                if (n2 != -1) {
                    return n2;
                }
                throw new IOException("The child " + nextBit + " of node at index " + i + " is not defined");
            }
        }
    }
    
    static BinaryTree decode(final InputStream in, final int n) throws IOException {
        final int n2 = in.read() + 1;
        if (n2 == 0) {
            throw new IOException("Cannot read the size of the encoded tree, unexpected end of stream");
        }
        final byte[] b = new byte[n2];
        new DataInputStream(in).readFully(b);
        int max = 0;
        final int[] array = new int[n];
        int n3 = 0;
        for (final byte b2 : b) {
            final int n4 = ((b2 & 0xF0) >> 4) + 1;
            final int b3 = (b2 & 0xF) + 1;
            for (int j = 0; j < n4; ++j) {
                array[n3++] = b3;
            }
            max = Math.max(max, b3);
        }
        final int[] array3 = new int[array.length];
        for (int k = 0; k < array3.length; ++k) {
            array3[k] = k;
        }
        int n5 = 0;
        final int[] array4 = new int[array.length];
        for (int l = 0; l < array.length; ++l) {
            for (int n6 = 0; n6 < array.length; ++n6) {
                if (array[n6] == l) {
                    array4[n5] = l;
                    array3[n5] = n6;
                    ++n5;
                }
            }
        }
        int n7 = 0;
        int n8 = 0;
        int n9 = 0;
        final int[] array5 = new int[n];
        for (int n10 = n - 1; n10 >= 0; --n10) {
            n7 += n8;
            if (array4[n10] != n9) {
                n9 = array4[n10];
                n8 = 1 << 16 - n9;
            }
            array5[array3[n10]] = n7;
        }
        final BinaryTree binaryTree = new BinaryTree(max);
        for (int n11 = 0; n11 < array5.length; ++n11) {
            final int n12 = array[n11];
            if (n12 > 0) {
                binaryTree.addLeaf(0, Integer.reverse(array5[n11] << 16), n12, n11);
            }
        }
        return binaryTree;
    }
}
