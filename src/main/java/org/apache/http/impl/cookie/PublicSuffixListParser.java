/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl.cookie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import org.apache.http.annotation.Immutable;
import org.apache.http.impl.cookie.PublicSuffixFilter;

@Immutable
public class PublicSuffixListParser {
    private static final int MAX_LINE_LEN = 256;
    private final PublicSuffixFilter filter;

    PublicSuffixListParser(PublicSuffixFilter publicSuffixFilter) {
        this.filter = publicSuffixFilter;
    }

    public void parse(Reader reader) throws IOException {
        ArrayList<String> arrayList = new ArrayList<String>();
        ArrayList<String> arrayList2 = new ArrayList<String>();
        BufferedReader bufferedReader = new BufferedReader(reader);
        StringBuilder stringBuilder = new StringBuilder(256);
        boolean bl = true;
        while (bl) {
            boolean bl2;
            bl = this.readLine(bufferedReader, stringBuilder);
            String string = stringBuilder.toString();
            if (string.length() == 0 || string.startsWith("//")) continue;
            if (string.startsWith(".")) {
                string = string.substring(1);
            }
            if (bl2 = string.startsWith("!")) {
                string = string.substring(1);
            }
            if (bl2) {
                arrayList2.add(string);
                continue;
            }
            arrayList.add(string);
        }
        this.filter.setPublicSuffixes(arrayList);
        this.filter.setExceptions(arrayList2);
    }

    private boolean readLine(Reader reader, StringBuilder stringBuilder) throws IOException {
        char c;
        int n;
        stringBuilder.setLength(0);
        boolean bl = false;
        while ((n = reader.read()) != -1 && (c = (char)n) != '\n') {
            if (Character.isWhitespace(c)) {
                bl = true;
            }
            if (!bl) {
                stringBuilder.append(c);
            }
            if (stringBuilder.length() <= 256) continue;
            throw new IOException("Line too long");
        }
        return n != -1;
    }
}

