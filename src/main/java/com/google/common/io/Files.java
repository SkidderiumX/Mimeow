/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.TreeTraverser;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.io.ByteProcessor;
import com.google.common.io.ByteSink;
import com.google.common.io.ByteSource;
import com.google.common.io.ByteStreams;
import com.google.common.io.CharSink;
import com.google.common.io.CharSource;
import com.google.common.io.CharStreams;
import com.google.common.io.Closer;
import com.google.common.io.FileWriteMode;
import com.google.common.io.InputSupplier;
import com.google.common.io.LineProcessor;
import com.google.common.io.OutputSupplier;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Beta
public class Files {
    private static final int TEMP_DIR_ATTEMPTS = 10000;
    private static final TreeTraverser<File> FILE_TREE_TRAVERSER = new TreeTraverser<File>(){

        @Override
        public Iterable<File> children(File file) {
            File[] fileArray;
            if (file.isDirectory() && (fileArray = file.listFiles()) != null) {
                return Collections.unmodifiableList(Arrays.asList(fileArray));
            }
            return Collections.emptyList();
        }

        public String toString() {
            return "Files.fileTreeTraverser()";
        }
    };

    private Files() {
    }

    public static BufferedReader newReader(File file, Charset charset) throws FileNotFoundException {
        Preconditions.checkNotNull(file);
        Preconditions.checkNotNull(charset);
        return new BufferedReader(new InputStreamReader((InputStream)new FileInputStream(file), charset));
    }

    public static BufferedWriter newWriter(File file, Charset charset) throws FileNotFoundException {
        Preconditions.checkNotNull(file);
        Preconditions.checkNotNull(charset);
        return new BufferedWriter(new OutputStreamWriter((OutputStream)new FileOutputStream(file), charset));
    }

    public static ByteSource asByteSource(File file) {
        return new FileByteSource(file);
    }

    static byte[] readFile(InputStream inputStream2, long l) throws IOException {
        if (l > Integer.MAX_VALUE) {
            throw new OutOfMemoryError("file is too large to fit in a byte array: " + l + " bytes");
        }
        return l == 0L ? ByteStreams.toByteArray(inputStream2) : ByteStreams.toByteArray(inputStream2, (int)l);
    }

    public static ByteSink asByteSink(File file, FileWriteMode ... fileWriteModeArray) {
        return new FileByteSink(file, fileWriteModeArray);
    }

    public static CharSource asCharSource(File file, Charset charset) {
        return Files.asByteSource(file).asCharSource(charset);
    }

    public static CharSink asCharSink(File file, Charset charset, FileWriteMode ... fileWriteModeArray) {
        return Files.asByteSink(file, fileWriteModeArray).asCharSink(charset);
    }

    @Deprecated
    public static InputSupplier<FileInputStream> newInputStreamSupplier(File file) {
        return ByteStreams.asInputSupplier(Files.asByteSource(file));
    }

    @Deprecated
    public static OutputSupplier<FileOutputStream> newOutputStreamSupplier(File file) {
        return Files.newOutputStreamSupplier(file, false);
    }

    @Deprecated
    public static OutputSupplier<FileOutputStream> newOutputStreamSupplier(File file, boolean bl) {
        return ByteStreams.asOutputSupplier(Files.asByteSink(file, Files.modes(bl)));
    }

    private static FileWriteMode[] modes(boolean bl) {
        FileWriteMode[] fileWriteModeArray;
        if (bl) {
            FileWriteMode[] fileWriteModeArray2 = new FileWriteMode[1];
            fileWriteModeArray = fileWriteModeArray2;
            fileWriteModeArray2[0] = FileWriteMode.APPEND;
        } else {
            fileWriteModeArray = new FileWriteMode[]{};
        }
        return fileWriteModeArray;
    }

    @Deprecated
    public static InputSupplier<InputStreamReader> newReaderSupplier(File file, Charset charset) {
        return CharStreams.asInputSupplier(Files.asCharSource(file, charset));
    }

