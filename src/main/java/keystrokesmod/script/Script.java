package keystrokesmod.script;

import java.io.File;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import javax.tools.StandardJavaFileManager;
import keystrokesmod.oc502dfc7784;
import keystrokesmod.script.ScriptDefaults.modules;
import keystrokesmod.script.ScriptSourceTransformer.ProcessedScript;
import org.apache.logging.log4j.Logger;
import x.oc2cf3d80e17;
import x.oc7ab2161b9f;

public class Script {
   public String name;
   public Class clazz;
   public Object instance;
   public String scriptName;
   public String codeStr;
   public boolean error = false;
   public String lastError = null;
   public boolean usesLoadString = false;
   public int STARTING_LINE;
   public ScriptEvents event;
   public File file;

   public Script(String var1) {
      this.name = var1;
      this.scriptName = "sc_" + var1.replaceAll("[^a-zA-Z0-9_$]", "_") + "_" + oc7ab2161b9f.Ҥ(-2060683430 ^ -2060683434);
   }

   private ScriptManager manager() {
      return oc2cf3d80e17.ľ != null ? oc2cf3d80e17.ľ : oc502dfc7784.ң;
   }

   public boolean run() {
      try {
         if (this.scriptName != null && this.codeStr != null) {
            this.lastError = null;
            ScriptManager var1 = this.manager();
            if (var1 == null) {
               this.error = true;
               return false;
            } else {
               File var2 = new File(var1.COMPILED_DIR);
               if (!var2.exists() || !var2.isDirectory()) {
                  Files.createDirectories(var2.toPath());
               }

               if (var1.compiler == null) {
                  this.error = true;
                  this.lastError = "Launch client with JDK 17+ to compile scripts";
                  oc7ab2161b9f.ý("&cCannot compile scripts: launch Miau with a JDK (Java 17 or newer).");
                  return false;
               } else {
                  ScriptDiagnosticListener var3 = new ScriptDiagnosticListener(this);

                  boolean var19;
                  try (StandardJavaFileManager var4 = var1.compiler.getStandardFileManager(var3, null, StandardCharsets.UTF_8)) {
                     ArrayList var5 = new ArrayList();
                     var5.add("-d");
                     var5.add(var1.COMPILED_DIR);
                     String[] var10001 = new String[-851887767 ^ -851887762];
                     var10001[0] = "--release";
                     var10001[1] = "17";
                     var10001[-851887764 ^ -851887762] = "-proc:none";
                     var10001[-851887763 ^ -851887762] = "-encoding";
                     var10001[-851887766 ^ -851887762] = "UTF-8";
                     var10001[-851887765 ^ -851887762] = "-classpath";
                     var10001[-851887768 ^ -851887762] = var1.jarPath;
                     var5.addAll(Arrays.asList(var10001));
                     boolean var6 = var1.compiler
                        .getTask(
                           null,
                           ContainerCompilation.fileManager(var4, Script.class.getClassLoader()),
                           var3,
                           var5,
                           null,
                           Arrays.asList(new JavaSourceFromString(this.scriptName, this.codeStr, this.STARTING_LINE))
                        )
                        .call();
                     if (!var6) {
                        this.error = true;
                        return false;
                     }

                     try (SecureClassLoader var7 = new SecureClassLoader(new URL[]{var2.toURI().toURL()}, Script.class.getClassLoader())) {
                        this.clazz = var7.loadClass(this.scriptName);
                        this.loadGeneratedNestedClasses(var7, var2);
                        this.instance = this.clazz.getDeclaredConstructor().newInstance();
                        this.clazz.getDeclaredMethods();
                     } catch (Throwable var16) {
                        var16.printStackTrace();
                        String var21 = this.name;
                        String var22 = var16.getClass().getSimpleName();
                        String var10 = var16.getMessage();
                        String var11 = var22;
                        String var12 = var21;
                        oc7ab2161b9f.ý("&7Script &b" + var12 + " &cfailed to load: &7" + var11 + ": " + var10);
                        this.error = true;
                        return false;
                     }

                     var19 = true;
                  }

                  return var19;
               }
            }
         } else {
            return false;
         }
      } catch (Exception var18) {
         Logger var10000 = oc7ab2161b9f.ô;
         Object[] var10002 = new Object[-851887764 ^ -851887762];
         var10002[0] = this.name;
         var10002[1] = var18;
         var10000.error("Unable to compile script {}", var10002);
         this.error = true;
         return !this.error;
      }
   }

