package x;

import net.minecraft.client.Minecraft;

public abstract class oc6031c5c531 {
   protected final ocdacba68ccd Ȓ;
   protected final Minecraft ѥ = Minecraft.getMinecraft();
   private final String ķ;
   public static int Ǌ;

   protected oc6031c5c531(String var1, ocdacba68ccd var2) {
      this.ķ = var1;
      this.Ȓ = var2;
   }

   public final String Գ() {
      return this.ķ;
   }

   public boolean z$sdj84ne38bfn() {
      return false;
   }

   public boolean z$th2zwshf7gtl() {
      return true;
   }

   public boolean z$3hzq8op22ljmt() {
      return false;
   }

   public void z$3g18l332rzhcd(boolean var1) {
   }

   public void R(occ2f8dff8d8 var1) {
      this.z$3g18l332rzhcd(this.Ȓ.ԍ(this.ķ));
   }

   public void է(N var1) {
      this.z$3g18l332rzhcd(this.Ȓ.ԍ(this.ķ));
   }

   public void z$30uo8shdqe5to() {
   }

   public void z$1q0da71f8mrae() {
   }

   public void z$16gekk6u5hb3u() {
   }

   public void z$2chcnix6dewx9(oc2f61de30bc var1) {
   }

   public void z$f8mk1haurfvq(oc25aa89b91f var1) {
   }

   public void z$28gl8df6dqh8o(oce79181588d var1) {
   }

   public void z$eqd7gcilc76w(oc9d4393f3ce var1) {
   }

   public void z$1ygb8gyji3zuv(oc6c7463093f var1) {
   }

   public void z$1ofn7mpfow52n(oc58525a3389 var1) {
   }

   public void ȩ(oc746a23b244 var1) {
   }

   public void z$rvfg1nz4abtc(ocbab3c9954b var1) {
   }

