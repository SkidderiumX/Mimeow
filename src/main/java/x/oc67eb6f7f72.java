package x;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.world.WorldSettings.GameType;
import org.apache.commons.lang3.RandomUtils;

public class oc67eb6f7f72 extends oc69da1aa7f5 {
   private static final String[] ǿ;
   private static final String[] ϑ;
   private static final String[] Ѭ;
   private static final Minecraft ή = Minecraft.getMinecraft();
   private int ř = 0;
   private int ʎ = 0;
   private boolean Ӂ = false;
   private boolean å = false;
   private final oca9cc61aada Ǿ;
   private final occ2f8dff8d8 ɒ;
   public final oca9cc61aada r;
   public final oca9cc61aada ҏ;
   public final oca9cc61aada Τ;
   public final occ2f8dff8d8 ˢ;
   private final occc831eff22 Ժ;
   public final occ2f8dff8d8 C;
   public final occ2f8dff8d8 Ϩ;
   public final occ2f8dff8d8 Ю;
   public final occ2f8dff8d8 ǩ;
   private final oca9cc61aada Ŵ;
   private final oca9cc61aada ÿ;
   private final ocf1568fef75 ø;
   private final oca9cc61aada ӊ;
   private final oca9cc61aada ռ;
   private final occ2f8dff8d8 ȳ;
   private final occ2f8dff8d8 Ǧ;
   private final oca9cc61aada Ё;
   private final occ2f8dff8d8 ɜ;
   private final ocba5f31cad4 ɧ;
   private final ocba5f31cad4 ľ;
   private final ocba5f31cad4 ӂ;
   private long Ĭ;
   public int Ù;
   private int Ӥ;
   private int ҭ;
   public static boolean Ô;

   private boolean i() {
      GameType var2 = null;
      int var3 = 426682130 ^ 643895578;
      int var1 = oc84f20a0bc5.ė;

      while (true) {
         switch (var3) {
            case -2053831517:
               if (var2 == GameType.ADVENTURE) {
                  var3 = -555002819 ^ 643895578;
                  if (var1 == 0) {
                     break;
                  }
               }

               var3 = -2086911250 ^ 643895578;
               if (var1 == 0) {
                  break;
               }
            case -125156057:
               return true;
            case -1510124556:
               return false;
            case 1057994248:
               var2 = ή.playerController.getCurrentGameType();

               label33: {
                  try {
                     if (var1 != 0) {
                        break;
                     }

                     if (var2 == GameType.SURVIVAL) {
                        break label33;
                     }
                  } catch (ocbde1165e4e var4) {
                     throw var4;
                  }

                  var3 = -1544284743 ^ 643895578;
                  if (var1 == 0) {
                     break;
                  }
               }

               var3 = -555002819 ^ 643895578;
               break;
            default:
               throw null;
         }
      }
   }

   private boolean V(ItemStack var1) {
      ArmorMaterial var3 = null;
      int var4 = 1052645819 ^ -1926656614;
      int var2 = oc84f20a0bc5.ė;

      while (true) {
         switch (var4) {
            case -1281911775:
               if (var1 == null) {
                  var4 = 917405222 ^ -1926656614;
                  if (var2 == 0) {
                     break;
                  }
               }

               var4 = -2058202943 ^ -1926656614;
               if (var2 == 0) {
                  break;
               }
            case -437151442:
               return true;
            case -1148718148:
               return false;
            case -491988095:
               int var10;
               label104: {
                  label103: {
                     try {
                        var10 = var1.isItemEnchanted();
                        if (var2 != 0) {
                           break label104;
                        }

                        if (var10 == 0) {
                           break label103;
                        }
                     } catch (ocbde1165e4e var8) {
                        throw var8;
                     }

                     var4 = 1758991540 ^ -1926656614;
                     if (var2 == 0) {
                        break;
                     }
                  }

                  var10 = 932498840 ^ -1926656614;
               }

               var4 = var10;
               if (var2 == 0) {
                  break;
               }
            case -1162002430:
               return false;
            case 142335323:
               int var9;
               label85: {
                  label84: {
                     try {
                        var9 = this.Ю.ǭ();
                        if (var2 != 0) {
                           break label85;
                        }

                        if (var9 != 0) {
                           break label84;
                        }
                     } catch (ocbde1165e4e var6) {
                        throw var6;
                     }

                     var4 = -1567937369 ^ -1926656614;
                     if (var2 == 0) {
                        break;
                     }
                  }

                  var9 = -1445249530 ^ -1926656614;
               }

               var4 = var9;
               break;
            case 619885468:
               int var10000;
               label76: {
                  label75: {
                     try {
                        var10000 = var1.getItem() instanceof ItemArmor;
                        if (var2 != 0) {
                           break label76;
                        }

                        if (var10000 != 0) {
                           break label75;
                        }
                     } catch (ocbde1165e4e var5) {
                        throw var5;
                     }

                     var4 = -419655312 ^ -1926656614;
                     if (var2 == 0) {
                        break;
                     }
                  }

                  var10000 = 1274683776 ^ -1926656614;
               }

               var4 = var10000;
               if (var2 == 0) {
                  break;
               }
            case 1878493587:
               return true;
            case 799187261:
               return false;
            case 1310336457:
               if (var3 == ArmorMaterial.IRON) {
                  var4 = 1871009307 ^ -1926656614;
                  if (var2 == 0) {
                     break;
                  }
               }

               var4 = 932498840 ^ -1926656614;
               if (var2 == 0) {
                  break;
               }
            case -959206374:
               var3 = ((ItemArmor)var1.getItem()).getArmorMaterial();

               label94: {
                  label93: {
                     try {
                        if (var2 != 0) {
                           break label94;
                        }

                        if (var3 != ArmorMaterial.DIAMOND) {
                           break label93;
                        }
                     } catch (ocbde1165e4e var7) {
                        throw var7;
                     }

                     var4 = -488766455 ^ -1926656614;
                     if (var2 == 0) {
                        break;
                     }
                  }

                  var4 = -1020024749 ^ -1926656614;
               }

               if (var2 == 0) {
                  break;
               }
            case 1809128682:
               return false;
            default:
               throw null;
         }
      }
   }

   private boolean ӛ(ItemStack var1) {
      String var3 = null;
      int var4 = -897125337 ^ -771143418;
      int var2 = oc84f20a0bc5.ė;

      while (true) {
         switch (var4) {
            case -2104161375:
               int var14;
               label145: {
                  label144: {
                     try {
                        var14 = var1.getItem() instanceof ItemSword;
                        if (var2 != 0) {
                           break label145;
                        }

                        if (var14 != 0) {
                           break label144;
                        }
                     } catch (ocbde1165e4e var10) {
                        throw var10;
                     }

                     var4 = -1143416167 ^ -771143418;
                     if (var2 == 0) {
                        break;
                     }
                  }

                  var14 = -864234822 ^ -771143418;
               }

               var4 = var14;
               if (var2 == 0) {
                  break;
               }
            case 511024060:
               var3 = ((ItemSword)var1.getItem()).getToolMaterialName();

               label118: {
                  label117: {
                     try {
                        if (var2 != 0) {
                           break label118;
                        }

                        if (!ToolMaterial.EMERALD.toString().equals(var3)) {
                           break label117;
                        }
                     } catch (ocbde1165e4e var8) {
                        throw var8;
                     }

                     var4 = 1521575229 ^ -771143418;
                     if (var2 == 0) {
                        break;
                     }
                  }

                  var4 = -922634617 ^ -771143418;
               }

               if (var2 == 0) {
                  break;
               }

               return false;
            case -2055559581:
               int var13;
               label109: {
                  label108: {
                     try {
                        var13 = ToolMaterial.IRON.toString().equals(var3);
                        if (var2 != 0) {
                           break label109;
                        }

                        if (var13 == 0) {
                           break label108;
                        }
                     } catch (ocbde1165e4e var7) {
                        throw var7;
                     }

                     var4 = 366369310 ^ -771143418;
                     if (var2 == 0) {
                        break;
                     }
                  }

                  var13 = -1843548462 ^ -771143418;
               }

               var4 = var13;
               if (var2 == 0) {
                  break;
               }

               return false;
            case -2001195973:
               return true;
            case -1872227262:
               return true;
            case -1396143800:
               return false;
            case -1143976401:
               return false;
            case 412073249:
               if (var1 == null) {
                  var4 = 2126626894 ^ -771143418;
                  if (var2 == 0) {
                     break;
                  }
               }

               var4 = -1832335196 ^ -771143418;
               if (var2 == 0) {
                  break;
               }
            case 453574529:
               int var11;
               label136: {
                  label135: {
                     try {
                        var11 = Enchantment.fireAspect.effectId;
                        if (var2 != 0) {
                           break label136;
                        }

                        if (EnchantmentHelper.getEnchantmentLevel(Enchantment.fireAspect.effectId, var1) == 0) {
                           break label135;
                        }
                     } catch (ocbde1165e4e var9) {
                        throw var9;
                     }

                     var4 = 1113677124 ^ -771143418;
                     if (var2 == 0) {
                        break;
                     }
                  }

                  var11 = 1467215717 ^ -771143418;
               }

               var4 = var11;
               if (var2 == 0) {
                  break;
               }
            case -941681896:
               int var12;
               label91: {
                  label90: {
                     try {
                        var12 = var1.isItemEnchanted();
                        if (var2 != 0) {
                           break label91;
                        }

                        if (var12 == 0) {
                           break label90;
                        }
                     } catch (ocbde1165e4e var5) {
                        throw var5;
                     }

                     var4 = -509439663 ^ -771143418;
                     if (var2 == 0) {
                        break;
                     }
                  }

                  var12 = -1843548462 ^ -771143418;
               }

               var4 = var12;
               if (var2 == 0) {
                  break;
               }

               return true;
            case 866900055:
               return true;
            case 1075111892:
               return false;
            case 1086423458:
               int var10000;
               label100: {
                  label99: {
                     try {
                        var10000 = this.ǩ.ǭ();
                        if (var2 != 0) {
                           break label100;
                        }

                        if (var10000 != 0) {
                           break label99;
                        }
                     } catch (ocbde1165e4e var6) {
                        throw var6;
                     }

                     var4 = 1775830825 ^ -771143418;
                     if (var2 == 0) {
                        break;
                     }
                  }

                  var10000 = 1352417959 ^ -771143418;
               }

               var4 = var10000;
               if (var2 == 0) {
                  break;
               }

               return false;
            case 1775342495:
               return false;
            default:
               throw null;
         }
      }
   }