    @Deprecated
    public static OutputSupplier<OutputStreamWriter> newWriterSupplier(File file, Charset charset) {
        return Files.newWriterSupplier(file, charset, false);
    }

    @Deprecated
    public static OutputSupplier<OutputStreamWriter> newWriterSupplier(File file, Charset charset, boolean bl) {
        return CharStreams.asOutputSupplier(Files.asCharSink(file, charset, Files.modes(bl)));
    }

    public static byte[] toByteArray(File file) throws IOException {
        return Files.asByteSource(file).read();
    }

    public static String toString(File file, Charset charset) throws IOException {
        return Files.asCharSource(file, charset).read();
    }

    @Deprecated
    public static void copy(InputSupplier<? extends InputStream> inputSupplier, File file) throws IOException {
        ByteStreams.asByteSource(inputSupplier).copyTo(Files.asByteSink(file, new FileWriteMode[0]));
    }

    public static void write(byte[] byArray, File file) throws IOException {
        Files.asByteSink(file, new FileWriteMode[0]).write(byArray);
    }

    @Deprecated
    public static void copy(File file, OutputSupplier<? extends OutputStream> outputSupplier) throws IOException {
        Files.asByteSource(file).copyTo(ByteStreams.asByteSink(outputSupplier));
    }

    public static void copy(File file, OutputStream outputStream2) throws IOException {
        Files.asByteSource(file).copyTo(outputStream2);
    }

    public static void copy(File file, File file2) throws IOException {
        Preconditions.checkArgument(!file.equals(file2), "Source %s and destination %s must be different", file, file2);
        Files.asByteSource(file).copyTo(Files.asByteSink(file2, new FileWriteMode[0]));
    }

    @Deprecated
    public static <R extends Readable & Closeable> void copy(InputSupplier<R> inputSupplier, File file, Charset charset) throws IOException {
        CharStreams.asCharSource(inputSupplier).copyTo(Files.asCharSink(file, charset, new FileWriteMode[0]));
    }

    public static void write(CharSequence charSequence, File file, Charset charset) throws IOException {
        Files.asCharSink(file, charset, new FileWriteMode[0]).write(charSequence);
    }

    public static void append(CharSequence charSequence, File file, Charset charset) throws IOException {
        Files.write(charSequence, file, charset, true);
    }

    private static void write(CharSequence charSequence, File file, Charset charset, boolean bl) throws IOException {
        Files.asCharSink(file, charset, Files.modes(bl)).write(charSequence);
    }

    @Deprecated
    public static <W extends Appendable & Closeable> void copy(File file, Charset charset, OutputSupplier<W> outputSupplier) throws IOException {
        Files.asCharSource(file, charset).copyTo(CharStreams.asCharSink(outputSupplier));
    }

    public static void copy(File file, Charset charset, Appendable appendable) throws IOException {
        Files.asCharSource(file, charset).copyTo(appendable);
    }

    public static boolean equal(File file, File file2) throws IOException {
        Preconditions.checkNotNull(file);
        Preconditions.checkNotNull(file2);
        if (file == file2 || file.equals(file2)) {
            return true;
        }
        long l = file.length();
        long l2 = file2.length();
        if (l != 0L && l2 != 0L && l != l2) {
            return false;
        }
        return Files.asByteSource(file).contentEquals(Files.asByteSource(file2));
    }

    public static File createTempDir() {
        File file = new File(System.getProperty("java.io.tmpdir"));
        String string = System.currentTimeMillis() + "-";
        for (int i = 0; i < 10000; ++i) {
            File file2 = new File(file, string + i);
            if (!file2.mkdir()) continue;
            return file2;
        }
        throw new IllegalStateException("Failed to create directory within 10000 attempts (tried " + string + "0 to " + string + 9999 + ')');
    }

