/*
 * Decompiled with CFR 0.152.
 */
package x;

import org.lwjgl.opengl.GL20;
import x.oc188196c08d;
import x.oc1b46ea259e;

public class oc98d1de20cf
extends oc188196c08d {
    private static final String \u03fc = "#version 120\nuniform sampler2D tex;\nuniform vec4 tint;\nvoid main() {\n  float a = texture2D(tex, gl_TexCoord[0].xy).a;\n  gl_FragColor = vec4(tint.rgb, a > 0.0 ? tint.a : 0.0);\n}";
    public static boolean \u0215;

    public oc98d1de20cf() {
        super("#version 120\nuniform sampler2D tex;\nuniform vec4 tint;\nvoid main() {\n  float a = texture2D(tex, gl_TexCoord[0].xy).a;\n  gl_FragColor = vec4(tint.rgb, a > 0.0 ? tint.a : 0.0);\n}");
    }

    @Override
    public void z$mr5yuwpmnovg() {
        this.\u0232("tex");
        this.\u0232("tint");
    }

    @Override
    public void z$7r1hve2gx412() {
        block3: {
            int n;
            block2: {
                GL20.glUseProgram(this.\u0586);
                boolean bl = oc1b46ea259e.\u01e7;
                int n2 = this.\u0422("tex");
                n = n2;
                if (bl) break block2;
                if (n < 0) break block3;
                n = n2;
            }
            GL20.glUniform1i(n, 0);
        }
    }

    public void \u0507(int n, int n2, int n3, int n4) {
        block3: {
            int n5;
            block2: {
                int n6 = this.\u0422("tint");
                boolean bl = oc1b46ea259e.\u01e7;
                n5 = n6;
                if (bl) break block2;
                if (n5 < 0) break block3;
                n5 = n6;
            }
            GL20.glUniform4f(n5, (float)n / 255.0f, (float)n2 / 255.0f, (float)n3 / 255.0f, (float)n4 / 255.0f);
        }
    }

    public void \u03c2(int n) {
        this.\u0507(n >> (0x83356BB7 ^ 0x83356BA7) & (0x83356B58 ^ 0x83356BA7), n >> (0x83356BAF ^ 0x83356BA7) & (0x83356B58 ^ 0x83356BA7), n & (0x83356B58 ^ 0x83356BA7), n >> (0x83356BBF ^ 0x83356BA7) & (0x83356B58 ^ 0x83356BA7));
    }
}

