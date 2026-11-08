package keystrokesmod.script;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import net.minecraft.client.Minecraft;
import org.apache.logging.log4j.Logger;
import x.oc192c7e4083;
import x.oc2c25634a7e;
import x.oc2cf3d80e17;
import x.oc69da1aa7f5;
import x.oc7ab2161b9f;
import x.oc8ccd9c3f55;
import x.oce4cea752dd;
import x.ocea775c9d5c;

public class ScriptManager {
   private static final char[] INVALID_SCRIPT_NAME_CHARS;
   private Minecraft mc = Minecraft.getMinecraft();
   public LinkedHashMap<Script, oc69da1aa7f5> scripts = new LinkedHashMap<>();
   public JavaCompiler compiler = resolveJavaCompiler();
   public boolean deleteTempFiles = true;
   public File directory;
   public List<String> imports;
   public String COMPILED_DIR;
   public String jarPath;
   private Map<String, String> loadedHashes;
   private final Map<oc69da1aa7f5, Script> callbacks;
   private boolean loading;

   public static JavaCompiler resolveJavaCompiler() {
      try {
         JavaCompiler var0 = ToolProvider.getSystemJavaCompiler();
         if (var0 != null) {
            return var0;
         }
      } catch (Throwable var5) {
      }

      try {
         Iterator var6 = ServiceLoader.load(JavaCompiler.class, ClassLoader.getPlatformClassLoader()).iterator();
         if (var6.hasNext()) {
            return (JavaCompiler)var6.next();
         }
      } catch (Throwable var4) {
      }

      try {
         Iterator var7 = ServiceLoader.load(JavaCompiler.class, JavaCompiler.class.getClassLoader()).iterator();
         if (var7.hasNext()) {
            return (JavaCompiler)var7.next();
         }
      } catch (Throwable var3) {
      }

      try {
         Iterator var8 = ServiceLoader.load(JavaCompiler.class, Thread.currentThread().getContextClassLoader()).iterator();
         if (var8.hasNext()) {
            return (JavaCompiler)var8.next();
         }
      } catch (Throwable var2) {
      }

      return null;
   }

   public ScriptManager() {
      this(defaultGameDirectory());
   }

   public ScriptManager(File var1) {
      String[] var10001 = new String[1687191844 ^ 1687191863];
      var10001[0] = Color.class.getName();
      var10001[1] = Collections.class.getName();
      var10001[1687191861 ^ 1687191863] = List.class.getName();
      var10001[1687191860 ^ 1687191863] = ArrayList.class.getName();
      var10001[1687191859 ^ 1687191863] = Arrays.class.getName();
      var10001[1687191858 ^ 1687191863] = Map.class.getName();
      var10001[1687191857 ^ 1687191863] = Set.class.getName();
      var10001[1687191856 ^ 1687191863] = HashMap.class.getName();
      var10001[1687191871 ^ 1687191863] = HashSet.class.getName();
      var10001[1687191870 ^ 1687191863] = ConcurrentHashMap.class.getName();
      var10001[1687191869 ^ 1687191863] = LinkedHashMap.class.getName();
      var10001[1687191868 ^ 1687191863] = LinkedHashSet.class.getName();
      var10001[1687191867 ^ 1687191863] = Iterator.class.getName();
      var10001[1687191866 ^ 1687191863] = Comparator.class.getName();
      var10001[1687191865 ^ 1687191863] = AtomicInteger.class.getName();
      var10001[1687191864 ^ 1687191863] = AtomicLong.class.getName();
      var10001[1687191847 ^ 1687191863] = AtomicBoolean.class.getName();
      var10001[1687191846 ^ 1687191863] = Random.class.getName();
      var10001[1687191845 ^ 1687191863] = Matcher.class.getName();
      this.imports = Arrays.asList(var10001);
      this.jarPath = compilerClasspath();
      this.loadedHashes = new HashMap<>();
      this.callbacks = new ConcurrentHashMap<>();
      if (var1 == null) {
         var1 = defaultGameDirectory();
      }

      this.directory = new File(oc8ccd9c3f55.Ȓ(var1), "scripts");

      try {
         this.COMPILED_DIR = Files.createTempDirectory("miau-scripts-").toString();
         new File(this.COMPILED_DIR).deleteOnExit();
      } catch (IOException var3) {
         throw new IllegalStateException("Unable to create scripting compiler directory", var3);
      }
   }

   private static File defaultGameDirectory() {
      Minecraft var0 = Minecraft.getMinecraft();
      return var0 != null && var0.mcDataDir != null ? var0.mcDataDir : new File(System.getProperty("user.dir", "."));
   }

