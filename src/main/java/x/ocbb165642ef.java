package x;

import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;

public class ocbb165642ef {
   private static ocbb165642ef ñ = new ocbb165642ef();
   private Float մ = null;
   private Float ȩ = null;
   private Object ɼ;
   private boolean ȿ = false;
   public boolean Н = false;
   private boolean џ = false;
   private Boolean Ҵ;
   private float ֆ;
   private float ȥ;
   private float ǐ;
   private float ȁ;
   public boolean Ҙ;
   private boolean ʲ = false;
   private boolean ȵ = false;
   private Minecraft Ż = Minecraft.getMinecraft();
   private final Random ĩ = new Random();
   private Entity ő;
   private boolean ҁ;
   private boolean Ǒ;
   private int Ș = 1613267465 ^ -534216183;
   private int Ղ = 1613267465 ^ -534216183;
   private int У = 1613267465 ^ -534216183;
   private float ӕ;
   private float Ӵ;
   private float Ȑ;
   private float Ŧ;
   private float Ч;
   private float ӆ;
   private float ԉ = 1.0F;
   private float Ͽ = 1.0F;
   private float Ͼ = 1.0F;
   private float ϐ = 1.0F;
   private float Ť = 1.0F;
   private boolean Յ;
   private float Ǧ;
   private float ǵ;
   private float ʦ = 1.0F;
   private float ų = 1.0F;
   private long Ө;
   private long Ι;
   private double ʏ;
   private double Ƞ;
   private double ś;
   private double µ;
   private double Ó;
   private double Х;
   public static boolean ƛ;

   public static float ȥ(float var0, float var1) {
      return var1 + (((var0 - var1 + 180.0F) % 360.0F + 360.0F) % 360.0F - 180.0F);
   }

   public float[] Љ(Entity param1, oc86de9e2892 param2, float param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc02a3730b27.Ŧ I
      // 03: istore 4
      // 05: aload 1
      // 06: ifnull 17
      // 09: aload 0
      // 0a: getfield x/ocbb165642ef.Ż Lnet/minecraft/client/Minecraft;
      // 0d: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 10: ifnonnull 1a
      // 13: goto 17
      // 16: athrow
      // 17: aconst_null
      // 18: areturn
      // 19: athrow
      // 1a: aload 2
      // 1b: iload 4
      // 1d: ifne 2f
      // 20: getfield x/oc86de9e2892.Ӝ Ljava/lang/Float;
      // 23: ifnull 38
      // 26: goto 2a
      // 29: athrow
      // 2a: aload 2
      // 2b: goto 2f
      // 2e: athrow
      // 2f: getfield x/oc86de9e2892.Ӝ Ljava/lang/Float;
      // 32: invokevirtual java/lang/Float.floatValue ()F
      // 35: goto 3d
      // 38: getstatic x/oc75d51ec7eb.d [F
      // 3b: bipush 0
      // 3c: faload
      // 3d: fstore 5
      // 3f: aload 2
      // 40: iload 4
      // 42: ifne 54
      // 45: getfield x/oc86de9e2892.ŷ Ljava/lang/Float;
      // 48: ifnull 5d
      // 4b: goto 4f
      // 4e: athrow
      // 4f: aload 2
      // 50: goto 54
      // 53: athrow
      // 54: getfield x/oc86de9e2892.ŷ Ljava/lang/Float;
      // 57: invokevirtual java/lang/Float.floatValue ()F
      // 5a: goto 62
      // 5d: getstatic x/oc75d51ec7eb.d [F
      // 60: bipush 1
      // 61: faload
      // 62: fstore 6
      // 64: aload 1
      // 65: fload 5
      // 67: fload 6
      // 69: invokestatic x/oc75d51ec7eb.Ӄ (Lnet/minecraft/entity/Entity;FF)[F
      // 6c: astore 7
      // 6e: aload 7
      // 70: ifnonnull 76
      // 73: aconst_null
      // 74: areturn
      // 75: athrow
      // 76: fconst_1
      // 77: fload 3
      // 78: invokestatic java/lang/Math.max (FF)F
      // 7b: fstore 8
      // 7d: fload 5
      // 7f: aload 7
      // 81: bipush 0
      // 82: faload
      // 83: fload 5
      // 85: fsub
      // 86: invokestatic net/minecraft/util/MathHelper.wrapAngleTo180_float (F)F
      // 89: fload 8
      // 8b: fdiv
      // 8c: fadd
      // 8d: fstore 9
      // 8f: fload 6
      // 91: aload 7
      // 93: bipush 1
      // 94: faload
      // 95: fload 6
      // 97: fsub
      // 98: fload 8
      // 9a: fdiv
      // 9b: fadd
      // 9c: fstore 10
      // 9e: ldc 527043525
      // a0: ldc 527043527
      // a2: ixor
      // a3: newarray 6
      // a5: dup
      // a6: bipush 0
      // a7: fload 9
      // a9: fastore
      // aa: dup
      // ab: bipush 1
      // ac: fload 10
      // ae: fastore
      // af: areturn
   }

   public float[] ҁ(Entity param1, float param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc02a3730b27.Ŧ I
      // 03: istore 3
      // 04: aload 1
      // 05: ifnull 1e
      // 08: aload 0
      // 09: iload 3
      // 0a: ifne 22
      // 0d: goto 11
      // 10: athrow
      // 11: getfield x/ocbb165642ef.Ż Lnet/minecraft/client/Minecraft;
      // 14: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 17: ifnonnull 21
      // 1a: goto 1e
      // 1d: athrow
      // 1e: aconst_null
      // 1f: areturn
      // 20: athrow
      // 21: aload 0
      // 22: getfield x/ocbb165642ef.Ż Lnet/minecraft/client/Minecraft;
      // 25: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 28: getfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 2b: fstore 4
      // 2d: aload 0
      // 2e: getfield x/ocbb165642ef.Ż Lnet/minecraft/client/Minecraft;
      // 31: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 34: getfield net/minecraft/client/entity/EntityPlayerSP.rotationPitch F
      // 37: fstore 5
      // 39: aload 1
      // 3a: fload 4
      // 3c: fload 5
      // 3e: invokestatic x/oc75d51ec7eb.Ӄ (Lnet/minecraft/entity/Entity;FF)[F
      // 41: astore 6
      // 43: aload 6
      // 45: ifnonnull 4b
      // 48: aconst_null
      // 49: areturn
      // 4a: athrow
      // 4b: fconst_1
      // 4c: fload 2
      // 4d: invokestatic java/lang/Math.max (FF)F
      // 50: fstore 7
      // 52: fload 4
      // 54: aload 6
      // 56: bipush 0
      // 57: faload
      // 58: fload 4
      // 5a: fsub
      // 5b: invokestatic net/minecraft/util/MathHelper.wrapAngleTo180_float (F)F
      // 5e: fload 7
      // 60: fdiv
      // 61: fadd
      // 62: fstore 8
      // 64: fload 5
      // 66: aload 6
      // 68: bipush 1
      // 69: faload
      // 6a: fload 5
      // 6c: fsub
      // 6d: fload 7
      // 6f: fdiv
      // 70: fadd
      // 71: fstore 9
      // 73: ldc 1013328543
      // 75: ldc 1013328541
      // 77: ixor
      // 78: newarray 6
      // 7a: dup
      // 7b: bipush 0
      // 7c: fload 8
      // 7e: fastore
      // 7f: dup
      // 80: bipush 1
      // 81: fload 9
      // 83: fastore
      // 84: areturn
   }

   public float[] Ы(Entity var1, oc86de9e2892 var2, int var3) {
      return this.Ś(var1, var2, var3, 0.0, 0.0, 0.0F);
   }

   public float[] Ś(Entity var1, oc86de9e2892 var2, int var3, double var4, double var6, float var8) {
      return this.Ч(var1, var2, var3, var4, var6, var8, false, 10.0);
   }

   public float[] Ч(Entity var1, oc86de9e2892 var2, int var3, double var4, double var6, float var8, boolean var9, double var10) {
      return this.Ϭ(var1, var2, var3, var4, var6, var8, var9, var10, false, true);
   }

