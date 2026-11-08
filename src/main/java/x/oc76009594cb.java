package x;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import net.minecraft.network.Packet;

public class oc76009594cb {
   private static final long ҭ = TimeUnit.MILLISECONDS.toNanos(-249641945853250536L ^ -249641945853250418L);
   private static final int ѵ = 64;
   private final Deque<Packet<?>> З = new ArrayDeque<>();
   private final Consumer<Packet<?>> L;
   private boolean ѡ;
   private boolean л = true;
   private boolean Ҫ;
   private long Ϭ;
   public static int N;

   public oc76009594cb(Consumer<Packet<?>> var1) {
      this.L = var1;
   }

   public boolean Տ(Packet<?> param1, boolean param2, int param3, long param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc76009594cb.N I
      // 003: istore 6
      // 005: aload 0
      // 006: iload 6
      // 008: ifne 019
      // 00b: getfield x/oc76009594cb.ѡ Z
      // 00e: ifeq 018
      // 011: goto 015
      // 014: athrow
      // 015: bipush 0
      // 016: ireturn
      // 017: athrow
      // 018: aload 0
      // 019: lload 4
      // 01b: invokevirtual x/oc76009594cb.Ԏ (J)V
      // 01e: aload 1
      // 01f: iload 6
      // 021: ifne 093
      // 024: instanceof net/minecraft/network/play/client/C0FPacketConfirmTransaction
      // 027: ifeq 092
      // 02a: goto 02e
      // 02d: athrow
      // 02e: aload 0
      // 02f: getfield x/oc76009594cb.Ҫ Z
      // 032: iload 6
      // 034: ifne 096
      // 037: goto 03b
      // 03a: athrow
      // 03b: ifeq 092
      // 03e: goto 042
      // 041: athrow
      // 042: aload 0
      // 043: iload 6
      // 045: ifne 068
      // 048: goto 04c
      // 04b: athrow
      // 04c: getfield x/oc76009594cb.З Ljava/util/Deque;
      // 04f: invokeinterface java/util/Deque.size ()I 1
      // 054: ldc -345481241
      // 056: ldc -345481305
      // 058: ixor
      // 059: if_icmplt 067
      // 05c: goto 060
      // 05f: athrow
      // 060: aload 0
      // 061: invokevirtual x/oc76009594cb.q ()V
      // 064: bipush 0
      // 065: ireturn
      // 066: athrow
      // 067: aload 0
      // 068: iload 6
      // 06a: ifne 087
      // 06d: getfield x/oc76009594cb.З Ljava/util/Deque;
      // 070: invokeinterface java/util/Deque.isEmpty ()Z 1
      // 075: ifeq 086
      // 078: goto 07c
      // 07b: athrow
      // 07c: aload 0
      // 07d: lload 4
      // 07f: putfield x/oc76009594cb.Ϭ J
      // 082: goto 086
      // 085: athrow
      // 086: aload 0
      // 087: getfield x/oc76009594cb.З Ljava/util/Deque;
      // 08a: aload 1
      // 08b: invokeinterface java/util/Deque.addLast (Ljava/lang/Object;)V 2
      // 090: bipush 1
      // 091: ireturn
      // 092: aload 1
      // 093: instanceof net/minecraft/network/play/client/C03PacketPlayer
      // 096: iload 6
      // 098: ifne 0ab
      // 09b: ifne 0aa
      // 09e: goto 0a2
      // 0a1: athrow
      // 0a2: aload 0
      // 0a3: aload 1
      // 0a4: invokevirtual x/oc76009594cb.ʉ (Lnet/minecraft/network/Packet;)V
      // 0a7: bipush 0
      // 0a8: ireturn
      // 0a9: athrow
      // 0aa: iload 2
      // 0ab: iload 6
      // 0ad: ifne 0bf
      // 0b0: ifeq 0f2
      // 0b3: goto 0b7
      // 0b6: athrow
      // 0b7: aload 0
      // 0b8: getfield x/oc76009594cb.л Z
      // 0bb: goto 0bf
      // 0be: athrow
      // 0bf: iload 6
      // 0c1: ifne 0cc
      // 0c4: ifne 0f2
      // 0c7: goto 0cb
      // 0ca: athrow
      // 0cb: iload 3
      // 0cc: iload 6
      // 0ce: ifne 0d9
      // 0d1: iflt 0f2
      // 0d4: goto 0d8
      // 0d7: athrow
      // 0d8: iload 3
      // 0d9: iload 6
      // 0db: ifne 0ef
      // 0de: ldc -345481298
      // 0e0: ldc -345481305
      // 0e2: ixor
      // 0e3: if_icmpge 0f2
      // 0e6: goto 0ea
      // 0e9: athrow
      // 0ea: bipush 1
      // 0eb: goto 0ef
      // 0ee: athrow
      // 0ef: goto 0f3
      // 0f2: bipush 0
      // 0f3: istore 7
      // 0f5: iload 6
      // 0f7: ifne 133
      // 0fa: aload 0
      // 0fb: bipush 0
      // 0fc: putfield x/oc76009594cb.л Z
      // 0ff: aload 0
      // 100: bipush 0
      // 101: putfield x/oc76009594cb.Ҫ Z
      // 104: iload 7
      // 106: ifne 129
      // 109: goto 10d
      // 10c: athrow
      // 10d: aload 0
      // 10e: iload 6
      // 110: ifne 12a
      // 113: goto 117
      // 116: athrow
      // 117: getfield x/oc76009594cb.З Ljava/util/Deque;
      // 11a: invokeinterface java/util/Deque.isEmpty ()Z 1
      // 11f: ifeq 129
      // 122: goto 126
      // 125: athrow
      // 126: bipush 0
      // 127: ireturn
      // 128: athrow
      // 129: aload 0
      // 12a: bipush 1
      // 12b: putfield x/oc76009594cb.ѡ Z
      // 12e: iload 6
      // 130: ifne 168
      // 133: iload 7
      // 135: ifeq 155
      // 138: aload 0
      // 139: getfield x/oc76009594cb.L Ljava/util/function/Consumer;
      // 13c: new net/minecraft/network/play/client/C09PacketHeldItemChange
      // 13f: dup
      // 140: iload 3
      // 141: bipush 1
      // 142: iadd
      // 143: ldc -345481298
      // 145: ldc -345481305
      // 147: ixor
      // 148: irem
      // 149: invokespecial net/minecraft/network/play/client/C09PacketHeldItemChange.<init> (I)V
      // 14c: invokeinterface java/util/function/Consumer.accept (Ljava/lang/Object;)V 2
      // 151: goto 155
      // 154: athrow
      // 155: aload 0
      // 156: getfield x/oc76009594cb.L Ljava/util/function/Consumer;
      // 159: aload 1
      // 15a: invokeinterface java/util/function/Consumer.accept (Ljava/lang/Object;)V 2
      // 15f: iload 6
      // 161: ifne 1b5
      // 164: aload 0
      // 165: invokevirtual x/oc76009594cb.ȃ ()V
      // 168: iload 7
      // 16a: ifeq 1b0
      // 16d: aload 0
      // 16e: getfield x/oc76009594cb.L Ljava/util/function/Consumer;
      // 171: new net/minecraft/network/play/client/C09PacketHeldItemChange
      // 174: dup
      // 175: iload 3
      // 176: invokespecial net/minecraft/network/play/client/C09PacketHeldItemChange.<init> (I)V
      // 179: invokeinterface java/util/function/Consumer.accept (Ljava/lang/Object;)V 2
      // 17e: aload 0
      // 17f: bipush 1
      // 180: putfield x/oc76009594cb.Ҫ Z
      // 183: goto 1b0
      // 186: athrow
      // 187: astore 8
      // 189: iload 6
      // 18b: ifne 1a8
      // 18e: iload 7
      // 190: ifeq 1ad
      // 193: aload 0
      // 194: getfield x/oc76009594cb.L Ljava/util/function/Consumer;
      // 197: new net/minecraft/network/play/client/C09PacketHeldItemChange
      // 19a: dup
      // 19b: iload 3
      // 19c: invokespecial net/minecraft/network/play/client/C09PacketHeldItemChange.<init> (I)V
      // 19f: invokeinterface java/util/function/Consumer.accept (Ljava/lang/Object;)V 2
      // 1a4: goto 1a8
      // 1a7: athrow
      // 1a8: aload 0
      // 1a9: bipush 1
      // 1aa: putfield x/oc76009594cb.Ҫ Z
      // 1ad: aload 8
      // 1af: athrow
      // 1b0: aload 0
      // 1b1: bipush 0
      // 1b2: putfield x/oc76009594cb.ѡ Z
      // 1b5: goto 1c2
      // 1b8: astore 9
      // 1ba: aload 0
      // 1bb: bipush 0
      // 1bc: putfield x/oc76009594cb.ѡ Z
      // 1bf: aload 9
      // 1c1: athrow
      // 1c2: bipush 1
      // 1c3: ireturn
   }

