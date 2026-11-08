package x;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.world.WorldSettings.GameType;
import org.apache.commons.lang3.RandomUtils;

public class occddbf330f0 extends oc69da1aa7f5 {
   private static final Minecraft Լ = Minecraft.getMinecraft();
   private int Ƕ = 0;
   private int Ӣ = 0;
   private boolean Ԣ = false;
   private final ocba5f31cad4 Ê = new ocba5f31cad4();
   public final oca9cc61aada λ = new oca9cc61aada("Min delay", " ticks", 1.0, 0.0, 20.0, 1.0);
   public final oca9cc61aada ǟ = new oca9cc61aada("Max delay", " ticks", 2.0, 0.0, 20.0, 1.0);
   public final oca9cc61aada ѿ = new oca9cc61aada("Open delay", " ticks", 1.0, 0.0, 20.0, 1.0);
   private final occ2f8dff8d8 à = new occ2f8dff8d8("Visual", true);
   public final occ2f8dff8d8 δ = new occ2f8dff8d8("Auto armor", true);
   public final oca9cc61aada Ȉ = new oca9cc61aada("Auto armor interval", " ticks", 0.0, 0.0, 100.0, 1.0);
   public final occ2f8dff8d8 Ƣ = new occ2f8dff8d8("Drop trash", false);
   public final occ2f8dff8d8 Ɠ = new occ2f8dff8d8("Check durability", true);
   public final oca9cc61aada ſ = new occ4cfb65507("Sword slot", 1);
   public final oca9cc61aada Ԉ = new occ4cfb65507("Pickaxe slot", 1155867899 ^ 1155867896);
   public final oca9cc61aada ճ = new occ4cfb65507("Shovel slot", 1155867900 ^ 1155867896);
   public final oca9cc61aada ǌ = new occ4cfb65507("Axe slot", 1155867901 ^ 1155867896);
   public final oca9cc61aada Ѵ = new occ4cfb65507("Blocks slot", 1155867898 ^ 1155867896);
   public final oca9cc61aada շ = new oca9cc61aada("Blocks", 128.0, 64.0, 2304.0, 1.0);
   public final oca9cc61aada ɜ = new occ4cfb65507("Projectile slot", 1155867903 ^ 1155867896);
   public final oca9cc61aada ʨ = new oca9cc61aada("Projectiles", 64.0, 16.0, 2304.0, 1.0);
   public final oca9cc61aada Ƿ = new occ4cfb65507("Gold apple slot", 1155867889 ^ 1155867896);
   public final oca9cc61aada ɝ = new oca9cc61aada("Arrows", 256.0, 0.0, 2304.0, 1.0);
   public final oca9cc61aada ά = new occ4cfb65507("Bow slot", 1155867888 ^ 1155867896);
   private int ʪ = -1;
   private int r = -1;
   public static boolean ղ;

