package x;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class oc920065c394 {
   private static final int F = 100;
   private static List<oc2ef79a3df1> Í;
   private static Map<String, List<oc2ef79a3df1>> U;
   public static int Ŝ;

   private oc920065c394() {
   }

   public static List<oc019314a9ca> Ȯ(String param0, oc2ec6a95e5c param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc75d51ec7eb.ϩ I
      // 003: invokestatic x/oc920065c394.ǽ ()V
      // 006: istore 2
      // 007: aload 0
      // 008: iload 2
      // 009: ifne 021
      // 00c: ifnull 027
      // 00f: goto 013
      // 012: athrow
      // 013: aload 0
      // 014: iload 2
      // 015: ifne 030
      // 018: goto 01c
      // 01b: athrow
      // 01c: invokevirtual java/lang/String.trim ()Ljava/lang/String;
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
      // 03a: getstatic x/oc920065c394.Í Ljava/util/List;
      // 03d: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 042: astore 5
      // 044: aload 5
      // 046: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 04b: ifeq 1e1
      // 04e: aload 5
      // 050: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 055: checkcast x/oc2ef79a3df1
      // 058: astore 6
      // 05a: iload 2
      // 05b: ifne 207
      // 05e: aload 6
      // 060: iload 2
      // 061: ifne 079
      // 064: aload 1
      // 065: invokestatic x/oc920065c394.ş (Lx/oc2ef79a3df1;Lx/oc2ec6a95e5c;)Z
      // 068: ifeq 077
      // 06b: goto 06f
      // 06e: athrow
      // 06f: iload 2
      // 070: ifeq 044
      // 073: goto 077
      // 076: athrow
      // 077: aload 6
      // 079: getfield x/oc2ef79a3df1.Ѧ Ljava/lang/String;
      // 07c: invokevirtual java/lang/String.toLowerCase ()Ljava/lang/String;
      // 07f: astore 7
      // 081: aload 6
      // 083: getfield x/oc2ef79a3df1.Ѩ Ljava/lang/String;
      // 086: invokestatic x/oc920065c394.Ή (Ljava/lang/String;)Ljava/lang/String;
      // 089: invokevirtual java/lang/String.toLowerCase ()Ljava/lang/String;
      // 08c: astore 8
      // 08e: bipush 0
      // 08f: istore 9
      // 091: aload 7
      // 093: aload 3
      // 094: iload 2
      // 095: ifne 0bc
      // 098: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 09b: ifeq 0ad
      // 09e: goto 0a2
      // 0a1: athrow
      // 0a2: ldc -1651385346
      // 0a4: ldc -1651386346
      // 0a6: ixor
      // 0a7: istore 9
      // 0a9: iload 2
      // 0aa: ifeq 1b9
      // 0ad: aload 8
      // 0af: iload 2
      // 0b0: ifne 0d3
      // 0b3: goto 0b7
      // 0b6: athrow
      // 0b7: aload 3
      // 0b8: goto 0bc
      // 0bb: athrow
      // 0bc: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 0bf: ifeq 0cd
      // 0c2: ldc -1651385454
      // 0c4: ldc -1651386346
      // 0c6: ixor
      // 0c7: istore 9
      // 0c9: iload 2
      // 0ca: ifeq 1b9
      // 0cd: aload 7
      // 0cf: goto 0d3
      // 0d2: athrow
      // 0d3: aload 3
      // 0d4: iload 2
      // 0d5: ifne 0fc
      // 0d8: invokevirtual java/lang/String.startsWith (Ljava/lang/String;)Z
      // 0db: ifeq 0ed
      // 0de: goto 0e2
      // 0e1: athrow
      // 0e2: ldc -1651385546
      // 0e4: ldc -1651386346
      // 0e6: ixor
      // 0e7: istore 9
      // 0e9: iload 2
      // 0ea: ifeq 1b9
      // 0ed: aload 8
      // 0ef: iload 2
      // 0f0: ifne 113
      // 0f3: goto 0f7
      // 0f6: athrow
      // 0f7: aload 3
      // 0f8: goto 0fc
      // 0fb: athrow
      // 0fc: invokevirtual java/lang/String.startsWith (Ljava/lang/String;)Z
      // 0ff: ifeq 10d
      // 102: ldc -1651385686
      // 104: ldc -1651386346
      // 106: ixor
      // 107: istore 9
      // 109: iload 2
      // 10a: ifeq 1b9
      // 10d: aload 7
      // 10f: goto 113
      // 112: athrow
      // 113: ldc "\\s+"
      // 115: invokevirtual java/lang/String.split (Ljava/lang/String;)[Ljava/lang/String;
      // 118: astore 10
      // 11a: aload 10
      // 11c: astore 11
      // 11e: aload 11
      // 120: arraylength
      // 121: istore 12
      // 123: bipush 0
      // 124: istore 13
      // 126: iload 13
      // 128: iload 12
      // 12a: if_icmpge 15f
      // 12d: aload 11
      // 12f: iload 13
      // 131: aaload
      // 132: iload 2
      // 133: ifne 055
      // 136: astore 14
      // 138: iload 2
      // 139: ifne 15b
      // 13c: aload 14
      // 13e: aload 3
      // 13f: invokevirtual java/lang/String.startsWith (Ljava/lang/String;)Z
      // 142: ifeq 154
      // 145: goto 149
      // 148: athrow
      // 149: ldc -1651385778
      // 14b: ldc -1651386346
      // 14d: ixor
      // 14e: istore 9
      // 150: iload 2
      // 151: ifeq 15f
      // 154: iinc 13 1
      // 157: goto 15b
      // 15a: athrow
      // 15b: iload 2
      // 15c: ifeq 126
      // 15f: iload 9
      // 161: iload 2
      // 162: ifne 192
      // 165: ifne 18c
      // 168: goto 16c
      // 16b: athrow
      // 16c: aload 7
      // 16e: aload 3
      // 16f: invokevirtual java/lang/String.contains (Ljava/lang/CharSequence;)Z
      // 172: iload 2
      // 173: ifne 192
      // 176: goto 17a
      // 179: athrow
      // 17a: ifeq 18c
      // 17d: goto 181
      // 180: athrow
      // 181: ldc -1651385886
      // 183: ldc -1651386346
      // 185: ixor
      // 186: istore 9
      // 188: iload 2
      // 189: ifeq 1b9
      // 18c: iload 9
      // 18e: goto 192
      // 191: athrow
      // 192: iload 2
      // 193: ifne 1bb
      // 196: ifne 1b9
      // 199: goto 19d
      // 19c: athrow
      // 19d: aload 8
      // 19f: aload 3
      // 1a0: invokevirtual java/lang/String.contains (Ljava/lang/CharSequence;)Z
      // 1a3: iload 2
      // 1a4: ifne 1bb
      // 1a7: goto 1ab
      // 1aa: athrow
      // 1ab: ifeq 1b9
      // 1ae: goto 1b2
      // 1b1: athrow
      // 1b2: ldc -1651385978
      // 1b4: ldc -1651386346
      // 1b6: ixor
      // 1b7: istore 9
      // 1b9: iload 9
      // 1bb: iload 2
      // 1bc: ifne 1dc
      // 1bf: ifle 1dd
      // 1c2: goto 1c6
      // 1c5: athrow
      // 1c6: aload 4
      // 1c8: new x/oc35910170e3
      // 1cb: dup
      // 1cc: aload 6
      // 1ce: iload 9
      // 1d0: invokespecial x/oc35910170e3.<init> (Lx/oc2ef79a3df1;I)V
      // 1d3: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 1d8: goto 1dc
      // 1db: athrow
      // 1dc: pop
      // 1dd: iload 2
      // 1de: ifeq 044
      // 1e1: aload 4
      // 1e3: invokedynamic applyAsInt ()Ljava/util/function/ToIntFunction; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)I, x/oc920065c394.qeh778htbyjw (Lx/oc35910170e3;)I, (Lx/oc35910170e3;)I ]
      // 1e8: invokestatic java/util/Comparator.comparingInt (Ljava/util/function/ToIntFunction;)Ljava/util/Comparator;
      // 1eb: invokedynamic apply ()Ljava/util/function/Function; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Ljava/lang/Object;, x/oc920065c394.q1flffrubr6hjp (Lx/oc35910170e3;)Ljava/lang/String;, (Lx/oc35910170e3;)Ljava/lang/String; ]
      // 1f0: getstatic java/lang/String.CASE_INSENSITIVE_ORDER Ljava/util/Comparator;
      // 1f3: invokeinterface java/util/Comparator.thenComparing (Ljava/util/function/Function;Ljava/util/Comparator;)Ljava/util/Comparator; 3
      // 1f8: invokedynamic apply ()Ljava/util/function/Function; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Ljava/lang/Object;, x/oc920065c394.qgtu0w4j2gyv4 (Lx/oc35910170e3;)Ljava/lang/String;, (Lx/oc35910170e3;)Ljava/lang/String; ]
      // 1fd: invokeinterface java/util/Comparator.thenComparing (Ljava/util/function/Function;)Ljava/util/Comparator; 2
      // 202: invokeinterface java/util/List.sort (Ljava/util/Comparator;)V 2
      // 207: new java/util/HashMap
      // 20a: dup
      // 20b: invokespecial java/util/HashMap.<init> ()V
      // 20e: astore 5
      // 210: aload 4
      // 212: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 217: astore 6
      // 219: aload 6
      // 21b: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 220: ifeq 29f
      // 223: aload 6
      // 225: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 22a: checkcast x/oc35910170e3
      // 22d: astore 7
      // 22f: aload 7
      // 231: getfield x/oc35910170e3.Ӈ Lx/oc2ef79a3df1;
      // 234: getfield x/oc2ef79a3df1.Ѩ Ljava/lang/String;
      // 237: invokestatic x/oc920065c394.ϑ (Ljava/lang/String;)Ljava/lang/String;
      // 23a: astore 8
      // 23c: aload 8
      // 23e: iload 2
      // 23f: ifne 25a
      // 242: ifnonnull 251
      // 245: goto 249
      // 248: athrow
      // 249: iload 2
      // 24a: ifeq 219
      // 24d: goto 251
      // 250: athrow
      // 251: aload 5
      // 253: aload 8
      // 255: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 25a: checkcast java/lang/Integer
      // 25d: astore 9
      // 25f: aload 9
      // 261: iload 2
      // 262: ifne 29a
      // 265: ifnull 285
      // 268: goto 26c
      // 26b: athrow
      // 26c: aload 9
      // 26e: iload 2
      // 26f: ifne 29a
      // 272: goto 276
      // 275: athrow
      // 276: invokevirtual java/lang/Integer.intValue ()I
      // 279: aload 7
      // 27b: getfield x/oc35910170e3.Қ I
      // 27e: if_icmpge 29b
      // 281: goto 285
      // 284: athrow
      // 285: aload 5
      // 287: aload 8
      // 289: aload 7
      // 28b: getfield x/oc35910170e3.Қ I
      // 28e: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 291: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 296: goto 29a
      // 299: athrow
      // 29a: pop
      // 29b: iload 2
      // 29c: ifeq 219
      // 29f: new java/util/ArrayList
      // 2a2: dup
      // 2a3: invokespecial java/util/ArrayList.<init> ()V
      // 2a6: astore 6
      // 2a8: new java/util/HashSet
      // 2ab: dup
      // 2ac: invokespecial java/util/HashSet.<init> ()V
      // 2af: astore 7
      // 2b1: aload 4
      // 2b3: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 2b8: astore 8
      // 2ba: aload 8
      // 2bc: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 2c1: ifeq 391
      // 2c4: aload 8
      // 2c6: iload 2
      // 2c7: ifne 2bc
      // 2ca: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 2cf: checkcast x/oc35910170e3
      // 2d2: astore 9
      // 2d4: iload 2
      // 2d5: ifne 3ad
      // 2d8: aload 9
      // 2da: getfield x/oc35910170e3.Ӈ Lx/oc2ef79a3df1;
      // 2dd: getfield x/oc2ef79a3df1.Ѩ Ljava/lang/String;
      // 2e0: invokestatic x/oc920065c394.ϑ (Ljava/lang/String;)Ljava/lang/String;
      // 2e3: astore 10
      // 2e5: aload 10
      // 2e7: ifnull 2ba
      // 2ea: aload 7
      // 2ec: aload 10
      // 2ee: invokeinterface java/util/Set.add (Ljava/lang/Object;)Z 2
      // 2f3: ifne 2fe
      // 2f6: iload 2
      // 2f7: ifeq 2ba
      // 2fa: goto 2fe
      // 2fd: athrow
      // 2fe: aload 10
      // 300: invokestatic x/oc920065c394.ӛ (Ljava/lang/String;)Ljava/util/List;
      // 303: astore 11
      // 305: aload 11
      // 307: invokeinterface java/util/List.isEmpty ()Z 1
      // 30c: iload 2
      // 30d: ifne 330
      // 310: ifeq 31f
      // 313: goto 317
      // 316: athrow
      // 317: iload 2
      // 318: ifeq 2ba
      // 31b: goto 31f
      // 31e: athrow
      // 31f: aload 5
      // 321: aload 10
      // 323: iload 2
      // 324: ifne 33b
      // 327: invokeinterface java/util/Map.containsKey (Ljava/lang/Object;)Z 2
      // 32c: goto 330
      // 32f: athrow
      // 330: ifeq 349
      // 333: aload 5
      // 335: aload 10
      // 337: goto 33b
      // 33a: athrow
      // 33b: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 340: checkcast java/lang/Integer
      // 343: invokevirtual java/lang/Integer.intValue ()I
      // 346: goto 34e
      // 349: aload 9
      // 34b: getfield x/oc35910170e3.Қ I
      // 34e: istore 12
      // 350: aload 6
      // 352: new x/oc019314a9ca
      // 355: dup
      // 356: aload 10
      // 358: aload 11
      // 35a: iload 12
      // 35c: aload 10
      // 35e: aload 11
      // 360: invokestatic x/oc920065c394.õ (Ljava/lang/String;Ljava/util/List;)Ljava/lang/String;
      // 363: aload 10
      // 365: invokestatic x/oc920065c394.ø (Ljava/lang/String;)Ljava/lang/String;
      // 368: invokespecial x/oc019314a9ca.<init> (Ljava/lang/String;Ljava/util/List;ILjava/lang/String;Ljava/lang/String;)V
      // 36b: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 370: pop
      // 371: aload 6
      // 373: invokeinterface java/util/List.size ()I 1
      // 378: ldc_w -1651386254
      // 37b: ldc -1651386346
      // 37d: ixor
      // 37e: if_icmplt 389
      // 381: iload 2
      // 382: ifeq 391
      // 385: goto 389
      // 388: athrow
      // 389: iload 2
      // 38a: ifeq 2ba
      // 38d: goto 391
      // 390: athrow
      // 391: aload 6
      // 393: invokedynamic applyAsInt ()Ljava/util/function/ToIntFunction; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)I, x/oc920065c394.qk76z7lt9pu99 (Lx/oc019314a9ca;)I, (Lx/oc019314a9ca;)I ]
      // 398: invokestatic java/util/Comparator.comparingInt (Ljava/util/function/ToIntFunction;)Ljava/util/Comparator;
      // 39b: invokedynamic apply ()Ljava/util/function/Function; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Ljava/lang/Object;, x/oc920065c394.q3k718ok8p53mn (Lx/oc019314a9ca;)Ljava/lang/String;, (Lx/oc019314a9ca;)Ljava/lang/String; ]
      // 3a0: getstatic java/lang/String.CASE_INSENSITIVE_ORDER Ljava/util/Comparator;
      // 3a3: invokeinterface java/util/Comparator.thenComparing (Ljava/util/function/Function;Ljava/util/Comparator;)Ljava/util/Comparator; 3
      // 3a8: invokeinterface java/util/List.sort (Ljava/util/Comparator;)V 2
      // 3ad: aload 6
      // 3af: areturn
   }

   public static List<oc2ef79a3df1> Ҥ() {
      ǽ();
      return Collections.unmodifiableList(Í);
   }

   public static List<oc2ef79a3df1> ӛ(String param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: invokestatic x/oc920065c394.ǽ ()V
      // 06: istore 1
      // 07: getstatic x/oc920065c394.U Ljava/util/Map;
      // 0a: iload 1
      // 0b: ifne 23
      // 0e: ifnonnull 1a
      // 11: goto 15
      // 14: athrow
      // 15: invokestatic java/util/Collections.emptyList ()Ljava/util/List;
      // 18: areturn
      // 19: athrow
      // 1a: getstatic x/oc920065c394.U Ljava/util/Map;
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

   public static String Ձ(ItemStack param0) {
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
      // 15: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 18: ifnonnull 22
      // 1b: goto 1f
      // 1e: athrow
      // 1f: aconst_null
      // 20: areturn
      // 21: athrow
      // 22: aload 0
      // 23: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 26: invokestatic x/oc920065c394.ƅ (Lnet/minecraft/item/Item;)Ljava/lang/String;
      // 29: astore 2
      // 2a: aload 2
      // 2b: ifnonnull 31
      // 2e: aconst_null
      // 2f: areturn
      // 30: athrow
      // 31: aload 0
      // 32: iload 1
      // 33: ifne 48
      // 36: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 39: invokestatic x/oc920065c394.ё (Lnet/minecraft/item/Item;)Z
      // 3c: ifeq 5d
      // 3f: goto 43
      // 42: athrow
      // 43: aload 0
      // 44: goto 48
      // 47: athrow
      // 48: invokevirtual net/minecraft/item/ItemStack.getMetadata ()I
      // 4b: istore 3
      // 4c: iload 3
      // 4d: ifeq 5b
      // 50: aload 2
      // 51: iload 3
      // 52: invokedynamic makeConcatWithConstants (Ljava/lang/String;I)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001:\u0001" ]
      // 57: goto 5c
      // 5a: athrow
      // 5b: aload 2
      // 5c: areturn
      // 5d: aload 2
      // 5e: areturn
   }

   public static String ƅ(Item param0) {
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
      // 06: ifne 23
      // 09: ifnull 26
      // 0c: goto 10
      // 0f: athrow
      // 10: getstatic net/minecraft/item/Item.itemRegistry Lnet/minecraft/util/RegistryNamespaced;
      // 13: aload 0
      // 14: iload 1
      // 15: ifne 2d
      // 18: goto 1c
      // 1b: athrow
      // 1c: invokevirtual net/minecraft/util/RegistryNamespaced.getNameForObject (Ljava/lang/Object;)Ljava/lang/Object;
      // 1f: goto 23
      // 22: athrow
      // 23: ifnonnull 29
      // 26: aconst_null
      // 27: areturn
      // 28: athrow
      // 29: getstatic net/minecraft/item/Item.itemRegistry Lnet/minecraft/util/RegistryNamespaced;
      // 2c: aload 0
      // 2d: invokevirtual net/minecraft/util/RegistryNamespaced.getNameForObject (Ljava/lang/Object;)Ljava/lang/Object;
      // 30: checkcast net/minecraft/util/ResourceLocation
      // 33: invokevirtual net/minecraft/util/ResourceLocation.toString ()Ljava/lang/String;
      // 36: areturn
   }

   public static boolean Ջ(Item param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: aload 0
      // 04: invokestatic x/oc920065c394.ƅ (Lnet/minecraft/item/Item;)Ljava/lang/String;
      // 07: astore 2
      // 08: istore 1
      // 09: aload 2
      // 0a: iload 1
      // 0b: ifne 16
      // 0e: ifnull 32
      // 11: goto 15
      // 14: athrow
      // 15: aload 2
      // 16: invokestatic x/oc920065c394.ӛ (Ljava/lang/String;)Ljava/util/List;
      // 19: invokeinterface java/util/List.size ()I 1
      // 1e: iload 1
      // 1f: ifne 2f
      // 22: bipush 1
      // 23: if_icmple 32
      // 26: goto 2a
      // 29: athrow
      // 2a: bipush 1
      // 2b: goto 2f
      // 2e: athrow
      // 2f: goto 33
      // 32: bipush 0
      // 33: ireturn
   }

   public static boolean У(String var0) {
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

   public static boolean Ӷ(String param0) {
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
      // 06: ifne 18
      // 09: invokestatic x/ocb50cc94190.ȓ (Ljava/lang/String;)Lx/ocb50cc94190;
      // 0c: ifnonnull 26
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: goto 18
      // 17: athrow
      // 18: invokestatic x/oc920065c394.У (Ljava/lang/String;)Z
      // 1b: iload 1
      // 1c: ifne 27
      // 1f: ifeq 2a
      // 22: goto 26
      // 25: athrow
      // 26: bipush 1
      // 27: goto 2b
      // 2a: bipush 0
      // 2b: ireturn
   }

   public static String ø(String param0) {
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
      // 06: ifne 1f
      // 09: invokestatic x/ocb50cc94190.ȓ (Ljava/lang/String;)Lx/ocb50cc94190;
      // 0c: ifnull 16
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: areturn
      // 15: athrow
      // 16: aload 0
      // 17: ldc_w ":*"
      // 1a: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 1f: areturn
   }

   public static List<oc2ef79a3df1> ѫ(String param0) {
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
      // 12: ifne 25
      // 15: invokevirtual java/lang/String.isEmpty ()Z
      // 18: ifeq 24
      // 1b: goto 1f
      // 1e: athrow
      // 1f: invokestatic java/util/Collections.emptyList ()Ljava/util/List;
      // 22: areturn
      // 23: athrow
      // 24: aload 0
      // 25: invokestatic x/ocb50cc94190.ȓ (Ljava/lang/String;)Lx/ocb50cc94190;
      // 28: astore 2
      // 29: aload 2
      // 2a: ifnull 33
      // 2d: aload 0
      // 2e: invokestatic x/oc920065c394.ӛ (Ljava/lang/String;)Ljava/util/List;
      // 31: areturn
      // 32: athrow
      // 33: aload 0
      // 34: iload 1
      // 35: ifne 4a
      // 38: invokestatic x/oc920065c394.У (Ljava/lang/String;)Z
      // 3b: ifeq 4e
      // 3e: goto 42
      // 41: athrow
      // 42: aload 0
      // 43: invokestatic x/oc920065c394.ϑ (Ljava/lang/String;)Ljava/lang/String;
      // 46: goto 4a
      // 49: athrow
      // 4a: invokestatic x/oc920065c394.ӛ (Ljava/lang/String;)Ljava/util/List;
      // 4d: areturn
      // 4e: invokestatic java/util/Collections.emptyList ()Ljava/util/List;
      // 51: areturn
   }

   public static boolean Ǭ(List<String> param0, ItemStack param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 2
      // 04: aload 0
      // 05: iload 2
      // 06: ifne 11
      // 09: ifnull 21
      // 0c: goto 10
      // 0f: athrow
      // 10: aload 0
      // 11: iload 2
      // 12: ifne 25
      // 15: invokeinterface java/util/List.isEmpty ()Z 1
      // 1a: ifeq 24
      // 1d: goto 21
      // 20: athrow
      // 21: bipush 0
      // 22: ireturn
      // 23: athrow
      // 24: aload 0
      // 25: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 2a: astore 3
      // 2b: aload 3
      // 2c: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 31: ifeq 5e
      // 34: aload 3
      // 35: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 3a: checkcast java/lang/String
      // 3d: astore 4
      // 3f: aload 4
      // 41: aload 1
      // 42: invokestatic x/oc920065c394.ҳ (Ljava/lang/String;Lnet/minecraft/item/ItemStack;)Z
      // 45: iload 2
      // 46: ifne 5f
      // 49: iload 2
      // 4a: ifne 59
      // 4d: goto 51
      // 50: athrow
      // 51: ifeq 5a
      // 54: goto 58
      // 57: athrow
      // 58: bipush 1
      // 59: ireturn
      // 5a: iload 2
      // 5b: ifeq 2b
      // 5e: bipush 0
      // 5f: ireturn
   }

   public static boolean ҳ(String param0, ItemStack param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 2
      // 04: aload 0
      // 05: iload 2
      // 06: ifne 11
      // 09: ifnull 1f
      // 0c: goto 10
      // 0f: athrow
      // 10: aload 0
      // 11: iload 2
      // 12: ifne 23
      // 15: invokevirtual java/lang/String.isEmpty ()Z
      // 18: ifeq 22
      // 1b: goto 1f
      // 1e: athrow
      // 1f: bipush 0
      // 20: ireturn
      // 21: athrow
      // 22: aload 0
      // 23: invokestatic x/ocb50cc94190.ȓ (Ljava/lang/String;)Lx/ocb50cc94190;
      // 26: astore 3
      // 27: aload 3
      // 28: iload 2
      // 29: ifne 34
      // 2c: ifnull 39
      // 2f: goto 33
      // 32: athrow
      // 33: aload 3
      // 34: aload 1
      // 35: invokevirtual x/ocb50cc94190.z$2opx8s6bbbs2u (Lnet/minecraft/item/ItemStack;)Z
      // 38: ireturn
      // 39: aload 1
      // 3a: iload 2
      // 3b: ifne 46
      // 3e: ifnull 54
      // 41: goto 45
      // 44: athrow
      // 45: aload 1
      // 46: iload 2
      // 47: ifne 58
      // 4a: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 4d: ifnonnull 57
      // 50: goto 54
      // 53: athrow
      // 54: bipush 0
      // 55: ireturn
      // 56: athrow
      // 57: aload 1
      // 58: invokestatic x/oc920065c394.Ձ (Lnet/minecraft/item/ItemStack;)Ljava/lang/String;
      // 5b: astore 4
      // 5d: aload 4
      // 5f: iload 2
      // 60: ifne 6e
      // 63: ifnonnull 6d
      // 66: goto 6a
      // 69: athrow
      // 6a: bipush 0
      // 6b: ireturn
      // 6c: athrow
      // 6d: aload 0
      // 6e: iload 2
      // 6f: ifne 86
      // 72: aload 4
      // 74: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 77: ifeq 81
      // 7a: goto 7e
      // 7d: athrow
      // 7e: bipush 1
      // 7f: ireturn
      // 80: athrow
      // 81: aload 4
      // 83: invokestatic x/oc920065c394.ϑ (Ljava/lang/String;)Ljava/lang/String;
      // 86: astore 5
      // 88: aload 5
      // 8a: iload 2
      // 8b: ifne 96
      // 8e: ifnull b2
      // 91: goto 95
      // 94: athrow
      // 95: aload 0
      // 96: aload 5
      // 98: ldc_w ":*"
      // 9b: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // a0: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // a3: iload 2
      // a4: ifne af
      // a7: ifeq b2
      // aa: goto ae
      // ad: athrow
      // ae: bipush 1
      // af: goto b3
      // b2: bipush 0
      // b3: ireturn
   }

   public static double Ə(String param0, ItemStack param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 2
      // 04: aload 0
      // 05: iload 2
      // 06: ifne 1a
      // 09: aload 1
      // 0a: invokestatic x/oc920065c394.ҳ (Ljava/lang/String;Lnet/minecraft/item/ItemStack;)Z
      // 0d: ifne 19
      // 10: goto 14
      // 13: athrow
      // 14: ldc2_w -Infinity
      // 17: dreturn
      // 18: athrow
      // 19: aload 0
      // 1a: invokestatic x/ocb50cc94190.ȓ (Ljava/lang/String;)Lx/ocb50cc94190;
      // 1d: astore 3
      // 1e: aload 3
      // 1f: ifnonnull 25
      // 22: dconst_0
      // 23: dreturn
      // 24: athrow
      // 25: getstatic x/oc56dd62b3b1.ȅ [I
      // 28: aload 3
      // 29: invokevirtual java/lang/Enum.ordinal ()I
      // 2c: iaload
      // 2d: tableswitch 88 1 8 47 53 58 63 68 73 78 83
      // 5c: aload 1
      // 5d: invokestatic x/oc561cb941fa.ҿ (Lnet/minecraft/item/ItemStack;)D
      // 60: dreturn
      // 61: athrow
      // 62: aload 1
      // 63: invokestatic x/oc561cb941fa.ĸ (Lnet/minecraft/item/ItemStack;)D
      // 66: dreturn
      // 67: aload 1
      // 68: invokestatic x/oc561cb941fa.Ó (Lnet/minecraft/item/ItemStack;)D
      // 6b: dreturn
      // 6c: aload 1
      // 6d: invokestatic x/oc561cb941fa.ȣ (Lnet/minecraft/item/ItemStack;)D
      // 70: dreturn
      // 71: aload 1
      // 72: invokestatic x/oc561cb941fa.Ǭ (Lnet/minecraft/item/ItemStack;)D
      // 75: dreturn
      // 76: aload 1
      // 77: invokestatic x/oc561cb941fa.ѣ (Lnet/minecraft/item/ItemStack;)D
      // 7a: dreturn
      // 7b: aload 1
      // 7c: invokestatic x/oc561cb941fa.Α (Lnet/minecraft/item/ItemStack;)D
      // 7f: dreturn
      // 80: aload 1
      // 81: invokestatic x/oc561cb941fa.ʧ (Lnet/minecraft/item/ItemStack;)D
      // 84: dreturn
      // 85: dconst_0
      // 86: dreturn
   }

   public static String ϑ(String param0) {
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
      // 24: ifne 35
      // 27: invokestatic x/ocb50cc94190.ȓ (Ljava/lang/String;)Lx/ocb50cc94190;
      // 2a: ifnull 34
      // 2d: goto 31
      // 30: athrow
      // 31: aload 0
      // 32: areturn
      // 33: athrow
      // 34: aload 0
      // 35: iload 1
      // 36: ifne 5a
      // 39: ldc_w ":*"
      // 3c: invokevirtual java/lang/String.endsWith (Ljava/lang/String;)Z
      // 3f: ifeq 59
      // 42: goto 46
      // 45: athrow
      // 46: aload 0
      // 47: bipush 0
      // 48: aload 0
      // 49: invokevirtual java/lang/String.length ()I
      // 4c: ldc_w 785211086
      // 4f: ldc_w 785211084
      // 52: ixor
      // 53: isub
      // 54: invokevirtual java/lang/String.substring (II)Ljava/lang/String;
      // 57: areturn
      // 58: athrow
      // 59: aload 0
      // 5a: ldc_w ":"
      // 5d: invokevirtual java/lang/String.split (Ljava/lang/String;)[Ljava/lang/String;
      // 60: astore 2
      // 61: aload 2
      // 62: arraylength
      // 63: iload 1
      // 64: ifne 84
      // 67: ldc_w 785211087
      // 6a: ldc_w 785211084
      // 6d: ixor
      // 6e: if_icmplt 82
      // 71: goto 75
      // 74: athrow
      // 75: aload 2
      // 76: bipush 0
      // 77: aaload
      // 78: aload 2
      // 79: bipush 1
      // 7a: aaload
      // 7b: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001:\u0001" ]
      // 80: areturn
      // 81: athrow
      // 82: aload 2
      // 83: arraylength
      // 84: ldc_w 785211086
      // 87: ldc_w 785211084
      // 8a: ixor
      // 8b: if_icmpne 91
      // 8e: aload 0
      // 8f: areturn
      // 90: athrow
      // 91: aconst_null
      // 92: areturn
   }

   public static ItemStack t(String param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc75d51ec7eb.ϩ I
      // 003: invokestatic x/oc920065c394.ǽ ()V
      // 006: istore 1
      // 007: aload 0
      // 008: iload 1
      // 009: ifne 014
      // 00c: ifnull 022
      // 00f: goto 013
      // 012: athrow
      // 013: aload 0
      // 014: iload 1
      // 015: ifne 026
      // 018: invokevirtual java/lang/String.isEmpty ()Z
      // 01b: ifeq 025
      // 01e: goto 022
      // 021: athrow
      // 022: aconst_null
      // 023: areturn
      // 024: athrow
      // 025: aload 0
      // 026: invokestatic x/ocb50cc94190.ȓ (Ljava/lang/String;)Lx/ocb50cc94190;
      // 029: astore 2
      // 02a: aload 2
      // 02b: iload 1
      // 02c: ifne 037
      // 02f: ifnull 055
      // 032: goto 036
      // 035: athrow
      // 036: aload 2
      // 037: iload 1
      // 038: ifne 04a
      // 03b: getfield x/ocb50cc94190.ր Lnet/minecraft/item/ItemStack;
      // 03e: ifnull 053
      // 041: goto 045
      // 044: athrow
      // 045: aload 2
      // 046: goto 04a
      // 049: athrow
      // 04a: getfield x/ocb50cc94190.ր Lnet/minecraft/item/ItemStack;
      // 04d: invokevirtual net/minecraft/item/ItemStack.copy ()Lnet/minecraft/item/ItemStack;
      // 050: goto 054
      // 053: aconst_null
      // 054: areturn
      // 055: aload 0
      // 056: iload 1
      // 057: ifne 094
      // 05a: invokestatic x/oc920065c394.У (Ljava/lang/String;)Z
      // 05d: ifeq 090
      // 060: goto 064
      // 063: athrow
      // 064: aload 0
      // 065: invokestatic x/oc920065c394.ϑ (Ljava/lang/String;)Ljava/lang/String;
      // 068: invokestatic x/oc920065c394.ӛ (Ljava/lang/String;)Ljava/util/List;
      // 06b: astore 3
      // 06c: aload 3
      // 06d: iload 1
      // 06e: ifne 089
      // 071: invokeinterface java/util/List.isEmpty ()Z 1
      // 076: ifeq 082
      // 079: goto 07d
      // 07c: athrow
      // 07d: aconst_null
      // 07e: goto 08f
      // 081: athrow
      // 082: aload 3
      // 083: bipush 0
      // 084: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 089: checkcast x/oc2ef79a3df1
      // 08c: invokevirtual x/oc2ef79a3df1.ȋ ()Lnet/minecraft/item/ItemStack;
      // 08f: areturn
      // 090: aload 0
      // 091: invokestatic x/oc920065c394.ϑ (Ljava/lang/String;)Ljava/lang/String;
      // 094: astore 3
      // 095: aload 3
      // 096: iload 1
      // 097: ifne 0a5
      // 09a: ifnonnull 0a4
      // 09d: goto 0a1
      // 0a0: athrow
      // 0a1: aconst_null
      // 0a2: areturn
      // 0a3: athrow
      // 0a4: aload 3
      // 0a5: invokestatic x/oc920065c394.ӛ (Ljava/lang/String;)Ljava/util/List;
      // 0a8: astore 4
      // 0aa: aload 4
      // 0ac: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 0b1: astore 5
      // 0b3: aload 5
      // 0b5: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 0ba: ifeq 0e8
      // 0bd: aload 5
      // 0bf: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 0c4: checkcast x/oc2ef79a3df1
      // 0c7: astore 6
      // 0c9: aload 0
      // 0ca: iload 1
      // 0cb: ifne 0e9
      // 0ce: aload 6
      // 0d0: getfield x/oc2ef79a3df1.Ѩ Ljava/lang/String;
      // 0d3: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 0d6: ifeq 0e4
      // 0d9: goto 0dd
      // 0dc: athrow
      // 0dd: aload 6
      // 0df: invokevirtual x/oc2ef79a3df1.ȋ ()Lnet/minecraft/item/ItemStack;
      // 0e2: areturn
      // 0e3: athrow
      // 0e4: iload 1
      // 0e5: ifeq 0b3
      // 0e8: aload 3
      // 0e9: invokestatic x/oc920065c394.Ž (Ljava/lang/String;)Lnet/minecraft/item/Item;
      // 0ec: astore 5
      // 0ee: aload 5
      // 0f0: ifnonnull 0f6
      // 0f3: aconst_null
      // 0f4: areturn
      // 0f5: athrow
      // 0f6: new net/minecraft/item/ItemStack
      // 0f9: dup
      // 0fa: aload 5
      // 0fc: bipush 1
      // 0fd: aload 0
      // 0fe: invokestatic x/oc920065c394.ĸ (Ljava/lang/String;)I
      // 101: invokespecial net/minecraft/item/ItemStack.<init> (Lnet/minecraft/item/Item;II)V
      // 104: areturn
   }

   public static String ҟ(String var0) {
      int var10000 = oc75d51ec7eb.ϩ;
      ocb50cc94190 var2 = ocb50cc94190.ȓ(var0);
      int var1 = var10000;
      if (var2 != null) {
         List var9 = ӛ(var0);

         try {
            if (var9.size() > 1) {
               return var2.ԛ + " (All)";
            }
         } catch (NumberFormatException var4) {
            throw var4;
         }

         return var2.ԛ;
      } else {
         label94: {
            label72: {
               try {
                  var10 = var0;
                  if (var1 != 0) {
                     break label72;
                  }

                  if (У(var0)) {
                     break label94;
                  }
               } catch (NumberFormatException var7) {
                  throw var7;
               }

               var10 = var0;
            }

            ItemStack var8 = t(var10);

            try {
               if (var1 != 0) {
                  return var8.getDisplayName();
               }

               if (var8 == null) {
                  return var0;
               }
            } catch (NumberFormatException var6) {
               throw var6;
            }

            return var8.getDisplayName();
         }

         List var3 = ӛ(ϑ(var0));

         try {
            if (!var3.isEmpty()) {
               return õ(ϑ(var0), var3) + " (All)";
            }
         } catch (NumberFormatException var5) {
            throw var5;
         }

         return var0;
      }
   }

   private static void ǽ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc75d51ec7eb.ϩ I
      // 003: istore 0
      // 004: getstatic x/oc920065c394.Í Ljava/util/List;
      // 007: ifnull 00c
      // 00a: return
      // 00b: athrow
      // 00c: new java/util/ArrayList
      // 00f: dup
      // 010: invokespecial java/util/ArrayList.<init> ()V
      // 013: astore 1
      // 014: new java/util/HashMap
      // 017: dup
      // 018: invokespecial java/util/HashMap.<init> ()V
      // 01b: astore 2
      // 01c: getstatic net/minecraft/item/Item.itemRegistry Lnet/minecraft/util/RegistryNamespaced;
      // 01f: invokevirtual net/minecraft/util/RegistryNamespaced.iterator ()Ljava/util/Iterator;
      // 022: astore 3
      // 023: aload 3
      // 024: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 029: ifeq 1b0
      // 02c: aload 3
      // 02d: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 032: astore 4
      // 034: iload 0
      // 035: ifne 1bb
      // 038: aload 4
      // 03a: checkcast net/minecraft/item/Item
      // 03d: astore 5
      // 03f: aload 5
      // 041: invokestatic x/oc920065c394.ƅ (Lnet/minecraft/item/Item;)Ljava/lang/String;
      // 044: astore 6
      // 046: aload 6
      // 048: ifnonnull 053
      // 04b: iload 0
      // 04c: ifeq 023
      // 04f: goto 053
      // 052: athrow
      // 053: new java/util/ArrayList
      // 056: dup
      // 057: invokespecial java/util/ArrayList.<init> ()V
      // 05a: astore 7
      // 05c: aload 5
      // 05e: aload 7
      // 060: invokestatic x/oc920065c394.ŉ (Lnet/minecraft/item/Item;Ljava/util/List;)V
      // 063: aload 7
      // 065: iload 0
      // 066: ifne 07b
      // 069: invokeinterface java/util/List.isEmpty ()Z 1
      // 06e: ifeq 08c
      // 071: goto 075
      // 074: athrow
      // 075: aload 7
      // 077: goto 07b
      // 07a: athrow
      // 07b: new net/minecraft/item/ItemStack
      // 07e: dup
      // 07f: aload 5
      // 081: bipush 1
      // 082: bipush 0
      // 083: invokespecial net/minecraft/item/ItemStack.<init> (Lnet/minecraft/item/Item;II)V
      // 086: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 08b: pop
      // 08c: new java/util/LinkedHashMap
      // 08f: dup
      // 090: invokespecial java/util/LinkedHashMap.<init> ()V
      // 093: astore 8
      // 095: aload 7
      // 097: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 09c: astore 9
      // 09e: aload 9
      // 0a0: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 0a5: ifeq 167
      // 0a8: aload 9
      // 0aa: iload 0
      // 0ab: ifne 024
      // 0ae: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 0b3: checkcast net/minecraft/item/ItemStack
      // 0b6: astore 10
      // 0b8: aload 10
      // 0ba: iload 0
      // 0bb: ifne 0c7
      // 0be: ifnull 09e
      // 0c1: goto 0c5
      // 0c4: athrow
      // 0c5: aload 10
      // 0c7: iload 0
      // 0c8: ifne 0df
      // 0cb: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 0ce: ifnonnull 0dd
      // 0d1: goto 0d5
      // 0d4: athrow
      // 0d5: iload 0
      // 0d6: ifeq 09e
      // 0d9: goto 0dd
      // 0dc: athrow
      // 0dd: aload 10
      // 0df: invokestatic x/oc920065c394.Ձ (Lnet/minecraft/item/ItemStack;)Ljava/lang/String;
      // 0e2: astore 11
      // 0e4: aload 11
      // 0e6: ifnull 09e
      // 0e9: aload 8
      // 0eb: aload 11
      // 0ed: invokeinterface java/util/Map.containsKey (Ljava/lang/Object;)Z 2
      // 0f2: ifeq 0fd
      // 0f5: iload 0
      // 0f6: ifeq 09e
      // 0f9: goto 0fd
      // 0fc: athrow
      // 0fd: aload 10
      // 0ff: invokevirtual net/minecraft/item/ItemStack.getDisplayName ()Ljava/lang/String;
      // 102: astore 12
      // 104: aload 12
      // 106: iload 0
      // 107: ifne 113
      // 10a: ifnull 09e
      // 10d: goto 111
      // 110: athrow
      // 111: aload 12
      // 113: invokevirtual java/lang/String.isEmpty ()Z
      // 116: iload 0
      // 117: ifne 12e
      // 11a: ifeq 129
      // 11d: goto 121
      // 120: athrow
      // 121: iload 0
      // 122: ifeq 09e
      // 125: goto 129
      // 128: athrow
      // 129: aload 5
      // 12b: invokestatic x/oc920065c394.ё (Lnet/minecraft/item/Item;)Z
      // 12e: iload 0
      // 12f: ifne 142
      // 132: ifeq 145
      // 135: goto 139
      // 138: athrow
      // 139: aload 10
      // 13b: invokevirtual net/minecraft/item/ItemStack.getMetadata ()I
      // 13e: goto 142
      // 141: athrow
      // 142: goto 146
      // 145: bipush 0
      // 146: istore 13
      // 148: iload 0
      // 149: aload 8
      // 14b: aload 11
      // 14d: new x/oc2ef79a3df1
      // 150: dup
      // 151: aload 5
      // 153: iload 13
      // 155: aload 12
      // 157: aload 11
      // 159: aload 10
      // 15b: invokespecial x/oc2ef79a3df1.<init> (Lnet/minecraft/item/Item;ILjava/lang/String;Ljava/lang/String;Lnet/minecraft/item/ItemStack;)V
      // 15e: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 163: pop
      // 164: ifeq 09e
      // 167: aload 8
      // 169: invokeinterface java/util/Map.isEmpty ()Z 1
      // 16e: ifeq 179
      // 171: iload 0
      // 172: ifeq 023
      // 175: goto 179
      // 178: athrow
      // 179: new java/util/ArrayList
      // 17c: dup
      // 17d: aload 8
      // 17f: invokeinterface java/util/Map.values ()Ljava/util/Collection; 1
      // 184: invokespecial java/util/ArrayList.<init> (Ljava/util/Collection;)V
      // 187: astore 9
      // 189: iload 0
      // 18a: aload 9
      // 18c: invokedynamic applyAsInt ()Ljava/util/function/ToIntFunction; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)I, x/oc920065c394.q3vf2n3nejlgd5 (Lx/oc2ef79a3df1;)I, (Lx/oc2ef79a3df1;)I ]
      // 191: invokestatic java/util/Comparator.comparingInt (Ljava/util/function/ToIntFunction;)Ljava/util/Comparator;
      // 194: invokeinterface java/util/List.sort (Ljava/util/Comparator;)V 2
      // 199: aload 1
      // 19a: aload 9
      // 19c: invokeinterface java/util/List.addAll (Ljava/util/Collection;)Z 2
      // 1a1: pop
      // 1a2: aload 2
      // 1a3: aload 6
      // 1a5: aload 9
      // 1a7: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 1ac: pop
      // 1ad: ifeq 023
      // 1b0: new java/util/ArrayList
      // 1b3: dup
      // 1b4: aload 1
      // 1b5: invokespecial java/util/ArrayList.<init> (Ljava/util/Collection;)V
      // 1b8: putstatic x/oc920065c394.Í Ljava/util/List;
      // 1bb: invokestatic x/ocb50cc94190.values ()[Lx/ocb50cc94190;
      // 1be: astore 3
      // 1bf: aload 3
      // 1c0: arraylength
      // 1c1: istore 4
      // 1c3: bipush 0
      // 1c4: istore 5
      // 1c6: iload 5
      // 1c8: iload 4
      // 1ca: if_icmpge 282
      // 1cd: aload 3
      // 1ce: iload 5
      // 1d0: aaload
      // 1d1: astore 6
      // 1d3: iload 0
      // 1d4: ifne 2a3
      // 1d7: aload 6
      // 1d9: invokevirtual x/ocb50cc94190.ǿ ()Lx/oc2ef79a3df1;
      // 1dc: astore 7
      // 1de: getstatic x/oc920065c394.Í Ljava/util/List;
      // 1e1: aload 7
      // 1e3: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 1e8: pop
      // 1e9: new java/util/ArrayList
      // 1ec: dup
      // 1ed: invokespecial java/util/ArrayList.<init> ()V
      // 1f0: astore 8
      // 1f2: aload 1
      // 1f3: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 1f8: astore 9
      // 1fa: aload 9
      // 1fc: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 201: ifeq 23b
      // 204: aload 9
      // 206: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 20b: checkcast x/oc2ef79a3df1
      // 20e: iload 0
      // 20f: ifne 27a
      // 212: astore 10
      // 214: aload 6
      // 216: aload 10
      // 218: invokevirtual x/oc2ef79a3df1.ȋ ()Lnet/minecraft/item/ItemStack;
      // 21b: invokevirtual x/ocb50cc94190.z$2opx8s6bbbs2u (Lnet/minecraft/item/ItemStack;)Z
      // 21e: iload 0
      // 21f: ifne 236
      // 222: ifeq 237
      // 225: goto 229
      // 228: athrow
      // 229: aload 8
      // 22b: aload 10
      // 22d: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 232: goto 236
      // 235: athrow
      // 236: pop
      // 237: iload 0
      // 238: ifeq 1fa
      // 23b: aload 8
      // 23d: invokedynamic apply ()Ljava/util/function/Function; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Ljava/lang/Object;, x/oc920065c394.q1xa15lyx7xs2t (Lx/oc2ef79a3df1;)Ljava/lang/String;, (Lx/oc2ef79a3df1;)Ljava/lang/String; ]
      // 242: getstatic java/lang/String.CASE_INSENSITIVE_ORDER Ljava/util/Comparator;
      // 245: invokestatic java/util/Comparator.comparing (Ljava/util/function/Function;Ljava/util/Comparator;)Ljava/util/Comparator;
      // 248: invokeinterface java/util/List.sort (Ljava/util/Comparator;)V 2
      // 24d: iload 0
      // 24e: ifne 27e
      // 251: aload 8
      // 253: invokeinterface java/util/List.isEmpty ()Z 1
      // 258: ifeq 26d
      // 25b: goto 25f
      // 25e: athrow
      // 25f: aload 8
      // 261: aload 7
      // 263: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 268: pop
      // 269: goto 26d
      // 26c: athrow
      // 26d: aload 2
      // 26e: aload 6
      // 270: getfield x/ocb50cc94190.ϗ Ljava/lang/String;
      // 273: aload 8
      // 275: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 27a: pop
      // 27b: iinc 5 1
      // 27e: iload 0
      // 27f: ifeq 1c6
      // 282: getstatic x/oc920065c394.Í Ljava/util/List;
      // 285: invokedynamic apply ()Ljava/util/function/Function; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Ljava/lang/Object;, x/oc920065c394.qkbolll38e7zx (Lx/oc2ef79a3df1;)Ljava/lang/String;, (Lx/oc2ef79a3df1;)Ljava/lang/String; ]
      // 28a: getstatic java/lang/String.CASE_INSENSITIVE_ORDER Ljava/util/Comparator;
      // 28d: invokestatic java/util/Comparator.comparing (Ljava/util/function/Function;Ljava/util/Comparator;)Ljava/util/Comparator;
      // 290: invokedynamic apply ()Ljava/util/function/Function; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Ljava/lang/Object;, x/oc920065c394.q3hv0n3d1zhslu (Lx/oc2ef79a3df1;)Ljava/lang/String;, (Lx/oc2ef79a3df1;)Ljava/lang/String; ]
      // 295: invokeinterface java/util/Comparator.thenComparing (Ljava/util/function/Function;)Ljava/util/Comparator; 2
      // 29a: invokeinterface java/util/List.sort (Ljava/util/Comparator;)V 2
      // 29f: aload 2
      // 2a0: putstatic x/oc920065c394.U Ljava/util/Map;
      // 2a3: return
   }

   private static boolean ş(oc2ef79a3df1 var0, oc2ec6a95e5c var1) {
      int var2 = oc75d51ec7eb.ϩ;

      try {
         if (var1 == null) {
            return false;
         }
      } catch (NumberFormatException var5) {
         throw var5;
      }

      ocb50cc94190 var3 = ocb50cc94190.ȓ(var0.Ѩ);

      try {
         if (var2 != 0) {
            return var3.ո(var1.ǟ());
         }

         if (var3 == null) {
            return var1.b(var0.ȋ());
         }
      } catch (NumberFormatException var4) {
         throw var4;
      }

      return var3.ո(var1.ǟ());
   }

   private static String Ή(String param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: aload 0
      // 04: invokestatic x/ocb50cc94190.ȓ (Ljava/lang/String;)Lx/ocb50cc94190;
      // 07: astore 2
      // 08: istore 1
      // 09: aload 2
      // 0a: iload 1
      // 0b: ifne 16
      // 0e: ifnull 1a
      // 11: goto 15
      // 14: athrow
      // 15: aload 2
      // 16: getfield x/ocb50cc94190.ԛ Ljava/lang/String;
      // 19: areturn
      // 1a: aload 0
      // 1b: invokestatic x/oc920065c394.ϑ (Ljava/lang/String;)Ljava/lang/String;
      // 1e: astore 3
      // 1f: aload 3
      // 20: iload 1
      // 21: ifne 2f
      // 24: ifnonnull 2e
      // 27: goto 2b
      // 2a: athrow
      // 2b: aload 0
      // 2c: areturn
      // 2d: athrow
      // 2e: aload 3
      // 2f: ldc_w -1921564047
      // 32: ldc_w -1921564085
      // 35: ixor
      // 36: invokevirtual java/lang/String.indexOf (I)I
      // 39: istore 4
      // 3b: iload 4
      // 3d: iflt 4c
      // 40: aload 3
      // 41: iload 4
      // 43: bipush 1
      // 44: iadd
      // 45: invokevirtual java/lang/String.substring (I)Ljava/lang/String;
      // 48: goto 4d
      // 4b: athrow
      // 4c: aload 3
      // 4d: areturn
   }

   private static String õ(String param0, List<oc2ef79a3df1> param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: aload 0
      // 04: invokestatic x/ocb50cc94190.ȓ (Ljava/lang/String;)Lx/ocb50cc94190;
      // 07: astore 3
      // 08: istore 2
      // 09: aload 3
      // 0a: iload 2
      // 0b: ifne 16
      // 0e: ifnull 1a
      // 11: goto 15
      // 14: athrow
      // 15: aload 3
      // 16: getfield x/ocb50cc94190.ԛ Ljava/lang/String;
      // 19: areturn
      // 1a: aload 1
      // 1b: iload 2
      // 1c: ifne 36
      // 1f: invokeinterface java/util/List.isEmpty ()Z 1
      // 24: ifne 3f
      // 27: goto 2b
      // 2a: athrow
      // 2b: aload 1
      // 2c: bipush 0
      // 2d: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 32: goto 36
      // 35: athrow
      // 36: checkcast x/oc2ef79a3df1
      // 39: getfield x/oc2ef79a3df1.Ѧ Ljava/lang/String;
      // 3c: goto 40
      // 3f: aload 0
      // 40: areturn
   }

   private static void ŉ(Item param0, List<ItemStack> param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 2
      // 04: aload 0
      // 05: aload 0
      // 06: getstatic net/minecraft/creativetab/CreativeTabs.tabAllSearch Lnet/minecraft/creativetab/CreativeTabs;
      // 09: aload 1
      // 0a: invokevirtual net/minecraft/item/Item.getSubItems (Lnet/minecraft/item/Item;Lnet/minecraft/creativetab/CreativeTabs;Ljava/util/List;)V
      // 0d: goto 11
      // 10: astore 3
      // 11: aload 1
      // 12: invokeinterface java/util/List.isEmpty ()Z 1
      // 17: ifne 1c
      // 1a: return
      // 1b: athrow
      // 1c: aload 0
      // 1d: invokevirtual net/minecraft/item/Item.getCreativeTab ()Lnet/minecraft/creativetab/CreativeTabs;
      // 20: astore 3
      // 21: iload 2
      // 22: ifne 36
      // 25: aload 3
      // 26: ifnonnull 2f
      // 29: goto 2d
      // 2c: athrow
      // 2d: return
      // 2e: athrow
      // 2f: aload 0
      // 30: aload 0
      // 31: aload 3
      // 32: aload 1
      // 33: invokevirtual net/minecraft/item/Item.getSubItems (Lnet/minecraft/item/Item;Lnet/minecraft/creativetab/CreativeTabs;Ljava/util/List;)V
      // 36: goto 3b
      // 39: astore 4
      // 3b: return
   }

   private static int ĸ(String param0) {
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
      // 21: ldc_w 1028479504
      // 24: ldc_w 1028479507
      // 27: ixor
      // 28: if_icmplt 40
      // 2b: goto 2f
      // 2e: athrow
      // 2f: aload 2
      // 30: ldc_w 1028479505
      // 33: ldc_w 1028479507
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

   private static Item Ž(String var0) {
      try {
         return (Item)Item.itemRegistry.getObject(new ResourceLocation(var0));
      } catch (Exception var2) {
         return null;
      }
   }

   private static boolean ё(Item param0) {
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
      // 09: ifnull 36
      // 0c: goto 10
      // 0f: athrow
      // 10: aload 0
      // 11: iload 1
      // 12: ifne 24
      // 15: invokevirtual net/minecraft/item/Item.getHasSubtypes ()Z
      // 18: ifeq 36
      // 1b: goto 1f
      // 1e: athrow
      // 1f: aload 0
      // 20: goto 24
      // 23: athrow
      // 24: invokevirtual net/minecraft/item/Item.isDamageable ()Z
      // 27: iload 1
      // 28: ifne 33
      // 2b: ifne 36
      // 2e: goto 32
      // 31: athrow
      // 32: bipush 1
      // 33: goto 37
      // 36: bipush 0
      // 37: ireturn
   }

   private static boolean Ћ(Item param0) {
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
      // 05: instanceof net/minecraft/item/ItemTool
      // 08: iload 1
      // 09: ifne 3a
      // 0c: ifne 39
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: instanceof net/minecraft/item/ItemHoe
      // 17: iload 1
      // 18: ifne 3a
      // 1b: goto 1f
      // 1e: athrow
      // 1f: ifne 39
      // 22: goto 26
      // 25: athrow
      // 26: aload 0
      // 27: instanceof net/minecraft/item/ItemShears
      // 2a: iload 1
      // 2b: ifne 3a
      // 2e: goto 32
      // 31: athrow
      // 32: ifeq 3d
      // 35: goto 39
      // 38: athrow
      // 39: bipush 1
      // 3a: goto 3e
      // 3d: bipush 0
      // 3e: ireturn
   }
}
