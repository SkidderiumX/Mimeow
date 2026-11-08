package x;

import java.awt.Color;
import java.util.ArrayList;
import net.minecraft.entity.player.EntityPlayer;

public class oce9a353a216 extends oc69da1aa7f5 {
   private oca9cc61aada U;
   private oca9cc61aada ֆ;
   private occ2f8dff8d8 ր;
   private occ2f8dff8d8 պ;
   private occ2f8dff8d8 ǟ;
   private occ2f8dff8d8 ˁ;
   private occ2f8dff8d8 Ȕ;
   private occ2f8dff8d8 գ;
   private int Թ = new Color(0, 1072263635 ^ 1072263468, 0, 1072263635 ^ 1072263468).getRGB();
   private int Ӷ = new Color(1072263635 ^ 1072263468, 0, 0, 1072263635 ^ 1072263468).getRGB();
   private final ArrayList<oc68ed380e7d> Җ = new ArrayList<>();
   private int þ = 0;
   private String[] Ӑ;
   public static int Ѡ;

   public oce9a353a216() {
      super("Arrows", oce4cea752dd.Ŏ);
      String[] var10001 = new String[1072263471 ^ 1072263468];
      var10001[0] = "Caret";
      var10001[1] = "Greater than";
      var10001[1072263470 ^ 1072263468] = "Triangle";
      this.Ӑ = var10001;
      this.ą("Shows directional arrows toward other players.");
      this.ʌ(this.U = new oca9cc61aada("Arrow", 0, this.Ӑ));
      this.ʌ(this.ֆ = new oca9cc61aada("Circle radius", 50.0, 30.0, 200.0, 5.0));
      this.ʌ(this.ր = new occ2f8dff8d8("Team color", true));
      this.ʌ(this.պ = new occ2f8dff8d8("Hide teammates", true));
      this.ʌ(this.ǟ = new occ2f8dff8d8("Render friends (green)", true));
      this.ʌ(this.ˁ = new occ2f8dff8d8("Render enemies (red)", true));
      this.ʌ(this.Ȕ = new occ2f8dff8d8("Render distance", true));
      this.ʌ(this.գ = new occ2f8dff8d8("Render only offscreen", false));
   }

   @oc66fa4f2195
   public void J(oc9adb807c19 var1) {
      try {
         if (var1.Ұ != oc110d7f376c.END) {
            return;
         }
      } catch (ocbde1165e4e var2) {
         throw var2;
      }

      this.Ѐ();
   }

   @oc66fa4f2195
   public void ɣ(ocf923d5a814 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: istore 2
      // 04: aload 1
      // 05: getfield x/ocb508b4e274.Ұ Lx/oc110d7f376c;
      // 08: getstatic x/oc110d7f376c.END Lx/oc110d7f376c;
      // 0b: if_acmpeq 10
      // 0e: return
      // 0f: athrow
      // 10: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 13: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 16: ifnonnull 2b
      // 19: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 1c: iload 2
      // 1d: ifne 2d
      // 20: goto 24
      // 23: athrow
      // 24: ifne 2c
      // 27: goto 2b
      // 2a: athrow
      // 2b: return
      // 2c: bipush 0
      // 2d: istore 3
      // 2e: iload 3
      // 2f: aload 0
      // 30: getfield x/oce9a353a216.þ I
      // 33: if_icmpge 78
      // 36: aload 0
      // 37: getfield x/oce9a353a216.Җ Ljava/util/ArrayList;
      // 3a: iload 3
      // 3b: invokevirtual java/util/ArrayList.get (I)Ljava/lang/Object;
      // 3e: checkcast x/oc68ed380e7d
      // 41: astore 4
      // 43: iload 2
      // 44: ifne 7c
      // 47: aload 4
      // 49: getfield x/oc68ed380e7d.Ӷ Lnet/minecraft/entity/player/EntityPlayer;
      // 4c: ifnonnull 5b
      // 4f: goto 53
      // 52: athrow
      // 53: iload 2
      // 54: ifeq 71
      // 57: goto 5b
      // 5a: athrow
      // 5b: aload 0
      // 5c: aload 4
      // 5e: getfield x/oc68ed380e7d.Ӷ Lnet/minecraft/entity/player/EntityPlayer;
      // 61: aload 4
      // 63: getfield x/oc68ed380e7d.Ė I
      // 66: aload 1
      // 67: getfield x/ocf923d5a814.ô F
      // 6a: invokevirtual x/oce9a353a216.Ƒ (Lnet/minecraft/entity/player/EntityPlayer;IF)V
      // 6d: goto 71
      // 70: athrow
      // 71: iinc 3 1
      // 74: iload 2
      // 75: ifeq 2e
      // 78: goto 7c
      // 7b: astore 3
      // 7c: return
   }

