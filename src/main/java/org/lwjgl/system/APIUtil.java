/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system;

import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import org.jspecify.annotations.Nullable;
import org.lwjgl.PointerBuffer;
import org.lwjgl.system.Checks;
import org.lwjgl.system.Configuration;
import org.lwjgl.system.FunctionProvider;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.Platform;
import org.lwjgl.system.Pointer;
import org.lwjgl.system.SharedLibrary;
import org.lwjgl.system.freebsd.FreeBSDLibrary;
import org.lwjgl.system.libffi.FFICIF;
import org.lwjgl.system.libffi.FFIType;
import org.lwjgl.system.libffi.LibFFI;
import org.lwjgl.system.linux.LinuxLibrary;
import org.lwjgl.system.macosx.MacOSXLibrary;
import org.lwjgl.system.windows.WindowsLibrary;

public class APIUtil {
    public static final PrintStream DEBUG_STREAM = APIUtil.getDebugStream();
    private static final Pattern API_VERSION_PATTERN;

    private static PrintStream getDebugStream() {
        PrintStream printStream = System.err;
        Object object = Configuration.DEBUG_STREAM.get();
        if (object instanceof String) {
            try {
                Supplier supplier = (Supplier)Class.forName((String)object).getConstructor(new Class[0]).newInstance(new Object[0]);
                printStream = (PrintStream)supplier.get();
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        } else if (object instanceof Supplier) {
            printStream = (PrintStream)((Supplier)object).get();
        } else if (object instanceof PrintStream) {
            printStream = (PrintStream)object;
        }
        return printStream;
    }

    private APIUtil() {
    }

    public static void apiLog(CharSequence charSequence) {
        if (Checks.DEBUG) {
            DEBUG_STREAM.print("[LWJGL] " + charSequence + "\n");
        }
    }

    public static void apiLogMore(CharSequence charSequence) {
        if (Checks.DEBUG) {
            DEBUG_STREAM.print("\t" + charSequence + "\n");
        }
    }

    public static void apiLogMissing(String string, ByteBuffer byteBuffer) {
        if (Checks.DEBUG) {
            String string2 = MemoryUtil.memASCII(byteBuffer, byteBuffer.remaining() - 1);
            DEBUG_STREAM.print("[LWJGL] Failed to locate address for " + string + " function " + string2 + "\n");
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String apiFindLibrary(String string, String string2) {
        String string4 = Platform.get().mapLibraryName(string2);
        try (Stream<Path> stream = Files.find(Paths.get(string, new String[0]).toAbsolutePath(), Integer.MAX_VALUE, (path, basicFileAttributes) -> basicFileAttributes.isRegularFile() && path.getFileName().toString().equals(string4), new FileVisitOption[0]);){
            String string3 = stream.findFirst().map(Path::toString).orElse(string2);
            return string3;
        }
        catch (IOException iOException) {
            return string2;
        }
    }

    public static SharedLibrary apiCreateLibrary(String string) {
        switch (Platform.get()) {
            case FREEBSD: {
                return new FreeBSDLibrary(string);
            }
            case LINUX: {
                return new LinuxLibrary(string);
            }
            case MACOSX: {
                return MacOSXLibrary.create(string);
            }
            case WINDOWS: {
                return new WindowsLibrary(string);
            }
        }
        throw new IllegalStateException();
    }

    public static long apiGetFunctionAddress(FunctionProvider functionProvider, String string) {
        long l = functionProvider.getFunctionAddress(string);
        if (l == 0L) {
            APIUtil.requiredFunctionMissing(string);
        }
        return l;
    }

    private static void requiredFunctionMissing(String string) {
        if (!Configuration.DISABLE_FUNCTION_CHECKS.get(false).booleanValue()) {
            throw new NullPointerException("A required function is missing: " + string);
        }
    }

    public static long apiGetFunctionAddressOptional(SharedLibrary sharedLibrary, String string) {
        long l = sharedLibrary.getFunctionAddress(string);
        if (Checks.DEBUG_FUNCTIONS && l == 0L) {
            APIUtil.optionalFunctionMissing(sharedLibrary, string);
        }
        return l;
    }

    private static void optionalFunctionMissing(SharedLibrary sharedLibrary, String string) {
        if (Checks.DEBUG) {
            DEBUG_STREAM.print("[LWJGL] Failed to locate address for " + sharedLibrary.getName() + " function " + string + "\n");
        }
    }

    public static @Nullable ByteBuffer apiGetMappedBuffer(@Nullable ByteBuffer byteBuffer, long l, int n) {
        if (byteBuffer != null && MemoryUtil.memAddress(byteBuffer) == l && byteBuffer.capacity() == n) {
            return byteBuffer;
        }
        return l == 0L ? null : MemoryUtil.wrapBufferByte(l, n);
    }

    public static long apiGetBytes(int n, int n2) {
        return ((long)n & 0xFFFFFFFFL) << n2;
    }

    public static long apiCheckAllocation(int n, long l, long l2) {
        if (Checks.DEBUG) {
            if (n < 0) {
                throw new IllegalArgumentException("Invalid number of elements");
            }
            if (l2 + Long.MIN_VALUE < l + Long.MIN_VALUE) {
                throw new IllegalArgumentException("The request allocation is too large");
            }
        }
        return l;
    }

    public static @Nullable APIVersion apiParseVersion(Configuration<?> configuration) {
        Object obj = configuration.get();
        APIVersion aPIVersion = obj instanceof String ? APIUtil.apiParseVersion((String)obj) : (obj instanceof APIVersion ? (APIVersion)obj : null);
        return aPIVersion;
    }

    public static APIVersion apiParseVersion(String string) {
        Matcher matcher = API_VERSION_PATTERN.matcher(string);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(String.format("Malformed API version string [%s]", string));
        }
        return new APIVersion(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)), matcher.group(3), matcher.group(4));
    }

