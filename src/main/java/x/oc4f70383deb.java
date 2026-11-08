/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.Locale;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import x.oc8ecfa69e1b;
import x.occ0b63c0426;

public class oc4f70383deb {
    private final Minecraft \u049e = Minecraft.getMinecraft();
    public static boolean \u0213;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private KeyBinding \u049c(String string) {
        int n;
        block55: {
            String string2 = string.toLowerCase(Locale.ROOT);
            int n2 = -1;
            int n3 = occ0b63c0426.\u039f;
            n = string2.hashCode();
            if (n3 != 0) break block55;
            switch (n) {
                case -677145915: {
                    n = string2.equals("forward") ? 1 : 0;
                    if (n3 == 0) {
                        if (n == 0) break;
                        n2 = 0;
                        if (n3 == 0) break;
                    }
                    break block55;
                }
                case 3015911: {
                    n = string2.equals("back") ? 1 : 0;
                    if (n3 == 0) {
                        if (n == 0) break;
                        n2 = 1;
                        if (n3 == 0) break;
                    }
                    break block55;
                }
                case 3317767: {
                    n = string2.equals("left") ? 1 : 0;
                    if (n3 == 0) {
                        if (n == 0) break;
                        n2 = 0x9B926F1C ^ 0x9B926F1E;
                        if (n3 == 0) break;
                    }
                    break block55;
                }
                case 108511772: {
                    n = string2.equals("right") ? 1 : 0;
                    if (n3 == 0) {
                        if (n == 0) break;
                        n2 = 0x9B926F1D ^ 0x9B926F1E;
                        if (n3 == 0) break;
                    }
                    break block55;
                }
                case 3273774: {
                    n = string2.equals("jump") ? 1 : 0;
                    if (n3 == 0) {
                        if (n == 0) break;
                        n2 = 0x9B926F1A ^ 0x9B926F1E;
                        if (n3 == 0) break;
                    }
                    break block55;
                }
                case 109582100: {
                    n = string2.equals("sneak") ? 1 : 0;
                    if (n3 == 0) {
                        if (n == 0) break;
                        n2 = 0x9B926F1B ^ 0x9B926F1E;
                        if (n3 == 0) break;
                    }
                    break block55;
                }
                case -895679974: {
                    n = string2.equals("sprint") ? 1 : 0;
                    if (n3 == 0) {
                        if (n == 0) break;
                        n2 = 0x9B926F18 ^ 0x9B926F1E;
                        if (n3 == 0) break;
                    }
                    break block55;
                }
                case 116103: {
                    n = string2.equals("use") ? 1 : 0;
                    if (n3 == 0) {
                        if (n == 0) break;
                        n2 = 0x9B926F19 ^ 0x9B926F1E;
                        if (n3 == 0) break;
                    }
                    break block55;
                }
                case -1407259064: {
                    n = string2.equals("attack") ? 1 : 0;
                    if (n3 == 0) {
                        if (n == 0) break;
                        n2 = 0x9B926F16 ^ 0x9B926F1E;
                        if (n3 == 0) break;
                    }
                    break block55;
                }
                case 0x2F2EEF: {
                    n = string2.equals("drop") ? 1 : 0;
                    if (n3 != 0) break block55;
                    if (n == 0) break;
                    n2 = 0x9B926F17 ^ 0x9B926F1E;
                }
            }
            n = n2;
        }
        switch (n) {
            case 0: {
                return this.\u049e.gameSettings.keyBindForward;
            }
            case 1: {
                return this.\u049e.gameSettings.keyBindBack;
            }
            case 2: {
                return this.\u049e.gameSettings.keyBindLeft;
            }
            case 3: {
                return this.\u049e.gameSettings.keyBindRight;
            }
            case 4: {
                return this.\u049e.gameSettings.keyBindJump;
            }
            case 5: {
                return this.\u049e.gameSettings.keyBindSneak;
            }
            case 6: {
                return this.\u049e.gameSettings.keyBindSprint;
            }
            case 7: {
                return this.\u049e.gameSettings.keyBindUseItem;
            }
            case 8: {
                return this.\u049e.gameSettings.keyBindAttack;
            }
            case 9: {
                return this.\u049e.gameSettings.keyBindDrop;
            }
        }
        return null;
    }

    public void \u029d(String string, boolean bl) {
        block3: {
            KeyBinding keyBinding;
            block2: {
                KeyBinding keyBinding2 = this.\u049c(string);
                int n = occ0b63c0426.\u039f;
                keyBinding = keyBinding2;
                if (n != 0) break block2;
                if (keyBinding == null) break block3;
                keyBinding = keyBinding2;
            }
            KeyBinding.setKeyBindState(keyBinding.getKeyCode(), bl);
        }
    }

    public void \u0172(int n, boolean bl) {
        int n2;
        block4: {
            block5: {
                int n3 = occ0b63c0426.\u039f;
                n2 = n;
                if (n3 != 0) break block4;
                if (n2 < (0xB627474B ^ 0xB62744A3)) break block5;
                return;
            }
            n2 = n;
        }
        KeyBinding.setKeyBindState(n2, bl);
    }

