package x;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.LongSupplier;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;

public class ocfa8b80a093 {
   public static final long Ή = 400L;
   public static final long ҕ = 200L;
   public static final int Ǟ = 2;
   public static final int ʫ = 3;
   private final Consumer<Packet<?>> ȭ;
   private final LongSupplier ջ;
   private final Random Է;
   private int Ř;
   private int Λ;
   private int ȇ = -1;
   private int ϖ = -1;
   private long ʢ;
   private long ú = 547843006987764642L ^ 547843006987764274L;
   private int Ō = 418928845 ^ 418928809;
   private int Ϸ = 418928845 ^ 418928809;
   private int M = 418928845 ^ 418928809;
   private boolean û = false;
   private boolean ȡ = false;
   private boolean ǒ = false;
   public static boolean đ;

   public ocfa8b80a093(Consumer<Packet<?>> var1) {
      this(var1, System::currentTimeMillis, new Random());
   }

   public ocfa8b80a093(Consumer<Packet<?>> var1, LongSupplier var2, Random var3) {
      this.ȭ = var1;
      this.ջ = var2;
      this.Է = var3;
   }

   public void Ő(Packet<?> param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 00: getstatic x/oc76009594cb.N I
      // 03: istore 2
      // 04: aload 1
      // 05: iload 2
      // 06: ifne 7a
      // 09: instanceof net/minecraft/network/play/client/C02PacketUseEntity
      // 0c: ifeq 75
      // 0f: goto 13
      // 12: athrow
      // 13: aload 1
      // 14: checkcast net/minecraft/network/play/client/C02PacketUseEntity
      // 17: astore 3
      // 18: aload 3
      // 19: invokevirtual net/minecraft/network/play/client/C02PacketUseEntity.getAction ()Lnet/minecraft/network/play/client/C02PacketUseEntity$Action;
      // 1c: iload 2
      // 1d: ifne 47
      // 20: getstatic net/minecraft/network/play/client/C02PacketUseEntity$Action.ATTACK Lnet/minecraft/network/play/client/C02PacketUseEntity$Action;
      // 23: if_acmpne 37
      // 26: goto 2a
      // 29: athrow
      // 2a: aload 0
      // 2b: bipush 0
      // 2c: putfield x/ocfa8b80a093.Ō I
      // 2f: iload 2
      // 30: ifeq 71
      // 33: goto 37
      // 36: athrow
      // 37: aload 3
      // 38: iload 2
      // 39: ifne 52
      // 3c: goto 40
      // 3f: athrow
      // 40: invokevirtual net/minecraft/network/play/client/C02PacketUseEntity.getAction ()Lnet/minecraft/network/play/client/C02PacketUseEntity$Action;
      // 43: goto 47
      // 46: athrow
      // 47: getstatic net/minecraft/network/play/client/C02PacketUseEntity$Action.INTERACT Lnet/minecraft/network/play/client/C02PacketUseEntity$Action;
      // 4a: if_acmpeq 5b
      // 4d: aload 3
      // 4e: goto 52
      // 51: athrow
      // 52: invokevirtual net/minecraft/network/play/client/C02PacketUseEntity.getAction ()Lnet/minecraft/network/play/client/C02PacketUseEntity$Action;
      // 55: getstatic net/minecraft/network/play/client/C02PacketUseEntity$Action.INTERACT_AT Lnet/minecraft/network/play/client/C02PacketUseEntity$Action;
      // 58: if_acmpne 68
      // 5b: aload 0
      // 5c: bipush 0
      // 5d: putfield x/ocfa8b80a093.Ϸ I
      // 60: iload 2
      // 61: ifeq 71
      // 64: goto 68
      // 67: athrow
      // 68: aload 0
      // 69: bipush 0
      // 6a: putfield x/ocfa8b80a093.Ō I
      // 6d: goto 71
      // 70: athrow
      // 71: iload 2
      // 72: ifeq c4
      // 75: aload 1
      // 76: goto 7a
      // 79: athrow
      // 7a: iload 2
      // 7b: ifne 9a
      // 7e: instanceof net/minecraft/network/play/client/C08PacketPlayerBlockPlacement
      // 81: ifeq 95
      // 84: goto 88
      // 87: athrow
      // 88: aload 0
      // 89: bipush 0
      // 8a: putfield x/ocfa8b80a093.Ϸ I
      // 8d: iload 2
      // 8e: ifeq c4
      // 91: goto 95
      // 94: athrow
      // 95: aload 1
      // 96: goto 9a
      // 99: athrow
      // 9a: iload 2
      // 9b: ifne ad
      // 9e: instanceof net/minecraft/network/play/client/C07PacketPlayerDigging
      // a1: ifeq c4
      // a4: goto a8
      // a7: athrow
      // a8: aload 1
      // a9: goto ad
      // ac: athrow
      // ad: checkcast net/minecraft/network/play/client/C07PacketPlayerDigging
      // b0: astore 3
      // b1: aload 3
      // b2: invokevirtual net/minecraft/network/play/client/C07PacketPlayerDigging.getStatus ()Lnet/minecraft/network/play/client/C07PacketPlayerDigging$Action;
      // b5: getstatic net/minecraft/network/play/client/C07PacketPlayerDigging$Action.RELEASE_USE_ITEM Lnet/minecraft/network/play/client/C07PacketPlayerDigging$Action;
      // b8: if_acmpne c4
      // bb: aload 0
      // bc: bipush 0
      // bd: putfield x/ocfa8b80a093.M I
      // c0: goto c4
      // c3: athrow
      // c4: return
   }

