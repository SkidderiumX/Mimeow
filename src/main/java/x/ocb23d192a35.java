/*
 * Decompiled with CFR 0.152.
 */
package x;

import com.google.gson.JsonObject;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import x.N;
import x.oc8eb3e96b6e;
import x.oca9cc61aada;
import x.occc831eff22;

public class ocb23d192a35
extends N {
    private int \u037b;
    public occc831eff22 \u044d;
    public static boolean \u048d;

    public ocb23d192a35(String string, int n) {
        super(string);
        this.\u037b = n;
    }

    public ocb23d192a35(occc831eff22 occc831eff222, String string, int n) {
        super(string);
        this.\u044d = occc831eff222;
        this.\u037b = n;
    }

    public int \u01fa() {
        return this.\u037b;
    }

    @Override
    public String z$18nrktuqeiysv() {
        return super.z$18nrktuqeiysv();
    }

    @Override
    public String z$3lm3x0je4b2zv() {
        Object object;
        block6: {
            ocb23d192a35 ocb23d192a352;
            block4: {
                block5: {
                    int n = oca9cc61aada.\u01f7;
                    ocb23d192a352 = this;
                    if (n != 0) break block4;
                    if (ocb23d192a352.\u044d != null) break block5;
                    object = this.z$18nrktuqeiysv();
                    break block6;
                }
                ocb23d192a352 = this;
            }
            object = ocb23d192a352.\u044d.z$18nrktuqeiysv() + "." + this.z$18nrktuqeiysv();
        }
        return object;
    }

    public void \u00c8(int n) {
        this.\u037b = n;
    }

    public boolean \u0190() {
        ocb23d192a35 ocb23d192a352;
        block18: {
            block19: {
                boolean bl;
                block24: {
                    ocb23d192a35 ocb23d192a353;
                    block22: {
                        block23: {
                            ocb23d192a35 ocb23d192a354;
                            block20: {
                                block21: {
                                    int n;
                                    block16: {
                                        block17: {
                                            n = oca9cc61aada.\u01f7;
                                            ocb23d192a352 = this;
                                            if (n != 0) break block16;
                                            if (ocb23d192a352.\u01fa() != 0) break block17;
                                            return false;
                                        }
                                        ocb23d192a352 = this;
                                    }
                                    if (n != 0) break block18;
                                    if (ocb23d192a352.\u01fa() < (0x6B803A38 ^ 0x6B8039D0)) break block19;
                                    ocb23d192a354 = this;
                                    if (n != 0) break block20;
                                    if (ocb23d192a354.\u01fa() == (0x6B803DFD ^ 0x6B8039D0)) break block21;
                                    ocb23d192a353 = this;
                                    if (n != 0) break block22;
                                    if (ocb23d192a353.\u01fa() != (0x6B803DFE ^ 0x6B8039D0)) break block23;
                                }
                                ocb23d192a354 = this;
                            }
                            bl = oc8eb3e96b6e.\u0533(ocb23d192a354.\u01fa());
                            break block24;
                        }
                        ocb23d192a353 = this;
                    }
                    bl = Mouse.isButtonDown(ocb23d192a353.\u01fa() - (0x6B803A38 ^ 0x6B8039D0));
                }
                return bl;
            }
            ocb23d192a352 = this;
        }
        return Keyboard.isKeyDown(ocb23d192a352.\u01fa());
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void z$3ktkzjg2sjswq(JsonObject jsonObject) {
        block9: {
            int n;
            String string;
            block10: {
                String string2;
                JsonObject jsonObject2;
                int n2;
                block8: {
                    String string3 = this.z$3lm3x0je4b2zv();
                    String string4 = this.z$18nrktuqeiysv();
                    n2 = oca9cc61aada.\u01f7;
                    string = jsonObject.has(string3) ? string3 : string4;
                    jsonObject2 = jsonObject;
                    string2 = string;
                    if (n2 != 0) break block8;
                    if (!jsonObject2.has(string2)) break block9;
                    jsonObject2 = jsonObject;
                    string2 = string;
                }
                n = jsonObject2.get(string2).isJsonPrimitive();
                if (n2 != 0) break block10;
                if (n == 0) break block9;
                n = this.\u037b;
            }
            int n3 = n;
            try {
                n3 = jsonObject.getAsJsonPrimitive(string).getAsInt();
            }
            catch (Exception exception) {
                // empty catch block
            }
            this.\u037b = n3;
        }
    }
}

