package x;

public class ocdd0f49ff2f extends oc69da1aa7f5 {
   private final oc151419fdfe ɟ;
   private final oc321b4679dd ɛ;
   private String ȕ;
   public boolean Ƌ;
   public static boolean Ǿ;
   private static final String[] a;
   private static final String[] d;
   private static final long[] e;
   private static final Integer[] f;

   public ocdd0f49ff2f(oc151419fdfe var1, String var2, int var3) {
      long var4 = 158970363670818577L ^ 158953282293481596L;
      long var6 = var4 ^ 158926158890038146L ^ 158953282293481596L;
      long var8 = var4 ^ 159014019550021398L ^ 158953282293481596L;
      long var10 = var4 ^ 159015034527785283L ^ 158953282293481596L;
      super(var2, oce4cea752dd.ԝ, var3);
      this.Ƌ = true;
      this.ɟ = var1;
      this.ȕ = var2;
      this.ʌ(this.ɛ = new oc321b4679dd("Config name", var2, "Type a new config name...", 1610130359 ^ 1610130327, this::Ұ));
      this.ʌ(
         new occ2f8dff8d8(
            "Save config",
            () -> {
               boolean var3x = oc151419fdfe.v;
               int var4x = a(-635268603 ^ -635249506, 7507949162232750682L ^ 4805441139299262089L ^ var10);

               while (true) {
                  switch (var4x) {
                     case 312345545:
                        this.Ƌ = false;
                        oc7ab2161b9f.ý(
                           a((-347270642 ^ -635249506) - (-635255712 ^ -635249506), (-347270642 ^ -635249506) - (-635254087 ^ -635249506), (int)var10)
                              + this.z$3i8m9vxwuvqj0()
                        );
                        return;
                     case 1609258973:
                        oc7ab2161b9f.ý(
                           a((-347270642 ^ -635249506) - (-635255710 ^ -635249506), (-347270642 ^ -635249506) + (-635253053 ^ -635249506), (int)var10)
                              + this.z$3i8m9vxwuvqj0()
                        );
                        this.Ƌ = true;
                        return;
                     case 1665608832:
                        int var10000;
                        label35: {
                           label34: {
                              label41: {
                                 try {
                                    var10000 = oc2cf3d80e17.Á.Ϧ(this.ɟ);
                                    if (var3x) {
                                       break label35;
                                    }

                                    if (var10000 == 0) {
                                       break label41;
                                    }
                                 } catch (ocbde1165e4e var5) {
                                    throw var5;
                                 }

                                 var10000 = a(-635255548 ^ -635249506, 6289367969108260185L ^ 4805441139299262089L ^ var10);
                                 if (var10 < 1L) {
                                    break label34;
                                 }

                                 var4x = var10000;
                                 if (!var3x) {
                                    break;
                                 }
                              }

                              var10000 = -635256470 ^ -635249506;
                           }

                           var10000 = a(var10000, 866593618653212984L ^ 4805441139299262089L ^ var10);
                        }

                        var4x = var10000;
                        break;
                     default:
                        throw null;
                  }
               }
            }
         )
      );
      this.ʌ(
         new occ2f8dff8d8(
            "Remove config",
            () -> {
               String var4x = null;
               int var10000 = oc151419fdfe.v;
               int var5 = a(-1077006050 ^ -1076990024, 5538719301548952949L ^ 125927612185987013L ^ var8);
               boolean var3x = (boolean)var10000;

               while (true) {
                  switch (var5) {
                     case -1547538514:
                        return;
                     case 2116696362:
                        var4x = this.z$3i8m9vxwuvqj0();

                        label55: {
                           label54: {
                              label53: {
                                 long var10001;
                                 label52: {
                                    label69: {
                                       try {
                                          var10000 = var3x;
                                          if (var8 <= 0L) {
                                             break label55;
                                          }

                                          if (var3x) {
                                             break label54;
                                          }

                                          var10000 = oc2cf3d80e17.Á.ŏ(var4x);
                                          if (var8 < 1L) {
                                             break label53;
                                          }

                                          if (var10000 == 0) {
                                             break label69;
                                          }
                                       } catch (ocbde1165e4e var6x) {
                                          throw var6x;
                                       }

                                       var10000 = -1076988416 ^ -1076990024;
                                       var10001 = 4871472511069063786L ^ 125927612185987013L ^ var8;
                                       if (var8 <= 1L) {
                                          break label52;
                                       }

                                       var5 = a(var10000, var10001);
                                       if (!var3x) {
                                          continue;
                                       }
                                    }

                                    var10000 = -1076993814 ^ -1076990024;
                                    var10001 = 5449222846127381641L ^ 125927612185987013L ^ var8;
                                 }

                                 var10000 = a(var10000, var10001);
                              }

                              var5 = var10000;
                           }

                           var10000 = var3x;
                        }

                        if (var8 <= 1L) {
                           break;
                        }

                        if (!var10000) {
                           continue;
                        }
                     case -1109981901:
                        oc7ab2161b9f.ý(
                           a((-567152200 ^ -1076990024) + (-1077011846 ^ -1076990024), (-567152200 ^ -1076990024) + (char)(1077006074 ^ -1076990024), (int)var8)
                              + var4x
                        );
                        var10000 = var3x;
                        var5 = a(-1077010987 ^ -1076990024, 1518078674632663473L ^ 125927612185987013L ^ var8);
                        break;
                     default:
                        throw null;
                  }

                  if (var10000) {
                     return;
                  }
               }
            }
         )
      );
   }

