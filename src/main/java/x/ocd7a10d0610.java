package x;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.Vec3;

public class ocd7a10d0610 extends oc69da1aa7f5 {
   private final ocb23d192a35 ѫ;
   private final oca9cc61aada Ϣ;
   private final oca9cc61aada ė;
   private final occ2f8dff8d8 Ū;
   private final occ2f8dff8d8 ǟ;
   private final oc1957f41321 ɾ = new oc1957f41321();
   private final ocb8b190c865 с = new ocb8b190c865();
   private oc80ddc6e76a ѡ = oc80ddc6e76a.ɇ;
   private InventoryPlayer Դ;
   private Entity Ķ;
   private int Ȓ = -1;
   private int ç;
   private int ɛ;
   private int þ;
   private float Ƨ;
   private boolean ʛ;
   private boolean ƙ;
   private boolean Ɍ;
   private boolean Ƚ;
   private boolean ҩ;
   private boolean ǖ;
   public static int Ȝ;

   public ocd7a10d0610() {
      super("AutoRod", oce4cea752dd.ȁ);
      this.ą("Uses a fishing rod while the active key is held or assists KillAura automatically.");
      this.ʌ(this.ѫ = new ocb23d192a35("Active Keybind", 0));
      this.ʌ(this.Ϣ = new oca9cc61aada("Retract speed", 1.0, 0.5, 2.0, 0.01));
      this.ʌ(this.ė = new oca9cc61aada("Delay between actions", 0.5, 0.0, 2.0, 0.01));
      this.ʌ(this.Ū = new occ2f8dff8d8("Randomize delays", true));
      this.ʌ(this.ǟ = new occ2f8dff8d8("Always switch back to weapon", false));
   }

   @Override
   public void onEnable() {
      this.Ŏ(true);
      this.Ɍ = false;
      this.þ = 0;
   }

   @Override
   public void onDisable() {
      this.Ŏ(true);
   }

   @oc66fa4f2195
   public void Ô(ocbab3c9954b var1) {
      this.Ŏ(true);
      this.Ɍ = false;
      this.þ = 0;
      this.ɾ.ϸ();
   }

   private Entity Ԃ() {
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
      // 05: iload 1
      // 06: ifne 30
      // 09: getfield x/ocd7a10d0610.Ķ Lnet/minecraft/entity/Entity;
      // 0c: ifnull 19
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: getfield x/ocd7a10d0610.Ķ Lnet/minecraft/entity/Entity;
      // 17: areturn
      // 18: athrow
      // 19: aload 0
      // 1a: getfield x/ocd7a10d0610.ɾ Lx/oc1957f41321;
      // 1d: new x/oc6111f05032
      // 20: dup
      // 21: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 24: invokespecial x/oc6111f05032.<init> (Lnet/minecraft/client/Minecraft;)V
      // 27: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, x/oc5e08d6b90f.Ƣ (Lnet/minecraft/entity/player/EntityPlayer;)Z, (Lnet/minecraft/entity/player/EntityPlayer;)Z ]
      // 2c: invokevirtual x/oc1957f41321.ԍ (Lx/oc6111f05032;Ljava/util/function/Predicate;)V
      // 2f: aload 0
      // 30: getfield x/ocd7a10d0610.ɾ Lx/oc1957f41321;
      // 33: invokevirtual x/oc1957f41321.ϭ ()Lnet/minecraft/entity/player/EntityPlayer;
      // 36: areturn
   }

