package x;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;

public class oce021a2e586 extends oc69da1aa7f5 {
   private static final String[] ă;
   private static final int х = 0;
   private static final int ʂ = 1;
   private static final double ɋ = 1.62F;
   private static final double Ñ = 0.026;
   private static final double Ѓ = 16.0;
   private static final float r = 20.0F;
   private static final float Ƽ = 0.9F;
   private final oca9cc61aada Ո;
   private final oca9cc61aada ť;
   private final occ2f8dff8d8 ճ;
   private final occ2f8dff8d8 ʇ;
   public static boolean Г;

   public oce021a2e586() {
      super("Hit Select", oce4cea752dd.ȁ);
      this.ą("Times attacks around damage and hit trades.");
      this.Ո = new oca9cc61aada("Mode", 0, ă);
      this.ť = new oca9cc61aada("Pause duration", "ms", 200.0, 50.0, 500.0, 50.0);
      this.ճ = new occ2f8dff8d8("Fake swing", false);
      this.ʇ = new occ2f8dff8d8("Reduce air swings", false);
      this.ʌ(this.Ո);
      this.ʌ(this.ť);
      this.ʌ(this.ճ);
      this.ʌ(this.ʇ);
      this.ɮ = true;
   }

   public oca9cc61aada à() {
      return this.Ո;
   }

   public oca9cc61aada ը() {
      return this.ť;
   }

   public occ2f8dff8d8 ԗ() {
      return this.ճ;
   }

   public occ2f8dff8d8 ȁ() {
      return this.ʇ;
   }

   @Override
   public String getInfo() {
      int var10000 = oc5e549848f3.İ;
      int var2 = this.č();
      int var1 = var10000;

      label27: {
         try {
            var10000 = var2;
            if (var1 != 0) {
               break label27;
            }

            if (var2 < 0) {
               return "";
            }
         } catch (RuntimeException var4) {
            throw var4;
         }

         var10000 = var2;
      }

      try {
         if (var10000 < ă.length) {
            return ă[var2];
         }
      } catch (RuntimeException var3) {
         throw var3;
      }

      return "";
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.LOW
   )
   public void ѭ(oc507025139f param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 2
      // 04: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 07: iload 2
      // 08: ifne 1f
      // 0b: ifeq 2a
      // 0e: goto 12
      // 11: athrow
      // 12: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 15: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 18: getfield net/minecraft/client/entity/EntityPlayerSP.isDead Z
      // 1b: goto 1f
      // 1e: athrow
      // 1f: iload 2
      // 20: ifne 3b
      // 23: ifeq 2b
      // 26: goto 2a
      // 29: athrow
      // 2a: return
      // 2b: aload 0
      // 2c: iload 2
      // 2d: ifne 45
      // 30: aload 1
      // 31: getfield x/oc507025139f.ϋ Lnet/minecraft/util/MovingObjectPosition;
      // 34: invokevirtual x/oce021a2e586.ĝ (Lnet/minecraft/util/MovingObjectPosition;)Z
      // 37: goto 3b
      // 3a: athrow
      // 3b: ifne 3f
      // 3e: return
      // 3f: aload 1
      // 40: bipush 1
      // 41: invokevirtual x/oc68d6b191af.setCanceled (Z)V
      // 44: aload 0
      // 45: getfield x/oce021a2e586.ճ Lx/occ2f8dff8d8;
      // 48: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 4b: iload 2
      // 4c: ifne 6b
      // 4f: ifeq 77
      // 52: goto 56
      // 55: athrow
      // 56: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 59: iload 2
      // 5a: ifne 71
      // 5d: goto 61
      // 60: athrow
      // 61: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 64: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isUsingItem ()Z
      // 67: goto 6b
      // 6a: athrow
      // 6b: ifne 77
      // 6e: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 71: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 74: invokevirtual net/minecraft/client/entity/EntityPlayerSP.swingItem ()V
      // 77: return
   }

