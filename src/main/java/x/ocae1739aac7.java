/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.util.EnumFacing;
import x.oc84f20a0bc5;

public class ocae1739aac7 {
    static final float \u0239 = 17.5f;
    private boolean \u04a3;
    private float \u00d6;
    private float \u0117;

    ocae1739aac7() {
    }

    synchronized void \u02b2() {
        this.\u04a3 = false;
        this.\u0117 = 0.0f;
    }

    synchronized void \u0267(Packet<?> packet) {
        block13: {
            C03PacketPlayer c03PacketPlayer;
            block12: {
                Packet<?> packet2;
                int n;
                block10: {
                    block11: {
                        n = oc84f20a0bc5.\u0117;
                        packet2 = packet;
                        if (n != 0) break block10;
                        if (packet2 instanceof C03PacketPlayer) break block11;
                        return;
                    }
                    packet2 = packet;
                }
                C03PacketPlayer c03PacketPlayer2 = (C03PacketPlayer)packet2;
                c03PacketPlayer = c03PacketPlayer2;
                if (n != 0) break block12;
                if (!c03PacketPlayer.getRotating()) break block13;
                c03PacketPlayer = c03PacketPlayer2;
            }
            float f = c03PacketPlayer.getPitch();
            ocae1739aac7 ocae1739aac72 = this;
            float f2 = this.\u04a3 ? Math.abs(f - this.\u00d6) : 0.0f;
            ocae1739aac72.\u0117 = f2;
            this.\u04a3 = Float.isFinite(f);
            this.\u00d6 = f;
        }
    }

    synchronized boolean \u00f6(EnumFacing enumFacing) {
        int n;
        block9: {
            block10: {
                block8: {
                    int n2 = oc84f20a0bc5.\u0117;
                    if (enumFacing == EnumFacing.UP) break block8;
                    n = this.\u04a3;
                    if (n2 != 0) break block9;
                    if (n == 0) break block8;
                    float f = this.\u0117 - 18.0f;
                    n = f == 0.0f ? 0 : (f < 0.0f ? -1 : 1);
                    if (n2 != 0) break block9;
                    if (n > 0) break block10;
                }
                n = 1;
                break block9;
            }
            n = 0;
        }
        return n != 0;
    }

    synchronized float \u00e6(float f, float f2, float f3) {
        float f4;
        float f5;
        block32: {
            block31: {
                int n;
                block30: {
                    block29: {
                        float f6;
                        block27: {
                            block28: {
                                block25: {
                                    block26: {
                                        float f7;
                                        block33: {
                                            block24: {
                                                ocae1739aac7 ocae1739aac72;
                                                block23: {
                                                    n = oc84f20a0bc5.\u0117;
                                                    ocae1739aac72 = this;
                                                    if (n != 0) break block23;
                                                    if (!ocae1739aac72.\u04a3) break block24;
                                                    ocae1739aac72 = this;
                                                }
                                                f7 = ocae1739aac72.\u00d6;
                                                break block33;
                                            }
                                            f7 = f2;
                                        }
                                        f5 = f7;
                                        f6 = f5;
                                        if (n != 0) break block25;
                                        if (Float.isFinite(f6)) break block26;
                                        f5 = 0.0f;
                                    }
                                    f6 = f;
                                }
                                if (n != 0) break block27;
                                if (Float.isFinite(f6)) break block28;
                                return f5;
                            }
                            f4 = f;
                            if (n != 0) break block29;
                            f6 = Math.abs(f4 - f5);
                        }
                        if (f6 <= 17.5f) {
                            return f;
                        }
                        f4 = f3;
                    }
                    if (n != 0) break block30;
                    if (!Float.isFinite(f4)) break block31;
                    f4 = f3;
                }
                if (n != 0) break block32;
                if (!(f4 > 0.0f)) break block31;
                f4 = f3;
                break block32;
            }
            f4 = 0.15f;
        }
        float f8 = f4;
        float f9 = (float)Math.floor(17.5f / f8) * f8;
        return Math.max(-90.0f, Math.min(90.0f, f5 + Math.copySign(f9, f - f5)));
    }

    synchronized boolean \u0165(float f, float f2) {
        int n;
        block19: {
            block17: {
                float f3;
                int n2;
                block18: {
                    float f4;
                    block16: {
                        float f5;
                        block20: {
                            block15: {
                                ocae1739aac7 ocae1739aac72;
                                block14: {
                                    n2 = oc84f20a0bc5.\u0117;
                                    ocae1739aac72 = this;
                                    if (n2 != 0) break block14;
                                    if (!ocae1739aac72.\u04a3) break block15;
                                    ocae1739aac72 = this;
                                }
                                f5 = ocae1739aac72.\u00d6;
                                break block20;
                            }
                            f5 = f2;
                        }
                        f4 = f5;
                        f3 = f;
                        if (n2 != 0) break block16;
                        if (!Float.isFinite(f3)) break block17;
                        f3 = f4;
                    }
                    if (n2 != 0) break block18;
                    if (!Float.isFinite(f3)) break block17;
                    f3 = Math.abs(f - f4);
                }
                float f6 = f3 - 17.5f;
                n = f6 == 0.0f ? 0 : (f6 < 0.0f ? -1 : 1);
                if (n2 != 0) break block19;
                if (n > 0) break block17;
                n = 1;
                break block19;
            }
            n = 0;
        }
        return n != 0;
    }

    static boolean \u03b4(double d, float f) {
        int n;
        block18: {
            block15: {
                int n2;
                block17: {
                    double d2;
                    block16: {
                        block14: {
                            n2 = oc84f20a0bc5.\u0117;
                            d2 = d;
                            if (n2 != 0) break block14;
                            if (!Double.isFinite(d2)) break block15;
                            d2 = d;
                        }
                        if (n2 != 0) break block16;
                        if (!(d2 < 1.0)) break block15;
                        d2 = d;
                    }
                    n = Double.toString(d2).contains("E");
                    if (n2 != 0) break block17;
                    if (n == 0) break block15;
                    float f2 = f - 18.0f;
                    n = f2 == 0.0f ? 0 : (f2 > 0.0f ? 1 : -1);
                }
                if (n2 != 0) break block18;
                if (n <= 0) break block15;
                n = 1;
                break block18;
            }
            n = 0;
        }
        return n != 0;
    }
}

