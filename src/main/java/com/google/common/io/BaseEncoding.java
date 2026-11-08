/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Ascii;
import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;
import com.google.common.io.ByteSink;
import com.google.common.io.ByteSource;
import com.google.common.io.CharSink;
import com.google.common.io.CharSource;
import com.google.common.io.GwtWorkarounds;
import com.google.common.math.IntMath;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.math.RoundingMode;
import java.util.Arrays;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@Beta
@GwtCompatible(emulated=true)
public abstract class BaseEncoding {
    private static final BaseEncoding BASE64 = new StandardBaseEncoding("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", Character.valueOf('='));
    private static final BaseEncoding BASE64_URL = new StandardBaseEncoding("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", Character.valueOf('='));
    private static final BaseEncoding BASE32 = new StandardBaseEncoding("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", Character.valueOf('='));
    private static final BaseEncoding BASE32_HEX = new StandardBaseEncoding("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", Character.valueOf('='));
    private static final BaseEncoding BASE16 = new StandardBaseEncoding("base16()", "0123456789ABCDEF", null);

    BaseEncoding() {
    }

    public String encode(byte[] byArray) {
        return this.encode(Preconditions.checkNotNull(byArray), 0, byArray.length);
    }

    public final String encode(byte[] byArray, int n, int n2) {
        Preconditions.checkNotNull(byArray);
        Preconditions.checkPositionIndexes(n, n + n2, byArray.length);
        GwtWorkarounds.CharOutput charOutput = GwtWorkarounds.stringBuilderOutput(this.maxEncodedSize(n2));
        GwtWorkarounds.ByteOutput byteOutput = this.encodingStream(charOutput);
        try {
            for (int i = 0; i < n2; ++i) {
                byteOutput.write(byArray[n + i]);
            }
            byteOutput.close();
        }
        catch (IOException iOException) {
            throw new AssertionError((Object)"impossible");
        }
        return charOutput.toString();
    }

    @GwtIncompatible(value="Writer,OutputStream")
    public final OutputStream encodingStream(Writer writer) {
        return GwtWorkarounds.asOutputStream(this.encodingStream(GwtWorkarounds.asCharOutput(writer)));
    }

    @GwtIncompatible(value="ByteSink,CharSink")
    public final ByteSink encodingSink(final CharSink charSink) {
        Preconditions.checkNotNull(charSink);
        return new ByteSink(){

            @Override
            public OutputStream openStream() throws IOException {
                return BaseEncoding.this.encodingStream(charSink.openStream());
            }
        };
    }

    private static byte[] extract(byte[] byArray, int n) {
        if (n == byArray.length) {
            return byArray;
        }
        byte[] byArray2 = new byte[n];
        System.arraycopy(byArray, 0, byArray2, 0, n);
        return byArray2;
    }

    public final byte[] decode(CharSequence charSequence) {
        try {
            return this.decodeChecked(charSequence);
        }
        catch (DecodingException decodingException) {
            throw new IllegalArgumentException(decodingException);
        }
    }

    final byte[] decodeChecked(CharSequence charSequence) throws DecodingException {
        charSequence = this.padding().trimTrailingFrom(charSequence);
        GwtWorkarounds.ByteInput byteInput = this.decodingStream(GwtWorkarounds.asCharInput(charSequence));
        byte[] byArray = new byte[this.maxDecodedSize(charSequence.length())];
        int n = 0;
        try {
            int n2 = byteInput.read();
            while (n2 != -1) {
                byArray[n++] = (byte)n2;
                n2 = byteInput.read();
            }
        }
        catch (DecodingException decodingException) {
            throw decodingException;
        }
        catch (IOException iOException) {
            throw new AssertionError((Object)iOException);
        }
        return BaseEncoding.extract(byArray, n);
    }

    @GwtIncompatible(value="Reader,InputStream")
    public final InputStream decodingStream(Reader reader) {
        return GwtWorkarounds.asInputStream(this.decodingStream(GwtWorkarounds.asCharInput(reader)));
    }

