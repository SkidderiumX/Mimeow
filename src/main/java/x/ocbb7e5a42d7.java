/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import x.oc170ea29aae;
import x.oc69da1aa7f5;

public class ocbb7e5a42d7
extends Random {
    private static final long \u041c = -7046029254386353131L;
    private static final AtomicLong \u03c9 = new AtomicLong(System.nanoTime());
    private long \u012f;
    private long \u02ae;
    private long \u0209;
    private long \u0562;
    public static int \u00c7;

    public ocbb7e5a42d7() {
        this(System.nanoTime() ^ ocbb7e5a42d7.\u04b3());
    }

    public ocbb7e5a42d7(long l) {
        super(l);
    }

    private static long \u04b3() {
        return ocbb7e5a42d7.\u0388(\u03c9.addAndGet(0xE087FD5D8FF6BB9EL ^ 0x7EB084E4F0BCC78BL));
    }

    private static long \u0388(long l) {
        l = (l ^ l >>> (0x61A22117 ^ 0x61A22109)) * (0xCB7B0F810618C327L ^ 0x742348EC1AFC269EL);
        l = (l ^ l >>> (0x61A22112 ^ 0x61A22109)) * (0xE0F3015709CD3775L ^ 0x742348EC1AFC269EL);
        return l ^ l >>> (0x61A22116 ^ 0x61A22109);
    }

    private static long \u0513(long l, int n) {
        return l << n | l >>> (0x6DA0A46C ^ 0x6DA0A42C) - n;
    }

    @Override
    public void setSeed(long l) {
        block4: {
            boolean bl;
            block6: {
                block5: {
                    super.setSeed(l);
                    long l2 = l + (0x9AB2E0D26963B4ACL ^ 0x485996B1629C8B9L);
                    boolean bl2 = oc170ea29aae.\u0406;
                    this.\u012f = ocbb7e5a42d7.\u0388(l2);
                    this.\u02ae = ocbb7e5a42d7.\u0388(l2 += 0x9AB2E0D26963B4ACL ^ 0x485996B1629C8B9L);
                    this.\u0209 = ocbb7e5a42d7.\u0388(l2 += 0x9AB2E0D26963B4ACL ^ 0x485996B1629C8B9L);
                    l2 += 0x9AB2E0D26963B4ACL ^ 0x485996B1629C8B9L;
                    this.\u0562 = ocbb7e5a42d7.\u0388(l2);
                    if (!false) break block4;
                    if (!bl2) break block5;
                    bl = false;
                    break block6;
                }
                bl = true;
            }
            oc170ea29aae.\u0406 = bl;
        }
    }

    @Override
    protected int next(int n) {
        return (int)(this.nextLong() >>> (0x86F01336 ^ 0x86F01376) - n);
    }

    @Override
    public long nextLong() {
        long l;
        block4: {
            boolean bl;
            block6: {
                block5: {
                    long l2 = ocbb7e5a42d7.\u0513(this.\u02ae * (0xFCB355292BAFE443L ^ 0xFCB355292BAFE446L), 0x98F9747 ^ 0x98F9740) * (0xFCB355292BAFE44FL ^ 0xFCB355292BAFE446L);
                    long l3 = this.\u02ae << (0x98F9751 ^ 0x98F9740);
                    this.\u0209 ^= this.\u012f;
                    this.\u0562 ^= this.\u02ae;
                    this.\u02ae ^= this.\u0209;
                    boolean bl2 = oc170ea29aae.\u0406;
                    this.\u012f ^= this.\u0562;
                    this.\u0209 ^= l3;
                    this.\u0562 = ocbb7e5a42d7.\u0513(this.\u0562, 0x98F976D ^ 0x98F9740);
                    l = l2;
                    if (!bl2) break block4;
                    if (!false) break block5;
                    bl = false;
                    break block6;
                }
                bl = true;
            }
            oc69da1aa7f5.\u04ac = bl;
        }
        return l;
    }

    @Override
    public int nextInt() {
        return (int)this.nextLong();
    }

    @Override
    public int nextInt(int n) {
        int n2;
        block4: {
            block5: {
                boolean bl = oc170ea29aae.\u0406;
                n2 = n;
                if (bl) break block4;
                if (n2 > 0) break block5;
                throw new IllegalArgumentException("bound must be positive");
            }
            n2 = (int)((this.nextLong() & (0x867207E28CDD1426L ^ 0xF98DF81D7322EBD9L)) % (long)n);
        }
        return n2;
    }

    @Override
    public boolean nextBoolean() {
        long l;
        block2: {
            block3: {
                boolean bl = oc170ea29aae.\u0406;
                long l2 = (this.nextLong() & 1L) - 0L;
                l = l2 == 0L ? 0 : (l2 < 0L ? -1 : 1);
                if (bl) break block2;
                if (l == false) break block3;
                l = 1;
                break block2;
            }
            l = 0;
        }
        return (boolean)l;
    }

    @Override
    public double nextDouble() {
        return (double)(this.nextLong() >>> (0x6EE5B406 ^ 0x6EE5B40D)) * (double)1.110223E-16f;
    }

    @Override
    public float nextFloat() {
        return (float)(this.nextLong() >>> (0xCDA83D76 ^ 0xCDA83D5E)) * 5.9604645E-8f;
    }

    @Override
    public void nextBytes(byte[] byArray) {
        int n = 0;
        boolean bl = oc170ea29aae.\u0406;
        block0: while (n < byArray.length) {
            long l = this.nextLong();
            int n2 = Math.min(byArray.length - n, 0x75CC8C3D ^ 0x75CC8C35);
            while (n2-- > 0) {
                byArray[n++] = (byte)l;
                if (bl) continue block0;
                l >>>= 0x75CC8C3D ^ 0x75CC8C35;
                if (!bl) continue;
            }
            if (!bl) continue;
        }
    }
}

