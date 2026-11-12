 // scaffold modules\
package x;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovementInput;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;

public class oc668fce0dbf extends oc69da1aa7f5 {
   private static final String[] ӂ;
   private static final String[] Ž;
   private static final String[] Ŗ;
   private static final String[] ƪ;
   private static final String[] ӓ;
   private static final String[] ҏ;
   private static final float[] ε;
   private static List<Block> Ƿ;
   private static final int ř = 0;
   private static final int ɨ = 1;
   private static final int ʩ = 2;
   private static final int Ǒ = 3;
   private static final int ʋ = 0;
   private static final int Ŧ = 1;
   private static final int Ϗ = 2;
   private static final int Ğ = -1;
   private static final int Ȕ = 0;
   private static final int ҹ = 1;
   private static final int Վ = 4;
   private static final double ˡ = 0.3;
   private static final float ğ = 30.0F;
   private static final float ŉ = 20.0F;
   private static final int Ɋ = 1;
   private static final float ŭ = 149.0F;
   private static final int Ř = 5;
   private static final float Σ = 76.0F;
   private static final float δ = 70.0F;
   private static final float Ŵ = 84.0F;
   private static final float ǩ = 80.0F;
   private static final float с = 45.0F;
   private static final float Ū = 10.0F;
   private static final float Ǖ = 1.8F;
   private static final float Ƒ = 0.1F;
   private static final int ԕ = 100;
   private static final oc7beea7ccff ӧ = oc7beea7ccff.կ();
   private static final oca15072e54e ճ = new oca15072e54e();
   private static boolean բ;
   private final oc41ddc58b4a Ȉ = new oc41ddc58b4a();
   private final ocae1739aac7 ӎ = new ocae1739aac7();
   private final oca9cc61aada Ʃ;
   private final oca9cc61aada ƫ;
   private final oca9cc61aada ʪ;
   private final oca9cc61aada ϩ;
   private final oca9cc61aada ɒ;
   private final oca9cc61aada ӯ;
   private final occ2f8dff8d8 Ä;
   private final occ2f8dff8d8 գ;
   private final occ2f8dff8d8 Ы;
   private final occ2f8dff8d8 ґ;
   private final occ2f8dff8d8 ʖ;
   public final occ2f8dff8d8 Ư;
   private final occ2f8dff8d8 Ը;
   private final ocf1568fef75 Ү;
   private final occ2f8dff8d8 f;
   private final occ2f8dff8d8 ŏ;
   private final oca9cc61aada Ѷ;
   private final occ2f8dff8d8 Ѝ;
   private final occ2f8dff8d8 Ś;
   private final occ2f8dff8d8 ҵ;
   private final oca9cc61aada â;
   private final occ2f8dff8d8 ċ;
   private final occ2f8dff8d8 Ɯ;
   private final occ2f8dff8d8 ǔ;
   private final occ2f8dff8d8 ϕ;
   private final oca9cc61aada ȍ;
   private final ocf1568fef75 g;
   private final ocf1568fef75 Е;
   private final oc08992069b4 ʱ;
   private final ocbce5ea28a3 Ќ;
   private final oc3b42959d05 ӱ;
   private final oc11364ce42a ū;
   private float[] Ţ = new float[-1956034800 ^ -1956034798];
   private oc29fb8ce47a Ț;
   private oc412a041b25 Ջ;
   private float Ӛ = Float.NaN;
   private int Ȧ = 1;
   private boolean Ų;
   private float ə;
   private long ľ = -5160691347054104588L ^ 5160691347054104587L;
   private int Ʉ;
   private int ԛ;
   private int դ;
   private int Β;
   private int Ѡ;
   private int Ƚ;
   private boolean Ր;
   private boolean ո;
   private int ư = -1;
   private int Ɓ = -1;
   private int ɛ;
   private oc412a041b25 Ъ;
   private boolean J;
   private boolean Ƅ;
   private final oc8ef88da691 У = new oc8ef88da691(false, System.currentTimeMillis());
   private final ocff76b7be49 Ȝ = new ocff76b7be49(this);
   public static boolean e;

   public oc668fce0dbf() {
      super("Scaffold", oce4cea752dd.з);
      this.ą("Automatically places blocks beneath you while moving.");
      this.ʌ(this.Ʃ = new ocaa016f719c());
      this.ʌ(this.ƫ = new oca9cc61aada("Rotation", 0, Ž));
      this.ʌ(this.ʪ = new oca9cc61aada("Sprint", 1, ƪ));
      this.ʌ(this.ϩ = new oca9cc61aada("Yaw", 1, ҏ, "setting.tellyYaw"));
      this.ʌ(this.ɒ = new oca9cc61aada("Sneak", 0, ӓ, "setting.tellySneak"));
      this.z$1k81rl22ylo65(this.ӯ = new oca9cc61aada("Sneak every x cycle", 1.0, 1.0, 10.0, 1.0), "setting.tellySneakEveryCycle");
      this.Ä = new occ2f8dff8d8("Spoof Items (Silent)", false);
      this.ʌ(this.գ = new occ2f8dff8d8("Flick", true));
      this.ʌ(this.Ы = new occ2f8dff8d8("KeepY", false));
      this.ʌ(this.ґ = new occ2f8dff8d8("Jump on userinput", false));
      this.ʌ(this.ʖ = new occ2f8dff8d8("RMB Only", false));
      this.ʌ(this.Ư = new occ2f8dff8d8("While KillAura", false));
      this.ʌ(this.Ը = new occ2f8dff8d8("Clutch", false));
      this.ʌ(this.Ү = new ocf1568fef75("Rotation Speed", 1.0, 360.0, 180.0, 360.0, 1.0));
      this.ʌ(this.f = new occ2f8dff8d8("SafeWalk", true));
      this.ʌ(this.ϕ = new occ2f8dff8d8("NoSwing", false));
      this.ʌ(this.ŏ = new occ2f8dff8d8("Count-Block", true));
      this.ʌ(this.Ѷ = new oca9cc61aada("Animation", -1956034800 ^ -1956034798, Ŗ));
      this.ʌ(this.ǔ = new occ2f8dff8d8("Eagle", false));
      this.ʌ(this.ȍ = new oca9cc61aada("Eagle Distance", 0.0, 0.0, 0.5, 0.01));
      this.ʌ(this.g = new ocf1568fef75("Eagle Ticks", 0.0, 20.0, 1.0, 5.0, 1.0));
      this.ʌ(this.Е = new ocf1568fef75("Sneak Per Block", 0.0, 10.0, 0.0, 0.0, 1.0));
      this.ʱ = new oc08992069b4(this);
      this.z$1k81rl22ylo65(this.Ѝ = new ocecd8261f25("Intave", "Normal.Intave", false), "setting.normalIntave");
      this.z$1k81rl22ylo65(this.Ś = new ocecd8261f25("Intave", "Telly.Intave", false), "setting.tellyIntave");
      this.z$1k81rl22ylo65(this.ҵ = new ocecd8261f25("SameY", "Telly2.SameY", true), "setting.telly2SameY");
      String[] var10006 = new String[-1956034799 ^ -1956034798];
      var10006[0] = "Disabled";
      var10006[1] = "1 extra";
      var10006[-1956034800 ^ -1956034798] = "2 extra";
      this.ʌ(this.â = new oca9cc61aada("Multi-Place", 0, var10006));
      this.ʌ(this.ċ = new occ2f8dff8d8("Tower", true));
      this.ʌ(this.Ɯ = new occ2f8dff8d8("Keep-Y on Press Right", true));
      this.Ќ = new ocbce5ea28a3(this);
      this.ӱ = new oc3b42959d05(this);
      this.ū = new oc11364ce42a(this);
      this.z$2u87utkr1isxg();
   }

   @Override
   public String getInfo() {
      return ӂ[(int)this.Ʃ.Ӂ()];
   }

   public boolean Ƶ() {
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
      // 08: iload 1
      // 09: ifne 4b
      // 0c: ifeq 4a
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: iload 1
      // 15: ifne 39
      // 18: goto 1c
      // 1b: athrow
      // 1c: invokevirtual x/oc668fce0dbf.Ü ()Z
      // 1f: ifeq 38
      // 22: goto 26
      // 25: athrow
      // 26: aload 0
      // 27: getfield x/oc668fce0dbf.ū Lx/oc11364ce42a;
      // 2a: invokevirtual x/oc11364ce42a.ю ()Z
      // 2d: ifeq 4e
      // 30: goto 34
      // 33: athrow
      // 34: goto 4a
      // 37: athrow
      // 38: aload 0
      // 39: getfield x/oc668fce0dbf.Ư Lx/occ2f8dff8d8;
      // 3c: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 3f: iload 1
      // 40: ifne 4b
      // 43: ifeq 4e
      // 46: goto 4a
      // 49: athrow
      // 4a: bipush 1
      // 4b: goto 4f
      // 4e: bipush 0
      // 4f: ireturn
   }

   public boolean Ց() {
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
      // 08: iload 1
      // 09: ifne 3d
      // 0c: ifeq 3c
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: invokevirtual x/oc668fce0dbf.Ü ()Z
      // 17: iload 1
      // 18: ifne 3d
      // 1b: goto 1f
      // 1e: athrow
      // 1f: ifeq 3c
      // 22: goto 26
      // 25: athrow
      // 26: aload 0
      // 27: getfield x/oc668fce0dbf.ū Lx/oc11364ce42a;
      // 2a: invokevirtual x/oc11364ce42a.κ ()Z
      // 2d: iload 1
      // 2e: ifne 3d
      // 31: goto 35
      // 34: athrow
      // 35: ifeq 40
      // 38: goto 3c
      // 3b: athrow
      // 3c: bipush 1
      // 3d: goto 41
      // 40: bipush 0
      // 41: ireturn
   }

   @Override
   public void onEnable() {
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
      // 06: getfield x/oc668fce0dbf.Ȉ Lx/oc41ddc58b4a;
      // 09: invokevirtual x/oc41ddc58b4a.Ď ()V
      // 0c: ifne bb
      // 0f: aload 0
      // 10: getfield x/oc668fce0dbf.ӎ Lx/ocae1739aac7;
      // 13: invokevirtual x/ocae1739aac7.ʲ ()V
      // 16: aload 0
      // 17: getfield x/oc668fce0dbf.Ȝ Lx/ocff76b7be49;
      // 1a: bipush 0
      // 1b: invokevirtual x/ocff76b7be49.ĳ (Z)V
      // 1e: aload 0
      // 1f: invokevirtual x/oc668fce0dbf.ϝ ()V
      // 22: getstatic x/oc718fd4d503.Ō Lx/oc718fd4d503;
      // 25: aload 0
      // 26: bipush 1
      // 27: invokevirtual x/oc718fd4d503.à (Ljava/lang/Object;Z)V
      // 2a: aload 0
      // 2b: invokevirtual x/oc668fce0dbf.ʌ ()V
      // 2e: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 31: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 34: ifnull 75
      // 37: goto 3b
      // 3a: athrow
      // 3b: aload 0
      // 3c: iload 1
      // 3d: ifne bc
      // 40: goto 44
      // 43: athrow
      // 44: invokevirtual x/oc668fce0dbf.Ɯ ()Z
      // 47: ifne 75
      // 4a: goto 4e
      // 4d: athrow
      // 4e: aload 0
      // 4f: iload 1
      // 50: ifne bc
      // 53: goto 57
      // 56: athrow
      // 57: invokevirtual x/oc668fce0dbf.Ü ()Z
      // 5a: ifne 75
      // 5d: goto 61
      // 60: athrow
      // 61: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 64: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 67: getfield net/minecraft/client/settings/GameSettings.keyBindSprint Lnet/minecraft/client/settings/KeyBinding;
      // 6a: invokevirtual net/minecraft/client/settings/KeyBinding.getKeyCode ()I
      // 6d: bipush 0
      // 6e: invokestatic net/minecraft/client/settings/KeyBinding.setKeyBindState (IZ)V
      // 71: goto 75
      // 74: athrow
      // 75: aload 0
      // 76: aconst_null
      // 77: putfield x/oc668fce0dbf.Ț Lx/oc29fb8ce47a;
      // 7a: aload 0
      // 7b: aconst_null
      // 7c: putfield x/oc668fce0dbf.Ջ Lx/oc412a041b25;
      // 7f: aload 0
      // 80: invokevirtual x/oc668fce0dbf.Д ()V
      // 83: aload 0
      // 84: bipush 0
      // 85: putfield x/oc668fce0dbf.ԛ I
      // 88: aload 0
      // 89: invokevirtual x/oc668fce0dbf.ӌ ()V
      // 8c: aload 0
      // 8d: invokevirtual x/oc668fce0dbf.Ɏ ()V
      // 90: aload 0
      // 91: getfield x/oc668fce0dbf.Ќ Lx/ocbce5ea28a3;
      // 94: invokevirtual x/ocbce5ea28a3.ϔ ()V
      // 97: aload 0
      // 98: getfield x/oc668fce0dbf.ӱ Lx/oc3b42959d05;
      // 9b: invokevirtual x/oc3b42959d05.ą ()V
      // 9e: aload 0
      // 9f: getfield x/oc668fce0dbf.ʱ Lx/oc08992069b4;
      // a2: invokevirtual x/oc08992069b4.ʄ ()V
      // a5: getstatic x/oc668fce0dbf.ӧ Lx/oc7beea7ccff;
      // a8: invokevirtual x/oc7beea7ccff.Ψ ()V
      // ab: aload 0
      // ac: invokevirtual x/oc668fce0dbf.ʢ ()V
      // af: aload 0
      // b0: iload 1
      // b1: ifne d6
      // b4: invokevirtual x/oc668fce0dbf.ƌ ()V
      // b7: goto bb
      // ba: athrow
      // bb: aload 0
      // bc: invokevirtual x/oc668fce0dbf.Ü ()Z
      // bf: ifeq d1
      // c2: aload 0
      // c3: getfield x/oc668fce0dbf.ū Lx/oc11364ce42a;
      // c6: invokevirtual x/oc11364ce42a.Ȓ ()V
      // c9: iload 1
      // ca: ifeq d9
      // cd: goto d1
      // d0: athrow
      // d1: aload 0
      // d2: goto d6
      // d5: athrow
      // d6: invokevirtual x/oc668fce0dbf.ζ ()V
      // d9: return
   }

   @Override
   public void onDisable() {
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
      // 006: ifne 035
      // 009: invokevirtual x/oc668fce0dbf.Ü ()Z
      // 00c: ifeq 01e
      // 00f: goto 013
      // 012: athrow
      // 013: aload 0
      // 014: getfield x/oc668fce0dbf.ū Lx/oc11364ce42a;
      // 017: invokevirtual x/oc11364ce42a.Լ ()V
      // 01a: goto 01e
      // 01d: athrow
      // 01e: aload 0
      // 01f: getfield x/oc668fce0dbf.Ȉ Lx/oc41ddc58b4a;
      // 022: invokevirtual x/oc41ddc58b4a.Ď ()V
      // 025: aload 0
      // 026: iload 1
      // 027: ifne 040
      // 02a: getfield x/oc668fce0dbf.ӎ Lx/ocae1739aac7;
      // 02d: invokevirtual x/ocae1739aac7.ʲ ()V
      // 030: aload 0
      // 031: goto 035
      // 034: athrow
      // 035: invokevirtual x/oc668fce0dbf.ճ ()Z
      // 038: ifeq 063
      // 03b: aload 0
      // 03c: goto 040
      // 03f: athrow
      // 040: getfield x/oc668fce0dbf.Ѝ Lx/occ2f8dff8d8;
      // 043: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 046: iload 1
      // 047: ifne 054
      // 04a: ifeq 063
      // 04d: goto 051
      // 050: athrow
      // 051: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 054: iload 1
      // 055: ifne 060
      // 058: ifeq 063
      // 05b: goto 05f
      // 05e: athrow
      // 05f: bipush 1
      // 060: goto 064
      // 063: bipush 0
      // 064: istore 2
      // 065: iload 2
      // 066: iload 1
      // 067: ifne 098
      // 06a: ifeq 0a7
      // 06d: goto 071
      // 070: athrow
      // 071: aload 0
      // 072: getfield x/oc668fce0dbf.Ȝ Lx/ocff76b7be49;
      // 075: getstatic x/oc75d51ec7eb.d [F
      // 078: bipush 0
      // 079: faload
      // 07a: getstatic x/oc75d51ec7eb.d [F
      // 07d: bipush 1
      // 07e: faload
      // 07f: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 082: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 085: getfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 088: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 08b: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 08e: getfield net/minecraft/client/entity/EntityPlayerSP.rotationPitch F
      // 091: invokevirtual x/ocff76b7be49.ι (FFFF)Z
      // 094: goto 098
      // 097: athrow
      // 098: iload 1
      // 099: ifne 0a4
      // 09c: ifeq 0a7
      // 09f: goto 0a3
      // 0a2: athrow
      // 0a3: bipush 1
      // 0a4: goto 0a8
      // 0a7: bipush 0
      // 0a8: istore 3
      // 0a9: iload 1
      // 0aa: ifne 104
      // 0ad: iload 2
      // 0ae: ifne 0c1
      // 0b1: goto 0b5
      // 0b4: athrow
      // 0b5: aload 0
      // 0b6: getfield x/oc668fce0dbf.Ȝ Lx/ocff76b7be49;
      // 0b9: bipush 0
      // 0ba: invokevirtual x/ocff76b7be49.ĳ (Z)V
      // 0bd: goto 0c1
      // 0c0: athrow
      // 0c1: aload 0
      // 0c2: invokevirtual x/oc668fce0dbf.í ()V
      // 0c5: aload 0
      // 0c6: aconst_null
      // 0c7: putfield x/oc668fce0dbf.Ț Lx/oc29fb8ce47a;
      // 0ca: aload 0
      // 0cb: iload 1
      // 0cc: ifne 113
      // 0cf: aconst_null
      // 0d0: putfield x/oc668fce0dbf.Ջ Lx/oc412a041b25;
      // 0d3: aload 0
      // 0d4: invokevirtual x/oc668fce0dbf.ǐ ()V
      // 0d7: aload 0
      // 0d8: bipush 0
      // 0d9: putfield x/oc668fce0dbf.Ƅ Z
      // 0dc: aload 0
      // 0dd: invokevirtual x/oc668fce0dbf.Д ()V
      // 0e0: aload 0
      // 0e1: bipush 0
      // 0e2: putfield x/oc668fce0dbf.ԛ I
      // 0e5: aload 0
      // 0e6: invokevirtual x/oc668fce0dbf.ӌ ()V
      // 0e9: aload 0
      // 0ea: invokevirtual x/oc668fce0dbf.Ɏ ()V
      // 0ed: aload 0
      // 0ee: getfield x/oc668fce0dbf.Ќ Lx/ocbce5ea28a3;
      // 0f1: invokevirtual x/ocbce5ea28a3.ϔ ()V
      // 0f4: aload 0
      // 0f5: getfield x/oc668fce0dbf.ӱ Lx/oc3b42959d05;
      // 0f8: invokevirtual x/oc3b42959d05.ą ()V
      // 0fb: aload 0
      // 0fc: bipush 0
      // 0fd: invokevirtual x/oc668fce0dbf.ռ (Z)V
      // 100: goto 104
      // 103: athrow
      // 104: iload 3
      // 105: ifne 112
      // 108: getstatic x/oc668fce0dbf.ӧ Lx/oc7beea7ccff;
      // 10b: invokevirtual x/oc7beea7ccff.Ψ ()V
      // 10e: goto 112
      // 111: athrow
      // 112: aload 0
      // 113: getfield x/oc668fce0dbf.ʱ Lx/oc08992069b4;
      // 116: invokevirtual x/oc08992069b4.ʄ ()V
      // 119: invokestatic java/lang/System.currentTimeMillis ()J
      // 11c: lstore 4
      // 11e: aload 0
      // 11f: iload 1
      // 120: ifne 144
      // 123: invokevirtual x/oc668fce0dbf.ӿ ()I
      // 126: ifne 13f
      // 129: goto 12d
      // 12c: athrow
      // 12d: aload 0
      // 12e: getfield x/oc668fce0dbf.У Lx/oc8ef88da691;
      // 131: bipush 0
      // 132: lload 4
      // 134: invokevirtual x/oc8ef88da691.ΐ (ZJ)V
      // 137: iload 1
      // 138: ifeq 14d
      // 13b: goto 13f
      // 13e: athrow
      // 13f: aload 0
      // 140: goto 144
      // 143: athrow
      // 144: getfield x/oc668fce0dbf.У Lx/oc8ef88da691;
      // 147: bipush 0
      // 148: lload 4
      // 14a: invokevirtual x/oc8ef88da691.ɞ (ZJ)V
      // 14d: return
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
      // 000: aload 0
      // 001: invokevirtual x/oc668fce0dbf.ճ ()Z
      // 004: istore 2
      // 005: aload 0
      // 006: invokevirtual x/oc668fce0dbf.Ɯ ()Z
      // 009: istore 3
      // 00a: getstatic x/oc84f20a0bc5.ė I
      // 00d: aload 0
      // 00e: invokevirtual x/oc668fce0dbf.Ü ()Z
      // 011: istore 4
      // 013: istore 1
      // 014: aload 0
      // 015: getfield x/oc668fce0dbf.ƫ Lx/oca9cc61aada;
      // 018: iload 2
      // 019: iload 1
      // 01a: ifne 033
      // 01d: aload 0
      // 01e: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 021: aload 0
      // 022: getfield x/oc668fce0dbf.ʪ Lx/oca9cc61aada;
      // 025: iload 4
      // 027: ifne 036
      // 02a: goto 02e
      // 02d: athrow
      // 02e: bipush 1
      // 02f: goto 033
      // 032: athrow
      // 033: goto 037
      // 036: bipush 0
      // 037: aload 0
      // 038: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 03b: aload 0
      // 03c: getfield x/oc668fce0dbf.ϩ Lx/oca9cc61aada;
      // 03f: iload 3
      // 040: iload 1
      // 041: ifne 06f
      // 044: ifne 06e
      // 047: goto 04b
      // 04a: athrow
      // 04b: iload 2
      // 04c: iload 1
      // 04d: ifne 063
      // 050: goto 054
      // 053: athrow
      // 054: ifeq 072
      // 057: goto 05b
      // 05a: athrow
      // 05b: aload 0
      // 05c: invokevirtual x/oc668fce0dbf.T ()Z
      // 05f: goto 063
      // 062: athrow
      // 063: iload 1
      // 064: ifne 06f
      // 067: ifne 072
      // 06a: goto 06e
      // 06d: athrow
      // 06e: bipush 1
      // 06f: goto 073
      // 072: bipush 0
      // 073: aload 0
      // 074: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 077: aload 0
      // 078: getfield x/oc668fce0dbf.ɒ Lx/oca9cc61aada;
      // 07b: iload 3
      // 07c: iload 1
      // 07d: ifne 098
      // 080: aload 0
      // 081: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 084: aload 0
      // 085: getfield x/oc668fce0dbf.ӯ Lx/oca9cc61aada;
      // 088: iload 3
      // 089: ifeq 0a7
      // 08c: goto 090
      // 08f: athrow
      // 090: aload 0
      // 091: invokevirtual x/oc668fce0dbf.ϝ ()Z
      // 094: goto 098
      // 097: athrow
      // 098: iload 1
      // 099: ifne 0a4
      // 09c: ifeq 0a7
      // 09f: goto 0a3
      // 0a2: athrow
      // 0a3: bipush 1
      // 0a4: goto 0a8
      // 0a7: bipush 0
      // 0a8: aload 0
      // 0a9: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 0ac: aload 0
      // 0ad: getfield x/oc668fce0dbf.Ѝ Lx/occ2f8dff8d8;
      // 0b0: iload 2
      // 0b1: aload 0
      // 0b2: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 0b5: aload 0
      // 0b6: getfield x/oc668fce0dbf.Ś Lx/occ2f8dff8d8;
      // 0b9: aload 0
      // 0ba: iload 1
      // 0bb: ifne 0f4
      // 0be: invokevirtual x/oc668fce0dbf.ȷ ()Z
      // 0c1: aload 0
      // 0c2: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 0c5: aload 0
      // 0c6: getfield x/oc668fce0dbf.ҵ Lx/occ2f8dff8d8;
      // 0c9: aload 0
      // 0ca: invokevirtual x/oc668fce0dbf.ɣ ()Z
      // 0cd: aload 0
      // 0ce: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 0d1: aload 0
      // 0d2: getfield x/oc668fce0dbf.գ Lx/occ2f8dff8d8;
      // 0d5: iload 2
      // 0d6: aload 0
      // 0d7: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 0da: aload 0
      // 0db: getfield x/oc668fce0dbf.Ы Lx/occ2f8dff8d8;
      // 0de: iload 2
      // 0df: aload 0
      // 0e0: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 0e3: aload 0
      // 0e4: getfield x/oc668fce0dbf.ґ Lx/occ2f8dff8d8;
      // 0e7: iload 2
      // 0e8: ifeq 109
      // 0eb: goto 0ef
      // 0ee: athrow
      // 0ef: aload 0
      // 0f0: goto 0f4
      // 0f3: athrow
      // 0f4: getfield x/oc668fce0dbf.Ы Lx/occ2f8dff8d8;
      // 0f7: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 0fa: iload 1
      // 0fb: ifne 106
      // 0fe: ifeq 109
      // 101: goto 105
      // 104: athrow
      // 105: bipush 1
      // 106: goto 10a
      // 109: bipush 0
      // 10a: aload 0
      // 10b: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 10e: aload 0
      // 10f: getfield x/oc668fce0dbf.ʖ Lx/occ2f8dff8d8;
      // 112: iload 2
      // 113: iload 1
      // 114: ifne 129
      // 117: ifeq 138
      // 11a: goto 11e
      // 11d: athrow
      // 11e: aload 0
      // 11f: getfield x/oc668fce0dbf.Ы Lx/occ2f8dff8d8;
      // 122: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 125: goto 129
      // 128: athrow
      // 129: iload 1
      // 12a: ifne 135
      // 12d: ifeq 138
      // 130: goto 134
      // 133: athrow
      // 134: bipush 1
      // 135: goto 139
      // 138: bipush 0
      // 139: aload 0
      // 13a: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 13d: aload 0
      // 13e: getfield x/oc668fce0dbf.Ү Lx/ocf1568fef75;
      // 141: iload 2
      // 142: aload 0
      // 143: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 146: aload 0
      // 147: getfield x/oc668fce0dbf.f Lx/occ2f8dff8d8;
      // 14a: iload 2
      // 14b: iload 1
      // 14c: ifne 165
      // 14f: aload 0
      // 150: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 153: aload 0
      // 154: getfield x/oc668fce0dbf.Ư Lx/occ2f8dff8d8;
      // 157: iload 4
      // 159: ifne 168
      // 15c: goto 160
      // 15f: athrow
      // 160: bipush 1
      // 161: goto 165
      // 164: athrow
      // 165: goto 169
      // 168: bipush 0
      // 169: aload 0
      // 16a: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 16d: aload 0
      // 16e: getfield x/oc668fce0dbf.Ը Lx/occ2f8dff8d8;
      // 171: iload 4
      // 173: iload 1
      // 174: ifne 17f
      // 177: ifne 182
      // 17a: goto 17e
      // 17d: athrow
      // 17e: bipush 1
      // 17f: goto 183
      // 182: bipush 0
      // 183: aload 0
      // 184: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 187: aload 0
      // 188: getfield x/oc668fce0dbf.ϕ Lx/occ2f8dff8d8;
      // 18b: iload 4
      // 18d: iload 1
      // 18e: ifne 199
      // 191: ifne 19c
      // 194: goto 198
      // 197: athrow
      // 198: bipush 1
      // 199: goto 19d
      // 19c: bipush 0
      // 19d: aload 0
      // 19e: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 1a1: aload 0
      // 1a2: getfield x/oc668fce0dbf.ŏ Lx/occ2f8dff8d8;
      // 1a5: iload 4
      // 1a7: iload 1
      // 1a8: ifne 1b3
      // 1ab: ifne 1b6
      // 1ae: goto 1b2
      // 1b1: athrow
      // 1b2: bipush 1
      // 1b3: goto 1b7
      // 1b6: bipush 0
      // 1b7: aload 0
      // 1b8: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 1bb: aload 0
      // 1bc: getfield x/oc668fce0dbf.Ѷ Lx/oca9cc61aada;
      // 1bf: iload 4
      // 1c1: iload 1
      // 1c2: ifne 1d7
      // 1c5: ifne 1e6
      // 1c8: goto 1cc
      // 1cb: athrow
      // 1cc: aload 0
      // 1cd: getfield x/oc668fce0dbf.ŏ Lx/occ2f8dff8d8;
      // 1d0: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 1d3: goto 1d7
      // 1d6: athrow
      // 1d7: iload 1
      // 1d8: ifne 1e3
      // 1db: ifeq 1e6
      // 1de: goto 1e2
      // 1e1: athrow
      // 1e2: bipush 1
      // 1e3: goto 1e7
      // 1e6: bipush 0
      // 1e7: aload 0
      // 1e8: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 1eb: aload 0
      // 1ec: getfield x/oc668fce0dbf.ǔ Lx/occ2f8dff8d8;
      // 1ef: iload 2
      // 1f0: aload 0
      // 1f1: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 1f4: aload 0
      // 1f5: getfield x/oc668fce0dbf.ȍ Lx/oca9cc61aada;
      // 1f8: iload 2
      // 1f9: iload 1
      // 1fa: ifne 20f
      // 1fd: ifeq 21e
      // 200: goto 204
      // 203: athrow
      // 204: aload 0
      // 205: getfield x/oc668fce0dbf.ǔ Lx/occ2f8dff8d8;
      // 208: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 20b: goto 20f
      // 20e: athrow
      // 20f: iload 1
      // 210: ifne 21b
      // 213: ifeq 21e
      // 216: goto 21a
      // 219: athrow
      // 21a: bipush 1
      // 21b: goto 21f
      // 21e: bipush 0
      // 21f: aload 0
      // 220: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 223: aload 0
      // 224: getfield x/oc668fce0dbf.g Lx/ocf1568fef75;
      // 227: iload 2
      // 228: iload 1
      // 229: ifne 23e
      // 22c: ifeq 24d
      // 22f: goto 233
      // 232: athrow
      // 233: aload 0
      // 234: getfield x/oc668fce0dbf.ǔ Lx/occ2f8dff8d8;
      // 237: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 23a: goto 23e
      // 23d: athrow
      // 23e: iload 1
      // 23f: ifne 24a
      // 242: ifeq 24d
      // 245: goto 249
      // 248: athrow
      // 249: bipush 1
      // 24a: goto 24e
      // 24d: bipush 0
      // 24e: aload 0
      // 24f: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 252: aload 0
      // 253: getfield x/oc668fce0dbf.Е Lx/ocf1568fef75;
      // 256: iload 2
      // 257: iload 1
      // 258: ifne 26d
      // 25b: ifeq 27c
      // 25e: goto 262
      // 261: athrow
      // 262: aload 0
      // 263: getfield x/oc668fce0dbf.ǔ Lx/occ2f8dff8d8;
      // 266: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 269: goto 26d
      // 26c: athrow
      // 26d: iload 1
      // 26e: ifne 279
      // 271: ifeq 27c
      // 274: goto 278
      // 277: athrow
      // 278: bipush 1
      // 279: goto 27d
      // 27c: bipush 0
      // 27d: aload 0
      // 27e: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 281: aload 0
      // 282: getfield x/oc668fce0dbf.ʱ Lx/oc08992069b4;
      // 285: iload 4
      // 287: iload 1
      // 288: ifne 293
      // 28b: ifne 296
      // 28e: goto 292
      // 291: athrow
      // 292: bipush 1
      // 293: goto 297
      // 296: bipush 0
      // 297: invokevirtual x/oc08992069b4.ϙ (Z)V
      // 29a: aload 0
      // 29b: getfield x/oc668fce0dbf.â Lx/oca9cc61aada;
      // 29e: iload 4
      // 2a0: aload 0
      // 2a1: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 2a4: aload 0
      // 2a5: getfield x/oc668fce0dbf.ċ Lx/occ2f8dff8d8;
      // 2a8: iload 4
      // 2aa: aload 0
      // 2ab: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 2ae: aload 0
      // 2af: getfield x/oc668fce0dbf.Ɯ Lx/occ2f8dff8d8;
      // 2b2: iload 4
      // 2b4: aload 0
      // 2b5: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 2b8: bipush 0
      // 2b9: ifeq 2c7
      // 2bc: iinc 1 1
      // 2bf: iload 1
      // 2c0: putstatic x/oc84f20a0bc5.ė I
      // 2c3: goto 2c7
      // 2c6: athrow
      // 2c7: return
   }

   @Override
   public void z$1sehylui0i4ix(oca9cc61aada param1) {
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
      // 06: ifne 25
      // 09: aload 0
      // 0a: getfield x/oc668fce0dbf.Ʃ Lx/oca9cc61aada;
      // 0d: if_acmpne 20
      // 10: goto 14
      // 13: athrow
      // 14: aload 0
      // 15: invokevirtual x/oc668fce0dbf.Ѧ ()V
      // 18: iload 2
      // 19: ifeq 34
      // 1c: goto 20
      // 1f: athrow
      // 20: aload 1
      // 21: goto 25
      // 24: athrow
      // 25: aload 0
      // 26: getfield x/oc668fce0dbf.ƫ Lx/oca9cc61aada;
      // 29: if_acmpne 34
      // 2c: aload 0
      // 2d: invokevirtual x/oc668fce0dbf.ѝ ()V
      // 30: goto 34
      // 33: athrow
      // 34: return
   }

   @Override
   public void z$3tl278wzjcayb(N param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 2
      // 04: aload 1
      // 05: aload 0
      // 06: iload 2
      // 07: ifne 2e
      // 0a: getfield x/oc668fce0dbf.Ʃ Lx/oca9cc61aada;
      // 0d: if_acmpne 20
      // 10: goto 14
      // 13: athrow
      // 14: aload 0
      // 15: invokevirtual x/oc668fce0dbf.Ѧ ()V
      // 18: iload 2
      // 19: ifeq 54
      // 1c: goto 20
      // 1f: athrow
      // 20: aload 1
      // 21: iload 2
      // 22: ifne 45
      // 25: goto 29
      // 28: athrow
      // 29: aload 0
      // 2a: goto 2e
      // 2d: athrow
      // 2e: getfield x/oc668fce0dbf.ƫ Lx/oca9cc61aada;
      // 31: if_acmpne 40
      // 34: aload 0
      // 35: invokevirtual x/oc668fce0dbf.ѝ ()V
      // 38: iload 2
      // 39: ifeq 54
      // 3c: goto 40
      // 3f: athrow
      // 40: aload 1
      // 41: goto 45
      // 44: athrow
      // 45: aload 0
      // 46: getfield x/oc668fce0dbf.Ը Lx/occ2f8dff8d8;
      // 49: if_acmpne 54
      // 4c: aload 0
      // 4d: invokevirtual x/oc668fce0dbf.Ӟ ()V
      // 50: goto 54
      // 53: athrow
      // 54: return
   }

   private void Ѧ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: aload 0
      // 04: getfield x/oc668fce0dbf.ū Lx/oc11364ce42a;
      // 07: invokevirtual x/oc11364ce42a.Լ ()V
      // 0a: istore 1
      // 0b: aload 0
      // 0c: getfield x/oc668fce0dbf.ū Lx/oc11364ce42a;
      // 0f: invokevirtual x/oc11364ce42a.Ѥ ()V
      // 12: iload 1
      // 13: ifne 83
      // 16: aload 0
      // 17: invokevirtual x/oc668fce0dbf.í ()V
      // 1a: aload 0
      // 1b: getfield x/oc668fce0dbf.Ȝ Lx/ocff76b7be49;
      // 1e: bipush 0
      // 1f: invokevirtual x/ocff76b7be49.ĳ (Z)V
      // 22: aload 0
      // 23: bipush 1
      // 24: invokevirtual x/oc668fce0dbf.զ (Z)V
      // 27: aload 0
      // 28: invokevirtual x/oc668fce0dbf.ǐ ()V
      // 2b: aload 0
      // 2c: bipush 0
      // 2d: putfield x/oc668fce0dbf.ԛ I
      // 30: aload 0
      // 31: bipush 0
      // 32: putfield x/oc668fce0dbf.Ƅ Z
      // 35: aload 0
      // 36: getfield x/oc668fce0dbf.Ќ Lx/ocbce5ea28a3;
      // 39: invokevirtual x/ocbce5ea28a3.ϔ ()V
      // 3c: aload 0
      // 3d: getfield x/oc668fce0dbf.ӱ Lx/oc3b42959d05;
      // 40: invokevirtual x/oc3b42959d05.ą ()V
      // 43: aload 0
      // 44: bipush 0
      // 45: invokevirtual x/oc668fce0dbf.ռ (Z)V
      // 48: aload 0
      // 49: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 4c: ifeq 7f
      // 4f: goto 53
      // 52: athrow
      // 53: getstatic x/oc668fce0dbf.ӧ Lx/oc7beea7ccff;
      // 56: invokevirtual x/oc7beea7ccff.Ψ ()V
      // 59: aload 0
      // 5a: invokevirtual x/oc668fce0dbf.ʢ ()V
      // 5d: aload 0
      // 5e: iload 1
      // 5f: ifne 80
      // 62: goto 66
      // 65: athrow
      // 66: invokevirtual x/oc668fce0dbf.ƌ ()V
      // 69: aload 0
      // 6a: invokevirtual x/oc668fce0dbf.Ü ()Z
      // 6d: ifeq 7f
      // 70: goto 74
      // 73: athrow
      // 74: aload 0
      // 75: getfield x/oc668fce0dbf.ū Lx/oc11364ce42a;
      // 78: invokevirtual x/oc11364ce42a.Ȓ ()V
      // 7b: goto 7f
      // 7e: athrow
      // 7f: aload 0
      // 80: invokevirtual x/oc668fce0dbf.z$2u87utkr1isxg ()V
      // 83: return
   }

   @Override
   public void guiButtonToggled(occ2f8dff8d8 param1) {
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
      // 05: aload 0
      // 06: iload 2
      // 07: ifne 39
      // 0a: getfield x/oc668fce0dbf.Ä Lx/occ2f8dff8d8;
      // 0d: if_acmpne 2f
      // 10: goto 14
      // 13: athrow
      // 14: aload 0
      // 15: iload 2
      // 16: ifne 2c
      // 19: goto 1d
      // 1c: athrow
      // 1d: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 20: ifeq 2f
      // 23: goto 27
      // 26: athrow
      // 27: aload 0
      // 28: goto 2c
      // 2b: athrow
      // 2c: invokevirtual x/oc668fce0dbf.Ͼ ()V
      // 2f: aload 1
      // 30: iload 2
      // 31: ifne 76
      // 34: aload 0
      // 35: goto 39
      // 38: athrow
      // 39: getfield x/oc668fce0dbf.Ѝ Lx/occ2f8dff8d8;
      // 3c: if_acmpne 75
      // 3f: aload 0
      // 40: iload 2
      // 41: ifne 57
      // 44: goto 48
      // 47: athrow
      // 48: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 4b: ifeq 75
      // 4e: goto 52
      // 51: athrow
      // 52: aload 0
      // 53: goto 57
      // 56: athrow
      // 57: iload 2
      // 58: ifne 72
      // 5b: invokevirtual x/oc668fce0dbf.ճ ()Z
      // 5e: ifeq 75
      // 61: goto 65
      // 64: athrow
      // 65: aload 0
      // 66: getfield x/oc668fce0dbf.Ȝ Lx/ocff76b7be49;
      // 69: bipush 0
      // 6a: invokevirtual x/ocff76b7be49.ĳ (Z)V
      // 6d: aload 0
      // 6e: goto 72
      // 71: athrow
      // 72: invokevirtual x/oc668fce0dbf.ƌ ()V
      // 75: aload 1
      // 76: aload 0
      // 77: getfield x/oc668fce0dbf.Ը Lx/occ2f8dff8d8;
      // 7a: if_acmpne 85
      // 7d: aload 0
      // 7e: invokevirtual x/oc668fce0dbf.Ӟ ()V
      // 81: goto 85
      // 84: athrow
      // 85: aload 0
      // 86: invokevirtual x/oc668fce0dbf.z$2u87utkr1isxg ()V
      // 89: aload 0
      // 8a: aload 1
      // 8b: invokespecial x/oc69da1aa7f5.guiButtonToggled (Lx/occ2f8dff8d8;)V
      // 8e: return
   }

   private void ѝ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: aload 0
      // 04: getfield x/oc668fce0dbf.Ȝ Lx/ocff76b7be49;
      // 07: bipush 0
      // 08: invokevirtual x/ocff76b7be49.ĳ (Z)V
      // 0b: istore 1
      // 0c: aload 0
      // 0d: iload 1
      // 0e: ifne 4a
      // 11: bipush 1
      // 12: invokevirtual x/oc668fce0dbf.զ (Z)V
      // 15: aload 0
      // 16: invokevirtual x/oc668fce0dbf.ʢ ()V
      // 19: aload 0
      // 1a: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 1d: ifeq 49
      // 20: goto 24
      // 23: athrow
      // 24: aload 0
      // 25: iload 1
      // 26: ifne 4a
      // 29: goto 2d
      // 2c: athrow
      // 2d: invokevirtual x/oc668fce0dbf.ճ ()Z
      // 30: ifeq 49
      // 33: goto 37
      // 36: athrow
      // 37: getstatic x/oc668fce0dbf.ӧ Lx/oc7beea7ccff;
      // 3a: invokevirtual x/oc7beea7ccff.Ψ ()V
      // 3d: aload 0
      // 3e: invokevirtual x/oc668fce0dbf.ʢ ()V
      // 41: aload 0
      // 42: invokevirtual x/oc668fce0dbf.ƌ ()V
      // 45: goto 49
      // 48: athrow
      // 49: aload 0
      // 4a: invokevirtual x/oc668fce0dbf.z$2u87utkr1isxg ()V
      // 4d: return
   }

   @oc66fa4f2195
   public void ɮ(oc86de9e2892 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: aload 0
      // 004: bipush 0
      // 005: putfield x/oc668fce0dbf.J Z
      // 008: istore 2
      // 009: aload 0
      // 00a: iload 2
      // 00b: ifne 029
      // 00e: aconst_null
      // 00f: putfield x/oc668fce0dbf.Ъ Lx/oc412a041b25;
      // 012: aload 0
      // 013: bipush 0
      // 014: putfield x/oc668fce0dbf.Ƅ Z
      // 017: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 01a: ifne 028
      // 01d: goto 021
      // 020: athrow
      // 021: aload 0
      // 022: bipush 0
      // 023: putfield x/oc668fce0dbf.ɛ I
      // 026: return
      // 027: athrow
      // 028: aload 0
      // 029: iload 2
      // 02a: ifne 04c
      // 02d: invokevirtual x/oc668fce0dbf.Ü ()Z
      // 030: ifeq 04b
      // 033: goto 037
      // 036: athrow
      // 037: aload 0
      // 038: aconst_null
      // 039: putfield x/oc668fce0dbf.Ț Lx/oc29fb8ce47a;
      // 03c: aload 0
      // 03d: aconst_null
      // 03e: putfield x/oc668fce0dbf.Ջ Lx/oc412a041b25;
      // 041: aload 0
      // 042: getfield x/oc668fce0dbf.ū Lx/oc11364ce42a;
      // 045: aload 1
      // 046: invokevirtual x/oc11364ce42a.Š (Lx/oc86de9e2892;)V
      // 049: return
      // 04a: athrow
      // 04b: aload 0
      // 04c: iload 2
      // 04d: ifne 065
      // 050: aload 1
      // 051: invokevirtual x/oc668fce0dbf.Ǎ (Lx/oc86de9e2892;)Z
      // 054: ifeq 06a
      // 057: goto 05b
      // 05a: athrow
      // 05b: aload 0
      // 05c: aconst_null
      // 05d: putfield x/oc668fce0dbf.Ț Lx/oc29fb8ce47a;
      // 060: aload 0
      // 061: goto 065
      // 064: athrow
      // 065: aconst_null
      // 066: putfield x/oc668fce0dbf.Ջ Lx/oc412a041b25;
      // 069: return
      // 06a: getstatic x/oc9755810e45.ɓ Lx/oc2c637ab2aa;
      // 06d: astore 3
      // 06e: aload 0
      // 06f: iload 2
      // 070: ifne 0dc
      // 073: getfield x/oc668fce0dbf.ɛ I
      // 076: ifgt 0db
      // 079: goto 07d
      // 07c: athrow
      // 07d: aload 3
      // 07e: iload 2
      // 07f: ifne 08e
      // 082: goto 086
      // 085: athrow
      // 086: ifnull 0db
      // 089: goto 08d
      // 08c: athrow
      // 08d: aload 3
      // 08e: invokevirtual x/oc2c637ab2aa.І ()Z
      // 091: iload 2
      // 092: ifne 0e7
      // 095: ifeq 0db
      // 098: goto 09c
      // 09b: athrow
      // 09c: aload 0
      // 09d: iload 2
      // 09e: ifne 0dc
      // 0a1: goto 0a5
      // 0a4: athrow
      // 0a5: getfield x/oc668fce0dbf.ԛ I
      // 0a8: ifgt 0db
      // 0ab: goto 0af
      // 0ae: athrow
      // 0af: aload 0
      // 0b0: iload 2
      // 0b1: ifne 0dc
      // 0b4: goto 0b8
      // 0b7: athrow
      // 0b8: invokevirtual x/oc668fce0dbf.ȃ ()Z
      // 0bb: ifne 0db
      // 0be: goto 0c2
      // 0c1: athrow
      // 0c2: aload 0
      // 0c3: bipush 1
      // 0c4: putfield x/oc668fce0dbf.Ƅ Z
      // 0c7: aload 0
      // 0c8: aconst_null
      // 0c9: putfield x/oc668fce0dbf.Ț Lx/oc29fb8ce47a;
      // 0cc: aload 0
      // 0cd: aconst_null
      // 0ce: putfield x/oc668fce0dbf.Ջ Lx/oc412a041b25;
      // 0d1: aload 0
      // 0d2: getfield x/oc668fce0dbf.ӱ Lx/oc3b42959d05;
      // 0d5: bipush 0
      // 0d6: invokevirtual x/oc3b42959d05.М (Z)V
      // 0d9: return
      // 0da: athrow
      // 0db: aload 0
      // 0dc: iload 2
      // 0dd: ifne 1d1
      // 0e0: invokevirtual x/oc668fce0dbf.ȷ ()Z
      // 0e3: goto 0e7
      // 0e6: athrow
      // 0e7: ifeq 1d0
      // 0ea: aload 0
      // 0eb: aconst_null
      // 0ec: putfield x/oc668fce0dbf.Ț Lx/oc29fb8ce47a;
      // 0ef: aload 0
      // 0f0: aconst_null
      // 0f1: putfield x/oc668fce0dbf.Ջ Lx/oc412a041b25;
      // 0f4: getstatic x/oc668fce0dbf.ӧ Lx/oc7beea7ccff;
      // 0f7: aload 0
      // 0f8: getfield x/oc668fce0dbf.Ќ Lx/ocbce5ea28a3;
      // 0fb: dup
      // 0fc: invokestatic java/util/Objects.requireNonNull (Ljava/lang/Object;)Ljava/lang/Object;
      // 0ff: pop
      // 100: invokedynamic accept (Lx/ocbce5ea28a3;)Ljava/util/function/Consumer; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)V, x/ocbce5ea28a3.ԑ (Lx/oc7ebeda7e63;)V, (Lx/oc7ebeda7e63;)V ]
      // 105: invokevirtual x/oc7beea7ccff.Ø (Ljava/util/function/Consumer;)Lx/oc29fb8ce47a;
      // 108: astore 4
      // 10a: aload 0
      // 10b: aload 4
      // 10d: invokevirtual x/oc29fb8ce47a.վ ()F
      // 110: getstatic x/oc75d51ec7eb.d [F
      // 113: bipush 1
      // 114: faload
      // 115: invokestatic x/oc75d51ec7eb.Ӌ ()F
      // 118: invokevirtual x/oc668fce0dbf.б (FFF)F
      // 11b: fstore 5
      // 11d: aload 4
      // 11f: invokevirtual x/oc29fb8ce47a.Ǯ ()Z
      // 122: iload 2
      // 123: ifne 157
      // 126: ifeq 156
      // 129: goto 12d
      // 12c: athrow
      // 12d: aload 1
      // 12e: aload 0
      // 12f: ldc_w 288166484
      // 132: ldc_w 288166816
      // 135: ixor
      // 136: aload 4
      // 138: invokevirtual x/oc29fb8ce47a.Ċ ()F
      // 13b: invokestatic java/lang/Float.valueOf (F)Ljava/lang/Float;
      // 13e: fload 5
      // 140: invokestatic java/lang/Float.valueOf (F)Ljava/lang/Float;
      // 143: bipush 1
      // 144: invokevirtual x/oc86de9e2892.Ǎ (Ljava/lang/Object;ILjava/lang/Float;Ljava/lang/Float;Z)Z
      // 147: iload 2
      // 148: ifne 157
      // 14b: goto 14f
      // 14e: athrow
      // 14f: ifeq 15a
      // 152: goto 156
      // 155: athrow
      // 156: bipush 1
      // 157: goto 15b
      // 15a: bipush 0
      // 15b: istore 6
      // 15d: aload 0
      // 15e: getfield x/oc668fce0dbf.Ќ Lx/ocbce5ea28a3;
      // 161: aload 4
      // 163: invokevirtual x/oc29fb8ce47a.Ċ ()F
      // 166: fload 5
      // 168: aload 4
      // 16a: invokevirtual x/oc29fb8ce47a.Ǯ ()Z
      // 16d: iload 2
      // 16e: ifne 17a
      // 171: ifeq 189
      // 174: goto 178
      // 177: athrow
      // 178: iload 6
      // 17a: iload 2
      // 17b: ifne 186
      // 17e: ifeq 189
      // 181: goto 185
      // 184: athrow
      // 185: bipush 1
      // 186: goto 18a
      // 189: bipush 0
      // 18a: invokevirtual x/ocbce5ea28a3.ɓ (FFZ)V
      // 18d: aload 4
      // 18f: invokevirtual x/oc29fb8ce47a.Ǯ ()Z
      // 192: iload 2
      // 193: ifne 19f
      // 196: ifeq 1cf
      // 199: goto 19d
      // 19c: athrow
      // 19d: iload 6
      // 19f: iload 2
      // 1a0: ifne 1c7
      // 1a3: ifeq 1cf
      // 1a6: goto 1aa
      // 1a9: athrow
      // 1aa: aload 1
      // 1ab: iload 2
      // 1ac: ifne 1cb
      // 1af: goto 1b3
      // 1b2: athrow
      // 1b3: ldc_w 95.0
      // 1b6: invokevirtual x/oc86de9e2892.ɱ (F)V
      // 1b9: fload 5
      // 1bb: aload 4
      // 1bd: invokevirtual x/oc29fb8ce47a.վ ()F
      // 1c0: invokestatic java/lang/Float.compare (FF)I
      // 1c3: goto 1c7
      // 1c6: athrow
      // 1c7: ifeq 1cf
      // 1ca: aload 1
      // 1cb: bipush 1
      // 1cc: invokevirtual x/oc86de9e2892.ʐ (Z)V
      // 1cf: return
      // 1d0: aload 0
      // 1d1: iload 2
      // 1d2: ifne 252
      // 1d5: invokevirtual x/oc668fce0dbf.ɣ ()Z
      // 1d8: ifeq 24d
      // 1db: goto 1df
      // 1de: athrow
      // 1df: aload 0
      // 1e0: aconst_null
      // 1e1: putfield x/oc668fce0dbf.Ț Lx/oc29fb8ce47a;
      // 1e4: iload 2
      // 1e5: aload 0
      // 1e6: aconst_null
      // 1e7: putfield x/oc668fce0dbf.Ջ Lx/oc412a041b25;
      // 1ea: aload 0
      // 1eb: getfield x/oc668fce0dbf.ӱ Lx/oc3b42959d05;
      // 1ee: getstatic x/oc75d51ec7eb.d [F
      // 1f1: bipush 0
      // 1f2: faload
      // 1f3: getstatic x/oc75d51ec7eb.d [F
      // 1f6: bipush 1
      // 1f7: faload
      // 1f8: invokevirtual x/oc3b42959d05.Ə (FF)Lx/oc47c2cd4bd2;
      // 1fb: astore 4
      // 1fd: ifne 215
      // 200: aload 4
      // 202: ifnonnull 216
      // 205: goto 209
      // 208: athrow
      // 209: aload 0
      // 20a: getfield x/oc668fce0dbf.ӱ Lx/oc3b42959d05;
      // 20d: bipush 0
      // 20e: invokevirtual x/oc3b42959d05.М (Z)V
      // 211: goto 215
      // 214: athrow
      // 215: return
      // 216: aload 1
      // 217: aload 0
      // 218: ldc_w 288166484
      // 21b: ldc_w 288166816
      // 21e: ixor
      // 21f: aload 4
      // 221: getfield x/oc47c2cd4bd2.ϳ F
      // 224: invokestatic java/lang/Float.valueOf (F)Ljava/lang/Float;
      // 227: aload 4
      // 229: getfield x/oc47c2cd4bd2.Μ F
      // 22c: invokestatic java/lang/Float.valueOf (F)Ljava/lang/Float;
      // 22f: bipush 1
      // 230: invokevirtual x/oc86de9e2892.Ǎ (Ljava/lang/Object;ILjava/lang/Float;Ljava/lang/Float;Z)Z
      // 233: istore 5
      // 235: aload 0
      // 236: getfield x/oc668fce0dbf.ӱ Lx/oc3b42959d05;
      // 239: iload 5
      // 23b: invokevirtual x/oc3b42959d05.М (Z)V
      // 23e: iload 5
      // 240: ifeq 24c
      // 243: aload 1
      // 244: bipush 1
      // 245: invokevirtual x/oc86de9e2892.ʐ (Z)V
      // 248: goto 24c
      // 24b: athrow
      // 24c: return
      // 24d: aload 0
      // 24e: invokevirtual x/oc668fce0dbf.Ã ()V
      // 251: aload 0
      // 252: invokevirtual x/oc668fce0dbf.ш ()Lx/oc7204ffe95d;
      // 255: astore 4
      // 257: aload 0
      // 258: getfield x/oc668fce0dbf.Ȝ Lx/ocff76b7be49;
      // 25b: aload 4
      // 25d: getfield x/oc7204ffe95d.Ȏ F
      // 260: aload 4
      // 262: getfield x/oc7204ffe95d.ƺ F
      // 265: aload 0
      // 266: aload 4
      // 268: invokevirtual x/oc668fce0dbf.И (Lx/oc7204ffe95d;)Z
      // 26b: invokevirtual x/ocff76b7be49.ԏ (FFZ)V
      // 26e: getstatic x/oc668fce0dbf.ӧ Lx/oc7beea7ccff;
      // 271: aload 4
      // 273: dup
      // 274: invokestatic java/util/Objects.requireNonNull (Ljava/lang/Object;)Ljava/lang/Object;
      // 277: pop
      // 278: invokedynamic accept (Lx/oc7204ffe95d;)Ljava/util/function/Consumer; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)V, x/oc7204ffe95d.Ԣ (Lx/oc7ebeda7e63;)V, (Lx/oc7ebeda7e63;)V ]
      // 27d: invokevirtual x/oc7beea7ccff.Ø (Ljava/util/function/Consumer;)Lx/oc29fb8ce47a;
      // 280: astore 5
      // 282: aload 5
      // 284: invokevirtual x/oc29fb8ce47a.Ċ ()F
      // 287: fstore 6
      // 289: aload 5
      // 28b: invokevirtual x/oc29fb8ce47a.վ ()F
      // 28e: fstore 7
      // 290: aload 4
      // 292: iload 2
      // 293: ifne 2a6
      // 296: getfield x/oc7204ffe95d.ñ Lx/oc412a041b25;
      // 299: ifnull 2cf
      // 29c: goto 2a0
      // 29f: athrow
      // 2a0: aload 4
      // 2a2: goto 2a6
      // 2a5: athrow
      // 2a6: getfield x/oc7204ffe95d.Ӆ Z
      // 2a9: iload 2
      // 2aa: ifne 2d0
      // 2ad: ifeq 2cf
      // 2b0: goto 2b4
      // 2b3: athrow
      // 2b4: aload 0
      // 2b5: aload 4
      // 2b7: getfield x/oc7204ffe95d.ñ Lx/oc412a041b25;
      // 2ba: fload 6
      // 2bc: fload 7
      // 2be: invokevirtual x/oc668fce0dbf.ȋ (Lx/oc412a041b25;FF)[F
      // 2c1: astore 8
      // 2c3: aload 8
      // 2c5: bipush 0
      // 2c6: faload
      // 2c7: fstore 6
      // 2c9: aload 8
      // 2cb: bipush 1
      // 2cc: faload
      // 2cd: fstore 7
      // 2cf: bipush 0
      // 2d0: istore 8
      // 2d2: aload 0
      // 2d3: fload 7
      // 2d5: getstatic x/oc75d51ec7eb.d [F
      // 2d8: bipush 1
      // 2d9: faload
      // 2da: invokestatic x/oc75d51ec7eb.Ӌ ()F
      // 2dd: invokevirtual x/oc668fce0dbf.б (FFF)F
      // 2e0: fstore 9
      // 2e2: fload 9
      // 2e4: fload 7
      // 2e6: invokestatic java/lang/Float.compare (FF)I
      // 2e9: iload 2
      // 2ea: ifne 309
      // 2ed: ifeq 305
      // 2f0: goto 2f4
      // 2f3: athrow
      // 2f4: fload 9
      // 2f6: fstore 7
      // 2f8: bipush 1
      // 2f9: istore 8
      // 2fb: getstatic x/oc668fce0dbf.ӧ Lx/oc7beea7ccff;
      // 2fe: fload 6
      // 300: fload 7
      // 302: invokevirtual x/oc7beea7ccff.т (FF)V
      // 305: aload 0
      // 306: getfield x/oc668fce0dbf.Ʉ I
      // 309: iload 2
      // 30a: ifne 36c
      // 30d: ifle 367
      // 310: goto 314
      // 313: athrow
      // 314: aload 0
      // 315: getstatic x/oc75d51ec7eb.d [F
      // 318: bipush 1
      // 319: faload
      // 31a: fload 6
      // 31c: fload 7
      // 31e: aload 4
      // 320: iload 2
      // 321: ifne 339
      // 324: goto 328
      // 327: athrow
      // 328: getfield x/oc7204ffe95d.ñ Lx/oc412a041b25;
      // 32b: ifnonnull 337
      // 32e: goto 332
      // 331: athrow
      // 332: aconst_null
      // 333: goto 33f
      // 336: athrow
      // 337: aload 4
      // 339: getfield x/oc7204ffe95d.ñ Lx/oc412a041b25;
      // 33c: getfield x/oc412a041b25.Ͳ Lx/oc84f20a0bc5;
      // 33f: invokevirtual x/oc668fce0dbf.ѷ (FFFLx/oc84f20a0bc5;)F
      // 342: fstore 10
      // 344: fload 10
      // 346: fload 7
      // 348: invokestatic java/lang/Float.compare (FF)I
      // 34b: iload 2
      // 34c: ifne 36c
      // 34f: ifeq 367
      // 352: goto 356
      // 355: athrow
      // 356: fload 10
      // 358: fstore 7
      // 35a: bipush 1
      // 35b: istore 8
      // 35d: getstatic x/oc668fce0dbf.ӧ Lx/oc7beea7ccff;
      // 360: fload 6
      // 362: fload 7
      // 364: invokevirtual x/oc7beea7ccff.т (FF)V
      // 367: aload 5
      // 369: invokevirtual x/oc29fb8ce47a.Ǯ ()Z
      // 36c: iload 2
      // 36d: ifne 395
      // 370: ifne 394
      // 373: goto 377
      // 376: athrow
      // 377: aload 4
      // 379: getfield x/oc7204ffe95d.ñ Lx/oc412a041b25;
      // 37c: ifnonnull 394
      // 37f: goto 383
      // 382: athrow
      // 383: iload 8
      // 385: iload 2
      // 386: ifne 395
      // 389: goto 38d
      // 38c: athrow
      // 38d: ifeq 398
      // 390: goto 394
      // 393: athrow
      // 394: bipush 1
      // 395: goto 399
      // 398: bipush 0
      // 399: istore 10
      // 39b: iload 10
      // 39d: iload 2
      // 39e: ifne 3cf
      // 3a1: ifeq 3ce
      // 3a4: goto 3a8
      // 3a7: athrow
      // 3a8: aload 1
      // 3a9: aload 0
      // 3aa: ldc_w 288166484
      // 3ad: ldc_w 288166816
      // 3b0: ixor
      // 3b1: fload 6
      // 3b3: invokestatic java/lang/Float.valueOf (F)Ljava/lang/Float;
      // 3b6: fload 7
      // 3b8: invokestatic java/lang/Float.valueOf (F)Ljava/lang/Float;
      // 3bb: bipush 1
      // 3bc: invokevirtual x/oc86de9e2892.Ǎ (Ljava/lang/Object;ILjava/lang/Float;Ljava/lang/Float;Z)Z
      // 3bf: iload 2
      // 3c0: ifne 3cf
      // 3c3: goto 3c7
      // 3c6: athrow
      // 3c7: ifeq 3d2
      // 3ca: goto 3ce
      // 3cd: athrow
      // 3ce: bipush 1
      // 3cf: goto 3d3
      // 3d2: bipush 0
      // 3d3: istore 11
      // 3d5: iload 2
      // 3d6: ifne 3f4
      // 3d9: iload 11
      // 3db: ifeq 402
      // 3de: goto 3e2
      // 3e1: athrow
      // 3e2: aload 1
      // 3e3: iload 2
      // 3e4: ifne 3fe
      // 3e7: goto 3eb
      // 3ea: athrow
      // 3eb: ldc 149.0
      // 3ed: invokevirtual x/oc86de9e2892.ɱ (F)V
      // 3f0: goto 3f4
      // 3f3: athrow
      // 3f4: iload 8
      // 3f6: ifeq 402
      // 3f9: aload 1
      // 3fa: goto 3fe
      // 3fd: athrow
      // 3fe: bipush 1
      // 3ff: invokevirtual x/oc86de9e2892.ʐ (Z)V
      // 402: aload 0
      // 403: iload 11
      // 405: ifeq 40e
      // 408: aload 5
      // 40a: goto 40f
      // 40d: athrow
      // 40e: aconst_null
      // 40f: putfield x/oc668fce0dbf.Ț Lx/oc29fb8ce47a;
      // 412: aload 0
      // 413: iload 11
      // 415: iload 2
      // 416: ifne 431
      // 419: ifeq 43c
      // 41c: goto 420
      // 41f: athrow
      // 420: aload 4
      // 422: iload 2
      // 423: ifne 436
      // 426: goto 42a
      // 429: athrow
      // 42a: getfield x/oc7204ffe95d.Ӆ Z
      // 42d: goto 431
      // 430: athrow
      // 431: ifeq 43c
      // 434: aload 4
      // 436: getfield x/oc7204ffe95d.ñ Lx/oc412a041b25;
      // 439: goto 43d
      // 43c: aconst_null
      // 43d: putfield x/oc668fce0dbf.Ջ Lx/oc412a041b25;
      // 440: return
   }

   @oc66fa4f2195
   public void ĩ(oc746a23b244 param1) {
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
      // 05: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 08: iload 2
      // 09: ifne 16
      // 0c: ifeq 4f
      // 0f: goto 13
      // 12: athrow
      // 13: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 16: iload 2
      // 17: ifne 31
      // 1a: ifeq 4f
      // 1d: goto 21
      // 20: athrow
      // 21: aload 0
      // 22: iload 2
      // 23: ifne 48
      // 26: goto 2a
      // 29: athrow
      // 2a: invokevirtual x/oc668fce0dbf.Ü ()Z
      // 2d: goto 31
      // 30: athrow
      // 31: ifeq 43
      // 34: aload 0
      // 35: getfield x/oc668fce0dbf.ū Lx/oc11364ce42a;
      // 38: invokevirtual x/oc11364ce42a.Ȗ ()V
      // 3b: iload 2
      // 3c: ifeq 4f
      // 3f: goto 43
      // 42: athrow
      // 43: aload 0
      // 44: goto 48
      // 47: athrow
      // 48: getfield x/oc668fce0dbf.ʱ Lx/oc08992069b4;
      // 4b: aload 1
      // 4c: invokevirtual x/oc08992069b4.ä (Lx/oc746a23b244;)V
      // 4f: return
   }

   private void ӣ(ocf923d5a814 param1) {
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
      // 00b: if_acmpne 020
      // 00e: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 011: iload 2
      // 012: ifne 025
      // 015: goto 019
      // 018: athrow
      // 019: ifne 021
      // 01c: goto 020
      // 01f: athrow
      // 020: return
      // 021: aload 0
      // 022: invokevirtual x/oc668fce0dbf.Ü ()Z
      // 025: iload 2
      // 026: ifne 045
      // 029: ifeq 075
      // 02c: goto 030
      // 02f: athrow
      // 030: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 033: iload 2
      // 034: ifne 04b
      // 037: goto 03b
      // 03a: athrow
      // 03b: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 03e: getfield net/minecraft/client/settings/GameSettings.showDebugInfo Z
      // 041: goto 045
      // 044: athrow
      // 045: ifne 074
      // 048: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 04b: iload 2
      // 04c: ifne 060
      // 04f: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 052: ifnull 069
      // 055: goto 059
      // 058: athrow
      // 059: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 05c: goto 060
      // 05f: athrow
      // 060: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 063: instanceof net/minecraft/client/gui/GuiChat
      // 066: ifeq 074
      // 069: aload 0
      // 06a: getfield x/oc668fce0dbf.ū Lx/oc11364ce42a;
      // 06d: invokevirtual x/oc11364ce42a.ǿ ()V
      // 070: goto 074
      // 073: athrow
      // 074: return
      // 075: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 078: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 07b: ifnull 080
      // 07e: return
      // 07f: athrow
      // 080: invokestatic java/lang/System.currentTimeMillis ()J
      // 083: lstore 3
      // 084: aload 0
      // 085: iload 2
      // 086: ifne 098
      // 089: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 08c: ifeq 0ad
      // 08f: goto 093
      // 092: athrow
      // 093: aload 0
      // 094: goto 098
      // 097: athrow
      // 098: getfield x/oc668fce0dbf.ŏ Lx/occ2f8dff8d8;
      // 09b: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 09e: iload 2
      // 09f: ifne 0aa
      // 0a2: ifeq 0ad
      // 0a5: goto 0a9
      // 0a8: athrow
      // 0a9: bipush 1
      // 0aa: goto 0ae
      // 0ad: bipush 0
      // 0ae: istore 5
      // 0b0: iload 2
      // 0b1: aload 0
      // 0b2: invokevirtual x/oc668fce0dbf.ӿ ()I
      // 0b5: istore 6
      // 0b7: ifne 0d1
      // 0ba: iload 6
      // 0bc: ifne 0d5
      // 0bf: goto 0c3
      // 0c2: athrow
      // 0c3: aload 0
      // 0c4: getfield x/oc668fce0dbf.У Lx/oc8ef88da691;
      // 0c7: iload 5
      // 0c9: lload 3
      // 0ca: invokevirtual x/oc8ef88da691.ΐ (ZJ)V
      // 0cd: goto 0d1
      // 0d0: athrow
      // 0d1: iload 2
      // 0d2: ifeq 0e3
      // 0d5: aload 0
      // 0d6: getfield x/oc668fce0dbf.У Lx/oc8ef88da691;
      // 0d9: iload 5
      // 0db: lload 3
      // 0dc: invokevirtual x/oc8ef88da691.ɞ (ZJ)V
      // 0df: goto 0e3
      // 0e2: athrow
      // 0e3: iload 5
      // 0e5: iload 2
      // 0e6: ifne 11b
      // 0e9: ifne 119
      // 0ec: goto 0f0
      // 0ef: athrow
      // 0f0: iload 6
      // 0f2: iload 2
      // 0f3: ifne 10d
      // 0f6: goto 0fa
      // 0f9: athrow
      // 0fa: ifeq 118
      // 0fd: goto 101
      // 100: athrow
      // 101: aload 0
      // 102: getfield x/oc668fce0dbf.У Lx/oc8ef88da691;
      // 105: lload 3
      // 106: invokevirtual x/oc8ef88da691.ń (J)Z
      // 109: goto 10d
      // 10c: athrow
      // 10d: iload 2
      // 10e: ifne 11b
      // 111: ifeq 119
      // 114: goto 118
      // 117: athrow
      // 118: return
      // 119: iload 6
      // 11b: ifne 123
      // 11e: fconst_1
      // 11f: goto 12c
      // 122: athrow
      // 123: aload 0
      // 124: getfield x/oc668fce0dbf.У Lx/oc8ef88da691;
      // 127: lload 3
      // 128: invokevirtual x/oc8ef88da691.ʡ (J)D
      // 12b: d2f
      // 12c: fstore 7
      // 12e: fload 7
      // 130: fconst_0
      // 131: fcmpg
      // 132: iload 2
      // 133: ifne 14d
      // 136: ifgt 13e
      // 139: goto 13d
      // 13c: athrow
      // 13d: return
      // 13e: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 141: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 144: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 147: getfield net/minecraft/entity/player/InventoryPlayer.mainInventory [Lnet/minecraft/item/ItemStack;
      // 14a: invokestatic x/oc668fce0dbf.Љ ([Lnet/minecraft/item/ItemStack;)I
      // 14d: istore 8
      // 14f: iload 8
      // 151: iload 2
      // 152: ifne 16c
      // 155: ldc_w -387884454
      // 158: ldc_w -387884449
      // 15b: ixor
      // 15c: if_icmpgt 16a
      // 15f: goto 163
      // 162: athrow
      // 163: ldc_w "§c"
      // 166: goto 19b
      // 169: athrow
      // 16a: iload 8
      // 16c: iload 2
      // 16d: ifne 187
      // 170: ldc_w -387884464
      // 173: ldc_w -387884449
      // 176: ixor
      // 177: if_icmpgt 185
      // 17a: goto 17e
      // 17d: athrow
      // 17e: ldc_w "§6"
      // 181: goto 19b
      // 184: athrow
      // 185: iload 8
      // 187: ldc_w -387884474
      // 18a: ldc_w -387884449
      // 18d: ixor
      // 18e: if_icmpgt 198
      // 191: ldc_w "§e"
      // 194: goto 19b
      // 197: athrow
      // 198: ldc_w ""
      // 19b: astore 9
      // 19d: aload 9
      // 19f: iload 8
      // 1a1: ldc_w "§f blocks"
      // 1a4: invokedynamic makeConcatWithConstants (Ljava/lang/String;ILjava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001" ]
      // 1a9: astore 10
      // 1ab: new net/minecraft/client/gui/ScaledResolution
      // 1ae: dup
      // 1af: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1b2: invokespecial net/minecraft/client/gui/ScaledResolution.<init> (Lnet/minecraft/client/Minecraft;)V
      // 1b5: astore 11
      // 1b7: aload 11
      // 1b9: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledWidth ()I
      // 1bc: i2f
      // 1bd: fconst_2
      // 1be: fdiv
      // 1bf: ldc_w 11.0
      // 1c2: fadd
      // 1c3: fstore 12
      // 1c5: aload 11
      // 1c7: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledHeight ()I
      // 1ca: i2f
      // 1cb: fconst_2
      // 1cc: fdiv
      // 1cd: ldc_w 3.0
      // 1d0: fsub
      // 1d1: fstore 13
      // 1d3: ldc_w 404661664
      // 1d6: ldc_w -387884449
      // 1d9: ixor
      // 1da: fload 7
      // 1dc: invokestatic x/oc668fce0dbf.ų (IF)I
      // 1df: istore 14
      // 1e1: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1e4: getfield net/minecraft/client/Minecraft.fontRendererObj Lnet/minecraft/client/gui/FontRenderer;
      // 1e7: aload 10
      // 1e9: invokevirtual net/minecraft/client/gui/FontRenderer.getStringWidth (Ljava/lang/String;)I
      // 1ec: i2f
      // 1ed: fstore 15
      // 1ef: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1f2: getfield net/minecraft/client/Minecraft.fontRendererObj Lnet/minecraft/client/gui/FontRenderer;
      // 1f5: getfield net/minecraft/client/gui/FontRenderer.FONT_HEIGHT I
      // 1f8: i2f
      // 1f9: fstore 16
      // 1fb: fload 12
      // 1fd: fload 15
      // 1ff: fconst_2
      // 200: fdiv
      // 201: fadd
      // 202: fstore 17
      // 204: fload 13
      // 206: fload 16
      // 208: fconst_2
      // 209: fdiv
      // 20a: fadd
      // 20b: fstore 18
      // 20d: invokestatic net/minecraft/client/renderer/GlStateManager.pushMatrix ()V
      // 210: iload 6
      // 212: iload 2
      // 213: ifne 242
      // 216: bipush 1
      // 217: if_icmpne 23c
      // 21a: goto 21e
      // 21d: athrow
      // 21e: fload 12
      // 220: fload 12
      // 222: fload 15
      // 224: fadd
      // 225: aload 11
      // 227: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaledWidth ()I
      // 22a: fload 7
      // 22c: invokestatic x/oc668fce0dbf.х (FFIF)F
      // 22f: fconst_0
      // 230: fconst_0
      // 231: invokestatic net/minecraft/client/renderer/GlStateManager.translate (FFF)V
      // 234: iload 2
      // 235: ifeq 272
      // 238: goto 23c
      // 23b: athrow
      // 23c: iload 6
      // 23e: goto 242
      // 241: athrow
      // 242: iload 2
      // 243: ifne 29d
      // 246: ldc_w -387884451
      // 249: ldc_w -387884449
      // 24c: ixor
      // 24d: if_icmpne 272
      // 250: goto 254
      // 253: athrow
      // 254: fload 17
      // 256: fload 18
      // 258: fconst_0
      // 259: invokestatic net/minecraft/client/renderer/GlStateManager.translate (FFF)V
      // 25c: fload 7
      // 25e: fload 7
      // 260: fconst_1
      // 261: invokestatic net/minecraft/client/renderer/GlStateManager.scale (FFF)V
      // 264: fload 17
      // 266: fneg
      // 267: fload 18
      // 269: fneg
      // 26a: fconst_0
      // 26b: invokestatic net/minecraft/client/renderer/GlStateManager.translate (FFF)V
      // 26e: goto 272
      // 271: athrow
      // 272: invokestatic net/minecraft/client/renderer/GlStateManager.disableDepth ()V
      // 275: invokestatic net/minecraft/client/renderer/GlStateManager.enableBlend ()V
      // 278: ldc_w -387884707
      // 27b: ldc_w -387884449
      // 27e: ixor
      // 27f: ldc_w -387884708
      // 282: ldc_w -387884449
      // 285: ixor
      // 286: bipush 1
      // 287: bipush 0
      // 288: invokestatic net/minecraft/client/renderer/GlStateManager.tryBlendFuncSeparate (IIII)V
      // 28b: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 28e: getfield net/minecraft/client/Minecraft.fontRendererObj Lnet/minecraft/client/gui/FontRenderer;
      // 291: aload 10
      // 293: fload 12
      // 295: fload 13
      // 297: iload 14
      // 299: bipush 1
      // 29a: invokevirtual net/minecraft/client/gui/FontRenderer.drawString (Ljava/lang/String;FFIZ)I
      // 29d: pop
      // 29e: invokestatic net/minecraft/client/renderer/GlStateManager.disableBlend ()V
      // 2a1: invokestatic net/minecraft/client/renderer/GlStateManager.enableDepth ()V
      // 2a4: invokestatic net/minecraft/client/renderer/GlStateManager.popMatrix ()V
      // 2a7: return
   }

   static void ù(MovementInput var0) {
      int var1 = oc84f20a0bc5.ė;

      MovementInput var10000;
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

         var10000 = var0;
      }

      var10000.sneak = true;
   }

   @Deprecated
   static void Ȳ(MovementInput var0) {
      int var1 = oc84f20a0bc5.ė;

      MovementInput var10000;
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

         var0.moveForward = 0.0F;
         var0.moveStrafe = 0.0F;
         var10000 = var0;
      }

      var10000.jump = false;
   }

   static boolean ό(int param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 1
      // 04: iload 0
      // 05: iload 1
      // 06: ifne 16
      // 09: bipush 1
      // 0a: if_icmplt 19
      // 0d: goto 11
      // 10: athrow
      // 11: bipush 1
      // 12: goto 16
      // 15: athrow
      // 16: goto 1a
      // 19: bipush 0
      // 1a: ireturn
   }

   static boolean ǆ(int param0, int param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 2
      // 04: iload 1
      // 05: iload 2
      // 06: ifne 11
      // 09: ifle 25
      // 0c: goto 10
      // 0f: athrow
      // 10: iload 0
      // 11: iload 2
      // 12: ifne 22
      // 15: iload 1
      // 16: if_icmplt 25
      // 19: goto 1d
      // 1c: athrow
      // 1d: bipush 1
      // 1e: goto 22
      // 21: athrow
      // 22: goto 26
      // 25: bipush 0
      // 26: ireturn
   }

   static int ɉ(boolean var0) {
      int var1 = oc84f20a0bc5.ė;

      try {
         if (var1 != 0) {
            return var0;
         }

         if (var0 != 0) {
            return 1;
         }
      } catch (ocbde1165e4e var2) {
         throw var2;
      }

      return 0;
   }

   static boolean Ө(boolean var0) {
      int var1 = oc84f20a0bc5.ė;

      try {
         if (var1 != 0) {
            return var0;
         }

         if (!var0) {
            return true;
         }
      } catch (ocbde1165e4e var2) {
         throw var2;
      }

      return false;
   }

   static boolean ƪ(float param0, float param1, float param2, float param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 4
      // 05: fload 0
      // 06: invokestatic x/oc668fce0dbf.ά (F)Z
      // 09: iload 4
      // 0b: ifne 56
      // 0e: ifeq 51
      // 11: goto 15
      // 14: athrow
      // 15: fload 1
      // 16: invokestatic x/oc668fce0dbf.ά (F)Z
      // 19: iload 4
      // 1b: ifne 56
      // 1e: goto 22
      // 21: athrow
      // 22: ifeq 51
      // 25: goto 29
      // 28: athrow
      // 29: fload 2
      // 2a: invokestatic x/oc668fce0dbf.ά (F)Z
      // 2d: iload 4
      // 2f: ifne 56
      // 32: goto 36
      // 35: athrow
      // 36: ifeq 51
      // 39: goto 3d
      // 3c: athrow
      // 3d: fload 3
      // 3e: iload 4
      // 40: ifne 60
      // 43: goto 47
      // 46: athrow
      // 47: invokestatic x/oc668fce0dbf.ά (F)Z
      // 4a: ifne 57
      // 4d: goto 51
      // 50: athrow
      // 51: bipush 0
      // 52: goto 56
      // 55: athrow
      // 56: ireturn
      // 57: fload 2
      // 58: fload 0
      // 59: fsub
      // 5a: invokestatic net/minecraft/util/MathHelper.wrapAngleTo180_float (F)F
      // 5d: invokestatic java/lang/Math.abs (F)F
      // 60: fstore 5
      // 62: fload 3
      // 63: fload 1
      // 64: fsub
      // 65: invokestatic java/lang/Math.abs (F)F
      // 68: fstore 6
      // 6a: fload 5
      // 6c: ldc 30.0
      // 6e: fcmpl
      // 6f: iload 4
      // 71: ifne 91
      // 74: ifge 90
      // 77: goto 7b
      // 7a: athrow
      // 7b: fload 6
      // 7d: ldc 20.0
      // 7f: fcmpl
      // 80: iload 4
      // 82: ifne 91
      // 85: goto 89
      // 88: athrow
      // 89: iflt 94
      // 8c: goto 90
      // 8f: athrow
      // 90: bipush 1
      // 91: goto 95
      // 94: bipush 0
      // 95: ireturn
   }

   private static boolean ά(float var0) {
      int var1 = oc84f20a0bc5.ė;
      int var2 = 1686618389 ^ 654035967;

      while (true) {
         switch (var2) {
            case 193820747:
               return true;
            case 1115425514:
               int var10000;
               label50: {
                  label49: {
                     try {
                        var10000 = Float.isNaN(var0);
                        if (var1 != 0) {
                           break label50;
                        }

                        if (var10000 != 0) {
                           break label49;
                        }
                     } catch (ocbde1165e4e var4) {
                        throw var4;
                     }

                     var2 = 879811991 ^ 654035967;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var10000 = 1265312059 ^ 654035967;
               }

               var2 = var10000;
               if (var1 == 0) {
                  break;
               }
            case 311105128:
               int var5;
               label38: {
                  label37: {
                     try {
                        var5 = Float.isInfinite(var0);
                        if (var1 != 0) {
                           break label38;
                        }

                        if (var5 != 0) {
                           break label37;
                        }
                     } catch (ocbde1165e4e var3) {
                        throw var3;
                     }

                     var2 = 762753972 ^ 654035967;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var5 = 1265312059 ^ 654035967;
               }

               var2 = var5;
               if (var1 == 0) {
                  break;
               }

               return true;
            case 1838213828:
               return false;
            default:
               throw null;
         }
      }
   }

   private boolean И(oc7204ffe95d var1) {
      int var2 = oc84f20a0bc5.ė;
      int var3 = 361558517 ^ -2134506655;

      while (true) {
         label186:
         while (true) {
            label184:
            while (true) {
               label182:
               while (true) {
                  label180:
                  while (true) {
                     label176:
                     while (true) {
                        switch (var3) {
                           case -1877078102:
                              if (oc69da1aa7f5.ő.gameSettings != null) {
                                 var3 = 1243671630 ^ -2134506655;
                                 if (var2 == 0) {
                                    continue;
                                 }
                              }

                              var3 = -156048415 ^ -2134506655;
                              if (var2 != 0) {
                                 break label180;
                              }
                              continue;
                           case -1790250348:
                              break label176;
                           case -1438382372:
                              break label184;
                           case -1207462600:
                              break label186;
                           case -1136238661:
                              return true;
                           case -890835153:
                              break;
                           case -633995775:
                              return true;
                           case -519184218:
                              return false;
                           case -431443092:
                              return false;
                           case -218029588:
                              if (oc69da1aa7f5.ő.thePlayer == null) {
                                 var3 = 1640752071 ^ -2134506655;
                                 if (var2 == 0) {
                                    continue;
                                 }
                              }

                              var3 = -1100135119 ^ -2134506655;
                              if (var2 != 0) {
                                 break label182;
                              }
                              continue;
                           case -30516698:
                              break label180;
                           case 512790183:
                              return true;
                           case 1051412048:
                              break label182;
                           case 1987371136:
                              int var10000;
                              label155: {
                                 label154: {
                                    try {
                                       var10000 = oc69da1aa7f5.ő.thePlayer.onGround;
                                       if (var2 != 0) {
                                          break label155;
                                       }

                                       if (!oc69da1aa7f5.ő.thePlayer.onGround) {
                                          break label154;
                                       }
                                    } catch (ocbde1165e4e var8) {
                                       throw var8;
                                    }

                                    var3 = 2129156423 ^ -2134506655;
                                    if (var2 == 0) {
                                       continue;
                                    }
                                 }

                                 var10000 = 1720627213 ^ -2134506655;
                              }

                              var3 = var10000;
                              if (var2 == 0) {
                                 continue;
                              }
                           case -1164138842:
                              int var9;
                              label145: {
                                 label144: {
                                    try {
                                       var9 = this.ʗ();
                                       if (var2 != 0) {
                                          break label145;
                                       }

                                       if (var9 == 0) {
                                          break label144;
                                       }
                                    } catch (ocbde1165e4e var7) {
                                       throw var7;
                                    }

                                    var3 = 1015045338 ^ -2134506655;
                                    if (var2 == 0) {
                                       continue;
                                    }
                                 }

                                 var9 = 1720627213 ^ -2134506655;
                              }

                              var3 = var9;
                              if (var2 == 0) {
                                 continue;
                              }
                              break;
                           default:
                              throw null;
                        }

                        int var11;
                        label133: {
                           label132: {
                              try {
                                 var11 = oc7ab2161b9f.ն(oc69da1aa7f5.ő.gameSettings.keyBindJump);
                                 if (var2 != 0) {
                                    break label133;
                                 }

                                 if (var11 == 0) {
                                    break label132;
                                 }
                              } catch (ocbde1165e4e var6) {
                                 throw var6;
                              }

                              var3 = 1525939552 ^ -2134506655;
                              if (var2 == 0) {
                                 continue;
                              }
                           }

                           var11 = -156048415 ^ -2134506655;
                        }

                        var3 = var11;
                        if (var2 != 0) {
                           break;
                        }
                     }

                     if (var1 != null) {
                        var3 = 713164221 ^ -2134506655;
                        if (var2 == 0) {
                           continue;
                        }
                     }

                     var3 = 1942430349 ^ -2134506655;
                     if (var2 != 0) {
                        break label184;
                     }
                  }

                  int var12;
                  label114: {
                     label113: {
                        try {
                           var12 = this.ѧ();
                           if (var2 != 0) {
                              break label114;
                           }

                           if (var12 == 0) {
                              break label113;
                           }
                        } catch (ocbde1165e4e var5) {
                           throw var5;
                        }

                        var3 = 979019207 ^ -2134506655;
                        if (var2 == 0) {
                           continue;
                        }
                     }

                     var12 = 1720627213 ^ -2134506655;
                  }

                  var3 = var12;
                  if (var2 != 0) {
                     return false;
                  }
               }

               int var10;
               label105: {
                  label104: {
                     try {
                        double var13;
                        var10 = (var13 = oc69da1aa7f5.ő.thePlayer.motionY - 0.0) == 0.0 ? 0 : (var13 < 0.0 ? -1 : 1);
                        if (var2 != 0) {
                           break label105;
                        }

                        if (var10 > 0) {
                           break label104;
                        }
                     } catch (ocbde1165e4e var4) {
                        throw var4;
                     }

                     var3 = 282594507 ^ -2134506655;
                     if (var2 == 0) {
                        continue;
                     }
                  }

                  var10 = 1525939552 ^ -2134506655;
               }

               var3 = var10;
               if (var2 != 0) {
                  return true;
               }
            }

            if (var1.ñ != null) {
               var3 = 952211033 ^ -2134506655;
               if (var2 == 0) {
                  continue;
               }
            }

            var3 = 1942430349 ^ -2134506655;
            if (var2 != 0) {
               break;
            }
         }

         if (var1.ñ.Ͳ.ʂ == EnumFacing.UP) {
            var3 = -1638494778 ^ -2134506655;
            if (var2 == 0) {
               continue;
            }
         }

         var3 = 1942430349 ^ -2134506655;
      }
   }

   static boolean ӆ(boolean param0, double param1) {
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
      // 06: ifne 20
      // 09: ifeq 37
      // 0c: goto 10
      // 0f: athrow
      // 10: dload 1
      // 11: iload 3
      // 12: ifne 24
      // 15: goto 19
      // 18: athrow
      // 19: invokestatic java/lang/Double.isNaN (D)Z
      // 1c: goto 20
      // 1f: athrow
      // 20: ifne 37
      // 23: dload 1
      // 24: ldc2_w 0.3
      // 27: dcmpg
      // 28: iload 3
      // 29: ifne 34
      // 2c: ifge 37
      // 2f: goto 33
      // 32: athrow
      // 33: bipush 1
      // 34: goto 38
      // 37: bipush 0
      // 38: ireturn
   }

   static boolean Ű(boolean param0, boolean param1, boolean param2, double param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 5
      // 05: iload 0
      // 06: iload 5
      // 08: ifne 13
      // 0b: ifeq 53
      // 0e: goto 12
      // 11: athrow
      // 12: iload 1
      // 13: iload 5
      // 15: ifne 20
      // 18: ifeq 53
      // 1b: goto 1f
      // 1e: athrow
      // 1f: iload 2
      // 20: iload 5
      // 22: ifne 3d
      // 25: ifne 53
      // 28: goto 2c
      // 2b: athrow
      // 2c: dload 3
      // 2d: iload 5
      // 2f: ifne 41
      // 32: goto 36
      // 35: athrow
      // 36: invokestatic java/lang/Double.isFinite (D)Z
      // 39: goto 3d
      // 3c: athrow
      // 3d: ifeq 53
      // 40: dload 3
      // 41: dconst_0
      // 42: dcmpg
      // 43: iload 5
      // 45: ifne 50
      // 48: ifge 53
      // 4b: goto 4f
      // 4e: athrow
      // 4f: bipush 1
      // 50: goto 54
      // 53: bipush 0
      // 54: ireturn
   }

   static float ʴ() {
      return 70.0F;
   }

   static float ŉ(boolean var0) {
      try {
         if (var0) {
            return 80.0F;
         }
      } catch (ocbde1165e4e var1) {
         throw var1;
      }

      return 84.0F;
   }

   static float ͻ(float var0, float var1, float var2) {
      float var3 = MathHelper.wrapAngleTo180_float(var1 - var0);
      float var4 = Math.max(0.0F, var2);
      return var0 + Math.max(-var4, Math.min(var4, var3));
   }

   static boolean Զ(float param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: fload 0
      // 04: ldc_w 360.0
      // 07: frem
      // 08: fstore 2
      // 09: istore 1
      // 0a: fload 2
      // 0b: fconst_0
      // 0c: fcmpg
      // 0d: iload 1
      // 0e: ifne 25
      // 11: ifge 1e
      // 14: goto 18
      // 17: athrow
      // 18: fload 2
      // 19: ldc_w 360.0
      // 1c: fadd
      // 1d: fstore 2
      // 1e: ldc_w -2019752294
      // 21: ldc_w -2019752290
      // 24: ixor
      // 25: newarray 6
      // 27: dup
      // 28: bipush 0
      // 29: ldc 45.0
      // 2b: fastore
      // 2c: dup
      // 2d: bipush 1
      // 2e: ldc_w 135.0
      // 31: fastore
      // 32: dup
      // 33: ldc_w -2019752292
      // 36: ldc_w -2019752290
      // 39: ixor
      // 3a: ldc_w 225.0
      // 3d: fastore
      // 3e: dup
      // 3f: ldc_w -2019752291
      // 42: ldc_w -2019752290
      // 45: ixor
      // 46: ldc_w 315.0
      // 49: fastore
      // 4a: astore 3
      // 4b: aload 3
      // 4c: arraylength
      // 4d: istore 4
      // 4f: bipush 0
      // 50: istore 5
      // 52: iload 5
      // 54: iload 4
      // 56: if_icmpge bf
      // 59: aload 3
      // 5a: iload 5
      // 5c: faload
      // 5d: fstore 6
      // 5f: fload 2
      // 60: fload 6
      // 62: fsub
      // 63: invokestatic java/lang/Math.abs (F)F
      // 66: ldc 10.0
      // 68: fcmpg
      // 69: iload 1
      // 6a: ifne c0
      // 6d: iload 1
      // 6e: ifne b7
      // 71: goto 75
      // 74: athrow
      // 75: iflt b6
      // 78: goto 7c
      // 7b: athrow
      // 7c: fload 2
      // 7d: fload 6
      // 7f: ldc_w 360.0
      // 82: fadd
      // 83: fsub
      // 84: invokestatic java/lang/Math.abs (F)F
      // 87: ldc 10.0
      // 89: fcmpg
      // 8a: iload 1
      // 8b: ifne b7
      // 8e: goto 92
      // 91: athrow
      // 92: iflt b6
      // 95: goto 99
      // 98: athrow
      // 99: fload 2
      // 9a: fload 6
      // 9c: ldc_w 360.0
      // 9f: fsub
      // a0: fsub
      // a1: invokestatic java/lang/Math.abs (F)F
      // a4: ldc 10.0
      // a6: fcmpg
      // a7: iload 1
      // a8: ifne b7
      // ab: goto af
      // ae: athrow
      // af: ifge b8
      // b2: goto b6
      // b5: athrow
      // b6: bipush 1
      // b7: ireturn
      // b8: iinc 5 1
      // bb: iload 1
      // bc: ifeq 52
      // bf: bipush 0
      // c0: ireturn
   }

   static float ӭ(float param0) {
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
      // 06: ifne 1a
      // 09: invokestatic x/oc668fce0dbf.Զ (F)Z
      // 0c: ifeq 1d
      // 0f: goto 13
      // 12: athrow
      // 13: ldc_w 180.0
      // 16: goto 1a
      // 19: athrow
      // 1a: goto 20
      // 1d: ldc_w 135.0
      // 20: fstore 2
      // 21: fload 0
      // 22: fload 2
      // 23: fsub
      // 24: ldc 45.0
      // 26: fdiv
      // 27: invokestatic java/lang/Math.round (F)I
      // 2a: i2f
      // 2b: ldc 45.0
      // 2d: fmul
      // 2e: freturn
   }

   static float ƭ(float var0, boolean var1) {
      try {
         if (var1) {
            return 180.0F;
         }
      } catch (ocbde1165e4e var2) {
         throw var2;
      }

      return var0;
   }

   static float Ȉ(float var0, boolean var1) {
      try {
         if (var1) {
            return 180.0F;
         }
      } catch (ocbde1165e4e var2) {
         throw var2;
      }

      return var0 / 2.0F;
   }

   static boolean ί(double param0, double param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 4
      // 05: dload 0
      // 06: iload 4
      // 08: ifne 1f
      // 0b: invokestatic java/lang/Double.isNaN (D)Z
      // 0e: ifne 3c
      // 11: goto 15
      // 14: athrow
      // 15: dload 2
      // 16: iload 4
      // 18: ifne 2a
      // 1b: goto 1f
      // 1e: athrow
      // 1f: invokestatic java/lang/Double.isNaN (D)Z
      // 22: ifne 3c
      // 25: dload 2
      // 26: goto 2a
      // 29: athrow
      // 2a: dload 0
      // 2b: dcmpg
      // 2c: iload 4
      // 2e: ifne 39
      // 31: ifge 3c
      // 34: goto 38
      // 37: athrow
      // 38: bipush 1
      // 39: goto 3d
      // 3c: bipush 0
      // 3d: ireturn
   }

   static boolean ґ(boolean var0, boolean var1, boolean var2) {
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

   static boolean í(AxisAlignedBB param0, BlockPos param1) {
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
      // 05: ifnull 10
      // 08: aload 1
      // 09: ifnonnull 13
      // 0c: goto 10
      // 0f: athrow
      // 10: bipush 0
      // 11: ireturn
      // 12: athrow
      // 13: aload 0
      // 14: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 17: iload 2
      // 18: ifne 30
      // 1b: aload 1
      // 1c: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 1f: i2d
      // 20: dcmpl
      // 21: ifle 7b
      // 24: goto 28
      // 27: athrow
      // 28: aload 0
      // 29: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 2c: goto 30
      // 2f: athrow
      // 30: aload 1
      // 31: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 34: iload 2
      // 35: ifne 57
      // 38: i2d
      // 39: dconst_1
      // 3a: dadd
      // 3b: dcmpg
      // 3c: ifge 7b
      // 3f: goto 43
      // 42: athrow
      // 43: aload 0
      // 44: iload 2
      // 45: ifne 61
      // 48: goto 4c
      // 4b: athrow
      // 4c: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 4f: aload 1
      // 50: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 53: goto 57
      // 56: athrow
      // 57: i2d
      // 58: dcmpl
      // 59: ifle 7b
      // 5c: aload 0
      // 5d: goto 61
      // 60: athrow
      // 61: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 64: aload 1
      // 65: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 68: i2d
      // 69: dconst_1
      // 6a: dadd
      // 6b: dcmpg
      // 6c: iload 2
      // 6d: ifne 78
      // 70: ifge 7b
      // 73: goto 77
      // 76: athrow
      // 77: bipush 1
      // 78: goto 7c
      // 7b: bipush 0
      // 7c: ireturn
   }

   private void ϝ() {
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
      // 05: getstatic x/oc668fce0dbf.ճ Lx/oca15072e54e;
      // 08: aload 0
      // 09: putfield x/oca15072e54e.ȅ Lx/oc668fce0dbf;
      // 0c: ifne 26
      // 0f: getstatic x/oc668fce0dbf.բ Z
      // 12: ifne 2a
      // 15: goto 19
      // 18: athrow
      // 19: getstatic x/ocea775c9d5c.ų Lx/oc04596227b7;
      // 1c: getstatic x/oc668fce0dbf.ճ Lx/oca15072e54e;
      // 1f: invokevirtual x/oc04596227b7.register (Ljava/lang/Object;)V
      // 22: goto 26
      // 25: athrow
      // 26: bipush 1
      // 27: putstatic x/oc668fce0dbf.բ Z
      // 2a: return
   }

   private void ƌ() {
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
      // 0c: ifeq 4d
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: goto 18
      // 17: athrow
      // 18: iload 1
      // 19: ifne 2b
      // 1c: invokevirtual x/oc668fce0dbf.ճ ()Z
      // 1f: ifeq 4d
      // 22: goto 26
      // 25: athrow
      // 26: aload 0
      // 27: goto 2b
      // 2a: athrow
      // 2b: getfield x/oc668fce0dbf.Ѝ Lx/occ2f8dff8d8;
      // 2e: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 31: iload 1
      // 32: ifne 3f
      // 35: ifeq 4d
      // 38: goto 3c
      // 3b: athrow
      // 3c: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 3f: ifeq 4d
      // 42: aload 0
      // 43: getfield x/oc668fce0dbf.Ȝ Lx/ocff76b7be49;
      // 46: invokevirtual x/ocff76b7be49.œ ()V
      // 49: goto 4d
      // 4c: athrow
      // 4d: return
   }

   private void զ(boolean param1) {
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
      // 06: ifne 1f
      // 09: aconst_null
      // 0a: putfield x/oc668fce0dbf.Ț Lx/oc29fb8ce47a;
      // 0d: aload 0
      // 0e: aconst_null
      // 0f: putfield x/oc668fce0dbf.Ջ Lx/oc412a041b25;
      // 12: iload 1
      // 13: ifeq 22
      // 16: goto 1a
      // 19: athrow
      // 1a: aload 0
      // 1b: goto 1f
      // 1e: athrow
      // 1f: invokevirtual x/oc668fce0dbf.Д ()V
      // 22: return
   }

   private void ʢ() {
      try {
         if (this.շ()) {
            return;
         }
      } catch (ocbde1165e4e var1) {
         throw var1;
      }

      try {
         if (oc69da1aa7f5.ő.thePlayer == null) {
            float[] var3 = new float[-1904028361 ^ -1904028363];
            var3[0] = 0.0F;
            var3[1] = 76.0F;
            this.Ţ = var3;
            return;
         }
      } catch (ocbde1165e4e var2) {
         throw var2;
      }

      float[] var10001 = new float[-1904028361 ^ -1904028363];
      var10001[0] = oc69da1aa7f5.ő.thePlayer.rotationYaw + 180.0F;
      var10001[1] = 76.0F;
      this.Ţ = var10001;
   }

   private void Д() {
      this.Ӛ = Float.NaN;
      this.Ȧ = 1;
      this.ɏ();
   }

   private void ɏ() {
      this.Ų = false;
      this.ə = 0.0F;
      this.ľ = -4453603076615968782L ^ 4453603076615968781L;
      this.Ʉ = 0;
   }

   private boolean Ǫ() {
      int var1 = oc84f20a0bc5.ė;
      int var2 = 684503000 ^ -1979870935;

      while (true) {
         switch (var2) {
            case -1590608143:
               int var7;
               label66: {
                  label65: {
                     try {
                        var7 = this.Ü();
                        if (var1 != 0) {
                           break label66;
                        }

                        if (var7 == 0) {
                           break label65;
                        }
                     } catch (ocbde1165e4e var5) {
                        throw var5;
                     }

                     var2 = 81211091 ^ -1979870935;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var7 = 1949147221 ^ -1979870935;
               }

               var2 = var7;
               if (var1 == 0) {
                  break;
               }
            case -1926578182:
               return this.ū.ȫ();
            case -36687492:
               int var10000;
               label57: {
                  label56: {
                     try {
                        var10000 = this.ӿ();
                        if (var1 != 0) {
                           break label57;
                        }

                        if (var10000 == 0) {
                           break label56;
                        }
                     } catch (ocbde1165e4e var4) {
                        throw var4;
                     }

                     var2 = -1141624114 ^ -1979870935;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var10000 = -1693373536 ^ -1979870935;
               }

               var2 = var10000;
               if (var1 == 0) {
                  break;
               }
            case 839492583:
               int var6;
               label48: {
                  label47: {
                     try {
                        var6 = this.У.ń(System.currentTimeMillis());
                        if (var1 != 0) {
                           break label48;
                        }

                        if (var6 == 0) {
                           break label47;
                        }
                     } catch (ocbde1165e4e var3) {
                        throw var3;
                     }

                     var2 = -1693373536 ^ -1979870935;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var6 = -2123647870 ^ -1979870935;
               }

               var2 = var6;
               break;
            case 144057771:
               return false;
            case 317504137:
               return true;
            default:
               throw null;
         }
      }
   }

   private int ӿ() {
      return Math.max(0, Math.min(Ŗ.length - 1, (int)this.Ѷ.Ӂ()));
   }

   static float х(float param0, float param1, int param2, float param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: fconst_0
      // 01: fconst_1
      // 02: fload 3
      // 03: invokestatic java/lang/Math.min (FF)F
      // 06: invokestatic java/lang/Math.max (FF)F
      // 09: fstore 5
      // 0b: getstatic x/oc84f20a0bc5.ė I
      // 0e: fload 0
      // 0f: fload 1
      // 10: fadd
      // 11: ldc_w 0.5
      // 14: fmul
      // 15: fstore 6
      // 17: istore 4
      // 19: fload 6
      // 1b: iload 2
      // 1c: i2f
      // 1d: ldc_w 0.5
      // 20: fmul
      // 21: iload 4
      // 23: ifne 37
      // 26: fcmpg
      // 27: ifgt 34
      // 2a: goto 2e
      // 2d: athrow
      // 2e: fload 1
      // 2f: fneg
      // 30: goto 38
      // 33: athrow
      // 34: iload 2
      // 35: i2f
      // 36: fload 0
      // 37: fsub
      // 38: fstore 7
      // 3a: fload 7
      // 3c: fconst_1
      // 3d: fload 5
      // 3f: fsub
      // 40: fmul
      // 41: freturn
   }

   static int ų(int var0, float var1) {
      int var2 = var0 >>> (1987328446 ^ 1987328422);
      int var3 = Math.round(var2 * Math.max(0.0F, Math.min(1.0F, var1)));
      return var0 & (1988871769 ^ 1987328422) | var3 << (1987328446 ^ 1987328422);
   }

   @oc66fa4f2195
   public void к(oc2f61de30bc param1) {
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
      // 09: invokevirtual x/oc668fce0dbf.Ü ()Z
      // 0c: ifeq 15
      // 0f: goto 13
      // 12: athrow
      // 13: return
      // 14: athrow
      // 15: aload 0
      // 16: iload 2
      // 17: ifne 41
      // 1a: getfield x/oc668fce0dbf.J Z
      // 1d: ifne 37
      // 20: goto 24
      // 23: athrow
      // 24: aload 0
      // 25: iload 2
      // 26: ifne 47
      // 29: goto 2d
      // 2c: athrow
      // 2d: getfield x/oc668fce0dbf.Ƅ Z
      // 30: ifeq 46
      // 33: goto 37
      // 36: athrow
      // 37: aload 0
      // 38: aconst_null
      // 39: putfield x/oc668fce0dbf.Ț Lx/oc29fb8ce47a;
      // 3c: aload 0
      // 3d: goto 41
      // 40: athrow
      // 41: aconst_null
      // 42: putfield x/oc668fce0dbf.Ջ Lx/oc412a041b25;
      // 45: return
      // 46: aload 0
      // 47: iload 2
      // 48: ifne 62
      // 4b: invokevirtual x/oc668fce0dbf.ɣ ()Z
      // 4e: ifeq 61
      // 51: goto 55
      // 54: athrow
      // 55: aload 0
      // 56: aconst_null
      // 57: putfield x/oc668fce0dbf.Ț Lx/oc29fb8ce47a;
      // 5a: aload 0
      // 5b: aconst_null
      // 5c: putfield x/oc668fce0dbf.Ջ Lx/oc412a041b25;
      // 5f: return
      // 60: athrow
      // 61: aload 0
      // 62: invokevirtual x/oc668fce0dbf.ȷ ()Z
      // 65: iload 2
      // 66: ifne 7f
      // 69: ifeq 7c
      // 6c: goto 70
      // 6f: athrow
      // 70: aload 0
      // 71: aconst_null
      // 72: putfield x/oc668fce0dbf.Ț Lx/oc29fb8ce47a;
      // 75: aload 0
      // 76: aconst_null
      // 77: putfield x/oc668fce0dbf.Ջ Lx/oc412a041b25;
      // 7a: return
      // 7b: athrow
      // 7c: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 7f: ifne 8e
      // 82: aload 0
      // 83: aconst_null
      // 84: putfield x/oc668fce0dbf.Ț Lx/oc29fb8ce47a;
      // 87: aload 0
      // 88: aconst_null
      // 89: putfield x/oc668fce0dbf.Ջ Lx/oc412a041b25;
      // 8c: return
      // 8d: athrow
      // 8e: aload 0
      // 8f: iload 2
      // 90: ifne a5
      // 93: getfield x/oc668fce0dbf.Ț Lx/oc29fb8ce47a;
      // 96: ifnonnull a4
      // 99: goto 9d
      // 9c: athrow
      // 9d: aload 0
      // 9e: aconst_null
      // 9f: putfield x/oc668fce0dbf.Ջ Lx/oc412a041b25;
      // a2: return
      // a3: athrow
      // a4: aload 0
      // a5: getfield x/oc668fce0dbf.Ț Lx/oc29fb8ce47a;
      // a8: astore 3
      // a9: aload 0
      // aa: getfield x/oc668fce0dbf.Ջ Lx/oc412a041b25;
      // ad: astore 4
      // af: aload 0
      // b0: aconst_null
      // b1: putfield x/oc668fce0dbf.Ț Lx/oc29fb8ce47a;
      // b4: aload 0
      // b5: aconst_null
      // b6: putfield x/oc668fce0dbf.Ջ Lx/oc412a041b25;
      // b9: aload 0
      // ba: aload 3
      // bb: aload 4
      // bd: invokevirtual x/oc668fce0dbf.ƹ (Lx/oc29fb8ce47a;Lx/oc412a041b25;)V
      // c0: return
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.LOWEST
   )
   public void Ď(oc25aa89b91f param1) {
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
      // 006: ifne 01d
      // 009: invokevirtual x/oc668fce0dbf.Ü ()Z
      // 00c: ifeq 01c
      // 00f: goto 013
      // 012: athrow
      // 013: aload 0
      // 014: getfield x/oc668fce0dbf.ū Lx/oc11364ce42a;
      // 017: invokevirtual x/oc11364ce42a.ȃ ()V
      // 01a: return
      // 01b: athrow
      // 01c: aload 0
      // 01d: iload 2
      // 01e: ifne 087
      // 021: getfield x/oc668fce0dbf.J Z
      // 024: ifeq 086
      // 027: goto 02b
      // 02a: athrow
      // 02b: invokestatic x/ocbb165642ef.ʨ ()Lx/ocbb165642ef;
      // 02e: invokevirtual x/ocbb165642ef.ɦ ()Ljava/lang/Float;
      // 031: astore 3
      // 032: invokestatic x/ocbb165642ef.ʨ ()Lx/ocbb165642ef;
      // 035: invokevirtual x/ocbb165642ef.ȫ ()Ljava/lang/Float;
      // 038: astore 4
      // 03a: aload 3
      // 03b: iload 2
      // 03c: ifne 048
      // 03f: ifnull 085
      // 042: goto 046
      // 045: athrow
      // 046: aload 4
      // 048: iload 2
      // 049: ifne 054
      // 04c: ifnull 085
      // 04f: goto 053
      // 052: athrow
      // 053: aload 3
      // 054: invokevirtual java/lang/Float.floatValue ()F
      // 057: iload 2
      // 058: ifne 06e
      // 05b: invokestatic x/oc668fce0dbf.ά (F)Z
      // 05e: ifeq 085
      // 061: goto 065
      // 064: athrow
      // 065: aload 4
      // 067: invokevirtual java/lang/Float.floatValue ()F
      // 06a: goto 06e
      // 06d: athrow
      // 06e: invokestatic x/oc668fce0dbf.ά (F)Z
      // 071: ifeq 085
      // 074: aload 1
      // 075: aload 3
      // 076: invokevirtual java/lang/Float.floatValue ()F
      // 079: aload 4
      // 07b: invokevirtual java/lang/Float.floatValue ()F
      // 07e: invokevirtual x/oc25aa89b91f.Ŕ (FF)V
      // 081: goto 085
      // 084: athrow
      // 085: return
      // 086: aload 0
      // 087: iload 2
      // 088: ifne 098
      // 08b: getfield x/oc668fce0dbf.Ƅ Z
      // 08e: ifeq 097
      // 091: goto 095
      // 094: athrow
      // 095: return
      // 096: athrow
      // 097: aload 0
      // 098: iload 2
      // 099: ifne 0ab
      // 09c: invokevirtual x/oc668fce0dbf.ȷ ()Z
      // 09f: ifeq 0b2
      // 0a2: goto 0a6
      // 0a5: athrow
      // 0a6: aload 0
      // 0a7: goto 0ab
      // 0aa: athrow
      // 0ab: getfield x/oc668fce0dbf.Ќ Lx/ocbce5ea28a3;
      // 0ae: aload 1
      // 0af: invokevirtual x/ocbce5ea28a3.ώ (Lx/oc25aa89b91f;)V
      // 0b2: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0b5: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0b8: ifnull 107
      // 0bb: invokestatic x/ocbb165642ef.ʨ ()Lx/ocbb165642ef;
      // 0be: aload 0
      // 0bf: invokevirtual x/ocbb165642ef.D (Ljava/lang/Object;)Z
      // 0c2: iload 2
      // 0c3: ifne 0e1
      // 0c6: goto 0ca
      // 0c9: athrow
      // 0ca: ifne 0f6
      // 0cd: goto 0d1
      // 0d0: athrow
      // 0d1: aload 0
      // 0d2: iload 2
      // 0d3: ifne 0e5
      // 0d6: goto 0da
      // 0d9: athrow
      // 0da: invokevirtual x/oc668fce0dbf.ȷ ()Z
      // 0dd: goto 0e1
      // 0e0: athrow
      // 0e1: ifeq 107
      // 0e4: aload 0
      // 0e5: iload 2
      // 0e6: ifne 0fb
      // 0e9: getfield x/oc668fce0dbf.Ќ Lx/ocbce5ea28a3;
      // 0ec: invokevirtual x/ocbce5ea28a3.ԃ ()Z
      // 0ef: ifeq 107
      // 0f2: goto 0f6
      // 0f5: athrow
      // 0f6: aload 0
      // 0f7: goto 0fb
      // 0fa: athrow
      // 0fb: aload 1
      // 0fc: getstatic x/oc75d51ec7eb.d [F
      // 0ff: bipush 1
      // 100: faload
      // 101: invokestatic x/oc75d51ec7eb.Ӌ ()F
      // 104: invokevirtual x/oc668fce0dbf.w (Lx/oc25aa89b91f;FF)V
      // 107: return
   }

   @oc66fa4f2195
   public void ʐ(oc0e4b758d9a param1) {
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
      // 09: getfield x/oc668fce0dbf.J Z
      // 0c: ifeq 3e
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: goto 18
      // 17: athrow
      // 18: getfield x/oc668fce0dbf.Ъ Lx/oc412a041b25;
      // 1b: ifnull 3e
      // 1e: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 21: iload 2
      // 22: ifne 3b
      // 25: goto 29
      // 28: athrow
      // 29: ifeq 3e
      // 2c: goto 30
      // 2f: athrow
      // 30: invokestatic x/ocbb165642ef.ʨ ()Lx/ocbb165642ef;
      // 33: aload 0
      // 34: invokevirtual x/ocbb165642ef.D (Ljava/lang/Object;)Z
      // 37: goto 3b
      // 3a: athrow
      // 3b: ifne 3f
      // 3e: return
      // 3f: aload 0
      // 40: getfield x/oc668fce0dbf.Ъ Lx/oc412a041b25;
      // 43: astore 3
      // 44: aload 0
      // 45: aconst_null
      // 46: putfield x/oc668fce0dbf.Ъ Lx/oc412a041b25;
      // 49: getstatic x/oc75d51ec7eb.d [F
      // 4c: bipush 0
      // 4d: faload
      // 4e: fstore 4
      // 50: getstatic x/oc75d51ec7eb.d [F
      // 53: bipush 1
      // 54: faload
      // 55: fstore 5
      // 57: aload 0
      // 58: fload 4
      // 5a: fload 5
      // 5c: invokevirtual x/oc668fce0dbf.ǒ (FF)Lnet/minecraft/util/MovingObjectPosition;
      // 5f: astore 6
      // 61: aload 0
      // 62: iload 2
      // 63: ifne 78
      // 66: aload 3
      // 67: aload 6
      // 69: invokevirtual x/oc668fce0dbf.Ѱ (Lx/oc412a041b25;Lnet/minecraft/util/MovingObjectPosition;)Z
      // 6c: ifeq 7c
      // 6f: goto 73
      // 72: athrow
      // 73: aload 0
      // 74: goto 78
      // 77: athrow
      // 78: bipush 0
      // 79: putfield x/oc668fce0dbf.ɛ I
      // 7c: return
   }

   private oce50d12f5a5 ɬ(BlockPos param1, EnumFacing param2, float param3, float param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: istore 5
      // 005: aload 0
      // 006: iload 5
      // 008: ifne 088
      // 00b: invokevirtual x/oc668fce0dbf.շ ()Z
      // 00e: ifeq 087
      // 011: goto 015
      // 014: athrow
      // 015: aload 1
      // 016: aload 2
      // 017: fload 3
      // 018: invokestatic x/oc668fce0dbf.Ø (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;F)[F
      // 01b: astore 6
      // 01d: aload 6
      // 01f: ifnonnull 027
      // 022: aconst_null
      // 023: goto 033
      // 026: athrow
      // 027: aload 0
      // 028: aload 6
      // 02a: bipush 0
      // 02b: faload
      // 02c: aload 6
      // 02e: bipush 1
      // 02f: faload
      // 030: invokevirtual x/oc668fce0dbf.ǒ (FF)Lnet/minecraft/util/MovingObjectPosition;
      // 033: astore 7
      // 035: aload 7
      // 037: aload 1
      // 038: iload 5
      // 03a: ifne 06a
      // 03d: aload 2
      // 03e: invokestatic x/oc668fce0dbf.Ԗ (Lnet/minecraft/util/MovingObjectPosition;Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;)Z
      // 041: ifne 067
      // 044: goto 048
      // 047: athrow
      // 048: aload 1
      // 049: aload 2
      // 04a: invokestatic x/oc668fce0dbf.Ԇ (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;)[F
      // 04d: astore 6
      // 04f: aload 6
      // 051: ifnonnull 059
      // 054: aconst_null
      // 055: goto 065
      // 058: athrow
      // 059: aload 0
      // 05a: aload 6
      // 05c: bipush 0
      // 05d: faload
      // 05e: aload 6
      // 060: bipush 1
      // 061: faload
      // 062: invokevirtual x/oc668fce0dbf.ǒ (FF)Lnet/minecraft/util/MovingObjectPosition;
      // 065: astore 7
      // 067: aload 7
      // 069: aload 1
      // 06a: aload 2
      // 06b: invokestatic x/oc668fce0dbf.Ԗ (Lnet/minecraft/util/MovingObjectPosition;Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;)Z
      // 06e: ifeq 085
      // 071: new x/oce50d12f5a5
      // 074: dup
      // 075: aload 6
      // 077: bipush 0
      // 078: faload
      // 079: aload 6
      // 07b: bipush 1
      // 07c: faload
      // 07d: bipush 0
      // 07e: invokespecial x/oce50d12f5a5.<init> (FFZ)V
      // 081: goto 086
      // 084: athrow
      // 085: aconst_null
      // 086: areturn
      // 087: aload 0
      // 088: iload 5
      // 08a: ifne 09c
      // 08d: invokevirtual x/oc668fce0dbf.T ()Z
      // 090: ifeq 0c4
      // 093: goto 097
      // 096: athrow
      // 097: aload 0
      // 098: goto 09c
      // 09b: athrow
      // 09c: aload 1
      // 09d: aload 2
      // 09e: fload 3
      // 09f: fload 4
      // 0a1: ldc 80.0
      // 0a3: invokevirtual x/oc668fce0dbf.ɂ (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;FFF)Lx/ocd08d8d613d;
      // 0a6: astore 6
      // 0a8: aload 6
      // 0aa: getfield x/ocd08d8d613d.R Z
      // 0ad: ifeq 0c2
      // 0b0: new x/oce50d12f5a5
      // 0b3: dup
      // 0b4: fload 3
      // 0b5: aload 6
      // 0b7: getfield x/ocd08d8d613d.ů F
      // 0ba: bipush 0
      // 0bb: invokespecial x/oce50d12f5a5.<init> (FFZ)V
      // 0be: goto 0c3
      // 0c1: athrow
      // 0c2: aconst_null
      // 0c3: areturn
      // 0c4: fload 3
      // 0c5: fstore 6
      // 0c7: aload 0
      // 0c8: aload 1
      // 0c9: aload 2
      // 0ca: fload 6
      // 0cc: fload 4
      // 0ce: ldc 84.0
      // 0d0: invokevirtual x/oc668fce0dbf.ɂ (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;FFF)Lx/ocd08d8d613d;
      // 0d3: astore 7
      // 0d5: aload 7
      // 0d7: getfield x/ocd08d8d613d.R Z
      // 0da: iload 5
      // 0dc: ifne 110
      // 0df: ifeq 0f7
      // 0e2: goto 0e6
      // 0e5: athrow
      // 0e6: new x/oce50d12f5a5
      // 0e9: dup
      // 0ea: fload 6
      // 0ec: aload 7
      // 0ee: getfield x/ocd08d8d613d.ů F
      // 0f1: bipush 1
      // 0f2: invokespecial x/oce50d12f5a5.<init> (FFZ)V
      // 0f5: areturn
      // 0f6: athrow
      // 0f7: aload 0
      // 0f8: iload 5
      // 0fa: ifne 117
      // 0fd: aload 1
      // 0fe: aload 0
      // 0ff: fload 6
      // 101: aload 7
      // 103: getfield x/ocd08d8d613d.ů F
      // 106: invokevirtual x/oc668fce0dbf.ǒ (FF)Lnet/minecraft/util/MovingObjectPosition;
      // 109: invokevirtual x/oc668fce0dbf.Ϫ (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/MovingObjectPosition;)Z
      // 10c: goto 110
      // 10f: athrow
      // 110: ifeq 116
      // 113: aconst_null
      // 114: areturn
      // 115: athrow
      // 116: aload 0
      // 117: aload 1
      // 118: aload 2
      // 119: invokevirtual x/oc668fce0dbf.ȫ (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;)[F
      // 11c: bipush 0
      // 11d: faload
      // 11e: fstore 8
      // 120: bipush 0
      // 121: istore 9
      // 123: iload 9
      // 125: ldc_w 155154861
      // 128: ldc_w 155154889
      // 12b: ixor
      // 12c: if_icmpgt 1c0
      // 12f: ldc 1.8
      // 131: invokestatic java/util/concurrent/ThreadLocalRandom.current ()Ljava/util/concurrent/ThreadLocalRandom;
      // 134: invokevirtual java/util/concurrent/ThreadLocalRandom.nextFloat ()F
      // 137: ldc 0.1
      // 139: fmul
      // 13a: fadd
      // 13b: fstore 10
      // 13d: iload 5
      // 13f: fload 6
      // 141: fload 8
      // 143: fload 10
      // 145: invokestatic x/oc668fce0dbf.ͻ (FFF)F
      // 148: fstore 6
      // 14a: ifne 178
      // 14d: aload 0
      // 14e: aload 1
      // 14f: aload 2
      // 150: fload 6
      // 152: ldc 84.0
      // 154: invokevirtual x/oc668fce0dbf.ѓ (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;FF)Z
      // 157: ifne 167
      // 15a: goto 15e
      // 15d: athrow
      // 15e: iload 5
      // 160: ifeq 1b4
      // 163: goto 167
      // 166: athrow
      // 167: aload 0
      // 168: aload 1
      // 169: aload 2
      // 16a: fload 6
      // 16c: aload 7
      // 16e: getfield x/ocd08d8d613d.ů F
      // 171: ldc 84.0
      // 173: invokevirtual x/oc668fce0dbf.ɂ (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;FFF)Lx/ocd08d8d613d;
      // 176: astore 7
      // 178: aload 7
      // 17a: getfield x/ocd08d8d613d.R Z
      // 17d: iload 5
      // 17f: ifne 1a8
      // 182: ifeq 19a
      // 185: goto 189
      // 188: athrow
      // 189: new x/oce50d12f5a5
      // 18c: dup
      // 18d: fload 6
      // 18f: aload 7
      // 191: getfield x/ocd08d8d613d.ů F
      // 194: bipush 1
      // 195: invokespecial x/oce50d12f5a5.<init> (FFZ)V
      // 198: areturn
      // 199: athrow
      // 19a: fload 8
      // 19c: fload 6
      // 19e: fsub
      // 19f: invokestatic net/minecraft/util/MathHelper.wrapAngleTo180_float (F)F
      // 1a2: invokestatic java/lang/Math.abs (F)F
      // 1a5: ldc 1.8
      // 1a7: fcmpg
      // 1a8: ifge 1b4
      // 1ab: iload 5
      // 1ad: ifeq 1c0
      // 1b0: goto 1b4
      // 1b3: athrow
      // 1b4: iinc 9 1
      // 1b7: iload 5
      // 1b9: ifeq 123
      // 1bc: goto 1c0
      // 1bf: athrow
      // 1c0: aconst_null
      // 1c1: areturn
   }

   private ocd08d8d613d ɂ(BlockPos param1, EnumFacing param2, float param3, float param4, float param5) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: aload 0
      // 04: fload 3
      // 05: fload 4
      // 07: invokevirtual x/oc668fce0dbf.ǒ (FF)Lnet/minecraft/util/MovingObjectPosition;
      // 0a: astore 7
      // 0c: istore 6
      // 0e: aload 7
      // 10: aload 1
      // 11: aload 2
      // 12: invokestatic x/oc668fce0dbf.Ԗ (Lnet/minecraft/util/MovingObjectPosition;Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;)Z
      // 15: iload 6
      // 17: ifne 36
      // 1a: ifeq 2d
      // 1d: goto 21
      // 20: athrow
      // 21: new x/ocd08d8d613d
      // 24: dup
      // 25: fload 4
      // 27: bipush 1
      // 28: invokespecial x/ocd08d8d613d.<init> (FZ)V
      // 2b: areturn
      // 2c: athrow
      // 2d: aload 0
      // 2e: aload 1
      // 2f: aload 2
      // 30: fload 3
      // 31: fload 5
      // 33: invokevirtual x/oc668fce0dbf.ѓ (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;FF)Z
      // 36: ifne 45
      // 39: new x/ocd08d8d613d
      // 3c: dup
      // 3d: fload 4
      // 3f: bipush 0
      // 40: invokespecial x/ocd08d8d613d.<init> (FZ)V
      // 43: areturn
      // 44: athrow
      // 45: ldc 70.0
      // 47: fstore 8
      // 49: fload 8
      // 4b: fload 5
      // 4d: ldc_w 1.0E-4
      // 50: fadd
      // 51: fcmpg
      // 52: ifgt 7c
      // 55: aload 0
      // 56: fload 3
      // 57: fload 8
      // 59: invokevirtual x/oc668fce0dbf.ǒ (FF)Lnet/minecraft/util/MovingObjectPosition;
      // 5c: aload 1
      // 5d: aload 2
      // 5e: invokestatic x/oc668fce0dbf.Ԗ (Lnet/minecraft/util/MovingObjectPosition;Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;)Z
      // 61: ifeq 70
      // 64: new x/ocd08d8d613d
      // 67: dup
      // 68: fload 8
      // 6a: bipush 1
      // 6b: invokespecial x/ocd08d8d613d.<init> (FZ)V
      // 6e: areturn
      // 6f: athrow
      // 70: fload 8
      // 72: ldc 0.1
      // 74: fadd
      // 75: fstore 8
      // 77: iload 6
      // 79: ifeq 49
      // 7c: new x/ocd08d8d613d
      // 7f: dup
      // 80: fload 4
      // 82: bipush 0
      // 83: invokespecial x/ocd08d8d613d.<init> (FZ)V
      // 86: areturn
   }

   private boolean ѓ(BlockPos param1, EnumFacing param2, float param3, float param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: istore 5
      // 005: aload 2
      // 006: iload 5
      // 008: ifne 01a
      // 00b: getstatic net/minecraft/util/EnumFacing.UP Lnet/minecraft/util/EnumFacing;
      // 00e: if_acmpeq 020
      // 011: goto 015
      // 014: athrow
      // 015: aload 2
      // 016: goto 01a
      // 019: athrow
      // 01a: getstatic net/minecraft/util/EnumFacing.DOWN Lnet/minecraft/util/EnumFacing;
      // 01d: if_acmpne 06d
      // 020: aload 1
      // 021: aload 2
      // 022: fload 3
      // 023: ldc 76.0
      // 025: invokestatic x/oc668fce0dbf.Ŋ (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;FF)[F
      // 028: astore 6
      // 02a: aload 6
      // 02c: iload 5
      // 02e: ifne 03a
      // 031: ifnull 06b
      // 034: goto 038
      // 037: athrow
      // 038: aload 6
      // 03a: bipush 1
      // 03b: faload
      // 03c: iload 5
      // 03e: ifne 054
      // 041: ldc_w 69.8
      // 044: fcmpl
      // 045: iflt 06b
      // 048: goto 04c
      // 04b: athrow
      // 04c: aload 6
      // 04e: bipush 1
      // 04f: faload
      // 050: goto 054
      // 053: athrow
      // 054: fload 4
      // 056: ldc_w 0.2
      // 059: fadd
      // 05a: fcmpg
      // 05b: iload 5
      // 05d: ifne 068
      // 060: ifgt 06b
      // 063: goto 067
      // 066: athrow
      // 067: bipush 1
      // 068: goto 06c
      // 06b: bipush 0
      // 06c: ireturn
      // 06d: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 070: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 073: astore 6
      // 075: aload 6
      // 077: getfield net/minecraft/client/entity/EntityPlayerSP.posX D
      // 07a: dstore 7
      // 07c: aload 6
      // 07e: getfield net/minecraft/client/entity/EntityPlayerSP.posY D
      // 081: aload 6
      // 083: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getEyeHeight ()F
      // 086: f2d
      // 087: dadd
      // 088: dstore 9
      // 08a: aload 6
      // 08c: getfield net/minecraft/client/entity/EntityPlayerSP.posZ D
      // 08f: dstore 11
      // 091: fload 3
      // 092: f2d
      // 093: invokestatic java/lang/Math.toRadians (D)D
      // 096: dstore 13
      // 098: dload 13
      // 09a: invokestatic java/lang/Math.sin (D)D
      // 09d: dneg
      // 09e: dstore 15
      // 0a0: dload 13
      // 0a2: invokestatic java/lang/Math.cos (D)D
      // 0a5: dstore 17
      // 0a7: aload 2
      // 0a8: iload 5
      // 0aa: ifne 0bc
      // 0ad: getstatic net/minecraft/util/EnumFacing.NORTH Lnet/minecraft/util/EnumFacing;
      // 0b0: if_acmpeq 0c2
      // 0b3: goto 0b7
      // 0b6: athrow
      // 0b7: aload 2
      // 0b8: goto 0bc
      // 0bb: athrow
      // 0bc: getstatic net/minecraft/util/EnumFacing.SOUTH Lnet/minecraft/util/EnumFacing;
      // 0bf: if_acmpne 13c
      // 0c2: aload 1
      // 0c3: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 0c6: i2d
      // 0c7: aload 2
      // 0c8: getstatic net/minecraft/util/EnumFacing.SOUTH Lnet/minecraft/util/EnumFacing;
      // 0cb: if_acmpne 0d7
      // 0ce: goto 0d2
      // 0d1: athrow
      // 0d2: dconst_1
      // 0d3: goto 0d8
      // 0d6: athrow
      // 0d7: dconst_0
      // 0d8: dadd
      // 0d9: dstore 21
      // 0db: dload 17
      // 0dd: iload 5
      // 0df: ifne 0fb
      // 0e2: invokestatic java/lang/Math.abs (D)D
      // 0e5: ldc2_w 1.0E-6
      // 0e8: dcmpg
      // 0e9: ifge 0f3
      // 0ec: goto 0f0
      // 0ef: athrow
      // 0f0: bipush 0
      // 0f1: ireturn
      // 0f2: athrow
      // 0f3: dload 21
      // 0f5: dload 11
      // 0f7: dsub
      // 0f8: dload 17
      // 0fa: ddiv
      // 0fb: dstore 19
      // 0fd: dload 7
      // 0ff: dload 15
      // 101: dload 19
      // 103: dmul
      // 104: dadd
      // 105: dstore 23
      // 107: dload 23
      // 109: aload 1
      // 10a: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 10d: i2d
      // 10e: dcmpg
      // 10f: iload 5
      // 111: ifne 136
      // 114: iflt 135
      // 117: goto 11b
      // 11a: athrow
      // 11b: dload 23
      // 11d: aload 1
      // 11e: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 121: i2d
      // 122: dconst_1
      // 123: dadd
      // 124: dcmpl
      // 125: iload 5
      // 127: ifne 136
      // 12a: goto 12e
      // 12d: athrow
      // 12e: ifle 137
      // 131: goto 135
      // 134: athrow
      // 135: bipush 0
      // 136: ireturn
      // 137: iload 5
      // 139: ifeq 1b5
      // 13c: aload 1
      // 13d: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 140: i2d
      // 141: aload 2
      // 142: getstatic net/minecraft/util/EnumFacing.EAST Lnet/minecraft/util/EnumFacing;
      // 145: if_acmpne 151
      // 148: goto 14c
      // 14b: athrow
      // 14c: dconst_1
      // 14d: goto 152
      // 150: athrow
      // 151: dconst_0
      // 152: dadd
      // 153: dstore 21
      // 155: dload 15
      // 157: iload 5
      // 159: ifne 175
      // 15c: invokestatic java/lang/Math.abs (D)D
      // 15f: ldc2_w 1.0E-6
      // 162: dcmpg
      // 163: ifge 16d
      // 166: goto 16a
      // 169: athrow
      // 16a: bipush 0
      // 16b: ireturn
      // 16c: athrow
      // 16d: dload 21
      // 16f: dload 7
      // 171: dsub
      // 172: dload 15
      // 174: ddiv
      // 175: dstore 19
      // 177: dload 11
      // 179: dload 17
      // 17b: dload 19
      // 17d: dmul
      // 17e: dadd
      // 17f: dstore 23
      // 181: dload 23
      // 183: aload 1
      // 184: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 187: i2d
      // 188: dcmpg
      // 189: iload 5
      // 18b: ifne 1b4
      // 18e: iflt 1af
      // 191: goto 195
      // 194: athrow
      // 195: dload 23
      // 197: aload 1
      // 198: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 19b: i2d
      // 19c: dconst_1
      // 19d: dadd
      // 19e: iload 5
      // 1a0: ifne 1b8
      // 1a3: goto 1a7
      // 1a6: athrow
      // 1a7: dcmpl
      // 1a8: ifle 1b5
      // 1ab: goto 1af
      // 1ae: athrow
      // 1af: bipush 0
      // 1b0: goto 1b4
      // 1b3: athrow
      // 1b4: ireturn
      // 1b5: dload 19
      // 1b7: dconst_0
      // 1b8: dcmpg
      // 1b9: iload 5
      // 1bb: ifne 1e0
      // 1be: ifle 1db
      // 1c1: goto 1c5
      // 1c4: athrow
      // 1c5: dload 19
      // 1c7: iload 5
      // 1c9: ifne 210
      // 1cc: goto 1d0
      // 1cf: athrow
      // 1d0: ldc2_w 4.5
      // 1d3: dcmpl
      // 1d4: ifle 1e1
      // 1d7: goto 1db
      // 1da: athrow
      // 1db: bipush 0
      // 1dc: goto 1e0
      // 1df: athrow
      // 1e0: ireturn
      // 1e1: dload 9
      // 1e3: aload 1
      // 1e4: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 1e7: i2d
      // 1e8: dconst_1
      // 1e9: dadd
      // 1ea: dsub
      // 1eb: dload 19
      // 1ed: ddiv
      // 1ee: invokestatic java/lang/Math.atan (D)D
      // 1f1: invokestatic java/lang/Math.toDegrees (D)D
      // 1f4: dstore 21
      // 1f6: dload 9
      // 1f8: aload 1
      // 1f9: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 1fc: i2d
      // 1fd: dsub
      // 1fe: dload 19
      // 200: ddiv
      // 201: invokestatic java/lang/Math.atan (D)D
      // 204: invokestatic java/lang/Math.toDegrees (D)D
      // 207: dstore 23
      // 209: dload 21
      // 20b: dload 23
      // 20d: invokestatic java/lang/Math.min (DD)D
      // 210: dstore 25
      // 212: dload 21
      // 214: dload 23
      // 216: invokestatic java/lang/Math.max (DD)D
      // 219: dstore 27
      // 21b: dload 27
      // 21d: iload 5
      // 21f: ifne 233
      // 222: ldc2_w 69.8
      // 225: dcmpl
      // 226: iflt 24b
      // 229: goto 22d
      // 22c: athrow
      // 22d: dload 25
      // 22f: goto 233
      // 232: athrow
      // 233: fload 4
      // 235: f2d
      // 236: ldc2_w 0.2
      // 239: dadd
      // 23a: dcmpg
      // 23b: iload 5
      // 23d: ifne 248
      // 240: ifgt 24b
      // 243: goto 247
      // 246: athrow
      // 247: bipush 1
      // 248: goto 24c
      // 24b: bipush 0
      // 24c: ireturn
   }

   private boolean Ϫ(BlockPos var1, MovingObjectPosition var2) {
      int var3 = oc84f20a0bc5.ė;
      int var4 = -487089413 ^ -724208064;

      while (true) {
         switch (var4) {
            case 51363401:
               if (var2.typeOfHit == MovingObjectType.BLOCK) {
                  var4 = 1218050084 ^ -724208064;
                  if (var3 == 0) {
                     continue;
                  }
               }

               var4 = -456290346 ^ -724208064;
               if (var3 == 0) {
                  continue;
               }
            case 806943126:
               return false;
            case 337616529:
               return true;
            case 908258491:
               if (var2 != null) {
                  var4 = -673527799 ^ -724208064;
                  if (var3 == 0) {
                     continue;
                  }
               }

               var4 = -456290346 ^ -724208064;
               if (var3 == 0) {
                  continue;
               }
            case -1672704412:
               if (var1 != null) {
                  var4 = -1939080430 ^ -724208064;
                  if (var3 == 0) {
                     continue;
                  }
               }

               var4 = -456290346 ^ -724208064;
               if (var3 == 0) {
                  continue;
               }
            case 1488883026:
               break;
            default:
               throw null;
         }

         int var10000;
         label50: {
            label49: {
               try {
                  var10000 = var1.equals(var2.getBlockPos());
                  if (var3 != 0) {
                     break label50;
                  }

                  if (var10000 == 0) {
                     break label49;
                  }
               } catch (ocbde1165e4e var5) {
                  throw var5;
               }

               var4 = -1060443951 ^ -724208064;
               if (var3 == 0) {
                  continue;
               }
            }

            var10000 = -456290346 ^ -724208064;
         }

         var4 = var10000;
      }
   }

   private float[] ȫ(BlockPos var1, EnumFacing var2) {
      EntityPlayerSP var3 = oc69da1aa7f5.ő.thePlayer;
      double var4 = var1.getX() + 0.5 + var2.getFrontOffsetX() * 0.5;
      double var6 = var1.getY() + 0.5 + var2.getFrontOffsetY() * 0.5;
      double var8 = var1.getZ() + 0.5 + var2.getFrontOffsetZ() * 0.5;
      double var10 = var4 - var3.posX;
      double var12 = var6 - (var3.posY + var3.getEyeHeight());
      double var14 = var8 - var3.posZ;
      float var16 = (float)Math.toDegrees(Math.atan2(-var10, var14));
      float var17 = (float)(-Math.toDegrees(Math.atan2(var12, Math.sqrt(var10 * var10 + var14 * var14))));
      float[] var10000 = new float[-1573473262 ^ -1573473264];
      var10000[0] = var16;
      var10000[1] = MathHelper.clamp_float(var17, -90.0F, 90.0F);
      return var10000;
   }

   private boolean Ǎ(oc86de9e2892 var1) {
      oc412a041b25 var3 = null;
      int var4 = 1241634741 ^ -2117570696;
      int var2 = oc84f20a0bc5.ė;

      label160: {
         label170: {
            label146:
            while (true) {
               switch (var4) {
                  case -2032154065:
                     return false;
                  case -1856740977:
                     break label146;
                  case -1300086548:
                     var3 = this.Ǖ();

                     label101: {
                        label100: {
                           try {
                              if (var2 != 0) {
                                 break label101;
                              }

                              if (var3 == null) {
                                 break label100;
                              }
                           } catch (ocbde1165e4e var7) {
                              throw var7;
                           }

                           var4 = -1886667195 ^ -2117570696;
                           if (var2 == 0) {
                              break;
                           }
                        }

                        var4 = 1976417525 ^ -2117570696;
                     }

                     if (var2 == 0) {
                        break;
                     }
                     break label160;
                  case -875972403:
                     int var13;
                     label111: {
                        label110: {
                           try {
                              var13 = this.Ը.ǭ();
                              if (var2 != 0) {
                                 break label111;
                              }

                              if (var13 != 0) {
                                 break label110;
                              }
                           } catch (ocbde1165e4e var8) {
                              throw var8;
                           }

                           var4 = 1753819046 ^ -2117570696;
                           if (var2 == 0) {
                              break;
                           }
                        }

                        var13 = -1221121530 ^ -2117570696;
                     }

                     var4 = var13;
                     if (var2 == 0) {
                        break;
                     }
                     break label146;
                  case -755085562:
                     break label170;
                  case -381597474:
                     break label160;
                  case -200944755:
                     return false;
                  case 271996444:
                     return false;
                  case 381492491:
                     label92: {
                        label91: {
                           try {
                              this.ɛ--;
                              if (var2 != 0) {
                                 break label92;
                              }

                              if (this.ƽ()) {
                                 break label91;
                              }
                           } catch (ocbde1165e4e var6) {
                              throw var6;
                           }

                           var4 = 118990167 ^ -2117570696;
                           if (var2 == 0) {
                              break;
                           }
                        }

                        var4 = 860499860 ^ -2117570696;
                     }

                     if (var2 == 0) {
                        break;
                     }
                     break label170;
                  case 922699134:
                     int var11;
                     label136: {
                        label135: {
                           try {
                              var11 = this.ɛ;
                              if (var2 != 0) {
                                 break label136;
                              }

                              if (this.ɛ > 0) {
                                 break label135;
                              }
                           } catch (ocbde1165e4e var10) {
                              throw var10;
                           }

                           var4 = -1845610140 ^ -2117570696;
                           if (var2 == 0) {
                              break;
                           }
                        }

                        var11 = -367463077 ^ -2117570696;
                     }

                     var4 = var11;
                     if (var2 == 0) {
                        break;
                     }
                  case 239325501:
                     int var12;
                     label120: {
                        label119: {
                           try {
                              var12 = var1.Ǎ(this, -2117570932 ^ -2117570696, var3.қ, var3.ʡ, true);
                              if (var2 != 0) {
                                 break label120;
                              }

                              if (var12 != 0) {
                                 break label119;
                              }
                           } catch (ocbde1165e4e var9) {
                              throw var9;
                           }

                           var4 = 1976417525 ^ -2117570696;
                           if (var2 == 0) {
                              break;
                           }
                        }

                        var12 = 278662903 ^ -2117570696;
                     }

                     var4 = var12;
                     if (var2 == 0) {
                        break;
                     }

                     return false;
                  case 1808833059:
                     int var10000;
                     label83: {
                        label82: {
                           try {
                              var10000 = 1;
                              if (var2 != 0) {
                                 break label83;
                              }

                              if (Ű(true, true, oc69da1aa7f5.ő.thePlayer.onGround, oc69da1aa7f5.ő.thePlayer.motionY)) {
                                 break label82;
                              }
                           } catch (ocbde1165e4e var5) {
                              throw var5;
                           }

                           var4 = 1396056190 ^ -2117570696;
                           if (var2 == 0) {
                              break;
                           }
                        }

                        var10000 = -1753910669 ^ -2117570696;
                     }

                     var4 = var10000;
                     if (var2 == 0) {
                        break;
                     }

                     return false;
                  default:
                     throw null;
               }
            }

            var1.ʐ(true);
            var1.Ȥ(true);
            this.Ъ = var3;
            this.J = true;
            return true;
         }

         this.ǐ();
         return false;
      }

      this.ǐ();
      return false;
   }

   private oc412a041b25 Ǖ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: aload 0
      // 004: invokevirtual x/oc668fce0dbf.ǭ ()Lnet/minecraft/item/Item;
      // 007: astore 2
      // 008: istore 1
      // 009: aload 2
      // 00a: iload 1
      // 00b: ifne 01c
      // 00e: instanceof net/minecraft/item/ItemBlock
      // 011: ifne 01b
      // 014: goto 018
      // 017: athrow
      // 018: aconst_null
      // 019: areturn
      // 01a: athrow
      // 01b: aload 2
      // 01c: checkcast net/minecraft/item/ItemBlock
      // 01f: astore 3
      // 020: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 023: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 026: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getEntityBoundingBox ()Lnet/minecraft/util/AxisAlignedBB;
      // 029: astore 4
      // 02b: dconst_1
      // 02c: invokestatic x/oc3e9033eba7.թ (D)Lnet/minecraft/util/AxisAlignedBB;
      // 02f: astore 5
      // 031: aload 4
      // 033: aload 5
      // 035: invokevirtual net/minecraft/util/AxisAlignedBB.union (Lnet/minecraft/util/AxisAlignedBB;)Lnet/minecraft/util/AxisAlignedBB;
      // 038: astore 6
      // 03a: aload 6
      // 03c: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 03f: ldc2_w 1.0E-6
      // 042: dadd
      // 043: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 046: istore 7
      // 048: aload 6
      // 04a: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 04d: ldc2_w 1.0E-6
      // 050: dsub
      // 051: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 054: istore 8
      // 056: aload 6
      // 058: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 05b: ldc2_w 1.0E-6
      // 05e: dadd
      // 05f: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 062: istore 9
      // 064: aload 6
      // 066: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 069: ldc2_w 1.0E-6
      // 06c: dsub
      // 06d: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 070: istore 10
      // 072: aload 6
      // 074: getfield net/minecraft/util/AxisAlignedBB.minY D
      // 077: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 07a: bipush 1
      // 07b: isub
      // 07c: istore 11
      // 07e: ldc_w -32823156
      // 081: ldc_w -32823158
      // 084: ixor
      // 085: anewarray 1104
      // 088: dup
      // 089: bipush 0
      // 08a: getstatic net/minecraft/util/EnumFacing.UP Lnet/minecraft/util/EnumFacing;
      // 08d: aastore
      // 08e: dup
      // 08f: bipush 1
      // 090: getstatic net/minecraft/util/EnumFacing.DOWN Lnet/minecraft/util/EnumFacing;
      // 093: aastore
      // 094: dup
      // 095: ldc_w -32823160
      // 098: ldc_w -32823158
      // 09b: ixor
      // 09c: getstatic net/minecraft/util/EnumFacing.NORTH Lnet/minecraft/util/EnumFacing;
      // 09f: aastore
      // 0a0: dup
      // 0a1: ldc_w -32823159
      // 0a4: ldc_w -32823158
      // 0a7: ixor
      // 0a8: getstatic net/minecraft/util/EnumFacing.SOUTH Lnet/minecraft/util/EnumFacing;
      // 0ab: aastore
      // 0ac: dup
      // 0ad: ldc_w -32823154
      // 0b0: ldc_w -32823158
      // 0b3: ixor
      // 0b4: getstatic net/minecraft/util/EnumFacing.WEST Lnet/minecraft/util/EnumFacing;
      // 0b7: aastore
      // 0b8: dup
      // 0b9: ldc_w -32823153
      // 0bc: ldc_w -32823158
      // 0bf: ixor
      // 0c0: getstatic net/minecraft/util/EnumFacing.EAST Lnet/minecraft/util/EnumFacing;
      // 0c3: aastore
      // 0c4: astore 12
      // 0c6: aconst_null
      // 0c7: astore 13
      // 0c9: ldc2_w Infinity
      // 0cc: dstore 14
      // 0ce: aload 6
      // 0d0: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 0d3: aload 6
      // 0d5: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 0d8: dadd
      // 0d9: ldc2_w 0.5
      // 0dc: dmul
      // 0dd: dstore 16
      // 0df: aload 6
      // 0e1: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 0e4: aload 6
      // 0e6: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 0e9: dadd
      // 0ea: ldc2_w 0.5
      // 0ed: dmul
      // 0ee: dstore 18
      // 0f0: bipush 0
      // 0f1: istore 20
      // 0f3: iload 20
      // 0f5: ldc_w 32823156
      // 0f8: ldc_w -32823158
      // 0fb: ixor
      // 0fc: if_icmplt 28b
      // 0ff: iload 7
      // 101: istore 21
      // 103: iload 21
      // 105: iload 8
      // 107: if_icmpgt 284
      // 10a: iload 1
      // 10b: ifne 287
      // 10e: iload 9
      // 110: istore 22
      // 112: iload 22
      // 114: iload 10
      // 116: if_icmpgt 27d
      // 119: new net/minecraft/util/BlockPos
      // 11c: dup
      // 11d: iload 21
      // 11f: iload 11
      // 121: iload 20
      // 123: iadd
      // 124: iload 22
      // 126: invokespecial net/minecraft/util/BlockPos.<init> (III)V
      // 129: astore 23
      // 12b: iload 1
      // 12c: ifne 280
      // 12f: iload 1
      // 130: ifne 279
      // 133: aload 0
      // 134: aload 23
      // 136: invokevirtual x/oc668fce0dbf.à (Lnet/minecraft/util/BlockPos;)Z
      // 139: ifeq 276
      // 13c: goto 140
      // 13f: athrow
      // 140: aload 6
      // 142: aload 23
      // 144: invokestatic x/oc668fce0dbf.í (Lnet/minecraft/util/AxisAlignedBB;Lnet/minecraft/util/BlockPos;)Z
      // 147: ifne 156
      // 14a: goto 14e
      // 14d: athrow
      // 14e: iload 1
      // 14f: ifeq 276
      // 152: goto 156
      // 155: athrow
      // 156: aload 12
      // 158: astore 24
      // 15a: aload 24
      // 15c: arraylength
      // 15d: istore 25
      // 15f: bipush 0
      // 160: istore 26
      // 162: iload 26
      // 164: iload 25
      // 166: if_icmpge 276
      // 169: aload 24
      // 16b: iload 26
      // 16d: aaload
      // 16e: astore 27
      // 170: aload 23
      // 172: aload 27
      // 174: invokevirtual net/minecraft/util/EnumFacing.getOpposite ()Lnet/minecraft/util/EnumFacing;
      // 177: invokevirtual net/minecraft/util/BlockPos.offset (Lnet/minecraft/util/EnumFacing;)Lnet/minecraft/util/BlockPos;
      // 17a: iload 1
      // 17b: ifne 129
      // 17e: astore 28
      // 180: iload 1
      // 181: ifne 272
      // 184: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 187: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 18a: aload 28
      // 18c: invokevirtual net/minecraft/client/multiplayer/WorldClient.getBlockState (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // 18f: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 194: invokevirtual net/minecraft/block/Block.getMaterial ()Lnet/minecraft/block/material/Material;
      // 197: getstatic net/minecraft/block/material/Material.air Lnet/minecraft/block/material/Material;
      // 19a: if_acmpeq 26f
      // 19d: goto 1a1
      // 1a0: athrow
      // 1a1: aload 3
      // 1a2: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1a5: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 1a8: aload 28
      // 1aa: aload 27
      // 1ac: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1af: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1b2: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1b5: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1b8: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getHeldItem ()Lnet/minecraft/item/ItemStack;
      // 1bb: invokevirtual net/minecraft/item/ItemBlock.canPlaceBlockOnSide (Lnet/minecraft/world/World;Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;Lnet/minecraft/entity/player/EntityPlayer;Lnet/minecraft/item/ItemStack;)Z
      // 1be: ifne 1cd
      // 1c1: goto 1c5
      // 1c4: athrow
      // 1c5: iload 1
      // 1c6: ifeq 26f
      // 1c9: goto 1cd
      // 1cc: athrow
      // 1cd: aload 28
      // 1cf: aload 27
      // 1d1: getstatic x/oc75d51ec7eb.d [F
      // 1d4: bipush 0
      // 1d5: faload
      // 1d6: getstatic x/oc75d51ec7eb.d [F
      // 1d9: bipush 1
      // 1da: faload
      // 1db: invokestatic x/oc668fce0dbf.ʳ (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;FF)[F
      // 1de: astore 29
      // 1e0: aload 0
      // 1e1: aload 29
      // 1e3: bipush 0
      // 1e4: faload
      // 1e5: aload 29
      // 1e7: bipush 1
      // 1e8: faload
      // 1e9: invokevirtual x/oc668fce0dbf.ǒ (FF)Lnet/minecraft/util/MovingObjectPosition;
      // 1ec: astore 30
      // 1ee: aload 30
      // 1f0: aload 28
      // 1f2: aload 27
      // 1f4: invokestatic x/oc668fce0dbf.Ԗ (Lnet/minecraft/util/MovingObjectPosition;Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;)Z
      // 1f7: iload 1
      // 1f8: ifne 213
      // 1fb: ifne 20a
      // 1fe: goto 202
      // 201: athrow
      // 202: iload 1
      // 203: ifeq 26f
      // 206: goto 20a
      // 209: athrow
      // 20a: aload 23
      // 20c: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 20f: goto 213
      // 212: athrow
      // 213: i2d
      // 214: ldc2_w 0.5
      // 217: dadd
      // 218: dload 16
      // 21a: dsub
      // 21b: dstore 31
      // 21d: iload 1
      // 21e: ifne 272
      // 221: aload 23
      // 223: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 226: i2d
      // 227: ldc2_w 0.5
      // 22a: dadd
      // 22b: dload 18
      // 22d: dsub
      // 22e: dstore 33
      // 230: iload 20
      // 232: ineg
      // 233: i2d
      // 234: ldc2_w 16.0
      // 237: dmul
      // 238: dload 31
      // 23a: dload 31
      // 23c: dmul
      // 23d: dadd
      // 23e: dload 33
      // 240: dload 33
      // 242: dmul
      // 243: dadd
      // 244: dstore 35
      // 246: dload 35
      // 248: dload 14
      // 24a: dcmpg
      // 24b: ifge 26f
      // 24e: dload 35
      // 250: dstore 14
      // 252: new x/oc412a041b25
      // 255: dup
      // 256: new x/oc84f20a0bc5
      // 259: dup
      // 25a: aload 28
      // 25c: aload 27
      // 25e: invokespecial x/oc84f20a0bc5.<init> (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;)V
      // 261: aload 29
      // 263: bipush 0
      // 264: faload
      // 265: aload 29
      // 267: bipush 1
      // 268: faload
      // 269: bipush 1
      // 26a: invokespecial x/oc412a041b25.<init> (Lx/oc84f20a0bc5;FFZ)V
      // 26d: astore 13
      // 26f: iinc 26 1
      // 272: iload 1
      // 273: ifeq 162
      // 276: iinc 22 1
      // 279: iload 1
      // 27a: ifeq 112
      // 27d: iinc 21 1
      // 280: iload 1
      // 281: ifeq 103
      // 284: iinc 20 -1
      // 287: iload 1
      // 288: ifeq 0f3
      // 28b: aload 13
      // 28d: areturn
   }

   private boolean Ѱ(oc412a041b25 var1, MovingObjectPosition var2) {
      Item var4 = null;
      BlockPos var5 = null;
      ItemBlock var6 = null;
      int var3 = oc84f20a0bc5.ė;
      boolean var7 = false;
      int var8 = -1708937348 ^ -819532633;

      while (true) {
         label163:
         while (true) {
            label161:
            while (true) {
               label155:
               while (true) {
                  switch (var8) {
                     case -1347103239:
                        break label163;
                     case -1261582728:
                        return false;
                     case -1085506725:
                        var4 = this.ǭ();

                        label135: {
                           label134: {
                              try {
                                 if (var3 != 0) {
                                    break label135;
                                 }

                                 if (var4 instanceof ItemBlock) {
                                    break label134;
                                 }
                              } catch (ocbde1165e4e var12) {
                                 throw var12;
                              }

                              var8 = 2079009503 ^ -819532633;
                              if (var3 == 0) {
                                 continue;
                              }
                           }

                           var8 = 621584207 ^ -819532633;
                        }

                        if (var3 == 0) {
                           continue;
                        }
                     case -99643180:
                        var7 = oc69da1aa7f5.ő
                           .playerController
                           .onPlayerRightClick(
                              oc69da1aa7f5.ő.thePlayer,
                              oc69da1aa7f5.ő.theWorld,
                              oc69da1aa7f5.ő.thePlayer.inventory.getCurrentItem(),
                              var1.Ͳ.Ԛ,
                              var1.Ͳ.ʂ,
                              var2.hitVec
                           );

                        label123: {
                           label122: {
                              try {
                                 if (var3 != 0) {
                                    break label123;
                                 }

                                 if (!var7) {
                                    break label122;
                                 }
                              } catch (ocbde1165e4e var11) {
                                 throw var11;
                              }

                              var8 = 1620195678 ^ -819532633;
                              if (var3 == 0) {
                                 continue;
                              }
                           }

                           var8 = -212378411 ^ -819532633;
                        }

                        if (var3 == 0) {
                           continue;
                        }
                        break;
                     case -366316568:
                        break label161;
                     case -64401013:
                        int var10000;
                        label95: {
                           label94: {
                              try {
                                 var10000 = ԣ(var2, var1.Ͳ);
                                 if (var3 != 0) {
                                    break label95;
                                 }

                                 if (var10000 == 0) {
                                    break label94;
                                 }
                              } catch (ocbde1165e4e var9) {
                                 throw var9;
                              }

                              var8 = -886290892 ^ -819532633;
                              if (var3 == 0) {
                                 continue;
                              }
                           }

                           var10000 = -1385844149 ^ -819532633;
                        }

                        var8 = var10000;
                        if (var3 != 0) {
                           return false;
                        }
                        continue;
                     case 67807891:
                        break;
                     case 132409719:
                        if (oc69da1aa7f5.ő.theWorld.getBlockState(var1.Ͳ.Ԛ).getBlock().getMaterial() != Material.air) {
                           var8 = -1920880469 ^ -819532633;
                           if (var3 == 0) {
                              continue;
                           }
                        }

                        var8 = -2015081310 ^ -819532633;
                        if (var3 != 0) {
                           break label163;
                        }
                        continue;
                     case 1014083698:
                        return var7;
                     case 1118264332:
                        break label155;
                     case 1220714501:
                        return false;
                     case 1426408411:
                        if (var1 != null) {
                           var8 = 856669484 ^ -819532633;
                           if (var3 == 0) {
                              continue;
                           }
                        }

                        var8 = -1385844149 ^ -819532633;
                        if (var3 != 0) {
                           break label161;
                        }
                        continue;
                     case 1648582380:
                        return false;
                     default:
                        throw null;
                  }

                  if (oc69da1aa7f5.ő.playerController == null) {
                     var8 = -1385844149 ^ -819532633;
                     if (var3 == 0) {
                        continue;
                     }
                  }

                  var8 = 1886033916 ^ -819532633;
                  if (var3 != 0) {
                     break;
                  }
               }

               int var13;
               label104: {
                  label103: {
                     try {
                        var13 = var6.canPlaceBlockOnSide(
                           oc69da1aa7f5.ő.theWorld, var1.Ͳ.Ԛ, var1.Ͳ.ʂ, oc69da1aa7f5.ő.thePlayer, oc69da1aa7f5.ő.thePlayer.getHeldItem()
                        );
                        if (var3 != 0) {
                           break label104;
                        }

                        if (var13 != 0) {
                           break label103;
                        }
                     } catch (ocbde1165e4e var10) {
                        throw var10;
                     }

                     var8 = -2015081310 ^ -819532633;
                     if (var3 == 0) {
                        continue;
                     }
                  }

                  var13 = 891911283 ^ -819532633;
               }

               var8 = var13;
               if (var3 != 0) {
                  return false;
               }
            }

            var5 = var1.Ͳ.Ԛ.offset(var1.Ͳ.ʂ);
            if (var3 == 0) {
               var6 = (ItemBlock)var4;
               if (this.à(var5)) {
                  var8 = -926775856 ^ -819532633;
                  if (var3 == 0) {
                     continue;
                  }
               }

               var8 = -2015081310 ^ -819532633;
            }

            if (var3 != 0) {
               return var7;
            }
         }

         this.Ϫ();
         this.ʱ.Ѵ(var5);
         this.Β++;
         this.ԛ = -819532638 ^ -819532633;
         var8 = -212378411 ^ -819532633;
      }
   }

   private void ǐ() {
      this.ɛ = 0;
      this.Ъ = null;
      this.J = false;
   }

   private void Ӟ() {
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
      // 06: ifne 1c
      // 09: invokevirtual x/oc668fce0dbf.ǐ ()V
      // 0c: aload 0
      // 0d: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 10: ifeq 1f
      // 13: goto 17
      // 16: athrow
      // 17: aload 0
      // 18: goto 1c
      // 1b: athrow
      // 1c: invokevirtual x/oc668fce0dbf.ζ ()V
      // 1f: return
   }

   private void ζ() {
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
      // 05: aload 0
      // 06: getfield x/oc668fce0dbf.Ը Lx/occ2f8dff8d8;
      // 09: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 0c: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 0f: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 12: iload 1
      // 13: ifne 27
      // 16: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 19: ifnull 3c
      // 1c: goto 20
      // 1f: athrow
      // 20: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 23: goto 27
      // 26: athrow
      // 27: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 2a: getfield net/minecraft/client/entity/EntityPlayerSP.onGround Z
      // 2d: iload 1
      // 2e: ifne 39
      // 31: ifeq 3c
      // 34: goto 38
      // 37: athrow
      // 38: bipush 1
      // 39: goto 3d
      // 3c: bipush 0
      // 3d: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 40: iload 1
      // 41: ifne 56
      // 44: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 47: ifnonnull 53
      // 4a: goto 4e
      // 4d: athrow
      // 4e: dconst_0
      // 4f: goto 5c
      // 52: athrow
      // 53: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 56: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 59: getfield net/minecraft/client/entity/EntityPlayerSP.motionY D
      // 5c: invokestatic x/oc668fce0dbf.Ű (ZZZD)Z
      // 5f: iload 1
      // 60: ifne 71
      // 63: ifeq 74
      // 66: goto 6a
      // 69: athrow
      // 6a: ldc_w 613391047
      // 6d: ldc_w 613391043
      // 70: ixor
      // 71: goto 75
      // 74: bipush 0
      // 75: putfield x/oc668fce0dbf.ɛ I
      // 78: aload 0
      // 79: iload 1
      // 7a: ifne 8c
      // 7d: getfield x/oc668fce0dbf.ɛ I
      // 80: ifle 90
      // 83: goto 87
      // 86: athrow
      // 87: aload 0
      // 88: goto 8c
      // 8b: athrow
      // 8c: invokevirtual x/oc668fce0dbf.ƽ ()Z
      // 8f: pop
      // 90: return
   }

   public boolean Ļ() {
      return this.Ƅ;
   }

   private boolean ȃ() {
      Object var2 = null;
      int var3 = -1009740140 ^ -2029894287;
      int var1 = oc84f20a0bc5.ė;

      label75:
      while (true) {
         switch (var3) {
            case -468464361:
               break label75;
            case 1154667493:
               int var8;
               label69: {
                  label68: {
                     try {
                        var8 = oc7ab2161b9f.Ð();
                        if (var1 != 0) {
                           break label69;
                        }

                        if (var8 == 0) {
                           break label68;
                        }
                     } catch (ocbde1165e4e var6) {
                        throw var6;
                     }

                     var3 = 287533419 ^ -2029894287;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var8 = -454496665 ^ -2029894287;
               }

               var3 = var8;
               if (var1 == 0) {
                  break;
               }
            case -1776210918:
               int var9;
               label57: {
                  label56: {
                     try {
                        var9 = Double.isFinite(oc69da1aa7f5.ő.thePlayer.motionY);
                        if (var1 != 0) {
                           break label57;
                        }

                        if (var9 == 0) {
                           break label56;
                        }
                     } catch (ocbde1165e4e var5) {
                        throw var5;
                     }

                     var3 = -494767625 ^ -2029894287;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var9 = -454496665 ^ -2029894287;
               }

               var3 = var9;
               if (var1 == 0) {
                  break;
               }
               break label75;
            case 1676323606:
               return false;
            case 1702900870:
               int var10000;
               label48: {
                  label47: {
                     try {
                        double var10;
                        var10000 = (var10 = oc69da1aa7f5.ő.thePlayer.motionY - 0.3) == 0.0 ? 0 : (var10 < 0.0 ? -1 : 1);
                        if (var1 != 0) {
                           break label48;
                        }

                        if (var10000 < 0) {
                           break label47;
                        }
                     } catch (ocbde1165e4e var4) {
                        throw var4;
                     }

                     var3 = -454496665 ^ -2029894287;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var10000 = 1662093414 ^ -2029894287;
               }

               var3 = var10000;
               if (var1 == 0) {
                  break;
               }

               return false;
            default:
               throw null;
         }
      }

      var2 = oc69da1aa7f5.ő.thePlayer.getEntityBoundingBox().offset(oc69da1aa7f5.ő.thePlayer.motionX, 0.0, oc69da1aa7f5.ő.thePlayer.motionZ);
      return oc69da1aa7f5.ő.theWorld.getCollidingBoundingBoxes(oc69da1aa7f5.ő.thePlayer, var2.offset(0.0, -0.5, 0.0)).isEmpty();
   }

   private oc7204ffe95d ш() {
      AxisAlignedBB var2 = oc3e9033eba7.թ(1.0);
      int var10000 = oc84f20a0bc5.ė;
      boolean var3 = oc69da1aa7f5.ő.theWorld.getCollidingBoundingBoxes(oc69da1aa7f5.ő.thePlayer, var2.offset(0.0, -0.5, 0.0)).isEmpty();
      int var1 = var10000;
      float var4 = this.є();
      Item var5 = this.ǭ();

      label123: {
         try {
            if (var5 instanceof ItemBlock) {
               var20 = this.ӌ(var4, var2);
               break label123;
            }
         } catch (ocbde1165e4e var19) {
            throw var19;
         }

         var20 = null;
      }

      oc412a041b25 var6 = var20;
      var10000 = var1;
      float var7 = (float)this.Ү.ϐ();
      float var8 = this.ν(var4);
      float var9 = this.Ş();

      label115: {
         label114: {
            try {
               if (var10000 != 0) {
                  break label114;
               }

               if (var6 == null) {
                  break label115;
               }
            } catch (ocbde1165e4e var18) {
               throw var18;
            }

            float[] var10001 = new float[-1167657542 ^ -1167657544];
            var10001[0] = var6.қ;
            var10001[1] = var6.ʡ;
            this.Ţ = var10001;
            var8 = var6.қ;
         }

         var9 = var6.ʡ;
      }

      label127: {
         try {
            if (this.շ()) {
               var23 = var7;
               break label127;
            }
         } catch (ocbde1165e4e var17) {
            throw var17;
         }

         boolean var27;
         label99: {
            label98: {
               label97: {
                  label96: {
                     try {
                        var22 = var7;
                        var26 = var6;
                        if (var1 != 0) {
                           break label96;
                        }

                        if (var6 == null) {
                           break label97;
                        }
                     } catch (ocbde1165e4e var16) {
                        throw var16;
                     }

                     var26 = var6;
                  }

                  try {
                     var27 = var26.Ғ;
                     if (var1 != 0) {
                        break label99;
                     }

                     if (var26.Ғ) {
                        break label98;
                     }
                  } catch (ocbde1165e4e var15) {
                     throw var15;
                  }
               }

               var27 = false;
               break label99;
            }

            var27 = true;
         }

         var23 = ƭ(var22, var27);
      }

      float var10 = var23;

      label128: {
         try {
            if (this.շ()) {
               var25 = var7;
               break label128;
            }
         } catch (ocbde1165e4e var14) {
            throw var14;
         }

         boolean var29;
         label74: {
            label73: {
               label72: {
                  label71: {
                     try {
                        var24 = var7;
                        var28 = var6;
                        if (var1 != 0) {
                           break label71;
                        }

                        if (var6 == null) {
                           break label72;
                        }
                     } catch (ocbde1165e4e var13) {
                        throw var13;
                     }

                     var28 = var6;
                  }

                  try {
                     var29 = var28.Ғ;
                     if (var1 != 0) {
                        break label74;
                     }

                     if (var28.Ғ) {
                        break label73;
                     }
                  } catch (ocbde1165e4e var12) {
                     throw var12;
                  }
               }

               var29 = false;
               break label74;
            }

            var29 = true;
         }

         var25 = Ȉ(var24, var29);
      }

      float var11 = var25;
      return new oc7204ffe95d(var8, var9, var10, var11, var6, ӆ(var3, oc69da1aa7f5.ő.thePlayer.motionY));
   }

   private void ƹ(oc29fb8ce47a param1, oc412a041b25 param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: bipush 0
      // 004: istore 4
      // 006: istore 3
      // 007: aload 0
      // 008: invokevirtual x/oc668fce0dbf.ǭ ()Lnet/minecraft/item/Item;
      // 00b: astore 5
      // 00d: iload 3
      // 00e: ifne 149
      // 011: aload 5
      // 013: instanceof net/minecraft/item/ItemBlock
      // 016: ifeq 143
      // 019: goto 01d
      // 01c: athrow
      // 01d: aload 2
      // 01e: ifnull 143
      // 021: goto 025
      // 024: athrow
      // 025: aload 0
      // 026: iload 3
      // 027: ifne 144
      // 02a: goto 02e
      // 02d: athrow
      // 02e: aload 2
      // 02f: invokevirtual x/oc668fce0dbf.Ý (Lx/oc412a041b25;)Z
      // 032: ifeq 143
      // 035: goto 039
      // 038: athrow
      // 039: aload 5
      // 03b: checkcast net/minecraft/item/ItemBlock
      // 03e: astore 6
      // 040: invokestatic x/ocbb165642ef.ʨ ()Lx/ocbb165642ef;
      // 043: invokevirtual x/ocbb165642ef.ɦ ()Ljava/lang/Float;
      // 046: astore 7
      // 048: invokestatic x/ocbb165642ef.ʨ ()Lx/ocbb165642ef;
      // 04b: invokevirtual x/ocbb165642ef.ȫ ()Ljava/lang/Float;
      // 04e: astore 8
      // 050: aload 7
      // 052: iload 3
      // 053: ifne 05f
      // 056: ifnull 070
      // 059: goto 05d
      // 05c: athrow
      // 05d: aload 7
      // 05f: iload 3
      // 060: ifne 07a
      // 063: invokevirtual java/lang/Float.floatValue ()F
      // 066: invokestatic x/oc668fce0dbf.ά (F)Z
      // 069: ifne 078
      // 06c: goto 070
      // 06f: athrow
      // 070: aload 1
      // 071: invokevirtual x/oc29fb8ce47a.Ċ ()F
      // 074: goto 07d
      // 077: athrow
      // 078: aload 7
      // 07a: invokevirtual java/lang/Float.floatValue ()F
      // 07d: fstore 9
      // 07f: aload 8
      // 081: iload 3
      // 082: ifne 08e
      // 085: ifnull 09f
      // 088: goto 08c
      // 08b: athrow
      // 08c: aload 8
      // 08e: iload 3
      // 08f: ifne 0a9
      // 092: invokevirtual java/lang/Float.floatValue ()F
      // 095: invokestatic x/oc668fce0dbf.ά (F)Z
      // 098: ifne 0a7
      // 09b: goto 09f
      // 09e: athrow
      // 09f: aload 1
      // 0a0: invokevirtual x/oc29fb8ce47a.վ ()F
      // 0a3: goto 0ac
      // 0a6: athrow
      // 0a7: aload 8
      // 0a9: invokevirtual java/lang/Float.floatValue ()F
      // 0ac: fstore 10
      // 0ae: aload 0
      // 0af: iload 3
      // 0b0: ifne 144
      // 0b3: fload 9
      // 0b5: fload 10
      // 0b7: invokevirtual x/oc668fce0dbf.ǒ (FF)Lnet/minecraft/util/MovingObjectPosition;
      // 0ba: astore 11
      // 0bc: aload 11
      // 0be: aload 2
      // 0bf: getfield x/oc412a041b25.Ͳ Lx/oc84f20a0bc5;
      // 0c2: invokestatic x/oc668fce0dbf.ԣ (Lnet/minecraft/util/MovingObjectPosition;Lx/oc84f20a0bc5;)Z
      // 0c5: ifeq 143
      // 0c8: aload 11
      // 0ca: getfield net/minecraft/util/MovingObjectPosition.sideHit Lnet/minecraft/util/EnumFacing;
      // 0cd: getstatic net/minecraft/util/EnumFacing.DOWN Lnet/minecraft/util/EnumFacing;
      // 0d0: if_acmpeq 143
      // 0d3: goto 0d7
      // 0d6: athrow
      // 0d7: aload 0
      // 0d8: invokevirtual x/oc668fce0dbf.ѧ ()Z
      // 0db: iload 3
      // 0dc: ifne 121
      // 0df: goto 0e3
      // 0e2: athrow
      // 0e3: ifeq 0f9
      // 0e6: goto 0ea
      // 0e9: athrow
      // 0ea: aload 11
      // 0ec: getfield net/minecraft/util/MovingObjectPosition.sideHit Lnet/minecraft/util/EnumFacing;
      // 0ef: getstatic net/minecraft/util/EnumFacing.UP Lnet/minecraft/util/EnumFacing;
      // 0f2: if_acmpeq 143
      // 0f5: goto 0f9
      // 0f8: athrow
      // 0f9: aload 6
      // 0fb: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0fe: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 101: aload 11
      // 103: invokevirtual net/minecraft/util/MovingObjectPosition.getBlockPos ()Lnet/minecraft/util/BlockPos;
      // 106: aload 11
      // 108: getfield net/minecraft/util/MovingObjectPosition.sideHit Lnet/minecraft/util/EnumFacing;
      // 10b: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 10e: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 111: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 114: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 117: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getHeldItem ()Lnet/minecraft/item/ItemStack;
      // 11a: invokevirtual net/minecraft/item/ItemBlock.canPlaceBlockOnSide (Lnet/minecraft/world/World;Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;Lnet/minecraft/entity/player/EntityPlayer;Lnet/minecraft/item/ItemStack;)Z
      // 11d: goto 121
      // 120: athrow
      // 121: iload 3
      // 122: ifne 141
      // 125: ifeq 143
      // 128: goto 12c
      // 12b: athrow
      // 12c: aload 0
      // 12d: aload 2
      // 12e: getfield x/oc412a041b25.Ͳ Lx/oc84f20a0bc5;
      // 131: aload 11
      // 133: getstatic x/oc75d51ec7eb.d [F
      // 136: bipush 0
      // 137: faload
      // 138: fload 9
      // 13a: invokevirtual x/oc668fce0dbf.y (Lx/oc84f20a0bc5;Lnet/minecraft/util/MovingObjectPosition;FF)Z
      // 13d: goto 141
      // 140: athrow
      // 141: istore 4
      // 143: aload 0
      // 144: iload 4
      // 146: invokevirtual x/oc668fce0dbf.Ù (Z)V
      // 149: return
   }

   private boolean Ý(oc412a041b25 var1) {
      AxisAlignedBB var3 = null;
      boolean var4 = false;
      BlockPos var5 = null;
      Object var6 = null;
      AxisAlignedBB var7 = null;
      int var2 = oc84f20a0bc5.ė;
      oc412a041b25 var8 = null;
      int var9 = -184584824 ^ -163940620;

      while (true) {
         label172:
         while (true) {
            switch (var9) {
               case -1468644622:
                  return false;
               case -1082677851:
                  int var17;
                  label154: {
                     label153: {
                        try {
                           var17 = var8.Ͳ.Ԛ.offset(var8.Ͳ.ʂ).equals(var5);
                           if (var2 != 0) {
                              break label154;
                           }

                           if (var17 == 0) {
                              break label153;
                           }
                        } catch (ocbde1165e4e var14) {
                           throw var14;
                        }

                        var9 = 470086607 ^ -163940620;
                        if (var2 == 0) {
                           continue;
                        }
                     }

                     var17 = -518701766 ^ -163940620;
                  }

                  var9 = var17;
                  if (var2 == 0) {
                     continue;
                  }
               case 801521598:
                  int var18;
                  label130: {
                     label129: {
                        try {
                           var18 = í(var7, var5);
                           if (var2 != 0) {
                              break label130;
                           }

                           if (var18 != 0) {
                              break label129;
                           }
                        } catch (ocbde1165e4e var12) {
                           throw var12;
                        }

                        var9 = -475487599 ^ -163940620;
                        if (var2 == 0) {
                           continue;
                        }
                     }

                     var18 = 1902238795 ^ -163940620;
                  }

                  var9 = var18;
                  if (var2 == 0) {
                     continue;
                  }
                  break;
               case -718301755:
                  int var10000;
                  label105: {
                     label104: {
                        try {
                           var10000 = oc7ab2161b9f.Ð();
                           if (var2 != 0) {
                              break label105;
                           }

                           if (var10000 == 0) {
                              break label104;
                           }
                        } catch (ocbde1165e4e var10) {
                           throw var10;
                        }

                        var9 = -22760240 ^ -163940620;
                        if (var2 == 0) {
                           continue;
                        }
                     }

                     var10000 = -740775138 ^ -163940620;
                  }

                  var9 = var10000;
                  if (var2 != 0) {
                     return false;
                  }
                  continue;
               case -644650214:
                  break;
               case -365001413:
                  return true;
               case 46465916:
                  if (var1 != null) {
                     var9 = 588636977 ^ -163940620;
                     if (var2 == 0) {
                        continue;
                     }
                  }

                  var9 = -740775138 ^ -163940620;
                  if (var2 != 0) {
                     return false;
                  }
                  continue;
               case 144622116:
                  break label172;
               case 354396337:
                  if (oc69da1aa7f5.ő.theWorld == null) {
                     var9 = -740775138 ^ -163940620;
                     if (var2 == 0) {
                        continue;
                     }
                  }

                  var9 = 799612398 ^ -163940620;
                  if (var2 == 0) {
                     continue;
                  }
               case -2024035649:
                  var8 = this.ӌ(this.є(), var3);

                  label139: {
                     label138: {
                        try {
                           if (var2 != 0) {
                              break label139;
                           }

                           if (var8 == null) {
                              break label138;
                           }
                        } catch (ocbde1165e4e var13) {
                           throw var13;
                        }

                        var9 = 1229837137 ^ -163940620;
                        if (var2 == 0) {
                           continue;
                        }
                     }

                     var9 = -518701766 ^ -163940620;
                  }

                  if (var2 == 0) {
                     continue;
                  }
                  break label172;
               case 361944165:
                  return false;
               case 388975566:
                  return false;
               case 635624938:
                  return false;
               case 782816294:
                  var5 = var1.Ͳ.Ԛ.offset(var1.Ͳ.ʂ);
                  if (var2 == 0) {
                     var6 = oc69da1aa7f5.ő.theWorld.getBlockState(var5);
                     var7 = oc69da1aa7f5.ő.thePlayer.getEntityBoundingBox().union(var3);
                     if (var6.getBlock().isReplaceable(oc69da1aa7f5.ő.theWorld, var5)) {
                        var9 = -637777590 ^ -163940620;
                        if (var2 == 0) {
                           continue;
                        }
                     }

                     var9 = -475487599 ^ -163940620;
                  }

                  if (var2 != 0) {
                     return false;
                  }
                  continue;
               default:
                  throw null;
            }

            var3 = oc3e9033eba7.թ(1.0);
            int var19 = var2;
            var4 = oc69da1aa7f5.ő.theWorld.getCollidingBoundingBoxes(oc69da1aa7f5.ő.thePlayer, var3.offset(0.0, -0.5, 0.0)).isEmpty();

            label114: {
               label113: {
                  try {
                     if (var19 != 0) {
                        break label114;
                     }

                     if (ӆ(var4, oc69da1aa7f5.ő.thePlayer.motionY)) {
                        break label113;
                     }
                  } catch (ocbde1165e4e var11) {
                     throw var11;
                  }

                  var9 = 1582052358 ^ -163940620;
                  if (var2 == 0) {
                     continue;
                  }
               }

               var9 = -661478702 ^ -163940620;
            }

            if (var2 != 0) {
               return true;
            }
         }

         if (oc69da1aa7f5.ő.thePlayer != null) {
            var9 = -484057531 ^ -163940620;
            if (var2 == 0) {
               continue;
            }
         }

         var9 = -740775138 ^ -163940620;
         if (var2 != 0) {
            return false;
         }
      }
   }

   private float[] ȋ(oc412a041b25 param1, float param2, float param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc75d51ec7eb.d [F
      // 003: bipush 0
      // 004: faload
      // 005: fstore 5
      // 007: getstatic x/oc84f20a0bc5.ė I
      // 00a: getstatic x/oc75d51ec7eb.d [F
      // 00d: bipush 1
      // 00e: faload
      // 00f: fstore 6
      // 011: istore 4
      // 013: fload 5
      // 015: fload 6
      // 017: fload 2
      // 018: fload 3
      // 019: invokestatic x/oc668fce0dbf.Ƅ (FFFF)[F
      // 01c: astore 7
      // 01e: aload 0
      // 01f: aload 7
      // 021: bipush 0
      // 022: faload
      // 023: aload 7
      // 025: bipush 1
      // 026: faload
      // 027: invokevirtual x/oc668fce0dbf.ǒ (FF)Lnet/minecraft/util/MovingObjectPosition;
      // 02a: aload 1
      // 02b: getfield x/oc412a041b25.Ͳ Lx/oc84f20a0bc5;
      // 02e: invokestatic x/oc668fce0dbf.ԣ (Lnet/minecraft/util/MovingObjectPosition;Lx/oc84f20a0bc5;)Z
      // 031: iload 4
      // 033: ifne 044
      // 036: ifne 04f
      // 039: goto 03d
      // 03c: athrow
      // 03d: ldc_w 1448588434
      // 040: ldc_w 1448588432
      // 043: ixor
      // 044: newarray 6
      // 046: dup
      // 047: bipush 0
      // 048: fload 2
      // 049: fastore
      // 04a: dup
      // 04b: bipush 1
      // 04c: fload 3
      // 04d: fastore
      // 04e: areturn
      // 04f: fload 5
      // 051: aload 7
      // 053: bipush 0
      // 054: faload
      // 055: aload 0
      // 056: getfield x/oc668fce0dbf.Ӛ F
      // 059: invokestatic x/oc75d51ec7eb.Ӌ ()F
      // 05c: ldc 149.0
      // 05e: aload 0
      // 05f: getfield x/oc668fce0dbf.Ȧ I
      // 062: invokestatic x/oc668fce0dbf.ȁ (FFFFFI)F
      // 065: fstore 8
      // 067: fload 8
      // 069: aload 7
      // 06b: bipush 0
      // 06c: faload
      // 06d: invokestatic java/lang/Float.compare (FF)I
      // 070: iload 4
      // 072: ifne 096
      // 075: ifne 08f
      // 078: goto 07c
      // 07b: athrow
      // 07c: ldc_w 1448588434
      // 07f: ldc_w 1448588432
      // 082: ixor
      // 083: newarray 6
      // 085: dup
      // 086: bipush 0
      // 087: fload 2
      // 088: fastore
      // 089: dup
      // 08a: bipush 1
      // 08b: fload 3
      // 08c: fastore
      // 08d: areturn
      // 08e: athrow
      // 08f: ldc_w 1448588434
      // 092: ldc_w 1448588432
      // 095: ixor
      // 096: newarray 10
      // 098: dup
      // 099: bipush 0
      // 09a: aload 0
      // 09b: getfield x/oc668fce0dbf.Ȧ I
      // 09e: iastore
      // 09f: dup
      // 0a0: bipush 1
      // 0a1: aload 0
      // 0a2: getfield x/oc668fce0dbf.Ȧ I
      // 0a5: ineg
      // 0a6: iastore
      // 0a7: astore 9
      // 0a9: aload 9
      // 0ab: arraylength
      // 0ac: istore 10
      // 0ae: bipush 0
      // 0af: istore 11
      // 0b1: iload 11
      // 0b3: iload 10
      // 0b5: if_icmpge 14c
      // 0b8: aload 9
      // 0ba: iload 11
      // 0bc: iaload
      // 0bd: iload 4
      // 0bf: ifne 153
      // 0c2: istore 12
      // 0c4: iload 4
      // 0c6: ifne 147
      // 0c9: fload 5
      // 0cb: aload 7
      // 0cd: bipush 0
      // 0ce: faload
      // 0cf: aload 0
      // 0d0: getfield x/oc668fce0dbf.Ӛ F
      // 0d3: invokestatic x/oc75d51ec7eb.Ӌ ()F
      // 0d6: ldc 149.0
      // 0d8: iload 12
      // 0da: invokestatic x/oc668fce0dbf.ȁ (FFFFFI)F
      // 0dd: fstore 8
      // 0df: fload 8
      // 0e1: aload 7
      // 0e3: bipush 0
      // 0e4: faload
      // 0e5: invokestatic java/lang/Float.compare (FF)I
      // 0e8: ifeq 144
      // 0eb: aload 0
      // 0ec: iload 4
      // 0ee: ifne 11a
      // 0f1: goto 0f5
      // 0f4: athrow
      // 0f5: fload 8
      // 0f7: aload 7
      // 0f9: bipush 1
      // 0fa: faload
      // 0fb: invokevirtual x/oc668fce0dbf.ǒ (FF)Lnet/minecraft/util/MovingObjectPosition;
      // 0fe: aload 1
      // 0ff: getfield x/oc412a041b25.Ͳ Lx/oc84f20a0bc5;
      // 102: invokestatic x/oc668fce0dbf.ԣ (Lnet/minecraft/util/MovingObjectPosition;Lx/oc84f20a0bc5;)Z
      // 105: ifne 115
      // 108: goto 10c
      // 10b: athrow
      // 10c: iload 4
      // 10e: ifeq 144
      // 111: goto 115
      // 114: athrow
      // 115: aload 0
      // 116: goto 11a
      // 119: athrow
      // 11a: aload 0
      // 11b: getfield x/oc668fce0dbf.Ȧ I
      // 11e: ineg
      // 11f: putfield x/oc668fce0dbf.Ȧ I
      // 122: getstatic x/oc668fce0dbf.ӧ Lx/oc7beea7ccff;
      // 125: fload 8
      // 127: aload 7
      // 129: bipush 1
      // 12a: faload
      // 12b: invokevirtual x/oc7beea7ccff.т (FF)V
      // 12e: ldc_w 1448588434
      // 131: ldc_w 1448588432
      // 134: ixor
      // 135: newarray 6
      // 137: dup
      // 138: bipush 0
      // 139: fload 8
      // 13b: fastore
      // 13c: dup
      // 13d: bipush 1
      // 13e: aload 7
      // 140: bipush 1
      // 141: faload
      // 142: fastore
      // 143: areturn
      // 144: iinc 11 1
      // 147: iload 4
      // 149: ifeq 0b1
      // 14c: ldc_w 1448588434
      // 14f: ldc_w 1448588432
      // 152: ixor
      // 153: newarray 6
      // 155: dup
      // 156: bipush 0
      // 157: fload 2
      // 158: fastore
      // 159: dup
      // 15a: bipush 1
      // 15b: fload 3
      // 15c: fastore
      // 15d: areturn
   }

   private float ѷ(float param1, float param2, float param3, oc84f20a0bc5 param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: istore 5
      // 005: aload 0
      // 006: iload 5
      // 008: ifne 01a
      // 00b: getfield x/oc668fce0dbf.Ų Z
      // 00e: ifeq 053
      // 011: goto 015
      // 014: athrow
      // 015: aload 0
      // 016: goto 01a
      // 019: athrow
      // 01a: getfield x/oc668fce0dbf.ľ J
      // 01d: lconst_0
      // 01e: lcmp
      // 01f: iload 5
      // 021: ifne 03c
      // 024: ifle 053
      // 027: goto 02b
      // 02a: athrow
      // 02b: fload 1
      // 02c: iload 5
      // 02e: ifne 058
      // 031: goto 035
      // 034: athrow
      // 035: invokestatic x/oc668fce0dbf.ά (F)Z
      // 038: goto 03c
      // 03b: athrow
      // 03c: ifeq 053
      // 03f: fload 3
      // 040: iload 5
      // 042: ifne 05c
      // 045: goto 049
      // 048: athrow
      // 049: invokestatic x/oc668fce0dbf.ά (F)Z
      // 04c: ifne 059
      // 04f: goto 053
      // 052: athrow
      // 053: fload 3
      // 054: goto 058
      // 057: athrow
      // 058: freturn
      // 059: fload 3
      // 05a: fload 1
      // 05b: fsub
      // 05c: fstore 6
      // 05e: fload 6
      // 060: iload 5
      // 062: ifne 07c
      // 065: aload 0
      // 066: getfield x/oc668fce0dbf.ľ J
      // 069: invokestatic x/oc3b42959d05.Ҳ (FJ)Z
      // 06c: ifne 076
      // 06f: goto 073
      // 072: athrow
      // 073: fload 3
      // 074: freturn
      // 075: athrow
      // 076: invokestatic x/oc75d51ec7eb.Ӌ ()F
      // 079: invokestatic java/lang/Math.abs (F)F
      // 07c: fstore 7
      // 07e: fload 7
      // 080: iload 5
      // 082: ifne 0a6
      // 085: invokestatic x/oc668fce0dbf.ά (F)Z
      // 088: ifeq 0a5
      // 08b: goto 08f
      // 08e: athrow
      // 08f: fload 7
      // 091: ldc_w 1.0E-4
      // 094: fcmpg
      // 095: iload 5
      // 097: ifne 0b6
      // 09a: goto 09e
      // 09d: athrow
      // 09e: ifgt 0a7
      // 0a1: goto 0a5
      // 0a4: athrow
      // 0a5: fload 3
      // 0a6: freturn
      // 0a7: bipush 1
      // 0a8: fload 6
      // 0aa: invokestatic java/lang/Math.abs (F)F
      // 0ad: fload 7
      // 0af: fdiv
      // 0b0: invokestatic java/lang/Math.round (F)I
      // 0b3: invokestatic java/lang/Math.max (II)I
      // 0b6: istore 8
      // 0b8: fload 6
      // 0ba: fconst_0
      // 0bb: fcmpg
      // 0bc: iload 5
      // 0be: ifne 0c9
      // 0c1: ifge 0cc
      // 0c4: goto 0c8
      // 0c7: athrow
      // 0c8: bipush -1
      // 0c9: goto 0cd
      // 0cc: bipush 1
      // 0cd: istore 9
      // 0cf: aload 4
      // 0d1: ifnonnull 0d9
      // 0d4: aconst_null
      // 0d5: goto 0df
      // 0d8: athrow
      // 0d9: aload 0
      // 0da: fload 2
      // 0db: fload 3
      // 0dc: invokevirtual x/oc668fce0dbf.ǒ (FF)Lnet/minecraft/util/MovingObjectPosition;
      // 0df: astore 10
      // 0e1: aload 4
      // 0e3: ifnull 0fd
      // 0e6: aload 10
      // 0e8: aload 4
      // 0ea: invokestatic x/oc668fce0dbf.ԣ (Lnet/minecraft/util/MovingObjectPosition;Lx/oc84f20a0bc5;)Z
      // 0ed: iload 5
      // 0ef: ifne 0fe
      // 0f2: goto 0f6
      // 0f5: athrow
      // 0f6: ifeq 101
      // 0f9: goto 0fd
      // 0fc: athrow
      // 0fd: bipush 1
      // 0fe: goto 102
      // 101: bipush 0
      // 102: istore 11
      // 104: bipush 0
      // 105: istore 12
      // 107: iload 12
      // 109: ldc_w -836374466
      // 10c: ldc_w -836374402
      // 10f: ixor
      // 110: if_icmpgt 23a
      // 113: iload 8
      // 115: iload 12
      // 117: isub
      // 118: istore 13
      // 11a: iload 8
      // 11c: iload 12
      // 11e: iadd
      // 11f: istore 14
      // 121: iload 12
      // 123: iload 5
      // 125: ifne 142
      // 128: ifne 13b
      // 12b: goto 12f
      // 12e: athrow
      // 12f: bipush 1
      // 130: newarray 10
      // 132: dup
      // 133: bipush 0
      // 134: iload 8
      // 136: iastore
      // 137: goto 14e
      // 13a: athrow
      // 13b: ldc_w -836374404
      // 13e: ldc_w -836374402
      // 141: ixor
      // 142: newarray 10
      // 144: dup
      // 145: bipush 0
      // 146: iload 13
      // 148: iastore
      // 149: dup
      // 14a: bipush 1
      // 14b: iload 14
      // 14d: iastore
      // 14e: astore 15
      // 150: aload 15
      // 152: astore 16
      // 154: aload 16
      // 156: arraylength
      // 157: istore 17
      // 159: bipush 0
      // 15a: istore 18
      // 15c: iload 18
      // 15e: iload 17
      // 160: if_icmpge 232
      // 163: aload 16
      // 165: iload 18
      // 167: iaload
      // 168: istore 19
      // 16a: iload 5
      // 16c: ifne 235
      // 16f: iload 19
      // 171: ifgt 181
      // 174: goto 178
      // 177: athrow
      // 178: iload 5
      // 17a: ifeq 22a
      // 17d: goto 181
      // 180: athrow
      // 181: fload 1
      // 182: iload 9
      // 184: iload 19
      // 186: imul
      // 187: i2f
      // 188: fload 7
      // 18a: fmul
      // 18b: fadd
      // 18c: ldc_w -90.0
      // 18f: ldc_w 90.0
      // 192: invokestatic net/minecraft/util/MathHelper.clamp_float (FFF)F
      // 195: fstore 20
      // 197: iload 5
      // 199: ifne 22d
      // 19c: fload 20
      // 19e: fload 1
      // 19f: fsub
      // 1a0: fstore 21
      // 1a2: fload 20
      // 1a4: invokestatic x/oc668fce0dbf.ά (F)Z
      // 1a7: ifeq 22a
      // 1aa: aload 0
      // 1ab: fload 20
      // 1ad: fload 1
      // 1ae: invokevirtual x/oc668fce0dbf.ӳ (FF)Z
      // 1b1: iload 5
      // 1b3: ifne 1d7
      // 1b6: goto 1ba
      // 1b9: athrow
      // 1ba: ifeq 22a
      // 1bd: goto 1c1
      // 1c0: athrow
      // 1c1: fload 21
      // 1c3: invokestatic java/lang/Math.abs (F)F
      // 1c6: iload 5
      // 1c8: ifne 1dc
      // 1cb: goto 1cf
      // 1ce: athrow
      // 1cf: ldc_w 0.15
      // 1d2: fcmpg
      // 1d3: goto 1d7
      // 1d6: athrow
      // 1d7: ifle 22a
      // 1da: fload 21
      // 1dc: aload 0
      // 1dd: getfield x/oc668fce0dbf.ľ J
      // 1e0: invokestatic x/oc3b42959d05.Ҳ (FJ)Z
      // 1e3: iload 5
      // 1e5: ifne 1fe
      // 1e8: ifeq 1f8
      // 1eb: goto 1ef
      // 1ee: athrow
      // 1ef: iload 5
      // 1f1: ifeq 22a
      // 1f4: goto 1f8
      // 1f7: athrow
      // 1f8: iload 11
      // 1fa: goto 1fe
      // 1fd: athrow
      // 1fe: ifeq 226
      // 201: aload 4
      // 203: ifnull 226
      // 206: goto 20a
      // 209: athrow
      // 20a: aload 0
      // 20b: fload 2
      // 20c: fload 20
      // 20e: invokevirtual x/oc668fce0dbf.ǒ (FF)Lnet/minecraft/util/MovingObjectPosition;
      // 211: aload 4
      // 213: invokestatic x/oc668fce0dbf.ԣ (Lnet/minecraft/util/MovingObjectPosition;Lx/oc84f20a0bc5;)Z
      // 216: ifne 226
      // 219: goto 21d
      // 21c: athrow
      // 21d: iload 5
      // 21f: ifeq 22a
      // 222: goto 226
      // 225: athrow
      // 226: fload 20
      // 228: freturn
      // 229: athrow
      // 22a: iinc 18 1
      // 22d: iload 5
      // 22f: ifeq 15c
      // 232: iinc 12 1
      // 235: iload 5
      // 237: ifeq 107
      // 23a: fload 3
      // 23b: freturn
   }

   private static float[] Ƅ(float var0, float var1, float var2, float var3) {
      float var4 = Math.abs(oc75d51ec7eb.Ӌ());
      float var5 = oc7beea7ccff.Ŧ(149.0F, var4);
      float var6 = MathHelper.wrapAngleTo180_float(var2 - var0);
      float var7 = var0 + oc7beea7ccff.ł(var6, var5);
      return oc75d51ec7eb.Ĩ(var7, var3, var0, var1);
   }

   static float ȁ(float param0, float param1, float param2, float param3, float param4, int param5) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: istore 6
      // 005: fload 0
      // 006: iload 6
      // 008: ifne 042
      // 00b: invokestatic x/oc668fce0dbf.ά (F)Z
      // 00e: ifeq 03d
      // 011: goto 015
      // 014: athrow
      // 015: fload 1
      // 016: iload 6
      // 018: ifne 042
      // 01b: goto 01f
      // 01e: athrow
      // 01f: invokestatic x/oc668fce0dbf.ά (F)Z
      // 022: ifeq 03d
      // 025: goto 029
      // 028: athrow
      // 029: fload 2
      // 02a: iload 6
      // 02c: ifne 049
      // 02f: goto 033
      // 032: athrow
      // 033: invokestatic x/oc668fce0dbf.ά (F)Z
      // 036: ifne 043
      // 039: goto 03d
      // 03c: athrow
      // 03d: fload 1
      // 03e: goto 042
      // 041: athrow
      // 042: freturn
      // 043: fload 1
      // 044: fload 0
      // 045: fsub
      // 046: invokestatic java/lang/Math.abs (F)F
      // 049: fstore 7
      // 04b: fload 7
      // 04d: iload 6
      // 04f: ifne 064
      // 052: fload 2
      // 053: invokestatic x/oc668fce0dbf.ʡ (FF)Z
      // 056: ifne 060
      // 059: goto 05d
      // 05c: athrow
      // 05d: fload 1
      // 05e: freturn
      // 05f: athrow
      // 060: fload 3
      // 061: invokestatic java/lang/Math.abs (F)F
      // 064: fstore 8
      // 066: fload 8
      // 068: iload 6
      // 06a: ifne 090
      // 06d: invokestatic x/oc668fce0dbf.ά (F)Z
      // 070: ifeq 08b
      // 073: goto 077
      // 076: athrow
      // 077: fload 8
      // 079: iload 6
      // 07b: ifne 098
      // 07e: goto 082
      // 081: athrow
      // 082: fconst_0
      // 083: fcmpg
      // 084: ifgt 091
      // 087: goto 08b
      // 08a: athrow
      // 08b: fload 1
      // 08c: goto 090
      // 08f: athrow
      // 090: freturn
      // 091: fload 4
      // 093: fload 8
      // 095: invokestatic x/oc7beea7ccff.Ŧ (FF)F
      // 098: fstore 9
      // 09a: iload 5
      // 09c: iload 6
      // 09e: ifne 0a9
      // 0a1: ifge 0ac
      // 0a4: goto 0a8
      // 0a7: athrow
      // 0a8: bipush -1
      // 0a9: goto 0ad
      // 0ac: bipush 1
      // 0ad: istore 10
      // 0af: ldc_w 1490630143
      // 0b2: ldc_w 1490630141
      // 0b5: ixor
      // 0b6: newarray 10
      // 0b8: dup
      // 0b9: bipush 0
      // 0ba: iload 10
      // 0bc: iastore
      // 0bd: dup
      // 0be: bipush 1
      // 0bf: iload 10
      // 0c1: ineg
      // 0c2: iastore
      // 0c3: astore 11
      // 0c5: aload 11
      // 0c7: arraylength
      // 0c8: istore 12
      // 0ca: bipush 0
      // 0cb: istore 13
      // 0cd: iload 13
      // 0cf: iload 12
      // 0d1: if_icmpge 14b
      // 0d4: aload 11
      // 0d6: iload 13
      // 0d8: iaload
      // 0d9: istore 14
      // 0db: fload 1
      // 0dc: iload 14
      // 0de: i2f
      // 0df: fload 8
      // 0e1: fmul
      // 0e2: fadd
      // 0e3: fstore 15
      // 0e5: fload 15
      // 0e7: iload 6
      // 0e9: ifne 14c
      // 0ec: fload 0
      // 0ed: fsub
      // 0ee: invokestatic java/lang/Math.abs (F)F
      // 0f1: fstore 16
      // 0f3: iload 6
      // 0f5: ifne 146
      // 0f8: fload 16
      // 0fa: fload 9
      // 0fc: fcmpl
      // 0fd: ifgt 143
      // 100: goto 104
      // 103: athrow
      // 104: fload 16
      // 106: iload 6
      // 108: ifne 142
      // 10b: goto 10f
      // 10e: athrow
      // 10f: fconst_2
      // 110: fcmpl
      // 111: ifle 13c
      // 114: goto 118
      // 117: athrow
      // 118: fload 16
      // 11a: fload 2
      // 11b: fsub
      // 11c: iload 6
      // 11e: ifne 142
      // 121: goto 125
      // 124: athrow
      // 125: invokestatic java/lang/Math.abs (F)F
      // 128: ldc_w 1.0E-4
      // 12b: fcmpg
      // 12c: ifge 13c
      // 12f: goto 133
      // 132: athrow
      // 133: iload 6
      // 135: ifeq 143
      // 138: goto 13c
      // 13b: athrow
      // 13c: fload 15
      // 13e: goto 142
      // 141: athrow
      // 142: freturn
      // 143: iinc 13 1
      // 146: iload 6
      // 148: ifeq 0cd
      // 14b: fload 1
      // 14c: freturn
   }

   private static boolean ʡ(float var0, float var1) {
      int var2 = oc84f20a0bc5.ė;
      int var3 = 1673834228 ^ -56255127;

      while (true) {
         switch (var3) {
            case -1621019747:
               int var9;
               label88: {
                  label87: {
                     try {
                        var9 = ά(var0);
                        if (var2 != 0) {
                           break label88;
                        }

                        if (var9 == 0) {
                           break label87;
                        }
                     } catch (ocbde1165e4e var7) {
                        throw var7;
                     }

                     var3 = -1934378348 ^ -56255127;
                     if (var2 == 0) {
                        continue;
                     }
                  }

                  var9 = 587944715 ^ -56255127;
               }

               var3 = var9;
               if (var2 == 0) {
                  continue;
               }
            case 1880500221:
               int var10;
               label75: {
                  label74: {
                     try {
                        var10 = ά(var1);
                        if (var2 != 0) {
                           break label75;
                        }

                        if (var10 == 0) {
                           break label74;
                        }
                     } catch (ocbde1165e4e var6) {
                        throw var6;
                     }

                     var3 = -2105195192 ^ -56255127;
                     if (var2 == 0) {
                        continue;
                     }
                  }

                  var10 = 587944715 ^ -56255127;
               }

               var3 = var10;
               if (var2 == 0) {
                  continue;
               }

               return true;
            case -542192030:
               return false;
            case 821052708:
               return true;
            case 1942393788:
               int var10000;
               label66: {
                  label65: {
                     try {
                        float var11;
                        var10000 = (var11 = Math.abs(var0 - var1) - 1.0E-4F) == 0.0F ? 0 : (var11 < 0.0F ? -1 : 1);
                        if (var2 != 0) {
                           break label66;
                        }

                        if (var10000 >= 0) {
                           break label65;
                        }
                     } catch (ocbde1165e4e var5) {
                        throw var5;
                     }

                     var3 = -866789299 ^ -56255127;
                     if (var2 == 0) {
                        continue;
                     }
                  }

                  var10000 = 587944715 ^ -56255127;
               }

               var3 = var10000;
               if (var2 == 0) {
                  continue;
               }
            case 2116081697:
               break;
            default:
               throw null;
         }

         int var8;
         label57: {
            label56: {
               try {
                  float var12;
                  var8 = (var12 = var0 - 2.0F) == 0.0F ? 0 : (var12 < 0.0F ? -1 : 1);
                  if (var2 != 0) {
                     break label57;
                  }

                  if (var8 <= 0) {
                     break label56;
                  }
               } catch (ocbde1165e4e var4) {
                  throw var4;
               }

               var3 = -1889333547 ^ -56255127;
               if (var2 == 0) {
                  continue;
               }
            }

            var8 = 587944715 ^ -56255127;
         }

         var3 = var8;
      }
   }

   @oc66fa4f2195
   public void ò(oc70db705765 param1) {
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
      // 005: invokevirtual x/oc668fce0dbf.Ü ()Z
      // 008: ifeq 00d
      // 00b: return
      // 00c: athrow
      // 00d: aload 1
      // 00e: ifnull 049
      // 011: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 014: iload 2
      // 015: ifne 026
      // 018: goto 01c
      // 01b: athrow
      // 01c: ifnull 049
      // 01f: goto 023
      // 022: athrow
      // 023: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 026: iload 2
      // 027: ifne 03b
      // 02a: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 02d: ifnull 049
      // 030: goto 034
      // 033: athrow
      // 034: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 037: goto 03b
      // 03a: athrow
      // 03b: iload 2
      // 03c: ifne 055
      // 03f: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 042: ifnonnull 052
      // 045: goto 049
      // 048: athrow
      // 049: aload 0
      // 04a: getfield x/oc668fce0dbf.Ȉ Lx/oc41ddc58b4a;
      // 04d: invokevirtual x/oc41ddc58b4a.Ď ()V
      // 050: return
      // 051: athrow
      // 052: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 055: iload 2
      // 056: ifne 06a
      // 059: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 05c: ifnull 082
      // 05f: goto 063
      // 062: athrow
      // 063: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 066: goto 06a
      // 069: athrow
      // 06a: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 06d: getfield net/minecraft/client/settings/GameSettings.keyBindSneak Lnet/minecraft/client/settings/KeyBinding;
      // 070: invokestatic x/oc7ab2161b9f.ն (Lnet/minecraft/client/settings/KeyBinding;)Z
      // 073: iload 2
      // 074: ifne 07f
      // 077: ifeq 082
      // 07a: goto 07e
      // 07d: athrow
      // 07e: bipush 1
      // 07f: goto 083
      // 082: bipush 0
      // 083: istore 3
      // 084: aload 0
      // 085: getfield x/oc668fce0dbf.Ȉ Lx/oc41ddc58b4a;
      // 088: aload 0
      // 089: invokevirtual x/oc668fce0dbf.getInfo ()Ljava/lang/String;
      // 08c: iload 3
      // 08d: iload 2
      // 08e: ifne 0a3
      // 091: ifeq 09f
      // 094: goto 098
      // 097: athrow
      // 098: ldc_w "/physical Shift"
      // 09b: goto 0b0
      // 09e: athrow
      // 09f: aload 1
      // 0a0: invokevirtual x/oc70db705765.ҧ ()Z
      // 0a3: ifeq 0ad
      // 0a6: ldc_w "/pre-existing input"
      // 0a9: goto 0b0
      // 0ac: athrow
      // 0ad: ldc_w "/none"
      // 0b0: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 0b5: aload 1
      // 0b6: invokevirtual x/oc70db705765.ҧ ()Z
      // 0b9: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0bc: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0bf: getfield net/minecraft/client/entity/EntityPlayerSP.onGround Z
      // 0c2: invokevirtual x/oc41ddc58b4a.Ν (Ljava/lang/String;ZZ)V
      // 0c5: aload 0
      // 0c6: iload 2
      // 0c7: ifne 0d7
      // 0ca: invokevirtual x/oc668fce0dbf.ʉ ()Z
      // 0cd: ifeq 0d6
      // 0d0: goto 0d4
      // 0d3: athrow
      // 0d4: return
      // 0d5: athrow
      // 0d6: aload 0
      // 0d7: iload 2
      // 0d8: ifne 0ff
      // 0db: invokevirtual x/oc668fce0dbf.Ɯ ()Z
      // 0de: ifeq 0fe
      // 0e1: goto 0e5
      // 0e4: athrow
      // 0e5: aload 0
      // 0e6: getfield x/oc668fce0dbf.Ȉ Lx/oc41ddc58b4a;
      // 0e9: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0ec: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0ef: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0f2: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 0f5: aload 1
      // 0f6: iload 3
      // 0f7: invokevirtual x/oc41ddc58b4a.ɱ (Lnet/minecraft/client/entity/EntityPlayerSP;Lnet/minecraft/client/multiplayer/WorldClient;Lx/oc70db705765;Z)V
      // 0fa: goto 0fe
      // 0fd: athrow
      // 0fe: aload 0
      // 0ff: iload 2
      // 100: ifne 12a
      // 103: invokevirtual x/oc668fce0dbf.ȷ ()Z
      // 106: ifeq 125
      // 109: goto 10d
      // 10c: athrow
      // 10d: aload 0
      // 10e: getfield x/oc668fce0dbf.Ќ Lx/ocbce5ea28a3;
      // 111: aload 1
      // 112: aload 0
      // 113: invokevirtual x/oc668fce0dbf.ϝ ()Z
      // 116: aload 0
      // 117: invokevirtual x/oc668fce0dbf.Ȅ ()I
      // 11a: invokevirtual x/ocbce5ea28a3.O (Lx/oc70db705765;ZI)V
      // 11d: iload 2
      // 11e: ifeq 153
      // 121: goto 125
      // 124: athrow
      // 125: aload 0
      // 126: goto 12a
      // 129: athrow
      // 12a: iload 2
      // 12b: ifne 13d
      // 12e: invokevirtual x/oc668fce0dbf.ɣ ()Z
      // 131: ifeq 153
      // 134: goto 138
      // 137: athrow
      // 138: aload 0
      // 139: goto 13d
      // 13c: athrow
      // 13d: getfield x/oc668fce0dbf.ӱ Lx/oc3b42959d05;
      // 140: aload 1
      // 141: aload 0
      // 142: getfield x/oc668fce0dbf.f Lx/occ2f8dff8d8;
      // 145: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 148: aload 0
      // 149: invokevirtual x/oc668fce0dbf.ϝ ()Z
      // 14c: aload 0
      // 14d: invokevirtual x/oc668fce0dbf.Ȅ ()I
      // 150: invokevirtual x/oc3b42959d05.Ϭ (Lx/oc70db705765;ZZI)V
      // 153: return
   }

   @oc66fa4f2195
   public void ō(ocf242f30eaa param1) {
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
      // 09: invokevirtual x/oc668fce0dbf.Ü ()Z
      // 0c: ifeq 15
      // 0f: goto 13
      // 12: athrow
      // 13: return
      // 14: athrow
      // 15: aload 0
      // 16: iload 2
      // 17: ifne 27
      // 1a: invokevirtual x/oc668fce0dbf.ʉ ()Z
      // 1d: ifeq 26
      // 20: goto 24
      // 23: athrow
      // 24: return
      // 25: athrow
      // 26: aload 0
      // 27: iload 2
      // 28: ifne 40
      // 2b: invokevirtual x/oc668fce0dbf.ȷ ()Z
      // 2e: ifeq 3f
      // 31: goto 35
      // 34: athrow
      // 35: aload 0
      // 36: getfield x/oc668fce0dbf.Ќ Lx/ocbce5ea28a3;
      // 39: aload 1
      // 3a: invokevirtual x/ocbce5ea28a3.Յ (Lx/ocf242f30eaa;)V
      // 3d: return
      // 3e: athrow
      // 3f: aload 0
      // 40: iload 2
      // 41: ifne 53
      // 44: invokevirtual x/oc668fce0dbf.ɣ ()Z
      // 47: ifeq 5b
      // 4a: goto 4e
      // 4d: athrow
      // 4e: aload 0
      // 4f: goto 53
      // 52: athrow
      // 53: getfield x/oc668fce0dbf.ӱ Lx/oc3b42959d05;
      // 56: aload 1
      // 57: invokevirtual x/oc3b42959d05.ƅ (Lx/ocf242f30eaa;)V
      // 5a: return
      // 5b: getstatic x/oc668fce0dbf.ӧ Lx/oc7beea7ccff;
      // 5e: aload 1
      // 5f: aload 0
      // 60: invokevirtual x/oc668fce0dbf.Ȃ ()F
      // 63: invokevirtual x/oc7beea7ccff.Ҿ (Lx/ocf242f30eaa;F)V
      // 66: return
   }

   @oc66fa4f2195
   public void ŝ(oc52918cda9d param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
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
      // 018: invokevirtual x/oc668fce0dbf.Ü ()Z
      // 01b: goto 01f
      // 01e: athrow
      // 01f: ifeq 023
      // 022: return
      // 023: aload 0
      // 024: invokevirtual x/oc668fce0dbf.Ã ()V
      // 027: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 02a: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 02d: getfield net/minecraft/client/entity/EntityPlayerSP.movementInput Lnet/minecraft/util/MovementInput;
      // 030: getfield net/minecraft/util/MovementInput.jump Z
      // 033: iload 2
      // 034: ifne 052
      // 037: ifne 051
      // 03a: goto 03e
      // 03d: athrow
      // 03e: aload 0
      // 03f: invokevirtual x/oc668fce0dbf.Ѱ ()Z
      // 042: iload 2
      // 043: ifne 052
      // 046: goto 04a
      // 049: athrow
      // 04a: ifeq 055
      // 04d: goto 051
      // 050: athrow
      // 051: bipush 1
      // 052: goto 056
      // 055: bipush 0
      // 056: istore 3
      // 057: new x/ocf242f30eaa
      // 05a: dup
      // 05b: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 05e: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 061: getfield net/minecraft/client/entity/EntityPlayerSP.movementInput Lnet/minecraft/util/MovementInput;
      // 064: getfield net/minecraft/util/MovementInput.moveForward F
      // 067: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 06a: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 06d: getfield net/minecraft/client/entity/EntityPlayerSP.movementInput Lnet/minecraft/util/MovementInput;
      // 070: getfield net/minecraft/util/MovementInput.moveStrafe F
      // 073: iload 3
      // 074: invokespecial x/ocf242f30eaa.<init> (FFZ)V
      // 077: astore 4
      // 079: getstatic x/ocea775c9d5c.ų Lx/oc04596227b7;
      // 07c: aload 4
      // 07e: invokevirtual x/oc04596227b7.post (Lx/oc68d6b191af;)Z
      // 081: pop
      // 082: aload 0
      // 083: invokevirtual x/oc668fce0dbf.ʉ ()Z
      // 086: istore 5
      // 088: iload 5
      // 08a: iload 2
      // 08b: ifne 0eb
      // 08e: ifne 0e9
      // 091: goto 095
      // 094: athrow
      // 095: aload 0
      // 096: invokevirtual x/oc668fce0dbf.Ɯ ()Z
      // 099: iload 2
      // 09a: ifne 0eb
      // 09d: goto 0a1
      // 0a0: athrow
      // 0a1: ifeq 0e9
      // 0a4: goto 0a8
      // 0a7: athrow
      // 0a8: aload 0
      // 0a9: getfield x/oc668fce0dbf.Ȉ Lx/oc41ddc58b4a;
      // 0ac: invokevirtual x/oc41ddc58b4a.ҽ ()Z
      // 0af: iload 2
      // 0b0: ifne 0eb
      // 0b3: goto 0b7
      // 0b6: athrow
      // 0b7: ifeq 0e9
      // 0ba: goto 0be
      // 0bd: athrow
      // 0be: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0c1: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0c4: getfield net/minecraft/client/entity/EntityPlayerSP.movementInput Lnet/minecraft/util/MovementInput;
      // 0c7: getfield net/minecraft/util/MovementInput.sneak Z
      // 0ca: iload 2
      // 0cb: ifne 0eb
      // 0ce: goto 0d2
      // 0d1: athrow
      // 0d2: ifne 0e9
      // 0d5: goto 0d9
      // 0d8: athrow
      // 0d9: aload 4
      // 0db: fconst_0
      // 0dc: invokevirtual x/ocf242f30eaa.ў (F)V
      // 0df: aload 4
      // 0e1: fconst_0
      // 0e2: invokevirtual x/ocf242f30eaa.I (F)V
      // 0e5: goto 0e9
      // 0e8: athrow
      // 0e9: iload 5
      // 0eb: iload 2
      // 0ec: ifne 118
      // 0ef: ifne 116
      // 0f2: goto 0f6
      // 0f5: athrow
      // 0f6: aload 0
      // 0f7: invokevirtual x/oc668fce0dbf.ȷ ()Z
      // 0fa: iload 2
      // 0fb: ifne 118
      // 0fe: goto 102
      // 101: athrow
      // 102: ifeq 116
      // 105: goto 109
      // 108: athrow
      // 109: aload 0
      // 10a: getfield x/oc668fce0dbf.Ќ Lx/ocbce5ea28a3;
      // 10d: aload 4
      // 10f: invokevirtual x/ocbce5ea28a3.Ӯ (Lx/ocf242f30eaa;)V
      // 112: goto 116
      // 115: athrow
      // 116: iload 5
      // 118: iload 2
      // 119: ifne 133
      // 11c: ifne 151
      // 11f: goto 123
      // 122: athrow
      // 123: aload 0
      // 124: iload 2
      // 125: ifne 137
      // 128: goto 12c
      // 12b: athrow
      // 12c: invokevirtual x/oc668fce0dbf.ȷ ()Z
      // 12f: goto 133
      // 132: athrow
      // 133: ifeq 151
      // 136: aload 0
      // 137: getfield x/oc668fce0dbf.Ќ Lx/ocbce5ea28a3;
      // 13a: aload 4
      // 13c: invokevirtual x/ocf242f30eaa.ǡ ()Z
      // 13f: invokevirtual x/ocbce5ea28a3.ȶ (Z)Z
      // 142: iload 2
      // 143: ifne 14e
      // 146: ifeq 151
      // 149: goto 14d
      // 14c: athrow
      // 14d: bipush 1
      // 14e: goto 152
      // 151: bipush 0
      // 152: istore 6
      // 154: iload 2
      // 155: ifne 1ac
      // 158: aload 4
      // 15a: invokevirtual x/oc68d6b191af.isCanceled ()Z
      // 15d: ifeq 186
      // 160: goto 164
      // 163: athrow
      // 164: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 167: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 16a: getfield net/minecraft/client/entity/EntityPlayerSP.movementInput Lnet/minecraft/util/MovementInput;
      // 16d: fconst_0
      // 16e: putfield net/minecraft/util/MovementInput.moveForward F
      // 171: iload 2
      // 172: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 175: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 178: getfield net/minecraft/client/entity/EntityPlayerSP.movementInput Lnet/minecraft/util/MovementInput;
      // 17b: fconst_0
      // 17c: putfield net/minecraft/util/MovementInput.moveStrafe F
      // 17f: ifeq 1fb
      // 182: goto 186
      // 185: athrow
      // 186: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 189: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 18c: getfield net/minecraft/client/entity/EntityPlayerSP.movementInput Lnet/minecraft/util/MovementInput;
      // 18f: aload 4
      // 191: invokevirtual x/ocf242f30eaa.Α ()F
      // 194: putfield net/minecraft/util/MovementInput.moveForward F
      // 197: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 19a: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 19d: getfield net/minecraft/client/entity/EntityPlayerSP.movementInput Lnet/minecraft/util/MovementInput;
      // 1a0: aload 4
      // 1a2: invokevirtual x/ocf242f30eaa.Υ ()F
      // 1a5: putfield net/minecraft/util/MovementInput.moveStrafe F
      // 1a8: goto 1ac
      // 1ab: athrow
      // 1ac: aload 0
      // 1ad: aload 4
      // 1af: invokevirtual x/oc668fce0dbf.Ɛ (Lx/ocf242f30eaa;)Z
      // 1b2: iload 2
      // 1b3: ifne 1c9
      // 1b6: ifeq 1c7
      // 1b9: goto 1bd
      // 1bc: athrow
      // 1bd: aload 4
      // 1bf: bipush 1
      // 1c0: invokevirtual x/ocf242f30eaa.ќ (Z)V
      // 1c3: goto 1c7
      // 1c6: athrow
      // 1c7: iload 5
      // 1c9: iload 2
      // 1ca: ifne 1dc
      // 1cd: ifne 1ea
      // 1d0: goto 1d4
      // 1d3: athrow
      // 1d4: aload 0
      // 1d5: invokevirtual x/oc668fce0dbf.ȷ ()Z
      // 1d8: goto 1dc
      // 1db: athrow
      // 1dc: ifeq 1ea
      // 1df: aload 4
      // 1e1: iload 6
      // 1e3: invokevirtual x/ocf242f30eaa.ќ (Z)V
      // 1e6: goto 1ea
      // 1e9: athrow
      // 1ea: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1ed: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1f0: getfield net/minecraft/client/entity/EntityPlayerSP.movementInput Lnet/minecraft/util/MovementInput;
      // 1f3: aload 4
      // 1f5: invokevirtual x/ocf242f30eaa.ǡ ()Z
      // 1f8: putfield net/minecraft/util/MovementInput.jump Z
      // 1fb: return
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.LOWEST
   )
   public void Ȱ(oc52918cda9d var1) {
      int var2 = oc84f20a0bc5.ė;

      boolean var10000;
      label26: {
         try {
            var10000 = this.Ü();
            if (var2 != 0) {
               break label26;
            }

            if (!var10000) {
               return;
            }
         } catch (ocbde1165e4e var4) {
            throw var4;
         }

         var10000 = oc7ab2161b9f.Ð();
      }

      try {
         if (var10000) {
            this.ū.ʗ();
         }
      } catch (ocbde1165e4e var3) {
         throw var3;
      }
   }

   private boolean Ѱ() {
      int var1 = oc84f20a0bc5.ė;
      int var2 = 592761373 ^ 1498326254;

      while (true) {
         switch (var2) {
            case -1315574396:
               return true;
            case -25500836:
               if (oc69da1aa7f5.ő.gameSettings != null) {
                  var2 = -554299884 ^ 1498326254;
                  if (var1 == 0) {
                     break;
                  }
               }

               var2 = 1065139675 ^ 1498326254;
               if (var1 == 0) {
                  break;
               }
            case 2048554739:
               int var10000;
               label64: {
                  label63: {
                     try {
                        var10000 = oc69da1aa7f5.ő.inGameHasFocus;
                        if (var1 != 0) {
                           break label64;
                        }

                        if (!oc69da1aa7f5.ő.inGameHasFocus) {
                           break label63;
                        }
                     } catch (ocbde1165e4e var4) {
                        throw var4;
                     }

                     var2 = 118166700 ^ 1498326254;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var10000 = 1065139675 ^ 1498326254;
               }

               var2 = var10000;
               if (var1 == 0) {
                  break;
               }
            case -2017940742:
               int var5;
               label52: {
                  label51: {
                     try {
                        var5 = oc69da1aa7f5.ő.gameSettings.keyBindJump.isPressed();
                        if (var1 != 0) {
                           break label52;
                        }

                        if (var5 == 0) {
                           break label51;
                        }
                     } catch (ocbde1165e4e var3) {
                        throw var3;
                     }

                     var2 = -388282006 ^ 1498326254;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var5 = 1065139675 ^ 1498326254;
               }

               var2 = var5;
               if (var1 == 0) {
                  break;
               }

               return true;
            case 1581625410:
               if (oc69da1aa7f5.ő.currentScreen == null) {
                  var2 = -1489745998 ^ 1498326254;
                  if (var1 == 0) {
                     break;
                  }
               }

               var2 = 1065139675 ^ 1498326254;
               if (var1 == 0) {
                  break;
               }

               return false;
            case 1714559285:
               return false;
            default:
               throw null;
         }
      }
   }

   @oc66fa4f2195
   public void Ŝ(oc1059074ce8 param1) {
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
      // 006: ifne 01d
      // 009: invokevirtual x/oc668fce0dbf.Ü ()Z
      // 00c: ifeq 01c
      // 00f: goto 013
      // 012: athrow
      // 013: aload 0
      // 014: getfield x/oc668fce0dbf.ū Lx/oc11364ce42a;
      // 017: invokevirtual x/oc11364ce42a.Ͱ ()V
      // 01a: return
      // 01b: athrow
      // 01c: aload 0
      // 01d: iload 2
      // 01e: ifne 07f
      // 021: invokevirtual x/oc668fce0dbf.ʉ ()Z
      // 024: ifeq 07e
      // 027: goto 02b
      // 02a: athrow
      // 02b: aload 0
      // 02c: iload 2
      // 02d: ifne 047
      // 030: goto 034
      // 033: athrow
      // 034: getfield x/oc668fce0dbf.ʪ Lx/oca9cc61aada;
      // 037: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 03a: d2i
      // 03b: ifeq 073
      // 03e: goto 042
      // 041: athrow
      // 042: aload 0
      // 043: goto 047
      // 046: athrow
      // 047: invokevirtual x/oc668fce0dbf.ˁ ()Z
      // 04a: iload 2
      // 04b: ifne 070
      // 04e: ifeq 073
      // 051: goto 055
      // 054: athrow
      // 055: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 058: iload 2
      // 059: ifne 076
      // 05c: goto 060
      // 05f: athrow
      // 060: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 063: getfield net/minecraft/client/entity/EntityPlayerSP.movementInput Lnet/minecraft/util/MovementInput;
      // 066: getfield net/minecraft/util/MovementInput.moveForward F
      // 069: invokestatic x/oc668fce0dbf.Ÿ (F)Z
      // 06c: goto 070
      // 06f: athrow
      // 070: ifne 07d
      // 073: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 076: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 079: bipush 0
      // 07a: invokevirtual net/minecraft/client/entity/EntityPlayerSP.setSprinting (Z)V
      // 07d: return
      // 07e: aload 0
      // 07f: iload 2
      // 080: ifne 0ff
      // 083: invokevirtual x/oc668fce0dbf.ȷ ()Z
      // 086: ifeq 0fe
      // 089: goto 08d
      // 08c: athrow
      // 08d: aload 0
      // 08e: iload 2
      // 08f: ifne 0a9
      // 092: goto 096
      // 095: athrow
      // 096: getfield x/oc668fce0dbf.ʪ Lx/oca9cc61aada;
      // 099: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 09c: d2i
      // 09d: ifeq 0ba
      // 0a0: goto 0a4
      // 0a3: athrow
      // 0a4: aload 0
      // 0a5: goto 0a9
      // 0a8: athrow
      // 0a9: iload 2
      // 0aa: ifne 0d1
      // 0ad: getfield x/oc668fce0dbf.Ќ Lx/ocbce5ea28a3;
      // 0b0: invokevirtual x/ocbce5ea28a3.ʷ ()Z
      // 0b3: ifne 0cc
      // 0b6: goto 0ba
      // 0b9: athrow
      // 0ba: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0bd: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0c0: bipush 0
      // 0c1: invokevirtual net/minecraft/client/entity/EntityPlayerSP.setSprinting (Z)V
      // 0c4: iload 2
      // 0c5: ifeq 0ed
      // 0c8: goto 0cc
      // 0cb: athrow
      // 0cc: aload 0
      // 0cd: goto 0d1
      // 0d0: athrow
      // 0d1: iload 2
      // 0d2: ifne 0ee
      // 0d5: invokevirtual x/oc668fce0dbf.ˁ ()Z
      // 0d8: ifeq 0ed
      // 0db: goto 0df
      // 0de: athrow
      // 0df: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0e2: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0e5: bipush 1
      // 0e6: invokevirtual net/minecraft/client/entity/EntityPlayerSP.setSprinting (Z)V
      // 0e9: goto 0ed
      // 0ec: athrow
      // 0ed: aload 0
      // 0ee: getfield x/oc668fce0dbf.Ќ Lx/ocbce5ea28a3;
      // 0f1: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0f4: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0f7: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isSprinting ()Z
      // 0fa: invokevirtual x/ocbce5ea28a3.È (Z)V
      // 0fd: return
      // 0fe: aload 0
      // 0ff: iload 2
      // 100: ifne 177
      // 103: invokevirtual x/oc668fce0dbf.ɣ ()Z
      // 106: ifeq 176
      // 109: goto 10d
      // 10c: athrow
      // 10d: aload 0
      // 10e: iload 2
      // 10f: ifne 129
      // 112: goto 116
      // 115: athrow
      // 116: getfield x/oc668fce0dbf.ʪ Lx/oca9cc61aada;
      // 119: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 11c: d2i
      // 11d: ifeq 155
      // 120: goto 124
      // 123: athrow
      // 124: aload 0
      // 125: goto 129
      // 128: athrow
      // 129: invokevirtual x/oc668fce0dbf.ˁ ()Z
      // 12c: iload 2
      // 12d: ifne 152
      // 130: ifeq 155
      // 133: goto 137
      // 136: athrow
      // 137: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 13a: iload 2
      // 13b: ifne 16e
      // 13e: goto 142
      // 141: athrow
      // 142: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 145: getfield net/minecraft/client/entity/EntityPlayerSP.movementInput Lnet/minecraft/util/MovementInput;
      // 148: getfield net/minecraft/util/MovementInput.moveForward F
      // 14b: invokestatic x/oc668fce0dbf.Ÿ (F)Z
      // 14e: goto 152
      // 151: athrow
      // 152: ifne 167
      // 155: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 158: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 15b: bipush 0
      // 15c: invokevirtual net/minecraft/client/entity/EntityPlayerSP.setSprinting (Z)V
      // 15f: iload 2
      // 160: ifeq 175
      // 163: goto 167
      // 166: athrow
      // 167: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 16a: goto 16e
      // 16d: athrow
      // 16e: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 171: bipush 1
      // 172: invokevirtual net/minecraft/client/entity/EntityPlayerSP.setSprinting (Z)V
      // 175: return
      // 176: aload 0
      // 177: iload 2
      // 178: ifne 196
      // 17b: getfield x/oc668fce0dbf.ʪ Lx/oca9cc61aada;
      // 17e: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 181: d2i
      // 182: ifne 195
      // 185: goto 189
      // 188: athrow
      // 189: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 18c: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 18f: bipush 0
      // 190: invokevirtual net/minecraft/client/entity/EntityPlayerSP.setSprinting (Z)V
      // 193: return
      // 194: athrow
      // 195: aload 0
      // 196: invokevirtual x/oc668fce0dbf.ˁ ()Z
      // 199: iload 2
      // 19a: ifne 1bc
      // 19d: ifne 1a5
      // 1a0: goto 1a4
      // 1a3: athrow
      // 1a4: return
      // 1a5: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1a8: iload 2
      // 1a9: ifne 1d8
      // 1ac: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1af: getfield net/minecraft/client/entity/EntityPlayerSP.movementInput Lnet/minecraft/util/MovementInput;
      // 1b2: getfield net/minecraft/util/MovementInput.moveForward F
      // 1b5: invokestatic x/oc668fce0dbf.Ÿ (F)Z
      // 1b8: goto 1bc
      // 1bb: athrow
      // 1bc: ifeq 1d1
      // 1bf: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1c2: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1c5: bipush 1
      // 1c6: invokevirtual net/minecraft/client/entity/EntityPlayerSP.setSprinting (Z)V
      // 1c9: iload 2
      // 1ca: ifeq 1df
      // 1cd: goto 1d1
      // 1d0: athrow
      // 1d1: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1d4: goto 1d8
      // 1d7: athrow
      // 1d8: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1db: bipush 0
      // 1dc: invokevirtual net/minecraft/client/entity/EntityPlayerSP.setSprinting (Z)V
      // 1df: return
   }

   @oc66fa4f2195
   public void ы(oca27090789a param1) {
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
      // 09: invokevirtual x/oc668fce0dbf.ʉ ()Z
      // 0c: ifeq 15
      // 0f: goto 13
      // 12: athrow
      // 13: return
      // 14: athrow
      // 15: aload 0
      // 16: iload 2
      // 17: ifne 29
      // 1a: invokevirtual x/oc668fce0dbf.ɣ ()Z
      // 1d: ifeq 2f
      // 20: goto 24
      // 23: athrow
      // 24: aload 0
      // 25: goto 29
      // 28: athrow
      // 29: getfield x/oc668fce0dbf.ӱ Lx/oc3b42959d05;
      // 2c: invokevirtual x/oc3b42959d05.ɶ ()V
      // 2f: return
   }

   @oc66fa4f2195
   public void á(oc479681b341 param1) {
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
      // 06: ifne 31
      // 09: invokevirtual x/oc668fce0dbf.Ü ()Z
      // 0c: ifeq 30
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: iload 2
      // 15: ifne 31
      // 18: goto 1c
      // 1b: athrow
      // 1c: getfield x/oc668fce0dbf.ū Lx/oc11364ce42a;
      // 1f: invokevirtual x/oc11364ce42a.ġ ()Z
      // 22: ifeq 30
      // 25: goto 29
      // 28: athrow
      // 29: aload 1
      // 2a: bipush 1
      // 2b: invokevirtual x/oc68d6b191af.setCanceled (Z)V
      // 2e: return
      // 2f: athrow
      // 30: aload 0
      // 31: iload 2
      // 32: ifne 44
      // 35: invokevirtual x/oc668fce0dbf.ճ ()Z
      // 38: ifeq 6c
      // 3b: goto 3f
      // 3e: athrow
      // 3f: aload 0
      // 40: goto 44
      // 43: athrow
      // 44: getfield x/oc668fce0dbf.Ы Lx/occ2f8dff8d8;
      // 47: iload 2
      // 48: ifne 5d
      // 4b: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 4e: ifeq 6c
      // 51: goto 55
      // 54: athrow
      // 55: aload 0
      // 56: getfield x/oc668fce0dbf.ʖ Lx/occ2f8dff8d8;
      // 59: goto 5d
      // 5c: athrow
      // 5d: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 60: ifeq 6c
      // 63: aload 1
      // 64: bipush 1
      // 65: invokevirtual x/oc68d6b191af.setCanceled (Z)V
      // 68: goto 6c
      // 6b: athrow
      // 6c: return
   }

   @oc66fa4f2195
   public void y(MouseEvent param1) {
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
      // 09: invokevirtual x/oc668fce0dbf.Ü ()Z
      // 0c: ifeq 41
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: goto 18
      // 17: athrow
      // 18: getfield x/oc668fce0dbf.ū Lx/oc11364ce42a;
      // 1b: invokevirtual x/oc11364ce42a.ġ ()Z
      // 1e: iload 2
      // 1f: ifne 39
      // 22: ifeq 41
      // 25: goto 29
      // 28: athrow
      // 29: aload 1
      // 2a: iload 2
      // 2b: ifne 3d
      // 2e: goto 32
      // 31: athrow
      // 32: getfield x/MouseEvent.buttonstate Z
      // 35: goto 39
      // 38: athrow
      // 39: ifeq 41
      // 3c: aload 1
      // 3d: bipush 1
      // 3e: invokevirtual x/oc68d6b191af.setCanceled (Z)V
      // 41: return
   }

   @oc66fa4f2195
   public void Ϫ(oc55585a6f85 param1) {
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
      // 06: ifne 48
      // 09: invokevirtual x/oc668fce0dbf.Ü ()Z
      // 0c: ifeq 47
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: getfield x/oc668fce0dbf.ū Lx/oc11364ce42a;
      // 17: invokevirtual x/oc11364ce42a.ġ ()Z
      // 1a: iload 2
      // 1b: ifne 34
      // 1e: goto 22
      // 21: athrow
      // 22: ifeq 46
      // 25: goto 29
      // 28: athrow
      // 29: invokestatic x/ocbb165642ef.ʨ ()Lx/ocbb165642ef;
      // 2c: aload 0
      // 2d: invokevirtual x/ocbb165642ef.D (Ljava/lang/Object;)Z
      // 30: goto 34
      // 33: athrow
      // 34: ifeq 46
      // 37: aload 1
      // 38: aload 0
      // 39: getfield x/oc668fce0dbf.ū Lx/oc11364ce42a;
      // 3c: invokevirtual x/oc11364ce42a.ǭ ()F
      // 3f: invokevirtual x/oc55585a6f85.Ě (F)V
      // 42: goto 46
      // 45: athrow
      // 46: return
      // 47: aload 0
      // 48: iload 2
      // 49: ifne 59
      // 4c: invokevirtual x/oc668fce0dbf.ʉ ()Z
      // 4f: ifeq 58
      // 52: goto 56
      // 55: athrow
      // 56: return
      // 57: athrow
      // 58: aload 0
      // 59: iload 2
      // 5a: ifne 72
      // 5d: invokevirtual x/oc668fce0dbf.ȷ ()Z
      // 60: ifeq 71
      // 63: goto 67
      // 66: athrow
      // 67: aload 0
      // 68: getfield x/oc668fce0dbf.Ќ Lx/ocbce5ea28a3;
      // 6b: aload 1
      // 6c: invokevirtual x/ocbce5ea28a3.Ʈ (Lx/oc55585a6f85;)V
      // 6f: return
      // 70: athrow
      // 71: aload 0
      // 72: iload 2
      // 73: ifne 85
      // 76: invokevirtual x/oc668fce0dbf.ɣ ()Z
      // 79: ifeq 8d
      // 7c: goto 80
      // 7f: athrow
      // 80: aload 0
      // 81: goto 85
      // 84: athrow
      // 85: getfield x/oc668fce0dbf.ӱ Lx/oc3b42959d05;
      // 88: aload 1
      // 89: invokevirtual x/oc3b42959d05.Լ (Lx/oc55585a6f85;)V
      // 8c: return
      // 8d: getstatic x/oc668fce0dbf.ӧ Lx/oc7beea7ccff;
      // 90: aload 1
      // 91: aload 0
      // 92: invokevirtual x/oc668fce0dbf.Ȃ ()F
      // 95: invokevirtual x/oc7beea7ccff.Ƀ (Lx/oc55585a6f85;F)V
      // 98: return
   }

   @oc66fa4f2195
   public void Ը(oc4c5a4d3446 param1) {
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
      // 06: ifne 48
      // 09: invokevirtual x/oc668fce0dbf.Ü ()Z
      // 0c: ifeq 47
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: getfield x/oc668fce0dbf.ū Lx/oc11364ce42a;
      // 17: invokevirtual x/oc11364ce42a.ġ ()Z
      // 1a: iload 2
      // 1b: ifne 34
      // 1e: goto 22
      // 21: athrow
      // 22: ifeq 46
      // 25: goto 29
      // 28: athrow
      // 29: invokestatic x/ocbb165642ef.ʨ ()Lx/ocbb165642ef;
      // 2c: aload 0
      // 2d: invokevirtual x/ocbb165642ef.D (Ljava/lang/Object;)Z
      // 30: goto 34
      // 33: athrow
      // 34: ifeq 46
      // 37: aload 1
      // 38: aload 0
      // 39: getfield x/oc668fce0dbf.ū Lx/oc11364ce42a;
      // 3c: invokevirtual x/oc11364ce42a.ǭ ()F
      // 3f: invokevirtual x/oc4c5a4d3446.Ŗ (F)V
      // 42: goto 46
      // 45: athrow
      // 46: return
      // 47: aload 0
      // 48: iload 2
      // 49: ifne 59
      // 4c: invokevirtual x/oc668fce0dbf.ʉ ()Z
      // 4f: ifeq 58
      // 52: goto 56
      // 55: athrow
      // 56: return
      // 57: athrow
      // 58: aload 0
      // 59: iload 2
      // 5a: ifne 72
      // 5d: invokevirtual x/oc668fce0dbf.ȷ ()Z
      // 60: ifeq 71
      // 63: goto 67
      // 66: athrow
      // 67: aload 0
      // 68: getfield x/oc668fce0dbf.Ќ Lx/ocbce5ea28a3;
      // 6b: aload 1
      // 6c: invokevirtual x/ocbce5ea28a3.ε (Lx/oc4c5a4d3446;)V
      // 6f: return
      // 70: athrow
      // 71: aload 0
      // 72: iload 2
      // 73: ifne 85
      // 76: invokevirtual x/oc668fce0dbf.ɣ ()Z
      // 79: ifeq 8d
      // 7c: goto 80
      // 7f: athrow
      // 80: aload 0
      // 81: goto 85
      // 84: athrow
      // 85: getfield x/oc668fce0dbf.ӱ Lx/oc3b42959d05;
      // 88: aload 1
      // 89: invokevirtual x/oc3b42959d05.Ϋ (Lx/oc4c5a4d3446;)V
      // 8c: return
      // 8d: getstatic x/oc668fce0dbf.ӧ Lx/oc7beea7ccff;
      // 90: aload 1
      // 91: aload 0
      // 92: invokevirtual x/oc668fce0dbf.Ȃ ()F
      // 95: invokevirtual x/oc7beea7ccff.Ʉ (Lx/oc4c5a4d3446;F)V
      // 98: return
   }

   @oc66fa4f2195
   public void Ą(ocbab3c9954b var1) {
      this.ū.Ѥ();
      this.Ȉ.Ď();
      this.ӎ.ʲ();
      this.Ȝ.ĳ(true);
      oc718fd4d503.Ō.à(this, false);
      this.ʌ();
      this.զ(true);
      this.ǐ();
      this.ԛ = 0;
      this.Ƅ = false;
      this.ӌ();
      this.Ɏ();
      this.Ќ.ϔ();
      this.ӱ.ą();
      this.ռ(false);
      this.ʱ.ʄ();
      ӧ.ώ();
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.LOWEST,
      receiveCanceled = true
   )
   public void ó(oc9d4393f3ce param1) {
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
      // 09: invokevirtual x/oc668fce0dbf.ʉ ()Z
      // 0c: ifne 32
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: goto 18
      // 17: athrow
      // 18: iload 2
      // 19: ifne 2b
      // 1c: invokevirtual x/oc668fce0dbf.ȷ ()Z
      // 1f: ifeq 32
      // 22: goto 26
      // 25: athrow
      // 26: aload 0
      // 27: goto 2b
      // 2a: athrow
      // 2b: getfield x/oc668fce0dbf.Ќ Lx/ocbce5ea28a3;
      // 2e: aload 1
      // 2f: invokevirtual x/ocbce5ea28a3.ҫ (Lx/oc9d4393f3ce;)V
      // 32: return
   }

   @oc66fa4f2195
   public void Һ(oc6c7463093f param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: aload 0
      // 004: getfield x/oc668fce0dbf.ū Lx/oc11364ce42a;
      // 007: aload 1
      // 008: invokevirtual x/oc6c7463093f.Ҩ ()Lnet/minecraft/network/Packet;
      // 00b: invokevirtual x/oc11364ce42a.У (Lnet/minecraft/network/Packet;)V
      // 00e: istore 2
      // 00f: aload 0
      // 010: getfield x/oc668fce0dbf.ӎ Lx/ocae1739aac7;
      // 013: aload 1
      // 014: invokevirtual x/oc6c7463093f.Ҩ ()Lnet/minecraft/network/Packet;
      // 017: invokevirtual x/ocae1739aac7.ɧ (Lnet/minecraft/network/Packet;)V
      // 01a: aload 1
      // 01b: invokevirtual x/oc6c7463093f.Ҩ ()Lnet/minecraft/network/Packet;
      // 01e: iload 2
      // 01f: ifne 034
      // 022: instanceof net/minecraft/network/play/client/C03PacketPlayer
      // 025: ifeq 062
      // 028: goto 02c
      // 02b: athrow
      // 02c: aload 1
      // 02d: invokevirtual x/oc6c7463093f.Ҩ ()Lnet/minecraft/network/Packet;
      // 030: goto 034
      // 033: athrow
      // 034: checkcast net/minecraft/network/play/client/C03PacketPlayer
      // 037: invokevirtual net/minecraft/network/play/client/C03PacketPlayer.getRotating ()Z
      // 03a: iload 2
      // 03b: ifne 055
      // 03e: ifeq 062
      // 041: goto 045
      // 044: athrow
      // 045: aload 0
      // 046: iload 2
      // 047: ifne 059
      // 04a: goto 04e
      // 04d: athrow
      // 04e: getfield x/oc668fce0dbf.ԛ I
      // 051: goto 055
      // 054: athrow
      // 055: ifle 062
      // 058: aload 0
      // 059: dup
      // 05a: getfield x/oc668fce0dbf.ԛ I
      // 05d: bipush 1
      // 05e: isub
      // 05f: putfield x/oc668fce0dbf.ԛ I
      // 062: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 065: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 068: ifnull 1ec
      // 06b: aload 1
      // 06c: invokevirtual x/oc6c7463093f.Ҩ ()Lnet/minecraft/network/Packet;
      // 06f: instanceof net/minecraft/network/play/client/C0BPacketEntityAction
      // 072: ifeq 1dc
      // 075: goto 079
      // 078: athrow
      // 079: aload 0
      // 07a: invokevirtual x/oc668fce0dbf.getInfo ()Ljava/lang/String;
      // 07d: aload 0
      // 07e: invokevirtual x/oc668fce0dbf.ҧ ()Z
      // 081: aload 0
      // 082: invokevirtual x/oc668fce0dbf.ϝ ()Z
      // 085: aload 0
      // 086: getfield x/oc668fce0dbf.f Lx/occ2f8dff8d8;
      // 089: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 08c: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 08f: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 092: getfield net/minecraft/client/entity/EntityPlayerSP.onGround Z
      // 095: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 098: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 09b: getfield net/minecraft/client/entity/EntityPlayerSP.motionY D
      // 09e: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0a1: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0a4: getfield net/minecraft/client/entity/EntityPlayerSP.motionX D
      // 0a7: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0aa: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0ad: getfield net/minecraft/client/entity/EntityPlayerSP.motionZ D
      // 0b0: invokestatic java/lang/Math.hypot (DD)D
      // 0b3: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0b6: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0b9: getfield net/minecraft/client/entity/EntityPlayerSP.jumpMovementFactor F
      // 0bc: aload 0
      // 0bd: getfield x/oc668fce0dbf.Ȉ Lx/oc41ddc58b4a;
      // 0c0: invokevirtual x/oc41ddc58b4a.б ()Z
      // 0c3: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0c6: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0c9: iload 2
      // 0ca: ifne 0e5
      // 0cd: goto 0d1
      // 0d0: athrow
      // 0d1: getfield net/minecraft/client/entity/EntityPlayerSP.movementInput Lnet/minecraft/util/MovementInput;
      // 0d4: ifnull 0fa
      // 0d7: goto 0db
      // 0da: athrow
      // 0db: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0de: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0e1: goto 0e5
      // 0e4: athrow
      // 0e5: getfield net/minecraft/client/entity/EntityPlayerSP.movementInput Lnet/minecraft/util/MovementInput;
      // 0e8: getfield net/minecraft/util/MovementInput.sneak Z
      // 0eb: iload 2
      // 0ec: ifne 0f7
      // 0ef: ifeq 0fa
      // 0f2: goto 0f6
      // 0f5: athrow
      // 0f6: bipush 1
      // 0f7: goto 0fb
      // 0fa: bipush 0
      // 0fb: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0fe: iload 2
      // 0ff: ifne 117
      // 102: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 105: getfield net/minecraft/client/entity/EntityPlayerSP.movementInput Lnet/minecraft/util/MovementInput;
      // 108: ifnonnull 114
      // 10b: goto 10f
      // 10e: athrow
      // 10f: fconst_0
      // 110: goto 120
      // 113: athrow
      // 114: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 117: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 11a: getfield net/minecraft/client/entity/EntityPlayerSP.movementInput Lnet/minecraft/util/MovementInput;
      // 11d: getfield net/minecraft/util/MovementInput.moveForward F
      // 120: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 123: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 126: iload 2
      // 127: ifne 13f
      // 12a: getfield net/minecraft/client/entity/EntityPlayerSP.movementInput Lnet/minecraft/util/MovementInput;
      // 12d: ifnonnull 139
      // 130: goto 134
      // 133: athrow
      // 134: fconst_0
      // 135: goto 145
      // 138: athrow
      // 139: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 13c: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 13f: getfield net/minecraft/client/entity/EntityPlayerSP.movementInput Lnet/minecraft/util/MovementInput;
      // 142: getfield net/minecraft/util/MovementInput.moveStrafe F
      // 145: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 148: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 14b: iload 2
      // 14c: ifne 163
      // 14f: getfield net/minecraft/client/entity/EntityPlayerSP.movementInput Lnet/minecraft/util/MovementInput;
      // 152: ifnull 178
      // 155: goto 159
      // 158: athrow
      // 159: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 15c: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 15f: goto 163
      // 162: athrow
      // 163: getfield net/minecraft/client/entity/EntityPlayerSP.movementInput Lnet/minecraft/util/MovementInput;
      // 166: getfield net/minecraft/util/MovementInput.jump Z
      // 169: iload 2
      // 16a: ifne 175
      // 16d: ifeq 178
      // 170: goto 174
      // 173: athrow
      // 174: bipush 1
      // 175: goto 179
      // 178: bipush 0
      // 179: istore 4
      // 17b: fstore 5
      // 17d: fstore 6
      // 17f: istore 7
      // 181: istore 8
      // 183: fstore 9
      // 185: dstore 10
      // 187: dstore 12
      // 189: istore 14
      // 18b: istore 15
      // 18d: istore 16
      // 18f: istore 17
      // 191: astore 18
      // 193: ldc_w "mode="
      // 196: aload 18
      // 198: ldc_w " sameY="
      // 19b: iload 17
      // 19d: ldc_w " pulse="
      // 1a0: iload 16
      // 1a2: ldc_w " safeWalk="
      // 1a5: iload 15
      // 1a7: ldc_w " ground="
      // 1aa: iload 14
      // 1ac: ldc_w " motionY="
      // 1af: dload 12
      // 1b1: ldc_w " motionXZ="
      // 1b4: dload 10
      // 1b6: ldc_w " airFactor="
      // 1b9: fload 9
      // 1bb: ldc_w " deferredRelease="
      // 1be: iload 8
      // 1c0: ldc_w " inputSneak="
      // 1c3: iload 7
      // 1c5: ldc_w " forward="
      // 1c8: fload 6
      // 1ca: ldc_w " strafe="
      // 1cd: fload 5
      // 1cf: ldc_w " jump="
      // 1d2: iload 4
      // 1d4: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZLjava/lang/String;ZLjava/lang/String;ZLjava/lang/String;DLjava/lang/String;DLjava/lang/String;FLjava/lang/String;ZLjava/lang/String;ZLjava/lang/String;FLjava/lang/String;FLjava/lang/String;Z)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001" ]
      // 1d9: goto 1df
      // 1dc: ldc_w ""
      // 1df: astore 3
      // 1e0: aload 0
      // 1e1: getfield x/oc668fce0dbf.Ȉ Lx/oc41ddc58b4a;
      // 1e4: aload 1
      // 1e5: invokevirtual x/oc6c7463093f.Ҩ ()Lnet/minecraft/network/Packet;
      // 1e8: aload 3
      // 1e9: invokevirtual x/oc41ddc58b4a.қ (Lnet/minecraft/network/Packet;Ljava/lang/String;)V
      // 1ec: aload 0
      // 1ed: iload 2
      // 1ee: ifne 226
      // 1f1: invokevirtual x/oc668fce0dbf.ʉ ()Z
      // 1f4: ifne 221
      // 1f7: goto 1fb
      // 1fa: athrow
      // 1fb: aload 0
      // 1fc: iload 2
      // 1fd: ifne 226
      // 200: goto 204
      // 203: athrow
      // 204: invokevirtual x/oc668fce0dbf.ȷ ()Z
      // 207: ifeq 221
      // 20a: goto 20e
      // 20d: athrow
      // 20e: aload 0
      // 20f: getfield x/oc668fce0dbf.Ќ Lx/ocbce5ea28a3;
      // 212: aload 1
      // 213: invokevirtual x/oc6c7463093f.Ҩ ()Lnet/minecraft/network/Packet;
      // 216: invokevirtual x/ocbce5ea28a3.è (Lnet/minecraft/network/Packet;)V
      // 219: iload 2
      // 21a: ifeq 279
      // 21d: goto 221
      // 220: athrow
      // 221: aload 0
      // 222: goto 226
      // 225: athrow
      // 226: iload 2
      // 227: ifne 25f
      // 22a: invokevirtual x/oc668fce0dbf.ʉ ()Z
      // 22d: ifne 25a
      // 230: goto 234
      // 233: athrow
      // 234: aload 0
      // 235: iload 2
      // 236: ifne 25f
      // 239: goto 23d
      // 23c: athrow
      // 23d: invokevirtual x/oc668fce0dbf.ɣ ()Z
      // 240: ifeq 25a
      // 243: goto 247
      // 246: athrow
      // 247: aload 0
      // 248: getfield x/oc668fce0dbf.ӱ Lx/oc3b42959d05;
      // 24b: aload 1
      // 24c: invokevirtual x/oc6c7463093f.Ҩ ()Lnet/minecraft/network/Packet;
      // 24f: invokevirtual x/oc3b42959d05.δ (Lnet/minecraft/network/Packet;)V
      // 252: iload 2
      // 253: ifeq 279
      // 256: goto 25a
      // 259: athrow
      // 25a: aload 0
      // 25b: goto 25f
      // 25e: athrow
      // 25f: iload 2
      // 260: ifne 272
      // 263: invokevirtual x/oc668fce0dbf.ճ ()Z
      // 266: ifeq 279
      // 269: goto 26d
      // 26c: athrow
      // 26d: aload 0
      // 26e: goto 272
      // 271: athrow
      // 272: aload 1
      // 273: invokevirtual x/oc6c7463093f.Ҩ ()Lnet/minecraft/network/Packet;
      // 276: invokevirtual x/oc668fce0dbf.Ƞ (Lnet/minecraft/network/Packet;)V
      // 279: return
   }

   private void Ƞ(Packet<?> param1) {
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
      // 06: ifne 21
      // 09: instanceof net/minecraft/network/play/client/C08PacketPlayerBlockPlacement
      // 0c: ifeq 20
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: ldc_w 1814773406
      // 17: ldc_w 1814773403
      // 1a: ixor
      // 1b: putfield x/oc668fce0dbf.Ʉ I
      // 1e: return
      // 1f: athrow
      // 20: aload 1
      // 21: iload 2
      // 22: ifne 34
      // 25: instanceof net/minecraft/network/play/client/C03PacketPlayer
      // 28: ifeq 45
      // 2b: goto 2f
      // 2e: athrow
      // 2f: aload 1
      // 30: goto 34
      // 33: athrow
      // 34: iload 2
      // 35: ifne 48
      // 38: checkcast net/minecraft/network/play/client/C03PacketPlayer
      // 3b: invokevirtual net/minecraft/network/play/client/C03PacketPlayer.getRotating ()Z
      // 3e: ifne 47
      // 41: goto 45
      // 44: athrow
      // 45: return
      // 46: athrow
      // 47: aload 1
      // 48: checkcast net/minecraft/network/play/client/C03PacketPlayer
      // 4b: astore 3
      // 4c: iload 2
      // 4d: aload 3
      // 4e: invokevirtual net/minecraft/network/play/client/C03PacketPlayer.getPitch ()F
      // 51: fstore 4
      // 53: ifne 80
      // 56: aload 0
      // 57: getfield x/oc668fce0dbf.Ų Z
      // 5a: ifeq 77
      // 5d: goto 61
      // 60: athrow
      // 61: aload 0
      // 62: fload 4
      // 64: aload 0
      // 65: getfield x/oc668fce0dbf.ə F
      // 68: fsub
      // 69: invokestatic x/oc3b42959d05.Ѱ (F)J
      // 6c: putfield x/oc668fce0dbf.ľ J
      // 6f: iload 2
      // 70: ifeq 8b
      // 73: goto 77
      // 76: athrow
      // 77: aload 0
      // 78: bipush 1
      // 79: putfield x/oc668fce0dbf.Ų Z
      // 7c: goto 80
      // 7f: athrow
      // 80: aload 0
      // 81: ldc2_w -1552099777476846687
      // 84: ldc2_w 1552099777476846686
      // 87: lxor
      // 88: putfield x/oc668fce0dbf.ľ J
      // 8b: aload 0
      // 8c: iload 2
      // 8d: ifne a5
      // 90: fload 4
      // 92: putfield x/oc668fce0dbf.ə F
      // 95: aload 0
      // 96: getfield x/oc668fce0dbf.Ʉ I
      // 99: ifle ae
      // 9c: goto a0
      // 9f: athrow
      // a0: aload 0
      // a1: goto a5
      // a4: athrow
      // a5: dup
      // a6: getfield x/oc668fce0dbf.Ʉ I
      // a9: bipush 1
      // aa: isub
      // ab: putfield x/oc668fce0dbf.Ʉ I
      // ae: return
   }

   @oc66fa4f2195
   public void ը(oce79181588d param1) {
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
      // 05: invokevirtual x/oce79181588d.Ҡ ()Lnet/minecraft/network/Packet;
      // 08: instanceof net/minecraft/network/play/server/S08PacketPlayerPosLook
      // 0b: iload 2
      // 0c: ifne 34
      // 0f: ifeq 28
      // 12: goto 16
      // 15: athrow
      // 16: aload 0
      // 17: getfield x/oc668fce0dbf.Ȉ Lx/oc41ddc58b4a;
      // 1a: invokevirtual x/oc41ddc58b4a.Ď ()V
      // 1d: aload 0
      // 1e: getfield x/oc668fce0dbf.ӎ Lx/ocae1739aac7;
      // 21: invokevirtual x/ocae1739aac7.ʲ ()V
      // 24: goto 28
      // 27: athrow
      // 28: aload 0
      // 29: iload 2
      // 2a: ifne 47
      // 2d: invokevirtual x/oc668fce0dbf.ȷ ()Z
      // 30: goto 34
      // 33: athrow
      // 34: ifeq 46
      // 37: aload 0
      // 38: getfield x/oc668fce0dbf.Ќ Lx/ocbce5ea28a3;
      // 3b: aload 1
      // 3c: invokevirtual x/oce79181588d.Ҡ ()Lnet/minecraft/network/Packet;
      // 3f: invokevirtual x/ocbce5ea28a3.B (Lnet/minecraft/network/Packet;)V
      // 42: goto 46
      // 45: athrow
      // 46: aload 0
      // 47: invokevirtual x/oc668fce0dbf.Ɯ ()Z
      // 4a: iload 2
      // 4b: ifne 60
      // 4e: ifeq 8b
      // 51: goto 55
      // 54: athrow
      // 55: aload 1
      // 56: invokevirtual x/oce79181588d.Ҡ ()Lnet/minecraft/network/Packet;
      // 59: instanceof net/minecraft/network/play/server/S08PacketPlayerPosLook
      // 5c: goto 60
      // 5f: athrow
      // 60: iload 2
      // 61: ifne 7b
      // 64: ifeq 8b
      // 67: goto 6b
      // 6a: athrow
      // 6b: aload 0
      // 6c: iload 2
      // 6d: ifne 7f
      // 70: goto 74
      // 73: athrow
      // 74: invokevirtual x/oc668fce0dbf.ɣ ()Z
      // 77: goto 7b
      // 7a: athrow
      // 7b: ifeq 85
      // 7e: aload 0
      // 7f: getfield x/oc668fce0dbf.ӱ Lx/oc3b42959d05;
      // 82: invokevirtual x/oc3b42959d05.ą ()V
      // 85: getstatic x/oc668fce0dbf.ӧ Lx/oc7beea7ccff;
      // 88: invokevirtual x/oc7beea7ccff.Ψ ()V
      // 8b: return
   }

   @oc66fa4f2195
   public void θ(ocadfd5cc157 param1) {
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
      // 05: getfield x/ocadfd5cc157.Ц Lnet/minecraft/entity/Entity;
      // 08: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0b: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0e: if_acmpeq 13
      // 11: return
      // 12: athrow
      // 13: aload 0
      // 14: iload 2
      // 15: ifne 65
      // 18: getfield x/oc668fce0dbf.ū Lx/oc11364ce42a;
      // 1b: invokevirtual x/oc11364ce42a.Ѥ ()V
      // 1e: aload 0
      // 1f: getfield x/oc668fce0dbf.Ȉ Lx/oc41ddc58b4a;
      // 22: invokevirtual x/oc41ddc58b4a.Ď ()V
      // 25: aload 0
      // 26: bipush 1
      // 27: invokevirtual x/oc668fce0dbf.զ (Z)V
      // 2a: aload 0
      // 2b: invokevirtual x/oc668fce0dbf.ǐ ()V
      // 2e: aload 0
      // 2f: bipush 0
      // 30: putfield x/oc668fce0dbf.ԛ I
      // 33: aload 0
      // 34: bipush 0
      // 35: putfield x/oc668fce0dbf.Ƅ Z
      // 38: aload 0
      // 39: getfield x/oc668fce0dbf.ӎ Lx/ocae1739aac7;
      // 3c: invokevirtual x/ocae1739aac7.ʲ ()V
      // 3f: aload 0
      // 40: invokevirtual x/oc668fce0dbf.Ɯ ()Z
      // 43: ifeq 60
      // 46: goto 4a
      // 49: athrow
      // 4a: aload 0
      // 4b: getfield x/oc668fce0dbf.Ќ Lx/ocbce5ea28a3;
      // 4e: invokevirtual x/ocbce5ea28a3.ϔ ()V
      // 51: iload 2
      // 52: aload 0
      // 53: getfield x/oc668fce0dbf.ӱ Lx/oc3b42959d05;
      // 56: invokevirtual x/oc3b42959d05.ą ()V
      // 59: ifeq 6c
      // 5c: goto 60
      // 5f: athrow
      // 60: aload 0
      // 61: goto 65
      // 64: athrow
      // 65: getfield x/oc668fce0dbf.Ȝ Lx/ocff76b7be49;
      // 68: bipush 0
      // 69: invokevirtual x/ocff76b7be49.ĳ (Z)V
      // 6c: getstatic x/oc668fce0dbf.ӧ Lx/oc7beea7ccff;
      // 6f: invokevirtual x/oc7beea7ccff.Ψ ()V
      // 72: aload 0
      // 73: invokevirtual x/oc668fce0dbf.ʢ ()V
      // 76: aload 0
      // 77: invokevirtual x/oc668fce0dbf.ƌ ()V
      // 7a: return
   }

   private boolean ճ() {
      int var1 = oc84f20a0bc5.ė;
      int var2 = 126237922 ^ -173534280;

      while (true) {
         switch (var2) {
            case -231854246:
               int var10000;
               label28: {
                  label27: {
                     try {
                        var10000 = (int)this.Ʃ.Ӂ();
                        if (var1 != 0) {
                           break label28;
                        }

                        if (var10000 != 0) {
                           break label27;
                        }
                     } catch (ocbde1165e4e var3) {
                        throw var3;
                     }

                     var2 = -34922914 ^ -173534280;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var10000 = 362582875 ^ -173534280;
               }

               var2 = var10000;
               if (var1 == 0) {
                  break;
               }
            case -533430045:
               return false;
            case 138612198:
               return true;
            default:
               throw null;
         }
      }
   }

   private boolean Ü() {
      int var1 = oc84f20a0bc5.ė;
      int var2 = -21102248 ^ 416347206;

      while (true) {
         switch (var2) {
            case -2097449802:
               return true;
            case -428935906:
               int var10000;
               label28: {
                  label27: {
                     try {
                        var10000 = (int)this.Ʃ.Ӂ();
                        if (var1 != 0) {
                           break label28;
                        }

                        if (var10000 != (416347205 ^ 416347206)) {
                           break label27;
                        }
                     } catch (ocbde1165e4e var3) {
                        throw var3;
                     }

                     var2 = -1708424976 ^ 416347206;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var10000 = -1932365831 ^ 416347206;
               }

               var2 = var10000;
               if (var1 == 0) {
                  break;
               }
            case -1811768385:
               return false;
            default:
               throw null;
         }
      }
   }

   int ө() {
      return (int)this.â.Ӂ();
   }

   boolean Ȉ() {
      return this.ċ.ǭ();
   }

   boolean eBool() {
      return this.Ɯ.ǭ();
   }

   private boolean ʉ() {
      int var1 = oc84f20a0bc5.ė;
      int var2 = -407128617 ^ 588355969;

      while (true) {
         switch (var2) {
            case -1901337198:
               int var10000;
               label50: {
                  label49: {
                     try {
                        var10000 = this.Ƅ;
                        if (var1 != 0) {
                           break label50;
                        }

                        if (!this.Ƅ) {
                           break label49;
                        }
                     } catch (ocbde1165e4e var4) {
                        throw var4;
                     }

                     var2 = -1944170256 ^ 588355969;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var10000 = 1945940041 ^ 588355969;
               }

               var2 = var10000;
               if (var1 == 0) {
                  break;
               }
            case -995480490:
               int var5;
               label38: {
                  label37: {
                     try {
                        var5 = this.J;
                        if (var1 != 0) {
                           break label38;
                        }

                        if (this.J) {
                           break label37;
                        }
                     } catch (ocbde1165e4e var3) {
                        throw var3;
                     }

                     var2 = -1380287469 ^ 588355969;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var5 = -1944170256 ^ 588355969;
               }

               var2 = var5;
               if (var1 == 0) {
                  break;
               }

               return false;
            case -1357919887:
               return true;
            case 1357720008:
               return false;
            default:
               throw null;
         }
      }
   }

   private boolean Ɯ() {
      int var1 = oc84f20a0bc5.ė;
      int var2 = 1920999688 ^ -673391379;

      while (true) {
         switch (var2) {
            case -1866023432:
               return false;
            case -670717538:
               return true;
            case 1872401607:
               int var10000;
               label50: {
                  label49: {
                     try {
                        var10000 = (int)this.Ʃ.Ӂ();
                        if (var1 != 0) {
                           break label50;
                        }

                        if (var10000 != (-673391377 ^ -673391379)) {
                           break label49;
                        }
                     } catch (ocbde1165e4e var4) {
                        throw var4;
                     }

                     var2 = 265909619 ^ -673391379;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var10000 = 1192911125 ^ -673391379;
               }

               var2 = var10000;
               if (var1 == 0) {
                  break;
               }
            case -1520632347:
               int var5;
               label38: {
                  label37: {
                     try {
                        var5 = (int)this.Ʃ.Ӂ();
                        if (var1 != 0) {
                           break label38;
                        }

                        if (var5 == 1) {
                           break label37;
                        }
                     } catch (ocbde1165e4e var3) {
                        throw var3;
                     }

                     var2 = -1203353558 ^ -673391379;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var5 = 265909619 ^ -673391379;
               }

               var2 = var5;
               if (var1 == 0) {
                  break;
               }

               return false;
            default:
               throw null;
         }
      }
   }

   private boolean ȷ() {
      int var1 = oc84f20a0bc5.ė;
      int var2 = 528538410 ^ -1797707968;

      while (true) {
         switch (var2) {
            case -1957036950:
               int var10000;
               label29: {
                  label28: {
                     try {
                        var10000 = (int)this.Ʃ.Ӂ();
                        if (var1 != 0) {
                           break label29;
                        }

                        if (var10000 != 1) {
                           break label28;
                        }
                     } catch (ocbde1165e4e var3) {
                        throw var3;
                     }

                     var2 = -470563855 ^ -1797707968;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var10000 = -1790115384 ^ -1797707968;
               }

               var2 = var10000;
               break;
            case 26486408:
               return false;
            case 1999299761:
               return true;
            default:
               throw null;
         }
      }
   }

   boolean ɣ() {
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
      // 05: getfield x/oc668fce0dbf.Ʃ Lx/oca9cc61aada;
      // 08: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0b: d2i
      // 0c: iload 1
      // 0d: ifne 23
      // 10: ldc_w 110987787
      // 13: ldc_w 110987785
      // 16: ixor
      // 17: if_icmpne 26
      // 1a: goto 1e
      // 1d: athrow
      // 1e: bipush 1
      // 1f: goto 23
      // 22: athrow
      // 23: goto 27
      // 26: bipush 0
      // 27: ireturn
   }

   private float Ω() {
      float var2 = 0.0F;
      float var3 = 0.0F;
      int var1 = oc84f20a0bc5.ė;

      Minecraft var8;
      label71: {
         label66: {
            label65: {
               try {
                  var10000 = oc69da1aa7f5.ő.gameSettings;
                  if (var1 != 0) {
                     break label66;
                  }

                  if (!oc69da1aa7f5.ő.gameSettings.keyBindForward.isKeyDown()) {
                     break label65;
                  }
               } catch (ocbde1165e4e var7) {
                  throw var7;
               }

               var2++;
            }

            try {
               var8 = oc69da1aa7f5.ő;
               if (var1 != 0) {
                  break label71;
               }

               var10000 = oc69da1aa7f5.ő.gameSettings;
            } catch (ocbde1165e4e var6) {
               throw var6;
            }
         }

         if (var10000.keyBindBack.isKeyDown()) {
            var2--;
         }

         var8 = oc69da1aa7f5.ő;
      }

      label53: {
         label52: {
            try {
               if (var1 != 0) {
                  break label53;
               }

               if (!var8.gameSettings.keyBindLeft.isKeyDown()) {
                  break label52;
               }
            } catch (ocbde1165e4e var5) {
               throw var5;
            }

            var3++;
         }

         var8 = oc69da1aa7f5.ő;
      }

      try {
         if (var1 != 0) {
            return р(var8.thePlayer.rotationYaw, var2, var3, oc69da1aa7f5.ő.thePlayer.motionX, oc69da1aa7f5.ő.thePlayer.motionZ, this.ì());
         }

         if (!var8.gameSettings.keyBindRight.isKeyDown()) {
            return р(oc69da1aa7f5.ő.thePlayer.rotationYaw, var2, var3, oc69da1aa7f5.ő.thePlayer.motionX, oc69da1aa7f5.ő.thePlayer.motionZ, this.ì());
         }
      } catch (ocbde1165e4e var4) {
         throw var4;
      }

      var3--;
      return р(oc69da1aa7f5.ő.thePlayer.rotationYaw, var2, var3, oc69da1aa7f5.ő.thePlayer.motionX, oc69da1aa7f5.ő.thePlayer.motionZ, this.ì());
   }

   private float є() {
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
      // 06: ifne 1a
      // 09: invokevirtual x/oc668fce0dbf.շ ()Z
      // 0c: ifeq 19
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: invokevirtual x/oc668fce0dbf.Ω ()F
      // 17: freturn
      // 18: athrow
      // 19: aload 0
      // 1a: iload 1
      // 1b: ifne 41
      // 1e: invokevirtual x/oc668fce0dbf.ʗ ()Z
      // 21: ifeq 40
      // 24: goto 28
      // 27: athrow
      // 28: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 2b: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 2e: getfield net/minecraft/client/entity/EntityPlayerSP.hurtTime I
      // 31: iload 1
      // 32: ifne 77
      // 35: goto 39
      // 38: athrow
      // 39: ifeq 6b
      // 3c: goto 40
      // 3f: athrow
      // 40: aload 0
      // 41: getfield x/oc668fce0dbf.Ţ [F
      // 44: iload 1
      // 45: ifne 5c
      // 48: bipush 0
      // 49: faload
      // 4a: invokestatic x/oc668fce0dbf.ά (F)Z
      // 4d: ifeq 61
      // 50: goto 54
      // 53: athrow
      // 54: aload 0
      // 55: getfield x/oc668fce0dbf.Ţ [F
      // 58: goto 5c
      // 5b: athrow
      // 5c: bipush 0
      // 5d: faload
      // 5e: goto 6a
      // 61: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 64: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 67: getfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 6a: freturn
      // 6b: aload 0
      // 6c: iload 1
      // 6d: ifne 89
      // 70: invokevirtual x/oc668fce0dbf.T ()Z
      // 73: goto 77
      // 76: athrow
      // 77: ifeq 88
      // 7a: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 7d: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 80: getfield net/minecraft/client/entity/EntityPlayerSP.rotationYaw F
      // 83: invokestatic x/oc668fce0dbf.ӭ (F)F
      // 86: freturn
      // 87: athrow
      // 88: aload 0
      // 89: invokevirtual x/oc668fce0dbf.Ω ()F
      // 8c: freturn
   }

   private float Ş() {
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
      // 06: ifne 1c
      // 09: invokevirtual x/oc668fce0dbf.շ ()Z
      // 0c: ifeq 1b
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: getfield x/oc668fce0dbf.Ţ [F
      // 17: bipush 1
      // 18: faload
      // 19: freturn
      // 1a: athrow
      // 1b: aload 0
      // 1c: iload 1
      // 1d: ifne 47
      // 20: invokevirtual x/oc668fce0dbf.ʗ ()Z
      // 23: ifeq 46
      // 26: goto 2a
      // 29: athrow
      // 2a: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 2d: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 30: getfield net/minecraft/client/entity/EntityPlayerSP.hurtTime I
      // 33: iload 1
      // 34: ifne 57
      // 37: goto 3b
      // 3a: athrow
      // 3b: ifne 46
      // 3e: goto 42
      // 41: athrow
      // 42: ldc 76.0
      // 44: freturn
      // 45: athrow
      // 46: aload 0
      // 47: iload 1
      // 48: ifne 5b
      // 4b: getfield x/oc668fce0dbf.Ţ [F
      // 4e: bipush 1
      // 4f: faload
      // 50: invokestatic x/oc668fce0dbf.ά (F)Z
      // 53: goto 57
      // 56: athrow
      // 57: ifeq 63
      // 5a: aload 0
      // 5b: getfield x/oc668fce0dbf.Ţ [F
      // 5e: bipush 1
      // 5f: faload
      // 60: goto 6c
      // 63: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 66: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 69: getfield net/minecraft/client/entity/EntityPlayerSP.rotationPitch F
      // 6c: freturn
   }

   private boolean ʗ() {
      int var1 = oc84f20a0bc5.ė;
      int var2 = 1699833033 ^ -165120817;

      while (true) {
         switch (var2) {
            case -1820782586:
               int var9;
               label75: {
                  label74: {
                     try {
                        var9 = oc69da1aa7f5.ő.gameSettings.keyBindForward.isKeyDown();
                        if (var1 != 0) {
                           break label75;
                        }

                        if (var9 != 0) {
                           break label74;
                        }
                     } catch (ocbde1165e4e var5) {
                        throw var5;
                     }

                     var2 = 1098197692 ^ -165120817;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var9 = -530064566 ^ -165120817;
               }

               var2 = var9;
               break;
            case -1218617741:
               int var8;
               label57: {
                  label56: {
                     try {
                        var8 = oc69da1aa7f5.ő.gameSettings.keyBindBack.isKeyDown();
                        if (var1 != 0) {
                           break label57;
                        }

                        if (var8 != 0) {
                           break label56;
                        }
                     } catch (ocbde1165e4e var3) {
                        throw var3;
                     }

                     var2 = -1395378233 ^ -165120817;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var8 = -530064566 ^ -165120817;
               }

               var2 = var8;
               if (var1 == 0) {
                  break;
               }

               return false;
            case 374321029:
               return true;
            case 754351394:
               return false;
            case 1526481672:
               int var10000;
               label88: {
                  label87: {
                     try {
                        var10000 = oc69da1aa7f5.ő.gameSettings.keyBindLeft.isKeyDown();
                        if (var1 != 0) {
                           break label88;
                        }

                        if (var10000 != 0) {
                           break label87;
                        }
                     } catch (ocbde1165e4e var6) {
                        throw var6;
                     }

                     var2 = 1807496848 ^ -165120817;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var10000 = -530064566 ^ -165120817;
               }

               var2 = var10000;
               if (var1 == 0) {
                  break;
               }
            case -1651228065:
               int var7;
               label66: {
                  label65: {
                     try {
                        var7 = oc69da1aa7f5.ő.gameSettings.keyBindRight.isKeyDown();
                        if (var1 != 0) {
                           break label66;
                        }

                        if (var7 == 0) {
                           break label65;
                        }
                     } catch (ocbde1165e4e var4) {
                        throw var4;
                     }

                     var2 = -530064566 ^ -165120817;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var7 = -622982675 ^ -165120817;
               }

               var2 = var7;
               if (var1 == 0) {
                  break;
               }

               return true;
            default:
               throw null;
         }
      }
   }

   private boolean T() {
      int var1 = oc84f20a0bc5.ė;
      int var2 = -465233247 ^ -1765692283;

      while (true) {
         switch (var2) {
            case -1718472446:
               return false;
            case 1921300004:
               int var10000;
               label28: {
                  label27: {
                     try {
                        var10000 = (int)this.ƫ.Ӂ();
                        if (var1 != 0) {
                           break label28;
                        }

                        if (var10000 != 1) {
                           break label27;
                        }
                     } catch (ocbde1165e4e var3) {
                        throw var3;
                     }

                     var2 = -82514181 ^ -1765692283;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var10000 = 257138055 ^ -1765692283;
               }

               var2 = var10000;
               if (var1 == 0) {
                  break;
               }
            case 1842692734:
               return true;
            default:
               throw null;
         }
      }
   }

   private boolean շ() {
      int var1 = oc84f20a0bc5.ė;
      int var2 = -879769116 ^ 378595329;

      while (true) {
         switch (var2) {
            case -585162267:
               int var10000;
               label29: {
                  label28: {
                     try {
                        var10000 = (int)this.ƫ.Ӂ();
                        if (var1 != 0) {
                           break label29;
                        }

                        if (var10000 != (378595331 ^ 378595329)) {
                           break label28;
                        }
                     } catch (ocbde1165e4e var3) {
                        throw var3;
                     }

                     var2 = -29898600 ^ 378595329;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var10000 = 781884039 ^ 378595329;
               }

               var2 = var10000;
               break;
            case -391700327:
               return true;
            case 940208774:
               return false;
            default:
               throw null;
         }
      }
   }

   private float ν(float var1) {
      try {
         if (this.գ.ǭ()) {
            return oc69da1aa7f5.ő.thePlayer.rotationYaw;
         }
      } catch (ocbde1165e4e var2) {
         throw var2;
      }

      return var1;
   }

   static float р(float param0, float param1, float param2, double param3, double param5, float param7) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 8
      // 05: fload 1
      // 06: iload 8
      // 08: ifne 2d
      // 0b: fconst_0
      // 0c: fcmpl
      // 0d: ifne 27
      // 10: goto 14
      // 13: athrow
      // 14: fload 2
      // 15: iload 8
      // 17: ifne 2d
      // 1a: goto 1e
      // 1d: athrow
      // 1e: fconst_0
      // 1f: fcmpl
      // 20: ifeq 7a
      // 23: goto 27
      // 26: athrow
      // 27: fload 2
      // 28: fneg
      // 29: goto 2d
      // 2c: athrow
      // 2d: f2d
      // 2e: fload 1
      // 2f: f2d
      // 30: invokestatic java/lang/Math.atan2 (DD)D
      // 33: invokestatic java/lang/Math.toDegrees (D)D
      // 36: dstore 9
      // 38: dload 9
      // 3a: ldc2_w 180.0
      // 3d: dadd
      // 3e: dstore 11
      // 40: dload 11
      // 42: ldc2_w 180.0
      // 45: dcmpl
      // 46: ifle 5b
      // 49: dload 11
      // 4b: ldc2_w 360.0
      // 4e: iload 8
      // 50: ifne 60
      // 53: dsub
      // 54: dstore 11
      // 56: iload 8
      // 58: ifeq 40
      // 5b: dload 11
      // 5d: ldc2_w -180.0
      // 60: dcmpg
      // 61: ifgt 71
      // 64: dload 11
      // 66: ldc2_w 360.0
      // 69: dadd
      // 6a: dstore 11
      // 6c: iload 8
      // 6e: ifeq 5b
      // 71: fload 0
      // 72: dload 11
      // 74: d2f
      // 75: fadd
      // 76: fload 7
      // 78: fadd
      // 79: freturn
      // 7a: dload 3
      // 7b: dload 3
      // 7c: dmul
      // 7d: dload 5
      // 7f: dload 5
      // 81: dmul
      // 82: dadd
      // 83: dstore 9
      // 85: dload 9
      // 87: iload 8
      // 89: ifne a5
      // 8c: ldc2_w 1.0E-8
      // 8f: dcmpl
      // 90: ifle a9
      // 93: goto 97
      // 96: athrow
      // 97: dload 3
      // 98: dneg
      // 99: dload 5
      // 9b: invokestatic java/lang/Math.atan2 (DD)D
      // 9e: invokestatic java/lang/Math.toDegrees (D)D
      // a1: goto a5
      // a4: athrow
      // a5: d2f
      // a6: goto aa
      // a9: fload 0
      // aa: fstore 11
      // ac: fload 11
      // ae: ldc_w 180.0
      // b1: fadd
      // b2: fload 7
      // b4: fadd
      // b5: freturn
   }

   static int Љ(ItemStack[] param0) {
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
      // 05: ifnonnull 0b
      // 08: bipush 0
      // 09: ireturn
      // 0a: athrow
      // 0b: bipush 0
      // 0c: istore 2
      // 0d: invokestatic net/minecraft/entity/player/InventoryPlayer.getHotbarSize ()I
      // 10: aload 0
      // 11: arraylength
      // 12: invokestatic java/lang/Math.min (II)I
      // 15: istore 3
      // 16: bipush 0
      // 17: istore 4
      // 19: iload 4
      // 1b: iload 3
      // 1c: if_icmpge 95
      // 1f: aload 0
      // 20: iload 4
      // 22: aaload
      // 23: astore 5
      // 25: iload 1
      // 26: ifne 91
      // 29: aload 5
      // 2b: ifnull 8e
      // 2e: goto 32
      // 31: athrow
      // 32: aload 5
      // 34: iload 1
      // 35: ifne 4c
      // 38: goto 3c
      // 3b: athrow
      // 3c: getfield net/minecraft/item/ItemStack.stackSize I
      // 3f: ifle 8e
      // 42: goto 46
      // 45: athrow
      // 46: aload 5
      // 48: goto 4c
      // 4b: athrow
      // 4c: iload 1
      // 4d: ifne 6b
      // 50: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 53: instanceof net/minecraft/item/ItemBlock
      // 56: ifne 65
      // 59: goto 5d
      // 5c: athrow
      // 5d: iload 1
      // 5e: ifeq 8e
      // 61: goto 65
      // 64: athrow
      // 65: aload 5
      // 67: goto 6b
      // 6a: athrow
      // 6b: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 6e: checkcast net/minecraft/item/ItemBlock
      // 71: astore 6
      // 73: iload 1
      // 74: ifne 91
      // 77: aload 6
      // 79: invokevirtual net/minecraft/item/ItemBlock.getBlock ()Lnet/minecraft/block/Block;
      // 7c: invokestatic x/oc3e9033eba7.Ɖ (Lnet/minecraft/block/Block;)Z
      // 7f: ifeq 8e
      // 82: goto 86
      // 85: athrow
      // 86: iload 2
      // 87: aload 5
      // 89: getfield net/minecraft/item/ItemStack.stackSize I
      // 8c: iadd
      // 8d: istore 2
      // 8e: iinc 4 1
      // 91: iload 1
      // 92: ifeq 19
      // 95: iload 2
      // 96: ireturn
   }

   private void Ù(boolean param1) {
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
      // 006: ifne 025
      // 009: invokevirtual x/oc668fce0dbf.ȷ ()Z
      // 00c: ifeq 024
      // 00f: goto 013
      // 012: athrow
      // 013: aload 0
      // 014: invokevirtual x/oc668fce0dbf.ӌ ()V
      // 017: aload 0
      // 018: aload 0
      // 019: getfield x/oc668fce0dbf.Ќ Lx/ocbce5ea28a3;
      // 01c: invokevirtual x/ocbce5ea28a3.н ()Z
      // 01f: invokevirtual x/oc668fce0dbf.ռ (Z)V
      // 022: return
      // 023: athrow
      // 024: aload 0
      // 025: iload 2
      // 026: ifne 03f
      // 029: invokevirtual x/oc668fce0dbf.ɣ ()Z
      // 02c: ifeq 03e
      // 02f: goto 033
      // 032: athrow
      // 033: aload 0
      // 034: invokevirtual x/oc668fce0dbf.ӌ ()V
      // 037: aload 0
      // 038: bipush 0
      // 039: invokevirtual x/oc668fce0dbf.ռ (Z)V
      // 03c: return
      // 03d: athrow
      // 03e: aload 0
      // 03f: getfield x/oc668fce0dbf.f Lx/occ2f8dff8d8;
      // 042: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 045: iload 2
      // 046: ifne 05d
      // 049: ifeq 086
      // 04c: goto 050
      // 04f: athrow
      // 050: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 053: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 056: getfield net/minecraft/client/entity/EntityPlayerSP.onGround Z
      // 059: goto 05d
      // 05c: athrow
      // 05d: iload 2
      // 05e: ifne 069
      // 061: ifeq 086
      // 064: goto 068
      // 067: athrow
      // 068: iload 1
      // 069: iload 2
      // 06a: ifne 077
      // 06d: ifne 086
      // 070: goto 074
      // 073: athrow
      // 074: invokestatic x/oc3e9033eba7.Ο ()Z
      // 077: iload 2
      // 078: ifne 083
      // 07b: ifeq 086
      // 07e: goto 082
      // 081: athrow
      // 082: bipush 1
      // 083: goto 087
      // 086: bipush 0
      // 087: istore 3
      // 088: aload 0
      // 089: iload 2
      // 08a: ifne 0ab
      // 08d: getfield x/oc668fce0dbf.ǔ Lx/occ2f8dff8d8;
      // 090: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 093: ifne 0a6
      // 096: goto 09a
      // 099: athrow
      // 09a: aload 0
      // 09b: invokevirtual x/oc668fce0dbf.ӌ ()V
      // 09e: iload 2
      // 09f: ifeq 11d
      // 0a2: goto 0a6
      // 0a5: athrow
      // 0a6: aload 0
      // 0a7: goto 0ab
      // 0aa: athrow
      // 0ab: iload 2
      // 0ac: ifne 103
      // 0af: getfield x/oc668fce0dbf.դ I
      // 0b2: ifgt 102
      // 0b5: goto 0b9
      // 0b8: athrow
      // 0b9: aload 0
      // 0ba: iload 2
      // 0bb: ifne 103
      // 0be: goto 0c2
      // 0c1: athrow
      // 0c2: getfield x/oc668fce0dbf.Β I
      // 0c5: aload 0
      // 0c6: getfield x/oc668fce0dbf.Ѡ I
      // 0c9: if_icmplt 102
      // 0cc: goto 0d0
      // 0cf: athrow
      // 0d0: aload 0
      // 0d1: iload 2
      // 0d2: ifne 103
      // 0d5: goto 0d9
      // 0d8: athrow
      // 0d9: invokevirtual x/oc668fce0dbf.à ()Z
      // 0dc: ifeq 102
      // 0df: goto 0e3
      // 0e2: athrow
      // 0e3: aload 0
      // 0e4: aload 0
      // 0e5: getfield x/oc668fce0dbf.g Lx/ocf1568fef75;
      // 0e8: invokestatic x/oc668fce0dbf.ո (Lx/ocf1568fef75;)I
      // 0eb: putfield x/oc668fce0dbf.դ I
      // 0ee: aload 0
      // 0ef: bipush 0
      // 0f0: putfield x/oc668fce0dbf.Β I
      // 0f3: aload 0
      // 0f4: aload 0
      // 0f5: getfield x/oc668fce0dbf.Е Lx/ocf1568fef75;
      // 0f8: invokestatic x/oc668fce0dbf.ո (Lx/ocf1568fef75;)I
      // 0fb: putfield x/oc668fce0dbf.Ѡ I
      // 0fe: goto 102
      // 101: athrow
      // 102: aload 0
      // 103: iload 2
      // 104: ifne 11e
      // 107: getfield x/oc668fce0dbf.դ I
      // 10a: ifle 11d
      // 10d: goto 111
      // 110: athrow
      // 111: bipush 1
      // 112: istore 3
      // 113: aload 0
      // 114: dup
      // 115: getfield x/oc668fce0dbf.դ I
      // 118: bipush 1
      // 119: isub
      // 11a: putfield x/oc668fce0dbf.դ I
      // 11d: aload 0
      // 11e: iload 3
      // 11f: invokevirtual x/oc668fce0dbf.ռ (Z)V
      // 122: return
   }

   private void ռ(boolean param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 2
      // 04: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 07: iload 2
      // 08: ifne 1a
      // 0b: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 0e: ifnonnull 17
      // 11: goto 15
      // 14: athrow
      // 15: return
      // 16: athrow
      // 17: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1a: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 1d: getfield net/minecraft/client/settings/GameSettings.keyBindSneak Lnet/minecraft/client/settings/KeyBinding;
      // 20: invokevirtual net/minecraft/client/settings/KeyBinding.getKeyCode ()I
      // 23: iload 1
      // 24: iload 2
      // 25: ifne 61
      // 28: ifne 60
      // 2b: goto 2f
      // 2e: athrow
      // 2f: aload 0
      // 30: getfield x/oc668fce0dbf.Ȝ Lx/ocff76b7be49;
      // 33: invokevirtual x/ocff76b7be49.ҕ ()Z
      // 36: iload 2
      // 37: ifne 61
      // 3a: goto 3e
      // 3d: athrow
      // 3e: ifne 60
      // 41: goto 45
      // 44: athrow
      // 45: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 48: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 4b: getfield net/minecraft/client/settings/GameSettings.keyBindSneak Lnet/minecraft/client/settings/KeyBinding;
      // 4e: invokestatic x/oc7ab2161b9f.ն (Lnet/minecraft/client/settings/KeyBinding;)Z
      // 51: iload 2
      // 52: ifne 61
      // 55: goto 59
      // 58: athrow
      // 59: ifeq 64
      // 5c: goto 60
      // 5f: athrow
      // 60: bipush 1
      // 61: goto 65
      // 64: bipush 0
      // 65: invokestatic net/minecraft/client/settings/KeyBinding.setKeyBindState (IZ)V
      // 68: return
   }

   private boolean à() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: new net/minecraft/util/BlockPos
      // 006: dup
      // 007: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 00a: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 00d: invokespecial net/minecraft/util/BlockPos.<init> (Lnet/minecraft/entity/Entity;)V
      // 010: invokevirtual net/minecraft/util/BlockPos.down ()Lnet/minecraft/util/BlockPos;
      // 013: astore 2
      // 014: istore 1
      // 015: aload 0
      // 016: aload 2
      // 017: invokevirtual x/oc668fce0dbf.à (Lnet/minecraft/util/BlockPos;)Z
      // 01a: iload 1
      // 01b: ifne 026
      // 01e: ifeq 027
      // 021: goto 025
      // 024: athrow
      // 025: bipush 1
      // 026: ireturn
      // 027: ldc2_w 1.7976931348623157E308
      // 02a: dstore 3
      // 02b: ldc_w -600042410
      // 02e: ldc_w -600042414
      // 031: ixor
      // 032: anewarray 1104
      // 035: dup
      // 036: bipush 0
      // 037: getstatic net/minecraft/util/EnumFacing.NORTH Lnet/minecraft/util/EnumFacing;
      // 03a: aastore
      // 03b: dup
      // 03c: bipush 1
      // 03d: getstatic net/minecraft/util/EnumFacing.SOUTH Lnet/minecraft/util/EnumFacing;
      // 040: aastore
      // 041: dup
      // 042: ldc_w -600042416
      // 045: ldc_w -600042414
      // 048: ixor
      // 049: getstatic net/minecraft/util/EnumFacing.WEST Lnet/minecraft/util/EnumFacing;
      // 04c: aastore
      // 04d: dup
      // 04e: ldc_w -600042415
      // 051: ldc_w -600042414
      // 054: ixor
      // 055: getstatic net/minecraft/util/EnumFacing.EAST Lnet/minecraft/util/EnumFacing;
      // 058: aastore
      // 059: astore 5
      // 05b: aload 5
      // 05d: astore 6
      // 05f: aload 6
      // 061: arraylength
      // 062: istore 7
      // 064: bipush 0
      // 065: istore 8
      // 067: iload 8
      // 069: iload 7
      // 06b: if_icmpge 0fc
      // 06e: aload 6
      // 070: iload 8
      // 072: aaload
      // 073: astore 9
      // 075: iload 1
      // 076: ifne 114
      // 079: aload 2
      // 07a: aload 9
      // 07c: invokevirtual net/minecraft/util/BlockPos.offset (Lnet/minecraft/util/EnumFacing;)Lnet/minecraft/util/BlockPos;
      // 07f: astore 10
      // 081: aload 0
      // 082: aload 10
      // 084: invokevirtual x/oc668fce0dbf.à (Lnet/minecraft/util/BlockPos;)Z
      // 087: ifne 092
      // 08a: iload 1
      // 08b: ifeq 0f5
      // 08e: goto 092
      // 091: athrow
      // 092: aload 9
      // 094: iload 1
      // 095: ifne 0ac
      // 098: goto 09c
      // 09b: athrow
      // 09c: getstatic net/minecraft/util/EnumFacing.NORTH Lnet/minecraft/util/EnumFacing;
      // 09f: if_acmpeq 0b2
      // 0a2: goto 0a6
      // 0a5: athrow
      // 0a6: aload 9
      // 0a8: goto 0ac
      // 0ab: athrow
      // 0ac: getstatic net/minecraft/util/EnumFacing.SOUTH Lnet/minecraft/util/EnumFacing;
      // 0af: if_acmpne 0d1
      // 0b2: aload 10
      // 0b4: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 0b7: i2d
      // 0b8: ldc2_w 0.5
      // 0bb: dadd
      // 0bc: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0bf: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0c2: getfield net/minecraft/client/entity/EntityPlayerSP.posZ D
      // 0c5: dsub
      // 0c6: invokestatic java/lang/Math.abs (D)D
      // 0c9: ldc2_w 0.5
      // 0cc: dsub
      // 0cd: goto 0ec
      // 0d0: athrow
      // 0d1: aload 10
      // 0d3: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 0d6: i2d
      // 0d7: ldc2_w 0.5
      // 0da: dadd
      // 0db: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0de: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0e1: getfield net/minecraft/client/entity/EntityPlayerSP.posX D
      // 0e4: dsub
      // 0e5: invokestatic java/lang/Math.abs (D)D
      // 0e8: ldc2_w 0.5
      // 0eb: dsub
      // 0ec: dstore 11
      // 0ee: dload 3
      // 0ef: dload 11
      // 0f1: invokestatic java/lang/Math.min (DD)D
      // 0f4: dstore 3
      // 0f5: iinc 8 1
      // 0f8: iload 1
      // 0f9: ifeq 067
      // 0fc: dload 3
      // 0fd: aload 0
      // 0fe: getfield x/oc668fce0dbf.ȍ Lx/oca9cc61aada;
      // 101: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 104: dcmpg
      // 105: iload 1
      // 106: ifne 111
      // 109: ifge 114
      // 10c: goto 110
      // 10f: athrow
      // 110: bipush 1
      // 111: goto 115
      // 114: bipush 0
      // 115: ireturn
   }

   private boolean à(BlockPos var1) {
      return oc69da1aa7f5.ő.theWorld.getBlockState(var1).getBlock().isReplaceable(oc69da1aa7f5.ő.theWorld, var1);
   }

   private void ӌ() {
      this.դ = 0;
      this.Β = 0;
      this.Ѡ = ո(this.Е);
   }

   private static int ո(ocf1568fef75 var0) {
      int var2 = 0;
      int var3 = 0;
      int var4 = 318402318 ^ -583829695;
      int var1 = oc84f20a0bc5.ė;

      while (true) {
         switch (var4) {
            case -808904625:
               var2 = (int)Math.round(var0.ö());
               if (var1 == 0) {
                  var3 = (int)Math.round(var0.і());
                  if (var2 == var3) {
                     var4 = -604554738 ^ -583829695;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var4 = -45108421 ^ -583829695;
               }

               if (var1 == 0) {
                  break;
               }
            case 545047674:
               return ThreadLocalRandom.current().nextInt(var2, var3 + 1);
            case 113528143:
               return var2;
            default:
               throw null;
         }
      }
   }

   private void Ã() {
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
      // 006: ifne 02a
      // 009: invokevirtual x/oc668fce0dbf.Ɯ ()Z
      // 00c: ifne 029
      // 00f: goto 013
      // 012: athrow
      // 013: aload 0
      // 014: getfield x/oc668fce0dbf.Ы Lx/occ2f8dff8d8;
      // 017: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 01a: iload 1
      // 01b: ifne 03a
      // 01e: goto 022
      // 021: athrow
      // 022: ifne 02e
      // 025: goto 029
      // 028: athrow
      // 029: aload 0
      // 02a: invokevirtual x/oc668fce0dbf.Ɏ ()V
      // 02d: return
      // 02e: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 031: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 034: getfield net/minecraft/client/settings/GameSettings.keyBindJump Lnet/minecraft/client/settings/KeyBinding;
      // 037: invokestatic x/oc7ab2161b9f.ն (Lnet/minecraft/client/settings/KeyBinding;)Z
      // 03a: istore 2
      // 03b: aload 0
      // 03c: getfield x/oc668fce0dbf.ґ Lx/occ2f8dff8d8;
      // 03f: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 042: iload 1
      // 043: ifne 05f
      // 046: ifne 05a
      // 049: goto 04d
      // 04c: athrow
      // 04d: aload 0
      // 04e: bipush 0
      // 04f: putfield x/oc668fce0dbf.ո Z
      // 052: iload 1
      // 053: ifeq 098
      // 056: goto 05a
      // 059: athrow
      // 05a: iload 2
      // 05b: goto 05f
      // 05e: athrow
      // 05f: iload 1
      // 060: ifne 084
      // 063: ifeq 077
      // 066: goto 06a
      // 069: athrow
      // 06a: aload 0
      // 06b: bipush 1
      // 06c: putfield x/oc668fce0dbf.ո Z
      // 06f: iload 1
      // 070: ifeq 098
      // 073: goto 077
      // 076: athrow
      // 077: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 07a: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 07d: getfield net/minecraft/client/entity/EntityPlayerSP.onGround Z
      // 080: goto 084
      // 083: athrow
      // 084: iload 1
      // 085: ifne 09f
      // 088: ifeq 098
      // 08b: goto 08f
      // 08e: athrow
      // 08f: aload 0
      // 090: bipush 0
      // 091: putfield x/oc668fce0dbf.ո Z
      // 094: goto 098
      // 097: athrow
      // 098: aload 0
      // 099: getfield x/oc668fce0dbf.ʖ Lx/occ2f8dff8d8;
      // 09c: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 09f: iload 1
      // 0a0: ifne 0c6
      // 0a3: ifeq 0c5
      // 0a6: goto 0aa
      // 0a9: athrow
      // 0aa: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0ad: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 0b0: getfield net/minecraft/client/settings/GameSettings.keyBindUseItem Lnet/minecraft/client/settings/KeyBinding;
      // 0b3: invokestatic x/oc7ab2161b9f.ն (Lnet/minecraft/client/settings/KeyBinding;)Z
      // 0b6: iload 1
      // 0b7: ifne 0c6
      // 0ba: goto 0be
      // 0bd: athrow
      // 0be: ifeq 0c9
      // 0c1: goto 0c5
      // 0c4: athrow
      // 0c5: bipush 1
      // 0c6: goto 0ca
      // 0c9: bipush 0
      // 0ca: istore 3
      // 0cb: iload 1
      // 0cc: ifne 0f3
      // 0cf: iload 3
      // 0d0: ifeq 0ea
      // 0d3: goto 0d7
      // 0d6: athrow
      // 0d7: aload 0
      // 0d8: iload 1
      // 0d9: ifne 0f5
      // 0dc: goto 0e0
      // 0df: athrow
      // 0e0: getfield x/oc668fce0dbf.ո Z
      // 0e3: ifeq 0f4
      // 0e6: goto 0ea
      // 0e9: athrow
      // 0ea: aload 0
      // 0eb: bipush 0
      // 0ec: putfield x/oc668fce0dbf.Ր Z
      // 0ef: goto 0f3
      // 0f2: athrow
      // 0f3: return
      // 0f4: aload 0
      // 0f5: iload 1
      // 0f6: ifne 118
      // 0f9: getfield x/oc668fce0dbf.Ր Z
      // 0fc: ifne 11c
      // 0ff: goto 103
      // 102: athrow
      // 103: aload 0
      // 104: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 107: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 10a: getfield net/minecraft/client/entity/EntityPlayerSP.posY D
      // 10d: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 110: putfield x/oc668fce0dbf.Ƚ I
      // 113: aload 0
      // 114: goto 118
      // 117: athrow
      // 118: bipush 1
      // 119: putfield x/oc668fce0dbf.Ր Z
      // 11c: return
   }

   private void Ɏ() {
      this.Ր = false;
      this.ո = false;
      this.Ƚ = 0;
   }

   private boolean ѧ() {
      int var1 = oc84f20a0bc5.ė;
      int var2 = -2125840331 ^ 1512286386;

      while (true) {
         switch (var2) {
            case -1758611042:
               int var9;
               label109: {
                  label108: {
                     try {
                        var9 = oc7ab2161b9f.ն(oc69da1aa7f5.ő.gameSettings.keyBindUseItem);
                        if (var1 != 0) {
                           break label109;
                        }

                        if (var9 == 0) {
                           break label108;
                        }
                     } catch (ocbde1165e4e var7) {
                        throw var7;
                     }

                     var2 = -1736730025 ^ 1512286386;
                     if (var1 == 0) {
                        continue;
                     }
                  }

                  var9 = -341243807 ^ 1512286386;
               }

               var2 = var9;
               if (var1 == 0) {
                  continue;
               }
            case 1998524545:
               int var10;
               label98: {
                  label97: {
                     try {
                        var10 = this.Ր;
                        if (var1 != 0) {
                           break label98;
                        }

                        if (!this.Ր) {
                           break label97;
                        }
                     } catch (ocbde1165e4e var6) {
                        throw var6;
                     }

                     var2 = -198741753 ^ 1512286386;
                     if (var1 == 0) {
                        continue;
                     }
                  }

                  var10 = -341243807 ^ 1512286386;
               }

               var2 = var10;
               if (var1 == 0) {
                  continue;
               }
            case -1375413835:
               break;
            case -1316314925:
               return false;
            case -1034407195:
               return true;
            case -613816185:
               int var8;
               label67: {
                  label66: {
                     try {
                        var8 = this.Ы.ǭ();
                        if (var1 != 0) {
                           break label67;
                        }

                        if (var8 == 0) {
                           break label66;
                        }
                     } catch (ocbde1165e4e var3) {
                        throw var3;
                     }

                     var2 = 758954035 ^ 1512286386;
                     if (var1 == 0) {
                        continue;
                     }
                  }

                  var8 = -341243807 ^ 1512286386;
               }

               var2 = var8;
               continue;
            case 413936326:
               int var10000;
               label76: {
                  label75: {
                     try {
                        var10000 = this.ʖ.ǭ();
                        if (var1 != 0) {
                           break label76;
                        }

                        if (var10000 == 0) {
                           break label75;
                        }
                     } catch (ocbde1165e4e var4) {
                        throw var4;
                     }

                     var2 = -854716116 ^ 1512286386;
                     if (var1 == 0) {
                        continue;
                     }
                  }

                  var10000 = -1736730025 ^ 1512286386;
               }

               var2 = var10000;
               if (var1 != 0) {
                  return false;
               }
               continue;
            default:
               throw null;
         }

         int var11;
         label85: {
            label84: {
               try {
                  var11 = this.ո;
                  if (var1 != 0) {
                     break label85;
                  }

                  if (this.ո) {
                     break label84;
                  }
               } catch (ocbde1165e4e var5) {
                  throw var5;
               }

               var2 = 1116701300 ^ 1512286386;
               if (var1 == 0) {
                  continue;
               }
            }

            var11 = -341243807 ^ 1512286386;
         }

         var2 = var11;
         if (var1 != 0) {
            return true;
         }
      }
   }

   private boolean Ɛ(ocf242f30eaa var1) {
      int var2 = oc84f20a0bc5.ė;
      int var3 = 487302583 ^ -739614999;

      while (true) {
         switch (var3) {
            case -868577623:
               return true;
            case -824050850:
               break;
            case 516018386:
               int var9;
               label57: {
                  label56: {
                     try {
                        float var12;
                        var9 = (var12 = var1.Υ() - 0.0F) == 0.0F ? 0 : (var12 < 0.0F ? -1 : 1);
                        if (var2 != 0) {
                           break label57;
                        }

                        if (var9 == 0) {
                           break label56;
                        }
                     } catch (ocbde1165e4e var4) {
                        throw var4;
                     }

                     var3 = 533778496 ^ -739614999;
                     if (var2 == 0) {
                        continue;
                     }
                  }

                  var9 = -25431952 ^ -739614999;
               }

               var3 = var9;
               continue;
            case 764522137:
               return false;
            case 1419291283:
               int var10000;
               label89: {
                  label88: {
                     try {
                        var10000 = oc69da1aa7f5.ő.thePlayer.onGround;
                        if (var2 != 0) {
                           break label89;
                        }

                        if (!oc69da1aa7f5.ő.thePlayer.onGround) {
                           break label88;
                        }
                     } catch (ocbde1165e4e var7) {
                        throw var7;
                     }

                     var3 = 1631935895 ^ -739614999;
                     if (var2 == 0) {
                        continue;
                     }
                  }

                  var10000 = -25431952 ^ -739614999;
               }

               var3 = var10000;
               if (var2 == 0) {
                  continue;
               }
            case -1297153154:
               int var8;
               label79: {
                  label78: {
                     try {
                        float var11;
                        var8 = (var11 = var1.Α() - 0.0F) == 0.0F ? 0 : (var11 < 0.0F ? -1 : 1);
                        if (var2 != 0) {
                           break label79;
                        }

                        if (var8 != 0) {
                           break label78;
                        }
                     } catch (ocbde1165e4e var6) {
                        throw var6;
                     }

                     var3 = -852783557 ^ -739614999;
                     if (var2 == 0) {
                        continue;
                     }
                  }

                  var8 = 533778496 ^ -739614999;
               }

               var3 = var8;
               if (var2 == 0) {
                  continue;
               }
               break;
            default:
               throw null;
         }

         int var10;
         label66: {
            label65: {
               try {
                  var10 = this.ѧ();
                  if (var2 != 0) {
                     break label66;
                  }

                  if (var10 == 0) {
                     break label65;
                  }
               } catch (ocbde1165e4e var5) {
                  throw var5;
               }

               var3 = -2022509446 ^ -739614999;
               if (var2 == 0) {
                  continue;
               }
            }

            var10 = -25431952 ^ -739614999;
         }

         var3 = var10;
         if (var2 != 0) {
            return true;
         }
      }
   }

   private boolean ˁ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: istore 1
      // 004: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 007: iload 1
      // 008: ifne 095
      // 00b: ifeq 090
      // 00e: goto 012
      // 011: athrow
      // 012: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 015: iload 1
      // 016: ifne 031
      // 019: goto 01d
      // 01c: athrow
      // 01d: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 020: getfield net/minecraft/client/entity/EntityPlayerSP.movementInput Lnet/minecraft/util/MovementInput;
      // 023: ifnull 090
      // 026: goto 02a
      // 029: athrow
      // 02a: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 02d: goto 031
      // 030: athrow
      // 031: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 034: getfield net/minecraft/client/entity/EntityPlayerSP.isCollidedHorizontally Z
      // 037: iload 1
      // 038: ifne 095
      // 03b: ifne 090
      // 03e: goto 042
      // 041: athrow
      // 042: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 045: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 048: getstatic net/minecraft/potion/Potion.blindness Lnet/minecraft/potion/Potion;
      // 04b: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isPotionActive (Lnet/minecraft/potion/Potion;)Z
      // 04e: iload 1
      // 04f: ifne 095
      // 052: goto 056
      // 055: athrow
      // 056: ifne 090
      // 059: goto 05d
      // 05c: athrow
      // 05d: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 060: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 063: invokevirtual net/minecraft/client/entity/EntityPlayerSP.isUsingItem ()Z
      // 066: iload 1
      // 067: ifne 095
      // 06a: goto 06e
      // 06d: athrow
      // 06e: ifne 090
      // 071: goto 075
      // 074: athrow
      // 075: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 078: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 07b: iload 1
      // 07c: ifne 09c
      // 07f: goto 083
      // 082: athrow
      // 083: getfield net/minecraft/client/entity/EntityPlayerSP.movementInput Lnet/minecraft/util/MovementInput;
      // 086: getfield net/minecraft/util/MovementInput.sneak Z
      // 089: ifeq 096
      // 08c: goto 090
      // 08f: athrow
      // 090: bipush 0
      // 091: goto 095
      // 094: athrow
      // 095: ireturn
      // 096: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 099: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 09c: getfield net/minecraft/client/entity/EntityPlayerSP.movementInput Lnet/minecraft/util/MovementInput;
      // 09f: getfield net/minecraft/util/MovementInput.moveForward F
      // 0a2: fconst_0
      // 0a3: fcmpl
      // 0a4: iload 1
      // 0a5: ifne 0cd
      // 0a8: ifne 0cc
      // 0ab: goto 0af
      // 0ae: athrow
      // 0af: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0b2: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0b5: getfield net/minecraft/client/entity/EntityPlayerSP.movementInput Lnet/minecraft/util/MovementInput;
      // 0b8: getfield net/minecraft/util/MovementInput.moveStrafe F
      // 0bb: fconst_0
      // 0bc: fcmpl
      // 0bd: iload 1
      // 0be: ifne 0cd
      // 0c1: goto 0c5
      // 0c4: athrow
      // 0c5: ifeq 0d0
      // 0c8: goto 0cc
      // 0cb: athrow
      // 0cc: bipush 1
      // 0cd: goto 0d1
      // 0d0: bipush 0
      // 0d1: istore 2
      // 0d2: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0d5: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0d8: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getFoodStats ()Lnet/minecraft/util/FoodStats;
      // 0db: invokevirtual net/minecraft/util/FoodStats.getFoodLevel ()I
      // 0de: iload 1
      // 0df: ifne 10c
      // 0e2: ldc_w 1705793680
      // 0e5: ldc_w 1705793686
      // 0e8: ixor
      // 0e9: if_icmpgt 10b
      // 0ec: goto 0f0
      // 0ef: athrow
      // 0f0: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0f3: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0f6: getfield net/minecraft/client/entity/EntityPlayerSP.capabilities Lnet/minecraft/entity/player/PlayerCapabilities;
      // 0f9: getfield net/minecraft/entity/player/PlayerCapabilities.allowFlying Z
      // 0fc: iload 1
      // 0fd: ifne 10c
      // 100: goto 104
      // 103: athrow
      // 104: ifeq 10f
      // 107: goto 10b
      // 10a: athrow
      // 10b: bipush 1
      // 10c: goto 110
      // 10f: bipush 0
      // 110: istore 3
      // 111: iload 2
      // 112: iload 1
      // 113: ifne 11e
      // 116: ifeq 12d
      // 119: goto 11d
      // 11c: athrow
      // 11d: iload 3
      // 11e: iload 1
      // 11f: ifne 12a
      // 122: ifeq 12d
      // 125: goto 129
      // 128: athrow
      // 129: bipush 1
      // 12a: goto 12e
      // 12d: bipush 0
      // 12e: ireturn
   }

   static boolean Ÿ(float var0) {
      int var1 = oc84f20a0bc5.ė;

      try {
         float var3;
         int var10000 = (var3 = var0 - 0.8F) == 0.0F ? 0 : (var3 < 0.0F ? -1 : 1);
         if (var1 != 0) {
            return (boolean)var10000;
         }

         if (var10000 >= 0) {
            return (boolean)1;
         }
      } catch (ocbde1165e4e var2) {
         throw var2;
      }

      return (boolean)0;
   }

   private float Ȃ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: invokestatic x/ocbb165642ef.ʨ ()Lx/ocbb165642ef;
      // 06: invokevirtual x/ocbb165642ef.ɦ ()Ljava/lang/Float;
      // 09: astore 2
      // 0a: istore 1
      // 0b: aload 2
      // 0c: iload 1
      // 0d: ifne 18
      // 10: ifnull 2c
      // 13: goto 17
      // 16: athrow
      // 17: aload 2
      // 18: invokevirtual java/lang/Float.isNaN ()Z
      // 1b: iload 1
      // 1c: ifne 38
      // 1f: ifne 2c
      // 22: goto 26
      // 25: athrow
      // 26: aload 2
      // 27: invokevirtual java/lang/Float.floatValue ()F
      // 2a: freturn
      // 2b: athrow
      // 2c: aload 0
      // 2d: iload 1
      // 2e: ifne 3c
      // 31: invokevirtual x/oc668fce0dbf.ȷ ()Z
      // 34: goto 38
      // 37: athrow
      // 38: ifeq 59
      // 3b: aload 0
      // 3c: iload 1
      // 3d: ifne 52
      // 40: getfield x/oc668fce0dbf.Ќ Lx/ocbce5ea28a3;
      // 43: invokevirtual x/ocbce5ea28a3.ԃ ()Z
      // 46: ifeq 59
      // 49: goto 4d
      // 4c: athrow
      // 4d: aload 0
      // 4e: goto 52
      // 51: athrow
      // 52: getfield x/oc668fce0dbf.Ќ Lx/ocbce5ea28a3;
      // 55: invokevirtual x/ocbce5ea28a3.ʈ ()F
      // 58: freturn
      // 59: getstatic x/oc668fce0dbf.ӧ Lx/oc7beea7ccff;
      // 5c: invokevirtual x/oc7beea7ccff.ɥ ()F
      // 5f: freturn
   }

   public oc84f20a0bc5 τ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: aload 0
      // 04: aload 0
      // 05: invokevirtual x/oc668fce0dbf.є ()F
      // 08: dconst_1
      // 09: invokestatic x/oc3e9033eba7.թ (D)Lnet/minecraft/util/AxisAlignedBB;
      // 0c: invokevirtual x/oc668fce0dbf.ӌ (FLnet/minecraft/util/AxisAlignedBB;)Lx/oc412a041b25;
      // 0f: astore 2
      // 10: istore 1
      // 11: aload 2
      // 12: iload 1
      // 13: ifne 23
      // 16: ifnonnull 22
      // 19: goto 1d
      // 1c: athrow
      // 1d: aconst_null
      // 1e: goto 26
      // 21: athrow
      // 22: aload 2
      // 23: getfield x/oc412a041b25.Ͳ Lx/oc84f20a0bc5;
      // 26: areturn
   }

   private oc412a041b25 ӌ(float param1, AxisAlignedBB param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 003: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 006: astore 4
      // 008: getstatic x/oc84f20a0bc5.ė I
      // 00b: aload 0
      // 00c: invokevirtual x/oc668fce0dbf.ѧ ()Z
      // 00f: istore 5
      // 011: istore 3
      // 012: iload 5
      // 014: ifeq 038
      // 017: new net/minecraft/util/BlockPos
      // 01a: dup
      // 01b: aload 4
      // 01d: getfield net/minecraft/client/entity/EntityPlayerSP.posX D
      // 020: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 023: aload 0
      // 024: getfield x/oc668fce0dbf.Ƚ I
      // 027: bipush 1
      // 028: isub
      // 029: aload 4
      // 02b: getfield net/minecraft/client/entity/EntityPlayerSP.posZ D
      // 02e: invokestatic net/minecraft/util/MathHelper.floor_double (D)I
      // 031: invokespecial net/minecraft/util/BlockPos.<init> (III)V
      // 034: goto 044
      // 037: athrow
      // 038: new net/minecraft/util/BlockPos
      // 03b: dup
      // 03c: aload 4
      // 03e: invokespecial net/minecraft/util/BlockPos.<init> (Lnet/minecraft/entity/Entity;)V
      // 041: invokevirtual net/minecraft/util/BlockPos.down ()Lnet/minecraft/util/BlockPos;
      // 044: astore 6
      // 046: aload 2
      // 047: getfield net/minecraft/util/AxisAlignedBB.minX D
      // 04a: aload 2
      // 04b: getfield net/minecraft/util/AxisAlignedBB.maxX D
      // 04e: dadd
      // 04f: ldc2_w 0.5
      // 052: dmul
      // 053: dstore 7
      // 055: aload 2
      // 056: getfield net/minecraft/util/AxisAlignedBB.minZ D
      // 059: aload 2
      // 05a: getfield net/minecraft/util/AxisAlignedBB.maxZ D
      // 05d: dadd
      // 05e: ldc2_w 0.5
      // 061: dmul
      // 062: dstore 9
      // 064: aload 6
      // 066: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 069: i2d
      // 06a: ldc2_w 0.5
      // 06d: dadd
      // 06e: dstore 11
      // 070: ldc2_w 1.7976931348623157E308
      // 073: dstore 13
      // 075: aload 4
      // 077: getfield net/minecraft/client/entity/EntityPlayerSP.onGround Z
      // 07a: iload 3
      // 07b: ifne 086
      // 07e: ifne 089
      // 081: goto 085
      // 084: athrow
      // 085: bipush 1
      // 086: goto 08a
      // 089: bipush 0
      // 08a: iload 5
      // 08c: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 08f: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 092: getfield net/minecraft/client/settings/GameSettings.keyBindJump Lnet/minecraft/client/settings/KeyBinding;
      // 095: invokestatic x/oc7ab2161b9f.ն (Lnet/minecraft/client/settings/KeyBinding;)Z
      // 098: invokestatic x/oc668fce0dbf.ґ (ZZZ)Z
      // 09b: istore 15
      // 09d: iload 15
      // 09f: iload 3
      // 0a0: ifne 0ab
      // 0a3: ifeq 0ae
      // 0a6: goto 0aa
      // 0a9: athrow
      // 0aa: bipush -1
      // 0ab: goto 0af
      // 0ae: bipush 0
      // 0af: istore 16
      // 0b1: invokestatic x/oc668fce0dbf.ɸ ()Lnet/minecraft/item/ItemBlock;
      // 0b4: astore 17
      // 0b6: new java/util/ArrayList
      // 0b9: dup
      // 0ba: invokespecial java/util/ArrayList.<init> ()V
      // 0bd: astore 18
      // 0bf: bipush 0
      // 0c0: istore 19
      // 0c2: iload 19
      // 0c4: iload 16
      // 0c6: if_icmplt 2f8
      // 0c9: iload 3
      // 0ca: ifne 307
      // 0cd: aload 6
      // 0cf: bipush 0
      // 0d0: iload 19
      // 0d2: bipush 0
      // 0d3: invokevirtual net/minecraft/util/BlockPos.add (III)Lnet/minecraft/util/BlockPos;
      // 0d6: astore 20
      // 0d8: ldc_w -85264567
      // 0db: ldc_w 85264565
      // 0de: ixor
      // 0df: istore 21
      // 0e1: iload 21
      // 0e3: ldc_w 85264561
      // 0e6: ldc_w 85264565
      // 0e9: ixor
      // 0ea: if_icmpgt 2f1
      // 0ed: iload 3
      // 0ee: ifne 2f4
      // 0f1: ldc_w -85264567
      // 0f4: ldc_w 85264565
      // 0f7: ixor
      // 0f8: istore 22
      // 0fa: iload 22
      // 0fc: ldc_w 85264561
      // 0ff: ldc_w 85264565
      // 102: ixor
      // 103: if_icmpgt 2ea
      // 106: iload 3
      // 107: ifne 2ed
      // 10a: aload 20
      // 10c: iload 21
      // 10e: bipush 0
      // 10f: iload 22
      // 111: invokevirtual net/minecraft/util/BlockPos.add (III)Lnet/minecraft/util/BlockPos;
      // 114: astore 23
      // 116: iload 3
      // 117: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 11a: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 11d: aload 23
      // 11f: invokevirtual net/minecraft/client/multiplayer/WorldClient.getBlockState (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // 122: astore 24
      // 124: ifne 2e6
      // 127: aload 24
      // 129: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 12e: getstatic net/minecraft/init/Blocks.air Lnet/minecraft/block/Block;
      // 131: if_acmpeq 2e3
      // 134: goto 138
      // 137: athrow
      // 138: aload 24
      // 13a: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 13f: invokevirtual net/minecraft/block/Block.isFullCube ()Z
      // 142: iload 3
      // 143: ifne 162
      // 146: goto 14a
      // 149: athrow
      // 14a: ifne 159
      // 14d: goto 151
      // 150: athrow
      // 151: iload 3
      // 152: ifeq 2e3
      // 155: goto 159
      // 158: athrow
      // 159: aload 23
      // 15b: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 15e: goto 162
      // 161: athrow
      // 162: i2d
      // 163: ldc2_w 0.5
      // 166: dadd
      // 167: dload 7
      // 169: dsub
      // 16a: dstore 25
      // 16c: aload 23
      // 16e: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 171: i2d
      // 172: ldc2_w 0.5
      // 175: dadd
      // 176: dload 9
      // 178: dsub
      // 179: dstore 27
      // 17b: aload 23
      // 17d: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 180: i2d
      // 181: ldc2_w 0.5
      // 184: dadd
      // 185: dload 11
      // 187: dsub
      // 188: dstore 29
      // 18a: dload 25
      // 18c: dload 25
      // 18e: dmul
      // 18f: dload 27
      // 191: dload 27
      // 193: dmul
      // 194: dadd
      // 195: dload 29
      // 197: dload 29
      // 199: dmul
      // 19a: ldc2_w 0.25
      // 19d: dmul
      // 19e: dadd
      // 19f: dstore 31
      // 1a1: dload 31
      // 1a3: iload 3
      // 1a4: ifne 1b7
      // 1a7: dload 13
      // 1a9: dcmpg
      // 1aa: ifge 1b9
      // 1ad: goto 1b1
      // 1b0: athrow
      // 1b1: dload 31
      // 1b3: goto 1b7
      // 1b6: athrow
      // 1b7: dstore 13
      // 1b9: new java/util/ArrayList
      // 1bc: dup
      // 1bd: ldc_w 85264561
      // 1c0: ldc_w 85264565
      // 1c3: ixor
      // 1c4: anewarray 1104
      // 1c7: dup
      // 1c8: bipush 0
      // 1c9: getstatic net/minecraft/util/EnumFacing.NORTH Lnet/minecraft/util/EnumFacing;
      // 1cc: aastore
      // 1cd: dup
      // 1ce: bipush 1
      // 1cf: getstatic net/minecraft/util/EnumFacing.SOUTH Lnet/minecraft/util/EnumFacing;
      // 1d2: aastore
      // 1d3: dup
      // 1d4: ldc_w 85264567
      // 1d7: ldc_w 85264565
      // 1da: ixor
      // 1db: getstatic net/minecraft/util/EnumFacing.WEST Lnet/minecraft/util/EnumFacing;
      // 1de: aastore
      // 1df: dup
      // 1e0: ldc_w 85264566
      // 1e3: ldc_w 85264565
      // 1e6: ixor
      // 1e7: getstatic net/minecraft/util/EnumFacing.EAST Lnet/minecraft/util/EnumFacing;
      // 1ea: aastore
      // 1eb: invokestatic java/util/Arrays.asList ([Ljava/lang/Object;)Ljava/util/List;
      // 1ee: invokespecial java/util/ArrayList.<init> (Ljava/util/Collection;)V
      // 1f1: astore 33
      // 1f3: iload 15
      // 1f5: iload 3
      // 1f6: ifne 20e
      // 1f9: ifeq 20f
      // 1fc: goto 200
      // 1ff: athrow
      // 200: aload 33
      // 202: getstatic net/minecraft/util/EnumFacing.UP Lnet/minecraft/util/EnumFacing;
      // 205: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 20a: goto 20e
      // 20d: athrow
      // 20e: pop
      // 20f: aload 33
      // 211: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 216: astore 34
      // 218: aload 34
      // 21a: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 21f: ifeq 2e3
      // 222: aload 34
      // 224: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 229: checkcast net/minecraft/util/EnumFacing
      // 22c: astore 35
      // 22e: iload 3
      // 22f: ifne 2e6
      // 232: aload 17
      // 234: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 237: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 23a: aload 23
      // 23c: aload 35
      // 23e: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 241: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 244: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 247: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 24a: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getHeldItem ()Lnet/minecraft/item/ItemStack;
      // 24d: invokevirtual net/minecraft/item/ItemBlock.canPlaceBlockOnSide (Lnet/minecraft/world/World;Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;Lnet/minecraft/entity/player/EntityPlayer;Lnet/minecraft/item/ItemStack;)Z
      // 250: ifne 25f
      // 253: goto 257
      // 256: athrow
      // 257: iload 3
      // 258: ifeq 218
      // 25b: goto 25f
      // 25e: athrow
      // 25f: aload 23
      // 261: aload 35
      // 263: invokevirtual net/minecraft/util/BlockPos.offset (Lnet/minecraft/util/EnumFacing;)Lnet/minecraft/util/BlockPos;
      // 266: astore 36
      // 268: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 26b: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 26e: aload 36
      // 270: invokevirtual net/minecraft/client/multiplayer/WorldClient.getBlockState (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // 273: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 278: getstatic net/minecraft/init/Blocks.air Lnet/minecraft/block/Block;
      // 27b: if_acmpeq 286
      // 27e: iload 3
      // 27f: ifeq 218
      // 282: goto 286
      // 285: athrow
      // 286: aload 36
      // 288: invokevirtual net/minecraft/util/BlockPos.getX ()I
      // 28b: i2d
      // 28c: ldc2_w 0.5
      // 28f: dadd
      // 290: dload 7
      // 292: dsub
      // 293: dstore 37
      // 295: iload 3
      // 296: aload 36
      // 298: invokevirtual net/minecraft/util/BlockPos.getZ ()I
      // 29b: i2d
      // 29c: ldc2_w 0.5
      // 29f: dadd
      // 2a0: dload 9
      // 2a2: dsub
      // 2a3: dstore 39
      // 2a5: aload 36
      // 2a7: invokevirtual net/minecraft/util/BlockPos.getY ()I
      // 2aa: i2d
      // 2ab: ldc2_w 0.5
      // 2ae: dadd
      // 2af: dload 11
      // 2b1: dsub
      // 2b2: dstore 41
      // 2b4: dload 37
      // 2b6: dload 37
      // 2b8: dmul
      // 2b9: dload 39
      // 2bb: dload 39
      // 2bd: dmul
      // 2be: dadd
      // 2bf: dload 41
      // 2c1: dload 41
      // 2c3: dmul
      // 2c4: ldc2_w 0.25
      // 2c7: dmul
      // 2c8: dadd
      // 2c9: dstore 43
      // 2cb: aload 18
      // 2cd: new x/oc78cbf6d293
      // 2d0: dup
      // 2d1: aload 23
      // 2d3: aload 35
      // 2d5: dload 43
      // 2d7: invokespecial x/oc78cbf6d293.<init> (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;D)V
      // 2da: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 2df: pop
      // 2e0: ifeq 218
      // 2e3: iinc 22 1
      // 2e6: iload 3
      // 2e7: ifeq 0fa
      // 2ea: iinc 21 1
      // 2ed: iload 3
      // 2ee: ifeq 0e1
      // 2f1: iinc 19 -1
      // 2f4: iload 3
      // 2f5: ifeq 0c2
      // 2f8: aload 18
      // 2fa: invokedynamic applyAsDouble ()Ljava/util/function/ToDoubleFunction; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)D, x/oc668fce0dbf.q1r49391t9zi6c (Lx/oc78cbf6d293;)D, (Lx/oc78cbf6d293;)D ]
      // 2ff: invokestatic java/util/Comparator.comparingDouble (Ljava/util/function/ToDoubleFunction;)Ljava/util/Comparator;
      // 302: invokeinterface java/util/List.sort (Ljava/util/Comparator;)V 2
      // 307: aload 0
      // 308: invokevirtual x/oc668fce0dbf.Ş ()F
      // 30b: fstore 19
      // 30d: aload 18
      // 30f: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 314: astore 20
      // 316: aload 20
      // 318: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 31d: ifeq 3b0
      // 320: aload 20
      // 322: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 327: checkcast x/oc78cbf6d293
      // 32a: astore 21
      // 32c: dload 13
      // 32e: aload 21
      // 330: getfield x/oc78cbf6d293.î D
      // 333: invokestatic x/oc668fce0dbf.ί (DD)Z
      // 336: ifne 341
      // 339: iload 3
      // 33a: ifeq 3b0
      // 33d: goto 341
      // 340: athrow
      // 341: aload 0
      // 342: aload 21
      // 344: getfield x/oc78cbf6d293.Ȉ Lnet/minecraft/util/BlockPos;
      // 347: aload 21
      // 349: getfield x/oc78cbf6d293.š Lnet/minecraft/util/EnumFacing;
      // 34c: fload 1
      // 34d: fload 19
      // 34f: invokevirtual x/oc668fce0dbf.ɬ (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;FF)Lx/oce50d12f5a5;
      // 352: astore 22
      // 354: aload 22
      // 356: ifnonnull 35e
      // 359: aconst_null
      // 35a: goto 36c
      // 35d: athrow
      // 35e: aload 0
      // 35f: aload 22
      // 361: getfield x/oce50d12f5a5.ç F
      // 364: aload 22
      // 366: getfield x/oce50d12f5a5.Ҡ F
      // 369: invokevirtual x/oc668fce0dbf.ǒ (FF)Lnet/minecraft/util/MovingObjectPosition;
      // 36c: astore 23
      // 36e: aload 23
      // 370: aload 21
      // 372: getfield x/oc78cbf6d293.Ȉ Lnet/minecraft/util/BlockPos;
      // 375: aload 21
      // 377: getfield x/oc78cbf6d293.š Lnet/minecraft/util/EnumFacing;
      // 37a: invokestatic x/oc668fce0dbf.Ԗ (Lnet/minecraft/util/MovingObjectPosition;Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;)Z
      // 37d: ifne 388
      // 380: iload 3
      // 381: ifeq 316
      // 384: goto 388
      // 387: athrow
      // 388: new x/oc412a041b25
      // 38b: dup
      // 38c: new x/oc84f20a0bc5
      // 38f: dup
      // 390: aload 21
      // 392: getfield x/oc78cbf6d293.Ȉ Lnet/minecraft/util/BlockPos;
      // 395: aload 21
      // 397: getfield x/oc78cbf6d293.š Lnet/minecraft/util/EnumFacing;
      // 39a: invokespecial x/oc84f20a0bc5.<init> (Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;)V
      // 39d: aload 22
      // 39f: getfield x/oce50d12f5a5.ç F
      // 3a2: aload 22
      // 3a4: getfield x/oce50d12f5a5.Ҡ F
      // 3a7: aload 22
      // 3a9: getfield x/oce50d12f5a5.Ֆ Z
      // 3ac: invokespecial x/oc412a041b25.<init> (Lx/oc84f20a0bc5;FFZ)V
      // 3af: areturn
      // 3b0: aconst_null
      // 3b1: areturn
   }

   public boolean ƽ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 1
      // 04: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 07: iload 1
      // 08: ifne 1d
      // 0b: ifeq 2c
      // 0e: goto 12
      // 11: athrow
      // 12: aload 0
      // 13: invokevirtual x/oc668fce0dbf.ǭ ()Lnet/minecraft/item/Item;
      // 16: instanceof net/minecraft/item/ItemBlock
      // 19: goto 1d
      // 1c: athrow
      // 1d: iload 1
      // 1e: ifne 29
      // 21: ifeq 2c
      // 24: goto 28
      // 27: athrow
      // 28: bipush 1
      // 29: goto 2d
      // 2c: bipush 0
      // 2d: ireturn
   }

   EntityPlayerSP ն() {
      return oc69da1aa7f5.ő.thePlayer;
   }

   float ʓ() {
      return this.ì();
   }

   float ӆ() {
      return this.ì();
   }

   boolean ҧ() {
      return this.ҵ.ǭ();
   }

   boolean lBool() {
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
      // 09: invokevirtual x/oc668fce0dbf.ȷ ()Z
      // 0c: ifeq 2d
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: goto 18
      // 17: athrow
      // 18: getfield x/oc668fce0dbf.Ś Lx/occ2f8dff8d8;
      // 1b: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 1e: iload 1
      // 1f: ifne 2a
      // 22: ifeq 2d
      // 25: goto 29
      // 28: athrow
      // 29: bipush 1
      // 2a: goto 2e
      // 2d: bipush 0
      // 2e: ireturn
   }

   boolean qBool() {
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
      // 05: getfield x/oc668fce0dbf.ɒ Lx/oca9cc61aada;
      // 08: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0b: d2i
      // 0c: iload 1
      // 0d: ifne 1d
      // 10: bipush 1
      // 11: if_icmpne 20
      // 14: goto 18
      // 17: athrow
      // 18: bipush 1
      // 19: goto 1d
      // 1c: athrow
      // 1d: goto 21
      // 20: bipush 0
      // 21: ireturn
   }

   int Ȅ() {
      return Math.max(1, Math.min(-381674868 ^ -381674874, (int)this.ӯ.Ӂ()));
   }

   boolean Λ(oc70db705765 var1, String var2) {
      return this.Ȉ.ɖ(oc69da1aa7f5.ő.thePlayer, oc69da1aa7f5.ő.theWorld, var1, var2);
   }

   boolean Ƹ() {
      return this.Ȉ.ҽ();
   }

   float б(float var1, float var2, float var3) {
      return this.ӎ.æ(var1, var2, var3);
   }

   void w(oc25aa89b91f var1, float var2, float var3) {
      var1.ȫ(this.б(var1.ƽ(), var2, var3));
   }

   boolean ӳ(float var1, float var2) {
      return this.ӎ.ť(var1, var2);
   }

   boolean ȉ() {
      return this.Ȉ.б();
   }

   void Ԝ(String var1) {
      this.Ȉ.Ϙ(var1);
   }

   private float ì() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: aload 0
      // 04: getfield x/oc668fce0dbf.ϩ Lx/oca9cc61aada;
      // 07: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0a: d2i
      // 0b: istore 2
      // 0c: istore 1
      // 0d: iload 2
      // 0e: iload 1
      // 0f: ifne 32
      // 12: iflt 2d
      // 15: goto 19
      // 18: athrow
      // 19: iload 2
      // 1a: iload 1
      // 1b: ifne 32
      // 1e: goto 22
      // 21: athrow
      // 22: getstatic x/oc668fce0dbf.ε [F
      // 25: arraylength
      // 26: if_icmplt 33
      // 29: goto 2d
      // 2c: athrow
      // 2d: bipush 1
      // 2e: goto 32
      // 31: athrow
      // 32: istore 2
      // 33: getstatic x/oc668fce0dbf.ε [F
      // 36: iload 2
      // 37: faload
      // 38: freturn
   }

   ItemBlock ҵ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: aload 0
      // 04: invokevirtual x/oc668fce0dbf.ǭ ()Lnet/minecraft/item/Item;
      // 07: astore 2
      // 08: istore 1
      // 09: aload 2
      // 0a: iload 1
      // 0b: ifne 1d
      // 0e: instanceof net/minecraft/item/ItemBlock
      // 11: ifeq 23
      // 14: goto 18
      // 17: athrow
      // 18: aload 2
      // 19: goto 1d
      // 1c: athrow
      // 1d: checkcast net/minecraft/item/ItemBlock
      // 20: goto 24
      // 23: aconst_null
      // 24: areturn
   }

   boolean Р() {
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
      // 05: invokevirtual x/oc668fce0dbf.Θ ()I
      // 08: iload 1
      // 09: ifne 19
      // 0c: bipush -1
      // 0d: if_icmpeq 1c
      // 10: goto 14
      // 13: athrow
      // 14: bipush 1
      // 15: goto 19
      // 18: athrow
      // 19: goto 1d
      // 1c: bipush 0
      // 1d: ireturn
   }

   boolean θ() {
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
      // 06: invokevirtual x/oc668fce0dbf.Θ ()I
      // 09: istore 2
      // 0a: ifne 1e
      // 0d: iload 2
      // 0e: bipush -1
      // 0f: if_icmpne 19
      // 12: goto 16
      // 15: athrow
      // 16: bipush 0
      // 17: ireturn
      // 18: athrow
      // 19: aload 0
      // 1a: iload 2
      // 1b: invokevirtual x/oc668fce0dbf.Ζ (I)V
      // 1e: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 21: iload 1
      // 22: ifne 37
      // 25: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 28: ifnonnull 34
      // 2b: goto 2f
      // 2e: athrow
      // 2f: aconst_null
      // 30: goto 40
      // 33: athrow
      // 34: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 37: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 3a: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 3d: invokevirtual net/minecraft/entity/player/InventoryPlayer.getCurrentItem ()Lnet/minecraft/item/ItemStack;
      // 40: astore 3
      // 41: aload 3
      // 42: iload 1
      // 43: ifne 4e
      // 46: ifnull 92
      // 49: goto 4d
      // 4c: athrow
      // 4d: aload 3
      // 4e: iload 1
      // 4f: ifne 61
      // 52: getfield net/minecraft/item/ItemStack.stackSize I
      // 55: ifle 92
      // 58: goto 5c
      // 5b: athrow
      // 5c: aload 3
      // 5d: goto 61
      // 60: athrow
      // 61: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 64: iload 1
      // 65: ifne 7a
      // 68: instanceof net/minecraft/item/ItemBlock
      // 6b: ifeq 92
      // 6e: goto 72
      // 71: athrow
      // 72: aload 3
      // 73: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 76: goto 7a
      // 79: athrow
      // 7a: checkcast net/minecraft/item/ItemBlock
      // 7d: invokevirtual net/minecraft/item/ItemBlock.getBlock ()Lnet/minecraft/block/Block;
      // 80: invokestatic x/oc668fce0dbf.Ň (Lnet/minecraft/block/Block;)Z
      // 83: iload 1
      // 84: ifne 8f
      // 87: ifeq 92
      // 8a: goto 8e
      // 8d: athrow
      // 8e: bipush 1
      // 8f: goto 93
      // 92: bipush 0
      // 93: ireturn
   }

   private int Θ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: istore 1
      // 004: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 007: iload 1
      // 008: ifne 01b
      // 00b: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 00e: ifnonnull 018
      // 011: goto 015
      // 014: athrow
      // 015: bipush -1
      // 016: ireturn
      // 017: athrow
      // 018: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 01b: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 01e: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 021: invokevirtual net/minecraft/entity/player/InventoryPlayer.getCurrentItem ()Lnet/minecraft/item/ItemStack;
      // 024: astore 2
      // 025: aload 2
      // 026: iload 1
      // 027: ifne 032
      // 02a: ifnull 081
      // 02d: goto 031
      // 030: athrow
      // 031: aload 2
      // 032: getfield net/minecraft/item/ItemStack.stackSize I
      // 035: iload 1
      // 036: ifne 082
      // 039: bipush 1
      // 03a: if_icmple 081
      // 03d: goto 041
      // 040: athrow
      // 041: aload 2
      // 042: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 045: instanceof net/minecraft/item/ItemBlock
      // 048: iload 1
      // 049: ifne 082
      // 04c: goto 050
      // 04f: athrow
      // 050: ifeq 081
      // 053: goto 057
      // 056: athrow
      // 057: aload 2
      // 058: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 05b: checkcast net/minecraft/item/ItemBlock
      // 05e: invokevirtual net/minecraft/item/ItemBlock.getBlock ()Lnet/minecraft/block/Block;
      // 061: invokestatic x/oc668fce0dbf.Ň (Lnet/minecraft/block/Block;)Z
      // 064: iload 1
      // 065: ifne 082
      // 068: goto 06c
      // 06b: athrow
      // 06c: ifeq 081
      // 06f: goto 073
      // 072: athrow
      // 073: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 076: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 079: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 07c: getfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 07f: ireturn
      // 080: athrow
      // 081: bipush -1
      // 082: istore 3
      // 083: bipush 0
      // 084: istore 4
      // 086: bipush 0
      // 087: istore 5
      // 089: iload 5
      // 08b: invokestatic net/minecraft/entity/player/InventoryPlayer.getHotbarSize ()I
      // 08e: if_icmpge 10d
      // 091: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 094: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 097: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 09a: iload 5
      // 09c: invokevirtual net/minecraft/entity/player/InventoryPlayer.getStackInSlot (I)Lnet/minecraft/item/ItemStack;
      // 09f: astore 6
      // 0a1: iload 1
      // 0a2: ifne 109
      // 0a5: aload 6
      // 0a7: ifnull 106
      // 0aa: goto 0ae
      // 0ad: athrow
      // 0ae: aload 6
      // 0b0: iload 1
      // 0b1: ifne 0ce
      // 0b4: goto 0b8
      // 0b7: athrow
      // 0b8: getfield net/minecraft/item/ItemStack.stackSize I
      // 0bb: iload 4
      // 0bd: if_icmple 106
      // 0c0: goto 0c4
      // 0c3: athrow
      // 0c4: aload 6
      // 0c6: iload 1
      // 0c7: ifne 0e1
      // 0ca: goto 0ce
      // 0cd: athrow
      // 0ce: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 0d1: instanceof net/minecraft/item/ItemBlock
      // 0d4: ifeq 106
      // 0d7: aload 6
      // 0d9: iload 1
      // 0da: ifne 0fe
      // 0dd: goto 0e1
      // 0e0: athrow
      // 0e1: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 0e4: checkcast net/minecraft/item/ItemBlock
      // 0e7: invokevirtual net/minecraft/item/ItemBlock.getBlock ()Lnet/minecraft/block/Block;
      // 0ea: invokestatic x/oc668fce0dbf.Ň (Lnet/minecraft/block/Block;)Z
      // 0ed: ifne 0f8
      // 0f0: iload 1
      // 0f1: ifeq 106
      // 0f4: goto 0f8
      // 0f7: athrow
      // 0f8: aload 6
      // 0fa: goto 0fe
      // 0fd: athrow
      // 0fe: getfield net/minecraft/item/ItemStack.stackSize I
      // 101: istore 4
      // 103: iload 5
      // 105: istore 3
      // 106: iinc 5 1
      // 109: iload 1
      // 10a: ifeq 089
      // 10d: iload 3
      // 10e: ireturn
   }

   private static boolean Ň(Block var0) {
      int var1 = oc84f20a0bc5.ė;
      int var2 = -907835135 ^ -795473911;

      while (true) {
         switch (var2) {
            case -547189279:
               int var10000;
               label36: {
                  label35: {
                     try {
                        var10000 = ӊ().contains(var0);
                        if (var1 != 0) {
                           break label36;
                        }

                        if (var10000 != 0) {
                           break label35;
                        }
                     } catch (ocbde1165e4e var3) {
                        throw var3;
                     }

                     var2 = -1523421686 ^ -795473911;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var10000 = -947346926 ^ -795473911;
               }

               var2 = var10000;
               break;
            case 387885595:
               return false;
            case 427131144:
               if (var0 != null) {
                  var2 = 267683304 ^ -795473911;
                  if (var1 == 0) {
                     break;
                  }
               }

               var2 = -947346926 ^ -795473911;
               if (var1 == 0) {
                  break;
               }
            case 1973708291:
               return true;
            default:
               throw null;
         }
      }
   }

   private static List<Block> ӊ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: istore 0
      // 004: getstatic x/oc668fce0dbf.Ƿ Ljava/util/List;
      // 007: iload 0
      // 008: ifne 215
      // 00b: ifnonnull 212
      // 00e: goto 012
      // 011: athrow
      // 012: ldc_w 860783075
      // 015: ldc_w 860783049
      // 018: ixor
      // 019: anewarray 1556
      // 01c: dup
      // 01d: bipush 0
      // 01e: getstatic net/minecraft/init/Blocks.enchanting_table Lnet/minecraft/block/Block;
      // 021: aastore
      // 022: dup
      // 023: bipush 1
      // 024: getstatic net/minecraft/init/Blocks.carpet Lnet/minecraft/block/Block;
      // 027: aastore
      // 028: dup
      // 029: ldc_w 860783051
      // 02c: ldc_w 860783049
      // 02f: ixor
      // 030: getstatic net/minecraft/init/Blocks.glass_pane Lnet/minecraft/block/Block;
      // 033: aastore
      // 034: dup
      // 035: ldc_w 860783050
      // 038: ldc_w 860783049
      // 03b: ixor
      // 03c: getstatic net/minecraft/init/Blocks.ladder Lnet/minecraft/block/Block;
      // 03f: aastore
      // 040: dup
      // 041: ldc_w 860783053
      // 044: ldc_w 860783049
      // 047: ixor
      // 048: getstatic net/minecraft/init/Blocks.web Lnet/minecraft/block/Block;
      // 04b: aastore
      // 04c: dup
      // 04d: ldc_w 860783052
      // 050: ldc_w 860783049
      // 053: ixor
      // 054: getstatic net/minecraft/init/Blocks.stained_glass_pane Lnet/minecraft/block/BlockStainedGlassPane;
      // 057: aastore
      // 058: dup
      // 059: ldc_w 860783055
      // 05c: ldc_w 860783049
      // 05f: ixor
      // 060: getstatic net/minecraft/init/Blocks.iron_bars Lnet/minecraft/block/Block;
      // 063: aastore
      // 064: dup
      // 065: ldc_w 860783054
      // 068: ldc_w 860783049
      // 06b: ixor
      // 06c: getstatic net/minecraft/init/Blocks.air Lnet/minecraft/block/Block;
      // 06f: aastore
      // 070: dup
      // 071: ldc_w 860783041
      // 074: ldc_w 860783049
      // 077: ixor
      // 078: getstatic net/minecraft/init/Blocks.water Lnet/minecraft/block/BlockStaticLiquid;
      // 07b: aastore
      // 07c: dup
      // 07d: ldc_w 860783040
      // 080: ldc_w 860783049
      // 083: ixor
      // 084: getstatic net/minecraft/init/Blocks.flowing_water Lnet/minecraft/block/BlockDynamicLiquid;
      // 087: aastore
      // 088: dup
      // 089: ldc_w 860783043
      // 08c: ldc_w 860783049
      // 08f: ixor
      // 090: getstatic net/minecraft/init/Blocks.lava Lnet/minecraft/block/BlockStaticLiquid;
      // 093: aastore
      // 094: dup
      // 095: ldc_w 860783042
      // 098: ldc_w 860783049
      // 09b: ixor
      // 09c: getstatic net/minecraft/init/Blocks.soul_sand Lnet/minecraft/block/Block;
      // 09f: aastore
      // 0a0: dup
      // 0a1: ldc_w 860783045
      // 0a4: ldc_w 860783049
      // 0a7: ixor
      // 0a8: getstatic net/minecraft/init/Blocks.ice Lnet/minecraft/block/Block;
      // 0ab: aastore
      // 0ac: dup
      // 0ad: ldc_w 860783044
      // 0b0: ldc_w 860783049
      // 0b3: ixor
      // 0b4: getstatic net/minecraft/init/Blocks.sand Lnet/minecraft/block/BlockSand;
      // 0b7: aastore
      // 0b8: dup
      // 0b9: ldc_w 860783047
      // 0bc: ldc_w 860783049
      // 0bf: ixor
      // 0c0: getstatic net/minecraft/init/Blocks.flowing_lava Lnet/minecraft/block/BlockDynamicLiquid;
      // 0c3: aastore
      // 0c4: dup
      // 0c5: ldc_w 860783046
      // 0c8: ldc_w 860783049
      // 0cb: ixor
      // 0cc: getstatic net/minecraft/init/Blocks.snow_layer Lnet/minecraft/block/Block;
      // 0cf: aastore
      // 0d0: dup
      // 0d1: ldc_w 860783065
      // 0d4: ldc_w 860783049
      // 0d7: ixor
      // 0d8: getstatic net/minecraft/init/Blocks.chest Lnet/minecraft/block/BlockChest;
      // 0db: aastore
      // 0dc: dup
      // 0dd: ldc_w 860783064
      // 0e0: ldc_w 860783049
      // 0e3: ixor
      // 0e4: getstatic net/minecraft/init/Blocks.ender_chest Lnet/minecraft/block/Block;
      // 0e7: aastore
      // 0e8: dup
      // 0e9: ldc_w 860783067
      // 0ec: ldc_w 860783049
      // 0ef: ixor
      // 0f0: getstatic net/minecraft/init/Blocks.torch Lnet/minecraft/block/Block;
      // 0f3: aastore
      // 0f4: dup
      // 0f5: ldc_w 860783066
      // 0f8: ldc_w 860783049
      // 0fb: ixor
      // 0fc: getstatic net/minecraft/init/Blocks.anvil Lnet/minecraft/block/Block;
      // 0ff: aastore
      // 100: dup
      // 101: ldc_w 860783069
      // 104: ldc_w 860783049
      // 107: ixor
      // 108: getstatic net/minecraft/init/Blocks.trapped_chest Lnet/minecraft/block/Block;
      // 10b: aastore
      // 10c: dup
      // 10d: ldc_w 860783068
      // 110: ldc_w 860783049
      // 113: ixor
      // 114: getstatic net/minecraft/init/Blocks.noteblock Lnet/minecraft/block/Block;
      // 117: aastore
      // 118: dup
      // 119: ldc_w 860783071
      // 11c: ldc_w 860783049
      // 11f: ixor
      // 120: getstatic net/minecraft/init/Blocks.jukebox Lnet/minecraft/block/Block;
      // 123: aastore
      // 124: dup
      // 125: ldc_w 860783070
      // 128: ldc_w 860783049
      // 12b: ixor
      // 12c: getstatic net/minecraft/init/Blocks.wooden_pressure_plate Lnet/minecraft/block/Block;
      // 12f: aastore
      // 130: dup
      // 131: ldc_w 860783057
      // 134: ldc_w 860783049
      // 137: ixor
      // 138: getstatic net/minecraft/init/Blocks.stone_pressure_plate Lnet/minecraft/block/Block;
      // 13b: aastore
      // 13c: dup
      // 13d: ldc_w 860783056
      // 140: ldc_w 860783049
      // 143: ixor
      // 144: getstatic net/minecraft/init/Blocks.light_weighted_pressure_plate Lnet/minecraft/block/Block;
      // 147: aastore
      // 148: dup
      // 149: ldc_w 860783059
      // 14c: ldc_w 860783049
      // 14f: ixor
      // 150: getstatic net/minecraft/init/Blocks.heavy_weighted_pressure_plate Lnet/minecraft/block/Block;
      // 153: aastore
      // 154: dup
      // 155: ldc_w 860783058
      // 158: ldc_w 860783049
      // 15b: ixor
      // 15c: getstatic net/minecraft/init/Blocks.stone_button Lnet/minecraft/block/Block;
      // 15f: aastore
      // 160: dup
      // 161: ldc_w 860783061
      // 164: ldc_w 860783049
      // 167: ixor
      // 168: getstatic net/minecraft/init/Blocks.tnt Lnet/minecraft/block/Block;
      // 16b: aastore
      // 16c: dup
      // 16d: ldc_w 860783060
      // 170: ldc_w 860783049
      // 173: ixor
      // 174: getstatic net/minecraft/init/Blocks.wooden_button Lnet/minecraft/block/Block;
      // 177: aastore
      // 178: dup
      // 179: ldc_w 860783063
      // 17c: ldc_w 860783049
      // 17f: ixor
      // 180: getstatic net/minecraft/init/Blocks.lever Lnet/minecraft/block/Block;
      // 183: aastore
      // 184: dup
      // 185: ldc_w 860783062
      // 188: ldc_w 860783049
      // 18b: ixor
      // 18c: getstatic net/minecraft/init/Blocks.crafting_table Lnet/minecraft/block/Block;
      // 18f: aastore
      // 190: dup
      // 191: ldc_w 860783081
      // 194: ldc_w 860783049
      // 197: ixor
      // 198: getstatic net/minecraft/init/Blocks.furnace Lnet/minecraft/block/Block;
      // 19b: aastore
      // 19c: dup
      // 19d: ldc_w 860783080
      // 1a0: ldc_w 860783049
      // 1a3: ixor
      // 1a4: getstatic net/minecraft/init/Blocks.stone_slab Lnet/minecraft/block/BlockSlab;
      // 1a7: aastore
      // 1a8: dup
      // 1a9: ldc_w 860783083
      // 1ac: ldc_w 860783049
      // 1af: ixor
      // 1b0: getstatic net/minecraft/init/Blocks.wooden_slab Lnet/minecraft/block/BlockSlab;
      // 1b3: aastore
      // 1b4: dup
      // 1b5: ldc_w 860783082
      // 1b8: ldc_w 860783049
      // 1bb: ixor
      // 1bc: getstatic net/minecraft/init/Blocks.stone_slab2 Lnet/minecraft/block/BlockSlab;
      // 1bf: aastore
      // 1c0: dup
      // 1c1: ldc_w 860783085
      // 1c4: ldc_w 860783049
      // 1c7: ixor
      // 1c8: getstatic net/minecraft/init/Blocks.brown_mushroom Lnet/minecraft/block/BlockBush;
      // 1cb: aastore
      // 1cc: dup
      // 1cd: ldc_w 860783084
      // 1d0: ldc_w 860783049
      // 1d3: ixor
      // 1d4: getstatic net/minecraft/init/Blocks.red_mushroom Lnet/minecraft/block/BlockBush;
      // 1d7: aastore
      // 1d8: dup
      // 1d9: ldc_w 860783087
      // 1dc: ldc_w 860783049
      // 1df: ixor
      // 1e0: getstatic net/minecraft/init/Blocks.gold_block Lnet/minecraft/block/Block;
      // 1e3: aastore
      // 1e4: dup
      // 1e5: ldc_w 860783086
      // 1e8: ldc_w 860783049
      // 1eb: ixor
      // 1ec: getstatic net/minecraft/init/Blocks.red_flower Lnet/minecraft/block/BlockFlower;
      // 1ef: aastore
      // 1f0: dup
      // 1f1: ldc_w 860783073
      // 1f4: ldc_w 860783049
      // 1f7: ixor
      // 1f8: getstatic net/minecraft/init/Blocks.yellow_flower Lnet/minecraft/block/BlockFlower;
      // 1fb: aastore
      // 1fc: dup
      // 1fd: ldc_w 860783072
      // 200: ldc_w 860783049
      // 203: ixor
      // 204: getstatic net/minecraft/init/Blocks.flower_pot Lnet/minecraft/block/Block;
      // 207: aastore
      // 208: invokestatic java/util/Arrays.asList ([Ljava/lang/Object;)Ljava/util/List;
      // 20b: putstatic x/oc668fce0dbf.Ƿ Ljava/util/List;
      // 20e: goto 212
      // 211: athrow
      // 212: getstatic x/oc668fce0dbf.Ƿ Ljava/util/List;
      // 215: areturn
   }

   boolean ӥ(BlockPos param1, EnumFacing param2, MovingObjectPosition param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: istore 4
      // 005: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 008: iload 4
      // 00a: ifne 01e
      // 00d: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 010: ifnull 0a7
      // 013: goto 017
      // 016: athrow
      // 017: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 01a: goto 01e
      // 01d: athrow
      // 01e: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 021: ifnull 0a7
      // 024: aload 1
      // 025: ifnull 0a7
      // 028: goto 02c
      // 02b: athrow
      // 02c: aload 2
      // 02d: ifnull 0a7
      // 030: goto 034
      // 033: athrow
      // 034: aload 3
      // 035: iload 4
      // 037: ifne 046
      // 03a: goto 03e
      // 03d: athrow
      // 03e: ifnull 0a7
      // 041: goto 045
      // 044: athrow
      // 045: aload 3
      // 046: iload 4
      // 048: ifne 05d
      // 04b: getfield net/minecraft/util/MovingObjectPosition.typeOfHit Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // 04e: getstatic net/minecraft/util/MovingObjectPosition$MovingObjectType.BLOCK Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // 051: if_acmpne 0a7
      // 054: goto 058
      // 057: athrow
      // 058: aload 3
      // 059: goto 05d
      // 05c: athrow
      // 05d: invokevirtual net/minecraft/util/MovingObjectPosition.getBlockPos ()Lnet/minecraft/util/BlockPos;
      // 060: iload 4
      // 062: ifne 06d
      // 065: ifnull 0a7
      // 068: goto 06c
      // 06b: athrow
      // 06c: aload 1
      // 06d: aload 3
      // 06e: invokevirtual net/minecraft/util/MovingObjectPosition.getBlockPos ()Lnet/minecraft/util/BlockPos;
      // 071: invokevirtual net/minecraft/util/BlockPos.equals (Ljava/lang/Object;)Z
      // 074: iload 4
      // 076: ifne 0a8
      // 079: ifeq 0a7
      // 07c: goto 080
      // 07f: athrow
      // 080: aload 2
      // 081: aload 3
      // 082: getfield net/minecraft/util/MovingObjectPosition.sideHit Lnet/minecraft/util/EnumFacing;
      // 085: if_acmpne 0a7
      // 088: goto 08c
      // 08b: athrow
      // 08c: aload 0
      // 08d: getfield x/oc668fce0dbf.ӎ Lx/ocae1739aac7;
      // 090: aload 3
      // 091: getfield net/minecraft/util/MovingObjectPosition.sideHit Lnet/minecraft/util/EnumFacing;
      // 094: invokevirtual x/ocae1739aac7.ö (Lnet/minecraft/util/EnumFacing;)Z
      // 097: iload 4
      // 099: ifne 0a8
      // 09c: goto 0a0
      // 09f: athrow
      // 0a0: ifne 0a9
      // 0a3: goto 0a7
      // 0a6: athrow
      // 0a7: bipush 0
      // 0a8: ireturn
      // 0a9: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0ac: iload 4
      // 0ae: ifne 0d3
      // 0b1: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 0b4: aload 3
      // 0b5: invokevirtual net/minecraft/util/MovingObjectPosition.getBlockPos ()Lnet/minecraft/util/BlockPos;
      // 0b8: invokevirtual net/minecraft/client/multiplayer/WorldClient.getBlockState (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // 0bb: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 0c0: invokevirtual net/minecraft/block/Block.getMaterial ()Lnet/minecraft/block/material/Material;
      // 0c3: getstatic net/minecraft/block/material/Material.air Lnet/minecraft/block/material/Material;
      // 0c6: if_acmpne 0d0
      // 0c9: goto 0cd
      // 0cc: athrow
      // 0cd: bipush 0
      // 0ce: ireturn
      // 0cf: athrow
      // 0d0: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0d3: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0d6: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 0d9: invokevirtual net/minecraft/entity/player/InventoryPlayer.getCurrentItem ()Lnet/minecraft/item/ItemStack;
      // 0dc: astore 5
      // 0de: aload 5
      // 0e0: iload 4
      // 0e2: ifne 0ee
      // 0e5: ifnull 100
      // 0e8: goto 0ec
      // 0eb: athrow
      // 0ec: aload 5
      // 0ee: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 0f1: instanceof net/minecraft/item/ItemBlock
      // 0f4: iload 4
      // 0f6: ifne 126
      // 0f9: ifne 103
      // 0fc: goto 100
      // 0ff: athrow
      // 100: bipush 0
      // 101: ireturn
      // 102: athrow
      // 103: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 106: getfield net/minecraft/client/Minecraft.playerController Lnet/minecraft/client/multiplayer/PlayerControllerMP;
      // 109: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 10c: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 10f: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 112: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 115: aload 5
      // 117: aload 3
      // 118: invokevirtual net/minecraft/util/MovingObjectPosition.getBlockPos ()Lnet/minecraft/util/BlockPos;
      // 11b: aload 3
      // 11c: getfield net/minecraft/util/MovingObjectPosition.sideHit Lnet/minecraft/util/EnumFacing;
      // 11f: aload 3
      // 120: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 123: invokevirtual net/minecraft/client/multiplayer/PlayerControllerMP.onPlayerRightClick (Lnet/minecraft/client/entity/EntityPlayerSP;Lnet/minecraft/client/multiplayer/WorldClient;Lnet/minecraft/item/ItemStack;Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;Lnet/minecraft/util/Vec3;)Z
      // 126: istore 6
      // 128: iload 6
      // 12a: iload 4
      // 12c: ifne 15d
      // 12f: ifeq 15b
      // 132: goto 136
      // 135: athrow
      // 136: aload 0
      // 137: invokevirtual x/oc668fce0dbf.Ϫ ()V
      // 13a: aload 0
      // 13b: getfield x/oc668fce0dbf.ʱ Lx/oc08992069b4;
      // 13e: aload 3
      // 13f: invokevirtual net/minecraft/util/MovingObjectPosition.getBlockPos ()Lnet/minecraft/util/BlockPos;
      // 142: aload 3
      // 143: getfield net/minecraft/util/MovingObjectPosition.sideHit Lnet/minecraft/util/EnumFacing;
      // 146: invokevirtual net/minecraft/util/BlockPos.offset (Lnet/minecraft/util/EnumFacing;)Lnet/minecraft/util/BlockPos;
      // 149: invokevirtual x/oc08992069b4.Ѵ (Lnet/minecraft/util/BlockPos;)V
      // 14c: aload 0
      // 14d: ldc_w 892933899
      // 150: ldc_w 892933902
      // 153: ixor
      // 154: putfield x/oc668fce0dbf.ԛ I
      // 157: goto 15b
      // 15a: athrow
      // 15b: iload 6
      // 15d: ireturn
   }

   boolean Ѭ(oc84f20a0bc5 param1, MovingObjectPosition param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc84f20a0bc5.ė I
      // 003: istore 3
      // 004: aload 1
      // 005: ifnull 07b
      // 008: aload 2
      // 009: iload 3
      // 00a: ifne 019
      // 00d: goto 011
      // 010: athrow
      // 011: ifnull 07b
      // 014: goto 018
      // 017: athrow
      // 018: aload 2
      // 019: getfield net/minecraft/util/MovingObjectPosition.typeOfHit Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // 01c: getstatic net/minecraft/util/MovingObjectPosition$MovingObjectType.BLOCK Lnet/minecraft/util/MovingObjectPosition$MovingObjectType;
      // 01f: if_acmpne 07b
      // 022: aload 1
      // 023: invokevirtual x/oc84f20a0bc5.ʒ ()Lnet/minecraft/util/BlockPos;
      // 026: aload 2
      // 027: invokevirtual net/minecraft/util/MovingObjectPosition.getBlockPos ()Lnet/minecraft/util/BlockPos;
      // 02a: invokevirtual net/minecraft/util/BlockPos.equals (Ljava/lang/Object;)Z
      // 02d: iload 3
      // 02e: ifne 080
      // 031: goto 035
      // 034: athrow
      // 035: ifeq 07b
      // 038: goto 03c
      // 03b: athrow
      // 03c: aload 1
      // 03d: iload 3
      // 03e: ifne 058
      // 041: goto 045
      // 044: athrow
      // 045: invokevirtual x/oc84f20a0bc5.Ӈ ()Lnet/minecraft/util/EnumFacing;
      // 048: aload 2
      // 049: getfield net/minecraft/util/MovingObjectPosition.sideHit Lnet/minecraft/util/EnumFacing;
      // 04c: if_acmpne 07b
      // 04f: goto 053
      // 052: athrow
      // 053: aload 1
      // 054: goto 058
      // 057: athrow
      // 058: invokevirtual x/oc84f20a0bc5.Ӈ ()Lnet/minecraft/util/EnumFacing;
      // 05b: getstatic net/minecraft/util/EnumFacing.DOWN Lnet/minecraft/util/EnumFacing;
      // 05e: if_acmpeq 07b
      // 061: aload 0
      // 062: iload 3
      // 063: ifne 082
      // 066: goto 06a
      // 069: athrow
      // 06a: getfield x/oc668fce0dbf.ӎ Lx/ocae1739aac7;
      // 06d: aload 2
      // 06e: getfield net/minecraft/util/MovingObjectPosition.sideHit Lnet/minecraft/util/EnumFacing;
      // 071: invokevirtual x/ocae1739aac7.ö (Lnet/minecraft/util/EnumFacing;)Z
      // 074: ifne 081
      // 077: goto 07b
      // 07a: athrow
      // 07b: bipush 0
      // 07c: goto 080
      // 07f: athrow
      // 080: ireturn
      // 081: aload 0
      // 082: invokevirtual x/oc668fce0dbf.ǭ ()Lnet/minecraft/item/Item;
      // 085: astore 4
      // 087: aload 4
      // 089: instanceof net/minecraft/item/ItemBlock
      // 08c: iload 3
      // 08d: ifne 0cc
      // 090: ifeq 0cb
      // 093: goto 097
      // 096: athrow
      // 097: aload 4
      // 099: checkcast net/minecraft/item/ItemBlock
      // 09c: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 09f: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 0a2: aload 2
      // 0a3: invokevirtual net/minecraft/util/MovingObjectPosition.getBlockPos ()Lnet/minecraft/util/BlockPos;
      // 0a6: aload 2
      // 0a7: getfield net/minecraft/util/MovingObjectPosition.sideHit Lnet/minecraft/util/EnumFacing;
      // 0aa: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0ad: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0b0: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0b3: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0b6: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getHeldItem ()Lnet/minecraft/item/ItemStack;
      // 0b9: invokevirtual net/minecraft/item/ItemBlock.canPlaceBlockOnSide (Lnet/minecraft/world/World;Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;Lnet/minecraft/entity/player/EntityPlayer;Lnet/minecraft/item/ItemStack;)Z
      // 0bc: iload 3
      // 0bd: ifne 0cc
      // 0c0: goto 0c4
      // 0c3: athrow
      // 0c4: ifne 0cd
      // 0c7: goto 0cb
      // 0ca: athrow
      // 0cb: bipush 0
      // 0cc: ireturn
      // 0cd: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0d0: iload 3
      // 0d1: ifne 0f6
      // 0d4: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 0d7: aload 2
      // 0d8: invokevirtual net/minecraft/util/MovingObjectPosition.getBlockPos ()Lnet/minecraft/util/BlockPos;
      // 0db: invokevirtual net/minecraft/client/multiplayer/WorldClient.getBlockState (Lnet/minecraft/util/BlockPos;)Lnet/minecraft/block/state/IBlockState;
      // 0de: invokeinterface net/minecraft/block/state/IBlockState.getBlock ()Lnet/minecraft/block/Block; 1
      // 0e3: invokevirtual net/minecraft/block/Block.getMaterial ()Lnet/minecraft/block/material/Material;
      // 0e6: getstatic net/minecraft/block/material/Material.air Lnet/minecraft/block/material/Material;
      // 0e9: if_acmpne 0f3
      // 0ec: goto 0f0
      // 0ef: athrow
      // 0f0: bipush 0
      // 0f1: ireturn
      // 0f2: athrow
      // 0f3: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0f6: getfield net/minecraft/client/Minecraft.playerController Lnet/minecraft/client/multiplayer/PlayerControllerMP;
      // 0f9: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0fc: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0ff: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 102: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 105: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 108: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 10b: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 10e: invokevirtual net/minecraft/entity/player/InventoryPlayer.getCurrentItem ()Lnet/minecraft/item/ItemStack;
      // 111: aload 1
      // 112: invokevirtual x/oc84f20a0bc5.ʒ ()Lnet/minecraft/util/BlockPos;
      // 115: aload 1
      // 116: invokevirtual x/oc84f20a0bc5.Ӈ ()Lnet/minecraft/util/EnumFacing;
      // 119: aload 2
      // 11a: getfield net/minecraft/util/MovingObjectPosition.hitVec Lnet/minecraft/util/Vec3;
      // 11d: invokevirtual net/minecraft/client/multiplayer/PlayerControllerMP.onPlayerRightClick (Lnet/minecraft/client/entity/EntityPlayerSP;Lnet/minecraft/client/multiplayer/WorldClient;Lnet/minecraft/item/ItemStack;Lnet/minecraft/util/BlockPos;Lnet/minecraft/util/EnumFacing;Lnet/minecraft/util/Vec3;)Z
      // 120: istore 5
      // 122: aload 0
      // 123: invokevirtual x/oc668fce0dbf.Ϫ ()V
      // 126: iload 5
      // 128: iload 3
      // 129: ifne 160
      // 12c: ifeq 15e
      // 12f: goto 133
      // 132: athrow
      // 133: aload 0
      // 134: getfield x/oc668fce0dbf.ʱ Lx/oc08992069b4;
      // 137: aload 1
      // 138: invokevirtual x/oc84f20a0bc5.ʒ ()Lnet/minecraft/util/BlockPos;
      // 13b: aload 1
      // 13c: invokevirtual x/oc84f20a0bc5.Ӈ ()Lnet/minecraft/util/EnumFacing;
      // 13f: invokevirtual net/minecraft/util/BlockPos.offset (Lnet/minecraft/util/EnumFacing;)Lnet/minecraft/util/BlockPos;
      // 142: invokevirtual x/oc08992069b4.Ѵ (Lnet/minecraft/util/BlockPos;)V
      // 145: aload 0
      // 146: dup
      // 147: getfield x/oc668fce0dbf.Β I
      // 14a: bipush 1
      // 14b: iadd
      // 14c: putfield x/oc668fce0dbf.Β I
      // 14f: aload 0
      // 150: ldc_w 1056924787
      // 153: ldc_w 1056924790
      // 156: ixor
      // 157: putfield x/oc668fce0dbf.ԛ I
      // 15a: goto 15e
      // 15d: athrow
      // 15e: iload 5
      // 160: ireturn
   }

   void Ѥ() {
      this.ռ(this.Ќ.н());
   }

   void Σ(boolean param1) {
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
      // 09: invokevirtual x/oc668fce0dbf.Ɯ ()Z
      // 0c: ifeq 1c
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: goto 18
      // 17: athrow
      // 18: iload 1
      // 19: invokevirtual x/oc668fce0dbf.ռ (Z)V
      // 1c: return
   }

   private Item ǭ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 06: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 09: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 0c: invokevirtual net/minecraft/entity/player/InventoryPlayer.getCurrentItem ()Lnet/minecraft/item/ItemStack;
      // 0f: astore 2
      // 10: istore 1
      // 11: aload 2
      // 12: iload 1
      // 13: ifne 1e
      // 16: ifnull 43
      // 19: goto 1d
      // 1c: athrow
      // 1d: aload 2
      // 1e: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 21: instanceof net/minecraft/item/ItemBlock
      // 24: iload 1
      // 25: ifne 4a
      // 28: ifeq 43
      // 2b: goto 2f
      // 2e: athrow
      // 2f: aload 2
      // 30: iload 1
      // 31: ifne cb
      // 34: goto 38
      // 37: athrow
      // 38: getfield net/minecraft/item/ItemStack.stackSize I
      // 3b: bipush 1
      // 3c: if_icmpgt b9
      // 3f: goto 43
      // 42: athrow
      // 43: invokestatic x/oc3e9033eba7.Ȓ ()I
      // 46: goto 4a
      // 49: athrow
      // 4a: istore 3
      // 4b: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 4e: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 51: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 54: iload 3
      // 55: invokevirtual net/minecraft/entity/player/InventoryPlayer.getStackInSlot (I)Lnet/minecraft/item/ItemStack;
      // 58: astore 4
      // 5a: aload 4
      // 5c: iload 1
      // 5d: ifne 90
      // 60: ifnull 8b
      // 63: goto 67
      // 66: athrow
      // 67: aload 4
      // 69: iload 1
      // 6a: ifne 90
      // 6d: goto 71
      // 70: athrow
      // 71: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // 74: instanceof net/minecraft/item/ItemBlock
      // 77: ifeq 8b
      // 7a: goto 7e
      // 7d: athrow
      // 7e: aload 0
      // 7f: iload 3
      // 80: invokevirtual x/oc668fce0dbf.Ζ (I)V
      // 83: iload 1
      // 84: ifeq b9
      // 87: goto 8b
      // 8a: athrow
      // 8b: aload 2
      // 8c: goto 90
      // 8f: athrow
      // 90: iload 1
      // 91: ifne 9c
      // 94: ifnull ad
      // 97: goto 9b
      // 9a: athrow
      // 9b: aload 2
      // 9c: iload 1
      // 9d: ifne cb
      // a0: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // a3: instanceof net/minecraft/item/ItemBlock
      // a6: ifne b9
      // a9: goto ad
      // ac: athrow
      // ad: getstatic x/oc718fd4d503.Ō Lx/oc718fd4d503;
      // b0: aload 0
      // b1: bipush 1
      // b2: invokevirtual x/oc718fd4d503.à (Ljava/lang/Object;Z)V
      // b5: goto b9
      // b8: athrow
      // b9: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // bc: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // bf: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // c2: invokevirtual net/minecraft/entity/player/InventoryPlayer.getCurrentItem ()Lnet/minecraft/item/ItemStack;
      // c5: iload 1
      // c6: ifne d4
      // c9: astore 2
      // ca: aload 2
      // cb: ifnonnull d3
      // ce: aconst_null
      // cf: goto d7
      // d2: athrow
      // d3: aload 2
      // d4: invokevirtual net/minecraft/item/ItemStack.getItem ()Lnet/minecraft/item/Item;
      // d7: areturn
   }

   private void Ζ(int param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 2
      // 04: iload 1
      // 05: iload 2
      // 06: ifne 11
      // 09: iflt 1f
      // 0c: goto 10
      // 0f: athrow
      // 10: iload 1
      // 11: iload 2
      // 12: ifne 35
      // 15: invokestatic net/minecraft/entity/player/InventoryPlayer.getHotbarSize ()I
      // 18: if_icmplt 21
      // 1b: goto 1f
      // 1e: athrow
      // 1f: return
      // 20: athrow
      // 21: getstatic x/oc718fd4d503.Ō Lx/oc718fd4d503;
      // 24: aload 0
      // 25: bipush 0
      // 26: invokevirtual x/oc718fd4d503.à (Ljava/lang/Object;Z)V
      // 29: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 2c: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 2f: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 32: getfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 35: istore 3
      // 36: iload 3
      // 37: iload 2
      // 38: ifne 8d
      // 3b: iload 1
      // 3c: if_icmpeq 7e
      // 3f: goto 43
      // 42: athrow
      // 43: aload 0
      // 44: iload 2
      // 45: ifne 68
      // 48: goto 4c
      // 4b: athrow
      // 4c: getfield x/oc668fce0dbf.ư I
      // 4f: bipush -1
      // 50: if_icmpeq 63
      // 53: goto 57
      // 56: athrow
      // 57: iload 3
      // 58: aload 0
      // 59: getfield x/oc668fce0dbf.Ɓ I
      // 5c: if_icmpeq 6c
      // 5f: goto 63
      // 62: athrow
      // 63: aload 0
      // 64: goto 68
      // 67: athrow
      // 68: iload 3
      // 69: putfield x/oc668fce0dbf.ư I
      // 6c: aload 0
      // 6d: iload 1
      // 6e: putfield x/oc668fce0dbf.Ɓ I
      // 71: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 74: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 77: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 7a: iload 1
      // 7b: putfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 7e: aload 0
      // 7f: iload 2
      // 80: ifne 91
      // 83: getfield x/oc668fce0dbf.Ä Lx/occ2f8dff8d8;
      // 86: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 89: goto 8d
      // 8c: athrow
      // 8d: ifeq b1
      // 90: aload 0
      // 91: getfield x/oc668fce0dbf.ư I
      // 94: invokestatic x/oc668fce0dbf.ƀ (I)Z
      // 97: ifeq b1
      // 9a: getstatic x/oc718fd4d503.Ō Lx/oc718fd4d503;
      // 9d: aload 0
      // 9e: iload 1
      // 9f: aload 0
      // a0: getfield x/oc668fce0dbf.ư I
      // a3: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // a6: aconst_null
      // a7: bipush 0
      // a8: bipush 0
      // a9: bipush 1
      // aa: invokevirtual x/oc718fd4d503.Β (Ljava/lang/Object;ILjava/lang/Integer;Ljava/lang/Integer;ZZZ)V
      // ad: goto b1
      // b0: athrow
      // b1: return
   }

   private void Ͼ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 1
      // 04: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 07: iload 1
      // 08: ifne 2f
      // 0b: ifne 20
      // 0e: goto 12
      // 11: athrow
      // 12: getstatic x/oc718fd4d503.Ō Lx/oc718fd4d503;
      // 15: aload 0
      // 16: bipush 0
      // 17: invokevirtual x/oc718fd4d503.à (Ljava/lang/Object;Z)V
      // 1a: aload 0
      // 1b: invokevirtual x/oc668fce0dbf.ʌ ()V
      // 1e: return
      // 1f: athrow
      // 20: aload 0
      // 21: iload 1
      // 22: ifne 33
      // 25: getfield x/oc668fce0dbf.Ä Lx/occ2f8dff8d8;
      // 28: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 2b: goto 2f
      // 2e: athrow
      // 2f: ifeq 8d
      // 32: aload 0
      // 33: getfield x/oc668fce0dbf.ư I
      // 36: iload 1
      // 37: ifne 50
      // 3a: invokestatic x/oc668fce0dbf.ƀ (I)Z
      // 3d: ifeq 8c
      // 40: goto 44
      // 43: athrow
      // 44: aload 0
      // 45: aload 0
      // 46: getfield x/oc668fce0dbf.Ɓ I
      // 49: invokevirtual x/oc668fce0dbf.ü (I)Z
      // 4c: goto 50
      // 4f: athrow
      // 50: iload 1
      // 51: ifne 6b
      // 54: ifeq 8c
      // 57: goto 5b
      // 5a: athrow
      // 5b: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 5e: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 61: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 64: getfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 67: goto 6b
      // 6a: athrow
      // 6b: aload 0
      // 6c: getfield x/oc668fce0dbf.Ɓ I
      // 6f: if_icmpne 8c
      // 72: getstatic x/oc718fd4d503.Ō Lx/oc718fd4d503;
      // 75: aload 0
      // 76: aload 0
      // 77: getfield x/oc668fce0dbf.Ɓ I
      // 7a: aload 0
      // 7b: getfield x/oc668fce0dbf.ư I
      // 7e: invokestatic java/lang/Integer.valueOf (I)Ljava/lang/Integer;
      // 81: aconst_null
      // 82: bipush 0
      // 83: bipush 0
      // 84: bipush 1
      // 85: invokevirtual x/oc718fd4d503.Β (Ljava/lang/Object;ILjava/lang/Integer;Ljava/lang/Integer;ZZZ)V
      // 88: goto 8c
      // 8b: athrow
      // 8c: return
      // 8d: getstatic x/oc718fd4d503.Ō Lx/oc718fd4d503;
      // 90: aload 0
      // 91: bipush 0
      // 92: invokevirtual x/oc718fd4d503.à (Ljava/lang/Object;Z)V
      // 95: return
   }

   private void í() {
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
      // 07: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0a: ifnull 56
      // 0d: aload 0
      // 0e: iload 1
      // 0f: ifne 5f
      // 12: goto 16
      // 15: athrow
      // 16: getfield x/oc668fce0dbf.ư I
      // 19: invokestatic x/oc668fce0dbf.ƀ (I)Z
      // 1c: ifeq 56
      // 1f: goto 23
      // 22: athrow
      // 23: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 26: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 29: iload 1
      // 2a: ifne 4c
      // 2d: goto 31
      // 30: athrow
      // 31: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 34: getfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 37: aload 0
      // 38: getfield x/oc668fce0dbf.Ɓ I
      // 3b: if_icmpne 56
      // 3e: goto 42
      // 41: athrow
      // 42: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 45: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 48: goto 4c
      // 4b: athrow
      // 4c: getfield net/minecraft/client/entity/EntityPlayerSP.inventory Lnet/minecraft/entity/player/InventoryPlayer;
      // 4f: aload 0
      // 50: getfield x/oc668fce0dbf.ư I
      // 53: putfield net/minecraft/entity/player/InventoryPlayer.currentItem I
      // 56: getstatic x/oc718fd4d503.Ō Lx/oc718fd4d503;
      // 59: aload 0
      // 5a: bipush 1
      // 5b: invokevirtual x/oc718fd4d503.à (Ljava/lang/Object;Z)V
      // 5e: aload 0
      // 5f: invokevirtual x/oc668fce0dbf.ʌ ()V
      // 62: return
   }

   private boolean ü(int var1) {
      ItemStack var3 = null;
      int var4 = -1945425313 ^ -1135119726;
      int var2 = oc84f20a0bc5.ė;

      while (true) {
         switch (var4) {
            case -1299192495:
               return true;
            case -1041473517:
               break;
            case 811358413:
               int var10000;
               label74: {
                  label73: {
                     try {
                        var10000 = var1;
                        if (var2 != 0) {
                           break label74;
                        }

                        if (ƀ(var1)) {
                           break label73;
                        }
                     } catch (ocbde1165e4e var7) {
                        throw var7;
                     }

                     var4 = -975745025 ^ -1135119726;
                     if (var2 == 0) {
                        continue;
                     }
                  }

                  var10000 = 1070694628 ^ -1135119726;
               }

               var4 = var10000;
               if (var2 == 0) {
                  continue;
               }
            case -2088308106:
               var3 = oc69da1aa7f5.ő.thePlayer.inventory.getStackInSlot(var1);

               label63: {
                  label62: {
                     try {
                        if (var2 != 0) {
                           break label63;
                        }

                        if (var3 == null) {
                           break label62;
                        }
                     } catch (ocbde1165e4e var6) {
                        throw var6;
                     }

                     var4 = 2109411969 ^ -1135119726;
                     if (var2 == 0) {
                        continue;
                     }
                  }

                  var4 = -1961653311 ^ -1135119726;
               }

               if (var2 == 0) {
                  continue;
               }
               break;
            case 927267155:
               return false;
            case 2038447469:
               return false;
            default:
               throw null;
         }

         int var8;
         label50: {
            label49: {
               try {
                  var8 = var3.getItem() instanceof ItemBlock;
                  if (var2 != 0) {
                     break label50;
                  }

                  if (var8 == 0) {
                     break label49;
                  }
               } catch (ocbde1165e4e var5) {
                  throw var5;
               }

               var4 = 249075651 ^ -1135119726;
               if (var2 == 0) {
                  continue;
               }
            }

            var8 = -1961653311 ^ -1135119726;
         }

         var4 = var8;
         if (var2 != 0) {
            return true;
         }
      }
   }

   private static boolean ƀ(int var0) {
      int var1 = oc84f20a0bc5.ė;
      int var2 = 498908774 ^ 722591686;

      while (true) {
         switch (var2) {
            case -1682802722:
               return false;
            case -1269957638:
               int var10000;
               label46: {
                  label45: {
                     try {
                        var10000 = var0;
                        if (var1 != 0) {
                           break label46;
                        }

                        if (var0 >= InventoryPlayer.getHotbarSize()) {
                           break label45;
                        }
                     } catch (ocbde1165e4e var4) {
                        throw var4;
                     }

                     var2 = 1642286210 ^ 722591686;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var10000 = -1331451880 ^ 722591686;
               }

               var2 = var10000;
               if (var1 == 0) {
                  break;
               }
            case 917332384:
               int var5;
               label37: {
                  label36: {
                     try {
                        var5 = var0;
                        if (var1 != 0) {
                           break label37;
                        }

                        if (var0 < 0) {
                           break label36;
                        }
                     } catch (ocbde1165e4e var3) {
                        throw var3;
                     }

                     var2 = -1621351364 ^ 722591686;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var5 = -1331451880 ^ 722591686;
               }

               var2 = var5;
               break;
            case 1257411396:
               return true;
            default:
               throw null;
         }
      }
   }

   private void ʌ() {
      this.ư = -1;
      this.Ɓ = -1;
   }

   private boolean y(oc84f20a0bc5 var1, MovingObjectPosition var2, float var3, float var4) {
      BlockPos var6 = null;
      int var7 = 0;
      int var5 = oc84f20a0bc5.ė;
      int var8 = -239206097 ^ 283136174;

      while (true) {
         label123:
         while (true) {
            switch (var8) {
               case -1186772306:
                  var6 = var2.getBlockPos();

                  label109: {
                     label108: {
                        try {
                           if (var5 != 0) {
                              break label109;
                           }

                           if (var2.typeOfHit != MovingObjectType.BLOCK) {
                              break label108;
                           }
                        } catch (ocbde1165e4e var11) {
                           throw var11;
                        }

                        var8 = -995781514 ^ 283136174;
                        if (var5 == 0) {
                           continue;
                        }
                     }

                     var8 = 772914700 ^ 283136174;
                  }

                  if (var5 == 0) {
                     continue;
                  }
               case -1705836105:
                  int var13;
                  label97: {
                     label96: {
                        try {
                           var13 = ԣ(var2, var1);
                           if (var5 != 0) {
                              break label97;
                           }

                           if (var13 == 0) {
                              break label96;
                           }
                        } catch (ocbde1165e4e var10) {
                           throw var10;
                        }

                        var8 = 1778598181 ^ 283136174;
                        if (var5 == 0) {
                           continue;
                        }
                     }

                     var13 = 1484101606 ^ 283136174;
                  }

                  var8 = var13;
                  if (var5 == 0) {
                     continue;
                  }
                  break label123;
               case -733625128:
                  break;
               case -513912447:
                  break label123;
               case -357309964:
                  if (var2 != null) {
                     var8 = -1967959783 ^ 283136174;
                     if (var5 == 0) {
                        continue;
                     }
                  }

                  var8 = 1484101606 ^ 283136174;
                  if (var5 == 0) {
                     continue;
                  }
               case -1826430632:
                  int var12 = oc69da1aa7f5.ő
                     .playerController
                     .onPlayerRightClick(
                        oc69da1aa7f5.ő.thePlayer, oc69da1aa7f5.ő.theWorld, oc69da1aa7f5.ő.thePlayer.inventory.getCurrentItem(), var1.Ԛ, var1.ʂ, var2.hitVec
                     );
                  if (var5 == 0) {
                     var7 = var12;
                     this.Ϫ();
                     if (var7 != 0) {
                        var8 = 2107294616 ^ 283136174;
                        if (var5 == 0) {
                           continue;
                        }
                     }

                     var12 = 885115372 ^ 283136174;
                  }

                  var8 = var12;
                  if (var5 == 0) {
                     continue;
                  }
                  break;
               case 606181698:
                  return (boolean)var7;
               case 1056042658:
                  return false;
               case 1217775432:
                  return false;
               case 1836749622:
                  this.ʱ.Ѵ(var1.Ԛ.offset(var1.ʂ));
                  this.Β++;
                  this.ԛ = 283136171 ^ 283136174;
                  this.Ӛ = Math.abs(var4 - var3);
                  var8 = 885115372 ^ 283136174;
                  if (var5 != 0) {
                     return false;
                  }
                  continue;
               case 2061701515:
                  int var10000;
                  label83: {
                     label82: {
                        try {
                           var10000 = this.ӎ.ö(var2.sideHit);
                           if (var5 != 0) {
                              break label83;
                           }

                           if (var10000 != 0) {
                              break label82;
                           }
                        } catch (ocbde1165e4e var9) {
                           throw var9;
                        }

                        var8 = 1484101606 ^ 283136174;
                        if (var5 == 0) {
                           continue;
                        }
                     }

                     var10000 = -1448928768 ^ 283136174;
                  }

                  var8 = var10000;
                  continue;
               default:
                  throw null;
            }

            if (oc69da1aa7f5.ő.theWorld.getBlockState(var6).getBlock().getMaterial() == Material.air) {
               var8 = 772914700 ^ 283136174;
               if (var5 == 0) {
                  continue;
               }
            }

            var8 = -2084392458 ^ 283136174;
            if (var5 != 0) {
               return (boolean)var7;
            }
         }

         if (var1 != null) {
            var8 = -95178406 ^ 283136174;
            if (var5 == 0) {
               continue;
            }
         }

         var8 = 1484101606 ^ 283136174;
         if (var5 != 0) {
            return false;
         }
      }
   }

   private void Ϫ() {
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
      // 05: getfield x/oc668fce0dbf.ϕ Lx/occ2f8dff8d8;
      // 08: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 0b: ifeq 20
      // 0e: new net/minecraft/network/play/client/C0APacketAnimation
      // 11: dup
      // 12: invokespecial net/minecraft/network/play/client/C0APacketAnimation.<init> ()V
      // 15: invokestatic x/ocd6ae010123.ĕ (Lnet/minecraft/network/Packet;)V
      // 18: iload 1
      // 19: ifeq 2d
      // 1c: goto 20
      // 1f: athrow
      // 20: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 23: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 26: invokevirtual net/minecraft/client/entity/EntityPlayerSP.swingItem ()V
      // 29: goto 2d
      // 2c: athrow
      // 2d: return
   }

   private static boolean ԣ(MovingObjectPosition var0, oc84f20a0bc5 var1) {
      int var2 = oc84f20a0bc5.ė;
      int var3 = 1026230745 ^ -1161521676;

      while (true) {
         switch (var3) {
            case 773732112:
               return false;
            case 1003418277:
               int var10000;
               label34: {
                  label33: {
                     try {
                        var10000 = Ԗ(var0, var1.Ԛ, var1.ʂ);
                        if (var2 != 0) {
                           break label34;
                        }

                        if (var10000 == 0) {
                           break label33;
                        }
                     } catch (ocbde1165e4e var4) {
                        throw var4;
                     }

                     var3 = -877474726 ^ -1161521676;
                     if (var2 == 0) {
                        break;
                     }
                  }

                  var10000 = -1797610780 ^ -1161521676;
               }

               var3 = var10000;
               if (var2 == 0) {
                  break;
               }
            case -2014340051:
               if (var1 != null) {
                  var3 = -2130024623 ^ -1161521676;
                  if (var2 == 0) {
                     break;
                  }
               }

               var3 = -1797610780 ^ -1161521676;
               break;
            case 1903581614:
               return true;
            default:
               throw null;
         }
      }
   }

   private static boolean Ԗ(MovingObjectPosition var0, BlockPos var1, EnumFacing var2) {
      int var3 = oc84f20a0bc5.ė;
      int var4 = 368910202 ^ -1919681047;

      while (true) {
         switch (var4) {
            case -1168035168:
               return true;
            case 158098189:
               return false;
            case 2119538544:
               if (var1 != null) {
                  var4 = -1373726584 ^ -1919681047;
                  if (var3 == 0) {
                     break;
                  }
               }

               var4 = -2063622428 ^ -1919681047;
               if (var3 == 0) {
                  break;
               }
            case -600892307:
               if (var0.typeOfHit == MovingObjectType.BLOCK) {
                  var4 = -205100391 ^ -1919681047;
                  if (var3 == 0) {
                     break;
                  }
               }

               var4 = -2063622428 ^ -1919681047;
               if (var3 == 0) {
                  break;
               }
            case 513589657:
               if (var2 == var0.sideHit) {
                  var4 = 938659657 ^ -1919681047;
                  if (var3 == 0) {
                     break;
                  }
               }

               var4 = -2063622428 ^ -1919681047;
               if (var3 == 0) {
                  break;
               }
            case 596469089:
               int var10000;
               label59: {
                  label58: {
                     try {
                        var10000 = var1.equals(var0.getBlockPos());
                        if (var3 != 0) {
                           break label59;
                        }

                        if (var10000 == 0) {
                           break label58;
                        }
                     } catch (ocbde1165e4e var5) {
                        throw var5;
                     }

                     var4 = -1827718032 ^ -1919681047;
                     if (var3 == 0) {
                        break;
                     }
                  }

                  var10000 = -2063622428 ^ -1919681047;
               }

               var4 = var10000;
               if (var3 == 0) {
                  break;
               }
            case -1737563501:
               if (var0 != null) {
                  var4 = 1371332996 ^ -1919681047;
                  if (var3 == 0) {
                     break;
                  }
               }

               var4 = -2063622428 ^ -1919681047;
               if (var3 == 0) {
                  break;
               }

               return true;
            default:
               throw null;
         }
      }
   }

   private MovingObjectPosition ǒ(float var1, float var2) {
      Vec3 var3 = oc69da1aa7f5.ő.thePlayer.getPositionEyes(1.0F);
      Vec3 var4 = oc7ab2161b9f.ҵ(var1, var2);
      Vec3 var5 = var3.addVector(var4.xCoord * 4.5, var4.yCoord * 4.5, var4.zCoord * 4.5);
      return oc69da1aa7f5.ő.theWorld.rayTraceBlocks(var3, var5, false, false, true);
   }

   public static float[] Ø(BlockPos var0, EnumFacing var1, float var2) {
      return Ŋ(var0, var1, var2, ӧ.k());
   }

   // $VF: Handled exception range with multiple entry points by splitting it
   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   static float[] Ŋ(BlockPos var0, EnumFacing var1, float var2, float var3) {
      int var10000 = oc84f20a0bc5.ė;
      EntityPlayerSP var5 = oc69da1aa7f5.ő.thePlayer;
      double var6 = var5.posX;
      double var8 = var5.posY + var5.getEyeHeight();
      double var10 = var5.posZ;
      float var12 = (float)Math.toRadians(var2);
      double var13 = -Math.sin(var12);
      double var15 = Math.cos(var12);
      int var4 = var10000;
      double var17 = var0.getX();
      double var19 = var17 + 1.0;
      double var21 = var0.getY();
      double var23 = var21 + 1.0;
      double var25 = var0.getZ();
      double var27 = var25 + 1.0;
      float var29 = Float.MAX_VALUE;
      float var30 = Float.MAX_VALUE;

      float var10001;
      label184: {
         label178: {
            label185: {
               label176: {
                  label186: {
                     try {
                        var65 = var1;
                        if (var4 != 0) {
                           break label176;
                        }

                        if (var1 != EnumFacing.UP) {
                           break label186;
                        }
                     } catch (ocbde1165e4e var55) {
                        throw var55;
                     }

                     float var31 = ө(var6, var8, var10, var13, var15, var17 + 0.5, var23, var25 + 0.5);
                     float[] var32 = ǽ(var31, var3, var29, var30);
                     var29 = var32[0];
                     var30 = var32[1];
                     double[] var66 = new double[-720087345 ^ -720087347];
                     var66[0] = var17 + 0.1;
                     var66[1] = var19 - 0.1;
                     double[] var33 = var66;
                     int var34 = var33.length;
                     int var35 = 0;

                     while (var35 < var34) {
                        double var36 = var33[var35];
                        var10000 = -720087345 ^ -720087347;
                        if (var4 != 0) {
                           break label178;
                        }

                        double[] var68 = new double[var10000];
                        var68[0] = var25 + 0.1;
                        var68[1] = var27 - 0.1;
                        double[] var38 = var68;
                        int var39 = var38.length;
                        int var40 = 0;

                        label165: {
                           while (var40 < var39) {
                              double var41 = var38[var40];
                              var32 = ǽ(ө(var6, var8, var10, var13, var15, var36, var23, var41), var3, var29, var30);
                              if (var4 != 0) {
                                 break label165;
                              }

                              var29 = var32[0];
                              var30 = var32[1];
                              var40++;
                              if (var4 != 0) {
                                 break;
                              }
                           }

                           var35++;
                        }

                        if (var4 != 0) {
                           break;
                        }
                     }

                     try {
                        if (var4 == 0) {
                           break label185;
                        }
                     } catch (ocbde1165e4e var54) {
                        throw var54;
                     }
                  }

                  try {
                     var65 = var1;
                  } catch (ocbde1165e4e var45) {
                     throw var45;
                  }
               }

               label146: {
                  label145: {
                     try {
                        if (var4 != 0) {
                           break label146;
                        }

                        if (var65 != EnumFacing.DOWN) {
                           break label145;
                        }
                     } catch (ocbde1165e4e var53) {
                        throw var53;
                     }

                     float[] var57 = ǽ(ө(var6, var8, var10, var13, var15, var17 + 0.5, var21, var25 + 0.5), var3, var29, var30);
                     var29 = var57[0];
                     if (var4 == 0) {
                        break label185;
                     }
                  }

                  var65 = var1;
               }

               float[] var58;
               label189: {
                  label134: {
                     label190: {
                        try {
                           if (var4 != 0) {
                              break label134;
                           }

                           if (var65 != EnumFacing.NORTH) {
                              break label190;
                           }
                        } catch (ocbde1165e4e var52) {
                           throw var52;
                        }

                        var58 = Դ(var6, var8, var10, var13, var15, var25, var17, var19, var21, var23);

                        try {
                           if (var4 == 0) {
                              break label189;
                           }
                        } catch (ocbde1165e4e var50) {
                           throw var50;
                        }
                     }

                     try {
                        var65 = var1;
                     } catch (ocbde1165e4e var44) {
                        throw var44;
                     }
                  }

                  label125: {
                     label191: {
                        try {
                           if (var4 != 0) {
                              break label125;
                           }

                           if (var65 != EnumFacing.SOUTH) {
                              break label191;
                           }
                        } catch (ocbde1165e4e var51) {
                           throw var51;
                        }

                        var58 = Դ(var6, var8, var10, var13, var15, var27, var17, var19, var21, var23);

                        try {
                           if (var4 == 0) {
                              break label189;
                           }
                        } catch (ocbde1165e4e var49) {
                           throw var49;
                        }
                     }

                     try {
                        var65 = var1;
                     } catch (ocbde1165e4e var43) {
                        throw var43;
                     }
                  }

                  if (var65 == EnumFacing.WEST) {
                     var58 = ʋ(var6, var8, var10, var13, var15, var17, var21, var23, var25, var27);
                     if (var4 == 0) {
                        break label189;
                     }
                  }

                  var58 = ʋ(var6, var8, var10, var13, var15, var19, var21, var23, var25, var27);
               }

               float[] var60 = var58;
               int var61 = var58.length;
               int var62 = 0;

               while (var62 < var61) {
                  float var63 = var60[var62];
                  var10000 = var4;
                  float[] var64 = ǽ(var63, var3, var29, var30);
                  var29 = var64[0];
                  var30 = var64[1];

                  try {
                     if (var10000 != 0) {
                        return var58;
                     }

                     var62++;
                     if (var4 != 0) {
                        break;
                     }
                  } catch (ocbde1165e4e var48) {
                     throw var48;
                  }
               }
            }

            try {
               var70 = var29;
               var10001 = Float.MAX_VALUE;
               if (var4 != 0) {
                  break label184;
               }

               float var73;
               var10000 = (var73 = var29 - (Float.MAX_VALUE)) == 0.0F ? 0 : (var73 < 0.0F ? -1 : 1);
            } catch (ocbde1165e4e var46) {
               throw var46;
            }
         }

         try {
            if (var10000 == 0) {
               return null;
            }
         } catch (ocbde1165e4e var47) {
            throw var47;
         }

         var70 = var29;
         var10001 = -90.0F;
      }

      var29 = MathHelper.clamp_float(var70, var10001, 90.0F);
      float[] var71 = new float[-720087345 ^ -720087347];
      var71[0] = var2;
      var71[1] = var3;
      float[] var72 = new float[-720087345 ^ -720087347];
      var72[0] = var2;
      var72[1] = var29;
      float[] var74 = oc75d51ec7eb.Ŕ(var71, var72);
      var74[0] = var2;
      return var74;
   }

   public static float[] Ԇ(BlockPos var0, EnumFacing var1) {
      return ʳ(var0, var1, ӧ.ɥ(), ӧ.k());
   }

   private static float[] ʳ(BlockPos var0, EnumFacing var1, float var2, float var3) {
      EntityPlayerSP var4 = oc69da1aa7f5.ő.thePlayer;
      double var5 = var0.getX() + 0.5 + var1.getFrontOffsetX() * 0.5;
      double var7 = var0.getY() + 0.5 + var1.getFrontOffsetY() * 0.5;
      double var9 = var0.getZ() + 0.5 + var1.getFrontOffsetZ() * 0.5;
      double var11 = var5 - var4.posX;
      double var13 = var7 - (var4.posY + var4.getEyeHeight());
      double var15 = var9 - var4.posZ;
      float var17 = (float)Math.toDegrees(Math.atan2(-var11, var15));
      float var18 = (float)(-Math.toDegrees(Math.atan2(var13, Math.sqrt(var11 * var11 + var15 * var15))));
      var18 = MathHelper.clamp_float(var18, -90.0F, 90.0F);
      float[] var10000 = new float[183013749 ^ 183013751];
      var10000[0] = var2;
      var10000[1] = var3;
      float[] var10001 = new float[183013749 ^ 183013751];
      var10001[0] = var17;
      var10001[1] = var18;
      return oc75d51ec7eb.Ŕ(var10000, var10001);
   }

   private static float[] ǽ(float param0, float param1, float param2, float param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 4
      // 05: fload 0
      // 06: iload 4
      // 08: ifne 31
      // 0b: invokestatic java/lang/Float.isNaN (F)Z
      // 0e: ifeq 28
      // 11: goto 15
      // 14: athrow
      // 15: ldc_w 1320350174
      // 18: ldc_w 1320350172
      // 1b: ixor
      // 1c: newarray 6
      // 1e: dup
      // 1f: bipush 0
      // 20: fload 2
      // 21: fastore
      // 22: dup
      // 23: bipush 1
      // 24: fload 3
      // 25: fastore
      // 26: areturn
      // 27: athrow
      // 28: fload 0
      // 29: fload 1
      // 2a: fsub
      // 2b: invokestatic net/minecraft/util/MathHelper.wrapAngleTo180_float (F)F
      // 2e: invokestatic java/lang/Math.abs (F)F
      // 31: fstore 5
      // 33: fload 5
      // 35: fload 3
      // 36: fcmpg
      // 37: iload 4
      // 39: ifne 60
      // 3c: ifge 59
      // 3f: goto 43
      // 42: athrow
      // 43: ldc_w 1320350174
      // 46: ldc_w 1320350172
      // 49: ixor
      // 4a: newarray 6
      // 4c: dup
      // 4d: bipush 0
      // 4e: fload 0
      // 4f: fastore
      // 50: dup
      // 51: bipush 1
      // 52: fload 5
      // 54: fastore
      // 55: goto 6a
      // 58: athrow
      // 59: ldc_w 1320350174
      // 5c: ldc_w 1320350172
      // 5f: ixor
      // 60: newarray 6
      // 62: dup
      // 63: bipush 0
      // 64: fload 2
      // 65: fastore
      // 66: dup
      // 67: bipush 1
      // 68: fload 3
      // 69: fastore
      // 6a: areturn
   }

   private static float ө(double param0, double param2, double param4, double param6, double param8, double param10, double param12, double param14) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: dload 10
      // 05: dload 0
      // 06: dsub
      // 07: dstore 17
      // 09: istore 16
      // 0b: dload 12
      // 0d: dload 2
      // 0e: dsub
      // 0f: dstore 19
      // 11: dload 14
      // 13: dload 4
      // 15: dsub
      // 16: dstore 21
      // 18: dload 6
      // 1a: iload 16
      // 1c: ifne 6a
      // 1f: invokestatic java/lang/Math.abs (D)D
      // 22: dload 8
      // 24: invokestatic java/lang/Math.abs (D)D
      // 27: dcmpl
      // 28: ifle 58
      // 2b: goto 2f
      // 2e: athrow
      // 2f: dload 6
      // 31: iload 16
      // 33: ifne 51
      // 36: goto 3a
      // 39: athrow
      // 3a: invokestatic java/lang/Math.abs (D)D
      // 3d: ldc2_w 1.0E-6
      // 40: dcmpg
      // 41: ifge 4c
      // 44: goto 48
      // 47: athrow
      // 48: ldc NaN
      // 4a: freturn
      // 4b: athrow
      // 4c: dload 17
      // 4e: dload 6
      // 50: ddiv
      // 51: dstore 23
      // 53: iload 16
      // 55: ifeq 7c
      // 58: dload 8
      // 5a: iload 16
      // 5c: ifne 7a
      // 5f: goto 63
      // 62: athrow
      // 63: invokestatic java/lang/Math.abs (D)D
      // 66: goto 6a
      // 69: athrow
      // 6a: ldc2_w 1.0E-6
      // 6d: dcmpg
      // 6e: ifge 75
      // 71: ldc NaN
      // 73: freturn
      // 74: athrow
      // 75: dload 21
      // 77: dload 8
      // 79: ddiv
      // 7a: dstore 23
      // 7c: dload 23
      // 7e: iload 16
      // 80: ifne 9c
      // 83: dconst_0
      // 84: dcmpg
      // 85: ifgt 90
      // 88: goto 8c
      // 8b: athrow
      // 8c: ldc NaN
      // 8e: freturn
      // 8f: athrow
      // 90: dload 19
      // 92: dneg
      // 93: dload 23
      // 95: ddiv
      // 96: invokestatic java/lang/Math.atan (D)D
      // 99: invokestatic java/lang/Math.toDegrees (D)D
      // 9c: d2f
      // 9d: freturn
   }

   private static float[] Դ(
      double param0, double param2, double param4, double param6, double param8, double param10, double param12, double param14, double param16, double param18
   ) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 20
      // 05: dload 8
      // 07: invokestatic java/lang/Math.abs (D)D
      // 0a: iload 20
      // 0c: ifne 27
      // 0f: ldc2_w 1.0E-6
      // 12: dcmpg
      // 13: ifge 1f
      // 16: goto 1a
      // 19: athrow
      // 1a: bipush 0
      // 1b: newarray 6
      // 1d: areturn
      // 1e: athrow
      // 1f: dload 10
      // 21: dload 4
      // 23: dsub
      // 24: dload 8
      // 26: ddiv
      // 27: dstore 21
      // 29: dload 21
      // 2b: iload 20
      // 2d: ifne 45
      // 30: dconst_0
      // 31: dcmpg
      // 32: ifgt 3e
      // 35: goto 39
      // 38: athrow
      // 39: bipush 0
      // 3a: newarray 6
      // 3c: areturn
      // 3d: athrow
      // 3e: dload 0
      // 3f: dload 6
      // 41: dload 21
      // 43: dmul
      // 44: dadd
      // 45: dstore 23
      // 47: dload 23
      // 49: dload 12
      // 4b: dcmpg
      // 4c: iload 20
      // 4e: ifne 72
      // 51: iflt 6d
      // 54: goto 58
      // 57: athrow
      // 58: dload 23
      // 5a: iload 20
      // 5c: ifne 76
      // 5f: goto 63
      // 62: athrow
      // 63: dload 14
      // 65: dcmpl
      // 66: ifle 75
      // 69: goto 6d
      // 6c: athrow
      // 6d: bipush 0
      // 6e: goto 72
      // 71: athrow
      // 72: newarray 6
      // 74: areturn
      // 75: dload 2
      // 76: dload 21
      // 78: dload 16
      // 7a: dload 18
      // 7c: invokestatic x/oc668fce0dbf.б (DDDD)[F
      // 7f: areturn
   }

   private static float[] ʋ(
      double param0, double param2, double param4, double param6, double param8, double param10, double param12, double param14, double param16, double param18
   ) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc84f20a0bc5.ė I
      // 03: istore 20
      // 05: dload 6
      // 07: invokestatic java/lang/Math.abs (D)D
      // 0a: iload 20
      // 0c: ifne 26
      // 0f: ldc2_w 1.0E-6
      // 12: dcmpg
      // 13: ifge 1f
      // 16: goto 1a
      // 19: athrow
      // 1a: bipush 0
      // 1b: newarray 6
      // 1d: areturn
      // 1e: athrow
      // 1f: dload 10
      // 21: dload 0
      // 22: dsub
      // 23: dload 6
      // 25: ddiv
      // 26: dstore 21
      // 28: dload 21
      // 2a: iload 20
      // 2c: ifne 45
      // 2f: dconst_0
      // 30: dcmpg
      // 31: ifgt 3d
      // 34: goto 38
      // 37: athrow
      // 38: bipush 0
      // 39: newarray 6
      // 3b: areturn
      // 3c: athrow
      // 3d: dload 4
      // 3f: dload 8
      // 41: dload 21
      // 43: dmul
      // 44: dadd
      // 45: dstore 23
      // 47: dload 23
      // 49: dload 16
      // 4b: dcmpg
      // 4c: iload 20
      // 4e: ifne 72
      // 51: iflt 6d
      // 54: goto 58
      // 57: athrow
      // 58: dload 23
      // 5a: iload 20
      // 5c: ifne 76
      // 5f: goto 63
      // 62: athrow
      // 63: dload 18
      // 65: dcmpl
      // 66: ifle 75
      // 69: goto 6d
      // 6c: athrow
      // 6d: bipush 0
      // 6e: goto 72
      // 71: athrow
      // 72: newarray 6
      // 74: areturn
      // 75: dload 2
      // 76: dload 21
      // 78: dload 12
      // 7a: dload 14
      // 7c: invokestatic x/oc668fce0dbf.б (DDDD)[F
      // 7f: areturn
   }

   private static float[] б(double var0, double var2, double var4, double var6) {
      double[] var10000 = new double[-17471859 ^ -17471865];
      var10000[0] = var4 + 0.1;
      var10000[1] = var4 + (var6 - var4) * 0.2;
      var10000[-17471867 ^ -17471865] = var4 + (var6 - var4) * 0.3;
      var10000[-17471868 ^ -17471865] = var4 + (var6 - var4) * 0.4;
      var10000[-17471869 ^ -17471865] = (var4 + var6) * 0.5;
      var10000[-17471870 ^ -17471865] = var4 + (var6 - var4) * 0.6;
      var10000[-17471871 ^ -17471865] = var4 + (var6 - var4) * 0.7;
      var10000[-17471872 ^ -17471865] = var4 + (var6 - var4) * 0.8;
      var10000[-17471857 ^ -17471865] = var4 + (var6 - var4) * 0.9;
      var10000[-17471858 ^ -17471865] = var6 - 0.1;
      double[] var9 = var10000;
      float[] var10 = new float[var9.length];
      int var11 = 0;
      int var8 = oc84f20a0bc5.ė;

      while (true) {
         if (var11 < var9.length) {
            try {
               var13 = var10;
               if (var8 != 0) {
                  break;
               }

               var10[var11] = (float)Math.toDegrees(Math.atan(-(var9[var11] - var0) / var2));
               var11++;
               if (var8 == 0) {
                  continue;
               }
            } catch (ocbde1165e4e var12) {
               throw var12;
            }
         }

         var13 = var10;
         break;
      }

      return var13;
   }

   private static ItemBlock ɸ() {
      return ocd2872428d3.ϫ;
   }

   static {
      String[] var10000 = new String[-157503813 ^ -157503809];
      var10000[0] = "Normal";
      var10000[1] = "Telly";
      var10000[-157503811 ^ -157503809] = "Telly2";
      var10000[-157503812 ^ -157503809] = "Hypixel";
      ӂ = var10000;
      var10000 = new String[-157503812 ^ -157503809];
      var10000[0] = "Intave";
      var10000[1] = "Minimal";
      var10000[-157503811 ^ -157503809] = "Normal";
      Ž = var10000;
      var10000 = new String[-157503812 ^ -157503809];
      var10000[0] = "None";
      var10000[1] = "Move in";
      var10000[-157503811 ^ -157503809] = "Scale in";
      Ŗ = var10000;
      var10000 = new String[-157503811 ^ -157503809];
      var10000[0] = "Off";
      var10000[1] = "Vanilla";
      ƪ = var10000;
      var10000 = new String[-157503811 ^ -157503809];
      var10000[0] = "Off";
      var10000[1] = "Mid cycle";
      ӓ = var10000;
      var10000 = new String[-157503812 ^ -157503809];
      var10000[0] = "45";
      var10000[1] = "0";
      var10000[-157503811 ^ -157503809] = "-45";
      ҏ = var10000;
      float[] var5 = new float[-157503812 ^ -157503809];
      var5[0] = 45.0F;
      var5[1] = 0.0F;
      var5[-157503811 ^ -157503809] = -45.0F;
      ε = var5;
   }
}
