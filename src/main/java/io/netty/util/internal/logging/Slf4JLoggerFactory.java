/*
 * Decompiled with CFR 0.152.
 */
package io.netty.util.internal.logging;

import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import io.netty.util.internal.logging.Slf4JLogger;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import org.slf4j.LoggerFactory;
import org.slf4j.helpers.NOPLoggerFactory;

public class Slf4JLoggerFactory
extends InternalLoggerFactory {
    public Slf4JLoggerFactory() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    Slf4JLoggerFactory(boolean bl) {
        assert (bl);
        final StringBuffer stringBuffer = new StringBuffer();
        PrintStream printStream = System.err;
        try {
            System.setErr(new PrintStream(new OutputStream(){

                @Override
                public void write(int n) {
                    stringBuffer.append((char)n);
                }
            }, true, "US-ASCII"));
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new Error(unsupportedEncodingException);
        }
        try {
            if (LoggerFactory.getILoggerFactory() instanceof NOPLoggerFactory) {
                throw new NoClassDefFoundError(stringBuffer.toString());
            }
            printStream.print(stringBuffer);
            printStream.flush();
        }
        finally {
            System.setErr(printStream);
        }
    }

    @Override
    public InternalLogger newInstance(String string) {
        return new Slf4JLogger(LoggerFactory.getLogger(string));
    }
}

