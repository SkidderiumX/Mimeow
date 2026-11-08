package x;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.util.EnumChatFormatting;

public class oc446ce7e211 extends oc69da1aa7f5 {
   public static final String[] Ȝ;
   public static oca9cc61aada Ҋ;
   public static oca9cc61aada У;
   public static oca9cc61aada Ǎ;
   public static occ2f8dff8d8 ʯ;
   public static occ2f8dff8d8 ә;
   public static occ2f8dff8d8 ʕ;
   public static oca9cc61aada ӱ;
   public static oca9cc61aada ճ;
   public static occ2f8dff8d8 Ц;
   private float ү = 0.0F;
   private float ͼ = 0.0F;
   private long Ѱ = 0L;
   private boolean Ʀ = false;
   private double ѐ = 0.0;
   private double Ƿ = 0.0;
   private double ȸ = 0.0;
   private double վ = 0.0;
   public static int ŭ;

   public oc446ce7e211() {
      super("Scoreboard", oce4cea752dd.Ŏ);
      this.ą("Customizes the sidebar scoreboard style.");
      this.а = false;
      this.ӂ(true);
      occc831eff22 var1 = new occc831eff22("Appearance");
      this.ʌ(var1);
      this.ƞ(var1, Ҋ = new oca9cc61aada("Style", -1271748822 ^ -1271748824, Ȝ));
      this.ƞ(var1, У = new oca9cc61aada("Corner Radius", "px", 5.0, 1.0, 10.0, 0.5));
      this.ƞ(var1, Ǎ = new oca9cc61aada("BG Opacity", 0.4, 0.0, 1.0, 0.05));
      this.ƞ(var1, ә = new occ2f8dff8d8("Hide Red Numbers", false));
      this.ƞ(var1, Ц = new occ2f8dff8d8("Animation", false));
      occc831eff22 var2 = new occc831eff22("Shaders");
      this.ʌ(var2);
      this.ƞ(var2, ʯ = new occ2f8dff8d8("Blur", false));
      occc831eff22 var3 = new occc831eff22("Position");
      this.ʌ(var3);
      this.ƞ(var3, ʕ = new occ2f8dff8d8("Custom Position", false));
      this.ƞ(var3, ӱ = new oca9cc61aada("Offset X", 0.0, -1000.0, 1000.0, 1.0));
      this.ƞ(var3, ճ = new oca9cc61aada("Offset Y", 0.0, -1000.0, 1000.0, 1.0));
      this.z$2u87utkr1isxg();
   }

   private void ƞ(occc831eff22 var1, N var2) {
      oc93499ec6de.Ҭ(var2, var1);
      this.ʌ(var2);
   }

   @Override
   public void z$2u87utkr1isxg() {
      boolean var1 = oce6044968f8.ђ;

      oca9cc61aada var10000;
      int var10001;
      label39: {
         label38: {
            try {
               var10000 = У;
               double var6;
               var10001 = (var6 = Ҋ.Ӂ() - 0.0) == 0.0 ? 0 : (var6 < 0.0 ? -1 : 1);
               if (var1) {
                  break label39;
               }

               if (!var10001) {
                  break label38;
               }
            } catch (ocbde1165e4e var3) {
               throw var3;
            }

            var10001 = 0;
            break label39;
         }

         var10001 = 1;
      }

      label30: {
         label29: {
            try {
               var10000.ȉ((boolean)var10001, this);
               var10000 = Ǎ;
               double var7;
               var10001 = (var7 = Ҋ.Ӂ() - 1.0) == 0.0 ? 0 : (var7 < 0.0 ? -1 : 1);
               if (var1) {
                  break label30;
               }

               if (var10001) {
                  break label29;
               }
            } catch (ocbde1165e4e var2) {
               throw var2;
            }

            var10001 = 0;
            break label30;
         }

         var10001 = 1;
      }

      var10000.ȉ((boolean)var10001, this);
      ӱ.ȉ(ʕ.ǭ(), this);
      ճ.ȉ(ʕ.ǭ(), this);
   }

   @Override
   public void z$1sehylui0i4ix(oca9cc61aada var1) {
      this.z$2u87utkr1isxg();
   }

   @Override
   public void guiButtonToggled(occ2f8dff8d8 var1) {
      super.guiButtonToggled(var1);
      this.z$2u87utkr1isxg();
   }

