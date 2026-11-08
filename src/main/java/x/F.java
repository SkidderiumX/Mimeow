package x;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class F {
   private static final int Ń = 100;
   private static List<oc43fdb4c5d3> Æ = null;
   private static Map<String, List<oc43fdb4c5d3>> и = null;
   private static final Map<Block, Item> ġ = new HashMap<>();
   public static boolean Ҭ;

   public static List<oc43fdb4c5d3> ύ(String param0, oc10354c7bb8 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc75d51ec7eb.ϩ I
      // 003: invokestatic x/F.Լ ()V
      // 006: istore 2
      // 007: aload 0
      // 008: iload 2
      // 009: ifne 021
      // 00c: ifnull 027
      // 00f: goto 013
      // 012: athrow
      // 013: aload 0
      // 014: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 017: iload 2
      // 018: ifne 030
      // 01b: goto 01f
      // 01e: athrow
      // 01f: dup
      // 020: astore 0
      // 021: invokevirtual java/lang/String.isEmpty ()Z
      // 024: ifeq 02c
      // 027: invokestatic java/util/Collections.emptyList ()Ljava/util/List;
      // 02a: areturn
      // 02b: athrow
      // 02c: aload 0
      // 02d: invokevirtual java/lang/String.toLowerCase ()Ljava/lang/String;
      // 030: astore 3
      // 031: new java/util/ArrayList
      // 034: dup
      // 035: invokespecial java/util/ArrayList.<init> ()V
      // 038: astore 4
      // 03a: getstatic x/F.Æ Ljava/util/List;
      // 03d: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 042: astore 5
      // 044: aload 5
      // 046: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 04b: ifeq 20a
      // 04e: aload 5
      // 050: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 055: checkcast x/oc43fdb4c5d3
      // 058: astore 6
      // 05a: iload 2
      // 05b: ifne 230
      // 05e: aload 6
      // 060: getfield x/oc43fdb4c5d3.í Ljava/lang/String;
      // 063: invokevirtual java/lang/String.toLowerCase ()Ljava/lang/String;
      // 066: astore 7
      // 068: aload 6
      // 06a: getfield x/oc43fdb4c5d3.Ȏ Ljava/lang/String;
      // 06d: invokevirtual java/lang/String.toLowerCase ()Ljava/lang/String;
      // 070: astore 8
      // 072: aload 8
      // 074: iload 2
      // 075: ifne 09c
      // 078: ldc 2125387705
      // 07a: ldc 2125387651
      // 07c: ixor
      // 07d: invokevirtual java/lang/String.indexOf (I)I
      // 080: iflt 09f
      // 083: goto 087
      // 086: athrow
      // 087: aload 8
      // 089: aload 8
      // 08b: ldc 2125387705
      // 08d: ldc 2125387651
      // 08f: ixor
      // 090: invokevirtual java/lang/String.indexOf (I)I
      // 093: bipush 1
      // 094: iadd
      // 095: invokevirtual java/lang/String.substring (I)Ljava/lang/String;
      // 098: goto 09c
      // 09b: athrow
      // 09c: goto 0a1
      // 09f: aload 8
      // 0a1: astore 9
      // 0a3: bipush 0
      // 0a4: istore 10
      // 0a6: aload 7
      // 0a8: aload 3
      // 0a9: iload 2
      // 0aa: ifne 0cd
      // 0ad: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 0b0: ifeq 0be
      // 0b3: ldc 2125386859
      // 0b5: ldc 2125387651
      // 0b7: ixor
      // 0b8: istore 10
      // 0ba: iload 2
      // 0bb: ifeq 1ca
      // 0be: aload 9
      // 0c0: iload 2
      // 0c1: ifne 0e4
      // 0c4: goto 0c8
      // 0c7: athrow
      // 0c8: aload 3
      // 0c9: goto 0cd
      // 0cc: athrow
      // 0cd: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 0d0: ifeq 0de
      // 0d3: ldc 2125386759
      // 0d5: ldc 2125387651
      // 0d7: ixor
      // 0d8: istore 10
      // 0da: iload 2
      // 0db: ifeq 1ca
      // 0de: aload 7
      // 0e0: goto 0e4
      // 0e3: athrow
      // 0e4: aload 3
      // 0e5: iload 2
      // 0e6: ifne 10d
      // 0e9: invokevirtual java/lang/String.startsWith (Ljava/lang/String;)Z
      // 0ec: ifeq 0fe
      // 0ef: goto 0f3
      // 0f2: athrow
      // 0f3: ldc 2125386915
      // 0f5: ldc 2125387651
      // 0f7: ixor
      // 0f8: istore 10
      // 0fa: iload 2
      // 0fb: ifeq 1ca
      // 0fe: aload 9
      // 100: iload 2
      // 101: ifne 124
      // 104: goto 108
      // 107: athrow
      // 108: aload 3
      // 109: goto 10d
      // 10c: athrow
      // 10d: invokevirtual java/lang/String.startsWith (Ljava/lang/String;)Z
      // 110: ifeq 11e
      // 113: ldc 2125387071
      // 115: ldc 2125387651
      // 117: ixor
      // 118: istore 10
      // 11a: iload 2
      // 11b: ifeq 1ca
      // 11e: aload 7
      // 120: goto 124
      // 123: athrow
      // 124: ldc "\\s+"
      // 126: invokevirtual java/lang/String.split (Ljava/lang/String;)[Ljava/lang/String;
      // 129: astore 11
      // 12b: aload 11
      // 12d: astore 12
      // 12f: aload 12
      // 131: arraylength
      // 132: istore 13
      // 134: bipush 0
      // 135: istore 14
      // 137: iload 14
      // 139: iload 13
      // 13b: if_icmpge 170
      // 13e: aload 12
      // 140: iload 14
      // 142: aaload
      // 143: astore 15
      // 145: iload 2
      // 146: ifne 16c
      // 149: aload 15
      // 14b: aload 3
      // 14c: iload 2
      // 14d: ifne 0a9
      // 150: goto 154
      // 153: athrow
      // 154: invokevirtual java/lang/String.startsWith (Ljava/lang/String;)Z
      // 157: ifeq 165
      // 15a: ldc 2125387227
      // 15c: ldc 2125387651
      // 15e: ixor
      // 15f: istore 10
      // 161: iload 2
      // 162: ifeq 170
      // 165: iinc 14 1
      // 168: goto 16c
      // 16b: athrow
      // 16c: iload 2
      // 16d: ifeq 137
      // 170: iload 10
      // 172: iload 2
      // 173: ifne 1a3
      // 176: ifne 19d
      // 179: goto 17d
      // 17c: athrow
      // 17d: aload 7
      // 17f: aload 3
      // 180: invokevirtual java/lang/String.contains (Ljava/lang/CharSequence;)Z
      // 183: iload 2
      // 184: ifne 1a3
      // 187: goto 18b
      // 18a: athrow
      // 18b: ifeq 19d
      // 18e: goto 192
      // 191: athrow
      // 192: ldc 2125387383
      // 194: ldc 2125387651
      // 196: ixor
      // 197: istore 10
      // 199: iload 2
      // 19a: ifeq 1ca
      // 19d: iload 10
      // 19f: goto 1a3
      // 1a2: athrow
      // 1a3: iload 2
      // 1a4: ifne 1cc
      // 1a7: ifne 1ca
      // 1aa: goto 1ae
      // 1ad: athrow
      // 1ae: aload 9
      // 1b0: aload 3
      // 1b1: invokevirtual java/lang/String.contains (Ljava/lang/CharSequence;)Z
      // 1b4: iload 2
      // 1b5: ifne 1cc
      // 1b8: goto 1bc
      // 1bb: athrow
      // 1bc: ifeq 1ca
      // 1bf: goto 1c3
      // 1c2: athrow
      // 1c3: ldc 2125387283
      // 1c5: ldc 2125387651
      // 1c7: ixor
      // 1c8: istore 10
      // 1ca: iload 10
      // 1cc: iload 2
      // 1cd: ifne 1e4
      // 1d0: ifle 206
      // 1d3: goto 1d7
      // 1d6: athrow
      // 1d7: aload 1
      // 1d8: aload 6
      // 1da: getfield x/oc43fdb4c5d3.Ȏ Ljava/lang/String;
      // 1dd: invokevirtual x/oc10354c7bb8.Ѣ (Ljava/lang/String;)Z
      // 1e0: goto 1e4
      // 1e3: athrow
      // 1e4: iload 2
      // 1e5: ifne 205
      // 1e8: ifne 206
      // 1eb: goto 1ef
      // 1ee: athrow
      // 1ef: aload 4
      // 1f1: new x/oc25b12192fe
      // 1f4: dup
      // 1f5: aload 6
      // 1f7: iload 10
      // 1f9: invokespecial x/oc25b12192fe.<init> (Lx/oc43fdb4c5d3;I)V
      // 1fc: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 201: goto 205
      // 204: athrow
      // 205: pop
      // 206: iload 2
      // 207: ifeq 044
      // 20a: aload 4
      // 20c: invokedynamic applyAsInt ()Ljava/util/function/ToIntFunction; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)I, x/F.q1sneqz78s1arp (Lx/oc25b12192fe;)I, (Lx/oc25b12192fe;)I ]
      // 211: invokestatic java/util/Comparator.comparingInt (Ljava/util/function/ToIntFunction;)Ljava/util/Comparator;
      // 214: invokedynamic apply ()Ljava/util/function/Function; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Ljava/lang/Object;, x/F.q2gngdzaxp1o41 (Lx/oc25b12192fe;)Ljava/lang/String;, (Lx/oc25b12192fe;)Ljava/lang/String; ]
      // 219: getstatic java/lang/String.CASE_INSENSITIVE_ORDER Ljava/util/Comparator;
      // 21c: invokeinterface java/util/Comparator.thenComparing (Ljava/util/function/Function;Ljava/util/Comparator;)Ljava/util/Comparator; 3
      // 221: invokedynamic apply ()Ljava/util/function/Function; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Ljava/lang/Object;, x/F.q13z035sg61mu1 (Lx/oc25b12192fe;)Ljava/lang/String;, (Lx/oc25b12192fe;)Ljava/lang/String; ]
      // 226: invokeinterface java/util/Comparator.thenComparing (Ljava/util/function/Function;)Ljava/util/Comparator; 2
      // 22b: invokeinterface java/util/List.sort (Ljava/util/Comparator;)V 2
      // 230: new java/util/ArrayList
      // 233: dup
      // 234: ldc 2125387751
      // 236: ldc 2125387651
      // 238: ixor
      // 239: aload 4
      // 23b: invokeinterface java/util/List.size ()I 1
      // 240: invokestatic java/lang/Math.min (II)I
      // 243: invokespecial java/util/ArrayList.<init> (I)V
      // 246: astore 5
      // 248: bipush 0
      // 249: istore 6
      // 24b: iload 6
      // 24d: ldc 2125387751
      // 24f: ldc 2125387651
      // 251: ixor
      // 252: aload 4
      // 254: invokeinterface java/util/List.size ()I 1
      // 259: invokestatic java/lang/Math.min (II)I
      // 25c: if_icmpge 285
      // 25f: aload 5
      // 261: iload 2
      // 262: ifne 287
      // 265: aload 4
      // 267: iload 6
      // 269: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 26e: checkcast x/oc25b12192fe
      // 271: getfield x/oc25b12192fe.ȟ Lx/oc43fdb4c5d3;
      // 274: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 279: pop
      // 27a: iload 2
      // 27b: iinc 6 1
      // 27e: ifeq 24b
      // 281: goto 285
      // 284: athrow
      // 285: aload 5
      // 287: areturn
   }

   public static List<oc3af4427d65> ү(String param0, oc10354c7bb8 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc75d51ec7eb.ϩ I
      // 003: invokestatic x/F.Լ ()V
      // 006: istore 2
      // 007: aload 0
      // 008: iload 2
      // 009: ifne 021
      // 00c: ifnull 027
      // 00f: goto 013
      // 012: athrow
      // 013: aload 0
      // 014: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 017: iload 2
      // 018: ifne 030
      // 01b: goto 01f
      // 01e: athrow
      // 01f: dup
      // 020: astore 0
      // 021: invokevirtual java/lang/String.isEmpty ()Z
      // 024: ifeq 02c
      // 027: invokestatic java/util/Collections.emptyList ()Ljava/util/List;
      // 02a: areturn
      // 02b: athrow
      // 02c: aload 0
      // 02d: invokevirtual java/lang/String.toLowerCase ()Ljava/lang/String;
      // 030: astore 3
      // 031: new java/util/ArrayList
      // 034: dup
      // 035: invokespecial java/util/ArrayList.<init> ()V
      // 038: astore 4
      // 03a: getstatic x/F.Æ Ljava/util/List;
      // 03d: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 042: astore 5
      // 044: aload 5
      // 046: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 04b: ifeq 239
      // 04e: aload 5
      // 050: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 055: goto 059
      // 058: athrow
      // 059: checkcast x/oc43fdb4c5d3
      // 05c: astore 6
      // 05e: iload 2
      // 05f: ifne 25f
      // 062: aload 1
      // 063: aload 6
      // 065: getfield x/oc43fdb4c5d3.Ȏ Ljava/lang/String;
      // 068: invokevirtual x/oc10354c7bb8.Ѣ (Ljava/lang/String;)Z
      // 06b: ifeq 072
      // 06e: goto 044
      // 071: athrow
      // 072: aload 6
      // 074: getfield x/oc43fdb4c5d3.Ȏ Ljava/lang/String;
      // 077: invokestatic x/F.ԙ (Ljava/lang/String;)Ljava/lang/String;
      // 07a: astore 7
      // 07c: aload 7
      // 07e: iload 2
      // 07f: ifne 0a9
      // 082: ifnull 0a1
      // 085: goto 089
      // 088: athrow
      // 089: aload 1
      // 08a: aload 7
      // 08c: ldc ":*"
      // 08e: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 093: invokevirtual x/oc10354c7bb8.Ѣ (Ljava/lang/String;)Z
      // 096: ifeq 0a1
      // 099: goto 09d
      // 09c: athrow
      // 09d: goto 044
      // 0a0: athrow
      // 0a1: aload 6
      // 0a3: getfield x/oc43fdb4c5d3.í Ljava/lang/String;
      // 0a6: invokevirtual java/lang/String.toLowerCase ()Ljava/lang/String;
      // 0a9: astore 8
      // 0ab: aload 6
      // 0ad: getfield x/oc43fdb4c5d3.Ȏ Ljava/lang/String;
      // 0b0: invokevirtual java/lang/String.toLowerCase ()Ljava/lang/String;
      // 0b3: astore 9
      // 0b5: aload 9
      // 0b7: iload 2
      // 0b8: ifne 0df
      // 0bb: ldc -273008795
      // 0bd: ldc -273008801
      // 0bf: ixor
      // 0c0: invokevirtual java/lang/String.indexOf (I)I
      // 0c3: iflt 0e2
      // 0c6: goto 0ca
      // 0c9: athrow
      // 0ca: aload 9
      // 0cc: aload 9
      // 0ce: ldc -273008795
      // 0d0: ldc -273008801
      // 0d2: ixor
      // 0d3: invokevirtual java/lang/String.indexOf (I)I
      // 0d6: bipush 1
      // 0d7: iadd
      // 0d8: invokevirtual java/lang/String.substring (I)Ljava/lang/String;
      // 0db: goto 0df
      // 0de: athrow
      // 0df: goto 0e4
      // 0e2: aload 9
      // 0e4: astore 10
      // 0e6: bipush 0
      // 0e7: istore 11
      // 0e9: aload 8
      // 0eb: aload 3
      // 0ec: iload 2
      // 0ed: ifne 114
      // 0f0: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 0f3: ifeq 105
      // 0f6: goto 0fa
      // 0f9: athrow
      // 0fa: ldc -273009481
      // 0fc: ldc -273008801
      // 0fe: ixor
      // 0ff: istore 11
      // 101: iload 2
      // 102: ifeq 211
      // 105: aload 10
      // 107: iload 2
      // 108: ifne 12b
      // 10b: goto 10f
      // 10e: athrow
      // 10f: aload 3
      // 110: goto 114
      // 113: athrow
      // 114: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 117: ifeq 125
      // 11a: ldc -273009445
      // 11c: ldc -273008801
      // 11e: ixor
      // 11f: istore 11
      // 121: iload 2
      // 122: ifeq 211
      // 125: aload 8
      // 127: goto 12b
      // 12a: athrow
      // 12b: iload 2
      // 12c: ifne 14b
      // 12f: aload 3
      // 130: invokevirtual java/lang/String.startsWith (Ljava/lang/String;)Z
      // 133: ifeq 145
      // 136: goto 13a
      // 139: athrow
      // 13a: ldc -273009537
      // 13c: ldc -273008801
      // 13e: ixor
      // 13f: istore 11
      // 141: iload 2
      // 142: ifeq 211
      // 145: aload 10
      // 147: goto 14b
      // 14a: athrow
      // 14b: iload 2
      // 14c: ifne 16b
      // 14f: aload 3
      // 150: invokevirtual java/lang/String.startsWith (Ljava/lang/String;)Z
      // 153: ifeq 165
      // 156: goto 15a
      // 159: athrow
      // 15a: ldc -273009181
      // 15c: ldc -273008801
      // 15e: ixor
      // 15f: istore 11
      // 161: iload 2
      // 162: ifeq 211
      // 165: aload 8
      // 167: goto 16b
      // 16a: athrow
      // 16b: ldc "\\s+"
      // 16d: invokevirtual java/lang/String.split (Ljava/lang/String;)[Ljava/lang/String;
      // 170: astore 12
      // 172: aload 12
      // 174: astore 13
      // 176: aload 13
      // 178: arraylength
      // 179: istore 14
      // 17b: bipush 0
      // 17c: istore 15
      // 17e: iload 15
      // 180: iload 14
      // 182: if_icmpge 1b7
      // 185: aload 13
      // 187: iload 15
      // 189: aaload
      // 18a: astore 16
      // 18c: iload 2
      // 18d: ifne 1b3
      // 190: aload 16
      // 192: iload 2
      // 193: ifne 059
      // 196: goto 19a
      // 199: athrow
      // 19a: aload 3
      // 19b: invokevirtual java/lang/String.startsWith (Ljava/lang/String;)Z
      // 19e: ifeq 1ac
      // 1a1: ldc -273009401
      // 1a3: ldc -273008801
      // 1a5: ixor
      // 1a6: istore 11
      // 1a8: iload 2
      // 1a9: ifeq 1b7
      // 1ac: iinc 15 1
      // 1af: goto 1b3
      // 1b2: athrow
      // 1b3: iload 2
      // 1b4: ifeq 17e
      // 1b7: iload 11
      // 1b9: iload 2
      // 1ba: ifne 1ea
      // 1bd: ifne 1e4
      // 1c0: goto 1c4
      // 1c3: athrow
      // 1c4: aload 8
      // 1c6: aload 3
      // 1c7: invokevirtual java/lang/String.contains (Ljava/lang/CharSequence;)Z
      // 1ca: iload 2
      // 1cb: ifne 1ea
      // 1ce: goto 1d2
      // 1d1: athrow
      // 1d2: ifeq 1e4
      // 1d5: goto 1d9
      // 1d8: athrow
      // 1d9: ldc -273008981
      // 1db: ldc -273008801
      // 1dd: ixor
      // 1de: istore 11
      // 1e0: iload 2
      // 1e1: ifeq 211
      // 1e4: iload 11
      // 1e6: goto 1ea
      // 1e9: athrow
      // 1ea: iload 2
      // 1eb: ifne 213
      // 1ee: ifne 211
      // 1f1: goto 1f5
      // 1f4: athrow
      // 1f5: aload 10
      // 1f7: aload 3
      // 1f8: invokevirtual java/lang/String.contains (Ljava/lang/CharSequence;)Z
      // 1fb: iload 2
      // 1fc: ifne 213
      // 1ff: goto 203
      // 202: athrow
      // 203: ifeq 211
      // 206: goto 20a
      // 209: athrow
      // 20a: ldc -273008945
      // 20c: ldc -273008801
      // 20e: ixor
      // 20f: istore 11
      // 211: iload 11
      // 213: iload 2
      // 214: ifne 234
      // 217: ifle 235
      // 21a: goto 21e
      // 21d: athrow
      // 21e: aload 4
      // 220: new x/oc25b12192fe
      // 223: dup
      // 224: aload 6
      // 226: iload 11
      // 228: invokespecial x/oc25b12192fe.<init> (Lx/oc43fdb4c5d3;I)V
      // 22b: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 230: goto 234
      // 233: athrow
      // 234: pop
      // 235: iload 2
      // 236: ifeq 044
      // 239: aload 4
      // 23b: invokedynamic applyAsInt ()Ljava/util/function/ToIntFunction; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)I, x/F.q2idzkytfmbq8t (Lx/oc25b12192fe;)I, (Lx/oc25b12192fe;)I ]
      // 240: invokestatic java/util/Comparator.comparingInt (Ljava/util/function/ToIntFunction;)Ljava/util/Comparator;
      // 243: invokedynamic apply ()Ljava/util/function/Function; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Ljava/lang/Object;, x/F.qg0hhzo45g3na (Lx/oc25b12192fe;)Ljava/lang/String;, (Lx/oc25b12192fe;)Ljava/lang/String; ]
      // 248: getstatic java/lang/String.CASE_INSENSITIVE_ORDER Ljava/util/Comparator;
      // 24b: invokeinterface java/util/Comparator.thenComparing (Ljava/util/function/Function;Ljava/util/Comparator;)Ljava/util/Comparator; 3
      // 250: invokedynamic apply ()Ljava/util/function/Function; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Ljava/lang/Object;, x/F.q13o88qs1jka8a (Lx/oc25b12192fe;)Ljava/lang/String;, (Lx/oc25b12192fe;)Ljava/lang/String; ]
      // 255: invokeinterface java/util/Comparator.thenComparing (Ljava/util/function/Function;)Ljava/util/Comparator; 2
      // 25a: invokeinterface java/util/List.sort (Ljava/util/Comparator;)V 2
      // 25f: new java/util/HashMap
      // 262: dup
      // 263: invokespecial java/util/HashMap.<init> ()V
      // 266: astore 5
      // 268: aload 4
      // 26a: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 26f: astore 6
      // 271: aload 6
      // 273: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 278: ifeq 2ee
      // 27b: aload 6
      // 27d: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 282: checkcast x/oc25b12192fe
      // 285: astore 7
      // 287: aload 7
      // 289: getfield x/oc25b12192fe.ȟ Lx/oc43fdb4c5d3;
      // 28c: getfield x/oc43fdb4c5d3.Ȏ Ljava/lang/String;
      // 28f: invokestatic x/F.ԙ (Ljava/lang/String;)Ljava/lang/String;
      // 292: astore 8
      // 294: aload 8
      // 296: ifnull 2ea
      // 299: aload 5
      // 29b: iload 2
      // 29c: ifne 2e9
      // 29f: goto 2a3
      // 2a2: athrow
      // 2a3: aload 8
      // 2a5: invokeinterface java/util/Map.containsKey (Ljava/lang/Object;)Z 2
      // 2aa: ifeq 2d4
      // 2ad: goto 2b1
      // 2b0: athrow
      // 2b1: aload 5
      // 2b3: aload 8
      // 2b5: iload 2
      // 2b6: ifne 2dc
      // 2b9: goto 2bd
      // 2bc: athrow
      // 2bd: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 2c2: checkcast java/lang/Integer
      // 2c5: invokevirtual java/lang/Integer.intValue ()I
      // 2c8: aload 7
      // 2ca: getfield x/oc25b12192fe.о I
      // 2cd: if_icmpge 2ea
      // 2d0: goto 2d4
      // 2d3: athrow
      // 2d4: aload 5
      // 2d6: aload 8
      // 2d8: goto 2dc
      // 2db: athrow
      // 2dc: aload 7
      // 2de: getfield x/oc25b12192fe.о I
      // 2e1: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 2e4: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 2e9: pop
      // 2ea: iload 2
      // 2eb: ifeq 271
      // 2ee: new java/util/ArrayList
      // 2f1: dup
      // 2f2: invokespecial java/util/ArrayList.<init> ()V
      // 2f5: astore 6
      // 2f7: new java/util/ArrayList
      // 2fa: dup
      // 2fb: invokespecial java/util/ArrayList.<init> ()V
      // 2fe: astore 7
      // 300: aload 4
      // 302: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 307: astore 8
      // 309: aload 8
      // 30b: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 310: ifeq 3d5
      // 313: aload 8
      // 315: iload 2
      // 316: ifne 30b
      // 319: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 31e: checkcast x/oc25b12192fe
      // 321: astore 9
      // 323: iload 2
      // 324: ifne 3f1
      // 327: aload 9
      // 329: getfield x/oc25b12192fe.ȟ Lx/oc43fdb4c5d3;
      // 32c: getfield x/oc43fdb4c5d3.Ȏ Ljava/lang/String;
      // 32f: invokestatic x/F.ԙ (Ljava/lang/String;)Ljava/lang/String;
      // 332: astore 10
      // 334: aload 10
      // 336: ifnull 309
      // 339: aload 7
      // 33b: iload 2
      // 33c: ifne 360
      // 33f: aload 10
      // 341: invokeinterface java/util/List.contains (Ljava/lang/Object;)Z 2
      // 346: ifeq 351
      // 349: goto 34d
      // 34c: athrow
      // 34d: goto 309
      // 350: athrow
      // 351: aload 7
      // 353: aload 10
      // 355: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 35a: pop
      // 35b: aload 10
      // 35d: invokestatic x/F.Ύ (Ljava/lang/String;)Ljava/util/List;
      // 360: astore 11
      // 362: aload 11
      // 364: invokeinterface java/util/List.isEmpty ()Z 1
      // 369: iload 2
      // 36a: ifne 388
      // 36d: ifeq 377
      // 370: goto 374
      // 373: athrow
      // 374: goto 309
      // 377: aload 5
      // 379: iload 2
      // 37a: ifne 398
      // 37d: aload 10
      // 37f: invokeinterface java/util/Map.containsKey (Ljava/lang/Object;)Z 2
      // 384: goto 388
      // 387: athrow
      // 388: ifeq 3a1
      // 38b: aload 5
      // 38d: aload 10
      // 38f: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 394: goto 398
      // 397: athrow
      // 398: checkcast java/lang/Integer
      // 39b: invokevirtual java/lang/Integer.intValue ()I
      // 39e: goto 3a6
      // 3a1: aload 9
      // 3a3: getfield x/oc25b12192fe.о I
      // 3a6: istore 12
      // 3a8: aload 6
      // 3aa: new x/oc3af4427d65
      // 3ad: dup
      // 3ae: aload 10
      // 3b0: aload 11
      // 3b2: iload 12
      // 3b4: invokespecial x/oc3af4427d65.<init> (Ljava/lang/String;Ljava/util/List;I)V
      // 3b7: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 3bc: pop
      // 3bd: aload 6
      // 3bf: invokeinterface java/util/List.size ()I 1
      // 3c4: ldc_w -273008837
      // 3c7: ldc -273008801
      // 3c9: ixor
      // 3ca: if_icmplt 3d1
      // 3cd: goto 3d5
      // 3d0: athrow
      // 3d1: iload 2
      // 3d2: ifeq 309
      // 3d5: aload 6
      // 3d7: invokedynamic applyAsInt ()Ljava/util/function/ToIntFunction; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)I, x/F.q2of299eaunuv2 (Lx/oc3af4427d65;)I, (Lx/oc3af4427d65;)I ]
      // 3dc: invokestatic java/util/Comparator.comparingInt (Ljava/util/function/ToIntFunction;)Ljava/util/Comparator;
      // 3df: invokedynamic apply ()Ljava/util/function/Function; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Ljava/lang/Object;, x/F.q37m5ecriyovm (Lx/oc3af4427d65;)Ljava/lang/String;, (Lx/oc3af4427d65;)Ljava/lang/String; ]
      // 3e4: getstatic java/lang/String.CASE_INSENSITIVE_ORDER Ljava/util/Comparator;
      // 3e7: invokeinterface java/util/Comparator.thenComparing (Ljava/util/function/Function;Ljava/util/Comparator;)Ljava/util/Comparator; 3
      // 3ec: invokeinterface java/util/List.sort (Ljava/util/Comparator;)V 2
      // 3f1: aload 6
      // 3f3: areturn
   }

   public static List<oc43fdb4c5d3> å() {
      Լ();
      return Collections.unmodifiableList(Æ);
   }

   public static List<oc43fdb4c5d3> Ύ(String param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: invokestatic x/F.Լ ()V
      // 06: istore 1
      // 07: getstatic x/F.и Ljava/util/Map;
      // 0a: iload 1
      // 0b: ifne 23
      // 0e: ifnonnull 1a
      // 11: goto 15
      // 14: athrow
      // 15: invokestatic java/util/Collections.emptyList ()Ljava/util/List;
      // 18: areturn
      // 19: athrow
      // 1a: getstatic x/F.и Ljava/util/Map;
      // 1d: aload 0
      // 1e: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 23: checkcast java/util/List
      // 26: astore 2
      // 27: aload 2
      // 28: iload 1
      // 29: ifne 34
      // 2c: ifnull 37
      // 2f: goto 33
      // 32: athrow
      // 33: aload 2
      // 34: goto 3a
      // 37: invokestatic java/util/Collections.emptyList ()Ljava/util/List;
      // 3a: areturn
   }

   public static boolean Ǧ(String var0) {
      int var1 = oc75d51ec7eb.ϩ;

      String var10000;
      label33: {
         try {
            var10000 = var0;
            if (var1 != 0) {
               break label33;
            }

            if (var0 == null) {
               return false;
            }
         } catch (NumberFormatException var3) {
            throw var3;
         }

         var10000 = var0;
      }

      try {
         boolean var4 = var10000.endsWith(":*");
         if (var1 != 0) {
            return var4;
         }

         if (var4) {
            return true;
         }
      } catch (NumberFormatException var2) {
         throw var2;
      }

      return false;
   }

   public static String ԙ(String param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 11
      // 09: ifnull 1f
      // 0c: goto 10
      // 0f: athrow
      // 10: aload 0
      // 11: iload 1
      // 12: ifne 23
      // 15: invokevirtual java/lang/String.isEmpty ()Z
      // 18: ifeq 22
      // 1b: goto 1f
      // 1e: athrow
      // 1f: aconst_null
      // 20: areturn
      // 21: athrow
      // 22: aload 0
      // 23: iload 1
      // 24: ifne 47
      // 27: ldc ":*"
      // 29: invokevirtual java/lang/String.endsWith (Ljava/lang/String;)Z
      // 2c: ifeq 46
      // 2f: goto 33
      // 32: athrow
      // 33: aload 0
      // 34: bipush 0
      // 35: aload 0
      // 36: invokevirtual java/lang/String.length ()I
      // 39: ldc_w 448990593
      // 3c: ldc_w 448990595
      // 3f: ixor
      // 40: isub
      // 41: invokevirtual java/lang/String.substring (II)Ljava/lang/String;
      // 44: areturn
      // 45: athrow
      // 46: aload 0
      // 47: ldc_w ":"
      // 4a: invokevirtual java/lang/String.split (Ljava/lang/String;)[Ljava/lang/String;
      // 4d: astore 2
      // 4e: aload 2
      // 4f: iload 1
      // 50: ifne 70
      // 53: arraylength
      // 54: ldc_w 448990592
      // 57: ldc_w 448990595
      // 5a: ixor
      // 5b: if_icmplt 6f
      // 5e: goto 62
      // 61: athrow
      // 62: aload 2
      // 63: bipush 0
      // 64: aaload
      // 65: aload 2
      // 66: bipush 1
      // 67: aaload
      // 68: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001:\u0001" ]
      // 6d: areturn
      // 6e: athrow
      // 6f: aload 2
      // 70: arraylength
      // 71: ldc_w 448990593
      // 74: ldc_w 448990595
      // 77: ixor
      // 78: if_icmpne 7e
      // 7b: aload 0
      // 7c: areturn
      // 7d: athrow
      // 7e: aconst_null
      // 7f: areturn
   }

   public static ItemStack ȯ(String param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 1b
      // 09: invokestatic x/F.Ǧ (Ljava/lang/String;)Z
      // 0c: ifeq 1e
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: invokestatic x/F.ԙ (Ljava/lang/String;)Ljava/lang/String;
      // 17: goto 1b
      // 1a: athrow
      // 1b: goto 1f
      // 1e: aload 0
      // 1f: astore 2
      // 20: aload 2
      // 21: invokestatic x/F.į (Ljava/lang/String;)Lnet/minecraft/block/Block;
      // 24: astore 3
      // 25: aload 3
      // 26: ifnonnull 2c
      // 29: aconst_null
      // 2a: areturn
      // 2b: athrow
      // 2c: aload 0
      // 2d: iload 1
      // 2e: ifne 41
      // 31: invokestatic x/F.Ǧ (Ljava/lang/String;)Z
      // 34: ifeq 40
      // 37: goto 3b
      // 3a: athrow
      // 3b: bipush 0
      // 3c: goto 44
      // 3f: athrow
      // 40: aload 0
      // 41: invokestatic x/F.ǽ (Ljava/lang/String;)I
      // 44: istore 4
      // 46: getstatic x/F.ġ Ljava/util/Map;
      // 49: aload 3
      // 4a: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 4f: checkcast net/minecraft/item/Item
      // 52: astore 5
      // 54: aload 5
      // 56: ifnull 67
      // 59: new net/minecraft/item/ItemStack
      // 5c: dup
      // 5d: aload 5
      // 5f: bipush 1
      // 60: iload 4
      // 62: invokespecial net/minecraft/item/ItemStack.<init> (Lnet/minecraft/item/Item;II)V
      // 65: areturn
      // 66: athrow
      // 67: new net/minecraft/item/ItemStack
      // 6a: dup
      // 6b: aload 3
      // 6c: bipush 1
      // 6d: iload 4
      // 6f: invokespecial net/minecraft/item/ItemStack.<init> (Lnet/minecraft/block/Block;II)V
      // 72: areturn
   }

   public static String Ͱ(String var0) {
      int var1 = oc75d51ec7eb.ϩ;

      label86: {
         String var10000;
         label63: {
            try {
               var10000 = var0;
               if (var1 != 0) {
                  break label63;
               }

               if (Ǧ(var0)) {
                  break label86;
               }
            } catch (NumberFormatException var5) {
               throw var5;
            }

            var10000 = var0;
         }

         ItemStack var6 = ȯ(var10000);

         try {
            if (var1 != 0) {
               return var6.getDisplayName();
            }

            if (var6 == null) {
               return var0;
            }
         } catch (NumberFormatException var4) {
            throw var4;
         }

         return var6.getDisplayName();
      }

      ItemStack var2 = ȯ(ԙ(var0));

      try {
         if (var1 != 0) {
            return var2.getDisplayName() + " (All)";
         }

         if (var2 == null) {
            return var0;
         }
      } catch (NumberFormatException var3) {
         throw var3;
      }

      return var2.getDisplayName() + " (All)";
   }

   private static void Լ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc75d51ec7eb.ϩ I
      // 003: istore 0
      // 004: getstatic x/F.Æ Ljava/util/List;
      // 007: ifnull 00c
      // 00a: return
      // 00b: athrow
      // 00c: new java/util/ArrayList
      // 00f: dup
      // 010: invokespecial java/util/ArrayList.<init> ()V
      // 013: putstatic x/F.Æ Ljava/util/List;
      // 016: new java/util/HashMap
      // 019: dup
      // 01a: invokespecial java/util/HashMap.<init> ()V
      // 01d: astore 1
      // 01e: getstatic net/minecraft/block/Block.blockRegistry Lnet/minecraft/util/RegistryNamespacedDefaultedByKey;
      // 021: invokevirtual net/minecraft/util/RegistryNamespacedDefaultedByKey.iterator ()Ljava/util/Iterator;
      // 024: astore 2
      // 025: aload 2
      // 026: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 02b: ifeq 207
      // 02e: aload 2
      // 02f: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 034: astore 3
      // 035: iload 0
      // 036: ifne 21e
      // 039: aload 3
      // 03a: checkcast net/minecraft/block/Block
      // 03d: astore 4
      // 03f: getstatic net/minecraft/block/Block.blockRegistry Lnet/minecraft/util/RegistryNamespacedDefaultedByKey;
      // 042: iload 0
      // 043: ifne 05e
      // 046: aload 4
      // 048: invokevirtual net/minecraft/util/RegistryNamespacedDefaultedByKey.getNameForObject (Ljava/lang/Object;)Ljava/lang/Object;
      // 04b: ifnull 067
      // 04e: goto 052
      // 051: athrow
      // 052: getstatic net/minecraft/block/Block.blockRegistry Lnet/minecraft/util/RegistryNamespacedDefaultedByKey;
      // 055: aload 4
      // 057: invokevirtual net/minecraft/util/RegistryNamespacedDefaultedByKey.getNameForObject (Ljava/lang/Object;)Ljava/lang/Object;
      // 05a: goto 05e
      // 05d: athrow
      // 05e: checkcast net/minecraft/util/ResourceLocation
      // 061: invokevirtual net/minecraft/util/ResourceLocation.toString ()Ljava/lang/String;
      // 064: goto 068
      // 067: aconst_null
      // 068: astore 5
      // 06a: aload 5
      // 06c: ifnonnull 073
      // 06f: goto 025
      // 072: athrow
      // 073: aload 4
      // 075: invokestatic net/minecraft/item/Item.getItemFromBlock (Lnet/minecraft/block/Block;)Lnet/minecraft/item/Item;
      // 078: astore 6
      // 07a: aload 6
      // 07c: iload 0
      // 07d: ifne 098
      // 080: ifnonnull 0f7
      // 083: goto 087
      // 086: athrow
      // 087: getstatic x/F.ġ Ljava/util/Map;
      // 08a: aload 4
      // 08c: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 091: checkcast net/minecraft/item/Item
      // 094: goto 098
      // 097: athrow
      // 098: astore 7
      // 09a: aload 7
      // 09c: ifnull 025
      // 09f: new net/minecraft/item/ItemStack
      // 0a2: dup
      // 0a3: aload 7
      // 0a5: bipush 1
      // 0a6: bipush 0
      // 0a7: invokespecial net/minecraft/item/ItemStack.<init> (Lnet/minecraft/item/Item;II)V
      // 0aa: astore 8
      // 0ac: aload 8
      // 0ae: invokevirtual net/minecraft/item/ItemStack.getDisplayName ()Ljava/lang/String;
      // 0b1: astore 9
      // 0b3: aload 9
      // 0b5: iload 0
      // 0b6: ifne 0c2
      // 0b9: ifnull 0f3
      // 0bc: goto 0c0
      // 0bf: athrow
      // 0c0: aload 9
      // 0c2: invokevirtual java/lang/String.isEmpty ()Z
      // 0c5: ifne 0f3
      // 0c8: new x/oc43fdb4c5d3
      // 0cb: dup
      // 0cc: aload 4
      // 0ce: bipush 0
      // 0cf: aload 9
      // 0d1: aload 5
      // 0d3: aload 7
      // 0d5: invokespecial x/oc43fdb4c5d3.<init> (Lnet/minecraft/block/Block;ILjava/lang/String;Ljava/lang/String;Lnet/minecraft/item/Item;)V
      // 0d8: astore 10
      // 0da: getstatic x/F.Æ Ljava/util/List;
      // 0dd: aload 10
      // 0df: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 0e4: pop
      // 0e5: aload 1
      // 0e6: aload 5
      // 0e8: aload 10
      // 0ea: invokestatic java/util/Collections.singletonList (Ljava/lang/Object;)Ljava/util/List;
      // 0ed: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 0f2: pop
      // 0f3: iload 0
      // 0f4: ifeq 025
      // 0f7: new java/util/ArrayList
      // 0fa: dup
      // 0fb: invokespecial java/util/ArrayList.<init> ()V
      // 0fe: astore 7
      // 100: aload 4
      // 102: aload 6
      // 104: getstatic net/minecraft/creativetab/CreativeTabs.tabBlock Lnet/minecraft/creativetab/CreativeTabs;
      // 107: aload 7
      // 109: invokevirtual net/minecraft/block/Block.getSubBlocks (Lnet/minecraft/item/Item;Lnet/minecraft/creativetab/CreativeTabs;Ljava/util/List;)V
      // 10c: aload 7
      // 10e: iload 0
      // 10f: ifne 13c
      // 112: invokeinterface java/util/List.isEmpty ()Z 1
      // 117: ifeq 135
      // 11a: goto 11e
      // 11d: athrow
      // 11e: aload 7
      // 120: new net/minecraft/item/ItemStack
      // 123: dup
      // 124: aload 4
      // 126: bipush 1
      // 127: bipush 0
      // 128: invokespecial net/minecraft/item/ItemStack.<init> (Lnet/minecraft/block/Block;II)V
      // 12b: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 130: pop
      // 131: goto 135
      // 134: athrow
      // 135: new java/util/ArrayList
      // 138: dup
      // 139: invokespecial java/util/ArrayList.<init> ()V
      // 13c: astore 8
      // 13e: aload 7
      // 140: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 145: astore 9
      // 147: aload 9
      // 149: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 14e: ifeq 1d3
      // 151: aload 9
      // 153: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 158: checkcast net/minecraft/item/ItemStack
      // 15b: astore 10
      // 15d: iload 0
      // 15e: aload 10
      // 160: invokevirtual net/minecraft/item/ItemStack.getDisplayName ()Ljava/lang/String;
      // 163: astore 11
      // 165: ifne 203
      // 168: aload 11
      // 16a: iload 0
      // 16b: ifne 17b
      // 16e: goto 172
      // 171: athrow
      // 172: ifnull 147
      // 175: goto 179
      // 178: athrow
      // 179: aload 11
      // 17b: invokevirtual java/lang/String.isEmpty ()Z
      // 17e: iload 0
      // 17f: ifne 191
      // 182: ifeq 18c
      // 185: goto 189
      // 188: athrow
      // 189: goto 147
      // 18c: aload 10
      // 18e: invokevirtual net/minecraft/item/ItemStack.getMetadata ()I
      // 191: istore 12
      // 193: iload 12
      // 195: ifeq 1a5
      // 198: aload 5
      // 19a: iload 12
      // 19c: invokedynamic makeConcatWithConstants (Ljava/lang/String;I)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001:\u0001" ]
      // 1a1: goto 1a7
      // 1a4: athrow
      // 1a5: aload 5
      // 1a7: astore 13
      // 1a9: iload 0
      // 1aa: new x/oc43fdb4c5d3
      // 1ad: dup
      // 1ae: aload 4
      // 1b0: iload 12
      // 1b2: aload 11
      // 1b4: aload 13
      // 1b6: invokespecial x/oc43fdb4c5d3.<init> (Lnet/minecraft/block/Block;ILjava/lang/String;Ljava/lang/String;)V
      // 1b9: astore 14
      // 1bb: getstatic x/F.Æ Ljava/util/List;
      // 1be: aload 14
      // 1c0: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 1c5: pop
      // 1c6: aload 8
      // 1c8: aload 14
      // 1ca: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 1cf: pop
      // 1d0: ifeq 147
      // 1d3: aload 8
      // 1d5: iload 0
      // 1d6: ifne 202
      // 1d9: invokeinterface java/util/List.isEmpty ()Z 1
      // 1de: ifne 203
      // 1e1: goto 1e5
      // 1e4: athrow
      // 1e5: aload 8
      // 1e7: invokedynamic apply ()Ljava/util/function/Function; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Ljava/lang/Object;, x/F.q2ab1sb4bu87gp (Lx/oc43fdb4c5d3;)Ljava/lang/Integer;, (Lx/oc43fdb4c5d3;)Ljava/lang/Integer; ]
      // 1ec: invokestatic java/util/Comparator.comparing (Ljava/util/function/Function;)Ljava/util/Comparator;
      // 1ef: invokeinterface java/util/List.sort (Ljava/util/Comparator;)V 2
      // 1f4: aload 1
      // 1f5: aload 5
      // 1f7: aload 8
      // 1f9: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 1fe: goto 202
      // 201: athrow
      // 202: pop
      // 203: iload 0
      // 204: ifeq 025
      // 207: getstatic x/F.Æ Ljava/util/List;
      // 20a: invokedynamic apply ()Ljava/util/function/Function; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Ljava/lang/Object;, x/F.q9qfm2plwamic (Lx/oc43fdb4c5d3;)Ljava/lang/String;, (Lx/oc43fdb4c5d3;)Ljava/lang/String; ]
      // 20f: getstatic java/lang/String.CASE_INSENSITIVE_ORDER Ljava/util/Comparator;
      // 212: invokestatic java/util/Comparator.comparing (Ljava/util/function/Function;Ljava/util/Comparator;)Ljava/util/Comparator;
      // 215: invokeinterface java/util/List.sort (Ljava/util/Comparator;)V 2
      // 21a: aload 1
      // 21b: putstatic x/F.и Ljava/util/Map;
      // 21e: return
   }

   private static String ϫ(String param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 11
      // 09: ifnull 1f
      // 0c: goto 10
      // 0f: athrow
      // 10: aload 0
      // 11: iload 1
      // 12: ifne 23
      // 15: invokevirtual java/lang/String.isEmpty ()Z
      // 18: ifeq 22
      // 1b: goto 1f
      // 1e: athrow
      // 1f: aconst_null
      // 20: areturn
      // 21: athrow
      // 22: aload 0
      // 23: ldc_w ":"
      // 26: invokevirtual java/lang/String.split (Ljava/lang/String;)[Ljava/lang/String;
      // 29: astore 2
      // 2a: aload 2
      // 2b: iload 1
      // 2c: ifne 4c
      // 2f: arraylength
      // 30: ldc_w -1747687384
      // 33: ldc_w -1747687381
      // 36: ixor
      // 37: if_icmplt 4b
      // 3a: goto 3e
      // 3d: athrow
      // 3e: aload 2
      // 3f: bipush 0
      // 40: aaload
      // 41: aload 2
      // 42: bipush 1
      // 43: aaload
      // 44: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001:\u0001" ]
      // 49: areturn
      // 4a: athrow
      // 4b: aload 2
      // 4c: arraylength
      // 4d: ldc_w -1747687383
      // 50: ldc_w -1747687381
      // 53: ixor
      // 54: if_icmpne 5a
      // 57: aload 0
      // 58: areturn
      // 59: athrow
      // 5a: aconst_null
      // 5b: areturn
   }

   private static int ǽ(String param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 14
      // 09: ifnonnull 13
      // 0c: goto 10
      // 0f: athrow
      // 10: bipush 0
      // 11: ireturn
      // 12: athrow
      // 13: aload 0
      // 14: ldc_w ":"
      // 17: invokevirtual java/lang/String.split (Ljava/lang/String;)[Ljava/lang/String;
      // 1a: astore 2
      // 1b: aload 2
      // 1c: arraylength
      // 1d: iload 1
      // 1e: ifne 41
      // 21: ldc_w 1306370682
      // 24: ldc_w 1306370681
      // 27: ixor
      // 28: if_icmplt 40
      // 2b: goto 2f
      // 2e: athrow
      // 2f: aload 2
      // 30: ldc_w 1306370683
      // 33: ldc_w 1306370681
      // 36: ixor
      // 37: aaload
      // 38: invokestatic java/lang/Integer.parseInt (Ljava/lang/String;)I
      // 3b: ireturn
      // 3c: athrow
      // 3d: astore 3
      // 3e: bipush 0
      // 3f: ireturn
      // 40: bipush 0
      // 41: ireturn
   }

   private static Block į(String param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: aload 0
      // 04: invokestatic x/F.ϫ (Ljava/lang/String;)Ljava/lang/String;
      // 07: astore 2
      // 08: istore 1
      // 09: aload 2
      // 0a: iload 1
      // 0b: ifne 26
      // 0e: ifnonnull 18
      // 11: goto 15
      // 14: athrow
      // 15: aconst_null
      // 16: areturn
      // 17: athrow
      // 18: getstatic net/minecraft/block/Block.blockRegistry Lnet/minecraft/util/RegistryNamespacedDefaultedByKey;
      // 1b: new net/minecraft/util/ResourceLocation
      // 1e: dup
      // 1f: aload 2
      // 20: invokespecial net/minecraft/util/ResourceLocation.<init> (Ljava/lang/String;)V
      // 23: invokevirtual net/minecraft/util/RegistryNamespacedDefaultedByKey.getObject (Ljava/lang/Object;)Ljava/lang/Object;
      // 26: checkcast net/minecraft/block/Block
      // 29: areturn
      // 2a: astore 3
      // 2b: aconst_null
      // 2c: areturn
   }

   static {
      ġ.put(Blocks.bed, Items.bed);
   }
}
