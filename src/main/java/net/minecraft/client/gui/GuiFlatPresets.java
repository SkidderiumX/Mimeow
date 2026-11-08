/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiCreateFlatWorld;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSlot;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.resources.I18n;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.FlatGeneratorInfo;
import net.minecraft.world.gen.FlatLayerInfo;
import org.lwjgl.input.Keyboard;

public class GuiFlatPresets
extends GuiScreen {
    private static final List<LayerItem> FLAT_WORLD_PRESETS = Lists.newArrayList();
    private final GuiCreateFlatWorld parentScreen;
    private String presetsTitle;
    private String presetsShare;
    private String field_146436_r;
    private ListSlot field_146435_s;
    private GuiButton field_146434_t;
    private GuiTextField field_146433_u;

    public GuiFlatPresets(GuiCreateFlatWorld guiCreateFlatWorld) {
        this.parentScreen = guiCreateFlatWorld;
    }

    @Override
    public void initGui() {
        this.buttonList.clear();
        Keyboard.enableRepeatEvents(true);
        this.presetsTitle = I18n.format("createWorld.customize.presets.title", new Object[0]);
        this.presetsShare = I18n.format("createWorld.customize.presets.share", new Object[0]);
        this.field_146436_r = I18n.format("createWorld.customize.presets.list", new Object[0]);
        this.field_146433_u = new GuiTextField(2, this.fontRendererObj, 50, 40, this.width - 100, 20);
        this.field_146435_s = new ListSlot();
        this.field_146433_u.setMaxStringLength(1230);
        this.field_146433_u.setText(this.parentScreen.func_146384_e());
        this.field_146434_t = new GuiButton(0, this.width / 2 - 155, this.height - 28, 150, 20, I18n.format("createWorld.customize.presets.select", new Object[0]));
        this.buttonList.add(this.field_146434_t);
        this.buttonList.add(new GuiButton(1, this.width / 2 + 5, this.height - 28, 150, 20, I18n.format("gui.cancel", new Object[0])));
        this.func_146426_g();
    }

    @Override
    public void handleMouseInput() throws IOException {
        super.handleMouseInput();
        this.field_146435_s.handleMouseInput();
    }

    @Override
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
    }

    @Override
    protected void mouseClicked(int n, int n2, int n3) throws IOException {
        this.field_146433_u.mouseClicked(n, n2, n3);
        super.mouseClicked(n, n2, n3);
    }

    @Override
    protected void keyTyped(char c, int n) throws IOException {
        if (!this.field_146433_u.textboxKeyTyped(c, n)) {
            super.keyTyped(c, n);
        }
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) throws IOException {
        if (guiButton.id == 0 && this.func_146430_p()) {
            this.parentScreen.func_146383_a(this.field_146433_u.getText());
            this.mc.displayGuiScreen(this.parentScreen);
        } else if (guiButton.id == 1) {
            this.mc.displayGuiScreen(this.parentScreen);
        }
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.drawDefaultBackground();
        this.field_146435_s.drawScreen(n, n2, f);
        this.drawCenteredString(this.fontRendererObj, this.presetsTitle, this.width / 2, 8, 0xFFFFFF);
        this.drawString(this.fontRendererObj, this.presetsShare, 50, 30, 0xA0A0A0);
        this.drawString(this.fontRendererObj, this.field_146436_r, 50, 70, 0xA0A0A0);
        this.field_146433_u.drawTextBox();
        super.drawScreen(n, n2, f);
    }

    @Override
    public void updateScreen() {
        this.field_146433_u.updateCursorCounter();
        super.updateScreen();
    }

    public void func_146426_g() {
        boolean bl;
        this.field_146434_t.enabled = bl = this.func_146430_p();
    }

    private boolean func_146430_p() {
        return this.field_146435_s.field_148175_k > -1 && this.field_146435_s.field_148175_k < FLAT_WORLD_PRESETS.size() || this.field_146433_u.getText().length() > 1;
    }

    private static void func_146425_a(String string, Item item, BiomeGenBase biomeGenBase, FlatLayerInfo ... flatLayerInfoArray) {
        GuiFlatPresets.func_175354_a(string, item, 0, biomeGenBase, null, flatLayerInfoArray);
    }

    private static void func_146421_a(String string, Item item, BiomeGenBase biomeGenBase, List<String> list, FlatLayerInfo ... flatLayerInfoArray) {
        GuiFlatPresets.func_175354_a(string, item, 0, biomeGenBase, list, flatLayerInfoArray);
    }

    private static void func_175354_a(String string, Item item, int n, BiomeGenBase biomeGenBase, List<String> list, FlatLayerInfo ... flatLayerInfoArray) {
        FlatGeneratorInfo flatGeneratorInfo = new FlatGeneratorInfo();
        for (int i = flatLayerInfoArray.length - 1; i >= 0; --i) {
            flatGeneratorInfo.getFlatLayers().add(flatLayerInfoArray[i]);
        }
        flatGeneratorInfo.setBiome(biomeGenBase.biomeID);
        flatGeneratorInfo.func_82645_d();
        if (list != null) {
            for (String string2 : list) {
                flatGeneratorInfo.getWorldFeatures().put(string2, Maps.newHashMap());
            }
        }
        FLAT_WORLD_PRESETS.add(new LayerItem(item, n, string, flatGeneratorInfo.toString()));
    }

    static {
        GuiFlatPresets.func_146421_a("Classic Flat", Item.getItemFromBlock(Blocks.grass), BiomeGenBase.plains, Arrays.asList("village"), new FlatLayerInfo(1, Blocks.grass), new FlatLayerInfo(2, Blocks.dirt), new FlatLayerInfo(1, Blocks.bedrock));
        GuiFlatPresets.func_146421_a("Tunnelers' Dream", Item.getItemFromBlock(Blocks.stone), BiomeGenBase.extremeHills, Arrays.asList("biome_1", "dungeon", "decoration", "stronghold", "mineshaft"), new FlatLayerInfo(1, Blocks.grass), new FlatLayerInfo(5, Blocks.dirt), new FlatLayerInfo(230, Blocks.stone), new FlatLayerInfo(1, Blocks.bedrock));
        GuiFlatPresets.func_146421_a("Water World", Items.water_bucket, BiomeGenBase.deepOcean, Arrays.asList("biome_1", "oceanmonument"), new FlatLayerInfo(90, Blocks.water), new FlatLayerInfo(5, Blocks.sand), new FlatLayerInfo(5, Blocks.dirt), new FlatLayerInfo(5, Blocks.stone), new FlatLayerInfo(1, Blocks.bedrock));
        GuiFlatPresets.func_175354_a("Overworld", Item.getItemFromBlock(Blocks.tallgrass), BlockTallGrass.EnumType.GRASS.getMeta(), BiomeGenBase.plains, Arrays.asList("village", "biome_1", "decoration", "stronghold", "mineshaft", "dungeon", "lake", "lava_lake"), new FlatLayerInfo(1, Blocks.grass), new FlatLayerInfo(3, Blocks.dirt), new FlatLayerInfo(59, Blocks.stone), new FlatLayerInfo(1, Blocks.bedrock));
        GuiFlatPresets.func_146421_a("Snowy Kingdom", Item.getItemFromBlock(Blocks.snow_layer), BiomeGenBase.icePlains, Arrays.asList("village", "biome_1"), new FlatLayerInfo(1, Blocks.snow_layer), new FlatLayerInfo(1, Blocks.grass), new FlatLayerInfo(3, Blocks.dirt), new FlatLayerInfo(59, Blocks.stone), new FlatLayerInfo(1, Blocks.bedrock));
        GuiFlatPresets.func_146421_a("Bottomless Pit", Items.feather, BiomeGenBase.plains, Arrays.asList("village", "biome_1"), new FlatLayerInfo(1, Blocks.grass), new FlatLayerInfo(3, Blocks.dirt), new FlatLayerInfo(2, Blocks.cobblestone));
        GuiFlatPresets.func_146421_a("Desert", Item.getItemFromBlock(Blocks.sand), BiomeGenBase.desert, Arrays.asList("village", "biome_1", "decoration", "stronghold", "mineshaft", "dungeon"), new FlatLayerInfo(8, Blocks.sand), new FlatLayerInfo(52, Blocks.sandstone), new FlatLayerInfo(3, Blocks.stone), new FlatLayerInfo(1, Blocks.bedrock));
        GuiFlatPresets.func_146425_a("Redstone Ready", Items.redstone, BiomeGenBase.desert, new FlatLayerInfo(52, Blocks.sandstone), new FlatLayerInfo(3, Blocks.stone), new FlatLayerInfo(1, Blocks.bedrock));
    }

    public class ListSlot
    extends GuiSlot {
        public int field_148175_k;

        public ListSlot() {
            super(GuiFlatPresets.this.mc, GuiFlatPresets.this.width, GuiFlatPresets.this.height, 80, GuiFlatPresets.this.height - 37, 24);
            this.field_148175_k = -1;
        }

        private void func_178054_a(int n, int n2, Item item, int n3) {
            this.func_148173_e(n + 1, n2 + 1);
            GlStateManager.enableRescaleNormal();
            RenderHelper.enableGUIStandardItemLighting();
            GuiFlatPresets.this.itemRender.renderItemIntoGUI(new ItemStack(item, 1, n3), n + 2, n2 + 2);
            RenderHelper.disableStandardItemLighting();
            GlStateManager.disableRescaleNormal();
        }

        private void func_148173_e(int n, int n2) {
            this.func_148171_c(n, n2, 0, 0);
        }

        private void func_148171_c(int n, int n2, int n3, int n4) {
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            this.mc.getTextureManager().bindTexture(Gui.statIcons);
            float f = 0.0078125f;
            float f2 = 0.0078125f;
            int n5 = 18;
            int n6 = 18;
            Tessellator tessellator = Tessellator.getInstance();
            WorldRenderer worldRenderer = tessellator.getWorldRenderer();
            worldRenderer.begin(7, DefaultVertexFormats.POSITION_TEX);
            worldRenderer.pos(n + 0, n2 + 18, GuiFlatPresets.this.zLevel).tex((float)(n3 + 0) * 0.0078125f, (float)(n4 + 18) * 0.0078125f).endVertex();
            worldRenderer.pos(n + 18, n2 + 18, GuiFlatPresets.this.zLevel).tex((float)(n3 + 18) * 0.0078125f, (float)(n4 + 18) * 0.0078125f).endVertex();
            worldRenderer.pos(n + 18, n2 + 0, GuiFlatPresets.this.zLevel).tex((float)(n3 + 18) * 0.0078125f, (float)(n4 + 0) * 0.0078125f).endVertex();
            worldRenderer.pos(n + 0, n2 + 0, GuiFlatPresets.this.zLevel).tex((float)(n3 + 0) * 0.0078125f, (float)(n4 + 0) * 0.0078125f).endVertex();
            tessellator.draw();
        }

        @Override
        protected int getSize() {
            return FLAT_WORLD_PRESETS.size();
        }

        @Override
        protected void elementClicked(int n, boolean bl, int n2, int n3) {
            this.field_148175_k = n;
            GuiFlatPresets.this.func_146426_g();
            GuiFlatPresets.this.field_146433_u.setText(GuiFlatPresets.FLAT_WORLD_PRESETS.get((int)GuiFlatPresets.this.field_146435_s.field_148175_k).field_148233_c);
        }

        @Override
        protected boolean isSelected(int n) {
            return n == this.field_148175_k;
        }

        @Override
        protected void drawBackground() {
        }

        @Override
        protected void drawSlot(int n, int n2, int n3, int n4, int n5, int n6) {
            LayerItem layerItem = FLAT_WORLD_PRESETS.get(n);
            this.func_178054_a(n2, n3, layerItem.field_148234_a, layerItem.field_179037_b);
            GuiFlatPresets.this.fontRendererObj.drawString(layerItem.field_148232_b, n2 + 18 + 5, n3 + 6, 0xFFFFFF);
        }
    }

    public static class LayerItem {
        public Item field_148234_a;
        public int field_179037_b;
        public String field_148232_b;
        public String field_148233_c;

        public LayerItem(Item item, int n, String string, String string2) {
            this.field_148234_a = item;
            this.field_179037_b = n;
            this.field_148232_b = string;
            this.field_148233_c = string2;
        }
    }
}

