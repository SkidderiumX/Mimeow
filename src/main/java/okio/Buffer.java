package okio;

import java.nio.channels.*;
import org.jetbrains.annotations.*;
import kotlin.jvm.internal.*;
import kotlin.jvm.*;
import okio.internal.*;
import kotlin.text.*;
import java.nio.charset.*;
import kotlin.collections.*;
import java.nio.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.*;
import kotlin.*;
import java.io.*;

@Metadata(mv = { 1, 9, 0 }, k = 1, xi = 48, d1 = { "\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002\u0090\u0001B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0000H\u0016J\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\u0013\u001a\u00020\u0000H\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0016J\u0006\u0010\u0015\u001a\u00020\fJ\u0006\u0010\u0016\u001a\u00020\u0000J$\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\fH\u0007J\u0018\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u001a\u001a\u00020\fJ \u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\fJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u0000H\u0016J\b\u0010!\u001a\u00020\u0000H\u0016J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0096\u0002J\b\u0010&\u001a\u00020#H\u0016J\b\u0010'\u001a\u00020\u0012H\u0016J\u0016\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\fH\u0087\u0002¢\u0006\u0002\b+J\u0015\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020\fH\u0007¢\u0006\u0002\b-J\b\u0010.\u001a\u00020/H\u0016J\u0018\u00100\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\u001dH\u0002J\u000e\u00102\u001a\u00020\u001d2\u0006\u00101\u001a\u00020\u001dJ\u000e\u00103\u001a\u00020\u001d2\u0006\u00101\u001a\u00020\u001dJ\u000e\u00104\u001a\u00020\u001d2\u0006\u00101\u001a\u00020\u001dJ\u0010\u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020)H\u0016J\u0018\u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020)2\u0006\u00107\u001a\u00020\fH\u0016J \u00105\u001a\u00020\f2\u0006\u00106\u001a\u00020)2\u0006\u00107\u001a\u00020\f2\u0006\u00108\u001a\u00020\fH\u0016J\u0010\u00105\u001a\u00020\f2\u0006\u00109\u001a\u00020\u001dH\u0016J\u0018\u00105\u001a\u00020\f2\u0006\u00109\u001a\u00020\u001d2\u0006\u00107\u001a\u00020\fH\u0016J\u0010\u0010:\u001a\u00020\f2\u0006\u0010;\u001a\u00020\u001dH\u0016J\u0018\u0010:\u001a\u00020\f2\u0006\u0010;\u001a\u00020\u001d2\u0006\u00107\u001a\u00020\fH\u0016J\b\u0010<\u001a\u00020=H\u0016J\b\u0010>\u001a\u00020#H\u0016J\u0006\u0010?\u001a\u00020\u001dJ\b\u0010@\u001a\u00020\u0019H\u0016J\b\u0010A\u001a\u00020\u0001H\u0016J\u0018\u0010B\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u00109\u001a\u00020\u001dH\u0016J(\u0010B\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u00109\u001a\u00020\u001d2\u0006\u0010C\u001a\u00020/2\u0006\u0010\u001b\u001a\u00020/H\u0016J\u0010\u0010D\u001a\u00020/2\u0006\u0010E\u001a\u00020FH\u0016J\u0010\u0010D\u001a\u00020/2\u0006\u0010E\u001a\u00020GH\u0016J \u0010D\u001a\u00020/2\u0006\u0010E\u001a\u00020G2\u0006\u0010\u001a\u001a\u00020/2\u0006\u0010\u001b\u001a\u00020/H\u0016J\u0018\u0010D\u001a\u00020\f2\u0006\u0010E\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010H\u001a\u00020\f2\u0006\u0010E\u001a\u00020IH\u0016J\u0012\u0010J\u001a\u00020K2\b\b\u0002\u0010L\u001a\u00020KH\u0007J\b\u0010M\u001a\u00020)H\u0016J\b\u0010N\u001a\u00020GH\u0016J\u0010\u0010N\u001a\u00020G2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010O\u001a\u00020\u001dH\u0016J\u0010\u0010O\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010P\u001a\u00020\fH\u0016J\u000e\u0010Q\u001a\u00020\u00002\u0006\u0010R\u001a\u00020=J\u0016\u0010Q\u001a\u00020\u00002\u0006\u0010R\u001a\u00020=2\u0006\u0010\u001b\u001a\u00020\fJ \u0010Q\u001a\u00020\u00122\u0006\u0010R\u001a\u00020=2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010S\u001a\u00020#H\u0002J\u0010\u0010T\u001a\u00020\u00122\u0006\u0010E\u001a\u00020GH\u0016J\u0018\u0010T\u001a\u00020\u00122\u0006\u0010E\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010U\u001a\u00020\fH\u0016J\b\u0010V\u001a\u00020/H\u0016J\b\u0010W\u001a\u00020/H\u0016J\b\u0010X\u001a\u00020\fH\u0016J\b\u0010Y\u001a\u00020\fH\u0016J\b\u0010Z\u001a\u00020[H\u0016J\b\u0010\\\u001a\u00020[H\u0016J\u0010\u0010]\u001a\u00020\u001f2\u0006\u0010^\u001a\u00020_H\u0016J\u0018\u0010]\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010^\u001a\u00020_H\u0016J\u0012\u0010`\u001a\u00020K2\b\b\u0002\u0010L\u001a\u00020KH\u0007J\b\u0010a\u001a\u00020\u001fH\u0016J\u0010\u0010a\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010b\u001a\u00020/H\u0016J\n\u0010c\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010d\u001a\u00020\u001fH\u0016J\u0010\u0010d\u001a\u00020\u001f2\u0006\u0010e\u001a\u00020\fH\u0016J\u0010\u0010f\u001a\u00020#2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010g\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010h\u001a\u00020/2\u0006\u0010i\u001a\u00020jH\u0016J\u0006\u0010k\u001a\u00020\u001dJ\u0006\u0010l\u001a\u00020\u001dJ\u0006\u0010m\u001a\u00020\u001dJ\r\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0002\bnJ\u0010\u0010o\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0006\u0010p\u001a\u00020\u001dJ\u000e\u0010p\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020/J\b\u0010q\u001a\u00020rH\u0016J\b\u0010s\u001a\u00020\u001fH\u0016J\u0015\u0010t\u001a\u00020\n2\u0006\u0010u\u001a\u00020/H\u0000¢\u0006\u0002\bvJ\u0010\u0010w\u001a\u00020/2\u0006\u0010x\u001a\u00020FH\u0016J\u0010\u0010w\u001a\u00020\u00002\u0006\u0010x\u001a\u00020GH\u0016J \u0010w\u001a\u00020\u00002\u0006\u0010x\u001a\u00020G2\u0006\u0010\u001a\u001a\u00020/2\u0006\u0010\u001b\u001a\u00020/H\u0016J\u0018\u0010w\u001a\u00020\u00122\u0006\u0010x\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010w\u001a\u00020\u00002\u0006\u0010y\u001a\u00020\u001dH\u0016J \u0010w\u001a\u00020\u00002\u0006\u0010y\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020/2\u0006\u0010\u001b\u001a\u00020/H\u0016J\u0018\u0010w\u001a\u00020\u00002\u0006\u0010x\u001a\u00020z2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010{\u001a\u00020\f2\u0006\u0010x\u001a\u00020zH\u0016J\u0010\u0010|\u001a\u00020\u00002\u0006\u00106\u001a\u00020/H\u0016J\u0010\u0010}\u001a\u00020\u00002\u0006\u0010~\u001a\u00020\fH\u0016J\u0010\u0010\u007f\u001a\u00020\u00002\u0006\u0010~\u001a\u00020\fH\u0016J\u0012\u0010\u0080\u0001\u001a\u00020\u00002\u0007\u0010\u0081\u0001\u001a\u00020/H\u0016J\u0012\u0010\u0082\u0001\u001a\u00020\u00002\u0007\u0010\u0081\u0001\u001a\u00020/H\u0016J\u0011\u0010\u0083\u0001\u001a\u00020\u00002\u0006\u0010~\u001a\u00020\fH\u0016J\u0011\u0010\u0084\u0001\u001a\u00020\u00002\u0006\u0010~\u001a\u00020\fH\u0016J\u0012\u0010\u0085\u0001\u001a\u00020\u00002\u0007\u0010\u0086\u0001\u001a\u00020/H\u0016J\u0012\u0010\u0087\u0001\u001a\u00020\u00002\u0007\u0010\u0086\u0001\u001a\u00020/H\u0016J\u001a\u0010\u0088\u0001\u001a\u00020\u00002\u0007\u0010\u0089\u0001\u001a\u00020\u001f2\u0006\u0010^\u001a\u00020_H\u0016J,\u0010\u0088\u0001\u001a\u00020\u00002\u0007\u0010\u0089\u0001\u001a\u00020\u001f2\u0007\u0010\u008a\u0001\u001a\u00020/2\u0007\u0010\u008b\u0001\u001a\u00020/2\u0006\u0010^\u001a\u00020_H\u0016J\u001b\u0010\u008c\u0001\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\fH\u0007J\u0012\u0010\u008d\u0001\u001a\u00020\u00002\u0007\u0010\u0089\u0001\u001a\u00020\u001fH\u0016J$\u0010\u008d\u0001\u001a\u00020\u00002\u0007\u0010\u0089\u0001\u001a\u00020\u001f2\u0007\u0010\u008a\u0001\u001a\u00020/2\u0007\u0010\u008b\u0001\u001a\u00020/H\u0016J\u0012\u0010\u008e\u0001\u001a\u00020\u00002\u0007\u0010\u008f\u0001\u001a\u00020/H\u0016R\u0014\u0010\u0006\u001a\u00020\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u0004\u0018\u00010\n8\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R&\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8G@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0091\u0001" }, d2 = { "Lokio/Buffer;", "Lokio/BufferedSource;", "Lokio/BufferedSink;", "", "Ljava/nio/channels/ByteChannel;", "()V", "buffer", "getBuffer", "()Lokio/Buffer;", "head", "Lokio/Segment;", "<set-?>", "", "size", "()J", "setSize$okio", "(J)V", "clear", "", "clone", "close", "completeSegmentByteCount", "copy", "copyTo", "out", "Ljava/io/OutputStream;", "offset", "byteCount", "digest", "Lokio/ByteString;", "algorithm", "", "emit", "emitCompleteSegments", "equals", "", "other", "", "exhausted", "flush", "get", "", "pos", "getByte", "index", "-deprecated_getByte", "hashCode", "", "hmac", "key", "hmacSha1", "hmacSha256", "hmacSha512", "indexOf", "b", "fromIndex", "toIndex", "bytes", "indexOfElement", "targetBytes", "inputStream", "Ljava/io/InputStream;", "isOpen", "md5", "outputStream", "peek", "rangeEquals", "bytesOffset", "read", "sink", "Ljava/nio/ByteBuffer;", "", "readAll", "Lokio/Sink;", "readAndWriteUnsafe", "Lokio/Buffer$UnsafeCursor;", "unsafeCursor", "readByte", "readByteArray", "readByteString", "readDecimalLong", "readFrom", "input", "forever", "readFully", "readHexadecimalUnsignedLong", "readInt", "readIntLe", "readLong", "readLongLe", "readShort", "", "readShortLe", "readString", "charset", "Ljava/nio/charset/Charset;", "readUnsafe", "readUtf8", "readUtf8CodePoint", "readUtf8Line", "readUtf8LineStrict", "limit", "request", "require", "select", "options", "Lokio/Options;", "sha1", "sha256", "sha512", "-deprecated_size", "skip", "snapshot", "timeout", "Lokio/Timeout;", "toString", "writableSegment", "minimumCapacity", "writableSegment$okio", "write", "source", "byteString", "Lokio/Source;", "writeAll", "writeByte", "writeDecimalLong", "v", "writeHexadecimalUnsignedLong", "writeInt", "i", "writeIntLe", "writeLong", "writeLongLe", "writeShort", "s", "writeShortLe", "writeString", "string", "beginIndex", "endIndex", "writeTo", "writeUtf8", "writeUtf8CodePoint", "codePoint", "UnsafeCursor", "okio" })
@SourceDebugExtension({ "SMAP\nBuffer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Buffer.kt\nokio/Buffer\n+ 2 Util.kt\nokio/DSegmentedByteString\n+ 3 Buffer.kt\nokio/internal/DBuffer\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,641:1\n89#2:642\n86#2:675\n86#2:677\n74#2:737\n74#2:763\n83#2:802\n77#2:813\n89#2:1003\n74#2:1018\n86#2:1122\n89#2:1615\n244#3,32:643\n279#3,10:678\n292#3,18:688\n414#3,2:706\n112#3:708\n416#3:709\n114#3,18:710\n313#3,9:728\n322#3,15:738\n340#3,10:753\n350#3,3:764\n348#3,25:767\n376#3,10:792\n386#3:803\n384#3,9:804\n393#3,7:814\n391#3,20:821\n682#3,60:841\n745#3,56:901\n803#3:957\n806#3:958\n807#3,6:960\n817#3,7:966\n827#3,6:973\n835#3,5:979\n867#3,6:984\n877#3:990\n878#3,11:992\n889#3,5:1004\n898#3,9:1009\n908#3,61:1019\n633#3:1080\n636#3:1081\n637#3,5:1083\n644#3:1088\n647#3,7:1089\n656#3,20:1096\n420#3:1116\n423#3,5:1117\n428#3,10:1123\n439#3,7:1133\n444#3,2:1140\n973#3:1142\n974#3,87:1144\n1064#3,48:1231\n603#3:1279\n610#3,21:1280\n1115#3,7:1301\n1125#3,7:1308\n1135#3,4:1315\n1142#3,8:1319\n1153#3,10:1327\n1166#3,14:1337\n449#3,91:1351\n543#3,40:1442\n586#3:1482\n588#3,13:1484\n1183#3:1497\n1234#3:1498\n1235#3,39:1500\n1276#3,2:1539\n1278#3,4:1542\n1285#3,3:1546\n1289#3,4:1550\n112#3:1554\n1293#3,22:1555\n114#3,18:1577\n1319#3,2:1595\n1321#3,3:1598\n112#3:1601\n1324#3,13:1602\n1337#3,13:1616\n114#3,18:1629\n1354#3,2:1647\n1357#3:1650\n112#3:1651\n1358#3,50:1652\n114#3,18:1702\n1417#3,14:1720\n1434#3,32:1734\n1469#3,12:1766\n1484#3,18:1778\n1506#3:1796\n1507#3:1798\n1512#3,34:1799\n1#4:676\n1#4:959\n1#4:991\n1#4:1082\n1#4:1143\n1#4:1483\n1#4:1499\n1#4:1541\n1#4:1549\n1#4:1597\n1#4:1649\n1#4:1797\n*S KotlinDebug\n*F\n+ 1 Buffer.kt\nokio/Buffer\n*L\n167#1:642\n197#1:675\n235#1:677\n261#1:737\n264#1:763\n267#1:802\n267#1:813\n335#1:1003\n338#1:1018\n374#1:1122\n483#1:1615\n181#1:643,32\n252#1:678,10\n255#1:688,18\n258#1:706,2\n258#1:708\n258#1:709\n258#1:710,18\n261#1:728,9\n261#1:738,15\n264#1:753,10\n264#1:764,3\n264#1:767,25\n267#1:792,10\n267#1:803\n267#1:804,9\n267#1:814,7\n267#1:821,20\n279#1:841,60\n282#1:901,56\n284#1:957\n287#1:958\n287#1:960,6\n289#1:966,7\n292#1:973,6\n295#1:979,5\n329#1:984,6\n335#1:990\n335#1:992,11\n335#1:1004,5\n338#1:1009,9\n338#1:1019,61\n340#1:1080\n343#1:1081\n343#1:1083,5\n345#1:1088\n348#1:1089,7\n351#1:1096,20\n371#1:1116\n374#1:1117,5\n374#1:1123,10\n376#1:1133,7\n379#1:1140,2\n384#1:1142\n384#1:1144,87\n387#1:1231,48\n410#1:1279\n416#1:1280,21\n437#1:1301,7\n441#1:1308,7\n443#1:1315,4\n445#1:1319,8\n449#1:1327,10\n453#1:1337,14\n457#1:1351,91\n460#1:1442,40\n463#1:1482\n463#1:1484,13\n465#1:1497\n465#1:1498\n465#1:1500,39\n467#1:1539,2\n467#1:1542,4\n477#1:1546,3\n477#1:1550,4\n477#1:1554\n477#1:1555,22\n477#1:1577,18\n483#1:1595,2\n483#1:1598,3\n483#1:1601\n483#1:1602,13\n483#1:1616,13\n483#1:1629,18\n488#1:1647,2\n488#1:1650\n488#1:1651\n488#1:1652,50\n488#1:1702,18\n498#1:1720,14\n568#1:1734,32\n570#1:1766,12\n578#1:1778,18\n586#1:1796\n586#1:1798\n588#1:1799,34\n287#1:959\n335#1:991\n343#1:1082\n384#1:1143\n463#1:1483\n465#1:1499\n467#1:1541\n477#1:1549\n483#1:1597\n488#1:1649\n586#1:1797\n*E\n" })
public class Buffer implements BufferedSource, BufferedSink, Cloneable, ByteChannel
{
    @JvmField
    @Nullable
    public Segment head;
    private long size;
    
