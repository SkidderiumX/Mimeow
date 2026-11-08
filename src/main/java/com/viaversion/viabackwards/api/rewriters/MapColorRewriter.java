/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.api.rewriters;

import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandler;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.rewriter.IdRewriteFunction;

public class MapColorRewriter {
    public static void rewriteMapColors(PacketWrapper packetWrapper, IdRewriteFunction idRewriteFunction, int n) {
        int n2;
        for (n2 = 0; n2 < n; ++n2) {
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.BYTE);
            packetWrapper.passthrough(Types.BYTE);
            packetWrapper.passthrough(Types.BYTE);
            packetWrapper.passthrough(Types.OPTIONAL_COMPONENT);
        }
        n2 = packetWrapper.passthrough(Types.UNSIGNED_BYTE).shortValue();
        if (n2 < 1) {
            return;
        }
        packetWrapper.passthrough(Types.UNSIGNED_BYTE);
        packetWrapper.passthrough(Types.UNSIGNED_BYTE);
        packetWrapper.passthrough(Types.UNSIGNED_BYTE);
        byte[] byArray = packetWrapper.passthrough(Types.BYTE_ARRAY_PRIMITIVE);
        for (int i = 0; i < byArray.length; ++i) {
            int n3 = byArray[i] & 0xFF;
            int n4 = idRewriteFunction.rewrite(n3);
            if (n4 == -1) continue;
            byArray[i] = (byte)n4;
        }
    }

    public static PacketHandler getRewriteHandler(IdRewriteFunction idRewriteFunction) {
        return packetWrapper -> MapColorRewriter.rewriteMapColors(packetWrapper, idRewriteFunction, packetWrapper.passthrough(Types.VAR_INT));
    }
}

