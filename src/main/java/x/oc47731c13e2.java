package x;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedHashSet;
import java.util.Set;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.network.play.client.C0FPacketConfirmTransaction;
import net.minecraft.network.play.server.S12PacketEntityVelocity;
import net.minecraft.network.play.server.S27PacketExplosion;
import net.minecraft.network.play.server.S32PacketConfirmTransaction;

public class oc47731c13e2 extends oc6031c5c531 {
   private static final int ϭ = 8;
   private static final int О = 128;
   private static final double ç = 0.03;
   private static final double ƃ = 0.05;
   private static final long ɺ = Long.MIN_VALUE;
   public final oca9cc61aada ϊ = new oca9cc61aada("Intave loops", "", 2.0, 1.0, 10.0, 1.0, "Loops");
   private final Deque<C0FPacketConfirmTransaction> Ӑ = new ArrayDeque<>();
   private final Set<Long> ӷ = new LinkedHashSet<>();
   private oc465d0e1818 ų = oc465d0e1818.E;
   private oc6aa1f6efb4 Ҟ = oc6aa1f6efb4.Ǥ;
   private boolean Յ;
   private int Ȭ;
   private int ǉ;
   private int Ȏ;
   private long S = -6637519640707757080L ^ 2585852396147018728L;
   private long V = -6637519640707757080L ^ 2585852396147018728L;
   private double С;
   private double Ƙ;
   private double ԡ;
   public static int ů;

   public oc47731c13e2(ocdacba68ccd var1) {
      super("IntaveFireBall2", var1);
   }

   @Override
   public boolean z$th2zwshf7gtl() {
      return false;
   }

   @Override
   public void z$3g18l332rzhcd(boolean var1) {
      this.ϊ.ȉ(var1, super.Ȓ);
   }

   @Override
   public synchronized void z$30uo8shdqe5to() {
      this.Ƈ();
      this.Ӑ.clear();
      this.Ď();
   }

   @Override
   public synchronized void z$1q0da71f8mrae() {
      this.ĥ(true);
      this.Ď();
   }

   @Override
   public synchronized void z$28gl8df6dqh8o(oce79181588d param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc47731c13e2.ů I
      // 03: istore 2
      // 04: iload 2
      // 05: aload 1
      // 06: invokevirtual x/oce79181588d.Ҡ ()Lnet/minecraft/network/Packet;
      // 09: astore 3
      // 0a: ifne 24
      // 0d: aload 3
      // 0e: instanceof net/minecraft/network/play/server/S32PacketConfirmTransaction
      // 11: ifeq 25
      // 14: goto 18
      // 17: athrow
      // 18: aload 0
      // 19: aload 3
      // 1a: checkcast net/minecraft/network/play/server/S32PacketConfirmTransaction
      // 1d: invokevirtual x/oc47731c13e2.ƣ (Lnet/minecraft/network/play/server/S32PacketConfirmTransaction;)V
      // 20: goto 24
      // 23: athrow
      // 24: return
      // 25: aload 0
      // 26: invokevirtual x/oc47731c13e2.ͻ ()J
      // 29: lstore 4
      // 2b: aload 3
      // 2c: iload 2
      // 2d: ifne 41
      // 30: instanceof net/minecraft/network/play/server/S08PacketPlayerPosLook
      // 33: ifeq 40
      // 36: goto 3a
      // 39: athrow
      // 3a: aload 0
      // 3b: invokevirtual x/oc47731c13e2.p ()V
      // 3e: return
      // 3f: athrow
      // 40: aload 3
      // 41: iload 2
      // 42: ifne 5d
      // 45: instanceof net/minecraft/network/play/server/S12PacketEntityVelocity
      // 48: ifeq 5c
      // 4b: goto 4f
      // 4e: athrow
      // 4f: aload 0
      // 50: aload 1
      // 51: aload 3
      // 52: checkcast net/minecraft/network/play/server/S12PacketEntityVelocity
      // 55: lload 4
      // 57: invokevirtual x/oc47731c13e2.ñ (Lx/oce79181588d;Lnet/minecraft/network/play/server/S12PacketEntityVelocity;J)V
      // 5a: return
      // 5b: athrow
      // 5c: aload 3
      // 5d: instanceof net/minecraft/network/play/server/S27PacketExplosion
      // 60: ifeq 71
      // 63: aload 0
      // 64: aload 3
      // 65: checkcast net/minecraft/network/play/server/S27PacketExplosion
      // 68: lload 4
      // 6a: invokevirtual x/oc47731c13e2.Ă (Lnet/minecraft/network/play/server/S27PacketExplosion;J)V
      // 6d: goto 71
      // 70: athrow
      // 71: return
   }