   public float[] Ϭ(
      Entity param1,
      oc86de9e2892 param2,
      int param3,
      double param4,
      double param6,
      float param8,
      boolean param9,
      double param10,
      boolean param12,
      boolean param13
   ) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc02a3730b27.Ŧ I
      // 03: istore 14
      // 05: aload 1
      // 06: ifnull 17
      // 09: aload 0
      // 0a: getfield x/ocbb165642ef.Ż Lnet/minecraft/client/Minecraft;
      // 0d: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 10: ifnonnull 1a
      // 13: goto 17
      // 16: athrow
      // 17: aconst_null
      // 18: areturn
      // 19: athrow
      // 1a: aload 2
      // 1b: iload 14
      // 1d: ifne 2f
      // 20: getfield x/oc86de9e2892.Ӝ Ljava/lang/Float;
      // 23: ifnull 38
      // 26: goto 2a
      // 29: athrow
      // 2a: aload 2
      // 2b: goto 2f
      // 2e: athrow
      // 2f: getfield x/oc86de9e2892.Ӝ Ljava/lang/Float;
      // 32: invokevirtual java/lang/Float.floatValue ()F
      // 35: goto 3d
      // 38: getstatic x/oc75d51ec7eb.d [F
      // 3b: bipush 0
      // 3c: faload
      // 3d: fstore 15
      // 3f: aload 2
      // 40: iload 14
      // 42: ifne 54
      // 45: getfield x/oc86de9e2892.ŷ Ljava/lang/Float;
      // 48: ifnull 5d
      // 4b: goto 4f
      // 4e: athrow
      // 4f: aload 2
      // 50: goto 54
      // 53: athrow
      // 54: getfield x/oc86de9e2892.ŷ Ljava/lang/Float;
      // 57: invokevirtual java/lang/Float.floatValue ()F
      // 5a: goto 62
      // 5d: getstatic x/oc75d51ec7eb.d [F
      // 60: bipush 1
      // 61: faload
      // 62: fstore 16
      // 64: aload 0
      // 65: aload 1
      // 66: fload 15
      // 68: fload 16
      // 6a: iload 3
      // 6b: dload 4
      // 6d: dload 6
      // 6f: fload 8
      // 71: iload 9
      // 73: dload 10
      // 75: iload 12
      // 77: iload 13
      // 79: bipush 1
      // 7a: invokevirtual x/ocbb165642ef.Ϸ (Lnet/minecraft/entity/Entity;FFIDDFZDZZZ)[F
      // 7d: areturn
   }

   public float[] ʖ(Entity var1, int var2) {
      return this.Ġ(var1, var2, 0.0, 0.0, 0.0F);
   }

   public float[] Ġ(Entity var1, int var2, double var3, double var5, float var7) {
      return this.Ӄ(var1, var2, var3, var5, var7, false, 10.0);
   }

   public float[] Ӄ(Entity var1, int var2, double var3, double var5, float var7, boolean var8, double var9) {
      return this.Ԋ(var1, var2, var3, var5, var7, var8, var9, false, true);
   }

   public float[] Ԋ(Entity param1, int param2, double param3, double param5, float param7, boolean param8, double param9, boolean param11, boolean param12) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc02a3730b27.Ŧ I
      // 03: istore 13
      // 05: aload 1
      // 06: ifnull 20
      // 09: aload 0
      // 0a: iload 13
      // 0c: ifne 24
      // 0f: goto 13
      // 12: athrow
      // 13: getfield x/ocbb165642ef.Ż Lnet/minecraft/client/Minecraft;
      // 16: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 19: ifnonnull 23
      // 1c: goto 20
      // 1f: athrow
      // 20: aconst_null
      // 21: areturn
      // 22: athrow
      // 23: aload 0
      // 24: getfield x/ocbb165642ef.Ż Lnet/minecraft/client/Minecraft;
      // 27: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 2a: getfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 2d: fstore 14
      // 2f: aload 0
      // 30: getfield x/ocbb165642ef.Ż Lnet/minecraft/client/Minecraft;
      // 33: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 36: getfield net/minecraft/client/entity/EntityPlayerSP.rotationPitch F
      // 39: fstore 15
      // 3b: aload 0
      // 3c: aload 1
      // 3d: fload 14
      // 3f: fload 15
      // 41: iload 2
      // 42: dload 3
      // 43: dload 5
      // 45: fload 7
      // 47: iload 8
      // 49: dload 9
      // 4b: iload 11
      // 4d: iload 12
      // 4f: bipush 0
      // 50: invokevirtual x/ocbb165642ef.Ϸ (Lnet/minecraft/entity/Entity;FFIDDFZDZZZ)[F
      // 53: areturn
   }

   private float[] Ϸ(
      Entity param1,
      float param2,
      float param3,
      int param4,
      double param5,
      double param7,
      float param9,
      boolean param10,
      double param11,
      boolean param13,
      boolean param14,
      boolean param15
   ) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc02a3730b27.Ŧ I
      // 03: aload 0
      // 04: aload 1
      // 05: iload 15
      // 07: iload 4
      // 09: invokevirtual x/ocbb165642ef.ȳ (Lnet/minecraft/entity/Entity;ZI)V
      // 0c: istore 16
      // 0e: iload 10
      // 10: ifeq 25
      // 13: aload 1
      // 14: dload 5
      // 16: dload 7
      // 18: dload 11
      // 1a: iload 13
      // 1c: iload 14
      // 1e: invokestatic x/oc75d51ec7eb.ӝ (Lnet/minecraft/entity/Entity;DDDZZ)Lnet/minecraft/util/Vec3;
      // 21: goto 2d
      // 24: athrow
      // 25: aload 1
      // 26: dload 5
      // 28: dload 7
      // 2a: invokestatic x/oc75d51ec7eb.қ (Lnet/minecraft/entity/Entity;DD)Lnet/minecraft/util/Vec3;
      // 2d: astore 17
      // 2f: iload 16
      // 31: ifne 57
      // 34: aload 17
      // 36: ifnonnull 44
      // 39: goto 3d
      // 3c: athrow
      // 3d: aload 0
      // 3e: invokevirtual x/ocbb165642ef.Ѥ ()V
      // 41: aconst_null
      // 42: areturn
      // 43: athrow
      // 44: aload 0
      // 45: aload 1
      // 46: aload 17
      // 48: fload 9
      // 4a: dload 11
      // 4c: iload 10
      // 4e: iload 13
      // 50: iload 14
      // 52: invokevirtual x/ocbb165642ef.ռ (Lnet/minecraft/entity/Entity;Lnet/minecraft/util/Vec3;FDZZZ)Lnet/minecraft/util/Vec3;
      // 55: astore 17
      // 57: aload 17
      // 59: getfield net/minecraft/util/Vec3.xCoord D
      // 5c: aload 17
      // 5e: getfield net/minecraft/util/Vec3.yCoord D
      // 61: aload 17
      // 63: getfield net/minecraft/util/Vec3.zCoord D
      // 66: fload 2
      // 67: fload 3
      // 68: invokestatic x/oc75d51ec7eb.ƺ (DDDFF)[F
      // 6b: astore 18
      // 6d: aload 0
      // 6e: aload 1
      // 6f: aload 17
      // 71: fload 2
      // 72: fload 3
      // 73: aload 18
      // 75: bipush 0
      // 76: faload
      // 77: aload 18
      // 79: bipush 1
      // 7a: faload
      // 7b: iload 4
      // 7d: invokevirtual x/ocbb165642ef.Θ (Lnet/minecraft/entity/Entity;Lnet/minecraft/util/Vec3;FFFFI)[F
      // 80: areturn
   }

   private void ȳ(Entity param1, boolean param2, int param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc02a3730b27.Ŧ I
      // 003: istore 4
      // 005: iload 4
      // 007: aload 0
      // 008: getfield x/ocbb165642ef.Ż Lnet/minecraft/client/Minecraft;
      // 00b: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 00e: getfield net/minecraft/client/entity/EntityPlayerSP.ticksExisted I
      // 011: istore 5
      // 013: ifne 166
      // 016: aload 0
      // 017: getfield x/ocbb165642ef.ő Lnet/minecraft/entity/Entity;
      // 01a: aload 1
      // 01b: if_acmpne 0a9
      // 01e: goto 022
      // 021: athrow
      // 022: aload 0
      // 023: iload 4
      // 025: ifne 167
      // 028: goto 02c
      // 02b: athrow
      // 02c: getfield x/ocbb165642ef.Ǒ Z
      // 02f: ifeq 0a9
      // 032: goto 036
      // 035: athrow
      // 036: aload 0
      // 037: iload 4
      // 039: ifne 167
      // 03c: goto 040
      // 03f: athrow
      // 040: getfield x/ocbb165642ef.ҁ Z
      // 043: iload 2
      // 044: if_icmpne 0a9
      // 047: goto 04b
      // 04a: athrow
      // 04b: aload 0
      // 04c: iload 4
      // 04e: ifne 167
      // 051: goto 055
      // 054: athrow
      // 055: getfield x/ocbb165642ef.Ș I
      // 058: ldc_w 1372662675
      // 05b: ldc_w -774820973
      // 05e: ixor
      // 05f: if_icmpeq 0a9
      // 062: goto 066
      // 065: athrow
      // 066: iload 5
      // 068: aload 0
      // 069: iload 4
      // 06b: ifne 083
      // 06e: goto 072
      // 071: athrow
      // 072: getfield x/ocbb165642ef.Ș I
      // 075: if_icmplt 0a9
      // 078: goto 07c
      // 07b: athrow
      // 07c: iload 5
      // 07e: aload 0
      // 07f: goto 083
      // 082: athrow
      // 083: getfield x/ocbb165642ef.Ș I
      // 086: isub
      // 087: iload 4
      // 089: ifne 0a5
      // 08c: bipush 1
      // 08d: if_icmpgt 0a9
      // 090: goto 094
      // 093: athrow
      // 094: aload 0
      // 095: iload 4
      // 097: ifne 176
      // 09a: goto 09e
      // 09d: athrow
      // 09e: getfield x/ocbb165642ef.Ղ I
      // 0a1: goto 0a5
      // 0a4: athrow
      // 0a5: iload 3
      // 0a6: if_icmpeq 175
      // 0a9: aload 0
      // 0aa: aload 1
      // 0ab: putfield x/ocbb165642ef.ő Lnet/minecraft/entity/Entity;
      // 0ae: aload 0
      // 0af: iload 2
      // 0b0: putfield x/ocbb165642ef.ҁ Z
      // 0b3: aload 0
      // 0b4: bipush 1
      // 0b5: putfield x/ocbb165642ef.Ǒ Z
      // 0b8: aload 0
      // 0b9: iload 3
      // 0ba: putfield x/ocbb165642ef.Ղ I
      // 0bd: aload 0
      // 0be: fconst_0
      // 0bf: putfield x/ocbb165642ef.ӕ F
      // 0c2: aload 0
      // 0c3: fconst_0
      // 0c4: putfield x/ocbb165642ef.Ӵ F
      // 0c7: aload 0
      // 0c8: fconst_0
      // 0c9: putfield x/ocbb165642ef.Ȑ F
      // 0cc: aload 0
      // 0cd: fconst_0
      // 0ce: putfield x/ocbb165642ef.Ŧ F
      // 0d1: aload 0
      // 0d2: fconst_0
      // 0d3: putfield x/ocbb165642ef.Ч F
      // 0d6: aload 0
      // 0d7: fconst_0
      // 0d8: putfield x/ocbb165642ef.ӆ F
      // 0db: aload 0
      // 0dc: ldc_w 0.8
      // 0df: aload 0
      // 0e0: getfield x/ocbb165642ef.ĩ Ljava/util/Random;
      // 0e3: invokevirtual java/util/Random.nextFloat ()F
      // 0e6: ldc_w 0.4
      // 0e9: fmul
      // 0ea: fadd
      // 0eb: putfield x/ocbb165642ef.ԉ F
      // 0ee: aload 0
      // 0ef: ldc_w 0.85
      // 0f2: aload 0
      // 0f3: getfield x/ocbb165642ef.ĩ Ljava/util/Random;
      // 0f6: invokevirtual java/util/Random.nextFloat ()F
      // 0f9: ldc_w 0.3
      // 0fc: fmul
      // 0fd: fadd
      // 0fe: putfield x/ocbb165642ef.Ͽ F
      // 101: aload 0
      // 102: ldc_w 0.85
      // 105: aload 0
      // 106: getfield x/ocbb165642ef.ĩ Ljava/util/Random;
      // 109: invokevirtual java/util/Random.nextFloat ()F
      // 10c: ldc_w 0.3
      // 10f: fmul
      // 110: fadd
      // 111: putfield x/ocbb165642ef.Ͼ F
      // 114: aload 0
      // 115: ldc_w 0.85
      // 118: aload 0
      // 119: getfield x/ocbb165642ef.ĩ Ljava/util/Random;
      // 11c: invokevirtual java/util/Random.nextFloat ()F
      // 11f: ldc_w 0.3
      // 122: fmul
      // 123: fadd
      // 124: putfield x/ocbb165642ef.ϐ F
      // 127: aload 0
      // 128: aload 0
      // 129: invokevirtual x/ocbb165642ef.U ()F
      // 12c: putfield x/ocbb165642ef.Ť F
      // 12f: aload 0
      // 130: lconst_0
      // 131: putfield x/ocbb165642ef.Ι J
      // 134: aload 0
      // 135: bipush 0
      // 136: putfield x/ocbb165642ef.Յ Z
      // 139: aload 0
      // 13a: fconst_1
      // 13b: putfield x/ocbb165642ef.ʦ F
      // 13e: aload 0
      // 13f: fconst_1
      // 140: putfield x/ocbb165642ef.ų F
      // 143: aload 0
      // 144: lconst_0
      // 145: putfield x/ocbb165642ef.Ө J
      // 148: aload 0
      // 149: ldc_w 1372662675
      // 14c: ldc_w -774820973
      // 14f: ixor
      // 150: putfield x/ocbb165642ef.У I
      // 153: aload 0
      // 154: aload 0
      // 155: aload 0
      // 156: dconst_0
      // 157: dup2_x1
      // 158: putfield x/ocbb165642ef.ś D
      // 15b: dup2_x1
      // 15c: putfield x/ocbb165642ef.Ƞ D
      // 15f: putfield x/ocbb165642ef.ʏ D
      // 162: goto 166
      // 165: athrow
      // 166: aload 0
      // 167: aload 0
      // 168: aload 0
      // 169: dconst_0
      // 16a: dup2_x1
      // 16b: putfield x/ocbb165642ef.Х D
      // 16e: dup2_x1
      // 16f: putfield x/ocbb165642ef.Ó D
      // 172: putfield x/ocbb165642ef.µ D
      // 175: aload 0
      // 176: iload 5
      // 178: putfield x/ocbb165642ef.Ș I
      // 17b: return
   }

   private Vec3 ռ(Entity var1, Vec3 var2, float var3, double var4, boolean var6, boolean var7, boolean var8) {
      float var10 = MathHelper.clamp_float(var3 / 100.0F, 0.0F, 1.0F);
      int var10000 = oc02a3730b27.Ŧ;
      this.ȏ(var10);
      int var9 = var10000;

      try {
         if (var10 <= 0.001F) {
            return var2;
         }
      } catch (ocbde1165e4e var29) {
         throw var29;
      }

      double var11 = var1.posX - var1.lastTickPosX;
      double var13 = var1.posZ - var1.lastTickPosZ;
      double var15 = 1.0 + Math.min(0.5, Math.sqrt(var11 * var11 + var13 * var13));
      float var17 = var1.getCollisionBorderSize();
      AxisAlignedBB var18 = var1.getEntityBoundingBox().expand(var17, var17, var17);
      double var19 = ӟ(var2.xCoord + this.ʏ * var15, var18.minX, var18.maxX);
      double var21 = ӟ(var2.yCoord + this.Ƞ, var18.minY, var18.maxY);
      double var23 = ӟ(var2.zCoord + this.ś * var15, var18.minZ, var18.maxZ);
      Vec3 var25 = new Vec3(var19, var21, var23);

      try {
         if (!var6) {
            return var25;
         }

         var30 = this.Ż.thePlayer.getPositionEyes(1.0F);
         if (var9 != 0) {
            return var30;
         }
      } catch (ocbde1165e4e var28) {
         throw var28;
      }

      Vec3 var26 = var30;

      try {
         if (!oc75d51ec7eb.ц(var26, var25, var1, var4, var7, var8)) {
            return var2;
         }
      } catch (ocbde1165e4e var27) {
         throw var27;
      }

      return var25;
   }

   private void ȏ(float param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc02a3730b27.Ŧ I
      // 003: istore 2
      // 004: iload 2
      // 005: aload 0
      // 006: getfield x/ocbb165642ef.Ż Lnet/minecraft/client/Minecraft;
      // 009: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 00c: getfield net/minecraft/client/entity/EntityPlayerSP.ticksExisted I
      // 00f: istore 3
      // 010: ifne 026
      // 013: aload 0
      // 014: getfield x/ocbb165642ef.У I
      // 017: iload 3
      // 018: if_icmpne 021
      // 01b: goto 01f
      // 01e: athrow
      // 01f: return
      // 020: athrow
      // 021: aload 0
      // 022: iload 3
      // 023: putfield x/ocbb165642ef.У I
      // 026: invokestatic java/lang/System.currentTimeMillis ()J
      // 029: lstore 4
      // 02b: iload 2
      // 02c: ifne 092
      // 02f: lload 4
      // 031: aload 0
      // 032: getfield x/ocbb165642ef.Ө J
      // 035: lcmp
      // 036: iflt 0ae
      // 039: goto 03d
      // 03c: athrow
      // 03d: aload 0
      // 03e: lload 4
      // 040: ldc2_w 4761320505762898152
      // 043: ldc2_w 4761320505762898060
      // 046: lxor
      // 047: ladd
      // 048: aload 0
      // 049: getfield x/ocbb165642ef.ĩ Ljava/util/Random;
      // 04c: ldc_w -1101309756
      // 04f: ldc_w -1101309119
      // 052: ixor
      // 053: invokevirtual java/util/Random.nextInt (I)I
      // 056: i2l
      // 057: ladd
      // 058: putfield x/ocbb165642ef.Ө J
      // 05b: aload 0
      // 05c: aload 0
      // 05d: ldc2_w -0.15
      // 060: ldc2_w 0.15
      // 063: invokevirtual x/ocbb165642ef.Ɍ (DD)D
      // 066: fload 1
      // 067: f2d
      // 068: dmul
      // 069: putfield x/ocbb165642ef.µ D
      // 06c: aload 0
      // 06d: aload 0
      // 06e: ldc2_w -0.3
      // 071: ldc2_w 0.25
      // 074: invokevirtual x/ocbb165642ef.Ɍ (DD)D
      // 077: fload 1
      // 078: f2d
      // 079: dmul
      // 07a: putfield x/ocbb165642ef.Ó D
      // 07d: aload 0
      // 07e: aload 0
      // 07f: ldc2_w -0.15
      // 082: ldc2_w 0.15
      // 085: invokevirtual x/ocbb165642ef.Ɍ (DD)D
      // 088: fload 1
      // 089: f2d
      // 08a: dmul
      // 08b: putfield x/ocbb165642ef.Х D
      // 08e: goto 092
      // 091: athrow
      // 092: ldc_w 0.6
      // 095: fload 1
      // 096: fmul
      // 097: fstore 6
      // 099: aload 0
      // 09a: fconst_1
      // 09b: fload 6
      // 09d: fconst_2
      // 09e: fdiv
      // 09f: fsub
      // 0a0: aload 0
      // 0a1: getfield x/ocbb165642ef.ĩ Ljava/util/Random;
      // 0a4: invokevirtual java/util/Random.nextFloat ()F
      // 0a7: fload 6
      // 0a9: fmul
      // 0aa: fadd
      // 0ab: putfield x/ocbb165642ef.ų F
      // 0ae: ldc2_w 0.01
      // 0b1: aload 0
      // 0b2: getfield x/ocbb165642ef.ĩ Ljava/util/Random;
      // 0b5: invokevirtual java/util/Random.nextDouble ()D
      // 0b8: ldc2_w 0.05
      // 0bb: dmul
      // 0bc: dadd
      // 0bd: fload 1
      // 0be: ldc_w 0.05
      // 0c1: invokestatic java/lang/Math.max (FF)F
      // 0c4: f2d
      // 0c5: dmul
      // 0c6: dstore 6
      // 0c8: aload 0
      // 0c9: aload 0
      // 0ca: getfield x/ocbb165642ef.ʏ D
      // 0cd: aload 0
      // 0ce: getfield x/ocbb165642ef.µ D
      // 0d1: dload 6
      // 0d3: invokestatic x/ocbb165642ef.ȿ (DDD)D
      // 0d6: putfield x/ocbb165642ef.ʏ D
      // 0d9: aload 0
      // 0da: aload 0
      // 0db: getfield x/ocbb165642ef.Ƞ D
      // 0de: aload 0
      // 0df: getfield x/ocbb165642ef.Ó D
      // 0e2: dload 6
      // 0e4: invokestatic x/ocbb165642ef.ȿ (DDD)D
      // 0e7: putfield x/ocbb165642ef.Ƞ D
      // 0ea: aload 0
      // 0eb: aload 0
      // 0ec: getfield x/ocbb165642ef.ś D
      // 0ef: aload 0
      // 0f0: getfield x/ocbb165642ef.Х D
      // 0f3: dload 6
      // 0f5: invokestatic x/ocbb165642ef.ȿ (DDD)D
      // 0f8: putfield x/ocbb165642ef.ś D
      // 0fb: aload 0
      // 0fc: aload 0
      // 0fd: getfield x/ocbb165642ef.ʦ F
      // 100: f2d
      // 101: aload 0
      // 102: getfield x/ocbb165642ef.ų F
      // 105: f2d
      // 106: ldc2_w 0.04
      // 109: invokestatic x/ocbb165642ef.ȿ (DDD)D
      // 10c: d2f
      // 10d: putfield x/ocbb165642ef.ʦ F
      // 110: return
   }

   private float[] Θ(Entity param1, Vec3 param2, float param3, float param4, float param5, float param6, int param7) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc02a3730b27.Ŧ I
      // 003: istore 8
      // 005: iload 7
      // 007: iload 8
      // 009: ifne 022
      // 00c: ifgt 031
      // 00f: goto 013
      // 012: athrow
      // 013: aload 0
      // 014: invokevirtual x/ocbb165642ef.Ѥ ()V
      // 017: ldc_w -440820498
      // 01a: ldc_w -440820500
      // 01d: ixor
      // 01e: goto 022
      // 021: athrow
      // 022: newarray 6
      // 024: dup
      // 025: bipush 0
      // 026: fload 3
      // 027: fastore
      // 028: dup
      // 029: bipush 1
      // 02a: fload 4
      // 02c: invokestatic x/oc75d51ec7eb.À (F)F
      // 02f: fastore
      // 030: areturn
      // 031: invokestatic x/oc75d51ec7eb.ʟ ()D
      // 034: d2f
      // 035: fstore 9
      // 037: fload 9
      // 039: fconst_0
      // 03a: fcmpg
      // 03b: iload 8
      // 03d: ifne 059
      // 040: ifgt 055
      // 043: goto 047
      // 046: athrow
      // 047: fload 3
      // 048: fload 4
      // 04a: fload 5
      // 04c: fload 6
      // 04e: iload 7
      // 050: invokestatic x/oc75d51ec7eb.ɍ (FFFFI)[F
      // 053: areturn
      // 054: athrow
      // 055: aload 0
      // 056: getfield x/ocbb165642ef.Յ Z
      // 059: iload 8
      // 05b: ifne 089
      // 05e: ifeq 0b9
      // 061: goto 065
      // 064: athrow
      // 065: fload 3
      // 066: aload 0
      // 067: getfield x/ocbb165642ef.Ǧ F
      // 06a: fsub
      // 06b: invokestatic net/minecraft/util/MathHelper.wrapAngleTo180_float (F)F
      // 06e: invokestatic java/lang/Math.abs (F)F
      // 071: iload 8
      // 073: ifne 09a
      // 076: goto 07a
      // 079: athrow
      // 07a: ldc_w 0.5
      // 07d: fload 9
      // 07f: fconst_2
      // 080: fmul
      // 081: invokestatic java/lang/Math.max (FF)F
      // 084: fcmpl
      // 085: goto 089
      // 088: athrow
      // 089: ifgt 0b1
      // 08c: fload 4
      // 08e: aload 0
      // 08f: getfield x/ocbb165642ef.ǵ F
      // 092: fsub
      // 093: invokestatic java/lang/Math.abs (F)F
      // 096: goto 09a
      // 099: athrow
      // 09a: ldc_w 0.5
      // 09d: iload 8
      // 09f: ifne 0bc
      // 0a2: fload 9
      // 0a4: fconst_2
      // 0a5: fmul
      // 0a6: invokestatic java/lang/Math.max (FF)F
      // 0a9: fcmpl
      // 0aa: ifle 0b9
      // 0ad: goto 0b1
      // 0b0: athrow
      // 0b1: aload 0
      // 0b2: invokevirtual x/ocbb165642ef.Ѥ ()V
      // 0b5: goto 0b9
      // 0b8: athrow
      // 0b9: fload 5
      // 0bb: fload 3
      // 0bc: fsub
      // 0bd: invokestatic net/minecraft/util/MathHelper.wrapAngleTo180_float (F)F
      // 0c0: fstore 10
      // 0c2: fload 6
      // 0c4: fload 4
      // 0c6: fsub
      // 0c7: fstore 11
      // 0c9: aload 0
      // 0ca: getfield x/ocbb165642ef.Ч F
      // 0cd: fstore 12
      // 0cf: aload 0
      // 0d0: getfield x/ocbb165642ef.ӆ F
      // 0d3: fstore 13
      // 0d5: aload 1
      // 0d6: getfield net/minecraft/entity/Entity.posX D
      // 0d9: aload 1
      // 0da: getfield net/minecraft/entity/Entity.lastTickPosX D
      // 0dd: dsub
      // 0de: dstore 14
      // 0e0: aload 1
      // 0e1: getfield net/minecraft/entity/Entity.posZ D
      // 0e4: aload 1
      // 0e5: getfield net/minecraft/entity/Entity.lastTickPosZ D
      // 0e8: dsub
      // 0e9: dstore 16
      // 0eb: dload 14
      // 0ed: dload 14
      // 0ef: dmul
      // 0f0: dload 16
      // 0f2: dload 16
      // 0f4: dmul
      // 0f5: dadd
      // 0f6: invokestatic java/lang/Math.sqrt (D)D
      // 0f9: dstore 18
      // 0fb: aload 0
      // 0fc: getfield x/ocbb165642ef.Ż Lnet/minecraft/client/Minecraft;
      // 0ff: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 102: getfield net/minecraft/client/entity/EntityPlayerSP.motionX D
      // 105: aload 0
      // 106: getfield x/ocbb165642ef.Ż Lnet/minecraft/client/Minecraft;
      // 109: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 10c: getfield net/minecraft/client/entity/EntityPlayerSP.motionX D
      // 10f: dmul
      // 110: aload 0
      // 111: getfield x/ocbb165642ef.Ż Lnet/minecraft/client/Minecraft;
      // 114: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 117: getfield net/minecraft/client/entity/EntityPlayerSP.motionZ D
      // 11a: aload 0
      // 11b: getfield x/ocbb165642ef.Ż Lnet/minecraft/client/Minecraft;
      // 11e: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 121: getfield net/minecraft/client/entity/EntityPlayerSP.motionZ D
      // 124: dmul
      // 125: dadd
      // 126: invokestatic java/lang/Math.sqrt (D)D
      // 129: dstore 20
      // 12b: aload 0
      // 12c: aload 2
      // 12d: invokevirtual x/ocbb165642ef.Ɉ (Lnet/minecraft/util/Vec3;)D
      // 130: dstore 22
      // 132: ldc_w 0.45
      // 135: aload 0
      // 136: getfield x/ocbb165642ef.Ͽ F
      // 139: fmul
      // 13a: fstore 24
      // 13c: ldc_w 0.91
      // 13f: aload 0
      // 140: getfield x/ocbb165642ef.ϐ F
      // 143: fmul
      // 144: fstore 25
      // 146: fload 10
      // 148: iload 8
      // 14a: ifne 162
      // 14d: invokestatic java/lang/Math.abs (F)F
      // 150: ldc_w 20.0
      // 153: fcmpg
      // 154: ifge 165
      // 157: goto 15b
      // 15a: athrow
      // 15b: ldc_w 0.05
      // 15e: goto 162
      // 161: athrow
      // 162: goto 168
      // 165: ldc_w 0.1
      // 168: aload 0
      // 169: getfield x/ocbb165642ef.ԉ F
      // 16c: fmul
      // 16d: fstore 26
      // 16f: ldc_w 0.33
      // 172: aload 0
      // 173: getfield x/ocbb165642ef.Ͼ F
      // 176: fmul
      // 177: fstore 27
      // 179: aload 0
      // 17a: getfield x/ocbb165642ef.Ż Lnet/minecraft/client/Minecraft;
      // 17d: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 180: getfield net/minecraft/client/entity/EntityPlayerSP.motionY D
      // 183: invokestatic java/lang/Math.abs (D)D
      // 186: ldc2_w 0.1
      // 189: dcmpl
      // 18a: iload 8
      // 18c: ifne 1b3
      // 18f: ifle 1a8
      // 192: goto 196
      // 195: athrow
      // 196: fload 11
      // 198: fconst_1
      // 199: aload 0
      // 19a: getfield x/ocbb165642ef.ĩ Ljava/util/Random;
      // 19d: invokevirtual java/util/Random.nextFloat ()F
      // 1a0: ldc_w 0.32
      // 1a3: fmul
      // 1a4: fadd
      // 1a5: fmul
      // 1a6: fstore 11
      // 1a8: fload 10
      // 1aa: invokestatic java/lang/Math.signum (F)F
      // 1ad: fload 12
      // 1af: invokestatic java/lang/Math.signum (F)F
      // 1b2: fcmpl
      // 1b3: iload 8
      // 1b5: ifne 1c0
      // 1b8: ifne 1c3
      // 1bb: goto 1bf
      // 1be: athrow
      // 1bf: bipush 1
      // 1c0: goto 1c4
      // 1c3: bipush 0
      // 1c4: istore 28
      // 1c6: iload 28
      // 1c8: iload 8
      // 1ca: ifne 217
      // 1cd: ifeq 208
      // 1d0: goto 1d4
      // 1d3: athrow
      // 1d4: fload 10
      // 1d6: invokestatic java/lang/Math.abs (F)F
      // 1d9: ldc_w 20.0
      // 1dc: fcmpg
      // 1dd: iload 8
      // 1df: ifne 217
      // 1e2: goto 1e6
      // 1e5: athrow
      // 1e6: ifge 208
      // 1e9: goto 1ed
      // 1ec: athrow
      // 1ed: fload 26
      // 1ef: ldc_w 2.5
      // 1f2: fmul
      // 1f3: fstore 26
      // 1f5: fload 12
      // 1f7: dconst_1
      // 1f8: dload 18
      // 1fa: dload 20
      // 1fc: dadd
      // 1fd: ldc2_w 0.25
      // 200: invokestatic java/lang/Math.min (DD)D
      // 203: dadd
      // 204: d2f
      // 205: fmul
      // 206: fstore 12
      // 208: dload 22
      // 20a: iload 8
      // 20c: ifne 224
      // 20f: ldc2_w 0.8
      // 212: dcmpg
      // 213: goto 217
      // 216: athrow
      // 217: ifge 239
      // 21a: dload 22
      // 21c: ldc2_w 0.8
      // 21f: ddiv
      // 220: goto 224
      // 223: athrow
      // 224: dstore 29
      // 226: fload 11
      // 228: dload 29
      // 22a: dload 29
      // 22c: dmul
      // 22d: d2f
      // 22e: fmul
      // 22f: fstore 11
      // 231: fload 10
      // 233: dload 29
      // 235: d2f
      // 236: fmul
      // 237: fstore 10
      // 239: ldc_w 0.05
      // 23c: fstore 29
      // 23e: fload 11
      // 240: fload 13
      // 242: fsub
      // 243: fload 12
      // 245: fload 29
      // 247: iload 8
      // 249: ifne 262
      // 24c: fmul
      // 24d: aload 0
      // 24e: getfield x/ocbb165642ef.ĩ Ljava/util/Random;
      // 251: invokevirtual java/util/Random.nextBoolean ()Z
      // 254: ifeq 265
      // 257: goto 25b
      // 25a: athrow
      // 25b: ldc_w -1.0
      // 25e: goto 262
      // 261: athrow
      // 262: goto 266
      // 265: fconst_1
      // 266: fmul
      // 267: fadd
      // 268: fstore 30
      // 26a: iload 8
      // 26c: fload 10
      // 26e: fload 12
      // 270: fsub
      // 271: fstore 31
      // 273: aload 0
      // 274: aload 0
      // 275: getfield x/ocbb165642ef.Ŧ F
      // 278: fload 30
      // 27a: fload 29
      // 27c: fmul
      // 27d: fadd
      // 27e: ldc_w 45.0
      // 281: invokestatic x/ocbb165642ef.Ԑ (FF)F
      // 284: putfield x/ocbb165642ef.Ŧ F
      // 287: aload 0
      // 288: aload 0
      // 289: getfield x/ocbb165642ef.Ȑ F
      // 28c: fload 31
      // 28e: fload 29
      // 290: fmul
      // 291: fadd
      // 292: ldc_w 60.0
      // 295: invokestatic x/ocbb165642ef.Ԑ (FF)F
      // 298: putfield x/ocbb165642ef.Ȑ F
      // 29b: fload 24
      // 29d: fload 30
      // 29f: fmul
      // 2a0: fload 25
      // 2a2: aload 0
      // 2a3: getfield x/ocbb165642ef.Ŧ F
      // 2a6: fmul
      // 2a7: fadd
      // 2a8: fstore 32
      // 2aa: fload 26
      // 2ac: fload 31
      // 2ae: fmul
      // 2af: fload 27
      // 2b1: aload 0
      // 2b2: getfield x/ocbb165642ef.Ȑ F
      // 2b5: fmul
      // 2b6: fadd
      // 2b7: fstore 33
      // 2b9: ifne 2d5
      // 2bc: fload 10
      // 2be: invokestatic java/lang/Math.abs (F)F
      // 2c1: ldc_w 120.0
      // 2c4: fcmpl
      // 2c5: ifle 2d8
      // 2c8: goto 2cc
      // 2cb: athrow
      // 2cc: aload 0
      // 2cd: fconst_0
      // 2ce: putfield x/ocbb165642ef.Ȑ F
      // 2d1: goto 2d5
      // 2d4: athrow
      // 2d5: fconst_0
      // 2d6: fstore 33
      // 2d8: aload 0
      // 2d9: iload 8
      // 2db: ifne 2f5
      // 2de: getfield x/ocbb165642ef.Ż Lnet/minecraft/client/Minecraft;
      // 2e1: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 2e4: ifnull 2f9
      // 2e7: goto 2eb
      // 2ea: athrow
      // 2eb: aload 0
      // 2ec: fconst_0
      // 2ed: putfield x/ocbb165642ef.Ȑ F
      // 2f0: aload 0
      // 2f1: goto 2f5
      // 2f4: athrow
      // 2f5: fconst_0
      // 2f6: putfield x/ocbb165642ef.Ŧ F
      // 2f9: fload 3
      // 2fa: fload 10
      // 2fc: fadd
      // 2fd: fload 33
      // 2ff: ldc_w 3.0
      // 302: fdiv
      // 303: fadd
      // 304: fstore 34
      // 306: fload 4
      // 308: fload 32
      // 30a: fadd
      // 30b: fstore 35
      // 30d: aload 0
      // 30e: invokevirtual x/ocbb165642ef.Ί ()V
      // 311: iload 7
      // 313: invokestatic x/ocbb165642ef.ј (I)F
      // 316: fstore 36
      // 318: fload 36
      // 31a: aload 0
      // 31b: getfield x/ocbb165642ef.Ť F
      // 31e: fmul
      // 31f: aload 0
      // 320: getfield x/ocbb165642ef.ʦ F
      // 323: fmul
      // 324: fstore 37
      // 326: aload 0
      // 327: getfield x/ocbb165642ef.Ż Lnet/minecraft/client/Minecraft;
      // 32a: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 32d: getfield net/minecraft/client/settings/GameSettings.mouseSensitivity F
      // 330: ldc_w 0.6
      // 333: fmul
      // 334: ldc_w 0.2
      // 337: fadd
      // 338: fstore 38
      // 33a: fload 38
      // 33c: fload 38
      // 33e: fmul
      // 33f: fload 38
      // 341: fmul
      // 342: ldc_w 8.0
      // 345: fmul
      // 346: fstore 39
      // 348: fload 39
      // 34a: iload 8
      // 34c: ifne 35e
      // 34f: fconst_0
      // 350: fcmpg
      // 351: ifgt 35d
      // 354: goto 358
      // 357: athrow
      // 358: fconst_1
      // 359: goto 361
      // 35c: athrow
      // 35d: fconst_1
      // 35e: fload 39
      // 360: fdiv
      // 361: fstore 40
      // 363: fload 37
      // 365: ldc_w 0.25
      // 368: fmul
      // 369: ldc_w 50.0
      // 36c: fmul
      // 36d: fload 40
      // 36f: fmul
      // 370: fstore 41
      // 372: fload 34
      // 374: fload 3
      // 375: fsub
      // 376: invokestatic net/minecraft/util/MathHelper.wrapAngleTo180_float (F)F
      // 379: fstore 42
      // 37b: fload 35
      // 37d: fload 4
      // 37f: fsub
      // 380: fstore 43
      // 382: aload 0
      // 383: aload 0
      // 384: aload 0
      // 385: getfield x/ocbb165642ef.ӕ F
      // 388: fload 42
      // 38a: fload 41
      // 38c: fload 9
      // 38e: invokevirtual x/ocbb165642ef.ó (FFFF)F
      // 391: putfield x/ocbb165642ef.ӕ F
      // 394: aload 0
      // 395: aload 0
      // 396: aload 0
      // 397: getfield x/ocbb165642ef.Ӵ F
      // 39a: fload 43
      // 39c: fload 41
      // 39e: fload 9
      // 3a0: invokevirtual x/ocbb165642ef.ó (FFFF)F
      // 3a3: putfield x/ocbb165642ef.Ӵ F
      // 3a6: aload 0
      // 3a7: getfield x/ocbb165642ef.ӕ F
      // 3aa: f2i
      // 3ab: istore 44
      // 3ad: aload 0
      // 3ae: getfield x/ocbb165642ef.Ӵ F
      // 3b1: f2i
      // 3b2: istore 45
      // 3b4: aload 0
      // 3b5: dup
      // 3b6: getfield x/ocbb165642ef.ӕ F
      // 3b9: iload 44
      // 3bb: i2f
      // 3bc: fsub
      // 3bd: putfield x/ocbb165642ef.ӕ F
      // 3c0: aload 0
      // 3c1: dup
      // 3c2: getfield x/ocbb165642ef.Ӵ F
      // 3c5: iload 45
      // 3c7: i2f
      // 3c8: fsub
      // 3c9: putfield x/ocbb165642ef.Ӵ F
      // 3cc: fload 3
      // 3cd: iload 44
      // 3cf: i2f
      // 3d0: fload 9
      // 3d2: fmul
      // 3d3: fadd
      // 3d4: fload 3
      // 3d5: invokestatic x/oc75d51ec7eb.Ā (FF)F
      // 3d8: fstore 46
      // 3da: fload 4
      // 3dc: iload 45
      // 3de: i2f
      // 3df: fload 9
      // 3e1: fmul
      // 3e2: fadd
      // 3e3: invokestatic x/oc75d51ec7eb.À (F)F
      // 3e6: fstore 47
      // 3e8: aload 0
      // 3e9: fload 46
      // 3eb: fload 3
      // 3ec: fsub
      // 3ed: invokestatic net/minecraft/util/MathHelper.wrapAngleTo180_float (F)F
      // 3f0: putfield x/ocbb165642ef.Ч F
      // 3f3: aload 0
      // 3f4: fload 47
      // 3f6: fload 4
      // 3f8: fsub
      // 3f9: putfield x/ocbb165642ef.ӆ F
      // 3fc: aload 0
      // 3fd: fload 46
      // 3ff: putfield x/ocbb165642ef.Ǧ F
      // 402: aload 0
      // 403: fload 47
      // 405: putfield x/ocbb165642ef.ǵ F
      // 408: aload 0
      // 409: bipush 1
      // 40a: putfield x/ocbb165642ef.Յ Z
      // 40d: ldc_w -440820498
      // 410: ldc_w -440820500
      // 413: ixor
      // 414: newarray 6
      // 416: dup
      // 417: bipush 0
      // 418: fload 46
      // 41a: fastore
      // 41b: dup
      // 41c: bipush 1
      // 41d: fload 47
      // 41f: fastore
      // 420: areturn
   }

   private float ó(float param1, float param2, float param3, float param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc02a3730b27.Ŧ I
      // 03: istore 5
      // 05: fload 2
      // 06: invokestatic java/lang/Math.abs (F)F
      // 09: fload 4
      // 0b: iload 5
      // 0d: ifne 28
      // 10: ldc_w 0.5
      // 13: fmul
      // 14: fcmpg
      // 15: ifgt 1f
      // 18: goto 1c
      // 1b: athrow
      // 1c: fconst_0
      // 1d: freturn
      // 1e: athrow
      // 1f: fload 1
      // 20: fload 2
      // 21: invokestatic x/ocbb165642ef.н (FF)F
      // 24: fstore 1
      // 25: fload 2
      // 26: fload 4
      // 28: fdiv
      // 29: invokestatic java/lang/Math.abs (F)F
      // 2c: fstore 6
      // 2e: fconst_0
      // 2f: fload 6
      // 31: fload 1
      // 32: invokestatic java/lang/Math.abs (F)F
      // 35: fsub
      // 36: invokestatic java/lang/Math.max (FF)F
      // 39: fstore 7
      // 3b: fload 3
      // 3c: fload 7
      // 3e: invokestatic java/lang/Math.min (FF)F
      // 41: fstore 8
      // 43: fload 2
      // 44: iload 5
      // 46: ifne 5b
      // 49: fconst_0
      // 4a: fcmpl
      // 4b: ifle 5a
      // 4e: goto 52
      // 51: athrow
      // 52: fload 1
      // 53: fload 8
      // 55: fadd
      // 56: goto 5e
      // 59: athrow
      // 5a: fload 1
      // 5b: fload 8
      // 5d: fsub
      // 5e: freturn
   }

   private static float н(float param0, float param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc02a3730b27.Ŧ I
      // 03: istore 2
      // 04: fload 0
      // 05: iload 2
      // 06: ifne 29
      // 09: fconst_0
      // 0a: fcmpl
      // 0b: ifle 24
      // 0e: goto 12
      // 11: athrow
      // 12: fload 1
      // 13: iload 2
      // 14: ifne 4d
      // 17: goto 1b
      // 1a: athrow
      // 1b: fconst_0
      // 1c: fcmpg
      // 1d: iflt 48
      // 20: goto 24
      // 23: athrow
      // 24: fload 0
      // 25: goto 29
      // 28: athrow
      // 29: iload 2
      // 2a: ifne 4f
      // 2d: fconst_0
      // 2e: fcmpg
      // 2f: ifge 4e
      // 32: goto 36
      // 35: athrow
      // 36: fload 1
      // 37: iload 2
      // 38: ifne 4f
      // 3b: goto 3f
      // 3e: athrow
      // 3f: fconst_0
      // 40: fcmpl
      // 41: ifle 4e
      // 44: goto 48
      // 47: athrow
      // 48: fconst_0
      // 49: goto 4d
      // 4c: athrow
      // 4d: freturn
      // 4e: fload 0
      // 4f: freturn
   }

   private void Ί() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc02a3730b27.Ŧ I
      // 03: istore 1
      // 04: iload 1
      // 05: invokestatic java/lang/System.currentTimeMillis ()J
      // 08: lstore 2
      // 09: ifne 40
      // 0c: lload 2
      // 0d: aload 0
      // 0e: getfield x/ocbb165642ef.Ι J
      // 11: lcmp
      // 12: ifge 1b
      // 15: goto 19
      // 18: athrow
      // 19: return
      // 1a: athrow
      // 1b: aload 0
      // 1c: lload 2
      // 1d: ldc2_w -1405284504512455574
      // 20: ldc2_w -1405284504512455458
      // 23: lxor
      // 24: ladd
      // 25: aload 0
      // 26: getfield x/ocbb165642ef.ĩ Ljava/util/Random;
      // 29: ldc_w -141274550
      // 2c: ldc_w -141274357
      // 2f: ixor
      // 30: invokevirtual java/util/Random.nextInt (I)I
      // 33: i2l
      // 34: ladd
      // 35: putfield x/ocbb165642ef.Ι J
      // 38: aload 0
      // 39: aload 0
      // 3a: invokevirtual x/ocbb165642ef.U ()F
      // 3d: putfield x/ocbb165642ef.Ť F
      // 40: return
   }

   private float U() {
      double var1 = Math.max(1.0E-4, this.ĩ.nextDouble());
      double var3 = this.ĩ.nextDouble();
      double var5 = Math.sqrt(-2.0 * Math.log(var1)) * Math.cos((Math.PI * 2) * var3);
      double var7 = Math.exp(0.65 + 0.25 * var5);
      return (float)Math.max(1.4, Math.min(3.0, var7));
   }

   private static float ј(int var0) {
      float var1 = MathHelper.clamp_float((var0 - 1.0F) / 29.0F, 0.0F, 1.0F);
      return 1.0F + var1 * 9.0F;
   }

   private double Ɉ(Vec3 var1) {
      double var2 = var1.xCoord - this.Ż.thePlayer.posX;
      double var4 = var1.yCoord - (this.Ż.thePlayer.posY + this.Ż.thePlayer.getEyeHeight());
      double var6 = var1.zCoord - this.Ż.thePlayer.posZ;
      return Math.sqrt(var2 * var2 + var4 * var4 + var6 * var6);
   }

   private static float Ԑ(float var0, float var1) {
      return MathHelper.clamp_float(var0, -var1, var1);
   }

   private void Ѥ() {
      this.ӕ = 0.0F;
      this.Ӵ = 0.0F;
      this.Ȑ = 0.0F;
      this.Ŧ = 0.0F;
      this.Ч = 0.0F;
      this.ӆ = 0.0F;
      this.Յ = false;
   }

   private double Ɍ(double var1, double var3) {
      return var1 + this.ĩ.nextDouble() * (var3 - var1);
   }

   private static double ȿ(double param0, double param2, double param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc02a3730b27.Ŧ I
      // 03: istore 6
      // 05: dload 0
      // 06: iload 6
      // 08: ifne 1f
      // 0b: dload 2
      // 0c: dcmpg
      // 0d: ifge 1e
      // 10: goto 14
      // 13: athrow
      // 14: dload 0
      // 15: dload 4
      // 17: dadd
      // 18: dload 2
      // 19: invokestatic java/lang/Math.min (DD)D
      // 1c: dreturn
      // 1d: athrow
      // 1e: dload 0
      // 1f: iload 6
      // 21: ifne 38
      // 24: dload 2
      // 25: dcmpl
      // 26: ifle 37
      // 29: goto 2d
      // 2c: athrow
      // 2d: dload 0
      // 2e: dload 4
      // 30: dsub
      // 31: dload 2
      // 32: invokestatic java/lang/Math.max (DD)D
      // 35: dreturn
      // 36: athrow
      // 37: dload 0
      // 38: dreturn
   }

   private static double ӟ(double param0, double param2, double param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc02a3730b27.Ŧ I
      // 03: istore 6
      // 05: dload 4
      // 07: dload 2
      // 08: dsub
      // 09: iload 6
      // 0b: ifne 35
      // 0e: ldc2_w 0.002
      // 11: dcmpg
      // 12: ifge 23
      // 15: goto 19
      // 18: athrow
      // 19: dload 2
      // 1a: dload 4
      // 1c: dadd
      // 1d: ldc2_w 0.5
      // 20: dmul
      // 21: dreturn
      // 22: athrow
      // 23: dload 2
      // 24: ldc2_w 0.001
      // 27: dadd
      // 28: dload 4
      // 2a: ldc2_w 0.001
      // 2d: dsub
      // 2e: dload 0
      // 2f: invokestatic java/lang/Math.min (DD)D
      // 32: invokestatic java/lang/Math.max (DD)D
      // 35: dreturn
   }

   public void ŕ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc02a3730b27.Ŧ I
      // 003: istore 1
      // 004: aload 0
      // 005: iload 1
      // 006: ifne 019
      // 009: getfield x/ocbb165642ef.Ż Lnet/minecraft/client/Minecraft;
      // 00c: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 00f: ifnonnull 018
      // 012: goto 016
      // 015: athrow
      // 016: return
      // 017: athrow
      // 018: aload 0
      // 019: iload 1
      // 01a: ifne 02a
      // 01d: getfield x/ocbb165642ef.ʲ Z
      // 020: ifeq 029
      // 023: goto 027
      // 026: athrow
      // 027: return
      // 028: athrow
      // 029: aload 0
      // 02a: bipush 1
      // 02b: putfield x/ocbb165642ef.ʲ Z
      // 02e: new x/oc86de9e2892
      // 031: dup
      // 032: aload 0
      // 033: getfield x/ocbb165642ef.մ Ljava/lang/Float;
      // 036: aload 0
      // 037: getfield x/ocbb165642ef.ȩ Ljava/lang/Float;
      // 03a: invokespecial x/oc86de9e2892.<init> (Ljava/lang/Float;Ljava/lang/Float;)V
      // 03d: astore 2
      // 03e: getstatic x/ocea775c9d5c.ų Lx/oc04596227b7;
      // 041: aload 2
      // 042: invokevirtual x/oc04596227b7.post (Lx/oc68d6b191af;)Z
      // 045: pop
      // 046: aload 0
      // 047: iload 1
      // 048: ifne 082
      // 04b: aload 2
      // 04c: getfield x/oc86de9e2892.Ӝ Ljava/lang/Float;
      // 04f: putfield x/ocbb165642ef.մ Ljava/lang/Float;
      // 052: aload 0
      // 053: aload 2
      // 054: getfield x/oc86de9e2892.ŷ Ljava/lang/Float;
      // 057: putfield x/ocbb165642ef.ȩ Ljava/lang/Float;
      // 05a: aload 0
      // 05b: aload 2
      // 05c: invokevirtual x/oc86de9e2892.Ύ ()Ljava/lang/Object;
      // 05f: putfield x/ocbb165642ef.ɼ Ljava/lang/Object;
      // 062: aload 0
      // 063: aload 2
      // 064: invokevirtual x/oc86de9e2892.Є ()Z
      // 067: putfield x/ocbb165642ef.џ Z
      // 06a: aload 0
      // 06b: aload 2
      // 06c: invokevirtual x/oc86de9e2892.þ ()Ljava/lang/Boolean;
      // 06f: putfield x/ocbb165642ef.Ҵ Ljava/lang/Boolean;
      // 072: aload 0
      // 073: getfield x/ocbb165642ef.մ Ljava/lang/Float;
      // 076: ifnonnull 08a
      // 079: goto 07d
      // 07c: athrow
      // 07d: aload 0
      // 07e: goto 082
      // 081: athrow
      // 082: getfield x/ocbb165642ef.ȩ Ljava/lang/Float;
      // 085: ifnonnull 08a
      // 088: return
      // 089: athrow
      // 08a: getstatic x/oc75d51ec7eb.d [F
      // 08d: bipush 0
      // 08e: faload
      // 08f: fstore 3
      // 090: aload 0
      // 091: iload 1
      // 092: ifne 0ae
      // 095: getfield x/ocbb165642ef.մ Ljava/lang/Float;
      // 098: ifnonnull 0ad
      // 09b: goto 09f
      // 09e: athrow
      // 09f: aload 0
      // 0a0: getfield x/ocbb165642ef.Ż Lnet/minecraft/client/Minecraft;
      // 0a3: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0a6: getfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 0a9: goto 0b4
      // 0ac: athrow
      // 0ad: aload 0
      // 0ae: getfield x/ocbb165642ef.մ Ljava/lang/Float;
      // 0b1: invokevirtual java/lang/Float.floatValue ()F
      // 0b4: fstore 4
      // 0b6: aload 2
      // 0b7: invokevirtual x/oc86de9e2892.o ()F
      // 0ba: invokestatic x/oc75d51ec7eb.Ӌ ()F
      // 0bd: invokestatic x/oc7beea7ccff.Ŧ (FF)F
      // 0c0: fstore 5
      // 0c2: fload 4
      // 0c4: fload 3
      // 0c5: fload 5
      // 0c7: invokestatic x/ocbb165642ef.Ų (FFF)F
      // 0ca: fstore 4
      // 0cc: aload 0
      // 0cd: iload 1
      // 0ce: ifne 0ea
      // 0d1: getfield x/ocbb165642ef.ȩ Ljava/lang/Float;
      // 0d4: ifnonnull 0e9
      // 0d7: goto 0db
      // 0da: athrow
      // 0db: aload 0
      // 0dc: getfield x/ocbb165642ef.Ż Lnet/minecraft/client/Minecraft;
      // 0df: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0e2: getfield net/minecraft/client/entity/EntityPlayerSP.rotationPitch F
      // 0e5: goto 0f0
      // 0e8: athrow
      // 0e9: aload 0
      // 0ea: getfield x/ocbb165642ef.ȩ Ljava/lang/Float;
      // 0ed: invokevirtual java/lang/Float.floatValue ()F
      // 0f0: fstore 6
      // 0f2: aload 2
      // 0f3: invokevirtual x/oc86de9e2892.ɚ ()Z
      // 0f6: iload 1
      // 0f7: ifne 108
      // 0fa: ifeq 11a
      // 0fd: goto 101
      // 100: athrow
      // 101: ldc_w -1353009469
      // 104: ldc_w -1353009471
      // 107: ixor
      // 108: newarray 6
      // 10a: dup
      // 10b: bipush 0
      // 10c: fload 4
      // 10e: fastore
      // 10f: dup
      // 110: bipush 1
      // 111: fload 6
      // 113: invokestatic x/oc75d51ec7eb.À (F)F
      // 116: fastore
      // 117: goto 127
      // 11a: fload 4
      // 11c: fload 6
      // 11e: fload 3
      // 11f: getstatic x/oc75d51ec7eb.d [F
      // 122: bipush 1
      // 123: faload
      // 124: invokestatic x/oc75d51ec7eb.Ĩ (FFFF)[F
      // 127: astore 7
      // 129: aload 0
      // 12a: aload 7
      // 12c: bipush 0
      // 12d: faload
      // 12e: invokestatic java/lang/Float.valueOf (F)Ljava/lang/Float;
      // 131: putfield x/ocbb165642ef.մ Ljava/lang/Float;
      // 134: aload 0
      // 135: aload 7
      // 137: bipush 1
      // 138: faload
      // 139: invokestatic java/lang/Float.valueOf (F)Ljava/lang/Float;
      // 13c: putfield x/ocbb165642ef.ȩ Ljava/lang/Float;
      // 13f: aload 0
      // 140: getfield x/ocbb165642ef.մ Ljava/lang/Float;
      // 143: iload 1
      // 144: ifne 192
      // 147: invokevirtual java/lang/Float.floatValue ()F
      // 14a: aload 0
      // 14b: getfield x/ocbb165642ef.Ż Lnet/minecraft/client/Minecraft;
      // 14e: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 151: getfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 154: fcmpl
      // 155: ifeq 18e
      // 158: goto 15c
      // 15b: athrow
      // 15c: aload 2
      // 15d: iload 1
      // 15e: ifne 174
      // 161: goto 165
      // 164: athrow
      // 165: getfield x/oc86de9e2892.Ӝ Ljava/lang/Float;
      // 168: ifnull 185
      // 16b: goto 16f
      // 16e: athrow
      // 16f: aload 2
      // 170: goto 174
      // 173: athrow
      // 174: getfield x/oc86de9e2892.Ӝ Ljava/lang/Float;
      // 177: iload 1
      // 178: ifne 192
      // 17b: invokevirtual java/lang/Float.isNaN ()Z
      // 17e: ifne 18e
      // 181: goto 185
      // 184: athrow
      // 185: aload 0
      // 186: bipush 1
      // 187: putfield x/ocbb165642ef.ȿ Z
      // 18a: goto 18e
      // 18d: athrow
      // 18e: aload 0
      // 18f: getfield x/ocbb165642ef.ȩ Ljava/lang/Float;
      // 192: iload 1
      // 193: ifne 1bb
      // 196: invokevirtual java/lang/Float.floatValue ()F
      // 199: aload 0
      // 19a: getfield x/ocbb165642ef.Ż Lnet/minecraft/client/Minecraft;
      // 19d: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1a0: getfield net/minecraft/client/entity/EntityPlayerSP.rotationPitch F
      // 1a3: fcmpl
      // 1a4: ifeq 1d1
      // 1a7: goto 1ab
      // 1aa: athrow
      // 1ab: aload 2
      // 1ac: iload 1
      // 1ad: ifne 1bf
      // 1b0: goto 1b4
      // 1b3: athrow
      // 1b4: getfield x/oc86de9e2892.ŷ Ljava/lang/Float;
      // 1b7: goto 1bb
      // 1ba: athrow
      // 1bb: ifnull 1c8
      // 1be: aload 2
      // 1bf: getfield x/oc86de9e2892.ŷ Ljava/lang/Float;
      // 1c2: invokevirtual java/lang/Float.isNaN ()Z
      // 1c5: ifne 1d1
      // 1c8: aload 0
      // 1c9: bipush 1
      // 1ca: putfield x/ocbb165642ef.ȿ Z
      // 1cd: goto 1d1
      // 1d0: athrow
      // 1d1: return
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.HIGHEST
   )
   public void խ(oc2f61de30bc var1) {
      this.ŕ();
   }

   @oc66fa4f2195
   public void ã(oc25aa89b91f param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc02a3730b27.Ŧ I
      // 03: istore 2
      // 04: aload 0
      // 05: iload 2
      // 06: ifne 16
      // 09: getfield x/ocbb165642ef.ȿ Z
      // 0c: ifne 15
      // 0f: goto 13
      // 12: athrow
      // 13: return
      // 14: athrow
      // 15: aload 0
      // 16: iload 2
      // 17: ifne 4a
      // 1a: getfield x/ocbb165642ef.մ Ljava/lang/Float;
      // 1d: ifnull 49
      // 20: goto 24
      // 23: athrow
      // 24: aload 0
      // 25: iload 2
      // 26: ifne 4a
      // 29: goto 2d
      // 2c: athrow
      // 2d: getfield x/ocbb165642ef.մ Ljava/lang/Float;
      // 30: invokevirtual java/lang/Float.isNaN ()Z
      // 33: ifne 49
      // 36: goto 3a
      // 39: athrow
      // 3a: aload 1
      // 3b: aload 0
      // 3c: getfield x/ocbb165642ef.մ Ljava/lang/Float;
      // 3f: invokevirtual java/lang/Float.floatValue ()F
      // 42: invokevirtual x/oc25aa89b91f.Տ (F)V
      // 45: goto 49
      // 48: athrow
      // 49: aload 0
      // 4a: iload 2
      // 4b: ifne 5d
      // 4e: getfield x/ocbb165642ef.ȩ Ljava/lang/Float;
      // 51: ifnull 75
      // 54: goto 58
      // 57: athrow
      // 58: aload 0
      // 59: goto 5d
      // 5c: athrow
      // 5d: getfield x/ocbb165642ef.ȩ Ljava/lang/Float;
      // 60: invokevirtual java/lang/Float.isNaN ()Z
      // 63: ifne 75
      // 66: aload 1
      // 67: aload 0
      // 68: getfield x/ocbb165642ef.ȩ Ljava/lang/Float;
      // 6b: invokevirtual java/lang/Float.floatValue ()F
      // 6e: invokevirtual x/oc25aa89b91f.ȫ (F)V
      // 71: goto 75
      // 74: athrow
      // 75: return
   }

   @oc66fa4f2195
   public void Ҁ(ocf6b0e5bf86 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc02a3730b27.Ŧ I
      // 03: istore 2
      // 04: aload 0
      // 05: iload 2
      // 06: ifne 96
      // 09: getfield x/ocbb165642ef.ȿ Z
      // 0c: ifeq 6d
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: iload 2
      // 15: ifne 96
      // 18: goto 1c
      // 1b: athrow
      // 1c: getfield x/ocbb165642ef.մ Ljava/lang/Float;
      // 1f: ifnull 6d
      // 22: goto 26
      // 25: athrow
      // 26: aload 0
      // 27: iload 2
      // 28: ifne 96
      // 2b: goto 2f
      // 2e: athrow
      // 2f: getfield x/ocbb165642ef.Ż Lnet/minecraft/client/Minecraft;
      // 32: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 35: ifnull 6d
      // 38: goto 3c
      // 3b: athrow
      // 3c: getstatic x/oc75d51ec7eb.d [F
      // 3f: bipush 0
      // 40: faload
      // 41: fstore 3
      // 42: aload 0
      // 43: getfield x/ocbb165642ef.Ż Lnet/minecraft/client/Minecraft;
      // 46: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 49: getfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 4c: invokestatic net/minecraft/util/MathHelper.wrapAngleTo180_float (F)F
      // 4f: fload 3
      // 50: invokestatic x/ocbb165642ef.ȥ (FF)F
      // 53: fstore 4
      // 55: aload 0
      // 56: getfield x/ocbb165642ef.Ż Lnet/minecraft/client/Minecraft;
      // 59: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 5c: fload 4
      // 5e: putfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 61: aload 0
      // 62: getfield x/ocbb165642ef.Ż Lnet/minecraft/client/Minecraft;
      // 65: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 68: fload 4
      // 6a: putfield net/minecraft/client/entity/EntityPlayerSP.prevRotationYaw F
      // 6d: aload 0
      // 6e: aload 0
      // 6f: aconst_null
      // 70: dup_x1
      // 71: putfield x/ocbb165642ef.ȩ Ljava/lang/Float;
      // 74: putfield x/ocbb165642ef.մ Ljava/lang/Float;
      // 77: aload 0
      // 78: aconst_null
      // 79: putfield x/ocbb165642ef.ɼ Ljava/lang/Object;
      // 7c: aload 0
      // 7d: bipush 0
      // 7e: putfield x/ocbb165642ef.ȿ Z
      // 81: aload 0
      // 82: bipush 0
      // 83: putfield x/ocbb165642ef.Н Z
      // 86: aload 0
      // 87: bipush 0
      // 88: putfield x/ocbb165642ef.џ Z
      // 8b: aload 0
      // 8c: aconst_null
      // 8d: putfield x/ocbb165642ef.Ҵ Ljava/lang/Boolean;
      // 90: aload 0
      // 91: bipush 0
      // 92: putfield x/ocbb165642ef.ʲ Z
      // 95: aload 0
      // 96: bipush 0
      // 97: putfield x/ocbb165642ef.Ҙ Z
      // 9a: return
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.HIGHEST
   )
   public void ʖ(oc746a23b244 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc02a3730b27.Ŧ I
      // 03: istore 2
      // 04: aload 0
      // 05: iload 2
      // 06: ifne 18
      // 09: getfield x/ocbb165642ef.ȿ Z
      // 0c: ifeq 55
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: goto 18
      // 17: athrow
      // 18: getfield x/ocbb165642ef.Ż Lnet/minecraft/client/Minecraft;
      // 1b: iload 2
      // 1c: ifne 45
      // 1f: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 22: ifnull 55
      // 25: goto 29
      // 28: athrow
      // 29: aload 0
      // 2a: getfield x/ocbb165642ef.Ż Lnet/minecraft/client/Minecraft;
      // 2d: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 30: aload 0
      // 31: getfield x/ocbb165642ef.Ż Lnet/minecraft/client/Minecraft;
      // 34: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 37: getfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 3a: putfield net/minecraft/client/entity/EntityPlayerSP.prevRenderArmYaw F
      // 3d: aload 0
      // 3e: getfield x/ocbb165642ef.Ż Lnet/minecraft/client/Minecraft;
      // 41: goto 45
      // 44: athrow
      // 45: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 48: aload 0
      // 49: getfield x/ocbb165642ef.Ż Lnet/minecraft/client/Minecraft;
      // 4c: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 4f: getfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 52: putfield net/minecraft/client/entity/EntityPlayerSP.renderArmYaw F
      // 55: return
   }

   public boolean Ÿ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc02a3730b27.Ŧ I
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 18
      // 09: getfield x/ocbb165642ef.ȿ Z
      // 0c: ifeq 36
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: goto 18
      // 17: athrow
      // 18: iload 1
      // 19: ifne 2b
      // 1c: getfield x/ocbb165642ef.մ Ljava/lang/Float;
      // 1f: ifnonnull 31
      // 22: goto 26
      // 25: athrow
      // 26: aload 0
      // 27: goto 2b
      // 2a: athrow
      // 2b: getfield x/ocbb165642ef.ȩ Ljava/lang/Float;
      // 2e: ifnull 36
      // 31: bipush 1
      // 32: goto 37
      // 35: athrow
      // 36: bipush 0
      // 37: ireturn
   }

   public boolean D(Object param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc02a3730b27.Ŧ I
      // 03: istore 2
      // 04: aload 1
      // 05: iload 2
      // 06: ifne 18
      // 09: ifnull 21
      // 0c: goto 10
      // 0f: athrow
      // 10: aload 0
      // 11: getfield x/ocbb165642ef.ɼ Ljava/lang/Object;
      // 14: goto 18
      // 17: athrow
      // 18: aload 1
      // 19: if_acmpne 21
      // 1c: bipush 1
      // 1d: goto 22
      // 20: athrow
      // 21: bipush 0
      // 22: ireturn
   }

   public void Ҕ(Entity param1, float param2, float param3, boolean param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc02a3730b27.Ŧ I
      // 03: aload 0
      // 04: aload 1
      // 05: getfield net/minecraft/entity/Entity.rotationYaw F
      // 08: putfield x/ocbb165642ef.ֆ F
      // 0b: istore 5
      // 0d: aload 0
      // 0e: aload 1
      // 0f: getfield net/minecraft/entity/Entity.prevRotationYaw F
      // 12: putfield x/ocbb165642ef.ǐ F
      // 15: aload 0
      // 16: aload 1
      // 17: getfield net/minecraft/entity/Entity.rotationPitch F
      // 1a: putfield x/ocbb165642ef.ȥ F
      // 1d: aload 0
      // 1e: aload 1
      // 1f: getfield net/minecraft/entity/Entity.prevRotationPitch F
      // 22: putfield x/ocbb165642ef.ȁ F
      // 25: aload 1
      // 26: fload 2
      // 27: putfield net/minecraft/entity/Entity.rotationYaw F
      // 2a: aload 1
      // 2b: fload 2
      // 2c: iload 5
      // 2e: ifne 48
      // 31: putfield net/minecraft/entity/Entity.prevRotationYaw F
      // 34: iload 4
      // 36: ifeq 4b
      // 39: goto 3d
      // 3c: athrow
      // 3d: aload 1
      // 3e: fload 3
      // 3f: putfield net/minecraft/entity/Entity.rotationPitch F
      // 42: aload 1
      // 43: fload 3
      // 44: goto 48
      // 47: athrow
      // 48: putfield net/minecraft/entity/Entity.prevRotationPitch F
      // 4b: return
   }

   public void ě(Entity var1) {
      var1.rotationYaw = this.ֆ;
      var1.prevRotationYaw = this.ǐ;
      var1.rotationPitch = this.ȥ;
      var1.prevRotationPitch = this.ȁ;
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.HIGHEST
   )
   public void Ė(oc52918cda9d param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 000: getstatic x/oc02a3730b27.Ŧ I
      // 003: istore 2
      // 004: aload 0
      // 005: iload 2
      // 006: ifne 016
      // 009: invokevirtual x/ocbb165642ef.Ӝ ()Z
      // 00c: ifne 015
      // 00f: goto 013
      // 012: athrow
      // 013: return
      // 014: athrow
      // 015: aload 0
      // 016: iload 2
      // 017: ifne 027
      // 01a: getfield x/ocbb165642ef.џ Z
      // 01d: ifeq 026
      // 020: goto 024
      // 023: athrow
      // 024: return
      // 025: athrow
      // 026: aload 0
      // 027: getfield x/ocbb165642ef.Ż Lnet/minecraft/client/Minecraft;
      // 02a: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 02d: getfield net/minecraft/client/entity/EntityPlayerSP.movementInput Lnet/minecraft/util/MovementInput;
      // 030: getfield net/minecraft/util/MovementInput.sneak Z
      // 033: ifeq 03d
      // 036: ldc_w 0.3
      // 039: goto 03e
      // 03c: athrow
      // 03d: fconst_1
      // 03e: fstore 3
      // 03f: aload 0
      // 040: getfield x/ocbb165642ef.մ Ljava/lang/Float;
      // 043: invokevirtual java/lang/Float.floatValue ()F
      // 046: fstore 4
      // 048: aload 0
      // 049: getfield x/ocbb165642ef.Ż Lnet/minecraft/client/Minecraft;
      // 04c: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 04f: getfield net/minecraft/client/entity/EntityPlayerSP.movementInput Lnet/minecraft/util/MovementInput;
      // 052: getfield net/minecraft/util/MovementInput.moveForward F
      // 055: fstore 5
      // 057: aload 0
      // 058: getfield x/ocbb165642ef.Ż Lnet/minecraft/client/Minecraft;
      // 05b: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 05e: getfield net/minecraft/client/entity/EntityPlayerSP.movementInput Lnet/minecraft/util/MovementInput;
      // 061: getfield net/minecraft/util/MovementInput.moveStrafe F
      // 064: fstore 6
      // 066: fload 5
      // 068: iload 2
      // 069: ifne 094
      // 06c: fconst_0
      // 06d: fcmpl
      // 06e: ifne 08a
      // 071: goto 075
      // 074: athrow
      // 075: fload 6
      // 077: iload 2
      // 078: ifne 094
      // 07b: goto 07f
      // 07e: athrow
      // 07f: fconst_0
      // 080: fcmpl
      // 081: ifne 08a
      // 084: goto 088
      // 087: athrow
      // 088: return
      // 089: athrow
      // 08a: aload 0
      // 08b: getfield x/ocbb165642ef.Ż Lnet/minecraft/client/Minecraft;
      // 08e: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 091: getfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 094: fload 5
      // 096: f2d
      // 097: fload 6
      // 099: f2d
      // 09a: invokestatic x/ocbb165642ef.ț (FDD)D
      // 09d: invokestatic java/lang/Math.toDegrees (D)D
      // 0a0: dstore 7
      // 0a2: fconst_0
      // 0a3: fstore 9
      // 0a5: fconst_0
      // 0a6: fstore 10
      // 0a8: ldc_w 3.4028235E38
      // 0ab: fstore 11
      // 0ad: ldc_w -1.0
      // 0b0: fstore 12
      // 0b2: fload 12
      // 0b4: fconst_1
      // 0b5: fcmpg
      // 0b6: ifgt 15a
      // 0b9: iload 2
      // 0ba: ifne 178
      // 0bd: ldc_w -1.0
      // 0c0: fstore 13
      // 0c2: fload 13
      // 0c4: fconst_1
      // 0c5: fcmpg
      // 0c6: ifgt 150
      // 0c9: fload 12
      // 0cb: iload 2
      // 0cc: ifne 154
      // 0cf: iload 2
      // 0d0: ifne 10b
      // 0d3: goto 0d7
      // 0d6: athrow
      // 0d7: fconst_0
      // 0d8: fcmpl
      // 0d9: ifne 0fb
      // 0dc: goto 0e0
      // 0df: athrow
      // 0e0: fload 13
      // 0e2: iload 2
      // 0e3: ifne 10b
      // 0e6: goto 0ea
      // 0e9: athrow
      // 0ea: fconst_0
      // 0eb: fcmpl
      // 0ec: ifne 0fb
      // 0ef: goto 0f3
      // 0f2: athrow
      // 0f3: iload 2
      // 0f4: ifeq 146
      // 0f7: goto 0fb
      // 0fa: athrow
      // 0fb: fload 12
      // 0fd: iload 2
      // 0fe: ifne 14a
      // 101: goto 105
      // 104: athrow
      // 105: fload 3
      // 106: fmul
      // 107: goto 10b
      // 10a: athrow
      // 10b: fstore 14
      // 10d: fload 13
      // 10f: fload 3
      // 110: fmul
      // 111: fstore 15
      // 113: fload 4
      // 115: fload 14
      // 117: f2d
      // 118: fload 15
      // 11a: f2d
      // 11b: invokestatic x/ocbb165642ef.ț (FDD)D
      // 11e: invokestatic java/lang/Math.toDegrees (D)D
      // 121: dstore 16
      // 123: dload 7
      // 125: dload 16
      // 127: dsub
      // 128: invokestatic net/minecraft/util/MathHelper.wrapAngleTo180_double (D)D
      // 12b: invokestatic java/lang/Math.abs (D)D
      // 12e: dstore 18
      // 130: dload 18
      // 132: fload 11
      // 134: f2d
      // 135: dcmpg
      // 136: ifge 146
      // 139: dload 18
      // 13b: d2f
      // 13c: fstore 11
      // 13e: fload 14
      // 140: fstore 9
      // 142: fload 15
      // 144: fstore 10
      // 146: fload 13
      // 148: fconst_1
      // 149: fadd
      // 14a: fstore 13
      // 14c: iload 2
      // 14d: ifeq 0c2
      // 150: fload 12
      // 152: fconst_1
      // 153: fadd
      // 154: fstore 12
      // 156: iload 2
      // 157: ifeq 0b2
      // 15a: aload 0
      // 15b: getfield x/ocbb165642ef.Ż Lnet/minecraft/client/Minecraft;
      // 15e: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 161: getfield net/minecraft/client/entity/EntityPlayerSP.movementInput Lnet/minecraft/util/MovementInput;
      // 164: fload 9
      // 166: putfield net/minecraft/util/MovementInput.moveForward F
      // 169: aload 0
      // 16a: getfield x/ocbb165642ef.Ż Lnet/minecraft/client/Minecraft;
      // 16d: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 170: getfield net/minecraft/client/entity/EntityPlayerSP.movementInput Lnet/minecraft/util/MovementInput;
      // 173: fload 10
      // 175: putfield net/minecraft/util/MovementInput.moveStrafe F
      // 178: return
   }

   @oc66fa4f2195
   public void ӏ(oc55585a6f85 var1) {
      try {
         if (this.Ӝ()) {
            var1.Ě(this.մ);
         }
      } catch (ocbde1165e4e var2) {
         throw var2;
      }
   }

   @oc66fa4f2195
   public void ʱ(oc4c5a4d3446 var1) {
      try {
         if (this.Ӝ()) {
            var1.Ŗ(this.մ);
         }
      } catch (ocbde1165e4e var2) {
         throw var2;
      }
   }

   public boolean Ӝ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc02a3730b27.Ŧ I
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 18
      // 09: getfield x/ocbb165642ef.Ҵ Ljava/lang/Boolean;
      // 0c: ifnull 21
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: goto 18
      // 17: athrow
      // 18: getfield x/ocbb165642ef.Ҵ Ljava/lang/Boolean;
      // 1b: invokevirtual java/lang/Boolean.booleanValue ()Z
      // 1e: goto 47
      // 21: invokestatic x/oc3de8a289c5.Ӕ ()Z
      // 24: iload 1
      // 25: ifne 43
      // 28: ifne 42
      // 2b: goto 2f
      // 2e: athrow
      // 2f: aload 0
      // 30: getfield x/ocbb165642ef.Н Z
      // 33: iload 1
      // 34: ifne 43
      // 37: goto 3b
      // 3a: athrow
      // 3b: ifeq 46
      // 3e: goto 42
      // 41: athrow
      // 42: bipush 1
      // 43: goto 47
      // 46: bipush 0
      // 47: istore 2
      // 48: iload 2
      // 49: iload 1
      // 4a: ifne 5c
      // 4d: ifeq 6b
      // 50: goto 54
      // 53: athrow
      // 54: aload 0
      // 55: getfield x/ocbb165642ef.ȿ Z
      // 58: goto 5c
      // 5b: athrow
      // 5c: iload 1
      // 5d: ifne 68
      // 60: ifeq 6b
      // 63: goto 67
      // 66: athrow
      // 67: bipush 1
      // 68: goto 6c
      // 6b: bipush 0
      // 6c: ireturn
   }

   // $VF: Handled exception range with multiple entry points by splitting it
   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public static double ț(float var0, double var1, double var3) {
      int var5 = oc02a3730b27.Ŧ;
      if (var1 < 0.0) {
         var0 += 180.0F;
      }

      float var6 = 1.0F;

      double var10000;
      label85: {
         double var10001;
         label78: {
            label86: {
               label76: {
                  label87: {
                     try {
                        var10000 = var1;
                        var10001 = 0.0;
                        if (var5 != 0) {
                           break label76;
                        }

                        if (!(var1 < 0.0)) {
                           break label87;
                        }
                     } catch (ocbde1165e4e var12) {
                        throw var12;
                     }

                     var6 = -0.5F;

                     try {
                        if (var5 == 0) {
                           break label86;
                        }
                     } catch (ocbde1165e4e var11) {
                        throw var11;
                     }
                  }

                  try {
                     var10000 = var1;
                     var10001 = 0.0;
                  } catch (ocbde1165e4e var7) {
                     throw var7;
                  }
               }

               try {
                  if (var5 != 0) {
                     break label78;
                  }

                  if (!(var10000 > var10001)) {
                     break label86;
                  }
               } catch (ocbde1165e4e var10) {
                  throw var10;
               }

               var6 = 0.5F;
            }

            try {
               var10000 = var3;
               if (var5 != 0) {
                  break label85;
               }

               var10001 = 0.0;
            } catch (ocbde1165e4e var9) {
               throw var9;
            }
         }

         if (var10000 > var10001) {
            var0 -= 90.0F * var6;
         }

         var10000 = var3;
      }

      try {
         if (var5 != 0) {
            return var10000;
         }

         if (!(var10000 < 0.0)) {
            return Math.toRadians(var0);
         }
      } catch (ocbde1165e4e var8) {
         throw var8;
      }

      var0 += 90.0F * var6;
      return Math.toRadians(var0);
   }

   public static ocbb165642ef ʨ() {
      return ñ;
   }

   private static float Ų(float param0, float param1, float param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc02a3730b27.Ŧ I
      // 03: istore 3
      // 04: fload 2
      // 05: iload 3
      // 06: ifne 2b
      // 09: invokestatic java/lang/Float.isNaN (F)Z
      // 0c: ifne 26
      // 0f: goto 13
      // 12: athrow
      // 13: fload 2
      // 14: iload 3
      // 15: ifne 32
      // 18: goto 1c
      // 1b: athrow
      // 1c: invokestatic java/lang/Float.isInfinite (F)Z
      // 1f: ifeq 2c
      // 22: goto 26
      // 25: athrow
      // 26: fload 0
      // 27: goto 2b
      // 2a: athrow
      // 2b: freturn
      // 2c: fload 0
      // 2d: fload 1
      // 2e: fsub
      // 2f: invokestatic net/minecraft/util/MathHelper.wrapAngleTo180_float (F)F
      // 32: fstore 4
      // 34: fconst_0
      // 35: fload 2
      // 36: invokestatic java/lang/Math.max (FF)F
      // 39: fstore 5
      // 3b: fload 1
      // 3c: fload 5
      // 3e: fneg
      // 3f: fload 5
      // 41: fload 4
      // 43: invokestatic java/lang/Math.min (FF)F
      // 46: invokestatic java/lang/Math.max (FF)F
      // 49: fadd
      // 4a: freturn
   }

   public void ƕ(float var1, float var2) {
      this.մ = var1;
      this.ȩ = var2;
      this.ɼ = null;
      this.Ҵ = null;
      this.ȿ = true;
   }

   public void ʑ(float var1) {
      this.մ = var1;
      this.ɼ = null;
      this.Ҵ = null;
      this.ȿ = true;
   }

   public void ԟ(float var1) {
      this.ȩ = var1;
      this.ɼ = null;
      this.Ҵ = null;
      this.ȿ = true;
   }

   public Float ɦ() {
      return this.մ;
   }

   public Float ȫ() {
      return this.ȩ;
   }
}