   public int getBoolean(String var1, Object... var2) {
      if (this.clazz != null && this.instance != null) {
         Method var3 = null;

         for (Method var7 : this.clazz.getDeclaredMethods()) {
            if (var7.getName().equalsIgnoreCase(var1) && var7.getParameterCount() == var2.length && var7.getReturnType().equals(boolean.class)) {
               var3 = var7;
               break;
            }
         }

         if (var3 != null) {
            try {
               var3.setAccessible(true);
               Object var13 = var3.invoke(this.instance, var2);
               if (var13 instanceof Boolean) {
                  return (Boolean)var13 ? 1 : 0;
               }
            } catch (Throwable var12) {
               oc7ab2161b9f.ý("&7Runtime error during script &b" + this.name);
               if (var12.getCause() == null) {
                  oc7ab2161b9f.ý(" &7err: &cThrowable");
               } else {
                  oc7ab2161b9f.ý(" &7err: &c" + describeCause(var12.getCause()));
                  StackTraceElement[] var14 = var12.getCause().getStackTrace();
                  if (var14.length > 0) {
                     StackTraceElement var15 = var14[0];

                     for (StackTraceElement var11 : var12.getCause().getStackTrace()) {
                        if (var11.getClassName().equalsIgnoreCase(this.scriptName)) {
                           var15 = var11;
                           break;
                        }
                     }

                     oc7ab2161b9f.ý(" &7line: &c" + (var15.getLineNumber() - this.STARTING_LINE));
                     oc7ab2161b9f.ý(" &7src: &c" + var15.getMethodName());
                  }
               }
            }
         }

         return -1;
      } else {
         return -1;
      }
   }

   public String getString(String var1, Object... var2) {
      if (this.clazz != null && this.instance != null) {
         Method var3 = null;

         for (Method var7 : this.clazz.getDeclaredMethods()) {
            if (var7.getName().equalsIgnoreCase(var1) && var7.getParameterCount() == var2.length && var7.getReturnType().equals(String.class)) {
               var3 = var7;
               break;
            }
         }

         if (var3 != null) {
            try {
               var3.setAccessible(true);
               Object var13 = var3.invoke(this.instance, var2);
               if (var13 instanceof String) {
                  return (String)var13;
               }
            } catch (Throwable var12) {
               oc7ab2161b9f.ý("&7Runtime error during script &b" + this.name);
               if (var12.getCause() == null) {
                  oc7ab2161b9f.ý(" &7err: &cThrowable");
               } else {
                  oc7ab2161b9f.ý(" &7err: &c" + describeCause(var12.getCause()));
                  StackTraceElement[] var14 = var12.getCause().getStackTrace();
                  if (var14.length > 0) {
                     StackTraceElement var15 = var14[0];

                     for (StackTraceElement var11 : var12.getCause().getStackTrace()) {
                        if (var11.getClassName().equalsIgnoreCase(this.scriptName)) {
                           var15 = var11;
                           break;
                        }
                     }

                     oc7ab2161b9f.ý(" &7line: &c" + (var15.getLineNumber() - this.STARTING_LINE));
                     oc7ab2161b9f.ý(" &7src: &c" + var15.getMethodName());
                  }
               }
            }
         }

         return null;
      } else {
         return null;
      }
   }

   public Float[] getFloatArray(String var1, Object... var2) {
      if (this.clazz != null && this.instance != null) {
         Method var3 = null;

         for (Method var7 : this.clazz.getDeclaredMethods()) {
            if (var7.getName().equals(var1) && var7.getReturnType().equals(Float[].class) && var7.getParameterCount() == var2.length) {
               var3 = var7;
               break;
            }
         }

         if (var3 != null) {
            try {
               var3.setAccessible(true);
               Object var13 = var3.invoke(this.instance, var2);
               if (var13 instanceof Float[]) {
                  return (Float[])var13;
               }
            } catch (Throwable var12) {
               oc7ab2161b9f.ý("&7Runtime error during script &b" + this.name);
               if (var12.getCause() == null) {
                  oc7ab2161b9f.ý(" &7err: &cThrowable");
               } else {
                  oc7ab2161b9f.ý(" &7err: &c" + describeCause(var12.getCause()));
                  StackTraceElement[] var14 = var12.getCause().getStackTrace();
                  if (var14.length > 0) {
                     StackTraceElement var15 = var14[0];

                     for (StackTraceElement var11 : var12.getCause().getStackTrace()) {
                        if (var11.getClassName().equalsIgnoreCase(this.scriptName)) {
                           var15 = var11;
                           break;
                        }
                     }

                     oc7ab2161b9f.ý(" &7line: &c" + (var15.getLineNumber() - this.STARTING_LINE));
                     oc7ab2161b9f.ý(" &7src: &c" + var15.getMethodName());
                  }
               }
            }
         }

         return null;
      } else {
         return null;
      }
   }

   public void delete() {
      this.clazz = null;
      this.instance = null;
      ScriptManager var1 = this.manager();
      if (var1 != null) {
         File var2 = new File(var1.COMPILED_DIR + File.separator + this.scriptName + ".class");
         if (var2.exists()) {
            var2.delete();
         }
      }
   }