    @JvmName(name = "size")
    public final long size() {
        return this.size;
    }
    
    public final void setSize$okio(final long size) {
        this.size = size;
    }
    
    @NotNull
    @Override
    public Buffer buffer() {
        return this;
    }
    
    @NotNull
    @Override
    public Buffer getBuffer() {
        return this;
    }
    
    @NotNull
    @Override
    public OutputStream outputStream() {
        return (OutputStream)new Buffer$outputStream.Buffer$outputStream$1(this);
    }
    
    @NotNull
    @Override
    public Buffer emitCompleteSegments() {
        return this;
    }
    
    @NotNull
    @Override
    public Buffer emit() {
        return this;
    }
    
    @Override
    public boolean exhausted() {
        return this.size == 0L;
    }
    
    @Override
    public void require(final long n) throws EOFException {
        if (this.size < n) {
            throw new EOFException();
        }
    }
    
    @Override
    public boolean request(final long n) {
        return this.size >= n;
    }
    
    @NotNull
    @Override
    public BufferedSource peek() {
        return Okio.buffer(new PeekSource(this));
    }
    
    @NotNull
    @Override
    public InputStream inputStream() {
        return (InputStream)new Buffer$inputStream.Buffer$inputStream$1(this);
    }
    
    @JvmOverloads
    @NotNull
    public final Buffer copyTo(@NotNull final OutputStream outputStream, final long n, final long n2) throws IOException {
        Intrinsics.checkNotNullParameter(outputStream, "out");
        long n3 = n;
        long b = n2;
        DSegmentedByteString.checkOffsetAndCount(this.size, n3, b);
        if (b == 0L) {
            return this;
        }
        Segment segment = this.head;
        while (true) {
            final long n4 = n3;
            final Segment segment2 = segment;
            Intrinsics.checkNotNull(segment2);
            if (n4 < segment2.limit - segment.pos) {
                break;
            }
            n3 -= segment.limit - segment.pos;
            segment = segment.next;
        }
        while (b > 0L) {
            final Segment segment3 = segment;
            Intrinsics.checkNotNull(segment3);
            final int off = (int)(segment3.pos + n3);
            final int len = (int)Math.min(segment.limit - off, b);
            outputStream.write(segment.data, off, len);
            b -= len;
            n3 = 0L;
            segment = segment.next;
        }
        return this;
    }
    
    public static /* synthetic */ Buffer copyTo$default(final Buffer buffer, final OutputStream outputStream, long n, long n2, final int n3, final Object o) throws IOException {
        if ((n3 & 0x2) != 0x0) {
            n = 0L;
        }
        if ((n3 & 0x4) != 0x0) {
            n2 = buffer.size - n;
        }
        return buffer.copyTo(outputStream, n, n2);
    }
    
    @NotNull
    public final Buffer copyTo(@NotNull final Buffer buffer, final long n, final long n2) {
        Intrinsics.checkNotNullParameter(buffer, "out");
        long n3 = n;
        long n4 = n2;
        DSegmentedByteString.checkOffsetAndCount(this.size(), n3, n4);
        Buffer buffer2;
        if (n4 == 0L) {
            buffer2 = this;
        }
        else {
            buffer.setSize$okio(buffer.size() + n4);
            Segment segment = this.head;
            while (true) {
                final long n5 = n3;
                final Segment segment2 = segment;
                Intrinsics.checkNotNull(segment2);
                if (n5 < segment2.limit - segment.pos) {
                    break;
                }
                n3 -= segment.limit - segment.pos;
                segment = segment.next;
            }
            while (n4 > 0L) {
                final Segment segment3 = segment;
                Intrinsics.checkNotNull(segment3);
                final Segment sharedCopy = segment3.sharedCopy();
                sharedCopy.pos += (int)n3;
                sharedCopy.limit = Math.min(sharedCopy.pos + (int)n4, sharedCopy.limit);
                if (buffer.head == null) {
                    sharedCopy.prev = sharedCopy;
                    sharedCopy.next = sharedCopy.prev;
                    buffer.head = sharedCopy.next;
                }
                else {
                    final Segment head = buffer.head;
                    Intrinsics.checkNotNull(head);
                    final Segment prev = head.prev;
                    Intrinsics.checkNotNull(prev);
                    prev.push(sharedCopy);
                }
                n4 -= sharedCopy.limit - sharedCopy.pos;
                n3 = 0L;
                segment = segment.next;
            }
            buffer2 = this;
        }
        return buffer2;
    }
    
    @NotNull
    public final Buffer copyTo(@NotNull final Buffer buffer, final long n) {
        Intrinsics.checkNotNullParameter(buffer, "out");
        return this.copyTo(buffer, n, this.size - n);
    }
    
    @JvmOverloads
    @NotNull
    public final Buffer writeTo(@NotNull final OutputStream outputStream, final long n) throws IOException {
        Intrinsics.checkNotNullParameter(outputStream, "out");
        long a = n;
        DSegmentedByteString.checkOffsetAndCount(this.size, 0L, a);
        Segment head = this.head;
        while (a > 0L) {
            final Segment segment = head;
            Intrinsics.checkNotNull(segment);
            final int len = (int)Math.min(a, segment.limit - head.pos);
            outputStream.write(head.data, head.pos, len);
            final Segment segment2 = head;
            segment2.pos += len;
            this.size -= len;
            a -= len;
            if (head.pos == head.limit) {
                final Segment segment3 = head;
                head = segment3.pop();
                this.head = head;
                SegmentPool.recycle(segment3);
            }
        }
        return this;
    }
    
    public static /* synthetic */ Buffer writeTo$default(final Buffer buffer, final OutputStream outputStream, long size, final int n, final Object o) throws IOException {
        if ((n & 0x2) != 0x0) {
            size = buffer.size;
        }
        return buffer.writeTo(outputStream, size);
    }
    
