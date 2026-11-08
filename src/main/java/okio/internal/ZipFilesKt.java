package okio.internal;

import org.jetbrains.annotations.*;
import java.io.*;
import kotlin.io.*;
import kotlin.*;
import kotlin.comparisons.*;
import kotlin.collections.*;
import kotlin.jvm.internal.*;
import kotlin.jvm.functions.*;
import okio.*;
import java.util.*;
import kotlin.text.*;

@Metadata(mv = { 1, 9, 0 }, k = 2, xi = 48, d1 = { "\u0000j\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\"\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0017H\u0002\u001a\u001f\u0010\u0018\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010\u001b\u001a.\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020 2\u0014\b\u0002\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020#0\"H\u0000\u001a\f\u0010$\u001a\u00020\u0015*\u00020%H\u0000\u001a\f\u0010&\u001a\u00020'*\u00020%H\u0002\u001a.\u0010(\u001a\u00020)*\u00020%2\u0006\u0010*\u001a\u00020\u00012\u0018\u0010+\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020)0,H\u0002\u001a\u0014\u0010-\u001a\u00020.*\u00020%2\u0006\u0010/\u001a\u00020.H\u0000\u001a\u0018\u00100\u001a\u0004\u0018\u00010.*\u00020%2\b\u0010/\u001a\u0004\u0018\u00010.H\u0002\u001a\u0014\u00101\u001a\u00020'*\u00020%2\u0006\u00102\u001a\u00020'H\u0002\u001a\f\u00103\u001a\u00020)*\u00020%H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010\u000e\u001a\u00020\u000f*\u00020\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u00064" }, d2 = { "BIT_FLAG_ENCRYPTED", "", "BIT_FLAG_UNSUPPORTED_MASK", "CENTRAL_FILE_HEADER_SIGNATURE", "COMPRESSION_METHOD_DEFLATED", "COMPRESSION_METHOD_STORED", "END_OF_CENTRAL_DIRECTORY_SIGNATURE", "HEADER_ID_EXTENDED_TIMESTAMP", "HEADER_ID_ZIP64_EXTENDED_INFO", "LOCAL_FILE_HEADER_SIGNATURE", "MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE", "", "ZIP64_EOCD_RECORD_SIGNATURE", "ZIP64_LOCATOR_SIGNATURE", "hex", "", "getHex", "(I)Ljava/lang/String;", "buildIndex", "", "Lokio/Path;", "Lokio/internal/ZipEntry;", "entries", "", "dosDateTimeToEpochMillis", "date", "time", "(II)Ljava/lang/Long;", "openZip", "Lokio/ZipFileSystem;", "zipPath", "fileSystem", "Lokio/FileSystem;", "predicate", "Lkotlin/Function1;", "", "readEntry", "Lokio/BufferedSource;", "readEocdRecord", "Lokio/internal/EocdRecord;", "readExtra", "", "extraSize", "block", "Lkotlin/Function2;", "readLocalHeader", "Lokio/FileMetadata;", "basicMetadata", "readOrSkipLocalHeader", "readZip64EocdRecord", "regularRecord", "skipLocalHeader", "okio" })
@SourceDebugExtension({ "SMAP\nZipFiles.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ZipFiles.kt\nokio/internal/ZipFilesKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,459:1\n1045#2:460\n*S KotlinDebug\n*F\n+ 1 ZipFiles.kt\nokio/internal/ZipFilesKt\n*L\n156#1:460\n*E\n" })
public class ZipFilesKt
{
    private static final int LOCAL_FILE_HEADER_SIGNATURE = 67324752;
    private static final int CENTRAL_FILE_HEADER_SIGNATURE = 33639248;
    private static final int END_OF_CENTRAL_DIRECTORY_SIGNATURE = 101010256;
    private static final int ZIP64_LOCATOR_SIGNATURE = 117853008;
    private static final int ZIP64_EOCD_RECORD_SIGNATURE = 101075792;
    public static final int COMPRESSION_METHOD_DEFLATED = 8;
    public static final int COMPRESSION_METHOD_STORED = 0;
    private static final int BIT_FLAG_ENCRYPTED = 1;
    private static final int BIT_FLAG_UNSUPPORTED_MASK = 1;
    private static final long MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE = 4294967295L;
    private static final int HEADER_ID_ZIP64_EXTENDED_INFO = 1;
    private static final int HEADER_ID_EXTENDED_TIMESTAMP = 21589;
    
