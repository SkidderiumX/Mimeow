package x;

import net.minecraft.block.BlockStairs;
import net.minecraft.block.BlockStairs.EnumHalf;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import org.lwjgl.opengl.GL11;

public class oc8e5d226f46 {
   public static boolean н;

   // $VF: Handled exception range with multiple entry points by splitting it
   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   // $VF: Unable to simplify switch on enum
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public static void ϳ(
      BlockPos var0,
      IBlockState var1,
      AxisAlignedBB var2,
      EnumFacing var3,
      double var4,
      double var6,
      double var8,
      int var10,
      int var11,
      int var12,
      int var13,
      boolean var14,
      boolean var15,
      oc6ae6c74639 var16
   ) {
      EnumFacing var18 = (EnumFacing)var1.getValue(BlockStairs.FACING);
      EnumHalf var19 = (EnumHalf)var1.getValue(BlockStairs.HALF);
      int var10000 = oc75d51ec7eb.ϩ;
      int var20 = var0.getX();
      int var17 = var10000;
      int var21 = var0.getY();
      int var22 = var0.getZ();

      label77: {
         try {
            if (var19 == EnumHalf.TOP) {
               var10000 = 782063832 ^ 782064086;
               break label77;
            }
         } catch (ocbde1165e4e var30) {
            throw var30;
         }

         var10000 = 0;
      }

      int var23 = var10000;
      var10000 = var17;
      int var24 = 0;

      label69: {
         label68: {
            label67: {
               label66: {
                  label65: {
                     label64: {
                        label63: {
                           try {
                              if (var10000 != 0) {
                                 break label66;
                              }

                              switch (oc45d695e8bd.ԓ[var18.ordinal()]) {
                                 case 1:
                                    break;
                                 case 2:
                                    break label63;
                                 case 3:
                                    break label64;
                                 default:
                                    break label65;
                              }
                           } catch (ocbde1165e4e var29) {
                              throw var29;
                           }

                           var24 = 782063970 ^ 782064086;
                           if (var17 == 0) {
                              break label65;
                           }
                        }

                        var24 = 782064012 ^ 782064086;
                        if (var17 == 0) {
                           break label65;
                        }
                     }

                     var24 = 782063832 ^ 782064086;
                  }

                  try {
                     GL11.glPushMatrix();
                     GL11.glTranslated(-var4, -var6, -var8);
                     if (var17 != 0) {
                        break label67;
                     }

                     GL11.glTranslated(var20 + 0.5, var21, var22 + 0.5);
                     GL11.glRotated(var24, 0.0, 1.0, 0.0);
                     GL11.glTranslated(0.0, 0.5, 0.0);
                     GL11.glRotated(var23, 1.0, 0.0, 0.0);
                     GL11.glTranslated(-var20 - 0.5, -var21 - 0.5, -var22 - 0.5);
                  } catch (ocbde1165e4e var28) {
                     throw var28;
                  }
               }

               try {
                  if (var3 != null) {
                     break label68;
                  }

                  e(var2, var10, var11, var12, var13, var14, var15, var16);
               } catch (ocbde1165e4e var27) {
                  throw var27;
               }
            }

            try {
               if (var17 == 0) {
                  break label69;
               }
            } catch (ocbde1165e4e var26) {
               throw var26;
            }
         }

         try {
            ƙ(var2, var19, var18, var3, var10, var11, var12, var13, var14, var15, var16);
         } catch (ocbde1165e4e var25) {
            throw var25;
         }
      }

      GL11.glPopMatrix();
   }

   private static void e(AxisAlignedBB var0, int var1, int var2, int var3, int var4, boolean var5, boolean var6, oc6ae6c74639 var7) {
      ĵ(var0, var1, var2, var3, var4, var5, var6, var7);
      ԅ(var0, var1, var2, var3, var4, var5, var6, var7);
      պ(var0, var1, var2, var3, var4, var5, var6, var7);
      Þ(var0, var1, var2, var3, var4, var5, var6, var7);
      Û(var0, var1, var2, var3, var4, var5, var6, var7);
      Ө(var0, var1, var2, var3, var4, var5, var6, var7);
   }

