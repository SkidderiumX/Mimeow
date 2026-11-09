/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiPlayerTabOverlay;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import x.oc19a24d59db;
import x.oc5fe36d3bb5;
import x.ocbf5a535fb8;
import x.occ0b63c0426;
import x.ocd3fd3d417e;
import x.ocfa806a7613;

public class oc8cac2f2134 {
    private final Minecraft \u0142 = Minecraft.getMinecraft();
    public static boolean p;

    public boolean \u03b4() {
        return this.\u0233();
    }

    public oc19a24d59db \u0235(ocbf5a535fb8 ocbf5a535fb82) {
        oc19a24d59db oc19a24d59db2 = ocbf5a535fb82 == null ? null : this.\u03f2((int)Math.floor(ocbf5a535fb82.\u03ba), (int)Math.floor(ocbf5a535fb82.\u0418), (int)Math.floor(ocbf5a535fb82.\u03e0));
        return oc19a24d59db2;
    }

    public oc19a24d59db \u03f2(int n, int n2, int n3) {
        oc19a24d59db oc19a24d59db2 = this.\u0142.theWorld == null ? null : new oc19a24d59db(this.\u0142.theWorld.getBlockState(new BlockPos(n, n2, n3)), new BlockPos(n, n2, n3));
        return oc19a24d59db2;
    }

    public oc19a24d59db Z(int n, int n2, int n3) {
        return this.\u03f2(n, n2, n3);
    }

    public oc19a24d59db \u0275(double d, double d2, double d3) {
        return this.\u03f2((int)Math.floor(d), (int)Math.floor(d2), (int)Math.floor(d3));
    }

    public long \u03bd() {
        long l;
        block6: {
            oc8cac2f2134 oc8cac2f21342;
            block4: {
                block5: {
                    int n = occ0b63c0426.\u039f;
                    oc8cac2f21342 = this;
                    if (n != 0) break block4;
                    if (oc8cac2f21342.\u0142.theWorld != null) break block5;
                    l = 0L;
                    break block6;
                }
                oc8cac2f21342 = this;
            }
            l = oc8cac2f21342.\u0142.theWorld.getWorldTime();
        }
        return l;
    }

    public long \u01af() {
        long l;
        block6: {
            Minecraft minecraft;
            block4: {
                block5: {
                    int n = occ0b63c0426.\u039f;
                    minecraft = this.\u0142;
                    if (n != 0) break block4;
                    if (minecraft.theWorld != null) break block5;
                    l = 0L;
                    break block6;
                }
                minecraft = this.\u0142;
            }
            l = minecraft.theWorld.getTotalWorldTime();
        }
        return l;
    }

    public boolean \u0233() {
        boolean bl = this.\u0142.theWorld != null;
        return bl;
    }

    public List<oc5fe36d3bb5> \u0500() {
        ArrayList<oc5fe36d3bb5> arrayList;
        block10: {
            ArrayList<oc5fe36d3bb5> arrayList2;
            block9: {
                oc8cac2f2134 oc8cac2f21342;
                int n;
                block8: {
                    arrayList2 = new ArrayList<oc5fe36d3bb5>();
                    n = occ0b63c0426.\u039f;
                    oc8cac2f21342 = this;
                    if (n != 0) break block8;
                    if (oc8cac2f21342.\u0142.theWorld == null) break block9;
                    oc8cac2f21342 = this;
                }
                for (Entity entity : oc8cac2f21342.\u0142.theWorld.loadedEntityList) {
                    arrayList = arrayList2;
                    if (n == 0) {
                        arrayList.add(oc5fe36d3bb5.\u0277(entity));
                        if (n == 0) continue;
                        break;
                    }
                    break block10;
                }
            }
            arrayList = arrayList2;
        }
        return arrayList;
    }

    public List<oc5fe36d3bb5> \u04a9() {
        ArrayList<oc5fe36d3bb5> arrayList;
        block10: {
            ArrayList<oc5fe36d3bb5> arrayList2;
            block9: {
                oc8cac2f2134 oc8cac2f21342;
                int n;
                block8: {
                    arrayList2 = new ArrayList<oc5fe36d3bb5>();
                    n = occ0b63c0426.\u039f;
                    oc8cac2f21342 = this;
                    if (n != 0) break block8;
                    if (oc8cac2f21342.\u0142.theWorld == null) break block9;
                    oc8cac2f21342 = this;
                }
                for (EntityPlayer entityPlayer : oc8cac2f21342.\u0142.theWorld.playerEntities) {
                    arrayList = arrayList2;
                    if (n == 0) {
                        arrayList.add(oc5fe36d3bb5.\u0277(entityPlayer));
                        if (n == 0) continue;
                        break;
                    }
                    break block10;
                }
            }
            arrayList = arrayList2;
        }
        return arrayList;
    }