   public void setCode(String var1) {
      this.STARTING_LINE = 0;
      StringBuilder var2 = new StringBuilder();
      ScriptManager var3 = this.manager();
      if (var3 == null) {
         this.codeStr = var1;
      } else {
         Iterator var4 = var3.imports.iterator();

         while (var4.hasNext()) {
            this.STARTING_LINE++;
            var2.append("import ").append((String)var4.next()).append(";\n");
         }

         var2.append("import keystrokesmod.script.model.*;\n");
         var2.append("import keystrokesmod.script.packet.clientbound.*;\n");
         var2.append("import keystrokesmod.script.packet.serverbound.*;\n");
         var2.append("import keystrokesmod.script.ScriptDefaults.*;\n");
         var2.append("import keystrokesmod.utility.*;\n");
         ProcessedScript var5 = ScriptSourceTransformer.process(var1, this.name);

         for (String var7 : var5.extractedImports) {
            this.STARTING_LINE++;
            var2.append("import ").append(var7).append(";\n");
         }

         String var15 = this.name.replace("\\", "\\\\").replace("\"", "\\\"").replace("\n", "\\n").replace("\r", "\\r");
         String var16 = var5.code;
         String var10001 = String.valueOf(var2);
         String var10002 = this.scriptName;
         String var10003 = ScriptDefaults.class.getName();
         String var11;
         String var12 = var11 = modules.class.getName().replace("$", ".");
         String var13 = var10003;
         String var14 = var10002;
         this.codeStr = var10001
            + "@SuppressWarnings(\"unchecked\")public class "
            + var14
            + " extends "
            + var13
            + " {public static final "
            + var12
            + " modules = new "
            + var11
            + "(\""
            + var15
            + "\");public static final String scriptName = \""
            + var15
            + "\";\n"
            + var16
            + "\n}";
         this.STARTING_LINE += 1390429918 ^ 1390429915;
      }
   }

   private void loadGeneratedNestedClasses(SecureClassLoader var1, File var2) throws ClassNotFoundException {
      File[] var3 = var2.listFiles((var1x, var2x) -> var2x.startsWith(this.scriptName + "$") && var2x.endsWith(".class"));
      if (var3 != null && var3.length != 0) {
         Arrays.sort(var3, Comparator.<File>comparingInt(var1x -> this.nestedClassDepth(var1x.getName())).thenComparing(File::getName));

         for (File var7 : var3) {
            String var8 = var7.getName();
            var1.loadClass(var8.substring(0, var8.length() - ".class".length()));
         }
      }
   }

   private int nestedClassDepth(String var1) {
      int var2 = 0;

      for (int var3 = 0; var3 < var1.length(); var3++) {
         if (var1.charAt(var3) == (646314763 ^ 646314799)) {
            var2++;
         }
      }

      return var2;
   }

   public boolean invoke(String var1, Object... var2) {
      if (this.clazz != null && this.instance != null) {
         Method var3 = null;

         for (Method var7 : this.clazz.getDeclaredMethods()) {
            if (var7.getName().equalsIgnoreCase(var1) && var7.getParameterCount() == var2.length && var7.getReturnType().equals(void.class)) {
               var3 = var7;
               break;
            }
         }

         if (var3 != null) {
            try {
               var3.setAccessible(true);
               var3.invoke(this.instance, var2);
               return true;
            } catch (Throwable var15) {
               PrintStream var10000 = System.err;
               String var10001 = this.name;
               String var12 = String.valueOf(var15.getCause() != null ? var15.getCause() : var15);
               String var14 = var10001;
               var10000.println("[script-runtime] " + var14 + " " + var1 + ": " + var12);
               oc7ab2161b9f.ý("&7Runtime error during script &b" + this.name);
               if (var15.getCause() == null) {
                  oc7ab2161b9f.ý(" &7err: &cThrowable");
               } else {
                  oc7ab2161b9f.ý(" &7err: &c" + describeCause(var15.getCause()));
                  StackTraceElement[] var16 = var15.getCause().getStackTrace();
                  if (var16.length > 0) {
                     StackTraceElement var17 = var16[0];

                     for (StackTraceElement var11 : var15.getCause().getStackTrace()) {
                        if (var11.getClassName().equalsIgnoreCase(this.scriptName)) {
                           var17 = var11;
                           break;
                        }
                     }

                     oc7ab2161b9f.ý(" &7line: &c" + (var17.getLineNumber() - this.STARTING_LINE));
                     oc7ab2161b9f.ý(" &7src: &c" + var17.getMethodName());
                  }
               }
            }
         }

         return false;
      } else {
         return false;
      }
   }

   private static String describeCause(Throwable var0) {
      if (var0 == null) {
         return "Unknown";
      } else {
         String var1 = var0.getClass().getSimpleName();
         String var2 = var0.getMessage();
         return var2 != null && !var2.isEmpty() && !var2.equals(var1) ? var1 + ": " + var2 : var1;
      }
   }
}
