package x;

public class oc5f2027353d {
   public float с;
   public long х;
   public float ɛ = Float.NaN;
   public static boolean К;

   public oc5f2027353d(float var1) {
      this.с = var1;
   }

   public float ǟ(float param1, float param2, int param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc75d51ec7eb.ϩ I
      // 003: istore 4
      // 005: aload 0
      // 006: getfield x/oc5f2027353d.ɛ F
      // 009: iload 4
      // 00b: ifne 042
      // 00e: invokestatic java/lang/Float.isNaN (F)Z
      // 011: ifne 034
      // 014: goto 018
      // 017: athrow
      // 018: aload 0
      // 019: getfield x/oc5f2027353d.ɛ F
      // 01c: iload 4
      // 01e: ifne 042
      // 021: goto 025
      // 024: athrow
      // 025: fload 2
      // 026: fcmpl
      // 027: ifne 034
      // 02a: goto 02e
      // 02d: athrow
      // 02e: aload 0
      // 02f: getfield x/oc5f2027353d.ɛ F
      // 032: freturn
      // 033: athrow
      // 034: invokestatic java/lang/System.currentTimeMillis ()J
      // 037: aload 0
      // 038: getfield x/oc5f2027353d.х J
      // 03b: lsub
      // 03c: l2f
      // 03d: aload 0
      // 03e: getfield x/oc5f2027353d.с F
      // 041: fdiv
      // 042: fstore 5
      // 044: iload 3
      // 045: iload 4
      // 047: ifne 07b
      // 04a: tableswitch 136 1 4 31 94 115 128
      // 068: athrow
      // 069: fload 5
      // 06b: iload 4
      // 06d: ifne 09f
      // 070: goto 074
      // 073: athrow
      // 074: ldc 0.5
      // 076: fcmpg
      // 077: goto 07b
      // 07a: athrow
      // 07b: ifge 08d
      // 07e: ldc 4.0
      // 080: fload 5
      // 082: fmul
      // 083: fload 5
      // 085: fmul
      // 086: fload 5
      // 088: fmul
      // 089: goto 0a1
      // 08c: athrow
      // 08d: fload 5
      // 08f: fconst_1
      // 090: fsub
      // 091: fconst_2
      // 092: fload 5
      // 094: fmul
      // 095: fconst_2
      // 096: fsub
      // 097: fmul
      // 098: fconst_2
      // 099: fload 5
      // 09b: fmul
      // 09c: fconst_2
      // 09d: fsub
      // 09e: fmul
      // 09f: fconst_1
      // 0a0: fadd
      // 0a1: fstore 5
      // 0a3: iload 4
      // 0a5: ifeq 0d2
      // 0a8: dconst_1
      // 0a9: fconst_1
      // 0aa: fload 5
      // 0ac: fsub
      // 0ad: f2d
      // 0ae: ldc2_w 5.0
      // 0b1: invokestatic java/lang/Math.pow (DD)D
      // 0b4: dsub
      // 0b5: d2f
      // 0b6: fstore 5
      // 0b8: iload 4
      // 0ba: ifeq 0d2
      // 0bd: aload 0
      // 0be: fload 5
      // 0c0: invokevirtual x/oc5f2027353d.ø (F)F
      // 0c3: fstore 5
      // 0c5: iload 4
      // 0c7: ifeq 0d2
      // 0ca: aload 0
      // 0cb: fload 5
      // 0cd: invokevirtual x/oc5f2027353d.Ĵ (F)F
      // 0d0: fstore 5
      // 0d2: fload 1
      // 0d3: fload 5
      // 0d5: fload 2
      // 0d6: fload 1
      // 0d7: fsub
      // 0d8: fmul
      // 0d9: fadd
      // 0da: fstore 6
      // 0dc: fload 2
      // 0dd: iload 4
      // 0df: ifne 104
      // 0e2: fload 1
      // 0e3: fcmpl
      // 0e4: ifle 0ff
      // 0e7: goto 0eb
      // 0ea: athrow
      // 0eb: fload 6
      // 0ed: iload 4
      // 0ef: ifne 12b
      // 0f2: goto 0f6
      // 0f5: athrow
      // 0f6: fload 2
      // 0f7: fcmpl
      // 0f8: ifgt 126
      // 0fb: goto 0ff
      // 0fe: athrow
      // 0ff: fload 2
      // 100: goto 104
      // 103: athrow
      // 104: iload 4
      // 106: ifne 12f
      // 109: fload 1
      // 10a: fcmpg
      // 10b: ifge 12d
      // 10e: goto 112
      // 111: athrow
      // 112: fload 6
      // 114: iload 4
      // 116: ifne 12f
      // 119: goto 11d
      // 11c: athrow
      // 11d: fload 2
      // 11e: fcmpg
      // 11f: ifge 12d
      // 122: goto 126
      // 125: athrow
      // 126: fload 2
      // 127: goto 12b
      // 12a: athrow
      // 12b: fstore 6
      // 12d: fload 6
      // 12f: iload 4
      // 131: ifne 149
      // 134: fload 2
      // 135: fcmpl
      // 136: ifne 147
      // 139: goto 13d
      // 13c: athrow
      // 13d: aload 0
      // 13e: fload 6
      // 140: putfield x/oc5f2027353d.ɛ F
      // 143: goto 147
      // 146: athrow
      // 147: fload 6
      // 149: freturn
   }

