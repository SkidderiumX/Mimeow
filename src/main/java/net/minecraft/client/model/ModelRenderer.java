/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.model;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.TextureOffset;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.src.Config;
import net.minecraft.util.ResourceLocation;
import net.optifine.entity.model.anim.ModelUpdater;
import net.optifine.model.ModelSprite;
import net.optifine.shaders.SVertexFormat;
import net.optifine.shaders.Shaders;
import org.lwjgl.opengl.GL11;

public class ModelRenderer {
    public float textureWidth = 64.0f;
    public float textureHeight = 32.0f;
    private int textureOffsetX;
    private int textureOffsetY;
    public float rotationPointX;
    public float rotationPointY;
    public float rotationPointZ;
    public float rotateAngleX;
    public float rotateAngleY;
    public float rotateAngleZ;
    private boolean compiled;
    private int displayList;
    public boolean mirror;
    public boolean showModel = true;
    public boolean isHidden;
    public List<ModelBox> cubeList;
    public List<ModelRenderer> childModels;
    public final String boxName;
    private ModelBase baseModel;
    public float offsetX;
    public float offsetY;
    public float offsetZ;
    public List spriteList = new ArrayList();
    public boolean mirrorV = false;
    public float scaleX = 1.0f;
    public float scaleY = 1.0f;
    public float scaleZ = 1.0f;
    private int countResetDisplayList;
    private ResourceLocation textureLocation = null;
    private String id = null;
    private ModelUpdater modelUpdater;
    private RenderGlobal renderGlobal = Config.getRenderGlobal();

    public ModelRenderer(ModelBase modelBase, String string) {
        this.cubeList = Lists.newArrayList();
        this.baseModel = modelBase;
        modelBase.boxList.add(this);
        this.boxName = string;
        this.setTextureSize(modelBase.textureWidth, modelBase.textureHeight);
    }

    public ModelRenderer(ModelBase modelBase) {
        this(modelBase, null);
    }

    public ModelRenderer(ModelBase modelBase, int n, int n2) {
        this(modelBase);
        this.setTextureOffset(n, n2);
    }

    public void addChild(ModelRenderer modelRenderer) {
        if (this.childModels == null) {
            this.childModels = Lists.newArrayList();
        }
        this.childModels.add(modelRenderer);
    }

    public ModelRenderer setTextureOffset(int n, int n2) {
        this.textureOffsetX = n;
        this.textureOffsetY = n2;
        return this;
    }

    public ModelRenderer addBox(String object, float f, float f2, float f3, int n, int n2, int n3) {
        object = this.boxName + "." + (String)object;
        TextureOffset textureOffset = this.baseModel.getTextureOffset((String)object);
        this.setTextureOffset(textureOffset.textureOffsetX, textureOffset.textureOffsetY);
        this.cubeList.add(new ModelBox(this, this.textureOffsetX, this.textureOffsetY, f, f2, f3, n, n2, n3, 0.0f).setBoxName((String)object));
        return this;
    }

    public ModelRenderer addBox(float f, float f2, float f3, int n, int n2, int n3) {
        this.cubeList.add(new ModelBox(this, this.textureOffsetX, this.textureOffsetY, f, f2, f3, n, n2, n3, 0.0f));
        return this;
    }

    public ModelRenderer addBox(float f, float f2, float f3, int n, int n2, int n3, boolean bl) {
        this.cubeList.add(new ModelBox(this, this.textureOffsetX, this.textureOffsetY, f, f2, f3, n, n2, n3, 0.0f, bl));
        return this;
    }

    public void addBox(float f, float f2, float f3, int n, int n2, int n3, float f4) {
        this.cubeList.add(new ModelBox(this, this.textureOffsetX, this.textureOffsetY, f, f2, f3, n, n2, n3, f4));
    }

    public void setRotationPoint(float f, float f2, float f3) {
        this.rotationPointX = f;
        this.rotationPointY = f2;
        this.rotationPointZ = f3;
    }

