package x;

import java.util.Iterator;
import java.util.List;

public class oc53d478f3cf extends oc161f4adba4 {
   public static boolean Ӑ;

   public oc53d478f3cf() {
      oc17aaf5d285 var10003 = oc17aaf5d285.ħ;
      String[] var10004 = new String[-247086006 ^ -247086007];
      var10004[0] = "bind <module> <key>";
      var10004[1] = "bind add <module> <key>";
      var10004[-247086005 ^ -247086007] = "bind remove <module>";
      super("bind", "Bind or unbind a module key.", var10003, var10004, new String[]{"b"});
   }

   public void z$2uoow1halcq2f(ocaae9de8508 param1) {
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
      // 006: ifne 01f
      // 009: invokevirtual x/ocaae9de8508.Ӿ ()I
      // 00c: ldc -760926156
      // 00e: ldc -760926154
      // 010: ixor
      // 011: if_icmpge 01e
      // 014: goto 018
      // 017: athrow
      // 018: aload 0
      // 019: invokevirtual x/oc161f4adba4.ǻ ()V
      // 01c: return
      // 01d: athrow
      // 01e: aload 1
      // 01f: bipush 0
      // 020: invokevirtual x/ocaae9de8508.ь (I)Ljava/lang/String;
      // 023: astore 3
      // 024: ldc "add"
      // 026: iload 2
      // 027: ifne 050
      // 02a: aload 3
      // 02b: invokevirtual java/lang/String.equalsIgnoreCase (Ljava/lang/String;)Z
      // 02e: ifne 04a
      // 031: goto 035
      // 034: athrow
      // 035: ldc "remove"
      // 037: iload 2
      // 038: ifne 11c
      // 03b: goto 03f
      // 03e: athrow
      // 03f: aload 3
      // 040: invokevirtual java/lang/String.equalsIgnoreCase (Ljava/lang/String;)Z
      // 043: ifeq 10e
      // 046: goto 04a
      // 049: athrow
      // 04a: ldc "remove"
      // 04c: goto 050
      // 04f: athrow
      // 050: aload 3
      // 051: invokevirtual java/lang/String.equalsIgnoreCase (Ljava/lang/String;)Z
      // 054: iload 2
      // 055: ifne 0df
      // 058: ifeq 0d3
      // 05b: goto 05f
      // 05e: athrow
      // 05f: aload 1
      // 060: bipush 1
      // 061: invokevirtual x/ocaae9de8508.ͺ (I)Ljava/lang/String;
      // 064: astore 6
      // 066: aload 0
      // 067: aload 6
      // 069: invokevirtual x/oc53d478f3cf.ƙ (Ljava/lang/String;)Lx/oc69da1aa7f5;
      // 06c: astore 7
      // 06e: aload 7
      // 070: iload 2
      // 071: ifne 0a6
      // 074: ifnonnull 0a4
      // 077: goto 07b
      // 07a: athrow
      // 07b: aload 1
      // 07c: invokevirtual x/ocaae9de8508.Ӿ ()I
      // 07f: ldc -760926156
      // 081: ldc -760926154
      // 083: ixor
      // 084: if_icmple 0a4
      // 087: goto 08b
      // 08a: athrow
      // 08b: aload 0
      // 08c: aload 1
      // 08d: invokevirtual x/ocaae9de8508.у ()[Ljava/lang/String;
      // 090: bipush 1
      // 091: aload 1
      // 092: invokevirtual x/ocaae9de8508.Ӿ ()I
      // 095: bipush 1
      // 096: isub
      // 097: invokevirtual x/oc53d478f3cf.Ε ([Ljava/lang/String;II)Ljava/lang/String;
      // 09a: astore 6
      // 09c: aload 0
      // 09d: aload 6
      // 09f: invokevirtual x/oc53d478f3cf.ƙ (Ljava/lang/String;)Lx/oc69da1aa7f5;
      // 0a2: astore 7
      // 0a4: aload 7
      // 0a6: iload 2
      // 0a7: ifne 0bb
      // 0aa: ifnonnull 0b9
      // 0ad: goto 0b1
      // 0b0: athrow
      // 0b1: aload 0
      // 0b2: ldc "&cModule not found."
      // 0b4: invokevirtual x/oc161f4adba4.ɇ (Ljava/lang/String;)V
      // 0b7: return
      // 0b8: athrow
      // 0b9: aload 7
      // 0bb: bipush 0
      // 0bc: invokevirtual x/oc69da1aa7f5.ӝ (I)V
      // 0bf: aload 0
      // 0c0: aload 7
      // 0c2: invokevirtual x/oc69da1aa7f5.z$3i8m9vxwuvqj0 ()Ljava/lang/String;
      // 0c5: ldc "&7Unbound &b"
      // 0c7: swap
      // 0c8: ldc "&7."
      // 0ca: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001" ]
      // 0cf: invokevirtual x/oc161f4adba4.ɇ (Ljava/lang/String;)V
      // 0d2: return
      // 0d3: aload 1
      // 0d4: iload 2
      // 0d5: ifne 0ee
      // 0d8: invokevirtual x/ocaae9de8508.Ӿ ()I
      // 0db: goto 0df
      // 0de: athrow
      // 0df: ldc -760926155
      // 0e1: ldc -760926154
      // 0e3: ixor
      // 0e4: if_icmpge 0ed
      // 0e7: aload 0
      // 0e8: invokevirtual x/oc161f4adba4.ǻ ()V
      // 0eb: return
      // 0ec: athrow
      // 0ed: aload 1
      // 0ee: aload 1
      // 0ef: invokevirtual x/ocaae9de8508.Ӿ ()I
      // 0f2: bipush 1
      // 0f3: isub
      // 0f4: invokevirtual x/ocaae9de8508.ь (I)Ljava/lang/String;
      // 0f7: astore 5
      // 0f9: iload 2
      // 0fa: aload 0
      // 0fb: aload 1
      // 0fc: invokevirtual x/ocaae9de8508.у ()[Ljava/lang/String;
      // 0ff: bipush 1
      // 100: aload 1
      // 101: invokevirtual x/ocaae9de8508.Ӿ ()I
      // 104: bipush 1
      // 105: isub
      // 106: invokevirtual x/oc53d478f3cf.Ε ([Ljava/lang/String;II)Ljava/lang/String;
      // 109: astore 4
      // 10b: ifeq 12f
      // 10e: aload 1
      // 10f: aload 1
      // 110: invokevirtual x/ocaae9de8508.Ӿ ()I
      // 113: bipush 1
      // 114: isub
      // 115: invokevirtual x/ocaae9de8508.ь (I)Ljava/lang/String;
      // 118: goto 11c
      // 11b: athrow
      // 11c: astore 5
      // 11e: aload 0
      // 11f: aload 1
      // 120: invokevirtual x/ocaae9de8508.у ()[Ljava/lang/String;
      // 123: bipush 0
      // 124: aload 1
      // 125: invokevirtual x/ocaae9de8508.Ӿ ()I
      // 128: bipush 1
      // 129: isub
      // 12a: invokevirtual x/oc53d478f3cf.Ε ([Ljava/lang/String;II)Ljava/lang/String;
      // 12d: astore 4
      // 12f: aload 0
      // 130: aload 4
      // 132: invokevirtual x/oc53d478f3cf.ƙ (Ljava/lang/String;)Lx/oc69da1aa7f5;
      // 135: astore 6
      // 137: iload 2
      // 138: ifne 14e
      // 13b: aload 6
      // 13d: ifnonnull 14f
      // 140: goto 144
      // 143: athrow
      // 144: aload 0
      // 145: ldc "&cModule not found."
      // 147: invokevirtual x/oc161f4adba4.ɇ (Ljava/lang/String;)V
      // 14a: goto 14e
      // 14d: athrow
      // 14e: return
      // 14f: aload 0
      // 150: aload 5
      // 152: invokevirtual x/oc53d478f3cf.Ϥ (Ljava/lang/String;)Z
      // 155: istore 7
      // 157: iload 2
      // 158: aload 0
      // 159: aload 5
      // 15b: invokevirtual x/oc53d478f3cf.ъ (Ljava/lang/String;)I
      // 15e: istore 8
      // 160: ifne 190
      // 163: iload 8
      // 165: ifne 185
      // 168: goto 16c
      // 16b: athrow
      // 16c: iload 7
      // 16e: iload 2
      // 16f: ifne 192
      // 172: goto 176
      // 175: athrow
      // 176: ifne 185
      // 179: goto 17d
      // 17c: athrow
      // 17d: aload 0
      // 17e: ldc "&7Invalid key."
      // 180: invokevirtual x/oc161f4adba4.ɇ (Ljava/lang/String;)V
      // 183: return
      // 184: athrow
      // 185: aload 6
      // 187: iload 8
      // 189: invokevirtual x/oc69da1aa7f5.ӝ (I)V
      // 18c: iload 2
      // 18d: ifne 1ac
      // 190: iload 8
      // 192: ifne 1b0
      // 195: aload 0
      // 196: aload 6
      // 198: invokevirtual x/oc69da1aa7f5.z$3i8m9vxwuvqj0 ()Ljava/lang/String;
      // 19b: ldc "&7Unbound &b"
      // 19d: swap
      // 19e: ldc "&7."
      // 1a0: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001" ]
      // 1a5: invokevirtual x/oc161f4adba4.ɇ (Ljava/lang/String;)V
      // 1a8: goto 1ac
      // 1ab: athrow
      // 1ac: iload 2
      // 1ad: ifeq 1d1
      // 1b0: aload 0
      // 1b1: aload 6
      // 1b3: invokevirtual x/oc69da1aa7f5.z$3i8m9vxwuvqj0 ()Ljava/lang/String;
      // 1b6: aload 0
      // 1b7: iload 8
      // 1b9: invokevirtual x/oc53d478f3cf.Ъ (I)Ljava/lang/String;
      // 1bc: ldc "&7Bound &b"
      // 1be: dup_x2
      // 1bf: pop
      // 1c0: ldc " &7to &b"
      // 1c2: swap
      // 1c3: ldc "&7."
      // 1c5: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001\u0001\u0001" ]
      // 1ca: invokevirtual x/oc161f4adba4.ɇ (Ljava/lang/String;)V
      // 1cd: goto 1d1
      // 1d0: athrow
      // 1d1: return
   }

