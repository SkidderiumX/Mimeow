package x;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ocd77007f9e2 {
   private final occc831eff22 ѥ = new occc831eff22("Overlay settings");
   private final occ2f8dff8d8 Í;
   private final occ2f8dff8d8 Ð;
   private final occ2f8dff8d8 Կ;
   private final occ2f8dff8d8 ж;
   private final occ2f8dff8d8 З;
   private final oca9cc61aada ǝ;
   private final oca9cc61aada ԟ;
   private final oca9cc61aada җ;
   private final oca9cc61aada Ӈ;
   private final oc24a0a5bddf Ͻ;
   private final oc24a0a5bddf г;
   private final occ2f8dff8d8 Ě;
   private final occ2f8dff8d8 ǯ;
   private final occ2f8dff8d8 չ;
   private final ocd2958dac48 Ō;
   private final Map<String, N> ր = new LinkedHashMap<>();
   private final List<oc3c294619e4> ǳ = new ArrayList<>();
   private boolean ӽ;
   private boolean ȟ;
   private int ư;
   private double ӵ;
   public static int Δ;

   public ocd77007f9e2(ocd2958dac48 var1) {
      this.Ō = var1;
      var1.ϩ(this.ѥ, "group");
      this.X("show_combat", this.Í = new occ2f8dff8d8("Combat", true));
      this.X("show_move", this.Ð = new occ2f8dff8d8("Move", true));
      this.X("show_block", this.Կ = new occ2f8dff8d8("Block", true));
      this.X("show_visual", this.ж = new occ2f8dff8d8("Visual", true));
      this.X("show_utility", this.З = new occ2f8dff8d8("Utility", true));
      this.X("text_size", this.ǝ = new oca9cc61aada("Text size", 16.0, 10.0, 24.0, 0.1));
      this.X("padding_x", this.ԟ = new oca9cc61aada("Padding X", 3.0, 0.0, 5.0, 0.1));
      this.X("padding_y", this.җ = new oca9cc61aada("Padding Y", 1.0, 0.0, 5.0, 0.1));
      this.X("bg_rounding", this.Ӈ = new oca9cc61aada("Rounding", 6.0, 0.0, 16.0, 0.1));
      this.X("name_color", this.Ͻ = new oc24a0a5bddf("Name color", -1788997643 ^ -1788997882, -1788997797 ^ -1788997882, -1788997868 ^ -1788997882));
      this.X("details_color", this.г = new oc24a0a5bddf("Details color", -1788997729 ^ -1788997882, -1788997729 ^ -1788997882, -1788997729 ^ -1788997882));
      this.X("lowercase", this.Ě = new occ2f8dff8d8("Lowercase", true));
      this.X("show_details", this.ǯ = new occ2f8dff8d8("Show details", true));
      this.X("require_bound", this.չ = new occ2f8dff8d8("Only bound modules", false));
   }

   private void X(String var1, N var2) {
      this.ր.put(var1, var2);
      oc93499ec6de.Ҭ(var2, this.ѥ);
      this.Ō.ϩ(var2, var1);
   }

   public void Ӗ(boolean var1) {
      boolean var10000 = oce6044968f8.ђ;
      this.ѥ.ȉ(var1, this.Ō);
      Iterator var3 = this.ր.values().iterator();
      boolean var2 = var10000;

      while (true) {
         if (var3.hasNext()) {
            N var4 = (N)var3.next();

            try {
               if (var2) {
                  break;
               }

               var4.ȉ(var1, this.Ō);
               if (!var2) {
                  continue;
               }
            } catch (ocbde1165e4e var5) {
               throw var5;
            }
         }

         this.Ž();
         break;
      }
   }

   public void Ҹ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: invokestatic net/minecraft/client/Minecraft.getMinecraft ()Lnet/minecraft/client/Minecraft;
      // 06: astore 2
      // 07: istore 1
      // 08: invokestatic x/ocd94f97a9f3.Ĩ ()D
      // 0b: dstore 3
      // 0c: aload 0
      // 0d: getfield x/ocd77007f9e2.ӵ D
      // 10: iload 1
      // 11: ifne 28
      // 14: dconst_0
      // 15: dcmpl
      // 16: ifne 22
      // 19: goto 1d
      // 1c: athrow
      // 1d: fconst_0
      // 1e: goto 29
      // 21: athrow
      // 22: dload 3
      // 23: aload 0
      // 24: getfield x/ocd77007f9e2.ӵ D
      // 27: dsub
      // 28: d2f
      // 29: fstore 5
      // 2b: aload 0
      // 2c: dload 3
      // 2d: putfield x/ocd77007f9e2.ӵ D
      // 30: aload 0
      // 31: invokevirtual x/ocd77007f9e2.Ӱ ()V
      // 34: aload 0
      // 35: aload 2
      // 36: getfield net/minecraft/client/Minecraft.displayWidth I
      // 39: i2f
      // 3a: fload 5
      // 3c: invokevirtual x/ocd77007f9e2.Ҷ (FF)Lx/ocac488f5520;
      // 3f: astore 6
      // 41: ldc_w -768158819
      // 44: ldc_w -768157635
      // 47: ixor
      // 48: invokestatic org/lwjgl/opengl/GL11.glGetInteger (I)I
      // 4b: istore 7
      // 4d: ldc_w -768159940
      // 50: ldc_w -768157635
      // 53: ixor
      // 54: invokestatic org/lwjgl/opengl/GL11.glMatrixMode (I)V
      // 57: invokestatic org/lwjgl/opengl/GL11.glPushMatrix ()V
      // 5a: invokestatic org/lwjgl/opengl/GL11.glLoadIdentity ()V
      // 5d: dconst_0
      // 5e: aload 2
      // 5f: getfield net/minecraft/client/Minecraft.displayWidth I
      // 62: i2d
      // 63: aload 2
      // 64: getfield net/minecraft/client/Minecraft.displayHeight I
      // 67: i2d
      // 68: dconst_0
      // 69: ldc2_w -3000.0
      // 6c: ldc2_w 3000.0
      // 6f: invokestatic org/lwjgl/opengl/GL11.glOrtho (DDDDDD)V
      // 72: ldc_w -768159939
      // 75: ldc_w -768157635
      // 78: ixor
      // 79: invokestatic org/lwjgl/opengl/GL11.glMatrixMode (I)V
      // 7c: invokestatic org/lwjgl/opengl/GL11.glPushMatrix ()V
      // 7f: invokestatic org/lwjgl/opengl/GL11.glLoadIdentity ()V
      // 82: aload 6
      // 84: invokestatic x/ocd94f97a9f3.ϋ (Lx/ocac488f5520;)V
      // 87: invokestatic org/lwjgl/opengl/GL11.glPopMatrix ()V
      // 8a: ldc_w -768159940
      // 8d: ldc_w -768157635
      // 90: ixor
      // 91: invokestatic org/lwjgl/opengl/GL11.glMatrixMode (I)V
      // 94: invokestatic org/lwjgl/opengl/GL11.glPopMatrix ()V
      // 97: iload 7
      // 99: invokestatic org/lwjgl/opengl/GL11.glMatrixMode (I)V
      // 9c: goto b9
      // 9f: astore 8
      // a1: invokestatic org/lwjgl/opengl/GL11.glPopMatrix ()V
      // a4: ldc_w -768159940
      // a7: ldc_w -768157635
      // aa: ixor
      // ab: invokestatic org/lwjgl/opengl/GL11.glMatrixMode (I)V
      // ae: invokestatic org/lwjgl/opengl/GL11.glPopMatrix ()V
      // b1: iload 7
      // b3: invokestatic org/lwjgl/opengl/GL11.glMatrixMode (I)V
      // b6: aload 8
      // b8: athrow
      // b9: return
   }

   private boolean Ɂ(oc69da1aa7f5 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: istore 2
      // 04: getstatic x/oc463df83122.Ǳ [I
      // 07: aload 1
      // 08: invokevirtual x/oc69da1aa7f5.ъ ()Lx/oce4cea752dd;
      // 0b: invokevirtual java/lang/Enum.ordinal ()I
      // 0e: iaload
      // 0f: iload 2
      // 10: ifne 5f
      // 13: tableswitch 75 1 5 34 43 51 59 67
      // 34: athrow
      // 35: aload 0
      // 36: getfield x/ocd77007f9e2.Í Lx/occ2f8dff8d8;
      // 39: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 3c: ireturn
      // 3d: athrow
      // 3e: aload 0
      // 3f: getfield x/ocd77007f9e2.Ð Lx/occ2f8dff8d8;
      // 42: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 45: ireturn
      // 46: aload 0
      // 47: getfield x/ocd77007f9e2.ж Lx/occ2f8dff8d8;
      // 4a: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 4d: ireturn
      // 4e: aload 0
      // 4f: getfield x/ocd77007f9e2.Կ Lx/occ2f8dff8d8;
      // 52: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 55: ireturn
      // 56: aload 0
      // 57: getfield x/ocd77007f9e2.З Lx/occ2f8dff8d8;
      // 5a: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 5d: ireturn
      // 5e: bipush 1
      // 5f: ireturn
   }

   private boolean Ȃ(oc69da1aa7f5 param1, boolean param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: istore 3
      // 04: iload 2
      // 05: iload 3
      // 06: ifne 2b
      // 09: ifeq 23
      // 0c: goto 10
      // 0f: athrow
      // 10: aload 1
      // 11: iload 3
      // 12: ifne 28
      // 15: goto 19
      // 18: athrow
      // 19: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 1c: ifeq 73
      // 1f: goto 23
      // 22: athrow
      // 23: aload 1
      // 24: goto 28
      // 27: athrow
      // 28: invokevirtual x/oc69da1aa7f5.լ ()Z
      // 2b: iload 3
      // 2c: ifne 49
      // 2f: ifne 73
      // 32: goto 36
      // 35: athrow
      // 36: aload 0
      // 37: iload 3
      // 38: ifne 60
      // 3b: goto 3f
      // 3e: athrow
      // 3f: getfield x/ocd77007f9e2.չ Lx/occ2f8dff8d8;
      // 42: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 45: goto 49
      // 48: athrow
      // 49: ifeq 5f
      // 4c: aload 1
      // 4d: invokevirtual x/oc69da1aa7f5.ɽ ()I
      // 50: iload 3
      // 51: ifne 64
      // 54: goto 58
      // 57: athrow
      // 58: ifeq 73
      // 5b: goto 5f
      // 5e: athrow
      // 5f: aload 0
      // 60: aload 1
      // 61: invokevirtual x/ocd77007f9e2.Ɂ (Lx/oc69da1aa7f5;)Z
      // 64: iload 3
      // 65: ifne 70
      // 68: ifeq 73
      // 6b: goto 6f
      // 6e: athrow
      // 6f: bipush 1
      // 70: goto 74
      // 73: bipush 0
      // 74: ireturn
   }

   private void º(oc3c294619e4 var1) {
      boolean var2 = oce6044968f8.ђ;

      oc3c294619e4 var10000;
      String var10001;
      label60: {
         try {
            var10000 = var1;
            if (this.Ě.ǭ()) {
               var10001 = Ȧ(var1.Ә.z$3i8m9vxwuvqj0());
               break label60;
            }
         } catch (ocbde1165e4e var7) {
            throw var7;
         }

         var10001 = var1.Ә.z$3i8m9vxwuvqj0();
      }

      label53: {
         try {
            var10000.Ǳ = ʩ(var10001, -2065343463 ^ -2065343478);
            if (this.ǯ.ǭ()) {
               var8 = var1.Ә.getInfo();
               break label53;
            }
         } catch (ocbde1165e4e var6) {
            throw var6;
         }

         var8 = null;
      }

      String var3 = var8;

      label45: {
         label64: {
            try {
               var10000 = var1;
               var10001 = var3;
               if (var2) {
                  break label45;
               }

               if (var3 == null) {
                  break label64;
               }
            } catch (ocbde1165e4e var5) {
               throw var5;
            }

            label36: {
               try {
                  if (this.Ě.ǭ()) {
                     var10001 = Ȧ(var3);
                     break label36;
                  }
               } catch (ocbde1165e4e var4) {
                  throw var4;
               }

               var10001 = var3;
            }

            var10001 = ʩ(var10001, -2065343467 ^ -2065343478);
            break label45;
         }

         var10001 = "";
      }

      var10000.Ņ = var10001;
   }

   private static String ʩ(String var0, int var1) {
      byte[] var2 = var0.getBytes(StandardCharsets.UTF_8);

      try {
         if (var2.length <= var1) {
            return var0;
         }
      } catch (ocbde1165e4e var3) {
         throw var3;
      }

      return new String(var2, 0, var1, StandardCharsets.UTF_8);
   }

   private static String Ȧ(String param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: new java/lang/StringBuilder
      // 06: dup
      // 07: aload 0
      // 08: invokevirtual java/lang/String.length ()I
      // 0b: invokespecial java/lang/StringBuilder.<init> (I)V
      // 0e: astore 2
      // 0f: bipush 0
      // 10: istore 3
      // 11: istore 1
      // 12: iload 3
      // 13: aload 0
      // 14: invokevirtual java/lang/String.length ()I
      // 17: if_icmpge 71
      // 1a: aload 0
      // 1b: iload 1
      // 1c: ifne 75
      // 1f: iload 3
      // 20: invokevirtual java/lang/String.charAt (I)C
      // 23: istore 4
      // 25: aload 2
      // 26: iload 4
      // 28: iload 1
      // 29: ifne 40
      // 2c: ldc_w -611472819
      // 2f: ldc_w -611472884
      // 32: ixor
      // 33: if_icmplt 64
      // 36: goto 3a
      // 39: athrow
      // 3a: iload 4
      // 3c: goto 40
      // 3f: athrow
      // 40: iload 1
      // 41: ifne 61
      // 44: ldc_w -611472810
      // 47: ldc_w -611472884
      // 4a: ixor
      // 4b: if_icmpgt 64
      // 4e: goto 52
      // 51: athrow
      // 52: iload 4
      // 54: ldc_w -611472852
      // 57: ldc_w -611472884
      // 5a: ixor
      // 5b: iadd
      // 5c: i2c
      // 5d: goto 61
      // 60: athrow
      // 61: goto 66
      // 64: iload 4
      // 66: invokevirtual java/lang/StringBuilder.append (C)Ljava/lang/StringBuilder;
      // 69: pop
      // 6a: iload 1
      // 6b: iinc 3 1
      // 6e: ifeq 12
      // 71: aload 2
      // 72: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 75: areturn
   }

   private void ճ(oc69da1aa7f5 var1) {
      oc3c294619e4 var2 = new oc3c294619e4(var1);
      this.º(var2);
      this.ǳ.add(var2);
   }

   public void Ȓ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: aload 0
      // 04: getfield x/ocd77007f9e2.ǳ Ljava/util/List;
      // 07: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 0c: astore 2
      // 0d: istore 1
      // 0e: aload 2
      // 0f: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 14: ifeq 3e
      // 17: aload 2
      // 18: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 1d: iload 1
      // 1e: ifne 56
      // 21: checkcast x/oc3c294619e4
      // 24: astore 3
      // 25: aload 0
      // 26: aload 3
      // 27: getfield x/oc3c294619e4.Ә Lx/oc69da1aa7f5;
      // 2a: bipush 0
      // 2b: invokevirtual x/ocd77007f9e2.Ȃ (Lx/oc69da1aa7f5;Z)Z
      // 2e: ifne 3a
      // 31: aload 3
      // 32: bipush 0
      // 33: putfield x/oc3c294619e4.ƚ Z
      // 36: goto 3a
      // 39: athrow
      // 3a: iload 1
      // 3b: ifeq 0e
      // 3e: getstatic x/oc9755810e45.Ŕ Ljava/util/List;
      // 41: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 46: astore 2
      // 47: aload 2
      // 48: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 4d: ifeq d6
      // 50: aload 2
      // 51: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 56: checkcast x/oc69da1aa7f5
      // 59: astore 3
      // 5a: iload 1
      // 5b: ifne db
      // 5e: aload 0
      // 5f: aload 3
      // 60: bipush 1
      // 61: invokevirtual x/ocd77007f9e2.Ȃ (Lx/oc69da1aa7f5;Z)Z
      // 64: ifeq d2
      // 67: aconst_null
      // 68: astore 4
      // 6a: aload 0
      // 6b: getfield x/ocd77007f9e2.ǳ Ljava/util/List;
      // 6e: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 73: astore 5
      // 75: aload 5
      // 77: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 7c: ifeq b2
      // 7f: aload 5
      // 81: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 86: checkcast x/oc3c294619e4
      // 89: iload 1
      // 8a: ifne 56
      // 8d: goto 91
      // 90: athrow
      // 91: astore 6
      // 93: aload 6
      // 95: iload 1
      // 96: ifne aa
      // 99: getfield x/oc3c294619e4.Ә Lx/oc69da1aa7f5;
      // 9c: aload 3
      // 9d: if_acmpne af
      // a0: goto a4
      // a3: athrow
      // a4: aload 6
      // a6: goto aa
      // a9: athrow
      // aa: astore 4
      // ac: goto b2
      // af: goto 75
      // b2: aload 4
      // b4: iload 1
      // b5: ifne c1
      // b8: ifnull c9
      // bb: goto bf
      // be: athrow
      // bf: aload 4
      // c1: bipush 1
      // c2: putfield x/oc3c294619e4.ƚ Z
      // c5: iload 1
      // c6: ifeq d2
      // c9: aload 0
      // ca: aload 3
      // cb: invokevirtual x/ocd77007f9e2.ճ (Lx/oc69da1aa7f5;)V
      // ce: goto d2
      // d1: athrow
      // d2: iload 1
      // d3: ifeq 47
      // d6: aload 0
      // d7: bipush 1
      // d8: putfield x/ocd77007f9e2.ȟ Z
      // db: return
   }

   public void ԅ(oc69da1aa7f5 param1, boolean param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 000: getstatic x/oce6044968f8.ђ Z
      // 003: istore 3
      // 004: aload 1
      // 005: aload 0
      // 006: getfield x/ocd77007f9e2.Ō Lx/ocd2958dac48;
      // 009: if_acmpeq 0ab
      // 00c: aload 0
      // 00d: getfield x/ocd77007f9e2.ǳ Ljava/util/List;
      // 010: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 015: astore 4
      // 017: aload 4
      // 019: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 01e: ifeq 078
      // 021: aload 4
      // 023: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 028: checkcast x/oc3c294619e4
      // 02b: astore 5
      // 02d: iload 3
      // 02e: ifne 115
      // 031: aload 5
      // 033: getfield x/oc3c294619e4.Ә Lx/oc69da1aa7f5;
      // 036: aload 1
      // 037: if_acmpne 074
      // 03a: goto 03e
      // 03d: athrow
      // 03e: iload 2
      // 03f: iload 3
      // 040: ifne 066
      // 043: goto 047
      // 046: athrow
      // 047: ifne 05c
      // 04a: goto 04e
      // 04d: athrow
      // 04e: aload 5
      // 050: bipush 0
      // 051: putfield x/oc3c294619e4.ƚ Z
      // 054: iload 3
      // 055: ifeq 073
      // 058: goto 05c
      // 05b: athrow
      // 05c: aload 0
      // 05d: aload 1
      // 05e: bipush 0
      // 05f: invokevirtual x/ocd77007f9e2.Ȃ (Lx/oc69da1aa7f5;Z)Z
      // 062: goto 066
      // 065: athrow
      // 066: ifeq 073
      // 069: aload 5
      // 06b: bipush 1
      // 06c: putfield x/oc3c294619e4.ƚ Z
      // 06f: goto 073
      // 072: athrow
      // 073: return
      // 074: iload 3
      // 075: ifeq 017
      // 078: iload 2
      // 079: iload 3
      // 07a: ifne 096
      // 07d: ifeq 115
      // 080: goto 084
      // 083: athrow
      // 084: aload 0
      // 085: iload 3
      // 086: ifne 0a3
      // 089: goto 08d
      // 08c: athrow
      // 08d: aload 1
      // 08e: bipush 1
      // 08f: invokevirtual x/ocd77007f9e2.Ȃ (Lx/oc69da1aa7f5;Z)Z
      // 092: goto 096
      // 095: athrow
      // 096: ifeq 115
      // 099: aload 0
      // 09a: aload 1
      // 09b: invokevirtual x/ocd77007f9e2.ճ (Lx/oc69da1aa7f5;)V
      // 09e: aload 0
      // 09f: goto 0a3
      // 0a2: athrow
      // 0a3: bipush 1
      // 0a4: putfield x/ocd77007f9e2.ȟ Z
      // 0a7: iload 3
      // 0a8: ifeq 115
      // 0ab: aload 0
      // 0ac: getfield x/ocd77007f9e2.ǳ Ljava/util/List;
      // 0af: iload 3
      // 0b0: ifne 0cb
      // 0b3: goto 0b7
      // 0b6: athrow
      // 0b7: invokeinterface java/util/List.clear ()V 1
      // 0bc: iload 2
      // 0bd: ifeq 115
      // 0c0: goto 0c4
      // 0c3: athrow
      // 0c4: getstatic x/oc9755810e45.Ŕ Ljava/util/List;
      // 0c7: goto 0cb
      // 0ca: athrow
      // 0cb: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 0d0: astore 4
      // 0d2: aload 4
      // 0d4: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 0d9: ifeq 110
      // 0dc: aload 4
      // 0de: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 0e3: checkcast x/oc69da1aa7f5
      // 0e6: astore 5
      // 0e8: iload 3
      // 0e9: ifne 115
      // 0ec: aload 0
      // 0ed: iload 3
      // 0ee: ifne 107
      // 0f1: goto 0f5
      // 0f4: athrow
      // 0f5: aload 5
      // 0f7: bipush 1
      // 0f8: invokevirtual x/ocd77007f9e2.Ȃ (Lx/oc69da1aa7f5;Z)Z
      // 0fb: ifeq 10c
      // 0fe: goto 102
      // 101: athrow
      // 102: aload 0
      // 103: goto 107
      // 106: athrow
      // 107: aload 5
      // 109: invokevirtual x/ocd77007f9e2.ճ (Lx/oc69da1aa7f5;)V
      // 10c: iload 3
      // 10d: ifeq 0d2
      // 110: aload 0
      // 111: bipush 1
      // 112: putfield x/ocd77007f9e2.ȟ Z
      // 115: return
   }

   public void Ӱ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oce6044968f8.ђ Z
      // 003: istore 1
      // 004: aload 0
      // 005: getfield x/ocd77007f9e2.Í Lx/occ2f8dff8d8;
      // 008: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 00b: iload 1
      // 00c: ifne 017
      // 00f: ifeq 01a
      // 012: goto 016
      // 015: athrow
      // 016: bipush 1
      // 017: goto 01b
      // 01a: bipush 0
      // 01b: aload 0
      // 01c: getfield x/ocd77007f9e2.Ð Lx/occ2f8dff8d8;
      // 01f: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 022: iload 1
      // 023: ifne 034
      // 026: ifeq 037
      // 029: goto 02d
      // 02c: athrow
      // 02d: ldc_w 1574443944
      // 030: ldc_w 1574443946
      // 033: ixor
      // 034: goto 038
      // 037: bipush 0
      // 038: iadd
      // 039: aload 0
      // 03a: getfield x/ocd77007f9e2.Կ Lx/occ2f8dff8d8;
      // 03d: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 040: iload 1
      // 041: ifne 052
      // 044: ifeq 055
      // 047: goto 04b
      // 04a: athrow
      // 04b: ldc_w 1574443950
      // 04e: ldc_w 1574443946
      // 051: ixor
      // 052: goto 056
      // 055: bipush 0
      // 056: iadd
      // 057: aload 0
      // 058: getfield x/ocd77007f9e2.ж Lx/occ2f8dff8d8;
      // 05b: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 05e: iload 1
      // 05f: ifne 070
      // 062: ifeq 073
      // 065: goto 069
      // 068: athrow
      // 069: ldc_w 1574443938
      // 06c: ldc_w 1574443946
      // 06f: ixor
      // 070: goto 074
      // 073: bipush 0
      // 074: iadd
      // 075: istore 2
      // 076: iload 2
      // 077: aload 0
      // 078: getfield x/ocd77007f9e2.З Lx/occ2f8dff8d8;
      // 07b: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 07e: iload 1
      // 07f: ifne 090
      // 082: ifeq 093
      // 085: goto 089
      // 088: athrow
      // 089: ldc_w 1574443962
      // 08c: ldc_w 1574443946
      // 08f: ixor
      // 090: goto 094
      // 093: bipush 0
      // 094: aload 0
      // 095: getfield x/ocd77007f9e2.չ Lx/occ2f8dff8d8;
      // 098: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 09b: iload 1
      // 09c: ifne 0ad
      // 09f: ifeq 0b0
      // 0a2: goto 0a6
      // 0a5: athrow
      // 0a6: ldc_w 1574443914
      // 0a9: ldc_w 1574443946
      // 0ac: ixor
      // 0ad: goto 0b1
      // 0b0: bipush 0
      // 0b1: ior
      // 0b2: ior
      // 0b3: istore 2
      // 0b4: iload 1
      // 0b5: aload 0
      // 0b6: getfield x/ocd77007f9e2.ӽ Z
      // 0b9: istore 3
      // 0ba: ifne 0e6
      // 0bd: aload 0
      // 0be: getfield x/ocd77007f9e2.ư I
      // 0c1: iload 2
      // 0c2: if_icmpne 0d9
      // 0c5: goto 0c9
      // 0c8: athrow
      // 0c9: iload 3
      // 0ca: iload 1
      // 0cb: ifne 0ec
      // 0ce: goto 0d2
      // 0d1: athrow
      // 0d2: ifeq 0eb
      // 0d5: goto 0d9
      // 0d8: athrow
      // 0d9: aload 0
      // 0da: invokevirtual x/ocd77007f9e2.Ȓ ()V
      // 0dd: aload 0
      // 0de: iload 2
      // 0df: putfield x/ocd77007f9e2.ư I
      // 0e2: goto 0e6
      // 0e5: athrow
      // 0e6: aload 0
      // 0e7: bipush 0
      // 0e8: putfield x/ocd77007f9e2.ӽ Z
      // 0eb: iload 3
      // 0ec: iload 1
      // 0ed: ifne 0fa
      // 0f0: ifne 0fd
      // 0f3: goto 0f7
      // 0f6: athrow
      // 0f7: invokestatic x/oc2922be51da.Ѽ ()Z
      // 0fa: ifne 135
      // 0fd: aload 0
      // 0fe: getfield x/ocd77007f9e2.ǳ Ljava/util/List;
      // 101: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 106: astore 4
      // 108: aload 4
      // 10a: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 10f: ifeq 130
      // 112: aload 4
      // 114: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 119: checkcast x/oc3c294619e4
      // 11c: astore 5
      // 11e: aload 0
      // 11f: iload 1
      // 120: ifne 131
      // 123: aload 5
      // 125: invokevirtual x/ocd77007f9e2.º (Lx/oc3c294619e4;)V
      // 128: iload 1
      // 129: ifeq 108
      // 12c: goto 130
      // 12f: athrow
      // 130: aload 0
      // 131: bipush 1
      // 132: putfield x/ocd77007f9e2.ȟ Z
      // 135: return
   }

   public void Ž() {
      this.ӽ = true;
   }

   public ocac488f5520 Ҷ(float var1, float var2) {
      boolean var10000 = oce6044968f8.ђ;
      oc6b92d7f083 var4 = oc1e7298eef6.ҩ();
      boolean var3 = var10000;

      ocac488f5520 var5;
      try {
         var5 = this.Ѡ(var1, var2);
      } catch (Throwable var9) {
         try {
            if (var3 || var4 == null) {
               throw var9;
            }
         } catch (Throwable var8) {
            throw var8;
         }

         try {
            var4.close();
         } catch (Throwable var7) {
            var9.addSuppressed(var7);
         }

         throw var9;
      }

      label44: {
         try {
            var11 = var4;
            if (var3) {
               break label44;
            }

            if (var4 == null) {
               return var5;
            }
         } catch (Throwable var10) {
            throw var10;
         }

         var11 = var4;
      }

      var11.close();
      return var5;
   }

   private ocac488f5520 Ѡ(float param1, float param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: aload 0
      // 001: getfield x/ocd77007f9e2.ǝ Lx/oca9cc61aada;
      // 004: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 007: d2f
      // 008: fstore 4
      // 00a: ldc2_w 5.0
      // 00d: dstore 5
      // 00f: getstatic x/oce6044968f8.ђ Z
      // 012: fload 2
      // 013: f2d
      // 014: dload 5
      // 016: dmul
      // 017: dstore 7
      // 019: fload 2
      // 01a: f2d
      // 01b: dneg
      // 01c: dload 5
      // 01e: dmul
      // 01f: dstore 9
      // 021: istore 3
      // 022: fconst_1
      // 023: fstore 11
      // 025: bipush 0
      // 026: istore 12
      // 028: iload 12
      // 02a: aload 0
      // 02b: getfield x/ocd77007f9e2.ǳ Ljava/util/List;
      // 02e: invokeinterface java/util/List.size ()I 1
      // 033: if_icmpge 0c1
      // 036: aload 0
      // 037: getfield x/ocd77007f9e2.ǳ Ljava/util/List;
      // 03a: iload 12
      // 03c: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 041: checkcast x/oc3c294619e4
      // 044: astore 13
      // 046: iload 3
      // 047: ifne 0a0
      // 04a: aload 13
      // 04c: getfield x/oc3c294619e4.ƚ Z
      // 04f: ifeq 089
      // 052: goto 056
      // 055: athrow
      // 056: aload 13
      // 058: iload 3
      // 059: ifne 073
      // 05c: goto 060
      // 05f: athrow
      // 060: getfield x/oc3c294619e4.Ƿ F
      // 063: fload 11
      // 065: fcmpl
      // 066: ifeq 0ba
      // 069: goto 06d
      // 06c: athrow
      // 06d: aload 13
      // 06f: goto 073
      // 072: athrow
      // 073: fload 11
      // 075: aload 13
      // 077: getfield x/oc3c294619e4.Ƿ F
      // 07a: f2d
      // 07b: dload 7
      // 07d: dadd
      // 07e: d2f
      // 07f: invokestatic java/lang/Math.min (FF)F
      // 082: putfield x/oc3c294619e4.Ƿ F
      // 085: iload 3
      // 086: ifeq 0ba
      // 089: aload 13
      // 08b: aload 13
      // 08d: getfield x/oc3c294619e4.Ƿ F
      // 090: f2d
      // 091: dload 9
      // 093: dadd
      // 094: d2f
      // 095: putfield x/oc3c294619e4.Ƿ F
      // 098: iload 3
      // 099: ifne 0bd
      // 09c: goto 0a0
      // 09f: athrow
      // 0a0: aload 13
      // 0a2: getfield x/oc3c294619e4.Ƿ F
      // 0a5: fconst_0
      // 0a6: fcmpl
      // 0a7: ifgt 0ba
      // 0aa: aload 0
      // 0ab: getfield x/ocd77007f9e2.ǳ Ljava/util/List;
      // 0ae: iload 12
      // 0b0: invokeinterface java/util/List.remove (I)Ljava/lang/Object; 2
      // 0b5: pop
      // 0b6: goto 0ba
      // 0b9: athrow
      // 0ba: iinc 12 1
      // 0bd: iload 3
      // 0be: ifeq 028
      // 0c1: ldc_w 4.0
      // 0c4: fstore 12
      // 0c6: aload 0
      // 0c7: iload 3
      // 0c8: ifne 0da
      // 0cb: getfield x/ocd77007f9e2.ȟ Z
      // 0ce: ifeq 19b
      // 0d1: goto 0d5
      // 0d4: athrow
      // 0d5: aload 0
      // 0d6: goto 0da
      // 0d9: athrow
      // 0da: getfield x/ocd77007f9e2.ǳ Ljava/util/List;
      // 0dd: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 0e2: astore 13
      // 0e4: aload 13
      // 0e6: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 0eb: ifeq 18a
      // 0ee: aload 13
      // 0f0: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 0f5: checkcast x/oc3c294619e4
      // 0f8: astore 14
      // 0fa: ldc_w -2095522822
      // 0fd: ldc_w -2095522818
      // 100: ixor
      // 101: newarray 6
      // 103: astore 15
      // 105: aload 14
      // 107: getfield x/oc3c294619e4.Ǳ Ljava/lang/String;
      // 10a: fconst_0
      // 10b: fconst_0
      // 10c: fload 4
      // 10e: ldc_w -2095522825
      // 111: ldc_w -2095522818
      // 114: ixor
      // 115: aload 15
      // 117: invokestatic x/oc1e7298eef6.թ (Ljava/lang/String;FFFI[F)F
      // 11a: iload 3
      // 11b: ifne 19c
      // 11e: pop
      // 11f: aload 14
      // 121: aload 15
      // 123: ldc_w -2095522820
      // 126: ldc_w -2095522818
      // 129: ixor
      // 12a: faload
      // 12b: putfield x/oc3c294619e4.Ș F
      // 12e: aload 14
      // 130: iload 3
      // 131: ifne 170
      // 134: goto 138
      // 137: athrow
      // 138: aload 15
      // 13a: ldc_w -2095522819
      // 13d: ldc_w -2095522818
      // 140: ixor
      // 141: faload
      // 142: putfield x/oc3c294619e4.ό F
      // 145: aload 14
      // 147: getfield x/oc3c294619e4.Ņ Ljava/lang/String;
      // 14a: invokevirtual java/lang/String.isEmpty ()Z
      // 14d: ifne 186
      // 150: goto 154
      // 153: athrow
      // 154: aload 14
      // 156: getfield x/oc3c294619e4.Ņ Ljava/lang/String;
      // 159: fconst_0
      // 15a: fconst_0
      // 15b: fload 4
      // 15d: ldc_w -2095522825
      // 160: ldc_w -2095522818
      // 163: ixor
      // 164: aload 15
      // 166: invokestatic x/oc1e7298eef6.թ (Ljava/lang/String;FFFI[F)F
      // 169: pop
      // 16a: aload 14
      // 16c: goto 170
      // 16f: athrow
      // 170: aload 15
      // 172: ldc_w -2095522820
      // 175: ldc_w -2095522818
      // 178: ixor
      // 179: faload
      // 17a: fload 12
      // 17c: fadd
      // 17d: aload 14
      // 17f: getfield x/oc3c294619e4.Ș F
      // 182: fadd
      // 183: putfield x/oc3c294619e4.Ș F
      // 186: iload 3
      // 187: ifeq 0e4
      // 18a: aload 0
      // 18b: getfield x/ocd77007f9e2.ǳ Ljava/util/List;
      // 18e: invokedynamic compare ()Ljava/util/Comparator; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;Ljava/lang/Object;)I, x/ocd77007f9e2.qu6cod4e9l7ir (Lx/oc3c294619e4;Lx/oc3c294619e4;)I, (Lx/oc3c294619e4;Lx/oc3c294619e4;)I ]
      // 193: invokestatic java/util/Collections.sort (Ljava/util/List;Ljava/util/Comparator;)V
      // 196: aload 0
      // 197: bipush 0
      // 198: putfield x/ocd77007f9e2.ȟ Z
      // 19b: fconst_0
      // 19c: fstore 13
      // 19e: new x/ocac488f5520
      // 1a1: dup
      // 1a2: invokespecial x/ocac488f5520.<init> ()V
      // 1a5: invokevirtual x/ocac488f5520.ƚ ()Lx/ocac488f5520;
      // 1a8: astore 14
      // 1aa: bipush 0
      // 1ab: istore 15
      // 1ad: iload 15
      // 1af: aload 0
      // 1b0: getfield x/ocd77007f9e2.ǳ Ljava/util/List;
      // 1b3: invokeinterface java/util/List.size ()I 1
      // 1b8: if_icmpge 348
      // 1bb: aload 0
      // 1bc: getfield x/ocd77007f9e2.ǳ Ljava/util/List;
      // 1bf: iload 15
      // 1c1: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 1c6: checkcast x/oc3c294619e4
      // 1c9: astore 16
      // 1cb: aload 16
      // 1cd: getfield x/oc3c294619e4.Ƿ F
      // 1d0: iload 3
      // 1d1: ifne 1f3
      // 1d4: fload 11
      // 1d6: fcmpl
      // 1d7: ifne 1e4
      // 1da: goto 1de
      // 1dd: athrow
      // 1de: fload 11
      // 1e0: goto 1ff
      // 1e3: athrow
      // 1e4: ldc_w 3.0
      // 1e7: aload 16
      // 1e9: getfield x/oc3c294619e4.Ƿ F
      // 1ec: aload 16
      // 1ee: getfield x/oc3c294619e4.Ƿ F
      // 1f1: fadd
      // 1f2: fsub
      // 1f3: aload 16
      // 1f5: getfield x/oc3c294619e4.Ƿ F
      // 1f8: aload 16
      // 1fa: getfield x/oc3c294619e4.Ƿ F
      // 1fd: fmul
      // 1fe: fmul
      // 1ff: fstore 17
      // 201: iload 3
      // 202: aload 0
      // 203: getfield x/ocd77007f9e2.Ӈ Lx/oca9cc61aada;
      // 206: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 209: d2f
      // 20a: fstore 18
      // 20c: ifne 24b
      // 20f: iload 15
      // 211: bipush 1
      // 212: iadd
      // 213: aload 0
      // 214: getfield x/ocd77007f9e2.ǳ Ljava/util/List;
      // 217: invokeinterface java/util/List.size ()I 1
      // 21c: if_icmpge 243
      // 21f: goto 223
      // 222: athrow
      // 223: aload 16
      // 225: getfield x/oc3c294619e4.Ș F
      // 228: aload 0
      // 229: getfield x/ocd77007f9e2.ǳ Ljava/util/List;
      // 22c: iload 15
      // 22e: bipush 1
      // 22f: iadd
      // 230: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 235: checkcast x/oc3c294619e4
      // 238: getfield x/oc3c294619e4.Ș F
      // 23b: fsub
      // 23c: fload 18
      // 23e: invokestatic java/lang/Math.min (FF)F
      // 241: fstore 18
      // 243: fconst_0
      // 244: fload 18
      // 246: invokestatic java/lang/Math.max (FF)F
      // 249: fstore 18
      // 24b: aload 0
      // 24c: getfield x/ocd77007f9e2.ԟ Lx/oca9cc61aada;
      // 24f: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 252: d2f
      // 253: fstore 19
      // 255: iload 3
      // 256: fload 19
      // 258: fload 19
      // 25a: fadd
      // 25b: fstore 20
      // 25d: aload 0
      // 25e: getfield x/ocd77007f9e2.җ Lx/oca9cc61aada;
      // 261: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 264: d2f
      // 265: fstore 21
      // 267: fload 1
      // 268: fload 20
      // 26a: fsub
      // 26b: aload 16
      // 26d: getfield x/oc3c294619e4.Ș F
      // 270: fload 17
      // 272: fmul
      // 273: fsub
      // 274: fstore 22
      // 276: fload 20
      // 278: aload 16
      // 27a: getfield x/oc3c294619e4.Ș F
      // 27d: fadd
      // 27e: fstore 23
      // 280: fload 21
      // 282: fload 21
      // 284: fadd
      // 285: aload 16
      // 287: getfield x/oc3c294619e4.ό F
      // 28a: fadd
      // 28b: fstore 24
      // 28d: aload 14
      // 28f: fconst_0
      // 290: fconst_0
      // 291: fconst_0
      // 292: ldc_w 0.7
      // 295: fload 17
      // 297: fmul
      // 298: invokevirtual x/ocac488f5520.Ą (FFFF)Lx/ocac488f5520;
      // 29b: fload 22
      // 29d: fload 13
      // 29f: fload 23
      // 2a1: fload 24
      // 2a3: fconst_0
      // 2a4: fconst_0
      // 2a5: fconst_0
      // 2a6: fload 18
      // 2a8: invokevirtual x/ocac488f5520.ν (FFFFFFFF)Lx/ocac488f5520;
      // 2ab: pop
      // 2ac: fload 21
      // 2ae: fload 13
      // 2b0: fadd
      // 2b1: fstore 25
      // 2b3: fload 1
      // 2b4: fload 19
      // 2b6: fsub
      // 2b7: aload 16
      // 2b9: getfield x/oc3c294619e4.Ș F
      // 2bc: fload 17
      // 2be: fmul
      // 2bf: fsub
      // 2c0: fstore 26
      // 2c2: aload 14
      // 2c4: aload 16
      // 2c6: getfield x/oc3c294619e4.Ǳ Ljava/lang/String;
      // 2c9: fload 26
      // 2cb: fload 25
      // 2cd: aload 0
      // 2ce: getfield x/ocd77007f9e2.Ͻ Lx/oc24a0a5bddf;
      // 2d1: invokevirtual x/oc24a0a5bddf.ͳ ()I
      // 2d4: fload 17
      // 2d6: invokestatic x/ocd77007f9e2.Đ (IF)I
      // 2d9: fload 4
      // 2db: ldc_w -2095522825
      // 2de: ldc_w -2095522818
      // 2e1: ixor
      // 2e2: invokevirtual x/ocac488f5520.ÿ (Ljava/lang/String;FFIFI)F
      // 2e5: fstore 27
      // 2e7: ifne 344
      // 2ea: aload 16
      // 2ec: getfield x/oc3c294619e4.Ņ Ljava/lang/String;
      // 2ef: invokevirtual java/lang/String.isEmpty ()Z
      // 2f2: ifne 324
      // 2f5: goto 2f9
      // 2f8: athrow
      // 2f9: aload 14
      // 2fb: aload 16
      // 2fd: getfield x/oc3c294619e4.Ņ Ljava/lang/String;
      // 300: fload 27
      // 302: fload 12
      // 304: fadd
      // 305: fload 25
      // 307: aload 0
      // 308: getfield x/ocd77007f9e2.г Lx/oc24a0a5bddf;
      // 30b: invokevirtual x/oc24a0a5bddf.ͳ ()I
      // 30e: fload 17
      // 310: invokestatic x/ocd77007f9e2.Đ (IF)I
      // 313: fload 4
      // 315: ldc_w -2095522825
      // 318: ldc_w -2095522818
      // 31b: ixor
      // 31c: invokevirtual x/ocac488f5520.ÿ (Ljava/lang/String;FFIFI)F
      // 31f: pop
      // 320: goto 324
      // 323: athrow
      // 324: aload 0
      // 325: getfield x/ocd77007f9e2.җ Lx/oca9cc61aada;
      // 328: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 32b: d2f
      // 32c: fstore 21
      // 32e: fload 13
      // 330: fload 17
      // 332: fload 21
      // 334: fload 21
      // 336: fadd
      // 337: aload 16
      // 339: getfield x/oc3c294619e4.ό F
      // 33c: fadd
      // 33d: fmul
      // 33e: fadd
      // 33f: fstore 13
      // 341: iinc 15 1
      // 344: iload 3
      // 345: ifeq 1ad
      // 348: aload 14
      // 34a: areturn
   }

   private static int Đ(int var0, float var1) {
      return (int)(var1 * 255.0F) << (-675319594 ^ -675319602) | var0 & (-683634895 ^ -675319602);
   }

   public List<oc3c294619e4> ô() {
      return Collections.unmodifiableList(this.ǳ);
   }

   public void ǆ() {
      this.ǳ.clear();
      this.ӽ = true;
      this.ӵ = 0.0;
   }
}