   public void ʉ(Packet<?> param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc76009594cb.N I
      // 03: istore 2
      // 04: aload 0
      // 05: getfield x/oc76009594cb.ѡ Z
      // 08: iload 2
      // 09: ifne 20
      // 0c: ifeq 14
      // 0f: goto 13
      // 12: athrow
      // 13: return
      // 14: aload 1
      // 15: iload 2
      // 16: ifne 35
      // 19: instanceof net/minecraft/network/play/client/C03PacketPlayer
      // 1c: goto 20
      // 1f: athrow
      // 20: ifeq 30
      // 23: aload 0
      // 24: bipush 0
      // 25: putfield x/oc76009594cb.л Z
      // 28: iload 2
      // 29: ifeq b6
      // 2c: goto 30
      // 2f: athrow
      // 30: aload 1
      // 31: goto 35
      // 34: athrow
      // 35: iload 2
      // 36: ifne 48
      // 39: instanceof net/minecraft/network/play/client/C02PacketUseEntity
      // 3c: ifne ad
      // 3f: goto 43
      // 42: athrow
      // 43: aload 1
      // 44: goto 48
      // 47: athrow
      // 48: iload 2
      // 49: ifne 5b
      // 4c: instanceof net/minecraft/network/play/client/C07PacketPlayerDigging
      // 4f: ifne ad
      // 52: goto 56
      // 55: athrow
      // 56: aload 1
      // 57: goto 5b
      // 5a: athrow
      // 5b: iload 2
      // 5c: ifne 6e
      // 5f: instanceof net/minecraft/network/play/client/C08PacketPlayerBlockPlacement
      // 62: ifne ad
      // 65: goto 69
      // 68: athrow
      // 69: aload 1
      // 6a: goto 6e
      // 6d: athrow
      // 6e: iload 2
      // 6f: ifne 81
      // 72: instanceof net/minecraft/network/play/client/C09PacketHeldItemChange
      // 75: ifne ad
      // 78: goto 7c
      // 7b: athrow
      // 7c: aload 1
      // 7d: goto 81
      // 80: athrow
      // 81: iload 2
      // 82: ifne 94
      // 85: instanceof net/minecraft/network/play/client/C0BPacketEntityAction
      // 88: ifne ad
      // 8b: goto 8f
      // 8e: athrow
      // 8f: aload 1
      // 90: goto 94
      // 93: athrow
      // 94: iload 2
      // 95: ifne a7
      // 98: instanceof net/minecraft/network/play/client/C0EPacketClickWindow
      // 9b: ifne ad
      // 9e: goto a2
      // a1: athrow
      // a2: aload 1
      // a3: goto a7
      // a6: athrow
      // a7: instanceof net/minecraft/network/play/client/C16PacketClientStatus
      // aa: ifeq b6
      // ad: aload 0
      // ae: bipush 1
      // af: putfield x/oc76009594cb.л Z
      // b2: goto b6
      // b5: athrow
      // b6: return
   }