    @NotNull
    public static final ZipFileSystem openZip(@NotNull final Path path, @NotNull final FileSystem fileSystem, @NotNull final Function1<? super ZipEntry, Boolean> function1) throws IOException {
        Intrinsics.checkNotNullParameter(path, "zipPath");
        Intrinsics.checkNotNullParameter(fileSystem, "fileSystem");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        final Closeable closeable = fileSystem.openReadOnly(path);
        Throwable t = null;
        try {
            final FileHandle fileHandle = (FileHandle)closeable;
            long n = fileHandle.size() - 22;
            if (n < 0L) {
                throw new IOException("not a zip: size=" + fileHandle.size());
            }
            final long max = Math.max(n - 65536L, 0L);
            long n2 = 0L;
            EocdRecord eocdRecord = null;
            String utf8 = null;
            do {
                final BufferedSource buffer = Okio.buffer(fileHandle.source(n));
                Label_0221: {
                    try {
                        if (buffer.readIntLe() == 101010256) {
                            n2 = n;
                            eocdRecord = readEocdRecord(buffer);
                            utf8 = buffer.readUtf8(eocdRecord.getCommentByteCount());
                            break Label_0221;
                        }
                    }
                    finally {
                        buffer.close();
                    }
                    --n;
                    continue;
                }
                final long n3 = n2 - 20;
                if (n3 > 0L) {
                    final Closeable closeable2 = Okio.buffer(fileHandle.source(n3));
                    Throwable t2 = null;
                    try {
                        final BufferedSource bufferedSource = (BufferedSource)closeable2;
                        if (bufferedSource.readIntLe() == 117853008) {
                            final int intLe = bufferedSource.readIntLe();
                            final long longLe = bufferedSource.readLongLe();
                            if (bufferedSource.readIntLe() != 1 || intLe != 0) {
                                throw new IOException("unsupported zip: spanned");
                            }
                            final Closeable closeable3 = Okio.buffer(fileHandle.source(longLe));
                            Throwable t3 = null;
                            try {
                                final BufferedSource bufferedSource2 = (BufferedSource)closeable3;
                                final int intLe2 = bufferedSource2.readIntLe();
                                if (intLe2 != 101075792) {
                                    throw new IOException("bad zip: expected " + getHex(101075792) + " but was " + getHex(intLe2));
                                }
                                eocdRecord = readZip64EocdRecord(bufferedSource2, eocdRecord);
                                final Unit instance = Unit.INSTANCE;
                            }
                            catch (final Throwable t4) {
                                t3 = t4;
                                throw t4;
                            }
                            finally {
                                CloseableKt.closeFinally(closeable3, t3);
                            }
                        }
                        final Unit instance2 = Unit.INSTANCE;
                    }
                    catch (final Throwable t5) {
                        t2 = t5;
                        throw t5;
                    }
                    finally {
                        CloseableKt.closeFinally(closeable2, t2);
                    }
                }
                final List list = new ArrayList();
                final Closeable closeable4 = Okio.buffer(fileHandle.source(eocdRecord.getCentralDirectoryOffset()));
                Throwable t6 = null;
                try {
                    final BufferedSource bufferedSource3 = (BufferedSource)closeable4;
                    for (long n4 = 0L; n4 < eocdRecord.getEntryCount(); ++n4) {
                        final ZipEntry entry = readEntry(bufferedSource3);
                        if (entry.getOffset() >= eocdRecord.getCentralDirectoryOffset()) {
                            throw new IOException("bad zip: local file header offset >= central directory offset");
                        }
                        if (function1.invoke(entry)) {
                            list.add(entry);
                        }
                    }
                    final Unit instance3 = Unit.INSTANCE;
                }
                catch (final Throwable t7) {
                    t6 = t7;
                    throw t7;
                }
                finally {
                    CloseableKt.closeFinally(closeable4, t6);
                }
                return new ZipFileSystem(path, fileSystem, buildIndex(list), utf8);
            } while (n >= max);
            throw new IOException("not a zip: end of central directory signature not found");
        }
        catch (final Throwable t8) {
            t = t8;
            throw t8;
        }
        finally {
            CloseableKt.closeFinally(closeable, t);
        }
    }
    
