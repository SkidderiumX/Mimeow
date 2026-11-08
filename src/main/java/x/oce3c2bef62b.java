/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.List;
import java.util.Locale;
import x.oc019d1ae7a9;
import x.ocf7a7942e84;

public enum oce3c2bef62b {
    \u04ee("windows-x64", "windows/x64/org/lwjgl/", List.of(new ocf7a7942e84("lwjgl.dll", "lwjgl.dll"), new ocf7a7942e84("glfw/glfw.dll", "glfw.dll"), new ocf7a7942e84("opengl/lwjgl_opengl.dll", "lwjgl_opengl.dll"), new ocf7a7942e84("openal/OpenAL.dll", "OpenAL.dll"))),
    \u0423("linux-x64", "linux/x64/org/lwjgl/", List.of(new ocf7a7942e84("liblwjgl.so", "liblwjgl.so"), new ocf7a7942e84("glfw/libglfw.so", "libglfw.so"), new ocf7a7942e84("opengl/liblwjgl_opengl.so", "liblwjgl_opengl.so"), new ocf7a7942e84("openal/libopenal.so", "libopenal.so")));
    private static final oce3c2bef62b[] $VALUES_REF;
    static {
        $VALUES_REF = oce3c2bef62b.\u02af();
    }


    private final String \u0118;
    private final String \u0130;
    private final List<ocf7a7942e84> \u048e;


    private oce3c2bef62b(String string2, String string3, List<ocf7a7942e84> list) {
        this.\u0118 = string2;
        this.\u0130 = string3;
        this.\u048e = list;
    }

    private static oce3c2bef62b \u03a6(String string, String string2) {
        String string3;
        block41: {
            boolean bl;
            String string4;
            block39: {
                boolean bl2;
                block40: {
                    boolean bl3;
                    block36: {
                        block38: {
                            block37: {
                                String string5;
                                block35: {
                                    String string6;
                                    block33: {
                                        block34: {
                                            String string7;
                                            block32: {
                                                String string8;
                                                block30: {
                                                    block31: {
                                                        bl2 = oc019d1ae7a9.\u051e;
                                                        string8 = string;
                                                        if (bl2) break block30;
                                                        if (string8 != null) break block31;
                                                        string7 = "";
                                                        break block32;
                                                    }
                                                    string8 = string;
                                                }
                                                string7 = string8.toLowerCase(Locale.ROOT);
                                            }
                                            string4 = string7;
                                            string6 = string2;
                                            if (bl2) break block33;
                                            if (string6 != null) break block34;
                                            string5 = "";
                                            break block35;
                                        }
                                        string6 = string2;
                                    }
                                    string5 = string6.toLowerCase(Locale.ROOT);
                                }
                                String string9 = string5;
                                bl3 = string9.equals("amd64");
                                if (bl2) break block36;
                                if (bl3) break block37;
                                bl3 = string9.equals("x86_64");
                                if (bl2) break block36;
                                if (bl3) break block37;
                                bl3 = string9.equals("x64");
                                if (bl2) break block36;
                                if (!bl3) break block38;
                            }
                            bl3 = true;
                            break block36;
                        }
                        bl3 = false;
                    }
                    boolean bl4 = bl3;
                    bl = bl4;
                    if (bl2) break block39;
                    if (bl) break block40;
                    return null;
                }
                string3 = string4;
                if (bl2) break block41;
                bl = string3.contains("win");
            }
            if (bl) {
                return \u04ee;
            }
            string3 = string4;
        }
        if (string3.contains("linux")) {
            return \u0423;
        }
        return null;
    }

    private static oce3c2bef62b[] \u02af() {
        oce3c2bef62b[] oce3c2bef62bArray = new oce3c2bef62b[0xEDD56F88 ^ 0xEDD56F8A];
        oce3c2bef62bArray[0] = \u04ee;
        oce3c2bef62bArray[1] = \u0423;
        return oce3c2bef62bArray;
    }
}

