package x;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.regex.Pattern;

public class U {
   static final String ϗ = "version";
   private static final Pattern ԃ = Pattern.compile("^v?(\\d+(?:\\.\\d+)*)(.*)$", 1529587604 ^ 1529587606);
   private static final Pattern Ϲ = Pattern.compile("[a-z]+|\\d+", 1529587604 ^ 1529587606);

   private U() {
   }

   static void Ђ(JsonObject var0) {
      var0.addProperty("version", "2.5");
   }

   static String Ѕ(JsonObject param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: ldc2_w 1096344447969701398
      // 03: ldc2_w 1096299846584808838
      // 06: lxor
      // 07: lstore 1
      // 08: lload 1
      // 09: dup2
      // 0a: ldc2_w 1096306655913795838
      // 0d: ldc2_w 1096299846584808838
      // 10: lxor
      // 11: lxor
      // 12: lstore 3
      // 13: pop2
      // 14: getstatic x/oc151419fdfe.v Z
      // 17: istore 5
      // 19: aload 0
      // 1a: iload 5
      // 1c: ifne 30
      // 1f: ifnonnull 2a
      // 22: goto 26
      // 25: athrow
      // 26: ldc ""
      // 28: areturn
      // 29: athrow
      // 2a: aload 0
      // 2b: ldc "version"
      // 2d: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 30: lload 3
      // 31: dup2_x1
      // 32: pop2
      // 33: invokestatic x/U.ŗ (JLcom/google/gson/JsonElement;)Ljava/lang/String;
      // 36: astore 6
      // 38: aload 6
      // 3a: iload 5
      // 3c: ifne 59
      // 3f: invokevirtual java/lang/String.isEmpty ()Z
      // 42: ifeq 5c
      // 45: goto 49
      // 48: athrow
      // 49: aload 0
      // 4a: ldc "clientVersion"
      // 4c: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 4f: lload 3
      // 50: dup2_x1
      // 51: pop2
      // 52: invokestatic x/U.ŗ (JLcom/google/gson/JsonElement;)Ljava/lang/String;
      // 55: goto 59
      // 58: athrow
      // 59: goto 5e
      // 5c: aload 6
      // 5e: areturn
   }

   static boolean ʖ(JsonObject var0) {
      return Ժ(Ѕ(var0), "2.5");
   }

   static boolean Ժ(String var0, String var1) {
      int var10000 = oc151419fdfe.v;
      oc979e0e9083 var3 = oc979e0e9083.ո(var0);
      boolean var2 = (boolean)var10000;
      oc979e0e9083 var4 = oc979e0e9083.ո(var1);

      label47: {
         try {
            var8 = var3;
            if (var2) {
               break label47;
            }

            if (var3 == null) {
               return (boolean)0;
            }
         } catch (ocbde1165e4e var7) {
            throw var7;
         }

         var8 = var4;
      }

      label41: {
         try {
            if (var2) {
               break label41;
            }

            if (var8 == null) {
               return (boolean)0;
            }
         } catch (ocbde1165e4e var6) {
            throw var6;
         }

         var8 = var3;
      }

      try {
         var10000 = var8.ƞ(var4);
         if (var2) {
            return (boolean)var10000;
         }

         if (var10000 < 0) {
            return (boolean)1;
         }
      } catch (ocbde1165e4e var5) {
         throw var5;
      }

      return (boolean)0;
   }

   private static String ŗ(long param0, JsonElement param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc151419fdfe.v Z
      // 03: istore 3
      // 04: aload 2
      // 05: lload 0
      // 06: lconst_0
      // 07: lcmp
      // 08: ifle 17
      // 0b: iload 3
      // 0c: ifne 17
      // 0f: ifnull 25
      // 12: goto 16
      // 15: athrow
      // 16: aload 2
      // 17: iload 3
      // 18: ifne 2a
      // 1b: invokevirtual com/google/gson/JsonElement.isJsonPrimitive ()Z
      // 1e: ifne 29
      // 21: goto 25
      // 24: athrow
      // 25: ldc ""
      // 27: areturn
      // 28: athrow
      // 29: aload 2
      // 2a: invokevirtual com/google/gson/JsonElement.getAsString ()Ljava/lang/String;
      // 2d: astore 4
      // 2f: aload 4
      // 31: iload 3
      // 32: ifne 44
      // 35: ifnonnull 42
      // 38: goto 3c
      // 3b: athrow
      // 3c: ldc ""
      // 3e: goto 47
      // 41: athrow
      // 42: aload 4
      // 44: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 47: areturn
      // 48: astore 4
      // 4a: ldc ""
      // 4c: areturn
   }
}
