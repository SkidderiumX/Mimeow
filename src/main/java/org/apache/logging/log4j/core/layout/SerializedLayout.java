/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.core.layout;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.layout.AbstractLayout;

@Plugin(name="SerializedLayout", category="Core", elementType="layout", printObject=true)
public class SerializedLayout
extends AbstractLayout<LogEvent> {
    private static byte[] header;

    private SerializedLayout() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public byte[] toByteArray(LogEvent logEvent) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            PrivateObjectOutputStream privateObjectOutputStream = new PrivateObjectOutputStream(byteArrayOutputStream);
            try {
                privateObjectOutputStream.writeObject(logEvent);
                privateObjectOutputStream.reset();
            }
            finally {
                privateObjectOutputStream.close();
            }
        }
        catch (IOException iOException) {
            LOGGER.error("Serialization of LogEvent failed.", (Throwable)iOException);
        }
        return byteArrayOutputStream.toByteArray();
    }

    @Override
    public LogEvent toSerializable(LogEvent logEvent) {
        return logEvent;
    }

    @PluginFactory
    public static SerializedLayout createLayout() {
        return new SerializedLayout();
    }

    @Override
    public byte[] getHeader() {
        return header;
    }

    @Override
    public Map<String, String> getContentFormat() {
        return new HashMap<String, String>();
    }

    @Override
    public String getContentType() {
        return "application/octet-stream";
    }

    static {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.close();
            header = byteArrayOutputStream.toByteArray();
        }
        catch (Exception exception) {
            LOGGER.error("Unable to generate Object stream header", (Throwable)exception);
        }
    }

    private class PrivateObjectOutputStream
    extends ObjectOutputStream {
        public PrivateObjectOutputStream(OutputStream outputStream2) throws IOException {
            super(outputStream2);
        }

        @Override
        protected void writeStreamHeader() {
        }
    }
}