   @Override
   public synchronized void z$eqd7gcilc76w(oc9d4393f3ce param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc47731c13e2.ů I
      // 03: istore 2
      // 04: aload 1
      // 05: invokevirtual x/oc9d4393f3ce.ɟ ()Lnet/minecraft/network/Packet;
      // 08: instanceof net/minecraft/network/play/client/C0FPacketConfirmTransaction
      // 0b: iload 2
      // 0c: ifne 1e
      // 0f: ifeq 21
      // 12: goto 16
      // 15: athrow
      // 16: aload 0
      // 17: invokevirtual x/oc47731c13e2.Ί ()Z
      // 1a: goto 1e
      // 1d: athrow
      // 1e: ifne 22
      // 21: return
      // 22: aload 1
      // 23: invokevirtual x/oc9d4393f3ce.ɟ ()Lnet/minecraft/network/Packet;
      // 26: checkcast net/minecraft/network/play/client/C0FPacketConfirmTransaction
      // 29: astore 3
      // 2a: iload 2
      // 2b: aload 3
      // 2c: invokestatic x/oc47731c13e2.P (Lnet/minecraft/network/play/client/C0FPacketConfirmTransaction;)J
      // 2f: lstore 4
      // 31: ifne 61
      // 34: aload 0
      // 35: getfield x/oc47731c13e2.Ҟ Lx/oc6aa1f6efb4;
      // 38: getstatic x/oc6aa1f6efb4.ҍ Lx/oc6aa1f6efb4;
      // 3b: if_acmpne 52
      // 3e: goto 42
      // 41: athrow
      // 42: lload 4
      // 44: aload 0
      // 45: getfield x/oc47731c13e2.S J
      // 48: lcmp
      // 49: ifne 52
      // 4c: goto 50
      // 4f: athrow
      // 50: return
      // 51: athrow
      // 52: aload 0
      // 53: getfield x/oc47731c13e2.Ӑ Ljava/util/Deque;
      // 56: aload 3
      // 57: invokeinterface java/util/Deque.addLast (Ljava/lang/Object;)V 2
      // 5c: aload 1
      // 5d: bipush 1
      // 5e: invokevirtual x/oc68d6b191af.setCanceled (Z)V
      // 61: return
   }

   @Override
   public synchronized void z$1ygb8gyji3zuv(oc6c7463093f param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc47731c13e2.ů I
      // 03: istore 2
      // 04: aload 1
      // 05: iload 2
      // 06: ifne 19
      // 09: invokevirtual x/oc6c7463093f.Ҩ ()Lnet/minecraft/network/Packet;
      // 0c: instanceof net/minecraft/network/play/client/C0FPacketConfirmTransaction
      // 0f: ifne 18
      // 12: goto 16
      // 15: athrow
      // 16: return
      // 17: athrow
      // 18: aload 1
      // 19: invokevirtual x/oc6c7463093f.Ҩ ()Lnet/minecraft/network/Packet;
      // 1c: checkcast net/minecraft/network/play/client/C0FPacketConfirmTransaction
      // 1f: invokestatic x/oc47731c13e2.P (Lnet/minecraft/network/play/client/C0FPacketConfirmTransaction;)J
      // 22: lstore 3
      // 23: aload 0
      // 24: getfield x/oc47731c13e2.ӷ Ljava/util/Set;
      // 27: lload 3
      // 28: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 2b: invokeinterface java/util/Set.remove (Ljava/lang/Object;)Z 2
      // 30: iload 2
      // 31: ifne 4d
      // 34: pop
      // 35: aload 0
      // 36: getfield x/oc47731c13e2.Ҟ Lx/oc6aa1f6efb4;
      // 39: getstatic x/oc6aa1f6efb4.ҍ Lx/oc6aa1f6efb4;
      // 3c: if_acmpne 58
      // 3f: goto 43
      // 42: athrow
      // 43: lload 3
      // 44: aload 0
      // 45: getfield x/oc47731c13e2.S J
      // 48: lcmp
      // 49: goto 4d
      // 4c: athrow
      // 4d: ifne 58
      // 50: aload 0
      // 51: invokevirtual x/oc47731c13e2.Թ ()V
      // 54: goto 58
      // 57: athrow
      // 58: return
   }