   public static String compilerClasspath() {
      LinkedHashSet var0 = new LinkedHashSet();

      try {
         URL var1 = ScriptManager.class.getProtectionDomain().getCodeSource().getLocation();
         if (var1 != null) {
            try {
               var0.add(new File(var1.toURI()).getPath());
            } catch (Exception var12) {
               var0.add(new File(var1.getPath()).getPath());
            }
         }
      } catch (Exception var13) {
         oc7ab2161b9f.ô.warn("Unable to resolve scripting API location", var13);
      }

      for (String var4 : System.getProperty("java.class.path", "").split(Pattern.quote(File.pathSeparator))) {
         if (!var4.isEmpty()) {
            var0.add(var4);
         }
      }

      for (ClassLoader var16 = ScriptManager.class.getClassLoader(); var16 != null; var16 = var16.getParent()) {
         if (var16 instanceof URLClassLoader) {
            for (URL var5 : ((URLClassLoader)var16).getURLs()) {
               if ("file".equals(var5.getProtocol())) {
                  try {
                     var0.add(new File(var5.toURI()).getPath());
                  } catch (Exception var11) {
                     try {
                        var0.add(new File(var5.getPath()).getPath());
                     } catch (Exception var10) {
                     }
                  }
               }
            }
         }
      }

      try {
         ClassLoader var17 = Thread.currentThread().getContextClassLoader();
         if (var17 instanceof URLClassLoader) {
            for (URL var24 : ((URLClassLoader)var17).getURLs()) {
               if ("file".equals(var24.getProtocol())) {
                  try {
                     var0.add(new File(var24.toURI()).getPath());
                  } catch (Exception var9) {
                     try {
                        var0.add(new File(var24.getPath()).getPath());
                     } catch (Exception var8) {
                     }
                  }
               }
            }
         }
      } catch (Throwable var14) {
      }

      return String.join(File.pathSeparator, var0);
   }

   public void onEnable(Script var1) {
      if (var1.event == null) {
         var1.event = new ScriptEvents(this.getModule(var1));
         ocea775c9d5c.ų.register(var1.event);
      }

      var1.invoke("onEnable", new Object[0]);
   }

   public oc69da1aa7f5 getModule(Script var1) {
      for (Entry var3 : this.scripts.entrySet()) {
         if (((Script)var3.getKey()).equals(var1)) {
            return (oc69da1aa7f5)var3.getValue();
         }
      }

      return null;
   }

   public synchronized void shutdown() {
      for (oc69da1aa7f5 var2 : new ArrayList<>(this.scripts.values())) {
         try {
            if (var2.z$3rzb3dil7uydr()) {
               var2.z$1ca1cmv0s357();
            }
         } catch (Throwable var4) {
            Logger var10000 = oc7ab2161b9f.ô;
            Object[] var10002 = new Object[-1546161010 ^ -1546161012];
            var10002[0] = var2.z$3i8m9vxwuvqj0();
            var10002[1] = var4;
            var10000.error("Unable to disable script module {}", var10002);
         }

         if (oc2cf3d80e17.ļ != null) {
            oc2cf3d80e17.ļ.ѷ(var2);
         }
      }

      this.scripts.clear();
      this.callbacks.clear();
      this.loadedHashes.clear();
      ScriptDefaults.reloadModules();
      this.refreshScriptModules();
   }

   public String createScript(String var1) {
      String var2 = this.normalizeScriptName(var1);
      String var3 = this.validateScriptName(var2, null);
      if (var3 != null) {
         oc7ab2161b9f.ý("&c" + var3);
         return null;
      } else {
         try {
            if (!this.directory.exists() && !this.directory.mkdirs()) {
               oc7ab2161b9f.ý("&cFailed to create scripts folder.");
               return null;
            } else {
               Files.write(new File(this.directory, var2 + ".java").toPath(), this.buildDefaultScriptTemplate().getBytes(StandardCharsets.UTF_8));
               this.loadScripts();
               return var2;
            }
         } catch (Exception var5) {
            oc7ab2161b9f.ý("&cFailed to create script: &b" + var2);
            var5.printStackTrace();
            return null;
         }
      }
   }

