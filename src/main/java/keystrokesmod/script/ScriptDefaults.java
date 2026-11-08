/*
 * Decompiled with CFR 0.152.
 */
package keystrokesmod.script;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import keystrokesmod.oc502dfc7784;
import keystrokesmod.script.ClientEntityManager;
import keystrokesmod.script.Script;
import keystrokesmod.script.ScriptManager;
import keystrokesmod.script.model.Block;
import keystrokesmod.script.model.Bridge;
import keystrokesmod.script.model.Entity;
import keystrokesmod.script.model.Image;
import keystrokesmod.script.model.ItemStack;
import keystrokesmod.script.model.Message;
import keystrokesmod.script.model.NetworkPlayer;
import keystrokesmod.script.model.PlayerState;
import keystrokesmod.script.model.TileEntity;
import keystrokesmod.script.model.Vec3;
import keystrokesmod.script.packet.clientbound.SPacket;
import keystrokesmod.script.packet.serverbound.CPacket;
import keystrokesmod.script.packet.serverbound.PacketHandler;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiScreenBook;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiContainerCreative;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.texture.AbstractTexture;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.resources.ResourcePackRepository;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.inventory.ContainerWorkbench;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemBlock;
import net.minecraft.network.Packet;
import net.minecraft.realms.RealmsBridge;
import net.minecraft.scoreboard.Team;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import x.N;
import x.ReflectionUtils;
import x.W;
import x.oc170ea29aae;
import x.oc192c7e4083;
import x.oc1b46ea259e;
import x.oc24a0a5bddf;
import x.oc29a4412fc2;
import x.oc2c25634a7e;
import x.oc2cf3d80e17;
import x.oc3542cefbeb;
import x.oc3c7a892f2f;
import x.oc4d46a99983;
import x.oc69da1aa7f5;
import x.oc75d51ec7eb;
import x.oc7ab2161b9f;
import x.oc8ccd9c3f55;
import x.oc9755810e45;
import x.oca633d4a05c;
import x.oca9cc61aada;
import x.ocaa9a64f047;
import x.ocb23d192a35;
import x.ocbb165642ef;
import x.ocbd4917c4b1;
import x.occ2f8dff8d8;
import x.occ39d36078d;
import x.occb1ed1ed8f;
import x.occc831eff22;
import x.ocd6ae010123;
import x.ocdd342096f8;
import x.ocebe35f25d6;

public class ScriptDefaults {
    private static ExecutorService cachedExecutor;
    public static final Minecraft mc;
    public static final Bridge bridge;
    private static volatile Map<String, oc69da1aa7f5> modulesMap;

    public static long timeMillis() {
        return System.currentTimeMillis();
    }

    public static void reloadModules() {
        Object object;
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
        oc9755810e45 oc9755810e452 = oc2cf3d80e17.\u00f3();
        if (oc9755810e452 != null) {
            object = oc9755810e452.\u057f().iterator();
            while (object.hasNext()) {
                oc69da1aa7f5 oc69da1aa7f52 = (oc69da1aa7f5)object.next();
                linkedHashMap.put(oc69da1aa7f52.z$3i8m9vxwuvqj0(), oc69da1aa7f52);
            }
        }
        Object object2 = object = oc2cf3d80e17.\u013e != null ? oc2cf3d80e17.\u013e : oc502dfc7784.\u04a3;
        if (object != null) {
            for (oc69da1aa7f5 oc69da1aa7f53 : ((ScriptManager)object).scripts.values()) {
                linkedHashMap.put(oc69da1aa7f53.z$3i8m9vxwuvqj0(), oc69da1aa7f53);
                linkedHashMap.put("sc-" + oc69da1aa7f53.z$3i8m9vxwuvqj0(), oc69da1aa7f53);
                linkedHashMap.put("script:" + oc69da1aa7f53.z$3i8m9vxwuvqj0(), oc69da1aa7f53);
            }
        }
        modulesMap = Collections.unmodifiableMap(linkedHashMap);
    }

    static {
        mc = Minecraft.getMinecraft();
        bridge = new Bridge();
        modulesMap = Collections.emptyMap();
    }

    public static class util {
        public static final String colorSymbol = "\u00a7";

        public static String color(String string) {
            return oc7ab2161b9f.\u012c(string);
        }

        public static String strip(String string) {
            return oc7ab2161b9f.\u045b(string);
        }

        public static double round(double d, int n) {
            return oc7ab2161b9f.\u025c(d, n);
        }

        public static int randomInt(int n, int n2) {
            return oc7ab2161b9f.\u0565(n, n2);
        }

        public static double randomDouble(double d, double d2) {
            return oc7ab2161b9f.t(d, d2);
        }
    }

    public static class keybinds {
        public static int[] getMousePosition() {
            int[] nArray = new int[0x6C55DB8D ^ 0x6C55DB8F];
            nArray[0] = Mouse.getX();
            nArray[1] = Mouse.getY();
            return nArray;
        }

        public static boolean isPressed(String string) {
            KeyBinding keyBinding = ReflectionUtils.keybinds.get(string);
            return keyBinding != null && keyBinding.isKeyDown();
        }

        public static void setPressed(String string, boolean bl) {
            KeyBinding keyBinding = ReflectionUtils.keybinds.get(string);
            if (keyBinding != null) {
                KeyBinding.setKeyBindState(keyBinding.getKeyCode(), bl);
            }
        }

        public static void onTick(String string) {
            KeyBinding keyBinding = ReflectionUtils.keybinds.get(string);
            if (keyBinding != null) {
                KeyBinding.onTick(keyBinding.getKeyCode());
            }
        }

        public static int getKeyCode(String string) {
            KeyBinding keyBinding = ReflectionUtils.keybinds.get(string);
            if (keyBinding != null) {
                return keyBinding.getKeyCode();
            }
            return -1;
        }

        public static int getKeycode(String string) {
            return keybinds.getKeyCode(string);
        }

        public static int getKeyIndex(String string) {
            return Keyboard.getKeyIndex(string);
        }

        public static boolean isMouseDown(int n) {
            return Mouse.isButtonDown(n);
        }

        public static boolean isKeyDown(int n) {
            return Keyboard.isKeyDown(n);
        }

        public static void rightClick() {
            mc.callRightClickMouse();
        }

        public static void leftClick() {
            mc.callClickMouse();
        }

        public static int getScroll() {
            return Mouse.getDWheel();
        }
    }

    public static class invntory
    extends inventory {
    }

    public static class inventory {
        public static int getSlot() {
            return ScriptDefaults.mc.thePlayer.inventory.currentItem;
        }

        public static void setSlot(int n) {
            ScriptDefaults.mc.thePlayer.inventory.currentItem = n;
        }

        public static void click(int n, int n2, int n3) {
            ScriptDefaults.mc.playerController.windowClick(ScriptDefaults.mc.thePlayer.openContainer.windowId, n, n2, n3, ScriptDefaults.mc.thePlayer);
        }

        public static List<String> getBookContents() {
            if (ScriptDefaults.mc.currentScreen instanceof GuiScreenBook) {
                ArrayList<String> arrayList = new ArrayList<String>();
                List<IChatComponent> list = ((oca633d4a05c)((Object)ScriptDefaults.mc.currentScreen)).getBookContents();
                if (list == null) {
                    return arrayList;
                }
                int n = Math.min((0x2C525ACF ^ 0x2C525A4F) / ScriptDefaults.mc.fontRendererObj.FONT_HEIGHT, list.size());
                for (int i = 0; i < n; ++i) {
                    IChatComponent iChatComponent = list.get(i);
                    arrayList.add(iChatComponent.getUnformattedText());
                }
                if (!arrayList.isEmpty()) {
                    return arrayList;
                }
            }
            return null;
        }

        public static String getChest() {
            if (ScriptDefaults.mc.thePlayer.openContainer instanceof ContainerChest) {
                ContainerChest containerChest = (ContainerChest)ScriptDefaults.mc.thePlayer.openContainer;
                if (containerChest == null) {
                    return "";
                }
                return containerChest.getLowerChestInventory().getDisplayName().getUnformattedText();
            }
            return "";
        }

        public static String getContainer() {
            if (ScriptDefaults.mc.currentScreen instanceof GuiContainerCreative) {
                CreativeTabs creativeTabs = CreativeTabs.creativeTabArray[((GuiContainerCreative)ScriptDefaults.mc.currentScreen).getSelectedTabIndex()];
                if (creativeTabs != null) {
                    return I18n.format(creativeTabs.getTranslatedTabLabel(), new Object[0]);
                }
            } else if (ScriptDefaults.mc.currentScreen != null) {
                try {
                    return ((IInventory)ReflectionUtils.containerInventoryPlayer.get(ScriptDefaults.mc.currentScreen.getClass()).get(ScriptDefaults.mc.currentScreen)).getDisplayName().getUnformattedText();
                }
                catch (Exception exception) {
                    // empty catch block
                }
            }
            return "";
        }

        public static int getSize() {
            return ScriptDefaults.mc.thePlayer.inventory.getSizeInventory();
        }

        public static int getChestSize() {
            if (ScriptDefaults.mc.thePlayer.openContainer instanceof ContainerChest) {
                ContainerChest containerChest = (ContainerChest)ScriptDefaults.mc.thePlayer.openContainer;
                if (containerChest == null) {
                    return -1;
                }
                return containerChest.getLowerChestInventory().getSizeInventory();
            }
            return -1;
        }

        public static ItemStack getStackInSlot(int n) {
            if (ScriptDefaults.mc.thePlayer.inventory.getStackInSlot(n) == null) {
                return null;
            }
            return new ItemStack(ScriptDefaults.mc.thePlayer.inventory.getStackInSlot(n), 0);
        }

        public static ItemStack getStackInChestSlot(int n) {
            if (ScriptDefaults.mc.thePlayer.openContainer instanceof ContainerChest) {
                ContainerChest containerChest = (ContainerChest)ScriptDefaults.mc.thePlayer.openContainer;
                if (containerChest.getLowerChestInventory().getStackInSlot(n) == null) {
                    return null;
                }
                return new ItemStack(containerChest.getLowerChestInventory().getStackInSlot(n), 0);
            }
            return null;
        }