   @Override
   public synchronized void z$2chcnix6dewx9(oc2f61de30bc param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc47731c13e2.ů I
      // 03: istore 2
      // 04: aload 0
      // 05: iload 2
      // 06: ifne 1e
      // 09: getfield x/oc47731c13e2.Ҟ Lx/oc6aa1f6efb4;
      // 0c: getstatic x/oc6aa1f6efb4.դ Lx/oc6aa1f6efb4;
      // 0f: if_acmpne 1d
      // 12: goto 16
      // 15: athrow
      // 16: aload 0
      // 17: bipush 0
      // 18: invokevirtual x/oc47731c13e2.ĥ (Z)V
      // 1b: return
      // 1c: athrow
      // 1d: aload 0
      // 1e: iload 2
      // 1f: ifne 32
      // 22: getfield x/oc6031c5c531.ѥ Lnet/minecraft/client/Minecraft;
      // 25: ifnonnull 31
      // 28: goto 2c
      // 2b: athrow
      // 2c: aconst_null
      // 2d: goto 38
      // 30: athrow
      // 31: aload 0
      // 32: getfield x/oc6031c5c531.ѥ Lnet/minecraft/client/Minecraft;
      // 35: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 38: astore 3
      // 39: aload 0
      // 3a: getfield x/oc47731c13e2.Ҟ Lx/oc6aa1f6efb4;
      // 3d: getstatic x/oc6aa1f6efb4.ü Lx/oc6aa1f6efb4;
      // 40: if_acmpne 4b
      // 43: aload 3
      // 44: ifnonnull 4d
      // 47: goto 4b
      // 4a: athrow
      // 4b: return
      // 4c: athrow
      // 4d: aload 0
      // 4e: iload 2
      // 4f: ifne 7d
      // 52: dup
      // 53: getfield x/oc47731c13e2.Ȏ I
      // 56: bipush 1
      // 57: iadd
      // 58: putfield x/oc47731c13e2.Ȏ I
      // 5b: aload 0
      // 5c: getfield x/oc47731c13e2.Ȏ I
      // 5f: ldc -1563498492
      // 61: ldc -1563498484
      // 63: ixor
      // 64: if_icmpge 7c
      // 67: goto 6b
      // 6a: athrow
      // 6b: aload 3
      // 6c: getfield net/minecraft/client/entity/EntityPlayerSP.motionY D
      // 6f: ldc2_w 0.03
      // 72: dcmpl
      // 73: ifle 7c
      // 76: goto 7a
      // 79: athrow
      // 7a: return
      // 7b: athrow
      // 7c: aload 0
      // 7d: aload 3
      // 7e: invokevirtual x/oc47731c13e2.Ү (Lnet/minecraft/client/entity/EntityPlayerSP;)V
      // 81: return
   }

   @Override
   public synchronized void z$rvfg1nz4abtc(ocbab3c9954b var1) {
      this.Ƈ();
      this.Ӑ.clear();
      this.Ď();
   }

   private void ñ(oce79181588d param1, S12PacketEntityVelocity param2, long param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc47731c13e2.ů I
      // 03: istore 5
      // 05: aload 0
      // 06: iload 5
      // 08: ifne 1a
      // 0b: getfield x/oc6031c5c531.ѥ Lnet/minecraft/client/Minecraft;
      // 0e: ifnull 41
      // 11: goto 15
      // 14: athrow
      // 15: aload 0
      // 16: goto 1a
      // 19: athrow
      // 1a: getfield x/oc6031c5c531.ѥ Lnet/minecraft/client/Minecraft;
      // 1d: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 20: ifnull 41
      // 23: aload 2
      // 24: iload 5
      // 26: ifne 44
      // 29: goto 2d
      // 2c: athrow
      // 2d: invokevirtual net/minecraft/network/play/server/S12PacketEntityVelocity.getEntityID ()I
      // 30: aload 0
      // 31: getfield x/oc6031c5c531.ѥ Lnet/minecraft/client/Minecraft;
      // 34: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 37: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getEntityId ()I
      // 3a: if_icmpeq 43
      // 3d: goto 41
      // 40: athrow
      // 41: return
      // 42: athrow
      // 43: aload 2
      // 44: invokevirtual net/minecraft/network/play/server/S12PacketEntityVelocity.getMotionX ()I
      // 47: i2d
      // 48: ldc2_w 8000.0
      // 4b: ddiv
      // 4c: dstore 6
      // 4e: aload 2
      // 4f: invokevirtual net/minecraft/network/play/server/S12PacketEntityVelocity.getMotionY ()I
      // 52: i2d
      // 53: ldc2_w 8000.0
      // 56: ddiv
      // 57: dstore 8
      // 59: aload 2
      // 5a: invokevirtual net/minecraft/network/play/server/S12PacketEntityVelocity.getMotionZ ()I
      // 5d: i2d
      // 5e: ldc2_w 8000.0
      // 61: ddiv
      // 62: dstore 10
      // 64: aload 0
      // 65: getstatic x/oc465d0e1818.ͳ Lx/oc465d0e1818;
      // 68: lload 3
      // 69: dload 6
      // 6b: dload 8
      // 6d: dload 10
      // 6f: invokevirtual x/oc47731c13e2.ü (Lx/oc465d0e1818;JDDD)Z
      // 72: ifeq 7e
      // 75: aload 1
      // 76: bipush 1
      // 77: invokevirtual x/oc68d6b191af.setCanceled (Z)V
      // 7a: goto 7e
      // 7d: athrow
      // 7e: return
   }

