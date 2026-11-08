/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.shaders.config;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.src.Config;
import net.optifine.expr.ExpressionFloatArrayCached;
import net.optifine.expr.ExpressionFloatCached;
import net.optifine.expr.ExpressionParser;
import net.optifine.expr.ExpressionType;
import net.optifine.expr.IExpression;
import net.optifine.expr.IExpressionBool;
import net.optifine.expr.IExpressionFloat;
import net.optifine.expr.IExpressionFloatArray;
import net.optifine.expr.ParseException;
import net.optifine.render.GlAlphaState;
import net.optifine.render.GlBlendState;
import net.optifine.shaders.IShaderPack;
import net.optifine.shaders.Program;
import net.optifine.shaders.SMCLog;
import net.optifine.shaders.ShaderUtils;
import net.optifine.shaders.Shaders;
import net.optifine.shaders.config.RenderScale;
import net.optifine.shaders.config.ScreenShaderOptions;
import net.optifine.shaders.config.ShaderMacro;
import net.optifine.shaders.config.ShaderMacros;
import net.optifine.shaders.config.ShaderOption;
import net.optifine.shaders.config.ShaderOptionProfile;
import net.optifine.shaders.config.ShaderOptionResolver;
import net.optifine.shaders.config.ShaderOptionRest;
import net.optifine.shaders.config.ShaderOptionScreen;
import net.optifine.shaders.config.ShaderOptionSwitch;
import net.optifine.shaders.config.ShaderOptionSwitchConst;
import net.optifine.shaders.config.ShaderOptionVariable;
import net.optifine.shaders.config.ShaderOptionVariableConst;
import net.optifine.shaders.config.ShaderProfile;
import net.optifine.shaders.uniform.CustomUniform;
import net.optifine.shaders.uniform.CustomUniforms;
import net.optifine.shaders.uniform.ShaderExpressionResolver;
import net.optifine.shaders.uniform.UniformType;
import net.optifine.util.StrUtils;

public class ShaderPackParser {
    private static final Pattern PATTERN_VERSION = Pattern.compile("^\\s*#version\\s+.*$");
    private static final Pattern PATTERN_INCLUDE = Pattern.compile("^\\s*#include\\s+\"([A-Za-z0-9_/\\.]+)\".*$");
    private static final Set<String> setConstNames = ShaderPackParser.makeSetConstNames();
    private static final Map<String, Integer> mapAlphaFuncs = ShaderPackParser.makeMapAlphaFuncs();
    private static final Map<String, Integer> mapBlendFactors = ShaderPackParser.makeMapBlendFactors();

    public static ShaderOption[] parseShaderPackOptions(IShaderPack iShaderPack, String[] stringArray, List<Integer> list) {
        String string;
        if (iShaderPack == null) {
            return new ShaderOption[0];
        }
        HashMap<String, ShaderOption> hashMap = new HashMap<String, ShaderOption>();
        ShaderPackParser.collectShaderOptions(iShaderPack, "/shaders", stringArray, hashMap);
        for (int n : list) {
            string = "/shaders/world" + n;
            ShaderPackParser.collectShaderOptions(iShaderPack, string, stringArray, hashMap);
        }
        Collection collection = hashMap.values();
        string = collection.toArray(new ShaderOption[collection.size()]);
        Comparator<ShaderOption> comparator = new Comparator<ShaderOption>(){

            @Override
            public int compare(ShaderOption shaderOption, ShaderOption shaderOption2) {
                return shaderOption.getName().compareToIgnoreCase(shaderOption2.getName());
            }
        };
        Arrays.sort(string, comparator);
        return string;
    }

    private static void collectShaderOptions(IShaderPack iShaderPack, String string, String[] stringArray, Map<String, ShaderOption> map) {
        for (int i = 0; i < stringArray.length; ++i) {
            String string2 = stringArray[i];
            if (string2.equals("")) continue;
            String string3 = string + "/" + string2 + ".vsh";
            String string4 = string + "/" + string2 + ".fsh";
            ShaderPackParser.collectShaderOptions(iShaderPack, string3, map);
            ShaderPackParser.collectShaderOptions(iShaderPack, string4, map);
        }
    }

    private static void collectShaderOptions(IShaderPack iShaderPack, String string, Map<String, ShaderOption> map) {
        String[] stringArray = ShaderPackParser.getLines(iShaderPack, string);
        for (int i = 0; i < stringArray.length; ++i) {
            String string2 = stringArray[i];
            ShaderOption shaderOption = ShaderPackParser.getShaderOption(string2, string);
            if (shaderOption == null || shaderOption.getName().startsWith(ShaderMacros.getPrefixMacro()) || shaderOption.checkUsed() && !ShaderPackParser.isOptionUsed(shaderOption, stringArray)) continue;
            String string3 = shaderOption.getName();
            ShaderOption shaderOption2 = map.get(string3);
            if (shaderOption2 != null) {
                if (!Config.equals(shaderOption2.getValueDefault(), shaderOption.getValueDefault())) {
                    Config.warn("Ambiguous shader option: " + shaderOption.getName());
                    Config.warn(" - in " + Config.arrayToString(shaderOption2.getPaths()) + ": " + shaderOption2.getValueDefault());
                    Config.warn(" - in " + Config.arrayToString(shaderOption.getPaths()) + ": " + shaderOption.getValueDefault());
                    shaderOption2.setEnabled(false);
                }
                if (shaderOption2.getDescription() == null || shaderOption2.getDescription().length() <= 0) {
                    shaderOption2.setDescription(shaderOption.getDescription());
                }
                shaderOption2.addPaths(shaderOption.getPaths());
                continue;
            }
            map.put(string3, shaderOption);
        }
    }

