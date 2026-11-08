/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.snakeyaml.serializer;

import com.viaversion.viaversion.libs.snakeyaml.nodes.Node;
import com.viaversion.viaversion.libs.snakeyaml.serializer.AnchorGenerator;
import java.text.NumberFormat;

public class NumberAnchorGenerator
implements AnchorGenerator {
    private int lastAnchorId = 0;

    public NumberAnchorGenerator(int n) {
        this.lastAnchorId = n;
    }

    @Override
    public String nextAnchor(Node node) {
        if (node.getAnchor() != null) {
            return node.getAnchor();
        }
        ++this.lastAnchorId;
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        numberFormat.setMinimumIntegerDigits(3);
        numberFormat.setMaximumFractionDigits(0);
        numberFormat.setGroupingUsed(false);
        String string = numberFormat.format(this.lastAnchorId);
        return "id" + string;
    }
}

