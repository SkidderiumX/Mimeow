/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui;

import com.google.common.collect.Lists;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Random;
import net.minecraft.client.audio.MusicTicker;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.network.play.client.C16PacketClientStatus;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.io.Charsets;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GuiWinGame
extends GuiScreen {
    private static final Logger logger = LogManager.getLogger();
    private static final ResourceLocation MINECRAFT_LOGO = new ResourceLocation("textures/gui/title/minecraft.png");
    private static final ResourceLocation VIGNETTE_TEXTURE = new ResourceLocation("textures/misc/vignette.png");
    private int field_146581_h;
    private List<String> field_146582_i;
    private int field_146579_r;
    private float field_146578_s = 0.5f;

    @Override
    public void updateScreen() {
        MusicTicker musicTicker = this.mc.getMusicTicker();
        SoundHandler soundHandler = this.mc.getSoundHandler();
        if (this.field_146581_h == 0) {
            musicTicker.func_181557_a();
            musicTicker.func_181558_a(MusicTicker.MusicType.CREDITS);
            soundHandler.resumeSounds();
        }
        soundHandler.update();
        ++this.field_146581_h;
        float f = (float)(this.field_146579_r + this.height + this.height + 24) / this.field_146578_s;
        if ((float)this.field_146581_h > f) {
            this.sendRespawnPacket();
        }
    }

    @Override
    protected void keyTyped(char c, int n) throws IOException {
        if (n == 1) {
            this.sendRespawnPacket();
        }
    }

    private void sendRespawnPacket() {
        this.mc.thePlayer.sendQueue.addToSendQueue(new C16PacketClientStatus(C16PacketClientStatus.EnumState.PERFORM_RESPAWN));
        this.mc.displayGuiScreen(null);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return true;
    }

    @Override
    public void initGui() {
        if (this.field_146582_i == null) {
            this.field_146582_i = Lists.newArrayList();
            try {
                Object object = "";
                String string = String.valueOf((Object)EnumChatFormatting.WHITE) + String.valueOf((Object)EnumChatFormatting.OBFUSCATED) + String.valueOf((Object)EnumChatFormatting.GREEN) + String.valueOf((Object)EnumChatFormatting.AQUA);
                int n = 274;
                InputStream inputStream2 = this.mc.getResourceManager().getResource(new ResourceLocation("texts/end.txt")).getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream2, Charsets.UTF_8));
                Random random = new Random(8124371L);
                while ((object = bufferedReader.readLine()) != null) {
                    object = ((String)object).replaceAll("PLAYERNAME", this.mc.getSession().getUsername());
                    while (((String)object).contains(string)) {
                        int n2 = ((String)object).indexOf(string);
                        String string2 = ((String)object).substring(0, n2);
                        String string3 = ((String)object).substring(n2 + string.length());
                        object = string2 + String.valueOf((Object)EnumChatFormatting.WHITE) + String.valueOf((Object)EnumChatFormatting.OBFUSCATED) + "XXXXXXXX".substring(0, random.nextInt(4) + 3) + string3;
                    }
                    this.field_146582_i.addAll(this.mc.fontRendererObj.listFormattedStringToWidth((String)object, n));
                    this.field_146582_i.add("");
                }
                inputStream2.close();
                for (int i = 0; i < 8; ++i) {
                    this.field_146582_i.add("");
                }
                inputStream2 = this.mc.getResourceManager().getResource(new ResourceLocation("texts/credits.txt")).getInputStream();
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream2, Charsets.UTF_8));
                while ((object = bufferedReader.readLine()) != null) {
                    object = ((String)object).replaceAll("PLAYERNAME", this.mc.getSession().getUsername());
                    object = ((String)object).replaceAll("\t", "    ");
                    this.field_146582_i.addAll(this.mc.fontRendererObj.listFormattedStringToWidth((String)object, n));
                    this.field_146582_i.add("");
                }
                inputStream2.close();
                this.field_146579_r = this.field_146582_i.size() * 12;
            }
            catch (Exception exception) {
                logger.error("Couldn't load credits", (Throwable)exception);
            }
        }
    }

    private void drawWinGameScreen(int n, int n2, float f) {
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldRenderer = tessellator.getWorldRenderer();
        this.mc.getTextureManager().bindTexture(Gui.optionsBackground);
        worldRenderer.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
        int n3 = this.width;
        float f2 = 0.0f - ((float)this.field_146581_h + f) * 0.5f * this.field_146578_s;
        float f3 = (float)this.height - ((float)this.field_146581_h + f) * 0.5f * this.field_146578_s;
        float f4 = 0.015625f;
        float f5 = ((float)this.field_146581_h + f - 0.0f) * 0.02f;
        float f6 = (float)(this.field_146579_r + this.height + this.height + 24) / this.field_146578_s;
        float f7 = (f6 - 20.0f - ((float)this.field_146581_h + f)) * 0.005f;
        if (f7 < f5) {
            f5 = f7;
        }
        if (f5 > 1.0f) {
            f5 = 1.0f;
        }
        f5 *= f5;
        f5 = f5 * 96.0f / 255.0f;
        worldRenderer.pos(0.0, this.height, this.zLevel).tex(0.0, f2 * f4).color(f5, f5, f5, 1.0f).endVertex();
        worldRenderer.pos(n3, this.height, this.zLevel).tex((float)n3 * f4, f2 * f4).color(f5, f5, f5, 1.0f).endVertex();
        worldRenderer.pos(n3, 0.0, this.zLevel).tex((float)n3 * f4, f3 * f4).color(f5, f5, f5, 1.0f).endVertex();
        worldRenderer.pos(0.0, 0.0, this.zLevel).tex(0.0, f3 * f4).color(f5, f5, f5, 1.0f).endVertex();
        tessellator.draw();
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        int n3;
        this.drawWinGameScreen(n, n2, f);
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldRenderer = tessellator.getWorldRenderer();
        int n4 = 274;
        int n5 = this.width / 2 - n4 / 2;
        int n6 = this.height + 50;
        float f2 = -((float)this.field_146581_h + f) * this.field_146578_s;
        GlStateManager.pushMatrix();
        GlStateManager.translate(0.0f, f2, 0.0f);
        this.mc.getTextureManager().bindTexture(MINECRAFT_LOGO);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.drawTexturedModalRect(n5, n6, 0, 0, 155, 44);
        this.drawTexturedModalRect(n5 + 155, n6, 0, 45, 155, 44);
        int n7 = n6 + 200;
        for (n3 = 0; n3 < this.field_146582_i.size(); ++n3) {
            float f3;
            if (n3 == this.field_146582_i.size() - 1 && (f3 = (float)n7 + f2 - (float)(this.height / 2 - 6)) < 0.0f) {
                GlStateManager.translate(0.0f, -f3, 0.0f);
            }
            if ((float)n7 + f2 + 12.0f + 8.0f > 0.0f && (float)n7 + f2 < (float)this.height) {
                String string = this.field_146582_i.get(n3);
                if (string.startsWith("[C]")) {
                    this.fontRendererObj.drawStringWithShadow(string.substring(3), n5 + (n4 - this.fontRendererObj.getStringWidth(string.substring(3))) / 2, n7, 0xFFFFFF);
                } else {
                    this.fontRendererObj.fontRandom.setSeed((long)n3 * 4238972211L + (long)(this.field_146581_h / 4));
                    this.fontRendererObj.drawStringWithShadow(string, n5, n7, 0xFFFFFF);
                }
            }
            n7 += 12;
        }
        GlStateManager.popMatrix();
        this.mc.getTextureManager().bindTexture(VIGNETTE_TEXTURE);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(0, 769);
        n3 = this.width;
        int n8 = this.height;
        worldRenderer.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
        worldRenderer.pos(0.0, n8, this.zLevel).tex(0.0, 1.0).color(1.0f, 1.0f, 1.0f, 1.0f).endVertex();
        worldRenderer.pos(n3, n8, this.zLevel).tex(1.0, 1.0).color(1.0f, 1.0f, 1.0f, 1.0f).endVertex();
        worldRenderer.pos(n3, 0.0, this.zLevel).tex(1.0, 0.0).color(1.0f, 1.0f, 1.0f, 1.0f).endVertex();
        worldRenderer.pos(0.0, 0.0, this.zLevel).tex(0.0, 0.0).color(1.0f, 1.0f, 1.0f, 1.0f).endVertex();
        tessellator.draw();
        GlStateManager.disableBlend();
        super.drawScreen(n, n2, f);
    }
}

