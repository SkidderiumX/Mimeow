/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.Collections;
import java.util.List;
import net.minecraft.client.Minecraft;
import x.oc161f4adba4;
import x.oc17aaf5d285;
import x.oc24b4725b15;
import x.ocaae9de8508;
import x.ocf65052963e;

public class oc54ec615c9f
extends oc161f4adba4 {
    public static int \u01ff;

    public oc54ec615c9f() {
        String[] stringArray = new String[0x7B77AA6B ^ 0x7B77AA69];
        stringArray[0] = "scripteditor";
        stringArray[1] = "se";
        super("scripteditor", "Open the in-game script editor.", oc17aaf5d285.\u0572, stringArray, "se");
    }

    @Override
    public void z$2uoow1halcq2f(ocaae9de8508 ocaae9de85082) {
        block14: {
            Minecraft minecraft;
            Minecraft minecraft2;
            String string;
            block12: {
                block13: {
                    String string2;
                    int n;
                    block15: {
                        block11: {
                            ocaae9de8508 ocaae9de85083;
                            block10: {
                                n = oc24b4725b15.\u0395;
                                ocaae9de85083 = ocaae9de85082;
                                if (n != 0) break block10;
                                if (ocaae9de85083.\u0443().length < 1) break block11;
                                ocaae9de85083 = ocaae9de85082;
                            }
                            string2 = ocaae9de85083.\u044c(0);
                            break block15;
                        }
                        string2 = null;
                    }
                    string = string2;
                    minecraft2 = Minecraft.getMinecraft();
                    minecraft = minecraft2;
                    if (n != 0) break block12;
                    if (!minecraft.isCallingFromMinecraftThread()) break block13;
                    minecraft2.displayGuiScreen(new ocf65052963e(string));
                    if (n == 0) break block14;
                }
                minecraft = minecraft2;
            }
            minecraft.addScheduledTask(() -> minecraft2.displayGuiScreen(new ocf65052963e(string)));
        }
    }

    @Override
    public List<String> z$9ofids0wyz4j(ocaae9de8508 ocaae9de85082) {
        return Collections.emptyList();
    }
}

