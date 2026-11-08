/*
 * Decompiled with CFR 0.152.
 */
package org.java_websocket.extensions.permessage_deflate;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
import org.java_websocket.enums.Opcode;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidFrameException;
import org.java_websocket.extensions.CompressionExtension;
import org.java_websocket.extensions.ExtensionRequestData;
import org.java_websocket.extensions.IExtension;
import org.java_websocket.framing.ContinuousFrame;
import org.java_websocket.framing.DataFrame;
import org.java_websocket.framing.Framedata;
import org.java_websocket.framing.FramedataImpl1;

public class PerMessageDeflateExtension
extends CompressionExtension {
    private static final String EXTENSION_REGISTERED_NAME = "permessage-deflate";
    private static final String SERVER_NO_CONTEXT_TAKEOVER = "server_no_context_takeover";
    private static final String CLIENT_NO_CONTEXT_TAKEOVER = "client_no_context_takeover";
    private static final String SERVER_MAX_WINDOW_BITS = "server_max_window_bits";
    private static final String CLIENT_MAX_WINDOW_BITS = "client_max_window_bits";
    private static final int serverMaxWindowBits = 32768;
    private static final int clientMaxWindowBits = 32768;
    private static final byte[] TAIL_BYTES = new byte[]{0, 0, -1, -1};
    private static final int BUFFER_SIZE = 1024;
    private int threshold = 1024;
    private boolean serverNoContextTakeover = true;
    private boolean clientNoContextTakeover = false;
    private Map<String, String> requestedParameters = new LinkedHashMap<String, String>();
    private final int compressionLevel;
    private final Inflater inflater;
    private final Deflater deflater;

    public PerMessageDeflateExtension() {
        this(-1);
    }

    public PerMessageDeflateExtension(int n) {
        this.compressionLevel = n;
        this.deflater = new Deflater(this.compressionLevel, true);
        this.inflater = new Inflater(true);
    }

    public int getCompressionLevel() {
        return this.compressionLevel;
    }

    public int getThreshold() {
        return this.threshold;
    }

    public void setThreshold(int n) {
        this.threshold = n;
    }

    public boolean isServerNoContextTakeover() {
        return this.serverNoContextTakeover;
    }

    public void setServerNoContextTakeover(boolean bl) {
        this.serverNoContextTakeover = bl;
    }

    public boolean isClientNoContextTakeover() {
        return this.clientNoContextTakeover;
    }

    public void setClientNoContextTakeover(boolean bl) {
        this.clientNoContextTakeover = bl;
    }

    @Override
    public void decodeFrame(Framedata framedata) throws InvalidDataException {
        if (!(framedata instanceof DataFrame)) {
            return;
        }
        if (!framedata.isRSV1() && framedata.getOpcode() != Opcode.CONTINUOUS) {
            return;
        }
        if (framedata.getOpcode() == Opcode.CONTINUOUS && framedata.isRSV1()) {
            throw new InvalidDataException(1008, "RSV1 bit can only be set for the first frame.");
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            this.decompress(framedata.getPayloadData().array(), byteArrayOutputStream);
            if (this.inflater.getRemaining() > 0) {
                this.inflater.reset();
                this.decompress(framedata.getPayloadData().array(), byteArrayOutputStream);
            }
            if (framedata.isFin()) {
                this.decompress(TAIL_BYTES, byteArrayOutputStream);
                if (this.clientNoContextTakeover) {
                    this.inflater.reset();
                }
            }
        }
        catch (DataFormatException dataFormatException) {
            throw new InvalidDataException(1008, dataFormatException.getMessage());
        }
        ((FramedataImpl1)framedata).setPayload(ByteBuffer.wrap(byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.size()));
    }

    private void decompress(byte[] byArray, ByteArrayOutputStream byteArrayOutputStream) throws DataFormatException {
        int n;
        this.inflater.setInput(byArray);
        byte[] byArray2 = new byte[1024];
        while ((n = this.inflater.inflate(byArray2)) > 0) {
            byteArrayOutputStream.write(byArray2, 0, n);
        }
    }

    @Override
    public void encodeFrame(Framedata framedata) {
        int n;
        if (!(framedata instanceof DataFrame)) {
            return;
        }
        byte[] byArray = framedata.getPayloadData().array();
        if (byArray.length < this.threshold) {
            return;
        }
        if (!(framedata instanceof ContinuousFrame)) {
            ((DataFrame)framedata).setRSV1(true);
        }
        this.deflater.setInput(byArray);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] byArray2 = new byte[1024];
        while ((n = this.deflater.deflate(byArray2, 0, byArray2.length, 2)) > 0) {
            byteArrayOutputStream.write(byArray2, 0, n);
        }
        byte[] byArray3 = byteArrayOutputStream.toByteArray();
        int n2 = byArray3.length;
        if (framedata.isFin()) {
            if (PerMessageDeflateExtension.endsWithTail(byArray3)) {
                n2 -= TAIL_BYTES.length;
            }
            if (this.serverNoContextTakeover) {
                this.deflater.reset();
            }
        }
        ((FramedataImpl1)framedata).setPayload(ByteBuffer.wrap(byArray3, 0, n2));
    }

    private static boolean endsWithTail(byte[] byArray) {
        if (byArray.length < 4) {
            return false;
        }
        int n = byArray.length;
        for (int i = 0; i < TAIL_BYTES.length; ++i) {
            if (TAIL_BYTES[i] == byArray[n - TAIL_BYTES.length + i]) continue;
            return false;
        }
        return true;
    }

    @Override
    public boolean acceptProvidedExtensionAsServer(String string) {
        String[] stringArray;
        for (String string2 : stringArray = string.split(",")) {
            ExtensionRequestData extensionRequestData = ExtensionRequestData.parseExtensionRequest(string2);
            if (!EXTENSION_REGISTERED_NAME.equalsIgnoreCase(extensionRequestData.getExtensionName())) continue;
            Map<String, String> map = extensionRequestData.getExtensionParameters();
            this.requestedParameters.putAll(map);
            if (this.requestedParameters.containsKey(CLIENT_NO_CONTEXT_TAKEOVER)) {
                this.clientNoContextTakeover = true;
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean acceptProvidedExtensionAsClient(String string) {
        String[] stringArray;
        for (String string2 : stringArray = string.split(",")) {
            ExtensionRequestData extensionRequestData = ExtensionRequestData.parseExtensionRequest(string2);
            if (!EXTENSION_REGISTERED_NAME.equalsIgnoreCase(extensionRequestData.getExtensionName())) continue;
            Map<String, String> map = extensionRequestData.getExtensionParameters();
            return true;
        }
        return false;
    }

    @Override
    public String getProvidedExtensionAsClient() {
        this.requestedParameters.put(CLIENT_NO_CONTEXT_TAKEOVER, "");
        this.requestedParameters.put(SERVER_NO_CONTEXT_TAKEOVER, "");
        return "permessage-deflate; server_no_context_takeover; client_no_context_takeover";
    }

    @Override
    public String getProvidedExtensionAsServer() {
        return "permessage-deflate; server_no_context_takeover" + (this.clientNoContextTakeover ? "; client_no_context_takeover" : "");
    }

    @Override
    public IExtension copyInstance() {
        PerMessageDeflateExtension perMessageDeflateExtension = new PerMessageDeflateExtension(this.getCompressionLevel());
        perMessageDeflateExtension.setThreshold(this.getThreshold());
        perMessageDeflateExtension.setClientNoContextTakeover(this.isClientNoContextTakeover());
        perMessageDeflateExtension.setServerNoContextTakeover(this.isServerNoContextTakeover());
        return perMessageDeflateExtension;
    }

    @Override
    public void isFrameValid(Framedata framedata) throws InvalidDataException {
        if (framedata instanceof ContinuousFrame && (framedata.isRSV1() || framedata.isRSV2() || framedata.isRSV3())) {
            throw new InvalidFrameException("bad rsv RSV1: " + framedata.isRSV1() + " RSV2: " + framedata.isRSV2() + " RSV3: " + framedata.isRSV3());
        }
        super.isFrameValid(framedata);
    }

    @Override
    public String toString() {
        return "PerMessageDeflateExtension";
    }
}