   private boolean Ĕ() {
      GameType var2 = null;
      int var3 = 732517651 ^ 1744311626;
      int var1 = oc84f20a0bc5.ė;

      while (true) {
         switch (var3) {
            case -459522931:
               if (var2 == GameType.ADVENTURE) {
                  var3 = 25377654 ^ 1744311626;
                  if (var1 == 0) {
                     break;
                  }
               }

               var3 = -58221398 ^ 1744311626;
               if (var1 == 0) {
                  break;
               }
            case -1686140448:
               return false;
            case 1280393305:
               var2 = Լ.playerController.getCurrentGameType();

               label36: {
                  label35: {
                     try {
                        if (var1 != 0) {
                           break label36;
                        }

                        if (var2 == GameType.SURVIVAL) {
                           break label35;
                        }
                     } catch (ocbde1165e4e var4) {
                        throw var4;
                     }

                     var3 = -2090587705 ^ 1744311626;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var3 = 25377654 ^ 1744311626;
               }

               if (var1 == 0) {
                  break;
               }
            case 1719348796:
               return true;
            default:
               throw null;
         }
      }
   }

   private int Ҳ(int var1) {
      int var2 = oc84f20a0bc5.ė;
      int var3 = 873685410 ^ -1364913162;

      while (true) {
         switch (var3) {
            case -1699319212:
               int var6;
               label47: {
                  label46: {
                     try {
                        var6 = var1;
                        if (var2 != 0) {
                           break label47;
                        }

                        if (var1 < (-1364913198 ^ -1364913162)) {
                           break label46;
                        }
                     } catch (ocbde1165e4e var5) {
                        throw var5;
                     }

                     var3 = 1254157372 ^ -1364913162;
                     if (var2 == 0) {
                        break;
                     }
                  }

                  var6 = -1649611530 ^ -1364913162;
               }

               var3 = var6;
               if (var2 == 0) {
                  break;
               }
            case 1684060197:
               return var1;
            case -463077430:
               return (-1364913154 ^ -1364913162) - (var1 - (-1364913198 ^ -1364913162));
            case 856293120:
               int var10000;
               label38: {
                  label37: {
                     try {
                        var10000 = var1;
                        if (var2 != 0) {
                           break label38;
                        }

                        if (var1 > (-1364913154 ^ -1364913162)) {
                           break label37;
                        }
                     } catch (ocbde1165e4e var4) {
                        throw var4;
                     }

                     var3 = -664005851 ^ -1364913162;
                     if (var2 == 0) {
                        break;
                     }
                  }

                  var10000 = -893015085 ^ -1364913162;
               }

               var3 = var10000;
               break;
            case 1992884435:
               return var1 + (-1364913198 ^ -1364913162);
            default:
               throw null;
         }
      }
   }

   private void ȭ(int param1, int param2, int param3, int param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 5
      // 05: aload 0
      // 06: iload 5
      // 08: ifne 30
      // 0b: getfield x/occddbf330f0.à Lx/occ2f8dff8d8;
      // 0e: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 11: ifeq 2b
      // 14: goto 18
      // 17: athrow
      // 18: aload 0
      // 19: iload 1
      // 1a: putfield x/occddbf330f0.ʪ I
      // 1d: iload 5
      // 1f: aload 0
      // 20: iload 2
      // 21: putfield x/occddbf330f0.r I
      // 24: ifeq 33
      // 27: goto 2b
      // 2a: athrow
      // 2b: aload 0
      // 2c: goto 30
      // 2f: athrow
      // 30: invokevirtual x/occddbf330f0.Ͼ ()V
      // 33: getstatic x/occddbf330f0.Լ Lnet/minecraft/client/Minecraft;
      // 36: getfield net/minecraft/client/Minecraft.playerController Lnet/minecraft/client/multiplayer/PlayerControllerMP;
      // 39: iload 1
      // 3a: iload 2
      // 3b: iload 3
      // 3c: iload 4
      // 3e: getstatic x/occddbf330f0.Լ Lnet/minecraft/client/Minecraft;
      // 41: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 44: invokevirtual net/minecraft/client/multiplayer/PlayerControllerMP.windowClick (IIIILnet/minecraft/entity/player/EntityPlayer;)Lnet/minecraft/item/ItemStack;
      // 47: pop
      // 48: return
   }

   private int ɑ(int var1) {
      ItemStack var3 = null;
      int var4 = -1754511455 ^ 318720523;
      int var2 = oc84f20a0bc5.ė;

      while (true) {
         switch (var4) {
            case -2053960278:
               int var10000;
               label54: {
                  label53: {
                     try {
                        var10000 = var1;
                        if (var2 != 0) {
                           break label54;
                        }

                        if (var1 != -1) {
                           break label53;
                        }
                     } catch (ocbde1165e4e var6) {
                        throw var6;
                     }

                     var4 = 1315520272 ^ 318720523;
                     if (var2 == 0) {
                        break;
                     }
                  }

                  var10000 = 1306767849 ^ 318720523;
               }

               var4 = var10000;
               if (var2 == 0) {
                  break;
               }
            case 1595735010:
               var3 = Լ.thePlayer.inventory.getStackInSlot(var1);

               label40: {
                  label39: {
                     try {
                        if (var2 != 0) {
                           break label40;
                        }

                        if (var3 == null) {
                           break label39;
                        }
                     } catch (ocbde1165e4e var5) {
                        throw var5;
                     }

                     var4 = 2059941757 ^ 318720523;
                     if (var2 == 0) {
                        break;
                     }
                  }

                  var4 = -1681423274 ^ 318720523;
               }

               if (var2 == 0) {
                  break;
               }

               return 0;
            case -1992765859:
               return 0;
            case 1553364251:
               return 0;
            case 1748467062:
               return var3.stackSize;
            default:
               throw null;
         }
      }
   }

   public occddbf330f0() {
      super("InvManager", oce4cea752dd.з);
      this.ą("Sorts your inventory, equips armor and drops trash.");
      this.ʌ(this.λ);
      this.ʌ(this.ǟ);
      this.ʌ(this.ѿ);
      this.ʌ(this.à);
      this.ʌ(this.δ);
      this.ʌ(this.Ȉ);
      this.ʌ(this.Ƣ);
      this.ʌ(this.Ɠ);
      this.ʌ(this.ſ);
      this.ʌ(this.Ԉ);
      this.ʌ(this.ճ);
      this.ʌ(this.ǌ);
      this.ʌ(this.Ѵ);
      this.ʌ(this.շ);
      this.ʌ(this.ɜ);
      this.ʌ(this.ʨ);
      this.ʌ(this.Ƿ);
      this.ʌ(this.ɝ);
      this.ʌ(this.ά);
   }

   @Override
   public void z$1sehylui0i4ix(oca9cc61aada param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 2
      // 04: aload 1
      // 05: aload 0
      // 06: iload 2
      // 07: ifne 57
      // 0a: getfield x/occddbf330f0.λ Lx/oca9cc61aada;
      // 0d: if_acmpne 49
      // 10: goto 14
      // 13: athrow
      // 14: aload 0
      // 15: getfield x/occddbf330f0.λ Lx/oca9cc61aada;
      // 18: iload 2
      // 19: ifne 4e
      // 1c: goto 20
      // 1f: athrow
      // 20: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 23: aload 0
      // 24: getfield x/occddbf330f0.ǟ Lx/oca9cc61aada;
      // 27: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 2a: dcmpl
      // 2b: ifle 49
      // 2e: goto 32
      // 31: athrow
      // 32: aload 0
      // 33: getfield x/occddbf330f0.ǟ Lx/oca9cc61aada;
      // 36: aload 0
      // 37: getfield x/occddbf330f0.λ Lx/oca9cc61aada;
      // 3a: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 3d: invokevirtual x/oca9cc61aada.Ȟ (D)D
      // 40: pop2
      // 41: iload 2
      // 42: ifeq 8e
      // 45: goto 49
      // 48: athrow
      // 49: aload 1
      // 4a: goto 4e
      // 4d: athrow
      // 4e: iload 2
      // 4f: ifne 6d
      // 52: aload 0
      // 53: goto 57
      // 56: athrow
      // 57: getfield x/occddbf330f0.ǟ Lx/oca9cc61aada;
      // 5a: if_acmpne 8e
      // 5d: aload 0
      // 5e: iload 2
      // 5f: ifne 80
      // 62: goto 66
      // 65: athrow
      // 66: getfield x/occddbf330f0.ǟ Lx/oca9cc61aada;
      // 69: goto 6d
      // 6c: athrow
      // 6d: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 70: aload 0
      // 71: getfield x/occddbf330f0.λ Lx/oca9cc61aada;
      // 74: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 77: dcmpg
      // 78: ifge 8e
      // 7b: aload 0
      // 7c: goto 80
      // 7f: athrow
      // 80: getfield x/occddbf330f0.λ Lx/oca9cc61aada;
      // 83: aload 0
      // 84: getfield x/occddbf330f0.ǟ Lx/oca9cc61aada;
      // 87: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 8a: invokevirtual x/oca9cc61aada.Ȟ (D)D
      // 8d: pop2
      // 8e: return
   }

   @Override
   public void z$2u87utkr1isxg() {
      this.Ȉ.ȉ(this.δ.ǭ(), this);
   }

   @oc66fa4f2195
   public void ԟ(oc2f61de30bc param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: istore 2
      // 004: aload 0
      // 005: iload 2
      // 006: ifne 022
      // 009: getfield x/occddbf330f0.Ƕ I
      // 00c: ifle 021
      // 00f: goto 013
      // 012: athrow
      // 013: aload 0
      // 014: dup
      // 015: getfield x/occddbf330f0.Ƕ I
      // 018: bipush 1
      // 019: isub
      // 01a: putfield x/occddbf330f0.Ƕ I
      // 01d: goto 021
      // 020: athrow
      // 021: aload 0
      // 022: getfield x/occddbf330f0.Ӣ I
      // 025: iload 2
      // 026: ifne 047
      // 029: ifle 03e
      // 02c: goto 030
      // 02f: athrow
      // 030: aload 0
      // 031: dup
      // 032: getfield x/occddbf330f0.Ӣ I
      // 035: bipush 1
      // 036: isub
      // 037: putfield x/occddbf330f0.Ӣ I
      // 03a: goto 03e
      // 03d: athrow
      // 03e: getstatic x/occddbf330f0.Լ Lnet/minecraft/client/Minecraft;
      // 041: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 044: instanceof net/minecraft/client/gui/inventory/GuiInventory
      // 047: iload 2
      // 048: ifne 089
      // 04b: ifeq 070
      // 04e: goto 052
      // 051: athrow
      // 052: getstatic x/occddbf330f0.Լ Lnet/minecraft/client/Minecraft;
      // 055: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 058: checkcast net/minecraft/client/gui/inventory/GuiInventory
      // 05b: getfield net/minecraft/client/gui/inventory/GuiInventory.inventorySlots Lnet/minecraft/inventory/Container;
      // 05e: instanceof net/minecraft/inventory/ContainerPlayer
      // 061: iload 2
      // 062: ifne 107
      // 065: goto 069
      // 068: athrow
      // 069: ifne 0f7
      // 06c: goto 070
      // 06f: athrow
      // 070: aload 0
      // 071: bipush 0
      // 072: putfield x/occddbf330f0.Ԣ Z
      // 075: aload 0
      // 076: iload 2
      // 077: ifne 08d
      // 07a: goto 07e
      // 07d: athrow
      // 07e: invokevirtual x/occddbf330f0.Ͼ ()V
      // 081: aload 0
      // 082: getfield x/occddbf330f0.Ƕ I
      // 085: goto 089
      // 088: athrow
      // 089: ifgt b6e
      // 08c: aload 0
      // 08d: iload 2
      // 08e: ifne 0a0
      // 091: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 094: ifeq b6e
      // 097: goto 09b
      // 09a: athrow
      // 09b: aload 0
      // 09c: goto 0a0
      // 09f: athrow
      // 0a0: iload 2
      // 0a1: ifne 0b3
      // 0a4: invokevirtual x/occddbf330f0.Ĕ ()Z
      // 0a7: ifeq b6e
      // 0aa: goto 0ae
      // 0ad: athrow
      // 0ae: aload 0
      // 0af: goto 0b3
      // 0b2: athrow
      // 0b3: iload 2
      // 0b4: ifne 0c9
      // 0b7: getfield x/occddbf330f0.δ Lx/occ2f8dff8d8;
      // 0ba: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 0bd: ifeq b6e
      // 0c0: goto 0c4
      // 0c3: athrow
      // 0c4: aload 0
      // 0c5: goto 0c9
      // 0c8: athrow
      // 0c9: iload 2
      // 0ca: ifne 0f0
      // 0cd: getfield x/occddbf330f0.Ê Lx/ocba5f31cad4;
      // 0d0: aload 0
      // 0d1: getfield x/occddbf330f0.Ȉ Lx/oca9cc61aada;
      // 0d4: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0d7: d2i
      // 0d8: i2l
      // 0d9: ldc2_w 6039391328298738428
      // 0dc: ldc2_w 6039391328298738382
      // 0df: lxor
      // 0e0: lmul
      // 0e1: invokevirtual x/ocba5f31cad4.Ũ (J)Z
      // 0e4: ifeq b6e
      // 0e7: goto 0eb
      // 0ea: athrow
      // 0eb: aload 0
      // 0ec: goto 0f0
      // 0ef: athrow
      // 0f0: invokevirtual x/occddbf330f0.Ը ()V
      // 0f3: iload 2
      // 0f4: ifeq b6e
      // 0f7: aload 0
      // 0f8: iload 2
      // 0f9: ifne 129
      // 0fc: goto 100
      // 0ff: athrow
      // 100: getfield x/occddbf330f0.Ԣ Z
      // 103: goto 107
      // 106: athrow
      // 107: ifne 128
      // 10a: aload 0
      // 10b: bipush 1
      // 10c: putfield x/occddbf330f0.Ԣ Z
      // 10f: aload 0
      // 110: aload 0
      // 111: getfield x/occddbf330f0.ѿ Lx/oca9cc61aada;
      // 114: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 117: d2i
      // 118: bipush 1
      // 119: iadd
      // 11a: putfield x/occddbf330f0.Ӣ I
      // 11d: aload 0
      // 11e: getfield x/occddbf330f0.Ê Lx/ocba5f31cad4;
      // 121: invokevirtual x/ocba5f31cad4.Ÿ ()V
      // 124: goto 128
      // 127: athrow
      // 128: aload 0
      // 129: iload 2
      // 12a: ifne 13c
      // 12d: getfield x/occddbf330f0.Ӣ I
      // 130: ifgt b6e
      // 133: goto 137
      // 136: athrow
      // 137: aload 0
      // 138: goto 13c
      // 13b: athrow
      // 13c: iload 2
      // 13d: ifne 14f
      // 140: getfield x/occddbf330f0.Ƕ I
      // 143: ifgt b6e
      // 146: goto 14a
      // 149: athrow
      // 14a: aload 0
      // 14b: goto 14f
      // 14e: athrow
      // 14f: iload 2
      // 150: ifne 162
      // 153: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 156: ifeq b6e
      // 159: goto 15d
      // 15c: athrow
      // 15d: aload 0
      // 15e: goto 162
      // 161: athrow
      // 162: invokevirtual x/occddbf330f0.Ĕ ()Z
      // 165: ifeq b6e
      // 168: new java/util/ArrayList
      // 16b: dup
      // 16c: ldc_w 1990041679
      // 16f: ldc_w 1990041675
      // 172: ixor
      // 173: anewarray 345
      // 176: dup
      // 177: bipush 0
      // 178: bipush -1
      // 179: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 17c: aastore
      // 17d: dup
      // 17e: bipush 1
      // 17f: bipush -1
      // 180: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 183: aastore
      // 184: dup
      // 185: ldc_w 1990041673
      // 188: ldc_w 1990041675
      // 18b: ixor
      // 18c: bipush -1
      // 18d: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 190: aastore
      // 191: dup
      // 192: ldc_w 1990041672
      // 195: ldc_w 1990041675
      // 198: ixor
      // 199: bipush -1
      // 19a: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 19d: aastore
      // 19e: invokestatic java/util/Arrays.asList ([Ljava/lang/Object;)Ljava/util/List;
      // 1a1: invokespecial java/util/ArrayList.<init> (Ljava/util/Collection;)V
      // 1a4: astore 3
      // 1a5: new java/util/ArrayList
      // 1a8: dup
      // 1a9: ldc_w 1990041679
      // 1ac: ldc_w 1990041675
      // 1af: ixor
      // 1b0: anewarray 345
      // 1b3: dup
      // 1b4: bipush 0
      // 1b5: bipush -1
      // 1b6: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 1b9: aastore
      // 1ba: dup
      // 1bb: bipush 1
      // 1bc: bipush -1
      // 1bd: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 1c0: aastore
      // 1c1: dup
      // 1c2: ldc_w 1990041673
      // 1c5: ldc_w 1990041675
      // 1c8: ixor
      // 1c9: bipush -1
      // 1ca: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 1cd: aastore
      // 1ce: dup
      // 1cf: ldc_w 1990041672
      // 1d2: ldc_w 1990041675
      // 1d5: ixor
      // 1d6: bipush -1
      // 1d7: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 1da: aastore
      // 1db: invokestatic java/util/Arrays.asList ([Ljava/lang/Object;)Ljava/util/List;
      // 1de: invokespecial java/util/ArrayList.<init> (Ljava/util/Collection;)V
      // 1e1: astore 4
      // 1e3: bipush 0
      // 1e4: istore 5
      // 1e6: iload 5
      // 1e8: ldc_w 1990041679
      // 1eb: ldc_w 1990041675
      // 1ee: ixor
      // 1ef: if_icmpge 222
      // 1f2: aload 3
      // 1f3: iload 5
      // 1f5: iload 5
      // 1f7: bipush 1
      // 1f8: invokestatic x/oc7fbc83d9b3.Ǵ (IZ)I
      // 1fb: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 1fe: invokevirtual java/util/ArrayList.set (ILjava/lang/Object;)Ljava/lang/Object;
      // 201: pop
      // 202: iload 2
      // 203: ifne 22e
      // 206: aload 4
      // 208: iload 5
      // 20a: iload 5
      // 20c: bipush 0
      // 20d: invokestatic x/oc7fbc83d9b3.Ǵ (IZ)I
      // 210: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 213: invokevirtual java/util/ArrayList.set (ILjava/lang/Object;)Ljava/lang/Object;
      // 216: pop
      // 217: iload 2
      // 218: iinc 5 1
      // 21b: ifeq 1e6
      // 21e: goto 222
      // 221: athrow
      // 222: aload 0
      // 223: getfield x/occddbf330f0.ſ Lx/oca9cc61aada;
      // 226: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 229: d2i
      // 22a: bipush 1
      // 22b: isub
      // 22c: istore 5
      // 22e: iload 5
      // 230: aload 0
      // 231: getfield x/occddbf330f0.Ɠ Lx/occ2f8dff8d8;
      // 234: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 237: invokestatic x/oc7fbc83d9b3.ʭ (IZ)I
      // 23a: istore 6
      // 23c: iload 6
      // 23e: iload 2
      // 23f: ifne 25c
      // 242: bipush -1
      // 243: if_icmpne 252
      // 246: goto 24a
      // 249: athrow
      // 24a: iload 5
      // 24c: bipush 0
      // 24d: invokestatic x/oc7fbc83d9b3.ʭ (IZ)I
      // 250: istore 6
      // 252: aload 0
      // 253: getfield x/occddbf330f0.Ԉ Lx/oca9cc61aada;
      // 256: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 259: d2i
      // 25a: bipush 1
      // 25b: isub
      // 25c: istore 7
      // 25e: ldc_w "pickaxe"
      // 261: iload 7
      // 263: aload 0
      // 264: getfield x/occddbf330f0.Ɠ Lx/occ2f8dff8d8;
      // 267: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 26a: invokestatic x/oc7fbc83d9b3.Ň (Ljava/lang/String;IZ)I
      // 26d: istore 8
      // 26f: iload 8
      // 271: iload 2
      // 272: ifne 292
      // 275: bipush -1
      // 276: if_icmpne 288
      // 279: goto 27d
      // 27c: athrow
      // 27d: ldc_w "pickaxe"
      // 280: iload 7
      // 282: bipush 0
      // 283: invokestatic x/oc7fbc83d9b3.Ň (Ljava/lang/String;IZ)I
      // 286: istore 8
      // 288: aload 0
      // 289: getfield x/occddbf330f0.ճ Lx/oca9cc61aada;
      // 28c: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 28f: d2i
      // 290: bipush 1
      // 291: isub
      // 292: istore 9
      // 294: ldc_w "shovel"
      // 297: iload 9
      // 299: aload 0
      // 29a: getfield x/occddbf330f0.Ɠ Lx/occ2f8dff8d8;
      // 29d: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 2a0: invokestatic x/oc7fbc83d9b3.Ň (Ljava/lang/String;IZ)I
      // 2a3: istore 10
      // 2a5: iload 10
      // 2a7: iload 2
      // 2a8: ifne 2c8
      // 2ab: bipush -1
      // 2ac: if_icmpne 2be
      // 2af: goto 2b3
      // 2b2: athrow
      // 2b3: ldc_w "shovel"
      // 2b6: iload 9
      // 2b8: bipush 0
      // 2b9: invokestatic x/oc7fbc83d9b3.Ň (Ljava/lang/String;IZ)I
      // 2bc: istore 10
      // 2be: aload 0
      // 2bf: getfield x/occddbf330f0.ǌ Lx/oca9cc61aada;
      // 2c2: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 2c5: d2i
      // 2c6: bipush 1
      // 2c7: isub
      // 2c8: istore 11
      // 2ca: ldc_w "axe"
      // 2cd: iload 11
      // 2cf: aload 0
      // 2d0: getfield x/occddbf330f0.Ɠ Lx/occ2f8dff8d8;
      // 2d3: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 2d6: invokestatic x/oc7fbc83d9b3.Ň (Ljava/lang/String;IZ)I
      // 2d9: istore 12
      // 2db: iload 12
      // 2dd: iload 2
      // 2de: ifne 2fe
      // 2e1: bipush -1
      // 2e2: if_icmpne 2f4
      // 2e5: goto 2e9
      // 2e8: athrow
      // 2e9: ldc_w "axe"
      // 2ec: iload 11
      // 2ee: bipush 0
      // 2ef: invokestatic x/oc7fbc83d9b3.Ň (Ljava/lang/String;IZ)I
      // 2f2: istore 12
      // 2f4: aload 0
      // 2f5: getfield x/occddbf330f0.Ѵ Lx/oca9cc61aada;
      // 2f8: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 2fb: d2i
      // 2fc: bipush 1
      // 2fd: isub
      // 2fe: istore 13
      // 300: iload 13
      // 302: getstatic x/oc3ec0054e46.k Lx/oc3ec0054e46;
      // 305: invokestatic x/oc7fbc83d9b3.д (ILx/oc3ec0054e46;)I
      // 308: istore 14
      // 30a: aload 0
      // 30b: getfield x/occddbf330f0.ɜ Lx/oca9cc61aada;
      // 30e: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 311: d2i
      // 312: bipush 1
      // 313: isub
      // 314: istore 15
      // 316: iload 15
      // 318: getstatic x/oc3ec0054e46.Ϲ Lx/oc3ec0054e46;
      // 31b: invokestatic x/oc7fbc83d9b3.д (ILx/oc3ec0054e46;)I
      // 31e: istore 16
      // 320: iload 16
      // 322: iload 2
      // 323: ifne 342
      // 326: bipush -1
      // 327: if_icmpne 338
      // 32a: goto 32e
      // 32d: athrow
      // 32e: iload 15
      // 330: getstatic x/oc3ec0054e46.Ǒ Lx/oc3ec0054e46;
      // 333: invokestatic x/oc7fbc83d9b3.д (ILx/oc3ec0054e46;)I
      // 336: istore 16
      // 338: aload 0
      // 339: getfield x/occddbf330f0.Ƿ Lx/oca9cc61aada;
      // 33c: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 33f: d2i
      // 340: bipush 1
      // 341: isub
      // 342: istore 17
      // 344: iload 17
      // 346: getstatic x/oc3ec0054e46.т Lx/oc3ec0054e46;
      // 349: invokestatic x/oc7fbc83d9b3.д (ILx/oc3ec0054e46;)I
      // 34c: istore 18
      // 34e: aload 0
      // 34f: getfield x/occddbf330f0.ά Lx/oca9cc61aada;
      // 352: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 355: d2i
      // 356: bipush 1
      // 357: isub
      // 358: istore 19
      // 35a: iload 19
      // 35c: aload 0
      // 35d: getfield x/occddbf330f0.Ɠ Lx/occ2f8dff8d8;
      // 360: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 363: invokestatic x/oc7fbc83d9b3.Ǚ (IZ)I
      // 366: istore 20
      // 368: iload 20
      // 36a: iload 2
      // 36b: ifne 38d
      // 36e: bipush -1
      // 36f: if_icmpne 37e
      // 372: goto 376
      // 375: athrow
      // 376: iload 19
      // 378: bipush 0
      // 379: invokestatic x/oc7fbc83d9b3.Ǚ (IZ)I
      // 37c: istore 20
      // 37e: aload 0
      // 37f: iload 2
      // 380: ifne 391
      // 383: getfield x/occddbf330f0.δ Lx/occ2f8dff8d8;
      // 386: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 389: goto 38d
      // 38c: athrow
      // 38d: ifeq 4ee
      // 390: aload 0
      // 391: getfield x/occddbf330f0.Ê Lx/ocba5f31cad4;
      // 394: aload 0
      // 395: getfield x/occddbf330f0.Ȉ Lx/oca9cc61aada;
      // 398: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 39b: d2i
      // 39c: i2l
      // 39d: ldc2_w 6039391328298738428
      // 3a0: ldc2_w 6039391328298738382
      // 3a3: lxor
      // 3a4: lmul
      // 3a5: invokevirtual x/ocba5f31cad4.Ũ (J)Z
      // 3a8: iload 2
      // 3a9: ifne 3b4
      // 3ac: ifeq 4ee
      // 3af: goto 3b3
      // 3b2: athrow
      // 3b3: bipush 0
      // 3b4: istore 21
      // 3b6: iload 21
      // 3b8: ldc_w 1990041679
      // 3bb: ldc_w 1990041675
      // 3be: ixor
      // 3bf: if_icmpge 4ee
      // 3c2: aload 3
      // 3c3: iload 21
      // 3c5: invokevirtual java/util/ArrayList.get (I)Ljava/lang/Object;
      // 3c8: checkcast java/lang/Integer
      // 3cb: invokevirtual java/lang/Integer.intValue ()I
      // 3ce: istore 22
      // 3d0: iload 2
      // 3d1: aload 4
      // 3d3: iload 21
      // 3d5: invokevirtual java/util/ArrayList.get (I)Ljava/lang/Object;
      // 3d8: checkcast java/lang/Integer
      // 3db: invokevirtual java/lang/Integer.intValue ()I
      // 3de: istore 23
      // 3e0: ifne b6e
      // 3e3: iload 22
      // 3e5: iload 2
      // 3e6: ifne 415
      // 3e9: goto 3ed
      // 3ec: athrow
      // 3ed: bipush -1
      // 3ee: if_icmpne 407
      // 3f1: goto 3f5
      // 3f4: athrow
      // 3f5: iload 23
      // 3f7: iload 2
      // 3f8: ifne 415
      // 3fb: goto 3ff
      // 3fe: athrow
      // 3ff: bipush -1
      // 400: if_icmpeq 4e7
      // 403: goto 407
      // 406: athrow
      // 407: ldc_w 1990041708
      // 40a: ldc_w 1990041675
      // 40d: ixor
      // 40e: iload 21
      // 410: isub
      // 411: goto 415
      // 414: athrow
      // 415: istore 24
      // 417: iload 2
      // 418: ifne 4ea
      // 41b: iload 22
      // 41d: iload 24
      // 41f: if_icmpeq 4e7
      // 422: goto 426
      // 425: athrow
      // 426: iload 23
      // 428: iload 24
      // 42a: if_icmpeq 4e7
      // 42d: goto 431
      // 430: athrow
      // 431: getstatic x/occddbf330f0.Լ Lnet/minecraft/client/Minecraft;
      // 434: iload 2
      // 435: ifne 455
      // 438: goto 43c
      // 43b: athrow
      // 43c: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 43f: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 442: iload 24
      // 444: invokevirtual net/minecraft/entity/player/InventoryPlayer.getStackInSlot (I)Lnet/minecraft/item/ItemStack;
      // 447: ifnull 4a8
      // 44a: goto 44e
      // 44d: athrow
      // 44e: getstatic x/occddbf330f0.Լ Lnet/minecraft/client/Minecraft;
      // 451: goto 455
      // 454: athrow
      // 455: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 458: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 45b: invokevirtual net/minecraft/entity/player/InventoryPlayer.getFirstEmptyStack ()I
      // 45e: bipush -1
      // 45f: if_icmpeq 482
      // 462: aload 0
      // 463: getstatic x/occddbf330f0.Լ Lnet/minecraft/client/Minecraft;
      // 466: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 469: getfield net/minecraft/client/entity/EntityPlayerSP.inventoryContainer Lnet/minecraft/inventory/Container;
      // 46c: getfield net/minecraft/inventory/Container.windowId I
      // 46f: aload 0
      // 470: iload 24
      // 472: invokevirtual x/occddbf330f0.Ҳ (I)I
      // 475: bipush 0
      // 476: bipush 1
      // 477: invokevirtual x/occddbf330f0.ȭ (IIII)V
      // 47a: iload 2
      // 47b: ifeq 4e6
      // 47e: goto 482
      // 481: athrow
      // 482: aload 0
      // 483: getstatic x/occddbf330f0.Լ Lnet/minecraft/client/Minecraft;
      // 486: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 489: getfield net/minecraft/client/entity/EntityPlayerSP.inventoryContainer Lnet/minecraft/inventory/Container;
      // 48c: getfield net/minecraft/inventory/Container.windowId I
      // 48f: aload 0
      // 490: iload 24
      // 492: invokevirtual x/occddbf330f0.Ҳ (I)I
      // 495: bipush 1
      // 496: ldc_w 1990041679
      // 499: ldc_w 1990041675
      // 49c: ixor
      // 49d: invokevirtual x/occddbf330f0.ȭ (IIII)V
      // 4a0: iload 2
      // 4a1: ifeq 4e6
      // 4a4: goto 4a8
      // 4a7: athrow
      // 4a8: iload 22
      // 4aa: iload 2
      // 4ab: ifne 4c0
      // 4ae: goto 4b2
      // 4b1: athrow
      // 4b2: bipush -1
      // 4b3: if_icmpeq 4c3
      // 4b6: goto 4ba
      // 4b9: athrow
      // 4ba: iload 22
      // 4bc: goto 4c0
      // 4bf: athrow
      // 4c0: goto 4c5
      // 4c3: iload 23
      // 4c5: istore 25
      // 4c7: aload 0
      // 4c8: getstatic x/occddbf330f0.Լ Lnet/minecraft/client/Minecraft;
      // 4cb: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 4ce: getfield net/minecraft/client/entity/EntityPlayerSP.inventoryContainer Lnet/minecraft/inventory/Container;
      // 4d1: getfield net/minecraft/inventory/Container.windowId I
      // 4d4: aload 0
      // 4d5: iload 25
      // 4d7: invokevirtual x/occddbf330f0.Ҳ (I)I
      // 4da: bipush 0
      // 4db: bipush 1
      // 4dc: invokevirtual x/occddbf330f0.ȭ (IIII)V
      // 4df: aload 0
      // 4e0: getfield x/occddbf330f0.Ê Lx/ocba5f31cad4;
      // 4e3: invokevirtual x/ocba5f31cad4.Ÿ ()V
      // 4e6: return
      // 4e7: iinc 21 1
      // 4ea: iload 2
      // 4eb: ifeq 3b6
      // 4ee: new java/util/LinkedHashSet
      // 4f1: dup
      // 4f2: invokespecial java/util/LinkedHashSet.<init> ()V
      // 4f5: astore 21
      // 4f7: iload 5
      // 4f9: iload 2
      // 4fa: ifne 56f
      // 4fd: iflt 56d
      // 500: goto 504
      // 503: athrow
      // 504: iload 5
      // 506: iload 2
      // 507: ifne 56f
      // 50a: goto 50e
      // 50d: athrow
      // 50e: ldc_w 1990041667
      // 511: ldc_w 1990041675
      // 514: ixor
      // 515: if_icmpgt 56d
      // 518: goto 51c
      // 51b: athrow
      // 51c: iload 6
      // 51e: iload 2
      // 51f: ifne 56f
      // 522: goto 526
      // 525: athrow
      // 526: bipush -1
      // 527: if_icmpeq 56d
      // 52a: goto 52e
      // 52d: athrow
      // 52e: aload 21
      // 530: iload 5
      // 532: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 535: invokevirtual java/util/LinkedHashSet.add (Ljava/lang/Object;)Z
      // 538: iload 2
      // 539: ifne 56f
      // 53c: goto 540
      // 53f: athrow
      // 540: pop
      // 541: iload 6
      // 543: iload 5
      // 545: if_icmpeq 56d
      // 548: goto 54c
      // 54b: athrow
      // 54c: aload 0
      // 54d: getstatic x/occddbf330f0.Լ Lnet/minecraft/client/Minecraft;
      // 550: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 553: getfield net/minecraft/client/entity/EntityPlayerSP.inventoryContainer Lnet/minecraft/inventory/Container;
      // 556: getfield net/minecraft/inventory/Container.windowId I
      // 559: aload 0
      // 55a: iload 6
      // 55c: invokevirtual x/occddbf330f0.Ҳ (I)I
      // 55f: iload 5
      // 561: ldc_w 1990041673
      // 564: ldc_w 1990041675
      // 567: ixor
      // 568: invokevirtual x/occddbf330f0.ȭ (IIII)V
      // 56b: return
      // 56c: athrow
      // 56d: iload 7
      // 56f: iload 2
      // 570: ifne 5fe
      // 573: iflt 5fc
      // 576: goto 57a
      // 579: athrow
      // 57a: iload 7
      // 57c: iload 2
      // 57d: ifne 5fe
      // 580: goto 584
      // 583: athrow
      // 584: ldc_w 1990041667
      // 587: ldc_w 1990041675
      // 58a: ixor
      // 58b: if_icmpgt 5fc
      // 58e: goto 592
      // 591: athrow
      // 592: aload 21
      // 594: iload 7
      // 596: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 599: invokevirtual java/util/LinkedHashSet.contains (Ljava/lang/Object;)Z
      // 59c: iload 2
      // 59d: ifne 5fe
      // 5a0: goto 5a4
      // 5a3: athrow
      // 5a4: ifne 5fc
      // 5a7: goto 5ab
      // 5aa: athrow
      // 5ab: iload 8
      // 5ad: iload 2
      // 5ae: ifne 5fe
      // 5b1: goto 5b5
      // 5b4: athrow
      // 5b5: bipush -1
      // 5b6: if_icmpeq 5fc
      // 5b9: goto 5bd
      // 5bc: athrow
      // 5bd: aload 21
      // 5bf: iload 7
      // 5c1: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 5c4: invokevirtual java/util/LinkedHashSet.add (Ljava/lang/Object;)Z
      // 5c7: iload 2
      // 5c8: ifne 5fe
      // 5cb: goto 5cf
      // 5ce: athrow
      // 5cf: pop
      // 5d0: iload 8
      // 5d2: iload 7
      // 5d4: if_icmpeq 5fc
      // 5d7: goto 5db
      // 5da: athrow
      // 5db: aload 0
      // 5dc: getstatic x/occddbf330f0.Լ Lnet/minecraft/client/Minecraft;
      // 5df: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 5e2: getfield net/minecraft/client/entity/EntityPlayerSP.inventoryContainer Lnet/minecraft/inventory/Container;
      // 5e5: getfield net/minecraft/inventory/Container.windowId I
      // 5e8: aload 0
      // 5e9: iload 8
      // 5eb: invokevirtual x/occddbf330f0.Ҳ (I)I
      // 5ee: iload 7
      // 5f0: ldc_w 1990041673
      // 5f3: ldc_w 1990041675
      // 5f6: ixor
      // 5f7: invokevirtual x/occddbf330f0.ȭ (IIII)V
      // 5fa: return
      // 5fb: athrow
      // 5fc: iload 9
      // 5fe: iload 2
      // 5ff: ifne 68d
      // 602: iflt 68b
      // 605: goto 609
      // 608: athrow
      // 609: iload 9
      // 60b: iload 2
      // 60c: ifne 68d
      // 60f: goto 613
      // 612: athrow
      // 613: ldc_w 1990041667
      // 616: ldc_w 1990041675
      // 619: ixor
      // 61a: if_icmpgt 68b
      // 61d: goto 621
      // 620: athrow
      // 621: aload 21
      // 623: iload 9
      // 625: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 628: invokevirtual java/util/LinkedHashSet.contains (Ljava/lang/Object;)Z
      // 62b: iload 2
      // 62c: ifne 68d
      // 62f: goto 633
      // 632: athrow
      // 633: ifne 68b
      // 636: goto 63a
      // 639: athrow
      // 63a: iload 10
      // 63c: iload 2
      // 63d: ifne 68d
      // 640: goto 644
      // 643: athrow
      // 644: bipush -1
      // 645: if_icmpeq 68b
      // 648: goto 64c
      // 64b: athrow
      // 64c: aload 21
      // 64e: iload 9
      // 650: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 653: invokevirtual java/util/LinkedHashSet.add (Ljava/lang/Object;)Z
      // 656: iload 2
      // 657: ifne 68d
      // 65a: goto 65e
      // 65d: athrow
      // 65e: pop
      // 65f: iload 10
      // 661: iload 9
      // 663: if_icmpeq 68b
      // 666: goto 66a
      // 669: athrow
      // 66a: aload 0
      // 66b: getstatic x/occddbf330f0.Լ Lnet/minecraft/client/Minecraft;
      // 66e: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 671: getfield net/minecraft/client/entity/EntityPlayerSP.inventoryContainer Lnet/minecraft/inventory/Container;
      // 674: getfield net/minecraft/inventory/Container.windowId I
      // 677: aload 0
      // 678: iload 10
      // 67a: invokevirtual x/occddbf330f0.Ҳ (I)I
      // 67d: iload 9
      // 67f: ldc_w 1990041673
      // 682: ldc_w 1990041675
      // 685: ixor
      // 686: invokevirtual x/occddbf330f0.ȭ (IIII)V
      // 689: return
      // 68a: athrow
      // 68b: iload 11
      // 68d: iload 2
      // 68e: ifne 71c
      // 691: iflt 71a
      // 694: goto 698
      // 697: athrow
      // 698: iload 11
      // 69a: iload 2
      // 69b: ifne 71c
      // 69e: goto 6a2
      // 6a1: athrow
      // 6a2: ldc_w 1990041667
      // 6a5: ldc_w 1990041675
      // 6a8: ixor
      // 6a9: if_icmpgt 71a
      // 6ac: goto 6b0
      // 6af: athrow
      // 6b0: aload 21
      // 6b2: iload 11
      // 6b4: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 6b7: invokevirtual java/util/LinkedHashSet.contains (Ljava/lang/Object;)Z
      // 6ba: iload 2
      // 6bb: ifne 71c
      // 6be: goto 6c2
      // 6c1: athrow
      // 6c2: ifne 71a
      // 6c5: goto 6c9
      // 6c8: athrow
      // 6c9: iload 12
      // 6cb: iload 2
      // 6cc: ifne 71c
      // 6cf: goto 6d3
      // 6d2: athrow
      // 6d3: bipush -1
      // 6d4: if_icmpeq 71a
      // 6d7: goto 6db
      // 6da: athrow
      // 6db: aload 21
      // 6dd: iload 11
      // 6df: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 6e2: invokevirtual java/util/LinkedHashSet.add (Ljava/lang/Object;)Z
      // 6e5: iload 2
      // 6e6: ifne 71c
      // 6e9: goto 6ed
      // 6ec: athrow
      // 6ed: pop
      // 6ee: iload 12
      // 6f0: iload 11
      // 6f2: if_icmpeq 71a
      // 6f5: goto 6f9
      // 6f8: athrow
      // 6f9: aload 0
      // 6fa: getstatic x/occddbf330f0.Լ Lnet/minecraft/client/Minecraft;
      // 6fd: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 700: getfield net/minecraft/client/entity/EntityPlayerSP.inventoryContainer Lnet/minecraft/inventory/Container;
      // 703: getfield net/minecraft/inventory/Container.windowId I
      // 706: aload 0
      // 707: iload 12
      // 709: invokevirtual x/occddbf330f0.Ҳ (I)I
      // 70c: iload 11
      // 70e: ldc_w 1990041673
      // 711: ldc_w 1990041675
      // 714: ixor
      // 715: invokevirtual x/occddbf330f0.ȭ (IIII)V
      // 718: return
      // 719: athrow
      // 71a: iload 13
      // 71c: iload 2
      // 71d: ifne 7ab
      // 720: iflt 7a9
      // 723: goto 727
      // 726: athrow
      // 727: iload 13
      // 729: iload 2
      // 72a: ifne 7ab
      // 72d: goto 731
      // 730: athrow
      // 731: ldc_w 1990041667
      // 734: ldc_w 1990041675
      // 737: ixor
      // 738: if_icmpgt 7a9
      // 73b: goto 73f
      // 73e: athrow
      // 73f: aload 21
      // 741: iload 13
      // 743: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 746: invokevirtual java/util/LinkedHashSet.contains (Ljava/lang/Object;)Z
      // 749: iload 2
      // 74a: ifne 7ab
      // 74d: goto 751
      // 750: athrow
      // 751: ifne 7a9
      // 754: goto 758
      // 757: athrow
      // 758: iload 14
      // 75a: iload 2
      // 75b: ifne 7ab
      // 75e: goto 762
      // 761: athrow
      // 762: bipush -1
      // 763: if_icmpeq 7a9
      // 766: goto 76a
      // 769: athrow
      // 76a: aload 21
      // 76c: iload 13
      // 76e: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 771: invokevirtual java/util/LinkedHashSet.add (Ljava/lang/Object;)Z
      // 774: iload 2
      // 775: ifne 7ab
      // 778: goto 77c
      // 77b: athrow
      // 77c: pop
      // 77d: iload 14
      // 77f: iload 13
      // 781: if_icmpeq 7a9
      // 784: goto 788
      // 787: athrow
      // 788: aload 0
      // 789: getstatic x/occddbf330f0.Լ Lnet/minecraft/client/Minecraft;
      // 78c: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 78f: getfield net/minecraft/client/entity/EntityPlayerSP.inventoryContainer Lnet/minecraft/inventory/Container;
      // 792: getfield net/minecraft/inventory/Container.windowId I
      // 795: aload 0
      // 796: iload 14
      // 798: invokevirtual x/occddbf330f0.Ҳ (I)I
      // 79b: iload 13
      // 79d: ldc_w 1990041673
      // 7a0: ldc_w 1990041675
      // 7a3: ixor
      // 7a4: invokevirtual x/occddbf330f0.ȭ (IIII)V
      // 7a7: return
      // 7a8: athrow
      // 7a9: iload 15
      // 7ab: iload 2
      // 7ac: ifne 83a
      // 7af: iflt 838
      // 7b2: goto 7b6
      // 7b5: athrow
      // 7b6: iload 15
      // 7b8: iload 2
      // 7b9: ifne 83a
      // 7bc: goto 7c0
      // 7bf: athrow
      // 7c0: ldc_w 1990041667
      // 7c3: ldc_w 1990041675
      // 7c6: ixor
      // 7c7: if_icmpgt 838
      // 7ca: goto 7ce
      // 7cd: athrow
      // 7ce: aload 21
      // 7d0: iload 15
      // 7d2: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 7d5: invokevirtual java/util/LinkedHashSet.contains (Ljava/lang/Object;)Z
      // 7d8: iload 2
      // 7d9: ifne 83a
      // 7dc: goto 7e0
      // 7df: athrow
      // 7e0: ifne 838
      // 7e3: goto 7e7
      // 7e6: athrow
      // 7e7: iload 16
      // 7e9: iload 2
      // 7ea: ifne 83a
      // 7ed: goto 7f1
      // 7f0: athrow
      // 7f1: bipush -1
      // 7f2: if_icmpeq 838
      // 7f5: goto 7f9
      // 7f8: athrow
      // 7f9: aload 21
      // 7fb: iload 15
      // 7fd: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 800: invokevirtual java/util/LinkedHashSet.add (Ljava/lang/Object;)Z
      // 803: iload 2
      // 804: ifne 83a
      // 807: goto 80b
      // 80a: athrow
      // 80b: pop
      // 80c: iload 16
      // 80e: iload 15
      // 810: if_icmpeq 838
      // 813: goto 817
      // 816: athrow
      // 817: aload 0
      // 818: getstatic x/occddbf330f0.Լ Lnet/minecraft/client/Minecraft;
      // 81b: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 81e: getfield net/minecraft/client/entity/EntityPlayerSP.inventoryContainer Lnet/minecraft/inventory/Container;
      // 821: getfield net/minecraft/inventory/Container.windowId I
      // 824: aload 0
      // 825: iload 16
      // 827: invokevirtual x/occddbf330f0.Ҳ (I)I
      // 82a: iload 15
      // 82c: ldc_w 1990041673
      // 82f: ldc_w 1990041675
      // 832: ixor
      // 833: invokevirtual x/occddbf330f0.ȭ (IIII)V
      // 836: return
      // 837: athrow
      // 838: iload 17
      // 83a: iload 2
      // 83b: ifne 8c9
      // 83e: iflt 8c7
      // 841: goto 845
      // 844: athrow
      // 845: iload 17
      // 847: iload 2
      // 848: ifne 8c9
      // 84b: goto 84f
      // 84e: athrow
      // 84f: ldc_w 1990041667
      // 852: ldc_w 1990041675
      // 855: ixor
      // 856: if_icmpgt 8c7
      // 859: goto 85d
      // 85c: athrow
      // 85d: aload 21
      // 85f: iload 17
      // 861: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 864: invokevirtual java/util/LinkedHashSet.contains (Ljava/lang/Object;)Z
      // 867: iload 2
      // 868: ifne 8c9
      // 86b: goto 86f
      // 86e: athrow
      // 86f: ifne 8c7
      // 872: goto 876
      // 875: athrow
      // 876: iload 18
      // 878: iload 2
      // 879: ifne 8c9
      // 87c: goto 880
      // 87f: athrow
      // 880: bipush -1
      // 881: if_icmpeq 8c7
      // 884: goto 888
      // 887: athrow
      // 888: aload 21
      // 88a: iload 17
      // 88c: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 88f: invokevirtual java/util/LinkedHashSet.add (Ljava/lang/Object;)Z
      // 892: iload 2
      // 893: ifne 8c9
      // 896: goto 89a
      // 899: athrow
      // 89a: pop
      // 89b: iload 18
      // 89d: iload 17
      // 89f: if_icmpeq 8c7
      // 8a2: goto 8a6
      // 8a5: athrow
      // 8a6: aload 0
      // 8a7: getstatic x/occddbf330f0.Լ Lnet/minecraft/client/Minecraft;
      // 8aa: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 8ad: getfield net/minecraft/client/entity/EntityPlayerSP.inventoryContainer Lnet/minecraft/inventory/Container;
      // 8b0: getfield net/minecraft/inventory/Container.windowId I
      // 8b3: aload 0
      // 8b4: iload 18
      // 8b6: invokevirtual x/occddbf330f0.Ҳ (I)I
      // 8b9: iload 17
      // 8bb: ldc_w 1990041673
      // 8be: ldc_w 1990041675
      // 8c1: ixor
      // 8c2: invokevirtual x/occddbf330f0.ȭ (IIII)V
      // 8c5: return
      // 8c6: athrow
      // 8c7: iload 19
      // 8c9: iload 2
      // 8ca: ifne 965
      // 8cd: iflt 956
      // 8d0: goto 8d4
      // 8d3: athrow
      // 8d4: iload 19
      // 8d6: iload 2
      // 8d7: ifne 965
      // 8da: goto 8de
      // 8dd: athrow
      // 8de: ldc_w 1990041667
      // 8e1: ldc_w 1990041675
      // 8e4: ixor
      // 8e5: if_icmpgt 956
      // 8e8: goto 8ec
      // 8eb: athrow
      // 8ec: aload 21
      // 8ee: iload 19
      // 8f0: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 8f3: invokevirtual java/util/LinkedHashSet.contains (Ljava/lang/Object;)Z
      // 8f6: iload 2
      // 8f7: ifne 965
      // 8fa: goto 8fe
      // 8fd: athrow
      // 8fe: ifne 956
      // 901: goto 905
      // 904: athrow
      // 905: iload 20
      // 907: iload 2
      // 908: ifne 965
      // 90b: goto 90f
      // 90e: athrow
      // 90f: bipush -1
      // 910: if_icmpeq 956
      // 913: goto 917
      // 916: athrow
      // 917: aload 21
      // 919: iload 19
      // 91b: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 91e: invokevirtual java/util/LinkedHashSet.add (Ljava/lang/Object;)Z
      // 921: iload 2
      // 922: ifne 965
      // 925: goto 929
      // 928: athrow
      // 929: pop
      // 92a: iload 20
      // 92c: iload 19
      // 92e: if_icmpeq 956
      // 931: goto 935
      // 934: athrow
      // 935: aload 0
      // 936: getstatic x/occddbf330f0.Լ Lnet/minecraft/client/Minecraft;
      // 939: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 93c: getfield net/minecraft/client/entity/EntityPlayerSP.inventoryContainer Lnet/minecraft/inventory/Container;
      // 93f: getfield net/minecraft/inventory/Container.windowId I
      // 942: aload 0
      // 943: iload 20
      // 945: invokevirtual x/occddbf330f0.Ҳ (I)I
      // 948: iload 19
      // 94a: ldc_w 1990041673
      // 94d: ldc_w 1990041675
      // 950: ixor
      // 951: invokevirtual x/occddbf330f0.ȭ (IIII)V
      // 954: return
      // 955: athrow
      // 956: aload 0
      // 957: iload 2
      // 958: ifne 969
      // 95b: getfield x/occddbf330f0.Ƣ Lx/occ2f8dff8d8;
      // 95e: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 961: goto 965
      // 964: athrow
      // 965: ifeq b6e
      // 968: aload 0
      // 969: iload 14
      // 96b: invokevirtual x/occddbf330f0.ɑ (I)I
      // 96e: istore 22
      // 970: aload 0
      // 971: iload 16
      // 973: invokevirtual x/occddbf330f0.ɑ (I)I
      // 976: istore 23
      // 978: bipush 0
      // 979: istore 24
      // 97b: bipush 0
      // 97c: istore 25
      // 97e: iload 25
      // 980: ldc_w 1990041711
      // 983: ldc_w 1990041675
      // 986: ixor
      // 987: if_icmpge b6e
      // 98a: aload 3
      // 98b: iload 2
      // 98c: ifne 9a4
      // 98f: iload 25
      // 991: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 994: invokevirtual java/util/ArrayList.contains (Ljava/lang/Object;)Z
      // 997: ifne b67
      // 99a: goto 99e
      // 99d: athrow
      // 99e: aload 4
      // 9a0: goto 9a4
      // 9a3: athrow
      // 9a4: iload 25
      // 9a6: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 9a9: invokevirtual java/util/ArrayList.contains (Ljava/lang/Object;)Z
      // 9ac: iload 2
      // 9ad: ifne 9d0
      // 9b0: ifne b67
      // 9b3: goto 9b7
      // 9b6: athrow
      // 9b7: iload 25
      // 9b9: iload 2
      // 9ba: ifne 9d5
      // 9bd: goto 9c1
      // 9c0: athrow
      // 9c1: iload 5
      // 9c3: iload 7
      // 9c5: iload 9
      // 9c7: iload 11
      // 9c9: invokestatic x/occddbf330f0.ʦ (IIIII)Z
      // 9cc: goto 9d0
      // 9cf: athrow
      // 9d0: ifne b67
      // 9d3: iload 6
      // 9d5: iload 2
      // 9d6: ifne 9e8
      // 9d9: iload 25
      // 9db: if_icmpeq b67
      // 9de: goto 9e2
      // 9e1: athrow
      // 9e2: iload 8
      // 9e4: goto 9e8
      // 9e7: athrow
      // 9e8: iload 2
      // 9e9: ifne 9fb
      // 9ec: iload 25
      // 9ee: if_icmpeq b67
      // 9f1: goto 9f5
      // 9f4: athrow
      // 9f5: iload 10
      // 9f7: goto 9fb
      // 9fa: athrow
      // 9fb: iload 2
      // 9fc: ifne a0e
      // 9ff: iload 25
      // a01: if_icmpeq b67
      // a04: goto a08
      // a07: athrow
      // a08: iload 12
      // a0a: goto a0e
      // a0d: athrow
      // a0e: iload 2
      // a0f: ifne a21
      // a12: iload 25
      // a14: if_icmpeq b67
      // a17: goto a1b
      // a1a: athrow
      // a1b: iload 14
      // a1d: goto a21
      // a20: athrow
      // a21: iload 2
      // a22: ifne a34
      // a25: iload 25
      // a27: if_icmpeq b67
      // a2a: goto a2e
      // a2d: athrow
      // a2e: iload 16
      // a30: goto a34
      // a33: athrow
      // a34: iload 2
      // a35: ifne a47
      // a38: iload 25
      // a3a: if_icmpeq b67
      // a3d: goto a41
      // a40: athrow
      // a41: iload 18
      // a43: goto a47
      // a46: athrow
      // a47: iload 2
      // a48: ifne a5a
      // a4b: iload 25
      // a4d: if_icmpeq b67
      // a50: goto a54
      // a53: athrow
      // a54: iload 20
      // a56: goto a5a
      // a59: athrow
      // a5a: iload 25
      // a5c: if_icmpeq b67
      // a5f: getstatic x/occddbf330f0.Լ Lnet/minecraft/client/Minecraft;
      // a62: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // a65: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // a68: iload 25
      // a6a: invokevirtual net/minecraft/entity/player/InventoryPlayer.getStackInSlot (I)Lnet/minecraft/item/ItemStack;
      // a6d: astore 26
      // a6f: iload 2
      // a70: ifne b6a
      // a73: aload 26
      // a75: ifnull b67
      // a78: goto a7c
      // a7b: athrow
      // a7c: aload 26
      // a7e: invokestatic x/oc7fbc83d9b3.Ӭ (Lnet/minecraft/item/ItemStack;)Z
      // a81: istore 27
      // a83: aload 26
      // a85: invokestatic x/oc7fbc83d9b3.ȁ (Lnet/minecraft/item/ItemStack;)Z
      // a88: istore 28
      // a8a: getstatic x/oc3ec0054e46.K Lx/oc3ec0054e46;
      // a8d: aload 26
      // a8f: invokevirtual x/oc3ec0054e46.z$1z7an8sgo26hk (Lnet/minecraft/item/ItemStack;)Z
      // a92: istore 29
      // a94: iload 27
      // a96: iload 2
      // a97: ifne aad
      // a9a: ifeq aab
      // a9d: goto aa1
      // aa0: athrow
      // aa1: iload 22
      // aa3: aload 26
      // aa5: getfield net/minecraft/item/ItemStack.stackSize I
      // aa8: iadd
      // aa9: istore 22
      // aab: iload 28
      // aad: iload 2
      // aae: ifne ac4
      // ab1: ifeq ac2
      // ab4: goto ab8
      // ab7: athrow
      // ab8: iload 23
      // aba: aload 26
      // abc: getfield net/minecraft/item/ItemStack.stackSize I
      // abf: iadd
      // ac0: istore 23
      // ac2: iload 29
      // ac4: iload 2
      // ac5: ifne adb
      // ac8: ifeq ad9
      // acb: goto acf
      // ace: athrow
      // acf: iload 24
      // ad1: aload 26
      // ad3: getfield net/minecraft/item/ItemStack.stackSize I
      // ad6: iadd
      // ad7: istore 24
      // ad9: iload 27
      // adb: iload 2
      // adc: ifne afd
      // adf: ifeq afb
      // ae2: goto ae6
      // ae5: athrow
      // ae6: iload 22
      // ae8: aload 0
      // ae9: getfield x/occddbf330f0.շ Lx/oca9cc61aada;
      // aec: invokevirtual x/oca9cc61aada.Ӂ ()D
      // aef: d2i
      // af0: if_icmple b67
      // af3: goto af7
      // af6: athrow
      // af7: goto b47
      // afa: athrow
      // afb: iload 28
      // afd: iload 2
      // afe: ifne b1f
      // b01: ifeq b1d
      // b04: goto b08
      // b07: athrow
      // b08: iload 23
      // b0a: aload 0
      // b0b: getfield x/occddbf330f0.ʨ Lx/oca9cc61aada;
      // b0e: invokevirtual x/oca9cc61aada.Ӂ ()D
      // b11: d2i
      // b12: if_icmple b67
      // b15: goto b19
      // b18: athrow
      // b19: goto b47
      // b1c: athrow
      // b1d: iload 29
      // b1f: iload 2
      // b20: ifne b44
      // b23: ifeq b3f
      // b26: goto b2a
      // b29: athrow
      // b2a: iload 24
      // b2c: aload 0
      // b2d: getfield x/occddbf330f0.ɝ Lx/oca9cc61aada;
      // b30: invokevirtual x/oca9cc61aada.Ӂ ()D
      // b33: d2i
      // b34: if_icmple b67
      // b37: goto b3b
      // b3a: athrow
      // b3b: goto b47
      // b3e: athrow
      // b3f: aload 26
      // b41: invokestatic x/oc7fbc83d9b3.ɯ (Lnet/minecraft/item/ItemStack;)Z
      // b44: ifeq b67
      // b47: aload 0
      // b48: getstatic x/occddbf330f0.Լ Lnet/minecraft/client/Minecraft;
      // b4b: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // b4e: getfield net/minecraft/client/entity/EntityPlayerSP.inventoryContainer Lnet/minecraft/inventory/Container;
      // b51: getfield net/minecraft/inventory/Container.windowId I
      // b54: aload 0
      // b55: iload 25
      // b57: invokevirtual x/occddbf330f0.Ҳ (I)I
      // b5a: bipush 1
      // b5b: ldc_w 1990041679
      // b5e: ldc_w 1990041675
      // b61: ixor
      // b62: invokevirtual x/occddbf330f0.ȭ (IIII)V
      // b65: return
      // b66: athrow
      // b67: iinc 25 1
      // b6a: iload 2
      // b6b: ifeq 97e
      // b6e: return
   }

   private void Ը() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: istore 1
      // 004: getstatic x/occddbf330f0.Լ Lnet/minecraft/client/Minecraft;
      // 007: iload 1
      // 008: ifne 01c
      // 00b: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 00e: ifnull 037
      // 011: goto 015
      // 014: athrow
      // 015: getstatic x/occddbf330f0.Լ Lnet/minecraft/client/Minecraft;
      // 018: goto 01c
      // 01b: athrow
      // 01c: iload 1
      // 01d: ifne 031
      // 020: getfield net/minecraft/client/Minecraft.playerController Lnet/minecraft/client/multiplayer/PlayerControllerMP;
      // 023: ifnull 037
      // 026: goto 02a
      // 029: athrow
      // 02a: getstatic x/occddbf330f0.Լ Lnet/minecraft/client/Minecraft;
      // 02d: goto 031
      // 030: athrow
      // 031: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 034: ifnonnull 039
      // 037: return
      // 038: athrow
      // 039: bipush 0
      // 03a: istore 2
      // 03b: iload 2
      // 03c: ldc_w 333815933
      // 03f: ldc_w 333815929
      // 042: ixor
      // 043: if_icmpge 204
      // 046: ldc_w 333815902
      // 049: ldc_w 333815929
      // 04c: ixor
      // 04d: iload 2
      // 04e: isub
      // 04f: istore 3
      // 050: getstatic x/occddbf330f0.Լ Lnet/minecraft/client/Minecraft;
      // 053: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 056: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 059: iload 3
      // 05a: invokevirtual net/minecraft/entity/player/InventoryPlayer.getStackInSlot (I)Lnet/minecraft/item/ItemStack;
      // 05d: ifnull 064
      // 060: iload 1
      // 061: ifeq 1fd
      // 064: bipush -1
      // 065: istore 4
      // 067: dconst_0
      // 068: dstore 5
      // 06a: bipush 0
      // 06b: istore 7
      // 06d: iload 7
      // 06f: ldc_w 333815920
      // 072: ldc_w 333815929
      // 075: ixor
      // 076: if_icmpge 14c
      // 079: getstatic x/occddbf330f0.Լ Lnet/minecraft/client/Minecraft;
      // 07c: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 07f: iload 1
      // 080: ifne 056
      // 083: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 086: iload 7
      // 088: invokevirtual net/minecraft/entity/player/InventoryPlayer.getStackInSlot (I)Lnet/minecraft/item/ItemStack;
      // 08b: astore 8
      // 08d: aload 8
      // 08f: iload 1
      // 090: ifne 09f
      // 093: ifnonnull 09d
      // 096: goto 09a
      // 099: athrow
      // 09a: goto 145
      // 09d: aload 8
      // 09f: iload 1
      // 0a0: ifne 0b6
      // 0a3: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 0a6: instanceof net/minecraft/item/ItemArmor
      // 0a9: ifne 0b4
      // 0ac: goto 0b0
      // 0af: athrow
      // 0b0: goto 145
      // 0b3: athrow
      // 0b4: aload 8
      // 0b6: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 0b9: checkcast net/minecraft/item/ItemArmor
      // 0bc: astore 9
      // 0be: aload 9
      // 0c0: getfield net/minecraft/item/ItemArmor.armorType I
      // 0c3: iload 1
      // 0c4: ifne 0da
      // 0c7: iload 2
      // 0c8: if_icmpeq 0d3
      // 0cb: goto 0cf
      // 0ce: athrow
      // 0cf: goto 145
      // 0d2: athrow
      // 0d3: aload 0
      // 0d4: getfield x/occddbf330f0.Ɠ Lx/occ2f8dff8d8;
      // 0d7: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 0da: iload 1
      // 0db: ifne 0f6
      // 0de: ifeq 122
      // 0e1: goto 0e5
      // 0e4: athrow
      // 0e5: aload 8
      // 0e7: iload 1
      // 0e8: ifne 128
      // 0eb: goto 0ef
      // 0ee: athrow
      // 0ef: invokevirtual net/minecraft/item/ItemStack.isItemDamaged ()Z
      // 0f2: goto 0f6
      // 0f5: athrow
      // 0f6: ifeq 122
      // 0f9: aload 8
      // 0fb: iload 1
      // 0fc: ifne 128
      // 0ff: goto 103
      // 102: athrow
      // 103: invokevirtual net/minecraft/item/ItemStack.getMaxDamage ()I
      // 106: aload 8
      // 108: invokevirtual net/minecraft/item/ItemStack.getItemDamage ()I
      // 10b: isub
      // 10c: ldc_w 333815911
      // 10f: ldc_w 333815929
      // 112: ixor
      // 113: if_icmpge 122
      // 116: goto 11a
      // 119: athrow
      // 11a: iload 1
      // 11b: ifeq 145
      // 11e: goto 122
      // 121: athrow
      // 122: aload 8
      // 124: goto 128
      // 127: athrow
      // 128: invokestatic x/oc7fbc83d9b3.З (Lnet/minecraft/item/ItemStack;)D
      // 12b: dstore 10
      // 12d: iload 1
      // 12e: ifne 148
      // 131: dload 10
      // 133: dload 5
      // 135: dcmpl
      // 136: iflt 145
      // 139: goto 13d
      // 13c: athrow
      // 13d: iload 7
      // 13f: istore 4
      // 141: dload 10
      // 143: dstore 5
      // 145: iinc 7 1
      // 148: iload 1
      // 149: ifeq 06d
      // 14c: iload 4
      // 14e: iload 1
      // 14f: ifne 16a
      // 152: bipush -1
      // 153: if_icmpeq 1fd
      // 156: goto 15a
      // 159: athrow
      // 15a: getstatic x/occddbf330f0.Լ Lnet/minecraft/client/Minecraft;
      // 15d: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 160: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 163: getfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 166: goto 16a
      // 169: athrow
      // 16a: istore 7
      // 16c: getstatic x/occddbf330f0.Լ Lnet/minecraft/client/Minecraft;
      // 16f: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 172: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 175: iload 4
      // 177: putfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 17a: getstatic x/occddbf330f0.Լ Lnet/minecraft/client/Minecraft;
      // 17d: invokevirtual net/minecraft/client/Minecraft.getNetHandler ()Lnet/minecraft/client/network/NetHandlerPlayClient;
      // 180: new net/minecraft/network/play/client/C09PacketHeldItemChange
      // 183: dup
      // 184: iload 4
      // 186: invokespecial net/minecraft/network/play/client/C09PacketHeldItemChange.<init> (I)V
      // 189: invokevirtual net/minecraft/client/network/NetHandlerPlayClient.addToSendQueue (Lnet/minecraft/network/Packet;)V
      // 18c: getstatic x/occddbf330f0.Լ Lnet/minecraft/client/Minecraft;
      // 18f: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 192: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 195: iload 4
      // 197: invokevirtual net/minecraft/entity/player/InventoryPlayer.getStackInSlot (I)Lnet/minecraft/item/ItemStack;
      // 19a: astore 8
      // 19c: getstatic x/occddbf330f0.Լ Lnet/minecraft/client/Minecraft;
      // 19f: getfield net/minecraft/client/Minecraft.playerController Lnet/minecraft/client/multiplayer/PlayerControllerMP;
      // 1a2: getstatic x/occddbf330f0.Լ Lnet/minecraft/client/Minecraft;
      // 1a5: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1a8: getstatic x/occddbf330f0.Լ Lnet/minecraft/client/Minecraft;
      // 1ab: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 1ae: aload 8
      // 1b0: invokevirtual net/minecraft/client/multiplayer/PlayerControllerMP.sendUseItem (Lnet/minecraft/entity/player/EntityPlayer;Lnet/minecraft/world/World;Lnet/minecraft/item/ItemStack;)Z
      // 1b3: pop
      // 1b4: getstatic x/occddbf330f0.Լ Lnet/minecraft/client/Minecraft;
      // 1b7: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1ba: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 1bd: iload 7
      // 1bf: putfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 1c2: getstatic x/occddbf330f0.Լ Lnet/minecraft/client/Minecraft;
      // 1c5: invokevirtual net/minecraft/client/Minecraft.getNetHandler ()Lnet/minecraft/client/network/NetHandlerPlayClient;
      // 1c8: new net/minecraft/network/play/client/C09PacketHeldItemChange
      // 1cb: dup
      // 1cc: iload 7
      // 1ce: invokespecial net/minecraft/network/play/client/C09PacketHeldItemChange.<init> (I)V
      // 1d1: invokevirtual net/minecraft/client/network/NetHandlerPlayClient.addToSendQueue (Lnet/minecraft/network/Packet;)V
      // 1d4: aload 0
      // 1d5: getfield x/occddbf330f0.Ê Lx/ocba5f31cad4;
      // 1d8: invokevirtual x/ocba5f31cad4.Ÿ ()V
      // 1db: aload 0
      // 1dc: aload 0
      // 1dd: getfield x/occddbf330f0.λ Lx/oca9cc61aada;
      // 1e0: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 1e3: d2i
      // 1e4: bipush 1
      // 1e5: iadd
      // 1e6: aload 0
      // 1e7: getfield x/occddbf330f0.ǟ Lx/oca9cc61aada;
      // 1ea: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 1ed: d2i
      // 1ee: ldc_w 333815931
      // 1f1: ldc_w 333815929
      // 1f4: ixor
      // 1f5: iadd
      // 1f6: invokestatic org/apache/commons/lang3/RandomUtils.nextInt (II)I
      // 1f9: putfield x/occddbf330f0.Ƕ I
      // 1fc: return
      // 1fd: iinc 2 1
      // 200: iload 1
      // 201: ifeq 03b
      // 204: return
   }

