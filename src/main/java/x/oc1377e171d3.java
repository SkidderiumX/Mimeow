package x;

import java.util.List;

public class oc1377e171d3 extends oc161f4adba4 {
   public static int Ù;

   public oc1377e171d3() {
      oc17aaf5d285 var10003 = oc17aaf5d285.ʝ;
      String[] var10004 = new String[799644435 ^ 799644443];
      var10004[0] = "config";
      var10004[1] = "config list";
      var10004[799644441 ^ 799644443] = "config refresh";
      var10004[799644440 ^ 799644443] = "config folder";
      var10004[799644447 ^ 799644443] = "config save <name>";
      var10004[799644446 ^ 799644443] = "config load <name>";
      var10004[799644445 ^ 799644443] = "config delete <name>";
      var10004[799644444 ^ 799644443] = "config rename <old> <new>";
      String[] var10005 = new String[799644441 ^ 799644443];
      var10005[0] = "c";
      var10005[1] = "cfg";
      super("config", "Manage local configurations.", var10003, var10004, var10005);
   }

   public void z$2uoow1halcq2f(ocaae9de8508 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc24b4725b15.Ε I
      // 003: istore 2
      // 004: aload 1
      // 005: iload 2
      // 006: ifne 01a
      // 009: invokevirtual x/ocaae9de8508.Ӿ ()I
      // 00c: ifne 019
      // 00f: goto 013
      // 012: athrow
      // 013: aload 0
      // 014: invokevirtual x/oc1377e171d3.ə ()V
      // 017: return
      // 018: athrow
      // 019: aload 1
      // 01a: bipush 0
      // 01b: invokevirtual x/ocaae9de8508.ь (I)Ljava/lang/String;
      // 01e: invokevirtual java/lang/String.toLowerCase ()Ljava/lang/String;
      // 021: astore 3
      // 022: aload 3
      // 023: astore 4
      // 025: bipush -1
      // 026: istore 5
      // 028: aload 4
      // 02a: invokevirtual java/lang/String.hashCode ()I
      // 02d: iload 2
      // 02e: ifne 29a
      // 031: lookupswitch 615 15 -1335458389 487 -1268966290 256 -934641255 223 -934610812 520 -934594754 586 108 454 114 553 115 388 3463 161 99469 289 3322014 132 3327206 421 3417674 322 3522941 355 1085444827 190
      // 0b4: athrow
      // 0b5: aload 4
      // 0b7: ldc "list"
      // 0b9: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 0bc: iload 2
      // 0bd: ifne 29a
      // 0c0: goto 0c4
      // 0c3: athrow
      // 0c4: ifeq 298
      // 0c7: goto 0cb
      // 0ca: athrow
      // 0cb: bipush 0
      // 0cc: istore 5
      // 0ce: iload 2
      // 0cf: ifeq 298
      // 0d2: aload 4
      // 0d4: ldc "ls"
      // 0d6: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 0d9: iload 2
      // 0da: ifne 29a
      // 0dd: goto 0e1
      // 0e0: athrow
      // 0e1: ifeq 298
      // 0e4: goto 0e8
      // 0e7: athrow
      // 0e8: bipush 1
      // 0e9: istore 5
      // 0eb: iload 2
      // 0ec: ifeq 298
      // 0ef: aload 4
      // 0f1: ldc "refresh"
      // 0f3: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 0f6: iload 2
      // 0f7: ifne 29a
      // 0fa: goto 0fe
      // 0fd: athrow
      // 0fe: ifeq 298
      // 101: goto 105
      // 104: athrow
      // 105: ldc -1781088800
      // 107: ldc -1781088798
      // 109: ixor
      // 10a: istore 5
      // 10c: iload 2
      // 10d: ifeq 298
      // 110: aload 4
      // 112: ldc "reload"
      // 114: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 117: iload 2
      // 118: ifne 29a
      // 11b: goto 11f
      // 11e: athrow
      // 11f: ifeq 298
      // 122: goto 126
      // 125: athrow
      // 126: ldc -1781088799
      // 128: ldc -1781088798
      // 12a: ixor
      // 12b: istore 5
      // 12d: iload 2
      // 12e: ifeq 298
      // 131: aload 4
      // 133: ldc "folder"
      // 135: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 138: iload 2
      // 139: ifne 29a
      // 13c: goto 140
      // 13f: athrow
      // 140: ifeq 298
      // 143: goto 147
      // 146: athrow
      // 147: ldc -1781088794
      // 149: ldc -1781088798
      // 14b: ixor
      // 14c: istore 5
      // 14e: iload 2
      // 14f: ifeq 298
      // 152: aload 4
      // 154: ldc "dir"
      // 156: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 159: iload 2
      // 15a: ifne 29a
      // 15d: goto 161
      // 160: athrow
      // 161: ifeq 298
      // 164: goto 168
      // 167: athrow
      // 168: ldc -1781088793
      // 16a: ldc -1781088798
      // 16c: ixor
      // 16d: istore 5
      // 16f: iload 2
      // 170: ifeq 298
      // 173: aload 4
      // 175: ldc "open"
      // 177: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 17a: iload 2
      // 17b: ifne 29a
      // 17e: goto 182
      // 181: athrow
      // 182: ifeq 298
      // 185: goto 189
      // 188: athrow
      // 189: ldc -1781088796
      // 18b: ldc -1781088798
      // 18d: ixor
      // 18e: istore 5
      // 190: iload 2
      // 191: ifeq 298
      // 194: aload 4
      // 196: ldc "save"
      // 198: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 19b: iload 2
      // 19c: ifne 29a
      // 19f: goto 1a3
      // 1a2: athrow
      // 1a3: ifeq 298
      // 1a6: goto 1aa
      // 1a9: athrow
      // 1aa: ldc -1781088795
      // 1ac: ldc -1781088798
      // 1ae: ixor
      // 1af: istore 5
      // 1b1: iload 2
      // 1b2: ifeq 298
      // 1b5: aload 4
      // 1b7: ldc "s"
      // 1b9: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 1bc: iload 2
      // 1bd: ifne 29a
      // 1c0: goto 1c4
      // 1c3: athrow
      // 1c4: ifeq 298
      // 1c7: goto 1cb
      // 1ca: athrow
      // 1cb: ldc -1781088790
      // 1cd: ldc -1781088798
      // 1cf: ixor
      // 1d0: istore 5
      // 1d2: iload 2
      // 1d3: ifeq 298
      // 1d6: aload 4
      // 1d8: ldc "load"
      // 1da: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 1dd: iload 2
      // 1de: ifne 29a
      // 1e1: goto 1e5
      // 1e4: athrow
      // 1e5: ifeq 298
      // 1e8: goto 1ec
      // 1eb: athrow
      // 1ec: ldc -1781088789
      // 1ee: ldc -1781088798
      // 1f0: ixor
      // 1f1: istore 5
      // 1f3: iload 2
      // 1f4: ifeq 298
      // 1f7: aload 4
      // 1f9: ldc "l"
      // 1fb: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 1fe: iload 2
      // 1ff: ifne 29a
      // 202: goto 206
      // 205: athrow
      // 206: ifeq 298
      // 209: goto 20d
      // 20c: athrow
      // 20d: ldc -1781088792
      // 20f: ldc -1781088798
      // 211: ixor
      // 212: istore 5
      // 214: iload 2
      // 215: ifeq 298
      // 218: aload 4
      // 21a: ldc "delete"
      // 21c: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 21f: iload 2
      // 220: ifne 29a
      // 223: goto 227
      // 226: athrow
      // 227: ifeq 298
      // 22a: goto 22e
      // 22d: athrow
      // 22e: ldc -1781088791
      // 230: ldc -1781088798
      // 232: ixor
      // 233: istore 5
      // 235: iload 2
      // 236: ifeq 298
      // 239: aload 4
      // 23b: ldc "remove"
      // 23d: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 240: iload 2
      // 241: ifne 29a
      // 244: goto 248
      // 247: athrow
      // 248: ifeq 298
      // 24b: goto 24f
      // 24e: athrow
      // 24f: ldc -1781088786
      // 251: ldc -1781088798
      // 253: ixor
      // 254: istore 5
      // 256: iload 2
      // 257: ifeq 298
      // 25a: aload 4
      // 25c: ldc "r"
      // 25e: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 261: iload 2
      // 262: ifne 29a
      // 265: goto 269
      // 268: athrow
      // 269: ifeq 298
      // 26c: goto 270
      // 26f: athrow
      // 270: ldc -1781088785
      // 272: ldc -1781088798
      // 274: ixor
      // 275: istore 5
      // 277: iload 2
      // 278: ifeq 298
      // 27b: aload 4
      // 27d: ldc "rename"
      // 27f: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 282: iload 2
      // 283: ifne 29a
      // 286: goto 28a
      // 289: athrow
      // 28a: ifeq 298
      // 28d: goto 291
      // 290: athrow
      // 291: ldc -1781088788
      // 293: ldc -1781088798
      // 295: ixor
      // 296: istore 5
      // 298: iload 5
      // 29a: tableswitch 114 0 14 74 74 80 80 85 85 85 90 90 96 96 102 102 102 108
      // 2e4: aload 0
      // 2e5: invokevirtual x/oc1377e171d3.ə ()V
      // 2e8: return
      // 2e9: athrow
      // 2ea: aload 0
      // 2eb: invokevirtual x/oc1377e171d3.Ļ ()V
      // 2ee: return
      // 2ef: aload 0
      // 2f0: invokevirtual x/oc1377e171d3.λ ()V
      // 2f3: return
      // 2f4: aload 0
      // 2f5: aload 1
      // 2f6: invokevirtual x/oc1377e171d3.ƅ (Lx/ocaae9de8508;)V
      // 2f9: return
      // 2fa: aload 0
      // 2fb: aload 1
      // 2fc: invokevirtual x/oc1377e171d3.ɨ (Lx/ocaae9de8508;)V
      // 2ff: return
      // 300: aload 0
      // 301: aload 1
      // 302: invokevirtual x/oc1377e171d3.ɘ (Lx/ocaae9de8508;)V
      // 305: return
      // 306: aload 0
      // 307: aload 1
      // 308: invokevirtual x/oc1377e171d3.á (Lx/ocaae9de8508;)V
      // 30b: return
      // 30c: aload 0
      // 30d: invokevirtual x/oc161f4adba4.ǻ ()V
      // 310: return
   }

