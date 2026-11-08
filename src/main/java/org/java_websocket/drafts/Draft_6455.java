/*
 * Decompiled with CFR 0.152.
 */
package org.java_websocket.drafts;

import java.math.BigInteger;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.java_websocket.WebSocket;
import org.java_websocket.WebSocketImpl;
import org.java_websocket.drafts.Draft;
import org.java_websocket.enums.CloseHandshakeType;
import org.java_websocket.enums.HandshakeState;
import org.java_websocket.enums.Opcode;
import org.java_websocket.enums.ReadyState;
import org.java_websocket.enums.Role;
import org.java_websocket.exceptions.IncompleteException;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidFrameException;
import org.java_websocket.exceptions.InvalidHandshakeException;
import org.java_websocket.exceptions.LimitExceededException;
import org.java_websocket.exceptions.NotSendableException;
import org.java_websocket.extensions.DefaultExtension;
import org.java_websocket.extensions.IExtension;
import org.java_websocket.framing.BinaryFrame;
import org.java_websocket.framing.CloseFrame;
import org.java_websocket.framing.Framedata;
import org.java_websocket.framing.FramedataImpl1;
import org.java_websocket.framing.TextFrame;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.handshake.ClientHandshakeBuilder;
import org.java_websocket.handshake.HandshakeBuilder;
import org.java_websocket.handshake.ServerHandshake;
import org.java_websocket.handshake.ServerHandshakeBuilder;
import org.java_websocket.protocols.IProtocol;
import org.java_websocket.protocols.Protocol;
import org.java_websocket.util.Base64;
import org.java_websocket.util.Charsetfunctions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Draft_6455
extends Draft {
    private static final String SEC_WEB_SOCKET_KEY = "Sec-WebSocket-Key";
    private static final String SEC_WEB_SOCKET_PROTOCOL = "Sec-WebSocket-Protocol";
    private static final String SEC_WEB_SOCKET_EXTENSIONS = "Sec-WebSocket-Extensions";
    private static final String SEC_WEB_SOCKET_ACCEPT = "Sec-WebSocket-Accept";
    private static final String UPGRADE = "Upgrade";
    private static final String CONNECTION = "Connection";
    private final Logger log = LoggerFactory.getLogger(Draft_6455.class);
    private IExtension negotiatedExtension = new DefaultExtension();
    private IExtension defaultExtension = new DefaultExtension();
    private List<IExtension> knownExtensions;
    private IExtension currentDecodingExtension;
    private IProtocol protocol;
    private List<IProtocol> knownProtocols;
    private Framedata currentContinuousFrame;
    private final List<ByteBuffer> byteBufferList;
    private ByteBuffer incompleteframe;
    private final SecureRandom reuseableRandom = new SecureRandom();
    private int maxFrameSize;

    public Draft_6455() {
        this(Collections.emptyList());
    }

    public Draft_6455(IExtension iExtension) {
        this(Collections.singletonList(iExtension));
    }

    public Draft_6455(List<IExtension> list) {
        this(list, Collections.singletonList(new Protocol("")));
    }

    public Draft_6455(List<IExtension> list, List<IProtocol> list2) {
        this(list, list2, Integer.MAX_VALUE);
    }

    public Draft_6455(List<IExtension> list, int n) {
        this(list, Collections.singletonList(new Protocol("")), n);
    }

    public Draft_6455(List<IExtension> list, List<IProtocol> list2, int n) {
        if (list == null || list2 == null || n < 1) {
            throw new IllegalArgumentException();
        }
        this.knownExtensions = new ArrayList<IExtension>(list.size());
        this.knownProtocols = new ArrayList<IProtocol>(list2.size());
        boolean bl = false;
        this.byteBufferList = new ArrayList<ByteBuffer>();
        for (IExtension iExtension : list) {
            if (!iExtension.getClass().equals(DefaultExtension.class)) continue;
            bl = true;
        }
        this.knownExtensions.addAll(list);
        if (!bl) {
            this.knownExtensions.add(this.knownExtensions.size(), this.negotiatedExtension);
        }
        this.knownProtocols.addAll(list2);
        this.maxFrameSize = n;
        this.currentDecodingExtension = null;
    }

    @Override
    public HandshakeState acceptHandshakeAsServer(ClientHandshake clientHandshake) throws InvalidHandshakeException {
        int n = this.readVersion(clientHandshake);
        if (n != 13) {
            this.log.trace("acceptHandshakeAsServer - Wrong websocket version.");
            return HandshakeState.NOT_MATCHED;
        }
        HandshakeState handshakeState = HandshakeState.NOT_MATCHED;
        String string = clientHandshake.getFieldValue(SEC_WEB_SOCKET_EXTENSIONS);
        Object object = this.knownExtensions.iterator();
        while (object.hasNext()) {
            IExtension iExtension = object.next();
            if (!iExtension.acceptProvidedExtensionAsServer(string)) continue;
            this.negotiatedExtension = iExtension;
            handshakeState = HandshakeState.MATCHED;
            this.log.trace("acceptHandshakeAsServer - Matching extension found: {}", (Object)this.negotiatedExtension);
            break;
        }
        if ((object = this.containsRequestedProtocol(clientHandshake.getFieldValue(SEC_WEB_SOCKET_PROTOCOL))) == HandshakeState.MATCHED && handshakeState == HandshakeState.MATCHED) {
            return HandshakeState.MATCHED;
        }
        this.log.trace("acceptHandshakeAsServer - No matching extension or protocol found.");
        return HandshakeState.NOT_MATCHED;
    }

    private HandshakeState containsRequestedProtocol(String string) {
        for (IProtocol iProtocol : this.knownProtocols) {
            if (!iProtocol.acceptProvidedProtocol(string)) continue;
            this.protocol = iProtocol;
            this.log.trace("acceptHandshake - Matching protocol found: {}", (Object)this.protocol);
            return HandshakeState.MATCHED;
        }
        return HandshakeState.NOT_MATCHED;
    }

    @Override
    public HandshakeState acceptHandshakeAsClient(ClientHandshake clientHandshake, ServerHandshake serverHandshake) throws InvalidHandshakeException {
        if (!this.basicAccept(serverHandshake)) {
            this.log.trace("acceptHandshakeAsClient - Missing/wrong upgrade or connection in handshake.");
            return HandshakeState.NOT_MATCHED;
        }
        if (!clientHandshake.hasFieldValue(SEC_WEB_SOCKET_KEY) || !serverHandshake.hasFieldValue(SEC_WEB_SOCKET_ACCEPT)) {
            this.log.trace("acceptHandshakeAsClient - Missing Sec-WebSocket-Key or Sec-WebSocket-Accept");
            return HandshakeState.NOT_MATCHED;
        }
        String string = serverHandshake.getFieldValue(SEC_WEB_SOCKET_ACCEPT);
        String string2 = clientHandshake.getFieldValue(SEC_WEB_SOCKET_KEY);
        if (!(string2 = this.generateFinalKey(string2)).equals(string)) {
            this.log.trace("acceptHandshakeAsClient - Wrong key for Sec-WebSocket-Key.");
            return HandshakeState.NOT_MATCHED;
        }
        HandshakeState handshakeState = HandshakeState.NOT_MATCHED;
        String string3 = serverHandshake.getFieldValue(SEC_WEB_SOCKET_EXTENSIONS);
        Object object = this.knownExtensions.iterator();
        while (object.hasNext()) {
            IExtension iExtension = object.next();
            if (!iExtension.acceptProvidedExtensionAsClient(string3)) continue;
            this.negotiatedExtension = iExtension;
            handshakeState = HandshakeState.MATCHED;
            this.log.trace("acceptHandshakeAsClient - Matching extension found: {}", (Object)this.negotiatedExtension);
            break;
        }
        if ((object = this.containsRequestedProtocol(serverHandshake.getFieldValue(SEC_WEB_SOCKET_PROTOCOL))) == HandshakeState.MATCHED && handshakeState == HandshakeState.MATCHED) {
            return HandshakeState.MATCHED;
        }
        this.log.trace("acceptHandshakeAsClient - No matching extension or protocol found.");
        return HandshakeState.NOT_MATCHED;
    }

    public IExtension getExtension() {
        return this.negotiatedExtension;
    }

    public List<IExtension> getKnownExtensions() {
        return this.knownExtensions;
    }

    public IProtocol getProtocol() {
        return this.protocol;
    }

    public int getMaxFrameSize() {
        return this.maxFrameSize;
    }

    public List<IProtocol> getKnownProtocols() {
        return this.knownProtocols;
    }

    @Override
    public ClientHandshakeBuilder postProcessHandshakeRequestAsClient(ClientHandshakeBuilder clientHandshakeBuilder) {
        clientHandshakeBuilder.put(UPGRADE, "websocket");
        clientHandshakeBuilder.put(CONNECTION, UPGRADE);
        byte[] byArray = new byte[16];
        this.reuseableRandom.nextBytes(byArray);
        clientHandshakeBuilder.put(SEC_WEB_SOCKET_KEY, Base64.encodeBytes(byArray));
        clientHandshakeBuilder.put("Sec-WebSocket-Version", "13");
        StringBuilder stringBuilder = new StringBuilder();
        for (IExtension object : this.knownExtensions) {
            if (object.getProvidedExtensionAsClient() == null || object.getProvidedExtensionAsClient().length() == 0) continue;
            if (stringBuilder.length() > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(object.getProvidedExtensionAsClient());
        }
        if (stringBuilder.length() != 0) {
            clientHandshakeBuilder.put(SEC_WEB_SOCKET_EXTENSIONS, stringBuilder.toString());
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        for (IProtocol iProtocol : this.knownProtocols) {
            if (iProtocol.getProvidedProtocol().length() == 0) continue;
            if (stringBuilder2.length() > 0) {
                stringBuilder2.append(", ");
            }
            stringBuilder2.append(iProtocol.getProvidedProtocol());
        }
        if (stringBuilder2.length() != 0) {
            clientHandshakeBuilder.put(SEC_WEB_SOCKET_PROTOCOL, stringBuilder2.toString());
        }
        return clientHandshakeBuilder;
    }

    @Override
    public HandshakeBuilder postProcessHandshakeResponseAsServer(ClientHandshake clientHandshake, ServerHandshakeBuilder serverHandshakeBuilder) throws InvalidHandshakeException {
        serverHandshakeBuilder.put(UPGRADE, "websocket");
        serverHandshakeBuilder.put(CONNECTION, clientHandshake.getFieldValue(CONNECTION));
        String string = clientHandshake.getFieldValue(SEC_WEB_SOCKET_KEY);
        if (string == null || "".equals(string)) {
            throw new InvalidHandshakeException("missing Sec-WebSocket-Key");
        }
        serverHandshakeBuilder.put(SEC_WEB_SOCKET_ACCEPT, this.generateFinalKey(string));
        if (this.getExtension().getProvidedExtensionAsServer().length() != 0) {
            serverHandshakeBuilder.put(SEC_WEB_SOCKET_EXTENSIONS, this.getExtension().getProvidedExtensionAsServer());
        }
        if (this.getProtocol() != null && this.getProtocol().getProvidedProtocol().length() != 0) {
            serverHandshakeBuilder.put(SEC_WEB_SOCKET_PROTOCOL, this.getProtocol().getProvidedProtocol());
        }
        serverHandshakeBuilder.setHttpStatusMessage("Web Socket Protocol Handshake");
        serverHandshakeBuilder.put("Server", "TooTallNate Java-WebSocket");
        serverHandshakeBuilder.put("Date", this.getServerTime());
        return serverHandshakeBuilder;
    }

    @Override
    public Draft copyInstance() {
        ArrayList<IExtension> arrayList = new ArrayList<IExtension>();
        for (IExtension object : this.getKnownExtensions()) {
            arrayList.add(object.copyInstance());
        }
        ArrayList arrayList2 = new ArrayList();
        for (IProtocol iProtocol : this.getKnownProtocols()) {
            arrayList2.add(iProtocol.copyInstance());
        }
        return new Draft_6455(arrayList, arrayList2, this.maxFrameSize);
    }

    @Override
    public ByteBuffer createBinaryFrame(Framedata framedata) {
        this.getExtension().encodeFrame(framedata);
        if (this.log.isTraceEnabled()) {
            this.log.trace("afterEnconding({}): {}", (Object)framedata.getPayloadData().remaining(), (Object)(framedata.getPayloadData().remaining() > 1000 ? "too big to display" : new String(framedata.getPayloadData().array())));
        }
        return this.createByteBufferFromFramedata(framedata);
    }

    private ByteBuffer createByteBufferFromFramedata(Framedata framedata) {
        ByteBuffer byteBuffer = framedata.getPayloadData();
        boolean bl = this.role == Role.CLIENT;
        int n = this.getSizeBytes(byteBuffer);
        ByteBuffer byteBuffer2 = ByteBuffer.allocate(1 + (n > 1 ? n + 1 : n) + (bl ? 4 : 0) + byteBuffer.remaining());
        byte by = this.fromOpcode(framedata.getOpcode());
        byte by2 = (byte)(framedata.isFin() ? -128 : 0);
        by2 = (byte)(by2 | by);
        if (framedata.isRSV1()) {
            by2 = (byte)(by2 | this.getRSVByte(1));
        }
        if (framedata.isRSV2()) {
            by2 = (byte)(by2 | this.getRSVByte(2));
        }
        if (framedata.isRSV3()) {
            by2 = (byte)(by2 | this.getRSVByte(3));
        }
        byteBuffer2.put(by2);
        byte[] byArray = this.toByteArray(byteBuffer.remaining(), n);
        assert (byArray.length == n);
        if (n == 1) {
            byteBuffer2.put((byte)(byArray[0] | this.getMaskByte(bl)));
        } else if (n == 2) {
            byteBuffer2.put((byte)(0x7E | this.getMaskByte(bl)));
            byteBuffer2.put(byArray);
        } else if (n == 8) {
            byteBuffer2.put((byte)(0x7F | this.getMaskByte(bl)));
            byteBuffer2.put(byArray);
        } else {
            throw new IllegalStateException("Size representation not supported/specified");
        }
        if (bl) {
            ByteBuffer byteBuffer3 = ByteBuffer.allocate(4);
            byteBuffer3.putInt(this.reuseableRandom.nextInt());
            byteBuffer2.put(byteBuffer3.array());
            int n2 = 0;
            while (byteBuffer.hasRemaining()) {
                byteBuffer2.put((byte)(byteBuffer.get() ^ byteBuffer3.get(n2 % 4)));
                ++n2;
            }
        } else {
            byteBuffer2.put(byteBuffer);
            byteBuffer.flip();
        }
        assert (byteBuffer2.remaining() == 0) : byteBuffer2.remaining();
        byteBuffer2.flip();
        return byteBuffer2;
    }

    private Framedata translateSingleFrame(ByteBuffer byteBuffer) throws IncompleteException, InvalidDataException {
        Object object;
        Object object2;
        if (byteBuffer == null) {
            throw new IllegalArgumentException();
        }
        int n = byteBuffer.remaining();
        int n2 = 2;
        this.translateSingleFrameCheckPacketSize(n, n2);
        byte by = byteBuffer.get();
        boolean bl = by >> 8 != 0;
        boolean bl2 = (by & 0x40) != 0;
        boolean bl3 = (by & 0x20) != 0;
        boolean bl4 = (by & 0x10) != 0;
        byte by2 = byteBuffer.get();
        boolean bl5 = (by2 & 0xFFFFFF80) != 0;
        int n3 = by2 & 0x7F;
        Opcode opcode = this.toOpcode((byte)(by & 0xF));
        if (n3 < 0 || n3 > 125) {
            object2 = this.translateSingleFramePayloadLength(byteBuffer, opcode, n3, n, n2);
            n3 = ((TranslatedPayloadMetaData)object2).getPayloadLength();
            n2 = ((TranslatedPayloadMetaData)object2).getRealPackageSize();
        }
        this.translateSingleFrameCheckLengthLimit(n3);
        n2 += bl5 ? 4 : 0;
        this.translateSingleFrameCheckPacketSize(n, n2 += n3);
        object2 = ByteBuffer.allocate(this.checkAlloc(n3));
        if (bl5) {
            object = new byte[4];
            byteBuffer.get((byte[])object);
            for (int i = 0; i < n3; ++i) {
                ((ByteBuffer)object2).put((byte)(byteBuffer.get() ^ object[i % 4]));
            }
        } else {
            ((ByteBuffer)object2).put(byteBuffer.array(), byteBuffer.position(), ((Buffer)object2).limit());
            byteBuffer.position(byteBuffer.position() + ((Buffer)object2).limit());
        }
        object = FramedataImpl1.get(opcode);
        ((FramedataImpl1)object).setFin(bl);
        ((FramedataImpl1)object).setRSV1(bl2);
        ((FramedataImpl1)object).setRSV2(bl3);
        ((FramedataImpl1)object).setRSV3(bl4);
        ((ByteBuffer)object2).flip();
        ((FramedataImpl1)object).setPayload((ByteBuffer)object2);
        if (((FramedataImpl1)object).getOpcode() != Opcode.CONTINUOUS) {
            this.currentDecodingExtension = ((FramedataImpl1)object).isRSV1() || ((FramedataImpl1)object).isRSV2() || ((FramedataImpl1)object).isRSV3() ? this.getExtension() : this.defaultExtension;
        }
        if (this.currentDecodingExtension == null) {
            this.currentDecodingExtension = this.defaultExtension;
        }
        this.currentDecodingExtension.isFrameValid((Framedata)object);
        this.currentDecodingExtension.decodeFrame((Framedata)object);
        if (this.log.isTraceEnabled()) {
            this.log.trace("afterDecoding({}): {}", (Object)((FramedataImpl1)object).getPayloadData().remaining(), (Object)(((FramedataImpl1)object).getPayloadData().remaining() > 1000 ? "too big to display" : new String(((FramedataImpl1)object).getPayloadData().array())));
        }
        ((FramedataImpl1)object).isValid();
        return object;
    }

    private TranslatedPayloadMetaData translateSingleFramePayloadLength(ByteBuffer byteBuffer, Opcode opcode, int n, int n2, int n3) throws InvalidFrameException, IncompleteException, LimitExceededException {
        int n4 = n;
        int n5 = n3;
        if (opcode == Opcode.PING || opcode == Opcode.PONG || opcode == Opcode.CLOSING) {
            this.log.trace("Invalid frame: more than 125 octets");
            throw new InvalidFrameException("more than 125 octets");
        }
        if (n4 == 126) {
            this.translateSingleFrameCheckPacketSize(n2, n5 += 2);
            byte[] byArray = new byte[3];
            byArray[1] = byteBuffer.get();
            byArray[2] = byteBuffer.get();
            n4 = new BigInteger(byArray).intValue();
        } else {
            this.translateSingleFrameCheckPacketSize(n2, n5 += 8);
            byte[] byArray = new byte[8];
            for (int i = 0; i < 8; ++i) {
                byArray[i] = byteBuffer.get();
            }
            long l = new BigInteger(byArray).longValue();
            this.translateSingleFrameCheckLengthLimit(l);
            n4 = (int)l;
        }
        return new TranslatedPayloadMetaData(n4, n5);
    }

    private void translateSingleFrameCheckLengthLimit(long l) throws LimitExceededException {
        if (l > Integer.MAX_VALUE) {
            this.log.trace("Limit exedeed: Payloadsize is to big...");
            throw new LimitExceededException("Payloadsize is to big...");
        }
        if (l > (long)this.maxFrameSize) {
            this.log.trace("Payload limit reached. Allowed: {} Current: {}", (Object)this.maxFrameSize, (Object)l);
            throw new LimitExceededException("Payload limit reached.", this.maxFrameSize);
        }
        if (l < 0L) {
            this.log.trace("Limit underflow: Payloadsize is to little...");
            throw new LimitExceededException("Payloadsize is to little...");
        }
    }

    private void translateSingleFrameCheckPacketSize(int n, int n2) throws IncompleteException {
        if (n < n2) {
            this.log.trace("Incomplete frame: maxpacketsize < realpacketsize");
            throw new IncompleteException(n2);
        }
    }

    private byte getRSVByte(int n) {
        switch (n) {
            case 1: {
                return 64;
            }
            case 2: {
                return 32;
            }
            case 3: {
                return 16;
            }
        }
        return 0;
    }

    private byte getMaskByte(boolean bl) {
        return bl ? (byte)-128 : 0;
    }

    private int getSizeBytes(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() <= 125) {
            return 1;
        }
        if (byteBuffer.remaining() <= 65535) {
            return 2;
        }
        return 8;
    }

    @Override
    public List<Framedata> translateFrame(ByteBuffer byteBuffer) throws InvalidDataException {
        Framedata framedata;
        int n;
        LinkedList<Framedata> linkedList;
        while (true) {
            linkedList = new LinkedList<Framedata>();
            if (this.incompleteframe == null) break;
            try {
                byteBuffer.mark();
                int n2 = byteBuffer.remaining();
                n = this.incompleteframe.remaining();
                if (n > n2) {
                    this.incompleteframe.put(byteBuffer.array(), byteBuffer.position(), n2);
                    byteBuffer.position(byteBuffer.position() + n2);
                    return Collections.emptyList();
                }
                this.incompleteframe.put(byteBuffer.array(), byteBuffer.position(), n);
                byteBuffer.position(byteBuffer.position() + n);
                framedata = this.translateSingleFrame((ByteBuffer)this.incompleteframe.duplicate().position(0));
                linkedList.add(framedata);
                this.incompleteframe = null;
            }
            catch (IncompleteException incompleteException) {
                ByteBuffer byteBuffer2 = ByteBuffer.allocate(this.checkAlloc(incompleteException.getPreferredSize()));
                assert (byteBuffer2.limit() > this.incompleteframe.limit());
                this.incompleteframe.rewind();
                byteBuffer2.put(this.incompleteframe);
                this.incompleteframe = byteBuffer2;
                continue;
            }
            break;
        }
        while (byteBuffer.hasRemaining()) {
            byteBuffer.mark();
            try {
                framedata = this.translateSingleFrame(byteBuffer);
                linkedList.add(framedata);
            }
            catch (IncompleteException incompleteException) {
                byteBuffer.reset();
                n = incompleteException.getPreferredSize();
                this.incompleteframe = ByteBuffer.allocate(this.checkAlloc(n));
                this.incompleteframe.put(byteBuffer);
                break;
            }
        }
        return linkedList;
    }

    @Override
    public List<Framedata> createFrames(ByteBuffer byteBuffer, boolean bl) {
        BinaryFrame binaryFrame = new BinaryFrame();
        binaryFrame.setPayload(byteBuffer);
        binaryFrame.setTransferemasked(bl);
        try {
            binaryFrame.isValid();
        }
        catch (InvalidDataException invalidDataException) {
            throw new NotSendableException(invalidDataException);
        }
        return Collections.singletonList(binaryFrame);
    }

    @Override
    public List<Framedata> createFrames(String string, boolean bl) {
        TextFrame textFrame = new TextFrame();
        textFrame.setPayload(ByteBuffer.wrap(Charsetfunctions.utf8Bytes(string)));
        textFrame.setTransferemasked(bl);
        try {
            textFrame.isValid();
        }
        catch (InvalidDataException invalidDataException) {
            throw new NotSendableException(invalidDataException);
        }
        return Collections.singletonList(textFrame);
    }

    @Override
    public void reset() {
        this.incompleteframe = null;
        if (this.negotiatedExtension != null) {
            this.negotiatedExtension.reset();
        }
        this.negotiatedExtension = new DefaultExtension();
        this.protocol = null;
    }

    private String getServerTime() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat.format(calendar.getTime());
    }

    private String generateFinalKey(String string) {
        MessageDigest messageDigest;
        String string2 = string.trim();
        String string3 = string2 + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
        try {
            messageDigest = MessageDigest.getInstance("SHA1");
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            throw new IllegalStateException(noSuchAlgorithmException);
        }
        return Base64.encodeBytes(messageDigest.digest(string3.getBytes()));
    }

    private byte[] toByteArray(long l, int n) {
        byte[] byArray = new byte[n];
        int n2 = 8 * n - 8;
        for (int i = 0; i < n; ++i) {
            byArray[i] = (byte)(l >>> n2 - 8 * i);
        }
        return byArray;
    }

    private byte fromOpcode(Opcode opcode) {
        if (opcode == Opcode.CONTINUOUS) {
            return 0;
        }
        if (opcode == Opcode.TEXT) {
            return 1;
        }
        if (opcode == Opcode.BINARY) {
            return 2;
        }
        if (opcode == Opcode.CLOSING) {
            return 8;
        }
        if (opcode == Opcode.PING) {
            return 9;
        }
        if (opcode == Opcode.PONG) {
            return 10;
        }
        throw new IllegalArgumentException("Don't know how to handle " + opcode.toString());
    }

    private Opcode toOpcode(byte by) throws InvalidFrameException {
        switch (by) {
            case 0: {
                return Opcode.CONTINUOUS;
            }
            case 1: {
                return Opcode.TEXT;
            }
            case 2: {
                return Opcode.BINARY;
            }
            case 8: {
                return Opcode.CLOSING;
            }
            case 9: {
                return Opcode.PING;
            }
            case 10: {
                return Opcode.PONG;
            }
        }
        throw new InvalidFrameException("Unknown opcode " + (short)by);
    }

    @Override
    public void processFrame(WebSocketImpl webSocketImpl, Framedata framedata) throws InvalidDataException {
        Opcode opcode = framedata.getOpcode();
        if (opcode == Opcode.CLOSING) {
            this.processFrameClosing(webSocketImpl, framedata);
        } else if (opcode == Opcode.PING) {
            webSocketImpl.getWebSocketListener().onWebsocketPing(webSocketImpl, framedata);
        } else if (opcode == Opcode.PONG) {
            webSocketImpl.updateLastPong();
            webSocketImpl.getWebSocketListener().onWebsocketPong(webSocketImpl, framedata);
        } else if (!framedata.isFin() || opcode == Opcode.CONTINUOUS) {
            this.processFrameContinuousAndNonFin(webSocketImpl, framedata, opcode);
        } else {
            if (this.currentContinuousFrame != null) {
                this.log.error("Protocol error: Continuous frame sequence not completed.");
                throw new InvalidDataException(1002, "Continuous frame sequence not completed.");
            }
            if (opcode == Opcode.TEXT) {
                this.processFrameText(webSocketImpl, framedata);
            } else if (opcode == Opcode.BINARY) {
                this.processFrameBinary(webSocketImpl, framedata);
            } else {
                this.log.error("non control or continious frame expected");
                throw new InvalidDataException(1002, "non control or continious frame expected");
            }
        }
    }

    private void processFrameContinuousAndNonFin(WebSocketImpl webSocketImpl, Framedata framedata, Opcode opcode) throws InvalidDataException {
        if (opcode != Opcode.CONTINUOUS) {
            this.processFrameIsNotFin(framedata);
        } else if (framedata.isFin()) {
            this.processFrameIsFin(webSocketImpl, framedata);
        } else if (this.currentContinuousFrame == null) {
            this.log.error("Protocol error: Continuous frame sequence was not started.");
            throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
        }
        if (opcode == Opcode.TEXT && !Charsetfunctions.isValidUTF8(framedata.getPayloadData())) {
            this.log.error("Protocol error: Payload is not UTF8");
            throw new InvalidDataException(1007);
        }
        if (opcode == Opcode.CONTINUOUS && this.currentContinuousFrame != null) {
            this.addToBufferList(framedata.getPayloadData());
        }
    }

    private void processFrameBinary(WebSocketImpl webSocketImpl, Framedata framedata) {
        try {
            webSocketImpl.getWebSocketListener().onWebsocketMessage((WebSocket)webSocketImpl, framedata.getPayloadData());
        }
        catch (RuntimeException runtimeException) {
            this.logRuntimeException(webSocketImpl, runtimeException);
        }
    }

    private void logRuntimeException(WebSocketImpl webSocketImpl, RuntimeException runtimeException) {
        this.log.error("Runtime exception during onWebsocketMessage", runtimeException);
        webSocketImpl.getWebSocketListener().onWebsocketError(webSocketImpl, runtimeException);
    }

    private void processFrameText(WebSocketImpl webSocketImpl, Framedata framedata) throws InvalidDataException {
        try {
            webSocketImpl.getWebSocketListener().onWebsocketMessage((WebSocket)webSocketImpl, Charsetfunctions.stringUtf8(framedata.getPayloadData()));
        }
        catch (RuntimeException runtimeException) {
            this.logRuntimeException(webSocketImpl, runtimeException);
        }
    }

    private void processFrameIsFin(WebSocketImpl webSocketImpl, Framedata framedata) throws InvalidDataException {
        if (this.currentContinuousFrame == null) {
            this.log.trace("Protocol error: Previous continuous frame sequence not completed.");
            throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
        }
        this.addToBufferList(framedata.getPayloadData());
        this.checkBufferLimit();
        if (this.currentContinuousFrame.getOpcode() == Opcode.TEXT) {
            ((FramedataImpl1)this.currentContinuousFrame).setPayload(this.getPayloadFromByteBufferList());
            ((FramedataImpl1)this.currentContinuousFrame).isValid();
            try {
                webSocketImpl.getWebSocketListener().onWebsocketMessage((WebSocket)webSocketImpl, Charsetfunctions.stringUtf8(this.currentContinuousFrame.getPayloadData()));
            }
            catch (RuntimeException runtimeException) {
                this.logRuntimeException(webSocketImpl, runtimeException);
            }
        } else if (this.currentContinuousFrame.getOpcode() == Opcode.BINARY) {
            ((FramedataImpl1)this.currentContinuousFrame).setPayload(this.getPayloadFromByteBufferList());
            ((FramedataImpl1)this.currentContinuousFrame).isValid();
            try {
                webSocketImpl.getWebSocketListener().onWebsocketMessage((WebSocket)webSocketImpl, this.currentContinuousFrame.getPayloadData());
            }
            catch (RuntimeException runtimeException) {
                this.logRuntimeException(webSocketImpl, runtimeException);
            }
        }
        this.currentContinuousFrame = null;
        this.clearBufferList();
    }

    private void processFrameIsNotFin(Framedata framedata) throws InvalidDataException {
        if (this.currentContinuousFrame != null) {
            this.log.trace("Protocol error: Previous continuous frame sequence not completed.");
            throw new InvalidDataException(1002, "Previous continuous frame sequence not completed.");
        }
        this.currentContinuousFrame = framedata;
        this.addToBufferList(framedata.getPayloadData());
        this.checkBufferLimit();
    }

    private void processFrameClosing(WebSocketImpl webSocketImpl, Framedata framedata) {
        int n = 1005;
        String string = "";
        if (framedata instanceof CloseFrame) {
            CloseFrame closeFrame = (CloseFrame)framedata;
            n = closeFrame.getCloseCode();
            string = closeFrame.getMessage();
        }
        if (webSocketImpl.getReadyState() == ReadyState.CLOSING) {
            webSocketImpl.closeConnection(n, string, true);
        } else if (this.getCloseHandshakeType() == CloseHandshakeType.TWOWAY) {
            webSocketImpl.close(n, string, true);
        } else {
            webSocketImpl.flushAndClose(n, string, false);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void clearBufferList() {
        List<ByteBuffer> list = this.byteBufferList;
        synchronized (list) {
            this.byteBufferList.clear();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void addToBufferList(ByteBuffer byteBuffer) {
        List<ByteBuffer> list = this.byteBufferList;
        synchronized (list) {
            this.byteBufferList.add(byteBuffer);
        }
    }

    private void checkBufferLimit() throws LimitExceededException {
        long l = this.getByteBufferListSize();
        if (l > (long)this.maxFrameSize) {
            this.clearBufferList();
            this.log.trace("Payload limit reached. Allowed: {} Current: {}", (Object)this.maxFrameSize, (Object)l);
            throw new LimitExceededException(this.maxFrameSize);
        }
    }

    @Override
    public CloseHandshakeType getCloseHandshakeType() {
        return CloseHandshakeType.TWOWAY;
    }

    @Override
    public String toString() {
        String string = super.toString();
        if (this.getExtension() != null) {
            string = string + " extension: " + this.getExtension().toString();
        }
        if (this.getProtocol() != null) {
            string = string + " protocol: " + this.getProtocol().toString();
        }
        string = string + " max frame size: " + this.maxFrameSize;
        return string;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        Draft_6455 draft_6455 = (Draft_6455)object;
        if (this.maxFrameSize != draft_6455.getMaxFrameSize()) {
            return false;
        }
        if (this.negotiatedExtension != null ? !this.negotiatedExtension.equals(draft_6455.getExtension()) : draft_6455.getExtension() != null) {
            return false;
        }
        return this.protocol != null ? this.protocol.equals(draft_6455.getProtocol()) : draft_6455.getProtocol() == null;
    }

    public int hashCode() {
        int n = this.negotiatedExtension != null ? this.negotiatedExtension.hashCode() : 0;
        n = 31 * n + (this.protocol != null ? this.protocol.hashCode() : 0);
        n = 31 * n + (this.maxFrameSize ^ this.maxFrameSize >>> 32);
        return n;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private ByteBuffer getPayloadFromByteBufferList() throws LimitExceededException {
        ByteBuffer byteBuffer;
        long l = 0L;
        List<ByteBuffer> list = this.byteBufferList;
        synchronized (list) {
            for (ByteBuffer byteBuffer2 : this.byteBufferList) {
                l += (long)byteBuffer2.limit();
            }
            this.checkBufferLimit();
            byteBuffer = ByteBuffer.allocate((int)l);
            for (ByteBuffer byteBuffer2 : this.byteBufferList) {
                byteBuffer.put(byteBuffer2);
            }
        }
        byteBuffer.flip();
        return byteBuffer;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private long getByteBufferListSize() {
        long l = 0L;
        List<ByteBuffer> list = this.byteBufferList;
        synchronized (list) {
            for (ByteBuffer byteBuffer : this.byteBufferList) {
                l += (long)byteBuffer.limit();
            }
        }
        return l;
    }

    private class TranslatedPayloadMetaData {
        private int payloadLength;
        private int realPackageSize;

        private int getPayloadLength() {
            return this.payloadLength;
        }

        private int getRealPackageSize() {
            return this.realPackageSize;
        }

        TranslatedPayloadMetaData(int n, int n2) {
            this.payloadLength = n;
            this.realPackageSize = n2;
        }
    }
}

