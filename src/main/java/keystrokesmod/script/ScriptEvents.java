/*
 * Decompiled with CFR 0.152.
 */
package keystrokesmod.script;

import keystrokesmod.script.ScriptDefaults;
import keystrokesmod.script.model.Entity;
import keystrokesmod.script.model.MovementInput;
import keystrokesmod.script.model.PlayerState;
import keystrokesmod.script.model.Vec3;
import keystrokesmod.script.packet.clientbound.SPacket;
import keystrokesmod.script.packet.serverbound.CPacket;
import keystrokesmod.script.packet.serverbound.PacketHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import org.lwjgl.opengl.GL11;
import x.MouseEvent;
import x.oc02e6d57a60;
import x.oc0e4b758d9a;
import x.oc110d7f376c;
import x.oc1e3977fb7b;
import x.oc227cab88a2;
import x.oc25aa89b91f;
import x.oc2cf3d80e17;
import x.oc2f61de30bc;
import x.oc36adbc80c5;
import x.oc507025139f;
import x.oc52918cda9d;
import x.oc66fa4f2195;
import x.oc69da1aa7f5;
import x.oc6c7463093f;
import x.oc70db705765;
import x.oc746a23b244;
import x.oc7ab2161b9f;
import x.oc86de9e2892;
import x.oc8ce2882092;
import x.oc9ca1ce49ff;
import x.oc9d4393f3ce;
import x.oca27090789a;
import x.oca8d3b21c30;
import x.ocadfd5cc157;
import x.occ48acb5d22;
import x.occb187f10ff;
import x.ocd4576614ae;
import x.ocdbf1bb859b;
import x.ocded28ccee0;
import x.oce79181588d;
import x.ocebec3dfd67;
import x.ocf923d5a814;

public class ScriptEvents {
    public oc69da1aa7f5 f1191ad1ed4;

    public ScriptEvents(oc69da1aa7f5 oc69da1aa7f52) {
        this.f1191ad1ed4 = oc69da1aa7f52;
    }

    @oc66fa4f2195(priority=oc8ce2882092.HIGHEST)
    public void onChat(oc02e6d57a60 oc02e6d57a602) {
        if (!oc7ab2161b9f.\u00d0()) {
            return;
        }
        if (oc7ab2161b9f.\u045b(oc02e6d57a602.\u01eb.getUnformattedText()).isEmpty()) {
            return;
        }
        Object[] objectArray = new Object[0xA4924443 ^ 0xA4924441];
        objectArray[0] = oc02e6d57a602.\u01eb.getUnformattedText();
        objectArray[1] = oc02e6d57a602.\u03c1;
        if (oc2cf3d80e17.\u013e.invokeBoolean("onChat", this.f1191ad1ed4, objectArray) == 0) {
            oc02e6d57a602.setCanceled(true);
        }
    }

    @oc66fa4f2195(priority=oc8ce2882092.HIGHEST)
    public void onSendPacket(oc9d4393f3ce oc9d4393f3ce2) {
        if (oc9d4393f3ce2.isCanceled() || oc9d4393f3ce2.\u025f() == null) {
            return;
        }
        if (oc9d4393f3ce2.\u025f().getClass().getSimpleName().startsWith("S")) {
            return;
        }
        CPacket cPacket = PacketHandler.convertServerBound(oc9d4393f3ce2.\u025f());
        if (cPacket != null && oc2cf3d80e17.\u013e.invokeBoolean("onPacketSent", this.f1191ad1ed4, cPacket) == 0) {
            oc9d4393f3ce2.setCanceled(true);
        }
    }

    @oc66fa4f2195(priority=oc8ce2882092.HIGHEST)
    public void onDispatchPacket(oc6c7463093f oc6c7463093f2) {
        if (oc6c7463093f2.\u04a8() == null) {
            return;
        }
        if (oc6c7463093f2.\u04a8().getClass().getSimpleName().startsWith("S")) {
            return;
        }
        CPacket cPacket = PacketHandler.convertServerBound(oc6c7463093f2.\u04a8());
        oc2cf3d80e17.\u013e.invoke("onDispatchPacket", this.f1191ad1ed4, cPacket);
    }