   public List<String> z$9ofids0wyz4j(ocaae9de8508 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc24b4725b15.Ε I
      // 03: istore 2
      // 04: aload 1
      // 05: iload 2
      // 06: ifne 7f
      // 09: invokevirtual x/ocaae9de8508.Ӿ ()I
      // 0c: bipush 1
      // 0d: if_icmpne 7e
      // 10: goto 14
      // 13: athrow
      // 14: aload 0
      // 15: aload 1
      // 16: ldc -488242041
      // 18: ldc -488242036
      // 1a: ixor
      // 1b: anewarray 34
      // 1e: dup
      // 1f: bipush 0
      // 20: ldc "list"
      // 22: aastore
      // 23: dup
      // 24: bipush 1
      // 25: ldc "refresh"
      // 27: aastore
      // 28: dup
      // 29: ldc -488242034
      // 2b: ldc -488242036
      // 2d: ixor
      // 2e: ldc "folder"
      // 30: aastore
      // 31: dup
      // 32: ldc -488242033
      // 34: ldc -488242036
      // 36: ixor
      // 37: ldc "save"
      // 39: aastore
      // 3a: dup
      // 3b: ldc -488242040
      // 3d: ldc -488242036
      // 3f: ixor
      // 40: ldc "s"
      // 42: aastore
      // 43: dup
      // 44: ldc -488242039
      // 46: ldc -488242036
      // 48: ixor
      // 49: ldc "load"
      // 4b: aastore
      // 4c: dup
      // 4d: ldc -488242038
      // 4f: ldc -488242036
      // 51: ixor
      // 52: ldc "l"
      // 54: aastore
      // 55: dup
      // 56: ldc -488242037
      // 58: ldc -488242036
      // 5a: ixor
      // 5b: ldc "delete"
      // 5d: aastore
      // 5e: dup
      // 5f: ldc -488242044
      // 61: ldc -488242036
      // 63: ixor
      // 64: ldc "remove"
      // 66: aastore
      // 67: dup
      // 68: ldc -488242043
      // 6a: ldc -488242036
      // 6c: ixor
      // 6d: ldc "r"
      // 6f: aastore
      // 70: dup
      // 71: ldc -488242042
      // 73: ldc -488242036
      // 75: ixor
      // 76: ldc "rename"
      // 78: aastore
      // 79: invokevirtual x/oc161f4adba4.Ġ (Lx/ocaae9de8508;[Ljava/lang/String;)Ljava/util/List;
      // 7c: areturn
      // 7d: athrow
      // 7e: aload 1
      // 7f: bipush 0
      // 80: invokevirtual x/ocaae9de8508.ь (I)Ljava/lang/String;
      // 83: astore 3
      // 84: aload 0
      // 85: aload 3
      // 86: iload 2
      // 87: ifne a1
      // 8a: invokevirtual x/oc1377e171d3.Ъ (Ljava/lang/String;)Z
      // 8d: ifeq 9f
      // 90: goto 94
      // 93: athrow
      // 94: aload 0
      // 95: aload 1
      // 96: bipush 1
      // 97: invokevirtual x/ocaae9de8508.ͺ (I)Ljava/lang/String;
      // 9a: invokevirtual x/oc1377e171d3.C (Ljava/lang/String;)Ljava/util/List;
      // 9d: areturn
      // 9e: athrow
      // 9f: aload 0
      // a0: aload 3
      // a1: invokevirtual x/oc1377e171d3.Ĩ (Ljava/lang/String;)Z
      // a4: iload 2
      // a5: ifne b7
      // a8: ifeq ca
      // ab: goto af
      // ae: athrow
      // af: aload 1
      // b0: invokevirtual x/ocaae9de8508.Ӿ ()I
      // b3: goto b7
      // b6: athrow
      // b7: ldc -488242034
      // b9: ldc -488242036
      // bb: ixor
      // bc: if_icmpne ca
      // bf: aload 0
      // c0: aload 1
      // c1: bipush 1
      // c2: invokevirtual x/ocaae9de8508.ͺ (I)Ljava/lang/String;
      // c5: invokevirtual x/oc1377e171d3.C (Ljava/lang/String;)Ljava/util/List;
      // c8: areturn
      // c9: athrow
      // ca: new java/util/ArrayList
      // cd: dup
      // ce: invokespecial java/util/ArrayList.<init> ()V
      // d1: areturn
   }