   protected final void ϗ(double param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc6031c5c531.Ǌ I
      // 003: istore 3
      // 004: aload 0
      // 005: iload 3
      // 006: ifne 018
      // 009: getfield x/oc6031c5c531.ѥ Lnet/minecraft/client/Minecraft;
      // 00c: ifnull 021
      // 00f: goto 013
      // 012: athrow
      // 013: aload 0
      // 014: goto 018
      // 017: athrow
      // 018: getfield x/oc6031c5c531.ѥ Lnet/minecraft/client/Minecraft;
      // 01b: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 01e: ifnonnull 023
      // 021: return
      // 022: athrow
      // 023: dload 1
      // 024: iload 3
      // 025: ifne 057
      // 028: dconst_0
      // 029: dcmpl
      // 02a: ifne 049
      // 02d: goto 031
      // 030: athrow
      // 031: aload 0
      // 032: getfield x/oc6031c5c531.ѥ Lnet/minecraft/client/Minecraft;
      // 035: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 038: dconst_0
      // 039: putfield net/minecraft/client/entity/EntityPlayerSP.motionX D
      // 03c: aload 0
      // 03d: getfield x/oc6031c5c531.ѥ Lnet/minecraft/client/Minecraft;
      // 040: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 043: dconst_0
      // 044: putfield net/minecraft/client/entity/EntityPlayerSP.motionZ D
      // 047: return
      // 048: athrow
      // 049: aload 0
      // 04a: getfield x/oc6031c5c531.ѥ Lnet/minecraft/client/Minecraft;
      // 04d: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 050: getfield net/minecraft/client/entity/EntityPlayerSP.movementInput Lnet/minecraft/util/MovementInput;
      // 053: getfield net/minecraft/util/MovementInput.moveForward F
      // 056: f2d
      // 057: dstore 4
      // 059: aload 0
      // 05a: getfield x/oc6031c5c531.ѥ Lnet/minecraft/client/Minecraft;
      // 05d: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 060: getfield net/minecraft/client/entity/EntityPlayerSP.movementInput Lnet/minecraft/util/MovementInput;
      // 063: getfield net/minecraft/util/MovementInput.moveStrafe F
      // 066: f2d
      // 067: dstore 6
      // 069: aload 0
      // 06a: getfield x/oc6031c5c531.ѥ Lnet/minecraft/client/Minecraft;
      // 06d: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 070: getfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 073: fstore 8
      // 075: dload 4
      // 077: dconst_0
      // 078: iload 3
      // 079: ifne 0ba
      // 07c: dcmpl
      // 07d: ifne 0af
      // 080: goto 084
      // 083: athrow
      // 084: dload 6
      // 086: iload 3
      // 087: ifne 0b1
      // 08a: goto 08e
      // 08d: athrow
      // 08e: dconst_0
      // 08f: dcmpl
      // 090: ifne 0af
      // 093: goto 097
      // 096: athrow
      // 097: aload 0
      // 098: getfield x/oc6031c5c531.ѥ Lnet/minecraft/client/Minecraft;
      // 09b: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 09e: dconst_0
      // 09f: putfield net/minecraft/client/entity/EntityPlayerSP.motionX D
      // 0a2: aload 0
      // 0a3: getfield x/oc6031c5c531.ѥ Lnet/minecraft/client/Minecraft;
      // 0a6: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0a9: dconst_0
      // 0aa: putfield net/minecraft/client/entity/EntityPlayerSP.motionZ D
      // 0ad: return
      // 0ae: athrow
      // 0af: dload 4
      // 0b1: iload 3
      // 0b2: ifne 13c
      // 0b5: dconst_0
      // 0b6: goto 0ba
      // 0b9: athrow
      // 0ba: dcmpl
      // 0bb: ifeq 133
      // 0be: dload 6
      // 0c0: iload 3
      // 0c1: ifne 0f3
      // 0c4: goto 0c8
      // 0c7: athrow
      // 0c8: dconst_0
      // 0c9: dcmpl
      // 0ca: ifle 0ed
      // 0cd: goto 0d1
      // 0d0: athrow
      // 0d1: fload 8
      // 0d3: dload 4
      // 0d5: dconst_0
      // 0d6: dcmpl
      // 0d7: ifle 0e4
      // 0da: goto 0de
      // 0dd: athrow
      // 0de: ldc -45.0
      // 0e0: goto 0e6
      // 0e3: athrow
      // 0e4: ldc 45.0
      // 0e6: fadd
      // 0e7: fstore 8
      // 0e9: iload 3
      // 0ea: ifeq 118
      // 0ed: dload 6
      // 0ef: goto 0f3
      // 0f2: athrow
      // 0f3: iload 3
      // 0f4: ifne 121
      // 0f7: dconst_0
      // 0f8: dcmpg
      // 0f9: ifge 118
      // 0fc: goto 100
      // 0ff: athrow
      // 100: fload 8
      // 102: dload 4
      // 104: dconst_0
      // 105: dcmpl
      // 106: ifle 113
      // 109: goto 10d
      // 10c: athrow
      // 10d: ldc 45.0
      // 10f: goto 115
      // 112: athrow
      // 113: ldc -45.0
      // 115: fadd
      // 116: fstore 8
      // 118: dconst_0
      // 119: iload 3
      // 11a: ifne 12b
      // 11d: dstore 6
      // 11f: dload 4
      // 121: dconst_0
      // 122: dcmpl
      // 123: ifle 12e
      // 126: dconst_1
      // 127: goto 12b
      // 12a: athrow
      // 12b: goto 131
      // 12e: ldc2_w -1.0
      // 131: dstore 4
      // 133: fload 8
      // 135: ldc 90.0
      // 137: fadd
      // 138: f2d
      // 139: invokestatic java/lang/Math.toRadians (D)D
      // 13c: dstore 9
      // 13e: dload 9
      // 140: invokestatic java/lang/Math.sin (D)D
      // 143: dstore 11
      // 145: dload 9
      // 147: invokestatic java/lang/Math.cos (D)D
      // 14a: dstore 13
      // 14c: aload 0
      // 14d: getfield x/oc6031c5c531.ѥ Lnet/minecraft/client/Minecraft;
      // 150: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 153: dload 4
      // 155: dload 1
      // 156: dmul
      // 157: dload 13
      // 159: dmul
      // 15a: dload 6
      // 15c: dload 1
      // 15d: dmul
      // 15e: dload 11
      // 160: dmul
      // 161: dadd
      // 162: putfield net/minecraft/client/entity/EntityPlayerSP.motionX D
      // 165: aload 0
      // 166: getfield x/oc6031c5c531.ѥ Lnet/minecraft/client/Minecraft;
      // 169: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 16c: dload 4
      // 16e: dload 1
      // 16f: dmul
      // 170: dload 11
      // 172: dmul
      // 173: dload 6
      // 175: dload 1
      // 176: dmul
      // 177: dload 13
      // 179: dmul
      // 17a: dsub
      // 17b: putfield net/minecraft/client/entity/EntityPlayerSP.motionZ D
      // 17e: return
   }
}
