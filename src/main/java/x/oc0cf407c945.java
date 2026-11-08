package x;

import net.minecraft.entity.EntityLivingBase;

public class oc0cf407c945 extends oc49fb68d420 {
   private static final int Z = 0;
   private static final int ς = 1;
   private final oca9cc61aada ϋ;
   private boolean Ò;
   public static int Զ;

   public oc0cf407c945(oc72ee500c19 var1) {
      super("Intave", var1);
      String[] var10006 = new String[-184517292 ^ -184517290];
      var10006[0] = "Latest";
      var10006[1] = "13";
      this.Ⱦ(this.ϋ = new oca9cc61aada("Intave mode", 0, var10006));
   }

   public String z$1vjyi4gk9v6c9() {
      return "Intave " + this.ϋ.Ҿ()[(int)this.ϋ.Ӂ()];
   }

   public void z$fe4mfecqaowg() {
      this.ϋ.ȉ(super.ό.ӂ("Intave"), super.ό);
   }

   public void z$24alrqiqeci48() {
      this.Ò = false;
   }

   public void z$1bjr376lv3ef3() {
      this.Ò = false;
   }

   public void z$3n62k5eunm8co(occ48acb5d22 var1) {
      double var3 = 0.0;
      int var5 = -887550691 ^ -777065722;
      boolean var2 = false;

      while (true) {
         label265:
         do {
            label261:
            while (true) {
               label259:
               while (true) {
                  label257:
                  while (true) {
                     label253:
                     while (true) {
                        label251:
                        while (true) {
                           label249:
                           while (true) {
                              label245:
                              while (true) {
                                 label243:
                                 while (true) {
                                    switch (var5) {
                                       case -2033735787:
                                          super.Ǳ.thePlayer.motionX *= var3;
                                          super.Ǳ.thePlayer.motionZ *= var3;
                                          var5 = 1723514208 ^ -777065722;
                                          if (var2) {
                                             break label251;
                                          }
                                          continue;
                                       case -1647749290:
                                          break label257;
                                       case -1223403930:
                                          return;
                                       case -1093155721:
                                          break label259;
                                       case -868270407:
                                          break;
                                       case -816593599:
                                          break label243;
                                       case -524872510:
                                          return;
                                       case -505476053:
                                          return;
                                       case -279899602:
                                          super.Ǳ.thePlayer.motionX *= 0.6;
                                          super.Ǳ.thePlayer.motionZ *= 0.6;
                                          super.Ǳ.thePlayer.setSprinting(false);
                                          var5 = -1437119809 ^ -777065722;
                                          if (!var2) {
                                             continue;
                                          }
                                       case 448259611:
                                          int var15;
                                          label221: {
                                             label220: {
                                                try {
                                                   var15 = this.Ȧ();
                                                   if (var2) {
                                                      break label221;
                                                   }

                                                   if (var15 != 0) {
                                                      break label220;
                                                   }
                                                } catch (ocbde1165e4e var14) {
                                                   throw var14;
                                                }

                                                var5 = 496096703 ^ -777065722;
                                                if (!var2) {
                                                   continue;
                                                }
                                             }

                                             var15 = 812771117 ^ -777065722;
                                          }

                                          var5 = var15;
                                          if (!var2) {
                                             continue;
                                          }
                                       case -656792464:
                                          int var16;
                                          label211: {
                                             label210: {
                                                try {
                                                   var16 = super.Ǳ.thePlayer.isSprinting();
                                                   if (var2) {
                                                      break label211;
                                                   }

                                                   if (var16 == 0) {
                                                      break label210;
                                                   }
                                                } catch (ocbde1165e4e var13) {
                                                   throw var13;
                                                }

                                                var5 = 1056962856 ^ -777065722;
                                                if (!var2) {
                                                   continue;
                                                }
                                             }

                                             var16 = -1437119809 ^ -777065722;
                                          }

                                          var5 = var16;
                                          if (!var2) {
                                             continue;
                                          }
                                          break;
                                       case -104740479:
                                          break label249;
                                       case 771375522:
                                          break label265;
                                       case 787744570:
                                          var3 = 0.52;
                                          var5 = 1466518675 ^ -777065722;
                                          if (var2) {
                                             return;
                                          }
                                          continue;
                                       case 1096736342:
                                          break label245;
                                       case 1167063238:
                                          break label253;
                                       case 1372879536:
                                          int var10000;
                                          label155: {
                                             label154: {
                                                try {
                                                   var10000 = var1.Ǻ instanceof EntityLivingBase;
                                                   if (var2) {
                                                      break label155;
                                                   }

                                                   if (var10000 != 0) {
                                                      break label154;
                                                   }
                                                } catch (ocbde1165e4e var8) {
                                                   throw var8;
                                                }

                                                var5 = 812771117 ^ -777065722;
                                                if (!var2) {
                                                   continue;
                                                }
                                             }

                                             var10000 = 1281866832 ^ -777065722;
                                          }

                                          var5 = var10000;
                                          if (var2) {
                                             break label259;
                                          }
                                          continue;
                                       case 1887629851:
                                          break label251;
                                       case 2079957433:
                                          break label261;
                                       default:
                                          throw null;
                                    }

                                    if (super.Ǳ.thePlayer != null) {
                                       var5 = -61560156 ^ -777065722;
                                       if (!var2) {
                                          continue;
                                       }
                                    }

                                    var5 = 812771117 ^ -777065722;
                                    if (var2) {
                                       break;
                                    }
                                 }

                                 int var17;
                                 label200: {
                                    label199: {
                                       try {
                                          var17 = super.Ǳ.thePlayer.hurtTime;
                                          if (var2) {
                                             break label200;
                                          }

                                          if (super.Ǳ.thePlayer.hurtTime <= 0) {
                                             break label199;
                                          }
                                       } catch (ocbde1165e4e var12) {
                                          throw var12;
                                       }

                                       var5 = 1870212977 ^ -777065722;
                                       if (!var2) {
                                          continue;
                                       }
                                    }

                                    var17 = 823787460 ^ -777065722;
                                 }

                                 var5 = var17;
                                 if (var2) {
                                    break;
                                 }
                              }

                              int var18;
                              label189: {
                                 label188: {
                                    try {
                                       var18 = this.Ȳ();
                                       if (var2) {
                                          break label189;
                                       }

                                       if (var18 != 0) {
                                          break label188;
                                       }
                                    } catch (ocbde1165e4e var11) {
                                       throw var11;
                                    }

                                    var5 = -1590945507 ^ -777065722;
                                    if (!var2) {
                                       continue;
                                    }
                                 }

                                 var18 = 1723514208 ^ -777065722;
                              }

                              var5 = var18;
                              if (var2) {
                                 break;
                              }
                           }

                           var3 = 0.8;
                           var5 = 1466518675 ^ -777065722;
                           if (var2) {
                              break label253;
                           }
                        }

                        int var22;
                        label173: {
                           label172: {
                              try {
                                 var22 = super.Ǳ.thePlayer.onGround;
                                 if (var2) {
                                    break label173;
                                 }

                                 if (!super.Ǳ.thePlayer.onGround) {
                                    break label172;
                                 }
                              } catch (ocbde1165e4e var10) {
                                 throw var10;
                              }

                              var5 = -10818500 ^ -777065722;
                              if (!var2) {
                                 continue;
                              }
                           }

                           var22 = 678371975 ^ -777065722;
                        }

                        var5 = var22;
                        if (var2) {
                           break label261;
                        }
                     }

                     int var19;
                     label164: {
                        label163: {
                           try {
                              var19 = super.Ǳ.thePlayer.hurtTime;
                              if (var2) {
                                 break label164;
                              }

                              if (super.Ǳ.thePlayer.hurtTime <= 0) {
                                 break label163;
                              }
                           } catch (ocbde1165e4e var9) {
                              throw var9;
                           }

                           var5 = -1863305904 ^ -777065722;
                           if (!var2) {
                              continue;
                           }
                        }

                        var19 = 1723514208 ^ -777065722;
                     }

                     var5 = var19;
                     if (var2) {
                        break;
                     }
                  }

                  int var21;
                  label141: {
                     label140: {
                        try {
                           var21 = (int)this.ϋ.Ӂ();
                           if (var2) {
                              break label141;
                           }

                           if (var21 != 1) {
                              break label140;
                           }
                        } catch (ocbde1165e4e var7) {
                           throw var7;
                        }

                        var5 = -1809771584 ^ -777065722;
                        if (!var2) {
                           continue;
                        }
                     }

                     var21 = 519908935 ^ -777065722;
                  }

                  var5 = var21;
                  if (var2) {
                     return;
                  }
               }

               int var20;
               label132: {
                  label131: {
                     try {
                        var20 = this.Ò;
                        if (var2) {
                           break label132;
                        }

                        if (this.Ò) {
                           break label131;
                        }
                     } catch (ocbde1165e4e var6) {
                        throw var6;
                     }

                     var5 = 158650230 ^ -777065722;
                     if (!var2) {
                        continue;
                     }
                  }

                  var20 = -1437119809 ^ -777065722;
               }

               var5 = var20;
               if (var2) {
                  return;
               }
            }

            this.Ò = false;
            var5 = 823787460 ^ -777065722;
         } while (!var2);

         if (var1.Ǖ == super.Ǳ.thePlayer) {
            var5 = -2139450954 ^ -777065722;
            if (!var2) {
               continue;
            }
         }

         var5 = 812771117 ^ -777065722;
      }
   }