   static boolean ʦ(int param0, int param1, int param2, int param3, int param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 5
      // 05: iload 0
      // 06: iload 5
      // 08: ifne 13
      // 0b: iflt 77
      // 0e: goto 12
      // 11: athrow
      // 12: iload 0
      // 13: iload 5
      // 15: ifne 2b
      // 18: ldc_w -1129024156
      // 1b: ldc_w -1129024147
      // 1e: ixor
      // 1f: if_icmpge 77
      // 22: goto 26
      // 25: athrow
      // 26: iload 0
      // 27: goto 2b
      // 2a: athrow
      // 2b: iload 5
      // 2d: ifne 74
      // 30: iload 1
      // 31: if_icmpeq 6f
      // 34: goto 38
      // 37: athrow
      // 38: iload 0
      // 39: iload 5
      // 3b: ifne 74
      // 3e: goto 42
      // 41: athrow
      // 42: iload 2
      // 43: if_icmpeq 6f
      // 46: goto 4a
      // 49: athrow
      // 4a: iload 0
      // 4b: iload 5
      // 4d: ifne 74
      // 50: goto 54
      // 53: athrow
      // 54: iload 3
      // 55: if_icmpeq 6f
      // 58: goto 5c
      // 5b: athrow
      // 5c: iload 0
      // 5d: iload 5
      // 5f: ifne 74
      // 62: goto 66
      // 65: athrow
      // 66: iload 4
      // 68: if_icmpne 77
      // 6b: goto 6f
      // 6e: athrow
      // 6f: bipush 1
      // 70: goto 74
      // 73: athrow
      // 74: goto 78
      // 77: bipush 0
      // 78: ireturn
   }