   public void Ԏ(long param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc76009594cb.N I
      // 03: istore 3
      // 04: aload 0
      // 05: getfield x/oc76009594cb.З Ljava/util/Deque;
      // 08: invokeinterface java/util/Deque.isEmpty ()Z 1
      // 0d: iload 3
      // 0e: ifne 26
      // 11: ifne 31
      // 14: goto 18
      // 17: athrow
      // 18: lload 1
      // 19: aload 0
      // 1a: getfield x/oc76009594cb.Ϭ J
      // 1d: lsub
      // 1e: getstatic x/oc76009594cb.ҭ J
      // 21: lcmp
      // 22: goto 26
      // 25: athrow
      // 26: iflt 31
      // 29: aload 0
      // 2a: invokevirtual x/oc76009594cb.q ()V
      // 2d: goto 31
      // 30: athrow
      // 31: return
   }

   public void q() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc76009594cb.N I
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 24
      // 09: getfield x/oc76009594cb.ѡ Z
      // 0c: ifeq 15
      // 0f: goto 13
      // 12: athrow
      // 13: return
      // 14: athrow
      // 15: aload 0
      // 16: bipush 1
      // 17: putfield x/oc76009594cb.ѡ Z
      // 1a: aload 0
      // 1b: invokevirtual x/oc76009594cb.ȃ ()V
      // 1e: aload 0
      // 1f: bipush 0
      // 20: putfield x/oc76009594cb.Ҫ Z
      // 23: aload 0
      // 24: bipush 0
      // 25: putfield x/oc76009594cb.ѡ Z
      // 28: goto 33
      // 2b: astore 2
      // 2c: aload 0
      // 2d: bipush 0
      // 2e: putfield x/oc76009594cb.ѡ Z
      // 31: aload 2
      // 32: athrow
      // 33: return
   }

   private void ȃ() {
      int var1 = N;

      oc76009594cb var10000;
      while (true) {
         if (!this.З.isEmpty()) {
            try {
               var10000 = this;
               if (var1 != 0) {
                  break;
               }

               this.L.accept(this.З.removeFirst());
               if (var1 == 0) {
                  continue;
               }
            } catch (ocbde1165e4e var2) {
               throw var2;
            }
         }

         var10000 = this;
         break;
      }

      var10000.Ϭ = 0L;
   }

   public void Ɲ() {
      this.З.clear();
      this.л = true;
      this.Ҫ = false;
      this.Ϭ = 0L;
   }
}