    private static boolean isOptionUsed(ShaderOption shaderOption, String[] stringArray) {
        for (int i = 0; i < stringArray.length; ++i) {
            String string = stringArray[i];
            if (!shaderOption.isUsedInLine(string)) continue;
            return true;
        }
        return false;
    }

    private static String[] getLines(IShaderPack iShaderPack, String string) {
        try {
            ArrayList<String> arrayList = new ArrayList<String>();
            String string2 = ShaderPackParser.loadFile(string, iShaderPack, 0, arrayList, 0);
            if (string2 == null) {
                return new String[0];
            }
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(string2.getBytes());
            String[] stringArray = Config.readLines(byteArrayInputStream);
            return stringArray;
        }
        catch (IOException iOException) {
            Config.dbg(iOException.getClass().getName() + ": " + iOException.getMessage());
            return new String[0];
        }
    }

    private static ShaderOption getShaderOption(String string, String string2) {
        ShaderOption shaderOption = null;
        int n = 2126932684;
        block16: while (true) {
            switch (n) {
                default: {
                    throw null;
                }
                case 884504925: {
                    if (shaderOption == null) {
                        n = -643108010;
                        continue block16;
                    }
                    n = 1475171356;
                    continue block16;
                }
                case -710700115: {
                    return shaderOption;
                }
                case -1915253468: {
                    if (shaderOption == null) {
                        n = -1452056819;
                        continue block16;
                    }
                    n = 804260600;
                    continue block16;
                }
                case 1475171356: {
                    if (shaderOption != null) {
                        n = 416492193;
                        continue block16;
                    }
                    n = 1595313940;
                    continue block16;
                }
                case -1297742040: {
                    if (setConstNames.contains(shaderOption.getName())) {
                        n = -710700115;
                        continue block16;
                    }
                    n = 761327148;
                    continue block16;
                }
                case 804260600: {
                    if (shaderOption != null) {
                        n = -1297742040;
                        continue block16;
                    }
                    n = 761327148;
                    continue block16;
                }
                case -956704906: {
                    shaderOption = ShaderOptionSwitchConst.parseOption(string, string2);
                    n = -1915253468;
                    continue block16;
                }
                case 2126932684: {
                    shaderOption = null;
                    if (shaderOption == null) {
                        n = -1221287527;
                        continue block16;
                    }
                    n = 884504925;
                    continue block16;
                }
                case 1595313940: {
                    if (shaderOption == null) {
                        n = -956704906;
                        continue block16;
                    }
                    n = -1915253468;
                    continue block16;
                }
                case -1452056819: {
                    shaderOption = ShaderOptionVariableConst.parseOption(string, string2);
                    n = 804260600;
                    continue block16;
                }
                case -643108010: {
                    shaderOption = ShaderOptionVariable.parseOption(string, string2);
                    n = 1475171356;
                    continue block16;
                }
                case -1221287527: {
                    shaderOption = ShaderOptionSwitch.parseOption(string, string2);
                    n = 884504925;
                    continue block16;
                }
                case 416492193: {
                    return shaderOption;
                }
                case 761327148: 
            }
            break;
        }
        return null;
    }

    private static Set<String> makeSetConstNames() {
        HashSet<String> hashSet = new HashSet<String>();
        hashSet.add("shadowMapResolution");
        hashSet.add("shadowMapFov");
        hashSet.add("shadowDistance");
        hashSet.add("shadowDistanceRenderMul");
        hashSet.add("shadowIntervalSize");
        hashSet.add("generateShadowMipmap");
        hashSet.add("generateShadowColorMipmap");
        hashSet.add("shadowHardwareFiltering");
        hashSet.add("shadowHardwareFiltering0");
        hashSet.add("shadowHardwareFiltering1");
        hashSet.add("shadowtex0Mipmap");
        hashSet.add("shadowtexMipmap");
        hashSet.add("shadowtex1Mipmap");
        hashSet.add("shadowcolor0Mipmap");
        hashSet.add("shadowColor0Mipmap");
        hashSet.add("shadowcolor1Mipmap");
        hashSet.add("shadowColor1Mipmap");
        hashSet.add("shadowtex0Nearest");
        hashSet.add("shadowtexNearest");
        hashSet.add("shadow0MinMagNearest");
        hashSet.add("shadowtex1Nearest");
        hashSet.add("shadow1MinMagNearest");
        hashSet.add("shadowcolor0Nearest");
        hashSet.add("shadowColor0Nearest");
        hashSet.add("shadowColor0MinMagNearest");
        hashSet.add("shadowcolor1Nearest");
        hashSet.add("shadowColor1Nearest");
        hashSet.add("shadowColor1MinMagNearest");
        hashSet.add("wetnessHalflife");
        hashSet.add("drynessHalflife");
        hashSet.add("eyeBrightnessHalflife");
        hashSet.add("centerDepthHalflife");
        hashSet.add("sunPathRotation");
        hashSet.add("ambientOcclusionLevel");
        hashSet.add("superSamplingLevel");
        hashSet.add("noiseTextureResolution");
        return hashSet;
    }

