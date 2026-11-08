/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL20;
import x.oc188196c08d;
import x.oc1b46ea259e;

public class oc66e0225688
extends oc188196c08d {
    private static final String \u00db = "#version 120\nuniform sampler2D tex;\nuniform vec2 texelSize;\nuniform float kernel;\nvoid main() {\n  vec4 c = texture2D(tex, gl_TexCoord[0].xy);\n  if (c.a > 0.0) { gl_FragColor = vec4(0.0); return; }\n  gl_FragColor = vec4(0.0);\n  for (float dx = -kernel; dx <= kernel; dx += 1.0)\n    for (float dy = -kernel; dy <= kernel; dy += 1.0) {\n      vec4 n = texture2D(tex, gl_TexCoord[0].xy + vec2(dx, dy) * texelSize);\n      if (n.a > 0.0) gl_FragColor = n;\n    }\n}";
    public static int \u01d4;

    public oc66e0225688() {
        super("#version 120\nuniform sampler2D tex;\nuniform vec2 texelSize;\nuniform float kernel;\nvoid main() {\n  vec4 c = texture2D(tex, gl_TexCoord[0].xy);\n  if (c.a > 0.0) { gl_FragColor = vec4(0.0); return; }\n  gl_FragColor = vec4(0.0);\n  for (float dx = -kernel; dx <= kernel; dx += 1.0)\n    for (float dy = -kernel; dy <= kernel; dy += 1.0) {\n      vec4 n = texture2D(tex, gl_TexCoord[0].xy + vec2(dx, dy) * texelSize);\n      if (n.a > 0.0) gl_FragColor = n;\n    }\n}");
    }

    @Override
    public void z$mr5yuwpmnovg() {
        this.\u0232("tex");
        this.\u0232("texelSize");
        this.\u0232("kernel");
    }

    @Override
    public void z$7r1hve2gx412() {
        block14: {
            oc66e0225688 oc66e02256882;
            int n;
            boolean bl;
            block15: {
                block12: {
                    block13: {
                        GL20.glUseProgram(this.\u0586);
                        bl = oc1b46ea259e.\u01e7;
                        n = this.\u0422("tex");
                        if (bl) break block12;
                        if (n < 0) break block13;
                        GL20.glUniform1i(n, 0);
                    }
                    oc66e02256882 = this;
                    if (bl) break block15;
                    n = oc66e02256882.\u0422("texelSize");
                }
                if (n >= 0) {
                    Minecraft minecraft = Minecraft.getMinecraft();
                    GL20.glUniform2f(n, 1.0f / (float)minecraft.displayWidth, 1.0f / (float)minecraft.displayHeight);
                }
                oc66e02256882 = this;
            }
            int n2 = oc66e02256882.\u0422("kernel");
            if (!bl) {
                n = n2;
                if (n < 0) break block14;
                n2 = n;
            }
            GL20.glUniform1f(n2, 2.0f);
        }
    }
}