   private void Ă(S27PacketExplosion param1, long param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc47731c13e2.ů I
      // 03: aload 1
      // 04: invokevirtual net/minecraft/network/play/server/S27PacketExplosion.func_149149_c ()F
      // 07: f2d
      // 08: dstore 5
      // 0a: istore 4
      // 0c: aload 1
      // 0d: invokevirtual net/minecraft/network/play/server/S27PacketExplosion.func_149144_d ()F
      // 10: f2d
      // 11: dstore 7
      // 13: iload 4
      // 15: aload 1
      // 16: invokevirtual net/minecraft/network/play/server/S27PacketExplosion.func_149147_e ()F
      // 19: f2d
      // 1a: dstore 9
      // 1c: ifne 45
      // 1f: aload 0
      // 20: getstatic x/oc465d0e1818.Ψ Lx/oc465d0e1818;
      // 23: lload 2
      // 24: dload 5
      // 26: dload 7
      // 28: dload 9
      // 2a: invokevirtual x/oc47731c13e2.ü (Lx/oc465d0e1818;JDDD)Z
      // 2d: ifne 36
      // 30: goto 34
      // 33: athrow
      // 34: return
      // 35: athrow
      // 36: aload 1
      // 37: fconst_0
      // 38: invokevirtual net/minecraft/network/play/server/S27PacketExplosion.setPlayerMotionX (F)V
      // 3b: aload 1
      // 3c: fconst_0
      // 3d: invokevirtual net/minecraft/network/play/server/S27PacketExplosion.setPlayerMotionY (F)V
      // 40: aload 1
      // 41: fconst_0
      // 42: invokevirtual net/minecraft/network/play/server/S27PacketExplosion.setPlayerMotionZ (F)V
      // 45: return
   }

   private boolean ü(oc465d0e1818 var1, long var2, double var4, double var6, double var8) {
      int var10 = ů;
      int var11 = -1301508551 ^ 1274596166;

      while (true) {
         switch (var11) {
            case -917482611:
               return false;
            case -818804385:
               int var17;
               label72: {
                  label71: {
                     try {
                        var17 = о(var4, var6, var8);
                        if (var10 != 0) {
                           break label72;
                        }

                        if (var17 != 0) {
                           break label71;
                        }
                     } catch (ocbde1165e4e var13) {
                        throw var13;
                     }

                     var11 = -2102880053 ^ 1274596166;
                     if (var10 == 0) {
                        continue;
                     }
                  }

                  var17 = 726990008 ^ 1274596166;
               }

               var11 = var17;
               if (var10 == 0) {
                  continue;
               }

               return false;
            case -485618071:
               return true;
            case 890924023:
               break;
            case 938470965:
               this.Թ();
               var11 = -1460222673 ^ 1274596166;
               if (var10 == 0) {
                  continue;
               }
            case 1906859542:
               label85: {
                  label84: {
                     try {
                        this.ų = var1;
                        this.С = var4;
                        this.Ƙ = var6;
                        if (var10 != 0) {
                           break label85;
                        }

                        this.ԡ = var8;
                        this.Ȭ = 0;
                        this.ǉ = (int)this.ϊ.Ӂ();
                        this.Ȏ = 0;
                        if (!this.ӷ.contains(var2)) {
                           break label84;
                        }
                     } catch (ocbde1165e4e var14) {
                        throw var14;
                     }

                     var11 = 1419496488 ^ 1274596166;
                     if (var10 == 0) {
                        continue;
                     }
                  }

                  var11 = 2081891699 ^ 1274596166;
               }

               if (var10 == 0) {
                  continue;
               }
            case 526583662:
               this.Ҟ = oc6aa1f6efb4.ҍ;
               this.S = var2;
               var11 = -1460222673 ^ 1274596166;
               if (var10 == 0) {
                  continue;
               }
               break;
            case 1621899262:
               int var10000;
               label94: {
                  label93: {
                     try {
                        var10000 = this.Ί();
                        if (var10 != 0) {
                           break label94;
                        }

                        if (var10000 == 0) {
                           break label93;
                        }
                     } catch (ocbde1165e4e var15) {
                        throw var15;
                     }

                     var11 = 2128781489 ^ 1274596166;
                     if (var10 == 0) {
                        continue;
                     }
                  }

                  var10000 = 978359632 ^ 1274596166;
               }

               var11 = var10000;
               if (var10 == 0) {
                  continue;
               }
            case -107723393:
               int var16;
               label63: {
                  label62: {
                     try {
                        long var18;
                        var16 = (var18 = var2 - (-509654264717678831L ^ 8713717772137096977L)) == 0L ? 0 : (var18 < 0L ? -1 : 1);
                        if (var10 != 0) {
                           break label63;
                        }

                        if (var16 == 0) {
                           break label62;
                        }
                     } catch (ocbde1165e4e var12) {
                        throw var12;
                     }

                     var11 = -2067086823 ^ 1274596166;
                     if (var10 == 0) {
                        continue;
                     }
                  }

                  var16 = -2102880053 ^ 1274596166;
               }

               var11 = var16;
               if (var10 == 0) {
                  continue;
               }

               return true;
            default:
               throw null;
         }

         this.ĥ(true);
         var11 = 978359632 ^ 1274596166;
      }
   }