    public static void apiFilterExtensions(Set<String> set, Configuration<Object> configuration) {
        Object object = configuration.get();
        if (object == null) {
            return;
        }
        if (object instanceof String) {
            String string = (String)object;
            if (string.indexOf(46) != -1) {
                try {
                    Predicate predicate = (Predicate)Class.forName(string).newInstance();
                    set.removeIf(predicate);
                }
                catch (Exception exception) {
                    throw new RuntimeException(exception);
                }
            } else {
                for (String string2 : string.split(",")) {
                    set.remove(string2);
                }
            }
        } else if (object instanceof List) {
            List list = (List)object;
            set.removeAll(list);
        } else if (object instanceof Predicate) {
            Predicate predicate = (Predicate)object;
            set.removeIf(predicate);
        } else {
            throw new IllegalStateException("Unsupported " + configuration.getProperty() + " value specified.");
        }
    }

    public static String apiUnknownToken(int n) {
        return APIUtil.apiUnknownToken("Unknown", n);
    }

    public static String apiUnknownToken(String string, int n) {
        return String.format("%s [0x%X]", string, n);
    }

    public static Map<Integer, String> apiClassTokens(@Nullable BiPredicate<Field, Integer> biPredicate, @Nullable Map<Integer, String> map, Class<?> ... classArray) {
        if (map == null) {
            map = new HashMap<Integer, String>(64);
        }
        int n = 25;
        for (Class<?> clazz : classArray) {
            for (Field field : clazz.getDeclaredFields()) {
                if ((field.getModifiers() & n) != n || field.getType() != Integer.TYPE) continue;
                try {
                    Integer n2 = field.getInt(null);
                    if (biPredicate != null && !biPredicate.test(field, n2)) continue;
                    String string = map.get(n2);
                    map.put(n2, string == null ? field.getName() : string + "|" + field.getName());
                }
                catch (IllegalAccessException illegalAccessException) {
                    // empty catch block
                }
            }
        }
        return map;
    }

    public static long apiArray(MemoryStack memoryStack, long ... lArray) {
        PointerBuffer pointerBuffer = MemoryUtil.memPointerBuffer(memoryStack.nmalloc(MemoryStack.POINTER_SIZE, lArray.length << MemoryStack.POINTER_SHIFT), lArray.length);
        for (long l : lArray) {
            pointerBuffer.put(l);
        }
        return pointerBuffer.address;
    }

    public static long apiArray(MemoryStack memoryStack, ByteBuffer ... byteBufferArray) {
        PointerBuffer pointerBuffer = MemoryUtil.memPointerBuffer(memoryStack.nmalloc(MemoryStack.POINTER_SIZE, byteBufferArray.length << MemoryStack.POINTER_SHIFT), byteBufferArray.length);
        for (ByteBuffer byteBuffer : byteBufferArray) {
            pointerBuffer.put(byteBuffer);
        }
        return pointerBuffer.address;
    }

    public static long apiArrayp(MemoryStack memoryStack, ByteBuffer ... byteBufferArray) {
        long l = APIUtil.apiArray(memoryStack, byteBufferArray);
        PointerBuffer pointerBuffer = memoryStack.mallocPointer(byteBufferArray.length);
        for (ByteBuffer byteBuffer : byteBufferArray) {
            pointerBuffer.put(byteBuffer.remaining());
        }
        return l;
    }

    public static long apiArray(MemoryStack memoryStack, Encoder encoder, CharSequence ... charSequenceArray) {
        PointerBuffer pointerBuffer = memoryStack.mallocPointer(charSequenceArray.length);
        for (CharSequence charSequence : charSequenceArray) {
            pointerBuffer.put(encoder.encode(charSequence, true));
        }
        return pointerBuffer.address;
    }

