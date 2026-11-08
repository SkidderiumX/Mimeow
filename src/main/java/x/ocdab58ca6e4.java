/*
 * Decompiled with CFR 0.152.
 */
package x;

import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.util.ReferenceCountUtil;
import java.nio.channels.ClosedChannelException;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import x.oc0798de80d4;
import x.oc3390060a37;
import x.oc35c0bb4ef9;
import x.oc60f9dd7d1b;
import x.ocb6bbd41fe6;
import x.ocf4219784cf;

public class ocdab58ca6e4
extends ChannelDuplexHandler
implements Runnable {
    private static final AtomicInteger \u00fa;
    private static final Set<ocdab58ca6e4> \u0549;
    public static final String \u04cf;
    private final ArrayDeque<oc3390060a37> \u02ad = new ArrayDeque();
    private final ArrayDeque<oc3390060a37> \u00da = new ArrayDeque();
    private final oc0798de80d4 \u01b9;
    private final oc35c0bb4ef9 \u0404;
    private final boolean \u01b2;
    private Future<?> \u02a3;
    private ChannelHandlerContext \u03e3;
    public static boolean \u02e3;

    public ocdab58ca6e4() {
        this(new ocf4219784cf(), new ocb6bbd41fe6(), true);
    }

    public ocdab58ca6e4(oc0798de80d4 oc0798de80d42, oc35c0bb4ef9 oc35c0bb4ef92) {
        this(oc0798de80d42, oc35c0bb4ef92, false);
    }

    private ocdab58ca6e4(oc0798de80d4 oc0798de80d42, oc35c0bb4ef9 oc35c0bb4ef92, boolean bl) {
        this.\u01b9 = oc0798de80d42;
        this.\u0404 = oc35c0bb4ef92;
        this.\u01b2 = bl;
    }

    @Override
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) {
        block5: {
            block4: {
                boolean bl = \u02e3;
                ocdab58ca6e4 ocdab58ca6e42 = this;
                if (bl) break block4;
                ocdab58ca6e42.\u03e3 = channelHandlerContext;
                \u0549.add(this);
                if (!this.\u01b2) break block5;
                ocdab58ca6e42 = this;
            }
            ocdab58ca6e42.\u02a3 = channelHandlerContext.executor().scheduleWithFixedDelay(this, 0x77DA9F411C6B7924L ^ 0x77DA9F411C6B7920L, 0x77DA9F411C6B7924L ^ 0x77DA9F411C6B7920L, TimeUnit.MILLISECONDS);
        }
    }

    @Override
    public void write(ChannelHandlerContext channelHandlerContext, Object object, ChannelPromise channelPromise) {
        this.\u013e(channelHandlerContext, object, channelPromise, true);
    }

    @Override
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object object) {
        this.\u013e(channelHandlerContext, object, null, false);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void \u013e(ChannelHandlerContext channelHandlerContext, Object object, ChannelPromise channelPromise, boolean bl) {
        block17: {
            ArrayDeque<oc3390060a37> arrayDeque;
            int n;
            int n2;
            block21: {
                ArrayDeque<oc3390060a37> arrayDeque2;
                block18: {
                    boolean bl2;
                    block22: {
                        int n3;
                        block19: {
                            block20: {
                                int n4;
                                int n5;
                                block15: {
                                    block16: {
                                        n2 = \u00fa.getAndIncrement();
                                        n5 = this.\u0404.z$5j5sh7l32w6l(object, bl, 0L, n2);
                                        bl2 = \u02e3;
                                        n4 = n5;
                                        if (bl2) break block15;
                                        if (n4 != (0x860F2310 ^ 0x860F2312)) break block16;
                                        ocdab58ca6e4.\u0275(object, channelPromise);
                                        if (!bl2) break block17;
                                    }
                                    n4 = bl ? 1 : 0;
                                }
                                arrayDeque2 = n4 != 0 ? this.\u00da : this.\u02ad;
                                n = n5;
                                if (bl2) break block17;
                                if (n == 1) break block18;
                                n3 = n5;
                                if (bl2) break block19;
                                if (n3 != 0) break block20;
                                arrayDeque = arrayDeque2;
                                if (bl2) break block21;
                                if (!arrayDeque.isEmpty()) break block18;
                            }
                            n3 = bl ? 1 : 0;
                        }
                        if (n3 == 0) break block22;
                        channelHandlerContext.write(object, channelPromise);
                        if (!bl2) break block17;
                    }
                    channelHandlerContext.fireChannelRead(object);
                    if (!bl2) break block17;
                }
                arrayDeque = arrayDeque2;
            }
            n = arrayDeque.add(new oc3390060a37(channelHandlerContext, object, channelPromise, this.\u01b9.z$30uogy23wf28n(), n2)) ? 1 : 0;
        }
    }

    @Override
    public void run() {
        long l = this.\u01b9.z$30uogy23wf28n();
        this.\u01ed(this.\u02ad, false, l);
        this.\u01ed(this.\u00da, true, l);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void \u01ed(ArrayDeque<oc3390060a37> arrayDeque, boolean bl, long l) {
        block17: {
            ChannelHandlerContext channelHandlerContext = null;
            boolean bl2 = \u02e3;
            while (!arrayDeque.isEmpty()) {
                block19: {
                    oc3390060a37 oc3390060a372;
                    block18: {
                        oc3390060a372 = arrayDeque.peek();
                        int n = this.\u0404.z$5j5sh7l32w6l(oc3390060a372.\u03a7, bl, l - oc3390060a372.\u0426, oc3390060a372.b);
                        if (bl2) break block17;
                        int n2 = n;
                        if (!bl2) {
                            if (n2 == 1 && !bl2) break;
                            n2 = n;
                        }
                        if (!bl2) {
                            if (n2 == (0x1BA87CC7 ^ 0x1BA87CC5)) {
                                arrayDeque.removeFirst();
                                ocdab58ca6e4.\u0275(oc3390060a372.\u03a7, oc3390060a372.\u03df);
                                return;
                            }
                            n2 = bl ? 1 : 0;
                        }
                        if (n2 == 0) break block18;
                        oc3390060a372.\u0243.write(oc3390060a372.\u03a7, oc3390060a372.\u03df);
                        channelHandlerContext = oc3390060a372.\u0243;
                        if (!bl2) break block19;
                    }
                    oc3390060a372.\u0243.fireChannelRead(oc3390060a372.\u03a7);
                }
                arrayDeque.removeFirst();
                if (!bl2) continue;
            }
            ChannelHandlerContext channelHandlerContext2 = channelHandlerContext;
            if (!bl2 && channelHandlerContext2 != null) {
                channelHandlerContext2 = channelHandlerContext.flush();
            }
        }
    }

    private static void \u0275(Object object, ChannelPromise channelPromise) {
        ReferenceCountUtil.release(object);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) {
        block4: {
            block5: {
                boolean bl = \u02e3;
                \u0549.remove(this);
                if (bl) break block4;
                if (this.\u02a3 == null) break block5;
                this.\u02a3.cancel(false);
                this.\u02a3 = null;
            }
            this.\u04b6(channelHandlerContext, this.\u02ad, false);
            this.\u04b6(channelHandlerContext, this.\u00da, true);
            channelHandlerContext.flush();
            this.\u03e3 = null;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void \u04b6(ChannelHandlerContext channelHandlerContext, ArrayDeque<oc3390060a37> arrayDeque, boolean bl) {
        boolean bl2 = \u02e3;
        while (!arrayDeque.isEmpty()) {
            block13: {
                oc3390060a37 oc3390060a372;
                block14: {
                    boolean bl3;
                    block10: {
                        block11: {
                            oc3390060a37 oc3390060a373;
                            block12: {
                                oc3390060a372 = arrayDeque.removeFirst();
                                bl3 = channelHandlerContext.channel().isOpen();
                                if (bl2) break block10;
                                if (bl3) break block11;
                                oc3390060a373 = oc3390060a372;
                                if (bl2) break block12;
                                ReferenceCountUtil.release(oc3390060a373.\u03a7);
                                if (oc3390060a372.\u03df == null) break block13;
                                oc3390060a373 = oc3390060a372;
                            }
                            oc3390060a373.\u03df.tryFailure(new ClosedChannelException());
                            if (!bl2) break block13;
                        }
                        bl3 = bl;
                    }
                    if (!bl3) break block14;
                    channelHandlerContext.write(oc3390060a372.\u03a7, oc3390060a372.\u03df);
                    if (!bl2) break block13;
                }
                channelHandlerContext.fireChannelRead(oc3390060a372.\u03a7);
            }
            if (!bl2) continue;
        }
    }

    @Override
    public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
        block4: {
            block5: {
                boolean bl = \u02e3;
                \u0549.remove(this);
                if (bl) break block4;
                if (this.\u02a3 == null) break block5;
                this.\u02a3.cancel(false);
                this.\u02a3 = null;
            }
            this.\u04b6(channelHandlerContext, this.\u02ad, false);
            this.\u04b6(channelHandlerContext, this.\u00da, true);
            super.channelInactive(channelHandlerContext);
        }
    }

    public static void \u0535(boolean bl) {
        Iterator<ocdab58ca6e4> iterator2 = \u0549.iterator();
        boolean bl2 = \u02e3;
        while (iterator2.hasNext()) {
            block4: {
                ChannelHandlerContext channelHandlerContext;
                ChannelHandlerContext channelHandlerContext2;
                ocdab58ca6e4 ocdab58ca6e42;
                block3: {
                    ocdab58ca6e42 = iterator2.next();
                    channelHandlerContext2 = ocdab58ca6e42.\u03e3;
                    channelHandlerContext = channelHandlerContext2;
                    if (bl2) break block3;
                    if (channelHandlerContext == null) break block4;
                    channelHandlerContext = channelHandlerContext2;
                }
                channelHandlerContext.executor().execute(new oc60f9dd7d1b(bl, channelHandlerContext2, ocdab58ca6e42));
            }
            if (!bl2) continue;
        }
    }

    public int \u0238(boolean bl) {
        ArrayDeque<oc3390060a37> arrayDeque = bl ? this.\u00da : this.\u02ad;
        return arrayDeque.size();
    }

    static {
        \u04cf = "mimeow_slinky_packets";
        \u00fa = new AtomicInteger();
        \u0549 = Collections.newSetFromMap(new ConcurrentHashMap());
    }
}