    @NotNull
    public final Buffer readFrom(@NotNull final InputStream inputStream) throws IOException {
        Intrinsics.checkNotNullParameter(inputStream, "input");
        this.readFrom(inputStream, Long.MAX_VALUE, true);
        return this;
    }
    
    @NotNull
    public final Buffer readFrom(@NotNull final InputStream inputStream, final long lng) throws IOException {
        Intrinsics.checkNotNullParameter(inputStream, "input");
        if (lng < 0L) {
            throw new IllegalArgumentException(("byteCount < 0: " + lng).toString());
        }
        this.readFrom(inputStream, lng, false);
        return this;
    }
    
    private final void readFrom(final InputStream inputStream, final long n, final boolean b) throws IOException {
        long a = n;
        while (a > 0L || b) {
            final Segment writableSegment$okio = this.writableSegment$okio(1);
            final int read = inputStream.read(writableSegment$okio.data, writableSegment$okio.limit, (int)Math.min(a, 8192 - writableSegment$okio.limit));
            if (read == -1) {
                if (writableSegment$okio.pos == writableSegment$okio.limit) {
                    this.head = writableSegment$okio.pop();
                    SegmentPool.recycle(writableSegment$okio);
                }
                if (b) {
                    return;
                }
                throw new EOFException();
            }
            else {
                writableSegment$okio.limit += read;
                this.size += read;
                a -= read;
            }
        }
    }
    
    public final long completeSegmentByteCount() {
        long size = this.size();
        long n;
        if (size == 0L) {
            n = 0L;
        }
        else {
            final Segment head = this.head;
            Intrinsics.checkNotNull(head);
            final Segment prev = head.prev;
            Intrinsics.checkNotNull(prev);
            final Segment segment = prev;
            if (segment.limit < 8192 && segment.owner) {
                size -= segment.limit - segment.pos;
            }
            n = size;
        }
        return n;
    }
    
    @Override
    public byte readByte() throws EOFException {
        if (this.size() == 0L) {
            throw new EOFException();
        }
        final Segment head = this.head;
        Intrinsics.checkNotNull(head);
        final Segment segment = head;
        int pos = segment.pos;
        final int limit = segment.limit;
        final byte b = segment.data[pos++];
        this.setSize$okio(this.size() - 1L);
        if (pos == limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        else {
            segment.pos = pos;
        }
        return b;
    }
    
    @JvmName(name = "getByte")
    public final byte getByte(final long n) {
        DSegmentedByteString.checkOffsetAndCount(this.size(), n, 1L);
        final Segment head = this.head;
        byte b;
        if (head == null) {
            final Segment segment = null;
            final long n2 = -1L;
            final Segment segment3;
            final Segment segment2 = segment3 = segment;
            Intrinsics.checkNotNull(segment3);
            b = segment3.data[(int)(segment2.pos + n - n2)];
        }
        else {
            Segment segment4 = head;
            if (this.size() - n < n) {
                long size;
                for (size = this.size(); size > n; size -= segment4.limit - segment4.pos) {
                    final Segment prev = segment4.prev;
                    Intrinsics.checkNotNull(prev);
                    segment4 = prev;
                }
                final Segment segment5 = segment4;
                final long n3 = size;
                final Segment segment7;
                final Segment segment6 = segment7 = segment5;
                Intrinsics.checkNotNull(segment7);
                b = segment7.data[(int)(segment6.pos + n - n3)];
            }
            else {
                long n4 = 0L;
                while (true) {
                    final long n5 = n4 + (segment4.limit - segment4.pos);
                    if (n5 > n) {
                        break;
                    }
                    final Segment next = segment4.next;
                    Intrinsics.checkNotNull(next);
                    segment4 = next;
                    n4 = n5;
                }
                final Segment segment8 = segment4;
                final long n6 = n4;
                final Segment segment10;
                final Segment segment9 = segment10 = segment8;
                Intrinsics.checkNotNull(segment10);
                b = segment10.data[(int)(segment9.pos + n - n6)];
            }
        }
        return b;
    }
    
    @Override
    public short readShort() throws EOFException {
        if (this.size() < 2L) {
            throw new EOFException();
        }
        final Segment head = this.head;
        Intrinsics.checkNotNull(head);
        final Segment segment = head;
        int pos = segment.pos;
        final int limit = segment.limit;
        short n;
        if (limit - pos < 2) {
            n = (short)((this.readByte() & 0xFF) << 8 | (this.readByte() & 0xFF));
        }
        else {
            final byte[] data = segment.data;
            final int n2 = (data[pos++] & 0xFF) << 8 | (data[pos++] & 0xFF);
            this.setSize$okio(this.size() - 2L);
            if (pos == limit) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            }
            else {
                segment.pos = pos;
            }
            n = (short)n2;
        }
        return n;
    }
    