   public void loadScripts() {
      if (!this.loading) {
         this.loading = true;

         try {
            HashMap var1 = new HashMap();
            HashMap var2 = new HashMap();

            for (oc69da1aa7f5 var4 : this.scripts.values()) {
               var1.put(var4.z$3i8m9vxwuvqj0(), var4.z$3rzb3dil7uydr());
               if (var4 instanceof ScriptModule) {
                  var2.put(var4.z$3i8m9vxwuvqj0(), ((ScriptModule)var4).getCustomName());
               }
            }

            if (this.deleteTempFiles) {
               this.deleteTempFiles = false;
               File var19 = new File(this.COMPILED_DIR);
               if (var19.exists() && var19.isDirectory()) {
                  File[] var22 = var19.listFiles();
                  if (var22 != null) {
                     for (File var8 : var22) {
                        if (this.isGeneratedClass(var8) && !var8.delete()) {
                           System.err.println("Failed to delete temp file: " + var8.getAbsolutePath());
                        }
                     }
                  }
               }
            } else if (!this.scripts.isEmpty()) {
               Iterator var18 = this.scripts.entrySet().iterator();

               while (var18.hasNext()) {
                  Entry var21 = (Entry)var18.next();
                  if (((Script)var21.getKey()).file != null && ((Script)var21.getKey()).file.exists()) {
                     String var5 = ((Script)var21.getKey()).file.getName();
                     String var6 = this.calculateHash(((Script)var21.getKey()).file);
                     String var7 = this.loadedHashes.get(var5);
                     if (var7 == null || !var7.equals(var6) || ((Script)var21.getKey()).error || ((Script)var21.getKey()).usesLoadString) {
                        if (((oc69da1aa7f5)var21.getValue()).z$3rzb3dil7uydr()) {
                           ((oc69da1aa7f5)var21.getValue()).z$1ca1cmv0s357();
                        }

                        ((Script)var21.getKey()).delete();
                        oc2cf3d80e17.ļ.ѷ((oc69da1aa7f5)var21.getValue());
                        this.callbacks.remove(var21.getValue());
                        var18.remove();
                        this.loadedHashes.remove(var5);
                     }
                  } else {
                     if (((oc69da1aa7f5)var21.getValue()).z$3rzb3dil7uydr()) {
                        ((oc69da1aa7f5)var21.getValue()).z$1ca1cmv0s357();
                     }

                     ((Script)var21.getKey()).delete();
                     oc2cf3d80e17.ļ.ѷ((oc69da1aa7f5)var21.getValue());
                     this.callbacks.remove(var21.getValue());
                     var18.remove();
                     this.loadedHashes.remove(((Script)var21.getKey()).file != null ? ((Script)var21.getKey()).file.getName() : "");
                  }
               }
            } else {
               this.loadedHashes.clear();
            }

            File var20 = this.directory;
            if (var20.exists() && var20.isDirectory()) {
               File[] var23 = var20.listFiles();
               if (var23 != null) {
                  Arrays.sort(var23, Comparator.comparing(File::getName));

                  for (File var34 : var23) {
                     if (var34.isFile() && var34.getName().endsWith(".java")) {
                        String var9 = var34.getName();
                        String var10 = this.calculateHash(var34);
                        String var11 = this.loadedHashes.get(var9);
                        if (var11 == null || !var11.equals(var10)) {
                           this.parseFile(var34, var1);
                           Script var12 = this.getScriptByFile(var34);
                           oc69da1aa7f5 var13 = var12 == null ? null : this.getModule(var12);
                           if (var13 instanceof ScriptModule) {
                              String var14 = (String)var2.get(var13.z$3i8m9vxwuvqj0());
                              if (var14 != null) {
                                 ((ScriptModule)var13).setCustomName(var14);
                              }
                           }

                           this.loadedHashes.put(var34.getName(), var10);
                        }
                     }
                  }
               }
            } else if (var20.mkdirs()) {
               System.out.println("Created script directory: " + var20.getAbsolutePath());
            } else {
               System.err.println("Failed to create script directory: " + var20.getAbsolutePath());
            }

            this.refreshScriptModules();
            ScriptDefaults.reloadModules();
            File var24 = new File(this.COMPILED_DIR);
            if (var24.exists() && var24.isDirectory()) {
               File[] var27 = var24.listFiles();
               if (var27 != null) {
                  for (File var36 : var27) {
                     if (this.isGeneratedClass(var36) && !var36.delete()) {
                        System.err.println("Failed to delete temp file: " + var36.getAbsolutePath());
                     }
                  }
               }
            }

            if (oc2cf3d80e17.щ != null) {
               oc2cf3d80e17.щ.ĵ();
            }
         } finally {
            this.loading = false;
         }
      }
   }

   private boolean parseFile(File var1) {
      return this.parseFile(var1, Collections.emptyMap());
   }