   private boolean ĝ(MovingObjectPosition param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc5e549848f3.İ I
      // 003: istore 2
      // 004: aload 1
      // 005: ifnonnull 00d
      // 008: bipush 1
      // 009: goto 00e
      // 00c: athrow
      // 00d: bipush 0
      // 00e: istore 3
      // 00f: aload 1
      // 010: iload 2
      // 011: ifne 01c
      // 014: ifnull 09d
      // 017: goto 01b
      // 01a: athrow
      // 01b: aload 1
      // 01c: getfield net/minecraft/util/MovingObjectPosition.typeOfHit Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // 01f: iload 2
      // 020: ifne 03c
      // 023: getstatic net/minecraft/util/MovingObjectPosition$MovingObjectType.BLOCK Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // 026: if_acmpne 030
      // 029: goto 02d
      // 02c: athrow
      // 02d: bipush 0
      // 02e: ireturn
      // 02f: athrow
      // 030: aload 1
      // 031: iload 2
      // 032: ifne 047
      // 035: getfield net/minecraft/util/MovingObjectPosition.typeOfHit Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // 038: goto 03c
      // 03b: athrow
      // 03c: getstatic net/minecraft/util/MovingObjectPosition$MovingObjectType.ENTITY Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // 03f: if_acmpne 09b
      // 042: aload 1
      // 043: goto 047
      // 046: athrow
      // 047: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 04a: astore 4
      // 04c: aload 4
      // 04e: iload 2
      // 04f: ifne 07f
      // 052: ifnonnull 081
      // 055: goto 059
      // 058: athrow
      // 059: new net/minecraft/util/Vec3
      // 05c: dup
      // 05d: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 060: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 063: getfield net/minecraft/client/entity/EntityPlayerSP.posX D
      // 066: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 069: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 06c: getfield net/minecraft/client/entity/EntityPlayerSP.posY D
      // 06f: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 072: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 075: getfield net/minecraft/client/entity/EntityPlayerSP.posZ D
      // 078: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 07b: goto 07f
      // 07e: athrow
      // 07f: astore 4
      // 081: aload 0
      // 082: aload 4
      // 084: invokevirtual x/oce021a2e586.ȋ (Lnet/minecraft/util/Vec3;)Z
      // 087: iload 2
      // 088: ifne 096
      // 08b: ifeq 095
      // 08e: goto 092
      // 091: athrow
      // 092: bipush 0
      // 093: ireturn
      // 094: athrow
      // 095: bipush 1
      // 096: istore 3
      // 097: iload 2
      // 098: ifeq 09d
      // 09b: bipush 1
      // 09c: istore 3
      // 09d: iload 3
      // 09e: iload 2
      // 09f: ifne 0bb
      // 0a2: ifne 0ac
      // 0a5: goto 0a9
      // 0a8: athrow
      // 0a9: bipush 0
      // 0aa: ireturn
      // 0ab: athrow
      // 0ac: aload 0
      // 0ad: iload 2
      // 0ae: ifne 105
      // 0b1: getfield x/oce021a2e586.ʇ Lx/occ2f8dff8d8;
      // 0b4: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 0b7: goto 0bb
      // 0ba: athrow
      // 0bb: ifeq 104
      // 0be: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0c1: iload 2
      // 0c2: ifne 0da
      // 0c5: goto 0c9
      // 0c8: athrow
      // 0c9: getfield net/minecraft/client/Minecraft.objectMouseOver Lnet/minecraft/util/MovingObjectPosition;
      // 0cc: ifnull 104
      // 0cf: goto 0d3
      // 0d2: athrow
      // 0d3: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0d6: goto 0da
      // 0d9: athrow
      // 0da: getfield net/minecraft/client/Minecraft.objectMouseOver Lnet/minecraft/util/MovingObjectPosition;
      // 0dd: getfield net/minecraft/util/MovingObjectPosition.typeOfHit Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // 0e0: getstatic net/minecraft/util/MovingObjectPosition$MovingObjectType.MISS Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // 0e3: if_acmpne 104
      // 0e6: invokestatic java/util/concurrent/ThreadLocalRandom.current ()Ljava/util/concurrent/ThreadLocalRandom;
      // 0e9: invokevirtual java/util/concurrent/ThreadLocalRandom.nextFloat ()F
      // 0ec: ldc 0.9
      // 0ee: fcmpg
      // 0ef: iload 2
      // 0f0: ifne 0ff
      // 0f3: goto 0f7
      // 0f6: athrow
      // 0f7: ifge 102
      // 0fa: goto 0fe
      // 0fd: athrow
      // 0fe: bipush 1
      // 0ff: goto 103
      // 102: bipush 0
      // 103: ireturn
      // 104: aload 0
      // 105: invokevirtual x/oce021a2e586.č ()I
      // 108: istore 4
      // 10a: iload 4
      // 10c: iload 2
      // 10d: ifne 120
      // 110: bipush 1
      // 111: if_icmpne 11e
      // 114: goto 118
      // 117: athrow
      // 118: aload 0
      // 119: invokevirtual x/oce021a2e586.ͳ ()Z
      // 11c: ireturn
      // 11d: athrow
      // 11e: iload 4
      // 120: iload 2
      // 121: ifne 132
      // 124: ifeq 12e
      // 127: goto 12b
      // 12a: athrow
      // 12b: bipush 0
      // 12c: ireturn
      // 12d: athrow
      // 12e: aload 0
      // 12f: invokevirtual x/oce021a2e586.Ë ()Z
      // 132: ireturn
   }