   public List<String> z$9ofids0wyz4j(ocaae9de8508 param1) {
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
      // 006: ifne 05e
      // 009: invokevirtual x/ocaae9de8508.Ӿ ()I
      // 00c: bipush 1
      // 00d: if_icmpgt 05d
      // 010: goto 014
      // 013: athrow
      // 014: new java/util/ArrayList
      // 017: dup
      // 018: ldc -715356802
      // 01a: ldc -715356804
      // 01c: ixor
      // 01d: anewarray 27
      // 020: dup
      // 021: bipush 0
      // 022: ldc "add"
      // 024: aastore
      // 025: dup
      // 026: bipush 1
      // 027: ldc "remove"
      // 029: aastore
      // 02a: invokestatic java/util/Arrays.asList ([Ljava/lang/Object;)Ljava/util/List;
      // 02d: invokespecial java/util/ArrayList.<init> (Ljava/util/Collection;)V
      // 030: astore 3
      // 031: aload 3
      // 032: aload 0
      // 033: aload 1
      // 034: iload 2
      // 035: ifne 049
      // 038: invokevirtual x/ocaae9de8508.Ӿ ()I
      // 03b: ifne 048
      // 03e: goto 042
      // 041: athrow
      // 042: ldc ""
      // 044: goto 04d
      // 047: athrow
      // 048: aload 1
      // 049: bipush 0
      // 04a: invokevirtual x/ocaae9de8508.ͺ (I)Ljava/lang/String;
      // 04d: invokevirtual x/oc53d478f3cf.Ã (Ljava/lang/String;)Ljava/util/List;
      // 050: invokeinterface java/util/List.addAll (Ljava/util/Collection;)Z 2
      // 055: pop
      // 056: aload 0
      // 057: aload 1
      // 058: aload 3
      // 059: invokevirtual x/oc161f4adba4.ҕ (Lx/ocaae9de8508;Ljava/util/List;)Ljava/util/List;
      // 05c: areturn
      // 05d: aload 1
      // 05e: bipush 0
      // 05f: invokevirtual x/ocaae9de8508.ь (I)Ljava/lang/String;
      // 062: astore 3
      // 063: ldc "add"
      // 065: iload 2
      // 066: ifne 0d9
      // 069: aload 3
      // 06a: invokevirtual java/lang/String.equalsIgnoreCase (Ljava/lang/String;)Z
      // 06d: ifeq 0d7
      // 070: goto 074
      // 073: athrow
      // 074: aload 1
      // 075: invokevirtual x/ocaae9de8508.Ӿ ()I
      // 078: iload 2
      // 079: ifne 09b
      // 07c: goto 080
      // 07f: athrow
      // 080: ldc -715356802
      // 082: ldc -715356804
      // 084: ixor
      // 085: if_icmpne 097
      // 088: goto 08c
      // 08b: athrow
      // 08c: aload 0
      // 08d: aload 1
      // 08e: bipush 1
      // 08f: invokevirtual x/ocaae9de8508.ь (I)Ljava/lang/String;
      // 092: invokevirtual x/oc53d478f3cf.Ã (Ljava/lang/String;)Ljava/util/List;
      // 095: areturn
      // 096: athrow
      // 097: aload 1
      // 098: invokevirtual x/ocaae9de8508.Ӿ ()I
      // 09b: ldc -715356801
      // 09d: ldc -715356804
      // 09f: ixor
      // 0a0: if_icmplt 133
      // 0a3: aload 0
      // 0a4: aload 1
      // 0a5: ldc -715356807
      // 0a7: ldc -715356804
      // 0a9: ixor
      // 0aa: anewarray 27
      // 0ad: dup
      // 0ae: bipush 0
      // 0af: ldc "R"
      // 0b1: aastore
      // 0b2: dup
      // 0b3: bipush 1
      // 0b4: ldc "F"
      // 0b6: aastore
      // 0b7: dup
      // 0b8: ldc -715356802
      // 0ba: ldc -715356804
      // 0bc: ixor
      // 0bd: ldc "G"
      // 0bf: aastore
      // 0c0: dup
      // 0c1: ldc -715356801
      // 0c3: ldc -715356804
      // 0c5: ixor
      // 0c6: ldc "V"
      // 0c8: aastore
      // 0c9: dup
      // 0ca: ldc -715356808
      // 0cc: ldc -715356804
      // 0ce: ixor
      // 0cf: ldc "NONE"
      // 0d1: aastore
      // 0d2: invokevirtual x/oc161f4adba4.Ġ (Lx/ocaae9de8508;[Ljava/lang/String;)Ljava/util/List;
      // 0d5: areturn
      // 0d6: athrow
      // 0d7: ldc "remove"
      // 0d9: aload 3
      // 0da: invokevirtual java/lang/String.equalsIgnoreCase (Ljava/lang/String;)Z
      // 0dd: iload 2
      // 0de: ifne 0f7
      // 0e1: ifeq 0f3
      // 0e4: goto 0e8
      // 0e7: athrow
      // 0e8: aload 0
      // 0e9: aload 1
      // 0ea: bipush 1
      // 0eb: invokevirtual x/ocaae9de8508.ͺ (I)Ljava/lang/String;
      // 0ee: invokevirtual x/oc53d478f3cf.Ã (Ljava/lang/String;)Ljava/util/List;
      // 0f1: areturn
      // 0f2: athrow
      // 0f3: aload 1
      // 0f4: invokevirtual x/ocaae9de8508.Ӿ ()I
      // 0f7: ldc -715356802
      // 0f9: ldc -715356804
      // 0fb: ixor
      // 0fc: if_icmplt 133
      // 0ff: aload 0
      // 100: aload 1
      // 101: ldc -715356807
      // 103: ldc -715356804
      // 105: ixor
      // 106: anewarray 27
      // 109: dup
      // 10a: bipush 0
      // 10b: ldc "R"
      // 10d: aastore
      // 10e: dup
      // 10f: bipush 1
      // 110: ldc "F"
      // 112: aastore
      // 113: dup
      // 114: ldc -715356802
      // 116: ldc -715356804
      // 118: ixor
      // 119: ldc "G"
      // 11b: aastore
      // 11c: dup
      // 11d: ldc -715356801
      // 11f: ldc -715356804
      // 121: ixor
      // 122: ldc "V"
      // 124: aastore
      // 125: dup
      // 126: ldc -715356808
      // 128: ldc -715356804
      // 12a: ixor
      // 12b: ldc "NONE"
      // 12d: aastore
      // 12e: invokevirtual x/oc161f4adba4.Ġ (Lx/ocaae9de8508;[Ljava/lang/String;)Ljava/util/List;
      // 131: areturn
      // 132: athrow
      // 133: new java/util/ArrayList
      // 136: dup
      // 137: invokespecial java/util/ArrayList.<init> ()V
      // 13a: areturn
   }

