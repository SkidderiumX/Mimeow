/*
 * Decompiled with CFR 0.152.
 */
package keystrokesmod.script;

import java.util.Locale;
import javax.tools.Diagnostic;
import javax.tools.DiagnosticListener;
import javax.tools.JavaFileObject;
import keystrokesmod.script.JavaSourceFromString;
import keystrokesmod.script.Script;
import x.oc7ab2161b9f;

public class ScriptDiagnosticListener
implements DiagnosticListener<JavaFileObject> {
    private final Script script;

    public ScriptDiagnosticListener() {
        this(null);
    }

    public ScriptDiagnosticListener(Script script) {
        this.script = script;
    }

    @Override
    public void report(Diagnostic<? extends JavaFileObject> diagnostic) {
        Object object;
        String string = diagnostic.getMessage(null);
        if (string.contains("SpongePowered")) {
            return;
        }
        String string2 = string;
        long l = diagnostic.getLineNumber();
        System.err.println("[script-compile] " + l + ": " + string2);
        String string3 = string;
        int n = string3.indexOf(0x32F6677B ^ 0x32F66771);
        if (n != -1) {
            string3 = string3.substring(0, n);
        }
        long l2 = diagnostic.getLineNumber();
        if (diagnostic.getSource() instanceof JavaSourceFromString) {
            l2 -= (long)((JavaSourceFromString)diagnostic.getSource()).extraLines;
        }
        if (l2 <= 0L) {
            l2 = 1L;
        }
        String string4 = string3;
        long l3 = l2;
        String string5 = "Line " + l3 + ": " + string4;
        if (this.script != null) {
            this.script.lastError = string5;
        }
        if (diagnostic.getKind() == Diagnostic.Kind.ERROR) {
            object = this.script != null ? this.script.name : (diagnostic.getSource() != null ? oc7ab2161b9f.\u00c4(((JavaSourceFromString)diagnostic.getSource()).name) : "Script");
            oc7ab2161b9f.\u00fd("&c[Script " + (String)object + "] &7" + string5);
        }
        if (diagnostic.getSource() != null) {
            oc7ab2161b9f.\u057a("\u00a7cError loading script \u00a7b" + oc7ab2161b9f.\u00c4(((JavaSourceFromString)diagnostic.getSource()).name));
        }
        if ((object = diagnostic.getSource()) != null) {
            int n2 = string.indexOf("\n");
            String string6 = diagnostic.getMessage(Locale.getDefault());
            oc7ab2161b9f.\u057a(" \u00a77err: \u00a7c" + (n2 == -1 ? string6 : string6.substring(0, n2)));
            oc7ab2161b9f.\u057a(" \u00a77line: \u00a7c" + l2);
            try {
                String string7 = object.getCharContent(true).toString();
                int n3 = (int)diagnostic.getStartPosition();
                int n4 = (int)diagnostic.getEndPosition();
                if (n3 >= 0 && n4 >= n3 && n3 < string7.length()) {
                    int n5 = Math.min(n4, string7.length());
                    int n6 = string7.indexOf("\n", n3);
                    if (n6 != -1 && n6 >= n3) {
                        oc7ab2161b9f.\u057a(" \u00a77src: \u00a7c" + string7.substring(n3, n6));
                    } else {
                        oc7ab2161b9f.\u057a(" \u00a77src: \u00a7c" + string7.substring(n3, n5));
                    }
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    }
}

