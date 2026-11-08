/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.io;

import java.io.IOException;

public abstract class LineBuffer {
    private StringBuilder line = new StringBuilder();
    private boolean sawReturn;

    LineBuffer() {
    }

    protected void add(char[] cArray, int n, int n2) throws IOException {
        int n3 = n;
        if (this.sawReturn && n2 > 0 && this.finishLine(cArray[n3] == '\n')) {
            ++n3;
        }
        int n4 = n3;
        int n5 = n + n2;
        while (n3 < n5) {
            switch (cArray[n3]) {
                case '\r': {
                    this.line.append(cArray, n4, n3 - n4);
                    this.sawReturn = true;
                    if (n3 + 1 < n5 && this.finishLine(cArray[n3 + 1] == '\n')) {
                        ++n3;
                    }
                    n4 = n3 + 1;
                    break;
                }
                case '\n': {
                    this.line.append(cArray, n4, n3 - n4);
                    this.finishLine(true);
                    n4 = n3 + 1;
                    break;
                }
            }
            ++n3;
        }
        this.line.append(cArray, n4, n + n2 - n4);
    }

    private boolean finishLine(boolean bl) throws IOException {
        this.handleLine(this.line.toString(), this.sawReturn ? (bl ? "\r\n" : "\r") : (bl ? "\n" : ""));
        this.line = new StringBuilder();
        this.sawReturn = false;
        return bl;
    }

    protected void finish() throws IOException {
        if (this.sawReturn || this.line.length() > 0) {
            this.finishLine(false);
        }
    }

    protected abstract void handleLine(String var1, String var2) throws IOException;
}

