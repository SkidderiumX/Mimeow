/*
 * Decompiled with CFR 0.152.
 */
package de.florianmichael.viamcp;

import com.viaversion.viaversion.api.connection.UserConnection;
import de.florianmichael.vialoadingbase.netty.VLBPipeline;

public class MCPVLBPipeline
extends VLBPipeline {
    public MCPVLBPipeline(UserConnection userConnection) {
        super(userConnection);
    }

    @Override
    public String z$2k9bvms96uf74() {
        return "decoder";
    }

    @Override
    public String z$3hf8gmbusm194() {
        return "encoder";
    }

    @Override
    public String z$1xjrefqy4f2y0() {
        return "decompress";
    }

    @Override
    public String z$eywqmm9wigl3() {
        return "compress";
    }
}

