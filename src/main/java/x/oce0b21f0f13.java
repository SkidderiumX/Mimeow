/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.io.IOException;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import x.oc59f7c2bbde;
import x.oc89eb238246;
import x.oca4800eb63f;
import x.ocbd4917c4b1;

public class oce0b21f0f13
extends GuiScreen {
    private oc59f7c2bbde \u011d;
    private boolean \u051f;
    private float \u0573;
    private float \u0128;
    private float \u038f;
    private float \u00c3;
    private int \u04bf;
    private int \u056e;
    final oca4800eb63f this$0;

    private oce0b21f0f13(oca4800eb63f oca4800eb63f2) {
        this.this$0 = oca4800eb63f2;
    }

    @Override
    public void initGui() {
        super.initGui();
        this.\u011d = new oc59f7c2bbde(1, this.width - (0x166FE6D5 ^ 0x166FE68F), this.height - (0x166FE696 ^ 0x166FE68F), 0x166FE6DA ^ 0x166FE68F, 0x166FE69B ^ 0x166FE68F, "Reset position");
        this.buttonList.add(this.\u011d);
        this.this$0.\u00d1(new ScaledResolution(this.mc));
        this.\u0573 = this.this$0.\u0197;
        this.\u0128 = this.this$0.\u0561;
        int n = oc89eb238246.\u0127;
        if (false) {
            oc89eb238246.\u0127 = ++n;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void drawScreen(int n, int n2, float f) {
        int n3 = oc89eb238246.\u0127;
        ScaledResolution scaledResolution = new ScaledResolution(this.mc);
        if (n3 == 0) {
            if (!this.\u051f) {
                this.this$0.\u00d1(scaledResolution);
                this.\u0573 = this.this$0.\u0197;
                this.\u0128 = this.this$0.\u0561;
            }
            Gui.drawRect(0, 0, this.width, this.height, 0x1B78E6C4 ^ 0xA978E6C4);
            this.this$0.\u050c(this.\u0573, this.\u0128, scaledResolution);
            this.this$0.\u04bc(true);
            this.\u0573 = this.this$0.\u0197;
            this.\u0128 = this.this$0.\u0561;
        }
        String string = "Drag the icon to reposition it.";
        int n4 = scaledResolution.getScaledWidth() / (0xA978E6C6 ^ 0xA978E6C4) - this.fontRendererObj.getStringWidth(string) / (0xA978E6C6 ^ 0xA978E6C4);
        int n5 = scaledResolution.getScaledHeight() / (0xA978E6C6 ^ 0xA978E6C4) - (0xA978E6CE ^ 0xA978E6C4);
        ocbd4917c4b1.\u00c8(string, (char)(0xA978E6E9 ^ 0xA978E6C4), n4, n5, 0x71DB4AA74CB565C3L ^ 0x71DB4AA74CB565C1L, 0L, true, this.fontRendererObj);
        try {
            this.handleInput();
        }
        catch (IOException iOException) {
            // empty catch block
        }
        super.drawScreen(n, n2, f);
    }

    @Override
    protected void mouseClickMove(int n, int n2, int n3, long l) {
        block28: {
            float f;
            float f2;
            block30: {
                float f3;
                float f4;
                int n4;
                block29: {
                    float f5;
                    block27: {
                        oce0b21f0f13 oce0b21f0f132;
                        block25: {
                            block26: {
                                block23: {
                                    block24: {
                                        n4 = oc89eb238246.\u0127;
                                        oce0b21f0f132 = this;
                                        if (n4 != 0) break block23;
                                        super.mouseClickMove(n, n2, n3, l);
                                        if (n3 == 0) break block24;
                                        return;
                                    }
                                    oce0b21f0f132 = this;
                                }
                                if (n4 != 0) break block25;
                                if (!oce0b21f0f132.\u051f) break block26;
                                this.\u0573 = this.\u038f + (float)n - (float)this.\u04bf;
                                this.\u0128 = this.\u00c3 + (float)n2 - (float)this.\u056e;
                                return;
                            }
                            oce0b21f0f132 = this;
                        }
                        float f6 = (float)oce0b21f0f132.this$0.\u027e.\u04c1();
                        int n5 = Math.round(16.0f * f6);
                        float f7 = this.this$0.\u0197 - (float)n5 / 2.0f - 2.0f;
                        f4 = this.this$0.\u0561 - (float)n5 / 2.0f - 2.0f;
                        f5 = this.this$0.\u0197 + (float)n5 / 2.0f + 2.0f;
                        f3 = this.this$0.\u0561 + (float)n5 / 2.0f + 2.0f;
                        f2 = n;
                        if (n4 != 0) break block27;
                        if (!(f2 >= f7)) break block28;
                        f2 = n;
                    }
                    if (n4 != 0) break block29;
                    if (!(f2 <= f5)) break block28;
                    f2 = n2;
                }
                f = f4;
                if (n4 != 0) break block30;
                if (!(f2 >= f)) break block28;
                f2 = n2;
                f = f3;
            }
            if (f2 <= f) {
                this.\u051f = true;
                this.\u04bf = n;
                this.\u056e = n2;
                this.\u038f = this.\u0573;
                this.\u00c3 = this.\u0128;
            }
        }
    }

    @Override
    protected void mouseReleased(int n, int n2, int n3) {
        block5: {
            block4: {
                int n4 = oc89eb238246.\u0127;
                oce0b21f0f13 oce0b21f0f132 = this;
                if (n4 != 0) break block4;
                super.mouseReleased(n, n2, n3);
                if (n3 != 0) break block5;
                oce0b21f0f132 = this;
            }
            oce0b21f0f132.\u051f = false;
        }
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) {
        if (guiButton == this.\u011d) {
            this.this$0.\u0496();
            this.\u0573 = this.this$0.\u0197;
            this.\u0128 = this.this$0.\u0561;
        }
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
}

