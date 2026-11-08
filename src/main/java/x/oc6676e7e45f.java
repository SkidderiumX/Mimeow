package x;

import net.minecraft.block.Block;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;

public class oc6676e7e45f extends oc69da1aa7f5 {
   private static final float Һ = 0.98F;
   private static final float ǔ = 0.2F;
   private static final float ж = (float) (Math.PI / 180.0);
   private final occ2f8dff8d8 ճ;
   private final occ2f8dff8d8 Ƹ;
   private final occ2f8dff8d8 ƙ;
   private final occ2f8dff8d8 Ѷ;
   private oca77e773b24 վ;
   private EntityPlayerSP Թ;
   private float Ǆ;
   private float ė;
   private float ɧ;
   private float ԇ;
   private float Զ;
   private float Ԣ;
   private float ȉ;
   private float ү;
   private float Ѱ;
   private float ƈ;
   private float Д;
   private boolean Ѡ;
   private boolean ǿ;
   private boolean Ȝ;
   public static int ı;

   public oc6676e7e45f() {
      super("45Jump", oce4cea752dd.ҕ);
      this.ą("Aligns sprint jumps to a 45-degree diagonal.");
      this.ʌ(new oc4d46a99983("45 degree diagonal sprint jumps"));
      this.ʌ(this.ճ = new occ2f8dff8d8("Holding blocks", true));
      this.ʌ(this.Ƹ = new occ2f8dff8d8("Holding throwable", true));
      this.ʌ(this.ƙ = new occ2f8dff8d8("Holding rod", true));
      this.ʌ(this.Ѷ = new occ2f8dff8d8("Targeting", false));
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.HIGHEST
   )
   public void Ȩ(oc70db705765 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: bipush 0
      // 001: istore 2
      // 002: aload 0
      // 003: iload 2
      // 004: ifne 022
      // 007: aconst_null
      // 008: putfield x/oc6676e7e45f.վ Lx/oca77e773b24;
      // 00b: aload 0
      // 00c: bipush 0
      // 00d: putfield x/oc6676e7e45f.Ѡ Z
      // 010: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 013: ifne 021
      // 016: goto 01a
      // 019: athrow
      // 01a: aload 0
      // 01b: bipush 0
      // 01c: putfield x/oc6676e7e45f.Ȝ Z
      // 01f: return
      // 020: athrow
      // 021: aload 0
      // 022: getfield x/oc6676e7e45f.Ȝ Z
      // 025: iload 2
      // 026: ifne 050
      // 029: ifeq 04c
      // 02c: goto 030
      // 02f: athrow
      // 030: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 033: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 036: getfield net/minecraft/client/entity/EntityPlayerSP.onGround Z
      // 039: ifne 047
      // 03c: goto 040
      // 03f: athrow
      // 040: aload 1
      // 041: fconst_0
      // 042: invokevirtual x/oc70db705765.Ԥ (F)V
      // 045: return
      // 046: athrow
      // 047: aload 0
      // 048: bipush 0
      // 049: putfield x/oc6676e7e45f.Ȝ Z
      // 04c: aload 1
      // 04d: invokevirtual x/oc70db705765.ϧ ()Z
      // 050: iload 2
      // 051: ifne 070
      // 054: ifeq 15a
      // 057: goto 05b
      // 05a: athrow
      // 05b: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 05e: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 061: iload 2
      // 062: ifne 07d
      // 065: goto 069
      // 068: athrow
      // 069: getfield net/minecraft/client/entity/EntityPlayerSP.onGround Z
      // 06c: goto 070
      // 06f: athrow
      // 070: ifeq 15a
      // 073: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 076: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 079: goto 07d
      // 07c: athrow
      // 07d: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getJumpTicks ()I
      // 080: iload 2
      // 081: ifne 093
      // 084: ifne 15a
      // 087: goto 08b
      // 08a: athrow
      // 08b: aload 1
      // 08c: invokevirtual x/oc70db705765.ҧ ()Z
      // 08f: goto 093
      // 092: athrow
      // 093: iload 2
      // 094: ifne 0b3
      // 097: ifne 15a
      // 09a: goto 09e
      // 09d: athrow
      // 09e: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0a1: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0a4: iload 2
      // 0a5: ifne 0c4
      // 0a8: goto 0ac
      // 0ab: athrow
      // 0ac: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isInWater ()Z
      // 0af: goto 0b3
      // 0b2: athrow
      // 0b3: ifne 15a
      // 0b6: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0b9: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0bc: iload 2
      // 0bd: ifne 0dc
      // 0c0: goto 0c4
      // 0c3: athrow
      // 0c4: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isInLava ()Z
      // 0c7: ifne 15a
      // 0ca: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0cd: iload 2
      // 0ce: ifne 0ec
      // 0d1: goto 0d5
      // 0d4: athrow
      // 0d5: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0d8: goto 0dc
      // 0db: athrow
      // 0dc: getfield net/minecraft/client/entity/EntityPlayerSP.capabilities Lnet/minecraft/entity/player/PlayerCapabilities;
      // 0df: getfield net/minecraft/entity/player/PlayerCapabilities.isFlying Z
      // 0e2: ifne 15a
      // 0e5: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0e8: goto 0ec
      // 0eb: athrow
      // 0ec: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0ef: iload 2
      // 0f0: ifne 107
      // 0f3: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isRiding ()Z
      // 0f6: ifne 15a
      // 0f9: goto 0fd
      // 0fc: athrow
      // 0fd: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 100: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 103: goto 107
      // 106: athrow
      // 107: getfield net/minecraft/client/entity/EntityPlayerSP.isCollidedHorizontally Z
      // 10a: iload 2
      // 10b: ifne 11f
      // 10e: ifne 15a
      // 111: goto 115
      // 114: athrow
      // 115: invokestatic x/ocbb165642ef.ʨ ()Lx/ocbb165642ef;
      // 118: invokevirtual x/ocbb165642ef.Ÿ ()Z
      // 11b: goto 11f
      // 11e: athrow
      // 11f: iload 2
      // 120: ifne 13a
      // 123: ifne 15a
      // 126: goto 12a
      // 129: athrow
      // 12a: aload 0
      // 12b: iload 2
      // 12c: ifne 13e
      // 12f: goto 133
      // 132: athrow
      // 133: invokevirtual x/oc6676e7e45f.ĵ ()Z
      // 136: goto 13a
      // 139: athrow
      // 13a: ifeq 15a
      // 13d: aload 0
      // 13e: iload 2
      // 13f: ifne 154
      // 142: getfield x/oc6676e7e45f.Ѷ Lx/occ2f8dff8d8;
      // 145: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 148: ifeq 15c
      // 14b: goto 14f
      // 14e: athrow
      // 14f: aload 0
      // 150: goto 154
      // 153: athrow
      // 154: invokevirtual x/oc6676e7e45f.Ў ()Z
      // 157: ifne 15c
      // 15a: return
      // 15b: athrow
      // 15c: aload 1
      // 15d: invokevirtual x/oc70db705765.ԉ ()F
      // 160: fstore 3
      // 161: aload 1
      // 162: invokevirtual x/oc70db705765.Ƕ ()F
      // 165: fstore 4
      // 167: fload 3
      // 168: iload 2
      // 169: ifne 190
      // 16c: fconst_0
      // 16d: fcmpl
      // 16e: ifne 18f
      // 171: goto 175
      // 174: athrow
      // 175: fload 4
      // 177: iload 2
      // 178: ifne 190
      // 17b: goto 17f
      // 17e: athrow
      // 17f: fconst_0
      // 180: fcmpl
      // 181: ifne 18f
      // 184: goto 188
      // 187: athrow
      // 188: fconst_1
      // 189: fstore 3
      // 18a: aload 1
      // 18b: fload 3
      // 18c: invokevirtual x/oc70db705765.ď (F)V
      // 18f: fload 3
      // 190: iload 2
      // 191: ifne 1a5
      // 194: ldc 0.99
      // 196: fcmpg
      // 197: ifge 1a0
      // 19a: goto 19e
      // 19d: athrow
      // 19e: return
      // 19f: athrow
      // 1a0: fload 4
      // 1a2: invokestatic java/lang/Math.abs (F)F
      // 1a5: ldc 0.99
      // 1a7: fcmpg
      // 1a8: iload 2
      // 1a9: ifne 1d8
      // 1ac: ifge 1c7
      // 1af: goto 1b3
      // 1b2: athrow
      // 1b3: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1b6: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1b9: getfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 1bc: invokestatic x/oc6676e7e45f.f (F)F
      // 1bf: fstore 4
      // 1c1: aload 1
      // 1c2: fload 4
      // 1c4: invokevirtual x/oc70db705765.Ԥ (F)V
      // 1c7: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1ca: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1cd: iload 2
      // 1ce: ifne 1ef
      // 1d1: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isSprinting ()Z
      // 1d4: goto 1d8
      // 1d7: athrow
      // 1d8: ifne 1e9
      // 1db: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1de: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1e1: bipush 1
      // 1e2: invokevirtual net/minecraft/client/entity/EntityPlayerSP.setSprinting (Z)V
      // 1e5: goto 1e9
      // 1e8: athrow
      // 1e9: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1ec: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1ef: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isSprinting ()Z
      // 1f2: ifne 1f7
      // 1f5: return
      // 1f6: athrow
      // 1f7: aload 0
      // 1f8: invokevirtual x/oc6676e7e45f.յ ()V
      // 1fb: aload 0
      // 1fc: getfield x/oc6676e7e45f.Ǆ F
      // 1ff: aload 0
      // 200: getfield x/oc6676e7e45f.ė F
      // 203: getstatic x/oc75d51ec7eb.d [F
      // 206: bipush 0
      // 207: faload
      // 208: getstatic x/oc75d51ec7eb.d [F
      // 20b: bipush 1
      // 20c: faload
      // 20d: invokestatic x/oc75d51ec7eb.Ĩ (FFFF)[F
      // 210: astore 5
      // 212: aload 0
      // 213: aload 5
      // 215: bipush 0
      // 216: faload
      // 217: putfield x/oc6676e7e45f.ƈ F
      // 21a: aload 0
      // 21b: aload 5
      // 21d: bipush 1
      // 21e: faload
      // 21f: putfield x/oc6676e7e45f.Д F
      // 222: invokestatic x/ocbb165642ef.ʨ ()Lx/ocbb165642ef;
      // 225: aload 0
      // 226: getfield x/oc6676e7e45f.ƈ F
      // 229: aload 0
      // 22a: getfield x/oc6676e7e45f.Д F
      // 22d: invokevirtual x/ocbb165642ef.ƕ (FF)V
      // 230: aload 0
      // 231: bipush 1
      // 232: putfield x/oc6676e7e45f.Ѡ Z
      // 235: return
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.LOWEST
   )
   public void a(oc52918cda9d param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: istore 2
      // 02: aload 0
      // 03: iload 2
      // 04: ifne 14
      // 07: getfield x/oc6676e7e45f.Ѡ Z
      // 0a: ifne 13
      // 0d: goto 11
      // 10: athrow
      // 11: return
      // 12: athrow
      // 13: aload 0
      // 14: bipush 0
      // 15: putfield x/oc6676e7e45f.Ѡ Z
      // 18: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 1b: iload 2
      // 1c: ifne 3b
      // 1f: ifeq 69
      // 22: goto 26
      // 25: athrow
      // 26: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 29: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 2c: iload 2
      // 2d: ifne 50
      // 30: goto 34
      // 33: athrow
      // 34: getfield net/minecraft/client/entity/EntityPlayerSP.onGround Z
      // 37: goto 3b
      // 3a: athrow
      // 3b: ifeq 69
      // 3e: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 41: iload 2
      // 42: ifne 60
      // 45: goto 49
      // 48: athrow
      // 49: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 4c: goto 50
      // 4f: athrow
      // 50: getfield net/minecraft/client/entity/EntityPlayerSP.movementInput Lnet/minecraft/util/MovementInput;
      // 53: getfield net/minecraft/util/MovementInput.jump Z
      // 56: ifeq 69
      // 59: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 5c: goto 60
      // 5f: athrow
      // 60: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 63: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isSprinting ()Z
      // 66: ifne 6b
      // 69: return
      // 6a: athrow
      // 6b: invokestatic x/oc6676e7e45f.ҧ ()F
      // 6e: fstore 3
      // 6f: iload 2
      // 70: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 73: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 76: getfield net/minecraft/client/entity/EntityPlayerSP.movementInput Lnet/minecraft/util/MovementInput;
      // 79: getfield net/minecraft/util/MovementInput.moveForward F
      // 7c: fload 3
      // 7d: fmul
      // 7e: fstore 4
      // 80: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 83: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 86: getfield net/minecraft/client/entity/EntityPlayerSP.movementInput Lnet/minecraft/util/MovementInput;
      // 89: getfield net/minecraft/util/MovementInput.moveStrafe F
      // 8c: fload 3
      // 8d: fmul
      // 8e: fstore 5
      // 90: fload 4
      // 92: fload 5
      // 94: aload 0
      // 95: getfield x/oc6676e7e45f.Ǆ F
      // 98: aload 0
      // 99: getfield x/oc6676e7e45f.ƈ F
      // 9c: aload 0
      // 9d: getfield x/oc6676e7e45f.Д F
      // a0: invokestatic x/oc6676e7e45f.Ӊ (FFFFF)Lx/oca77e773b24;
      // a3: astore 6
      // a5: ifne ca
      // a8: aload 6
      // aa: ifnonnull b3
      // ad: goto b1
      // b0: athrow
      // b1: return
      // b2: athrow
      // b3: aload 0
      // b4: aload 6
      // b6: putfield x/oc6676e7e45f.վ Lx/oca77e773b24;
      // b9: aload 0
      // ba: getfield x/oc6676e7e45f.Թ Lnet/minecraft/client/entity/EntityPlayerSP;
      // bd: aload 6
      // bf: getfield x/oca77e773b24.ȹ F
      // c2: putfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // c5: aload 0
      // c6: bipush 1
      // c7: putfield x/oc6676e7e45f.ǿ Z
      // ca: return
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.LOWEST
   )
   public void ʦ(oc4c5a4d3446 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: istore 2
      // 02: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 05: iload 2
      // 06: ifne 1a
      // 09: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0c: ifnull 7a
      // 0f: goto 13
      // 12: athrow
      // 13: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 16: goto 1a
      // 19: athrow
      // 1a: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1d: iload 2
      // 1e: ifne 3b
      // 21: getfield net/minecraft/client/entity/EntityPlayerSP.movementInput Lnet/minecraft/util/MovementInput;
      // 24: ifnull 7a
      // 27: goto 2b
      // 2a: athrow
      // 2b: aload 1
      // 2c: iload 2
      // 2d: ifne 49
      // 30: goto 34
      // 33: athrow
      // 34: getfield x/oc4c5a4d3446.ȗ Lnet/minecraft/entity/EntityLivingBase;
      // 37: goto 3b
      // 3a: athrow
      // 3b: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 3e: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 41: if_acmpne 7a
      // 44: aload 1
      // 45: goto 49
      // 48: athrow
      // 49: invokevirtual x/oc4c5a4d3446.ř ()Z
      // 4c: iload 2
      // 4d: ifne 64
      // 50: ifeq 7a
      // 53: goto 57
      // 56: athrow
      // 57: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 5a: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 5d: getfield net/minecraft/client/entity/EntityPlayerSP.onGround Z
      // 60: goto 64
      // 63: athrow
      // 64: ifeq 7a
      // 67: aload 0
      // 68: iload 2
      // 69: ifne 88
      // 6c: goto 70
      // 6f: athrow
      // 70: getfield x/oc6676e7e45f.վ Lx/oca77e773b24;
      // 73: ifnonnull 7c
      // 76: goto 7a
      // 79: athrow
      // 7a: return
      // 7b: athrow
      // 7c: aload 1
      // 7d: aload 0
      // 7e: getfield x/oc6676e7e45f.վ Lx/oca77e773b24;
      // 81: getfield x/oca77e773b24.Ȓ F
      // 84: invokevirtual x/oc4c5a4d3446.Ŗ (F)V
      // 87: aload 0
      // 88: bipush 1
      // 89: putfield x/oc6676e7e45f.Ȝ Z
      // 8c: return
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.LOWEST
   )
   public void б(oc25aa89b91f param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: istore 2
      // 02: iload 2
      // 03: aload 0
      // 04: invokevirtual x/oc6676e7e45f.ȟ ()V
      // 07: ifne 2b
      // 0a: aload 0
      // 0b: getfield x/oc6676e7e45f.վ Lx/oca77e773b24;
      // 0e: ifnonnull 17
      // 11: goto 15
      // 14: athrow
      // 15: return
      // 16: athrow
      // 17: aload 1
      // 18: aload 0
      // 19: getfield x/oc6676e7e45f.ƈ F
      // 1c: invokevirtual x/oc25aa89b91f.Տ (F)V
      // 1f: aload 1
      // 20: aload 0
      // 21: getfield x/oc6676e7e45f.Д F
      // 24: invokevirtual x/oc25aa89b91f.ȫ (F)V
      // 27: bipush 0
      // 28: invokestatic x/oc25aa89b91f.c (Z)V
      // 2b: return
   }

