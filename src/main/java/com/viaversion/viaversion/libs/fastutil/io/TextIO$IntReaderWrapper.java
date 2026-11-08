/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.io;

import com.viaversion.viaversion.libs.fastutil.ints.IntIterator;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.util.NoSuchElementException;

public class TextIO$IntReaderWrapper
implements IntIterator {
    private final BufferedReader reader;
    private boolean toAdvance = true;
    private String s;
    private int next;

    public TextIO$IntReaderWrapper(BufferedReader bufferedReader) {
        this.reader = bufferedReader;
    }

    @Override
    public boolean hasNext() {
        if (!this.toAdvance) {
            return this.s != null;
        }
        this.toAdvance = false;
        try {
            this.s = this.reader.readLine();
        }
        catch (EOFException eOFException) {
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
        if (this.s == null) {
            return false;
        }
        this.next = Integer.parseInt(this.s.trim());
        return true;
    }

    @Override
    public int nextInt() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        this.toAdvance = true;
        return this.next;
    }
}

