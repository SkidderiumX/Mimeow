/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiNewChat;
import net.minecraft.client.gui.GuiOverlayDebug;
import net.minecraft.client.gui.GuiPlayerTabOverlay;
import net.minecraft.client.gui.GuiSpectator;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.FoodStats;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StringUtils;
import net.minecraft.world.border.WorldBorder;
import org.lwjgl.opengl.GL11;
import x.oc170ea29aae;
import x.oc446ce7e211;
import x.oc6e8b910f43;
import x.oc9755810e45;

public class GuiIngame
extends Gui
implements oc6e8b910f43 {
    private static final ResourceLocation vignetteTexPath = new ResourceLocation("textures/misc/vignette.png");
    private static final ResourceLocation widgetsTexPath = new ResourceLocation("textures/gui/widgets.png");
    private static final ResourceLocation pumpkinBlurTexPath = new ResourceLocation("textures/misc/pumpkinblur.png");
    private final Random rand = new Random();
    private final Minecraft mc;
    private final RenderItem itemRenderer;
    private final GuiNewChat persistantChatGUI;
    private int updateCounter;
    private String recordPlaying = "";
    private int recordPlayingUpFor;
    private boolean recordIsPlaying;
    public float prevVignetteBrightness = 1.0f;
    private int remainingHighlightTicks;
    private ItemStack highlightingItemStack;
    private final GuiOverlayDebug overlayDebug;
    private final GuiSpectator spectatorGui;
    private final GuiPlayerTabOverlay overlayPlayerList;
    private int titlesTimer;
    private String displayedTitle = "";
    private String displayedSubTitle = "";
    private int titleFadeIn;
    private int titleDisplayTime;
    private int titleFadeOut;
    private int playerHealth = 0;
    private int lastPlayerHealth = 0;
    private long lastSystemTime = 0L;
    private long healthUpdateCounter = 0L;

    public GuiIngame(Minecraft minecraft) {
        this.mc = minecraft;
        this.itemRenderer = minecraft.getRenderItem();
        this.overlayDebug = new GuiOverlayDebug(minecraft);
        this.spectatorGui = new GuiSpectator(minecraft);
        this.persistantChatGUI = new GuiNewChat(minecraft);
        this.overlayPlayerList = new GuiPlayerTabOverlay(minecraft, this);
        this.setDefaultTitlesTimes();
    }

    public void setDefaultTitlesTimes() {
        this.titleFadeIn = 10;
        this.titleDisplayTime = 70;
        this.titleFadeOut = 20;
    }

    public void renderGameOverlay(float f) {
        ScoreObjective scoreObjective;
        int n;
        int n2;
        float f2;
        float f3;
        ScaledResolution scaledResolution = new ScaledResolution(this.mc);
        int n3 = scaledResolution.getScaledWidth();
        int n4 = scaledResolution.getScaledHeight();
        this.mc.entityRenderer.setupOverlayRendering();
        GlStateManager.enableBlend();
        if (Minecraft.isFancyGraphicsEnabled()) {
            this.renderVignette(this.mc.thePlayer.getBrightness(f), scaledResolution);
        } else {
            GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        }
        ItemStack itemStack = this.mc.thePlayer.inventory.armorItemInSlot(3);
        if (this.mc.gameSettings.thirdPersonView == 0 && itemStack != null && itemStack.getItem() == Item.getItemFromBlock(Blocks.pumpkin)) {
            this.renderPumpkinOverlay(scaledResolution);
        }
        if (!this.mc.thePlayer.isPotionActive(Potion.confusion) && (f3 = this.mc.thePlayer.prevTimeInPortal + (this.mc.thePlayer.timeInPortal - this.mc.thePlayer.prevTimeInPortal) * f) > 0.0f) {
            this.renderPortal(f3, scaledResolution);
        }
        if (this.mc.playerController.isSpectator()) {
            this.spectatorGui.renderTooltip(scaledResolution, f);
        } else {
            this.renderTooltip(scaledResolution, f);
        }
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(icons);
        GlStateManager.enableBlend();
        if (this.showCrosshair()) {
            GlStateManager.tryBlendFuncSeparate(775, 769, 1, 0);
            GlStateManager.enableAlpha();
            this.drawTexturedModalRect(n3 / 2 - 7, n4 / 2 - 7, 0, 0, 16, 16);
        }
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        this.mc.mcProfiler.startSection("bossHealth");
        this.renderBossHealth();
        this.mc.mcProfiler.endSection();
        if (this.mc.playerController.shouldDrawHUD()) {
            this.renderPlayerStats(scaledResolution);
        }
        GlStateManager.disableBlend();
        if (this.mc.thePlayer.getSleepTimer() > 0) {
            this.mc.mcProfiler.startSection("sleep");
            GlStateManager.disableDepth();
            GlStateManager.disableAlpha();
            int n5 = this.mc.thePlayer.getSleepTimer();
            f2 = (float)n5 / 100.0f;
            if (f2 > 1.0f) {
                f2 = 1.0f - (float)(n5 - 100) / 10.0f;
            }
            n2 = (int)(220.0f * f2) << 24 | 0x101020;
            GuiIngame.drawRect(0, 0, n3, n4, n2);
            GlStateManager.enableAlpha();
            GlStateManager.enableDepth();
            this.mc.mcProfiler.endSection();
        }
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        int n6 = n3 / 2 - 91;
        if (this.mc.thePlayer.isRidingHorse()) {
            this.renderHorseJumpBar(scaledResolution, n6);
        } else if (this.mc.playerController.gameIsSurvivalOrAdventure()) {
            this.renderExpBar(scaledResolution, n6);
        }
        if (this.mc.gameSettings.heldItemTooltips && !this.mc.playerController.isSpectator()) {
            this.renderSelectedItem(scaledResolution);
        } else if (this.mc.thePlayer.isSpectator()) {
            this.spectatorGui.renderSelectedItem(scaledResolution);
        }
        if (this.mc.isDemo()) {
            this.renderDemo(scaledResolution);
        }
        if (this.mc.gameSettings.showDebugInfo) {
            this.overlayDebug.renderDebugInfo(scaledResolution);
        }
        if (this.recordPlayingUpFor > 0) {
            this.mc.mcProfiler.startSection("overlayMessage");
            f2 = (float)this.recordPlayingUpFor - f;
            n2 = (int)(f2 * 255.0f / 20.0f);
            if (n2 > 255) {
                n2 = 255;
            }
            if (n2 > 8) {
                GlStateManager.pushMatrix();
                GlStateManager.translate(n3 / 2, n4 - 68, 0.0f);
                GlStateManager.enableBlend();
                GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
                int n7 = 0xFFFFFF;
                if (this.recordIsPlaying) {
                    n7 = MathHelper.hsvToRGB(f2 / 50.0f, 0.7f, 0.6f) & 0xFFFFFF;
                }
                this.getFontRenderer().drawString(this.recordPlaying, -this.getFontRenderer().getStringWidth(this.recordPlaying) / 2, -4, n7 + (n2 << 24 & 0xFF000000));
                GlStateManager.disableBlend();
                GlStateManager.popMatrix();
            }
            this.mc.mcProfiler.endSection();
        }
        if (this.titlesTimer > 0) {
            this.mc.mcProfiler.startSection("titleAndSubtitle");
            f2 = (float)this.titlesTimer - f;
            n2 = 255;
            if (this.titlesTimer > this.titleFadeOut + this.titleDisplayTime) {
                float f4 = (float)(this.titleFadeIn + this.titleDisplayTime + this.titleFadeOut) - f2;
                n2 = (int)(f4 * 255.0f / (float)this.titleFadeIn);
            }
            if (this.titlesTimer <= this.titleFadeOut) {
                n2 = (int)(f2 * 255.0f / (float)this.titleFadeOut);
            }
            if ((n2 = MathHelper.clamp_int(n2, 0, 255)) > 8) {
                GlStateManager.pushMatrix();
                GlStateManager.translate(n3 / 2, n4 / 2, 0.0f);
                GlStateManager.enableBlend();
                GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
                GlStateManager.pushMatrix();
                GlStateManager.scale(4.0f, 4.0f, 4.0f);
                int n8 = n2 << 24 & 0xFF000000;
                this.getFontRenderer().drawString(this.displayedTitle, -this.getFontRenderer().getStringWidth(this.displayedTitle) / 2, -10.0f, 0xFFFFFF | n8, true);
                GlStateManager.popMatrix();
                GlStateManager.pushMatrix();
                GlStateManager.scale(2.0f, 2.0f, 2.0f);
                this.getFontRenderer().drawString(this.displayedSubTitle, -this.getFontRenderer().getStringWidth(this.displayedSubTitle) / 2, 5.0f, 0xFFFFFF | n8, true);
                GlStateManager.popMatrix();
                GlStateManager.disableBlend();
                GlStateManager.popMatrix();
            }
            this.mc.mcProfiler.endSection();
        }
        Scoreboard scoreboard = this.mc.theWorld.getScoreboard();
        ScoreObjective scoreObjective2 = null;
        ScorePlayerTeam scorePlayerTeam = scoreboard.getPlayersTeam(this.mc.thePlayer.getName());
        if (scorePlayerTeam != null && (n = scorePlayerTeam.getChatFormat().getColorIndex()) >= 0) {
            scoreObjective2 = scoreboard.getObjectiveInDisplaySlot(3 + n);
        }
        ScoreObjective scoreObjective3 = scoreObjective = scoreObjective2 != null ? scoreObjective2 : scoreboard.getObjectiveInDisplaySlot(1);
        if (scoreObjective != null || this.mc.currentScreen instanceof GuiChat && oc446ce7e211.\u00c2()) {
            this.renderScoreboard(scoreObjective, scaledResolution);
        }
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        GlStateManager.disableAlpha();
        GlStateManager.pushMatrix();
        GlStateManager.translate(0.0f, n4 - 48, 0.0f);
        this.mc.mcProfiler.startSection("chat");
        this.persistantChatGUI.drawChat(this.updateCounter);
        this.mc.mcProfiler.endSection();
        GlStateManager.popMatrix();
        scoreObjective = scoreboard.getObjectiveInDisplaySlot(0);
        if (this.mc.gameSettings.keyBindPlayerList.isKeyDown() && (!this.mc.isIntegratedServerRunning() || this.mc.thePlayer.sendQueue.getPlayerInfoMap().size() > 1 || scoreObjective != null)) {
            this.overlayPlayerList.updatePlayerList(true);
            this.overlayPlayerList.renderPlayerlist(n3, scoreboard, scoreObjective);
        } else {
            this.overlayPlayerList.updatePlayerList(false);
        }
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.disableLighting();
        GlStateManager.enableAlpha();
    }

    protected void renderTooltip(ScaledResolution scaledResolution, float f) {
        if (this.mc.getRenderViewEntity() instanceof EntityPlayer) {
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            this.mc.getTextureManager().bindTexture(widgetsTexPath);
            EntityPlayer entityPlayer = (EntityPlayer)this.mc.getRenderViewEntity();
            int n = scaledResolution.getScaledWidth() / 2;
            float f2 = this.zLevel;
            this.zLevel = -90.0f;
            this.drawTexturedModalRect(n - 91, scaledResolution.getScaledHeight() - 22, 0, 0, 182, 22);
            this.drawTexturedModalRect(n - 91 - 1 + entityPlayer.inventory.currentItem * 20, scaledResolution.getScaledHeight() - 22 - 1, 0, 22, 24, 22);
            this.zLevel = f2;
            GlStateManager.enableRescaleNormal();
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
            RenderHelper.enableGUIStandardItemLighting();
            for (int i = 0; i < 9; ++i) {
                int n2 = scaledResolution.getScaledWidth() / 2 - 90 + i * 20 + 2;
                int n3 = scaledResolution.getScaledHeight() - 16 - 3;
                this.renderHotbarItem(i, n2, n3, f, entityPlayer);
            }
            RenderHelper.disableStandardItemLighting();
            GlStateManager.disableRescaleNormal();
            GlStateManager.disableBlend();
        }
    }

    public void renderHorseJumpBar(ScaledResolution scaledResolution, int n) {
        this.mc.mcProfiler.startSection("jumpBar");
        this.mc.getTextureManager().bindTexture(Gui.icons);
        float f = this.mc.thePlayer.getHorseJumpPower();
        int n2 = 182;
        int n3 = (int)(f * (float)(n2 + 1));
        int n4 = scaledResolution.getScaledHeight() - 32 + 3;
        this.drawTexturedModalRect(n, n4, 0, 84, n2, 5);
        if (n3 > 0) {
            this.drawTexturedModalRect(n, n4, 0, 89, n3, 5);
        }
        this.mc.mcProfiler.endSection();
    }

    public void renderExpBar(ScaledResolution scaledResolution, int n) {
        int n2;
        int n3;
        this.mc.mcProfiler.startSection("expBar");
        this.mc.getTextureManager().bindTexture(Gui.icons);
        int n4 = this.mc.thePlayer.xpBarCap();
        if (n4 > 0) {
            n3 = 182;
            int n5 = (int)(this.mc.thePlayer.experience * (float)(n3 + 1));
            n2 = scaledResolution.getScaledHeight() - 32 + 3;
            this.drawTexturedModalRect(n, n2, 0, 64, n3, 5);
            if (n5 > 0) {
                this.drawTexturedModalRect(n, n2, 0, 69, n5, 5);
            }
        }
        this.mc.mcProfiler.endSection();
        if (this.mc.thePlayer.experienceLevel > 0) {
            this.mc.mcProfiler.startSection("expLevel");
            n3 = 8453920;
            String string = "" + this.mc.thePlayer.experienceLevel;
            n2 = (scaledResolution.getScaledWidth() - this.getFontRenderer().getStringWidth(string)) / 2;
            int n6 = scaledResolution.getScaledHeight() - 31 - 4;
            boolean bl = false;
            this.getFontRenderer().drawString(string, n2 + 1, n6, 0);
            this.getFontRenderer().drawString(string, n2 - 1, n6, 0);
            this.getFontRenderer().drawString(string, n2, n6 + 1, 0);
            this.getFontRenderer().drawString(string, n2, n6 - 1, 0);
            this.getFontRenderer().drawString(string, n2, n6, n3);
            this.mc.mcProfiler.endSection();
        }
    }

    public void renderSelectedItem(ScaledResolution scaledResolution) {
        this.mc.mcProfiler.startSection("selectedItemName");
        if (this.remainingHighlightTicks > 0 && this.highlightingItemStack != null) {
            int n;
            Object object = this.highlightingItemStack.getDisplayName();
            if (this.highlightingItemStack.hasDisplayName()) {
                object = String.valueOf((Object)EnumChatFormatting.ITALIC) + (String)object;
            }
            int n2 = (scaledResolution.getScaledWidth() - this.getFontRenderer().getStringWidth((String)object)) / 2;
            int n3 = scaledResolution.getScaledHeight() - 59;
            if (!this.mc.playerController.shouldDrawHUD()) {
                n3 += 14;
            }
            if ((n = (int)((float)this.remainingHighlightTicks * 256.0f / 10.0f)) > 255) {
                n = 255;
            }
            if (n > 0) {
                GlStateManager.pushMatrix();
                GlStateManager.enableBlend();
                GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
                this.getFontRenderer().drawStringWithShadow((String)object, n2, n3, 0xFFFFFF + (n << 24));
                GlStateManager.disableBlend();
                GlStateManager.popMatrix();
            }
        }
        this.mc.mcProfiler.endSection();
    }

    public void renderDemo(ScaledResolution scaledResolution) {
        this.mc.mcProfiler.startSection("demo");
        String string = "";
        string = this.mc.theWorld.getTotalWorldTime() >= 120500L ? I18n.format("demo.demoExpired", new Object[0]) : I18n.format("demo.remainingTime", StringUtils.ticksToElapsedTime((int)(120500L - this.mc.theWorld.getTotalWorldTime())));
        int n = this.getFontRenderer().getStringWidth(string);
        this.getFontRenderer().drawStringWithShadow(string, scaledResolution.getScaledWidth() - n - 10, 5.0f, 0xFFFFFF);
        this.mc.mcProfiler.endSection();
    }

    protected boolean showCrosshair() {
        if (this.mc.gameSettings.showDebugInfo && !this.mc.thePlayer.hasReducedDebug() && !this.mc.gameSettings.reducedDebugInfo) {
            return false;
        }
        if (this.mc.playerController.isSpectator()) {
            BlockPos blockPos;
            if (this.mc.pointedEntity != null) {
                return true;
            }
            return this.mc.objectMouseOver != null && this.mc.objectMouseOver.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK && this.mc.theWorld.getTileEntity(blockPos = this.mc.objectMouseOver.getBlockPos()) instanceof IInventory;
        }
        return true;
    }

    private void renderScoreboard(ScoreObjective scoreObjective, ScaledResolution scaledResolution) {
        if (oc9755810e45.u != null && oc9755810e45.u.z$3rzb3dil7uydr()) {
            oc9755810e45.u.\u026f(scoreObjective, scaledResolution, this.getFontRenderer());
            return;
        }
        if (scoreObjective == null) {
            return;
        }
        Scoreboard scoreboard = scoreObjective.getScoreboard();
        Collection<Score> collection = scoreboard.getSortedScores(scoreObjective);
        ArrayList<Score> arrayList = Lists.newArrayList(Iterables.filter(collection, new Predicate<Score>(){

            @Override
            public boolean apply(Score score) {
                return score.getPlayerName() != null && !score.getPlayerName().startsWith("#");
            }
        }));
        collection = arrayList.size() > 15 ? Lists.newArrayList(Iterables.skip(arrayList, collection.size() - 15)) : arrayList;
        int n = this.getFontRenderer().getStringWidth(scoreObjective.getDisplayName());
        for (Score score : collection) {
            ScorePlayerTeam scorePlayerTeam = scoreboard.getPlayersTeam(score.getPlayerName());
            String string = ScorePlayerTeam.formatPlayerName(scorePlayerTeam, score.getPlayerName()) + ": " + String.valueOf((Object)EnumChatFormatting.RED) + score.getScorePoints();
            n = Math.max(n, this.getFontRenderer().getStringWidth(string));
        }
        int n2 = collection.size() * this.getFontRenderer().FONT_HEIGHT;
        int n3 = scaledResolution.getScaledHeight() / 2 + n2 / 3;
        int n4 = 3;
        int n5 = scaledResolution.getScaledWidth() - n - n4;
        int n6 = 0;
        for (Score score : collection) {
            ScorePlayerTeam scorePlayerTeam = scoreboard.getPlayersTeam(score.getPlayerName());
            String string = ScorePlayerTeam.formatPlayerName(scorePlayerTeam, score.getPlayerName());
            String string2 = String.valueOf((Object)EnumChatFormatting.RED) + score.getScorePoints();
            int n7 = n3 - ++n6 * this.getFontRenderer().FONT_HEIGHT;
            int n8 = scaledResolution.getScaledWidth() - n4 + 2;
            GuiIngame.drawRect(n5 - 2, n7, n8, n7 + this.getFontRenderer().FONT_HEIGHT, 0x50000000);
            this.getFontRenderer().drawString(string, n5, n7, 0x20FFFFFF);
            this.getFontRenderer().drawString(string2, n8 - this.getFontRenderer().getStringWidth(string2), n7, 0x20FFFFFF);
            if (n6 != collection.size()) continue;
            String string3 = scoreObjective.getDisplayName();
            GuiIngame.drawRect(n5 - 2, n7 - this.getFontRenderer().FONT_HEIGHT - 1, n8, n7 - 1, 0x60000000);
            GuiIngame.drawRect(n5 - 2, n7 - 1, n8, n7, 0x50000000);
            this.getFontRenderer().drawString(string3, n5 + n / 2 - this.getFontRenderer().getStringWidth(string3) / 2, n7 - this.getFontRenderer().FONT_HEIGHT, 0x20FFFFFF);
        }
    }

    private void renderPlayerStats(ScaledResolution scaledResolution) {
        if (this.mc.getRenderViewEntity() instanceof EntityPlayer) {
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            int n7;
            boolean bl;
            EntityPlayer entityPlayer = (EntityPlayer)this.mc.getRenderViewEntity();
            int n8 = MathHelper.ceiling_float_int(entityPlayer.getHealth());
            boolean bl2 = bl = this.healthUpdateCounter > (long)this.updateCounter && (this.healthUpdateCounter - (long)this.updateCounter) / 3L % 2L == 1L;
            if (n8 < this.playerHealth && entityPlayer.hurtResistantTime > 0) {
                this.lastSystemTime = Minecraft.getSystemTime();
                this.healthUpdateCounter = this.updateCounter + 20;
            } else if (n8 > this.playerHealth && entityPlayer.hurtResistantTime > 0) {
                this.lastSystemTime = Minecraft.getSystemTime();
                this.healthUpdateCounter = this.updateCounter + 10;
            }
            if (Minecraft.getSystemTime() - this.lastSystemTime > 1000L) {
                this.playerHealth = n8;
                this.lastPlayerHealth = n8;
                this.lastSystemTime = Minecraft.getSystemTime();
            }
            this.playerHealth = n8;
            int n9 = this.lastPlayerHealth;
            this.rand.setSeed(this.updateCounter * 312871);
            boolean bl3 = false;
            FoodStats foodStats = entityPlayer.getFoodStats();
            int n10 = foodStats.getFoodLevel();
            int n11 = foodStats.getPrevFoodLevel();
            IAttributeInstance iAttributeInstance = entityPlayer.getEntityAttribute(SharedMonsterAttributes.maxHealth);
            int n12 = scaledResolution.getScaledWidth() / 2 - 91;
            int n13 = scaledResolution.getScaledWidth() / 2 + 91;
            int n14 = scaledResolution.getScaledHeight() - 39;
            float f = (float)iAttributeInstance.getAttributeValue();
            float f2 = entityPlayer.getAbsorptionAmount();
            int n15 = MathHelper.ceiling_float_int((f + f2) / 2.0f / 10.0f);
            int n16 = Math.max(10 - (n15 - 2), 3);
            int n17 = n14 - (n15 - 1) * n16 - 10;
            float f3 = f2;
            int n18 = entityPlayer.getTotalArmorValue();
            int n19 = -1;
            if (entityPlayer.isPotionActive(Potion.regeneration)) {
                n19 = this.updateCounter % MathHelper.ceiling_float_int(f + 5.0f);
            }
            this.mc.mcProfiler.startSection("armor");
            for (n7 = 0; n7 < 10; ++n7) {
                if (n18 <= 0) continue;
                n6 = n12 + n7 * 8;
                if (n7 * 2 + 1 < n18) {
                    this.drawTexturedModalRect(n6, n17, 34, 9, 9, 9);
                }
                if (n7 * 2 + 1 == n18) {
                    this.drawTexturedModalRect(n6, n17, 25, 9, 9, 9);
                }
                if (n7 * 2 + 1 <= n18) continue;
                this.drawTexturedModalRect(n6, n17, 16, 9, 9, 9);
            }
            this.mc.mcProfiler.endStartSection("health");
            for (n7 = MathHelper.ceiling_float_int((f + f2) / 2.0f) - 1; n7 >= 0; --n7) {
                n6 = 16;
                if (entityPlayer.isPotionActive(Potion.poison)) {
                    n6 += 36;
                } else if (entityPlayer.isPotionActive(Potion.wither)) {
                    n6 += 72;
                }
                n5 = 0;
                if (bl) {
                    n5 = 1;
                }
                n4 = MathHelper.ceiling_float_int((float)(n7 + 1) / 10.0f) - 1;
                n3 = n12 + n7 % 10 * 8;
                n2 = n14 - n4 * n16;
                if (n8 <= 4) {
                    n2 += this.rand.nextInt(2);
                }
                if (n7 == n19) {
                    n2 -= 2;
                }
                n = 0;
                if (entityPlayer.worldObj.getWorldInfo().isHardcoreModeEnabled()) {
                    n = 5;
                }
                this.drawTexturedModalRect(n3, n2, 16 + n5 * 9, 9 * n, 9, 9);
                if (bl) {
                    if (n7 * 2 + 1 < n9) {
                        this.drawTexturedModalRect(n3, n2, n6 + 54, 9 * n, 9, 9);
                    }
                    if (n7 * 2 + 1 == n9) {
                        this.drawTexturedModalRect(n3, n2, n6 + 63, 9 * n, 9, 9);
                    }
                }
                if (f3 <= 0.0f) {
                    if (n7 * 2 + 1 < n8) {
                        this.drawTexturedModalRect(n3, n2, n6 + 36, 9 * n, 9, 9);
                    }
                    if (n7 * 2 + 1 != n8) continue;
                    this.drawTexturedModalRect(n3, n2, n6 + 45, 9 * n, 9, 9);
                    continue;
                }
                if (f3 == f2 && f2 % 2.0f == 1.0f) {
                    this.drawTexturedModalRect(n3, n2, n6 + 153, 9 * n, 9, 9);
                } else {
                    this.drawTexturedModalRect(n3, n2, n6 + 144, 9 * n, 9, 9);
                }
                f3 -= 2.0f;
            }
            Entity entity = entityPlayer.ridingEntity;
            if (entity == null) {
                this.mc.mcProfiler.endStartSection("food");
                for (n6 = 0; n6 < 10; ++n6) {
                    n5 = n14;
                    n4 = 16;
                    n3 = 0;
                    if (entityPlayer.isPotionActive(Potion.hunger)) {
                        n4 += 36;
                        n3 = 13;
                    }
                    if (entityPlayer.getFoodStats().getSaturationLevel() <= 0.0f && this.updateCounter % (n10 * 3 + 1) == 0) {
                        n5 = n14 + (this.rand.nextInt(3) - 1);
                    }
                    if (bl3) {
                        n3 = 1;
                    }
                    n2 = n13 - n6 * 8 - 9;
                    this.drawTexturedModalRect(n2, n5, 16 + n3 * 9, 27, 9, 9);
                    if (bl3) {
                        if (n6 * 2 + 1 < n11) {
                            this.drawTexturedModalRect(n2, n5, n4 + 54, 27, 9, 9);
                        }
                        if (n6 * 2 + 1 == n11) {
                            this.drawTexturedModalRect(n2, n5, n4 + 63, 27, 9, 9);
                        }
                    }
                    if (n6 * 2 + 1 < n10) {
                        this.drawTexturedModalRect(n2, n5, n4 + 36, 27, 9, 9);
                    }
                    if (n6 * 2 + 1 != n10) continue;
                    this.drawTexturedModalRect(n2, n5, n4 + 45, 27, 9, 9);
                }
            } else if (entity instanceof EntityLivingBase) {
                this.mc.mcProfiler.endStartSection("mountHealth");
                EntityLivingBase entityLivingBase = (EntityLivingBase)entity;
                n5 = (int)Math.ceil(entityLivingBase.getHealth());
                float f4 = entityLivingBase.getMaxHealth();
                n3 = (int)(f4 + 0.5f) / 2;
                if (n3 > 30) {
                    n3 = 30;
                }
                n2 = n14;
                n = 0;
                while (n3 > 0) {
                    int n20 = Math.min(n3, 10);
                    n3 -= n20;
                    for (int i = 0; i < n20; ++i) {
                        int n21 = 52;
                        int n22 = 0;
                        if (bl3) {
                            n22 = 1;
                        }
                        int n23 = n13 - i * 8 - 9;
                        this.drawTexturedModalRect(n23, n2, n21 + n22 * 9, 9, 9, 9);
                        if (i * 2 + 1 + n < n5) {
                            this.drawTexturedModalRect(n23, n2, n21 + 36, 9, 9, 9);
                        }
                        if (i * 2 + 1 + n != n5) continue;
                        this.drawTexturedModalRect(n23, n2, n21 + 45, 9, 9, 9);
                    }
                    n2 -= 10;
                    n += 20;
                }
            }
            this.mc.mcProfiler.endStartSection("air");
            if (entityPlayer.isInsideOfMaterial(Material.water)) {
                int n24 = this.mc.thePlayer.getAir();
                n5 = MathHelper.ceiling_double_int((double)(n24 - 2) * 10.0 / 300.0);
                int n25 = MathHelper.ceiling_double_int((double)n24 * 10.0 / 300.0) - n5;
                for (n3 = 0; n3 < n5 + n25; ++n3) {
                    if (n3 < n5) {
                        this.drawTexturedModalRect(n13 - n3 * 8 - 9, n17, 16, 18, 9, 9);
                        continue;
                    }
                    this.drawTexturedModalRect(n13 - n3 * 8 - 9, n17, 25, 18, 9, 9);
                }
            }
            this.mc.mcProfiler.endSection();
        }
    }

    private void renderBossHealth() {
        if (BossStatus.bossName != null && BossStatus.statusBarTime > 0) {
            --BossStatus.statusBarTime;
            FontRenderer fontRenderer = this.mc.fontRendererObj;
            ScaledResolution scaledResolution = new ScaledResolution(this.mc);
            int n = scaledResolution.getScaledWidth();
            int n2 = 182;
            int n3 = n / 2 - n2 / 2;
            int n4 = (int)(BossStatus.healthScale * (float)(n2 + 1));
            int n5 = 12;
            this.drawTexturedModalRect(n3, n5, 0, 74, n2, 5);
            this.drawTexturedModalRect(n3, n5, 0, 74, n2, 5);
            if (n4 > 0) {
                this.drawTexturedModalRect(n3, n5, 0, 79, n4, 5);
            }
            String string = BossStatus.bossName;
            this.getFontRenderer().drawStringWithShadow(string, n / 2 - this.getFontRenderer().getStringWidth(string) / 2, n5 - 10, 0xFFFFFF);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            this.mc.getTextureManager().bindTexture(icons);
        }
    }

    private void renderPumpkinOverlay(ScaledResolution scaledResolution) {
        GlStateManager.disableDepth();
        GlStateManager.depthMask(false);
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.disableAlpha();
        this.mc.getTextureManager().bindTexture(pumpkinBlurTexPath);
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldRenderer = tessellator.getWorldRenderer();
        worldRenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
        worldRenderer.pos(0.0, scaledResolution.getScaledHeight(), -90.0).tex(0.0, 1.0).endVertex();
        worldRenderer.pos(scaledResolution.getScaledWidth(), scaledResolution.getScaledHeight(), -90.0).tex(1.0, 1.0).endVertex();
        worldRenderer.pos(scaledResolution.getScaledWidth(), 0.0, -90.0).tex(1.0, 0.0).endVertex();
        worldRenderer.pos(0.0, 0.0, -90.0).tex(0.0, 0.0).endVertex();
        tessellator.draw();
        GlStateManager.depthMask(true);
        GlStateManager.enableDepth();
        GlStateManager.enableAlpha();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
    }

    private void renderVignette(float f, ScaledResolution scaledResolution) {
        f = 1.0f - f;
        f = MathHelper.clamp_float(f, 0.0f, 1.0f);
        WorldBorder worldBorder = this.mc.theWorld.getWorldBorder();
        float f2 = (float)worldBorder.getClosestDistance(this.mc.thePlayer);
        double d = Math.min(worldBorder.getResizeSpeed() * (double)worldBorder.getWarningTime() * 1000.0, Math.abs(worldBorder.getTargetSize() - worldBorder.getDiameter()));
        double d2 = Math.max((double)worldBorder.getWarningDistance(), d);
        f2 = (double)f2 < d2 ? 1.0f - (float)((double)f2 / d2) : 0.0f;
        this.prevVignetteBrightness = (float)((double)this.prevVignetteBrightness + (double)(f - this.prevVignetteBrightness) * 0.01);
        GlStateManager.disableDepth();
        GlStateManager.depthMask(false);
        GlStateManager.tryBlendFuncSeparate(0, 769, 1, 0);
        if (f2 > 0.0f) {
            GlStateManager.color(0.0f, f2, f2, 1.0f);
        } else {
            GlStateManager.color(this.prevVignetteBrightness, this.prevVignetteBrightness, this.prevVignetteBrightness, 1.0f);
        }
        this.mc.getTextureManager().bindTexture(vignetteTexPath);
        GL11.glBegin(7);
        GL11.glTexCoord2f(0.0f, 1.0f);
        GL11.glVertex3f(0.0f, scaledResolution.getScaledHeight(), -90.0f);
        GL11.glTexCoord2f(1.0f, 1.0f);
        GL11.glVertex3f(scaledResolution.getScaledWidth(), scaledResolution.getScaledHeight(), -90.0f);
        GL11.glTexCoord2f(1.0f, 0.0f);
        GL11.glVertex3f(scaledResolution.getScaledWidth(), 0.0f, -90.0f);
        GL11.glTexCoord2f(0.0f, 0.0f);
        GL11.glVertex3f(0.0f, 0.0f, -90.0f);
        oc170ea29aae.\u0177();
        GlStateManager.depthMask(true);
        GlStateManager.enableDepth();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
    }

    private void renderPortal(float f, ScaledResolution scaledResolution) {
        if (f < 1.0f) {
            f *= f;
            f *= f;
            f = f * 0.8f + 0.2f;
        }
        GlStateManager.disableAlpha();
        GlStateManager.disableDepth();
        GlStateManager.depthMask(false);
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        GlStateManager.color(1.0f, 1.0f, 1.0f, f);
        this.mc.getTextureManager().bindTexture(TextureMap.locationBlocksTexture);
        TextureAtlasSprite textureAtlasSprite = this.mc.getBlockRendererDispatcher().getBlockModelShapes().getTexture(Blocks.portal.getDefaultState());
        float f2 = textureAtlasSprite.getMinU();
        float f3 = textureAtlasSprite.getMinV();
        float f4 = textureAtlasSprite.getMaxU();
        float f5 = textureAtlasSprite.getMaxV();
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldRenderer = tessellator.getWorldRenderer();
        worldRenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
        worldRenderer.pos(0.0, scaledResolution.getScaledHeight(), -90.0).tex(f2, f5).endVertex();
        worldRenderer.pos(scaledResolution.getScaledWidth(), scaledResolution.getScaledHeight(), -90.0).tex(f4, f5).endVertex();
        worldRenderer.pos(scaledResolution.getScaledWidth(), 0.0, -90.0).tex(f4, f3).endVertex();
        worldRenderer.pos(0.0, 0.0, -90.0).tex(f2, f3).endVertex();
        tessellator.draw();
        GlStateManager.depthMask(true);
        GlStateManager.enableDepth();
        GlStateManager.enableAlpha();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
    }

    private void renderHotbarItem(int n, int n2, int n3, float f, EntityPlayer entityPlayer) {
        ItemStack itemStack = entityPlayer.inventory.mainInventory[n];
        if (itemStack != null) {
            float f2 = (float)itemStack.animationsToGo - f;
            if (f2 > 0.0f) {
                GlStateManager.pushMatrix();
                float f3 = 1.0f + f2 / 5.0f;
                GlStateManager.translate(n2 + 8, n3 + 12, 0.0f);
                GlStateManager.scale(1.0f / f3, (f3 + 1.0f) / 2.0f, 1.0f);
                GlStateManager.translate(-(n2 + 8), -(n3 + 12), 0.0f);
            }
            this.itemRenderer.renderItemAndEffectIntoGUI(itemStack, n2, n3);
            if (f2 > 0.0f) {
                GlStateManager.popMatrix();
            }
            this.itemRenderer.renderItemOverlays(this.mc.fontRendererObj, itemStack, n2, n3);
        }
    }

    public void updateTick() {
        if (this.recordPlayingUpFor > 0) {
            --this.recordPlayingUpFor;
        }
        if (this.titlesTimer > 0) {
            --this.titlesTimer;
            if (this.titlesTimer <= 0) {
                this.displayedTitle = "";
                this.displayedSubTitle = "";
            }
        }
        ++this.updateCounter;
        if (this.mc.thePlayer != null) {
            ItemStack itemStack = this.mc.thePlayer.inventory.getCurrentItem();
            if (itemStack == null) {
                this.remainingHighlightTicks = 0;
            } else if (this.highlightingItemStack != null && itemStack.getItem() == this.highlightingItemStack.getItem() && ItemStack.areItemStackTagsEqual(itemStack, this.highlightingItemStack) && (itemStack.isItemStackDamageable() || itemStack.getMetadata() == this.highlightingItemStack.getMetadata())) {
                if (this.remainingHighlightTicks > 0) {
                    --this.remainingHighlightTicks;
                }
            } else {
                this.remainingHighlightTicks = 40;
            }
            this.highlightingItemStack = itemStack;
        }
    }

    public void setRecordPlayingMessage(String string) {
        this.setRecordPlaying(I18n.format("record.nowPlaying", string), true);
    }

    public void setRecordPlaying(String string, boolean bl) {
        this.recordPlaying = string;
        this.recordPlayingUpFor = 60;
        this.recordIsPlaying = bl;
    }

    public void displayTitle(String string, String string2, int n, int n2, int n3) {
        if (string == null && string2 == null && n < 0 && n2 < 0 && n3 < 0) {
            this.displayedTitle = "";
            this.displayedSubTitle = "";
            this.titlesTimer = 0;
        } else if (string != null) {
            this.displayedTitle = string;
            this.titlesTimer = this.titleFadeIn + this.titleDisplayTime + this.titleFadeOut;
        } else if (string2 != null) {
            this.displayedSubTitle = string2;
        } else {
            if (n >= 0) {
                this.titleFadeIn = n;
            }
            if (n2 >= 0) {
                this.titleDisplayTime = n2;
            }
            if (n3 >= 0) {
                this.titleFadeOut = n3;
            }
            if (this.titlesTimer > 0) {
                this.titlesTimer = this.titleFadeIn + this.titleDisplayTime + this.titleFadeOut;
            }
        }
    }

    public void setRecordPlaying(IChatComponent iChatComponent, boolean bl) {
        this.setRecordPlaying(iChatComponent.getUnformattedText(), bl);
    }

    public GuiNewChat getChatGUI() {
        return this.persistantChatGUI;
    }

    public int getUpdateCounter() {
        return this.updateCounter;
    }

    public FontRenderer getFontRenderer() {
        return this.mc.fontRendererObj;
    }

    public GuiSpectator getSpectatorGui() {
        return this.spectatorGui;
    }

    public GuiPlayerTabOverlay getTabList() {
        return this.overlayPlayerList;
    }

    public void resetPlayersOverlayFooterHeader() {
        this.overlayPlayerList.resetFooterHeader();
    }

    @Override
    public String getRecordPlaying() {
        return this.recordPlaying;
    }

    @Override
    public String getDisplayedTitle() {
        return this.displayedTitle;
    }

    @Override
    public String getDisplayedSubTitle() {
        return this.displayedSubTitle;
    }
}