        public static ItemStack getStackInCraftingSlot(int n) {
            if (ScriptDefaults.mc.thePlayer.openContainer instanceof ContainerWorkbench) {
                InventoryCrafting inventoryCrafting = ((ContainerWorkbench)ScriptDefaults.mc.thePlayer.openContainer).craftMatrix;
                if (inventoryCrafting.getStackInSlot(n) == null) {
                    return null;
                }
                return new ItemStack(inventoryCrafting.getStackInSlot(n), 0);
            }
            return null;
        }

        public static ItemStack getCraftResult() {
            if (ScriptDefaults.mc.thePlayer.openContainer instanceof ContainerWorkbench) {
                IInventory iInventory = ((ContainerWorkbench)ScriptDefaults.mc.thePlayer.openContainer).craftResult;
                if (iInventory.getStackInSlot(0) == null) {
                    return null;
                }
                return new ItemStack(iInventory.getStackInSlot(0), 0);
            }
            return null;
        }

        public static void open() {
            KeyBinding keyBinding = ScriptDefaults.mc.gameSettings.keyBindInventory;
            int n = keyBinding.getKeyCode();
            if (n == 0) {
                keyBinding.setKeyCode(0x905057E7 ^ 0x905057EA);
                KeyBinding.resetKeyBindingArrayAndHash();
            }
            KeyBinding.setKeyBindState(keyBinding.getKeyCode(), true);
            KeyBinding.onTick(keyBinding.getKeyCode());
            KeyBinding.setKeyBindState(keyBinding.getKeyCode(), false);
            if (n == 0) {
                keyBinding.setKeyCode(0);
                KeyBinding.resetKeyBindingArrayAndHash();
            }
        }
    }

    public static class render {
        private static final double[] WORLD_TO_SCREEN_COORDS = new double[0xFC4BF511 ^ 0xFC4BF512];
        private static oc29a4412fc2 worldToScreenContext;
        private static boolean worldToScreenContextActive;

        public static void beginWorldToScreen(int n) {
            worldToScreenContext = ocbd4917c4b1.\u04e9(worldToScreenContext, n);
            worldToScreenContextActive = true;
        }

        public static void endWorldToScreen() {
            worldToScreenContextActive = false;
        }

        public static void block(Vec3 vec3, int n, boolean bl, boolean bl2) {
            ocbd4917c4b1.\u044c(new BlockPos(vec3.x, vec3.y, vec3.z), n, bl, bl2);
        }

        public static int getThemeRGB(String string) {
            return oc3542cefbeb.\u053e(oc7ab2161b9f.\u0120(oc3542cefbeb.class, string).ordinal(), 0.0);
        }

        public static void block(int n, int n2, int n3, int n4, boolean bl, boolean bl2) {
            ocbd4917c4b1.\u044c(new BlockPos(n, n2, n3), n4, bl, bl2);
        }

        public static void entity(Entity entity, int n, float f, boolean bl, boolean bl2) {
            net.minecraft.entity.Entity entity2 = entity.entity;
            double d = entity2.lastTickPosX + (entity2.posX - entity2.lastTickPosX) * (double)f - ScriptDefaults.mc.getRenderManager().viewerPosX;
            double d2 = entity2.lastTickPosY + (entity2.posY - entity2.lastTickPosY) * (double)f - ScriptDefaults.mc.getRenderManager().viewerPosY;
            double d3 = entity2.lastTickPosZ + (entity2.posZ - entity2.lastTickPosZ) * (double)f - ScriptDefaults.mc.getRenderManager().viewerPosZ;
            AxisAlignedBB axisAlignedBB = entity2.getEntityBoundingBox().expand(0.1, 0.1, 0.1);
            AxisAlignedBB axisAlignedBB2 = new AxisAlignedBB(axisAlignedBB.minX - entity2.posX + d, axisAlignedBB.minY - entity2.posY + d2, axisAlignedBB.minZ - entity2.posZ + d3, axisAlignedBB.maxX - entity2.posX + d, axisAlignedBB.maxY - entity2.posY + d2, axisAlignedBB.maxZ - entity2.posZ + d3);
            GL11.glPushMatrix();
            GL11.glBlendFunc(0x3F5F116E ^ 0x3F5F126C, 0x3F5F116F ^ 0x3F5F126C);
            GL11.glEnable(0x3F5F198E ^ 0x3F5F126C);
            GL11.glDisable(0x3F5F1F8D ^ 0x3F5F126C);
            GL11.glDisable(0x3F5F191D ^ 0x3F5F126C);
            GL11.glDepthMask(false);
            GL11.glLineWidth(2.0f);
            float f2 = (float)(n >> (0x3F5F1274 ^ 0x3F5F126C) & (0x3F5F1293 ^ 0x3F5F126C)) / 255.0f;
            float f3 = (float)(n >> (0x3F5F127C ^ 0x3F5F126C) & (0x3F5F1293 ^ 0x3F5F126C)) / 255.0f;
            float f4 = (float)(n >> (0x3F5F1264 ^ 0x3F5F126C) & (0x3F5F1293 ^ 0x3F5F126C)) / 255.0f;
            float f5 = (float)(n & (0x3F5F1293 ^ 0x3F5F126C)) / 255.0f;
            GL11.glColor4f(f3, f4, f5, f2);
            if (bl) {
                RenderGlobal.drawSelectionBoundingBox(axisAlignedBB2);
            }
            if (bl2) {
                ocbd4917c4b1.x(axisAlignedBB2, f3, f4, f5);
            }
            GL11.glEnable(0x3F5F1F8D ^ 0x3F5F126C);
            GL11.glEnable(0x3F5F191D ^ 0x3F5F126C);
            GL11.glDepthMask(true);
            GL11.glDisable(0x3F5F198E ^ 0x3F5F126C);
            GL11.glPopMatrix();
        }

        public static void entityGui(Entity entity, int n, int n2, float f, float f2, int n3) {
            if (!entity.isLiving) {
                return;
            }
            GL11.glPushMatrix();
            GuiInventory.drawEntityOnScreen(n, n2, n3, f, f2, (EntityLivingBase)entity.entity);
            GL11.glPopMatrix();
        }

        public static void resetEquippedProgress() {
            mc.getItemRenderer().resetEquippedProgress();
        }

        public static void tracer(Entity entity, float f, int n, float f2) {
            ocbd4917c4b1.\u029f(entity.entity, n, f, f2);
        }

        public static void showGui() {
            mc.displayGuiScreen(new EmptyGuiScreen());
        }

        public static void item(ItemStack itemStack, float f, float f2, float f3) {
            if (itemStack == null || itemStack.itemStack == null) {
                return;
            }
            GlStateManager.pushMatrix();
            ScriptDefaults.mc.entityRenderer.setupOverlayRendering();
            if (f3 != 1.0f) {
                GlStateManager.scale(f3, f3, f3);
            }
            RenderHelper.enableGUIStandardItemLighting();
            GlStateManager.disableBlend();
            GlStateManager.translate(f / f3, f2 / f3, 0.0f);
            mc.getRenderItem().renderItemIntoGUI(itemStack.itemStack, 0, 0);
            GlStateManager.enableBlend();
            RenderHelper.disableStandardItemLighting();
            if (f3 != 1.0f) {
                GlStateManager.scale(f3, f3, f3);
            }
            GlStateManager.popMatrix();
        }

        public static void image(Image image, float f, float f2, float f3, float f4) {
            Object object;
            if (image == null || !image.isLoaded()) {
                return;
            }
            if (image.textureId == -1) {
                object = new DynamicTexture(image.bufferedImage);
                GL11.glTexParameteri(0xBEAB165F ^ 0xBEAB1BBE, 0xBEAB33BE ^ 0xBEAB1BBE, 0xBEAB3DBE ^ 0xBEAB1BBE);
                ((DynamicTexture)object).updateDynamicTexture();
                image.textureId = ((AbstractTexture)object).getGlTextureId();
            }
            GlStateManager.pushMatrix();
            GlStateManager.enableTexture2D();
            GlStateManager.bindTexture(image.textureId);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            GL11.glTexParameteri(0xBEAB165F ^ 0xBEAB1BBE, 0xBEAB33BE ^ 0xBEAB1BBE, 0xBEAB3DBE ^ 0xBEAB1BBE);
            object = Tessellator.getInstance();
            WorldRenderer worldRenderer = ((Tessellator)object).getWorldRenderer();
            worldRenderer.begin(0xBEAB1BB9 ^ 0xBEAB1BBE, DefaultVertexFormats.POSITION_TEX_COLOR);
            worldRenderer.pos(f, f2 + f4, 0.0).tex(0.0, 1.0).color(0xBEAB1B41 ^ 0xBEAB1BBE, 0xBEAB1B41 ^ 0xBEAB1BBE, 0xBEAB1B41 ^ 0xBEAB1BBE, 0xBEAB1B41 ^ 0xBEAB1BBE).endVertex();
            worldRenderer.pos(f + f3, f2 + f4, 0.0).tex(1.0, 1.0).color(0xBEAB1B41 ^ 0xBEAB1BBE, 0xBEAB1B41 ^ 0xBEAB1BBE, 0xBEAB1B41 ^ 0xBEAB1BBE, 0xBEAB1B41 ^ 0xBEAB1BBE).endVertex();
            worldRenderer.pos(f + f3, f2, 0.0).tex(1.0, 0.0).color(0xBEAB1B41 ^ 0xBEAB1BBE, 0xBEAB1B41 ^ 0xBEAB1BBE, 0xBEAB1B41 ^ 0xBEAB1BBE, 0xBEAB1B41 ^ 0xBEAB1BBE).endVertex();
            worldRenderer.pos(f, f2, 0.0).tex(0.0, 0.0).color(0xBEAB1B41 ^ 0xBEAB1BBE, 0xBEAB1B41 ^ 0xBEAB1BBE, 0xBEAB1B41 ^ 0xBEAB1BBE, 0xBEAB1B41 ^ 0xBEAB1BBE).endVertex();
            ((Tessellator)object).draw();
            GlStateManager.popMatrix();
        }