   private boolean ȋ(Vec3 var1) {
      EntityPlayerSP var3 = null;
      float var4 = 0.0F;
      Object var5 = null;
      int var2 = oc5e549848f3.İ;
      double var6 = 0.0;
      double var8 = 0.0;
      double var10 = 0.0;
      int var12 = 1761855064 ^ -831833926;

      while (true) {
         switch (var12) {
            case -1281450698:
               return true;
            case 805438600:
               var4 = var3.getAIMoveSpeed();
               var12 = 810844737 ^ -831833926;
               if (var2 == 0) {
                  break;
               }
            case -1316262623:
               return false;
            case 966524775:
               var4 = 0.026F;
               var12 = 810844737 ^ -831833926;
               if (var2 == 0) {
                  break;
               }
            case -1486291230:
               var3 = oc69da1aa7f5.ő.thePlayer;

               label43: {
                  label42: {
                     try {
                        if (var2 != 0) {
                           break label43;
                        }

                        if (!var3.onGround) {
                           break label42;
                        }
                     } catch (RuntimeException var13) {
                        throw var13;
                     }

                     var12 = -26657742 ^ -831833926;
                     if (var2 == 0) {
                        break;
                     }
                  }

                  var12 = -135215139 ^ -831833926;
               }

               if (var2 == 0) {
                  break;
               }
            case -29377797:
               var5 = ƙ(var3.moveStrafing, var3.moveForward, var4, var3.rotationYaw);
               var6 = var3.posY + 1.62F;
               if (var2 != 0) {
                  break;
               }

               var8 = ŕ(
                  var3.posX + var3.motionX + ((Object[])var5)[0],
                  var6 + var3.motionY,
                  var3.posZ + var3.motionZ + ((Object[])var5)[1],
                  var1.xCoord,
                  var1.yCoord,
                  var1.zCoord
               );
               var10 = ŕ(
                  var3.posX + var3.motionX * 0.6 + ((Object[])var5)[0],
                  var6 + var3.motionY,
                  var3.posZ + var3.motionZ * 0.6 + ((Object[])var5)[1],
                  var1.xCoord,
                  var1.yCoord,
                  var1.zCoord
               );
               if (var8 > var10) {
                  var12 = 2113250700 ^ -831833926;
                  if (var2 == 0) {
                     break;
                  }
               }

               var12 = 2145408411 ^ -831833926;
               break;
            default:
               throw null;
         }
      }
   }

