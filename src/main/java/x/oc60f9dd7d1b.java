/*
 * Decompiled with CFR 0.152.
 */
package x;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import x.ocdab58ca6e4;

public class oc60f9dd7d1b
implements Runnable {
    final boolean val$removeHandler;
    final ChannelHandlerContext val$context;
    final ocdab58ca6e4 val$handler;

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    oc60f9dd7d1b(boolean bl, ChannelHandlerContext channelHandlerContext, ocdab58ca6e4 ocdab58ca6e42) {
        this.val$removeHandler = bl;
        this.val$context = channelHandlerContext;
        this.val$handler = ocdab58ca6e42;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void run() {
        block10: {
            oc60f9dd7d1b oc60f9dd7d1b2;
            block7: {
                block8: {
                    boolean bl;
                    block9: {
                        bl = ocdab58ca6e4.\u02e3;
                        oc60f9dd7d1b2 = this;
                        if (bl) break block7;
                        if (!oc60f9dd7d1b2.val$removeHandler) break block8;
                        ChannelPipeline channelPipeline = this.val$context.pipeline();
                        if (bl) break block9;
                        if (channelPipeline.context(this.val$handler) == null) break block10;
                        channelPipeline = this.val$context.pipeline().remove(this.val$handler);
                    }
                    if (!bl) break block10;
                }
                this.val$handler.\u04b6(this.val$context, this.val$handler.\u02ad, false);
                this.val$handler.\u04b6(this.val$context, this.val$handler.\u00da, true);
                oc60f9dd7d1b2 = this;
            }
            oc60f9dd7d1b2.val$context.flush();
        }
    }
}

