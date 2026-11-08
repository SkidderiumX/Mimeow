/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.renderer.entity.layers;

import com.google.common.collect.Maps;
import java.util.Map;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.src.Config;
import net.minecraft.util.ResourceLocation;
import net.optifine.CustomItems;
import net.optifine.reflect.Reflector;
import net.optifine.reflect.ReflectorCompat;
import net.optifine.shaders.Shaders;
import net.optifine.shaders.ShadersRender;
import x.ocf1c26cb57f;

public abstract class LayerArmorBase<T extends ModelBase>
implements LayerRenderer<EntityLivingBase> {
    protected static final ResourceLocation ENCHANTED_ITEM_GLINT_RES = new ResourceLocation("textures/misc/enchanted_item_glint.png");
    protected T modelLeggings;
    protected T modelArmor;
    private final RendererLivingEntity<?> renderer;
    private float alpha = 1.0f;
    private float colorR = 1.0f;
    private float colorG = 1.0f;
    private float colorB = 1.0f;
    private boolean skipRenderGlint;
    private static final Map<String, ResourceLocation> ARMOR_TEXTURE_RES_MAP = Maps.newHashMap();
    private static final ResourceLocation[][] ARMOR_TEXTURE_CACHE = new ResourceLocation[ItemArmor.ArmorMaterial.values().length][4];

    public LayerArmorBase(RendererLivingEntity<?> rendererLivingEntity) {
        this.renderer = rendererLivingEntity;
        this.initArmor();
    }

    @Override
    public void doRenderLayer(EntityLivingBase entityLivingBase, float f, float f2, float f3, float f4, float f5, float f6, float f7) {
        if (ocf1c26cb57f.\u019e(entityLivingBase)) {
            return;
        }
        this.renderLayer(entityLivingBase, f, f2, f3, f4, f5, f6, f7, 4);
        this.renderLayer(entityLivingBase, f, f2, f3, f4, f5, f6, f7, 3);
        this.renderLayer(entityLivingBase, f, f2, f3, f4, f5, f6, f7, 2);
        this.renderLayer(entityLivingBase, f, f2, f3, f4, f5, f6, f7, 1);
    }

    @Override
    public boolean shouldCombineTextures() {
        return false;
    }

    private void renderLayer(EntityLivingBase entityLivingBase, float f, float f2, float f3, float f4, float f5, float f6, float f7, int n) {
        ItemStack itemStack = this.getCurrentArmor(entityLivingBase, n);
        if (itemStack != null && itemStack.getItem() instanceof ItemArmor) {
            ItemArmor itemArmor = (ItemArmor)itemStack.getItem();
            T t = this.getArmorModel(n);
            ((ModelBase)t).setModelAttributes(this.renderer.getMainModel());
            ((ModelBase)t).setLivingAnimations(entityLivingBase, f, f2, f3);
            if (Reflector.CompatHooksClient.exists()) {
                t = this.getArmorModelHook(entityLivingBase, itemStack, n, t);
            }
            this.setModelPartVisible(t, n);
            boolean bl = this.isSlotForLeggings(n);
            if (!Config.isCustomItems() || !CustomItems.bindCustomArmorTexture(itemStack, bl ? 2 : 1, null)) {
                if (Reflector.CompatHooksClient_getArmorTexture.exists()) {
                    this.renderer.bindTexture(this.getArmorResource(entityLivingBase, itemStack, bl ? 2 : 1, null));
                } else {
                    this.renderer.bindTexture(this.getArmorResource(itemArmor, bl));
                }
            }
            if (Reflector.CompatHooksClient_getArmorTexture.exists()) {
                if (ReflectorCompat.armorHasOverlay(itemArmor, itemStack)) {
                    int n2 = itemArmor.getColor(itemStack);
                    float f8 = (float)(n2 >> 16 & 0xFF) / 255.0f;
                    float f9 = (float)(n2 >> 8 & 0xFF) / 255.0f;
                    float f10 = (float)(n2 & 0xFF) / 255.0f;
                    GlStateManager.color(this.colorR * f8, this.colorG * f9, this.colorB * f10, this.alpha);
                    ((ModelBase)t).render(entityLivingBase, f, f2, f4, f5, f6, f7);
                    if (!Config.isCustomItems() || !CustomItems.bindCustomArmorTexture(itemStack, bl ? 2 : 1, "overlay")) {
                        this.renderer.bindTexture(this.getArmorResource(entityLivingBase, itemStack, bl ? 2 : 1, "overlay"));
                    }
                }
                GlStateManager.color(this.colorR, this.colorG, this.colorB, this.alpha);
                ((ModelBase)t).render(entityLivingBase, f, f2, f4, f5, f6, f7);
                if (!(this.skipRenderGlint || !itemStack.hasEffect() || Config.isCustomItems() && CustomItems.renderCustomArmorEffect(entityLivingBase, itemStack, t, f, f2, f3, f4, f5, f6, f7))) {
                    this.renderGlint(entityLivingBase, t, f, f2, f3, f4, f5, f6, f7);
                }
                return;
            }
            switch (itemArmor.getArmorMaterial()) {
                case LEATHER: {
                    int n3 = itemArmor.getColor(itemStack);
                    float f11 = (float)(n3 >> 16 & 0xFF) / 255.0f;
                    float f12 = (float)(n3 >> 8 & 0xFF) / 255.0f;
                    float f13 = (float)(n3 & 0xFF) / 255.0f;
                    GlStateManager.color(this.colorR * f11, this.colorG * f12, this.colorB * f13, this.alpha);
                    ((ModelBase)t).render(entityLivingBase, f, f2, f4, f5, f6, f7);
                    if (!Config.isCustomItems() || !CustomItems.bindCustomArmorTexture(itemStack, bl ? 2 : 1, "overlay")) {
                        this.renderer.bindTexture(this.getArmorResource(itemArmor, bl, "overlay"));
                    }
                }
                case CHAIN: 
                case IRON: 
                case GOLD: 
                case DIAMOND: {
                    GlStateManager.color(this.colorR, this.colorG, this.colorB, this.alpha);
                    ((ModelBase)t).render(entityLivingBase, f, f2, f4, f5, f6, f7);
                }
            }
            if (!(this.skipRenderGlint || !itemStack.isItemEnchanted() || Config.isCustomItems() && CustomItems.renderCustomArmorEffect(entityLivingBase, itemStack, t, f, f2, f3, f4, f5, f6, f7))) {
                this.renderGlint(entityLivingBase, t, f, f2, f3, f4, f5, f6, f7);
            }
        }
    }

    public ItemStack getCurrentArmor(EntityLivingBase entityLivingBase, int n) {
        return entityLivingBase.getCurrentArmor(n - 1);
    }

    public T getArmorModel(int n) {
        return this.isSlotForLeggings(n) ? this.modelLeggings : this.modelArmor;
    }

    private boolean isSlotForLeggings(int n) {
        return n == 2;
    }

    private void renderGlint(EntityLivingBase entityLivingBase, T t, float f, float f2, float f3, float f4, float f5, float f6, float f7) {
        if (!Config.isShaders() || !Shaders.isShadowPass) {
            float f8 = (float)entityLivingBase.ticksExisted + f3;
            this.renderer.bindTexture(ENCHANTED_ITEM_GLINT_RES);
            if (Config.isShaders()) {
                ShadersRender.renderEnchantedGlintBegin();
            }
            GlStateManager.enableBlend();
            GlStateManager.depthFunc(514);
            GlStateManager.depthMask(false);
            float f9 = 0.5f;
            GlStateManager.color(f9, f9, f9, 1.0f);
            for (int i = 0; i < 2; ++i) {
                GlStateManager.disableLighting();
                GlStateManager.blendFunc(768, 1);
                float f10 = 0.76f;
                GlStateManager.color(0.5f * f10, 0.25f * f10, 0.8f * f10, 1.0f);
                GlStateManager.matrixMode(5890);
                GlStateManager.loadIdentity();
                float f11 = 0.33333334f;
                GlStateManager.scale(f11, f11, f11);
                GlStateManager.rotate(30.0f - (float)i * 60.0f, 0.0f, 0.0f, 1.0f);
                GlStateManager.translate(0.0f, f8 * (0.001f + (float)i * 0.003f) * 20.0f, 0.0f);
                GlStateManager.matrixMode(5888);
                ((ModelBase)t).render(entityLivingBase, f, f2, f4, f5, f6, f7);
            }
            GlStateManager.matrixMode(5890);
            GlStateManager.loadIdentity();
            GlStateManager.matrixMode(5888);
            GlStateManager.enableLighting();
            GlStateManager.depthMask(true);
            GlStateManager.depthFunc(515);
            GlStateManager.disableBlend();
            if (Config.isShaders()) {
                ShadersRender.renderEnchantedGlintEnd();
            }
        }
    }

    private ResourceLocation getArmorResource(ItemArmor itemArmor, boolean bl) {
        return this.getArmorResource(itemArmor, bl, null);
    }

    private ResourceLocation getArmorResource(ItemArmor itemArmor, boolean bl, String string) {
        ItemArmor.ArmorMaterial armorMaterial = itemArmor.getArmorMaterial();
        if (string == null || "overlay".equals(string)) {
            int n = (bl ? 2 : 0) + (string == null ? 0 : 1);
            ResourceLocation resourceLocation = ARMOR_TEXTURE_CACHE[armorMaterial.ordinal()][n];
            if (resourceLocation == null) {
                String string2 = "textures/models/armor/" + armorMaterial.getName() + "_layer_" + (bl ? 2 : 1) + (string == null ? "" : "_overlay") + ".png";
                LayerArmorBase.ARMOR_TEXTURE_CACHE[armorMaterial.ordinal()][n] = resourceLocation = new ResourceLocation(string2);
            }
            return resourceLocation;
        }
        String string3 = "textures/models/armor/" + armorMaterial.getName() + "_layer_" + (bl ? 2 : 1) + "_" + string + ".png";
        ResourceLocation resourceLocation = ARMOR_TEXTURE_RES_MAP.get(string3);
        if (resourceLocation == null) {
            resourceLocation = new ResourceLocation(string3);
            ARMOR_TEXTURE_RES_MAP.put(string3, resourceLocation);
        }
        return resourceLocation;
    }

    protected abstract void initArmor();

    protected abstract void setModelPartVisible(T var1, int var2);

    protected T getArmorModelHook(EntityLivingBase entityLivingBase, ItemStack itemStack, int n, T t) {
        return t;
    }

    public ResourceLocation getArmorResource(Entity entity, ItemStack itemStack, int n, String string) {
        ItemArmor itemArmor = (ItemArmor)itemStack.getItem();
        String string2 = itemArmor.getArmorMaterial().getName();
        String string3 = "minecraft";
        int n2 = string2.indexOf(58);
        if (n2 != -1) {
            string3 = string2.substring(0, n2);
            string2 = string2.substring(n2 + 1);
        }
        String string4 = String.format("%s:textures/models/armor/%s_layer_%d%s.png", string3, string2, this.isSlotForLeggings(n) ? 2 : 1, string == null ? "" : String.format("_%s", string));
        ResourceLocation resourceLocation = ARMOR_TEXTURE_RES_MAP.get(string4 = Reflector.callString(Reflector.CompatHooksClient_getArmorTexture, entity, itemStack, string4, n, string));
        if (resourceLocation == null) {
            resourceLocation = new ResourceLocation(string4);
            ARMOR_TEXTURE_RES_MAP.put(string4, resourceLocation);
        }
        return resourceLocation;
    }
}

