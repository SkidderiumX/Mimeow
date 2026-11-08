/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.io;

import com.viaversion.viaversion.libs.fastutil.longs.LongIterator;
import java.io.DataInput;
import java.io.EOFException;
import java.io.IOException;
import java.util.NoSuchElementException;

public class BinIO$LongDataInputWrapper
implements LongIterator {
    private final DataInput dataInput;
    private boolean toAdvance = true;
    private boolean endOfProcess = false;
    private long next;

    public BinIO$LongDataInputWrapper(DataInput dataInput) {
        this.dataInput = dataInput;
    }

    @Override
    public boolean hasNext() {
        if (!this.toAdvance) {
            return !this.endOfProcess;
        }
        this.toAdvance = false;
        try {
            this.next = this.dataInput.readLong();
        }
        catch (EOFException eOFException) {
            this.endOfProcess = true;
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
        return !this.endOfProcess;
    }

    @Override
    public long nextLong() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        this.toAdvance = true;
        return this.next;
    }
}

