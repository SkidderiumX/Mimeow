package x;

public class ocd299de7725 {
   private double è;
   private float Ͽ;
   private float ϫ;
   public static int τ;

   public float Զ(float param1, float param2, double param3, double param5, oca6eae151db param7) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 00: getstatic x/oca6eae151db.ȷ Z
      // 03: istore 8
      // 05: dload 5
      // 07: aload 0
      // 08: getfield x/ocd299de7725.è D
      // 0b: iload 8
      // 0d: ifne ba
      // 10: dload 3
      // 11: dadd
      // 12: dcmpl
      // 13: ifle a5
      // 16: goto 1a
      // 19: athrow
      // 1a: aload 0
      // 1b: iload 8
      // 1d: ifne 7f
      // 20: goto 24
      // 23: athrow
      // 24: dload 5
      // 26: putfield x/ocd299de7725.è D
      // 29: aload 0
      // 2a: getfield x/ocd299de7725.Ͽ F
      // 2d: fconst_0
      // 2e: fcmpl
      // 2f: ifne 7e
      // 32: goto 36
      // 35: athrow
      // 36: aload 0
      // 37: iload 8
      // 39: ifne 7f
      // 3c: goto 40
      // 3f: athrow
      // 40: getfield x/ocd299de7725.ϫ F
      // 43: fconst_0
      // 44: fcmpl
      // 45: ifne 7e
      // 48: goto 4c
      // 4b: athrow
      // 4c: aload 0
      // 4d: aload 7
      // 4f: fconst_0
      // 50: fconst_1
      // 51: invokevirtual x/oca6eae151db.ŝ (FF)F
      // 54: putfield x/ocd299de7725.Ͽ F
      // 57: aload 0
      // 58: aload 7
      // 5a: fconst_0
      // 5b: fconst_1
      // 5c: invokevirtual x/oca6eae151db.ŝ (FF)F
      // 5f: putfield x/ocd299de7725.ϫ F
      // 62: ldc2_w 0.2
      // 65: aload 0
      // 66: getfield x/ocd299de7725.Ͽ F
      // 69: aload 0
      // 6a: getfield x/ocd299de7725.ϫ F
      // 6d: fsub
      // 6e: invokestatic x/oc497d0cdf29.Ж (F)F
      // 71: f2d
      // 72: dcmpl
      // 73: ifgt 4c
      // 76: goto 7a
      // 79: athrow
      // 7a: goto a5
      // 7d: athrow
      // 7e: aload 0
      // 7f: aload 0
      // 80: getfield x/ocd299de7725.ϫ F
      // 83: putfield x/ocd299de7725.Ͽ F
      // 86: aload 0
      // 87: aload 7
      // 89: fconst_0
      // 8a: fconst_1
      // 8b: invokevirtual x/oca6eae151db.ŝ (FF)F
      // 8e: putfield x/ocd299de7725.ϫ F
      // 91: ldc2_w 0.2
      // 94: aload 0
      // 95: getfield x/ocd299de7725.Ͽ F
      // 98: aload 0
      // 99: getfield x/ocd299de7725.ϫ F
      // 9c: fsub
      // 9d: invokestatic x/oc497d0cdf29.Ж (F)F
      // a0: f2d
      // a1: dcmpl
      // a2: ifgt 86
      // a5: dload 5
      // a7: aload 0
      // a8: getfield x/ocd299de7725.è D
      // ab: iload 8
      // ad: ifne a1
      // b0: goto b4
      // b3: athrow
      // b4: dsub
      // b5: dload 3
      // b6: goto ba
      // b9: athrow
      // ba: ddiv
      // bb: dstore 9
      // bd: aload 0
      // be: getfield x/ocd299de7725.ϫ F
      // c1: aload 0
      // c2: getfield x/ocd299de7725.Ͽ F
      // c5: fsub
      // c6: f2d
      // c7: dload 9
      // c9: dmul
      // ca: aload 0
      // cb: getfield x/ocd299de7725.Ͽ F
      // ce: f2d
      // cf: dadd
      // d0: dstore 11
      // d2: fload 2
      // d3: fload 1
      // d4: fsub
      // d5: f2d
      // d6: dload 11
      // d8: dmul
      // d9: fload 1
      // da: f2d
      // db: dadd
      // dc: d2f
      // dd: freturn
   }

   public boolean È(float var1, float var2, double var3, double var5, oca6eae151db var7) {
      int var10000 = oca6eae151db.ȷ;
      float var9 = var7.ŝ(0.0F, 1.0F);
      boolean var8 = (boolean)var10000;

      try {
         float var12;
         var10000 = (var12 = this.Զ(var1, var2, var3, var5, var7) - var9) == 0.0F ? 0 : (var12 < 0.0F ? -1 : 1);
         if (var8) {
            return (boolean)var10000;
         }

         if (var10000 > 0) {
            return (boolean)1;
         }
      } catch (ocbde1165e4e var10) {
         throw var10;
      }

      return (boolean)0;
   }
}