    public static ShaderProfile[] parseProfiles(Properties properties, ShaderOption[] shaderOptionArray) {
        String string = "profile.";
        ArrayList<ShaderProfile> arrayList = new ArrayList<ShaderProfile>();
        for (Object object : properties.keySet()) {
            String string2 = (String)object;
            if (!string2.startsWith(string)) continue;
            String string3 = string2.substring(string.length());
            properties.getProperty(string2);
            HashSet<String> hashSet = new HashSet<String>();
            ShaderProfile shaderProfile = ShaderPackParser.parseProfile(string3, properties, hashSet, shaderOptionArray);
            if (shaderProfile == null) continue;
            arrayList.add(shaderProfile);
        }
        if (arrayList.size() <= 0) {
            return null;
        }
        ShaderProfile[] shaderProfileArray = arrayList.toArray(new ShaderProfile[arrayList.size()]);
        return shaderProfileArray;
    }

    public static Map<String, IExpressionBool> parseProgramConditions(Properties properties, ShaderOption[] shaderOptionArray) {
        String string = "program.";
        Pattern pattern = Pattern.compile("program\\.([^.]+)\\.enabled");
        HashMap<String, IExpressionBool> hashMap = new HashMap<String, IExpressionBool>();
        for (Object object : properties.keySet()) {
            String string2 = (String)object;
            Matcher matcher = pattern.matcher(string2);
            if (!matcher.matches()) continue;
            String string3 = matcher.group(1);
            String string4 = properties.getProperty(string2).trim();
            IExpressionBool iExpressionBool = ShaderPackParser.parseOptionExpression(string4, shaderOptionArray);
            if (iExpressionBool == null) {
                SMCLog.severe("Error parsing program condition: " + string2);
                continue;
            }
            hashMap.put(string3, iExpressionBool);
        }
        return hashMap;
    }

    private static IExpressionBool parseOptionExpression(String string, ShaderOption[] shaderOptionArray) {
        try {
            ShaderOptionResolver shaderOptionResolver = new ShaderOptionResolver(shaderOptionArray);
            ExpressionParser expressionParser = new ExpressionParser(shaderOptionResolver);
            IExpressionBool iExpressionBool = expressionParser.parseBool(string);
            return iExpressionBool;
        }
        catch (ParseException parseException) {
            SMCLog.warning(parseException.getClass().getName() + ": " + parseException.getMessage());
            return null;
        }
    }

    public static Set<String> parseOptionSliders(Properties properties, ShaderOption[] shaderOptionArray) {
        HashSet<String> hashSet = new HashSet<String>();
        String string = properties.getProperty("sliders");
        if (string == null) {
            return hashSet;
        }
        String[] stringArray = Config.tokenize(string, " ");
        for (int i = 0; i < stringArray.length; ++i) {
            String string2 = stringArray[i];
            ShaderOption shaderOption = ShaderUtils.getShaderOption(string2, shaderOptionArray);
            if (shaderOption == null) {
                Config.warn("Invalid shader option: " + string2);
                continue;
            }
            hashSet.add(string2);
        }
        return hashSet;
    }