        public static Vec3 worldToScreen(double d, double d2, double d3, int n, float f) {
            boolean bl;
            boolean bl2 = bl = !worldToScreenContextActive;
            if (bl) {
                ScriptDefaults.mc.entityRenderer.callSetupCameraTransform(f, 0);
                render.beginWorldToScreen(new ScaledResolution(mc).getScaleFactor());
            }
            int n2 = worldToScreenContext != null ? worldToScreenContext.\u0105() : n;
            boolean bl3 = ocbd4917c4b1.\u010b(worldToScreenContext, d -= ScriptDefaults.mc.getRenderManager().viewerPosX, d2 -= ScriptDefaults.mc.getRenderManager().viewerPosY, d3 -= ScriptDefaults.mc.getRenderManager().viewerPosZ, n2, WORLD_TO_SCREEN_COORDS);
            ScriptDefaults.mc.entityRenderer.setupOverlayRendering();
            if (bl) {
                render.endWorldToScreen();
            }
            if (!bl3) {
                return null;
            }
            return new Vec3(WORLD_TO_SCREEN_COORDS[0], WORLD_TO_SCREEN_COORDS[1], WORLD_TO_SCREEN_COORDS[0xB77CB00E ^ 0xB77CB00C]);
        }

        public static void roundedRect(float f, float f2, float f3, float f4, float f5, int n) {
            W.\u0137(f, f2, Math.abs(f - f3), Math.abs(f2 - f4), f5, n);
        }

        public static void gradientRect(float f, float f2, float f3, float f4, int n, int n2) {
            render.gradientRect(f, f2, f3, f4, n, n, n2, n2);
        }

        public static void gradientRect(float f, float f2, float f3, float f4, int n, int n2, int n3, int n4) {
            ocbd4917c4b1.\u04f6(f, f2, f3, f4, 0.0f, n, n2, n3, n4);
        }

        public static double[] getRotations() {
            double[] dArray = new double[0x280552D9 ^ 0x280552DB];
            dArray[0] = ScriptDefaults.mc.getRenderManager().playerViewY;
            dArray[1] = ScriptDefaults.mc.getRenderManager().playerViewX;
            return dArray;
        }

        public static double[] getCameraRotations() {
            double[] dArray = new double[0xDA6C828D ^ 0xDA6C828F];
            dArray[0] = oc7ab2161b9f.\u01fb();
            dArray[1] = oc7ab2161b9f.\u051b();
            return dArray;
        }

        public static int getFontWidth(String string) {
            return ScriptDefaults.mc.fontRendererObj.getStringWidth(string) + oc7ab2161b9f.\u046a(string);
        }

        public static int getFontHeight() {
            return ScriptDefaults.mc.fontRendererObj.FONT_HEIGHT;
        }

        public static Vec3 getPosition() {
            return new Vec3(ScriptDefaults.mc.getRenderManager().viewerPosX, ScriptDefaults.mc.getRenderManager().viewerPosY, ScriptDefaults.mc.getRenderManager().viewerPosZ);
        }

        public static void text(String string, float f, float f2, float f3, int n, boolean bl) {
            render.text2d(string, f, f2, f3, n, bl);
        }

        public static void text2d(String string, float f, float f2, float f3, int n, boolean bl) {
            GlStateManager.pushMatrix();
            if (f3 != 1.0f) {
                GlStateManager.scale(f3, f3, f3);
            }
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(0x8FA6E6A0 ^ 0x8FA6E5A2, 0x8FA6E6A1 ^ 0x8FA6E5A2, 1, 0);
            ScriptDefaults.mc.fontRendererObj.drawString(string, f / f3, f2 / f3, n, bl);
            GlStateManager.disableBlend();
            if (f3 != 1.0f) {
                GlStateManager.scale(1.0f, 1.0f, 1.0f);
            }
            GlStateManager.popMatrix();
        }

        public static void text3d(String string, Vec3 vec3, float f, boolean bl, boolean bl2, boolean bl3, int n) {
            ScriptDefaults.mc.entityRenderer.callSetupCameraTransform(ScriptDefaults.mc.getTimer().renderPartialTicks, 0);
            GlStateManager.pushMatrix();
            float f2 = ScriptDefaults.mc.getTimer().renderPartialTicks;
            double d = ScriptDefaults.mc.thePlayer.prevPosX + (ScriptDefaults.mc.thePlayer.posX - ScriptDefaults.mc.thePlayer.prevPosX) * (double)f2;
            double d2 = ScriptDefaults.mc.thePlayer.prevPosY + (ScriptDefaults.mc.thePlayer.posY - ScriptDefaults.mc.thePlayer.prevPosY) * (double)f2;
            double d3 = ScriptDefaults.mc.thePlayer.prevPosZ + (ScriptDefaults.mc.thePlayer.posZ - ScriptDefaults.mc.thePlayer.prevPosZ) * (double)f2;
            GlStateManager.translate((double)((float)vec3.x) - d, (double)((float)vec3.y) - d2, (double)((float)vec3.z) - d3);
            GL11.glNormal3f(0.0f, 1.0f, 0.0f);
            GlStateManager.rotate(-ScriptDefaults.mc.getRenderManager().playerViewY, 0.0f, 1.0f, 0.0f);
            GlStateManager.rotate(ScriptDefaults.mc.getRenderManager().playerViewX, 1.0f, 0.0f, 0.0f);
            float f3 = 0.02666667f;
            GlStateManager.scale(-f3, -f3, f3);
            if (bl2) {
                GlStateManager.depthMask(false);
                GlStateManager.disableDepth();
            }
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(0x1B198EDD ^ 0x1B198DDF, 0x1B198EDC ^ 0x1B198DDF, 1, 0);
            if (bl3) {
                GlStateManager.disableTexture2D();
                int n2 = ScriptDefaults.mc.fontRendererObj.getStringWidth(string);
                Tessellator tessellator = Tessellator.getInstance();
                WorldRenderer worldRenderer = tessellator.getWorldRenderer();
                worldRenderer.begin(0x1B198DD8 ^ 0x1B198DDF, DefaultVertexFormats.POSITION_COLOR);
                worldRenderer.pos(-1.0, -1.0, 0.0).color(0.0f, 0.0f, 0.0f, 0.25f).endVertex();
                worldRenderer.pos(-1.0, 7.0, 0.0).color(0.0f, 0.0f, 0.0f, 0.25f).endVertex();
                worldRenderer.pos(n2 + 1, 7.0, 0.0).color(0.0f, 0.0f, 0.0f, 0.25f).endVertex();
                worldRenderer.pos(n2 + 1, -1.0, 0.0).color(0.0f, 0.0f, 0.0f, 0.25f).endVertex();
                tessellator.draw();
                GlStateManager.enableTexture2D();
            }
            if (f != 1.0f) {
                GlStateManager.scale(f, f, f);
            }
            ScriptDefaults.mc.fontRendererObj.drawString(string, 0.0f, 0.0f, n, bl);
            if (f != 1.0f) {
                GlStateManager.scale(1.0f, 1.0f, 1.0f);
            }
            if (bl2) {
                GlStateManager.enableDepth();
                GlStateManager.depthMask(true);
            }
            GlStateManager.disableBlend();
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.popMatrix();
        }

        public static void rect(float f, float f2, float f3, float f4, int n) {
            float f5;
            if (f < f3) {
                f5 = f;
                f = f3;
                f3 = f5;
            }
            if (f2 < f4) {
                f5 = f2;
                f2 = f4;
                f4 = f5;
            }
            f5 = (float)(n >> (0x3BC75400 ^ 0x3BC75418) & (0x3BC754E7 ^ 0x3BC75418)) / 255.0f;
            float f6 = (float)(n >> (0x3BC75408 ^ 0x3BC75418) & (0x3BC754E7 ^ 0x3BC75418)) / 255.0f;
            float f7 = (float)(n >> (0x3BC75410 ^ 0x3BC75418) & (0x3BC754E7 ^ 0x3BC75418)) / 255.0f;
            float f8 = (float)(n & (0x3BC754E7 ^ 0x3BC75418)) / 255.0f;
            Tessellator tessellator = Tessellator.getInstance();
            WorldRenderer worldRenderer = tessellator.getWorldRenderer();
            GL11.glPushMatrix();
            GlStateManager.enableBlend();
            GlStateManager.disableTexture2D();
            GlStateManager.tryBlendFuncSeparate(0x3BC7571A ^ 0x3BC75418, 0x3BC7571B ^ 0x3BC75418, 1, 0);
            GlStateManager.color(f6, f7, f8, f5);
            worldRenderer.begin(0x3BC7541F ^ 0x3BC75418, DefaultVertexFormats.POSITION);
            worldRenderer.pos(f, f4, 0.0).endVertex();
            worldRenderer.pos(f3, f4, 0.0).endVertex();
            worldRenderer.pos(f3, f2, 0.0).endVertex();
            worldRenderer.pos(f, f2, 0.0).endVertex();
            tessellator.draw();
            GlStateManager.enableTexture2D();
            GlStateManager.disableBlend();
            GL11.glPopMatrix();
        }

        public static void line2D(double d, double d2, double d3, double d4, float f, int n) {
            GL11.glPushMatrix();
            GL11.glEnable(0x8BDD2A3B ^ 0x8BDD211B);
            GL11.glDisable(0x8BDD2CFA ^ 0x8BDD211B);
            GL11.glEnable(0x8BDD2AF9 ^ 0x8BDD211B);
            ocbd4917c4b1.I(n);
            GL11.glLineWidth(f);
            GL11.glBegin(1);
            GL11.glVertex2d(d, d2);
            GL11.glVertex2d(d3, d4);
            oc170ea29aae.\u0177();
            GL11.glDisable(0x8BDD2AF9 ^ 0x8BDD211B);
            GL11.glEnable(0x8BDD2CFA ^ 0x8BDD211B);
            GL11.glDisable(0x8BDD2A3B ^ 0x8BDD211B);
            GL11.glPopMatrix();
        }

        public static void line3D(Vec3 vec3, Vec3 vec32, float f, int n) {
            render.line3D(vec3.x, vec3.y, vec3.z, vec32.x, vec32.y, vec32.z, f, n);
        }