   private boolean ǫ(ItemStack param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: istore 2
      // 004: aload 1
      // 005: ifnonnull 00b
      // 008: bipush 0
      // 009: ireturn
      // 00a: athrow
      // 00b: getstatic x/oc9755810e45.ż Lx/occddbf330f0;
      // 00e: astore 3
      // 00f: getstatic x/oc3ec0054e46.k Lx/oc3ec0054e46;
      // 012: aload 1
      // 013: iload 2
      // 014: ifne 067
      // 017: invokevirtual x/oc3ec0054e46.z$1z7an8sgo26hk (Lnet/minecraft/item/ItemStack;)Z
      // 01a: ifeq 05b
      // 01d: goto 021
      // 020: athrow
      // 021: aload 3
      // 022: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 025: iload 2
      // 026: ifne 056
      // 029: goto 02d
      // 02c: athrow
      // 02d: ifeq 051
      // 030: goto 034
      // 033: athrow
      // 034: getstatic x/oc3ec0054e46.k Lx/oc3ec0054e46;
      // 037: invokestatic x/oc7fbc83d9b3.ƒ (Lx/oc3ec0054e46;)I
      // 03a: iload 2
      // 03b: ifne 056
      // 03e: goto 042
      // 041: athrow
      // 042: aload 3
      // 043: getfield x/occddbf330f0.շ Lx/oca9cc61aada;
      // 046: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 049: d2i
      // 04a: if_icmpge 059
      // 04d: goto 051
      // 050: athrow
      // 051: bipush 1
      // 052: goto 056
      // 055: athrow
      // 056: goto 05a
      // 059: bipush 0
      // 05a: ireturn
      // 05b: getstatic x/oc3ec0054e46.Ϲ Lx/oc3ec0054e46;
      // 05e: iload 2
      // 05f: ifne 0aa
      // 062: aload 1
      // 063: goto 067
      // 066: athrow
      // 067: invokevirtual x/oc3ec0054e46.z$1z7an8sgo26hk (Lnet/minecraft/item/ItemStack;)Z
      // 06a: ifeq 0a7
      // 06d: aload 3
      // 06e: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 071: iload 2
      // 072: ifne 0a2
      // 075: goto 079
      // 078: athrow
      // 079: ifeq 09d
      // 07c: goto 080
      // 07f: athrow
      // 080: getstatic x/oc3ec0054e46.Ϲ Lx/oc3ec0054e46;
      // 083: invokestatic x/oc7fbc83d9b3.ƒ (Lx/oc3ec0054e46;)I
      // 086: iload 2
      // 087: ifne 0a2
      // 08a: goto 08e
      // 08d: athrow
      // 08e: aload 3
      // 08f: getfield x/occddbf330f0.ʨ Lx/oca9cc61aada;
      // 092: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 095: d2i
      // 096: if_icmpge 0a5
      // 099: goto 09d
      // 09c: athrow
      // 09d: bipush 1
      // 09e: goto 0a2
      // 0a1: athrow
      // 0a2: goto 0a6
      // 0a5: bipush 0
      // 0a6: ireturn
      // 0a7: getstatic x/oc3ec0054e46.Ǒ Lx/oc3ec0054e46;
      // 0aa: iload 2
      // 0ab: ifne 0d7
      // 0ae: aload 1
      // 0af: invokevirtual x/oc3ec0054e46.z$1z7an8sgo26hk (Lnet/minecraft/item/ItemStack;)Z
      // 0b2: ifeq 0d4
      // 0b5: goto 0b9
      // 0b8: athrow
      // 0b9: getstatic x/oc3ec0054e46.Ϲ Lx/oc3ec0054e46;
      // 0bc: invokestatic x/oc7fbc83d9b3.ƒ (Lx/oc3ec0054e46;)I
      // 0bf: iload 2
      // 0c0: ifne 0cf
      // 0c3: goto 0c7
      // 0c6: athrow
      // 0c7: ifne 0d2
      // 0ca: goto 0ce
      // 0cd: athrow
      // 0ce: bipush 1
      // 0cf: goto 0d3
      // 0d2: bipush 0
      // 0d3: ireturn
      // 0d4: getstatic x/oc3ec0054e46.K Lx/oc3ec0054e46;
      // 0d7: aload 1
      // 0d8: invokevirtual x/oc3ec0054e46.z$1z7an8sgo26hk (Lnet/minecraft/item/ItemStack;)Z
      // 0db: iload 2
      // 0dc: ifne 121
      // 0df: ifeq 120
      // 0e2: goto 0e6
      // 0e5: athrow
      // 0e6: aload 3
      // 0e7: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 0ea: iload 2
      // 0eb: ifne 11b
      // 0ee: goto 0f2
      // 0f1: athrow
      // 0f2: ifeq 116
      // 0f5: goto 0f9
      // 0f8: athrow
      // 0f9: getstatic x/oc3ec0054e46.K Lx/oc3ec0054e46;
      // 0fc: invokestatic x/oc7fbc83d9b3.ƒ (Lx/oc3ec0054e46;)I
      // 0ff: iload 2
      // 100: ifne 11b
      // 103: goto 107
      // 106: athrow
      // 107: aload 3
      // 108: getfield x/occddbf330f0.ɝ Lx/oca9cc61aada;
      // 10b: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 10e: d2i
      // 10f: if_icmpge 11e
      // 112: goto 116
      // 115: athrow
      // 116: bipush 1
      // 117: goto 11b
      // 11a: athrow
      // 11b: goto 11f
      // 11e: bipush 0
      // 11f: ireturn
      // 120: bipush 0
      // 121: ireturn
   }

   private void Ҟ(int param1, int param2, int param3, int param4) {
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
      // 0b: getfield x/oc67eb6f7f72.ɒ Lx/occ2f8dff8d8;
      // 0e: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 11: ifeq 2b
      // 14: goto 18
      // 17: athrow
      // 18: aload 0
      // 19: iload 1
      // 1a: putfield x/oc67eb6f7f72.Ӥ I
      // 1d: iload 5
      // 1f: aload 0
      // 20: iload 2
      // 21: putfield x/oc67eb6f7f72.ҭ I
      // 24: ifeq 33
      // 27: goto 2b
      // 2a: athrow
      // 2b: aload 0
      // 2c: goto 30
      // 2f: athrow
      // 30: invokevirtual x/oc67eb6f7f72.Ɂ ()V
      // 33: getstatic x/oc67eb6f7f72.ή Lnet/minecraft/client/Minecraft;
      // 36: getfield net/minecraft/client/Minecraft.playerController Lnet/minecraft/client/multiplayer/PlayerControllerMP;
      // 39: iload 1
      // 3a: iload 2
      // 3b: iload 3
      // 3c: iload 4
      // 3e: getstatic x/oc67eb6f7f72.ή Lnet/minecraft/client/Minecraft;
      // 41: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 44: invokevirtual net/minecraft/client/multiplayer/PlayerControllerMP.windowClick (IIIILnet/minecraft/entity/player/EntityPlayer;)Lnet/minecraft/item/ItemStack;
      // 47: pop
      // 48: return
   }

   private void ѭ(int var1, int var2) {
      this.Ҟ(var1, var2, 0, 1);
   }

   public oc67eb6f7f72() {
      super("ChestStealer", oce4cea752dd.з);
      this.Ǿ = new oca9cc61aada("Mode", 0, ǿ);
      this.ɒ = new occ2f8dff8d8("Visual", true);
      this.r = new oca9cc61aada("Min delay", " ticks", 1.0, 0.0, 20.0, 1.0);
      this.ҏ = new oca9cc61aada("Max delay", " ticks", 2.0, 0.0, 20.0, 1.0);
      this.Τ = new oca9cc61aada("Open delay", " ticks", 1.0, 0.0, 20.0, 1.0);
      this.ˢ = new occ2f8dff8d8("Auto close", false);
      this.Ժ = new occc831eff22("Filter");
      this.C = new occ2f8dff8d8(this.Ժ, "Name check", true);
      this.Ϩ = new occ2f8dff8d8(this.Ժ, "Skip trash", true);
      this.Ю = new occ2f8dff8d8(this.Ժ, "More armor", false);
      this.ǩ = new occ2f8dff8d8(this.Ժ, "More sword", false);
      this.Ŵ = new oca9cc61aada("Start Delay", " ticks", 1.0, 1.0, 10.0, 1.0);
      this.ÿ = new oca9cc61aada("Close Delay", " ticks", 1.0, 1.0, 10.0, 1.0);
      this.ø = new ocf1568fef75("Delay", 0.0, 10.0, 1.0, 1.0, 1.0);
      this.ӊ = new oca9cc61aada("Steal Mode", 0, ϑ);
      this.ռ = new oca9cc61aada("Miss-click chance", "%", 0.0, 0.0, 99.0, 1.0);
      this.ȳ = new occ2f8dff8d8("Instant", false, new String[]{"Allow instant"});
      this.Ǧ = new occ2f8dff8d8(this.Ժ, "Cap blocks", false);
      this.Ё = new oca9cc61aada(this.Ժ, "Max blocks", 128.0, 64.0, 512.0, 32.0);
      this.ɜ = new occ2f8dff8d8(this.Ժ, "Chest Tittle", true, new String[]{"Menu Check"});
      this.ɧ = new ocba5f31cad4();
      this.ľ = new ocba5f31cad4();
      this.ӂ = new ocba5f31cad4();
      this.Ӥ = -1;
      this.ҭ = -1;
      this.ą("Automatically steals items from chests.");
      this.ʌ(this.Ǿ);
      this.ʌ(this.ɒ);
      this.ʌ(this.r);
      this.ʌ(this.ҏ);
      this.ʌ(this.Τ);
      this.ʌ(this.ˢ);
      this.ʌ(this.Ժ);
      this.ʌ(this.C);
      this.ʌ(this.Ϩ);
      this.ʌ(this.Ю);
      this.ʌ(this.ǩ);
      this.ʌ(this.Ǧ);
      this.ʌ(this.Ё);
      this.ʌ(this.ɜ);
      this.ʌ(this.Ŵ);
      this.ʌ(this.ÿ);
      this.ʌ(this.ø);
      this.ʌ(this.ӊ);
      this.ʌ(this.ռ);
      this.ʌ(this.ȳ);
      this.z$2u87utkr1isxg();
   }

   @Override
   public String getInfo() {
      return ǿ[(int)this.Ǿ.Ӂ()];
   }

