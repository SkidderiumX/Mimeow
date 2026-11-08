package x;

import java.util.Deque;
import java.util.Iterator;
import net.minecraft.network.Packet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ocd3f0e2b0b5 {
   @NotNull
   private final Deque<oc189360bfdf> ҕ;
   @NotNull
   private final ocacfd09d720 ӊ;
   @Nullable
   private oc3d1d10e2c1 Ǔ = null;

   private ocd3f0e2b0b5(@NotNull Deque<oc189360bfdf> var1, @NotNull ocacfd09d720 var2) {
      this.ҕ = var1;
      this.ӊ = var2;
   }

   private synchronized void Ĉ(@NotNull oc3d1d10e2c1 var1) {
      this.ҕ.add(new ocdfee899164(var1));
   }

   private synchronized boolean с(@Nullable Packet<?> param1, @Nullable oc2f60cd9d1e param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 000: getstatic x/ocbbcd2a57ff.Ӊ I
      // 003: istore 3
      // 004: aload 0
      // 005: iload 3
      // 006: ifne 01d
      // 009: getfield x/ocd3f0e2b0b5.ҕ Ljava/util/Deque;
      // 00c: invokeinterface java/util/Deque.isEmpty ()Z 1
      // 011: ifeq 04f
      // 014: goto 018
      // 017: athrow
      // 018: aload 0
      // 019: goto 01d
      // 01c: athrow
      // 01d: iload 3
      // 01e: ifne 049
      // 021: getfield x/ocd3f0e2b0b5.Ǔ Lx/oc3d1d10e2c1;
      // 024: ifnull 044
      // 027: goto 02b
      // 02a: athrow
      // 02b: aload 0
      // 02c: iload 3
      // 02d: ifne 049
      // 030: goto 034
      // 033: athrow
      // 034: getfield x/ocd3f0e2b0b5.Ǔ Lx/oc3d1d10e2c1;
      // 037: invokevirtual x/oc3d1d10e2c1.Ƞ ()Lx/oc93821aed5f;
      // 03a: invokevirtual x/oc93821aed5f.ə ()Z
      // 03d: ifeq 04f
      // 040: goto 044
      // 043: athrow
      // 044: aload 0
      // 045: goto 049
      // 048: athrow
      // 049: aconst_null
      // 04a: putfield x/ocd3f0e2b0b5.Ǔ Lx/oc3d1d10e2c1;
      // 04d: bipush 0
      // 04e: ireturn
      // 04f: aconst_null
      // 050: astore 4
      // 052: aload 1
      // 053: ifnull 06d
      // 056: new x/oc753ddde3df
      // 059: dup
      // 05a: aload 1
      // 05b: aload 2
      // 05c: invokespecial x/oc753ddde3df.<init> (Lnet/minecraft/network/Packet;Lx/oc2f60cd9d1e;)V
      // 05f: astore 4
      // 061: aload 0
      // 062: getfield x/ocd3f0e2b0b5.ҕ Ljava/util/Deque;
      // 065: aload 4
      // 067: invokeinterface java/util/Deque.add (Ljava/lang/Object;)Z 2
      // 06c: pop
      // 06d: aload 0
      // 06e: getfield x/ocd3f0e2b0b5.Ǔ Lx/oc3d1d10e2c1;
      // 071: astore 5
      // 073: aload 5
      // 075: ifnull 08b
      // 078: aload 5
      // 07a: iload 3
      // 07b: ifne 10a
      // 07e: invokevirtual x/oc3d1d10e2c1.Ƞ ()Lx/oc93821aed5f;
      // 081: invokevirtual x/oc93821aed5f.ə ()Z
      // 084: ifeq 0ee
      // 087: goto 08b
      // 08a: athrow
      // 08b: aload 0
      // 08c: invokevirtual x/ocd3f0e2b0b5.խ ()Lx/oc189360bfdf;
      // 08f: astore 6
      // 091: aload 6
      // 093: iload 3
      // 094: ifne 0a6
      // 097: ifnonnull 0a4
      // 09a: goto 09e
      // 09d: athrow
      // 09e: aconst_null
      // 09f: astore 5
      // 0a1: goto 0ee
      // 0a4: aload 6
      // 0a6: iload 3
      // 0a7: ifne 0ce
      // 0aa: instanceof x/oc753ddde3df
      // 0ad: ifeq 0c8
      // 0b0: goto 0b4
      // 0b3: athrow
      // 0b4: aload 6
      // 0b6: checkcast x/oc753ddde3df
      // 0b9: aload 0
      // 0ba: getfield x/ocd3f0e2b0b5.ӊ Lx/ocacfd09d720;
      // 0bd: invokevirtual x/oc753ddde3df.Ⱥ (Lx/ocacfd09d720;)V
      // 0c0: iload 3
      // 0c1: ifeq 0ea
      // 0c4: goto 0c8
      // 0c7: athrow
      // 0c8: aload 6
      // 0ca: goto 0ce
      // 0cd: athrow
      // 0ce: iload 3
      // 0cf: ifne 0e2
      // 0d2: instanceof x/ocdfee899164
      // 0d5: ifeq 0ea
      // 0d8: goto 0dc
      // 0db: athrow
      // 0dc: aload 6
      // 0de: goto 0e2
      // 0e1: athrow
      // 0e2: checkcast x/ocdfee899164
      // 0e5: invokevirtual x/ocdfee899164.ǳ ()Lx/oc3d1d10e2c1;
      // 0e8: astore 5
      // 0ea: iload 3
      // 0eb: ifeq 073
      // 0ee: goto 0f8
      // 0f1: astore 6
      // 0f3: aload 6
      // 0f5: invokevirtual java/lang/Exception.printStackTrace ()V
      // 0f8: aload 0
      // 0f9: aload 5
      // 0fb: putfield x/ocd3f0e2b0b5.Ǔ Lx/oc3d1d10e2c1;
      // 0fe: aload 0
      // 0ff: iload 3
      // 100: ifne 10e
      // 103: getfield x/ocd3f0e2b0b5.Ǔ Lx/oc3d1d10e2c1;
      // 106: goto 10a
      // 109: athrow
      // 10a: ifnull 1d6
      // 10d: aload 0
      // 10e: iload 3
      // 10f: ifne 124
      // 112: getfield x/ocd3f0e2b0b5.Ǔ Lx/oc3d1d10e2c1;
      // 115: invokevirtual x/oc3d1d10e2c1.З ()Lx/oc6bda5bfdb7;
      // 118: ifnull 1d6
      // 11b: goto 11f
      // 11e: athrow
      // 11f: aload 0
      // 120: goto 124
      // 123: athrow
      // 124: getfield x/ocd3f0e2b0b5.Ǔ Lx/oc3d1d10e2c1;
      // 127: invokevirtual x/oc3d1d10e2c1.З ()Lx/oc6bda5bfdb7;
      // 12a: astore 6
      // 12c: aload 4
      // 12e: ifnull 15f
      // 131: aload 0
      // 132: getfield x/ocd3f0e2b0b5.ҕ Ljava/util/Deque;
      // 135: aload 4
      // 137: invokeinterface java/util/Deque.contains (Ljava/lang/Object;)Z 2
      // 13c: iload 3
      // 13d: ifne 159
      // 140: goto 144
      // 143: athrow
      // 144: ifeq 15f
      // 147: goto 14b
      // 14a: athrow
      // 14b: aload 6
      // 14d: aload 4
      // 14f: lconst_0
      // 150: invokeinterface x/oc6bda5bfdb7.z$31w6dt1tmm7en (Lx/oc753ddde3df;J)Z 4
      // 155: goto 159
      // 158: athrow
      // 159: invokestatic java/lang/Boolean.valueOf (Z)Ljava/lang/Boolean;
      // 15c: goto 160
      // 15f: aconst_null
      // 160: astore 7
      // 162: aload 4
      // 164: iload 3
      // 165: ifne 184
      // 168: ifnull 1b7
      // 16b: goto 16f
      // 16e: athrow
      // 16f: aload 0
      // 170: iload 3
      // 171: ifne 1b8
      // 174: goto 178
      // 177: athrow
      // 178: getfield x/ocd3f0e2b0b5.ҕ Ljava/util/Deque;
      // 17b: invokeinterface java/util/Deque.peekFirst ()Ljava/lang/Object; 1
      // 180: goto 184
      // 183: athrow
      // 184: aload 4
      // 186: if_acmpne 1b7
      // 189: getstatic java/lang/Boolean.FALSE Ljava/lang/Boolean;
      // 18c: aload 7
      // 18e: invokevirtual java/lang/Boolean.equals (Ljava/lang/Object;)Z
      // 191: iload 3
      // 192: ifne 1be
      // 195: goto 199
      // 198: athrow
      // 199: ifeq 1b7
      // 19c: goto 1a0
      // 19f: athrow
      // 1a0: aload 0
      // 1a1: getfield x/ocd3f0e2b0b5.ҕ Ljava/util/Deque;
      // 1a4: invokeinterface java/util/Deque.removeFirst ()Ljava/lang/Object; 1
      // 1a9: pop
      // 1aa: aload 4
      // 1ac: aload 0
      // 1ad: getfield x/ocd3f0e2b0b5.ӊ Lx/ocacfd09d720;
      // 1b0: invokevirtual x/oc753ddde3df.Ⱥ (Lx/ocacfd09d720;)V
      // 1b3: goto 1b7
      // 1b6: athrow
      // 1b7: aload 0
      // 1b8: getfield x/ocd3f0e2b0b5.Ǔ Lx/oc3d1d10e2c1;
      // 1bb: invokevirtual x/oc3d1d10e2c1.ɜ ()Z
      // 1be: iload 3
      // 1bf: ifne 1d7
      // 1c2: ifeq 1d6
      // 1c5: goto 1c9
      // 1c8: athrow
      // 1c9: aload 0
      // 1ca: aload 0
      // 1cb: getfield x/ocd3f0e2b0b5.Ǔ Lx/oc3d1d10e2c1;
      // 1ce: invokevirtual x/ocd3f0e2b0b5.L (Lx/oc3d1d10e2c1;)I
      // 1d1: pop
      // 1d2: goto 1d6
      // 1d5: athrow
      // 1d6: bipush 1
      // 1d7: ireturn
   }

   private synchronized int Ɉ(@NotNull oc3d1d10e2c1 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/ocbbcd2a57ff.Ӊ I
      // 03: istore 2
      // 04: aload 1
      // 05: iload 2
      // 06: ifne 25
      // 09: invokevirtual x/oc3d1d10e2c1.Ƞ ()Lx/oc93821aed5f;
      // 0c: invokevirtual x/oc93821aed5f.ə ()Z
      // 0f: ifeq 19
      // 12: goto 16
      // 15: athrow
      // 16: bipush 0
      // 17: ireturn
      // 18: athrow
      // 19: aload 0
      // 1a: iload 2
      // 1b: ifne 46
      // 1e: getfield x/ocd3f0e2b0b5.Ǔ Lx/oc3d1d10e2c1;
      // 21: goto 25
      // 24: athrow
      // 25: ifnull 41
      // 28: aload 0
      // 29: iload 2
      // 2a: ifne 4a
      // 2d: goto 31
      // 30: athrow
      // 31: getfield x/ocd3f0e2b0b5.Ǔ Lx/oc3d1d10e2c1;
      // 34: invokevirtual x/oc3d1d10e2c1.Ƞ ()Lx/oc93821aed5f;
      // 37: invokevirtual x/oc93821aed5f.ə ()Z
      // 3a: ifeq 49
      // 3d: goto 41
      // 40: athrow
      // 41: aload 0
      // 42: goto 46
      // 45: athrow
      // 46: invokevirtual x/ocd3f0e2b0b5.Ї ()V
      // 49: aload 0
      // 4a: iload 2
      // 4b: ifne 5d
      // 4e: getfield x/ocd3f0e2b0b5.Ǔ Lx/oc3d1d10e2c1;
      // 51: aload 1
      // 52: if_acmpeq 5c
      // 55: goto 59
      // 58: athrow
      // 59: bipush 0
      // 5a: ireturn
      // 5b: athrow
      // 5c: aload 0
      // 5d: aload 1
      // 5e: invokevirtual x/ocd3f0e2b0b5.L (Lx/oc3d1d10e2c1;)I
      // 61: ireturn
   }

   private synchronized boolean Ԗ(@NotNull oc3d1d10e2c1 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/ocbbcd2a57ff.Ӊ I
      // 003: istore 2
      // 004: aload 0
      // 005: iload 2
      // 006: ifne 072
      // 009: getfield x/ocd3f0e2b0b5.Ǔ Lx/oc3d1d10e2c1;
      // 00c: aload 1
      // 00d: if_acmpeq 071
      // 010: goto 014
      // 013: athrow
      // 014: aload 0
      // 015: getfield x/ocd3f0e2b0b5.ҕ Ljava/util/Deque;
      // 018: invokeinterface java/util/Deque.iterator ()Ljava/util/Iterator; 1
      // 01d: astore 3
      // 01e: aload 3
      // 01f: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 024: ifeq 068
      // 027: aload 3
      // 028: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 02d: checkcast x/oc189360bfdf
      // 030: astore 4
      // 032: iload 2
      // 033: ifne 06f
      // 036: aload 4
      // 038: iload 2
      // 039: ifne 050
      // 03c: goto 040
      // 03f: athrow
      // 040: instanceof x/ocdfee899164
      // 043: ifeq 064
      // 046: goto 04a
      // 049: athrow
      // 04a: aload 4
      // 04c: goto 050
      // 04f: athrow
      // 050: checkcast x/ocdfee899164
      // 053: invokevirtual x/ocdfee899164.ǳ ()Lx/oc3d1d10e2c1;
      // 056: aload 1
      // 057: if_acmpne 064
      // 05a: aload 3
      // 05b: invokeinterface java/util/Iterator.remove ()V 1
      // 060: goto 064
      // 063: athrow
      // 064: iload 2
      // 065: ifeq 01e
      // 068: aload 1
      // 069: invokevirtual x/oc3d1d10e2c1.Ƞ ()Lx/oc93821aed5f;
      // 06c: invokevirtual x/oc93821aed5f.å ()V
      // 06f: bipush 1
      // 070: ireturn
      // 071: aload 0
      // 072: getfield x/ocd3f0e2b0b5.ҕ Ljava/util/Deque;
      // 075: invokeinterface java/util/Deque.iterator ()Ljava/util/Iterator; 1
      // 07a: astore 3
      // 07b: aload 3
      // 07c: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 081: ifeq 0c9
      // 084: aload 3
      // 085: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 08a: checkcast x/oc189360bfdf
      // 08d: astore 4
      // 08f: iload 2
      // 090: ifne 0d5
      // 093: aload 4
      // 095: iload 2
      // 096: ifne 0b5
      // 099: goto 09d
      // 09c: athrow
      // 09d: instanceof x/ocdfee899164
      // 0a0: ifeq 0af
      // 0a3: goto 0a7
      // 0a6: athrow
      // 0a7: iload 2
      // 0a8: ifeq 0c9
      // 0ab: goto 0af
      // 0ae: athrow
      // 0af: aload 4
      // 0b1: goto 0b5
      // 0b4: athrow
      // 0b5: instanceof x/oc753ddde3df
      // 0b8: iload 2
      // 0b9: ifne 0c4
      // 0bc: ifeq 0c5
      // 0bf: goto 0c3
      // 0c2: athrow
      // 0c3: bipush 0
      // 0c4: ireturn
      // 0c5: iload 2
      // 0c6: ifeq 07b
      // 0c9: aload 1
      // 0ca: invokevirtual x/oc3d1d10e2c1.Ƞ ()Lx/oc93821aed5f;
      // 0cd: invokevirtual x/oc93821aed5f.å ()V
      // 0d0: aload 0
      // 0d1: aconst_null
      // 0d2: putfield x/ocd3f0e2b0b5.Ǔ Lx/oc3d1d10e2c1;
      // 0d5: aload 0
      // 0d6: getfield x/ocd3f0e2b0b5.ҕ Ljava/util/Deque;
      // 0d9: invokeinterface java/util/Deque.iterator ()Ljava/util/Iterator; 1
      // 0de: astore 3
      // 0df: aload 3
      // 0e0: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 0e5: ifeq 129
      // 0e8: aload 3
      // 0e9: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 0ee: checkcast x/oc189360bfdf
      // 0f1: astore 4
      // 0f3: iload 2
      // 0f4: ifne 12d
      // 0f7: aload 4
      // 0f9: iload 2
      // 0fa: ifne 111
      // 0fd: goto 101
      // 100: athrow
      // 101: instanceof x/ocdfee899164
      // 104: ifeq 125
      // 107: goto 10b
      // 10a: athrow
      // 10b: aload 4
      // 10d: goto 111
      // 110: athrow
      // 111: checkcast x/ocdfee899164
      // 114: invokevirtual x/ocdfee899164.ǳ ()Lx/oc3d1d10e2c1;
      // 117: aload 1
      // 118: if_acmpne 125
      // 11b: aload 3
      // 11c: invokeinterface java/util/Iterator.remove ()V 1
      // 121: goto 125
      // 124: athrow
      // 125: iload 2
      // 126: ifeq 0df
      // 129: aload 0
      // 12a: invokevirtual x/ocd3f0e2b0b5.Ї ()V
      // 12d: bipush 1
      // 12e: ireturn
   }

   private synchronized void Ї() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 00: getstatic x/ocbbcd2a57ff.Ӊ I
      // 03: aload 0
      // 04: getfield x/ocd3f0e2b0b5.Ǔ Lx/oc3d1d10e2c1;
      // 07: astore 2
      // 08: istore 1
      // 09: aload 2
      // 0a: ifnull 17
      // 0d: aload 2
      // 0e: invokevirtual x/oc3d1d10e2c1.Ƞ ()Lx/oc93821aed5f;
      // 11: invokevirtual x/oc93821aed5f.ə ()Z
      // 14: ifeq 72
      // 17: aload 0
      // 18: invokevirtual x/ocd3f0e2b0b5.խ ()Lx/oc189360bfdf;
      // 1b: astore 3
      // 1c: aload 3
      // 1d: iload 1
      // 1e: ifne 2e
      // 21: ifnonnull 2d
      // 24: goto 28
      // 27: athrow
      // 28: aconst_null
      // 29: astore 2
      // 2a: goto 72
      // 2d: aload 3
      // 2e: iload 1
      // 2f: ifne 54
      // 32: instanceof x/oc753ddde3df
      // 35: ifeq 4f
      // 38: goto 3c
      // 3b: athrow
      // 3c: aload 3
      // 3d: checkcast x/oc753ddde3df
      // 40: aload 0
      // 41: getfield x/ocd3f0e2b0b5.ӊ Lx/ocacfd09d720;
      // 44: invokevirtual x/oc753ddde3df.Ⱥ (Lx/ocacfd09d720;)V
      // 47: iload 1
      // 48: ifeq 6e
      // 4b: goto 4f
      // 4e: athrow
      // 4f: aload 3
      // 50: goto 54
      // 53: athrow
      // 54: iload 1
      // 55: ifne 67
      // 58: instanceof x/ocdfee899164
      // 5b: ifeq 6e
      // 5e: goto 62
      // 61: athrow
      // 62: aload 3
      // 63: goto 67
      // 66: athrow
      // 67: checkcast x/ocdfee899164
      // 6a: invokevirtual x/ocdfee899164.ǳ ()Lx/oc3d1d10e2c1;
      // 6d: astore 2
      // 6e: iload 1
      // 6f: ifeq 09
      // 72: goto 7a
      // 75: astore 3
      // 76: aload 3
      // 77: invokevirtual java/lang/Exception.printStackTrace ()V
      // 7a: aload 0
      // 7b: aload 2
      // 7c: putfield x/ocd3f0e2b0b5.Ǔ Lx/oc3d1d10e2c1;
      // 7f: return
   }

   private int L(@NotNull oc3d1d10e2c1 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/ocbbcd2a57ff.Ӊ I
      // 003: aload 1
      // 004: invokevirtual x/oc3d1d10e2c1.З ()Lx/oc6bda5bfdb7;
      // 007: astore 3
      // 008: istore 2
      // 009: aload 3
      // 00a: ifnonnull 010
      // 00d: bipush 0
      // 00e: ireturn
      // 00f: athrow
      // 010: bipush 0
      // 011: istore 4
      // 013: invokestatic java/lang/System.currentTimeMillis ()J
      // 016: lstore 5
      // 018: aload 0
      // 019: getfield x/ocd3f0e2b0b5.ҕ Ljava/util/Deque;
      // 01c: invokeinterface java/util/Deque.isEmpty ()Z 1
      // 021: ifne 103
      // 024: aload 0
      // 025: getfield x/ocd3f0e2b0b5.ҕ Ljava/util/Deque;
      // 028: invokeinterface java/util/Deque.peekFirst ()Ljava/lang/Object; 1
      // 02d: checkcast x/oc189360bfdf
      // 030: astore 7
      // 032: aload 7
      // 034: iload 2
      // 035: ifne 09b
      // 038: instanceof x/ocdfee899164
      // 03b: iload 2
      // 03c: ifne 105
      // 03f: goto 043
      // 042: athrow
      // 043: ifeq 095
      // 046: goto 04a
      // 049: athrow
      // 04a: aload 7
      // 04c: checkcast x/ocdfee899164
      // 04f: invokevirtual x/ocdfee899164.ǳ ()Lx/oc3d1d10e2c1;
      // 052: astore 8
      // 054: iload 2
      // 055: ifne 087
      // 058: aload 8
      // 05a: aload 1
      // 05b: if_acmpeq 079
      // 05e: goto 062
      // 061: athrow
      // 062: aload 8
      // 064: iload 2
      // 065: ifne 086
      // 068: goto 06c
      // 06b: athrow
      // 06c: invokevirtual x/oc3d1d10e2c1.Ƞ ()Lx/oc93821aed5f;
      // 06f: invokevirtual x/oc93821aed5f.ə ()Z
      // 072: ifeq 08b
      // 075: goto 079
      // 078: athrow
      // 079: aload 0
      // 07a: getfield x/ocd3f0e2b0b5.ҕ Ljava/util/Deque;
      // 07d: invokeinterface java/util/Deque.removeFirst ()Ljava/lang/Object; 1
      // 082: goto 086
      // 085: athrow
      // 086: pop
      // 087: iload 2
      // 088: ifeq 018
      // 08b: aload 0
      // 08c: aload 8
      // 08e: putfield x/ocd3f0e2b0b5.Ǔ Lx/oc3d1d10e2c1;
      // 091: iload 2
      // 092: ifeq 103
      // 095: aload 7
      // 097: goto 09b
      // 09a: athrow
      // 09b: iload 2
      // 09c: ifne 0bd
      // 09f: instanceof x/oc753ddde3df
      // 0a2: ifne 0bb
      // 0a5: goto 0a9
      // 0a8: athrow
      // 0a9: aload 0
      // 0aa: getfield x/ocd3f0e2b0b5.ҕ Ljava/util/Deque;
      // 0ad: invokeinterface java/util/Deque.removeFirst ()Ljava/lang/Object; 1
      // 0b2: pop
      // 0b3: iload 2
      // 0b4: ifeq 018
      // 0b7: goto 0bb
      // 0ba: athrow
      // 0bb: aload 7
      // 0bd: checkcast x/oc753ddde3df
      // 0c0: astore 8
      // 0c2: iload 2
      // 0c3: ifne 0ff
      // 0c6: aload 3
      // 0c7: aload 8
      // 0c9: lload 5
      // 0cb: aload 8
      // 0cd: invokevirtual x/oc753ddde3df.ӗ ()J
      // 0d0: lsub
      // 0d1: invokeinterface x/oc6bda5bfdb7.z$31w6dt1tmm7en (Lx/oc753ddde3df;J)Z 4
      // 0d6: ifeq 0e5
      // 0d9: goto 0dd
      // 0dc: athrow
      // 0dd: iload 2
      // 0de: ifeq 103
      // 0e1: goto 0e5
      // 0e4: athrow
      // 0e5: aload 0
      // 0e6: getfield x/ocd3f0e2b0b5.ҕ Ljava/util/Deque;
      // 0e9: invokeinterface java/util/Deque.removeFirst ()Ljava/lang/Object; 1
      // 0ee: pop
      // 0ef: aload 8
      // 0f1: aload 0
      // 0f2: getfield x/ocd3f0e2b0b5.ӊ Lx/ocacfd09d720;
      // 0f5: invokevirtual x/oc753ddde3df.Ⱥ (Lx/ocacfd09d720;)V
      // 0f8: iinc 4 1
      // 0fb: goto 0ff
      // 0fe: athrow
      // 0ff: iload 2
      // 100: ifeq 018
      // 103: iload 4
      // 105: ireturn
   }

   private synchronized int ό() {
      int var10000 = ocbbcd2a57ff.Ӊ;
      int var2 = 0;
      Iterator var3 = this.ҕ.iterator();
      int var1 = var10000;

      while (true) {
         if (var3.hasNext()) {
            oc189360bfdf var4 = (oc189360bfdf)var3.next();

            label24: {
               try {
                  var10000 = var4 instanceof oc753ddde3df;
                  if (var1 != 0) {
                     break;
                  }

                  if (var10000 == 0) {
                     break label24;
                  }
               } catch (ocbde1165e4e var5) {
                  throw var5;
               }

               var2++;
            }

            if (var1 == 0) {
               continue;
            }
         }

         var10000 = var2;
         break;
      }

      return var10000;
   }

   private synchronized void ψ(@NotNull oc3d1d10e2c1 param1, long param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/ocbbcd2a57ff.Ӊ I
      // 03: istore 4
      // 05: aload 0
      // 06: getfield x/ocd3f0e2b0b5.Ǔ Lx/oc3d1d10e2c1;
      // 09: aload 1
      // 0a: if_acmpeq 0f
      // 0d: return
      // 0e: athrow
      // 0f: invokestatic java/lang/System.currentTimeMillis ()J
      // 12: lload 2
      // 13: lsub
      // 14: lstore 5
      // 16: new java/util/ArrayList
      // 19: dup
      // 1a: invokespecial java/util/ArrayList.<init> ()V
      // 1d: astore 7
      // 1f: aload 0
      // 20: getfield x/ocd3f0e2b0b5.ҕ Ljava/util/Deque;
      // 23: invokeinterface java/util/Deque.iterator ()Ljava/util/Iterator; 1
      // 28: astore 8
      // 2a: aload 8
      // 2c: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 31: ifeq ad
      // 34: aload 8
      // 36: iload 4
      // 38: ifne b4
      // 3b: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 40: checkcast x/oc189360bfdf
      // 43: astore 9
      // 45: aload 9
      // 47: iload 4
      // 49: ifne 65
      // 4c: instanceof x/ocdfee899164
      // 4f: ifeq 5f
      // 52: goto 56
      // 55: athrow
      // 56: iload 4
      // 58: ifeq ad
      // 5b: goto 5f
      // 5e: athrow
      // 5f: aload 9
      // 61: goto 65
      // 64: athrow
      // 65: iload 4
      // 67: ifne 7a
      // 6a: instanceof x/oc753ddde3df
      // 6d: ifeq a8
      // 70: goto 74
      // 73: athrow
      // 74: aload 9
      // 76: goto 7a
      // 79: athrow
      // 7a: checkcast x/oc753ddde3df
      // 7d: astore 10
      // 7f: iload 4
      // 81: ifne 9e
      // 84: aload 10
      // 86: invokevirtual x/oc753ddde3df.ӗ ()J
      // 89: lload 5
      // 8b: lcmp
      // 8c: ifgt a8
      // 8f: goto 93
      // 92: athrow
      // 93: aload 8
      // 95: invokeinterface java/util/Iterator.remove ()V 1
      // 9a: goto 9e
      // 9d: athrow
      // 9e: aload 7
      // a0: aload 10
      // a2: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // a7: pop
      // a8: iload 4
      // aa: ifeq 2a
      // ad: aload 7
      // af: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // b4: astore 9
      // b6: aload 9
      // b8: invokeinterface java/util/Iterator.hasNext ()Z 1
      // bd: ifeq da
      // c0: aload 9
      // c2: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // c7: checkcast x/oc753ddde3df
      // ca: astore 10
      // cc: iload 4
      // ce: aload 10
      // d0: aload 0
      // d1: getfield x/ocd3f0e2b0b5.ӊ Lx/ocacfd09d720;
      // d4: invokevirtual x/oc753ddde3df.Ⱥ (Lx/ocacfd09d720;)V
      // d7: ifeq b6
      // da: return
   }

   private synchronized void Û(@NotNull oc3d1d10e2c1 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/ocbbcd2a57ff.Ӊ I
      // 003: new java/util/ArrayList
      // 006: dup
      // 007: invokespecial java/util/ArrayList.<init> ()V
      // 00a: astore 3
      // 00b: istore 2
      // 00c: aload 0
      // 00d: getfield x/ocd3f0e2b0b5.ҕ Ljava/util/Deque;
      // 010: invokeinterface java/util/Deque.iterator ()Ljava/util/Iterator; 1
      // 015: astore 4
      // 017: aload 0
      // 018: getfield x/ocd3f0e2b0b5.Ǔ Lx/oc3d1d10e2c1;
      // 01b: aload 1
      // 01c: if_acmpne 024
      // 01f: bipush 1
      // 020: goto 025
      // 023: athrow
      // 024: bipush 0
      // 025: istore 5
      // 027: bipush 0
      // 028: istore 6
      // 02a: aload 4
      // 02c: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 031: ifeq 11c
      // 034: aload 4
      // 036: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 03b: checkcast x/oc189360bfdf
      // 03e: astore 7
      // 040: iload 2
      // 041: ifne 12a
      // 044: aload 7
      // 046: instanceof x/ocdfee899164
      // 049: iload 2
      // 04a: ifne 0a2
      // 04d: goto 051
      // 050: athrow
      // 051: ifeq 09c
      // 054: goto 058
      // 057: athrow
      // 058: aload 7
      // 05a: checkcast x/ocdfee899164
      // 05d: astore 8
      // 05f: iload 5
      // 061: ifeq 06c
      // 064: iload 2
      // 065: ifeq 11c
      // 068: goto 06c
      // 06b: athrow
      // 06c: aload 8
      // 06e: invokevirtual x/ocdfee899164.ǳ ()Lx/oc3d1d10e2c1;
      // 071: aload 1
      // 072: if_acmpne 087
      // 075: goto 079
      // 078: athrow
      // 079: aload 4
      // 07b: invokeinterface java/util/Iterator.remove ()V 1
      // 080: iload 2
      // 081: bipush 1
      // 082: istore 6
      // 084: ifeq 02a
      // 087: iload 6
      // 089: iload 2
      // 08a: ifne 0a2
      // 08d: ifeq 09c
      // 090: goto 094
      // 093: athrow
      // 094: iload 2
      // 095: ifeq 11c
      // 098: goto 09c
      // 09b: athrow
      // 09c: iload 5
      // 09e: goto 0a2
      // 0a1: athrow
      // 0a2: iload 2
      // 0a3: ifne 0e2
      // 0a6: ifeq 0dc
      // 0a9: goto 0ad
      // 0ac: athrow
      // 0ad: aload 7
      // 0af: instanceof x/oc753ddde3df
      // 0b2: iload 2
      // 0b3: ifne 0e2
      // 0b6: goto 0ba
      // 0b9: athrow
      // 0ba: ifeq 0dc
      // 0bd: goto 0c1
      // 0c0: athrow
      // 0c1: aload 4
      // 0c3: invokeinterface java/util/Iterator.remove ()V 1
      // 0c8: iload 2
      // 0c9: aload 3
      // 0ca: aload 7
      // 0cc: checkcast x/oc753ddde3df
      // 0cf: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 0d4: pop
      // 0d5: ifeq 118
      // 0d8: goto 0dc
      // 0db: athrow
      // 0dc: iload 6
      // 0de: goto 0e2
      // 0e1: athrow
      // 0e2: iload 2
      // 0e3: ifne 0f6
      // 0e6: ifeq 118
      // 0e9: goto 0ed
      // 0ec: athrow
      // 0ed: aload 7
      // 0ef: instanceof x/oc753ddde3df
      // 0f2: goto 0f6
      // 0f5: athrow
      // 0f6: iload 2
      // 0f7: ifne 117
      // 0fa: ifeq 118
      // 0fd: goto 101
      // 100: athrow
      // 101: aload 4
      // 103: invokeinterface java/util/Iterator.remove ()V 1
      // 108: aload 3
      // 109: aload 7
      // 10b: checkcast x/oc753ddde3df
      // 10e: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 113: goto 117
      // 116: athrow
      // 117: pop
      // 118: iload 2
      // 119: ifeq 02a
      // 11c: iload 5
      // 11e: ifeq 12a
      // 121: aload 0
      // 122: aconst_null
      // 123: putfield x/ocd3f0e2b0b5.Ǔ Lx/oc3d1d10e2c1;
      // 126: goto 12a
      // 129: athrow
      // 12a: aload 3
      // 12b: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 130: astore 7
      // 132: aload 7
      // 134: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 139: ifeq 155
      // 13c: aload 7
      // 13e: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 143: checkcast x/oc753ddde3df
      // 146: astore 8
      // 148: iload 2
      // 149: aload 8
      // 14b: aload 0
      // 14c: getfield x/ocd3f0e2b0b5.ӊ Lx/ocacfd09d720;
      // 14f: invokevirtual x/oc753ddde3df.Ⱥ (Lx/ocacfd09d720;)V
      // 152: ifeq 132
      // 155: return
   }

   private synchronized void σ() {
      this.ҕ.clear();
      this.Ǔ = null;
   }

   @Nullable
   private oc189360bfdf խ() {
      return this.ҕ.pollFirst();
   }
}
