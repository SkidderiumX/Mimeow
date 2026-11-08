package x;

public class ocf130f74f2a {
   public static boolean ʡ;

   private ocf130f74f2a() {
   }

   private static double U(int var0) {
      return ocd857d42ebe.Ҝ(var0);
   }

   private static int ԋ(double var0) {
      return (int)(Double.doubleToRawLongBits(var0) >>> (1325083125 ^ 1325083073) & (5963976334965571543L ^ 5963976334965569576L));
   }

   private static double Ҋ(double var0, int var2) {
      return Double.longBitsToDouble(Double.doubleToRawLongBits(var0) ^ ocd857d42ebe.h(var2));
   }

   private static void ɍ(double var0, double[] var2, int var3, int var4) {
      double var5 = var0 + U(var3);
      double var7 = U(var4);
      var2[0] = var5 + var7;
      var2[1] = var5 - var2[0] + var7;
   }

   public static int Ȭ(double param0, double[] param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc01be0c7606.ź I
      // 003: dload 0
      // 004: invokestatic java/lang/Double.doubleToRawLongBits (D)J
      // 007: lstore 4
      // 009: lload 4
      // 00b: ldc 226696581
      // 00d: ldc 226696613
      // 00f: ixor
      // 010: lushr
      // 011: l2i
      // 012: ldc 1920787034
      // 014: ldc 226696613
      // 016: ixor
      // 017: iand
      // 018: istore 6
      // 01a: istore 3
      // 01b: lload 4
      // 01d: lconst_0
      // 01e: lcmp
      // 01f: iload 3
      // 020: ifne 02b
      // 023: ifge 02e
      // 026: goto 02a
      // 029: athrow
      // 02a: bipush 1
      // 02b: goto 02f
      // 02e: bipush 0
      // 02f: istore 7
      // 031: bipush 0
      // 032: istore 8
      // 034: iload 6
      // 036: iload 3
      // 037: ifne 11d
      // 03a: ldc 1301051359
      // 03c: ldc 226696613
      // 03e: ixor
      // 03f: if_icmpgt 11b
      // 042: goto 046
      // 045: athrow
      // 046: lload 4
      // 048: ldc 226696581
      // 04a: ldc 226696613
      // 04c: ixor
      // 04d: lushr
      // 04e: l2i
      // 04f: iload 3
      // 050: ifne 34d
      // 053: goto 057
      // 056: athrow
      // 057: ldc 227336794
      // 059: ldc 226696613
      // 05b: ixor
      // 05c: iand
      // 05d: ldc 227163230
      // 05f: ldc 226696613
      // 061: ixor
      // 062: if_icmpeq 348
      // 065: goto 069
      // 068: athrow
      // 069: iload 6
      // 06b: ldc 1300350169
      // 06d: ldc 226696613
      // 06f: ixor
      // 070: if_icmpgt 0c7
      // 073: goto 077
      // 076: athrow
      // 077: dload 0
      // 078: aload 2
      // 079: iload 7
      // 07b: iload 3
      // 07c: ifne 08f
      // 07f: goto 083
      // 082: athrow
      // 083: ifeq 092
      // 086: goto 08a
      // 089: athrow
      // 08a: ldc 229157637
      // 08c: ldc 226696613
      // 08e: ixor
      // 08f: goto 097
      // 092: ldc 229156941
      // 094: ldc 226696613
      // 096: ixor
      // 097: iload 7
      // 099: iload 3
      // 09a: ifne 0a9
      // 09d: ifeq 0ac
      // 0a0: goto 0a4
      // 0a3: athrow
      // 0a4: ldc 229156949
      // 0a6: ldc 226696613
      // 0a8: ixor
      // 0a9: goto 0b1
      // 0ac: ldc 229157693
      // 0ae: ldc 226696613
      // 0b0: ixor
      // 0b1: invokestatic x/ocf130f74f2a.ɍ (D[DII)V
      // 0b4: iload 7
      // 0b6: iload 3
      // 0b7: ifne 0c2
      // 0ba: ifeq 0c5
      // 0bd: goto 0c1
      // 0c0: athrow
      // 0c1: bipush -1
      // 0c2: goto 0c6
      // 0c5: bipush 1
      // 0c6: ireturn
      // 0c7: dload 0
      // 0c8: aload 2
      // 0c9: iload 7
      // 0cb: iload 3
      // 0cc: ifne 0db
      // 0cf: ifeq 0de
      // 0d2: goto 0d6
      // 0d5: athrow
      // 0d6: ldc 229157677
      // 0d8: ldc 226696613
      // 0da: ixor
      // 0db: goto 0e3
      // 0de: ldc 229157853
      // 0e0: ldc 226696613
      // 0e2: ixor
      // 0e3: iload 7
      // 0e5: iload 3
      // 0e6: ifne 0f5
      // 0e9: ifeq 0f8
      // 0ec: goto 0f0
      // 0ef: athrow
      // 0f0: ldc 229157685
      // 0f2: ldc 226696613
      // 0f4: ixor
      // 0f5: goto 0fd
      // 0f8: ldc 229157669
      // 0fa: ldc 226696613
      // 0fc: ixor
      // 0fd: invokestatic x/ocf130f74f2a.ɍ (D[DII)V
      // 100: iload 7
      // 102: iload 3
      // 103: ifne 112
      // 106: ifeq 115
      // 109: goto 10d
      // 10c: athrow
      // 10d: ldc -226696613
      // 10f: ldc 226696613
      // 111: ixor
      // 112: goto 11a
      // 115: ldc 226696615
      // 117: ldc 226696613
      // 119: ixor
      // 11a: ireturn
      // 11b: iload 6
      // 11d: iload 3
      // 11e: ifne 228
      // 121: ldc 1302289305
      // 123: ldc 226696613
      // 125: ixor
      // 126: if_icmpge 222
      // 129: goto 12d
      // 12c: athrow
      // 12d: iload 6
      // 12f: iload 3
      // 130: ifne 1b3
      // 133: goto 137
      // 136: athrow
      // 137: ldc 1301733400
      // 139: ldc 226696613
      // 13b: ixor
      // 13c: if_icmpge 1b1
      // 13f: goto 143
      // 142: athrow
      // 143: iload 6
      // 145: iload 3
      // 146: ifne 21c
      // 149: goto 14d
      // 14c: athrow
      // 14d: ldc 1301398745
      // 14f: ldc 226696613
      // 151: ixor
      // 152: if_icmpeq 21b
      // 155: goto 159
      // 158: athrow
      // 159: dload 0
      // 15a: aload 2
      // 15b: iload 7
      // 15d: iload 3
      // 15e: ifne 171
      // 161: goto 165
      // 164: athrow
      // 165: ifeq 174
      // 168: goto 16c
      // 16b: athrow
      // 16c: ldc 229157837
      // 16e: ldc 226696613
      // 170: ixor
      // 171: goto 179
      // 174: ldc 229157885
      // 176: ldc 226696613
      // 178: ixor
      // 179: iload 7
      // 17b: iload 3
      // 17c: ifne 18b
      // 17f: ifeq 18e
      // 182: goto 186
      // 185: athrow
      // 186: ldc 229157845
      // 188: ldc 226696613
      // 18a: ixor
      // 18b: goto 193
      // 18e: ldc 229157829
      // 190: ldc 226696613
      // 192: ixor
      // 193: invokestatic x/ocf130f74f2a.ɍ (D[DII)V
      // 196: iload 7
      // 198: iload 3
      // 199: ifne 1a8
      // 19c: ifeq 1ab
      // 19f: goto 1a3
      // 1a2: athrow
      // 1a3: ldc -226696616
      // 1a5: ldc 226696613
      // 1a7: ixor
      // 1a8: goto 1b0
      // 1ab: ldc 226696614
      // 1ad: ldc 226696613
      // 1af: ixor
      // 1b0: ireturn
      // 1b1: iload 6
      // 1b3: iload 3
      // 1b4: ifne 21c
      // 1b7: ldc 1301953630
      // 1b9: ldc 226696613
      // 1bb: ixor
      // 1bc: if_icmpeq 21b
      // 1bf: goto 1c3
      // 1c2: athrow
      // 1c3: dload 0
      // 1c4: aload 2
      // 1c5: iload 7
      // 1c7: iload 3
      // 1c8: ifne 1db
      // 1cb: goto 1cf
      // 1ce: athrow
      // 1cf: ifeq 1de
      // 1d2: goto 1d6
      // 1d5: athrow
      // 1d6: ldc 229157869
      // 1d8: ldc 226696613
      // 1da: ixor
      // 1db: goto 1e3
      // 1de: ldc 229157789
      // 1e0: ldc 226696613
      // 1e2: ixor
      // 1e3: iload 7
      // 1e5: iload 3
      // 1e6: ifne 1f5
      // 1e9: ifeq 1f8
      // 1ec: goto 1f0
      // 1ef: athrow
      // 1f0: ldc 229157877
      // 1f2: ldc 226696613
      // 1f4: ixor
      // 1f5: goto 1fd
      // 1f8: ldc 229157861
      // 1fa: ldc 226696613
      // 1fc: ixor
      // 1fd: invokestatic x/ocf130f74f2a.ɍ (D[DII)V
      // 200: iload 7
      // 202: iload 3
      // 203: ifne 212
      // 206: ifeq 215
      // 209: goto 20d
      // 20c: athrow
      // 20d: ldc -226696615
      // 20f: ldc 226696613
      // 211: ixor
      // 212: goto 21a
      // 215: ldc 226696609
      // 217: ldc 226696613
      // 219: ixor
      // 21a: ireturn
      // 21b: bipush 1
      // 21c: istore 8
      // 21e: iload 3
      // 21f: ifeq 348
      // 222: iload 6
      // 224: goto 228
      // 227: athrow
      // 228: iload 3
      // 229: ifne 34d
      // 22c: ldc 1287273566
      // 22e: ldc 226696613
      // 230: ixor
      // 231: if_icmplt 348
      // 234: goto 238
      // 237: athrow
      // 238: iload 6
      // 23a: iload 3
      // 23b: ifne 260
      // 23e: goto 242
      // 241: athrow
      // 242: ldc 1920146853
      // 244: ldc 226696613
      // 246: ixor
      // 247: if_icmplt 261
      // 24a: goto 24e
      // 24d: athrow
      // 24e: aload 2
      // 24f: bipush 0
      // 250: dload 0
      // 251: invokestatic x/oc15a3bceb4a.ҕ (D)D
      // 254: dastore
      // 255: aload 2
      // 256: bipush 1
      // 257: aload 2
      // 258: bipush 0
      // 259: daload
      // 25a: dastore
      // 25b: bipush 0
      // 25c: goto 260
      // 25f: athrow
      // 260: ireturn
      // 261: lload 4
      // 263: ldc2_w -1500214591984853779
      // 266: ldc2_w -1503686359471267054
      // 269: lxor
      // 26a: land
      // 26b: ldc2_w -6178422772681841902
      // 26e: ldc2_w -1503686359471267054
      // 271: lxor
      // 272: lor
      // 273: invokestatic java/lang/Double.longBitsToDouble (J)D
      // 276: dstore 9
      // 278: ldc 226696614
      // 27a: ldc 226696613
      // 27c: ixor
      // 27d: newarray 7
      // 27f: dup
      // 280: bipush 0
      // 281: dload 9
      // 283: invokestatic x/oc30e402796f.ϒ (D)I
      // 286: i2d
      // 287: dastore
      // 288: dup
      // 289: bipush 1
      // 28a: dconst_0
      // 28b: dastore
      // 28c: dup
      // 28d: ldc 226696615
      // 28f: ldc 226696613
      // 291: ixor
      // 292: dconst_0
      // 293: dastore
      // 294: astore 11
      // 296: dload 9
      // 298: aload 11
      // 29a: bipush 0
      // 29b: daload
      // 29c: dsub
      // 29d: ldc 229156885
      // 29f: ldc 226696613
      // 2a1: ixor
      // 2a2: invokestatic x/ocf130f74f2a.U (I)D
      // 2a5: dmul
      // 2a6: dstore 12
      // 2a8: aload 11
      // 2aa: bipush 1
      // 2ab: dload 12
      // 2ad: invokestatic x/oc30e402796f.ϒ (D)I
      // 2b0: i2d
      // 2b1: dastore
      // 2b2: aload 11
      // 2b4: ldc 226696615
      // 2b6: ldc 226696613
      // 2b8: ixor
      // 2b9: dload 12
      // 2bb: aload 11
      // 2bd: bipush 1
      // 2be: daload
      // 2bf: dsub
      // 2c0: ldc 229156885
      // 2c2: ldc 226696613
      // 2c4: ixor
      // 2c5: invokestatic x/ocf130f74f2a.U (I)D
      // 2c8: dmul
      // 2c9: dastore
      // 2ca: ldc 226696614
      // 2cc: ldc 226696613
      // 2ce: ixor
      // 2cf: istore 14
      // 2d1: aload 11
      // 2d3: iload 14
      // 2d5: bipush 1
      // 2d6: isub
      // 2d7: daload
      // 2d8: dconst_0
      // 2d9: dcmpl
      // 2da: ifne 2e4
      // 2dd: iinc 14 -1
      // 2e0: iload 3
      // 2e1: ifeq 2d1
      // 2e4: ldc 226696615
      // 2e6: ldc 226696613
      // 2e8: ixor
      // 2e9: newarray 7
      // 2eb: astore 15
      // 2ed: iload 3
      // 2ee: aload 11
      // 2f0: aload 15
      // 2f2: iload 6
      // 2f4: ldc 226696625
      // 2f6: ldc 226696613
      // 2f8: ixor
      // 2f9: iushr
      // 2fa: ldc 226695603
      // 2fc: ldc 226696613
      // 2fe: ixor
      // 2ff: isub
      // 300: iload 14
      // 302: bipush 1
      // 303: invokestatic x/ocbc6b8beaac.ӌ ([D[DIII)I
      // 306: istore 16
      // 308: ifne 345
      // 30b: iload 7
      // 30d: ifeq 337
      // 310: goto 314
      // 313: athrow
      // 314: aload 2
      // 315: bipush 0
      // 316: aload 15
      // 318: bipush 0
      // 319: daload
      // 31a: ldc 229156965
      // 31c: ldc 226696613
      // 31e: ixor
      // 31f: invokestatic x/ocf130f74f2a.Ҋ (DI)D
      // 322: dastore
      // 323: aload 2
      // 324: bipush 1
      // 325: aload 15
      // 327: bipush 1
      // 328: daload
      // 329: ldc 229156973
      // 32b: ldc 226696613
      // 32d: ixor
      // 32e: invokestatic x/ocf130f74f2a.Ҋ (DI)D
      // 331: dastore
      // 332: iload 16
      // 334: ineg
      // 335: ireturn
      // 336: athrow
      // 337: aload 2
      // 338: bipush 0
      // 339: aload 15
      // 33b: bipush 0
      // 33c: daload
      // 33d: dastore
      // 33e: aload 2
      // 33f: bipush 1
      // 340: aload 15
      // 342: bipush 1
      // 343: daload
      // 344: dastore
      // 345: iload 16
      // 347: ireturn
      // 348: ldc 229156981
      // 34a: ldc 226696613
      // 34c: ixor
      // 34d: invokestatic x/ocf130f74f2a.U (I)D
      // 350: dload 0
      // 351: dmul
      // 352: dstore 9
      // 354: dload 9
      // 356: ldc 229156989
      // 358: ldc 226696613
      // 35a: ixor
      // 35b: invokestatic x/ocf130f74f2a.U (I)D
      // 35e: dadd
      // 35f: dstore 9
      // 361: dload 9
      // 363: ldc 229156933
      // 365: ldc 226696613
      // 367: ixor
      // 368: invokestatic x/ocf130f74f2a.U (I)D
      // 36b: dadd
      // 36c: dstore 9
      // 36e: dload 9
      // 370: invokestatic x/oc30e402796f.ϒ (D)I
      // 373: istore 11
      // 375: ldc 229156941
      // 377: ldc 226696613
      // 379: ixor
      // 37a: invokestatic x/ocf130f74f2a.U (I)D
      // 37d: dload 9
      // 37f: dmul
      // 380: dload 0
      // 381: dadd
      // 382: dstore 12
      // 384: ldc 229156949
      // 386: ldc 226696613
      // 388: ixor
      // 389: invokestatic x/ocf130f74f2a.U (I)D
      // 38c: dload 9
      // 38e: dmul
      // 38f: dstore 14
      // 391: dload 12
      // 393: dload 14
      // 395: dsub
      // 396: dstore 16
      // 398: bipush 0
      // 399: istore 18
      // 39b: ldc 229156957
      // 39d: ldc 226696613
      // 39f: ixor
      // 3a0: iload 3
      // 3a1: ifne 3d7
      // 3a4: invokestatic x/ocf130f74f2a.U (I)D
      // 3a7: dload 16
      // 3a9: dcmpl
      // 3aa: ifle 3c8
      // 3ad: goto 3b1
      // 3b0: athrow
      // 3b1: iinc 11 -1
      // 3b4: iload 3
      // 3b5: dload 9
      // 3b7: ldc 229157813
      // 3b9: ldc 226696613
      // 3bb: ixor
      // 3bc: invokestatic x/ocf130f74f2a.U (I)D
      // 3bf: dadd
      // 3c0: dstore 9
      // 3c2: bipush 1
      // 3c3: istore 18
      // 3c5: ifeq 3f5
      // 3c8: dload 16
      // 3ca: ldc 229157797
      // 3cc: ldc 226696613
      // 3ce: ixor
      // 3cf: invokestatic x/ocf130f74f2a.U (I)D
      // 3d2: dcmpl
      // 3d3: goto 3d7
      // 3d6: athrow
      // 3d7: iload 3
      // 3d8: ifne 3f7
      // 3db: ifle 3f5
      // 3de: goto 3e2
      // 3e1: athrow
      // 3e2: iinc 11 1
      // 3e5: dload 9
      // 3e7: ldc 229157805
      // 3e9: ldc 226696613
      // 3eb: ixor
      // 3ec: invokestatic x/ocf130f74f2a.U (I)D
      // 3ef: dadd
      // 3f0: dstore 9
      // 3f2: bipush 1
      // 3f3: istore 18
      // 3f5: iload 18
      // 3f7: iload 3
      // 3f8: ifne 42e
      // 3fb: ifeq 41e
      // 3fe: goto 402
      // 401: athrow
      // 402: dload 0
      // 403: ldc 229156941
      // 405: ldc 226696613
      // 407: ixor
      // 408: invokestatic x/ocf130f74f2a.U (I)D
      // 40b: dload 9
      // 40d: dmul
      // 40e: dadd
      // 40f: dstore 12
      // 411: ldc 229156949
      // 413: ldc 226696613
      // 415: ixor
      // 416: invokestatic x/ocf130f74f2a.U (I)D
      // 419: dload 9
      // 41b: dmul
      // 41c: dstore 14
      // 41e: aload 2
      // 41f: bipush 0
      // 420: dload 12
      // 422: dload 14
      // 424: dsub
      // 425: dastore
      // 426: iload 6
      // 428: ldc 226696625
      // 42a: ldc 226696613
      // 42c: ixor
      // 42d: iushr
      // 42e: istore 19
      // 430: iload 8
      // 432: iload 3
      // 433: ifne 471
      // 436: ifeq 460
      // 439: goto 43d
      // 43c: athrow
      // 43d: aload 2
      // 43e: bipush 0
      // 43f: daload
      // 440: invokestatic x/ocf130f74f2a.ԋ (D)I
      // 443: iload 3
      // 444: ifne 45d
      // 447: goto 44b
      // 44a: athrow
      // 44b: ldc 226696788
      // 44d: ldc 226696613
      // 44f: ixor
      // 450: if_icmpge 45c
      // 453: goto 457
      // 456: athrow
      // 457: bipush 1
      // 458: goto 482
      // 45b: athrow
      // 45c: bipush 0
      // 45d: goto 482
      // 460: iload 19
      // 462: iload 3
      // 463: ifne 47e
      // 466: aload 2
      // 467: bipush 0
      // 468: daload
      // 469: invokestatic x/ocf130f74f2a.ԋ (D)I
      // 46c: isub
      // 46d: goto 471
      // 470: athrow
      // 471: ldc 226696629
      // 473: ldc 226696613
      // 475: ixor
      // 476: if_icmple 481
      // 479: bipush 1
      // 47a: goto 47e
      // 47d: athrow
      // 47e: goto 482
      // 481: bipush 0
      // 482: istore 20
      // 484: iload 3
      // 485: ifne 577
      // 488: iload 20
      // 48a: ifeq 56b
      // 48d: goto 491
      // 490: athrow
      // 491: ldc 229157821
      // 493: ldc 226696613
      // 495: ixor
      // 496: invokestatic x/ocf130f74f2a.U (I)D
      // 499: dload 9
      // 49b: dmul
      // 49c: dstore 21
      // 49e: dload 12
      // 4a0: dload 21
      // 4a2: dsub
      // 4a3: dstore 23
      // 4a5: ldc 229157765
      // 4a7: ldc 226696613
      // 4a9: ixor
      // 4aa: iload 3
      // 4ab: ifne 511
      // 4ae: invokestatic x/ocf130f74f2a.U (I)D
      // 4b1: dload 9
      // 4b3: dmul
      // 4b4: dload 12
      // 4b6: dload 23
      // 4b8: dsub
      // 4b9: dload 21
      // 4bb: dsub
      // 4bc: dsub
      // 4bd: dstore 14
      // 4bf: aload 2
      // 4c0: bipush 0
      // 4c1: dload 23
      // 4c3: dload 14
      // 4c5: dsub
      // 4c6: dastore
      // 4c7: iload 8
      // 4c9: ifeq 500
      // 4cc: aload 2
      // 4cd: bipush 0
      // 4ce: daload
      // 4cf: invokestatic java/lang/Double.doubleToRawLongBits (D)J
      // 4d2: ldc 226696605
      // 4d4: ldc 226696613
      // 4d6: ixor
      // 4d7: lushr
      // 4d8: ldc2_w -1503686359471266963
      // 4db: ldc2_w -1503686359471267054
      // 4de: lxor
      // 4df: land
      // 4e0: ldc2_w -1503686359471267026
      // 4e3: ldc2_w -1503686359471267054
      // 4e6: lxor
      // 4e7: lcmp
      // 4e8: iload 3
      // 4e9: ifne 4fd
      // 4ec: goto 4f0
      // 4ef: athrow
      // 4f0: ifgt 4fc
      // 4f3: goto 4f7
      // 4f6: athrow
      // 4f7: bipush 1
      // 4f8: goto 522
      // 4fb: athrow
      // 4fc: bipush 0
      // 4fd: goto 522
      // 500: iload 19
      // 502: iload 3
      // 503: ifne 51e
      // 506: aload 2
      // 507: bipush 0
      // 508: daload
      // 509: invokestatic x/ocf130f74f2a.ԋ (D)I
      // 50c: isub
      // 50d: goto 511
      // 510: athrow
      // 511: ldc 226696599
      // 513: ldc 226696613
      // 515: ixor
      // 516: if_icmplt 521
      // 519: bipush 1
      // 51a: goto 51e
      // 51d: athrow
      // 51e: goto 522
      // 521: bipush 0
      // 522: istore 25
      // 524: iload 3
      // 525: dload 23
      // 527: dstore 12
      // 529: ifne 577
      // 52c: iload 25
      // 52e: ifeq 56b
      // 531: goto 535
      // 534: athrow
      // 535: ldc 229157773
      // 537: ldc 226696613
      // 539: ixor
      // 53a: invokestatic x/ocf130f74f2a.U (I)D
      // 53d: dload 9
      // 53f: dmul
      // 540: dstore 26
      // 542: dload 23
      // 544: dload 26
      // 546: dsub
      // 547: dstore 28
      // 549: dload 9
      // 54b: ldc 229157781
      // 54d: ldc 226696613
      // 54f: ixor
      // 550: invokestatic x/ocf130f74f2a.U (I)D
      // 553: dmul
      // 554: dload 23
      // 556: dload 28
      // 558: dsub
      // 559: dload 26
      // 55b: dsub
      // 55c: dsub
      // 55d: dstore 14
      // 55f: dload 28
      // 561: dstore 12
      // 563: aload 2
      // 564: bipush 0
      // 565: dload 28
      // 567: dload 14
      // 569: dsub
      // 56a: dastore
      // 56b: aload 2
      // 56c: bipush 1
      // 56d: dload 12
      // 56f: aload 2
      // 570: bipush 0
      // 571: daload
      // 572: dsub
      // 573: dload 14
      // 575: dsub
      // 576: dastore
      // 577: iload 11
      // 579: ireturn
   }

