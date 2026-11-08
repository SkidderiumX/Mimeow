/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui;

import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;
import com.mojang.authlib.GameProfile;
import java.util.Comparator;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EnumPlayerModelParts;
import net.minecraft.scoreboard.IScoreObjectiveCriteria;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MathHelper;
import net.minecraft.world.WorldSettings;
import x.oc45aa3f2e74;
import x.oc9755810e45;
import x.oc9e2e8d26de;
import x.ocb8f315ebeb;
import x.occ52191e479;
import x.oced29a282d7;

public class GuiPlayerTabOverlay
extends Gui
implements ocb8f315ebeb {
    private static final Ordering<NetworkPlayerInfo> field_175252_a = Ordering.from(new PlayerComparator());
    private final Minecraft mc;
    private final GuiIngame guiIngame;
    private IChatComponent footer;
    private IChatComponent header;
    private long lastTimeOpened;
    private boolean isBeingRendered;

    public GuiPlayerTabOverlay(Minecraft minecraft, GuiIngame guiIngame) {
        this.mc = minecraft;
        this.guiIngame = guiIngame;
    }

    public String getPlayerName(NetworkPlayerInfo networkPlayerInfo) {
        String string = networkPlayerInfo.getDisplayName() != null ? networkPlayerInfo.getDisplayName().getFormattedText() : ScorePlayerTeam.formatPlayerName(networkPlayerInfo.getPlayerTeam(), networkPlayerInfo.getGameProfile().getName());
        String string2 = string;
        occ52191e479<String> occ52191e4792 = new occ52191e479<String>("getPlayerName", true, string);
        this.mimeow$nameHider$hideTabName(networkPlayerInfo, occ52191e4792);
        return occ52191e4792.z$24lpjeeur71n9() ? occ52191e4792.\u040d() : string2;
    }

    public void updatePlayerList(boolean bl) {
        if (bl && !this.isBeingRendered) {
            this.lastTimeOpened = Minecraft.getSystemTime();
        }
        this.isBeingRendered = bl;
    }

    public void renderPlayerlist(int n, Scoreboard scoreboard, ScoreObjective scoreObjective) {
        int n2;
        boolean bl;
        int n3;
        int n4;
        NetHandlerPlayClient netHandlerPlayClient = this.mc.thePlayer.sendQueue;
        List<NetworkPlayerInfo> list = field_175252_a.sortedCopy(netHandlerPlayClient.getPlayerInfoMap());
        int n5 = 0;
        int n6 = 0;
        for (NetworkPlayerInfo networkPlayerInfo : list) {
            n4 = this.mc.fontRendererObj.getStringWidth(this.getPlayerName(networkPlayerInfo));
            if (oc9e2e8d26de.\u04b0(networkPlayerInfo.getGameProfile().getId(), networkPlayerInfo.getGameProfile().getName())) {
                n4 += oc45aa3f2e74.\u041e(8);
            }
            n5 = Math.max(n5, n4);
            if (scoreObjective == null || scoreObjective.getRenderType() == IScoreObjectiveCriteria.EnumRenderType.HEARTS) continue;
            n4 = this.mc.fontRendererObj.getStringWidth(" " + scoreboard.getValueFromObjective(networkPlayerInfo.getGameProfile().getName(), scoreObjective).getScorePoints());
            n6 = Math.max(n6, n4);
        }
        list = list.subList(0, Math.min(list.size(), 80));
        int n7 = n3 = list.size();
        n4 = 1;
        while (n7 > 20) {
            n7 = (n3 + ++n4 - 1) / n4;
        }
        boolean bl2 = bl = this.mc.isIntegratedServerRunning() || this.mc.getNetHandler().getNetworkManager().getIsencrypted();
        int n8 = scoreObjective != null ? (scoreObjective.getRenderType() == IScoreObjectiveCriteria.EnumRenderType.HEARTS ? 90 : n6) : 0;
        int n9 = Math.min(n4 * ((bl ? 9 : 0) + n5 + n8 + 13), n - 50) / n4;
        int n10 = n / 2 - (n9 * n4 + (n4 - 1) * 5) / 2;
        int n11 = 10;
        int n12 = n9 * n4 + (n4 - 1) * 5;
        List<String> list2 = null;
        List<String> list3 = null;
        if (this.header != null) {
            list2 = this.mc.fontRendererObj.listFormattedStringToWidth(this.header.getFormattedText(), n - 50);
            for (String string : list2) {
                n12 = Math.max(n12, this.mc.fontRendererObj.getStringWidth(string));
            }
        }
        if (this.footer != null) {
            list3 = this.mc.fontRendererObj.listFormattedStringToWidth(this.footer.getFormattedText(), n - 50);
            for (String string : list3) {
                n12 = Math.max(n12, this.mc.fontRendererObj.getStringWidth(string));
            }
        }
        if (list2 != null) {
            GuiPlayerTabOverlay.drawRect(n / 2 - n12 / 2 - 1, n11 - 1, n / 2 + n12 / 2 + 1, n11 + list2.size() * this.mc.fontRendererObj.FONT_HEIGHT, Integer.MIN_VALUE);
            for (String string : list2) {
                n2 = this.mc.fontRendererObj.getStringWidth(string);
                this.mc.fontRendererObj.drawStringWithShadow(string, n / 2 - n2 / 2, n11, -1);
                n11 += this.mc.fontRendererObj.FONT_HEIGHT;
            }
            ++n11;
        }
        GuiPlayerTabOverlay.drawRect(n / 2 - n12 / 2 - 1, n11 - 1, n / 2 + n12 / 2 + 1, n11 + n7 * 9, Integer.MIN_VALUE);
        for (int i = 0; i < n3; ++i) {
            int n13;
            int n14;
            int n15 = i / n7;
            n2 = i % n7;
            int n16 = n10 + n15 * n9 + n15 * 5;
            int n17 = n11 + n2 * 9;
            GuiPlayerTabOverlay.drawRect(n16, n17, n16 + n9, n17 + 8, 0x20FFFFFF);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.enableAlpha();
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
            if (i >= list.size()) continue;
            NetworkPlayerInfo networkPlayerInfo = list.get(i);
            Object object = this.getPlayerName(networkPlayerInfo);
            GameProfile gameProfile = networkPlayerInfo.getGameProfile();
            if (bl) {
                EntityPlayer entityPlayer = this.mc.theWorld.getPlayerEntityByUUID(gameProfile.getId());
                n14 = entityPlayer != null && entityPlayer.isWearing(EnumPlayerModelParts.CAPE) && (gameProfile.getName().equals("Dinnerbone") || gameProfile.getName().equals("Grumm")) ? 1 : 0;
                this.mc.getTextureManager().bindTexture(networkPlayerInfo.getLocationSkin());
                n13 = 8 + (n14 != 0 ? 8 : 0);
                int n18 = 8 * (n14 != 0 ? -1 : 1);
                Gui.drawScaledCustomSizeModalRect(n16, n17, 8.0f, n13, 8, n18, 8, 8, 64.0f, 64.0f);
                if (entityPlayer != null && entityPlayer.isWearing(EnumPlayerModelParts.HAT)) {
                    int n19 = 8 + (n14 != 0 ? 8 : 0);
                    int n20 = 8 * (n14 != 0 ? -1 : 1);
                    Gui.drawScaledCustomSizeModalRect(n16, n17, 40.0f, n19, 8, n20, 8, 8, 64.0f, 64.0f);
                }
                n16 += 9;
            }
            int n21 = n16;
            if (oc9e2e8d26de.\u04b0(gameProfile.getId(), gameProfile.getName())) {
                oc45aa3f2e74.\u03f8(n16, n17, 8, -1);
                n21 += oc45aa3f2e74.\u041e(8);
            }
            if (networkPlayerInfo.getGameType() == WorldSettings.GameType.SPECTATOR) {
                object = String.valueOf((Object)EnumChatFormatting.ITALIC) + (String)object;
                this.mc.fontRendererObj.drawStringWithShadow((String)object, n21, n17, -1862270977);
            } else {
                this.mc.fontRendererObj.drawStringWithShadow((String)object, n21, n17, -1);
            }
            if (scoreObjective != null && networkPlayerInfo.getGameType() != WorldSettings.GameType.SPECTATOR && (n13 = (n14 = n16 + n5 + 1) + n8) - n14 > 5) {
                this.drawScoreboardValues(scoreObjective, n17, gameProfile.getName(), n14, n13, networkPlayerInfo);
            }
            this.drawPing(n9, n16 - (bl ? 9 : 0), n17, networkPlayerInfo);
        }
        if (list3 != null) {
            n11 = n11 + n7 * 9 + 1;
            GuiPlayerTabOverlay.drawRect(n / 2 - n12 / 2 - 1, n11 - 1, n / 2 + n12 / 2 + 1, n11 + list3.size() * this.mc.fontRendererObj.FONT_HEIGHT, Integer.MIN_VALUE);
            for (String string : list3) {
                n2 = this.mc.fontRendererObj.getStringWidth(string);
                this.mc.fontRendererObj.drawStringWithShadow(string, n / 2 - n2 / 2, n11, -1);
                n11 += this.mc.fontRendererObj.FONT_HEIGHT;
            }
        }
    }

    protected void drawPing(int n, int n2, int n3, NetworkPlayerInfo networkPlayerInfo) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(icons);
        int n4 = 0;
        int n5 = 0;
        n5 = networkPlayerInfo.getResponseTime() < 0 ? 5 : (networkPlayerInfo.getResponseTime() < 150 ? 0 : (networkPlayerInfo.getResponseTime() < 300 ? 1 : (networkPlayerInfo.getResponseTime() < 600 ? 2 : (networkPlayerInfo.getResponseTime() < 1000 ? 3 : 4))));
        this.zLevel += 100.0f;
        this.drawTexturedModalRect(n2 + n - 11, n3, 0 + n4 * 10, 176 + n5 * 8, 10, 8);
        this.zLevel -= 100.0f;
    }

    private void drawScoreboardValues(ScoreObjective scoreObjective, int n, String string, int n2, int n3, NetworkPlayerInfo networkPlayerInfo) {
        int n4 = scoreObjective.getScoreboard().getValueFromObjective(string, scoreObjective).getScorePoints();
        if (scoreObjective.getRenderType() == IScoreObjectiveCriteria.EnumRenderType.HEARTS) {
            boolean bl;
            this.mc.getTextureManager().bindTexture(icons);
            if (this.lastTimeOpened == networkPlayerInfo.func_178855_p()) {
                if (n4 < networkPlayerInfo.func_178835_l()) {
                    networkPlayerInfo.func_178846_a(Minecraft.getSystemTime());
                    networkPlayerInfo.func_178844_b(this.guiIngame.getUpdateCounter() + 20);
                } else if (n4 > networkPlayerInfo.func_178835_l()) {
                    networkPlayerInfo.func_178846_a(Minecraft.getSystemTime());
                    networkPlayerInfo.func_178844_b(this.guiIngame.getUpdateCounter() + 10);
                }
            }
            if (Minecraft.getSystemTime() - networkPlayerInfo.func_178847_n() > 1000L || this.lastTimeOpened != networkPlayerInfo.func_178855_p()) {
                networkPlayerInfo.func_178836_b(n4);
                networkPlayerInfo.func_178857_c(n4);
                networkPlayerInfo.func_178846_a(Minecraft.getSystemTime());
            }
            networkPlayerInfo.func_178843_c(this.lastTimeOpened);
            networkPlayerInfo.func_178836_b(n4);
            int n5 = MathHelper.ceiling_float_int((float)Math.max(n4, networkPlayerInfo.func_178860_m()) / 2.0f);
            int n6 = Math.max(MathHelper.ceiling_float_int(n4 / 2), Math.max(MathHelper.ceiling_float_int(networkPlayerInfo.func_178860_m() / 2), 10));
            boolean bl2 = bl = networkPlayerInfo.func_178858_o() > (long)this.guiIngame.getUpdateCounter() && (networkPlayerInfo.func_178858_o() - (long)this.guiIngame.getUpdateCounter()) / 3L % 2L == 1L;
            if (n5 > 0) {
                float f = Math.min((float)(n3 - n2 - 4) / (float)n6, 9.0f);
                if (f > 3.0f) {
                    int n7;
                    for (n7 = n5; n7 < n6; ++n7) {
                        this.drawTexturedModalRect((float)n2 + (float)n7 * f, (float)n, bl ? 25 : 16, 0, 9, 9);
                    }
                    for (n7 = 0; n7 < n5; ++n7) {
                        this.drawTexturedModalRect((float)n2 + (float)n7 * f, (float)n, bl ? 25 : 16, 0, 9, 9);
                        if (bl) {
                            if (n7 * 2 + 1 < networkPlayerInfo.func_178860_m()) {
                                this.drawTexturedModalRect((float)n2 + (float)n7 * f, (float)n, 70, 0, 9, 9);
                            }
                            if (n7 * 2 + 1 == networkPlayerInfo.func_178860_m()) {
                                this.drawTexturedModalRect((float)n2 + (float)n7 * f, (float)n, 79, 0, 9, 9);
                            }
                        }
                        if (n7 * 2 + 1 < n4) {
                            this.drawTexturedModalRect((float)n2 + (float)n7 * f, (float)n, n7 >= 10 ? 160 : 52, 0, 9, 9);
                        }
                        if (n7 * 2 + 1 != n4) continue;
                        this.drawTexturedModalRect((float)n2 + (float)n7 * f, (float)n, n7 >= 10 ? 169 : 61, 0, 9, 9);
                    }
                } else {
                    float f2 = MathHelper.clamp_float((float)n4 / 20.0f, 0.0f, 1.0f);
                    int n8 = (int)((1.0f - f2) * 255.0f) << 16 | (int)(f2 * 255.0f) << 8;
                    String string2 = "" + (float)n4 / 2.0f;
                    if (n3 - this.mc.fontRendererObj.getStringWidth(string2 + "hp") >= n2) {
                        string2 = string2 + "hp";
                    }
                    this.mc.fontRendererObj.drawStringWithShadow(string2, (n3 + n2) / 2 - this.mc.fontRendererObj.getStringWidth(string2) / 2, n, n8);
                }
            }
        } else {
            String string3 = String.valueOf((Object)EnumChatFormatting.YELLOW) + n4;
            this.mc.fontRendererObj.drawStringWithShadow(string3, n3 - this.mc.fontRendererObj.getStringWidth(string3), n, 0xFFFFFF);
        }
    }

    public void setFooter(IChatComponent iChatComponent) {
        this.footer = iChatComponent;
    }

    public void setHeader(IChatComponent iChatComponent) {
        this.header = iChatComponent;
    }

    public void resetFooterHeader() {
        this.header = null;
        this.footer = null;
    }

    private void mimeow$nameHider$hideTabName(NetworkPlayerInfo networkPlayerInfo, occ52191e479 occ52191e4792) {
        if (oc9755810e45.\u03c8 != null && oc9755810e45.\u03c8.z$3rzb3dil7uydr()) {
            occ52191e4792.\u04ea(oced29a282d7.\u044f(networkPlayerInfo, (String)occ52191e4792.\u040d()));
        }
    }

    @Override
    public IChatComponent getHeader() {
        return this.header;
    }

    @Override
    public IChatComponent getFooter() {
        return this.footer;
    }

    public static class PlayerComparator
    implements Comparator<NetworkPlayerInfo> {
        private PlayerComparator() {
        }

        @Override
        public int compare(NetworkPlayerInfo networkPlayerInfo, NetworkPlayerInfo networkPlayerInfo2) {
            ScorePlayerTeam scorePlayerTeam = networkPlayerInfo.getPlayerTeam();
            ScorePlayerTeam scorePlayerTeam2 = networkPlayerInfo2.getPlayerTeam();
            return ComparisonChain.start().compareTrueFirst(networkPlayerInfo.getGameType() != WorldSettings.GameType.SPECTATOR, networkPlayerInfo2.getGameType() != WorldSettings.GameType.SPECTATOR).compare((Comparable<?>)((Object)(scorePlayerTeam != null ? scorePlayerTeam.getRegisteredName() : "")), (Comparable<?>)((Object)(scorePlayerTeam2 != null ? scorePlayerTeam2.getRegisteredName() : ""))).compare((Comparable<?>)((Object)networkPlayerInfo.getGameProfile().getName()), (Comparable<?>)((Object)networkPlayerInfo2.getGameProfile().getName())).result();
        }
    }
}