   static double[] ƙ(float param0, float param1, float param2, float param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: fload 0
      // 04: ldc_w 0.98
      // 07: fmul
      // 08: fstore 0
      // 09: fload 1
      // 0a: ldc_w 0.98
      // 0d: fmul
      // 0e: fstore 1
      // 0f: istore 4
      // 11: fload 0
      // 12: fload 0
      // 13: fmul
      // 14: fload 1
      // 15: fload 1
      // 16: fmul
      // 17: fadd
      // 18: fstore 5
      // 1a: fload 5
      // 1c: iload 4
      // 1e: ifne 46
      // 21: ldc_w 1.0E-4
      // 24: fcmpg
      // 25: ifge 3f
      // 28: goto 2c
      // 2b: athrow
      // 2c: ldc_w 1284772568
      // 2f: ldc_w 1284772570
      // 32: ixor
      // 33: newarray 7
      // 35: dup
      // 36: bipush 0
      // 37: dconst_0
      // 38: dastore
      // 39: dup
      // 3a: bipush 1
      // 3b: dconst_0
      // 3c: dastore
      // 3d: areturn
      // 3e: athrow
      // 3f: fload 5
      // 41: f2d
      // 42: invokestatic java/lang/Math.sqrt (D)D
      // 45: d2f
      // 46: fstore 6
      // 48: fload 2
      // 49: ldc_w 0.9999998
      // 4c: fmul
      // 4d: fstore 7
      // 4f: fload 6
      // 51: iload 4
      // 53: ifne 7b
      // 56: fconst_1
      // 57: fcmpg
      // 58: iflt 66
      // 5b: goto 5f
      // 5e: athrow
      // 5f: fload 7
      // 61: fload 6
      // 63: fdiv
      // 64: fstore 7
      // 66: fload 0
      // 67: fload 7
      // 69: fmul
      // 6a: fstore 0
      // 6b: fload 1
      // 6c: fload 7
      // 6e: fmul
      // 6f: fstore 1
      // 70: fload 3
      // 71: f2d
      // 72: ldc2_w 3.141592653589793
      // 75: dmul
      // 76: ldc2_w 180.0
      // 79: ddiv
      // 7a: d2f
      // 7b: fstore 8
      // 7d: fload 8
      // 7f: f2d
      // 80: invokestatic java/lang/Math.sin (D)D
      // 83: d2f
      // 84: fstore 9
      // 86: fload 8
      // 88: f2d
      // 89: invokestatic java/lang/Math.cos (D)D
      // 8c: d2f
      // 8d: fstore 10
      // 8f: fload 0
      // 90: fload 10
      // 92: fmul
      // 93: fload 1
      // 94: fload 9
      // 96: fmul
      // 97: fsub
      // 98: fstore 11
      // 9a: fload 1
      // 9b: fload 10
      // 9d: fmul
      // 9e: fload 9
      // a0: fload 0
      // a1: fmul
      // a2: fadd
      // a3: fstore 12
      // a5: ldc_w 1284772568
      // a8: ldc_w 1284772570
      // ab: ixor
      // ac: newarray 7
      // ae: dup
      // af: bipush 0
      // b0: fload 11
      // b2: f2d
      // b3: dastore
      // b4: dup
      // b5: bipush 1
      // b6: fload 12
      // b8: f2d
      // b9: dastore
      // ba: areturn
   }

