package x;

public class ocbc6b8beaac {
   public static boolean Ҍ;

   private ocbc6b8beaac() {
   }

   private static double ƭ(int var0) {
      return ocd857d42ebe.Ҝ(var0);
   }

   private static double ҹ(int var0) {
      return ocd857d42ebe.Ԣ((-876527702 ^ -873796718) + (-873796714 ^ -873796718) * var0);
   }

   private static double ņ(double[] var0, double[] var1, int var2, int var3) {
      double var5 = 0.0;
      int var4 = oc01be0c7606.ź;
      int var7 = 0;

      double var10000;
      while (true) {
         if (var7 <= var2) {
            var10000 = var5;
            if (var4 != 0) {
               break;
            }

            var5 += var0[var7] * var1[var2 + var3 - var7];
            var7++;
            if (var4 == 0) {
               continue;
            }
         }

         var10000 = var5;
         break;
      }

      return var10000;
   }

   private static double Ӄ(double var0, int var2) {
      try {
         if (var2 != 0) {
            return Double.longBitsToDouble(Double.doubleToRawLongBits(var0) ^ ocd857d42ebe.h(603806833 ^ 601287697));
         }
      } catch (ocbde1165e4e var3) {
         throw var3;
      }

      return var0;
   }

   public static int ӌ(double[] param0, double[] param1, int param2, int param3, int param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc01be0c7606.ź I
      // 003: ldc 872598488
      // 005: ldc 875110384
      // 007: ixor
      // 008: ldc 875110388
      // 00a: ldc 875110384
      // 00c: ixor
      // 00d: iload 4
      // 00f: imul
      // 010: iadd
      // 011: invokestatic x/ocd857d42ebe.Ԣ (I)I
      // 014: istore 6
      // 016: iload 3
      // 017: bipush 1
      // 018: isub
      // 019: istore 7
      // 01b: bipush 0
      // 01c: iload 2
      // 01d: ldc 875110387
      // 01f: ldc 875110384
      // 021: ixor
      // 022: isub
      // 023: i2s
      // 024: ldc 875110376
      // 026: ldc 875110384
      // 028: ixor
      // 029: idiv
      // 02a: invokestatic java/lang/Math.max (II)I
      // 02d: istore 8
      // 02f: istore 5
      // 031: iload 2
      // 032: ldc 875110376
      // 034: ldc 875110384
      // 036: ixor
      // 037: iload 8
      // 039: bipush 1
      // 03a: iadd
      // 03b: imul
      // 03c: isub
      // 03d: istore 9
      // 03f: ldc 875110372
      // 041: ldc 875110384
      // 043: ixor
      // 044: newarray 7
      // 046: astore 10
      // 048: ldc 875110372
      // 04a: ldc 875110384
      // 04c: ixor
      // 04d: newarray 7
      // 04f: astore 11
      // 051: ldc 875110372
      // 053: ldc 875110384
      // 055: ixor
      // 056: newarray 7
      // 058: astore 12
      // 05a: ldc 875110372
      // 05c: ldc 875110384
      // 05e: ixor
      // 05f: newarray 10
      // 061: astore 13
      // 063: ldc 872591312
      // 065: ldc 875110384
      // 067: ixor
      // 068: invokestatic x/ocbc6b8beaac.ƭ (I)D
      // 06b: dstore 14
      // 06d: ldc 872591320
      // 06f: ldc 875110384
      // 071: ixor
      // 072: invokestatic x/ocbc6b8beaac.ƭ (I)D
      // 075: dstore 16
      // 077: ldc 872591296
      // 079: ldc 875110384
      // 07b: ixor
      // 07c: invokestatic x/ocbc6b8beaac.ƭ (I)D
      // 07f: dstore 18
      // 081: ldc 872591264
      // 083: ldc 875110384
      // 085: ixor
      // 086: invokestatic x/ocbc6b8beaac.ƭ (I)D
      // 089: dstore 20
      // 08b: ldc 872591288
      // 08d: ldc 875110384
      // 08f: ixor
      // 090: invokestatic x/ocbc6b8beaac.ƭ (I)D
      // 093: dstore 22
      // 095: bipush 0
      // 096: istore 24
      // 098: iload 24
      // 09a: iload 7
      // 09c: iload 6
      // 09e: iadd
      // 09f: if_icmpgt 0e3
      // 0a2: iload 5
      // 0a4: ifne 0e6
      // 0a7: iload 8
      // 0a9: iload 7
      // 0ab: isub
      // 0ac: iload 24
      // 0ae: iadd
      // 0af: istore 25
      // 0b1: aload 10
      // 0b3: iload 24
      // 0b5: iload 25
      // 0b7: iload 5
      // 0b9: ifne 0ca
      // 0bc: ifge 0c8
      // 0bf: goto 0c3
      // 0c2: athrow
      // 0c3: dconst_0
      // 0c4: goto 0cd
      // 0c7: athrow
      // 0c8: iload 25
      // 0ca: invokestatic x/ocbc6b8beaac.ҹ (I)D
      // 0cd: dastore
      // 0ce: iload 5
      // 0d0: iinc 24 1
      // 0d3: ifeq 098
      // 0d6: bipush 0
      // 0d7: ifeq 0df
      // 0da: bipush 0
      // 0db: goto 0e0
      // 0de: athrow
      // 0df: bipush 1
      // 0e0: putstatic x/oc69da1aa7f5.Ҭ Z
      // 0e3: bipush 0
      // 0e4: istore 24
      // 0e6: iload 24
      // 0e8: iload 6
      // 0ea: if_icmpgt 111
      // 0ed: iload 5
      // 0ef: ifne 115
      // 0f2: goto 0f6
      // 0f5: athrow
      // 0f6: aload 11
      // 0f8: iload 24
      // 0fa: aload 0
      // 0fb: aload 10
      // 0fd: iload 7
      // 0ff: iload 24
      // 101: invokestatic x/ocbc6b8beaac.ņ ([D[DII)D
      // 104: dastore
      // 105: iload 5
      // 107: iinc 24 1
      // 10a: ifeq 0e6
      // 10d: goto 111
      // 110: athrow
      // 111: iload 6
      // 113: istore 24
      // 115: bipush 0
      // 116: istore 25
      // 118: bipush 0
      // 119: istore 26
      // 11b: aload 11
      // 11d: iload 24
      // 11f: daload
      // 120: dstore 27
      // 122: bipush 0
      // 123: istore 29
      // 125: iload 24
      // 127: istore 30
      // 129: iload 30
      // 12b: ifle 165
      // 12e: dload 27
      // 130: dload 14
      // 132: dmul
      // 133: invokestatic x/oc30e402796f.ϒ (D)I
      // 136: i2d
      // 137: dstore 31
      // 139: aload 13
      // 13b: iload 29
      // 13d: dload 31
      // 13f: dload 18
      // 141: dmul
      // 142: dload 27
      // 144: dadd
      // 145: invokestatic x/oc30e402796f.ϒ (D)I
      // 148: iastore
      // 149: aload 11
      // 14b: iload 30
      // 14d: bipush 1
      // 14e: isub
      // 14f: daload
      // 150: iload 5
      // 152: ifne 17c
      // 155: dload 31
      // 157: dadd
      // 158: dstore 27
      // 15a: iload 5
      // 15c: iinc 29 1
      // 15f: iinc 30 -1
      // 162: ifeq 129
      // 165: dload 27
      // 167: iload 9
      // 169: invokestatic x/oc15a3bceb4a.ѷ (DI)D
      // 16c: dstore 27
      // 16e: dload 27
      // 170: ldc 872591304
      // 172: ldc 875110384
      // 174: ixor
      // 175: invokestatic x/ocbc6b8beaac.ƭ (I)D
      // 178: dmul
      // 179: invokestatic x/oc15a3bceb4a.ӿ (D)D
      // 17c: dstore 30
      // 17e: dload 30
      // 180: ldc 872591280
      // 182: ldc 875110384
      // 184: ixor
      // 185: invokestatic x/ocbc6b8beaac.ƭ (I)D
      // 188: dmul
      // 189: dload 27
      // 18b: dadd
      // 18c: dstore 27
      // 18e: dload 27
      // 190: invokestatic x/oc30e402796f.ϒ (D)I
      // 193: iload 5
      // 195: ifne 1f6
      // 198: istore 25
      // 19a: dload 27
      // 19c: iload 25
      // 19e: i2d
      // 19f: dsub
      // 1a0: dstore 27
      // 1a2: bipush 0
      // 1a3: istore 26
      // 1a5: iload 9
      // 1a7: ifle 1f4
      // 1aa: aload 13
      // 1ac: iload 24
      // 1ae: bipush 1
      // 1af: isub
      // 1b0: iaload
      // 1b1: ldc 875110376
      // 1b3: ldc 875110384
      // 1b5: ixor
      // 1b6: iload 9
      // 1b8: isub
      // 1b9: ishr
      // 1ba: istore 32
      // 1bc: iload 5
      // 1be: iload 25
      // 1c0: iload 32
      // 1c2: iadd
      // 1c3: istore 25
      // 1c5: aload 13
      // 1c7: iload 24
      // 1c9: bipush 1
      // 1ca: isub
      // 1cb: aload 13
      // 1cd: iload 24
      // 1cf: bipush 1
      // 1d0: isub
      // 1d1: iaload
      // 1d2: iload 32
      // 1d4: ldc 875110376
      // 1d6: ldc 875110384
      // 1d8: ixor
      // 1d9: iload 9
      // 1db: isub
      // 1dc: ishl
      // 1dd: isub
      // 1de: iastore
      // 1df: aload 13
      // 1e1: iload 24
      // 1e3: bipush 1
      // 1e4: isub
      // 1e5: iaload
      // 1e6: ldc 875110375
      // 1e8: ldc 875110384
      // 1ea: ixor
      // 1eb: iload 9
      // 1ed: isub
      // 1ee: ishr
      // 1ef: istore 26
      // 1f1: ifeq 232
      // 1f4: iload 9
      // 1f6: iload 5
      // 1f8: ifne 21f
      // 1fb: ifne 216
      // 1fe: goto 202
      // 201: athrow
      // 202: aload 13
      // 204: iload 24
      // 206: bipush 1
      // 207: isub
      // 208: iaload
      // 209: ldc 875110375
      // 20b: ldc 875110384
      // 20d: ixor
      // 20e: ishr
      // 20f: istore 26
      // 211: iload 5
      // 213: ifeq 232
      // 216: dload 27
      // 218: dload 22
      // 21a: dcmpg
      // 21b: goto 21f
      // 21e: athrow
      // 21f: iload 5
      // 221: ifne 234
      // 224: iflt 232
      // 227: goto 22b
      // 22a: athrow
      // 22b: ldc 875110386
      // 22d: ldc 875110384
      // 22f: ixor
      // 230: istore 26
      // 232: iload 26
      // 234: iload 5
      // 236: ifne 33d
      // 239: ifle 339
      // 23c: goto 240
      // 23f: athrow
      // 240: iinc 25 1
      // 243: bipush 0
      // 244: istore 32
      // 246: bipush 0
      // 247: istore 33
      // 249: iload 33
      // 24b: iload 24
      // 24d: if_icmpge 2ae
      // 250: aload 13
      // 252: iload 33
      // 254: iaload
      // 255: istore 34
      // 257: iload 5
      // 259: ifne 2da
      // 25c: iload 32
      // 25e: iload 5
      // 260: ifne 28a
      // 263: goto 267
      // 266: athrow
      // 267: ifeq 284
      // 26a: goto 26e
      // 26d: athrow
      // 26e: aload 13
      // 270: iload 33
      // 272: ldc 886497295
      // 274: ldc 875110384
      // 276: ixor
      // 277: iload 34
      // 279: isub
      // 27a: iastore
      // 27b: iload 5
      // 27d: ifeq 2a6
      // 280: goto 284
      // 283: athrow
      // 284: iload 34
      // 286: goto 28a
      // 289: athrow
      // 28a: iload 5
      // 28c: ifne 297
      // 28f: ifeq 2a6
      // 292: goto 296
      // 295: athrow
      // 296: bipush 1
      // 297: istore 32
      // 299: aload 13
      // 29b: iload 33
      // 29d: ldc 891887600
      // 29f: ldc 875110384
      // 2a1: ixor
      // 2a2: iload 34
      // 2a4: isub
      // 2a5: iastore
      // 2a6: iinc 33 1
      // 2a9: iload 5
      // 2ab: ifeq 249
      // 2ae: iload 9
      // 2b0: iload 5
      // 2b2: ifne 2dc
      // 2b5: bipush 1
      // 2b6: if_icmpne 2da
      // 2b9: goto 2bd
      // 2bc: athrow
      // 2bd: aload 13
      // 2bf: iload 24
      // 2c1: bipush 1
      // 2c2: isub
      // 2c3: aload 13
      // 2c5: iload 24
      // 2c7: bipush 1
      // 2c8: isub
      // 2c9: iaload
      // 2ca: ldc 878108687
      // 2cc: ldc 875110384
      // 2ce: ixor
      // 2cf: iand
      // 2d0: iastore
      // 2d1: iload 5
      // 2d3: ifeq 305
      // 2d6: goto 2da
      // 2d9: athrow
      // 2da: iload 9
      // 2dc: iload 5
      // 2de: ifne 307
      // 2e1: ldc 875110386
      // 2e3: ldc 875110384
      // 2e5: ixor
      // 2e6: if_icmpne 305
      // 2e9: goto 2ed
      // 2ec: athrow
      // 2ed: aload 13
      // 2ef: iload 24
      // 2f1: bipush 1
      // 2f2: isub
      // 2f3: aload 13
      // 2f5: iload 24
      // 2f7: bipush 1
      // 2f8: isub
      // 2f9: iaload
      // 2fa: ldc 873914383
      // 2fc: ldc 875110384
      // 2fe: ixor
      // 2ff: iand
      // 300: iastore
      // 301: goto 305
      // 304: athrow
      // 305: iload 26
      // 307: iload 5
      // 309: ifne 33d
      // 30c: ldc 875110386
      // 30e: ldc 875110384
      // 310: ixor
      // 311: if_icmpne 339
      // 314: goto 318
      // 317: athrow
      // 318: dload 20
      // 31a: dload 27
      // 31c: dsub
      // 31d: iload 5
      // 31f: ifne 33b
      // 322: goto 326
      // 325: athrow
      // 326: dstore 27
      // 328: iload 32
      // 32a: ifeq 339
      // 32d: dload 27
      // 32f: dload 20
      // 331: iload 9
      // 333: invokestatic x/oc15a3bceb4a.ѷ (DI)D
      // 336: dsub
      // 337: dstore 27
      // 339: dload 27
      // 33b: dconst_0
      // 33c: dcmpl
      // 33d: iload 5
      // 33f: ifne 357
      // 342: ifeq 352
      // 345: goto 349
      // 348: athrow
      // 349: iload 5
      // 34b: ifeq 3fb
      // 34e: goto 352
      // 351: athrow
      // 352: bipush 0
      // 353: goto 357
      // 356: athrow
      // 357: istore 32
      // 359: iload 24
      // 35b: bipush 1
      // 35c: isub
      // 35d: istore 33
      // 35f: iload 33
      // 361: iload 6
      // 363: if_icmplt 37d
      // 366: iload 32
      // 368: aload 13
      // 36a: iload 33
      // 36c: iaload
      // 36d: iload 5
      // 36f: ifne 3b6
      // 372: ior
      // 373: istore 32
      // 375: iload 5
      // 377: iinc 33 -1
      // 37a: ifeq 35f
      // 37d: iload 32
      // 37f: iload 5
      // 381: ifne 399
      // 384: ifeq 394
      // 387: goto 38b
      // 38a: athrow
      // 38b: iload 5
      // 38d: ifeq 3fb
      // 390: goto 394
      // 393: athrow
      // 394: bipush 1
      // 395: goto 399
      // 398: athrow
      // 399: istore 33
      // 39b: aload 13
      // 39d: iload 6
      // 39f: iload 33
      // 3a1: isub
      // 3a2: iaload
      // 3a3: ifne 3b3
      // 3a6: iload 5
      // 3a8: ifne 125
      // 3ab: iinc 33 1
      // 3ae: iload 5
      // 3b0: ifeq 39b
      // 3b3: iload 24
      // 3b5: bipush 1
      // 3b6: iadd
      // 3b7: istore 34
      // 3b9: iload 34
      // 3bb: iload 24
      // 3bd: iload 33
      // 3bf: iadd
      // 3c0: if_icmpgt 3ef
      // 3c3: aload 10
      // 3c5: iload 7
      // 3c7: iload 34
      // 3c9: iadd
      // 3ca: iload 8
      // 3cc: iload 34
      // 3ce: iadd
      // 3cf: invokestatic x/ocbc6b8beaac.ҹ (I)D
      // 3d2: dastore
      // 3d3: aload 11
      // 3d5: iload 34
      // 3d7: iload 5
      // 3d9: ifne 11f
      // 3dc: aload 0
      // 3dd: aload 10
      // 3df: iload 7
      // 3e1: iload 34
      // 3e3: invokestatic x/ocbc6b8beaac.ņ ([D[DII)D
      // 3e6: dastore
      // 3e7: iload 5
      // 3e9: iinc 34 1
      // 3ec: ifeq 3b9
      // 3ef: iload 24
      // 3f1: iload 33
      // 3f3: iadd
      // 3f4: istore 24
      // 3f6: iload 5
      // 3f8: ifeq 11b
      // 3fb: dload 27
      // 3fd: iload 5
      // 3ff: ifne 434
      // 402: dconst_0
      // 403: dcmpl
      // 404: ifne 428
      // 407: goto 40b
      // 40a: athrow
      // 40b: iinc 24 -1
      // 40e: iinc 9 -24
      // 411: goto 415
      // 414: athrow
      // 415: aload 13
      // 417: iload 24
      // 419: iaload
      // 41a: ifne 47f
      // 41d: iinc 24 -1
      // 420: iload 5
      // 422: iinc 9 -24
      // 425: ifeq 415
      // 428: dload 27
      // 42a: iload 9
      // 42c: ineg
      // 42d: invokestatic x/oc15a3bceb4a.ѷ (DI)D
      // 430: dstore 27
      // 432: dload 27
      // 434: dload 16
      // 436: iload 5
      // 438: ifne 44b
      // 43b: dcmpg
      // 43c: iflt 475
      // 43f: goto 443
      // 442: athrow
      // 443: dload 27
      // 445: dload 14
      // 447: goto 44b
      // 44a: athrow
      // 44b: dmul
      // 44c: invokestatic x/oc30e402796f.ϒ (D)I
      // 44f: i2d
      // 450: dstore 29
      // 452: aload 13
      // 454: iload 24
      // 456: dload 29
      // 458: dload 18
      // 45a: dmul
      // 45b: dload 27
      // 45d: dadd
      // 45e: invokestatic x/oc30e402796f.ϒ (D)I
      // 461: iastore
      // 462: iinc 24 1
      // 465: iinc 9 24
      // 468: aload 13
      // 46a: iload 24
      // 46c: dload 29
      // 46e: invokestatic x/oc30e402796f.ϒ (D)I
      // 471: iastore
      // 472: goto 47f
      // 475: aload 13
      // 477: iload 24
      // 479: dload 27
      // 47b: invokestatic x/oc30e402796f.ϒ (D)I
      // 47e: iastore
      // 47f: dload 20
      // 481: iload 9
      // 483: invokestatic x/oc15a3bceb4a.ѷ (DI)D
      // 486: dstore 29
      // 488: iload 24
      // 48a: istore 31
      // 48c: iload 31
      // 48e: iflt 4b7
      // 491: aload 11
      // 493: iload 31
      // 495: dload 29
      // 497: aload 13
      // 499: iload 31
      // 49b: iaload
      // 49c: i2d
      // 49d: dmul
      // 49e: dastore
      // 49f: iload 5
      // 4a1: dload 29
      // 4a3: dload 14
      // 4a5: dmul
      // 4a6: dstore 29
      // 4a8: ifne 4bb
      // 4ab: iinc 31 -1
      // 4ae: iload 5
      // 4b0: ifeq 48c
      // 4b3: goto 4b7
      // 4b6: athrow
      // 4b7: iload 24
      // 4b9: istore 31
      // 4bb: iload 31
      // 4bd: iflt 51a
      // 4c0: iload 5
      // 4c2: ifne 5ba
      // 4c5: dconst_0
      // 4c6: dstore 32
      // 4c8: bipush 0
      // 4c9: istore 34
      // 4cb: iload 34
      // 4cd: iload 6
      // 4cf: if_icmpgt 508
      // 4d2: iload 34
      // 4d4: iload 5
      // 4d6: ifne 4bd
      // 4d9: iload 24
      // 4db: iload 31
      // 4dd: isub
      // 4de: if_icmpgt 508
      // 4e1: dload 32
      // 4e3: ldc 872595696
      // 4e5: ldc 875110384
      // 4e7: ixor
      // 4e8: ldc 875110392
      // 4ea: ldc 875110384
      // 4ec: ixor
      // 4ed: iload 34
      // 4ef: imul
      // 4f0: iadd
      // 4f1: invokestatic x/ocbc6b8beaac.ƭ (I)D
      // 4f4: aload 11
      // 4f6: iload 31
      // 4f8: iload 34
      // 4fa: iadd
      // 4fb: daload
      // 4fc: dmul
      // 4fd: dadd
      // 4fe: dstore 32
      // 500: iload 5
      // 502: iinc 34 1
      // 505: ifeq 4cb
      // 508: aload 12
      // 50a: iload 24
      // 50c: iload 31
      // 50e: isub
      // 50f: dload 32
      // 511: dastore
      // 512: iload 5
      // 514: iinc 31 -1
      // 517: ifeq 4bb
      // 51a: iload 4
      // 51c: iload 5
      // 51e: ifne 5bc
      // 521: ldc 875110387
      // 523: ldc 875110384
      // 525: ixor
      // 526: if_icmpge 5ba
      // 529: goto 52d
      // 52c: athrow
      // 52d: dconst_0
      // 52e: dstore 31
      // 530: iload 24
      // 532: istore 33
      // 534: iload 33
      // 536: iflt 554
      // 539: dload 31
      // 53b: aload 12
      // 53d: iload 33
      // 53f: daload
      // 540: dadd
      // 541: dstore 31
      // 543: iload 5
      // 545: ifne 567
      // 548: iinc 33 -1
      // 54b: iload 5
      // 54d: ifeq 534
      // 550: goto 554
      // 553: athrow
      // 554: aload 1
      // 555: iload 5
      // 557: ifne 581
      // 55a: bipush 0
      // 55b: dload 31
      // 55d: iload 26
      // 55f: invokestatic x/ocbc6b8beaac.Ӄ (DI)D
      // 562: dastore
      // 563: goto 567
      // 566: athrow
      // 567: iload 4
      // 569: bipush 1
      // 56a: if_icmpeq 57b
      // 56d: iload 4
      // 56f: ldc 875110386
      // 571: ldc 875110384
      // 573: ixor
      // 574: if_icmpne 5b7
      // 577: goto 57b
      // 57a: athrow
      // 57b: aload 12
      // 57d: goto 581
      // 580: athrow
      // 581: bipush 0
      // 582: daload
      // 583: dload 31
      // 585: dsub
      // 586: dstore 33
      // 588: bipush 1
      // 589: istore 35
      // 58b: iload 35
      // 58d: iload 24
      // 58f: if_icmpgt 5ad
      // 592: dload 33
      // 594: aload 12
      // 596: iload 35
      // 598: daload
      // 599: dadd
      // 59a: dstore 33
      // 59c: iload 5
      // 59e: ifne 5b7
      // 5a1: iinc 35 1
      // 5a4: iload 5
      // 5a6: ifeq 58b
      // 5a9: goto 5ad
      // 5ac: athrow
      // 5ad: aload 1
      // 5ae: bipush 1
      // 5af: dload 33
      // 5b1: iload 26
      // 5b3: invokestatic x/ocbc6b8beaac.Ӄ (DI)D
      // 5b6: dastore
      // 5b7: goto 67b
      // 5ba: iload 4
      // 5bc: iload 5
      // 5be: ifne 683
      // 5c1: ldc 875110387
      // 5c3: ldc 875110384
      // 5c5: ixor
      // 5c6: if_icmpne 67b
      // 5c9: goto 5cd
      // 5cc: athrow
      // 5cd: bipush 0
      // 5ce: istore 31
      // 5d0: iload 31
      // 5d2: ldc 875110386
      // 5d4: ldc 875110384
      // 5d6: ixor
      // 5d7: if_icmpge 629
      // 5da: iload 5
      // 5dc: ifne 67b
      // 5df: iload 24
      // 5e1: istore 32
      // 5e3: iload 32
      // 5e5: iload 31
      // 5e7: if_icmple 621
      // 5ea: aload 12
      // 5ec: iload 32
      // 5ee: bipush 1
      // 5ef: isub
      // 5f0: daload
      // 5f1: iload 5
      // 5f3: ifne 62a
      // 5f6: aload 12
      // 5f8: iload 32
      // 5fa: daload
      // 5fb: dadd
      // 5fc: dstore 33
      // 5fe: iload 5
      // 600: aload 12
      // 602: iload 32
      // 604: dup2
      // 605: daload
      // 606: aload 12
      // 608: iload 32
      // 60a: bipush 1
      // 60b: isub
      // 60c: daload
      // 60d: dload 33
      // 60f: dsub
      // 610: dadd
      // 611: dastore
      // 612: aload 12
      // 614: iload 32
      // 616: bipush 1
      // 617: isub
      // 618: dload 33
      // 61a: dastore
      // 61b: iinc 32 -1
      // 61e: ifeq 5e3
      // 621: iinc 31 1
      // 624: iload 5
      // 626: ifeq 5d0
      // 629: dconst_0
      // 62a: dstore 31
      // 62c: iload 24
      // 62e: istore 33
      // 630: iload 33
      // 632: ldc 875110386
      // 634: ldc 875110384
      // 636: ixor
      // 637: if_icmplt 655
      // 63a: dload 31
      // 63c: aload 12
      // 63e: iload 33
      // 640: daload
      // 641: dadd
      // 642: dstore 31
      // 644: iload 5
      // 646: ifne 66d
      // 649: iinc 33 -1
      // 64c: iload 5
      // 64e: ifeq 630
      // 651: goto 655
      // 654: athrow
      // 655: aload 1
      // 656: bipush 0
      // 657: aload 12
      // 659: bipush 0
      // 65a: daload
      // 65b: iload 26
      // 65d: invokestatic x/ocbc6b8beaac.Ӄ (DI)D
      // 660: dastore
      // 661: aload 1
      // 662: bipush 1
      // 663: aload 12
      // 665: bipush 1
      // 666: daload
      // 667: iload 26
      // 669: invokestatic x/ocbc6b8beaac.Ӄ (DI)D
      // 66c: dastore
      // 66d: aload 1
      // 66e: ldc 875110386
      // 670: ldc 875110384
      // 672: ixor
      // 673: dload 31
      // 675: iload 26
      // 677: invokestatic x/ocbc6b8beaac.Ӄ (DI)D
      // 67a: dastore
      // 67b: iload 25
      // 67d: ldc 875110391
      // 67f: ldc 875110384
      // 681: ixor
      // 682: iand
      // 683: ireturn
   }
}