    public static void touch(File file) throws IOException {
        Preconditions.checkNotNull(file);
        if (!file.createNewFile() && !file.setLastModified(System.currentTimeMillis())) {
            throw new IOException("Unable to update modification time of " + file);
        }
    }

    public static void createParentDirs(File file) throws IOException {
        Preconditions.checkNotNull(file);
        File file2 = file.getCanonicalFile().getParentFile();
        if (file2 == null) {
            return;
        }
        file2.mkdirs();
        if (!file2.isDirectory()) {
            throw new IOException("Unable to create parent directories of " + file);
        }
    }

    public static void move(File file, File file2) throws IOException {
        Preconditions.checkNotNull(file);
        Preconditions.checkNotNull(file2);
        Preconditions.checkArgument(!file.equals(file2), "Source %s and destination %s must be different", file, file2);
        if (!file.renameTo(file2)) {
            Files.copy(file, file2);
            if (!file.delete()) {
                if (!file2.delete()) {
                    throw new IOException("Unable to delete " + file2);
                }
                throw new IOException("Unable to delete " + file);
            }
        }
    }

    public static String readFirstLine(File file, Charset charset) throws IOException {
        return Files.asCharSource(file, charset).readFirstLine();
    }

    public static List<String> readLines(File file, Charset charset) throws IOException {
        return Files.readLines(file, charset, new LineProcessor<List<String>>(){
            final List<String> result = Lists.newArrayList();

            @Override
            public boolean processLine(String string) {
                this.result.add(string);
                return true;
            }

            @Override
            public List<String> getResult() {
                return this.result;
            }
        });
    }

    public static <T> T readLines(File file, Charset charset, LineProcessor<T> lineProcessor) throws IOException {
        return CharStreams.readLines(Files.newReaderSupplier(file, charset), lineProcessor);
    }

    public static <T> T readBytes(File file, ByteProcessor<T> byteProcessor) throws IOException {
        return ByteStreams.readBytes(Files.newInputStreamSupplier(file), byteProcessor);
    }

    public static HashCode hash(File file, HashFunction hashFunction) throws IOException {
        return Files.asByteSource(file).hash(hashFunction);
    }

    public static MappedByteBuffer map(File file) throws IOException {
        Preconditions.checkNotNull(file);
        return Files.map(file, FileChannel.MapMode.READ_ONLY);
    }

    public static MappedByteBuffer map(File file, FileChannel.MapMode mapMode) throws IOException {
        Preconditions.checkNotNull(file);
        Preconditions.checkNotNull(mapMode);
        if (!file.exists()) {
            throw new FileNotFoundException(file.toString());
        }
        return Files.map(file, mapMode, file.length());
    }

    public static MappedByteBuffer map(File file, FileChannel.MapMode mapMode, long l) throws FileNotFoundException, IOException {
        Preconditions.checkNotNull(file);
        Preconditions.checkNotNull(mapMode);
        Closer closer = Closer.create();
        try {
            RandomAccessFile randomAccessFile = closer.register(new RandomAccessFile(file, mapMode == FileChannel.MapMode.READ_ONLY ? "r" : "rw"));
            MappedByteBuffer mappedByteBuffer = Files.map(randomAccessFile, mapMode, l);
            return mappedByteBuffer;
        }
        catch (Throwable throwable) {
            throw closer.rethrow(throwable);
        }
        finally {
            closer.close();
        }
    }

    private static MappedByteBuffer map(RandomAccessFile randomAccessFile, FileChannel.MapMode mapMode, long l) throws IOException {
        Closer closer = Closer.create();
        try {
            FileChannel fileChannel = closer.register(randomAccessFile.getChannel());
            MappedByteBuffer mappedByteBuffer = fileChannel.map(mapMode, 0L, l);
            return mappedByteBuffer;
        }
        catch (Throwable throwable) {
            throw closer.rethrow(throwable);
        }
        finally {
            closer.close();
        }
    }

