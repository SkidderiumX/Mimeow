package net.minecraft.client.renderer;

import net.minecraft.src.*;
import net.optifine.reflect.*;
import org.lwjgl.opengl.*;
import net.optifine.shaders.*;
import x.*;
import net.minecraft.client.renderer.vertex.*;
import java.nio.*;
import java.util.*;

public class WorldVertexBufferUploader
{
    public void draw(final WorldRenderer worldRenderer) {
        if (worldRenderer.getVertexCount() > 0) {
            if (worldRenderer.getDrawMode() == 7 && Config.isQuadsToTriangles()) {
                worldRenderer.quadsToTriangles();
            }
            final VertexFormat vertexFormat = worldRenderer.getVertexFormat();
            final int nextOffset = vertexFormat.getNextOffset();
            final ByteBuffer byteBuffer = worldRenderer.getByteBuffer();
            final List<VertexFormatElement> elements = vertexFormat.getElements();
            final boolean exists = Reflector.CompatVertexFormatElementEnumUseage_preDraw.exists();
            final boolean exists2 = Reflector.CompatVertexFormatElementEnumUseage_postDraw.exists();
            OpenGlHelper.glBindBuffer(OpenGlHelper.GL_ARRAY_BUFFER, 0);
            for (int i = 0; i < elements.size(); ++i) {
                final VertexFormatElement vertexFormatElement = elements.get(i);
                final VertexFormatElement.EnumUsage usage = vertexFormatElement.getUsage();
                if (exists) {
                    Reflector.callVoid(usage, Reflector.CompatVertexFormatElementEnumUseage_preDraw, vertexFormat, i, nextOffset, byteBuffer);
                }
                else {
                    final int glConstant = vertexFormatElement.getType().getGlConstant();
                    final int index = vertexFormatElement.getIndex();
                    byteBuffer.position(vertexFormat.getOffset(i));
                    switch (usage) {
                        case POSITION: {
                            GL11.glVertexPointer(vertexFormatElement.getElementCount(), glConstant, nextOffset, byteBuffer);
                            GL11.glEnableClientState(32884);
                            break;
                        }
                        case UV: {
                            OpenGlHelper.setClientActiveTexture(OpenGlHelper.defaultTexUnit + index);
                            GL11.glTexCoordPointer(vertexFormatElement.getElementCount(), glConstant, nextOffset, byteBuffer);
                            GL11.glEnableClientState(32888);
                            OpenGlHelper.setClientActiveTexture(OpenGlHelper.defaultTexUnit);
                            break;
                        }
                        case COLOR: {
                            GL11.glColorPointer(vertexFormatElement.getElementCount(), glConstant, nextOffset, byteBuffer);
                            GL11.glEnableClientState(32886);
                            break;
                        }
                        case NORMAL: {
                            GL11.glNormalPointer(glConstant, nextOffset, byteBuffer);
                            GL11.glEnableClientState(32885);
                            break;
                        }
                    }
                }
            }
            if (worldRenderer.isMultiTexture()) {
                worldRenderer.drawMultiTexture();
            }
            else if (Config.isShaders()) {
                SVertexBuilder.drawArrays(worldRenderer.getDrawMode(), 0, worldRenderer.getVertexCount(), worldRenderer);
            }
            else {
                oc170ea29aae.\u03ad(worldRenderer.getDrawMode(), 0, worldRenderer.getVertexCount());
            }
            for (int j = 0; j < elements.size(); ++j) {
                final VertexFormatElement vertexFormatElement2 = elements.get(j);
                final VertexFormatElement.EnumUsage usage2 = vertexFormatElement2.getUsage();
                if (exists2) {
                    Reflector.callVoid(usage2, Reflector.CompatVertexFormatElementEnumUseage_postDraw, vertexFormat, j, nextOffset, byteBuffer);
                }
                else {
                    final int index2 = vertexFormatElement2.getIndex();
                    switch (usage2) {
                        case POSITION: {
                            GL11.glDisableClientState(32884);
                            break;
                        }
                        case UV: {
                            OpenGlHelper.setClientActiveTexture(OpenGlHelper.defaultTexUnit + index2);
                            GL11.glDisableClientState(32888);
                            OpenGlHelper.setClientActiveTexture(OpenGlHelper.defaultTexUnit);
                            break;
                        }
                        case COLOR: {
                            GL11.glDisableClientState(32886);
                            GlStateManager.resetColor();
                            break;
                        }
                        case NORMAL: {
                            GL11.glDisableClientState(32885);
                            break;
                        }
                    }
                }
            }
        }
        worldRenderer.reset();
    }
}
