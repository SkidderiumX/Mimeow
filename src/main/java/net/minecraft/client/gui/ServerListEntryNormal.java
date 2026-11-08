/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui;

import com.google.common.base.Charsets;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.base64.Base64;
import java.awt.image.BufferedImage;
import java.net.UnknownHostException;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiListExtended;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.lang3.Validate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ServerListEntryNormal
implements GuiListExtended.IGuiListEntry {
    private static final Logger logger = LogManager.getLogger();
    private static final ThreadPoolExecutor field_148302_b = new ScheduledThreadPoolExecutor(5, new ThreadFactoryBuilder().setNameFormat("Server Pinger #%d").setDaemon(true).build());
    private static final ResourceLocation UNKNOWN_SERVER = new ResourceLocation("textures/misc/unknown_server.png");
    private static final ResourceLocation SERVER_SELECTION_BUTTONS = new ResourceLocation("textures/gui/server_selection.png");
    private final GuiMultiplayer owner;
    private final Minecraft mc;
    private final ServerData server;
    private final ResourceLocation serverIcon;
    private String field_148299_g;
    private DynamicTexture field_148305_h;
    private long field_148298_f;

    protected ServerListEntryNormal(GuiMultiplayer guiMultiplayer, ServerData serverData) {
        this.owner = guiMultiplayer;
        this.server = serverData;
        this.mc = Minecraft.getMinecraft();
        this.serverIcon = new ResourceLocation("servers/" + serverData.serverIP + "/icon");
        this.field_148305_h = (DynamicTexture)this.mc.getTextureManager().getTexture(this.serverIcon);
    }

    @Override
    public void drawEntry(int n, int n2, int n3, int n4, int n5, int n6, int n7, boolean bl) {
        Object object;
        int n8;
        if (!this.server.field_78841_f) {
            this.server.field_78841_f = true;
            this.server.pingToServer = -2L;
            this.server.serverMOTD = "";
            this.server.populationInfo = "";
            field_148302_b.submit(new Runnable(){

                @Override
                public void run() {
                    try {
                        ServerListEntryNormal.this.owner.getOldServerPinger().ping(ServerListEntryNormal.this.server);
                    }
                    catch (UnknownHostException unknownHostException) {
                        ServerListEntryNormal.this.server.pingToServer = -1L;
                        ServerListEntryNormal.this.server.serverMOTD = String.valueOf((Object)EnumChatFormatting.DARK_RED) + "Can't resolve hostname";
                    }
                    catch (Exception exception) {
                        ServerListEntryNormal.this.server.pingToServer = -1L;
                        ServerListEntryNormal.this.server.serverMOTD = String.valueOf((Object)EnumChatFormatting.DARK_RED) + "Can't connect to server.";
                    }
                }
            });
        }
        boolean bl2 = this.server.version > 47;
        boolean bl3 = this.server.version < 47;
        boolean bl4 = bl2 || bl3;
        this.mc.fontRendererObj.drawString(this.server.serverName, n2 + 32 + 3, n3 + 1, 0xFFFFFF);
        List<String> list = this.mc.fontRendererObj.listFormattedStringToWidth(this.server.serverMOTD, n4 - 32 - 2);
        for (int i = 0; i < Math.min(list.size(), 2); ++i) {
            this.mc.fontRendererObj.drawString(list.get(i), n2 + 32 + 3, n3 + 12 + this.mc.fontRendererObj.FONT_HEIGHT * i, 0x808080);
        }
        String string = bl4 ? String.valueOf((Object)EnumChatFormatting.DARK_RED) + this.server.gameVersion : this.server.populationInfo;
        int n9 = this.mc.fontRendererObj.getStringWidth(string);
        this.mc.fontRendererObj.drawString(string, n2 + n4 - n9 - 15 - 2, n3 + 1, 0x808080);
        int n10 = 0;
        String string2 = null;
        if (bl4) {
            n8 = 5;
            object = bl2 ? "Client out of date!" : "Server out of date!";
            string2 = this.server.playerList;
        } else if (this.server.field_78841_f && this.server.pingToServer != -2L) {
            n8 = this.server.pingToServer < 0L ? 5 : (this.server.pingToServer < 150L ? 0 : (this.server.pingToServer < 300L ? 1 : (this.server.pingToServer < 600L ? 2 : (this.server.pingToServer < 1000L ? 3 : 4))));
            if (this.server.pingToServer < 0L) {
                object = "(no connection)";
            } else {
                object = this.server.pingToServer + "ms";
                string2 = this.server.playerList;
            }
        } else {
            n10 = 1;
            n8 = (int)(Minecraft.getSystemTime() / 100L + (long)(n * 2) & 7L);
            if (n8 > 4) {
                n8 = 8 - n8;
            }
            object = "Pinging...";
        }
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(Gui.icons);
        Gui.drawModalRectWithCustomSizedTexture(n2 + n4 - 15, n3, n10 * 10, 176 + n8 * 8, 10, 8, 256.0f, 256.0f);
        if (this.server.getBase64EncodedIconData() != null && !this.server.getBase64EncodedIconData().equals(this.field_148299_g)) {
            this.field_148299_g = this.server.getBase64EncodedIconData();
            this.prepareServerIcon();
            this.owner.getServerList().saveServerList();
        }
        if (this.field_148305_h != null) {
            this.drawTextureAt(n2, n3, this.serverIcon);
        } else {
            this.drawTextureAt(n2, n3, UNKNOWN_SERVER);
        }
        int n11 = n6 - n2;
        int n12 = n7 - n3;
        if (n11 >= n4 - 15 && n11 <= n4 - 5 && n12 >= 0 && n12 <= 8) {
            this.owner.setHoveringText((String)object);
        } else if (n11 >= n4 - n9 - 15 - 2 && n11 <= n4 - 15 - 2 && n12 >= 0 && n12 <= 8) {
            this.owner.setHoveringText(string2);
        }
        if (this.mc.gameSettings.touchscreen || bl) {
            this.mc.getTextureManager().bindTexture(SERVER_SELECTION_BUTTONS);
            Gui.drawRect(n2, n3, n2 + 32, n3 + 32, -1601138544);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            int n13 = n6 - n2;
            int n14 = n7 - n3;
            if (this.func_178013_b()) {
                if (n13 < 32 && n13 > 16) {
                    Gui.drawModalRectWithCustomSizedTexture(n2, n3, 0.0f, 32.0f, 32, 32, 256.0f, 256.0f);
                } else {
                    Gui.drawModalRectWithCustomSizedTexture(n2, n3, 0.0f, 0.0f, 32, 32, 256.0f, 256.0f);
                }
            }
            if (this.owner.func_175392_a(this, n)) {
                if (n13 < 16 && n14 < 16) {
                    Gui.drawModalRectWithCustomSizedTexture(n2, n3, 96.0f, 32.0f, 32, 32, 256.0f, 256.0f);
                } else {
                    Gui.drawModalRectWithCustomSizedTexture(n2, n3, 96.0f, 0.0f, 32, 32, 256.0f, 256.0f);
                }
            }
            if (this.owner.func_175394_b(this, n)) {
                if (n13 < 16 && n14 > 16) {
                    Gui.drawModalRectWithCustomSizedTexture(n2, n3, 64.0f, 32.0f, 32, 32, 256.0f, 256.0f);
                } else {
                    Gui.drawModalRectWithCustomSizedTexture(n2, n3, 64.0f, 0.0f, 32, 32, 256.0f, 256.0f);
                }
            }
        }
    }

    protected void drawTextureAt(int n, int n2, ResourceLocation resourceLocation) {
        this.mc.getTextureManager().bindTexture(resourceLocation);
        GlStateManager.enableBlend();
        Gui.drawModalRectWithCustomSizedTexture(n, n2, 0.0f, 0.0f, 32, 32, 32.0f, 32.0f);
        GlStateManager.disableBlend();
    }

    private boolean func_178013_b() {
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void prepareServerIcon() {
        if (this.server.getBase64EncodedIconData() == null) {
            this.mc.getTextureManager().deleteTexture(this.serverIcon);
            this.field_148305_h = null;
        } else {
            BufferedImage bufferedImage;
            block8: {
                ByteBuf byteBuf = Unpooled.copiedBuffer(this.server.getBase64EncodedIconData(), Charsets.UTF_8);
                ByteBuf byteBuf2 = Base64.decode(byteBuf);
                try {
                    bufferedImage = TextureUtil.readBufferedImage(new ByteBufInputStream(byteBuf2));
                    Validate.validState(bufferedImage.getWidth() == 64, "Must be 64 pixels wide", new Object[0]);
                    Validate.validState(bufferedImage.getHeight() == 64, "Must be 64 pixels high", new Object[0]);
                    break block8;
                }
                catch (Throwable throwable) {
                    logger.error("Invalid icon for server " + this.server.serverName + " (" + this.server.serverIP + ")", throwable);
                    this.server.setBase64EncodedIconData(null);
                }
                finally {
                    byteBuf.release();
                    byteBuf2.release();
                }
                return;
            }
            if (this.field_148305_h == null) {
                this.field_148305_h = new DynamicTexture(bufferedImage.getWidth(), bufferedImage.getHeight());
                this.mc.getTextureManager().loadTexture(this.serverIcon, this.field_148305_h);
            }
            bufferedImage.getRGB(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight(), this.field_148305_h.getTextureData(), 0, bufferedImage.getWidth());
            this.field_148305_h.updateDynamicTexture();
        }
    }

    @Override
    public boolean mousePressed(int n, int n2, int n3, int n4, int n5, int n6) {
        if (n5 <= 32) {
            if (n5 < 32 && n5 > 16 && this.func_178013_b()) {
                this.owner.selectServer(n);
                this.owner.connectToSelected();
                return true;
            }
            if (n5 < 16 && n6 < 16 && this.owner.func_175392_a(this, n)) {
                this.owner.func_175391_a(this, n, GuiScreen.isShiftKeyDown());
                return true;
            }
            if (n5 < 16 && n6 > 16 && this.owner.func_175394_b(this, n)) {
                this.owner.func_175393_b(this, n, GuiScreen.isShiftKeyDown());
                return true;
            }
        }
        this.owner.selectServer(n);
        if (Minecraft.getSystemTime() - this.field_148298_f < 250L) {
            this.owner.connectToSelected();
        }
        this.field_148298_f = Minecraft.getSystemTime();
        return false;
    }

    @Override
    public void setSelected(int n, int n2, int n3) {
    }

    @Override
    public void mouseReleased(int n, int n2, int n3, int n4, int n5, int n6) {
    }

    public ServerData getServerData() {
        return this.server;
    }
}