   private void Ѐ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oce6044968f8.ђ Z
      // 003: aload 0
      // 004: bipush 0
      // 005: putfield x/oce9a353a216.þ I
      // 008: istore 1
      // 009: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 00c: ifeq 024
      // 00f: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 012: iload 1
      // 013: ifne 029
      // 016: goto 01a
      // 019: athrow
      // 01a: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 01d: ifnonnull 026
      // 020: goto 024
      // 023: athrow
      // 024: return
      // 025: athrow
      // 026: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 029: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 02c: getfield net/minecraft/client/multiplayer/WorldClient.playerEntities Ljava/util/List;
      // 02f: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 034: astore 2
      // 035: aload 2
      // 036: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 03b: ifeq 17b
      // 03e: aload 2
      // 03f: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 044: checkcast net/minecraft/entity/player/EntityPlayer
      // 047: astore 3
      // 048: aload 3
      // 049: iload 1
      // 04a: ifne 055
      // 04d: ifnull 035
      // 050: goto 054
      // 053: athrow
      // 054: aload 3
      // 055: iload 1
      // 056: ifne 06f
      // 059: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 05c: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 05f: if_acmpne 06e
      // 062: goto 066
      // 065: athrow
      // 066: iload 1
      // 067: ifeq 035
      // 06a: goto 06e
      // 06d: athrow
      // 06e: aload 3
      // 06f: iload 1
      // 070: ifne 086
      // 073: invokestatic x/oca4f99d2d44.Λ (Lnet/minecraft/entity/Entity;)Z
      // 076: ifeq 085
      // 079: goto 07d
      // 07c: athrow
      // 07d: iload 1
      // 07e: ifeq 035
      // 081: goto 085
      // 084: athrow
      // 085: aload 3
      // 086: invokestatic x/oc7ab2161b9f.ӥ (Lnet/minecraft/entity/Entity;)Z
      // 089: iload 1
      // 08a: ifne 0b3
      // 08d: ifeq 0b2
      // 090: goto 094
      // 093: athrow
      // 094: aload 0
      // 095: getfield x/oce9a353a216.պ Lx/occ2f8dff8d8;
      // 098: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 09b: iload 1
      // 09c: ifne 0b3
      // 09f: goto 0a3
      // 0a2: athrow
      // 0a3: ifeq 0b2
      // 0a6: goto 0aa
      // 0a9: athrow
      // 0aa: iload 1
      // 0ab: ifeq 035
      // 0ae: goto 0b2
      // 0b1: athrow
      // 0b2: bipush -1
      // 0b3: istore 4
      // 0b5: aload 0
      // 0b6: iload 1
      // 0b7: ifne 0e9
      // 0ba: getfield x/oce9a353a216.ǟ Lx/occ2f8dff8d8;
      // 0bd: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 0c0: ifeq 0e4
      // 0c3: goto 0c7
      // 0c6: athrow
      // 0c7: aload 3
      // 0c8: invokestatic x/oc7ab2161b9f.Ӭ (Lnet/minecraft/entity/player/EntityPlayer;)Z
      // 0cb: iload 1
      // 0cc: ifne 0f7
      // 0cf: goto 0d3
      // 0d2: athrow
      // 0d3: ifeq 0e4
      // 0d6: goto 0da
      // 0d9: athrow
      // 0da: aload 0
      // 0db: getfield x/oce9a353a216.Թ I
      // 0de: istore 4
      // 0e0: iload 1
      // 0e1: ifeq 133
      // 0e4: aload 0
      // 0e5: goto 0e9
      // 0e8: athrow
      // 0e9: iload 1
      // 0ea: ifne 11c
      // 0ed: getfield x/oce9a353a216.ˁ Lx/occ2f8dff8d8;
      // 0f0: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 0f3: goto 0f7
      // 0f6: athrow
      // 0f7: ifeq 117
      // 0fa: aload 3
      // 0fb: invokestatic x/oc7ab2161b9f.Š (Lnet/minecraft/entity/player/EntityPlayer;)Z
      // 0fe: iload 1
      // 0ff: ifne 12a
      // 102: goto 106
      // 105: athrow
      // 106: ifeq 117
      // 109: goto 10d
      // 10c: athrow
      // 10d: aload 0
      // 10e: getfield x/oce9a353a216.Ӷ I
      // 111: istore 4
      // 113: iload 1
      // 114: ifeq 133
      // 117: aload 0
      // 118: goto 11c
      // 11b: athrow
      // 11c: iload 1
      // 11d: ifne 134
      // 120: getfield x/oce9a353a216.ր Lx/occ2f8dff8d8;
      // 123: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 126: goto 12a
      // 129: athrow
      // 12a: ifeq 133
      // 12d: aload 3
      // 12e: invokestatic x/oc7ab2161b9f.ǳ (Lnet/minecraft/entity/Entity;)I
      // 131: istore 4
      // 133: aload 0
      // 134: iload 1
      // 135: ifne 16e
      // 138: getfield x/oce9a353a216.þ I
      // 13b: aload 0
      // 13c: getfield x/oce9a353a216.Җ Ljava/util/ArrayList;
      // 13f: invokevirtual java/util/ArrayList.size ()I
      // 142: if_icmplt 15c
      // 145: goto 149
      // 148: athrow
      // 149: aload 0
      // 14a: getfield x/oce9a353a216.Җ Ljava/util/ArrayList;
      // 14d: new x/oc68ed380e7d
      // 150: dup
      // 151: invokespecial x/oc68ed380e7d.<init> ()V
      // 154: invokevirtual java/util/ArrayList.add (Ljava/lang/Object;)Z
      // 157: pop
      // 158: goto 15c
      // 15b: athrow
      // 15c: aload 0
      // 15d: getfield x/oce9a353a216.Җ Ljava/util/ArrayList;
      // 160: aload 0
      // 161: dup
      // 162: getfield x/oce9a353a216.þ I
      // 165: dup_x1
      // 166: bipush 1
      // 167: iadd
      // 168: putfield x/oce9a353a216.þ I
      // 16b: invokevirtual java/util/ArrayList.get (I)Ljava/lang/Object;
      // 16e: checkcast x/oc68ed380e7d
      // 171: aload 3
      // 172: iload 4
      // 174: invokevirtual x/oc68ed380e7d.ȭ (Lnet/minecraft/entity/player/EntityPlayer;I)V
      // 177: iload 1
      // 178: ifeq 035
      // 17b: return
   }

   private void Ƒ(EntityPlayer param1, int param2, float param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oce6044968f8.ђ Z
      // 003: istore 4
      // 005: aload 0
      // 006: getfield x/oce9a353a216.գ Lx/occ2f8dff8d8;
      // 009: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 00c: iload 4
      // 00e: ifne 029
      // 011: ifeq 02d
      // 014: goto 018
      // 017: athrow
      // 018: aload 1
      // 019: iload 4
      // 01b: ifne 02e
      // 01e: goto 022
      // 021: athrow
      // 022: invokestatic x/ocbd4917c4b1.ž (Lnet/minecraft/entity/Entity;)Z
      // 025: goto 029
      // 028: athrow
      // 029: ifeq 02d
      // 02c: return
      // 02d: aload 1
      // 02e: getfield net/minecraft/entity/player/EntityPlayer.lastTickPosX D
      // 031: aload 1
      // 032: getfield net/minecraft/entity/player/EntityPlayer.posX D
      // 035: aload 1
      // 036: getfield net/minecraft/entity/player/EntityPlayer.lastTickPosX D
      // 039: dsub
      // 03a: fload 3
      // 03b: f2d
      // 03c: dmul
      // 03d: dadd
      // 03e: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 041: invokevirtual net/minecraft/client/Minecraft.getRenderManager ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 044: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosX D
      // 047: dsub
      // 048: dstore 5
      // 04a: iload 4
      // 04c: aload 1
      // 04d: getfield net/minecraft/entity/player/EntityPlayer.lastTickPosY D
      // 050: aload 1
      // 051: getfield net/minecraft/entity/player/EntityPlayer.posY D
      // 054: aload 1
      // 055: getfield net/minecraft/entity/player/EntityPlayer.lastTickPosY D
      // 058: dsub
      // 059: fload 3
      // 05a: f2d
      // 05b: dmul
      // 05c: dadd
      // 05d: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 060: invokevirtual net/minecraft/client/Minecraft.getRenderManager ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 063: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosY D
      // 066: dsub
      // 067: aload 1
      // 068: getfield net/minecraft/entity/player/EntityPlayer.height F
      // 06b: fconst_2
      // 06c: fdiv
      // 06d: f2d
      // 06e: dadd
      // 06f: dstore 7
      // 071: aload 1
      // 072: getfield net/minecraft/entity/player/EntityPlayer.lastTickPosZ D
      // 075: aload 1
      // 076: getfield net/minecraft/entity/player/EntityPlayer.posZ D
      // 079: aload 1
      // 07a: getfield net/minecraft/entity/player/EntityPlayer.lastTickPosZ D
      // 07d: dsub
      // 07e: fload 3
      // 07f: f2d
      // 080: dmul
      // 081: dadd
      // 082: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 085: invokevirtual net/minecraft/client/Minecraft.getRenderManager ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 088: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosZ D
      // 08b: dsub
      // 08c: dstore 9
      // 08e: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 091: getfield net/minecraft/client/Minecraft.entityRenderer Lnet/minecraft/client/renderer/EntityRenderer;
      // 094: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 097: invokeinterface x/oc8ecfa69e1b.getTimer ()Lnet/minecraft/util/Timer; 1
      // 09c: getfield net/minecraft/util/Timer.renderPartialTicks F
      // 09f: bipush 0
      // 0a0: invokeinterface x/oc65f19d876a.callSetupCameraTransform (FI)V 3
      // 0a5: new net/minecraft/client/gui/ScaledResolution
      // 0a8: dup
      // 0a9: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0ac: invokespecial net/minecraft/client/gui/ScaledResolution.<init> (Lnet/minecraft/client/Minecraft;)V
      // 0af: astore 11
      // 0b1: aload 11
      // 0b3: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaleFactor ()I
      // 0b6: dload 5
      // 0b8: dload 7
      // 0ba: dload 9
      // 0bc: invokestatic x/ocbd4917c4b1.ʵ (IDDD)Lnet/minecraft/util/Vec3;
      // 0bf: astore 12
      // 0c1: ifne 0da
      // 0c4: aload 12
      // 0c6: ifnull 450
      // 0c9: goto 0cd
      // 0cc: athrow
      // 0cd: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0d0: getfield net/minecraft/client/Minecraft.entityRenderer Lnet/minecraft/client/renderer/EntityRenderer;
      // 0d3: invokevirtual net/minecraft/client/renderer/EntityRenderer.setupOverlayRendering ()V
      // 0d6: goto 0da
      // 0d9: athrow
      // 0da: new net/minecraft/client/gui/ScaledResolution
      // 0dd: dup
      // 0de: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0e1: invokespecial net/minecraft/client/gui/ScaledResolution.<init> (Lnet/minecraft/client/Minecraft;)V
      // 0e4: astore 13
      // 0e6: aload 12
      // 0e8: getfield net/minecraft/util/Vec3.xCoord D
      // 0eb: aload 13
      // 0ed: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledWidth ()I
      // 0f0: i2d
      // 0f1: ldc2_w 2.0
      // 0f4: ddiv
      // 0f5: dsub
      // 0f6: dstore 14
      // 0f8: aload 12
      // 0fa: getfield net/minecraft/util/Vec3.yCoord D
      // 0fd: aload 13
      // 0ff: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledHeight ()I
      // 102: i2d
      // 103: ldc2_w 2.0
      // 106: ddiv
      // 107: dsub
      // 108: dstore 16
      // 10a: aload 12
      // 10c: getfield net/minecraft/util/Vec3.zCoord D
      // 10f: ldc2_w 1.0003684
      // 112: dcmpg
      // 113: iload 4
      // 115: ifne 120
      // 118: ifge 123
      // 11b: goto 11f
      // 11e: athrow
      // 11f: bipush 1
      // 120: goto 124
      // 123: bipush 0
      // 124: istore 18
      // 126: iload 4
      // 128: ifne 13c
      // 12b: iload 18
      // 12d: ifne 144
      // 130: goto 134
      // 133: athrow
      // 134: dload 14
      // 136: ldc2_w -1.0
      // 139: dmul
      // 13a: dstore 14
      // 13c: dload 16
      // 13e: ldc2_w -1.0
      // 141: dmul
      // 142: dstore 16
      // 144: dload 14
      // 146: dload 16
      // 148: invokestatic java/lang/Math.atan2 (DD)D
      // 14b: dstore 19
      // 14d: dload 16
      // 14f: dload 14
      // 151: invokestatic java/lang/Math.atan2 (DD)D
      // 154: ldc2_w 57.295780181884766
      // 157: dmul
      // 158: ldc2_w 90.0
      // 15b: dadd
      // 15c: dstore 21
      // 15e: dload 14
      // 160: dload 16
      // 162: invokestatic java/lang/Math.hypot (DD)D
      // 165: dstore 23
      // 167: aload 0
      // 168: getfield x/oce9a353a216.ֆ Lx/oca9cc61aada;
      // 16b: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 16e: dstore 25
      // 170: iload 18
      // 172: iload 4
      // 174: ifne 19e
      // 177: ifeq 199
      // 17a: goto 17e
      // 17d: athrow
      // 17e: dload 23
      // 180: dload 25
      // 182: ldc2_w 15.0
      // 185: dadd
      // 186: iload 4
      // 188: ifne 1a2
      // 18b: goto 18f
      // 18e: athrow
      // 18f: dcmpg
      // 190: ifge 199
      // 193: goto 197
      // 196: athrow
      // 197: return
      // 198: athrow
      // 199: aload 13
      // 19b: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledWidth ()I
      // 19e: i2d
      // 19f: ldc2_w 2.0
      // 1a2: ddiv
      // 1a3: dstore 27
      // 1a5: aload 13
      // 1a7: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledHeight ()I
      // 1aa: i2d
      // 1ab: ldc2_w 2.0
      // 1ae: ddiv
      // 1af: dstore 29
      // 1b1: dload 19
      // 1b3: invokestatic java/lang/Math.sin (D)D
      // 1b6: dstore 31
      // 1b8: dload 19
      // 1ba: invokestatic java/lang/Math.cos (D)D
      // 1bd: dstore 33
      // 1bf: dload 27
      // 1c1: dload 25
      // 1c3: dload 31
      // 1c5: dmul
      // 1c6: dadd
      // 1c7: dstore 35
      // 1c9: dload 29
      // 1cb: dload 25
      // 1cd: dload 33
      // 1cf: dmul
      // 1d0: dadd
      // 1d1: dstore 37
      // 1d3: invokestatic net/minecraft/client/renderer/GlStateManager.pushMatrix ()V
      // 1d6: dload 35
      // 1d8: dload 37
      // 1da: dconst_0
      // 1db: invokestatic net/minecraft/client/renderer/GlStateManager.translate (DDD)V
      // 1de: dload 21
      // 1e0: d2f
      // 1e1: fconst_0
      // 1e2: fconst_0
      // 1e3: fconst_1
      // 1e4: invokestatic net/minecraft/client/renderer/GlStateManager.rotate (FFFF)V
      // 1e7: fconst_1
      // 1e8: fconst_1
      // 1e9: fconst_1
      // 1ea: invokestatic net/minecraft/client/renderer/GlStateManager.scale (FFF)V
      // 1ed: aload 0
      // 1ee: getfield x/oce9a353a216.U Lx/oca9cc61aada;
      // 1f1: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 1f4: d2i
      // 1f5: istore 39
      // 1f7: iload 39
      // 1f9: iload 4
      // 1fb: ifne 329
      // 1fe: ifne 323
      // 201: goto 205
      // 204: athrow
      // 205: iload 2
      // 206: iload 4
      // 208: ifne 22b
      // 20b: goto 20f
      // 20e: athrow
      // 20f: bipush -1
      // 210: if_icmpne 226
      // 213: goto 217
      // 216: athrow
      // 217: dconst_1
      // 218: dconst_1
      // 219: dconst_1
      // 21a: invokestatic org/lwjgl/opengl/GL11.glColor3d (DDD)V
      // 21d: iload 4
      // 21f: ifeq 27a
      // 222: goto 226
      // 225: athrow
      // 226: iload 2
      // 227: goto 22b
      // 22a: athrow
      // 22b: istore 40
      // 22d: iload 40
      // 22f: ldc_w -883065681
      // 232: ldc_w -883065665
      // 235: ixor
      // 236: ishr
      // 237: ldc_w -883065792
      // 23a: ldc_w -883065665
      // 23d: ixor
      // 23e: iand
      // 23f: i2f
      // 240: ldc_w 255.0
      // 243: fdiv
      // 244: fstore 41
      // 246: iload 40
      // 248: ldc_w -883065673
      // 24b: ldc_w -883065665
      // 24e: ixor
      // 24f: ishr
      // 250: ldc_w -883065792
      // 253: ldc_w -883065665
      // 256: ixor
      // 257: iand
      // 258: i2f
      // 259: ldc_w 255.0
      // 25c: fdiv
      // 25d: fstore 42
      // 25f: iload 40
      // 261: ldc_w -883065792
      // 264: ldc_w -883065665
      // 267: ixor
      // 268: iand
      // 269: i2f
      // 26a: ldc_w 255.0
      // 26d: fdiv
      // 26e: fstore 43
      // 270: fload 41
      // 272: fload 42
      // 274: fload 43
      // 276: fconst_1
      // 277: invokestatic org/lwjgl/opengl/GL11.glColor4f (FFFF)V
      // 27a: ldc_w -883067043
      // 27d: ldc_w -883065665
      // 280: ixor
      // 281: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 284: iload 4
      // 286: ldc_w -883068578
      // 289: ldc_w -883065665
      // 28c: ixor
      // 28d: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 290: ldc_w -883064899
      // 293: ldc_w -883065665
      // 296: ixor
      // 297: ldc_w -883064900
      // 29a: ldc_w -883065665
      // 29d: ixor
      // 29e: invokestatic org/lwjgl/opengl/GL11.glBlendFunc (II)V
      // 2a1: ldc_w -883066977
      // 2a4: ldc_w -883065665
      // 2a7: ixor
      // 2a8: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 2ab: ldc2_w 0.6108652353286743
      // 2ae: dstore 40
      // 2b0: ldc2_w 9.0
      // 2b3: dstore 42
      // 2b5: ldc2_w 5.0
      // 2b8: dstore 44
      // 2ba: ldc_w 3.0
      // 2bd: invokestatic org/lwjgl/opengl/GL11.glLineWidth (F)V
      // 2c0: ldc_w -883065668
      // 2c3: ldc_w -883065665
      // 2c6: ixor
      // 2c7: invokestatic org/lwjgl/opengl/GL11.glBegin (I)V
      // 2ca: dload 40
      // 2cc: dneg
      // 2cd: invokestatic java/lang/Math.sin (D)D
      // 2d0: dload 42
      // 2d2: dmul
      // 2d3: dload 40
      // 2d5: dneg
      // 2d6: invokestatic java/lang/Math.cos (D)D
      // 2d9: dload 42
      // 2db: dmul
      // 2dc: dload 44
      // 2de: dsub
      // 2df: invokestatic org/lwjgl/opengl/GL11.glVertex2d (DD)V
      // 2e2: dconst_0
      // 2e3: dload 44
      // 2e5: dneg
      // 2e6: invokestatic org/lwjgl/opengl/GL11.glVertex2d (DD)V
      // 2e9: dload 40
      // 2eb: invokestatic java/lang/Math.sin (D)D
      // 2ee: dload 42
      // 2f0: dmul
      // 2f1: dload 40
      // 2f3: invokestatic java/lang/Math.cos (D)D
      // 2f6: dload 42
      // 2f8: dmul
      // 2f9: dload 44
      // 2fb: dsub
      // 2fc: invokestatic org/lwjgl/opengl/GL11.glVertex2d (DD)V
      // 2ff: invokestatic x/oc170ea29aae.ŷ ()V
      // 302: ldc_w -883068578
      // 305: ldc_w -883065665
      // 308: ixor
      // 309: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 30c: ldc_w -883067043
      // 30f: ldc_w -883065665
      // 312: ixor
      // 313: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 316: ldc_w -883066977
      // 319: ldc_w -883065665
      // 31c: ixor
      // 31d: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 320: ifeq 3a0
      // 323: iload 39
      // 325: goto 329
      // 328: athrow
      // 329: iload 4
      // 32b: ifne 36f
      // 32e: bipush 1
      // 32f: if_icmpne 369
      // 332: goto 336
      // 335: athrow
      // 336: ldc_w -90.0
      // 339: fconst_0
      // 33a: fconst_0
      // 33b: fconst_1
      // 33c: invokestatic net/minecraft/client/renderer/GlStateManager.rotate (FFFF)V
      // 33f: iload 4
      // 341: ldc2_w 1.5
      // 344: ldc2_w 1.5
      // 347: ldc2_w 1.5
      // 34a: invokestatic net/minecraft/client/renderer/GlStateManager.scale (DDD)V
      // 34d: aload 0
      // 34e: invokevirtual x/oce9a353a216.Ä ()Lx/oc1378bc114d;
      // 351: astore 40
      // 353: aload 40
      // 355: ldc_w ">"
      // 358: ldc_w -2.0
      // 35b: ldc_w -4.0
      // 35e: iload 2
      // 35f: bipush 0
      // 360: invokeinterface x/oc1378bc114d.z$ao2ykh4tuw6w (Ljava/lang/String;FFIZ)I 6
      // 365: pop
      // 366: ifeq 3a0
      // 369: iload 39
      // 36b: goto 36f
      // 36e: athrow
      // 36f: iload 4
      // 371: ifne 3dd
      // 374: ldc_w -883065667
      // 377: ldc_w -883065665
      // 37a: ixor
      // 37b: if_icmpne 3a0
      // 37e: goto 382
      // 381: athrow
      // 382: dconst_0
      // 383: dconst_0
      // 384: ldc2_w 5.0
      // 387: ldc_w -883065668
      // 38a: ldc_w -883065665
      // 38d: ixor
      // 38e: iload 2
      // 38f: ldc_w -883065792
      // 392: ldc_w -883065665
      // 395: ixor
      // 396: invokestatic x/oc7ab2161b9f.Ҭ (II)I
      // 399: invokestatic x/ocbd4917c4b1.İ (DDDII)V
      // 39c: goto 3a0
      // 39f: athrow
      // 3a0: invokestatic net/minecraft/client/renderer/GlStateManager.popMatrix ()V
      // 3a3: dload 27
      // 3a5: dload 25
      // 3a7: ldc2_w 13.0
      // 3aa: dsub
      // 3ab: dload 31
      // 3ad: dmul
      // 3ae: dadd
      // 3af: dstore 35
      // 3b1: dload 29
      // 3b3: dload 25
      // 3b5: ldc2_w 13.0
      // 3b8: dsub
      // 3b9: dload 33
      // 3bb: dmul
      // 3bc: dadd
      // 3bd: dstore 37
      // 3bf: invokestatic net/minecraft/client/renderer/GlStateManager.pushMatrix ()V
      // 3c2: dload 35
      // 3c4: dload 37
      // 3c6: dconst_0
      // 3c7: invokestatic net/minecraft/client/renderer/GlStateManager.translate (DDD)V
      // 3ca: ldc2_w 0.8
      // 3cd: ldc2_w 0.8
      // 3d0: ldc2_w 0.8
      // 3d3: invokestatic net/minecraft/client/renderer/GlStateManager.scale (DDD)V
      // 3d6: aload 0
      // 3d7: getfield x/oce9a353a216.Ȕ Lx/occ2f8dff8d8;
      // 3da: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 3dd: iload 4
      // 3df: ifne 3f8
      // 3e2: ifeq 44d
      // 3e5: goto 3e9
      // 3e8: athrow
      // 3e9: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 3ec: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 3ef: aload 1
      // 3f0: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getDistanceToEntity (Lnet/minecraft/entity/Entity;)F
      // 3f3: f2i
      // 3f4: goto 3f8
      // 3f7: athrow
      // 3f8: invokedynamic makeConcatWithConstants (I)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001m" ]
      // 3fd: astore 40
      // 3ff: aload 0
      // 400: invokevirtual x/oce9a353a216.Ä ()Lx/oc1378bc114d;
      // 403: astore 41
      // 405: aload 41
      // 407: aload 40
      // 409: invokeinterface x/oc1378bc114d.z$toz8pt08w0nc (Ljava/lang/String;)I 2
      // 40e: ineg
      // 40f: i2f
      // 410: fconst_2
      // 411: fdiv
      // 412: fstore 42
      // 414: fload 42
      // 416: invokestatic x/oce6044968f8.ǆ ()F
      // 419: fsub
      // 41a: ldc_w -4.0
      // 41d: invokestatic x/oce6044968f8.š ()F
      // 420: fsub
      // 421: aload 41
      // 423: aload 40
      // 425: invokeinterface x/oc1378bc114d.z$toz8pt08w0nc (Ljava/lang/String;)I 2
      // 42a: i2f
      // 42b: invokestatic x/oce6044968f8.ǆ ()F
      // 42e: fconst_2
      // 42f: fmul
      // 430: fadd
      // 431: aload 41
      // 433: invokeinterface x/oc1378bc114d.z$1tqmx4tpnr6lq ()I 1
      // 438: i2f
      // 439: invokestatic x/oce6044968f8.š ()F
      // 43c: fconst_2
      // 43d: fmul
      // 43e: fadd
      // 43f: aload 41
      // 441: aload 40
      // 443: fload 42
      // 445: invokedynamic run (Lx/oc1378bc114d;Ljava/lang/String;F)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, x/oce9a353a216.q19clip6s1cr29 (Lx/oc1378bc114d;Ljava/lang/String;F)V, ()V ]
      // 44a: invokestatic x/oce6044968f8.ӱ (FFFFLjava/lang/Runnable;)V
      // 44d: invokestatic net/minecraft/client/renderer/GlStateManager.popMatrix ()V
      // 450: return
   }

   private oc1378bc114d Ä() {
      return oce6044968f8.ʜ();
   }
}