   private boolean ͳ() {
      EntityPlayerSP var2 = null;
      int var3 = -224274927 ^ 1587381672;
      int var1 = oc5e549848f3.İ;

      while (true) {
         switch (var3) {
            case -1972071712:
               return true;
            case -1405332551:
               var2 = oc69da1aa7f5.ő.thePlayer;

               label36: {
                  try {
                     if (var1 != 0) {
                        break;
                     }

                     if (var2.onGround) {
                        break label36;
                     }
                  } catch (RuntimeException var4) {
                     throw var4;
                  }

                  var3 = 928863856 ^ 1587381672;
                  if (var1 == 0) {
                     break;
                  }
               }

               var3 = -961221110 ^ 1587381672;
               break;
            case 1774244824:
               int var10000;
               label46: {
                  label45: {
                     try {
                        double var6;
                        var10000 = (var6 = var2.prevPosY - var2.posY) == 0.0 ? 0 : (var6 < 0.0 ? -1 : 1);
                        if (var1 != 0) {
                           break label46;
                        }

                        if (var10000 >= 0) {
                           break label45;
                        }
                     } catch (RuntimeException var5) {
                        throw var5;
                     }

                     var3 = -722921656 ^ 1587381672;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var10000 = -961221110 ^ 1587381672;
               }

               var3 = var10000;
               if (var1 == 0) {
                  break;
               }
            case -1742115934:
               return false;
            default:
               throw null;
         }
      }
   }

   private boolean Ë() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 003: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 006: astore 2
      // 007: getstatic x/oc5e549848f3.İ I
      // 00a: bipush 0
      // 00b: istore 3
      // 00c: istore 1
      // 00d: ldc2_w 16.0
      // 010: dstore 4
      // 012: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 015: iload 1
      // 016: ifne 02a
      // 019: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 01c: ifnull 0fd
      // 01f: goto 023
      // 022: athrow
      // 023: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 026: goto 02a
      // 029: athrow
      // 02a: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 02d: getfield net/minecraft/client/multiplayer/WorldClient.loadedEntityList Ljava/util/List;
      // 030: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 035: astore 6
      // 037: aload 6
      // 039: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 03e: ifeq 0fd
      // 041: aload 6
      // 043: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 048: checkcast net/minecraft/entity/Entity
      // 04b: astore 7
      // 04d: aload 7
      // 04f: instanceof net/minecraft/entity/player/EntityPlayer
      // 052: iload 1
      // 053: ifne 067
      // 056: ifeq 037
      // 059: goto 05d
      // 05c: athrow
      // 05d: aload 0
      // 05e: aload 2
      // 05f: aload 7
      // 061: checkcast net/minecraft/entity/player/EntityPlayer
      // 064: invokevirtual x/oce021a2e586.č (Lnet/minecraft/entity/player/EntityPlayer;Lnet/minecraft/entity/player/EntityPlayer;)Z
      // 067: ifne 072
      // 06a: iload 1
      // 06b: ifeq 037
      // 06e: goto 072
      // 071: athrow
      // 072: aload 7
      // 074: checkcast net/minecraft/entity/player/EntityPlayer
      // 077: astore 8
      // 079: aload 2
      // 07a: getfield net/minecraft/entity/player/EntityPlayer.posX D
      // 07d: aload 2
      // 07e: getfield net/minecraft/entity/player/EntityPlayer.posY D
      // 081: ldc2_w 1.6200000047683716
      // 084: dadd
      // 085: aload 2
      // 086: getfield net/minecraft/entity/player/EntityPlayer.posZ D
      // 089: aload 8
      // 08b: getfield net/minecraft/entity/player/EntityPlayer.posX D
      // 08e: aload 8
      // 090: getfield net/minecraft/entity/player/EntityPlayer.posY D
      // 093: aload 8
      // 095: getfield net/minecraft/entity/player/EntityPlayer.posZ D
      // 098: invokestatic x/oce021a2e586.ŕ (DDDDDD)D
      // 09b: dstore 9
      // 09d: dload 9
      // 09f: iload 1
      // 0a0: ifne 0b9
      // 0a3: dload 4
      // 0a5: dcmpl
      // 0a6: ifle 0b5
      // 0a9: goto 0ad
      // 0ac: athrow
      // 0ad: iload 1
      // 0ae: ifeq 037
      // 0b1: goto 0b5
      // 0b4: athrow
      // 0b5: aload 2
      // 0b6: getfield net/minecraft/entity/player/EntityPlayer.posX D
      // 0b9: aload 2
      // 0ba: getfield net/minecraft/entity/player/EntityPlayer.posZ D
      // 0bd: aload 8
      // 0bf: getfield net/minecraft/entity/player/EntityPlayer.posX D
      // 0c2: aload 8
      // 0c4: getfield net/minecraft/entity/player/EntityPlayer.posZ D
      // 0c7: invokestatic x/oce021a2e586.ȩ (DDDD)F
      // 0ca: fstore 11
      // 0cc: iload 1
      // 0cd: ifne 0f9
      // 0d0: fload 11
      // 0d2: aload 2
      // 0d3: getfield net/minecraft/entity/player/EntityPlayer.rotationYaw F
      // 0d6: fsub
      // 0d7: invokestatic x/oce021a2e586.Ҹ (F)F
      // 0da: invokestatic java/lang/Math.abs (F)F
      // 0dd: ldc 20.0
      // 0df: fcmpl
      // 0e0: ifle 0ef
      // 0e3: goto 0e7
      // 0e6: athrow
      // 0e7: iload 1
      // 0e8: ifeq 037
      // 0eb: goto 0ef
      // 0ee: athrow
      // 0ef: dload 9
      // 0f1: dstore 4
      // 0f3: aload 8
      // 0f5: getfield net/minecraft/entity/player/EntityPlayer.hurtTime I
      // 0f8: istore 3
      // 0f9: iload 1
      // 0fa: ifeq 037
      // 0fd: aload 0
      // 0fe: getfield x/oce021a2e586.ť Lx/oca9cc61aada;
      // 101: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 104: ldc2_w 50.0
      // 107: ddiv
      // 108: dstore 6
      // 10a: iload 3
      // 10b: iload 1
      // 10c: ifne 123
      // 10f: i2d
      // 110: ldc2_w 9.0
      // 113: dload 6
      // 115: dsub
      // 116: dcmpl
      // 117: ifle 126
      // 11a: goto 11e
      // 11d: athrow
      // 11e: bipush 1
      // 11f: goto 123
      // 122: athrow
      // 123: goto 127
      // 126: bipush 0
      // 127: ireturn
   }

