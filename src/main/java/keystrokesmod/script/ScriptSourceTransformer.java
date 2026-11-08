/*
 * Decompiled with CFR 0.152.
 */
package keystrokesmod.script;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class ScriptSourceTransformer {
    private ScriptSourceTransformer() {
    }

    static ProcessedScript process(String string, String string2) {
        String string3;
        String string4;
        if (string == null || string.isEmpty()) {
            return new ProcessedScript(Collections.emptyList(), "");
        }
        String string5 = ScriptSourceTransformer.unwrapLegacyTemplate(string, string2);
        String[] stringArray = string5.split("\r?\n", -1);
        ArrayList<String> arrayList = new ArrayList<String>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < stringArray.length; ++i) {
            string4 = stringArray[i];
            string3 = string4.trim();
            if (string3.startsWith("package ") && string3.endsWith(";")) {
                stringBuilder.append("\n");
                continue;
            }
            if (string3.startsWith("import ") && string3.endsWith(";")) {
                String string6 = string3.substring(0x8F7AF630 ^ 0x8F7AF637, string3.length() - 1).trim();
                if (!string6.startsWith("keystrokesmod.script.ScriptModule") && !string6.startsWith("net.minecraftforge.")) {
                    arrayList.add(string6);
                }
                stringBuilder.append("\n");
                continue;
            }
            stringBuilder.append(string4);
            if (i >= stringArray.length - 1) continue;
            stringBuilder.append("\n");
        }
        String string7 = ScriptSourceTransformer.sanitizeCommonTypos(stringBuilder.toString());
        string4 = ScriptSourceTransformer.rewriteBlockedCalls(string7);
        string3 = ScriptSourceTransformer.supportNestedTypes(string4);
        return new ProcessedScript(arrayList, string3);
    }

    static String sanitizeCommonTypos(String string) {
        if (string == null || string.isEmpty()) {
            return string;
        }
        String string2 = string.replaceAll("\\bwList<", "List<");
        string2 = string2.replaceAll("\\binvntory\\b", "inventory");
        return string2;
    }

    public static String unwrapLegacyTemplate(String string, String string2) {
        if (string == null || !string.contains("extends ScriptModule") && !string.contains("extends Module")) {
            return string;
        }
        String[] stringArray = string.split("\r?\n", -1);
        ArrayList<String> arrayList = new ArrayList<String>();
        boolean bl = false;
        int n = 0;
        boolean bl2 = false;
        int n2 = 0;
        for (String string3 : stringArray) {
            int n3;
            int n4;
            String string4 = string3.trim();
            if (string4.startsWith("import keystrokesmod.script.ScriptModule") || string4.startsWith("import net.minecraftforge.")) {
                arrayList.add("");
                continue;
            }
            if (!bl && string4.matches("^(?:public\\s+)?class\\s+[a-zA-Z0-9_$]+\\s+extends\\s+(?:ScriptModule|Module).*")) {
                bl = true;
                n4 = ScriptSourceTransformer.countChar(string3, (char)(0x97718D75 ^ 0x97718D0E));
                n3 = ScriptSourceTransformer.countChar(string3, (char)(0x97718D73 ^ 0x97718D0E));
                n = n4 - n3;
                arrayList.add("");
                continue;
            }
            if (bl && n == 0 && string4.startsWith("{")) {
                n4 = ScriptSourceTransformer.countChar(string3, (char)(0x97718D75 ^ 0x97718D0E));
                n3 = ScriptSourceTransformer.countChar(string3, (char)(0x97718D73 ^ 0x97718D0E));
                n += n4 - n3;
                arrayList.add("");
                continue;
            }
            if (bl) {
                if (!bl2) {
                    n4 = 0;
                    if (string2 != null && !string2.isEmpty()) {
                        n4 = string4.matches("^(?:(?:public|protected|private)\\s+)?" + Pattern.quote(string2) + "\\s*\\([^)]*\\)\\s*(?:throws\\s+[^{;]+)?\\s*\\{?.*") ? 1 : 0;
                    }
                    if (n4 != 0) {
                        int n5;
                        bl2 = true;
                        n3 = ScriptSourceTransformer.countChar(string3, (char)(0x97718D75 ^ 0x97718D0E));
                        n2 = n3 - (n5 = ScriptSourceTransformer.countChar(string3, (char)(0x97718D73 ^ 0x97718D0E)));
                        if (n2 <= 0 && n3 > 0) {
                            bl2 = false;
                        }
                        arrayList.add("");
                        continue;
                    }
                } else {
                    n4 = ScriptSourceTransformer.countChar(string3, (char)(0x97718D75 ^ 0x97718D0E));
                    if ((n2 += n4 - (n3 = ScriptSourceTransformer.countChar(string3, (char)(0x97718D73 ^ 0x97718D0E)))) <= 0) {
                        bl2 = false;
                    }
                    arrayList.add("");
                    continue;
                }
                if (string4.startsWith("super(") && string4.endsWith(");")) {
                    arrayList.add("");
                    continue;
                }
                if (string4.equals("@Override") || string4.equals("@SubscribeEvent")) {
                    arrayList.add("");
                    continue;
                }
                if (string4.matches(".*void\\s+onTick\\s*\\([^)]*\\).*")) {
                    string3 = string3.replaceAll("void\\s+onTick\\s*\\([^)]*\\)", "void onPreUpdate()");
                }
                if (string3.contains("event.phase")) {
                    string3 = string3.replaceAll("event\\.phase\\s*!=\\s*(?:TickEvent\\.)?Phase\\.START\\s*\\|\\|\\s*", "");
                    string3 = string3.replaceAll("if\\s*\\(\\s*event\\.phase\\s*!=\\s*(?:TickEvent\\.)?Phase\\.START\\s*\\)\\s*return\\s*;?", "");
                    string3 = string3.replaceAll("if\\s*\\(\\s*event\\.phase\\s*==\\s*(?:TickEvent\\.)?Phase\\.END\\s*\\)\\s*return\\s*;?", "");
                }
                if (string3.contains("mc.thePlayer == null") && !string3.contains("mc ==")) {
                    string3 = string3.replace("mc.thePlayer == null", "(mc == null || mc.thePlayer == null)");
                }
                if ((n += (n4 = ScriptSourceTransformer.countChar(string3, (char)(0x97718D75 ^ 0x97718D0E))) - (n3 = ScriptSourceTransformer.countChar(string3, (char)(0x97718D73 ^ 0x97718D0E)))) <= 0) {
                    bl = false;
                    arrayList.add("");
                    continue;
                }
            }
            arrayList.add(string3);
        }
        return String.join((CharSequence)"\n", arrayList);
    }

    private static int countChar(String string, char c) {
        int n = 0;
        for (int i = 0; i < string.length(); ++i) {
            if (string.charAt(i) != c) continue;
            ++n;
        }
        return n;
    }

    static String rewriteBlockedCalls(String string) {
        if (string == null || string.isEmpty()) {
            return string;
        }
        String string2 = ScriptSourceTransformer.replaceCall(string, "System.currentTimeMillis", "timeMillis");
        return ScriptSourceTransformer.replaceCall(string2, "System.nanoTime", "client.nanoTime");
    }

    private static String replaceCall(String string, String string2, String string3) {
        StringBuilder stringBuilder = new StringBuilder(string.length());
        int n = 0;
        int n2 = 0;
        int n3 = string.length();
        while (n2 < n3) {
            char c;
            char c2 = string.charAt(n2);
            if (c2 == (0x32DDD080 ^ 0x32DDD0A2) || c2 == (0x32DDD085 ^ 0x32DDD0A2)) {
                n2 = ScriptSourceTransformer.skipQuotedValue(string, n2 + 1, c2);
                continue;
            }
            if (c2 == (0x32DDD08D ^ 0x32DDD0A2) && n2 + 1 < n3) {
                c = string.charAt(n2 + 1);
                if (c == (0x32DDD08D ^ 0x32DDD0A2)) {
                    n2 = ScriptSourceTransformer.skipLineComment(string, n2 + (0x32DDD0A0 ^ 0x32DDD0A2));
                    continue;
                }
                if (c == (0x32DDD088 ^ 0x32DDD0A2)) {
                    n2 = ScriptSourceTransformer.skipBlockComment(string, n2 + (0x32DDD0A0 ^ 0x32DDD0A2));
                    continue;
                }
            }
            char c3 = c = string.startsWith(string2, n2) && (n2 == 0 || !Character.isJavaIdentifierPart(string.charAt(n2 - 1))) && n2 + string2.length() + 1 < n3 && string.charAt(n2 + string2.length()) == (0x32DDD08A ^ 0x32DDD0A2) && string.charAt(n2 + string2.length() + 1) == (0x32DDD08B ^ 0x32DDD0A2) ? (char)'\u0001' : '\u0000';
            if (c != '\u0000') {
                stringBuilder.append(string, n, n2);
                stringBuilder.append(string3).append("()");
                n = n2 += string2.length() + (0x32DDD0A0 ^ 0x32DDD0A2);
                continue;
            }
            ++n2;
        }
        if (n == 0) {
            return string;
        }
        stringBuilder.append(string.substring(n));
        return stringBuilder.toString();
    }

    static String supportNestedTypes(String string) {
        if (string == null || string.isEmpty()) {
            return string;
        }
        List<Token> list = ScriptSourceTransformer.tokenize(string);
        Map<Integer, Integer> map = ScriptSourceTransformer.findMatchingBraces(list);
        List<TypeDeclaration> list2 = ScriptSourceTransformer.findTypeDeclarations(list, map);
        ScriptSourceTransformer.attachMemberParents(list2);
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (TypeDeclaration object2 : list2) {
            if (!object2.eligibleMember || object2.kind != TypeKind.CLASS || !ScriptSourceTransformer.becomesStatic(object2) || object2.declaredStatic) continue;
            arrayList.add(object2.keywordPosition);
        }
        if (arrayList.isEmpty()) {
            return string;
        }
        arrayList.sort(Collections.reverseOrder());
        StringBuilder stringBuilder = new StringBuilder(string);
        Iterator iterator2 = arrayList.iterator();
        while (iterator2.hasNext()) {
            int n = (Integer)iterator2.next();
            stringBuilder.insert(n, "static ");
        }
        return stringBuilder.toString();
    }

    private static boolean becomesStatic(TypeDeclaration typeDeclaration) {
        if (typeDeclaration.kind != TypeKind.CLASS) {
            return true;
        }
        if (typeDeclaration.staticState != null) {
            return typeDeclaration.staticState;
        }
        typeDeclaration.staticState = typeDeclaration.declaredStatic;
        if (!typeDeclaration.staticState.booleanValue()) {
            for (TypeDeclaration typeDeclaration2 : typeDeclaration.memberChildren) {
                if (!typeDeclaration2.eligibleMember || !ScriptSourceTransformer.becomesStatic(typeDeclaration2)) continue;
                typeDeclaration.staticState = true;
                break;
            }
        }
        return typeDeclaration.staticState;
    }

    private static void attachMemberParents(List<TypeDeclaration> list) {
        list.sort(Comparator.comparingInt(typeDeclaration -> typeDeclaration.keywordToken));
        for (TypeDeclaration typeDeclaration2 : list) {
            TypeDeclaration typeDeclaration3 = null;
            for (TypeDeclaration typeDeclaration4 : list) {
                if (typeDeclaration4.keywordToken >= typeDeclaration2.keywordToken) break;
                if (typeDeclaration4.bodyOpenToken >= typeDeclaration2.keywordToken || typeDeclaration4.bodyCloseToken <= typeDeclaration2.keywordToken || typeDeclaration3 != null && typeDeclaration4.bodyOpenToken <= typeDeclaration3.bodyOpenToken) continue;
                typeDeclaration3 = typeDeclaration4;
            }
            if (typeDeclaration3 == null) {
                typeDeclaration2.eligibleMember = typeDeclaration2.depth == 0;
                continue;
            }
            boolean bl = typeDeclaration2.depth == typeDeclaration3.depth + 1;
            boolean bl2 = typeDeclaration2.eligibleMember = bl && typeDeclaration3.eligibleMember;
            if (!bl) continue;
            typeDeclaration3.memberChildren.add(typeDeclaration2);
        }
    }

    private static List<TypeDeclaration> findTypeDeclarations(List<Token> list, Map<Integer, Integer> map) {
        ArrayList<TypeDeclaration> arrayList = new ArrayList<TypeDeclaration>();
        for (int i = 0; i < list.size(); ++i) {
            Token token = list.get(i);
            TypeKind typeKind = ScriptSourceTransformer.typeKind(token.text);
            if (typeKind == null || ScriptSourceTransformer.isClassLiteral(list, i)) continue;
            int n = ScriptSourceTransformer.findTypeBody(list, i);
            Integer n2 = map.get(n);
            if (n == -1 || n2 == null) continue;
            TypeDeclaration typeDeclaration = new TypeDeclaration();
            typeDeclaration.kind = typeKind;
            typeDeclaration.keywordToken = i;
            typeDeclaration.keywordPosition = token.position;
            typeDeclaration.bodyOpenToken = n;
            typeDeclaration.bodyCloseToken = n2;
            typeDeclaration.depth = token.depth;
            typeDeclaration.declaredStatic = typeKind != TypeKind.CLASS || ScriptSourceTransformer.hasStaticModifier(list, i);
            arrayList.add(typeDeclaration);
        }
        return arrayList;
    }

    private static int findTypeBody(List<Token> list, int n) {
        int n2 = list.get((int)n).depth;
        int n3 = 0;
        int n4 = 0;
        for (int i = n + 1; i < list.size(); ++i) {
            Token token = list.get(i);
            if (token.depth < n2) {
                return -1;
            }
            if (token.depth != n2) continue;
            if ("(".equals(token.text)) {
                ++n3;
                continue;
            }
            if (")".equals(token.text) && n3 > 0) {
                --n3;
                continue;
            }
            if ("[".equals(token.text)) {
                ++n4;
                continue;
            }
            if ("]".equals(token.text) && n4 > 0) {
                --n4;
                continue;
            }
            if ("{".equals(token.text) && n3 == 0 && n4 == 0) {
                return i;
            }
            if (!";".equals(token.text) || n3 != 0 || n4 != 0) continue;
            return -1;
        }
        return -1;
    }

    private static boolean hasStaticModifier(List<Token> list, int n) {
        int n2 = list.get((int)n).depth;
        for (int i = n - 1; i >= 0; --i) {
            Token token = list.get(i);
            if (token.depth < n2) break;
            if (token.depth > n2) continue;
            if (";".equals(token.text) || "{".equals(token.text) || "}".equals(token.text)) break;
            if (!"static".equals(token.text)) continue;
            return true;
        }
        return false;
    }

    private static boolean isClassLiteral(List<Token> list, int n) {
        return n > 0 && "class".equals(list.get((int)n).text) && ".".equals(list.get((int)(n - 1)).text);
    }

    private static TypeKind typeKind(String string) {
        if ("class".equals(string)) {
            return TypeKind.CLASS;
        }
        if ("enum".equals(string)) {
            return TypeKind.ENUM;
        }
        if ("interface".equals(string)) {
            return TypeKind.INTERFACE;
        }
        return null;
    }

    private static Map<Integer, Integer> findMatchingBraces(List<Token> list) {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<Integer>();
        for (int i = 0; i < list.size(); ++i) {
            String string = list.get((int)i).text;
            if ("{".equals(string)) {
                arrayDeque.push(i);
                continue;
            }
            if (!"}".equals(string) || arrayDeque.isEmpty()) continue;
            hashMap.put((Integer)arrayDeque.pop(), i);
        }
        return hashMap;
    }

    private static List<Token> tokenize(String string) {
        ArrayList<Token> arrayList = new ArrayList<Token>();
        int n = 0;
        int n2 = 0;
        while (n2 < string.length()) {
            int n3;
            char c = string.charAt(n2);
            if (Character.isWhitespace(c)) {
                ++n2;
                continue;
            }
            if (c == (0x36D87C00 ^ 0x36D87C2F) && n2 + 1 < string.length()) {
                n3 = string.charAt(n2 + 1);
                if (n3 == (0x36D87C00 ^ 0x36D87C2F)) {
                    n2 = ScriptSourceTransformer.skipLineComment(string, n2 + (0x36D87C2D ^ 0x36D87C2F));
                    continue;
                }
                if (n3 == (0x36D87C05 ^ 0x36D87C2F)) {
                    n2 = ScriptSourceTransformer.skipBlockComment(string, n2 + (0x36D87C2D ^ 0x36D87C2F));
                    continue;
                }
            }
            if (c == (0x36D87C0D ^ 0x36D87C2F) || c == (0x36D87C08 ^ 0x36D87C2F)) {
                n2 = ScriptSourceTransformer.skipQuotedValue(string, n2 + 1, c);
                continue;
            }
            if (Character.isJavaIdentifierStart(c)) {
                n3 = n2++;
                while (n2 < string.length() && Character.isJavaIdentifierPart(string.charAt(n2))) {
                    ++n2;
                }
                arrayList.add(new Token(string.substring(n3, n2), n3, n));
                continue;
            }
            if (c == (0x36D87C52 ^ 0x36D87C2F)) {
                n = Math.max(0, n - 1);
            }
            arrayList.add(new Token(String.valueOf(c), n2, n));
            if (c == (0x36D87C54 ^ 0x36D87C2F)) {
                ++n;
            }
            ++n2;
        }
        return arrayList;
    }

    private static int skipLineComment(String string, int n) {
        while (n < string.length() && string.charAt(n) != (0x47A72C1D ^ 0x47A72C17) && string.charAt(n) != (0x47A72C1A ^ 0x47A72C17)) {
            ++n;
        }
        return n;
    }

    private static int skipBlockComment(String string, int n) {
        while (n + 1 < string.length()) {
            if (string.charAt(n) == (0x48389C39 ^ 0x48389C13) && string.charAt(n + 1) == (0x48389C3C ^ 0x48389C13)) {
                return n + (0x48389C11 ^ 0x48389C13);
            }
            ++n;
        }
        return string.length();
    }

    private static int skipQuotedValue(String string, int n, char c) {
        boolean bl = false;
        while (n < string.length()) {
            char c2 = string.charAt(n++);
            if (bl) {
                bl = false;
                continue;
            }
            if (c2 == (0x109B3B08 ^ 0x109B3B54)) {
                bl = true;
                continue;
            }
            if (c2 != c) continue;
            break;
        }
        return n;
    }

    public static final class ProcessedScript {
        final List<String> extractedImports;
        final String code;

        ProcessedScript(List<String> list, String string) {
            this.extractedImports = list;
            this.code = string;
        }
    }

    private static final class TypeDeclaration {
        private TypeKind kind;
        private int keywordToken;
        private int keywordPosition;
        private int bodyOpenToken;
        private int bodyCloseToken;
        private int depth;
        private boolean declaredStatic;
        private boolean eligibleMember;
        private Boolean staticState;
        private final List<TypeDeclaration> memberChildren = new ArrayList<TypeDeclaration>();

        private TypeDeclaration() {
        }
    }

    private static final class TypeKind
    extends Enum<TypeKind> {
        public static final /* enum */ TypeKind CLASS = new TypeKind();
        public static final /* enum */ TypeKind ENUM = new TypeKind();
        public static final /* enum */ TypeKind INTERFACE = new TypeKind();
        private static final /* synthetic */ TypeKind[] $VALUES;

        public static TypeKind[] values() {
            return (TypeKind[])$VALUES.clone();
        }

        public static TypeKind valueOf(String string) {
            return Enum.valueOf(TypeKind.class, string);
        }

        private static /* synthetic */ TypeKind[] $values() {
            TypeKind[] typeKindArray = new TypeKind[0xC9A5E451 ^ 0xC9A5E452];
            typeKindArray[0] = CLASS;
            typeKindArray[1] = ENUM;
            typeKindArray[0xC9A5E450 ^ 0xC9A5E452] = INTERFACE;
            return typeKindArray;
        }

        static {
            $VALUES = TypeKind.$values();
        }
    }

    private static final class Token {
        private final String text;
        private final int position;
        private final int depth;

        private Token(String string, int n, int n2) {
            this.text = string;
            this.position = n;
            this.depth = n2;
        }
    }
}

