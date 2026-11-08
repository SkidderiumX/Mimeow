/*
 * Decompiled with CFR 0.152.
 */
package keystrokesmod.script;

import java.net.URI;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;

public class JavaSourceFromString
extends SimpleJavaFileObject {
    private final String code;
    public final String name;
    public int extraLines;

    @Override
    public CharSequence getCharContent(boolean bl) {
        return this.code;
    }

    public JavaSourceFromString(String string, String string2, int n) {
        super(URI.create("string:///" + string + ".java"), JavaFileObject.Kind.SOURCE);
        this.code = string2;
        this.name = string;
        this.extraLines = n;
    }
}