    private static final Map<Path, ZipEntry> buildIndex(final List<ZipEntry> list) {
        final Path get$default = Path.Companion.get$default(Path.Companion, "/", false, 1, null);
        final Map<Object, Object> mutableMap = MapsKt__MapsKt.mutableMapOf(TuplesKt.mcc4e6a6012(get$default, new ZipEntry(get$default, true, null, 0L, 0L, 0L, 0, null, 0L, 508, null)));
        for (final ZipEntry zipEntry : CollectionsKt___CollectionsKt.sortedWith((Iterable<? extends ZipEntry>)list, (Comparator<? super ZipEntry>)new Comparator<Object>() {
            @Override
            public final int compare(final T t, final T t2) {
                return ComparisonsKt__ComparisonsKt.compareValues(((ZipEntry)t).getCanonicalPath(), (Comparable)((ZipEntry)t2).getCanonicalPath());
            }
        })) {
            if (mutableMap.put(zipEntry.getCanonicalPath(), zipEntry) == null) {
                ZipEntry zipEntry2 = zipEntry;
                while (true) {
                    final Path parent = zipEntry2.getCanonicalPath().parent();
                    if (parent == null) {
                        break;
                    }
                    final Path path = parent;
                    final ZipEntry zipEntry3 = mutableMap.get(path);
                    if (zipEntry3 != null) {
                        zipEntry3.getChildren().add(zipEntry2.getCanonicalPath());
                        break;
                    }
                    final ZipEntry zipEntry4 = new ZipEntry(path, true, null, 0L, 0L, 0L, 0, null, 0L, 508, null);
                    mutableMap.put(path, zipEntry4);
                    zipEntry4.getChildren().add(zipEntry2.getCanonicalPath());
                    zipEntry2 = zipEntry4;
                }
            }
        }
        return (Map<Path, ZipEntry>)mutableMap;
    }
    
    @NotNull
    public static final ZipEntry readEntry(@NotNull final BufferedSource bufferedSource) throws IOException {
        Intrinsics.checkNotNullParameter(bufferedSource, "<this>");
        final int intLe = bufferedSource.readIntLe();
        if (intLe != 33639248) {
            throw new IOException("bad zip: expected " + getHex(33639248) + " but was " + getHex(intLe));
        }
        bufferedSource.skip(4L);
        final int n = bufferedSource.readShortLe() & 0xFFFF;
        if ((n & 0x1) != 0x0) {
            throw new IOException("unsupported zip: general purpose bit flag=" + getHex(n));
        }
        final int n2 = bufferedSource.readShortLe() & 0xFFFF;
        final Long dosDateTimeToEpochMillis = dosDateTimeToEpochMillis(bufferedSource.readShortLe() & 0xFFFF, bufferedSource.readShortLe() & 0xFFFF);
        final long n3 = (long)bufferedSource.readIntLe() & 0xFFFFFFFFL;
        final Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = ((long)bufferedSource.readIntLe() & 0xFFFFFFFFL);
        final Ref.LongRef longRef2 = new Ref.LongRef();
        longRef2.element = ((long)bufferedSource.readIntLe() & 0xFFFFFFFFL);
        final int n4 = bufferedSource.readShortLe() & 0xFFFF;
        final int n5 = bufferedSource.readShortLe() & 0xFFFF;
        final int n6 = bufferedSource.readShortLe() & 0xFFFF;
        bufferedSource.skip(8L);
        final Ref.LongRef longRef3 = new Ref.LongRef();
        longRef3.element = ((long)bufferedSource.readIntLe() & 0xFFFFFFFFL);
        final String utf8 = bufferedSource.readUtf8(n4);
        if (StringsKt__StringsKt.contains$default(utf8, '\0', false, 2, null)) {
            throw new IOException("bad zip: filename contains 0x00");
        }
        long n7 = 0L;
        if (longRef2.element == 4294967295L) {
            n7 += 8;
        }
        if (longRef.element == 4294967295L) {
            n7 += 8;
        }
        if (longRef3.element == 4294967295L) {
            n7 += 8;
        }
        final long n8 = n7;
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        readExtra(bufferedSource, n5, (Function2<? super Integer, ? super Long, Unit>)new ZipFilesKt$readEntry.ZipFilesKt$readEntry$1(booleanRef, n8, longRef2, bufferedSource, longRef, longRef3));
        if (n8 > 0L && !booleanRef.element) {
            throw new IOException("bad zip: zip64 extra required but absent");
        }
        return new ZipEntry(Path.Companion.get$default(Path.Companion, "/", false, 1, null).resolve(utf8), StringsKt__StringsJVMKt.endsWith$default(utf8, "/", false, 2, null), bufferedSource.readUtf8(n6), n3, longRef.element, longRef2.element, n2, dosDateTimeToEpochMillis, longRef3.element);
    }
    
    private static final EocdRecord readEocdRecord(final BufferedSource bufferedSource) throws IOException {
        final int n = bufferedSource.readShortLe() & 0xFFFF;
        final int n2 = bufferedSource.readShortLe() & 0xFFFF;
        final long n3 = bufferedSource.readShortLe() & 0xFFFF;
        if (n3 != (bufferedSource.readShortLe() & 0xFFFF) || n != 0 || n2 != 0) {
            throw new IOException("unsupported zip: spanned");
        }
        bufferedSource.skip(4L);
        return new EocdRecord(n3, (long)bufferedSource.readIntLe() & 0xFFFFFFFFL, bufferedSource.readShortLe() & 0xFFFF);
    }
    
