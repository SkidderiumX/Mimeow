/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oc75d51ec7eb;

public class occfd144e27a {
    private Character \u041c;
    private boolean \u02a0;
    private boolean \u00fc;
    private boolean \u0564;
    private boolean \u0260;
    private boolean \u018c;

    private occfd144e27a() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void \u0523(char c) {
        char c2;
        int n;
        block27: {
            char c3;
            block28: {
                block26: {
                    block24: {
                        block25: {
                            c3 = Character.toLowerCase(c);
                            n = oc75d51ec7eb.\u03e9;
                            c2 = c3;
                            if (n != 0) break block24;
                            if (c2 < (0xA4FE4714 ^ 0xA4FE4724)) break block25;
                            c2 = c3;
                            if (n != 0) break block24;
                            if (c2 <= (0xA4FE471D ^ 0xA4FE4724)) break block26;
                        }
                        c2 = c3;
                    }
                    if (n != 0) break block27;
                    if (c2 < (0xA4FE4745 ^ 0xA4FE4724)) break block28;
                    c2 = c3;
                    if (n != 0) break block27;
                    if (c2 > (0xA4FE4742 ^ 0xA4FE4724)) break block28;
                }
                this.\u041c = Character.valueOf(c3);
                this.\u02a0 = false;
                this.\u00fc = false;
                this.\u0564 = false;
                this.\u0260 = false;
                this.\u018c = false;
                return;
            }
            c2 = c3;
        }
        switch (c2) {
            case 'k': {
                this.\u02a0 = true;
                if (n == 0) return;
            }
            case 'l': {
                this.\u00fc = true;
                if (n == 0) return;
            }
            case 'm': {
                this.\u0564 = true;
                if (n == 0) return;
            }
            case 'n': {
                this.\u0260 = true;
                if (n == 0) return;
            }
            case 'o': {
                this.\u018c = true;
                if (n == 0) return;
            }
            case 'r': {
                this.\u041c = null;
                this.\u02a0 = false;
                this.\u00fc = false;
                this.\u0564 = false;
                this.\u0260 = false;
                this.\u018c = false;
                return;
            }
        }
    }

    private String \u00d0() {
        occfd144e27a occfd144e27a2;
        StringBuilder stringBuilder;
        block31: {
            block32: {
                int n;
                block29: {
                    block30: {
                        block27: {
                            block28: {
                                block25: {
                                    block26: {
                                        block23: {
                                            block24: {
                                                stringBuilder = new StringBuilder();
                                                n = oc75d51ec7eb.\u03e9;
                                                occfd144e27a2 = this;
                                                if (n != 0) break block23;
                                                if (occfd144e27a2.\u041c == null) break block24;
                                                stringBuilder.append((char)(0xBE3B5BBB ^ 0xBE3B5B1C)).append(this.\u041c);
                                            }
                                            occfd144e27a2 = this;
                                        }
                                        if (n != 0) break block25;
                                        if (!occfd144e27a2.\u02a0) break block26;
                                        stringBuilder.append((char)(0xBE3B5BBB ^ 0xBE3B5B1C)).append((char)(0xBE3B5B77 ^ 0xBE3B5B1C));
                                    }
                                    occfd144e27a2 = this;
                                }
                                if (n != 0) break block27;
                                if (!occfd144e27a2.\u00fc) break block28;
                                stringBuilder.append((char)(0xBE3B5BBB ^ 0xBE3B5B1C)).append((char)(0xBE3B5B70 ^ 0xBE3B5B1C));
                            }
                            occfd144e27a2 = this;
                        }
                        if (n != 0) break block29;
                        if (!occfd144e27a2.\u0564) break block30;
                        stringBuilder.append((char)(0xBE3B5BBB ^ 0xBE3B5B1C)).append((char)(0xBE3B5B71 ^ 0xBE3B5B1C));
                    }
                    occfd144e27a2 = this;
                }
                if (n != 0) break block31;
                if (!occfd144e27a2.\u0260) break block32;
                stringBuilder.append((char)(0xBE3B5BBB ^ 0xBE3B5B1C)).append((char)(0xBE3B5B72 ^ 0xBE3B5B1C));
            }
            occfd144e27a2 = this;
        }
        if (occfd144e27a2.\u018c) {
            stringBuilder.append((char)(0xBE3B5BBB ^ 0xBE3B5B1C)).append((char)(0xBE3B5B73 ^ 0xBE3B5B1C));
        }
        return stringBuilder.toString();
    }
}

