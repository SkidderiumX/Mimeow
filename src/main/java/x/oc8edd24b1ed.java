package x;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Set;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBed;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.server.S08PacketPlayerPosLook;
import net.minecraft.network.play.server.S08PacketPlayerPosLook.EnumFlags;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import org.lwjgl.opengl.GL11;

public class oc8edd24b1ed extends oc69da1aa7f5 {
   private static final long g = 1000L;
   private static final float ʠ = 1.0F;
   private static final double ĉ = 1225.0;
   private static final double ѝ = 1600.0;
   private static final double ǩ = 1.0E-4;
   private static final double Ѣ = 0.25;
   private static final double Θ = 0.9;
   private static final int Ý = 5;
   private static final int ÿ = 10;
   private static final float Ҙ = 45.0F;
   private static final float Ș = 0.15F;
   private static final int Ϩ = 0;
   private static final int ˠ = 1;
   private static final String[] Ή;
   private static final int Ɔ = 1;
   private final oc1e60691dfe ª = new oc1e60691dfe();
   private final ArrayList<BlockPos> S = new ArrayList<>();
   private final oc2b4e974fd6 ū = new oc2b4e974fd6();
   private BlockPos Ѥ;
   private Vec3 Б;
   private Block Ї;
   private BlockPos ů;
   private Vec3 ŷ;
   private BlockPos Ū;
   private BlockPos å;
   private BlockPos ĝ;
   private BlockPos J;
   private Vec3 ΐ;
   private Vec3 Ժ;
   private int È;
   private int ɥ;
   private Vec3 Α;
   private int Ǡ;
   private int ə;
   private float ƙ;
   private boolean ɗ;
   private int Ɩ = -1;
   private boolean Ͽ;
   private boolean Є;
   private boolean Ȓ;
   private boolean ά;
   private boolean ô;
   private boolean Ô;
   private long Ϣ = -8942899110861366509L ^ 8942899110861366508L;
   private int ʕ;
   private int Ӑ;
   private final occ2f8dff8d8 Ƒ = new occ2f8dff8d8("Prioritize KillAura", false);
   private final oca9cc61aada ƚ = new oca9cc61aada("Defer enemy range", "m", 4.5, 1.0, 8.0, 0.1);
   public final oca9cc61aada ӧ;
   public final oca9cc61aada ǉ;
   public final occ2f8dff8d8 Տ;
   public final occ2f8dff8d8 Ò;
   public final oca9cc61aada Ȉ;
   public final occ2f8dff8d8 ƃ;
   public static boolean ɟ;

   public oc8edd24b1ed() {
      super("BedAura", oce4cea752dd.з);
      String[] var10005 = new String[-1076361077 ^ -1076361079];
      var10005[0] = "LEGIT";
      var10005[1] = "HYPIXEL";
      this.ӧ = new oca9cc61aada("Mode", 0, var10005);
      this.ǉ = new oca9cc61aada("Range", 4.5, 3.0, 6.0, 0.1);
      var10005 = new String[-1076361077 ^ -1076361079];
      var10005[0] = "Whitelist";
      var10005[1] = "Ignore own bed";
      this.Տ = new occ2f8dff8d8("Whitelist Own Bed", true, var10005);
      this.Ò = new occ2f8dff8d8("Surroundings", true);
      this.Ȉ = new oca9cc61aada("Visual Mode", 0, Ή);
      this.ƃ = new occ2f8dff8d8("Swing", true);
      this.ą("Fucker.");
      this.ʌ(this.ӧ);
      this.ʌ(this.ǉ);
      this.ʌ(this.Տ);
      this.ʌ(this.Ò);
      this.ʌ(this.Ȉ);
      this.ʌ(this.Ƒ);
      this.ʌ(this.ƚ);
      this.ʌ(this.ƃ);
   }

   private void P() {
      this.ƽ();
      this.σ();
      this.ƙ();
      this.ǽ();
   }

   private void ƙ() {
      this.ů = null;
      this.ŷ = null;
      this.Ժ = null;
      this.È = 0;
   }

   private void ǽ() {
      this.Ū = null;
      this.å = null;
   }

   private void ҭ() {
      this.ĝ = null;
      this.J = null;
      this.ΐ = null;
      this.ɥ = 0;
   }

   private void ŉ(BlockPos var1) {
      this.Ū = var1;
      this.å = this.ϧ(var1);
   }

   private BlockPos ϧ(BlockPos param1) {
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
      // 05: ifnull 1d
      // 08: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0b: iload 2
      // 0c: ifne 23
      // 0f: goto 13
      // 12: athrow
      // 13: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 16: ifnonnull 20
      // 19: goto 1d
      // 1c: athrow
      // 1d: aconst_null
      // 1e: areturn
      // 1f: athrow
      // 20: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 23: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 26: aload 1
      // 27: invokevirtual net/minecraft/client/multiplayer/WorldClient.getBlockState (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // 2a: astore 3
      // 2b: aload 3
      // 2c: iload 2
      // 2d: ifne 43
      // 30: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 35: instanceof net/minecraft/block/BlockBed
      // 38: ifne 42
      // 3b: goto 3f
      // 3e: athrow
      // 3f: aconst_null
      // 40: areturn
      // 41: athrow
      // 42: aload 3
      // 43: getstatic net/minecraft/block/BlockBed.PART Lnet/minecraft/block/properties/PropertyEnum;
      // 46: invokeinterface net/minecraft/block/state/IBlockState.getValue (Lnet/minecraft/block/properties/IProperty;)Ljava/lang/Comparable; 2
      // 4b: checkcast net/minecraft/block/BlockBed$EnumPartType
      // 4e: astore 4
      // 50: aload 3
      // 51: getstatic net/minecraft/block/BlockBed.FACING Lnet/minecraft/block/properties/PropertyDirection;
      // 54: invokeinterface net/minecraft/block/state/IBlockState.getValue (Lnet/minecraft/block/properties/IProperty;)Ljava/lang/Comparable; 2
      // 59: checkcast net/minecraft/util/EnumFacing
      // 5c: astore 5
      // 5e: aload 1
      // 5f: aload 4
      // 61: getstatic net/minecraft/block/BlockBed$EnumPartType.HEAD Lnet/minecraft/block/BlockBed$EnumPartType;
      // 64: if_acmpne 70
      // 67: aload 5
      // 69: invokevirtual net/minecraft/util/EnumFacing.getOpposite ()Lnet/minecraft/util/EnumFacing;
      // 6c: goto 72
      // 6f: athrow
      // 70: aload 5
      // 72: invokevirtual net/minecraft/util/BlockPos.offset (Lnet/minecraft/util/EnumFacing;)Lnet/minecraft/util/BlockPos;
      // 75: areturn
   }

   private BlockPos Ѫ(BlockPos param1) {
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
      // 05: ifnull 1d
      // 08: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0b: iload 2
      // 0c: ifne 23
      // 0f: goto 13
      // 12: athrow
      // 13: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 16: ifnonnull 20
      // 19: goto 1d
      // 1c: athrow
      // 1d: aconst_null
      // 1e: areturn
      // 1f: athrow
      // 20: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 23: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 26: aload 1
      // 27: invokevirtual net/minecraft/client/multiplayer/WorldClient.getBlockState (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // 2a: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 2f: instanceof net/minecraft/block/BlockBed
      // 32: ifeq 38
      // 35: aload 1
      // 36: areturn
      // 37: athrow
      // 38: invokestatic net/minecraft/util/EnumFacing.values ()[Lnet/minecraft/util/EnumFacing;
      // 3b: astore 3
      // 3c: aload 3
      // 3d: arraylength
      // 3e: istore 4
      // 40: bipush 0
      // 41: istore 5
      // 43: iload 5
      // 45: iload 4
      // 47: if_icmpge 81
      // 4a: aload 3
      // 4b: iload 5
      // 4d: aaload
      // 4e: astore 6
      // 50: iload 2
      // 51: aload 1
      // 52: aload 6
      // 54: invokevirtual net/minecraft/util/BlockPos.offset (Lnet/minecraft/util/EnumFacing;)Lnet/minecraft/util/BlockPos;
      // 57: astore 7
      // 59: ifne 7d
      // 5c: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 5f: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 62: aload 7
      // 64: invokevirtual net/minecraft/client/multiplayer/WorldClient.getBlockState (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // 67: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 6c: instanceof net/minecraft/block/BlockBed
      // 6f: ifeq 7a
      // 72: goto 76
      // 75: athrow
      // 76: aload 7
      // 78: areturn
      // 79: athrow
      // 7a: iinc 5 1
      // 7d: iload 2
      // 7e: ifeq 43
      // 81: aconst_null
      // 82: areturn
   }

   private boolean ҿ() {
      int var1 = oc84f20a0bc5.ė;
      int var2 = 227687206 ^ 1917352609;

      while (true) {
         switch (var2) {
            case 1471898495:
               int var10000;
               label35: {
                  label34: {
                     try {
                        var10000 = oc69da1aa7f5.ő.thePlayer.ticksExisted;
                        if (var1 != 0) {
                           break label35;
                        }

                        if (oc69da1aa7f5.ő.thePlayer.ticksExisted >= this.ɥ) {
                           break label34;
                        }
                     } catch (ocbde1165e4e var3) {
                        throw var3;
                     }

                     var2 = 1755726198 ^ 1917352609;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var10000 = 1571148640 ^ 1917352609;
               }

               var2 = var10000;
               if (var1 == 0) {
                  break;
               }
            case 804104641:
               return false;
            case 2145010055:
               if (oc69da1aa7f5.ő.thePlayer != null) {
                  var2 = 636688862 ^ 1917352609;
                  if (var1 == 0) {
                     break;
                  }
               }

               var2 = 1571148640 ^ 1917352609;
               if (var1 == 0) {
                  break;
               }
            case 451820503:
               return true;
            default:
               throw null;
         }
      }
   }

   private boolean ȉ(BlockPos var1) {
      int var2 = oc84f20a0bc5.ė;
      int var3 = -723243509 ^ -69557446;

      while (true) {
         switch (var3) {
            case -1040068848:
               return true;
            case 792628529:
               int var6;
               label46: {
                  label45: {
                     try {
                        var6 = var1.equals(this.ĝ);
                        if (var2 != 0) {
                           break label46;
                        }

                        if (var6 != 0) {
                           break label45;
                        }
                     } catch (ocbde1165e4e var5) {
                        throw var5;
                     }

                     var3 = -1864416431 ^ -69557446;
                     if (var2 == 0) {
                        break;
                     }
                  }

                  var6 = 970681386 ^ -69557446;
               }

               var3 = var6;
               if (var2 == 0) {
                  break;
               }
            case -977707173:
               return false;
            case 1795547243:
               int var10000;
               label37: {
                  label36: {
                     try {
                        var10000 = var1.equals(this.J);
                        if (var2 != 0) {
                           break label37;
                        }

                        if (var10000 == 0) {
                           break label36;
                        }
                     } catch (ocbde1165e4e var4) {
                        throw var4;
                     }

                     var3 = 970681386 ^ -69557446;
                     if (var2 == 0) {
                        break;
                     }
                  }

                  var10000 = 1046740065 ^ -69557446;
               }

               var3 = var10000;
               break;
            default:
               throw null;
         }
      }
   }

   private void ֆ() {
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
      // 09: invokevirtual x/oc8edd24b1ed.ҿ ()Z
      // 0c: ifne 33
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: goto 18
      // 17: athrow
      // 18: getfield x/oc8edd24b1ed.ĝ Lnet/minecraft/util/BlockPos;
      // 1b: ifnull 33
      // 1e: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 21: iload 1
      // 22: ifne 38
      // 25: goto 29
      // 28: athrow
      // 29: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 2c: ifnonnull 35
      // 2f: goto 33
      // 32: athrow
      // 33: return
      // 34: athrow
      // 35: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 38: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 3b: aload 0
      // 3c: getfield x/oc8edd24b1ed.ĝ Lnet/minecraft/util/BlockPos;
      // 3f: invokevirtual net/minecraft/client/multiplayer/WorldClient.getBlockState (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // 42: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 47: instanceof net/minecraft/block/BlockBed
      // 4a: istore 2
      // 4b: aload 0
      // 4c: getfield x/oc8edd24b1ed.J Lnet/minecraft/util/BlockPos;
      // 4f: ifnull 7a
      // 52: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 55: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 58: aload 0
      // 59: getfield x/oc8edd24b1ed.J Lnet/minecraft/util/BlockPos;
      // 5c: invokevirtual net/minecraft/client/multiplayer/WorldClient.getBlockState (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // 5f: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 64: instanceof net/minecraft/block/BlockBed
      // 67: iload 1
      // 68: ifne 77
      // 6b: goto 6f
      // 6e: athrow
      // 6f: ifeq 7a
      // 72: goto 76
      // 75: athrow
      // 76: bipush 1
      // 77: goto 7b
      // 7a: bipush 0
      // 7b: istore 3
      // 7c: iload 2
      // 7d: iload 1
      // 7e: ifne 89
      // 81: ifne 94
      // 84: goto 88
      // 87: athrow
      // 88: iload 3
      // 89: ifne 94
      // 8c: aload 0
      // 8d: invokevirtual x/oc8edd24b1ed.ҭ ()V
      // 90: goto 94
      // 93: athrow
      // 94: return
   }

   private boolean Ѯ() {
      int var1 = oc84f20a0bc5.ė;
      int var2 = -53643393 ^ 1335128614;

      while (true) {
         switch (var2) {
            case -1719318918:
               return false;
            case -1286011559:
               if (this.Ū != null) {
                  var2 = 65804657 ^ 1335128614;
                  if (var1 == 0) {
                     break;
                  }
               }

               var2 = -703515556 ^ 1335128614;
               if (var1 == 0) {
                  break;
               }
            case 1634520818:
               return true;
            case 1282960215:
               int var10000;
               label36: {
                  label35: {
                     try {
                        var10000 = oc69da1aa7f5.ő.theWorld.getBlockState(this.Ū).getBlock() instanceof BlockBed;
                        if (var1 != 0) {
                           break label36;
                        }

                        if (var10000 != 0) {
                           break label35;
                        }
                     } catch (ocbde1165e4e var3) {
                        throw var3;
                     }

                     var2 = 788053204 ^ 1335128614;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var10000 = -703515556 ^ 1335128614;
               }

               var2 = var10000;
               break;
            default:
               throw null;
         }
      }
   }

   private void ђ() {
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
      // 05: getfield x/oc8edd24b1ed.Ū Lnet/minecraft/util/BlockPos;
      // 08: ifnull 18
      // 0b: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0e: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 11: ifnonnull 1a
      // 14: goto 18
      // 17: athrow
      // 18: return
      // 19: athrow
      // 1a: aload 0
      // 1b: aload 0
      // 1c: getfield x/oc8edd24b1ed.Ū Lnet/minecraft/util/BlockPos;
      // 1f: putfield x/oc8edd24b1ed.ĝ Lnet/minecraft/util/BlockPos;
      // 22: aload 0
      // 23: aload 0
      // 24: iload 1
      // 25: ifne 3f
      // 28: getfield x/oc8edd24b1ed.å Lnet/minecraft/util/BlockPos;
      // 2b: putfield x/oc8edd24b1ed.J Lnet/minecraft/util/BlockPos;
      // 2e: aload 0
      // 2f: aload 0
      // 30: getfield x/oc8edd24b1ed.ŷ Lnet/minecraft/util/Vec3;
      // 33: ifnull 45
      // 36: goto 3a
      // 39: athrow
      // 3a: aload 0
      // 3b: goto 3f
      // 3e: athrow
      // 3f: getfield x/oc8edd24b1ed.ŷ Lnet/minecraft/util/Vec3;
      // 42: goto 70
      // 45: new net/minecraft/util/Vec3
      // 48: dup
      // 49: aload 0
      // 4a: getfield x/oc8edd24b1ed.Ū Lnet/minecraft/util/BlockPos;
      // 4d: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 50: i2d
      // 51: ldc2_w 0.5
      // 54: dadd
      // 55: aload 0
      // 56: getfield x/oc8edd24b1ed.Ū Lnet/minecraft/util/BlockPos;
      // 59: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 5c: i2d
      // 5d: ldc2_w 0.5
      // 60: dadd
      // 61: aload 0
      // 62: getfield x/oc8edd24b1ed.Ū Lnet/minecraft/util/BlockPos;
      // 65: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 68: i2d
      // 69: ldc2_w 0.5
      // 6c: dadd
      // 6d: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 70: putfield x/oc8edd24b1ed.ΐ Lnet/minecraft/util/Vec3;
      // 73: aload 0
      // 74: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 77: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 7a: getfield net/minecraft/client/entity/EntityPlayerSP.ticksExisted I
      // 7d: ldc_w -1440038874
      // 80: ldc_w -1440038868
      // 83: ixor
      // 84: iadd
      // 85: putfield x/oc8edd24b1ed.ɥ I
      // 88: aload 0
      // 89: invokevirtual x/oc8edd24b1ed.P ()V
      // 8c: aload 0
      // 8d: invokevirtual x/oc8edd24b1ed.Ը ()V
      // 90: return
   }

   private void Լ(BlockPos var1, Block var2) {
      try {
         if (é(var1, var2 instanceof BlockBed, this.Ū, this.å)) {
            this.ђ();
         }
      } catch (ocbde1165e4e var3) {
         throw var3;
      }
   }

   static boolean é(BlockPos param0, boolean param1, BlockPos param2, BlockPos param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 4
      // 05: iload 1
      // 06: ifne 44
      // 09: aload 0
      // 0a: iload 4
      // 0c: ifne 1b
      // 0f: goto 13
      // 12: athrow
      // 13: ifnull 44
      // 16: goto 1a
      // 19: athrow
      // 1a: aload 0
      // 1b: aload 2
      // 1c: invokevirtual net/minecraft/util/BlockPos.equals (Ljava/lang/Object;)Z
      // 1f: iload 4
      // 21: ifne 41
      // 24: ifne 40
      // 27: goto 2b
      // 2a: athrow
      // 2b: aload 0
      // 2c: aload 3
      // 2d: invokevirtual net/minecraft/util/BlockPos.equals (Ljava/lang/Object;)Z
      // 30: iload 4
      // 32: ifne 41
      // 35: goto 39
      // 38: athrow
      // 39: ifeq 44
      // 3c: goto 40
      // 3f: athrow
      // 40: bipush 1
      // 41: goto 45
      // 44: bipush 0
      // 45: ireturn
   }

   private void σ() {
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
      // 06: ifne 8b
      // 09: getfield x/oc8edd24b1ed.Ѥ Lnet/minecraft/util/BlockPos;
      // 0c: ifnull 58
      // 0f: goto 13
      // 12: athrow
      // 13: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 16: iload 1
      // 17: ifne 2f
      // 1a: goto 1e
      // 1d: athrow
      // 1e: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 21: ifnull 58
      // 24: goto 28
      // 27: athrow
      // 28: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 2b: goto 2f
      // 2e: athrow
      // 2f: iload 1
      // 30: ifne 44
      // 33: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 36: ifnull 58
      // 39: goto 3d
      // 3c: athrow
      // 3d: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 40: goto 44
      // 43: athrow
      // 44: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 47: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 4a: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 4d: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getEntityId ()I
      // 50: aload 0
      // 51: getfield x/oc8edd24b1ed.Ѥ Lnet/minecraft/util/BlockPos;
      // 54: bipush -1
      // 55: invokevirtual net/minecraft/client/multiplayer/WorldClient.sendBlockBreakProgress (ILnet/minecraft/util/BlockPos;I)V
      // 58: aload 0
      // 59: aconst_null
      // 5a: putfield x/oc8edd24b1ed.Ѥ Lnet/minecraft/util/BlockPos;
      // 5d: aload 0
      // 5e: aconst_null
      // 5f: putfield x/oc8edd24b1ed.Б Lnet/minecraft/util/Vec3;
      // 62: aload 0
      // 63: aconst_null
      // 64: putfield x/oc8edd24b1ed.Ї Lnet/minecraft/block/Block;
      // 67: aload 0
      // 68: bipush 0
      // 69: putfield x/oc8edd24b1ed.Ǡ I
      // 6c: aload 0
      // 6d: bipush 0
      // 6e: putfield x/oc8edd24b1ed.ə I
      // 71: aload 0
      // 72: fconst_0
      // 73: putfield x/oc8edd24b1ed.ƙ F
      // 76: aload 0
      // 77: bipush 0
      // 78: putfield x/oc8edd24b1ed.ɗ Z
      // 7b: aload 0
      // 7c: bipush 0
      // 7d: putfield x/oc8edd24b1ed.Ͽ Z
      // 80: aload 0
      // 81: bipush 0
      // 82: putfield x/oc8edd24b1ed.Є Z
      // 85: aload 0
      // 86: bipush 0
      // 87: putfield x/oc8edd24b1ed.ʕ I
      // 8a: aload 0
      // 8b: bipush 0
      // 8c: putfield x/oc8edd24b1ed.Ӑ I
      // 8f: return
   }

   private void Ν() {
      this.Ϣ = System.currentTimeMillis() + (4727101679953841152L ^ 4727101679953842152L);
   }

   private void ȑ() {
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
      // 005: getfield x/oc8edd24b1ed.Ϣ J
      // 008: iload 1
      // 009: ifne 01c
      // 00c: lconst_0
      // 00d: lcmp
      // 00e: iflt 02c
      // 011: goto 015
      // 014: athrow
      // 015: invokestatic java/lang/System.currentTimeMillis ()J
      // 018: goto 01c
      // 01b: athrow
      // 01c: aload 0
      // 01d: getfield x/oc8edd24b1ed.Ϣ J
      // 020: lcmp
      // 021: iload 1
      // 022: ifne 042
      // 025: ifge 02d
      // 028: goto 02c
      // 02b: athrow
      // 02c: return
      // 02d: aload 0
      // 02e: ldc2_w 875829395778625594
      // 031: ldc2_w -875829395778625595
      // 034: lxor
      // 035: putfield x/oc8edd24b1ed.Ϣ J
      // 038: aload 0
      // 039: getfield x/oc8edd24b1ed.S Ljava/util/ArrayList;
      // 03c: invokevirtual java/util/ArrayList.clear ()V
      // 03f: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 042: iload 1
      // 043: ifne 05a
      // 046: ifne 04e
      // 049: goto 04d
      // 04c: athrow
      // 04d: return
      // 04e: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 051: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 054: getfield net/minecraft/client/entity/EntityPlayerSP.posX D
      // 057: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 05a: istore 2
      // 05b: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 05e: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 061: getfield net/minecraft/client/entity/EntityPlayerSP.posY D
      // 064: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 067: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 06a: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getEyeHeight ()F
      // 06d: f2d
      // 06e: dadd
      // 06f: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 072: istore 3
      // 073: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 076: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 079: getfield net/minecraft/client/entity/EntityPlayerSP.posZ D
      // 07c: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 07f: istore 4
      // 081: iload 2
      // 082: ldc_w -709702847
      // 085: ldc_w -709702824
      // 088: ixor
      // 089: isub
      // 08a: istore 5
      // 08c: iload 5
      // 08e: iload 2
      // 08f: ldc_w -709702847
      // 092: ldc_w -709702824
      // 095: ixor
      // 096: iadd
      // 097: if_icmpgt 12a
      // 09a: iload 3
      // 09b: ldc_w -709702847
      // 09e: ldc_w -709702824
      // 0a1: ixor
      // 0a2: isub
      // 0a3: istore 6
      // 0a5: iload 6
      // 0a7: iload 3
      // 0a8: ldc_w -709702847
      // 0ab: ldc_w -709702824
      // 0ae: ixor
      // 0af: iadd
      // 0b0: if_icmpgt 123
      // 0b3: iload 4
      // 0b5: ldc_w -709702847
      // 0b8: ldc_w -709702824
      // 0bb: ixor
      // 0bc: iload 1
      // 0bd: ifne 097
      // 0c0: isub
      // 0c1: istore 7
      // 0c3: iload 7
      // 0c5: iload 4
      // 0c7: ldc_w -709702847
      // 0ca: ldc_w -709702824
      // 0cd: ixor
      // 0ce: iadd
      // 0cf: if_icmpgt 11c
      // 0d2: new net/minecraft/util/BlockPos
      // 0d5: dup
      // 0d6: iload 5
      // 0d8: iload 6
      // 0da: iload 7
      // 0dc: invokespecial net/minecraft/util/BlockPos.<init> (III)V
      // 0df: astore 8
      // 0e1: iload 1
      // 0e2: ifne 11f
      // 0e5: iload 1
      // 0e6: ifne 118
      // 0e9: goto 0ed
      // 0ec: athrow
      // 0ed: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0f0: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 0f3: aload 8
      // 0f5: invokevirtual net/minecraft/client/multiplayer/WorldClient.getBlockState (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // 0f8: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 0fd: instanceof net/minecraft/block/BlockBed
      // 100: ifeq 115
      // 103: goto 107
      // 106: athrow
      // 107: aload 0
      // 108: getfield x/oc8edd24b1ed.S Ljava/util/ArrayList;
      // 10b: aload 8
      // 10d: invokevirtual java/util/ArrayList.add (Ljava/lang/Object;)Z
      // 110: pop
      // 111: goto 115
      // 114: athrow
      // 115: iinc 7 1
      // 118: iload 1
      // 119: ifeq 0c3
      // 11c: iinc 6 1
      // 11f: iload 1
      // 120: ifeq 0a5
      // 123: iinc 5 1
      // 126: iload 1
      // 127: ifeq 08c
      // 12a: return
   }

   private float floatOwing() {
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
      // 06: ifne 17
      // 09: getfield x/oc8edd24b1ed.Ѥ Lnet/minecraft/util/BlockPos;
      // 0c: ifnonnull 16
      // 0f: goto 13
      // 12: athrow
      // 13: fconst_0
      // 14: freturn
      // 15: athrow
      // 16: aload 0
      // 17: invokevirtual x/oc8edd24b1ed.ǩ ()Z
      // 1a: ifeq 5b
      // 1d: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 20: iload 1
      // 21: ifne 38
      // 24: goto 28
      // 27: athrow
      // 28: getfield net/minecraft/client/Minecraft.playerController Lnet/minecraft/client/multiplayer/PlayerControllerMP;
      // 2b: ifnonnull 35
      // 2e: goto 32
      // 31: athrow
      // 32: fconst_0
      // 33: freturn
      // 34: athrow
      // 35: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 38: getfield net/minecraft/client/Minecraft.playerController Lnet/minecraft/client/multiplayer/PlayerControllerMP;
      // 3b: astore 2
      // 3c: aload 0
      // 3d: getfield x/oc8edd24b1ed.Ѥ Lnet/minecraft/util/BlockPos;
      // 40: aload 2
      // 41: invokeinterface x/oc51cbcffcfe.getCurrentBlock ()Lnet/minecraft/util/BlockPos; 1
      // 46: invokevirtual net/minecraft/util/BlockPos.equals (Ljava/lang/Object;)Z
      // 49: ifne 4f
      // 4c: fconst_0
      // 4d: freturn
      // 4e: athrow
      // 4f: aload 2
      // 50: invokeinterface x/oc51cbcffcfe.getCurBlockDamageMP ()F 1
      // 55: fconst_0
      // 56: fconst_1
      // 57: invokestatic net/minecraft/util/MathHelper.clamp_float (FFF)F
      // 5a: freturn
      // 5b: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 5e: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 61: aload 0
      // 62: getfield x/oc8edd24b1ed.Ѥ Lnet/minecraft/util/BlockPos;
      // 65: invokevirtual net/minecraft/client/multiplayer/WorldClient.getBlockState (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // 68: astore 2
      // 69: aload 2
      // 6a: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 6f: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 72: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 75: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 78: getfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 7b: invokestatic x/oc8825472e29.Ϻ (Lnet/minecraft/block/Block;I)I
      // 7e: istore 3
      // 7f: aload 0
      // 80: getfield x/oc8edd24b1ed.ə I
      // 83: i2f
      // 84: aload 0
      // 85: aload 2
      // 86: aload 0
      // 87: getfield x/oc8edd24b1ed.Ѥ Lnet/minecraft/util/BlockPos;
      // 8a: iload 3
      // 8b: bipush 1
      // 8c: invokevirtual x/oc8edd24b1ed.ѐ (Lnet/minecraft/block/state/IBlockState;Lnet/minecraft/util/BlockPos;IZ)F
      // 8f: fmul
      // 90: fstore 4
      // 92: fconst_1
      // 93: fload 4
      // 95: fconst_1
      // 96: fdiv
      // 97: invokestatic java/lang/Math.min (FF)F
      // 9a: freturn
   }

   private void Ը() {
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
      // 05: getfield x/oc8edd24b1ed.Ɩ I
      // 08: bipush -1
      // 09: if_icmpeq 21
      // 0c: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0f: iload 1
      // 10: ifne 26
      // 13: goto 17
      // 16: athrow
      // 17: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1a: ifnonnull 23
      // 1d: goto 21
      // 20: athrow
      // 21: return
      // 22: athrow
      // 23: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 26: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 29: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 2c: aload 0
      // 2d: getfield x/oc8edd24b1ed.Ɩ I
      // 30: putfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 33: aload 0
      // 34: invokevirtual x/oc8edd24b1ed.Ѝ ()V
      // 37: aload 0
      // 38: bipush -1
      // 39: putfield x/oc8edd24b1ed.Ɩ I
      // 3c: return
   }

   private void Ѝ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 1
      // 04: iload 1
      // 05: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 08: getfield net/minecraft/client/Minecraft.playerController Lnet/minecraft/client/multiplayer/PlayerControllerMP;
      // 0b: invokeinterface x/oc51cbcffcfe.getCurrentPlayerItem ()I 1
      // 10: istore 2
      // 11: ifne 40
      // 14: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 17: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1a: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 1d: getfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 20: iload 2
      // 21: if_icmpeq 35
      // 24: goto 28
      // 27: athrow
      // 28: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 2b: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 2e: invokevirtual net/minecraft/client/entity/EntityPlayerSP.stopUsingItem ()V
      // 31: goto 35
      // 34: athrow
      // 35: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 38: getfield net/minecraft/client/Minecraft.playerController Lnet/minecraft/client/multiplayer/PlayerControllerMP;
      // 3b: invokeinterface x/oc51cbcffcfe.callSyncCurrentPlayItem ()V 1
      // 40: return
   }

   private void Ϣ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 1
      // 04: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 07: iload 1
      // 08: ifne 1a
      // 0b: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 0e: ifnonnull 17
      // 11: goto 15
      // 14: athrow
      // 15: return
      // 16: athrow
      // 17: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1a: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 1d: getfield net/minecraft/client/settings/GameSettings.keyBindAttack Lnet/minecraft/client/settings/KeyBinding;
      // 20: invokevirtual net/minecraft/client/settings/KeyBinding.getKeyCode ()I
      // 23: istore 2
      // 24: iload 2
      // 25: iload 1
      // 26: ifne 35
      // 29: ifne 31
      // 2c: goto 30
      // 2f: athrow
      // 30: return
      // 31: aload 0
      // 32: getfield x/oc8edd24b1ed.ô Z
      // 35: iload 1
      // 36: ifne 50
      // 39: ifne 5f
      // 3c: goto 40
      // 3f: athrow
      // 40: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 43: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 46: getfield net/minecraft/client/settings/GameSettings.keyBindAttack Lnet/minecraft/client/settings/KeyBinding;
      // 49: invokestatic x/oc7ab2161b9f.ն (Lnet/minecraft/client/settings/KeyBinding;)Z
      // 4c: goto 50
      // 4f: athrow
      // 50: iload 1
      // 51: ifne 5c
      // 54: ifne 5f
      // 57: goto 5b
      // 5a: athrow
      // 5b: bipush 1
      // 5c: goto 60
      // 5f: bipush 0
      // 60: istore 3
      // 61: iload 1
      // 62: ifne 89
      // 65: iload 2
      // 66: bipush 1
      // 67: invokestatic net/minecraft/client/settings/KeyBinding.setKeyBindState (IZ)V
      // 6a: iload 3
      // 6b: ifeq 7a
      // 6e: goto 72
      // 71: athrow
      // 72: iload 2
      // 73: invokestatic net/minecraft/client/settings/KeyBinding.onTick (I)V
      // 76: goto 7a
      // 79: athrow
      // 7a: aload 0
      // 7b: bipush 1
      // 7c: putfield x/oc8edd24b1ed.ά Z
      // 7f: aload 0
      // 80: bipush 1
      // 81: putfield x/oc8edd24b1ed.ô Z
      // 84: aload 0
      // 85: bipush 1
      // 86: putfield x/oc8edd24b1ed.Ͽ Z
      // 89: return
   }

