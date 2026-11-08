package x;

import java.util.concurrent.ConcurrentLinkedDeque;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S08PacketPlayerPosLook;
import net.minecraft.network.play.server.S12PacketEntityVelocity;
import net.minecraft.network.play.server.S27PacketExplosion;
import org.lwjgl.input.Keyboard;

public class oc0c1ea432b5 extends oc49fb68d420 {
   public final oca9cc61aada ŵ;
   public final oca9cc61aada պ;
   public final oca9cc61aada ź;
   public final occ2f8dff8d8 n;
   public final occ2f8dff8d8 á;
   public final occ2f8dff8d8 ң;
   public final oca9cc61aada ɨ;
   public final oca9cc61aada Ӽ;
   public final oca9cc61aada ʁ;
   public final oca9cc61aada Ǒ;
   public final occ2f8dff8d8 ɝ;
   public final occ2f8dff8d8 Ա;
   public final occ2f8dff8d8 ŧ;
   public final occ2f8dff8d8 Ӫ;
   public final oc2ec6a95e5c Ф;
   private final ConcurrentLinkedDeque<Packet<?>> ѱ = new ConcurrentLinkedDeque<>();
   private long ß = -7177232514372245869L ^ 7177232514372245868L;
   private long ԗ;
   public static boolean Ԍ;

   public oc0c1ea432b5(oc72ee500c19 var1) {
      super("Standard", var1);
      this.Ⱦ(this.ŵ = new oca9cc61aada("Horizontal", "%", 90.0, 0.0, 100.0, 1.0));
      this.Ⱦ(this.պ = new oca9cc61aada("Vertical", "%", 100.0, 0.0, 100.0, 1.0));
      this.Ⱦ(this.ź = new oca9cc61aada("Chance", "%", 100.0, 0.0, 100.0, 1.0));
      this.Ⱦ(this.n = new occ2f8dff8d8("Only while targeting", false));
      this.Ⱦ(this.á = new occ2f8dff8d8("Disable while holding S", false));
      this.Ⱦ(this.ң = new occ2f8dff8d8("Delay", false));
      this.Ⱦ(this.ɨ = new oca9cc61aada("Minimum delay", "ms", 100.0, 0.0, 1000.0, 10.0));
      this.Ⱦ(this.Ӽ = new oca9cc61aada("Maximum delay", "ms", 200.0, 50.0, 1000.0, 10.0));
      this.Ⱦ(this.ʁ = new oca9cc61aada("Delay distance to target", 6.0, 3.0, 12.0, 0.1));
      this.Ⱦ(this.Ǒ = new oca9cc61aada("Delay chance", "%", 100.0, 0.0, 100.0, 1.0));
      this.Ⱦ(this.ɝ = new occ2f8dff8d8("Delay in air", true));
      this.Ⱦ(this.Ա = new occ2f8dff8d8("Delay looking at player", false));
      this.Ⱦ(this.ŧ = new occ2f8dff8d8("Delay require left mouse", false));
      this.Ⱦ(this.Ӫ = new occ2f8dff8d8("Delay restrict held item", false));
      this.Ⱦ(this.Ф = new oc2ec6a95e5c("Delay whitelisted items", new String[]{"standard-delay-whitelisted-items"}));
   }

   public String z$1vjyi4gk9v6c9() {
      return (int)this.ŵ.Ӂ() + "% " + (int)this.պ.Ӂ() + "%";
   }

