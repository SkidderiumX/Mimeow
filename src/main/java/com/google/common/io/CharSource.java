/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.base.Ascii;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.io.CharSequenceReader;
import com.google.common.io.CharSink;
import com.google.common.io.CharStreams;
import com.google.common.io.Closer;
import com.google.common.io.InputSupplier;
import com.google.common.io.LineProcessor;
import com.google.common.io.MultiReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

public abstract class CharSource
implements InputSupplier<Reader> {
    protected CharSource() {
    }

    public abstract Reader openStream() throws IOException;

    @Override
    @Deprecated
    public final Reader getInput() throws IOException {
        return this.openStream();
    }

    public BufferedReader openBufferedStream() throws IOException {
        Reader reader = this.openStream();
        return reader instanceof BufferedReader ? (BufferedReader)reader : new BufferedReader(reader);
    }

    public long copyTo(Appendable appendable) throws IOException {
        Preconditions.checkNotNull(appendable);
        Closer closer = Closer.create();
        try {
            Reader reader = closer.register(this.openStream());
            long l = CharStreams.copy(reader, appendable);
            return l;
        }
        catch (Throwable throwable) {
            throw closer.rethrow(throwable);
        }
        finally {
            closer.close();
        }
    }

    public long copyTo(CharSink charSink) throws IOException {
        Preconditions.checkNotNull(charSink);
        Closer closer = Closer.create();
        try {
            Reader reader = closer.register(this.openStream());
            Writer writer = closer.register(charSink.openStream());
            long l = CharStreams.copy(reader, (Appendable)writer);
            return l;
        }
        catch (Throwable throwable) {
            throw closer.rethrow(throwable);
        }
        finally {
            closer.close();
        }
    }

    public String read() throws IOException {
        Closer closer = Closer.create();
        try {
            Reader reader = closer.register(this.openStream());
            String string = CharStreams.toString(reader);
            return string;
        }
        catch (Throwable throwable) {
            throw closer.rethrow(throwable);
        }
        finally {
            closer.close();
        }
    }

    @Nullable
    public String readFirstLine() throws IOException {
        Closer closer = Closer.create();
        try {
            BufferedReader bufferedReader = closer.register(this.openBufferedStream());
            String string = bufferedReader.readLine();
            return string;
        }
        catch (Throwable throwable) {
            throw closer.rethrow(throwable);
        }
        finally {
            closer.close();
        }
    }

    public ImmutableList<String> readLines() throws IOException {
        Closer closer = Closer.create();
        try {
            String string;
            BufferedReader bufferedReader = closer.register(this.openBufferedStream());
            ArrayList<String> arrayList = Lists.newArrayList();
            while ((string = bufferedReader.readLine()) != null) {
                arrayList.add(string);
            }
            ImmutableList<String> immutableList = ImmutableList.copyOf(arrayList);
            return immutableList;
        }
        catch (Throwable throwable) {
            throw closer.rethrow(throwable);
        }
        finally {
            closer.close();
        }
    }

    @Beta
    public <T> T readLines(LineProcessor<T> lineProcessor) throws IOException {
        Preconditions.checkNotNull(lineProcessor);
        Closer closer = Closer.create();
        try {
            Reader reader = closer.register(this.openStream());
            T t = CharStreams.readLines(reader, lineProcessor);
            return t;
        }
        catch (Throwable throwable) {
            throw closer.rethrow(throwable);
        }
        finally {
            closer.close();
        }
    }

    public boolean isEmpty() throws IOException {
        Closer closer = Closer.create();
        try {
            Reader reader = closer.register(this.openStream());
            boolean bl = reader.read() == -1;
            return bl;
        }
        catch (Throwable throwable) {
            throw closer.rethrow(throwable);
        }
        finally {
            closer.close();
        }
    }

    public static CharSource concat(Iterable<? extends CharSource> iterable) {
        return new ConcatenatedCharSource(iterable);
    }

    public static CharSource concat(Iterator<? extends CharSource> iterator2) {
        return CharSource.concat(ImmutableList.copyOf(iterator2));
    }

    public static CharSource concat(CharSource ... charSourceArray) {
        return CharSource.concat(ImmutableList.copyOf(charSourceArray));
    }

    public static CharSource wrap(CharSequence charSequence) {
        return new CharSequenceCharSource(charSequence);
    }

    public static CharSource empty() {
        return EmptyCharSource.INSTANCE;
    }

    private static final class ConcatenatedCharSource
    extends CharSource {
        private final Iterable<? extends CharSource> sources;

        ConcatenatedCharSource(Iterable<? extends CharSource> iterable) {
            this.sources = Preconditions.checkNotNull(iterable);
        }

        @Override
        public Reader openStream() throws IOException {
            return new MultiReader(this.sources.iterator());
        }

        @Override
        public boolean isEmpty() throws IOException {
            for (CharSource charSource : this.sources) {
                if (charSource.isEmpty()) continue;
                return false;
            }
            return true;
        }

        public String toString() {
            return "CharSource.concat(" + this.sources + ")";
        }
    }

    private static final class EmptyCharSource
    extends CharSequenceCharSource {
        private static final EmptyCharSource INSTANCE = new EmptyCharSource();

        private EmptyCharSource() {
            super("");
        }

        @Override
        public String toString() {
            return "CharSource.empty()";
        }
    }

    private static class CharSequenceCharSource
    extends CharSource {
        private static final Splitter LINE_SPLITTER = Splitter.on(Pattern.compile("\r\n|\n|\r"));
        private final CharSequence seq;

        protected CharSequenceCharSource(CharSequence charSequence) {
            this.seq = Preconditions.checkNotNull(charSequence);
        }

        @Override
        public Reader openStream() {
            return new CharSequenceReader(this.seq);
        }

        @Override
        public String read() {
            return this.seq.toString();
        }

        @Override
        public boolean isEmpty() {
            return this.seq.length() == 0;
        }

        private Iterable<String> lines() {
            return new Iterable<String>(){

                @Override
                public Iterator<String> iterator() {
                    return new AbstractIterator<String>(){
                        Iterator<String> lines;
                        {
                            this.lines = LINE_SPLITTER.split(CharSequenceCharSource.this.seq).iterator();
                        }

                        @Override
                        protected String computeNext() {
                            if (this.lines.hasNext()) {
                                String string = this.lines.next();
                                if (this.lines.hasNext() || !string.isEmpty()) {
                                    return string;
                                }
                            }
                            return (String)this.endOfData();
                        }
                    };
                }
            };
        }

        @Override
        public String readFirstLine() {
            Iterator<String> iterator2 = this.lines().iterator();
            return iterator2.hasNext() ? iterator2.next() : null;
        }

        @Override
        public ImmutableList<String> readLines() {
            return ImmutableList.copyOf(this.lines());
        }

        @Override
        public <T> T readLines(LineProcessor<T> lineProcessor) throws IOException {
            for (String string : this.lines()) {
                if (!lineProcessor.processLine(string)) break;
            }
            return lineProcessor.getResult();
        }

        public String toString() {
            return "CharSource.wrap(" + Ascii.truncate(this.seq, 30, "...") + ")";
        }
    }
}