    public static long apiArrayi(MemoryStack memoryStack, Encoder encoder, CharSequence ... charSequenceArray) {
        PointerBuffer pointerBuffer = memoryStack.mallocPointer(charSequenceArray.length);
        IntBuffer intBuffer = memoryStack.mallocInt(charSequenceArray.length);
        for (CharSequence charSequence : charSequenceArray) {
            ByteBuffer byteBuffer = encoder.encode(charSequence, false);
            pointerBuffer.put(byteBuffer);
            intBuffer.put(byteBuffer.capacity());
        }
        return pointerBuffer.address;
    }

    public static long apiArrayp(MemoryStack memoryStack, Encoder encoder, CharSequence ... charSequenceArray) {
        PointerBuffer pointerBuffer = memoryStack.mallocPointer(charSequenceArray.length);
        PointerBuffer pointerBuffer2 = memoryStack.mallocPointer(charSequenceArray.length);
        for (CharSequence charSequence : charSequenceArray) {
            ByteBuffer byteBuffer = encoder.encode(charSequence, false);
            pointerBuffer.put(byteBuffer);
            pointerBuffer2.put(byteBuffer.capacity());
        }
        return pointerBuffer.address;
    }

    public static void apiArrayFree(long l, int n) {
        int n2 = n;
        while (--n2 >= 0) {
            MemoryUtil.nmemFree(MemoryUtil.memGetAddress(l + Integer.toUnsignedLong(n2) * (long)MemoryStack.POINTER_SIZE));
        }
    }

    public static FFIType apiCreateStruct(FFIType ... fFITypeArray) {
        MemoryUtil.MemoryAllocator memoryAllocator = MemoryUtil.getAllocator();
        PointerBuffer pointerBuffer = PointerBuffer.create(memoryAllocator.malloc((fFITypeArray.length + 1) * MemoryStack.POINTER_SIZE), fFITypeArray.length + 1);
        for (int i = 0; i < fFITypeArray.length; ++i) {
            pointerBuffer.put(i, fFITypeArray[i]);
        }
        pointerBuffer.put(fFITypeArray.length, 0L);
        return FFIType.create(memoryAllocator.calloc(1L, FFIType.SIZEOF)).type((short)13).elements(pointerBuffer);
    }

    private static FFIType prep(FFIType fFIType) {
        try (MemoryStack memoryStack = MemoryStack.stackPush();){
            FFICIF fFICIF = FFICIF.calloc(memoryStack);
            if (LibFFI.ffi_prep_cif(fFICIF, LibFFI.FFI_DEFAULT_ABI, fFIType, null) != 0) {
                throw new IllegalStateException("Failed to prepare LibFFI type.");
            }
        }
        return fFIType;
    }

    public static FFIType apiCreateUnion(FFIType ... fFITypeArray) {
        MemoryUtil.MemoryAllocator memoryAllocator = MemoryUtil.getAllocator();
        FFIType fFIType = APIUtil.prep(fFITypeArray[0]);
        short s = fFITypeArray[0].alignment();
        for (int i = 1; i < fFITypeArray.length; ++i) {
            FFIType fFIType2 = APIUtil.prep(fFITypeArray[i]);
            if (fFIType.size() < fFIType2.size()) {
                fFIType = fFIType2;
            }
            if (s >= fFIType2.alignment()) continue;
            s = fFIType2.alignment();
        }
        return FFIType.create(memoryAllocator.malloc(FFIType.SIZEOF)).size(fFIType.size()).alignment(s).type((short)13).elements(PointerBuffer.create(memoryAllocator.malloc(2 * MemoryStack.POINTER_SIZE), 2).put(0, fFIType).put(1, 0L));
    }

    public static FFIType apiCreateArray(FFIType fFIType, int n) {
        MemoryUtil.MemoryAllocator memoryAllocator = MemoryUtil.getAllocator();
        PointerBuffer pointerBuffer = PointerBuffer.create(memoryAllocator.malloc((n + 1) * MemoryStack.POINTER_SIZE), n + 1);
        for (int i = 0; i < n; ++i) {
            pointerBuffer.put(i, fFIType);
        }
        pointerBuffer.put(n, 0L);
        return FFIType.create(memoryAllocator.calloc(1L, FFIType.SIZEOF)).type((short)13).elements(pointerBuffer);
    }