    private static ShaderProfile parseProfile(String string, Properties properties, Set<String> set, ShaderOption[] shaderOptionArray) {
        String string2 = "profile.";
        String string3 = string2 + string;
        if (set.contains(string3)) {
            Config.warn("[Shaders] Profile already parsed: " + string);
            return null;
        }
        set.add(string);
        ShaderProfile shaderProfile = new ShaderProfile(string);
        String string4 = properties.getProperty(string3);
        String[] stringArray = Config.tokenize(string4, " ");
        for (int i = 0; i < stringArray.length; ++i) {
            Object object;
            Object object2;
            Object object3;
            String string5 = stringArray[i];
            if (string5.startsWith(string2)) {
                object3 = string5.substring(string2.length());
                object2 = ShaderPackParser.parseProfile((String)object3, properties, set, shaderOptionArray);
                if (shaderProfile == null) continue;
                shaderProfile.addOptionValues((ShaderProfile)object2);
                shaderProfile.addDisabledPrograms(((ShaderProfile)object2).getDisabledPrograms());
                continue;
            }
            object3 = Config.tokenize(string5, ":=");
            if (((String[])object3).length == 1) {
                Object object4;
                object2 = object3[0];
                boolean bl = true;
                if (((String)object2).startsWith("!")) {
                    bl = false;
                    object2 = ((String)object2).substring(1);
                }
                if (((String)object2).startsWith((String)(object = "program."))) {
                    object4 = ((String)object2).substring(((String)object).length());
                    if (!Shaders.isProgramPath((String)object4)) {
                        Config.warn("Invalid program: " + (String)object4 + " in profile: " + shaderProfile.getName());
                        continue;
                    }
                    if (bl) {
                        shaderProfile.removeDisabledProgram((String)object4);
                        continue;
                    }
                    shaderProfile.addDisabledProgram((String)object4);
                    continue;
                }
                object4 = ShaderUtils.getShaderOption((String)object2, shaderOptionArray);
                if (!(object4 instanceof ShaderOptionSwitch)) {
                    Config.warn("[Shaders] Invalid option: " + (String)object2);
                    continue;
                }
                shaderProfile.addOptionValue((String)object2, String.valueOf(bl));
                ((ShaderOption)object4).setVisible(true);
                continue;
            }
            if (((String[])object3).length != 2) {
                Config.warn("[Shaders] Invalid option value: " + string5);
                continue;
            }
            object2 = object3[0];
            String string6 = object3[1];
            object = ShaderUtils.getShaderOption((String)object2, shaderOptionArray);
            if (object == null) {
                Config.warn("[Shaders] Invalid option: " + string5);
                continue;
            }
            if (!((ShaderOption)object).isValidValue(string6)) {
                Config.warn("[Shaders] Invalid value: " + string5);
                continue;
            }
            ((ShaderOption)object).setVisible(true);
            shaderProfile.addOptionValue((String)object2, string6);
        }
        return shaderProfile;
    }

    public static Map<String, ScreenShaderOptions> parseGuiScreens(Properties properties, ShaderProfile[] shaderProfileArray, ShaderOption[] shaderOptionArray) {
        HashMap<String, ScreenShaderOptions> hashMap = new HashMap<String, ScreenShaderOptions>();
        ShaderPackParser.parseGuiScreen("screen", properties, hashMap, shaderProfileArray, shaderOptionArray);
        return hashMap.isEmpty() ? null : hashMap;
    }

    private static boolean parseGuiScreen(String string, Properties properties, Map<String, ScreenShaderOptions> map, ShaderProfile[] shaderProfileArray, ShaderOption[] shaderOptionArray) {
        Object object;
        String string2;
        String string3 = properties.getProperty(string);
        if (string3 == null) {
            return false;
        }
        ArrayList<Object> arrayList = new ArrayList<Object>();
        HashSet<String> hashSet = new HashSet<String>();
        String[] stringArray = Config.tokenize(string3, " ");
        for (int i = 0; i < stringArray.length; ++i) {
            Object object2;
            string2 = stringArray[i];
            if (string2.equals("<empty>")) {
                arrayList.add(null);
                continue;
            }
            if (hashSet.contains(string2)) {
                Config.warn("[Shaders] Duplicate option: " + string2 + ", key: " + string);
                continue;
            }
            hashSet.add(string2);
            if (string2.equals("<profile>")) {
                if (shaderProfileArray == null) {
                    Config.warn("[Shaders] Option profile can not be used, no profiles defined: " + string2 + ", key: " + string);
                    continue;
                }
                object2 = new ShaderOptionProfile(shaderProfileArray, shaderOptionArray);
                arrayList.add(object2);
                continue;
            }
            if (string2.equals("*")) {
                object2 = new ShaderOptionRest("<rest>");
                arrayList.add(object2);
                continue;
            }
            if (string2.startsWith("[") && string2.endsWith("]")) {
                object2 = StrUtils.removePrefixSuffix(string2, "[", "]");
                if (!((String)object2).matches("^[a-zA-Z0-9_]+$")) {
                    Config.warn("[Shaders] Invalid screen: " + string2 + ", key: " + string);
                    continue;
                }
                if (!ShaderPackParser.parseGuiScreen("screen." + (String)object2, properties, map, shaderProfileArray, shaderOptionArray)) {
                    Config.warn("[Shaders] Invalid screen: " + string2 + ", key: " + string);
                    continue;
                }
                object = new ShaderOptionScreen((String)object2);
                arrayList.add(object);
                continue;
            }
            object2 = ShaderUtils.getShaderOption(string2, shaderOptionArray);
            if (object2 == null) {
                Config.warn("[Shaders] Invalid option: " + string2 + ", key: " + string);
                arrayList.add(null);
                continue;
            }
            ((ShaderOption)object2).setVisible(true);
            arrayList.add(object2);
        }
        ShaderOption[] shaderOptionArray2 = arrayList.toArray(new ShaderOption[arrayList.size()]);
        string2 = properties.getProperty(string + ".columns");
        int n = Config.parseInt(string2, 2);
        object = new ScreenShaderOptions(string, shaderOptionArray2, n);
        map.put(string, (ScreenShaderOptions)object);
        return true;
    }