    public oc5fe36d3bb5 \u00ba(int n) {
        oc5fe36d3bb5 oc5fe36d3bb52;
        block6: {
            oc8cac2f2134 oc8cac2f21342;
            block4: {
                block5: {
                    int n2 = occ0b63c0426.\u039f;
                    oc8cac2f21342 = this;
                    if (n2 != 0) break block4;
                    if (oc8cac2f21342.\u0142.theWorld != null) break block5;
                    oc5fe36d3bb52 = null;
                    break block6;
                }
                oc8cac2f21342 = this;
            }
            oc5fe36d3bb52 = oc5fe36d3bb5.\u0277(oc8cac2f21342.\u0142.theWorld.getEntityByID(n));
        }
        return oc5fe36d3bb52;
    }

    public oc5fe36d3bb5 \u04d6(int n) {
        return this.\u00ba(n);
    }

    public oc5fe36d3bb5 \u0480(String string) {
        int n;
        block9: {
            n = occ0b63c0426.\u039f;
            if (this.\u0142.theWorld != null && string != null) break block9;
            return null;
        }
        for (EntityPlayer entityPlayer : this.\u0142.theWorld.playerEntities) {
            block10: {
                if (entityPlayer == null || !string.equalsIgnoreCase(entityPlayer.getName())) break block10;
                return oc5fe36d3bb5.\u0277(entityPlayer);
            }
            if (n == 0) continue;
        }
        return null;
    }