    @oc66fa4f2195(priority=oc8ce2882092.HIGHEST)
    public void onReceivePacket(oce79181588d oce79181588d2) {
        if (oce79181588d2.isCanceled() || oce79181588d2.\u04a0() == null) {
            return;
        }
        SPacket sPacket = PacketHandler.convertClientBound(oce79181588d2.\u04a0());
        if (sPacket != null && oc2cf3d80e17.\u013e.invokeBoolean("onPacketReceived", this.f1191ad1ed4, sPacket) == 0) {
            oce79181588d2.setCanceled(true);
        }
    }

    @oc66fa4f2195(priority=oc8ce2882092.HIGHEST)
    public void onPreAttack(oc507025139f oc507025139f2) {
        if (oc507025139f2.isCanceled()) {
            return;
        }
        if (oc2cf3d80e17.\u013e.invokeBoolean("onPreAttack", this.f1191ad1ed4, new Object[0]) == 0) {
            oc507025139f2.setCanceled(true);
        }
    }

    @oc66fa4f2195(priority=oc8ce2882092.HIGHEST)
    public void onAttack(occ48acb5d22 occ48acb5d222) {
        if (occ48acb5d222.isCanceled()) {
            return;
        }
        Entity entity = Entity.convert(occ48acb5d222.\u01fa);
        Entity entity2 = Entity.convert(occ48acb5d222.\u01d5);
        Object[] objectArray = new Object[0x2D41EB6 ^ 0x2D41EB4];
        objectArray[0] = entity;
        objectArray[1] = entity2;
        if (oc2cf3d80e17.\u013e.invokeBoolean("onAttackEntity", this.f1191ad1ed4, objectArray) == 0) {
            occ48acb5d222.setCanceled(true);
        }
    }

    @oc66fa4f2195(priority=oc8ce2882092.HIGHEST)
    public void onClientRotations(oc86de9e2892 oc86de9e28922) {
        Float[] floatArray = oc2cf3d80e17.\u013e.invokeFloatArray("getRotations", this.f1191ad1ed4, new Object[0]);
        if (floatArray == null || floatArray.length == 0 || floatArray.length > (0x4B1ABE63 ^ 0x4B1ABE61)) {
            return;
        }
        if (floatArray[0] != null) {
            oc86de9e28922.\u04dc = floatArray[0];
            oc86de9e28922.\u0291 = true;
        }
        if (floatArray.length == (0x4B1ABE63 ^ 0x4B1ABE61) && floatArray[1] != null) {
            oc86de9e28922.\u0177 = floatArray[1];
            oc86de9e28922.\u0291 = true;
        }
    }

    @oc66fa4f2195(priority=oc8ce2882092.HIGHEST)
    public void onPrePlayerMovementInput(oc70db705765 oc70db7057652) {
        MovementInput movementInput = new MovementInput(oc70db7057652, 0);
        oc2cf3d80e17.\u013e.invoke("onPrePlayerInput", this.f1191ad1ed4, movementInput);
        oc70db7057652.\u010f(movementInput.forward);
        oc70db7057652.\u0413(movementInput.sneak);
        oc70db7057652.\u0243(movementInput.jump);
        oc70db7057652.\u0524(movementInput.strafe);
    }

    @oc66fa4f2195(priority=oc8ce2882092.HIGHEST)
    public void onKeyTyped(oc1e3977fb7b oc1e3977fb7b2) {
        if (oc1e3977fb7b2.isCanceled()) {
            return;
        }
        Object[] objectArray = new Object[0x4D21DA09 ^ 0x4D21DA0B];
        objectArray[0] = Character.valueOf(oc1e3977fb7b2.\u019f);
        objectArray[1] = oc1e3977fb7b2.\u00c1;
        if (oc2cf3d80e17.\u013e.invokeBoolean("onKeyPress", this.f1191ad1ed4, objectArray) == 0) {
            oc1e3977fb7b2.setCanceled(true);
        }
    }