        public static void line3D(double d, double d2, double d3, double d4, double d5, double d6, float f, int n) {
            double d7 = ScriptDefaults.mc.getRenderManager().viewerPosX;
            double d8 = ScriptDefaults.mc.getRenderManager().viewerPosY;
            double d9 = ScriptDefaults.mc.getRenderManager().viewerPosZ;
            double d10 = d - d7;
            double d11 = d2 - d8;
            double d12 = d3 - d9;
            d4 -= d7;
            d5 -= d8;
            d6 -= d9;
            float f2 = (float)(n >> (0xA4CD46BE ^ 0xA4CD46A6) & (0xA4CD4659 ^ 0xA4CD46A6)) / 255.0f;
            float f3 = (float)(n >> (0xA4CD46B6 ^ 0xA4CD46A6) & (0xA4CD4659 ^ 0xA4CD46A6)) / 255.0f;
            float f4 = (float)(n >> (0xA4CD46AE ^ 0xA4CD46A6) & (0xA4CD4659 ^ 0xA4CD46A6)) / 255.0f;
            float f5 = (float)(n & (0xA4CD4659 ^ 0xA4CD46A6)) / 255.0f;
            GL11.glPushMatrix();
            GL11.glEnable(0xA4CD4D44 ^ 0xA4CD46A6);
            GL11.glEnable(0xA4CD4D86 ^ 0xA4CD46A6);
            GL11.glDisable(0xA4CD4DD7 ^ 0xA4CD46A6);
            GL11.glDisable(0xA4CD4B47 ^ 0xA4CD46A6);
            GL11.glBlendFunc(0xA4CD45A4 ^ 0xA4CD46A6, 0xA4CD45A5 ^ 0xA4CD46A6);
            GL11.glLineWidth(f);
            GlStateManager.color(f3, f4, f5, f2);
            GL11.glBegin(0xA4CD46A4 ^ 0xA4CD46A6);
            GL11.glVertex3d(d10, d11, d12);
            GL11.glVertex3d(d4, d5, d6);
            oc170ea29aae.\u0177();
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            GL11.glEnable(0xA4CD4B47 ^ 0xA4CD46A6);
            GL11.glEnable(0xA4CD4DD7 ^ 0xA4CD46A6);
            GL11.glDisable(0xA4CD4D86 ^ 0xA4CD46A6);
            GL11.glDisable(0xA4CD4D44 ^ 0xA4CD46A6);
            GL11.glPopMatrix();
        }

        public static boolean isInView(Entity entity) {
            return ocbd4917c4b1.\u017e(entity.entity);
        }

        private static class EmptyGuiScreen
        extends GuiScreen {
            private EmptyGuiScreen() {
            }
        }

        public static class bloom {
            public static void prepare() {
                oc1b46ea259e.\u0391();
            }

            public static void apply(int n, float f) {
                oc1b46ea259e.\u026d(n, f);
            }
        }

        public static class blur {
            public static void prepare() {
                oc1b46ea259e.\u049d();
            }

            public static void apply(int n, float f) {
                oc1b46ea259e.\u038f(n, f);
            }
        }
    }

    public static class config {
        private static String CONFIG_DIR = new File(oc8ccd9c3f55.\u0212(ScriptDefaults.mc.mcDataDir), "script_config.txt").getPath();
        private static String SEPARATOR = ":";
        private static String SEPARATOR_FULL = SEPARATOR + " ";

        private static void ensureConfigFileExists() throws IOException {
            Path path = Paths.get(CONFIG_DIR, new String[0]);
            if (Files.notExists(path, new LinkOption[0])) {
                Files.createDirectories(path.getParent(), new FileAttribute[0]);
                Files.createFile(path, new FileAttribute[0]);
            }
        }

        public static boolean set(String string, String string2) {
            if (string == null || string.isEmpty()) {
                return false;
            }
            string = string.replace(SEPARATOR, "");
            String string3 = string + SEPARATOR_FULL + string2;
            try {
                config.ensureConfigFileExists();
                Path path = new File(CONFIG_DIR).toPath();
                ArrayList<String> arrayList = new ArrayList<String>(Files.readAllLines(path));
                boolean bl = false;
                for (int i = 0; i < arrayList.size(); ++i) {
                    String string4 = (String)arrayList.get(i);
                    if (!string4.startsWith(string + SEPARATOR_FULL)) continue;
                    arrayList.set(i, string3);
                    bl = true;
                    break;
                }
                if (!bl) {
                    arrayList.add(string3);
                }
                Files.write(path, arrayList, new OpenOption[0]);
                return true;
            }
            catch (IOException iOException) {
                return false;
            }
        }

        public static String get(String string) {
            if (string == null || string.isEmpty()) {
                return null;
            }
            try {
                config.ensureConfigFileExists();
                Path path = new File(CONFIG_DIR).toPath();
                List<String> list = Files.readAllLines(path);
                for (String string2 : list) {
                    if (!string2.startsWith(string + SEPARATOR_FULL)) continue;
                    return string2.substring((string + SEPARATOR_FULL).length());
                }
            }
            catch (IOException iOException) {
                // empty catch block
            }
            return null;
        }
    }

    public static class gl {
        public static void alpha(boolean bl) {
            if (bl) {
                GlStateManager.enableAlpha();
            } else {
                GlStateManager.disableAlpha();
            }
        }

        public static void begin(int n) {
            GL11.glBegin(n);
        }

        public static void blend(boolean bl) {
            if (bl) {
                GlStateManager.enableBlend();
            } else {
                GlStateManager.disableBlend();
            }
        }

        public static void color(float f, float f2, float f3, float f4) {
            GlStateManager.color(f, f2, f3, f4);
        }

        public static void color(double d, double d2, double d3, double d4) {
            GlStateManager.color((float)d, (float)d2, (float)d3, (float)d4);
        }

        public static void color(int n, int n2, int n3, int n4) {
            if (n <= 1 && n2 <= 1 && n3 <= 1 && n4 <= 1) {
                GlStateManager.color(n, n2, n3, n4);
                return;
            }
            GlStateManager.color((float)n / 255.0f, (float)n2 / 255.0f, (float)n3 / 255.0f, (float)n4 / 255.0f);
        }

        public static void depthFunc(int n) {
            GL11.glDepthFunc(n);
        }

        public static void colorMask(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
            GlStateManager.colorMask(bl, bl2, bl3, bl4);
        }

        public static void polygonOffset(float f, float f2) {
            GL11.glPolygonOffset(f, f2);
        }

        public static void texCoord2(double d, double d2) {
            GL11.glTexCoord2d(d, d2);
        }

        public static void texCoord2(float f, float f2) {
            GL11.glTexCoord2f(f, f2);
        }

        public static void bindTexture(String string) {
            ResourceLocation resourceLocation = new ResourceLocation(string);
            mc.getTextureManager().bindTexture(resourceLocation);
        }

        public static void bindTextureId(int n) {
            GlStateManager.bindTexture(n);
        }

        public static int getBoundTexture() {
            return GL11.glGetInteger(0x6CC519E2 ^ 0x6CC5998B);
        }

        public static void polygonOffset(boolean bl) {
            if (bl) {
                GlStateManager.enablePolygonOffset();
            } else {
                GlStateManager.disablePolygonOffset();
            }
        }

        public static void cull(boolean bl) {
            if (bl) {
                GlStateManager.enableCull();
            } else {
                GlStateManager.disableCull();
            }
        }

        public static void depth(boolean bl) {
            if (bl) {
                GlStateManager.enableDepth();
            } else {
                GlStateManager.disableDepth();
            }
        }

        public static void depthMask(boolean bl) {
            GlStateManager.depthMask(bl);
        }

        public static void disable(int n) {
            gl.setCapability(n, false);
        }

        public static void disableItemLighting() {
            RenderHelper.disableStandardItemLighting();
        }

        public static void enable(int n) {
            gl.setCapability(n, true);
        }

        public static void enableItemLighting(boolean bl) {
            if (bl) {
                RenderHelper.enableGUIStandardItemLighting();
            } else {
                RenderHelper.enableStandardItemLighting();
            }
        }

        public static void resetColor() {
            GlStateManager.resetColor();
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        }

        public static void end() {
            oc170ea29aae.\u0177();
        }

        public static void lighting(boolean bl) {
            if (bl) {
                GlStateManager.enableLighting();
            } else {
                GlStateManager.disableLighting();
            }
        }

        public static void lineSmooth(boolean bl) {
            gl.setGLEnable(0x8CA27777 ^ 0x8CA27C57, bl);
        }

        public static void lineWidth(float f) {
            GL11.glLineWidth(f);
        }

        public static void lineWidth(double d) {
            GL11.glLineWidth((float)d);
        }

        public static void normal(float f, float f2, float f3) {
            GL11.glNormal3f(f, f2, f3);
        }

        public static void normal(double d, double d2, double d3) {
            GL11.glNormal3d(d, d2, d3);
        }

        public static void pop() {
            GL11.glPopMatrix();
        }

        public static void push() {
            GL11.glPushMatrix();
        }

        public static void rotate(float f, float f2, float f3, float f4) {
            GL11.glRotatef(f, f2, f3, f4);
        }

        public static void rotate(double d, double d2, double d3, double d4) {
            GL11.glRotated(d, d2, d3, d4);
        }

        public static void scale(float f, float f2, float f3) {
            GL11.glScalef(f, f2, f3);
        }

        public static void scissor(int n, int n2, int n3, int n4) {
            GL11.glScissor(n, n2, n3, n4);
        }

        public static void scissor(boolean bl) {
            gl.setGLEnable(0x5A0E88E4 ^ 0x5A0E84F5, bl);
        }

        public static void texture2d(boolean bl) {
            if (bl) {
                GlStateManager.enableTexture2D();
            } else {
                GlStateManager.disableTexture2D();
            }
        }

        public static void translate(float f, float f2, float f3) {
            GL11.glTranslatef(f, f2, f3);
        }

        public static void translate(double d, double d2, double d3) {
            GL11.glTranslated(d, d2, d3);
        }

        public static void vertex2(float f, float f2) {
            GL11.glVertex2f(f, f2);
        }

        public static void vertex3(float f, float f2, float f3) {
            GL11.glVertex3f(f, f2, f3);
        }

        public static void vertex3(double d, double d2, double d3) {
            GL11.glVertex3d(d, d2, d3);
        }

        private static void setGLEnable(int n, boolean bl) {
            if (bl) {
                GL11.glEnable(n);
            } else {
                GL11.glDisable(n);
            }
        }