   private static void ƙ(
      AxisAlignedBB param0,
      EnumHalf param1,
      EnumFacing param2,
      EnumFacing param3,
      int param4,
      int param5,
      int param6,
      int param7,
      boolean param8,
      boolean param9,
      oc6ae6c74639 param10
   ) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 11
      // 05: iload 11
      // 07: aload 1
      // 08: aload 2
      // 09: aload 3
      // 0a: invokestatic x/oc8e5d226f46.З (Lnet/minecraft/block/BlockStairs$EnumHalf;Lnet/minecraft/util/EnumFacing;Lnet/minecraft/util/EnumFacing;)Lnet/minecraft/util/EnumFacing;
      // 0d: astore 12
      // 0f: ifne 57
      // 12: getstatic x/oc45d695e8bd.ԓ [I
      // 15: aload 12
      // 17: invokevirtual net/minecraft/util/EnumFacing.ordinal ()I
      // 1a: iaload
      // 1b: tableswitch 195 1 6 92 119 173 38 65 146
      // 40: athrow
      // 41: aload 0
      // 42: iload 4
      // 44: iload 5
      // 46: iload 6
      // 48: iload 7
      // 4a: iload 8
      // 4c: iload 9
      // 4e: aload 10
      // 50: invokestatic x/oc8e5d226f46.ĵ (Lnet/minecraft/util/AxisAlignedBB;IIIIZZLx/oc6ae6c74639;)V
      // 53: goto 57
      // 56: athrow
      // 57: iload 11
      // 59: ifeq de
      // 5c: aload 0
      // 5d: iload 4
      // 5f: iload 5
      // 61: iload 6
      // 63: iload 7
      // 65: iload 8
      // 67: iload 9
      // 69: aload 10
      // 6b: invokestatic x/oc8e5d226f46.ԅ (Lnet/minecraft/util/AxisAlignedBB;IIIIZZLx/oc6ae6c74639;)V
      // 6e: iload 11
      // 70: ifeq de
      // 73: goto 77
      // 76: athrow
      // 77: aload 0
      // 78: iload 4
      // 7a: iload 5
      // 7c: iload 6
      // 7e: iload 7
      // 80: iload 8
      // 82: iload 9
      // 84: aload 10
      // 86: invokestatic x/oc8e5d226f46.պ (Lnet/minecraft/util/AxisAlignedBB;IIIIZZLx/oc6ae6c74639;)V
      // 89: iload 11
      // 8b: ifeq de
      // 8e: goto 92
      // 91: athrow
      // 92: aload 0
      // 93: iload 4
      // 95: iload 5
      // 97: iload 6
      // 99: iload 7
      // 9b: iload 8
      // 9d: iload 9
      // 9f: aload 10
      // a1: invokestatic x/oc8e5d226f46.Þ (Lnet/minecraft/util/AxisAlignedBB;IIIIZZLx/oc6ae6c74639;)V
      // a4: iload 11
      // a6: ifeq de
      // a9: goto ad
      // ac: athrow
      // ad: aload 0
      // ae: iload 4
      // b0: iload 5
      // b2: iload 6
      // b4: iload 7
      // b6: iload 8
      // b8: iload 9
      // ba: aload 10
      // bc: invokestatic x/oc8e5d226f46.Û (Lnet/minecraft/util/AxisAlignedBB;IIIIZZLx/oc6ae6c74639;)V
      // bf: iload 11
      // c1: ifeq de
      // c4: goto c8
      // c7: athrow
      // c8: aload 0
      // c9: iload 4
      // cb: iload 5
      // cd: iload 6
      // cf: iload 7
      // d1: iload 8
      // d3: iload 9
      // d5: aload 10
      // d7: invokestatic x/oc8e5d226f46.Ө (Lnet/minecraft/util/AxisAlignedBB;IIIIZZLx/oc6ae6c74639;)V
      // da: goto de
      // dd: athrow
      // de: return
   }

   private static void ĵ(AxisAlignedBB var0, int var1, int var2, int var3, int var4, boolean var5, boolean var6, oc6ae6c74639 var7) {
      AxisAlignedBB var8 = var0.contract(0.0, 0.0, 0.25).offset(0.0, 0.0, 0.25);
      AxisAlignedBB var9 = var0.contract(0.0, 0.0, 0.25).offset(0.0, -0.5, -0.25);
      var7.z$28or8txyh193t(var8, EnumFacing.UP, var1, var2, var3, var4, var5, var6);
      var7.z$28or8txyh193t(var9, EnumFacing.UP, var1, var2, var3, var4, var5, var6);
   }

   private static void ԅ(AxisAlignedBB var0, int var1, int var2, int var3, int var4, boolean var5, boolean var6, oc6ae6c74639 var7) {
      var7.z$28or8txyh193t(var0, EnumFacing.DOWN, var1, var2, var3, var4, var5, var6);
   }

   private static void պ(AxisAlignedBB var0, int var1, int var2, int var3, int var4, boolean var5, boolean var6, oc6ae6c74639 var7) {
      var7.z$28or8txyh193t(var0.contract(0.0, 0.252, 0.0).offset(0.0, 0.252, 0.5), EnumFacing.NORTH, var1, var2, var3, var4, var5, var6);
      var7.z$28or8txyh193t(var0.contract(0.0, 0.25, 0.0).offset(0.0, -0.25, 0.0), EnumFacing.NORTH, var1, var2, var3, var4, var5, var6);
   }

   private static void Þ(AxisAlignedBB var0, int var1, int var2, int var3, int var4, boolean var5, boolean var6, oc6ae6c74639 var7) {
      var7.z$28or8txyh193t(var0.contract(0.0, 0.252, 0.25).offset(0.0, 0.252, 0.25), EnumFacing.EAST, var1, var2, var3, var4, var5, var6);
      var7.z$28or8txyh193t(var0.contract(0.0, 0.25, 0.0).offset(0.0, -0.25, 0.0), EnumFacing.EAST, var1, var2, var3, var4, var5, var6);
   }

   private static void Û(AxisAlignedBB var0, int var1, int var2, int var3, int var4, boolean var5, boolean var6, oc6ae6c74639 var7) {
      var7.z$28or8txyh193t(var0, EnumFacing.SOUTH, var1, var2, var3, var4, var5, var6);
   }

   private static void Ө(AxisAlignedBB var0, int var1, int var2, int var3, int var4, boolean var5, boolean var6, oc6ae6c74639 var7) {
      var7.z$28or8txyh193t(var0.contract(0.0, 0.252, 0.25).offset(0.0, 0.252, 0.25), EnumFacing.WEST, var1, var2, var3, var4, var5, var6);
      var7.z$28or8txyh193t(var0.contract(0.0, 0.25, 0.0).offset(0.0, -0.25, 0.0), EnumFacing.WEST, var1, var2, var3, var4, var5, var6);
   }

   private static EnumFacing З(EnumHalf param0, EnumFacing param1, EnumFacing param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc75d51ec7eb.ϩ I
      // 003: istore 3
      // 004: aload 0
      // 005: getstatic net/minecraft/block/BlockStairs$EnumHalf.TOP Lnet/minecraft/block/BlockStairs$EnumHalf;
      // 008: if_acmpne 0b1
      // 00b: getstatic x/oc45d695e8bd.ԓ [I
      // 00e: aload 1
      // 00f: invokevirtual net/minecraft/util/EnumFacing.ordinal ()I
      // 012: iaload
      // 013: tableswitch 150 1 6 38 66 114 150 150 86
      // 038: athrow
      // 039: aload 2
      // 03a: getstatic net/minecraft/util/EnumFacing$Axis.X Lnet/minecraft/util/EnumFacing$Axis;
      // 03d: invokevirtual net/minecraft/util/EnumFacing.rotateAround (Lnet/minecraft/util/EnumFacing$Axis;)Lnet/minecraft/util/EnumFacing;
      // 040: astore 2
      // 041: iload 3
      // 042: aload 2
      // 043: getstatic net/minecraft/util/EnumFacing$Axis.Y Lnet/minecraft/util/EnumFacing$Axis;
      // 046: invokevirtual net/minecraft/util/EnumFacing.rotateAround (Lnet/minecraft/util/EnumFacing$Axis;)Lnet/minecraft/util/EnumFacing;
      // 049: astore 2
      // 04a: aload 2
      // 04b: getstatic net/minecraft/util/EnumFacing$Axis.Y Lnet/minecraft/util/EnumFacing$Axis;
      // 04e: invokevirtual net/minecraft/util/EnumFacing.rotateAround (Lnet/minecraft/util/EnumFacing$Axis;)Lnet/minecraft/util/EnumFacing;
      // 051: astore 2
      // 052: ifeq 113
      // 055: aload 2
      // 056: getstatic net/minecraft/util/EnumFacing$Axis.Z Lnet/minecraft/util/EnumFacing$Axis;
      // 059: invokevirtual net/minecraft/util/EnumFacing.rotateAround (Lnet/minecraft/util/EnumFacing$Axis;)Lnet/minecraft/util/EnumFacing;
      // 05c: astore 2
      // 05d: iload 3
      // 05e: aload 2
      // 05f: getstatic net/minecraft/util/EnumFacing$Axis.Y Lnet/minecraft/util/EnumFacing$Axis;
      // 062: invokevirtual net/minecraft/util/EnumFacing.rotateAround (Lnet/minecraft/util/EnumFacing$Axis;)Lnet/minecraft/util/EnumFacing;
      // 065: astore 2
      // 066: ifeq 113
      // 069: aload 2
      // 06a: getstatic net/minecraft/util/EnumFacing$Axis.X Lnet/minecraft/util/EnumFacing$Axis;
      // 06d: invokevirtual net/minecraft/util/EnumFacing.rotateAround (Lnet/minecraft/util/EnumFacing$Axis;)Lnet/minecraft/util/EnumFacing;
      // 070: astore 2
      // 071: iload 3
      // 072: aload 2
      // 073: getstatic net/minecraft/util/EnumFacing$Axis.X Lnet/minecraft/util/EnumFacing$Axis;
      // 076: invokevirtual net/minecraft/util/EnumFacing.rotateAround (Lnet/minecraft/util/EnumFacing$Axis;)Lnet/minecraft/util/EnumFacing;
      // 079: astore 2
      // 07a: aload 2
      // 07b: getstatic net/minecraft/util/EnumFacing$Axis.X Lnet/minecraft/util/EnumFacing$Axis;
      // 07e: invokevirtual net/minecraft/util/EnumFacing.rotateAround (Lnet/minecraft/util/EnumFacing$Axis;)Lnet/minecraft/util/EnumFacing;
      // 081: astore 2
      // 082: ifeq 113
      // 085: aload 2
      // 086: getstatic net/minecraft/util/EnumFacing$Axis.Z Lnet/minecraft/util/EnumFacing$Axis;
      // 089: invokevirtual net/minecraft/util/EnumFacing.rotateAround (Lnet/minecraft/util/EnumFacing$Axis;)Lnet/minecraft/util/EnumFacing;
      // 08c: astore 2
      // 08d: iload 3
      // 08e: aload 2
      // 08f: getstatic net/minecraft/util/EnumFacing$Axis.Y Lnet/minecraft/util/EnumFacing$Axis;
      // 092: invokevirtual net/minecraft/util/EnumFacing.rotateAround (Lnet/minecraft/util/EnumFacing$Axis;)Lnet/minecraft/util/EnumFacing;
      // 095: astore 2
      // 096: aload 2
      // 097: getstatic net/minecraft/util/EnumFacing$Axis.Z Lnet/minecraft/util/EnumFacing$Axis;
      // 09a: invokevirtual net/minecraft/util/EnumFacing.rotateAround (Lnet/minecraft/util/EnumFacing$Axis;)Lnet/minecraft/util/EnumFacing;
      // 09d: astore 2
      // 09e: aload 2
      // 09f: getstatic net/minecraft/util/EnumFacing$Axis.Z Lnet/minecraft/util/EnumFacing$Axis;
      // 0a2: invokevirtual net/minecraft/util/EnumFacing.rotateAround (Lnet/minecraft/util/EnumFacing$Axis;)Lnet/minecraft/util/EnumFacing;
      // 0a5: astore 2
      // 0a6: ifeq 113
      // 0a9: iload 3
      // 0aa: ifeq 113
      // 0ad: goto 0b1
      // 0b0: athrow
      // 0b1: aload 2
      // 0b2: iload 3
      // 0b3: ifne 114
      // 0b6: goto 0ba
      // 0b9: athrow
      // 0ba: getstatic net/minecraft/util/EnumFacing.UP Lnet/minecraft/util/EnumFacing;
      // 0bd: if_acmpeq 113
      // 0c0: goto 0c4
      // 0c3: athrow
      // 0c4: aload 2
      // 0c5: iload 3
      // 0c6: ifne 114
      // 0c9: goto 0cd
      // 0cc: athrow
      // 0cd: getstatic net/minecraft/util/EnumFacing.DOWN Lnet/minecraft/util/EnumFacing;
      // 0d0: if_acmpeq 113
      // 0d3: goto 0d7
      // 0d6: athrow
      // 0d7: getstatic x/oc45d695e8bd.ԓ [I
      // 0da: aload 1
      // 0db: invokevirtual net/minecraft/util/EnumFacing.ordinal ()I
      // 0de: iaload
      // 0df: tableswitch 52 1 3 26 35 44
      // 0f8: athrow
      // 0f9: aload 2
      // 0fa: invokevirtual net/minecraft/util/EnumFacing.getOpposite ()Lnet/minecraft/util/EnumFacing;
      // 0fd: astore 2
      // 0fe: iload 3
      // 0ff: ifeq 113
      // 102: aload 2
      // 103: invokevirtual net/minecraft/util/EnumFacing.rotateYCCW ()Lnet/minecraft/util/EnumFacing;
      // 106: astore 2
      // 107: iload 3
      // 108: ifeq 113
      // 10b: aload 2
      // 10c: invokevirtual net/minecraft/util/EnumFacing.rotateYCCW ()Lnet/minecraft/util/EnumFacing;
      // 10f: astore 2
      // 110: goto 113
      // 113: aload 2
      // 114: areturn
   }

   private oc8e5d226f46() {
   }
}