   private static double Ŧ(double var0, double var2) {
      double var4 = var0 * var0;
      double var6 = var4 * var4;
      double var8 = U(-1200188867 ^ -1201853203) * var4 + U(-1200188875 ^ -1201853203);
      double var10 = U(-1200188915 ^ -1201853203) * var4 + U(-1200188899 ^ -1201853203);
      double var12 = var8 * var4 + U(-1200188907 ^ -1201853203);
      var6 *= var4;
      var6 *= var10;
      double var14 = var12 + var6;
      double var16 = var0 * var4;
      double var18 = U(-1200188835 ^ -1201853203) * var2;
      var14 *= var16;
      var18 -= var14;
      var18 *= var4;
      var18 -= var2;
      var16 *= U(-1200188435 ^ -1201853203);
      var16 += var18;
      return var0 - var16;
   }

   private static double Չ(double var0, double var2) {
      double var4 = var0 * var0;
      double var6 = var4 * var4;
      double var8 = U(876604335 ^ 873747935) * var4;
      double var10 = U(876604327 ^ 873747935) * var4;
      double var12 = U(876604255 ^ 873747935) + var8;
      double var14 = U(876604231 ^ 873747935) - var10;
      var12 = var12 * var4 + U(876604287 ^ 873747935);
      var14 = var14 * var4 + U(876604279 ^ 873747935);
      var6 *= var6;
      double var16 = var4 * var12;
      double var18 = var6 * var14;
      double var20 = var18 + var16;
      double var22 = U(876604271 ^ 873747935) * var4;
      double var24 = U(876604263 ^ 873747935);
      double var26 = var24 - var22;
      double var28 = var24 - var26 - var22;
      var20 *= var4;
      var0 *= var2;
      var20 -= var0;
      var20 += var28;
      return var20 + var26;
   }