        private static void setCapability(int n, boolean bl) {
            switch (n) {
                case 3008: {
                    gl.alpha(bl);
                    break;
                }
                case 3042: {
                    gl.blend(bl);
                    break;
                }
                case 2884: {
                    gl.cull(bl);
                    break;
                }
                case 2929: {
                    gl.depth(bl);
                    break;
                }
                case 2912: {
                    if (bl) {
                        GlStateManager.enableFog();
                        break;
                    }
                    GlStateManager.disableFog();
                    break;
                }
                case 2896: {
                    gl.lighting(bl);
                    break;
                }
                case 3058: {
                    if (bl) {
                        GlStateManager.enableColorLogic();
                        break;
                    }
                    GlStateManager.disableColorLogic();
                    break;
                }
                case 2977: {
                    if (bl) {
                        GlStateManager.enableNormalize();
                        break;
                    }
                    GlStateManager.disableNormalize();
                    break;
                }
                case 32823: {
                    if (bl) {
                        GlStateManager.enablePolygonOffset();
                        break;
                    }
                    GlStateManager.disablePolygonOffset();
                    break;
                }
                case 32826: {
                    if (bl) {
                        GlStateManager.enableRescaleNormal();
                        break;
                    }
                    GlStateManager.disableRescaleNormal();
                    break;
                }
                case 3553: {
                    gl.texture2d(bl);
                    break;
                }
                default: {
                    gl.setGLEnable(n, bl);
                }
            }
        }
    }

    public static class modules {
        private String superName;

        public modules(String string) {
            this.superName = string;
        }

        private static oc69da1aa7f5 getModule(String string) {
            return modulesMap.get(string);
        }

        private static oc69da1aa7f5 getScript(String string) {
            if (string == null) {
                return null;
            }
            oc69da1aa7f5 oc69da1aa7f52 = modulesMap.get(string);
            if (oc69da1aa7f52 != null) {
                return oc69da1aa7f52;
            }
            Object object = modulesMap.entrySet().iterator();
            while (object.hasNext()) {
                Map.Entry<String, oc69da1aa7f5> entry = object.next();
                if (!entry.getKey().equalsIgnoreCase(string)) continue;
                return entry.getValue();
            }
            Object object2 = object = oc2cf3d80e17.\u013e != null ? oc2cf3d80e17.\u013e : oc502dfc7784.\u04a3;
            if (object != null) {
                for (Map.Entry entry : ((ScriptManager)object).scripts.entrySet()) {
                    if (!((Script)entry.getKey()).name.equalsIgnoreCase(string) && !((oc69da1aa7f5)entry.getValue()).z$3i8m9vxwuvqj0().equalsIgnoreCase(string)) continue;
                    return (oc69da1aa7f5)entry.getValue();
                }
            }
            return null;
        }

        private void register(N n) {
            if (n == null) {
                return;
            }
            oc69da1aa7f5 oc69da1aa7f52 = modules.getScript(this.superName);
            if (oc69da1aa7f52 != null) {
                oc69da1aa7f52.\u028c(n);
            }
        }

        private static N getSetting(oc69da1aa7f5 oc69da1aa7f52, String string) {
            if (oc69da1aa7f52 == null) {
                return null;
            }
            for (N n : oc69da1aa7f52.\u0260()) {
                if (!n.z$18nrktuqeiysv().equals(string)) continue;
                return n;
            }
            return null;
        }

        private occc831eff22 getGroupForString(String string) {
            if (string.isEmpty()) {
                return null;
            }
            oc69da1aa7f5 oc69da1aa7f52 = modules.getScript(this.superName);
            if (oc69da1aa7f52 == null) {
                return null;
            }
            ArrayList<N> arrayList = oc69da1aa7f52.\u0260();
            for (N n : arrayList) {
                if (!(n instanceof occc831eff22) || !n.z$18nrktuqeiysv().equals(string)) continue;
                return (occc831eff22)n;
            }
            return null;
        }

        public void enable(String string) {
            if (modules.getModule(string) == null) {
                return;
            }
            modules.getModule(string).\u0425();
        }

        public void disable(String string) {
            if (modules.getModule(string) == null) {
                return;
            }
            modules.getModule(string).z$1ca1cmv0s357();
        }

        public boolean isEnabled(String string) {
            if (modules.getModule(string) == null) {
                return false;
            }
            return modules.getModule(string).z$3rzb3dil7uydr();
        }

        public Entity getKillAuraTarget() {
            if (ocdd342096f8.f == null) {
                return null;
            }
            return Entity.convert(ocdd342096f8.f);
        }

        public Entity getAimAssistTarget() {
            ocaa9a64f047 ocaa9a64f0472 = (ocaa9a64f047)oc9755810e45.\u02ac(ocaa9a64f047.class);
            if (ocaa9a64f0472 == null || !ocaa9a64f0472.z$3rzb3dil7uydr()) {
                return null;
            }
            return Entity.convert(ocaa9a64f0472.\u0177());
        }

        public Entity getLagRangeTarget() {
            oc3c7a892f2f oc3c7a892f2f2 = (oc3c7a892f2f)oc9755810e45.\u02ac(oc3c7a892f2f.class);
            if (oc3c7a892f2f2 == null || !oc3c7a892f2f2.z$3rzb3dil7uydr()) {
                return null;
            }
            return Entity.convert(oc3c7a892f2f2.B());
        }

        public Entity getBacktrackTarget() {
            occ39d36078d occ39d36078d2 = oc9755810e45.G;
            if (occ39d36078d2 == null || !occ39d36078d2.z$3rzb3dil7uydr()) {
                return null;
            }
            return Entity.convert(occ39d36078d2.\u0172());
        }

        public Vec3 getLagRangePosition() {
            oc3c7a892f2f oc3c7a892f2f2 = (oc3c7a892f2f)oc9755810e45.\u02ac(oc3c7a892f2f.class);
            if (oc3c7a892f2f2 == null || !oc3c7a892f2f2.z$3rzb3dil7uydr()) {
                return null;
            }
            net.minecraft.util.Vec3 vec3 = oc3c7a892f2f2.\u0407();
            return vec3 == null ? null : new Vec3(vec3);
        }

        public Vec3 getBacktrackPosition() {
            occ39d36078d occ39d36078d2 = oc9755810e45.G;
            if (occ39d36078d2 == null || !occ39d36078d2.z$3rzb3dil7uydr()) {
                return null;
            }
            net.minecraft.util.Vec3 vec3 = occ39d36078d2.\u022f();
            return vec3 == null ? null : new Vec3(vec3);
        }

        public Map<String, Object> getSettings(String string) {
            HashMap<String, Object> hashMap = new HashMap<String, Object>();
            oc69da1aa7f5 oc69da1aa7f52 = modules.getModule(string);
            if (oc69da1aa7f52 == null) {
                return hashMap;
            }
            for (N n : oc69da1aa7f52.\u0260()) {
                if (n instanceof oca9cc61aada) {
                    hashMap.put(n.z$18nrktuqeiysv(), ((oca9cc61aada)n).\u04c1());
                    continue;
                }
                if (n instanceof occ2f8dff8d8) {
                    hashMap.put(n.z$18nrktuqeiysv(), ((occ2f8dff8d8)n).\u01ed());
                    continue;
                }
                if (!(n instanceof oc24a0a5bddf)) continue;
                hashMap.put(n.z$18nrktuqeiysv(), ((oc24a0a5bddf)n).\u0373());
            }
            return hashMap;
        }

        public Map<String, List<String>> getCategories() {
            HashMap<String, List<String>> hashMap = new HashMap<String, List<String>>();
            for (oc192c7e4083 oc192c7e40832 : oc2c25634a7e.\u02b4) {
                ArrayList<String> arrayList = new ArrayList<String>();
                for (ocebe35f25d6 ocebe35f25d62 : oc192c7e40832.\u015d) {
                    arrayList.add(ocebe35f25d62.\u0523.z$3i8m9vxwuvqj0());
                }
                hashMap.put(oc192c7e40832.\u0229.name(), arrayList);
            }
            return hashMap;
        }

        public Vec3 getBedAuraPosition() {
            if (oc9755810e45.\u03d4 == null || !oc9755810e45.\u03d4.z$3rzb3dil7uydr()) {
                return null;
            }
            BlockPos blockPos = oc9755810e45.\u03d4.\u0513();
            if (blockPos == null) {
                return null;
            }
            return new Vec3(blockPos.getX(), blockPos.getY(), blockPos.getZ());
        }

        public float[] getBedAuraProgress() {
            if (oc9755810e45.\u03d4 == null || !oc9755810e45.\u03d4.z$3rzb3dil7uydr()) {
                float[] fArray = new float[0x476114F5 ^ 0x476114F7];
                fArray[0] = 0.0f;
                fArray[1] = 0.0f;
                return fArray;
            }
            float f = oc9755810e45.\u03d4.\u0402();
            float[] fArray = new float[0x476114F5 ^ 0x476114F7];
            fArray[0] = f;
            fArray[1] = 0.0f;
            return fArray;
        }

        public boolean isScaffolding() {
            return false;
        }

        public boolean isTowering() {
            return false;
        }

        public boolean isHidden(String string) {
            oc69da1aa7f5 oc69da1aa7f52 = modules.getModule(string);
            if (oc69da1aa7f52 != null) {
                return oc69da1aa7f52.\u056c();
            }
            return false;
        }

        public void registerGroup(String string) {
            this.register(new occc831eff22(string));
        }

        public void registerButton(String string, boolean bl) {
            this.register(new occ2f8dff8d8(string, bl));
        }

        public void registerButton(String string, String string2, boolean bl) {
            this.register(new occ2f8dff8d8(this.getGroupForString(string), string2, bl));
        }

        public void registerKey(String string, String string2, int n) {
            this.register(new ocb23d192a35(this.getGroupForString(string), string2, n));
        }

        public void registerKey(String string, int n) {
            this.register(new ocb23d192a35(string, n));
        }

        public void registerSlider(String string, String string2, String string3, double d, double d2, double d3, double d4) {
            this.register(new oca9cc61aada(this.getGroupForString(string), string2, string3, d, d2, d3, d4));
        }

        public void registerSlider(String string, String string2, String string3, int n, String[] stringArray) {
            this.register(new oca9cc61aada(this.getGroupForString(string), string2, string3, n, stringArray));
        }

        public void registerSlider(String string, double d, double d2, double d3, double d4) {
            this.registerSlider("", string, "", d, d2, d3, d4);
        }

        public void registerSlider(String string, int n, String[] stringArray) {
            this.registerSlider("", string, "", n, stringArray);
        }

        public void registerSlider(String string, String string2, double d, double d2, double d3, double d4) {
            this.registerSlider("", string, string2, d, d2, d3, d4);
        }

