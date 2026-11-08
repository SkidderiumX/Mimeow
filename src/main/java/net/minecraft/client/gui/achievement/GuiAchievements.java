/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui.achievement;

import java.io.IOException;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiOptionButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.IProgressMeter;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.resources.I18n;
import net.minecraft.init.Blocks;
import net.minecraft.network.play.client.C16PacketClientStatus;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraft.stats.StatFileWriter;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Mouse;

public class GuiAchievements
extends GuiScreen
implements IProgressMeter {
    private static final int field_146572_y = AchievementList.minDisplayColumn * 24 - 112;
    private static final int field_146571_z = AchievementList.minDisplayRow * 24 - 112;
    private static final int field_146559_A = AchievementList.maxDisplayColumn * 24 - 77;
    private static final int field_146560_B = AchievementList.maxDisplayRow * 24 - 77;
    private static final ResourceLocation ACHIEVEMENT_BACKGROUND = new ResourceLocation("textures/gui/achievement/achievement_background.png");
    protected GuiScreen parentScreen;
    protected int field_146555_f = 256;
    protected int field_146557_g = 202;
    protected int field_146563_h;
    protected int field_146564_i;
    protected float field_146570_r = 1.0f;
    protected double field_146569_s;
    protected double field_146568_t;
    protected double field_146567_u;
    protected double field_146566_v;
    protected double field_146565_w;
    protected double field_146573_x;
    private int field_146554_D;
    private StatFileWriter statFileWriter;
    private boolean loadingAchievements = true;

    public GuiAchievements(GuiScreen guiScreen, StatFileWriter statFileWriter) {
        this.parentScreen = guiScreen;
        this.statFileWriter = statFileWriter;
        int n = 141;
        int n2 = 141;
        this.field_146567_u = this.field_146565_w = (double)(AchievementList.openInventory.displayColumn * 24 - n / 2 - 12);
        this.field_146569_s = this.field_146565_w;
        this.field_146566_v = this.field_146573_x = (double)(AchievementList.openInventory.displayRow * 24 - n2 / 2);
        this.field_146568_t = this.field_146573_x;
    }

    @Override
    public void initGui() {
        this.mc.getNetHandler().addToSendQueue(new C16PacketClientStatus(C16PacketClientStatus.EnumState.REQUEST_STATS));
        this.buttonList.clear();
        this.buttonList.add(new GuiOptionButton(1, this.width / 2 + 24, this.height / 2 + 74, 80, 20, I18n.format("gui.done", new Object[0])));
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) throws IOException {
        if (!this.loadingAchievements && guiButton.id == 1) {
            this.mc.displayGuiScreen(this.parentScreen);
        }
    }

    @Override
    protected void keyTyped(char c, int n) throws IOException {
        if (n == this.mc.gameSettings.keyBindInventory.getKeyCode()) {
            this.mc.displayGuiScreen(null);
            this.mc.setIngameFocus();
        } else {
            super.keyTyped(c, n);
        }
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        if (this.loadingAchievements) {
            this.drawDefaultBackground();
            this.drawCenteredString(this.fontRendererObj, I18n.format("multiplayer.downloadingStats", new Object[0]), this.width / 2, this.height / 2, 0xFFFFFF);
            this.drawCenteredString(this.fontRendererObj, lanSearchStates[(int)(Minecraft.getSystemTime() / 150L % (long)lanSearchStates.length)], this.width / 2, this.height / 2 + this.fontRendererObj.FONT_HEIGHT * 2, 0xFFFFFF);
        } else {
            int n3;
            if (Mouse.isButtonDown(0)) {
                n3 = (this.width - this.field_146555_f) / 2;
                int n4 = (this.height - this.field_146557_g) / 2;
                int n5 = n3 + 8;
                int n6 = n4 + 17;
                if ((this.field_146554_D == 0 || this.field_146554_D == 1) && n >= n5 && n < n5 + 224 && n2 >= n6 && n2 < n6 + 155) {
                    if (this.field_146554_D == 0) {
                        this.field_146554_D = 1;
                    } else {
                        this.field_146567_u -= (double)((float)(n - this.field_146563_h) * this.field_146570_r);
                        this.field_146566_v -= (double)((float)(n2 - this.field_146564_i) * this.field_146570_r);
                        this.field_146565_w = this.field_146569_s = this.field_146567_u;
                        this.field_146573_x = this.field_146568_t = this.field_146566_v;
                    }
                    this.field_146563_h = n;
                    this.field_146564_i = n2;
                }
            } else {
                this.field_146554_D = 0;
            }
            n3 = Mouse.getDWheel();
            float f2 = this.field_146570_r;
            if (n3 < 0) {
                this.field_146570_r += 0.25f;
            } else if (n3 > 0) {
                this.field_146570_r -= 0.25f;
            }
            this.field_146570_r = MathHelper.clamp_float(this.field_146570_r, 1.0f, 2.0f);
            if (this.field_146570_r != f2) {
                float f3 = f2 - this.field_146570_r;
                float f4 = f2 * (float)this.field_146555_f;
                float f5 = f2 * (float)this.field_146557_g;
                float f6 = this.field_146570_r * (float)this.field_146555_f;
                float f7 = this.field_146570_r * (float)this.field_146557_g;
                this.field_146567_u -= (double)((f6 - f4) * 0.5f);
                this.field_146566_v -= (double)((f7 - f5) * 0.5f);
                this.field_146565_w = this.field_146569_s = this.field_146567_u;
                this.field_146573_x = this.field_146568_t = this.field_146566_v;
            }
            if (this.field_146565_w < (double)field_146572_y) {
                this.field_146565_w = field_146572_y;
            }
            if (this.field_146573_x < (double)field_146571_z) {
                this.field_146573_x = field_146571_z;
            }
            if (this.field_146565_w >= (double)field_146559_A) {
                this.field_146565_w = field_146559_A - 1;
            }
            if (this.field_146573_x >= (double)field_146560_B) {
                this.field_146573_x = field_146560_B - 1;
            }
            this.drawDefaultBackground();
            this.drawAchievementScreen(n, n2, f);
            GlStateManager.disableLighting();
            GlStateManager.disableDepth();
            this.drawTitle();
            GlStateManager.enableLighting();
            GlStateManager.enableDepth();
        }
    }

    @Override
    public void doneLoading() {
        if (this.loadingAchievements) {
            this.loadingAchievements = false;
        }
    }

    @Override
    public void updateScreen() {
        if (!this.loadingAchievements) {
            this.field_146569_s = this.field_146567_u;
            this.field_146568_t = this.field_146566_v;
            double d = this.field_146565_w - this.field_146567_u;
            double d2 = this.field_146573_x - this.field_146566_v;
            if (d * d + d2 * d2 < 4.0) {
                this.field_146567_u += d;
                this.field_146566_v += d2;
            } else {
                this.field_146567_u += d * 0.85;
                this.field_146566_v += d2 * 0.85;
            }
        }
    }

    protected void drawTitle() {
        int n = (this.width - this.field_146555_f) / 2;
        int n2 = (this.height - this.field_146557_g) / 2;
        this.fontRendererObj.drawString(I18n.format("gui.achievements", new Object[0]), n + 15, n2 + 5, 0x404040);
    }

    protected void drawAchievementScreen(int n, int n2, float f) {
        int n3;
        int n4;
        int n5;
        int n6;
        int n7;
        int n8 = MathHelper.floor_double(this.field_146569_s + (this.field_146567_u - this.field_146569_s) * (double)f);
        int n9 = MathHelper.floor_double(this.field_146568_t + (this.field_146566_v - this.field_146568_t) * (double)f);
        if (n8 < field_146572_y) {
            n8 = field_146572_y;
        }
        if (n9 < field_146571_z) {
            n9 = field_146571_z;
        }
        if (n8 >= field_146559_A) {
            n8 = field_146559_A - 1;
        }
        if (n9 >= field_146560_B) {
            n9 = field_146560_B - 1;
        }
        int n10 = (this.width - this.field_146555_f) / 2;
        int n11 = (this.height - this.field_146557_g) / 2;
        int n12 = n10 + 16;
        int n13 = n11 + 17;
        this.zLevel = 0.0f;
        GlStateManager.depthFunc(518);
        GlStateManager.pushMatrix();
        GlStateManager.translate(n12, n13, -200.0f);
        GlStateManager.scale(1.0f / this.field_146570_r, 1.0f / this.field_146570_r, 0.0f);
        GlStateManager.enableTexture2D();
        GlStateManager.disableLighting();
        GlStateManager.enableRescaleNormal();
        GlStateManager.enableColorMaterial();
        int n14 = n8 + 288 >> 4;
        int n15 = n9 + 288 >> 4;
        int n16 = (n8 + 288) % 16;
        int n17 = (n9 + 288) % 16;
        int n18 = 4;
        int n19 = 8;
        int n20 = 10;
        int n21 = 22;
        int n22 = 37;
        Random random = new Random();
        float f2 = 16.0f / this.field_146570_r;
        float f3 = 16.0f / this.field_146570_r;
        int n23 = 0;
        while ((float)n23 * f2 - (float)n17 < 155.0f) {
            float f4 = 0.6f - (float)(n15 + n23) / 25.0f * 0.3f;
            GlStateManager.color(f4, f4, f4, 1.0f);
            n7 = 0;
            while ((float)n7 * f3 - (float)n16 < 224.0f) {
                random.setSeed(this.mc.getSession().getPlayerID().hashCode() + n14 + n7 + (n15 + n23) * 16);
                n6 = random.nextInt(1 + n15 + n23) + (n15 + n23) / 2;
                TextureAtlasSprite textureAtlasSprite = this.func_175371_a(Blocks.sand);
                if (n6 <= 37 && n15 + n23 != 35) {
                    if (n6 == 22) {
                        textureAtlasSprite = random.nextInt(2) == 0 ? this.func_175371_a(Blocks.diamond_ore) : this.func_175371_a(Blocks.redstone_ore);
                    } else if (n6 == 10) {
                        textureAtlasSprite = this.func_175371_a(Blocks.iron_ore);
                    } else if (n6 == 8) {
                        textureAtlasSprite = this.func_175371_a(Blocks.coal_ore);
                    } else if (n6 > 4) {
                        textureAtlasSprite = this.func_175371_a(Blocks.stone);
                    } else if (n6 > 0) {
                        textureAtlasSprite = this.func_175371_a(Blocks.dirt);
                    }
                } else {
                    Block block = Blocks.bedrock;
                    textureAtlasSprite = this.func_175371_a(block);
                }
                this.mc.getTextureManager().bindTexture(TextureMap.locationBlocksTexture);
                this.drawTexturedModalRect(n7 * 16 - n16, n23 * 16 - n17, textureAtlasSprite, 16, 16);
                ++n7;
            }
            ++n23;
        }
        GlStateManager.enableDepth();
        GlStateManager.depthFunc(515);
        this.mc.getTextureManager().bindTexture(ACHIEVEMENT_BACKGROUND);
        for (n23 = 0; n23 < AchievementList.achievementList.size(); ++n23) {
            Achievement achievement = AchievementList.achievementList.get(n23);
            if (achievement.parentAchievement == null) continue;
            n7 = achievement.displayColumn * 24 - n8 + 11;
            n6 = achievement.displayRow * 24 - n9 + 11;
            int n24 = achievement.parentAchievement.displayColumn * 24 - n8 + 11;
            int n25 = achievement.parentAchievement.displayRow * 24 - n9 + 11;
            n5 = this.statFileWriter.hasAchievementUnlocked(achievement) ? 1 : 0;
            n4 = this.statFileWriter.canUnlockAchievement(achievement);
            int n26 = this.statFileWriter.func_150874_c(achievement);
            if (n26 > 4) continue;
            n3 = -16777216;
            if (n5 != 0) {
                n3 = -6250336;
            } else if (n4 != 0) {
                n3 = -16711936;
            }
            this.drawHorizontalLine(n7, n24, n6, n3);
            this.drawVerticalLine(n24, n6, n25, n3);
            if (n7 > n24) {
                this.drawTexturedModalRect(n7 - 11 - 7, n6 - 5, 114, 234, 7, 11);
                continue;
            }
            if (n7 < n24) {
                this.drawTexturedModalRect(n7 + 11, n6 - 5, 107, 234, 7, 11);
                continue;
            }
            if (n6 > n25) {
                this.drawTexturedModalRect(n7 - 5, n6 - 11 - 7, 96, 234, 11, 7);
                continue;
            }
            if (n6 >= n25) continue;
            this.drawTexturedModalRect(n7 - 5, n6 + 11, 96, 241, 11, 7);
        }
        Achievement achievement = null;
        float f5 = (float)(n - n12) * this.field_146570_r;
        float f6 = (float)(n2 - n13) * this.field_146570_r;
        RenderHelper.enableGUIStandardItemLighting();
        GlStateManager.disableLighting();
        GlStateManager.enableRescaleNormal();
        GlStateManager.enableColorMaterial();
        for (n6 = 0; n6 < AchievementList.achievementList.size(); ++n6) {
            float f7;
            Achievement achievement2 = AchievementList.achievementList.get(n6);
            int n27 = achievement2.displayColumn * 24 - n8;
            n5 = achievement2.displayRow * 24 - n9;
            if (n27 < -24 || n5 < -24 || !((float)n27 <= 224.0f * this.field_146570_r) || !((float)n5 <= 155.0f * this.field_146570_r)) continue;
            n4 = this.statFileWriter.func_150874_c(achievement2);
            if (this.statFileWriter.hasAchievementUnlocked(achievement2)) {
                f7 = 0.75f;
                GlStateManager.color(f7, f7, f7, 1.0f);
            } else if (this.statFileWriter.canUnlockAchievement(achievement2)) {
                f7 = 1.0f;
                GlStateManager.color(f7, f7, f7, 1.0f);
            } else if (n4 < 3) {
                f7 = 0.3f;
                GlStateManager.color(f7, f7, f7, 1.0f);
            } else if (n4 == 3) {
                f7 = 0.2f;
                GlStateManager.color(f7, f7, f7, 1.0f);
            } else {
                if (n4 != 4) continue;
                f7 = 0.1f;
                GlStateManager.color(f7, f7, f7, 1.0f);
            }
            this.mc.getTextureManager().bindTexture(ACHIEVEMENT_BACKGROUND);
            if (achievement2.getSpecial()) {
                this.drawTexturedModalRect(n27 - 2, n5 - 2, 26, 202, 26, 26);
            } else {
                this.drawTexturedModalRect(n27 - 2, n5 - 2, 0, 202, 26, 26);
            }
            if (!this.statFileWriter.canUnlockAchievement(achievement2)) {
                f7 = 0.1f;
                GlStateManager.color(f7, f7, f7, 1.0f);
                this.itemRender.isNotRenderingEffectsInGUI(false);
            }
            GlStateManager.enableLighting();
            GlStateManager.enableCull();
            this.itemRender.renderItemAndEffectIntoGUI(achievement2.theItemStack, n27 + 3, n5 + 3);
            GlStateManager.blendFunc(770, 771);
            GlStateManager.disableLighting();
            if (!this.statFileWriter.canUnlockAchievement(achievement2)) {
                this.itemRender.isNotRenderingEffectsInGUI(true);
            }
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            if (!(f5 >= (float)n27) || !(f5 <= (float)(n27 + 22)) || !(f6 >= (float)n5) || !(f6 <= (float)(n5 + 22))) continue;
            achievement = achievement2;
        }
        GlStateManager.disableDepth();
        GlStateManager.enableBlend();
        GlStateManager.popMatrix();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(ACHIEVEMENT_BACKGROUND);
        this.drawTexturedModalRect(n10, n11, 0, 0, this.field_146555_f, this.field_146557_g);
        this.zLevel = 0.0f;
        GlStateManager.depthFunc(515);
        GlStateManager.disableDepth();
        GlStateManager.enableTexture2D();
        super.drawScreen(n, n2, f);
        if (achievement != null) {
            String string = achievement.getStatName().getUnformattedText();
            String string2 = achievement.getDescription();
            int n28 = n + 12;
            n5 = n2 - 4;
            n4 = this.statFileWriter.func_150874_c(achievement);
            if (this.statFileWriter.canUnlockAchievement(achievement)) {
                int n29 = Math.max(this.fontRendererObj.getStringWidth(string), 120);
                n3 = this.fontRendererObj.splitStringWidth(string2, n29);
                if (this.statFileWriter.hasAchievementUnlocked(achievement)) {
                    n3 += 12;
                }
                this.drawGradientRect(n28 - 3, n5 - 3, n28 + n29 + 3, n5 + n3 + 3 + 12, -1073741824, -1073741824);
                this.fontRendererObj.drawSplitString(string2, n28, n5 + 12, n29, -6250336);
                if (this.statFileWriter.hasAchievementUnlocked(achievement)) {
                    this.fontRendererObj.drawStringWithShadow(I18n.format("achievement.taken", new Object[0]), n28, n5 + n3 + 4, -7302913);
                }
            } else if (n4 == 3) {
                string = I18n.format("achievement.unknown", new Object[0]);
                int n30 = Math.max(this.fontRendererObj.getStringWidth(string), 120);
                String string3 = new ChatComponentTranslation("achievement.requires", achievement.parentAchievement.getStatName()).getUnformattedText();
                int n31 = this.fontRendererObj.splitStringWidth(string3, n30);
                this.drawGradientRect(n28 - 3, n5 - 3, n28 + n30 + 3, n5 + n31 + 12 + 3, -1073741824, -1073741824);
                this.fontRendererObj.drawSplitString(string3, n28, n5 + 12, n30, -9416624);
            } else if (n4 < 3) {
                int n32 = Math.max(this.fontRendererObj.getStringWidth(string), 120);
                String string4 = new ChatComponentTranslation("achievement.requires", achievement.parentAchievement.getStatName()).getUnformattedText();
                int n33 = this.fontRendererObj.splitStringWidth(string4, n32);
                this.drawGradientRect(n28 - 3, n5 - 3, n28 + n32 + 3, n5 + n33 + 12 + 3, -1073741824, -1073741824);
                this.fontRendererObj.drawSplitString(string4, n28, n5 + 12, n32, -9416624);
            } else {
                string = null;
            }
            if (string != null) {
                this.fontRendererObj.drawStringWithShadow(string, n28, n5, this.statFileWriter.canUnlockAchievement(achievement) ? (achievement.getSpecial() ? -128 : -1) : (achievement.getSpecial() ? -8355776 : -8355712));
            }
        }
        GlStateManager.enableDepth();
        GlStateManager.enableLighting();
        RenderHelper.disableStandardItemLighting();
    }

    private TextureAtlasSprite func_175371_a(Block block) {
        return Minecraft.getMinecraft().getBlockRendererDispatcher().getBlockModelShapes().getTexture(block.getDefaultState());
    }

    @Override
    public boolean doesGuiPauseGame() {
        return !this.loadingAchievements;
    }
}