   public boolean ĺ() {
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
      // 05: getfield x/ocfa8b80a093.Ō I
      // 08: iload 1
      // 09: ifne 28
      // 0c: ldc 1462267021
      // 0e: ldc 1462267023
      // 10: ixor
      // 11: if_icmplt 50
      // 14: goto 18
      // 17: athrow
      // 18: aload 0
      // 19: iload 1
      // 1a: ifne 35
      // 1d: goto 21
      // 20: athrow
      // 21: getfield x/ocfa8b80a093.Ϸ I
      // 24: goto 28
      // 27: athrow
      // 28: ldc 1462267021
      // 2a: ldc 1462267023
      // 2c: ixor
      // 2d: if_icmplt 50
      // 30: aload 0
      // 31: goto 35
      // 34: athrow
      // 35: getfield x/ocfa8b80a093.M I
      // 38: iload 1
      // 39: ifne 4d
      // 3c: ldc 1462267021
      // 3e: ldc 1462267023
      // 40: ixor
      // 41: if_icmplt 50
      // 44: goto 48
      // 47: athrow
      // 48: bipush 1
      // 49: goto 4d
      // 4c: athrow
      // 4d: goto 51
      // 50: bipush 0
      // 51: ireturn
   }

   public void Ӵ(boolean var1, boolean var2, boolean var3, boolean var4, int var5, ItemStack[] var6) {
      this.ŏ(var1, var2, var3, var4, false, var5, var6);
   }