    @oc66fa4f2195(priority=oc8ce2882092.HIGHEST)
    public void onKeyTyped(occb187f10ff occb187f10ff2) {
        if (occb187f10ff2.isCanceled()) {
            return;
        }
        Object[] objectArray = new Object[0x42B5437C ^ 0x42B54378];
        objectArray[0] = occb187f10ff2.\u0402;
        objectArray[1] = occb187f10ff2.\u048e;
        objectArray[0x42B5437A ^ 0x42B54378] = occb187f10ff2.\u051c;
        objectArray[0x42B5437B ^ 0x42B54378] = occb187f10ff2.\u0511;
        oc2cf3d80e17.\u013e.invoke("onKey", this.f1191ad1ed4, objectArray);
    }

    @oc66fa4f2195(priority=oc8ce2882092.LOWEST)
    public void onRenderWorldLast(oc746a23b244 oc746a23b2442) {
        if (!oc7ab2161b9f.\u00d0()) {
            return;
        }
        Minecraft minecraft = Minecraft.getMinecraft();
        minecraft.entityRenderer.callSetupCameraTransform(oc746a23b2442.\u0401, 0);
        ScriptDefaults.render.beginWorldToScreen(new ScaledResolution(minecraft).getScaleFactor());
        try {
            oc2cf3d80e17.\u013e.invoke("onRenderWorld", this.f1191ad1ed4, Float.valueOf(oc746a23b2442.\u0401));
        }
        finally {
            ScriptDefaults.render.endWorldToScreen();
            this.restoreWorldRenderState(minecraft, oc746a23b2442.\u0401);
        }
    }

    @oc66fa4f2195(priority=oc8ce2882092.HIGHEST)
    public void onPreUpdate(oc2f61de30bc oc2f61de30bc2) {
        oc2cf3d80e17.\u013e.invoke("onPreUpdate", this.f1191ad1ed4, new Object[0]);
    }

    @oc66fa4f2195(priority=oc8ce2882092.HIGHEST)
    public void onPostUpdate(ocebec3dfd67 ocebec3dfd672) {
        oc2cf3d80e17.\u013e.invoke("onPostUpdate", this.f1191ad1ed4, new Object[0]);
    }

    @oc66fa4f2195(priority=oc8ce2882092.HIGHEST)
    public void onRenderTick(ocf923d5a814 ocf923d5a8142) {
        if (ocf923d5a8142.\u04b0 != oc110d7f376c.END || !oc7ab2161b9f.\u00d0()) {
            return;
        }
        Minecraft minecraft = Minecraft.getMinecraft();
        minecraft.entityRenderer.setupOverlayRendering();
        try {
            oc2cf3d80e17.\u013e.invoke("onRenderTick", this.f1191ad1ed4, Float.valueOf(ocf923d5a8142.\u00f4));
        }
        finally {
            this.restoreOverlayRenderState(minecraft);
        }
    }

    @oc66fa4f2195(priority=oc8ce2882092.HIGHEST)
    public void onAntiCheatFlag(oc227cab88a2 oc227cab88a22) {
        Object[] objectArray = new Object[0x28ED0FDB ^ 0x28ED0FD9];
        objectArray[0] = oc227cab88a22.\u0136;
        objectArray[1] = Entity.convert(oc227cab88a22.\u03e0);
        oc2cf3d80e17.\u013e.invoke("onAntiCheatFlag", this.f1191ad1ed4, objectArray);
    }