   public void z$1jqr9z9xe1cdc(oc3d09332f58 param1) {
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
      // 04: ifne 16
      // 07: invokevirtual x/oc49fb68d420.Ȧ ()Z
      // 0a: ifne 30
      // 0d: goto 11
      // 10: athrow
      // 11: aload 0
      // 12: goto 16
      // 15: athrow
      // 16: iload 2
      // 17: ifne 2c
      // 1a: getfield x/oc49fb68d420.Ǳ Lnet/minecraft/client/Minecraft;
      // 1d: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 20: ifnull 30
      // 23: goto 27
      // 26: athrow
      // 27: aload 0
      // 28: goto 2c
      // 2b: athrow
      // 2c: bipush 1
      // 2d: putfield x/oc0cf407c945.Ò Z
      // 30: return
   }

   public void z$2cvyenog50sql(ocbab3c9954b var1) {
      this.Ò = false;
   }

   private boolean Ȳ() {
      boolean var1 = false;
      int var2 = -497909662 ^ -1854900389;

      while (true) {
         switch (var2) {
            case -2013390449:
               return false;
            case -218847262:
               int var6;
               label56: {
                  label55: {
                     try {
                        var6 = super.Ǳ.thePlayer.getIsInWeb();
                        if (var1) {
                           break label56;
                        }

                        if (var6 == 0) {
                           break label55;
                        }
                     } catch (ocbde1165e4e var4) {
                        throw var4;
                     }

                     var2 = 1625130007 ^ -1854900389;
                     if (!var1) {
                        break;
                     }
                  }

                  var6 = 378433236 ^ -1854900389;
               }

               var2 = var6;
               if (!var1) {
                  break;
               }
            case 1931671353:
               int var7;
               label47: {
                  label46: {
                     try {
                        var7 = super.Ǳ.thePlayer.isInWater();
                        if (var1) {
                           break label47;
                        }

                        if (var7 != 0) {
                           break label46;
                        }
                     } catch (ocbde1165e4e var3) {
                        throw var3;
                     }

                     var2 = -1990282234 ^ -1854900389;
                     if (!var1) {
                        break;
                     }
                  }

                  var7 = 1625130007 ^ -1854900389;
               }

               var2 = var7;
               break;
            case 405717853:
               int var10000;
               label65: {
                  label64: {
                     try {
                        var10000 = super.Ǳ.thePlayer.isInLava();
                        if (var1) {
                           break label65;
                        }

                        if (var10000 != 0) {
                           break label64;
                        }
                     } catch (ocbde1165e4e var5) {
                        throw var5;
                     }

                     var2 = 1669648569 ^ -1854900389;
                     if (!var1) {
                        break;
                     }
                  }

                  var10000 = 1625130007 ^ -1854900389;
               }

               var2 = var10000;
               if (!var1) {
                  break;
               }
            case -240258228:
               return true;
            default:
               throw null;
         }
      }
   }
}
