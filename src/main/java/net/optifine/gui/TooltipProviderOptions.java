/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.gui;

import java.awt.Rectangle;
import java.util.ArrayList;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.settings.GameSettings;
import net.optifine.Lang;
import net.optifine.gui.IOptionControl;
import net.optifine.gui.TooltipProvider;

public class TooltipProviderOptions
implements TooltipProvider {
    @Override
    public Rectangle getTooltipBounds(GuiScreen guiScreen, int n, int n2) {
        int n3 = guiScreen.width / 2 - 150;
        int n4 = guiScreen.height / 6 - 7;
        if (n2 <= n4 + 98) {
            n4 += 105;
        }
        int n5 = n3 + 150 + 150;
        int n6 = n4 + 84 + 10;
        return new Rectangle(n3, n4, n5 - n3, n6 - n4);
    }

    @Override
    public boolean isRenderBorder() {
        return false;
    }

    @Override
    public String[] getTooltipLines(GuiButton guiButton, int n) {
        if (!(guiButton instanceof IOptionControl)) {
            return null;
        }
        IOptionControl iOptionControl = (IOptionControl)((Object)guiButton);
        GameSettings.Options options = iOptionControl.getOption();
        String[] stringArray = TooltipProviderOptions.getTooltipLines(options.getEnumString());
        return stringArray;
    }

    public static String[] getTooltipLines(String string) {
        String string2;
        String string3;
        ArrayList<String> arrayList = new ArrayList<String>();
        for (int i = 0; i < 10 && (string3 = Lang.get(string2 = string + ".tooltip." + (i + 1), null)) != null; ++i) {
            arrayList.add(string3);
        }
        if (arrayList.size() <= 0) {
            return null;
        }
        String[] stringArray = arrayList.toArray(new String[arrayList.size()]);
        return stringArray;
    }
}

