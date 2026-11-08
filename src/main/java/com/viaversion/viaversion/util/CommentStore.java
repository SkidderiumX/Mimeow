package com.viaversion.viaversion.util;

import java.util.regex.*;
import java.nio.charset.*;
import java.io.*;
import com.google.common.io.*;
import java.util.*;

public class CommentStore
{
    private final Map<String, List<String>> headers;
    private final String pathSeparator;
    private final String pathSeparatorQuoted;
    private final int indents;
    private List<String> mainHeader;
    
    public CommentStore(final char c, final int indents) {
        this.headers = new HashMap<String, List<String>>();
        this.mainHeader = new ArrayList<String>();
        this.pathSeparator = Character.toString(c);
        this.pathSeparatorQuoted = Pattern.quote(this.pathSeparator);
        this.indents = indents;
    }
    
    public void mainHeader(final String... a) {
        this.mainHeader = Arrays.asList(a);
    }
    
    public List<String> mainHeader() {
        return this.mainHeader;
    }
    
    public void header(final String s, final String... a) {
        this.headers.put(s, Arrays.asList(a));
    }
    
    public List<String> header(final String s) {
        return this.headers.get(s);
    }
    
    public void storeComments(final InputStream in) throws IOException {
        this.mainHeader.clear();
        this.headers.clear();
        String string;
        try (final InputStreamReader inputStreamReader = new InputStreamReader(in, StandardCharsets.UTF_8)) {
            string = CharStreams.toString(inputStreamReader);
        }
        final ArrayList c = new ArrayList();
        int n = 1;
        int n2 = 0;
        int n3 = 0;
        String s = "";
        final String[] split = string.split("\n");
        for (int length = split.length, i = 0; i < length; ++i) {
            final String s2 = split[i];
            final String trim = s2.trim();
            if (trim.startsWith("#")) {
                c.add(trim);
            }
            else {
                if (n != 0) {
                    if (!c.isEmpty()) {
                        c.add("");
                        this.mainHeader.addAll(c);
                        c.clear();
                    }
                    n = 0;
                }
                if (trim.isEmpty()) {
                    c.add(trim);
                }
                else if (trim.startsWith("- |")) {
                    n2 = 1;
                }
                else {
                    final int indents = this.getIndents(s2);
                    final int n4 = indents / this.indents;
                    if (n2 != 0) {
                        if (n4 > n3) {
                            continue;
                        }
                        n2 = 0;
                    }
                    if (n4 <= n3) {
                        final String[] split2 = s.split(this.pathSeparatorQuoted);
                        final int n5 = split2.length - (n3 - n4 + 1);
                        s = ((n5 >= 0) ? this.join(split2, n5) : s);
                    }
                    s = s + (s.isEmpty() ? "" : this.pathSeparator) + ((s2.indexOf(58) != -1) ? s2.split(Pattern.quote(":"))[0] : s2).substring(indents);
                    n3 = n4;
                    if (!c.isEmpty()) {
                        this.headers.put(s, new ArrayList<String>(c));
                        c.clear();
                    }
                }
            }
        }
    }
    
    public void writeComments(final String s, final File file) throws IOException {
        final StringBuilder sb = new StringBuilder();
        final Iterator<String> iterator = this.mainHeader.iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next()).append('\n');
        }
        sb.deleteCharAt(sb.length() - 1);
        int n = 0;
        String join = "";
        for (String s2 : s.lines().toList()) {
            if (s2.isEmpty()) {
                continue;
            }
            final int indents = this.getIndents(s2);
            final int n2 = indents / this.indents;
            final String substring = s2.substring(indents);
            int n3;
            if (substring.trim().isEmpty() || substring.charAt(0) == '-') {
                n3 = 0;
            }
            else if (n2 <= n) {
                final String[] split = join.split(this.pathSeparatorQuoted);
                join = this.join(split, split.length - (n - n2 + 1));
                n3 = 1;
            }
            else {
                n3 = ((s2.indexOf(58) != -1) ? 1 : 0);
            }
            if (n3 == 0) {
                sb.append(s2).append('\n');
            }
            else {
                final String s3 = substring.split(Pattern.quote(":"))[0];
                if (!join.isEmpty()) {
                    join += this.pathSeparator;
                }
                join += s3;
                final List list = this.headers.get(join);
                if (list != null && !list.isEmpty()) {
                    final String str = (indents > 0) ? s2.substring(0, indents) : "";
                    for (final String str2 : list) {
                        if (str2.isEmpty()) {
                            sb.append('\n');
                        }
                        else {
                            sb.append(str).append(str2).append('\n');
                        }
                    }
                }
                n = n2;
                sb.append(s2).append('\n');
            }
        }
        Files.write(sb.toString(), file, StandardCharsets.UTF_8);
    }
    
    private int getIndents(final String s) {
        int n = 0;
        for (int index = 0; index < s.length() && s.charAt(index) == ' '; ++index) {
            ++n;
        }
        return n;
    }
    
    private String join(final String[] array, final int n) {
        final String[] elements = new String[n];
        System.arraycopy(array, 0, elements, 0, n);
        return String.join(this.pathSeparator, (CharSequence[])elements);
    }
}
