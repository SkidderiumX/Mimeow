package x;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.init.Blocks;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.network.play.client.C0BPacketEntityAction;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.util.EnumFacing.Axis;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;

public class ocbce5ea28a3 {
   static final float ԁ = 95.0F;
   static final float n = 90.0F;
   static final int ծ = 12;
   static final int ձ = 20;
   private static final double ȱ = 4.5;
   private static final double ǘ = 1.0E-4;
   private static final double ʥ = 0.4;
   private static final double Ʉ = 0.2;
   private static final double Л = 0.35;
   private static final double ŉ = 0.42F;
   private static final float ք = 84.5F;
   private static final float ʩ = 45.0F;
   private static final float ϵ = 45.0F;
   private static final float к = 0.08F;
   private static final int ë = 1;
   private static final int њ = 1;
   private static final int Ō = 1;
   private static final int ҫ = 1;
   private static final double Ϻ = 500.0;
   private static final int Ð = 6;
   private static final int ҳ = 16;
   private static final double ǣ = 0.984807753;
   private static final double Ǿ = 0.001;
   private static final double[] Ћ;
   private final oc668fce0dbf Ǚ;
   private final Minecraft Ѭ = Minecraft.getMinecraft();
   private final oc7beea7ccff ƒ = oc7beea7ccff.կ();
   private final oc7cc5657deb Ͼ = new oc7cc5657deb();
   private oc65fedf8d38 Ѻ = oc65fedf8d38.ѻ;
   private long ϯ;
   private long Մ;
   private long Ӝ;
   private long ќ = 4420168326711319145L ^ -4803203710143456663L;
   private long ʁ = -4420168326711319146L ^ -4803203710143456663L;
   private long ւ = 4420168326711319145L ^ -4803203710143456663L;
   private int ʐ = 554967294 ^ -1592516354;
   private int Ҏ;
   private int φ;
   private boolean ɐ;
   private oc791986a759 ʡ;
   private oc06124119aa ɓ = oc06124119aa.ƌ;
   private oc53b792ae32 è;
   private oceb7a9b9a85 ն;
   private oc3458eda443 ƫ;
   private oc1a421bd3db Ƕ;
   private oc847503a8ab Ղ;
   private oc981d71de6a ɹ;
   private occ00ef6c188 Ш;
   private oc30b42710ad ҽ;
   private oc7b822110db б;
   private boolean Ć;
   private boolean ȷ;
   private boolean Κ;
   private boolean Դ;
   private boolean Ȯ;
   private boolean ǚ;
   private int Ϝ;
   private int ǯ = 1;
   private float A;
   private float ɞ;
   private float Ӑ;
   private float Ӭ;
   private float Ś;
   private float Η;
   private float Օ;
   private float Ӂ;
   private double π;
   private double Ԅ;
   private double Ű;
   private double ł;
   private BlockPos Ο;
   private BlockPos e;
   private boolean Լ;
   private boolean ʨ;
   private boolean Ժ;
   private boolean џ;
   private boolean ԣ;
   private final Set<BlockPos> Ñ = new HashSet<>();
   private float ȹ;
   private float я;
   private boolean Ƭ;
   private float D;
   private float ʫ;
   private boolean d;

   ocbce5ea28a3(oc668fce0dbf var1) {
      this.Ǚ = var1;
   }

   void ϔ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: aload 0
      // 004: getfield x/ocbce5ea28a3.Ǚ Lx/oc668fce0dbf;
      // 007: invokevirtual x/oc668fce0dbf.ն ()Lnet/minecraft/client/entity/EntityPlayerSP;
      // 00a: astore 2
      // 00b: istore 1
      // 00c: aload 0
      // 00d: getstatic x/oc65fedf8d38.ѻ Lx/oc65fedf8d38;
      // 010: putfield x/ocbce5ea28a3.Ѻ Lx/oc65fedf8d38;
      // 013: aload 0
      // 014: lconst_0
      // 015: putfield x/ocbce5ea28a3.ϯ J
      // 018: aload 0
      // 019: lconst_0
      // 01a: putfield x/ocbce5ea28a3.Մ J
      // 01d: aload 0
      // 01e: lconst_0
      // 01f: putfield x/ocbce5ea28a3.Ӝ J
      // 022: aload 0
      // 023: ldc2_w 2255616817376930900
      // 026: ldc2_w -6967755219477844908
      // 029: lxor
      // 02a: putfield x/ocbce5ea28a3.ќ J
      // 02d: aload 0
      // 02e: ldc2_w -2255616817376930901
      // 031: ldc2_w -6967755219477844908
      // 034: lxor
      // 035: putfield x/ocbce5ea28a3.ʁ J
      // 038: aload 0
      // 039: ldc2_w 2255616817376930900
      // 03c: ldc2_w -6967755219477844908
      // 03f: lxor
      // 040: putfield x/ocbce5ea28a3.ւ J
      // 043: aload 0
      // 044: ldc_w 422107652
      // 047: ldc_w -1725375996
      // 04a: ixor
      // 04b: putfield x/ocbce5ea28a3.ʐ I
      // 04e: aload 0
      // 04f: bipush 0
      // 050: putfield x/ocbce5ea28a3.Ҏ I
      // 053: aload 0
      // 054: bipush 0
      // 055: putfield x/ocbce5ea28a3.φ I
      // 058: aload 0
      // 059: bipush 0
      // 05a: putfield x/ocbce5ea28a3.ɐ Z
      // 05d: aload 0
      // 05e: aconst_null
      // 05f: putfield x/ocbce5ea28a3.ʡ Lx/oc791986a759;
      // 062: aload 0
      // 063: getstatic x/oc06124119aa.ƌ Lx/oc06124119aa;
      // 066: putfield x/ocbce5ea28a3.ɓ Lx/oc06124119aa;
      // 069: aload 0
      // 06a: aconst_null
      // 06b: putfield x/ocbce5ea28a3.è Lx/oc53b792ae32;
      // 06e: aload 0
      // 06f: aconst_null
      // 070: putfield x/ocbce5ea28a3.ն Lx/oceb7a9b9a85;
      // 073: aload 0
      // 074: aconst_null
      // 075: putfield x/ocbce5ea28a3.ƫ Lx/oc3458eda443;
      // 078: aload 0
      // 079: aconst_null
      // 07a: putfield x/ocbce5ea28a3.Ƕ Lx/oc1a421bd3db;
      // 07d: aload 0
      // 07e: aconst_null
      // 07f: putfield x/ocbce5ea28a3.Ղ Lx/oc847503a8ab;
      // 082: aload 0
      // 083: aconst_null
      // 084: putfield x/ocbce5ea28a3.ɹ Lx/oc981d71de6a;
      // 087: aload 0
      // 088: aconst_null
      // 089: putfield x/ocbce5ea28a3.Ш Lx/occ00ef6c188;
      // 08c: aload 0
      // 08d: aconst_null
      // 08e: putfield x/ocbce5ea28a3.ҽ Lx/oc30b42710ad;
      // 091: aload 0
      // 092: aconst_null
      // 093: putfield x/ocbce5ea28a3.б Lx/oc7b822110db;
      // 096: aload 0
      // 097: bipush 0
      // 098: iload 1
      // 099: ifne 0bf
      // 09c: putfield x/ocbce5ea28a3.Ć Z
      // 09f: aload 0
      // 0a0: bipush 0
      // 0a1: putfield x/ocbce5ea28a3.ȷ Z
      // 0a4: aload 0
      // 0a5: bipush 0
      // 0a6: putfield x/ocbce5ea28a3.Κ Z
      // 0a9: aload 0
      // 0aa: bipush 0
      // 0ab: putfield x/ocbce5ea28a3.Դ Z
      // 0ae: aload 0
      // 0af: aload 2
      // 0b0: ifnull 0ce
      // 0b3: goto 0b7
      // 0b6: athrow
      // 0b7: aload 2
      // 0b8: getfield net/minecraft/client/entity/EntityPlayerSP.onGround Z
      // 0bb: goto 0bf
      // 0be: athrow
      // 0bf: iload 1
      // 0c0: ifne 0cb
      // 0c3: ifne 0ce
      // 0c6: goto 0ca
      // 0c9: athrow
      // 0ca: bipush 1
      // 0cb: goto 0cf
      // 0ce: bipush 0
      // 0cf: putfield x/ocbce5ea28a3.Ȯ Z
      // 0d2: aload 0
      // 0d3: bipush 0
      // 0d4: putfield x/ocbce5ea28a3.ǚ Z
      // 0d7: aload 0
      // 0d8: bipush 0
      // 0d9: putfield x/ocbce5ea28a3.Ϝ I
      // 0dc: aload 0
      // 0dd: bipush 1
      // 0de: putfield x/ocbce5ea28a3.ǯ I
      // 0e1: aload 0
      // 0e2: fconst_0
      // 0e3: putfield x/ocbce5ea28a3.A F
      // 0e6: aload 0
      // 0e7: fconst_0
      // 0e8: putfield x/ocbce5ea28a3.ɞ F
      // 0eb: aload 0
      // 0ec: fconst_0
      // 0ed: putfield x/ocbce5ea28a3.Ӑ F
      // 0f0: aload 0
      // 0f1: fconst_0
      // 0f2: putfield x/ocbce5ea28a3.Ӭ F
      // 0f5: aload 0
      // 0f6: fconst_0
      // 0f7: putfield x/ocbce5ea28a3.Ś F
      // 0fa: aload 0
      // 0fb: fconst_0
      // 0fc: putfield x/ocbce5ea28a3.Η F
      // 0ff: aload 0
      // 100: fconst_0
      // 101: putfield x/ocbce5ea28a3.Օ F
      // 104: aload 0
      // 105: fconst_0
      // 106: putfield x/ocbce5ea28a3.Ӂ F
      // 109: aload 0
      // 10a: dconst_0
      // 10b: putfield x/ocbce5ea28a3.π D
      // 10e: aload 0
      // 10f: dconst_0
      // 110: putfield x/ocbce5ea28a3.Ԅ D
      // 113: aload 0
      // 114: dconst_0
      // 115: putfield x/ocbce5ea28a3.Ű D
      // 118: aload 0
      // 119: dconst_0
      // 11a: putfield x/ocbce5ea28a3.ł D
      // 11d: aload 0
      // 11e: aconst_null
      // 11f: putfield x/ocbce5ea28a3.Ο Lnet/minecraft/util/BlockPos;
      // 122: aload 0
      // 123: bipush 0
      // 124: putfield x/ocbce5ea28a3.Լ Z
      // 127: aload 0
      // 128: bipush 0
      // 129: putfield x/ocbce5ea28a3.ʨ Z
      // 12c: aload 0
      // 12d: bipush 0
      // 12e: putfield x/ocbce5ea28a3.Ժ Z
      // 131: aload 0
      // 132: bipush 0
      // 133: putfield x/ocbce5ea28a3.џ Z
      // 136: aload 0
      // 137: bipush 0
      // 138: putfield x/ocbce5ea28a3.ԣ Z
      // 13b: aload 0
      // 13c: aconst_null
      // 13d: putfield x/ocbce5ea28a3.e Lnet/minecraft/util/BlockPos;
      // 140: aload 0
      // 141: getfield x/ocbce5ea28a3.Ñ Ljava/util/Set;
      // 144: invokeinterface java/util/Set.clear ()V 1
      // 149: aload 0
      // 14a: fconst_0
      // 14b: putfield x/ocbce5ea28a3.ȹ F
      // 14e: aload 0
      // 14f: fconst_0
      // 150: putfield x/ocbce5ea28a3.я F
      // 153: aload 0
      // 154: bipush 0
      // 155: putfield x/ocbce5ea28a3.Ƭ Z
      // 158: aload 0
      // 159: fconst_0
      // 15a: putfield x/ocbce5ea28a3.D F
      // 15d: aload 0
      // 15e: fconst_0
      // 15f: putfield x/ocbce5ea28a3.ʫ F
      // 162: aload 0
      // 163: bipush 0
      // 164: putfield x/ocbce5ea28a3.d Z
      // 167: aload 0
      // 168: getfield x/ocbce5ea28a3.Ͼ Lx/oc7cc5657deb;
      // 16b: invokevirtual x/oc7cc5657deb.ȓ ()V
      // 16e: aload 0
      // 16f: getfield x/ocbce5ea28a3.Ǚ Lx/oc668fce0dbf;
      // 172: bipush 0
      // 173: invokevirtual x/oc668fce0dbf.Σ (Z)V
      // 176: iload 1
      // 177: ifeq 18b
      // 17a: bipush 0
      // 17b: ifeq 187
      // 17e: goto 182
      // 181: athrow
      // 182: bipush 0
      // 183: goto 188
      // 186: athrow
      // 187: bipush 1
      // 188: putstatic x/oc69da1aa7f5.Ҭ Z
      // 18b: return
   }

   void ɓ(float param1, float param2, boolean param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: aload 0
      // 04: fload 1
      // 05: putfield x/ocbce5ea28a3.ȹ F
      // 08: istore 4
      // 0a: aload 0
      // 0b: fload 2
      // 0c: putfield x/ocbce5ea28a3.я F
      // 0f: aload 0
      // 10: aload 0
      // 11: getfield x/ocbce5ea28a3.ƫ Lx/oc3458eda443;
      // 14: ifnonnull 3f
      // 17: iload 3
      // 18: iload 4
      // 1a: ifne 40
      // 1d: goto 21
      // 20: athrow
      // 21: ifne 3f
      // 24: goto 28
      // 27: athrow
      // 28: aload 0
      // 29: getfield x/ocbce5ea28a3.ƒ Lx/oc7beea7ccff;
      // 2c: invokevirtual x/oc7beea7ccff.ı ()Z
      // 2f: iload 4
      // 31: ifne 40
      // 34: goto 38
      // 37: athrow
      // 38: ifeq 43
      // 3b: goto 3f
      // 3e: athrow
      // 3f: bipush 1
      // 40: goto 44
      // 43: bipush 0
      // 44: putfield x/ocbce5ea28a3.Ƭ Z
      // 47: return
   }

   boolean ԃ() {
      return this.Ƭ;
   }

   float ʈ() {
      return this.ȹ;
   }

   boolean н() {
      return this.ȷ;
   }

   void ʁ(oc70db705765 var1, boolean var2) {
      this.O(var1, var2, 1);
   }

   void O(oc70db705765 param1, boolean param2, int param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: istore 4
      // 005: aload 0
      // 006: iload 4
      // 008: ifne 022
      // 00b: aload 0
      // 00c: getfield x/ocbce5ea28a3.Ǚ Lx/oc668fce0dbf;
      // 00f: invokevirtual x/oc668fce0dbf.ȉ ()Z
      // 012: putfield x/ocbce5ea28a3.Κ Z
      // 015: aload 1
      // 016: ifnull 031
      // 019: goto 01d
      // 01c: athrow
      // 01d: aload 0
      // 01e: goto 022
      // 021: athrow
      // 022: iload 4
      // 024: ifne 034
      // 027: invokevirtual x/ocbce5ea28a3.ǔ ()Z
      // 02a: ifne 033
      // 02d: goto 031
      // 030: athrow
      // 031: return
      // 032: athrow
      // 033: aload 0
      // 034: getfield x/ocbce5ea28a3.Ǚ Lx/oc668fce0dbf;
      // 037: invokevirtual x/oc668fce0dbf.ն ()Lnet/minecraft/client/entity/EntityPlayerSP;
      // 03a: astore 5
      // 03c: iload 3
      // 03d: invokestatic x/ocbce5ea28a3.u (I)I
      // 040: istore 6
      // 042: aload 0
      // 043: getfield x/ocbce5ea28a3.ǯ I
      // 046: iload 4
      // 048: ifne 069
      // 04b: iload 6
      // 04d: if_icmpeq 068
      // 050: goto 054
      // 053: athrow
      // 054: aload 0
      // 055: iload 6
      // 057: putfield x/ocbce5ea28a3.ǯ I
      // 05a: aload 0
      // 05b: bipush 0
      // 05c: putfield x/ocbce5ea28a3.Ϝ I
      // 05f: aload 0
      // 060: bipush 0
      // 061: putfield x/ocbce5ea28a3.ǚ Z
      // 064: goto 068
      // 067: athrow
      // 068: iload 2
      // 069: iload 4
      // 06b: ifne 0a8
      // 06e: ifne 0a3
      // 071: goto 075
      // 074: athrow
      // 075: aload 0
      // 076: aload 5
      // 078: getfield net/minecraft/client/entity/EntityPlayerSP.onGround Z
      // 07b: iload 4
      // 07d: ifne 08c
      // 080: goto 084
      // 083: athrow
      // 084: ifne 08f
      // 087: goto 08b
      // 08a: athrow
      // 08b: bipush 1
      // 08c: goto 090
      // 08f: bipush 0
      // 090: putfield x/ocbce5ea28a3.Ȯ Z
      // 093: aload 0
      // 094: bipush 0
      // 095: putfield x/ocbce5ea28a3.ǚ Z
      // 098: aload 0
      // 099: bipush 0
      // 09a: putfield x/ocbce5ea28a3.Ϝ I
      // 09d: aload 0
      // 09e: bipush 0
      // 09f: putfield x/ocbce5ea28a3.Դ Z
      // 0a2: return
      // 0a3: aload 5
      // 0a5: getfield net/minecraft/client/entity/EntityPlayerSP.onGround Z
      // 0a8: iload 4
      // 0aa: ifne 0d5
      // 0ad: ifeq 0c5
      // 0b0: goto 0b4
      // 0b3: athrow
      // 0b4: aload 0
      // 0b5: bipush 0
      // 0b6: putfield x/ocbce5ea28a3.Դ Z
      // 0b9: aload 0
      // 0ba: bipush 0
      // 0bb: putfield x/ocbce5ea28a3.Ȯ Z
      // 0be: aload 0
      // 0bf: bipush 0
      // 0c0: putfield x/ocbce5ea28a3.ǚ Z
      // 0c3: return
      // 0c4: athrow
      // 0c5: aload 0
      // 0c6: iload 4
      // 0c8: ifne 0da
      // 0cb: getfield x/ocbce5ea28a3.Ǚ Lx/oc668fce0dbf;
      // 0ce: invokevirtual x/oc668fce0dbf.ȉ ()Z
      // 0d1: goto 0d5
      // 0d4: athrow
      // 0d5: ifeq 0d9
      // 0d8: return
      // 0d9: aload 0
      // 0da: iload 4
      // 0dc: ifne 12a
      // 0df: getfield x/ocbce5ea28a3.Ȯ Z
      // 0e2: ifne 129
      // 0e5: goto 0e9
      // 0e8: athrow
      // 0e9: aload 0
      // 0ea: bipush 1
      // 0eb: iload 4
      // 0ed: ifne 115
      // 0f0: goto 0f4
      // 0f3: athrow
      // 0f4: putfield x/ocbce5ea28a3.Ȯ Z
      // 0f7: aload 0
      // 0f8: getfield x/ocbce5ea28a3.Ϝ I
      // 0fb: ifle 110
      // 0fe: goto 102
      // 101: athrow
      // 102: aload 0
      // 103: dup
      // 104: getfield x/ocbce5ea28a3.Ϝ I
      // 107: bipush 1
      // 108: isub
      // 109: putfield x/ocbce5ea28a3.Ϝ I
      // 10c: goto 110
      // 10f: athrow
      // 110: aload 0
      // 111: aload 0
      // 112: getfield x/ocbce5ea28a3.Ϝ I
      // 115: iload 4
      // 117: ifne 122
      // 11a: ifne 125
      // 11d: goto 121
      // 120: athrow
      // 121: bipush 1
      // 122: goto 126
      // 125: bipush 0
      // 126: putfield x/ocbce5ea28a3.ǚ Z
      // 129: aload 0
      // 12a: getfield x/ocbce5ea28a3.Ѻ Lx/oc65fedf8d38;
      // 12d: aload 5
      // 12f: getfield net/minecraft/client/entity/EntityPlayerSP.onGround Z
      // 132: aload 0
      // 133: getfield x/ocbce5ea28a3.Ҏ I
      // 136: aload 5
      // 138: getfield net/minecraft/client/entity/EntityPlayerSP.motionY D
      // 13b: aload 0
      // 13c: getfield x/ocbce5ea28a3.Դ Z
      // 13f: aload 0
      // 140: getfield x/ocbce5ea28a3.ǚ Z
      // 143: invokestatic x/ocbce5ea28a3.Ʉ (Lx/oc65fedf8d38;ZIDZZ)Z
      // 146: iload 4
      // 148: ifne 160
      // 14b: ifne 153
      // 14e: goto 152
      // 151: athrow
      // 152: return
      // 153: aload 1
      // 154: iload 4
      // 156: ifne 177
      // 159: invokevirtual x/oc70db705765.ҧ ()Z
      // 15c: goto 160
      // 15f: athrow
      // 160: ifne 176
      // 163: aload 0
      // 164: aload 0
      // 165: getfield x/ocbce5ea28a3.Ǚ Lx/oc668fce0dbf;
      // 168: aload 1
      // 169: ldc_w "Telly/Mid cycle"
      // 16c: invokevirtual x/oc668fce0dbf.Λ (Lx/oc70db705765;Ljava/lang/String;)Z
      // 16f: putfield x/ocbce5ea28a3.Κ Z
      // 172: goto 176
      // 175: athrow
      // 176: aload 1
      // 177: invokevirtual x/oc70db705765.ҧ ()Z
      // 17a: ifeq 191
      // 17d: aload 0
      // 17e: bipush 1
      // 17f: putfield x/ocbce5ea28a3.Դ Z
      // 182: aload 0
      // 183: bipush 0
      // 184: putfield x/ocbce5ea28a3.ǚ Z
      // 187: aload 0
      // 188: iload 6
      // 18a: putfield x/ocbce5ea28a3.Ϝ I
      // 18d: goto 191
      // 190: athrow
      // 191: return
   }

   void ԑ(oc7ebeda7e63 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: aload 0
      // 001: dup
      // 002: getfield x/ocbce5ea28a3.ϯ J
      // 005: lconst_1
      // 006: ladd
      // 007: putfield x/ocbce5ea28a3.ϯ J
      // 00a: aload 0
      // 00b: aconst_null
      // 00c: putfield x/ocbce5ea28a3.ƫ Lx/oc3458eda443;
      // 00f: getstatic x/oc84f20a0bc5.ė I
      // 012: aload 0
      // 013: bipush 0
      // 014: putfield x/ocbce5ea28a3.Ƭ Z
      // 017: istore 2
      // 018: aload 0
      // 019: iload 2
      // 01a: ifne 033
      // 01d: bipush 0
      // 01e: putfield x/ocbce5ea28a3.d Z
      // 021: aload 0
      // 022: invokevirtual x/ocbce5ea28a3.ǔ ()Z
      // 025: ifne 032
      // 028: goto 02c
      // 02b: athrow
      // 02c: aload 0
      // 02d: invokevirtual x/ocbce5ea28a3.ϔ ()V
      // 030: return
      // 031: athrow
      // 032: aload 0
      // 033: getfield x/ocbce5ea28a3.Ǚ Lx/oc668fce0dbf;
      // 036: invokevirtual x/oc668fce0dbf.ն ()Lnet/minecraft/client/entity/EntityPlayerSP;
      // 039: astore 3
      // 03a: aload 0
      // 03b: iload 2
      // 03c: ifne 069
      // 03f: getfield x/ocbce5ea28a3.Ѻ Lx/oc65fedf8d38;
      // 042: getstatic x/oc65fedf8d38.ѻ Lx/oc65fedf8d38;
      // 045: if_acmpne 068
      // 048: goto 04c
      // 04b: athrow
      // 04c: aload 0
      // 04d: aload 1
      // 04e: invokevirtual x/oc7ebeda7e63.ԋ ()F
      // 051: putfield x/ocbce5ea28a3.Ś F
      // 054: aload 0
      // 055: aload 1
      // 056: invokevirtual x/oc7ebeda7e63.ɦ ()F
      // 059: ldc_w -90.0
      // 05c: ldc 90.0
      // 05e: invokestatic net/minecraft/util/MathHelper.clamp_float (FFF)F
      // 061: putfield x/ocbce5ea28a3.Η F
      // 064: goto 068
      // 067: athrow
      // 068: aload 0
      // 069: iload 2
      // 06a: ifne 0a7
      // 06d: getfield x/ocbce5ea28a3.Ǚ Lx/oc668fce0dbf;
      // 070: invokevirtual x/oc668fce0dbf.ҵ ()Lnet/minecraft/item/ItemBlock;
      // 073: ifnonnull 0a6
      // 076: goto 07a
      // 079: athrow
      // 07a: aload 0
      // 07b: iload 2
      // 07c: ifne 09f
      // 07f: goto 083
      // 082: athrow
      // 083: getfield x/ocbce5ea28a3.Ѻ Lx/oc65fedf8d38;
      // 086: getstatic x/oc65fedf8d38.ѻ Lx/oc65fedf8d38;
      // 089: if_acmpeq 09e
      // 08c: goto 090
      // 08f: athrow
      // 090: aload 0
      // 091: invokevirtual x/ocbce5ea28a3.C ()V
      // 094: aload 0
      // 095: aload 1
      // 096: aload 3
      // 097: invokevirtual x/ocbce5ea28a3.ʑ (Lx/oc7ebeda7e63;Lnet/minecraft/client/entity/EntityPlayerSP;)V
      // 09a: goto 09e
      // 09d: athrow
      // 09e: aload 0
      // 09f: getfield x/ocbce5ea28a3.Ǚ Lx/oc668fce0dbf;
      // 0a2: invokevirtual x/oc668fce0dbf.Ѥ ()V
      // 0a5: return
      // 0a6: aload 0
      // 0a7: iload 2
      // 0a8: ifne 0ff
      // 0ab: getfield x/ocbce5ea28a3.Ш Lx/occ00ef6c188;
      // 0ae: ifnull 0fe
      // 0b1: goto 0b5
      // 0b4: athrow
      // 0b5: aload 0
      // 0b6: aload 0
      // 0b7: iload 2
      // 0b8: ifne 108
      // 0bb: goto 0bf
      // 0be: athrow
      // 0bf: getfield x/ocbce5ea28a3.Ш Lx/occ00ef6c188;
      // 0c2: getfield x/occ00ef6c188.Ÿ Lx/oc847503a8ab;
      // 0c5: getfield x/oc847503a8ab.ß Lx/oc1a421bd3db;
      // 0c8: invokevirtual x/ocbce5ea28a3.р (Lx/oc1a421bd3db;)Z
      // 0cb: ifne 0fe
      // 0ce: goto 0d2
      // 0d1: athrow
      // 0d2: aload 0
      // 0d3: iload 2
      // 0d4: ifne 0f7
      // 0d7: goto 0db
      // 0da: athrow
      // 0db: invokevirtual x/ocbce5ea28a3.C ()V
      // 0de: aload 0
      // 0df: getfield x/ocbce5ea28a3.Ѻ Lx/oc65fedf8d38;
      // 0e2: getstatic x/oc65fedf8d38.Ό Lx/oc65fedf8d38;
      // 0e5: if_acmpne 0f6
      // 0e8: goto 0ec
      // 0eb: athrow
      // 0ec: aload 0
      // 0ed: aload 1
      // 0ee: aload 3
      // 0ef: invokevirtual x/ocbce5ea28a3.ʑ (Lx/oc7ebeda7e63;Lnet/minecraft/client/entity/EntityPlayerSP;)V
      // 0f2: goto 0f6
      // 0f5: athrow
      // 0f6: aload 0
      // 0f7: getfield x/ocbce5ea28a3.Ǚ Lx/oc668fce0dbf;
      // 0fa: invokevirtual x/oc668fce0dbf.Ѥ ()V
      // 0fd: return
      // 0fe: aload 0
      // 0ff: iload 2
      // 100: ifne 127
      // 103: aload 0
      // 104: goto 108
      // 107: athrow
      // 108: getfield x/ocbce5ea28a3.ϯ J
      // 10b: invokevirtual x/ocbce5ea28a3.œ (J)Z
      // 10e: ifeq 119
      // 111: aload 0
      // 112: invokevirtual x/ocbce5ea28a3.C ()V
      // 115: goto 119
      // 118: athrow
      // 119: aload 0
      // 11a: iload 2
      // 11b: ifne 153
      // 11e: aload 3
      // 11f: invokevirtual x/ocbce5ea28a3.Ø (Lnet/minecraft/client/entity/EntityPlayerSP;)V
      // 122: aload 0
      // 123: goto 127
      // 126: athrow
      // 127: getfield x/ocbce5ea28a3.Ш Lx/occ00ef6c188;
      // 12a: ifnull 152
      // 12d: aload 0
      // 12e: aload 1
      // 12f: aload 0
      // 130: getfield x/ocbce5ea28a3.Ш Lx/occ00ef6c188;
      // 133: getfield x/occ00ef6c188.Ÿ Lx/oc847503a8ab;
      // 136: getfield x/oc847503a8ab.Ψ F
      // 139: aload 0
      // 13a: getfield x/ocbce5ea28a3.Ш Lx/occ00ef6c188;
      // 13d: getfield x/occ00ef6c188.Ÿ Lx/oc847503a8ab;
      // 140: getfield x/oc847503a8ab.ʌ F
      // 143: invokestatic x/oc3458eda443.ƹ (FF)Lx/oc3458eda443;
      // 146: invokevirtual x/ocbce5ea28a3.Ƨ (Lx/oc7ebeda7e63;Lx/oc3458eda443;)V
      // 149: aload 0
      // 14a: getfield x/ocbce5ea28a3.Ǚ Lx/oc668fce0dbf;
      // 14d: invokevirtual x/oc668fce0dbf.Ѥ ()V
      // 150: return
      // 151: athrow
      // 152: aload 0
      // 153: getfield x/ocbce5ea28a3.Ѻ Lx/oc65fedf8d38;
      // 156: iload 2
      // 157: ifne 182
      // 15a: getstatic x/oc65fedf8d38.Ό Lx/oc65fedf8d38;
      // 15d: if_acmpne 172
      // 160: goto 164
      // 163: athrow
      // 164: aload 0
      // 165: aload 1
      // 166: aload 3
      // 167: invokevirtual x/ocbce5ea28a3.ʑ (Lx/oc7ebeda7e63;Lnet/minecraft/client/entity/EntityPlayerSP;)V
      // 16a: iload 2
      // 16b: ifeq 31e
      // 16e: goto 172
      // 171: athrow
      // 172: aload 0
      // 173: iload 2
      // 174: ifne 1a3
      // 177: goto 17b
      // 17a: athrow
      // 17b: getfield x/ocbce5ea28a3.Ѻ Lx/oc65fedf8d38;
      // 17e: goto 182
      // 181: athrow
      // 182: getstatic x/oc65fedf8d38.Ǯ Lx/oc65fedf8d38;
      // 185: if_acmpeq 19e
      // 188: aload 0
      // 189: getfield x/ocbce5ea28a3.Ѻ Lx/oc65fedf8d38;
      // 18c: iload 2
      // 18d: ifne 1f2
      // 190: goto 194
      // 193: athrow
      // 194: getstatic x/oc65fedf8d38.И Lx/oc65fedf8d38;
      // 197: if_acmpne 1ea
      // 19a: goto 19e
      // 19d: athrow
      // 19e: aload 0
      // 19f: goto 1a3
      // 1a2: athrow
      // 1a3: aload 1
      // 1a4: aload 0
      // 1a5: iload 2
      // 1a6: ifne 1bc
      // 1a9: getfield x/ocbce5ea28a3.ҽ Lx/oc30b42710ad;
      // 1ac: ifnonnull 1bb
      // 1af: goto 1b3
      // 1b2: athrow
      // 1b3: aload 3
      // 1b4: getfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 1b7: goto 1c2
      // 1ba: athrow
      // 1bb: aload 0
      // 1bc: getfield x/ocbce5ea28a3.ҽ Lx/oc30b42710ad;
      // 1bf: getfield x/oc30b42710ad.ϡ F
      // 1c2: aload 0
      // 1c3: iload 2
      // 1c4: ifne 1da
      // 1c7: getfield x/ocbce5ea28a3.ҽ Lx/oc30b42710ad;
      // 1ca: ifnonnull 1d9
      // 1cd: goto 1d1
      // 1d0: athrow
      // 1d1: aload 3
      // 1d2: getfield net/minecraft/client/entity/EntityPlayerSP.rotationPitch F
      // 1d5: goto 1e0
      // 1d8: athrow
      // 1d9: aload 0
      // 1da: getfield x/ocbce5ea28a3.ҽ Lx/oc30b42710ad;
      // 1dd: getfield x/oc30b42710ad.ш F
      // 1e0: invokestatic x/oc3458eda443.ƹ (FF)Lx/oc3458eda443;
      // 1e3: invokevirtual x/ocbce5ea28a3.Ƨ (Lx/oc7ebeda7e63;Lx/oc3458eda443;)V
      // 1e6: iload 2
      // 1e7: ifeq 31e
      // 1ea: aload 0
      // 1eb: getfield x/ocbce5ea28a3.Ѻ Lx/oc65fedf8d38;
      // 1ee: goto 1f2
      // 1f1: athrow
      // 1f2: iload 2
      // 1f3: ifne 304
      // 1f6: getstatic x/oc65fedf8d38.ė Lx/oc65fedf8d38;
      // 1f9: if_acmpne 2f4
      // 1fc: goto 200
      // 1ff: athrow
      // 200: aload 0
      // 201: iload 2
      // 202: ifne 2bd
      // 205: goto 209
      // 208: athrow
      // 209: aload 3
      // 20a: invokevirtual x/ocbce5ea28a3.Ŷ (Lnet/minecraft/client/entity/EntityPlayerSP;)V
      // 20d: aload 0
      // 20e: getfield x/ocbce5ea28a3.Ƕ Lx/oc1a421bd3db;
      // 211: ifnull 2b8
      // 214: goto 218
      // 217: athrow
      // 218: aload 0
      // 219: iload 2
      // 21a: ifne 255
      // 21d: goto 221
      // 220: athrow
      // 221: getfield x/ocbce5ea28a3.Ղ Lx/oc847503a8ab;
      // 224: aload 0
      // 225: getfield x/ocbce5ea28a3.Ƕ Lx/oc1a421bd3db;
      // 228: invokestatic x/ocbce5ea28a3.Ά (Lx/oc847503a8ab;Lx/oc1a421bd3db;)Z
      // 22b: ifeq 250
      // 22e: goto 232
      // 231: athrow
      // 232: aload 0
      // 233: aload 1
      // 234: aload 0
      // 235: getfield x/ocbce5ea28a3.Ղ Lx/oc847503a8ab;
      // 238: getfield x/oc847503a8ab.Ψ F
      // 23b: aload 0
      // 23c: getfield x/ocbce5ea28a3.Ղ Lx/oc847503a8ab;
      // 23f: getfield x/oc847503a8ab.ʌ F
      // 242: invokestatic x/oc3458eda443.ƹ (FF)Lx/oc3458eda443;
      // 245: invokevirtual x/ocbce5ea28a3.Ƨ (Lx/oc7ebeda7e63;Lx/oc3458eda443;)V
      // 248: iload 2
      // 249: ifeq 31e
      // 24c: goto 250
      // 24f: athrow
      // 250: aload 0
      // 251: goto 255
      // 254: athrow
      // 255: aload 0
      // 256: getfield x/ocbce5ea28a3.Ƕ Lx/oc1a421bd3db;
      // 259: aload 0
      // 25a: aload 3
      // 25b: invokevirtual x/ocbce5ea28a3.Τ (Lnet/minecraft/client/entity/EntityPlayerSP;)Lx/oceb39b7deb2;
      // 25e: aload 0
      // 25f: aload 3
      // 260: ldc_w -1310184868
      // 263: ldc_w -1310184866
      // 266: ixor
      // 267: invokevirtual x/ocbce5ea28a3.Ė (Lnet/minecraft/client/entity/EntityPlayerSP;I)Lx/oceb39b7deb2;
      // 26a: aload 0
      // 26b: aload 3
      // 26c: invokevirtual x/ocbce5ea28a3.ԥ (Lnet/minecraft/client/entity/EntityPlayerSP;)F
      // 26f: aload 0
      // 270: aload 3
      // 271: invokevirtual x/ocbce5ea28a3.Ľ (Lnet/minecraft/client/entity/EntityPlayerSP;)F
      // 274: aload 0
      // 275: getfield x/ocbce5ea28a3.Ӭ F
      // 278: invokevirtual x/ocbce5ea28a3.Ϥ (Lx/oc1a421bd3db;Lx/oceb39b7deb2;Lx/oceb39b7deb2;FFF)Lx/oc3ab56105e0;
      // 27b: astore 4
      // 27d: aload 4
      // 27f: ifnull 2aa
      // 282: aload 0
      // 283: aload 3
      // 284: invokevirtual x/ocbce5ea28a3.ԥ (Lnet/minecraft/client/entity/EntityPlayerSP;)F
      // 287: aload 0
      // 288: aload 3
      // 289: invokevirtual x/ocbce5ea28a3.Ľ (Lnet/minecraft/client/entity/EntityPlayerSP;)F
      // 28c: aload 4
      // 28e: getfield x/oc3ab56105e0.Ώ F
      // 291: aload 4
      // 293: getfield x/oc3ab56105e0.ǉ F
      // 296: aload 0
      // 297: invokevirtual x/ocbce5ea28a3.Щ ()F
      // 29a: invokestatic x/ocbce5ea28a3.ʟ (FFFFF)Lx/oc3458eda443;
      // 29d: astore 5
      // 29f: iload 2
      // 2a0: aload 0
      // 2a1: aload 1
      // 2a2: aload 5
      // 2a4: invokevirtual x/ocbce5ea28a3.Ƨ (Lx/oc7ebeda7e63;Lx/oc3458eda443;)V
      // 2a7: ifeq 2b4
      // 2aa: aload 0
      // 2ab: aload 1
      // 2ac: aload 3
      // 2ad: invokevirtual x/ocbce5ea28a3.ѱ (Lx/oc7ebeda7e63;Lnet/minecraft/client/entity/EntityPlayerSP;)V
      // 2b0: goto 2b4
      // 2b3: athrow
      // 2b4: iload 2
      // 2b5: ifeq 31e
      // 2b8: aload 0
      // 2b9: goto 2bd
      // 2bc: athrow
      // 2bd: iload 2
      // 2be: ifne 2eb
      // 2c1: getfield x/ocbce5ea28a3.Ժ Z
      // 2c4: bipush 0
      // 2c5: aload 0
      // 2c6: aload 3
      // 2c7: invokevirtual x/ocbce5ea28a3.â (Lnet/minecraft/client/entity/EntityPlayerSP;)Z
      // 2ca: invokestatic x/ocbce5ea28a3.ɬ (ZZZ)Z
      // 2cd: ifeq 2e6
      // 2d0: goto 2d4
      // 2d3: athrow
      // 2d4: aload 0
      // 2d5: invokevirtual x/ocbce5ea28a3.Ǆ ()V
      // 2d8: iload 2
      // 2d9: aload 0
      // 2da: aload 1
      // 2db: aload 3
      // 2dc: invokevirtual x/ocbce5ea28a3.ʑ (Lx/oc7ebeda7e63;Lnet/minecraft/client/entity/EntityPlayerSP;)V
      // 2df: ifeq 31e
      // 2e2: goto 2e6
      // 2e5: athrow
      // 2e6: aload 0
      // 2e7: goto 2eb
      // 2ea: athrow
      // 2eb: aload 1
      // 2ec: aload 3
      // 2ed: invokevirtual x/ocbce5ea28a3.ѱ (Lx/oc7ebeda7e63;Lnet/minecraft/client/entity/EntityPlayerSP;)V
      // 2f0: iload 2
      // 2f1: ifeq 31e
      // 2f4: aload 0
      // 2f5: iload 2
      // 2f6: ifne 31f
      // 2f9: goto 2fd
      // 2fc: athrow
      // 2fd: getfield x/ocbce5ea28a3.Ѻ Lx/oc65fedf8d38;
      // 300: goto 304
      // 303: athrow
      // 304: getstatic x/oc65fedf8d38.В Lx/oc65fedf8d38;
      // 307: if_acmpne 31e
      // 30a: aload 0
      // 30b: aload 1
      // 30c: aload 0
      // 30d: getfield x/ocbce5ea28a3.ɞ F
      // 310: aload 0
      // 311: getfield x/ocbce5ea28a3.Ӑ F
      // 314: invokestatic x/oc3458eda443.ƹ (FF)Lx/oc3458eda443;
      // 317: invokevirtual x/ocbce5ea28a3.Ƨ (Lx/oc7ebeda7e63;Lx/oc3458eda443;)V
      // 31a: goto 31e
      // 31d: athrow
      // 31e: aload 0
      // 31f: getfield x/ocbce5ea28a3.Ǚ Lx/oc668fce0dbf;
      // 322: invokevirtual x/oc668fce0dbf.Ѥ ()V
      // 325: return
   }

   void Յ(ocf242f30eaa param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: aload 0
      // 004: getfield x/ocbce5ea28a3.Ǚ Lx/oc668fce0dbf;
      // 007: invokevirtual x/oc668fce0dbf.ն ()Lnet/minecraft/client/entity/EntityPlayerSP;
      // 00a: astore 3
      // 00b: istore 2
      // 00c: aload 3
      // 00d: ifnull 018
      // 010: aload 1
      // 011: ifnonnull 01a
      // 014: goto 018
      // 017: athrow
      // 018: return
      // 019: athrow
      // 01a: aload 0
      // 01b: aload 3
      // 01c: invokevirtual x/ocbce5ea28a3.ʧ (Lnet/minecraft/client/entity/EntityPlayerSP;)Z
      // 01f: istore 4
      // 021: aload 0
      // 022: getfield x/ocbce5ea28a3.Ѻ Lx/oc65fedf8d38;
      // 025: getstatic x/oc65fedf8d38.ѻ Lx/oc65fedf8d38;
      // 028: if_acmpeq 040
      // 02b: iload 4
      // 02d: iload 2
      // 02e: ifne 03d
      // 031: goto 035
      // 034: athrow
      // 035: ifne 040
      // 038: goto 03c
      // 03b: athrow
      // 03c: bipush 1
      // 03d: goto 041
      // 040: bipush 0
      // 041: istore 5
      // 043: iload 5
      // 045: iload 2
      // 046: ifne 06e
      // 049: ifeq 06c
      // 04c: goto 050
      // 04f: athrow
      // 050: aload 0
      // 051: getfield x/ocbce5ea28a3.Ƭ Z
      // 054: iload 2
      // 055: ifne 06e
      // 058: goto 05c
      // 05b: athrow
      // 05c: ifeq 06c
      // 05f: goto 063
      // 062: athrow
      // 063: aload 0
      // 064: aload 3
      // 065: invokevirtual x/ocbce5ea28a3.φ (Lnet/minecraft/client/entity/EntityPlayerSP;)V
      // 068: goto 06c
      // 06b: athrow
      // 06c: iload 5
      // 06e: ifeq 095
      // 071: aload 0
      // 072: iload 2
      // 073: ifne 089
      // 076: goto 07a
      // 079: athrow
      // 07a: getfield x/ocbce5ea28a3.ҽ Lx/oc30b42710ad;
      // 07d: ifnull 095
      // 080: goto 084
      // 083: athrow
      // 084: aload 0
      // 085: goto 089
      // 088: athrow
      // 089: getfield x/ocbce5ea28a3.ҽ Lx/oc30b42710ad;
      // 08c: getfield x/oc30b42710ad.ñ Lx/oceb7a9b9a85;
      // 08f: getfield x/oceb7a9b9a85.ē F
      // 092: goto 099
      // 095: aload 3
      // 096: getfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 099: fstore 6
      // 09b: iload 5
      // 09d: ifeq 0c1
      // 0a0: aload 0
      // 0a1: iload 2
      // 0a2: ifne 0b8
      // 0a5: goto 0a9
      // 0a8: athrow
      // 0a9: getfield x/ocbce5ea28a3.ҽ Lx/oc30b42710ad;
      // 0ac: ifnull 0c1
      // 0af: goto 0b3
      // 0b2: athrow
      // 0b3: aload 0
      // 0b4: goto 0b8
      // 0b7: athrow
      // 0b8: getfield x/ocbce5ea28a3.ҽ Lx/oc30b42710ad;
      // 0bb: getfield x/oc30b42710ad.ш F
      // 0be: goto 0c5
      // 0c1: aload 3
      // 0c2: getfield net/minecraft/client/entity/EntityPlayerSP.rotationPitch F
      // 0c5: fstore 7
      // 0c7: iload 5
      // 0c9: ifeq 0ed
      // 0cc: aload 0
      // 0cd: iload 2
      // 0ce: ifne 0ee
      // 0d1: goto 0d5
      // 0d4: athrow
      // 0d5: getfield x/ocbce5ea28a3.ҽ Lx/oc30b42710ad;
      // 0d8: ifnull 0ed
      // 0db: goto 0df
      // 0de: athrow
      // 0df: aload 0
      // 0e0: getfield x/ocbce5ea28a3.ҽ Lx/oc30b42710ad;
      // 0e3: getfield x/oc30b42710ad.ñ Lx/oceb7a9b9a85;
      // 0e6: getfield x/oceb7a9b9a85.Ƈ F
      // 0e9: goto 0f5
      // 0ec: athrow
      // 0ed: aload 0
      // 0ee: aload 1
      // 0ef: invokevirtual x/ocf242f30eaa.Α ()F
      // 0f2: invokevirtual x/ocbce5ea28a3.ո (F)F
      // 0f5: fstore 8
      // 0f7: iload 5
      // 0f9: ifeq 11d
      // 0fc: aload 0
      // 0fd: iload 2
      // 0fe: ifne 11e
      // 101: goto 105
      // 104: athrow
      // 105: getfield x/ocbce5ea28a3.ҽ Lx/oc30b42710ad;
      // 108: ifnull 11d
      // 10b: goto 10f
      // 10e: athrow
      // 10f: aload 0
      // 110: getfield x/ocbce5ea28a3.ҽ Lx/oc30b42710ad;
      // 113: getfield x/oc30b42710ad.ñ Lx/oceb7a9b9a85;
      // 116: getfield x/oceb7a9b9a85.Đ F
      // 119: goto 125
      // 11c: athrow
      // 11d: aload 0
      // 11e: aload 1
      // 11f: invokevirtual x/ocf242f30eaa.Υ ()F
      // 122: invokevirtual x/ocbce5ea28a3.S (F)F
      // 125: fstore 9
      // 127: iload 5
      // 129: iload 2
      // 12a: ifne 15a
      // 12d: ifeq 147
      // 130: goto 134
      // 133: athrow
      // 134: aload 0
      // 135: iload 2
      // 136: ifne 14c
      // 139: goto 13d
      // 13c: athrow
      // 13d: invokevirtual x/ocbce5ea28a3.ӎ ()Z
      // 140: ifne 15d
      // 143: goto 147
      // 146: athrow
      // 147: aload 0
      // 148: goto 14c
      // 14b: athrow
      // 14c: iload 2
      // 14d: ifne 164
      // 150: getfield x/ocbce5ea28a3.Ǚ Lx/oc668fce0dbf;
      // 153: invokevirtual x/oc668fce0dbf.Ƹ ()Z
      // 156: goto 15a
      // 159: athrow
      // 15a: ifeq 163
      // 15d: fconst_0
      // 15e: fstore 8
      // 160: fconst_0
      // 161: fstore 9
      // 163: aload 0
      // 164: iload 2
      // 165: ifne 177
      // 168: getfield x/ocbce5ea28a3.d Z
      // 16b: ifeq 17d
      // 16e: goto 172
      // 171: athrow
      // 172: aload 0
      // 173: goto 177
      // 176: athrow
      // 177: getfield x/ocbce5ea28a3.D F
      // 17a: goto 17f
      // 17d: fload 6
      // 17f: fstore 10
      // 181: aload 0
      // 182: getfield x/ocbce5ea28a3.Ѭ Lnet/minecraft/client/Minecraft;
      // 185: iload 2
      // 186: ifne 19b
      // 189: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 18c: ifnull 1b3
      // 18f: goto 193
      // 192: athrow
      // 193: aload 0
      // 194: getfield x/ocbce5ea28a3.Ѭ Lnet/minecraft/client/Minecraft;
      // 197: goto 19b
      // 19a: athrow
      // 19b: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 19e: getfield net/minecraft/client/settings/GameSettings.keyBindSneak Lnet/minecraft/client/settings/KeyBinding;
      // 1a1: invokestatic x/oc7ab2161b9f.ն (Lnet/minecraft/client/settings/KeyBinding;)Z
      // 1a4: iload 2
      // 1a5: ifne 1b0
      // 1a8: ifeq 1b3
      // 1ab: goto 1af
      // 1ae: athrow
      // 1af: bipush 1
      // 1b0: goto 1b4
      // 1b3: bipush 0
      // 1b4: istore 11
      // 1b6: aload 0
      // 1b7: new x/oc53b792ae32
      // 1ba: dup
      // 1bb: fload 6
      // 1bd: fload 7
      // 1bf: fload 10
      // 1c1: fload 8
      // 1c3: fload 9
      // 1c5: iload 11
      // 1c7: ifne 1d5
      // 1ca: aload 0
      // 1cb: getfield x/ocbce5ea28a3.Κ Z
      // 1ce: ifeq 1d9
      // 1d1: goto 1d5
      // 1d4: athrow
      // 1d5: bipush 1
      // 1d6: goto 1da
      // 1d9: bipush 0
      // 1da: aload 3
      // 1db: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isSprinting ()Z
      // 1de: invokespecial x/oc53b792ae32.<init> (FFFFFZZ)V
      // 1e1: putfield x/ocbce5ea28a3.è Lx/oc53b792ae32;
      // 1e4: iload 5
      // 1e6: iload 2
      // 1e7: ifne 223
      // 1ea: ifne 221
      // 1ed: aload 0
      // 1ee: getfield x/ocbce5ea28a3.ȷ Z
      // 1f1: iload 2
      // 1f2: ifne 223
      // 1f5: goto 1f9
      // 1f8: athrow
      // 1f9: ifeq 221
      // 1fc: goto 200
      // 1ff: athrow
      // 200: iload 11
      // 202: iload 2
      // 203: ifne 223
      // 206: goto 20a
      // 209: athrow
      // 20a: ifne 221
      // 20d: goto 211
      // 210: athrow
      // 211: aload 1
      // 212: fload 8
      // 214: invokevirtual x/ocf242f30eaa.ў (F)V
      // 217: aload 1
      // 218: fload 9
      // 21a: invokevirtual x/ocf242f30eaa.I (F)V
      // 21d: goto 221
      // 220: athrow
      // 221: iload 5
      // 223: iload 2
      // 224: ifne 298
      // 227: ifeq 289
      // 22a: goto 22e
      // 22d: athrow
      // 22e: aload 0
      // 22f: iload 2
      // 230: ifne 28a
      // 233: goto 237
      // 236: athrow
      // 237: getfield x/ocbce5ea28a3.d Z
      // 23a: ifeq 289
      // 23d: goto 241
      // 240: athrow
      // 241: fload 6
      // 243: fload 10
      // 245: fload 8
      // 247: fload 9
      // 249: iload 11
      // 24b: iload 2
      // 24c: ifne 26e
      // 24f: goto 253
      // 252: athrow
      // 253: ifne 26d
      // 256: goto 25a
      // 259: athrow
      // 25a: aload 0
      // 25b: getfield x/ocbce5ea28a3.Κ Z
      // 25e: iload 2
      // 25f: ifne 26e
      // 262: goto 266
      // 265: athrow
      // 266: ifeq 271
      // 269: goto 26d
      // 26c: athrow
      // 26d: bipush 1
      // 26e: goto 272
      // 271: bipush 0
      // 272: invokestatic x/oc7beea7ccff.p (FFFFZ)Lx/oc1c4f5dd176;
      // 275: astore 12
      // 277: aload 1
      // 278: aload 12
      // 27a: getfield x/oc1c4f5dd176.ˠ F
      // 27d: invokevirtual x/ocf242f30eaa.ў (F)V
      // 280: aload 1
      // 281: aload 12
      // 283: getfield x/oc1c4f5dd176.ô F
      // 286: invokevirtual x/ocf242f30eaa.I (F)V
      // 289: aload 0
      // 28a: iload 2
      // 28b: ifne 2aa
      // 28e: getfield x/ocbce5ea28a3.Ǚ Lx/oc668fce0dbf;
      // 291: invokevirtual x/oc668fce0dbf.Ƹ ()Z
      // 294: goto 298
      // 297: athrow
      // 298: ifeq 2a9
      // 29b: aload 1
      // 29c: fconst_0
      // 29d: invokevirtual x/ocf242f30eaa.ў (F)V
      // 2a0: aload 1
      // 2a1: fconst_0
      // 2a2: invokevirtual x/ocf242f30eaa.I (F)V
      // 2a5: goto 2a9
      // 2a8: athrow
      // 2a9: aload 0
      // 2aa: invokevirtual x/ocbce5ea28a3.ã ()Z
      // 2ad: ifeq 2b8
      // 2b0: aload 1
      // 2b1: invokestatic x/ocbce5ea28a3.ǎ (Lx/ocf242f30eaa;)V
      // 2b4: goto 2b8
      // 2b7: athrow
      // 2b8: return
   }

   void Ӯ(ocf242f30eaa param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: istore 2
      // 004: aload 0
      // 005: iload 2
      // 006: ifne 018
      // 009: invokevirtual x/ocbce5ea28a3.ǔ ()Z
      // 00c: ifne 01c
      // 00f: goto 013
      // 012: athrow
      // 013: aload 0
      // 014: goto 018
      // 017: athrow
      // 018: invokevirtual x/ocbce5ea28a3.ϔ ()V
      // 01b: return
      // 01c: aload 1
      // 01d: ifnonnull 022
      // 020: return
      // 021: athrow
      // 022: aload 0
      // 023: getfield x/ocbce5ea28a3.Ǚ Lx/oc668fce0dbf;
      // 026: invokevirtual x/oc668fce0dbf.ն ()Lnet/minecraft/client/entity/EntityPlayerSP;
      // 029: astore 3
      // 02a: aload 0
      // 02b: iload 2
      // 02c: ifne 04b
      // 02f: getfield x/ocbce5ea28a3.Ǚ Lx/oc668fce0dbf;
      // 032: invokevirtual x/oc668fce0dbf.Ƹ ()Z
      // 035: ifeq 04a
      // 038: goto 03c
      // 03b: athrow
      // 03c: aload 1
      // 03d: fconst_0
      // 03e: invokevirtual x/ocf242f30eaa.ў (F)V
      // 041: aload 1
      // 042: fconst_0
      // 043: invokevirtual x/ocf242f30eaa.I (F)V
      // 046: goto 04a
      // 049: athrow
      // 04a: aload 0
      // 04b: iload 2
      // 04c: ifne 05e
      // 04f: getfield x/ocbce5ea28a3.è Lx/oc53b792ae32;
      // 052: ifnull 064
      // 055: goto 059
      // 058: athrow
      // 059: aload 0
      // 05a: goto 05e
      // 05d: athrow
      // 05e: getfield x/ocbce5ea28a3.è Lx/oc53b792ae32;
      // 061: goto 09e
      // 064: new x/oc53b792ae32
      // 067: dup
      // 068: aload 3
      // 069: getfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 06c: aload 3
      // 06d: getfield net/minecraft/client/entity/EntityPlayerSP.rotationPitch F
      // 070: aload 0
      // 071: aload 3
      // 072: invokevirtual x/ocbce5ea28a3.Ӏ (Lnet/minecraft/client/entity/EntityPlayerSP;)F
      // 075: aload 1
      // 076: invokevirtual x/ocf242f30eaa.Α ()F
      // 079: aload 1
      // 07a: invokevirtual x/ocf242f30eaa.Υ ()F
      // 07d: aload 3
      // 07e: getfield net/minecraft/client/entity/EntityPlayerSP.movementInput Lnet/minecraft/util/MovementInput;
      // 081: ifnull 096
      // 084: aload 3
      // 085: getfield net/minecraft/client/entity/EntityPlayerSP.movementInput Lnet/minecraft/util/MovementInput;
      // 088: getfield net/minecraft/util/MovementInput.sneak Z
      // 08b: ifeq 096
      // 08e: goto 092
      // 091: athrow
      // 092: bipush 1
      // 093: goto 097
      // 096: bipush 0
      // 097: aload 3
      // 098: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isSprinting ()Z
      // 09b: invokespecial x/oc53b792ae32.<init> (FFFFFZZ)V
      // 09e: astore 4
      // 0a0: aload 0
      // 0a1: aconst_null
      // 0a2: putfield x/ocbce5ea28a3.è Lx/oc53b792ae32;
      // 0a5: aload 1
      // 0a6: iload 2
      // 0a7: ifne 0ba
      // 0aa: invokevirtual x/oc68d6b191af.isCanceled ()Z
      // 0ad: ifeq 0b9
      // 0b0: goto 0b4
      // 0b3: athrow
      // 0b4: fconst_0
      // 0b5: goto 0bd
      // 0b8: athrow
      // 0b9: aload 1
      // 0ba: invokevirtual x/ocf242f30eaa.Α ()F
      // 0bd: fstore 5
      // 0bf: aload 1
      // 0c0: iload 2
      // 0c1: ifne 0d4
      // 0c4: invokevirtual x/oc68d6b191af.isCanceled ()Z
      // 0c7: ifeq 0d3
      // 0ca: goto 0ce
      // 0cd: athrow
      // 0ce: fconst_0
      // 0cf: goto 0d7
      // 0d2: athrow
      // 0d3: aload 1
      // 0d4: invokevirtual x/ocf242f30eaa.Υ ()F
      // 0d7: fstore 6
      // 0d9: iload 2
      // 0da: aload 0
      // 0db: new x/oceb7a9b9a85
      // 0de: dup
      // 0df: aload 4
      // 0e1: getfield x/oc53b792ae32.ɇ F
      // 0e4: aload 4
      // 0e6: getfield x/oc53b792ae32.Ъ F
      // 0e9: aload 4
      // 0eb: getfield x/oc53b792ae32.ѧ F
      // 0ee: aload 4
      // 0f0: getfield x/oc53b792ae32.ȸ F
      // 0f3: fload 5
      // 0f5: fload 6
      // 0f7: aload 4
      // 0f9: getfield x/oc53b792ae32.Ļ Z
      // 0fc: aload 4
      // 0fe: getfield x/oc53b792ae32.ʶ Z
      // 101: invokespecial x/oceb7a9b9a85.<init> (FFFFFFZZ)V
      // 104: putfield x/ocbce5ea28a3.ն Lx/oceb7a9b9a85;
      // 107: ifne 158
      // 10a: aload 0
      // 10b: invokevirtual x/ocbce5ea28a3.ã ()Z
      // 10e: ifeq 153
      // 111: goto 115
      // 114: athrow
      // 115: aload 1
      // 116: invokestatic x/ocbce5ea28a3.ǎ (Lx/ocf242f30eaa;)V
      // 119: aload 0
      // 11a: new x/oceb7a9b9a85
      // 11d: dup
      // 11e: aload 4
      // 120: getfield x/oc53b792ae32.ɇ F
      // 123: aload 4
      // 125: getfield x/oc53b792ae32.Ъ F
      // 128: aload 4
      // 12a: getfield x/oc53b792ae32.ѧ F
      // 12d: aload 4
      // 12f: getfield x/oc53b792ae32.ȸ F
      // 132: fconst_0
      // 133: fconst_0
      // 134: aload 4
      // 136: getfield x/oc53b792ae32.Ļ Z
      // 139: bipush 0
      // 13a: invokespecial x/oceb7a9b9a85.<init> (FFFFFFZZ)V
      // 13d: putfield x/ocbce5ea28a3.ն Lx/oceb7a9b9a85;
      // 140: aload 0
      // 141: dup
      // 142: getfield x/ocbce5ea28a3.φ I
      // 145: bipush 1
      // 146: iadd
      // 147: putfield x/ocbce5ea28a3.φ I
      // 14a: aload 3
      // 14b: bipush 0
      // 14c: invokevirtual net/minecraft/client/entity/EntityPlayerSP.setSprinting (Z)V
      // 14f: goto 153
      // 152: athrow
      // 153: aload 0
      // 154: bipush 0
      // 155: putfield x/ocbce5ea28a3.Κ Z
      // 158: aload 0
      // 159: aload 3
      // 15a: invokevirtual x/ocbce5ea28a3.ʧ (Lnet/minecraft/client/entity/EntityPlayerSP;)Z
      // 15d: istore 7
      // 15f: aload 0
      // 160: getfield x/ocbce5ea28a3.Ѻ Lx/oc65fedf8d38;
      // 163: iload 2
      // 164: ifne 203
      // 167: getstatic x/oc65fedf8d38.ė Lx/oc65fedf8d38;
      // 16a: if_acmpne 1f7
      // 16d: goto 171
      // 170: athrow
      // 171: aload 0
      // 172: iload 2
      // 173: ifne 1f8
      // 176: goto 17a
      // 179: athrow
      // 17a: getfield x/ocbce5ea28a3.Ղ Lx/oc847503a8ab;
      // 17d: ifnull 1f7
      // 180: goto 184
      // 183: athrow
      // 184: aload 0
      // 185: iload 2
      // 186: ifne 1f8
      // 189: goto 18d
      // 18c: athrow
      // 18d: getfield x/ocbce5ea28a3.Ƕ Lx/oc1a421bd3db;
      // 190: ifnull 1f7
      // 193: goto 197
      // 196: athrow
      // 197: aload 0
      // 198: iload 2
      // 199: ifne 1f8
      // 19c: goto 1a0
      // 19f: athrow
      // 1a0: getfield x/ocbce5ea28a3.Ղ Lx/oc847503a8ab;
      // 1a3: getfield x/oc847503a8ab.ß Lx/oc1a421bd3db;
      // 1a6: aload 0
      // 1a7: getfield x/ocbce5ea28a3.Ƕ Lx/oc1a421bd3db;
      // 1aa: invokevirtual x/oc1a421bd3db.equals (Ljava/lang/Object;)Z
      // 1ad: ifeq 1f7
      // 1b0: goto 1b4
      // 1b3: athrow
      // 1b4: aload 0
      // 1b5: iload 2
      // 1b6: ifne 1f8
      // 1b9: goto 1bd
      // 1bc: athrow
      // 1bd: getfield x/ocbce5ea28a3.ɹ Lx/oc981d71de6a;
      // 1c0: ifnonnull 1f7
      // 1c3: goto 1c7
      // 1c6: athrow
      // 1c7: aload 0
      // 1c8: iload 2
      // 1c9: ifne 1f8
      // 1cc: goto 1d0
      // 1cf: athrow
      // 1d0: getfield x/ocbce5ea28a3.Ш Lx/occ00ef6c188;
      // 1d3: ifnonnull 1f7
      // 1d6: goto 1da
      // 1d9: athrow
      // 1da: aload 0
      // 1db: iload 2
      // 1dc: ifne 1f8
      // 1df: goto 1e3
      // 1e2: athrow
      // 1e3: aload 3
      // 1e4: invokevirtual x/ocbce5ea28a3.Չ (Lnet/minecraft/client/entity/EntityPlayerSP;)Z
      // 1e7: ifeq 1f7
      // 1ea: goto 1ee
      // 1ed: athrow
      // 1ee: aload 0
      // 1ef: aload 3
      // 1f0: invokevirtual x/ocbce5ea28a3.ƨ (Lnet/minecraft/client/entity/EntityPlayerSP;)V
      // 1f3: goto 1f7
      // 1f6: athrow
      // 1f7: aload 0
      // 1f8: iload 2
      // 1f9: ifne 282
      // 1fc: getfield x/ocbce5ea28a3.Ѻ Lx/oc65fedf8d38;
      // 1ff: goto 203
      // 202: athrow
      // 203: getstatic x/oc65fedf8d38.ѻ Lx/oc65fedf8d38;
      // 206: if_acmpeq 281
      // 209: iload 7
      // 20b: iload 2
      // 20c: ifne 222
      // 20f: goto 213
      // 212: athrow
      // 213: ifne 281
      // 216: goto 21a
      // 219: athrow
      // 21a: aload 3
      // 21b: getfield net/minecraft/client/entity/EntityPlayerSP.onGround Z
      // 21e: goto 222
      // 221: athrow
      // 222: iload 2
      // 223: ifne 240
      // 226: ifeq 281
      // 229: goto 22d
      // 22c: athrow
      // 22d: aload 0
      // 22e: iload 2
      // 22f: ifne 282
      // 232: goto 236
      // 235: athrow
      // 236: getfield x/ocbce5ea28a3.ն Lx/oceb7a9b9a85;
      // 239: invokevirtual x/oceb7a9b9a85.ё ()Z
      // 23c: goto 240
      // 23f: athrow
      // 240: ifeq 281
      // 243: aload 0
      // 244: aload 3
      // 245: invokevirtual x/ocbce5ea28a3.Ę (Lnet/minecraft/client/entity/EntityPlayerSP;)Lnet/minecraft/util/BlockPos;
      // 248: astore 8
      // 24a: aload 8
      // 24c: ifnull 277
      // 24f: aload 0
      // 250: iload 2
      // 251: ifne 27c
      // 254: goto 258
      // 257: athrow
      // 258: aload 3
      // 259: aload 0
      // 25a: getfield x/ocbce5ea28a3.ն Lx/oceb7a9b9a85;
      // 25d: invokevirtual x/ocbce5ea28a3.Ǘ (Lnet/minecraft/client/entity/EntityPlayerSP;Lx/oceb7a9b9a85;)Z
      // 260: ifeq 277
      // 263: goto 267
      // 266: athrow
      // 267: aload 0
      // 268: aload 1
      // 269: aload 4
      // 26b: aload 3
      // 26c: invokevirtual x/ocbce5ea28a3.и (Lx/ocf242f30eaa;Lx/oc53b792ae32;Lnet/minecraft/client/entity/EntityPlayerSP;)V
      // 26f: iload 2
      // 270: ifeq 280
      // 273: goto 277
      // 276: athrow
      // 277: aload 0
      // 278: goto 27c
      // 27b: athrow
      // 27c: aload 3
      // 27d: invokevirtual x/ocbce5ea28a3.Ό (Lnet/minecraft/client/entity/EntityPlayerSP;)V
      // 280: return
      // 281: aload 0
      // 282: iload 2
      // 283: ifne 2ac
      // 286: getfield x/ocbce5ea28a3.Ѻ Lx/oc65fedf8d38;
      // 289: getstatic x/oc65fedf8d38.ѻ Lx/oc65fedf8d38;
      // 28c: if_acmpeq 2ab
      // 28f: goto 293
      // 292: athrow
      // 293: iload 7
      // 295: iload 2
      // 296: ifne 2b2
      // 299: goto 29d
      // 29c: athrow
      // 29d: ifne 2ab
      // 2a0: goto 2a4
      // 2a3: athrow
      // 2a4: aload 0
      // 2a5: aload 3
      // 2a6: invokevirtual x/ocbce5ea28a3.Ό (Lnet/minecraft/client/entity/EntityPlayerSP;)V
      // 2a9: return
      // 2aa: athrow
      // 2ab: aload 0
      // 2ac: getfield x/ocbce5ea28a3.Ѻ Lx/oc65fedf8d38;
      // 2af: invokestatic x/ocbce5ea28a3.Т (Lx/oc65fedf8d38;)Z
      // 2b2: iload 2
      // 2b3: ifne 2cf
      // 2b6: ifne 2ce
      // 2b9: goto 2bd
      // 2bc: athrow
      // 2bd: iload 7
      // 2bf: iload 2
      // 2c0: ifne 2cf
      // 2c3: goto 2c7
      // 2c6: athrow
      // 2c7: ifeq 2d2
      // 2ca: goto 2ce
      // 2cd: athrow
      // 2ce: bipush 1
      // 2cf: goto 2d3
      // 2d2: bipush 0
      // 2d3: istore 8
      // 2d5: iload 8
      // 2d7: iload 2
      // 2d8: ifne 2ea
      // 2db: ifeq 313
      // 2de: goto 2e2
      // 2e1: athrow
      // 2e2: aload 3
      // 2e3: getfield net/minecraft/client/entity/EntityPlayerSP.onGround Z
      // 2e6: goto 2ea
      // 2e9: athrow
      // 2ea: ifeq 313
      // 2ed: aload 0
      // 2ee: iload 2
      // 2ef: ifne 305
      // 2f2: goto 2f6
      // 2f5: athrow
      // 2f6: getfield x/ocbce5ea28a3.ɹ Lx/oc981d71de6a;
      // 2f9: ifnonnull 313
      // 2fc: goto 300
      // 2ff: athrow
      // 300: aload 0
      // 301: goto 305
      // 304: athrow
      // 305: iload 2
      // 306: ifne 316
      // 309: getfield x/ocbce5ea28a3.Ш Lx/occ00ef6c188;
      // 30c: ifnull 315
      // 30f: goto 313
      // 312: athrow
      // 313: return
      // 314: athrow
      // 315: aload 0
      // 316: aload 3
      // 317: invokevirtual x/ocbce5ea28a3.Ę (Lnet/minecraft/client/entity/EntityPlayerSP;)Lnet/minecraft/util/BlockPos;
      // 31a: astore 9
      // 31c: aload 0
      // 31d: getfield x/ocbce5ea28a3.ն Lx/oceb7a9b9a85;
      // 320: invokevirtual x/oceb7a9b9a85.ё ()Z
      // 323: istore 10
      // 325: aload 0
      // 326: getfield x/ocbce5ea28a3.Ǚ Lx/oc668fce0dbf;
      // 329: invokevirtual x/oc668fce0dbf.ҵ ()Lnet/minecraft/item/ItemBlock;
      // 32c: ifnull 334
      // 32f: bipush 1
      // 330: goto 335
      // 333: athrow
      // 334: bipush 0
      // 335: istore 11
      // 337: aload 9
      // 339: ifnull 341
      // 33c: bipush 1
      // 33d: goto 342
      // 340: athrow
      // 341: bipush 0
      // 342: istore 12
      // 344: iload 10
      // 346: iload 2
      // 347: ifne 353
      // 34a: ifeq 37a
      // 34d: goto 351
      // 350: athrow
      // 351: iload 12
      // 353: iload 2
      // 354: ifne 36b
      // 357: ifeq 37a
      // 35a: goto 35e
      // 35d: athrow
      // 35e: aload 0
      // 35f: aload 3
      // 360: aload 0
      // 361: getfield x/ocbce5ea28a3.ն Lx/oceb7a9b9a85;
      // 364: invokevirtual x/ocbce5ea28a3.Ǘ (Lnet/minecraft/client/entity/EntityPlayerSP;Lx/oceb7a9b9a85;)Z
      // 367: goto 36b
      // 36a: athrow
      // 36b: iload 2
      // 36c: ifne 377
      // 36f: ifeq 37a
      // 372: goto 376
      // 375: athrow
      // 376: bipush 1
      // 377: goto 37b
      // 37a: bipush 0
      // 37b: istore 13
      // 37d: aload 0
      // 37e: getfield x/ocbce5ea28a3.ն Lx/oceb7a9b9a85;
      // 381: getfield x/oceb7a9b9a85.Ú Z
      // 384: istore 14
      // 386: aload 4
      // 388: getfield x/oc53b792ae32.ѧ F
      // 38b: aload 4
      // 38d: getfield x/oc53b792ae32.ȸ F
      // 390: invokestatic x/ocbce5ea28a3.ή (FF)Z
      // 393: istore 15
      // 395: aload 0
      // 396: invokevirtual x/ocbce5ea28a3.ț ()Z
      // 399: iload 2
      // 39a: ifne 3b8
      // 39d: ifne 3b7
      // 3a0: goto 3a4
      // 3a3: athrow
      // 3a4: aload 1
      // 3a5: invokevirtual x/ocf242f30eaa.ǡ ()Z
      // 3a8: iload 2
      // 3a9: ifne 3b8
      // 3ac: goto 3b0
      // 3af: athrow
      // 3b0: ifeq 3bb
      // 3b3: goto 3b7
      // 3b6: athrow
      // 3b7: bipush 1
      // 3b8: goto 3bc
      // 3bb: bipush 0
      // 3bc: iload 15
      // 3be: iload 12
      // 3c0: iload 11
      // 3c2: iload 14
      // 3c4: invokestatic x/ocbce5ea28a3.ȸ (ZZZZZ)Z
      // 3c7: istore 16
      // 3c9: aload 3
      // 3ca: getfield net/minecraft/client/entity/EntityPlayerSP.onGround Z
      // 3cd: iload 2
      // 3ce: ifne 44a
      // 3d1: ifeq 448
      // 3d4: goto 3d8
      // 3d7: athrow
      // 3d8: iload 8
      // 3da: iload 2
      // 3db: ifne 44a
      // 3de: goto 3e2
      // 3e1: athrow
      // 3e2: ifeq 448
      // 3e5: goto 3e9
      // 3e8: athrow
      // 3e9: iload 10
      // 3eb: iload 2
      // 3ec: ifne 44a
      // 3ef: goto 3f3
      // 3f2: athrow
      // 3f3: ifeq 448
      // 3f6: goto 3fa
      // 3f9: athrow
      // 3fa: iload 13
      // 3fc: iload 2
      // 3fd: ifne 44a
      // 400: goto 404
      // 403: athrow
      // 404: ifeq 448
      // 407: goto 40b
      // 40a: athrow
      // 40b: iload 12
      // 40d: iload 2
      // 40e: ifne 44a
      // 411: goto 415
      // 414: athrow
      // 415: ifeq 448
      // 418: goto 41c
      // 41b: athrow
      // 41c: iload 11
      // 41e: iload 2
      // 41f: ifne 44a
      // 422: goto 426
      // 425: athrow
      // 426: ifne 448
      // 429: goto 42d
      // 42c: athrow
      // 42d: iload 14
      // 42f: iload 2
      // 430: ifne 44a
      // 433: goto 437
      // 436: athrow
      // 437: ifne 448
      // 43a: goto 43e
      // 43d: athrow
      // 43e: aload 0
      // 43f: aload 1
      // 440: aload 4
      // 442: aload 3
      // 443: invokevirtual x/ocbce5ea28a3.и (Lx/ocf242f30eaa;Lx/oc53b792ae32;Lnet/minecraft/client/entity/EntityPlayerSP;)V
      // 446: return
      // 447: athrow
      // 448: iload 16
      // 44a: iload 2
      // 44b: ifne 47b
      // 44e: ifne 475
      // 451: goto 455
      // 454: athrow
      // 455: aload 3
      // 456: getfield net/minecraft/client/entity/EntityPlayerSP.onGround Z
      // 459: iload 2
      // 45a: ifne 47b
      // 45d: goto 461
      // 460: athrow
      // 461: iload 8
      // 463: iload 10
      // 465: iload 13
      // 467: iload 12
      // 469: iload 11
      // 46b: invokestatic x/ocbce5ea28a3.D (ZZZZZZ)Z
      // 46e: ifeq 486
      // 471: goto 475
      // 474: athrow
      // 475: iload 14
      // 477: goto 47b
      // 47a: athrow
      // 47b: iload 2
      // 47c: ifne 48f
      // 47f: ifeq 48d
      // 482: goto 486
      // 485: athrow
      // 486: aload 0
      // 487: aload 3
      // 488: invokevirtual x/ocbce5ea28a3.Ό (Lnet/minecraft/client/entity/EntityPlayerSP;)V
      // 48b: return
      // 48c: athrow
      // 48d: iload 7
      // 48f: ifeq 49a
      // 492: aload 0
      // 493: invokevirtual x/ocbce5ea28a3.º ()V
      // 496: goto 49a
      // 499: athrow
      // 49a: aload 0
      // 49b: aload 3
      // 49c: aload 4
      // 49e: aload 9
      // 4a0: iload 16
      // 4a2: ifeq 4ac
      // 4a5: getstatic x/oc23ff80be39.Ϡ Lx/oc23ff80be39;
      // 4a8: goto 4af
      // 4ab: athrow
      // 4ac: getstatic x/oc23ff80be39.Ǆ Lx/oc23ff80be39;
      // 4af: invokevirtual x/ocbce5ea28a3.ǳ (Lnet/minecraft/client/entity/EntityPlayerSP;Lx/oc53b792ae32;Lnet/minecraft/util/BlockPos;Lx/oc23ff80be39;)V
      // 4b2: aload 0
      // 4b3: iload 16
      // 4b5: ifeq 4c2
      // 4b8: aload 0
      // 4b9: aload 9
      // 4bb: invokevirtual x/ocbce5ea28a3.Έ (Lnet/minecraft/util/BlockPos;)Lx/oc1a421bd3db;
      // 4be: goto 4c3
      // 4c1: athrow
      // 4c2: aconst_null
      // 4c3: putfield x/ocbce5ea28a3.Ƕ Lx/oc1a421bd3db;
      // 4c6: iload 16
      // 4c8: iload 2
      // 4c9: ifne 4f6
      // 4cc: ifne 4f4
      // 4cf: goto 4d3
      // 4d2: athrow
      // 4d3: aload 0
      // 4d4: invokevirtual x/ocbce5ea28a3.ù ()Z
      // 4d7: iload 2
      // 4d8: ifne 4f6
      // 4db: goto 4df
      // 4de: athrow
      // 4df: ifne 4f4
      // 4e2: goto 4e6
      // 4e5: athrow
      // 4e6: aload 0
      // 4e7: invokevirtual x/ocbce5ea28a3.Μ ()V
      // 4ea: aload 0
      // 4eb: aload 1
      // 4ec: aload 4
      // 4ee: aload 3
      // 4ef: invokevirtual x/ocbce5ea28a3.и (Lx/ocf242f30eaa;Lx/oc53b792ae32;Lnet/minecraft/client/entity/EntityPlayerSP;)V
      // 4f2: return
      // 4f3: athrow
      // 4f4: iload 16
      // 4f6: iload 2
      // 4f7: ifne 518
      // 4fa: ifne 53d
      // 4fd: goto 501
      // 500: athrow
      // 501: aload 0
      // 502: iload 2
      // 503: ifne 53e
      // 506: goto 50a
      // 509: athrow
      // 50a: getfield x/ocbce5ea28a3.π D
      // 50d: aload 0
      // 50e: getfield x/ocbce5ea28a3.Ԅ D
      // 511: invokestatic x/ocbce5ea28a3.ŧ (DD)Z
      // 514: goto 518
      // 517: athrow
      // 518: ifeq 53d
      // 51b: aload 0
      // 51c: iload 2
      // 51d: ifne 53e
      // 520: goto 524
      // 523: athrow
      // 524: aload 3
      // 525: invokevirtual x/ocbce5ea28a3.Ɂ (Lnet/minecraft/client/entity/EntityPlayerSP;)Z
      // 528: ifne 53d
      // 52b: goto 52f
      // 52e: athrow
      // 52f: aload 0
      // 530: invokevirtual x/ocbce5ea28a3.Μ ()V
      // 533: aload 0
      // 534: aload 1
      // 535: aload 4
      // 537: aload 3
      // 538: invokevirtual x/ocbce5ea28a3.и (Lx/ocf242f30eaa;Lx/oc53b792ae32;Lnet/minecraft/client/entity/EntityPlayerSP;)V
      // 53b: return
      // 53c: athrow
      // 53d: aload 0
      // 53e: iload 2
      // 53f: ifne 560
      // 542: getfield x/ocbce5ea28a3.Ƕ Lx/oc1a421bd3db;
      // 545: ifnonnull 55b
      // 548: goto 54c
      // 54b: athrow
      // 54c: aload 0
      // 54d: getstatic x/oc06124119aa.ƌ Lx/oc06124119aa;
      // 550: putfield x/ocbce5ea28a3.ɓ Lx/oc06124119aa;
      // 553: iload 2
      // 554: ifeq 566
      // 557: goto 55b
      // 55a: athrow
      // 55b: aload 0
      // 55c: goto 560
      // 55f: athrow
      // 560: getstatic x/oc06124119aa.ί Lx/oc06124119aa;
      // 563: putfield x/ocbce5ea28a3.ɓ Lx/oc06124119aa;
      // 566: aload 0
      // 567: aload 0
      // 568: getfield x/ocbce5ea28a3.ϯ J
      // 56b: putfield x/ocbce5ea28a3.ќ J
      // 56e: aload 0
      // 56f: aconst_null
      // 570: putfield x/ocbce5ea28a3.Ղ Lx/oc847503a8ab;
      // 573: aload 0
      // 574: bipush 0
      // 575: putfield x/ocbce5ea28a3.Ժ Z
      // 578: aload 0
      // 579: iload 16
      // 57b: ifeq 585
      // 57e: getstatic x/oc23ff80be39.Ϡ Lx/oc23ff80be39;
      // 581: goto 588
      // 584: athrow
      // 585: getstatic x/oc23ff80be39.Ǆ Lx/oc23ff80be39;
      // 588: invokestatic x/ocbce5ea28a3.ƌ (Lx/oc23ff80be39;)Lx/oc65fedf8d38;
      // 58b: putfield x/ocbce5ea28a3.Ѻ Lx/oc65fedf8d38;
      // 58e: iload 2
      // 58f: ifne 5a6
      // 592: iload 16
      // 594: ifeq 5aa
      // 597: goto 59b
      // 59a: athrow
      // 59b: aload 0
      // 59c: aload 1
      // 59d: aload 4
      // 59f: invokevirtual x/ocbce5ea28a3.Ѯ (Lx/ocf242f30eaa;Lx/oc53b792ae32;)V
      // 5a2: goto 5a6
      // 5a5: athrow
      // 5a6: iload 2
      // 5a7: ifeq 5b5
      // 5aa: aload 0
      // 5ab: aload 1
      // 5ac: aload 4
      // 5ae: invokevirtual x/ocbce5ea28a3.α (Lx/ocf242f30eaa;Lx/oc53b792ae32;)V
      // 5b1: goto 5b5
      // 5b4: athrow
      // 5b5: aload 0
      // 5b6: iload 2
      // 5b7: ifne 5d1
      // 5ba: aload 3
      // 5bb: invokevirtual x/ocbce5ea28a3.Ό (Lnet/minecraft/client/entity/EntityPlayerSP;)V
      // 5be: aload 0
      // 5bf: getfield x/ocbce5ea28a3.Ͼ Lx/oc7cc5657deb;
      // 5c2: invokevirtual x/oc7cc5657deb.К ()Z
      // 5c5: ifne 5d4
      // 5c8: goto 5cc
      // 5cb: athrow
      // 5cc: aload 0
      // 5cd: goto 5d1
      // 5d0: athrow
      // 5d1: invokevirtual x/ocbce5ea28a3.C ()V
      // 5d4: return
   }

   boolean ȶ(boolean param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 2
      // 04: aload 0
      // 05: iload 2
      // 06: ifne 37
      // 09: getfield x/ocbce5ea28a3.ҽ Lx/oc30b42710ad;
      // 0c: ifnull 36
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: iload 2
      // 15: ifne 37
      // 18: goto 1c
      // 1b: athrow
      // 1c: getfield x/ocbce5ea28a3.ҽ Lx/oc30b42710ad;
      // 1f: getfield x/oc30b42710ad.Ň Lx/oc23ff80be39;
      // 22: getstatic x/oc23ff80be39.Ϡ Lx/oc23ff80be39;
      // 25: if_acmpne 36
      // 28: goto 2c
      // 2b: athrow
      // 2c: aload 0
      // 2d: getfield x/ocbce5ea28a3.Ͼ Lx/oc7cc5657deb;
      // 30: bipush 0
      // 31: invokevirtual x/oc7cc5657deb.F (Z)Z
      // 34: ireturn
      // 35: athrow
      // 36: aload 0
      // 37: getfield x/ocbce5ea28a3.Ͼ Lx/oc7cc5657deb;
      // 3a: iload 1
      // 3b: invokevirtual x/oc7cc5657deb.F (Z)Z
      // 3e: ireturn
   }

   void È(boolean param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 2
      // 04: aload 0
      // 05: iload 2
      // 06: ifne 2a
      // 09: getfield x/ocbce5ea28a3.ҽ Lx/oc30b42710ad;
      // 0c: ifnonnull 15
      // 0f: goto 13
      // 12: athrow
      // 13: return
      // 14: athrow
      // 15: aload 0
      // 16: iload 2
      // 17: ifne 35
      // 1a: aload 0
      // 1b: getfield x/ocbce5ea28a3.ҽ Lx/oc30b42710ad;
      // 1e: iload 1
      // 1f: invokevirtual x/oc30b42710ad.Ͱ (Z)Lx/oc30b42710ad;
      // 22: putfield x/ocbce5ea28a3.ҽ Lx/oc30b42710ad;
      // 25: aload 0
      // 26: goto 2a
      // 29: athrow
      // 2a: getfield x/ocbce5ea28a3.ն Lx/oceb7a9b9a85;
      // 2d: ifnull 71
      // 30: aload 0
      // 31: goto 35
      // 34: athrow
      // 35: new x/oceb7a9b9a85
      // 38: dup
      // 39: aload 0
      // 3a: getfield x/ocbce5ea28a3.ն Lx/oceb7a9b9a85;
      // 3d: getfield x/oceb7a9b9a85.ē F
      // 40: aload 0
      // 41: getfield x/ocbce5ea28a3.ն Lx/oceb7a9b9a85;
      // 44: getfield x/oceb7a9b9a85.ӥ F
      // 47: aload 0
      // 48: getfield x/ocbce5ea28a3.ն Lx/oceb7a9b9a85;
      // 4b: getfield x/oceb7a9b9a85.Ƈ F
      // 4e: aload 0
      // 4f: getfield x/ocbce5ea28a3.ն Lx/oceb7a9b9a85;
      // 52: getfield x/oceb7a9b9a85.Đ F
      // 55: aload 0
      // 56: getfield x/ocbce5ea28a3.ն Lx/oceb7a9b9a85;
      // 59: getfield x/oceb7a9b9a85.λ F
      // 5c: aload 0
      // 5d: getfield x/ocbce5ea28a3.ն Lx/oceb7a9b9a85;
      // 60: getfield x/oceb7a9b9a85.ӄ F
      // 63: aload 0
      // 64: getfield x/ocbce5ea28a3.ն Lx/oceb7a9b9a85;
      // 67: getfield x/oceb7a9b9a85.Ú Z
      // 6a: iload 1
      // 6b: invokespecial x/oceb7a9b9a85.<init> (FFFFFFZZ)V
      // 6e: putfield x/ocbce5ea28a3.ն Lx/oceb7a9b9a85;
      // 71: return
   }

   boolean ʷ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 1
      // 04: aload 0
      // 05: getfield x/ocbce5ea28a3.ն Lx/oceb7a9b9a85;
      // 08: aload 0
      // 09: getfield x/ocbce5ea28a3.ȷ Z
      // 0c: aload 0
      // 0d: iload 1
      // 0e: ifne 20
      // 11: getfield x/ocbce5ea28a3.ҽ Lx/oc30b42710ad;
      // 14: ifnull 2e
      // 17: goto 1b
      // 1a: athrow
      // 1b: aload 0
      // 1c: goto 20
      // 1f: athrow
      // 20: getfield x/ocbce5ea28a3.ԣ Z
      // 23: iload 1
      // 24: ifne 2f
      // 27: ifeq 32
      // 2a: goto 2e
      // 2d: athrow
      // 2e: bipush 1
      // 2f: goto 33
      // 32: bipush 0
      // 33: invokestatic x/ocbce5ea28a3.Ψ (Lx/oceb7a9b9a85;ZZ)Z
      // 36: ireturn
   }

   void Ʈ(oc55585a6f85 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 2
      // 04: aload 1
      // 05: ifnonnull 0a
      // 08: return
      // 09: athrow
      // 0a: aload 0
      // 0b: getfield x/ocbce5ea28a3.Ѻ Lx/oc65fedf8d38;
      // 0e: iload 2
      // 0f: ifne 48
      // 12: getstatic x/oc65fedf8d38.В Lx/oc65fedf8d38;
      // 15: if_acmpne 3c
      // 18: goto 1c
      // 1b: athrow
      // 1c: aload 0
      // 1d: iload 2
      // 1e: ifne 3d
      // 21: goto 25
      // 24: athrow
      // 25: getfield x/ocbce5ea28a3.ҽ Lx/oc30b42710ad;
      // 28: ifnull 3c
      // 2b: goto 2f
      // 2e: athrow
      // 2f: aload 1
      // 30: aload 0
      // 31: getfield x/ocbce5ea28a3.ҽ Lx/oc30b42710ad;
      // 34: getfield x/oc30b42710ad.ϡ F
      // 37: invokevirtual x/oc55585a6f85.Ě (F)V
      // 3a: return
      // 3b: athrow
      // 3c: aload 0
      // 3d: iload 2
      // 3e: ifne 69
      // 41: getfield x/ocbce5ea28a3.Ѻ Lx/oc65fedf8d38;
      // 44: goto 48
      // 47: athrow
      // 48: getstatic x/oc65fedf8d38.Ǯ Lx/oc65fedf8d38;
      // 4b: if_acmpeq 64
      // 4e: aload 0
      // 4f: iload 2
      // 50: ifne 85
      // 53: goto 57
      // 56: athrow
      // 57: getfield x/ocbce5ea28a3.Ѻ Lx/oc65fedf8d38;
      // 5a: getstatic x/oc65fedf8d38.И Lx/oc65fedf8d38;
      // 5d: if_acmpne 84
      // 60: goto 64
      // 63: athrow
      // 64: aload 0
      // 65: goto 69
      // 68: athrow
      // 69: iload 2
      // 6a: ifne 85
      // 6d: getfield x/ocbce5ea28a3.ҽ Lx/oc30b42710ad;
      // 70: ifnull 84
      // 73: goto 77
      // 76: athrow
      // 77: aload 1
      // 78: aload 0
      // 79: getfield x/ocbce5ea28a3.ҽ Lx/oc30b42710ad;
      // 7c: getfield x/oc30b42710ad.ϡ F
      // 7f: invokevirtual x/oc55585a6f85.Ě (F)V
      // 82: return
      // 83: athrow
      // 84: aload 0
      // 85: iload 2
      // 86: ifne 9e
      // 89: getfield x/ocbce5ea28a3.d Z
      // 8c: ifeq 9d
      // 8f: goto 93
      // 92: athrow
      // 93: aload 1
      // 94: aload 0
      // 95: getfield x/ocbce5ea28a3.D F
      // 98: invokevirtual x/oc55585a6f85.Ě (F)V
      // 9b: return
      // 9c: athrow
      // 9d: aload 0
      // 9e: getfield x/ocbce5ea28a3.ƒ Lx/oc7beea7ccff;
      // a1: aload 1
      // a2: aload 0
      // a3: aload 0
      // a4: getfield x/ocbce5ea28a3.Ǚ Lx/oc668fce0dbf;
      // a7: invokevirtual x/oc668fce0dbf.ն ()Lnet/minecraft/client/entity/EntityPlayerSP;
      // aa: invokevirtual x/ocbce5ea28a3.Ӏ (Lnet/minecraft/client/entity/EntityPlayerSP;)F
      // ad: invokevirtual x/oc7beea7ccff.Ƀ (Lx/oc55585a6f85;F)V
      // b0: return
   }

   void ε(oc4c5a4d3446 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 2
      // 04: aload 1
      // 05: ifnonnull 0a
      // 08: return
      // 09: athrow
      // 0a: aload 0
      // 0b: iload 2
      // 0c: ifne 89
      // 0f: getfield x/ocbce5ea28a3.Ѻ Lx/oc65fedf8d38;
      // 12: getstatic x/oc65fedf8d38.В Lx/oc65fedf8d38;
      // 15: if_acmpne 88
      // 18: goto 1c
      // 1b: athrow
      // 1c: aload 0
      // 1d: iload 2
      // 1e: ifne 89
      // 21: goto 25
      // 24: athrow
      // 25: getfield x/ocbce5ea28a3.ҽ Lx/oc30b42710ad;
      // 28: ifnull 88
      // 2b: goto 2f
      // 2e: athrow
      // 2f: aload 1
      // 30: aload 0
      // 31: getfield x/ocbce5ea28a3.ҽ Lx/oc30b42710ad;
      // 34: getfield x/oc30b42710ad.ϡ F
      // 37: invokevirtual x/oc4c5a4d3446.Ŗ (F)V
      // 3a: aload 0
      // 3b: iload 2
      // 3c: ifne 58
      // 3f: goto 43
      // 42: athrow
      // 43: getfield x/ocbce5ea28a3.ҽ Lx/oc30b42710ad;
      // 46: getfield x/oc30b42710ad.Ň Lx/oc23ff80be39;
      // 49: getstatic x/oc23ff80be39.Ǆ Lx/oc23ff80be39;
      // 4c: if_acmpne 87
      // 4f: goto 53
      // 52: athrow
      // 53: aload 0
      // 54: goto 58
      // 57: athrow
      // 58: iload 2
      // 59: ifne 78
      // 5c: getfield x/ocbce5ea28a3.ҽ Lx/oc30b42710ad;
      // 5f: getfield x/oc30b42710ad.ǐ D
      // 62: aload 0
      // 63: getfield x/ocbce5ea28a3.ҽ Lx/oc30b42710ad;
      // 66: getfield x/oc30b42710ad.ϐ D
      // 69: invokestatic x/ocbce5ea28a3.ŧ (DD)Z
      // 6c: ifeq 87
      // 6f: goto 73
      // 72: athrow
      // 73: aload 0
      // 74: goto 78
      // 77: athrow
      // 78: getfield x/ocbce5ea28a3.ԣ Z
      // 7b: ifne 87
      // 7e: aload 1
      // 7f: bipush 0
      // 80: invokevirtual x/oc4c5a4d3446.ŧ (Z)V
      // 83: goto 87
      // 86: athrow
      // 87: return
      // 88: aload 0
      // 89: iload 2
      // 8a: ifne b5
      // 8d: getfield x/ocbce5ea28a3.Ѻ Lx/oc65fedf8d38;
      // 90: getstatic x/oc65fedf8d38.Ǯ Lx/oc65fedf8d38;
      // 93: if_acmpeq b0
      // 96: goto 9a
      // 99: athrow
      // 9a: aload 0
      // 9b: iload 2
      // 9c: ifne d1
      // 9f: goto a3
      // a2: athrow
      // a3: getfield x/ocbce5ea28a3.Ѻ Lx/oc65fedf8d38;
      // a6: getstatic x/oc65fedf8d38.И Lx/oc65fedf8d38;
      // a9: if_acmpne d0
      // ac: goto b0
      // af: athrow
      // b0: aload 0
      // b1: goto b5
      // b4: athrow
      // b5: iload 2
      // b6: ifne d1
      // b9: getfield x/ocbce5ea28a3.ҽ Lx/oc30b42710ad;
      // bc: ifnull d0
      // bf: goto c3
      // c2: athrow
      // c3: aload 1
      // c4: aload 0
      // c5: getfield x/ocbce5ea28a3.ҽ Lx/oc30b42710ad;
      // c8: getfield x/oc30b42710ad.ϡ F
      // cb: invokevirtual x/oc4c5a4d3446.Ŗ (F)V
      // ce: return
      // cf: athrow
      // d0: aload 0
      // d1: iload 2
      // d2: ifne ea
      // d5: getfield x/ocbce5ea28a3.d Z
      // d8: ifeq e9
      // db: goto df
      // de: athrow
      // df: aload 1
      // e0: aload 0
      // e1: getfield x/ocbce5ea28a3.D F
      // e4: invokevirtual x/oc4c5a4d3446.Ŗ (F)V
      // e7: return
      // e8: athrow
      // e9: aload 0
      // ea: getfield x/ocbce5ea28a3.ƒ Lx/oc7beea7ccff;
      // ed: aload 1
      // ee: aload 0
      // ef: aload 0
      // f0: getfield x/ocbce5ea28a3.Ǚ Lx/oc668fce0dbf;
      // f3: invokevirtual x/oc668fce0dbf.ն ()Lnet/minecraft/client/entity/EntityPlayerSP;
      // f6: invokevirtual x/ocbce5ea28a3.Ӏ (Lnet/minecraft/client/entity/EntityPlayerSP;)F
      // f9: invokevirtual x/oc7beea7ccff.Ʉ (Lx/oc4c5a4d3446;F)V
      // fc: return
   }

   void ώ(oc25aa89b91f param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 2
      // 04: aload 0
      // 05: iload 2
      // 06: ifne 18
      // 09: invokevirtual x/ocbce5ea28a3.ǔ ()Z
      // 0c: ifne 1c
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: goto 18
      // 17: athrow
      // 18: invokevirtual x/ocbce5ea28a3.ϔ ()V
      // 1b: return
      // 1c: aload 1
      // 1d: ifnonnull 22
      // 20: return
      // 21: athrow
      // 22: aload 0
      // 23: iload 2
      // 24: ifne 65
      // 27: getfield x/ocbce5ea28a3.Ѻ Lx/oc65fedf8d38;
      // 2a: getstatic x/oc65fedf8d38.В Lx/oc65fedf8d38;
      // 2d: if_acmpeq 60
      // 30: goto 34
      // 33: athrow
      // 34: aload 0
      // 35: iload 2
      // 36: ifne 65
      // 39: goto 3d
      // 3c: athrow
      // 3d: getfield x/ocbce5ea28a3.Ѻ Lx/oc65fedf8d38;
      // 40: getstatic x/oc65fedf8d38.Ǯ Lx/oc65fedf8d38;
      // 43: if_acmpeq 60
      // 46: goto 4a
      // 49: athrow
      // 4a: aload 0
      // 4b: iload 2
      // 4c: ifne a3
      // 4f: goto 53
      // 52: athrow
      // 53: getfield x/ocbce5ea28a3.Ѻ Lx/oc65fedf8d38;
      // 56: getstatic x/oc65fedf8d38.И Lx/oc65fedf8d38;
      // 59: if_acmpne a2
      // 5c: goto 60
      // 5f: athrow
      // 60: aload 0
      // 61: goto 65
      // 64: athrow
      // 65: iload 2
      // 66: ifne a3
      // 69: getfield x/ocbce5ea28a3.ҽ Lx/oc30b42710ad;
      // 6c: ifnull a2
      // 6f: goto 73
      // 72: athrow
      // 73: aload 1
      // 74: aload 0
      // 75: getfield x/ocbce5ea28a3.ҽ Lx/oc30b42710ad;
      // 78: getfield x/oc30b42710ad.ϡ F
      // 7b: aload 0
      // 7c: getfield x/ocbce5ea28a3.ҽ Lx/oc30b42710ad;
      // 7f: getfield x/oc30b42710ad.ш F
      // 82: invokevirtual x/oc25aa89b91f.Ŕ (FF)V
      // 85: aload 0
      // 86: aload 0
      // 87: getfield x/ocbce5ea28a3.ҽ Lx/oc30b42710ad;
      // 8a: getfield x/oc30b42710ad.ϡ F
      // 8d: putfield x/ocbce5ea28a3.ȹ F
      // 90: aload 0
      // 91: aload 0
      // 92: getfield x/ocbce5ea28a3.ҽ Lx/oc30b42710ad;
      // 95: getfield x/oc30b42710ad.ш F
      // 98: putfield x/ocbce5ea28a3.я F
      // 9b: aload 0
      // 9c: bipush 1
      // 9d: putfield x/ocbce5ea28a3.Ƭ Z
      // a0: return
      // a1: athrow
      // a2: aload 0
      // a3: iload 2
      // a4: ifne d0
      // a7: getfield x/ocbce5ea28a3.d Z
      // aa: ifne b3
      // ad: goto b1
      // b0: athrow
      // b1: return
      // b2: athrow
      // b3: aload 1
      // b4: aload 0
      // b5: getfield x/ocbce5ea28a3.D F
      // b8: aload 0
      // b9: getfield x/ocbce5ea28a3.ʫ F
      // bc: invokevirtual x/oc25aa89b91f.Ŕ (FF)V
      // bf: aload 0
      // c0: aload 0
      // c1: getfield x/ocbce5ea28a3.D F
      // c4: putfield x/ocbce5ea28a3.ȹ F
      // c7: aload 0
      // c8: aload 0
      // c9: getfield x/ocbce5ea28a3.ʫ F
      // cc: putfield x/ocbce5ea28a3.я F
      // cf: aload 0
      // d0: bipush 1
      // d1: putfield x/ocbce5ea28a3.Ƭ Z
      // d4: return
   }

   void ҫ(oc9d4393f3ce param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 2
      // 04: aload 1
      // 05: iload 2
      // 06: ifne 11
      // 09: ifnull 64
      // 0c: goto 10
      // 0f: athrow
      // 10: aload 1
      // 11: invokevirtual x/oc9d4393f3ce.ɟ ()Lnet/minecraft/network/Packet;
      // 14: instanceof net/minecraft/network/play/client/C08PacketPlayerBlockPlacement
      // 17: ifeq 64
      // 1a: aload 0
      // 1b: iload 2
      // 1c: ifne 32
      // 1f: goto 23
      // 22: athrow
      // 23: getfield x/ocbce5ea28a3.ɹ Lx/oc981d71de6a;
      // 26: ifnull 64
      // 29: goto 2d
      // 2c: athrow
      // 2d: aload 0
      // 2e: goto 32
      // 31: athrow
      // 32: iload 2
      // 33: ifne 48
      // 36: getfield x/ocbce5ea28a3.ɹ Lx/oc981d71de6a;
      // 39: getfield x/oc981d71de6a.ɂ Lnet/minecraft/network/play/client/C08PacketPlayerBlockPlacement;
      // 3c: ifnonnull 64
      // 3f: goto 43
      // 42: athrow
      // 43: aload 0
      // 44: goto 48
      // 47: athrow
      // 48: iload 2
      // 49: ifne 5e
      // 4c: getfield x/ocbce5ea28a3.ɓ Lx/oc06124119aa;
      // 4f: getstatic x/oc06124119aa.Ư Lx/oc06124119aa;
      // 52: if_acmpne 64
      // 55: goto 59
      // 58: athrow
      // 59: aload 0
      // 5a: goto 5e
      // 5d: athrow
      // 5e: getfield x/ocbce5ea28a3.Ć Z
      // 61: ifne 66
      // 64: return
      // 65: athrow
      // 66: aload 1
      // 67: invokevirtual x/oc9d4393f3ce.ɟ ()Lnet/minecraft/network/Packet;
      // 6a: checkcast net/minecraft/network/play/client/C08PacketPlayerBlockPlacement
      // 6d: astore 3
      // 6e: iload 2
      // 6f: ifne ac
      // 72: aload 3
      // 73: aload 0
      // 74: getfield x/ocbce5ea28a3.ɹ Lx/oc981d71de6a;
      // 77: getfield x/oc981d71de6a.î Lx/oc847503a8ab;
      // 7a: invokestatic x/ocbce5ea28a3.ƅ (Lnet/minecraft/network/play/client/C08PacketPlayerBlockPlacement;Lx/oc847503a8ab;)Z
      // 7d: ifne 86
      // 80: goto 84
      // 83: athrow
      // 84: return
      // 85: athrow
      // 86: aload 0
      // 87: aload 0
      // 88: getfield x/ocbce5ea28a3.ɹ Lx/oc981d71de6a;
      // 8b: aload 3
      // 8c: invokevirtual x/oc981d71de6a.į (Lnet/minecraft/network/play/client/C08PacketPlayerBlockPlacement;)Lx/oc981d71de6a;
      // 8f: putfield x/ocbce5ea28a3.ɹ Lx/oc981d71de6a;
      // 92: aload 0
      // 93: aload 0
      // 94: getfield x/ocbce5ea28a3.ɹ Lx/oc981d71de6a;
      // 97: getfield x/oc981d71de6a.î Lx/oc847503a8ab;
      // 9a: aload 3
      // 9b: aload 0
      // 9c: getfield x/ocbce5ea28a3.ϯ J
      // 9f: invokestatic x/occ00ef6c188.P (Lx/oc847503a8ab;Lnet/minecraft/network/play/client/C08PacketPlayerBlockPlacement;J)Lx/occ00ef6c188;
      // a2: putfield x/ocbce5ea28a3.Ш Lx/occ00ef6c188;
      // a5: aload 0
      // a6: getstatic x/oc06124119aa.Ɓ Lx/oc06124119aa;
      // a9: putfield x/ocbce5ea28a3.ɓ Lx/oc06124119aa;
      // ac: return
   }

   void è(Packet<?> param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: aload 0
      // 004: dup
      // 005: getfield x/ocbce5ea28a3.Մ J
      // 008: lconst_1
      // 009: ladd
      // 00a: putfield x/ocbce5ea28a3.Մ J
      // 00d: istore 2
      // 00e: aload 1
      // 00f: iload 2
      // 010: ifne 028
      // 013: instanceof net/minecraft/network/play/client/C0BPacketEntityAction
      // 016: ifeq 027
      // 019: goto 01d
      // 01c: athrow
      // 01d: aload 0
      // 01e: aload 1
      // 01f: checkcast net/minecraft/network/play/client/C0BPacketEntityAction
      // 022: invokevirtual x/ocbce5ea28a3.Ǘ (Lnet/minecraft/network/play/client/C0BPacketEntityAction;)V
      // 025: return
      // 026: athrow
      // 027: aload 1
      // 028: iload 2
      // 029: ifne 041
      // 02c: instanceof net/minecraft/network/play/client/C08PacketPlayerBlockPlacement
      // 02f: ifeq 040
      // 032: goto 036
      // 035: athrow
      // 036: aload 0
      // 037: aload 1
      // 038: checkcast net/minecraft/network/play/client/C08PacketPlayerBlockPlacement
      // 03b: invokevirtual x/ocbce5ea28a3.Õ (Lnet/minecraft/network/play/client/C08PacketPlayerBlockPlacement;)V
      // 03e: return
      // 03f: athrow
      // 040: aload 1
      // 041: instanceof net/minecraft/network/play/client/C03PacketPlayer
      // 044: iload 2
      // 045: ifne 07c
      // 048: ifne 050
      // 04b: goto 04f
      // 04e: athrow
      // 04f: return
      // 050: aload 0
      // 051: dup
      // 052: getfield x/ocbce5ea28a3.Ӝ J
      // 055: lconst_1
      // 056: ladd
      // 057: putfield x/ocbce5ea28a3.Ӝ J
      // 05a: aload 0
      // 05b: iload 2
      // 05c: ifne 099
      // 05f: aload 0
      // 060: getfield x/ocbce5ea28a3.ʡ Lx/oc791986a759;
      // 063: aload 1
      // 064: checkcast net/minecraft/network/play/client/C03PacketPlayer
      // 067: aload 0
      // 068: getfield x/ocbce5ea28a3.Ӝ J
      // 06b: invokestatic x/oc791986a759.ұ (Lx/oc791986a759;Lnet/minecraft/network/play/client/C03PacketPlayer;J)Lx/oc791986a759;
      // 06e: putfield x/ocbce5ea28a3.ʡ Lx/oc791986a759;
      // 071: aload 0
      // 072: getfield x/ocbce5ea28a3.ʡ Lx/oc791986a759;
      // 075: getfield x/oc791986a759.ŕ Z
      // 078: goto 07c
      // 07b: athrow
      // 07c: ifeq 098
      // 07f: aload 0
      // 080: getfield x/ocbce5ea28a3.ƒ Lx/oc7beea7ccff;
      // 083: aload 0
      // 084: getfield x/ocbce5ea28a3.ʡ Lx/oc791986a759;
      // 087: getfield x/oc791986a759.Ά F
      // 08a: aload 0
      // 08b: getfield x/ocbce5ea28a3.ʡ Lx/oc791986a759;
      // 08e: getfield x/oc791986a759.ţ F
      // 091: invokevirtual x/oc7beea7ccff.т (FF)V
      // 094: goto 098
      // 097: athrow
      // 098: aload 0
      // 099: iload 2
      // 09a: ifne 145
      // 09d: getfield x/ocbce5ea28a3.Ш Lx/occ00ef6c188;
      // 0a0: ifnull 144
      // 0a3: goto 0a7
      // 0a6: athrow
      // 0a7: aload 0
      // 0a8: iload 2
      // 0a9: ifne 0cc
      // 0ac: goto 0b0
      // 0af: athrow
      // 0b0: getfield x/ocbce5ea28a3.Ш Lx/occ00ef6c188;
      // 0b3: aload 0
      // 0b4: getfield x/ocbce5ea28a3.ʡ Lx/oc791986a759;
      // 0b7: aload 0
      // 0b8: invokevirtual x/ocbce5ea28a3.Щ ()F
      // 0bb: invokevirtual x/occ00ef6c188.վ (Lx/oc791986a759;F)Z
      // 0be: ifne 0cb
      // 0c1: goto 0c5
      // 0c4: athrow
      // 0c5: aload 0
      // 0c6: invokevirtual x/ocbce5ea28a3.C ()V
      // 0c9: return
      // 0ca: athrow
      // 0cb: aload 0
      // 0cc: iload 2
      // 0cd: ifne 0e2
      // 0d0: getfield x/ocbce5ea28a3.Ш Lx/occ00ef6c188;
      // 0d3: getfield x/occ00ef6c188.ԁ Z
      // 0d6: ifeq 143
      // 0d9: goto 0dd
      // 0dc: athrow
      // 0dd: aload 0
      // 0de: goto 0e2
      // 0e1: athrow
      // 0e2: iload 2
      // 0e3: ifne 109
      // 0e6: getfield x/ocbce5ea28a3.Մ J
      // 0e9: aload 0
      // 0ea: getfield x/ocbce5ea28a3.Ш Lx/occ00ef6c188;
      // 0ed: getfield x/occ00ef6c188.Ń J
      // 0f0: lcmp
      // 0f1: ifle 143
      // 0f4: goto 0f8
      // 0f7: athrow
      // 0f8: aload 0
      // 0f9: iload 2
      // 0fa: ifne 117
      // 0fd: goto 101
      // 100: athrow
      // 101: invokevirtual x/ocbce5ea28a3.ϋ ()V
      // 104: aload 0
      // 105: goto 109
      // 108: athrow
      // 109: getfield x/ocbce5ea28a3.Ѻ Lx/oc65fedf8d38;
      // 10c: getstatic x/oc65fedf8d38.ė Lx/oc65fedf8d38;
      // 10f: if_acmpne 143
      // 112: aload 0
      // 113: goto 117
      // 116: athrow
      // 117: iload 2
      // 118: ifne 12a
      // 11b: getfield x/ocbce5ea28a3.Ƕ Lx/oc1a421bd3db;
      // 11e: ifnull 143
      // 121: goto 125
      // 124: athrow
      // 125: aload 0
      // 126: goto 12a
      // 129: athrow
      // 12a: iload 2
      // 12b: ifne 140
      // 12e: getfield x/ocbce5ea28a3.ɓ Lx/oc06124119aa;
      // 131: getstatic x/oc06124119aa.ί Lx/oc06124119aa;
      // 134: if_acmpne 143
      // 137: goto 13b
      // 13a: athrow
      // 13b: aload 0
      // 13c: goto 140
      // 13f: athrow
      // 140: invokevirtual x/ocbce5ea28a3.Ϟ ()V
      // 143: return
      // 144: aload 0
      // 145: getfield x/ocbce5ea28a3.Ѻ Lx/oc65fedf8d38;
      // 148: iload 2
      // 149: ifne 1b8
      // 14c: getstatic x/oc65fedf8d38.Ό Lx/oc65fedf8d38;
      // 14f: if_acmpne 1ac
      // 152: goto 156
      // 155: athrow
      // 156: aload 0
      // 157: iload 2
      // 158: ifne 16e
      // 15b: goto 15f
      // 15e: athrow
      // 15f: getfield x/ocbce5ea28a3.ʨ Z
      // 162: ifeq 1ab
      // 165: goto 169
      // 168: athrow
      // 169: aload 0
      // 16a: goto 16e
      // 16d: athrow
      // 16e: iload 2
      // 16f: ifne 186
      // 172: getfield x/ocbce5ea28a3.Ӝ J
      // 175: aload 0
      // 176: getfield x/ocbce5ea28a3.ʁ J
      // 179: lcmp
      // 17a: ifle 1ab
      // 17d: goto 181
      // 180: athrow
      // 181: aload 0
      // 182: goto 186
      // 185: athrow
      // 186: iload 2
      // 187: ifne 1a8
      // 18a: getfield x/ocbce5ea28a3.ʡ Lx/oc791986a759;
      // 18d: aload 0
      // 18e: getfield x/ocbce5ea28a3.ɞ F
      // 191: aload 0
      // 192: getfield x/ocbce5ea28a3.Ӑ F
      // 195: aload 0
      // 196: invokevirtual x/ocbce5ea28a3.Щ ()F
      // 199: invokestatic x/ocbce5ea28a3.ю (Lx/oc791986a759;FFF)Z
      // 19c: ifeq 1ab
      // 19f: goto 1a3
      // 1a2: athrow
      // 1a3: aload 0
      // 1a4: goto 1a8
      // 1a7: athrow
      // 1a8: invokevirtual x/ocbce5ea28a3.º ()V
      // 1ab: return
      // 1ac: aload 0
      // 1ad: iload 2
      // 1ae: ifne 1d9
      // 1b1: getfield x/ocbce5ea28a3.Ѻ Lx/oc65fedf8d38;
      // 1b4: goto 1b8
      // 1b7: athrow
      // 1b8: getstatic x/oc65fedf8d38.В Lx/oc65fedf8d38;
      // 1bb: if_acmpeq 1d4
      // 1be: aload 0
      // 1bf: iload 2
      // 1c0: ifne 1d9
      // 1c3: goto 1c7
      // 1c6: athrow
      // 1c7: getfield x/ocbce5ea28a3.Ѻ Lx/oc65fedf8d38;
      // 1ca: getstatic x/oc65fedf8d38.ė Lx/oc65fedf8d38;
      // 1cd: if_acmpne 1dc
      // 1d0: goto 1d4
      // 1d3: athrow
      // 1d4: aload 0
      // 1d5: goto 1d9
      // 1d8: athrow
      // 1d9: invokevirtual x/ocbce5ea28a3.Ϟ ()V
      // 1dc: return
   }

   void B(Packet<?> param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 2
      // 04: aload 1
      // 05: iload 2
      // 06: ifne 1a
      // 09: instanceof net/minecraft/network/play/server/S08PacketPlayerPosLook
      // 0c: ifeq 19
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: invokevirtual x/ocbce5ea28a3.ϔ ()V
      // 17: return
      // 18: athrow
      // 19: aload 1
      // 1a: iload 2
      // 1b: ifne 3b
      // 1e: instanceof net/minecraft/network/play/server/S23PacketBlockChange
      // 21: ifeq 3a
      // 24: goto 28
      // 27: athrow
      // 28: aload 1
      // 29: checkcast net/minecraft/network/play/server/S23PacketBlockChange
      // 2c: astore 3
      // 2d: aload 0
      // 2e: aload 3
      // 2f: invokevirtual net/minecraft/network/play/server/S23PacketBlockChange.getBlockPosition ()Lnet/minecraft/util/BlockPos;
      // 32: aload 3
      // 33: invokevirtual net/minecraft/network/play/server/S23PacketBlockChange.getBlockState ()Lnet/minecraft/block/state/IBlockState;
      // 36: invokevirtual x/ocbce5ea28a3.ʝ (Lnet/minecraft/util/BlockPos;Lnet/minecraft/block/state/IBlockState;)V
      // 39: return
      // 3a: aload 1
      // 3b: iload 2
      // 3c: ifne 4e
      // 3f: instanceof net/minecraft/network/play/server/S22PacketMultiBlockChange
      // 42: ifeq 7e
      // 45: goto 49
      // 48: athrow
      // 49: aload 1
      // 4a: goto 4e
      // 4d: athrow
      // 4e: checkcast net/minecraft/network/play/server/S22PacketMultiBlockChange
      // 51: invokevirtual net/minecraft/network/play/server/S22PacketMultiBlockChange.getChangedBlocks ()[Lnet/minecraft/network/play/server/S22PacketMultiBlockChange$BlockUpdateData;
      // 54: astore 3
      // 55: aload 3
      // 56: arraylength
      // 57: istore 4
      // 59: bipush 0
      // 5a: istore 5
      // 5c: iload 5
      // 5e: iload 4
      // 60: if_icmpge 7e
      // 63: aload 3
      // 64: iload 5
      // 66: aaload
      // 67: astore 6
      // 69: iload 2
      // 6a: aload 0
      // 6b: aload 6
      // 6d: invokevirtual net/minecraft/network/play/server/S22PacketMultiBlockChange$BlockUpdateData.getPos ()Lnet/minecraft/util/BlockPos;
      // 70: aload 6
      // 72: invokevirtual net/minecraft/network/play/server/S22PacketMultiBlockChange$BlockUpdateData.getBlockState ()Lnet/minecraft/block/state/IBlockState;
      // 75: invokevirtual x/ocbce5ea28a3.ʝ (Lnet/minecraft/util/BlockPos;Lnet/minecraft/block/state/IBlockState;)V
      // 78: iinc 5 1
      // 7b: ifeq 5c
      // 7e: return
   }

   private void Õ(C08PacketPlayerBlockPlacement param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 2
      // 04: aload 0
      // 05: iload 2
      // 06: ifne 18
      // 09: getfield x/ocbce5ea28a3.Ш Lx/occ00ef6c188;
      // 0c: ifnull 40
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: goto 18
      // 17: athrow
      // 18: iload 2
      // 19: ifne 2f
      // 1c: getfield x/ocbce5ea28a3.Ш Lx/occ00ef6c188;
      // 1f: getfield x/occ00ef6c188.ψ Lnet/minecraft/network/play/client/C08PacketPlayerBlockPlacement;
      // 22: aload 1
      // 23: if_acmpne 40
      // 26: goto 2a
      // 29: athrow
      // 2a: aload 0
      // 2b: goto 2f
      // 2e: athrow
      // 2f: iload 2
      // 30: ifne 43
      // 33: getfield x/ocbce5ea28a3.ɓ Lx/oc06124119aa;
      // 36: getstatic x/oc06124119aa.Ɓ Lx/oc06124119aa;
      // 39: if_acmpeq 42
      // 3c: goto 40
      // 3f: athrow
      // 40: return
      // 41: athrow
      // 42: aload 0
      // 43: iload 2
      // 44: ifne 7e
      // 47: getfield x/ocbce5ea28a3.Ш Lx/occ00ef6c188;
      // 4a: aload 0
      // 4b: getfield x/ocbce5ea28a3.ʡ Lx/oc791986a759;
      // 4e: aload 0
      // 4f: invokevirtual x/ocbce5ea28a3.Щ ()F
      // 52: invokevirtual x/occ00ef6c188.վ (Lx/oc791986a759;F)Z
      // 55: ifeq 79
      // 58: goto 5c
      // 5b: athrow
      // 5c: aload 0
      // 5d: iload 2
      // 5e: ifne bc
      // 61: goto 65
      // 64: athrow
      // 65: aload 0
      // 66: getfield x/ocbce5ea28a3.Ш Lx/occ00ef6c188;
      // 69: getfield x/occ00ef6c188.Ÿ Lx/oc847503a8ab;
      // 6c: getfield x/oc847503a8ab.ß Lx/oc1a421bd3db;
      // 6f: invokevirtual x/ocbce5ea28a3.р (Lx/oc1a421bd3db;)Z
      // 72: ifne 82
      // 75: goto 79
      // 78: athrow
      // 79: aload 0
      // 7a: goto 7e
      // 7d: athrow
      // 7e: invokevirtual x/ocbce5ea28a3.C ()V
      // 81: return
      // 82: aload 0
      // 83: aload 0
      // 84: getfield x/ocbce5ea28a3.Ш Lx/occ00ef6c188;
      // 87: aload 0
      // 88: getfield x/ocbce5ea28a3.Մ J
      // 8b: invokevirtual x/occ00ef6c188.Ծ (J)Lx/occ00ef6c188;
      // 8e: putfield x/ocbce5ea28a3.Ш Lx/occ00ef6c188;
      // 91: aload 0
      // 92: aload 0
      // 93: getfield x/ocbce5ea28a3.Ш Lx/occ00ef6c188;
      // 96: getfield x/occ00ef6c188.Ÿ Lx/oc847503a8ab;
      // 99: getfield x/oc847503a8ab.ß Lx/oc1a421bd3db;
      // 9c: invokevirtual x/ocbce5ea28a3.Ȼ (Lx/oc1a421bd3db;)V
      // 9f: aload 0
      // a0: getfield x/ocbce5ea28a3.Ñ Ljava/util/Set;
      // a3: aload 0
      // a4: getfield x/ocbce5ea28a3.Ш Lx/occ00ef6c188;
      // a7: getfield x/occ00ef6c188.Ÿ Lx/oc847503a8ab;
      // aa: getfield x/oc847503a8ab.ß Lx/oc1a421bd3db;
      // ad: getfield x/oc1a421bd3db.Շ Lnet/minecraft/util/BlockPos;
      // b0: invokeinterface java/util/Set.add (Ljava/lang/Object;)Z 2
      // b5: pop
      // b6: aload 0
      // b7: bipush 1
      // b8: putfield x/ocbce5ea28a3.Ժ Z
      // bb: aload 0
      // bc: getstatic x/oc06124119aa.Ⱦ Lx/oc06124119aa;
      // bf: putfield x/ocbce5ea28a3.ɓ Lx/oc06124119aa;
      // c2: return
   }

   private void Ȼ(oc1a421bd3db param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 2
      // 04: aload 1
      // 05: ifnonnull 0a
      // 08: return
      // 09: athrow
      // 0a: aload 0
      // 0b: iload 2
      // 0c: ifne 3d
      // 0f: invokevirtual x/ocbce5ea28a3.ӎ ()Z
      // 12: ifne 3c
      // 15: goto 19
      // 18: athrow
      // 19: aload 0
      // 1a: iload 2
      // 1b: ifne 3d
      // 1e: goto 22
      // 21: athrow
      // 22: getfield x/ocbce5ea28a3.б Lx/oc7b822110db;
      // 25: ifnull 3c
      // 28: goto 2c
      // 2b: athrow
      // 2c: aload 0
      // 2d: getfield x/ocbce5ea28a3.б Lx/oc7b822110db;
      // 30: aload 1
      // 31: getfield x/oc1a421bd3db.Շ Lnet/minecraft/util/BlockPos;
      // 34: invokevirtual x/oc7b822110db.ǹ (Lnet/minecraft/util/BlockPos;)Z
      // 37: pop
      // 38: goto 3c
      // 3b: athrow
      // 3c: aload 0
      // 3d: aload 1
      // 3e: getfield x/oc1a421bd3db.Շ Lnet/minecraft/util/BlockPos;
      // 41: putfield x/ocbce5ea28a3.Ο Lnet/minecraft/util/BlockPos;
      // 44: return
   }

   private void ʝ(BlockPos param1, IBlockState param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 3
      // 04: aload 1
      // 05: ifnull 19
      // 08: aload 0
      // 09: getfield x/ocbce5ea28a3.Ñ Ljava/util/Set;
      // 0c: aload 1
      // 0d: invokeinterface java/util/Set.remove (Ljava/lang/Object;)Z 2
      // 12: ifne 1b
      // 15: goto 19
      // 18: athrow
      // 19: return
      // 1a: athrow
      // 1b: aload 2
      // 1c: iload 3
      // 1d: ifne 28
      // 20: ifnull 4d
      // 23: goto 27
      // 26: athrow
      // 27: aload 2
      // 28: iload 3
      // 29: ifne 40
      // 2c: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 31: getstatic net/minecraft/init/Blocks.air Lnet/minecraft/block/Block;
      // 34: if_acmpeq 4d
      // 37: goto 3b
      // 3a: athrow
      // 3b: aload 2
      // 3c: goto 40
      // 3f: athrow
      // 40: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 45: invokevirtual net/minecraft/block/Block.isFullCube ()Z
      // 48: ifeq 4d
      // 4b: return
      // 4c: athrow
      // 4d: aload 0
      // 4e: getfield x/ocbce5ea28a3.Ñ Ljava/util/Set;
      // 51: invokeinterface java/util/Set.clear ()V 1
      // 56: aload 0
      // 57: aconst_null
      // 58: putfield x/ocbce5ea28a3.б Lx/oc7b822110db;
      // 5b: aload 0
      // 5c: aconst_null
      // 5d: putfield x/ocbce5ea28a3.Ο Lnet/minecraft/util/BlockPos;
      // 60: aload 0
      // 61: bipush 0
      // 62: putfield x/ocbce5ea28a3.џ Z
      // 65: aload 0
      // 66: iload 3
      // 67: ifne 7c
      // 6a: getfield x/ocbce5ea28a3.Ѻ Lx/oc65fedf8d38;
      // 6d: getstatic x/oc65fedf8d38.ѻ Lx/oc65fedf8d38;
      // 70: if_acmpeq 95
      // 73: goto 77
      // 76: athrow
      // 77: aload 0
      // 78: goto 7c
      // 7b: athrow
      // 7c: iload 3
      // 7d: ifne 92
      // 80: getfield x/ocbce5ea28a3.Ѻ Lx/oc65fedf8d38;
      // 83: getstatic x/oc65fedf8d38.Ό Lx/oc65fedf8d38;
      // 86: if_acmpeq 95
      // 89: goto 8d
      // 8c: athrow
      // 8d: aload 0
      // 8e: goto 92
      // 91: athrow
      // 92: invokevirtual x/ocbce5ea28a3.C ()V
      // 95: return
   }

   private void Ǘ(C0BPacketEntityAction param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 2
      // 04: aload 1
      // 05: invokevirtual net/minecraft/network/play/client/C0BPacketEntityAction.getAction ()Lnet/minecraft/network/play/client/C0BPacketEntityAction$Action;
      // 08: iload 2
      // 09: ifne 32
      // 0c: getstatic net/minecraft/network/play/client/C0BPacketEntityAction$Action.START_SNEAKING Lnet/minecraft/network/play/client/C0BPacketEntityAction$Action;
      // 0f: if_acmpne 2a
      // 12: goto 16
      // 15: athrow
      // 16: aload 0
      // 17: aload 0
      // 18: getfield x/ocbce5ea28a3.ʡ Lx/oc791986a759;
      // 1b: bipush 1
      // 1c: invokestatic x/oc791986a759.Ի (Lx/oc791986a759;Z)Lx/oc791986a759;
      // 1f: putfield x/ocbce5ea28a3.ʡ Lx/oc791986a759;
      // 22: iload 2
      // 23: ifeq 48
      // 26: goto 2a
      // 29: athrow
      // 2a: aload 1
      // 2b: invokevirtual net/minecraft/network/play/client/C0BPacketEntityAction.getAction ()Lnet/minecraft/network/play/client/C0BPacketEntityAction$Action;
      // 2e: goto 32
      // 31: athrow
      // 32: getstatic net/minecraft/network/play/client/C0BPacketEntityAction$Action.STOP_SNEAKING Lnet/minecraft/network/play/client/C0BPacketEntityAction$Action;
      // 35: if_acmpne 48
      // 38: aload 0
      // 39: aload 0
      // 3a: getfield x/ocbce5ea28a3.ʡ Lx/oc791986a759;
      // 3d: bipush 0
      // 3e: invokestatic x/oc791986a759.Ի (Lx/oc791986a759;Z)Lx/oc791986a759;
      // 41: putfield x/ocbce5ea28a3.ʡ Lx/oc791986a759;
      // 44: goto 48
      // 47: athrow
      // 48: return
   }

   private void Ϟ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: istore 1
      // 004: aload 0
      // 005: iload 1
      // 006: ifne 0c0
      // 009: getfield x/ocbce5ea28a3.ʡ Lx/oc791986a759;
      // 00c: ifnull 0bb
      // 00f: goto 013
      // 012: athrow
      // 013: aload 0
      // 014: iload 1
      // 015: ifne 0c0
      // 018: goto 01c
      // 01b: athrow
      // 01c: getfield x/ocbce5ea28a3.ʡ Lx/oc791986a759;
      // 01f: getfield x/oc791986a759.Ӎ Z
      // 022: ifeq 0bb
      // 025: goto 029
      // 028: athrow
      // 029: aload 0
      // 02a: iload 1
      // 02b: ifne 0c0
      // 02e: goto 032
      // 031: athrow
      // 032: getfield x/ocbce5ea28a3.ʡ Lx/oc791986a759;
      // 035: getfield x/oc791986a759.ŕ Z
      // 038: ifeq 0bb
      // 03b: goto 03f
      // 03e: athrow
      // 03f: aload 0
      // 040: iload 1
      // 041: ifne 0c0
      // 044: goto 048
      // 047: athrow
      // 048: getfield x/ocbce5ea28a3.Ƕ Lx/oc1a421bd3db;
      // 04b: ifnull 0bb
      // 04e: goto 052
      // 051: athrow
      // 052: aload 0
      // 053: iload 1
      // 054: ifne 0c0
      // 057: goto 05b
      // 05a: athrow
      // 05b: getfield x/ocbce5ea28a3.ɹ Lx/oc981d71de6a;
      // 05e: ifnonnull 0bb
      // 061: goto 065
      // 064: athrow
      // 065: aload 0
      // 066: iload 1
      // 067: ifne 0c0
      // 06a: goto 06e
      // 06d: athrow
      // 06e: getfield x/ocbce5ea28a3.Ш Lx/occ00ef6c188;
      // 071: ifnonnull 0bb
      // 074: goto 078
      // 077: athrow
      // 078: aload 0
      // 079: iload 1
      // 07a: ifne 0a9
      // 07d: goto 081
      // 080: athrow
      // 081: getfield x/ocbce5ea28a3.ɓ Lx/oc06124119aa;
      // 084: getstatic x/oc06124119aa.ί Lx/oc06124119aa;
      // 087: if_acmpeq 0a4
      // 08a: goto 08e
      // 08d: athrow
      // 08e: aload 0
      // 08f: iload 1
      // 090: ifne 0c0
      // 093: goto 097
      // 096: athrow
      // 097: getfield x/ocbce5ea28a3.ɓ Lx/oc06124119aa;
      // 09a: getstatic x/oc06124119aa.Ư Lx/oc06124119aa;
      // 09d: if_acmpne 0bb
      // 0a0: goto 0a4
      // 0a3: athrow
      // 0a4: aload 0
      // 0a5: goto 0a9
      // 0a8: athrow
      // 0a9: iload 1
      // 0aa: ifne 0c6
      // 0ad: aload 0
      // 0ae: getfield x/ocbce5ea28a3.Ƕ Lx/oc1a421bd3db;
      // 0b1: invokevirtual x/ocbce5ea28a3.ӛ (Lx/oc1a421bd3db;)Z
      // 0b4: ifne 0c5
      // 0b7: goto 0bb
      // 0ba: athrow
      // 0bb: aload 0
      // 0bc: goto 0c0
      // 0bf: athrow
      // 0c0: aconst_null
      // 0c1: putfield x/ocbce5ea28a3.Ղ Lx/oc847503a8ab;
      // 0c4: return
      // 0c5: aload 0
      // 0c6: aload 0
      // 0c7: getfield x/ocbce5ea28a3.ʡ Lx/oc791986a759;
      // 0ca: invokevirtual x/oc791986a759.Ț ()Lx/oceb39b7deb2;
      // 0cd: aload 0
      // 0ce: getfield x/ocbce5ea28a3.ʡ Lx/oc791986a759;
      // 0d1: getfield x/oc791986a759.Ά F
      // 0d4: aload 0
      // 0d5: getfield x/ocbce5ea28a3.ʡ Lx/oc791986a759;
      // 0d8: getfield x/oc791986a759.ţ F
      // 0db: aload 0
      // 0dc: getfield x/ocbce5ea28a3.Ƕ Lx/oc1a421bd3db;
      // 0df: invokevirtual x/ocbce5ea28a3.Ȱ (Lx/oceb39b7deb2;FFLx/oc1a421bd3db;)Lnet/minecraft/util/MovingObjectPosition;
      // 0e2: astore 2
      // 0e3: iload 1
      // 0e4: ifne 11f
      // 0e7: aload 2
      // 0e8: aload 0
      // 0e9: getfield x/ocbce5ea28a3.Ƕ Lx/oc1a421bd3db;
      // 0ec: invokestatic x/ocbce5ea28a3.ǟ (Lnet/minecraft/util/MovingObjectPosition;Lx/oc1a421bd3db;)Z
      // 0ef: ifeq 10f
      // 0f2: goto 0f6
      // 0f5: athrow
      // 0f6: aload 0
      // 0f7: iload 1
      // 0f8: ifne 154
      // 0fb: goto 0ff
      // 0fe: athrow
      // 0ff: getfield x/ocbce5ea28a3.ʡ Lx/oc791986a759;
      // 102: getfield x/oc791986a759.ţ F
      // 105: invokestatic x/ocbce5ea28a3.ο (F)Z
      // 108: ifne 120
      // 10b: goto 10f
      // 10e: athrow
      // 10f: aload 0
      // 110: aconst_null
      // 111: putfield x/ocbce5ea28a3.Ղ Lx/oc847503a8ab;
      // 114: aload 0
      // 115: getstatic x/oc06124119aa.ί Lx/oc06124119aa;
      // 118: putfield x/ocbce5ea28a3.ɓ Lx/oc06124119aa;
      // 11b: goto 11f
      // 11e: athrow
      // 11f: return
      // 120: aload 0
      // 121: new x/oc847503a8ab
      // 124: dup
      // 125: aload 0
      // 126: getfield x/ocbce5ea28a3.Ƕ Lx/oc1a421bd3db;
      // 129: aload 2
      // 12a: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 12d: aload 0
      // 12e: getfield x/ocbce5ea28a3.Ƕ Lx/oc1a421bd3db;
      // 131: getfield x/oc1a421bd3db.ʚ Lnet/minecraft/util/BlockPos;
      // 134: invokestatic x/ocbce5ea28a3.њ (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/BlockPos;)Lnet/minecraft/util/Vec3;
      // 137: aload 0
      // 138: getfield x/ocbce5ea28a3.ʡ Lx/oc791986a759;
      // 13b: getfield x/oc791986a759.Ά F
      // 13e: aload 0
      // 13f: getfield x/ocbce5ea28a3.ʡ Lx/oc791986a759;
      // 142: getfield x/oc791986a759.ţ F
      // 145: aload 0
      // 146: getfield x/ocbce5ea28a3.ʡ Lx/oc791986a759;
      // 149: aload 0
      // 14a: getfield x/ocbce5ea28a3.Ӝ J
      // 14d: invokespecial x/oc847503a8ab.<init> (Lx/oc1a421bd3db;Lnet/minecraft/util/Vec3;FFLx/oc791986a759;J)V
      // 150: putfield x/ocbce5ea28a3.Ղ Lx/oc847503a8ab;
      // 153: aload 0
      // 154: getstatic x/oc06124119aa.Ư Lx/oc06124119aa;
      // 157: putfield x/ocbce5ea28a3.ɓ Lx/oc06124119aa;
      // 15a: return
   }

   private void ƨ(EntityPlayerSP param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: aload 0
      // 004: getfield x/ocbce5ea28a3.Ղ Lx/oc847503a8ab;
      // 007: astore 3
      // 008: istore 2
      // 009: aload 3
      // 00a: ifnull 012
      // 00d: bipush 1
      // 00e: goto 013
      // 011: athrow
      // 012: bipush 0
      // 013: aload 0
      // 014: getfield x/ocbce5ea28a3.Ƕ Lx/oc1a421bd3db;
      // 017: ifnull 044
      // 01a: aload 3
      // 01b: iload 2
      // 01c: ifne 02b
      // 01f: goto 023
      // 022: athrow
      // 023: ifnull 044
      // 026: goto 02a
      // 029: athrow
      // 02a: aload 3
      // 02b: getfield x/oc847503a8ab.ß Lx/oc1a421bd3db;
      // 02e: aload 0
      // 02f: getfield x/ocbce5ea28a3.Ƕ Lx/oc1a421bd3db;
      // 032: invokevirtual x/oc1a421bd3db.equals (Ljava/lang/Object;)Z
      // 035: iload 2
      // 036: ifne 041
      // 039: ifeq 044
      // 03c: goto 040
      // 03f: athrow
      // 040: bipush 1
      // 041: goto 045
      // 044: bipush 0
      // 045: aload 0
      // 046: getfield x/ocbce5ea28a3.ʡ Lx/oc791986a759;
      // 049: ifnull 077
      // 04c: aload 3
      // 04d: iload 2
      // 04e: ifne 05d
      // 051: goto 055
      // 054: athrow
      // 055: ifnull 077
      // 058: goto 05c
      // 05b: athrow
      // 05c: aload 3
      // 05d: getfield x/oc847503a8ab.Ѷ J
      // 060: aload 0
      // 061: getfield x/ocbce5ea28a3.ʡ Lx/oc791986a759;
      // 064: getfield x/oc791986a759.Ԣ J
      // 067: lcmp
      // 068: iload 2
      // 069: ifne 074
      // 06c: ifne 077
      // 06f: goto 073
      // 072: athrow
      // 073: bipush 1
      // 074: goto 078
      // 077: bipush 0
      // 078: aload 0
      // 079: getfield x/ocbce5ea28a3.ɓ Lx/oc06124119aa;
      // 07c: getstatic x/oc06124119aa.Ư Lx/oc06124119aa;
      // 07f: if_acmpne 0a5
      // 082: aload 3
      // 083: ifnull 0a5
      // 086: goto 08a
      // 089: athrow
      // 08a: aload 1
      // 08b: aload 3
      // 08c: getfield x/oc847503a8ab.ʏ Lx/oc791986a759;
      // 08f: invokestatic x/ocbce5ea28a3.ӓ (Lnet/minecraft/client/entity/EntityPlayerSP;Lx/oc791986a759;)Z
      // 092: iload 2
      // 093: ifne 0a2
      // 096: goto 09a
      // 099: athrow
      // 09a: ifeq 0a5
      // 09d: goto 0a1
      // 0a0: athrow
      // 0a1: bipush 1
      // 0a2: goto 0a6
      // 0a5: bipush 0
      // 0a6: aload 0
      // 0a7: aload 0
      // 0a8: getfield x/ocbce5ea28a3.Ƕ Lx/oc1a421bd3db;
      // 0ab: invokevirtual x/ocbce5ea28a3.ӛ (Lx/oc1a421bd3db;)Z
      // 0ae: invokestatic x/ocbce5ea28a3.Ŋ (ZZZZZ)Z
      // 0b1: iload 2
      // 0b2: ifne 0f4
      // 0b5: ifne 0c3
      // 0b8: goto 0bc
      // 0bb: athrow
      // 0bc: aload 0
      // 0bd: aconst_null
      // 0be: putfield x/ocbce5ea28a3.Ղ Lx/oc847503a8ab;
      // 0c1: return
      // 0c2: athrow
      // 0c3: aload 0
      // 0c4: aload 3
      // 0c5: aload 0
      // 0c6: getfield x/ocbce5ea28a3.ϯ J
      // 0c9: invokestatic x/oc981d71de6a.k (Lx/oc847503a8ab;J)Lx/oc981d71de6a;
      // 0cc: putfield x/ocbce5ea28a3.ɹ Lx/oc981d71de6a;
      // 0cf: aload 0
      // 0d0: bipush 1
      // 0d1: putfield x/ocbce5ea28a3.Ć Z
      // 0d4: aload 0
      // 0d5: getfield x/ocbce5ea28a3.Ǚ Lx/oc668fce0dbf;
      // 0d8: new x/oc84f20a0bc5
      // 0db: dup
      // 0dc: aload 3
      // 0dd: getfield x/oc847503a8ab.ß Lx/oc1a421bd3db;
      // 0e0: getfield x/oc1a421bd3db.ʚ Lnet/minecraft/util/BlockPos;
      // 0e3: aload 3
      // 0e4: getfield x/oc847503a8ab.ß Lx/oc1a421bd3db;
      // 0e7: getfield x/oc1a421bd3db.Փ Lnet/minecraft/util/EnumFacing;
      // 0ea: invokespecial x/oc84f20a0bc5.<init> (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;)V
      // 0ed: aload 3
      // 0ee: invokevirtual x/oc847503a8ab.Χ ()Lnet/minecraft/util/MovingObjectPosition;
      // 0f1: invokevirtual x/oc668fce0dbf.Ѭ (Lx/oc84f20a0bc5;Lnet/minecraft/util/MovingObjectPosition;)Z
      // 0f4: istore 4
      // 0f6: aload 0
      // 0f7: bipush 0
      // 0f8: putfield x/ocbce5ea28a3.Ć Z
      // 0fb: goto 108
      // 0fe: astore 5
      // 100: aload 0
      // 101: bipush 0
      // 102: putfield x/ocbce5ea28a3.Ć Z
      // 105: aload 5
      // 107: athrow
      // 108: aload 0
      // 109: iload 2
      // 10a: ifne 14f
      // 10d: getfield x/ocbce5ea28a3.Ш Lx/occ00ef6c188;
      // 110: ifnull 140
      // 113: goto 117
      // 116: athrow
      // 117: aload 0
      // 118: iload 2
      // 119: ifne 14f
      // 11c: goto 120
      // 11f: athrow
      // 120: getfield x/ocbce5ea28a3.ɹ Lx/oc981d71de6a;
      // 123: ifnull 140
      // 126: goto 12a
      // 129: athrow
      // 12a: aload 0
      // 12b: iload 2
      // 12c: ifne 16c
      // 12f: goto 133
      // 132: athrow
      // 133: getfield x/ocbce5ea28a3.ɹ Lx/oc981d71de6a;
      // 136: getfield x/oc981d71de6a.ɂ Lnet/minecraft/network/play/client/C08PacketPlayerBlockPlacement;
      // 139: ifnonnull 156
      // 13c: goto 140
      // 13f: athrow
      // 140: aload 0
      // 141: aconst_null
      // 142: putfield x/ocbce5ea28a3.ɹ Lx/oc981d71de6a;
      // 145: aload 0
      // 146: aconst_null
      // 147: putfield x/ocbce5ea28a3.Ղ Lx/oc847503a8ab;
      // 14a: aload 0
      // 14b: goto 14f
      // 14e: athrow
      // 14f: getstatic x/oc06124119aa.ί Lx/oc06124119aa;
      // 152: putfield x/ocbce5ea28a3.ɓ Lx/oc06124119aa;
      // 155: return
      // 156: aload 0
      // 157: aload 0
      // 158: iload 2
      // 159: ifne 17b
      // 15c: getfield x/ocbce5ea28a3.ϯ J
      // 15f: putfield x/ocbce5ea28a3.ւ J
      // 162: aload 0
      // 163: aconst_null
      // 164: putfield x/ocbce5ea28a3.Ƕ Lx/oc1a421bd3db;
      // 167: aload 0
      // 168: goto 16c
      // 16b: athrow
      // 16c: aconst_null
      // 16d: putfield x/ocbce5ea28a3.Ղ Lx/oc847503a8ab;
      // 170: iload 4
      // 172: ifne 191
      // 175: aload 0
      // 176: aload 0
      // 177: goto 17b
      // 17a: athrow
      // 17b: getfield x/ocbce5ea28a3.Ш Lx/occ00ef6c188;
      // 17e: getfield x/occ00ef6c188.ԁ Z
      // 181: ifeq 18b
      // 184: getstatic x/oc06124119aa.Ⱦ Lx/oc06124119aa;
      // 187: goto 18e
      // 18a: athrow
      // 18b: getstatic x/oc06124119aa.Ɓ Lx/oc06124119aa;
      // 18e: putfield x/ocbce5ea28a3.ɓ Lx/oc06124119aa;
      // 191: return
   }

   private void ϋ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: aload 0
      // 01: aconst_null
      // 02: putfield x/ocbce5ea28a3.Ш Lx/occ00ef6c188;
      // 05: getstatic x/oc84f20a0bc5.ė I
      // 08: aload 0
      // 09: aconst_null
      // 0a: putfield x/ocbce5ea28a3.ɹ Lx/oc981d71de6a;
      // 0d: istore 1
      // 0e: aload 0
      // 0f: iload 1
      // 10: ifne 35
      // 13: aconst_null
      // 14: putfield x/ocbce5ea28a3.Ղ Lx/oc847503a8ab;
      // 17: aload 0
      // 18: aconst_null
      // 19: putfield x/ocbce5ea28a3.Ƕ Lx/oc1a421bd3db;
      // 1c: aload 0
      // 1d: getstatic x/oc06124119aa.ƌ Lx/oc06124119aa;
      // 20: putfield x/ocbce5ea28a3.ɓ Lx/oc06124119aa;
      // 23: aload 0
      // 24: getfield x/ocbce5ea28a3.Ժ Z
      // 27: ifne 34
      // 2a: goto 2e
      // 2d: athrow
      // 2e: aload 0
      // 2f: invokevirtual x/ocbce5ea28a3.C ()V
      // 32: return
      // 33: athrow
      // 34: aload 0
      // 35: getfield x/ocbce5ea28a3.Ǚ Lx/oc668fce0dbf;
      // 38: invokevirtual x/oc668fce0dbf.ն ()Lnet/minecraft/client/entity/EntityPlayerSP;
      // 3b: astore 2
      // 3c: iload 1
      // 3d: ifne 86
      // 40: aload 0
      // 41: invokevirtual x/ocbce5ea28a3.ӎ ()Z
      // 44: ifne 7e
      // 47: goto 4b
      // 4a: athrow
      // 4b: aload 2
      // 4c: iload 1
      // 4d: ifne 5c
      // 50: goto 54
      // 53: athrow
      // 54: ifnull 7e
      // 57: goto 5b
      // 5a: athrow
      // 5b: aload 2
      // 5c: getfield net/minecraft/client/entity/EntityPlayerSP.onGround Z
      // 5f: iload 1
      // 60: ifne 7b
      // 63: ifne 7e
      // 66: goto 6a
      // 69: athrow
      // 6a: aload 0
      // 6b: iload 1
      // 6c: ifne a3
      // 6f: goto 73
      // 72: athrow
      // 73: aload 2
      // 74: invokevirtual x/ocbce5ea28a3.â (Lnet/minecraft/client/entity/EntityPlayerSP;)Z
      // 77: goto 7b
      // 7a: athrow
      // 7b: ifeq 8a
      // 7e: aload 0
      // 7f: invokevirtual x/ocbce5ea28a3.Ǆ ()V
      // 82: goto 86
      // 85: athrow
      // 86: iload 1
      // 87: ifeq b7
      // 8a: aload 0
      // 8b: getstatic x/oc65fedf8d38.ė Lx/oc65fedf8d38;
      // 8e: putfield x/ocbce5ea28a3.Ѻ Lx/oc65fedf8d38;
      // 91: aload 0
      // 92: aload 0
      // 93: aload 0
      // 94: getfield x/ocbce5ea28a3.Ο Lnet/minecraft/util/BlockPos;
      // 97: aload 2
      // 98: invokevirtual x/ocbce5ea28a3.վ (Lnet/minecraft/util/BlockPos;Lnet/minecraft/client/entity/EntityPlayerSP;)Lx/oc1a421bd3db;
      // 9b: putfield x/ocbce5ea28a3.Ƕ Lx/oc1a421bd3db;
      // 9e: aload 0
      // 9f: goto a3
      // a2: athrow
      // a3: aload 0
      // a4: getfield x/ocbce5ea28a3.Ƕ Lx/oc1a421bd3db;
      // a7: ifnonnull b1
      // aa: getstatic x/oc06124119aa.ƌ Lx/oc06124119aa;
      // ad: goto b4
      // b0: athrow
      // b1: getstatic x/oc06124119aa.ί Lx/oc06124119aa;
      // b4: putfield x/ocbce5ea28a3.ɓ Lx/oc06124119aa;
      // b7: return
   }

   private void Ø(EntityPlayerSP param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: istore 2
      // 004: aload 0
      // 005: iload 2
      // 006: ifne 0a4
      // 009: getfield x/ocbce5ea28a3.Ѻ Lx/oc65fedf8d38;
      // 00c: getstatic x/oc65fedf8d38.В Lx/oc65fedf8d38;
      // 00f: if_acmpne 0a3
      // 012: goto 016
      // 015: athrow
      // 016: aload 1
      // 017: getfield net/minecraft/client/entity/EntityPlayerSP.onGround Z
      // 01a: iload 2
      // 01b: ifne 09a
      // 01e: goto 022
      // 021: athrow
      // 022: ifne 081
      // 025: goto 029
      // 028: athrow
      // 029: aload 0
      // 02a: bipush 1
      // 02b: putfield x/ocbce5ea28a3.Ҏ I
      // 02e: iload 2
      // 02f: ifne 06b
      // 032: goto 036
      // 035: athrow
      // 036: aload 0
      // 037: getfield x/ocbce5ea28a3.ɐ Z
      // 03a: ifeq 060
      // 03d: goto 041
      // 040: athrow
      // 041: aload 0
      // 042: aload 0
      // 043: getfield x/ocbce5ea28a3.Ѻ Lx/oc65fedf8d38;
      // 046: bipush 1
      // 047: aload 0
      // 048: getfield x/ocbce5ea28a3.φ I
      // 04b: invokestatic x/ocbce5ea28a3.ƴ (Lx/oc65fedf8d38;ZI)Lx/oc65fedf8d38;
      // 04e: putfield x/ocbce5ea28a3.Ѻ Lx/oc65fedf8d38;
      // 051: iload 2
      // 052: aload 0
      // 053: getstatic x/oc06124119aa.ƌ Lx/oc06124119aa;
      // 056: putfield x/ocbce5ea28a3.ɓ Lx/oc06124119aa;
      // 059: ifeq 0a3
      // 05c: goto 060
      // 05f: athrow
      // 060: aload 0
      // 061: getstatic x/oc65fedf8d38.ė Lx/oc65fedf8d38;
      // 064: putfield x/ocbce5ea28a3.Ѻ Lx/oc65fedf8d38;
      // 067: goto 06b
      // 06a: athrow
      // 06b: aload 0
      // 06c: aload 0
      // 06d: getfield x/ocbce5ea28a3.Ƕ Lx/oc1a421bd3db;
      // 070: ifnonnull 07a
      // 073: getstatic x/oc06124119aa.ƌ Lx/oc06124119aa;
      // 076: goto 07d
      // 079: athrow
      // 07a: getstatic x/oc06124119aa.ί Lx/oc06124119aa;
      // 07d: putfield x/ocbce5ea28a3.ɓ Lx/oc06124119aa;
      // 080: return
      // 081: aload 0
      // 082: iload 2
      // 083: ifne 0a4
      // 086: getfield x/ocbce5ea28a3.ϯ J
      // 089: aload 0
      // 08a: getfield x/ocbce5ea28a3.ќ J
      // 08d: lsub
      // 08e: ldc2_w -8882840502692487418
      // 091: ldc2_w -8882840502692487420
      // 094: lxor
      // 095: lcmp
      // 096: goto 09a
      // 099: athrow
      // 09a: ifle 0a3
      // 09d: aload 0
      // 09e: invokevirtual x/ocbce5ea28a3.C ()V
      // 0a1: return
      // 0a2: athrow
      // 0a3: aload 0
      // 0a4: iload 2
      // 0a5: ifne 0e4
      // 0a8: getfield x/ocbce5ea28a3.Ѻ Lx/oc65fedf8d38;
      // 0ab: getstatic x/oc65fedf8d38.Ǯ Lx/oc65fedf8d38;
      // 0ae: if_acmpne 0e3
      // 0b1: goto 0b5
      // 0b4: athrow
      // 0b5: aload 1
      // 0b6: getfield net/minecraft/client/entity/EntityPlayerSP.onGround Z
      // 0b9: iload 2
      // 0ba: ifne 0db
      // 0bd: goto 0c1
      // 0c0: athrow
      // 0c1: ifeq 0ce
      // 0c4: goto 0c8
      // 0c7: athrow
      // 0c8: aload 0
      // 0c9: invokevirtual x/ocbce5ea28a3.Ǆ ()V
      // 0cc: return
      // 0cd: athrow
      // 0ce: aload 0
      // 0cf: iload 2
      // 0d0: ifne 0df
      // 0d3: aload 1
      // 0d4: invokevirtual x/ocbce5ea28a3.ը (Lnet/minecraft/client/entity/EntityPlayerSP;)Z
      // 0d7: goto 0db
      // 0da: athrow
      // 0db: ifne 0e2
      // 0de: aload 0
      // 0df: invokevirtual x/ocbce5ea28a3.Ď ()V
      // 0e2: return
      // 0e3: aload 0
      // 0e4: iload 2
      // 0e5: ifne 15c
      // 0e8: getfield x/ocbce5ea28a3.Ѻ Lx/oc65fedf8d38;
      // 0eb: getstatic x/oc65fedf8d38.И Lx/oc65fedf8d38;
      // 0ee: if_acmpne 157
      // 0f1: goto 0f5
      // 0f4: athrow
      // 0f5: aload 0
      // 0f6: iload 2
      // 0f7: ifne 119
      // 0fa: goto 0fe
      // 0fd: athrow
      // 0fe: dup
      // 0ff: getfield x/ocbce5ea28a3.Ҏ I
      // 102: bipush 1
      // 103: iadd
      // 104: putfield x/ocbce5ea28a3.Ҏ I
      // 107: aload 1
      // 108: getfield net/minecraft/client/entity/EntityPlayerSP.onGround Z
      // 10b: ifeq 118
      // 10e: goto 112
      // 111: athrow
      // 112: aload 0
      // 113: invokevirtual x/ocbce5ea28a3.Ǆ ()V
      // 116: return
      // 117: athrow
      // 118: aload 0
      // 119: getfield x/ocbce5ea28a3.Ѻ Lx/oc65fedf8d38;
      // 11c: bipush 1
      // 11d: aload 0
      // 11e: getfield x/ocbce5ea28a3.φ I
      // 121: invokestatic x/ocbce5ea28a3.ƴ (Lx/oc65fedf8d38;ZI)Lx/oc65fedf8d38;
      // 124: astore 3
      // 125: iload 2
      // 126: ifne 14c
      // 129: aload 3
      // 12a: getstatic x/oc65fedf8d38.ė Lx/oc65fedf8d38;
      // 12d: if_acmpne 153
      // 130: goto 134
      // 133: athrow
      // 134: aload 0
      // 135: aload 3
      // 136: putfield x/ocbce5ea28a3.Ѻ Lx/oc65fedf8d38;
      // 139: aload 0
      // 13a: bipush 0
      // 13b: putfield x/ocbce5ea28a3.џ Z
      // 13e: aload 0
      // 13f: aconst_null
      // 140: putfield x/ocbce5ea28a3.Ƕ Lx/oc1a421bd3db;
      // 143: aload 0
      // 144: aconst_null
      // 145: putfield x/ocbce5ea28a3.Ղ Lx/oc847503a8ab;
      // 148: goto 14c
      // 14b: athrow
      // 14c: aload 0
      // 14d: getstatic x/oc06124119aa.ƌ Lx/oc06124119aa;
      // 150: putfield x/ocbce5ea28a3.ɓ Lx/oc06124119aa;
      // 153: iload 2
      // 154: ifeq 17b
      // 157: aload 0
      // 158: goto 15c
      // 15b: athrow
      // 15c: getfield x/ocbce5ea28a3.Ѻ Lx/oc65fedf8d38;
      // 15f: iload 2
      // 160: ifne 187
      // 163: getstatic x/oc65fedf8d38.ė Lx/oc65fedf8d38;
      // 166: if_acmpne 17b
      // 169: goto 16d
      // 16c: athrow
      // 16d: aload 0
      // 16e: dup
      // 16f: getfield x/ocbce5ea28a3.Ҏ I
      // 172: bipush 1
      // 173: iadd
      // 174: putfield x/ocbce5ea28a3.Ҏ I
      // 177: goto 17b
      // 17a: athrow
      // 17b: aload 0
      // 17c: iload 2
      // 17d: ifne 192
      // 180: getfield x/ocbce5ea28a3.Ѻ Lx/oc65fedf8d38;
      // 183: goto 187
      // 186: athrow
      // 187: getstatic x/oc65fedf8d38.И Lx/oc65fedf8d38;
      // 18a: if_acmpeq 1a3
      // 18d: aload 0
      // 18e: goto 192
      // 191: athrow
      // 192: iload 2
      // 193: ifne 1e3
      // 196: getfield x/ocbce5ea28a3.Ѻ Lx/oc65fedf8d38;
      // 199: getstatic x/oc65fedf8d38.ė Lx/oc65fedf8d38;
      // 19c: if_acmpne 1e2
      // 19f: goto 1a3
      // 1a2: athrow
      // 1a3: aload 1
      // 1a4: getfield net/minecraft/client/entity/EntityPlayerSP.onGround Z
      // 1a7: iload 2
      // 1a8: ifne 1f1
      // 1ab: goto 1af
      // 1ae: athrow
      // 1af: ifeq 1e2
      // 1b2: goto 1b6
      // 1b5: athrow
      // 1b6: aload 0
      // 1b7: iload 2
      // 1b8: ifne 1e3
      // 1bb: goto 1bf
      // 1be: athrow
      // 1bf: getfield x/ocbce5ea28a3.ɹ Lx/oc981d71de6a;
      // 1c2: ifnonnull 1e2
      // 1c5: goto 1c9
      // 1c8: athrow
      // 1c9: aload 0
      // 1ca: iload 2
      // 1cb: ifne 1e3
      // 1ce: goto 1d2
      // 1d1: athrow
      // 1d2: getfield x/ocbce5ea28a3.Ш Lx/occ00ef6c188;
      // 1d5: ifnonnull 1e2
      // 1d8: goto 1dc
      // 1db: athrow
      // 1dc: aload 0
      // 1dd: invokevirtual x/ocbce5ea28a3.Ǆ ()V
      // 1e0: return
      // 1e1: athrow
      // 1e2: aload 0
      // 1e3: iload 2
      // 1e4: ifne 1f5
      // 1e7: getfield x/ocbce5ea28a3.Ѻ Lx/oc65fedf8d38;
      // 1ea: invokestatic x/ocbce5ea28a3.β (Lx/oc65fedf8d38;)Z
      // 1ed: goto 1f1
      // 1f0: athrow
      // 1f1: ifeq 225
      // 1f4: aload 0
      // 1f5: getfield x/ocbce5ea28a3.ʐ I
      // 1f8: iload 2
      // 1f9: ifne 21a
      // 1fc: ldc_w -1370906805
      // 1ff: ldc_w 776576843
      // 202: ixor
      // 203: if_icmpeq 225
      // 206: goto 20a
      // 209: athrow
      // 20a: aload 1
      // 20b: getfield net/minecraft/client/entity/EntityPlayerSP.posY D
      // 20e: aload 0
      // 20f: getfield x/ocbce5ea28a3.ʐ I
      // 212: i2d
      // 213: dconst_1
      // 214: dsub
      // 215: dcmpg
      // 216: goto 21a
      // 219: athrow
      // 21a: ifge 225
      // 21d: aload 0
      // 21e: invokevirtual x/ocbce5ea28a3.C ()V
      // 221: goto 225
      // 224: athrow
      // 225: return
   }

   private void Ď() {
      this.Ѻ = oc65fedf8d38.И;
      this.φ = 0;
      this.Ƕ = null;
      this.Ղ = null;
      this.ɹ = null;
      this.Ш = null;
      this.ɓ = oc06124119aa.ƌ;
      this.џ = false;
   }

   private void C() {
      this.ɹ = null;
      this.Ш = null;
      this.Ղ = null;
      this.Ƕ = null;
      this.ɓ = oc06124119aa.ƌ;
      this.Ć = false;
      this.Ͼ.ȓ();
      this.Ǆ();
   }

   private void Ǆ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 45
      // 09: aconst_null
      // 0a: putfield x/ocbce5ea28a3.Ƕ Lx/oc1a421bd3db;
      // 0d: aload 0
      // 0e: aconst_null
      // 0f: putfield x/ocbce5ea28a3.Ղ Lx/oc847503a8ab;
      // 12: aload 0
      // 13: getstatic x/oc06124119aa.ƌ Lx/oc06124119aa;
      // 16: putfield x/ocbce5ea28a3.ɓ Lx/oc06124119aa;
      // 19: aload 0
      // 1a: getfield x/ocbce5ea28a3.Լ Z
      // 1d: ifeq 40
      // 20: goto 24
      // 23: athrow
      // 24: aload 0
      // 25: getstatic x/oc65fedf8d38.Ό Lx/oc65fedf8d38;
      // 28: putfield x/ocbce5ea28a3.Ѻ Lx/oc65fedf8d38;
      // 2b: iload 1
      // 2c: aload 0
      // 2d: aload 0
      // 2e: getfield x/ocbce5ea28a3.Ӝ J
      // 31: putfield x/ocbce5ea28a3.ʁ J
      // 34: aload 0
      // 35: bipush 0
      // 36: putfield x/ocbce5ea28a3.ʨ Z
      // 39: ifeq 48
      // 3c: goto 40
      // 3f: athrow
      // 40: aload 0
      // 41: goto 45
      // 44: athrow
      // 45: invokevirtual x/ocbce5ea28a3.º ()V
      // 48: return
   }

   private void º() {
      this.Ѻ = oc65fedf8d38.ѻ;
      this.ќ = 3925400365357853424L ^ -5297971671496922384L;
      this.ʁ = -3925400365357853425L ^ -5297971671496922384L;
      this.ʐ = 1810899923 ^ -336583725;
      this.Ҏ = 0;
      this.Ƕ = null;
      this.Ղ = null;
      this.ɹ = null;
      this.Ш = null;
      this.ɓ = oc06124119aa.ƌ;
      this.Ć = false;
      this.ҽ = null;
      this.Ο = null;
      this.Օ = 0.0F;
      this.Ӂ = 0.0F;
      this.π = 0.0;
      this.Ԅ = 0.0;
      this.Ӭ = 0.0F;
      this.A = 0.0F;
      this.Ś = this.ɞ;
      this.Η = this.Ӑ;
      this.Լ = false;
      this.ʨ = false;
      this.Ժ = false;
      this.џ = false;
      this.ԣ = false;
      this.e = null;
      this.ɐ = false;
      this.φ = 0;
      this.d = false;
      this.Ͼ.ȓ();
      this.ȷ = false;
      this.Ǚ.Σ(false);
   }

   private boolean œ(long var1) {
      long var4 = 0L;
      int var6 = 884080370 ^ 1082333457;
      int var3 = oc84f20a0bc5.ė;

      while (true) {
         switch (var6) {
            case -544263381:
               var4 = this.ɹ.խ;
               var6 = -634635775 ^ 1082333457;
               if (var3 == 0) {
                  break;
               }
            case 2122393360:
               var4 = 2775037906709472268L ^ 6448334130145303539L;
               var6 = -634635775 ^ 1082333457;
               if (var3 == 0) {
                  break;
               }
            case 1949493219:
               if (this.Ш != null) {
                  var6 = 954553099 ^ 1082333457;
                  if (var3 == 0) {
                     break;
                  }
               }

               var6 = -881970813 ^ 1082333457;
               if (var3 == 0) {
                  break;
               }
            case -1947391854:
               if (this.ɹ != null) {
                  var6 = -1626592710 ^ 1082333457;
                  if (var3 == 0) {
                     break;
                  }
               }

               var6 = 1040334337 ^ 1082333457;
               if (var3 == 0) {
                  break;
               }
            case 2019969562:
               var4 = this.Ш.ʊ;
               var6 = -634635775 ^ 1082333457;
               if (var3 == 0) {
                  break;
               }
            case -1699798256:
               return M(var4, var1, 1082333445 ^ 1082333457);
            default:
               throw null;
         }
      }
   }

   private boolean ǔ() {
      int var1 = oc84f20a0bc5.ė;
      int var2 = -231487943 ^ -1239453887;

      while (true) {
         switch (var2) {
            case -1041628447:
               if (this.Ǚ.ն() != null) {
                  var2 = -2063122435 ^ -1239453887;
                  if (var1 == 0) {
                     continue;
                  }
               }

               var2 = -1269406131 ^ -1239453887;
               if (var1 == 0) {
                  continue;
               }
            case -69316249:
               if (this.Ѭ.theWorld != null) {
                  var2 = 2012573088 ^ -1239453887;
                  if (var1 == 0) {
                     continue;
                  }
               }

               var2 = -1269406131 ^ -1239453887;
               if (var1 == 0) {
                  continue;
               }
               break;
            case 38340876:
               return false;
            case 857231548:
               if (this.Ѭ.currentScreen == null) {
                  var2 = -1653841182 ^ -1239453887;
                  if (var1 == 0) {
                     continue;
                  }
               }

               var2 = -1269406131 ^ -1239453887;
               if (var1 == 0) {
                  continue;
               }
            case 728960419:
               return true;
            case 1143777656:
               break;
            default:
               throw null;
         }

         int var10000;
         label50: {
            label49: {
               try {
                  var10000 = oc7ab2161b9f.Ð();
                  if (var1 != 0) {
                     break label50;
                  }

                  if (var10000 == 0) {
                     break label49;
                  }
               } catch (ocbde1165e4e var3) {
                  throw var3;
               }

               var2 = 1304509990 ^ -1239453887;
               if (var1 == 0) {
                  continue;
               }
            }

            var10000 = -1269406131 ^ -1239453887;
         }

         var2 = var10000;
      }
   }

   private void ǳ(EntityPlayerSP param1, oc53b792ae32 param2, BlockPos param3, oc23ff80be39 param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: aload 0
      // 004: aload 3
      // 005: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 008: putfield x/ocbce5ea28a3.ʐ I
      // 00b: aload 0
      // 00c: aload 1
      // 00d: getfield net/minecraft/client/entity/EntityPlayerSP.posX D
      // 010: putfield x/ocbce5ea28a3.Ű D
      // 013: aload 0
      // 014: aload 1
      // 015: getfield net/minecraft/client/entity/EntityPlayerSP.posZ D
      // 018: putfield x/ocbce5ea28a3.ł D
      // 01b: aload 0
      // 01c: aload 2
      // 01d: getfield x/oc53b792ae32.ѧ F
      // 020: putfield x/ocbce5ea28a3.Օ F
      // 023: aload 0
      // 024: aload 2
      // 025: getfield x/oc53b792ae32.ȸ F
      // 028: putfield x/ocbce5ea28a3.Ӂ F
      // 02b: istore 5
      // 02d: aload 2
      // 02e: getfield x/oc53b792ae32.ɇ F
      // 031: aload 0
      // 032: getfield x/ocbce5ea28a3.Օ F
      // 035: aload 0
      // 036: getfield x/ocbce5ea28a3.Ӂ F
      // 039: invokestatic x/ocbce5ea28a3.Ӓ (FFF)[D
      // 03c: astore 6
      // 03e: aload 0
      // 03f: aload 6
      // 041: iload 5
      // 043: ifne 054
      // 046: ifnonnull 052
      // 049: goto 04d
      // 04c: athrow
      // 04d: dconst_0
      // 04e: goto 056
      // 051: athrow
      // 052: aload 6
      // 054: bipush 0
      // 055: daload
      // 056: putfield x/ocbce5ea28a3.π D
      // 059: aload 0
      // 05a: aload 6
      // 05c: iload 5
      // 05e: ifne 06f
      // 061: ifnonnull 06d
      // 064: goto 068
      // 067: athrow
      // 068: dconst_0
      // 069: goto 071
      // 06c: athrow
      // 06d: aload 6
      // 06f: bipush 1
      // 070: daload
      // 071: putfield x/ocbce5ea28a3.Ԅ D
      // 074: aload 0
      // 075: aload 2
      // 076: iload 5
      // 078: ifne 08d
      // 07b: getfield x/oc53b792ae32.ɇ F
      // 07e: invokestatic x/ocbce5ea28a3.С (F)Z
      // 081: ifeq 093
      // 084: goto 088
      // 087: athrow
      // 088: aload 2
      // 089: goto 08d
      // 08c: athrow
      // 08d: getfield x/oc53b792ae32.ɇ F
      // 090: goto 097
      // 093: aload 1
      // 094: getfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 097: putfield x/ocbce5ea28a3.ɞ F
      // 09a: aload 0
      // 09b: aload 2
      // 09c: iload 5
      // 09e: ifne 0b3
      // 0a1: getfield x/oc53b792ae32.ȼ F
      // 0a4: invokestatic x/ocbce5ea28a3.С (F)Z
      // 0a7: ifeq 0c1
      // 0aa: goto 0ae
      // 0ad: athrow
      // 0ae: aload 2
      // 0af: goto 0b3
      // 0b2: athrow
      // 0b3: getfield x/oc53b792ae32.ȼ F
      // 0b6: ldc_w -90.0
      // 0b9: ldc 90.0
      // 0bb: invokestatic net/minecraft/util/MathHelper.clamp_float (FFF)F
      // 0be: goto 0c5
      // 0c1: aload 1
      // 0c2: getfield net/minecraft/client/entity/EntityPlayerSP.rotationPitch F
      // 0c5: putfield x/ocbce5ea28a3.Ӑ F
      // 0c8: aload 6
      // 0ca: ifnonnull 0d5
      // 0cd: aload 0
      // 0ce: getfield x/ocbce5ea28a3.ɞ F
      // 0d1: goto 0e5
      // 0d4: athrow
      // 0d5: aload 0
      // 0d6: getfield x/ocbce5ea28a3.π D
      // 0d9: dneg
      // 0da: aload 0
      // 0db: getfield x/ocbce5ea28a3.Ԅ D
      // 0de: invokestatic java/lang/Math.atan2 (DD)D
      // 0e1: invokestatic java/lang/Math.toDegrees (D)D
      // 0e4: d2f
      // 0e5: fstore 7
      // 0e7: aload 0
      // 0e8: iload 5
      // 0ea: ifne 11a
      // 0ed: getfield x/ocbce5ea28a3.ʡ Lx/oc791986a759;
      // 0f0: ifnull 119
      // 0f3: goto 0f7
      // 0f6: athrow
      // 0f7: aload 0
      // 0f8: iload 5
      // 0fa: ifne 11a
      // 0fd: goto 101
      // 100: athrow
      // 101: getfield x/ocbce5ea28a3.ʡ Lx/oc791986a759;
      // 104: getfield x/oc791986a759.ŕ Z
      // 107: ifeq 119
      // 10a: goto 10e
      // 10d: athrow
      // 10e: aload 0
      // 10f: getfield x/ocbce5ea28a3.ʡ Lx/oc791986a759;
      // 112: getfield x/oc791986a759.Ά F
      // 115: goto 11d
      // 118: athrow
      // 119: aload 0
      // 11a: getfield x/ocbce5ea28a3.ɞ F
      // 11d: fstore 8
      // 11f: aload 0
      // 120: fload 8
      // 122: fload 7
      // 124: fload 8
      // 126: invokestatic x/ocbce5ea28a3.Ԇ (FF)F
      // 129: aload 0
      // 12a: invokevirtual x/ocbce5ea28a3.Щ ()F
      // 12d: invokestatic x/ocbce5ea28a3.Ҁ (FFF)F
      // 130: putfield x/ocbce5ea28a3.A F
      // 133: aload 0
      // 134: aload 0
      // 135: getfield x/ocbce5ea28a3.A F
      // 138: aload 0
      // 139: getfield x/ocbce5ea28a3.Ǚ Lx/oc668fce0dbf;
      // 13c: invokevirtual x/oc668fce0dbf.ʓ ()F
      // 13f: aload 0
      // 140: getfield x/ocbce5ea28a3.ɞ F
      // 143: invokestatic x/ocbce5ea28a3.ʆ (FFF)F
      // 146: putfield x/ocbce5ea28a3.Ӭ F
      // 149: aload 0
      // 14a: getfield x/ocbce5ea28a3.ɞ F
      // 14d: aload 0
      // 14e: getfield x/ocbce5ea28a3.A F
      // 151: aload 0
      // 152: getfield x/ocbce5ea28a3.Օ F
      // 155: aload 0
      // 156: getfield x/ocbce5ea28a3.Ӂ F
      // 159: bipush 0
      // 15a: invokestatic x/oc7beea7ccff.p (FFFFZ)Lx/oc1c4f5dd176;
      // 15d: astore 9
      // 15f: new x/oceb7a9b9a85
      // 162: dup
      // 163: aload 0
      // 164: getfield x/ocbce5ea28a3.ɞ F
      // 167: aload 0
      // 168: getfield x/ocbce5ea28a3.A F
      // 16b: aload 0
      // 16c: getfield x/ocbce5ea28a3.Օ F
      // 16f: aload 0
      // 170: getfield x/ocbce5ea28a3.Ӂ F
      // 173: aload 9
      // 175: getfield x/oc1c4f5dd176.ˠ F
      // 178: aload 9
      // 17a: getfield x/oc1c4f5dd176.ô F
      // 17d: bipush 0
      // 17e: aload 2
      // 17f: getfield x/oc53b792ae32.ʶ Z
      // 182: invokespecial x/oceb7a9b9a85.<init> (FFFFFFZZ)V
      // 185: astore 10
      // 187: aload 0
      // 188: iload 5
      // 18a: ifne 248
      // 18d: new x/oc30b42710ad
      // 190: dup
      // 191: aload 4
      // 193: aload 3
      // 194: aload 10
      // 196: aload 0
      // 197: getfield x/ocbce5ea28a3.π D
      // 19a: aload 0
      // 19b: getfield x/ocbce5ea28a3.Ԅ D
      // 19e: aload 0
      // 19f: getfield x/ocbce5ea28a3.Ű D
      // 1a2: aload 0
      // 1a3: getfield x/ocbce5ea28a3.ł D
      // 1a6: aload 0
      // 1a7: getfield x/ocbce5ea28a3.A F
      // 1aa: aload 0
      // 1ab: getfield x/ocbce5ea28a3.ɞ F
      // 1ae: aload 0
      // 1af: getfield x/ocbce5ea28a3.Ӑ F
      // 1b2: aload 0
      // 1b3: getfield x/ocbce5ea28a3.Ӭ F
      // 1b6: invokespecial x/oc30b42710ad.<init> (Lx/oc23ff80be39;Lnet/minecraft/util/BlockPos;Lx/oceb7a9b9a85;DDDDFFFF)V
      // 1b9: putfield x/ocbce5ea28a3.ҽ Lx/oc30b42710ad;
      // 1bc: aload 4
      // 1be: getstatic x/oc23ff80be39.Ǆ Lx/oc23ff80be39;
      // 1c1: if_acmpne 243
      // 1c4: goto 1c8
      // 1c7: athrow
      // 1c8: aload 0
      // 1c9: iload 5
      // 1cb: ifne 218
      // 1ce: getfield x/ocbce5ea28a3.б Lx/oc7b822110db;
      // 1d1: ifnull 213
      // 1d4: goto 1d8
      // 1d7: athrow
      // 1d8: aload 0
      // 1d9: iload 5
      // 1db: ifne 218
      // 1de: goto 1e2
      // 1e1: athrow
      // 1e2: getfield x/ocbce5ea28a3.б Lx/oc7b822110db;
      // 1e5: aload 3
      // 1e6: aload 0
      // 1e7: getfield x/ocbce5ea28a3.π D
      // 1ea: aload 0
      // 1eb: getfield x/ocbce5ea28a3.Ԅ D
      // 1ee: invokestatic x/ocbce5ea28a3.ł (Lx/oc7b822110db;Lnet/minecraft/util/BlockPos;DD)Z
      // 1f1: ifeq 213
      // 1f4: goto 1f8
      // 1f7: athrow
      // 1f8: aload 0
      // 1f9: aload 0
      // 1fa: iload 5
      // 1fc: ifne 235
      // 1ff: goto 203
      // 202: athrow
      // 203: getfield x/ocbce5ea28a3.б Lx/oc7b822110db;
      // 206: invokevirtual x/oc7b822110db.Ȍ ()Lnet/minecraft/util/BlockPos;
      // 209: invokevirtual x/ocbce5ea28a3.Ζ (Lnet/minecraft/util/BlockPos;)Z
      // 20c: ifne 233
      // 20f: goto 213
      // 212: athrow
      // 213: aload 0
      // 214: goto 218
      // 217: athrow
      // 218: new x/oc7b822110db
      // 21b: dup
      // 21c: aload 3
      // 21d: aload 0
      // 21e: getfield x/ocbce5ea28a3.Ű D
      // 221: aload 0
      // 222: getfield x/ocbce5ea28a3.ł D
      // 225: aload 0
      // 226: getfield x/ocbce5ea28a3.π D
      // 229: aload 0
      // 22a: getfield x/ocbce5ea28a3.Ԅ D
      // 22d: invokespecial x/oc7b822110db.<init> (Lnet/minecraft/util/BlockPos;DDDD)V
      // 230: putfield x/ocbce5ea28a3.б Lx/oc7b822110db;
      // 233: aload 0
      // 234: aload 0
      // 235: getfield x/ocbce5ea28a3.б Lx/oc7b822110db;
      // 238: invokevirtual x/oc7b822110db.Ȍ ()Lnet/minecraft/util/BlockPos;
      // 23b: putfield x/ocbce5ea28a3.Ο Lnet/minecraft/util/BlockPos;
      // 23e: iload 5
      // 240: ifeq 24c
      // 243: aload 0
      // 244: goto 248
      // 247: athrow
      // 248: aload 3
      // 249: putfield x/ocbce5ea28a3.Ο Lnet/minecraft/util/BlockPos;
      // 24c: aload 0
      // 24d: bipush 1
      // 24e: putfield x/ocbce5ea28a3.Լ Z
      // 251: aload 0
      // 252: bipush 0
      // 253: putfield x/ocbce5ea28a3.ʨ Z
      // 256: aload 0
      // 257: bipush 0
      // 258: iload 5
      // 25a: ifne 282
      // 25d: putfield x/ocbce5ea28a3.џ Z
      // 260: aload 0
      // 261: bipush 0
      // 262: putfield x/ocbce5ea28a3.ԣ Z
      // 265: aload 0
      // 266: aconst_null
      // 267: putfield x/ocbce5ea28a3.e Lnet/minecraft/util/BlockPos;
      // 26a: aload 0
      // 26b: aload 4
      // 26d: getstatic x/oc23ff80be39.Ǆ Lx/oc23ff80be39;
      // 270: if_acmpne 292
      // 273: goto 277
      // 276: athrow
      // 277: aload 0
      // 278: getfield x/ocbce5ea28a3.Ǚ Lx/oc668fce0dbf;
      // 27b: invokevirtual x/oc668fce0dbf.ӌ ()Z
      // 27e: goto 282
      // 281: athrow
      // 282: iload 5
      // 284: ifne 28f
      // 287: ifeq 292
      // 28a: goto 28e
      // 28d: athrow
      // 28e: bipush 1
      // 28f: goto 293
      // 292: bipush 0
      // 293: putfield x/ocbce5ea28a3.ɐ Z
      // 296: aload 0
      // 297: bipush 0
      // 298: putfield x/ocbce5ea28a3.φ I
      // 29b: aload 0
      // 29c: ldc2_w 8281291225518148515
      // 29f: ldc2_w 942080811336627292
      // 2a2: lxor
      // 2a3: putfield x/ocbce5ea28a3.ʁ J
      // 2a6: aload 0
      // 2a7: bipush 0
      // 2a8: putfield x/ocbce5ea28a3.Ҏ I
      // 2ab: aload 0
      // 2ac: getstatic x/oc06124119aa.ƌ Lx/oc06124119aa;
      // 2af: putfield x/ocbce5ea28a3.ɓ Lx/oc06124119aa;
      // 2b2: return
   }

   private void Μ() {
      this.ʐ = -1883357143 ^ 264126505;
      this.Ο = null;
      this.Օ = 0.0F;
      this.Ӂ = 0.0F;
      this.π = 0.0;
      this.Ԅ = 0.0;
      this.Ӭ = 0.0F;
      this.A = 0.0F;
      this.Լ = false;
      this.џ = false;
      this.ԣ = false;
      this.e = null;
      this.ɐ = false;
      this.φ = 0;
      this.ҽ = null;
      this.Ƕ = null;
      this.Ղ = null;
      this.ɓ = oc06124119aa.ƌ;
   }

   private void Ѯ(ocf242f30eaa var1, oc53b792ae32 var2) {
      var1.ў(0.0F);
      var1.I(0.0F);
      this.ն = new oceb7a9b9a85(var2.ɇ, var2.Ъ, 0.0F, 0.0F, 0.0F, 0.0F, var2.Ļ, false);
   }

   private void α(ocf242f30eaa param1, oc53b792ae32 param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 3
      // 04: aload 0
      // 05: iload 3
      // 06: ifne 18
      // 09: getfield x/ocbce5ea28a3.ҽ Lx/oc30b42710ad;
      // 0c: ifnull 2c
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: goto 18
      // 17: athrow
      // 18: iload 3
      // 19: ifne 4b
      // 1c: getfield x/ocbce5ea28a3.ҽ Lx/oc30b42710ad;
      // 1f: getfield x/oc30b42710ad.Ň Lx/oc23ff80be39;
      // 22: getstatic x/oc23ff80be39.Ǆ Lx/oc23ff80be39;
      // 25: if_acmpeq 2e
      // 28: goto 2c
      // 2b: athrow
      // 2c: return
      // 2d: athrow
      // 2e: aload 1
      // 2f: aload 0
      // 30: getfield x/ocbce5ea28a3.ҽ Lx/oc30b42710ad;
      // 33: getfield x/oc30b42710ad.ñ Lx/oceb7a9b9a85;
      // 36: getfield x/oceb7a9b9a85.λ F
      // 39: invokevirtual x/ocf242f30eaa.ў (F)V
      // 3c: aload 1
      // 3d: aload 0
      // 3e: getfield x/ocbce5ea28a3.ҽ Lx/oc30b42710ad;
      // 41: getfield x/oc30b42710ad.ñ Lx/oceb7a9b9a85;
      // 44: getfield x/oceb7a9b9a85.ӄ F
      // 47: invokevirtual x/ocf242f30eaa.I (F)V
      // 4a: aload 0
      // 4b: new x/oceb7a9b9a85
      // 4e: dup
      // 4f: aload 0
      // 50: getfield x/ocbce5ea28a3.ҽ Lx/oc30b42710ad;
      // 53: getfield x/oc30b42710ad.ñ Lx/oceb7a9b9a85;
      // 56: getfield x/oceb7a9b9a85.ē F
      // 59: aload 0
      // 5a: getfield x/ocbce5ea28a3.ҽ Lx/oc30b42710ad;
      // 5d: getfield x/oc30b42710ad.ñ Lx/oceb7a9b9a85;
      // 60: getfield x/oceb7a9b9a85.ӥ F
      // 63: aload 0
      // 64: getfield x/ocbce5ea28a3.ҽ Lx/oc30b42710ad;
      // 67: getfield x/oc30b42710ad.ñ Lx/oceb7a9b9a85;
      // 6a: getfield x/oceb7a9b9a85.Ƈ F
      // 6d: aload 0
      // 6e: getfield x/ocbce5ea28a3.ҽ Lx/oc30b42710ad;
      // 71: getfield x/oc30b42710ad.ñ Lx/oceb7a9b9a85;
      // 74: getfield x/oceb7a9b9a85.Đ F
      // 77: aload 0
      // 78: getfield x/ocbce5ea28a3.ҽ Lx/oc30b42710ad;
      // 7b: getfield x/oc30b42710ad.ñ Lx/oceb7a9b9a85;
      // 7e: getfield x/oceb7a9b9a85.λ F
      // 81: aload 0
      // 82: getfield x/ocbce5ea28a3.ҽ Lx/oc30b42710ad;
      // 85: getfield x/oc30b42710ad.ñ Lx/oceb7a9b9a85;
      // 88: getfield x/oceb7a9b9a85.ӄ F
      // 8b: aload 2
      // 8c: getfield x/oc53b792ae32.Ļ Z
      // 8f: aload 2
      // 90: getfield x/oc53b792ae32.ʶ Z
      // 93: invokespecial x/oceb7a9b9a85.<init> (FFFFFFZZ)V
      // 96: putfield x/ocbce5ea28a3.ն Lx/oceb7a9b9a85;
      // 99: return
   }

   private boolean ț() {
      int var1 = oc84f20a0bc5.ė;
      int var2 = -288425453 ^ 1045664861;

      while (true) {
         switch (var2) {
            case -1041683161:
               return true;
            case 807588302:
               return false;
            case 1591703317:
               int var10000;
               label38: {
                  label37: {
                     try {
                        var10000 = oc7ab2161b9f.ն(this.Ѭ.gameSettings.keyBindJump);
                        if (var1 != 0) {
                           break label38;
                        }

                        if (var10000 == 0) {
                           break label37;
                        }
                     } catch (ocbde1165e4e var3) {
                        throw var3;
                     }

                     var2 = -4540038 ^ 1045664861;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var10000 = 242304403 ^ 1045664861;
               }

               var2 = var10000;
               if (var1 == 0) {
                  break;
               }
            case -794988978:
               if (this.Ѭ.gameSettings != null) {
                  var2 = 1619845960 ^ 1045664861;
                  if (var1 == 0) {
                     break;
                  }
               }

               var2 = 242304403 ^ 1045664861;
               if (var1 == 0) {
                  break;
               }

               return false;
            default:
               throw null;
         }
      }
   }

   private boolean ʧ(EntityPlayerSP var1) {
      int var2 = oc84f20a0bc5.ė;
      int var3 = -1184462027 ^ 1807216109;

      while (true) {
         label81:
         while (true) {
            label79:
            while (true) {
               switch (var3) {
                  case -758028584:
                     break label79;
                  case 43377322:
                     if (this.ɹ == null) {
                        var3 = 52560572 ^ 1807216109;
                        if (var2 == 0) {
                           continue;
                        }
                     }

                     var3 = 420851928 ^ 1807216109;
                     if (var2 == 0) {
                        continue;
                     }
                  case -1664850011:
                     int var10000;
                     label68: {
                        label67: {
                           try {
                              var10000 = var1.onGround;
                              if (var2 != 0) {
                                 break label68;
                              }

                              if (!var1.onGround) {
                                 break label67;
                              }
                           } catch (ocbde1165e4e var4) {
                              throw var4;
                           }

                           var3 = 27493380 ^ 1807216109;
                           if (var2 == 0) {
                              continue;
                           }
                        }

                        var10000 = 420851928 ^ 1807216109;
                     }

                     var3 = var10000;
                     if (var2 == 0) {
                        continue;
                     }
                  case 1779722729:
                     if (this.Ѻ == oc65fedf8d38.Ό) {
                        var3 = 1763839815 ^ 1807216109;
                        if (var2 == 0) {
                           continue;
                        }
                     }

                     var3 = 420851928 ^ 1807216109;
                     if (var2 == 0) {
                        continue;
                     }
                     break;
                  case 218763746:
                     return true;
                  case 1640173352:
                     break label81;
                  case 1754656593:
                     break;
                  case 1923243317:
                     return false;
                  default:
                     throw null;
               }

               if (this.Ш == null) {
                  var3 = 175432389 ^ 1807216109;
                  if (var2 == 0) {
                     continue;
                  }
               }

               var3 = 420851928 ^ 1807216109;
               if (var2 != 0) {
                  break;
               }
            }

            if (var1 != null) {
               var3 = -143422904 ^ 1807216109;
               if (var2 == 0) {
                  continue;
               }
            }

            var3 = 420851928 ^ 1807216109;
            if (var2 != 0) {
               break;
            }
         }

         if (this.ɓ == oc06124119aa.ƌ) {
            var3 = 1723726863 ^ 1807216109;
            if (var2 == 0) {
               continue;
            }
         }

         var3 = 420851928 ^ 1807216109;
      }
   }

   private boolean ù() {
      oc1a5b048236 var2 = null;
      int var3 = 498798150 ^ -1946969586;
      int var1 = oc84f20a0bc5.ė;

      while (true) {
         label143:
         while (true) {
            switch (var3) {
               case -1773628344:
                  break label143;
               case -1702843856:
                  int var11;
                  label92: {
                     label91: {
                        try {
                           var11 = this.с(var2.ӄ);
                           if (var1 != 0) {
                              break label92;
                           }

                           if (var11 != 0) {
                              break label91;
                           }
                        } catch (ocbde1165e4e var5) {
                           throw var5;
                        }

                        var3 = -2128570304 ^ -1946969586;
                        if (var1 == 0) {
                           continue;
                        }
                     }

                     var11 = 390337913 ^ -1946969586;
                  }

                  var3 = var11;
                  if (var1 != 0) {
                     return false;
                  }
                  continue;
               case -1679138273:
                  if (this.Ο != null) {
                     var3 = -292976924 ^ -1946969586;
                     if (var1 == 0) {
                        continue;
                     }
                  }

                  var3 = 1836398977 ^ -1946969586;
                  continue;
               case -1665691785:
                  return true;
               case -686279186:
                  return false;
               case -427383921:
                  return false;
               case 181600846:
                  int var9;
                  label128: {
                     label127: {
                        try {
                           var9 = this.Ζ(var2.ӄ);
                           if (var1 != 0) {
                              break label128;
                           }

                           if (var9 == 0) {
                              break label127;
                           }
                        } catch (ocbde1165e4e var8) {
                           throw var8;
                        }

                        var3 = 390337913 ^ -1946969586;
                        if (var1 == 0) {
                           continue;
                        }
                     }

                     var9 = 1558949856 ^ -1946969586;
                  }

                  var3 = var9;
                  if (var1 == 0) {
                     continue;
                  }
               case 986242780:
                  var2 = this.б.B();

                  label106: {
                     label105: {
                        try {
                           if (var1 != 0) {
                              break label106;
                           }

                           if (var2 == null) {
                              break label105;
                           }
                        } catch (ocbde1165e4e var6) {
                           throw var6;
                        }

                        var3 = 292761662 ^ -1946969586;
                        if (var1 == 0) {
                           continue;
                        }
                     }

                     var3 = 1558949856 ^ -1946969586;
                  }

                  if (var1 == 0) {
                     continue;
                  }
               case 1335786214:
                  break;
               case 1702501610:
                  int var10000;
                  label116: {
                     label115: {
                        try {
                           var10000 = this.Ο.equals(this.б.Ȍ());
                           if (var1 != 0) {
                              break label116;
                           }

                           if (var10000 == 0) {
                              break label115;
                           }
                        } catch (ocbde1165e4e var7) {
                           throw var7;
                        }

                        var3 = -999431960 ^ -1946969586;
                        if (var1 == 0) {
                           continue;
                        }
                     }

                     var10000 = 1836398977 ^ -1946969586;
                  }

                  var3 = var10000;
                  if (var1 == 0) {
                     continue;
                  }
                  break label143;
               default:
                  throw null;
            }

            int var10;
            label83: {
               label82: {
                  try {
                     var10 = this.Ζ(this.Ο);
                     if (var1 != 0) {
                        break label83;
                     }

                     if (var10 != 0) {
                        break label82;
                     }
                  } catch (ocbde1165e4e var4) {
                     throw var4;
                  }

                  var3 = 1836398977 ^ -1946969586;
                  if (var1 == 0) {
                     continue;
                  }
               }

               var10 = -1321515822 ^ -1946969586;
            }

            var3 = var10;
            if (var1 != 0) {
               return false;
            }
         }

         if (this.б != null) {
            var3 = 270137361 ^ -1946969586;
            if (var1 == 0) {
               continue;
            }
         }

         var3 = 1836398977 ^ -1946969586;
         if (var1 != 0) {
            return true;
         }
      }
   }

   private boolean ӎ() {
      int var1 = oc84f20a0bc5.ė;
      int var2 = -1754128683 ^ -682217847;

      while (true) {
         switch (var2) {
            case -396702156:
               return false;
            case 1076113500:
               if (this.ҽ != null) {
                  var2 = -1232726907 ^ -682217847;
                  if (var1 == 0) {
                     break;
                  }
               }

               var2 = 1057808573 ^ -682217847;
               break;
            case 1641036300:
               if (this.ҽ.Ň == oc23ff80be39.Ϡ) {
                  var2 = 891895920 ^ -682217847;
                  if (var1 == 0) {
                     break;
                  }
               }

               var2 = 1057808573 ^ -682217847;
               if (var1 == 0) {
                  break;
               }
            case -494964999:
               return true;
            default:
               throw null;
         }
      }
   }

   private oc1a421bd3db Έ(BlockPos param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: aload 1
      // 01: ifnull 10
      // 04: aload 0
      // 05: aload 1
      // 06: invokevirtual x/ocbce5ea28a3.Ζ (Lnet/minecraft/util/BlockPos;)Z
      // 09: ifne 13
      // 0c: goto 10
      // 0f: athrow
      // 10: aconst_null
      // 11: areturn
      // 12: athrow
      // 13: aload 1
      // 14: invokevirtual net/minecraft/util/BlockPos.up ()Lnet/minecraft/util/BlockPos;
      // 17: astore 2
      // 18: aload 0
      // 19: aload 2
      // 1a: invokevirtual x/ocbce5ea28a3.с (Lnet/minecraft/util/BlockPos;)Z
      // 1d: ifeq 30
      // 20: new x/oc1a421bd3db
      // 23: dup
      // 24: aload 1
      // 25: getstatic net/minecraft/util/EnumFacing.UP Lnet/minecraft/util/EnumFacing;
      // 28: aload 2
      // 29: invokespecial x/oc1a421bd3db.<init> (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;Lnet/minecraft/util/BlockPos;)V
      // 2c: goto 31
      // 2f: athrow
      // 30: aconst_null
      // 31: areturn
   }

   private void и(ocf242f30eaa param1, oc53b792ae32 param2, EntityPlayerSP param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: aload 0
      // 04: bipush 1
      // 05: putfield x/ocbce5ea28a3.ȷ Z
      // 08: istore 4
      // 0a: aload 0
      // 0b: getfield x/ocbce5ea28a3.Ǚ Lx/oc668fce0dbf;
      // 0e: bipush 1
      // 0f: invokevirtual x/oc668fce0dbf.Σ (Z)V
      // 12: aload 3
      // 13: iload 4
      // 15: ifne 27
      // 18: getfield net/minecraft/client/entity/EntityPlayerSP.movementInput Lnet/minecraft/util/MovementInput;
      // 1b: ifnull 2e
      // 1e: goto 22
      // 21: athrow
      // 22: aload 3
      // 23: goto 27
      // 26: athrow
      // 27: getfield net/minecraft/client/entity/EntityPlayerSP.movementInput Lnet/minecraft/util/MovementInput;
      // 2a: bipush 1
      // 2b: putfield net/minecraft/util/MovementInput.sneak Z
      // 2e: aload 1
      // 2f: invokevirtual x/ocf242f30eaa.Α ()F
      // 32: fstore 5
      // 34: iload 4
      // 36: aload 1
      // 37: invokevirtual x/ocf242f30eaa.Υ ()F
      // 3a: fstore 6
      // 3c: ifne 96
      // 3f: aload 2
      // 40: getfield x/oc53b792ae32.Ļ Z
      // 43: ifne 70
      // 46: goto 4a
      // 49: athrow
      // 4a: aload 0
      // 4b: getfield x/ocbce5ea28a3.Ǚ Lx/oc668fce0dbf;
      // 4e: ldc_w "Telly/SafeWalk"
      // 51: invokevirtual x/oc668fce0dbf.Ԝ (Ljava/lang/String;)V
      // 54: fload 5
      // 56: ldc_w 0.3
      // 59: fmul
      // 5a: fstore 5
      // 5c: fload 6
      // 5e: ldc_w 0.3
      // 61: fmul
      // 62: fstore 6
      // 64: aload 1
      // 65: fload 5
      // 67: invokevirtual x/ocf242f30eaa.ў (F)V
      // 6a: aload 1
      // 6b: fload 6
      // 6d: invokevirtual x/ocf242f30eaa.I (F)V
      // 70: aload 0
      // 71: new x/oceb7a9b9a85
      // 74: dup
      // 75: aload 2
      // 76: getfield x/oc53b792ae32.ɇ F
      // 79: aload 2
      // 7a: getfield x/oc53b792ae32.Ъ F
      // 7d: aload 2
      // 7e: getfield x/oc53b792ae32.ѧ F
      // 81: aload 2
      // 82: getfield x/oc53b792ae32.ȸ F
      // 85: fload 5
      // 87: fload 6
      // 89: bipush 1
      // 8a: bipush 0
      // 8b: invokespecial x/oceb7a9b9a85.<init> (FFFFFFZZ)V
      // 8e: putfield x/ocbce5ea28a3.ն Lx/oceb7a9b9a85;
      // 91: aload 3
      // 92: bipush 0
      // 93: invokevirtual net/minecraft/client/entity/EntityPlayerSP.setSprinting (Z)V
      // 96: return
   }

   private void Ό(EntityPlayerSP param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: aload 0
      // 04: getfield x/ocbce5ea28a3.ȷ Z
      // 07: istore 3
      // 08: aload 0
      // 09: bipush 0
      // 0a: putfield x/ocbce5ea28a3.ȷ Z
      // 0d: istore 2
      // 0e: aload 0
      // 0f: getfield x/ocbce5ea28a3.Ǚ Lx/oc668fce0dbf;
      // 12: bipush 0
      // 13: invokevirtual x/oc668fce0dbf.Σ (Z)V
      // 16: iload 3
      // 17: ifeq 7d
      // 1a: aload 1
      // 1b: iload 2
      // 1c: ifne 2b
      // 1f: goto 23
      // 22: athrow
      // 23: ifnull 7d
      // 26: goto 2a
      // 29: athrow
      // 2a: aload 1
      // 2b: getfield net/minecraft/client/entity/EntityPlayerSP.movementInput Lnet/minecraft/util/MovementInput;
      // 2e: ifnull 7d
      // 31: aload 0
      // 32: iload 2
      // 33: ifne 4c
      // 36: goto 3a
      // 39: athrow
      // 3a: getfield x/ocbce5ea28a3.Ǚ Lx/oc668fce0dbf;
      // 3d: invokevirtual x/oc668fce0dbf.ȉ ()Z
      // 40: ifne 7d
      // 43: goto 47
      // 46: athrow
      // 47: aload 0
      // 48: goto 4c
      // 4b: athrow
      // 4c: getfield x/ocbce5ea28a3.Ѭ Lnet/minecraft/client/Minecraft;
      // 4f: iload 2
      // 50: ifne 65
      // 53: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 56: ifnull 71
      // 59: goto 5d
      // 5c: athrow
      // 5d: aload 0
      // 5e: getfield x/ocbce5ea28a3.Ѭ Lnet/minecraft/client/Minecraft;
      // 61: goto 65
      // 64: athrow
      // 65: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 68: getfield net/minecraft/client/settings/GameSettings.keyBindSneak Lnet/minecraft/client/settings/KeyBinding;
      // 6b: invokestatic x/oc7ab2161b9f.ն (Lnet/minecraft/client/settings/KeyBinding;)Z
      // 6e: ifne 7d
      // 71: aload 1
      // 72: getfield net/minecraft/client/entity/EntityPlayerSP.movementInput Lnet/minecraft/util/MovementInput;
      // 75: bipush 0
      // 76: putfield net/minecraft/util/MovementInput.sneak Z
      // 79: goto 7d
      // 7c: athrow
      // 7d: return
   }

   private float ո(float param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 2
      // 04: aload 0
      // 05: getfield x/ocbce5ea28a3.Ѭ Lnet/minecraft/client/Minecraft;
      // 08: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 0b: ifnonnull 11
      // 0e: fload 1
      // 0f: freturn
      // 10: athrow
      // 11: fconst_0
      // 12: fstore 3
      // 13: aload 0
      // 14: getfield x/ocbce5ea28a3.Ѭ Lnet/minecraft/client/Minecraft;
      // 17: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 1a: getfield net/minecraft/client/settings/GameSettings.keyBindForward Lnet/minecraft/client/settings/KeyBinding;
      // 1d: iload 2
      // 1e: ifne 39
      // 21: invokestatic x/oc7ab2161b9f.ն (Lnet/minecraft/client/settings/KeyBinding;)Z
      // 24: ifeq 2f
      // 27: goto 2b
      // 2a: athrow
      // 2b: fload 3
      // 2c: fconst_1
      // 2d: fadd
      // 2e: fstore 3
      // 2f: aload 0
      // 30: getfield x/ocbce5ea28a3.Ѭ Lnet/minecraft/client/Minecraft;
      // 33: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 36: getfield net/minecraft/client/settings/GameSettings.keyBindBack Lnet/minecraft/client/settings/KeyBinding;
      // 39: invokestatic x/oc7ab2161b9f.ն (Lnet/minecraft/client/settings/KeyBinding;)Z
      // 3c: iload 2
      // 3d: ifne 56
      // 40: ifeq 4b
      // 43: goto 47
      // 46: athrow
      // 47: fload 3
      // 48: fconst_1
      // 49: fsub
      // 4a: fstore 3
      // 4b: fload 3
      // 4c: iload 2
      // 4d: ifne 69
      // 50: fconst_0
      // 51: fcmpl
      // 52: goto 56
      // 55: athrow
      // 56: ifne 78
      // 59: fload 1
      // 5a: iload 2
      // 5b: ifne 75
      // 5e: goto 62
      // 61: athrow
      // 62: invokestatic java/lang/Math.abs (F)F
      // 65: goto 69
      // 68: athrow
      // 69: ldc_w 1.0E-4
      // 6c: fcmpl
      // 6d: ifle 78
      // 70: fload 1
      // 71: goto 75
      // 74: athrow
      // 75: goto 79
      // 78: fload 3
      // 79: freturn
   }

   private float S(float param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 2
      // 04: aload 0
      // 05: getfield x/ocbce5ea28a3.Ѭ Lnet/minecraft/client/Minecraft;
      // 08: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 0b: ifnonnull 11
      // 0e: fload 1
      // 0f: freturn
      // 10: athrow
      // 11: fconst_0
      // 12: fstore 3
      // 13: aload 0
      // 14: getfield x/ocbce5ea28a3.Ѭ Lnet/minecraft/client/Minecraft;
      // 17: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 1a: iload 2
      // 1b: ifne 36
      // 1e: getfield net/minecraft/client/settings/GameSettings.keyBindLeft Lnet/minecraft/client/settings/KeyBinding;
      // 21: invokestatic x/oc7ab2161b9f.ն (Lnet/minecraft/client/settings/KeyBinding;)Z
      // 24: ifeq 2f
      // 27: goto 2b
      // 2a: athrow
      // 2b: fload 3
      // 2c: fconst_1
      // 2d: fadd
      // 2e: fstore 3
      // 2f: aload 0
      // 30: getfield x/ocbce5ea28a3.Ѭ Lnet/minecraft/client/Minecraft;
      // 33: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 36: getfield net/minecraft/client/settings/GameSettings.keyBindRight Lnet/minecraft/client/settings/KeyBinding;
      // 39: invokestatic x/oc7ab2161b9f.ն (Lnet/minecraft/client/settings/KeyBinding;)Z
      // 3c: iload 2
      // 3d: ifne 56
      // 40: ifeq 4b
      // 43: goto 47
      // 46: athrow
      // 47: fload 3
      // 48: fconst_1
      // 49: fsub
      // 4a: fstore 3
      // 4b: fload 3
      // 4c: iload 2
      // 4d: ifne 69
      // 50: fconst_0
      // 51: fcmpl
      // 52: goto 56
      // 55: athrow
      // 56: ifne 78
      // 59: fload 1
      // 5a: iload 2
      // 5b: ifne 75
      // 5e: goto 62
      // 61: athrow
      // 62: invokestatic java/lang/Math.abs (F)F
      // 65: goto 69
      // 68: athrow
      // 69: ldc_w 1.0E-4
      // 6c: fcmpl
      // 6d: ifle 78
      // 70: fload 1
      // 71: goto 75
      // 74: athrow
      // 75: goto 79
      // 78: fload 3
      // 79: freturn
   }

   private boolean Չ(EntityPlayerSP var1) {
      int var2 = oc84f20a0bc5.ė;
      int var3 = -1637179787 ^ -2053751218;

      while (true) {
         switch (var3) {
            case -1609970147:
               return true;
            case 90272585:
               return false;
            case 469540923:
               int var10000;
               label71: {
                  label70: {
                     try {
                        long var9;
                        var10000 = (var9 = this.ϯ - this.ւ) == 0L ? 0 : (var9 < 0L ? -1 : 1);
                        if (var2 != 0) {
                           break label71;
                        }

                        if (var10000 == 0) {
                           break label70;
                        }
                     } catch (ocbde1165e4e var6) {
                        throw var6;
                     }

                     var3 = -1507214553 ^ -2053751218;
                     if (var2 == 0) {
                        continue;
                     }
                  }

                  var10000 = -2131276537 ^ -2053751218;
               }

               var3 = var10000;
               if (var2 == 0) {
                  continue;
               }
            case 315632414:
               int var7;
               label57: {
                  label56: {
                     try {
                        var7 = this.ӎ();
                        if (var2 != 0) {
                           break label57;
                        }

                        if (var7 == 0) {
                           break label56;
                        }
                     } catch (ocbde1165e4e var5) {
                        throw var5;
                     }

                     var3 = -1322865533 ^ -2053751218;
                     if (var2 == 0) {
                        continue;
                     }
                  }

                  var7 = 631238739 ^ -2053751218;
               }

               var3 = var7;
               if (var2 == 0) {
                  continue;
               }
            case 599754089:
               break;
            case 883987149:
               return ɖ(var1, this.Ƕ);
            default:
               throw null;
         }

         int var8;
         label48: {
            label47: {
               try {
                  var8 = this.Ҏ;
                  if (var2 != 0) {
                     break label48;
                  }

                  if (this.Ҏ >= 1) {
                     break label47;
                  }
               } catch (ocbde1165e4e var4) {
                  throw var4;
               }

               var3 = -2131276537 ^ -2053751218;
               if (var2 == 0) {
                  continue;
               }
            }

            var8 = -1757014704 ^ -2053751218;
         }

         var3 = var8;
      }
   }

   private static boolean ɖ(EntityPlayerSP var0, oc1a421bd3db var1) {
      Object var3 = null;
      int var4 = -85456404 ^ -2067798319;
      int var2 = oc84f20a0bc5.ė;

      while (true) {
         switch (var4) {
            case 604176744:
               return false;
            case 818194070:
               if (var1.Փ != EnumFacing.UP) {
                  var4 = -1346496236 ^ -2067798319;
                  if (var2 == 0) {
                     break;
                  }
               }

               var4 = -2010165161 ^ -2067798319;
               if (var2 == 0) {
                  break;
               }
            case 721551301:
               return false;
            case 2119692093:
               if (var0 != null) {
                  var4 = -748096893 ^ -2067798319;
                  if (var2 == 0) {
                     break;
                  }
               }

               var4 = -1346496236 ^ -2067798319;
               if (var2 == 0) {
                  break;
               }
            case 1473713234:
               if (var1 != null) {
                  var4 = -1266991033 ^ -2067798319;
                  if (var2 == 0) {
                     break;
                  }
               }

               var4 = -1346496236 ^ -2067798319;
               if (var2 == 0) {
                  break;
               }
            case 210810502:
               var3 = var0.getEntityBoundingBox();

               label51: {
                  label50: {
                     try {
                        if (var2 != 0) {
                           break label51;
                        }

                        if (!(((AxisAlignedBB)var3).minY >= var1.Շ.getY() + 1.0 - 0.001)) {
                           break label50;
                        }
                     } catch (ocbde1165e4e var5) {
                        throw var5;
                     }

                     var4 = -178579504 ^ -2067798319;
                     if (var2 == 0) {
                        break;
                     }
                  }

                  var4 = -1598232647 ^ -2067798319;
               }

               if (var2 == 0) {
                  break;
               }
            case 1910829313:
               return true;
            default:
               throw null;
         }
      }
   }

   private static Vec3 њ(Vec3 var0, BlockPos var1) {
      double var2 = Math.max(0.0, Math.min(1.0, var0.xCoord - var1.getX()));
      double var4 = Math.max(0.0, Math.min(1.0, var0.yCoord - var1.getY()));
      double var6 = Math.max(0.0, Math.min(1.0, var0.zCoord - var1.getZ()));
      return new Vec3(var1.getX() + var2, var1.getY() + var4, var1.getZ() + var6);
   }

   private static boolean ю(oc791986a759 var0, float var1, float var2, float var3) {
      float var5 = 0.0F;
      int var6 = -1911273710 ^ -935053023;
      int var4 = oc84f20a0bc5.ė;

      while (true) {
         switch (var6) {
            case -971154928:
               int var10;
               label75: {
                  label74: {
                     try {
                        var10 = var0.ŕ;
                        if (var4 != 0) {
                           break label75;
                        }

                        if (var0.ŕ) {
                           break label74;
                        }
                     } catch (ocbde1165e4e var9) {
                        throw var9;
                     }

                     var6 = 1800273501 ^ -935053023;
                     if (var4 == 0) {
                        break;
                     }
                  }

                  var10 = -414153955 ^ -935053023;
               }

               var6 = var10;
               if (var4 == 0) {
                  break;
               }
            case 1512633811:
               return false;
            case 471731661:
               return true;
            case 789887548:
               var5 = Math.max(1.0E-4F, ѫ(var3) * 0.51F);

               label65: {
                  label64: {
                     try {
                        if (var4 != 0) {
                           break label65;
                        }

                        if (!(Math.abs(MathHelper.wrapAngleTo180_float(var0.Ά - var1)) <= var5)) {
                           break label64;
                        }
                     } catch (ocbde1165e4e var8) {
                        throw var8;
                     }

                     var6 = -421721137 ^ -935053023;
                     if (var4 == 0) {
                        break;
                     }
                  }

                  var6 = -1838363406 ^ -935053023;
               }

               if (var4 == 0) {
                  break;
               }
            case 781791982:
               int var10000;
               label56: {
                  label55: {
                     try {
                        float var11;
                        var10000 = (var11 = Math.abs(var0.ţ - var2) - var5) == 0.0F ? 0 : (var11 < 0.0F ? -1 : 1);
                        if (var4 != 0) {
                           break label56;
                        }

                        if (var10000 > 0) {
                           break label55;
                        }
                     } catch (ocbde1165e4e var7) {
                        throw var7;
                     }

                     var6 = -732285716 ^ -935053023;
                     if (var4 == 0) {
                        break;
                     }
                  }

                  var10000 = -1838363406 ^ -935053023;
               }

               var6 = var10000;
               break;
            case 1179680307:
               if (var0 != null) {
                  var6 = 240739121 ^ -935053023;
                  if (var4 == 0) {
                     break;
                  }
               }

               var6 = 1800273501 ^ -935053023;
               if (var4 == 0) {
                  break;
               }
            case -1559640196:
               return false;
            default:
               throw null;
         }
      }
   }

   private void Ŷ(EntityPlayerSP param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 2
      // 04: aload 0
      // 05: iload 2
      // 06: ifne 18
      // 09: getfield x/ocbce5ea28a3.ɹ Lx/oc981d71de6a;
      // 0c: ifnonnull 26
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: goto 18
      // 17: athrow
      // 18: iload 2
      // 19: ifne 29
      // 1c: getfield x/ocbce5ea28a3.Ш Lx/occ00ef6c188;
      // 1f: ifnull 28
      // 22: goto 26
      // 25: athrow
      // 26: return
      // 27: athrow
      // 28: aload 0
      // 29: iload 2
      // 2a: ifne 51
      // 2d: getfield x/ocbce5ea28a3.Ƕ Lx/oc1a421bd3db;
      // 30: ifnull 50
      // 33: goto 37
      // 36: athrow
      // 37: aload 0
      // 38: iload 2
      // 39: ifne 51
      // 3c: goto 40
      // 3f: athrow
      // 40: aload 0
      // 41: getfield x/ocbce5ea28a3.Ƕ Lx/oc1a421bd3db;
      // 44: invokevirtual x/ocbce5ea28a3.ӛ (Lx/oc1a421bd3db;)Z
      // 47: ifeq 50
      // 4a: goto 4e
      // 4d: athrow
      // 4e: return
      // 4f: athrow
      // 50: aload 0
      // 51: iload 2
      // 52: ifne 7c
      // 55: invokevirtual x/ocbce5ea28a3.ӎ ()Z
      // 58: ifne 7b
      // 5b: goto 5f
      // 5e: athrow
      // 5f: aload 0
      // 60: iload 2
      // 61: ifne 7c
      // 64: goto 68
      // 67: athrow
      // 68: getfield x/ocbce5ea28a3.џ Z
      // 6b: ifne 7b
      // 6e: goto 72
      // 71: athrow
      // 72: aload 0
      // 73: aload 1
      // 74: invokevirtual x/ocbce5ea28a3.л (Lnet/minecraft/client/entity/EntityPlayerSP;)V
      // 77: goto 7b
      // 7a: athrow
      // 7b: aload 0
      // 7c: aload 0
      // 7d: iload 2
      // 7e: ifne 9b
      // 81: invokevirtual x/ocbce5ea28a3.ӎ ()Z
      // 84: ifeq 9a
      // 87: goto 8b
      // 8a: athrow
      // 8b: aload 0
      // 8c: aload 0
      // 8d: getfield x/ocbce5ea28a3.ҽ Lx/oc30b42710ad;
      // 90: getfield x/oc30b42710ad.Չ Lnet/minecraft/util/BlockPos;
      // 93: invokevirtual x/ocbce5ea28a3.Έ (Lnet/minecraft/util/BlockPos;)Lx/oc1a421bd3db;
      // 96: goto a3
      // 99: athrow
      // 9a: aload 0
      // 9b: aload 0
      // 9c: getfield x/ocbce5ea28a3.Ο Lnet/minecraft/util/BlockPos;
      // 9f: aload 1
      // a0: invokevirtual x/ocbce5ea28a3.վ (Lnet/minecraft/util/BlockPos;Lnet/minecraft/client/entity/EntityPlayerSP;)Lx/oc1a421bd3db;
      // a3: putfield x/ocbce5ea28a3.Ƕ Lx/oc1a421bd3db;
      // a6: aload 0
      // a7: aconst_null
      // a8: putfield x/ocbce5ea28a3.Ղ Lx/oc847503a8ab;
      // ab: aload 0
      // ac: aload 0
      // ad: getfield x/ocbce5ea28a3.Ƕ Lx/oc1a421bd3db;
      // b0: ifnonnull ba
      // b3: getstatic x/oc06124119aa.ƌ Lx/oc06124119aa;
      // b6: goto bd
      // b9: athrow
      // ba: getstatic x/oc06124119aa.ί Lx/oc06124119aa;
      // bd: putfield x/ocbce5ea28a3.ɓ Lx/oc06124119aa;
      // c0: return
   }

   private void л(EntityPlayerSP param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: istore 2
      // 004: aload 0
      // 005: iload 2
      // 006: ifne 01a
      // 009: bipush 1
      // 00a: putfield x/ocbce5ea28a3.џ Z
      // 00d: aload 1
      // 00e: ifnull 06e
      // 011: goto 015
      // 014: athrow
      // 015: aload 0
      // 016: goto 01a
      // 019: athrow
      // 01a: iload 2
      // 01b: ifne 02d
      // 01e: getfield x/ocbce5ea28a3.ҽ Lx/oc30b42710ad;
      // 021: ifnull 06e
      // 024: goto 028
      // 027: athrow
      // 028: aload 0
      // 029: goto 02d
      // 02c: athrow
      // 02d: iload 2
      // 02e: ifne 046
      // 031: getfield x/ocbce5ea28a3.ҽ Lx/oc30b42710ad;
      // 034: getfield x/oc30b42710ad.Ň Lx/oc23ff80be39;
      // 037: getstatic x/oc23ff80be39.Ǆ Lx/oc23ff80be39;
      // 03a: if_acmpne 06e
      // 03d: goto 041
      // 040: athrow
      // 041: aload 0
      // 042: goto 046
      // 045: athrow
      // 046: iload 2
      // 047: ifne 059
      // 04a: getfield x/ocbce5ea28a3.ն Lx/oceb7a9b9a85;
      // 04d: ifnull 06e
      // 050: goto 054
      // 053: athrow
      // 054: aload 0
      // 055: goto 059
      // 058: athrow
      // 059: iload 2
      // 05a: ifne 071
      // 05d: getfield x/ocbce5ea28a3.ʐ I
      // 060: ldc_w 1718997148
      // 063: ldc_w -428486500
      // 066: ixor
      // 067: if_icmpne 070
      // 06a: goto 06e
      // 06d: athrow
      // 06e: return
      // 06f: athrow
      // 070: aload 0
      // 071: getfield x/ocbce5ea28a3.ҽ Lx/oc30b42710ad;
      // 074: getfield x/oc30b42710ad.Չ Lnet/minecraft/util/BlockPos;
      // 077: astore 3
      // 078: iload 2
      // 079: ifne 096
      // 07c: aload 0
      // 07d: aload 3
      // 07e: invokevirtual x/ocbce5ea28a3.Ζ (Lnet/minecraft/util/BlockPos;)Z
      // 081: ifne 097
      // 084: goto 088
      // 087: athrow
      // 088: aload 0
      // 089: aconst_null
      // 08a: putfield x/ocbce5ea28a3.б Lx/oc7b822110db;
      // 08d: aload 0
      // 08e: aconst_null
      // 08f: putfield x/ocbce5ea28a3.Ο Lnet/minecraft/util/BlockPos;
      // 092: goto 096
      // 095: athrow
      // 096: return
      // 097: dconst_0
      // 098: dconst_0
      // 099: aload 1
      // 09a: getfield net/minecraft/client/entity/EntityPlayerSP.posY D
      // 09d: aload 1
      // 09e: getfield net/minecraft/client/entity/EntityPlayerSP.motionX D
      // 0a1: aload 1
      // 0a2: getfield net/minecraft/client/entity/EntityPlayerSP.motionY D
      // 0a5: aload 1
      // 0a6: getfield net/minecraft/client/entity/EntityPlayerSP.motionZ D
      // 0a9: aload 0
      // 0aa: getfield x/ocbce5ea28a3.ն Lx/oceb7a9b9a85;
      // 0ad: aload 1
      // 0ae: getfield net/minecraft/client/entity/EntityPlayerSP.jumpMovementFactor F
      // 0b1: aload 0
      // 0b2: getfield x/ocbce5ea28a3.ʐ I
      // 0b5: i2d
      // 0b6: dconst_1
      // 0b7: dadd
      // 0b8: ldc_w -428486512
      // 0bb: ldc_w -428486500
      // 0be: ixor
      // 0bf: invokestatic x/ocbce5ea28a3.ù (DDDDDDLx/oceb7a9b9a85;FDI)Lx/oc81c78bf988;
      // 0c2: astore 4
      // 0c4: aload 4
      // 0c6: getfield x/oc81c78bf988.I Z
      // 0c9: ifne 0ce
      // 0cc: return
      // 0cd: athrow
      // 0ce: aload 0
      // 0cf: aload 1
      // 0d0: aload 4
      // 0d2: aload 3
      // 0d3: invokevirtual x/ocbce5ea28a3.Ʀ (Lnet/minecraft/client/entity/EntityPlayerSP;Lx/oc81c78bf988;Lnet/minecraft/util/BlockPos;)Lx/M;
      // 0d6: astore 5
      // 0d8: aload 5
      // 0da: iload 2
      // 0db: ifne 0e7
      // 0de: ifnull 108
      // 0e1: goto 0e5
      // 0e4: athrow
      // 0e5: aload 5
      // 0e7: getfield x/M.ϓ Z
      // 0ea: ifeq 108
      // 0ed: aload 0
      // 0ee: aload 5
      // 0f0: getfield x/M.Ȏ Lx/oc7b822110db;
      // 0f3: invokevirtual x/oc7b822110db.ә ()Lx/oc7b822110db;
      // 0f6: putfield x/ocbce5ea28a3.б Lx/oc7b822110db;
      // 0f9: aload 0
      // 0fa: aload 0
      // 0fb: getfield x/ocbce5ea28a3.б Lx/oc7b822110db;
      // 0fe: invokevirtual x/oc7b822110db.Ȍ ()Lnet/minecraft/util/BlockPos;
      // 101: putfield x/ocbce5ea28a3.Ο Lnet/minecraft/util/BlockPos;
      // 104: goto 108
      // 107: athrow
      // 108: return
   }

   private boolean Ɂ(EntityPlayerSP param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: istore 2
      // 004: aload 1
      // 005: ifnull 04e
      // 008: aload 0
      // 009: iload 2
      // 00a: ifne 020
      // 00d: goto 011
      // 010: athrow
      // 011: getfield x/ocbce5ea28a3.ҽ Lx/oc30b42710ad;
      // 014: ifnull 04e
      // 017: goto 01b
      // 01a: athrow
      // 01b: aload 0
      // 01c: goto 020
      // 01f: athrow
      // 020: iload 2
      // 021: ifne 039
      // 024: getfield x/ocbce5ea28a3.ҽ Lx/oc30b42710ad;
      // 027: getfield x/oc30b42710ad.Ň Lx/oc23ff80be39;
      // 02a: getstatic x/oc23ff80be39.Ǆ Lx/oc23ff80be39;
      // 02d: if_acmpne 04e
      // 030: goto 034
      // 033: athrow
      // 034: aload 0
      // 035: goto 039
      // 038: athrow
      // 039: getfield x/ocbce5ea28a3.ʐ I
      // 03c: iload 2
      // 03d: ifne 053
      // 040: ldc_w -344855581
      // 043: ldc_w 1802628067
      // 046: ixor
      // 047: if_icmpne 054
      // 04a: goto 04e
      // 04d: athrow
      // 04e: bipush 0
      // 04f: goto 053
      // 052: athrow
      // 053: ireturn
      // 054: ldc2_w 0.41999998688697815
      // 057: dstore 3
      // 058: aload 1
      // 059: getstatic net/minecraft/potion/Potion.jump Lnet/minecraft/potion/Potion;
      // 05c: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isPotionActive (Lnet/minecraft/potion/Potion;)Z
      // 05f: ifeq 077
      // 062: dload 3
      // 063: aload 1
      // 064: getstatic net/minecraft/potion/Potion.jump Lnet/minecraft/potion/Potion;
      // 067: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getActivePotionEffect (Lnet/minecraft/potion/Potion;)Lnet/minecraft/potion/PotionEffect;
      // 06a: invokevirtual net/minecraft/potion/PotionEffect.getAmplifier ()I
      // 06d: bipush 1
      // 06e: iadd
      // 06f: i2f
      // 070: ldc_w 0.1
      // 073: fmul
      // 074: f2d
      // 075: dadd
      // 076: dstore 3
      // 077: aload 0
      // 078: aload 1
      // 079: dload 3
      // 07a: bipush 1
      // 07b: invokevirtual x/ocbce5ea28a3.Ŷ (Lnet/minecraft/client/entity/EntityPlayerSP;DZ)Lx/oc81c78bf988;
      // 07e: astore 5
      // 080: aload 5
      // 082: getfield x/oc81c78bf988.I Z
      // 085: ifeq 09a
      // 088: aload 0
      // 089: aload 1
      // 08a: aload 5
      // 08c: aload 0
      // 08d: getfield x/ocbce5ea28a3.ҽ Lx/oc30b42710ad;
      // 090: getfield x/oc30b42710ad.Չ Lnet/minecraft/util/BlockPos;
      // 093: invokevirtual x/ocbce5ea28a3.Ʀ (Lnet/minecraft/client/entity/EntityPlayerSP;Lx/oc81c78bf988;Lnet/minecraft/util/BlockPos;)Lx/M;
      // 096: goto 09b
      // 099: athrow
      // 09a: aconst_null
      // 09b: astore 6
      // 09d: aload 6
      // 09f: iload 2
      // 0a0: ifne 0ac
      // 0a3: ifnull 0e9
      // 0a6: goto 0aa
      // 0a9: athrow
      // 0aa: aload 6
      // 0ac: getfield x/M.ϓ Z
      // 0af: iload 2
      // 0b0: ifne 0d8
      // 0b3: ifeq 0e9
      // 0b6: goto 0ba
      // 0b9: athrow
      // 0ba: aload 5
      // 0bc: iload 2
      // 0bd: ifne 0f0
      // 0c0: goto 0c4
      // 0c3: athrow
      // 0c4: getfield x/oc81c78bf988.ˢ I
      // 0c7: aload 6
      // 0c9: getfield x/M.ƺ Ljava/util/List;
      // 0cc: invokeinterface java/util/List.size ()I 1
      // 0d1: invokestatic x/ocbce5ea28a3.Ӿ (II)Z
      // 0d4: goto 0d8
      // 0d7: athrow
      // 0d8: ifeq 0e9
      // 0db: aload 0
      // 0dc: bipush 1
      // 0dd: putfield x/ocbce5ea28a3.ԣ Z
      // 0e0: aload 0
      // 0e1: aload 6
      // 0e3: invokevirtual x/ocbce5ea28a3.а (Lx/M;)V
      // 0e6: bipush 1
      // 0e7: ireturn
      // 0e8: athrow
      // 0e9: aload 0
      // 0ea: aload 1
      // 0eb: dload 3
      // 0ec: bipush 0
      // 0ed: invokevirtual x/ocbce5ea28a3.Ŷ (Lnet/minecraft/client/entity/EntityPlayerSP;DZ)Lx/oc81c78bf988;
      // 0f0: astore 7
      // 0f2: aload 7
      // 0f4: getfield x/oc81c78bf988.I Z
      // 0f7: ifeq 10c
      // 0fa: aload 0
      // 0fb: aload 1
      // 0fc: aload 7
      // 0fe: aload 0
      // 0ff: getfield x/ocbce5ea28a3.ҽ Lx/oc30b42710ad;
      // 102: getfield x/oc30b42710ad.Չ Lnet/minecraft/util/BlockPos;
      // 105: invokevirtual x/ocbce5ea28a3.Ʀ (Lnet/minecraft/client/entity/EntityPlayerSP;Lx/oc81c78bf988;Lnet/minecraft/util/BlockPos;)Lx/M;
      // 108: goto 10d
      // 10b: athrow
      // 10c: aconst_null
      // 10d: astore 8
      // 10f: aload 8
      // 111: iload 2
      // 112: ifne 11e
      // 115: ifnull 14d
      // 118: goto 11c
      // 11b: athrow
      // 11c: aload 8
      // 11e: getfield x/M.ϓ Z
      // 121: iload 2
      // 122: ifne 152
      // 125: ifeq 14d
      // 128: goto 12c
      // 12b: athrow
      // 12c: aload 7
      // 12e: getfield x/oc81c78bf988.ˢ I
      // 131: iload 2
      // 132: ifne 15f
      // 135: goto 139
      // 138: athrow
      // 139: aload 8
      // 13b: getfield x/M.ƺ Ljava/util/List;
      // 13e: invokeinterface java/util/List.size ()I 1
      // 143: invokestatic x/ocbce5ea28a3.Ҧ (II)Z
      // 146: ifne 153
      // 149: goto 14d
      // 14c: athrow
      // 14d: bipush 0
      // 14e: goto 152
      // 151: athrow
      // 152: ireturn
      // 153: aload 0
      // 154: bipush 0
      // 155: putfield x/ocbce5ea28a3.ԣ Z
      // 158: aload 0
      // 159: aload 8
      // 15b: invokevirtual x/ocbce5ea28a3.а (Lx/M;)V
      // 15e: bipush 1
      // 15f: ireturn
   }

   private oc81c78bf988 Ŷ(EntityPlayerSP var1, double var2, boolean var4) {
      double var5 = var1.motionX;
      double var7 = var1.motionZ;
      if (var4) {
         float var9 = this.A * (float) (Math.PI / 180.0);
         var5 -= MathHelper.sin(var9) * 0.2F;
         var7 += MathHelper.cos(var9) * 0.2F;
      }

      return ù(0.0, 0.0, var1.posY, var5, var2, var7, this.ҽ.ñ, var1.jumpMovementFactor, this.ʐ + 1.0, -1800437012 ^ -1800437024);
   }

   private void а(M var1) {
      this.б = var1.Ȏ.ә();
      this.Ο = this.б.Ȍ();
      this.e = var1.δ.ʗ.Ȍ();
      this.џ = true;
   }

   private M Ʀ(EntityPlayerSP param1, oc81c78bf988 param2, BlockPos param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: aload 1
      // 01: ifnull 14
      // 04: aload 2
      // 05: ifnull 14
      // 08: goto 0c
      // 0b: athrow
      // 0c: aload 3
      // 0d: ifnonnull 17
      // 10: goto 14
      // 13: athrow
      // 14: aconst_null
      // 15: areturn
      // 16: athrow
      // 17: aload 1
      // 18: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getEntityBoundingBox ()Lnet/minecraft/util/AxisAlignedBB;
      // 1b: aload 2
      // 1c: getfield x/oc81c78bf988.ơ D
      // 1f: dconst_0
      // 20: aload 2
      // 21: getfield x/oc81c78bf988.о D
      // 24: invokevirtual net/minecraft/util/AxisAlignedBB.offset (DDD)Lnet/minecraft/util/AxisAlignedBB;
      // 27: astore 4
      // 29: new x/oc7b822110db
      // 2c: dup
      // 2d: aload 3
      // 2e: aload 0
      // 2f: getfield x/ocbce5ea28a3.Ű D
      // 32: aload 0
      // 33: getfield x/ocbce5ea28a3.ł D
      // 36: aload 0
      // 37: getfield x/ocbce5ea28a3.π D
      // 3a: aload 0
      // 3b: getfield x/ocbce5ea28a3.Ԅ D
      // 3e: bipush 1
      // 3f: invokespecial x/oc7b822110db.<init> (Lnet/minecraft/util/BlockPos;DDDDZ)V
      // 42: astore 5
      // 44: new x/oc7b822110db
      // 47: dup
      // 48: aload 3
      // 49: aload 0
      // 4a: getfield x/ocbce5ea28a3.Ű D
      // 4d: aload 0
      // 4e: getfield x/ocbce5ea28a3.ł D
      // 51: aload 0
      // 52: getfield x/ocbce5ea28a3.π D
      // 55: aload 0
      // 56: getfield x/ocbce5ea28a3.Ԅ D
      // 59: bipush 0
      // 5a: invokespecial x/oc7b822110db.<init> (Lnet/minecraft/util/BlockPos;DDDDZ)V
      // 5d: astore 6
      // 5f: aload 0
      // 60: aload 5
      // 62: aload 4
      // 64: ldc_w -1808621779
      // 67: ldc_w -1808621763
      // 6a: ixor
      // 6b: invokevirtual x/ocbce5ea28a3.И (Lx/oc7b822110db;Lnet/minecraft/util/AxisAlignedBB;I)Lx/M;
      // 6e: aload 0
      // 6f: aload 6
      // 71: aload 4
      // 73: ldc_w -1808621779
      // 76: ldc_w -1808621763
      // 79: ixor
      // 7a: invokevirtual x/ocbce5ea28a3.И (Lx/oc7b822110db;Lnet/minecraft/util/AxisAlignedBB;I)Lx/M;
      // 7d: invokestatic x/ocbce5ea28a3.õ (Lx/M;Lx/M;)Lx/M;
      // 80: areturn
   }

   private M И(oc7b822110db param1, AxisAlignedBB param2, int param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: aload 0
      // 04: aload 1
      // 05: aload 2
      // 06: iload 3
      // 07: invokevirtual x/ocbce5ea28a3.ց (Lx/oc7b822110db;Lnet/minecraft/util/AxisAlignedBB;I)Lx/oc78dc1256b9;
      // 0a: astore 5
      // 0c: istore 4
      // 0e: aload 5
      // 10: iload 4
      // 12: ifne 1e
      // 15: ifnull 24
      // 18: goto 1c
      // 1b: athrow
      // 1c: aload 5
      // 1e: getfield x/oc78dc1256b9.ǭ Z
      // 21: ifne 2c
      // 24: aload 1
      // 25: aload 5
      // 27: invokestatic x/M.ϲ (Lx/oc7b822110db;Lx/oc78dc1256b9;)Lx/M;
      // 2a: areturn
      // 2b: athrow
      // 2c: new java/util/ArrayList
      // 2f: dup
      // 30: invokespecial java/util/ArrayList.<init> ()V
      // 33: astore 6
      // 35: aload 5
      // 37: getfield x/oc78dc1256b9.Ȟ Ljava/util/List;
      // 3a: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 3f: astore 7
      // 41: aload 7
      // 43: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 48: ifeq a4
      // 4b: aload 7
      // 4d: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 52: checkcast x/oc1a5b048236
      // 55: astore 8
      // 57: aload 0
      // 58: iload 4
      // 5a: ifne 76
      // 5d: aload 8
      // 5f: getfield x/oc1a5b048236.ӄ Lnet/minecraft/util/BlockPos;
      // 62: invokevirtual x/ocbce5ea28a3.Ζ (Lnet/minecraft/util/BlockPos;)Z
      // 65: ifeq 75
      // 68: goto 6c
      // 6b: athrow
      // 6c: iload 4
      // 6e: ifeq 41
      // 71: goto 75
      // 74: athrow
      // 75: aload 0
      // 76: aload 8
      // 78: getfield x/oc1a5b048236.ӄ Lnet/minecraft/util/BlockPos;
      // 7b: invokevirtual x/ocbce5ea28a3.с (Lnet/minecraft/util/BlockPos;)Z
      // 7e: iload 4
      // 80: ifne 9e
      // 83: ifne 92
      // 86: goto 8a
      // 89: athrow
      // 8a: aload 1
      // 8b: aload 5
      // 8d: invokestatic x/M.ϲ (Lx/oc7b822110db;Lx/oc78dc1256b9;)Lx/M;
      // 90: areturn
      // 91: athrow
      // 92: aload 6
      // 94: aload 8
      // 96: getfield x/oc1a5b048236.ӄ Lnet/minecraft/util/BlockPos;
      // 99: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 9e: pop
      // 9f: iload 4
      // a1: ifeq 41
      // a4: aload 1
      // a5: aload 5
      // a7: aload 6
      // a9: invokestatic x/M.ŉ (Lx/oc7b822110db;Lx/oc78dc1256b9;Ljava/util/List;)Lx/M;
      // ac: areturn
   }

   static M õ(M param0, M param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: istore 2
      // 004: aload 0
      // 005: iload 2
      // 006: ifne 028
      // 009: ifnull 023
      // 00c: goto 010
      // 00f: athrow
      // 010: aload 0
      // 011: iload 2
      // 012: ifne 04d
      // 015: goto 019
      // 018: athrow
      // 019: getfield x/M.ϓ Z
      // 01c: ifne 04c
      // 01f: goto 023
      // 022: athrow
      // 023: aload 1
      // 024: goto 028
      // 027: athrow
      // 028: iload 2
      // 029: ifne 034
      // 02c: ifnull 04a
      // 02f: goto 033
      // 032: athrow
      // 033: aload 1
      // 034: iload 2
      // 035: ifne 047
      // 038: getfield x/M.ϓ Z
      // 03b: ifeq 04a
      // 03e: goto 042
      // 041: athrow
      // 042: aload 1
      // 043: goto 047
      // 046: athrow
      // 047: goto 04b
      // 04a: aconst_null
      // 04b: areturn
      // 04c: aload 1
      // 04d: iload 2
      // 04e: ifne 070
      // 051: ifnull 06b
      // 054: goto 058
      // 057: athrow
      // 058: aload 1
      // 059: iload 2
      // 05a: ifne 072
      // 05d: goto 061
      // 060: athrow
      // 061: getfield x/M.ϓ Z
      // 064: ifne 071
      // 067: goto 06b
      // 06a: athrow
      // 06b: aload 0
      // 06c: goto 070
      // 06f: athrow
      // 070: areturn
      // 071: aload 0
      // 072: iload 2
      // 073: ifne 0ba
      // 076: getfield x/M.ƺ Ljava/util/List;
      // 079: invokeinterface java/util/List.size ()I 1
      // 07e: aload 1
      // 07f: getfield x/M.ƺ Ljava/util/List;
      // 082: invokeinterface java/util/List.size ()I 1
      // 087: if_icmpeq 0b9
      // 08a: goto 08e
      // 08d: athrow
      // 08e: aload 0
      // 08f: iload 2
      // 090: ifne 0b4
      // 093: goto 097
      // 096: athrow
      // 097: getfield x/M.ƺ Ljava/util/List;
      // 09a: invokeinterface java/util/List.size ()I 1
      // 09f: aload 1
      // 0a0: getfield x/M.ƺ Ljava/util/List;
      // 0a3: invokeinterface java/util/List.size ()I 1
      // 0a8: if_icmpge 0b7
      // 0ab: goto 0af
      // 0ae: athrow
      // 0af: aload 0
      // 0b0: goto 0b4
      // 0b3: athrow
      // 0b4: goto 0b8
      // 0b7: aload 1
      // 0b8: areturn
      // 0b9: aload 0
      // 0ba: getfield x/M.Ǝ I
      // 0bd: iload 2
      // 0be: ifne 101
      // 0c1: aload 1
      // 0c2: getfield x/M.Ǝ I
      // 0c5: if_icmpeq 0ed
      // 0c8: goto 0cc
      // 0cb: athrow
      // 0cc: aload 0
      // 0cd: iload 2
      // 0ce: ifne 0e8
      // 0d1: goto 0d5
      // 0d4: athrow
      // 0d5: getfield x/M.Ǝ I
      // 0d8: aload 1
      // 0d9: getfield x/M.Ǝ I
      // 0dc: if_icmpge 0eb
      // 0df: goto 0e3
      // 0e2: athrow
      // 0e3: aload 0
      // 0e4: goto 0e8
      // 0e7: athrow
      // 0e8: goto 0ec
      // 0eb: aload 1
      // 0ec: areturn
      // 0ed: aload 0
      // 0ee: iload 2
      // 0ef: ifne 142
      // 0f2: getfield x/M.δ Lx/oc78dc1256b9;
      // 0f5: getfield x/oc78dc1256b9.Ȟ Ljava/util/List;
      // 0f8: invokeinterface java/util/List.size ()I 1
      // 0fd: goto 101
      // 100: athrow
      // 101: aload 1
      // 102: getfield x/M.δ Lx/oc78dc1256b9;
      // 105: getfield x/oc78dc1256b9.Ȟ Ljava/util/List;
      // 108: invokeinterface java/util/List.size ()I 1
      // 10d: if_icmpeq 141
      // 110: aload 0
      // 111: iload 2
      // 112: ifne 13c
      // 115: goto 119
      // 118: athrow
      // 119: getfield x/M.δ Lx/oc78dc1256b9;
      // 11c: getfield x/oc78dc1256b9.Ȟ Ljava/util/List;
      // 11f: invokeinterface java/util/List.size ()I 1
      // 124: aload 1
      // 125: getfield x/M.δ Lx/oc78dc1256b9;
      // 128: getfield x/oc78dc1256b9.Ȟ Ljava/util/List;
      // 12b: invokeinterface java/util/List.size ()I 1
      // 130: if_icmpge 13f
      // 133: goto 137
      // 136: athrow
      // 137: aload 0
      // 138: goto 13c
      // 13b: athrow
      // 13c: goto 140
      // 13f: aload 1
      // 140: areturn
      // 141: aload 0
      // 142: iload 2
      // 143: ifne 18b
      // 146: getfield x/M.δ Lx/oc78dc1256b9;
      // 149: getfield x/oc78dc1256b9.ѻ D
      // 14c: aload 1
      // 14d: getfield x/M.δ Lx/oc78dc1256b9;
      // 150: getfield x/oc78dc1256b9.ѻ D
      // 153: dsub
      // 154: invokestatic java/lang/Math.abs (D)D
      // 157: ldc2_w 1.0E-4
      // 15a: dcmpl
      // 15b: ifle 18a
      // 15e: goto 162
      // 161: athrow
      // 162: aload 0
      // 163: iload 2
      // 164: ifne 185
      // 167: goto 16b
      // 16a: athrow
      // 16b: getfield x/M.δ Lx/oc78dc1256b9;
      // 16e: getfield x/oc78dc1256b9.ѻ D
      // 171: aload 1
      // 172: getfield x/M.δ Lx/oc78dc1256b9;
      // 175: getfield x/oc78dc1256b9.ѻ D
      // 178: dcmpl
      // 179: ifle 188
      // 17c: goto 180
      // 17f: athrow
      // 180: aload 0
      // 181: goto 185
      // 184: athrow
      // 185: goto 189
      // 188: aload 1
      // 189: areturn
      // 18a: aload 0
      // 18b: areturn
   }

   private oc1a421bd3db վ(BlockPos param1, EntityPlayerSP param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 3
      // 04: aload 1
      // 05: ifnull 79
      // 08: aload 2
      // 09: ifnull 79
      // 0c: goto 10
      // 0f: athrow
      // 10: aload 0
      // 11: iload 3
      // 12: ifne 2f
      // 15: goto 19
      // 18: athrow
      // 19: getfield x/ocbce5ea28a3.ʐ I
      // 1c: ldc_w 954841258
      // 1f: ldc_w -1192642390
      // 22: ixor
      // 23: if_icmpeq 79
      // 26: goto 2a
      // 29: athrow
      // 2a: aload 0
      // 2b: goto 2f
      // 2e: athrow
      // 2f: iload 3
      // 30: ifne 42
      // 33: getfield x/ocbce5ea28a3.б Lx/oc7b822110db;
      // 36: ifnull 79
      // 39: goto 3d
      // 3c: athrow
      // 3d: aload 0
      // 3e: goto 42
      // 41: athrow
      // 42: iload 3
      // 43: ifne 64
      // 46: getfield x/ocbce5ea28a3.б Lx/oc7b822110db;
      // 49: aload 0
      // 4a: getfield x/ocbce5ea28a3.ʐ I
      // 4d: aload 0
      // 4e: getfield x/ocbce5ea28a3.π D
      // 51: aload 0
      // 52: getfield x/ocbce5ea28a3.Ԅ D
      // 55: invokevirtual x/oc7b822110db.ț (IDD)Z
      // 58: ifeq 79
      // 5b: goto 5f
      // 5e: athrow
      // 5f: aload 0
      // 60: goto 64
      // 63: athrow
      // 64: aload 0
      // 65: getfield x/ocbce5ea28a3.б Lx/oc7b822110db;
      // 68: invokevirtual x/oc7b822110db.Ȍ ()Lnet/minecraft/util/BlockPos;
      // 6b: invokevirtual x/ocbce5ea28a3.Ζ (Lnet/minecraft/util/BlockPos;)Z
      // 6e: iload 3
      // 6f: ifne 7d
      // 72: ifne 7c
      // 75: goto 79
      // 78: athrow
      // 79: aconst_null
      // 7a: areturn
      // 7b: athrow
      // 7c: bipush 0
      // 7d: istore 4
      // 7f: iload 4
      // 81: ldc_w -1192642388
      // 84: ldc_w -1192642390
      // 87: ixor
      // 88: if_icmpge fe
      // 8b: aload 0
      // 8c: getfield x/ocbce5ea28a3.б Lx/oc7b822110db;
      // 8f: invokevirtual x/oc7b822110db.B ()Lx/oc1a5b048236;
      // 92: astore 5
      // 94: aload 5
      // 96: ifnonnull 9c
      // 99: aconst_null
      // 9a: areturn
      // 9b: athrow
      // 9c: aload 0
      // 9d: iload 3
      // 9e: ifne c9
      // a1: aload 5
      // a3: getfield x/oc1a5b048236.ӄ Lnet/minecraft/util/BlockPos;
      // a6: invokevirtual x/ocbce5ea28a3.с (Lnet/minecraft/util/BlockPos;)Z
      // a9: ifeq c8
      // ac: goto b0
      // af: athrow
      // b0: new x/oc1a421bd3db
      // b3: dup
      // b4: aload 5
      // b6: getfield x/oc1a5b048236.Ļ Lnet/minecraft/util/BlockPos;
      // b9: aload 5
      // bb: getfield x/oc1a5b048236.Ԉ Lnet/minecraft/util/EnumFacing;
      // be: aload 5
      // c0: getfield x/oc1a5b048236.ӄ Lnet/minecraft/util/BlockPos;
      // c3: invokespecial x/oc1a421bd3db.<init> (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;Lnet/minecraft/util/BlockPos;)V
      // c6: areturn
      // c7: athrow
      // c8: aload 0
      // c9: iload 3
      // ca: ifne ed
      // cd: aload 5
      // cf: getfield x/oc1a5b048236.ӄ Lnet/minecraft/util/BlockPos;
      // d2: invokevirtual x/ocbce5ea28a3.Ζ (Lnet/minecraft/util/BlockPos;)Z
      // d5: ifne df
      // d8: goto dc
      // db: athrow
      // dc: aconst_null
      // dd: areturn
      // de: athrow
      // df: aload 0
      // e0: getfield x/ocbce5ea28a3.б Lx/oc7b822110db;
      // e3: aload 5
      // e5: getfield x/oc1a5b048236.ӄ Lnet/minecraft/util/BlockPos;
      // e8: invokevirtual x/oc7b822110db.ǹ (Lnet/minecraft/util/BlockPos;)Z
      // eb: pop
      // ec: aload 0
      // ed: aload 0
      // ee: getfield x/ocbce5ea28a3.б Lx/oc7b822110db;
      // f1: invokevirtual x/oc7b822110db.Ȍ ()Lnet/minecraft/util/BlockPos;
      // f4: putfield x/ocbce5ea28a3.Ο Lnet/minecraft/util/BlockPos;
      // f7: iload 3
      // f8: iinc 4 1
      // fb: ifeq 7f
      // fe: aconst_null
      // ff: areturn
   }

   private boolean â(EntityPlayerSP var1) {
      Object var3 = null;
      AxisAlignedBB var4 = null;
      int var5 = 981653357 ^ 665168500;
      int var2 = oc84f20a0bc5.ė;

      while (true) {
         label127:
         while (true) {
            label125:
            while (true) {
               switch (var5) {
                  case -1950542856:
                     break label125;
                  case -665348522:
                     return true;
                  case -63918239:
                     int var12;
                     label96: {
                        label95: {
                           try {
                              double var14;
                              var12 = (var14 = this.հ(var4, this.ʐ) - 0.2) == 0.0 ? 0 : (var14 < 0.0 ? -1 : 1);
                              if (var2 != 0) {
                                 break label96;
                              }

                              if (var12 < 0) {
                                 break label95;
                              }
                           } catch (ocbde1165e4e var8) {
                              throw var8;
                           }

                           var5 = 67747724 ^ 665168500;
                           if (var2 == 0) {
                              continue;
                           }
                        }

                        var12 = 1557526603 ^ 665168500;
                     }

                     var5 = var12;
                     if (var2 != 0) {
                        break label125;
                     }
                     continue;
                  case 489127193:
                     break;
                  case 598480376:
                     break label127;
                  case 1268868592:
                     var3 = ù(
                        0.0, 0.0, var1.posY, var1.motionX, var1.motionY, var1.motionZ, this.ն, var1.jumpMovementFactor, this.ʐ + 1.0, 665168504 ^ 665168500
                     );
                     int var10000 = var2;
                     var4 = var1.getEntityBoundingBox().offset(((oc81c78bf988)var3).ơ, 0.0, ((oc81c78bf988)var3).о);

                     label109: {
                        label108: {
                           try {
                              if (var10000 != 0) {
                                 break label109;
                              }

                              if (!((oc81c78bf988)var3).I) {
                                 break label108;
                              }
                           } catch (ocbde1165e4e var9) {
                              throw var9;
                           }

                           var5 = -610990827 ^ 665168500;
                           if (var2 == 0) {
                              continue;
                           }
                        }

                        var5 = 1557526603 ^ 665168500;
                     }

                     if (var2 == 0) {
                        continue;
                     }
                  case -1826615578:
                     if (this.ն == null) {
                        var5 = 1958911354 ^ 665168500;
                        if (var2 == 0) {
                           continue;
                        }
                     }

                     var5 = 1812254596 ^ 665168500;
                     if (var2 == 0) {
                        continue;
                     }
                     break;
                  case 1399273230:
                     return false;
                  case 2070958655:
                     return false;
                  default:
                     throw null;
               }

               if (var1 != null) {
                  var5 = -1407665780 ^ 665168500;
                  if (var2 == 0) {
                     continue;
                  }
               }

               var5 = 1958911354 ^ 665168500;
               if (var2 != 0) {
                  break label127;
               }
            }

            int var13;
            label83: {
               label82: {
                  try {
                     var13 = this.ʐ;
                     if (var2 != 0) {
                        break label83;
                     }

                     if (this.ʐ == (-1482315148 ^ 665168500)) {
                        break label82;
                     }
                  } catch (ocbde1165e4e var7) {
                     throw var7;
                  }

                  var5 = -1266309998 ^ 665168500;
                  if (var2 == 0) {
                     continue;
                  }
               }

               var13 = 1958911354 ^ 665168500;
            }

            var5 = var13;
            if (var2 != 0) {
               return false;
            }
         }

         int var11;
         label74: {
            label73: {
               try {
                  var11 = this.ϙ(var4, this.ʐ);
                  if (var2 != 0) {
                     break label74;
                  }

                  if (var11 == 0) {
                     break label73;
                  }
               } catch (ocbde1165e4e var6) {
                  throw var6;
               }

               var5 = -902110 ^ 665168500;
               if (var2 == 0) {
                  continue;
               }
            }

            var11 = 1557526603 ^ 665168500;
         }

         var5 = var11;
         if (var2 != 0) {
            return false;
         }
      }
   }

   private boolean ã() {
      EntityPlayerSP var2 = null;
      int var3 = -1219939257 ^ -289876668;
      int var1 = oc84f20a0bc5.ė;

      while (true) {
         switch (var3) {
            case -2016046850:
               return true;
            case -1379463449:
               return false;
            case -508861638:
               if (this.Ѻ != oc65fedf8d38.И) {
                  var3 = -2094429260 ^ -289876668;
                  if (var1 == 0) {
                     break;
                  }
               }

               var3 = 1768768954 ^ -289876668;
               if (var1 == 0) {
                  break;
               }
            case 1838243568:
               if (this.Ѻ != oc65fedf8d38.ė) {
                  var3 = -1268288260 ^ -289876668;
                  if (var1 == 0) {
                     break;
                  }
               }

               var3 = 1768768954 ^ -289876668;
               if (var1 == 0) {
                  break;
               }
            case -425157735:
               if (var2 != null) {
                  var3 = 1339906117 ^ -289876668;
                  if (var1 == 0) {
                     break;
                  }
               }

               var3 = 1132452771 ^ -289876668;
               if (var1 == 0) {
                  break;
               }
            case 1524605368:
               if (this.Ѻ == oc65fedf8d38.Ό) {
                  var3 = 135286493 ^ -289876668;
                  if (var1 == 0) {
                     break;
                  }
               }

               var3 = 1132452771 ^ -289876668;
               if (var1 == 0) {
                  break;
               }

               return false;
            case 1509024003:
               var2 = this.Ǚ.ն();

               label79: {
                  label78: {
                     try {
                        if (var1 != 0) {
                           break label79;
                        }

                        if (!this.ɐ) {
                           break label78;
                        }
                     } catch (ocbde1165e4e var5) {
                        throw var5;
                     }

                     var3 = 252950142 ^ -289876668;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var3 = 1132452771 ^ -289876668;
               }

               if (var1 == 0) {
                  break;
               }
            case -1587180287:
               int var10000;
               label67: {
                  label66: {
                     try {
                        var10000 = var2.onGround;
                        if (var1 != 0) {
                           break label67;
                        }

                        if (var2.onGround) {
                           break label66;
                        }
                     } catch (ocbde1165e4e var4) {
                        throw var4;
                     }

                     var3 = 1768768954 ^ -289876668;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var10000 = 1132452771 ^ -289876668;
               }

               var3 = var10000;
               if (var1 == 0) {
                  break;
               }

               return true;
            default:
               throw null;
         }
      }
   }

   private boolean ը(EntityPlayerSP var1) {
      oc81c78bf988 var3 = null;
      int var4 = 0;
      int var5 = 0;
      int var6 = 0;
      int var2 = oc84f20a0bc5.ė;
      int var7 = -591208030 ^ -1913913559;

      while (true) {
         switch (var7) {
            case -1756984023:
               return true;
            case -1575907439:
               int var13 = var4;
               if (var2 == 0) {
                  var5 = ɂ(var4);
                  var6 = Math.max(0, var3.ˢ - 1);
                  if (var6 >= var5) {
                     var7 = 447574528 ^ -1913913559;
                     if (var2 == 0) {
                        break;
                     }
                  }

                  var13 = -1212828747 ^ -1913913559;
               }

               var7 = var13;
               if (var2 == 0) {
                  break;
               }
            case 1192374564:
               if (this.ն == null) {
                  var7 = 711595951 ^ -1913913559;
                  if (var2 == 0) {
                     break;
                  }
               }

               var7 = 1906246311 ^ -1913913559;
               if (var2 == 0) {
                  break;
               }

               return false;
            case -1484658554:
               return false;
            case -842621934:
               return false;
            case -692252158:
               return false;
            case -203010913:
               if (var1 != null) {
                  var7 = -889598451 ^ -1913913559;
                  if (var2 == 0) {
                     break;
                  }
               }

               var7 = 711595951 ^ -1913913559;
               if (var2 == 0) {
                  break;
               }

               return false;
            case -59441778:
               var3 = this.ű(var1, 1);

               label93: {
                  label92: {
                     try {
                        if (var2 != 0) {
                           break label93;
                        }

                        if (var3.I) {
                           break label92;
                        }
                     } catch (ocbde1165e4e var9) {
                        throw var9;
                     }

                     var7 = 1076716347 ^ -1913913559;
                     if (var2 == 0) {
                        break;
                     }
                  }

                  var7 = -1596960812 ^ -1913913559;
               }

               if (var2 == 0) {
                  break;
               }
            case 758886653:
               int var12 = this.f(var1, var3);
               if (var2 == 0) {
                  var4 = var12;
                  if (var4 < 0) {
                     var7 = 1532423467 ^ -1913913559;
                     if (var2 == 0) {
                        break;
                     }
                  }

                  var12 = 804942008 ^ -1913913559;
               }

               var7 = var12;
               if (var2 == 0) {
                  break;
               }

               return false;
            case 979258524:
               return false;
            case 1361649291:
               int var10000;
               label77: {
                  label76: {
                     try {
                        var10000 = this.ɐ;
                        if (var2 != 0) {
                           break label77;
                        }

                        if (!this.ɐ) {
                           break label76;
                        }
                     } catch (ocbde1165e4e var8) {
                        throw var8;
                     }

                     var7 = 2114827190 ^ -1913913559;
                     if (var2 == 0) {
                        break;
                     }
                  }

                  var10000 = 711595951 ^ -1913913559;
               }

               var7 = var10000;
               break;
            default:
               throw null;
         }
      }
   }

   private oc81c78bf988 ű(EntityPlayerSP param1, int param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: bipush 0
      // 004: iload 2
      // 005: invokestatic java/lang/Math.max (II)I
      // 008: istore 4
      // 00a: istore 3
      // 00b: new x/oceb7a9b9a85
      // 00e: dup
      // 00f: aload 0
      // 010: getfield x/ocbce5ea28a3.ն Lx/oceb7a9b9a85;
      // 013: getfield x/oceb7a9b9a85.ē F
      // 016: aload 0
      // 017: getfield x/ocbce5ea28a3.ն Lx/oceb7a9b9a85;
      // 01a: getfield x/oceb7a9b9a85.ӥ F
      // 01d: aload 0
      // 01e: getfield x/ocbce5ea28a3.ն Lx/oceb7a9b9a85;
      // 021: getfield x/oceb7a9b9a85.Ƈ F
      // 024: aload 0
      // 025: getfield x/ocbce5ea28a3.ն Lx/oceb7a9b9a85;
      // 028: getfield x/oceb7a9b9a85.Đ F
      // 02b: fconst_0
      // 02c: fconst_0
      // 02d: aload 0
      // 02e: getfield x/ocbce5ea28a3.ն Lx/oceb7a9b9a85;
      // 031: getfield x/oceb7a9b9a85.Ú Z
      // 034: bipush 0
      // 035: invokespecial x/oceb7a9b9a85.<init> (FFFFFFZZ)V
      // 038: astore 5
      // 03a: iload 4
      // 03c: ifne 06a
      // 03f: dconst_0
      // 040: dconst_0
      // 041: aload 1
      // 042: getfield net/minecraft/client/entity/EntityPlayerSP.posY D
      // 045: aload 1
      // 046: getfield net/minecraft/client/entity/EntityPlayerSP.motionX D
      // 049: aload 1
      // 04a: getfield net/minecraft/client/entity/EntityPlayerSP.motionY D
      // 04d: aload 1
      // 04e: getfield net/minecraft/client/entity/EntityPlayerSP.motionZ D
      // 051: aload 5
      // 053: aload 1
      // 054: getfield net/minecraft/client/entity/EntityPlayerSP.jumpMovementFactor F
      // 057: aload 0
      // 058: getfield x/ocbce5ea28a3.ʐ I
      // 05b: i2d
      // 05c: dconst_1
      // 05d: dadd
      // 05e: ldc_w -1939832912
      // 061: ldc_w -1939832900
      // 064: ixor
      // 065: invokestatic x/ocbce5ea28a3.ù (DDDDDDLx/oceb7a9b9a85;FDI)Lx/oc81c78bf988;
      // 068: areturn
      // 069: athrow
      // 06a: dconst_0
      // 06b: dconst_0
      // 06c: aload 1
      // 06d: getfield net/minecraft/client/entity/EntityPlayerSP.posY D
      // 070: aload 1
      // 071: getfield net/minecraft/client/entity/EntityPlayerSP.motionX D
      // 074: aload 1
      // 075: getfield net/minecraft/client/entity/EntityPlayerSP.motionY D
      // 078: aload 1
      // 079: getfield net/minecraft/client/entity/EntityPlayerSP.motionZ D
      // 07c: aload 0
      // 07d: getfield x/ocbce5ea28a3.ն Lx/oceb7a9b9a85;
      // 080: aload 1
      // 081: getfield net/minecraft/client/entity/EntityPlayerSP.jumpMovementFactor F
      // 084: aload 0
      // 085: getfield x/ocbce5ea28a3.ʐ I
      // 088: i2d
      // 089: dconst_1
      // 08a: dadd
      // 08b: iload 4
      // 08d: invokestatic x/ocbce5ea28a3.ù (DDDDDDLx/oceb7a9b9a85;FDI)Lx/oc81c78bf988;
      // 090: astore 6
      // 092: aload 6
      // 094: iload 3
      // 095: ifne 0c3
      // 098: getfield x/oc81c78bf988.I Z
      // 09b: ifne 0bd
      // 09e: goto 0a2
      // 0a1: athrow
      // 0a2: aload 6
      // 0a4: iload 3
      // 0a5: ifne 0fc
      // 0a8: goto 0ac
      // 0ab: athrow
      // 0ac: getfield x/oc81c78bf988.ˢ I
      // 0af: ldc_w -1939832912
      // 0b2: ldc_w -1939832900
      // 0b5: ixor
      // 0b6: if_icmplt 0c4
      // 0b9: goto 0bd
      // 0bc: athrow
      // 0bd: aload 6
      // 0bf: goto 0c3
      // 0c2: athrow
      // 0c3: areturn
      // 0c4: dconst_0
      // 0c5: dconst_0
      // 0c6: aload 1
      // 0c7: getfield net/minecraft/client/entity/EntityPlayerSP.posY D
      // 0ca: aload 6
      // 0cc: getfield x/oc81c78bf988.ԣ D
      // 0cf: dadd
      // 0d0: aload 6
      // 0d2: getfield x/oc81c78bf988.ѱ D
      // 0d5: aload 6
      // 0d7: getfield x/oc81c78bf988.ú D
      // 0da: aload 6
      // 0dc: getfield x/oc81c78bf988.D D
      // 0df: aload 5
      // 0e1: aload 1
      // 0e2: getfield net/minecraft/client/entity/EntityPlayerSP.jumpMovementFactor F
      // 0e5: aload 0
      // 0e6: getfield x/ocbce5ea28a3.ʐ I
      // 0e9: i2d
      // 0ea: dconst_1
      // 0eb: dadd
      // 0ec: ldc_w -1939832912
      // 0ef: ldc_w -1939832900
      // 0f2: ixor
      // 0f3: aload 6
      // 0f5: getfield x/oc81c78bf988.ˢ I
      // 0f8: isub
      // 0f9: invokestatic x/ocbce5ea28a3.ù (DDDDDDLx/oceb7a9b9a85;FDI)Lx/oc81c78bf988;
      // 0fc: astore 7
      // 0fe: aload 6
      // 100: aload 7
      // 102: invokestatic x/ocbce5ea28a3.Ք (Lx/oc81c78bf988;Lx/oc81c78bf988;)Lx/oc81c78bf988;
      // 105: areturn
   }

   static void ǎ(ocf242f30eaa var0) {
      int var1 = oc84f20a0bc5.ė;

      ocf242f30eaa var10000;
      label22: {
         try {
            var10000 = var0;
            if (var1 != 0) {
               break label22;
            }

            if (var0 == null) {
               return;
            }
         } catch (ocbde1165e4e var2) {
            throw var2;
         }

         var0.ў(0.0F);
         var0.I(0.0F);
         var10000 = var0;
      }

      var10000.ќ(false);
   }

   static oc81c78bf988 Ք(oc81c78bf988 param0, oc81c78bf988 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 2
      // 04: aload 0
      // 05: iload 2
      // 06: ifne 14
      // 09: ifnonnull 13
      // 0c: goto 10
      // 0f: athrow
      // 10: aload 1
      // 11: areturn
      // 12: athrow
      // 13: aload 1
      // 14: iload 2
      // 15: ifne 37
      // 18: ifnull 32
      // 1b: goto 1f
      // 1e: athrow
      // 1f: aload 0
      // 20: iload 2
      // 21: ifne 73
      // 24: goto 28
      // 27: athrow
      // 28: getfield x/oc81c78bf988.I Z
      // 2b: ifeq 38
      // 2e: goto 32
      // 31: athrow
      // 32: aload 0
      // 33: goto 37
      // 36: athrow
      // 37: areturn
      // 38: new x/oc81c78bf988
      // 3b: dup
      // 3c: aload 0
      // 3d: getfield x/oc81c78bf988.ơ D
      // 40: aload 1
      // 41: getfield x/oc81c78bf988.ơ D
      // 44: dadd
      // 45: aload 0
      // 46: getfield x/oc81c78bf988.ԣ D
      // 49: aload 1
      // 4a: getfield x/oc81c78bf988.ԣ D
      // 4d: dadd
      // 4e: aload 0
      // 4f: getfield x/oc81c78bf988.о D
      // 52: aload 1
      // 53: getfield x/oc81c78bf988.о D
      // 56: dadd
      // 57: aload 0
      // 58: getfield x/oc81c78bf988.ˢ I
      // 5b: aload 1
      // 5c: getfield x/oc81c78bf988.ˢ I
      // 5f: iadd
      // 60: aload 1
      // 61: getfield x/oc81c78bf988.I Z
      // 64: aload 1
      // 65: getfield x/oc81c78bf988.ѱ D
      // 68: aload 1
      // 69: getfield x/oc81c78bf988.ú D
      // 6c: aload 1
      // 6d: getfield x/oc81c78bf988.D D
      // 70: invokespecial x/oc81c78bf988.<init> (DDDIZDDD)V
      // 73: areturn
   }

   private int f(EntityPlayerSP var1, oc81c78bf988 var2) {
      M var4 = null;
      int var5 = -785184104 ^ -2101954994;
      int var3 = oc84f20a0bc5.ė;

      while (true) {
         switch (var5) {
            case -97682852:
               return -1;
            case -74228210:
               return -1;
            case 52429898:
               if (var2 != null) {
                  var5 = -754337092 ^ -2101954994;
                  if (var3 == 0) {
                     break;
                  }
               }

               var5 = 2032527424 ^ -2101954994;
               if (var3 == 0) {
                  break;
               }
            case -1724400375:
               var4 = this.Ʀ(var1, var2, this.ҽ.Չ);

               label61: {
                  label60: {
                     try {
                        if (var3 != 0) {
                           break label61;
                        }

                        if (var4 == null) {
                           break label60;
                        }
                     } catch (ocbde1165e4e var6) {
                        throw var6;
                     }

                     var5 = -1369336211 ^ -2101954994;
                     if (var3 == 0) {
                        break;
                     }
                  }

                  var5 = 2023476242 ^ -2101954994;
               }

               if (var3 == 0) {
                  break;
               }

               return Math.max(1, var4.ƺ.size());
            case 1317741437:
               return Math.max(1, var4.ƺ.size());
            case 1401273558:
               if (var1 != null) {
                  var5 = -2120830460 ^ -2101954994;
                  if (var3 == 0) {
                     break;
                  }
               }

               var5 = 2032527424 ^ -2101954994;
               if (var3 == 0) {
                  break;
               }
            case 752295971:
               int var10000;
               label75: {
                  label74: {
                     try {
                        var10000 = var4.ϓ;
                        if (var3 != 0) {
                           break label75;
                        }

                        if (!var4.ϓ) {
                           break label74;
                        }
                     } catch (ocbde1165e4e var7) {
                        throw var7;
                     }

                     var5 = -868379341 ^ -2101954994;
                     if (var3 == 0) {
                        break;
                     }
                  }

                  var10000 = 2023476242 ^ -2101954994;
               }

               var5 = var10000;
               if (var3 == 0) {
                  break;
               }
            case 1371475186:
               if (this.ҽ == null) {
                  var5 = 2032527424 ^ -2101954994;
                  if (var3 == 0) {
                     break;
                  }
               }

               var5 = 461441863 ^ -2101954994;
               if (var3 == 0) {
                  break;
               }

               return -1;
            default:
               throw null;
         }
      }
   }

   static int ɂ(int var0) {
      return Ѵ(Math.max(1, var0)) + 1 + 1;
   }

   static boolean č(int param0, int param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 2
      // 04: iload 0
      // 05: iload 2
      // 06: ifne 19
      // 09: iload 1
      // 0a: invokestatic x/ocbce5ea28a3.ɂ (I)I
      // 0d: if_icmpgt 1c
      // 10: goto 14
      // 13: athrow
      // 14: bipush 1
      // 15: goto 19
      // 18: athrow
      // 19: goto 1d
      // 1c: bipush 0
      // 1d: ireturn
   }

   private boolean ϙ(AxisAlignedBB var1, int var2) {
      double var3 = (var1.minX + var1.maxX) * 0.5;
      double var5 = (var1.minZ + var1.maxZ) * 0.5;
      return this.Ζ(new BlockPos(MathHelper.floor_double(var3), var2, MathHelper.floor_double(var5)));
   }

   static boolean ͳ(EnumFacing param0, double param1, double param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 5
      // 05: aload 0
      // 06: iload 5
      // 08: ifne 13
      // 0b: ifnull 1c
      // 0e: goto 12
      // 11: athrow
      // 12: aload 0
      // 13: invokevirtual net/minecraft/util/EnumFacing.getAxis ()Lnet/minecraft/util/EnumFacing$Axis;
      // 16: getstatic net/minecraft/util/EnumFacing$Axis.Y Lnet/minecraft/util/EnumFacing$Axis;
      // 19: if_acmpne 1f
      // 1c: bipush 0
      // 1d: ireturn
      // 1e: athrow
      // 1f: dload 1
      // 20: dload 1
      // 21: dmul
      // 22: dload 3
      // 23: dload 3
      // 24: dmul
      // 25: dadd
      // 26: invokestatic java/lang/Math.sqrt (D)D
      // 29: dstore 6
      // 2b: dload 6
      // 2d: ldc2_w 1.0E-4
      // 30: iload 5
      // 32: ifne 51
      // 35: dcmpg
      // 36: ifge 40
      // 39: goto 3d
      // 3c: athrow
      // 3d: bipush 0
      // 3e: ireturn
      // 3f: athrow
      // 40: aload 0
      // 41: invokevirtual net/minecraft/util/EnumFacing.getFrontOffsetX ()I
      // 44: i2d
      // 45: dload 1
      // 46: dmul
      // 47: aload 0
      // 48: invokevirtual net/minecraft/util/EnumFacing.getFrontOffsetZ ()I
      // 4b: i2d
      // 4c: dload 3
      // 4d: dmul
      // 4e: dadd
      // 4f: dload 6
      // 51: ddiv
      // 52: dstore 8
      // 54: dload 8
      // 56: ldc2_w 1.0E-4
      // 59: dcmpl
      // 5a: iload 5
      // 5c: ifne 67
      // 5f: ifle 6a
      // 62: goto 66
      // 65: athrow
      // 66: bipush 1
      // 67: goto 6b
      // 6a: bipush 0
      // 6b: ireturn
   }

   private double հ(AxisAlignedBB param1, int param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: aload 1
      // 04: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 07: ldc2_w 1.0E-4
      // 0a: dadd
      // 0b: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 0e: istore 4
      // 10: aload 1
      // 11: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 14: ldc2_w 1.0E-4
      // 17: dsub
      // 18: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 1b: istore 5
      // 1d: istore 3
      // 1e: aload 1
      // 1f: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 22: ldc2_w 1.0E-4
      // 25: dadd
      // 26: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 29: istore 6
      // 2b: aload 1
      // 2c: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 2f: ldc2_w 1.0E-4
      // 32: dsub
      // 33: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 36: istore 7
      // 38: dconst_0
      // 39: dstore 8
      // 3b: iload 4
      // 3d: istore 10
      // 3f: iload 10
      // 41: iload 5
      // 43: if_icmpgt 91
      // 46: iload 6
      // 48: istore 11
      // 4a: iload 11
      // 4c: iload 7
      // 4e: if_icmpgt 8a
      // 51: new net/minecraft/util/BlockPos
      // 54: dup
      // 55: iload 10
      // 57: iload 2
      // 58: iload 11
      // 5a: invokespecial net/minecraft/util/BlockPos.<init> (III)V
      // 5d: astore 12
      // 5f: iload 3
      // 60: ifne 8d
      // 63: iload 3
      // 64: ifne 86
      // 67: goto 6b
      // 6a: athrow
      // 6b: aload 0
      // 6c: aload 12
      // 6e: invokevirtual x/ocbce5ea28a3.Ζ (Lnet/minecraft/util/BlockPos;)Z
      // 71: ifeq 83
      // 74: goto 78
      // 77: athrow
      // 78: dload 8
      // 7a: aload 1
      // 7b: aload 12
      // 7d: invokestatic x/ocbce5ea28a3.ϡ (Lnet/minecraft/util/AxisAlignedBB;Lnet/minecraft/util/BlockPos;)D
      // 80: dadd
      // 81: dstore 8
      // 83: iinc 11 1
      // 86: iload 3
      // 87: ifeq 4a
      // 8a: iinc 10 1
      // 8d: iload 3
      // 8e: ifeq 3f
      // 91: dload 8
      // 93: dreturn
   }

   private static double ϡ(AxisAlignedBB var0, BlockPos var1) {
      double var2 = Math.max(0.0, Math.min(var0.maxX, var1.getX() + 1.0) - Math.max(var0.minX, (double)var1.getX()));
      double var4 = Math.max(0.0, Math.min(var0.maxZ, var1.getZ() + 1.0) - Math.max(var0.minZ, (double)var1.getZ()));
      return var2 * var4;
   }

   private oc78dc1256b9 ց(oc7b822110db param1, AxisAlignedBB param2, int param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: istore 4
      // 005: aload 1
      // 006: ifnull 011
      // 009: aload 2
      // 00a: ifnonnull 014
      // 00d: goto 011
      // 010: athrow
      // 011: aconst_null
      // 012: areturn
      // 013: athrow
      // 014: aload 1
      // 015: invokevirtual x/oc7b822110db.ә ()Lx/oc7b822110db;
      // 018: astore 5
      // 01a: new java/util/ArrayList
      // 01d: dup
      // 01e: invokespecial java/util/ArrayList.<init> ()V
      // 021: astore 6
      // 023: new java/util/HashSet
      // 026: dup
      // 027: invokespecial java/util/HashSet.<init> ()V
      // 02a: astore 7
      // 02c: aload 7
      // 02e: aload 5
      // 030: invokevirtual x/oc7b822110db.Ȍ ()Lnet/minecraft/util/BlockPos;
      // 033: invokeinterface java/util/Set.add (Ljava/lang/Object;)Z 2
      // 038: pop
      // 039: aload 0
      // 03a: aload 2
      // 03b: aload 7
      // 03d: invokevirtual x/ocbce5ea28a3.ӵ (Lnet/minecraft/util/AxisAlignedBB;Ljava/util/Set;)D
      // 040: dstore 8
      // 042: aload 0
      // 043: aload 2
      // 044: aload 7
      // 046: invokevirtual x/ocbce5ea28a3.Γ (Lnet/minecraft/util/AxisAlignedBB;Ljava/util/Set;)Z
      // 049: istore 10
      // 04b: bipush 1
      // 04c: iload 3
      // 04d: invokestatic java/lang/Math.max (II)I
      // 050: istore 11
      // 052: dload 8
      // 054: ldc2_w 0.2
      // 057: dcmpg
      // 058: iflt 072
      // 05b: iload 10
      // 05d: iload 4
      // 05f: ifne 07d
      // 062: iload 4
      // 064: ifne 0f0
      // 067: goto 06b
      // 06a: athrow
      // 06b: ifne 0ea
      // 06e: goto 072
      // 071: athrow
      // 072: aload 6
      // 074: invokeinterface java/util/List.size ()I 1
      // 079: goto 07d
      // 07c: athrow
      // 07d: iload 4
      // 07f: ifne 0f0
      // 082: iload 11
      // 084: if_icmpge 0ea
      // 087: goto 08b
      // 08a: athrow
      // 08b: aload 5
      // 08d: invokevirtual x/oc7b822110db.B ()Lx/oc1a5b048236;
      // 090: astore 12
      // 092: aload 12
      // 094: iload 4
      // 096: ifne 0a2
      // 099: ifnull 0ea
      // 09c: goto 0a0
      // 09f: athrow
      // 0a0: aload 12
      // 0a2: getfield x/oc1a5b048236.ӄ Lnet/minecraft/util/BlockPos;
      // 0a5: ifnonnull 0b1
      // 0a8: iload 4
      // 0aa: ifeq 0ea
      // 0ad: goto 0b1
      // 0b0: athrow
      // 0b1: aload 6
      // 0b3: aload 12
      // 0b5: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 0ba: pop
      // 0bb: iload 4
      // 0bd: aload 5
      // 0bf: aload 12
      // 0c1: getfield x/oc1a5b048236.ӄ Lnet/minecraft/util/BlockPos;
      // 0c4: invokevirtual x/oc7b822110db.ǹ (Lnet/minecraft/util/BlockPos;)Z
      // 0c7: pop
      // 0c8: aload 7
      // 0ca: aload 12
      // 0cc: getfield x/oc1a5b048236.ӄ Lnet/minecraft/util/BlockPos;
      // 0cf: invokeinterface java/util/Set.add (Ljava/lang/Object;)Z 2
      // 0d4: pop
      // 0d5: aload 0
      // 0d6: aload 2
      // 0d7: aload 7
      // 0d9: invokevirtual x/ocbce5ea28a3.ӵ (Lnet/minecraft/util/AxisAlignedBB;Ljava/util/Set;)D
      // 0dc: dstore 8
      // 0de: aload 0
      // 0df: aload 2
      // 0e0: aload 7
      // 0e2: invokevirtual x/ocbce5ea28a3.Γ (Lnet/minecraft/util/AxisAlignedBB;Ljava/util/Set;)Z
      // 0e5: istore 10
      // 0e7: ifeq 052
      // 0ea: dload 8
      // 0ec: ldc2_w 0.2
      // 0ef: dcmpl
      // 0f0: iload 4
      // 0f2: ifne 0fe
      // 0f5: iflt 10e
      // 0f8: goto 0fc
      // 0fb: athrow
      // 0fc: iload 10
      // 0fe: iload 4
      // 100: ifne 10b
      // 103: ifeq 10e
      // 106: goto 10a
      // 109: athrow
      // 10a: bipush 1
      // 10b: goto 10f
      // 10e: bipush 0
      // 10f: istore 12
      // 111: new x/oc78dc1256b9
      // 114: dup
      // 115: aload 6
      // 117: aload 5
      // 119: dload 8
      // 11b: iload 12
      // 11d: invokespecial x/oc78dc1256b9.<init> (Ljava/util/List;Lx/oc7b822110db;DZ)V
      // 120: areturn
   }

   private double ӵ(AxisAlignedBB param1, Set<BlockPos> param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 3
      // 04: aload 1
      // 05: ifnull 29
      // 08: aload 2
      // 09: iload 3
      // 0a: ifne 19
      // 0d: goto 11
      // 10: athrow
      // 11: ifnull 29
      // 14: goto 18
      // 17: athrow
      // 18: aload 2
      // 19: invokeinterface java/util/Set.isEmpty ()Z 1
      // 1e: iload 3
      // 1f: ifne 37
      // 22: ifeq 2c
      // 25: goto 29
      // 28: athrow
      // 29: dconst_0
      // 2a: dreturn
      // 2b: athrow
      // 2c: aload 1
      // 2d: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 30: ldc2_w 1.0E-4
      // 33: dadd
      // 34: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 37: istore 4
      // 39: aload 1
      // 3a: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 3d: ldc2_w 1.0E-4
      // 40: dsub
      // 41: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 44: istore 5
      // 46: aload 1
      // 47: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 4a: ldc2_w 1.0E-4
      // 4d: dadd
      // 4e: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 51: istore 6
      // 53: aload 1
      // 54: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 57: ldc2_w 1.0E-4
      // 5a: dsub
      // 5b: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 5e: istore 7
      // 60: dconst_0
      // 61: dstore 8
      // 63: iload 4
      // 65: istore 10
      // 67: iload 10
      // 69: iload 5
      // 6b: if_icmpgt cb
      // 6e: iload 6
      // 70: istore 11
      // 72: iload 11
      // 74: iload 7
      // 76: if_icmpgt c4
      // 79: new net/minecraft/util/BlockPos
      // 7c: dup
      // 7d: iload 10
      // 7f: aload 0
      // 80: getfield x/ocbce5ea28a3.ʐ I
      // 83: iload 11
      // 85: invokespecial net/minecraft/util/BlockPos.<init> (III)V
      // 88: astore 12
      // 8a: iload 3
      // 8b: ifne c7
      // 8e: aload 2
      // 8f: aload 12
      // 91: invokeinterface java/util/Set.contains (Ljava/lang/Object;)Z 2
      // 96: iload 3
      // 97: ifne af
      // 9a: goto 9e
      // 9d: athrow
      // 9e: ifne b2
      // a1: goto a5
      // a4: athrow
      // a5: aload 0
      // a6: aload 12
      // a8: invokevirtual x/ocbce5ea28a3.Ζ (Lnet/minecraft/util/BlockPos;)Z
      // ab: goto af
      // ae: athrow
      // af: ifeq bd
      // b2: dload 8
      // b4: aload 1
      // b5: aload 12
      // b7: invokestatic x/ocbce5ea28a3.ϡ (Lnet/minecraft/util/AxisAlignedBB;Lnet/minecraft/util/BlockPos;)D
      // ba: dadd
      // bb: dstore 8
      // bd: iinc 11 1
      // c0: iload 3
      // c1: ifeq 72
      // c4: iinc 10 1
      // c7: iload 3
      // c8: ifeq 67
      // cb: dload 8
      // cd: dreturn
   }

   private boolean Γ(AxisAlignedBB var1, Set<BlockPos> var2) {
      double var4 = 0.0;
      double var6 = 0.0;
      int var3 = oc84f20a0bc5.ė;
      BlockPos var8 = null;
      int var9 = 1190640643 ^ 1410776453;

      while (true) {
         switch (var9) {
            case -1764399839:
               return false;
            case 527220614:
               int var10000;
               label42: {
                  label41: {
                     try {
                        var10000 = this.Ζ(var8);
                        if (var3 != 0) {
                           break label42;
                        }

                        if (var10000 == 0) {
                           break label41;
                        }
                     } catch (ocbde1165e4e var10) {
                        throw var10;
                     }

                     var9 = 448888255 ^ 1410776453;
                     if (var3 == 0) {
                        break;
                     }
                  }

                  var10000 = -1027352412 ^ 1410776453;
               }

               var9 = var10000;
               if (var3 == 0) {
                  break;
               }
            case 316735878:
               var4 = (var1.minX + var1.maxX) * 0.5;
               if (var3 == 0) {
                  var6 = (var1.minZ + var1.maxZ) * 0.5;
                  var8 = new BlockPos(MathHelper.floor_double(var4), this.ʐ, MathHelper.floor_double(var6));
                  if (!var2.contains(var8)) {
                     var9 = 1266287107 ^ 1410776453;
                     if (var3 == 0) {
                        break;
                     }
                  }

                  var9 = 448888255 ^ 1410776453;
               }

               if (var3 == 0) {
                  break;
               }

               return true;
            case 1322762298:
               return true;
            default:
               throw null;
         }
      }
   }

   private oc3ab56105e0 Ϥ(oc1a421bd3db param1, oceb39b7deb2 param2, oceb39b7deb2 param3, float param4, float param5, float param6) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: istore 7
      // 005: aload 1
      // 006: ifnull 028
      // 009: aload 2
      // 00a: ifnull 028
      // 00d: goto 011
      // 010: athrow
      // 011: aload 0
      // 012: iload 7
      // 014: ifne 02c
      // 017: goto 01b
      // 01a: athrow
      // 01b: getfield x/ocbce5ea28a3.Ѭ Lnet/minecraft/client/Minecraft;
      // 01e: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 021: ifnonnull 02b
      // 024: goto 028
      // 027: athrow
      // 028: aconst_null
      // 029: areturn
      // 02a: athrow
      // 02b: aload 0
      // 02c: invokevirtual x/ocbce5ea28a3.Щ ()F
      // 02f: fstore 8
      // 031: aload 0
      // 032: aload 1
      // 033: invokevirtual x/ocbce5ea28a3.Ų (Lx/oc1a421bd3db;)Lx/oc1a421bd3db;
      // 036: astore 9
      // 038: aconst_null
      // 039: astore 10
      // 03b: aload 1
      // 03c: getfield x/oc1a421bd3db.ʚ Lnet/minecraft/util/BlockPos;
      // 03f: aload 1
      // 040: getfield x/oc1a421bd3db.Փ Lnet/minecraft/util/EnumFacing;
      // 043: invokestatic x/ocbce5ea28a3.ȩ (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;)Ljava/util/List;
      // 046: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 04b: astore 11
      // 04d: aload 11
      // 04f: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 054: ifeq 1ea
      // 057: aload 11
      // 059: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 05e: checkcast net/minecraft/util/Vec3
      // 061: astore 12
      // 063: aload 2
      // 064: invokevirtual x/oceb39b7deb2.Ɍ ()Lnet/minecraft/util/Vec3;
      // 067: aload 12
      // 069: fload 4
      // 06b: fload 5
      // 06d: invokestatic x/ocbce5ea28a3.P (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;FF)[F
      // 070: astore 13
      // 072: fload 4
      // 074: aload 13
      // 076: bipush 0
      // 077: faload
      // 078: fload 8
      // 07a: invokestatic x/ocbce5ea28a3.Ҁ (FFF)F
      // 07d: fstore 14
      // 07f: fload 5
      // 081: aload 13
      // 083: bipush 1
      // 084: faload
      // 085: fload 8
      // 087: invokestatic x/ocbce5ea28a3.ǣ (FFF)F
      // 08a: fstore 15
      // 08c: fload 14
      // 08e: fload 8
      // 090: invokestatic x/ocbce5ea28a3.â (FF)[F
      // 093: astore 16
      // 095: aload 16
      // 097: arraylength
      // 098: istore 17
      // 09a: bipush 0
      // 09b: istore 18
      // 09d: iload 18
      // 09f: iload 17
      // 0a1: if_icmpge 1e5
      // 0a4: aload 16
      // 0a6: iload 18
      // 0a8: faload
      // 0a9: iload 7
      // 0ab: ifne 08e
      // 0ae: fstore 19
      // 0b0: iload 7
      // 0b2: aload 0
      // 0b3: aload 2
      // 0b4: fload 19
      // 0b6: fload 15
      // 0b8: aload 1
      // 0b9: invokevirtual x/ocbce5ea28a3.Ȱ (Lx/oceb39b7deb2;FFLx/oc1a421bd3db;)Lnet/minecraft/util/MovingObjectPosition;
      // 0bc: astore 20
      // 0be: ifne 1e0
      // 0c1: aload 20
      // 0c3: aload 1
      // 0c4: invokestatic x/ocbce5ea28a3.ǟ (Lnet/minecraft/util/MovingObjectPosition;Lx/oc1a421bd3db;)Z
      // 0c7: ifeq 1dd
      // 0ca: goto 0ce
      // 0cd: athrow
      // 0ce: fload 15
      // 0d0: iload 7
      // 0d2: ifne 0fb
      // 0d5: goto 0d9
      // 0d8: athrow
      // 0d9: invokestatic x/ocbce5ea28a3.ο (F)Z
      // 0dc: ifne 0ec
      // 0df: goto 0e3
      // 0e2: athrow
      // 0e3: iload 7
      // 0e5: ifeq 1dd
      // 0e8: goto 0ec
      // 0eb: athrow
      // 0ec: fload 19
      // 0ee: fload 4
      // 0f0: fsub
      // 0f1: invokestatic net/minecraft/util/MathHelper.wrapAngleTo180_float (F)F
      // 0f4: invokestatic java/lang/Math.abs (F)F
      // 0f7: goto 0fb
      // 0fa: athrow
      // 0fb: fstore 21
      // 0fd: fload 19
      // 0ff: fload 6
      // 101: fsub
      // 102: invokestatic net/minecraft/util/MathHelper.wrapAngleTo180_float (F)F
      // 105: invokestatic java/lang/Math.abs (F)F
      // 108: fstore 22
      // 10a: fload 15
      // 10c: fload 5
      // 10e: fsub
      // 10f: invokestatic java/lang/Math.abs (F)F
      // 112: fstore 23
      // 114: aload 9
      // 116: ifnull 14c
      // 119: aload 3
      // 11a: iload 7
      // 11c: ifne 12b
      // 11f: goto 123
      // 122: athrow
      // 123: ifnonnull 12e
      // 126: goto 12a
      // 129: athrow
      // 12a: aload 2
      // 12b: goto 12f
      // 12e: aload 3
      // 12f: fload 19
      // 131: fload 15
      // 133: aload 9
      // 135: getfield x/oc1a421bd3db.ʚ Lnet/minecraft/util/BlockPos;
      // 138: aload 9
      // 13a: getfield x/oc1a421bd3db.Փ Lnet/minecraft/util/EnumFacing;
      // 13d: invokestatic x/ocbce5ea28a3.Ŏ (Lx/oceb39b7deb2;FFLnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;)Z
      // 140: iload 7
      // 142: ifne 14d
      // 145: ifeq 150
      // 148: goto 14c
      // 14b: athrow
      // 14c: bipush 1
      // 14d: goto 151
      // 150: bipush 0
      // 151: istore 24
      // 153: fload 22
      // 155: f2d
      // 156: ldc2_w 4.0
      // 159: dmul
      // 15a: fload 21
      // 15c: f2d
      // 15d: ldc2_w 0.1
      // 160: dmul
      // 161: dadd
      // 162: fload 23
      // 164: f2d
      // 165: iload 7
      // 167: ifne 18e
      // 16a: ldc2_w 0.25
      // 16d: dmul
      // 16e: dadd
      // 16f: aload 2
      // 170: invokevirtual x/oceb39b7deb2.Ɍ ()Lnet/minecraft/util/Vec3;
      // 173: aload 20
      // 175: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 178: invokevirtual net/minecraft/util/Vec3.distanceTo (Lnet/minecraft/util/Vec3;)D
      // 17b: ldc2_w 0.01
      // 17e: dmul
      // 17f: dadd
      // 180: iload 24
      // 182: ifeq 191
      // 185: goto 189
      // 188: athrow
      // 189: dconst_0
      // 18a: goto 18e
      // 18d: athrow
      // 18e: goto 194
      // 191: ldc2_w 500.0
      // 194: dadd
      // 195: fload 15
      // 197: invokestatic x/ocbce5ea28a3.ɍ (F)Z
      // 19a: ifeq 1a2
      // 19d: dconst_0
      // 19e: goto 1a5
      // 1a1: athrow
      // 1a2: ldc2_w 1000.0
      // 1a5: dadd
      // 1a6: dstore 25
      // 1a8: aload 10
      // 1aa: iload 7
      // 1ac: ifne 1db
      // 1af: ifnull 1c5
      // 1b2: goto 1b6
      // 1b5: athrow
      // 1b6: dload 25
      // 1b8: aload 10
      // 1ba: getfield x/oc3ab56105e0.Ж D
      // 1bd: dcmpg
      // 1be: ifge 1dd
      // 1c1: goto 1c5
      // 1c4: athrow
      // 1c5: new x/oc3ab56105e0
      // 1c8: dup
      // 1c9: fload 19
      // 1cb: fload 15
      // 1cd: aload 20
      // 1cf: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 1d2: dload 25
      // 1d4: invokespecial x/oc3ab56105e0.<init> (FFLnet/minecraft/util/Vec3;D)V
      // 1d7: goto 1db
      // 1da: athrow
      // 1db: astore 10
      // 1dd: iinc 18 1
      // 1e0: iload 7
      // 1e2: ifeq 09d
      // 1e5: iload 7
      // 1e7: ifeq 04d
      // 1ea: aload 10
      // 1ec: areturn
   }

   private oc1a421bd3db Ų(oc1a421bd3db param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: istore 2
      // 004: aload 1
      // 005: ifnull 057
      // 008: aload 0
      // 009: iload 2
      // 00a: ifne 024
      // 00d: goto 011
      // 010: athrow
      // 011: getfield x/ocbce5ea28a3.б Lx/oc7b822110db;
      // 014: ifnull 057
      // 017: goto 01b
      // 01a: athrow
      // 01b: aload 0
      // 01c: iload 2
      // 01d: ifne 02f
      // 020: goto 024
      // 023: athrow
      // 024: invokevirtual x/ocbce5ea28a3.ӎ ()Z
      // 027: ifne 057
      // 02a: aload 0
      // 02b: goto 02f
      // 02e: athrow
      // 02f: iload 2
      // 030: ifne 042
      // 033: getfield x/ocbce5ea28a3.e Lnet/minecraft/util/BlockPos;
      // 036: ifnull 057
      // 039: goto 03d
      // 03c: athrow
      // 03d: aload 0
      // 03e: goto 042
      // 041: athrow
      // 042: iload 2
      // 043: ifne 05b
      // 046: getfield x/ocbce5ea28a3.π D
      // 049: aload 0
      // 04a: getfield x/ocbce5ea28a3.Ԅ D
      // 04d: invokestatic x/ocbce5ea28a3.ŧ (DD)Z
      // 050: ifne 05a
      // 053: goto 057
      // 056: athrow
      // 057: aconst_null
      // 058: areturn
      // 059: athrow
      // 05a: aload 0
      // 05b: getfield x/ocbce5ea28a3.б Lx/oc7b822110db;
      // 05e: invokevirtual x/oc7b822110db.ә ()Lx/oc7b822110db;
      // 061: astore 3
      // 062: aload 1
      // 063: getfield x/oc1a421bd3db.ʚ Lnet/minecraft/util/BlockPos;
      // 066: aload 3
      // 067: invokevirtual x/oc7b822110db.Ȍ ()Lnet/minecraft/util/BlockPos;
      // 06a: invokevirtual net/minecraft/util/BlockPos.equals (Ljava/lang/Object;)Z
      // 06d: iload 2
      // 06e: ifne 084
      // 071: ifeq 08f
      // 074: goto 078
      // 077: athrow
      // 078: aload 3
      // 079: aload 1
      // 07a: getfield x/oc1a421bd3db.Շ Lnet/minecraft/util/BlockPos;
      // 07d: invokevirtual x/oc7b822110db.ǹ (Lnet/minecraft/util/BlockPos;)Z
      // 080: goto 084
      // 083: athrow
      // 084: iload 2
      // 085: ifne 093
      // 088: ifne 092
      // 08b: goto 08f
      // 08e: athrow
      // 08f: aconst_null
      // 090: areturn
      // 091: athrow
      // 092: bipush 0
      // 093: istore 4
      // 095: iload 4
      // 097: ldc_w -2096996752
      // 09a: ldc_w -2096996746
      // 09d: ixor
      // 09e: if_icmpge 122
      // 0a1: aload 3
      // 0a2: iload 2
      // 0a3: ifne 0bb
      // 0a6: invokevirtual x/oc7b822110db.Ȍ ()Lnet/minecraft/util/BlockPos;
      // 0a9: aload 0
      // 0aa: getfield x/ocbce5ea28a3.e Lnet/minecraft/util/BlockPos;
      // 0ad: invokevirtual net/minecraft/util/BlockPos.equals (Ljava/lang/Object;)Z
      // 0b0: ifeq 0ba
      // 0b3: goto 0b7
      // 0b6: athrow
      // 0b7: aconst_null
      // 0b8: areturn
      // 0b9: athrow
      // 0ba: aload 3
      // 0bb: invokevirtual x/oc7b822110db.B ()Lx/oc1a5b048236;
      // 0be: astore 5
      // 0c0: aload 5
      // 0c2: ifnonnull 0c8
      // 0c5: aconst_null
      // 0c6: areturn
      // 0c7: athrow
      // 0c8: aload 0
      // 0c9: iload 2
      // 0ca: ifne 0f5
      // 0cd: aload 5
      // 0cf: getfield x/oc1a5b048236.ӄ Lnet/minecraft/util/BlockPos;
      // 0d2: invokevirtual x/ocbce5ea28a3.с (Lnet/minecraft/util/BlockPos;)Z
      // 0d5: ifeq 0f4
      // 0d8: goto 0dc
      // 0db: athrow
      // 0dc: new x/oc1a421bd3db
      // 0df: dup
      // 0e0: aload 5
      // 0e2: getfield x/oc1a5b048236.Ļ Lnet/minecraft/util/BlockPos;
      // 0e5: aload 5
      // 0e7: getfield x/oc1a5b048236.Ԉ Lnet/minecraft/util/EnumFacing;
      // 0ea: aload 5
      // 0ec: getfield x/oc1a5b048236.ӄ Lnet/minecraft/util/BlockPos;
      // 0ef: invokespecial x/oc1a421bd3db.<init> (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;Lnet/minecraft/util/BlockPos;)V
      // 0f2: areturn
      // 0f3: athrow
      // 0f4: aload 0
      // 0f5: aload 5
      // 0f7: getfield x/oc1a5b048236.ӄ Lnet/minecraft/util/BlockPos;
      // 0fa: invokevirtual x/ocbce5ea28a3.Ζ (Lnet/minecraft/util/BlockPos;)Z
      // 0fd: iload 2
      // 0fe: ifne 115
      // 101: ifeq 118
      // 104: goto 108
      // 107: athrow
      // 108: aload 3
      // 109: aload 5
      // 10b: getfield x/oc1a5b048236.ӄ Lnet/minecraft/util/BlockPos;
      // 10e: invokevirtual x/oc7b822110db.ǹ (Lnet/minecraft/util/BlockPos;)Z
      // 111: goto 115
      // 114: athrow
      // 115: ifne 11b
      // 118: aconst_null
      // 119: areturn
      // 11a: athrow
      // 11b: iinc 4 1
      // 11e: iload 2
      // 11f: ifeq 095
      // 122: aconst_null
      // 123: areturn
   }

   private static List<Vec3> ȩ(BlockPos param0, EnumFacing param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: new java/util/ArrayList
      // 003: dup
      // 004: invokespecial java/util/ArrayList.<init> ()V
      // 007: astore 3
      // 008: getstatic x/oc84f20a0bc5.ė I
      // 00b: getstatic x/ocbce5ea28a3.Ћ [D
      // 00e: astore 4
      // 010: istore 2
      // 011: aload 4
      // 013: arraylength
      // 014: istore 5
      // 016: bipush 0
      // 017: istore 6
      // 019: iload 6
      // 01b: iload 5
      // 01d: if_icmpge 17a
      // 020: aload 4
      // 022: iload 6
      // 024: daload
      // 025: dstore 7
      // 027: getstatic x/ocbce5ea28a3.Ћ [D
      // 02a: astore 9
      // 02c: aload 9
      // 02e: arraylength
      // 02f: istore 10
      // 031: bipush 0
      // 032: istore 11
      // 034: iload 11
      // 036: iload 10
      // 038: if_icmpge 173
      // 03b: aload 9
      // 03d: iload 11
      // 03f: daload
      // 040: dstore 12
      // 042: iload 2
      // 043: aload 0
      // 044: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 047: i2d
      // 048: ldc2_w 0.5
      // 04b: dadd
      // 04c: dstore 14
      // 04e: aload 0
      // 04f: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 052: i2d
      // 053: dload 7
      // 055: dadd
      // 056: dstore 16
      // 058: ifne 176
      // 05b: aload 0
      // 05c: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 05f: i2d
      // 060: ldc2_w 0.5
      // 063: dadd
      // 064: dstore 18
      // 066: iload 2
      // 067: ifne 09a
      // 06a: aload 1
      // 06b: getstatic net/minecraft/util/EnumFacing.UP Lnet/minecraft/util/EnumFacing;
      // 06e: if_acmpeq 088
      // 071: goto 075
      // 074: athrow
      // 075: aload 1
      // 076: iload 2
      // 077: ifne 0c1
      // 07a: goto 07e
      // 07d: athrow
      // 07e: getstatic net/minecraft/util/EnumFacing.DOWN Lnet/minecraft/util/EnumFacing;
      // 081: if_acmpne 0c0
      // 084: goto 088
      // 087: athrow
      // 088: aload 0
      // 089: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 08c: i2d
      // 08d: dload 7
      // 08f: iload 2
      // 090: ifne 0ab
      // 093: goto 097
      // 096: athrow
      // 097: dadd
      // 098: dstore 14
      // 09a: aload 0
      // 09b: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 09e: i2d
      // 09f: aload 1
      // 0a0: getstatic net/minecraft/util/EnumFacing.UP Lnet/minecraft/util/EnumFacing;
      // 0a3: if_acmpne 0ae
      // 0a6: dconst_1
      // 0a7: goto 0ab
      // 0aa: athrow
      // 0ab: goto 0af
      // 0ae: dconst_0
      // 0af: dadd
      // 0b0: dstore 16
      // 0b2: iload 2
      // 0b3: aload 0
      // 0b4: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 0b7: i2d
      // 0b8: dload 12
      // 0ba: dadd
      // 0bb: dstore 18
      // 0bd: ifeq 158
      // 0c0: aload 1
      // 0c1: iload 2
      // 0c2: ifne 0d4
      // 0c5: getstatic net/minecraft/util/EnumFacing.NORTH Lnet/minecraft/util/EnumFacing;
      // 0c8: if_acmpeq 0e2
      // 0cb: goto 0cf
      // 0ce: athrow
      // 0cf: aload 1
      // 0d0: goto 0d4
      // 0d3: athrow
      // 0d4: iload 2
      // 0d5: ifne 115
      // 0d8: getstatic net/minecraft/util/EnumFacing.SOUTH Lnet/minecraft/util/EnumFacing;
      // 0db: if_acmpne 110
      // 0de: goto 0e2
      // 0e1: athrow
      // 0e2: aload 0
      // 0e3: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 0e6: i2d
      // 0e7: dload 12
      // 0e9: iload 2
      // 0ea: ifne 105
      // 0ed: goto 0f1
      // 0f0: athrow
      // 0f1: dadd
      // 0f2: dstore 14
      // 0f4: aload 0
      // 0f5: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 0f8: i2d
      // 0f9: aload 1
      // 0fa: getstatic net/minecraft/util/EnumFacing.SOUTH Lnet/minecraft/util/EnumFacing;
      // 0fd: if_acmpne 108
      // 100: dconst_1
      // 101: goto 105
      // 104: athrow
      // 105: goto 109
      // 108: dconst_0
      // 109: dadd
      // 10a: dstore 18
      // 10c: iload 2
      // 10d: ifeq 158
      // 110: aload 1
      // 111: goto 115
      // 114: athrow
      // 115: iload 2
      // 116: ifne 128
      // 119: getstatic net/minecraft/util/EnumFacing.WEST Lnet/minecraft/util/EnumFacing;
      // 11c: if_acmpeq 12e
      // 11f: goto 123
      // 122: athrow
      // 123: aload 1
      // 124: goto 128
      // 127: athrow
      // 128: getstatic net/minecraft/util/EnumFacing.EAST Lnet/minecraft/util/EnumFacing;
      // 12b: if_acmpne 158
      // 12e: aload 0
      // 12f: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 132: i2d
      // 133: dload 12
      // 135: iload 2
      // 136: ifne 151
      // 139: goto 13d
      // 13c: athrow
      // 13d: dadd
      // 13e: dstore 18
      // 140: aload 0
      // 141: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 144: i2d
      // 145: aload 1
      // 146: getstatic net/minecraft/util/EnumFacing.EAST Lnet/minecraft/util/EnumFacing;
      // 149: if_acmpne 154
      // 14c: dconst_1
      // 14d: goto 151
      // 150: athrow
      // 151: goto 155
      // 154: dconst_0
      // 155: dadd
      // 156: dstore 14
      // 158: aload 3
      // 159: new net/minecraft/util/Vec3
      // 15c: dup
      // 15d: dload 14
      // 15f: dload 16
      // 161: dload 18
      // 163: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 166: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 16b: pop
      // 16c: iload 2
      // 16d: iinc 11 1
      // 170: ifeq 034
      // 173: iinc 6 1
      // 176: iload 2
      // 177: ifeq 019
      // 17a: aload 3
      // 17b: areturn
   }

   private static float[] P(Vec3 var0, Vec3 var1, float var2, float var3) {
      double var4 = var1.xCoord - var0.xCoord;
      double var6 = var1.yCoord - var0.yCoord;
      double var8 = var1.zCoord - var0.zCoord;
      double var10 = Math.sqrt(var4 * var4 + var8 * var8);
      float var12 = (float)Math.toDegrees(Math.atan2(-var4, var8));
      float var13 = (float)(-Math.toDegrees(Math.atan2(var6, var10)));
      float[] var10000 = new float[-1623086596 ^ -1623086594];
      var10000[0] = Ԇ(var12, var2);
      var10000[1] = MathHelper.clamp_float(var13, -90.0F, 90.0F);
      return var10000;
   }

   private MovingObjectPosition Ψ(oceb39b7deb2 var1, float var2, float var3) {
      Vec3 var4 = var1.Ɍ();
      Vec3 var5 = oc7ab2161b9f.ҵ(var2, var3);
      Vec3 var6 = var4.addVector(var5.xCoord * 4.5, var5.yCoord * 4.5, var5.zCoord * 4.5);
      return this.Ѭ.theWorld.rayTraceBlocks(var4, var6, false, false, true);
   }

   private MovingObjectPosition Ȱ(oceb39b7deb2 param1, float param2, float param3, oc1a421bd3db param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: aload 0
      // 004: aload 1
      // 005: fload 2
      // 006: fload 3
      // 007: invokevirtual x/ocbce5ea28a3.Ψ (Lx/oceb39b7deb2;FF)Lnet/minecraft/util/MovingObjectPosition;
      // 00a: astore 6
      // 00c: istore 5
      // 00e: aload 6
      // 010: iload 5
      // 012: ifne 045
      // 015: aload 4
      // 017: invokestatic x/ocbce5ea28a3.ǟ (Lnet/minecraft/util/MovingObjectPosition;Lx/oc1a421bd3db;)Z
      // 01a: ifne 03f
      // 01d: goto 021
      // 020: athrow
      // 021: aload 4
      // 023: ifnull 03f
      // 026: goto 02a
      // 029: athrow
      // 02a: aload 0
      // 02b: getfield x/ocbce5ea28a3.Ñ Ljava/util/Set;
      // 02e: aload 4
      // 030: getfield x/oc1a421bd3db.ʚ Lnet/minecraft/util/BlockPos;
      // 033: invokeinterface java/util/Set.contains (Ljava/lang/Object;)Z 2
      // 038: ifne 046
      // 03b: goto 03f
      // 03e: athrow
      // 03f: aload 6
      // 041: goto 045
      // 044: athrow
      // 045: areturn
      // 046: aload 1
      // 047: invokevirtual x/oceb39b7deb2.Ɍ ()Lnet/minecraft/util/Vec3;
      // 04a: astore 7
      // 04c: fload 2
      // 04d: fload 3
      // 04e: invokestatic x/oc7ab2161b9f.ҵ (FF)Lnet/minecraft/util/Vec3;
      // 051: astore 8
      // 053: aload 7
      // 055: aload 8
      // 057: getfield net/minecraft/util/Vec3.xCoord D
      // 05a: ldc2_w 4.5
      // 05d: dmul
      // 05e: aload 8
      // 060: getfield net/minecraft/util/Vec3.yCoord D
      // 063: ldc2_w 4.5
      // 066: dmul
      // 067: aload 8
      // 069: getfield net/minecraft/util/Vec3.zCoord D
      // 06c: ldc2_w 4.5
      // 06f: dmul
      // 070: invokevirtual net/minecraft/util/Vec3.addVector (DDD)Lnet/minecraft/util/Vec3;
      // 073: astore 9
      // 075: new net/minecraft/util/AxisAlignedBB
      // 078: dup
      // 079: aload 4
      // 07b: getfield x/oc1a421bd3db.ʚ Lnet/minecraft/util/BlockPos;
      // 07e: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 081: i2d
      // 082: aload 4
      // 084: getfield x/oc1a421bd3db.ʚ Lnet/minecraft/util/BlockPos;
      // 087: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 08a: i2d
      // 08b: aload 4
      // 08d: getfield x/oc1a421bd3db.ʚ Lnet/minecraft/util/BlockPos;
      // 090: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 093: i2d
      // 094: aload 4
      // 096: getfield x/oc1a421bd3db.ʚ Lnet/minecraft/util/BlockPos;
      // 099: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 09c: i2d
      // 09d: dconst_1
      // 09e: dadd
      // 09f: aload 4
      // 0a1: getfield x/oc1a421bd3db.ʚ Lnet/minecraft/util/BlockPos;
      // 0a4: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 0a7: i2d
      // 0a8: dconst_1
      // 0a9: dadd
      // 0aa: aload 4
      // 0ac: getfield x/oc1a421bd3db.ʚ Lnet/minecraft/util/BlockPos;
      // 0af: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 0b2: i2d
      // 0b3: dconst_1
      // 0b4: dadd
      // 0b5: invokespecial net/minecraft/util/AxisAlignedBB.<init> (DDDDDD)V
      // 0b8: astore 10
      // 0ba: aload 10
      // 0bc: aload 7
      // 0be: aload 9
      // 0c0: invokevirtual net/minecraft/util/AxisAlignedBB.calculateIntercept (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;)Lnet/minecraft/util/MovingObjectPosition;
      // 0c3: astore 11
      // 0c5: aload 11
      // 0c7: iload 5
      // 0c9: ifne 0f3
      // 0cc: ifnull 0ed
      // 0cf: goto 0d3
      // 0d2: athrow
      // 0d3: aload 11
      // 0d5: iload 5
      // 0d7: ifne 0f6
      // 0da: goto 0de
      // 0dd: athrow
      // 0de: getfield net/minecraft/util/MovingObjectPosition.sideHit Lnet/minecraft/util/EnumFacing;
      // 0e1: aload 4
      // 0e3: getfield x/oc1a421bd3db.Փ Lnet/minecraft/util/EnumFacing;
      // 0e6: if_acmpeq 0f4
      // 0e9: goto 0ed
      // 0ec: athrow
      // 0ed: aload 6
      // 0ef: goto 0f3
      // 0f2: athrow
      // 0f3: areturn
      // 0f4: aload 6
      // 0f6: iload 5
      // 0f8: ifne 151
      // 0fb: ifnull 13b
      // 0fe: goto 102
      // 101: athrow
      // 102: aload 6
      // 104: iload 5
      // 106: ifne 151
      // 109: goto 10d
      // 10c: athrow
      // 10d: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 110: ifnull 13b
      // 113: goto 117
      // 116: athrow
      // 117: aload 7
      // 119: aload 6
      // 11b: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 11e: invokevirtual net/minecraft/util/Vec3.distanceTo (Lnet/minecraft/util/Vec3;)D
      // 121: aload 7
      // 123: aload 11
      // 125: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 128: invokevirtual net/minecraft/util/Vec3.distanceTo (Lnet/minecraft/util/Vec3;)D
      // 12b: ldc2_w 1.0E-4
      // 12e: dsub
      // 12f: dcmpg
      // 130: ifge 13b
      // 133: goto 137
      // 136: athrow
      // 137: aload 6
      // 139: areturn
      // 13a: athrow
      // 13b: new net/minecraft/util/MovingObjectPosition
      // 13e: dup
      // 13f: aload 11
      // 141: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 144: aload 11
      // 146: getfield net/minecraft/util/MovingObjectPosition.sideHit Lnet/minecraft/util/EnumFacing;
      // 149: aload 4
      // 14b: getfield x/oc1a421bd3db.ʚ Lnet/minecraft/util/BlockPos;
      // 14e: invokespecial net/minecraft/util/MovingObjectPosition.<init> (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/EnumFacing;Lnet/minecraft/util/BlockPos;)V
      // 151: areturn
   }

   private static boolean ǟ(MovingObjectPosition var0, oc1a421bd3db var1) {
      int var2 = oc84f20a0bc5.ė;
      int var3 = 1314342812 ^ 286741964;

      while (true) {
         switch (var3) {
            case -1812717214:
               break;
            case -230435628:
               return false;
            case 1140532837:
               if (var1 != null) {
                  var3 = -2099022674 ^ 286741964;
                  if (var2 == 0) {
                     continue;
                  }
               }

               var3 = -481001192 ^ 286741964;
               if (var2 == 0) {
                  continue;
               }
            case 1061288047:
               if (var0.typeOfHit == MovingObjectType.BLOCK) {
                  var3 = 1391227817 ^ 286741964;
                  if (var2 == 0) {
                     continue;
                  }
               }

               var3 = -481001192 ^ 286741964;
               if (var2 == 0) {
                  continue;
               }
            case -1981922797:
               if (var1.Փ == var0.sideHit) {
                  var3 = -1320440467 ^ 286741964;
                  if (var2 == 0) {
                     continue;
                  }
               }

               var3 = -481001192 ^ 286741964;
               if (var2 == 0) {
                  continue;
               }
            case -1604519775:
               return true;
            case 1598034512:
               if (var0 != null) {
                  var3 = 777432483 ^ 286741964;
                  if (var2 == 0) {
                     continue;
                  }
               }

               var3 = -481001192 ^ 286741964;
               if (var2 == 0) {
                  continue;
               }
               break;
            default:
               throw null;
         }

         int var10000;
         label57: {
            label56: {
               try {
                  var10000 = var1.ʚ.equals(var0.getBlockPos());
                  if (var2 != 0) {
                     break label57;
                  }

                  if (var10000 == 0) {
                     break label56;
                  }
               } catch (ocbde1165e4e var4) {
                  throw var4;
               }

               var3 = -1731651617 ^ 286741964;
               if (var2 == 0) {
                  continue;
               }
            }

            var10000 = -481001192 ^ 286741964;
         }

         var3 = var10000;
      }
   }

   static boolean ƅ(C08PacketPlayerBlockPlacement param0, oc847503a8ab param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 2
      // 04: aload 0
      // 05: ifnull 4e
      // 08: aload 1
      // 09: iload 2
      // 0a: ifne 19
      // 0d: goto 11
      // 10: athrow
      // 11: ifnull 4e
      // 14: goto 18
      // 17: athrow
      // 18: aload 1
      // 19: getfield x/oc847503a8ab.ß Lx/oc1a421bd3db;
      // 1c: getfield x/oc1a421bd3db.ʚ Lnet/minecraft/util/BlockPos;
      // 1f: aload 0
      // 20: invokevirtual net/minecraft/network/play/client/C08PacketPlayerBlockPlacement.getPosition ()Lnet/minecraft/util/BlockPos;
      // 23: invokevirtual net/minecraft/util/BlockPos.equals (Ljava/lang/Object;)Z
      // 26: iload 2
      // 27: ifne 53
      // 2a: ifeq 4e
      // 2d: goto 31
      // 30: athrow
      // 31: aload 1
      // 32: iload 2
      // 33: ifne 55
      // 36: goto 3a
      // 39: athrow
      // 3a: getfield x/oc847503a8ab.ß Lx/oc1a421bd3db;
      // 3d: getfield x/oc1a421bd3db.Փ Lnet/minecraft/util/EnumFacing;
      // 40: invokevirtual net/minecraft/util/EnumFacing.getIndex ()I
      // 43: aload 0
      // 44: invokevirtual net/minecraft/network/play/client/C08PacketPlayerBlockPlacement.getPlacedBlockDirection ()I
      // 47: if_icmpeq 54
      // 4a: goto 4e
      // 4d: athrow
      // 4e: bipush 0
      // 4f: goto 53
      // 52: athrow
      // 53: ireturn
      // 54: aload 1
      // 55: getfield x/oc847503a8ab.ģ Lnet/minecraft/util/Vec3;
      // 58: astore 3
      // 59: aload 3
      // 5a: getfield net/minecraft/util/Vec3.xCoord D
      // 5d: aload 1
      // 5e: getfield x/oc847503a8ab.ß Lx/oc1a421bd3db;
      // 61: getfield x/oc1a421bd3db.ʚ Lnet/minecraft/util/BlockPos;
      // 64: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 67: i2d
      // 68: dsub
      // 69: d2f
      // 6a: fstore 4
      // 6c: aload 3
      // 6d: getfield net/minecraft/util/Vec3.yCoord D
      // 70: aload 1
      // 71: getfield x/oc847503a8ab.ß Lx/oc1a421bd3db;
      // 74: getfield x/oc1a421bd3db.ʚ Lnet/minecraft/util/BlockPos;
      // 77: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 7a: i2d
      // 7b: dsub
      // 7c: d2f
      // 7d: fstore 5
      // 7f: aload 3
      // 80: getfield net/minecraft/util/Vec3.zCoord D
      // 83: aload 1
      // 84: getfield x/oc847503a8ab.ß Lx/oc1a421bd3db;
      // 87: getfield x/oc1a421bd3db.ʚ Lnet/minecraft/util/BlockPos;
      // 8a: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 8d: i2d
      // 8e: dsub
      // 8f: d2f
      // 90: fstore 6
      // 92: aload 0
      // 93: invokevirtual net/minecraft/network/play/client/C08PacketPlayerBlockPlacement.getPlacedBlockOffsetX ()F
      // 96: fload 4
      // 98: fsub
      // 99: iload 2
      // 9a: ifne c1
      // 9d: invokestatic java/lang/Math.abs (F)F
      // a0: ldc_w 1.0E-4
      // a3: fcmpg
      // a4: ifge e9
      // a7: goto ab
      // aa: athrow
      // ab: aload 0
      // ac: invokevirtual net/minecraft/network/play/client/C08PacketPlayerBlockPlacement.getPlacedBlockOffsetY ()F
      // af: fload 5
      // b1: iload 2
      // b2: ifne d9
      // b5: goto b9
      // b8: athrow
      // b9: fsub
      // ba: invokestatic java/lang/Math.abs (F)F
      // bd: goto c1
      // c0: athrow
      // c1: ldc_w 1.0E-4
      // c4: fcmpg
      // c5: ifge e9
      // c8: aload 0
      // c9: invokevirtual net/minecraft/network/play/client/C08PacketPlayerBlockPlacement.getPlacedBlockOffsetZ ()F
      // cc: fload 6
      // ce: fsub
      // cf: invokestatic java/lang/Math.abs (F)F
      // d2: ldc_w 1.0E-4
      // d5: goto d9
      // d8: athrow
      // d9: fcmpg
      // da: iload 2
      // db: ifne e6
      // de: ifge e9
      // e1: goto e5
      // e4: athrow
      // e5: bipush 1
      // e6: goto ea
      // e9: bipush 0
      // ea: ireturn
   }

   private boolean ӛ(oc1a421bd3db param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: istore 2
      // 004: aload 1
      // 005: ifnull 05d
      // 008: aload 0
      // 009: getfield x/ocbce5ea28a3.ʐ I
      // 00c: iload 2
      // 00d: ifne 05e
      // 010: goto 014
      // 013: athrow
      // 014: ldc_w -921242915
      // 017: ldc_w 1226240733
      // 01a: ixor
      // 01b: if_icmpeq 05d
      // 01e: goto 022
      // 021: athrow
      // 022: aload 1
      // 023: getfield x/oc1a421bd3db.ʚ Lnet/minecraft/util/BlockPos;
      // 026: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 029: iload 2
      // 02a: ifne 05e
      // 02d: goto 031
      // 030: athrow
      // 031: aload 0
      // 032: getfield x/ocbce5ea28a3.ʐ I
      // 035: if_icmpne 05d
      // 038: goto 03c
      // 03b: athrow
      // 03c: aload 1
      // 03d: getfield x/oc1a421bd3db.ʚ Lnet/minecraft/util/BlockPos;
      // 040: aload 1
      // 041: getfield x/oc1a421bd3db.Փ Lnet/minecraft/util/EnumFacing;
      // 044: invokevirtual net/minecraft/util/BlockPos.offset (Lnet/minecraft/util/EnumFacing;)Lnet/minecraft/util/BlockPos;
      // 047: aload 1
      // 048: getfield x/oc1a421bd3db.Շ Lnet/minecraft/util/BlockPos;
      // 04b: invokevirtual net/minecraft/util/BlockPos.equals (Ljava/lang/Object;)Z
      // 04e: iload 2
      // 04f: ifne 063
      // 052: goto 056
      // 055: athrow
      // 056: ifne 05f
      // 059: goto 05d
      // 05c: athrow
      // 05d: bipush 0
      // 05e: ireturn
      // 05f: aload 0
      // 060: invokevirtual x/ocbce5ea28a3.ӎ ()Z
      // 063: ifeq 0a1
      // 066: aload 1
      // 067: iload 2
      // 068: ifne 081
      // 06b: goto 06f
      // 06e: athrow
      // 06f: getfield x/oc1a421bd3db.Փ Lnet/minecraft/util/EnumFacing;
      // 072: getstatic net/minecraft/util/EnumFacing.UP Lnet/minecraft/util/EnumFacing;
      // 075: if_acmpne 09d
      // 078: goto 07c
      // 07b: athrow
      // 07c: aload 1
      // 07d: goto 081
      // 080: athrow
      // 081: getfield x/oc1a421bd3db.Շ Lnet/minecraft/util/BlockPos;
      // 084: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 087: iload 2
      // 088: ifne 09e
      // 08b: aload 0
      // 08c: getfield x/ocbce5ea28a3.ʐ I
      // 08f: bipush 1
      // 090: iadd
      // 091: if_icmpne 09d
      // 094: goto 098
      // 097: athrow
      // 098: bipush 1
      // 099: goto 0d9
      // 09c: athrow
      // 09d: bipush 0
      // 09e: goto 0d9
      // 0a1: aload 1
      // 0a2: iload 2
      // 0a3: ifne 0bb
      // 0a6: getfield x/oc1a421bd3db.Փ Lnet/minecraft/util/EnumFacing;
      // 0a9: invokevirtual net/minecraft/util/EnumFacing.getAxis ()Lnet/minecraft/util/EnumFacing$Axis;
      // 0ac: getstatic net/minecraft/util/EnumFacing$Axis.Y Lnet/minecraft/util/EnumFacing$Axis;
      // 0af: if_acmpeq 0d8
      // 0b2: goto 0b6
      // 0b5: athrow
      // 0b6: aload 1
      // 0b7: goto 0bb
      // 0ba: athrow
      // 0bb: getfield x/oc1a421bd3db.Շ Lnet/minecraft/util/BlockPos;
      // 0be: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 0c1: iload 2
      // 0c2: ifne 0d5
      // 0c5: aload 0
      // 0c6: getfield x/ocbce5ea28a3.ʐ I
      // 0c9: if_icmpne 0d8
      // 0cc: goto 0d0
      // 0cf: athrow
      // 0d0: bipush 1
      // 0d1: goto 0d5
      // 0d4: athrow
      // 0d5: goto 0d9
      // 0d8: bipush 0
      // 0d9: istore 3
      // 0da: iload 3
      // 0db: iload 2
      // 0dc: ifne 0fa
      // 0df: ifeq 127
      // 0e2: goto 0e6
      // 0e5: athrow
      // 0e6: aload 0
      // 0e7: aload 1
      // 0e8: iload 2
      // 0e9: ifne 10b
      // 0ec: goto 0f0
      // 0ef: athrow
      // 0f0: getfield x/oc1a421bd3db.ʚ Lnet/minecraft/util/BlockPos;
      // 0f3: invokevirtual x/ocbce5ea28a3.Ζ (Lnet/minecraft/util/BlockPos;)Z
      // 0f6: goto 0fa
      // 0f9: athrow
      // 0fa: ifeq 127
      // 0fd: aload 0
      // 0fe: iload 2
      // 0ff: ifne 119
      // 102: goto 106
      // 105: athrow
      // 106: aload 1
      // 107: goto 10b
      // 10a: athrow
      // 10b: getfield x/oc1a421bd3db.Շ Lnet/minecraft/util/BlockPos;
      // 10e: invokevirtual x/ocbce5ea28a3.с (Lnet/minecraft/util/BlockPos;)Z
      // 111: ifeq 127
      // 114: aload 0
      // 115: goto 119
      // 118: athrow
      // 119: getfield x/ocbce5ea28a3.Ǚ Lx/oc668fce0dbf;
      // 11c: invokevirtual x/oc668fce0dbf.ҵ ()Lnet/minecraft/item/ItemBlock;
      // 11f: ifnull 127
      // 122: bipush 1
      // 123: goto 128
      // 126: athrow
      // 127: bipush 0
      // 128: ireturn
   }

   private boolean р(oc1a421bd3db var1) {
      int var2 = oc84f20a0bc5.ė;
      int var3 = 492238160 ^ 1113504919;

      while (true) {
         switch (var3) {
            case -1032824824:
               int var8;
               label86: {
                  label85: {
                     try {
                        var8 = var1.ʚ.offset(var1.Փ).equals(var1.Շ);
                        if (var2 != 0) {
                           break label86;
                        }

                        if (var8 == 0) {
                           break label85;
                        }
                     } catch (ocbde1165e4e var6) {
                        throw var6;
                     }

                     var3 = 895512298 ^ 1113504919;
                     if (var2 == 0) {
                        break;
                     }
                  }

                  var8 = 210830171 ^ 1113504919;
               }

               var3 = var8;
               if (var2 == 0) {
                  break;
               }
            case -1377541840:
               return true;
            case 1280536716:
               if (var1.Փ == EnumFacing.UP) {
                  var3 = -2144410465 ^ 1113504919;
                  if (var2 == 0) {
                     break;
                  }
               }

               var3 = 210830171 ^ 1113504919;
               if (var2 == 0) {
                  break;
               }
            case 1594378695:
               if (var1 != null) {
                  var3 = 1144331093 ^ 1113504919;
                  if (var2 == 0) {
                     break;
                  }
               }

               var3 = 210830171 ^ 1113504919;
               if (var2 == 0) {
                  break;
               }
            case 73015083:
               int var7;
               label77: {
                  label76: {
                     try {
                        var7 = this.ӎ();
                        if (var2 != 0) {
                           break label77;
                        }

                        if (var7 == 0) {
                           break label76;
                        }
                     } catch (ocbde1165e4e var5) {
                        throw var5;
                     }

                     var3 = 235785243 ^ 1113504919;
                     if (var2 == 0) {
                        break;
                     }
                  }

                  var7 = 210830171 ^ 1113504919;
               }

               var3 = var7;
               if (var2 == 0) {
                  break;
               }
            case 107718594:
               if (var1.Փ.getAxis() == Axis.Y) {
                  var3 = 1174709180 ^ 1113504919;
                  if (var2 == 0) {
                     break;
                  }
               }

               var3 = -2144410465 ^ 1113504919;
               break;
            case 2000605821:
               int var10000;
               label68: {
                  label67: {
                     try {
                        var10000 = this.Ζ(var1.ʚ);
                        if (var2 != 0) {
                           break label68;
                        }

                        if (var10000 == 0) {
                           break label67;
                        }
                     } catch (ocbde1165e4e var4) {
                        throw var4;
                     }

                     var3 = -272966233 ^ 1113504919;
                     if (var2 == 0) {
                        break;
                     }
                  }

                  var10000 = 210830171 ^ 1113504919;
               }

               var3 = var10000;
               if (var2 == 0) {
                  break;
               }
            case 1322237900:
               return false;
            default:
               throw null;
         }
      }
   }

   private boolean Ζ(BlockPos var1) {
      IBlockState var3 = null;
      int var4 = -1159581504 ^ -814565250;
      int var2 = oc84f20a0bc5.ė;

      while (true) {
         switch (var4) {
            case -1482794095:
               if (this.Ѭ.theWorld == null) {
                  var4 = -1528921862 ^ -814565250;
                  if (var2 == 0) {
                     break;
                  }
               }

               var4 = -315165302 ^ -814565250;
               if (var2 == 0) {
                  break;
               }
            case -357172046:
               int var8;
               label75: {
                  label74: {
                     try {
                        var8 = var3.getBlock().isFullCube();
                        if (var2 != 0) {
                           break label75;
                        }

                        if (var8 == 0) {
                           break label74;
                        }
                     } catch (ocbde1165e4e var6) {
                        throw var6;
                     }

                     var4 = 750835895 ^ -814565250;
                     if (var2 == 0) {
                        break;
                     }
                  }

                  var8 = 756148447 ^ -814565250;
               }

               var4 = var8;
               if (var2 == 0) {
                  break;
               }

               return false;
            case -496807775:
               return false;
            case -474849079:
               return true;
            case 1806448772:
               return false;
            case 1890498128:
               return true;
            case 1972406462:
               if (var1 != null) {
                  var4 = 1760355311 ^ -814565250;
                  if (var2 == 0) {
                     break;
                  }
               }

               var4 = -1528921862 ^ -814565250;
               if (var2 == 0) {
                  break;
               }
            case 574901748:
               int var10000;
               label89: {
                  label88: {
                     try {
                        var10000 = this.Ñ.contains(var1);
                        if (var2 != 0) {
                           break label89;
                        }

                        if (var10000 == 0) {
                           break label88;
                        }
                     } catch (ocbde1165e4e var7) {
                        throw var7;
                     }

                     var4 = -1076097490 ^ -814565250;
                     if (var2 == 0) {
                        break;
                     }
                  }

                  var10000 = -282285224 ^ -814565250;
               }

               var4 = var10000;
               if (var2 == 0) {
                  break;
               }
            case 543036198:
               var3 = this.Ѭ.theWorld.getBlockState(var1);

               label65: {
                  label64: {
                     try {
                        if (var2 != 0) {
                           break label65;
                        }

                        if (var3.getBlock() == Blocks.air) {
                           break label64;
                        }
                     } catch (ocbde1165e4e var5) {
                        throw var5;
                     }

                     var4 = 633816268 ^ -814565250;
                     if (var2 == 0) {
                        break;
                     }
                  }

                  var4 = 756148447 ^ -814565250;
               }

               if (var2 == 0) {
                  break;
               }

               return true;
            default:
               throw null;
         }
      }
   }

   private boolean с(BlockPos var1) {
      IBlockState var3 = null;
      int var4 = 1903301409 ^ -132151668;
      int var2 = oc84f20a0bc5.ė;

      while (true) {
         label106:
         while (true) {
            switch (var4) {
               case -1989306963:
                  break label106;
               case -1368248070:
                  return false;
               case -331330889:
                  break;
               case 408421092:
                  return true;
               case 528154307:
                  return false;
               case 576365311:
                  return false;
               case 1373446471:
                  if (this.Ѭ.theWorld == null) {
                     var4 = -633002893 ^ -132151668;
                     if (var2 == 0) {
                        continue;
                     }
                  }

                  var4 = 341822523 ^ -132151668;
                  if (var2 != 0) {
                     return false;
                  }
                  continue;
               case 1753658413:
                  int var10000;
                  label91: {
                     label90: {
                        try {
                           var10000 = var3.getBlock().isReplaceable(this.Ѭ.theWorld, var1);
                           if (var2 != 0) {
                              break label91;
                           }

                           if (var10000 == 0) {
                              break label90;
                           }
                        } catch (ocbde1165e4e var7) {
                           throw var7;
                        }

                        var4 = -532183960 ^ -132151668;
                        if (var2 == 0) {
                           continue;
                        }
                     }

                     var10000 = 1450030710 ^ -132151668;
                  }

                  var4 = var10000;
                  if (var2 == 0) {
                     continue;
                  }
               case 355610888:
                  var3 = this.Ѭ.theWorld.getBlockState(var1);

                  label79: {
                     label78: {
                        try {
                           if (var2 != 0) {
                              break label79;
                           }

                           if (var3.getBlock() == Blocks.air) {
                              break label78;
                           }
                        } catch (ocbde1165e4e var6) {
                           throw var6;
                        }

                        var4 = -1869008223 ^ -132151668;
                        if (var2 == 0) {
                           continue;
                        }
                     }

                     var4 = -532183960 ^ -132151668;
                  }

                  if (var2 == 0) {
                     continue;
                  }
                  break;
               default:
                  throw null;
            }

            int var8;
            label64: {
               label63: {
                  try {
                     var8 = this.Ñ.contains(var1);
                     if (var2 != 0) {
                        break label64;
                     }

                     if (var8 == 0) {
                        break label63;
                     }
                  } catch (ocbde1165e4e var5) {
                     throw var5;
                  }

                  var4 = -412780465 ^ -132151668;
                  if (var2 == 0) {
                     continue;
                  }
               }

               var8 = -315771004 ^ -132151668;
            }

            var4 = var8;
            if (var2 != 0) {
               break;
            }
         }

         if (var1 != null) {
            var4 = -1446860853 ^ -132151668;
            if (var2 == 0) {
               continue;
            }
         }

         var4 = -633002893 ^ -132151668;
      }
   }

   private BlockPos Ę(EntityPlayerSP var1) {
      int var10000 = oc84f20a0bc5.ė;
      AxisAlignedBB var3 = var1.getEntityBoundingBox();
      int var4 = MathHelper.floor_double(var3.minY - 1.0E-4);
      int var5 = MathHelper.floor_double(var3.minX + 1.0E-4);
      int var6 = MathHelper.floor_double(var3.maxX - 1.0E-4);
      int var2 = var10000;
      int var7 = MathHelper.floor_double(var3.minZ + 1.0E-4);
      int var8 = MathHelper.floor_double(var3.maxZ - 1.0E-4);
      BlockPos var9 = null;
      double var10 = 0.0;
      int var12 = var5;

      while (var12 <= var6) {
         int var13 = var7;

         while (true) {
            if (var13 <= var8) {
               if (var2 != 0) {
                  break;
               }

               BlockPos var14 = new BlockPos(var12, var4, var13);

               label52: {
                  label66: {
                     try {
                        if (!this.Ζ(var14) && var2 == 0) {
                           break label66;
                        }
                     } catch (ocbde1165e4e var18) {
                        throw var18;
                     }

                     double var15 = ϡ(var3, var14);

                     try {
                        if (var2 != 0) {
                           break label52;
                        }

                        if (!(var15 > var10)) {
                           break label66;
                        }
                     } catch (ocbde1165e4e var17) {
                        throw var17;
                     }

                     var10 = var15;
                     var9 = var14;
                  }

                  var13++;
               }

               if (var2 == 0) {
                  continue;
               }
            }

            var12++;
            break;
         }

         if (var2 != 0) {
            break;
         }
      }

      return var9;
   }

   private boolean Ǘ(EntityPlayerSP var1, oceb7a9b9a85 var2) {
      float var4 = 0.0F;
      double var5 = 0.0;
      double var7 = 0.0;
      Object var9 = null;
      Object var10 = null;
      int var11 = 1999373203 ^ 1497419349;
      int var3 = oc84f20a0bc5.ė;

      while (true) {
         switch (var11) {
            case 1679390277:
               var4 = this.Ӽ(var1, var2);
               var11 = 1524241121 ^ 1497419349;
               if (var3 == 0) {
                  break;
               }
            case -2043035393:
               var4 = var1.jumpMovementFactor;
               var11 = 1524241121 ^ 1497419349;
               if (var3 == 0) {
                  break;
               }
            case 778882502:
               int var10000;
               label31: {
                  label30: {
                     try {
                        var10000 = var1.onGround;
                        if (var3 != 0) {
                           break label31;
                        }

                        if (!var1.onGround) {
                           break label30;
                        }
                     } catch (ocbde1165e4e var12) {
                        throw var12;
                     }

                     var11 = 1029290000 ^ 1497419349;
                     if (var3 == 0) {
                        break;
                     }
                  }

                  var10000 = -545714518 ^ 1497419349;
               }

               var11 = var10000;
               if (var3 == 0) {
                  break;
               }
            case 60480692:
               var5 = var1.motionX;
               var7 = var1.motionZ;
               var9 = ù(0.0, 0.0, var1.posY, var5, var1.motionY, var7, var2, var4, Double.NEGATIVE_INFINITY, 1);
               var10 = var1.getEntityBoundingBox().offset(((oc81c78bf988)var9).ơ, -0.5, ((oc81c78bf988)var9).о);
               return this.Ѭ.theWorld.getCollidingBoundingBoxes(var1, (AxisAlignedBB)var10).isEmpty();
            default:
               throw null;
         }
      }
   }

   private float Ӽ(EntityPlayerSP param1, oceb7a9b9a85 param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: new net/minecraft/util/BlockPos
      // 03: dup
      // 04: aload 1
      // 05: getfield net/minecraft/client/entity/EntityPlayerSP.posX D
      // 08: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 0b: aload 1
      // 0c: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getEntityBoundingBox ()Lnet/minecraft/util/AxisAlignedBB;
      // 0f: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 12: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 15: bipush 1
      // 16: isub
      // 17: aload 1
      // 18: getfield net/minecraft/client/entity/EntityPlayerSP.posZ D
      // 1b: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 1e: invokespecial net/minecraft/util/BlockPos.<init> (III)V
      // 21: astore 4
      // 23: aload 1
      // 24: getfield net/minecraft/client/entity/EntityPlayerSP.worldObj Lnet/minecraft/world/World;
      // 27: aload 4
      // 29: invokevirtual net/minecraft/world/World.getBlockState (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // 2c: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 31: getfield net/minecraft/block/Block.slipperiness F
      // 34: ldc_w 0.91
      // 37: fmul
      // 38: fstore 5
      // 3a: getstatic x/oc84f20a0bc5.ė I
      // 3d: ldc_w 0.16277136
      // 40: fload 5
      // 42: fload 5
      // 44: fmul
      // 45: fload 5
      // 47: fmul
      // 48: fdiv
      // 49: fstore 6
      // 4b: aload 1
      // 4c: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getAIMoveSpeed ()F
      // 4f: fstore 7
      // 51: istore 3
      // 52: aload 1
      // 53: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isSprinting ()Z
      // 56: iload 3
      // 57: ifne 75
      // 5a: ifne 8b
      // 5d: goto 61
      // 60: athrow
      // 61: aload 2
      // 62: getfield x/oceb7a9b9a85.λ F
      // 65: iload 3
      // 66: ifne 90
      // 69: goto 6d
      // 6c: athrow
      // 6d: ldc_w 0.8
      // 70: fcmpl
      // 71: goto 75
      // 74: athrow
      // 75: iflt 8b
      // 78: aload 2
      // 79: getfield x/oceb7a9b9a85.Ú Z
      // 7c: ifne 8b
      // 7f: goto 83
      // 82: athrow
      // 83: fload 7
      // 85: ldc_w 1.3
      // 88: fmul
      // 89: fstore 7
      // 8b: fload 7
      // 8d: fload 6
      // 8f: fmul
      // 90: freturn
   }

   private void ѱ(oc7ebeda7e63 param1, EntityPlayerSP param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 3
      // 04: aload 0
      // 05: iload 3
      // 06: ifne 4c
      // 09: getfield x/ocbce5ea28a3.ʡ Lx/oc791986a759;
      // 0c: ifnull 47
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: iload 3
      // 15: ifne 4c
      // 18: goto 1c
      // 1b: athrow
      // 1c: getfield x/ocbce5ea28a3.ʡ Lx/oc791986a759;
      // 1f: getfield x/oc791986a759.ŕ Z
      // 22: ifeq 47
      // 25: goto 29
      // 28: athrow
      // 29: aload 0
      // 2a: aload 1
      // 2b: aload 0
      // 2c: getfield x/ocbce5ea28a3.ʡ Lx/oc791986a759;
      // 2f: getfield x/oc791986a759.Ά F
      // 32: aload 0
      // 33: getfield x/ocbce5ea28a3.ʡ Lx/oc791986a759;
      // 36: getfield x/oc791986a759.ţ F
      // 39: invokestatic x/oc3458eda443.ƹ (FF)Lx/oc3458eda443;
      // 3c: invokevirtual x/ocbce5ea28a3.Ƨ (Lx/oc7ebeda7e63;Lx/oc3458eda443;)V
      // 3f: iload 3
      // 40: ifeq 5b
      // 43: goto 47
      // 46: athrow
      // 47: aload 0
      // 48: goto 4c
      // 4b: athrow
      // 4c: aload 1
      // 4d: aload 2
      // 4e: getfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 51: aload 2
      // 52: getfield net/minecraft/client/entity/EntityPlayerSP.rotationPitch F
      // 55: invokestatic x/oc3458eda443.ƹ (FF)Lx/oc3458eda443;
      // 58: invokevirtual x/ocbce5ea28a3.Ƨ (Lx/oc7ebeda7e63;Lx/oc3458eda443;)V
      // 5b: return
   }

   private void ʑ(oc7ebeda7e63 param1, EntityPlayerSP param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 3
      // 04: aload 0
      // 05: iload 3
      // 06: ifne 1a
      // 09: getfield x/ocbce5ea28a3.Լ Z
      // 0c: ifne 19
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: invokevirtual x/ocbce5ea28a3.º ()V
      // 17: return
      // 18: athrow
      // 19: aload 0
      // 1a: aload 2
      // 1b: invokevirtual x/ocbce5ea28a3.ԥ (Lnet/minecraft/client/entity/EntityPlayerSP;)F
      // 1e: fstore 4
      // 20: aload 0
      // 21: aload 2
      // 22: invokevirtual x/ocbce5ea28a3.Ľ (Lnet/minecraft/client/entity/EntityPlayerSP;)F
      // 25: fstore 5
      // 27: aload 0
      // 28: getfield x/ocbce5ea28a3.ɞ F
      // 2b: fload 4
      // 2d: invokestatic x/ocbce5ea28a3.Ԇ (FF)F
      // 30: fstore 6
      // 32: aload 0
      // 33: getfield x/ocbce5ea28a3.Ӑ F
      // 36: fstore 7
      // 38: fload 4
      // 3a: fload 5
      // 3c: fload 6
      // 3e: fload 7
      // 40: aload 0
      // 41: invokevirtual x/ocbce5ea28a3.Щ ()F
      // 44: invokestatic x/ocbce5ea28a3.Ħ (FFFFF)Lx/oc3458eda443;
      // 47: astore 8
      // 49: aload 0
      // 4a: aload 1
      // 4b: aload 8
      // 4d: invokevirtual x/ocbce5ea28a3.Ƨ (Lx/oc7ebeda7e63;Lx/oc3458eda443;)V
      // 50: aload 0
      // 51: aload 8
      // 53: fload 6
      // 55: fload 7
      // 57: aload 0
      // 58: invokevirtual x/ocbce5ea28a3.Щ ()F
      // 5b: invokevirtual x/oc3458eda443.c (FFF)Z
      // 5e: putfield x/ocbce5ea28a3.ʨ Z
      // 61: aload 0
      // 62: getstatic x/oc65fedf8d38.Ό Lx/oc65fedf8d38;
      // 65: putfield x/ocbce5ea28a3.Ѻ Lx/oc65fedf8d38;
      // 68: return
   }

   private void Ƨ(oc7ebeda7e63 var1, oc3458eda443 var2) {
      this.ƫ = var2;
      this.ȹ = var2.ω;
      this.Ƭ = true;
      var1.Ն(360.0F);
      var1.w(360.0F);
      var1.ջ(95.0F);
      var1.љ(false);
      var1.Π(var2.ω);
      var1.Ӿ(var2.խ);
   }

   private float Ӏ(EntityPlayerSP param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 2
      // 04: aload 0
      // 05: iload 2
      // 06: ifne 1a
      // 09: getfield x/ocbce5ea28a3.d Z
      // 0c: ifeq 19
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: getfield x/ocbce5ea28a3.D F
      // 17: freturn
      // 18: athrow
      // 19: aload 0
      // 1a: iload 2
      // 1b: ifne 32
      // 1e: getfield x/ocbce5ea28a3.ƫ Lx/oc3458eda443;
      // 21: ifnull 31
      // 24: goto 28
      // 27: athrow
      // 28: aload 0
      // 29: getfield x/ocbce5ea28a3.ƫ Lx/oc3458eda443;
      // 2c: getfield x/oc3458eda443.ω F
      // 2f: freturn
      // 30: athrow
      // 31: aload 0
      // 32: iload 2
      // 33: ifne 45
      // 36: getfield x/ocbce5ea28a3.ʡ Lx/oc791986a759;
      // 39: ifnull 62
      // 3c: goto 40
      // 3f: athrow
      // 40: aload 0
      // 41: goto 45
      // 44: athrow
      // 45: iload 2
      // 46: ifne 5b
      // 49: getfield x/ocbce5ea28a3.ʡ Lx/oc791986a759;
      // 4c: getfield x/oc791986a759.ŕ Z
      // 4f: ifeq 62
      // 52: goto 56
      // 55: athrow
      // 56: aload 0
      // 57: goto 5b
      // 5a: athrow
      // 5b: getfield x/ocbce5ea28a3.ʡ Lx/oc791986a759;
      // 5e: getfield x/oc791986a759.Ά F
      // 61: freturn
      // 62: aload 1
      // 63: iload 2
      // 64: ifne 7a
      // 67: ifnonnull 79
      // 6a: goto 6e
      // 6d: athrow
      // 6e: aload 0
      // 6f: getfield x/ocbce5ea28a3.ƒ Lx/oc7beea7ccff;
      // 72: invokevirtual x/oc7beea7ccff.ɥ ()F
      // 75: goto 7d
      // 78: athrow
      // 79: aload 1
      // 7a: getfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 7d: freturn
   }

   private void φ(EntityPlayerSP param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: invokestatic x/ocbb165642ef.ʨ ()Lx/ocbb165642ef;
      // 006: invokevirtual x/ocbb165642ef.ɦ ()Ljava/lang/Float;
      // 009: astore 3
      // 00a: invokestatic x/ocbb165642ef.ʨ ()Lx/ocbb165642ef;
      // 00d: invokevirtual x/ocbb165642ef.ȫ ()Ljava/lang/Float;
      // 010: astore 4
      // 012: istore 2
      // 013: aload 0
      // 014: aload 3
      // 015: iload 2
      // 016: ifne 021
      // 019: ifnull 03d
      // 01c: goto 020
      // 01f: athrow
      // 020: aload 3
      // 021: iload 2
      // 022: ifne 037
      // 025: invokevirtual java/lang/Float.floatValue ()F
      // 028: invokestatic x/ocbce5ea28a3.С (F)Z
      // 02b: ifeq 03d
      // 02e: goto 032
      // 031: athrow
      // 032: aload 3
      // 033: goto 037
      // 036: athrow
      // 037: invokevirtual java/lang/Float.floatValue ()F
      // 03a: goto 041
      // 03d: aload 0
      // 03e: getfield x/ocbce5ea28a3.ȹ F
      // 041: putfield x/ocbce5ea28a3.D F
      // 044: aload 0
      // 045: aload 4
      // 047: iload 2
      // 048: ifne 054
      // 04b: ifnull 071
      // 04e: goto 052
      // 051: athrow
      // 052: aload 4
      // 054: iload 2
      // 055: ifne 06b
      // 058: invokevirtual java/lang/Float.floatValue ()F
      // 05b: invokestatic x/ocbce5ea28a3.С (F)Z
      // 05e: ifeq 071
      // 061: goto 065
      // 064: athrow
      // 065: aload 4
      // 067: goto 06b
      // 06a: athrow
      // 06b: invokevirtual java/lang/Float.floatValue ()F
      // 06e: goto 075
      // 071: aload 0
      // 072: getfield x/ocbce5ea28a3.я F
      // 075: putfield x/ocbce5ea28a3.ʫ F
      // 078: aload 0
      // 079: iload 2
      // 07a: ifne 0ad
      // 07d: getfield x/ocbce5ea28a3.D F
      // 080: invokestatic x/ocbce5ea28a3.С (F)Z
      // 083: ifne 0ac
      // 086: goto 08a
      // 089: athrow
      // 08a: aload 0
      // 08b: aload 1
      // 08c: iload 2
      // 08d: ifne 09c
      // 090: goto 094
      // 093: athrow
      // 094: ifnull 0a2
      // 097: goto 09b
      // 09a: athrow
      // 09b: aload 1
      // 09c: getfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 09f: goto 0a9
      // 0a2: aload 0
      // 0a3: getfield x/ocbce5ea28a3.ƒ Lx/oc7beea7ccff;
      // 0a6: invokevirtual x/oc7beea7ccff.ɥ ()F
      // 0a9: putfield x/ocbce5ea28a3.D F
      // 0ac: aload 0
      // 0ad: iload 2
      // 0ae: ifne 0fe
      // 0b1: getfield x/ocbce5ea28a3.ʫ F
      // 0b4: invokestatic x/ocbce5ea28a3.С (F)Z
      // 0b7: ifne 0e0
      // 0ba: goto 0be
      // 0bd: athrow
      // 0be: aload 0
      // 0bf: aload 1
      // 0c0: iload 2
      // 0c1: ifne 0d0
      // 0c4: goto 0c8
      // 0c7: athrow
      // 0c8: ifnull 0d6
      // 0cb: goto 0cf
      // 0ce: athrow
      // 0cf: aload 1
      // 0d0: getfield net/minecraft/client/entity/EntityPlayerSP.rotationPitch F
      // 0d3: goto 0dd
      // 0d6: aload 0
      // 0d7: getfield x/ocbce5ea28a3.ƒ Lx/oc7beea7ccff;
      // 0da: invokevirtual x/oc7beea7ccff.k ()F
      // 0dd: putfield x/ocbce5ea28a3.ʫ F
      // 0e0: aload 0
      // 0e1: aload 0
      // 0e2: getfield x/ocbce5ea28a3.ʫ F
      // 0e5: ldc_w -90.0
      // 0e8: ldc 90.0
      // 0ea: invokestatic net/minecraft/util/MathHelper.clamp_float (FFF)F
      // 0ed: putfield x/ocbce5ea28a3.ʫ F
      // 0f0: aload 0
      // 0f1: bipush 1
      // 0f2: putfield x/ocbce5ea28a3.d Z
      // 0f5: aload 0
      // 0f6: aload 0
      // 0f7: getfield x/ocbce5ea28a3.D F
      // 0fa: putfield x/ocbce5ea28a3.ȹ F
      // 0fd: aload 0
      // 0fe: aload 0
      // 0ff: getfield x/ocbce5ea28a3.ʫ F
      // 102: putfield x/ocbce5ea28a3.я F
      // 105: return
   }

   private float ԥ(EntityPlayerSP param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 2
      // 04: aload 0
      // 05: iload 2
      // 06: ifne 18
      // 09: getfield x/ocbce5ea28a3.ʡ Lx/oc791986a759;
      // 0c: ifnull 37
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: goto 18
      // 17: athrow
      // 18: iload 2
      // 19: ifne 2e
      // 1c: getfield x/ocbce5ea28a3.ʡ Lx/oc791986a759;
      // 1f: getfield x/oc791986a759.ŕ Z
      // 22: ifeq 37
      // 25: goto 29
      // 28: athrow
      // 29: aload 0
      // 2a: goto 2e
      // 2d: athrow
      // 2e: getfield x/ocbce5ea28a3.ʡ Lx/oc791986a759;
      // 31: getfield x/oc791986a759.Ά F
      // 34: goto 51
      // 37: aload 1
      // 38: iload 2
      // 39: ifne 44
      // 3c: ifnull 4a
      // 3f: goto 43
      // 42: athrow
      // 43: aload 1
      // 44: getfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 47: goto 51
      // 4a: aload 0
      // 4b: getfield x/ocbce5ea28a3.ƒ Lx/oc7beea7ccff;
      // 4e: invokevirtual x/oc7beea7ccff.ɥ ()F
      // 51: freturn
   }

   private float Ľ(EntityPlayerSP param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 2
      // 04: aload 0
      // 05: iload 2
      // 06: ifne 18
      // 09: getfield x/ocbce5ea28a3.ʡ Lx/oc791986a759;
      // 0c: ifnull 37
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: goto 18
      // 17: athrow
      // 18: iload 2
      // 19: ifne 2e
      // 1c: getfield x/ocbce5ea28a3.ʡ Lx/oc791986a759;
      // 1f: getfield x/oc791986a759.ŕ Z
      // 22: ifeq 37
      // 25: goto 29
      // 28: athrow
      // 29: aload 0
      // 2a: goto 2e
      // 2d: athrow
      // 2e: getfield x/ocbce5ea28a3.ʡ Lx/oc791986a759;
      // 31: getfield x/oc791986a759.ţ F
      // 34: goto 51
      // 37: aload 1
      // 38: iload 2
      // 39: ifne 44
      // 3c: ifnull 4a
      // 3f: goto 43
      // 42: athrow
      // 43: aload 1
      // 44: getfield net/minecraft/client/entity/EntityPlayerSP.rotationPitch F
      // 47: goto 51
      // 4a: aload 0
      // 4b: getfield x/ocbce5ea28a3.ƒ Lx/oc7beea7ccff;
      // 4e: invokevirtual x/oc7beea7ccff.k ()F
      // 51: freturn
   }

   private oceb39b7deb2 ʝ(EntityPlayerSP var1) {
      double var10002;
      double var10003;
      double var10004;
      boolean var10005;
      label16: {
            var10002 = var1.posX;
            var10003 = var1.posY;
            var10004 = var1.posZ;
            if (this.ʡ != null) {
               var10005 = this.ʡ.ռ;
               break label16;
            }
         var10005 = var1.isSneaking();
      }

      return new oceb39b7deb2(var10002, var10003, var10004, var10005);
   }

   private oceb39b7deb2 Τ(EntityPlayerSP var1) {
      return this.Ė(var1, 1);
   }

   private oceb39b7deb2 Ė(EntityPlayerSP param1, int param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 3
      // 04: aload 0
      // 05: iload 3
      // 06: ifne 18
      // 09: getfield x/ocbce5ea28a3.ն Lx/oceb7a9b9a85;
      // 0c: ifnonnull 1d
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: goto 18
      // 17: athrow
      // 18: aload 1
      // 19: invokevirtual x/ocbce5ea28a3.ʝ (Lnet/minecraft/client/entity/EntityPlayerSP;)Lx/oceb39b7deb2;
      // 1c: areturn
      // 1d: dconst_0
      // 1e: dconst_0
      // 1f: aload 1
      // 20: getfield net/minecraft/client/entity/EntityPlayerSP.posY D
      // 23: aload 1
      // 24: getfield net/minecraft/client/entity/EntityPlayerSP.motionX D
      // 27: aload 1
      // 28: getfield net/minecraft/client/entity/EntityPlayerSP.motionY D
      // 2b: aload 1
      // 2c: getfield net/minecraft/client/entity/EntityPlayerSP.motionZ D
      // 2f: aload 0
      // 30: getfield x/ocbce5ea28a3.ն Lx/oceb7a9b9a85;
      // 33: aload 1
      // 34: getfield net/minecraft/client/entity/EntityPlayerSP.jumpMovementFactor F
      // 37: ldc2_w -Infinity
      // 3a: bipush 1
      // 3b: iload 2
      // 3c: invokestatic java/lang/Math.max (II)I
      // 3f: invokestatic x/ocbce5ea28a3.ù (DDDDDDLx/oceb7a9b9a85;FDI)Lx/oc81c78bf988;
      // 42: astore 4
      // 44: new x/oceb39b7deb2
      // 47: dup
      // 48: aload 1
      // 49: getfield net/minecraft/client/entity/EntityPlayerSP.posX D
      // 4c: aload 4
      // 4e: getfield x/oc81c78bf988.ơ D
      // 51: dadd
      // 52: aload 1
      // 53: getfield net/minecraft/client/entity/EntityPlayerSP.posY D
      // 56: aload 4
      // 58: getfield x/oc81c78bf988.ԣ D
      // 5b: dadd
      // 5c: aload 1
      // 5d: getfield net/minecraft/client/entity/EntityPlayerSP.posZ D
      // 60: aload 4
      // 62: getfield x/oc81c78bf988.о D
      // 65: dadd
      // 66: aload 0
      // 67: getfield x/ocbce5ea28a3.ʡ Lx/oc791986a759;
      // 6a: ifnull 78
      // 6d: aload 0
      // 6e: getfield x/ocbce5ea28a3.ʡ Lx/oc791986a759;
      // 71: getfield x/oc791986a759.ռ Z
      // 74: goto 7c
      // 77: athrow
      // 78: aload 1
      // 79: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isSneaking ()Z
      // 7c: invokespecial x/oceb39b7deb2.<init> (DDDZ)V
      // 7f: areturn
   }

   private float Щ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 1
      // 04: aload 0
      // 05: getfield x/ocbce5ea28a3.Ѭ Lnet/minecraft/client/Minecraft;
      // 08: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 0b: ifnonnull 13
      // 0e: ldc_w 0.15
      // 11: freturn
      // 12: athrow
      // 13: invokestatic x/oc75d51ec7eb.Ӌ ()F
      // 16: invokestatic java/lang/Math.abs (F)F
      // 19: fstore 2
      // 1a: fload 2
      // 1b: iload 1
      // 1c: ifne 31
      // 1f: fconst_0
      // 20: fcmpl
      // 21: ifle 4e
      // 24: goto 28
      // 27: athrow
      // 28: fload 2
      // 29: iload 1
      // 2a: ifne 40
      // 2d: goto 31
      // 30: athrow
      // 31: invokestatic java/lang/Float.isNaN (F)Z
      // 34: ifne 4e
      // 37: fload 2
      // 38: iload 1
      // 39: ifne 4b
      // 3c: goto 40
      // 3f: athrow
      // 40: invokestatic java/lang/Float.isInfinite (F)Z
      // 43: ifne 4e
      // 46: fload 2
      // 47: goto 4b
      // 4a: athrow
      // 4b: goto 51
      // 4e: ldc_w 0.15
      // 51: freturn
   }

   private static boolean ӓ(EntityPlayerSP var0, oc791986a759 var1) {
      int var2 = oc84f20a0bc5.ė;
      int var3 = 1363707415 ^ -650493601;

      while (true) {
         label124:
         while (true) {
            switch (var3) {
               case -2005743800:
                  if (var0 != null) {
                     var3 = -521739878 ^ -650493601;
                     if (var2 == 0) {
                        continue;
                     }
                  }

                  var3 = -337328369 ^ -650493601;
                  if (var2 != 0) {
                     return true;
                  }
                  continue;
               case -1624973108:
                  int var9;
                  label107: {
                     label106: {
                        try {
                           double var12;
                           var9 = (var12 = Math.abs(var0.posZ - var1.Ƀ) - 0.4) == 0.0 ? 0 : (var12 < 0.0 ? -1 : 1);
                           if (var2 != 0) {
                              break label107;
                           }

                           if (var9 > 0) {
                              break label106;
                           }
                        } catch (ocbde1165e4e var7) {
                           throw var7;
                        }

                        var3 = 1836589012 ^ -650493601;
                        if (var2 == 0) {
                           continue;
                        }
                     }

                     var9 = -131978317 ^ -650493601;
                  }

                  var3 = var9;
                  if (var2 == 0) {
                     continue;
                  }
               case 961957693:
                  int var10;
                  label95: {
                     label94: {
                        try {
                           double var11;
                           var10 = (var11 = Math.abs(var0.posY - var1.ſ) - 0.4) == 0.0 ? 0 : (var11 < 0.0 ? -1 : 1);
                           if (var2 != 0) {
                              break label95;
                           }

                           if (var10 > 0) {
                              break label94;
                           }
                        } catch (ocbde1165e4e var6) {
                           throw var6;
                        }

                        var3 = 1176412563 ^ -650493601;
                        if (var2 == 0) {
                           continue;
                        }
                     }

                     var10 = -131978317 ^ -650493601;
                  }

                  var3 = var10;
                  if (var2 == 0) {
                     continue;
                  }
                  break;
               case -1413476721:
                  int var10000;
                  label81: {
                     label80: {
                        try {
                           var10000 = var1.Ӎ;
                           if (var2 != 0) {
                              break label81;
                           }

                           if (var1.Ӎ) {
                              break label80;
                           }
                        } catch (ocbde1165e4e var5) {
                           throw var5;
                        }

                        var3 = -337328369 ^ -650493601;
                        if (var2 == 0) {
                           continue;
                        }
                     }

                     var10000 = 754241032 ^ -650493601;
                  }

                  var3 = var10000;
                  if (var2 != 0) {
                     break label124;
                  }
                  continue;
               case -1270718837:
                  return true;
               case -171012265:
                  break label124;
               case 555248364:
                  return false;
               case 853444176:
                  return false;
               case 970760389:
                  break;
               default:
                  throw null;
            }

            if (var1 != null) {
               var3 = 1929007056 ^ -650493601;
               if (var2 == 0) {
                  continue;
               }
            }

            var3 = -337328369 ^ -650493601;
            if (var2 != 0) {
               return false;
            }
         }

         int var8;
         label72: {
            label71: {
               try {
                  double var13;
                  var8 = (var13 = Math.abs(var0.posX - var1.ԉ) - 0.4) == 0.0 ? 0 : (var13 < 0.0 ? -1 : 1);
                  if (var2 != 0) {
                     break label72;
                  }

                  if (var8 > 0) {
                     break label71;
                  }
               } catch (ocbde1165e4e var4) {
                  throw var4;
               }

               var3 = -529789342 ^ -650493601;
               if (var2 == 0) {
                  continue;
               }
            }

            var8 = -131978317 ^ -650493601;
         }

         var3 = var8;
      }
   }

   static boolean D(boolean var0, boolean var1, boolean var2, boolean var3, boolean var4, boolean var5) {
      int var6 = oc84f20a0bc5.ė;

      boolean var10000;
      label86: {
         try {
            var10000 = var0;
            if (var6 != 0) {
               break label86;
            }

            if (!var0) {
               return false;
            }
         } catch (ocbde1165e4e var12) {
            throw var12;
         }

         var10000 = var1;
      }

      label80: {
         try {
            if (var6 != 0) {
               break label80;
            }

            if (!var10000) {
               return false;
            }
         } catch (ocbde1165e4e var11) {
            throw var11;
         }

         var10000 = var2;
      }

      label74: {
         try {
            if (var6 != 0) {
               break label74;
            }

            if (!var10000) {
               return false;
            }
         } catch (ocbde1165e4e var10) {
            throw var10;
         }

         var10000 = var3;
      }

      label68: {
         try {
            if (var6 != 0) {
               break label68;
            }

            if (!var10000) {
               return false;
            }
         } catch (ocbde1165e4e var9) {
            throw var9;
         }

         var10000 = var4;
      }

      label62: {
         try {
            if (var6 != 0) {
               break label62;
            }

            if (!var10000) {
               return false;
            }
         } catch (ocbde1165e4e var8) {
            throw var8;
         }

         var10000 = var5;
      }

      try {
         if (var6 != 0) {
            return var10000;
         }

         if (var10000) {
            return true;
         }
      } catch (ocbde1165e4e var7) {
         throw var7;
      }

      return false;
   }

   static boolean ȸ(boolean var0, boolean var1, boolean var2, boolean var3, boolean var4) {
      int var5 = oc84f20a0bc5.ė;

      boolean var10000;
      label73: {
         try {
            var10000 = var0;
            if (var5 != 0) {
               break label73;
            }

            if (!var0) {
               return false;
            }
         } catch (ocbde1165e4e var10) {
            throw var10;
         }

         var10000 = var1;
      }

      label67: {
         try {
            if (var5 != 0) {
               break label67;
            }

            if (var10000) {
               return false;
            }
         } catch (ocbde1165e4e var9) {
            throw var9;
         }

         var10000 = var2;
      }

      label61: {
         try {
            if (var5 != 0) {
               break label61;
            }

            if (!var10000) {
               return false;
            }
         } catch (ocbde1165e4e var8) {
            throw var8;
         }

         var10000 = var3;
      }

      label55: {
         try {
            if (var5 != 0) {
               break label55;
            }

            if (!var10000) {
               return false;
            }
         } catch (ocbde1165e4e var7) {
            throw var7;
         }

         var10000 = var4;
      }

      try {
         if (var5 != 0) {
            return var10000;
         }

         if (!var10000) {
            return true;
         }
      } catch (ocbde1165e4e var6) {
         throw var6;
      }

      return false;
   }

   private static boolean ή(float var0, float var1) {
      int var2 = oc84f20a0bc5.ė;
      int var3 = -189019215 ^ 1367656988;

      while (true) {
         switch (var3) {
            case -1522597459:
               int var10000;
               label50: {
                  label49: {
                     try {
                        float var8;
                        var10000 = (var8 = Math.abs(var0) - 1.0E-4F) == 0.0F ? 0 : (var8 < 0.0F ? -1 : 1);
                        if (var2 != 0) {
                           break label50;
                        }

                        if (var10000 > 0) {
                           break label49;
                        }
                     } catch (ocbde1165e4e var5) {
                        throw var5;
                     }

                     var3 = -257334017 ^ 1367656988;
                     if (var2 == 0) {
                        break;
                     }
                  }

                  var10000 = 386480133 ^ 1367656988;
               }

               var3 = var10000;
               if (var2 == 0) {
                  break;
               }
            case -1590841629:
               int var6;
               label38: {
                  label37: {
                     try {
                        float var7;
                        var6 = (var7 = Math.abs(var1) - 1.0E-4F) == 0.0F ? 0 : (var7 < 0.0F ? -1 : 1);
                        if (var2 != 0) {
                           break label38;
                        }

                        if (var6 <= 0) {
                           break label37;
                        }
                     } catch (ocbde1165e4e var4) {
                        throw var4;
                     }

                     var3 = 386480133 ^ 1367656988;
                     if (var2 == 0) {
                        break;
                     }
                  }

                  var6 = -1351150661 ^ 1367656988;
               }

               var3 = var6;
               if (var2 == 0) {
                  break;
               }

               return true;
            case -17573465:
               return false;
            case 1183707673:
               return true;
            default:
               throw null;
         }
      }
   }

   static boolean Т(oc65fedf8d38 param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 18
      // 09: getstatic x/oc65fedf8d38.ѻ Lx/oc65fedf8d38;
      // 0c: if_acmpeq 1e
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: goto 18
      // 17: athrow
      // 18: getstatic x/oc65fedf8d38.Ό Lx/oc65fedf8d38;
      // 1b: if_acmpne 23
      // 1e: bipush 1
      // 1f: goto 24
      // 22: athrow
      // 23: bipush 0
      // 24: ireturn
   }

   static oc65fedf8d38 ƴ(oc65fedf8d38 param0, boolean param1, int param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 3
      // 04: iload 1
      // 05: ifeq 18
      // 08: aload 0
      // 09: iload 3
      // 0a: ifne 1c
      // 0d: goto 11
      // 10: athrow
      // 11: ifnonnull 1b
      // 14: goto 18
      // 17: athrow
      // 18: aload 0
      // 19: areturn
      // 1a: athrow
      // 1b: aload 0
      // 1c: iload 3
      // 1d: ifne 30
      // 20: getstatic x/oc65fedf8d38.В Lx/oc65fedf8d38;
      // 23: if_acmpne 2f
      // 26: goto 2a
      // 29: athrow
      // 2a: getstatic x/oc65fedf8d38.Ǯ Lx/oc65fedf8d38;
      // 2d: areturn
      // 2e: athrow
      // 2f: aload 0
      // 30: iload 3
      // 31: ifne 4d
      // 34: getstatic x/oc65fedf8d38.И Lx/oc65fedf8d38;
      // 37: if_acmpne 4c
      // 3a: goto 3e
      // 3d: athrow
      // 3e: iload 2
      // 3f: bipush 1
      // 40: if_icmplt 4c
      // 43: goto 47
      // 46: athrow
      // 47: getstatic x/oc65fedf8d38.ė Lx/oc65fedf8d38;
      // 4a: areturn
      // 4b: athrow
      // 4c: aload 0
      // 4d: areturn
   }

   static oc65fedf8d38 ƌ(oc23ff80be39 var0) {
      return oc65fedf8d38.В;
   }

   static boolean ł(oc7b822110db param0, BlockPos param1, double param2, double param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 6
      // 05: aload 0
      // 06: ifnull 4d
      // 09: aload 1
      // 0a: iload 6
      // 0c: ifne 1b
      // 0f: goto 13
      // 12: athrow
      // 13: ifnull 4d
      // 16: goto 1a
      // 19: athrow
      // 1a: aload 1
      // 1b: aload 0
      // 1c: invokevirtual x/oc7b822110db.Ȍ ()Lnet/minecraft/util/BlockPos;
      // 1f: invokevirtual net/minecraft/util/BlockPos.equals (Ljava/lang/Object;)Z
      // 22: iload 6
      // 24: ifne 3d
      // 27: ifeq 4d
      // 2a: goto 2e
      // 2d: athrow
      // 2e: aload 0
      // 2f: aload 1
      // 30: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 33: dload 2
      // 34: dload 4
      // 36: invokevirtual x/oc7b822110db.ț (IDD)Z
      // 39: goto 3d
      // 3c: athrow
      // 3d: iload 6
      // 3f: ifne 4a
      // 42: ifeq 4d
      // 45: goto 49
      // 48: athrow
      // 49: bipush 1
      // 4a: goto 4e
      // 4d: bipush 0
      // 4e: ireturn
   }

   static boolean ɬ(boolean var0, boolean var1, boolean var2) {
      int var3 = oc84f20a0bc5.ė;

      boolean var10000;
      label47: {
         try {
            var10000 = var0;
            if (var3 != 0) {
               break label47;
            }

            if (!var0) {
               return false;
            }
         } catch (ocbde1165e4e var6) {
            throw var6;
         }

         var10000 = var1;
      }

      label41: {
         try {
            if (var3 != 0) {
               break label41;
            }

            if (var10000) {
               return false;
            }
         } catch (ocbde1165e4e var5) {
            throw var5;
         }

         var10000 = var2;
      }

      try {
         if (var3 != 0) {
            return var10000;
         }

         if (var10000) {
            return true;
         }
      } catch (ocbde1165e4e var4) {
         throw var4;
      }

      return false;
   }

   static boolean Ŋ(boolean var0, boolean var1, boolean var2, boolean var3, boolean var4) {
      int var5 = oc84f20a0bc5.ė;

      boolean var10000;
      label73: {
         try {
            var10000 = var0;
            if (var5 != 0) {
               break label73;
            }

            if (!var0) {
               return false;
            }
         } catch (ocbde1165e4e var10) {
            throw var10;
         }

         var10000 = var1;
      }

      label67: {
         try {
            if (var5 != 0) {
               break label67;
            }

            if (!var10000) {
               return false;
            }
         } catch (ocbde1165e4e var9) {
            throw var9;
         }

         var10000 = var2;
      }

      label61: {
         try {
            if (var5 != 0) {
               break label61;
            }

            if (!var10000) {
               return false;
            }
         } catch (ocbde1165e4e var8) {
            throw var8;
         }

         var10000 = var3;
      }

      label55: {
         try {
            if (var5 != 0) {
               break label55;
            }

            if (!var10000) {
               return false;
            }
         } catch (ocbde1165e4e var7) {
            throw var7;
         }

         var10000 = var4;
      }

      try {
         if (var5 != 0) {
            return var10000;
         }

         if (var10000) {
            return true;
         }
      } catch (ocbde1165e4e var6) {
         throw var6;
      }

      return false;
   }

   static boolean Ά(oc847503a8ab param0, oc1a421bd3db param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 2
      // 04: aload 0
      // 05: ifnull 33
      // 08: aload 1
      // 09: iload 2
      // 0a: ifne 20
      // 0d: goto 11
      // 10: athrow
      // 11: ifnull 33
      // 14: goto 18
      // 17: athrow
      // 18: aload 0
      // 19: getfield x/oc847503a8ab.ß Lx/oc1a421bd3db;
      // 1c: goto 20
      // 1f: athrow
      // 20: aload 1
      // 21: invokevirtual x/oc1a421bd3db.equals (Ljava/lang/Object;)Z
      // 24: iload 2
      // 25: ifne 30
      // 28: ifeq 33
      // 2b: goto 2f
      // 2e: athrow
      // 2f: bipush 1
      // 30: goto 34
      // 33: bipush 0
      // 34: ireturn
   }

   static boolean M(long param0, long param2, int param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 5
      // 05: lload 0
      // 06: iload 5
      // 08: ifne 1f
      // 0b: ldc2_w 1634556522707500235
      // 0e: ldc2_w 7588815514147275572
      // 11: lxor
      // 12: lcmp
      // 13: ifeq 52
      // 16: goto 1a
      // 19: athrow
      // 1a: lload 0
      // 1b: goto 1f
      // 1e: athrow
      // 1f: iload 5
      // 21: ifne 3a
      // 24: ldc2_w -1634556522707500236
      // 27: ldc2_w 7588815514147275572
      // 2a: lxor
      // 2b: lcmp
      // 2c: ifeq 52
      // 2f: goto 33
      // 32: athrow
      // 33: lload 2
      // 34: lload 0
      // 35: lsub
      // 36: goto 3a
      // 39: athrow
      // 3a: bipush 0
      // 3b: iload 4
      // 3d: invokestatic java/lang/Math.max (II)I
      // 40: i2l
      // 41: lcmp
      // 42: iload 5
      // 44: ifne 4f
      // 47: ifle 52
      // 4a: goto 4e
      // 4d: athrow
      // 4e: bipush 1
      // 4f: goto 53
      // 52: bipush 0
      // 53: ireturn
   }

   static boolean β(oc65fedf8d38 param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 18
      // 09: getstatic x/oc65fedf8d38.В Lx/oc65fedf8d38;
      // 0c: if_acmpeq 44
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: goto 18
      // 17: athrow
      // 18: iload 1
      // 19: ifne 2b
      // 1c: getstatic x/oc65fedf8d38.Ǯ Lx/oc65fedf8d38;
      // 1f: if_acmpeq 44
      // 22: goto 26
      // 25: athrow
      // 26: aload 0
      // 27: goto 2b
      // 2a: athrow
      // 2b: iload 1
      // 2c: ifne 3e
      // 2f: getstatic x/oc65fedf8d38.И Lx/oc65fedf8d38;
      // 32: if_acmpeq 44
      // 35: goto 39
      // 38: athrow
      // 39: aload 0
      // 3a: goto 3e
      // 3d: athrow
      // 3e: getstatic x/oc65fedf8d38.ė Lx/oc65fedf8d38;
      // 41: if_acmpne 49
      // 44: bipush 1
      // 45: goto 4a
      // 48: athrow
      // 49: bipush 0
      // 4a: ireturn
   }

   static boolean Ж(oc65fedf8d38 var0, boolean var1, int var2, double var3, boolean var5) {
      return Ʉ(var0, var1, var2, var3, var5, true);
   }

   static boolean Ʉ(oc65fedf8d38 param0, boolean param1, int param2, double param3, boolean param5, boolean param6) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 7
      // 05: iload 6
      // 07: iload 7
      // 09: ifne 15
      // 0c: ifeq 8d
      // 0f: goto 13
      // 12: athrow
      // 13: iload 5
      // 15: iload 7
      // 17: ifne 22
      // 1a: ifne 8d
      // 1d: goto 21
      // 20: athrow
      // 21: iload 1
      // 22: iload 7
      // 24: ifne 36
      // 27: ifne 8d
      // 2a: goto 2e
      // 2d: athrow
      // 2e: aload 0
      // 2f: invokestatic x/ocbce5ea28a3.β (Lx/oc65fedf8d38;)Z
      // 32: goto 36
      // 35: athrow
      // 36: iload 7
      // 38: ifne 43
      // 3b: ifeq 8d
      // 3e: goto 42
      // 41: athrow
      // 42: iload 2
      // 43: iload 7
      // 45: ifne 61
      // 48: bipush 1
      // 49: if_icmple 8d
      // 4c: goto 50
      // 4f: athrow
      // 50: dload 3
      // 51: iload 7
      // 53: ifne 6e
      // 56: goto 5a
      // 59: athrow
      // 5a: invokestatic java/lang/Double.isNaN (D)Z
      // 5d: goto 61
      // 60: athrow
      // 61: ifne 8d
      // 64: dload 3
      // 65: iload 7
      // 67: ifne 79
      // 6a: goto 6e
      // 6d: athrow
      // 6e: invokestatic java/lang/Double.isInfinite (D)Z
      // 71: ifne 8d
      // 74: dload 3
      // 75: goto 79
      // 78: athrow
      // 79: ldc2_w 0.17
      // 7c: dcmpg
      // 7d: iload 7
      // 7f: ifne 8a
      // 82: ifgt 8d
      // 85: goto 89
      // 88: athrow
      // 89: bipush 1
      // 8a: goto 8e
      // 8d: bipush 0
      // 8e: ireturn
   }

   private static int u(int var0) {
      return Math.max(1, Math.min(-642033099 ^ -642033089, var0));
   }

   static oc3458eda443 ʟ(float var0, float var1, float var2, float var3, float var4) {
      float var6 = ѫ(var4);
      int var10000 = oc84f20a0bc5.ė;
      float var7 = MathHelper.wrapAngleTo180_float(var2 - var0);
      int var5 = var10000;
      float var8 = oc7beea7ccff.Ŧ(95.0F, var6);
      float var9 = Math.max(-var8, Math.min(var8, var7));
      var9 = ǣ(0.0F, var9, var6);
      float var10 = var0 + var9;
      float var11 = var1;

      label21: {
         label20: {
            try {
               var18 = Math.abs(var7);
               if (var5 != 0) {
                  break label21;
               }

               if (!(var18 <= 95.0F)) {
                  break label20;
               }
            } catch (ocbde1165e4e var15) {
               throw var15;
            }

            float var12 = var3 - var1;
            float var13 = oc7beea7ccff.Ŧ(90.0F, var6);
            float var14 = Math.max(-var13, Math.min(var13, var12));
            var11 = var1 + ǣ(0.0F, var14, var6);
         }

         var18 = MathHelper.clamp_float(var11, -90.0F, 90.0F);
      }

      var11 = var18;
      return new oc3458eda443(var10, var11);
   }

   static oc3458eda443 Ħ(float var0, float var1, float var2, float var3, float var4) {
      float var5 = ѫ(var4);
      float var6 = MathHelper.wrapAngleTo180_float(var2 - var0);
      float var7 = oc7beea7ccff.Ŧ(95.0F, var5);
      float var8 = Math.max(-var7, Math.min(var7, var6));
      float var9 = var0 + ǣ(0.0F, var8, var5);
      float var10 = var3 - var1;
      float var11 = oc7beea7ccff.Ŧ(45.0F, var5);
      float var12 = Math.max(-var11, Math.min(var11, var10));
      float var13 = var1 + ǣ(0.0F, var12, var5);
      return new oc3458eda443(var9, MathHelper.clamp_float(var13, -90.0F, 90.0F));
   }

   static float Ҁ(float var0, float var1, float var2) {
      float var3 = MathHelper.wrapAngleTo180_float(var1 - var0);
      return var0 + Math.round(var3 / ѫ(var2)) * ѫ(var2);
   }

   static float ǣ(float var0, float var1, float var2) {
      float var3 = ѫ(var2);
      return var0 + Math.round((var1 - var0) / var3) * var3;
   }

   private static float ѫ(float param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: fload 0
      // 04: invokestatic java/lang/Math.abs (F)F
      // 07: fstore 2
      // 08: istore 1
      // 09: fload 2
      // 0a: iload 1
      // 0b: ifne 20
      // 0e: fconst_0
      // 0f: fcmpl
      // 10: ifle 3d
      // 13: goto 17
      // 16: athrow
      // 17: fload 2
      // 18: iload 1
      // 19: ifne 2f
      // 1c: goto 20
      // 1f: athrow
      // 20: invokestatic java/lang/Float.isNaN (F)Z
      // 23: ifne 3d
      // 26: fload 2
      // 27: iload 1
      // 28: ifne 3a
      // 2b: goto 2f
      // 2e: athrow
      // 2f: invokestatic java/lang/Float.isInfinite (F)Z
      // 32: ifne 3d
      // 35: fload 2
      // 36: goto 3a
      // 39: athrow
      // 3a: goto 40
      // 3d: ldc_w 0.15
      // 40: freturn
   }

   private static boolean С(float var0) {
      int var1 = oc84f20a0bc5.ė;
      int var2 = -1174497303 ^ -1691991649;

      while (true) {
         switch (var2) {
            case -399284675:
               int var5;
               label47: {
                  label46: {
                     try {
                        var5 = Float.isInfinite(var0);
                        if (var1 != 0) {
                           break label47;
                        }

                        if (var5 != 0) {
                           break label46;
                        }
                     } catch (ocbde1165e4e var4) {
                        throw var4;
                     }

                     var2 = 494349920 ^ -1691991649;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var5 = 1876503515 ^ -1691991649;
               }

               var2 = var5;
               if (var1 == 0) {
                  break;
               }
            case -2041483265:
               return true;
            case 584636022:
               int var10000;
               label38: {
                  label37: {
                     try {
                        var10000 = Float.isNaN(var0);
                        if (var1 != 0) {
                           break label38;
                        }

                        if (var10000 != 0) {
                           break label37;
                        }
                     } catch (ocbde1165e4e var3) {
                        throw var3;
                     }

                     var2 = 1930766242 ^ -1691991649;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var10000 = 1876503515 ^ -1691991649;
               }

               var2 = var10000;
               if (var1 == 0) {
                  break;
               }
            case -184587708:
               return false;
            default:
               throw null;
         }
      }
   }

   static float Ԇ(float var0, float var1) {
      return var0 + 360.0F * Math.round((var1 - var0) / 360.0F);
   }

   static float ʆ(float param0, float param1, float param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 3
      // 04: fload 0
      // 05: iload 3
      // 06: ifne 18
      // 09: invokestatic x/ocbce5ea28a3.С (F)Z
      // 0c: ifeq 1b
      // 0f: goto 13
      // 12: athrow
      // 13: fload 0
      // 14: goto 18
      // 17: athrow
      // 18: goto 1c
      // 1b: fload 2
      // 1c: fstore 4
      // 1e: fload 1
      // 1f: iload 3
      // 20: ifne 32
      // 23: invokestatic x/ocbce5ea28a3.С (F)Z
      // 26: ifeq 35
      // 29: goto 2d
      // 2c: athrow
      // 2d: fload 1
      // 2e: goto 32
      // 31: athrow
      // 32: goto 36
      // 35: fconst_0
      // 36: fstore 5
      // 38: fload 4
      // 3a: ldc_w 180.0
      // 3d: fadd
      // 3e: fload 5
      // 40: fadd
      // 41: fload 2
      // 42: invokestatic x/ocbce5ea28a3.Ԇ (FF)F
      // 45: freturn
   }

   static float ԃ(float var0) {
      float var2 = var0 % 45.0F;
      int var1 = oc84f20a0bc5.ė;

      try {
         if (var1 != 0) {
            return var2;
         }

         if (!(var2 < 0.0F)) {
            return Math.min(var2, 45.0F - var2);
         }
      } catch (ocbde1165e4e var3) {
         throw var3;
      }

      var2 += 45.0F;
      return Math.min(var2, 45.0F - var2);
   }

   static float[] â(float param0, float param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 2
      // 04: fload 0
      // 05: iload 2
      // 06: ifne 23
      // 09: invokestatic x/ocbce5ea28a3.ԃ (F)F
      // 0c: ldc 0.08
      // 0e: fcmpl
      // 0f: iflt 1f
      // 12: goto 16
      // 15: athrow
      // 16: bipush 1
      // 17: newarray 6
      // 19: dup
      // 1a: bipush 0
      // 1b: fload 0
      // 1c: fastore
      // 1d: areturn
      // 1e: athrow
      // 1f: fload 1
      // 20: invokestatic x/ocbce5ea28a3.ѫ (F)F
      // 23: fstore 3
      // 24: bipush 1
      // 25: ldc 0.08
      // 27: fload 3
      // 28: fdiv
      // 29: f2d
      // 2a: invokestatic java/lang/Math.ceil (D)D
      // 2d: d2i
      // 2e: bipush 1
      // 2f: iadd
      // 30: invokestatic java/lang/Math.max (II)I
      // 33: istore 4
      // 35: ldc_w 1525872003
      // 38: ldc_w 1525872000
      // 3b: ixor
      // 3c: newarray 6
      // 3e: dup
      // 3f: bipush 0
      // 40: fload 0
      // 41: iload 4
      // 43: i2f
      // 44: fload 3
      // 45: fmul
      // 46: fadd
      // 47: fastore
      // 48: dup
      // 49: bipush 1
      // 4a: fload 0
      // 4b: iload 4
      // 4d: i2f
      // 4e: fload 3
      // 4f: fmul
      // 50: fsub
      // 51: fastore
      // 52: dup
      // 53: ldc_w 1525872002
      // 56: ldc_w 1525872000
      // 59: ixor
      // 5a: fload 0
      // 5b: fastore
      // 5c: areturn
   }

   static boolean ɍ(float param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 1
      // 04: fload 0
      // 05: iload 1
      // 06: ifne 18
      // 09: invokestatic java/lang/Float.isNaN (F)Z
      // 0c: ifne 3d
      // 0f: goto 13
      // 12: athrow
      // 13: fload 0
      // 14: goto 18
      // 17: athrow
      // 18: iload 1
      // 19: ifne 2b
      // 1c: invokestatic java/lang/Float.isInfinite (F)Z
      // 1f: ifne 3d
      // 22: goto 26
      // 25: athrow
      // 26: fload 0
      // 27: goto 2b
      // 2a: athrow
      // 2b: ldc 84.5
      // 2d: fcmpg
      // 2e: iload 1
      // 2f: ifne 3a
      // 32: ifgt 3d
      // 35: goto 39
      // 38: athrow
      // 39: bipush 1
      // 3a: goto 3e
      // 3d: bipush 0
      // 3e: ireturn
   }

   private static boolean ο(float var0) {
      int var1 = oc84f20a0bc5.ė;
      int var2 = -1631374431 ^ -1761942911;

      while (true) {
         switch (var2) {
            case -1057824229:
               return true;
            case 138006816:
               int var7;
               label57: {
                  label56: {
                     try {
                        var7 = С(var0);
                        if (var1 != 0) {
                           break label57;
                        }

                        if (var7 == 0) {
                           break label56;
                        }
                     } catch (ocbde1165e4e var4) {
                        throw var4;
                     }

                     var2 = -1933530919 ^ -1761942911;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var7 = -1234899855 ^ -1761942911;
               }

               var2 = var7;
               if (var1 == 0) {
                  break;
               }

               return true;
            case 440027736:
               int var10000;
               label69: {
                  label68: {
                     try {
                        float var9;
                        var10000 = (var9 = var0 - -90.0F) == 0.0F ? 0 : (var9 < 0.0F ? -1 : 1);
                        if (var1 != 0) {
                           break label69;
                        }

                        if (var10000 < 0) {
                           break label68;
                        }
                     } catch (ocbde1165e4e var5) {
                        throw var5;
                     }

                     var2 = 1119586969 ^ -1761942911;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var10000 = -1234899855 ^ -1761942911;
               }

               var2 = var10000;
               if (var1 == 0) {
                  break;
               }
            case -733911016:
               int var6;
               label48: {
                  label47: {
                     try {
                        float var8;
                        var6 = (var8 = var0 - 90.0F) == 0.0F ? 0 : (var8 < 0.0F ? -1 : 1);
                        if (var1 != 0) {
                           break label48;
                        }

                        if (var6 > 0) {
                           break label47;
                        }
                     } catch (ocbde1165e4e var3) {
                        throw var3;
                     }

                     var2 = 1443365018 ^ -1761942911;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var6 = -1234899855 ^ -1761942911;
               }

               var2 = var6;
               if (var1 == 0) {
                  break;
               }

               return false;
            case 547229424:
               return false;
            default:
               throw null;
         }
      }
   }

   static double[] Ӓ(float param0, float param1, float param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: fload 1
      // 04: fload 1
      // 05: fmul
      // 06: fload 2
      // 07: fload 2
      // 08: fmul
      // 09: fadd
      // 0a: f2d
      // 0b: invokestatic java/lang/Math.sqrt (D)D
      // 0e: dstore 4
      // 10: istore 3
      // 11: dload 4
      // 13: iload 3
      // 14: ifne 2a
      // 17: ldc2_w 1.0E-4
      // 1a: dcmpg
      // 1b: ifge 25
      // 1e: goto 22
      // 21: athrow
      // 22: aconst_null
      // 23: areturn
      // 24: athrow
      // 25: fload 0
      // 26: f2d
      // 27: invokestatic java/lang/Math.toRadians (D)D
      // 2a: dstore 6
      // 2c: dload 6
      // 2e: invokestatic java/lang/Math.sin (D)D
      // 31: dstore 8
      // 33: dload 6
      // 35: invokestatic java/lang/Math.cos (D)D
      // 38: dstore 10
      // 3a: fload 2
      // 3b: f2d
      // 3c: dload 10
      // 3e: dmul
      // 3f: fload 1
      // 40: f2d
      // 41: dload 8
      // 43: dmul
      // 44: dsub
      // 45: dstore 12
      // 47: fload 1
      // 48: f2d
      // 49: dload 10
      // 4b: dmul
      // 4c: fload 2
      // 4d: f2d
      // 4e: dload 8
      // 50: dmul
      // 51: dadd
      // 52: dstore 14
      // 54: dload 12
      // 56: dload 12
      // 58: dmul
      // 59: dload 14
      // 5b: dload 14
      // 5d: dmul
      // 5e: dadd
      // 5f: invokestatic java/lang/Math.sqrt (D)D
      // 62: dstore 16
      // 64: ldc_w 875922988
      // 67: ldc_w 875922990
      // 6a: ixor
      // 6b: newarray 7
      // 6d: dup
      // 6e: bipush 0
      // 6f: dload 12
      // 71: dload 16
      // 73: ddiv
      // 74: dastore
      // 75: dup
      // 76: bipush 1
      // 77: dload 14
      // 79: dload 16
      // 7b: ddiv
      // 7c: dastore
      // 7d: areturn
   }

   static boolean ŧ(double param0, double param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: dload 0
      // 04: dload 2
      // 05: invokestatic java/lang/Math.hypot (DD)D
      // 08: dstore 5
      // 0a: istore 4
      // 0c: dload 5
      // 0e: iload 4
      // 10: ifne 32
      // 13: ldc2_w 1.0E-4
      // 16: dcmpl
      // 17: iflt 58
      // 1a: goto 1e
      // 1d: athrow
      // 1e: dload 0
      // 1f: dload 5
      // 21: iload 4
      // 23: ifne 47
      // 26: goto 2a
      // 29: athrow
      // 2a: ddiv
      // 2b: invokestatic java/lang/Math.abs (D)D
      // 2e: goto 32
      // 31: athrow
      // 32: ldc2_w 0.35
      // 35: dcmpl
      // 36: iflt 58
      // 39: dload 2
      // 3a: dload 5
      // 3c: ddiv
      // 3d: invokestatic java/lang/Math.abs (D)D
      // 40: ldc2_w 0.35
      // 43: goto 47
      // 46: athrow
      // 47: dcmpl
      // 48: iload 4
      // 4a: ifne 55
      // 4d: iflt 58
      // 50: goto 54
      // 53: athrow
      // 54: bipush 1
      // 55: goto 59
      // 58: bipush 0
      // 59: ireturn
   }

   static boolean Ψ(oceb7a9b9a85 param0, boolean param1, boolean param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 3
      // 04: aload 0
      // 05: iload 3
      // 06: ifne 11
      // 09: ifnull 46
      // 0c: goto 10
      // 0f: athrow
      // 10: aload 0
      // 11: invokevirtual x/oceb7a9b9a85.ё ()Z
      // 14: iload 3
      // 15: ifne 47
      // 18: ifeq 46
      // 1b: goto 1f
      // 1e: athrow
      // 1f: aload 0
      // 20: getfield x/oceb7a9b9a85.λ F
      // 23: ldc_w 0.8
      // 26: fcmpg
      // 27: iload 3
      // 28: ifne 47
      // 2b: goto 2f
      // 2e: athrow
      // 2f: iflt 46
      // 32: goto 36
      // 35: athrow
      // 36: iload 1
      // 37: iload 3
      // 38: ifne 47
      // 3b: goto 3f
      // 3e: athrow
      // 3f: ifeq 48
      // 42: goto 46
      // 45: athrow
      // 46: bipush 0
      // 47: ireturn
      // 48: aload 0
      // 49: invokevirtual x/oceb7a9b9a85.ǫ ()[D
      // 4c: astore 4
      // 4e: iload 2
      // 4f: iload 3
      // 50: ifne 75
      // 53: ifne 74
      // 56: goto 5a
      // 59: athrow
      // 5a: aload 4
      // 5c: bipush 0
      // 5d: daload
      // 5e: aload 4
      // 60: bipush 1
      // 61: daload
      // 62: invokestatic x/ocbce5ea28a3.ŧ (DD)Z
      // 65: iload 3
      // 66: ifne 75
      // 69: goto 6d
      // 6c: athrow
      // 6d: ifne 78
      // 70: goto 74
      // 73: athrow
      // 74: bipush 1
      // 75: goto 79
      // 78: bipush 0
      // 79: ireturn
   }

   static boolean Ҧ(int param0, int param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: bipush 0
      // 04: iload 0
      // 05: bipush 1
      // 06: isub
      // 07: invokestatic java/lang/Math.max (II)I
      // 0a: istore 3
      // 0b: istore 2
      // 0c: iload 1
      // 0d: iload 2
      // 0e: ifne 21
      // 11: invokestatic x/ocbce5ea28a3.ǡ (I)I
      // 14: iload 3
      // 15: if_icmpgt 24
      // 18: goto 1c
      // 1b: athrow
      // 1c: bipush 1
      // 1d: goto 21
      // 20: athrow
      // 21: goto 25
      // 24: bipush 0
      // 25: ireturn
   }

   static boolean Ӿ(int param0, int param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: bipush 0
      // 04: iload 0
      // 05: bipush 1
      // 06: isub
      // 07: invokestatic java/lang/Math.max (II)I
      // 0a: istore 3
      // 0b: istore 2
      // 0c: iload 1
      // 0d: invokestatic x/ocbce5ea28a3.Ѵ (I)I
      // 10: iload 2
      // 11: ifne 23
      // 14: bipush 1
      // 15: iadd
      // 16: iload 3
      // 17: if_icmpgt 26
      // 1a: goto 1e
      // 1d: athrow
      // 1e: bipush 1
      // 1f: goto 23
      // 22: athrow
      // 23: goto 27
      // 26: bipush 0
      // 27: ireturn
   }

   static boolean Ʃ(double var0, double var2, double var4, boolean var6, float var7, float var8, BlockPos var9) {
      oceb39b7deb2 var10 = new oceb39b7deb2(var0, var2, var4, var6);

      try {
         if (ʅ(var10, var7, var8, var9) != null) {
            return true;
         }
      } catch (ocbde1165e4e var11) {
         throw var11;
      }

      return false;
   }

   static boolean ԅ(double var0, double var2, double var4, boolean var6, float var7, float var8, BlockPos var9, EnumFacing var10) {
      int var10000 = oc84f20a0bc5.ė;
      MovingObjectPosition var12 = ʅ(new oceb39b7deb2(var0, var2, var4, var6), var7, var8, var9);
      int var11 = var10000;

      label27: {
         try {
            var15 = var12;
            if (var11 != 0) {
               break label27;
            }

            if (var12 == null) {
               return false;
            }
         } catch (ocbde1165e4e var14) {
            throw var14;
         }

         var15 = var12;
      }

      try {
         if (var15.sideHit == var10) {
            return true;
         }
      } catch (ocbde1165e4e var13) {
         throw var13;
      }

      return false;
   }

   private static boolean Ŏ(oceb39b7deb2 var0, float var1, float var2, BlockPos var3, EnumFacing var4) {
      MovingObjectPosition var6 = null;
      int var7 = 1973532357 ^ -865820243;
      int var5 = oc84f20a0bc5.ė;

      while (true) {
         switch (var7) {
            case -1178265752:
               var6 = ʅ(var0, var1, var2, var3);

               label39: {
                  label38: {
                     try {
                        if (var5 != 0) {
                           break label39;
                        }

                        if (var6 == null) {
                           break label38;
                        }
                     } catch (ocbde1165e4e var8) {
                        throw var8;
                     }

                     var7 = -1495732761 ^ -865820243;
                     if (var5 == 0) {
                        break;
                     }
                  }

                  var7 = -1912274733 ^ -865820243;
               }

               if (var5 == 0) {
                  break;
               }
            case 1790725194:
               if (var6.sideHit == var4) {
                  var7 = -1985821222 ^ -865820243;
                  if (var5 == 0) {
                     break;
                  }
               }

               var7 = -1912274733 ^ -865820243;
               if (var5 == 0) {
                  break;
               }

               return false;
            case 1113694590:
               return false;
            case 1170629751:
               return true;
            default:
               throw null;
         }
      }
   }

   private static MovingObjectPosition ʅ(oceb39b7deb2 param0, float param1, float param2, BlockPos param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: aload 0
      // 01: ifnull 0c
      // 04: aload 3
      // 05: ifnonnull 0f
      // 08: goto 0c
      // 0b: athrow
      // 0c: aconst_null
      // 0d: areturn
      // 0e: athrow
      // 0f: aload 0
      // 10: invokevirtual x/oceb39b7deb2.Ɍ ()Lnet/minecraft/util/Vec3;
      // 13: astore 4
      // 15: fload 1
      // 16: fload 2
      // 17: invokestatic x/oc7ab2161b9f.ҵ (FF)Lnet/minecraft/util/Vec3;
      // 1a: astore 5
      // 1c: aload 4
      // 1e: aload 5
      // 20: getfield net/minecraft/util/Vec3.xCoord D
      // 23: ldc2_w 4.5
      // 26: dmul
      // 27: aload 5
      // 29: getfield net/minecraft/util/Vec3.yCoord D
      // 2c: ldc2_w 4.5
      // 2f: dmul
      // 30: aload 5
      // 32: getfield net/minecraft/util/Vec3.zCoord D
      // 35: ldc2_w 4.5
      // 38: dmul
      // 39: invokevirtual net/minecraft/util/Vec3.addVector (DDD)Lnet/minecraft/util/Vec3;
      // 3c: astore 6
      // 3e: new net/minecraft/util/AxisAlignedBB
      // 41: dup
      // 42: aload 3
      // 43: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 46: i2d
      // 47: aload 3
      // 48: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 4b: i2d
      // 4c: aload 3
      // 4d: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 50: i2d
      // 51: aload 3
      // 52: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 55: i2d
      // 56: dconst_1
      // 57: dadd
      // 58: aload 3
      // 59: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 5c: i2d
      // 5d: dconst_1
      // 5e: dadd
      // 5f: aload 3
      // 60: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 63: i2d
      // 64: dconst_1
      // 65: dadd
      // 66: invokespecial net/minecraft/util/AxisAlignedBB.<init> (DDDDDD)V
      // 69: astore 7
      // 6b: aload 7
      // 6d: aload 4
      // 6f: aload 6
      // 71: invokevirtual net/minecraft/util/AxisAlignedBB.calculateIntercept (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;)Lnet/minecraft/util/MovingObjectPosition;
      // 74: areturn
   }

   static oc81c78bf988 ù(
      double param0,
      double param2,
      double param4,
      double param6,
      double param8,
      double param10,
      oceb7a9b9a85 param12,
      float param13,
      double param14,
      int param16
   ) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: dload 0
      // 004: dstore 18
      // 006: istore 17
      // 008: dload 4
      // 00a: dstore 20
      // 00c: dload 2
      // 00d: dstore 22
      // 00f: dload 6
      // 011: dstore 24
      // 013: dload 8
      // 015: dstore 26
      // 017: dload 10
      // 019: dstore 28
      // 01b: bipush 0
      // 01c: istore 30
      // 01e: bipush 0
      // 01f: istore 31
      // 021: bipush 0
      // 022: istore 32
      // 024: iload 32
      // 026: bipush 0
      // 027: iload 16
      // 029: invokestatic java/lang/Math.max (II)I
      // 02c: if_icmpge 10a
      // 02f: dload 24
      // 031: iload 17
      // 033: ifne 055
      // 036: invokestatic java/lang/Math.abs (D)D
      // 039: ldc2_w 0.005
      // 03c: dcmpg
      // 03d: ifge 047
      // 040: goto 044
      // 043: athrow
      // 044: dconst_0
      // 045: dstore 24
      // 047: dload 28
      // 049: iload 17
      // 04b: ifne 061
      // 04e: invokestatic java/lang/Math.abs (D)D
      // 051: goto 055
      // 054: athrow
      // 055: ldc2_w 0.005
      // 058: dcmpg
      // 059: ifge 063
      // 05c: dconst_0
      // 05d: goto 061
      // 060: athrow
      // 061: dstore 28
      // 063: aload 12
      // 065: getfield x/oceb7a9b9a85.ӥ F
      // 068: aload 12
      // 06a: getfield x/oceb7a9b9a85.λ F
      // 06d: aload 12
      // 06f: getfield x/oceb7a9b9a85.ӄ F
      // 072: fload 13
      // 074: invokestatic x/ocbce5ea28a3.ϗ (FFFF)[D
      // 077: astore 33
      // 079: dload 24
      // 07b: aload 33
      // 07d: bipush 0
      // 07e: daload
      // 07f: dadd
      // 080: dstore 24
      // 082: dload 28
      // 084: aload 33
      // 086: bipush 1
      // 087: daload
      // 088: dadd
      // 089: dstore 28
      // 08b: dload 18
      // 08d: dload 24
      // 08f: dadd
      // 090: iload 17
      // 092: ifne 100
      // 095: dstore 18
      // 097: dload 20
      // 099: dload 26
      // 09b: dadd
      // 09c: dstore 20
      // 09e: dload 22
      // 0a0: dload 28
      // 0a2: dadd
      // 0a3: dstore 22
      // 0a5: iinc 30 1
      // 0a8: dload 26
      // 0aa: dconst_0
      // 0ab: dcmpg
      // 0ac: ifgt 0e6
      // 0af: dload 20
      // 0b1: iload 17
      // 0b3: ifne 100
      // 0b6: goto 0ba
      // 0b9: athrow
      // 0ba: dload 14
      // 0bc: dcmpg
      // 0bd: ifgt 0e6
      // 0c0: goto 0c4
      // 0c3: athrow
      // 0c4: dload 14
      // 0c6: ldc2_w -Infinity
      // 0c9: dcmpl
      // 0ca: iload 17
      // 0cc: ifne 0db
      // 0cf: goto 0d3
      // 0d2: athrow
      // 0d3: ifeq 0de
      // 0d6: goto 0da
      // 0d9: athrow
      // 0da: bipush 1
      // 0db: goto 0df
      // 0de: bipush 0
      // 0df: istore 31
      // 0e1: iload 17
      // 0e3: ifeq 10a
      // 0e6: dload 26
      // 0e8: ldc2_w 0.08
      // 0eb: dsub
      // 0ec: ldc2_w 0.9800000190734863
      // 0ef: dmul
      // 0f0: dstore 26
      // 0f2: dload 24
      // 0f4: ldc2_w 0.9100000262260437
      // 0f7: dmul
      // 0f8: dstore 24
      // 0fa: dload 28
      // 0fc: ldc2_w 0.9100000262260437
      // 0ff: dmul
      // 100: dstore 28
      // 102: iload 17
      // 104: iinc 32 1
      // 107: ifeq 024
      // 10a: new x/oc81c78bf988
      // 10d: dup
      // 10e: dload 18
      // 110: dload 0
      // 111: dsub
      // 112: dload 20
      // 114: dload 4
      // 116: dsub
      // 117: dload 22
      // 119: dload 2
      // 11a: dsub
      // 11b: iload 30
      // 11d: iload 31
      // 11f: dload 24
      // 121: dload 26
      // 123: dload 28
      // 125: invokespecial x/oc81c78bf988.<init> (DDDIZDDD)V
      // 128: areturn
   }

   private static double[] ϗ(float param0, float param1, float param2, float param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: fload 1
      // 04: ldc_w 0.98
      // 07: fmul
      // 08: fstore 5
      // 0a: istore 4
      // 0c: fload 2
      // 0d: ldc_w 0.98
      // 10: fmul
      // 11: fstore 6
      // 13: fload 6
      // 15: fload 6
      // 17: fmul
      // 18: fload 5
      // 1a: fload 5
      // 1c: fmul
      // 1d: fadd
      // 1e: fstore 7
      // 20: fload 7
      // 22: ldc_w 1.0E-4
      // 25: iload 4
      // 27: ifne 58
      // 2a: fcmpg
      // 2b: ifge 45
      // 2e: goto 32
      // 31: athrow
      // 32: ldc_w 138429470
      // 35: ldc_w 138429468
      // 38: ixor
      // 39: newarray 7
      // 3b: dup
      // 3c: bipush 0
      // 3d: dconst_0
      // 3e: dastore
      // 3f: dup
      // 40: bipush 1
      // 41: dconst_0
      // 42: dastore
      // 43: areturn
      // 44: athrow
      // 45: fload 7
      // 47: invokestatic net/minecraft/util/MathHelper.sqrt_float (F)F
      // 4a: fstore 7
      // 4c: fload 7
      // 4e: iload 4
      // 50: ifne 63
      // 53: fconst_1
      // 54: goto 58
      // 57: athrow
      // 58: fcmpg
      // 59: ifge 5f
      // 5c: fconst_1
      // 5d: fstore 7
      // 5f: fload 3
      // 60: fload 7
      // 62: fdiv
      // 63: fstore 8
      // 65: fload 6
      // 67: fload 8
      // 69: fmul
      // 6a: fstore 6
      // 6c: fload 5
      // 6e: fload 8
      // 70: fmul
      // 71: fstore 5
      // 73: fload 0
      // 74: ldc_w 0.017453292
      // 77: fmul
      // 78: fstore 9
      // 7a: fload 9
      // 7c: invokestatic net/minecraft/util/MathHelper.sin (F)F
      // 7f: fstore 10
      // 81: fload 9
      // 83: invokestatic net/minecraft/util/MathHelper.cos (F)F
      // 86: fstore 11
      // 88: ldc_w 138429470
      // 8b: ldc_w 138429468
      // 8e: ixor
      // 8f: newarray 7
      // 91: dup
      // 92: bipush 0
      // 93: fload 6
      // 95: fload 11
      // 97: fmul
      // 98: fload 5
      // 9a: fload 10
      // 9c: fmul
      // 9d: fsub
      // 9e: f2d
      // 9f: dastore
      // a0: dup
      // a1: bipush 1
      // a2: fload 5
      // a4: fload 11
      // a6: fmul
      // a7: fload 6
      // a9: fload 10
      // ab: fmul
      // ac: fadd
      // ad: f2d
      // ae: dastore
      // af: areturn
   }

   static int ǡ(int param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: bipush 0
      // 04: iload 0
      // 05: invokestatic java/lang/Math.max (II)I
      // 08: istore 2
      // 09: istore 1
      // 0a: iload 2
      // 0b: iload 1
      // 0c: ifne 24
      // 0f: ifne 1b
      // 12: goto 16
      // 15: athrow
      // 16: bipush 0
      // 17: goto 26
      // 1a: athrow
      // 1b: iload 2
      // 1c: ldc_w 2060925696
      // 1f: ldc_w 2060925698
      // 22: ixor
      // 23: imul
      // 24: bipush 1
      // 25: iadd
      // 26: ireturn
   }

   static int Ѵ(int param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: bipush 0
      // 04: iload 0
      // 05: invokestatic java/lang/Math.max (II)I
      // 08: istore 2
      // 09: istore 1
      // 0a: iload 2
      // 0b: iload 1
      // 0c: ifne 1c
      // 0f: ifne 1b
      // 12: goto 16
      // 15: athrow
      // 16: bipush 0
      // 17: goto 24
      // 1a: athrow
      // 1b: iload 2
      // 1c: ldc_w -1365310738
      // 1f: ldc_w -1365310740
      // 22: ixor
      // 23: iadd
      // 24: ireturn
   }

   static {
      double[] var10000 = new double[-1069466109 ^ -1069466106];
      var10000[0] = 0.18;
      var10000[1] = 0.34;
      var10000[-1069466108 ^ -1069466106] = 0.5;
      var10000[-1069466107 ^ -1069466106] = 0.66;
      var10000[-1069466110 ^ -1069466106] = 0.82;
      Ћ = var10000;
   }
}