    @oc66fa4f2195(priority=oc8ce2882092.HIGHEST)
    public void onGuiUpdate(ocded28ccee0 ocded28ccee02) {
        if (ocded28ccee02.\u057b == null) {
            return;
        }
        Object[] objectArray = new Object[0x25EE1EF9 ^ 0x25EE1EFB];
        objectArray[0] = ocded28ccee02.\u057b.getClass().getSimpleName();
        objectArray[1] = ocded28ccee02.\u00da;
        oc2cf3d80e17.\u013e.invoke("onGuiUpdate", this.f1191ad1ed4, objectArray);
    }

    @oc66fa4f2195
    public void onDisconnect(ocdbf1bb859b ocdbf1bb859b2) {
        Minecraft.getMinecraft().addScheduledTask(() -> oc2cf3d80e17.\u013e.invoke("onDisconnect", this.f1191ad1ed4, new Object[0]));
    }

    @oc66fa4f2195(priority=oc8ce2882092.HIGHEST)
    public void onPreMotion(oc25aa89b91f oc25aa89b91f2) {
        PlayerState playerState = new PlayerState(oc25aa89b91f2, 0);
        oc2cf3d80e17.\u013e.invoke("onPreMotion", this.f1191ad1ed4, playerState);
        if (oc25aa89b91f2.\u0541() != playerState.yaw) {
            oc25aa89b91f2.\u054f(playerState.yaw);
        }
        if (oc25aa89b91f2.\u01bd() != playerState.pitch) {
            oc25aa89b91f2.\u022b(playerState.pitch);
        }
        oc25aa89b91f2.\u0169(playerState.x);
        oc25aa89b91f2.\u0436(playerState.y);
        oc25aa89b91f2.\u0271(playerState.z);
        oc25aa89b91f2.\u0133(playerState.onGround);
        oc25aa89b91f2.\u026f(playerState.isSprinting);
        oc25aa89b91f2.\u0151(playerState.isSneaking);
    }

    @oc66fa4f2195(priority=oc8ce2882092.HIGHEST)
    public void onPrePlayerInteract(oca27090789a oca27090789a2) {
        oc2cf3d80e17.\u013e.invoke("onPrePlayerInteract", this.f1191ad1ed4, new Object[0]);
    }

    @oc66fa4f2195(priority=oc8ce2882092.HIGHEST)
    public void onWorldJoin(ocadfd5cc157 ocadfd5cc1572) {
        if (ocadfd5cc1572.\u0426 == null) {
            return;
        }
        oc2cf3d80e17.\u013e.invoke("onWorldJoin", this.f1191ad1ed4, Entity.convert(ocadfd5cc1572.\u0426));
    }

    @oc66fa4f2195(priority=oc8ce2882092.HIGHEST)
    public void onPostInput(oc52918cda9d oc52918cda9d2) {
        oc2cf3d80e17.\u013e.invoke("onPostPlayerInput", this.f1191ad1ed4, new Object[0]);
    }

    @oc66fa4f2195(priority=oc8ce2882092.HIGHEST)
    public void onPostMotion(oc0e4b758d9a oc0e4b758d9a2) {
        oc2cf3d80e17.\u013e.invoke("onPostMotion", this.f1191ad1ed4, new Object[0]);
    }

    @oc66fa4f2195(priority=oc8ce2882092.HIGHEST)
    public void onMouse(MouseEvent mouseEvent) {
        if (mouseEvent.button == -1 && mouseEvent.dwheel == 0) {
            return;
        }
        boolean bl = mouseEvent.buttonstate;
        if (mouseEvent.button == -1) {
            bl = mouseEvent.dwheel > 0;
        }
        Object[] objectArray = new Object[0x3F877647 ^ 0x3F877643];
        objectArray[0] = mouseEvent.button;
        objectArray[1] = bl;
        objectArray[0x3F877641 ^ 0x3F877643] = mouseEvent.x;
        objectArray[0x3F877640 ^ 0x3F877643] = mouseEvent.y;
        if (oc2cf3d80e17.\u013e.invokeBoolean("onMouse", this.f1191ad1ed4, objectArray) == 0) {
            mouseEvent.setCanceled(true);
        }
    }

