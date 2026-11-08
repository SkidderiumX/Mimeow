package x;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class oca4134a3ce8 extends oc69da1aa7f5 {
   private final occ2f8dff8d8 Ř;
   private final oc10354c7bb8 Ѷ;
   private ItemStack Α;
   private int Ù = -1;
   private int ͳ = -1;
   private long ǜ;
   public static int Ě;

   public oca4134a3ce8() {
      super("AutoSwap", oce4cea752dd.з);
      this.ą("Switches to another block stack when yours runs out.");
      this.ʌ(this.Ř = new occ2f8dff8d8("Use block whitelist", false));
      String[] var10005 = new String[997480161 ^ 997480162];
      var10005[0] = "Blocks";
      var10005[1] = "Blocks.Block whitelist";
      var10005[997480160 ^ 997480162] = "Blocks.Whitelisted blocks";
      this.ʌ(this.Ѷ = new oc10354c7bb8("Whitelisted blocks", var10005));
      this.Ѷ.Ӏ = false;
      this.ɮ = true;
   }

   @Override
   public void z$2u87utkr1isxg() {
      this.Ѷ.ȉ(this.Ř.ǭ(), this);
   }

   @Override
   public void onEnable() {
      this.Ѭ();
   }

   @Override
   public void onDisable() {
      this.Ѭ();
   }

   @oc66fa4f2195
   public void i(oc9d4393f3ce param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 2
      // 04: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 07: iload 2
      // 08: ifne 25
      // 0b: ifeq 28
      // 0e: goto 12
      // 11: athrow
      // 12: aload 1
      // 13: iload 2
      // 14: ifne 2a
      // 17: goto 1b
      // 1a: athrow
      // 1b: invokevirtual x/oc9d4393f3ce.ɟ ()Lnet/minecraft/network/Packet;
      // 1e: instanceof net/minecraft/network/play/client/C08PacketPlayerBlockPlacement
      // 21: goto 25
      // 24: athrow
      // 25: ifne 29
      // 28: return
      // 29: aload 1
      // 2a: invokevirtual x/oc9d4393f3ce.ɟ ()Lnet/minecraft/network/Packet;
      // 2d: checkcast net/minecraft/network/play/client/C08PacketPlayerBlockPlacement
      // 30: astore 3
      // 31: aload 3
      // 32: iload 2
      // 33: ifne 48
      // 36: invokevirtual net/minecraft/network/play/client/C08PacketPlayerBlockPlacement.getPlacedBlockDirection ()I
      // 39: ldc -1968291602
      // 3b: ldc -1968291823
      // 3d: ixor
      // 3e: if_icmpne 47
      // 41: goto 45
      // 44: athrow
      // 45: return
      // 46: athrow
      // 47: aload 3
      // 48: invokevirtual net/minecraft/network/play/client/C08PacketPlayerBlockPlacement.getStack ()Lnet/minecraft/item/ItemStack;
      // 4b: astore 4
      // 4d: aload 4
      // 4f: iload 2
      // 50: ifne 5c
      // 53: ifnull 6d
      // 56: goto 5a
      // 59: athrow
      // 5a: aload 4
      // 5c: iload 2
      // 5d: ifne 7c
      // 60: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 63: instanceof net/minecraft/item/ItemBlock
      // 66: ifne 6f
      // 69: goto 6d
      // 6c: athrow
      // 6d: return
      // 6e: athrow
      // 6f: aload 0
      // 70: aload 4
      // 72: invokevirtual net/minecraft/item/ItemStack.copy ()Lnet/minecraft/item/ItemStack;
      // 75: putfield x/oca4134a3ce8.Α Lnet/minecraft/item/ItemStack;
      // 78: aload 0
      // 79: getfield x/oca4134a3ce8.Α Lnet/minecraft/item/ItemStack;
      // 7c: bipush 1
      // 7d: putfield net/minecraft/item/ItemStack.stackSize I
      // 80: aload 0
      // 81: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 84: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 87: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 8a: getfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 8d: putfield x/oca4134a3ce8.Ù I
      // 90: return
   }

   @oc66fa4f2195
   public void Ԉ(oca27090789a param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: istore 2
      // 004: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 007: iload 2
      // 008: ifne 026
      // 00b: ifne 018
      // 00e: goto 012
      // 011: athrow
      // 012: aload 0
      // 013: invokevirtual x/oca4134a3ce8.Ѭ ()V
      // 016: return
      // 017: athrow
      // 018: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 01b: iload 2
      // 01c: ifne 02c
      // 01f: getfield net/minecraft/client/Minecraft.inGameHasFocus Z
      // 022: goto 026
      // 025: athrow
      // 026: ifeq 04d
      // 029: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 02c: iload 2
      // 02d: ifne 041
      // 030: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 033: ifnonnull 04d
      // 036: goto 03a
      // 039: athrow
      // 03a: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 03d: goto 041
      // 040: athrow
      // 041: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 044: getfield net/minecraft/client/settings/GameSettings.keyBindUseItem Lnet/minecraft/client/settings/KeyBinding;
      // 047: invokestatic x/oc7ab2161b9f.ն (Lnet/minecraft/client/settings/KeyBinding;)Z
      // 04a: ifne 04f
      // 04d: return
      // 04e: athrow
      // 04f: aload 0
      // 050: iload 2
      // 051: ifne 063
      // 054: getfield x/oca4134a3ce8.Α Lnet/minecraft/item/ItemStack;
      // 057: ifnull 091
      // 05a: goto 05e
      // 05d: athrow
      // 05e: aload 0
      // 05f: goto 063
      // 062: athrow
      // 063: getfield x/oca4134a3ce8.Ù I
      // 066: iload 2
      // 067: ifne 08a
      // 06a: bipush -1
      // 06b: if_icmpeq 091
      // 06e: goto 072
      // 071: athrow
      // 072: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 075: iload 2
      // 076: ifne 096
      // 079: goto 07d
      // 07c: athrow
      // 07d: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 080: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 083: getfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 086: goto 08a
      // 089: athrow
      // 08a: aload 0
      // 08b: getfield x/oca4134a3ce8.Ù I
      // 08e: if_icmpeq 093
      // 091: return
      // 092: athrow
      // 093: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 096: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 099: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getHeldItem ()Lnet/minecraft/item/ItemStack;
      // 09c: astore 3
      // 09d: aload 3
      // 09e: iload 2
      // 09f: ifne 0aa
      // 0a2: ifnull 0b9
      // 0a5: goto 0a9
      // 0a8: athrow
      // 0a9: aload 3
      // 0aa: getfield net/minecraft/item/ItemStack.stackSize I
      // 0ad: iload 2
      // 0ae: ifne 0c1
      // 0b1: ifle 0b9
      // 0b4: goto 0b8
      // 0b7: athrow
      // 0b8: return
      // 0b9: aload 0
      // 0ba: aload 0
      // 0bb: getfield x/oca4134a3ce8.Α Lnet/minecraft/item/ItemStack;
      // 0be: invokevirtual x/oca4134a3ce8.Ϙ (Lnet/minecraft/item/ItemStack;)Z
      // 0c1: ifne 0c5
      // 0c4: return
      // 0c5: invokestatic java/lang/System.currentTimeMillis ()J
      // 0c8: lstore 4
      // 0ca: ldc 1448034226
      // 0cc: ldc 1448034234
      // 0ce: ixor
      // 0cf: istore 6
      // 0d1: iload 6
      // 0d3: iflt 153
      // 0d6: iload 6
      // 0d8: iload 2
      // 0d9: ifne 0fa
      // 0dc: aload 0
      // 0dd: getfield x/oca4134a3ce8.ͳ I
      // 0e0: if_icmpne 105
      // 0e3: goto 0e7
      // 0e6: athrow
      // 0e7: lload 4
      // 0e9: aload 0
      // 0ea: getfield x/oca4134a3ce8.ǜ J
      // 0ed: lsub
      // 0ee: ldc2_w -7970630397164800631
      // 0f1: ldc2_w -7970630397164800859
      // 0f4: lxor
      // 0f5: lcmp
      // 0f6: goto 0fa
      // 0f9: athrow
      // 0fa: ifge 105
      // 0fd: iload 2
      // 0fe: ifeq 148
      // 101: goto 105
      // 104: athrow
      // 105: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 108: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 10b: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 10e: iload 6
      // 110: invokevirtual net/minecraft/entity/player/InventoryPlayer.getStackInSlot (I)Lnet/minecraft/item/ItemStack;
      // 113: astore 7
      // 115: iload 2
      // 116: ifne 144
      // 119: aload 0
      // 11a: aload 7
      // 11c: invokevirtual x/oca4134a3ce8.Լ (Lnet/minecraft/item/ItemStack;)Z
      // 11f: ifne 12e
      // 122: goto 126
      // 125: athrow
      // 126: iload 2
      // 127: ifeq 148
      // 12a: goto 12e
      // 12d: athrow
      // 12e: aload 0
      // 12f: iload 6
      // 131: invokevirtual x/oca4134a3ce8.ƶ (I)V
      // 134: aload 0
      // 135: iload 6
      // 137: putfield x/oca4134a3ce8.ͳ I
      // 13a: aload 0
      // 13b: lload 4
      // 13d: putfield x/oca4134a3ce8.ǜ J
      // 140: goto 144
      // 143: athrow
      // 144: iload 2
      // 145: ifeq 153
      // 148: iinc 6 -1
      // 14b: iload 2
      // 14c: ifeq 0d1
      // 14f: goto 153
      // 152: athrow
      // 153: return
   }

   private boolean Ϙ(ItemStack var1) {
      Object var3 = null;
      Object var4 = null;
      String var5 = null;
      int var2 = oc84f20a0bc5.ė;
      int var6 = 0;
      String var7 = null;
      int var8 = -886359432 ^ -42920371;

      while (true) {
         label172:
         while (true) {
            label166:
            while (true) {
               label164:
               while (true) {
                  label162:
                  while (true) {
                     label160:
                     while (true) {
                        switch (var8) {
                           case -2085813871:
                              break label162;
                           case -1625002128:
                              return false;
                           case -978483107:
                              break label164;
                           case -386526930:
                              return true;
                           case -269541315:
                              int var15;
                              label109: {
                                 label108: {
                                    try {
                                       var15 = var1.getItem() instanceof ItemBlock;
                                       if (var2 != 0) {
                                          break label109;
                                       }

                                       if (var15 != 0) {
                                          break label108;
                                       }
                                    } catch (ocbde1165e4e var10) {
                                       throw var10;
                                    }

                                    var8 = 1649768765 ^ -42920371;
                                    if (var2 == 0) {
                                       continue;
                                    }
                                 }

                                 var15 = -2037772302 ^ -42920371;
                              }

                              var8 = var15;
                              if (var2 != 0) {
                                 return true;
                              }
                              continue;
                           case -116657756:
                              break label160;
                           case 456697693:
                              int var14;
                              label141: {
                                 label140: {
                                    try {
                                       var14 = this.Ѷ.Ѣ(var7);
                                       if (var2 != 0) {
                                          break label141;
                                       }

                                       if (var14 != 0) {
                                          break label140;
                                       }
                                    } catch (ocbde1165e4e var12) {
                                       throw var12;
                                    }

                                    var8 = -1953627316 ^ -42920371;
                                    if (var2 == 0) {
                                       continue;
                                    }
                                 }

                                 var14 = 361170787 ^ -42920371;
                              }

                              var8 = var14;
                              if (var2 == 0) {
                                 continue;
                              }
                           case 1862804039:
                              var7 = var5 + ":" + var6;
                              var8 = -431378160 ^ -42920371;
                              if (var2 == 0) {
                                 continue;
                              }
                              break;
                           case 495540235:
                              return false;
                           case 762460658:
                              return false;
                           case 821534283:
                              return true;
                           case 911879221:
                              break label166;
                           case 921362408:
                              var7 = var5;
                              var8 = -431378160 ^ -42920371;
                              if (var2 != 0) {
                                 break label172;
                              }
                              continue;
                           case 1996428545:
                              break label172;
                           case 2080053695:
                              break;
                           default:
                              throw null;
                        }

                        var3 = ((ItemBlock)var1.getItem()).getBlock();
                        if (var2 == 0) {
                           var4 = Block.blockRegistry.getNameForObject(var3);
                           if (var3 != null) {
                              var8 = 953982480 ^ -42920371;
                              if (var2 == 0) {
                                 continue;
                              }
                           }

                           var8 = -805097537 ^ -42920371;
                        }

                        if (var2 != 0) {
                           break;
                        }
                     }

                     var5 = var4.toString();
                     if (var2 == 0) {
                        var6 = var1.getMetadata();
                        if (var6 != 0) {
                           var8 = -1837550582 ^ -42920371;
                           if (var2 == 0) {
                              continue;
                           }
                        }

                        var8 = -878982747 ^ -42920371;
                     }

                     if (var2 != 0) {
                        break;
                     }
                  }

                  if (var1 != null) {
                     var8 = 312358512 ^ -42920371;
                     if (var2 == 0) {
                        continue;
                     }
                  }

                  var8 = 1649768765 ^ -42920371;
                  if (var2 != 0) {
                     break;
                  }
               }

               if (var4 == null) {
                  var8 = -805097537 ^ -42920371;
                  if (var2 == 0) {
                     continue;
                  }
               }

               var8 = 75163625 ^ -42920371;
               if (var2 != 0) {
                  break;
               }
            }

            int var16;
            label118: {
               label117: {
                  try {
                     var16 = this.Ř.ǭ();
                     if (var2 != 0) {
                        break label118;
                     }

                     if (var16 != 0) {
                        break label117;
                     }
                  } catch (ocbde1165e4e var11) {
                     throw var11;
                  }

                  var8 = -846821370 ^ -42920371;
                  if (var2 == 0) {
                     continue;
                  }
               }

               var16 = 2128353244 ^ -42920371;
            }

            var8 = var16;
            if (var2 != 0) {
               return false;
            }
         }

         int var10000;
         label100: {
            label99: {
               try {
                  var10000 = this.Ѷ.Ѣ(var5);
                  if (var2 != 0) {
                     break label100;
                  }

                  if (var10000 == 0) {
                     break label99;
                  }
               } catch (ocbde1165e4e var9) {
                  throw var9;
               }

               var8 = 361170787 ^ -42920371;
               if (var2 == 0) {
                  continue;
               }
            }

            var10000 = -520597946 ^ -42920371;
         }

         var8 = var10000;
      }
   }

   private boolean Լ(ItemStack var1) {
      int var2 = oc84f20a0bc5.ė;
      int var3 = -1705170336 ^ -1300661481;

      while (true) {
         switch (var3) {
            case -1862659569:
               return false;
            case -1190289097:
               int var6;
               label59: {
                  label58: {
                     try {
                        var6 = var1.getHasSubtypes();
                        if (var2 != 0) {
                           break label59;
                        }

                        if (var6 == 0) {
                           break label58;
                        }
                     } catch (ocbde1165e4e var4) {
                        throw var4;
                     }

                     var3 = 1532554675 ^ -1300661481;
                     if (var2 == 0) {
                        break;
                     }
                  }

                  var6 = 1475156540 ^ -1300661481;
               }

               var3 = var6;
               if (var2 == 0) {
                  break;
               }

               return ItemStack.areItemStackTagsEqual(var1, this.Α);
            case -443260629:
               return ItemStack.areItemStackTagsEqual(var1, this.Α);
            case -414410554:
               return false;
            case -187923672:
               if (var1.getItem() != this.Α.getItem()) {
                  var3 = 1429595089 ^ -1300661481;
                  if (var2 == 0) {
                     break;
                  }
               }

               var3 = 192207392 ^ -1300661481;
               break;
            case -64658948:
               if (var1 != null) {
                  var3 = 1186330687 ^ -1300661481;
                  if (var2 == 0) {
                     break;
                  }
               }

               var3 = 1429595089 ^ -1300661481;
               if (var2 == 0) {
                  break;
               }
            case -383674716:
               int var10000;
               label73: {
                  label72: {
                     try {
                        var10000 = var1.getMetadata();
                        if (var2 != 0) {
                           break label73;
                        }

                        if (var10000 == this.Α.getMetadata()) {
                           break label72;
                        }
                     } catch (ocbde1165e4e var5) {
                        throw var5;
                     }

                     var3 = 579037464 ^ -1300661481;
                     if (var2 == 0) {
                        break;
                     }
                  }

                  var10000 = 1475156540 ^ -1300661481;
               }

               var3 = var10000;
               if (var2 == 0) {
                  break;
               }
            case 673468791:
               if (this.Α != null) {
                  var3 = 1314659051 ^ -1300661481;
                  if (var2 == 0) {
                     break;
                  }
               }

               var3 = 1429595089 ^ -1300661481;
               if (var2 == 0) {
                  break;
               }

               return false;
            default:
               throw null;
         }
      }
   }

   private void ƶ(int param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 2
      // 04: iload 1
      // 05: iload 2
      // 06: ifne 16
      // 09: bipush -1
      // 0a: if_icmpeq 25
      // 0d: goto 11
      // 10: athrow
      // 11: iload 1
      // 12: goto 16
      // 15: athrow
      // 16: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 19: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1c: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 1f: getfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 22: if_icmpne 27
      // 25: return
      // 26: athrow
      // 27: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 2a: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 2d: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 30: iload 1
      // 31: putfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 34: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 37: getfield net/minecraft/client/Minecraft.playerController Lnet/minecraft/client/multiplayer/PlayerControllerMP;
      // 3a: invokeinterface x/oc51cbcffcfe.callSyncCurrentPlayItem ()V 1
      // 3f: return
   }

   private void Ѭ() {
      this.Α = null;
      this.Ù = -1;
      this.ͳ = -1;
      this.ǜ = 0L;
   }
}
