/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.gson;

import java.util.Objects;

public class FormattingStyle {
    private final String newline;
    private final String indent;
    private final boolean spaceAfterSeparators;
    public static final FormattingStyle COMPACT = new FormattingStyle("", "", false);
    public static final FormattingStyle PRETTY = new FormattingStyle("\n", "  ", true);

    private FormattingStyle(String string, String string2, boolean bl) {
        Objects.requireNonNull(string, "newline == null");
        Objects.requireNonNull(string2, "indent == null");
        if (!string.matches("[\r\n]*")) {
            throw new IllegalArgumentException("Only combinations of \\n and \\r are allowed in newline.");
        }
        if (!string2.matches("[ \t]*")) {
            throw new IllegalArgumentException("Only combinations of spaces and tabs are allowed in indent.");
        }
        this.newline = string;
        this.indent = string2;
        this.spaceAfterSeparators = bl;
    }

    public FormattingStyle withNewline(String string) {
        return new FormattingStyle(string, this.indent, this.spaceAfterSeparators);
    }

    public FormattingStyle withIndent(String string) {
        return new FormattingStyle(this.newline, string, this.spaceAfterSeparators);
    }

    public FormattingStyle withSpaceAfterSeparators(boolean bl) {
        return new FormattingStyle(this.newline, this.indent, bl);
    }

    public String getNewline() {
        return this.newline;
    }

    public String getIndent() {
        return this.indent;
    }

    public boolean usesSpaceAfterSeparators() {
        return this.spaceAfterSeparators;
    }
}

