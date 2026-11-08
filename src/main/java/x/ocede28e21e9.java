package x;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.play.server.S25PacketBlockBreakAnim;
import net.minecraft.util.Vec3;

public class ocede28e21e9 {
   Block ġ;
   int e;
   int v;
   int ϧ;
   int Ҧ;
   int Ū;
   int ѽ;
   int è;
   int ƫ;
   int C;
   int ų;
   int ķ;
   int ʖ;
   int Ǭ;
   int ɗ;
   int Н;
   int ԕ;
   int Լ;
   int Ȧ;
   int Ę;
   int Ӭ;
   int ǿ;
   int Ѹ;
   boolean փ;
   boolean Ѿ;
   double պ;
   double Ǆ;
   double с;
   double ƕ;
   Vec3 ǔ;
   final oc8c951938d3 this$0;

   ocede28e21e9(oc8c951938d3 var1) {
      this.this$0 = var1;
      this.ɗ = -1;
   }

   void ւ(EntityPlayer param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc89eb238246.ħ I
      // 003: aload 1
      // 004: getfield net/minecraft/entity/player/EntityPlayer.ticksExisted I
      // 007: istore 3
      // 008: istore 2
      // 009: aload 0
      // 00a: aload 1
      // 00b: invokevirtual x/ocede28e21e9.ր (Lnet/minecraft/entity/player/EntityPlayer;)V
      // 00e: iload 2
      // 00f: aload 0
      // 010: getfield x/ocede28e21e9.this$0 Lx/oc8c951938d3;
      // 013: getfield x/oc8c951938d3.â Lnet/minecraft/util/BlockPos$MutableBlockPos;
      // 016: aload 1
      // 017: getfield net/minecraft/entity/player/EntityPlayer.posX D
      // 01a: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 01d: aload 1
      // 01e: getfield net/minecraft/entity/player/EntityPlayer.posY D
      // 021: dconst_1
      // 022: dsub
      // 023: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 026: aload 1
      // 027: getfield net/minecraft/entity/player/EntityPlayer.posZ D
      // 02a: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 02d: invokevirtual net/minecraft/util/BlockPos$MutableBlockPos.set (III)Lnet/minecraft/util/BlockPos$MutableBlockPos;
      // 030: pop
      // 031: aload 0
      // 032: aload 0
      // 033: getfield x/ocede28e21e9.this$0 Lx/oc8c951938d3;
      // 036: getfield x/oc8c951938d3.â Lnet/minecraft/util/BlockPos$MutableBlockPos;
      // 039: invokestatic x/occb1ed1ed8f.ϛ (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/Block;
      // 03c: putfield x/ocede28e21e9.ġ Lnet/minecraft/block/Block;
      // 03f: ifne 0a1
      // 042: aload 0
      // 043: aload 0
      // 044: getfield x/ocede28e21e9.Ǆ D
      // 047: invokestatic java/lang/Math.abs (D)D
      // 04a: aload 0
      // 04b: getfield x/ocede28e21e9.ƕ D
      // 04e: invokestatic java/lang/Math.abs (D)D
      // 051: invokestatic java/lang/Math.max (DD)D
      // 054: putfield x/ocede28e21e9.պ D
      // 057: aload 0
      // 058: getfield x/ocede28e21e9.պ D
      // 05b: dconst_0
      // 05c: dcmpl
      // 05d: ifne 09c
      // 060: goto 064
      // 063: athrow
      // 064: aload 0
      // 065: iload 2
      // 066: ifne 0a2
      // 069: goto 06d
      // 06c: athrow
      // 06d: getfield x/ocede28e21e9.с D
      // 070: dconst_0
      // 071: dcmpl
      // 072: ifne 09c
      // 075: goto 079
      // 078: athrow
      // 079: aload 0
      // 07a: dup
      // 07b: getfield x/ocede28e21e9.ѽ I
      // 07e: bipush 1
      // 07f: iadd
      // 080: putfield x/ocede28e21e9.ѽ I
      // 083: iload 2
      // 084: ifeq 0a6
      // 087: goto 08b
      // 08a: athrow
      // 08b: bipush 0
      // 08c: ifeq 098
      // 08f: goto 093
      // 092: athrow
      // 093: bipush 0
      // 094: goto 099
      // 097: athrow
      // 098: bipush 1
      // 099: putstatic x/oc69da1aa7f5.Ҭ Z
      // 09c: aload 0
      // 09d: bipush 0
      // 09e: putfield x/ocede28e21e9.ѽ I
      // 0a1: aload 0
      // 0a2: iload 3
      // 0a3: putfield x/ocede28e21e9.Ҧ I
      // 0a6: aload 0
      // 0a7: iload 2
      // 0a8: ifne 0d5
      // 0ab: getfield x/ocede28e21e9.պ D
      // 0ae: ldc2_w 0.07
      // 0b1: dcmpl
      // 0b2: iflt 0d0
      // 0b5: goto 0b9
      // 0b8: athrow
      // 0b9: aload 0
      // 0ba: dup
      // 0bb: getfield x/ocede28e21e9.Ѹ I
      // 0be: bipush 1
      // 0bf: iadd
      // 0c0: putfield x/ocede28e21e9.Ѹ I
      // 0c3: iload 2
      // 0c4: aload 0
      // 0c5: iload 3
      // 0c6: putfield x/ocede28e21e9.Ȧ I
      // 0c9: ifeq 0d9
      // 0cc: goto 0d0
      // 0cf: athrow
      // 0d0: aload 0
      // 0d1: goto 0d5
      // 0d4: athrow
      // 0d5: bipush 0
      // 0d6: putfield x/ocede28e21e9.Ѹ I
      // 0d9: aload 0
      // 0da: iload 2
      // 0db: ifne 0f9
      // 0de: getfield x/ocede28e21e9.с D
      // 0e1: invokestatic java/lang/Math.abs (D)D
      // 0e4: ldc2_w 0.1
      // 0e7: dcmpl
      // 0e8: iflt 0f8
      // 0eb: goto 0ef
      // 0ee: athrow
      // 0ef: aload 0
      // 0f0: iload 3
      // 0f1: putfield x/ocede28e21e9.ʖ I
      // 0f4: goto 0f8
      // 0f7: athrow
      // 0f8: aload 0
      // 0f9: aload 0
      // 0fa: iload 2
      // 0fb: ifne 10f
      // 0fe: getfield x/ocede28e21e9.с D
      // 101: dconst_0
      // 102: dcmpg
      // 103: ifge 132
      // 106: goto 10a
      // 109: athrow
      // 10a: aload 0
      // 10b: goto 10f
      // 10e: athrow
      // 10f: iload 2
      // 110: ifne 125
      // 113: getfield x/ocede28e21e9.ġ Lnet/minecraft/block/Block;
      // 116: getstatic net/minecraft/init/Blocks.air Lnet/minecraft/block/Block;
      // 119: if_acmpne 132
      // 11c: goto 120
      // 11f: athrow
      // 120: aload 0
      // 121: goto 125
      // 124: athrow
      // 125: dup
      // 126: getfield x/ocede28e21e9.Ӭ I
      // 129: bipush 1
      // 12a: iadd
      // 12b: dup_x1
      // 12c: putfield x/ocede28e21e9.Ӭ I
      // 12f: goto 133
      // 132: bipush 0
      // 133: putfield x/ocede28e21e9.Ӭ I
      // 136: aload 1
      // 137: iload 2
      // 138: ifne 14f
      // 13b: invokevirtual net/minecraft/entity/player/EntityPlayer.isSneaking ()Z
      // 13e: ifeq 14e
      // 141: goto 145
      // 144: athrow
      // 145: aload 0
      // 146: iload 3
      // 147: putfield x/ocede28e21e9.Н I
      // 14a: goto 14e
      // 14d: athrow
      // 14e: aload 1
      // 14f: iload 2
      // 150: ifne 16c
      // 153: getfield net/minecraft/entity/player/EntityPlayer.rotationPitch F
      // 156: aload 1
      // 157: getfield net/minecraft/entity/player/EntityPlayer.prevRotationPitch F
      // 15a: fcmpl
      // 15b: ifeq 16b
      // 15e: goto 162
      // 161: athrow
      // 162: aload 0
      // 163: iload 3
      // 164: putfield x/ocede28e21e9.v I
      // 167: goto 16b
      // 16a: athrow
      // 16b: aload 1
      // 16c: invokevirtual net/minecraft/entity/player/EntityPlayer.isUsingItem ()Z
      // 16f: iload 2
      // 170: ifne 18a
      // 173: ifne 196
      // 176: goto 17a
      // 179: athrow
      // 17a: aload 0
      // 17b: iload 2
      // 17c: ifne 197
      // 17f: goto 183
      // 182: athrow
      // 183: getfield x/ocede28e21e9.փ Z
      // 186: goto 18a
      // 189: athrow
      // 18a: ifeq 196
      // 18d: aload 0
      // 18e: iload 3
      // 18f: putfield x/ocede28e21e9.ų I
      // 192: goto 196
      // 195: athrow
      // 196: aload 0
      // 197: aload 1
      // 198: getfield net/minecraft/entity/player/EntityPlayer.rotationYaw F
      // 19b: aload 1
      // 19c: getfield net/minecraft/entity/player/EntityPlayer.prevRotationYaw F
      // 19f: fsub
      // 1a0: invokestatic java/lang/Math.abs (F)F
      // 1a3: fconst_1
      // 1a4: fcmpl
      // 1a5: iload 2
      // 1a6: ifne 1bf
      // 1a9: iflt 1c2
      // 1ac: goto 1b0
      // 1af: athrow
      // 1b0: aload 0
      // 1b1: dup
      // 1b2: getfield x/ocede28e21e9.Ū I
      // 1b5: bipush 1
      // 1b6: iadd
      // 1b7: dup_x1
      // 1b8: putfield x/ocede28e21e9.Ū I
      // 1bb: goto 1bf
      // 1be: athrow
      // 1bf: goto 1c3
      // 1c2: bipush 0
      // 1c3: putfield x/ocede28e21e9.Ū I
      // 1c6: aload 0
      // 1c7: aload 1
      // 1c8: iload 2
      // 1c9: ifne 1db
      // 1cc: getfield net/minecraft/entity/player/EntityPlayer.isSwingInProgress Z
      // 1cf: ifeq 1fb
      // 1d2: goto 1d6
      // 1d5: athrow
      // 1d6: aload 1
      // 1d7: goto 1db
      // 1da: athrow
      // 1db: invokevirtual net/minecraft/entity/player/EntityPlayer.isBlocking ()Z
      // 1de: iload 2
      // 1df: ifne 1f8
      // 1e2: ifeq 1fb
      // 1e5: goto 1e9
      // 1e8: athrow
      // 1e9: aload 0
      // 1ea: dup
      // 1eb: getfield x/ocede28e21e9.ԕ I
      // 1ee: bipush 1
      // 1ef: iadd
      // 1f0: dup_x1
      // 1f1: putfield x/ocede28e21e9.ԕ I
      // 1f4: goto 1f8
      // 1f7: athrow
      // 1f8: goto 1fc
      // 1fb: bipush 0
      // 1fc: putfield x/ocede28e21e9.ԕ I
      // 1ff: aload 0
      // 200: aload 1
      // 201: invokevirtual net/minecraft/entity/player/EntityPlayer.isSprinting ()Z
      // 204: iload 2
      // 205: ifne 21e
      // 208: ifeq 221
      // 20b: goto 20f
      // 20e: athrow
      // 20f: aload 0
      // 210: dup
      // 211: getfield x/ocede28e21e9.è I
      // 214: bipush 1
      // 215: iadd
      // 216: dup_x1
      // 217: putfield x/ocede28e21e9.è I
      // 21a: goto 21e
      // 21d: athrow
      // 21e: goto 222
      // 221: bipush 0
      // 222: putfield x/ocede28e21e9.è I
      // 225: aload 0
      // 226: aload 1
      // 227: iload 2
      // 228: ifne 23a
      // 22b: invokevirtual net/minecraft/entity/player/EntityPlayer.isSprinting ()Z
      // 22e: ifeq 280
      // 231: goto 235
      // 234: athrow
      // 235: aload 1
      // 236: goto 23a
      // 239: athrow
      // 23a: iload 2
      // 23b: ifne 24d
      // 23e: invokevirtual net/minecraft/entity/player/EntityPlayer.isUsingItem ()Z
      // 241: ifeq 280
      // 244: goto 248
      // 247: athrow
      // 248: aload 1
      // 249: goto 24d
      // 24c: athrow
      // 24d: iload 2
      // 24e: ifne 260
      // 251: invokevirtual net/minecraft/entity/player/EntityPlayer.isRiding ()Z
      // 254: ifne 280
      // 257: goto 25b
      // 25a: athrow
      // 25b: aload 1
      // 25c: goto 260
      // 25f: athrow
      // 260: invokevirtual net/minecraft/entity/player/EntityPlayer.isInWater ()Z
      // 263: iload 2
      // 264: ifne 27d
      // 267: ifne 280
      // 26a: goto 26e
      // 26d: athrow
      // 26e: aload 0
      // 26f: dup
      // 270: getfield x/ocede28e21e9.Լ I
      // 273: bipush 1
      // 274: iadd
      // 275: dup_x1
      // 276: putfield x/ocede28e21e9.Լ I
      // 279: goto 27d
      // 27c: athrow
      // 27d: goto 281
      // 280: bipush 0
      // 281: putfield x/ocede28e21e9.Լ I
      // 284: iload 2
      // 285: ifne 34c
      // 288: aload 1
      // 289: getfield net/minecraft/entity/player/EntityPlayer.isSwingInProgress Z
      // 28c: ifeq 343
      // 28f: goto 293
      // 292: athrow
      // 293: aload 1
      // 294: getfield net/minecraft/entity/player/EntityPlayer.rotationPitch F
      // 297: ldc 65.0
      // 299: fcmpl
      // 29a: iload 2
      // 29b: ifne 2c0
      // 29e: goto 2a2
      // 2a1: athrow
      // 2a2: iflt 343
      // 2a5: goto 2a9
      // 2a8: athrow
      // 2a9: aload 0
      // 2aa: iload 2
      // 2ab: ifne 34d
      // 2ae: goto 2b2
      // 2b1: athrow
      // 2b2: getfield x/ocede28e21e9.this$0 Lx/oc8c951938d3;
      // 2b5: aload 1
      // 2b6: invokevirtual net/minecraft/entity/player/EntityPlayer.getHeldItem ()Lnet/minecraft/item/ItemStack;
      // 2b9: invokevirtual x/oc8c951938d3.Ѣ (Lnet/minecraft/item/ItemStack;)Z
      // 2bc: goto 2c0
      // 2bf: athrow
      // 2c0: ifeq 343
      // 2c3: aload 0
      // 2c4: aload 0
      // 2c5: iload 2
      // 2c6: ifne 2e1
      // 2c9: goto 2cd
      // 2cc: athrow
      // 2cd: getfield x/ocede28e21e9.Ѹ I
      // 2d0: ldc -1565368380
      // 2d2: ldc -1565368373
      // 2d4: ixor
      // 2d5: if_icmplt 2ee
      // 2d8: goto 2dc
      // 2db: athrow
      // 2dc: aload 0
      // 2dd: goto 2e1
      // 2e0: athrow
      // 2e1: dup
      // 2e2: getfield x/ocede28e21e9.ǿ I
      // 2e5: bipush 1
      // 2e6: iadd
      // 2e7: dup_x1
      // 2e8: putfield x/ocede28e21e9.ǿ I
      // 2eb: goto 2ef
      // 2ee: bipush 0
      // 2ef: putfield x/ocede28e21e9.ǿ I
      // 2f2: aload 1
      // 2f3: iload 2
      // 2f4: ifne 352
      // 2f7: getfield net/minecraft/entity/player/EntityPlayer.swingProgressInt I
      // 2fa: bipush 1
      // 2fb: if_icmpne 351
      // 2fe: goto 302
      // 301: athrow
      // 302: aload 0
      // 303: aload 0
      // 304: getfield x/ocede28e21e9.Ѿ Z
      // 307: iload 2
      // 308: ifne 31e
      // 30b: goto 30f
      // 30e: athrow
      // 30f: ifne 33b
      // 312: goto 316
      // 315: athrow
      // 316: aload 1
      // 317: invokevirtual net/minecraft/entity/player/EntityPlayer.isSneaking ()Z
      // 31a: goto 31e
      // 31d: athrow
      // 31e: iload 2
      // 31f: ifne 338
      // 322: ifeq 33b
      // 325: goto 329
      // 328: athrow
      // 329: aload 0
      // 32a: dup
      // 32b: getfield x/ocede28e21e9.Ę I
      // 32e: bipush 1
      // 32f: iadd
      // 330: dup_x1
      // 331: putfield x/ocede28e21e9.Ę I
      // 334: goto 338
      // 337: athrow
      // 338: goto 33c
      // 33b: bipush 0
      // 33c: putfield x/ocede28e21e9.Ę I
      // 33f: iload 2
      // 340: ifeq 351
      // 343: aload 0
      // 344: bipush 0
      // 345: putfield x/ocede28e21e9.Ę I
      // 348: goto 34c
      // 34b: athrow
      // 34c: aload 0
      // 34d: bipush 0
      // 34e: putfield x/ocede28e21e9.ǿ I
      // 351: aload 1
      // 352: getfield net/minecraft/entity/player/EntityPlayer.isSwingInProgress Z
      // 355: iload 2
      // 356: ifne 368
      // 359: ifeq 3ca
      // 35c: goto 360
      // 35f: athrow
      // 360: aload 0
      // 361: getfield x/ocede28e21e9.ɗ I
      // 364: goto 368
      // 367: athrow
      // 368: iload 2
      // 369: ifne 394
      // 36c: bipush -1
      // 36d: if_icmpeq 38c
      // 370: goto 374
      // 373: athrow
      // 374: aload 0
      // 375: iload 2
      // 376: ifne 3cf
      // 379: goto 37d
      // 37c: athrow
      // 37d: getfield x/ocede28e21e9.ɗ I
      // 380: ldc -1565368524
      // 382: ldc -1565368373
      // 384: ixor
      // 385: if_icmpne 3ca
      // 388: goto 38c
      // 38b: athrow
      // 38c: aload 1
      // 38d: getfield net/minecraft/entity/player/EntityPlayer.swingProgressInt I
      // 390: goto 394
      // 393: athrow
      // 394: ifne 3d3
      // 397: aload 0
      // 398: aload 0
      // 399: iload 2
      // 39a: ifne 3b5
      // 39d: goto 3a1
      // 3a0: athrow
      // 3a1: getfield x/ocede28e21e9.ϧ I
      // 3a4: ldc -1565368376
      // 3a6: ldc -1565368373
      // 3a8: ixor
      // 3a9: if_icmpne 3c2
      // 3ac: goto 3b0
      // 3af: athrow
      // 3b0: aload 0
      // 3b1: goto 3b5
      // 3b4: athrow
      // 3b5: dup
      // 3b6: getfield x/ocede28e21e9.e I
      // 3b9: bipush 1
      // 3ba: iadd
      // 3bb: dup_x1
      // 3bc: putfield x/ocede28e21e9.e I
      // 3bf: goto 3c3
      // 3c2: bipush 0
      // 3c3: putfield x/ocede28e21e9.e I
      // 3c6: iload 2
      // 3c7: ifeq 3d3
      // 3ca: aload 0
      // 3cb: goto 3cf
      // 3ce: athrow
      // 3cf: bipush 0
      // 3d0: putfield x/ocede28e21e9.e I
      // 3d3: aload 0
      // 3d4: aload 1
      // 3d5: iload 2
      // 3d6: ifne 3e8
      // 3d9: invokevirtual net/minecraft/entity/player/EntityPlayer.isSneaking ()Z
      // 3dc: ifne 462
      // 3df: goto 3e3
      // 3e2: athrow
      // 3e3: aload 1
      // 3e4: goto 3e8
      // 3e7: athrow
      // 3e8: getfield net/minecraft/entity/player/EntityPlayer.isSwingInProgress Z
      // 3eb: iload 2
      // 3ec: ifne 408
      // 3ef: ifne 462
      // 3f2: goto 3f6
      // 3f5: athrow
      // 3f6: aload 0
      // 3f7: getfield x/ocede28e21e9.պ D
      // 3fa: iload 2
      // 3fb: ifne 413
      // 3fe: goto 402
      // 401: athrow
      // 402: dconst_0
      // 403: dcmpl
      // 404: goto 408
      // 407: athrow
      // 408: ifne 462
      // 40b: aload 0
      // 40c: getfield x/ocede28e21e9.с D
      // 40f: goto 413
      // 412: athrow
      // 413: dconst_0
      // 414: dcmpl
      // 415: iload 2
      // 416: ifne 435
      // 419: ifne 462
      // 41c: goto 420
      // 41f: athrow
      // 420: aload 1
      // 421: getfield net/minecraft/entity/player/EntityPlayer.rotationYaw F
      // 424: aload 1
      // 425: iload 2
      // 426: ifne 441
      // 429: goto 42d
      // 42c: athrow
      // 42d: getfield net/minecraft/entity/player/EntityPlayer.prevRotationYaw F
      // 430: fcmpl
      // 431: goto 435
      // 434: athrow
      // 435: ifne 462
      // 438: aload 1
      // 439: getfield net/minecraft/entity/player/EntityPlayer.rotationPitch F
      // 43c: aload 1
      // 43d: goto 441
      // 440: athrow
      // 441: getfield net/minecraft/entity/player/EntityPlayer.prevRotationPitch F
      // 444: fcmpl
      // 445: iload 2
      // 446: ifne 45f
      // 449: ifne 462
      // 44c: goto 450
      // 44f: athrow
      // 450: aload 0
      // 451: dup
      // 452: getfield x/ocede28e21e9.Ǭ I
      // 455: bipush 1
      // 456: iadd
      // 457: dup_x1
      // 458: putfield x/ocede28e21e9.Ǭ I
      // 45b: goto 45f
      // 45e: athrow
      // 45f: goto 463
      // 462: bipush 0
      // 463: putfield x/ocede28e21e9.Ǭ I
      // 466: return
   }