   public static double σ(double param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc01be0c7606.ź I
      // 003: dload 0
      // 004: invokestatic java/lang/Double.doubleToRawLongBits (D)J
      // 007: ldc -1702376249
      // 009: ldc -1702376217
      // 00b: ixor
      // 00c: lushr
      // 00d: l2i
      // 00e: ldc -445107432
      // 010: ldc -1702376217
      // 012: ixor
      // 013: iand
      // 014: istore 3
      // 015: istore 2
      // 016: iload 3
      // 017: iload 2
      // 018: ifne 0bb
      // 01b: ldc -1519456996
      // 01d: ldc -1702376217
      // 01f: ixor
      // 020: if_icmpgt 0ba
      // 023: goto 027
      // 026: athrow
      // 027: iload 3
      // 028: ldc -1529361177
      // 02a: ldc -1702376217
      // 02c: ixor
      // 02d: if_icmpge 037
      // 030: goto 034
      // 033: athrow
      // 034: dload 0
      // 035: dreturn
      // 036: athrow
      // 037: dload 0
      // 038: dload 0
      // 039: dmul
      // 03a: dstore 4
      // 03c: dload 4
      // 03e: dload 4
      // 040: dmul
      // 041: dload 4
      // 043: dmul
      // 044: dstore 6
      // 046: dload 4
      // 048: ldc -1699974153
      // 04a: ldc -1702376217
      // 04c: ixor
      // 04d: invokestatic x/ocf130f74f2a.U (I)D
      // 050: dmul
      // 051: ldc -1699974201
      // 053: ldc -1702376217
      // 055: ixor
      // 056: invokestatic x/ocf130f74f2a.U (I)D
      // 059: dadd
      // 05a: dstore 8
      // 05c: dload 4
      // 05e: ldc -1699974145
      // 060: ldc -1702376217
      // 062: ixor
      // 063: invokestatic x/ocf130f74f2a.U (I)D
      // 066: dmul
      // 067: ldc -1699974193
      // 069: ldc -1702376217
      // 06b: ixor
      // 06c: invokestatic x/ocf130f74f2a.U (I)D
      // 06f: dadd
      // 070: dstore 10
      // 072: dload 6
      // 074: dload 8
      // 076: dmul
      // 077: dstore 12
      // 079: dload 4
      // 07b: dload 10
      // 07d: dmul
      // 07e: dstore 14
      // 080: dload 14
      // 082: ldc -1699974185
      // 084: ldc -1702376217
      // 086: ixor
      // 087: invokestatic x/ocf130f74f2a.U (I)D
      // 08a: dadd
      // 08b: dstore 16
      // 08d: dload 16
      // 08f: dload 12
      // 091: dadd
      // 092: dstore 16
      // 094: dload 0
      // 095: dload 4
      // 097: dmul
      // 098: dstore 18
      // 09a: dload 16
      // 09c: dload 4
      // 09e: dmul
      // 09f: dstore 16
      // 0a1: dload 16
      // 0a3: ldc -1699974177
      // 0a5: ldc -1702376217
      // 0a7: ixor
      // 0a8: invokestatic x/ocf130f74f2a.U (I)D
      // 0ab: dadd
      // 0ac: dstore 16
      // 0ae: dload 16
      // 0b0: dload 18
      // 0b2: dmul
      // 0b3: dstore 16
      // 0b5: dload 0
      // 0b6: dload 16
      // 0b8: dadd
      // 0b9: dreturn
      // 0ba: iload 3
      // 0bb: iload 2
      // 0bc: ifne 0d6
      // 0bf: ldc -446156008
      // 0c1: ldc -1702376217
      // 0c3: ixor
      // 0c4: if_icmple 0d1
      // 0c7: goto 0cb
      // 0ca: athrow
      // 0cb: dload 0
      // 0cc: invokestatic x/oc15a3bceb4a.ҕ (D)D
      // 0cf: dreturn
      // 0d0: athrow
      // 0d1: ldc -1702376219
      // 0d3: ldc -1702376217
      // 0d5: ixor
      // 0d6: newarray 7
      // 0d8: astore 4
      // 0da: dload 0
      // 0db: aload 4
      // 0dd: invokestatic x/ocf130f74f2a.Ȭ (D[D)I
      // 0e0: ldc -1702376220
      // 0e2: ldc -1702376217
      // 0e4: ixor
      // 0e5: iand
      // 0e6: istore 5
      // 0e8: iload 5
      // 0ea: bipush 1
      // 0eb: iand
      // 0ec: ifne 117
      // 0ef: aload 4
      // 0f1: bipush 0
      // 0f2: daload
      // 0f3: aload 4
      // 0f5: bipush 1
      // 0f6: daload
      // 0f7: invokestatic x/ocf130f74f2a.Ŧ (DD)D
      // 0fa: dstore 6
      // 0fc: iload 5
      // 0fe: ldc -1702376219
      // 100: ldc -1702376217
      // 102: ixor
      // 103: if_icmpne 114
      // 106: dload 6
      // 108: ldc -1699974617
      // 10a: ldc -1702376217
      // 10c: ixor
      // 10d: invokestatic x/ocf130f74f2a.Ҋ (DI)D
      // 110: goto 116
      // 113: athrow
      // 114: dload 6
      // 116: dreturn
      // 117: aload 4
      // 119: bipush 0
      // 11a: daload
      // 11b: aload 4
      // 11d: bipush 1
      // 11e: daload
      // 11f: invokestatic x/ocf130f74f2a.Չ (DD)D
      // 122: dstore 6
      // 124: iload 5
      // 126: ldc -1702376220
      // 128: ldc -1702376217
      // 12a: ixor
      // 12b: if_icmpne 13c
      // 12e: dload 6
      // 130: ldc -1699974617
      // 132: ldc -1702376217
      // 134: ixor
      // 135: invokestatic x/ocf130f74f2a.Ҋ (DI)D
      // 138: goto 13e
      // 13b: athrow
      // 13c: dload 6
      // 13e: dreturn
   }
}