    @GwtIncompatible(value="ByteSource,CharSource")
    public final ByteSource decodingSource(final CharSource charSource) {
        Preconditions.checkNotNull(charSource);
        return new ByteSource(){

            @Override
            public InputStream openStream() throws IOException {
                return BaseEncoding.this.decodingStream(charSource.openStream());
            }
        };
    }

    abstract int maxEncodedSize(int var1);

    abstract GwtWorkarounds.ByteOutput encodingStream(GwtWorkarounds.CharOutput var1);

    abstract int maxDecodedSize(int var1);

    abstract GwtWorkarounds.ByteInput decodingStream(GwtWorkarounds.CharInput var1);

    abstract CharMatcher padding();

    @CheckReturnValue
    public abstract BaseEncoding omitPadding();

    @CheckReturnValue
    public abstract BaseEncoding withPadChar(char var1);

    @CheckReturnValue
    public abstract BaseEncoding withSeparator(String var1, int var2);

    @CheckReturnValue
    public abstract BaseEncoding upperCase();

    @CheckReturnValue
    public abstract BaseEncoding lowerCase();

    public static BaseEncoding base64() {
        return BASE64;
    }

    public static BaseEncoding base64Url() {
        return BASE64_URL;
    }

    public static BaseEncoding base32() {
        return BASE32;
    }

    public static BaseEncoding base32Hex() {
        return BASE32_HEX;
    }

    public static BaseEncoding base16() {
        return BASE16;
    }

    static GwtWorkarounds.CharInput ignoringInput(final GwtWorkarounds.CharInput charInput, final CharMatcher charMatcher) {
        Preconditions.checkNotNull(charInput);
        Preconditions.checkNotNull(charMatcher);
        return new GwtWorkarounds.CharInput(){

            @Override
            public int read() throws IOException {
                int n;
                while ((n = charInput.read()) != -1 && charMatcher.matches((char)n)) {
                }
                return n;
            }

            @Override
            public void close() throws IOException {
                charInput.close();
            }
        };
    }

    static GwtWorkarounds.CharOutput separatingOutput(final GwtWorkarounds.CharOutput charOutput, final String string, final int n) {
        Preconditions.checkNotNull(charOutput);
        Preconditions.checkNotNull(string);
        Preconditions.checkArgument(n > 0);
        return new GwtWorkarounds.CharOutput(){
            int charsUntilSeparator;
            {
                this.charsUntilSeparator = n;
            }

            @Override
            public void write(char c) throws IOException {
                if (this.charsUntilSeparator == 0) {
                    for (int i = 0; i < string.length(); ++i) {
                        charOutput.write(string.charAt(i));
                    }
                    this.charsUntilSeparator = n;
                }
                charOutput.write(c);
                --this.charsUntilSeparator;
            }

            @Override
            public void flush() throws IOException {
                charOutput.flush();
            }

            @Override
            public void close() throws IOException {
                charOutput.close();
            }
        };
    }

    public static final class SeparatedBaseEncoding
    extends BaseEncoding {
        private final BaseEncoding delegate;
        private final String separator;
        private final int afterEveryChars;
        private final CharMatcher separatorChars;

        SeparatedBaseEncoding(BaseEncoding baseEncoding, String string, int n) {
            this.delegate = Preconditions.checkNotNull(baseEncoding);
            this.separator = Preconditions.checkNotNull(string);
            this.afterEveryChars = n;
            Preconditions.checkArgument(n > 0, "Cannot add a separator after every %s chars", n);
            this.separatorChars = CharMatcher.anyOf(string).precomputed();
        }

        @Override
        CharMatcher padding() {
            return this.delegate.padding();
        }

        @Override
        int maxEncodedSize(int n) {
            int n2 = this.delegate.maxEncodedSize(n);
            return n2 + this.separator.length() * IntMath.divide(Math.max(0, n2 - 1), this.afterEveryChars, RoundingMode.FLOOR);
        }

        @Override
        GwtWorkarounds.ByteOutput encodingStream(GwtWorkarounds.CharOutput charOutput) {
            return this.delegate.encodingStream(SeparatedBaseEncoding.separatingOutput(charOutput, this.separator, this.afterEveryChars));
        }

        @Override
        int maxDecodedSize(int n) {
            return this.delegate.maxDecodedSize(n);
        }

        @Override
        GwtWorkarounds.ByteInput decodingStream(GwtWorkarounds.CharInput charInput) {
            return this.delegate.decodingStream(SeparatedBaseEncoding.ignoringInput(charInput, this.separatorChars));
        }

        @Override
        public BaseEncoding omitPadding() {
            return this.delegate.omitPadding().withSeparator(this.separator, this.afterEveryChars);
        }

        @Override
        public BaseEncoding withPadChar(char c) {
            return this.delegate.withPadChar(c).withSeparator(this.separator, this.afterEveryChars);
        }

        @Override
        public BaseEncoding withSeparator(String string, int n) {
            throw new UnsupportedOperationException("Already have a separator");
        }

        @Override
        public BaseEncoding upperCase() {
            return this.delegate.upperCase().withSeparator(this.separator, this.afterEveryChars);
        }

        @Override
        public BaseEncoding lowerCase() {
            return this.delegate.lowerCase().withSeparator(this.separator, this.afterEveryChars);
        }

        public String toString() {
            return this.delegate.toString() + ".withSeparator(\"" + this.separator + "\", " + this.afterEveryChars + ")";
        }
    }

