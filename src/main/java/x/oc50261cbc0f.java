/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import x.occ0b63c0426;

public class oc50261cbc0f {
    public final ChatComponentText \u0228;
    public static int p;

    public oc50261cbc0f(String string) {
        this.\u0228 = new ChatComponentText(occ0b63c0426.\u03bb(string));
    }

    public oc50261cbc0f \u0271(String string) {
        String string2;
        ChatComponentText chatComponentText;
        block2: {
            block3: {
                int n = occ0b63c0426.\u039f;
                chatComponentText = this.\u0228;
                string2 = string;
                if (n != 0) break block2;
                if (string2 != null) break block3;
                string2 = "";
                break block2;
            }
            string2 = string;
        }
        chatComponentText.appendText(string2);
        return this;
    }

    public void \u0408(String string, String string2, String string3, String string4) {
        this.\u0271(string);
    }

    public List<oc50261cbc0f> \u039a() {
        ArrayList<oc50261cbc0f> arrayList;
        block4: {
            ArrayList<oc50261cbc0f> arrayList2 = new ArrayList<oc50261cbc0f>();
            Iterator<IChatComponent> iterator2 = this.\u0228.getSiblings().iterator();
            int n = occ0b63c0426.\u039f;
            while (iterator2.hasNext()) {
                IChatComponent iChatComponent = iterator2.next();
                arrayList = arrayList2;
                if (n == 0) {
                    arrayList.add(new oc50261cbc0f(iChatComponent.getUnformattedText()));
                    if (n == 0) continue;
                    break;
                }
                break block4;
            }
            arrayList = arrayList2;
        }
        return arrayList;
    }

    public String \u015c() {
        String string;
        block6: {
            ChatComponentText chatComponentText;
            block4: {
                block5: {
                    int n = occ0b63c0426.\u039f;
                    chatComponentText = this.\u0228;
                    if (n != 0) break block4;
                    if (chatComponentText.getChatStyle() != null) break block5;
                    string = "";
                    break block6;
                }
                chatComponentText = this.\u0228;
            }
            string = chatComponentText.getChatStyle().getFormattingCode();
        }
        return string;
    }

    public String \u0291() {
        return this.\u0228.getUnformattedText();
    }

    public String toString() {
        return this.\u0291();
    }

    public IChatComponent \u010b() {
        return this.\u0228;
    }
}