   public int z$7k2utc7u0w8s(ocaae9de8508 var1) {
      return Math.max(0, var1.Ӿ() - 1);
   }

   private oc69da1aa7f5 ƙ(String var1) {
      String var3 = this.ʧ(var1);
      int var10000 = oc24b4725b15.Ε;
      Iterator var4 = oc9755810e45.Ŕ.iterator();
      int var2 = var10000;

      while (var4.hasNext()) {
         oc69da1aa7f5 var5 = (oc69da1aa7f5)var4.next();

         try {
            if (this.ʧ(var5.z$3i8m9vxwuvqj0()).equals(var3)) {
               return var5;
            }
         } catch (ocbde1165e4e var6) {
            throw var6;
         }

         if (var2 != 0) {
            break;
         }
      }

      return null;
   }

   private List<String> Ã(String param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc24b4725b15.Ε I
      // 03: new java/util/ArrayList
      // 06: dup
      // 07: invokespecial java/util/ArrayList.<init> ()V
      // 0a: astore 3
      // 0b: istore 2
      // 0c: aload 0
      // 0d: aload 1
      // 0e: invokevirtual x/oc53d478f3cf.ʧ (Ljava/lang/String;)Ljava/lang/String;
      // 11: astore 4
      // 13: getstatic x/oc9755810e45.Ŕ Ljava/util/List;
      // 16: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 1b: astore 5
      // 1d: aload 5
      // 1f: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 24: ifeq 61
      // 27: aload 5
      // 29: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 2e: checkcast x/oc69da1aa7f5
      // 31: astore 6
      // 33: aload 6
      // 35: invokevirtual x/oc69da1aa7f5.z$3i8m9vxwuvqj0 ()Ljava/lang/String;
      // 38: astore 7
      // 3a: aload 0
      // 3b: aload 7
      // 3d: invokevirtual x/oc53d478f3cf.ʧ (Ljava/lang/String;)Ljava/lang/String;
      // 40: aload 4
      // 42: invokevirtual java/lang/String.startsWith (Ljava/lang/String;)Z
      // 45: iload 2
      // 46: ifne 5c
      // 49: ifeq 5d
      // 4c: goto 50
      // 4f: athrow
      // 50: aload 3
      // 51: aload 7
      // 53: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 58: goto 5c
      // 5b: athrow
      // 5c: pop
      // 5d: iload 2
      // 5e: ifeq 1d
      // 61: aload 3
      // 62: areturn
   }