    public void render(float f) {
        if (!this.isHidden && this.showModel) {
            this.checkResetDisplayList();
            if (!this.compiled) {
                this.compileDisplayList(f);
            }
            int n = 0;
            if (this.textureLocation != null && !this.renderGlobal.renderOverlayDamaged) {
                if (this.renderGlobal.renderOverlayEyes) {
                    return;
                }
                n = GlStateManager.getBoundTexture();
                Config.getTextureManager().bindTexture(this.textureLocation);
            }
            if (this.modelUpdater != null) {
                this.modelUpdater.update();
            }
            boolean bl = this.scaleX != 1.0f || this.scaleY != 1.0f || this.scaleZ != 1.0f;
            GlStateManager.translate(this.offsetX, this.offsetY, this.offsetZ);
            if (this.rotateAngleX == 0.0f && this.rotateAngleY == 0.0f && this.rotateAngleZ == 0.0f) {
                if (this.rotationPointX == 0.0f && this.rotationPointY == 0.0f && this.rotationPointZ == 0.0f) {
                    if (bl) {
                        GlStateManager.scale(this.scaleX, this.scaleY, this.scaleZ);
                    }
                    GlStateManager.callList(this.displayList);
                    if (this.childModels != null) {
                        for (int i = 0; i < this.childModels.size(); ++i) {
                            this.childModels.get(i).render(f);
                        }
                    }
                    if (bl) {
                        GlStateManager.scale(1.0f / this.scaleX, 1.0f / this.scaleY, 1.0f / this.scaleZ);
                    }
                } else {
                    GlStateManager.translate(this.rotationPointX * f, this.rotationPointY * f, this.rotationPointZ * f);
                    if (bl) {
                        GlStateManager.scale(this.scaleX, this.scaleY, this.scaleZ);
                    }
                    GlStateManager.callList(this.displayList);
                    if (this.childModels != null) {
                        for (int i = 0; i < this.childModels.size(); ++i) {
                            this.childModels.get(i).render(f);
                        }
                    }
                    if (bl) {
                        GlStateManager.scale(1.0f / this.scaleX, 1.0f / this.scaleY, 1.0f / this.scaleZ);
                    }
                    GlStateManager.translate(-this.rotationPointX * f, -this.rotationPointY * f, -this.rotationPointZ * f);
                }
            } else {
                GlStateManager.pushMatrix();
                GlStateManager.translate(this.rotationPointX * f, this.rotationPointY * f, this.rotationPointZ * f);
                if (this.rotateAngleZ != 0.0f) {
                    GlStateManager.rotate(this.rotateAngleZ * 57.295776f, 0.0f, 0.0f, 1.0f);
                }
                if (this.rotateAngleY != 0.0f) {
                    GlStateManager.rotate(this.rotateAngleY * 57.295776f, 0.0f, 1.0f, 0.0f);
                }
                if (this.rotateAngleX != 0.0f) {
                    GlStateManager.rotate(this.rotateAngleX * 57.295776f, 1.0f, 0.0f, 0.0f);
                }
                if (bl) {
                    GlStateManager.scale(this.scaleX, this.scaleY, this.scaleZ);
                }
                GlStateManager.callList(this.displayList);
                if (this.childModels != null) {
                    for (int i = 0; i < this.childModels.size(); ++i) {
                        this.childModels.get(i).render(f);
                    }
                }
                GlStateManager.popMatrix();
            }
            GlStateManager.translate(-this.offsetX, -this.offsetY, -this.offsetZ);
            if (n != 0) {
                GlStateManager.bindTexture(n);
            }
        }
    }

    public void renderWithRotation(float f) {
        if (!this.isHidden && this.showModel) {
            this.checkResetDisplayList();
            if (!this.compiled) {
                this.compileDisplayList(f);
            }
            int n = 0;
            if (this.textureLocation != null && !this.renderGlobal.renderOverlayDamaged) {
                if (this.renderGlobal.renderOverlayEyes) {
                    return;
                }
                n = GlStateManager.getBoundTexture();
                Config.getTextureManager().bindTexture(this.textureLocation);
            }
            if (this.modelUpdater != null) {
                this.modelUpdater.update();
            }
            boolean bl = this.scaleX != 1.0f || this.scaleY != 1.0f || this.scaleZ != 1.0f;
            GlStateManager.pushMatrix();
            GlStateManager.translate(this.rotationPointX * f, this.rotationPointY * f, this.rotationPointZ * f);
            if (this.rotateAngleY != 0.0f) {
                GlStateManager.rotate(this.rotateAngleY * 57.295776f, 0.0f, 1.0f, 0.0f);
            }
            if (this.rotateAngleX != 0.0f) {
                GlStateManager.rotate(this.rotateAngleX * 57.295776f, 1.0f, 0.0f, 0.0f);
            }
            if (this.rotateAngleZ != 0.0f) {
                GlStateManager.rotate(this.rotateAngleZ * 57.295776f, 0.0f, 0.0f, 1.0f);
            }
            if (bl) {
                GlStateManager.scale(this.scaleX, this.scaleY, this.scaleZ);
            }
            GlStateManager.callList(this.displayList);
            if (this.childModels != null) {
                for (int i = 0; i < this.childModels.size(); ++i) {
                    this.childModels.get(i).render(f);
                }
            }
            GlStateManager.popMatrix();
            if (n != 0) {
                GlStateManager.bindTexture(n);
            }
        }
    }

