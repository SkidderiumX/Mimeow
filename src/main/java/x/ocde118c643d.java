/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.lang.reflect.Field;
import keystrokesmod.oc4ef17ea060;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiDisconnected;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSelectWorld;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.util.IChatComponent;
import org.apache.commons.lang3.StringUtils;
import x.oc110d7f376c;
import x.oc20d79c55a2;
import x.oc54714bd439;
import x.oc5566810b45;
import x.oc66fa4f2195;
import x.oc804fdd8d75;
import x.oc8e5a0b9bfa;
import x.oc9adb807c19;
import x.occ791aa07d0;
import x.ocd6bc26d10b;
import x.oce4fccf5a38;
import x.ocf923d5a814;
import x.ocfbfc7a6736;
import x.ocfc2b827e17;

public class ocde118c643d {
    private static final Minecraft F = Minecraft.getMinecraft();
    public static int V;

    @oc66fa4f2195
    public void \u0512(oc9adb807c19 oc9adb807c192) {
        if (oc9adb807c192.\u04b0 == oc110d7f376c.END) {
            occ791aa07d0.\u04fc();
            ocd6bc26d10b.\u0256();
        }
    }

    @oc66fa4f2195
    public void \u04f5(ocf923d5a814 ocf923d5a8142) {
        block17: {
            GuiScreen guiScreen;
            block16: {
                GuiScreen guiScreen2;
                block15: {
                    Minecraft minecraft;
                    boolean bl;
                    block13: {
                        block14: {
                            block12: {
                                bl = oc4ef17ea060.\u010b;
                                if (ocf923d5a8142.\u04b0 != oc110d7f376c.END) break block12;
                                minecraft = F;
                                if (bl) break block13;
                                if (minecraft.currentScreen != null) break block14;
                            }
                            return;
                        }
                        minecraft = F;
                    }
                    guiScreen = minecraft.currentScreen;
                    guiScreen2 = guiScreen;
                    if (bl) break block15;
                    if (guiScreen2 instanceof GuiSelectWorld) break block16;
                    guiScreen2 = guiScreen;
                }
                if (!(guiScreen2 instanceof GuiMultiplayer)) break block17;
            }
            String string = oc54714bd439.\u01e4(String.format("&7Username: &3%s&r", occ791aa07d0.\u00fe().getUsername()));
            oc20d79c55a2.\u024a(() -> guiScreen.drawString(ocde118c643d.F.fontRendererObj, string, 0x7D519E0A ^ 0x7D519E09, 0x7D519E0A ^ 0x7D519E09, -1));
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @oc66fa4f2195
    public void \u015c(ocfbfc7a6736 ocfbfc7a67362) {
        ocfbfc7a6736 ocfbfc7a67363;
        boolean bl;
        block62: {
            block63: {
                ocfbfc7a6736 ocfbfc7a67364;
                block60: {
                    block61: {
                        bl = oc4ef17ea060.\u010b;
                        ocfbfc7a67364 = ocfbfc7a67362;
                        if (bl) break block60;
                        if (ocfbfc7a67364.\u04ad instanceof GuiSelectWorld) break block61;
                        ocfbfc7a67363 = ocfbfc7a67362;
                        if (bl) break block62;
                        if (!(ocfbfc7a67363.\u04ad instanceof GuiMultiplayer)) break block63;
                    }
                    ocfbfc7a67362.N.removeIf(guiButton -> {
                        int n;
                        block4: {
                            block5: {
                                boolean bl = oc4ef17ea060.\u010b;
                                n = guiButton.id;
                                if (bl) break block4;
                                if (n != (0xAF15DF45 ^ 0xAF15DF00)) break block5;
                                n = 1;
                                break block4;
                            }
                            n = 0;
                        }
                        return n != 0;
                    });
                    ocfbfc7a67364 = ocfbfc7a67362;
                }
                ocfbfc7a67364.N.add(new GuiButton(0xE63FCAA8 ^ 0xE63FCAED, ocfbfc7a67362.\u04ad.width - (0xE63FCA87 ^ 0xE63FCAED), 0xE63FCAEB ^ 0xE63FCAED, 0xE63FCA89 ^ 0xE63FCAED, 0xE63FCAF9 ^ 0xE63FCAED, "Accounts"));
            }
            ocfbfc7a67363 = ocfbfc7a67362;
        }
        if (!(ocfbfc7a67363.\u04ad instanceof GuiDisconnected)) return;
        try {
            long l;
            block59: {
                String string;
                String string2;
                block68: {
                    String string3;
                    block69: {
                        block66: {
                            block67: {
                                block64: {
                                    block65: {
                                        String[] stringArray = new String[0xE63FCAEF ^ 0xE63FCAED];
                                        stringArray[0] = "message";
                                        stringArray[1] = "field_146304_f";
                                        Field field = oc8e5a0b9bfa.\u020a(GuiDisconnected.class, stringArray);
                                        IChatComponent iChatComponent = (IChatComponent)field.get(ocfbfc7a67362.\u04ad);
                                        string3 = iChatComponent.getFormattedText().split("\n\n")[0];
                                        if (bl) break block64;
                                        if (string3.equals("\u00a7r\u00a7cYou are permanently banned from this server!")) break block65;
                                        string2 = string3;
                                        if (bl) break block66;
                                        if (!string2.equals("\u00a7r\u00a7cYour account has been blocked.")) break block67;
                                    }
                                    ocd6bc26d10b.\u010d();
                                }
                                for (oc804fdd8d75 oc804fdd8d752 : ocd6bc26d10b.\u0293) {
                                    if (bl) return;
                                    if (F.getSession().getUsername().equals(oc804fdd8d752.\u014c())) {
                                        oc804fdd8d752.\u041f(0xF41DD0890939D64L ^ 0xF0BE22F76F6C629BL);
                                    }
                                    if (!bl) continue;
                                }
                                ocd6bc26d10b.\u0547();
                                return;
                            }
                            string2 = string3;
                        }
                        if (bl) break block68;
                        if (string2.matches("\u00a7r\u00a7cYou are temporarily banned for \u00a7r\u00a7f.*\u00a7r\u00a7c from this server!")) break block69;
                        string2 = string3;
                        if (bl) break block68;
                        if (!string2.matches("\u00a7r\u00a7cYour account is temporarily blocked for \u00a7r\u00a7f.*\u00a7r\u00a7c from this server!")) return;
                    }
                    string2 = StringUtils.substringBetween(string3, "\u00a7r\u00a7f", "\u00a7r\u00a7c");
                }
                if ((string = string2) == null) return;
                l = System.currentTimeMillis();
                block40: for (String string4 : string.split(" ")) {
                    int n;
                    long l2;
                    block70: {
                        if (bl) break block59;
                        String string5 = string4.substring(string4.length() - 1);
                        l2 = Long.parseLong(string4.substring(0, string4.length() - 1));
                        String string6 = string5;
                        int n2 = -1;
                        n = string6.hashCode();
                        if (bl) break block70;
                        switch (n) {
                            case 100: {
                                n = string6.equals("d") ? 1 : 0;
                                if (!bl) {
                                    if (n == 0) break;
                                    n2 = 0;
                                    if (!bl) break;
                                }
                                break block70;
                            }
                            case 104: {
                                n = string6.equals("h") ? 1 : 0;
                                if (!bl) {
                                    if (n == 0) break;
                                    n2 = 1;
                                    if (!bl) break;
                                }
                                break block70;
                            }
                            case 109: {
                                n = string6.equals("m") ? 1 : 0;
                                if (!bl) {
                                    if (n == 0) break;
                                    n2 = 0xE63FCAEF ^ 0xE63FCAED;
                                    if (!bl) break;
                                }
                                break block70;
                            }
                            case 115: {
                                n = string6.equals("s") ? 1 : 0;
                                if (bl) break block70;
                                if (n == 0) break;
                                n2 = 0xE63FCAEE ^ 0xE63FCAED;
                            }
                        }
                        n = n2;
                    }
                    switch (n) {
                        case 0: {
                            l += l2 * (0xF0BE22F76A4A3E9BL ^ 0xF0BE22F76F6C629BL);
                            if (!bl) continue block40;
                        }
                        case 1: {
                            l += l2 * (0xF0BE22F76F5A8C1BL ^ 0xF0BE22F76F6C629BL);
                            if (!bl) continue block40;
                        }
                        case 2: {
                            l += l2 * (0xF0BE22F76F6C88FBL ^ 0xF0BE22F76F6C629BL);
                            if (!bl) continue block40;
                        }
                        case 3: {
                            l += l2 * (0xF0BE22F76F6C6173L ^ 0xF0BE22F76F6C629BL);
                            continue block40;
                        }
                    }
                    if (!bl) continue;
                }
                ocd6bc26d10b.\u010d();
            }
            for (oc804fdd8d75 oc804fdd8d753 : ocd6bc26d10b.\u0293) {
                if (bl) return;
                if (F.getSession().getUsername().equals(oc804fdd8d753.\u014c())) {
                    oc804fdd8d753.\u041f(l);
                }
                if (!bl) continue;
            }
            ocd6bc26d10b.\u0547();
            return;
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    @oc66fa4f2195
    public void \u0191(oc5566810b45 oc5566810b452) {
        block13: {
            oc5566810b45 oc5566810b453;
            block11: {
                block12: {
                    boolean bl = oc4ef17ea060.\u010b;
                    oc5566810b453 = oc5566810b452;
                    if (bl) break block11;
                    if (oc5566810b453.\u04ad instanceof GuiSelectWorld) break block12;
                    oc5566810b453 = oc5566810b452;
                    if (bl) break block11;
                    if (!(oc5566810b453.\u04ad instanceof GuiMultiplayer)) break block13;
                }
                oc5566810b453 = oc5566810b452;
            }
            if (oc5566810b453.\u019a.id == (0x12D99A77 ^ 0x12D99A32)) {
                F.displayGuiScreen(new ocfc2b827e17(oc5566810b452.\u04ad));
            }
        }
    }

    @oc66fa4f2195
    public void \u03af(oce4fccf5a38 oce4fccf5a382) {
        block14: {
            boolean bl;
            block15: {
                block16: {
                    ServerData serverData;
                    block13: {
                        ServerData serverData2 = F.getCurrentServerData();
                        bl = oc4ef17ea060.\u010b;
                        serverData = serverData2;
                        if (bl) break block13;
                        if (serverData == null) break block14;
                        serverData = serverData2;
                    }
                    String string = serverData.serverIP;
                    if (bl) break block15;
                    if (string.endsWith("hypixel.net")) break block16;
                    if (!string.endsWith("hypixel.io")) break block14;
                }
                ocd6bc26d10b.\u010d();
            }
            for (oc804fdd8d75 oc804fdd8d752 : ocd6bc26d10b.\u0293) {
                block17: {
                    if (bl) break block14;
                    if (!F.getSession().getUsername().equals(oc804fdd8d752.\u014c())) break block17;
                    oc804fdd8d752.\u041f(0L);
                }
                if (!bl) continue;
            }
            ocd6bc26d10b.\u0547();
        }
    }
}

