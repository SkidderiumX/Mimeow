package x;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class oc835693ee7c {
   private static final long є = 60000L;
   private static final long ҿ = 60000L;
   private static final Map<oc9e5a7eeec6, oc8a9bd37278<List<oc41720aed4a>>> V;
   private static final Map<String, oc8a9bd37278<String>> Ǟ;
   public static boolean ԁ;
   private static final String[] a;
   private static final String[] b;
   private static final long[] c;
   private static final Integer[] d;

   public static void Ĥ() {
      V.clear();
      Ǟ.clear();
   }

   public List<oc41720aed4a> ʴ(oc9e5a7eeec6 var1) throws Exception {
      return this.Ǯ(var1, false);
   }

   public List<oc41720aed4a> Ǯ(oc9e5a7eeec6 param1, boolean param2) throws Exception {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: ldc2_w -7549162306598626177
      // 03: ldc2_w -7549274155702932133
      // 06: lxor
      // 07: lstore 3
      // 08: lload 3
      // 09: dup2
      // 0a: ldc2_w -7549211167114172191
      // 0d: ldc2_w -7549274155702932133
      // 10: lxor
      // 11: lxor
      // 12: lstore 5
      // 14: pop2
      // 15: getstatic x/oc9e5a7eeec6.Ν Z
      // 18: istore 7
      // 1a: iload 2
      // 1b: ifne 58
      // 1e: getstatic x/oc835693ee7c.V Ljava/util/Map;
      // 21: aload 1
      // 22: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 27: checkcast x/oc8a9bd37278
      // 2a: astore 8
      // 2c: aload 8
      // 2e: iload 7
      // 30: ifne 3c
      // 33: ifnull 58
      // 36: goto 3a
      // 39: athrow
      // 3a: aload 8
      // 3c: iload 7
      // 3e: ifne 54
      // 41: invokevirtual x/oc8a9bd37278.Á ()Z
      // 44: ifeq 58
      // 47: goto 4b
      // 4a: athrow
      // 4b: aload 8
      // 4d: getfield x/oc8a9bd37278.ȱ Ljava/lang/Object;
      // 50: goto 54
      // 53: athrow
      // 54: checkcast java/util/List
      // 57: areturn
      // 58: aload 1
      // 59: invokevirtual x/oc9e5a7eeec6.Ӳ ()Ljava/lang/String;
      // 5c: ldc "configs/"
      // 5e: swap
      // 5f: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 64: invokestatic x/oc380d0f830c.ɦ (Ljava/lang/String;)Ljava/lang/String;
      // 67: invokestatic x/oc835693ee7c.ʮ (Ljava/lang/String;)Ljava/util/List;
      // 6a: astore 8
      // 6c: goto 9c
      // 6f: astore 9
      // 71: aload 9
      // 73: iload 7
      // 75: ifne 8d
      // 78: invokevirtual x/oca5f3ad0ac4.Ȥ ()I
      // 7b: ldc -1205301610
      // 7d: ldc -1205301502
      // 7f: ixor
      // 80: if_icmpeq 8e
      // 83: goto 87
      // 86: athrow
      // 87: aload 9
      // 89: goto 8d
      // 8c: athrow
      // 8d: athrow
      // 8e: lload 5
      // 90: aload 1
      // 91: invokestatic x/oc835693ee7c.Ž (JLx/oc9e5a7eeec6;)Ljava/lang/String;
      // 94: invokestatic x/oc380d0f830c.ɦ (Ljava/lang/String;)Ljava/lang/String;
      // 97: invokestatic x/oc835693ee7c.ʮ (Ljava/lang/String;)Ljava/util/List;
      // 9a: astore 8
      // 9c: getstatic x/oc835693ee7c.V Ljava/util/Map;
      // 9f: aload 1
      // a0: new x/oc8a9bd37278
      // a3: dup
      // a4: aload 8
      // a6: invokestatic java/lang/System.currentTimeMillis ()J
      // a9: ldc2_w -7549274155702892741
      // ac: ldc2_w -7549274155702932133
      // af: lxor
      // b0: ladd
      // b1: invokespecial x/oc8a9bd37278.<init> (Ljava/lang/Object;J)V
      // b4: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // b9: pop
      // ba: aload 8
      // bc: areturn
   }

   public String S(oc9e5a7eeec6 var1, String var2) throws Exception {
      return this.փ(var1, var2, false);
   }

   public String փ(oc9e5a7eeec6 param1, String param2, boolean param3) throws Exception {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: ldc2_w -5101000874582799599
      // 003: ldc2_w -5100992131279837955
      // 006: lxor
      // 007: lstore 4
      // 009: lload 4
      // 00b: dup2
      // 00c: ldc2_w -5100970707439976561
      // 00f: ldc2_w -5100992131279837955
      // 012: lxor
      // 013: lxor
      // 014: lstore 6
      // 016: pop2
      // 017: getstatic x/oc9e5a7eeec6.Ν Z
      // 01a: istore 8
      // 01c: aload 2
      // 01d: iload 8
      // 01f: ifne 030
      // 022: ifnonnull 02f
      // 025: goto 029
      // 028: athrow
      // 029: ldc ""
      // 02b: goto 033
      // 02e: athrow
      // 02f: aload 2
      // 030: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 033: astore 9
      // 035: aload 9
      // 037: invokevirtual java/lang/String.isEmpty ()Z
      // 03a: ifeq 048
      // 03d: new java/lang/Exception
      // 040: dup
      // 041: ldc "Invalid config id"
      // 043: invokespecial java/lang/Exception.<init> (Ljava/lang/String;)V
      // 046: athrow
      // 047: athrow
      // 048: aload 1
      // 049: iload 8
      // 04b: ifne 05c
      // 04e: ifnonnull 05b
      // 051: goto 055
      // 054: athrow
      // 055: ldc "OFFICIAL"
      // 057: goto 05f
      // 05a: athrow
      // 05b: aload 1
      // 05c: invokevirtual java/lang/Enum.name ()Ljava/lang/String;
      // 05f: aload 9
      // 061: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001:\u0001" ]
      // 066: astore 10
      // 068: iload 3
      // 069: ifne 0a7
      // 06c: getstatic x/oc835693ee7c.Ǟ Ljava/util/Map;
      // 06f: aload 10
      // 071: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 076: checkcast x/oc8a9bd37278
      // 079: astore 11
      // 07b: aload 11
      // 07d: iload 8
      // 07f: ifne 08b
      // 082: ifnull 0a7
      // 085: goto 089
      // 088: athrow
      // 089: aload 11
      // 08b: iload 8
      // 08d: ifne 0a3
      // 090: invokevirtual x/oc8a9bd37278.Á ()Z
      // 093: ifeq 0a7
      // 096: goto 09a
      // 099: athrow
      // 09a: aload 11
      // 09c: getfield x/oc8a9bd37278.ȱ Ljava/lang/Object;
      // 09f: goto 0a3
      // 0a2: athrow
      // 0a3: checkcast java/lang/String
      // 0a6: areturn
      // 0a7: aload 1
      // 0a8: invokevirtual x/oc9e5a7eeec6.Ӳ ()Ljava/lang/String;
      // 0ab: aload 9
      // 0ad: invokestatic x/oc380d0f830c.ѓ (Ljava/lang/String;)Ljava/lang/String;
      // 0b0: ldc "configs/"
      // 0b2: dup_x2
      // 0b3: pop
      // 0b4: ldc "/"
      // 0b6: swap
      // 0b7: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001\u0001" ]
      // 0bc: invokestatic x/oc380d0f830c.ɦ (Ljava/lang/String;)Ljava/lang/String;
      // 0bf: astore 11
      // 0c1: goto 0f8
      // 0c4: astore 12
      // 0c6: aload 12
      // 0c8: iload 8
      // 0ca: ifne 0e2
      // 0cd: invokevirtual x/oca5f3ad0ac4.Ȥ ()I
      // 0d0: ldc -839935567
      // 0d2: ldc -839935963
      // 0d4: ixor
      // 0d5: if_icmpeq 0e3
      // 0d8: goto 0dc
      // 0db: athrow
      // 0dc: aload 12
      // 0de: goto 0e2
      // 0e1: athrow
      // 0e2: athrow
      // 0e3: lload 6
      // 0e5: aload 1
      // 0e6: invokestatic x/oc835693ee7c.Ž (JLx/oc9e5a7eeec6;)Ljava/lang/String;
      // 0e9: aload 9
      // 0eb: invokestatic x/oc380d0f830c.ѓ (Ljava/lang/String;)Ljava/lang/String;
      // 0ee: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001/\u0001" ]
      // 0f3: invokestatic x/oc380d0f830c.ɦ (Ljava/lang/String;)Ljava/lang/String;
      // 0f6: astore 11
      // 0f8: getstatic x/oc835693ee7c.Ǟ Ljava/util/Map;
      // 0fb: aload 10
      // 0fd: new x/oc8a9bd37278
      // 100: dup
      // 101: aload 11
      // 103: invokestatic java/lang/System.currentTimeMillis ()J
      // 106: ldc2_w -5100992131279860067
      // 109: ldc2_w -5100992131279837955
      // 10c: lxor
      // 10d: ladd
      // 10e: invokespecial x/oc8a9bd37278.<init> (Ljava/lang/Object;J)V
      // 111: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 116: pop
      // 117: aload 11
      // 119: bipush 0
      // 11a: ifeq 12f
      // 11d: iload 8
      // 11f: ifeq 12b
      // 122: goto 126
      // 125: athrow
      // 126: bipush 0
      // 127: goto 12c
      // 12a: athrow
      // 12b: bipush 1
      // 12c: putstatic x/oc9e5a7eeec6.Ν Z
      // 12f: areturn
   }

   static List<oc41720aed4a> ʮ(String param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc9e5a7eeec6.Ν Z
      // 03: new com/google/gson/JsonParser
      // 06: dup
      // 07: invokespecial com/google/gson/JsonParser.<init> ()V
      // 0a: aload 0
      // 0b: invokevirtual com/google/gson/JsonParser.parse (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 0e: astore 2
      // 0f: istore 1
      // 10: aload 2
      // 11: iload 1
      // 12: ifne 2d
      // 15: invokevirtual com/google/gson/JsonElement.isJsonArray ()Z
      // 18: ifeq 28
      // 1b: goto 1f
      // 1e: athrow
      // 1f: aload 2
      // 20: invokevirtual com/google/gson/JsonElement.getAsJsonArray ()Lcom/google/gson/JsonArray;
      // 23: astore 3
      // 24: iload 1
      // 25: ifeq 7f
      // 28: aload 2
      // 29: goto 2d
      // 2c: athrow
      // 2d: iload 1
      // 2e: ifne 40
      // 31: invokevirtual com/google/gson/JsonElement.isJsonObject ()Z
      // 34: ifeq 7a
      // 37: goto 3b
      // 3a: athrow
      // 3b: aload 2
      // 3c: goto 40
      // 3f: athrow
      // 40: invokevirtual com/google/gson/JsonElement.getAsJsonObject ()Lcom/google/gson/JsonObject;
      // 43: astore 4
      // 45: aload 4
      // 47: ldc "configs"
      // 49: invokevirtual com/google/gson/JsonObject.get (Ljava/lang/String;)Lcom/google/gson/JsonElement;
      // 4c: astore 5
      // 4e: aload 5
      // 50: iload 1
      // 51: ifne 5d
      // 54: ifnull 6b
      // 57: goto 5b
      // 5a: athrow
      // 5b: aload 5
      // 5d: iload 1
      // 5e: ifne 72
      // 61: invokevirtual com/google/gson/JsonElement.isJsonArray ()Z
      // 64: ifne 70
      // 67: goto 6b
      // 6a: athrow
      // 6b: invokestatic java/util/Collections.emptyList ()Ljava/util/List;
      // 6e: areturn
      // 6f: athrow
      // 70: aload 5
      // 72: invokevirtual com/google/gson/JsonElement.getAsJsonArray ()Lcom/google/gson/JsonArray;
      // 75: astore 3
      // 76: iload 1
      // 77: ifeq 7f
      // 7a: invokestatic java/util/Collections.emptyList ()Ljava/util/List;
      // 7d: areturn
      // 7e: athrow
      // 7f: new java/util/ArrayList
      // 82: dup
      // 83: invokespecial java/util/ArrayList.<init> ()V
      // 86: astore 4
      // 88: aload 3
      // 89: invokevirtual com/google/gson/JsonArray.iterator ()Ljava/util/Iterator;
      // 8c: astore 5
      // 8e: aload 5
      // 90: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 95: ifeq f8
      // 98: aload 5
      // 9a: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 9f: checkcast com/google/gson/JsonElement
      // a2: astore 6
      // a4: aload 6
      // a6: iload 1
      // a7: ifne be
      // aa: invokevirtual com/google/gson/JsonElement.isJsonObject ()Z
      // ad: ifne bc
      // b0: goto b4
      // b3: athrow
      // b4: iload 1
      // b5: ifeq 8e
      // b8: goto bc
      // bb: athrow
      // bc: aload 6
      // be: invokevirtual com/google/gson/JsonElement.getAsJsonObject ()Lcom/google/gson/JsonObject;
      // c1: invokestatic x/oc41720aed4a.C (Lcom/google/gson/JsonObject;)Lx/oc41720aed4a;
      // c4: astore 7
      // c6: aload 7
      // c8: iload 1
      // c9: ifne d5
      // cc: ifnull f4
      // cf: goto d3
      // d2: athrow
      // d3: aload 7
      // d5: invokevirtual x/oc41720aed4a.ǒ ()Ljava/lang/String;
      // d8: invokevirtual java/lang/String.isEmpty ()Z
      // db: iload 1
      // dc: ifne f3
      // df: ifne f4
      // e2: goto e6
      // e5: athrow
      // e6: aload 4
      // e8: aload 7
      // ea: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // ef: goto f3
      // f2: athrow
      // f3: pop
      // f4: iload 1
      // f5: ifeq 8e
      // f8: aload 4
      // fa: areturn
   }

   private static String Ž(long var0, oc9e5a7eeec6 var2) {
      byte var3 = oc9e5a7eeec6.Ν;
      int var4 = a(303255486 ^ 303252377, 6243637654715761176L ^ 8999423817923049557L ^ var0);

      while (true) {
         switch (var4) {
            case -1839994158:
               int var10000;
               label25: {
                  if (var2 == oc9e5a7eeec6.ý) {
                     var10000 = 303256860 ^ 303252377;
                     if (var0 <= 1L) {
                        break label25;
                     }

                     var4 = a(var10000, 7435029519190005947L ^ 8999423817923049557L ^ var0);
                     if (var3 == 0) {
                        break;
                     }
                  }

                  var4 = a(303240699 ^ 303252377, 3754597980957464670L ^ 8999423817923049557L ^ var0);
                  var10000 = var3;
               }

               if (var10000 == 0) {
                  break;
               }
            case -319072712:
               return a((-389593419 ^ 303252377) - -((char)(-303258998 ^ 303252377)), (389593421 ^ 303252377) - (char)(-303244869 ^ 303252377), (int)var0);
            case 1217635577:
               return a((-389593419 ^ 303252377) - -((char)(-303258997 ^ 303252377)), (-389593419 ^ 303252377) - -((char)(-303258252 ^ 303252377)), (int)var0);
            default:
               throw null;
         }
      }
   }

   // $VF: Irreducible bytecode was duplicated to produce valid code
   static {
      String[] var13 = new String[1817233184 ^ 1817233186];
      int var11 = 0;
      String var10 = "\rì\u0011sqr¥ö\fÂj?qÃù76\u0018Õ\u009dM";
      int var12 = "\rì\u0011sqr¥ö\fÂj?qÃù76\u0018Õ\u009dM".length();
      int var9 = 1817233194 ^ 1817233186;
      int var8 = -1;

      while (true) {
         char[] var26;
         label47: {
            char[] var10001 = var10.substring(++var8, var8 + var9).toCharArray();
            int var10003 = var10001.length;
            int var14 = 0;
            var26 = var10001;
            int var18 = var10003;
            char[] var33;
            int var10004;
            if (var10003 <= 1) {
               var33 = var10001;
               var10004 = var14;
            } else {
               var26 = var10001;
               var18 = var10003;
               if (var10003 <= var14) {
                  break label47;
               }

               var33 = var10001;
               var10004 = var14;
            }

            while (true) {
               var33[var10004] = (char)(var33[var10004] ^ switch (var14 % (1817233189 ^ 1817233186)) {
                  case 0 -> 1817233167 ^ 1817233186;
                  case 1 -> 1817233168 ^ 1817233186;
                  case 2 -> 1817233246 ^ 1817233186;
                  case 3 -> 1817233207 ^ 1817233186;
                  case 4 -> 1817233261 ^ 1817233186;
                  case 5 -> 1817233160 ^ 1817233186;
                  default -> 1817233251 ^ 1817233186;
               });
               var14++;
               if (var18 == 0) {
                  var10004 = var18;
                  var33 = var26;
               } else {
                  if (var18 <= var14) {
                     break;
                  }

                  var33 = var26;
                  var10004 = var14;
               }
            }
         }

         String var40 = new String(var26).intern();
         int var22 = -1;
         var13[var11++] = var40;
         if ((var8 += var9) >= var12) {
            a = var13;
            b = new String[1817233184 ^ 1817233186];
            long var0 = 5067296692113492270L ^ 5067274056463751153L;
            long[] var6 = new long[1817233185 ^ 1817233186];
            int var3 = 0;
            String var4 = "\faÞjz\u0018®VÀARýÊ\u0093úÞ»Oá!Æó\u001cr";
            int var5 = "\faÞjz\u0018®VÀARýÊ\u0093úÞ»Oá!Æó\u001cr".length();
            byte var2 = 0;

            do {
               var22 = var2;
               var2 += 8;
               byte[] var7 = var4.substring(var22, var2).getBytes("ISO-8859-1");
               var22 = var3++;
               long var42 = (
                     (var7[0] & (5067274056463750926L ^ 5067274056463751153L)) << (1817233178 ^ 1817233186)
                        | (var7[1] & (5067274056463750926L ^ 5067274056463751153L)) << (1817233170 ^ 1817233186)
                        | (var7[1817233184 ^ 1817233186] & (5067274056463750926L ^ 5067274056463751153L)) << (1817233162 ^ 1817233186)
                        | (var7[1817233185 ^ 1817233186] & (5067274056463750926L ^ 5067274056463751153L)) << (1817233154 ^ 1817233186)
                        | (var7[1817233190 ^ 1817233186] & (5067274056463750926L ^ 5067274056463751153L)) << (1817233210 ^ 1817233186)
                        | (var7[1817233191 ^ 1817233186] & (5067274056463750926L ^ 5067274056463751153L)) << (1817233202 ^ 1817233186)
                        | (var7[1817233188 ^ 1817233186] & (5067274056463750926L ^ 5067274056463751153L)) << (1817233194 ^ 1817233186)
                        | var7[1817233189 ^ 1817233186] & (5067274056463750926L ^ 5067274056463751153L)
                  )
                  ^ var0;
               byte var41 = -1;
               var6[var22] = var42;
            } while (var2 < var5);

            c = var6;
            d = new Integer[1817233185 ^ 1817233186];
            V = new ConcurrentHashMap<>();
            Ǟ = new ConcurrentHashMap<>();
            return;
         }

         var9 = var10.charAt(var8);
      }
   }

   private static String a(int var0, int var1, int var2) {
      int var3 = (var0 ^ var2 ^ -1373551029 ^ -1373547286) & (-1373525227 ^ -1373547286);
      if (b[var3] == null) {
         char[] var4 = a[var3].toCharArray();

         int var5 = switch (var4[0] & (-1373547499 ^ -1373547286)) {
            case 0 -> -1373547339 ^ -1373547286;
            case 1 -> -1373547290 ^ -1373547286;
            case 2 -> -1373547336 ^ -1373547286;
            case 3 -> -1373547283 ^ -1373547286;
            case 4 -> -1373547438 ^ -1373547286;
            case 5 -> -1373547399 ^ -1373547286;
            case 6 -> -1373547427 ^ -1373547286;
            case 7 -> -1373547411 ^ -1373547286;
            case 8 -> -1373547487 ^ -1373547286;
            case 9 -> -1373547353 ^ -1373547286;
            case 10 -> -1373547342 ^ -1373547286;
            case 11 -> -1373547457 ^ -1373547286;
            case 12 -> -1373547381 ^ -1373547286;
            case 13 -> -1373547410 ^ -1373547286;
            case 14 -> -1373547472 ^ -1373547286;
            case 15 -> -1373547442 ^ -1373547286;
            case 16 -> -1373547327 ^ -1373547286;
            case 17 -> -1373547293 ^ -1373547286;
            case 18 -> -1373547395 ^ -1373547286;
            case 19 -> -1373547278 ^ -1373547286;
            case 20 -> -1373547355 ^ -1373547286;
            case 21 -> -1373547444 ^ -1373547286;
            case 22 -> -1373547271 ^ -1373547286;
            case 23 -> -1373547468 ^ -1373547286;
            case 24 -> -1373547503 ^ -1373547286;
            case 25 -> -1373547274 ^ -1373547286;
            case 26 -> -1373547313 ^ -1373547286;
            case 27 -> -1373547316 ^ -1373547286;
            case 28 -> -1373547517 ^ -1373547286;
            case 29 -> -1373547374 ^ -1373547286;
            case 30 -> -1373547289 ^ -1373547286;
            case 31 -> -1373547312 ^ -1373547286;
            case 32 -> -1373547469 ^ -1373547286;
            case 33 -> -1373547367 ^ -1373547286;
            case 34 -> -1373547474 ^ -1373547286;
            case 35 -> -1373547321 ^ -1373547286;
            case 36 -> -1373547436 ^ -1373547286;
            case 37 -> -1373547346 ^ -1373547286;
            case 38 -> -1373547391 ^ -1373547286;
            case 39 -> -1373547326 ^ -1373547286;
            case 40 -> -1373547352 ^ -1373547286;
            case 41 -> -1373547272 ^ -1373547286;
            case 42 -> -1373547405 ^ -1373547286;
            case 43 -> -1373547358 ^ -1373547286;
            case 44 -> -1373547509 ^ -1373547286;
            case 45 -> -1373547328 ^ -1373547286;
            case 46 -> -1373547337 ^ -1373547286;
            case 47 -> -1373547296 ^ -1373547286;
            case 48 -> -1373547389 ^ -1373547286;
            case 49 -> -1373547413 ^ -1373547286;
            case 50 -> -1373547386 ^ -1373547286;
            case 51 -> -1373547276 ^ -1373547286;
            case 52 -> -1373547448 ^ -1373547286;
            case 53 -> -1373547486 ^ -1373547286;
            case 54 -> -1373547310 ^ -1373547286;
            case 55 -> -1373547423 ^ -1373547286;
            case 56 -> -1373547294 ^ -1373547286;
            case 57 -> -1373547508 ^ -1373547286;
            case 58 -> -1373547318 ^ -1373547286;
            case 59 -> -1373547322 ^ -1373547286;
            case 60 -> -1373547371 ^ -1373547286;
            case 61 -> -1373547334 ^ -1373547286;
            case 62 -> -1373547435 ^ -1373547286;
            case 63 -> -1373547398 ^ -1373547286;
            case 64 -> -1373547430 ^ -1373547286;
            case 65 -> -1373547287 ^ -1373547286;
            case 66 -> -1373547506 ^ -1373547286;
            case 67 -> -1373547401 ^ -1373547286;
            case 68 -> -1373547319 ^ -1373547286;
            case 69 -> -1373547504 ^ -1373547286;
            case 70 -> -1373547359 ^ -1373547286;
            case 71 -> -1373547414 ^ -1373547286;
            case 72 -> -1373547451 ^ -1373547286;
            case 73 -> -1373547496 ^ -1373547286;
            case 74 -> -1373547341 ^ -1373547286;
            case 75 -> -1373547365 ^ -1373547286;
            case 76 -> -1373547354 ^ -1373547286;
            case 77 -> -1373547446 ^ -1373547286;
            case 78 -> -1373547378 ^ -1373547286;
            case 79 -> -1373547421 ^ -1373547286;
            case 80 -> -1373547393 ^ -1373547286;
            case 81 -> -1373547515 ^ -1373547286;
            case 82 -> -1373547512 ^ -1373547286;
            case 83 -> -1373547317 ^ -1373547286;
            case 84 -> -1373547350 ^ -1373547286;
            case 85 -> -1373547356 ^ -1373547286;
            case 86 -> -1373547329 ^ -1373547286;
            case 87 -> -1373547277 ^ -1373547286;
            case 88 -> -1373547303 ^ -1373547286;
            case 89 -> -1373547465 ^ -1373547286;
            case 90 -> -1373547494 ^ -1373547286;
            case 91 -> -1373547420 ^ -1373547286;
            case 92 -> -1373547481 ^ -1373547286;
            case 93 -> -1373547495 ^ -1373547286;
            case 94 -> -1373547345 ^ -1373547286;
            case 95 -> -1373547443 ^ -1373547286;
            case 96 -> -1373547424 ^ -1373547286;
            case 97 -> -1373547440 ^ -1373547286;
            case 98 -> -1373547320 ^ -1373547286;
            case 99 -> -1373547292 ^ -1373547286;
            case 100 -> -1373547425 ^ -1373547286;
            case 101 -> -1373547383 ^ -1373547286;
            case 102 -> -1373547416 ^ -1373547286;
            case 103 -> -1373547375 ^ -1373547286;
            case 104 -> -1373547441 ^ -1373547286;
            case 105 -> -1373547519 ^ -1373547286;
            case 106 -> -1373547428 ^ -1373547286;
            case 107 -> -1373547490 ^ -1373547286;
            case 108 -> -1373547268 ^ -1373547286;
            case 109 -> -1373547376 ^ -1373547286;
            case 110 -> -1373547311 ^ -1373547286;
            case 111 -> -1373547464 ^ -1373547286;
            case 112 -> -1373547364 ^ -1373547286;
            case 113 -> -1373547344 ^ -1373547286;
            case 114 -> -1373547434 ^ -1373547286;
            case 115 -> -1373547275 ^ -1373547286;
            case 116 -> -1373547396 ^ -1373547286;
            case 117 -> -1373547408 ^ -1373547286;
            case 118 -> -1373547498 ^ -1373547286;
            case 119 -> -1373547463 ^ -1373547286;
            case 120 -> -1373547304 ^ -1373547286;
            case 121 -> -1373547333 ^ -1373547286;
            case 122 -> -1373547385 ^ -1373547286;
            case 123 -> -1373547479 ^ -1373547286;
            case 124 -> -1373547282 ^ -1373547286;
            case 125 -> -1373547269 ^ -1373547286;
            case 126 -> -1373547351 ^ -1373547286;
            case 127 -> -1373547499 ^ -1373547286;
            case 128 -> -1373547298 ^ -1373547286;
            case 129 -> 1;
            case 130 -> -1373547299 ^ -1373547286;
            case 131 -> -1373547412 ^ -1373547286;
            case 132 -> -1373547520 ^ -1373547286;
            case 133 -> -1373547402 ^ -1373547286;
            case 134 -> -1373547331 ^ -1373547286;
            case 135 -> -1373547505 ^ -1373547286;
            case 136 -> -1373547491 ^ -1373547286;
            case 137 -> -1373547475 ^ -1373547286;
            case 138 -> -1373547394 ^ -1373547286;
            case 139 -> -1373547466 ^ -1373547286;
            case 140 -> -1373547417 ^ -1373547286;
            case 141 -> -1373547281 ^ -1373547286;
            case 142 -> -1373547419 ^ -1373547286;
            case 143 -> -1373547338 ^ -1373547286;
            case 144 -> -1373547360 ^ -1373547286;
            case 145 -> -1373547453 ^ -1373547286;
            case 146 -> -1373547288 ^ -1373547286;
            case 147 -> -1373547335 ^ -1373547286;
            case 148 -> -1373547266 ^ -1373547286;
            case 149 -> -1373547478 ^ -1373547286;
            case 150 -> -1373547449 ^ -1373547286;
            case 151 -> -1373547458 ^ -1373547286;
            case 152 -> -1373547429 ^ -1373547286;
            case 153 -> -1373547379 ^ -1373547286;
            case 154 -> -1373547323 ^ -1373547286;
            case 155 -> -1373547297 ^ -1373547286;
            case 156 -> -1373547447 ^ -1373547286;
            case 157 -> -1373547363 ^ -1373547286;
            case 158 -> -1373547373 ^ -1373547286;
            case 159 -> -1373547488 ^ -1373547286;
            case 160 -> -1373547502 ^ -1373547286;
            case 161 -> -1373547392 ^ -1373547286;
            case 162 -> -1373547480 ^ -1373547286;
            case 163 -> -1373547459 ^ -1373547286;
            case 164 -> -1373547501 ^ -1373547286;
            case 165 -> -1373547357 ^ -1373547286;
            case 166 -> -1373547308 ^ -1373547286;
            case 167 -> -1373547507 ^ -1373547286;
            case 168 -> -1373547366 ^ -1373547286;
            case 169 -> -1373547291 ^ -1373547286;
            case 170 -> -1373547273 ^ -1373547286;
            case 171 -> -1373547489 ^ -1373547286;
            case 172 -> -1373547314 ^ -1373547286;
            case 173 -> -1373547397 ^ -1373547286;
            case 174 -> -1373547332 ^ -1373547286;
            case 175 -> -1373547510 ^ -1373547286;
            case 176 -> -1373547406 ^ -1373547286;
            case 177 -> -1373547473 ^ -1373547286;
            case 178 -> -1373547493 ^ -1373547286;
            case 179 -> -1373547265 ^ -1373547286;
            case 180 -> -1373547476 ^ -1373547286;
            case 181 -> -1373547305 ^ -1373547286;
            case 182 -> -1373547511 ^ -1373547286;
            case 183 -> -1373547315 ^ -1373547286;
            case 184 -> -1373547407 ^ -1373547286;
            case 185 -> -1373547415 ^ -1373547286;
            case 186 -> -1373547380 ^ -1373547286;
            case 187 -> -1373547325 ^ -1373547286;
            case 188 -> -1373547403 ^ -1373547286;
            case 189 -> -1373547454 ^ -1373547286;
            case 190 -> -1373547452 ^ -1373547286;
            case 191 -> -1373547471 ^ -1373547286;
            case 192 -> -1373547409 ^ -1373547286;
            case 193 -> -1373547270 ^ -1373547286;
            case 194 -> -1373547347 ^ -1373547286;
            case 195 -> -1373547516 ^ -1373547286;
            case 196 -> -1373547300 ^ -1373547286;
            case 197 -> -1373547445 ^ -1373547286;
            case 198 -> -1373547361 ^ -1373547286;
            case 199 -> -1373547482 ^ -1373547286;
            case 200 -> -1373547301 ^ -1373547286;
            case 201 -> -1373547362 ^ -1373547286;
            case 202 -> -1373547309 ^ -1373547286;
            case 203 -> -1373547343 ^ -1373547286;
            case 204 -> -1373547372 ^ -1373547286;
            case 205 -> -1373547437 ^ -1373547286;
            case 206 -> -1373547456 ^ -1373547286;
            case 207 -> -1373547279 ^ -1373547286;
            case 208 -> -1373547439 ^ -1373547286;
            case 209 -> -1373547483 ^ -1373547286;
            case 210 -> -1373547461 ^ -1373547286;
            case 211 -> -1373547433 ^ -1373547286;
            case 212 -> -1373547404 ^ -1373547286;
            case 213 -> -1373547382 ^ -1373547286;
            case 214 -> -1373547302 ^ -1373547286;
            case 215 -> -1373547369 ^ -1373547286;
            case 216 -> -1373547387 ^ -1373547286;
            case 217 -> -1373547431 ^ -1373547286;
            case 218 -> -1373547518 ^ -1373547286;
            case 219 -> -1373547450 ^ -1373547286;
            case 220 -> -1373547348 ^ -1373547286;
            case 221 -> -1373547295 ^ -1373547286;
            case 222 -> -1373547306 ^ -1373547286;
            case 223 -> -1373547368 ^ -1373547286;
            case 224 -> -1373547422 ^ -1373547286;
            case 225 -> -1373547400 ^ -1373547286;
            case 226 -> -1373547349 ^ -1373547286;
            case 227 -> -1373547514 ^ -1373547286;
            case 228 -> -1373547470 ^ -1373547286;
            case 229 -> -1373547455 ^ -1373547286;
            case 230 -> -1373547384 ^ -1373547286;
            case 231 -> -1373547497 ^ -1373547286;
            case 232 -> -1373547370 ^ -1373547286;
            case 233 -> -1373547267 ^ -1373547286;
            case 234 -> -1373547284 ^ -1373547286;
            case 235 -> -1373547388 ^ -1373547286;
            case 236 -> -1373547492 ^ -1373547286;
            case 237 -> -1373547307 ^ -1373547286;
            case 238 -> 0;
            case 239 -> -1373547513 ^ -1373547286;
            case 240 -> -1373547390 ^ -1373547286;
            case 241 -> -1373547500 ^ -1373547286;
            case 242 -> -1373547460 ^ -1373547286;
            case 243 -> -1373547340 ^ -1373547286;
            case 244 -> -1373547418 ^ -1373547286;
            case 245 -> -1373547330 ^ -1373547286;
            case 246 -> -1373547467 ^ -1373547286;
            case 247 -> -1373547485 ^ -1373547286;
            case 248 -> -1373547462 ^ -1373547286;
            case 249 -> -1373547280 ^ -1373547286;
            case 250 -> -1373547432 ^ -1373547286;
            case 251 -> -1373547477 ^ -1373547286;
            case 252 -> -1373547324 ^ -1373547286;
            case 253 -> -1373547426 ^ -1373547286;
            case 254 -> -1373547484 ^ -1373547286;
            default -> -1373547377 ^ -1373547286;
         };
         int var10;
         int var6 = ((var10 = var1 ^ var2) & (-1373547499 ^ -1373547286)) - var5;
         if (var6 < 0) {
            var6 += 256;
         }

         int var7 = ((var10 & (-1373525227 ^ -1373547286)) >>> (-1373547294 ^ -1373547286)) - var5;
         if (var7 < 0) {
            var7 += 256;
         }

         for (int var8 = 0; var8 < var4.length; var8++) {
            int var9 = var8 % (-1373547288 ^ -1373547286);
            char var10002 = var4[var8];
            if (var9 == 0) {
               var4[var8] = (char)(var10002 ^ var6);
               var6 = ((var6 >>> (-1373547287 ^ -1373547286) | var6 << (-1373547281 ^ -1373547286)) ^ var4[var8]) & (-1373547499 ^ -1373547286);
            } else {
               var4[var8] = (char)(var10002 ^ var7);
               var7 = ((var7 >>> (-1373547287 ^ -1373547286) | var7 << (-1373547281 ^ -1373547286)) ^ var4[var8]) & (-1373547499 ^ -1373547286);
            }
         }

         b[var3] = new String(var4).intern();
      }

      return b[var3];
   }

   private static int a(int var0, long var1) {
      int var3 = var0 ^ (int)(var1 & (-1612572271239853806L ^ -1612572271239825683L)) ^ -410178576 ^ -410162939;
      if (d[var3] == null) {
         d[var3] = (int)(c[var3] ^ var1);
      }

      return d[var3];
   }
}