    public void postRender(float f) {
        if (!this.isHidden && this.showModel) {
            this.checkResetDisplayList();
            if (!this.compiled) {
                this.compileDisplayList(f);
            }
            if (this.rotateAngleX == 0.0f && this.rotateAngleY == 0.0f && this.rotateAngleZ == 0.0f) {
                if (this.rotationPointX != 0.0f || this.rotationPointY != 0.0f || this.rotationPointZ != 0.0f) {
                    GlStateManager.translate(this.rotationPointX * f, this.rotationPointY * f, this.rotationPointZ * f);
                }
            } else {
                GlStateManager.translate(this.rotationPointX * f, this.rotationPointY * f, this.rotationPointZ * f);
                if (this.rotateAngleZ != 0.0f) {
                    GlStateManager.rotate(this.rotateAngleZ * 57.295776f, 0.0f, 0.0f, 1.0f);
                }
                if (this.rotateAngleY != 0.0f) {
                    GlStateManager.rotate(this.rotateAngleY * 57.295776f, 0.0f, 1.0f, 0.0f);
                }
                if (this.rotateAngleX != 0.0f) {
                    GlStateManager.rotate(this.rotateAngleX * 57.295776f, 1.0f, 0.0f, 0.0f);
                }
            }
        }
    }

    private void compileDisplayList(float f) {
        int n;
        if (this.displayList == 0) {
            this.displayList = GLAllocation.generateDisplayLists(1);
        }
        GL11.glNewList(this.displayList, 4864);
        WorldRenderer worldRenderer = Tessellator.getInstance().getWorldRenderer();
        if (!this.cubeList.isEmpty()) {
            if (Config.isShaders()) {
                worldRenderer.begin(7, SVertexFormat.defVertexFormatTextured);
            } else {
                worldRenderer.begin(7, DefaultVertexFormats.OLDMODEL_POSITION_TEX_NORMAL);
            }
            for (n = 0; n < this.cubeList.size(); ++n) {
                this.cubeList.get(n).render(worldRenderer, f);
            }
            Tessellator.getInstance().draw();
        }
        for (n = 0; n < this.spriteList.size(); ++n) {
            ModelSprite modelSprite = (ModelSprite)this.spriteList.get(n);
            modelSprite.render(Tessellator.getInstance(), f);
        }
        GL11.glEndList();
        this.compiled = true;
    }

    public ModelRenderer setTextureSize(int n, int n2) {
        this.textureWidth = n;
        this.textureHeight = n2;
        return this;
    }

    public void addSprite(float f, float f2, float f3, int n, int n2, int n3, float f4) {
        this.spriteList.add(new ModelSprite(this, this.textureOffsetX, this.textureOffsetY, f, f2, f3, n, n2, n3, f4));
    }

    public boolean getCompiled() {
        return this.compiled;
    }

    public int getDisplayList() {
        return this.displayList;
    }

    private void checkResetDisplayList() {
        if (this.countResetDisplayList != Shaders.countResetDisplayLists) {
            this.compiled = false;
            this.countResetDisplayList = Shaders.countResetDisplayLists;
        }
    }

    public ResourceLocation getTextureLocation() {
        return this.textureLocation;
    }

    public void setTextureLocation(ResourceLocation resourceLocation) {
        this.textureLocation = resourceLocation;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String string) {
        this.id = string;
    }

    public void addBox(int[][] nArray, float f, float f2, float f3, float f4, float f5, float f6, float f7) {
        this.cubeList.add(new ModelBox(this, nArray, f, f2, f3, f4, f5, f6, f7, this.mirror));
    }

    public ModelRenderer getChild(String string) {
        if (string == null) {
            return null;
        }
        if (this.childModels != null) {
            for (int i = 0; i < this.childModels.size(); ++i) {
                ModelRenderer modelRenderer = this.childModels.get(i);
                if (!string.equals(modelRenderer.getId())) continue;
                return modelRenderer;
            }
        }
        return null;
    }

    public ModelRenderer getChildDeep(String string) {
        if (string == null) {
            return null;
        }
        ModelRenderer modelRenderer = this.getChild(string);
        if (modelRenderer != null) {
            return modelRenderer;
        }
        if (this.childModels != null) {
            for (int i = 0; i < this.childModels.size(); ++i) {
                ModelRenderer modelRenderer2 = this.childModels.get(i);
                ModelRenderer modelRenderer3 = modelRenderer2.getChildDeep(string);
                if (modelRenderer3 == null) continue;
                return modelRenderer3;
            }
        }
        return null;
    }

    public void setModelUpdater(ModelUpdater modelUpdater) {
        this.modelUpdater = modelUpdater;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("id: " + this.id + ", boxes: " + (this.cubeList != null ? Integer.valueOf(this.cubeList.size()) : null) + ", submodels: " + (this.childModels != null ? Integer.valueOf(this.childModels.size()) : null));
        return stringBuffer.toString();
    }
}

