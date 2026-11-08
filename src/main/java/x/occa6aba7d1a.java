package x;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class occa6aba7d1a extends oc69da1aa7f5 {
   private static final String[] ĥ;
   private static final float Λ = 8.0F;
   private oca9cc61aada ʳ;
   private oc24a0a5bddf ք;
   private oc24a0a5bddf ē;
   private oca9cc61aada ϱ;
   private oca9cc61aada Ţ;
   private oca9cc61aada λ;
   private occ2f8dff8d8 Ɨ;
   private occ2f8dff8d8 ɝ;
   private occ2f8dff8d8 i;
   private oc24a0a5bddf Ї;
   private occ2f8dff8d8 ŗ;
   private occ2f8dff8d8 ƥ;
   private occ2f8dff8d8 ă;
   private oca9cc61aada Ѐ;
   private oca9cc61aada մ;
   private occ2f8dff8d8 Ý;
   private boolean с;
   private final List<BlockPos[]> Ŵ = new ArrayList<>();
   private static final int ʧ = 16;
   private static final int Ȑ = 18;
   private static final int у = 3;
   private static final float ĝ = 8.0F;
   private static final int Ј = 1929379840;
   private static final int պ = -1778384896;
   private static final int ъ = 5;
   private static final float я = 0.2F;
   private static final float J = 0.2F;
   private static final EnumMap<EnumFacing, occfa28f796b[]> d = Ϸ();
   private final List<BlockPos[]> ſ = new ArrayList<>();
   private final Map<Long, ocecae709e0b> ֆ = new HashMap<>();
   private final Map<Long, oc20f324c8eb> Α = new HashMap<>();
   private final Map<Long, Set<Long>> ͼ = new HashMap<>();
   private final Map<Long, Set<Long>> ұ = new HashMap<>();
   private final Set<Long> j = new HashSet<>();
   private final oc5627f01551 Շ = new oc6afb9d4aa5(this);
   public static int ƫ;

   public occa6aba7d1a() {
      super("BedESP", oce4cea752dd.Ŏ);
      this.ą("Highlights beds.");
      this.ʌ(this.ʳ = new oca9cc61aada("Color mode", 0, ĥ));
      this.ʌ(this.ք = new oc24a0a5bddf("Color", -666998373 ^ -666998428, -666998479 ^ -666998428, -666998479 ^ -666998428, -666998492 ^ -666998428));
      this.ʌ(this.ē = new oc24a0a5bddf("Color 2", -666998479 ^ -666998428, -666998479 ^ -666998428, -666998373 ^ -666998428, -666998492 ^ -666998428));
      this.ʌ(this.ϱ = new oca9cc61aada("Gradient speed", 1.0, 0.1, 8.0, 0.1));
      this.ʌ(this.Ţ = new oca9cc61aada("Range", 10.0, 2.0, 200.0, 2.0));
      this.ʌ(this.λ = new oca9cc61aada("Scan speed", 8.0, 1.0, 32.0, 1.0));
      this.ʌ(this.Ɨ = new occ2f8dff8d8("Only render first bed", false));
      this.ʌ(this.ɝ = new occ2f8dff8d8("Render full block", false));
      this.ʌ(this.i = new occ2f8dff8d8("Exposed outline", true));
      this.ʌ(
         this.Ї = new oc24a0a5bddf("Exposed outline color", -666998373 ^ -666998428, -666998344 ^ -666998428, -666998492 ^ -666998428, -666998373 ^ -666998428)
      );
      this.ʌ(this.ŗ = new occ2f8dff8d8("Show defense layers", false));
      this.ʌ(this.ƥ = new occ2f8dff8d8("Show break tools", false));
      this.ʌ(this.ă = new occ2f8dff8d8("Show defense counts", true));
      this.ʌ(this.Ѐ = new oca9cc61aada("Defense height", 0.6, 0.1, 3.0, 0.1));
      this.ʌ(this.մ = new oca9cc61aada("Defense scale", 1.0, 0.1, 2.0, 0.01));
      this.ʌ(this.Ý = new occ2f8dff8d8("Auto Scale", false));
   }

   @Override
   public void z$2u87utkr1isxg() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: aload 0
      // 04: getfield x/occa6aba7d1a.ʳ Lx/oca9cc61aada;
      // 07: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0a: d2i
      // 0b: istore 2
      // 0c: istore 1
      // 0d: aload 0
      // 0e: getfield x/occa6aba7d1a.ք Lx/oc24a0a5bddf;
      // 11: iload 2
      // 12: iload 1
      // 13: ifne 1e
      // 16: ifeq 21
      // 19: goto 1d
      // 1c: athrow
      // 1d: bipush 1
      // 1e: goto 22
      // 21: bipush 0
      // 22: aload 0
      // 23: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 26: aload 0
      // 27: getfield x/occa6aba7d1a.ē Lx/oc24a0a5bddf;
      // 2a: iload 2
      // 2b: iload 1
      // 2c: ifne 42
      // 2f: ldc_w 1228282365
      // 32: ldc_w 1228282367
      // 35: ixor
      // 36: if_icmpne 45
      // 39: goto 3d
      // 3c: athrow
      // 3d: bipush 1
      // 3e: goto 42
      // 41: athrow
      // 42: goto 46
      // 45: bipush 0
      // 46: aload 0
      // 47: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 4a: aload 0
      // 4b: getfield x/occa6aba7d1a.ϱ Lx/oca9cc61aada;
      // 4e: iload 2
      // 4f: iload 1
      // 50: ifne 66
      // 53: ldc_w 1228282365
      // 56: ldc_w 1228282367
      // 59: ixor
      // 5a: if_icmpne 69
      // 5d: goto 61
      // 60: athrow
      // 61: bipush 1
      // 62: goto 66
      // 65: athrow
      // 66: goto 6a
      // 69: bipush 0
      // 6a: aload 0
      // 6b: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 6e: aload 0
      // 6f: getfield x/occa6aba7d1a.Ї Lx/oc24a0a5bddf;
      // 72: aload 0
      // 73: getfield x/occa6aba7d1a.i Lx/occ2f8dff8d8;
      // 76: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 79: aload 0
      // 7a: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 7d: aload 0
      // 7e: getfield x/occa6aba7d1a.ŗ Lx/occ2f8dff8d8;
      // 81: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 84: istore 3
      // 85: aload 0
      // 86: getfield x/occa6aba7d1a.ƥ Lx/occ2f8dff8d8;
      // 89: iload 3
      // 8a: iload 1
      // 8b: ifne a9
      // 8e: aload 0
      // 8f: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 92: aload 0
      // 93: getfield x/occa6aba7d1a.ă Lx/occ2f8dff8d8;
      // 96: iload 3
      // 97: ifeq b8
      // 9a: goto 9e
      // 9d: athrow
      // 9e: aload 0
      // 9f: getfield x/occa6aba7d1a.ƥ Lx/occ2f8dff8d8;
      // a2: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // a5: goto a9
      // a8: athrow
      // a9: iload 1
      // aa: ifne b5
      // ad: ifne b8
      // b0: goto b4
      // b3: athrow
      // b4: bipush 1
      // b5: goto b9
      // b8: bipush 0
      // b9: aload 0
      // ba: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // bd: aload 0
      // be: getfield x/occa6aba7d1a.Ѐ Lx/oca9cc61aada;
      // c1: iload 3
      // c2: aload 0
      // c3: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // c6: aload 0
      // c7: getfield x/occa6aba7d1a.մ Lx/oca9cc61aada;
      // ca: iload 3
      // cb: aload 0
      // cc: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // cf: aload 0
      // d0: getfield x/occa6aba7d1a.Ý Lx/occ2f8dff8d8;
      // d3: iload 3
      // d4: aload 0
      // d5: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // d8: return
   }

   @Override
   public void onEnable() {
      ocfbf6a7fb78 var1 = ocfbf6a7fb78.ā();
      var1.Ƴ(this.Շ);
      var1.Ǎ();
      var1.Ä();
   }

   @Override
   public void onDisable() {
      ocfbf6a7fb78 var1 = ocfbf6a7fb78.ā();
      var1.Ǣ(this.Շ);
      var1.ԛ();
      this.ſ.clear();
      this.Ŵ.clear();
      this.с = false;
      this.Ͷ();
   }

   @oc66fa4f2195
   public void x(ocadfd5cc157 var1) {
      try {
         if (var1.Ц == oc69da1aa7f5.ő.thePlayer) {
            this.ſ.clear();
            this.Ŵ.clear();
            this.с = false;
            this.Ͷ();
         }
      } catch (ocbde1165e4e var2) {
         throw var2;
      }
   }

   public int Ʈ() {
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
      // 05: iload 1
      // 06: ifne 18
      // 09: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 0c: ifeq 22
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: goto 18
      // 17: athrow
      // 18: getfield x/occa6aba7d1a.λ Lx/oca9cc61aada;
      // 1b: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 1e: d2i
      // 1f: goto 23
      // 22: bipush 0
      // 23: ireturn
   }

   @Override
   public void z$1m9j3ewef9s() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oce6044968f8.ђ Z
      // 003: istore 1
      // 004: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 007: ifne 019
      // 00a: aload 0
      // 00b: getfield x/occa6aba7d1a.ſ Ljava/util/List;
      // 00e: invokeinterface java/util/List.clear ()V 1
      // 013: aload 0
      // 014: invokevirtual x/occa6aba7d1a.Ͷ ()V
      // 017: return
      // 018: athrow
      // 019: invokestatic x/ocfbf6a7fb78.ā ()Lx/ocfbf6a7fb78;
      // 01c: astore 2
      // 01d: aload 0
      // 01e: getfield x/occa6aba7d1a.Ţ Lx/oca9cc61aada;
      // 021: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 024: aload 0
      // 025: getfield x/occa6aba7d1a.Ţ Lx/oca9cc61aada;
      // 028: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 02b: dmul
      // 02c: dstore 3
      // 02d: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 030: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 033: getfield net/minecraft/client/entity/EntityPlayerSP.posX D
      // 036: dstore 5
      // 038: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 03b: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 03e: getfield net/minecraft/client/entity/EntityPlayerSP.posY D
      // 041: dstore 7
      // 043: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 046: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 049: getfield net/minecraft/client/entity/EntityPlayerSP.posZ D
      // 04c: dstore 9
      // 04e: aload 0
      // 04f: aload 2
      // 050: dload 5
      // 052: dload 7
      // 054: dload 9
      // 056: dload 3
      // 057: invokevirtual x/occa6aba7d1a.Ι (Lx/ocfbf6a7fb78;DDDD)Ljava/util/List;
      // 05a: astore 11
      // 05c: aload 0
      // 05d: getfield x/occa6aba7d1a.ſ Ljava/util/List;
      // 060: invokeinterface java/util/List.clear ()V 1
      // 065: aload 11
      // 067: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 06c: astore 12
      // 06e: aload 12
      // 070: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 075: ifeq 09f
      // 078: aload 12
      // 07a: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 07f: checkcast [Lnet/minecraft/util/BlockPos;
      // 082: astore 13
      // 084: aload 0
      // 085: iload 1
      // 086: ifne 0a0
      // 089: getfield x/occa6aba7d1a.ſ Ljava/util/List;
      // 08c: aload 13
      // 08e: invokestatic x/occa6aba7d1a.Ѭ ([Lnet/minecraft/util/BlockPos;)[Lnet/minecraft/util/BlockPos;
      // 091: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 096: pop
      // 097: iload 1
      // 098: ifeq 06e
      // 09b: goto 09f
      // 09e: athrow
      // 09f: aload 0
      // 0a0: getfield x/occa6aba7d1a.ƥ Lx/occ2f8dff8d8;
      // 0a3: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 0a6: istore 12
      // 0a8: aload 0
      // 0a9: iload 1
      // 0aa: ifne 0c8
      // 0ad: getfield x/occa6aba7d1a.с Z
      // 0b0: iload 12
      // 0b2: if_icmpeq 0c7
      // 0b5: goto 0b9
      // 0b8: athrow
      // 0b9: aload 0
      // 0ba: invokevirtual x/occa6aba7d1a.Ͷ ()V
      // 0bd: aload 0
      // 0be: iload 12
      // 0c0: putfield x/occa6aba7d1a.с Z
      // 0c3: goto 0c7
      // 0c6: athrow
      // 0c7: aload 0
      // 0c8: iload 1
      // 0c9: ifne 0de
      // 0cc: getfield x/occa6aba7d1a.ŗ Lx/occ2f8dff8d8;
      // 0cf: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 0d2: ifne 0e2
      // 0d5: goto 0d9
      // 0d8: athrow
      // 0d9: aload 0
      // 0da: goto 0de
      // 0dd: athrow
      // 0de: invokevirtual x/occa6aba7d1a.Ͷ ()V
      // 0e1: return
      // 0e2: new java/util/HashSet
      // 0e5: dup
      // 0e6: invokespecial java/util/HashSet.<init> ()V
      // 0e9: astore 13
      // 0eb: aload 11
      // 0ed: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 0f2: astore 14
      // 0f4: aload 14
      // 0f6: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 0fb: ifeq 1f7
      // 0fe: aload 14
      // 100: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 105: checkcast [Lnet/minecraft/util/BlockPos;
      // 108: astore 15
      // 10a: aload 15
      // 10c: bipush 0
      // 10d: aaload
      // 10e: astore 16
      // 110: aload 15
      // 112: bipush 1
      // 113: aaload
      // 114: astore 17
      // 116: aload 16
      // 118: invokevirtual net/minecraft/util/BlockPos.toLong ()J
      // 11b: lstore 18
      // 11d: aload 13
      // 11f: lload 18
      // 121: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 124: invokeinterface java/util/Set.add (Ljava/lang/Object;)Z 2
      // 129: pop
      // 12a: aload 0
      // 12b: getfield x/occa6aba7d1a.Α Ljava/util/Map;
      // 12e: iload 1
      // 12f: ifne 21d
      // 132: lload 18
      // 134: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 137: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 13c: checkcast x/oc20f324c8eb
      // 13f: astore 20
      // 141: iload 1
      // 142: ifne 176
      // 145: aload 20
      // 147: ifnull 164
      // 14a: goto 14e
      // 14d: athrow
      // 14e: aload 20
      // 150: iload 1
      // 151: ifne 193
      // 154: goto 158
      // 157: athrow
      // 158: aload 17
      // 15a: invokevirtual x/oc20f324c8eb.ʀ (Lnet/minecraft/util/BlockPos;)Z
      // 15d: ifne 185
      // 160: goto 164
      // 163: athrow
      // 164: aload 0
      // 165: lload 18
      // 167: invokevirtual x/occa6aba7d1a.º (J)V
      // 16a: aload 0
      // 16b: aload 16
      // 16d: aload 17
      // 16f: invokevirtual x/occa6aba7d1a.ǭ (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/BlockPos;)V
      // 172: goto 176
      // 175: athrow
      // 176: aload 0
      // 177: getfield x/occa6aba7d1a.j Ljava/util/Set;
      // 17a: lload 18
      // 17c: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 17f: invokeinterface java/util/Set.add (Ljava/lang/Object;)Z 2
      // 184: pop
      // 185: aload 0
      // 186: getfield x/occa6aba7d1a.ֆ Ljava/util/Map;
      // 189: lload 18
      // 18b: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 18e: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 193: checkcast x/ocecae709e0b
      // 196: astore 21
      // 198: aload 21
      // 19a: iload 1
      // 19b: ifne 1f2
      // 19e: ifnull 1d8
      // 1a1: goto 1a5
      // 1a4: athrow
      // 1a5: aload 21
      // 1a7: iload 1
      // 1a8: ifne 1f2
      // 1ab: goto 1af
      // 1ae: athrow
      // 1af: aload 17
      // 1b1: invokevirtual x/ocecae709e0b.Đ (Lnet/minecraft/util/BlockPos;)Z
      // 1b4: ifeq 1d8
      // 1b7: goto 1bb
      // 1ba: athrow
      // 1bb: aload 0
      // 1bc: iload 1
      // 1bd: ifne 1f2
      // 1c0: goto 1c4
      // 1c3: athrow
      // 1c4: getfield x/occa6aba7d1a.j Ljava/util/Set;
      // 1c7: lload 18
      // 1c9: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 1cc: invokeinterface java/util/Set.remove (Ljava/lang/Object;)Z 2
      // 1d1: ifeq 1f3
      // 1d4: goto 1d8
      // 1d7: athrow
      // 1d8: aload 0
      // 1d9: getfield x/occa6aba7d1a.ֆ Ljava/util/Map;
      // 1dc: lload 18
      // 1de: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 1e1: aload 0
      // 1e2: aload 16
      // 1e4: aload 17
      // 1e6: invokevirtual x/occa6aba7d1a.Ҝ (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/BlockPos;)Lx/ocecae709e0b;
      // 1e9: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 1ee: goto 1f2
      // 1f1: athrow
      // 1f2: pop
      // 1f3: iload 1
      // 1f4: ifeq 0f4
      // 1f7: new java/util/ArrayList
      // 1fa: dup
      // 1fb: aload 0
      // 1fc: getfield x/occa6aba7d1a.Α Ljava/util/Map;
      // 1ff: invokeinterface java/util/Map.keySet ()Ljava/util/Set; 1
      // 204: invokespecial java/util/ArrayList.<init> (Ljava/util/Collection;)V
      // 207: invokevirtual java/util/ArrayList.iterator ()Ljava/util/Iterator;
      // 20a: astore 14
      // 20c: aload 14
      // 20e: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 213: ifeq 247
      // 216: aload 14
      // 218: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 21d: checkcast java/lang/Long
      // 220: astore 15
      // 222: aload 13
      // 224: iload 1
      // 225: ifne 24b
      // 228: aload 15
      // 22a: invokeinterface java/util/Set.contains (Ljava/lang/Object;)Z 2
      // 22f: ifne 243
      // 232: goto 236
      // 235: athrow
      // 236: aload 0
      // 237: aload 15
      // 239: invokevirtual java/lang/Long.longValue ()J
      // 23c: invokevirtual x/occa6aba7d1a.º (J)V
      // 23f: goto 243
      // 242: athrow
      // 243: iload 1
      // 244: ifeq 20c
      // 247: aload 0
      // 248: getfield x/occa6aba7d1a.j Ljava/util/Set;
      // 24b: aload 13
      // 24d: invokeinterface java/util/Set.retainAll (Ljava/util/Collection;)Z 2
      // 252: pop
      // 253: return
   }

   @Override
   public String getInfo() {
      boolean var10000 = oce6044968f8.ђ;
      int var2 = ocfbf6a7fb78.ā().Ú();
      boolean var1 = var10000;

      try {
         if (var1) {
            return String.valueOf(var2);
         }

         if (var2 <= 0) {
            return "";
         }
      } catch (ocbde1165e4e var3) {
         throw var3;
      }

      return String.valueOf(var2);
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.LOWEST
   )
   public void ʪ(oc746a23b244 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oce6044968f8.ђ Z
      // 003: istore 2
      // 004: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 007: iload 2
      // 008: ifne 01f
      // 00b: ifne 013
      // 00e: goto 012
      // 011: athrow
      // 012: return
      // 013: aload 0
      // 014: iload 2
      // 015: ifne 024
      // 018: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 01b: goto 01f
      // 01e: athrow
      // 01f: ifne 023
      // 022: return
      // 023: aload 0
      // 024: invokevirtual x/occa6aba7d1a.Ѻ ()F
      // 027: fstore 3
      // 028: aload 0
      // 029: getfield x/occa6aba7d1a.Ţ Lx/oca9cc61aada;
      // 02c: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 02f: aload 0
      // 030: getfield x/occa6aba7d1a.Ţ Lx/oca9cc61aada;
      // 033: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 036: dmul
      // 037: dstore 4
      // 039: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 03c: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 03f: getfield net/minecraft/client/entity/EntityPlayerSP.posX D
      // 042: dstore 6
      // 044: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 047: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 04a: getfield net/minecraft/client/entity/EntityPlayerSP.posY D
      // 04d: dstore 8
      // 04f: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 052: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 055: getfield net/minecraft/client/entity/EntityPlayerSP.posZ D
      // 058: dstore 10
      // 05a: new java/util/ArrayList
      // 05d: dup
      // 05e: invokespecial java/util/ArrayList.<init> ()V
      // 061: astore 12
      // 063: new java/util/HashSet
      // 066: dup
      // 067: invokespecial java/util/HashSet.<init> ()V
      // 06a: astore 13
      // 06c: aload 0
      // 06d: getfield x/occa6aba7d1a.ſ Ljava/util/List;
      // 070: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 075: astore 14
      // 077: aload 14
      // 079: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 07e: ifeq 0e6
      // 081: aload 14
      // 083: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 088: checkcast [Lnet/minecraft/util/BlockPos;
      // 08b: astore 15
      // 08d: iload 2
      // 08e: aload 15
      // 090: bipush 0
      // 091: aaload
      // 092: astore 16
      // 094: ifne 0f6
      // 097: aload 15
      // 099: bipush 0
      // 09a: aaload
      // 09b: aload 15
      // 09d: bipush 1
      // 09e: aaload
      // 09f: fload 3
      // 0a0: invokestatic x/occa6aba7d1a.M (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/BlockPos;F)Lnet/minecraft/util/AxisAlignedBB;
      // 0a3: astore 17
      // 0a5: aload 17
      // 0a7: invokestatic x/ocbd4917c4b1.ӥ (Lnet/minecraft/util/AxisAlignedBB;)Z
      // 0aa: iload 2
      // 0ab: ifne 0c6
      // 0ae: ifne 0bd
      // 0b1: goto 0b5
      // 0b4: athrow
      // 0b5: iload 2
      // 0b6: ifeq 077
      // 0b9: goto 0bd
      // 0bc: athrow
      // 0bd: aload 13
      // 0bf: aload 16
      // 0c1: invokeinterface java/util/Set.add (Ljava/lang/Object;)Z 2
      // 0c6: iload 2
      // 0c7: ifne 0e1
      // 0ca: ifeq 0e2
      // 0cd: goto 0d1
      // 0d0: athrow
      // 0d1: aload 12
      // 0d3: aload 15
      // 0d5: invokestatic x/occa6aba7d1a.Ѭ ([Lnet/minecraft/util/BlockPos;)[Lnet/minecraft/util/BlockPos;
      // 0d8: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 0dd: goto 0e1
      // 0e0: athrow
      // 0e1: pop
      // 0e2: iload 2
      // 0e3: ifeq 077
      // 0e6: new java/util/ArrayList
      // 0e9: dup
      // 0ea: aload 0
      // 0eb: getfield x/occa6aba7d1a.Ŵ Ljava/util/List;
      // 0ee: invokespecial java/util/ArrayList.<init> (Ljava/util/Collection;)V
      // 0f1: invokevirtual java/util/ArrayList.iterator ()Ljava/util/Iterator;
      // 0f4: astore 14
      // 0f6: aload 14
      // 0f8: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 0fd: ifeq 208
      // 100: aload 14
      // 102: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 107: checkcast [Lnet/minecraft/util/BlockPos;
      // 10a: astore 15
      // 10c: iload 2
      // 10d: ifne 211
      // 110: aload 15
      // 112: iload 2
      // 113: ifne 123
      // 116: goto 11a
      // 119: athrow
      // 11a: ifnull 0f6
      // 11d: goto 121
      // 120: athrow
      // 121: aload 15
      // 123: iload 2
      // 124: ifne 140
      // 127: arraylength
      // 128: ldc_w 2095504395
      // 12b: ldc_w 2095504393
      // 12e: ixor
      // 12f: if_icmpge 13e
      // 132: goto 136
      // 135: athrow
      // 136: iload 2
      // 137: ifeq 0f6
      // 13a: goto 13e
      // 13d: athrow
      // 13e: aload 15
      // 140: bipush 0
      // 141: aaload
      // 142: astore 16
      // 144: aload 15
      // 146: bipush 1
      // 147: aaload
      // 148: astore 17
      // 14a: aload 13
      // 14c: aload 16
      // 14e: invokeinterface java/util/Set.contains (Ljava/lang/Object;)Z 2
      // 153: iload 2
      // 154: ifne 16c
      // 157: ifeq 166
      // 15a: goto 15e
      // 15d: athrow
      // 15e: iload 2
      // 15f: ifeq 0f6
      // 162: goto 166
      // 165: athrow
      // 166: aload 0
      // 167: aload 15
      // 169: invokevirtual x/occa6aba7d1a.Ԟ ([Lnet/minecraft/util/BlockPos;)Z
      // 16c: iload 2
      // 16d: ifne 184
      // 170: ifne 17f
      // 173: goto 177
      // 176: athrow
      // 177: iload 2
      // 178: ifeq 0f6
      // 17b: goto 17f
      // 17e: athrow
      // 17f: aload 16
      // 181: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 184: i2d
      // 185: ldc2_w 0.5
      // 188: dadd
      // 189: dload 6
      // 18b: dsub
      // 18c: dstore 18
      // 18e: aload 16
      // 190: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 193: i2d
      // 194: ldc2_w 0.5
      // 197: dadd
      // 198: dload 8
      // 19a: dsub
      // 19b: dstore 20
      // 19d: aload 16
      // 19f: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 1a2: i2d
      // 1a3: ldc2_w 0.5
      // 1a6: dadd
      // 1a7: dload 10
      // 1a9: dsub
      // 1aa: dstore 22
      // 1ac: dload 18
      // 1ae: dload 18
      // 1b0: dmul
      // 1b1: dload 20
      // 1b3: dload 20
      // 1b5: dmul
      // 1b6: dadd
      // 1b7: dload 22
      // 1b9: dload 22
      // 1bb: dmul
      // 1bc: dadd
      // 1bd: dload 4
      // 1bf: dcmpl
      // 1c0: ifle 1cb
      // 1c3: iload 2
      // 1c4: ifeq 0f6
      // 1c7: goto 1cb
      // 1ca: athrow
      // 1cb: aload 16
      // 1cd: aload 17
      // 1cf: fload 3
      // 1d0: invokestatic x/occa6aba7d1a.M (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/BlockPos;F)Lnet/minecraft/util/AxisAlignedBB;
      // 1d3: astore 24
      // 1d5: iload 2
      // 1d6: ifne 204
      // 1d9: aload 24
      // 1db: invokestatic x/ocbd4917c4b1.ӥ (Lnet/minecraft/util/AxisAlignedBB;)Z
      // 1de: ifne 1ed
      // 1e1: goto 1e5
      // 1e4: athrow
      // 1e5: iload 2
      // 1e6: ifeq 0f6
      // 1e9: goto 1ed
      // 1ec: athrow
      // 1ed: aload 12
      // 1ef: aload 15
      // 1f1: invokestatic x/occa6aba7d1a.Ѭ ([Lnet/minecraft/util/BlockPos;)[Lnet/minecraft/util/BlockPos;
      // 1f4: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 1f9: pop
      // 1fa: aload 13
      // 1fc: aload 16
      // 1fe: invokeinterface java/util/Set.add (Ljava/lang/Object;)Z 2
      // 203: pop
      // 204: iload 2
      // 205: ifeq 0f6
      // 208: aload 12
      // 20a: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 20f: astore 14
      // 211: aload 14
      // 213: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 218: ifeq 26c
      // 21b: aload 14
      // 21d: iload 2
      // 21e: ifne 27c
      // 221: goto 225
      // 224: athrow
      // 225: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 22a: checkcast [Lnet/minecraft/util/BlockPos;
      // 22d: astore 15
      // 22f: aload 0
      // 230: aload 15
      // 232: iload 2
      // 233: ifne 257
      // 236: fload 3
      // 237: invokevirtual x/occa6aba7d1a.S ([Lnet/minecraft/util/BlockPos;F)V
      // 23a: aload 0
      // 23b: getfield x/occa6aba7d1a.ŗ Lx/occ2f8dff8d8;
      // 23e: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 241: ifeq 268
      // 244: goto 248
      // 247: athrow
      // 248: aload 0
      // 249: iload 2
      // 24a: ifne 262
      // 24d: goto 251
      // 250: athrow
      // 251: aload 15
      // 253: goto 257
      // 256: athrow
      // 257: invokevirtual x/occa6aba7d1a.Λ ([Lnet/minecraft/util/BlockPos;)Z
      // 25a: ifeq 268
      // 25d: aload 0
      // 25e: goto 262
      // 261: athrow
      // 262: aload 15
      // 264: fload 3
      // 265: invokevirtual x/occa6aba7d1a.Ş ([Lnet/minecraft/util/BlockPos;F)V
      // 268: iload 2
      // 269: ifeq 211
      // 26c: aload 0
      // 26d: getfield x/occa6aba7d1a.Ŵ Ljava/util/List;
      // 270: invokeinterface java/util/List.clear ()V 1
      // 275: aload 12
      // 277: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 27c: astore 14
      // 27e: aload 14
      // 280: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 285: ifeq 2a7
      // 288: aload 14
      // 28a: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 28f: checkcast [Lnet/minecraft/util/BlockPos;
      // 292: astore 15
      // 294: iload 2
      // 295: aload 0
      // 296: getfield x/occa6aba7d1a.Ŵ Ljava/util/List;
      // 299: aload 15
      // 29b: invokestatic x/occa6aba7d1a.Ѭ ([Lnet/minecraft/util/BlockPos;)[Lnet/minecraft/util/BlockPos;
      // 29e: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 2a3: pop
      // 2a4: ifeq 27e
      // 2a7: return
   }

   private static BlockPos[] Ѭ(BlockPos[] var0) {
      BlockPos[] var10000 = new BlockPos[-1496163170 ^ -1496163172];
      var10000[0] = new BlockPos(var0[0]);
      var10000[1] = new BlockPos(var0[1]);
      return var10000;
   }

   private List<BlockPos[]> Ι(ocfbf6a7fb78 param1, double param2, double param4, double param6, double param8) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oce6044968f8.ђ Z
      // 003: new java/util/ArrayList
      // 006: dup
      // 007: invokespecial java/util/ArrayList.<init> ()V
      // 00a: astore 11
      // 00c: aload 1
      // 00d: invokevirtual x/ocfbf6a7fb78.ț ()Ljava/lang/Iterable;
      // 010: invokeinterface java/lang/Iterable.iterator ()Ljava/util/Iterator; 1
      // 015: astore 12
      // 017: istore 10
      // 019: aload 12
      // 01b: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 020: ifeq 0ef
      // 023: aload 12
      // 025: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 02a: checkcast java/util/Map$Entry
      // 02d: astore 13
      // 02f: iload 10
      // 031: ifne 11a
      // 034: aload 13
      // 036: invokeinterface java/util/Map$Entry.getValue ()Ljava/lang/Object; 1
      // 03b: goto 03f
      // 03e: athrow
      // 03f: checkcast java/util/Set
      // 042: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 047: astore 14
      // 049: aload 14
      // 04b: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 050: ifeq 0ea
      // 053: aload 14
      // 055: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 05a: checkcast net/minecraft/util/BlockPos
      // 05d: astore 15
      // 05f: aload 15
      // 061: iload 10
      // 063: ifne 03f
      // 066: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 069: i2d
      // 06a: ldc2_w 0.5
      // 06d: dadd
      // 06e: dload 2
      // 06f: dsub
      // 070: dstore 16
      // 072: aload 15
      // 074: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 077: i2d
      // 078: ldc2_w 0.5
      // 07b: dadd
      // 07c: dload 4
      // 07e: dsub
      // 07f: dstore 18
      // 081: aload 15
      // 083: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 086: i2d
      // 087: ldc2_w 0.5
      // 08a: dadd
      // 08b: dload 6
      // 08d: dsub
      // 08e: dstore 20
      // 090: dload 16
      // 092: dload 16
      // 094: dmul
      // 095: dload 18
      // 097: dload 18
      // 099: dmul
      // 09a: dadd
      // 09b: dload 20
      // 09d: dload 20
      // 09f: dmul
      // 0a0: dadd
      // 0a1: dload 8
      // 0a3: dcmpl
      // 0a4: ifle 0b0
      // 0a7: iload 10
      // 0a9: ifeq 049
      // 0ac: goto 0b0
      // 0af: athrow
      // 0b0: aload 0
      // 0b1: aload 15
      // 0b3: invokevirtual x/occa6aba7d1a.A (Lnet/minecraft/util/BlockPos;)[Lnet/minecraft/util/BlockPos;
      // 0b6: astore 22
      // 0b8: aload 22
      // 0ba: ifnull 049
      // 0bd: aload 0
      // 0be: aload 22
      // 0c0: invokevirtual x/occa6aba7d1a.Ԟ ([Lnet/minecraft/util/BlockPos;)Z
      // 0c3: iload 10
      // 0c5: ifne 0e4
      // 0c8: ifne 0d8
      // 0cb: goto 0cf
      // 0ce: athrow
      // 0cf: iload 10
      // 0d1: ifeq 049
      // 0d4: goto 0d8
      // 0d7: athrow
      // 0d8: aload 11
      // 0da: aload 22
      // 0dc: invokestatic x/occa6aba7d1a.Ѭ ([Lnet/minecraft/util/BlockPos;)[Lnet/minecraft/util/BlockPos;
      // 0df: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 0e4: pop
      // 0e5: iload 10
      // 0e7: ifeq 049
      // 0ea: iload 10
      // 0ec: ifeq 019
      // 0ef: aload 0
      // 0f0: getfield x/occa6aba7d1a.Ɨ Lx/occ2f8dff8d8;
      // 0f3: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 0f6: iload 10
      // 0f8: ifne 116
      // 0fb: ifeq 11a
      // 0fe: goto 102
      // 101: athrow
      // 102: aload 11
      // 104: iload 10
      // 106: ifne 11c
      // 109: goto 10d
      // 10c: athrow
      // 10d: invokeinterface java/util/List.size ()I 1
      // 112: goto 116
      // 115: athrow
      // 116: bipush 1
      // 117: if_icmpgt 11d
      // 11a: aload 11
      // 11c: areturn
      // 11d: aconst_null
      // 11e: astore 12
      // 120: ldc2_w 1.7976931348623157E308
      // 123: dstore 13
      // 125: aload 11
      // 127: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 12c: astore 15
      // 12e: aload 15
      // 130: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 135: ifeq 1ac
      // 138: aload 15
      // 13a: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 13f: checkcast [Lnet/minecraft/util/BlockPos;
      // 142: astore 16
      // 144: iload 10
      // 146: ifne 1bc
      // 149: aload 16
      // 14b: bipush 0
      // 14c: aaload
      // 14d: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 150: i2d
      // 151: ldc2_w 0.5
      // 154: dadd
      // 155: dload 2
      // 156: dsub
      // 157: dstore 17
      // 159: iload 10
      // 15b: aload 16
      // 15d: bipush 0
      // 15e: aaload
      // 15f: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 162: i2d
      // 163: ldc2_w 0.5
      // 166: dadd
      // 167: dload 4
      // 169: dsub
      // 16a: dstore 19
      // 16c: aload 16
      // 16e: bipush 0
      // 16f: aaload
      // 170: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 173: i2d
      // 174: ldc2_w 0.5
      // 177: dadd
      // 178: dload 6
      // 17a: dsub
      // 17b: dstore 21
      // 17d: dload 17
      // 17f: dload 17
      // 181: dmul
      // 182: dload 19
      // 184: dload 19
      // 186: dmul
      // 187: dadd
      // 188: dload 21
      // 18a: dload 21
      // 18c: dmul
      // 18d: dadd
      // 18e: dstore 23
      // 190: ifne 1a3
      // 193: dload 23
      // 195: dload 13
      // 197: dcmpg
      // 198: ifge 1a7
      // 19b: goto 19f
      // 19e: athrow
      // 19f: dload 23
      // 1a1: dstore 13
      // 1a3: aload 16
      // 1a5: astore 12
      // 1a7: iload 10
      // 1a9: ifeq 12e
      // 1ac: aload 11
      // 1ae: iload 10
      // 1b0: ifne 1d1
      // 1b3: invokeinterface java/util/List.clear ()V 1
      // 1b8: goto 1bc
      // 1bb: athrow
      // 1bc: aload 12
      // 1be: ifnull 1cf
      // 1c1: aload 11
      // 1c3: aload 12
      // 1c5: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 1ca: pop
      // 1cb: goto 1cf
      // 1ce: athrow
      // 1cf: aload 11
      // 1d1: areturn
   }

   private static boolean Ƴ(IBlockState param0) {
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
      // 05: iload 1
      // 06: ifne 11
      // 09: ifnull 3c
      // 0c: goto 10
      // 0f: athrow
      // 10: aload 0
      // 11: iload 1
      // 12: ifne 29
      // 15: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 1a: instanceof net/minecraft/block/BlockBed
      // 1d: ifeq 3c
      // 20: goto 24
      // 23: athrow
      // 24: aload 0
      // 25: goto 29
      // 28: athrow
      // 29: getstatic net/minecraft/block/BlockBed.PART Lnet/minecraft/block/properties/PropertyEnum;
      // 2c: invokeinterface net/minecraft/block/state/IBlockState.getValue (Lnet/minecraft/block/properties/IProperty;)Ljava/lang/Comparable; 2
      // 31: getstatic net/minecraft/block/BlockBed$EnumPartType.FOOT Lnet/minecraft/block/BlockBed$EnumPartType;
      // 34: if_acmpne 3c
      // 37: bipush 1
      // 38: goto 3d
      // 3b: athrow
      // 3c: bipush 0
      // 3d: ireturn
   }

   private boolean Ԟ(BlockPos[] param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: istore 2
      // 04: aload 1
      // 05: iload 2
      // 06: ifne 11
      // 09: ifnull 39
      // 0c: goto 10
      // 0f: athrow
      // 10: aload 1
      // 11: arraylength
      // 12: iload 2
      // 13: ifne 3e
      // 16: ldc_w 235596539
      // 19: ldc_w 235596537
      // 1c: ixor
      // 1d: if_icmplt 39
      // 20: goto 24
      // 23: athrow
      // 24: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 27: iload 2
      // 28: ifne 42
      // 2b: goto 2f
      // 2e: athrow
      // 2f: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 32: ifnonnull 3f
      // 35: goto 39
      // 38: athrow
      // 39: bipush 0
      // 3a: goto 3e
      // 3d: athrow
      // 3e: ireturn
      // 3f: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 42: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 45: aload 1
      // 46: bipush 0
      // 47: aaload
      // 48: invokevirtual net/minecraft/client/multiplayer/WorldClient.getBlockState (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // 4b: astore 3
      // 4c: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 4f: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 52: aload 1
      // 53: bipush 1
      // 54: aaload
      // 55: invokevirtual net/minecraft/client/multiplayer/WorldClient.getBlockState (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // 58: astore 4
      // 5a: aload 3
      // 5b: iload 2
      // 5c: ifne 80
      // 5f: ifnull 7e
      // 62: goto 66
      // 65: athrow
      // 66: aload 3
      // 67: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 6c: instanceof net/minecraft/block/BlockBed
      // 6f: iload 2
      // 70: ifne a1
      // 73: goto 77
      // 76: athrow
      // 77: ifne a0
      // 7a: goto 7e
      // 7d: athrow
      // 7e: aload 4
      // 80: iload 2
      // 81: ifne 8d
      // 84: ifnull a4
      // 87: goto 8b
      // 8a: athrow
      // 8b: aload 4
      // 8d: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 92: instanceof net/minecraft/block/BlockBed
      // 95: iload 2
      // 96: ifne a1
      // 99: ifeq a4
      // 9c: goto a0
      // 9f: athrow
      // a0: bipush 1
      // a1: goto a5
      // a4: bipush 0
      // a5: ireturn
   }

   private boolean Λ(BlockPos[] param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: istore 2
      // 04: aload 1
      // 05: iload 2
      // 06: ifne 11
      // 09: ifnull 39
      // 0c: goto 10
      // 0f: athrow
      // 10: aload 1
      // 11: arraylength
      // 12: iload 2
      // 13: ifne 3e
      // 16: ldc_w 247414602
      // 19: ldc_w 247414600
      // 1c: ixor
      // 1d: if_icmplt 39
      // 20: goto 24
      // 23: athrow
      // 24: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 27: iload 2
      // 28: ifne 42
      // 2b: goto 2f
      // 2e: athrow
      // 2f: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 32: ifnonnull 3f
      // 35: goto 39
      // 38: athrow
      // 39: bipush 0
      // 3a: goto 3e
      // 3d: athrow
      // 3e: ireturn
      // 3f: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 42: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 45: aload 1
      // 46: bipush 0
      // 47: aaload
      // 48: invokevirtual net/minecraft/client/multiplayer/WorldClient.getBlockState (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // 4b: astore 3
      // 4c: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 4f: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 52: aload 1
      // 53: bipush 1
      // 54: aaload
      // 55: invokevirtual net/minecraft/client/multiplayer/WorldClient.getBlockState (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // 58: astore 4
      // 5a: aload 3
      // 5b: iload 2
      // 5c: ifne 6f
      // 5f: invokestatic x/occa6aba7d1a.Ƴ (Lnet/minecraft/block/state/IBlockState;)Z
      // 62: ifeq 93
      // 65: goto 69
      // 68: athrow
      // 69: aload 4
      // 6b: goto 6f
      // 6e: athrow
      // 6f: iload 2
      // 70: ifne 7c
      // 73: ifnull 93
      // 76: goto 7a
      // 79: athrow
      // 7a: aload 4
      // 7c: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 81: instanceof net/minecraft/block/BlockBed
      // 84: iload 2
      // 85: ifne 90
      // 88: ifeq 93
      // 8b: goto 8f
      // 8e: athrow
      // 8f: bipush 1
      // 90: goto 94
      // 93: bipush 0
      // 94: ireturn
   }

   private static AxisAlignedBB M(BlockPos param0, BlockPos param1, float param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: aload 0
      // 04: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 07: istore 4
      // 09: aload 0
      // 0a: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 0d: istore 5
      // 0f: istore 3
      // 10: aload 0
      // 11: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 14: istore 6
      // 16: iload 5
      // 18: i2f
      // 19: fload 2
      // 1a: fadd
      // 1b: f2d
      // 1c: dstore 7
      // 1e: aload 0
      // 1f: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 22: iload 3
      // 23: ifne 83
      // 26: aload 1
      // 27: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 2a: if_icmpeq 7f
      // 2d: goto 31
      // 30: athrow
      // 31: aload 0
      // 32: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 35: aload 1
      // 36: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 39: if_icmple 60
      // 3c: goto 40
      // 3f: athrow
      // 40: new net/minecraft/util/AxisAlignedBB
      // 43: dup
      // 44: iload 4
      // 46: i2d
      // 47: dconst_1
      // 48: dsub
      // 49: iload 5
      // 4b: i2d
      // 4c: iload 6
      // 4e: i2d
      // 4f: iload 4
      // 51: i2d
      // 52: dconst_1
      // 53: dadd
      // 54: dload 7
      // 56: iload 6
      // 58: i2d
      // 59: dconst_1
      // 5a: dadd
      // 5b: invokespecial net/minecraft/util/AxisAlignedBB.<init> (DDDDDD)V
      // 5e: areturn
      // 5f: athrow
      // 60: new net/minecraft/util/AxisAlignedBB
      // 63: dup
      // 64: iload 4
      // 66: i2d
      // 67: iload 5
      // 69: i2d
      // 6a: iload 6
      // 6c: i2d
      // 6d: iload 4
      // 6f: i2d
      // 70: ldc2_w 2.0
      // 73: dadd
      // 74: dload 7
      // 76: iload 6
      // 78: i2d
      // 79: dconst_1
      // 7a: dadd
      // 7b: invokespecial net/minecraft/util/AxisAlignedBB.<init> (DDDDDD)V
      // 7e: areturn
      // 7f: aload 0
      // 80: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 83: aload 1
      // 84: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 87: if_icmple aa
      // 8a: new net/minecraft/util/AxisAlignedBB
      // 8d: dup
      // 8e: iload 4
      // 90: i2d
      // 91: iload 5
      // 93: i2d
      // 94: iload 6
      // 96: i2d
      // 97: dconst_1
      // 98: dsub
      // 99: iload 4
      // 9b: i2d
      // 9c: dconst_1
      // 9d: dadd
      // 9e: dload 7
      // a0: iload 6
      // a2: i2d
      // a3: dconst_1
      // a4: dadd
      // a5: invokespecial net/minecraft/util/AxisAlignedBB.<init> (DDDDDD)V
      // a8: areturn
      // a9: athrow
      // aa: new net/minecraft/util/AxisAlignedBB
      // ad: dup
      // ae: iload 4
      // b0: i2d
      // b1: iload 5
      // b3: i2d
      // b4: iload 6
      // b6: i2d
      // b7: iload 4
      // b9: i2d
      // ba: dconst_1
      // bb: dadd
      // bc: dload 7
      // be: iload 6
      // c0: i2d
      // c1: ldc2_w 2.0
      // c4: dadd
      // c5: invokespecial net/minecraft/util/AxisAlignedBB.<init> (DDDDDD)V
      // c8: areturn
   }

   private BlockPos[] A(BlockPos param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 06: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 09: aload 1
      // 0a: invokevirtual net/minecraft/client/multiplayer/WorldClient.getBlockState (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // 0d: astore 3
      // 0e: istore 2
      // 0f: aload 3
      // 10: iload 2
      // 11: ifne 27
      // 14: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 19: instanceof net/minecraft/block/BlockBed
      // 1c: ifne 26
      // 1f: goto 23
      // 22: athrow
      // 23: aconst_null
      // 24: areturn
      // 25: athrow
      // 26: aload 3
      // 27: getstatic net/minecraft/block/BlockBed.FACING Lnet/minecraft/block/properties/PropertyDirection;
      // 2a: invokeinterface net/minecraft/block/state/IBlockState.getValue (Lnet/minecraft/block/properties/IProperty;)Ljava/lang/Comparable; 2
      // 2f: checkcast net/minecraft/util/EnumFacing
      // 32: astore 4
      // 34: ldc_w 1762136688
      // 37: ldc_w 1762136690
      // 3a: ixor
      // 3b: anewarray 34
      // 3e: dup
      // 3f: bipush 0
      // 40: aload 1
      // 41: aastore
      // 42: dup
      // 43: bipush 1
      // 44: aload 1
      // 45: aload 4
      // 47: invokevirtual net/minecraft/util/BlockPos.offset (Lnet/minecraft/util/EnumFacing;)Lnet/minecraft/util/BlockPos;
      // 4a: aastore
      // 4b: areturn
   }

   private void S(BlockPos[] param1, float param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oce6044968f8.ђ Z
      // 003: istore 3
      // 004: aload 0
      // 005: iload 3
      // 006: ifne 01b
      // 009: getfield x/occa6aba7d1a.i Lx/occ2f8dff8d8;
      // 00c: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 00f: ifeq 02e
      // 012: goto 016
      // 015: athrow
      // 016: aload 0
      // 017: goto 01b
      // 01a: athrow
      // 01b: aload 1
      // 01c: invokevirtual x/occa6aba7d1a.ʍ ([Lnet/minecraft/util/BlockPos;)Z
      // 01f: iload 3
      // 020: ifne 02b
      // 023: ifeq 02e
      // 026: goto 02a
      // 029: athrow
      // 02a: bipush 1
      // 02b: goto 02f
      // 02e: bipush 0
      // 02f: istore 4
      // 031: aload 1
      // 032: bipush 0
      // 033: aaload
      // 034: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 037: i2d
      // 038: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 03b: invokevirtual net/minecraft/client/Minecraft.getRenderManager ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 03e: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosX D
      // 041: dsub
      // 042: dstore 5
      // 044: aload 1
      // 045: bipush 0
      // 046: aaload
      // 047: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 04a: i2d
      // 04b: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 04e: invokevirtual net/minecraft/client/Minecraft.getRenderManager ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 051: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosY D
      // 054: dsub
      // 055: dstore 7
      // 057: aload 1
      // 058: bipush 0
      // 059: aaload
      // 05a: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 05d: i2d
      // 05e: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 061: invokevirtual net/minecraft/client/Minecraft.getRenderManager ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 064: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosZ D
      // 067: dsub
      // 068: dstore 9
      // 06a: ldc_w -1465471887
      // 06d: ldc_w -1465471117
      // 070: ixor
      // 071: ldc_w -1465471888
      // 074: ldc_w -1465471117
      // 077: ixor
      // 078: invokestatic org/lwjgl/opengl/GL11.glBlendFunc (II)V
      // 07b: ldc_w -1465473903
      // 07e: ldc_w -1465471117
      // 081: ixor
      // 082: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 085: fconst_2
      // 086: invokestatic org/lwjgl/opengl/GL11.glLineWidth (F)V
      // 089: ldc_w -1465474414
      // 08c: ldc_w -1465471117
      // 08f: ixor
      // 090: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 093: ldc_w -1465474046
      // 096: ldc_w -1465471117
      // 099: ixor
      // 09a: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 09d: bipush 0
      // 09e: invokestatic org/lwjgl/opengl/GL11.glDepthMask (Z)V
      // 0a1: aload 0
      // 0a2: invokevirtual x/occa6aba7d1a.ʩ ()I
      // 0a5: istore 11
      // 0a7: iload 11
      // 0a9: ldc_w -1465471125
      // 0ac: ldc_w -1465471117
      // 0af: ixor
      // 0b0: ishr
      // 0b1: ldc_w -1465471092
      // 0b4: ldc_w -1465471117
      // 0b7: ixor
      // 0b8: iand
      // 0b9: i2f
      // 0ba: ldc_w 255.0
      // 0bd: fdiv
      // 0be: fstore 12
      // 0c0: iload 11
      // 0c2: ldc_w -1465471133
      // 0c5: ldc_w -1465471117
      // 0c8: ixor
      // 0c9: ishr
      // 0ca: ldc_w -1465471092
      // 0cd: ldc_w -1465471117
      // 0d0: ixor
      // 0d1: iand
      // 0d2: i2f
      // 0d3: ldc_w 255.0
      // 0d6: fdiv
      // 0d7: fstore 13
      // 0d9: iload 11
      // 0db: ldc_w -1465471109
      // 0de: ldc_w -1465471117
      // 0e1: ixor
      // 0e2: ishr
      // 0e3: ldc_w -1465471092
      // 0e6: ldc_w -1465471117
      // 0e9: ixor
      // 0ea: iand
      // 0eb: i2f
      // 0ec: ldc_w 255.0
      // 0ef: fdiv
      // 0f0: fstore 14
      // 0f2: iload 11
      // 0f4: ldc_w -1465471092
      // 0f7: ldc_w -1465471117
      // 0fa: ixor
      // 0fb: iand
      // 0fc: i2f
      // 0fd: ldc_w 255.0
      // 100: fdiv
      // 101: fstore 15
      // 103: fload 13
      // 105: f2d
      // 106: fload 14
      // 108: f2d
      // 109: fload 15
      // 10b: f2d
      // 10c: fload 12
      // 10e: f2d
      // 10f: invokestatic org/lwjgl/opengl/GL11.glColor4d (DDDD)V
      // 112: aload 1
      // 113: bipush 0
      // 114: iload 3
      // 115: ifne 186
      // 118: aaload
      // 119: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 11c: aload 1
      // 11d: bipush 1
      // 11e: aaload
      // 11f: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 122: if_icmpeq 180
      // 125: goto 129
      // 128: athrow
      // 129: aload 1
      // 12a: bipush 0
      // 12b: aaload
      // 12c: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 12f: aload 1
      // 130: bipush 1
      // 131: aaload
      // 132: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 135: if_icmple 15e
      // 138: goto 13c
      // 13b: athrow
      // 13c: new net/minecraft/util/AxisAlignedBB
      // 13f: dup
      // 140: dload 5
      // 142: dconst_1
      // 143: dsub
      // 144: dload 7
      // 146: dload 9
      // 148: dload 5
      // 14a: dconst_1
      // 14b: dadd
      // 14c: dload 7
      // 14e: fload 2
      // 14f: f2d
      // 150: dadd
      // 151: dload 9
      // 153: dconst_1
      // 154: dadd
      // 155: invokespecial net/minecraft/util/AxisAlignedBB.<init> (DDDDDD)V
      // 158: astore 16
      // 15a: iload 3
      // 15b: ifeq 1d3
      // 15e: new net/minecraft/util/AxisAlignedBB
      // 161: dup
      // 162: dload 5
      // 164: dload 7
      // 166: dload 9
      // 168: dload 5
      // 16a: ldc2_w 2.0
      // 16d: dadd
      // 16e: dload 7
      // 170: fload 2
      // 171: f2d
      // 172: dadd
      // 173: dload 9
      // 175: dconst_1
      // 176: dadd
      // 177: invokespecial net/minecraft/util/AxisAlignedBB.<init> (DDDDDD)V
      // 17a: astore 16
      // 17c: iload 3
      // 17d: ifeq 1d3
      // 180: aload 1
      // 181: bipush 0
      // 182: goto 186
      // 185: athrow
      // 186: aaload
      // 187: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 18a: aload 1
      // 18b: bipush 1
      // 18c: aaload
      // 18d: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 190: if_icmple 1b5
      // 193: new net/minecraft/util/AxisAlignedBB
      // 196: dup
      // 197: dload 5
      // 199: dload 7
      // 19b: dload 9
      // 19d: dconst_1
      // 19e: dsub
      // 19f: dload 5
      // 1a1: dconst_1
      // 1a2: dadd
      // 1a3: dload 7
      // 1a5: fload 2
      // 1a6: f2d
      // 1a7: dadd
      // 1a8: dload 9
      // 1aa: dconst_1
      // 1ab: dadd
      // 1ac: invokespecial net/minecraft/util/AxisAlignedBB.<init> (DDDDDD)V
      // 1af: astore 16
      // 1b1: iload 3
      // 1b2: ifeq 1d3
      // 1b5: new net/minecraft/util/AxisAlignedBB
      // 1b8: dup
      // 1b9: dload 5
      // 1bb: dload 7
      // 1bd: dload 9
      // 1bf: dload 5
      // 1c1: dconst_1
      // 1c2: dadd
      // 1c3: dload 7
      // 1c5: fload 2
      // 1c6: f2d
      // 1c7: dadd
      // 1c8: dload 9
      // 1ca: ldc2_w 2.0
      // 1cd: dadd
      // 1ce: invokespecial net/minecraft/util/AxisAlignedBB.<init> (DDDDDD)V
      // 1d1: astore 16
      // 1d3: aload 16
      // 1d5: fload 13
      // 1d7: fload 14
      // 1d9: fload 15
      // 1db: fload 12
      // 1dd: invokestatic x/ocbd4917c4b1.ʓ (Lnet/minecraft/util/AxisAlignedBB;FFFF)V
      // 1e0: iload 3
      // 1e1: ifne 295
      // 1e4: iload 4
      // 1e6: ifeq 26c
      // 1e9: goto 1ed
      // 1ec: athrow
      // 1ed: aload 0
      // 1ee: getfield x/occa6aba7d1a.Ї Lx/oc24a0a5bddf;
      // 1f1: invokevirtual x/oc24a0a5bddf.ͳ ()I
      // 1f4: istore 17
      // 1f6: iload 17
      // 1f8: ldc_w -1465471125
      // 1fb: ldc_w -1465471117
      // 1fe: ixor
      // 1ff: ishr
      // 200: ldc_w -1465471092
      // 203: ldc_w -1465471117
      // 206: ixor
      // 207: iand
      // 208: i2f
      // 209: ldc_w 255.0
      // 20c: fdiv
      // 20d: fstore 18
      // 20f: iload 17
      // 211: ldc_w -1465471133
      // 214: ldc_w -1465471117
      // 217: ixor
      // 218: ishr
      // 219: ldc_w -1465471092
      // 21c: ldc_w -1465471117
      // 21f: ixor
      // 220: iand
      // 221: i2f
      // 222: ldc_w 255.0
      // 225: fdiv
      // 226: fstore 19
      // 228: iload 17
      // 22a: ldc_w -1465471109
      // 22d: ldc_w -1465471117
      // 230: ixor
      // 231: ishr
      // 232: ldc_w -1465471092
      // 235: ldc_w -1465471117
      // 238: ixor
      // 239: iand
      // 23a: i2f
      // 23b: ldc_w 255.0
      // 23e: fdiv
      // 23f: fstore 20
      // 241: iload 17
      // 243: ldc_w -1465471092
      // 246: ldc_w -1465471117
      // 249: ixor
      // 24a: iand
      // 24b: i2f
      // 24c: ldc_w 255.0
      // 24f: fdiv
      // 250: fstore 21
      // 252: ldc_w 3.0
      // 255: invokestatic org/lwjgl/opengl/GL11.glLineWidth (F)V
      // 258: fload 19
      // 25a: fload 20
      // 25c: fload 21
      // 25e: fload 18
      // 260: invokestatic org/lwjgl/opengl/GL11.glColor4f (FFFF)V
      // 263: aload 16
      // 265: invokestatic net/minecraft/client/renderer/RenderGlobal.drawSelectionBoundingBox (Lnet/minecraft/util/AxisAlignedBB;)V
      // 268: fconst_2
      // 269: invokestatic org/lwjgl/opengl/GL11.glLineWidth (F)V
      // 26c: fconst_1
      // 26d: fconst_1
      // 26e: fconst_1
      // 26f: fconst_1
      // 270: invokestatic org/lwjgl/opengl/GL11.glColor4f (FFFF)V
      // 273: ldc_w -1465474414
      // 276: ldc_w -1465471117
      // 279: ixor
      // 27a: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 27d: ldc_w -1465474046
      // 280: ldc_w -1465471117
      // 283: ixor
      // 284: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 287: bipush 1
      // 288: invokestatic org/lwjgl/opengl/GL11.glDepthMask (Z)V
      // 28b: ldc_w -1465473903
      // 28e: ldc_w -1465471117
      // 291: ixor
      // 292: invokestatic org/lwjgl/opengl/GL11.glDisable (I)V
      // 295: return
   }

   private boolean ʍ(BlockPos[] param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: istore 2
      // 04: aload 1
      // 05: iload 2
      // 06: ifne 11
      // 09: ifnull 31
      // 0c: goto 10
      // 0f: athrow
      // 10: aload 1
      // 11: arraylength
      // 12: iload 2
      // 13: ifne 36
      // 16: ldc_w 1423687643
      // 19: ldc_w 1423687641
      // 1c: ixor
      // 1d: if_icmplt 31
      // 20: goto 24
      // 23: athrow
      // 24: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 27: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 2a: ifnonnull 37
      // 2d: goto 31
      // 30: athrow
      // 31: bipush 0
      // 32: goto 36
      // 35: athrow
      // 36: ireturn
      // 37: aload 1
      // 38: astore 3
      // 39: aload 3
      // 3a: arraylength
      // 3b: istore 4
      // 3d: bipush 0
      // 3e: istore 5
      // 40: iload 5
      // 42: iload 4
      // 44: if_icmpge ac
      // 47: aload 3
      // 48: iload 5
      // 4a: aaload
      // 4b: astore 6
      // 4d: invokestatic net/minecraft/util/EnumFacing.values ()[Lnet/minecraft/util/EnumFacing;
      // 50: astore 7
      // 52: aload 7
      // 54: arraylength
      // 55: iload 2
      // 56: ifne ad
      // 59: istore 8
      // 5b: bipush 0
      // 5c: istore 9
      // 5e: iload 9
      // 60: iload 8
      // 62: if_icmpge a5
      // 65: aload 7
      // 67: iload 9
      // 69: aaload
      // 6a: astore 10
      // 6c: aload 6
      // 6e: aload 10
      // 70: invokevirtual net/minecraft/util/BlockPos.offset (Lnet/minecraft/util/EnumFacing;)Lnet/minecraft/util/BlockPos;
      // 73: iload 2
      // 74: ifne 4b
      // 77: astore 11
      // 79: iload 2
      // 7a: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 7d: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 80: aload 11
      // 82: invokevirtual net/minecraft/client/multiplayer/WorldClient.getBlockState (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // 85: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 8a: astore 12
      // 8c: ifne a1
      // 8f: aload 12
      // 91: getstatic net/minecraft/init/Blocks.air Lnet/minecraft/block/Block;
      // 94: if_acmpne 9e
      // 97: goto 9b
      // 9a: athrow
      // 9b: bipush 1
      // 9c: ireturn
      // 9d: athrow
      // 9e: iinc 9 1
      // a1: iload 2
      // a2: ifeq 5e
      // a5: iinc 5 1
      // a8: iload 2
      // a9: ifeq 40
      // ac: bipush 0
      // ad: ireturn
   }

   private void Ş(BlockPos[] param1, float param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oce6044968f8.ђ Z
      // 003: aload 0
      // 004: getfield x/occa6aba7d1a.ֆ Ljava/util/Map;
      // 007: aload 1
      // 008: bipush 0
      // 009: aaload
      // 00a: invokevirtual net/minecraft/util/BlockPos.toLong ()J
      // 00d: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 010: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 015: checkcast x/ocecae709e0b
      // 018: astore 4
      // 01a: istore 3
      // 01b: aload 4
      // 01d: iload 3
      // 01e: ifne 02a
      // 021: ifnull 04c
      // 024: goto 028
      // 027: athrow
      // 028: aload 4
      // 02a: iload 3
      // 02b: ifne 041
      // 02e: aload 1
      // 02f: bipush 1
      // 030: aaload
      // 031: invokevirtual x/ocecae709e0b.Đ (Lnet/minecraft/util/BlockPos;)Z
      // 034: ifeq 04c
      // 037: goto 03b
      // 03a: athrow
      // 03b: aload 4
      // 03d: goto 041
      // 040: athrow
      // 041: getfield x/ocecae709e0b.փ Ljava/util/List;
      // 044: invokeinterface java/util/List.isEmpty ()Z 1
      // 049: ifeq 04e
      // 04c: return
      // 04d: athrow
      // 04e: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 051: invokevirtual net/minecraft/client/Minecraft.getRenderManager ()Lnet/minecraft/client/renderer/entity/RenderManager;
      // 054: astore 5
      // 056: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 059: getfield net/minecraft/client/Minecraft.fontRendererObj Lnet/minecraft/client/gui/FontRenderer;
      // 05c: astore 6
      // 05e: aload 5
      // 060: ifnull 06c
      // 063: aload 6
      // 065: ifnonnull 06e
      // 068: goto 06c
      // 06b: athrow
      // 06c: return
      // 06d: athrow
      // 06e: aload 1
      // 06f: bipush 0
      // 070: aaload
      // 071: aload 1
      // 072: bipush 1
      // 073: aaload
      // 074: fload 2
      // 075: invokestatic x/occa6aba7d1a.M (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/BlockPos;F)Lnet/minecraft/util/AxisAlignedBB;
      // 078: astore 7
      // 07a: aload 7
      // 07c: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 07f: aload 7
      // 081: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 084: dadd
      // 085: ldc2_w 0.5
      // 088: dmul
      // 089: aload 5
      // 08b: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosX D
      // 08e: dsub
      // 08f: dstore 8
      // 091: aload 7
      // 093: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 096: aload 0
      // 097: getfield x/occa6aba7d1a.Ѐ Lx/oca9cc61aada;
      // 09a: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 09d: dadd
      // 09e: aload 5
      // 0a0: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosY D
      // 0a3: dsub
      // 0a4: dstore 10
      // 0a6: aload 7
      // 0a8: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 0ab: aload 7
      // 0ad: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 0b0: dadd
      // 0b1: ldc2_w 0.5
      // 0b4: dmul
      // 0b5: aload 5
      // 0b7: getfield net/minecraft/client/renderer/entity/RenderManager.viewerPosZ D
      // 0ba: dsub
      // 0bb: dstore 12
      // 0bd: aload 0
      // 0be: invokevirtual x/occa6aba7d1a.ĥ ()F
      // 0c1: fstore 14
      // 0c3: aload 0
      // 0c4: getfield x/occa6aba7d1a.Ý Lx/occ2f8dff8d8;
      // 0c7: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 0ca: ifeq 0ec
      // 0cd: dload 8
      // 0cf: dload 8
      // 0d1: dmul
      // 0d2: dload 10
      // 0d4: dload 10
      // 0d6: dmul
      // 0d7: dadd
      // 0d8: dload 12
      // 0da: dload 12
      // 0dc: dmul
      // 0dd: dadd
      // 0de: invokestatic java/lang/Math.sqrt (D)D
      // 0e1: d2f
      // 0e2: fstore 15
      // 0e4: aload 0
      // 0e5: fload 15
      // 0e7: invokevirtual x/occa6aba7d1a.ĺ (F)F
      // 0ea: fstore 14
      // 0ec: aload 4
      // 0ee: getfield x/ocecae709e0b.փ Ljava/util/List;
      // 0f1: astore 15
      // 0f3: aload 15
      // 0f5: invokeinterface java/util/List.size ()I 1
      // 0fa: ldc_w 186770513
      // 0fd: ldc_w 186770499
      // 100: ixor
      // 101: imul
      // 102: ldc_w 186770497
      // 105: ldc_w 186770499
      // 108: ixor
      // 109: isub
      // 10a: istore 16
      // 10c: iload 16
      // 10e: ineg
      // 10f: ldc_w 186770497
      // 112: ldc_w 186770499
      // 115: ixor
      // 116: idiv
      // 117: istore 17
      // 119: ldc_w -186770501
      // 11c: ldc_w 186770499
      // 11f: ixor
      // 120: istore 18
      // 122: iload 17
      // 124: ldc_w 186770496
      // 127: ldc_w 186770499
      // 12a: ixor
      // 12b: isub
      // 12c: istore 19
      // 12e: iload 18
      // 130: ldc_w 186770496
      // 133: ldc_w 186770499
      // 136: ixor
      // 137: isub
      // 138: istore 20
      // 13a: iload 17
      // 13c: iload 16
      // 13e: iadd
      // 13f: ldc_w 186770496
      // 142: ldc_w 186770499
      // 145: ixor
      // 146: iadd
      // 147: istore 21
      // 149: iload 18
      // 14b: ldc_w 186770515
      // 14e: ldc_w 186770499
      // 151: ixor
      // 152: iadd
      // 153: ldc_w 186770496
      // 156: ldc_w 186770499
      // 159: ixor
      // 15a: iadd
      // 15b: istore 22
      // 15d: invokestatic net/minecraft/client/renderer/GlStateManager.pushMatrix ()V
      // 160: dload 8
      // 162: d2f
      // 163: dload 10
      // 165: d2f
      // 166: dload 12
      // 168: d2f
      // 169: invokestatic net/minecraft/client/renderer/GlStateManager.translate (FFF)V
      // 16c: aload 5
      // 16e: getfield net/minecraft/client/renderer/entity/RenderManager.playerViewY F
      // 171: fneg
      // 172: fconst_0
      // 173: fconst_1
      // 174: fconst_0
      // 175: invokestatic net/minecraft/client/renderer/GlStateManager.rotate (FFFF)V
      // 178: aload 5
      // 17a: getfield net/minecraft/client/renderer/entity/RenderManager.playerViewX F
      // 17d: fconst_1
      // 17e: fconst_0
      // 17f: fconst_0
      // 180: invokestatic net/minecraft/client/renderer/GlStateManager.rotate (FFFF)V
      // 183: fload 14
      // 185: fneg
      // 186: fload 14
      // 188: fneg
      // 189: fload 14
      // 18b: invokestatic net/minecraft/client/renderer/GlStateManager.scale (FFF)V
      // 18e: invokestatic net/minecraft/client/renderer/GlStateManager.disableLighting ()V
      // 191: bipush 0
      // 192: invokestatic net/minecraft/client/renderer/GlStateManager.depthMask (Z)V
      // 195: invokestatic net/minecraft/client/renderer/GlStateManager.disableDepth ()V
      // 198: invokestatic net/minecraft/client/renderer/GlStateManager.enableBlend ()V
      // 19b: ldc_w 186771265
      // 19e: ldc_w 186770499
      // 1a1: ixor
      // 1a2: ldc_w 186771264
      // 1a5: ldc_w 186770499
      // 1a8: ixor
      // 1a9: bipush 1
      // 1aa: bipush 0
      // 1ab: invokestatic net/minecraft/client/renderer/GlStateManager.tryBlendFuncSeparate (IIII)V
      // 1ae: aload 0
      // 1af: iload 19
      // 1b1: iload 20
      // 1b3: iload 21
      // 1b5: iload 22
      // 1b7: invokevirtual x/occa6aba7d1a.Â (IIII)V
      // 1ba: aload 0
      // 1bb: invokevirtual x/occa6aba7d1a.Ԃ ()V
      // 1be: bipush 0
      // 1bf: istore 23
      // 1c1: iload 23
      // 1c3: aload 15
      // 1c5: invokeinterface java/util/List.size ()I 1
      // 1ca: if_icmpge 283
      // 1cd: aload 15
      // 1cf: iload 23
      // 1d1: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 1d6: checkcast x/oc8c33630684
      // 1d9: astore 24
      // 1db: iload 3
      // 1dc: iload 17
      // 1de: iload 23
      // 1e0: ldc_w 186770513
      // 1e3: ldc_w 186770499
      // 1e6: ixor
      // 1e7: imul
      // 1e8: iadd
      // 1e9: istore 25
      // 1eb: aload 0
      // 1ec: aload 24
      // 1ee: iload 25
      // 1f0: iload 18
      // 1f2: invokevirtual x/occa6aba7d1a.ȹ (Lx/oc8c33630684;II)V
      // 1f5: ifne 2ce
      // 1f8: iload 3
      // 1f9: ifne 27f
      // 1fc: goto 200
      // 1ff: athrow
      // 200: aload 0
      // 201: invokevirtual x/occa6aba7d1a.Ԃ ()V
      // 204: aload 0
      // 205: getfield x/occa6aba7d1a.ƥ Lx/occ2f8dff8d8;
      // 208: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 20b: ifne 27c
      // 20e: goto 212
      // 211: athrow
      // 212: aload 0
      // 213: getfield x/occa6aba7d1a.ă Lx/occ2f8dff8d8;
      // 216: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 219: iload 3
      // 21a: ifne 239
      // 21d: goto 221
      // 220: athrow
      // 221: ifeq 27c
      // 224: goto 228
      // 227: athrow
      // 228: aload 24
      // 22a: iload 3
      // 22b: ifne 243
      // 22e: goto 232
      // 231: athrow
      // 232: getfield x/oc8c33630684.Ӝ I
      // 235: goto 239
      // 238: athrow
      // 239: bipush 1
      // 23a: if_icmple 27c
      // 23d: aload 24
      // 23f: goto 243
      // 242: athrow
      // 243: invokevirtual x/oc8c33630684.Ɔ ()I
      // 246: invokestatic java/lang/String.valueOf (I)Ljava/lang/String;
      // 249: astore 26
      // 24b: aload 6
      // 24d: aload 26
      // 24f: iload 25
      // 251: ldc_w 186770514
      // 254: ldc_w 186770499
      // 257: ixor
      // 258: iadd
      // 259: aload 6
      // 25b: aload 26
      // 25d: invokevirtual net/minecraft/client/gui/FontRenderer.getStringWidth (Ljava/lang/String;)I
      // 260: isub
      // 261: i2f
      // 262: iload 18
      // 264: ldc_w 186770506
      // 267: ldc_w 186770499
      // 26a: ixor
      // 26b: iadd
      // 26c: i2f
      // 26d: ldc_w 199105468
      // 270: ldc_w 186770499
      // 273: ixor
      // 274: invokevirtual net/minecraft/client/gui/FontRenderer.drawStringWithShadow (Ljava/lang/String;FFI)I
      // 277: pop
      // 278: aload 0
      // 279: invokevirtual x/occa6aba7d1a.Ԃ ()V
      // 27c: iinc 23 1
      // 27f: iload 3
      // 280: ifeq 1c1
      // 283: invokestatic net/minecraft/client/renderer/GlStateManager.enableDepth ()V
      // 286: bipush 1
      // 287: invokestatic net/minecraft/client/renderer/GlStateManager.depthMask (Z)V
      // 28a: invokestatic net/minecraft/client/renderer/GlStateManager.disableLighting ()V
      // 28d: invokestatic net/minecraft/client/renderer/GlStateManager.disableRescaleNormal ()V
      // 290: invokestatic net/minecraft/client/renderer/GlStateManager.disableBlend ()V
      // 293: invokestatic net/minecraft/client/renderer/GlStateManager.enableAlpha ()V
      // 296: invokestatic net/minecraft/client/renderer/GlStateManager.enableTexture2D ()V
      // 299: ldc_w 186771265
      // 29c: ldc_w 186770499
      // 29f: ixor
      // 2a0: ldc_w 186771264
      // 2a3: ldc_w 186770499
      // 2a6: ixor
      // 2a7: bipush 1
      // 2a8: bipush 0
      // 2a9: invokestatic net/minecraft/client/renderer/GlStateManager.tryBlendFuncSeparate (IIII)V
      // 2ac: ldc_w 186763075
      // 2af: ldc_w 186770499
      // 2b2: ixor
      // 2b3: ldc_w 186762819
      // 2b6: ldc_w 186770499
      // 2b9: ixor
      // 2ba: ldc_w 186762563
      // 2bd: ldc_w 186770499
      // 2c0: ixor
      // 2c1: invokestatic org/lwjgl/opengl/GL11.glTexEnvi (III)V
      // 2c4: fconst_1
      // 2c5: fconst_1
      // 2c6: fconst_1
      // 2c7: fconst_1
      // 2c8: invokestatic net/minecraft/client/renderer/GlStateManager.color (FFFF)V
      // 2cb: invokestatic net/minecraft/client/renderer/GlStateManager.popMatrix ()V
      // 2ce: goto 321
      // 2d1: astore 27
      // 2d3: invokestatic net/minecraft/client/renderer/GlStateManager.enableDepth ()V
      // 2d6: bipush 1
      // 2d7: invokestatic net/minecraft/client/renderer/GlStateManager.depthMask (Z)V
      // 2da: invokestatic net/minecraft/client/renderer/GlStateManager.disableLighting ()V
      // 2dd: invokestatic net/minecraft/client/renderer/GlStateManager.disableRescaleNormal ()V
      // 2e0: invokestatic net/minecraft/client/renderer/GlStateManager.disableBlend ()V
      // 2e3: invokestatic net/minecraft/client/renderer/GlStateManager.enableAlpha ()V
      // 2e6: invokestatic net/minecraft/client/renderer/GlStateManager.enableTexture2D ()V
      // 2e9: ldc_w 186771265
      // 2ec: ldc_w 186770499
      // 2ef: ixor
      // 2f0: ldc_w 186771264
      // 2f3: ldc_w 186770499
      // 2f6: ixor
      // 2f7: bipush 1
      // 2f8: bipush 0
      // 2f9: invokestatic net/minecraft/client/renderer/GlStateManager.tryBlendFuncSeparate (IIII)V
      // 2fc: ldc_w 186763075
      // 2ff: ldc_w 186770499
      // 302: ixor
      // 303: ldc_w 186762819
      // 306: ldc_w 186770499
      // 309: ixor
      // 30a: ldc_w 186762563
      // 30d: ldc_w 186770499
      // 310: ixor
      // 311: invokestatic org/lwjgl/opengl/GL11.glTexEnvi (III)V
      // 314: fconst_1
      // 315: fconst_1
      // 316: fconst_1
      // 317: fconst_1
      // 318: invokestatic net/minecraft/client/renderer/GlStateManager.color (FFFF)V
      // 31b: invokestatic net/minecraft/client/renderer/GlStateManager.popMatrix ()V
      // 31e: aload 27
      // 320: athrow
      // 321: return
   }

   private void ȹ(oc8c33630684 param1, int param2, int param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: istore 4
      // 05: aload 1
      // 06: iload 4
      // 08: ifne 14
      // 0b: ifnonnull 13
      // 0e: goto 12
      // 11: athrow
      // 12: return
      // 13: aload 1
      // 14: iload 4
      // 16: ifne 2f
      // 19: invokevirtual x/oc8c33630684.ȋ ()Z
      // 1c: ifeq 2e
      // 1f: goto 23
      // 22: athrow
      // 23: aload 1
      // 24: getfield x/oc8c33630684.ƛ Lnet/minecraft/item/ItemStack;
      // 27: iload 2
      // 28: iload 3
      // 29: invokestatic x/ocbd4917c4b1.Ӱ (Lnet/minecraft/item/ItemStack;II)V
      // 2c: return
      // 2d: athrow
      // 2e: aload 1
      // 2f: invokevirtual x/oc8c33630684.ν ()Z
      // 32: ifeq 43
      // 35: aload 0
      // 36: aload 1
      // 37: getfield x/oc8c33630684.ã Lnet/minecraft/client/renderer/texture/TextureAtlasSprite;
      // 3a: iload 2
      // 3b: iload 3
      // 3c: invokevirtual x/occa6aba7d1a.ϔ (Lnet/minecraft/client/renderer/texture/TextureAtlasSprite;II)V
      // 3f: goto 43
      // 42: athrow
      // 43: return
   }

   private void ϔ(TextureAtlasSprite var1, int var2, int var3) {
      try {
         if (var1 == null) {
            return;
         }
      } catch (ocbde1165e4e var6) {
         throw var6;
      }

      oc69da1aa7f5.ő.getTextureManager().bindTexture(TextureMap.locationBlocksTexture);
      GlStateManager.enableTexture2D();
      GlStateManager.enableBlend();
      GlStateManager.enableAlpha();
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      Tessellator var4 = Tessellator.getInstance();
      WorldRenderer var5 = var4.getWorldRenderer();
      var5.begin(-718578119 ^ -718578114, DefaultVertexFormats.POSITION_TEX);
      var5.pos(var2, var3 + (-718578130 ^ -718578114), 0.0).tex(var1.getMinU(), var1.getMaxV()).endVertex();
      var5.pos(var2 + (-718578130 ^ -718578114), var3 + (-718578130 ^ -718578114), 0.0).tex(var1.getMaxU(), var1.getMaxV()).endVertex();
      var5.pos(var2 + (-718578130 ^ -718578114), var3, 0.0).tex(var1.getMaxU(), var1.getMinV()).endVertex();
      var5.pos(var2, var3, 0.0).tex(var1.getMinU(), var1.getMinV()).endVertex();
      var4.draw();
   }

   private void Â(int var1, int var2, int var3, int var4) {
      ocbd4917c4b1.Т(var1, var2, var3, var4, 8.0F, 1413542461 ^ 658567741, -1321143747 ^ 658567741, -1321143747 ^ 658567741);
   }

   private void Ԃ() {
      GlStateManager.disableLighting();
      GlStateManager.disableDepth();
      GlStateManager.depthMask(false);
      GlStateManager.enableTexture2D();
      GlStateManager.enableAlpha();
      GlStateManager.alphaFunc(476904307 ^ 476903799, 0.1F);
      GlStateManager.enableBlend();
      GlStateManager.tryBlendFuncSeparate(476904053 ^ 476903799, 476904052 ^ 476903799, 1, 0);
      GL11.glTexEnvi(476895863 ^ 476903799, 476896119 ^ 476903799, 476895351 ^ 476903799);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
   }

   private ocecae709e0b Ҝ(BlockPos param1, BlockPos param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 000: getstatic x/oce6044968f8.ђ Z
      // 003: aload 0
      // 004: aload 1
      // 005: aload 2
      // 006: invokevirtual x/occa6aba7d1a.ү (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/BlockPos;)[Lx/occfa28f796b;
      // 009: astore 4
      // 00b: istore 3
      // 00c: aload 4
      // 00e: ifnonnull 025
      // 011: new x/ocecae709e0b
      // 014: dup
      // 015: new net/minecraft/util/BlockPos
      // 018: dup
      // 019: aload 2
      // 01a: invokespecial net/minecraft/util/BlockPos.<init> (Lnet/minecraft/util/Vec3i;)V
      // 01d: invokestatic java/util/Collections.emptyList ()Ljava/util/List;
      // 020: invokespecial x/ocecae709e0b.<init> (Lnet/minecraft/util/BlockPos;Ljava/util/List;)V
      // 023: areturn
      // 024: athrow
      // 025: new java/util/HashMap
      // 028: dup
      // 029: invokespecial java/util/HashMap.<init> ()V
      // 02c: astore 5
      // 02e: new java/util/HashMap
      // 031: dup
      // 032: invokespecial java/util/HashMap.<init> ()V
      // 035: astore 6
      // 037: bipush 0
      // 038: istore 7
      // 03a: new net/minecraft/util/BlockPos$MutableBlockPos
      // 03d: dup
      // 03e: invokespecial net/minecraft/util/BlockPos$MutableBlockPos.<init> ()V
      // 041: astore 8
      // 043: aload 4
      // 045: astore 9
      // 047: aload 9
      // 049: arraylength
      // 04a: istore 10
      // 04c: bipush 0
      // 04d: istore 11
      // 04f: iload 11
      // 051: iload 10
      // 053: if_icmpge 1ac
      // 056: aload 9
      // 058: iload 11
      // 05a: aaload
      // 05b: astore 12
      // 05d: iload 3
      // 05e: new java/util/HashMap
      // 061: dup
      // 062: invokespecial java/util/HashMap.<init> ()V
      // 065: astore 13
      // 067: ifne 295
      // 06a: bipush 0
      // 06b: istore 14
      // 06d: bipush 0
      // 06e: istore 15
      // 070: aload 12
      // 072: getfield x/occfa28f796b.ǆ Ljava/util/List;
      // 075: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 07a: astore 16
      // 07c: aload 16
      // 07e: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 083: ifeq 0d9
      // 086: aload 16
      // 088: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 08d: iload 3
      // 08e: ifne 148
      // 091: checkcast x/occ1dd5eec49
      // 094: astore 17
      // 096: iload 3
      // 097: ifne 0d5
      // 09a: aload 8
      // 09c: aload 1
      // 09d: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 0a0: aload 17
      // 0a2: getfield x/occ1dd5eec49.ʇ I
      // 0a5: iadd
      // 0a6: aload 1
      // 0a7: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 0aa: aload 17
      // 0ac: getfield x/occ1dd5eec49.ħ I
      // 0af: iadd
      // 0b0: aload 1
      // 0b1: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 0b4: aload 17
      // 0b6: getfield x/occ1dd5eec49.Ĳ I
      // 0b9: iadd
      // 0ba: invokevirtual net/minecraft/util/BlockPos$MutableBlockPos.set (III)Lnet/minecraft/util/BlockPos$MutableBlockPos;
      // 0bd: pop
      // 0be: aload 0
      // 0bf: aload 8
      // 0c1: aload 13
      // 0c3: aload 6
      // 0c5: invokevirtual x/occa6aba7d1a.Ơ (Lnet/minecraft/util/BlockPos;Ljava/util/Map;Ljava/util/Map;)Z
      // 0c8: ifeq 0d2
      // 0cb: iinc 15 1
      // 0ce: goto 0d2
      // 0d1: athrow
      // 0d2: iinc 14 1
      // 0d5: iload 3
      // 0d6: ifeq 07c
      // 0d9: iload 14
      // 0db: iload 3
      // 0dc: ifne 110
      // 0df: ifeq 0ff
      // 0e2: goto 0e6
      // 0e5: athrow
      // 0e6: iload 15
      // 0e8: iload 3
      // 0e9: ifne 127
      // 0ec: goto 0f0
      // 0ef: athrow
      // 0f0: i2f
      // 0f1: iload 14
      // 0f3: i2f
      // 0f4: fdiv
      // 0f5: ldc 0.2
      // 0f7: fcmpl
      // 0f8: ifle 122
      // 0fb: goto 0ff
      // 0fe: athrow
      // 0ff: iinc 7 1
      // 102: iload 3
      // 103: ifne 1a8
      // 106: goto 10a
      // 109: athrow
      // 10a: iload 7
      // 10c: goto 110
      // 10f: athrow
      // 110: ldc_w 1395255553
      // 113: ldc_w 1395255555
      // 116: ixor
      // 117: if_icmplt 1a5
      // 11a: iload 3
      // 11b: ifeq 1ac
      // 11e: goto 122
      // 121: athrow
      // 122: bipush 0
      // 123: goto 127
      // 126: athrow
      // 127: istore 7
      // 129: aload 13
      // 12b: invokeinterface java/util/Map.entrySet ()Ljava/util/Set; 1
      // 130: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 135: astore 16
      // 137: aload 16
      // 139: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 13e: ifeq 1a5
      // 141: aload 16
      // 143: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 148: checkcast java/util/Map$Entry
      // 14b: iload 3
      // 14c: ifne 091
      // 14f: astore 17
      // 151: aload 17
      // 153: invokeinterface java/util/Map$Entry.getValue ()Ljava/lang/Object; 1
      // 158: checkcast java/lang/Integer
      // 15b: invokevirtual java/lang/Integer.intValue ()I
      // 15e: istore 18
      // 160: iload 18
      // 162: i2f
      // 163: iload 14
      // 165: i2f
      // 166: fdiv
      // 167: ldc 0.2
      // 169: fcmpl
      // 16a: iflt 1a1
      // 16d: aload 5
      // 16f: aload 17
      // 171: invokeinterface java/util/Map$Entry.getKey ()Ljava/lang/Object; 1
      // 176: checkcast x/oc627b93cac9
      // 179: aload 5
      // 17b: aload 17
      // 17d: invokeinterface java/util/Map$Entry.getKey ()Ljava/lang/Object; 1
      // 182: bipush 0
      // 183: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 186: invokeinterface java/util/Map.getOrDefault (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 18b: checkcast java/lang/Integer
      // 18e: invokevirtual java/lang/Integer.intValue ()I
      // 191: iload 18
      // 193: iadd
      // 194: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 197: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 19c: pop
      // 19d: goto 1a1
      // 1a0: athrow
      // 1a1: iload 3
      // 1a2: ifeq 137
      // 1a5: iinc 11 1
      // 1a8: iload 3
      // 1a9: ifeq 04f
      // 1ac: aload 0
      // 1ad: getfield x/occa6aba7d1a.ƥ Lx/occ2f8dff8d8;
      // 1b0: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 1b3: ifeq 295
      // 1b6: new java/util/HashSet
      // 1b9: dup
      // 1ba: invokespecial java/util/HashSet.<init> ()V
      // 1bd: astore 10
      // 1bf: aload 5
      // 1c1: invokeinterface java/util/Map.keySet ()Ljava/util/Set; 1
      // 1c6: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 1cb: astore 11
      // 1cd: aload 11
      // 1cf: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 1d4: ifeq 20c
      // 1d7: aload 11
      // 1d9: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 1de: checkcast x/oc627b93cac9
      // 1e1: astore 12
      // 1e3: iload 3
      // 1e4: aload 12
      // 1e6: getfield x/oc627b93cac9.Ϟ Lnet/minecraft/block/state/IBlockState;
      // 1e9: invokestatic x/oc0745e01074.Ƥ (Lnet/minecraft/block/state/IBlockState;)Lx/oc0745e01074;
      // 1ec: astore 13
      // 1ee: ifne 230
      // 1f1: aload 13
      // 1f3: ifnull 208
      // 1f6: goto 1fa
      // 1f9: athrow
      // 1fa: aload 10
      // 1fc: aload 13
      // 1fe: invokeinterface java/util/Set.add (Ljava/lang/Object;)Z 2
      // 203: pop
      // 204: goto 208
      // 207: athrow
      // 208: iload 3
      // 209: ifeq 1cd
      // 20c: aload 10
      // 20e: iload 3
      // 20f: ifne 227
      // 212: getstatic x/oc0745e01074.ɩ Lx/oc0745e01074;
      // 215: invokeinterface java/util/Set.contains (Ljava/lang/Object;)Z 2
      // 21a: ifeq 230
      // 21d: goto 221
      // 220: athrow
      // 221: aload 10
      // 223: goto 227
      // 226: athrow
      // 227: getstatic x/oc0745e01074.է Lx/oc0745e01074;
      // 22a: invokeinterface java/util/Set.remove (Ljava/lang/Object;)Z 2
      // 22f: pop
      // 230: new java/util/ArrayList
      // 233: dup
      // 234: aload 10
      // 236: invokeinterface java/util/Set.size ()I 1
      // 23b: invokespecial java/util/ArrayList.<init> (I)V
      // 23e: astore 9
      // 240: aload 10
      // 242: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 247: astore 11
      // 249: aload 11
      // 24b: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 250: ifeq 286
      // 253: aload 11
      // 255: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 25a: checkcast x/oc0745e01074
      // 25d: astore 12
      // 25f: aload 9
      // 261: iload 3
      // 262: ifne 288
      // 265: new x/oc8c33630684
      // 268: dup
      // 269: aload 12
      // 26b: invokevirtual x/oc0745e01074.Ѥ ()Lnet/minecraft/item/ItemStack;
      // 26e: aconst_null
      // 26f: bipush 1
      // 270: aload 12
      // 272: getfield x/oc0745e01074.ԃ Ljava/lang/String;
      // 275: invokespecial x/oc8c33630684.<init> (Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/renderer/texture/TextureAtlasSprite;ILjava/lang/String;)V
      // 278: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 27d: pop
      // 27e: iload 3
      // 27f: ifeq 249
      // 282: goto 286
      // 285: athrow
      // 286: aload 9
      // 288: invokedynamic compare ()Ljava/util/Comparator; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;Ljava/lang/Object;)I, x/occa6aba7d1a.q3da28my2gizpc (Lx/oc8c33630684;Lx/oc8c33630684;)I, (Lx/oc8c33630684;Lx/oc8c33630684;)I ]
      // 28d: invokeinterface java/util/List.sort (Ljava/util/Comparator;)V 2
      // 292: goto 31d
      // 295: new java/util/ArrayList
      // 298: dup
      // 299: invokespecial java/util/ArrayList.<init> ()V
      // 29c: astore 9
      // 29e: aload 5
      // 2a0: invokeinterface java/util/Map.entrySet ()Ljava/util/Set; 1
      // 2a5: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 2aa: astore 10
      // 2ac: aload 10
      // 2ae: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 2b3: ifeq 311
      // 2b6: aload 10
      // 2b8: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 2bd: checkcast java/util/Map$Entry
      // 2c0: astore 11
      // 2c2: iload 3
      // 2c3: aload 9
      // 2c5: new x/oc8c33630684
      // 2c8: dup
      // 2c9: aload 11
      // 2cb: invokeinterface java/util/Map$Entry.getKey ()Ljava/lang/Object; 1
      // 2d0: checkcast x/oc627b93cac9
      // 2d3: invokevirtual x/oc627b93cac9.Ƣ ()Lnet/minecraft/item/ItemStack;
      // 2d6: aload 11
      // 2d8: invokeinterface java/util/Map$Entry.getKey ()Ljava/lang/Object; 1
      // 2dd: checkcast x/oc627b93cac9
      // 2e0: getfield x/oc627b93cac9.ɾ Lnet/minecraft/client/renderer/texture/TextureAtlasSprite;
      // 2e3: aload 11
      // 2e5: invokeinterface java/util/Map$Entry.getValue ()Ljava/lang/Object; 1
      // 2ea: checkcast java/lang/Integer
      // 2ed: invokevirtual java/lang/Integer.intValue ()I
      // 2f0: aload 11
      // 2f2: invokeinterface java/util/Map$Entry.getKey ()Ljava/lang/Object; 1
      // 2f7: checkcast x/oc627b93cac9
      // 2fa: getfield x/oc627b93cac9.ͼ Ljava/lang/String;
      // 2fd: invokespecial x/oc8c33630684.<init> (Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/renderer/texture/TextureAtlasSprite;ILjava/lang/String;)V
      // 300: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 305: pop
      // 306: ifne 31d
      // 309: iload 3
      // 30a: ifeq 2ac
      // 30d: goto 311
      // 310: athrow
      // 311: aload 9
      // 313: invokedynamic compare ()Ljava/util/Comparator; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;Ljava/lang/Object;)I, x/occa6aba7d1a.q16s3j2n6ge1c (Lx/oc8c33630684;Lx/oc8c33630684;)I, (Lx/oc8c33630684;Lx/oc8c33630684;)I ]
      // 318: invokeinterface java/util/List.sort (Ljava/util/Comparator;)V 2
      // 31d: new x/ocecae709e0b
      // 320: dup
      // 321: new net/minecraft/util/BlockPos
      // 324: dup
      // 325: aload 2
      // 326: invokespecial net/minecraft/util/BlockPos.<init> (Lnet/minecraft/util/Vec3i;)V
      // 329: aload 9
      // 32b: invokestatic java/util/Collections.unmodifiableList (Ljava/util/List;)Ljava/util/List;
      // 32e: invokespecial x/ocecae709e0b.<init> (Lnet/minecraft/util/BlockPos;Ljava/util/List;)V
      // 331: areturn
   }

   private boolean Ơ(BlockPos param1, Map<oc627b93cac9, Integer> param2, Map<Integer, oc627b93cac9> param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 06: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 09: aload 1
      // 0a: invokevirtual net/minecraft/client/multiplayer/WorldClient.getBlockState (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // 0d: astore 5
      // 0f: istore 4
      // 11: aload 5
      // 13: iload 4
      // 15: ifne 21
      // 18: ifnull 35
      // 1b: goto 1f
      // 1e: athrow
      // 1f: aload 5
      // 21: iload 4
      // 23: ifne 3d
      // 26: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 2b: getstatic net/minecraft/init/Blocks.air Lnet/minecraft/block/Block;
      // 2e: if_acmpne 38
      // 31: goto 35
      // 34: athrow
      // 35: bipush 1
      // 36: ireturn
      // 37: athrow
      // 38: aload 5
      // 3a: invokestatic x/occa6aba7d1a.Ȍ (Lnet/minecraft/block/state/IBlockState;)Lnet/minecraft/block/state/IBlockState;
      // 3d: astore 6
      // 3f: iload 4
      // 41: aload 6
      // 43: invokestatic net/minecraft/block/Block.getStateId (Lnet/minecraft/block/state/IBlockState;)I
      // 46: istore 7
      // 48: aload 3
      // 49: iload 7
      // 4b: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 4e: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 53: checkcast x/oc627b93cac9
      // 56: astore 8
      // 58: ifne a0
      // 5b: aload 8
      // 5d: ifnonnull 80
      // 60: goto 64
      // 63: athrow
      // 64: aload 6
      // 66: aload 1
      // 67: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 6a: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 6d: invokestatic x/oc627b93cac9.Ŭ (Lnet/minecraft/block/state/IBlockState;Lnet/minecraft/util/BlockPos;Lnet/minecraft/world/World;)Lx/oc627b93cac9;
      // 70: astore 8
      // 72: aload 3
      // 73: iload 7
      // 75: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 78: aload 8
      // 7a: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 7f: pop
      // 80: aload 2
      // 81: aload 8
      // 83: aload 2
      // 84: aload 8
      // 86: bipush 0
      // 87: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 8a: invokeinterface java/util/Map.getOrDefault (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 8f: checkcast java/lang/Integer
      // 92: invokevirtual java/lang/Integer.intValue ()I
      // 95: bipush 1
      // 96: iadd
      // 97: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 9a: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 9f: pop
      // a0: bipush 0
      // a1: ireturn
   }

   private occfa28f796b[] ү(BlockPos param1, BlockPos param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: aload 1
      // 04: aload 2
      // 05: invokestatic x/occa6aba7d1a.Ɏ (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/BlockPos;)Lnet/minecraft/util/EnumFacing;
      // 08: astore 4
      // 0a: istore 3
      // 0b: aload 4
      // 0d: iload 3
      // 0e: ifne 25
      // 11: ifnonnull 1d
      // 14: goto 18
      // 17: athrow
      // 18: aconst_null
      // 19: goto 28
      // 1c: athrow
      // 1d: getstatic x/occa6aba7d1a.d Ljava/util/EnumMap;
      // 20: aload 4
      // 22: invokevirtual java/util/EnumMap.get (Ljava/lang/Object;)Ljava/lang/Object;
      // 25: checkcast [Lx/occfa28f796b;
      // 28: areturn
   }

   private static EnumMap<EnumFacing, occfa28f796b[]> Ϸ() {
      EnumMap var0 = new EnumMap(EnumFacing.class);
      var0.put(EnumFacing.EAST, Ӑ(EnumFacing.EAST));
      var0.put(EnumFacing.WEST, Ӑ(EnumFacing.WEST));
      var0.put(EnumFacing.SOUTH, Ӑ(EnumFacing.SOUTH));
      var0.put(EnumFacing.NORTH, Ӑ(EnumFacing.NORTH));
      return var0;
   }

   private static occfa28f796b[] Ӑ(EnumFacing param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic net/minecraft/util/BlockPos.ORIGIN Lnet/minecraft/util/BlockPos;
      // 003: astore 1
      // 004: aload 1
      // 005: aload 0
      // 006: invokevirtual net/minecraft/util/BlockPos.offset (Lnet/minecraft/util/EnumFacing;)Lnet/minecraft/util/BlockPos;
      // 009: astore 2
      // 00a: aload 0
      // 00b: invokevirtual net/minecraft/util/EnumFacing.getAxis ()Lnet/minecraft/util/EnumFacing$Axis;
      // 00e: getstatic net/minecraft/util/EnumFacing$Axis.Z Lnet/minecraft/util/EnumFacing$Axis;
      // 011: if_acmpne 019
      // 014: bipush 1
      // 015: goto 01a
      // 018: athrow
      // 019: bipush 0
      // 01a: istore 3
      // 01b: iload 3
      // 01c: ifeq 037
      // 01f: aload 2
      // 020: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 023: aload 1
      // 024: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 027: if_icmple 033
      // 02a: goto 02e
      // 02d: athrow
      // 02e: aload 2
      // 02f: goto 048
      // 032: athrow
      // 033: aload 1
      // 034: goto 048
      // 037: aload 2
      // 038: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 03b: aload 1
      // 03c: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 03f: if_icmple 047
      // 042: aload 2
      // 043: goto 048
      // 046: athrow
      // 047: aload 1
      // 048: astore 4
      // 04a: aload 4
      // 04c: aload 1
      // 04d: invokevirtual net/minecraft/util/BlockPos.equals (Ljava/lang/Object;)Z
      // 050: ifeq 058
      // 053: aload 2
      // 054: goto 059
      // 057: athrow
      // 058: aload 1
      // 059: astore 5
      // 05b: ldc_w -1159772401
      // 05e: ldc_w -1159772403
      // 061: ixor
      // 062: anewarray 34
      // 065: dup
      // 066: bipush 0
      // 067: aload 4
      // 069: aastore
      // 06a: dup
      // 06b: bipush 1
      // 06c: aload 5
      // 06e: aastore
      // 06f: astore 6
      // 071: ldc_w -1159772408
      // 074: ldc_w -1159772403
      // 077: ixor
      // 078: anewarray 8
      // 07b: astore 7
      // 07d: new java/util/HashSet
      // 080: dup
      // 081: invokespecial java/util/HashSet.<init> ()V
      // 084: astore 8
      // 086: bipush 1
      // 087: istore 9
      // 089: iload 9
      // 08b: ldc_w -1159772408
      // 08e: ldc_w -1159772403
      // 091: ixor
      // 092: if_icmpgt 1c0
      // 095: new java/util/ArrayList
      // 098: dup
      // 099: invokespecial java/util/ArrayList.<init> ()V
      // 09c: astore 10
      // 09e: bipush 0
      // 09f: istore 11
      // 0a1: iload 11
      // 0a3: aload 6
      // 0a5: arraylength
      // 0a6: if_icmpge 1a7
      // 0a9: aload 6
      // 0ab: iload 11
      // 0ad: aaload
      // 0ae: astore 12
      // 0b0: iload 11
      // 0b2: ifne 0bb
      // 0b5: iload 9
      // 0b7: goto 0be
      // 0ba: athrow
      // 0bb: iload 9
      // 0bd: ineg
      // 0be: istore 13
      // 0c0: iload 3
      // 0c1: ifeq 0cd
      // 0c4: aload 12
      // 0c6: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 0c9: goto 0d5
      // 0cc: athrow
      // 0cd: aload 12
      // 0cf: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 0d2: iload 13
      // 0d4: iadd
      // 0d5: istore 14
      // 0d7: iload 3
      // 0d8: ifeq 0e7
      // 0db: aload 12
      // 0dd: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 0e0: iload 13
      // 0e2: iadd
      // 0e3: goto 0ec
      // 0e6: athrow
      // 0e7: aload 12
      // 0e9: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 0ec: istore 15
      // 0ee: bipush 0
      // 0ef: istore 16
      // 0f1: iload 16
      // 0f3: iload 9
      // 0f5: if_icmpgt 1a1
      // 0f8: bipush 0
      // 0f9: istore 17
      // 0fb: iload 16
      // 0fd: istore 18
      // 0ff: iload 18
      // 101: iflt 19b
      // 104: aload 12
      // 106: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 109: iload 17
      // 10b: iadd
      // 10c: istore 20
      // 10e: iload 20
      // 110: istore 23
      // 112: iload 3
      // 113: ifeq 146
      // 116: iload 15
      // 118: iload 11
      // 11a: ifne 127
      // 11d: goto 121
      // 120: athrow
      // 121: iload 16
      // 123: goto 12a
      // 126: athrow
      // 127: iload 16
      // 129: ineg
      // 12a: isub
      // 12b: istore 25
      // 12d: iload 14
      // 12f: iload 18
      // 131: isub
      // 132: istore 19
      // 134: iload 25
      // 136: istore 21
      // 138: iload 14
      // 13a: iload 18
      // 13c: iadd
      // 13d: istore 22
      // 13f: iload 25
      // 141: istore 24
      // 143: goto 16f
      // 146: iload 14
      // 148: iload 11
      // 14a: ifne 153
      // 14d: iload 16
      // 14f: goto 156
      // 152: athrow
      // 153: iload 16
      // 155: ineg
      // 156: isub
      // 157: istore 25
      // 159: iload 25
      // 15b: istore 19
      // 15d: iload 15
      // 15f: iload 18
      // 161: isub
      // 162: istore 21
      // 164: iload 25
      // 166: istore 22
      // 168: iload 15
      // 16a: iload 18
      // 16c: iadd
      // 16d: istore 24
      // 16f: aload 10
      // 171: aload 8
      // 173: iload 19
      // 175: iload 20
      // 177: iload 21
      // 179: invokestatic x/occa6aba7d1a.Ϙ (Ljava/util/List;Ljava/util/Set;III)V
      // 17c: aload 10
      // 17e: aload 8
      // 180: iload 22
      // 182: iload 23
      // 184: iload 24
      // 186: invokestatic x/occa6aba7d1a.Ϙ (Ljava/util/List;Ljava/util/Set;III)V
      // 189: iload 18
      // 18b: ifle 195
      // 18e: iinc 17 1
      // 191: goto 195
      // 194: athrow
      // 195: iinc 18 -1
      // 198: goto 0ff
      // 19b: iinc 16 1
      // 19e: goto 0f1
      // 1a1: iinc 11 1
      // 1a4: goto 0a1
      // 1a7: aload 7
      // 1a9: iload 9
      // 1ab: bipush 1
      // 1ac: isub
      // 1ad: new x/occfa28f796b
      // 1b0: dup
      // 1b1: aload 10
      // 1b3: invokestatic java/util/Collections.unmodifiableList (Ljava/util/List;)Ljava/util/List;
      // 1b6: invokespecial x/occfa28f796b.<init> (Ljava/util/List;)V
      // 1b9: aastore
      // 1ba: iinc 9 1
      // 1bd: goto 089
      // 1c0: aload 7
      // 1c2: areturn
   }

   private static void Ϙ(List<occ1dd5eec49> var0, Set<Long> var1, int var2, int var3, int var4) {
      long var5 = new BlockPos(var2, var3, var4).toLong();

      try {
         if (var1.add(var5)) {
            var0.add(new occ1dd5eec49(var2, var3, var4));
         }
      } catch (ocbde1165e4e var7) {
         throw var7;
      }
   }

   private static EnumFacing Ɏ(BlockPos param0, BlockPos param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: aload 1
      // 04: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 07: aload 0
      // 08: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 0b: isub
      // 0c: istore 3
      // 0d: aload 1
      // 0e: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 11: aload 0
      // 12: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 15: isub
      // 16: istore 4
      // 18: getstatic net/minecraft/util/EnumFacing$Plane.HORIZONTAL Lnet/minecraft/util/EnumFacing$Plane;
      // 1b: invokevirtual net/minecraft/util/EnumFacing$Plane.iterator ()Ljava/util/Iterator;
      // 1e: astore 5
      // 20: istore 2
      // 21: aload 5
      // 23: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 28: ifeq 69
      // 2b: aload 5
      // 2d: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 32: checkcast net/minecraft/util/EnumFacing
      // 35: astore 6
      // 37: aload 6
      // 39: iload 2
      // 3a: ifne 4e
      // 3d: invokevirtual net/minecraft/util/EnumFacing.getFrontOffsetX ()I
      // 40: iload 3
      // 41: if_icmpne 65
      // 44: goto 48
      // 47: athrow
      // 48: aload 6
      // 4a: goto 4e
      // 4d: athrow
      // 4e: iload 2
      // 4f: ifne 64
      // 52: invokevirtual net/minecraft/util/EnumFacing.getFrontOffsetZ ()I
      // 55: iload 4
      // 57: if_icmpne 65
      // 5a: goto 5e
      // 5d: athrow
      // 5e: aload 6
      // 60: goto 64
      // 63: athrow
      // 64: areturn
      // 65: iload 2
      // 66: ifeq 21
      // 69: aconst_null
      // 6a: areturn
   }

   private void Ͷ() {
      this.ֆ.clear();
      this.Α.clear();
      this.ͼ.clear();
      this.ұ.clear();
      this.j.clear();
   }

   private void Ϲ(BlockPos param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: istore 2
      // 04: aload 1
      // 05: iload 2
      // 06: ifne 21
      // 09: ifnonnull 11
      // 0c: goto 10
      // 0f: athrow
      // 10: return
      // 11: aload 0
      // 12: getfield x/occa6aba7d1a.ͼ Ljava/util/Map;
      // 15: aload 1
      // 16: invokevirtual net/minecraft/util/BlockPos.toLong ()J
      // 19: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 1c: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 21: checkcast java/util/Set
      // 24: astore 3
      // 25: iload 2
      // 26: ifne 3e
      // 29: aload 3
      // 2a: ifnonnull 33
      // 2d: goto 31
      // 30: athrow
      // 31: return
      // 32: athrow
      // 33: aload 0
      // 34: getfield x/occa6aba7d1a.j Ljava/util/Set;
      // 37: aload 3
      // 38: invokeinterface java/util/Set.addAll (Ljava/util/Collection;)Z 2
      // 3d: pop
      // 3e: return
   }

   private void Χ(int param1, int param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: istore 3
      // 04: iload 3
      // 05: aload 0
      // 06: getfield x/occa6aba7d1a.ұ Ljava/util/Map;
      // 09: iload 1
      // 0a: iload 2
      // 0b: invokestatic x/occa6aba7d1a.ș (II)J
      // 0e: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 11: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 16: checkcast java/util/Set
      // 19: astore 4
      // 1b: ifne 35
      // 1e: aload 4
      // 20: ifnonnull 29
      // 23: goto 27
      // 26: athrow
      // 27: return
      // 28: athrow
      // 29: aload 0
      // 2a: getfield x/occa6aba7d1a.j Ljava/util/Set;
      // 2d: aload 4
      // 2f: invokeinterface java/util/Set.addAll (Ljava/util/Collection;)Z 2
      // 34: pop
      // 35: return
   }

   private void ǭ(BlockPos param1, BlockPos param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oce6044968f8.ђ Z
      // 003: aload 0
      // 004: aload 1
      // 005: aload 2
      // 006: invokevirtual x/occa6aba7d1a.ү (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/BlockPos;)[Lx/occfa28f796b;
      // 009: astore 4
      // 00b: istore 3
      // 00c: aload 1
      // 00d: invokevirtual net/minecraft/util/BlockPos.toLong ()J
      // 010: lstore 5
      // 012: iload 3
      // 013: ifne 043
      // 016: aload 4
      // 018: ifnonnull 044
      // 01b: goto 01f
      // 01e: athrow
      // 01f: aload 0
      // 020: getfield x/occa6aba7d1a.Α Ljava/util/Map;
      // 023: lload 5
      // 025: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 028: new x/oc20f324c8eb
      // 02b: dup
      // 02c: aload 2
      // 02d: invokevirtual net/minecraft/util/BlockPos.toLong ()J
      // 030: invokestatic java/util/Collections.emptySet ()Ljava/util/Set;
      // 033: invokestatic java/util/Collections.emptySet ()Ljava/util/Set;
      // 036: invokespecial x/oc20f324c8eb.<init> (JLjava/util/Set;Ljava/util/Set;)V
      // 039: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 03e: pop
      // 03f: goto 043
      // 042: athrow
      // 043: return
      // 044: new java/util/HashSet
      // 047: dup
      // 048: invokespecial java/util/HashSet.<init> ()V
      // 04b: astore 7
      // 04d: new java/util/HashSet
      // 050: dup
      // 051: invokespecial java/util/HashSet.<init> ()V
      // 054: astore 8
      // 056: aload 4
      // 058: astore 9
      // 05a: aload 9
      // 05c: arraylength
      // 05d: istore 10
      // 05f: bipush 0
      // 060: istore 11
      // 062: iload 11
      // 064: iload 10
      // 066: if_icmpge 13b
      // 069: aload 9
      // 06b: iload 11
      // 06d: aaload
      // 06e: astore 12
      // 070: aload 12
      // 072: getfield x/occfa28f796b.ǆ Ljava/util/List;
      // 075: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 07a: iload 3
      // 07b: ifne 142
      // 07e: astore 13
      // 080: aload 13
      // 082: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 087: ifeq 134
      // 08a: aload 13
      // 08c: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 091: checkcast x/occ1dd5eec49
      // 094: astore 14
      // 096: iload 3
      // 097: new net/minecraft/util/BlockPos
      // 09a: dup
      // 09b: aload 1
      // 09c: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 09f: aload 14
      // 0a1: getfield x/occ1dd5eec49.ʇ I
      // 0a4: iadd
      // 0a5: aload 1
      // 0a6: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 0a9: aload 14
      // 0ab: getfield x/occ1dd5eec49.ħ I
      // 0ae: iadd
      // 0af: aload 1
      // 0b0: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 0b3: aload 14
      // 0b5: getfield x/occ1dd5eec49.Ĳ I
      // 0b8: iadd
      // 0b9: invokespecial net/minecraft/util/BlockPos.<init> (III)V
      // 0bc: astore 15
      // 0be: ifne 137
      // 0c1: aload 15
      // 0c3: invokevirtual net/minecraft/util/BlockPos.toLong ()J
      // 0c6: lstore 16
      // 0c8: iload 3
      // 0c9: ifne 130
      // 0cc: aload 7
      // 0ce: lload 16
      // 0d0: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 0d3: invokeinterface java/util/Set.add (Ljava/lang/Object;)Z 2
      // 0d8: ifne 0e7
      // 0db: goto 0df
      // 0de: athrow
      // 0df: iload 3
      // 0e0: ifeq 080
      // 0e3: goto 0e7
      // 0e6: athrow
      // 0e7: aload 0
      // 0e8: getfield x/occa6aba7d1a.ͼ Ljava/util/Map;
      // 0eb: lload 16
      // 0ed: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 0f0: invokedynamic apply ()Ljava/util/function/Function; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Ljava/lang/Object;, x/occa6aba7d1a.q1apxtubmqvap (Ljava/lang/Long;)Ljava/util/Set;, (Ljava/lang/Long;)Ljava/util/Set; ]
      // 0f5: invokeinterface java/util/Map.computeIfAbsent (Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object; 3
      // 0fa: checkcast java/util/Set
      // 0fd: lload 5
      // 0ff: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 102: invokeinterface java/util/Set.add (Ljava/lang/Object;)Z 2
      // 107: pop
      // 108: aload 8
      // 10a: aload 15
      // 10c: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 10f: ldc_w -2057699657
      // 112: ldc_w -2057699661
      // 115: ixor
      // 116: ishr
      // 117: aload 15
      // 119: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 11c: ldc_w -2057699657
      // 11f: ldc_w -2057699661
      // 122: ixor
      // 123: ishr
      // 124: invokestatic x/occa6aba7d1a.ș (II)J
      // 127: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 12a: invokeinterface java/util/Set.add (Ljava/lang/Object;)Z 2
      // 12f: pop
      // 130: iload 3
      // 131: ifeq 080
      // 134: iinc 11 1
      // 137: iload 3
      // 138: ifeq 062
      // 13b: aload 8
      // 13d: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 142: astore 9
      // 144: aload 9
      // 146: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 14b: ifeq 184
      // 14e: aload 9
      // 150: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 155: checkcast java/lang/Long
      // 158: astore 10
      // 15a: iload 3
      // 15b: ifne 1a8
      // 15e: aload 0
      // 15f: getfield x/occa6aba7d1a.ұ Ljava/util/Map;
      // 162: aload 10
      // 164: invokedynamic apply ()Ljava/util/function/Function; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Ljava/lang/Object;, x/occa6aba7d1a.quq8tokshvps3 (Ljava/lang/Long;)Ljava/util/Set;, (Ljava/lang/Long;)Ljava/util/Set; ]
      // 169: invokeinterface java/util/Map.computeIfAbsent (Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object; 3
      // 16e: checkcast java/util/Set
      // 171: lload 5
      // 173: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 176: invokeinterface java/util/Set.add (Ljava/lang/Object;)Z 2
      // 17b: pop
      // 17c: iload 3
      // 17d: ifeq 144
      // 180: goto 184
      // 183: athrow
      // 184: aload 0
      // 185: getfield x/occa6aba7d1a.Α Ljava/util/Map;
      // 188: lload 5
      // 18a: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 18d: new x/oc20f324c8eb
      // 190: dup
      // 191: aload 2
      // 192: invokevirtual net/minecraft/util/BlockPos.toLong ()J
      // 195: aload 7
      // 197: invokestatic java/util/Collections.unmodifiableSet (Ljava/util/Set;)Ljava/util/Set;
      // 19a: aload 8
      // 19c: invokestatic java/util/Collections.unmodifiableSet (Ljava/util/Set;)Ljava/util/Set;
      // 19f: invokespecial x/oc20f324c8eb.<init> (JLjava/util/Set;Ljava/util/Set;)V
      // 1a2: invokeinterface java/util/Map.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; 3
      // 1a7: pop
      // 1a8: return
   }

   private void º(long param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oce6044968f8.ђ Z
      // 003: aload 0
      // 004: getfield x/occa6aba7d1a.Α Ljava/util/Map;
      // 007: lload 1
      // 008: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 00b: invokeinterface java/util/Map.remove (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 010: checkcast x/oc20f324c8eb
      // 013: astore 4
      // 015: istore 3
      // 016: aload 0
      // 017: getfield x/occa6aba7d1a.ֆ Ljava/util/Map;
      // 01a: lload 1
      // 01b: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 01e: invokeinterface java/util/Map.remove (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 023: pop
      // 024: aload 0
      // 025: getfield x/occa6aba7d1a.j Ljava/util/Set;
      // 028: iload 3
      // 029: ifne 046
      // 02c: lload 1
      // 02d: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 030: invokeinterface java/util/Set.remove (Ljava/lang/Object;)Z 2
      // 035: pop
      // 036: aload 4
      // 038: ifnonnull 041
      // 03b: goto 03f
      // 03e: athrow
      // 03f: return
      // 040: athrow
      // 041: aload 4
      // 043: getfield x/oc20f324c8eb.ԥ Ljava/util/Set;
      // 046: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 04b: astore 5
      // 04d: aload 5
      // 04f: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 054: ifeq 0be
      // 057: aload 5
      // 059: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 05e: checkcast java/lang/Long
      // 061: astore 6
      // 063: aload 0
      // 064: getfield x/occa6aba7d1a.ͼ Ljava/util/Map;
      // 067: aload 6
      // 069: iload 3
      // 06a: ifne 0e6
      // 06d: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 072: checkcast java/util/Set
      // 075: astore 7
      // 077: iload 3
      // 078: ifne 0a0
      // 07b: aload 7
      // 07d: ifnonnull 08c
      // 080: goto 084
      // 083: athrow
      // 084: iload 3
      // 085: ifeq 04d
      // 088: goto 08c
      // 08b: athrow
      // 08c: aload 7
      // 08e: iload 3
      // 08f: ifne 0b9
      // 092: lload 1
      // 093: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 096: invokeinterface java/util/Set.remove (Ljava/lang/Object;)Z 2
      // 09b: pop
      // 09c: goto 0a0
      // 09f: athrow
      // 0a0: aload 7
      // 0a2: invokeinterface java/util/Set.isEmpty ()Z 1
      // 0a7: ifeq 0ba
      // 0aa: aload 0
      // 0ab: getfield x/occa6aba7d1a.ͼ Ljava/util/Map;
      // 0ae: aload 6
      // 0b0: invokeinterface java/util/Map.remove (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 0b5: goto 0b9
      // 0b8: athrow
      // 0b9: pop
      // 0ba: iload 3
      // 0bb: ifeq 04d
      // 0be: aload 4
      // 0c0: getfield x/oc20f324c8eb.ҩ Ljava/util/Set;
      // 0c3: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 0c8: astore 5
      // 0ca: aload 5
      // 0cc: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 0d1: ifeq 137
      // 0d4: aload 5
      // 0d6: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 0db: checkcast java/lang/Long
      // 0de: astore 6
      // 0e0: aload 0
      // 0e1: getfield x/occa6aba7d1a.ұ Ljava/util/Map;
      // 0e4: aload 6
      // 0e6: invokeinterface java/util/Map.get (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 0eb: checkcast java/util/Set
      // 0ee: astore 7
      // 0f0: iload 3
      // 0f1: ifne 119
      // 0f4: aload 7
      // 0f6: ifnonnull 105
      // 0f9: goto 0fd
      // 0fc: athrow
      // 0fd: iload 3
      // 0fe: ifeq 0ca
      // 101: goto 105
      // 104: athrow
      // 105: aload 7
      // 107: iload 3
      // 108: ifne 132
      // 10b: lload 1
      // 10c: invokestatic java/lang/Long.valueOf (J)Ljava/lang/Long;
      // 10f: invokeinterface java/util/Set.remove (Ljava/lang/Object;)Z 2
      // 114: pop
      // 115: goto 119
      // 118: athrow
      // 119: aload 7
      // 11b: invokeinterface java/util/Set.isEmpty ()Z 1
      // 120: ifeq 133
      // 123: aload 0
      // 124: getfield x/occa6aba7d1a.ұ Ljava/util/Map;
      // 127: aload 6
      // 129: invokeinterface java/util/Map.remove (Ljava/lang/Object;)Ljava/lang/Object; 2
      // 12e: goto 132
      // 131: athrow
      // 132: pop
      // 133: iload 3
      // 134: ifeq 0ca
      // 137: return
   }

   private static long ș(int var0, int var1) {
      return (long)var0 << (182388268 ^ 182388236) | var1 & (4602230368022925237L ^ 4602230365186846794L);
   }

   public float Ѻ() {
      try {
         if (this.ɝ.ǭ()) {
            return 1.0F;
         }
      } catch (ocbde1165e4e var1) {
         throw var1;
      }

      return 0.5625F;
   }

   private float ĥ() {
      return oc05d664c647.Ө(this.մ.Ӂ()) * 0.02F;
   }

   private float ĺ(float var1) {
      float var2 = this.ĥ();
      float var3 = Math.max(1.0F, var1);
      float var4 = var2 * (var3 / 8.0F);
      return Math.max(var2, var4);
   }

   private static ItemStack ӗ(IBlockState param0, BlockPos param1, World param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: aload 0
      // 04: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 09: astore 4
      // 0b: istore 3
      // 0c: aload 4
      // 0e: aload 2
      // 0f: aload 1
      // 10: invokevirtual net/minecraft/block/Block.getItem (Lnet/minecraft/world/World;Lnet/minecraft/util/BlockPos;)Lnet/minecraft/item/Item;
      // 13: astore 5
      // 15: aload 5
      // 17: iload 3
      // 18: ifne 26
      // 1b: ifnonnull 24
      // 1e: goto 22
      // 21: athrow
      // 22: aconst_null
      // 23: areturn
      // 24: aload 5
      // 26: invokevirtual net/minecraft/item/Item.getHasSubtypes ()Z
      // 29: iload 3
      // 2a: ifne 3f
      // 2d: ifeq 42
      // 30: goto 34
      // 33: athrow
      // 34: aload 4
      // 36: aload 2
      // 37: aload 1
      // 38: invokevirtual net/minecraft/block/Block.getDamageValue (Lnet/minecraft/world/World;Lnet/minecraft/util/BlockPos;)I
      // 3b: goto 3f
      // 3e: athrow
      // 3f: goto 43
      // 42: bipush 0
      // 43: istore 6
      // 45: new net/minecraft/item/ItemStack
      // 48: dup
      // 49: aload 5
      // 4b: bipush 1
      // 4c: iload 6
      // 4e: invokespecial net/minecraft/item/ItemStack.<init> (Lnet/minecraft/item/Item;II)V
      // 51: areturn
      // 52: astore 5
      // 54: aconst_null
      // 55: areturn
   }

   private static TextureAtlasSprite ģ(IBlockState param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: istore 1
      // 04: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 07: iload 1
      // 08: ifne 15
      // 0b: ifnull 3b
      // 0e: goto 12
      // 11: athrow
      // 12: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 15: iload 1
      // 16: ifne 2a
      // 19: invokevirtual net/minecraft/client/Minecraft.getBlockRendererDispatcher ()Lnet/minecraft/client/renderer/BlockRendererDispatcher;
      // 1c: ifnull 3b
      // 1f: goto 23
      // 22: athrow
      // 23: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 26: goto 2a
      // 29: athrow
      // 2a: iload 1
      // 2b: ifne 41
      // 2e: invokevirtual net/minecraft/client/Minecraft.getBlockRendererDispatcher ()Lnet/minecraft/client/renderer/BlockRendererDispatcher;
      // 31: invokevirtual net/minecraft/client/renderer/BlockRendererDispatcher.getBlockModelShapes ()Lnet/minecraft/client/renderer/BlockModelShapes;
      // 34: ifnonnull 3e
      // 37: goto 3b
      // 3a: athrow
      // 3b: aconst_null
      // 3c: areturn
      // 3d: athrow
      // 3e: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 41: invokevirtual net/minecraft/client/Minecraft.getBlockRendererDispatcher ()Lnet/minecraft/client/renderer/BlockRendererDispatcher;
      // 44: invokevirtual net/minecraft/client/renderer/BlockRendererDispatcher.getBlockModelShapes ()Lnet/minecraft/client/renderer/BlockModelShapes;
      // 47: aload 0
      // 48: invokevirtual net/minecraft/client/renderer/BlockModelShapes.getTexture (Lnet/minecraft/block/state/IBlockState;)Lnet/minecraft/client/renderer/texture/TextureAtlasSprite;
      // 4b: astore 2
      // 4c: aload 2
      // 4d: iload 1
      // 4e: ifne 5c
      // 51: ifnonnull 5b
      // 54: goto 58
      // 57: athrow
      // 58: aconst_null
      // 59: areturn
      // 5a: athrow
      // 5b: aload 2
      // 5c: areturn
   }

   private static IBlockState Ȍ(IBlockState param0) {
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
      // 05: iload 1
      // 06: ifne 14
      // 09: ifnonnull 13
      // 0c: goto 10
      // 0f: athrow
      // 10: aconst_null
      // 11: areturn
      // 12: athrow
      // 13: aload 0
      // 14: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 19: astore 2
      // 1a: aload 2
      // 1b: iload 1
      // 1c: ifne 2e
      // 1f: getstatic net/minecraft/init/Blocks.water Lnet/minecraft/block/BlockStaticLiquid;
      // 22: if_acmpeq 3c
      // 25: goto 29
      // 28: athrow
      // 29: aload 2
      // 2a: goto 2e
      // 2d: athrow
      // 2e: iload 1
      // 2f: ifne 45
      // 32: getstatic net/minecraft/init/Blocks.flowing_water Lnet/minecraft/block/BlockDynamicLiquid;
      // 35: if_acmpne 44
      // 38: goto 3c
      // 3b: athrow
      // 3c: getstatic net/minecraft/init/Blocks.water Lnet/minecraft/block/BlockStaticLiquid;
      // 3f: invokevirtual net/minecraft/block/BlockStaticLiquid.getDefaultState ()Lnet/minecraft/block/state/IBlockState;
      // 42: areturn
      // 43: athrow
      // 44: aload 2
      // 45: iload 1
      // 46: ifne 58
      // 49: getstatic net/minecraft/init/Blocks.lava Lnet/minecraft/block/BlockStaticLiquid;
      // 4c: if_acmpeq 66
      // 4f: goto 53
      // 52: athrow
      // 53: aload 2
      // 54: goto 58
      // 57: athrow
      // 58: iload 1
      // 59: ifne 6f
      // 5c: getstatic net/minecraft/init/Blocks.flowing_lava Lnet/minecraft/block/BlockDynamicLiquid;
      // 5f: if_acmpne 6e
      // 62: goto 66
      // 65: athrow
      // 66: getstatic net/minecraft/init/Blocks.lava Lnet/minecraft/block/BlockStaticLiquid;
      // 69: invokevirtual net/minecraft/block/BlockStaticLiquid.getDefaultState ()Lnet/minecraft/block/state/IBlockState;
      // 6c: areturn
      // 6d: athrow
      // 6e: aload 2
      // 6f: getstatic net/minecraft/init/Blocks.fire Lnet/minecraft/block/BlockFire;
      // 72: if_acmpne 7d
      // 75: getstatic net/minecraft/init/Blocks.fire Lnet/minecraft/block/BlockFire;
      // 78: invokevirtual net/minecraft/block/BlockFire.getDefaultState ()Lnet/minecraft/block/state/IBlockState;
      // 7b: areturn
      // 7c: athrow
      // 7d: aload 0
      // 7e: areturn
   }

   private static String V(IBlockState param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: aload 0
      // 04: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 09: invokevirtual net/minecraft/block/Block.getLocalizedName ()Ljava/lang/String;
      // 0c: astore 2
      // 0d: istore 1
      // 0e: aload 2
      // 0f: iload 1
      // 10: ifne 3c
      // 13: ifnull 30
      // 16: goto 1a
      // 19: athrow
      // 1a: aload 2
      // 1b: iload 1
      // 1c: ifne 3c
      // 1f: goto 23
      // 22: athrow
      // 23: invokevirtual java/lang/String.isEmpty ()Z
      // 26: ifne 30
      // 29: goto 2d
      // 2c: athrow
      // 2d: aload 2
      // 2e: areturn
      // 2f: athrow
      // 30: getstatic net/minecraft/block/Block.blockRegistry Lnet/minecraft/util/RegistryNamespacedDefaultedByKey;
      // 33: aload 0
      // 34: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 39: invokevirtual net/minecraft/util/RegistryNamespacedDefaultedByKey.getNameForObject (Ljava/lang/Object;)Ljava/lang/Object;
      // 3c: astore 3
      // 3d: aload 3
      // 3e: ifnull 66
      // 41: aload 0
      // 42: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 47: aload 0
      // 48: invokevirtual net/minecraft/block/Block.getMetaFromState (Lnet/minecraft/block/state/IBlockState;)I
      // 4b: istore 4
      // 4d: iload 4
      // 4f: ifeq 61
      // 52: aload 3
      // 53: invokestatic java/lang/String.valueOf (Ljava/lang/Object;)Ljava/lang/String;
      // 56: iload 4
      // 58: invokedynamic makeConcatWithConstants (Ljava/lang/String;I)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001:\u0001" ]
      // 5d: goto 65
      // 60: athrow
      // 61: aload 3
      // 62: invokevirtual java/lang/Object.toString ()Ljava/lang/String;
      // 65: areturn
      // 66: ldc_w "unknown"
      // 69: areturn
   }

   private static ItemStack Ъ(Block param0) {
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
      // 05: iload 1
      // 06: ifne 20
      // 09: getstatic net/minecraft/init/Blocks.bed Lnet/minecraft/block/Block;
      // 0c: if_acmpne 1f
      // 0f: goto 13
      // 12: athrow
      // 13: new net/minecraft/item/ItemStack
      // 16: dup
      // 17: getstatic net/minecraft/init/Items.bed Lnet/minecraft/item/Item;
      // 1a: invokespecial net/minecraft/item/ItemStack.<init> (Lnet/minecraft/item/Item;)V
      // 1d: areturn
      // 1e: athrow
      // 1f: aload 0
      // 20: invokestatic net/minecraft/item/Item.getItemFromBlock (Lnet/minecraft/block/Block;)Lnet/minecraft/item/Item;
      // 23: astore 2
      // 24: aload 2
      // 25: ifnull 3c
      // 28: aload 0
      // 29: aload 0
      // 2a: invokevirtual net/minecraft/block/Block.getDefaultState ()Lnet/minecraft/block/state/IBlockState;
      // 2d: invokevirtual net/minecraft/block/Block.getMetaFromState (Lnet/minecraft/block/state/IBlockState;)I
      // 30: istore 3
      // 31: new net/minecraft/item/ItemStack
      // 34: dup
      // 35: aload 2
      // 36: bipush 1
      // 37: iload 3
      // 38: invokespecial net/minecraft/item/ItemStack.<init> (Lnet/minecraft/item/Item;II)V
      // 3b: areturn
      // 3c: goto 40
      // 3f: astore 2
      // 40: new net/minecraft/item/ItemStack
      // 43: dup
      // 44: getstatic net/minecraft/init/Blocks.barrier Lnet/minecraft/block/Block;
      // 47: invokespecial net/minecraft/item/ItemStack.<init> (Lnet/minecraft/block/Block;)V
      // 4a: areturn
   }

   public int ʩ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oce6044968f8.ђ Z
      // 003: aload 0
      // 004: getfield x/occa6aba7d1a.ʳ Lx/oca9cc61aada;
      // 007: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 00a: d2i
      // 00b: istore 2
      // 00c: istore 1
      // 00d: iload 2
      // 00e: iload 1
      // 00f: ifne 108
      // 012: tableswitch 232 0 3 31 47 55 204
      // 030: athrow
      // 031: dconst_0
      // 032: invokestatic x/ocd2958dac48.ů (D)I
      // 035: aload 0
      // 036: getfield x/occa6aba7d1a.ք Lx/oc24a0a5bddf;
      // 039: invokevirtual x/oc24a0a5bddf.Ǣ ()I
      // 03c: invokestatic x/oc7ab2161b9f.Ҭ (II)I
      // 03f: ireturn
      // 040: athrow
      // 041: aload 0
      // 042: getfield x/occa6aba7d1a.ք Lx/oc24a0a5bddf;
      // 045: invokevirtual x/oc24a0a5bddf.ͳ ()I
      // 048: ireturn
      // 049: invokestatic java/lang/System.currentTimeMillis ()J
      // 04c: l2d
      // 04d: aload 0
      // 04e: getfield x/occa6aba7d1a.ϱ Lx/oca9cc61aada;
      // 051: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 054: dmul
      // 055: ldc2_w 1000.0
      // 058: ddiv
      // 059: invokestatic java/lang/Math.sin (D)D
      // 05c: ldc2_w 0.5
      // 05f: dmul
      // 060: ldc2_w 0.5
      // 063: dadd
      // 064: dstore 3
      // 065: new java/awt/Color
      // 068: dup
      // 069: aload 0
      // 06a: getfield x/occa6aba7d1a.ք Lx/oc24a0a5bddf;
      // 06d: invokevirtual x/oc24a0a5bddf.ˀ ()I
      // 070: aload 0
      // 071: getfield x/occa6aba7d1a.ք Lx/oc24a0a5bddf;
      // 074: invokevirtual x/oc24a0a5bddf.z ()I
      // 077: aload 0
      // 078: getfield x/occa6aba7d1a.ք Lx/oc24a0a5bddf;
      // 07b: invokevirtual x/oc24a0a5bddf.ц ()I
      // 07e: aload 0
      // 07f: getfield x/occa6aba7d1a.ք Lx/oc24a0a5bddf;
      // 082: invokevirtual x/oc24a0a5bddf.Ǣ ()I
      // 085: invokespecial java/awt/Color.<init> (IIII)V
      // 088: astore 5
      // 08a: new java/awt/Color
      // 08d: dup
      // 08e: aload 0
      // 08f: getfield x/occa6aba7d1a.ē Lx/oc24a0a5bddf;
      // 092: invokevirtual x/oc24a0a5bddf.ˀ ()I
      // 095: aload 0
      // 096: getfield x/occa6aba7d1a.ē Lx/oc24a0a5bddf;
      // 099: invokevirtual x/oc24a0a5bddf.z ()I
      // 09c: aload 0
      // 09d: getfield x/occa6aba7d1a.ē Lx/oc24a0a5bddf;
      // 0a0: invokevirtual x/oc24a0a5bddf.ц ()I
      // 0a3: aload 0
      // 0a4: getfield x/occa6aba7d1a.ē Lx/oc24a0a5bddf;
      // 0a7: invokevirtual x/oc24a0a5bddf.Ǣ ()I
      // 0aa: invokespecial java/awt/Color.<init> (IIII)V
      // 0ad: astore 6
      // 0af: aload 5
      // 0b1: aload 6
      // 0b3: dload 3
      // 0b4: invokestatic x/oc3542cefbeb.ɂ (Ljava/awt/Color;Ljava/awt/Color;D)Ljava/awt/Color;
      // 0b7: astore 7
      // 0b9: aload 0
      // 0ba: getfield x/occa6aba7d1a.ք Lx/oc24a0a5bddf;
      // 0bd: invokevirtual x/oc24a0a5bddf.Ǣ ()I
      // 0c0: i2d
      // 0c1: dload 3
      // 0c2: dmul
      // 0c3: aload 0
      // 0c4: getfield x/occa6aba7d1a.ē Lx/oc24a0a5bddf;
      // 0c7: invokevirtual x/oc24a0a5bddf.Ǣ ()I
      // 0ca: i2d
      // 0cb: dconst_1
      // 0cc: dload 3
      // 0cd: dsub
      // 0ce: dmul
      // 0cf: dadd
      // 0d0: d2i
      // 0d1: istore 8
      // 0d3: aload 7
      // 0d5: invokevirtual java/awt/Color.getRGB ()I
      // 0d8: iload 8
      // 0da: invokestatic x/oc7ab2161b9f.Ҭ (II)I
      // 0dd: ireturn
      // 0de: ldc2_w 7977436770564175459
      // 0e1: ldc2_w 7977436770564175457
      // 0e4: lxor
      // 0e5: bipush 1
      // 0e6: newarray 11
      // 0e8: dup
      // 0e9: bipush 0
      // 0ea: lconst_0
      // 0eb: lastore
      // 0ec: invokestatic x/oc7ab2161b9f.ƾ (J[J)I
      // 0ef: aload 0
      // 0f0: getfield x/occa6aba7d1a.ք Lx/oc24a0a5bddf;
      // 0f3: invokevirtual x/oc24a0a5bddf.Ǣ ()I
      // 0f6: invokestatic x/oc7ab2161b9f.Ҭ (II)I
      // 0f9: ireturn
      // 0fa: dconst_0
      // 0fb: invokestatic x/ocd2958dac48.ů (D)I
      // 0fe: aload 0
      // 0ff: getfield x/occa6aba7d1a.ք Lx/oc24a0a5bddf;
      // 102: invokevirtual x/oc24a0a5bddf.Ǣ ()I
      // 105: invokestatic x/oc7ab2161b9f.Ҭ (II)I
      // 108: ireturn
   }

   static {
      String[] var10000 = new String[-1756623915 ^ -1756623919];
      var10000[0] = "HUD";
      var10000[1] = "Static";
      var10000[-1756623917 ^ -1756623919] = "Gradient";
      var10000[-1756623918 ^ -1756623919] = "Rainbow";
      ĥ = var10000;
   }
}