   public static boolean Â() {
      boolean var0 = oce6044968f8.ђ;

      oc446ce7e211 var10000;
      label33: {
         try {
            var10000 = oc9755810e45.u;
            if (var0) {
               break label33;
            }

            if (oc9755810e45.u == null) {
               return false;
            }
         } catch (ocbde1165e4e var2) {
            throw var2;
         }

         var10000 = oc9755810e45.u;
      }

      try {
         boolean var3 = var10000.z$3rzb3dil7uydr();
         if (var0) {
            return var3;
         }

         if (var3) {
            return true;
         }
      } catch (ocbde1165e4e var1) {
         throw var1;
      }

      return false;
   }

   public static boolean Ш() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: istore 0
      // 04: invokestatic x/oc446ce7e211.Â ()Z
      // 07: ifeq 31
      // 0a: getstatic x/oc446ce7e211.ʯ Lx/occ2f8dff8d8;
      // 0d: iload 0
      // 0e: ifne 1f
      // 11: goto 15
      // 14: athrow
      // 15: ifnull 31
      // 18: goto 1c
      // 1b: athrow
      // 1c: getstatic x/oc446ce7e211.ʯ Lx/occ2f8dff8d8;
      // 1f: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 22: iload 0
      // 23: ifne 2e
      // 26: ifeq 31
      // 29: goto 2d
      // 2c: athrow
      // 2d: bipush 1
      // 2e: goto 32
      // 31: bipush 0
      // 32: ireturn
   }

   public static float ǌ() {
      return oce6044968f8.Ɗ();
   }

   public static boolean Ҿ() {
      return Ш();
   }

   public static float Ç() {
      return oce6044968f8.Ǵ();
   }

   public static oc9cd81f0bf1 Ђ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: istore 0
      // 04: getstatic x/oc446ce7e211.Ҋ Lx/oca9cc61aada;
      // 07: iload 0
      // 08: ifne 1e
      // 0b: ifnonnull 1b
      // 0e: goto 12
      // 11: athrow
      // 12: ldc -1920054494
      // 14: ldc -1920054496
      // 16: ixor
      // 17: goto 22
      // 1a: athrow
      // 1b: getstatic x/oc446ce7e211.Ҋ Lx/oca9cc61aada;
      // 1e: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 21: d2i
      // 22: istore 1
      // 23: iload 1
      // 24: ifne 4d
      // 27: getstatic x/oc446ce7e211.У Lx/oca9cc61aada;
      // 2a: iload 0
      // 2b: ifne 42
      // 2e: goto 32
      // 31: athrow
      // 32: ifnonnull 3f
      // 35: goto 39
      // 38: athrow
      // 39: ldc 5.0
      // 3b: goto 46
      // 3e: athrow
      // 3f: getstatic x/oc446ce7e211.У Lx/oca9cc61aada;
      // 42: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 45: d2f
      // 46: invokestatic x/oce6044968f8.Ƽ ()F
      // 49: fmul
      // 4a: goto 4e
      // 4d: fconst_0
      // 4e: fstore 2
      // 4f: iload 1
      // 50: iload 0
      // 51: ifne 61
      // 54: bipush 1
      // 55: if_icmpne 64
      // 58: goto 5c
      // 5b: athrow
      // 5c: bipush 0
      // 5d: goto 61
      // 60: athrow
      // 61: goto 8b
      // 64: getstatic x/oc446ce7e211.Ǎ Lx/oca9cc61aada;
      // 67: iload 0
      // 68: ifne 7b
      // 6b: ifnonnull 78
      // 6e: goto 72
      // 71: athrow
      // 72: ldc 0.4
      // 74: goto 7f
      // 77: athrow
      // 78: getstatic x/oc446ce7e211.Ǎ Lx/oca9cc61aada;
      // 7b: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 7e: d2f
      // 7f: ldc 255.0
      // 81: fmul
      // 82: invokestatic java/lang/Math.round (F)I
      // 85: ldc -1920054472
      // 87: ldc -1920054496
      // 89: ixor
      // 8a: ishl
      // 8b: istore 3
      // 8c: fload 2
      // 8d: iload 3
      // 8e: invokestatic x/oc446ce7e211.Ш ()Z
      // 91: invokestatic x/oc446ce7e211.Ҿ ()Z
      // 94: invokestatic x/oc9cd81f0bf1.ы (FIZZ)Lx/oc9cd81f0bf1;
      // 97: areturn
   }

   List<oc1332c88c75> Š() {
      ArrayList var1 = new ArrayList();
      var1.add(new oc1332c88c75(EnumChatFormatting.GRAY + "getmiau.today", "1"));
      var1.add(new oc1332c88c75(EnumChatFormatting.YELLOW + "Drag to reposition", "2"));
      var1.add(new oc1332c88c75("Status: " + EnumChatFormatting.GREEN + "Active", "3"));
      var1.add(new oc1332c88c75(EnumChatFormatting.GOLD + "Mimeow Client", "4"));
      return var1;
   }

   private void ʩ(ScaledResolution param1, float param2, float param3, float param4, float param5) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oce6044968f8.ђ Z
      // 003: istore 6
      // 005: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 008: iload 6
      // 00a: ifne 017
      // 00d: ifnull 029
      // 010: goto 014
      // 013: athrow
      // 014: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 017: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 01a: instanceof net/minecraft/client/gui/GuiChat
      // 01d: iload 6
      // 01f: ifne 04c
      // 022: ifne 030
      // 025: goto 029
      // 028: athrow
      // 029: aload 0
      // 02a: bipush 0
      // 02b: putfield x/oc446ce7e211.Ʀ Z
      // 02e: return
      // 02f: athrow
      // 030: fload 2
      // 031: f2i
      // 032: fload 3
      // 033: f2i
      // 034: iload 6
      // 036: ifne 05e
      // 039: fload 4
      // 03b: f2i
      // 03c: fload 5
      // 03e: f2i
      // 03f: ldc_w 423102212
      // 042: ldc_w 1506277627
      // 045: ixor
      // 046: invokestatic net/minecraft/client/gui/Gui.drawRect (IIIII)V
      // 049: invokestatic org/lwjgl/input/Mouse.isCreated ()Z
      // 04c: ifne 050
      // 04f: return
      // 050: invokestatic org/lwjgl/input/Mouse.getX ()I
      // 053: aload 1
      // 054: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledWidth ()I
      // 057: imul
      // 058: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 05b: getfield net/minecraft/client/Minecraft.displayWidth I
      // 05e: idiv
      // 05f: istore 7
      // 061: aload 1
      // 062: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledHeight ()I
      // 065: invokestatic org/lwjgl/input/Mouse.getY ()I
      // 068: aload 1
      // 069: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledHeight ()I
      // 06c: imul
      // 06d: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 070: getfield net/minecraft/client/Minecraft.displayHeight I
      // 073: idiv
      // 074: isub
      // 075: bipush 1
      // 076: isub
      // 077: istore 8
      // 079: iload 7
      // 07b: i2f
      // 07c: iload 6
      // 07e: ifne 091
      // 081: fload 2
      // 082: fcmpl
      // 083: iflt 0cf
      // 086: goto 08a
      // 089: athrow
      // 08a: iload 7
      // 08c: i2f
      // 08d: goto 091
      // 090: athrow
      // 091: iload 6
      // 093: ifne 0b0
      // 096: fload 4
      // 098: fcmpg
      // 099: ifgt 0cf
      // 09c: goto 0a0
      // 09f: athrow
      // 0a0: iload 8
      // 0a2: iload 6
      // 0a4: ifne 0c8
      // 0a7: goto 0ab
      // 0aa: athrow
      // 0ab: i2f
      // 0ac: goto 0b0
      // 0af: athrow
      // 0b0: fload 3
      // 0b1: fcmpl
      // 0b2: iflt 0cf
      // 0b5: iload 8
      // 0b7: iload 6
      // 0b9: ifne 0cc
      // 0bc: goto 0c0
      // 0bf: athrow
      // 0c0: i2f
      // 0c1: fload 5
      // 0c3: fcmpg
      // 0c4: goto 0c8
      // 0c7: athrow
      // 0c8: ifgt 0cf
      // 0cb: bipush 1
      // 0cc: goto 0d0
      // 0cf: bipush 0
      // 0d0: istore 9
      // 0d2: aload 1
      // 0d3: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaleFactor ()I
      // 0d6: i2d
      // 0d7: aload 1
      // 0d8: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaleFactor ()I
      // 0db: i2d
      // 0dc: ldc2_w 2.0
      // 0df: invokestatic java/lang/Math.pow (DD)D
      // 0e2: ddiv
      // 0e3: dstore 10
      // 0e5: invokestatic org/lwjgl/input/Mouse.getX ()I
      // 0e8: i2d
      // 0e9: dload 10
      // 0eb: dmul
      // 0ec: dstore 12
      // 0ee: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0f1: getfield net/minecraft/client/Minecraft.displayHeight I
      // 0f4: invokestatic org/lwjgl/input/Mouse.getY ()I
      // 0f7: isub
      // 0f8: i2d
      // 0f9: dload 10
      // 0fb: dmul
      // 0fc: dstore 14
      // 0fe: iload 9
      // 100: iload 6
      // 102: ifne 187
      // 105: ifeq 183
      // 108: goto 10c
      // 10b: athrow
      // 10c: aload 0
      // 10d: iload 6
      // 10f: ifne 184
      // 112: goto 116
      // 115: athrow
      // 116: getfield x/oc446ce7e211.Ʀ Z
      // 119: ifne 183
      // 11c: goto 120
      // 11f: athrow
      // 120: bipush 0
      // 121: iload 6
      // 123: ifne 187
      // 126: goto 12a
      // 129: athrow
      // 12a: invokestatic org/lwjgl/input/Mouse.isButtonDown (I)Z
      // 12d: ifeq 183
      // 130: goto 134
      // 133: athrow
      // 134: aload 0
      // 135: bipush 1
      // 136: putfield x/oc446ce7e211.Ʀ Z
      // 139: aload 0
      // 13a: getstatic x/oc446ce7e211.ӱ Lx/oca9cc61aada;
      // 13d: iload 6
      // 13f: ifne 150
      // 142: goto 146
      // 145: athrow
      // 146: ifnull 156
      // 149: goto 14d
      // 14c: athrow
      // 14d: getstatic x/oc446ce7e211.ӱ Lx/oca9cc61aada;
      // 150: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 153: goto 157
      // 156: dconst_0
      // 157: putfield x/oc446ce7e211.ѐ D
      // 15a: aload 0
      // 15b: getstatic x/oc446ce7e211.ճ Lx/oca9cc61aada;
      // 15e: iload 6
      // 160: ifne 16d
      // 163: ifnull 173
      // 166: goto 16a
      // 169: athrow
      // 16a: getstatic x/oc446ce7e211.ճ Lx/oca9cc61aada;
      // 16d: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 170: goto 174
      // 173: dconst_0
      // 174: putfield x/oc446ce7e211.Ƿ D
      // 177: aload 0
      // 178: dload 12
      // 17a: putfield x/oc446ce7e211.ȸ D
      // 17d: aload 0
      // 17e: dload 14
      // 180: putfield x/oc446ce7e211.վ D
      // 183: aload 0
      // 184: getfield x/oc446ce7e211.Ʀ Z
      // 187: iload 6
      // 189: ifne 19b
      // 18c: ifeq 212
      // 18f: goto 193
      // 192: athrow
      // 193: bipush 0
      // 194: invokestatic org/lwjgl/input/Mouse.isButtonDown (I)Z
      // 197: goto 19b
      // 19a: athrow
      // 19b: ifne 1ac
      // 19e: aload 0
      // 19f: bipush 0
      // 1a0: putfield x/oc446ce7e211.Ʀ Z
      // 1a3: iload 6
      // 1a5: ifeq 212
      // 1a8: goto 1ac
      // 1ab: athrow
      // 1ac: dload 12
      // 1ae: aload 0
      // 1af: getfield x/oc446ce7e211.ȸ D
      // 1b2: dsub
      // 1b3: dstore 16
      // 1b5: dload 14
      // 1b7: aload 0
      // 1b8: getfield x/oc446ce7e211.վ D
      // 1bb: dsub
      // 1bc: dstore 18
      // 1be: getstatic x/oc446ce7e211.ʕ Lx/occ2f8dff8d8;
      // 1c1: iload 6
      // 1c3: ifne 1d0
      // 1c6: ifnull 1d4
      // 1c9: goto 1cd
      // 1cc: athrow
      // 1cd: getstatic x/oc446ce7e211.ʕ Lx/occ2f8dff8d8;
      // 1d0: bipush 1
      // 1d1: invokevirtual x/occ2f8dff8d8.ϑ (Z)V
      // 1d4: getstatic x/oc446ce7e211.ӱ Lx/oca9cc61aada;
      // 1d7: iload 6
      // 1d9: ifne 1f8
      // 1dc: ifnull 1f5
      // 1df: goto 1e3
      // 1e2: athrow
      // 1e3: getstatic x/oc446ce7e211.ӱ Lx/oca9cc61aada;
      // 1e6: aload 0
      // 1e7: getfield x/oc446ce7e211.ѐ D
      // 1ea: dload 16
      // 1ec: dadd
      // 1ed: invokevirtual x/oca9cc61aada.Ȟ (D)D
      // 1f0: pop2
      // 1f1: goto 1f5
      // 1f4: athrow
      // 1f5: getstatic x/oc446ce7e211.ճ Lx/oca9cc61aada;
      // 1f8: iload 6
      // 1fa: ifne 207
      // 1fd: ifnull 212
      // 200: goto 204
      // 203: athrow
      // 204: getstatic x/oc446ce7e211.ճ Lx/oca9cc61aada;
      // 207: aload 0
      // 208: getfield x/oc446ce7e211.Ƿ D
      // 20b: dload 18
      // 20d: dadd
      // 20e: invokevirtual x/oca9cc61aada.Ȟ (D)D
      // 211: pop2
      // 212: goto 217
      // 215: astore 7
      // 217: return
   }

   public void ɯ(ScoreObjective param1, ScaledResolution param2, FontRenderer param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oce6044968f8.ђ Z
      // 003: istore 4
      // 005: aload 2
      // 006: ifnull 011
      // 009: aload 3
      // 00a: ifnonnull 013
      // 00d: goto 011
      // 010: athrow
      // 011: return
      // 012: athrow
      // 013: aload 1
      // 014: iload 4
      // 016: ifne 051
      // 019: ifnonnull 050
      // 01c: goto 020
      // 01f: athrow
      // 020: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 023: iload 4
      // 025: ifne 036
      // 028: goto 02c
      // 02b: athrow
      // 02c: ifnull 04f
      // 02f: goto 033
      // 032: athrow
      // 033: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 036: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 039: instanceof net/minecraft/client/gui/GuiChat
      // 03c: ifeq 04f
      // 03f: aload 0
      // 040: ldc "Scoreboard"
      // 042: aload 0
      // 043: invokevirtual x/oc446ce7e211.Š ()Ljava/util/List;
      // 046: aload 2
      // 047: aload 3
      // 048: invokevirtual x/oc446ce7e211.Ǥ (Ljava/lang/String;Ljava/util/List;Lnet/minecraft/client/gui/ScaledResolution;Lnet/minecraft/client/gui/FontRenderer;)V
      // 04b: goto 04f
      // 04e: athrow
      // 04f: return
      // 050: aload 1
      // 051: invokevirtual net/minecraft/scoreboard/ScoreObjective.getScoreboard ()Lnet/minecraft/scoreboard/Scoreboard;
      // 054: astore 5
      // 056: aload 5
      // 058: iload 4
      // 05a: ifne 098
      // 05d: ifnonnull 096
      // 060: goto 064
      // 063: athrow
      // 064: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 067: iload 4
      // 069: ifne 07a
      // 06c: goto 070
      // 06f: athrow
      // 070: ifnull 095
      // 073: goto 077
      // 076: athrow
      // 077: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 07a: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 07d: instanceof net/minecraft/client/gui/GuiChat
      // 080: ifeq 095
      // 083: aload 0
      // 084: aload 1
      // 085: invokevirtual net/minecraft/scoreboard/ScoreObjective.getDisplayName ()Ljava/lang/String;
      // 088: aload 0
      // 089: invokevirtual x/oc446ce7e211.Š ()Ljava/util/List;
      // 08c: aload 2
      // 08d: aload 3
      // 08e: invokevirtual x/oc446ce7e211.Ǥ (Ljava/lang/String;Ljava/util/List;Lnet/minecraft/client/gui/ScaledResolution;Lnet/minecraft/client/gui/FontRenderer;)V
      // 091: goto 095
      // 094: athrow
      // 095: return
      // 096: aload 5
      // 098: aload 1
      // 099: invokevirtual net/minecraft/scoreboard/Scoreboard.getSortedScores (Lnet/minecraft/scoreboard/ScoreObjective;)Ljava/util/Collection;
      // 09c: astore 6
      // 09e: aload 6
      // 0a0: new x/ocd455364f5a
      // 0a3: dup
      // 0a4: aload 0
      // 0a5: invokespecial x/ocd455364f5a.<init> (Lx/oc446ce7e211;)V
      // 0a8: invokestatic com/google/common/collect/Iterables.filter (Ljava/lang/Iterable;Lcom/google/common/base/Predicate;)Ljava/lang/Iterable;
      // 0ab: invokestatic com/google/common/collect/Lists.newArrayList (Ljava/lang/Iterable;)Ljava/util/ArrayList;
      // 0ae: astore 7
      // 0b0: aload 7
      // 0b2: iload 4
      // 0b4: ifne 0ee
      // 0b7: invokeinterface java/util/List.size ()I 1
      // 0bc: ldc_w -1416469567
      // 0bf: ldc_w -1416469554
      // 0c2: ixor
      // 0c3: if_icmple 0e8
      // 0c6: goto 0ca
      // 0c9: athrow
      // 0ca: aload 7
      // 0cc: aload 7
      // 0ce: invokeinterface java/util/List.size ()I 1
      // 0d3: ldc_w -1416469567
      // 0d6: ldc_w -1416469554
      // 0d9: ixor
      // 0da: isub
      // 0db: invokestatic com/google/common/collect/Iterables.skip (Ljava/lang/Iterable;I)Ljava/lang/Iterable;
      // 0de: invokestatic com/google/common/collect/Lists.newArrayList (Ljava/lang/Iterable;)Ljava/util/ArrayList;
      // 0e1: astore 6
      // 0e3: iload 4
      // 0e5: ifeq 0f0
      // 0e8: aload 7
      // 0ea: goto 0ee
      // 0ed: athrow
      // 0ee: astore 6
      // 0f0: new java/util/ArrayList
      // 0f3: dup
      // 0f4: invokespecial java/util/ArrayList.<init> ()V
      // 0f7: astore 8
      // 0f9: aload 6
      // 0fb: invokeinterface java/util/Collection.iterator ()Ljava/util/Iterator; 1
      // 100: astore 9
      // 102: aload 9
      // 104: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 109: ifeq 157
      // 10c: aload 9
      // 10e: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 113: checkcast net/minecraft/scoreboard/Score
      // 116: astore 10
      // 118: aload 5
      // 11a: aload 10
      // 11c: invokevirtual net/minecraft/scoreboard/Score.getPlayerName ()Ljava/lang/String;
      // 11f: invokevirtual net/minecraft/scoreboard/Scoreboard.getPlayersTeam (Ljava/lang/String;)Lnet/minecraft/scoreboard/ScorePlayerTeam;
      // 122: astore 11
      // 124: aload 11
      // 126: aload 10
      // 128: invokevirtual net/minecraft/scoreboard/Score.getPlayerName ()Ljava/lang/String;
      // 12b: invokestatic net/minecraft/scoreboard/ScorePlayerTeam.formatPlayerName (Lnet/minecraft/scoreboard/Team;Ljava/lang/String;)Ljava/lang/String;
      // 12e: astore 12
      // 130: aload 8
      // 132: new x/oc1332c88c75
      // 135: dup
      // 136: aload 12
      // 138: aload 10
      // 13a: invokevirtual net/minecraft/scoreboard/Score.getScorePoints ()I
      // 13d: invokestatic java/lang/String.valueOf (I)Ljava/lang/String;
      // 140: invokespecial x/oc1332c88c75.<init> (Ljava/lang/String;Ljava/lang/String;)V
      // 143: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 148: iload 4
      // 14a: ifne 15e
      // 14d: pop
      // 14e: iload 4
      // 150: ifeq 102
      // 153: goto 157
      // 156: athrow
      // 157: aload 8
      // 159: invokeinterface java/util/List.isEmpty ()Z 1
      // 15e: ifeq 186
      // 161: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 164: iload 4
      // 166: ifne 177
      // 169: goto 16d
      // 16c: athrow
      // 16d: ifnull 186
      // 170: goto 174
      // 173: athrow
      // 174: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 177: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 17a: instanceof net/minecraft/client/gui/GuiChat
      // 17d: ifeq 186
      // 180: aload 0
      // 181: invokevirtual x/oc446ce7e211.Š ()Ljava/util/List;
      // 184: astore 8
      // 186: aload 0
      // 187: aload 1
      // 188: invokevirtual net/minecraft/scoreboard/ScoreObjective.getDisplayName ()Ljava/lang/String;
      // 18b: aload 8
      // 18d: aload 2
      // 18e: aload 3
      // 18f: invokevirtual x/oc446ce7e211.Ǥ (Ljava/lang/String;Ljava/util/List;Lnet/minecraft/client/gui/ScaledResolution;Lnet/minecraft/client/gui/FontRenderer;)V
      // 192: return
   }

   private void Ǥ(String param1, List<oc1332c88c75> param2, ScaledResolution param3, FontRenderer param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oce6044968f8.ђ Z
      // 003: aload 4
      // 005: invokestatic x/oce6044968f8.Ɏ (Lnet/minecraft/client/gui/FontRenderer;)Lx/oc1378bc114d;
      // 008: astore 6
      // 00a: getstatic x/oc446ce7e211.ә Lx/occ2f8dff8d8;
      // 00d: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 010: istore 7
      // 012: istore 5
      // 014: ldc_w 3.0
      // 017: invokestatic x/oce6044968f8.Ƽ ()F
      // 01a: fmul
      // 01b: invokestatic x/oce6044968f8.ǆ ()F
      // 01e: invokestatic java/lang/Math.max (FF)F
      // 021: fstore 8
      // 023: invokestatic x/oce6044968f8.Ƽ ()F
      // 026: invokestatic x/oce6044968f8.š ()F
      // 029: invokestatic java/lang/Math.max (FF)F
      // 02c: fstore 9
      // 02e: aload 6
      // 030: invokeinterface x/oc1378bc114d.z$1tqmx4tpnr6lq ()I 1
      // 035: i2f
      // 036: fload 9
      // 038: fconst_2
      // 039: fmul
      // 03a: fadd
      // 03b: fstore 10
      // 03d: aload 6
      // 03f: aload 1
      // 040: invokeinterface x/oc1378bc114d.z$toz8pt08w0nc (Ljava/lang/String;)I 2
      // 045: istore 11
      // 047: aload 2
      // 048: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 04d: astore 12
      // 04f: aload 12
      // 051: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 056: ifeq 0b1
      // 059: aload 12
      // 05b: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 060: checkcast x/oc1332c88c75
      // 063: astore 13
      // 065: iload 11
      // 067: iload 5
      // 069: ifne 0b3
      // 06c: aload 6
      // 06e: aload 13
      // 070: getfield x/oc1332c88c75.ķ Ljava/lang/String;
      // 073: invokeinterface x/oc1378bc114d.z$toz8pt08w0nc (Ljava/lang/String;)I 2
      // 078: iload 7
      // 07a: iload 5
      // 07c: ifne 099
      // 07f: goto 083
      // 082: athrow
      // 083: ifeq 08f
      // 086: goto 08a
      // 089: athrow
      // 08a: bipush 0
      // 08b: goto 0a6
      // 08e: athrow
      // 08f: ldc_w 6.0
      // 092: invokestatic x/oce6044968f8.Ƽ ()F
      // 095: fmul
      // 096: invokestatic java/lang/Math.round (F)I
      // 099: aload 6
      // 09b: aload 13
      // 09d: getfield x/oc1332c88c75.ͽ Ljava/lang/String;
      // 0a0: invokeinterface x/oc1378bc114d.z$toz8pt08w0nc (Ljava/lang/String;)I 2
      // 0a5: iadd
      // 0a6: iadd
      // 0a7: invokestatic java/lang/Math.max (II)I
      // 0aa: istore 11
      // 0ac: iload 5
      // 0ae: ifeq 04f
      // 0b1: iload 11
      // 0b3: i2f
      // 0b4: fload 8
      // 0b6: fconst_2
      // 0b7: fmul
      // 0b8: fadd
      // 0b9: fstore 12
      // 0bb: aload 2
      // 0bc: invokeinterface java/util/List.size ()I 1
      // 0c1: bipush 1
      // 0c2: iadd
      // 0c3: i2f
      // 0c4: fload 10
      // 0c6: fmul
      // 0c7: fstore 13
      // 0c9: invokestatic java/lang/System.currentTimeMillis ()J
      // 0cc: lstore 14
      // 0ce: aload 0
      // 0cf: getfield x/oc446ce7e211.Ѱ J
      // 0d2: lconst_0
      // 0d3: lcmp
      // 0d4: ifne 0de
      // 0d7: ldc_w 0.05
      // 0da: goto 0f0
      // 0dd: athrow
      // 0de: ldc_w 0.1
      // 0e1: lload 14
      // 0e3: aload 0
      // 0e4: getfield x/oc446ce7e211.Ѱ J
      // 0e7: lsub
      // 0e8: l2f
      // 0e9: ldc_w 1000.0
      // 0ec: fdiv
      // 0ed: invokestatic java/lang/Math.min (FF)F
      // 0f0: fstore 16
      // 0f2: iload 5
      // 0f4: ifne 164
      // 0f7: aload 0
      // 0f8: lload 14
      // 0fa: putfield x/oc446ce7e211.Ѱ J
      // 0fd: getstatic x/oc446ce7e211.Ц Lx/occ2f8dff8d8;
      // 100: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 103: ifeq 15a
      // 106: goto 10a
      // 109: athrow
      // 10a: aload 0
      // 10b: iload 5
      // 10d: ifne 165
      // 110: goto 114
      // 113: athrow
      // 114: getfield x/oc446ce7e211.ү F
      // 117: fconst_0
      // 118: fcmpl
      // 119: ifle 15a
      // 11c: goto 120
      // 11f: athrow
      // 120: fconst_1
      // 121: ldc_w -14.0
      // 124: fload 16
      // 126: fmul
      // 127: f2d
      // 128: invokestatic java/lang/Math.exp (D)D
      // 12b: d2f
      // 12c: fsub
      // 12d: fstore 17
      // 12f: iload 5
      // 131: aload 0
      // 132: dup
      // 133: getfield x/oc446ce7e211.ү F
      // 136: fload 12
      // 138: aload 0
      // 139: getfield x/oc446ce7e211.ү F
      // 13c: fsub
      // 13d: fload 17
      // 13f: fmul
      // 140: fadd
      // 141: putfield x/oc446ce7e211.ү F
      // 144: aload 0
      // 145: dup
      // 146: getfield x/oc446ce7e211.ͼ F
      // 149: fload 13
      // 14b: aload 0
      // 14c: getfield x/oc446ce7e211.ͼ F
      // 14f: fsub
      // 150: fload 17
      // 152: fmul
      // 153: fadd
      // 154: putfield x/oc446ce7e211.ͼ F
      // 157: ifeq 16a
      // 15a: aload 0
      // 15b: fload 12
      // 15d: putfield x/oc446ce7e211.ү F
      // 160: goto 164
      // 163: athrow
      // 164: aload 0
      // 165: fload 13
      // 167: putfield x/oc446ce7e211.ͼ F
      // 16a: aload 0
      // 16b: getfield x/oc446ce7e211.ү F
      // 16e: fstore 17
      // 170: iload 5
      // 172: aload 0
      // 173: getfield x/oc446ce7e211.ͼ F
      // 176: fstore 18
      // 178: aload 3
      // 179: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledWidth ()I
      // 17c: i2f
      // 17d: fload 17
      // 17f: fsub
      // 180: ldc_w 3.0
      // 183: fsub
      // 184: fstore 19
      // 186: aload 3
      // 187: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledHeight ()I
      // 18a: i2f
      // 18b: fload 18
      // 18d: fsub
      // 18e: fconst_2
      // 18f: fdiv
      // 190: fstore 20
      // 192: ifne 1cd
      // 195: getstatic x/oc446ce7e211.ʕ Lx/occ2f8dff8d8;
      // 198: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 19b: ifeq 1ba
      // 19e: goto 1a2
      // 1a1: athrow
      // 1a2: fload 19
      // 1a4: getstatic x/oc446ce7e211.ӱ Lx/oca9cc61aada;
      // 1a7: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 1aa: d2f
      // 1ab: fadd
      // 1ac: fstore 19
      // 1ae: fload 20
      // 1b0: getstatic x/oc446ce7e211.ճ Lx/oca9cc61aada;
      // 1b3: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 1b6: d2f
      // 1b7: fadd
      // 1b8: fstore 20
      // 1ba: aload 0
      // 1bb: aload 3
      // 1bc: fload 19
      // 1be: fload 20
      // 1c0: fload 19
      // 1c2: fload 17
      // 1c4: fadd
      // 1c5: fload 20
      // 1c7: fload 18
      // 1c9: fadd
      // 1ca: invokevirtual x/oc446ce7e211.ʩ (Lnet/minecraft/client/gui/ScaledResolution;FFFF)V
      // 1cd: fload 19
      // 1cf: fstore 21
      // 1d1: fload 20
      // 1d3: fstore 22
      // 1d5: new x/oc99b8eeba10
      // 1d8: dup
      // 1d9: fload 21
      // 1db: fload 22
      // 1dd: fload 17
      // 1df: fload 18
      // 1e1: fload 21
      // 1e3: fload 22
      // 1e5: fload 17
      // 1e7: fload 18
      // 1e9: aload 6
      // 1eb: aload 1
      // 1ec: fload 9
      // 1ee: aload 2
      // 1ef: fload 10
      // 1f1: fload 8
      // 1f3: iload 7
      // 1f5: invokedynamic run (FFFFLx/oc1378bc114d;Ljava/lang/String;FLjava/util/List;FFZ)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, x/oc446ce7e211.q3oa9zokwvz4p1 (FFFFLx/oc1378bc114d;Ljava/lang/String;FLjava/util/List;FFZ)V, ()V ]
      // 1fa: invokespecial x/oc99b8eeba10.<init> (FFFFLjava/lang/Runnable;)V
      // 1fd: invokestatic x/oc446ce7e211.Ђ ()Lx/oc9cd81f0bf1;
      // 200: invokestatic x/oce6044968f8.ΐ (Lx/oc99b8eeba10;Lx/oc9cd81f0bf1;)V
      // 203: return
   }

   static {
      String[] var10000 = new String[1289789824 ^ 1289789827];
      var10000[0] = "Modern Rounded";
      var10000[1] = "Clean (No BG)";
      var10000[1289789825 ^ 1289789827] = "Vanilla";
      Ȝ = var10000;
   }
}