    public static final class StandardBaseEncoding
    extends BaseEncoding {
        private final Alphabet alphabet;
        @Nullable
        private final Character paddingChar;
        private transient BaseEncoding upperCase;
        private transient BaseEncoding lowerCase;

        StandardBaseEncoding(String string, String string2, @Nullable Character c) {
            this(new Alphabet(string, string2.toCharArray()), c);
        }

        StandardBaseEncoding(Alphabet alphabet, @Nullable Character c) {
            this.alphabet = Preconditions.checkNotNull(alphabet);
            Preconditions.checkArgument(c == null || !alphabet.matches(c.charValue()), "Padding character %s was already in alphabet", c);
            this.paddingChar = c;
        }

        @Override
        CharMatcher padding() {
            return this.paddingChar == null ? CharMatcher.NONE : CharMatcher.is(this.paddingChar.charValue());
        }

        @Override
        int maxEncodedSize(int n) {
            return this.alphabet.charsPerChunk * IntMath.divide(n, this.alphabet.bytesPerChunk, RoundingMode.CEILING);
        }

        @Override
        GwtWorkarounds.ByteOutput encodingStream(final GwtWorkarounds.CharOutput charOutput) {
            Preconditions.checkNotNull(charOutput);
            return new GwtWorkarounds.ByteOutput(){
                int bitBuffer = 0;
                int bitBufferLength = 0;
                int writtenChars = 0;

                @Override
                public void write(byte by) throws IOException {
                    this.bitBuffer <<= 8;
                    this.bitBuffer |= by & 0xFF;
                    this.bitBufferLength += 8;
                    while (this.bitBufferLength >= ((StandardBaseEncoding)StandardBaseEncoding.this).alphabet.bitsPerChar) {
                        int n = this.bitBuffer >> this.bitBufferLength - ((StandardBaseEncoding)StandardBaseEncoding.this).alphabet.bitsPerChar & ((StandardBaseEncoding)StandardBaseEncoding.this).alphabet.mask;
                        charOutput.write(StandardBaseEncoding.this.alphabet.encode(n));
                        ++this.writtenChars;
                        this.bitBufferLength -= ((StandardBaseEncoding)StandardBaseEncoding.this).alphabet.bitsPerChar;
                    }
                }

                @Override
                public void flush() throws IOException {
                    charOutput.flush();
                }

                @Override
                public void close() throws IOException {
                    if (this.bitBufferLength > 0) {
                        int n = this.bitBuffer << ((StandardBaseEncoding)StandardBaseEncoding.this).alphabet.bitsPerChar - this.bitBufferLength & ((StandardBaseEncoding)StandardBaseEncoding.this).alphabet.mask;
                        charOutput.write(StandardBaseEncoding.this.alphabet.encode(n));
                        ++this.writtenChars;
                        if (StandardBaseEncoding.this.paddingChar != null) {
                            while (this.writtenChars % ((StandardBaseEncoding)StandardBaseEncoding.this).alphabet.charsPerChunk != 0) {
                                charOutput.write(StandardBaseEncoding.this.paddingChar.charValue());
                                ++this.writtenChars;
                            }
                        }
                    }
                    charOutput.close();
                }
            };
        }

        @Override
        int maxDecodedSize(int n) {
            return (int)(((long)this.alphabet.bitsPerChar * (long)n + 7L) / 8L);
        }

        @Override
        GwtWorkarounds.ByteInput decodingStream(final GwtWorkarounds.CharInput charInput) {
            Preconditions.checkNotNull(charInput);
            return new GwtWorkarounds.ByteInput(){
                int bitBuffer = 0;
                int bitBufferLength = 0;
                int readChars = 0;
                boolean hitPadding = false;
                final CharMatcher paddingMatcher = StandardBaseEncoding.this.padding();

                @Override
                public int read() throws IOException {
                    while (true) {
                        int n;
                        if ((n = charInput.read()) == -1) {
                            if (!this.hitPadding && !StandardBaseEncoding.this.alphabet.isValidPaddingStartPosition(this.readChars)) {
                                throw new DecodingException("Invalid input length " + this.readChars);
                            }
                            return -1;
                        }
                        ++this.readChars;
                        char c = (char)n;
                        if (this.paddingMatcher.matches(c)) {
                            if (!(this.hitPadding || this.readChars != 1 && StandardBaseEncoding.this.alphabet.isValidPaddingStartPosition(this.readChars - 1))) {
                                throw new DecodingException("Padding cannot start at index " + this.readChars);
                            }
                            this.hitPadding = true;
                            continue;
                        }
                        if (this.hitPadding) {
                            throw new DecodingException("Expected padding character but found '" + c + "' at index " + this.readChars);
                        }
                        this.bitBuffer <<= ((StandardBaseEncoding)StandardBaseEncoding.this).alphabet.bitsPerChar;
                        this.bitBuffer |= StandardBaseEncoding.this.alphabet.decode(c);
                        this.bitBufferLength += ((StandardBaseEncoding)StandardBaseEncoding.this).alphabet.bitsPerChar;
                        if (this.bitBufferLength >= 8) break;
                    }
                    this.bitBufferLength -= 8;
                    return this.bitBuffer >> this.bitBufferLength & 0xFF;
                }

                @Override
                public void close() throws IOException {
                    charInput.close();
                }
            };
        }

        @Override
        public BaseEncoding omitPadding() {
            return this.paddingChar == null ? this : new StandardBaseEncoding(this.alphabet, null);
        }

        @Override
        public BaseEncoding withPadChar(char c) {
            if (8 % this.alphabet.bitsPerChar == 0 || this.paddingChar != null && this.paddingChar.charValue() == c) {
                return this;
            }
            return new StandardBaseEncoding(this.alphabet, Character.valueOf(c));
        }

        @Override
        public BaseEncoding withSeparator(String string, int n) {
            Preconditions.checkNotNull(string);
            Preconditions.checkArgument(this.padding().or(this.alphabet).matchesNoneOf(string), "Separator cannot contain alphabet or padding characters");
            return new SeparatedBaseEncoding(this, string, n);
        }

        @Override
        public BaseEncoding upperCase() {
            BaseEncoding baseEncoding = this.upperCase;
            if (baseEncoding == null) {
                Alphabet alphabet = this.alphabet.upperCase();
                this.upperCase = alphabet == this.alphabet ? this : new StandardBaseEncoding(alphabet, this.paddingChar);
                baseEncoding = this.upperCase;
            }
            return baseEncoding;
        }

        @Override
        public BaseEncoding lowerCase() {
            BaseEncoding baseEncoding = this.lowerCase;
            if (baseEncoding == null) {
                Alphabet alphabet = this.alphabet.lowerCase();
                this.lowerCase = alphabet == this.alphabet ? this : new StandardBaseEncoding(alphabet, this.paddingChar);
                baseEncoding = this.lowerCase;
            }
            return baseEncoding;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("BaseEncoding.");
            stringBuilder.append(this.alphabet.toString());
            if (8 % this.alphabet.bitsPerChar != 0) {
                if (this.paddingChar == null) {
                    stringBuilder.append(".omitPadding()");
                } else {
                    stringBuilder.append(".withPadChar(").append(this.paddingChar).append(')');
                }
            }
            return stringBuilder.toString();
        }
    }