    public boolean \u0116(String string) {
        boolean bl;
        block6: {
            block5: {
                KeyBinding keyBinding;
                int n;
                block4: {
                    KeyBinding keyBinding2 = this.\u049c(string);
                    n = occ0b63c0426.\u039f;
                    keyBinding = keyBinding2;
                    if (n != 0) break block4;
                    if (keyBinding == null) break block5;
                    keyBinding = keyBinding2;
                }
                bl = keyBinding.isKeyDown();
                if (n != 0) break block6;
                if (!bl) break block5;
                bl = true;
                break block6;
            }
            bl = false;
        }
        return bl;
    }

    public boolean \u038e(int n) {
        return this.\u01ab(n);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int \u04cf(String string) {
        int n;
        KeyBinding keyBinding2;
        int n2 = occ0b63c0426.\u039f;
        String string2 = string;
        if (n2 == 0) {
            if (string2 == null) {
                return 0;
            }
            string2 = string.trim().toUpperCase(Locale.ROOT);
        }
        String string22 = string2;
        int n3 = string22.startsWith("MOUSE");
        if (n2 != 0) return n3;
        if (n3 != 0) {
            try {
                n3 = (0x8ABE8EBF ^ 0x8ABE8D57) + Integer.parseInt(string22.substring(0x8ABE8D52 ^ 0x8ABE8D57));
                return n3;
            }
            catch (NumberFormatException numberFormatException) {
                return 0;
            }
        }
        KeyBinding keyBinding = keyBinding2 = this.\u049c(string22);
        if (n2 == 0) {
            if (keyBinding == null) {
                n = Keyboard.getKeyIndex(string22);
                return n;
            }
            keyBinding = keyBinding2;
        }
        n = keyBinding.getKeyCode();
        return n;
    }

    public int \u00e7(String string) {
        return this.\u04cf(string);
    }

    public int \u0412(String string) {
        return this.\u04cf(string);
    }

    public int[] \u0295() {
        int[] nArray = new int[0xCEE05030 ^ 0xCEE05032];
        nArray[0] = Mouse.getX();
        nArray[1] = Mouse.getY();
        return nArray;
    }

    public int \u022e() {
        return Mouse.getDWheel();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean \u01ab(int n) {
        int n2;
        block12: {
            int n3;
            block10: {
                block11: {
                    n3 = occ0b63c0426.\u039f;
                    n2 = n;
                    if (n3 != 0) break block10;
                    if (n2 < (0x602759D9 ^ 0x60275A31)) break block11;
                    return Mouse.isButtonDown(n - (0x602759D9 ^ 0x60275A31));
                }
                n2 = n;
            }
            if (n3 != 0) break block12;
            if (n2 <= 0) return 0 != 0;
            int n4 = n;
            if (n3 != 0) return n4 != 0;
            n2 = Keyboard.isKeyDown(n4) ? 1 : 0;
        }
        if (n2 == 0) return 0 != 0;
        return 1 != 0;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean \u047d(int n) {
        int n2;
        block6: {
            int n3 = occ0b63c0426.\u039f;
            n2 = n;
            if (n3 != 0) break block6;
            if (n2 < 0) return 0 != 0;
            int n4 = n;
            if (n3 != 0) return n4 != 0;
            n2 = Mouse.isButtonDown(n4) ? 1 : 0;
        }
        if (n2 == 0) return 0 != 0;
        return 1 != 0;
    }

    public void \u0519(String string) {
        block3: {
            KeyBinding keyBinding;
            block2: {
                KeyBinding keyBinding2 = this.\u049c(string);
                int n = occ0b63c0426.\u039f;
                keyBinding = keyBinding2;
                if (n != 0) break block2;
                if (keyBinding == null) break block3;
                keyBinding = keyBinding2;
            }
            KeyBinding.onTick(keyBinding.getKeyCode());
        }
    }

    public void \u03a1() {
        block5: {
            oc4f70383deb oc4f70383deb2;
            block4: {
                int n = occ0b63c0426.\u039f;
                oc4f70383deb2 = this;
                if (n != 0) break block4;
                if (!(oc4f70383deb2.\u049e instanceof oc8ecfa69e1b)) break block5;
                oc4f70383deb2 = this;
            }
            oc4f70383deb2.\u049e.callClickMouse();
        }
    }

    public void \u0173() {
        block5: {
            oc4f70383deb oc4f70383deb2;
            block4: {
                int n = occ0b63c0426.\u039f;
                oc4f70383deb2 = this;
                if (n != 0) break block4;
                if (!(oc4f70383deb2.\u049e instanceof oc8ecfa69e1b)) break block5;
                oc4f70383deb2 = this;
            }
            oc4f70383deb2.\u049e.callRightClickMouse();
        }
    }
}