   public int Ӟ(int var1, int var2, int var3) {
      return Math.round(this.ǟ(var1, var2, var3));
   }

   public void Ξ() {
      this.ɛ = Float.NaN;
      this.х = System.currentTimeMillis();
   }

   // $VF: Handled exception range with multiple entry points by splitting it
   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private float ø(float var1) {
      double var4 = 7.5625;
      double var6 = 2.75;
      int var2 = oc75d51ec7eb.ϩ;

      float var10000;
      label76: {
         label82: {
            try {
               var10000 = var1;
               if (var2 != 0) {
                  break label76;
               }

               if (!(var1 < 1.0 / var6)) {
                  break label82;
               }
            } catch (ocbde1165e4e var14) {
               throw var14;
            }

            float var3 = (float)(var4 * var1 * var1);

            try {
               if (var2 == 0) {
                  return var3;
               }
            } catch (ocbde1165e4e var13) {
               throw var13;
            }
         }

         try {
            var10000 = var1;
         } catch (ocbde1165e4e var9) {
            throw var9;
         }
      }

      label63: {
         label83: {
            try {
               var16 = var10000;
               if (var2 != 0) {
                  break label63;
               }

               if (!(var16 < 2.0 / var6)) {
                  break label83;
               }
            } catch (ocbde1165e4e var12) {
               throw var12;
            }

            float var17 = (float)(var4 * (var1 = (float)(var1 - 1.5 / var6)) * var1 + 0.75);

            try {
               if (var2 == 0) {
                  return var17;
               }
            } catch (ocbde1165e4e var11) {
               throw var11;
            }
         }

         try {
            var16 = var1;
         } catch (ocbde1165e4e var8) {
            throw var8;
         }
      }

      try {
         if (var2 != 0) {
            return (float)var16;
         }

         if (!(var16 < 2.5 / var6)) {
            float var20;
            return (float)(var4 * (var20 = (float)(var1 - 2.625 / var6)) * var20 + 0.984375);
         }
      } catch (ocbde1165e4e var10) {
         throw var10;
      }

      float var19;
      float var18 = (float)(var4 * (var19 = (float)(var1 - 2.25 / var6)) * var19 + 0.9375);
      return var2 == 0 ? var18 : (float)(var4 * (var1 = (float)(var19 - 2.625 / var6)) * var1 + 0.984375);
   }

   float Ĵ(float param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc75d51ec7eb.ϩ I
      // 03: istore 2
      // 04: fload 1
      // 05: iload 2
      // 06: ifne 25
      // 09: ldc 0.5
      // 0b: fcmpg
      // 0c: ifge 1a
      // 0f: goto 13
      // 12: athrow
      // 13: fconst_2
      // 14: fload 1
      // 15: fmul
      // 16: fload 1
      // 17: fmul
      // 18: freturn
      // 19: athrow
      // 1a: ldc -1.0
      // 1c: ldc 4.0
      // 1e: fconst_2
      // 1f: fload 1
      // 20: fmul
      // 21: fsub
      // 22: fload 1
      // 23: fmul
      // 24: fadd
      // 25: freturn
   }
}