   public boolean z$35cvjrtlfk6sk() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: istore 1
      // 02: aload 0
      // 03: getfield x/oc0c1ea432b5.ŵ Lx/oca9cc61aada;
      // 06: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 09: iload 1
      // 0a: ifne 21
      // 0d: dconst_0
      // 0e: dcmpl
      // 0f: ifne 32
      // 12: goto 16
      // 15: athrow
      // 16: aload 0
      // 17: getfield x/oc0c1ea432b5.պ Lx/oca9cc61aada;
      // 1a: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 1d: goto 21
      // 20: athrow
      // 21: dconst_0
      // 22: dcmpl
      // 23: iload 1
      // 24: ifne 2f
      // 27: ifne 32
      // 2a: goto 2e
      // 2d: athrow
      // 2e: bipush 1
      // 2f: goto 33
      // 32: bipush 0
      // 33: ireturn
   }

   public void z$fe4mfecqaowg() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: bipush 0
      // 001: aload 0
      // 002: getfield x/oc49fb68d420.ό Lx/oc72ee500c19;
      // 005: ldc "Standard"
      // 007: invokevirtual x/oc72ee500c19.ӂ (Ljava/lang/String;)Z
      // 00a: istore 2
      // 00b: aload 0
      // 00c: getfield x/oc0c1ea432b5.ŵ Lx/oca9cc61aada;
      // 00f: iload 2
      // 010: aload 0
      // 011: getfield x/oc49fb68d420.ό Lx/oc72ee500c19;
      // 014: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 017: istore 1
      // 018: aload 0
      // 019: getfield x/oc0c1ea432b5.պ Lx/oca9cc61aada;
      // 01c: iload 2
      // 01d: aload 0
      // 01e: getfield x/oc49fb68d420.ό Lx/oc72ee500c19;
      // 021: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 024: aload 0
      // 025: getfield x/oc0c1ea432b5.ź Lx/oca9cc61aada;
      // 028: iload 2
      // 029: aload 0
      // 02a: getfield x/oc49fb68d420.ό Lx/oc72ee500c19;
      // 02d: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 030: aload 0
      // 031: getfield x/oc0c1ea432b5.n Lx/occ2f8dff8d8;
      // 034: iload 1
      // 035: ifne 068
      // 038: iload 2
      // 039: aload 0
      // 03a: getfield x/oc49fb68d420.ό Lx/oc72ee500c19;
      // 03d: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 040: aload 0
      // 041: getfield x/oc0c1ea432b5.á Lx/occ2f8dff8d8;
      // 044: iload 2
      // 045: aload 0
      // 046: getfield x/oc49fb68d420.ό Lx/oc72ee500c19;
      // 049: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 04c: aload 0
      // 04d: getfield x/oc0c1ea432b5.ң Lx/occ2f8dff8d8;
      // 050: iload 2
      // 051: aload 0
      // 052: getfield x/oc49fb68d420.ό Lx/oc72ee500c19;
      // 055: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 058: iload 2
      // 059: ifeq 07a
      // 05c: goto 060
      // 05f: athrow
      // 060: aload 0
      // 061: getfield x/oc0c1ea432b5.ң Lx/occ2f8dff8d8;
      // 064: goto 068
      // 067: athrow
      // 068: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 06b: iload 1
      // 06c: ifne 077
      // 06f: ifeq 07a
      // 072: goto 076
      // 075: athrow
      // 076: bipush 1
      // 077: goto 07b
      // 07a: bipush 0
      // 07b: istore 3
      // 07c: aload 0
      // 07d: getfield x/oc0c1ea432b5.ɨ Lx/oca9cc61aada;
      // 080: iload 3
      // 081: aload 0
      // 082: getfield x/oc49fb68d420.ό Lx/oc72ee500c19;
      // 085: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 088: aload 0
      // 089: getfield x/oc0c1ea432b5.Ӽ Lx/oca9cc61aada;
      // 08c: iload 3
      // 08d: aload 0
      // 08e: getfield x/oc49fb68d420.ό Lx/oc72ee500c19;
      // 091: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 094: aload 0
      // 095: getfield x/oc0c1ea432b5.ʁ Lx/oca9cc61aada;
      // 098: iload 3
      // 099: aload 0
      // 09a: getfield x/oc49fb68d420.ό Lx/oc72ee500c19;
      // 09d: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 0a0: aload 0
      // 0a1: getfield x/oc0c1ea432b5.Ǒ Lx/oca9cc61aada;
      // 0a4: iload 3
      // 0a5: aload 0
      // 0a6: getfield x/oc49fb68d420.ό Lx/oc72ee500c19;
      // 0a9: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 0ac: aload 0
      // 0ad: getfield x/oc0c1ea432b5.ɝ Lx/occ2f8dff8d8;
      // 0b0: iload 3
      // 0b1: aload 0
      // 0b2: getfield x/oc49fb68d420.ό Lx/oc72ee500c19;
      // 0b5: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 0b8: aload 0
      // 0b9: getfield x/oc0c1ea432b5.Ա Lx/occ2f8dff8d8;
      // 0bc: iload 3
      // 0bd: aload 0
      // 0be: getfield x/oc49fb68d420.ό Lx/oc72ee500c19;
      // 0c1: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 0c4: aload 0
      // 0c5: getfield x/oc0c1ea432b5.ŧ Lx/occ2f8dff8d8;
      // 0c8: iload 3
      // 0c9: aload 0
      // 0ca: getfield x/oc49fb68d420.ό Lx/oc72ee500c19;
      // 0cd: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 0d0: aload 0
      // 0d1: getfield x/oc0c1ea432b5.Ӫ Lx/occ2f8dff8d8;
      // 0d4: iload 3
      // 0d5: aload 0
      // 0d6: getfield x/oc49fb68d420.ό Lx/oc72ee500c19;
      // 0d9: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 0dc: aload 0
      // 0dd: getfield x/oc0c1ea432b5.Ф Lx/oc2ec6a95e5c;
      // 0e0: iload 3
      // 0e1: iload 1
      // 0e2: ifne 0f7
      // 0e5: ifeq 106
      // 0e8: goto 0ec
      // 0eb: athrow
      // 0ec: aload 0
      // 0ed: getfield x/oc0c1ea432b5.Ӫ Lx/occ2f8dff8d8;
      // 0f0: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 0f3: goto 0f7
      // 0f6: athrow
      // 0f7: iload 1
      // 0f8: ifne 103
      // 0fb: ifeq 106
      // 0fe: goto 102
      // 101: athrow
      // 102: bipush 1
      // 103: goto 107
      // 106: bipush 0
      // 107: aload 0
      // 108: getfield x/oc49fb68d420.ό Lx/oc72ee500c19;
      // 10b: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 10e: iload 1
      // 10f: ifeq 123
      // 112: bipush 0
      // 113: ifeq 11f
      // 116: goto 11a
      // 119: athrow
      // 11a: bipush 0
      // 11b: goto 120
      // 11e: athrow
      // 11f: bipush 1
      // 120: putstatic x/oc69da1aa7f5.Ҭ Z
      // 123: return
   }

   public void z$24alrqiqeci48() {
      this.ѱ.clear();
      this.ß = -568557758180386234L ^ 568557758180386233L;
   }

   public void z$1bjr376lv3ef3() {
      this.ӣ();
   }

   public void z$1k6rqjev9onbs(occ2f8dff8d8 param1) {
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
      // 04: ifne 1c
      // 07: aload 1
      // 08: invokespecial x/oc49fb68d420.z$1k6rqjev9onbs (Lx/occ2f8dff8d8;)V
      // 0b: aload 1
      // 0c: aload 0
      // 0d: getfield x/oc0c1ea432b5.ң Lx/occ2f8dff8d8;
      // 10: if_acmpne 35
      // 13: goto 17
      // 16: athrow
      // 17: aload 0
      // 18: goto 1c
      // 1b: athrow
      // 1c: iload 2
      // 1d: ifne 32
      // 20: getfield x/oc0c1ea432b5.ң Lx/occ2f8dff8d8;
      // 23: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 26: ifne 35
      // 29: goto 2d
      // 2c: athrow
      // 2d: aload 0
      // 2e: goto 32
      // 31: athrow
      // 32: invokevirtual x/oc0c1ea432b5.ӣ ()V
      // 35: return
   }

   public void z$2az31g34zryyb(oce79181588d var1) {
      Object var3 = null;
      long var4 = 0L;
      long var6 = 0L;
      int var8 = 769689905 ^ 1827674562;
      boolean var2 = false;

      label242: {
         label241:
         while (true) {
            label239:
            while (true) {
               label231:
               while (true) {
                  switch (var8) {
                     case -1719968338:
                        int var23;
                        label176: {
                           label175: {
                              try {
                                 var23 = var1.Ҡ() instanceof S12PacketEntityVelocity;
                                 if (var2) {
                                    break label176;
                                 }

                                 if (var23 == 0) {
                                    break label175;
                                 }
                              } catch (ocbde1165e4e var14) {
                                 throw var14;
                              }

                              var8 = 46464005 ^ 1827674562;
                              if (!var2) {
                                 continue;
                              }
                           }

                           var23 = 263033973 ^ 1827674562;
                        }

                        var8 = var23;
                        if (var2) {
                           return;
                        }
                        continue;
                     case -1293995840:
                        return;
                     case -901772064:
                        int var20;
                        label209: {
                           label208: {
                              try {
                                 var20 = this.Δ();
                                 if (var2) {
                                    break label209;
                                 }

                                 if (var20 == 0) {
                                    break label208;
                                 }
                              } catch (ocbde1165e4e var16) {
                                 throw var16;
                              }

                              var8 = 655229148 ^ 1827674562;
                              if (!var2) {
                                 continue;
                              }
                           }

                           var20 = -1929439277 ^ 1827674562;
                        }

                        var8 = var20;
                        if (!var2) {
                           continue;
                        }
                     case -715088548:
                        int var21;
                        label194: {
                           label193: {
                              try {
                                 var21 = var1.Ҡ() instanceof S08PacketPlayerPosLook;
                                 if (var2) {
                                    break label194;
                                 }

                                 if (var21 == 0) {
                                    break label193;
                                 }
                              } catch (ocbde1165e4e var15) {
                                 throw var15;
                              }

                              var8 = -1716180385 ^ 1827674562;
                              if (!var2) {
                                 continue;
                              }
                           }

                           var21 = -1992066182 ^ 1827674562;
                        }

                        var8 = var21;
                        if (!var2) {
                           continue;
                        }
                        break;
                     case -877595195:
                        var4 = var6;
                        var8 = 1288058997 ^ 1827674562;
                        if (!var2) {
                           continue;
                        }
                     case 1848960455:
                        if (super.Ǳ.thePlayer != null) {
                           var8 = -1317376399 ^ 1827674562;
                           if (!var2) {
                              continue;
                           }
                        }

                        var8 = 263033973 ^ 1827674562;
                        if (!var2) {
                           continue;
                        }
                     case -578127949:
                        if (super.Ǳ.theWorld == null) {
                           var8 = 263033973 ^ 1827674562;
                           if (!var2) {
                              continue;
                           }
                        }

                        var8 = 328690954 ^ 1827674562;
                        if (!var2) {
                           continue;
                        }
                        break label231;
                     case -661040758:
                        return;
                     case -535884271:
                        break;
                     case -477502602:
                        break label239;
                     case -441228616:
                        int var19;
                        label148: {
                           label147: {
                              try {
                                 long var25;
                                 var19 = (var25 = this.ß - (1486119204986162776L ^ -1486119204986162777L)) == 0L ? 0 : (var25 < 0L ? -1 : 1);
                                 if (var2) {
                                    break label148;
                                 }

                                 if (var19 == 0) {
                                    break label147;
                                 }
                              } catch (ocbde1165e4e var11) {
                                 throw var11;
                              }

                              var8 = -2127481967 ^ 1827674562;
                              if (!var2) {
                                 continue;
                              }
                           }

                           var19 = -175422356 ^ 1827674562;
                        }

                        var8 = var19;
                        if (var2) {
                           break label241;
                        }
                        continue;
                     case -306107821:
                        break label242;
                     case -180014179:
                        break label241;
                     case 69148200:
                        int var18;
                        label130: {
                           label129: {
                              try {
                                 double var26;
                                 var18 = (var26 = Math.random() * 100.0 - this.Ǒ.Ӂ()) == 0.0 ? 0 : (var26 < 0.0 ? -1 : 1);
                                 if (var2) {
                                    break label130;
                                 }

                                 if (var18 < 0) {
                                    break label129;
                                 }
                              } catch (ocbde1165e4e var9) {
                                 throw var9;
                              }

                              var8 = -1268168632 ^ 1827674562;
                              if (!var2) {
                                 continue;
                              }
                           }

                           var18 = -1887831372 ^ 1827674562;
                        }

                        var8 = var18;
                        if (var2) {
                           return;
                        }
                        continue;
                     case 540418487:
                        this.ԗ = var4 + (long)(Math.random() * (var6 - var4 + 1L));
                        return;
                     case 1091604723:
                        int var10000;
                        label139: {
                           label138: {
                              try {
                                 var10000 = this.ң.ǭ();
                                 if (var2) {
                                    break label139;
                                 }

                                 if (var10000 != 0) {
                                    break label138;
                                 }
                              } catch (ocbde1165e4e var10) {
                                 throw var10;
                              }

                              var8 = -567334654 ^ 1827674562;
                              if (!var2) {
                                 continue;
                              }
                           }

                           var10000 = -1181711202 ^ 1827674562;
                        }

                        var8 = var10000;
                        if (var2) {
                           break label242;
                        }
                        continue;
                     case 1274943774:
                        return;
                     case 1667075511:
                        return;
                     case 2137486536:
                        break label231;
                     default:
                        throw null;
                  }

                  int var22;
                  label167: {
                     label166: {
                        try {
                           double var24;
                           var22 = (var24 = this.Ǒ.Ӂ() - 100.0) == 0.0 ? 0 : (var24 < 0.0 ? -1 : 1);
                           if (var2) {
                              break label167;
                           }

                           if (var22 >= 0) {
                              break label166;
                           }
                        } catch (ocbde1165e4e var13) {
                           throw var13;
                        }

                        var8 = 1760495594 ^ 1827674562;
                        if (!var2) {
                           continue;
                        }
                     }

                     var22 = -1887831372 ^ 1827674562;
                  }

                  var8 = var22;
                  if (var2) {
                     return;
                  }
               }

               var3 = (S12PacketEntityVelocity)var1.Ҡ();

               label157: {
                  label156: {
                     try {
                        if (var2) {
                           break label157;
                        }

                        if (var3.getEntityID() != super.Ǳ.thePlayer.getEntityId()) {
                           break label156;
                        }
                     } catch (ocbde1165e4e var12) {
                        throw var12;
                     }

                     var8 = -1498409694 ^ 1827674562;
                     if (!var2) {
                        continue;
                     }
                  }

                  var8 = 655229148 ^ 1827674562;
               }

               if (var2) {
                  break;
               }
            }

            var1.setCanceled(true);
            this.ѱ.addLast(var1.Ҡ());
            this.ß = System.currentTimeMillis();
            if (!var2) {
               var4 = (long)this.ɨ.Ӂ();
               var6 = (long)this.Ӽ.Ӂ();
               if (var4 > var6) {
                  var8 = -1488917497 ^ 1827674562;
                  if (!var2) {
                     continue;
                  }
               }

               var8 = 1288058997 ^ 1827674562;
            }
         }

         this.ӣ();
         return;
      }

      var1.setCanceled(true);
      this.ѱ.addLast(var1.Ҡ());
   }

   public void z$3fnumkcg4fzh7(oce79181588d var1) {
      S12PacketEntityVelocity var3 = null;
      S27PacketExplosion var4 = null;
      double var5 = 0.0;
      boolean var2 = false;
      double var7 = 0.0;
      int var9 = 28346322 ^ -1544201615;

      label334: {
         label289:
         while (true) {
            label285:
            while (true) {
               label279:
               while (true) {
                  label277:
                  while (true) {
                     switch (var9) {
                        case -1784074055:
                           break label334;
                        case -1702862876:
                           break label289;
                        case -1572479581:
                           int var27;
                           label187: {
                              label186: {
                                 try {
                                    var27 = oc7ab2161b9f.Ð();
                                    if (var2) {
                                       break label187;
                                    }

                                    if (var27 == 0) {
                                       break label186;
                                    }
                                 } catch (ocbde1165e4e var14) {
                                    throw var14;
                                 }

                                 var9 = -1434122744 ^ -1544201615;
                                 if (!var2) {
                                    continue;
                                 }
                              }

                              var27 = 403076045 ^ -1544201615;
                           }

                           var9 = var27;
                           if (!var2) {
                              continue;
                           }

                           return;
                        case -1469164060:
                           return;
                        case -1401893730:
                           return;
                        case -1189378418:
                           var4 = (S27PacketExplosion)var1.Ҡ();
                           var9 = 1744004492 ^ -1544201615;
                           if (var2) {
                              return;
                           }
                           continue;
                        case -1141691972:
                           return;
                        case -1006223363:
                           break;
                        case -974676634:
                           break label279;
                        case -803435821:
                           int var24;
                           label250: {
                              label249: {
                                 try {
                                    var24 = this.Ғ();
                                    if (var2) {
                                       break label250;
                                    }

                                    if (var24 != 0) {
                                       break label249;
                                    }
                                 } catch (ocbde1165e4e var19) {
                                    throw var19;
                                 }

                                 var9 = 260413167 ^ -1544201615;
                                 if (!var2) {
                                    continue;
                                 }
                              }

                              var24 = 1174981945 ^ -1544201615;
                           }

                           var9 = var24;
                           if (!var2) {
                              continue;
                           }
                        case -436365496:
                           var5 = this.ŵ.Ӂ() / 100.0;
                           if (!var2) {
                              var7 = this.պ.Ӂ() / 100.0;
                              if (var3 != null) {
                                 var9 = 963970453 ^ -1544201615;
                                 if (!var2) {
                                    continue;
                                 }
                              }

                              var9 = 912026312 ^ -1544201615;
                           }

                           if (!var2) {
                              continue;
                           }
                           break label277;
                        case -443105278:
                           if (super.Ǳ.objectMouseOver != null) {
                              var9 = -1288490255 ^ -1544201615;
                              if (!var2) {
                                 continue;
                              }
                           }

                           var9 = -1421246029 ^ -1544201615;
                           if (var2) {
                              break label285;
                           }
                           continue;
                        case -97901770:
                           return;
                        case -7560463:
                           break label277;
                        case 146594754:
                           return;
                        case 281438336:
                           if (super.Ǳ.objectMouseOver.entityHit == null) {
                              var9 = -1421246029 ^ -1544201615;
                              if (!var2) {
                                 continue;
                              }
                           }

                           var9 = -1696724879 ^ -1544201615;
                           if (!var2) {
                              continue;
                           }
                        case 158358649:
                           int var22;
                           label225: {
                              label224: {
                                 try {
                                    var22 = this.Ȧ();
                                    if (var2) {
                                       break label225;
                                    }

                                    if (var22 != 0) {
                                       break label224;
                                    }
                                 } catch (ocbde1165e4e var17) {
                                    throw var17;
                                 }

                                 var9 = -112656101 ^ -1544201615;
                                 if (!var2) {
                                    continue;
                                 }
                              }

                              var22 = 403076045 ^ -1544201615;
                           }

                           var9 = var22;
                           if (!var2) {
                              continue;
                           }
                           break label279;
                        case 290484947:
                           int var21;
                           label196: {
                              label195: {
                                 try {
                                    var21 = var1.Ҡ() instanceof S27PacketExplosion;
                                    if (var2) {
                                       break label196;
                                    }

                                    if (var21 == 0) {
                                       break label195;
                                    }
                                 } catch (ocbde1165e4e var15) {
                                    throw var15;
                                 }

                                 var9 = 451861759 ^ -1544201615;
                                 if (!var2) {
                                    continue;
                                 }
                              }

                              var21 = 194711445 ^ -1544201615;
                           }

                           var9 = var21;
                           if (var2) {
                              break label289;
                           }
                           continue;
                        case 381575873:
                           break label285;
                        case 959140352:
                           int var20;
                           label234: {
                              label233: {
                                 try {
                                    var20 = this.á.ǭ();
                                    if (var2) {
                                       break label234;
                                    }

                                    if (var20 == 0) {
                                       break label233;
                                    }
                                 } catch (ocbde1165e4e var18) {
                                    throw var18;
                                 }

                                 var9 = 1551497344 ^ -1544201615;
                                 if (!var2) {
                                    continue;
                                 }
                              }

                              var20 = 1944703138 ^ -1544201615;
                           }

                           var9 = var20;
                           if (!var2) {
                              continue;
                           }
                           break;
                        case 1522293610:
                           int var10000;
                           label152: {
                              label151: {
                                 try {
                                    var10000 = var1.isCanceled();
                                    if (var2) {
                                       break label152;
                                    }

                                    if (var10000 == 0) {
                                       break label151;
                                    }
                                 } catch (ocbde1165e4e var10) {
                                    throw var10;
                                 }

                                 var9 = 403076045 ^ -1544201615;
                                 if (!var2) {
                                    continue;
                                 }
                              }

                              var10000 = -1253361488 ^ -1544201615;
                           }

                           var9 = var10000;
                           continue;
                        case 1641848843:
                           return;
                        default:
                           throw null;
                     }

                     int var26;
                     label205: {
                        label204: {
                           try {
                              var26 = this.n.ǭ();
                              if (var2) {
                                 break label205;
                              }

                              if (var26 == 0) {
                                 break label204;
                              }
                           } catch (ocbde1165e4e var16) {
                              throw var16;
                           }

                           var9 = 1180932723 ^ -1544201615;
                           if (!var2) {
                              continue;
                           }
                        }

                        var26 = -1696724879 ^ -1544201615;
                     }

                     var9 = var26;
                     if (var2) {
                        break label334;
                     }
                  }

                  int var25;
                  label178: {
                     label177: {
                        try {
                           var25 = super.Ǳ.gameSettings.keyBindBack.getKeyCode();
                           if (var2) {
                              break label178;
                           }

                           if (!Keyboard.isKeyDown(var25)) {
                              break label177;
                           }
                        } catch (ocbde1165e4e var13) {
                           throw var13;
                        }

                        var9 = 1507817799 ^ -1544201615;
                        if (!var2) {
                           continue;
                        }
                     }

                     var25 = 1944703138 ^ -1544201615;
                  }

                  var9 = var25;
                  if (var2) {
                     return;
                  }
               }

               var3 = (S12PacketEntityVelocity)var1.Ҡ();

               label168: {
                  label167: {
                     try {
                        if (var2) {
                           break label168;
                        }

                        if (var3.getEntityID() == super.Ǳ.thePlayer.getEntityId()) {
                           break label167;
                        }
                     } catch (ocbde1165e4e var12) {
                        throw var12;
                     }

                     var9 = -1037436294 ^ -1544201615;
                     if (!var2) {
                        continue;
                     }
                  }

                  var9 = 1744004492 ^ -1544201615;
               }

               if (var2) {
                  return;
               }
            }

            var3 = null;
            boolean var23 = var2;
            var4 = null;

            label158: {
               try {
                  if (var23) {
                     continue;
                  }

                  if (!(var1.Ҡ() instanceof S12PacketEntityVelocity)) {
                     break label158;
                  }
               } catch (ocbde1165e4e var11) {
                  throw var11;
               }

               var9 = 1712506647 ^ -1544201615;
               if (!var2) {
                  continue;
               }
            }

            var9 = -1297799006 ^ -1544201615;
         }

         var3.setMotionX(љ(var3.getMotionX(), var5));
         var3.setMotionY(љ(var3.getMotionY(), var7));
         var3.setMotionZ(љ(var3.getMotionZ(), var5));
         return;
      }

      var4.setPlayerMotionX((float)(var4.func_149149_c() * var5));
      var4.setPlayerMotionY((float)(var4.func_149144_d() * var7));
      var4.setPlayerMotionZ((float)(var4.func_149147_e() * var5));
   }

   public void z$1hfnjryfrqybj(oc9341368218 param1) {
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
      // 04: ifne 48
      // 07: getfield x/oc49fb68d420.Ǳ Lnet/minecraft/client/Minecraft;
      // 0a: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0d: ifnull 43
      // 10: goto 14
      // 13: athrow
      // 14: aload 0
      // 15: iload 2
      // 16: ifne 48
      // 19: goto 1d
      // 1c: athrow
      // 1d: getfield x/oc49fb68d420.Ǳ Lnet/minecraft/client/Minecraft;
      // 20: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 23: ifnull 43
      // 26: goto 2a
      // 29: athrow
      // 2a: aload 0
      // 2b: iload 2
      // 2c: ifne 4d
      // 2f: goto 33
      // 32: athrow
      // 33: getfield x/oc49fb68d420.Ǳ Lnet/minecraft/client/Minecraft;
      // 36: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 39: getfield net/minecraft/client/entity/EntityPlayerSP.isDead Z
      // 3c: ifeq 4c
      // 3f: goto 43
      // 42: athrow
      // 43: aload 0
      // 44: goto 48
      // 47: athrow
      // 48: invokevirtual x/oc0c1ea432b5.ӣ ()V
      // 4b: return
      // 4c: aload 0
      // 4d: iload 2
      // 4e: ifne 68
      // 51: getfield x/oc0c1ea432b5.ß J
      // 54: ldc2_w -461095566428687904
      // 57: ldc2_w 461095566428687903
      // 5a: lxor
      // 5b: lcmp
      // 5c: ifeq 92
      // 5f: goto 63
      // 62: athrow
      // 63: aload 0
      // 64: goto 68
      // 67: athrow
      // 68: iload 2
      // 69: ifne 8f
      // 6c: invokevirtual x/oc0c1ea432b5.Δ ()Z
      // 6f: ifne 8a
      // 72: goto 76
      // 75: athrow
      // 76: invokestatic java/lang/System.currentTimeMillis ()J
      // 79: aload 0
      // 7a: getfield x/oc0c1ea432b5.ß J
      // 7d: lsub
      // 7e: aload 0
      // 7f: getfield x/oc0c1ea432b5.ԗ J
      // 82: lcmp
      // 83: iflt 92
      // 86: goto 8a
      // 89: athrow
      // 8a: aload 0
      // 8b: goto 8f
      // 8e: athrow
      // 8f: invokevirtual x/oc0c1ea432b5.ӣ ()V
      // 92: return
   }

   public void z$2cvyenog50sql(ocbab3c9954b var1) {
      this.ӣ();
   }

   private boolean Ғ() {
      double var2 = 0.0;
      int var4 = -298804712 ^ 2014104659;
      boolean var1 = false;

      while (true) {
         switch (var4) {
            case -1774430645:
               var2 = this.ź.Ӂ();

               label58: {
                  label57: {
                     try {
                        if (var1) {
                           break label58;
                        }

                        if (!(var2 > 0.0)) {
                           break label57;
                        }
                     } catch (ocbde1165e4e var6) {
                        throw var6;
                     }

                     var4 = 938939334 ^ 2014104659;
                     if (!var1) {
                        break;
                     }
                  }

                  var4 = 2059876759 ^ 2014104659;
               }

               if (!var1) {
                  break;
               }

               return false;
            case 46921156:
               return false;
            case 101555451:
               return true;
            case 1341906837:
               int var10000;
               label71: {
                  label70: {
                     try {
                        double var10;
                        var10000 = (var10 = var2 - 100.0) == 0.0 ? 0 : (var10 < 0.0 ? -1 : 1);
                        if (var1) {
                           break label71;
                        }

                        if (var10000 >= 0) {
                           break label70;
                        }
                     } catch (ocbde1165e4e var7) {
                        throw var7;
                     }

                     var4 = 1696019888 ^ 2014104659;
                     if (!var1) {
                        break;
                     }
                  }

                  var10000 = 2114015400 ^ 2014104659;
               }

               var4 = var10000;
               if (!var1) {
                  break;
               }
            case 488372707:
               int var8;
               label49: {
                  label48: {
                     try {
                        double var9;
                        var8 = (var9 = Math.random() - var2 / 100.0) == 0.0 ? 0 : (var9 < 0.0 ? -1 : 1);
                        if (var1) {
                           break label49;
                        }

                        if (var8 >= 0) {
                           break label48;
                        }
                     } catch (ocbde1165e4e var5) {
                        throw var5;
                     }

                     var4 = 2114015400 ^ 2014104659;
                     if (!var1) {
                        break;
                     }
                  }

                  var8 = 2059876759 ^ 2014104659;
               }

               var4 = var8;
               if (!var1) {
                  break;
               }

               return true;
            default:
               throw null;
         }
      }
   }

   private static int љ(int var0, double var1) {
      return (int)Math.round(var0 * var1);
   }

   private boolean Δ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: aload 0
      // 02: getfield x/oc0c1ea432b5.ʁ Lx/oca9cc61aada;
      // 05: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 08: aload 0
      // 09: getfield x/oc0c1ea432b5.ʁ Lx/oca9cc61aada;
      // 0c: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0f: dmul
      // 10: dstore 2
      // 11: istore 1
      // 12: dload 2
      // 13: bipush 1
      // 14: invokestatic x/oc5e08d6b90f.ß (DZ)Lnet/minecraft/entity/player/EntityPlayer;
      // 17: ifnonnull 1d
      // 1a: bipush 1
      // 1b: ireturn
      // 1c: athrow
      // 1d: aload 0
      // 1e: getfield x/oc0c1ea432b5.ɝ Lx/occ2f8dff8d8;
      // 21: iload 1
      // 22: ifne 57
      // 25: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 28: ifeq 4b
      // 2b: goto 2f
      // 2e: athrow
      // 2f: aload 0
      // 30: iload 1
      // 31: ifne 4c
      // 34: goto 38
      // 37: athrow
      // 38: getfield x/oc49fb68d420.Ǳ Lnet/minecraft/client/Minecraft;
      // 3b: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 3e: getfield net/minecraft/client/entity/EntityPlayerSP.onGround Z
      // 41: ifeq 4b
      // 44: goto 48
      // 47: athrow
      // 48: bipush 1
      // 49: ireturn
      // 4a: athrow
      // 4b: aload 0
      // 4c: iload 1
      // 4d: ifne 6d
      // 50: getfield x/oc0c1ea432b5.Ա Lx/occ2f8dff8d8;
      // 53: goto 57
      // 56: athrow
      // 57: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 5a: ifeq 6c
      // 5d: dload 2
      // 5e: bipush 1
      // 5f: invokestatic x/oc5e08d6b90f.ը (DZ)Lnet/minecraft/entity/player/EntityPlayer;
      // 62: ifnonnull 6c
      // 65: goto 69
      // 68: athrow
      // 69: bipush 1
      // 6a: ireturn
      // 6b: athrow
      // 6c: aload 0
      // 6d: iload 1
      // 6e: ifne 95
      // 71: getfield x/oc0c1ea432b5.ŧ Lx/occ2f8dff8d8;
      // 74: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 77: ifeq 94
      // 7a: goto 7e
      // 7d: athrow
      // 7e: bipush 0
      // 7f: iload 1
      // 80: ifne 9b
      // 83: goto 87
      // 86: athrow
      // 87: invokestatic org/lwjgl/input/Mouse.isButtonDown (I)Z
      // 8a: ifne 94
      // 8d: goto 91
      // 90: athrow
      // 91: bipush 1
      // 92: ireturn
      // 93: athrow
      // 94: aload 0
      // 95: getfield x/oc0c1ea432b5.Ӫ Lx/occ2f8dff8d8;
      // 98: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 9b: iload 1
      // 9c: ifne d6
      // 9f: ifeq d5
      // a2: goto a6
      // a5: athrow
      // a6: aload 0
      // a7: getfield x/oc49fb68d420.Ǳ Lnet/minecraft/client/Minecraft;
      // aa: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // ad: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getHeldItem ()Lnet/minecraft/item/ItemStack;
      // b0: astore 4
      // b2: aload 4
      // b4: ifnull cf
      // b7: aload 0
      // b8: getfield x/oc0c1ea432b5.Ф Lx/oc2ec6a95e5c;
      // bb: aload 4
      // bd: invokevirtual x/oc2ec6a95e5c.b (Lnet/minecraft/item/ItemStack;)Z
      // c0: iload 1
      // c1: ifne d0
      // c4: goto c8
      // c7: athrow
      // c8: ifne d3
      // cb: goto cf
      // ce: athrow
      // cf: bipush 1
      // d0: goto d4
      // d3: bipush 0
      // d4: ireturn
      // d5: bipush 0
      // d6: ireturn
   }

   private void ӣ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: istore 1
      // 02: aload 0
      // 03: iload 1
      // 04: ifne 55
      // 07: ldc2_w -1815013895598380185
      // 0a: ldc2_w 1815013895598380184
      // 0d: lxor
      // 0e: putfield x/oc0c1ea432b5.ß J
      // 11: aload 0
      // 12: getfield x/oc49fb68d420.Ǳ Lnet/minecraft/client/Minecraft;
      // 15: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 18: ifnull 54
      // 1b: goto 1f
      // 1e: athrow
      // 1f: aload 0
      // 20: iload 1
      // 21: ifne 55
      // 24: goto 28
      // 27: athrow
      // 28: getfield x/oc49fb68d420.Ǳ Lnet/minecraft/client/Minecraft;
      // 2b: invokevirtual net/minecraft/client/Minecraft.getNetHandler ()Lnet/minecraft/client/network/NetHandlerPlayClient;
      // 2e: ifnull 54
      // 31: goto 35
      // 34: athrow
      // 35: aload 0
      // 36: getfield x/oc0c1ea432b5.ѱ Ljava/util/concurrent/ConcurrentLinkedDeque;
      // 39: invokevirtual java/util/concurrent/ConcurrentLinkedDeque.pollFirst ()Ljava/lang/Object;
      // 3c: checkcast net/minecraft/network/Packet
      // 3f: dup
      // 40: astore 2
      // 41: ifnull 54
      // 44: iload 1
      // 45: ifne 5b
      // 48: aload 2
      // 49: invokestatic x/ocd6ae010123.Å (Lnet/minecraft/network/Packet;)V
      // 4c: iload 1
      // 4d: ifeq 35
      // 50: goto 54
      // 53: athrow
      // 54: aload 0
      // 55: getfield x/oc0c1ea432b5.ѱ Ljava/util/concurrent/ConcurrentLinkedDeque;
      // 58: invokevirtual java/util/concurrent/ConcurrentLinkedDeque.clear ()V
      // 5b: return
   }
}
