package x;

import net.minecraft.util.BlockPos;

public class oc7b822110db {
   private static final double Í = 1.0E-10;
   private BlockPos Ű;
   private final double ĳ;
   private final double հ;
   private final int Ð;
   private final int Ĥ;
   private final double Վ;
   private final double Ϛ;
   private final boolean ò;
   private double ˁ;
   private double R;

   oc7b822110db(BlockPos var1, double var2, double var4, double var6, double var8) {
      this(var1, var2, var4, var6, var8, true);
   }

   oc7b822110db(BlockPos var1, double var2, double var4, double var6, double var8, boolean var10) {
      if (var1 == null) {
         throw new IllegalArgumentException("start");
      } else {
         double var11 = Math.hypot(var6, var8);
         if (var11 < 1.0E-4) {
            throw new IllegalArgumentException("direction");
         } else {
            this.Ű = var1;
            this.ĳ = var6 / var11;
            this.հ = var8 / var11;
            this.Ð = this.ĳ > 1.0E-9 ? 1 : (this.ĳ < -1.0E-9 ? -1 : 0);
            this.Ĥ = this.հ > 1.0E-9 ? 1 : (this.հ < -1.0E-9 ? -1 : 0);
            this.Վ = this.Ð == 0 ? Double.POSITIVE_INFINITY : Math.abs(1.0 / this.ĳ);
            this.Ϛ = this.Ĥ == 0 ? Double.POSITIVE_INFINITY : Math.abs(1.0 / this.հ);
            this.ò = var10;
            double var13 = Math.max(var1.getX() + 1.0E-10, Math.min(var1.getX() + 1.0 - 1.0E-10, var2));
            double var15 = Math.max(var1.getZ() + 1.0E-10, Math.min(var1.getZ() + 1.0 - 1.0E-10, var4));
            this.ˁ = this.Ð > 0 ? (var1.getX() + 1.0 - var13) / this.ĳ : (this.Ð < 0 ? (var13 - var1.getX()) / -this.ĳ : Double.POSITIVE_INFINITY);
            this.R = this.Ĥ > 0 ? (var1.getZ() + 1.0 - var15) / this.հ : (this.Ĥ < 0 ? (var15 - var1.getZ()) / -this.հ : Double.POSITIVE_INFINITY);
         }
      }
   }

   private oc7b822110db(oc7b822110db var1) {
      this.Ű = var1.Ű;
      this.ĳ = var1.ĳ;
      this.հ = var1.հ;
      this.Ð = var1.Ð;
      this.Ĥ = var1.Ĥ;
      this.Վ = var1.Վ;
      this.Ϛ = var1.Ϛ;
      this.ò = var1.ò;
      this.ˁ = var1.ˁ;
      this.R = var1.R;
   }

   oc7b822110db ә() {
      return new oc7b822110db(this);
   }

   boolean ř() {
      return this.ò;
   }

   BlockPos Ȍ() {
      return this.Ű;
   }

   boolean ț(int param1, double param2, double param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: dload 2
      // 04: dload 4
      // 06: invokestatic java/lang/Math.hypot (DD)D
      // 09: dstore 7
      // 0b: istore 6
      // 0d: aload 0
      // 0e: getfield x/oc7b822110db.Ű Lnet/minecraft/util/BlockPos;
      // 11: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 14: iload 6
      // 16: ifne 3c
      // 19: iload 1
      // 1a: if_icmpne 37
      // 1d: goto 21
      // 20: athrow
      // 21: dload 7
      // 23: iload 6
      // 25: ifne 51
      // 28: goto 2c
      // 2b: athrow
      // 2c: ldc2_w 1.0E-4
      // 2f: dcmpg
      // 30: ifge 3d
      // 33: goto 37
      // 36: athrow
      // 37: bipush 0
      // 38: goto 3c
      // 3b: athrow
      // 3c: ireturn
      // 3d: aload 0
      // 3e: getfield x/oc7b822110db.ĳ D
      // 41: dload 2
      // 42: dmul
      // 43: dload 7
      // 45: ddiv
      // 46: aload 0
      // 47: getfield x/oc7b822110db.հ D
      // 4a: dload 4
      // 4c: dmul
      // 4d: dload 7
      // 4f: ddiv
      // 50: dadd
      // 51: dstore 9
      // 53: dload 9
      // 55: ldc2_w 0.984807753
      // 58: dcmpl
      // 59: iload 6
      // 5b: ifne 66
      // 5e: iflt 69
      // 61: goto 65
      // 64: athrow
      // 65: bipush 1
      // 66: goto 6a
      // 69: bipush 0
      // 6a: ireturn
   }