   private boolean č(EntityPlayer var1, EntityPlayer var2) {
      int var3 = oc5e549848f3.İ;
      int var4 = 1879033265 ^ 81773593;

      while (true) {
         switch (var4) {
            case -1816498246:
               int var12;
               label139: {
                  label138: {
                     try {
                        var12 = var2.isEntityAlive();
                        if (var3 != 0) {
                           break label139;
                        }

                        if (var12 != 0) {
                           break label138;
                        }
                     } catch (RuntimeException var9) {
                        throw var9;
                     }

                     var4 = 846626331 ^ 81773593;
                     if (var3 == 0) {
                        break;
                     }
                  }

                  var12 = 433616039 ^ 81773593;
               }

               var4 = var12;
               if (var3 == 0) {
                  break;
               }
            case -589324749:
               int var13;
               label125: {
                  label124: {
                     try {
                        var13 = var2.isDead;
                        if (var3 != 0) {
                           break label125;
                        }

                        if (var2.isDead) {
                           break label124;
                        }
                     } catch (RuntimeException var8) {
                        throw var8;
                     }

                     var4 = -1754944605 ^ 81773593;
                     if (var3 == 0) {
                        break;
                     }
                  }

                  var13 = 846626331 ^ 81773593;
               }

               var4 = var13;
               if (var3 == 0) {
                  break;
               }

               return false;
            case -1301363014:
               return false;
            case -872843276:
               return true;
            case -747068459:
               if (var2 != null) {
                  var4 = 1007605020 ^ 81773593;
                  if (var3 == 0) {
                     break;
                  }
               }

               var4 = 846626331 ^ 81773593;
               if (var3 == 0) {
                  break;
               }
            case 1917762499:
               int var11;
               label107: {
                  label106: {
                     try {
                        var11 = oc9755810e45.Ǵ.z$3rzb3dil7uydr();
                        if (var3 != 0) {
                           break label107;
                        }

                        if (var11 == 0) {
                           break label106;
                        }
                     } catch (RuntimeException var6) {
                        throw var6;
                     }

                     var4 = 1255346974 ^ 81773593;
                     if (var3 == 0) {
                        break;
                     }
                  }

                  var11 = -819547155 ^ 81773593;
               }

               var4 = var11;
               if (var3 == 0) {
                  break;
               }

               return false;
            case 917092866:
               return false;
            case 953225477:
               if (var2 != var1) {
                  var4 = -671065558 ^ 81773593;
                  if (var3 == 0) {
                     break;
                  }
               }

               var4 = 846626331 ^ 81773593;
               if (var3 == 0) {
                  break;
               }
            case 61548619:
               if (oc9755810e45.Ǵ != null) {
                  var4 = 1989246938 ^ 81773593;
                  if (var3 == 0) {
                     break;
                  }
               }

               var4 = -819547155 ^ 81773593;
               if (var3 == 0) {
                  break;
               }
            case 1797259688:
               if (var1 != null) {
                  var4 = -676894772 ^ 81773593;
                  if (var3 == 0) {
                     break;
                  }
               }

               var4 = 846626331 ^ 81773593;
               if (var3 == 0) {
                  break;
               }
            case 487043262:
               int var10;
               label116: {
                  label115: {
                     try {
                        var10 = oc7ab2161b9f.Ӭ(var2);
                        if (var3 != 0) {
                           break label116;
                        }

                        if (var10 == 0) {
                           break label115;
                        }
                     } catch (RuntimeException var7) {
                        throw var7;
                     }

                     var4 = 1312618611 ^ 81773593;
                     if (var3 == 0) {
                        break;
                     }
                  }

                  var10 = 125103186 ^ 81773593;
               }

               var4 = var10;
               if (var3 == 0) {
                  break;
               }

               return true;
            case 1256406122:
               return false;
            case 1309464327:
               int var10000;
               label98: {
                  label97: {
                     try {
                        var10000 = oca4f99d2d44.Λ(var2);
                        if (var3 != 0) {
                           break label98;
                        }

                        if (var10000 != 0) {
                           break label97;
                        }
                     } catch (RuntimeException var5) {
                        throw var5;
                     }

                     var4 = -819547155 ^ 81773593;
                     if (var3 == 0) {
                        break;
                     }
                  }

                  var10000 = -1229913437 ^ 81773593;
               }

               var4 = var10000;
               if (var3 == 0) {
                  break;
               }

               return false;
            default:
               throw null;
         }
      }
   }