    public static BufferedReader resolveIncludes(BufferedReader bufferedReader, String string, IShaderPack iShaderPack, int n, List<String> list, int n2) throws IOException {
        String string2 = "/";
        int n3 = string.lastIndexOf("/");
        if (n3 >= 0) {
            string2 = string.substring(0, n3);
        }
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        int n4 = -1;
        LinkedHashSet<Object> linkedHashSet = new LinkedHashSet<Object>();
        int n5 = 1;
        while (true) {
            Object object5;
            Object object2;
            Object object3;
            Object object4;
            if ((object4 = bufferedReader.readLine()) == null) {
                object3 = charArrayWriter.toCharArray();
                if (n4 >= 0 && linkedHashSet.size() > 0) {
                    object2 = new StringBuilder();
                    for (Object object5 : linkedHashSet) {
                        object2.append("#define ");
                        object2.append(((ShaderMacro)object5).getName());
                        object2.append(" ");
                        object2.append(((ShaderMacro)object5).getValue());
                        object2.append("\n");
                    }
                    String string3 = object2.toString();
                    object5 = new StringBuilder(new String((char[])object3));
                    ((StringBuilder)object5).insert(n4, string3);
                    String string4 = ((StringBuilder)object5).toString();
                    object3 = string4.toCharArray();
                }
                object2 = new CharArrayReader((char[])object3);
                return new BufferedReader((Reader)object2);
            }
            if (n4 < 0 && (object3 = (Object)PATTERN_VERSION.matcher((CharSequence)object4)).matches()) {
                object2 = ShaderMacros.getFixedMacroLines() + ShaderMacros.getOptionMacroLines();
                String string5 = (String)object4 + "\n" + (String)object2;
                object5 = "#line " + (n5 + 1) + " " + n;
                object4 = string5 + (String)object5;
                n4 = charArrayWriter.size() + string5.length();
            }
            if ((object3 = (Object)PATTERN_INCLUDE.matcher((CharSequence)object4)).matches()) {
                int n6;
                object2 = object3.group(1);
                boolean bl = object2.startsWith("/");
                Object object6 = object5 = bl ? "/shaders" + (String)object2 : string2 + "/" + (String)object2;
                if (!list.contains(object5)) {
                    list.add((String)object5);
                }
                if ((object4 = ShaderPackParser.loadFile((String)object5, iShaderPack, n6 = list.indexOf(object5) + 1, list, n2)) == null) {
                    throw new IOException("Included file not found: " + string);
                }
                if (((String)object4).endsWith("\n")) {
                    object4 = ((String)object4).substring(0, ((String)object4).length() - 1);
                }
                Object object7 = "#line 1 " + n6 + "\n";
                if (((String)object4).startsWith("#version ")) {
                    object7 = "";
                }
                object4 = (String)object7 + (String)object4 + "\n#line " + (n5 + 1) + " " + n;
            }
            if (n4 >= 0 && ((String)object4).contains(ShaderMacros.getPrefixMacro())) {
                object2 = ShaderPackParser.findMacros((String)object4, ShaderMacros.getExtensions());
                for (int i = 0; i < ((ShaderMacro[])object2).length; ++i) {
                    object5 = object2[i];
                    linkedHashSet.add(object5);
                }
            }
            charArrayWriter.write((String)object4);
            charArrayWriter.write("\n");
            ++n5;
        }
    }

    private static ShaderMacro[] findMacros(String string, ShaderMacro[] shaderMacroArray) {
        ArrayList<ShaderMacro> arrayList = new ArrayList<ShaderMacro>();
        for (int i = 0; i < shaderMacroArray.length; ++i) {
            ShaderMacro shaderMacro = shaderMacroArray[i];
            if (!string.contains(shaderMacro.getName())) continue;
            arrayList.add(shaderMacro);
        }
        ShaderMacro[] shaderMacroArray2 = arrayList.toArray(new ShaderMacro[arrayList.size()]);
        return shaderMacroArray2;
    }