   @oc66fa4f2195
   public void ʎ(oc0e4b758d9a var1) {
      this.ȟ();
      this.ӽ();
   }

   @Override
   public void onDisable() {
      this.ȟ();
      this.ӽ();
      this.Ȝ = false;
   }

   private void յ() {
      this.Թ = oc69da1aa7f5.ő.thePlayer;
      this.Ǆ = this.Թ.rotationYaw;
      this.ė = this.Թ.rotationPitch;
      this.ɧ = this.Թ.prevRotationYaw;
      this.ԇ = this.Թ.rotationYawHead;
      this.Զ = this.Թ.prevRotationYawHead;
      this.Ԣ = this.Թ.renderYawOffset;
      this.ȉ = this.Թ.prevRenderYawOffset;
      this.ү = this.Թ.renderArmYaw;
      this.Ѱ = this.Թ.prevRenderArmYaw;
      this.ǿ = false;
   }

   private void ȟ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: istore 1
      // 02: aload 0
      // 03: iload 1
      // 04: ifne 16
      // 07: getfield x/oc6676e7e45f.ǿ Z
      // 0a: ifeq 24
      // 0d: goto 11
      // 10: athrow
      // 11: aload 0
      // 12: goto 16
      // 15: athrow
      // 16: iload 1
      // 17: ifne 8f
      // 1a: getfield x/oc6676e7e45f.Թ Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1d: ifnonnull 26
      // 20: goto 24
      // 23: athrow
      // 24: return
      // 25: athrow
      // 26: aload 0
      // 27: getfield x/oc6676e7e45f.Թ Lnet/minecraft/client/entity/EntityPlayerSP;
      // 2a: aload 0
      // 2b: getfield x/oc6676e7e45f.Ǆ F
      // 2e: putfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 31: aload 0
      // 32: getfield x/oc6676e7e45f.Թ Lnet/minecraft/client/entity/EntityPlayerSP;
      // 35: aload 0
      // 36: getfield x/oc6676e7e45f.ė F
      // 39: putfield net/minecraft/client/entity/EntityPlayerSP.rotationPitch F
      // 3c: aload 0
      // 3d: getfield x/oc6676e7e45f.Թ Lnet/minecraft/client/entity/EntityPlayerSP;
      // 40: aload 0
      // 41: getfield x/oc6676e7e45f.ɧ F
      // 44: putfield net/minecraft/client/entity/EntityPlayerSP.prevRotationYaw F
      // 47: aload 0
      // 48: getfield x/oc6676e7e45f.Թ Lnet/minecraft/client/entity/EntityPlayerSP;
      // 4b: aload 0
      // 4c: getfield x/oc6676e7e45f.ԇ F
      // 4f: putfield net/minecraft/client/entity/EntityPlayerSP.rotationYawHead F
      // 52: aload 0
      // 53: getfield x/oc6676e7e45f.Թ Lnet/minecraft/client/entity/EntityPlayerSP;
      // 56: aload 0
      // 57: getfield x/oc6676e7e45f.Զ F
      // 5a: putfield net/minecraft/client/entity/EntityPlayerSP.prevRotationYawHead F
      // 5d: aload 0
      // 5e: getfield x/oc6676e7e45f.Թ Lnet/minecraft/client/entity/EntityPlayerSP;
      // 61: aload 0
      // 62: getfield x/oc6676e7e45f.Ԣ F
      // 65: putfield net/minecraft/client/entity/EntityPlayerSP.renderYawOffset F
      // 68: aload 0
      // 69: getfield x/oc6676e7e45f.Թ Lnet/minecraft/client/entity/EntityPlayerSP;
      // 6c: aload 0
      // 6d: getfield x/oc6676e7e45f.ȉ F
      // 70: putfield net/minecraft/client/entity/EntityPlayerSP.prevRenderYawOffset F
      // 73: aload 0
      // 74: getfield x/oc6676e7e45f.Թ Lnet/minecraft/client/entity/EntityPlayerSP;
      // 77: aload 0
      // 78: getfield x/oc6676e7e45f.ү F
      // 7b: putfield net/minecraft/client/entity/EntityPlayerSP.renderArmYaw F
      // 7e: aload 0
      // 7f: getfield x/oc6676e7e45f.Թ Lnet/minecraft/client/entity/EntityPlayerSP;
      // 82: aload 0
      // 83: getfield x/oc6676e7e45f.Ѱ F
      // 86: putfield net/minecraft/client/entity/EntityPlayerSP.prevRenderArmYaw F
      // 89: aload 0
      // 8a: bipush 0
      // 8b: putfield x/oc6676e7e45f.ǿ Z
      // 8e: aload 0
      // 8f: aconst_null
      // 90: putfield x/oc6676e7e45f.Թ Lnet/minecraft/client/entity/EntityPlayerSP;
      // 93: return
   }

   private void ӽ() {
      this.վ = null;
      this.Ѡ = false;
      this.ƈ = 0.0F;
      this.Д = 0.0F;
   }

   private boolean ĵ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: bipush 0
      // 001: istore 1
      // 002: aload 0
      // 003: getfield x/oc6676e7e45f.ճ Lx/occ2f8dff8d8;
      // 006: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 009: iload 1
      // 00a: ifne 041
      // 00d: ifne 040
      // 010: goto 014
      // 013: athrow
      // 014: aload 0
      // 015: getfield x/oc6676e7e45f.Ƹ Lx/occ2f8dff8d8;
      // 018: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 01b: iload 1
      // 01c: ifne 041
      // 01f: goto 023
      // 022: athrow
      // 023: ifne 040
      // 026: goto 02a
      // 029: athrow
      // 02a: aload 0
      // 02b: getfield x/oc6676e7e45f.ƙ Lx/occ2f8dff8d8;
      // 02e: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 031: iload 1
      // 032: ifne 041
      // 035: goto 039
      // 038: athrow
      // 039: ifeq 044
      // 03c: goto 040
      // 03f: athrow
      // 040: bipush 1
      // 041: goto 045
      // 044: bipush 0
      // 045: istore 2
      // 046: iload 2
      // 047: iload 1
      // 048: ifne 053
      // 04b: ifne 054
      // 04e: goto 052
      // 051: athrow
      // 052: bipush 1
      // 053: ireturn
      // 054: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 057: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 05a: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getHeldItem ()Lnet/minecraft/item/ItemStack;
      // 05d: astore 3
      // 05e: aload 3
      // 05f: iload 1
      // 060: ifne 06e
      // 063: ifnonnull 06d
      // 066: goto 06a
      // 069: athrow
      // 06a: bipush 0
      // 06b: ireturn
      // 06c: athrow
      // 06d: aload 3
      // 06e: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 071: astore 4
      // 073: aload 0
      // 074: iload 1
      // 075: ifne 09a
      // 078: getfield x/oc6676e7e45f.ճ Lx/occ2f8dff8d8;
      // 07b: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 07e: ifeq 099
      // 081: goto 085
      // 084: athrow
      // 085: aload 4
      // 087: instanceof net/minecraft/item/ItemBlock
      // 08a: iload 1
      // 08b: ifne 150
      // 08e: goto 092
      // 091: athrow
      // 092: ifne 14f
      // 095: goto 099
      // 098: athrow
      // 099: aload 0
      // 09a: getfield x/oc6676e7e45f.ƙ Lx/occ2f8dff8d8;
      // 09d: iload 1
      // 09e: ifne 0c7
      // 0a1: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 0a4: ifeq 0bf
      // 0a7: goto 0ab
      // 0aa: athrow
      // 0ab: aload 4
      // 0ad: instanceof net/minecraft/item/ItemFishingRod
      // 0b0: iload 1
      // 0b1: ifne 150
      // 0b4: goto 0b8
      // 0b7: athrow
      // 0b8: ifne 14f
      // 0bb: goto 0bf
      // 0be: athrow
      // 0bf: aload 0
      // 0c0: getfield x/oc6676e7e45f.Ƹ Lx/occ2f8dff8d8;
      // 0c3: goto 0c7
      // 0c6: athrow
      // 0c7: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 0ca: iload 1
      // 0cb: ifne 0de
      // 0ce: ifeq 153
      // 0d1: goto 0d5
      // 0d4: athrow
      // 0d5: aload 4
      // 0d7: instanceof net/minecraft/item/ItemSnowball
      // 0da: goto 0de
      // 0dd: athrow
      // 0de: iload 1
      // 0df: ifne 150
      // 0e2: ifne 14f
      // 0e5: goto 0e9
      // 0e8: athrow
      // 0e9: aload 4
      // 0eb: instanceof net/minecraft/item/ItemEgg
      // 0ee: iload 1
      // 0ef: ifne 150
      // 0f2: goto 0f6
      // 0f5: athrow
      // 0f6: ifne 14f
      // 0f9: goto 0fd
      // 0fc: athrow
      // 0fd: aload 4
      // 0ff: instanceof net/minecraft/item/ItemEnderPearl
      // 102: iload 1
      // 103: ifne 150
      // 106: goto 10a
      // 109: athrow
      // 10a: ifne 14f
      // 10d: goto 111
      // 110: athrow
      // 111: aload 4
      // 113: iload 1
      // 114: ifne 12b
      // 117: goto 11b
      // 11a: athrow
      // 11b: getstatic net/minecraft/init/Items.experience_bottle Lnet/minecraft/item/Item;
      // 11e: if_acmpeq 14f
      // 121: goto 125
      // 124: athrow
      // 125: aload 4
      // 127: goto 12b
      // 12a: athrow
      // 12b: instanceof net/minecraft/item/ItemPotion
      // 12e: iload 1
      // 12f: ifne 14c
      // 132: ifeq 153
      // 135: goto 139
      // 138: athrow
      // 139: aload 3
      // 13a: invokevirtual net/minecraft/item/ItemStack.getItemDamage ()I
      // 13d: iload 1
      // 13e: ifne 150
      // 141: goto 145
      // 144: athrow
      // 145: invokestatic net/minecraft/item/ItemPotion.isSplash (I)Z
      // 148: goto 14c
      // 14b: athrow
      // 14c: ifeq 153
      // 14f: bipush 1
      // 150: goto 154
      // 153: bipush 0
      // 154: ireturn
   }

   private boolean Ў() {
      boolean var1 = false;
      int var2 = -966127926 ^ 351258287;

      while (true) {
         switch (var2) {
            case -1215995779:
               return true;
            case -764542527:
               if (oc69da1aa7f5.ő.objectMouseOver != null) {
                  var2 = 1052850414 ^ 351258287;
                  if (!var1) {
                     continue;
                  }
               }

               var2 = -1978046642 ^ 351258287;
               if (!var1) {
                  continue;
               }
            case -1179238743:
               return true;
            case -762984347:
               if (ocdd342096f8.f != null) {
                  var2 = -1386612730 ^ 351258287;
                  if (!var1) {
                     continue;
                  }
               }

               var2 = -436822282 ^ 351258287;
               if (!var1) {
                  continue;
               }
            case -1628003871:
               return false;
            case -249997223:
               break;
            case 707722817:
               if (oc69da1aa7f5.ő.objectMouseOver.entityHit != null) {
                  var2 = -1553291566 ^ 351258287;
                  if (!var1) {
                     continue;
                  }
               }

               var2 = -1978046642 ^ 351258287;
               if (!var1) {
                  continue;
               }
               break;
            default:
               throw null;
         }

         int var10000;
         label51: {
            label50: {
               try {
                  var10000 = oc69da1aa7f5.ő.gameSettings.keyBindAttack.isKeyDown();
                  if (var1) {
                     break label51;
                  }

                  if (var10000 == 0) {
                     break label50;
                  }
               } catch (ocbde1165e4e var3) {
                  throw var3;
               }

               var2 = -964573330 ^ 351258287;
               if (!var1) {
                  continue;
               }
            }

            var10000 = -1978046642 ^ 351258287;
         }

         var2 = var10000;
      }
   }

   private static float ҧ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: istore 0
      // 02: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 05: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 08: iload 0
      // 09: ifne 20
      // 0c: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isUsingItem ()Z
      // 0f: ifeq 26
      // 12: goto 16
      // 15: athrow
      // 16: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 19: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1c: goto 20
      // 1f: athrow
      // 20: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isRiding ()Z
      // 23: ifeq 29
      // 26: fconst_1
      // 27: freturn
      // 28: athrow
      // 29: getstatic x/oc9755810e45.Ԏ Lx/oce3cc81daa8;
      // 2c: astore 1
      // 2d: aload 1
      // 2e: iload 0
      // 2f: ifne 3a
      // 32: ifnull 49
      // 35: goto 39
      // 38: athrow
      // 39: aload 1
      // 3a: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 3d: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 40: invokevirtual x/oce3cc81daa8.Ȣ (Lnet/minecraft/entity/player/EntityPlayer;)Z
      // 43: ifeq 49
      // 46: fconst_1
      // 47: freturn
      // 48: athrow
      // 49: invokestatic x/oc4557683e94.Ҳ ()F
      // 4c: freturn
   }

   private static float f(float var0) {
      oc535a9b76fc var1 = Ņ(var0, 1.0);
      double var2 = oc69da1aa7f5.ő.thePlayer.motionX * var1.ž + oc69da1aa7f5.ő.thePlayer.motionZ * var1.Ԑ;

      try {
         if (var2 > 0.0) {
            return -1.0F;
         }
      } catch (ocbde1165e4e var4) {
         throw var4;
      }

      return 1.0F;
   }

   private static oca77e773b24 Ӊ(float param0, float param1, float param2, float param3, float param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: bipush 0
      // 001: istore 5
      // 003: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 006: ifne 00c
      // 009: aconst_null
      // 00a: areturn
      // 00b: athrow
      // 00c: invokestatic x/oc6676e7e45f.Ѽ ()F
      // 00f: fstore 6
      // 011: fload 6
      // 013: iload 5
      // 015: ifne 028
      // 018: invokestatic java/lang/Float.isFinite (F)Z
      // 01b: ifeq 036
      // 01e: goto 022
      // 021: athrow
      // 022: fload 6
      // 024: goto 028
      // 027: athrow
      // 028: iload 5
      // 02a: ifne 03d
      // 02d: fconst_0
      // 02e: fcmpg
      // 02f: ifgt 039
      // 032: goto 036
      // 035: athrow
      // 036: aconst_null
      // 037: areturn
      // 038: athrow
      // 039: fload 0
      // 03a: ldc 0.98
      // 03c: fmul
      // 03d: fstore 7
      // 03f: fload 1
      // 040: ldc 0.98
      // 042: fmul
      // 043: fstore 8
      // 045: fconst_0
      // 046: fload 8
      // 048: fload 7
      // 04a: fload 6
      // 04c: invokestatic x/oc6676e7e45f.ԋ (FFFF)Lx/oc535a9b76fc;
      // 04f: astore 9
      // 051: aload 9
      // 053: iload 5
      // 055: ifne 069
      // 058: invokevirtual x/oc535a9b76fc.ϖ ()D
      // 05b: dconst_0
      // 05c: dcmpg
      // 05d: ifgt 067
      // 060: goto 064
      // 063: athrow
      // 064: aconst_null
      // 065: areturn
      // 066: athrow
      // 067: aload 9
      // 069: fconst_0
      // 06a: invokestatic x/oc6676e7e45f.Ϲ (Lx/oc535a9b76fc;F)F
      // 06d: fstore 10
      // 06f: fload 2
      // 070: fload 10
      // 072: fsub
      // 073: fload 2
      // 074: invokestatic x/oc75d51ec7eb.Ā (FF)F
      // 077: fstore 11
      // 079: fload 11
      // 07b: fload 8
      // 07d: fload 7
      // 07f: fload 6
      // 081: invokestatic x/oc6676e7e45f.ԋ (FFFF)Lx/oc535a9b76fc;
      // 084: astore 12
      // 086: new x/oc535a9b76fc
      // 089: dup
      // 08a: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 08d: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 090: getfield net/minecraft/client/entity/EntityPlayerSP.motionX D
      // 093: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 096: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 099: getfield net/minecraft/client/entity/EntityPlayerSP.motionZ D
      // 09c: invokespecial x/oc535a9b76fc.<init> (DD)V
      // 09f: astore 13
      // 0a1: aload 13
      // 0a3: aload 12
      // 0a5: invokevirtual x/oc535a9b76fc.S (Lx/oc535a9b76fc;)V
      // 0a8: fload 2
      // 0a9: dconst_1
      // 0aa: invokestatic x/oc6676e7e45f.ʱ (FD)Lx/oc535a9b76fc;
      // 0ad: astore 14
      // 0af: fload 2
      // 0b0: dconst_1
      // 0b1: invokestatic x/oc6676e7e45f.Ņ (FD)Lx/oc535a9b76fc;
      // 0b4: astore 15
      // 0b6: aload 13
      // 0b8: aload 15
      // 0ba: invokevirtual x/oc535a9b76fc.Ȁ (Lx/oc535a9b76fc;)D
      // 0bd: dstore 16
      // 0bf: ldc2_w -0.20000000298023224
      // 0c2: ldc2_w 0.20000000298023224
      // 0c5: dload 16
      // 0c7: dneg
      // 0c8: invokestatic java/lang/Math.min (DD)D
      // 0cb: invokestatic java/lang/Math.max (DD)D
      // 0ce: dstore 18
      // 0d0: dconst_0
      // 0d1: ldc2_w 0.04000000283122063
      // 0d4: dload 18
      // 0d6: dload 18
      // 0d8: dmul
      // 0d9: dsub
      // 0da: invokestatic java/lang/Math.max (DD)D
      // 0dd: invokestatic java/lang/Math.sqrt (D)D
      // 0e0: dstore 20
      // 0e2: aload 13
      // 0e4: iload 5
      // 0e6: ifne 126
      // 0e9: aload 14
      // 0eb: invokevirtual x/oc535a9b76fc.Ȁ (Lx/oc535a9b76fc;)D
      // 0ee: dload 20
      // 0f0: dadd
      // 0f1: dconst_0
      // 0f2: dcmpg
      // 0f3: ifgt 0fd
      // 0f6: goto 0fa
      // 0f9: athrow
      // 0fa: aconst_null
      // 0fb: areturn
      // 0fc: athrow
      // 0fd: new x/oc535a9b76fc
      // 100: dup
      // 101: aload 14
      // 103: getfield x/oc535a9b76fc.ž D
      // 106: dload 20
      // 108: dmul
      // 109: aload 15
      // 10b: getfield x/oc535a9b76fc.ž D
      // 10e: dload 18
      // 110: dmul
      // 111: dadd
      // 112: aload 14
      // 114: getfield x/oc535a9b76fc.Ԑ D
      // 117: dload 20
      // 119: dmul
      // 11a: aload 15
      // 11c: getfield x/oc535a9b76fc.Ԑ D
      // 11f: dload 18
      // 121: dmul
      // 122: dadd
      // 123: invokespecial x/oc535a9b76fc.<init> (DD)V
      // 126: astore 22
      // 128: aload 22
      // 12a: fload 2
      // 12b: invokestatic x/oc6676e7e45f.Ϲ (Lx/oc535a9b76fc;F)F
      // 12e: fstore 23
      // 130: new x/oca77e773b24
      // 133: dup
      // 134: fload 3
      // 135: fload 4
      // 137: fload 11
      // 139: fload 23
      // 13b: invokespecial x/oca77e773b24.<init> (FFFF)V
      // 13e: areturn
   }

   public static float[] r(float param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: istore 1
      // 02: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 05: ifeq 20
      // 08: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0b: iload 1
      // 0c: ifne 26
      // 0f: goto 13
      // 12: athrow
      // 13: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 16: getfield net/minecraft/client/entity/EntityPlayerSP.movementInput Lnet/minecraft/util/MovementInput;
      // 19: ifnonnull 23
      // 1c: goto 20
      // 1f: athrow
      // 20: aconst_null
      // 21: areturn
      // 22: athrow
      // 23: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 26: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 29: getfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 2c: fstore 2
      // 2d: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 30: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 33: getfield net/minecraft/client/entity/EntityPlayerSP.rotationPitch F
      // 36: fstore 3
      // 37: fload 2
      // 38: fload 3
      // 39: getstatic x/oc75d51ec7eb.d [F
      // 3c: bipush 0
      // 3d: faload
      // 3e: getstatic x/oc75d51ec7eb.d [F
      // 41: bipush 1
      // 42: faload
      // 43: invokestatic x/oc75d51ec7eb.Ĩ (FFFF)[F
      // 46: astore 4
      // 48: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 4b: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 4e: getfield net/minecraft/client/entity/EntityPlayerSP.movementInput Lnet/minecraft/util/MovementInput;
      // 51: getfield net/minecraft/util/MovementInput.moveForward F
      // 54: fload 0
      // 55: fload 2
      // 56: aload 4
      // 58: bipush 0
      // 59: faload
      // 5a: aload 4
      // 5c: bipush 1
      // 5d: faload
      // 5e: invokestatic x/oc6676e7e45f.Ӊ (FFFFF)Lx/oca77e773b24;
      // 61: astore 5
      // 63: aload 5
      // 65: ifnonnull 6d
      // 68: aconst_null
      // 69: goto 86
      // 6c: athrow
      // 6d: ldc_w 1232376708
      // 70: ldc_w 1232376710
      // 73: ixor
      // 74: newarray 6
      // 76: dup
      // 77: bipush 0
      // 78: aload 5
      // 7a: getfield x/oca77e773b24.Ѭ F
      // 7d: fastore
      // 7e: dup
      // 7f: bipush 1
      // 80: aload 5
      // 82: getfield x/oca77e773b24.Ȓ F
      // 85: fastore
      // 86: areturn
   }

   private static float Ѽ() {
      BlockPos var0 = new BlockPos(
         MathHelper.floor_double(oc69da1aa7f5.ő.thePlayer.posX),
         MathHelper.floor_double(oc69da1aa7f5.ő.thePlayer.getEntityBoundingBox().minY) - 1,
         MathHelper.floor_double(oc69da1aa7f5.ő.thePlayer.posZ)
      );
      Block var1 = oc69da1aa7f5.ő.theWorld.getBlockState(var0).getBlock();
      float var2 = var1.slipperiness * 0.91F;
      return oc69da1aa7f5.ő.thePlayer.getAIMoveSpeed() * (0.16277136F / (var2 * var2 * var2));
   }

   private static oc535a9b76fc ԋ(float param0, float param1, float param2, float param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: fload 1
      // 02: fload 1
      // 03: fmul
      // 04: fload 2
      // 05: fload 2
      // 06: fmul
      // 07: fadd
      // 08: fstore 5
      // 0a: istore 4
      // 0c: fload 5
      // 0e: ldc_w 1.0E-4
      // 11: iload 4
      // 13: ifne 38
      // 16: fcmpg
      // 17: ifge 29
      // 1a: goto 1e
      // 1d: athrow
      // 1e: new x/oc535a9b76fc
      // 21: dup
      // 22: dconst_0
      // 23: dconst_0
      // 24: invokespecial x/oc535a9b76fc.<init> (DD)V
      // 27: areturn
      // 28: athrow
      // 29: fload 5
      // 2b: invokestatic net/minecraft/util/MathHelper.sqrt_float (F)F
      // 2e: iload 4
      // 30: ifne 43
      // 33: fstore 5
      // 35: fload 5
      // 37: fconst_1
      // 38: fcmpg
      // 39: ifge 3f
      // 3c: fconst_1
      // 3d: fstore 5
      // 3f: fload 3
      // 40: fload 5
      // 42: fdiv
      // 43: fstore 6
      // 45: fload 1
      // 46: fload 6
      // 48: fmul
      // 49: fstore 1
      // 4a: fload 2
      // 4b: fload 6
      // 4d: fmul
      // 4e: fstore 2
      // 4f: fload 0
      // 50: ldc 0.017453292
      // 52: fmul
      // 53: invokestatic net/minecraft/util/MathHelper.sin (F)F
      // 56: fstore 7
      // 58: fload 0
      // 59: ldc 0.017453292
      // 5b: fmul
      // 5c: invokestatic net/minecraft/util/MathHelper.cos (F)F
      // 5f: fstore 8
      // 61: new x/oc535a9b76fc
      // 64: dup
      // 65: fload 1
      // 66: fload 8
      // 68: fmul
      // 69: fload 2
      // 6a: fload 7
      // 6c: fmul
      // 6d: fsub
      // 6e: f2d
      // 6f: fload 2
      // 70: fload 8
      // 72: fmul
      // 73: fload 1
      // 74: fload 7
      // 76: fmul
      // 77: fadd
      // 78: f2d
      // 79: invokespecial x/oc535a9b76fc.<init> (DD)V
      // 7c: areturn
   }

   private static oc535a9b76fc ʱ(float var0, double var1) {
      float var3 = var0 * (float) (Math.PI / 180.0);
      return new oc535a9b76fc(-MathHelper.sin(var3) * var1, MathHelper.cos(var3) * var1);
   }

   private static oc535a9b76fc Ņ(float var0, double var1) {
      float var3 = var0 * (float) (Math.PI / 180.0);
      return new oc535a9b76fc(MathHelper.cos(var3) * var1, MathHelper.sin(var3) * var1);
   }

   private static float Ϲ(oc535a9b76fc var0, float var1) {
      float var2 = (float)Math.toDegrees(Math.atan2(-var0.ž, var0.Ԑ));
      return oc75d51ec7eb.Ā(var2, var1);
   }
}
