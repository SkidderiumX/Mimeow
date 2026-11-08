/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import org.apache.commons.lang3.text.translate.CharSequenceTranslator;

public class LookupTranslator
extends CharSequenceTranslator {
    private final HashMap<String, CharSequence> lookupMap = new HashMap();
    private final int shortest;
    private final int longest;

    public LookupTranslator(CharSequence[] ... charSequenceArray) {
        int n = Integer.MAX_VALUE;
        int n2 = 0;
        if (charSequenceArray != null) {
            for (CharSequence[] charSequenceArray2 : charSequenceArray) {
                this.lookupMap.put(charSequenceArray2[0].toString(), charSequenceArray2[1]);
                int n3 = charSequenceArray2[0].length();
                if (n3 < n) {
                    n = n3;
                }
                if (n3 <= n2) continue;
                n2 = n3;
            }
        }
        this.shortest = n;
        this.longest = n2;
    }

    @Override
    public int translate(CharSequence charSequence, int n, Writer writer) throws IOException {
        int n2 = this.longest;
        if (n + this.longest > charSequence.length()) {
            n2 = charSequence.length() - n;
        }
        for (int i = n2; i >= this.shortest; --i) {
            CharSequence charSequence2 = charSequence.subSequence(n, n + i);
            CharSequence charSequence3 = this.lookupMap.get(charSequence2.toString());
            if (charSequence3 == null) continue;
            writer.write(charSequence3.toString());
            return i;
        }
        return 0;
    }
}

