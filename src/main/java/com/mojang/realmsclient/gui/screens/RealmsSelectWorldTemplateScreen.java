/*
 * Decompiled with CFR 0.152.
 */
package com.mojang.realmsclient.gui.screens;

import com.mojang.realmsclient.client.RealmsClient;
import com.mojang.realmsclient.dto.WorldTemplate;
import com.mojang.realmsclient.exception.RealmsServiceException;
import com.mojang.realmsclient.gui.RealmsConstants;
import com.mojang.realmsclient.gui.screens.RealmsScreenWithCallback;
import com.mojang.realmsclient.util.RealmsTextureManager;
import com.mojang.realmsclient.util.RealmsUtil;
import java.util.Collections;
import java.util.List;
import net.minecraft.realms.Realms;
import net.minecraft.realms.RealmsButton;
import net.minecraft.realms.RealmsClickableScrolledSelectionList;
import net.minecraft.realms.RealmsDefaultVertexFormat;
import net.minecraft.realms.RealmsScreen;
import net.minecraft.realms.RealmsSharedConstants;
import net.minecraft.realms.Tezzelator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class RealmsSelectWorldTemplateScreen
extends RealmsScreen {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String LINK_ICON = "realms:textures/gui/realms/link_icons.png";
    private static final String TRAILER_ICON = "realms:textures/gui/realms/trailer_icons.png";
    private static final String SLOT_FRAME_LOCATION = "realms:textures/gui/realms/slot_frame.png";
    private final RealmsScreenWithCallback<WorldTemplate> lastScreen;
    private WorldTemplate selectedWorldTemplate;
    private List<WorldTemplate> templates = Collections.emptyList();
    private WorldTemplateSelectionList worldTemplateSelectionList;
    private int selectedTemplate = -1;
    private String title;
    private static final int BUTTON_BACK_ID = 0;
    private static final int BUTTON_SELECT_ID = 1;
    private RealmsButton selectButton;
    private String toolTip = null;
    private String currentLink = null;
    private boolean isMiniGame;
    private int clicks = 0;
    private String warning = null;
    private String warningURL = null;
    private boolean displayWarning = false;
    private boolean hoverWarning = false;

    public RealmsSelectWorldTemplateScreen(RealmsScreenWithCallback<WorldTemplate> realmsScreenWithCallback, WorldTemplate worldTemplate, boolean bl) {
        this.lastScreen = realmsScreenWithCallback;
        this.selectedWorldTemplate = worldTemplate;
        this.isMiniGame = bl;
        this.title = bl ? RealmsSelectWorldTemplateScreen.getLocalizedString("mco.template.title.minigame") : RealmsSelectWorldTemplateScreen.getLocalizedString("mco.template.title");
    }

    public RealmsSelectWorldTemplateScreen(RealmsScreenWithCallback<WorldTemplate> realmsScreenWithCallback, WorldTemplate worldTemplate, boolean bl, List<WorldTemplate> list) {
        this(realmsScreenWithCallback, worldTemplate, bl);
        this.templates = list;
    }

    public void setTitle(String string) {
        this.title = string;
    }

    public void setWarning(String string) {
        this.warning = string;
        this.displayWarning = true;
    }

    public void setWarningURL(String string) {
        this.warningURL = string;
    }

    @Override
    public void mouseClicked(int n, int n2, int n3) {
        if (this.hoverWarning && this.warningURL != null) {
            RealmsUtil.browseTo("https://beta.minecraft.net/realms/adventure-maps-in-1-9");
        }
    }

    @Override
    public void mouseEvent() {
        super.mouseEvent();
        this.worldTemplateSelectionList.mouseEvent();
    }

    @Override
    public void init() {
        Keyboard.enableRepeatEvents(true);
        this.buttonsClear();
        this.worldTemplateSelectionList = new WorldTemplateSelectionList();
        if (this.templates.size() == 0) {
            final boolean bl = this.isMiniGame;
            new Thread("Realms-minigame-fetcher"){

                @Override
                public void run() {
                    RealmsClient realmsClient = RealmsClient.createRealmsClient();
                    try {
                        if (bl) {
                            RealmsSelectWorldTemplateScreen.this.templates = realmsClient.fetchMinigames().templates;
                        } else {
                            RealmsSelectWorldTemplateScreen.this.templates = realmsClient.fetchWorldTemplates().templates;
                        }
                    }
                    catch (RealmsServiceException realmsServiceException) {
                        LOGGER.error("Couldn't fetch templates");
                    }
                }
            }.start();
        }
        this.buttonsAdd(RealmsSelectWorldTemplateScreen.newButton(0, this.width() / 2 + 6, this.height() - 32, 153, 20, this.isMiniGame ? RealmsSelectWorldTemplateScreen.getLocalizedString("gui.cancel") : RealmsSelectWorldTemplateScreen.getLocalizedString("gui.back")));
        this.selectButton = RealmsSelectWorldTemplateScreen.newButton(1, this.width() / 2 - 154, this.height() - 32, 153, 20, RealmsSelectWorldTemplateScreen.getLocalizedString("mco.template.button.select"));
        this.buttonsAdd(this.selectButton);
        this.selectButton.active(false);
    }

    @Override
    public void tick() {
        super.tick();
        --this.clicks;
        if (this.clicks < 0) {
            this.clicks = 0;
        }
    }

    @Override
    public void buttonClicked(RealmsButton realmsButton) {
        if (!realmsButton.active()) {
            return;
        }
        switch (realmsButton.id()) {
            case 0: {
                this.backButtonClicked();
                break;
            }
            case 1: {
                this.selectTemplate();
                break;
            }
            default: {
                return;
            }
        }
    }

    @Override
    public void keyPressed(char c, int n) {
        switch (n) {
            case 1: {
                this.backButtonClicked();
                break;
            }
            case 200: {
                if (this.selectedTemplate != -1) {
                    int n2 = this.selectedTemplate;
                    if (n2 == 0) {
                        this.worldTemplateSelectionList.scroll(0 - this.worldTemplateSelectionList.getScroll());
                        return;
                    }
                    int n3 = n2 - 1;
                    if (n3 > -1) {
                        this.selectedTemplate = n3;
                        int n4 = Math.max(0, this.worldTemplateSelectionList.getMaxPosition() - (this.height() - 40 - (this.displayWarning ? RealmsConstants.row(1) : 32) - 4));
                        int n5 = (int)Math.floor((this.height() - 40 - (this.displayWarning ? RealmsConstants.row(1) : 32)) / 46);
                        int n6 = this.worldTemplateSelectionList.getScroll();
                        int n7 = (int)Math.ceil((float)n6 / 46.0f);
                        int n8 = n4 / this.templates.size();
                        int n9 = n8 * n3;
                        int n10 = n9 - this.worldTemplateSelectionList.getScroll();
                        if (n3 < n7 || n3 > n7 + n5) {
                            this.worldTemplateSelectionList.scroll(n10);
                        }
                        return;
                    }
                }
                this.selectedTemplate = 0;
                this.worldTemplateSelectionList.scroll(0 - this.worldTemplateSelectionList.getScroll());
                break;
            }
            case 208: {
                if (this.selectedTemplate != -1) {
                    int n11 = this.selectedTemplate;
                    int n12 = Math.max(0, this.worldTemplateSelectionList.getMaxPosition() - (this.height() - 40 - (this.displayWarning ? RealmsConstants.row(1) : 32)));
                    if (n11 == this.templates.size() - 1) {
                        this.worldTemplateSelectionList.scroll(n12 - this.worldTemplateSelectionList.getScroll() + 46);
                        return;
                    }
                    int n13 = n11 + 1;
                    if (n13 == this.templates.size() - 1) {
                        this.selectedTemplate = n13;
                        this.worldTemplateSelectionList.scroll(n12 - this.worldTemplateSelectionList.getScroll() + 46);
                        return;
                    }
                    if (n13 < this.templates.size()) {
                        this.selectedTemplate = n13;
                        int n14 = (int)Math.floor((this.height() - 40 - (this.displayWarning ? RealmsConstants.row(1) : 32)) / 46);
                        int n15 = this.worldTemplateSelectionList.getScroll();
                        int n16 = (int)Math.ceil((float)n15 / 46.0f);
                        int n17 = n12 / this.templates.size();
                        int n18 = n17 * n13;
                        int n19 = n18 - this.worldTemplateSelectionList.getScroll();
                        if (n19 > 0) {
                            n19 += n17;
                        }
                        if (n13 < n16 || n13 >= n16 + n14) {
                            this.worldTemplateSelectionList.scroll(n19);
                        }
                        return;
                    }
                }
                this.selectedTemplate = 0;
                this.worldTemplateSelectionList.scroll(-(this.worldTemplateSelectionList.getItemCount() * 46));
                break;
            }
            case 28: 
            case 156: {
                this.selectTemplate();
            }
        }
    }

    private void backButtonClicked() {
        this.lastScreen.callback(null);
        Realms.setScreen(this.lastScreen);
    }

    private void selectTemplate() {
        if (this.selectedTemplate >= 0 && this.selectedTemplate < this.templates.size()) {
            WorldTemplate worldTemplate = this.templates.get(this.selectedTemplate);
            worldTemplate.setMinigame(this.isMiniGame);
            this.lastScreen.callback(worldTemplate);
        }
    }

    @Override
    public void render(int n, int n2, float f) {
        this.toolTip = null;
        this.currentLink = null;
        this.hoverWarning = false;
        this.renderBackground();
        this.worldTemplateSelectionList.render(n, n2, f);
        this.drawCenteredString(this.title, this.width() / 2, 13, 0xFFFFFF);
        if (this.displayWarning) {
            int n3;
            int n4;
            String[] stringArray = this.warning.split("\\\\n");
            for (n4 = 0; n4 < stringArray.length; ++n4) {
                int n5 = this.fontWidth(stringArray[n4]);
                n3 = this.width() / 2 - n5 / 2;
                int n6 = RealmsConstants.row(-1 + n4);
                if (n < n3 || n > n3 + n5 || n2 < n6 || n2 > n6 + this.fontLineHeight()) continue;
                this.hoverWarning = true;
            }
            for (n4 = 0; n4 < stringArray.length; ++n4) {
                String string = stringArray[n4];
                n3 = 0xA0A0A0;
                if (this.warningURL != null) {
                    if (this.hoverWarning) {
                        n3 = 7107012;
                        string = "\u00a7n" + string;
                    } else {
                        n3 = 0x3366BB;
                    }
                }
                this.drawCenteredString(string, this.width() / 2, RealmsConstants.row(-1 + n4), n3);
            }
        }
        super.render(n, n2, f);
        if (this.toolTip != null) {
            this.renderMousehoverTooltip(this.toolTip, n, n2);
        }
    }

    protected void renderMousehoverTooltip(String string, int n, int n2) {
        if (string == null) {
            return;
        }
        int n3 = n + 12;
        int n4 = n2 - 12;
        int n5 = this.fontWidth(string);
        this.fillGradient(n3 - 3, n4 - 3, n3 + n5 + 3, n4 + 8 + 3, -1073741824, -1073741824);
        this.fontDrawShadow(string, n3, n4, 0xFFFFFF);
    }

    private class WorldTemplateSelectionList
    extends RealmsClickableScrolledSelectionList {
        public WorldTemplateSelectionList() {
            super(RealmsSelectWorldTemplateScreen.this.width(), RealmsSelectWorldTemplateScreen.this.height(), RealmsSelectWorldTemplateScreen.this.displayWarning ? RealmsConstants.row(1) : 32, RealmsSelectWorldTemplateScreen.this.height() - 40, 46);
        }

        @Override
        public int getItemCount() {
            return RealmsSelectWorldTemplateScreen.this.templates.size();
        }

        @Override
        public void customMouseEvent(int n, int n2, int n3, float f, int n4) {
            if (Mouse.isButtonDown(0) && this.ym() >= n && this.ym() <= n2) {
                int n5 = this.width() / 2 - 150;
                int n6 = this.width();
                int n7 = this.ym() - n - n3 + (int)f - 4;
                int n8 = n7 / n4;
                if (this.xm() >= n5 && this.xm() <= n6 && n8 >= 0 && n7 >= 0 && n8 < this.getItemCount()) {
                    this.itemClicked(n7, n8, this.xm(), this.ym(), this.width());
                    if (n8 >= RealmsSelectWorldTemplateScreen.this.templates.size()) {
                        return;
                    }
                    RealmsSelectWorldTemplateScreen.this.selectButton.active(true);
                    RealmsSelectWorldTemplateScreen.this.selectedTemplate = n8;
                    RealmsSelectWorldTemplateScreen.this.selectedWorldTemplate = null;
                    RealmsSelectWorldTemplateScreen.this.clicks = RealmsSelectWorldTemplateScreen.this.clicks + (RealmsSharedConstants.TICKS_PER_SECOND / 3 + 1);
                    if (RealmsSelectWorldTemplateScreen.this.clicks >= RealmsSharedConstants.TICKS_PER_SECOND / 2) {
                        RealmsSelectWorldTemplateScreen.this.selectTemplate();
                    }
                }
            }
        }

        @Override
        public boolean isSelectedItem(int n) {
            if (RealmsSelectWorldTemplateScreen.this.templates.size() == 0) {
                return false;
            }
            if (n >= RealmsSelectWorldTemplateScreen.this.templates.size()) {
                return false;
            }
            if (RealmsSelectWorldTemplateScreen.this.selectedWorldTemplate != null) {
                boolean bl = ((RealmsSelectWorldTemplateScreen)RealmsSelectWorldTemplateScreen.this).selectedWorldTemplate.name.equals(((WorldTemplate)((RealmsSelectWorldTemplateScreen)RealmsSelectWorldTemplateScreen.this).templates.get((int)n)).name);
                if (bl) {
                    RealmsSelectWorldTemplateScreen.this.selectedTemplate = n;
                }
                return bl;
            }
            return n == RealmsSelectWorldTemplateScreen.this.selectedTemplate;
        }

        @Override
        public void itemClicked(int n, int n2, int n3, int n4, int n5) {
            if (n2 >= RealmsSelectWorldTemplateScreen.this.templates.size()) {
                return;
            }
            if (RealmsSelectWorldTemplateScreen.this.currentLink != null) {
                RealmsUtil.browseTo(RealmsSelectWorldTemplateScreen.this.currentLink);
            }
        }

        @Override
        public int getMaxPosition() {
            return this.getItemCount() * 46;
        }

        @Override
        public void renderBackground() {
            RealmsSelectWorldTemplateScreen.this.renderBackground();
        }

        @Override
        public void renderItem(int n, int n2, int n3, int n4, int n5, int n6) {
            if (n < RealmsSelectWorldTemplateScreen.this.templates.size()) {
                this.renderWorldTemplateItem(n, n2, n3, n4);
            }
        }

        @Override
        public int getScrollbarPosition() {
            return super.getScrollbarPosition() + 30;
        }

        @Override
        public void renderSelected(int n, int n2, int n3, Tezzelator tezzelator) {
            int n4 = this.getScrollbarPosition() - 290;
            int n5 = this.getScrollbarPosition() - 10;
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            GL11.glDisable(3553);
            tezzelator.begin(7, RealmsDefaultVertexFormat.POSITION_TEX_COLOR);
            tezzelator.vertex(n4, n2 + n3 + 2, 0.0).tex(0.0, 1.0).color(128, 128, 128, 255).endVertex();
            tezzelator.vertex(n5, n2 + n3 + 2, 0.0).tex(1.0, 1.0).color(128, 128, 128, 255).endVertex();
            tezzelator.vertex(n5, n2 - 2, 0.0).tex(1.0, 0.0).color(128, 128, 128, 255).endVertex();
            tezzelator.vertex(n4, n2 - 2, 0.0).tex(0.0, 0.0).color(128, 128, 128, 255).endVertex();
            tezzelator.vertex(n4 + 1, n2 + n3 + 1, 0.0).tex(0.0, 1.0).color(0, 0, 0, 255).endVertex();
            tezzelator.vertex(n5 - 1, n2 + n3 + 1, 0.0).tex(1.0, 1.0).color(0, 0, 0, 255).endVertex();
            tezzelator.vertex(n5 - 1, n2 - 1, 0.0).tex(1.0, 0.0).color(0, 0, 0, 255).endVertex();
            tezzelator.vertex(n4 + 1, n2 - 1, 0.0).tex(0.0, 0.0).color(0, 0, 0, 255).endVertex();
            tezzelator.end();
            GL11.glEnable(3553);
        }

        private void renderWorldTemplateItem(int n, int n2, int n3, int n4) {
            WorldTemplate worldTemplate = (WorldTemplate)RealmsSelectWorldTemplateScreen.this.templates.get(n);
            int n5 = n2 + 20;
            RealmsSelectWorldTemplateScreen.this.drawString(worldTemplate.name, n5, n3 + 2, 0xFFFFFF);
            RealmsSelectWorldTemplateScreen.this.drawString(worldTemplate.author, n5, n3 + 15, 0x6C6C6C);
            RealmsSelectWorldTemplateScreen.this.drawString(worldTemplate.version, n5 + 227 - RealmsSelectWorldTemplateScreen.this.fontWidth(worldTemplate.version), n3 + 1, 0x6C6C6C);
            if (!(worldTemplate.link.equals("") && worldTemplate.trailer.equals("") && worldTemplate.recommendedPlayers.equals(""))) {
                this.drawIcons(n5 - 1, n3 + 25, this.xm(), this.ym(), worldTemplate.link, worldTemplate.trailer, worldTemplate.recommendedPlayers);
            }
            this.drawImage(n2 - 25, n3 + 1, this.xm(), this.ym(), worldTemplate);
        }

        private void drawImage(int n, int n2, int n3, int n4, WorldTemplate worldTemplate) {
            RealmsTextureManager.bindWorldTemplate(worldTemplate.id, worldTemplate.image);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            RealmsScreen.blit(n + 1, n2 + 1, 0.0f, 0.0f, 38, 38, 38.0f, 38.0f);
            RealmsScreen.bind(RealmsSelectWorldTemplateScreen.SLOT_FRAME_LOCATION);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            RealmsScreen.blit(n, n2, 0.0f, 0.0f, 40, 40, 40.0f, 40.0f);
        }

        private void drawIcons(int n, int n2, int n3, int n4, String string, String string2, String string3) {
            int n5;
            boolean bl = false;
            boolean bl2 = false;
            if (!string3.equals("")) {
                RealmsSelectWorldTemplateScreen.this.drawString(string3, n, n2 + 4, 0x4C4C4C);
            }
            int n6 = n5 = string3.equals("") ? 0 : RealmsSelectWorldTemplateScreen.this.fontWidth(string3) + 2;
            if (n3 >= n + n5 && n3 <= n + n5 + 32 && n4 >= n2 && n4 <= n2 + 15 && n4 < RealmsSelectWorldTemplateScreen.this.height() - 15 && n4 > 32) {
                if (n3 <= n + 15 + n5 && n3 > n5) {
                    if (!string.equals("")) {
                        bl = true;
                    } else {
                        bl2 = true;
                    }
                } else if (!string.equals("")) {
                    bl2 = true;
                }
            }
            if (!string.equals("")) {
                RealmsScreen.bind(RealmsSelectWorldTemplateScreen.LINK_ICON);
                GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                GL11.glPushMatrix();
                GL11.glScalef(1.0f, 1.0f, 1.0f);
                RealmsScreen.blit(n + n5, n2, bl ? 15.0f : 0.0f, 0.0f, 15, 15, 30.0f, 15.0f);
                GL11.glPopMatrix();
            }
            if (!string2.equals("")) {
                RealmsScreen.bind(RealmsSelectWorldTemplateScreen.TRAILER_ICON);
                GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                GL11.glPushMatrix();
                GL11.glScalef(1.0f, 1.0f, 1.0f);
                RealmsScreen.blit(n + n5 + (string.equals("") ? 0 : 17), n2, bl2 ? 15.0f : 0.0f, 0.0f, 15, 15, 30.0f, 15.0f);
                GL11.glPopMatrix();
            }
            if (bl && !string.equals("")) {
                RealmsSelectWorldTemplateScreen.this.toolTip = RealmsScreen.getLocalizedString("mco.template.info.tooltip");
                RealmsSelectWorldTemplateScreen.this.currentLink = string;
            } else if (bl2 && !string2.equals("")) {
                RealmsSelectWorldTemplateScreen.this.toolTip = RealmsScreen.getLocalizedString("mco.template.trailer.tooltip");
                RealmsSelectWorldTemplateScreen.this.currentLink = string2;
            }
        }
    }
}