    @oc66fa4f2195(priority=oc8ce2882092.HIGHEST)
    public void onPreRenderModel(oc9ca1ce49ff oc9ca1ce49ff2) {
        if (!oc7ab2161b9f.\u00d0()) {
            return;
        }
        if (oc2cf3d80e17.\u013e.invokeBoolean("onPreRenderModel", this.f1191ad1ed4, Entity.convert(oc9ca1ce49ff2.\u04bd)) == 0) {
            oc9ca1ce49ff2.setCanceled(true);
        }
    }

    @oc66fa4f2195(priority=oc8ce2882092.HIGHEST)
    public void onPostRenderModel(ocd4576614ae ocd4576614ae2) {
        if (!oc7ab2161b9f.\u00d0()) {
            return;
        }
        oc2cf3d80e17.\u013e.invoke("onPostRenderModel", this.f1191ad1ed4, Entity.convert(ocd4576614ae2.\u04bd));
    }

    @oc66fa4f2195(priority=oc8ce2882092.HIGHEST)
    public void onScreenRender(oc36adbc80c5 oc36adbc80c52) {
        Object[] objectArray = new Object[0xB65ADE3D ^ 0xB65ADE39];
        objectArray[0] = oc36adbc80c52.\u04ad == null ? "" : oc36adbc80c52.\u04ad.getClass().getSimpleName();
        objectArray[1] = oc36adbc80c52.\u04f3;
        objectArray[0xB65ADE3B ^ 0xB65ADE39] = oc36adbc80c52.\u01f4;
        objectArray[0xB65ADE3A ^ 0xB65ADE39] = Float.valueOf(oc36adbc80c52.\u039d);
        oc2cf3d80e17.\u013e.invoke("onScreenRender", this.f1191ad1ed4, objectArray);
    }

    @oc66fa4f2195(priority=oc8ce2882092.HIGHEST)
    public void onPlayerMove(oca8d3b21c30 oca8d3b21c302) {
        oc2cf3d80e17.\u013e.invoke("onPlayerMove", this.f1191ad1ed4, new Vec3(oca8d3b21c302.\u04ee, oca8d3b21c302.\u0119, oca8d3b21c302.\u0518));
    }

    private void restoreWorldRenderState(Minecraft minecraft, float f) {
        minecraft.entityRenderer.callSetupCameraTransform(minecraft.getTimer().renderPartialTicks, 0);
        this.restoreCommonRenderState();
        GlStateManager.shadeModel(0xE269AF1D ^ 0xE269B21D);
        GlStateManager.enableDepth();
        GlStateManager.depthMask(true);
        GlStateManager.enableCull();
        GlStateManager.disableBlend();
        GlStateManager.disableFog();
        RenderHelper.disableStandardItemLighting();
    }

    private void restoreOverlayRenderState(Minecraft minecraft) {
        minecraft.entityRenderer.setupOverlayRendering();
        this.restoreCommonRenderState();
        GlStateManager.disableDepth();
        GlStateManager.depthMask(true);
        GlStateManager.disableLighting();
        GlStateManager.disableBlend();
        RenderHelper.disableStandardItemLighting();
    }

    private void restoreCommonRenderState() {
        GlStateManager.resetColor();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.colorMask(true, true, true, true);
        GlStateManager.enableTexture2D();
        GlStateManager.enableAlpha();
        GlStateManager.alphaFunc(0xE2388868 ^ 0xE2388A6C, 0.1f);
        GlStateManager.tryBlendFuncSeparate(0xE238896E ^ 0xE2388A6C, 0xE238896F ^ 0xE2388A6C, 1, 0);
        GL11.glLineWidth(1.0f);
        GL11.glDisable(0xE238814C ^ 0xE2388A6C);
        GL11.glDisable(0xE238867D ^ 0xE2388A6C);
    }
}