   @Override
   public void z$11p1yfisf2riw() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc151419fdfe.v Z
      // 03: istore 1
      // 04: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 07: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 0a: instanceof x/oc2c25634a7e
      // 0d: iload 1
      // 0e: ifne 63
      // 11: ifne 55
      // 14: goto 18
      // 17: athrow
      // 18: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1b: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 1e: instanceof x/oc1cb76bf763
      // 21: iload 1
      // 22: ifne 63
      // 25: goto 29
      // 28: athrow
      // 29: ifne 55
      // 2c: goto 30
      // 2f: athrow
      // 30: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 33: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 36: instanceof x/oc6a954e7c9f
      // 39: iload 1
      // 3a: ifne 63
      // 3d: goto 41
      // 40: athrow
      // 41: ifne 55
      // 44: goto 48
      // 47: athrow
      // 48: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 4b: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 4e: ifnonnull 88
      // 51: goto 55
      // 54: athrow
      // 55: getstatic x/oc2cf3d80e17.Á Lx/oc7d9b6bd5c4;
      // 58: aload 0
      // 59: invokevirtual x/ocdd0f49ff2f.z$3i8m9vxwuvqj0 ()Ljava/lang/String;
      // 5c: invokevirtual x/oc7d9b6bd5c4.б (Ljava/lang/String;)Z
      // 5f: goto 63
      // 62: athrow
      // 63: ifne 6d
      // 66: aload 0
      // 67: bipush 0
      // 68: putfield x/ocdd0f49ff2f.Ƌ Z
      // 6b: return
      // 6c: athrow
      // 6d: aload 0
      // 6e: getfield x/ocdd0f49ff2f.ɟ Lx/oc151419fdfe;
      // 71: putstatic x/oc2cf3d80e17.ĕ Lx/oc151419fdfe;
      // 74: aload 0
      // 75: invokevirtual x/ocdd0f49ff2f.z$3i8m9vxwuvqj0 ()Ljava/lang/String;
      // 78: ldc "&7Enabled config: &b"
      // 7a: swap
      // 7b: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 80: invokestatic x/oc7ab2161b9f.ý (Ljava/lang/String;)V
      // 83: aload 0
      // 84: bipush 1
      // 85: putfield x/ocdd0f49ff2f.Ƌ Z
      // 88: return
   }

   @Override
   public boolean z$3rzb3dil7uydr() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc151419fdfe.v Z
      // 03: istore 1
      // 04: getstatic x/oc2cf3d80e17.ĕ Lx/oc151419fdfe;
      // 07: iload 1
      // 08: ifne 18
      // 0b: ifnonnull 15
      // 0e: goto 12
      // 11: athrow
      // 12: bipush 0
      // 13: ireturn
      // 14: athrow
      // 15: getstatic x/oc2cf3d80e17.ĕ Lx/oc151419fdfe;
      // 18: invokevirtual x/oc151419fdfe.ǚ ()Lx/ocdd0f49ff2f;
      // 1b: aload 0
      // 1c: if_acmpne 24
      // 1f: bipush 1
      // 20: goto 25
      // 23: athrow
      // 24: bipush 0
      // 25: ireturn
   }

   @Override
   public String z$3i8m9vxwuvqj0() {
      return this.ȕ;
   }

   public void Ģ(String var1) {
      this.ȕ = var1;
      this.ɛ.z$1bnplyl2p7uqx(var1);
   }

   // $VF: Handled exception range with multiple entry points by splitting it
   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private void Ұ(long var1) {
      String var4 = null;
      int var10000 = oc151419fdfe.v;
      int var5 = a(688541769 ^ 688528271, 6387660070339693860L ^ 1530122206586218087L ^ var1);
      byte var3 = (byte)var10000;

      label139:
      while (true) {
         var10000 = var5;

         label133: {
            while (true) {
               label144: {
                  switch (var10000) {
                     case -2013038878:
                        break label133;
                     case -1371162239:
                        return;
                     case -764071077:
                        break label144;
                     case 675535683:
                        label122: {
                           label121: {
                              label120: {
                                 long var10001;
                                 label119: {
                                    label146: {
                                       try {
                                          this.ɛ.z$1bnplyl2p7uqx(this.ɟ.Ġ());
                                          var10000 = var3;
                                          if (var1 <= 0L) {
                                             break label122;
                                          }

                                          if (var3 != 0) {
                                             break label121;
                                          }

                                          var10000 = var4.equals(this.ɟ.Ġ());
                                          if (var1 <= 1L) {
                                             break label120;
                                          }

                                          if (var10000 != 0) {
                                             break label146;
                                          }
                                       } catch (ocbde1165e4e var8) {
                                          throw var8;
                                       }

                                       var10000 = 688540533 ^ 688528271;
                                       var10001 = 7140517293661804058L ^ 1530122206586218087L ^ var1;
                                       if (var1 < 0L) {
                                          break label119;
                                       }

                                       var5 = a(var10000, var10001);
                                       if (var3 == 0) {
                                          continue label139;
                                       }
                                    }

                                    var10000 = 688524872 ^ 688528271;
                                    var10001 = 174368581755212582L ^ 1530122206586218087L ^ var1;
                                 }

                                 var10000 = a(var10000, var10001);
                              }

                              var5 = var10000;
                           }

                           var10000 = var3;
                        }

                        if (var1 < 0L) {
                           break;
                        }

                        if (var10000 == 0) {
                           continue label139;
                        }
                     case -941450813:
                        var4 = this.z$3i8m9vxwuvqj0();

                        try {
                           var10000 = var3;
                           break;
                        } catch (ocbde1165e4e var6) {
                           throw var6;
                        }
                     case 1780826447:
                        return;
                     default:
                        throw null;
                  }

                  label97: {
                     label96: {
                        label95: {
                           long var15;
                           long var10002;
                           label94: {
                              label148: {
                                 try {
                                    if (var1 < 1L) {
                                       break label97;
                                    }

                                    if (var10000 != 0) {
                                       break label96;
                                    }

                                    var10000 = oc2cf3d80e17.Á.ǽ(this.ɟ, this.ɛ.Ê());
                                    if (var1 < 0L) {
                                       break label95;
                                    }

                                    if (var10000 == 0) {
                                       break label148;
                                    }
                                 } catch (ocbde1165e4e var7) {
                                    throw var7;
                                 }

                                 var10000 = 688533985 ^ 688528271;
                                 var15 = 5414964960603286662L ^ 1530122206586218087L;
                                 var10002 = var1;
                                 if (var1 <= 1L) {
                                    break label94;
                                 }

                                 var5 = a(var10000, var15 ^ var1);
                                 if (var3 == 0) {
                                    continue label139;
                                 }
                              }

                              var10000 = 688542180 ^ 688528271;
                              var15 = 2973520611116928132L ^ 1530122206586218087L;
                              var10002 = var1;
                           }

                           var10000 = a(var10000, var15 ^ var10002);
                        }

                        var5 = var10000;
                     }

                     var10000 = var3;
                  }

                  if (var1 < 0L) {
                     break;
                  }

                  if (var10000 == 0) {
                     continue label139;
                  }
               }

               oc7ab2161b9f.ý(
                  a((280485325 ^ 688528271) + (char)(-688538979 ^ 688528271), (-280485327 ^ 688528271) + -((char)(-688539500 ^ 688528271)), (int)var1)
                     + var4
                     + a((280485325 ^ 688528271) + (char)(-688538982 ^ 688528271), (280485325 ^ 688528271) + (char)(-688553176 ^ 688528271), (int)var1)
                     + this.ɟ.Ġ()
               );
               var10000 = var3;
               if (var1 >= 0L) {
                  var5 = a(688542180 ^ 688528271, 2973520611116928132L ^ 1530122206586218087L ^ var1);
                  break;
               }
            }

            if (var10000 == 0) {
               continue;
            }
         }

         long var16;
         label66: {
            if (oc2cf3d80e17.Á == null) {
               var10000 = 688523708 ^ 688528271;
               var16 = 1290742064217560280L ^ 1530122206586218087L ^ var1;
               if (var1 <= 1L) {
                  break label66;
               }

               var5 = a(var10000, var16);
               if (var3 == 0) {
                  continue;
               }
            }

            var10000 = 688548990 ^ 688528271;
            var16 = 5802583284848226584L ^ 1530122206586218087L ^ var1;
         }

         var5 = a(var10000, var16);
         if (var3 != 0) {
            return;
         }
      }
   }

   // $VF: Irreducible bytecode was duplicated to produce valid code
   static {
      String[] var13 = new String[-1105154252 ^ -1105154255];
      int var11 = 0;
      String var10 = "í¡wI\u001a°Ìø\u0014<\u0091îmâHÁFVøª\u001ew\f\u008cþ6\u009f×ö\u0012ÀðpE\u000bÃ\u00969ëµ÷\u0018wå8¥\u0085\u0019";
      int var12 = "í¡wI\u001a°Ìø\u0014<\u0091îmâHÁFVøª\u001ew\f\u008cþ6\u009f×ö\u0012ÀðpE\u000bÃ\u00969ëµ÷\u0018wå8¥\u0085\u0019".length();
      int var9 = -1105154247 ^ -1105154255;
      int var17 = -1;

      label70:
      while (true) {
         String var10000 = var10.substring(++var17, var17 + var9);
         int var10001 = -1;

         while (true) {
            char[] var33;
            label65: {
               char[] var21 = var10000.toCharArray();
               int var10003 = var21.length;
               int var14 = 0;
               var33 = var21;
               var10001 = var10003;
               char[] var43;
               int var10004;
               if (var10003 <= 1) {
                  var43 = var21;
                  var10004 = var14;
               } else {
                  var33 = var21;
                  var10001 = var10003;
                  if (var10003 <= var14) {
                     break label65;
                  }

                  var43 = var21;
                  var10004 = var14;
               }

               while (true) {
                  var43[var10004] = (char)(var43[var10004] ^ switch (var14 % (-1105154250 ^ -1105154255)) {
                     case 0 -> -1105154187 ^ -1105154255;
                     case 1 -> -1105154201 ^ -1105154255;
                     case 2 -> -1105154208 ^ -1105154255;
                     case 3 -> -1105154288 ^ -1105154255;
                     case 4 -> -1105154223 ^ -1105154255;
                     case 5 -> -1105154218 ^ -1105154255;
                     default -> -1105154282 ^ -1105154255;
                  });
                  var14++;
                  if (var10001 == 0) {
                     var10004 = var10001;
                     var43 = var33;
                  } else {
                     if (var10001 <= var14) {
                        break;
                     }

                     var43 = var33;
                     var10004 = var14;
                  }
               }
            }

            String var50 = new String(var33).intern();
            switch (var10001) {
               case 0:
                  var13[var11++] = var50;
                  if ((var17 += var9) >= var12) {
                     a = var13;
                     d = new String[-1105154252 ^ -1105154255];
                     long var0 = 1462580574402431086L ^ 1462588116568193274L;
                     long[] var6 = new long[-1105154241 ^ -1105154255];
                     int var3 = 0;
                     String var4 = "\b\u0082{r7»¢»|\u0004J1ë\u0017½¥ÆÞ·ÔÔ´g9\u0011H*\u008c3\tQIJt²ApÇ¬q2!{×a\u008f\u0002Ë`-]\u0006GnG«0L(`ÇÚ®\u0095\u008akÝÀ\u0095\u0001\u0018\t¿\\1ë³í¯!uGÆ\u000eDáR¾\u00811©\u0096ö.q¦";
                     int var5 = "\b\u0082{r7»¢»|\u0004J1ë\u0017½¥ÆÞ·ÔÔ´g9\u0011H*\u008c3\tQIJt²ApÇ¬q2!{×a\u008f\u0002Ë`-]\u0006GnG«0L(`ÇÚ®\u0095\u008akÝÀ\u0095\u0001\u0018\t¿\\1ë³í¯!uGÆ\u000eDáR¾\u00811©\u0096ö.q¦"
                        .length();
                     byte var2 = 0;

                     label44:
                     while (true) {
                        int var28 = var2;
                        var2 += 8;
                        byte[] var7 = var4.substring(var28, var2).getBytes("ISO-8859-1");
                        long[] var19 = var6;
                        var28 = var3++;
                        long var39 = (var7[0] & (1462588116568193029L ^ 1462588116568193274L)) << (-1105154295 ^ -1105154255)
                           | (var7[1] & (1462588116568193029L ^ 1462588116568193274L)) << (-1105154303 ^ -1105154255)
                           | (var7[-1105154253 ^ -1105154255] & (1462588116568193029L ^ 1462588116568193274L)) << (-1105154279 ^ -1105154255)
                           | (var7[-1105154254 ^ -1105154255] & (1462588116568193029L ^ 1462588116568193274L)) << (-1105154287 ^ -1105154255)
                           | (var7[-1105154251 ^ -1105154255] & (1462588116568193029L ^ 1462588116568193274L)) << (-1105154263 ^ -1105154255)
                           | (var7[-1105154252 ^ -1105154255] & (1462588116568193029L ^ 1462588116568193274L)) << (-1105154271 ^ -1105154255)
                           | (var7[-1105154249 ^ -1105154255] & (1462588116568193029L ^ 1462588116568193274L)) << (-1105154247 ^ -1105154255)
                           | var7[-1105154250 ^ -1105154255] & (1462588116568193029L ^ 1462588116568193274L);
                        byte var51 = -1;

                        while (true) {
                           long var54 = var39 ^ var0;
                           switch (var51) {
                              case 0:
                                 var19[var28] = var54;
                                 if (var2 >= var5) {
                                    e = var6;
                                    f = new Integer[-1105154241 ^ -1105154255];
                                    return;
                                 }
                                 break;
                              default:
                                 var19[var28] = var54;
                                 if (var2 < var5) {
                                    continue label44;
                                 }

                                 var4 = ",1ÌLÿ\u001e«\t½\u0081\u000f>\u0088ÕP\u000f";
                                 var5 = ",1ÌLÿ\u001e«\t½\u0081\u000f>\u0088ÕP\u000f".length();
                                 var2 = 0;
                           }

                           byte var30 = var2;
                           var2 += 8;
                           var7 = var4.substring(var30, var2).getBytes("ISO-8859-1");
                           var19 = var6;
                           var28 = var3++;
                           var39 = (var7[0] & (1462588116568193029L ^ 1462588116568193274L)) << (-1105154295 ^ -1105154255)
                              | (var7[1] & (1462588116568193029L ^ 1462588116568193274L)) << (-1105154303 ^ -1105154255)
                              | (var7[-1105154253 ^ -1105154255] & (1462588116568193029L ^ 1462588116568193274L)) << (-1105154279 ^ -1105154255)
                              | (var7[-1105154254 ^ -1105154255] & (1462588116568193029L ^ 1462588116568193274L)) << (-1105154287 ^ -1105154255)
                              | (var7[-1105154251 ^ -1105154255] & (1462588116568193029L ^ 1462588116568193274L)) << (-1105154263 ^ -1105154255)
                              | (var7[-1105154252 ^ -1105154255] & (1462588116568193029L ^ 1462588116568193274L)) << (-1105154271 ^ -1105154255)
                              | (var7[-1105154249 ^ -1105154255] & (1462588116568193029L ^ 1462588116568193274L)) << (-1105154247 ^ -1105154255)
                              | var7[-1105154250 ^ -1105154255] & (1462588116568193029L ^ 1462588116568193274L);
                           var51 = 0;
                        }
                     }
                  }

                  var9 = var10.charAt(var17);
                  break;
               default:
                  var13[var11++] = var50;
                  if ((var17 += var9) < var12) {
                     var9 = var10.charAt(var17);
                     continue label70;
                  }

                  var10 = "ü\u0019ö|âd¹\f!±D7ª)7ZA\u000b9d\u001b&Ê¹Ü\u009aùY\u0012p\u0007®pg`/\u0096¤\u0093\u0095P}hÐªZDN";
                  var12 = "ü\u0019ö|âd¹\f!±D7ª)7ZA\u000b9d\u001b&Ê¹Ü\u009aùY\u0012p\u0007®pg`/\u0096¤\u0093\u0095P}hÐªZDN".length();
                  var9 = -1105154267 ^ -1105154255;
                  var17 = -1;
            }

            var10000 = var10.substring(++var17, var17 + var9);
            var10001 = 0;
         }
      }
   }

   private static String a(int var0, int var1, int var2) {
      int var3 = (var0 ^ var2 ^ 1127008178 ^ -1127007114) & (-1126972535 ^ -1127007114);
      if (d[var3] == null) {
         char[] var4 = a[var3].toCharArray();

         int var5 = switch (var4[0] & (-1127007095 ^ -1127007114)) {
            case 0 -> -1127007112 ^ -1127007114;
            case 1 -> -1127007016 ^ -1127007114;
            case 2 -> -1127007142 ^ -1127007114;
            case 3 -> -1127007067 ^ -1127007114;
            case 4 -> -1127007182 ^ -1127007114;
            case 5 -> -1127007081 ^ -1127007114;
            case 6 -> -1127007174 ^ -1127007114;
            case 7 -> -1127007023 ^ -1127007114;
            case 8 -> -1127007176 ^ -1127007114;
            case 9 -> -1127007201 ^ -1127007114;
            case 10 -> -1127006990 ^ -1127007114;
            case 11 -> -1127007226 ^ -1127007114;
            case 12 -> -1127007013 ^ -1127007114;
            case 13 -> -1127007171 ^ -1127007114;
            case 14 -> -1127007059 ^ -1127007114;
            case 15 -> -1127007218 ^ -1127007114;
            case 16 -> -1127007198 ^ -1127007114;
            case 17 -> -1127007183 ^ -1127007114;
            case 18 -> -1127007088 ^ -1127007114;
            case 19 -> -1127007140 ^ -1127007114;
            case 20 -> -1127007065 ^ -1127007114;
            case 21 -> -1127007197 ^ -1127007114;
            case 22 -> -1127007210 ^ -1127007114;
            case 23 -> -1127007107 ^ -1127007114;
            case 24 -> -1127007228 ^ -1127007114;
            case 25 -> -1127007111 ^ -1127007114;
            case 26 -> -1127007026 ^ -1127007114;
            case 27 -> -1127007083 ^ -1127007114;
            case 28 -> -1127007221 ^ -1127007114;
            case 29 -> -1127007075 ^ -1127007114;
            case 30 -> -1127007215 ^ -1127007114;
            case 31 -> -1127007202 ^ -1127007114;
            case 32 -> -1127007055 ^ -1127007114;
            case 33 -> -1127007160 ^ -1127007114;
            case 34 -> -1127007169 ^ -1127007114;
            case 35 -> -1127007156 ^ -1127007114;
            case 36 -> -1127007152 ^ -1127007114;
            case 37 -> -1127007014 ^ -1127007114;
            case 38 -> -1127007122 ^ -1127007114;
            case 39 -> -1127007124 ^ -1127007114;
            case 40 -> -1127007162 ^ -1127007114;
            case 41 -> -1127007123 ^ -1127007114;
            case 42 -> -1127007165 ^ -1127007114;
            case 43 -> -1127007185 ^ -1127007114;
            case 44 -> -1127007163 ^ -1127007114;
            case 45 -> -1127007180 ^ -1127007114;
            case 46 -> -1127007040 ^ -1127007114;
            case 47 -> -1127007117 ^ -1127007114;
            case 48 -> -1127007192 ^ -1127007114;
            case 49 -> -1127006995 ^ -1127007114;
            case 50 -> -1127006997 ^ -1127007114;
            case 51 -> -1127007021 ^ -1127007114;
            case 52 -> -1127007060 ^ -1127007114;
            case 53 -> -1127007194 ^ -1127007114;
            case 54 -> -1127007100 ^ -1127007114;
            case 55 -> -1127007213 ^ -1127007114;
            case 56 -> -1127007089 ^ -1127007114;
            case 57 -> -1127007002 ^ -1127007114;
            case 58 -> -1127007137 ^ -1127007114;
            case 59 -> -1127007167 ^ -1127007114;
            case 60 -> -1127006977 ^ -1127007114;
            case 61 -> -1127007121 ^ -1127007114;
            case 62 -> -1127007024 ^ -1127007114;
            case 63 -> -1127007175 ^ -1127007114;
            case 64 -> -1127007193 ^ -1127007114;
            case 65 -> -1127007022 ^ -1127007114;
            case 66 -> 0;
            case 67 -> -1127007066 ^ -1127007114;
            case 68 -> -1127007030 ^ -1127007114;
            case 69 -> -1127006978 ^ -1127007114;
            case 70 -> -1127007046 ^ -1127007114;
            case 71 -> -1127007136 ^ -1127007114;
            case 72 -> -1127007010 ^ -1127007114;
            case 73 -> -1127007037 ^ -1127007114;
            case 74 -> -1127007173 ^ -1127007114;
            case 75 -> -1127007204 ^ -1127007114;
            case 76 -> -1127007130 ^ -1127007114;
            case 77 -> -1127007007 ^ -1127007114;
            case 78 -> -1127007128 ^ -1127007114;
            case 79 -> -1127007120 ^ -1127007114;
            case 80 -> -1127007094 ^ -1127007114;
            case 81 -> -1127007106 ^ -1127007114;
            case 82 -> -1127007039 ^ -1127007114;
            case 83 -> -1127006991 ^ -1127007114;
            case 84 -> -1127006993 ^ -1127007114;
            case 85 -> -1127007216 ^ -1127007114;
            case 86 -> -1127007071 ^ -1127007114;
            case 87 -> -1127007058 ^ -1127007114;
            case 88 -> -1127006996 ^ -1127007114;
            case 89 -> -1127007178 ^ -1127007114;
            case 90 -> -1127007217 ^ -1127007114;
            case 91 -> -1127006981 ^ -1127007114;
            case 92 -> -1127007116 ^ -1127007114;
            case 93 -> -1127007090 ^ -1127007114;
            case 94 -> -1127007158 ^ -1127007114;
            case 95 -> -1127006984 ^ -1127007114;
            case 96 -> -1127006983 ^ -1127007114;
            case 97 -> -1127007172 ^ -1127007114;
            case 98 -> -1127007103 ^ -1127007114;
            case 99 -> -1127007008 ^ -1127007114;
            case 100 -> -1127007049 ^ -1127007114;
            case 101 -> -1127007191 ^ -1127007114;
            case 102 -> -1127007220 ^ -1127007114;
            case 103 -> -1127007214 ^ -1127007114;
            case 104 -> -1127007063 ^ -1127007114;
            case 105 -> -1127007168 ^ -1127007114;
            case 106 -> -1127007225 ^ -1127007114;
            case 107 -> -1127007146 ^ -1127007114;
            case 108 -> -1127006989 ^ -1127007114;
            case 109 -> -1127007150 ^ -1127007114;
            case 110 -> -1127007206 ^ -1127007114;
            case 111 -> -1127006992 ^ -1127007114;
            case 112 -> -1127007153 ^ -1127007114;
            case 113 -> -1127007144 ^ -1127007114;
            case 114 -> -1127007025 ^ -1127007114;
            case 115 -> -1127007019 ^ -1127007114;
            case 116 -> -1127007115 ^ -1127007114;
            case 117 -> -1127007110 ^ -1127007114;
            case 118 -> -1127007209 ^ -1127007114;
            case 119 -> -1127007231 ^ -1127007114;
            case 120 -> -1127007087 ^ -1127007114;
            case 121 -> -1127006979 ^ -1127007114;
            case 122 -> -1127007041 ^ -1127007114;
            case 123 -> -1127007126 ^ -1127007114;
            case 124 -> -1127007042 ^ -1127007114;
            case 125 -> -1127007091 ^ -1127007114;
            case 126 -> -1127007105 ^ -1127007114;
            case 127 -> -1127007230 ^ -1127007114;
            case 128 -> -1127007061 ^ -1127007114;
            case 129 -> -1127007118 ^ -1127007114;
            case 130 -> -1127007139 ^ -1127007114;
            case 131 -> -1127007036 ^ -1127007114;
            case 132 -> -1127007125 ^ -1127007114;
            case 133 -> -1127007190 ^ -1127007114;
            case 134 -> -1127007129 ^ -1127007114;
            case 135 -> -1127007056 ^ -1127007114;
            case 136 -> -1127007164 ^ -1127007114;
            case 137 -> -1127007020 ^ -1127007114;
            case 138 -> -1127007208 ^ -1127007114;
            case 139 -> -1127007047 ^ -1127007114;
            case 140 -> -1127006985 ^ -1127007114;
            case 141 -> -1127007009 ^ -1127007114;
            case 142 -> -1127007003 ^ -1127007114;
            case 143 -> 1;
            case 144 -> -1127007093 ^ -1127007114;
            case 145 -> -1127007189 ^ -1127007114;
            case 146 -> -1127006987 ^ -1127007114;
            case 147 -> -1127006980 ^ -1127007114;
            case 148 -> -1127007159 ^ -1127007114;
            case 149 -> -1127007028 ^ -1127007114;
            case 150 -> -1127007079 ^ -1127007114;
            case 151 -> -1127007011 ^ -1127007114;
            case 152 -> -1127007147 ^ -1127007114;
            case 153 -> -1127007177 ^ -1127007114;
            case 154 -> -1127007134 ^ -1127007114;
            case 155 -> -1127007155 ^ -1127007114;
            case 156 -> -1127007102 ^ -1127007114;
            case 157 -> -1127007053 ^ -1127007114;
            case 158 -> -1127007195 ^ -1127007114;
            case 159 -> -1127007127 ^ -1127007114;
            case 160 -> -1127007224 ^ -1127007114;
            case 161 -> -1127007101 ^ -1127007114;
            case 162 -> -1127007015 ^ -1127007114;
            case 163 -> -1127007043 ^ -1127007114;
            case 164 -> -1127007018 ^ -1127007114;
            case 165 -> -1127006999 ^ -1127007114;
            case 166 -> -1127007222 ^ -1127007114;
            case 167 -> -1127007096 ^ -1127007114;
            case 168 -> -1127006994 ^ -1127007114;
            case 169 -> -1127007097 ^ -1127007114;
            case 170 -> -1127007196 ^ -1127007114;
            case 171 -> -1127007131 ^ -1127007114;
            case 172 -> -1127007045 ^ -1127007114;
            case 173 -> -1127007187 ^ -1127007114;
            case 174 -> -1127007186 ^ -1127007114;
            case 175 -> -1127007035 ^ -1127007114;
            case 176 -> -1127007005 ^ -1127007114;
            case 177 -> -1127007108 ^ -1127007114;
            case 178 -> -1127007181 ^ -1127007114;
            case 179 -> -1127007141 ^ -1127007114;
            case 180 -> -1127007184 ^ -1127007114;
            case 181 -> -1127007062 ^ -1127007114;
            case 182 -> -1127007001 ^ -1127007114;
            case 183 -> -1127007070 ^ -1127007114;
            case 184 -> -1127007004 ^ -1127007114;
            case 185 -> -1127007132 ^ -1127007114;
            case 186 -> -1127007054 ^ -1127007114;
            case 187 -> -1127007086 ^ -1127007114;
            case 188 -> -1127007029 ^ -1127007114;
            case 189 -> -1127007148 ^ -1127007114;
            case 190 -> -1127007188 ^ -1127007114;
            case 191 -> -1127007170 ^ -1127007114;
            case 192 -> -1127007219 ^ -1127007114;
            case 193 -> -1127007038 ^ -1127007114;
            case 194 -> -1127007229 ^ -1127007114;
            case 195 -> -1127007104 ^ -1127007114;
            case 196 -> -1127006982 ^ -1127007114;
            case 197 -> -1127007064 ^ -1127007114;
            case 198 -> -1127007085 ^ -1127007114;
            case 199 -> -1127007161 ^ -1127007114;
            case 200 -> -1127007199 ^ -1127007114;
            case 201 -> -1127007052 ^ -1127007114;
            case 202 -> -1127007207 ^ -1127007114;
            case 203 -> -1127007077 ^ -1127007114;
            case 204 -> -1127007223 ^ -1127007114;
            case 205 -> -1127006988 ^ -1127007114;
            case 206 -> -1127007095 ^ -1127007114;
            case 207 -> -1127006986 ^ -1127007114;
            case 208 -> -1127007073 ^ -1127007114;
            case 209 -> -1127007000 ^ -1127007114;
            case 210 -> -1127007203 ^ -1127007114;
            case 211 -> -1127007133 ^ -1127007114;
            case 212 -> -1127007151 ^ -1127007114;
            case 213 -> -1127007149 ^ -1127007114;
            case 214 -> -1127007212 ^ -1127007114;
            case 215 -> -1127007138 ^ -1127007114;
            case 216 -> -1127007069 ^ -1127007114;
            case 217 -> -1127007135 ^ -1127007114;
            case 218 -> -1127007143 ^ -1127007114;
            case 219 -> -1127007027 ^ -1127007114;
            case 220 -> -1127007034 ^ -1127007114;
            case 221 -> -1127007072 ^ -1127007114;
            case 222 -> -1127007232 ^ -1127007114;
            case 223 -> -1127007109 ^ -1127007114;
            case 224 -> -1127007084 ^ -1127007114;
            case 225 -> -1127007145 ^ -1127007114;
            case 226 -> -1127007157 ^ -1127007114;
            case 227 -> -1127007099 ^ -1127007114;
            case 228 -> -1127007031 ^ -1127007114;
            case 229 -> -1127007050 ^ -1127007114;
            case 230 -> -1127007076 ^ -1127007114;
            case 231 -> -1127007006 ^ -1127007114;
            case 232 -> -1127007154 ^ -1127007114;
            case 233 -> -1127006998 ^ -1127007114;
            case 234 -> -1127007179 ^ -1127007114;
            case 235 -> -1127007012 ^ -1127007114;
            case 236 -> -1127007092 ^ -1127007114;
            case 237 -> -1127007017 ^ -1127007114;
            case 238 -> -1127007057 ^ -1127007114;
            case 239 -> -1127007166 ^ -1127007114;
            case 240 -> -1127007200 ^ -1127007114;
            case 241 -> -1127007074 ^ -1127007114;
            case 242 -> -1127007078 ^ -1127007114;
            case 243 -> -1127007205 ^ -1127007114;
            case 244 -> -1127007227 ^ -1127007114;
            case 245 -> -1127007032 ^ -1127007114;
            case 246 -> -1127007033 ^ -1127007114;
            case 247 -> -1127007068 ^ -1127007114;
            case 248 -> -1127007080 ^ -1127007114;
            case 249 -> -1127007082 ^ -1127007114;
            case 250 -> -1127007051 ^ -1127007114;
            case 251 -> -1127007098 ^ -1127007114;
            case 252 -> -1127007048 ^ -1127007114;
            case 253 -> -1127007211 ^ -1127007114;
            case 254 -> -1127007119 ^ -1127007114;
            default -> -1127007044 ^ -1127007114;
         };
         int var10;
         int var6 = ((var10 = var1 ^ var2) & (-1127007095 ^ -1127007114)) - var5;
         if (var6 < 0) {
            var6 += 256;
         }

         int var7 = ((var10 & (-1126972535 ^ -1127007114)) >>> (-1127007106 ^ -1127007114)) - var5;
         if (var7 < 0) {
            var7 += 256;
         }

         for (int var8 = 0; var8 < var4.length; var8++) {
            int var9 = var8 % (-1127007116 ^ -1127007114);
            char var10002 = var4[var8];
            if (var9 == 0) {
               var4[var8] = (char)(var10002 ^ var6);
               var6 = ((var6 >>> (-1127007115 ^ -1127007114) | var6 << (-1127007117 ^ -1127007114)) ^ var4[var8]) & (-1127007095 ^ -1127007114);
            } else {
               var4[var8] = (char)(var10002 ^ var7);
               var7 = ((var7 >>> (-1127007115 ^ -1127007114) | var7 << (-1127007117 ^ -1127007114)) ^ var4[var8]) & (-1127007095 ^ -1127007114);
            }
         }

         d[var3] = new String(var4).intern();
      }

      return d[var3];
   }

   private static int a(int var0, long var1) {
      int var3 = var0 ^ (int)(var1 & (7700462935987514793L ^ 7700462935987491414L)) ^ -2119928051 ^ -2119939312;
      if (f[var3] == null) {
         f[var3] = (int)(e[var3] ^ var1);
      }

      return f[var3];
   }
}
