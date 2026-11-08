/*
 * Decompiled with CFR 0.152.
 */
package x;

import com.mojang.authlib.GameProfile;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.util.IChatComponent;
import x.occ0b63c0426;

public class ocd3fd3d417e {
    private final NetworkPlayerInfo \u037c;
    public static boolean \u04b0;

    public ocd3fd3d417e(NetworkPlayerInfo networkPlayerInfo) {
        this.\u037c = networkPlayerInfo;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public String \u019d() {
        NetworkPlayerInfo networkPlayerInfo;
        block9: {
            ocd3fd3d417e ocd3fd3d417e2;
            int n;
            block8: {
                n = occ0b63c0426.\u039f;
                ocd3fd3d417e2 = this;
                if (n != 0) break block8;
                if (ocd3fd3d417e2.\u037c == null) return null;
                ocd3fd3d417e2 = this;
            }
            networkPlayerInfo = ocd3fd3d417e2.\u037c;
            if (n != 0) return networkPlayerInfo.getLocationCape().toString();
            if (networkPlayerInfo.getLocationCape() != null) break block9;
            return null;
        }
        networkPlayerInfo = this.\u037c;
        return networkPlayerInfo.getLocationCape().toString();
    }

    public String \u042c() {
        String string;
        block12: {
            IChatComponent iChatComponent;
            block10: {
                IChatComponent iChatComponent2;
                block11: {
                    ocd3fd3d417e ocd3fd3d417e2;
                    int n;
                    block8: {
                        block9: {
                            n = occ0b63c0426.\u039f;
                            ocd3fd3d417e2 = this;
                            if (n != 0) break block8;
                            if (ocd3fd3d417e2.\u037c != null) break block9;
                            return "";
                        }
                        ocd3fd3d417e2 = this;
                    }
                    iChatComponent2 = ocd3fd3d417e2.\u037c.getDisplayName();
                    iChatComponent = iChatComponent2;
                    if (n != 0) break block10;
                    if (iChatComponent != null) break block11;
                    string = this.\u02ae();
                    break block12;
                }
                iChatComponent = iChatComponent2;
            }
            string = iChatComponent.getUnformattedText();
        }
        return string;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public String \u02ae() {
        NetworkPlayerInfo networkPlayerInfo;
        block9: {
            block10: {
                ocd3fd3d417e ocd3fd3d417e2;
                int n;
                block8: {
                    n = occ0b63c0426.\u039f;
                    ocd3fd3d417e2 = this;
                    if (n != 0) break block8;
                    if (ocd3fd3d417e2.\u037c == null) return null;
                    ocd3fd3d417e2 = this;
                }
                networkPlayerInfo = ocd3fd3d417e2.\u037c;
                if (n != 0) break block9;
                if (networkPlayerInfo.getGameProfile() != null) break block10;
                return null;
            }
            networkPlayerInfo = this.\u037c;
        }
        String string = networkPlayerInfo.getGameProfile().getName();
        return string;
    }

    public int \u00c1() {
        int n;
        block6: {
            ocd3fd3d417e ocd3fd3d417e2;
            block4: {
                block5: {
                    int n2 = occ0b63c0426.\u039f;
                    ocd3fd3d417e2 = this;
                    if (n2 != 0) break block4;
                    if (ocd3fd3d417e2.\u037c != null) break block5;
                    n = 0;
                    break block6;
                }
                ocd3fd3d417e2 = this;
            }
            n = ocd3fd3d417e2.\u037c.getResponseTime();
        }
        return n;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public String \u01bf() {
        ocd3fd3d417e ocd3fd3d417e2;
        block9: {
            int n;
            block8: {
                n = occ0b63c0426.\u039f;
                ocd3fd3d417e2 = this;
                if (n != 0) break block8;
                if (ocd3fd3d417e2.\u037c == null) return null;
                ocd3fd3d417e2 = this;
            }
            if (n != 0) return ocd3fd3d417e2.\u037c.getLocationSkin().toString();
            if (ocd3fd3d417e2.\u037c.getLocationSkin() != null) break block9;
            return null;
        }
        ocd3fd3d417e2 = this;
        return ocd3fd3d417e2.\u037c.getLocationSkin().toString();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public String \u0504() {
        GameProfile gameProfile;
        block14: {
            block15: {
                NetworkPlayerInfo networkPlayerInfo;
                int n;
                block13: {
                    ocd3fd3d417e ocd3fd3d417e2;
                    block12: {
                        n = occ0b63c0426.\u039f;
                        ocd3fd3d417e2 = this;
                        if (n != 0) break block12;
                        if (ocd3fd3d417e2.\u037c == null) return null;
                        ocd3fd3d417e2 = this;
                    }
                    networkPlayerInfo = ocd3fd3d417e2.\u037c;
                    if (n != 0) break block13;
                    if (networkPlayerInfo.getGameProfile() == null) return null;
                    networkPlayerInfo = this.\u037c;
                }
                gameProfile = networkPlayerInfo.getGameProfile();
                if (n != 0) break block14;
                if (gameProfile.getId() != null) break block15;
                return null;
            }
            gameProfile = this.\u037c.getGameProfile();
        }
        String string = gameProfile.getId().toString();
        return string;
    }

    public static ocd3fd3d417e \u056d(NetworkPlayerInfo networkPlayerInfo) {
        ocd3fd3d417e ocd3fd3d417e2 = networkPlayerInfo == null ? null : new ocd3fd3d417e(networkPlayerInfo);
        return ocd3fd3d417e2;
    }

    public static void \u0505() {
    }
}