   private Entity Ȼ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: getstatic x/oc9755810e45.ÿ Lx/ocdd342096f8;
      // 06: astore 2
      // 07: istore 1
      // 08: aload 2
      // 09: iload 1
      // 0a: ifne 15
      // 0d: ifnull 37
      // 10: goto 14
      // 13: athrow
      // 14: aload 2
      // 15: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 18: iload 1
      // 19: ifne 26
      // 1c: ifeq 37
      // 1f: goto 23
      // 22: athrow
      // 23: invokestatic x/oc7c017b256e.Ͱ ()Z
      // 26: iload 1
      // 27: ifne 34
      // 2a: ifne 37
      // 2d: goto 31
      // 30: athrow
      // 31: invokestatic x/oc7c017b256e.ę ()Z
      // 34: ifeq 3a
      // 37: aconst_null
      // 38: areturn
      // 39: athrow
      // 3a: aload 2
      // 3b: invokevirtual x/ocdd342096f8.Ǒ ()Lnet/minecraft/entity/Entity;
      // 3e: astore 3
      // 3f: aload 0
      // 40: aload 3
      // 41: invokevirtual x/ocd7a10d0610.ƹ (Lnet/minecraft/entity/Entity;)Z
      // 44: ifne 4a
      // 47: aconst_null
      // 48: areturn
      // 49: athrow
      // 4a: aload 3
      // 4b: invokestatic x/oc75d51ec7eb.Ŭ (Lnet/minecraft/entity/Entity;)D
      // 4e: dstore 4
      // 50: aload 2
      // 51: invokevirtual x/ocdd342096f8.Q ()Lx/oca9cc61aada;
      // 54: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 57: dstore 6
      // 59: dload 4
      // 5b: iload 1
      // 5c: ifne 6f
      // 5f: dload 6
      // 61: dcmpl
      // 62: ifle 9d
      // 65: goto 69
      // 68: athrow
      // 69: dload 4
      // 6b: goto 6f
      // 6e: athrow
      // 6f: ldc2_w 8.0
      // 72: dcmpg
      // 73: iload 1
      // 74: ifne 96
      // 77: ifgt 9d
      // 7a: goto 7e
      // 7d: athrow
      // 7e: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 81: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 84: iload 1
      // 85: ifne 9a
      // 88: goto 8c
      // 8b: athrow
      // 8c: aload 3
      // 8d: dload 6
      // 8f: invokestatic x/oc169f211a70.У (Lnet/minecraft/entity/Entity;Lnet/minecraft/entity/Entity;D)Z
      // 92: goto 96
      // 95: athrow
      // 96: ifne 9d
      // 99: aload 3
      // 9a: goto 9e
      // 9d: aconst_null
      // 9e: areturn
   }

   private boolean ƹ(Entity var1) {
      int var2 = oc5e549848f3.İ;
      int var3 = -1056773315 ^ -1519293893;

      while (true) {
         label159:
         while (true) {
            label157:
            while (true) {
               switch (var3) {
                  case -2083534953:
                     if (var1.worldObj == oc69da1aa7f5.ő.theWorld) {
                        var3 = -342749052 ^ -1519293893;
                        if (var2 == 0) {
                           continue;
                        }
                     }

                     var3 = -2139368159 ^ -1519293893;
                     if (var2 != 0) {
                        break label159;
                     }
                     continue;
                  case -487873970:
                     break label157;
                  case -141931605:
                     int var12;
                     label143: {
                        label142: {
                           try {
                              float var15;
                              var12 = (var15 = ((EntityLivingBase)var1).getHealth() - 0.0F) == 0.0F ? 0 : (var15 < 0.0F ? -1 : 1);
                              if (var2 != 0) {
                                 break label143;
                              }

                              if (var12 <= 0) {
                                 break label142;
                              }
                           } catch (IllegalStateException var9) {
                              throw var9;
                           }

                           var3 = 650030508 ^ -1519293893;
                           if (var2 == 0) {
                              continue;
                           }
                        }

                        var12 = -2139368159 ^ -1519293893;
                     }

                     var3 = var12;
                     if (var2 == 0) {
                        continue;
                     }
                  case 1004102745:
                     int var13;
                     label122: {
                        label121: {
                           try {
                              var13 = var1.isDead;
                              if (var2 != 0) {
                                 break label122;
                              }

                              if (var1.isDead) {
                                 break label121;
                              }
                           } catch (IllegalStateException var7) {
                              throw var7;
                           }

                           var3 = -1750394801 ^ -1519293893;
                           if (var2 == 0) {
                              continue;
                           }
                        }

                        var13 = -2139368159 ^ -1519293893;
                     }

                     var3 = var13;
                     if (var2 == 0) {
                        continue;
                     }
                     break label157;
                  case -25991357:
                     return true;
                  case 621461274:
                     return false;
                  case 853176948:
                     int var10000;
                     label134: {
                        label133: {
                           try {
                              var10000 = ((EntityLivingBase)var1).deathTime;
                              if (var2 != 0) {
                                 break label134;
                              }

                              if (((EntityLivingBase)var1).deathTime != 0) {
                                 break label133;
                              }
                           } catch (IllegalStateException var8) {
                              throw var8;
                           }

                           var3 = 1392189840 ^ -1519293893;
                           if (var2 == 0) {
                              continue;
                           }
                        }

                        var10000 = -2139368159 ^ -1519293893;
                     }

                     var3 = var10000;
                     if (var2 == 0) {
                        continue;
                     }
                  case 1685291270:
                     int var10;
                     label113: {
                        label112: {
                           try {
                              var10 = var1 instanceof EntityLivingBase;
                              if (var2 != 0) {
                                 break label113;
                              }

                              if (var10 == 0) {
                                 break label112;
                              }
                           } catch (IllegalStateException var6) {
                              throw var6;
                           }

                           var3 = 1201326197 ^ -1519293893;
                           if (var2 == 0) {
                              continue;
                           }
                        }

                        var10 = -2139368159 ^ -1519293893;
                     }

                     var3 = var10;
                     if (var2 == 0) {
                        continue;
                     }
                     break;
                  case 866767391:
                     break label159;
                  case 1323530943:
                     break;
                  default:
                     throw null;
               }

               int var11;
               label91: {
                  label90: {
                     try {
                        var11 = oc69da1aa7f5.ő.theWorld.loadedEntityList.contains(var1);
                        if (var2 != 0) {
                           break label91;
                        }

                        if (var11 == 0) {
                           break label90;
                        }
                     } catch (IllegalStateException var4) {
                        throw var4;
                     }

                     var3 = -1764181980 ^ -1519293893;
                     if (var2 == 0) {
                        continue;
                     }
                  }

                  var11 = -2139368159 ^ -1519293893;
               }

               var3 = var11;
               if (var2 != 0) {
                  return false;
               }
            }

            if (var1 != oc69da1aa7f5.ő.thePlayer) {
               var3 = -1633153438 ^ -1519293893;
               if (var2 == 0) {
                  continue;
               }
            }

            var3 = -2139368159 ^ -1519293893;
            if (var2 != 0) {
               return true;
            }
         }

         int var14;
         label100: {
            label99: {
               try {
                  var14 = oc69da1aa7f5.ő.thePlayer.canEntityBeSeen(var1);
                  if (var2 != 0) {
                     break label100;
                  }

                  if (var14 == 0) {
                     break label99;
                  }
               } catch (IllegalStateException var5) {
                  throw var5;
               }

               var3 = 1526861176 ^ -1519293893;
               if (var2 == 0) {
                  continue;
               }
            }

            var14 = -2139368159 ^ -1519293893;
         }

         var3 = var14;
      }
   }

   private float Ǘ() {
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
      // 05: iload 1
      // 06: ifne 30
      // 09: getfield x/ocd7a10d0610.Ū Lx/occ2f8dff8d8;
      // 0c: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 0f: ifeq 2f
      // 12: goto 16
      // 15: athrow
      // 16: aload 0
      // 17: getfield x/ocd7a10d0610.с Lx/ocb8b190c865;
      // 1a: aload 0
      // 1b: getfield x/ocd7a10d0610.ė Lx/oca9cc61aada;
      // 1e: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 21: d2f
      // 22: invokestatic x/oca6eae151db.Ϫ ()D
      // 25: getstatic x/oca6eae151db.ő Lx/oca6eae151db;
      // 28: invokevirtual x/ocb8b190c865.ʈ (FDLx/oca6eae151db;)F
      // 2b: goto 37
      // 2e: athrow
      // 2f: aload 0
      // 30: getfield x/ocd7a10d0610.ė Lx/oca9cc61aada;
      // 33: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 36: d2f
      // 37: freturn
   }

   public static int ʴ(int[] param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: bipush 0
      // 04: istore 2
      // 05: istore 1
      // 06: iload 2
      // 07: ldc_w -728966657
      // 0a: ldc_w -728966666
      // 0d: ixor
      // 0e: if_icmpge 3b
      // 11: aload 0
      // 12: iload 2
      // 13: iaload
      // 14: iload 1
      // 15: ifne 3c
      // 18: iload 1
      // 19: ifne 33
      // 1c: goto 20
      // 1f: athrow
      // 20: ldc_w -728966996
      // 23: ldc_w -728966666
      // 26: ixor
      // 27: if_icmpne 34
      // 2a: goto 2e
      // 2d: athrow
      // 2e: iload 2
      // 2f: goto 33
      // 32: athrow
      // 33: ireturn
      // 34: iinc 2 1
      // 37: iload 1
      // 38: ifeq 06
      // 3b: bipush -1
      // 3c: ireturn
   }

   private int ƥ(InventoryPlayer param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: bipush 0
      // 04: istore 3
      // 05: istore 2
      // 06: iload 3
      // 07: ldc_w 1342978527
      // 0a: ldc_w 1342978518
      // 0d: ixor
      // 0e: if_icmpge 40
      // 11: aload 1
      // 12: iload 3
      // 13: invokevirtual net/minecraft/entity/player/InventoryPlayer.getStackInSlot (I)Lnet/minecraft/item/ItemStack;
      // 16: invokestatic x/oc2922be51da.ц (Lnet/minecraft/item/ItemStack;)I
      // 19: iload 2
      // 1a: ifne 41
      // 1d: iload 2
      // 1e: ifne 38
      // 21: goto 25
      // 24: athrow
      // 25: ldc_w 1342978188
      // 28: ldc_w 1342978518
      // 2b: ixor
      // 2c: if_icmpne 39
      // 2f: goto 33
      // 32: athrow
      // 33: iload 3
      // 34: goto 38
      // 37: athrow
      // 38: ireturn
      // 39: iinc 3 1
      // 3c: iload 2
      // 3d: ifeq 06
      // 40: bipush -1
      // 41: ireturn
   }

   // $VF: Handled exception range with multiple entry points by splitting it
   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public static int ʜ(Vec3 var0, Vec3 var1, float var2) {
      int var3 = oc5e549848f3.İ;

      Vec3 var10000;
      label32: {
         label37: {
            try {
               var10000 = var1;
               if (var3 != 0) {
                  break label32;
               }

               if (var1 != null) {
                  break label37;
               }
            } catch (IllegalStateException var8) {
               throw var8;
            }

            float var4 = 10.0F / var2;

            try {
               if (var3 == 0) {
                  return oc30e402796f.ý(oc30e402796f.Ż(var4));
               }
            } catch (IllegalStateException var7) {
               throw var7;
            }
         }

         try {
            var10000 = new Vec3(
               oc497d0cdf29.ɨ(var1.xCoord - 0.3, var1.xCoord + 0.3, var0.xCoord),
               oc497d0cdf29.ɨ(var1.yCoord, var1.yCoord + 1.8, var0.yCoord),
               oc497d0cdf29.ɨ(var1.zCoord - 0.3, var1.zCoord + 0.3, var0.zCoord)
            );
         } catch (IllegalStateException var6) {
            throw var6;
         }
      }

      Vec3 var5 = var10000;
      float var9 = (float)(oc497d0cdf29.Ż(var0, var5) / var2);
      return oc30e402796f.ý(oc30e402796f.Ż(var9));
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.LOW
   )
   public void Ւ(oc86de9e2892 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 2
      // 04: aload 0
      // 05: getfield x/ocd7a10d0610.ƙ Z
      // 08: iload 2
      // 09: ifne 16
      // 0c: ifeq 5f
      // 0f: goto 13
      // 12: athrow
      // 13: invokestatic x/oc2922be51da.Ѽ ()Z
      // 16: iload 2
      // 17: ifne 2d
      // 1a: ifeq 5f
      // 1d: goto 21
      // 20: athrow
      // 21: aload 0
      // 22: aload 0
      // 23: getfield x/ocd7a10d0610.Ķ Lnet/minecraft/entity/Entity;
      // 26: invokevirtual x/ocd7a10d0610.ƹ (Lnet/minecraft/entity/Entity;)Z
      // 29: goto 2d
      // 2c: athrow
      // 2d: ifeq 5f
      // 30: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 33: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 36: aload 0
      // 37: getfield x/ocd7a10d0610.Ķ Lnet/minecraft/entity/Entity;
      // 3a: invokestatic x/oc169f211a70.έ (Lnet/minecraft/entity/Entity;Lnet/minecraft/entity/Entity;)Lnet/minecraft/util/Vec3;
      // 3d: astore 3
      // 3e: aload 3
      // 3f: invokestatic x/oc75d51ec7eb.Ѭ (Lnet/minecraft/util/Vec3;)[F
      // 42: astore 4
      // 44: aload 1
      // 45: aload 0
      // 46: ldc_w 1703191128
      // 49: ldc_w 1703191468
      // 4c: ixor
      // 4d: aload 4
      // 4f: bipush 0
      // 50: faload
      // 51: invokestatic java/lang/Float.valueOf (F)Ljava/lang/Float;
      // 54: aload 4
      // 56: bipush 1
      // 57: faload
      // 58: invokestatic java/lang/Float.valueOf (F)Ljava/lang/Float;
      // 5b: invokevirtual x/oc86de9e2892.л (Ljava/lang/Object;ILjava/lang/Float;Ljava/lang/Float;)Z
      // 5e: pop
      // 5f: return
   }

   @oc66fa4f2195
   public void ʛ(oc507025139f var1) {
      try {
         if (ocf5b7e839f8.ȱ() == this) {
            var1.setCanceled(true);
         }
      } catch (IllegalStateException var2) {
         throw var2;
      }
   }

   @oc66fa4f2195
   public void ĕ(oc479681b341 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 2
      // 04: invokestatic x/ocf5b7e839f8.ȱ ()Ljava/lang/Object;
      // 07: aload 0
      // 08: if_acmpne 6d
      // 0b: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 0e: iload 2
      // 0f: ifne 2d
      // 12: goto 16
      // 15: athrow
      // 16: ifeq 6d
      // 19: goto 1d
      // 1c: athrow
      // 1d: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 20: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 23: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getHeldItem ()Lnet/minecraft/item/ItemStack;
      // 26: invokestatic x/oc2922be51da.ц (Lnet/minecraft/item/ItemStack;)I
      // 29: goto 2d
      // 2c: athrow
      // 2d: iload 2
      // 2e: ifne 4f
      // 31: ldc_w -681317624
      // 34: ldc_w -681317806
      // 37: ixor
      // 38: if_icmpne 6d
      // 3b: goto 3f
      // 3e: athrow
      // 3f: aload 0
      // 40: iload 2
      // 41: ifne 69
      // 44: goto 48
      // 47: athrow
      // 48: getfield x/ocd7a10d0610.ʛ Z
      // 4b: goto 4f
      // 4e: athrow
      // 4f: ifeq 5f
      // 52: aload 1
      // 53: bipush 1
      // 54: invokevirtual x/oc68d6b191af.setCanceled (Z)V
      // 57: iload 2
      // 58: ifeq 6d
      // 5b: goto 5f
      // 5e: athrow
      // 5f: aload 0
      // 60: bipush 1
      // 61: putfield x/ocd7a10d0610.ʛ Z
      // 64: aload 0
      // 65: goto 69
      // 68: athrow
      // 69: bipush 0
      // 6a: putfield x/ocd7a10d0610.Ƚ Z
      // 6d: return
   }

   @oc66fa4f2195
   public void А(occb36f998dc param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc5e549848f3.İ I
      // 003: istore 2
      // 004: invokestatic x/oc2922be51da.Ѽ ()Z
      // 007: ifeq 017
      // 00a: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 00d: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 010: ifnull 01e
      // 013: goto 017
      // 016: athrow
      // 017: aload 0
      // 018: bipush 1
      // 019: invokevirtual x/ocd7a10d0610.Ŏ (Z)V
      // 01c: return
      // 01d: athrow
      // 01e: aload 0
      // 01f: getfield x/ocd7a10d0610.ѫ Lx/ocb23d192a35;
      // 022: invokevirtual x/ocb23d192a35.Ǻ ()I
      // 025: iload 2
      // 026: ifne 031
      // 029: ifeq 034
      // 02c: goto 030
      // 02f: athrow
      // 030: bipush 1
      // 031: goto 035
      // 034: bipush 0
      // 035: istore 3
      // 036: iload 3
      // 037: iload 2
      // 038: ifne 04d
      // 03b: ifeq 05c
      // 03e: goto 042
      // 041: athrow
      // 042: aload 0
      // 043: getfield x/ocd7a10d0610.ѫ Lx/ocb23d192a35;
      // 046: invokevirtual x/ocb23d192a35.Ɛ ()Z
      // 049: goto 04d
      // 04c: athrow
      // 04d: iload 2
      // 04e: ifne 059
      // 051: ifeq 05c
      // 054: goto 058
      // 057: athrow
      // 058: bipush 1
      // 059: goto 05d
      // 05c: bipush 0
      // 05d: istore 4
      // 05f: iload 4
      // 061: iload 2
      // 062: ifne 076
      // 065: ifne 075
      // 068: goto 06c
      // 06b: athrow
      // 06c: aload 0
      // 06d: bipush 0
      // 06e: putfield x/ocd7a10d0610.Ɍ Z
      // 071: goto 075
      // 074: athrow
      // 075: iload 3
      // 076: iload 2
      // 077: ifne 0b8
      // 07a: ifeq 0ac
      // 07d: goto 081
      // 080: athrow
      // 081: iload 4
      // 083: iload 2
      // 084: ifne 0a2
      // 087: goto 08b
      // 08a: athrow
      // 08b: ifeq 0a5
      // 08e: goto 092
      // 091: athrow
      // 092: aload 0
      // 093: iload 2
      // 094: ifne 0ad
      // 097: goto 09b
      // 09a: athrow
      // 09b: getfield x/ocd7a10d0610.Ɍ Z
      // 09e: goto 0a2
      // 0a1: athrow
      // 0a2: ifeq 0ac
      // 0a5: aload 0
      // 0a6: bipush 1
      // 0a7: invokevirtual x/ocd7a10d0610.Ŏ (Z)V
      // 0aa: return
      // 0ab: athrow
      // 0ac: aload 0
      // 0ad: iload 2
      // 0ae: ifne 0d9
      // 0b1: getfield x/ocd7a10d0610.ƙ Z
      // 0b4: goto 0b8
      // 0b7: athrow
      // 0b8: ifeq 0d8
      // 0bb: aload 0
      // 0bc: iload 2
      // 0bd: ifne 0d9
      // 0c0: goto 0c4
      // 0c3: athrow
      // 0c4: invokevirtual x/ocd7a10d0610.Ȼ ()Lnet/minecraft/entity/Entity;
      // 0c7: aload 0
      // 0c8: getfield x/ocd7a10d0610.Ķ Lnet/minecraft/entity/Entity;
      // 0cb: if_acmpeq 0d8
      // 0ce: goto 0d2
      // 0d1: athrow
      // 0d2: aload 0
      // 0d3: invokevirtual x/ocd7a10d0610.Ҧ ()V
      // 0d6: return
      // 0d7: athrow
      // 0d8: aload 0
      // 0d9: iload 2
      // 0da: ifne 0f6
      // 0dd: getfield x/ocd7a10d0610.ɛ I
      // 0e0: ifle 0f5
      // 0e3: goto 0e7
      // 0e6: athrow
      // 0e7: aload 0
      // 0e8: dup
      // 0e9: getfield x/ocd7a10d0610.ɛ I
      // 0ec: bipush 1
      // 0ed: isub
      // 0ee: putfield x/ocd7a10d0610.ɛ I
      // 0f1: goto 0f5
      // 0f4: athrow
      // 0f5: aload 0
      // 0f6: iload 2
      // 0f7: ifne 1c4
      // 0fa: getfield x/ocd7a10d0610.ƙ Z
      // 0fd: ifeq 1c3
      // 100: goto 104
      // 103: athrow
      // 104: aload 0
      // 105: iload 2
      // 106: ifne 1c4
      // 109: goto 10d
      // 10c: athrow
      // 10d: getfield x/ocd7a10d0610.ѡ Lx/oc80ddc6e76a;
      // 110: getstatic x/oc80ddc6e76a.ʑ Lx/oc80ddc6e76a;
      // 113: if_acmpne 1c3
      // 116: goto 11a
      // 119: athrow
      // 11a: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 11d: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 120: getfield net/minecraft/client/entity/EntityPlayerSP.fishEntity Lnet/minecraft/entity/projectile/EntityFishHook;
      // 123: astore 5
      // 125: iload 2
      // 126: ifne 143
      // 129: aload 5
      // 12b: ifnull 158
      // 12e: goto 132
      // 131: athrow
      // 132: aload 0
      // 133: bipush 1
      // 134: iload 2
      // 135: ifne 151
      // 138: goto 13c
      // 13b: athrow
      // 13c: putfield x/ocd7a10d0610.ҩ Z
      // 13f: goto 143
      // 142: athrow
      // 143: aload 0
      // 144: aload 5
      // 146: getfield net/minecraft/entity/projectile/EntityFishHook.caughtEntity Lnet/minecraft/entity/Entity;
      // 149: ifnull 154
      // 14c: bipush 1
      // 14d: goto 151
      // 150: athrow
      // 151: goto 155
      // 154: bipush 0
      // 155: putfield x/ocd7a10d0610.ǖ Z
      // 158: aload 0
      // 159: iload 2
      // 15a: ifne 1bf
      // 15d: getfield x/ocd7a10d0610.ǖ Z
      // 160: ifne 1be
      // 163: goto 167
      // 166: athrow
      // 167: aload 0
      // 168: iload 2
      // 169: ifne 1b0
      // 16c: goto 170
      // 16f: athrow
      // 170: getfield x/ocd7a10d0610.ҩ Z
      // 173: ifeq 1af
      // 176: goto 17a
      // 179: athrow
      // 17a: aload 5
      // 17c: iload 2
      // 17d: ifne 18d
      // 180: goto 184
      // 183: athrow
      // 184: ifnull 1be
      // 187: goto 18b
      // 18a: athrow
      // 18b: aload 5
      // 18d: iload 2
      // 18e: ifne 1a1
      // 191: getfield net/minecraft/entity/projectile/EntityFishHook.isDead Z
      // 194: ifne 1be
      // 197: goto 19b
      // 19a: athrow
      // 19b: aload 5
      // 19d: goto 1a1
      // 1a0: athrow
      // 1a1: getfield net/minecraft/entity/projectile/EntityFishHook.onGround Z
      // 1a4: iload 2
      // 1a5: ifne 1bb
      // 1a8: ifne 1be
      // 1ab: goto 1af
      // 1ae: athrow
      // 1af: aload 0
      // 1b0: iload 2
      // 1b1: ifne 1c4
      // 1b4: getfield x/ocd7a10d0610.ɛ I
      // 1b7: goto 1bb
      // 1ba: athrow
      // 1bb: ifne 1c3
      // 1be: aload 0
      // 1bf: invokevirtual x/ocd7a10d0610.Ҧ ()V
      // 1c2: return
      // 1c3: aload 0
      // 1c4: getfield x/ocd7a10d0610.Ƨ F
      // 1c7: fconst_0
      // 1c8: fcmpl
      // 1c9: iload 2
      // 1ca: ifne 1f2
      // 1cd: ifle 1f1
      // 1d0: goto 1d4
      // 1d3: athrow
      // 1d4: aload 0
      // 1d5: dup
      // 1d6: getfield x/ocd7a10d0610.Ƨ F
      // 1d9: fconst_1
      // 1da: fsub
      // 1db: dup_x1
      // 1dc: putfield x/ocd7a10d0610.Ƨ F
      // 1df: fconst_0
      // 1e0: fcmpl
      // 1e1: iload 2
      // 1e2: ifne 1f2
      // 1e5: goto 1e9
      // 1e8: athrow
      // 1e9: ifle 1f1
      // 1ec: goto 1f0
      // 1ef: athrow
      // 1f0: return
      // 1f1: bipush 0
      // 1f2: istore 5
      // 1f4: iload 5
      // 1f6: ldc_w 139547853
      // 1f9: ldc_w 139547854
      // 1fc: ixor
      // 1fd: if_icmpge 534
      // 200: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 203: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 206: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 209: astore 6
      // 20b: aload 0
      // 20c: iload 2
      // 20d: ifne 21f
      // 210: getfield x/ocd7a10d0610.Դ Lnet/minecraft/entity/player/InventoryPlayer;
      // 213: ifnull 261
      // 216: goto 21a
      // 219: athrow
      // 21a: aload 0
      // 21b: goto 21f
      // 21e: athrow
      // 21f: getfield x/ocd7a10d0610.ѡ Lx/oc80ddc6e76a;
      // 222: getstatic x/oc80ddc6e76a.џ Lx/oc80ddc6e76a;
      // 225: if_acmpeq 261
      // 228: aload 6
      // 22a: getfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 22d: iload 2
      // 22e: ifne 26c
      // 231: goto 235
      // 234: athrow
      // 235: aload 0
      // 236: getfield x/ocd7a10d0610.ç I
      // 239: if_icmpeq 261
      // 23c: goto 240
      // 23f: athrow
      // 240: aload 0
      // 241: bipush 0
      // 242: invokevirtual x/ocd7a10d0610.Ŏ (Z)V
      // 245: aload 0
      // 246: iload 3
      // 247: putfield x/ocd7a10d0610.Ɍ Z
      // 24a: aload 0
      // 24b: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 24e: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 251: getfield net/minecraft/client/entity/EntityPlayerSP.ticksExisted I
      // 254: ldc_w 139547844
      // 257: ldc_w 139547854
      // 25a: ixor
      // 25b: iadd
      // 25c: putfield x/ocd7a10d0610.þ I
      // 25f: return
      // 260: athrow
      // 261: getstatic x/ocdb5b1f467a.ƺ [I
      // 264: aload 0
      // 265: getfield x/ocd7a10d0610.ѡ Lx/oc80ddc6e76a;
      // 268: invokevirtual java/lang/Enum.ordinal ()I
      // 26b: iaload
      // 26c: iload 2
      // 26d: ifne 29a
      // 270: tableswitch 679 1 6 41 305 342 579 638 674
      // 298: athrow
      // 299: iload 3
      // 29a: ifeq 2a2
      // 29d: aconst_null
      // 29e: goto 2a6
      // 2a1: athrow
      // 2a2: aload 0
      // 2a3: invokevirtual x/ocd7a10d0610.Ȼ ()Lnet/minecraft/entity/Entity;
      // 2a6: astore 7
      // 2a8: iload 3
      // 2a9: iload 2
      // 2aa: ifne 2e1
      // 2ad: ifne 2db
      // 2b0: goto 2b4
      // 2b3: athrow
      // 2b4: aload 7
      // 2b6: ifnull 2d9
      // 2b9: goto 2bd
      // 2bc: athrow
      // 2bd: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 2c0: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 2c3: getfield net/minecraft/client/entity/EntityPlayerSP.ticksExisted I
      // 2c6: iload 2
      // 2c7: ifne 2e1
      // 2ca: goto 2ce
      // 2cd: athrow
      // 2ce: aload 0
      // 2cf: getfield x/ocd7a10d0610.þ I
      // 2d2: if_icmpge 2db
      // 2d5: goto 2d9
      // 2d8: athrow
      // 2d9: return
      // 2da: athrow
      // 2db: aload 0
      // 2dc: aload 6
      // 2de: invokevirtual x/ocd7a10d0610.ƥ (Lnet/minecraft/entity/player/InventoryPlayer;)I
      // 2e1: istore 8
      // 2e3: iload 8
      // 2e5: iload 2
      // 2e6: ifne 300
      // 2e9: iflt 303
      // 2ec: goto 2f0
      // 2ef: athrow
      // 2f0: aload 0
      // 2f1: iload 2
      // 2f2: ifne 32b
      // 2f5: goto 2f9
      // 2f8: athrow
      // 2f9: invokestatic x/ocf5b7e839f8.ӡ (Ljava/lang/Object;)Z
      // 2fc: goto 300
      // 2ff: athrow
      // 300: ifne 304
      // 303: return
      // 304: invokestatic x/oc2922be51da.ǟ ()V
      // 307: aload 0
      // 308: aload 6
      // 30a: putfield x/ocd7a10d0610.Դ Lnet/minecraft/entity/player/InventoryPlayer;
      // 30d: aload 0
      // 30e: aload 6
      // 310: getfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 313: putfield x/ocd7a10d0610.Ȓ I
      // 316: aload 0
      // 317: iload 8
      // 319: iload 2
      // 31a: ifne 334
      // 31d: putfield x/ocd7a10d0610.ç I
      // 320: aload 0
      // 321: aload 7
      // 323: putfield x/ocd7a10d0610.Ķ Lnet/minecraft/entity/Entity;
      // 326: aload 0
      // 327: goto 32b
      // 32a: athrow
      // 32b: iload 3
      // 32c: ifne 337
      // 32f: bipush 1
      // 330: goto 334
      // 333: athrow
      // 334: goto 338
      // 337: bipush 0
      // 338: putfield x/ocd7a10d0610.ƙ Z
      // 33b: aload 0
      // 33c: bipush 0
      // 33d: putfield x/ocd7a10d0610.ʛ Z
      // 340: aload 0
      // 341: getfield x/ocd7a10d0610.ƙ Z
      // 344: iload 2
      // 345: ifne 371
      // 348: ifne 365
      // 34b: goto 34f
      // 34e: athrow
      // 34f: aload 0
      // 350: iload 2
      // 351: ifne 384
      // 354: goto 358
      // 357: athrow
      // 358: getfield x/ocd7a10d0610.ǟ Lx/occ2f8dff8d8;
      // 35b: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 35e: ifeq 383
      // 361: goto 365
      // 364: athrow
      // 365: getstatic x/ocbd3640d420.L Lx/ocbd3640d420;
      // 368: aload 6
      // 36a: invokevirtual x/ocbd3640d420.Ō (Lnet/minecraft/entity/player/InventoryPlayer;)I
      // 36d: goto 371
      // 370: athrow
      // 371: istore 9
      // 373: iload 9
      // 375: bipush -1
      // 376: if_icmpeq 383
      // 379: aload 0
      // 37a: iload 9
      // 37c: putfield x/ocd7a10d0610.Ȓ I
      // 37f: goto 383
      // 382: athrow
      // 383: aload 0
      // 384: aload 0
      // 385: getfield x/ocd7a10d0610.ç I
      // 388: aload 6
      // 38a: getfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 38d: if_icmpne 397
      // 390: getstatic x/oc80ddc6e76a.s Lx/oc80ddc6e76a;
      // 393: goto 39a
      // 396: athrow
      // 397: getstatic x/oc80ddc6e76a.џ Lx/oc80ddc6e76a;
      // 39a: putfield x/ocd7a10d0610.ѡ Lx/oc80ddc6e76a;
      // 39d: iload 2
      // 39e: ifeq 522
      // 3a1: aload 6
      // 3a3: aload 0
      // 3a4: getfield x/ocd7a10d0610.ç I
      // 3a7: putfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 3aa: iload 2
      // 3ab: aload 0
      // 3ac: getstatic x/oc80ddc6e76a.s Lx/oc80ddc6e76a;
      // 3af: putfield x/ocd7a10d0610.ѡ Lx/oc80ddc6e76a;
      // 3b2: aload 0
      // 3b3: dup
      // 3b4: getfield x/ocd7a10d0610.Ƨ F
      // 3b7: aload 0
      // 3b8: invokevirtual x/ocd7a10d0610.Ǘ ()F
      // 3bb: fadd
      // 3bc: putfield x/ocd7a10d0610.Ƨ F
      // 3bf: ifeq 522
      // 3c2: goto 3c6
      // 3c5: athrow
      // 3c6: aload 0
      // 3c7: aload 6
      // 3c9: invokevirtual x/ocd7a10d0610.ƥ (Lnet/minecraft/entity/player/InventoryPlayer;)I
      // 3cc: istore 9
      // 3ce: iload 9
      // 3d0: iload 2
      // 3d1: ifne 3e3
      // 3d4: ifge 3e1
      // 3d7: goto 3db
      // 3da: athrow
      // 3db: aload 0
      // 3dc: invokevirtual x/ocd7a10d0610.Ҧ ()V
      // 3df: return
      // 3e0: athrow
      // 3e1: iload 9
      // 3e3: aload 6
      // 3e5: getfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 3e8: if_icmpeq 40d
      // 3eb: aload 0
      // 3ec: iload 9
      // 3ee: putfield x/ocd7a10d0610.ç I
      // 3f1: iload 2
      // 3f2: aload 0
      // 3f3: getstatic x/oc80ddc6e76a.џ Lx/oc80ddc6e76a;
      // 3f6: putfield x/ocd7a10d0610.ѡ Lx/oc80ddc6e76a;
      // 3f9: aload 0
      // 3fa: dup
      // 3fb: getfield x/ocd7a10d0610.Ƨ F
      // 3fe: aload 0
      // 3ff: invokevirtual x/ocd7a10d0610.Ǘ ()F
      // 402: fadd
      // 403: putfield x/ocd7a10d0610.Ƨ F
      // 406: ifeq 522
      // 409: goto 40d
      // 40c: athrow
      // 40d: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 410: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 413: getfield net/minecraft/client/settings/GameSettings.keyBindUseItem Lnet/minecraft/client/settings/KeyBinding;
      // 416: bipush 1
      // 417: invokestatic x/oc2922be51da.Ƚ (Lnet/minecraft/client/settings/KeyBinding;I)V
      // 41a: aload 0
      // 41b: bipush 1
      // 41c: putfield x/ocd7a10d0610.Ƚ Z
      // 41f: aload 0
      // 420: getstatic x/oc80ddc6e76a.ʑ Lx/oc80ddc6e76a;
      // 423: putfield x/ocd7a10d0610.ѡ Lx/oc80ddc6e76a;
      // 426: aload 0
      // 427: invokevirtual x/ocd7a10d0610.Ԃ ()Lnet/minecraft/entity/Entity;
      // 42a: astore 10
      // 42c: aload 0
      // 42d: new net/minecraft/util/Vec3
      // 430: dup
      // 431: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 434: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 437: getfield net/minecraft/client/entity/EntityPlayerSP.posX D
      // 43a: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 43d: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 440: getfield net/minecraft/client/entity/EntityPlayerSP.posY D
      // 443: ldc2_w 1.62
      // 446: dadd
      // 447: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 44a: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 44d: getfield net/minecraft/client/entity/EntityPlayerSP.posZ D
      // 450: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 453: aload 10
      // 455: iload 2
      // 456: ifne 467
      // 459: ifnonnull 465
      // 45c: goto 460
      // 45f: athrow
      // 460: aconst_null
      // 461: goto 46a
      // 464: athrow
      // 465: aload 10
      // 467: invokestatic x/oceb15b1dc5f.Ț (Lnet/minecraft/entity/Entity;)Lnet/minecraft/util/Vec3;
      // 46a: aload 0
      // 46b: getfield x/ocd7a10d0610.Ϣ Lx/oca9cc61aada;
      // 46e: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 471: d2f
      // 472: invokestatic x/ocd7a10d0610.ʜ (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;F)I
      // 475: putfield x/ocd7a10d0610.ɛ I
      // 478: iload 2
      // 479: ifne 4b2
      // 47c: aload 0
      // 47d: getfield x/ocd7a10d0610.ƙ Z
      // 480: ifeq 4a5
      // 483: goto 487
      // 486: athrow
      // 487: aload 0
      // 488: ldc_w 139547853
      // 48b: ldc_w 139547854
      // 48e: ixor
      // 48f: aload 0
      // 490: getfield x/ocd7a10d0610.ɛ I
      // 493: ldc_w 139547852
      // 496: ldc_w 139547854
      // 499: ixor
      // 49a: iadd
      // 49b: invokestatic java/lang/Math.max (II)I
      // 49e: putfield x/ocd7a10d0610.ɛ I
      // 4a1: goto 4a5
      // 4a4: athrow
      // 4a5: aload 0
      // 4a6: dup
      // 4a7: getfield x/ocd7a10d0610.Ƨ F
      // 4aa: aload 0
      // 4ab: invokevirtual x/ocd7a10d0610.Ǘ ()F
      // 4ae: fadd
      // 4af: putfield x/ocd7a10d0610.Ƨ F
      // 4b2: return
      // 4b3: aload 0
      // 4b4: iload 2
      // 4b5: ifne 4c5
      // 4b8: getfield x/ocd7a10d0610.ɛ I
      // 4bb: ifeq 4c4
      // 4be: goto 4c2
      // 4c1: athrow
      // 4c2: return
      // 4c3: athrow
      // 4c4: aload 0
      // 4c5: aload 0
      // 4c6: getfield x/ocd7a10d0610.Ȓ I
      // 4c9: aload 0
      // 4ca: getfield x/ocd7a10d0610.ç I
      // 4cd: if_icmpne 4d7
      // 4d0: getstatic x/oc80ddc6e76a.ƃ Lx/oc80ddc6e76a;
      // 4d3: goto 4da
      // 4d6: athrow
      // 4d7: getstatic x/oc80ddc6e76a.ɷ Lx/oc80ddc6e76a;
      // 4da: putfield x/ocd7a10d0610.ѡ Lx/oc80ddc6e76a;
      // 4dd: iload 2
      // 4de: aload 0
      // 4df: dup
      // 4e0: getfield x/ocd7a10d0610.Ƨ F
      // 4e3: aload 0
      // 4e4: invokevirtual x/ocd7a10d0610.Ǘ ()F
      // 4e7: fadd
      // 4e8: putfield x/ocd7a10d0610.Ƨ F
      // 4eb: ifeq 522
      // 4ee: aload 0
      // 4ef: aload 0
      // 4f0: getfield x/ocd7a10d0610.Ȓ I
      // 4f3: bipush 1
      // 4f4: iadd
      // 4f5: ldc_w 139547847
      // 4f8: ldc_w 139547854
      // 4fb: ixor
      // 4fc: irem
      // 4fd: putfield x/ocd7a10d0610.ç I
      // 500: aload 6
      // 502: aload 0
      // 503: getfield x/ocd7a10d0610.ç I
      // 506: putfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 509: aload 0
      // 50a: getstatic x/oc80ddc6e76a.ɷ Lx/oc80ddc6e76a;
      // 50d: putfield x/ocd7a10d0610.ѡ Lx/oc80ddc6e76a;
      // 510: return
      // 511: athrow
      // 512: aload 0
      // 513: invokevirtual x/ocd7a10d0610.Ҧ ()V
      // 516: return
      // 517: new java/lang/IllegalStateException
      // 51a: dup
      // 51b: ldc_w "Invalid rod phase"
      // 51e: invokespecial java/lang/IllegalStateException.<init> (Ljava/lang/String;)V
      // 521: athrow
      // 522: aload 0
      // 523: getfield x/ocd7a10d0610.Ƨ F
      // 526: fconst_0
      // 527: fcmpl
      // 528: ifle 52d
      // 52b: return
      // 52c: athrow
      // 52d: iinc 5 1
      // 530: iload 2
      // 531: ifeq 1f4
      // 534: return
   }

   private void Ҧ() {
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
      // 05: iload 1
      // 06: ifne 46
      // 09: getfield x/ocd7a10d0610.ƙ Z
      // 0c: ifeq 45
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 17: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1a: getfield net/minecraft/client/entity/EntityPlayerSP.ticksExisted I
      // 1d: aload 0
      // 1e: getfield x/ocd7a10d0610.ǖ Z
      // 21: iload 1
      // 22: ifne 37
      // 25: goto 29
      // 28: athrow
      // 29: ifeq 3a
      // 2c: goto 30
      // 2f: athrow
      // 30: ldc_w 183397689
      // 33: ldc_w 183397681
      // 36: ixor
      // 37: goto 41
      // 3a: ldc_w 183397685
      // 3d: ldc_w 183397681
      // 40: ixor
      // 41: iadd
      // 42: putfield x/ocd7a10d0610.þ I
      // 45: aload 0
      // 46: getfield x/ocd7a10d0610.Ƨ F
      // 49: aload 0
      // 4a: invokevirtual x/ocd7a10d0610.Ǘ ()F
      // 4d: fadd
      // 4e: fstore 2
      // 4f: aload 0
      // 50: bipush 1
      // 51: invokevirtual x/ocd7a10d0610.Ŏ (Z)V
      // 54: aload 0
      // 55: fload 2
      // 56: putfield x/ocd7a10d0610.Ƨ F
      // 59: return
   }

   private void Ŏ(boolean param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 2
      // 04: aload 0
      // 05: getfield x/ocd7a10d0610.Ƚ Z
      // 08: iload 2
      // 09: ifne 3a
      // 0c: ifeq 39
      // 0f: goto 13
      // 12: athrow
      // 13: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 16: iload 2
      // 17: ifne 2f
      // 1a: goto 1e
      // 1d: athrow
      // 1e: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 21: ifnull 39
      // 24: goto 28
      // 27: athrow
      // 28: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 2b: goto 2f
      // 2e: athrow
      // 2f: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 32: getfield net/minecraft/client/settings/GameSettings.keyBindUseItem Lnet/minecraft/client/settings/KeyBinding;
      // 35: bipush 0
      // 36: invokestatic x/oc2922be51da.Ƚ (Lnet/minecraft/client/settings/KeyBinding;I)V
      // 39: iload 1
      // 3a: ifeq 8c
      // 3d: aload 0
      // 3e: iload 2
      // 3f: ifne c5
      // 42: goto 46
      // 45: athrow
      // 46: getfield x/ocd7a10d0610.Դ Lnet/minecraft/entity/player/InventoryPlayer;
      // 49: ifnull 8c
      // 4c: goto 50
      // 4f: athrow
      // 50: aload 0
      // 51: iload 2
      // 52: ifne c5
      // 55: goto 59
      // 58: athrow
      // 59: getfield x/ocd7a10d0610.Ȓ I
      // 5c: iflt 8c
      // 5f: goto 63
      // 62: athrow
      // 63: aload 0
      // 64: iload 2
      // 65: ifne c5
      // 68: goto 6c
      // 6b: athrow
      // 6c: getfield x/ocd7a10d0610.Դ Lnet/minecraft/entity/player/InventoryPlayer;
      // 6f: getfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 72: aload 0
      // 73: getfield x/ocd7a10d0610.ç I
      // 76: if_icmpne 8c
      // 79: goto 7d
      // 7c: athrow
      // 7d: aload 0
      // 7e: getfield x/ocd7a10d0610.Դ Lnet/minecraft/entity/player/InventoryPlayer;
      // 81: aload 0
      // 82: getfield x/ocd7a10d0610.Ȓ I
      // 85: putfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 88: goto 8c
      // 8b: athrow
      // 8c: aload 0
      // 8d: invokestatic x/ocf5b7e839f8.İ (Ljava/lang/Object;)V
      // 90: aload 0
      // 91: aconst_null
      // 92: putfield x/ocd7a10d0610.Դ Lnet/minecraft/entity/player/InventoryPlayer;
      // 95: aload 0
      // 96: bipush -1
      // 97: putfield x/ocd7a10d0610.Ȓ I
      // 9a: aload 0
      // 9b: getstatic x/oc80ddc6e76a.ɇ Lx/oc80ddc6e76a;
      // 9e: putfield x/ocd7a10d0610.ѡ Lx/oc80ddc6e76a;
      // a1: aload 0
      // a2: aconst_null
      // a3: putfield x/ocd7a10d0610.Ķ Lnet/minecraft/entity/Entity;
      // a6: aload 0
      // a7: bipush 0
      // a8: putfield x/ocd7a10d0610.ƙ Z
      // ab: aload 0
      // ac: bipush 0
      // ad: putfield x/ocd7a10d0610.ʛ Z
      // b0: aload 0
      // b1: aload 0
      // b2: aload 0
      // b3: bipush 0
      // b4: dup_x1
      // b5: putfield x/ocd7a10d0610.ǖ Z
      // b8: dup_x1
      // b9: putfield x/ocd7a10d0610.ҩ Z
      // bc: putfield x/ocd7a10d0610.Ƚ Z
      // bf: aload 0
      // c0: bipush 0
      // c1: putfield x/ocd7a10d0610.ɛ I
      // c4: aload 0
      // c5: fconst_0
      // c6: putfield x/ocd7a10d0610.Ƨ F
      // c9: return
   }
}
