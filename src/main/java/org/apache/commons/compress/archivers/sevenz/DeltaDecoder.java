/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.compress.archivers.sevenz;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.compress.archivers.sevenz.Coder;
import org.apache.commons.compress.archivers.sevenz.CoderBase;
import org.tukaani.xz.DeltaOptions;
import org.tukaani.xz.FinishableOutputStream;
import org.tukaani.xz.FinishableWrapperOutputStream;
import org.tukaani.xz.UnsupportedOptionsException;

public class DeltaDecoder
extends CoderBase {
    DeltaDecoder() {
        super(Number.class);
    }

    InputStream decode(InputStream inputStream2, Coder coder, byte[] byArray) throws IOException {
        return new DeltaOptions(this.getOptionsFromCoder(coder)).getInputStream(inputStream2);
    }

    OutputStream encode(OutputStream outputStream2, Object object) throws IOException {
        int n = DeltaDecoder.numberOptionOrDefault(object, 1);
        try {
            return new DeltaOptions(n).getOutputStream((FinishableOutputStream)new FinishableWrapperOutputStream(outputStream2));
        }
        catch (UnsupportedOptionsException unsupportedOptionsException) {
            throw new IOException(unsupportedOptionsException.getMessage());
        }
    }

    byte[] getOptionsAsProperties(Object object) {
        return new byte[]{(byte)(DeltaDecoder.numberOptionOrDefault(object, 1) - 1)};
    }

    Object getOptionsFromCoder(Coder coder, InputStream inputStream2) {
        return this.getOptionsFromCoder(coder);
    }

    private int getOptionsFromCoder(Coder coder) {
        if (coder.properties == null || coder.properties.length == 0) {
            return 1;
        }
        return (0xFF & coder.properties[0]) + 1;
    }
}