   public void ŏ(boolean param1, boolean param2, boolean param3, boolean param4, boolean param5, int param6, ItemStack[] param7) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc76009594cb.N I
      // 003: aload 0
      // 004: iload 5
      // 006: putfield x/ocfa8b80a093.ǒ Z
      // 009: aload 0
      // 00a: dup
      // 00b: getfield x/ocfa8b80a093.Ō I
      // 00e: bipush 1
      // 00f: iadd
      // 010: putfield x/ocfa8b80a093.Ō I
      // 013: aload 0
      // 014: dup
      // 015: getfield x/ocfa8b80a093.Ϸ I
      // 018: bipush 1
      // 019: iadd
      // 01a: putfield x/ocfa8b80a093.Ϸ I
      // 01d: istore 8
      // 01f: aload 0
      // 020: dup
      // 021: getfield x/ocfa8b80a093.M I
      // 024: bipush 1
      // 025: iadd
      // 026: putfield x/ocfa8b80a093.M I
      // 029: aload 0
      // 02a: getfield x/ocfa8b80a093.ջ Ljava/util/function/LongSupplier;
      // 02d: invokeinterface java/util/function/LongSupplier.getAsLong ()J 1
      // 032: lstore 9
      // 034: aload 0
      // 035: iload 8
      // 037: ifne 097
      // 03a: getfield x/ocfa8b80a093.û Z
      // 03d: ifeq 096
      // 040: goto 044
      // 043: athrow
      // 044: aload 0
      // 045: iload 8
      // 047: ifne 07e
      // 04a: goto 04e
      // 04d: athrow
      // 04e: invokevirtual x/ocfa8b80a093.ĺ ()Z
      // 051: ifeq 095
      // 054: goto 058
      // 057: athrow
      // 058: aload 0
      // 059: getfield x/ocfa8b80a093.ȭ Ljava/util/function/Consumer;
      // 05c: new net/minecraft/network/play/client/C09PacketHeldItemChange
      // 05f: dup
      // 060: iload 6
      // 062: invokespecial net/minecraft/network/play/client/C09PacketHeldItemChange.<init> (I)V
      // 065: invokeinterface java/util/function/Consumer.accept (Ljava/lang/Object;)V 2
      // 06a: aload 0
      // 06b: bipush 0
      // 06c: putfield x/ocfa8b80a093.û Z
      // 06f: aload 0
      // 070: invokevirtual x/ocfa8b80a093.ȱ ()V
      // 073: aload 0
      // 074: lload 9
      // 076: putfield x/ocfa8b80a093.ʢ J
      // 079: aload 0
      // 07a: goto 07e
      // 07d: athrow
      // 07e: ldc2_w -4452411751091361054
      // 081: ldc2_w -4452411751091360910
      // 084: lxor
      // 085: aload 0
      // 086: getfield x/ocfa8b80a093.Է Ljava/util/Random;
      // 089: invokevirtual java/util/Random.nextDouble ()D
      // 08c: ldc2_w 200.0
      // 08f: dmul
      // 090: d2l
      // 091: ladd
      // 092: putfield x/ocfa8b80a093.ú J
      // 095: return
      // 096: aload 0
      // 097: getfield x/ocfa8b80a093.Ř I
      // 09a: iload 8
      // 09c: ifne 0dd
      // 09f: ifle 0dc
      // 0a2: goto 0a6
      // 0a5: athrow
      // 0a6: aload 0
      // 0a7: getfield x/ocfa8b80a093.ϖ I
      // 0aa: iload 8
      // 0ac: ifne 0dd
      // 0af: goto 0b3
      // 0b2: athrow
      // 0b3: bipush -1
      // 0b4: if_icmpeq 0dc
      // 0b7: goto 0bb
      // 0ba: athrow
      // 0bb: iload 6
      // 0bd: iload 8
      // 0bf: ifne 0dd
      // 0c2: goto 0c6
      // 0c5: athrow
      // 0c6: aload 0
      // 0c7: getfield x/ocfa8b80a093.ϖ I
      // 0ca: if_icmpeq 0dc
      // 0cd: goto 0d1
      // 0d0: athrow
      // 0d1: aload 0
      // 0d2: invokevirtual x/ocfa8b80a093.ȱ ()V
      // 0d5: aload 0
      // 0d6: bipush 0
      // 0d7: putfield x/ocfa8b80a093.û Z
      // 0da: return
      // 0db: athrow
      // 0dc: iload 1
      // 0dd: iload 8
      // 0df: ifne 0ea
      // 0e2: ifeq 123
      // 0e5: goto 0e9
      // 0e8: athrow
      // 0e9: iload 2
      // 0ea: iload 8
      // 0ec: ifne 0f7
      // 0ef: ifeq 123
      // 0f2: goto 0f6
      // 0f5: athrow
      // 0f6: iload 3
      // 0f7: iload 8
      // 0f9: ifne 105
      // 0fc: ifne 123
      // 0ff: goto 103
      // 102: athrow
      // 103: iload 4
      // 105: iload 8
      // 107: ifne 113
      // 10a: ifne 123
      // 10d: goto 111
      // 110: athrow
      // 111: iload 5
      // 113: iload 8
      // 115: ifne 120
      // 118: ifne 123
      // 11b: goto 11f
      // 11e: athrow
      // 11f: bipush 1
      // 120: goto 124
      // 123: bipush 0
      // 124: istore 11
      // 126: iload 11
      // 128: iload 8
      // 12a: ifne 1a6
      // 12d: ifne 199
      // 130: goto 134
      // 133: athrow
      // 134: aload 0
      // 135: getfield x/ocfa8b80a093.Ř I
      // 138: iload 8
      // 13a: ifne 187
      // 13d: goto 141
      // 140: athrow
      // 141: ifle 186
      // 144: goto 148
      // 147: athrow
      // 148: aload 0
      // 149: iload 8
      // 14b: ifne 182
      // 14e: goto 152
      // 151: athrow
      // 152: invokevirtual x/ocfa8b80a093.ĺ ()Z
      // 155: ifeq 17c
      // 158: goto 15c
      // 15b: athrow
      // 15c: aload 0
      // 15d: iload 6
      // 15f: invokevirtual x/ocfa8b80a093.Ā (I)V
      // 162: iload 8
      // 164: ifeq 186
      // 167: goto 16b
      // 16a: athrow
      // 16b: bipush 0
      // 16c: ifeq 178
      // 16f: goto 173
      // 172: athrow
      // 173: bipush 0
      // 174: goto 179
      // 177: athrow
      // 178: bipush 1
      // 179: putstatic x/oc69da1aa7f5.Ҭ Z
      // 17c: aload 0
      // 17d: bipush 1
      // 17e: putfield x/ocfa8b80a093.û Z
      // 181: aload 0
      // 182: bipush 0
      // 183: putfield x/ocfa8b80a093.Ř I
      // 186: iload 1
      // 187: ifne 198
      // 18a: aload 0
      // 18b: bipush 0
      // 18c: putfield x/ocfa8b80a093.ȡ Z
      // 18f: aload 0
      // 190: lconst_0
      // 191: putfield x/ocfa8b80a093.ʢ J
      // 194: goto 198
      // 197: athrow
      // 198: return
      // 199: aload 0
      // 19a: iload 8
      // 19c: ifne 23f
      // 19f: getfield x/ocfa8b80a093.Ř I
      // 1a2: goto 1a6
      // 1a5: athrow
      // 1a6: ifne 23a
      // 1a9: lload 9
      // 1ab: aload 0
      // 1ac: getfield x/ocfa8b80a093.ʢ J
      // 1af: lsub
      // 1b0: aload 0
      // 1b1: getfield x/ocfa8b80a093.ú J
      // 1b4: lcmp
      // 1b5: iload 8
      // 1b7: ifne 1d6
      // 1ba: goto 1be
      // 1bd: athrow
      // 1be: iflt 2b4
      // 1c1: goto 1c5
      // 1c4: athrow
      // 1c5: aload 0
      // 1c6: iload 8
      // 1c8: ifne 1da
      // 1cb: goto 1cf
      // 1ce: athrow
      // 1cf: invokevirtual x/ocfa8b80a093.ĺ ()Z
      // 1d2: goto 1d6
      // 1d5: athrow
      // 1d6: ifeq 2b4
      // 1d9: aload 0
      // 1da: iload 6
      // 1dc: aload 7
      // 1de: invokevirtual x/ocfa8b80a093.ӑ (I[Lnet/minecraft/item/ItemStack;)I
      // 1e1: istore 12
      // 1e3: iload 8
      // 1e5: ifne 230
      // 1e8: iload 12
      // 1ea: iload 6
      // 1ec: if_icmpeq 235
      // 1ef: goto 1f3
      // 1f2: athrow
      // 1f3: aload 0
      // 1f4: getfield x/ocfa8b80a093.ȭ Ljava/util/function/Consumer;
      // 1f7: new net/minecraft/network/play/client/C09PacketHeldItemChange
      // 1fa: dup
      // 1fb: iload 12
      // 1fd: invokespecial net/minecraft/network/play/client/C09PacketHeldItemChange.<init> (I)V
      // 200: invokeinterface java/util/function/Consumer.accept (Ljava/lang/Object;)V 2
      // 205: aload 0
      // 206: iload 6
      // 208: putfield x/ocfa8b80a093.ϖ I
      // 20b: aload 0
      // 20c: iload 12
      // 20e: putfield x/ocfa8b80a093.ȇ I
      // 211: aload 0
      // 212: ldc 1873828160
      // 214: ldc 1873828162
      // 216: ixor
      // 217: aload 0
      // 218: getfield x/ocfa8b80a093.Է Ljava/util/Random;
      // 21b: ldc 1873828161
      // 21d: ldc 1873828162
      // 21f: ixor
      // 220: invokevirtual java/util/Random.nextInt (I)I
      // 223: iadd
      // 224: putfield x/ocfa8b80a093.Λ I
      // 227: aload 0
      // 228: bipush 1
      // 229: putfield x/ocfa8b80a093.Ř I
      // 22c: goto 230
      // 22f: athrow
      // 230: aload 0
      // 231: bipush 1
      // 232: putfield x/ocfa8b80a093.ȡ Z
      // 235: iload 8
      // 237: ifeq 2b4
      // 23a: aload 0
      // 23b: goto 23f
      // 23e: athrow
      // 23f: iload 8
      // 241: ifne 2ab
      // 244: getfield x/ocfa8b80a093.Ř I
      // 247: aload 0
      // 248: getfield x/ocfa8b80a093.Λ I
      // 24b: if_icmplt 2a6
      // 24e: goto 252
      // 251: athrow
      // 252: aload 0
      // 253: iload 8
      // 255: ifne 29d
      // 258: goto 25c
      // 25b: athrow
      // 25c: invokevirtual x/ocfa8b80a093.ĺ ()Z
      // 25f: ifeq 293
      // 262: goto 266
      // 265: athrow
      // 266: aload 0
      // 267: iload 6
      // 269: invokevirtual x/ocfa8b80a093.Ā (I)V
      // 26c: iload 8
      // 26e: aload 0
      // 26f: lload 9
      // 271: putfield x/ocfa8b80a093.ʢ J
      // 274: aload 0
      // 275: ldc2_w -4452411751091361054
      // 278: ldc2_w -4452411751091360910
      // 27b: lxor
      // 27c: aload 0
      // 27d: getfield x/ocfa8b80a093.Է Ljava/util/Random;
      // 280: invokevirtual java/util/Random.nextDouble ()D
      // 283: ldc2_w 200.0
      // 286: dmul
      // 287: d2l
      // 288: ladd
      // 289: putfield x/ocfa8b80a093.ú J
      // 28c: ifeq 2b4
      // 28f: goto 293
      // 292: athrow
      // 293: aload 0
      // 294: bipush 1
      // 295: putfield x/ocfa8b80a093.û Z
      // 298: aload 0
      // 299: goto 29d
      // 29c: athrow
      // 29d: bipush 0
      // 29e: putfield x/ocfa8b80a093.Ř I
      // 2a1: iload 8
      // 2a3: ifeq 2b4
      // 2a6: aload 0
      // 2a7: goto 2ab
      // 2aa: athrow
      // 2ab: dup
      // 2ac: getfield x/ocfa8b80a093.Ř I
      // 2af: bipush 1
      // 2b0: iadd
      // 2b1: putfield x/ocfa8b80a093.Ř I
      // 2b4: return
   }

   public int ӑ(int param1, ItemStack[] param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc76009594cb.N I
      // 03: iload 1
      // 04: istore 4
      // 06: istore 3
      // 07: aload 2
      // 08: ifnull 65
      // 0b: bipush 0
      // 0c: istore 5
      // 0e: iload 5
      // 10: ldc 1417558355
      // 12: ldc 1417558387
      // 14: ixor
      // 15: if_icmpge 65
      // 18: aload 0
      // 19: getfield x/ocfa8b80a093.Է Ljava/util/Random;
      // 1c: ldc 1417558394
      // 1e: ldc 1417558387
      // 20: ixor
      // 21: invokevirtual java/util/Random.nextInt (I)I
      // 24: istore 6
      // 26: iload 3
      // 27: ifne 8b
      // 2a: iload 3
      // 2b: ifne 61
      // 2e: goto 32
      // 31: athrow
      // 32: iload 6
      // 34: iload 1
      // 35: if_icmpeq 5a
      // 38: goto 3c
      // 3b: athrow
      // 3c: iload 6
      // 3e: aload 2
      // 3f: arraylength
      // 40: if_icmpge 5a
      // 43: goto 47
      // 46: athrow
      // 47: aload 2
      // 48: iload 6
      // 4a: aaload
      // 4b: ifnull 5a
      // 4e: goto 52
      // 51: athrow
      // 52: iload 6
      // 54: istore 4
      // 56: iload 3
      // 57: ifeq 65
      // 5a: iinc 5 1
      // 5d: goto 61
      // 60: athrow
      // 61: iload 3
      // 62: ifeq 0e
      // 65: iload 4
      // 67: iload 3
      // 68: ifne 8d
      // 6b: iload 1
      // 6c: if_icmpne 8b
      // 6f: goto 73
      // 72: athrow
      // 73: iload 1
      // 74: bipush 1
      // 75: iadd
      // 76: aload 0
      // 77: getfield x/ocfa8b80a093.Է Ljava/util/Random;
      // 7a: ldc 1417558395
      // 7c: ldc 1417558387
      // 7e: ixor
      // 7f: invokevirtual java/util/Random.nextInt (I)I
      // 82: iadd
      // 83: ldc 1417558394
      // 85: ldc 1417558387
      // 87: ixor
      // 88: irem
      // 89: istore 4
      // 8b: iload 4
      // 8d: ireturn
   }

   public void Ā(int param1) {
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
      // 05: iload 2
      // 06: ifne 3f
      // 09: getfield x/ocfa8b80a093.Ř I
      // 0c: ifgt 3a
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: iload 2
      // 15: ifne 3f
      // 18: goto 1c
      // 1b: athrow
      // 1c: getfield x/ocfa8b80a093.ȇ I
      // 1f: bipush -1
      // 20: if_icmpne 3a
      // 23: goto 27
      // 26: athrow
      // 27: aload 0
      // 28: iload 2
      // 29: ifne 54
      // 2c: goto 30
      // 2f: athrow
      // 30: getfield x/ocfa8b80a093.û Z
      // 33: ifeq 4f
      // 36: goto 3a
      // 39: athrow
      // 3a: aload 0
      // 3b: goto 3f
      // 3e: athrow
      // 3f: getfield x/ocfa8b80a093.ȭ Ljava/util/function/Consumer;
      // 42: new net/minecraft/network/play/client/C09PacketHeldItemChange
      // 45: dup
      // 46: iload 1
      // 47: invokespecial net/minecraft/network/play/client/C09PacketHeldItemChange.<init> (I)V
      // 4a: invokeinterface java/util/function/Consumer.accept (Ljava/lang/Object;)V 2
      // 4f: aload 0
      // 50: invokevirtual x/ocfa8b80a093.ȱ ()V
      // 53: aload 0
      // 54: bipush 0
      // 55: putfield x/ocfa8b80a093.û Z
      // 58: return
   }

   public void ϒ(int var1) {
      this.ȡ = false;
      this.ǒ = false;
      this.Ā(var1);
   }

   public void B(int var1) {
      this.ȡ = false;
      this.ǒ = false;
      this.Ā(var1);
      int var10000 = oc76009594cb.N;
      this.ʢ = this.ջ.getAsLong();
      this.ú = -3934142921443872730L ^ -3934142921443872130L;
      int var2 = var10000;

      try {
         if (false) {
            oc76009594cb.N = ++var2;
         }
      } catch (ocbde1165e4e var3) {
         throw var3;
      }
   }

   public boolean Ѐ() {
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
      // 06: ifne 2b
      // 09: getfield x/ocfa8b80a093.ȡ Z
      // 0c: ifne 26
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: iload 1
      // 15: ifne 2b
      // 18: goto 1c
      // 1b: athrow
      // 1c: getfield x/ocfa8b80a093.Ř I
      // 1f: ifle 50
      // 22: goto 26
      // 25: athrow
      // 26: aload 0
      // 27: goto 2b
      // 2a: athrow
      // 2b: iload 1
      // 2c: ifne 3e
      // 2f: getfield x/ocfa8b80a093.Ϸ I
      // 32: ifle 50
      // 35: goto 39
      // 38: athrow
      // 39: aload 0
      // 3a: goto 3e
      // 3d: athrow
      // 3e: getfield x/ocfa8b80a093.ǒ Z
      // 41: iload 1
      // 42: ifne 4d
      // 45: ifne 50
      // 48: goto 4c
      // 4b: athrow
      // 4c: bipush 1
      // 4d: goto 51
      // 50: bipush 0
      // 51: ireturn
   }

   public void Ί(boolean var1) {
      this.ȡ = var1;
   }

   public boolean ɰ() {
      return this.ȡ;
   }

   public boolean ȸ() {
      return this.ǒ;
   }

   public void ȱ() {
      this.Ř = 0;
      this.ȇ = -1;
      this.ϖ = -1;
      this.û = false;
   }

   public boolean Ѫ() {
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
      // 05: getfield x/ocfa8b80a093.Ř I
      // 08: iload 1
      // 09: ifne 27
      // 0c: ifgt 26
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: getfield x/ocfa8b80a093.û Z
      // 17: iload 1
      // 18: ifne 27
      // 1b: goto 1f
      // 1e: athrow
      // 1f: ifeq 2a
      // 22: goto 26
      // 25: athrow
      // 26: bipush 1
      // 27: goto 2b
      // 2a: bipush 0
      // 2b: ireturn
   }

   public boolean ž() {
      return this.û;
   }

   public int ũ() {
      return this.Ř;
   }

   public int ʴ() {
      return this.Λ;
   }

   public int ª() {
      return this.ȇ;
   }

   public long Σ() {
      return this.ʢ;
   }

   public long ʛ() {
      return this.ú;
   }

   public int ΐ() {
      return this.Ō;
   }

   public int ʆ() {
      return this.Ϸ;
   }

   public int ҏ() {
      return this.M;
   }

   public void Ɔ(int var1) {
      this.Ō = var1;
   }

   public void ˢ(int var1) {
      this.Ϸ = var1;
   }

   public void ȑ(int var1) {
      this.M = var1;
   }
}
