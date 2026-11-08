/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui.spectator;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiSpectator;
import net.minecraft.client.gui.spectator.BaseSpectatorGroup;
import net.minecraft.client.gui.spectator.ISpectatorMenuObject;
import net.minecraft.client.gui.spectator.ISpectatorMenuRecipient;
import net.minecraft.client.gui.spectator.ISpectatorMenuView;
import net.minecraft.client.gui.spectator.categories.SpectatorDetails;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;

public class SpectatorMenu {
    private static final ISpectatorMenuObject field_178655_b = new EndSpectatorObject();
    private static final ISpectatorMenuObject field_178656_c = new MoveMenuObject(-1, true);
    private static final ISpectatorMenuObject field_178653_d = new MoveMenuObject(1, true);
    private static final ISpectatorMenuObject field_178654_e = new MoveMenuObject(1, false);
    public static final ISpectatorMenuObject field_178657_a = new ISpectatorMenuObject(){

        @Override
        public void func_178661_a(SpectatorMenu spectatorMenu) {
        }

        @Override
        public IChatComponent getSpectatorName() {
            return new ChatComponentText("");
        }

        @Override
        public void func_178663_a(float f, int n) {
        }

        @Override
        public boolean func_178662_A_() {
            return false;
        }
    };
    private final ISpectatorMenuRecipient field_178651_f;
    private final List<SpectatorDetails> field_178652_g = Lists.newArrayList();
    private ISpectatorMenuView field_178659_h = new BaseSpectatorGroup();
    private int field_178660_i = -1;
    private int field_178658_j;

    public SpectatorMenu(ISpectatorMenuRecipient iSpectatorMenuRecipient) {
        this.field_178651_f = iSpectatorMenuRecipient;
    }

    public ISpectatorMenuObject func_178643_a(int n) {
        int n2 = n + this.field_178658_j * 6;
        return this.field_178658_j > 0 && n == 0 ? field_178656_c : (n == 7 ? (n2 < this.field_178659_h.func_178669_a().size() ? field_178653_d : field_178654_e) : (n == 8 ? field_178655_b : (n2 >= 0 && n2 < this.field_178659_h.func_178669_a().size() ? Objects.firstNonNull(this.field_178659_h.func_178669_a().get(n2), field_178657_a) : field_178657_a)));
    }

    public List<ISpectatorMenuObject> func_178642_a() {
        ArrayList<ISpectatorMenuObject> arrayList = Lists.newArrayList();
        for (int i = 0; i <= 8; ++i) {
            arrayList.add(this.func_178643_a(i));
        }
        return arrayList;
    }

    public ISpectatorMenuObject func_178645_b() {
        return this.func_178643_a(this.field_178660_i);
    }

    public ISpectatorMenuView func_178650_c() {
        return this.field_178659_h;
    }

    public void func_178644_b(int n) {
        ISpectatorMenuObject iSpectatorMenuObject = this.func_178643_a(n);
        if (iSpectatorMenuObject != field_178657_a) {
            if (this.field_178660_i == n && iSpectatorMenuObject.func_178662_A_()) {
                iSpectatorMenuObject.func_178661_a(this);
            } else {
                this.field_178660_i = n;
            }
        }
    }

    public void func_178641_d() {
        this.field_178651_f.func_175257_a(this);
    }

    public int func_178648_e() {
        return this.field_178660_i;
    }

    public void func_178647_a(ISpectatorMenuView iSpectatorMenuView) {
        this.field_178652_g.add(this.func_178646_f());
        this.field_178659_h = iSpectatorMenuView;
        this.field_178660_i = -1;
        this.field_178658_j = 0;
    }

    public SpectatorDetails func_178646_f() {
        return new SpectatorDetails(this.field_178659_h, this.func_178642_a(), this.field_178660_i);
    }

    public static class EndSpectatorObject
    implements ISpectatorMenuObject {
        private EndSpectatorObject() {
        }

        @Override
        public void func_178661_a(SpectatorMenu spectatorMenu) {
            spectatorMenu.func_178641_d();
        }

        @Override
        public IChatComponent getSpectatorName() {
            return new ChatComponentText("Close menu");
        }

        @Override
        public void func_178663_a(float f, int n) {
            Minecraft.getMinecraft().getTextureManager().bindTexture(GuiSpectator.field_175269_a);
            Gui.drawModalRectWithCustomSizedTexture(0, 0, 128.0f, 0.0f, 16, 16, 256.0f, 256.0f);
        }

        @Override
        public boolean func_178662_A_() {
            return true;
        }
    }

    public static class MoveMenuObject
    implements ISpectatorMenuObject {
        private final int field_178666_a;
        private final boolean field_178665_b;

        public MoveMenuObject(int n, boolean bl) {
            this.field_178666_a = n;
            this.field_178665_b = bl;
        }

        @Override
        public void func_178661_a(SpectatorMenu spectatorMenu) {
            spectatorMenu.field_178658_j = this.field_178666_a;
        }

        @Override
        public IChatComponent getSpectatorName() {
            return this.field_178666_a < 0 ? new ChatComponentText("Previous Page") : new ChatComponentText("Next Page");
        }

        @Override
        public void func_178663_a(float f, int n) {
            Minecraft.getMinecraft().getTextureManager().bindTexture(GuiSpectator.field_175269_a);
            if (this.field_178666_a < 0) {
                Gui.drawModalRectWithCustomSizedTexture(0, 0, 144.0f, 0.0f, 16, 16, 256.0f, 256.0f);
            } else {
                Gui.drawModalRectWithCustomSizedTexture(0, 0, 160.0f, 0.0f, 16, 16, 256.0f, 256.0f);
            }
        }

        @Override
        public boolean func_178662_A_() {
            return this.field_178665_b;
        }
    }
}

