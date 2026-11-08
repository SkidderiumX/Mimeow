/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import x.oca9cc61aada;

public class occ4cfb65507
extends oca9cc61aada {
    private final List<String> \u03fc;
    public static int \u00e9;

    public occ4cfb65507(String string, int n, String[] stringArray) {
        super(string, n, stringArray);
        this.\u03fc = Collections.unmodifiableList(Arrays.asList((String[])stringArray.clone()));
    }

    public occ4cfb65507(String string, int n2) {
        super(string, (double)n2, 0.0, 9.0, 1.0);
        this.\u03fc = IntStream.rangeClosed(0, 0x26D6959F ^ 0x26D69596).mapToObj(n -> {
            Object object;
            block6: {
                int n2;
                block4: {
                    block5: {
                        int n3 = oca9cc61aada.\u01f7;
                        n2 = n;
                        if (n3 != 0) break block4;
                        if (n2 != 0) break block5;
                        object = "None";
                        break block6;
                    }
                    n2 = n;
                }
                object = "Slot " + n2;
            }
            return object;
        }).toList();
    }

    public List<String> \u04ed() {
        return this.\u03fc;
    }
}