   void ϫ(EntityPlayer var1) {
      this.ƫ = this.ѽ;
      this.C = this.è;
      this.ķ = this.Ӭ;
      this.Ѿ = var1.isSneaking();
      this.ϧ = var1.swingProgressInt;
      this.փ = var1.isUsingItem();
   }

   void ү(EntityPlayer param1, S25PacketBlockBreakAnim param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc89eb238246.ħ I
      // 03: aload 0
      // 04: aload 2
      // 05: invokevirtual net/minecraft/network/play/server/S25PacketBlockBreakAnim.getProgress ()I
      // 08: putfield x/ocede28e21e9.ɗ I
      // 0b: istore 3
      // 0c: aload 0
      // 0d: iload 3
      // 0e: ifne 33
      // 11: getfield x/ocede28e21e9.this$0 Lx/oc8c951938d3;
      // 14: getstatic x/oc89eb238246.ʩ Lx/oc89eb238246;
      // 17: invokevirtual x/oc8c951938d3.ʒ (Lx/oc89eb238246;)Z
      // 1a: ifeq 84
      // 1d: goto 21
      // 20: athrow
      // 21: aload 0
      // 22: getfield x/ocede28e21e9.this$0 Lx/oc8c951938d3;
      // 25: getfield x/oc8c951938d3.Ƅ Ljava/util/HashMap;
      // 28: aload 1
      // 29: invokevirtual net/minecraft/entity/player/EntityPlayer.getUniqueID ()Ljava/util/UUID;
      // 2c: invokevirtual java/util/HashMap.get (Ljava/lang/Object;)Ljava/lang/Object;
      // 2f: goto 33
      // 32: athrow
      // 33: checkcast net/minecraft/network/play/server/S25PacketBlockBreakAnim
      // 36: astore 4
      // 38: aload 4
      // 3a: iload 3
      // 3b: ifne 83
      // 3e: ifnull 74
      // 41: goto 45
      // 44: athrow
      // 45: aload 2
      // 46: iload 3
      // 47: ifne 83
      // 4a: goto 4e
      // 4d: athrow
      // 4e: invokevirtual net/minecraft/network/play/server/S25PacketBlockBreakAnim.getProgress ()I
      // 51: ldc_w -183033063
      // 54: ldc_w -183032858
      // 57: ixor
      // 58: if_icmpne 74
      // 5b: goto 5f
      // 5e: athrow
      // 5f: aload 0
      // 60: getfield x/ocede28e21e9.this$0 Lx/oc8c951938d3;
      // 63: getfield x/oc8c951938d3.ƃ Ljava/util/HashMap;
      // 66: aload 2
      // 67: invokevirtual net/minecraft/network/play/server/S25PacketBlockBreakAnim.getPosition ()Lnet/minecraft/util/BlockPos;
      // 6a: aload 4
      // 6c: invokevirtual java/util/HashMap.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      // 6f: pop
      // 70: goto 74
      // 73: athrow
      // 74: aload 0
      // 75: getfield x/ocede28e21e9.this$0 Lx/oc8c951938d3;
      // 78: getfield x/oc8c951938d3.Ƅ Ljava/util/HashMap;
      // 7b: aload 1
      // 7c: invokevirtual net/minecraft/entity/player/EntityPlayer.getUniqueID ()Ljava/util/UUID;
      // 7f: aload 2
      // 80: invokevirtual java/util/HashMap.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      // 83: pop
      // 84: return
   }

   void ր(EntityPlayer var1) {
      this.Ǆ = var1.posX - var1.lastTickPosX;
      this.с = var1.posY - var1.lastTickPosY;
      this.ƕ = var1.posZ - var1.lastTickPosZ;
   }
}