        public void registerSlider(String string, String string2, int n, String[] stringArray) {
            this.registerSlider("", string, string2, n, stringArray);
        }

        public void registerDescription(String string) {
            this.register(new oc4d46a99983(string));
        }

        public void registerColor(String string, int n, int n2, int n3) {
            this.register(new oc24a0a5bddf(string, n, n2, n3));
        }

        public void registerColor(String string, int n, int n2, int n3, int n4) {
            this.register(new oc24a0a5bddf(string, n, n2, n3, n4));
        }

        public void registerColor(String string, String string2, int n, int n2, int n3) {
            this.register(new oc24a0a5bddf(this.getGroupForString(string), string2, n, n2, n3));
        }

        public void registerColor(String string, String string2, int n, int n2, int n3, int n4) {
            this.register(new oc24a0a5bddf(this.getGroupForString(string), string2, n, n2, n3, n4));
        }

        public int getColor(String string, String string2) {
            oc24a0a5bddf oc24a0a5bddf2 = (oc24a0a5bddf)modules.getSetting(modules.getModule(string), string2);
            if (oc24a0a5bddf2 == null) {
                return 0;
            }
            return oc24a0a5bddf2.\u0373();
        }

        public void setColor(String string, String string2, int n, int n2, int n3) {
            oc24a0a5bddf oc24a0a5bddf2 = (oc24a0a5bddf)modules.getSetting(modules.getModule(string), string2);
            if (oc24a0a5bddf2 == null) {
                return;
            }
            oc24a0a5bddf2.\u04c2(n, n2, n3);
        }

        public void setColor(String string, String string2, int n, int n2, int n3, int n4) {
            oc24a0a5bddf oc24a0a5bddf2 = (oc24a0a5bddf)modules.getSetting(modules.getModule(string), string2);
            if (oc24a0a5bddf2 == null) {
                return;
            }
            oc24a0a5bddf2.\u01be(n, n2, n3, n4);
        }

        public boolean getButton(String string, String string2) {
            occ2f8dff8d8 occ2f8dff8d82 = (occ2f8dff8d8)modules.getSetting(modules.getModule(string), string2);
            if (occ2f8dff8d82 == null) {
                return false;
            }
            boolean bl = occ2f8dff8d82.\u01ed();
            return bl;
        }

        public double getSlider(String string, String string2) {
            oca9cc61aada oca9cc61aada2 = (oca9cc61aada)modules.getSetting(modules.getModule(string), string2);
            if (oca9cc61aada2 == null) {
                return 0.0;
            }
            double d = oca9cc61aada2.\u04c1();
            return d;
        }

        public double getSliderMin(String string, String string2) {
            oca9cc61aada oca9cc61aada2 = (oca9cc61aada)modules.getSetting(modules.getModule(string), string2);
            if (oca9cc61aada2 == null) {
                return 0.0;
            }
            return oca9cc61aada2.\u0515();
        }

        public double getSliderMax(String string, String string2) {
            oca9cc61aada oca9cc61aada2 = (oca9cc61aada)modules.getSetting(modules.getModule(string), string2);
            if (oca9cc61aada2 == null) {
                return 0.0;
            }
            return oca9cc61aada2.\u0236();
        }

        public String getSliderString(String string, String string2) {
            oca9cc61aada oca9cc61aada2 = (oca9cc61aada)modules.getSetting(modules.getModule(string), string2);
            if (oca9cc61aada2 == null || !oca9cc61aada2.\u00c6) {
                return "";
            }
            int n = (int)Math.round(oca9cc61aada2.\u04c1());
            n = Math.max(0, Math.min(n, oca9cc61aada2.\u04be().length - 1));
            return oca9cc61aada2.\u04be()[n];
        }

        public boolean getKeyPressed(String string, String string2) {
            ocb23d192a35 ocb23d192a352 = (ocb23d192a35)modules.getSetting(modules.getModule(string), string2);
            if (ocb23d192a352 == null) {
                return false;
            }
            return ocb23d192a352.\u0190();
        }

        public void setButton(String string, String string2, boolean bl) {
            occ2f8dff8d8 occ2f8dff8d82 = (occ2f8dff8d8)modules.getSetting(modules.getModule(string), string2);
            if (occ2f8dff8d82 == null) {
                return;
            }
            occ2f8dff8d82.\u03d1(bl);
        }

        public void setSlider(String string, String string2, double d) {
            oca9cc61aada oca9cc61aada2 = (oca9cc61aada)modules.getSetting(modules.getModule(string), string2);
            if (oca9cc61aada2 == null) {
                return;
            }
            oca9cc61aada2.f(d);
        }

        public void setKey(String string, String string2, int n) {
            ocb23d192a35 ocb23d192a352 = (ocb23d192a35)modules.getSetting(modules.getModule(string), string2);
            if (ocb23d192a352 == null) {
                return;
            }
            ocb23d192a352.\u00c8(n);
        }
    }

    public static class world {
        public static boolean exists() {
            return ScriptDefaults.mc.theWorld != null;
        }

        public static Entity spawnMob(String string, double d, double d2, double d3) {
            return ClientEntityManager.spawnMob(string, d, d2, d3);
        }

        public static Entity spawnMob(String string, Vec3 vec3) {
            if (vec3 == null) {
                return null;
            }
            return world.spawnMob(string, vec3.x, vec3.y, vec3.z);
        }

        public static boolean removeClientEntity(Entity entity) {
            return ClientEntityManager.removeClientEntity(entity);
        }

        public static void clearClientEntities() {
            ClientEntityManager.clearClientEntities();
        }

        public static void playSound(String string, float f, float f2, double d, double d2, double d3) {
            ScriptDefaults.mc.theWorld.playSound(d, d2, d3, string, f, f2, false);
        }

        public static boolean isValidEntity(Entity entity) {
            return ScriptDefaults.mc.theWorld != null && ScriptDefaults.mc.theWorld.loadedEntityList.contains(entity);
        }

        public static Block getBlockAt(int n, int n2, int n3) {
            IBlockState iBlockState = occb1ed1ed8f.\u041e(new BlockPos(n, n2, n3));
            if (iBlockState == null) {
                return new Block(Blocks.air, new BlockPos(n, n2, n3));
            }
            return new Block(iBlockState, new BlockPos(n, n2, n3));
        }

        public static String getTitleText() {
            return client.getTitle();
        }

        public static void setTitleText(String string, String string2, int n, int n2, int n3) {
            ScriptDefaults.mc.ingameGUI.displayTitle(string, string2, n, n2, n3);
        }

        public static void clearTitleText() {
            ScriptDefaults.mc.ingameGUI.displayTitle(null, null, -1, -1, -1);
        }

        public static Block getBlockAt(Vec3 vec3) {
            IBlockState iBlockState = occb1ed1ed8f.\u041e(new BlockPos(vec3.x, vec3.y, vec3.z));
            if (iBlockState == null) {
                return new Block(Blocks.air, new BlockPos(vec3.x, vec3.y, vec3.z));
            }
            return new Block(iBlockState, new BlockPos(vec3.x, vec3.y, vec3.z));
        }

        public static String getDimension() {
            if (ScriptDefaults.mc.theWorld == null) {
                return "";
            }
            return ScriptDefaults.mc.theWorld.provider.getDimensionName();
        }

        public static List<Entity> getEntities() {
            ArrayList<Entity> arrayList = new ArrayList<Entity>();
            if (ScriptDefaults.mc.theWorld == null) {
                return arrayList;
            }
            for (net.minecraft.entity.Entity entity : ScriptDefaults.mc.theWorld.loadedEntityList) {
                arrayList.add(Entity.convert(entity));
            }
            return arrayList;
        }

        public static Entity getEntityById(int n) {
            if (ScriptDefaults.mc.theWorld == null) {
                return null;
            }
            return Entity.convert(ScriptDefaults.mc.theWorld.getEntityByID(n));
        }

        public static List<NetworkPlayer> getNetworkPlayers() {
            ArrayList<NetworkPlayer> arrayList = new ArrayList<NetworkPlayer>();
            for (NetworkPlayerInfo networkPlayerInfo : oc7ab2161b9f.\u02e0(false)) {
                arrayList.add(NetworkPlayer.convert(networkPlayerInfo));
            }
            return arrayList;
        }

        public static List<Entity> getPlayerEntities() {
            ArrayList<Entity> arrayList = new ArrayList<Entity>();
            for (net.minecraft.entity.Entity entity : ScriptDefaults.mc.theWorld.playerEntities) {
                arrayList.add(Entity.convert(entity));
            }
            return arrayList;
        }

        public static List<String> getScoreboard() {
            List<String> list = oc7ab2161b9f.\u0570();
            if (list.isEmpty()) {
                return null;
            }
            return list;
        }

        public static String getTabHeader() {
            if (mc == null || ScriptDefaults.mc.ingameGUI == null || ScriptDefaults.mc.ingameGUI.getTabList() == null) {
                return "";
            }
            IChatComponent iChatComponent = ScriptDefaults.mc.ingameGUI.getTabList().getHeader();
            if (iChatComponent != null) {
                return iChatComponent.getUnformattedText();
            }
            return "";
        }

        public static String getTabFooter() {
            if (mc == null || ScriptDefaults.mc.ingameGUI == null || ScriptDefaults.mc.ingameGUI.getTabList() == null) {
                return "";
            }
            IChatComponent iChatComponent = ScriptDefaults.mc.ingameGUI.getTabList().getFooter();
            if (iChatComponent != null) {
                return iChatComponent.getUnformattedText();
            }
            return "";
        }

        public static Map<String, List<String>> getTeams() {
            HashMap<String, List<String>> hashMap = new HashMap<String, List<String>>();
            for (Team team : ScriptDefaults.mc.theWorld.getScoreboard().getTeams()) {
                ArrayList<String> arrayList = new ArrayList<String>();
                for (String string : team.getMembershipCollection()) {
                    arrayList.add(string);
                }
                hashMap.put(team.getRegisteredName(), arrayList);
            }
            return hashMap;
        }

        public static List<TileEntity> getTileEntities() {
            ArrayList<TileEntity> arrayList = new ArrayList<TileEntity>();
            for (net.minecraft.tileentity.TileEntity tileEntity : ScriptDefaults.mc.theWorld.loadedTileEntityList) {
                arrayList.add(new TileEntity(tileEntity));
            }
            return arrayList;
        }
    }