    public static FFICIF apiCreateCIF(int n, FFIType fFIType, FFIType ... fFITypeArray) {
        MemoryUtil.MemoryAllocator memoryAllocator = MemoryUtil.getAllocator();
        PointerBuffer pointerBuffer = PointerBuffer.create(memoryAllocator.malloc(fFITypeArray.length * MemoryStack.POINTER_SIZE), fFITypeArray.length);
        for (int i = 0; i < fFITypeArray.length; ++i) {
            pointerBuffer.put(i, fFITypeArray[i]);
        }
        FFICIF fFICIF = FFICIF.create(memoryAllocator.malloc(FFICIF.SIZEOF));
        int n2 = LibFFI.ffi_prep_cif(fFICIF, n, fFIType, pointerBuffer);
        if (n2 != 0) {
            throw new IllegalStateException("Failed to prepare libffi CIF: " + n2);
        }
        return fFICIF;
    }

    public static FFICIF apiCreateCIFVar(int n, int n2, FFIType fFIType, FFIType ... fFITypeArray) {
        MemoryUtil.MemoryAllocator memoryAllocator = MemoryUtil.getAllocator();
        PointerBuffer pointerBuffer = PointerBuffer.create(memoryAllocator.malloc(fFITypeArray.length * MemoryStack.POINTER_SIZE), fFITypeArray.length);
        for (int i = 0; i < fFITypeArray.length; ++i) {
            pointerBuffer.put(i, fFITypeArray[i]);
        }
        FFICIF fFICIF = FFICIF.create(memoryAllocator.malloc(FFICIF.SIZEOF));
        int n3 = LibFFI.ffi_prep_cif_var(fFICIF, n, n2, fFIType, pointerBuffer);
        if (n3 != 0) {
            throw new IllegalStateException("Failed to prepare libffi var CIF: " + n3);
        }
        return fFICIF;
    }

    public static int apiStdcall() {
        return Platform.get() == Platform.WINDOWS && Pointer.BITS32 ? LibFFI.FFI_STDCALL : LibFFI.FFI_DEFAULT_ABI;
    }

    public static void apiClosureRet(long l, boolean bl) {
        MemoryUtil.memPutAddress(l, bl ? 1L : 0L);
    }

    public static void apiClosureRet(long l, byte by) {
        MemoryUtil.memPutAddress(l, (long)by & 0xFFL);
    }

    public static void apiClosureRet(long l, short s) {
        MemoryUtil.memPutAddress(l, (long)s & 0xFFFFL);
    }

    public static void apiClosureRet(long l, int n) {
        MemoryUtil.memPutAddress(l, (long)n & 0xFFFFFFFFL);
    }

    public static void apiClosureRetL(long l, long l2) {
        MemoryUtil.memPutLong(l, l2);
    }

    public static void apiClosureRetP(long l, long l2) {
        MemoryUtil.memPutAddress(l, l2);
    }

    public static void apiClosureRet(long l, float f) {
        MemoryUtil.memPutFloat(l, f);
    }

    public static void apiClosureRet(long l, double d) {
        MemoryUtil.memPutDouble(l, d);
    }

    static {
        String string = "[^\\d\\n\\r]*";
        String string2 = "(\\d+)[.](\\d+)(?:[.](\\S+))?";
        String string3 = "(?:\\s+(.+?))?\\s*";
        API_VERSION_PATTERN = Pattern.compile("^" + string + string2 + string3 + "$", 32);
    }

    public static interface Encoder {
        public ByteBuffer encode(CharSequence var1, boolean var2);
    }

    public static class APIVersion
    implements Comparable<APIVersion> {
        public final int major;
        public final int minor;
        public final @Nullable String revision;
        public final @Nullable String implementation;

        public APIVersion(int n, int n2) {
            this(n, n2, null, null);
        }

        public APIVersion(int n, int n2, @Nullable String string, @Nullable String string2) {
            this.major = n;
            this.minor = n2;
            this.revision = string;
            this.implementation = string2;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder(16);
            stringBuilder.append(this.major).append('.').append(this.minor);
            if (this.revision != null) {
                stringBuilder.append('.').append(this.revision);
            }
            if (this.implementation != null) {
                stringBuilder.append(" (").append(this.implementation).append(')');
            }
            return stringBuilder.toString();
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (!(object instanceof APIVersion)) {
                return false;
            }
            APIVersion aPIVersion = (APIVersion)object;
            return this.major == aPIVersion.major && this.minor == aPIVersion.major && Objects.equals(this.revision, aPIVersion.revision) && Objects.equals(this.implementation, aPIVersion.implementation);
        }

        public int hashCode() {
            int n = this.major;
            n = 31 * n + this.minor;
            n = 31 * n + (this.revision != null ? this.revision.hashCode() : 0);
            n = 31 * n + (this.implementation != null ? this.implementation.hashCode() : 0);
            return n;
        }

        @Override
        public int compareTo(APIVersion aPIVersion) {
            if (this.major != aPIVersion.major) {
                return Integer.compare(this.major, aPIVersion.major);
            }
            if (this.minor != aPIVersion.minor) {
                return Integer.compare(this.minor, aPIVersion.minor);
            }
            return 0;
        }
    }
}