    @Override
    public int readInt() throws EOFException {
        if (this.size() < 4L) {
            throw new EOFException();
        }
        final Segment head = this.head;
        Intrinsics.checkNotNull(head);
        final Segment segment = head;
        int pos = segment.pos;
        final int limit = segment.limit;
        int n;
        if (limit - pos < 4L) {
            n = ((this.readByte() & 0xFF) << 24 | (this.readByte() & 0xFF) << 16 | (this.readByte() & 0xFF) << 8 | (this.readByte() & 0xFF));
        }
        else {
            final byte[] data = segment.data;
            final int n2 = (data[pos++] & 0xFF) << 24 | (data[pos++] & 0xFF) << 16 | (data[pos++] & 0xFF) << 8 | (data[pos++] & 0xFF);
            this.setSize$okio(this.size() - 4L);
            if (pos == limit) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            }
            else {
                segment.pos = pos;
            }
            n = n2;
        }
        return n;
    }
    
    @Override
    public long readLong() throws EOFException {
        if (this.size() < 8L) {
            throw new EOFException();
        }
        final Segment head = this.head;
        Intrinsics.checkNotNull(head);
        final Segment segment = head;
        int pos = segment.pos;
        final int limit = segment.limit;
        long n;
        if (limit - pos < 8L) {
            n = (((long)this.readInt() & 0xFFFFFFFFL) << 32 | ((long)this.readInt() & 0xFFFFFFFFL));
        }
        else {
            final byte[] data = segment.data;
            final long n2 = ((long)data[pos++] & 0xFFL) << 56 | ((long)data[pos++] & 0xFFL) << 48 | ((long)data[pos++] & 0xFFL) << 40 | ((long)data[pos++] & 0xFFL) << 32 | ((long)data[pos++] & 0xFFL) << 24 | ((long)data[pos++] & 0xFFL) << 16 | ((long)data[pos++] & 0xFFL) << 8 | ((long)data[pos++] & 0xFFL);
            this.setSize$okio(this.size() - 8L);
            if (pos == limit) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            }
            else {
                segment.pos = pos;
            }
            n = n2;
        }
        return n;
    }
    
    @Override
    public short readShortLe() throws EOFException {
        return DSegmentedByteString.reverseBytes(this.readShort());
    }
    
    @Override
    public int readIntLe() throws EOFException {
        return DSegmentedByteString.reverseBytes(this.readInt());
    }
    
    @Override
    public long readLongLe() throws EOFException {
        return DSegmentedByteString.reverseBytes(this.readLong());
    }
    
    @Override
    public long readDecimalLong() throws EOFException {
        if (this.size() == 0L) {
            throw new EOFException();
        }
        long n = 0L;
        int n2 = 0;
        int n3 = 0;
        boolean b = false;
        long n4 = -7L;
        do {
            final Segment head = this.head;
            Intrinsics.checkNotNull(head);
            final Segment segment = head;
            final byte[] data = segment.data;
            int i;
            int limit;
            for (i = segment.pos, limit = segment.limit; i < limit; ++i, ++n2) {
                final byte b2 = data[i];
                if (b2 >= 48 && b2 <= 57) {
                    final int n5 = 48 - b2;
                    if (n < -922337203685477580L || (n == -922337203685477580L && n5 < n4)) {
                        final Buffer writeByte = new Buffer().writeDecimalLong(n).writeByte((int)b2);
                        if (n3 == 0) {
                            writeByte.readByte();
                        }
                        throw new NumberFormatException("Number too large: " + writeByte.readUtf8());
                    }
                    n = n * 10L + n5;
                }
                else {
                    if (b2 != 45 || n2 != 0) {
                        b = true;
                        break;
                    }
                    n3 = 1;
                    --n4;
                }
            }
            if (i == limit) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            }
            else {
                segment.pos = i;
            }
        } while (!b && this.head != null);
        this.setSize$okio(this.size() - n2);
        if (n2 >= ((n3 != 0) ? 2 : 1)) {
            return (n3 != 0) ? n : (-n);
        }
        if (this.size() == 0L) {
            throw new EOFException();
        }
        throw new NumberFormatException(((n3 != 0) ? "Expected a digit" : "Expected a digit or '-'") + " but was 0x" + DSegmentedByteString.toHexString(this.getByte(0L)));
    }
    
    @Override
    public long readHexadecimalUnsignedLong() throws EOFException {
        if (this.size() == 0L) {
            throw new EOFException();
        }
        long n = 0L;
        int n2 = 0;
        boolean b = false;
        do {
            final Segment head = this.head;
            Intrinsics.checkNotNull(head);
            final Segment segment = head;
            final byte[] data = segment.data;
            int i;
            int limit;
            for (i = segment.pos, limit = segment.limit; i < limit; ++i, ++n2) {
                final byte b2 = data[i];
                int n3;
                if (b2 >= 48 && b2 <= 57) {
                    n3 = b2 - 48;
                }
                else if (b2 >= 97 && b2 <= 102) {
                    n3 = b2 - 97 + 10;
                }
                else if (b2 >= 65 && b2 <= 70) {
                    n3 = b2 - 65 + 10;
                }
                else {
                    if (n2 == 0) {
                        throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + DSegmentedByteString.toHexString(b2));
                    }
                    b = true;
                    break;
                }
                if ((n & 0xF000000000000000L) != 0x0L) {
                    throw new NumberFormatException("Number too large: " + new Buffer().writeHexadecimalUnsignedLong(n).writeByte((int)b2).readUtf8());
                }
                n = (n << 4 | (long)n3);
            }
            if (i == limit) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            }
            else {
                segment.pos = i;
            }
        } while (!b && this.head != null);
        this.setSize$okio(this.size() - n2);
        return n;
    }
    
    @NotNull
    @Override
    public ByteString readByteString() {
        return this.readByteString(this.size());
    }
    
    @NotNull
    @Override
    public ByteString readByteString(final long lng) throws EOFException {
        if (lng < 0L || lng > 2147483647L) {
            throw new IllegalArgumentException(("byteCount: " + lng).toString());
        }
        if (this.size() < lng) {
            throw new EOFException();
        }
        ByteString byteString;
        if (lng >= 4096L) {
            final ByteString snapshot = this.snapshot((int)lng);
            this.skip(lng);
            byteString = snapshot;
        }
        else {
            byteString = new ByteString(this.readByteArray(lng));
        }
        return byteString;
    }
    
    @Override
    public int select(@NotNull final Options options) {
        Intrinsics.checkNotNullParameter(options, "options");
        final int selectPrefix$default = DBuffer.selectPrefix$default(this, options, false, 2, null);
        int n;
        if (selectPrefix$default == -1) {
            n = -1;
        }
        else {
            this.skip(options.getByteStrings$okio()[selectPrefix$default].size());
            n = selectPrefix$default;
        }
        return n;
    }
    
    @Override
    public void readFully(@NotNull final Buffer buffer, final long n) throws EOFException {
        Intrinsics.checkNotNullParameter(buffer, "sink");
        if (this.size() < n) {
            buffer.write(this, this.size());
            throw new EOFException();
        }
        buffer.write(this, n);
    }
    
    @Override
    public long readAll(@NotNull final Sink sink) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        final long size = this.size();
        if (size > 0L) {
            sink.write(this, size);
        }
        return size;
    }
    
    @NotNull
    @Override
    public String readUtf8() {
        return this.readString(this.size, Charsets.UTF_8);
    }
    
    @NotNull
    @Override
    public String readUtf8(final long n) throws EOFException {
        return this.readString(n, Charsets.UTF_8);
    }
    
    @NotNull
    @Override
    public String readString(@NotNull final Charset charset) {
        Intrinsics.checkNotNullParameter(charset, "charset");
        return this.readString(this.size, charset);
    }
    
    @NotNull
    @Override
    public String readString(final long lng, @NotNull final Charset charset) throws EOFException {
        Intrinsics.checkNotNullParameter(charset, "charset");
        if (lng < 0L || lng > 2147483647L) {
            throw new IllegalArgumentException(("byteCount: " + lng).toString());
        }
        if (this.size < lng) {
            throw new EOFException();
        }
        if (lng == 0L) {
            return "";
        }
        final Segment head = this.head;
        Intrinsics.checkNotNull(head);
        final Segment segment = head;
        if (segment.pos + lng > segment.limit) {
            return new String(this.readByteArray(lng), charset);
        }
        final String s = new String(segment.data, segment.pos, (int)lng, charset);
        segment.pos += (int)lng;
        this.size -= lng;
        if (segment.pos == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return s;
    }
    
    @Nullable
    @Override
    public String readUtf8Line() throws EOFException {
        final long index = this.indexOf((byte)10);
        return (index != -1L) ? DBuffer.readUtf8Line(this, index) : ((this.size() != 0L) ? this.readUtf8(this.size()) : null);
    }
    
    @NotNull
    @Override
    public String readUtf8LineStrict() throws EOFException {
        return this.readUtf8LineStrict(Long.MAX_VALUE);
    }
    
    @NotNull
    @Override
    public String readUtf8LineStrict(final long n) throws EOFException {
        if (n < 0L) {
            throw new IllegalArgumentException(("limit < 0: " + n).toString());
        }
        final long n2 = (n == Long.MAX_VALUE) ? Long.MAX_VALUE : (n + 1L);
        final long index = this.indexOf((byte)10, 0L, n2);
        String s;
        if (index != -1L) {
            s = DBuffer.readUtf8Line(this, index);
        }
        else {
            if (n2 >= this.size() || this.getByte(n2 - 1L) != 13 || this.getByte(n2) != 10) {
                final Buffer buffer = new Buffer();
                this.copyTo(buffer, 0L, Math.min(32, this.size()));
                throw new EOFException("\\n not found: limit=" + Math.min(this.size(), n) + " content=" + buffer.readByteString().hex() + '\u2026');
            }
            s = DBuffer.readUtf8Line(this, n2);
        }
        return s;
    }
    
    @Override
    public int readUtf8CodePoint() throws EOFException {
        if (this.size() == 0L) {
            throw new EOFException();
        }
        final byte byte1 = this.getByte(0L);
        int n;
        int i;
        if ((byte1 & 0x80) == 0x0) {
            n = (byte1 & 0x7F);
            i = 1;
            final int n2 = 0;
        }
        else if ((byte1 & 0xE0) == 0xC0) {
            n = (byte1 & 0x1F);
            i = 2;
            final int n2 = 128;
        }
        else if ((byte1 & 0xF0) == 0xE0) {
            n = (byte1 & 0xF);
            i = 3;
            final int n2 = 2048;
        }
        else {
            if ((byte1 & 0xF8) != 0xF0) {
                this.skip(1L);
                return 65533;
            }
            n = (byte1 & 0x7);
            i = 4;
            final int n2 = 65536;
        }
        if (this.size() < i) {
            throw new EOFException("size < " + i + ": " + this.size() + " (to read code point prefixed 0x" + DSegmentedByteString.toHexString(byte1) + ')');
        }
        for (int j = 1; j < i; ++j) {
            final byte byte2 = this.getByte(j);
            if ((byte2 & 0xC0) != 0x80) {
                this.skip(j);
                return 65533;
            }
            n = (n << 6 | (byte2 & 0x3F));
        }
        this.skip(i);
        int n2;
        return (n > 1114111) ? 65533 : ((55296 <= n && n < 57344) ? 65533 : ((n < n2) ? 65533 : n));
    }
    
    @NotNull
    @Override
    public byte[] readByteArray() {
        return this.readByteArray(this.size());
    }
    
    @NotNull
    @Override
    public byte[] readByteArray(final long lng) throws EOFException {
        if (lng < 0L || lng > 2147483647L) {
            throw new IllegalArgumentException(("byteCount: " + lng).toString());
        }
        if (this.size() < lng) {
            throw new EOFException();
        }
        final byte[] array = new byte[(int)lng];
        this.readFully(array);
        return array;
    }
    
    @Override
    public int read(@NotNull final byte[] array) {
        Intrinsics.checkNotNullParameter(array, "sink");
        return this.read(array, 0, array.length);
    }
    
    @Override
    public void readFully(@NotNull final byte[] array) throws EOFException {
        Intrinsics.checkNotNullParameter(array, "sink");
        int read;
        for (int i = 0; i < array.length; i += read) {
            read = this.read(array, i, array.length - i);
            if (read == -1) {
                throw new EOFException();
            }
        }
    }
    
    @Override
    public int read(@NotNull final byte[] array, final int n, final int a) {
        Intrinsics.checkNotNullParameter(array, "sink");
        DSegmentedByteString.checkOffsetAndCount(array.length, n, a);
        final Segment head = this.head;
        int n2;
        if (head == null) {
            n2 = -1;
        }
        else {
            final Segment segment = head;
            final int min = Math.min(a, segment.limit - segment.pos);
            ArraysKt___ArraysJvmKt.copyInto(segment.data, array, n, segment.pos, segment.pos + min);
            segment.pos += min;
            this.setSize$okio(this.size() - min);
            if (segment.pos == segment.limit) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            }
            n2 = min;
        }
        return n2;
    }
    
    @Override
    public int read(@NotNull final ByteBuffer byteBuffer) throws IOException {
        Intrinsics.checkNotNullParameter(byteBuffer, "sink");
        final Segment head = this.head;
        if (head == null) {
            return -1;
        }
        final Segment segment = head;
        final int min = Math.min(byteBuffer.remaining(), segment.limit - segment.pos);
        byteBuffer.put(segment.data, segment.pos, min);
        segment.pos += min;
        this.size -= min;
        if (segment.pos == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return min;
    }
    
    public final void clear() {
        this.skip(this.size());
    }
    
    @Override
    public void skip(final long n) throws EOFException {
        long a = n;
        while (a > 0L) {
            final Segment head = this.head;
            if (head == null) {
                throw new EOFException();
            }
            final Segment segment = head;
            final int n2 = (int)Math.min(a, segment.limit - segment.pos);
            this.setSize$okio(this.size() - n2);
            a -= n2;
            segment.pos += n2;
            if (segment.pos != segment.limit) {
                continue;
            }
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
    }
    
    @NotNull
    @Override
    public Buffer write(@NotNull final ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        byteString.write$okio(this, 0, byteString.size());
        return this;
    }
    
    @NotNull
    @Override
    public Buffer write(@NotNull final ByteString byteString, final int n, final int n2) {
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        byteString.write$okio(this, n, n2);
        return this;
    }
    
    @NotNull
    @Override
    public Buffer writeUtf8(@NotNull final String s) {
        Intrinsics.checkNotNullParameter(s, "string");
        return this.writeUtf8(s, 0, s.length());
    }
    
    @NotNull
    @Override
    public Buffer writeUtf8(@NotNull final String s, final int n, final int a) {
        Intrinsics.checkNotNullParameter(s, "string");
        if (n < 0) {
            throw new IllegalArgumentException(("beginIndex < 0: " + n).toString());
        }
        if (a < n) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + a + " < " + n).toString());
        }
        if (a > s.length()) {
            throw new IllegalArgumentException(("endIndex > string.length: " + a + " > " + s.length()).toString());
        }
        int i = n;
        while (i < a) {
            final char char1 = s.charAt(i);
            if (char1 < '\u0080') {
                final Segment writableSegment$okio = this.writableSegment$okio(1);
                final byte[] data = writableSegment$okio.data;
                final int n2 = writableSegment$okio.limit - i;
                final int min = Math.min(a, 8192 - n2);
                data[n2 + i++] = (byte)char1;
                while (i < min) {
                    final char char2 = s.charAt(i);
                    if (char2 >= '\u0080') {
                        break;
                    }
                    data[n2 + i++] = (byte)char2;
                }
                final int n3 = i + n2 - writableSegment$okio.limit;
                writableSegment$okio.limit += n3;
                this.setSize$okio(this.size() + n3);
            }
            else if (char1 < '\u0800') {
                final Segment writableSegment$okio2 = this.writableSegment$okio(2);
                writableSegment$okio2.data[writableSegment$okio2.limit] = (byte)(char1 >> 6 | 0xC0);
                writableSegment$okio2.data[writableSegment$okio2.limit + 1] = (byte)((char1 & '?') | 0x80);
                writableSegment$okio2.limit += 2;
                this.setSize$okio(this.size() + 2L);
                ++i;
            }
            else if (char1 < '\ud800' || char1 > '\udfff') {
                final Segment writableSegment$okio3 = this.writableSegment$okio(3);
                writableSegment$okio3.data[writableSegment$okio3.limit] = (byte)(char1 >> 12 | 0xE0);
                writableSegment$okio3.data[writableSegment$okio3.limit + 1] = (byte)((char1 >> 6 & 0x3F) | 0x80);
                writableSegment$okio3.data[writableSegment$okio3.limit + 2] = (byte)((char1 & '?') | 0x80);
                writableSegment$okio3.limit += 3;
                this.setSize$okio(this.size() + 3L);
                ++i;
            }
            else {
                final char c = (i + 1 < a) ? s.charAt(i + 1) : '\0';
                if (char1 > '\udbff' || '\udc00' > c || c >= '\ue000') {
                    this.writeByte(63);
                    ++i;
                }
                else {
                    final int n4 = 65536 + ((char1 & '\u03ff') << 10 | (c & '\u03ff'));
                    final Segment writableSegment$okio4 = this.writableSegment$okio(4);
                    writableSegment$okio4.data[writableSegment$okio4.limit] = (byte)(n4 >> 18 | 0xF0);
                    writableSegment$okio4.data[writableSegment$okio4.limit + 1] = (byte)((n4 >> 12 & 0x3F) | 0x80);
                    writableSegment$okio4.data[writableSegment$okio4.limit + 2] = (byte)((n4 >> 6 & 0x3F) | 0x80);
                    writableSegment$okio4.data[writableSegment$okio4.limit + 3] = (byte)((n4 & 0x3F) | 0x80);
                    writableSegment$okio4.limit += 4;
                    this.setSize$okio(this.size() + 4L);
                    i += 2;
                }
            }
        }
        return this;
    }
    
    @NotNull
    @Override
    public Buffer writeUtf8CodePoint(final int n) {
        if (n < 128) {
            this.writeByte(n);
        }
        else if (n < 2048) {
            final Segment writableSegment$okio = this.writableSegment$okio(2);
            writableSegment$okio.data[writableSegment$okio.limit] = (byte)(n >> 6 | 0xC0);
            writableSegment$okio.data[writableSegment$okio.limit + 1] = (byte)((n & 0x3F) | 0x80);
            writableSegment$okio.limit += 2;
            this.setSize$okio(this.size() + 2L);
        }
        else if (55296 <= n && n < 57344) {
            this.writeByte(63);
        }
        else if (n < 65536) {
            final Segment writableSegment$okio2 = this.writableSegment$okio(3);
            writableSegment$okio2.data[writableSegment$okio2.limit] = (byte)(n >> 12 | 0xE0);
            writableSegment$okio2.data[writableSegment$okio2.limit + 1] = (byte)((n >> 6 & 0x3F) | 0x80);
            writableSegment$okio2.data[writableSegment$okio2.limit + 2] = (byte)((n & 0x3F) | 0x80);
            writableSegment$okio2.limit += 3;
            this.setSize$okio(this.size() + 3L);
        }
        else {
            if (n > 1114111) {
                throw new IllegalArgumentException("Unexpected code point: 0x" + DSegmentedByteString.toHexString(n));
            }
            final Segment writableSegment$okio3 = this.writableSegment$okio(4);
            writableSegment$okio3.data[writableSegment$okio3.limit] = (byte)(n >> 18 | 0xF0);
            writableSegment$okio3.data[writableSegment$okio3.limit + 1] = (byte)((n >> 12 & 0x3F) | 0x80);
            writableSegment$okio3.data[writableSegment$okio3.limit + 2] = (byte)((n >> 6 & 0x3F) | 0x80);
            writableSegment$okio3.data[writableSegment$okio3.limit + 3] = (byte)((n & 0x3F) | 0x80);
            writableSegment$okio3.limit += 4;
            this.setSize$okio(this.size() + 4L);
        }
        return this;
    }
    
    @NotNull
    @Override
    public Buffer writeString(@NotNull final String s, @NotNull final Charset charset) {
        Intrinsics.checkNotNullParameter(s, "string");
        Intrinsics.checkNotNullParameter(charset, "charset");
        return this.writeString(s, 0, s.length(), charset);
    }
    
    @NotNull
    @Override
    public Buffer writeString(@NotNull final String s, final int beginIndex, final int endIndex, @NotNull final Charset charset) {
        Intrinsics.checkNotNullParameter(s, "string");
        Intrinsics.checkNotNullParameter(charset, "charset");
        if (beginIndex < 0) {
            throw new IllegalArgumentException(("beginIndex < 0: " + beginIndex).toString());
        }
        if (endIndex < beginIndex) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + endIndex + " < " + beginIndex).toString());
        }
        if (endIndex > s.length()) {
            throw new IllegalArgumentException(("endIndex > string.length: " + endIndex + " > " + s.length()).toString());
        }
        if (Intrinsics.areEqual(charset, Charsets.UTF_8)) {
            return this.writeUtf8(s, beginIndex, endIndex);
        }
        final String substring = s.substring(beginIndex, endIndex);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        final byte[] bytes = substring.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        final byte[] array = bytes;
        return this.write(array, 0, array.length);
    }
    
    @NotNull
    @Override
    public Buffer write(@NotNull final byte[] array) {
        Intrinsics.checkNotNullParameter(array, "source");
        return this.write(array, 0, array.length);
    }
    
    @NotNull
    @Override
    public Buffer write(@NotNull final byte[] array, final int n, final int n2) {
        Intrinsics.checkNotNullParameter(array, "source");
        int i = n;
        DSegmentedByteString.checkOffsetAndCount(array.length, i, n2);
        Segment writableSegment$okio;
        int min;
        for (int n3 = i + n2; i < n3; i += min, writableSegment$okio.limit += min) {
            writableSegment$okio = this.writableSegment$okio(1);
            min = Math.min(n3 - i, 8192 - writableSegment$okio.limit);
            ArraysKt___ArraysJvmKt.copyInto(array, writableSegment$okio.data, writableSegment$okio.limit, i, i + min);
        }
        this.setSize$okio(this.size() + n2);
        return this;
    }
    
    @Override
    public int write(@NotNull final ByteBuffer byteBuffer) throws IOException {
        Intrinsics.checkNotNullParameter(byteBuffer, "source");
        int i;
        int n;
        Segment writableSegment$okio;
        int min;
        for (n = (i = byteBuffer.remaining()); i > 0; i -= min, writableSegment$okio.limit += min) {
            writableSegment$okio = this.writableSegment$okio(1);
            min = Math.min(i, 8192 - writableSegment$okio.limit);
            byteBuffer.get(writableSegment$okio.data, writableSegment$okio.limit, min);
        }
        this.size += n;
        return n;
    }
    
    @Override
    public long writeAll(@NotNull final Source source) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        long n = 0L;
        while (true) {
            final long read = source.read(this, 8192L);
            if (read == -1L) {
                break;
            }
            n += read;
        }
        return n;
    }
    
    @NotNull
    @Override
    public Buffer write(@NotNull final Source source, final long n) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        long read;
        for (long n2 = n; n2 > 0L; n2 -= read) {
            read = source.read(this, n2);
            if (read == -1L) {
                throw new EOFException();
            }
        }
        return this;
    }
    
    @NotNull
    @Override
    public Buffer writeByte(final int n) {
        final Segment writableSegment$okio = this.writableSegment$okio(1);
        writableSegment$okio.data[writableSegment$okio.limit++] = (byte)n;
        this.setSize$okio(this.size() + 1L);
        return this;
    }
    
    @NotNull
    @Override
    public Buffer writeShort(final int n) {
        final Segment writableSegment$okio = this.writableSegment$okio(2);
        final byte[] data = writableSegment$okio.data;
        int limit = writableSegment$okio.limit;
        data[limit++] = (byte)(n >>> 8 & 0xFF);
        data[limit++] = (byte)(n & 0xFF);
        writableSegment$okio.limit = limit;
        this.setSize$okio(this.size() + 2L);
        return this;
    }
    
    @NotNull
    @Override
    public Buffer writeShortLe(final int n) {
        return this.writeShort((int)DSegmentedByteString.reverseBytes((short)n));
    }
    
    @NotNull
    @Override
    public Buffer writeInt(final int n) {
        final Segment writableSegment$okio = this.writableSegment$okio(4);
        final byte[] data = writableSegment$okio.data;
        int limit = writableSegment$okio.limit;
        data[limit++] = (byte)(n >>> 24 & 0xFF);
        data[limit++] = (byte)(n >>> 16 & 0xFF);
        data[limit++] = (byte)(n >>> 8 & 0xFF);
        data[limit++] = (byte)(n & 0xFF);
        writableSegment$okio.limit = limit;
        this.setSize$okio(this.size() + 4L);
        return this;
    }
    
    @NotNull
    @Override
    public Buffer writeIntLe(final int n) {
        return this.writeInt(DSegmentedByteString.reverseBytes(n));
    }
    
    @NotNull
    @Override
    public Buffer writeLong(final long n) {
        final Segment writableSegment$okio = this.writableSegment$okio(8);
        final byte[] data = writableSegment$okio.data;
        int limit = writableSegment$okio.limit;
        data[limit++] = (byte)(n >>> 56 & 0xFFL);
        data[limit++] = (byte)(n >>> 48 & 0xFFL);
        data[limit++] = (byte)(n >>> 40 & 0xFFL);
        data[limit++] = (byte)(n >>> 32 & 0xFFL);
        data[limit++] = (byte)(n >>> 24 & 0xFFL);
        data[limit++] = (byte)(n >>> 16 & 0xFFL);
        data[limit++] = (byte)(n >>> 8 & 0xFFL);
        data[limit++] = (byte)(n & 0xFFL);
        writableSegment$okio.limit = limit;
        this.setSize$okio(this.size() + 8L);
        return this;
    }
    
    @NotNull
    @Override
    public Buffer writeLongLe(final long n) {
        return this.writeLong(DSegmentedByteString.reverseBytes(n));
    }
    
    @NotNull
    @Override
    public Buffer writeDecimalLong(final long n) {
        long n2 = n;
        Buffer buffer;
        if (n2 == 0L) {
            buffer = this.writeByte(48);
        }
        else {
            boolean b = false;
            if (n2 < 0L) {
                n2 = -n2;
                if (n2 < 0L) {
                    buffer = this.writeUtf8("-9223372036854775808");
                    return buffer;
                }
                b = true;
            }
            int n3 = (n2 < 100000000L) ? ((n2 < 10000L) ? ((n2 < 100L) ? ((n2 < 10L) ? 1 : 2) : ((n2 < 1000L) ? 3 : 4)) : ((n2 < 1000000L) ? ((n2 < 100000L) ? 5 : 6) : ((n2 < 10000000L) ? 7 : 8))) : ((n2 < 1000000000000L) ? ((n2 < 10000000000L) ? ((n2 < 1000000000L) ? 9 : 10) : ((n2 < 100000000000L) ? 11 : 12)) : ((n2 < 1000000000000000L) ? ((n2 < 10000000000000L) ? 13 : ((n2 < 100000000000000L) ? 14 : 15)) : ((n2 < 100000000000000000L) ? ((n2 < 10000000000000000L) ? 16 : 17) : ((n2 < 1000000000000000000L) ? 18 : 19))));
            if (b) {
                ++n3;
            }
            final Segment writableSegment$okio = this.writableSegment$okio(n3);
            final byte[] data = writableSegment$okio.data;
            int n4 = writableSegment$okio.limit + n3;
            while (n2 != 0L) {
                data[--n4] = DBuffer.getHEX_DIGIT_BYTES()[(int)(n2 % 10)];
                n2 /= 10;
            }
            if (b) {
                data[--n4] = 45;
            }
            writableSegment$okio.limit += n3;
            this.setSize$okio(this.size() + n3);
            buffer = this;
        }
        return buffer;
    }
    
    @NotNull
    @Override
    public Buffer writeHexadecimalUnsignedLong(final long n) {
        long n2 = n;
        Buffer writeByte;
        if (n2 == 0L) {
            writeByte = this.writeByte(48);
        }
        else {
            final long n3 = n2;
            final long n4 = n3 | n3 >>> 1;
            final long n5 = n4 | n4 >>> 2;
            final long n6 = n5 | n5 >>> 4;
            final long n7 = n6 | n6 >>> 8;
            final long n8 = n7 | n7 >>> 16;
            final long n9 = n8 | n8 >>> 32;
            final long n10 = n9 - (n9 >>> 1 & 0x5555555555555555L);
            final long n11 = (n10 >>> 2 & 0x3333333333333333L) + (n10 & 0x3333333333333333L);
            final long n12 = (n11 >>> 4) + n11 & 0xF0F0F0F0F0F0F0FL;
            final long n13 = n12 + (n12 >>> 8);
            final long n14 = n13 + (n13 >>> 16);
            final int n15 = (int)(((n14 & 0x3FL) + (n14 >>> 32 & 0x3FL) + 3) / 4);
            final Segment writableSegment$okio = this.writableSegment$okio(n15);
            final byte[] data = writableSegment$okio.data;
            for (int i = writableSegment$okio.limit + n15 - 1; i >= writableSegment$okio.limit; --i) {
                data[i] = DBuffer.getHEX_DIGIT_BYTES()[(int)(n2 & 0xFL)];
                n2 >>>= 4;
            }
            writableSegment$okio.limit += n15;
            this.setSize$okio(this.size() + n15);
            writeByte = this;
        }
        return writeByte;
    }
    
    @NotNull
    public final Segment writableSegment$okio(final int n) {
        if (n < 1 || n > 8192) {
            throw new IllegalArgumentException("unexpected capacity".toString());
        }
        Segment segment;
        if (this.head == null) {
            final Segment take = SegmentPool.take();
            this.head = take;
            take.prev = take;
            take.next = take;
            segment = take;
        }
        else {
            final Segment head = this.head;
            Intrinsics.checkNotNull(head);
            final Segment prev;
            Segment push = prev = head.prev;
            Intrinsics.checkNotNull(prev);
            if (prev.limit + n > 8192 || !push.owner) {
                push = push.push(SegmentPool.take());
            }
            segment = push;
        }
        return segment;
    }
    
    @Override
    public void write(@NotNull final Buffer buffer, final long n) {
        Intrinsics.checkNotNullParameter(buffer, "source");
        long n2 = n;
        if (buffer == this) {
            throw new IllegalArgumentException("source == this".toString());
        }
        DSegmentedByteString.checkOffsetAndCount(buffer.size(), 0L, n2);
        while (n2 > 0L) {
            final long n3 = n2;
            final Segment head = buffer.head;
            Intrinsics.checkNotNull(head);
            final int limit = head.limit;
            final Segment head2 = buffer.head;
            Intrinsics.checkNotNull(head2);
            if (n3 < limit - head2.pos) {
                Segment prev;
                if (this.head != null) {
                    final Segment head3 = this.head;
                    Intrinsics.checkNotNull(head3);
                    prev = head3.prev;
                }
                else {
                    prev = null;
                }
                final Segment segment = prev;
                if (segment != null && segment.owner && n2 + segment.limit - (segment.shared ? 0 : segment.pos) <= 8192L) {
                    final Segment head4 = buffer.head;
                    Intrinsics.checkNotNull(head4);
                    head4.writeTo(segment, (int)n2);
                    buffer.setSize$okio(buffer.size() - n2);
                    this.setSize$okio(this.size() + n2);
                    return;
                }
                final Segment head5 = buffer.head;
                Intrinsics.checkNotNull(head5);
                buffer.head = head5.split((int)n2);
            }
            final Segment head6;
            final Segment segment2 = head6 = buffer.head;
            Intrinsics.checkNotNull(head6);
            final long n4 = head6.limit - segment2.pos;
            buffer.head = segment2.pop();
            if (this.head == null) {
                this.head = segment2;
                segment2.prev = segment2;
                segment2.next = segment2.prev;
            }
            else {
                final Segment head7 = this.head;
                Intrinsics.checkNotNull(head7);
                final Segment prev2 = head7.prev;
                Intrinsics.checkNotNull(prev2);
                prev2.push(segment2).compact();
            }
            buffer.setSize$okio(buffer.size() - n4);
            this.setSize$okio(this.size() + n4);
            n2 -= n4;
        }
    }
    
    @Override
    public long read(@NotNull final Buffer buffer, final long n) {
        Intrinsics.checkNotNullParameter(buffer, "sink");
        long size = n;
        if (size < 0L) {
            throw new IllegalArgumentException(("byteCount < 0: " + size).toString());
        }
        long n2;
        if (this.size() == 0L) {
            n2 = -1L;
        }
        else {
            if (size > this.size()) {
                size = this.size();
            }
            buffer.write(this, size);
            n2 = size;
        }
        return n2;
    }
    
    @Override
    public long indexOf(final byte b) {
        return this.indexOf(b, 0L, Long.MAX_VALUE);
    }
    
    @Override
    public long indexOf(final byte b, final long n) {
        return this.indexOf(b, n, Long.MAX_VALUE);
    }
    
    @Override
    public long indexOf(final byte b, final long n, final long n2) {
        long lng = n;
        long size = n2;
        if (0L > lng || lng > size) {
            throw new IllegalArgumentException(("size=" + this.size() + " fromIndex=" + lng + " toIndex=" + size).toString());
        }
        if (size > this.size()) {
            size = this.size();
        }
        long n3;
        if (lng == size) {
            n3 = -1L;
        }
        else {
            final long n4 = lng;
            final Segment head = this.head;
            if (head == null) {
                n3 = -1L;
            }
            else {
                Segment segment = head;
                if (this.size() - n4 < n4) {
                    long size2;
                    for (size2 = this.size(); size2 > n4; size2 -= segment.limit - segment.pos) {
                        final Segment prev = segment.prev;
                        Intrinsics.checkNotNull(prev);
                        segment = prev;
                    }
                    final Segment segment2 = segment;
                    final long n5 = size2;
                    final Segment segment3 = segment2;
                    if (segment3 == null) {
                        n3 = -1L;
                    }
                    else {
                        Segment segment4 = segment3;
                        long n6 = n5;
                        while (n6 < size) {
                            final byte[] data = segment4.data;
                            for (int n7 = (int)Math.min(segment4.limit, segment4.pos + size - n6), i = (int)(segment4.pos + lng - n6); i < n7; ++i) {
                                if (data[i] == b) {
                                    n3 = i - segment4.pos + n6;
                                    return n3;
                                }
                            }
                            n6 = (lng = n6 + (segment4.limit - segment4.pos));
                            final Segment next = segment4.next;
                            Intrinsics.checkNotNull(next);
                            segment4 = next;
                        }
                        n3 = -1L;
                    }
                }
                else {
                    long n8 = 0L;
                    while (true) {
                        final long n9 = n8 + (segment.limit - segment.pos);
                        if (n9 > n4) {
                            break;
                        }
                        final Segment next2 = segment.next;
                        Intrinsics.checkNotNull(next2);
                        segment = next2;
                        n8 = n9;
                    }
                    final Segment segment5 = segment;
                    final long n10 = n8;
                    final Segment segment6 = segment5;
                    if (segment6 == null) {
                        n3 = -1L;
                    }
                    else {
                        Segment segment7 = segment6;
                        long n11 = n10;
                        while (n11 < size) {
                            final byte[] data2 = segment7.data;
                            for (int n12 = (int)Math.min(segment7.limit, segment7.pos + size - n11), j = (int)(segment7.pos + lng - n11); j < n12; ++j) {
                                if (data2[j] == b) {
                                    n3 = j - segment7.pos + n11;
                                    return n3;
                                }
                            }
                            n11 = (lng = n11 + (segment7.limit - segment7.pos));
                            final Segment next3 = segment7.next;
                            Intrinsics.checkNotNull(next3);
                            segment7 = next3;
                        }
                        n3 = -1L;
                    }
                }
            }
        }
        return n3;
    }
    
    @Override
    public long indexOf(@NotNull final ByteString byteString) throws IOException {
        Intrinsics.checkNotNullParameter(byteString, "bytes");
        return this.indexOf(byteString, 0L);
    }
    
    @Override
    public long indexOf(@NotNull final ByteString byteString, final long n) throws IOException {
        Intrinsics.checkNotNullParameter(byteString, "bytes");
        long lng = n;
        if (byteString.size() <= 0) {
            throw new IllegalArgumentException("bytes is empty".toString());
        }
        if (lng < 0L) {
            throw new IllegalArgumentException(("fromIndex < 0: " + lng).toString());
        }
        final long n2 = lng;
        final Segment head = this.head;
        long n3;
        if (head == null) {
            n3 = -1L;
        }
        else {
            Segment segment = head;
            if (this.size() - n2 < n2) {
                long size;
                for (size = this.size(); size > n2; size -= segment.limit - segment.pos) {
                    final Segment prev = segment.prev;
                    Intrinsics.checkNotNull(prev);
                    segment = prev;
                }
                final Segment segment2 = segment;
                final long n4 = size;
                final Segment segment3 = segment2;
                if (segment3 == null) {
                    n3 = -1L;
                }
                else {
                    Segment segment4 = segment3;
                    long n5 = n4;
                    final byte[] internalArray$okio = byteString.internalArray$okio();
                    final byte b = internalArray$okio[0];
                    final int size2 = byteString.size();
                    final long n6 = this.size() - size2 + 1L;
                    while (n5 < n6) {
                        final byte[] data = segment4.data;
                        for (int n7 = (int)Math.min(segment4.limit, segment4.pos + n6 - n5), i = (int)(segment4.pos + lng - n5); i < n7; ++i) {
                            if (data[i] == b && DBuffer.rangeEquals(segment4, i + 1, internalArray$okio, 1, size2)) {
                                n3 = i - segment4.pos + n5;
                                return n3;
                            }
                        }
                        n5 = (lng = n5 + (segment4.limit - segment4.pos));
                        final Segment next = segment4.next;
                        Intrinsics.checkNotNull(next);
                        segment4 = next;
                    }
                    n3 = -1L;
                }
            }
            else {
                long n8 = 0L;
                while (true) {
                    final long n9 = n8 + (segment.limit - segment.pos);
                    if (n9 > n2) {
                        break;
                    }
                    final Segment next2 = segment.next;
                    Intrinsics.checkNotNull(next2);
                    segment = next2;
                    n8 = n9;
                }
                final Segment segment5 = segment;
                final long n10 = n8;
                final Segment segment6 = segment5;
                if (segment6 == null) {
                    n3 = -1L;
                }
                else {
                    Segment segment7 = segment6;
                    long n11 = n10;
                    final byte[] internalArray$okio2 = byteString.internalArray$okio();
                    final byte b2 = internalArray$okio2[0];
                    final int size3 = byteString.size();
                    final long n12 = this.size() - size3 + 1L;
                    while (n11 < n12) {
                        final byte[] data2 = segment7.data;
                        for (int n13 = (int)Math.min(segment7.limit, segment7.pos + n12 - n11), j = (int)(segment7.pos + lng - n11); j < n13; ++j) {
                            if (data2[j] == b2 && DBuffer.rangeEquals(segment7, j + 1, internalArray$okio2, 1, size3)) {
                                n3 = j - segment7.pos + n11;
                                return n3;
                            }
                        }
                        n11 = (lng = n11 + (segment7.limit - segment7.pos));
                        final Segment next3 = segment7.next;
                        Intrinsics.checkNotNull(next3);
                        segment7 = next3;
                    }
                    n3 = -1L;
                }
            }
        }
        return n3;
    }
    
    @Override
    public long indexOfElement(@NotNull final ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "targetBytes");
        return this.indexOfElement(byteString, 0L);
    }
    
    @Override
    public long indexOfElement(@NotNull final ByteString byteString, final long n) {
        Intrinsics.checkNotNullParameter(byteString, "targetBytes");
        long lng = n;
        if (lng < 0L) {
            throw new IllegalArgumentException(("fromIndex < 0: " + lng).toString());
        }
        final long n2 = lng;
        final Segment head = this.head;
        long n3;
        if (head == null) {
            n3 = -1L;
        }
        else {
            Segment segment = head;
            if (this.size() - n2 < n2) {
                long size;
                for (size = this.size(); size > n2; size -= segment.limit - segment.pos) {
                    final Segment prev = segment.prev;
                    Intrinsics.checkNotNull(prev);
                    segment = prev;
                }
                final Segment segment2 = segment;
                final long n4 = size;
                final Segment segment3 = segment2;
                if (segment3 == null) {
                    n3 = -1L;
                }
                else {
                    Segment segment4 = segment3;
                    long n5 = n4;
                    if (byteString.size() == 2) {
                        final byte byte1 = byteString.getByte(0);
                        final byte byte2 = byteString.getByte(1);
                        while (n5 < this.size()) {
                            final byte[] data = segment4.data;
                            for (int i = (int)(segment4.pos + lng - n5); i < segment4.limit; ++i) {
                                final byte b = data[i];
                                if (b == byte1 || b == byte2) {
                                    n3 = i - segment4.pos + n5;
                                    return n3;
                                }
                            }
                            n5 = (lng = n5 + (segment4.limit - segment4.pos));
                            final Segment next = segment4.next;
                            Intrinsics.checkNotNull(next);
                            segment4 = next;
                        }
                    }
                    else {
                        final byte[] internalArray$okio = byteString.internalArray$okio();
                        while (n5 < this.size()) {
                            final byte[] data2 = segment4.data;
                            for (int j = (int)(segment4.pos + lng - n5); j < segment4.limit; ++j) {
                                final byte b2 = data2[j];
                                for (int k = 0; k < internalArray$okio.length; ++k) {
                                    if (b2 == internalArray$okio[k]) {
                                        n3 = j - segment4.pos + n5;
                                        return n3;
                                    }
                                }
                            }
                            n5 = (lng = n5 + (segment4.limit - segment4.pos));
                            final Segment next2 = segment4.next;
                            Intrinsics.checkNotNull(next2);
                            segment4 = next2;
                        }
                    }
                    n3 = -1L;
                }
            }
            else {
                long n6 = 0L;
                while (true) {
                    final long n7 = n6 + (segment.limit - segment.pos);
                    if (n7 > n2) {
                        break;
                    }
                    final Segment next3 = segment.next;
                    Intrinsics.checkNotNull(next3);
                    segment = next3;
                    n6 = n7;
                }
                final Segment segment5 = segment;
                final long n8 = n6;
                final Segment segment6 = segment5;
                if (segment6 == null) {
                    n3 = -1L;
                }
                else {
                    Segment segment7 = segment6;
                    long n9 = n8;
                    if (byteString.size() == 2) {
                        final byte byte3 = byteString.getByte(0);
                        final byte byte4 = byteString.getByte(1);
                        while (n9 < this.size()) {
                            final byte[] data3 = segment7.data;
                            for (int l = (int)(segment7.pos + lng - n9); l < segment7.limit; ++l) {
                                final byte b3 = data3[l];
                                if (b3 == byte3 || b3 == byte4) {
                                    n3 = l - segment7.pos + n9;
                                    return n3;
                                }
                            }
                            n9 = (lng = n9 + (segment7.limit - segment7.pos));
                            final Segment next4 = segment7.next;
                            Intrinsics.checkNotNull(next4);
                            segment7 = next4;
                        }
                    }
                    else {
                        final byte[] internalArray$okio2 = byteString.internalArray$okio();
                        while (n9 < this.size()) {
                            final byte[] data4 = segment7.data;
                            for (int n10 = (int)(segment7.pos + lng - n9); n10 < segment7.limit; ++n10) {
                                final byte b4 = data4[n10];
                                for (int n11 = 0; n11 < internalArray$okio2.length; ++n11) {
                                    if (b4 == internalArray$okio2[n11]) {
                                        n3 = n10 - segment7.pos + n9;
                                        return n3;
                                    }
                                }
                            }
                            n9 = (lng = n9 + (segment7.limit - segment7.pos));
                            final Segment next5 = segment7.next;
                            Intrinsics.checkNotNull(next5);
                            segment7 = next5;
                        }
                    }
                    n3 = -1L;
                }
            }
        }
        return n3;
    }
    
    @Override
    public boolean rangeEquals(final long n, @NotNull final ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "bytes");
        return this.rangeEquals(n, byteString, 0, byteString.size());
    }
    
    @Override
    public boolean rangeEquals(final long n, @NotNull final ByteString byteString, final int n2, final int n3) {
        Intrinsics.checkNotNullParameter(byteString, "bytes");
        boolean b;
        if (n < 0L || n2 < 0 || n3 < 0 || this.size() - n < n3 || byteString.size() - n2 < n3) {
            b = false;
        }
        else {
            for (int i = 0; i < n3; ++i) {
                if (this.getByte(n + i) != byteString.getByte(n2 + i)) {
                    b = false;
                    return b;
                }
            }
            b = true;
        }
        return b;
    }
    
    @Override
    public void flush() {
    }
    
    @Override
    public boolean isOpen() {
        return true;
    }
    
    @Override
    public void close() {
    }
    
    @NotNull
    @Override
    public Timeout timeout() {
        return Timeout.NONE;
    }
    
    @NotNull
    public final ByteString md5() {
        return this.digest("MD5");
    }
    
    @NotNull
    public final ByteString sha1() {
        return this.digest("SHA-1");
    }
    
    @NotNull
    public final ByteString sha256() {
        return this.digest("SHA-256");
    }
    
    @NotNull
    public final ByteString sha512() {
        return this.digest("SHA-512");
    }
    
    private final ByteString digest(final String algorithm) {
        final MessageDigest instance = MessageDigest.getInstance(algorithm);
        final Segment head = this.head;
        if (head != null) {
            final Segment segment = head;
            instance.update(segment.data, segment.pos, segment.limit - segment.pos);
            final Segment next = segment.next;
            Intrinsics.checkNotNull(next);
            Segment next2;
            for (Segment segment2 = next; segment2 != segment; segment2 = next2) {
                instance.update(segment2.data, segment2.pos, segment2.limit - segment2.pos);
                next2 = segment2.next;
                Intrinsics.checkNotNull(next2);
            }
        }
        final byte[] digest = instance.digest();
        Intrinsics.checkNotNullExpressionValue(digest, "digest(...)");
        return new ByteString(digest);
    }
    
    @NotNull
    public final ByteString hmacSha1(@NotNull final ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "key");
        return this.hmac("HmacSHA1", byteString);
    }
    
    @NotNull
    public final ByteString hmacSha256(@NotNull final ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "key");
        return this.hmac("HmacSHA256", byteString);
    }
    
    @NotNull
    public final ByteString hmacSha512(@NotNull final ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "key");
        return this.hmac("HmacSHA512", byteString);
    }
    
    private final ByteString hmac(final String s, final ByteString byteString) {
        try {
            final Mac instance = Mac.getInstance(s);
            instance.init(new SecretKeySpec(byteString.internalArray$okio(), s));
            final Segment head = this.head;
            if (head != null) {
                final Segment segment = head;
                instance.update(segment.data, segment.pos, segment.limit - segment.pos);
                final Segment next = segment.next;
                Intrinsics.checkNotNull(next);
                Segment next2;
                for (Segment segment2 = next; segment2 != segment; segment2 = next2) {
                    instance.update(segment2.data, segment2.pos, segment2.limit - segment2.pos);
                    next2 = segment2.next;
                    Intrinsics.checkNotNull(next2);
                }
            }
            final byte[] doFinal = instance.doFinal();
            Intrinsics.checkNotNullExpressionValue(doFinal, "doFinal(...)");
            return new ByteString(doFinal);
        }
        catch (final InvalidKeyException ex) {
            throw new IllegalArgumentException(ex);
        }
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        boolean b;
        if (this == o) {
            b = true;
        }
        else if (!(o instanceof Buffer)) {
            b = false;
        }
        else if (this.size() != ((Buffer)o).size()) {
            b = false;
        }
        else if (this.size() == 0L) {
            b = true;
        }
        else {
            final Segment head = this.head;
            Intrinsics.checkNotNull(head);
            Segment segment = head;
            final Segment head2 = ((Buffer)o).head;
            Intrinsics.checkNotNull(head2);
            Segment segment2 = head2;
            int n = segment.pos;
            int n2 = segment2.pos;
            long n4;
            for (long n3 = 0L; n3 < this.size(); n3 += n4) {
                n4 = Math.min(segment.limit - n, segment2.limit - n2);
                for (long n5 = 0L; n5 < n4; ++n5) {
                    if (segment.data[n++] != segment2.data[n2++]) {
                        b = false;
                        return b;
                    }
                }
                if (n == segment.limit) {
                    final Segment next = segment.next;
                    Intrinsics.checkNotNull(next);
                    segment = next;
                    n = segment.pos;
                }
                if (n2 == segment2.limit) {
                    final Segment next2 = segment2.next;
                    Intrinsics.checkNotNull(next2);
                    segment2 = next2;
                    n2 = segment2.pos;
                }
            }
            b = true;
        }
        return b;
    }
    
    @Override
    public int hashCode() {
        final Segment head = this.head;
        int n;
        if (head == null) {
            n = 0;
        }
        else {
            Segment segment = head;
            int n2 = 1;
            do {
                for (int i = segment.pos; i < segment.limit; ++i) {
                    n2 = 31 * n2 + segment.data[i];
                }
                final Segment next = segment.next;
                Intrinsics.checkNotNull(next);
                segment = next;
            } while (segment != this.head);
            n = n2;
        }
        return n;
    }
    
    @NotNull
    @Override
    public String toString() {
        return this.snapshot().toString();
    }
    
    @NotNull
    public final Buffer copy() {
        final Buffer buffer = new Buffer();
        Buffer buffer2;
        if (this.size() == 0L) {
            buffer2 = buffer;
        }
        else {
            final Segment head = this.head;
            Intrinsics.checkNotNull(head);
            final Segment segment = head;
            final Segment sharedCopy = segment.sharedCopy();
            buffer.head = sharedCopy;
            sharedCopy.prev = buffer.head;
            sharedCopy.next = sharedCopy.prev;
            for (Segment segment2 = segment.next; segment2 != segment; segment2 = segment2.next) {
                final Segment prev = sharedCopy.prev;
                Intrinsics.checkNotNull(prev);
                final Segment segment3 = segment2;
                Intrinsics.checkNotNull(segment3);
                prev.push(segment3.sharedCopy());
            }
            buffer.setSize$okio(this.size());
            buffer2 = buffer;
        }
        return buffer2;
    }
    
    @NotNull
    public Buffer clone() {
        return this.copy();
    }
    
    @NotNull
    public final ByteString snapshot() {
        if (this.size() > 2147483647L) {
            throw new IllegalStateException(("size > Int.MAX_VALUE: " + this.size()).toString());
        }
        return this.snapshot((int)this.size());
    }
    
    @NotNull
    public final ByteString snapshot(final int b) {
        ByteString empty;
        if (b == 0) {
            empty = ByteString.EMPTY;
        }
        else {
            DSegmentedByteString.checkOffsetAndCount(this.size(), 0L, b);
            int i = 0;
            int n = 0;
            for (Segment segment = this.head; i < b; i += segment.limit - segment.pos, ++n, segment = segment.next) {
                final Segment segment2 = segment;
                Intrinsics.checkNotNull(segment2);
                if (segment2.limit == segment.pos) {
                    throw new AssertionError((Object)"s.limit == s.pos");
                }
            }
            final byte[][] array = new byte[n][];
            final int[] array2 = new int[n * 2];
            int j = 0;
            int n2 = 0;
            for (Segment segment3 = this.head; j < b; j += segment3.limit - segment3.pos, array2[n2] = Math.min(j, b), array2[n2 + ((Object[])array).length] = segment3.pos, segment3.shared = true, ++n2, segment3 = segment3.next) {
                final byte[][] array3 = array;
                final int n3 = n2;
                final Segment segment4 = segment3;
                Intrinsics.checkNotNull(segment4);
                array3[n3] = segment4.data;
            }
            empty = new SegmentedByteString(array, array2);
        }
        return empty;
    }
    
    @JvmOverloads
    @NotNull
    public final UnsafeCursor readUnsafe(@NotNull final UnsafeCursor unsafeCursor) {
        Intrinsics.checkNotNullParameter(unsafeCursor, "unsafeCursor");
        return DBuffer.commonReadUnsafe(this, unsafeCursor);
    }
    
    public static /* synthetic */ UnsafeCursor readUnsafe$default(final Buffer buffer, UnsafeCursor default__new_UnsafeCursor, final int n, final Object o) {
        if ((n & 0x1) != 0x0) {
            default__new_UnsafeCursor = DSegmentedByteString.getDEFAULT__new_UnsafeCursor();
        }
        return buffer.readUnsafe(default__new_UnsafeCursor);
    }
    
    @JvmOverloads
    @NotNull
    public final UnsafeCursor readAndWriteUnsafe(@NotNull final UnsafeCursor unsafeCursor) {
        Intrinsics.checkNotNullParameter(unsafeCursor, "unsafeCursor");
        return DBuffer.commonReadAndWriteUnsafe(this, unsafeCursor);
    }
    
    public static /* synthetic */ UnsafeCursor readAndWriteUnsafe$default(final Buffer buffer, UnsafeCursor default__new_UnsafeCursor, final int n, final Object o) {
        if ((n & 0x1) != 0x0) {
            default__new_UnsafeCursor = DSegmentedByteString.getDEFAULT__new_UnsafeCursor();
        }
        return buffer.readAndWriteUnsafe(default__new_UnsafeCursor);
    }
    
    @Deprecated(message = "moved to operator function", replaceWith = @ReplaceWith(expression = "this[index]", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_getByte")
    @java.lang.Deprecated
    public final byte m0377f75dac(final long n) {
        return this.getByte(n);
    }
    
    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "size", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_size")
    @java.lang.Deprecated
    public final long mfd88fdb958() {
        return this.size;
    }
    
    @JvmOverloads
    @NotNull
    public final Buffer copyTo(@NotNull final OutputStream outputStream, final long n) throws IOException {
        Intrinsics.checkNotNullParameter(outputStream, "out");
        return copyTo$default(this, outputStream, n, 0L, 4, null);
    }
    
    @JvmOverloads
    @NotNull
    public final Buffer copyTo(@NotNull final OutputStream outputStream) throws IOException {
        Intrinsics.checkNotNullParameter(outputStream, "out");
        return copyTo$default(this, outputStream, 0L, 0L, 6, null);
    }
    
    @JvmOverloads
    @NotNull
    public final Buffer writeTo(@NotNull final OutputStream outputStream) throws IOException {
        Intrinsics.checkNotNullParameter(outputStream, "out");
        return writeTo$default(this, outputStream, 0L, 2, null);
    }
    
    @JvmOverloads
    @NotNull
    public final UnsafeCursor readUnsafe() {
        return readUnsafe$default(this, null, 1, null);
    }
    
    @JvmOverloads
    @NotNull
    public final UnsafeCursor readAndWriteUnsafe() {
        return readAndWriteUnsafe$default(this, null, 1, null);
    }
    
    @Metadata(mv = { 1, 9, 0 }, k = 1, xi = 48, d1 = { "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u000e\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\bJ\u0006\u0010\u0018\u001a\u00020\bJ\u000e\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\nJ\u000e\u0010\u001b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0013\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c" }, d2 = { "Lokio/Buffer$UnsafeCursor;", "Ljava/io/Closeable;", "()V", "buffer", "Lokio/Buffer;", "data", "", "end", "", "offset", "", "readWrite", "", "segment", "Lokio/Segment;", "getSegment$okio", "()Lokio/Segment;", "setSegment$okio", "(Lokio/Segment;)V", "start", "close", "", "expandBuffer", "minByteCount", "next", "resizeBuffer", "newSize", "seek", "okio" })
    @SourceDebugExtension({ "SMAP\nBuffer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Buffer.kt\nokio/Buffer$UnsafeCursor\n+ 2 Buffer.kt\nokio/internal/DBuffer\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Util.kt\nokio/DSegmentedByteString\n*L\n1#1,641:1\n1567#2:642\n1568#2:644\n1572#2:645\n1573#2,68:647\n1644#2:715\n1645#2,32:717\n1677#2,18:750\n1698#2:768\n1699#2,18:770\n1721#2:788\n1723#2,7:790\n1#3:643\n1#3:646\n1#3:716\n1#3:769\n1#3:789\n86#4:749\n*S KotlinDebug\n*F\n+ 1 Buffer.kt\nokio/Buffer$UnsafeCursor\n*L\n628#1:642\n628#1:644\n630#1:645\n630#1:647,68\n632#1:715\n632#1:717,32\n632#1:750,18\n634#1:768\n634#1:770,18\n637#1:788\n637#1:790,7\n628#1:643\n630#1:646\n632#1:716\n634#1:769\n637#1:789\n632#1:749\n*E\n" })
    public static final class UnsafeCursor implements Closeable
    {
        @JvmField
        @Nullable
        public Buffer buffer;
        @JvmField
        public boolean readWrite;
        @Nullable
        private Segment segment;
        @JvmField
        public long offset;
        @JvmField
        @Nullable
        public byte[] data;
        @JvmField
        public int start;
        @JvmField
        public int end;
        
        public UnsafeCursor() {
            this.offset = -1L;
            this.start = -1;
            this.end = -1;
        }
        
        @Nullable
        public final Segment getSegment$okio() {
            return this.segment;
        }
        
        public final void setSegment$okio(@Nullable final Segment segment) {
            this.segment = segment;
        }
        
        public final int next() {
            final long offset = this.offset;
            final Buffer buffer = this.buffer;
            Intrinsics.checkNotNull(buffer);
            if (offset == buffer.size()) {
                throw new IllegalStateException("no more bytes".toString());
            }
            return (this.offset == -1L) ? this.seek(0L) : this.seek(this.offset + (this.end - this.start));
        }
        
        public final int seek(final long offset) {
            final Buffer buffer = this.buffer;
            if (buffer == null) {
                throw new IllegalStateException("not attached to a buffer".toString());
            }
            final Buffer buffer2 = buffer;
            if (offset < -1L || offset > buffer2.size()) {
                throw new ArrayIndexOutOfBoundsException("offset=" + offset + " > size=" + buffer2.size());
            }
            int n;
            if (offset == -1L || offset == buffer2.size()) {
                this.setSegment$okio(null);
                this.offset = offset;
                this.data = null;
                this.start = -1;
                this.end = -1;
                n = -1;
            }
            else {
                long n2 = 0L;
                long size = buffer2.size();
                Segment segment = buffer2.head;
                Segment segment2 = buffer2.head;
                if (this.getSegment$okio() != null) {
                    final long offset2 = this.offset;
                    final int start = this.start;
                    final Segment segment$okio = this.getSegment$okio();
                    Intrinsics.checkNotNull(segment$okio);
                    final long n3 = offset2 - (start - segment$okio.pos);
                    if (n3 > offset) {
                        size = n3;
                        segment2 = this.getSegment$okio();
                    }
                    else {
                        n2 = n3;
                        segment = this.getSegment$okio();
                    }
                }
                Segment segment$okio2;
                long n4;
                if (size - offset > offset - n2) {
                    segment$okio2 = segment;
                    n4 = n2;
                    while (true) {
                        final long n5 = n4;
                        final Segment segment3 = segment$okio2;
                        Intrinsics.checkNotNull(segment3);
                        if (offset < n5 + (segment3.limit - segment$okio2.pos)) {
                            break;
                        }
                        n4 += segment$okio2.limit - segment$okio2.pos;
                        segment$okio2 = segment$okio2.next;
                    }
                }
                else {
                    Segment segment4;
                    long n6;
                    Segment segment5;
                    for (segment$okio2 = segment2, n4 = size; n4 > offset; n4 = n6 - (segment5.limit - segment$okio2.pos)) {
                        segment4 = segment$okio2;
                        Intrinsics.checkNotNull(segment4);
                        segment$okio2 = segment4.prev;
                        n6 = n4;
                        segment5 = segment$okio2;
                        Intrinsics.checkNotNull(segment5);
                    }
                }
                if (this.readWrite) {
                    final Segment segment6 = segment$okio2;
                    Intrinsics.checkNotNull(segment6);
                    if (segment6.shared) {
                        final Segment unsharedCopy = segment$okio2.unsharedCopy();
                        if (buffer2.head == segment$okio2) {
                            buffer2.head = unsharedCopy;
                        }
                        segment$okio2 = segment$okio2.push(unsharedCopy);
                        final Segment prev = segment$okio2.prev;
                        Intrinsics.checkNotNull(prev);
                        prev.pop();
                    }
                }
                this.setSegment$okio(segment$okio2);
                this.offset = offset;
                final Segment segment7 = segment$okio2;
                Intrinsics.checkNotNull(segment7);
                this.data = segment7.data;
                this.start = segment$okio2.pos + (int)(offset - n4);
                this.end = segment$okio2.limit;
                n = this.end - this.start;
            }
            return n;
        }
        
        public final long resizeBuffer(final long size$okio) {
            final Buffer buffer = this.buffer;
            if (buffer == null) {
                throw new IllegalStateException("not attached to a buffer".toString());
            }
            final Buffer buffer2 = buffer;
            if (!this.readWrite) {
                throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers".toString());
            }
            final long size = buffer2.size();
            if (size$okio <= size) {
                if (size$okio < 0L) {
                    throw new IllegalArgumentException(("newSize < 0: " + size$okio).toString());
                }
                int n2;
                for (long n = size - size$okio; n > 0L; n -= n2) {
                    final Segment head = buffer2.head;
                    Intrinsics.checkNotNull(head);
                    final Segment prev;
                    final Segment segment = prev = head.prev;
                    Intrinsics.checkNotNull(prev);
                    n2 = prev.limit - segment.pos;
                    if (n2 > n) {
                        segment.limit -= (int)n;
                        break;
                    }
                    buffer2.head = segment.pop();
                    SegmentPool.recycle(segment);
                }
                this.setSegment$okio(null);
                this.offset = size$okio;
                this.data = null;
                this.start = -1;
                this.end = -1;
            }
            else if (size$okio > size) {
                int n3 = 1;
                long a = size$okio - size;
                while (a > 0L) {
                    final Segment writableSegment$okio = buffer2.writableSegment$okio(1);
                    final int n4 = (int)Math.min(a, 8192 - writableSegment$okio.limit);
                    writableSegment$okio.limit += n4;
                    a -= n4;
                    if (n3 != 0) {
                        this.setSegment$okio(writableSegment$okio);
                        this.offset = size;
                        this.data = writableSegment$okio.data;
                        this.start = writableSegment$okio.limit - n4;
                        this.end = writableSegment$okio.limit;
                        n3 = 0;
                    }
                }
            }
            buffer2.setSize$okio(size$okio);
            return size;
        }
        
        public final long expandBuffer(final int n) {
            if (n <= 0) {
                throw new IllegalArgumentException(("minByteCount <= 0: " + n).toString());
            }
            if (n > 8192) {
                throw new IllegalArgumentException(("minByteCount > Segment.SIZE: " + n).toString());
            }
            final Buffer buffer = this.buffer;
            if (buffer == null) {
                throw new IllegalStateException("not attached to a buffer".toString());
            }
            final Buffer buffer2 = buffer;
            if (!this.readWrite) {
                throw new IllegalStateException("expandBuffer() only permitted for read/write buffers".toString());
            }
            final long size = buffer2.size();
            final Segment writableSegment$okio = buffer2.writableSegment$okio(n);
            final int n2 = 8192 - writableSegment$okio.limit;
            writableSegment$okio.limit = 8192;
            buffer2.setSize$okio(size + n2);
            this.setSegment$okio(writableSegment$okio);
            this.offset = size;
            this.data = writableSegment$okio.data;
            this.start = 8192 - n2;
            this.end = 8192;
            return n2;
        }
        
        @Override
        public void close() {
            if (this.buffer == null) {
                throw new IllegalStateException("not attached to a buffer".toString());
            }
            this.buffer = null;
            this.setSegment$okio(null);
            this.offset = -1L;
            this.data = null;
            this.start = -1;
            this.end = -1;
        }
    }
}