   private static double ŕ(double var0, double var2, double var4, double var6, double var8, double var10) {
      double var12 = var0 - var6;
      double var14 = var2 - var8;
      double var16 = var4 - var10;
      return var12 * var12 + var14 * var14 + var16 * var16;
   }

   private static float ȩ(double var0, double var2, double var4, double var6) {
      return (float)(Math.atan2(var6 - var2, var4 - var0) * 180.0 / Math.PI - 90.0);
   }

   static float Ҹ(float param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: fload 0
      // 04: ldc_w 360.0
      // 07: frem
      // 08: fstore 2
      // 09: istore 1
      // 0a: fload 2
      // 0b: iload 1
      // 0c: ifne 22
      // 0f: ldc_w 180.0
      // 12: fcmpl
      // 13: iflt 21
      // 16: goto 1a
      // 19: athrow
      // 1a: fload 2
      // 1b: ldc_w 360.0
      // 1e: fsub
      // 1f: freturn
      // 20: athrow
      // 21: fload 2
      // 22: iload 1
      // 23: ifne 39
      // 26: ldc_w -180.0
      // 29: fcmpg
      // 2a: ifge 38
      // 2d: goto 31
      // 30: athrow
      // 31: fload 2
      // 32: ldc_w 360.0
      // 35: fadd
      // 36: freturn
      // 37: athrow
      // 38: fload 2
      // 39: freturn
   }

   private int č() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 1
      // 04: aload 0
      // 05: getfield x/oce021a2e586.Ո Lx/oca9cc61aada;
      // 08: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0b: dstore 2
      // 0c: goto 13
      // 0f: astore 4
      // 11: bipush -1
      // 12: ireturn
      // 13: dload 2
      // 14: invokestatic java/lang/Double.isNaN (D)Z
      // 17: iload 1
      // 18: ifne 3a
      // 1b: ifne 35
      // 1e: goto 22
      // 21: athrow
      // 22: dload 2
      // 23: iload 1
      // 24: ifne 3c
      // 27: goto 2b
      // 2a: athrow
      // 2b: invokestatic java/lang/Double.isInfinite (D)Z
      // 2e: ifeq 3b
      // 31: goto 35
      // 34: athrow
      // 35: bipush -1
      // 36: goto 3a
      // 39: athrow
      // 3a: ireturn
      // 3b: dload 2
      // 3c: iload 1
      // 3d: ifne 50
      // 40: dload 2
      // 41: invokestatic java/lang/Math.rint (D)D
      // 44: dcmpl
      // 45: ifeq 4f
      // 48: goto 4c
      // 4b: athrow
      // 4c: bipush -1
      // 4d: ireturn
      // 4e: athrow
      // 4f: dload 2
      // 50: d2i
      // 51: ireturn
   }

   static {
      String[] var10000 = new String[1988715641 ^ 1988715643];
      var10000[0] = "Burst";
      var10000[1] = "Criticals";
      ă = var10000;
   }
}