    public List<ocd3fd3d417e> \u0240() {
        ArrayList<ocd3fd3d417e> arrayList;
        block9: {
            oc8cac2f2134 oc8cac2f21342;
            int n;
            block8: {
                arrayList = new ArrayList<ocd3fd3d417e>();
                n = occ0b63c0426.\u039f;
                oc8cac2f21342 = this;
                if (n != 0) break block8;
                if (oc8cac2f21342.\u0142.getNetHandler() == null) break block9;
                oc8cac2f21342 = this;
            }
            for (NetworkPlayerInfo networkPlayerInfo : oc8cac2f21342.\u0142.getNetHandler().getPlayerInfoMap()) {
                ocd3fd3d417e ocd3fd3d417e2 = ocd3fd3d417e.\u056d(networkPlayerInfo);
                if (ocd3fd3d417e2 != null) {
                    arrayList.add(ocd3fd3d417e2);
                }
                if (n == 0) continue;
            }
        }
        return arrayList;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public List<String> \u040f() {
        ArrayList<String> arrayList;
        WorldClient worldClient;
        int n;
        ArrayList<String> arrayList2;
        block12: {
            block13: {
                oc8cac2f2134 oc8cac2f21342;
                block11: {
                    arrayList2 = new ArrayList<String>();
                    n = occ0b63c0426.\u039f;
                    oc8cac2f21342 = this;
                    if (n != 0) break block11;
                    if (oc8cac2f21342.\u0142.theWorld == null) return arrayList2;
                    oc8cac2f21342 = this;
                }
                worldClient = oc8cac2f21342.\u0142.theWorld;
                if (n != 0) break block12;
                if (worldClient.getScoreboard() != null) break block13;
                return arrayList2;
            }
            worldClient = this.\u0142.theWorld;
        }
        for (Score score : worldClient.getScoreboard().getScores()) {
            arrayList = arrayList2;
            if (n != 0) return arrayList;
            arrayList.add(score.getPlayerName() + ": " + score.getScorePoints());
            if (n == 0) continue;
            break;
        }
        arrayList = arrayList2;
        return arrayList;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public String \u0491() {
        GuiPlayerTabOverlay guiPlayerTabOverlay;
        block14: {
            GuiPlayerTabOverlay guiPlayerTabOverlay2;
            block15: {
                int n;
                block13: {
                    GuiPlayerTabOverlay guiPlayerTabOverlay3;
                    block12: {
                        oc8cac2f2134 oc8cac2f21342;
                        block10: {
                            block11: {
                                n = occ0b63c0426.\u039f;
                                oc8cac2f21342 = this;
                                if (n != 0) break block10;
                                if (oc8cac2f21342.\u0142.ingameGUI != null) break block11;
                                guiPlayerTabOverlay3 = null;
                                break block12;
                            }
                            oc8cac2f21342 = this;
                        }
                        guiPlayerTabOverlay3 = oc8cac2f21342.\u0142.ingameGUI.getTabList();
                    }
                    guiPlayerTabOverlay2 = guiPlayerTabOverlay3;
                    guiPlayerTabOverlay = guiPlayerTabOverlay2;
                    if (n != 0) break block13;
                    if (guiPlayerTabOverlay == null) return "";
                    guiPlayerTabOverlay = guiPlayerTabOverlay2;
                }
                if (n != 0) break block14;
                if (guiPlayerTabOverlay.getHeader() != null) break block15;
                return "";
            }
            guiPlayerTabOverlay = guiPlayerTabOverlay2;
        }
        String string = guiPlayerTabOverlay.getHeader().getUnformattedText();
        return string;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public String \u03ae() {
        GuiPlayerTabOverlay guiPlayerTabOverlay;
        block14: {
            GuiPlayerTabOverlay guiPlayerTabOverlay2;
            block15: {
                int n;
                block13: {
                    GuiPlayerTabOverlay guiPlayerTabOverlay3;
                    block12: {
                        oc8cac2f2134 oc8cac2f21342;
                        block10: {
                            block11: {
                                n = occ0b63c0426.\u039f;
                                oc8cac2f21342 = this;
                                if (n != 0) break block10;
                                if (oc8cac2f21342.\u0142.ingameGUI != null) break block11;
                                guiPlayerTabOverlay3 = null;
                                break block12;
                            }
                            oc8cac2f21342 = this;
                        }
                        guiPlayerTabOverlay3 = oc8cac2f21342.\u0142.ingameGUI.getTabList();
                    }
                    guiPlayerTabOverlay2 = guiPlayerTabOverlay3;
                    guiPlayerTabOverlay = guiPlayerTabOverlay2;
                    if (n != 0) break block13;
                    if (guiPlayerTabOverlay == null) return "";
                    guiPlayerTabOverlay = guiPlayerTabOverlay2;
                }
                if (n != 0) break block14;
                if (guiPlayerTabOverlay.getFooter() != null) break block15;
                return "";
            }
            guiPlayerTabOverlay = guiPlayerTabOverlay2;
        }
        String string = guiPlayerTabOverlay.getFooter().getUnformattedText();
        return string;
    }

    public boolean \u013e(oc5fe36d3bb5 oc5fe36d3bb52) {
        boolean bl;
        block6: {
            block5: {
                oc5fe36d3bb5 oc5fe36d3bb53;
                int n;
                block4: {
                    n = occ0b63c0426.\u039f;
                    oc5fe36d3bb53 = oc5fe36d3bb52;
                    if (n != 0) break block4;
                    if (oc5fe36d3bb53 == null) break block5;
                    oc5fe36d3bb53 = oc5fe36d3bb52;
                }
                bl = oc5fe36d3bb53.\u051b();
                if (n != 0) break block6;
                if (!bl) break block5;
                bl = true;
                break block6;
            }
            bl = false;
        }
        return bl;
    }

    public oc5fe36d3bb5 \u03b0(String string, double d, double d2, double d3) {
        return null;
    }

    public oc5fe36d3bb5 \u0467(String string, ocbf5a535fb8 ocbf5a535fb82) {
        oc5fe36d3bb5 oc5fe36d3bb52 = ocbf5a535fb82 == null ? null : this.\u03b0(string, ocbf5a535fb82.\u03ba, ocbf5a535fb82.\u0418, ocbf5a535fb82.\u03e0);
        return oc5fe36d3bb52;
    }

    public boolean \u0544(oc5fe36d3bb5 oc5fe36d3bb52) {
        return false;
    }

    public void \u03d2() {
    }

    public void \u01ed(String string, float f, float f2, double d, double d2, double d3) {
        block4: {
            if (this.\u0142.theWorld == null || string == null) break block4;
            this.\u0142.theWorld.playSound(d, d2, d3, string, f, f2, false);
        }
    }

    public String \u0282() {
        String string;
        block6: {
            oc8cac2f2134 oc8cac2f21342;
            block4: {
                block5: {
                    int n = occ0b63c0426.\u039f;
                    oc8cac2f21342 = this;
                    if (n != 0) break block4;
                    if (oc8cac2f21342.\u0142.ingameGUI != null) break block5;
                    string = "";
                    break block6;
                }
                oc8cac2f21342 = this;
            }
            string = oc8cac2f21342.\u0142.ingameGUI.getDisplayedTitle();
        }
        return string;
    }

    public void \u00d2(String string, String string2, int n, int n2, int n3) {
        block5: {
            oc8cac2f2134 oc8cac2f21342;
            block4: {
                int n4 = occ0b63c0426.\u039f;
                oc8cac2f21342 = this;
                if (n4 != 0) break block4;
                if (oc8cac2f21342.\u0142.ingameGUI == null) break block5;
                oc8cac2f21342 = this;
            }
            oc8cac2f21342.\u0142.ingameGUI.displayTitle(string, string2, n, n2, n3);
        }
    }

    public void \u0395() {
        block5: {
            Minecraft minecraft;
            block4: {
                int n = occ0b63c0426.\u039f;
                minecraft = this.\u0142;
                if (n != 0) break block4;
                if (minecraft.ingameGUI == null) break block5;
                minecraft = this.\u0142;
            }
            minecraft.ingameGUI.displayTitle(null, null, -1, -1, -1);
        }
    }

    public List<ocfa806a7613> \u0229() {
        ArrayList<ocfa806a7613> arrayList;
        block10: {
            ArrayList<ocfa806a7613> arrayList2;
            block9: {
                Minecraft minecraft;
                int n;
                block8: {
                    arrayList2 = new ArrayList<ocfa806a7613>();
                    n = occ0b63c0426.\u039f;
                    minecraft = this.\u0142;
                    if (n != 0) break block8;
                    if (minecraft.theWorld == null) break block9;
                    minecraft = this.\u0142;
                }
                for (TileEntity tileEntity : minecraft.theWorld.loadedTileEntityList) {
                    arrayList = arrayList2;
                    if (n == 0) {
                        arrayList.add(new ocfa806a7613(tileEntity));
                        if (n == 0) continue;
                        break;
                    }
                    break block10;
                }
            }
            arrayList = arrayList2;
        }
        return arrayList;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public Map<String, List<String>> \u00df() {
        LinkedHashMap<String, List<String>> linkedHashMap;
        WorldClient worldClient;
        int n;
        LinkedHashMap<String, List<String>> linkedHashMap2;
        block12: {
            block13: {
                oc8cac2f2134 oc8cac2f21342;
                block11: {
                    linkedHashMap2 = new LinkedHashMap<String, List<String>>();
                    n = occ0b63c0426.\u039f;
                    oc8cac2f21342 = this;
                    if (n != 0) break block11;
                    if (oc8cac2f21342.\u0142.theWorld == null) return linkedHashMap2;
                    oc8cac2f21342 = this;
                }
                worldClient = oc8cac2f21342.\u0142.theWorld;
                if (n != 0) break block12;
                if (worldClient.getScoreboard() != null) break block13;
                return linkedHashMap2;
            }
            worldClient = this.\u0142.theWorld;
        }
        for (ScorePlayerTeam scorePlayerTeam : worldClient.getScoreboard().getTeams()) {
            linkedHashMap = linkedHashMap2;
            if (n != 0) return linkedHashMap;
            linkedHashMap.put(scorePlayerTeam.getRegisteredName(), new ArrayList<String>(scorePlayerTeam.getMembershipCollection()));
            if (n == 0) continue;
            break;
        }
        linkedHashMap = linkedHashMap2;
        return linkedHashMap;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public String \u0439() {
        WorldClient worldClient;
        block9: {
            block10: {
                oc8cac2f2134 oc8cac2f21342;
                int n;
                block8: {
                    n = occ0b63c0426.\u039f;
                    oc8cac2f21342 = this;
                    if (n != 0) break block8;
                    if (oc8cac2f21342.\u0142.theWorld == null) return "";
                    oc8cac2f21342 = this;
                }
                worldClient = oc8cac2f21342.\u0142.theWorld;
                if (n != 0) break block9;
                if (worldClient.provider != null) break block10;
                return "";
            }
            worldClient = this.\u0142.theWorld;
        }
        String string = worldClient.provider.getDimensionName();
        return string;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public int \u0240Int() {
        WorldClient worldClient;
        block9: {
            block10: {
                oc8cac2f2134 oc8cac2f21342;
                int n;
                block8: {
                    n = occ0b63c0426.\u039f;
                    oc8cac2f21342 = this;
                    if (n != 0) break block8;
                    if (oc8cac2f21342.\u0142.theWorld == null) return 0;
                    oc8cac2f21342 = this;
                }
                worldClient = oc8cac2f21342.\u0142.theWorld;
                if (n != 0) break block9;
                if (worldClient.provider != null) break block10;
                return 0;
            }
            worldClient = this.\u0142.theWorld;
        }
        int n = worldClient.provider.getDimensionId();
        return n;
    }
}