   private int ъ(String param1) {
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
      // 06: ifne 15
      // 09: ifnonnull 13
      // 0c: goto 10
      // 0f: athrow
      // 10: bipush 0
      // 11: ireturn
      // 12: athrow
      // 13: ldc "NONE"
      // 15: aload 1
      // 16: invokevirtual java/lang/String.equalsIgnoreCase (Ljava/lang/String;)Z
      // 19: iload 2
      // 1a: ifne 3e
      // 1d: ifne 39
      // 20: goto 24
      // 23: athrow
      // 24: ldc "UNBOUND"
      // 26: iload 2
      // 27: ifne 43
      // 2a: goto 2e
      // 2d: athrow
      // 2e: aload 1
      // 2f: invokevirtual java/lang/String.equalsIgnoreCase (Ljava/lang/String;)Z
      // 32: ifeq 3f
      // 35: goto 39
      // 38: athrow
      // 39: bipush 0
      // 3a: goto 3e
      // 3d: athrow
      // 3e: ireturn
      // 3f: aload 1
      // 40: invokevirtual java/lang/String.toUpperCase ()Ljava/lang/String;
      // 43: invokestatic org/lwjgl/input/Keyboard.getKeyIndex (Ljava/lang/String;)I
      // 46: ireturn
   }

   private boolean Ϥ(String param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc24b4725b15.Ε I
      // 03: istore 2
      // 04: ldc "NONE"
      // 06: aload 1
      // 07: invokevirtual java/lang/String.equalsIgnoreCase (Ljava/lang/String;)Z
      // 0a: iload 2
      // 0b: ifne 2b
      // 0e: ifne 2a
      // 11: goto 15
      // 14: athrow
      // 15: ldc "UNBOUND"
      // 17: aload 1
      // 18: invokevirtual java/lang/String.equalsIgnoreCase (Ljava/lang/String;)Z
      // 1b: iload 2
      // 1c: ifne 2b
      // 1f: goto 23
      // 22: athrow
      // 23: ifeq 2e
      // 26: goto 2a
      // 29: athrow
      // 2a: bipush 1
      // 2b: goto 2f
      // 2e: bipush 0
      // 2f: ireturn
   }