   public boolean ը(int param1, int param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 3
      // 04: aload 0
      // 05: iload 3
      // 06: ifne 18
      // 09: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 0c: ifeq 59
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: goto 18
      // 17: athrow
      // 18: iload 3
      // 19: ifne 2e
      // 1c: getfield x/occddbf330f0.à Lx/occ2f8dff8d8;
      // 1f: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 22: ifeq 59
      // 25: goto 29
      // 28: athrow
      // 29: aload 0
      // 2a: goto 2e
      // 2d: athrow
      // 2e: iload 3
      // 2f: ifne 42
      // 32: getfield x/occddbf330f0.ʪ I
      // 35: iload 1
      // 36: if_icmpne 59
      // 39: goto 3d
      // 3c: athrow
      // 3d: aload 0
      // 3e: goto 42
      // 41: athrow
      // 42: getfield x/occddbf330f0.r I
      // 45: iload 3
      // 46: ifne 56
      // 49: iload 2
      // 4a: if_icmpne 59
      // 4d: goto 51
      // 50: athrow
      // 51: bipush 1
      // 52: goto 56
      // 55: athrow
      // 56: goto 5a
      // 59: bipush 0
      // 5a: ireturn
   }

   private void Ͼ() {
      this.ʪ = -1;
      this.r = -1;
   }

   @Override
   public void onDisable() {
      this.Ͼ();
   }

   @oc66fa4f2195
   public void Ÿ(oc2f7ef6a217 var1) {
      this.Ƕ = RandomUtils.nextInt((int)this.λ.Ӂ() + 1, (int)this.ǟ.Ӂ() + (-1581861236 ^ -1581861234));
   }
}