    public static class client {
        public static boolean allowFlying() {
            return ScriptDefaults.mc.thePlayer.capabilities.allowFlying;
        }

        public static void setTabName(String string, String string2) {
            if (string == null || string2 == null || mc.getNetHandler() == null) {
                return;
            }
            for (NetworkPlayerInfo networkPlayerInfo : mc.getNetHandler().getPlayerInfoMap()) {
                if (networkPlayerInfo.getGameProfile() == null || !string.equalsIgnoreCase(networkPlayerInfo.getGameProfile().getName())) continue;
                networkPlayerInfo.setDisplayName(new ChatComponentText(string2));
                return;
            }
        }

        public static long nanoTime() {
            return System.nanoTime();
        }

        public static void removePotionEffect(int n) {
            if (ScriptDefaults.mc.thePlayer == null) {
                return;
            }
            ScriptDefaults.mc.thePlayer.removePotionEffectClient(n);
        }

        public static int getUID() {
            return 0x64EF83D ^ 0x64EF839;
        }

        public static String getUser() {
            return ScriptDefaults.mc.thePlayer.getName();
        }

        public static void addEnemy(String string) {
            oc7ab2161b9f.\u0513(string);
        }

        public static void addFriend(String string) {
            oc7ab2161b9f.\u017f(string);
        }

        public static void async(Runnable runnable2) {
            if (cachedExecutor == null) {
                cachedExecutor = Executors.newCachedThreadPool();
            }
            cachedExecutor.execute(runnable2);
        }

        public static int getFPS() {
            return Minecraft.getDebugFPS();
        }

        public static void chat(String string) {
            ScriptDefaults.mc.thePlayer.sendChatMessage(string);
        }

        public static void print(String string) {
            oc7ab2161b9f.\u022b(string);
        }

        public static void sendMessage(String string) {
            client.print(string);
        }

        public static void print(Message message) {
            ScriptDefaults.mc.thePlayer.addChatMessage(message.component);
        }

        public static void sendMessage(Message message) {
            client.print(message);
        }

        public static void print(Object object) {
            String string = String.valueOf(object);
            oc7ab2161b9f.\u022b(string);
        }

        public static void sendMessage(Object object) {
            client.print(object);
        }

        public static boolean isDiagonal() {
            return oc7ab2161b9f.\u0100(false);
        }

        public static void setTimer(float f) {
            ScriptDefaults.mc.getTimer().timerSpeed = f;
        }

        public static void setTimer(double d) {
            ScriptDefaults.mc.getTimer().timerSpeed = (float)d;
        }

        public static boolean isCreative() {
            return ScriptDefaults.mc.thePlayer.capabilities.isCreativeMode;
        }

        public static void processPacket(SPacket sPacket) {
            sPacket.packet.processPacket(mc.getNetHandler().getNetworkManager().getPacketListener());
        }

        public static void multiplyMotion(double d) {
            ScriptDefaults.mc.thePlayer.motionZ *= d;
            ScriptDefaults.mc.thePlayer.motionX *= d;
        }

        public static void processPacketNoEvent(SPacket sPacket) {
            ocd6ae010123.\u00c5(sPacket.packet);
        }

        public static String getTitle() {
            return ScriptDefaults.mc.ingameGUI.getDisplayedTitle();
        }

        public static String getSubTitle() {
            return ScriptDefaults.mc.ingameGUI.getDisplayedSubTitle();
        }

        public static String getRecordPlaying() {
            return ScriptDefaults.mc.ingameGUI.getRecordPlaying();
        }

        public static boolean isFlying() {
            return ScriptDefaults.mc.thePlayer.capabilities.isFlying;
        }

        public static void attack(Entity entity) {
            oc7ab2161b9f.\u010d(entity.entity, true, true);
        }

        public static boolean isSinglePlayer() {
            return mc.isSingleplayer();
        }

        public static boolean isSpectator() {
            return ScriptDefaults.mc.thePlayer.isSpectator();
        }

        public static void setFlying(boolean bl) {
            ScriptDefaults.mc.thePlayer.capabilities.isFlying = bl;
        }

        public static void setJump(boolean bl) {
            ScriptDefaults.mc.thePlayer.movementInput.jump = bl;
        }

        public static void setJumping(boolean bl) {
            ScriptDefaults.mc.thePlayer.setJumping(bl);
        }

        public static void setRenderArmPitch(float f) {
            ScriptDefaults.mc.thePlayer.prevRenderArmPitch = f;
            ScriptDefaults.mc.thePlayer.renderArmPitch = f;
        }

        public static float getEquippedProgress() {
            return mc.getItemRenderer().getEquippedProgress();
        }

        public static void disconnect() {
            boolean bl = mc.isIntegratedServerRunning();
            boolean bl2 = mc.isConnectedToRealms();
            ScriptDefaults.mc.theWorld.sendQuittingDisconnectingPacket();
            mc.loadWorld(null);
            if (bl) {
                mc.displayGuiScreen(new GuiMainMenu());
                return;
            }
            if (bl2) {
                new RealmsBridge().switchToRealms(new GuiMainMenu());
                return;
            }
            mc.displayGuiScreen(new GuiMultiplayer(new GuiMainMenu()));
        }

        public static float getRenderArmPitch() {
            return ScriptDefaults.mc.thePlayer.renderArmPitch;
        }

        public static void setRenderArmYaw(float f) {
            ScriptDefaults.mc.thePlayer.prevRenderArmYaw = f;
            ScriptDefaults.mc.thePlayer.renderArmYaw = f;
        }

        public static float getRenderArmYaw() {
            return ScriptDefaults.mc.thePlayer.renderArmYaw;
        }

        public static long getTotalMemory() {
            return Runtime.getRuntime().totalMemory();
        }

        public static long getFreeMemory() {
            return Runtime.getRuntime().freeMemory();
        }

        public static long getMaxMemory() {
            return Runtime.getRuntime().maxMemory();
        }

        public static List<String[]> getResourcePacks() {
            ArrayList<String[]> arrayList = new ArrayList<String[]>();
            if (mc.getResourcePackRepository().getRepositoryEntries() == null || mc.getResourcePackRepository().getRepositoryEntries().isEmpty()) {
                String[] stringArray = new String[0xCD0F5CC5 ^ 0xCD0F5CC7];
                stringArray[0] = mc.getDefaultResourcePack().getPackName();
                stringArray[1] = "";
                arrayList.add(stringArray);
            } else {
                for (ResourcePackRepository.Entry entry : mc.getResourcePackRepository().getRepositoryEntries()) {
                    String[] stringArray = new String[0xCD0F5CC5 ^ 0xCD0F5CC7];
                    stringArray[0] = entry.getResourcePackName();
                    stringArray[1] = entry.getTexturePackDescription();
                    arrayList.add(stringArray);
                }
            }
            Collections.reverse(arrayList);
            return arrayList;
        }

        public static void jump() {
            ScriptDefaults.mc.thePlayer.jump();
        }

        public static boolean allowEditing() {
            if (ScriptDefaults.mc.thePlayer == null || ScriptDefaults.mc.thePlayer.capabilities == null) {
                return false;
            }
            return ScriptDefaults.mc.thePlayer.capabilities.allowEdit;
        }

        public static void setItemInUseCount(int n) {
            ScriptDefaults.mc.thePlayer.setItemInUseCount(n);
        }

        public static int getItemInUseCount() {
            return ScriptDefaults.mc.thePlayer.getItemInUseCount();
        }

        public static int getItemInUseDuration() {
            return ScriptDefaults.mc.thePlayer.getItemInUseDuration();
        }

        public static void log(Object object) {
            oc7ab2161b9f.\u00f4.info(object);
        }

        public static void setSneaking(boolean bl) {
            ScriptDefaults.mc.thePlayer.setSneaking(bl);
        }

        public static void setSneak(boolean bl) {
            ScriptDefaults.mc.thePlayer.movementInput.sneak = bl;
        }

        public static boolean isSneak() {
            return ScriptDefaults.mc.thePlayer.movementInput.sneak;
        }

        public static Entity getPlayer() {
            if (mc == null || ScriptDefaults.mc.thePlayer == null) {
                return null;
            }
            return Entity.convert(ScriptDefaults.mc.thePlayer);
        }

        public static void removeEnemy(String string) {
            oc7ab2161b9f.\u03d3(string);
        }

        public static void removeFriend(String string) {
            oc7ab2161b9f.\u0421(string);
        }

        public static boolean isRiding() {
            return ScriptDefaults.mc.thePlayer.isRiding();
        }

        public static void setRidingEntity(Entity entity) {
            if (entity == null) {
                ScriptDefaults.mc.thePlayer.ridingEntity = null;
                return;
            }
            ScriptDefaults.mc.thePlayer.ridingEntity = entity.entity;
        }

        public static Vec3 getMotion() {
            return new Vec3(ScriptDefaults.mc.thePlayer.motionX, ScriptDefaults.mc.thePlayer.motionY, ScriptDefaults.mc.thePlayer.motionZ);
        }

        public static void sleep(long l) {
            try {
                Thread.sleep(l);
            }
            catch (InterruptedException interruptedException) {
                // empty catch block
            }
        }

        public static void ping() {
            ScriptDefaults.mc.thePlayer.playSound("note.pling", 1.0f, 1.0f);
        }

        public static void playSound(String string, float f, float f2) {
            ScriptDefaults.mc.thePlayer.playSound(string, f, f2);
        }

        public static boolean isMoving() {
            return oc7ab2161b9f.\u0223();
        }

        public static boolean isJump() {
            return ScriptDefaults.mc.thePlayer.movementInput.jump;
        }

        public static float getStrafe() {
            return ScriptDefaults.mc.thePlayer.movementInput.moveStrafe;
        }