   private String Ъ(int param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc24b4725b15.Ε I
      // 03: istore 2
      // 04: iload 1
      // 05: iload 2
      // 06: ifne 17
      // 09: ifne 16
      // 0c: goto 10
      // 0f: athrow
      // 10: ldc "NONE"
      // 12: goto 1a
      // 15: athrow
      // 16: iload 1
      // 17: invokestatic org/lwjgl/input/Keyboard.getKeyName (I)Ljava/lang/String;
      // 1a: areturn
   }

   private String ʧ(String param1) {
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
      // 06: ifne 1e
      // 09: ifnonnull 16
      // 0c: goto 10
      // 0f: athrow
      // 10: ldc ""
      // 12: goto 24
      // 15: athrow
      // 16: aload 1
      // 17: ldc "[^a-zA-Z0-9]"
      // 19: ldc ""
      // 1b: invokevirtual java/lang/String.replaceAll (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      // 1e: getstatic java/util/Locale.ROOT Ljava/util/Locale;
      // 21: invokevirtual java/lang/String.toLowerCase (Ljava/util/Locale;)Ljava/lang/String;
      // 24: areturn
   }

   private String Ε(String[] param1, int param2, int param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc24b4725b15.Ε I
      // 03: istore 4
      // 05: aload 1
      // 06: ifnull 12
      // 09: iload 2
      // 0a: iload 3
      // 0b: if_icmplt 16
      // 0e: goto 12
      // 11: athrow
      // 12: ldc ""
      // 14: areturn
      // 15: athrow
      // 16: new java/lang/StringBuilder
      // 19: dup
      // 1a: invokespecial java/lang/StringBuilder.<init> ()V
      // 1d: astore 5
      // 1f: iload 2
      // 20: istore 6
      // 22: iload 6
      // 24: iload 3
      // 25: if_icmpge 51
      // 28: iload 6
      // 2a: iload 2
      // 2b: if_icmple 3f
      // 2e: aload 5
      // 30: ldc_w -978369873
      // 33: ldc_w -978369905
      // 36: ixor
      // 37: invokevirtual java/lang/StringBuilder.append (C)Ljava/lang/StringBuilder;
      // 3a: pop
      // 3b: goto 3f
      // 3e: athrow
      // 3f: aload 5
      // 41: aload 1
      // 42: iload 6
      // 44: aaload
      // 45: invokevirtual java/lang/StringBuilder.append (Ljava/lang/String;)Ljava/lang/StringBuilder;
      // 48: pop
      // 49: iload 4
      // 4b: iinc 6 1
      // 4e: ifeq 22
      // 51: aload 5
      // 53: invokevirtual java/lang/StringBuilder.toString ()Ljava/lang/String;
      // 56: areturn
   }
}