    private static final class Alphabet
    extends CharMatcher {
        private final String name;
        private final char[] chars;
        final int mask;
        final int bitsPerChar;
        final int charsPerChunk;
        final int bytesPerChunk;
        private final byte[] decodabet;
        private final boolean[] validPadding;

        Alphabet(String string, char[] cArray) {
            char c;
            this.name = Preconditions.checkNotNull(string);
            this.chars = Preconditions.checkNotNull(cArray);
            try {
                this.bitsPerChar = IntMath.log2(cArray.length, RoundingMode.UNNECESSARY);
            }
            catch (ArithmeticException arithmeticException) {
                throw new IllegalArgumentException("Illegal alphabet length " + cArray.length, arithmeticException);
            }
            int n = Math.min(8, Integer.lowestOneBit(this.bitsPerChar));
            this.charsPerChunk = 8 / n;
            this.bytesPerChunk = this.bitsPerChar / n;
            this.mask = cArray.length - 1;
            byte[] byArray = new byte[128];
            Arrays.fill(byArray, (byte)-1);
            for (int i = 0; i < cArray.length; ++i) {
                c = cArray[i];
                Preconditions.checkArgument(CharMatcher.ASCII.matches(c), "Non-ASCII character: %s", Character.valueOf(c));
                Preconditions.checkArgument(byArray[c] == -1, "Duplicate character: %s", Character.valueOf(c));
                byArray[c] = (byte)i;
            }
            this.decodabet = byArray;
            boolean[] blArray = new boolean[this.charsPerChunk];
            for (c = '\u0000'; c < this.bytesPerChunk; ++c) {
                blArray[IntMath.divide((int)(c * 8), (int)this.bitsPerChar, (RoundingMode)RoundingMode.CEILING)] = true;
            }
            this.validPadding = blArray;
        }

        char encode(int n) {
            return this.chars[n];
        }

        boolean isValidPaddingStartPosition(int n) {
            return this.validPadding[n % this.charsPerChunk];
        }

        int decode(char c) throws IOException {
            if (c > '\u007f' || this.decodabet[c] == -1) {
                throw new DecodingException("Unrecognized character: " + c);
            }
            return this.decodabet[c];
        }

        private boolean hasLowerCase() {
            for (char c : this.chars) {
                if (!Ascii.isLowerCase(c)) continue;
                return true;
            }
            return false;
        }

        private boolean hasUpperCase() {
            for (char c : this.chars) {
                if (!Ascii.isUpperCase(c)) continue;
                return true;
            }
            return false;
        }

        Alphabet upperCase() {
            if (!this.hasLowerCase()) {
                return this;
            }
            Preconditions.checkState(!this.hasUpperCase(), "Cannot call upperCase() on a mixed-case alphabet");
            char[] cArray = new char[this.chars.length];
            for (int i = 0; i < this.chars.length; ++i) {
                cArray[i] = Ascii.toUpperCase(this.chars[i]);
            }
            return new Alphabet(this.name + ".upperCase()", cArray);
        }

        Alphabet lowerCase() {
            if (!this.hasUpperCase()) {
                return this;
            }
            Preconditions.checkState(!this.hasLowerCase(), "Cannot call lowerCase() on a mixed-case alphabet");
            char[] cArray = new char[this.chars.length];
            for (int i = 0; i < this.chars.length; ++i) {
                cArray[i] = Ascii.toLowerCase(this.chars[i]);
            }
            return new Alphabet(this.name + ".lowerCase()", cArray);
        }

        @Override
        public boolean matches(char c) {
            return CharMatcher.ASCII.matches(c) && this.decodabet[c] != -1;
        }

        @Override
        public String toString() {
            return this.name;
        }
    }

    public static final class DecodingException
    extends IOException {
        DecodingException(String string) {
            super(string);
        }

        DecodingException(Throwable throwable) {
            super(throwable);
        }
    }
}