   private void ə() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc24b4725b15.Ε I
      // 003: istore 1
      // 004: iload 1
      // 005: new java/util/ArrayList
      // 008: dup
      // 009: getstatic x/oc2cf3d80e17.Á Lx/oc7d9b6bd5c4;
      // 00c: invokevirtual x/oc7d9b6bd5c4.ž ()Ljava/util/List;
      // 00f: invokespecial java/util/ArrayList.<init> (Ljava/util/Collection;)V
      // 012: astore 2
      // 013: ifne 03e
      // 016: aload 2
      // 017: invokedynamic apply ()Ljava/util/function/Function; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Ljava/lang/Object;, java/io/File.getName ()Ljava/lang/String;, (Ljava/io/File;)Ljava/lang/String; ]
      // 01c: getstatic java/lang/String.CASE_INSENSITIVE_ORDER Ljava/util/Comparator;
      // 01f: invokestatic java/util/Comparator.comparing (Ljava/util/function/Function;Ljava/util/Comparator;)Ljava/util/Comparator;
      // 022: invokeinterface java/util/List.sort (Ljava/util/Comparator;)V 2
      // 027: aload 2
      // 028: invokeinterface java/util/List.isEmpty ()Z 1
      // 02d: ifeq 03f
      // 030: goto 034
      // 033: athrow
      // 034: aload 0
      // 035: ldc "&7No configs found."
      // 037: invokevirtual x/oc161f4adba4.ɇ (Ljava/lang/String;)V
      // 03a: goto 03e
      // 03d: athrow
      // 03e: return
      // 03f: aload 0
      // 040: aload 2
      // 041: invokeinterface java/util/List.size ()I 1
      // 046: aload 2
      // 047: invokeinterface java/util/List.size ()I 1
      // 04c: bipush 1
      // 04d: if_icmpne 057
      // 050: ldc_w ""
      // 053: goto 059
      // 056: athrow
      // 057: ldc "s"
      // 059: ldc_w "&b"
      // 05c: dup_x2
      // 05d: pop
      // 05e: ldc_w " &7config"
      // 061: swap
      // 062: ldc_w ":"
      // 065: invokedynamic makeConcatWithConstants (Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001\u0001\u0001" ]
      // 06a: invokevirtual x/oc161f4adba4.ɇ (Ljava/lang/String;)V
      // 06d: getstatic x/oc2cf3d80e17.ĕ Lx/oc151419fdfe;
      // 070: iload 1
      // 071: ifne 083
      // 074: ifnonnull 080
      // 077: goto 07b
      // 07a: athrow
      // 07b: aconst_null
      // 07c: goto 086
      // 07f: athrow
      // 080: getstatic x/oc2cf3d80e17.ĕ Lx/oc151419fdfe;
      // 083: invokevirtual x/oc151419fdfe.Ġ ()Ljava/lang/String;
      // 086: astore 3
      // 087: aload 2
      // 088: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 08d: astore 4
      // 08f: aload 4
      // 091: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 096: ifeq 10d
      // 099: aload 4
      // 09b: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 0a0: checkcast java/io/File
      // 0a3: astore 5
      // 0a5: aload 5
      // 0a7: invokevirtual java/io/File.getName ()Ljava/lang/String;
      // 0aa: astore 6
      // 0ac: aload 6
      // 0ae: bipush 0
      // 0af: aload 6
      // 0b1: invokevirtual java/lang/String.length ()I
      // 0b4: ldc_w ".json"
      // 0b7: invokevirtual java/lang/String.length ()I
      // 0ba: isub
      // 0bb: invokevirtual java/lang/String.substring (II)Ljava/lang/String;
      // 0be: astore 7
      // 0c0: aload 3
      // 0c1: iload 1
      // 0c2: ifne 0cd
      // 0c5: ifnull 0e1
      // 0c8: goto 0cc
      // 0cb: athrow
      // 0cc: aload 3
      // 0cd: aload 7
      // 0cf: invokevirtual java/lang/String.equalsIgnoreCase (Ljava/lang/String;)Z
      // 0d2: iload 1
      // 0d3: ifne 0de
      // 0d6: ifeq 0e1
      // 0d9: goto 0dd
      // 0dc: athrow
      // 0dd: bipush 1
      // 0de: goto 0e2
      // 0e1: bipush 0
      // 0e2: istore 8
      // 0e4: aload 0
      // 0e5: aload 7
      // 0e7: iload 8
      // 0e9: ifeq 0f3
      // 0ec: ldc_w " &7(&bcurrent&7)"
      // 0ef: goto 0f6
      // 0f2: athrow
      // 0f3: ldc_w ""
      // 0f6: astore 9
      // 0f8: astore 10
      // 0fa: ldc_w " &7"
      // 0fd: aload 10
      // 0ff: aload 9
      // 101: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001" ]
      // 106: invokevirtual x/oc161f4adba4.å (Ljava/lang/String;)V
      // 109: iload 1
      // 10a: ifeq 08f
      // 10d: return
   }

   private void Ļ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc24b4725b15.Ε I
      // 03: istore 1
      // 04: getstatic x/oc2cf3d80e17.Á Lx/oc7d9b6bd5c4;
      // 07: iload 1
      // 08: ifne 1e
      // 0b: ifnonnull 1b
      // 0e: goto 12
      // 11: athrow
      // 12: aload 0
      // 13: ldc_w "&cConfig manager is unavailable."
      // 16: invokevirtual x/oc161f4adba4.ɇ (Ljava/lang/String;)V
      // 19: return
      // 1a: athrow
      // 1b: getstatic x/oc2cf3d80e17.Á Lx/oc7d9b6bd5c4;
      // 1e: invokevirtual x/oc7d9b6bd5c4.Ё ()V
      // 21: return
   }

   private void λ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc24b4725b15.Ε I
      // 03: getstatic x/oc2cf3d80e17.Á Lx/oc7d9b6bd5c4;
      // 06: getfield x/oc7d9b6bd5c4.ю Ljava/io/File;
      // 09: astore 2
      // 0a: istore 1
      // 0b: aload 2
      // 0c: invokevirtual java/io/File.exists ()Z
      // 0f: iload 1
      // 10: ifne 39
      // 13: ifne 36
      // 16: goto 1a
      // 19: athrow
      // 1a: aload 2
      // 1b: invokevirtual java/io/File.mkdirs ()Z
      // 1e: iload 1
      // 1f: ifne 39
      // 22: goto 26
      // 25: athrow
      // 26: ifne 36
      // 29: goto 2d
      // 2c: athrow
      // 2d: aload 0
      // 2e: ldc_w "&cFailed to create the config folder."
      // 31: invokevirtual x/oc161f4adba4.ɇ (Ljava/lang/String;)V
      // 34: return
      // 35: athrow
      // 36: invokestatic java/awt/Desktop.isDesktopSupported ()Z
      // 39: iload 1
      // 3a: ifne 59
      // 3d: ifeq 5c
      // 40: goto 44
      // 43: athrow
      // 44: invokestatic java/awt/Desktop.getDesktop ()Ljava/awt/Desktop;
      // 47: iload 1
      // 48: ifne 68
      // 4b: goto 4f
      // 4e: athrow
      // 4f: getstatic java/awt/Desktop$Action.OPEN Ljava/awt/Desktop$Action;
      // 52: invokevirtual java/awt/Desktop.isSupported (Ljava/awt/Desktop$Action;)Z
      // 55: goto 59
      // 58: athrow
      // 59: ifne 65
      // 5c: aload 0
      // 5d: ldc_w "&cOpening folders is not supported on this system."
      // 60: invokevirtual x/oc161f4adba4.ɇ (Ljava/lang/String;)V
      // 63: return
      // 64: athrow
      // 65: invokestatic java/awt/Desktop.getDesktop ()Ljava/awt/Desktop;
      // 68: aload 2
      // 69: invokevirtual java/awt/Desktop.open (Ljava/io/File;)V
      // 6c: aload 0
      // 6d: aload 2
      // 6e: invokevirtual java/io/File.getAbsolutePath ()Ljava/lang/String;
      // 71: ldc_w "&7Opened config folder: &b"
      // 74: swap
      // 75: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 7a: invokevirtual x/oc161f4adba4.ɇ (Ljava/lang/String;)V
      // 7d: goto 92
      // 80: astore 3
      // 81: aload 0
      // 82: aload 2
      // 83: invokevirtual java/io/File.getAbsolutePath ()Ljava/lang/String;
      // 86: ldc_w "&cFailed to open config folder: &b"
      // 89: swap
      // 8a: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 8f: invokevirtual x/oc161f4adba4.ɇ (Ljava/lang/String;)V
      // 92: return
   }

   public int z$7k2utc7u0w8s(ocaae9de8508 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc24b4725b15.Ε I
      // 03: aload 1
      // 04: bipush 0
      // 05: invokevirtual x/ocaae9de8508.ь (I)Ljava/lang/String;
      // 08: astore 3
      // 09: istore 2
      // 0a: aload 0
      // 0b: aload 3
      // 0c: invokevirtual x/oc1377e171d3.Ъ (Ljava/lang/String;)Z
      // 0f: iload 2
      // 10: ifne 33
      // 13: ifne 2e
      // 16: goto 1a
      // 19: athrow
      // 1a: aload 0
      // 1b: iload 2
      // 1c: ifne 35
      // 1f: goto 23
      // 22: athrow
      // 23: aload 3
      // 24: invokevirtual x/oc1377e171d3.Ĩ (Ljava/lang/String;)Z
      // 27: ifeq 34
      // 2a: goto 2e
      // 2d: athrow
      // 2e: bipush 1
      // 2f: goto 33
      // 32: athrow
      // 33: ireturn
      // 34: aload 0
      // 35: aload 1
      // 36: invokespecial x/oc161f4adba4.z$7k2utc7u0w8s (Lx/ocaae9de8508;)I
      // 39: ireturn
   }

   private void ƅ(ocaae9de8508 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc24b4725b15.Ε I
      // 03: istore 2
      // 04: aload 1
      // 05: iload 2
      // 06: ifne 56
      // 09: invokevirtual x/ocaae9de8508.Ӿ ()I
      // 0c: ldc_w -1120011039
      // 0f: ldc_w -1120011037
      // 12: ixor
      // 13: if_icmpge 55
      // 16: goto 1a
      // 19: athrow
      // 1a: getstatic x/oc2cf3d80e17.ĕ Lx/oc151419fdfe;
      // 1d: iload 2
      // 1e: ifne 2f
      // 21: goto 25
      // 24: athrow
      // 25: ifnull 4c
      // 28: goto 2c
      // 2b: athrow
      // 2c: getstatic x/oc2cf3d80e17.ĕ Lx/oc151419fdfe;
      // 2f: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 32: ldc_w "&7Saved config: &b"
      // 35: swap
      // 36: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 3b: invokestatic x/oc7ab2161b9f.ý (Ljava/lang/String;)V
      // 3e: iload 2
      // 3f: getstatic x/oc2cf3d80e17.Á Lx/oc7d9b6bd5c4;
      // 42: getstatic x/oc2cf3d80e17.ĕ Lx/oc151419fdfe;
      // 45: invokevirtual x/oc7d9b6bd5c4.Ϧ (Lx/oc151419fdfe;)Z
      // 48: pop
      // 49: ifeq 54
      // 4c: aload 0
      // 4d: invokevirtual x/oc161f4adba4.ǻ ()V
      // 50: goto 54
      // 53: athrow
      // 54: return
      // 55: aload 1
      // 56: bipush 1
      // 57: invokevirtual x/ocaae9de8508.ͺ (I)Ljava/lang/String;
      // 5a: astore 3
      // 5b: iload 2
      // 5c: getstatic x/oc2cf3d80e17.Á Lx/oc7d9b6bd5c4;
      // 5f: aload 3
      // 60: invokevirtual x/oc7d9b6bd5c4.Ӈ (Ljava/lang/String;)Lx/oc151419fdfe;
      // 63: astore 4
      // 65: ifne 7f
      // 68: aload 4
      // 6a: ifnonnull 86
      // 6d: goto 71
      // 70: athrow
      // 71: getstatic x/oc2cf3d80e17.Á Lx/oc7d9b6bd5c4;
      // 74: aload 3
      // 75: bipush 0
      // 76: invokevirtual x/oc7d9b6bd5c4.χ (Ljava/lang/String;I)Lx/oc151419fdfe;
      // 79: astore 4
      // 7b: iload 2
      // 7c: ifne af
      // 7f: aload 4
      // 81: ifnonnull a1
      // 84: return
      // 85: athrow
      // 86: getstatic x/oc2cf3d80e17.Á Lx/oc7d9b6bd5c4;
      // 89: aload 4
      // 8b: invokevirtual x/oc7d9b6bd5c4.Ϧ (Lx/oc151419fdfe;)Z
      // 8e: ifne a1
      // 91: aload 0
      // 92: aload 3
      // 93: ldc_w "&cFailed to save config: &b"
      // 96: swap
      // 97: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 9c: invokevirtual x/oc161f4adba4.ɇ (Ljava/lang/String;)V
      // 9f: return
      // a0: athrow
      // a1: aload 0
      // a2: aload 3
      // a3: ldc_w "&7Saved config: &b"
      // a6: swap
      // a7: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // ac: invokevirtual x/oc161f4adba4.ɇ (Ljava/lang/String;)V
      // af: return
   }

   private void ɨ(ocaae9de8508 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc24b4725b15.Ε I
      // 03: istore 2
      // 04: aload 1
      // 05: iload 2
      // 06: ifne 21
      // 09: invokevirtual x/ocaae9de8508.Ӿ ()I
      // 0c: ldc_w 265716416
      // 0f: ldc_w 265716418
      // 12: ixor
      // 13: if_icmpge 20
      // 16: goto 1a
      // 19: athrow
      // 1a: aload 0
      // 1b: invokevirtual x/oc161f4adba4.ǻ ()V
      // 1e: return
      // 1f: athrow
      // 20: aload 1
      // 21: bipush 1
      // 22: invokevirtual x/ocaae9de8508.ͺ (I)Ljava/lang/String;
      // 25: astore 3
      // 26: getstatic x/oc2cf3d80e17.Á Lx/oc7d9b6bd5c4;
      // 29: iload 2
      // 2a: ifne 4e
      // 2d: aload 3
      // 2e: invokevirtual x/oc7d9b6bd5c4.Ӈ (Ljava/lang/String;)Lx/oc151419fdfe;
      // 31: ifnonnull 4b
      // 34: goto 38
      // 37: athrow
      // 38: aload 0
      // 39: aload 3
      // 3a: ldc_w "&b"
      // 3d: swap
      // 3e: ldc_w " &7does not exist"
      // 41: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001" ]
      // 46: invokevirtual x/oc161f4adba4.ɇ (Ljava/lang/String;)V
      // 49: return
      // 4a: athrow
      // 4b: getstatic x/oc2cf3d80e17.Á Lx/oc7d9b6bd5c4;
      // 4e: aload 3
      // 4f: invokevirtual x/oc7d9b6bd5c4.б (Ljava/lang/String;)Z
      // 52: ifeq 6b
      // 55: aload 0
      // 56: aload 3
      // 57: ldc_w "&7Enabled config: &b"
      // 5a: swap
      // 5b: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 60: invokevirtual x/oc161f4adba4.ɇ (Ljava/lang/String;)V
      // 63: iload 2
      // 64: ifeq 7d
      // 67: goto 6b
      // 6a: athrow
      // 6b: aload 0
      // 6c: aload 3
      // 6d: ldc_w "&cFailed to load config: &b"
      // 70: swap
      // 71: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 76: invokevirtual x/oc161f4adba4.ɇ (Ljava/lang/String;)V
      // 79: goto 7d
      // 7c: athrow
      // 7d: return
   }

   private void ɘ(ocaae9de8508 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc24b4725b15.Ε I
      // 03: istore 2
      // 04: aload 1
      // 05: iload 2
      // 06: ifne 21
      // 09: invokevirtual x/ocaae9de8508.Ӿ ()I
      // 0c: ldc_w 110724510
      // 0f: ldc_w 110724508
      // 12: ixor
      // 13: if_icmpge 20
      // 16: goto 1a
      // 19: athrow
      // 1a: aload 0
      // 1b: invokevirtual x/oc161f4adba4.ǻ ()V
      // 1e: return
      // 1f: athrow
      // 20: aload 1
      // 21: bipush 1
      // 22: invokevirtual x/ocaae9de8508.ͺ (I)Ljava/lang/String;
      // 25: astore 3
      // 26: iload 2
      // 27: ifne 67
      // 2a: getstatic x/oc2cf3d80e17.Á Lx/oc7d9b6bd5c4;
      // 2d: aload 3
      // 2e: invokevirtual x/oc7d9b6bd5c4.Ӈ (Ljava/lang/String;)Lx/oc151419fdfe;
      // 31: ifnonnull 4b
      // 34: goto 38
      // 37: athrow
      // 38: aload 0
      // 39: aload 3
      // 3a: ldc_w "&cConfig &b"
      // 3d: swap
      // 3e: ldc_w " &7does not exist"
      // 41: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001" ]
      // 46: invokevirtual x/oc161f4adba4.ɇ (Ljava/lang/String;)V
      // 49: return
      // 4a: athrow
      // 4b: getstatic x/oc2cf3d80e17.Á Lx/oc7d9b6bd5c4;
      // 4e: aload 3
      // 4f: invokevirtual x/oc7d9b6bd5c4.ŏ (Ljava/lang/String;)Z
      // 52: pop
      // 53: aload 0
      // 54: aload 3
      // 55: ldc_w "&7Removed config: &b"
      // 58: swap
      // 59: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 5e: invokevirtual x/oc161f4adba4.ɇ (Ljava/lang/String;)V
      // 61: getstatic x/oc2cf3d80e17.Á Lx/oc7d9b6bd5c4;
      // 64: invokevirtual x/oc7d9b6bd5c4.Ё ()V
      // 67: return
   }

   private void á(ocaae9de8508 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc24b4725b15.Ε I
      // 03: istore 2
      // 04: aload 1
      // 05: invokevirtual x/ocaae9de8508.Ӿ ()I
      // 08: ldc_w -1243006462
      // 0b: ldc_w -1243006463
      // 0e: ixor
      // 0f: if_icmpge 18
      // 12: aload 0
      // 13: invokevirtual x/oc161f4adba4.ǻ ()V
      // 16: return
      // 17: athrow
      // 18: aload 0
      // 19: aload 1
      // 1a: bipush 1
      // 1b: invokevirtual x/ocaae9de8508.ͺ (I)Ljava/lang/String;
      // 1e: invokevirtual x/oc1377e171d3.ŋ (Ljava/lang/String;)Lx/oc0b1f7f605f;
      // 21: astore 3
      // 22: aload 3
      // 23: iload 2
      // 24: ifne 38
      // 27: ifnonnull 37
      // 2a: goto 2e
      // 2d: athrow
      // 2e: aload 0
      // 2f: ldc_w "&7Rename requires an existing config name followed by the new name."
      // 32: invokevirtual x/oc161f4adba4.ɇ (Ljava/lang/String;)V
      // 35: return
      // 36: athrow
      // 37: aload 3
      // 38: getfield x/oc0b1f7f605f.э Ljava/lang/String;
      // 3b: astore 4
      // 3d: aload 3
      // 3e: getfield x/oc0b1f7f605f.Š Ljava/lang/String;
      // 41: astore 5
      // 43: getstatic x/oc2cf3d80e17.Á Lx/oc7d9b6bd5c4;
      // 46: aload 4
      // 48: invokevirtual x/oc7d9b6bd5c4.Ӈ (Ljava/lang/String;)Lx/oc151419fdfe;
      // 4b: astore 6
      // 4d: aload 6
      // 4f: iload 2
      // 50: ifne 7e
      // 53: ifnonnull 6e
      // 56: goto 5a
      // 59: athrow
      // 5a: aload 0
      // 5b: aload 4
      // 5d: ldc_w "&b"
      // 60: swap
      // 61: ldc_w " &7does not exist"
      // 64: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001" ]
      // 69: invokevirtual x/oc161f4adba4.ɇ (Ljava/lang/String;)V
      // 6c: return
      // 6d: athrow
      // 6e: getstatic x/oc2cf3d80e17.Á Lx/oc7d9b6bd5c4;
      // 71: iload 2
      // 72: ifne 98
      // 75: aload 5
      // 77: invokevirtual x/oc7d9b6bd5c4.Ӈ (Ljava/lang/String;)Lx/oc151419fdfe;
      // 7a: goto 7e
      // 7d: athrow
      // 7e: ifnull 95
      // 81: aload 0
      // 82: aload 5
      // 84: ldc_w "&b"
      // 87: swap
      // 88: ldc_w " &7already exists"
      // 8b: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001" ]
      // 90: invokevirtual x/oc161f4adba4.ɇ (Ljava/lang/String;)V
      // 93: return
      // 94: athrow
      // 95: getstatic x/oc2cf3d80e17.Á Lx/oc7d9b6bd5c4;
      // 98: aload 6
      // 9a: aload 5
      // 9c: invokevirtual x/oc7d9b6bd5c4.ǽ (Lx/oc151419fdfe;Ljava/lang/String;)Z
      // 9f: ifne a4
      // a2: return
      // a3: athrow
      // a4: aload 0
      // a5: aload 4
      // a7: aload 6
      // a9: invokevirtual x/oc151419fdfe.Ġ ()Ljava/lang/String;
      // ac: ldc_w "&b"
      // af: dup_x2
      // b0: pop
      // b1: ldc_w " &7renamed to &b"
      // b4: swap
      // b5: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001\u0001" ]
      // ba: invokevirtual x/oc161f4adba4.ɇ (Ljava/lang/String;)V
      // bd: return
   }

   private List<String> C(String param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc24b4725b15.Ε I
      // 03: istore 2
      // 04: aload 1
      // 05: iload 2
      // 06: ifne 18
      // 09: ifnonnull 17
      // 0c: goto 10
      // 0f: athrow
      // 10: ldc_w ""
      // 13: goto 1b
      // 16: athrow
      // 17: aload 1
      // 18: invokevirtual java/lang/String.toLowerCase ()Ljava/lang/String;
      // 1b: astore 3
      // 1c: new java/util/ArrayList
      // 1f: dup
      // 20: invokespecial java/util/ArrayList.<init> ()V
      // 23: astore 4
      // 25: getstatic x/oc2cf3d80e17.Á Lx/oc7d9b6bd5c4;
      // 28: getfield x/oc7d9b6bd5c4.ǹ Ljava/util/List;
      // 2b: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 30: astore 5
      // 32: aload 5
      // 34: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 39: ifeq 74
      // 3c: aload 5
      // 3e: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 43: checkcast x/oc151419fdfe
      // 46: astore 6
      // 48: aload 6
      // 4a: invokevirtual x/oc151419fdfe.Ġ ()Ljava/lang/String;
      // 4d: invokevirtual java/lang/String.toLowerCase ()Ljava/lang/String;
      // 50: aload 3
      // 51: invokevirtual java/lang/String.startsWith (Ljava/lang/String;)Z
      // 54: iload 2
      // 55: ifne 6f
      // 58: ifeq 70
      // 5b: goto 5f
      // 5e: athrow
      // 5f: aload 4
      // 61: aload 6
      // 63: invokevirtual x/oc151419fdfe.Ġ ()Ljava/lang/String;
      // 66: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 6b: goto 6f
      // 6e: athrow
      // 6f: pop
      // 70: iload 2
      // 71: ifeq 32
      // 74: aload 4
      // 76: areturn
   }

   private boolean Ъ(String param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc24b4725b15.Ε I
      // 03: istore 2
      // 04: ldc "load"
      // 06: aload 1
      // 07: invokevirtual java/lang/String.equalsIgnoreCase (Ljava/lang/String;)Z
      // 0a: iload 2
      // 0b: ifne 6a
      // 0e: ifne 69
      // 11: goto 15
      // 14: athrow
      // 15: ldc "l"
      // 17: aload 1
      // 18: invokevirtual java/lang/String.equalsIgnoreCase (Ljava/lang/String;)Z
      // 1b: iload 2
      // 1c: ifne 6a
      // 1f: goto 23
      // 22: athrow
      // 23: ifne 69
      // 26: goto 2a
      // 29: athrow
      // 2a: ldc "delete"
      // 2c: aload 1
      // 2d: invokevirtual java/lang/String.equalsIgnoreCase (Ljava/lang/String;)Z
      // 30: iload 2
      // 31: ifne 6a
      // 34: goto 38
      // 37: athrow
      // 38: ifne 69
      // 3b: goto 3f
      // 3e: athrow
      // 3f: ldc "remove"
      // 41: aload 1
      // 42: invokevirtual java/lang/String.equalsIgnoreCase (Ljava/lang/String;)Z
      // 45: iload 2
      // 46: ifne 6a
      // 49: goto 4d
      // 4c: athrow
      // 4d: ifne 69
      // 50: goto 54
      // 53: athrow
      // 54: ldc "r"
      // 56: aload 1
      // 57: invokevirtual java/lang/String.equalsIgnoreCase (Ljava/lang/String;)Z
      // 5a: iload 2
      // 5b: ifne 6a
      // 5e: goto 62
      // 61: athrow
      // 62: ifeq 6d
      // 65: goto 69
      // 68: athrow
      // 69: bipush 1
      // 6a: goto 6e
      // 6d: bipush 0
      // 6e: ireturn
   }

   private boolean Ĩ(String var1) {
      return "rename".equalsIgnoreCase(var1);
   }

   private oc0b1f7f605f ŋ(String param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc24b4725b15.Ε I
      // 003: istore 2
      // 004: aload 1
      // 005: iload 2
      // 006: ifne 017
      // 009: ifnonnull 013
      // 00c: goto 010
      // 00f: athrow
      // 010: aconst_null
      // 011: areturn
      // 012: athrow
      // 013: aload 1
      // 014: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 017: astore 3
      // 018: aload 3
      // 019: invokevirtual java/lang/String.isEmpty ()Z
      // 01c: ifeq 022
      // 01f: aconst_null
      // 020: areturn
      // 021: athrow
      // 022: aconst_null
      // 023: astore 4
      // 025: getstatic x/oc2cf3d80e17.Á Lx/oc7d9b6bd5c4;
      // 028: getfield x/oc7d9b6bd5c4.ǹ Ljava/util/List;
      // 02b: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 030: astore 5
      // 032: aload 5
      // 034: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 039: ifeq 0e1
      // 03c: aload 5
      // 03e: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 043: checkcast x/oc151419fdfe
      // 046: astore 6
      // 048: iload 2
      // 049: ifne 0f1
      // 04c: aload 6
      // 04e: invokevirtual x/oc151419fdfe.Ġ ()Ljava/lang/String;
      // 051: astore 7
      // 053: aload 3
      // 054: iload 2
      // 055: ifne 070
      // 058: invokevirtual java/lang/String.length ()I
      // 05b: aload 7
      // 05d: invokevirtual java/lang/String.length ()I
      // 060: if_icmpgt 06f
      // 063: goto 067
      // 066: athrow
      // 067: iload 2
      // 068: ifeq 032
      // 06b: goto 06f
      // 06e: athrow
      // 06f: aload 3
      // 070: iload 2
      // 071: ifne 091
      // 074: bipush 1
      // 075: bipush 0
      // 076: aload 7
      // 078: bipush 0
      // 079: aload 7
      // 07b: invokevirtual java/lang/String.length ()I
      // 07e: invokevirtual java/lang/String.regionMatches (ZILjava/lang/String;II)Z
      // 081: ifne 090
      // 084: goto 088
      // 087: athrow
      // 088: iload 2
      // 089: ifeq 032
      // 08c: goto 090
      // 08f: athrow
      // 090: aload 3
      // 091: iload 2
      // 092: ifne 0b1
      // 095: aload 7
      // 097: invokevirtual java/lang/String.length ()I
      // 09a: invokevirtual java/lang/String.charAt (I)C
      // 09d: invokestatic java/lang/Character.isWhitespace (C)Z
      // 0a0: ifne 0af
      // 0a3: goto 0a7
      // 0a6: athrow
      // 0a7: iload 2
      // 0a8: ifeq 032
      // 0ab: goto 0af
      // 0ae: athrow
      // 0af: aload 4
      // 0b1: iload 2
      // 0b2: ifne 0db
      // 0b5: ifnull 0d5
      // 0b8: goto 0bc
      // 0bb: athrow
      // 0bc: aload 7
      // 0be: iload 2
      // 0bf: ifne 0db
      // 0c2: goto 0c6
      // 0c5: athrow
      // 0c6: invokevirtual java/lang/String.length ()I
      // 0c9: aload 4
      // 0cb: invokevirtual java/lang/String.length ()I
      // 0ce: if_icmple 0dd
      // 0d1: goto 0d5
      // 0d4: athrow
      // 0d5: aload 7
      // 0d7: goto 0db
      // 0da: athrow
      // 0db: astore 4
      // 0dd: iload 2
      // 0de: ifeq 032
      // 0e1: aload 4
      // 0e3: iload 2
      // 0e4: ifne 0fd
      // 0e7: ifnonnull 0f1
      // 0ea: goto 0ee
      // 0ed: athrow
      // 0ee: aconst_null
      // 0ef: areturn
      // 0f0: athrow
      // 0f1: aload 3
      // 0f2: aload 4
      // 0f4: invokevirtual java/lang/String.length ()I
      // 0f7: invokevirtual java/lang/String.substring (I)Ljava/lang/String;
      // 0fa: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 0fd: astore 5
      // 0ff: aload 5
      // 101: invokevirtual java/lang/String.isEmpty ()Z
      // 104: ifeq 10a
      // 107: aconst_null
      // 108: areturn
      // 109: athrow
      // 10a: new x/oc0b1f7f605f
      // 10d: dup
      // 10e: aload 4
      // 110: aload 5
      // 112: invokespecial x/oc0b1f7f605f.<init> (Ljava/lang/String;Ljava/lang/String;)V
      // 115: areturn
   }
}