    private static String loadFile(String string, IShaderPack iShaderPack, int n, List<String> list, int n2) throws IOException {
        if (n2 >= 10) {
            throw new IOException("#include depth exceeded: " + n2 + ", file: " + string);
        }
        ++n2;
        InputStream inputStream2 = iShaderPack.getResourceAsStream(string);
        if (inputStream2 == null) {
            return null;
        }
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream2, "ASCII");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        bufferedReader = ShaderPackParser.resolveIncludes(bufferedReader, string, iShaderPack, n, list, n2);
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        String string2;
        while ((string2 = bufferedReader.readLine()) != null) {
            charArrayWriter.write(string2);
            charArrayWriter.write("\n");
        }
        return charArrayWriter.toString();
    }

    public static CustomUniforms parseCustomUniforms(Properties properties) {
        Object object2;
        String string = "uniform";
        String string2 = "variable";
        String string3 = string + ".";
        String string4 = string2 + ".";
        HashMap<String, IExpression> hashMap = new HashMap<String, IExpression>();
        ArrayList<CustomUniform> arrayList = new ArrayList<CustomUniform>();
        for (Object object2 : properties.keySet()) {
            String string5 = (String)object2;
            String[] stringArray = Config.tokenize(string5, ".");
            if (stringArray.length != 3) continue;
            String string6 = stringArray[0];
            String string7 = stringArray[1];
            String string8 = stringArray[2];
            String string9 = properties.getProperty(string5).trim();
            if (hashMap.containsKey(string8)) {
                SMCLog.warning("Expression already defined: " + string8);
                continue;
            }
            if (!string6.equals(string) && !string6.equals(string2)) continue;
            SMCLog.info("Custom " + string6 + ": " + string8);
            CustomUniform customUniform = ShaderPackParser.parseCustomUniform(string6, string8, string7, string9, hashMap);
            if (customUniform == null) continue;
            hashMap.put(string8, customUniform.getExpression());
            if (string6.equals(string2)) continue;
            arrayList.add(customUniform);
        }
        if (arrayList.size() <= 0) {
            return null;
        }
        CustomUniform[] customUniformArray = arrayList.toArray(new CustomUniform[arrayList.size()]);
        object2 = new CustomUniforms(customUniformArray, hashMap);
        return object2;
    }

    private static CustomUniform parseCustomUniform(String string, String string2, String string3, String string4, Map<String, IExpression> map) {
        try {
            UniformType uniformType = UniformType.parse(string3);
            if (uniformType == null) {
                SMCLog.warning("Unknown " + string + " type: " + String.valueOf((Object)uniformType));
                return null;
            }
            ShaderExpressionResolver shaderExpressionResolver = new ShaderExpressionResolver(map);
            ExpressionParser expressionParser = new ExpressionParser(shaderExpressionResolver);
            IExpression iExpression = expressionParser.parse(string4);
            ExpressionType expressionType = iExpression.getExpressionType();
            if (!uniformType.matchesExpressionType(expressionType)) {
                SMCLog.warning("Expression type does not match " + string + " type, expression: " + String.valueOf((Object)expressionType) + ", " + string + ": " + String.valueOf((Object)uniformType) + " " + string2);
                return null;
            }
            iExpression = ShaderPackParser.makeExpressionCached(iExpression);
            CustomUniform customUniform = new CustomUniform(string2, uniformType, iExpression);
            return customUniform;
        }
        catch (ParseException parseException) {
            SMCLog.warning(parseException.getClass().getName() + ": " + parseException.getMessage());
            return null;
        }
    }

    private static IExpression makeExpressionCached(IExpression iExpression) {
        int n = -1896737807;
        block7: while (true) {
            switch (n) {
                default: {
                    throw null;
                }
                case -1896737807: {
                    if (iExpression instanceof IExpressionFloat) {
                        n = -206406043;
                        continue block7;
                    }
                    n = 1249705164;
                    continue block7;
                }
                case -720469020: {
                    return new ExpressionFloatArrayCached((IExpressionFloatArray)iExpression);
                }
                case 1346397831: {
                    return iExpression;
                }
                case -206406043: {
                    return new ExpressionFloatCached((IExpressionFloat)iExpression);
                }
                case 1249705164: 
            }
            if (iExpression instanceof IExpressionFloatArray) {
                n = -720469020;
                continue;
            }
            n = 1346397831;
        }
    }

    public static void parseAlphaStates(Properties properties) {
        for (Object object : properties.keySet()) {
            String string = (String)object;
            String[] stringArray = Config.tokenize(string, ".");
            if (stringArray.length != 2) continue;
            String string2 = stringArray[0];
            String string3 = stringArray[1];
            if (!string2.equals("alphaTest")) continue;
            Program program = Shaders.getProgram(string3);
            if (program == null) {
                SMCLog.severe("Invalid program name: " + string3);
                continue;
            }
            String string4 = properties.getProperty(string).trim();
            GlAlphaState glAlphaState = ShaderPackParser.parseAlphaState(string4);
            if (glAlphaState == null) continue;
            program.setAlphaState(glAlphaState);
        }
    }

    private static GlAlphaState parseAlphaState(String string) {
        String[] stringArray = null;
        String string2 = null;
        String string3 = null;
        Integer n = null;
        float f = 0.0f;
        int n2 = -253941039;
        block12: while (true) {
            switch (n2) {
                default: {
                    throw null;
                }
                case -1548259720: {
                    if (string2.equals("false")) {
                        n2 = 1249272799;
                        continue block12;
                    }
                    n2 = 765137226;
                    continue block12;
                }
                case 730971357: {
                    if (f >= 0.0f) {
                        n2 = 1520251259;
                        continue block12;
                    }
                    n2 = -304002347;
                    continue block12;
                }
                case 1249272799: {
                    return new GlAlphaState(false);
                }
                case 765137226: {
                    n2 = -304002347;
                    continue block12;
                }
                case -2122849864: {
                    string2 = stringArray[0];
                    if (!string2.equals("off")) {
                        n2 = -1548259720;
                        continue block12;
                    }
                    n2 = 1249272799;
                    continue block12;
                }
                case -253941039: {
                    stringArray = Config.tokenize(string, " ");
                    if (stringArray.length == 1) {
                        n2 = -2122849864;
                        continue block12;
                    }
                    n2 = -1522031983;
                    continue block12;
                }
                case -304002347: {
                    SMCLog.severe("Invalid alpha test: " + string);
                    return null;
                }
                case -1522031983: {
                    if (stringArray.length == 2) {
                        n2 = -1657064448;
                        continue block12;
                    }
                    n2 = -304002347;
                    continue block12;
                }
                case -1657064448: {
                    string2 = stringArray[0];
                    string3 = stringArray[1];
                    n = mapAlphaFuncs.get(string2);
                    f = Config.parseFloat(string3, -1.0f);
                    if (n != null) {
                        n2 = 730971357;
                        continue block12;
                    }
                    n2 = -304002347;
                    continue block12;
                }
                case 1520251259: 
            }
            break;
        }
        return new GlAlphaState(true, n, f);
    }

    public static void parseBlendStates(Properties properties) {
        for (Object object : properties.keySet()) {
            String string = (String)object;
            String[] stringArray = Config.tokenize(string, ".");
            if (stringArray.length != 2) continue;
            String string2 = stringArray[0];
            String string3 = stringArray[1];
            if (!string2.equals("blend")) continue;
            Program program = Shaders.getProgram(string3);
            if (program == null) {
                SMCLog.severe("Invalid program name: " + string3);
                continue;
            }
            String string4 = properties.getProperty(string).trim();
            GlBlendState glBlendState = ShaderPackParser.parseBlendState(string4);
            if (glBlendState == null) continue;
            program.setBlendState(glBlendState);
        }
    }

    private static GlBlendState parseBlendState(String string) {
        String[] stringArray = null;
        String string2 = null;
        String string3 = null;
        String string4 = null;
        String string5 = null;
        Integer n = null;
        Integer n2 = null;
        Integer n3 = null;
        Integer n4 = null;
        int n5 = 1918845688;
        block17: while (true) {
            switch (n5) {
                default: {
                    throw null;
                }
                case -2275231: {
                    return new GlBlendState(true, n, n2, n3, n4);
                }
                case -255280444: {
                    n5 = -611985597;
                    continue block17;
                }
                case 1918845688: {
                    stringArray = Config.tokenize(string, " ");
                    if (stringArray.length == 1) {
                        n5 = 691098283;
                        continue block17;
                    }
                    n5 = 1113199541;
                    continue block17;
                }
                case -92516982: {
                    if (n2 != null) {
                        n5 = 1731377287;
                        continue block17;
                    }
                    n5 = -611985597;
                    continue block17;
                }
                case 622298529: {
                    if (string2.equals("false")) {
                        n5 = -991011307;
                        continue block17;
                    }
                    n5 = -255280444;
                    continue block17;
                }
                case -991011307: {
                    return new GlBlendState(false);
                }
                case -611985597: {
                    SMCLog.severe("Invalid blend mode: " + string);
                    return null;
                }
                case 1113199541: {
                    if (stringArray.length != 2) {
                        n5 = 928903583;
                        continue block17;
                    }
                    n5 = 1276602429;
                    continue block17;
                }
                case 691098283: {
                    string2 = stringArray[0];
                    if (!string2.equals("off")) {
                        n5 = 622298529;
                        continue block17;
                    }
                    n5 = -991011307;
                    continue block17;
                }
                case 1154241663: {
                    string4 = stringArray[2];
                    string5 = stringArray[3];
                    n5 = -1737622118;
                    continue block17;
                }
                case 1276602429: {
                    string2 = stringArray[0];
                    string3 = stringArray[1];
                    string4 = string2;
                    string5 = string3;
                    if (stringArray.length == 4) {
                        n5 = 1154241663;
                        continue block17;
                    }
                    n5 = -1737622118;
                    continue block17;
                }
                case 928903583: {
                    if (stringArray.length == 4) {
                        n5 = 1276602429;
                        continue block17;
                    }
                    n5 = -611985597;
                    continue block17;
                }
                case 1036685682: {
                    if (n4 != null) {
                        n5 = -2275231;
                        continue block17;
                    }
                    n5 = -611985597;
                    continue block17;
                }
                case 1731377287: {
                    if (n3 != null) {
                        n5 = 1036685682;
                        continue block17;
                    }
                    n5 = -611985597;
                    continue block17;
                }
                case -1737622118: 
            }
            n = mapBlendFactors.get(string2);
            n2 = mapBlendFactors.get(string3);
            n3 = mapBlendFactors.get(string4);
            n4 = mapBlendFactors.get(string5);
            if (n != null) {
                n5 = -92516982;
                continue;
            }
            n5 = -611985597;
        }
    }

    public static void parseRenderScales(Properties properties) {
        for (Object object : properties.keySet()) {
            String string = (String)object;
            String[] stringArray = Config.tokenize(string, ".");
            if (stringArray.length != 2) continue;
            String string2 = stringArray[0];
            String string3 = stringArray[1];
            if (!string2.equals("scale")) continue;
            Program program = Shaders.getProgram(string3);
            if (program == null) {
                SMCLog.severe("Invalid program name: " + string3);
                continue;
            }
            String string4 = properties.getProperty(string).trim();
            RenderScale renderScale = ShaderPackParser.parseRenderScale(string4);
            if (renderScale == null) continue;
            program.setRenderScale(renderScale);
        }
    }

    private static RenderScale parseRenderScale(String string) {
        String[] stringArray = null;
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        int n = 1293046477;
        block11: while (true) {
            switch (n) {
                default: {
                    throw null;
                }
                case 1579313886: {
                    if (Config.between(f3, 0.0f, 1.0f)) {
                        n = -65876739;
                        continue block11;
                    }
                    n = -1674606005;
                    continue block11;
                }
                case 315607089: {
                    f2 = Config.parseFloat((String)stringArray[1], -1.0f);
                    f3 = Config.parseFloat(stringArray[2], -1.0f);
                    n = -192283820;
                    continue block11;
                }
                case -218558765: {
                    if (stringArray.length != 3) {
                        n = 275253970;
                        continue block11;
                    }
                    n = 315607089;
                    continue block11;
                }
                case 275253970: {
                    SMCLog.severe("Invalid render scale: " + string);
                    return null;
                }
                case -881756585: {
                    if (Config.between(f2, 0.0f, 1.0f)) {
                        n = 1579313886;
                        continue block11;
                    }
                    n = -1674606005;
                    continue block11;
                }
                case -65876739: {
                    return new RenderScale(f, f2, f3);
                }
                case 1293046477: {
                    stringArray = Config.tokenize(string, " ");
                    f = Config.parseFloat(stringArray[0], -1.0f);
                    f2 = 0.0f;
                    f3 = 0.0f;
                    if (stringArray.length > 1) {
                        n = -218558765;
                        continue block11;
                    }
                    n = -192283820;
                    continue block11;
                }
                case -192283820: {
                    if (Config.between(f, 0.0f, 1.0f)) {
                        n = -881756585;
                        continue block11;
                    }
                    n = -1674606005;
                    continue block11;
                }
                case -1674606005: 
            }
            break;
        }
        SMCLog.severe("Invalid render scale: " + string);
        return null;
    }

    public static void parseBuffersFlip(Properties properties) {
        for (Object object : properties.keySet()) {
            String string = (String)object;
            String[] stringArray = Config.tokenize(string, ".");
            if (stringArray.length != 3) continue;
            String string2 = stringArray[0];
            String string3 = stringArray[1];
            String string4 = stringArray[2];
            if (!string2.equals("flip")) continue;
            Program program = Shaders.getProgram(string3);
            if (program == null) {
                SMCLog.severe("Invalid program name: " + string3);
                continue;
            }
            Boolean[] booleanArray = program.getBuffersFlip();
            int n = Shaders.getBufferIndexFromString(string4);
            if (n >= 0 && n < booleanArray.length) {
                String string5 = properties.getProperty(string).trim();
                Boolean bl = Config.parseBoolean(string5, null);
                if (bl == null) {
                    SMCLog.severe("Invalid boolean value: " + string5);
                    continue;
                }
                booleanArray[n] = bl;
                continue;
            }
            SMCLog.severe("Invalid buffer name: " + string4);
        }
    }

    private static Map<String, Integer> makeMapAlphaFuncs() {
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        hashMap.put("NEVER", new Integer(512));
        hashMap.put("LESS", new Integer(513));
        hashMap.put("EQUAL", new Integer(514));
        hashMap.put("LEQUAL", new Integer(515));
        hashMap.put("GREATER", new Integer(516));
        hashMap.put("NOTEQUAL", new Integer(517));
        hashMap.put("GEQUAL", new Integer(518));
        hashMap.put("ALWAYS", new Integer(519));
        return Collections.unmodifiableMap(hashMap);
    }

    private static Map<String, Integer> makeMapBlendFactors() {
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        hashMap.put("ZERO", new Integer(0));
        hashMap.put("ONE", new Integer(1));
        hashMap.put("SRC_COLOR", new Integer(768));
        hashMap.put("ONE_MINUS_SRC_COLOR", new Integer(769));
        hashMap.put("DST_COLOR", new Integer(774));
        hashMap.put("ONE_MINUS_DST_COLOR", new Integer(775));
        hashMap.put("SRC_ALPHA", new Integer(770));
        hashMap.put("ONE_MINUS_SRC_ALPHA", new Integer(771));
        hashMap.put("DST_ALPHA", new Integer(772));
        hashMap.put("ONE_MINUS_DST_ALPHA", new Integer(773));
        hashMap.put("CONSTANT_COLOR", new Integer(32769));
        hashMap.put("ONE_MINUS_CONSTANT_COLOR", new Integer(32770));
        hashMap.put("CONSTANT_ALPHA", new Integer(32771));
        hashMap.put("ONE_MINUS_CONSTANT_ALPHA", new Integer(32772));
        hashMap.put("SRC_ALPHA_SATURATE", new Integer(776));
        return Collections.unmodifiableMap(hashMap);
    }
}