   private boolean parseFile(File var1, Map<String, Boolean> var2) {
      if (!var1.getName().startsWith("_") && var1.getName().endsWith(".java")) {
         String var3 = var1.getName().substring(0, var1.getName().length() - ".java".length());
         if (var3.isEmpty()) {
            return false;
         } else {
            for (Script var5 : this.scripts.keySet()) {
               if (var5.name.equalsIgnoreCase(var3) && (var5.file == null || !var5.file.equals(var1))) {
                  oc7ab2161b9f.ý("&cDuplicate script name: &b" + var3);
                  return false;
               }
            }

            StringBuilder var16 = new StringBuilder();

            String var6;
            try (BufferedReader var17 = Files.newBufferedReader(var1.toPath(), StandardCharsets.UTF_8)) {
               while ((var6 = var17.readLine()) != null) {
                  var16.append(var6).append("\n");
               }
            } catch (Exception var15) {
               var15.printStackTrace();
            }

            if (var16.length() == 0) {
               return false;
            } else {
               String var18 = this.normalizeLineSeparators(var16.toString());
               List var19 = oc7ab2161b9f.ը(var18);
               boolean var7 = false;

               for (String var9 : var19) {
                  if (var9.startsWith("load - \"") && var9.endsWith("\"")) {
                     var7 = true;
                     int var10 = var18.indexOf(var9);
                     if (var10 != -1) {
                        var18 = var18.substring(0, var10) + var18.substring(var10 + var9.length());
                     }

                     if (!Manager.enableHttpRequests.ǭ()) {
                        oc7ab2161b9f.ý("&7Blocked &cload string&7 in &b" + var3 + "&7, http requests are not enabled.");
                     } else {
                        String var11 = var9.substring("load - \"".length(), var9.length() - 1);
                        String var12 = this.normalizeLineSeparators(ScriptHttp.load(var11));
                        if (var12.isEmpty()) {
                           break;
                        }

                        if (var10 != -1) {
                           var18 = var18.substring(0, var10) + var12 + var18.substring(var10);
                        }
                     }
                  }
               }

               Script var20 = new Script(var3);
               var20.file = var1;
               var20.usesLoadString = var7;
               var20.setCode(var18);
               var20.run();
               ScriptModule var21 = new ScriptModule(var20);
               oc2cf3d80e17.ľ.scripts.put(var20, var21);
               this.callbacks.put(var21, var20);
               oc2cf3d80e17.ļ.Ȼ(var21);
               ScriptDefaults.reloadModules();
               oc2cf3d80e17.ľ.invoke("onLoad", var21);
               if (var2 != null && Boolean.TRUE.equals(var2.get(var3)) && var21.canBeEnabled()) {
                  var21.Х();
               }

               return !var20.error;
            }
         }
      } else {
         return false;
      }
   }

   private String normalizeLineSeparators(String var1) {
      return var1 == null
         ? ""
         : var1.replace((char)(-360908859 ^ -360917011), (char)(-360917017 ^ -360917011))
            .replace((char)(-360908860 ^ -360917011), (char)(-360917017 ^ -360917011))
            .replace((char)(-360917144 ^ -360917011), (char)(-360917017 ^ -360917011));
   }

   public void onDisable(Script var1) {
      if (var1.event != null) {
         ocea775c9d5c.ų.unregister(var1.event);
         var1.event = null;
      }

      var1.invoke("onDisable", new Object[0]);
   }

   public void invoke(String var1, oc69da1aa7f5 var2, Object... var3) {
      Script var4 = this.callbacks.get(var2);
      if (var4 != null && (var2.canBeEnabled() && var2.z$3rzb3dil7uydr() || var1.equals("onLoad"))) {
         var4.invoke(var1, var3);
      }
   }

   public int invokeBoolean(String var1, oc69da1aa7f5 var2, Object... var3) {
      Script var4 = this.callbacks.get(var2);
      return var4 != null && var2.canBeEnabled() && var2.z$3rzb3dil7uydr() ? var4.getBoolean(var1, var3) : -1;
   }

   public Float[] invokeFloatArray(String var1, oc69da1aa7f5 var2, Object... var3) {
      Script var4 = this.callbacks.get(var2);
      return var4 != null && var2.canBeEnabled() && var2.z$3rzb3dil7uydr() ? var4.getFloatArray(var1, var3) : null;
   }