   private void Թ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc47731c13e2.ů I
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 30
      // 09: getstatic x/oc6aa1f6efb4.ü Lx/oc6aa1f6efb4;
      // 0c: putfield x/oc47731c13e2.Ҟ Lx/oc6aa1f6efb4;
      // 0f: aload 0
      // 10: bipush 0
      // 11: putfield x/oc47731c13e2.Ȏ I
      // 14: aload 0
      // 15: ldc2_w -4363073224754099866
      // 18: ldc2_w 4860298812100675942
      // 1b: lxor
      // 1c: putfield x/oc47731c13e2.S J
      // 1f: aload 0
      // 20: getfield x/oc6031c5c531.ѥ Lnet/minecraft/client/Minecraft;
      // 23: ifnonnull 2f
      // 26: goto 2a
      // 29: athrow
      // 2a: aconst_null
      // 2b: goto 36
      // 2e: athrow
      // 2f: aload 0
      // 30: getfield x/oc6031c5c531.ѥ Lnet/minecraft/client/Minecraft;
      // 33: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 36: astore 2
      // 37: aload 2
      // 38: iload 1
      // 39: ifne 44
      // 3c: ifnull 69
      // 3f: goto 43
      // 42: athrow
      // 43: aload 2
      // 44: iload 1
      // 45: ifne 57
      // 48: getfield net/minecraft/client/entity/EntityPlayerSP.worldObj Lnet/minecraft/world/World;
      // 4b: ifnull 69
      // 4e: goto 52
      // 51: athrow
      // 52: aload 2
      // 53: goto 57
      // 56: athrow
      // 57: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isInLava ()Z
      // 5a: iload 1
      // 5b: ifne 66
      // 5e: ifeq 69
      // 61: goto 65
      // 64: athrow
      // 65: bipush 1
      // 66: goto 6a
      // 69: bipush 0
      // 6a: istore 3
      // 6b: aload 2
      // 6c: iload 1
      // 6d: ifne 78
      // 70: ifnull e5
      // 73: goto 77
      // 76: athrow
      // 77: aload 2
      // 78: iload 1
      // 79: ifne 8b
      // 7c: getfield net/minecraft/client/entity/EntityPlayerSP.onGround Z
      // 7f: ifeq e5
      // 82: goto 86
      // 85: athrow
      // 86: aload 2
      // 87: goto 8b
      // 8a: athrow
      // 8b: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isInWater ()Z
      // 8e: iload 1
      // 8f: ifne 9a
      // 92: ifne e5
      // 95: goto 99
      // 98: athrow
      // 99: iload 3
      // 9a: iload 1
      // 9b: ifne b5
      // 9e: ifne e5
      // a1: goto a5
      // a4: athrow
      // a5: aload 2
      // a6: iload 1
      // a7: ifne b9
      // aa: goto ae
      // ad: athrow
      // ae: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isRiding ()Z
      // b1: goto b5
      // b4: athrow
      // b5: ifne e5
      // b8: aload 2
      // b9: iload 1
      // ba: ifne e2
      // bd: getfield net/minecraft/client/entity/EntityPlayerSP.movementInput Lnet/minecraft/util/MovementInput;
      // c0: ifnull dd
      // c3: goto c7
      // c6: athrow
      // c7: aload 2
      // c8: iload 1
      // c9: ifne e2
      // cc: goto d0
      // cf: athrow
      // d0: getfield net/minecraft/client/entity/EntityPlayerSP.movementInput Lnet/minecraft/util/MovementInput;
      // d3: getfield net/minecraft/util/MovementInput.jump Z
      // d6: ifne e5
      // d9: goto dd
      // dc: athrow
      // dd: aload 2
      // de: goto e2
      // e1: athrow
      // e2: invokevirtual net/minecraft/client/entity/EntityPlayerSP.jump ()V
      // e5: return
   }

   private void ĥ(boolean param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc47731c13e2.ů I
      // 03: istore 2
      // 04: aload 0
      // 05: iload 2
      // 06: ifne 19
      // 09: getfield x/oc6031c5c531.ѥ Lnet/minecraft/client/Minecraft;
      // 0c: ifnonnull 18
      // 0f: goto 13
      // 12: athrow
      // 13: aconst_null
      // 14: goto 1f
      // 17: athrow
      // 18: aload 0
      // 19: getfield x/oc6031c5c531.ѥ Lnet/minecraft/client/Minecraft;
      // 1c: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1f: astore 3
      // 20: iload 2
      // 21: ifne 6b
      // 24: iload 1
      // 25: ifeq 63
      // 28: goto 2c
      // 2b: athrow
      // 2c: aload 0
      // 2d: iload 2
      // 2e: ifne 68
      // 31: goto 35
      // 34: athrow
      // 35: getfield x/oc47731c13e2.Ȭ I
      // 38: ifne 63
      // 3b: goto 3f
      // 3e: athrow
      // 3f: aload 0
      // 40: iload 2
      // 41: ifne 68
      // 44: goto 48
      // 47: athrow
      // 48: invokevirtual x/oc47731c13e2.Ί ()Z
      // 4b: ifeq 63
      // 4e: goto 52
      // 51: athrow
      // 52: aload 3
      // 53: ifnull 63
      // 56: goto 5a
      // 59: athrow
      // 5a: aload 0
      // 5b: aload 3
      // 5c: invokevirtual x/oc47731c13e2.Ķ (Lnet/minecraft/client/entity/EntityPlayerSP;)V
      // 5f: goto 63
      // 62: athrow
      // 63: aload 0
      // 64: invokevirtual x/oc47731c13e2.Ƈ ()V
      // 67: aload 0
      // 68: invokevirtual x/oc47731c13e2.ʝ ()V
      // 6b: return
   }

   private void p() {
      this.Ƈ();
      this.ʝ();
   }

   private void Ķ(EntityPlayerSP param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc47731c13e2.ů I
      // 03: istore 2
      // 04: aload 0
      // 05: iload 2
      // 06: ifne 3b
      // 09: getfield x/oc47731c13e2.ų Lx/oc465d0e1818;
      // 0c: getstatic x/oc465d0e1818.ͳ Lx/oc465d0e1818;
      // 0f: if_acmpne 36
      // 12: goto 16
      // 15: athrow
      // 16: aload 1
      // 17: aload 0
      // 18: getfield x/oc47731c13e2.С D
      // 1b: putfield net/minecraft/client/entity/EntityPlayerSP.motionX D
      // 1e: iload 2
      // 1f: aload 1
      // 20: aload 0
      // 21: getfield x/oc47731c13e2.Ƙ D
      // 24: putfield net/minecraft/client/entity/EntityPlayerSP.motionY D
      // 27: aload 1
      // 28: aload 0
      // 29: getfield x/oc47731c13e2.ԡ D
      // 2c: putfield net/minecraft/client/entity/EntityPlayerSP.motionZ D
      // 2f: ifeq 6f
      // 32: goto 36
      // 35: athrow
      // 36: aload 0
      // 37: goto 3b
      // 3a: athrow
      // 3b: getfield x/oc47731c13e2.ų Lx/oc465d0e1818;
      // 3e: getstatic x/oc465d0e1818.Ψ Lx/oc465d0e1818;
      // 41: if_acmpne 6f
      // 44: aload 1
      // 45: dup
      // 46: getfield net/minecraft/client/entity/EntityPlayerSP.motionX D
      // 49: aload 0
      // 4a: getfield x/oc47731c13e2.С D
      // 4d: dadd
      // 4e: putfield net/minecraft/client/entity/EntityPlayerSP.motionX D
      // 51: aload 1
      // 52: dup
      // 53: getfield net/minecraft/client/entity/EntityPlayerSP.motionY D
      // 56: aload 0
      // 57: getfield x/oc47731c13e2.Ƙ D
      // 5a: dadd
      // 5b: putfield net/minecraft/client/entity/EntityPlayerSP.motionY D
      // 5e: aload 1
      // 5f: dup
      // 60: getfield net/minecraft/client/entity/EntityPlayerSP.motionZ D
      // 63: aload 0
      // 64: getfield x/oc47731c13e2.ԡ D
      // 67: dadd
      // 68: putfield net/minecraft/client/entity/EntityPlayerSP.motionZ D
      // 6b: goto 6f
      // 6e: athrow
      // 6f: return
   }

   private void Ү(EntityPlayerSP var1) {
      oc47731c13e2 var10000;
      oc6aa1f6efb4 var10001;
      label16: {
         try {
            this.Ķ(var1);
            this.Ȭ++;
            this.ǉ--;
            this.Ȏ = 0;
            var10000 = this;
            if (this.ǉ > 0) {
               var10001 = oc6aa1f6efb4.ü;
               break label16;
            }
         } catch (ocbde1165e4e var2) {
            throw var2;
         }

         var10001 = oc6aa1f6efb4.դ;
      }

      var10000.Ҟ = var10001;
   }

   private void Ƈ() {
      this.ų = oc465d0e1818.E;
      this.Ҟ = oc6aa1f6efb4.Ǥ;
      this.Ȭ = 0;
      this.ǉ = 0;
      this.Ȏ = 0;
      this.S = -986498381367273809L ^ 8236873655487501999L;
      this.С = 0.0;
      this.Ƙ = 0.0;
      this.ԡ = 0.0;
   }

   private void Ď() {
      this.ӷ.clear();
      this.Յ = false;
      this.V = -8284150045291470389L ^ 939221991563305419L;
   }

   private long ͻ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc47731c13e2.ů I
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 18
      // 09: getfield x/oc47731c13e2.Յ Z
      // 0c: ifeq 1e
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: goto 18
      // 17: athrow
      // 18: getfield x/oc47731c13e2.V J
      // 1b: goto 25
      // 1e: ldc2_w 2966709252711967504
      // 21: ldc2_w -6256662784142808304
      // 24: lxor
      // 25: lstore 2
      // 26: aload 0
      // 27: bipush 0
      // 28: putfield x/oc47731c13e2.Յ Z
      // 2b: aload 0
      // 2c: ldc2_w 2966709252711967504
      // 2f: ldc2_w -6256662784142808304
      // 32: lxor
      // 33: putfield x/oc47731c13e2.V J
      // 36: lload 2
      // 37: lreturn
   }

   private void ƣ(S32PacketConfirmTransaction param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc47731c13e2.ů I
      // 03: istore 2
      // 04: aload 1
      // 05: iload 2
      // 06: ifne 26
      // 09: invokevirtual net/minecraft/network/play/server/S32PacketConfirmTransaction.func_148888_e ()Z
      // 0c: ifeq 25
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: bipush 0
      // 15: putfield x/oc47731c13e2.Յ Z
      // 18: aload 0
      // 19: ldc2_w -2760412949081419717
      // 1c: ldc2_w 6462959087773356091
      // 1f: lxor
      // 20: putfield x/oc47731c13e2.V J
      // 23: return
      // 24: athrow
      // 25: aload 1
      // 26: invokestatic x/oc47731c13e2.Ǹ (Lnet/minecraft/network/play/server/S32PacketConfirmTransaction;)J
      // 29: lstore 3
      // 2a: aload 0
      // 2b: getfield x/oc47731c13e2.ӷ Ljava/util/Set;
      // 2e: iload 2
      // 2f: ifne 95
      // 32: invokeinterface java/util/Set.size ()I 1
      // 37: ldc_w -780023047
      // 3a: ldc_w -780023175
      // 3d: ixor
      // 3e: if_icmplt 91
      // 41: goto 45
      // 44: athrow
      // 45: aload 0
      // 46: getfield x/oc47731c13e2.ӷ Ljava/util/Set;
      // 49: lload 3
      // 4a: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 4d: iload 2
      // 4e: ifne 99
      // 51: goto 55
      // 54: athrow
      // 55: invokeinterface java/util/Set.contains (Ljava/lang/Object;)Z 2
      // 5a: ifne 91
      // 5d: goto 61
      // 60: athrow
      // 61: aload 0
      // 62: getfield x/oc47731c13e2.ӷ Ljava/util/Set;
      // 65: iload 2
      // 66: ifne 95
      // 69: goto 6d
      // 6c: athrow
      // 6d: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 72: astore 5
      // 74: aload 5
      // 76: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 7b: ifeq 91
      // 7e: aload 5
      // 80: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 85: pop
      // 86: aload 5
      // 88: invokeinterface java/util/Iterator.remove ()V 1
      // 8d: goto 91
      // 90: athrow
      // 91: aload 0
      // 92: getfield x/oc47731c13e2.ӷ Ljava/util/Set;
      // 95: lload 3
      // 96: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 99: invokeinterface java/util/Set.add (Ljava/lang/Object;)Z 2
      // 9e: pop
      // 9f: aload 0
      // a0: bipush 1
      // a1: putfield x/oc47731c13e2.Յ Z
      // a4: aload 0
      // a5: lload 3
      // a6: putfield x/oc47731c13e2.V J
      // a9: return
   }

   private void ʝ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc47731c13e2.ů I
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 18
      // 09: getfield x/oc6031c5c531.ѥ Lnet/minecraft/client/Minecraft;
      // 0c: ifnull 26
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: goto 18
      // 17: athrow
      // 18: getfield x/oc6031c5c531.ѥ Lnet/minecraft/client/Minecraft;
      // 1b: invokevirtual net/minecraft/client/Minecraft.getNetHandler ()Lnet/minecraft/client/network/NetHandlerPlayClient;
      // 1e: ifnull 26
      // 21: bipush 1
      // 22: goto 27
      // 25: athrow
      // 26: bipush 0
      // 27: istore 2
      // 28: aload 0
      // 29: getfield x/oc47731c13e2.Ӑ Ljava/util/Deque;
      // 2c: invokeinterface java/util/Deque.pollFirst ()Ljava/lang/Object; 1
      // 31: checkcast net/minecraft/network/play/client/C0FPacketConfirmTransaction
      // 34: dup
      // 35: astore 3
      // 36: ifnull 5e
      // 39: aload 0
      // 3a: getfield x/oc47731c13e2.ӷ Ljava/util/Set;
      // 3d: aload 3
      // 3e: invokestatic x/oc47731c13e2.P (Lnet/minecraft/network/play/client/C0FPacketConfirmTransaction;)J
      // 41: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 44: invokeinterface java/util/Set.remove (Ljava/lang/Object;)Z 2
      // 49: pop
      // 4a: iload 1
      // 4b: ifne 5a
      // 4e: iload 2
      // 4f: ifeq 28
      // 52: goto 56
      // 55: athrow
      // 56: aload 3
      // 57: invokestatic x/ocd6ae010123.ĕ (Lnet/minecraft/network/Packet;)V
      // 5a: iload 1
      // 5b: ifeq 28
      // 5e: return
   }

   private boolean Ί() {
      int var1 = ů;
      int var2 = -1008301372 ^ -1925234989;

      while (true) {
         switch (var2) {
            case -1417025271:
               return true;
            case 236726007:
               return false;
            case 1322890263:
               if (this.Ҟ != oc6aa1f6efb4.Ǥ) {
                  var2 = 649517018 ^ -1925234989;
                  if (var1 == 0) {
                     break;
                  }
               }

               var2 = -2094852060 ^ -1925234989;
               break;
            default:
               throw null;
         }
      }
   }

   private static boolean о(double var0, double var2, double var4) {
      int var6 = ů;
      int var7 = -475800142 ^ 1199290578;

      while (true) {
         switch (var7) {
            case -1139542751:
               int var13;
               label84: {
                  label83: {
                     try {
                        var13 = Double.isFinite(var4);
                        if (var6 != 0) {
                           break label84;
                        }

                        if (var13 == 0) {
                           break label83;
                        }
                     } catch (ocbde1165e4e var11) {
                        throw var11;
                     }

                     var7 = 184878881 ^ 1199290578;
                     if (var6 == 0) {
                        break;
                     }
                  }

                  var13 = 550277140 ^ 1199290578;
               }

               var7 = var13;
               if (var6 == 0) {
                  break;
               }
            case -1529322144:
               int var14;
               label75: {
                  label74: {
                     try {
                        var14 = Double.isFinite(var0);
                        if (var6 != 0) {
                           break label75;
                        }

                        if (var14 == 0) {
                           break label74;
                        }
                     } catch (ocbde1165e4e var10) {
                        throw var10;
                     }

                     var7 = 1713673733 ^ 1199290578;
                     if (var6 == 0) {
                        break;
                     }
                  }

                  var14 = 550277140 ^ 1199290578;
               }

               var7 = var14;
               break;
            case 559886039:
               int var12;
               label66: {
                  label65: {
                     try {
                        var12 = Double.isFinite(var2);
                        if (var6 != 0) {
                           break label66;
                        }

                        if (var12 == 0) {
                           break label65;
                        }
                     } catch (ocbde1165e4e var9) {
                        throw var9;
                     }

                     var7 = -77050381 ^ 1199290578;
                     if (var6 == 0) {
                        break;
                     }
                  }

                  var12 = 550277140 ^ 1199290578;
               }

               var7 = var12;
               if (var6 == 0) {
                  break;
               }
            case 579349472:
               return true;
            case 1283375091:
               int var10000;
               label57: {
                  label56: {
                     try {
                        double var15;
                        var10000 = (var15 = var2 - 0.05) == 0.0 ? 0 : (var15 < 0.0 ? -1 : 1);
                        if (var6 != 0) {
                           break label57;
                        }

                        if (var10000 <= 0) {
                           break label56;
                        }
                     } catch (ocbde1165e4e var8) {
                        throw var8;
                     }

                     var7 = 1710461746 ^ 1199290578;
                     if (var6 == 0) {
                        break;
                     }
                  }

                  var10000 = 550277140 ^ 1199290578;
               }

               var7 = var10000;
               if (var6 == 0) {
                  break;
               }
            case 1740056774:
               return false;
            default:
               throw null;
         }
      }
   }

   private static long Ǹ(S32PacketConfirmTransaction var0) {
      return и(var0.getWindowId(), var0.getActionNumber());
   }

   private static long P(C0FPacketConfirmTransaction var0) {
      return и(var0.getWindowId(), var0.getUid());
   }

   private static long и(int var0, short var1) {
      return (long)var0 << (-1791561995 ^ -1791562011) | var1 & (1245498218483972083L ^ 1245498218483976204L);
   }
}
