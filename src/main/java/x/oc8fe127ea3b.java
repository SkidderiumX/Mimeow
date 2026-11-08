package x;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import net.minecraft.util.Vec3;

public class oc8fe127ea3b {
   private final Deque<oc9f8d7423cd> Ĩ;
   private final List<oc66f33bb961> ӯ;
   private final double ɲ;
   private final boolean ʷ;
   private final double ǭ;
   private final int Z;
   private final double Ҏ;
   private final double ԝ;
   private Vec3 а;
   private Vec3 Ғ;
   private Vec3 Τ;
   private double Ы;
   private double ʏ;
   private int ň;
   private int ƛ;
   final ocdb10538f60 this$0;

   private oc8fe127ea3b(ocdb10538f60 var1, Vec3 var2, boolean var3) {
      this.this$0 = var1;
      this.Ĩ = new ArrayDeque<>();
      this.ӯ = new ArrayList<>();
      this.ɲ = this.this$0.Ɏ.nextDouble() * Math.PI * 2.0;
      this.Τ = new Vec3(0.0, 0.0, 0.0);
      this.Ы = this.this$0.Ɏ.nextDouble() * Math.PI * 2.0;
      this.ʏ = this.Ы;
      this.а = var2;
      this.Ғ = var2;
      this.ʷ = var3;
      this.ǭ = var3 ? 0.2 + var1.Ɏ.nextDouble() * 0.1 : 0.13 + var1.Ɏ.nextDouble() * 0.07;
      this.Z = var3 ? (1604389876 ^ 1604389752) + var1.Ɏ.nextInt(1604389701 ^ 1604389752) : (1604389848 ^ 1604389752) + var1.Ɏ.nextInt(1604389673 ^ 1604389752);
      this.Ҏ = var3 ? 0.09 + var1.Ɏ.nextDouble() * 0.09 : 0.035 + var1.Ɏ.nextDouble() * 0.035;
      this.ԝ = (var1.Ɏ.nextDouble() - 0.4) * 0.09;
      this.ň = (1604389748 ^ 1604389752) + var1.Ɏ.nextInt(1604389739 ^ 1604389752);
   }

   private float Ȼ(float var1, Vec3 var2) {
      float var3 = this.ƛ + var1;
      double var4 = var3 / 20.0;

      double var10000;
      double var10001;
      double var10002;
      double var10003;
      label45: {
         try {
            var10000 = 0.5;
            var10001 = 0.5;
            var10002 = var4;
            if (this.ʷ) {
               var10003 = 0.9;
               break label45;
            }
         } catch (ocbde1165e4e var12) {
            throw var12;
         }

         var10003 = 2.3;
      }

      double var6 = var10000 + var10001 * Math.sin(var10002 * var10003 + this.ɲ);
      float var8 = (float)Math.sqrt(this.а.squareDistanceTo(var2));

      label37: {
         try {
            if (this.ʷ) {
               var13 = ocdb10538f60.ä(var3 / 24.0F) * ocdb10538f60.ä((this.Z - var3) / 36.0F);
               break label37;
            }
         } catch (ocbde1165e4e var11) {
            throw var11;
         }

         var13 = ocdb10538f60.с(var3, this.Z);
      }

      float var9 = var13;

      try {
         var14 = var9;
         if (this.ʷ) {
            return var9 * (float)(0.65 + 0.35 * var6) * ocdb10538f60.ä((var8 - 0.35F) / 1.1F) * ocdb10538f60.ä((32.0F - var8) / 6.0F);
         }
      } catch (ocbde1165e4e var10) {
         throw var10;
      }

      return var14 * (float)(0.35 + 0.65 * var6 * var6) * ocdb10538f60.ä((var8 - 0.35F) / 1.1F) * ocdb10538f60.ä((32.0F - var8) / 6.0F);
   }

