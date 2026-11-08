package okhttp3.internal.http2;

import kotlin.*;
import org.jetbrains.annotations.*;
import okio.*;
import kotlin.jvm.*;
import okhttp3.internal.*;
import kotlin.jvm.internal.*;
import kotlin.text.*;

@Metadata(mv = { 1, 8, 0 }, k = 1, xi = 48, d1 = { "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000bJ\u0015\u0010\"\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u000bH\u0000¢\u0006\u0002\b#J.\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000bR\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0014\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000¨\u0006)" }, d2 = { "Lokhttp3/internal/http2/Http2;", "", "()V", "BINARY", "", "", "[Ljava/lang/String;", "CONNECTION_PREFACE", "Lokio/ByteString;", "FLAGS", "FLAG_ACK", "", "FLAG_COMPRESSED", "FLAG_END_HEADERS", "FLAG_END_PUSH_PROMISE", "FLAG_END_STREAM", "FLAG_NONE", "FLAG_PADDED", "FLAG_PRIORITY", "FRAME_NAMES", "INITIAL_MAX_FRAME_SIZE", "TYPE_CONTINUATION", "TYPE_DATA", "TYPE_GOAWAY", "TYPE_HEADERS", "TYPE_PING", "TYPE_PRIORITY", "TYPE_PUSH_PROMISE", "TYPE_RST_STREAM", "TYPE_SETTINGS", "TYPE_WINDOW_UPDATE", "formatFlags", "type", "flags", "formattedType", "formattedType$okhttp", "frameLog", "inbound", "", "streamId", "length", "okhttp" })
public class Http2
{
    @NotNull
    public static final Http2 INSTANCE;
    @JvmField
    @NotNull
    public static final ByteString CONNECTION_PREFACE;
    public static final int INITIAL_MAX_FRAME_SIZE = 16384;
    public static final int TYPE_DATA = 0;
    public static final int TYPE_HEADERS = 1;
    public static final int TYPE_PRIORITY = 2;
    public static final int TYPE_RST_STREAM = 3;
    public static final int TYPE_SETTINGS = 4;
    public static final int TYPE_PUSH_PROMISE = 5;
    public static final int TYPE_PING = 6;
    public static final int TYPE_GOAWAY = 7;
    public static final int TYPE_WINDOW_UPDATE = 8;
    public static final int TYPE_CONTINUATION = 9;
    public static final int FLAG_NONE = 0;
    public static final int FLAG_ACK = 1;
    public static final int FLAG_END_STREAM = 1;
    public static final int FLAG_END_HEADERS = 4;
    public static final int FLAG_END_PUSH_PROMISE = 4;
    public static final int FLAG_PADDED = 8;
    public static final int FLAG_PRIORITY = 32;
    public static final int FLAG_COMPRESSED = 32;
    @NotNull
    private static final String[] FRAME_NAMES;
    @NotNull
    private static final String[] FLAGS;
    @NotNull
    private static final String[] BINARY;
    
    private Http2() {
    }
    
    @NotNull
    public final String frameLog(final boolean b, final int i, final int j, final int n, final int n2) {
        return Util.format("%s 0x%08x %5d %-13s %s", b ? "<<" : ">>", i, j, this.formattedType$okhttp(n), this.formatFlags(n, n2));
    }
    
    @NotNull
    public final String formattedType$okhttp(final int i) {
        return (i < Http2.FRAME_NAMES.length) ? Http2.FRAME_NAMES[i] : Util.format("0x%02x", i);
    }
    
    @NotNull
    public final String formatFlags(final int n, final int n2) {
        if (n2 == 0) {
            return "";
        }
        switch (n) {
            case 4:
            case 6: {
                return (n2 == 1) ? "ACK" : Http2.BINARY[n2];
            }
            case 2:
            case 3:
            case 7:
            case 8: {
                return Http2.BINARY[n2];
            }
            default: {
                String s;
                if (n2 < Http2.FLAGS.length) {
                    Intrinsics.checkNotNull(s = Http2.FLAGS[n2]);
                }
                else {
                    s = Http2.BINARY[n2];
                }
                final String s2 = s;
                return (n == 5 && (n2 & 0x4) != 0x0) ? StringsKt__StringsJVMKt.replace$default(s2, "HEADERS", "PUSH_PROMISE", false, 4, null) : ((n == 0 && (n2 & 0x20) != 0x0) ? StringsKt__StringsJVMKt.replace$default(s2, "PRIORITY", "COMPRESSED", false, 4, null) : s2);
            }
        }
    }
    
    static {
        INSTANCE = new Http2();
        CONNECTION_PREFACE = ByteString.Companion.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
        FRAME_NAMES = new String[] { "DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION" };
        FLAGS = new String[64];
        int i = 0;
        final String[] binary = new String[256];
        while (i < 256) {
            final int j = i;
            final String[] array = binary;
            final int n = j;
            final String s = "%8s";
            final Object[] array2 = { null };
            final int n2 = 0;
            final String binaryString = Integer.toBinaryString(j);
            Intrinsics.checkNotNullExpressionValue(binaryString, "toBinaryString(it)");
            array2[n2] = binaryString;
            array[n] = StringsKt__StringsJVMKt.replace$default(Util.format(s, array2), ' ', '0', false, 4, null);
            ++i;
        }
        BINARY = binary;
        Http2.FLAGS[0] = "";
        Http2.FLAGS[1] = "END_STREAM";
        final int[] array3 = { 1 };
        Http2.FLAGS[8] = "PADDED";
        for (int k = 0; k < array3.length; ++k) {
            final int n3 = array3[k];
            Http2.FLAGS[n3 | 0x8] = Http2.FLAGS[n3] + "|PADDED";
        }
        Http2.FLAGS[4] = "END_HEADERS";
        Http2.FLAGS[32] = "PRIORITY";
        Http2.FLAGS[36] = "END_HEADERS|PRIORITY";
        final int[] array4 = { 4, 32, 36 };
        for (int l = 0; l < array4.length; ++l) {
            final int n4 = array4[l];
            for (int n5 = 0; n5 < array3.length; ++n5) {
                final int n6 = array3[n5];
                Http2.FLAGS[n6 | n4] = Http2.FLAGS[n6] + '|' + Http2.FLAGS[n4];
                Http2.FLAGS[n6 | n4 | 0x8] = Http2.FLAGS[n6] + '|' + Http2.FLAGS[n4] + "|PADDED";
            }
        }
        for (int n7 = 0; n7 < Http2.FLAGS.length; ++n7) {
            if (Http2.FLAGS[n7] == null) {
                Http2.FLAGS[n7] = Http2.BINARY[n7];
            }
        }
    }
}
