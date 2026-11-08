/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.ArrayList;
import net.minecraft.client.Minecraft;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.scoreboard.Scoreboard;
import x.oc75d51ec7eb;

public class ocf6c2c4edcc {
    private static final Minecraft \u043f = Minecraft.getMinecraft();
    public static int \u0392;

    private ocf6c2c4edcc() {
    }

    public static ArrayList<String> \u03df() {
        ArrayList<String> arrayList;
        block16: {
            ScoreObjective scoreObjective;
            Scoreboard scoreboard;
            block17: {
                Scoreboard scoreboard2;
                int n;
                block14: {
                    block15: {
                        Minecraft minecraft;
                        block12: {
                            block13: {
                                arrayList = new ArrayList<String>();
                                n = oc75d51ec7eb.\u03e9;
                                minecraft = \u043f;
                                if (n != 0) break block12;
                                if (minecraft.theWorld != null) break block13;
                                return arrayList;
                            }
                            minecraft = \u043f;
                        }
                        scoreboard = minecraft.theWorld.getScoreboard();
                        scoreboard2 = scoreboard;
                        if (n != 0) break block14;
                        if (scoreboard2 != null) break block15;
                        return arrayList;
                    }
                    scoreboard2 = scoreboard;
                }
                scoreObjective = scoreboard2.getObjectiveInDisplaySlot(1);
                if (n != 0) break block16;
                if (scoreObjective != null) break block17;
                return arrayList;
            }
            scoreboard.getSortedScores(scoreObjective).forEach(score -> arrayList.add(ScorePlayerTeam.formatPlayerName(scoreboard.getPlayersTeam(score.getPlayerName()), score.getPlayerName())));
        }
        return arrayList;
    }

    public static boolean \u01b6() {
        int n;
        ArrayList<String> arrayList;
        block11: {
            Object object;
            ArrayList<String> arrayList2;
            block9: {
                int n2;
                block10: {
                    arrayList2 = ocf6c2c4edcc.\u03df();
                    n2 = oc75d51ec7eb.\u03e9;
                    object = arrayList2;
                    if (n2 != 0) break block9;
                    if (!((ArrayList)object).isEmpty()) break block10;
                    return false;
                }
                arrayList = arrayList2;
                n = 0;
                if (n2 != 0) break block11;
                object = arrayList.get(n);
            }
            if (((String)object).equals("\u00a7ewww.hypixel.ne\ud83c\udf82\u00a7et")) {
                return true;
            }
            arrayList = arrayList2;
            n = 0;
        }
        return arrayList.get(n).equals("\u00a7ewww.hypixel.ne\u00a7g\u00a7et");
    }
}

