/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.shaders.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.resources.I18n;
import net.optifine.shaders.Shaders;
import net.optifine.shaders.config.EnumShaderOption;
import net.optifine.shaders.gui.GuiShaders;

public class GuiButtonEnumShaderOption
extends GuiButton {
    private EnumShaderOption enumShaderOption = null;

    public GuiButtonEnumShaderOption(EnumShaderOption enumShaderOption, int n, int n2, int n3, int n4) {
        super(enumShaderOption.ordinal(), n, n2, n3, n4, GuiButtonEnumShaderOption.getButtonText(enumShaderOption));
        this.enumShaderOption = enumShaderOption;
    }

    public EnumShaderOption getEnumShaderOption() {
        return this.enumShaderOption;
    }

    private static String getButtonText(EnumShaderOption enumShaderOption) {
        String string = I18n.format(enumShaderOption.getResourceKey(), new Object[0]) + ": ";
        switch (enumShaderOption) {
            case ANTIALIASING: {
                return string + GuiShaders.toStringAa(Shaders.configAntialiasingLevel);
            }
            case NORMAL_MAP: {
                return string + GuiShaders.toStringOnOff(Shaders.configNormalMap);
            }
            case SPECULAR_MAP: {
                return string + GuiShaders.toStringOnOff(Shaders.configSpecularMap);
            }
            case RENDER_RES_MUL: {
                return string + GuiShaders.toStringQuality(Shaders.configRenderResMul);
            }
            case SHADOW_RES_MUL: {
                return string + GuiShaders.toStringQuality(Shaders.configShadowResMul);
            }
            case HAND_DEPTH_MUL: {
                return string + GuiShaders.toStringHandDepth(Shaders.configHandDepthMul);
            }
            case CLOUD_SHADOW: {
                return string + GuiShaders.toStringOnOff(Shaders.configCloudShadow);
            }
            case OLD_HAND_LIGHT: {
                return string + Shaders.configOldHandLight.getUserValue();
            }
            case OLD_LIGHTING: {
                return string + Shaders.configOldLighting.getUserValue();
            }
            case SHADOW_CLIP_FRUSTRUM: {
                return string + GuiShaders.toStringOnOff(Shaders.configShadowClipFrustrum);
            }
            case TWEAK_BLOCK_DAMAGE: {
                return string + GuiShaders.toStringOnOff(Shaders.configTweakBlockDamage);
            }
        }
        return string + Shaders.getEnumShaderOption(enumShaderOption);
    }

    public void updateButtonText() {
        this.displayString = GuiButtonEnumShaderOption.getButtonText(this.enumShaderOption);
    }
}