   private void ƽ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 1
      // 04: iload 1
      // 05: aload 0
      // 06: bipush 0
      // 07: putfield x/oc8edd24b1ed.ô Z
      // 0a: ifne 1f
      // 0d: aload 0
      // 0e: getfield x/oc8edd24b1ed.ά Z
      // 11: ifne 1a
      // 14: goto 18
      // 17: athrow
      // 18: return
      // 19: athrow
      // 1a: aload 0
      // 1b: bipush 0
      // 1c: putfield x/oc8edd24b1ed.ά Z
      // 1f: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 22: iload 1
      // 23: ifne 35
      // 26: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 29: ifnonnull 32
      // 2c: goto 30
      // 2f: athrow
      // 30: return
      // 31: athrow
      // 32: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 35: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 38: getfield net/minecraft/client/settings/GameSettings.keyBindAttack Lnet/minecraft/client/settings/KeyBinding;
      // 3b: invokestatic x/oc7ab2161b9f.ն (Lnet/minecraft/client/settings/KeyBinding;)Z
      // 3e: istore 2
      // 3f: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 42: iload 1
      // 43: ifne 62
      // 46: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 49: getfield net/minecraft/client/settings/GameSettings.keyBindAttack Lnet/minecraft/client/settings/KeyBinding;
      // 4c: invokevirtual net/minecraft/client/settings/KeyBinding.getKeyCode ()I
      // 4f: iload 2
      // 50: invokestatic net/minecraft/client/settings/KeyBinding.setKeyBindState (IZ)V
      // 53: iload 2
      // 54: ifne 7d
      // 57: goto 5b
      // 5a: athrow
      // 5b: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 5e: goto 62
      // 61: athrow
      // 62: iload 1
      // 63: ifne 77
      // 66: getfield net/minecraft/client/Minecraft.playerController Lnet/minecraft/client/multiplayer/PlayerControllerMP;
      // 69: ifnull 7d
      // 6c: goto 70
      // 6f: athrow
      // 70: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 73: goto 77
      // 76: athrow
      // 77: getfield net/minecraft/client/Minecraft.playerController Lnet/minecraft/client/multiplayer/PlayerControllerMP;
      // 7a: invokevirtual net/minecraft/client/multiplayer/PlayerControllerMP.resetBlockRemoving ()V
      // 7d: return
   }

   private boolean ą(Block param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: aload 1
      // 04: invokevirtual net/minecraft/block/Block.getMaterial ()Lnet/minecraft/block/material/Material;
      // 07: astore 3
      // 08: istore 2
      // 09: aload 3
      // 0a: iload 2
      // 0b: ifne 1d
      // 0e: getstatic net/minecraft/block/material/Material.iron Lnet/minecraft/block/material/Material;
      // 11: if_acmpeq 39
      // 14: goto 18
      // 17: athrow
      // 18: aload 3
      // 19: goto 1d
      // 1c: athrow
      // 1d: iload 2
      // 1e: ifne 30
      // 21: getstatic net/minecraft/block/material/Material.anvil Lnet/minecraft/block/material/Material;
      // 24: if_acmpeq 39
      // 27: goto 2b
      // 2a: athrow
      // 2b: aload 3
      // 2c: goto 30
      // 2f: athrow
      // 30: getstatic net/minecraft/block/material/Material.rock Lnet/minecraft/block/material/Material;
      // 33: if_acmpeq 39
      // 36: bipush 1
      // 37: ireturn
      // 38: athrow
      // 39: bipush 0
      // 3a: istore 4
      // 3c: iload 4
      // 3e: ldc_w -551808494
      // 41: ldc_w -551808485
      // 44: ixor
      // 45: if_icmpge 85
      // 48: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 4b: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 4e: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 51: iload 4
      // 53: invokevirtual net/minecraft/entity/player/InventoryPlayer.getStackInSlot (I)Lnet/minecraft/item/ItemStack;
      // 56: astore 5
      // 58: iload 2
      // 59: ifne 81
      // 5c: aload 5
      // 5e: ifnull 7e
      // 61: goto 65
      // 64: athrow
      // 65: aload 5
      // 67: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 6a: instanceof net/minecraft/item/ItemPickaxe
      // 6d: iload 2
      // 6e: ifne 7d
      // 71: goto 75
      // 74: athrow
      // 75: ifeq 7e
      // 78: goto 7c
      // 7b: athrow
      // 7c: bipush 1
      // 7d: ireturn
      // 7e: iinc 4 1
      // 81: iload 2
      // 82: ifeq 3c
      // 85: bipush 0
      // 86: ireturn
   }

   private EnumFacing Ĝ(BlockPos param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: aload 1
      // 04: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 07: i2d
      // 08: ldc2_w 0.5
      // 0b: dadd
      // 0c: dstore 3
      // 0d: istore 2
      // 0e: aload 1
      // 0f: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 12: i2d
      // 13: ldc2_w 0.25
      // 16: dadd
      // 17: dstore 5
      // 19: aload 1
      // 1a: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 1d: i2d
      // 1e: ldc2_w 0.5
      // 21: dadd
      // 22: dstore 7
      // 24: aload 0
      // 25: dload 3
      // 26: dload 5
      // 28: dload 7
      // 2a: invokevirtual x/oc8edd24b1ed.ȩ (DDD)[F
      // 2d: astore 9
      // 2f: ldc2_w 8.0
      // 32: aload 9
      // 34: bipush 0
      // 35: faload
      // 36: aload 9
      // 38: bipush 1
      // 39: faload
      // 3a: bipush 0
      // 3b: invokestatic x/oc75d51ec7eb.δ (DFFZ)Lnet/minecraft/util/MovingObjectPosition;
      // 3e: astore 10
      // 40: aload 10
      // 42: iload 2
      // 43: ifne 56
      // 46: ifnonnull 54
      // 49: goto 4d
      // 4c: athrow
      // 4d: getstatic net/minecraft/util/EnumFacing.UP Lnet/minecraft/util/EnumFacing;
      // 50: goto 59
      // 53: athrow
      // 54: aload 10
      // 56: getfield net/minecraft/util/MovingObjectPosition.sideHit Lnet/minecraft/util/EnumFacing;
      // 59: areturn
   }

   private float е(IBlockState param1, int param2, boolean param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 006: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 009: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 00c: iload 2
      // 00d: invokevirtual net/minecraft/entity/player/InventoryPlayer.getStackInSlot (I)Lnet/minecraft/item/ItemStack;
      // 010: astore 5
      // 012: istore 4
      // 014: aload 5
      // 016: iload 4
      // 018: ifne 029
      // 01b: ifnonnull 027
      // 01e: goto 022
      // 021: athrow
      // 022: fconst_1
      // 023: goto 037
      // 026: athrow
      // 027: aload 5
      // 029: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 02c: aload 5
      // 02e: aload 1
      // 02f: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 034: invokevirtual net/minecraft/item/Item.getStrVsBlock (Lnet/minecraft/item/ItemStack;Lnet/minecraft/block/Block;)F
      // 037: fstore 6
      // 039: fload 6
      // 03b: fconst_1
      // 03c: fcmpl
      // 03d: iload 4
      // 03f: ifne 086
      // 042: ifle 071
      // 045: goto 049
      // 048: athrow
      // 049: getstatic net/minecraft/enchantment/Enchantment.efficiency Lnet/minecraft/enchantment/Enchantment;
      // 04c: getfield net/minecraft/enchantment/Enchantment.effectId I
      // 04f: aload 5
      // 051: invokestatic net/minecraft/enchantment/EnchantmentHelper.getEnchantmentLevel (ILnet/minecraft/item/ItemStack;)I
      // 054: iload 4
      // 056: ifne 086
      // 059: goto 05d
      // 05c: athrow
      // 05d: istore 7
      // 05f: iload 7
      // 061: ifle 071
      // 064: fload 6
      // 066: iload 7
      // 068: iload 7
      // 06a: imul
      // 06b: i2f
      // 06c: fconst_1
      // 06d: fadd
      // 06e: fadd
      // 06f: fstore 6
      // 071: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 074: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 077: iload 4
      // 079: ifne 0b5
      // 07c: getstatic net/minecraft/potion/Potion.digSpeed Lnet/minecraft/potion/Potion;
      // 07f: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isPotionActive (Lnet/minecraft/potion/Potion;)Z
      // 082: goto 086
      // 085: athrow
      // 086: ifeq 0a6
      // 089: fload 6
      // 08b: fconst_1
      // 08c: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 08f: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 092: getstatic net/minecraft/potion/Potion.digSpeed Lnet/minecraft/potion/Potion;
      // 095: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getActivePotionEffect (Lnet/minecraft/potion/Potion;)Lnet/minecraft/potion/PotionEffect;
      // 098: invokevirtual net/minecraft/potion/PotionEffect.getAmplifier ()I
      // 09b: bipush 1
      // 09c: iadd
      // 09d: i2f
      // 09e: ldc_w 0.2
      // 0a1: fmul
      // 0a2: fadd
      // 0a3: fmul
      // 0a4: fstore 6
      // 0a6: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0a9: iload 4
      // 0ab: ifne 11b
      // 0ae: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0b1: goto 0b5
      // 0b4: athrow
      // 0b5: getstatic net/minecraft/potion/Potion.digSlowdown Lnet/minecraft/potion/Potion;
      // 0b8: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isPotionActive (Lnet/minecraft/potion/Potion;)Z
      // 0bb: ifeq 118
      // 0be: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0c1: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0c4: getstatic net/minecraft/potion/Potion.digSlowdown Lnet/minecraft/potion/Potion;
      // 0c7: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getActivePotionEffect (Lnet/minecraft/potion/Potion;)Lnet/minecraft/potion/PotionEffect;
      // 0ca: invokevirtual net/minecraft/potion/PotionEffect.getAmplifier ()I
      // 0cd: tableswitch 67 0 2 28 41 54
      // 0e8: athrow
      // 0e9: fload 6
      // 0eb: ldc_w 0.3
      // 0ee: fmul
      // 0ef: fstore 6
      // 0f1: iload 4
      // 0f3: ifeq 118
      // 0f6: fload 6
      // 0f8: ldc_w 0.09
      // 0fb: fmul
      // 0fc: fstore 6
      // 0fe: iload 4
      // 100: ifeq 118
      // 103: fload 6
      // 105: ldc_w 0.0027
      // 108: fmul
      // 109: fstore 6
      // 10b: iload 4
      // 10d: ifeq 118
      // 110: fload 6
      // 112: ldc_w 8.1E-4
      // 115: fmul
      // 116: fstore 6
      // 118: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 11b: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 11e: getstatic net/minecraft/block/material/Material.water Lnet/minecraft/block/material/Material;
      // 121: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isInsideOfMaterial (Lnet/minecraft/block/material/Material;)Z
      // 124: iload 4
      // 126: ifne 152
      // 129: ifeq 151
      // 12c: goto 130
      // 12f: athrow
      // 130: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 133: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 136: invokestatic net/minecraft/enchantment/EnchantmentHelper.getAquaAffinityModifier (Lnet/minecraft/entity/EntityLivingBase;)Z
      // 139: iload 4
      // 13b: ifne 152
      // 13e: goto 142
      // 141: athrow
      // 142: ifne 151
      // 145: goto 149
      // 148: athrow
      // 149: fload 6
      // 14b: ldc_w 5.0
      // 14e: fdiv
      // 14f: fstore 6
      // 151: iload 3
      // 152: ifne 15d
      // 155: fload 6
      // 157: ldc_w 5.0
      // 15a: fdiv
      // 15b: fstore 6
      // 15d: fload 6
      // 15f: freturn
   }

   private boolean R(Block var1, int var2) {
      ItemStack var4 = null;
      int var5 = 770770775 ^ 1241130268;
      int var3 = oc84f20a0bc5.ė;

      while (true) {
         switch (var5) {
            case -1663699806:
               int var9;
               label66: {
                  label65: {
                     try {
                        var9 = var4.canHarvestBlock(var1);
                        if (var3 != 0) {
                           break label66;
                        }

                        if (var9 == 0) {
                           break label65;
                        }
                     } catch (ocbde1165e4e var8) {
                        throw var8;
                     }

                     var5 = 322197619 ^ 1241130268;
                     if (var3 == 0) {
                        break;
                     }
                  }

                  var9 = 444284412 ^ 1241130268;
               }

               var5 = var9;
               if (var3 == 0) {
                  break;
               }
            case 485335510:
               return true;
            case 1400969440:
               return false;
            case 1523481967:
               return true;
            case 1678451275:
               int var10000;
               label57: {
                  label56: {
                     try {
                        var10000 = var1.getMaterial().isToolNotRequired();
                        if (var3 != 0) {
                           break label57;
                        }

                        if (var10000 == 0) {
                           break label56;
                        }
                     } catch (ocbde1165e4e var7) {
                        throw var7;
                     }

                     var5 = 1427604682 ^ 1241130268;
                     if (var3 == 0) {
                        break;
                     }
                  }

                  var10000 = 1442643214 ^ 1241130268;
               }

               var5 = var10000;
               if (var3 == 0) {
                  break;
               }
            case 470210578:
               var4 = oc69da1aa7f5.ő.thePlayer.inventory.getStackInSlot(var2);

               label47: {
                  try {
                     if (var3 != 0) {
                        break;
                     }

                     if (var4 == null) {
                        break label47;
                     }
                  } catch (ocbde1165e4e var6) {
                     throw var6;
                  }

                  var5 = -718286402 ^ 1241130268;
                  if (var3 == 0) {
                     break;
                  }
               }

               var5 = 444284412 ^ 1241130268;
               break;
            default:
               throw null;
         }
      }
   }

   private float ѐ(IBlockState param1, BlockPos param2, int param3, boolean param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: aload 1
      // 04: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 09: astore 6
      // 0b: aload 6
      // 0d: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 10: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 13: aload 2
      // 14: invokevirtual net/minecraft/block/Block.getBlockHardness (Lnet/minecraft/world/World;Lnet/minecraft/util/BlockPos;)F
      // 17: fstore 7
      // 19: istore 5
      // 1b: aload 0
      // 1c: aload 6
      // 1e: iload 3
      // 1f: invokevirtual x/oc8edd24b1ed.R (Lnet/minecraft/block/Block;I)Z
      // 22: ifeq 2c
      // 25: ldc_w 30.0
      // 28: goto 2f
      // 2b: athrow
      // 2c: ldc_w 100.0
      // 2f: fstore 8
      // 31: fload 7
      // 33: iload 5
      // 35: ifne 51
      // 38: fconst_0
      // 39: fcmpg
      // 3a: ifge 46
      // 3d: goto 41
      // 40: athrow
      // 41: fconst_0
      // 42: goto 54
      // 45: athrow
      // 46: aload 0
      // 47: aload 1
      // 48: iload 3
      // 49: iload 4
      // 4b: invokevirtual x/oc8edd24b1ed.е (Lnet/minecraft/block/state/IBlockState;IZ)F
      // 4e: fload 7
      // 50: fdiv
      // 51: fload 8
      // 53: fdiv
      // 54: freturn
   }

   private float ҵ(BlockPos var1) {
      IBlockState var2 = oc69da1aa7f5.ő.theWorld.getBlockState(var1);
      int var3 = oc8825472e29.Ϻ(var2.getBlock(), oc69da1aa7f5.ő.thePlayer.inventory.currentItem);
      return this.ѐ(var2, var1, var3, oc69da1aa7f5.ő.thePlayer.onGround);
   }

   private BlockPos д(BlockPos param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 006: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 009: aload 1
      // 00a: invokevirtual net/minecraft/client/multiplayer/WorldClient.getBlockState (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // 00d: astore 3
      // 00e: istore 2
      // 00f: aload 3
      // 010: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 015: instanceof net/minecraft/block/BlockBed
      // 018: ifne 01e
      // 01b: aconst_null
      // 01c: areturn
      // 01d: athrow
      // 01e: new java/util/ArrayList
      // 021: dup
      // 022: invokespecial java/util/ArrayList.<init> ()V
      // 025: astore 4
      // 027: aload 3
      // 028: getstatic net/minecraft/block/BlockBed.PART Lnet/minecraft/block/properties/PropertyEnum;
      // 02b: invokeinterface net/minecraft/block/state/IBlockState.getValue (Lnet/minecraft/block/properties/IProperty;)Ljava/lang/Comparable; 2
      // 030: checkcast net/minecraft/block/BlockBed$EnumPartType
      // 033: astore 5
      // 035: aload 3
      // 036: getstatic net/minecraft/block/BlockBed.FACING Lnet/minecraft/block/properties/PropertyDirection;
      // 039: invokeinterface net/minecraft/block/state/IBlockState.getValue (Lnet/minecraft/block/properties/IProperty;)Ljava/lang/Comparable; 2
      // 03e: checkcast net/minecraft/util/EnumFacing
      // 041: astore 6
      // 043: aload 1
      // 044: aload 5
      // 046: getstatic net/minecraft/block/BlockBed$EnumPartType.HEAD Lnet/minecraft/block/BlockBed$EnumPartType;
      // 049: if_acmpne 055
      // 04c: aload 6
      // 04e: invokevirtual net/minecraft/util/EnumFacing.getOpposite ()Lnet/minecraft/util/EnumFacing;
      // 051: goto 057
      // 054: athrow
      // 055: aload 6
      // 057: invokevirtual net/minecraft/util/BlockPos.offset (Lnet/minecraft/util/EnumFacing;)Lnet/minecraft/util/BlockPos;
      // 05a: astore 7
      // 05c: ldc_w 145278248
      // 05f: ldc_w 145278250
      // 062: ixor
      // 063: anewarray 300
      // 066: dup
      // 067: bipush 0
      // 068: aload 1
      // 069: aastore
      // 06a: dup
      // 06b: bipush 1
      // 06c: aload 7
      // 06e: aastore
      // 06f: invokestatic java/util/Arrays.asList ([Ljava/lang/Object;)Ljava/util/List;
      // 072: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 077: astore 8
      // 079: aload 8
      // 07b: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 080: ifeq 143
      // 083: aload 8
      // 085: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 08a: checkcast net/minecraft/util/BlockPos
      // 08d: iload 2
      // 08e: ifne 16a
      // 091: astore 9
      // 093: ldc_w 145278255
      // 096: ldc_w 145278250
      // 099: ixor
      // 09a: anewarray 332
      // 09d: dup
      // 09e: bipush 0
      // 09f: getstatic net/minecraft/util/EnumFacing.UP Lnet/minecraft/util/EnumFacing;
      // 0a2: aastore
      // 0a3: dup
      // 0a4: bipush 1
      // 0a5: getstatic net/minecraft/util/EnumFacing.NORTH Lnet/minecraft/util/EnumFacing;
      // 0a8: aastore
      // 0a9: dup
      // 0aa: ldc_w 145278248
      // 0ad: ldc_w 145278250
      // 0b0: ixor
      // 0b1: getstatic net/minecraft/util/EnumFacing.EAST Lnet/minecraft/util/EnumFacing;
      // 0b4: aastore
      // 0b5: dup
      // 0b6: ldc_w 145278249
      // 0b9: ldc_w 145278250
      // 0bc: ixor
      // 0bd: getstatic net/minecraft/util/EnumFacing.SOUTH Lnet/minecraft/util/EnumFacing;
      // 0c0: aastore
      // 0c1: dup
      // 0c2: ldc_w 145278254
      // 0c5: ldc_w 145278250
      // 0c8: ixor
      // 0c9: getstatic net/minecraft/util/EnumFacing.WEST Lnet/minecraft/util/EnumFacing;
      // 0cc: aastore
      // 0cd: invokestatic java/util/Arrays.asList ([Ljava/lang/Object;)Ljava/util/List;
      // 0d0: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 0d5: astore 10
      // 0d7: aload 10
      // 0d9: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 0de: ifeq 13f
      // 0e1: aload 10
      // 0e3: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 0e8: checkcast net/minecraft/util/EnumFacing
      // 0eb: astore 11
      // 0ed: iload 2
      // 0ee: aload 9
      // 0f0: aload 11
      // 0f2: invokevirtual net/minecraft/util/BlockPos.offset (Lnet/minecraft/util/EnumFacing;)Lnet/minecraft/util/BlockPos;
      // 0f5: astore 12
      // 0f7: ifne 079
      // 0fa: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0fd: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 100: aload 12
      // 102: invokevirtual net/minecraft/client/multiplayer/WorldClient.getBlockState (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // 105: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 10a: astore 13
      // 10c: aload 12
      // 10e: invokestatic x/occb1ed1ed8f.ɍ (Lnet/minecraft/util/BlockPos;)Z
      // 111: iload 2
      // 112: ifne 124
      // 115: ifeq 11f
      // 118: goto 11c
      // 11b: athrow
      // 11c: aconst_null
      // 11d: areturn
      // 11e: athrow
      // 11f: aload 13
      // 121: instanceof net/minecraft/block/BlockBed
      // 124: iload 2
      // 125: ifne 13a
      // 128: ifne 13b
      // 12b: goto 12f
      // 12e: athrow
      // 12f: aload 4
      // 131: aload 12
      // 133: invokevirtual java/util/ArrayList.add (Ljava/lang/Object;)Z
      // 136: goto 13a
      // 139: athrow
      // 13a: pop
      // 13b: iload 2
      // 13c: ifeq 0d7
      // 13f: iload 2
      // 140: ifeq 079
      // 143: aload 4
      // 145: iload 2
      // 146: ifne 167
      // 149: invokevirtual java/util/ArrayList.isEmpty ()Z
      // 14c: ifeq 156
      // 14f: goto 153
      // 152: athrow
      // 153: aconst_null
      // 154: areturn
      // 155: athrow
      // 156: aload 4
      // 158: aload 0
      // 159: invokedynamic compare (Lx/oc8edd24b1ed;)Ljava/util/Comparator; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;Ljava/lang/Object;)I, x/oc8edd24b1ed.q3aikknxf39572 (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/BlockPos;)I, (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/BlockPos;)I ]
      // 15e: invokevirtual java/util/ArrayList.sort (Ljava/util/Comparator;)V
      // 161: aload 4
      // 163: bipush 0
      // 164: invokevirtual java/util/ArrayList.get (I)Ljava/lang/Object;
      // 167: checkcast net/minecraft/util/BlockPos
      // 16a: areturn
   }

   private BlockPos Ï() {
      return this.ƕ(oc69da1aa7f5.ő.thePlayer.posX, oc69da1aa7f5.ő.thePlayer.posY + oc69da1aa7f5.ő.thePlayer.getEyeHeight(), oc69da1aa7f5.ő.thePlayer.posZ);
   }

   private BlockPos ƕ(double param1, double param3, double param5) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: istore 7
      // 005: aload 0
      // 006: invokevirtual x/oc8edd24b1ed.д ()Z
      // 009: ifeq 00f
      // 00c: aconst_null
      // 00d: areturn
      // 00e: athrow
      // 00f: new java/util/ArrayList
      // 012: dup
      // 013: invokespecial java/util/ArrayList.<init> ()V
      // 016: astore 8
      // 018: dload 1
      // 019: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 01c: istore 9
      // 01e: dload 3
      // 01f: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 022: istore 10
      // 024: dload 5
      // 026: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 029: istore 11
      // 02b: iload 9
      // 02d: ldc_w -1635518024
      // 030: ldc_w -1635518018
      // 033: ixor
      // 034: isub
      // 035: istore 12
      // 037: iload 12
      // 039: iload 9
      // 03b: ldc_w -1635518024
      // 03e: ldc_w -1635518018
      // 041: ixor
      // 042: iadd
      // 043: if_icmpgt 146
      // 046: iload 7
      // 048: ifne 167
      // 04b: iload 10
      // 04d: ldc_w -1635518024
      // 050: ldc_w -1635518018
      // 053: ixor
      // 054: isub
      // 055: istore 13
      // 057: iload 13
      // 059: iload 10
      // 05b: ldc_w -1635518024
      // 05e: ldc_w -1635518018
      // 061: ixor
      // 062: iadd
      // 063: if_icmpgt 13e
      // 066: iload 11
      // 068: iload 7
      // 06a: ifne 039
      // 06d: ldc_w -1635518024
      // 070: ldc_w -1635518018
      // 073: ixor
      // 074: isub
      // 075: istore 14
      // 077: iload 14
      // 079: iload 11
      // 07b: ldc_w -1635518024
      // 07e: ldc_w -1635518018
      // 081: ixor
      // 082: iadd
      // 083: if_icmpgt 136
      // 086: new net/minecraft/util/BlockPos
      // 089: dup
      // 08a: iload 12
      // 08c: iload 13
      // 08e: iload 14
      // 090: invokespecial net/minecraft/util/BlockPos.<init> (III)V
      // 093: astore 15
      // 095: iload 7
      // 097: ifne 139
      // 09a: aload 0
      // 09b: iload 7
      // 09d: ifne 0cf
      // 0a0: goto 0a4
      // 0a3: athrow
      // 0a4: getfield x/oc8edd24b1ed.Տ Lx/occ2f8dff8d8;
      // 0a7: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 0aa: ifeq 0ce
      // 0ad: goto 0b1
      // 0b0: athrow
      // 0b1: aload 0
      // 0b2: iload 7
      // 0b4: ifne 0cf
      // 0b7: goto 0bb
      // 0ba: athrow
      // 0bb: getfield x/oc8edd24b1ed.S Ljava/util/ArrayList;
      // 0be: aload 15
      // 0c0: invokevirtual java/util/ArrayList.contains (Ljava/lang/Object;)Z
      // 0c3: ifeq 0ce
      // 0c6: goto 0ca
      // 0c9: athrow
      // 0ca: goto 12e
      // 0cd: athrow
      // 0ce: aload 0
      // 0cf: aload 15
      // 0d1: invokevirtual x/oc8edd24b1ed.ȉ (Lnet/minecraft/util/BlockPos;)Z
      // 0d4: iload 7
      // 0d6: ifne 0f6
      // 0d9: ifeq 0e3
      // 0dc: goto 0e0
      // 0df: athrow
      // 0e0: goto 12e
      // 0e3: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0e6: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 0e9: aload 15
      // 0eb: invokevirtual net/minecraft/client/multiplayer/WorldClient.getBlockState (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // 0ee: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 0f3: instanceof net/minecraft/block/BlockBed
      // 0f6: iload 7
      // 0f8: ifne 116
      // 0fb: ifeq 12e
      // 0fe: goto 102
      // 101: athrow
      // 102: aload 15
      // 104: dload 1
      // 105: dload 3
      // 106: dload 5
      // 108: aload 0
      // 109: getfield x/oc8edd24b1ed.ǉ Lx/oca9cc61aada;
      // 10c: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 10f: invokestatic x/ocd84af7ddf8.կ (Lnet/minecraft/util/BlockPos;DDDD)Z
      // 112: goto 116
      // 115: athrow
      // 116: iload 7
      // 118: ifne 12d
      // 11b: ifeq 12e
      // 11e: goto 122
      // 121: athrow
      // 122: aload 8
      // 124: aload 15
      // 126: invokevirtual java/util/ArrayList.add (Ljava/lang/Object;)Z
      // 129: goto 12d
      // 12c: athrow
      // 12d: pop
      // 12e: iinc 14 1
      // 131: iload 7
      // 133: ifeq 077
      // 136: iinc 13 1
      // 139: iload 7
      // 13b: ifeq 057
      // 13e: iinc 12 1
      // 141: iload 7
      // 143: ifeq 037
      // 146: aload 8
      // 148: iload 7
      // 14a: ifne 169
      // 14d: invokevirtual java/util/ArrayList.isEmpty ()Z
      // 150: ifeq 15a
      // 153: goto 157
      // 156: athrow
      // 157: aconst_null
      // 158: areturn
      // 159: athrow
      // 15a: aload 8
      // 15c: invokedynamic applyAsDouble ()Ljava/util/function/ToDoubleFunction; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)D, x/oc8edd24b1ed.qkzqlcp0a4ka (Lnet/minecraft/util/BlockPos;)D, (Lnet/minecraft/util/BlockPos;)D ]
      // 161: invokestatic java/util/Comparator.comparingDouble (Ljava/util/function/ToDoubleFunction;)Ljava/util/Comparator;
      // 164: invokevirtual java/util/ArrayList.sort (Ljava/util/Comparator;)V
      // 167: aload 8
      // 169: invokevirtual java/util/ArrayList.iterator ()Ljava/util/Iterator;
      // 16c: astore 12
      // 16e: aload 12
      // 170: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 175: ifeq 1d7
      // 178: aload 12
      // 17a: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 17f: checkcast net/minecraft/util/BlockPos
      // 182: astore 13
      // 184: aload 0
      // 185: iload 7
      // 187: ifne 19c
      // 18a: getfield x/oc8edd24b1ed.Ò Lx/occ2f8dff8d8;
      // 18d: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 190: ifeq 1d4
      // 193: goto 197
      // 196: athrow
      // 197: aload 0
      // 198: goto 19c
      // 19b: athrow
      // 19c: aload 13
      // 19e: invokevirtual x/oc8edd24b1ed.д (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/util/BlockPos;
      // 1a1: iload 7
      // 1a3: ifne 1d6
      // 1a6: astore 14
      // 1a8: aload 14
      // 1aa: ifnull 1d4
      // 1ad: aload 0
      // 1ae: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1b1: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 1b4: aload 14
      // 1b6: invokevirtual net/minecraft/client/multiplayer/WorldClient.getBlockState (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // 1b9: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 1be: invokevirtual x/oc8edd24b1ed.ą (Lnet/minecraft/block/Block;)Z
      // 1c1: ifne 1d1
      // 1c4: goto 1c8
      // 1c7: athrow
      // 1c8: iload 7
      // 1ca: ifeq 16e
      // 1cd: goto 1d1
      // 1d0: athrow
      // 1d1: aload 14
      // 1d3: areturn
      // 1d4: aload 13
      // 1d6: areturn
      // 1d7: aconst_null
      // 1d8: areturn
   }

   private void Ѣ() {
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
      // 006: ifne 02f
      // 009: invokevirtual x/oc8edd24b1ed.д ()Z
      // 00c: ifne 026
      // 00f: goto 013
      // 012: athrow
      // 013: aload 0
      // 014: iload 1
      // 015: ifne 034
      // 018: goto 01c
      // 01b: athrow
      // 01c: invokevirtual x/oc8edd24b1ed.ե ()Z
      // 01f: ifne 033
      // 022: goto 026
      // 025: athrow
      // 026: aload 0
      // 027: invokevirtual x/oc8edd24b1ed.P ()V
      // 02a: aload 0
      // 02b: goto 02f
      // 02e: athrow
      // 02f: invokevirtual x/oc8edd24b1ed.Ը ()V
      // 032: return
      // 033: aload 0
      // 034: iload 1
      // 035: ifne 049
      // 038: invokevirtual x/oc8edd24b1ed.Ѯ ()Z
      // 03b: ifeq 048
      // 03e: goto 042
      // 041: athrow
      // 042: aload 0
      // 043: invokevirtual x/oc8edd24b1ed.ђ ()V
      // 046: return
      // 047: athrow
      // 048: aload 0
      // 049: iload 1
      // 04a: ifne 062
      // 04d: invokevirtual x/oc8edd24b1ed.ҿ ()Z
      // 050: ifeq 061
      // 053: goto 057
      // 056: athrow
      // 057: aload 0
      // 058: invokevirtual x/oc8edd24b1ed.ƽ ()V
      // 05b: aload 0
      // 05c: invokevirtual x/oc8edd24b1ed.Ը ()V
      // 05f: return
      // 060: athrow
      // 061: aload 0
      // 062: iload 1
      // 063: ifne 0bc
      // 066: invokevirtual x/oc8edd24b1ed.ҡ ()Z
      // 069: ifne 0aa
      // 06c: goto 070
      // 06f: athrow
      // 070: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 073: iload 1
      // 074: ifne 08c
      // 077: goto 07b
      // 07a: athrow
      // 07b: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 07e: ifnonnull 0aa
      // 081: goto 085
      // 084: athrow
      // 085: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 088: goto 08c
      // 08b: athrow
      // 08c: iload 1
      // 08d: ifne 0a1
      // 090: getfield net/minecraft/client/Minecraft.inGameHasFocus Z
      // 093: ifeq 0aa
      // 096: goto 09a
      // 099: athrow
      // 09a: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 09d: goto 0a1
      // 0a0: athrow
      // 0a1: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0a4: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isUsingItem ()Z
      // 0a7: ifeq 0c1
      // 0aa: aload 0
      // 0ab: invokevirtual x/oc8edd24b1ed.ƽ ()V
      // 0ae: aload 0
      // 0af: invokevirtual x/oc8edd24b1ed.Ը ()V
      // 0b2: aload 0
      // 0b3: bipush 0
      // 0b4: putfield x/oc8edd24b1ed.Ͽ Z
      // 0b7: aload 0
      // 0b8: goto 0bc
      // 0bb: athrow
      // 0bc: bipush 0
      // 0bd: putfield x/oc8edd24b1ed.Є Z
      // 0c0: return
      // 0c1: aload 0
      // 0c2: invokevirtual x/oc8edd24b1ed.Ű ()D
      // 0c5: dstore 2
      // 0c6: aload 0
      // 0c7: iload 1
      // 0c8: ifne 1e0
      // 0cb: getfield x/oc8edd24b1ed.Ѥ Lnet/minecraft/util/BlockPos;
      // 0ce: ifnull 1df
      // 0d1: goto 0d5
      // 0d4: athrow
      // 0d5: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0d8: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 0db: aload 0
      // 0dc: getfield x/oc8edd24b1ed.Ѥ Lnet/minecraft/util/BlockPos;
      // 0df: invokevirtual net/minecraft/client/multiplayer/WorldClient.getBlockState (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // 0e2: astore 4
      // 0e4: aload 4
      // 0e6: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 0eb: astore 5
      // 0ed: aload 5
      // 0ef: iload 1
      // 0f0: ifne 119
      // 0f3: invokevirtual net/minecraft/block/Block.getMaterial ()Lnet/minecraft/block/material/Material;
      // 0f6: getstatic net/minecraft/block/material/Material.air Lnet/minecraft/block/material/Material;
      // 0f9: if_acmpne 111
      // 0fc: goto 100
      // 0ff: athrow
      // 100: aload 0
      // 101: bipush 0
      // 102: putfield x/oc8edd24b1ed.ʕ I
      // 105: iload 1
      // 106: aload 0
      // 107: invokevirtual x/oc8edd24b1ed.σ ()V
      // 10a: ifeq 1df
      // 10d: goto 111
      // 110: athrow
      // 111: aload 0
      // 112: getfield x/oc8edd24b1ed.Ї Lnet/minecraft/block/Block;
      // 115: goto 119
      // 118: athrow
      // 119: iload 1
      // 11a: ifne 13f
      // 11d: ifnull 139
      // 120: goto 124
      // 123: athrow
      // 124: aload 5
      // 126: iload 1
      // 127: ifne 13f
      // 12a: goto 12e
      // 12d: athrow
      // 12e: aload 0
      // 12f: getfield x/oc8edd24b1ed.Ї Lnet/minecraft/block/Block;
      // 132: if_acmpne 151
      // 135: goto 139
      // 138: athrow
      // 139: aload 5
      // 13b: goto 13f
      // 13e: athrow
      // 13f: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 142: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 145: aload 0
      // 146: getfield x/oc8edd24b1ed.Ѥ Lnet/minecraft/util/BlockPos;
      // 149: invokevirtual net/minecraft/block/Block.getBlockHardness (Lnet/minecraft/world/World;Lnet/minecraft/util/BlockPos;)F
      // 14c: fconst_0
      // 14d: fcmpg
      // 14e: ifge 156
      // 151: aconst_null
      // 152: goto 15f
      // 155: athrow
      // 156: aload 0
      // 157: aload 0
      // 158: getfield x/oc8edd24b1ed.Ѥ Lnet/minecraft/util/BlockPos;
      // 15b: dload 2
      // 15c: invokevirtual x/oc8edd24b1ed.w (Lnet/minecraft/util/BlockPos;D)Lnet/minecraft/util/Vec3;
      // 15f: astore 6
      // 161: iload 1
      // 162: ifne 1d6
      // 165: aload 6
      // 167: ifnonnull 1c7
      // 16a: goto 16e
      // 16d: athrow
      // 16e: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 171: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 174: fconst_1
      // 175: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getPositionEyes (F)Lnet/minecraft/util/Vec3;
      // 178: astore 7
      // 17a: iload 1
      // 17b: ifne 1bf
      // 17e: aload 0
      // 17f: aload 7
      // 181: aload 0
      // 182: getfield x/oc8edd24b1ed.Ѥ Lnet/minecraft/util/BlockPos;
      // 185: invokevirtual x/oc8edd24b1ed.ӂ (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/BlockPos;)D
      // 188: dload 2
      // 189: ldc2_w 1.0E-4
      // 18c: dadd
      // 18d: dcmpg
      // 18e: ifgt 1ba
      // 191: goto 195
      // 194: athrow
      // 195: aload 0
      // 196: dup
      // 197: getfield x/oc8edd24b1ed.ʕ I
      // 19a: iload 1
      // 19b: ifne 1bc
      // 19e: goto 1a2
      // 1a1: athrow
      // 1a2: bipush 1
      // 1a3: iadd
      // 1a4: dup_x1
      // 1a5: putfield x/oc8edd24b1ed.ʕ I
      // 1a8: ldc_w 861359602
      // 1ab: ldc_w 861359606
      // 1ae: ixor
      // 1af: if_icmpgt 1ba
      // 1b2: goto 1b6
      // 1b5: athrow
      // 1b6: goto 1c3
      // 1b9: athrow
      // 1ba: aload 0
      // 1bb: bipush 0
      // 1bc: putfield x/oc8edd24b1ed.ʕ I
      // 1bf: aload 0
      // 1c0: invokevirtual x/oc8edd24b1ed.P ()V
      // 1c3: iload 1
      // 1c4: ifeq 1df
      // 1c7: aload 0
      // 1c8: bipush 0
      // 1c9: putfield x/oc8edd24b1ed.ʕ I
      // 1cc: aload 0
      // 1cd: aload 6
      // 1cf: putfield x/oc8edd24b1ed.Б Lnet/minecraft/util/Vec3;
      // 1d2: goto 1d6
      // 1d5: athrow
      // 1d6: aload 0
      // 1d7: aload 5
      // 1d9: instanceof net/minecraft/block/BlockBed
      // 1dc: putfield x/oc8edd24b1ed.ɗ Z
      // 1df: aload 0
      // 1e0: iload 1
      // 1e1: ifne 1f8
      // 1e4: getfield x/oc8edd24b1ed.Ѥ Lnet/minecraft/util/BlockPos;
      // 1e7: ifnull 1f7
      // 1ea: goto 1ee
      // 1ed: athrow
      // 1ee: aload 0
      // 1ef: dload 2
      // 1f0: invokevirtual x/oc8edd24b1ed.F (D)V
      // 1f3: goto 1f7
      // 1f6: athrow
      // 1f7: aload 0
      // 1f8: iload 1
      // 1f9: ifne 20b
      // 1fc: getfield x/oc8edd24b1ed.Ѥ Lnet/minecraft/util/BlockPos;
      // 1ff: ifnonnull 23e
      // 202: goto 206
      // 205: athrow
      // 206: aload 0
      // 207: goto 20b
      // 20a: athrow
      // 20b: dload 2
      // 20c: invokevirtual x/oc8edd24b1ed.I (D)Lx/ocd840a448ba;
      // 20f: astore 4
      // 211: aload 4
      // 213: iload 1
      // 214: ifne 22b
      // 217: ifnonnull 229
      // 21a: goto 21e
      // 21d: athrow
      // 21e: aload 0
      // 21f: invokevirtual x/oc8edd24b1ed.ƙ ()V
      // 222: aload 0
      // 223: dload 2
      // 224: invokevirtual x/oc8edd24b1ed.Μ (D)Lx/ocd840a448ba;
      // 227: astore 4
      // 229: aload 4
      // 22b: ifnonnull 238
      // 22e: aload 0
      // 22f: invokevirtual x/oc8edd24b1ed.ƽ ()V
      // 232: aload 0
      // 233: invokevirtual x/oc8edd24b1ed.Ը ()V
      // 236: return
      // 237: athrow
      // 238: aload 0
      // 239: aload 4
      // 23b: invokevirtual x/oc8edd24b1ed.Ϙ (Lx/ocd840a448ba;)V
      // 23e: getstatic x/oc9755810e45.ğ Lx/oca3ff10b94f;
      // 241: iload 1
      // 242: ifne 24f
      // 245: ifnull 265
      // 248: goto 24c
      // 24b: athrow
      // 24c: getstatic x/oc9755810e45.ğ Lx/oca3ff10b94f;
      // 24f: invokevirtual x/oca3ff10b94f.ê ()Z
      // 252: ifeq 265
      // 255: aload 0
      // 256: invokevirtual x/oc8edd24b1ed.ƽ ()V
      // 259: aload 0
      // 25a: bipush 0
      // 25b: putfield x/oc8edd24b1ed.Ͽ Z
      // 25e: aload 0
      // 25f: bipush 0
      // 260: putfield x/oc8edd24b1ed.Є Z
      // 263: return
      // 264: athrow
      // 265: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 268: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 26b: aload 0
      // 26c: getfield x/oc8edd24b1ed.Ѥ Lnet/minecraft/util/BlockPos;
      // 26f: invokevirtual net/minecraft/client/multiplayer/WorldClient.getBlockState (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // 272: astore 4
      // 274: aload 4
      // 276: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 27b: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 27e: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 281: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 284: getfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 287: invokestatic x/oc8825472e29.Ϻ (Lnet/minecraft/block/Block;I)I
      // 28a: istore 5
      // 28c: aload 0
      // 28d: getfield x/oc8edd24b1ed.Ɩ I
      // 290: iload 1
      // 291: ifne 2c4
      // 294: bipush -1
      // 295: if_icmpne 2b0
      // 298: goto 29c
      // 29b: athrow
      // 29c: aload 0
      // 29d: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 2a0: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 2a3: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 2a6: getfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 2a9: putfield x/oc8edd24b1ed.Ɩ I
      // 2ac: goto 2b0
      // 2af: athrow
      // 2b0: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 2b3: iload 1
      // 2b4: ifne 2e7
      // 2b7: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 2ba: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 2bd: getfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 2c0: goto 2c4
      // 2c3: athrow
      // 2c4: iload 5
      // 2c6: if_icmpeq 2df
      // 2c9: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 2cc: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 2cf: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 2d2: iload 5
      // 2d4: putfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 2d7: aload 0
      // 2d8: invokevirtual x/oc8edd24b1ed.Ѝ ()V
      // 2db: goto 2df
      // 2de: athrow
      // 2df: aload 0
      // 2e0: bipush 1
      // 2e1: putfield x/oc8edd24b1ed.Ͽ Z
      // 2e4: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 2e7: getfield net/minecraft/client/Minecraft.playerController Lnet/minecraft/client/multiplayer/PlayerControllerMP;
      // 2ea: astore 6
      // 2ec: aload 0
      // 2ed: aload 0
      // 2ee: getfield x/oc8edd24b1ed.ά Z
      // 2f1: iload 1
      // 2f2: ifne 307
      // 2f5: ifeq 333
      // 2f8: goto 2fc
      // 2fb: athrow
      // 2fc: aload 6
      // 2fe: invokeinterface x/oc51cbcffcfe.isHittingBlock ()Z 1
      // 303: goto 307
      // 306: athrow
      // 307: iload 1
      // 308: ifne 324
      // 30b: ifeq 333
      // 30e: goto 312
      // 311: athrow
      // 312: aload 0
      // 313: getfield x/oc8edd24b1ed.Ѥ Lnet/minecraft/util/BlockPos;
      // 316: aload 6
      // 318: invokeinterface x/oc51cbcffcfe.getCurrentBlock ()Lnet/minecraft/util/BlockPos; 1
      // 31d: invokevirtual net/minecraft/util/BlockPos.equals (Ljava/lang/Object;)Z
      // 320: goto 324
      // 323: athrow
      // 324: iload 1
      // 325: ifne 330
      // 328: ifeq 333
      // 32b: goto 32f
      // 32e: athrow
      // 32f: bipush 1
      // 330: goto 334
      // 333: bipush 0
      // 334: putfield x/oc8edd24b1ed.Є Z
      // 337: return
   }

   private void Ϙ(ocd840a448ba var1) {
      this.Ѥ = var1.ƣ;
      this.Б = var1.ԁ;
      this.Ї = oc69da1aa7f5.ő.theWorld.getBlockState(this.Ѥ).getBlock();
      this.ɗ = var1.Ʃ;
      this.ů = var1.ӊ;
      this.ŷ = var1.ƕ;
      this.ŉ(var1.ӊ);
      this.Ǡ = 0;
      this.ə = 0;
      this.ƙ = 0.0F;
      this.Ժ = oc69da1aa7f5.ő.thePlayer.getPositionEyes(1.0F);
      this.È = oc69da1aa7f5.ő.thePlayer.ticksExisted;
   }

   private void F(double param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 006: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 009: fconst_1
      // 00a: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getPositionEyes (F)Lnet/minecraft/util/Vec3;
      // 00d: astore 4
      // 00f: istore 3
      // 010: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 013: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 016: getfield net/minecraft/client/entity/EntityPlayerSP.ticksExisted I
      // 019: istore 5
      // 01b: iload 3
      // 01c: ifne 047
      // 01f: aload 0
      // 020: getfield x/oc8edd24b1ed.Ժ Lnet/minecraft/util/Vec3;
      // 023: ifnull 037
      // 026: goto 02a
      // 029: athrow
      // 02a: iload 5
      // 02c: aload 0
      // 02d: getfield x/oc8edd24b1ed.È I
      // 030: if_icmpge 048
      // 033: goto 037
      // 036: athrow
      // 037: aload 0
      // 038: aload 4
      // 03a: putfield x/oc8edd24b1ed.Ժ Lnet/minecraft/util/Vec3;
      // 03d: aload 0
      // 03e: iload 5
      // 040: putfield x/oc8edd24b1ed.È I
      // 043: goto 047
      // 046: athrow
      // 047: return
      // 048: aload 0
      // 049: getfield x/oc8edd24b1ed.Ѥ Lnet/minecraft/util/BlockPos;
      // 04c: ifnull 0cf
      // 04f: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 052: getfield net/minecraft/client/Minecraft.playerController Lnet/minecraft/client/multiplayer/PlayerControllerMP;
      // 055: astore 6
      // 057: aload 6
      // 059: ifnull 0cf
      // 05c: aload 0
      // 05d: getfield x/oc8edd24b1ed.Ѥ Lnet/minecraft/util/BlockPos;
      // 060: aload 6
      // 062: invokeinterface x/oc51cbcffcfe.getCurrentBlock ()Lnet/minecraft/util/BlockPos; 1
      // 067: invokevirtual net/minecraft/util/BlockPos.equals (Ljava/lang/Object;)Z
      // 06a: iload 3
      // 06b: ifne 0de
      // 06e: goto 072
      // 071: athrow
      // 072: ifeq 0cf
      // 075: goto 079
      // 078: athrow
      // 079: aload 6
      // 07b: invokeinterface x/oc51cbcffcfe.getCurBlockDamageMP ()F 1
      // 080: ldc_w 0.05
      // 083: fcmpl
      // 084: iload 3
      // 085: ifne 0de
      // 088: goto 08c
      // 08b: athrow
      // 08c: ifle 0cf
      // 08f: goto 093
      // 092: athrow
      // 093: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 096: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 099: aload 0
      // 09a: getfield x/oc8edd24b1ed.Ѥ Lnet/minecraft/util/BlockPos;
      // 09d: invokevirtual net/minecraft/client/multiplayer/WorldClient.isAirBlock (Lnet/minecraft/util/BlockPos;)Z
      // 0a0: iload 3
      // 0a1: ifne 0de
      // 0a4: goto 0a8
      // 0a7: athrow
      // 0a8: ifne 0cf
      // 0ab: goto 0af
      // 0ae: athrow
      // 0af: aload 0
      // 0b0: aload 4
      // 0b2: aload 0
      // 0b3: getfield x/oc8edd24b1ed.Ѥ Lnet/minecraft/util/BlockPos;
      // 0b6: invokevirtual x/oc8edd24b1ed.ӂ (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/BlockPos;)D
      // 0b9: dload 1
      // 0ba: ldc2_w 1.0E-4
      // 0bd: dadd
      // 0be: dcmpg
      // 0bf: iload 3
      // 0c0: ifne 0de
      // 0c3: goto 0c7
      // 0c6: athrow
      // 0c7: ifgt 0cf
      // 0ca: goto 0ce
      // 0cd: athrow
      // 0ce: return
      // 0cf: iload 5
      // 0d1: iload 3
      // 0d2: ifne 101
      // 0d5: aload 0
      // 0d6: getfield x/oc8edd24b1ed.È I
      // 0d9: isub
      // 0da: goto 0de
      // 0dd: athrow
      // 0de: ldc_w -18274121
      // 0e1: ldc_w -18274126
      // 0e4: ixor
      // 0e5: if_icmplt 104
      // 0e8: aload 0
      // 0e9: iload 3
      // 0ea: ifne 112
      // 0ed: goto 0f1
      // 0f0: athrow
      // 0f1: getfield x/oc8edd24b1ed.Ժ Lnet/minecraft/util/Vec3;
      // 0f4: aload 4
      // 0f6: invokevirtual net/minecraft/util/Vec3.squareDistanceTo (Lnet/minecraft/util/Vec3;)D
      // 0f9: ldc2_w 0.25
      // 0fc: dcmpg
      // 0fd: goto 101
      // 100: athrow
      // 101: ifge 105
      // 104: return
      // 105: aload 0
      // 106: aload 4
      // 108: putfield x/oc8edd24b1ed.Ժ Lnet/minecraft/util/Vec3;
      // 10b: aload 0
      // 10c: iload 5
      // 10e: putfield x/oc8edd24b1ed.È I
      // 111: aload 0
      // 112: dload 1
      // 113: invokevirtual x/oc8edd24b1ed.I (D)Lx/ocd840a448ba;
      // 116: astore 6
      // 118: aload 6
      // 11a: iload 3
      // 11b: ifne 148
      // 11e: ifnull 143
      // 121: goto 125
      // 124: athrow
      // 125: aload 6
      // 127: iload 3
      // 128: ifne 148
      // 12b: goto 12f
      // 12e: athrow
      // 12f: getfield x/ocd840a448ba.ƣ Lnet/minecraft/util/BlockPos;
      // 132: aload 0
      // 133: getfield x/oc8edd24b1ed.Ѥ Lnet/minecraft/util/BlockPos;
      // 136: invokevirtual net/minecraft/util/BlockPos.equals (Ljava/lang/Object;)Z
      // 139: ifne 143
      // 13c: goto 140
      // 13f: athrow
      // 140: aconst_null
      // 141: astore 6
      // 143: aload 0
      // 144: dload 1
      // 145: invokevirtual x/oc8edd24b1ed.Μ (D)Lx/ocd840a448ba;
      // 148: astore 7
      // 14a: aload 7
      // 14c: iload 3
      // 14d: ifne 16b
      // 150: ifnonnull 169
      // 153: goto 157
      // 156: athrow
      // 157: aload 6
      // 159: ifnonnull 168
      // 15c: goto 160
      // 15f: athrow
      // 160: aload 0
      // 161: invokevirtual x/oc8edd24b1ed.P ()V
      // 164: goto 168
      // 167: athrow
      // 168: return
      // 169: aload 7
      // 16b: iload 3
      // 16c: ifne 19f
      // 16f: getfield x/ocd840a448ba.ƣ Lnet/minecraft/util/BlockPos;
      // 172: aload 0
      // 173: getfield x/oc8edd24b1ed.Ѥ Lnet/minecraft/util/BlockPos;
      // 176: invokevirtual net/minecraft/util/BlockPos.equals (Ljava/lang/Object;)Z
      // 179: ifeq 19d
      // 17c: goto 180
      // 17f: athrow
      // 180: aload 0
      // 181: aload 7
      // 183: getfield x/ocd840a448ba.ӊ Lnet/minecraft/util/BlockPos;
      // 186: putfield x/oc8edd24b1ed.ů Lnet/minecraft/util/BlockPos;
      // 189: aload 0
      // 18a: aload 7
      // 18c: getfield x/ocd840a448ba.ƕ Lnet/minecraft/util/Vec3;
      // 18f: putfield x/oc8edd24b1ed.ŷ Lnet/minecraft/util/Vec3;
      // 192: aload 0
      // 193: aload 7
      // 195: getfield x/ocd840a448ba.ӊ Lnet/minecraft/util/BlockPos;
      // 198: invokevirtual x/oc8edd24b1ed.ŉ (Lnet/minecraft/util/BlockPos;)V
      // 19b: return
      // 19c: athrow
      // 19d: aload 6
      // 19f: ifnull 1f9
      // 1a2: fconst_0
      // 1a3: fstore 8
      // 1a5: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1a8: getfield net/minecraft/client/Minecraft.playerController Lnet/minecraft/client/multiplayer/PlayerControllerMP;
      // 1ab: astore 9
      // 1ad: aload 0
      // 1ae: getfield x/oc8edd24b1ed.Ѥ Lnet/minecraft/util/BlockPos;
      // 1b1: aload 9
      // 1b3: invokeinterface x/oc51cbcffcfe.getCurrentBlock ()Lnet/minecraft/util/BlockPos; 1
      // 1b8: invokevirtual net/minecraft/util/BlockPos.equals (Ljava/lang/Object;)Z
      // 1bb: ifeq 1cc
      // 1be: aload 9
      // 1c0: invokeinterface x/oc51cbcffcfe.getCurBlockDamageMP ()F 1
      // 1c5: fconst_0
      // 1c6: fconst_1
      // 1c7: invokestatic net/minecraft/util/MathHelper.clamp_float (FFF)F
      // 1ca: fstore 8
      // 1cc: aload 6
      // 1ce: getfield x/ocd840a448ba.Ǫ D
      // 1d1: fload 8
      // 1d3: f2d
      // 1d4: aload 0
      // 1d5: aload 0
      // 1d6: getfield x/oc8edd24b1ed.Ѥ Lnet/minecraft/util/BlockPos;
      // 1d9: invokevirtual x/oc8edd24b1ed.ҵ (Lnet/minecraft/util/BlockPos;)F
      // 1dc: f2d
      // 1dd: invokestatic x/oc8edd24b1ed.Ǔ (DDD)D
      // 1e0: dstore 10
      // 1e2: iload 3
      // 1e3: ifne 207
      // 1e6: aload 7
      // 1e8: getfield x/ocd840a448ba.Ǫ D
      // 1eb: dload 10
      // 1ed: invokestatic x/oc8edd24b1ed.ǚ (DD)Z
      // 1f0: ifne 1f9
      // 1f3: goto 1f7
      // 1f6: athrow
      // 1f7: return
      // 1f8: athrow
      // 1f9: aload 0
      // 1fa: invokevirtual x/oc8edd24b1ed.ƽ ()V
      // 1fd: aload 0
      // 1fe: invokevirtual x/oc8edd24b1ed.σ ()V
      // 201: aload 0
      // 202: aload 7
      // 204: invokevirtual x/oc8edd24b1ed.Ϙ (Lx/ocd840a448ba;)V
      // 207: return
   }

   private ocd840a448ba Μ(double param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: istore 3
      // 004: aload 0
      // 005: invokevirtual x/oc8edd24b1ed.д ()Z
      // 008: ifeq 00e
      // 00b: aconst_null
      // 00c: areturn
      // 00d: athrow
      // 00e: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 011: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 014: fconst_1
      // 015: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getPositionEyes (F)Lnet/minecraft/util/Vec3;
      // 018: astore 4
      // 01a: dload 1
      // 01b: invokestatic java/lang/Math.ceil (D)D
      // 01e: d2i
      // 01f: bipush 1
      // 020: iadd
      // 021: istore 5
      // 023: aload 4
      // 025: getfield net/minecraft/util/Vec3.xCoord D
      // 028: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 02b: istore 6
      // 02d: aload 4
      // 02f: getfield net/minecraft/util/Vec3.yCoord D
      // 032: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 035: istore 7
      // 037: aload 4
      // 039: getfield net/minecraft/util/Vec3.zCoord D
      // 03c: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 03f: istore 8
      // 041: new java/util/ArrayList
      // 044: dup
      // 045: invokespecial java/util/ArrayList.<init> ()V
      // 048: astore 9
      // 04a: iload 6
      // 04c: iload 5
      // 04e: isub
      // 04f: istore 10
      // 051: iload 10
      // 053: iload 6
      // 055: iload 5
      // 057: iadd
      // 058: if_icmpgt 136
      // 05b: iload 7
      // 05d: iload 5
      // 05f: isub
      // 060: istore 11
      // 062: iload 11
      // 064: iload 7
      // 066: iload 5
      // 068: iadd
      // 069: if_icmpgt 12f
      // 06c: iload 8
      // 06e: iload 5
      // 070: iload 3
      // 071: ifne 058
      // 074: isub
      // 075: istore 12
      // 077: iload 12
      // 079: iload 8
      // 07b: iload 5
      // 07d: iadd
      // 07e: if_icmpgt 128
      // 081: new net/minecraft/util/BlockPos
      // 084: dup
      // 085: iload 10
      // 087: iload 11
      // 089: iload 12
      // 08b: invokespecial net/minecraft/util/BlockPos.<init> (III)V
      // 08e: astore 13
      // 090: iload 3
      // 091: ifne 12b
      // 094: aload 0
      // 095: iload 3
      // 096: ifne 0c7
      // 099: goto 09d
      // 09c: athrow
      // 09d: getfield x/oc8edd24b1ed.Տ Lx/occ2f8dff8d8;
      // 0a0: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 0a3: ifeq 0c6
      // 0a6: goto 0aa
      // 0a9: athrow
      // 0aa: aload 0
      // 0ab: iload 3
      // 0ac: ifne 0c7
      // 0af: goto 0b3
      // 0b2: athrow
      // 0b3: getfield x/oc8edd24b1ed.S Ljava/util/ArrayList;
      // 0b6: aload 13
      // 0b8: invokevirtual java/util/ArrayList.contains (Ljava/lang/Object;)Z
      // 0bb: ifeq 0c6
      // 0be: goto 0c2
      // 0c1: athrow
      // 0c2: goto 121
      // 0c5: athrow
      // 0c6: aload 0
      // 0c7: aload 13
      // 0c9: invokevirtual x/oc8edd24b1ed.ȉ (Lnet/minecraft/util/BlockPos;)Z
      // 0cc: iload 3
      // 0cd: ifne 0ed
      // 0d0: ifeq 0da
      // 0d3: goto 0d7
      // 0d6: athrow
      // 0d7: goto 121
      // 0da: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0dd: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 0e0: aload 13
      // 0e2: invokevirtual net/minecraft/client/multiplayer/WorldClient.getBlockState (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // 0e5: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 0ea: instanceof net/minecraft/block/BlockBed
      // 0ed: iload 3
      // 0ee: ifne 10a
      // 0f1: ifeq 121
      // 0f4: goto 0f8
      // 0f7: athrow
      // 0f8: aload 0
      // 0f9: aload 4
      // 0fb: aload 13
      // 0fd: invokevirtual x/oc8edd24b1ed.ӂ (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/BlockPos;)D
      // 100: dload 1
      // 101: ldc2_w 1.0E-4
      // 104: dadd
      // 105: dcmpg
      // 106: goto 10a
      // 109: athrow
      // 10a: iload 3
      // 10b: ifne 120
      // 10e: ifgt 121
      // 111: goto 115
      // 114: athrow
      // 115: aload 9
      // 117: aload 13
      // 119: invokevirtual java/util/ArrayList.add (Ljava/lang/Object;)Z
      // 11c: goto 120
      // 11f: athrow
      // 120: pop
      // 121: iinc 12 1
      // 124: iload 3
      // 125: ifeq 077
      // 128: iinc 11 1
      // 12b: iload 3
      // 12c: ifeq 062
      // 12f: iinc 10 1
      // 132: iload 3
      // 133: ifeq 051
      // 136: aconst_null
      // 137: astore 10
      // 139: aload 9
      // 13b: invokevirtual java/util/ArrayList.iterator ()Ljava/util/Iterator;
      // 13e: astore 11
      // 140: aload 11
      // 142: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 147: ifeq 1cc
      // 14a: aload 11
      // 14c: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 151: checkcast net/minecraft/util/BlockPos
      // 154: astore 12
      // 156: aload 0
      // 157: aload 12
      // 159: invokevirtual x/oc8edd24b1ed.Ȧ (Lnet/minecraft/util/BlockPos;)[Lnet/minecraft/util/Vec3;
      // 15c: astore 13
      // 15e: aload 13
      // 160: arraylength
      // 161: istore 14
      // 163: bipush 0
      // 164: istore 15
      // 166: iload 15
      // 168: iload 14
      // 16a: if_icmpge 1c8
      // 16d: aload 13
      // 16f: iload 15
      // 171: aaload
      // 172: astore 16
      // 174: aload 0
      // 175: aload 12
      // 177: aload 16
      // 179: aload 4
      // 17b: dload 1
      // 17c: invokevirtual x/oc8edd24b1ed.ƕ (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;D)Lx/ocd840a448ba;
      // 17f: iload 3
      // 180: ifne 1ce
      // 183: astore 17
      // 185: iload 3
      // 186: ifne 1c4
      // 189: aload 17
      // 18b: ifnull 1c1
      // 18e: goto 192
      // 191: athrow
      // 192: aload 10
      // 194: iload 3
      // 195: ifne 1bf
      // 198: goto 19c
      // 19b: athrow
      // 19c: ifnull 1b9
      // 19f: goto 1a3
      // 1a2: athrow
      // 1a3: aload 17
      // 1a5: iload 3
      // 1a6: ifne 1bf
      // 1a9: goto 1ad
      // 1ac: athrow
      // 1ad: aload 10
      // 1af: invokevirtual x/ocd840a448ba.y (Lx/ocd840a448ba;)Z
      // 1b2: ifeq 1c1
      // 1b5: goto 1b9
      // 1b8: athrow
      // 1b9: aload 17
      // 1bb: goto 1bf
      // 1be: athrow
      // 1bf: astore 10
      // 1c1: iinc 15 1
      // 1c4: iload 3
      // 1c5: ifeq 166
      // 1c8: iload 3
      // 1c9: ifeq 140
      // 1cc: aload 10
      // 1ce: areturn
   }

   private ocd840a448ba I(double param1) {
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
      // 09: getfield x/oc8edd24b1ed.ů Lnet/minecraft/util/BlockPos;
      // 0c: ifnull 1e
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: goto 18
      // 17: athrow
      // 18: getfield x/oc8edd24b1ed.ŷ Lnet/minecraft/util/Vec3;
      // 1b: ifnonnull 21
      // 1e: aconst_null
      // 1f: areturn
      // 20: athrow
      // 21: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 24: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 27: aload 0
      // 28: getfield x/oc8edd24b1ed.ů Lnet/minecraft/util/BlockPos;
      // 2b: invokevirtual net/minecraft/client/multiplayer/WorldClient.getBlockState (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // 2e: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 33: instanceof net/minecraft/block/BlockBed
      // 36: iload 3
      // 37: ifne 53
      // 3a: ifne 44
      // 3d: goto 41
      // 40: athrow
      // 41: aconst_null
      // 42: areturn
      // 43: athrow
      // 44: aload 0
      // 45: iload 3
      // 46: ifne 57
      // 49: getfield x/oc8edd24b1ed.Տ Lx/occ2f8dff8d8;
      // 4c: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 4f: goto 53
      // 52: athrow
      // 53: ifeq 67
      // 56: aload 0
      // 57: getfield x/oc8edd24b1ed.S Ljava/util/ArrayList;
      // 5a: aload 0
      // 5b: getfield x/oc8edd24b1ed.ů Lnet/minecraft/util/BlockPos;
      // 5e: invokevirtual java/util/ArrayList.contains (Ljava/lang/Object;)Z
      // 61: ifeq 67
      // 64: aconst_null
      // 65: areturn
      // 66: athrow
      // 67: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 6a: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 6d: fconst_1
      // 6e: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getPositionEyes (F)Lnet/minecraft/util/Vec3;
      // 71: astore 4
      // 73: aload 0
      // 74: iload 3
      // 75: ifne 92
      // 78: aload 4
      // 7a: aload 0
      // 7b: getfield x/oc8edd24b1ed.ů Lnet/minecraft/util/BlockPos;
      // 7e: invokevirtual x/oc8edd24b1ed.ӂ (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/BlockPos;)D
      // 81: dload 1
      // 82: ldc2_w 1.0E-4
      // 85: dadd
      // 86: dcmpl
      // 87: ifle 91
      // 8a: goto 8e
      // 8d: athrow
      // 8e: aconst_null
      // 8f: areturn
      // 90: athrow
      // 91: aload 0
      // 92: aload 0
      // 93: getfield x/oc8edd24b1ed.ů Lnet/minecraft/util/BlockPos;
      // 96: aload 0
      // 97: getfield x/oc8edd24b1ed.ŷ Lnet/minecraft/util/Vec3;
      // 9a: aload 4
      // 9c: dload 1
      // 9d: invokevirtual x/oc8edd24b1ed.ƕ (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;D)Lx/ocd840a448ba;
      // a0: areturn
   }

   private ocd840a448ba ƕ(BlockPos param1, Vec3 param2, Vec3 param3, double param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: aconst_null
      // 004: astore 7
      // 006: bipush 0
      // 007: istore 8
      // 009: istore 6
      // 00b: ldc2_w 1.7976931348623157E308
      // 00e: dstore 9
      // 010: dconst_0
      // 011: dstore 11
      // 013: bipush 0
      // 014: istore 13
      // 016: aload 0
      // 017: aload 3
      // 018: aload 2
      // 019: invokevirtual x/oc8edd24b1ed.ì (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;)Ljava/util/ArrayList;
      // 01c: invokevirtual java/util/ArrayList.iterator ()Ljava/util/Iterator;
      // 01f: astore 14
      // 021: aload 14
      // 023: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 028: ifeq 1e2
      // 02b: aload 14
      // 02d: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 032: checkcast net/minecraft/util/BlockPos
      // 035: astore 15
      // 037: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 03a: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 03d: aload 15
      // 03f: invokevirtual net/minecraft/client/multiplayer/WorldClient.getBlockState (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // 042: astore 16
      // 044: aload 16
      // 046: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 04b: astore 17
      // 04d: aload 17
      // 04f: iload 6
      // 051: ifne 067
      // 054: aload 16
      // 056: bipush 0
      // 057: invokevirtual net/minecraft/block/Block.canCollideCheck (Lnet/minecraft/block/state/IBlockState;Z)Z
      // 05a: ifne 065
      // 05d: goto 061
      // 060: athrow
      // 061: goto 021
      // 064: athrow
      // 065: aload 17
      // 067: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 06a: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 06d: aload 15
      // 06f: aload 3
      // 070: aload 2
      // 071: invokevirtual net/minecraft/block/Block.collisionRayTrace (Lnet/minecraft/world/World;Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;)Lnet/minecraft/util/MovingObjectPosition;
      // 074: astore 18
      // 076: aload 18
      // 078: iload 6
      // 07a: ifne 086
      // 07d: ifnull 021
      // 080: goto 084
      // 083: athrow
      // 084: aload 18
      // 086: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 089: iload 6
      // 08b: ifne 099
      // 08e: ifnonnull 098
      // 091: goto 095
      // 094: athrow
      // 095: goto 021
      // 098: aload 3
      // 099: aload 18
      // 09b: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 09e: invokevirtual net/minecraft/util/Vec3.distanceTo (Lnet/minecraft/util/Vec3;)D
      // 0a1: dstore 19
      // 0a3: dload 19
      // 0a5: dload 4
      // 0a7: ldc2_w 1.0E-4
      // 0aa: dadd
      // 0ab: dcmpl
      // 0ac: iload 6
      // 0ae: ifne 0c0
      // 0b1: ifle 0bb
      // 0b4: goto 0b8
      // 0b7: athrow
      // 0b8: aconst_null
      // 0b9: areturn
      // 0ba: athrow
      // 0bb: aload 17
      // 0bd: instanceof net/minecraft/block/BlockBed
      // 0c0: istore 21
      // 0c2: iload 21
      // 0c4: iload 6
      // 0c6: ifne 105
      // 0c9: ifeq 103
      // 0cc: goto 0d0
      // 0cf: athrow
      // 0d0: aload 0
      // 0d1: getfield x/oc8edd24b1ed.Տ Lx/occ2f8dff8d8;
      // 0d4: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 0d7: iload 6
      // 0d9: ifne 105
      // 0dc: goto 0e0
      // 0df: athrow
      // 0e0: ifeq 103
      // 0e3: goto 0e7
      // 0e6: athrow
      // 0e7: aload 0
      // 0e8: getfield x/oc8edd24b1ed.S Ljava/util/ArrayList;
      // 0eb: aload 15
      // 0ed: invokevirtual java/util/ArrayList.contains (Ljava/lang/Object;)Z
      // 0f0: iload 6
      // 0f2: ifne 105
      // 0f5: goto 0f9
      // 0f8: athrow
      // 0f9: ifeq 103
      // 0fc: goto 100
      // 0ff: athrow
      // 100: aconst_null
      // 101: areturn
      // 102: athrow
      // 103: iload 21
      // 105: iload 6
      // 107: ifne 12c
      // 10a: ifeq 12a
      // 10d: goto 111
      // 110: athrow
      // 111: aload 15
      // 113: aload 1
      // 114: invokevirtual net/minecraft/util/BlockPos.equals (Ljava/lang/Object;)Z
      // 117: iload 6
      // 119: ifne 12c
      // 11c: goto 120
      // 11f: athrow
      // 120: ifne 12a
      // 123: goto 127
      // 126: athrow
      // 127: aconst_null
      // 128: areturn
      // 129: athrow
      // 12a: iload 21
      // 12c: iload 6
      // 12e: ifne 143
      // 131: ifne 168
      // 134: goto 138
      // 137: athrow
      // 138: aload 0
      // 139: getfield x/oc8edd24b1ed.Ò Lx/occ2f8dff8d8;
      // 13c: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 13f: goto 143
      // 142: athrow
      // 143: iload 6
      // 145: ifne 162
      // 148: ifeq 165
      // 14b: goto 14f
      // 14e: athrow
      // 14f: aload 17
      // 151: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 154: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 157: aload 15
      // 159: invokevirtual net/minecraft/block/Block.getBlockHardness (Lnet/minecraft/world/World;Lnet/minecraft/util/BlockPos;)F
      // 15c: fconst_0
      // 15d: fcmpg
      // 15e: goto 162
      // 161: athrow
      // 162: ifge 168
      // 165: aconst_null
      // 166: areturn
      // 167: athrow
      // 168: aload 7
      // 16a: iload 6
      // 16c: ifne 178
      // 16f: ifnonnull 182
      // 172: goto 176
      // 175: athrow
      // 176: aload 15
      // 178: astore 7
      // 17a: iload 21
      // 17c: istore 8
      // 17e: dload 19
      // 180: dstore 9
      // 182: aload 0
      // 183: aload 15
      // 185: invokevirtual x/oc8edd24b1ed.ҵ (Lnet/minecraft/util/BlockPos;)F
      // 188: fstore 22
      // 18a: iload 6
      // 18c: ifne 1aa
      // 18f: fload 22
      // 191: fconst_0
      // 192: fcmpg
      // 193: ifgt 19d
      // 196: goto 19a
      // 199: athrow
      // 19a: aconst_null
      // 19b: areturn
      // 19c: athrow
      // 19d: dload 11
      // 19f: dconst_1
      // 1a0: fload 22
      // 1a2: f2d
      // 1a3: ddiv
      // 1a4: dadd
      // 1a5: dstore 11
      // 1a7: iinc 13 1
      // 1aa: iload 21
      // 1ac: iload 6
      // 1ae: ifne 1d0
      // 1b1: ifeq 1ce
      // 1b4: goto 1b8
      // 1b7: athrow
      // 1b8: new x/ocd840a448ba
      // 1bb: dup
      // 1bc: aload 7
      // 1be: aload 2
      // 1bf: iload 8
      // 1c1: aload 1
      // 1c2: aload 2
      // 1c3: dload 11
      // 1c5: iload 13
      // 1c7: dload 9
      // 1c9: invokespecial x/ocd840a448ba.<init> (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/Vec3;ZLnet/minecraft/util/BlockPos;Lnet/minecraft/util/Vec3;DID)V
      // 1cc: areturn
      // 1cd: athrow
      // 1ce: iload 13
      // 1d0: ldc_w -1153977045
      // 1d3: ldc_w -1153976981
      // 1d6: ixor
      // 1d7: if_icmplt 1dd
      // 1da: aconst_null
      // 1db: areturn
      // 1dc: athrow
      // 1dd: iload 6
      // 1df: ifeq 021
      // 1e2: aconst_null
      // 1e3: areturn
   }

   private ArrayList<BlockPos> ì(Vec3 param1, Vec3 param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 000: new java/util/ArrayList
      // 003: dup
      // 004: invokespecial java/util/ArrayList.<init> ()V
      // 007: astore 4
      // 009: aload 1
      // 00a: getfield net/minecraft/util/Vec3.xCoord D
      // 00d: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 010: istore 5
      // 012: aload 1
      // 013: getfield net/minecraft/util/Vec3.yCoord D
      // 016: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 019: istore 6
      // 01b: aload 1
      // 01c: getfield net/minecraft/util/Vec3.zCoord D
      // 01f: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 022: istore 7
      // 024: aload 2
      // 025: getfield net/minecraft/util/Vec3.xCoord D
      // 028: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 02b: istore 8
      // 02d: aload 2
      // 02e: getfield net/minecraft/util/Vec3.yCoord D
      // 031: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 034: istore 9
      // 036: getstatic x/oc84f20a0bc5.ė I
      // 039: aload 2
      // 03a: getfield net/minecraft/util/Vec3.zCoord D
      // 03d: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 040: istore 10
      // 042: aload 2
      // 043: getfield net/minecraft/util/Vec3.xCoord D
      // 046: aload 1
      // 047: getfield net/minecraft/util/Vec3.xCoord D
      // 04a: dsub
      // 04b: dstore 11
      // 04d: istore 3
      // 04e: aload 2
      // 04f: getfield net/minecraft/util/Vec3.yCoord D
      // 052: aload 1
      // 053: getfield net/minecraft/util/Vec3.yCoord D
      // 056: dsub
      // 057: dstore 13
      // 059: aload 2
      // 05a: getfield net/minecraft/util/Vec3.zCoord D
      // 05d: aload 1
      // 05e: getfield net/minecraft/util/Vec3.zCoord D
      // 061: dsub
      // 062: dstore 15
      // 064: iload 8
      // 066: iload 5
      // 068: invokestatic java/lang/Integer.compare (II)I
      // 06b: istore 17
      // 06d: iload 9
      // 06f: iload 6
      // 071: invokestatic java/lang/Integer.compare (II)I
      // 074: istore 18
      // 076: iload 10
      // 078: iload 7
      // 07a: invokestatic java/lang/Integer.compare (II)I
      // 07d: istore 19
      // 07f: iload 17
      // 081: ifne 08b
      // 084: ldc2_w 1.7976931348623157E308
      // 087: goto 092
      // 08a: athrow
      // 08b: dconst_1
      // 08c: dload 11
      // 08e: invokestatic java/lang/Math.abs (D)D
      // 091: ddiv
      // 092: dstore 20
      // 094: iload 18
      // 096: ifne 0a0
      // 099: ldc2_w 1.7976931348623157E308
      // 09c: goto 0a7
      // 09f: athrow
      // 0a0: dconst_1
      // 0a1: dload 13
      // 0a3: invokestatic java/lang/Math.abs (D)D
      // 0a6: ddiv
      // 0a7: dstore 22
      // 0a9: iload 19
      // 0ab: ifne 0b5
      // 0ae: ldc2_w 1.7976931348623157E308
      // 0b1: goto 0bc
      // 0b4: athrow
      // 0b5: dconst_1
      // 0b6: dload 15
      // 0b8: invokestatic java/lang/Math.abs (D)D
      // 0bb: ddiv
      // 0bc: dstore 24
      // 0be: iload 17
      // 0c0: iload 3
      // 0c1: ifne 0d4
      // 0c4: ifne 0d2
      // 0c7: goto 0cb
      // 0ca: athrow
      // 0cb: ldc2_w 1.7976931348623157E308
      // 0ce: goto 0fa
      // 0d1: athrow
      // 0d2: iload 17
      // 0d4: iload 3
      // 0d5: ifne 0e1
      // 0d8: ifle 0ec
      // 0db: goto 0df
      // 0de: athrow
      // 0df: iload 5
      // 0e1: i2d
      // 0e2: dconst_1
      // 0e3: dadd
      // 0e4: aload 1
      // 0e5: getfield net/minecraft/util/Vec3.xCoord D
      // 0e8: dsub
      // 0e9: goto 0f4
      // 0ec: aload 1
      // 0ed: getfield net/minecraft/util/Vec3.xCoord D
      // 0f0: iload 5
      // 0f2: i2d
      // 0f3: dsub
      // 0f4: dload 11
      // 0f6: invokestatic java/lang/Math.abs (D)D
      // 0f9: ddiv
      // 0fa: dstore 26
      // 0fc: iload 18
      // 0fe: iload 3
      // 0ff: ifne 112
      // 102: ifne 110
      // 105: goto 109
      // 108: athrow
      // 109: ldc2_w 1.7976931348623157E308
      // 10c: goto 138
      // 10f: athrow
      // 110: iload 18
      // 112: iload 3
      // 113: ifne 11f
      // 116: ifle 12a
      // 119: goto 11d
      // 11c: athrow
      // 11d: iload 6
      // 11f: i2d
      // 120: dconst_1
      // 121: dadd
      // 122: aload 1
      // 123: getfield net/minecraft/util/Vec3.yCoord D
      // 126: dsub
      // 127: goto 132
      // 12a: aload 1
      // 12b: getfield net/minecraft/util/Vec3.yCoord D
      // 12e: iload 6
      // 130: i2d
      // 131: dsub
      // 132: dload 13
      // 134: invokestatic java/lang/Math.abs (D)D
      // 137: ddiv
      // 138: dstore 28
      // 13a: iload 19
      // 13c: iload 3
      // 13d: ifne 150
      // 140: ifne 14e
      // 143: goto 147
      // 146: athrow
      // 147: ldc2_w 1.7976931348623157E308
      // 14a: goto 176
      // 14d: athrow
      // 14e: iload 19
      // 150: iload 3
      // 151: ifne 15d
      // 154: ifle 168
      // 157: goto 15b
      // 15a: athrow
      // 15b: iload 7
      // 15d: i2d
      // 15e: dconst_1
      // 15f: dadd
      // 160: aload 1
      // 161: getfield net/minecraft/util/Vec3.zCoord D
      // 164: dsub
      // 165: goto 170
      // 168: aload 1
      // 169: getfield net/minecraft/util/Vec3.zCoord D
      // 16c: iload 7
      // 16e: i2d
      // 16f: dsub
      // 170: dload 15
      // 172: invokestatic java/lang/Math.abs (D)D
      // 175: ddiv
      // 176: dstore 30
      // 178: aload 4
      // 17a: new net/minecraft/util/BlockPos
      // 17d: dup
      // 17e: iload 5
      // 180: iload 6
      // 182: iload 7
      // 184: invokespecial net/minecraft/util/BlockPos.<init> (III)V
      // 187: invokevirtual java/util/ArrayList.add (Ljava/lang/Object;)Z
      // 18a: pop
      // 18b: iload 5
      // 18d: iload 8
      // 18f: if_icmpne 1bc
      // 192: iload 6
      // 194: iload 3
      // 195: ifne 1cd
      // 198: iload 3
      // 199: ifne 1cd
      // 19c: goto 1a0
      // 19f: athrow
      // 1a0: iload 9
      // 1a2: if_icmpne 1bc
      // 1a5: goto 1a9
      // 1a8: athrow
      // 1a9: iload 7
      // 1ab: iload 3
      // 1ac: ifne 1cd
      // 1af: goto 1b3
      // 1b2: athrow
      // 1b3: iload 10
      // 1b5: if_icmpeq 258
      // 1b8: goto 1bc
      // 1bb: athrow
      // 1bc: aload 4
      // 1be: iload 3
      // 1bf: ifne 25a
      // 1c2: goto 1c6
      // 1c5: athrow
      // 1c6: invokevirtual java/util/ArrayList.size ()I
      // 1c9: goto 1cd
      // 1cc: athrow
      // 1cd: ldc_w -1445333701
      // 1d0: ldc_w -1445333637
      // 1d3: ixor
      // 1d4: if_icmpge 258
      // 1d7: dload 26
      // 1d9: iload 3
      // 1da: ifne 213
      // 1dd: goto 1e1
      // 1e0: athrow
      // 1e1: dload 28
      // 1e3: dcmpg
      // 1e4: ifgt 211
      // 1e7: goto 1eb
      // 1ea: athrow
      // 1eb: dload 26
      // 1ed: iload 3
      // 1ee: ifne 213
      // 1f1: goto 1f5
      // 1f4: athrow
      // 1f5: dload 30
      // 1f7: dcmpg
      // 1f8: ifgt 211
      // 1fb: goto 1ff
      // 1fe: athrow
      // 1ff: iload 5
      // 201: iload 17
      // 203: iadd
      // 204: istore 5
      // 206: iload 3
      // 207: dload 26
      // 209: dload 20
      // 20b: dadd
      // 20c: dstore 26
      // 20e: ifeq 241
      // 211: dload 28
      // 213: dload 30
      // 215: iload 3
      // 216: ifne 23e
      // 219: dcmpg
      // 21a: ifgt 233
      // 21d: goto 221
      // 220: athrow
      // 221: iload 6
      // 223: iload 18
      // 225: iadd
      // 226: istore 6
      // 228: iload 3
      // 229: dload 28
      // 22b: dload 22
      // 22d: dadd
      // 22e: dstore 28
      // 230: ifeq 241
      // 233: iload 7
      // 235: iload 19
      // 237: iadd
      // 238: istore 7
      // 23a: dload 30
      // 23c: dload 24
      // 23e: dadd
      // 23f: dstore 30
      // 241: aload 4
      // 243: new net/minecraft/util/BlockPos
      // 246: dup
      // 247: iload 5
      // 249: iload 6
      // 24b: iload 7
      // 24d: invokespecial net/minecraft/util/BlockPos.<init> (III)V
      // 250: invokevirtual java/util/ArrayList.add (Ljava/lang/Object;)Z
      // 253: pop
      // 254: iload 3
      // 255: ifeq 18b
      // 258: aload 4
      // 25a: areturn
   }

   private Vec3 w(BlockPos param1, double param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 03: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 06: fconst_1
      // 07: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getPositionEyes (F)Lnet/minecraft/util/Vec3;
      // 0a: astore 5
      // 0c: getstatic x/oc84f20a0bc5.ė I
      // 0f: aload 0
      // 10: aload 1
      // 11: invokevirtual x/oc8edd24b1ed.Ȧ (Lnet/minecraft/util/BlockPos;)[Lnet/minecraft/util/Vec3;
      // 14: astore 6
      // 16: aload 6
      // 18: arraylength
      // 19: istore 7
      // 1b: istore 4
      // 1d: bipush 0
      // 1e: istore 8
      // 20: iload 8
      // 22: iload 7
      // 24: if_icmpge bb
      // 27: aload 6
      // 29: iload 8
      // 2b: aaload
      // 2c: astore 9
      // 2e: iload 4
      // 30: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 33: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 36: aload 5
      // 38: aload 9
      // 3a: bipush 0
      // 3b: bipush 0
      // 3c: bipush 1
      // 3d: invokevirtual net/minecraft/client/multiplayer/WorldClient.rayTraceBlocks (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;ZZZ)Lnet/minecraft/util/MovingObjectPosition;
      // 40: astore 10
      // 42: ifne b6
      // 45: aload 10
      // 47: ifnull b3
      // 4a: goto 4e
      // 4d: athrow
      // 4e: aload 10
      // 50: getfield net/minecraft/util/MovingObjectPosition.typeOfHit Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // 53: getstatic net/minecraft/util/MovingObjectPosition$MovingObjectType.BLOCK Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // 56: if_acmpne b3
      // 59: goto 5d
      // 5c: athrow
      // 5d: aload 1
      // 5e: aload 10
      // 60: invokevirtual net/minecraft/util/MovingObjectPosition.getBlockPos ()Lnet/minecraft/util/BlockPos;
      // 63: invokevirtual net/minecraft/util/BlockPos.equals (Ljava/lang/Object;)Z
      // 66: ifeq b3
      // 69: goto 6d
      // 6c: athrow
      // 6d: aload 10
      // 6f: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 72: iload 4
      // 74: ifne 91
      // 77: goto 7b
      // 7a: athrow
      // 7b: ifnonnull 8b
      // 7e: goto 82
      // 81: athrow
      // 82: iload 4
      // 84: ifeq b3
      // 87: goto 8b
      // 8a: athrow
      // 8b: aload 5
      // 8d: goto 91
      // 90: athrow
      // 91: aload 10
      // 93: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 96: invokevirtual net/minecraft/util/Vec3.distanceTo (Lnet/minecraft/util/Vec3;)D
      // 99: dstore 11
      // 9b: iload 4
      // 9d: ifne b6
      // a0: dload 11
      // a2: dload 2
      // a3: ldc2_w 1.0E-4
      // a6: dadd
      // a7: dcmpg
      // a8: ifgt b3
      // ab: goto af
      // ae: athrow
      // af: aload 9
      // b1: areturn
      // b2: athrow
      // b3: iinc 8 1
      // b6: iload 4
      // b8: ifeq 20
      // bb: aconst_null
      // bc: areturn
   }

   private Vec3[] Ȧ(BlockPos param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: aload 1
      // 004: invokestatic x/occb1ed1ed8f.ª (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/util/AxisAlignedBB;
      // 007: astore 3
      // 008: istore 2
      // 009: aload 3
      // 00a: iload 2
      // 00b: ifne 028
      // 00e: ifnonnull 029
      // 011: goto 015
      // 014: athrow
      // 015: new net/minecraft/util/AxisAlignedBB
      // 018: dup
      // 019: aload 1
      // 01a: aload 1
      // 01b: bipush 1
      // 01c: bipush 1
      // 01d: bipush 1
      // 01e: invokevirtual net/minecraft/util/BlockPos.add (III)Lnet/minecraft/util/BlockPos;
      // 021: invokespecial net/minecraft/util/AxisAlignedBB.<init> (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/BlockPos;)V
      // 024: goto 028
      // 027: athrow
      // 028: astore 3
      // 029: ldc2_w 0.1
      // 02c: aload 3
      // 02d: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 030: aload 3
      // 031: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 034: dsub
      // 035: ldc2_w 0.2
      // 038: dmul
      // 039: invokestatic java/lang/Math.min (DD)D
      // 03c: dstore 4
      // 03e: ldc2_w 0.1
      // 041: aload 3
      // 042: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 045: aload 3
      // 046: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 049: dsub
      // 04a: ldc2_w 0.2
      // 04d: dmul
      // 04e: invokestatic java/lang/Math.min (DD)D
      // 051: dstore 6
      // 053: ldc2_w 0.1
      // 056: aload 3
      // 057: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 05a: aload 3
      // 05b: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 05e: dsub
      // 05f: ldc2_w 0.2
      // 062: dmul
      // 063: invokestatic java/lang/Math.min (DD)D
      // 066: dstore 8
      // 068: aload 3
      // 069: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 06c: dload 4
      // 06e: dadd
      // 06f: dstore 10
      // 071: aload 3
      // 072: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 075: dload 6
      // 077: dadd
      // 078: dstore 12
      // 07a: aload 3
      // 07b: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 07e: dload 8
      // 080: dadd
      // 081: dstore 14
      // 083: aload 3
      // 084: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 087: dload 4
      // 089: dsub
      // 08a: dstore 16
      // 08c: aload 3
      // 08d: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 090: dload 6
      // 092: dsub
      // 093: dstore 18
      // 095: aload 3
      // 096: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 099: dload 8
      // 09b: dsub
      // 09c: dstore 20
      // 09e: aload 3
      // 09f: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 0a2: aload 3
      // 0a3: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 0a6: dadd
      // 0a7: ldc2_w 0.5
      // 0aa: dmul
      // 0ab: dstore 22
      // 0ad: aload 3
      // 0ae: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 0b1: aload 3
      // 0b2: getfield net/minecraft/util/AxisAlignedBB.maxY D
      // 0b5: dadd
      // 0b6: ldc2_w 0.5
      // 0b9: dmul
      // 0ba: dstore 24
      // 0bc: aload 3
      // 0bd: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 0c0: aload 3
      // 0c1: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 0c4: dadd
      // 0c5: ldc2_w 0.5
      // 0c8: dmul
      // 0c9: dstore 26
      // 0cb: ldc_w -1723682110
      // 0ce: ldc_w -1723682101
      // 0d1: ixor
      // 0d2: anewarray 392
      // 0d5: dup
      // 0d6: bipush 0
      // 0d7: new net/minecraft/util/Vec3
      // 0da: dup
      // 0db: dload 22
      // 0dd: dload 24
      // 0df: dload 26
      // 0e1: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 0e4: aastore
      // 0e5: dup
      // 0e6: bipush 1
      // 0e7: new net/minecraft/util/Vec3
      // 0ea: dup
      // 0eb: dload 10
      // 0ed: dload 12
      // 0ef: dload 14
      // 0f1: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 0f4: aastore
      // 0f5: dup
      // 0f6: ldc_w -1723682103
      // 0f9: ldc_w -1723682101
      // 0fc: ixor
      // 0fd: new net/minecraft/util/Vec3
      // 100: dup
      // 101: dload 10
      // 103: dload 12
      // 105: dload 20
      // 107: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 10a: aastore
      // 10b: dup
      // 10c: ldc_w -1723682104
      // 10f: ldc_w -1723682101
      // 112: ixor
      // 113: new net/minecraft/util/Vec3
      // 116: dup
      // 117: dload 16
      // 119: dload 12
      // 11b: dload 14
      // 11d: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 120: aastore
      // 121: dup
      // 122: ldc_w -1723682097
      // 125: ldc_w -1723682101
      // 128: ixor
      // 129: new net/minecraft/util/Vec3
      // 12c: dup
      // 12d: dload 16
      // 12f: dload 12
      // 131: dload 20
      // 133: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 136: aastore
      // 137: dup
      // 138: ldc_w -1723682098
      // 13b: ldc_w -1723682101
      // 13e: ixor
      // 13f: new net/minecraft/util/Vec3
      // 142: dup
      // 143: dload 10
      // 145: dload 18
      // 147: dload 14
      // 149: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 14c: aastore
      // 14d: dup
      // 14e: ldc_w -1723682099
      // 151: ldc_w -1723682101
      // 154: ixor
      // 155: new net/minecraft/util/Vec3
      // 158: dup
      // 159: dload 10
      // 15b: dload 18
      // 15d: dload 20
      // 15f: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 162: aastore
      // 163: dup
      // 164: ldc_w -1723682100
      // 167: ldc_w -1723682101
      // 16a: ixor
      // 16b: new net/minecraft/util/Vec3
      // 16e: dup
      // 16f: dload 16
      // 171: dload 18
      // 173: dload 14
      // 175: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 178: aastore
      // 179: dup
      // 17a: ldc_w -1723682109
      // 17d: ldc_w -1723682101
      // 180: ixor
      // 181: new net/minecraft/util/Vec3
      // 184: dup
      // 185: dload 16
      // 187: dload 18
      // 189: dload 20
      // 18b: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 18e: aastore
      // 18f: areturn
   }

   private double ӂ(Vec3 var1, BlockPos var2) {
      int var10000 = oc84f20a0bc5.ė;
      AxisAlignedBB var4 = occb1ed1ed8f.ª(var2);
      int var3 = var10000;

      label21: {
         label20: {
            try {
               var12 = var4;
               if (var3 != 0) {
                  break label21;
               }

               if (var4 != null) {
                  break label20;
               }
            } catch (ocbde1165e4e var11) {
               throw var11;
            }

            var4 = new AxisAlignedBB(var2, var2.add(1, 1, 1));
         }

         var12 = var4;
      }

      double var5 = Math.max(var12.minX - var1.xCoord, Math.max(0.0, var1.xCoord - var4.maxX));
      double var7 = Math.max(var4.minY - var1.yCoord, Math.max(0.0, var1.yCoord - var4.maxY));
      double var9 = Math.max(var4.minZ - var1.zCoord, Math.max(0.0, var1.zCoord - var4.maxZ));
      return Math.sqrt(var5 * var5 + var7 * var7 + var9 * var9);
   }

   private double Ű() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 1
      // 04: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 07: iload 1
      // 08: ifne 22
      // 0b: getfield net/minecraft/client/Minecraft.playerController Lnet/minecraft/client/multiplayer/PlayerControllerMP;
      // 0e: invokevirtual net/minecraft/client/multiplayer/PlayerControllerMP.extendedReach ()Z
      // 11: ifeq 1f
      // 14: goto 18
      // 17: athrow
      // 18: ldc2_w 6.0
      // 1b: goto 29
      // 1e: athrow
      // 1f: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 22: getfield net/minecraft/client/Minecraft.playerController Lnet/minecraft/client/multiplayer/PlayerControllerMP;
      // 25: invokevirtual net/minecraft/client/multiplayer/PlayerControllerMP.getBlockReachDistance ()F
      // 28: f2d
      // 29: dstore 2
      // 2a: aload 0
      // 2b: getfield x/oc8edd24b1ed.ǉ Lx/oca9cc61aada;
      // 2e: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 31: dload 2
      // 32: invokestatic x/oc8edd24b1ed.ҧ (DD)D
      // 35: dreturn
   }

   static double ҧ(double var0, double var2) {
      return Math.max(0.0, Math.min(var0, var2));
   }

   static boolean ƶ(double param0, int param2, double param3, double param5, int param7, double param8) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: dload 0
      // 04: dload 5
      // 06: invokestatic java/lang/Double.compare (DD)I
      // 09: istore 11
      // 0b: istore 10
      // 0d: iload 11
      // 0f: iload 10
      // 11: ifne 39
      // 14: ifeq 33
      // 17: goto 1b
      // 1a: athrow
      // 1b: iload 11
      // 1d: iload 10
      // 1f: ifne 2e
      // 22: goto 26
      // 25: athrow
      // 26: ifge 31
      // 29: goto 2d
      // 2c: athrow
      // 2d: bipush 1
      // 2e: goto 32
      // 31: bipush 0
      // 32: ireturn
      // 33: iload 2
      // 34: iload 7
      // 36: invokestatic java/lang/Integer.compare (II)I
      // 39: istore 12
      // 3b: iload 12
      // 3d: iload 10
      // 3f: ifne 70
      // 42: iflt 6f
      // 45: goto 49
      // 48: athrow
      // 49: iload 12
      // 4b: iload 10
      // 4d: ifne 63
      // 50: goto 54
      // 53: athrow
      // 54: ifne 73
      // 57: goto 5b
      // 5a: athrow
      // 5b: dload 3
      // 5c: dload 8
      // 5e: dcmpg
      // 5f: goto 63
      // 62: athrow
      // 63: iload 10
      // 65: ifne 70
      // 68: ifge 73
      // 6b: goto 6f
      // 6e: athrow
      // 6f: bipush 1
      // 70: goto 74
      // 73: bipush 0
      // 74: ireturn
   }

   static double Ǔ(double param0, double param2, double param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 6
      // 05: dload 4
      // 07: iload 6
      // 09: ifne 21
      // 0c: dconst_0
      // 0d: dcmpg
      // 0e: ifgt 18
      // 11: goto 15
      // 14: athrow
      // 15: dload 0
      // 16: dreturn
      // 17: athrow
      // 18: dconst_0
      // 19: dconst_1
      // 1a: dload 2
      // 1b: invokestatic java/lang/Math.min (DD)D
      // 1e: invokestatic java/lang/Math.max (DD)D
      // 21: dstore 7
      // 23: dconst_0
      // 24: dload 0
      // 25: dload 7
      // 27: dload 4
      // 29: ddiv
      // 2a: dsub
      // 2b: invokestatic java/lang/Math.max (DD)D
      // 2e: dreturn
   }

   static boolean ǚ(double var0, double var2) {
      int var4 = oc84f20a0bc5.ė;

      try {
         double var6;
         int var10000 = (var6 = var0 - var2 * 0.9) == 0.0 ? 0 : (var6 < 0.0 ? -1 : 1);
         if (var4 != 0) {
            return (boolean)var10000;
         }

         if (var10000 < 0) {
            return (boolean)1;
         }
      } catch (ocbde1165e4e var5) {
         throw var5;
      }

      return (boolean)0;
   }

   private void Ŝ() {
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
      // 05: getfield x/oc8edd24b1ed.ƃ Lx/occ2f8dff8d8;
      // 08: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 0b: ifeq 1f
      // 0e: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 11: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 14: invokevirtual net/minecraft/client/entity/EntityPlayerSP.swingItem ()V
      // 17: iload 1
      // 18: ifeq 36
      // 1b: goto 1f
      // 1e: athrow
      // 1f: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 22: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 25: getfield net/minecraft/client/entity/EntityPlayerSP.sendQueue Lnet/minecraft/client/network/NetHandlerPlayClient;
      // 28: new net/minecraft/network/play/client/C0APacketAnimation
      // 2b: dup
      // 2c: invokespecial net/minecraft/network/play/client/C0APacketAnimation.<init> ()V
      // 2f: invokevirtual net/minecraft/client/network/NetHandlerPlayClient.addToSendQueue (Lnet/minecraft/network/Packet;)V
      // 32: goto 36
      // 35: athrow
      // 36: return
   }

   private Color colorGetterX() {
      return new Color(ocd2958dac48.ů(0.0));
   }

   private boolean ǩ() {
      int var1 = oc84f20a0bc5.ė;
      int var2 = 1986956120 ^ 1474102787;

      while (true) {
         switch (var2) {
            case 565415259:
               int var10000;
               label28: {
                  label27: {
                     try {
                        var10000 = (int)this.ӧ.Ӂ();
                        if (var1 != 0) {
                           break label28;
                        }

                        if (var10000 != 0) {
                           break label27;
                        }
                     } catch (ocbde1165e4e var3) {
                        throw var3;
                     }

                     var2 = 697874073 ^ 1474102787;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var10000 = -1758984106 ^ 1474102787;
               }

               var2 = var10000;
               if (var1 == 0) {
                  break;
               }
            case -1057681835:
               return false;
            case 2118496410:
               return true;
            default:
               throw null;
         }
      }
   }

   private boolean ե() {
      int var1 = oc84f20a0bc5.ė;
      int var2 = -1489354873 ^ -1053799509;

      while (true) {
         switch (var2) {
            case -2143890063:
               return true;
            case -1011655910:
               int var10000;
               label34: {
                  label33: {
                     try {
                        var10000 = oc69da1aa7f5.ő.thePlayer.isSpectator();
                        if (var1 != 0) {
                           break label34;
                        }

                        if (var10000 != 0) {
                           break label33;
                        }
                     } catch (ocbde1165e4e var3) {
                        throw var3;
                     }

                     var2 = 1090952922 ^ -1053799509;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var10000 = -1503483028 ^ -1053799509;
               }

               var2 = var10000;
               if (var1 == 0) {
                  break;
               }
            case 1711961132:
               if (oc69da1aa7f5.ő.playerController != null) {
                  var2 = 42143921 ^ -1053799509;
                  if (var1 == 0) {
                     break;
                  }
               }

               var2 = -1503483028 ^ -1053799509;
               break;
            case 1733484743:
               return false;
            default:
               throw null;
         }
      }
   }

   public boolean Ќ() {
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
      // 09: getfield x/oc8edd24b1ed.Ѥ Lnet/minecraft/util/BlockPos;
      // 0c: ifnull 50
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: goto 18
      // 17: athrow
      // 18: iload 1
      // 19: ifne 2b
      // 1c: getfield x/oc8edd24b1ed.Ͽ Z
      // 1f: ifeq 50
      // 22: goto 26
      // 25: athrow
      // 26: aload 0
      // 27: goto 2b
      // 2a: athrow
      // 2b: invokevirtual x/oc8edd24b1ed.ǩ ()Z
      // 2e: iload 1
      // 2f: ifne 4d
      // 32: ifeq 4c
      // 35: goto 39
      // 38: athrow
      // 39: aload 0
      // 3a: invokevirtual x/oc8edd24b1ed.ҡ ()Z
      // 3d: iload 1
      // 3e: ifne 4d
      // 41: goto 45
      // 44: athrow
      // 45: ifne 50
      // 48: goto 4c
      // 4b: athrow
      // 4c: bipush 1
      // 4d: goto 51
      // 50: bipush 0
      // 51: ireturn
   }

   public boolean ʀ() {
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
      // 06: ifne 84
      // 09: invokevirtual x/oc8edd24b1ed.ǩ ()Z
      // 0c: ifeq 83
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: getfield x/oc8edd24b1ed.Ѥ Lnet/minecraft/util/BlockPos;
      // 17: ifnull 33
      // 1a: goto 1e
      // 1d: athrow
      // 1e: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 21: iload 1
      // 22: ifne 39
      // 25: goto 29
      // 28: athrow
      // 29: getfield net/minecraft/client/Minecraft.playerController Lnet/minecraft/client/multiplayer/PlayerControllerMP;
      // 2c: ifnonnull 36
      // 2f: goto 33
      // 32: athrow
      // 33: bipush 0
      // 34: ireturn
      // 35: athrow
      // 36: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 39: getfield net/minecraft/client/Minecraft.playerController Lnet/minecraft/client/multiplayer/PlayerControllerMP;
      // 3c: astore 2
      // 3d: aload 0
      // 3e: getfield x/oc8edd24b1ed.ά Z
      // 41: iload 1
      // 42: ifne 7e
      // 45: ifne 7d
      // 48: goto 4c
      // 4b: athrow
      // 4c: aload 2
      // 4d: invokeinterface x/oc51cbcffcfe.isHittingBlock ()Z 1
      // 52: iload 1
      // 53: ifne 72
      // 56: goto 5a
      // 59: athrow
      // 5a: ifeq 81
      // 5d: goto 61
      // 60: athrow
      // 61: aload 0
      // 62: getfield x/oc8edd24b1ed.Ѥ Lnet/minecraft/util/BlockPos;
      // 65: aload 2
      // 66: invokeinterface x/oc51cbcffcfe.getCurrentBlock ()Lnet/minecraft/util/BlockPos; 1
      // 6b: invokevirtual net/minecraft/util/BlockPos.equals (Ljava/lang/Object;)Z
      // 6e: goto 72
      // 71: athrow
      // 72: iload 1
      // 73: ifne 7e
      // 76: ifeq 81
      // 79: goto 7d
      // 7c: athrow
      // 7d: bipush 1
      // 7e: goto 82
      // 81: bipush 0
      // 82: ireturn
      // 83: aload 0
      // 84: iload 1
      // 85: ifne 97
      // 88: getfield x/oc8edd24b1ed.Ѥ Lnet/minecraft/util/BlockPos;
      // 8b: ifnull a9
      // 8e: goto 92
      // 91: athrow
      // 92: aload 0
      // 93: goto 97
      // 96: athrow
      // 97: getfield x/oc8edd24b1ed.Є Z
      // 9a: iload 1
      // 9b: ifne a6
      // 9e: ifeq a9
      // a1: goto a5
      // a4: athrow
      // a5: bipush 1
      // a6: goto aa
      // a9: bipush 0
      // aa: ireturn
   }

   public boolean Ƅ() {
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
      // 005: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 008: iload 1
      // 009: ifne 035
      // 00c: ifeq 030
      // 00f: goto 013
      // 012: athrow
      // 013: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 016: iload 1
      // 017: ifne 035
      // 01a: goto 01e
      // 01d: athrow
      // 01e: ifeq 030
      // 021: goto 025
      // 024: athrow
      // 025: aload 0
      // 026: getfield x/oc8edd24b1ed.Ѥ Lnet/minecraft/util/BlockPos;
      // 029: ifnonnull 036
      // 02c: goto 030
      // 02f: athrow
      // 030: bipush 0
      // 031: goto 035
      // 034: athrow
      // 035: ireturn
      // 036: getstatic x/oc9755810e45.ğ Lx/oca3ff10b94f;
      // 039: iload 1
      // 03a: ifne 047
      // 03d: ifnull 058
      // 040: goto 044
      // 043: athrow
      // 044: getstatic x/oc9755810e45.ğ Lx/oca3ff10b94f;
      // 047: invokevirtual x/oca3ff10b94f.ê ()Z
      // 04a: iload 1
      // 04b: ifne 065
      // 04e: ifeq 058
      // 051: goto 055
      // 054: athrow
      // 055: bipush 0
      // 056: ireturn
      // 057: athrow
      // 058: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 05b: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 05e: aload 0
      // 05f: getfield x/oc8edd24b1ed.Ѥ Lnet/minecraft/util/BlockPos;
      // 062: invokevirtual net/minecraft/client/multiplayer/WorldClient.isAirBlock (Lnet/minecraft/util/BlockPos;)Z
      // 065: iload 1
      // 066: ifne 0de
      // 069: ifne 0d9
      // 06c: goto 070
      // 06f: athrow
      // 070: aload 0
      // 071: iload 1
      // 072: ifne 0b6
      // 075: goto 079
      // 078: athrow
      // 079: invokevirtual x/oc8edd24b1ed.ǩ ()Z
      // 07c: ifeq 0ad
      // 07f: goto 083
      // 082: athrow
      // 083: aload 0
      // 084: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 087: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 08a: fconst_1
      // 08b: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getPositionEyes (F)Lnet/minecraft/util/Vec3;
      // 08e: aload 0
      // 08f: getfield x/oc8edd24b1ed.Ѥ Lnet/minecraft/util/BlockPos;
      // 092: invokevirtual x/oc8edd24b1ed.ӂ (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/BlockPos;)D
      // 095: aload 0
      // 096: invokevirtual x/oc8edd24b1ed.Ű ()D
      // 099: ldc2_w 1.0E-4
      // 09c: dadd
      // 09d: dcmpl
      // 09e: iload 1
      // 09f: ifne 0de
      // 0a2: goto 0a6
      // 0a5: athrow
      // 0a6: ifgt 0d9
      // 0a9: goto 0ad
      // 0ac: athrow
      // 0ad: aload 0
      // 0ae: iload 1
      // 0af: ifne 0e0
      // 0b2: goto 0b6
      // 0b5: athrow
      // 0b6: invokevirtual x/oc8edd24b1ed.ǩ ()Z
      // 0b9: ifne 0df
      // 0bc: aload 0
      // 0bd: iload 1
      // 0be: ifne 0e0
      // 0c1: goto 0c5
      // 0c4: athrow
      // 0c5: getfield x/oc8edd24b1ed.Ѥ Lnet/minecraft/util/BlockPos;
      // 0c8: aload 0
      // 0c9: getfield x/oc8edd24b1ed.ǉ Lx/oca9cc61aada;
      // 0cc: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0cf: invokestatic x/ocd84af7ddf8.В (Lnet/minecraft/util/BlockPos;D)Z
      // 0d2: ifne 0df
      // 0d5: goto 0d9
      // 0d8: athrow
      // 0d9: bipush 0
      // 0da: goto 0de
      // 0dd: athrow
      // 0de: ireturn
      // 0df: aload 0
      // 0e0: iload 1
      // 0e1: ifne 101
      // 0e4: invokevirtual x/oc8edd24b1ed.ǩ ()Z
      // 0e7: ifeq 100
      // 0ea: goto 0ee
      // 0ed: athrow
      // 0ee: aload 0
      // 0ef: getfield x/oc8edd24b1ed.Ͽ Z
      // 0f2: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0f5: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0f8: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isUsingItem ()Z
      // 0fb: invokestatic x/oc8edd24b1ed.Ā (ZZ)Z
      // 0fe: ireturn
      // 0ff: athrow
      // 100: aload 0
      // 101: getfield x/oc8edd24b1ed.Ǡ I
      // 104: aload 0
      // 105: getfield x/oc8edd24b1ed.Ͽ Z
      // 108: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 10b: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 10e: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isUsingItem ()Z
      // 111: invokestatic x/oc8edd24b1ed.Ц (IZZ)Z
      // 114: ireturn
   }

   static boolean Ц(int param0, boolean param1, boolean param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 3
      // 04: iload 0
      // 05: iload 3
      // 06: ifne 3a
      // 09: bipush 1
      // 0a: if_icmpeq 39
      // 0d: goto 11
      // 10: athrow
      // 11: iload 0
      // 12: iload 3
      // 13: ifne 22
      // 16: goto 1a
      // 19: athrow
      // 1a: ifne 3d
      // 1d: goto 21
      // 20: athrow
      // 21: iload 1
      // 22: iload 3
      // 23: ifne 2e
      // 26: ifeq 3d
      // 29: goto 2d
      // 2c: athrow
      // 2d: iload 2
      // 2e: iload 3
      // 2f: ifne 3a
      // 32: ifne 3d
      // 35: goto 39
      // 38: athrow
      // 39: bipush 1
      // 3a: goto 3e
      // 3d: bipush 0
      // 3e: ireturn
   }

   static boolean Ā(boolean var0, boolean var1) {
      int var2 = oc84f20a0bc5.ė;

      boolean var10000;
      label33: {
         try {
            var10000 = var0;
            if (var2 != 0) {
               break label33;
            }

            if (!var0) {
               return false;
            }
         } catch (ocbde1165e4e var4) {
            throw var4;
         }

         var10000 = var1;
      }

      try {
         if (var2 != 0) {
            return var10000;
         }

         if (!var10000) {
            return true;
         }
      } catch (ocbde1165e4e var3) {
         throw var3;
      }

      return false;
   }

   private boolean ҡ() {
      EntityLivingBase var2 = null;
      double var3 = 0.0;
      int var1 = oc84f20a0bc5.ė;
      int var5 = 89963880 ^ 311676582;

      while (true) {
         label124:
         while (true) {
            switch (var5) {
               case -2018788998:
                  break;
               case -1253108186:
                  var2 = oc9755810e45.ÿ.ɱ();

                  label111: {
                     label110: {
                        try {
                           if (var1 != 0) {
                              break label111;
                           }

                           if (var2 == null) {
                              break label110;
                           }
                        } catch (ocbde1165e4e var9) {
                           throw var9;
                        }

                        var5 = 464376580 ^ 311676582;
                        if (var1 == 0) {
                           continue;
                        }
                     }

                     var5 = 386989245 ^ 311676582;
                  }

                  if (var1 == 0) {
                     continue;
                  }
               case 427522021:
                  if (oc9755810e45.ÿ != null) {
                     var5 = -1791461412 ^ 311676582;
                     if (var1 == 0) {
                        continue;
                     }
                  }

                  var5 = 85433375 ^ 311676582;
                  if (var1 == 0) {
                     continue;
                  }
                  break;
               case 42800129:
                  return true;
               case 92484123:
                  return false;
               case 394547897:
                  return false;
               case 399471566:
                  break label124;
               case 1420718538:
                  var3 = Math.max(oc9755810e45.ÿ.Q().Ӂ(), this.ƚ.Ӂ());

                  label101: {
                     label100: {
                        try {
                           if (var1 != 0) {
                              break label101;
                           }

                           if (!(var2.getDistanceToEntity(oc69da1aa7f5.ő.thePlayer) <= var3)) {
                              break label100;
                           }
                        } catch (ocbde1165e4e var8) {
                           throw var8;
                        }

                        var5 = 270457511 ^ 311676582;
                        if (var1 == 0) {
                           continue;
                        }
                     }

                     var5 = 1832109638 ^ 311676582;
                  }

                  if (var1 == 0) {
                     continue;
                  }
               case 155065762:
                  if (oc69da1aa7f5.ő.thePlayer == null) {
                     var5 = 386989245 ^ 311676582;
                     if (var1 == 0) {
                        continue;
                     }
                  }

                  var5 = 1178451820 ^ 311676582;
                  if (var1 == 0) {
                     continue;
                  }
                  break label124;
               case 2141194464:
                  return false;
               default:
                  throw null;
            }

            int var11;
            label85: {
               label84: {
                  try {
                     var11 = oc9755810e45.ÿ.z$3rzb3dil7uydr();
                     if (var1 != 0) {
                        break label85;
                     }

                     if (var11 != 0) {
                        break label84;
                     }
                  } catch (ocbde1165e4e var7) {
                     throw var7;
                  }

                  var5 = 85433375 ^ 311676582;
                  if (var1 == 0) {
                     continue;
                  }
               }

               var11 = -1478698880 ^ 311676582;
            }

            var5 = var11;
            if (var1 != 0) {
               return true;
            }
         }

         int var10000;
         label76: {
            label75: {
               try {
                  var10000 = this.Ɵ();
                  if (var1 != 0) {
                     break label76;
                  }

                  if (var10000 == 0) {
                     break label75;
                  }
               } catch (ocbde1165e4e var6) {
                  throw var6;
               }

               var5 = 199801155 ^ 311676582;
               if (var1 == 0) {
                  continue;
               }
            }

            var10000 = 85433375 ^ 311676582;
         }

         var5 = var10000;
         if (var1 != 0) {
            return false;
         }
      }
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.HIGHEST
   )
   public void Ϛ(ocf6b0e5bf86 param1) {
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
      // 06: ifne 26
      // 09: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 0c: ifeq 25
      // 0f: goto 13
      // 12: athrow
      // 13: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 16: iload 2
      // 17: ifne 5a
      // 1a: goto 1e
      // 1d: athrow
      // 1e: ifne 46
      // 21: goto 25
      // 24: athrow
      // 25: aload 0
      // 26: iload 2
      // 27: ifne 41
      // 2a: getfield x/oc8edd24b1ed.Ô Z
      // 2d: ifeq 45
      // 30: goto 34
      // 33: athrow
      // 34: aload 0
      // 35: invokevirtual x/oc8edd24b1ed.P ()V
      // 38: aload 0
      // 39: invokevirtual x/oc8edd24b1ed.Ը ()V
      // 3c: aload 0
      // 3d: goto 41
      // 40: athrow
      // 41: bipush 0
      // 42: putfield x/oc8edd24b1ed.Ô Z
      // 45: return
      // 46: aload 0
      // 47: invokevirtual x/oc8edd24b1ed.ȑ ()V
      // 4a: aload 0
      // 4b: iload 2
      // 4c: ifne 66
      // 4f: invokevirtual x/oc8edd24b1ed.ֆ ()V
      // 52: aload 0
      // 53: invokevirtual x/oc8edd24b1ed.Ѯ ()Z
      // 56: goto 5a
      // 59: athrow
      // 5a: ifeq 65
      // 5d: aload 0
      // 5e: invokevirtual x/oc8edd24b1ed.ђ ()V
      // 61: goto 65
      // 64: athrow
      // 65: aload 0
      // 66: iload 2
      // 67: ifne 7f
      // 6a: invokevirtual x/oc8edd24b1ed.ҿ ()Z
      // 6d: ifeq 7e
      // 70: goto 74
      // 73: athrow
      // 74: aload 0
      // 75: invokevirtual x/oc8edd24b1ed.ƽ ()V
      // 78: aload 0
      // 79: invokevirtual x/oc8edd24b1ed.Ը ()V
      // 7c: return
      // 7d: athrow
      // 7e: aload 0
      // 7f: iload 2
      // 80: ifne be
      // 83: invokevirtual x/oc8edd24b1ed.ǩ ()Z
      // 86: ifeq b9
      // 89: goto 8d
      // 8c: athrow
      // 8d: aload 0
      // 8e: iload 2
      // 8f: ifne b2
      // 92: goto 96
      // 95: athrow
      // 96: getfield x/oc8edd24b1ed.Ô Z
      // 99: ifne b1
      // 9c: goto a0
      // 9f: athrow
      // a0: aload 0
      // a1: invokevirtual x/oc8edd24b1ed.P ()V
      // a4: aload 0
      // a5: invokevirtual x/oc8edd24b1ed.Ը ()V
      // a8: aload 0
      // a9: bipush 1
      // aa: putfield x/oc8edd24b1ed.Ô Z
      // ad: goto b1
      // b0: athrow
      // b1: aload 0
      // b2: invokevirtual x/oc8edd24b1ed.Ѣ ()V
      // b5: iload 2
      // b6: ifeq dd
      // b9: aload 0
      // ba: goto be
      // bd: athrow
      // be: iload 2
      // bf: ifne d9
      // c2: getfield x/oc8edd24b1ed.Ô Z
      // c5: ifeq dd
      // c8: goto cc
      // cb: athrow
      // cc: aload 0
      // cd: invokevirtual x/oc8edd24b1ed.P ()V
      // d0: aload 0
      // d1: invokevirtual x/oc8edd24b1ed.Ը ()V
      // d4: aload 0
      // d5: goto d9
      // d8: athrow
      // d9: bipush 0
      // da: putfield x/oc8edd24b1ed.Ô Z
      // dd: return
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.LOWEST
   )
   public void զ(oc25aa89b91f param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: aload 0
      // 004: invokevirtual x/oc8edd24b1ed.ȑ ()V
      // 007: istore 2
      // 008: aload 0
      // 009: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 00c: iload 2
      // 00d: ifne 01a
      // 010: ifeq 025
      // 013: goto 017
      // 016: athrow
      // 017: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 01a: iload 2
      // 01b: ifne 032
      // 01e: ifne 026
      // 021: goto 025
      // 024: athrow
      // 025: return
      // 026: aload 0
      // 027: iload 2
      // 028: ifne 037
      // 02b: invokevirtual x/oc8edd24b1ed.ǩ ()Z
      // 02e: goto 032
      // 031: athrow
      // 032: ifeq 036
      // 035: return
      // 036: aload 0
      // 037: iload 2
      // 038: ifne 048
      // 03b: invokevirtual x/oc8edd24b1ed.ҿ ()Z
      // 03e: ifeq 047
      // 041: goto 045
      // 044: athrow
      // 045: return
      // 046: athrow
      // 047: aload 0
      // 048: iload 2
      // 049: ifne 061
      // 04c: invokevirtual x/oc8edd24b1ed.д ()Z
      // 04f: ifeq 060
      // 052: goto 056
      // 055: athrow
      // 056: aload 0
      // 057: invokevirtual x/oc8edd24b1ed.Ը ()V
      // 05a: aload 0
      // 05b: invokevirtual x/oc8edd24b1ed.P ()V
      // 05e: return
      // 05f: athrow
      // 060: aload 0
      // 061: iload 2
      // 062: ifne 076
      // 065: invokevirtual x/oc8edd24b1ed.Ѯ ()Z
      // 068: ifeq 075
      // 06b: goto 06f
      // 06e: athrow
      // 06f: aload 0
      // 070: invokevirtual x/oc8edd24b1ed.ђ ()V
      // 073: return
      // 074: athrow
      // 075: aload 0
      // 076: iload 2
      // 077: ifne 113
      // 07a: getfield x/oc8edd24b1ed.Ѥ Lnet/minecraft/util/BlockPos;
      // 07d: ifnull 112
      // 080: goto 084
      // 083: athrow
      // 084: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 087: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 08a: aload 0
      // 08b: getfield x/oc8edd24b1ed.Ѥ Lnet/minecraft/util/BlockPos;
      // 08e: invokevirtual net/minecraft/client/multiplayer/WorldClient.isAirBlock (Lnet/minecraft/util/BlockPos;)Z
      // 091: iload 2
      // 092: ifne 0ba
      // 095: goto 099
      // 098: athrow
      // 099: ifne 0bd
      // 09c: goto 0a0
      // 09f: athrow
      // 0a0: aload 0
      // 0a1: iload 2
      // 0a2: ifne 0d2
      // 0a5: goto 0a9
      // 0a8: athrow
      // 0a9: getfield x/oc8edd24b1ed.Ѥ Lnet/minecraft/util/BlockPos;
      // 0ac: aload 0
      // 0ad: getfield x/oc8edd24b1ed.ǉ Lx/oca9cc61aada;
      // 0b0: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0b3: invokestatic x/ocd84af7ddf8.В (Lnet/minecraft/util/BlockPos;D)Z
      // 0b6: goto 0ba
      // 0b9: athrow
      // 0ba: ifne 0cd
      // 0bd: aload 0
      // 0be: invokevirtual x/oc8edd24b1ed.Ը ()V
      // 0c1: iload 2
      // 0c2: aload 0
      // 0c3: invokevirtual x/oc8edd24b1ed.P ()V
      // 0c6: ifeq 112
      // 0c9: goto 0cd
      // 0cc: athrow
      // 0cd: aload 0
      // 0ce: goto 0d2
      // 0d1: athrow
      // 0d2: iload 2
      // 0d3: ifne 113
      // 0d6: getfield x/oc8edd24b1ed.ɗ Z
      // 0d9: ifne 112
      // 0dc: goto 0e0
      // 0df: athrow
      // 0e0: aload 0
      // 0e1: invokevirtual x/oc8edd24b1ed.Ï ()Lnet/minecraft/util/BlockPos;
      // 0e4: iload 2
      // 0e5: ifne 11e
      // 0e8: goto 0ec
      // 0eb: athrow
      // 0ec: astore 3
      // 0ed: aload 3
      // 0ee: ifnull 112
      // 0f1: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0f4: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 0f7: aload 3
      // 0f8: invokevirtual net/minecraft/client/multiplayer/WorldClient.getBlockState (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // 0fb: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 100: instanceof net/minecraft/block/BlockBed
      // 103: ifeq 112
      // 106: goto 10a
      // 109: athrow
      // 10a: aload 0
      // 10b: invokevirtual x/oc8edd24b1ed.P ()V
      // 10e: goto 112
      // 111: athrow
      // 112: aload 0
      // 113: iload 2
      // 114: ifne 1cd
      // 117: getfield x/oc8edd24b1ed.Ѥ Lnet/minecraft/util/BlockPos;
      // 11a: goto 11e
      // 11d: athrow
      // 11e: ifnonnull 1cc
      // 121: aload 0
      // 122: iload 2
      // 123: ifne 1cd
      // 126: goto 12a
      // 129: athrow
      // 12a: invokevirtual x/oc8edd24b1ed.ե ()Z
      // 12d: ifeq 1cc
      // 130: goto 134
      // 133: athrow
      // 134: aload 0
      // 135: iload 2
      // 136: ifne 1cd
      // 139: goto 13d
      // 13c: athrow
      // 13d: getfield x/oc8edd24b1ed.ª Lx/oc1e60691dfe;
      // 140: ldc2_w 500.0
      // 143: invokevirtual x/oc1e60691dfe.ſ (D)Z
      // 146: ifeq 1cc
      // 149: goto 14d
      // 14c: athrow
      // 14d: aload 0
      // 14e: aload 0
      // 14f: invokevirtual x/oc8edd24b1ed.Ï ()Lnet/minecraft/util/BlockPos;
      // 152: putfield x/oc8edd24b1ed.Ѥ Lnet/minecraft/util/BlockPos;
      // 155: aload 0
      // 156: bipush 0
      // 157: iload 2
      // 158: ifne 191
      // 15b: goto 15f
      // 15e: athrow
      // 15f: putfield x/oc8edd24b1ed.Ǡ I
      // 162: aload 0
      // 163: bipush 0
      // 164: putfield x/oc8edd24b1ed.ə I
      // 167: aload 0
      // 168: fconst_0
      // 169: putfield x/oc8edd24b1ed.ƙ F
      // 16c: aload 0
      // 16d: aload 0
      // 16e: getfield x/oc8edd24b1ed.Ѥ Lnet/minecraft/util/BlockPos;
      // 171: ifnull 1a0
      // 174: goto 178
      // 177: athrow
      // 178: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 17b: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 17e: aload 0
      // 17f: getfield x/oc8edd24b1ed.Ѥ Lnet/minecraft/util/BlockPos;
      // 182: invokevirtual net/minecraft/client/multiplayer/WorldClient.getBlockState (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // 185: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 18a: instanceof net/minecraft/block/BlockBed
      // 18d: goto 191
      // 190: athrow
      // 191: iload 2
      // 192: ifne 19d
      // 195: ifeq 1a0
      // 198: goto 19c
      // 19b: athrow
      // 19c: bipush 1
      // 19d: goto 1a1
      // 1a0: bipush 0
      // 1a1: putfield x/oc8edd24b1ed.ɗ Z
      // 1a4: aload 0
      // 1a5: invokevirtual x/oc8edd24b1ed.Ը ()V
      // 1a8: aload 0
      // 1a9: iload 2
      // 1aa: ifne 1cd
      // 1ad: getfield x/oc8edd24b1ed.Ѥ Lnet/minecraft/util/BlockPos;
      // 1b0: ifnull 1cc
      // 1b3: goto 1b7
      // 1b6: athrow
      // 1b7: aload 0
      // 1b8: aload 0
      // 1b9: aload 0
      // 1ba: getfield x/oc8edd24b1ed.Ѥ Lnet/minecraft/util/BlockPos;
      // 1bd: invokevirtual x/oc8edd24b1ed.Ѫ (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/util/BlockPos;
      // 1c0: invokevirtual x/oc8edd24b1ed.ŉ (Lnet/minecraft/util/BlockPos;)V
      // 1c3: aload 0
      // 1c4: bipush 1
      // 1c5: putfield x/oc8edd24b1ed.Ͽ Z
      // 1c8: goto 1cc
      // 1cb: athrow
      // 1cc: aload 0
      // 1cd: getfield x/oc8edd24b1ed.Ѥ Lnet/minecraft/util/BlockPos;
      // 1d0: ifnull 1ee
      // 1d3: getstatic x/oc9755810e45.ğ Lx/oca3ff10b94f;
      // 1d6: iload 2
      // 1d7: ifne 1e8
      // 1da: goto 1de
      // 1dd: athrow
      // 1de: ifnull 1f0
      // 1e1: goto 1e5
      // 1e4: athrow
      // 1e5: getstatic x/oc9755810e45.ğ Lx/oca3ff10b94f;
      // 1e8: invokevirtual x/oca3ff10b94f.ê ()Z
      // 1eb: ifeq 1f0
      // 1ee: return
      // 1ef: athrow
      // 1f0: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1f3: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 1f6: aload 0
      // 1f7: getfield x/oc8edd24b1ed.Ѥ Lnet/minecraft/util/BlockPos;
      // 1fa: invokevirtual net/minecraft/client/multiplayer/WorldClient.getBlockState (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // 1fd: astore 3
      // 1fe: aload 3
      // 1ff: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 204: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 207: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 20a: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 20d: getfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 210: invokestatic x/oc8825472e29.Ϻ (Lnet/minecraft/block/Block;I)I
      // 213: istore 4
      // 215: aload 0
      // 216: iload 2
      // 217: ifne 486
      // 21a: getfield x/oc8edd24b1ed.Ǡ I
      // 21d: tableswitch 612 0 2 28 128 596
      // 238: athrow
      // 239: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 23c: iload 2
      // 23d: ifne 282
      // 240: goto 244
      // 243: athrow
      // 244: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 247: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isUsingItem ()Z
      // 24a: ifne 48a
      // 24d: goto 251
      // 250: athrow
      // 251: aload 0
      // 252: invokevirtual x/oc8edd24b1ed.Ŝ ()V
      // 255: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 258: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 25b: getfield net/minecraft/client/entity/EntityPlayerSP.sendQueue Lnet/minecraft/client/network/NetHandlerPlayClient;
      // 25e: new net/minecraft/network/play/client/C07PacketPlayerDigging
      // 261: dup
      // 262: getstatic net/minecraft/network/play/client/C07PacketPlayerDigging$Action.START_DESTROY_BLOCK Lnet/minecraft/network/play/client/C07PacketPlayerDigging$Action;
      // 265: aload 0
      // 266: getfield x/oc8edd24b1ed.Ѥ Lnet/minecraft/util/BlockPos;
      // 269: aload 0
      // 26a: aload 0
      // 26b: getfield x/oc8edd24b1ed.Ѥ Lnet/minecraft/util/BlockPos;
      // 26e: invokevirtual x/oc8edd24b1ed.Ĝ (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/util/EnumFacing;
      // 271: invokespecial net/minecraft/network/play/client/C07PacketPlayerDigging.<init> (Lnet/minecraft/network/play/client/C07PacketPlayerDigging$Action;Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;)V
      // 274: invokevirtual net/minecraft/client/network/NetHandlerPlayClient.addToSendQueue (Lnet/minecraft/network/Packet;)V
      // 277: aload 0
      // 278: invokevirtual x/oc8edd24b1ed.Ŝ ()V
      // 27b: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 27e: goto 282
      // 281: athrow
      // 282: getfield net/minecraft/client/Minecraft.effectRenderer Lnet/minecraft/client/particle/EffectRenderer;
      // 285: aload 0
      // 286: getfield x/oc8edd24b1ed.Ѥ Lnet/minecraft/util/BlockPos;
      // 289: aload 0
      // 28a: aload 0
      // 28b: getfield x/oc8edd24b1ed.Ѥ Lnet/minecraft/util/BlockPos;
      // 28e: invokevirtual x/oc8edd24b1ed.Ĝ (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/util/EnumFacing;
      // 291: invokevirtual net/minecraft/client/particle/EffectRenderer.addBlockHitEffects (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;)V
      // 294: iload 2
      // 295: aload 0
      // 296: bipush 1
      // 297: putfield x/oc8edd24b1ed.Ǡ I
      // 29a: ifeq 48a
      // 29d: aload 0
      // 29e: iload 2
      // 29f: ifne 2eb
      // 2a2: goto 2a6
      // 2a5: athrow
      // 2a6: getfield x/oc8edd24b1ed.ӧ Lx/oca9cc61aada;
      // 2a9: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 2ac: d2i
      // 2ad: bipush 1
      // 2ae: if_icmpne 2be
      // 2b1: goto 2b5
      // 2b4: athrow
      // 2b5: aload 0
      // 2b6: bipush 0
      // 2b7: putfield x/oc8edd24b1ed.Ͽ Z
      // 2ba: goto 2be
      // 2bd: athrow
      // 2be: aload 0
      // 2bf: bipush 1
      // 2c0: putfield x/oc8edd24b1ed.Є Z
      // 2c3: aload 0
      // 2c4: dup
      // 2c5: getfield x/oc8edd24b1ed.ə I
      // 2c8: bipush 1
      // 2c9: iadd
      // 2ca: putfield x/oc8edd24b1ed.ə I
      // 2cd: aload 0
      // 2ce: dup
      // 2cf: getfield x/oc8edd24b1ed.ƙ F
      // 2d2: aload 0
      // 2d3: aload 3
      // 2d4: aload 0
      // 2d5: getfield x/oc8edd24b1ed.Ѥ Lnet/minecraft/util/BlockPos;
      // 2d8: iload 4
      // 2da: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 2dd: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 2e0: getfield net/minecraft/client/entity/EntityPlayerSP.onGround Z
      // 2e3: invokevirtual x/oc8edd24b1ed.ѐ (Lnet/minecraft/block/state/IBlockState;Lnet/minecraft/util/BlockPos;IZ)F
      // 2e6: fadd
      // 2e7: putfield x/oc8edd24b1ed.ƙ F
      // 2ea: aload 0
      // 2eb: getfield x/oc8edd24b1ed.ə I
      // 2ee: i2f
      // 2ef: aload 0
      // 2f0: aload 3
      // 2f1: aload 0
      // 2f2: getfield x/oc8edd24b1ed.Ѥ Lnet/minecraft/util/BlockPos;
      // 2f5: iload 4
      // 2f7: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 2fa: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 2fd: getfield net/minecraft/client/entity/EntityPlayerSP.onGround Z
      // 300: invokevirtual x/oc8edd24b1ed.ѐ (Lnet/minecraft/block/state/IBlockState;Lnet/minecraft/util/BlockPos;IZ)F
      // 303: fmul
      // 304: fstore 5
      // 306: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 309: getfield net/minecraft/client/Minecraft.effectRenderer Lnet/minecraft/client/particle/EffectRenderer;
      // 30c: aload 0
      // 30d: getfield x/oc8edd24b1ed.Ѥ Lnet/minecraft/util/BlockPos;
      // 310: aload 0
      // 311: aload 0
      // 312: getfield x/oc8edd24b1ed.Ѥ Lnet/minecraft/util/BlockPos;
      // 315: invokevirtual x/oc8edd24b1ed.Ĝ (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/util/EnumFacing;
      // 318: invokevirtual net/minecraft/client/particle/EffectRenderer.addBlockHitEffects (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;)V
      // 31b: aload 0
      // 31c: iload 2
      // 31d: ifne 340
      // 320: getfield x/oc8edd24b1ed.ƙ F
      // 323: fconst_1
      // 324: fcmpl
      // 325: ifge 33f
      // 328: goto 32c
      // 32b: athrow
      // 32c: fload 5
      // 32e: fconst_1
      // 32f: fcmpl
      // 330: iload 2
      // 331: ifne 34f
      // 334: goto 338
      // 337: athrow
      // 338: iflt 48a
      // 33b: goto 33f
      // 33e: athrow
      // 33f: aload 0
      // 340: iload 2
      // 341: ifne 3f4
      // 344: getfield x/oc8edd24b1ed.ӧ Lx/oca9cc61aada;
      // 347: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 34a: d2i
      // 34b: goto 34f
      // 34e: athrow
      // 34f: bipush 1
      // 350: if_icmpne 3cc
      // 353: aload 0
      // 354: bipush 1
      // 355: putfield x/oc8edd24b1ed.Ͽ Z
      // 358: aload 0
      // 359: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 35c: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 35f: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 362: getfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 365: putfield x/oc8edd24b1ed.Ɩ I
      // 368: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 36b: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 36e: iload 2
      // 36f: ifne 3d7
      // 372: goto 376
      // 375: athrow
      // 376: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 379: iload 4
      // 37b: putfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 37e: aload 0
      // 37f: invokevirtual x/oc8edd24b1ed.Ѝ ()V
      // 382: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 385: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 388: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isUsingItem ()Z
      // 38b: ifeq 3cc
      // 38e: goto 392
      // 391: athrow
      // 392: aload 0
      // 393: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 396: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 399: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 39c: getfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 39f: putfield x/oc8edd24b1ed.Ɩ I
      // 3a2: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 3a5: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 3a8: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 3ab: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 3ae: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 3b1: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 3b4: getfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 3b7: bipush 1
      // 3b8: iadd
      // 3b9: ldc_w -691834790
      // 3bc: ldc_w -691834797
      // 3bf: ixor
      // 3c0: irem
      // 3c1: putfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 3c4: aload 0
      // 3c5: invokevirtual x/oc8edd24b1ed.Ѝ ()V
      // 3c8: goto 3cc
      // 3cb: athrow
      // 3cc: aload 0
      // 3cd: bipush 0
      // 3ce: putfield x/oc8edd24b1ed.Є Z
      // 3d1: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 3d4: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 3d7: getfield net/minecraft/client/entity/EntityPlayerSP.sendQueue Lnet/minecraft/client/network/NetHandlerPlayClient;
      // 3da: new net/minecraft/network/play/client/C07PacketPlayerDigging
      // 3dd: dup
      // 3de: getstatic net/minecraft/network/play/client/C07PacketPlayerDigging$Action.STOP_DESTROY_BLOCK Lnet/minecraft/network/play/client/C07PacketPlayerDigging$Action;
      // 3e1: aload 0
      // 3e2: getfield x/oc8edd24b1ed.Ѥ Lnet/minecraft/util/BlockPos;
      // 3e5: aload 0
      // 3e6: aload 0
      // 3e7: getfield x/oc8edd24b1ed.Ѥ Lnet/minecraft/util/BlockPos;
      // 3ea: invokevirtual x/oc8edd24b1ed.Ĝ (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/util/EnumFacing;
      // 3ed: invokespecial net/minecraft/network/play/client/C07PacketPlayerDigging.<init> (Lnet/minecraft/network/play/client/C07PacketPlayerDigging$Action;Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;)V
      // 3f0: invokevirtual net/minecraft/client/network/NetHandlerPlayClient.addToSendQueue (Lnet/minecraft/network/Packet;)V
      // 3f3: aload 0
      // 3f4: invokevirtual x/oc8edd24b1ed.Ŝ ()V
      // 3f7: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 3fa: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 3fd: aload 0
      // 3fe: getfield x/oc8edd24b1ed.Ѥ Lnet/minecraft/util/BlockPos;
      // 401: invokevirtual net/minecraft/client/multiplayer/WorldClient.getBlockState (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // 404: astore 6
      // 406: aload 6
      // 408: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 40d: astore 7
      // 40f: aload 7
      // 411: iload 2
      // 412: ifne 44f
      // 415: invokevirtual net/minecraft/block/Block.getMaterial ()Lnet/minecraft/block/material/Material;
      // 418: getstatic net/minecraft/block/material/Material.air Lnet/minecraft/block/material/Material;
      // 41b: if_acmpeq 44d
      // 41e: goto 422
      // 421: athrow
      // 422: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 425: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 428: ldc_w -691832958
      // 42b: ldc_w -691834797
      // 42e: ixor
      // 42f: aload 0
      // 430: getfield x/oc8edd24b1ed.Ѥ Lnet/minecraft/util/BlockPos;
      // 433: aload 6
      // 435: invokestatic net/minecraft/block/Block.getStateId (Lnet/minecraft/block/state/IBlockState;)I
      // 438: invokevirtual net/minecraft/client/multiplayer/WorldClient.playAuxSFX (ILnet/minecraft/util/BlockPos;I)V
      // 43b: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 43e: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 441: aload 0
      // 442: getfield x/oc8edd24b1ed.Ѥ Lnet/minecraft/util/BlockPos;
      // 445: invokevirtual net/minecraft/client/multiplayer/WorldClient.setBlockToAir (Lnet/minecraft/util/BlockPos;)Z
      // 448: pop
      // 449: goto 44d
      // 44c: athrow
      // 44d: aload 7
      // 44f: instanceof net/minecraft/block/BlockBed
      // 452: ifeq 462
      // 455: aload 0
      // 456: getfield x/oc8edd24b1ed.ª Lx/oc1e60691dfe;
      // 459: invokevirtual x/oc1e60691dfe.Ʉ ()V
      // 45c: aload 0
      // 45d: invokevirtual x/oc8edd24b1ed.ђ ()V
      // 460: return
      // 461: athrow
      // 462: aload 0
      // 463: ldc_w -691834799
      // 466: ldc_w -691834797
      // 469: ixor
      // 46a: putfield x/oc8edd24b1ed.Ǡ I
      // 46d: iload 2
      // 46e: ifeq 48a
      // 471: aload 0
      // 472: invokevirtual x/oc8edd24b1ed.Ը ()V
      // 475: iload 2
      // 476: aload 0
      // 477: invokevirtual x/oc8edd24b1ed.P ()V
      // 47a: ifeq 48a
      // 47d: goto 481
      // 480: athrow
      // 481: aload 0
      // 482: goto 486
      // 485: athrow
      // 486: bipush 0
      // 487: putfield x/oc8edd24b1ed.Ǡ I
      // 48a: return
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.LOWEST
   )
   public void Ӗ(oc86de9e2892 param1) {
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
      // 009: invokevirtual x/oc8edd24b1ed.Ƅ ()Z
      // 00c: ifeq 026
      // 00f: goto 013
      // 012: athrow
      // 013: aload 0
      // 014: goto 018
      // 017: athrow
      // 018: invokevirtual x/oc8edd24b1ed.ҡ ()Z
      // 01b: iload 2
      // 01c: ifne 02b
      // 01f: ifeq 027
      // 022: goto 026
      // 025: athrow
      // 026: return
      // 027: aload 1
      // 028: invokevirtual x/oc86de9e2892.ň ()Z
      // 02b: iload 2
      // 02c: ifne 047
      // 02f: ifeq 043
      // 032: goto 036
      // 035: athrow
      // 036: aload 1
      // 037: invokevirtual x/oc86de9e2892.Ύ ()Ljava/lang/Object;
      // 03a: ifnonnull 043
      // 03d: goto 041
      // 040: athrow
      // 041: return
      // 042: athrow
      // 043: aload 0
      // 044: invokevirtual x/oc8edd24b1ed.Ɵ ()Z
      // 047: iload 2
      // 048: ifne 059
      // 04b: ifeq 05c
      // 04e: goto 052
      // 051: athrow
      // 052: ldc_w -895717845
      // 055: ldc_w -895717661
      // 058: ixor
      // 059: goto 063
      // 05c: ldc_w -895717517
      // 05f: ldc_w -895717661
      // 062: ixor
      // 063: istore 3
      // 064: aload 1
      // 065: aload 0
      // 066: iload 3
      // 067: invokevirtual x/oc86de9e2892.ǰ (Ljava/lang/Object;I)Z
      // 06a: iload 2
      // 06b: ifne 082
      // 06e: ifne 076
      // 071: goto 075
      // 074: athrow
      // 075: return
      // 076: aload 0
      // 077: iload 2
      // 078: ifne 086
      // 07b: invokevirtual x/oc8edd24b1ed.ǩ ()Z
      // 07e: goto 082
      // 081: athrow
      // 082: ifeq 09f
      // 085: aload 0
      // 086: iload 2
      // 087: ifne 099
      // 08a: getfield x/oc8edd24b1ed.Б Lnet/minecraft/util/Vec3;
      // 08d: ifnull 09f
      // 090: goto 094
      // 093: athrow
      // 094: aload 0
      // 095: goto 099
      // 098: athrow
      // 099: getfield x/oc8edd24b1ed.Б Lnet/minecraft/util/Vec3;
      // 09c: goto 0ca
      // 09f: new net/minecraft/util/Vec3
      // 0a2: dup
      // 0a3: aload 0
      // 0a4: getfield x/oc8edd24b1ed.Ѥ Lnet/minecraft/util/BlockPos;
      // 0a7: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 0aa: i2d
      // 0ab: ldc2_w 0.5
      // 0ae: dadd
      // 0af: aload 0
      // 0b0: getfield x/oc8edd24b1ed.Ѥ Lnet/minecraft/util/BlockPos;
      // 0b3: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 0b6: i2d
      // 0b7: ldc2_w 0.5
      // 0ba: dadd
      // 0bb: aload 0
      // 0bc: getfield x/oc8edd24b1ed.Ѥ Lnet/minecraft/util/BlockPos;
      // 0bf: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 0c2: i2d
      // 0c3: ldc2_w 0.5
      // 0c6: dadd
      // 0c7: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 0ca: astore 4
      // 0cc: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0cf: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0d2: fconst_1
      // 0d3: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getPositionEyes (F)Lnet/minecraft/util/Vec3;
      // 0d6: astore 5
      // 0d8: aload 1
      // 0d9: invokevirtual x/oc86de9e2892.ŉ ()Ljava/lang/Float;
      // 0dc: astore 6
      // 0de: aload 1
      // 0df: invokevirtual x/oc86de9e2892.փ ()Ljava/lang/Float;
      // 0e2: astore 7
      // 0e4: aload 4
      // 0e6: getfield net/minecraft/util/Vec3.xCoord D
      // 0e9: aload 5
      // 0eb: getfield net/minecraft/util/Vec3.xCoord D
      // 0ee: dsub
      // 0ef: aload 4
      // 0f1: getfield net/minecraft/util/Vec3.yCoord D
      // 0f4: aload 5
      // 0f6: getfield net/minecraft/util/Vec3.yCoord D
      // 0f9: dsub
      // 0fa: aload 4
      // 0fc: getfield net/minecraft/util/Vec3.zCoord D
      // 0ff: aload 5
      // 101: getfield net/minecraft/util/Vec3.zCoord D
      // 104: dsub
      // 105: aload 6
      // 107: iload 2
      // 108: ifne 114
      // 10b: ifnull 11a
      // 10e: goto 112
      // 111: athrow
      // 112: aload 6
      // 114: invokevirtual java/lang/Float.floatValue ()F
      // 117: goto 11f
      // 11a: getstatic x/oc75d51ec7eb.d [F
      // 11d: bipush 0
      // 11e: faload
      // 11f: aload 7
      // 121: iload 2
      // 122: ifne 12e
      // 125: ifnull 134
      // 128: goto 12c
      // 12b: athrow
      // 12c: aload 7
      // 12e: invokevirtual java/lang/Float.floatValue ()F
      // 131: goto 139
      // 134: getstatic x/oc75d51ec7eb.d [F
      // 137: bipush 1
      // 138: faload
      // 139: ldc 45.0
      // 13b: ldc 0.15
      // 13d: invokestatic x/oc75d51ec7eb.ĕ (DDDFFFF)[F
      // 140: astore 8
      // 142: aload 1
      // 143: aload 0
      // 144: iload 3
      // 145: aload 8
      // 147: bipush 0
      // 148: faload
      // 149: invokestatic java/lang/Float.valueOf (F)Ljava/lang/Float;
      // 14c: aload 8
      // 14e: bipush 1
      // 14f: faload
      // 150: invokestatic java/lang/Float.valueOf (F)Ljava/lang/Float;
      // 153: invokevirtual x/oc86de9e2892.л (Ljava/lang/Object;ILjava/lang/Float;Ljava/lang/Float;)Z
      // 156: pop
      // 157: return
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.LOWEST
   )
   public void ŉ(oca27090789a var1) {
      this.Ⱥ();
   }

   private void Ⱥ() {
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
      // 006: ifne 0b5
      // 009: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 00c: ifeq 0ab
      // 00f: goto 013
      // 012: athrow
      // 013: aload 0
      // 014: iload 1
      // 015: ifne 0b5
      // 018: goto 01c
      // 01b: athrow
      // 01c: getfield x/oc8edd24b1ed.Ô Z
      // 01f: ifeq 0ab
      // 022: goto 026
      // 025: athrow
      // 026: aload 0
      // 027: iload 1
      // 028: ifne 0b5
      // 02b: goto 02f
      // 02e: athrow
      // 02f: invokevirtual x/oc8edd24b1ed.ǩ ()Z
      // 032: ifeq 0ab
      // 035: goto 039
      // 038: athrow
      // 039: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 03c: ifeq 0ab
      // 03f: goto 043
      // 042: athrow
      // 043: aload 0
      // 044: iload 1
      // 045: ifne 0b5
      // 048: goto 04c
      // 04b: athrow
      // 04c: getfield x/oc8edd24b1ed.Ѥ Lnet/minecraft/util/BlockPos;
      // 04f: ifnull 0ab
      // 052: goto 056
      // 055: athrow
      // 056: aload 0
      // 057: iload 1
      // 058: ifne 0b5
      // 05b: goto 05f
      // 05e: athrow
      // 05f: invokevirtual x/oc8edd24b1ed.ҡ ()Z
      // 062: ifne 0ab
      // 065: goto 069
      // 068: athrow
      // 069: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 06c: iload 1
      // 06d: ifne 085
      // 070: goto 074
      // 073: athrow
      // 074: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 077: ifnonnull 0ab
      // 07a: goto 07e
      // 07d: athrow
      // 07e: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 081: goto 085
      // 084: athrow
      // 085: iload 1
      // 086: ifne 09a
      // 089: getfield net/minecraft/client/Minecraft.inGameHasFocus Z
      // 08c: ifeq 0ab
      // 08f: goto 093
      // 092: athrow
      // 093: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 096: goto 09a
      // 099: athrow
      // 09a: iload 1
      // 09b: ifne 0bc
      // 09e: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0a1: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isUsingItem ()Z
      // 0a4: ifeq 0b9
      // 0a7: goto 0ab
      // 0aa: athrow
      // 0ab: aload 0
      // 0ac: bipush 0
      // 0ad: putfield x/oc8edd24b1ed.Ӑ I
      // 0b0: aload 0
      // 0b1: goto 0b5
      // 0b4: athrow
      // 0b5: invokevirtual x/oc8edd24b1ed.ƽ ()V
      // 0b8: return
      // 0b9: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0bc: getfield net/minecraft/client/Minecraft.objectMouseOver Lnet/minecraft/util/MovingObjectPosition;
      // 0bf: astore 2
      // 0c0: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0c3: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0c6: fconst_1
      // 0c7: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getPositionEyes (F)Lnet/minecraft/util/Vec3;
      // 0ca: astore 3
      // 0cb: aload 2
      // 0cc: iload 1
      // 0cd: ifne 0d8
      // 0d0: ifnull 126
      // 0d3: goto 0d7
      // 0d6: athrow
      // 0d7: aload 2
      // 0d8: getfield net/minecraft/util/MovingObjectPosition.typeOfHit Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // 0db: getstatic net/minecraft/util/MovingObjectPosition$MovingObjectType.BLOCK Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // 0de: if_acmpne 126
      // 0e1: aload 0
      // 0e2: getfield x/oc8edd24b1ed.Ѥ Lnet/minecraft/util/BlockPos;
      // 0e5: aload 2
      // 0e6: invokevirtual net/minecraft/util/MovingObjectPosition.getBlockPos ()Lnet/minecraft/util/BlockPos;
      // 0e9: invokevirtual net/minecraft/util/BlockPos.equals (Ljava/lang/Object;)Z
      // 0ec: ifeq 126
      // 0ef: goto 0f3
      // 0f2: athrow
      // 0f3: aload 2
      // 0f4: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 0f7: iload 1
      // 0f8: ifne 107
      // 0fb: goto 0ff
      // 0fe: athrow
      // 0ff: ifnull 126
      // 102: goto 106
      // 105: athrow
      // 106: aload 3
      // 107: aload 2
      // 108: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 10b: invokevirtual net/minecraft/util/Vec3.distanceTo (Lnet/minecraft/util/Vec3;)D
      // 10e: aload 0
      // 10f: invokevirtual x/oc8edd24b1ed.Ű ()D
      // 112: ldc2_w 1.0E-4
      // 115: dadd
      // 116: dcmpg
      // 117: iload 1
      // 118: ifne 123
      // 11b: ifgt 126
      // 11e: goto 122
      // 121: athrow
      // 122: bipush 1
      // 123: goto 127
      // 126: bipush 0
      // 127: istore 4
      // 129: iload 1
      // 12a: ifne 143
      // 12d: iload 4
      // 12f: ifeq 147
      // 132: goto 136
      // 135: athrow
      // 136: aload 0
      // 137: bipush 0
      // 138: putfield x/oc8edd24b1ed.Ӑ I
      // 13b: aload 0
      // 13c: invokevirtual x/oc8edd24b1ed.Ϣ ()V
      // 13f: goto 143
      // 142: athrow
      // 143: iload 1
      // 144: ifeq 23b
      // 147: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 14a: getfield net/minecraft/client/Minecraft.playerController Lnet/minecraft/client/multiplayer/PlayerControllerMP;
      // 14d: astore 5
      // 14f: aload 5
      // 151: ifnull 18d
      // 154: aload 0
      // 155: getfield x/oc8edd24b1ed.Ѥ Lnet/minecraft/util/BlockPos;
      // 158: aload 5
      // 15a: invokeinterface x/oc51cbcffcfe.getCurrentBlock ()Lnet/minecraft/util/BlockPos; 1
      // 15f: invokevirtual net/minecraft/util/BlockPos.equals (Ljava/lang/Object;)Z
      // 162: iload 1
      // 163: ifne 17e
      // 166: goto 16a
      // 169: athrow
      // 16a: ifeq 18d
      // 16d: goto 171
      // 170: athrow
      // 171: aload 5
      // 173: invokeinterface x/oc51cbcffcfe.getCurBlockDamageMP ()F 1
      // 178: fconst_0
      // 179: fcmpl
      // 17a: goto 17e
      // 17d: athrow
      // 17e: iload 1
      // 17f: ifne 18a
      // 182: ifle 18d
      // 185: goto 189
      // 188: athrow
      // 189: bipush 1
      // 18a: goto 18e
      // 18d: bipush 0
      // 18e: istore 6
      // 190: aload 0
      // 191: aload 3
      // 192: aload 0
      // 193: getfield x/oc8edd24b1ed.Ѥ Lnet/minecraft/util/BlockPos;
      // 196: invokevirtual x/oc8edd24b1ed.ӂ (Lnet/minecraft/util/Vec3;Lnet/minecraft/util/BlockPos;)D
      // 199: aload 0
      // 19a: invokevirtual x/oc8edd24b1ed.Ű ()D
      // 19d: ldc2_w 1.0E-4
      // 1a0: dadd
      // 1a1: dcmpg
      // 1a2: iload 1
      // 1a3: ifne 1be
      // 1a6: ifgt 1cd
      // 1a9: goto 1ad
      // 1ac: athrow
      // 1ad: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1b0: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 1b3: aload 0
      // 1b4: getfield x/oc8edd24b1ed.Ѥ Lnet/minecraft/util/BlockPos;
      // 1b7: invokevirtual net/minecraft/client/multiplayer/WorldClient.isAirBlock (Lnet/minecraft/util/BlockPos;)Z
      // 1ba: goto 1be
      // 1bd: athrow
      // 1be: iload 1
      // 1bf: ifne 1ca
      // 1c2: ifne 1cd
      // 1c5: goto 1c9
      // 1c8: athrow
      // 1c9: bipush 1
      // 1ca: goto 1ce
      // 1cd: bipush 0
      // 1ce: istore 7
      // 1d0: iload 6
      // 1d2: iload 1
      // 1d3: ifne 1f6
      // 1d6: ifne 1f0
      // 1d9: goto 1dd
      // 1dc: athrow
      // 1dd: aload 0
      // 1de: iload 1
      // 1df: ifne 238
      // 1e2: goto 1e6
      // 1e5: athrow
      // 1e6: getfield x/oc8edd24b1ed.ά Z
      // 1e9: ifeq 22e
      // 1ec: goto 1f0
      // 1ef: athrow
      // 1f0: iload 7
      // 1f2: goto 1f6
      // 1f5: athrow
      // 1f6: iload 1
      // 1f7: ifne 218
      // 1fa: ifeq 22e
      // 1fd: goto 201
      // 200: athrow
      // 201: aload 0
      // 202: iload 1
      // 203: ifne 238
      // 206: goto 20a
      // 209: athrow
      // 20a: dup
      // 20b: getfield x/oc8edd24b1ed.Ӑ I
      // 20e: bipush 1
      // 20f: iadd
      // 210: dup_x1
      // 211: putfield x/oc8edd24b1ed.Ӑ I
      // 214: goto 218
      // 217: athrow
      // 218: ldc_w -1669793013
      // 21b: ldc_w -1669793009
      // 21e: ixor
      // 21f: if_icmpgt 22e
      // 222: aload 0
      // 223: invokevirtual x/oc8edd24b1ed.Ϣ ()V
      // 226: iload 1
      // 227: ifeq 23b
      // 22a: goto 22e
      // 22d: athrow
      // 22e: aload 0
      // 22f: bipush 0
      // 230: putfield x/oc8edd24b1ed.Ӑ I
      // 233: aload 0
      // 234: goto 238
      // 237: athrow
      // 238: invokevirtual x/oc8edd24b1ed.ƽ ()V
      // 23b: return
   }

   @oc66fa4f2195
   public void Є(oc2f61de30bc param1) {
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
      // 09: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 0c: ifeq 71
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: goto 18
      // 17: athrow
      // 18: iload 2
      // 19: ifne 2b
      // 1c: invokevirtual x/oc8edd24b1ed.ǩ ()Z
      // 1f: ifne 71
      // 22: goto 26
      // 25: athrow
      // 26: aload 0
      // 27: goto 2b
      // 2a: athrow
      // 2b: invokevirtual x/oc8edd24b1ed.ʀ ()Z
      // 2e: iload 2
      // 2f: ifne 3c
      // 32: ifeq 71
      // 35: goto 39
      // 38: athrow
      // 39: getstatic x/ocb5d5ed49ea.ҋ Z
      // 3c: iload 2
      // 3d: ifne 4a
      // 40: ifne 71
      // 43: goto 47
      // 46: athrow
      // 47: getstatic x/ocb5d5ed49ea.ƃ Z
      // 4a: iload 2
      // 4b: ifne 58
      // 4e: ifne 71
      // 51: goto 55
      // 54: athrow
      // 55: getstatic x/ocb5d5ed49ea.Ӿ Z
      // 58: iload 2
      // 59: ifne 66
      // 5c: ifne 71
      // 5f: goto 63
      // 62: athrow
      // 63: getstatic x/ocb5d5ed49ea.ʷ Z
      // 66: ifne 71
      // 69: aload 0
      // 6a: invokevirtual x/oc8edd24b1ed.Ŝ ()V
      // 6d: goto 71
      // 70: athrow
      // 71: return
   }

   @oc66fa4f2195
   public void Ľ(oce79181588d param1) {
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
      // 005: iload 2
      // 006: ifne 016
      // 009: invokevirtual x/oc68d6b191af.isCanceled ()Z
      // 00c: ifeq 015
      // 00f: goto 013
      // 012: athrow
      // 013: return
      // 014: athrow
      // 015: aload 1
      // 016: invokevirtual x/oce79181588d.Ҡ ()Lnet/minecraft/network/Packet;
      // 019: astore 3
      // 01a: aload 0
      // 01b: iload 2
      // 01c: ifne 062
      // 01f: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 022: ifeq 061
      // 025: goto 029
      // 028: athrow
      // 029: aload 3
      // 02a: instanceof net/minecraft/network/play/server/S23PacketBlockChange
      // 02d: iload 2
      // 02e: ifne 065
      // 031: goto 035
      // 034: athrow
      // 035: ifeq 061
      // 038: goto 03c
      // 03b: athrow
      // 03c: aload 3
      // 03d: checkcast net/minecraft/network/play/server/S23PacketBlockChange
      // 040: astore 4
      // 042: aload 4
      // 044: invokevirtual net/minecraft/network/play/server/S23PacketBlockChange.getBlockState ()Lnet/minecraft/block/state/IBlockState;
      // 047: ifnull 061
      // 04a: aload 0
      // 04b: aload 4
      // 04d: invokevirtual net/minecraft/network/play/server/S23PacketBlockChange.getBlockPosition ()Lnet/minecraft/util/BlockPos;
      // 050: aload 4
      // 052: invokevirtual net/minecraft/network/play/server/S23PacketBlockChange.getBlockState ()Lnet/minecraft/block/state/IBlockState;
      // 055: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 05a: invokevirtual x/oc8edd24b1ed.Լ (Lnet/minecraft/util/BlockPos;Lnet/minecraft/block/Block;)V
      // 05d: goto 061
      // 060: athrow
      // 061: aload 0
      // 062: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 065: iload 2
      // 066: ifne 0e4
      // 069: ifeq 0d8
      // 06c: goto 070
      // 06f: athrow
      // 070: aload 3
      // 071: iload 2
      // 072: ifne 0d9
      // 075: goto 079
      // 078: athrow
      // 079: instanceof net/minecraft/network/play/server/S22PacketMultiBlockChange
      // 07c: ifeq 0d8
      // 07f: goto 083
      // 082: athrow
      // 083: aload 3
      // 084: checkcast net/minecraft/network/play/server/S22PacketMultiBlockChange
      // 087: invokevirtual net/minecraft/network/play/server/S22PacketMultiBlockChange.getChangedBlocks ()[Lnet/minecraft/network/play/server/S22PacketMultiBlockChange$BlockUpdateData;
      // 08a: astore 4
      // 08c: aload 4
      // 08e: arraylength
      // 08f: istore 5
      // 091: bipush 0
      // 092: istore 6
      // 094: iload 6
      // 096: iload 5
      // 098: if_icmpge 0d8
      // 09b: aload 4
      // 09d: iload 6
      // 09f: aaload
      // 0a0: astore 7
      // 0a2: iload 2
      // 0a3: ifne 128
      // 0a6: iload 2
      // 0a7: ifne 0d4
      // 0aa: goto 0ae
      // 0ad: athrow
      // 0ae: aload 7
      // 0b0: invokevirtual net/minecraft/network/play/server/S22PacketMultiBlockChange$BlockUpdateData.getBlockState ()Lnet/minecraft/block/state/IBlockState;
      // 0b3: ifnull 0d1
      // 0b6: goto 0ba
      // 0b9: athrow
      // 0ba: aload 0
      // 0bb: aload 7
      // 0bd: invokevirtual net/minecraft/network/play/server/S22PacketMultiBlockChange$BlockUpdateData.getPos ()Lnet/minecraft/util/BlockPos;
      // 0c0: aload 7
      // 0c2: invokevirtual net/minecraft/network/play/server/S22PacketMultiBlockChange$BlockUpdateData.getBlockState ()Lnet/minecraft/block/state/IBlockState;
      // 0c5: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 0ca: invokevirtual x/oc8edd24b1ed.Լ (Lnet/minecraft/util/BlockPos;Lnet/minecraft/block/Block;)V
      // 0cd: goto 0d1
      // 0d0: athrow
      // 0d1: iinc 6 1
      // 0d4: iload 2
      // 0d5: ifeq 094
      // 0d8: aload 3
      // 0d9: iload 2
      // 0da: ifne 129
      // 0dd: instanceof net/minecraft/network/play/server/S02PacketChat
      // 0e0: goto 0e4
      // 0e3: athrow
      // 0e4: ifeq 128
      // 0e7: aload 3
      // 0e8: checkcast net/minecraft/network/play/server/S02PacketChat
      // 0eb: invokevirtual net/minecraft/network/play/server/S02PacketChat.getChatComponent ()Lnet/minecraft/util/IChatComponent;
      // 0ee: invokeinterface net/minecraft/util/IChatComponent.getFormattedText ()Ljava/lang/String; 1
      // 0f3: astore 4
      // 0f5: aload 4
      // 0f7: iload 2
      // 0f8: ifne 10e
      // 0fb: ldc_w "§e§lProtect your bed and destroy the enemy bed"
      // 0fe: invokevirtual java/lang/String.contains (Ljava/lang/CharSequence;)Z
      // 101: ifne 11f
      // 104: goto 108
      // 107: athrow
      // 108: aload 4
      // 10a: goto 10e
      // 10d: athrow
      // 10e: ldc_w "§e§lDestroy the enemy bed and then eliminate them"
      // 111: invokevirtual java/lang/String.contains (Ljava/lang/CharSequence;)Z
      // 114: iload 2
      // 115: ifne 12c
      // 118: ifeq 128
      // 11b: goto 11f
      // 11e: athrow
      // 11f: aload 0
      // 120: bipush 1
      // 121: putfield x/oc8edd24b1ed.Ȓ Z
      // 124: goto 128
      // 127: athrow
      // 128: aload 3
      // 129: instanceof net/minecraft/network/play/server/S08PacketPlayerPosLook
      // 12c: iload 2
      // 12d: ifne 14f
      // 130: ifeq 166
      // 133: goto 137
      // 136: athrow
      // 137: aload 0
      // 138: aload 3
      // 139: checkcast net/minecraft/network/play/server/S08PacketPlayerPosLook
      // 13c: invokevirtual x/oc8edd24b1ed.ɢ (Lnet/minecraft/network/play/server/S08PacketPlayerPosLook;)V
      // 13f: iload 2
      // 140: ifne 162
      // 143: goto 147
      // 146: athrow
      // 147: aload 0
      // 148: getfield x/oc8edd24b1ed.Ȓ Z
      // 14b: goto 14f
      // 14e: athrow
      // 14f: ifeq 166
      // 152: aload 0
      // 153: bipush 0
      // 154: putfield x/oc8edd24b1ed.Ȓ Z
      // 157: aload 0
      // 158: getfield x/oc8edd24b1ed.S Ljava/util/ArrayList;
      // 15b: invokevirtual java/util/ArrayList.clear ()V
      // 15e: goto 162
      // 161: athrow
      // 162: aload 0
      // 163: invokevirtual x/oc8edd24b1ed.Ν ()V
      // 166: return
   }

   @oc66fa4f2195
   public void Ҹ(oc507025139f param1) {
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
      // 06: ifne 16
      // 09: invokevirtual x/oc8edd24b1ed.ǩ ()Z
      // 0c: ifeq 15
      // 0f: goto 13
      // 12: athrow
      // 13: return
      // 14: athrow
      // 15: aload 0
      // 16: iload 2
      // 17: ifne 29
      // 1a: invokevirtual x/oc8edd24b1ed.Ќ ()Z
      // 1d: ifne 5b
      // 20: goto 24
      // 23: athrow
      // 24: aload 0
      // 25: goto 29
      // 28: athrow
      // 29: getfield x/oc8edd24b1ed.Ѥ Lnet/minecraft/util/BlockPos;
      // 2c: ifnull 64
      // 2f: aload 1
      // 30: iload 2
      // 31: ifne 47
      // 34: goto 38
      // 37: athrow
      // 38: getfield x/oc507025139f.ϋ Lnet/minecraft/util/MovingObjectPosition;
      // 3b: ifnull 64
      // 3e: goto 42
      // 41: athrow
      // 42: aload 1
      // 43: goto 47
      // 46: athrow
      // 47: iload 2
      // 48: ifne 60
      // 4b: getfield x/oc507025139f.ϋ Lnet/minecraft/util/MovingObjectPosition;
      // 4e: getfield net/minecraft/util/MovingObjectPosition.typeOfHit Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // 51: getstatic net/minecraft/util/MovingObjectPosition$MovingObjectType.BLOCK Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // 54: if_acmpne 64
      // 57: goto 5b
      // 5a: athrow
      // 5b: aload 1
      // 5c: goto 60
      // 5f: athrow
      // 60: bipush 1
      // 61: invokevirtual x/oc68d6b191af.setCanceled (Z)V
      // 64: return
   }

   @oc66fa4f2195
   public void ε(oc479681b341 var1) {
      try {
         if (this.Ќ()) {
            var1.setCanceled(true);
         }
      } catch (ocbde1165e4e var2) {
         throw var2;
      }
   }

   @oc66fa4f2195
   public void ƽ(occ9a2be31f2 var1) {
      try {
         if (this.Ɩ != -1) {
            var1.setCanceled(true);
         }
      } catch (ocbde1165e4e var2) {
         throw var2;
      }
   }

   @oc66fa4f2195
   public void ή(oc142aa368f4 var1) {
      try {
         if (this.Ɩ != -1) {
            var1.setCanceled(true);
         }
      } catch (ocbde1165e4e var2) {
         throw var2;
      }
   }

   @oc66fa4f2195
   public void ĸ(ocf923d5a814 param1) {
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
      // 005: getfield x/ocb508b4e274.Ұ Lx/oc110d7f376c;
      // 008: getstatic x/oc110d7f376c.END Lx/oc110d7f376c;
      // 00b: if_acmpne 018
      // 00e: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 011: ifne 01a
      // 014: goto 018
      // 017: athrow
      // 018: return
      // 019: athrow
      // 01a: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 01d: iload 2
      // 01e: ifne 04a
      // 021: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 024: ifnull 043
      // 027: goto 02b
      // 02a: athrow
      // 02b: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 02e: iload 2
      // 02f: ifne 04a
      // 032: goto 036
      // 035: athrow
      // 036: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 039: instanceof net/minecraft/client/gui/GuiChat
      // 03c: ifeq 05f
      // 03f: goto 043
      // 042: athrow
      // 043: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 046: goto 04a
      // 049: athrow
      // 04a: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 04d: getfield net/minecraft/client/settings/GameSettings.showDebugInfo Z
      // 050: iload 2
      // 051: ifne 05c
      // 054: ifne 05f
      // 057: goto 05b
      // 05a: athrow
      // 05b: bipush 1
      // 05c: goto 060
      // 05f: bipush 0
      // 060: istore 3
      // 061: aload 0
      // 062: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 065: iload 2
      // 066: ifne 071
      // 069: ifeq 093
      // 06c: goto 070
      // 06f: athrow
      // 070: iload 3
      // 071: iload 2
      // 072: ifne 084
      // 075: ifeq 093
      // 078: goto 07c
      // 07b: athrow
      // 07c: aload 0
      // 07d: invokevirtual x/oc8edd24b1ed.À ()Z
      // 080: goto 084
      // 083: athrow
      // 084: iload 2
      // 085: ifne 090
      // 088: ifeq 093
      // 08b: goto 08f
      // 08e: athrow
      // 08f: bipush 1
      // 090: goto 094
      // 093: bipush 0
      // 094: istore 4
      // 096: iload 2
      // 097: ifne 0e8
      // 09a: aload 0
      // 09b: getfield x/oc8edd24b1ed.Ȉ Lx/oca9cc61aada;
      // 09e: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0a1: d2i
      // 0a2: bipush 1
      // 0a3: if_icmpne 0e1
      // 0a6: goto 0aa
      // 0a9: athrow
      // 0aa: iload 4
      // 0ac: ifeq 0c6
      // 0af: goto 0b3
      // 0b2: athrow
      // 0b3: aload 0
      // 0b4: getfield x/oc8edd24b1ed.ū Lx/oc2b4e974fd6;
      // 0b7: aload 0
      // 0b8: invokevirtual x/oc8edd24b1ed.Ɵ ()F
      // 0bb: invokevirtual x/oc2b4e974fd6.Ϭ (F)V
      // 0be: iload 2
      // 0bf: ifeq 0d1
      // 0c2: goto 0c6
      // 0c5: athrow
      // 0c6: aload 0
      // 0c7: getfield x/oc8edd24b1ed.ū Lx/oc2b4e974fd6;
      // 0ca: invokevirtual x/oc2b4e974fd6.Ϟ ()V
      // 0cd: goto 0d1
      // 0d0: athrow
      // 0d1: iload 3
      // 0d2: ifeq 0e0
      // 0d5: aload 0
      // 0d6: getfield x/oc8edd24b1ed.ū Lx/oc2b4e974fd6;
      // 0d9: invokevirtual x/oc2b4e974fd6.ô ()V
      // 0dc: goto 0e0
      // 0df: athrow
      // 0e0: return
      // 0e1: aload 0
      // 0e2: getfield x/oc8edd24b1ed.ū Lx/oc2b4e974fd6;
      // 0e5: invokevirtual x/oc2b4e974fd6.Ϟ ()V
      // 0e8: iload 3
      // 0e9: iload 2
      // 0ea: ifne 101
      // 0ed: ifeq 0ff
      // 0f0: goto 0f4
      // 0f3: athrow
      // 0f4: aload 0
      // 0f5: getfield x/oc8edd24b1ed.ū Lx/oc2b4e974fd6;
      // 0f8: invokevirtual x/oc2b4e974fd6.ô ()V
      // 0fb: goto 0ff
      // 0fe: athrow
      // 0ff: iload 4
      // 101: ifne 105
      // 104: return
      // 105: ldc_w "%d%%"
      // 108: bipush 1
      // 109: anewarray 817
      // 10c: dup
      // 10d: bipush 0
      // 10e: aload 0
      // 10f: invokevirtual x/oc8edd24b1ed.Ɵ ()F
      // 112: ldc_w 100.0
      // 115: fmul
      // 116: f2i
      // 117: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 11a: aastore
      // 11b: invokestatic java/lang/String.format (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      // 11e: astore 5
      // 120: new net/minecraft/client/gui/ScaledResolution
      // 123: dup
      // 124: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 127: invokespecial net/minecraft/client/gui/ScaledResolution.<init> (Lnet/minecraft/client/Minecraft;)V
      // 12a: astore 6
      // 12c: invokestatic x/oce6044968f8.ԗ ()Lx/oc1378bc114d;
      // 12f: astore 7
      // 131: aload 7
      // 133: aload 5
      // 135: invokeinterface x/oc1378bc114d.z$toz8pt08w0nc (Ljava/lang/String;)I 2
      // 13a: i2f
      // 13b: fstore 8
      // 13d: aload 6
      // 13f: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledWidth ()I
      // 142: i2f
      // 143: fconst_2
      // 144: fdiv
      // 145: fload 8
      // 147: fconst_2
      // 148: fdiv
      // 149: fsub
      // 14a: fstore 9
      // 14c: aload 6
      // 14e: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledHeight ()I
      // 151: i2f
      // 152: ldc_w 5.0
      // 155: fdiv
      // 156: fconst_2
      // 157: fmul
      // 158: fstore 10
      // 15a: invokestatic x/oce6044968f8.ǆ ()F
      // 15d: fstore 11
      // 15f: invokestatic x/oce6044968f8.š ()F
      // 162: fstore 12
      // 164: fload 9
      // 166: fload 11
      // 168: fsub
      // 169: fload 10
      // 16b: fload 12
      // 16d: fsub
      // 16e: fload 8
      // 170: fload 11
      // 172: fconst_2
      // 173: fmul
      // 174: fadd
      // 175: aload 7
      // 177: invokeinterface x/oc1378bc114d.z$1tqmx4tpnr6lq ()I 1
      // 17c: i2f
      // 17d: fload 12
      // 17f: fconst_2
      // 180: fmul
      // 181: fadd
      // 182: aload 7
      // 184: aload 5
      // 186: fload 9
      // 188: fload 10
      // 18a: invokedynamic run (Lx/oc1378bc114d;Ljava/lang/String;FF)Ljava/lang/Runnable; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ ()V, x/oc8edd24b1ed.q3g8ssq08ciymy (Lx/oc1378bc114d;Ljava/lang/String;FF)V, ()V ]
      // 18f: invokestatic x/oce6044968f8.ӱ (FFFFLjava/lang/Runnable;)V
      // 192: return
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.LOW
   )
   public void Ş(oc746a23b244 param1) {
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
      // 09: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 0c: ifeq 3a
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: goto 18
      // 17: athrow
      // 18: getfield x/oc8edd24b1ed.Ѥ Lnet/minecraft/util/BlockPos;
      // 1b: ifnull 3a
      // 1e: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 21: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 24: aload 0
      // 25: getfield x/oc8edd24b1ed.Ѥ Lnet/minecraft/util/BlockPos;
      // 28: invokevirtual net/minecraft/client/multiplayer/WorldClient.isAirBlock (Lnet/minecraft/util/BlockPos;)Z
      // 2b: iload 2
      // 2c: ifne 47
      // 2f: goto 33
      // 32: athrow
      // 33: ifeq 3b
      // 36: goto 3a
      // 39: athrow
      // 3a: return
      // 3b: aload 0
      // 3c: iload 2
      // 3d: ifne 70
      // 40: invokevirtual x/oc8edd24b1ed.ǩ ()Z
      // 43: goto 47
      // 46: athrow
      // 47: ifne 6f
      // 4a: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 4d: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 50: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 53: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 56: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getEntityId ()I
      // 59: aload 0
      // 5a: getfield x/oc8edd24b1ed.Ѥ Lnet/minecraft/util/BlockPos;
      // 5d: aload 0
      // 5e: invokevirtual x/oc8edd24b1ed.Ɵ ()F
      // 61: ldc_w 10.0
      // 64: fmul
      // 65: f2i
      // 66: bipush 1
      // 67: isub
      // 68: invokevirtual net/minecraft/client/multiplayer/WorldClient.sendBlockBreakProgress (ILnet/minecraft/util/BlockPos;I)V
      // 6b: goto 6f
      // 6e: athrow
      // 6f: aload 0
      // 70: aload 0
      // 71: getfield x/oc8edd24b1ed.Ѥ Lnet/minecraft/util/BlockPos;
      // 74: aload 0
      // 75: iload 2
      // 76: ifne 88
      // 79: getfield x/oc8edd24b1ed.ɗ Z
      // 7c: ifeq 8e
      // 7f: goto 83
      // 82: athrow
      // 83: aload 0
      // 84: goto 88
      // 87: athrow
      // 88: invokevirtual x/oc8edd24b1ed.Ζ ()D
      // 8b: goto 8f
      // 8e: dconst_1
      // 8f: aload 0
      // 90: invokevirtual x/oc8edd24b1ed.Ѯ ()Ljava/awt/Color;
      // 93: invokevirtual x/oc8edd24b1ed.ӗ (Lnet/minecraft/util/BlockPos;DLjava/awt/Color;)V
      // 96: return
   }

   @oc66fa4f2195
   public void ă(ocadfd5cc157 var1) {
      try {
         if (var1.Ц != oc69da1aa7f5.ő.thePlayer) {
            return;
         }
      } catch (ocbde1165e4e var2) {
         throw var2;
      }

      this.Ȓ = false;
      this.Ϣ = -6752013505538182394L ^ 6752013505538182393L;
      this.S.clear();
      this.Α = null;
      this.Ô = false;
      this.ū.ӓ();
      this.ҭ();
      this.P();
      this.Ը();
   }

   @oc66fa4f2195
   public void Ν(oc02e6d57a60 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: aload 1
      // 04: getfield x/oc02e6d57a60.ǫ Lnet/minecraft/util/IChatComponent;
      // 07: invokeinterface net/minecraft/util/IChatComponent.getUnformattedText ()Ljava/lang/String; 1
      // 0c: astore 3
      // 0d: istore 2
      // 0e: aload 3
      // 0f: iload 2
      // 10: ifne 25
      // 13: ldc_w "Protect your bed and destroy the enemy bed"
      // 16: invokevirtual java/lang/String.contains (Ljava/lang/CharSequence;)Z
      // 19: ifne 2e
      // 1c: goto 20
      // 1f: athrow
      // 20: aload 3
      // 21: goto 25
      // 24: athrow
      // 25: ldc_w "Destroy the enemy bed and then eliminate them"
      // 28: invokevirtual java/lang/String.contains (Ljava/lang/CharSequence;)Z
      // 2b: ifeq 37
      // 2e: aload 0
      // 2f: bipush 1
      // 30: putfield x/oc8edd24b1ed.Ȓ Z
      // 33: goto 37
      // 36: athrow
      // 37: return
   }

   @Override
   public void onEnable() {
      this.Ô = false;
      this.ū.ӓ();
      this.ҭ();
      this.P();
   }

   @Override
   public void onDisable() {
      this.ū.ӓ();
      this.ҭ();
      this.P();
      this.Ը();
      this.Ô = false;
      this.Ȓ = false;
      this.Ϣ = 5234665365301822289L ^ -5234665365301822290L;
   }

   @Override
   public void z$2u87utkr1isxg() {
      this.ƚ.ȉ(this.Ƒ.ǭ(), this);
   }

   @Override
   public String getInfo() {
      String var1 = this.ӧ.Ҿ()[(int)this.ӧ.Ӂ()].toLowerCase(Locale.ROOT);
      return Character.toUpperCase(var1.charAt(0)) + var1.substring(1);
   }

   private double Ζ() {
      int var10000 = oc84f20a0bc5.ė;
      occa6aba7d1a var2 = (occa6aba7d1a)oc9755810e45.ʬ(occa6aba7d1a.class);
      int var1 = var10000;

      try {
         if (var1 != 0) {
            return var2.Ѻ();
         }

         if (var2 == null) {
            return 0.5625;
         }
      } catch (ocbde1165e4e var3) {
         throw var3;
      }

      return var2.Ѻ();
   }

   private void ӗ(BlockPos var1, double var2, Color var4) {
      double var5 = var1.getX() - oc69da1aa7f5.ő.getRenderManager().viewerPosX;
      double var7 = var1.getY() - oc69da1aa7f5.ő.getRenderManager().viewerPosY;
      double var9 = var1.getZ() - oc69da1aa7f5.ő.getRenderManager().viewerPosZ;
      AxisAlignedBB var11 = new AxisAlignedBB(var5, var7, var9, var5 + 1.0, var7 + var2, var9 + 1.0);
      float var12 = var4.getRed() / 255.0F;
      float var13 = var4.getGreen() / 255.0F;
      float var14 = var4.getBlue() / 255.0F;
      float var15 = var4.getAlpha() / 255.0F;
      GL11.glPushMatrix();
      GlStateManager.enableBlend();
      GlStateManager.disableTexture2D();
      GlStateManager.disableDepth();
      GlStateManager.depthMask(false);
      GL11.glBlendFunc(374132609 ^ 374131843, 374132608 ^ 374131843);
      ocbd4917c4b1.ʓ(var11, var12, var13, var14, var15 * 0.25F);
      GL11.glLineWidth(2.0F);
      GL11.glColor4f(var12, var13, var14, var15);
      RenderGlobal.drawSelectionBoundingBox(var11);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GlStateManager.enableDepth();
      GlStateManager.depthMask(true);
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
      GL11.glPopMatrix();
   }

   private float[] ȩ(double var1, double var3, double var5) {
      double var7 = var1 - oc69da1aa7f5.ő.thePlayer.posX;
      double var9 = var3 - (oc69da1aa7f5.ő.thePlayer.posY + oc69da1aa7f5.ő.thePlayer.getEyeHeight());
      double var11 = var5 - oc69da1aa7f5.ő.thePlayer.posZ;
      double var13 = MathHelper.sqrt_double(var7 * var7 + var11 * var11);
      float[] var10000 = new float[1351935680 ^ 1351935682];
      var10000[0] = (float)(Math.atan2(var11, var7) * 180.0 / Math.PI) - 90.0F;
      var10000[1] = (float)(-(Math.atan2(var9, var13) * 180.0 / Math.PI));
      return var10000;
   }

   public boolean Ք() {
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
      // 09: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 0c: ifeq 36
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: goto 18
      // 17: athrow
      // 18: iload 1
      // 19: ifne 2b
      // 1c: invokevirtual x/oc8edd24b1ed.ǩ ()Z
      // 1f: ifeq 36
      // 22: goto 26
      // 25: athrow
      // 26: aload 0
      // 27: goto 2b
      // 2a: athrow
      // 2b: getfield x/oc8edd24b1ed.Ѥ Lnet/minecraft/util/BlockPos;
      // 2e: ifnull 36
      // 31: bipush 1
      // 32: goto 37
      // 35: athrow
      // 36: bipush 0
      // 37: ireturn
   }

   public boolean Ɵ() {
      return this.Ƒ.ǭ();
   }

   public float ӆ() {
      return 1.0F;
   }

   public int ʉ() {
      return -2095359218 ^ -2095359221;
   }

   public boolean φ() {
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
      // 09: invokevirtual x/oc8edd24b1ed.Ƅ ()Z
      // 0c: ifeq 2a
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: goto 18
      // 17: athrow
      // 18: invokevirtual x/oc8edd24b1ed.ҡ ()Z
      // 1b: iload 1
      // 1c: ifne 27
      // 1f: ifne 2a
      // 22: goto 26
      // 25: athrow
      // 26: bipush 1
      // 27: goto 2b
      // 2a: bipush 0
      // 2b: ireturn
   }

   private boolean À() {
      int var1 = oc84f20a0bc5.ė;
      int var2 = 167771919 ^ -1617486276;

      while (true) {
         switch (var2) {
            case -712584788:
               return true;
            case 207917902:
               int var10000;
               label58: {
                  label57: {
                     try {
                        var10000 = this.ɗ;
                        if (var1 != 0) {
                           break label58;
                        }

                        if (!this.ɗ) {
                           break label57;
                        }
                     } catch (ocbde1165e4e var4) {
                        throw var4;
                     }

                     var2 = -790117254 ^ -1617486276;
                     if (var1 == 0) {
                        continue;
                     }
                  }

                  var10000 = 1242681232 ^ -1617486276;
               }

               var2 = var10000;
               if (var1 == 0) {
                  continue;
               }
            case -1771511501:
               if (this.Ѥ != null) {
                  var2 = -1812755086 ^ -1617486276;
                  if (var1 == 0) {
                     continue;
                  }
               }

               var2 = -740136034 ^ -1617486276;
               if (var1 == 0) {
                  continue;
               }
               break;
            case 1282766242:
               return false;
            case 1332795974:
               break;
            default:
               throw null;
         }

         int var5;
         label45: {
            label44: {
               try {
                  var5 = this.Ò.ǭ();
                  if (var1 != 0) {
                     break label45;
                  }

                  if (var5 != 0) {
                     break label44;
                  }
               } catch (ocbde1165e4e var3) {
                  throw var3;
               }

               var2 = 1242681232 ^ -1617486276;
               if (var1 == 0) {
                  continue;
               }
            }

            var5 = -740136034 ^ -1617486276;
         }

         var2 = var5;
         if (var1 != 0) {
            return true;
         }
      }
   }

   private boolean д() {
      int var1 = oc84f20a0bc5.ė;
      int var2 = 512741779 ^ -1897628748;

      while (true) {
         switch (var2) {
            case -1871992281:
               if (this.Α != null) {
                  var2 = 1633269351 ^ -1897628748;
                  if (var1 == 0) {
                     break;
                  }
               }

               var2 = -152046959 ^ -1897628748;
               break;
            case -272773677:
               int var10000;
               label34: {
                  label33: {
                     try {
                        var10000 = this.Տ.ǭ();
                        if (var1 != 0) {
                           break label34;
                        }

                        if (!ͽ((boolean)var10000, oc69da1aa7f5.ő.thePlayer.getDistanceSq(this.Α.xCoord, this.Α.yCoord, this.Α.zCoord))) {
                           break label33;
                        }
                     } catch (ocbde1165e4e var3) {
                        throw var3;
                     }

                     var2 = -1464622447 ^ -1897628748;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var10000 = -152046959 ^ -1897628748;
               }

               var2 = var10000;
               if (var1 == 0) {
                  break;
               }
            case 643291429:
               return true;
            case 2014021925:
               return false;
            default:
               throw null;
         }
      }
   }

   private void ɢ(S08PacketPlayerPosLook var1) {
      int var2 = oc84f20a0bc5.ė;

      try {
         if (!oc7ab2161b9f.Ð()) {
            return;
         }
      } catch (ocbde1165e4e var19) {
         throw var19;
      }

      double var3 = var1.getX();
      double var5 = var1.getY();
      double var7 = var1.getZ();
      Set var9 = var1.func_179834_f();

      Set var10000;
      label65: {
         EnumFlags var10001;
         label53: {
            label52: {
               try {
                  var10000 = var9;
                  var10001 = EnumFlags.X;
                  if (var2 != 0) {
                     break label53;
                  }

                  if (!var9.contains(EnumFlags.X)) {
                     break label52;
                  }
               } catch (ocbde1165e4e var18) {
                  throw var18;
               }

               var3 += oc69da1aa7f5.ő.thePlayer.posX;
            }

            try {
               var10000 = var9;
               if (var2 != 0) {
                  break label65;
               }

               var10001 = EnumFlags.Y;
            } catch (ocbde1165e4e var17) {
               throw var17;
            }
         }

         if (var10000.contains(var10001)) {
            var5 += oc69da1aa7f5.ő.thePlayer.posY;
         }

         var10000 = var9;
      }

      if (var10000.contains(EnumFlags.Z)) {
         var7 += oc69da1aa7f5.ő.thePlayer.posZ;
      }

      double var10 = var3 - oc69da1aa7f5.ő.thePlayer.posX;
      double var12 = var5 - oc69da1aa7f5.ő.thePlayer.posY;
      double var14 = var7 - oc69da1aa7f5.ő.thePlayer.posZ;

      try {
         if (ƛ(var10 * var10 + var12 * var12 + var14 * var14)) {
            this.Α = new Vec3(var3, var5, var7);
         }
      } catch (ocbde1165e4e var16) {
         throw var16;
      }
   }

   static boolean ͽ(boolean param0, double param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 3
      // 04: iload 0
      // 05: iload 3
      // 06: ifne 19
      // 09: ifeq 28
      // 0c: goto 10
      // 0f: athrow
      // 10: dload 1
      // 11: ldc2_w 1225.0
      // 14: dcmpg
      // 15: goto 19
      // 18: athrow
      // 19: iload 3
      // 1a: ifne 25
      // 1d: ifge 28
      // 20: goto 24
      // 23: athrow
      // 24: bipush 1
      // 25: goto 29
      // 28: bipush 0
      // 29: ireturn
   }

   static boolean ƛ(double var0) {
      int var2 = oc84f20a0bc5.ė;

      try {
         double var4;
         int var10000 = (var4 = var0 - 1600.0) == 0.0 ? 0 : (var4 < 0.0 ? -1 : 1);
         if (var2 != 0) {
            return (boolean)var10000;
         }

         if (var10000 > 0) {
            return (boolean)1;
         }
      } catch (ocbde1165e4e var3) {
         throw var3;
      }

      return (boolean)0;
   }

   public void ß(float var1) {
   }

   public boolean Ƴ() {
      return this.ʀ();
   }

   public BlockPos ԓ() {
      return this.Ѥ;
   }

   public Vec3 Ъ() {
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
      // 05: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 08: ifeq 18
      // 0b: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0e: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 11: ifnonnull 1b
      // 14: goto 18
      // 17: athrow
      // 18: aconst_null
      // 19: areturn
      // 1a: athrow
      // 1b: aload 0
      // 1c: iload 1
      // 1d: ifne 83
      // 20: getfield x/oc8edd24b1ed.Ѥ Lnet/minecraft/util/BlockPos;
      // 23: ifnull 82
      // 26: goto 2a
      // 29: athrow
      // 2a: aload 0
      // 2b: iload 1
      // 2c: ifne 44
      // 2f: goto 33
      // 32: athrow
      // 33: getfield x/oc8edd24b1ed.ŷ Lnet/minecraft/util/Vec3;
      // 36: ifnull 43
      // 39: goto 3d
      // 3c: athrow
      // 3d: aload 0
      // 3e: getfield x/oc8edd24b1ed.ŷ Lnet/minecraft/util/Vec3;
      // 41: areturn
      // 42: athrow
      // 43: aload 0
      // 44: iload 1
      // 45: ifne 5b
      // 48: getfield x/oc8edd24b1ed.Ū Lnet/minecraft/util/BlockPos;
      // 4b: ifnull 5a
      // 4e: goto 52
      // 51: athrow
      // 52: aload 0
      // 53: getfield x/oc8edd24b1ed.Ū Lnet/minecraft/util/BlockPos;
      // 56: goto 5e
      // 59: athrow
      // 5a: aload 0
      // 5b: getfield x/oc8edd24b1ed.Ѥ Lnet/minecraft/util/BlockPos;
      // 5e: astore 2
      // 5f: new net/minecraft/util/Vec3
      // 62: dup
      // 63: aload 2
      // 64: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 67: i2d
      // 68: ldc2_w 0.5
      // 6b: dadd
      // 6c: aload 2
      // 6d: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 70: i2d
      // 71: ldc2_w 0.5
      // 74: dadd
      // 75: aload 2
      // 76: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 79: i2d
      // 7a: ldc2_w 0.5
      // 7d: dadd
      // 7e: invokespecial net/minecraft/util/Vec3.<init> (DDD)V
      // 81: areturn
      // 82: aload 0
      // 83: iload 1
      // 84: ifne 96
      // 87: invokevirtual x/oc8edd24b1ed.ҿ ()Z
      // 8a: ifeq 9c
      // 8d: goto 91
      // 90: athrow
      // 91: aload 0
      // 92: goto 96
      // 95: athrow
      // 96: getfield x/oc8edd24b1ed.ΐ Lnet/minecraft/util/Vec3;
      // 99: goto 9d
      // 9c: aconst_null
      // 9d: areturn
   }

   public float Ђ() {
      return this.floatOwing();
   }

   static {
      String[] var10000 = new String[395499960 ^ 395499962];
      var10000[0] = "Text";
      var10000[1] = "Bar";
      Ή = var10000;
   }
}