   private void К() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oce6044968f8.ђ Z
      // 003: aload 0
      // 004: aload 0
      // 005: getfield x/oc8fe127ea3b.а Lnet/minecraft/util/Vec3;
      // 008: putfield x/oc8fe127ea3b.Ғ Lnet/minecraft/util/Vec3;
      // 00b: istore 1
      // 00c: aload 0
      // 00d: dup
      // 00e: getfield x/oc8fe127ea3b.ƛ I
      // 011: bipush 1
      // 012: iadd
      // 013: putfield x/oc8fe127ea3b.ƛ I
      // 016: iload 1
      // 017: aload 0
      // 018: getfield x/oc8fe127ea3b.ƛ I
      // 01b: i2d
      // 01c: ldc2_w 20.0
      // 01f: ddiv
      // 020: dstore 2
      // 021: aload 0
      // 022: getfield x/oc8fe127ea3b.Ҏ D
      // 025: aload 0
      // 026: getfield x/oc8fe127ea3b.this$0 Lx/ocdb10538f60;
      // 029: getfield x/ocdb10538f60.Ӑ Lx/oca9cc61aada;
      // 02c: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 02f: dmul
      // 030: dstore 4
      // 032: ifne 129
      // 035: aload 0
      // 036: getfield x/oc8fe127ea3b.ʷ Z
      // 039: ifeq 10b
      // 03c: goto 040
      // 03f: athrow
      // 040: aload 0
      // 041: iload 1
      // 042: ifne 099
      // 045: goto 049
      // 048: athrow
      // 049: getfield x/oc8fe127ea3b.ƛ I
      // 04c: aload 0
      // 04d: getfield x/oc8fe127ea3b.ň I
      // 050: if_icmplt 098
      // 053: goto 057
      // 056: athrow
      // 057: aload 0
      // 058: aload 0
      // 059: getfield x/oc8fe127ea3b.Ы D
      // 05c: aload 0
      // 05d: getfield x/oc8fe127ea3b.this$0 Lx/ocdb10538f60;
      // 060: getfield x/ocdb10538f60.Ɏ Ljava/util/Random;
      // 063: invokevirtual java/util/Random.nextDouble ()D
      // 066: ldc2_w 0.5
      // 069: dsub
      // 06a: ldc2_w 3.141592653589793
      // 06d: dmul
      // 06e: ldc2_w 1.6
      // 071: dmul
      // 072: dadd
      // 073: putfield x/oc8fe127ea3b.ʏ D
      // 076: aload 0
      // 077: aload 0
      // 078: getfield x/oc8fe127ea3b.ƛ I
      // 07b: ldc -1369096337
      // 07d: ldc -1369096349
      // 07f: ixor
      // 080: iadd
      // 081: aload 0
      // 082: getfield x/oc8fe127ea3b.this$0 Lx/ocdb10538f60;
      // 085: getfield x/ocdb10538f60.Ɏ Ljava/util/Random;
      // 088: ldc -1369096336
      // 08a: ldc -1369096349
      // 08c: ixor
      // 08d: invokevirtual java/util/Random.nextInt (I)I
      // 090: iadd
      // 091: putfield x/oc8fe127ea3b.ň I
      // 094: goto 098
      // 097: athrow
      // 098: aload 0
      // 099: getfield x/oc8fe127ea3b.ʏ D
      // 09c: aload 0
      // 09d: getfield x/oc8fe127ea3b.Ы D
      // 0a0: dsub
      // 0a1: invokestatic java/lang/Math.sin (D)D
      // 0a4: aload 0
      // 0a5: getfield x/oc8fe127ea3b.ʏ D
      // 0a8: aload 0
      // 0a9: getfield x/oc8fe127ea3b.Ы D
      // 0ac: dsub
      // 0ad: invokestatic java/lang/Math.cos (D)D
      // 0b0: invokestatic java/lang/Math.atan2 (DD)D
      // 0b3: dstore 8
      // 0b5: iload 1
      // 0b6: aload 0
      // 0b7: dup
      // 0b8: getfield x/oc8fe127ea3b.Ы D
      // 0bb: dload 8
      // 0bd: ldc2_w 0.065
      // 0c0: dmul
      // 0c1: dadd
      // 0c2: putfield x/oc8fe127ea3b.Ы D
      // 0c5: dload 4
      // 0c7: aload 0
      // 0c8: getfield x/oc8fe127ea3b.ƛ I
      // 0cb: ineg
      // 0cc: i2d
      // 0cd: ldc2_w 0.004
      // 0d0: dmul
      // 0d1: invokestatic java/lang/Math.exp (D)D
      // 0d4: dmul
      // 0d5: dstore 4
      // 0d7: aload 0
      // 0d8: getfield x/oc8fe127ea3b.ԝ D
      // 0db: aload 0
      // 0dc: getfield x/oc8fe127ea3b.ƛ I
      // 0df: ineg
      // 0e0: i2d
      // 0e1: ldc2_w 0.018
      // 0e4: dmul
      // 0e5: invokestatic java/lang/Math.exp (D)D
      // 0e8: dmul
      // 0e9: dload 2
      // 0ea: ldc2_w 0.8
      // 0ed: dmul
      // 0ee: aload 0
      // 0ef: getfield x/oc8fe127ea3b.ɲ D
      // 0f2: dadd
      // 0f3: invokestatic java/lang/Math.sin (D)D
      // 0f6: ldc2_w 0.012
      // 0f9: dmul
      // 0fa: dadd
      // 0fb: aload 0
      // 0fc: getfield x/oc8fe127ea3b.this$0 Lx/ocdb10538f60;
      // 0ff: getfield x/ocdb10538f60.Ӑ Lx/oca9cc61aada;
      // 102: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 105: dmul
      // 106: dstore 6
      // 108: ifeq 13f
      // 10b: aload 0
      // 10c: dup
      // 10d: getfield x/oc8fe127ea3b.Ы D
      // 110: dload 2
      // 111: ldc2_w 0.8
      // 114: dmul
      // 115: aload 0
      // 116: getfield x/oc8fe127ea3b.ɲ D
      // 119: dadd
      // 11a: invokestatic java/lang/Math.sin (D)D
      // 11d: ldc2_w 0.035
      // 120: dmul
      // 121: dadd
      // 122: putfield x/oc8fe127ea3b.Ы D
      // 125: goto 129
      // 128: athrow
      // 129: dload 2
      // 12a: ldc2_w 1.4
      // 12d: dmul
      // 12e: aload 0
      // 12f: getfield x/oc8fe127ea3b.ɲ D
      // 132: dadd
      // 133: invokestatic java/lang/Math.sin (D)D
      // 136: dload 4
      // 138: dmul
      // 139: ldc2_w 0.35
      // 13c: dmul
      // 13d: dstore 6
      // 13f: new net/minecraft/util/Vec3
      // 142: dup
      // 143: aload 0
      // 144: getfield x/oc8fe127ea3b.Ы D
      // 147: invokestatic java/lang/Math.cos (D)D
      // 14a: dload 4
      // 14c: dmul
      // 14d: dload 6
      // 14f: aload 0
      // 150: getfield x/oc8fe127ea3b.Ы D
      // 153: invokestatic java/lang/Math.sin (D)D
      // 156: dload 4
      // 158: dmul
      // 159: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 15c: astore 8
      // 15e: aload 0
      // 15f: aload 0
      // 160: getfield x/oc8fe127ea3b.Τ Lnet/minecraft/util/Vec3;
      // 163: aload 8
      // 165: aload 0
      // 166: getfield x/oc8fe127ea3b.ʷ Z
      // 169: ifeq 172
      // 16c: ldc 0.18
      // 16e: goto 174
      // 171: athrow
      // 172: ldc 0.12
      // 174: invokestatic x/ocdb10538f60.É (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;F)Lnet/minecraft/util/Vec3;
      // 177: putfield x/oc8fe127ea3b.Τ Lnet/minecraft/util/Vec3;
      // 17a: iload 1
      // 17b: aload 0
      // 17c: getfield x/oc8fe127ea3b.а Lnet/minecraft/util/Vec3;
      // 17f: aload 0
      // 180: getfield x/oc8fe127ea3b.Τ Lnet/minecraft/util/Vec3;
      // 183: getfield net/minecraft/util/Vec3.xCoord D
      // 186: aload 0
      // 187: getfield x/oc8fe127ea3b.Τ Lnet/minecraft/util/Vec3;
      // 18a: getfield net/minecraft/util/Vec3.yCoord D
      // 18d: aload 0
      // 18e: getfield x/oc8fe127ea3b.Τ Lnet/minecraft/util/Vec3;
      // 191: getfield net/minecraft/util/Vec3.zCoord D
      // 194: invokevirtual net/minecraft/util/Vec3.addVector (DDD)Lnet/minecraft/util/Vec3;
      // 197: astore 9
      // 199: ifne 1d2
      // 19c: aload 0
      // 19d: getfield x/oc8fe127ea3b.this$0 Lx/ocdb10538f60;
      // 1a0: aload 9
      // 1a2: invokevirtual x/ocdb10538f60.Δ (Lnet/minecraft/util/Vec3;)Z
      // 1a5: ifeq 1ba
      // 1a8: goto 1ac
      // 1ab: athrow
      // 1ac: aload 0
      // 1ad: aload 9
      // 1af: putfield x/oc8fe127ea3b.а Lnet/minecraft/util/Vec3;
      // 1b2: iload 1
      // 1b3: ifeq 201
      // 1b6: goto 1ba
      // 1b9: athrow
      // 1ba: aload 0
      // 1bb: dup
      // 1bc: getfield x/oc8fe127ea3b.Ы D
      // 1bf: ldc2_w 2.0420352248333655
      // 1c2: dadd
      // 1c3: putfield x/oc8fe127ea3b.Ы D
      // 1c6: aload 0
      // 1c7: aload 0
      // 1c8: getfield x/oc8fe127ea3b.Ы D
      // 1cb: putfield x/oc8fe127ea3b.ʏ D
      // 1ce: goto 1d2
      // 1d1: athrow
      // 1d2: aload 0
      // 1d3: new net/minecraft/util/Vec3
      // 1d6: dup
      // 1d7: aload 0
      // 1d8: getfield x/oc8fe127ea3b.Τ Lnet/minecraft/util/Vec3;
      // 1db: getfield net/minecraft/util/Vec3.xCoord D
      // 1de: dneg
      // 1df: ldc2_w 0.35
      // 1e2: dmul
      // 1e3: aload 0
      // 1e4: getfield x/oc8fe127ea3b.Τ Lnet/minecraft/util/Vec3;
      // 1e7: getfield net/minecraft/util/Vec3.yCoord D
      // 1ea: dneg
      // 1eb: ldc2_w 0.35
      // 1ee: dmul
      // 1ef: aload 0
      // 1f0: getfield x/oc8fe127ea3b.Τ Lnet/minecraft/util/Vec3;
      // 1f3: getfield net/minecraft/util/Vec3.zCoord D
      // 1f6: dneg
      // 1f7: ldc2_w 0.35
      // 1fa: dmul
      // 1fb: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 1fe: putfield x/oc8fe127ea3b.Τ Lnet/minecraft/util/Vec3;
      // 201: aload 0
      // 202: getfield x/oc8fe127ea3b.Ĩ Ljava/util/Deque;
      // 205: new x/oc9f8d7423cd
      // 208: dup
      // 209: aload 0
      // 20a: getfield x/oc8fe127ea3b.а Lnet/minecraft/util/Vec3;
      // 20d: aload 0
      // 20e: getfield x/oc8fe127ea3b.ƛ I
      // 211: invokespecial x/oc9f8d7423cd.<init> (Lnet/minecraft/util/Vec3;I)V
      // 214: invokeinterface java/util/Deque.addLast (Ljava/lang/Object;)V 2
      // 219: aload 0
      // 21a: getfield x/oc8fe127ea3b.this$0 Lx/ocdb10538f60;
      // 21d: getfield x/ocdb10538f60.ղ Lx/oca9cc61aada;
      // 220: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 223: ldc2_w 50.0
      // 226: iload 1
      // 227: ifne 23d
      // 22a: ddiv
      // 22b: aload 0
      // 22c: getfield x/oc8fe127ea3b.ʷ Z
      // 22f: ifeq 240
      // 232: goto 236
      // 235: athrow
      // 236: ldc2_w 1.8
      // 239: goto 23d
      // 23c: athrow
      // 23d: goto 241
      // 240: dconst_1
      // 241: dmul
      // 242: invokestatic java/lang/Math.ceil (D)D
      // 245: d2i
      // 246: istore 10
      // 248: aload 0
      // 249: getfield x/oc8fe127ea3b.Ĩ Ljava/util/Deque;
      // 24c: invokeinterface java/util/Deque.isEmpty ()Z 1
      // 251: ifne 28f
      // 254: aload 0
      // 255: iload 1
      // 256: ifne 290
      // 259: iload 1
      // 25a: ifne 290
      // 25d: goto 261
      // 260: athrow
      // 261: getfield x/oc8fe127ea3b.ƛ I
      // 264: aload 0
      // 265: getfield x/oc8fe127ea3b.Ĩ Ljava/util/Deque;
      // 268: invokeinterface java/util/Deque.peekFirst ()Ljava/lang/Object; 1
      // 26d: checkcast x/oc9f8d7423cd
      // 270: getfield x/oc9f8d7423cd.ĥ I
      // 273: isub
      // 274: iload 10
      // 276: if_icmple 28f
      // 279: goto 27d
      // 27c: athrow
      // 27d: aload 0
      // 27e: getfield x/oc8fe127ea3b.Ĩ Ljava/util/Deque;
      // 281: invokeinterface java/util/Deque.removeFirst ()Ljava/lang/Object; 1
      // 286: pop
      // 287: iload 1
      // 288: ifeq 248
      // 28b: goto 28f
      // 28e: athrow
      // 28f: aload 0
      // 290: getfield x/oc8fe127ea3b.ӯ Ljava/util/List;
      // 293: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 298: astore 11
      // 29a: aload 11
      // 29c: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 2a1: ifeq 33d
      // 2a4: aload 11
      // 2a6: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 2ab: checkcast x/oc66f33bb961
      // 2ae: astore 12
      // 2b0: aload 12
      // 2b2: aload 12
      // 2b4: getfield x/oc66f33bb961.ͻ Lnet/minecraft/util/Vec3;
      // 2b7: putfield x/oc66f33bb961.Ԓ Lnet/minecraft/util/Vec3;
      // 2ba: aload 12
      // 2bc: aload 12
      // 2be: iload 1
      // 2bf: ifne 331
      // 2c2: getfield x/oc66f33bb961.ͻ Lnet/minecraft/util/Vec3;
      // 2c5: aload 12
      // 2c7: getfield x/oc66f33bb961.Ͽ Lnet/minecraft/util/Vec3;
      // 2ca: getfield net/minecraft/util/Vec3.xCoord D
      // 2cd: aload 12
      // 2cf: getfield x/oc66f33bb961.Ͽ Lnet/minecraft/util/Vec3;
      // 2d2: getfield net/minecraft/util/Vec3.yCoord D
      // 2d5: aload 12
      // 2d7: getfield x/oc66f33bb961.Ͽ Lnet/minecraft/util/Vec3;
      // 2da: getfield net/minecraft/util/Vec3.zCoord D
      // 2dd: invokevirtual net/minecraft/util/Vec3.addVector (DDD)Lnet/minecraft/util/Vec3;
      // 2e0: putfield x/oc66f33bb961.ͻ Lnet/minecraft/util/Vec3;
      // 2e3: iload 1
      // 2e4: ifne 354
      // 2e7: goto 2eb
      // 2ea: athrow
      // 2eb: aload 0
      // 2ec: getfield x/oc8fe127ea3b.ʷ Z
      // 2ef: ifeq 32e
      // 2f2: goto 2f6
      // 2f5: athrow
      // 2f6: aload 12
      // 2f8: new net/minecraft/util/Vec3
      // 2fb: dup
      // 2fc: aload 12
      // 2fe: getfield x/oc66f33bb961.Ͽ Lnet/minecraft/util/Vec3;
      // 301: getfield net/minecraft/util/Vec3.xCoord D
      // 304: ldc2_w 0.97
      // 307: dmul
      // 308: aload 12
      // 30a: getfield x/oc66f33bb961.Ͽ Lnet/minecraft/util/Vec3;
      // 30d: getfield net/minecraft/util/Vec3.yCoord D
      // 310: ldc2_w 0.97
      // 313: dmul
      // 314: ldc2_w 5.0E-4
      // 317: dsub
      // 318: aload 12
      // 31a: getfield x/oc66f33bb961.Ͽ Lnet/minecraft/util/Vec3;
      // 31d: getfield net/minecraft/util/Vec3.zCoord D
      // 320: ldc2_w 0.97
      // 323: dmul
      // 324: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 327: putfield x/oc66f33bb961.Ͽ Lnet/minecraft/util/Vec3;
      // 32a: goto 32e
      // 32d: athrow
      // 32e: aload 12
      // 330: dup
      // 331: getfield x/oc66f33bb961.ʡ I
      // 334: bipush 1
      // 335: iadd
      // 336: putfield x/oc66f33bb961.ʡ I
      // 339: iload 1
      // 33a: ifeq 29a
      // 33d: aload 0
      // 33e: getfield x/oc8fe127ea3b.ӯ Ljava/util/List;
      // 341: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, x/oc8fe127ea3b.q3o49yfh2g5h2p (Lx/oc66f33bb961;)Z, (Lx/oc66f33bb961;)Z ]
      // 346: invokeinterface java/util/List.removeIf (Ljava/util/function/Predicate;)Z 2
      // 34b: iload 1
      // 34c: ifne 448
      // 34f: pop
      // 350: goto 354
      // 353: athrow
      // 354: aload 0
      // 355: getfield x/oc8fe127ea3b.ʷ Z
      // 358: ifeq 43c
      // 35b: aload 0
      // 35c: iload 1
      // 35d: ifne 43d
      // 360: goto 364
      // 363: athrow
      // 364: getfield x/oc8fe127ea3b.ƛ I
      // 367: ldc_w -1369096351
      // 36a: ldc -1369096349
      // 36c: ixor
      // 36d: irem
      // 36e: ifne 43c
      // 371: goto 375
      // 374: athrow
      // 375: bipush 0
      // 376: istore 11
      // 378: iload 11
      // 37a: ldc_w -1369096351
      // 37d: ldc -1369096349
      // 37f: ixor
      // 380: if_icmpge 439
      // 383: aload 0
      // 384: getfield x/oc8fe127ea3b.this$0 Lx/ocdb10538f60;
      // 387: getfield x/ocdb10538f60.Ɏ Ljava/util/Random;
      // 38a: invokevirtual java/util/Random.nextDouble ()D
      // 38d: ldc2_w 3.141592653589793
      // 390: dmul
      // 391: ldc2_w 2.0
      // 394: dmul
      // 395: dstore 12
      // 397: iload 1
      // 398: ldc2_w 0.012
      // 39b: aload 0
      // 39c: getfield x/oc8fe127ea3b.this$0 Lx/ocdb10538f60;
      // 39f: getfield x/ocdb10538f60.Ɏ Ljava/util/Random;
      // 3a2: invokevirtual java/util/Random.nextDouble ()D
      // 3a5: ldc2_w 0.025
      // 3a8: dmul
      // 3a9: dadd
      // 3aa: dstore 14
      // 3ac: aload 0
      // 3ad: getfield x/oc8fe127ea3b.ӯ Ljava/util/List;
      // 3b0: new x/oc66f33bb961
      // 3b3: dup
      // 3b4: aload 0
      // 3b5: getfield x/oc8fe127ea3b.а Lnet/minecraft/util/Vec3;
      // 3b8: new net/minecraft/util/Vec3
      // 3bb: dup
      // 3bc: dload 12
      // 3be: invokestatic java/lang/Math.cos (D)D
      // 3c1: dload 14
      // 3c3: dmul
      // 3c4: aload 0
      // 3c5: getfield x/oc8fe127ea3b.Τ Lnet/minecraft/util/Vec3;
      // 3c8: getfield net/minecraft/util/Vec3.xCoord D
      // 3cb: ldc2_w 0.15
      // 3ce: dmul
      // 3cf: dadd
      // 3d0: aload 0
      // 3d1: getfield x/oc8fe127ea3b.this$0 Lx/ocdb10538f60;
      // 3d4: getfield x/ocdb10538f60.Ɏ Ljava/util/Random;
      // 3d7: invokevirtual java/util/Random.nextDouble ()D
      // 3da: ldc2_w 0.5
      // 3dd: dsub
      // 3de: ldc2_w 0.035
      // 3e1: dmul
      // 3e2: dload 12
      // 3e4: invokestatic java/lang/Math.sin (D)D
      // 3e7: dload 14
      // 3e9: dmul
      // 3ea: aload 0
      // 3eb: getfield x/oc8fe127ea3b.Τ Lnet/minecraft/util/Vec3;
      // 3ee: getfield net/minecraft/util/Vec3.zCoord D
      // 3f1: ldc2_w 0.15
      // 3f4: dmul
      // 3f5: dadd
      // 3f6: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 3f9: ldc_w -1369096331
      // 3fc: ldc -1369096349
      // 3fe: ixor
      // 3ff: aload 0
      // 400: getfield x/oc8fe127ea3b.this$0 Lx/ocdb10538f60;
      // 403: getfield x/ocdb10538f60.Ɏ Ljava/util/Random;
      // 406: ldc_w -1369096342
      // 409: ldc -1369096349
      // 40b: ixor
      // 40c: invokevirtual java/util/Random.nextInt (I)I
      // 40f: iadd
      // 410: ldc2_w 0.07
      // 413: aload 0
      // 414: getfield x/oc8fe127ea3b.this$0 Lx/ocdb10538f60;
      // 417: getfield x/ocdb10538f60.Ɏ Ljava/util/Random;
      // 41a: invokevirtual java/util/Random.nextDouble ()D
      // 41d: ldc2_w 0.08
      // 420: dmul
      // 421: dadd
      // 422: invokespecial x/oc66f33bb961.<init> (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;ID)V
      // 425: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 42a: pop
      // 42b: ifne 4c0
      // 42e: iinc 11 1
      // 431: iload 1
      // 432: ifeq 378
      // 435: goto 439
      // 438: athrow
      // 439: goto 4c0
      // 43c: aload 0
      // 43d: iload 1
      // 43e: ifne 44c
      // 441: getfield x/oc8fe127ea3b.ʷ Z
      // 444: goto 448
      // 447: athrow
      // 448: ifne 4c0
      // 44b: aload 0
      // 44c: getfield x/oc8fe127ea3b.ƛ I
      // 44f: iload 1
      // 450: ifne 4bf
      // 453: ldc_w -1369096341
      // 456: ldc -1369096349
      // 458: ixor
      // 459: irem
      // 45a: ifne 4c0
      // 45d: goto 461
      // 460: athrow
      // 461: aload 0
      // 462: getfield x/oc8fe127ea3b.ӯ Ljava/util/List;
      // 465: new x/oc66f33bb961
      // 468: dup
      // 469: aload 0
      // 46a: getfield x/oc8fe127ea3b.а Lnet/minecraft/util/Vec3;
      // 46d: new net/minecraft/util/Vec3
      // 470: dup
      // 471: aload 0
      // 472: getfield x/oc8fe127ea3b.this$0 Lx/ocdb10538f60;
      // 475: getfield x/ocdb10538f60.Ɏ Ljava/util/Random;
      // 478: invokevirtual java/util/Random.nextDouble ()D
      // 47b: ldc2_w 0.5
      // 47e: dsub
      // 47f: ldc2_w 0.012
      // 482: dmul
      // 483: ldc2_w -0.008
      // 486: aload 0
      // 487: getfield x/oc8fe127ea3b.this$0 Lx/ocdb10538f60;
      // 48a: getfield x/ocdb10538f60.Ɏ Ljava/util/Random;
      // 48d: invokevirtual java/util/Random.nextDouble ()D
      // 490: ldc2_w 0.008
      // 493: dmul
      // 494: dsub
      // 495: aload 0
      // 496: getfield x/oc8fe127ea3b.this$0 Lx/ocdb10538f60;
      // 499: getfield x/ocdb10538f60.Ɏ Ljava/util/Random;
      // 49c: invokevirtual java/util/Random.nextDouble ()D
      // 49f: ldc2_w 0.5
      // 4a2: dsub
      // 4a3: ldc2_w 0.012
      // 4a6: dmul
      // 4a7: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 4aa: ldc_w -1369096333
      // 4ad: ldc -1369096349
      // 4af: ixor
      // 4b0: ldc2_w 0.12
      // 4b3: invokespecial x/oc66f33bb961.<init> (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;ID)V
      // 4b6: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 4bb: goto 4bf
      // 4be: athrow
      // 4bf: pop
      // 4c0: return
   }

   private static boolean q3o49yfh2g5h2p(oc66f33bb961 param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: istore 1
      // 04: aload 0
      // 05: getfield x/oc66f33bb961.ʡ I
      // 08: iload 1
      // 09: ifne 1c
      // 0c: aload 0
      // 0d: getfield x/oc66f33bb961.ƴ I
      // 10: if_icmplt 1f
      // 13: goto 17
      // 16: athrow
      // 17: bipush 1
      // 18: goto 1c
      // 1b: athrow
      // 1c: goto 20
      // 1f: bipush 0
      // 20: ireturn
   }
}