   private String calculateHash(File var1) {
      try {
         MessageDigest var2 = MessageDigest.getInstance("SHA-256");
         byte[] var3 = Files.readAllBytes(Paths.get(var1.getPath()));
         byte[] var4 = var2.digest(var3);
         StringBuilder var5 = new StringBuilder();

         for (byte var9 : var4) {
            var5.append(String.format("%02x", var9));
         }

         return var5.toString();
      } catch (Exception var10) {
         return "";
      }
   }

   public boolean renameScript(Script var1, String var2) {
      if (var1 != null && var1.file != null) {
         String var3 = var1.name;
         String var4 = this.normalizeScriptName(var2);
         String var5 = this.validateScriptName(var4, var3);
         if (var5 != null) {
            oc7ab2161b9f.ý("&c" + var5);
            return false;
         } else if (var3.equals(var4)) {
            return true;
         } else {
            File var6 = new File(this.directory, var4 + ".java");

            try {
               Files.move(var1.file.toPath(), var6.toPath(), StandardCopyOption.REPLACE_EXISTING);
               this.loadScripts();
               return true;
            } catch (Exception var8) {
               oc7ab2161b9f.ý("&cFailed to rename script: &b" + var3);
               var8.printStackTrace();
               return false;
            }
         }
      } else {
         oc7ab2161b9f.ý("&cFailed to rename script.");
         return false;
      }
   }

   private void refreshScriptModules() {
      if (oc2cf3d80e17.V != null) {
         for (oc192c7e4083 var2 : oc2c25634a7e.ʴ) {
            if (var2.ȩ == oce4cea752dd.ռ) {
               var2.ā();
               break;
            }
         }

         if (oc2cf3d80e17.ե != null) {
            oc2cf3d80e17.ե.Ћ();
         }
      }
   }

   private boolean isGeneratedClass(File var1) {
      return var1.isFile() && var1.getName().startsWith("sc_") && var1.getName().endsWith(".class");
   }

   public Script getScript(String var1) {
      if (var1 == null) {
         return null;
      } else {
         for (Script var3 : this.scripts.keySet()) {
            if (var3.name.equalsIgnoreCase(var1)) {
               return var3;
            }
         }

         return null;
      }
   }

   public Script getScriptByFile(File var1) {
      if (var1 == null) {
         return null;
      } else {
         for (Script var3 : this.scripts.keySet()) {
            if (var3.file != null && var3.file.equals(var1)) {
               return var3;
            }
         }

         return null;
      }
   }

   private String validateScriptName(String var1, String var2) {
      if (var1.isEmpty()) {
         return "Script name cannot be empty.";
      } else if (!var1.endsWith(".") && !var1.endsWith(" ")) {
         for (char var6 : var1.toCharArray()) {
            if (var6 < (-2102854808 ^ -2102854840) || this.containsInvalidScriptChar(var6)) {
               return "Script name contains invalid characters.";
            }
         }

         File var7 = new File(this.directory, var1 + ".java");
         return (var2 == null || !var2.equalsIgnoreCase(var1)) && var7.exists() ? "Script already exists: " + var1 : null;
      } else {
         return "Script name cannot end with a space or period.";
      }
   }

   private boolean containsInvalidScriptChar(char var1) {
      for (char var5 : INVALID_SCRIPT_NAME_CHARS) {
         if (var5 == var1) {
            return true;
         }
      }

      return false;
   }

   private String normalizeScriptName(String var1) {
      return var1 == null ? "" : var1.trim();
   }

   private String buildDefaultScriptTemplate() {
      return "// New Raven script\nvoid onLoad() {\n}\n\nvoid onEnable() {\n}\n\nvoid onDisable() {\n}\n";
   }

   static {
      char[] var10000 = new char[1066659457 ^ 1066659464];
      var10000[0] = (char)(1066659540 ^ 1066659464);
      var10000[1] = (char)(1066659495 ^ 1066659464);
      var10000[1066659466 ^ 1066659464] = (char)(1066659506 ^ 1066659464);
      var10000[1066659467 ^ 1066659464] = (char)(1066659490 ^ 1066659464);
      var10000[1066659468 ^ 1066659464] = (char)(1066659511 ^ 1066659464);
      var10000[1066659469 ^ 1066659464] = (char)(1066659498 ^ 1066659464);
      var10000[1066659470 ^ 1066659464] = (char)(1066659508 ^ 1066659464);
      var10000[1066659471 ^ 1066659464] = (char)(1066659510 ^ 1066659464);
      var10000[1066659456 ^ 1066659464] = (char)(1066659572 ^ 1066659464);
      INVALID_SCRIPT_NAME_CHARS = var10000;
   }
}
