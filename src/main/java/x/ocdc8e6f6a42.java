/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.scoreboard.ScorePlayerTeam;
import x.oc2cf3d80e17;
import x.oc75d51ec7eb;
import x.occ9ed06a81d;
import x.ocf6c2c4edcc;

public class ocdc8e6f6a42 {
    private static final Minecraft \u04e0 = Minecraft.getMinecraft();
    public static int \u0298;

    private ocdc8e6f6a42() {
    }

    public static Color \u0207(EntityPlayer entityPlayer, float f) {
        int n;
        block7: {
            int n2;
            block8: {
                ScorePlayerTeam scorePlayerTeam;
                int n3;
                block6: {
                    n = 0xFF2AC761 ^ 0xFFD5389E;
                    ScorePlayerTeam scorePlayerTeam2 = (ScorePlayerTeam)entityPlayer.getTeam();
                    n3 = oc75d51ec7eb.\u03e9;
                    scorePlayerTeam = scorePlayerTeam2;
                    if (n3 != 0) break block6;
                    if (scorePlayerTeam == null) break block7;
                    scorePlayerTeam = scorePlayerTeam2;
                }
                String string = FontRenderer.getFormatFromString(scorePlayerTeam.getColorPrefix());
                n2 = string.length();
                if (n3 != 0) break block8;
                if (n2 < (0xFFD5389C ^ 0xFFD5389E)) break block7;
                n2 = ocdc8e6f6a42.\u04e0.fontRendererObj.getColorCode(string.charAt(1));
            }
            n = n2;
        }
        return new Color(n & (0xFF2AC761 ^ 0xFFD5389E) | (int)(f * 255.0f) << (0xFFD53886 ^ 0xFFD5389E), true);
    }

    public static boolean \u0289(EntityPlayer entityPlayer) {
        String string;
        block34: {
            ScorePlayerTeam scorePlayerTeam;
            block35: {
                ScorePlayerTeam scorePlayerTeam2;
                int n;
                block32: {
                    block33: {
                        NetworkPlayerInfo networkPlayerInfo;
                        block31: {
                            int n2;
                            NetworkPlayerInfo networkPlayerInfo2;
                            block29: {
                                block30: {
                                    block27: {
                                        block28: {
                                            n = oc75d51ec7eb.\u03e9;
                                            if (entityPlayer == ocdc8e6f6a42.\u04e0.thePlayer) {
                                                return false;
                                            }
                                            networkPlayerInfo2 = \u04e0.getNetHandler().getPlayerInfo(entityPlayer.getName());
                                            if (networkPlayerInfo2 == null) {
                                                return true;
                                            }
                                            n2 = ocf6c2c4edcc.\u01b6();
                                            if (n != 0) break block27;
                                            if (n2 != 0) break block28;
                                            return false;
                                        }
                                        n2 = entityPlayer.getName().startsWith("\u00a7k");
                                    }
                                    if (n != 0) break block29;
                                    if (n2 == 0) break block30;
                                    return entityPlayer.isInvisible();
                                }
                                networkPlayerInfo = networkPlayerInfo2;
                                if (n != 0) break block31;
                                n2 = networkPlayerInfo.getResponseTime();
                            }
                            if (n2 < 1) {
                                return true;
                            }
                            networkPlayerInfo = networkPlayerInfo2;
                        }
                        scorePlayerTeam = networkPlayerInfo.getPlayerTeam();
                        scorePlayerTeam2 = scorePlayerTeam;
                        if (n != 0) break block32;
                        if (scorePlayerTeam2 != null) break block33;
                        return false;
                    }
                    scorePlayerTeam2 = scorePlayerTeam;
                }
                string = scorePlayerTeam2.getTeamName();
                if (n != 0) break block34;
                if (string.isEmpty()) break block35;
                return false;
            }
            string = scorePlayerTeam.getColorPrefix();
        }
        return string.equals("\u00a7c");
    }

    public static boolean \u0118(EntityPlayer entityPlayer) {
        ScorePlayerTeam scorePlayerTeam;
        ScorePlayerTeam scorePlayerTeam2;
        block22: {
            ScorePlayerTeam scorePlayerTeam3;
            block23: {
                NetworkPlayerInfo networkPlayerInfo;
                int n;
                block20: {
                    NetworkPlayerInfo networkPlayerInfo2;
                    block21: {
                        NetworkPlayerInfo networkPlayerInfo3;
                        block18: {
                            NetworkPlayerInfo networkPlayerInfo4;
                            block19: {
                                n = oc75d51ec7eb.\u03e9;
                                if (entityPlayer == ocdc8e6f6a42.\u04e0.thePlayer) {
                                    return true;
                                }
                                networkPlayerInfo4 = \u04e0.getNetHandler().getPlayerInfo(ocdc8e6f6a42.\u04e0.thePlayer.getUniqueID());
                                networkPlayerInfo3 = networkPlayerInfo4;
                                if (n != 0) break block18;
                                if (networkPlayerInfo3 != null) break block19;
                                return false;
                            }
                            networkPlayerInfo3 = networkPlayerInfo4;
                        }
                        scorePlayerTeam3 = networkPlayerInfo3.getPlayerTeam();
                        if (scorePlayerTeam3 == null) {
                            return false;
                        }
                        networkPlayerInfo2 = \u04e0.getNetHandler().getPlayerInfo(entityPlayer.getUniqueID());
                        networkPlayerInfo = networkPlayerInfo2;
                        if (n != 0) break block20;
                        if (networkPlayerInfo != null) break block21;
                        return false;
                    }
                    networkPlayerInfo = networkPlayerInfo2;
                }
                scorePlayerTeam2 = networkPlayerInfo.getPlayerTeam();
                scorePlayerTeam = scorePlayerTeam2;
                if (n != 0) break block22;
                if (scorePlayerTeam != null) break block23;
                return false;
            }
            scorePlayerTeam = scorePlayerTeam3;
        }
        return scorePlayerTeam.getColorPrefix().equals(scorePlayerTeam2.getColorPrefix());
    }

    public static boolean \u047a(EntityPlayer entityPlayer) {
        boolean bl;
        block6: {
            block5: {
                occ9ed06a81d occ9ed06a81d2;
                int n;
                block4: {
                    n = oc75d51ec7eb.\u03e9;
                    occ9ed06a81d2 = oc2cf3d80e17.\u022c;
                    if (n != 0) break block4;
                    if (occ9ed06a81d2 == null) break block5;
                    occ9ed06a81d2 = oc2cf3d80e17.\u022c;
                }
                bl = occ9ed06a81d2.\u03e6(entityPlayer.getName());
                if (n != 0) break block6;
                if (!bl) break block5;
                bl = true;
                break block6;
            }
            bl = false;
        }
        return bl;
    }
}