   @Override
   public void z$2u87utkr1isxg() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: aload 0
      // 004: getfield x/oc67eb6f7f72.Ժ Lx/occc831eff22;
      // 007: bipush 1
      // 008: aload 0
      // 009: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 00c: istore 1
      // 00d: aload 0
      // 00e: getfield x/oc67eb6f7f72.Ǿ Lx/oca9cc61aada;
      // 011: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 014: d2i
      // 015: iload 1
      // 016: ifne 026
      // 019: bipush 1
      // 01a: if_icmpne 029
      // 01d: goto 021
      // 020: athrow
      // 021: bipush 1
      // 022: goto 026
      // 025: athrow
      // 026: goto 02a
      // 029: bipush 0
      // 02a: istore 2
      // 02b: aload 0
      // 02c: getfield x/oc67eb6f7f72.r Lx/oca9cc61aada;
      // 02f: iload 2
      // 030: iload 1
      // 031: ifne 03c
      // 034: ifne 03f
      // 037: goto 03b
      // 03a: athrow
      // 03b: bipush 1
      // 03c: goto 040
      // 03f: bipush 0
      // 040: aload 0
      // 041: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 044: aload 0
      // 045: getfield x/oc67eb6f7f72.ҏ Lx/oca9cc61aada;
      // 048: iload 2
      // 049: iload 1
      // 04a: ifne 055
      // 04d: ifne 058
      // 050: goto 054
      // 053: athrow
      // 054: bipush 1
      // 055: goto 059
      // 058: bipush 0
      // 059: aload 0
      // 05a: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 05d: aload 0
      // 05e: getfield x/oc67eb6f7f72.Τ Lx/oca9cc61aada;
      // 061: iload 2
      // 062: iload 1
      // 063: ifne 06e
      // 066: ifne 071
      // 069: goto 06d
      // 06c: athrow
      // 06d: bipush 1
      // 06e: goto 072
      // 071: bipush 0
      // 072: aload 0
      // 073: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 076: aload 0
      // 077: getfield x/oc67eb6f7f72.ˢ Lx/occ2f8dff8d8;
      // 07a: iload 2
      // 07b: iload 1
      // 07c: ifne 087
      // 07f: ifne 08a
      // 082: goto 086
      // 085: athrow
      // 086: bipush 1
      // 087: goto 08b
      // 08a: bipush 0
      // 08b: aload 0
      // 08c: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 08f: aload 0
      // 090: getfield x/oc67eb6f7f72.C Lx/occ2f8dff8d8;
      // 093: iload 2
      // 094: iload 1
      // 095: ifne 0a0
      // 098: ifne 0a3
      // 09b: goto 09f
      // 09e: athrow
      // 09f: bipush 1
      // 0a0: goto 0a4
      // 0a3: bipush 0
      // 0a4: aload 0
      // 0a5: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 0a8: aload 0
      // 0a9: getfield x/oc67eb6f7f72.Ϩ Lx/occ2f8dff8d8;
      // 0ac: iload 2
      // 0ad: iload 1
      // 0ae: ifne 0b9
      // 0b1: ifne 0bc
      // 0b4: goto 0b8
      // 0b7: athrow
      // 0b8: bipush 1
      // 0b9: goto 0bd
      // 0bc: bipush 0
      // 0bd: aload 0
      // 0be: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 0c1: aload 0
      // 0c2: getfield x/oc67eb6f7f72.Ю Lx/occ2f8dff8d8;
      // 0c5: iload 2
      // 0c6: iload 1
      // 0c7: ifne 0d2
      // 0ca: ifne 0d5
      // 0cd: goto 0d1
      // 0d0: athrow
      // 0d1: bipush 1
      // 0d2: goto 0d6
      // 0d5: bipush 0
      // 0d6: aload 0
      // 0d7: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 0da: aload 0
      // 0db: getfield x/oc67eb6f7f72.ǩ Lx/occ2f8dff8d8;
      // 0de: iload 2
      // 0df: iload 1
      // 0e0: ifne 0eb
      // 0e3: ifne 0ee
      // 0e6: goto 0ea
      // 0e9: athrow
      // 0ea: bipush 1
      // 0eb: goto 0ef
      // 0ee: bipush 0
      // 0ef: aload 0
      // 0f0: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 0f3: aload 0
      // 0f4: getfield x/oc67eb6f7f72.Ŵ Lx/oca9cc61aada;
      // 0f7: iload 2
      // 0f8: iload 1
      // 0f9: ifne 14d
      // 0fc: aload 0
      // 0fd: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 100: aload 0
      // 101: getfield x/oc67eb6f7f72.ÿ Lx/oca9cc61aada;
      // 104: iload 2
      // 105: aload 0
      // 106: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 109: aload 0
      // 10a: getfield x/oc67eb6f7f72.ø Lx/ocf1568fef75;
      // 10d: iload 2
      // 10e: aload 0
      // 10f: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 112: aload 0
      // 113: getfield x/oc67eb6f7f72.ӊ Lx/oca9cc61aada;
      // 116: iload 2
      // 117: aload 0
      // 118: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 11b: aload 0
      // 11c: getfield x/oc67eb6f7f72.ռ Lx/oca9cc61aada;
      // 11f: iload 2
      // 120: aload 0
      // 121: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 124: aload 0
      // 125: getfield x/oc67eb6f7f72.ȳ Lx/occ2f8dff8d8;
      // 128: iload 2
      // 129: aload 0
      // 12a: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 12d: aload 0
      // 12e: getfield x/oc67eb6f7f72.Ǧ Lx/occ2f8dff8d8;
      // 131: iload 2
      // 132: aload 0
      // 133: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 136: aload 0
      // 137: getfield x/oc67eb6f7f72.Ё Lx/oca9cc61aada;
      // 13a: iload 2
      // 13b: ifeq 15c
      // 13e: goto 142
      // 141: athrow
      // 142: aload 0
      // 143: getfield x/oc67eb6f7f72.Ǧ Lx/occ2f8dff8d8;
      // 146: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 149: goto 14d
      // 14c: athrow
      // 14d: iload 1
      // 14e: ifne 159
      // 151: ifeq 15c
      // 154: goto 158
      // 157: athrow
      // 158: bipush 1
      // 159: goto 15d
      // 15c: bipush 0
      // 15d: aload 0
      // 15e: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 161: aload 0
      // 162: getfield x/oc67eb6f7f72.ɜ Lx/occ2f8dff8d8;
      // 165: iload 2
      // 166: aload 0
      // 167: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 16a: return
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
      // 0a: getfield x/oc67eb6f7f72.r Lx/oca9cc61aada;
      // 0d: if_acmpne 49
      // 10: goto 14
      // 13: athrow
      // 14: aload 0
      // 15: getfield x/oc67eb6f7f72.r Lx/oca9cc61aada;
      // 18: iload 2
      // 19: ifne 4e
      // 1c: goto 20
      // 1f: athrow
      // 20: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 23: aload 0
      // 24: getfield x/oc67eb6f7f72.ҏ Lx/oca9cc61aada;
      // 27: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 2a: dcmpl
      // 2b: ifle 49
      // 2e: goto 32
      // 31: athrow
      // 32: aload 0
      // 33: getfield x/oc67eb6f7f72.ҏ Lx/oca9cc61aada;
      // 36: aload 0
      // 37: getfield x/oc67eb6f7f72.r Lx/oca9cc61aada;
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
      // 57: getfield x/oc67eb6f7f72.ҏ Lx/oca9cc61aada;
      // 5a: if_acmpne 8e
      // 5d: aload 0
      // 5e: iload 2
      // 5f: ifne 8f
      // 62: goto 66
      // 65: athrow
      // 66: getfield x/oc67eb6f7f72.ҏ Lx/oca9cc61aada;
      // 69: goto 6d
      // 6c: athrow
      // 6d: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 70: aload 0
      // 71: getfield x/oc67eb6f7f72.r Lx/oca9cc61aada;
      // 74: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 77: dcmpg
      // 78: ifge 8e
      // 7b: aload 0
      // 7c: getfield x/oc67eb6f7f72.r Lx/oca9cc61aada;
      // 7f: aload 0
      // 80: getfield x/oc67eb6f7f72.ҏ Lx/oca9cc61aada;
      // 83: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 86: invokevirtual x/oca9cc61aada.Ȟ (D)D
      // 89: pop2
      // 8a: goto 8e
      // 8d: athrow
      // 8e: aload 0
      // 8f: invokevirtual x/oc67eb6f7f72.z$2u87utkr1isxg ()V
      // 92: return
   }

   @Override
   public void guiButtonToggled(occ2f8dff8d8 var1) {
      this.z$2u87utkr1isxg();
      super.guiButtonToggled(var1);
   }

   @Override
   public void z$3tl278wzjcayb(N var1) {
      this.z$2u87utkr1isxg();
   }

   @oc66fa4f2195
   public void Ş(oc2f61de30bc param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: istore 2
      // 004: aload 0
      // 005: iload 2
      // 006: ifne 01f
      // 009: getfield x/oc67eb6f7f72.Ǿ Lx/oca9cc61aada;
      // 00c: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 00f: d2i
      // 010: bipush 1
      // 011: if_icmpne 01e
      // 014: goto 018
      // 017: athrow
      // 018: aload 0
      // 019: invokevirtual x/oc67eb6f7f72.F ()V
      // 01c: return
      // 01d: athrow
      // 01e: aload 0
      // 01f: iload 2
      // 020: ifne 03c
      // 023: getfield x/oc67eb6f7f72.ř I
      // 026: ifle 03b
      // 029: goto 02d
      // 02c: athrow
      // 02d: aload 0
      // 02e: dup
      // 02f: getfield x/oc67eb6f7f72.ř I
      // 032: bipush 1
      // 033: isub
      // 034: putfield x/oc67eb6f7f72.ř I
      // 037: goto 03b
      // 03a: athrow
      // 03b: aload 0
      // 03c: getfield x/oc67eb6f7f72.ʎ I
      // 03f: iload 2
      // 040: ifne 069
      // 043: ifle 058
      // 046: goto 04a
      // 049: athrow
      // 04a: aload 0
      // 04b: dup
      // 04c: getfield x/oc67eb6f7f72.ʎ I
      // 04f: bipush 1
      // 050: isub
      // 051: putfield x/oc67eb6f7f72.ʎ I
      // 054: goto 058
      // 057: athrow
      // 058: getstatic x/oc67eb6f7f72.ή Lnet/minecraft/client/Minecraft;
      // 05b: iload 2
      // 05c: ifne 084
      // 05f: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 062: instanceof net/minecraft/client/gui/inventory/GuiChest
      // 065: goto 069
      // 068: athrow
      // 069: ifne 07d
      // 06c: aload 0
      // 06d: bipush 0
      // 06e: putfield x/oc67eb6f7f72.Ӂ Z
      // 071: iload 2
      // 072: aload 0
      // 073: invokevirtual x/oc67eb6f7f72.Ɂ ()V
      // 076: ifeq 6de
      // 079: goto 07d
      // 07c: athrow
      // 07d: getstatic x/oc67eb6f7f72.ή Lnet/minecraft/client/Minecraft;
      // 080: goto 084
      // 083: athrow
      // 084: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 087: checkcast net/minecraft/client/gui/inventory/GuiChest
      // 08a: getfield net/minecraft/client/gui/inventory/GuiChest.inventorySlots Lnet/minecraft/inventory/Container;
      // 08d: astore 3
      // 08e: aload 3
      // 08f: instanceof net/minecraft/inventory/ContainerChest
      // 092: iload 2
      // 093: ifne 0be
      // 096: ifne 0ae
      // 099: goto 09d
      // 09c: athrow
      // 09d: aload 0
      // 09e: bipush 0
      // 09f: putfield x/oc67eb6f7f72.Ӂ Z
      // 0a2: iload 2
      // 0a3: aload 0
      // 0a4: invokevirtual x/oc67eb6f7f72.Ɂ ()V
      // 0a7: ifeq 6de
      // 0aa: goto 0ae
      // 0ad: athrow
      // 0ae: aload 0
      // 0af: iload 2
      // 0b0: ifne 0de
      // 0b3: goto 0b7
      // 0b6: athrow
      // 0b7: getfield x/oc67eb6f7f72.Ӂ Z
      // 0ba: goto 0be
      // 0bd: athrow
      // 0be: ifne 0dd
      // 0c1: aload 0
      // 0c2: bipush 1
      // 0c3: putfield x/oc67eb6f7f72.Ӂ Z
      // 0c6: aload 0
      // 0c7: bipush 0
      // 0c8: putfield x/oc67eb6f7f72.å Z
      // 0cb: aload 0
      // 0cc: aload 0
      // 0cd: getfield x/oc67eb6f7f72.Τ Lx/oca9cc61aada;
      // 0d0: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0d3: d2i
      // 0d4: bipush 1
      // 0d5: iadd
      // 0d6: putfield x/oc67eb6f7f72.ʎ I
      // 0d9: goto 0dd
      // 0dc: athrow
      // 0dd: aload 0
      // 0de: iload 2
      // 0df: ifne 0f1
      // 0e2: getfield x/oc67eb6f7f72.ʎ I
      // 0e5: ifgt 6de
      // 0e8: goto 0ec
      // 0eb: athrow
      // 0ec: aload 0
      // 0ed: goto 0f1
      // 0f0: athrow
      // 0f1: iload 2
      // 0f2: ifne 104
      // 0f5: getfield x/oc67eb6f7f72.ř I
      // 0f8: ifgt 6de
      // 0fb: goto 0ff
      // 0fe: athrow
      // 0ff: aload 0
      // 100: goto 104
      // 103: athrow
      // 104: iload 2
      // 105: ifne 117
      // 108: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 10b: ifeq 6de
      // 10e: goto 112
      // 111: athrow
      // 112: aload 0
      // 113: goto 117
      // 116: athrow
      // 117: invokevirtual x/oc67eb6f7f72.i ()Z
      // 11a: ifeq 6de
      // 11d: aload 3
      // 11e: checkcast net/minecraft/inventory/ContainerChest
      // 121: invokevirtual net/minecraft/inventory/ContainerChest.getLowerChestInventory ()Lnet/minecraft/inventory/IInventory;
      // 124: astore 4
      // 126: aload 0
      // 127: getfield x/oc67eb6f7f72.C Lx/occ2f8dff8d8;
      // 12a: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 12d: iload 2
      // 12e: ifne 186
      // 131: ifeq 17a
      // 134: goto 138
      // 137: athrow
      // 138: aload 4
      // 13a: invokeinterface net/minecraft/inventory/IInventory.getName ()Ljava/lang/String; 1
      // 13f: astore 5
      // 141: aload 5
      // 143: ldc_w "container.chest"
      // 146: bipush 0
      // 147: anewarray 505
      // 14a: invokestatic net/minecraft/client/resources/I18n.format (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      // 14d: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 150: iload 2
      // 151: ifne 186
      // 154: ifne 17a
      // 157: goto 15b
      // 15a: athrow
      // 15b: aload 5
      // 15d: ldc_w "container.chestDouble"
      // 160: bipush 0
      // 161: anewarray 505
      // 164: invokestatic net/minecraft/client/resources/I18n.format (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      // 167: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 16a: iload 2
      // 16b: ifne 186
      // 16e: goto 172
      // 171: athrow
      // 172: ifne 17a
      // 175: goto 179
      // 178: athrow
      // 179: return
      // 17a: getstatic x/oc67eb6f7f72.ή Lnet/minecraft/client/Minecraft;
      // 17d: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 180: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 183: invokevirtual net/minecraft/entity/player/InventoryPlayer.getFirstEmptyStack ()I
      // 186: iload 2
      // 187: ifne 1e7
      // 18a: bipush -1
      // 18b: if_icmpne 1dc
      // 18e: goto 192
      // 191: athrow
      // 192: aload 0
      // 193: iload 2
      // 194: ifne 1c2
      // 197: goto 19b
      // 19a: athrow
      // 19b: getfield x/oc67eb6f7f72.å Z
      // 19e: ifne 1c1
      // 1a1: goto 1a5
      // 1a4: athrow
      // 1a5: aload 0
      // 1a6: invokevirtual x/oc69da1aa7f5.z$3i8m9vxwuvqj0 ()Ljava/lang/String;
      // 1a9: ldc_w "&7[&b"
      // 1ac: swap
      // 1ad: ldc_w "&7] &cYour inventory is full!&r"
      // 1b0: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001" ]
      // 1b5: invokestatic x/oc7ab2161b9f.ý (Ljava/lang/String;)V
      // 1b8: aload 0
      // 1b9: bipush 1
      // 1ba: putfield x/oc67eb6f7f72.å Z
      // 1bd: goto 1c1
      // 1c0: athrow
      // 1c1: aload 0
      // 1c2: getfield x/oc67eb6f7f72.ˢ Lx/occ2f8dff8d8;
      // 1c5: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 1c8: ifeq 6de
      // 1cb: getstatic x/oc67eb6f7f72.ή Lnet/minecraft/client/Minecraft;
      // 1ce: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1d1: invokevirtual net/minecraft/client/entity/EntityPlayerSP.closeScreen ()V
      // 1d4: iload 2
      // 1d5: ifeq 6de
      // 1d8: goto 1dc
      // 1db: athrow
      // 1dc: aload 0
      // 1dd: getfield x/oc67eb6f7f72.Ϩ Lx/occ2f8dff8d8;
      // 1e0: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 1e3: goto 1e7
      // 1e6: athrow
      // 1e7: iload 2
      // 1e8: ifne 613
      // 1eb: ifeq 612
      // 1ee: goto 1f2
      // 1f1: athrow
      // 1f2: bipush -1
      // 1f3: istore 5
      // 1f5: dconst_0
      // 1f6: dstore 6
      // 1f8: ldc_w -1968071279
      // 1fb: ldc_w -1968071275
      // 1fe: ixor
      // 1ff: newarray 10
      // 201: dup
      // 202: bipush 0
      // 203: bipush -1
      // 204: iastore
      // 205: dup
      // 206: bipush 1
      // 207: bipush -1
      // 208: iastore
      // 209: dup
      // 20a: ldc_w -1968071273
      // 20d: ldc_w -1968071275
      // 210: ixor
      // 211: bipush -1
      // 212: iastore
      // 213: dup
      // 214: ldc_w -1968071274
      // 217: ldc_w -1968071275
      // 21a: ixor
      // 21b: bipush -1
      // 21c: iastore
      // 21d: astore 8
      // 21f: ldc_w -1968071279
      // 222: ldc_w -1968071275
      // 225: ixor
      // 226: newarray 7
      // 228: dup
      // 229: bipush 0
      // 22a: dconst_0
      // 22b: dastore
      // 22c: dup
      // 22d: bipush 1
      // 22e: dconst_0
      // 22f: dastore
      // 230: dup
      // 231: ldc_w -1968071273
      // 234: ldc_w -1968071275
      // 237: ixor
      // 238: dconst_0
      // 239: dastore
      // 23a: dup
      // 23b: ldc_w -1968071274
      // 23e: ldc_w -1968071275
      // 241: ixor
      // 242: dconst_0
      // 243: dastore
      // 244: astore 9
      // 246: bipush -1
      // 247: istore 10
      // 249: fconst_1
      // 24a: fstore 11
      // 24c: bipush -1
      // 24d: istore 12
      // 24f: fconst_1
      // 250: fstore 13
      // 252: bipush -1
      // 253: istore 14
      // 255: fconst_1
      // 256: fstore 15
      // 258: bipush -1
      // 259: istore 16
      // 25b: dconst_0
      // 25c: dstore 17
      // 25e: bipush 0
      // 25f: istore 19
      // 261: iload 19
      // 263: aload 4
      // 265: invokeinterface net/minecraft/inventory/IInventory.getSizeInventory ()I 1
      // 26a: if_icmpge 45e
      // 26d: aload 3
      // 26e: iload 2
      // 26f: ifne 28e
      // 272: iload 19
      // 274: invokevirtual net/minecraft/inventory/Container.getSlot (I)Lnet/minecraft/inventory/Slot;
      // 277: iload 2
      // 278: ifne 637
      // 27b: goto 27f
      // 27e: athrow
      // 27f: invokevirtual net/minecraft/inventory/Slot.getHasStack ()Z
      // 282: ifeq 457
      // 285: goto 289
      // 288: athrow
      // 289: aload 3
      // 28a: goto 28e
      // 28d: athrow
      // 28e: iload 19
      // 290: invokevirtual net/minecraft/inventory/Container.getSlot (I)Lnet/minecraft/inventory/Slot;
      // 293: invokevirtual net/minecraft/inventory/Slot.getStack ()Lnet/minecraft/item/ItemStack;
      // 296: astore 20
      // 298: aload 20
      // 29a: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 29d: astore 21
      // 29f: aload 21
      // 2a1: iload 2
      // 2a2: ifne 2ea
      // 2a5: instanceof net/minecraft/item/ItemSword
      // 2a8: ifeq 2e4
      // 2ab: goto 2af
      // 2ae: athrow
      // 2af: aload 20
      // 2b1: invokestatic x/oc7fbc83d9b3.ʲ (Lnet/minecraft/item/ItemStack;)D
      // 2b4: dstore 22
      // 2b6: iload 2
      // 2b7: ifne 2dc
      // 2ba: iload 5
      // 2bc: bipush -1
      // 2bd: if_icmpeq 2d8
      // 2c0: goto 2c4
      // 2c3: athrow
      // 2c4: dload 22
      // 2c6: iload 2
      // 2c7: ifne 2de
      // 2ca: goto 2ce
      // 2cd: athrow
      // 2ce: dload 6
      // 2d0: dcmpl
      // 2d1: ifle 2e0
      // 2d4: goto 2d8
      // 2d7: athrow
      // 2d8: iload 19
      // 2da: istore 5
      // 2dc: dload 22
      // 2de: dstore 6
      // 2e0: iload 2
      // 2e1: ifeq 457
      // 2e4: aload 21
      // 2e6: goto 2ea
      // 2e9: athrow
      // 2ea: iload 2
      // 2eb: ifne 345
      // 2ee: instanceof net/minecraft/item/ItemArmor
      // 2f1: ifeq 33f
      // 2f4: goto 2f8
      // 2f7: athrow
      // 2f8: aload 21
      // 2fa: checkcast net/minecraft/item/ItemArmor
      // 2fd: getfield net/minecraft/item/ItemArmor.armorType I
      // 300: istore 22
      // 302: iload 2
      // 303: aload 20
      // 305: invokestatic x/oc7fbc83d9b3.З (Lnet/minecraft/item/ItemStack;)D
      // 308: dstore 23
      // 30a: ifne 334
      // 30d: aload 8
      // 30f: iload 22
      // 311: iaload
      // 312: bipush -1
      // 313: if_icmpeq 329
      // 316: goto 31a
      // 319: athrow
      // 31a: dload 23
      // 31c: aload 9
      // 31e: iload 22
      // 320: daload
      // 321: dcmpl
      // 322: ifle 33b
      // 325: goto 329
      // 328: athrow
      // 329: aload 8
      // 32b: iload 22
      // 32d: iload 19
      // 32f: iastore
      // 330: goto 334
      // 333: athrow
      // 334: aload 9
      // 336: iload 22
      // 338: dload 23
      // 33a: dastore
      // 33b: iload 2
      // 33c: ifeq 457
      // 33f: aload 21
      // 341: goto 345
      // 344: athrow
      // 345: iload 2
      // 346: ifne 38e
      // 349: instanceof net/minecraft/item/ItemPickaxe
      // 34c: ifeq 388
      // 34f: goto 353
      // 352: athrow
      // 353: aload 20
      // 355: invokestatic x/oc7fbc83d9b3.ν (Lnet/minecraft/item/ItemStack;)F
      // 358: fstore 22
      // 35a: iload 2
      // 35b: ifne 380
      // 35e: iload 10
      // 360: bipush -1
      // 361: if_icmpeq 37c
      // 364: goto 368
      // 367: athrow
      // 368: fload 22
      // 36a: iload 2
      // 36b: ifne 382
      // 36e: goto 372
      // 371: athrow
      // 372: fload 11
      // 374: fcmpl
      // 375: ifle 384
      // 378: goto 37c
      // 37b: athrow
      // 37c: iload 19
      // 37e: istore 10
      // 380: fload 22
      // 382: fstore 11
      // 384: iload 2
      // 385: ifeq 457
      // 388: aload 21
      // 38a: goto 38e
      // 38d: athrow
      // 38e: iload 2
      // 38f: ifne 3d7
      // 392: instanceof net/minecraft/item/ItemSpade
      // 395: ifeq 3d1
      // 398: goto 39c
      // 39b: athrow
      // 39c: aload 20
      // 39e: invokestatic x/oc7fbc83d9b3.ν (Lnet/minecraft/item/ItemStack;)F
      // 3a1: fstore 22
      // 3a3: iload 2
      // 3a4: ifne 3c9
      // 3a7: iload 12
      // 3a9: bipush -1
      // 3aa: if_icmpeq 3c5
      // 3ad: goto 3b1
      // 3b0: athrow
      // 3b1: fload 22
      // 3b3: iload 2
      // 3b4: ifne 3cb
      // 3b7: goto 3bb
      // 3ba: athrow
      // 3bb: fload 13
      // 3bd: fcmpl
      // 3be: ifle 3cd
      // 3c1: goto 3c5
      // 3c4: athrow
      // 3c5: iload 19
      // 3c7: istore 12
      // 3c9: fload 22
      // 3cb: fstore 13
      // 3cd: iload 2
      // 3ce: ifeq 457
      // 3d1: aload 21
      // 3d3: goto 3d7
      // 3d6: athrow
      // 3d7: iload 2
      // 3d8: ifne 420
      // 3db: instanceof net/minecraft/item/ItemAxe
      // 3de: ifeq 41a
      // 3e1: goto 3e5
      // 3e4: athrow
      // 3e5: aload 20
      // 3e7: invokestatic x/oc7fbc83d9b3.ν (Lnet/minecraft/item/ItemStack;)F
      // 3ea: fstore 22
      // 3ec: iload 2
      // 3ed: ifne 412
      // 3f0: iload 14
      // 3f2: bipush -1
      // 3f3: if_icmpeq 40e
      // 3f6: goto 3fa
      // 3f9: athrow
      // 3fa: fload 22
      // 3fc: iload 2
      // 3fd: ifne 414
      // 400: goto 404
      // 403: athrow
      // 404: fload 15
      // 406: fcmpl
      // 407: ifle 416
      // 40a: goto 40e
      // 40d: athrow
      // 40e: iload 19
      // 410: istore 14
      // 412: fload 22
      // 414: fstore 15
      // 416: iload 2
      // 417: ifeq 457
      // 41a: aload 21
      // 41c: goto 420
      // 41f: athrow
      // 420: instanceof net/minecraft/item/ItemBow
      // 423: ifeq 457
      // 426: aload 20
      // 428: invokestatic x/oc7fbc83d9b3.Κ (Lnet/minecraft/item/ItemStack;)D
      // 42b: dstore 22
      // 42d: iload 2
      // 42e: ifne 453
      // 431: iload 16
      // 433: bipush -1
      // 434: if_icmpeq 44f
      // 437: goto 43b
      // 43a: athrow
      // 43b: dload 22
      // 43d: iload 2
      // 43e: ifne 455
      // 441: goto 445
      // 444: athrow
      // 445: dload 17
      // 447: dcmpl
      // 448: ifle 457
      // 44b: goto 44f
      // 44e: athrow
      // 44f: iload 19
      // 451: istore 16
      // 453: dload 22
      // 455: dstore 17
      // 457: iinc 19 1
      // 45a: iload 2
      // 45b: ifeq 261
      // 45e: bipush 0
      // 45f: bipush 1
      // 460: invokestatic x/oc7fbc83d9b3.ʭ (IZ)I
      // 463: istore 19
      // 465: iload 19
      // 467: bipush -1
      // 468: if_icmpeq 480
      // 46b: getstatic x/oc67eb6f7f72.ή Lnet/minecraft/client/Minecraft;
      // 46e: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 471: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 474: iload 19
      // 476: invokevirtual net/minecraft/entity/player/InventoryPlayer.getStackInSlot (I)Lnet/minecraft/item/ItemStack;
      // 479: invokestatic x/oc7fbc83d9b3.ʲ (Lnet/minecraft/item/ItemStack;)D
      // 47c: goto 481
      // 47f: athrow
      // 480: dconst_0
      // 481: dstore 20
      // 483: dload 6
      // 485: dload 20
      // 487: dcmpl
      // 488: iload 2
      // 489: ifne 4a0
      // 48c: ifle 49f
      // 48f: goto 493
      // 492: athrow
      // 493: aload 0
      // 494: aload 3
      // 495: getfield net/minecraft/inventory/Container.windowId I
      // 498: iload 5
      // 49a: invokevirtual x/oc67eb6f7f72.ѭ (II)V
      // 49d: return
      // 49e: athrow
      // 49f: bipush 0
      // 4a0: istore 22
      // 4a2: iload 22
      // 4a4: ldc_w -1968071279
      // 4a7: ldc_w -1968071275
      // 4aa: ixor
      // 4ab: if_icmpge 505
      // 4ae: iload 22
      // 4b0: bipush 1
      // 4b1: invokestatic x/oc7fbc83d9b3.Ǵ (IZ)I
      // 4b4: istore 23
      // 4b6: iload 2
      // 4b7: ifne 50f
      // 4ba: iload 23
      // 4bc: bipush -1
      // 4bd: if_icmpeq 4d9
      // 4c0: goto 4c4
      // 4c3: athrow
      // 4c4: getstatic x/oc67eb6f7f72.ή Lnet/minecraft/client/Minecraft;
      // 4c7: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 4ca: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 4cd: iload 23
      // 4cf: invokevirtual net/minecraft/entity/player/InventoryPlayer.getStackInSlot (I)Lnet/minecraft/item/ItemStack;
      // 4d2: invokestatic x/oc7fbc83d9b3.З (Lnet/minecraft/item/ItemStack;)D
      // 4d5: goto 4da
      // 4d8: athrow
      // 4d9: dconst_0
      // 4da: dstore 24
      // 4dc: iload 2
      // 4dd: ifne 501
      // 4e0: aload 9
      // 4e2: iload 22
      // 4e4: daload
      // 4e5: dload 24
      // 4e7: dcmpl
      // 4e8: ifle 4fe
      // 4eb: goto 4ef
      // 4ee: athrow
      // 4ef: aload 0
      // 4f0: aload 3
      // 4f1: getfield net/minecraft/inventory/Container.windowId I
      // 4f4: aload 8
      // 4f6: iload 22
      // 4f8: iaload
      // 4f9: invokevirtual x/oc67eb6f7f72.ѭ (II)V
      // 4fc: return
      // 4fd: athrow
      // 4fe: iinc 22 1
      // 501: iload 2
      // 502: ifeq 4a2
      // 505: ldc_w "pickaxe"
      // 508: bipush 0
      // 509: bipush 1
      // 50a: invokestatic x/oc7fbc83d9b3.Ň (Ljava/lang/String;IZ)I
      // 50d: istore 22
      // 50f: iload 22
      // 511: bipush -1
      // 512: if_icmpeq 52a
      // 515: getstatic x/oc67eb6f7f72.ή Lnet/minecraft/client/Minecraft;
      // 518: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 51b: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 51e: iload 22
      // 520: invokevirtual net/minecraft/entity/player/InventoryPlayer.getStackInSlot (I)Lnet/minecraft/item/ItemStack;
      // 523: invokestatic x/oc7fbc83d9b3.ν (Lnet/minecraft/item/ItemStack;)F
      // 526: goto 52b
      // 529: athrow
      // 52a: fconst_1
      // 52b: fstore 23
      // 52d: fload 11
      // 52f: fload 23
      // 531: fcmpl
      // 532: iload 2
      // 533: ifne 551
      // 536: ifle 549
      // 539: goto 53d
      // 53c: athrow
      // 53d: aload 0
      // 53e: aload 3
      // 53f: getfield net/minecraft/inventory/Container.windowId I
      // 542: iload 10
      // 544: invokevirtual x/oc67eb6f7f72.ѭ (II)V
      // 547: return
      // 548: athrow
      // 549: ldc_w "shovel"
      // 54c: bipush 0
      // 54d: bipush 1
      // 54e: invokestatic x/oc7fbc83d9b3.Ň (Ljava/lang/String;IZ)I
      // 551: istore 24
      // 553: iload 24
      // 555: bipush -1
      // 556: if_icmpeq 56e
      // 559: getstatic x/oc67eb6f7f72.ή Lnet/minecraft/client/Minecraft;
      // 55c: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 55f: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 562: iload 24
      // 564: invokevirtual net/minecraft/entity/player/InventoryPlayer.getStackInSlot (I)Lnet/minecraft/item/ItemStack;
      // 567: invokestatic x/oc7fbc83d9b3.ν (Lnet/minecraft/item/ItemStack;)F
      // 56a: goto 56f
      // 56d: athrow
      // 56e: fconst_1
      // 56f: fstore 25
      // 571: fload 13
      // 573: fload 25
      // 575: fcmpl
      // 576: iload 2
      // 577: ifne 595
      // 57a: ifle 58d
      // 57d: goto 581
      // 580: athrow
      // 581: aload 0
      // 582: aload 3
      // 583: getfield net/minecraft/inventory/Container.windowId I
      // 586: iload 12
      // 588: invokevirtual x/oc67eb6f7f72.ѭ (II)V
      // 58b: return
      // 58c: athrow
      // 58d: ldc_w "axe"
      // 590: bipush 0
      // 591: bipush 1
      // 592: invokestatic x/oc7fbc83d9b3.Ň (Ljava/lang/String;IZ)I
      // 595: istore 26
      // 597: iload 26
      // 599: bipush -1
      // 59a: if_icmpeq 5b2
      // 59d: getstatic x/oc67eb6f7f72.ή Lnet/minecraft/client/Minecraft;
      // 5a0: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 5a3: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 5a6: iload 26
      // 5a8: invokevirtual net/minecraft/entity/player/InventoryPlayer.getStackInSlot (I)Lnet/minecraft/item/ItemStack;
      // 5ab: invokestatic x/oc7fbc83d9b3.ν (Lnet/minecraft/item/ItemStack;)F
      // 5ae: goto 5b3
      // 5b1: athrow
      // 5b2: fconst_1
      // 5b3: fstore 27
      // 5b5: fload 15
      // 5b7: fload 27
      // 5b9: fcmpl
      // 5ba: iload 2
      // 5bb: ifne 5d6
      // 5be: ifle 5d1
      // 5c1: goto 5c5
      // 5c4: athrow
      // 5c5: aload 0
      // 5c6: aload 3
      // 5c7: getfield net/minecraft/inventory/Container.windowId I
      // 5ca: iload 14
      // 5cc: invokevirtual x/oc67eb6f7f72.ѭ (II)V
      // 5cf: return
      // 5d0: athrow
      // 5d1: bipush 0
      // 5d2: bipush 1
      // 5d3: invokestatic x/oc7fbc83d9b3.Ǚ (IZ)I
      // 5d6: istore 28
      // 5d8: iload 28
      // 5da: bipush -1
      // 5db: if_icmpeq 5f3
      // 5de: getstatic x/oc67eb6f7f72.ή Lnet/minecraft/client/Minecraft;
      // 5e1: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 5e4: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 5e7: iload 28
      // 5e9: invokevirtual net/minecraft/entity/player/InventoryPlayer.getStackInSlot (I)Lnet/minecraft/item/ItemStack;
      // 5ec: invokestatic x/oc7fbc83d9b3.Κ (Lnet/minecraft/item/ItemStack;)D
      // 5ef: goto 5f4
      // 5f2: athrow
      // 5f3: dconst_0
      // 5f4: dstore 29
      // 5f6: dload 17
      // 5f8: dload 29
      // 5fa: dcmpl
      // 5fb: iload 2
      // 5fc: ifne 613
      // 5ff: ifle 612
      // 602: goto 606
      // 605: athrow
      // 606: aload 0
      // 607: aload 3
      // 608: getfield net/minecraft/inventory/Container.windowId I
      // 60b: iload 16
      // 60d: invokevirtual x/oc67eb6f7f72.ѭ (II)V
      // 610: return
      // 611: athrow
      // 612: bipush 0
      // 613: istore 5
      // 615: iload 5
      // 617: aload 4
      // 619: invokeinterface net/minecraft/inventory/IInventory.getSizeInventory ()I 1
      // 61e: if_icmpge 6c7
      // 621: iload 2
      // 622: ifne 6de
      // 625: aload 3
      // 626: iload 5
      // 628: iload 2
      // 629: ifne 644
      // 62c: goto 630
      // 62f: athrow
      // 630: invokevirtual net/minecraft/inventory/Container.getSlot (I)Lnet/minecraft/inventory/Slot;
      // 633: goto 637
      // 636: athrow
      // 637: invokevirtual net/minecraft/inventory/Slot.getHasStack ()Z
      // 63a: ifeq 6c0
      // 63d: aload 3
      // 63e: iload 5
      // 640: goto 644
      // 643: athrow
      // 644: invokevirtual net/minecraft/inventory/Container.getSlot (I)Lnet/minecraft/inventory/Slot;
      // 647: invokevirtual net/minecraft/inventory/Slot.getStack ()Lnet/minecraft/item/ItemStack;
      // 64a: astore 6
      // 64c: iload 2
      // 64d: ifne 6bf
      // 650: aload 0
      // 651: getfield x/oc67eb6f7f72.Ϩ Lx/occ2f8dff8d8;
      // 654: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 657: ifeq 6b1
      // 65a: goto 65e
      // 65d: athrow
      // 65e: aload 6
      // 660: invokestatic x/oc7fbc83d9b3.ɯ (Lnet/minecraft/item/ItemStack;)Z
      // 663: iload 2
      // 664: ifne 684
      // 667: goto 66b
      // 66a: athrow
      // 66b: ifeq 6b1
      // 66e: goto 672
      // 671: athrow
      // 672: aload 0
      // 673: iload 2
      // 674: ifne 6b6
      // 677: goto 67b
      // 67a: athrow
      // 67b: aload 6
      // 67d: invokevirtual x/oc67eb6f7f72.V (Lnet/minecraft/item/ItemStack;)Z
      // 680: goto 684
      // 683: athrow
      // 684: ifne 6b1
      // 687: aload 0
      // 688: iload 2
      // 689: ifne 6b6
      // 68c: goto 690
      // 68f: athrow
      // 690: aload 6
      // 692: invokevirtual x/oc67eb6f7f72.ӛ (Lnet/minecraft/item/ItemStack;)Z
      // 695: ifne 6b1
      // 698: goto 69c
      // 69b: athrow
      // 69c: aload 0
      // 69d: iload 2
      // 69e: ifne 6b6
      // 6a1: goto 6a5
      // 6a4: athrow
      // 6a5: aload 6
      // 6a7: invokevirtual x/oc67eb6f7f72.ǫ (Lnet/minecraft/item/ItemStack;)Z
      // 6aa: ifeq 6c0
      // 6ad: goto 6b1
      // 6b0: athrow
      // 6b1: aload 0
      // 6b2: goto 6b6
      // 6b5: athrow
      // 6b6: aload 3
      // 6b7: getfield net/minecraft/inventory/Container.windowId I
      // 6ba: iload 5
      // 6bc: invokevirtual x/oc67eb6f7f72.ѭ (II)V
      // 6bf: return
      // 6c0: iinc 5 1
      // 6c3: iload 2
      // 6c4: ifeq 615
      // 6c7: aload 0
      // 6c8: getfield x/oc67eb6f7f72.ˢ Lx/occ2f8dff8d8;
      // 6cb: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 6ce: ifeq 6de
      // 6d1: getstatic x/oc67eb6f7f72.ή Lnet/minecraft/client/Minecraft;
      // 6d4: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 6d7: invokevirtual net/minecraft/client/entity/EntityPlayerSP.closeScreen ()V
      // 6da: goto 6de
      // 6dd: athrow
      // 6de: return
   }

   private void F() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: istore 1
      // 004: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 007: iload 1
      // 008: ifne 027
      // 00b: ifne 013
      // 00e: goto 012
      // 011: athrow
      // 012: return
      // 013: getstatic x/oc67eb6f7f72.ή Lnet/minecraft/client/Minecraft;
      // 016: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 019: iload 1
      // 01a: ifne 034
      // 01d: getfield net/minecraft/client/entity/EntityPlayerSP.openContainer Lnet/minecraft/inventory/Container;
      // 020: instanceof net/minecraft/inventory/ContainerChest
      // 023: goto 027
      // 026: athrow
      // 027: ifeq 2eb
      // 02a: getstatic x/oc67eb6f7f72.ή Lnet/minecraft/client/Minecraft;
      // 02d: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 030: goto 034
      // 033: athrow
      // 034: getfield net/minecraft/client/entity/EntityPlayerSP.openContainer Lnet/minecraft/inventory/Container;
      // 037: checkcast net/minecraft/inventory/ContainerChest
      // 03a: astore 2
      // 03b: aload 0
      // 03c: getfield x/oc67eb6f7f72.ɜ Lx/occ2f8dff8d8;
      // 03f: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 042: iload 1
      // 043: ifne 09d
      // 046: ifeq 09c
      // 049: goto 04d
      // 04c: athrow
      // 04d: aload 2
      // 04e: invokevirtual net/minecraft/inventory/ContainerChest.getLowerChestInventory ()Lnet/minecraft/inventory/IInventory;
      // 051: invokeinterface net/minecraft/inventory/IInventory.getDisplayName ()Lnet/minecraft/util/IChatComponent; 1
      // 056: invokeinterface net/minecraft/util/IChatComponent.getUnformattedText ()Ljava/lang/String; 1
      // 05b: invokevirtual java/lang/String.toLowerCase ()Ljava/lang/String;
      // 05e: astore 3
      // 05f: getstatic x/oc67eb6f7f72.Ѭ [Ljava/lang/String;
      // 062: astore 4
      // 064: aload 4
      // 066: arraylength
      // 067: istore 5
      // 069: bipush 0
      // 06a: istore 6
      // 06c: iload 6
      // 06e: iload 5
      // 070: if_icmpge 09c
      // 073: aload 4
      // 075: iload 6
      // 077: aaload
      // 078: astore 7
      // 07a: iload 1
      // 07b: ifne 303
      // 07e: iload 1
      // 07f: ifne 098
      // 082: goto 086
      // 085: athrow
      // 086: aload 3
      // 087: aload 7
      // 089: invokevirtual java/lang/String.contains (Ljava/lang/CharSequence;)Z
      // 08c: ifeq 095
      // 08f: goto 093
      // 092: athrow
      // 093: return
      // 094: athrow
      // 095: iinc 6 1
      // 098: iload 1
      // 099: ifeq 06c
      // 09c: bipush 0
      // 09d: istore 3
      // 09e: aload 0
      // 09f: getfield x/oc67eb6f7f72.ľ Lx/ocba5f31cad4;
      // 0a2: aload 0
      // 0a3: getfield x/oc67eb6f7f72.Ŵ Lx/oca9cc61aada;
      // 0a6: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0a9: ldc2_w 50.0
      // 0ac: dmul
      // 0ad: invokevirtual x/ocba5f31cad4.ξ (D)Z
      // 0b0: istore 4
      // 0b2: iload 4
      // 0b4: iload 1
      // 0b5: ifne 29b
      // 0b8: ifeq 298
      // 0bb: goto 0bf
      // 0be: athrow
      // 0bf: new java/util/ArrayList
      // 0c2: dup
      // 0c3: invokespecial java/util/ArrayList.<init> ()V
      // 0c6: astore 5
      // 0c8: bipush 0
      // 0c9: istore 6
      // 0cb: aload 0
      // 0cc: getfield x/oc67eb6f7f72.Ǧ Lx/occ2f8dff8d8;
      // 0cf: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 0d2: iload 1
      // 0d3: ifne 157
      // 0d6: ifeq 156
      // 0d9: goto 0dd
      // 0dc: athrow
      // 0dd: ldc_w 2121449038
      // 0e0: ldc_w 2121449031
      // 0e3: ixor
      // 0e4: istore 7
      // 0e6: iload 7
      // 0e8: ldc_w 2121449066
      // 0eb: ldc_w 2121449031
      // 0ee: ixor
      // 0ef: if_icmpge 156
      // 0f2: getstatic x/oc67eb6f7f72.ή Lnet/minecraft/client/Minecraft;
      // 0f5: iload 1
      // 0f6: ifne 2d2
      // 0f9: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0fc: getfield net/minecraft/client/entity/EntityPlayerSP.inventoryContainer Lnet/minecraft/inventory/Container;
      // 0ff: iload 7
      // 101: invokevirtual net/minecraft/inventory/Container.getSlot (I)Lnet/minecraft/inventory/Slot;
      // 104: invokevirtual net/minecraft/inventory/Slot.getStack ()Lnet/minecraft/item/ItemStack;
      // 107: astore 8
      // 109: iload 1
      // 10a: ifne 152
      // 10d: aload 8
      // 10f: ifnull 14f
      // 112: goto 116
      // 115: athrow
      // 116: aload 8
      // 118: iload 1
      // 119: ifne 130
      // 11c: goto 120
      // 11f: athrow
      // 120: invokestatic x/oc7fbc83d9b3.Ó (Lnet/minecraft/item/ItemStack;)Z
      // 123: ifeq 14f
      // 126: goto 12a
      // 129: athrow
      // 12a: aload 8
      // 12c: goto 130
      // 12f: athrow
      // 130: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 133: instanceof net/minecraft/item/ItemBlock
      // 136: iload 1
      // 137: ifne 14d
      // 13a: ifeq 14f
      // 13d: goto 141
      // 140: athrow
      // 141: iload 6
      // 143: aload 8
      // 145: getfield net/minecraft/item/ItemStack.stackSize I
      // 148: iadd
      // 149: goto 14d
      // 14c: athrow
      // 14d: istore 6
      // 14f: iinc 7 1
      // 152: iload 1
      // 153: ifeq 0e6
      // 156: bipush 0
      // 157: istore 7
      // 159: iload 7
      // 15b: aload 2
      // 15c: invokevirtual net/minecraft/inventory/ContainerChest.getLowerChestInventory ()Lnet/minecraft/inventory/IInventory;
      // 15f: invokeinterface net/minecraft/inventory/IInventory.getSizeInventory ()I 1
      // 164: if_icmpge 20c
      // 167: aload 2
      // 168: invokevirtual net/minecraft/inventory/ContainerChest.getLowerChestInventory ()Lnet/minecraft/inventory/IInventory;
      // 16b: iload 7
      // 16d: invokeinterface net/minecraft/inventory/IInventory.getStackInSlot (I)Lnet/minecraft/item/ItemStack; 2
      // 172: astore 8
      // 174: iload 1
      // 175: ifne 221
      // 178: iload 1
      // 179: ifne 208
      // 17c: goto 180
      // 17f: athrow
      // 180: aload 8
      // 182: ifnull 205
      // 185: goto 189
      // 188: athrow
      // 189: aload 8
      // 18b: invokestatic x/oc7fbc83d9b3.Ó (Lnet/minecraft/item/ItemStack;)Z
      // 18e: iload 1
      // 18f: ifne 1b0
      // 192: goto 196
      // 195: athrow
      // 196: ifne 1a5
      // 199: goto 19d
      // 19c: athrow
      // 19d: iload 1
      // 19e: ifeq 205
      // 1a1: goto 1a5
      // 1a4: athrow
      // 1a5: aload 0
      // 1a6: getfield x/oc67eb6f7f72.Ǧ Lx/occ2f8dff8d8;
      // 1a9: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 1ac: goto 1b0
      // 1af: athrow
      // 1b0: iload 1
      // 1b1: ifne 204
      // 1b4: ifeq 1f4
      // 1b7: goto 1bb
      // 1ba: athrow
      // 1bb: aload 8
      // 1bd: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 1c0: instanceof net/minecraft/item/ItemBlock
      // 1c3: iload 1
      // 1c4: ifne 204
      // 1c7: goto 1cb
      // 1ca: athrow
      // 1cb: ifeq 1f4
      // 1ce: goto 1d2
      // 1d1: athrow
      // 1d2: iload 6
      // 1d4: iload 1
      // 1d5: ifne 204
      // 1d8: goto 1dc
      // 1db: athrow
      // 1dc: i2d
      // 1dd: aload 0
      // 1de: getfield x/oc67eb6f7f72.Ё Lx/oca9cc61aada;
      // 1e1: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 1e4: dcmpl
      // 1e5: iflt 1f4
      // 1e8: goto 1ec
      // 1eb: athrow
      // 1ec: iload 1
      // 1ed: ifeq 205
      // 1f0: goto 1f4
      // 1f3: athrow
      // 1f4: aload 5
      // 1f6: iload 7
      // 1f8: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 1fb: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 200: goto 204
      // 203: athrow
      // 204: pop
      // 205: iinc 7 1
      // 208: iload 1
      // 209: ifeq 159
      // 20c: aload 0
      // 20d: getfield x/oc67eb6f7f72.ɧ Lx/ocba5f31cad4;
      // 210: aload 0
      // 211: getfield x/oc67eb6f7f72.Ĭ J
      // 214: ldc2_w -3912670815990415576
      // 217: ldc2_w -3912670815990415590
      // 21a: lxor
      // 21b: lmul
      // 21c: invokevirtual x/ocba5f31cad4.Ũ (J)Z
      // 21f: istore 7
      // 221: aload 5
      // 223: iload 1
      // 224: ifne 286
      // 227: invokeinterface java/util/List.isEmpty ()Z 1
      // 22c: ifne 284
      // 22f: goto 233
      // 232: athrow
      // 233: iload 4
      // 235: iload 1
      // 236: ifne 28b
      // 239: goto 23d
      // 23c: athrow
      // 23d: aload 0
      // 23e: getfield x/oc67eb6f7f72.ȳ Lx/occ2f8dff8d8;
      // 241: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 244: iload 7
      // 246: invokestatic x/oc67eb6f7f72.А (ZZZ)Z
      // 249: ifeq 284
      // 24c: goto 250
      // 24f: athrow
      // 250: aload 0
      // 251: iload 1
      // 252: ifne 27a
      // 255: goto 259
      // 258: athrow
      // 259: getfield x/oc67eb6f7f72.ȳ Lx/occ2f8dff8d8;
      // 25c: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 25f: ifeq 275
      // 262: goto 266
      // 265: athrow
      // 266: aload 0
      // 267: aload 2
      // 268: aload 5
      // 26a: invokevirtual x/oc67eb6f7f72.Ӱ (Lnet/minecraft/inventory/ContainerChest;Ljava/util/List;)V
      // 26d: iload 1
      // 26e: ifeq 284
      // 271: goto 275
      // 274: athrow
      // 275: aload 0
      // 276: goto 27a
      // 279: athrow
      // 27a: aload 2
      // 27b: aload 0
      // 27c: aload 5
      // 27e: invokevirtual x/oc67eb6f7f72.М (Ljava/util/List;)I
      // 281: invokevirtual x/oc67eb6f7f72.ȷ (Lnet/minecraft/inventory/ContainerChest;I)V
      // 284: aload 5
      // 286: invokeinterface java/util/List.isEmpty ()Z 1
      // 28b: iload 1
      // 28c: ifne 29b
      // 28f: ifeq 298
      // 292: goto 296
      // 295: athrow
      // 296: bipush 1
      // 297: istore 3
      // 298: invokestatic x/oc7fbc83d9b3.ʘ ()Z
      // 29b: iload 1
      // 29c: ifne 2cc
      // 29f: ifne 2b6
      // 2a2: goto 2a6
      // 2a5: athrow
      // 2a6: iload 3
      // 2a7: iload 1
      // 2a8: ifne 2cc
      // 2ab: goto 2af
      // 2ae: athrow
      // 2af: ifeq 2dc
      // 2b2: goto 2b6
      // 2b5: athrow
      // 2b6: aload 0
      // 2b7: getfield x/oc67eb6f7f72.ӂ Lx/ocba5f31cad4;
      // 2ba: aload 0
      // 2bb: getfield x/oc67eb6f7f72.ÿ Lx/oca9cc61aada;
      // 2be: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 2c1: ldc2_w 50.0
      // 2c4: dmul
      // 2c5: invokevirtual x/ocba5f31cad4.ξ (D)Z
      // 2c8: goto 2cc
      // 2cb: athrow
      // 2cc: ifeq 2e7
      // 2cf: getstatic x/oc67eb6f7f72.ή Lnet/minecraft/client/Minecraft;
      // 2d2: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 2d5: invokevirtual net/minecraft/client/entity/EntityPlayerSP.closeScreen ()V
      // 2d8: iload 1
      // 2d9: ifeq 2e7
      // 2dc: aload 0
      // 2dd: getfield x/oc67eb6f7f72.ӂ Lx/ocba5f31cad4;
      // 2e0: invokevirtual x/ocba5f31cad4.Ÿ ()V
      // 2e3: goto 2e7
      // 2e6: athrow
      // 2e7: iload 1
      // 2e8: ifeq 303
      // 2eb: aload 0
      // 2ec: aload 0
      // 2ed: getfield x/oc67eb6f7f72.ø Lx/ocf1568fef75;
      // 2f0: invokevirtual x/ocf1568fef75.ϐ ()D
      // 2f3: d2i
      // 2f4: i2l
      // 2f5: putfield x/oc67eb6f7f72.Ĭ J
      // 2f8: aload 0
      // 2f9: getfield x/oc67eb6f7f72.ľ Lx/ocba5f31cad4;
      // 2fc: invokevirtual x/ocba5f31cad4.Ÿ ()V
      // 2ff: goto 303
      // 302: athrow
      // 303: return
   }

   static boolean А(boolean param0, boolean param1, boolean param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 3
      // 04: iload 0
      // 05: iload 3
      // 06: ifne 11
      // 09: ifeq 30
      // 0c: goto 10
      // 0f: athrow
      // 10: iload 1
      // 11: iload 3
      // 12: ifne 2d
      // 15: ifne 2c
      // 18: goto 1c
      // 1b: athrow
      // 1c: iload 2
      // 1d: iload 3
      // 1e: ifne 2d
      // 21: goto 25
      // 24: athrow
      // 25: ifeq 30
      // 28: goto 2c
      // 2b: athrow
      // 2c: bipush 1
      // 2d: goto 31
      // 30: bipush 0
      // 31: ireturn
   }

   private int М(List<Integer> var1) {
      int var2 = oc84f20a0bc5.ė;
      int var3 = -1397452381 ^ 127886307;

      while (true) {
         switch (var3) {
            case -1423183296:
               int var6;
               label39: {
                  label38: {
                     try {
                        var6 = (int)this.ӊ.Ӂ();
                        if (var2 != 0) {
                           break label39;
                        }

                        if (var6 != 1) {
                           break label38;
                        }
                     } catch (ocbde1165e4e var4) {
                        throw var4;
                     }

                     var3 = 286525263 ^ 127886307;
                     if (var2 == 0) {
                        break;
                     }
                  }

                  var6 = -1976499464 ^ 127886307;
               }

               var3 = var6;
               break;
            case 378234028:
               return (Integer)var1.get(ThreadLocalRandom.current().nextInt(var1.size()));
            case 1235437353:
               var1.sort(Comparator.comparingInt(var1x -> {
                  int var2x = var1x / (1111169440 ^ 1111169449);
                  int var3x = var1x % (1111169440 ^ 1111169449);
                  int var4x = this.Ù / (1111169440 ^ 1111169449);
                  int var5x = this.Ù % (1111169440 ^ 1111169449);
                  return (var3x - var5x) * (var3x - var5x) + (var2x - var4x) * (var2x - var4x);
               }));
               var3 = -988957042 ^ 127886307;
               if (var2 == 0) {
                  break;
               }
            case -1917951717:
               int var10000;
               label48: {
                  label47: {
                     try {
                        var10000 = (int)this.ӊ.Ӂ();
                        if (var2 != 0) {
                           break label48;
                        }

                        if (var10000 != (127886305 ^ 127886307)) {
                           break label47;
                        }
                     } catch (ocbde1165e4e var5) {
                        throw var5;
                     }

                     var3 = 1312564426 ^ 127886307;
                     if (var2 == 0) {
                        break;
                     }
                  }

                  var10000 = -988957042 ^ 127886307;
               }

               var3 = var10000;
               if (var2 == 0) {
                  break;
               }
            case -1030564499:
               return (Integer)var1.get(0);
            default:
               throw null;
         }
      }
   }

   private void Ӱ(ContainerChest var1, List<Integer> var2) {
      int var10000 = oc84f20a0bc5.ė;
      Iterator var4 = var2.iterator();
      int var3 = var10000;

      while (true) {
         if (var4.hasNext()) {
            int var5 = (Integer)var4.next();
            if (var3 != 0) {
               break;
            }

            ItemStack var6 = var1.getLowerChestInventory().getStackInSlot(var5);

            label38: {
               try {
                  var9 = var6;
                  if (var3 != 0) {
                     break label38;
                  }

                  if (var6 == null) {
                     continue;
                  }
               } catch (ocbde1165e4e var8) {
                  throw var8;
               }

               var9 = var6;
            }

            try {
               if (!oc7fbc83d9b3.Ó(var9) && var3 == 0) {
                  continue;
               }
            } catch (ocbde1165e4e var7) {
               throw var7;
            }

            this.Ù = var5;
            this.Ҟ(var1.windowId, var5, 0, 1);
            if (var3 == 0) {
               continue;
            }
         }

         this.Ĭ = 0L;
         this.ɧ.Ÿ();
         break;
      }
   }

   private void ȷ(ContainerChest param1, int param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 3
      // 04: invokestatic java/util/concurrent/ThreadLocalRandom.current ()Ljava/util/concurrent/ThreadLocalRandom;
      // 07: ldc_w -1116365783
      // 0a: ldc_w -1116365747
      // 0d: ixor
      // 0e: invokevirtual java/util/concurrent/ThreadLocalRandom.nextInt (I)I
      // 11: iload 3
      // 12: ifne 32
      // 15: i2d
      // 16: aload 0
      // 17: getfield x/oc67eb6f7f72.ռ Lx/oca9cc61aada;
      // 1a: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 1d: dcmpg
      // 1e: ifgt c9
      // 21: goto 25
      // 24: athrow
      // 25: iload 2
      // 26: ldc_w -1116365756
      // 29: ldc_w -1116365747
      // 2c: ixor
      // 2d: idiv
      // 2e: goto 32
      // 31: athrow
      // 32: istore 4
      // 34: iload 3
      // 35: ifne ed
      // 38: iload 2
      // 39: ldc_w -1116365756
      // 3c: ldc_w -1116365747
      // 3f: ixor
      // 40: irem
      // 41: istore 5
      // 43: bipush 0
      // 44: aload 1
      // 45: invokevirtual net/minecraft/inventory/ContainerChest.getLowerChestInventory ()Lnet/minecraft/inventory/IInventory;
      // 48: invokeinterface net/minecraft/inventory/IInventory.getSizeInventory ()I 1
      // 4d: ldc_w -1116365756
      // 50: ldc_w -1116365747
      // 53: ixor
      // 54: idiv
      // 55: bipush 1
      // 56: isub
      // 57: iload 4
      // 59: invokestatic java/util/concurrent/ThreadLocalRandom.current ()Ljava/util/concurrent/ThreadLocalRandom;
      // 5c: ldc_w -1116365746
      // 5f: ldc_w -1116365747
      // 62: ixor
      // 63: invokevirtual java/util/concurrent/ThreadLocalRandom.nextInt (I)I
      // 66: iadd
      // 67: bipush 1
      // 68: isub
      // 69: invokestatic java/lang/Math.min (II)I
      // 6c: invokestatic java/lang/Math.max (II)I
      // 6f: istore 6
      // 71: bipush 0
      // 72: ldc_w -1116365755
      // 75: ldc_w -1116365747
      // 78: ixor
      // 79: iload 5
      // 7b: invokestatic java/util/concurrent/ThreadLocalRandom.current ()Ljava/util/concurrent/ThreadLocalRandom;
      // 7e: ldc_w -1116365746
      // 81: ldc_w -1116365747
      // 84: ixor
      // 85: invokevirtual java/util/concurrent/ThreadLocalRandom.nextInt (I)I
      // 88: iadd
      // 89: bipush 1
      // 8a: isub
      // 8b: invokestatic java/lang/Math.min (II)I
      // 8e: invokestatic java/lang/Math.max (II)I
      // 91: istore 7
      // 93: iload 6
      // 95: ldc_w -1116365756
      // 98: ldc_w -1116365747
      // 9b: ixor
      // 9c: imul
      // 9d: iload 7
      // 9f: iadd
      // a0: istore 8
      // a2: iload 8
      // a4: iload 2
      // a5: if_icmpeq c9
      // a8: iload 8
      // aa: iload 3
      // ab: ifne c8
      // ae: goto b2
      // b1: athrow
      // b2: aload 1
      // b3: invokevirtual net/minecraft/inventory/ContainerChest.getLowerChestInventory ()Lnet/minecraft/inventory/IInventory;
      // b6: invokeinterface net/minecraft/inventory/IInventory.getSizeInventory ()I 1
      // bb: if_icmpge c9
      // be: goto c2
      // c1: athrow
      // c2: iload 8
      // c4: goto c8
      // c7: athrow
      // c8: istore 2
      // c9: aload 0
      // ca: iload 2
      // cb: putfield x/oc67eb6f7f72.Ù I
      // ce: aload 0
      // cf: aload 1
      // d0: getfield net/minecraft/inventory/ContainerChest.windowId I
      // d3: iload 2
      // d4: bipush 0
      // d5: bipush 1
      // d6: invokevirtual x/oc67eb6f7f72.Ҟ (IIII)V
      // d9: aload 0
      // da: aload 0
      // db: getfield x/oc67eb6f7f72.ø Lx/ocf1568fef75;
      // de: invokevirtual x/ocf1568fef75.ϐ ()D
      // e1: d2i
      // e2: i2l
      // e3: putfield x/oc67eb6f7f72.Ĭ J
      // e6: aload 0
      // e7: getfield x/oc67eb6f7f72.ɧ Lx/ocba5f31cad4;
      // ea: invokevirtual x/ocba5f31cad4.Ÿ ()V
      // ed: return
   }

   public boolean T(int param1, int param2) {
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
      // 1c: getfield x/oc67eb6f7f72.ɒ Lx/occ2f8dff8d8;
      // 1f: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 22: ifeq 59
      // 25: goto 29
      // 28: athrow
      // 29: aload 0
      // 2a: goto 2e
      // 2d: athrow
      // 2e: getfield x/oc67eb6f7f72.Ӥ I
      // 31: iload 3
      // 32: ifne 45
      // 35: iload 1
      // 36: if_icmpne 59
      // 39: goto 3d
      // 3c: athrow
      // 3d: aload 0
      // 3e: getfield x/oc67eb6f7f72.ҭ I
      // 41: goto 45
      // 44: athrow
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

   private void Ɂ() {
      this.Ӥ = -1;
      this.ҭ = -1;
   }

   @Override
   public void onDisable() {
      this.Ɂ();
   }

   @oc66fa4f2195
   public void v(oc2f7ef6a217 var1) {
      this.ř = RandomUtils.nextInt((int)this.r.Ӂ() + 1, (int)this.ҏ.Ӂ() + (1399874877 ^ 1399874879));
   }

   static {
      String[] var10000 = new String[561458402 ^ 561458400];
      var10000[0] = "Normal";
      var10000[1] = "Advanced";
      ǿ = var10000;
      var10000 = new String[561458403 ^ 561458400];
      var10000[0] = "Linear";
      var10000[1] = "Random";
      var10000[561458402 ^ 561458400] = "Nearest";
      ϑ = var10000;
      var10000 = new String[561458386 ^ 561458400];
      var10000[0] = "mode";
      var10000[1] = "delivery";
      var10000[561458402 ^ 561458400] = "menu";
      var10000[561458403 ^ 561458400] = "selector";
      var10000[561458404 ^ 561458400] = "game";
      var10000[561458405 ^ 561458400] = "gui";
      var10000[561458406 ^ 561458400] = "server";
      var10000[561458407 ^ 561458400] = "inventory";
      var10000[561458408 ^ 561458400] = "play";
      var10000[561458409 ^ 561458400] = "teleporter";
      var10000[561458410 ^ 561458400] = "shop";
      var10000[561458411 ^ 561458400] = "melee";
      var10000[561458412 ^ 561458400] = "armor";
      var10000[561458413 ^ 561458400] = "block";
      var10000[561458414 ^ 561458400] = "castle";
      var10000[561458415 ^ 561458400] = "mini";
      var10000[561458416 ^ 561458400] = "warp";
      var10000[561458417 ^ 561458400] = "teleport";
      var10000[561458418 ^ 561458400] = "user";
      var10000[561458419 ^ 561458400] = "team";
      var10000[561458420 ^ 561458400] = "tool";
      var10000[561458421 ^ 561458400] = "sure";
      var10000[561458422 ^ 561458400] = "trade";
      var10000[561458423 ^ 561458400] = "cancel";
      var10000[561458424 ^ 561458400] = "accept";
      var10000[561458425 ^ 561458400] = "soul";
      var10000[561458426 ^ 561458400] = "book";
      var10000[561458427 ^ 561458400] = "recipe";
      var10000[561458428 ^ 561458400] = "profile";
      var10000[561458429 ^ 561458400] = "tele";
      var10000[561458430 ^ 561458400] = "port";
      var10000[561458431 ^ 561458400] = "map";
      var10000[561458368 ^ 561458400] = "kit";
      var10000[561458369 ^ 561458400] = "select";
      var10000[561458370 ^ 561458400] = "lobby";
      var10000[561458371 ^ 561458400] = "vault";
      var10000[561458372 ^ 561458400] = "lock";
      var10000[561458373 ^ 561458400] = "anticheat";
      var10000[561458374 ^ 561458400] = "travel";
      var10000[561458375 ^ 561458400] = "settings";
      var10000[561458376 ^ 561458400] = "user";
      var10000[561458377 ^ 561458400] = "preference";
      var10000[561458378 ^ 561458400] = "compass";
      var10000[561458379 ^ 561458400] = "cake";
      var10000[561458380 ^ 561458400] = "wars";
      var10000[561458381 ^ 561458400] = "buy";
      var10000[561458382 ^ 561458400] = "upgrade";
      var10000[561458383 ^ 561458400] = "ranged";
      var10000[561458384 ^ 561458400] = "potions";
      var10000[561458385 ^ 561458400] = "utility";
      Ѭ = var10000;
   }
}