    private static final EocdRecord readZip64EocdRecord(final BufferedSource bufferedSource, final EocdRecord eocdRecord) throws IOException {
        bufferedSource.skip(12L);
        final int intLe = bufferedSource.readIntLe();
        final int intLe2 = bufferedSource.readIntLe();
        final long longLe = bufferedSource.readLongLe();
        if (longLe != bufferedSource.readLongLe() || intLe != 0 || intLe2 != 0) {
            throw new IOException("unsupported zip: spanned");
        }
        bufferedSource.skip(8L);
        return new EocdRecord(longLe, bufferedSource.readLongLe(), eocdRecord.getCommentByteCount());
    }
    
    private static final void readExtra(final BufferedSource bufferedSource, final int n, final Function2<? super Integer, ? super Long, Unit> function2) {
        long l;
        long n4;
        for (long n2 = n; n2 != 0L; n2 = n4 - l) {
            if (n2 < 4L) {
                throw new IOException("bad zip: truncated header in extra field");
            }
            final int n3 = bufferedSource.readShortLe() & 0xFFFF;
            l = ((long)bufferedSource.readShortLe() & 0xFFFFL);
            n4 = n2 - 4;
            if (n4 < l) {
                throw new IOException("bad zip: truncated value in extra field");
            }
            bufferedSource.require(l);
            final long size = bufferedSource.getBuffer().size();
            function2.invoke(n3, l);
            final long n5 = l + bufferedSource.getBuffer().size() - size;
            if (n5 < 0L) {
                throw new IOException("unsupported zip: too many bytes processed for " + n3);
            }
            if (n5 > 0L) {
                bufferedSource.getBuffer().skip(n5);
            }
        }
    }
    
    public static final void skipLocalHeader(@NotNull final BufferedSource bufferedSource) {
        Intrinsics.checkNotNullParameter(bufferedSource, "<this>");
        readOrSkipLocalHeader(bufferedSource, null);
    }
    
    @NotNull
    public static final FileMetadata readLocalHeader(@NotNull final BufferedSource bufferedSource, @NotNull final FileMetadata fileMetadata) {
        Intrinsics.checkNotNullParameter(bufferedSource, "<this>");
        Intrinsics.checkNotNullParameter(fileMetadata, "basicMetadata");
        final FileMetadata orSkipLocalHeader = readOrSkipLocalHeader(bufferedSource, fileMetadata);
        Intrinsics.checkNotNull(orSkipLocalHeader);
        return orSkipLocalHeader;
    }
    
    private static final FileMetadata readOrSkipLocalHeader(final BufferedSource bufferedSource, final FileMetadata fileMetadata) {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = (T)((fileMetadata != null) ? fileMetadata.getLastModifiedAtMillis() : null);
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
        final int intLe = bufferedSource.readIntLe();
        if (intLe != 67324752) {
            throw new IOException("bad zip: expected " + getHex(67324752) + " but was " + getHex(intLe));
        }
        bufferedSource.skip(2L);
        final int n = bufferedSource.readShortLe() & 0xFFFF;
        if ((n & 0x1) != 0x0) {
            throw new IOException("unsupported zip: general purpose bit flag=" + getHex(n));
        }
        bufferedSource.skip(18L);
        final long n2 = (long)bufferedSource.readShortLe() & 0xFFFFL;
        final int n3 = bufferedSource.readShortLe() & 0xFFFF;
        bufferedSource.skip(n2);
        if (fileMetadata == null) {
            bufferedSource.skip(n3);
            return null;
        }
        readExtra(bufferedSource, n3, (Function2<? super Integer, ? super Long, Unit>)new ZipFilesKt$readOrSkipLocalHeader.ZipFilesKt$readOrSkipLocalHeader$1(bufferedSource, objectRef, objectRef2, objectRef3));
        return new FileMetadata(fileMetadata.isRegularFile(), fileMetadata.isDirectory(), null, fileMetadata.getSize(), (Long)objectRef3.element, (Long)objectRef.element, (Long)objectRef2.element, null, 128, null);
    }
    
    private static final Long dosDateTimeToEpochMillis(final int n, final int n2) {
        if (n2 == -1) {
            return null;
        }
        final GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(14, 0);
        gregorianCalendar.set(1980 + (n >> 9 & 0x7F), (n >> 5 & 0xF) - 1, n & 0x1F, n2 >> 11 & 0x1F, n2 >> 5 & 0x3F, (n2 & 0x1F) << 1);
        return gregorianCalendar.getTime().getTime();
    }
    
    private static final String getHex(final int i) {
        final StringBuilder append = new StringBuilder().append("0x");
        final String string = Integer.toString(i, CharsKt__CharJVMKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(string, "toString(this, checkRadix(radix))");
        return append.append(string).toString();
    }
}