    public static String simplifyPath(String string) {
        Preconditions.checkNotNull(string);
        if (string.length() == 0) {
            return ".";
        }
        Iterable<String> iterable = Splitter.on('/').omitEmptyStrings().split(string);
        ArrayList<String> arrayList = new ArrayList<String>();
        for (String string2 : iterable) {
            if (string2.equals(".")) continue;
            if (string2.equals("..")) {
                if (arrayList.size() > 0 && !((String)arrayList.get(arrayList.size() - 1)).equals("..")) {
                    arrayList.remove(arrayList.size() - 1);
                    continue;
                }
                arrayList.add("..");
                continue;
            }
            arrayList.add(string2);
        }
        Object object = Joiner.on('/').join(arrayList);
        if (string.charAt(0) == '/') {
            object = "/" + (String)object;
        }
        while (((String)object).startsWith("/../")) {
            object = ((String)object).substring(3);
        }
        if (((String)object).equals("/..")) {
            object = "/";
        } else if ("".equals(object)) {
            object = ".";
        }
        return object;
    }

    public static String getFileExtension(String string) {
        Preconditions.checkNotNull(string);
        String string2 = new File(string).getName();
        int n = string2.lastIndexOf(46);
        return n == -1 ? "" : string2.substring(n + 1);
    }

    public static String getNameWithoutExtension(String string) {
        Preconditions.checkNotNull(string);
        String string2 = new File(string).getName();
        int n = string2.lastIndexOf(46);
        return n == -1 ? string2 : string2.substring(0, n);
    }

    public static TreeTraverser<File> fileTreeTraverser() {
        return FILE_TREE_TRAVERSER;
    }

    public static Predicate<File> isDirectory() {
        return FilePredicate.IS_DIRECTORY;
    }

    public static Predicate<File> isFile() {
        return FilePredicate.IS_FILE;
    }

    private static enum FilePredicate implements Predicate<File>
    {
        IS_DIRECTORY{

            @Override
            public boolean apply(File file) {
                return file.isDirectory();
            }

            public String toString() {
                return "Files.isDirectory()";
            }
        }
        ,
        IS_FILE{

            @Override
            public boolean apply(File file) {
                return file.isFile();
            }

            public String toString() {
                return "Files.isFile()";
            }
        };

    }

    private static final class FileByteSink
    extends ByteSink {
        private final File file;
        private final ImmutableSet<FileWriteMode> modes;

        private FileByteSink(File file, FileWriteMode ... fileWriteModeArray) {
            this.file = Preconditions.checkNotNull(file);
            this.modes = ImmutableSet.copyOf(fileWriteModeArray);
        }

        @Override
        public FileOutputStream openStream() throws IOException {
            return new FileOutputStream(this.file, this.modes.contains((Object)FileWriteMode.APPEND));
        }

        public String toString() {
            return "Files.asByteSink(" + this.file + ", " + this.modes + ")";
        }
    }

    private static final class FileByteSource
    extends ByteSource {
        private final File file;

        private FileByteSource(File file) {
            this.file = Preconditions.checkNotNull(file);
        }

        @Override
        public FileInputStream openStream() throws IOException {
            return new FileInputStream(this.file);
        }

        @Override
        public long size() throws IOException {
            if (!this.file.isFile()) {
                throw new FileNotFoundException(this.file.toString());
            }
            return this.file.length();
        }

        @Override
        public byte[] read() throws IOException {
            Closer closer = Closer.create();
            try {
                FileInputStream fileInputStream = closer.register(this.openStream());
                byte[] byArray = Files.readFile(fileInputStream, fileInputStream.getChannel().size());
                return byArray;
            }
            catch (Throwable throwable) {
                throw closer.rethrow(throwable);
            }
            finally {
                closer.close();
            }
        }

        public String toString() {
            return "Files.asByteSource(" + this.file + ")";
        }
    }
}