        public static void sleep(int n) {
            try {
                Thread.sleep(n);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }

        public static float getForward() {
            return ScriptDefaults.mc.thePlayer.movementInput.moveForward;
        }

        public static void closeScreen() {
            if (ScriptDefaults.mc.currentScreen instanceof oc2c25634a7e) {
                mc.displayGuiScreen(null);
                return;
            }
            ScriptDefaults.mc.thePlayer.closeScreen();
        }

        public static String getScreen() {
            return ScriptDefaults.mc.currentScreen == null ? "" : ScriptDefaults.mc.currentScreen.getClass().getSimpleName();
        }

        public static float[] getRotationsToEntity(Entity entity) {
            return oc75d51ec7eb.\u026d(entity.entity);
        }

        public static void sendPacket(CPacket cPacket) {
            Packet packet = PacketHandler.convertCPacket(cPacket);
            if (packet == null) {
                return;
            }
            ScriptDefaults.mc.thePlayer.sendQueue.addToSendQueue(packet);
        }

        public static void sendPacketNoEvent(CPacket cPacket) {
            Packet packet = PacketHandler.convertCPacket(cPacket);
            if (packet == null) {
                return;
            }
            ocd6ae010123.\u0115(packet);
        }

        public static boolean inFocus() {
            return ScriptDefaults.mc.inGameHasFocus;
        }

        public static void dropItem(boolean bl) {
            ScriptDefaults.mc.thePlayer.dropOneItem(bl);
        }

        public static void setMotion(double d, double d2, double d3) {
            ScriptDefaults.mc.thePlayer.motionX = d;
            ScriptDefaults.mc.thePlayer.motionY = d2;
            ScriptDefaults.mc.thePlayer.motionZ = d3;
        }

        public static void setSpeed(double d) {
            oc7ab2161b9f.N(d);
        }

        public static void setForward(float f) {
            ScriptDefaults.mc.thePlayer.movementInput.moveForward = f;
        }

        public static void setStrafe(float f) {
            ScriptDefaults.mc.thePlayer.movementInput.moveStrafe = f;
        }

        public static String getServerIP() {
            if (mc.getCurrentServerData() == null || mc.isSingleplayer()) {
                return "";
            }
            return ScriptDefaults.mc.getCurrentServerData().serverIP;
        }

        public static int[] getDisplaySize() {
            ScaledResolution scaledResolution = new ScaledResolution(mc);
            int[] nArray = new int[0xCE217693 ^ 0xCE217690];
            nArray[0] = scaledResolution.getScaledWidth();
            nArray[1] = scaledResolution.getScaledHeight();
            nArray[0xCE217692 ^ 0xCE217690] = scaledResolution.getScaleFactor();
            return nArray;
        }

        public static float getServerDirection(PlayerState playerState) {
            return playerState.yaw;
        }

        public static Object[] raycastBlock(double d) {
            return client.raycastBlock(d, ScriptDefaults.mc.thePlayer.rotationYaw, ScriptDefaults.mc.thePlayer.rotationPitch);
        }

        public static Object[] raycastBlock(double d, float f, float f2) {
            net.minecraft.util.Vec3 vec3 = ScriptDefaults.mc.thePlayer.getPositionEyes(1.0f);
            net.minecraft.util.Vec3 vec32 = oc7ab2161b9f.\u04b5(f, f2);
            net.minecraft.util.Vec3 vec33 = vec3.addVector(vec32.xCoord * d, vec32.yCoord * d, vec32.zCoord * d);
            MovingObjectPosition movingObjectPosition = ScriptDefaults.mc.theWorld.rayTraceBlocks(vec3, vec33, false, false, false);
            if (movingObjectPosition == null || movingObjectPosition.typeOfHit != MovingObjectPosition.MovingObjectType.BLOCK) {
                return null;
            }
            Vec3 vec34 = new Vec3(movingObjectPosition.getBlockPos());
            Vec3 vec35 = new Vec3(movingObjectPosition.hitVec.xCoord - vec34.x, movingObjectPosition.hitVec.yCoord - vec34.y, movingObjectPosition.hitVec.zCoord - vec34.z);
            Object[] objectArray = new Object[0x72EB4E5F ^ 0x72EB4E5C];
            objectArray[0] = vec34;
            objectArray[1] = vec35;
            objectArray[0x72EB4E5E ^ 0x72EB4E5C] = movingObjectPosition.sideHit.name();
            return objectArray;
        }

        public static Object[] raycastEntity(double d) {
            return client.raycastEntity(d, ScriptDefaults.mc.thePlayer.rotationYaw, ScriptDefaults.mc.thePlayer.rotationPitch);
        }

        public static Object[] raycastEntity(double d, float f, float f2) {
            net.minecraft.entity.Entity entity = null;
            MovingObjectPosition movingObjectPosition = ScriptDefaults.mc.thePlayer.rayTrace(d, 1.0f);
            net.minecraft.util.Vec3 vec3 = ScriptDefaults.mc.thePlayer.getPositionEyes(1.0f);
            net.minecraft.util.Vec3 vec32 = oc7ab2161b9f.\u04b5(f, f2);
            net.minecraft.util.Vec3 vec33 = vec3.addVector(vec32.xCoord * d, vec32.yCoord * d, vec32.zCoord * d);
            net.minecraft.util.Vec3 vec34 = null;
            List<net.minecraft.entity.Entity> list = ScriptDefaults.mc.theWorld.getEntitiesWithinAABBExcludingEntity(mc.getRenderViewEntity(), mc.getRenderViewEntity().getEntityBoundingBox().addCoord(vec32.xCoord * d, vec32.yCoord * d, vec32.zCoord * d).expand(1.0, 1.0, 1.0));
            double d2 = d;
            for (int i = 0; i < list.size(); ++i) {
                double d3;
                net.minecraft.entity.Entity entity2 = list.get(i);
                if (!(entity2 instanceof EntityLivingBase) || !entity2.canBeCollidedWith() || ((EntityLivingBase)entity2).deathTime != 0) continue;
                float f3 = entity2.getCollisionBorderSize();
                AxisAlignedBB axisAlignedBB = entity2.getEntityBoundingBox().expand(f3, f3, f3);
                MovingObjectPosition movingObjectPosition2 = axisAlignedBB.calculateIntercept(vec3, vec33);
                if (axisAlignedBB.isVecInside(vec3)) {
                    if (!(0.0 < d2) && d2 != 0.0) continue;
                    entity = entity2;
                    vec34 = movingObjectPosition2 == null ? vec3 : movingObjectPosition2.hitVec;
                    d2 = 0.0;
                    continue;
                }
                if (movingObjectPosition2 == null || !((d3 = vec3.distanceTo(movingObjectPosition2.hitVec)) < d2) && d2 != 0.0) continue;
                if (entity2 == ScriptDefaults.mc.getRenderViewEntity().ridingEntity && !entity2.canRiderInteract()) {
                    if (d2 != 0.0) continue;
                    entity = entity2;
                    vec34 = movingObjectPosition2.hitVec;
                    continue;
                }
                entity = entity2;
                vec34 = movingObjectPosition2.hitVec;
                d2 = d3;
            }
            if (entity != null && (d2 < d || movingObjectPosition == null)) {
                movingObjectPosition = new MovingObjectPosition(entity, vec34);
                Vec3 vec35 = new Vec3(movingObjectPosition.hitVec.xCoord - entity.posX, movingObjectPosition.hitVec.yCoord - entity.posY, movingObjectPosition.hitVec.zCoord - entity.posZ);
                Object[] objectArray = new Object[0x9E50F399 ^ 0x9E50F39A];
                objectArray[0] = new Entity(movingObjectPosition.entityHit);
                objectArray[1] = vec35;
                objectArray[0x9E50F398 ^ 0x9E50F39A] = vec3.squareDistanceTo(movingObjectPosition.hitVec);
                return objectArray;
            }
            return null;
        }

        public static boolean canPlaceBlock(ItemStack itemStack, Vec3 vec3, String string) {
            if (itemStack == null || itemStack.itemStack == null || itemStack.itemStack.getItem() == null || !itemStack.isBlock) {
                return false;
            }
            return ((ItemBlock)itemStack.itemStack.getItem()).canPlaceBlockOnSide(ScriptDefaults.mc.theWorld, Vec3.getBlockPos(vec3), oc7ab2161b9f.\u0120(EnumFacing.class, string), ScriptDefaults.mc.thePlayer, itemStack.itemStack);
        }

        public static boolean placeBlock(Vec3 vec3, String string, Vec3 vec32) {
            return ScriptDefaults.mc.playerController.onPlayerRightClick(ScriptDefaults.mc.thePlayer, ScriptDefaults.mc.theWorld, ScriptDefaults.mc.thePlayer.getHeldItem(), Vec3.getBlockPos(vec3), oc7ab2161b9f.\u0120(EnumFacing.class, string), Vec3.getVec3(vec32));
        }

        public static void clickBlock(Vec3 vec3, String string) {
            ScriptDefaults.mc.playerController.clickBlock(Vec3.getBlockPos(vec3), oc7ab2161b9f.\u0120(EnumFacing.class, string));
        }

        public static void enableMovementFix() {
            ocbb165642ef.\u02a8().\u041d = true;
        }

        public static void disableMovementFix() {
            ocbb165642ef.\u02a8().\u041d = false;
        }

        public static boolean isMovementFixActive() {
            return ocbb165642ef.\u02a8().\u04dc();
        }

        public static boolean isRotationActive() {
            return ocbb165642ef.\u02a8().\u0178();
        }

        public static void setRotations(float f, float f2) {
            ocbb165642ef.\u02a8().\u0195(f, f2);
        }

        public static void setYaw(float f) {
            ocbb165642ef.\u02a8().\u0291(f);
        }

        public static void setPitch(float f) {
            ocbb165642ef.\u02a8().\u051f(f);
        }

        public static Float getServerYaw() {
            return ocbb165642ef.\u02a8().\u0266();
        }

        public static Float getServerPitch() {
            return ocbb165642ef.\u02a8().\u022b();
        }

        public static float[] getRotationsToBlock(Vec3 vec3) {
            return oc75d51ec7eb.\u0412(new BlockPos(vec3.x, vec3.y, vec3.z));
        }

        public static void setSprinting(boolean bl) {
            ScriptDefaults.mc.thePlayer.setSprinting(bl);
        }

        public static void swing() {
            ScriptDefaults.mc.thePlayer.swingItem();
        }

        public static void swingReset() {
            ScriptDefaults.mc.thePlayer.swingItem();
            mc.getItemRenderer().resetEquippedProgress();
        }

        public static long time() {
            return System.currentTimeMillis();
        }

        public static boolean isFriend(String string) {
            return oc7ab2161b9f.\u0158(string);
        }

        public static boolean isEnemy(String string) {
            return oc7ab2161b9f.h(string);
        }
    }
}