   oc1a5b048236 B() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: aload 0
      // 04: getfield x/oc7b822110db.ˁ D
      // 07: aload 0
      // 08: getfield x/oc7b822110db.R D
      // 0b: dsub
      // 0c: dstore 2
      // 0d: istore 1
      // 0e: dload 2
      // 0f: invokestatic java/lang/Math.abs (D)D
      // 12: ldc2_w 1.0E-10
      // 15: dcmpg
      // 16: iload 1
      // 17: ifne 22
      // 1a: ifgt 25
      // 1d: goto 21
      // 20: athrow
      // 21: bipush 1
      // 22: goto 26
      // 25: bipush 0
      // 26: istore 4
      // 28: iload 4
      // 2a: iload 1
      // 2b: ifne 40
      // 2e: ifeq 3d
      // 31: goto 35
      // 34: athrow
      // 35: aload 0
      // 36: getfield x/oc7b822110db.ò Z
      // 39: goto 50
      // 3c: athrow
      // 3d: dload 2
      // 3e: dconst_0
      // 3f: dcmpg
      // 40: iload 1
      // 41: ifne 4c
      // 44: ifge 4f
      // 47: goto 4b
      // 4a: athrow
      // 4b: bipush 1
      // 4c: goto 50
      // 4f: bipush 0
      // 50: istore 5
      // 52: aload 0
      // 53: iload 1
      // 54: ifne 6d
      // 57: getfield x/oc7b822110db.Ð I
      // 5a: ifne 68
      // 5d: goto 61
      // 60: athrow
      // 61: bipush 0
      // 62: istore 5
      // 64: iload 1
      // 65: ifeq 7e
      // 68: aload 0
      // 69: goto 6d
      // 6c: athrow
      // 6d: getfield x/oc7b822110db.Ĥ I
      // 70: iload 1
      // 71: ifne 80
      // 74: ifne 7e
      // 77: goto 7b
      // 7a: athrow
      // 7b: bipush 1
      // 7c: istore 5
      // 7e: iload 5
      // 80: ifeq 94
      // 83: aload 0
      // 84: getfield x/oc7b822110db.Ű Lnet/minecraft/util/BlockPos;
      // 87: aload 0
      // 88: getfield x/oc7b822110db.Ð I
      // 8b: bipush 0
      // 8c: bipush 0
      // 8d: invokevirtual net/minecraft/util/BlockPos.add (III)Lnet/minecraft/util/BlockPos;
      // 90: goto a1
      // 93: athrow
      // 94: aload 0
      // 95: getfield x/oc7b822110db.Ű Lnet/minecraft/util/BlockPos;
      // 98: bipush 0
      // 99: bipush 0
      // 9a: aload 0
      // 9b: getfield x/oc7b822110db.Ĥ I
      // 9e: invokevirtual net/minecraft/util/BlockPos.add (III)Lnet/minecraft/util/BlockPos;
      // a1: astore 6
      // a3: iload 5
      // a5: iload 1
      // a6: ifne cc
      // a9: ifeq c8
      // ac: goto b0
      // af: athrow
      // b0: aload 0
      // b1: getfield x/oc7b822110db.Ð I
      // b4: ifle c2
      // b7: goto bb
      // ba: athrow
      // bb: getstatic net/minecraft/util/EnumFacing.EAST Lnet/minecraft/util/EnumFacing;
      // be: goto d9
      // c1: athrow
      // c2: getstatic net/minecraft/util/EnumFacing.WEST Lnet/minecraft/util/EnumFacing;
      // c5: goto d9
      // c8: aload 0
      // c9: getfield x/oc7b822110db.Ĥ I
      // cc: ifle d6
      // cf: getstatic net/minecraft/util/EnumFacing.SOUTH Lnet/minecraft/util/EnumFacing;
      // d2: goto d9
      // d5: athrow
      // d6: getstatic net/minecraft/util/EnumFacing.NORTH Lnet/minecraft/util/EnumFacing;
      // d9: astore 7
      // db: new x/oc1a5b048236
      // de: dup
      // df: aload 0
      // e0: getfield x/oc7b822110db.Ű Lnet/minecraft/util/BlockPos;
      // e3: aload 7
      // e5: aload 6
      // e7: iload 5
      // e9: invokespecial x/oc1a5b048236.<init> (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;Lnet/minecraft/util/BlockPos;Z)V
      // ec: areturn
   }

   boolean ǹ(BlockPos param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: aload 0
      // 04: invokevirtual x/oc7b822110db.B ()Lx/oc1a5b048236;
      // 07: astore 3
      // 08: istore 2
      // 09: aload 1
      // 0a: iload 2
      // 0b: ifne 25
      // 0e: ifnull 2c
      // 11: goto 15
      // 14: athrow
      // 15: aload 3
      // 16: iload 2
      // 17: ifne 3d
      // 1a: goto 1e
      // 1d: athrow
      // 1e: getfield x/oc1a5b048236.ӄ Lnet/minecraft/util/BlockPos;
      // 21: goto 25
      // 24: athrow
      // 25: aload 1
      // 26: invokevirtual net/minecraft/util/BlockPos.equals (Ljava/lang/Object;)Z
      // 29: ifne 2f
      // 2c: bipush 0
      // 2d: ireturn
      // 2e: athrow
      // 2f: aload 0
      // 30: iload 2
      // 31: ifne 5d
      // 34: aload 1
      // 35: putfield x/oc7b822110db.Ű Lnet/minecraft/util/BlockPos;
      // 38: aload 3
      // 39: goto 3d
      // 3c: athrow
      // 3d: getfield x/oc1a5b048236.ե Z
      // 40: ifeq 58
      // 43: aload 0
      // 44: dup
      // 45: getfield x/oc7b822110db.ˁ D
      // 48: aload 0
      // 49: getfield x/oc7b822110db.Վ D
      // 4c: dadd
      // 4d: putfield x/oc7b822110db.ˁ D
      // 50: iload 2
      // 51: ifeq 69
      // 54: goto 58
      // 57: athrow
      // 58: aload 0
      // 59: goto 5d
      // 5c: athrow
      // 5d: dup
      // 5e: getfield x/oc7b822110db.R D
      // 61: aload 0
      // 62: getfield x/oc7b822110db.Ϛ D
      // 65: dadd
      // 66: putfield x/oc7b822110db.R D
      // 69: bipush 1
      // 6a: ireturn
   }
}
