package x;

import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;

public class oce3cc81daa8 extends oc69da1aa7f5 {
   private static final int Ѵ = 0;
   private static final int Ƃ = 1;
   private static final int ʰ = 2;
   private static final String[] Ǐ;
   private static final long ʀ = 5000000L;
   private final oca9cc61aada Ţ;
   private final oca9cc61aada Ə;
   private final oca9cc61aada ð;
   private final oca9cc61aada Ц;
   private final occ2f8dff8d8 с;
   private final occ2f8dff8d8 ӕ;
   private final occ2f8dff8d8 Ԡ;
   private final occ2f8dff8d8 F;
   private final oca9cc61aada ū;
   private final oca9cc61aada Ы;
   private final occ2f8dff8d8 ж;
   private final occ2f8dff8d8 H;
   private final occ2f8dff8d8 Ҩ;
   private final occ2f8dff8d8 ԝ;
   private final occc831eff22 Ɋ;
   private final occc831eff22 ә;
   private final occc831eff22 Џ;
   private final occc831eff22 ӑ;
   public final occ2f8dff8d8 Ѥ;
   private final oc1957f41321 ʩ = new oc1957f41321();
   private boolean a;
   private boolean Ƀ;
   private boolean ϩ;
   private int Ȁ = -1;
   private EntityLivingBase Ε;
   private int Η;
   private volatile boolean з;
   private int Ʉ = -1;
   private oc3d1d10e2c1 Ѧ;
   private boolean ӎ;
   private int Ɍ;
   private int ӛ = -1;
   private long Ǳ;
   private long ş;
   private long ɍ;
   private long ʚ;
   public static boolean ɵ;

   public oce3cc81daa8() {
      super("AutoBlock", oce4cea752dd.ȁ);
      this.ą("Help you reduce damage taken.");
      this.ʌ(this.Ţ = new oca9cc61aada("Mode", 0, Ǐ));
      this.ʌ(this.Ə = new oca9cc61aada("Range", 3.1, 2.0, 6.0, 0.1));
      this.ʌ(this.ð = new oca9cc61aada("Maximum hurt time", "ms", 300.0, 50.0, 500.0, 1.0));
      this.ʌ(this.Ц = new oca9cc61aada("Maximum hold duration", "ms", 250.0, 50.0, 500.0, 1.0));
      this.ʌ(this.Ɋ = new occc831eff22("Fake block animation"));
      this.ʌ(this.Ҩ = new occ2f8dff8d8(this.Ɋ, "Force block animation", true));
      this.ʌ(this.ԝ = new occ2f8dff8d8(this.Ɋ, "Only within range", false));
      this.ʌ(this.ә = new occc831eff22("Lag"));
      this.ʌ(this.ū = new oca9cc61aada(this.ә, "Lag Chance", "%", 0.0, 0.0, 100.0, 1.0, "Lag chance"));
      this.ʌ(this.Ы = new oca9cc61aada(this.ә, "Lag Delay", "ms", 100.0, 50.0, 500.0, 1.0, "Lag max duration"));
      this.ʌ(this.ж = new occ2f8dff8d8(this.ә, "Prevent delaying attacks", true));
      this.ʌ(this.H = new occ2f8dff8d8(this.ә, "Block again immediately", false));
      this.ʌ(this.Џ = new occc831eff22("Condition"));
      this.ʌ(this.с = new occ2f8dff8d8(this.Џ, "Require left mouse", true));
      this.ʌ(this.ӕ = new occ2f8dff8d8(this.Џ, "Require right mouse", false));
      this.ʌ(this.Ԡ = new occ2f8dff8d8(this.Џ, "Damaged", false));
      this.ʌ(this.Ѥ = new occ2f8dff8d8(this.Џ, "Only KillAura", false));
      this.ʌ(this.ӑ = new occc831eff22("Targets"));
      this.ʌ(this.F = new occ2f8dff8d8(this.ӑ, "Ignore teammates", true));
      this.ɮ = true;
      this.z$2u87utkr1isxg();
   }

   @Override
   public String getInfo() {
      return Ǐ[(int)this.Ţ.Ӂ()];
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
      // 000: getstatic x/oc5e549848f3.İ I
      // 003: istore 1
      // 004: aload 0
      // 005: getfield x/oce3cc81daa8.Џ Lx/occc831eff22;
      // 008: bipush 1
      // 009: iload 1
      // 00a: ifne 025
      // 00d: aload 0
      // 00e: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 011: aload 0
      // 012: getfield x/oce3cc81daa8.ӑ Lx/occc831eff22;
      // 015: aload 0
      // 016: invokevirtual x/oce3cc81daa8.Ƴ ()Z
      // 019: ifne 028
      // 01c: goto 020
      // 01f: athrow
      // 020: bipush 1
      // 021: goto 025
      // 024: athrow
      // 025: goto 029
      // 028: bipush 0
      // 029: aload 0
      // 02a: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 02d: aload 0
      // 02e: invokevirtual x/oce3cc81daa8.Ƴ ()Z
      // 031: istore 2
      // 032: aload 0
      // 033: getfield x/oce3cc81daa8.ð Lx/oca9cc61aada;
      // 036: iload 2
      // 037: aload 0
      // 038: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 03b: aload 0
      // 03c: getfield x/oce3cc81daa8.Ц Lx/oca9cc61aada;
      // 03f: iload 2
      // 040: aload 0
      // 041: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 044: aload 0
      // 045: getfield x/oce3cc81daa8.Ɋ Lx/occc831eff22;
      // 048: bipush 1
      // 049: aload 0
      // 04a: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 04d: aload 0
      // 04e: getfield x/oce3cc81daa8.ә Lx/occc831eff22;
      // 051: iload 2
      // 052: aload 0
      // 053: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 056: aload 0
      // 057: getfield x/oce3cc81daa8.ū Lx/oca9cc61aada;
      // 05a: aload 0
      // 05b: invokevirtual x/oce3cc81daa8.Ƴ ()Z
      // 05e: aload 0
      // 05f: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 062: aload 0
      // 063: getfield x/oce3cc81daa8.Ы Lx/oca9cc61aada;
      // 066: aload 0
      // 067: invokevirtual x/oce3cc81daa8.Ƴ ()Z
      // 06a: aload 0
      // 06b: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 06e: aload 0
      // 06f: getfield x/oce3cc81daa8.ж Lx/occ2f8dff8d8;
      // 072: aload 0
      // 073: invokevirtual x/oce3cc81daa8.Ƴ ()Z
      // 076: aload 0
      // 077: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 07a: aload 0
      // 07b: getfield x/oce3cc81daa8.H Lx/occ2f8dff8d8;
      // 07e: aload 0
      // 07f: iload 1
      // 080: ifne 0a4
      // 083: invokevirtual x/oce3cc81daa8.Ƴ ()Z
      // 086: aload 0
      // 087: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 08a: aload 0
      // 08b: getfield x/oce3cc81daa8.Ҩ Lx/occ2f8dff8d8;
      // 08e: bipush 1
      // 08f: aload 0
      // 090: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 093: aload 0
      // 094: getfield x/oce3cc81daa8.ԝ Lx/occ2f8dff8d8;
      // 097: iload 2
      // 098: ifeq 0b9
      // 09b: goto 09f
      // 09e: athrow
      // 09f: aload 0
      // 0a0: goto 0a4
      // 0a3: athrow
      // 0a4: getfield x/oce3cc81daa8.Ҩ Lx/occ2f8dff8d8;
      // 0a7: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 0aa: iload 1
      // 0ab: ifne 0b6
      // 0ae: ifeq 0b9
      // 0b1: goto 0b5
      // 0b4: athrow
      // 0b5: bipush 1
      // 0b6: goto 0ba
      // 0b9: bipush 0
      // 0ba: aload 0
      // 0bb: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 0be: aload 0
      // 0bf: getfield x/oce3cc81daa8.Ѥ Lx/occ2f8dff8d8;
      // 0c2: iload 2
      // 0c3: iload 1
      // 0c4: ifne 0cf
      // 0c7: ifne 0d2
      // 0ca: goto 0ce
      // 0cd: athrow
      // 0ce: bipush 1
      // 0cf: goto 0d3
      // 0d2: bipush 0
      // 0d3: aload 0
      // 0d4: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 0d7: aload 0
      // 0d8: getfield x/oce3cc81daa8.с Lx/occ2f8dff8d8;
      // 0db: bipush 1
      // 0dc: aload 0
      // 0dd: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 0e0: aload 0
      // 0e1: getfield x/oce3cc81daa8.ӕ Lx/occ2f8dff8d8;
      // 0e4: bipush 1
      // 0e5: aload 0
      // 0e6: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 0e9: aload 0
      // 0ea: getfield x/oce3cc81daa8.Ԡ Lx/occ2f8dff8d8;
      // 0ed: iload 2
      // 0ee: iload 1
      // 0ef: ifne 107
      // 0f2: aload 0
      // 0f3: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 0f6: aload 0
      // 0f7: getfield x/oce3cc81daa8.F Lx/occ2f8dff8d8;
      // 0fa: iload 2
      // 0fb: ifne 10a
      // 0fe: goto 102
      // 101: athrow
      // 102: bipush 1
      // 103: goto 107
      // 106: athrow
      // 107: goto 10b
      // 10a: bipush 0
      // 10b: aload 0
      // 10c: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 10f: bipush 0
      // 110: ifeq 11e
      // 113: iinc 1 1
      // 116: iload 1
      // 117: putstatic x/oc5e549848f3.İ I
      // 11a: goto 11e
      // 11d: athrow
      // 11e: return
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
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 2
      // 04: aload 1
      // 05: aload 0
      // 06: getfield x/oce3cc81daa8.Ţ Lx/oca9cc61aada;
      // 09: if_acmpne 3d
      // 0c: aload 0
      // 0d: bipush 1
      // 0e: invokevirtual x/oce3cc81daa8.ǟ (Z)V
      // 11: aload 0
      // 12: iload 2
      // 13: ifne 3a
      // 16: goto 1a
      // 19: athrow
      // 1a: aload 0
      // 1b: getfield x/oce3cc81daa8.Ţ Lx/oca9cc61aada;
      // 1e: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 21: d2i
      // 22: putfield x/oce3cc81daa8.ӛ I
      // 25: aload 0
      // 26: invokevirtual x/oce3cc81daa8.Ƴ ()Z
      // 29: ifeq 39
      // 2c: goto 30
      // 2f: athrow
      // 30: bipush 0
      // 31: invokestatic x/ReflectionUtils.setItemInUse (Z)Z
      // 34: pop
      // 35: goto 39
      // 38: athrow
      // 39: aload 0
      // 3a: invokevirtual x/oce3cc81daa8.z$2u87utkr1isxg ()V
      // 3d: return
   }

   @Override
   public void z$3tl278wzjcayb(N var1) {
      this.z$2u87utkr1isxg();
   }

   @Override
   public void guiButtonToggled(occ2f8dff8d8 var1) {
      this.z$2u87utkr1isxg();
      super.guiButtonToggled(var1);
   }

   @Override
   public void onEnable() {
      this.Ɍ = 0;
      this.ӎ = false;
      this.ӛ = (int)this.Ţ.Ӂ();
      this.ǟ(false);
   }

   private static int Ɇ(double var0) {
      float var3 = 0.0F;
      int var4 = 1862506313 ^ -690590201;
      int var2 = oc5e549848f3.İ;

      while (true) {
         switch (var4) {
            case -1177159346:
               var3 = (float)(var0 / 50.0);

               label26: {
                  try {
                     if (var2 != 0) {
                        break;
                     }

                     if (!(var3 <= 0.0F)) {
                        break label26;
                     }
                  } catch (ocbde1165e4e var5) {
                     throw var5;
                  }

                  var4 = -1329012864 ^ -690590201;
                  if (var2 == 0) {
                     break;
                  }
               }

               var4 = -1915806875 ^ -690590201;
               break;
            case 1528395106:
               return (int)Math.ceil(var3);
            case 1713287559:
               return 0;
            default:
               throw null;
         }
      }
   }

   @Override
   public void onDisable() {
      this.ǟ(true);
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.HIGHEST
   )
   public void ҥ(MouseEvent param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc5e549848f3.İ I
      // 003: istore 2
      // 004: aload 0
      // 005: iload 2
      // 006: ifne 016
      // 009: invokevirtual x/oce3cc81daa8.Ϧ ()Z
      // 00c: ifeq 015
      // 00f: goto 013
      // 012: athrow
      // 013: return
      // 014: athrow
      // 015: aload 0
      // 016: invokevirtual x/oce3cc81daa8.Ƴ ()Z
      // 019: iload 2
      // 01a: ifne 07a
      // 01d: ifeq 077
      // 020: goto 024
      // 023: athrow
      // 024: aload 0
      // 025: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 028: iload 2
      // 029: ifne 03f
      // 02c: goto 030
      // 02f: athrow
      // 030: ifeq 076
      // 033: goto 037
      // 036: athrow
      // 037: aload 1
      // 038: getfield x/MouseEvent.button I
      // 03b: goto 03f
      // 03e: athrow
      // 03f: iload 2
      // 040: ifne 052
      // 043: bipush 1
      // 044: if_icmpne 076
      // 047: goto 04b
      // 04a: athrow
      // 04b: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 04e: goto 052
      // 051: athrow
      // 052: ifeq 076
      // 055: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 058: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 05b: ifnonnull 076
      // 05e: goto 062
      // 061: athrow
      // 062: aload 0
      // 063: invokevirtual x/oce3cc81daa8.ȩ ()Z
      // 066: ifeq 076
      // 069: goto 06d
      // 06c: athrow
      // 06d: aload 1
      // 06e: bipush 1
      // 06f: invokevirtual x/oc68d6b191af.setCanceled (Z)V
      // 072: goto 076
      // 075: athrow
      // 076: return
      // 077: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 07a: iload 2
      // 07b: ifne 088
      // 07e: ifeq 08b
      // 081: goto 085
      // 084: athrow
      // 085: invokestatic x/oc7ab2161b9f.ө ()Z
      // 088: ifne 08c
      // 08b: return
      // 08c: getstatic x/oc9755810e45.ϔ Lx/oc8edd24b1ed;
      // 08f: iload 2
      // 090: ifne 09d
      // 093: ifnull 0ac
      // 096: goto 09a
      // 099: athrow
      // 09a: getstatic x/oc9755810e45.ϔ Lx/oc8edd24b1ed;
      // 09d: invokevirtual x/oc8edd24b1ed.Ƴ ()Z
      // 0a0: iload 2
      // 0a1: ifne 0b8
      // 0a4: ifeq 0ac
      // 0a7: goto 0ab
      // 0aa: athrow
      // 0ab: return
      // 0ac: aload 1
      // 0ad: iload 2
      // 0ae: ifne 0c1
      // 0b1: getfield x/MouseEvent.button I
      // 0b4: goto 0b8
      // 0b7: athrow
      // 0b8: bipush 1
      // 0b9: if_icmpne 128
      // 0bc: aload 1
      // 0bd: goto 0c1
      // 0c0: athrow
      // 0c1: iload 2
      // 0c2: ifne 0ea
      // 0c5: getfield x/MouseEvent.buttonstate Z
      // 0c8: ifne 0e9
      // 0cb: goto 0cf
      // 0ce: athrow
      // 0cf: aload 0
      // 0d0: getfield x/oce3cc81daa8.ϩ Z
      // 0d3: iload 2
      // 0d4: ifne 0f5
      // 0d7: goto 0db
      // 0da: athrow
      // 0db: ifeq 0e9
      // 0de: goto 0e2
      // 0e1: athrow
      // 0e2: aload 0
      // 0e3: bipush 0
      // 0e4: putfield x/oce3cc81daa8.ϩ Z
      // 0e7: return
      // 0e8: athrow
      // 0e9: aload 1
      // 0ea: iload 2
      // 0eb: ifne 124
      // 0ee: getfield x/MouseEvent.buttonstate Z
      // 0f1: goto 0f5
      // 0f4: athrow
      // 0f5: ifeq 123
      // 0f8: aload 0
      // 0f9: iload 2
      // 0fa: ifne 11e
      // 0fd: goto 101
      // 100: athrow
      // 101: invokevirtual x/oce3cc81daa8.տ ()Z
      // 104: ifeq 123
      // 107: goto 10b
      // 10a: athrow
      // 10b: aload 0
      // 10c: invokevirtual x/oce3cc81daa8.ɝ ()V
      // 10f: aload 0
      // 110: bipush 1
      // 111: invokevirtual x/oce3cc81daa8.ˣ (Z)V
      // 114: aload 0
      // 115: bipush 0
      // 116: putfield x/oce3cc81daa8.Ƀ Z
      // 119: aload 0
      // 11a: goto 11e
      // 11d: athrow
      // 11e: bipush 1
      // 11f: putfield x/oce3cc81daa8.ϩ Z
      // 122: return
      // 123: aload 1
      // 124: bipush 1
      // 125: invokevirtual x/oc68d6b191af.setCanceled (Z)V
      // 128: return
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.HIGHEST
   )
   public void һ(oc479681b341 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 2
      // 04: aload 0
      // 05: iload 2
      // 06: ifne 16
      // 09: invokevirtual x/oce3cc81daa8.Ϧ ()Z
      // 0c: ifeq 15
      // 0f: goto 13
      // 12: athrow
      // 13: return
      // 14: athrow
      // 15: aload 0
      // 16: iload 2
      // 17: ifne 27
      // 1a: invokevirtual x/oce3cc81daa8.Ƴ ()Z
      // 1d: ifeq 26
      // 20: goto 24
      // 23: athrow
      // 24: return
      // 25: athrow
      // 26: aload 0
      // 27: invokevirtual x/oce3cc81daa8.ӥ ()Z
      // 2a: ifeq 36
      // 2d: aload 1
      // 2e: bipush 1
      // 2f: invokevirtual x/oc68d6b191af.setCanceled (Z)V
      // 32: goto 36
      // 35: athrow
      // 36: return
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.HIGHEST
   )
   public void Ѐ(oce21f48fe00 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 2
      // 04: aload 0
      // 05: iload 2
      // 06: ifne 16
      // 09: invokevirtual x/oce3cc81daa8.Ϧ ()Z
      // 0c: ifeq 15
      // 0f: goto 13
      // 12: athrow
      // 13: return
      // 14: athrow
      // 15: aload 0
      // 16: iload 2
      // 17: ifne 3c
      // 1a: invokevirtual x/oce3cc81daa8.Ƴ ()Z
      // 1d: ifne 37
      // 20: goto 24
      // 23: athrow
      // 24: aload 0
      // 25: iload 2
      // 26: ifne 3c
      // 29: goto 2d
      // 2c: athrow
      // 2d: getfield x/oce3cc81daa8.ϩ Z
      // 30: ifne 42
      // 33: goto 37
      // 36: athrow
      // 37: aload 0
      // 38: goto 3c
      // 3b: athrow
      // 3c: invokevirtual x/oce3cc81daa8.ӥ ()Z
      // 3f: ifeq 4b
      // 42: aload 1
      // 43: bipush 1
      // 44: invokevirtual x/oc68d6b191af.setCanceled (Z)V
      // 47: goto 4b
      // 4a: athrow
      // 4b: return
   }

   @oc66fa4f2195
   public void Ϥ(ocf923d5a814 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 2
      // 04: aload 0
      // 05: invokevirtual x/oce3cc81daa8.Ϧ ()Z
      // 08: ifeq 0d
      // 0b: return
      // 0c: athrow
      // 0d: aload 1
      // 0e: getfield x/ocb508b4e274.Ұ Lx/oc110d7f376c;
      // 11: getstatic x/oc110d7f376c.START Lx/oc110d7f376c;
      // 14: if_acmpeq 19
      // 17: return
      // 18: athrow
      // 19: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 1c: ifne 25
      // 1f: aload 0
      // 20: invokevirtual x/oce3cc81daa8.Ƚ ()V
      // 23: return
      // 24: athrow
      // 25: getstatic x/oc9755810e45.ϔ Lx/oc8edd24b1ed;
      // 28: iload 2
      // 29: ifne 36
      // 2c: ifnull 4e
      // 2f: goto 33
      // 32: athrow
      // 33: getstatic x/oc9755810e45.ϔ Lx/oc8edd24b1ed;
      // 36: invokevirtual x/oc8edd24b1ed.Ƴ ()Z
      // 39: iload 2
      // 3a: ifne 4c
      // 3d: ifeq 4e
      // 40: goto 44
      // 43: athrow
      // 44: bipush 0
      // 45: invokestatic x/ReflectionUtils.setItemInUse (Z)Z
      // 48: goto 4c
      // 4b: athrow
      // 4c: pop
      // 4d: return
      // 4e: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 51: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 54: ifnull 87
      // 57: aload 0
      // 58: iload 2
      // 59: ifne 82
      // 5c: goto 60
      // 5f: athrow
      // 60: getfield x/oce3cc81daa8.a Z
      // 63: ifne 7d
      // 66: goto 6a
      // 69: athrow
      // 6a: aload 0
      // 6b: iload 2
      // 6c: ifne 88
      // 6f: goto 73
      // 72: athrow
      // 73: getfield x/oce3cc81daa8.з Z
      // 76: ifeq 87
      // 79: goto 7d
      // 7c: athrow
      // 7d: aload 0
      // 7e: goto 82
      // 81: athrow
      // 82: bipush 1
      // 83: invokevirtual x/oce3cc81daa8.ǟ (Z)V
      // 86: return
      // 87: aload 0
      // 88: invokevirtual x/oce3cc81daa8.Ƚ ()V
      // 8b: return
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.HIGHEST
   )
   public void ӡ(oce79181588d param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 2
      // 04: aload 0
      // 05: invokevirtual x/oce3cc81daa8.Ĵ ()Z
      // 08: iload 2
      // 09: ifne 16
      // 0c: ifeq 21
      // 0f: goto 13
      // 12: athrow
      // 13: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 16: iload 2
      // 17: ifne 31
      // 1a: ifne 22
      // 1d: goto 21
      // 20: athrow
      // 21: return
      // 22: aload 1
      // 23: iload 2
      // 24: ifne 35
      // 27: invokevirtual x/oce79181588d.Ҡ ()Lnet/minecraft/network/Packet;
      // 2a: instanceof net/minecraft/network/play/server/S19PacketEntityStatus
      // 2d: goto 31
      // 30: athrow
      // 31: ifeq 7a
      // 34: aload 1
      // 35: invokevirtual x/oce79181588d.Ҡ ()Lnet/minecraft/network/Packet;
      // 38: checkcast net/minecraft/network/play/server/S19PacketEntityStatus
      // 3b: astore 3
      // 3c: aload 3
      // 3d: iload 2
      // 3e: ifne 57
      // 41: invokevirtual net/minecraft/network/play/server/S19PacketEntityStatus.getOpCode ()B
      // 44: ldc_w -1235226409
      // 47: ldc_w -1235226411
      // 4a: ixor
      // 4b: if_icmpne 7a
      // 4e: goto 52
      // 51: athrow
      // 52: aload 3
      // 53: goto 57
      // 56: athrow
      // 57: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 5a: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 5d: invokevirtual net/minecraft/network/play/server/S19PacketEntityStatus.getEntity (Lnet/minecraft/world/World;)Lnet/minecraft/entity/Entity;
      // 60: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 63: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 66: if_acmpne 7a
      // 69: aload 0
      // 6a: invokestatic java/lang/System.currentTimeMillis ()J
      // 6d: aload 0
      // 6e: invokevirtual x/oce3cc81daa8.Ԍ ()I
      // 71: i2l
      // 72: lsub
      // 73: putfield x/oce3cc81daa8.ʚ J
      // 76: goto 7a
      // 79: athrow
      // 7a: return
   }

   @oc66fa4f2195
   public void Ȼ(ocbab3c9954b param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 2
      // 04: aload 0
      // 05: iload 2
      // 06: ifne 25
      // 09: invokevirtual x/oce3cc81daa8.Ƴ ()Z
      // 0c: ifeq 1a
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: bipush 0
      // 15: invokevirtual x/oce3cc81daa8.Ξ (Z)V
      // 18: return
      // 19: athrow
      // 1a: aload 0
      // 1b: bipush 0
      // 1c: putfield x/oce3cc81daa8.Ɍ I
      // 1f: aload 0
      // 20: bipush 0
      // 21: putfield x/oce3cc81daa8.ӎ Z
      // 24: aload 0
      // 25: bipush 1
      // 26: invokevirtual x/oce3cc81daa8.ǟ (Z)V
      // 29: return
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.HIGH
   )
   public void M(oc9d4393f3ce param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc5e549848f3.İ I
      // 003: istore 2
      // 004: aload 0
      // 005: iload 2
      // 006: ifne 016
      // 009: invokevirtual x/oce3cc81daa8.Ϧ ()Z
      // 00c: ifeq 015
      // 00f: goto 013
      // 012: athrow
      // 013: return
      // 014: athrow
      // 015: aload 0
      // 016: invokevirtual x/oce3cc81daa8.Ƴ ()Z
      // 019: iload 2
      // 01a: ifne 0b1
      // 01d: ifeq 0ad
      // 020: goto 024
      // 023: athrow
      // 024: aload 0
      // 025: iload 2
      // 026: ifne 03c
      // 029: goto 02d
      // 02c: athrow
      // 02d: getfield x/oce3cc81daa8.з Z
      // 030: ifeq 0ac
      // 033: goto 037
      // 036: athrow
      // 037: aload 0
      // 038: goto 03c
      // 03b: athrow
      // 03c: getfield x/oce3cc81daa8.ж Lx/occ2f8dff8d8;
      // 03f: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 042: iload 2
      // 043: ifne 060
      // 046: ifeq 0ac
      // 049: goto 04d
      // 04c: athrow
      // 04d: aload 1
      // 04e: iload 2
      // 04f: ifne 064
      // 052: goto 056
      // 055: athrow
      // 056: invokevirtual x/oc9d4393f3ce.ɟ ()Lnet/minecraft/network/Packet;
      // 059: instanceof net/minecraft/network/play/client/C02PacketUseEntity
      // 05c: goto 060
      // 05f: athrow
      // 060: ifeq 0ac
      // 063: aload 1
      // 064: invokevirtual x/oc9d4393f3ce.ɟ ()Lnet/minecraft/network/Packet;
      // 067: checkcast net/minecraft/network/play/client/C02PacketUseEntity
      // 06a: invokevirtual net/minecraft/network/play/client/C02PacketUseEntity.getAction ()Lnet/minecraft/network/play/client/C02PacketUseEntity$Action;
      // 06d: getstatic net/minecraft/network/play/client/C02PacketUseEntity$Action.ATTACK Lnet/minecraft/network/play/client/C02PacketUseEntity$Action;
      // 070: if_acmpne 0ac
      // 073: aload 0
      // 074: iload 2
      // 075: ifne 092
      // 078: goto 07c
      // 07b: athrow
      // 07c: invokevirtual x/oce3cc81daa8.ɝ ()V
      // 07f: aload 0
      // 080: getfield x/oce3cc81daa8.H Lx/occ2f8dff8d8;
      // 083: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 086: ifeq 0ac
      // 089: goto 08d
      // 08c: athrow
      // 08d: aload 0
      // 08e: goto 092
      // 091: athrow
      // 092: iload 2
      // 093: ifne 0a5
      // 096: invokevirtual x/oce3cc81daa8.ȩ ()Z
      // 099: ifeq 0ac
      // 09c: goto 0a0
      // 09f: athrow
      // 0a0: aload 0
      // 0a1: goto 0a5
      // 0a4: athrow
      // 0a5: aload 0
      // 0a6: getfield x/oce3cc81daa8.Ɍ I
      // 0a9: invokevirtual x/oce3cc81daa8.ɒ (I)V
      // 0ac: return
      // 0ad: aload 1
      // 0ae: invokevirtual x/oc68d6b191af.isCanceled ()Z
      // 0b1: ifne 0c0
      // 0b4: aload 0
      // 0b5: aload 1
      // 0b6: invokevirtual x/oc9d4393f3ce.ɟ ()Lnet/minecraft/network/Packet;
      // 0b9: invokevirtual x/oce3cc81daa8.Ť (Lnet/minecraft/network/Packet;)V
      // 0bc: goto 0c0
      // 0bf: athrow
      // 0c0: getstatic x/oc9755810e45.ϔ Lx/oc8edd24b1ed;
      // 0c3: iload 2
      // 0c4: ifne 0d1
      // 0c7: ifnull 0e5
      // 0ca: goto 0ce
      // 0cd: athrow
      // 0ce: getstatic x/oc9755810e45.ϔ Lx/oc8edd24b1ed;
      // 0d1: invokevirtual x/oc8edd24b1ed.Ƴ ()Z
      // 0d4: iload 2
      // 0d5: ifne 0f4
      // 0d8: ifeq 0e5
      // 0db: goto 0df
      // 0de: athrow
      // 0df: aload 0
      // 0e0: invokevirtual x/oce3cc81daa8.ɝ ()V
      // 0e3: return
      // 0e4: athrow
      // 0e5: aload 1
      // 0e6: iload 2
      // 0e7: ifne 0f9
      // 0ea: invokevirtual x/oc9d4393f3ce.ɟ ()Lnet/minecraft/network/Packet;
      // 0ed: instanceof net/minecraft/network/play/client/C02PacketUseEntity
      // 0f0: goto 0f4
      // 0f3: athrow
      // 0f4: ifne 0f8
      // 0f7: return
      // 0f8: aload 1
      // 0f9: invokevirtual x/oc9d4393f3ce.ɟ ()Lnet/minecraft/network/Packet;
      // 0fc: checkcast net/minecraft/network/play/client/C02PacketUseEntity
      // 0ff: invokevirtual net/minecraft/network/play/client/C02PacketUseEntity.getAction ()Lnet/minecraft/network/play/client/C02PacketUseEntity$Action;
      // 102: getstatic net/minecraft/network/play/client/C02PacketUseEntity$Action.ATTACK Lnet/minecraft/network/play/client/C02PacketUseEntity$Action;
      // 105: if_acmpeq 10a
      // 108: return
      // 109: athrow
      // 10a: aload 0
      // 10b: iload 2
      // 10c: ifne 11e
      // 10f: invokevirtual x/oce3cc81daa8.Ĵ ()Z
      // 112: ifeq 124
      // 115: goto 119
      // 118: athrow
      // 119: aload 0
      // 11a: goto 11e
      // 11d: athrow
      // 11e: invokestatic java/lang/System.currentTimeMillis ()J
      // 121: putfield x/oce3cc81daa8.Ǳ J
      // 124: return
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.LOW
   )
   public void Մ(oca27090789a param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 000: getstatic x/oc5e549848f3.İ I
      // 003: istore 2
      // 004: aload 0
      // 005: iload 2
      // 006: ifne 016
      // 009: invokevirtual x/oce3cc81daa8.Ϧ ()Z
      // 00c: ifeq 015
      // 00f: goto 013
      // 012: athrow
      // 013: return
      // 014: athrow
      // 015: aload 0
      // 016: invokevirtual x/oce3cc81daa8.Ƴ ()Z
      // 019: iload 2
      // 01a: ifne 028
      // 01d: ifeq 025
      // 020: goto 024
      // 023: athrow
      // 024: return
      // 025: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 028: iload 2
      // 029: ifne 048
      // 02c: ifeq 054
      // 02f: goto 033
      // 032: athrow
      // 033: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 036: iload 2
      // 037: ifne 04e
      // 03a: goto 03e
      // 03d: athrow
      // 03e: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 041: getfield net/minecraft/client/entity/EntityPlayerSP.isDead Z
      // 044: goto 048
      // 047: athrow
      // 048: ifne 054
      // 04b: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 04e: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 051: ifnull 05b
      // 054: aload 0
      // 055: bipush 1
      // 056: invokevirtual x/oce3cc81daa8.ǟ (Z)V
      // 059: return
      // 05a: athrow
      // 05b: aload 0
      // 05c: getfield x/oce3cc81daa8.Ѥ Lx/occ2f8dff8d8;
      // 05f: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 062: ifeq 0d5
      // 065: getstatic x/oc9755810e45.ÿ Lx/ocdd342096f8;
      // 068: astore 3
      // 069: aload 3
      // 06a: iload 2
      // 06b: ifne 076
      // 06e: ifnull 09c
      // 071: goto 075
      // 074: athrow
      // 075: aload 3
      // 076: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 079: iload 2
      // 07a: ifne 0ac
      // 07d: ifeq 09c
      // 080: goto 084
      // 083: athrow
      // 084: getstatic x/ocdd342096f8.f Lnet/minecraft/entity/EntityLivingBase;
      // 087: iload 2
      // 088: ifne 099
      // 08b: goto 08f
      // 08e: athrow
      // 08f: ifnonnull 0d5
      // 092: goto 096
      // 095: athrow
      // 096: getstatic x/ocdd342096f8.ѐ Lnet/minecraft/entity/EntityLivingBase;
      // 099: ifnonnull 0d5
      // 09c: aload 0
      // 09d: iload 2
      // 09e: ifne 0cb
      // 0a1: goto 0a5
      // 0a4: athrow
      // 0a5: getfield x/oce3cc81daa8.a Z
      // 0a8: goto 0ac
      // 0ab: athrow
      // 0ac: ifne 0c2
      // 0af: aload 0
      // 0b0: iload 2
      // 0b1: ifne 0d0
      // 0b4: goto 0b8
      // 0b7: athrow
      // 0b8: getfield x/oce3cc81daa8.з Z
      // 0bb: ifeq 0cf
      // 0be: goto 0c2
      // 0c1: athrow
      // 0c2: aload 0
      // 0c3: invokevirtual x/oce3cc81daa8.ɝ ()V
      // 0c6: aload 0
      // 0c7: goto 0cb
      // 0ca: athrow
      // 0cb: bipush 1
      // 0cc: invokevirtual x/oce3cc81daa8.ˣ (Z)V
      // 0cf: aload 0
      // 0d0: bipush 0
      // 0d1: putfield x/oce3cc81daa8.Ƀ Z
      // 0d4: return
      // 0d5: getstatic x/oc9755810e45.ϔ Lx/oc8edd24b1ed;
      // 0d8: iload 2
      // 0d9: ifne 0e6
      // 0dc: ifnull 0fb
      // 0df: goto 0e3
      // 0e2: athrow
      // 0e3: getstatic x/oc9755810e45.ϔ Lx/oc8edd24b1ed;
      // 0e6: invokevirtual x/oc8edd24b1ed.Ƴ ()Z
      // 0e9: iload 2
      // 0ea: ifne 0fe
      // 0ed: ifeq 0fb
      // 0f0: goto 0f4
      // 0f3: athrow
      // 0f4: aload 0
      // 0f5: bipush 1
      // 0f6: invokevirtual x/oce3cc81daa8.ǟ (Z)V
      // 0f9: return
      // 0fa: athrow
      // 0fb: invokestatic x/oc7ab2161b9f.ө ()Z
      // 0fe: iload 2
      // 0ff: ifne 118
      // 102: ifne 110
      // 105: goto 109
      // 108: athrow
      // 109: aload 0
      // 10a: bipush 0
      // 10b: invokevirtual x/oce3cc81daa8.ǟ (Z)V
      // 10e: return
      // 10f: athrow
      // 110: aload 0
      // 111: getfield x/oce3cc81daa8.Ţ Lx/oca9cc61aada;
      // 114: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 117: d2i
      // 118: istore 3
      // 119: iload 3
      // 11a: iload 2
      // 11b: ifne 143
      // 11e: aload 0
      // 11f: getfield x/oce3cc81daa8.ӛ I
      // 122: if_icmpeq 137
      // 125: goto 129
      // 128: athrow
      // 129: aload 0
      // 12a: bipush 1
      // 12b: invokevirtual x/oce3cc81daa8.ǟ (Z)V
      // 12e: aload 0
      // 12f: iload 3
      // 130: putfield x/oce3cc81daa8.ӛ I
      // 133: goto 137
      // 136: athrow
      // 137: aload 0
      // 138: iload 2
      // 139: ifne 157
      // 13c: getfield x/oce3cc81daa8.ϩ Z
      // 13f: goto 143
      // 142: athrow
      // 143: ifeq 156
      // 146: aload 0
      // 147: invokevirtual x/oce3cc81daa8.ɝ ()V
      // 14a: aload 0
      // 14b: bipush 1
      // 14c: invokevirtual x/oce3cc81daa8.ˣ (Z)V
      // 14f: aload 0
      // 150: bipush 0
      // 151: putfield x/oce3cc81daa8.Ƀ Z
      // 154: return
      // 155: athrow
      // 156: aload 0
      // 157: dup
      // 158: getfield x/oce3cc81daa8.Ɍ I
      // 15b: bipush 1
      // 15c: iadd
      // 15d: dup_x1
      // 15e: putfield x/oce3cc81daa8.Ɍ I
      // 161: istore 4
      // 163: aload 0
      // 164: invokevirtual x/oce3cc81daa8.Ƴ ()Z
      // 167: iload 2
      // 168: ifne 196
      // 16b: ifne 18d
      // 16e: goto 172
      // 171: athrow
      // 172: aload 0
      // 173: getfield x/oce3cc81daa8.з Z
      // 176: iload 2
      // 177: ifne 196
      // 17a: goto 17e
      // 17d: athrow
      // 17e: ifeq 18d
      // 181: goto 185
      // 184: athrow
      // 185: aload 0
      // 186: invokevirtual x/oce3cc81daa8.ɝ ()V
      // 189: goto 18d
      // 18c: athrow
      // 18d: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 190: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 193: getfield net/minecraft/client/entity/EntityPlayerSP.hurtTime I
      // 196: istore 5
      // 198: iload 5
      // 19a: iload 2
      // 19b: ifne 1ae
      // 19e: aload 0
      // 19f: getfield x/oce3cc81daa8.Η I
      // 1a2: if_icmple 1b1
      // 1a5: goto 1a9
      // 1a8: athrow
      // 1a9: bipush 1
      // 1aa: goto 1ae
      // 1ad: athrow
      // 1ae: goto 1b2
      // 1b1: bipush 0
      // 1b2: istore 6
      // 1b4: iload 2
      // 1b5: aload 0
      // 1b6: iload 5
      // 1b8: putfield x/oce3cc81daa8.Η I
      // 1bb: bipush 0
      // 1bc: invokestatic org/lwjgl/input/Mouse.isButtonDown (I)Z
      // 1bf: istore 7
      // 1c1: ifne 271
      // 1c4: aload 0
      // 1c5: invokevirtual x/oce3cc81daa8.Ĵ ()Z
      // 1c8: ifeq 267
      // 1cb: goto 1cf
      // 1ce: athrow
      // 1cf: aload 0
      // 1d0: aconst_null
      // 1d1: putfield x/oce3cc81daa8.Ε Lnet/minecraft/entity/EntityLivingBase;
      // 1d4: aload 0
      // 1d5: invokevirtual x/oce3cc81daa8.а ()Z
      // 1d8: istore 8
      // 1da: getstatic x/oc9755810e45.ÿ Lx/ocdd342096f8;
      // 1dd: iload 2
      // 1de: ifne 1f3
      // 1e1: ifnull 21f
      // 1e4: goto 1e8
      // 1e7: athrow
      // 1e8: getstatic x/oc9755810e45.ÿ Lx/ocdd342096f8;
      // 1eb: iload 2
      // 1ec: ifne 200
      // 1ef: goto 1f3
      // 1f2: athrow
      // 1f3: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 1f6: ifeq 21f
      // 1f9: getstatic x/oc9755810e45.ÿ Lx/ocdd342096f8;
      // 1fc: goto 200
      // 1ff: athrow
      // 200: invokevirtual x/ocdd342096f8.љ ()Z
      // 203: iload 2
      // 204: ifne 210
      // 207: ifne 21f
      // 20a: goto 20e
      // 20d: athrow
      // 20e: iload 8
      // 210: iload 2
      // 211: ifne 21c
      // 214: ifeq 21f
      // 217: goto 21b
      // 21a: athrow
      // 21b: bipush 1
      // 21c: goto 220
      // 21f: bipush 0
      // 220: istore 9
      // 222: bipush 1
      // 223: invokestatic org/lwjgl/input/Mouse.isButtonDown (I)Z
      // 226: istore 10
      // 228: aload 0
      // 229: iload 7
      // 22b: iload 2
      // 22c: ifne 248
      // 22f: ifne 247
      // 232: goto 236
      // 235: athrow
      // 236: iload 9
      // 238: iload 2
      // 239: ifne 248
      // 23c: goto 240
      // 23f: athrow
      // 240: ifeq 24b
      // 243: goto 247
      // 246: athrow
      // 247: bipush 1
      // 248: goto 24c
      // 24b: bipush 0
      // 24c: iload 10
      // 24e: invokevirtual x/oce3cc81daa8.B (ZZ)Z
      // 251: ifne 260
      // 254: aload 0
      // 255: bipush 1
      // 256: invokevirtual x/oce3cc81daa8.ˣ (Z)V
      // 259: aload 0
      // 25a: bipush 0
      // 25b: putfield x/oce3cc81daa8.Ƀ Z
      // 25e: return
      // 25f: athrow
      // 260: aload 0
      // 261: iload 4
      // 263: invokevirtual x/oce3cc81daa8.Ƶ (I)V
      // 266: return
      // 267: aload 0
      // 268: aload 0
      // 269: iload 7
      // 26b: invokevirtual x/oce3cc81daa8.Ō (Z)Lnet/minecraft/entity/player/EntityPlayer;
      // 26e: putfield x/oce3cc81daa8.Ε Lnet/minecraft/entity/EntityLivingBase;
      // 271: getstatic x/oc9755810e45.ÿ Lx/ocdd342096f8;
      // 274: iload 2
      // 275: ifne 28a
      // 278: ifnull 2ad
      // 27b: goto 27f
      // 27e: athrow
      // 27f: getstatic x/oc9755810e45.ÿ Lx/ocdd342096f8;
      // 282: iload 2
      // 283: ifne 297
      // 286: goto 28a
      // 289: athrow
      // 28a: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 28d: ifeq 2ad
      // 290: getstatic x/oc9755810e45.ÿ Lx/ocdd342096f8;
      // 293: goto 297
      // 296: athrow
      // 297: invokevirtual x/ocdd342096f8.љ ()Z
      // 29a: ifne 2ad
      // 29d: aload 0
      // 29e: getfield x/oce3cc81daa8.Ε Lnet/minecraft/entity/EntityLivingBase;
      // 2a1: ifnull 2ad
      // 2a4: goto 2a8
      // 2a7: athrow
      // 2a8: bipush 1
      // 2a9: goto 2ae
      // 2ac: athrow
      // 2ad: bipush 0
      // 2ae: istore 8
      // 2b0: bipush 1
      // 2b1: invokestatic org/lwjgl/input/Mouse.isButtonDown (I)Z
      // 2b4: istore 9
      // 2b6: iload 7
      // 2b8: iload 2
      // 2b9: ifne 2d5
      // 2bc: ifne 2d4
      // 2bf: goto 2c3
      // 2c2: athrow
      // 2c3: iload 8
      // 2c5: iload 2
      // 2c6: ifne 2d5
      // 2c9: goto 2cd
      // 2cc: athrow
      // 2cd: ifeq 2d8
      // 2d0: goto 2d4
      // 2d3: athrow
      // 2d4: bipush 1
      // 2d5: goto 2d9
      // 2d8: bipush 0
      // 2d9: istore 10
      // 2db: aload 0
      // 2dc: getfield x/oce3cc81daa8.Ε Lnet/minecraft/entity/EntityLivingBase;
      // 2df: ifnull 2e7
      // 2e2: bipush 1
      // 2e3: goto 2e8
      // 2e6: athrow
      // 2e7: bipush 0
      // 2e8: istore 11
      // 2ea: iload 11
      // 2ec: iload 2
      // 2ed: ifne 303
      // 2f0: ifeq 312
      // 2f3: goto 2f7
      // 2f6: athrow
      // 2f7: aload 0
      // 2f8: iload 10
      // 2fa: iload 9
      // 2fc: invokevirtual x/oce3cc81daa8.B (ZZ)Z
      // 2ff: goto 303
      // 302: athrow
      // 303: iload 2
      // 304: ifne 30f
      // 307: ifeq 312
      // 30a: goto 30e
      // 30d: athrow
      // 30e: bipush 1
      // 30f: goto 313
      // 312: bipush 0
      // 313: istore 12
      // 315: iload 11
      // 317: iload 2
      // 318: ifne 334
      // 31b: ifne 332
      // 31e: goto 322
      // 321: athrow
      // 322: aload 0
      // 323: invokevirtual x/oce3cc81daa8.ɝ ()V
      // 326: aload 0
      // 327: bipush 1
      // 328: invokevirtual x/oce3cc81daa8.ˣ (Z)V
      // 32b: aload 0
      // 32c: bipush 0
      // 32d: putfield x/oce3cc81daa8.Ƀ Z
      // 330: return
      // 331: athrow
      // 332: iload 12
      // 334: iload 2
      // 335: ifne 38e
      // 338: ifne 38a
      // 33b: goto 33f
      // 33e: athrow
      // 33f: iload 9
      // 341: iload 2
      // 342: ifne 38e
      // 345: goto 349
      // 348: athrow
      // 349: ifeq 38a
      // 34c: goto 350
      // 34f: athrow
      // 350: aload 0
      // 351: iload 2
      // 352: ifne 36c
      // 355: goto 359
      // 358: athrow
      // 359: getfield x/oce3cc81daa8.з Z
      // 35c: ifeq 36b
      // 35f: goto 363
      // 362: athrow
      // 363: aload 0
      // 364: invokevirtual x/oce3cc81daa8.ɝ ()V
      // 367: goto 36b
      // 36a: athrow
      // 36b: aload 0
      // 36c: iload 2
      // 36d: ifne 385
      // 370: getfield x/oce3cc81daa8.a Z
      // 373: ifne 384
      // 376: goto 37a
      // 379: athrow
      // 37a: aload 0
      // 37b: iload 4
      // 37d: invokevirtual x/oce3cc81daa8.ɒ (I)V
      // 380: goto 384
      // 383: athrow
      // 384: aload 0
      // 385: bipush 1
      // 386: putfield x/oce3cc81daa8.Ƀ Z
      // 389: return
      // 38a: aload 0
      // 38b: getfield x/oce3cc81daa8.Ƀ Z
      // 38e: iload 2
      // 38f: ifne 3a9
      // 392: ifeq 3a7
      // 395: goto 399
      // 398: athrow
      // 399: aload 0
      // 39a: bipush 1
      // 39b: invokevirtual x/oce3cc81daa8.ˣ (Z)V
      // 39e: aload 0
      // 39f: bipush 0
      // 3a0: putfield x/oce3cc81daa8.Ƀ Z
      // 3a3: goto 3a7
      // 3a6: athrow
      // 3a7: iload 12
      // 3a9: iload 2
      // 3aa: ifne 3c7
      // 3ad: ifne 3bb
      // 3b0: goto 3b4
      // 3b3: athrow
      // 3b4: aload 0
      // 3b5: bipush 1
      // 3b6: invokevirtual x/oce3cc81daa8.ˣ (Z)V
      // 3b9: return
      // 3ba: athrow
      // 3bb: aload 0
      // 3bc: iload 2
      // 3bd: ifne 3cb
      // 3c0: invokevirtual x/oce3cc81daa8.t ()Z
      // 3c3: goto 3c7
      // 3c6: athrow
      // 3c7: ifeq 3d1
      // 3ca: aload 0
      // 3cb: iload 4
      // 3cd: invokevirtual x/oce3cc81daa8.K (I)V
      // 3d0: return
      // 3d1: return
   }

   @oc66fa4f2195
   public void ϳ(oc9adb807c19 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 2
      // 04: aload 0
      // 05: invokevirtual x/oce3cc81daa8.Ϧ ()Z
      // 08: ifeq 0d
      // 0b: return
      // 0c: athrow
      // 0d: aload 1
      // 0e: getfield x/ocb508b4e274.Ұ Lx/oc110d7f376c;
      // 11: getstatic x/oc110d7f376c.START Lx/oc110d7f376c;
      // 14: if_acmpne 2a
      // 17: aload 0
      // 18: iload 2
      // 19: ifne 2d
      // 1c: goto 20
      // 1f: athrow
      // 20: invokevirtual x/oce3cc81daa8.Ƴ ()Z
      // 23: ifne 2c
      // 26: goto 2a
      // 29: athrow
      // 2a: return
      // 2b: athrow
      // 2c: aload 0
      // 2d: getfield x/oce3cc81daa8.ӛ I
      // 30: iload 2
      // 31: ifne 51
      // 34: ifeq 4e
      // 37: goto 3b
      // 3a: athrow
      // 3b: aload 0
      // 3c: bipush 1
      // 3d: invokevirtual x/oce3cc81daa8.ǟ (Z)V
      // 40: aload 0
      // 41: bipush 0
      // 42: putfield x/oce3cc81daa8.ӛ I
      // 45: bipush 0
      // 46: invokestatic x/ReflectionUtils.setItemInUse (Z)Z
      // 49: pop
      // 4a: goto 4e
      // 4d: athrow
      // 4e: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 51: iload 2
      // 52: ifne 71
      // 55: ifeq 85
      // 58: goto 5c
      // 5b: athrow
      // 5c: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 5f: iload 2
      // 60: ifne 77
      // 63: goto 67
      // 66: athrow
      // 67: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 6a: getfield net/minecraft/client/entity/EntityPlayerSP.isDead Z
      // 6d: goto 71
      // 70: athrow
      // 71: ifne 85
      // 74: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 77: iload 2
      // 78: ifne 8f
      // 7b: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 7e: ifnull 8c
      // 81: goto 85
      // 84: athrow
      // 85: aload 0
      // 86: bipush 1
      // 87: invokevirtual x/oce3cc81daa8.Ξ (Z)V
      // 8a: return
      // 8b: athrow
      // 8c: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 8f: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 92: getfield net/minecraft/client/entity/EntityPlayerSP.hurtTime I
      // 95: istore 3
      // 96: iload 3
      // 97: iload 2
      // 98: ifne ab
      // 9b: aload 0
      // 9c: getfield x/oce3cc81daa8.Η I
      // 9f: if_icmple ae
      // a2: goto a6
      // a5: athrow
      // a6: bipush 1
      // a7: goto ab
      // aa: athrow
      // ab: goto af
      // ae: bipush 0
      // af: istore 4
      // b1: aload 0
      // b2: iload 2
      // b3: ifne d5
      // b6: iload 3
      // b7: putfield x/oce3cc81daa8.Η I
      // ba: aload 0
      // bb: invokevirtual x/oce3cc81daa8.ȩ ()Z
      // be: ifne cc
      // c1: goto c5
      // c4: athrow
      // c5: aload 0
      // c6: bipush 0
      // c7: invokevirtual x/oce3cc81daa8.Ξ (Z)V
      // ca: return
      // cb: athrow
      // cc: aload 0
      // cd: aload 0
      // ce: invokevirtual x/oce3cc81daa8.Ƴ ()Lnet/minecraft/entity/player/EntityPlayer;
      // d1: putfield x/oce3cc81daa8.Ε Lnet/minecraft/entity/EntityLivingBase;
      // d4: aload 0
      // d5: aload 0
      // d6: dup
      // d7: getfield x/oce3cc81daa8.Ɍ I
      // da: bipush 1
      // db: iadd
      // dc: dup_x1
      // dd: putfield x/oce3cc81daa8.Ɍ I
      // e0: bipush 0
      // e1: invokestatic org/lwjgl/input/Mouse.isButtonDown (I)Z
      // e4: bipush 1
      // e5: invokestatic org/lwjgl/input/Mouse.isButtonDown (I)Z
      // e8: iload 4
      // ea: invokevirtual x/oce3cc81daa8.տ (IZZZ)V
      // ed: return
   }

   private void տ(int param1, boolean param2, boolean param3, boolean param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 000: getstatic x/oc5e549848f3.İ I
      // 003: istore 5
      // 005: iload 2
      // 006: iload 5
      // 008: ifne 065
      // 00b: ifne 058
      // 00e: goto 012
      // 011: athrow
      // 012: iload 3
      // 013: iload 5
      // 015: ifne 046
      // 018: goto 01c
      // 01b: athrow
      // 01c: ifne 031
      // 01f: goto 023
      // 022: athrow
      // 023: aload 0
      // 024: bipush 1
      // 025: invokevirtual x/oce3cc81daa8.ǟ (Z)V
      // 028: iload 5
      // 02a: ifeq 057
      // 02d: goto 031
      // 030: athrow
      // 031: aload 0
      // 032: invokevirtual x/oce3cc81daa8.ɝ ()V
      // 035: iload 5
      // 037: ifne 052
      // 03a: goto 03e
      // 03d: athrow
      // 03e: aload 0
      // 03f: getfield x/oce3cc81daa8.a Z
      // 042: goto 046
      // 045: athrow
      // 046: ifne 057
      // 049: aload 0
      // 04a: iload 1
      // 04b: invokevirtual x/oce3cc81daa8.ɒ (I)V
      // 04e: goto 052
      // 051: athrow
      // 052: aload 0
      // 053: bipush 1
      // 054: putfield x/oce3cc81daa8.Ƀ Z
      // 057: return
      // 058: aload 0
      // 059: iload 5
      // 05b: ifne 077
      // 05e: getfield x/oce3cc81daa8.Ƀ Z
      // 061: goto 065
      // 064: athrow
      // 065: ifeq 076
      // 068: aload 0
      // 069: bipush 1
      // 06a: invokevirtual x/oce3cc81daa8.ˣ (Z)V
      // 06d: aload 0
      // 06e: bipush 0
      // 06f: putfield x/oce3cc81daa8.Ƀ Z
      // 072: goto 076
      // 075: athrow
      // 076: aload 0
      // 077: iload 5
      // 079: ifne 08b
      // 07c: getfield x/oce3cc81daa8.Ε Lnet/minecraft/entity/EntityLivingBase;
      // 07f: ifnull 0b2
      // 082: goto 086
      // 085: athrow
      // 086: aload 0
      // 087: goto 08b
      // 08a: athrow
      // 08b: getfield x/oce3cc81daa8.ӕ Lx/occ2f8dff8d8;
      // 08e: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 091: iload 5
      // 093: ifne 0af
      // 096: ifeq 0ae
      // 099: goto 09d
      // 09c: athrow
      // 09d: iload 3
      // 09e: iload 5
      // 0a0: ifne 0af
      // 0a3: goto 0a7
      // 0a6: athrow
      // 0a7: ifeq 0b2
      // 0aa: goto 0ae
      // 0ad: athrow
      // 0ae: bipush 1
      // 0af: goto 0b3
      // 0b2: bipush 0
      // 0b3: istore 6
      // 0b5: aload 0
      // 0b6: getfield x/oce3cc81daa8.з Z
      // 0b9: iload 5
      // 0bb: ifne 180
      // 0be: ifeq 17e
      // 0c1: goto 0c5
      // 0c4: athrow
      // 0c5: aload 0
      // 0c6: getfield x/oce3cc81daa8.Ы Lx/oca9cc61aada;
      // 0c9: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0cc: invokestatic x/oce3cc81daa8.Ɇ (D)I
      // 0cf: istore 7
      // 0d1: iload 7
      // 0d3: iload 5
      // 0d5: ifne 0e7
      // 0d8: ifle 113
      // 0db: goto 0df
      // 0de: athrow
      // 0df: aload 0
      // 0e0: getfield x/oce3cc81daa8.Ʉ I
      // 0e3: goto 0e7
      // 0e6: athrow
      // 0e7: iload 5
      // 0e9: ifne 106
      // 0ec: iflt 113
      // 0ef: goto 0f3
      // 0f2: athrow
      // 0f3: iload 1
      // 0f4: iload 5
      // 0f6: ifne 110
      // 0f9: goto 0fd
      // 0fc: athrow
      // 0fd: aload 0
      // 0fe: getfield x/oce3cc81daa8.Ʉ I
      // 101: isub
      // 102: goto 106
      // 105: athrow
      // 106: iload 7
      // 108: if_icmplt 113
      // 10b: bipush 1
      // 10c: goto 110
      // 10f: athrow
      // 110: goto 114
      // 113: bipush 0
      // 114: istore 8
      // 116: iload 5
      // 118: ifne 13e
      // 11b: iload 8
      // 11d: ifne 136
      // 120: goto 124
      // 123: athrow
      // 124: iload 6
      // 126: iload 5
      // 128: ifne 180
      // 12b: goto 12f
      // 12e: athrow
      // 12f: ifne 17e
      // 132: goto 136
      // 135: athrow
      // 136: aload 0
      // 137: invokevirtual x/oce3cc81daa8.ɝ ()V
      // 13a: goto 13e
      // 13d: athrow
      // 13e: iload 8
      // 140: iload 5
      // 142: ifne 180
      // 145: ifeq 17e
      // 148: goto 14c
      // 14b: athrow
      // 14c: aload 0
      // 14d: getfield x/oce3cc81daa8.H Lx/occ2f8dff8d8;
      // 150: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 153: iload 5
      // 155: ifne 180
      // 158: goto 15c
      // 15b: athrow
      // 15c: ifeq 17e
      // 15f: goto 163
      // 162: athrow
      // 163: iload 6
      // 165: iload 5
      // 167: ifne 180
      // 16a: goto 16e
      // 16d: athrow
      // 16e: ifeq 17e
      // 171: goto 175
      // 174: athrow
      // 175: aload 0
      // 176: iload 1
      // 177: invokevirtual x/oce3cc81daa8.ɒ (I)V
      // 17a: goto 17e
      // 17d: athrow
      // 17e: iload 6
      // 180: iload 5
      // 182: ifne 1a0
      // 185: ifne 193
      // 188: goto 18c
      // 18b: athrow
      // 18c: aload 0
      // 18d: bipush 1
      // 18e: invokevirtual x/oce3cc81daa8.ˣ (Z)V
      // 191: return
      // 192: athrow
      // 193: aload 0
      // 194: iload 5
      // 196: ifne 1d5
      // 199: getfield x/oce3cc81daa8.a Z
      // 19c: goto 1a0
      // 19f: athrow
      // 1a0: ifne 1d4
      // 1a3: aload 0
      // 1a4: iload 5
      // 1a6: ifne 1d5
      // 1a9: goto 1ad
      // 1ac: athrow
      // 1ad: getfield x/oce3cc81daa8.з Z
      // 1b0: ifne 1d4
      // 1b3: goto 1b7
      // 1b6: athrow
      // 1b7: aload 0
      // 1b8: iload 5
      // 1ba: ifne 1d5
      // 1bd: goto 1c1
      // 1c0: athrow
      // 1c1: invokevirtual x/oce3cc81daa8.ý ()Z
      // 1c4: ifeq 1d4
      // 1c7: goto 1cb
      // 1ca: athrow
      // 1cb: aload 0
      // 1cc: iload 1
      // 1cd: invokevirtual x/oce3cc81daa8.ɒ (I)V
      // 1d0: goto 1d4
      // 1d3: athrow
      // 1d4: aload 0
      // 1d5: iload 5
      // 1d7: ifne 1e9
      // 1da: getfield x/oce3cc81daa8.a Z
      // 1dd: ifeq 291
      // 1e0: goto 1e4
      // 1e3: athrow
      // 1e4: aload 0
      // 1e5: goto 1e9
      // 1e8: athrow
      // 1e9: getfield x/oce3cc81daa8.Ц Lx/oca9cc61aada;
      // 1ec: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 1ef: invokestatic x/oce3cc81daa8.Ɇ (D)I
      // 1f2: istore 7
      // 1f4: iload 7
      // 1f6: iload 5
      // 1f8: ifne 20a
      // 1fb: ifle 236
      // 1fe: goto 202
      // 201: athrow
      // 202: aload 0
      // 203: getfield x/oce3cc81daa8.Ȁ I
      // 206: goto 20a
      // 209: athrow
      // 20a: iload 5
      // 20c: ifne 229
      // 20f: iflt 236
      // 212: goto 216
      // 215: athrow
      // 216: iload 1
      // 217: iload 5
      // 219: ifne 233
      // 21c: goto 220
      // 21f: athrow
      // 220: aload 0
      // 221: getfield x/oce3cc81daa8.Ȁ I
      // 224: isub
      // 225: goto 229
      // 228: athrow
      // 229: iload 7
      // 22b: if_icmplt 236
      // 22e: bipush 1
      // 22f: goto 233
      // 232: athrow
      // 233: goto 237
      // 236: bipush 0
      // 237: istore 8
      // 239: aload 0
      // 23a: getfield x/oce3cc81daa8.Ԡ Lx/occ2f8dff8d8;
      // 23d: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 240: iload 5
      // 242: ifne 263
      // 245: ifeq 261
      // 248: goto 24c
      // 24b: athrow
      // 24c: iload 4
      // 24e: iload 5
      // 250: ifne 263
      // 253: goto 257
      // 256: athrow
      // 257: ifeq 261
      // 25a: goto 25e
      // 25d: athrow
      // 25e: bipush 1
      // 25f: istore 8
      // 261: iload 8
      // 263: iload 5
      // 265: ifne 280
      // 268: ifeq 291
      // 26b: goto 26f
      // 26e: athrow
      // 26f: aload 0
      // 270: iload 5
      // 272: ifne 28d
      // 275: goto 279
      // 278: athrow
      // 279: invokevirtual x/oce3cc81daa8.B ()Z
      // 27c: goto 280
      // 27f: athrow
      // 280: ifeq 28c
      // 283: aload 0
      // 284: iload 1
      // 285: invokevirtual x/oce3cc81daa8.ɷ (I)V
      // 288: goto 28c
      // 28b: athrow
      // 28c: aload 0
      // 28d: bipush 1
      // 28e: invokevirtual x/oce3cc81daa8.ˣ (Z)V
      // 291: return
   }

   private void Ƶ(int param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 2
      // 04: aload 0
      // 05: iload 2
      // 06: ifne 2a
      // 09: getfield x/oce3cc81daa8.ɍ J
      // 0c: lconst_0
      // 0d: lcmp
      // 0e: ifle 29
      // 11: goto 15
      // 14: athrow
      // 15: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 18: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 1b: getfield net/minecraft/client/settings/GameSettings.keyBindUseItem Lnet/minecraft/client/settings/KeyBinding;
      // 1e: invokevirtual net/minecraft/client/settings/KeyBinding.getKeyCode ()I
      // 21: bipush 1
      // 22: invokestatic net/minecraft/client/settings/KeyBinding.setKeyBindState (IZ)V
      // 25: goto 29
      // 28: athrow
      // 29: aload 0
      // 2a: iload 2
      // 2b: ifne 40
      // 2e: invokevirtual x/oce3cc81daa8.ε ()Z
      // 31: ifeq 3f
      // 34: goto 38
      // 37: athrow
      // 38: aload 0
      // 39: bipush 1
      // 3a: invokevirtual x/oce3cc81daa8.ˣ (Z)V
      // 3d: return
      // 3e: athrow
      // 3f: aload 0
      // 40: iload 2
      // 41: ifne 7b
      // 44: invokevirtual x/oce3cc81daa8.Î ()Z
      // 47: ifeq 7a
      // 4a: goto 4e
      // 4d: athrow
      // 4e: aload 0
      // 4f: iload 2
      // 50: ifne 75
      // 53: goto 57
      // 56: athrow
      // 57: invokestatic java/lang/System.nanoTime ()J
      // 5a: ldc2_w 7638805580012896781
      // 5d: ldc2_w 7638805580009474381
      // 60: lxor
      // 61: ladd
      // 62: putfield x/oce3cc81daa8.ɍ J
      // 65: aload 0
      // 66: getfield x/oce3cc81daa8.a Z
      // 69: ifne 79
      // 6c: goto 70
      // 6f: athrow
      // 70: aload 0
      // 71: goto 75
      // 74: athrow
      // 75: iload 1
      // 76: invokevirtual x/oce3cc81daa8.ɒ (I)V
      // 79: return
      // 7a: aload 0
      // 7b: getfield x/oce3cc81daa8.ɍ J
      // 7e: iload 2
      // 7f: ifne 92
      // 82: lconst_0
      // 83: lcmp
      // 84: ifle a3
      // 87: goto 8b
      // 8a: athrow
      // 8b: invokestatic java/lang/System.nanoTime ()J
      // 8e: goto 92
      // 91: athrow
      // 92: aload 0
      // 93: getfield x/oce3cc81daa8.ɍ J
      // 96: lcmp
      // 97: ifle a3
      // 9a: aload 0
      // 9b: bipush 1
      // 9c: invokevirtual x/oce3cc81daa8.ˣ (Z)V
      // 9f: goto a3
      // a2: athrow
      // a3: return
   }

   private void K(int param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 2
      // 04: aload 0
      // 05: iload 2
      // 06: ifne 1d
      // 09: getfield x/oce3cc81daa8.a Z
      // 0c: ifne 1c
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: iload 1
      // 15: invokevirtual x/oce3cc81daa8.ɒ (I)V
      // 18: goto 1c
      // 1b: athrow
      // 1c: aload 0
      // 1d: invokevirtual x/oce3cc81daa8.ʄ ()Lnet/minecraft/entity/EntityLivingBase;
      // 20: astore 3
      // 21: aload 3
      // 22: ifnonnull 27
      // 25: return
      // 26: athrow
      // 27: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 2a: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 2d: getfield net/minecraft/client/settings/GameSettings.keyBindAttack Lnet/minecraft/client/settings/KeyBinding;
      // 30: invokevirtual net/minecraft/client/settings/KeyBinding.isPressed ()Z
      // 33: ifeq 47
      // 36: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 39: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 3c: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 3f: aload 3
      // 40: invokestatic de/florianmichael/viamcp/fixes/AttackOrder.sendFixedAttack (Lnet/minecraft/client/Minecraft;Lnet/minecraft/entity/player/EntityPlayer;Lnet/minecraft/entity/Entity;)V
      // 43: iload 2
      // 44: ifeq 27
      // 47: return
   }

   private EntityLivingBase ʄ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: getstatic x/oc9755810e45.ÿ Lx/ocdd342096f8;
      // 06: astore 2
      // 07: istore 1
      // 08: aload 2
      // 09: iload 1
      // 0a: ifne 15
      // 0d: ifnull 6f
      // 10: goto 14
      // 13: athrow
      // 14: aload 2
      // 15: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 18: ifeq 6f
      // 1b: getstatic x/ocdd342096f8.ѐ Lnet/minecraft/entity/EntityLivingBase;
      // 1e: iload 1
      // 1f: ifne 30
      // 22: goto 26
      // 25: athrow
      // 26: ifnull 6f
      // 29: goto 2d
      // 2c: athrow
      // 2d: getstatic x/ocdd342096f8.ѐ Lnet/minecraft/entity/EntityLivingBase;
      // 30: astore 3
      // 31: aload 3
      // 32: iload 1
      // 33: ifne 48
      // 36: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 39: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 3c: if_acmpeq 6f
      // 3f: goto 43
      // 42: athrow
      // 43: aload 3
      // 44: goto 48
      // 47: athrow
      // 48: iload 1
      // 49: ifne 5b
      // 4c: getfield net/minecraft/entity/EntityLivingBase.isDead Z
      // 4f: ifne 6f
      // 52: goto 56
      // 55: athrow
      // 56: aload 3
      // 57: goto 5b
      // 5a: athrow
      // 5b: iload 1
      // 5c: ifne 6e
      // 5f: getfield net/minecraft/entity/EntityLivingBase.deathTime I
      // 62: ifne 6f
      // 65: goto 69
      // 68: athrow
      // 69: aload 3
      // 6a: goto 6e
      // 6d: athrow
      // 6e: areturn
      // 6f: ldc2_w 3.0
      // 72: aload 0
      // 73: getfield x/oce3cc81daa8.Ə Lx/oca9cc61aada;
      // 76: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 79: invokestatic java/lang/Math.min (DD)D
      // 7c: dstore 3
      // 7d: dload 3
      // 7e: fconst_1
      // 7f: getstatic x/oc75d51ec7eb.d [F
      // 82: aconst_null
      // 83: invokestatic x/oc75d51ec7eb.Ƕ (DF[FLnet/minecraft/entity/EntityLivingBase;)Lnet/minecraft/util/MovingObjectPosition;
      // 86: astore 5
      // 88: aload 5
      // 8a: iload 1
      // 8b: ifne 9a
      // 8e: ifnonnull 98
      // 91: goto 95
      // 94: athrow
      // 95: aconst_null
      // 96: areturn
      // 97: athrow
      // 98: aload 5
      // 9a: getfield net/minecraft/util/MovingObjectPosition.entityHit Lnet/minecraft/entity/Entity;
      // 9d: dload 3
      // 9e: dload 3
      // 9f: dmul
      // a0: aload 0
      // a1: getfield x/oce3cc81daa8.F Lx/occ2f8dff8d8;
      // a4: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // a7: invokestatic x/oc5e08d6b90f.ķ (Lnet/minecraft/entity/Entity;DZ)Lnet/minecraft/entity/player/EntityPlayer;
      // aa: areturn
   }

   private boolean Î() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oc5e549848f3.İ I
      // 003: istore 1
      // 004: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 007: iload 1
      // 008: ifne 013
      // 00b: ifne 014
      // 00e: goto 012
      // 011: athrow
      // 012: bipush 0
      // 013: ireturn
      // 014: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 017: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 01a: fconst_1
      // 01b: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getPositionEyes (F)Lnet/minecraft/util/Vec3;
      // 01e: astore 2
      // 01f: invokestatic java/lang/System.currentTimeMillis ()J
      // 022: lstore 3
      // 023: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 026: getfield net/minecraft/client/Minecraft.theWorld Lnet/minecraft/client/multiplayer/WorldClient;
      // 029: getfield net/minecraft/client/multiplayer/WorldClient.playerEntities Ljava/util/List;
      // 02c: invokeinterface java/util/List.iterator ()Ljava/util/Iterator; 1
      // 031: astore 5
      // 033: aload 5
      // 035: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 03a: ifeq 283
      // 03d: aload 5
      // 03f: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 044: checkcast net/minecraft/entity/player/EntityPlayer
      // 047: astore 6
      // 049: iload 1
      // 04a: ifne 288
      // 04d: aload 6
      // 04f: iload 1
      // 050: ifne 06e
      // 053: goto 057
      // 056: athrow
      // 057: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 05a: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 05d: if_acmpne 06c
      // 060: goto 064
      // 063: athrow
      // 064: iload 1
      // 065: ifeq 033
      // 068: goto 06c
      // 06b: athrow
      // 06c: aload 6
      // 06e: getfield net/minecraft/entity/player/EntityPlayer.posX D
      // 071: aload 6
      // 073: getfield net/minecraft/entity/player/EntityPlayer.prevPosX D
      // 076: dsub
      // 077: d2f
      // 078: fstore 7
      // 07a: aload 6
      // 07c: getfield net/minecraft/entity/player/EntityPlayer.posZ D
      // 07f: aload 6
      // 081: getfield net/minecraft/entity/player/EntityPlayer.prevPosZ D
      // 084: dsub
      // 085: d2f
      // 086: fstore 8
      // 088: aload 6
      // 08a: getfield net/minecraft/entity/player/EntityPlayer.posX D
      // 08d: fload 7
      // 08f: ldc_w 4.0
      // 092: fmul
      // 093: f2d
      // 094: dadd
      // 095: dstore 9
      // 097: aload 6
      // 099: getfield net/minecraft/entity/player/EntityPlayer.posZ D
      // 09c: fload 8
      // 09e: ldc_w 4.0
      // 0a1: fmul
      // 0a2: f2d
      // 0a3: dadd
      // 0a4: dstore 11
      // 0a6: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0a9: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0ac: aload 6
      // 0ae: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getDistanceToEntity (Lnet/minecraft/entity/Entity;)F
      // 0b1: fstore 13
      // 0b3: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 0b6: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 0b9: dload 9
      // 0bb: aload 6
      // 0bd: getfield net/minecraft/entity/player/EntityPlayer.posY D
      // 0c0: dload 11
      // 0c2: invokevirtual net/minecraft/client/entity/EntityPlayerSP.getDistance (DDD)D
      // 0c5: fload 13
      // 0c7: f2d
      // 0c8: invokestatic java/lang/Math.min (DD)D
      // 0cb: ldc2_w 4.0
      // 0ce: dcmpg
      // 0cf: iload 1
      // 0d0: ifne 0db
      // 0d3: ifgt 0de
      // 0d6: goto 0da
      // 0d9: athrow
      // 0da: bipush 1
      // 0db: goto 0df
      // 0de: bipush 0
      // 0df: istore 14
      // 0e1: iload 14
      // 0e3: iload 1
      // 0e4: ifne 0fb
      // 0e7: ifeq 033
      // 0ea: goto 0ee
      // 0ed: athrow
      // 0ee: aload 6
      // 0f0: iload 1
      // 0f1: ifne 100
      // 0f4: getfield net/minecraft/entity/player/EntityPlayer.isSwingInProgress Z
      // 0f7: goto 0fb
      // 0fa: athrow
      // 0fb: ifeq 033
      // 0fe: aload 6
      // 100: iload 1
      // 101: ifne 11f
      // 104: aload 0
      // 105: getfield x/oce3cc81daa8.F Lx/occ2f8dff8d8;
      // 108: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 10b: invokestatic x/oc5e08d6b90f.Ǝ (Lnet/minecraft/entity/player/EntityPlayer;Z)Z
      // 10e: ifne 11d
      // 111: goto 115
      // 114: athrow
      // 115: iload 1
      // 116: ifeq 033
      // 119: goto 11d
      // 11c: athrow
      // 11d: aload 6
      // 11f: getfield net/minecraft/entity/player/EntityPlayer.swingProgressInt I
      // 122: iload 1
      // 123: ifne 142
      // 126: ifne 141
      // 129: goto 12d
      // 12c: athrow
      // 12d: aload 6
      // 12f: invokevirtual net/minecraft/entity/player/EntityPlayer.isBlocking ()Z
      // 132: iload 1
      // 133: ifne 142
      // 136: goto 13a
      // 139: athrow
      // 13a: ifeq 145
      // 13d: goto 141
      // 140: athrow
      // 141: bipush 1
      // 142: goto 146
      // 145: bipush 0
      // 146: istore 15
      // 148: aload 6
      // 14a: invokevirtual net/minecraft/entity/player/EntityPlayer.isUsingItem ()Z
      // 14d: iload 1
      // 14e: ifne 16d
      // 151: ifeq 16c
      // 154: goto 158
      // 157: athrow
      // 158: aload 6
      // 15a: invokevirtual net/minecraft/entity/player/EntityPlayer.isBlocking ()Z
      // 15d: iload 1
      // 15e: ifne 16d
      // 161: goto 165
      // 164: athrow
      // 165: ifeq 170
      // 168: goto 16c
      // 16b: athrow
      // 16c: bipush 1
      // 16d: goto 171
      // 170: bipush 0
      // 171: istore 16
      // 173: fload 13
      // 175: ldc_w 3.0
      // 178: fcmpl
      // 179: iload 1
      // 17a: ifne 1a2
      // 17d: ifge 1a1
      // 180: goto 184
      // 183: athrow
      // 184: lload 3
      // 185: aload 0
      // 186: getfield x/oce3cc81daa8.Ǳ J
      // 189: lsub
      // 18a: ldc2_w 3297424628217584382
      // 18d: ldc2_w 3297424628217584282
      // 190: lxor
      // 191: lcmp
      // 192: iload 1
      // 193: ifne 1a2
      // 196: goto 19a
      // 199: athrow
      // 19a: ifge 1a5
      // 19d: goto 1a1
      // 1a0: athrow
      // 1a1: bipush 1
      // 1a2: goto 1a6
      // 1a5: bipush 0
      // 1a6: istore 17
      // 1a8: fload 13
      // 1aa: ldc_w 3.0
      // 1ad: fcmpl
      // 1ae: iload 1
      // 1af: ifne 1d7
      // 1b2: ifge 1d6
      // 1b5: goto 1b9
      // 1b8: athrow
      // 1b9: lload 3
      // 1ba: aload 0
      // 1bb: getfield x/oce3cc81daa8.ş J
      // 1be: lsub
      // 1bf: ldc2_w 3297424628217584210
      // 1c2: ldc2_w 3297424628217584282
      // 1c5: lxor
      // 1c6: lcmp
      // 1c7: iload 1
      // 1c8: ifne 1d7
      // 1cb: goto 1cf
      // 1ce: athrow
      // 1cf: iflt 1da
      // 1d2: goto 1d6
      // 1d5: athrow
      // 1d6: bipush 1
      // 1d7: goto 1db
      // 1da: bipush 0
      // 1db: istore 18
      // 1dd: iload 15
      // 1df: iload 1
      // 1e0: ifne 1ec
      // 1e3: ifeq 033
      // 1e6: goto 1ea
      // 1e9: athrow
      // 1ea: iload 16
      // 1ec: iload 1
      // 1ed: ifne 1f9
      // 1f0: ifeq 033
      // 1f3: goto 1f7
      // 1f6: athrow
      // 1f7: iload 17
      // 1f9: iload 1
      // 1fa: ifne 206
      // 1fd: ifeq 033
      // 200: goto 204
      // 203: athrow
      // 204: iload 18
      // 206: iload 1
      // 207: ifne 21d
      // 20a: ifne 219
      // 20d: goto 211
      // 210: athrow
      // 211: iload 1
      // 212: ifeq 033
      // 215: goto 219
      // 218: athrow
      // 219: fload 13
      // 21b: fconst_2
      // 21c: fcmpl
      // 21d: iload 1
      // 21e: ifne 282
      // 221: ifle 276
      // 224: goto 228
      // 227: athrow
      // 228: aload 6
      // 22a: fconst_1
      // 22b: invokevirtual net/minecraft/entity/player/EntityPlayer.getPositionEyes (F)Lnet/minecraft/util/Vec3;
      // 22e: astore 19
      // 230: aload 19
      // 232: aload 2
      // 233: getfield net/minecraft/util/Vec3.xCoord D
      // 236: aload 2
      // 237: getfield net/minecraft/util/Vec3.yCoord D
      // 23a: aload 2
      // 23b: getfield net/minecraft/util/Vec3.zCoord D
      // 23e: invokestatic x/oc75d51ec7eb.ӆ (Lnet/minecraft/util/Vec3;DDD)[F
      // 241: astore 20
      // 243: aload 20
      // 245: iload 1
      // 246: ifne 252
      // 249: ifnull 033
      // 24c: goto 250
      // 24f: athrow
      // 250: aload 20
      // 252: bipush 0
      // 253: faload
      // 254: aload 6
      // 256: getfield net/minecraft/entity/player/EntityPlayer.rotationYaw F
      // 259: invokestatic x/oc75d51ec7eb.ɕ (FF)F
      // 25c: invokestatic java/lang/Math.abs (F)F
      // 25f: ldc_w 35.0
      // 262: fcmpl
      // 263: iload 1
      // 264: ifne 282
      // 267: ifle 276
      // 26a: goto 26e
      // 26d: athrow
      // 26e: iload 1
      // 26f: ifeq 033
      // 272: goto 276
      // 275: athrow
      // 276: aload 0
      // 277: aload 6
      // 279: putfield x/oce3cc81daa8.Ε Lnet/minecraft/entity/EntityLivingBase;
      // 27c: aload 0
      // 27d: lload 3
      // 27e: putfield x/oce3cc81daa8.ş J
      // 281: bipush 1
      // 282: ireturn
      // 283: aload 0
      // 284: aconst_null
      // 285: putfield x/oce3cc81daa8.Ε Lnet/minecraft/entity/EntityLivingBase;
      // 288: bipush 0
      // 289: ireturn
   }

   private boolean а() {
      int var1 = oc5e549848f3.İ;
      int var2 = 1454598297 ^ -589257890;

      while (true) {
         switch (var2) {
            case -1974219833:
               if (oc9755810e45.ÿ != null) {
                  var2 = -1447946299 ^ -589257890;
                  if (var1 == 0) {
                     continue;
                  }
               }

               var2 = -712727004 ^ -589257890;
               if (var1 == 0) {
                  continue;
               }
            case -516715934:
               break;
            case -74123883:
               return true;
            case 157549946:
               return false;
            case 1968354459:
               int var10000;
               label76: {
                  label75: {
                     try {
                        var10000 = oc9755810e45.ÿ.z$3rzb3dil7uydr();
                        if (var1 != 0) {
                           break label76;
                        }

                        if (var10000 == 0) {
                           break label75;
                        }
                     } catch (ocbde1165e4e var5) {
                        throw var5;
                     }

                     var2 = -1317685779 ^ -589257890;
                     if (var1 == 0) {
                        continue;
                     }
                  }

                  var10000 = -712727004 ^ -589257890;
               }

               var2 = var10000;
               if (var1 == 0) {
                  continue;
               }
            case 1838487219:
               int var6;
               label54: {
                  label53: {
                     try {
                        var6 = ocdd342096f8.f instanceof EntityPlayer;
                        if (var1 != 0) {
                           break label54;
                        }

                        if (var6 != 0) {
                           break label53;
                        }
                     } catch (ocbde1165e4e var3) {
                        throw var3;
                     }

                     var2 = 1037248828 ^ -589257890;
                     if (var1 == 0) {
                        continue;
                     }
                  }

                  var6 = 661935819 ^ -589257890;
               }

               var2 = var6;
               if (var1 == 0) {
                  continue;
               }

               return false;
            default:
               throw null;
         }

         int var7;
         label63: {
            label62: {
               try {
                  var7 = ocdd342096f8.ѐ instanceof EntityPlayer;
                  if (var1 != 0) {
                     break label63;
                  }

                  if (var7 == 0) {
                     break label62;
                  }
               } catch (ocbde1165e4e var4) {
                  throw var4;
               }

               var2 = 661935819 ^ -589257890;
               if (var1 == 0) {
                  continue;
               }
            }

            var7 = -712727004 ^ -589257890;
         }

         var2 = var7;
      }
   }

   private int ſ() {
      long var2 = 0L;
      int var4 = 0;
      int var5 = 934885533 ^ 1278336732;
      int var1 = oc5e549848f3.İ;

      while (true) {
         switch (var5) {
            case -1792031585:
               var2 = System.currentTimeMillis() - this.ʚ;
               var4 = (int)(var2 / (6600243698706605042L ^ 6600243698706604992L));
               return Math.max(0, (1278336712 ^ 1278336732) - var4);
            case 2072569409:
               int var10000;
               label28: {
                  label27: {
                     try {
                        long var9;
                        var10000 = (var9 = this.ʚ - 0L) == 0L ? 0 : (var9 < 0L ? -1 : 1);
                        if (var1 != 0) {
                           break label28;
                        }

                        if (var10000 != 0) {
                           break label27;
                        }
                     } catch (ocbde1165e4e var6) {
                        throw var6;
                     }

                     var5 = -448108857 ^ 1278336732;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var10000 = -652338621 ^ 1278336732;
               }

               var5 = var10000;
               if (var1 == 0) {
                  break;
               }
            case -1451509733:
               return 0;
            default:
               throw null;
         }
      }
   }

   private boolean ε() {
      int var1 = oc5e549848f3.İ;
      int var2 = -147407197 ^ 1454913333;

      while (true) {
         switch (var2) {
            case -1584494186:
               int var10000;
               label29: {
                  label28: {
                     try {
                        var10000 = this.ſ();
                        if (var1 != 0) {
                           break label29;
                        }

                        if (var10000 <= (1454913337 ^ 1454913333)) {
                           break label28;
                        }
                     } catch (ocbde1165e4e var3) {
                        throw var3;
                     }

                     var2 = 1835289890 ^ 1454913333;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var10000 = -2083558250 ^ 1454913333;
               }

               var2 = var10000;
               break;
            case -713598045:
               return false;
            case 1004304919:
               return true;
            default:
               throw null;
         }
      }
   }

   private int Ԍ() {
      NetworkPlayerInfo var2 = null;
      int var3 = -1334024105 ^ -272065576;
      int var1 = oc5e549848f3.İ;

      while (true) {
         switch (var3) {
            case -1573447967:
               return 0;
            case 1605694351:
               if (oc69da1aa7f5.ő.getNetHandler() != null) {
                  var3 = 1096253987 ^ -272065576;
                  if (var1 == 0) {
                     break;
                  }
               }

               var3 = -1491705144 ^ -272065576;
               if (var1 == 0) {
                  break;
               }
            case -1365304837:
               if (oc69da1aa7f5.ő.thePlayer == null) {
                  var3 = -1491705144 ^ -272065576;
                  if (var1 == 0) {
                     break;
                  }
               }

               var3 = -1291477073 ^ -272065576;
               if (var1 == 0) {
                  break;
               }
            case 1556939895:
               var2 = oc69da1aa7f5.ő.getNetHandler().getPlayerInfo(oc69da1aa7f5.ő.thePlayer.getUniqueID());

               label44: {
                  label43: {
                     try {
                        if (var1 != 0) {
                           break label44;
                        }

                        if (var2 != null) {
                           break label43;
                        }
                     } catch (ocbde1165e4e var4) {
                        throw var4;
                     }

                     var3 = 1308593465 ^ -272065576;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var3 = -2080413532 ^ -272065576;
               }

               if (var1 == 0) {
                  break;
               }
            case 1222572304:
               return 0;
            case 1815606140:
               return Math.max(0, var2.getResponseTime());
            default:
               throw null;
         }
      }
   }

   public boolean Λ() {
      return false;
   }

   public boolean Ȣ(EntityPlayer var1) {
      return false;
   }

   private boolean B(boolean var1, boolean var2) {
      ocdd342096f8 var4 = null;
      int var5 = -303985199 ^ 689094560;
      int var3 = oc5e549848f3.İ;

      while (true) {
         label199:
         while (true) {
            label195:
            while (true) {
               label193:
               while (true) {
                  label189:
                  while (true) {
                     switch (var5) {
                        case -1550909449:
                           return false;
                        case -1014240233:
                           return true;
                        case -990694799:
                           break label195;
                        case -319573780:
                           int var15;
                           label138: {
                              label137: {
                                 try {
                                    var15 = var2;
                                    if (var3 != 0) {
                                       break label138;
                                    }

                                    if (var2 != 0) {
                                       break label137;
                                    }
                                 } catch (ocbde1165e4e var9) {
                                    throw var9;
                                 }

                                 var5 = -1969471401 ^ 689094560;
                                 if (var3 == 0) {
                                    continue;
                                 }
                              }

                              var15 = -359050313 ^ 689094560;
                           }

                           var5 = var15;
                           if (var3 != 0) {
                              break label199;
                           }
                           continue;
                        case -143328776:
                           break;
                        case -41372931:
                           break label189;
                        case 244371833:
                           break label199;
                        case 493670649:
                           return false;
                        case 534155310:
                           var4 = oc9755810e45.ÿ;

                           label114: {
                              label113: {
                                 try {
                                    if (var3 != 0) {
                                       break label114;
                                    }

                                    if (var4 == null) {
                                       break label113;
                                    }
                                 } catch (ocbde1165e4e var7) {
                                    throw var7;
                                 }

                                 var5 = -563722664 ^ 689094560;
                                 if (var3 == 0) {
                                    continue;
                                 }
                              }

                              var5 = 323813079 ^ 689094560;
                           }

                           if (var3 != 0) {
                              return true;
                           }
                           continue;
                        case 781378830:
                           int var10000;
                           label172: {
                              label171: {
                                 try {
                                    var10000 = var1;
                                    if (var3 != 0) {
                                       break label172;
                                    }

                                    if (var1 != 0) {
                                       break label171;
                                    }
                                 } catch (ocbde1165e4e var12) {
                                    throw var12;
                                 }

                                 var5 = 880701273 ^ 689094560;
                                 if (var3 == 0) {
                                    continue;
                                 }
                              }

                              var10000 = 662859481 ^ 689094560;
                           }

                           var5 = var10000;
                           if (var3 == 0) {
                              continue;
                           }
                        case 440180108:
                           int var13;
                           label162: {
                              label161: {
                                 try {
                                    var13 = this.с.ǭ();
                                    if (var3 != 0) {
                                       break label162;
                                    }

                                    if (var13 == 0) {
                                       break label161;
                                    }
                                 } catch (ocbde1165e4e var11) {
                                    throw var11;
                                 }

                                 var5 = 125852334 ^ 689094560;
                                 if (var3 == 0) {
                                    continue;
                                 }
                              }

                              var13 = 662859481 ^ 689094560;
                           }

                           var5 = var13;
                           if (var3 == 0) {
                              continue;
                           }
                           break;
                        case 979255671:
                           return false;
                        case 1123476076:
                           break label193;
                        default:
                           throw null;
                     }

                     int var14;
                     label152: {
                        label151: {
                           try {
                              var14 = var4.z$3rzb3dil7uydr();
                              if (var3 != 0) {
                                 break label152;
                              }

                              if (var14 == 0) {
                                 break label151;
                              }
                           } catch (ocbde1165e4e var10) {
                              throw var10;
                           }

                           var5 = -728101539 ^ 689094560;
                           if (var3 == 0) {
                              continue;
                           }
                        }

                        var14 = 323813079 ^ 689094560;
                     }

                     var5 = var14;
                     if (var3 != 0) {
                        break;
                     }
                  }

                  if (ocdd342096f8.f == null) {
                     var5 = 1810128332 ^ 689094560;
                     if (var3 == 0) {
                        continue;
                     }
                  }

                  var5 = 858661420 ^ 689094560;
                  if (var3 != 0) {
                     break;
                  }
               }

               if (ocdd342096f8.ѐ == null) {
                  var5 = 323813079 ^ 689094560;
                  if (var3 == 0) {
                     continue;
                  }
               }

               var5 = 858661420 ^ 689094560;
               if (var3 != 0) {
                  break;
               }
            }

            int var17;
            label124: {
               label123: {
                  try {
                     var17 = this.Ѥ.ǭ();
                     if (var3 != 0) {
                        break label124;
                     }

                     if (var17 == 0) {
                        break label123;
                     }
                  } catch (ocbde1165e4e var8) {
                     throw var8;
                  }

                  var5 = 918826894 ^ 689094560;
                  if (var3 == 0) {
                     continue;
                  }
               }

               var17 = 858661420 ^ 689094560;
            }

            var5 = var17;
            if (var3 != 0) {
               return false;
            }
         }

         int var16;
         label105: {
            label104: {
               try {
                  var16 = this.ӕ.ǭ();
                  if (var3 != 0) {
                     break label105;
                  }

                  if (var16 == 0) {
                     break label104;
                  }
               } catch (ocbde1165e4e var6) {
                  throw var6;
               }

               var5 = -975106228 ^ 689094560;
               if (var3 == 0) {
                  continue;
               }
            }

            var16 = -359050313 ^ 689094560;
         }

         var5 = var16;
         if (var3 != 0) {
            return false;
         }
      }
   }

   private EntityPlayer Ō(boolean param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: getstatic x/oc9755810e45.ÿ Lx/ocdd342096f8;
      // 06: astore 3
      // 07: istore 2
      // 08: aload 3
      // 09: iload 2
      // 0a: ifne 1d
      // 0d: ifnull 4a
      // 10: goto 14
      // 13: athrow
      // 14: aload 3
      // 15: iload 2
      // 16: ifne 28
      // 19: goto 1d
      // 1c: athrow
      // 1d: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 20: ifeq 4a
      // 23: aload 3
      // 24: goto 28
      // 27: athrow
      // 28: invokevirtual x/ocdd342096f8.љ ()Z
      // 2b: iload 2
      // 2c: ifne 47
      // 2f: ifeq 46
      // 32: goto 36
      // 35: athrow
      // 36: iload 1
      // 37: iload 2
      // 38: ifne 47
      // 3b: goto 3f
      // 3e: athrow
      // 3f: ifeq 4a
      // 42: goto 46
      // 45: athrow
      // 46: bipush 1
      // 47: goto 4b
      // 4a: bipush 0
      // 4b: istore 4
      // 4d: iload 4
      // 4f: iload 2
      // 50: ifne 7a
      // 53: ifeq 6b
      // 56: goto 5a
      // 59: athrow
      // 5a: aload 3
      // 5b: aload 0
      // 5c: getfield x/oce3cc81daa8.Ə Lx/oca9cc61aada;
      // 5f: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 62: aload 0
      // 63: getfield x/oce3cc81daa8.з Z
      // 66: invokevirtual x/ocdd342096f8.Ȧ (DZ)Lnet/minecraft/entity/player/EntityPlayer;
      // 69: areturn
      // 6a: athrow
      // 6b: aload 0
      // 6c: iload 2
      // 6d: ifne 81
      // 70: getfield x/oce3cc81daa8.Ѥ Lx/occ2f8dff8d8;
      // 73: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 76: goto 7a
      // 79: athrow
      // 7a: ifeq 80
      // 7d: aconst_null
      // 7e: areturn
      // 7f: athrow
      // 80: aload 0
      // 81: getfield x/oce3cc81daa8.Ə Lx/oca9cc61aada;
      // 84: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 87: aload 0
      // 88: getfield x/oce3cc81daa8.Ə Lx/oca9cc61aada;
      // 8b: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 8e: dmul
      // 8f: aload 0
      // 90: getfield x/oce3cc81daa8.F Lx/occ2f8dff8d8;
      // 93: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 96: invokestatic x/oc5e08d6b90f.ß (DZ)Lnet/minecraft/entity/player/EntityPlayer;
      // 99: areturn
   }

   public void ҵ(oc6111f05032 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 2
      // 04: aload 0
      // 05: iload 2
      // 06: ifne 16
      // 09: invokevirtual x/oce3cc81daa8.Ϧ ()Z
      // 0c: ifeq 15
      // 0f: goto 13
      // 12: athrow
      // 13: return
      // 14: athrow
      // 15: aload 0
      // 16: getfield x/oce3cc81daa8.ʩ Lx/oc1957f41321;
      // 19: aload 1
      // 1a: invokedynamic test ()Ljava/util/function/Predicate; bsm=java/lang/invoke/LambdaMetafactory.metafactory (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; args=[ (Ljava/lang/Object;)Z, x/oce3cc81daa8.qrl59ujizwfoi (Lnet/minecraft/entity/player/EntityPlayer;)Z, (Lnet/minecraft/entity/player/EntityPlayer;)Z ]
      // 1f: invokevirtual x/oc1957f41321.ԍ (Lx/oc6111f05032;Ljava/util/function/Predicate;)V
      // 22: return
   }

   private EntityPlayer playerYI() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: aload 0
      // 01: getfield x/oce3cc81daa8.ʩ Lx/oc1957f41321;
      // 04: invokevirtual x/oc1957f41321.ϭ ()Lnet/minecraft/entity/player/EntityPlayer;
      // 07: astore 1
      // 08: aload 0
      // 09: getfield x/oce3cc81daa8.Ə Lx/oca9cc61aada;
      // 0c: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0f: d2f
      // 10: fstore 2
      // 11: aload 1
      // 12: ifnull 2d
      // 15: aload 0
      // 16: getfield x/oce3cc81daa8.ʩ Lx/oc1957f41321;
      // 19: invokevirtual x/oc1957f41321.Ĩ ()D
      // 1c: fload 2
      // 1d: fload 2
      // 1e: fmul
      // 1f: f2d
      // 20: dcmpg
      // 21: ifgt 2d
      // 24: goto 28
      // 27: athrow
      // 28: aload 1
      // 29: goto 2e
      // 2c: athrow
      // 2d: aconst_null
      // 2e: areturn
   }

   private boolean ȩ() {
      ItemStack var2 = null;
      int var3 = 0;
      int var1 = oc5e549848f3.İ;
      int var4 = 1576682460 ^ -1293629205;

      while (true) {
         label99:
         while (true) {
            switch (var4) {
               case -1247654880:
                  int var8;
                  label75: {
                     label74: {
                        try {
                           var8 = var3;
                           if (var1 != 0) {
                              break label75;
                           }

                           if (Integer.compareUnsigned(var3, -1293629189 ^ -1293629205) > 0) {
                              break label74;
                           }
                        } catch (ocbde1165e4e var6) {
                           throw var6;
                        }

                        var4 = -1359098997 ^ -1293629205;
                        if (var1 == 0) {
                           continue;
                        }
                     }

                     var8 = 162073789 ^ -1293629205;
                  }

                  var4 = var8;
                  if (var1 == 0) {
                     continue;
                  }
                  break label99;
               case -1152531370:
                  return false;
               case -283210953:
                  if (oc69da1aa7f5.ő.thePlayer == null) {
                     var4 = -496676304 ^ -1293629205;
                     if (var1 == 0) {
                        continue;
                     }
                  }

                  var4 = -1686466175 ^ -1293629205;
                  if (var1 != 0) {
                     return true;
                  }
                  continue;
               case 471401312:
                  int var10000;
                  label87: {
                     label86: {
                        try {
                           var10000 = -1293563192 ^ -1293629205;
                           if (var1 != 0) {
                              break label87;
                           }

                           if ((var10000 >>> (var3 & (-1293629196 ^ -1293629205)) & 1) == 0) {
                              break label86;
                           }
                        } catch (ocbde1165e4e var7) {
                           throw var7;
                        }

                        var4 = -1923454818 ^ -1293629205;
                        if (var1 == 0) {
                           continue;
                        }
                     }

                     var10000 = 162073789 ^ -1293629205;
                  }

                  var4 = var10000;
                  if (var1 == 0) {
                     continue;
                  }
               case 1948306375:
                  var3 = Item.getIdFromItem(var2.getItem()) - (-1293628960 ^ -1293629205);
                  var4 = 122062027 ^ -1293629205;
                  if (var1 == 0) {
                     continue;
                  }
                  break;
               case 634917575:
                  break label99;
               case 698243434:
                  break;
               case 1069457525:
                  return true;
               case 1350671067:
                  return false;
               default:
                  throw null;
            }

            var2 = oc69da1aa7f5.ő.thePlayer.getHeldItem();

            label61: {
               label60: {
                  try {
                     if (var1 != 0) {
                        break label61;
                     }

                     if (var2 != null) {
                        break label60;
                     }
                  } catch (ocbde1165e4e var5) {
                     throw var5;
                  }

                  var4 = -1757619668 ^ -1293629205;
                  if (var1 == 0) {
                     continue;
                  }
               }

               var4 = -960232660 ^ -1293629205;
            }

            if (var1 != 0) {
               return false;
            }
         }

         var3 = 1293628958 ^ -1293629205;
         var4 = 122062027 ^ -1293629205;
         if (var1 != 0) {
            return false;
         }
      }
   }

   private boolean ý() {
      int var2 = 0;
      int var3 = 0;
      int var4 = 432406530 ^ 378624268;
      int var1 = oc5e549848f3.İ;

      while (true) {
         switch (var4) {
            case -402922614:
               return false;
            case 349780092:
               return true;
            case 1135573251:
               int var10000;
               label52: {
                  label51: {
                     try {
                        var10000 = var2;
                        if (var1 != 0) {
                           break label52;
                        }

                        if (var2 != var3) {
                           break label51;
                        }
                     } catch (ocbde1165e4e var6) {
                        throw var6;
                     }

                     var4 = 38297968 ^ 378624268;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var10000 = -244663674 ^ 378624268;
               }

               var4 = var10000;
               if (var1 == 0) {
                  break;
               }
            case 257382670:
               var2 = oc69da1aa7f5.ő.thePlayer.hurtTime;
               int var8 = var1;
               var3 = Math.round((float)(this.ð.Ӂ() / 50.0));
               var3 = Math.max(1, Math.min(378624262 ^ 378624268, var3));

               label39: {
                  label38: {
                     try {
                        if (var8 != 0) {
                           break label39;
                        }

                        if (!this.Ԡ.ǭ()) {
                           break label38;
                        }
                     } catch (ocbde1165e4e var5) {
                        throw var5;
                     }

                     var4 = 1430134799 ^ 378624268;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var4 = 38297968 ^ 378624268;
               }

               if (var1 == 0) {
                  break;
               }

               return true;
            default:
               throw null;
         }
      }
   }

   private boolean ӥ() {
      int var1 = oc5e549848f3.İ;
      int var2 = -707228315 ^ -316910063;

      while (true) {
         label162:
         while (true) {
            label160:
            while (true) {
               label158:
               while (true) {
                  label156:
                  while (true) {
                     switch (var2) {
                        case -1805036036:
                           return false;
                        case -191790456:
                           break label162;
                        case -43154997:
                           return true;
                        case 60067872:
                           break label158;
                        case 329522293:
                           int var9;
                           label140: {
                              label139: {
                                 try {
                                    var9 = this.з;
                                    if (var1 != 0) {
                                       break label140;
                                    }

                                    if (!this.з) {
                                       break label139;
                                    }
                                 } catch (ocbde1165e4e var8) {
                                    throw var8;
                                 }

                                 var2 = -1770118273 ^ -316910063;
                                 if (var1 == 0) {
                                    continue;
                                 }
                              }

                              var9 = 2037711853 ^ -316910063;
                           }

                           var2 = var9;
                           if (var1 == 0) {
                              continue;
                           }
                        case 124265310:
                           int var10;
                           label130: {
                              label129: {
                                 try {
                                    var10 = oc7ab2161b9f.ө();
                                    if (var1 != 0) {
                                       break label130;
                                    }

                                    if (var10 == 0) {
                                       break label129;
                                    }
                                 } catch (ocbde1165e4e var7) {
                                    throw var7;
                                 }

                                 var2 = -100110428 ^ -316910063;
                                 if (var1 == 0) {
                                    continue;
                                 }
                              }

                              var10 = 2037711853 ^ -316910063;
                           }

                           var2 = var10;
                           if (var1 == 0) {
                              continue;
                           }
                        case 387201461:
                           break;
                        case 952425332:
                           break label156;
                        case 1797952372:
                           int var10000;
                           label117: {
                              label116: {
                                 try {
                                    var10000 = this.ȩ();
                                    if (var1 != 0) {
                                       break label117;
                                    }

                                    if (var10000 == 0) {
                                       break label116;
                                    }
                                 } catch (ocbde1165e4e var6) {
                                    throw var6;
                                 }

                                 var2 = 428725401 ^ -316910063;
                                 if (var1 == 0) {
                                    continue;
                                 }
                              }

                              var10000 = 2037711853 ^ -316910063;
                           }

                           var2 = var10000;
                           if (var1 != 0) {
                              break label158;
                           }
                           continue;
                        case 2070050158:
                           break label160;
                        default:
                           throw null;
                     }

                     if (oc69da1aa7f5.ő.currentScreen == null) {
                        var2 = 275896282 ^ -316910063;
                        if (var1 == 0) {
                           continue;
                        }
                     }

                     var2 = 2037711853 ^ -316910063;
                     if (var1 != 0) {
                        break;
                     }
                  }

                  int var11;
                  label108: {
                     label107: {
                        try {
                           var11 = this.z$3rzb3dil7uydr();
                           if (var1 != 0) {
                              break label108;
                           }

                           if (var11 == 0) {
                              break label107;
                           }
                        } catch (ocbde1165e4e var5) {
                           throw var5;
                        }

                        var2 = -21476764 ^ -316910063;
                        if (var1 == 0) {
                           continue;
                        }
                     }

                     var11 = 2037711853 ^ -316910063;
                  }

                  var2 = var11;
                  if (var1 != 0) {
                     break label160;
                  }
               }

               int var13;
               label95: {
                  label94: {
                     try {
                        var13 = this.Ƴ();
                        if (var1 != 0) {
                           break label95;
                        }

                        if (var13 == 0) {
                           break label94;
                        }
                     } catch (ocbde1165e4e var4) {
                        throw var4;
                     }

                     var2 = -2043230875 ^ -316910063;
                     if (var1 == 0) {
                        continue;
                     }
                  }

                  var13 = -361466545 ^ -316910063;
               }

               var2 = var13;
               if (var1 != 0) {
                  return false;
               }
            }

            int var12;
            label86: {
               label85: {
                  try {
                     var12 = oc7ab2161b9f.Ð();
                     if (var1 != 0) {
                        break label86;
                     }

                     if (var12 == 0) {
                        break label85;
                     }
                  } catch (ocbde1165e4e var3) {
                     throw var3;
                  }

                  var2 = -293026255 ^ -316910063;
                  if (var1 == 0) {
                     continue;
                  }
               }

               var12 = 2037711853 ^ -316910063;
            }

            var2 = var12;
            if (var1 != 0) {
               break;
            }
         }

         var2 = -100110428 ^ -316910063;
      }
   }

   private void ɒ(int param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 2
      // 04: aload 0
      // 05: invokevirtual x/oce3cc81daa8.Ƴ ()Z
      // 08: iload 2
      // 09: ifne 25
      // 0c: ifeq 22
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: invokevirtual x/oce3cc81daa8.ȩ ()Z
      // 17: ifeq 30
      // 1a: goto 1e
      // 1d: athrow
      // 1e: goto 31
      // 21: athrow
      // 22: invokestatic x/oc7ab2161b9f.ө ()Z
      // 25: iload 2
      // 26: ifne 3d
      // 29: ifne 31
      // 2c: goto 30
      // 2f: athrow
      // 30: return
      // 31: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 34: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 37: getfield net/minecraft/client/settings/GameSettings.keyBindUseItem Lnet/minecraft/client/settings/KeyBinding;
      // 3a: invokevirtual net/minecraft/client/settings/KeyBinding.getKeyCode ()I
      // 3d: istore 3
      // 3e: iload 2
      // 3f: iload 3
      // 40: bipush 1
      // 41: invokestatic net/minecraft/client/settings/KeyBinding.setKeyBindState (IZ)V
      // 44: ifne 68
      // 47: aload 0
      // 48: invokevirtual x/oce3cc81daa8.Ĵ ()Z
      // 4b: ifne 5a
      // 4e: goto 52
      // 51: athrow
      // 52: iload 3
      // 53: invokestatic net/minecraft/client/settings/KeyBinding.onTick (I)V
      // 56: goto 5a
      // 59: athrow
      // 5a: aload 0
      // 5b: bipush 1
      // 5c: putfield x/oce3cc81daa8.a Z
      // 5f: aload 0
      // 60: iload 1
      // 61: putfield x/oce3cc81daa8.Ȁ I
      // 64: aload 0
      // 65: invokevirtual x/oce3cc81daa8.Ƚ ()V
      // 68: return
   }

   private void ˣ(boolean param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 2
      // 04: aload 0
      // 05: iload 2
      // 06: ifne 2b
      // 09: invokevirtual x/oce3cc81daa8.Ƴ ()Z
      // 0c: ifne 26
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: iload 2
      // 15: ifne 80
      // 18: goto 1c
      // 1b: athrow
      // 1c: getfield x/oce3cc81daa8.ӛ I
      // 1f: ifne 7f
      // 22: goto 26
      // 25: athrow
      // 26: aload 0
      // 27: goto 2b
      // 2a: athrow
      // 2b: getfield x/oce3cc81daa8.a Z
      // 2e: iload 2
      // 2f: ifne 3a
      // 32: ifne 3d
      // 35: goto 39
      // 38: athrow
      // 39: iload 1
      // 3a: ifeq 7e
      // 3d: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 40: iload 2
      // 41: ifne 52
      // 44: goto 48
      // 47: athrow
      // 48: ifnull 74
      // 4b: goto 4f
      // 4e: athrow
      // 4f: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 52: iload 2
      // 53: ifne 67
      // 56: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 59: ifnull 74
      // 5c: goto 60
      // 5f: athrow
      // 60: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 63: goto 67
      // 66: athrow
      // 67: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 6a: getfield net/minecraft/client/settings/GameSettings.keyBindUseItem Lnet/minecraft/client/settings/KeyBinding;
      // 6d: invokevirtual net/minecraft/client/settings/KeyBinding.getKeyCode ()I
      // 70: bipush 0
      // 71: invokestatic net/minecraft/client/settings/KeyBinding.setKeyBindState (IZ)V
      // 74: aload 0
      // 75: bipush 0
      // 76: putfield x/oce3cc81daa8.a Z
      // 79: aload 0
      // 7a: bipush -1
      // 7b: putfield x/oce3cc81daa8.Ȁ I
      // 7e: return
      // 7f: aload 0
      // 80: getfield x/oce3cc81daa8.a Z
      // 83: iload 2
      // 84: ifne ab
      // 87: ifne 9f
      // 8a: goto 8e
      // 8d: athrow
      // 8e: iload 1
      // 8f: iload 2
      // 90: ifne ab
      // 93: goto 97
      // 96: athrow
      // 97: ifne 9f
      // 9a: goto 9e
      // 9d: athrow
      // 9e: return
      // 9f: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // a2: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // a5: getfield net/minecraft/client/settings/GameSettings.keyBindUseItem Lnet/minecraft/client/settings/KeyBinding;
      // a8: invokevirtual net/minecraft/client/settings/KeyBinding.getKeyCode ()I
      // ab: istore 3
      // ac: iload 3
      // ad: aload 0
      // ae: invokevirtual x/oce3cc81daa8.Ĵ ()Z
      // b1: iload 2
      // b2: ifne cc
      // b5: ifeq db
      // b8: goto bc
      // bb: athrow
      // bc: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // bf: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // c2: getfield net/minecraft/client/settings/GameSettings.keyBindUseItem Lnet/minecraft/client/settings/KeyBinding;
      // c5: invokestatic x/oc7ab2161b9f.ն (Lnet/minecraft/client/settings/KeyBinding;)Z
      // c8: goto cc
      // cb: athrow
      // cc: iload 2
      // cd: ifne d8
      // d0: ifeq db
      // d3: goto d7
      // d6: athrow
      // d7: bipush 1
      // d8: goto dc
      // db: bipush 0
      // dc: invokestatic net/minecraft/client/settings/KeyBinding.setKeyBindState (IZ)V
      // df: aload 0
      // e0: bipush 0
      // e1: putfield x/oce3cc81daa8.a Z
      // e4: aload 0
      // e5: bipush -1
      // e6: putfield x/oce3cc81daa8.Ȁ I
      // e9: aload 0
      // ea: lconst_0
      // eb: putfield x/oce3cc81daa8.ɍ J
      // ee: aload 0
      // ef: invokevirtual x/oce3cc81daa8.Ƚ ()V
      // f2: return
   }

   private boolean B() {
      double var2 = 0.0;
      int var4 = 128933003 ^ 1312114864;
      int var1 = oc5e549848f3.İ;

      while (true) {
         switch (var4) {
            case -1795192465:
               var2 = this.ū.Ӂ();

               label69: {
                  label68: {
                     try {
                        if (var1 != 0) {
                           break label69;
                        }

                        if (!(var2 <= 0.0)) {
                           break label68;
                        }
                     } catch (ocbde1165e4e var7) {
                        throw var7;
                     }

                     var4 = -1848868310 ^ 1312114864;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var4 = -1707110337 ^ 1312114864;
               }

               if (var1 == 0) {
                  break;
               }
            case -1049811579:
               return false;
            case -737486705:
               int var8;
               label51: {
                  label50: {
                     try {
                        double var9;
                        var8 = (var9 = var2 - 100.0) == 0.0 ? 0 : (var9 < 0.0 ? -1 : 1);
                        if (var1 != 0) {
                           break label51;
                        }

                        if (var8 < 0) {
                           break label50;
                        }
                     } catch (ocbde1165e4e var5) {
                        throw var5;
                     }

                     var4 = 551576318 ^ 1312114864;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var8 = -352079090 ^ 1312114864;
               }

               var4 = var8;
               if (var1 == 0) {
                  break;
               }
            case -537277798:
               return false;
            case 1234834491:
               int var10000;
               label60: {
                  label59: {
                     try {
                        var10000 = this.Ƴ();
                        if (var1 != 0) {
                           break label60;
                        }

                        if (var10000 != 0) {
                           break label59;
                        }
                     } catch (ocbde1165e4e var6) {
                        throw var6;
                     }

                     var4 = -1890030283 ^ 1312114864;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var10000 = -624246305 ^ 1312114864;
               }

               var4 = var10000;
               if (var1 == 0) {
                  break;
               }
            case -1523123266:
               return oca6eae151db.ő.Ϭ((float)(var2 / 100.0));
            case 1859463758:
               return true;
            default:
               throw null;
         }
      }
   }

   private void ɷ(int param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 2
      // 04: aload 0
      // 05: iload 2
      // 06: ifne 40
      // 09: getfield x/oce3cc81daa8.з Z
      // 0c: ifeq 15
      // 0f: goto 13
      // 12: athrow
      // 13: return
      // 14: athrow
      // 15: aload 0
      // 16: new x/oc3d1d10e2c1
      // 19: dup
      // 1a: getstatic x/oc2f60cd9d1e.Ս Ljava/util/Set;
      // 1d: new x/oc5b52533f96
      // 20: dup
      // 21: aload 0
      // 22: invokespecial x/oc5b52533f96.<init> (Lx/oc69da1aa7f5;)V
      // 25: invokespecial x/oc3d1d10e2c1.<init> (Ljava/util/Set;Lx/oc93821aed5f;)V
      // 28: putfield x/oce3cc81daa8.Ѧ Lx/oc3d1d10e2c1;
      // 2b: getstatic x/oc2cf3d80e17.Ȱ Lx/oc8da5ba227c;
      // 2e: aload 0
      // 2f: getfield x/oce3cc81daa8.Ѧ Lx/oc3d1d10e2c1;
      // 32: invokevirtual x/oc8da5ba227c.ʕ (Lx/oc3d1d10e2c1;)V
      // 35: aload 0
      // 36: bipush 1
      // 37: putfield x/oce3cc81daa8.з Z
      // 3a: aload 0
      // 3b: iload 1
      // 3c: putfield x/oce3cc81daa8.Ʉ I
      // 3f: aload 0
      // 40: invokevirtual x/oce3cc81daa8.Ƚ ()V
      // 43: return
   }

   private void ɝ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 29
      // 09: getfield x/oce3cc81daa8.з Z
      // 0c: ifne 28
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: iload 1
      // 15: ifne 29
      // 18: goto 1c
      // 1b: athrow
      // 1c: getfield x/oce3cc81daa8.Ѧ Lx/oc3d1d10e2c1;
      // 1f: ifnonnull 28
      // 22: goto 26
      // 25: athrow
      // 26: return
      // 27: athrow
      // 28: aload 0
      // 29: getfield x/oce3cc81daa8.Ѧ Lx/oc3d1d10e2c1;
      // 2c: astore 2
      // 2d: aload 0
      // 2e: aconst_null
      // 2f: putfield x/oce3cc81daa8.Ѧ Lx/oc3d1d10e2c1;
      // 32: aload 0
      // 33: bipush 0
      // 34: putfield x/oce3cc81daa8.з Z
      // 37: aload 0
      // 38: iload 1
      // 39: ifne 71
      // 3c: bipush -1
      // 3d: putfield x/oce3cc81daa8.Ʉ I
      // 40: aload 2
      // 41: ifnull 70
      // 44: goto 48
      // 47: athrow
      // 48: getstatic x/oc2cf3d80e17.Ȱ Lx/oc8da5ba227c;
      // 4b: iload 1
      // 4c: ifne 5d
      // 4f: goto 53
      // 52: athrow
      // 53: ifnull 65
      // 56: goto 5a
      // 59: athrow
      // 5a: getstatic x/oc2cf3d80e17.Ȱ Lx/oc8da5ba227c;
      // 5d: aload 2
      // 5e: invokevirtual x/oc8da5ba227c.ɭ (Lx/oc3d1d10e2c1;)V
      // 61: iload 1
      // 62: ifeq 70
      // 65: aload 2
      // 66: invokevirtual x/oc3d1d10e2c1.Ƞ ()Lx/oc93821aed5f;
      // 69: invokevirtual x/oc93821aed5f.å ()V
      // 6c: goto 70
      // 6f: athrow
      // 70: aload 0
      // 71: invokevirtual x/oce3cc81daa8.Ƚ ()V
      // 74: return
   }

   public boolean ń() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 53
      // 09: invokevirtual x/oce3cc81daa8.Ƴ ()Z
      // 0c: ifeq 52
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: iload 1
      // 15: ifne 2b
      // 18: goto 1c
      // 1b: athrow
      // 1c: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 1f: ifeq 50
      // 22: goto 26
      // 25: athrow
      // 26: aload 0
      // 27: goto 2b
      // 2a: athrow
      // 2b: getfield x/oce3cc81daa8.a Z
      // 2e: iload 1
      // 2f: ifne 4d
      // 32: ifne 4c
      // 35: goto 39
      // 38: athrow
      // 39: aload 0
      // 3a: getfield x/oce3cc81daa8.з Z
      // 3d: iload 1
      // 3e: ifne 4d
      // 41: goto 45
      // 44: athrow
      // 45: ifeq 50
      // 48: goto 4c
      // 4b: athrow
      // 4c: bipush 1
      // 4d: goto 51
      // 50: bipush 0
      // 51: ireturn
      // 52: aload 0
      // 53: iload 1
      // 54: ifne 66
      // 57: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 5a: ifeq ad
      // 5d: goto 61
      // 60: athrow
      // 61: aload 0
      // 62: goto 66
      // 65: athrow
      // 66: getfield x/oce3cc81daa8.a Z
      // 69: iload 1
      // 6a: ifne aa
      // 6d: ifne a5
      // 70: goto 74
      // 73: athrow
      // 74: aload 0
      // 75: getfield x/oce3cc81daa8.з Z
      // 78: iload 1
      // 79: ifne aa
      // 7c: goto 80
      // 7f: athrow
      // 80: ifne a5
      // 83: goto 87
      // 86: athrow
      // 87: aload 0
      // 88: getfield x/oce3cc81daa8.ӎ Z
      // 8b: iload 1
      // 8c: ifne aa
      // 8f: goto 93
      // 92: athrow
      // 93: ifne a5
      // 96: goto 9a
      // 99: athrow
      // 9a: aload 0
      // 9b: getfield x/oce3cc81daa8.Ѧ Lx/oc3d1d10e2c1;
      // 9e: ifnull ad
      // a1: goto a5
      // a4: athrow
      // a5: bipush 1
      // a6: goto aa
      // a9: athrow
      // aa: goto ae
      // ad: bipush 0
      // ae: ireturn
   }

   public boolean Ӿ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 18
      // 09: invokevirtual x/oce3cc81daa8.Ƴ ()Z
      // 0c: ifeq 4b
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: goto 18
      // 17: athrow
      // 18: invokevirtual x/oce3cc81daa8.ń ()Z
      // 1b: iload 1
      // 1c: ifne 29
      // 1f: ifeq 4b
      // 22: goto 26
      // 25: athrow
      // 26: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 29: iload 1
      // 2a: ifne 3c
      // 2d: ifeq 4b
      // 30: goto 34
      // 33: athrow
      // 34: aload 0
      // 35: invokevirtual x/oce3cc81daa8.ȩ ()Z
      // 38: goto 3c
      // 3b: athrow
      // 3c: iload 1
      // 3d: ifne 48
      // 40: ifeq 4b
      // 43: goto 47
      // 46: athrow
      // 47: bipush 1
      // 48: goto 4c
      // 4b: bipush 0
      // 4c: ireturn
   }

   public boolean х(EntityLivingBase var1) {
      return false;
   }

   public boolean Ƴ() {
      int var1 = oc5e549848f3.İ;

      try {
         int var10000 = (int)this.Ţ.Ӂ();
         if (var1 != 0) {
            return (boolean)var10000;
         }

         if (var10000 == 0) {
            return (boolean)1;
         }
      } catch (ocbde1165e4e var2) {
         throw var2;
      }

      return (boolean)0;
   }

   private boolean Ĵ() {
      int var1 = oc5e549848f3.İ;
      int var2 = -131680255 ^ -1240085455;

      while (true) {
         switch (var2) {
            case 1176465222:
               return true;
            case 1311994928:
               int var10000;
               label28: {
                  label27: {
                     try {
                        var10000 = (int)this.Ţ.Ӂ();
                        if (var1 != 0) {
                           break label28;
                        }

                        if (var10000 != 1) {
                           break label27;
                        }
                     } catch (ocbde1165e4e var3) {
                        throw var3;
                     }

                     var2 = -267738249 ^ -1240085455;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var10000 = -1595607103 ^ -1240085455;
               }

               var2 = var10000;
               if (var1 == 0) {
                  break;
               }
            case 384908272:
               return false;
            default:
               throw null;
         }
      }
   }

   public boolean å() {
      return this.a;
   }

   public EntityLivingBase ǿ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 1c
      // 09: invokevirtual x/oce3cc81daa8.Ƴ ()Z
      // 0c: ifeq 1b
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: invokevirtual x/oce3cc81daa8.Ƴ ()Lnet/minecraft/entity/player/EntityPlayer;
      // 17: goto 1f
      // 1a: athrow
      // 1b: aload 0
      // 1c: getfield x/oce3cc81daa8.Ε Lnet/minecraft/entity/EntityLivingBase;
      // 1f: areturn
   }

   private boolean t() {
      int var1 = oc5e549848f3.İ;
      int var2 = -478876433 ^ -1006130000;

      while (true) {
         switch (var2) {
            case -307403022:
               return true;
            case 661864543:
               int var10000;
               label29: {
                  label28: {
                     try {
                        var10000 = (int)this.Ţ.Ӂ();
                        if (var1 != 0) {
                           break label29;
                        }

                        if (var10000 != (-1006129998 ^ -1006130000)) {
                           break label28;
                        }
                     } catch (ocbde1165e4e var3) {
                        throw var3;
                     }

                     var2 = 699058754 ^ -1006130000;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var10000 = -19651707 ^ -1006130000;
               }

               var2 = var10000;
               break;
            case 986943285:
               return false;
            default:
               throw null;
         }
      }
   }

   private boolean տ() {
      MovingObjectPosition var2 = null;
      Entity var3 = null;
      int var1 = oc5e549848f3.İ;
      int var4 = -875271130 ^ 1724012821;

      while (true) {
         switch (var4) {
            case -1391053517:
               var2 = oc69da1aa7f5.ő.objectMouseOver;

               label90: {
                  try {
                     if (var1 != 0) {
                        break;
                     }

                     if (var2 != null) {
                        break label90;
                     }
                  } catch (ocbde1165e4e var7) {
                     throw var7;
                  }

                  var4 = -1126999886 ^ 1724012821;
                  if (var1 == 0) {
                     break;
                  }
               }

               var4 = 1840990123 ^ 1724012821;
               break;
            case -1382711529:
               int var10000;
               label84: {
                  label83: {
                     try {
                        var10000 = oca4f99d2d44.Λ(var3);
                        if (var1 != 0) {
                           break label84;
                        }

                        if (var10000 == 0) {
                           break label83;
                        }
                     } catch (ocbde1165e4e var6) {
                        throw var6;
                     }

                     var4 = 562859590 ^ 1724012821;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var10000 = 943173789 ^ 1724012821;
               }

               var4 = var10000;
               if (var1 == 0) {
                  break;
               }
            case 1196349267:
               return true;
            case -636419673:
               return false;
            case 192487102:
               if (var2.typeOfHit == MovingObjectType.BLOCK) {
                  var4 = 2082741243 ^ 1724012821;
                  if (var1 == 0) {
                     break;
                  }
               }

               var4 = 808973040 ^ 1724012821;
               if (var1 == 0) {
                  break;
               }
            case 451298030:
               return occb1ed1ed8f.Ր(var2);
            case 736923495:
               var3 = var2.entityHit;

               label74: {
                  label73: {
                     try {
                        if (var1 != 0) {
                           break label74;
                        }

                        if (!(var3 instanceof EntityPlayer)) {
                           break label73;
                        }
                     } catch (ocbde1165e4e var5) {
                        throw var5;
                     }

                     var4 = -883481086 ^ 1724012821;
                     if (var1 == 0) {
                        break;
                     }
                  }

                  var4 = 562859590 ^ 1724012821;
               }

               if (var1 == 0) {
                  break;
               }
            case 1593174408:
               return false;
            case 1458940901:
               if (var2.typeOfHit == MovingObjectType.ENTITY) {
                  var4 = -439269418 ^ 1724012821;
                  if (var1 == 0) {
                     break;
                  }
               }

               var4 = 2133769890 ^ 1724012821;
               if (var1 == 0) {
                  break;
               }
            case -2095898941:
               if (var2.entityHit == null) {
                  var4 = 2133769890 ^ 1724012821;
                  if (var1 == 0) {
                     break;
                  }
               }

               var4 = 1294915186 ^ 1724012821;
               if (var1 == 0) {
                  break;
               }
            case 434956215:
               return false;
            default:
               throw null;
         }
      }
   }

   private boolean Ϧ() {
      ocdd342096f8 var2 = null;
      byte var3 = 0;
      int var1 = oc5e549848f3.İ;
      int var4 = -712239536 ^ -1150942459;

      while (true) {
         label172:
         while (true) {
            label168:
            do {
               label166:
               while (true) {
                  label164:
                  while (true) {
                     label162:
                     while (true) {
                        label160:
                        while (true) {
                           label158:
                           while (true) {
                              switch (var4) {
                                 case -1509967720:
                                    break label172;
                                 case -792910625:
                                    break label168;
                                 case -56779058:
                                    return (boolean)var3;
                                 case -49424978:
                                    break;
                                 case 141833813:
                                    break label162;
                                 case 796221018:
                                    var3 = 1;
                                    var4 = 1809524698 ^ -1150942459;
                                    if (var1 != 0) {
                                       return (boolean)var3;
                                    }
                                    continue;
                                 case 946444214:
                                    break label160;
                                 case 1210422595:
                                    break label166;
                                 case 1261165557:
                                    break label164;
                                 case 1786646656:
                                    int var10000;
                                    label142: {
                                       label141: {
                                          try {
                                             var10000 = this.a;
                                             if (var1 != 0) {
                                                break label142;
                                             }

                                             if (this.a) {
                                                break label141;
                                             }
                                          } catch (ocbde1165e4e var9) {
                                             throw var9;
                                          }

                                          var4 = 513391517 ^ -1150942459;
                                          if (var1 == 0) {
                                             continue;
                                          }
                                       }

                                       var10000 = -213674426 ^ -1150942459;
                                    }

                                    var4 = var10000;
                                    if (var1 == 0) {
                                       continue;
                                    }
                                 case 16806160:
                                    if (var2.զ() != oc8df2d0340c.Ѐ) {
                                       var4 = -1810670241 ^ -1150942459;
                                       if (var1 == 0) {
                                          continue;
                                       }
                                    }

                                    var4 = 1181472427 ^ -1150942459;
                                    if (var1 == 0) {
                                       continue;
                                    }
                                    break;
                                 case 1860834645:
                                    break label158;
                                 default:
                                    throw null;
                              }

                              var3 = 0;
                              var4 = 1809524698 ^ -1150942459;
                              if (var1 != 0) {
                                 break;
                              }
                           }

                           var2 = oc9755810e45.ÿ;

                           label129: {
                              label128: {
                                 try {
                                    if (var1 != 0) {
                                       break label129;
                                    }

                                    if (var2 == null) {
                                       break label128;
                                    }
                                 } catch (ocbde1165e4e var8) {
                                    throw var8;
                                 }

                                 var4 = -2096130893 ^ -1150942459;
                                 if (var1 == 0) {
                                    continue;
                                 }
                              }

                              var4 = 1181472427 ^ -1150942459;
                           }

                           if (var1 != 0) {
                              break;
                           }
                        }

                        int var10;
                        label119: {
                           label118: {
                              try {
                                 var10 = var2.z$3rzb3dil7uydr();
                                 if (var1 != 0) {
                                    break label119;
                                 }

                                 if (var10 == 0) {
                                    break label118;
                                 }
                              } catch (ocbde1165e4e var7) {
                                 throw var7;
                              }

                              var4 = -263333648 ^ -1150942459;
                              if (var1 == 0) {
                                 continue;
                              }
                           }

                           var10 = 1181472427 ^ -1150942459;
                        }

                        var4 = var10;
                        if (var1 != 0) {
                           break;
                        }
                     }

                     if (this.Ѧ != null) {
                        var4 = -213674426 ^ -1150942459;
                        if (var1 == 0) {
                           continue;
                        }
                     }

                     var4 = 1207672267 ^ -1150942459;
                     if (var1 != 0) {
                        break;
                     }
                  }

                  if (var2.Ǒ() != null) {
                     var4 = -1167691243 ^ -1150942459;
                     if (var1 == 0) {
                        continue;
                     }
                  }

                  var4 = 1181472427 ^ -1150942459;
                  if (var1 != 0) {
                     break;
                  }
               }

               this.ǟ(true);
               var4 = 1207672267 ^ -1150942459;
            } while (var1 == 0);

            int var11;
            label103: {
               label102: {
                  try {
                     var11 = var3;
                     if (var1 != 0) {
                        break label103;
                     }

                     if (var3 == 0) {
                        break label102;
                     }
                  } catch (ocbde1165e4e var6) {
                     throw var6;
                  }

                  var4 = -786951291 ^ -1150942459;
                  if (var1 == 0) {
                     continue;
                  }
               }

               var11 = 1207672267 ^ -1150942459;
            }

            var4 = var11;
            if (var1 != 0) {
               break;
            }
         }

         int var12;
         label94: {
            label93: {
               try {
                  var12 = this.з;
                  if (var1 != 0) {
                     break label94;
                  }

                  if (this.з) {
                     break label93;
                  }
               } catch (ocbde1165e4e var5) {
                  throw var5;
               }

               var4 = -1290652336 ^ -1150942459;
               if (var1 == 0) {
                  continue;
               }
            }

            var12 = -213674426 ^ -1150942459;
         }

         var4 = var12;
      }
   }

   private void Ƚ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 000: getstatic x/oc5e549848f3.İ I
      // 003: istore 1
      // 004: aload 0
      // 005: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 008: iload 1
      // 009: ifne 08d
      // 00c: ifeq 085
      // 00f: goto 013
      // 012: athrow
      // 013: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 016: iload 1
      // 017: ifne 08d
      // 01a: goto 01e
      // 01d: athrow
      // 01e: ifeq 085
      // 021: goto 025
      // 024: athrow
      // 025: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 028: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 02b: ifnonnull 085
      // 02e: goto 032
      // 031: athrow
      // 032: aload 0
      // 033: invokevirtual x/oce3cc81daa8.Ƴ ()Z
      // 036: iload 1
      // 037: ifne 057
      // 03a: goto 03e
      // 03d: athrow
      // 03e: ifeq 054
      // 041: goto 045
      // 044: athrow
      // 045: aload 0
      // 046: invokevirtual x/oce3cc81daa8.ȩ ()Z
      // 049: ifne 062
      // 04c: goto 050
      // 04f: athrow
      // 050: goto 085
      // 053: athrow
      // 054: invokestatic x/oc7ab2161b9f.ө ()Z
      // 057: iload 1
      // 058: ifne 08d
      // 05b: ifeq 085
      // 05e: goto 062
      // 061: athrow
      // 062: getstatic x/oc9755810e45.ϔ Lx/oc8edd24b1ed;
      // 065: iload 1
      // 066: ifne 077
      // 069: goto 06d
      // 06c: athrow
      // 06d: ifnull 08f
      // 070: goto 074
      // 073: athrow
      // 074: getstatic x/oc9755810e45.ϔ Lx/oc8edd24b1ed;
      // 077: invokevirtual x/oc8edd24b1ed.Ƴ ()Z
      // 07a: iload 1
      // 07b: ifne 09b
      // 07e: ifeq 08f
      // 081: goto 085
      // 084: athrow
      // 085: bipush 0
      // 086: invokestatic x/ReflectionUtils.setItemInUse (Z)Z
      // 089: goto 08d
      // 08c: athrow
      // 08d: pop
      // 08e: return
      // 08f: aload 0
      // 090: iload 1
      // 091: ifne 0a7
      // 094: invokevirtual x/oce3cc81daa8.Ƴ ()Z
      // 097: goto 09b
      // 09a: athrow
      // 09b: ifeq 0a6
      // 09e: aload 0
      // 09f: invokevirtual x/oce3cc81daa8.Ƴ ()Lnet/minecraft/entity/player/EntityPlayer;
      // 0a2: goto 0aa
      // 0a5: athrow
      // 0a6: aload 0
      // 0a7: getfield x/oce3cc81daa8.Ε Lnet/minecraft/entity/EntityLivingBase;
      // 0aa: astore 2
      // 0ab: getstatic x/oc9755810e45.ÿ Lx/ocdd342096f8;
      // 0ae: iload 1
      // 0af: ifne 0c4
      // 0b2: ifnull 0e4
      // 0b5: goto 0b9
      // 0b8: athrow
      // 0b9: getstatic x/oc9755810e45.ÿ Lx/ocdd342096f8;
      // 0bc: iload 1
      // 0bd: ifne 0d1
      // 0c0: goto 0c4
      // 0c3: athrow
      // 0c4: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 0c7: ifeq 0e4
      // 0ca: getstatic x/oc9755810e45.ÿ Lx/ocdd342096f8;
      // 0cd: goto 0d1
      // 0d0: athrow
      // 0d1: invokevirtual x/ocdd342096f8.љ ()Z
      // 0d4: ifne 0e4
      // 0d7: aload 2
      // 0d8: ifnull 0e4
      // 0db: goto 0df
      // 0de: athrow
      // 0df: bipush 1
      // 0e0: goto 0e5
      // 0e3: athrow
      // 0e4: bipush 0
      // 0e5: istore 3
      // 0e6: aload 0
      // 0e7: bipush 0
      // 0e8: iload 1
      // 0e9: ifne 107
      // 0ec: invokestatic org/lwjgl/input/Mouse.isButtonDown (I)Z
      // 0ef: ifne 106
      // 0f2: goto 0f6
      // 0f5: athrow
      // 0f6: iload 3
      // 0f7: iload 1
      // 0f8: ifne 107
      // 0fb: goto 0ff
      // 0fe: athrow
      // 0ff: ifeq 10a
      // 102: goto 106
      // 105: athrow
      // 106: bipush 1
      // 107: goto 10b
      // 10a: bipush 0
      // 10b: bipush 1
      // 10c: invokestatic org/lwjgl/input/Mouse.isButtonDown (I)Z
      // 10f: invokevirtual x/oce3cc81daa8.B (ZZ)Z
      // 112: istore 4
      // 114: aload 0
      // 115: iload 1
      // 116: ifne 128
      // 119: invokevirtual x/oce3cc81daa8.Ĵ ()Z
      // 11c: ifne 150
      // 11f: goto 123
      // 122: athrow
      // 123: aload 0
      // 124: goto 128
      // 127: athrow
      // 128: getfield x/oce3cc81daa8.Ԡ Lx/occ2f8dff8d8;
      // 12b: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 12e: ifne 150
      // 131: aload 2
      // 132: ifnull 150
      // 135: goto 139
      // 138: athrow
      // 139: aload 0
      // 13a: getfield x/oce3cc81daa8.ϩ Z
      // 13d: iload 1
      // 13e: ifne 14d
      // 141: goto 145
      // 144: athrow
      // 145: ifne 150
      // 148: goto 14c
      // 14b: athrow
      // 14c: bipush 1
      // 14d: goto 151
      // 150: bipush 0
      // 151: istore 5
      // 153: iload 4
      // 155: iload 1
      // 156: ifne 162
      // 159: ifeq 197
      // 15c: goto 160
      // 15f: athrow
      // 160: iload 5
      // 162: iload 1
      // 163: ifne 194
      // 166: ifne 193
      // 169: goto 16d
      // 16c: athrow
      // 16d: aload 0
      // 16e: getfield x/oce3cc81daa8.a Z
      // 171: iload 1
      // 172: ifne 194
      // 175: goto 179
      // 178: athrow
      // 179: ifne 193
      // 17c: goto 180
      // 17f: athrow
      // 180: aload 0
      // 181: getfield x/oce3cc81daa8.з Z
      // 184: iload 1
      // 185: ifne 194
      // 188: goto 18c
      // 18b: athrow
      // 18c: ifeq 197
      // 18f: goto 193
      // 192: athrow
      // 193: bipush 1
      // 194: goto 198
      // 197: bipush 0
      // 198: istore 6
      // 19a: aload 0
      // 19b: invokevirtual x/oce3cc81daa8.Ƴ ()Z
      // 19e: iload 1
      // 19f: ifne 1cc
      // 1a2: ifeq 1c7
      // 1a5: goto 1a9
      // 1a8: athrow
      // 1a9: aload 0
      // 1aa: getfield x/oce3cc81daa8.ԝ Lx/occ2f8dff8d8;
      // 1ad: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 1b0: iload 1
      // 1b1: ifne 1cc
      // 1b4: goto 1b8
      // 1b7: athrow
      // 1b8: ifeq 1c7
      // 1bb: goto 1bf
      // 1be: athrow
      // 1bf: aload 2
      // 1c0: ifnull 1cf
      // 1c3: goto 1c7
      // 1c6: athrow
      // 1c7: bipush 1
      // 1c8: goto 1cc
      // 1cb: athrow
      // 1cc: goto 1d0
      // 1cf: bipush 0
      // 1d0: istore 7
      // 1d2: aload 0
      // 1d3: getfield x/oce3cc81daa8.Ҩ Lx/occ2f8dff8d8;
      // 1d6: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 1d9: iload 1
      // 1da: ifne 1e6
      // 1dd: ifeq 202
      // 1e0: goto 1e4
      // 1e3: athrow
      // 1e4: iload 6
      // 1e6: iload 1
      // 1e7: ifne 1f3
      // 1ea: ifeq 202
      // 1ed: goto 1f1
      // 1f0: athrow
      // 1f1: iload 7
      // 1f3: iload 1
      // 1f4: ifne 1ff
      // 1f7: ifeq 202
      // 1fa: goto 1fe
      // 1fd: athrow
      // 1fe: bipush 1
      // 1ff: goto 203
      // 202: bipush 0
      // 203: invokestatic x/ReflectionUtils.setItemInUse (Z)Z
      // 206: pop
      // 207: return
   }

   private void Ξ(boolean param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 2
      // 04: aload 0
      // 05: iload 2
      // 06: ifne d8
      // 09: invokevirtual x/oce3cc81daa8.ɝ ()V
      // 0c: aload 0
      // 0d: aconst_null
      // 0e: putfield x/oce3cc81daa8.Ε Lnet/minecraft/entity/EntityLivingBase;
      // 11: bipush 0
      // 12: invokestatic x/ReflectionUtils.setItemInUse (Z)Z
      // 15: pop
      // 16: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 19: ifnull ce
      // 1c: goto 20
      // 1f: athrow
      // 20: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 23: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 26: ifnull ce
      // 29: goto 2d
      // 2c: athrow
      // 2d: aload 0
      // 2e: iload 2
      // 2f: ifne 6a
      // 32: goto 36
      // 35: athrow
      // 36: getfield x/oce3cc81daa8.a Z
      // 39: ifne 50
      // 3c: goto 40
      // 3f: athrow
      // 40: iload 1
      // 41: iload 2
      // 42: ifne 7c
      // 45: goto 49
      // 48: athrow
      // 49: ifeq 6e
      // 4c: goto 50
      // 4f: athrow
      // 50: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 53: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 56: getfield net/minecraft/client/settings/GameSettings.keyBindUseItem Lnet/minecraft/client/settings/KeyBinding;
      // 59: invokevirtual net/minecraft/client/settings/KeyBinding.getKeyCode ()I
      // 5c: bipush 0
      // 5d: invokestatic net/minecraft/client/settings/KeyBinding.setKeyBindState (IZ)V
      // 60: aload 0
      // 61: bipush 0
      // 62: putfield x/oce3cc81daa8.a Z
      // 65: aload 0
      // 66: goto 6a
      // 69: athrow
      // 6a: bipush -1
      // 6b: putfield x/oce3cc81daa8.Ȁ I
      // 6e: aload 0
      // 6f: iload 2
      // 70: ifne c6
      // 73: bipush 0
      // 74: putfield x/oce3cc81daa8.Ƀ Z
      // 77: iload 1
      // 78: goto 7c
      // 7b: athrow
      // 7c: ifeq c5
      // 7f: invokestatic org/lwjgl/input/Mouse.isCreated ()Z
      // 82: iload 2
      // 83: ifne 99
      // 86: goto 8a
      // 89: athrow
      // 8a: ifeq c5
      // 8d: goto 91
      // 90: athrow
      // 91: bipush 1
      // 92: invokestatic org/lwjgl/input/Mouse.isButtonDown (I)Z
      // 95: goto 99
      // 98: athrow
      // 99: ifeq c5
      // 9c: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 9f: iload 2
      // a0: ifne b8
      // a3: goto a7
      // a6: athrow
      // a7: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // aa: ifnonnull c5
      // ad: goto b1
      // b0: athrow
      // b1: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // b4: goto b8
      // b7: athrow
      // b8: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // bb: getfield net/minecraft/client/settings/GameSettings.keyBindUseItem Lnet/minecraft/client/settings/KeyBinding;
      // be: invokevirtual net/minecraft/client/settings/KeyBinding.getKeyCode ()I
      // c1: bipush 1
      // c2: invokestatic net/minecraft/client/settings/KeyBinding.setKeyBindState (IZ)V
      // c5: aload 0
      // c6: bipush 0
      // c7: putfield x/oce3cc81daa8.Η I
      // ca: iload 2
      // cb: ifeq dc
      // ce: aload 0
      // cf: bipush 0
      // d0: putfield x/oce3cc81daa8.a Z
      // d3: aload 0
      // d4: goto d8
      // d7: athrow
      // d8: bipush 0
      // d9: putfield x/oce3cc81daa8.Ƀ Z
      // dc: return
   }

   private void ǟ(boolean param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 2
      // 04: aload 0
      // 05: iload 2
      // 06: ifne 3e
      // 09: getfield x/oce3cc81daa8.ӛ I
      // 0c: ifeq 39
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: iload 2
      // 15: ifne 60
      // 18: goto 1c
      // 1b: athrow
      // 1c: getfield x/oce3cc81daa8.ӛ I
      // 1f: ifge 43
      // 22: goto 26
      // 25: athrow
      // 26: aload 0
      // 27: iload 2
      // 28: ifne 60
      // 2b: goto 2f
      // 2e: athrow
      // 2f: invokevirtual x/oce3cc81daa8.Ƴ ()Z
      // 32: ifeq 43
      // 35: goto 39
      // 38: athrow
      // 39: aload 0
      // 3a: goto 3e
      // 3d: athrow
      // 3e: iload 1
      // 3f: invokevirtual x/oce3cc81daa8.Ξ (Z)V
      // 42: return
      // 43: aload 0
      // 44: invokevirtual x/oce3cc81daa8.ŉ ()V
      // 47: aload 0
      // 48: iload 1
      // 49: invokevirtual x/oce3cc81daa8.ˣ (Z)V
      // 4c: aload 0
      // 4d: invokevirtual x/oce3cc81daa8.ɝ ()V
      // 50: aload 0
      // 51: bipush 0
      // 52: putfield x/oce3cc81daa8.Ƀ Z
      // 55: aload 0
      // 56: bipush 0
      // 57: putfield x/oce3cc81daa8.ϩ Z
      // 5a: aload 0
      // 5b: aconst_null
      // 5c: putfield x/oce3cc81daa8.Ε Lnet/minecraft/entity/EntityLivingBase;
      // 5f: aload 0
      // 60: bipush 0
      // 61: putfield x/oce3cc81daa8.Η I
      // 64: bipush 0
      // 65: iload 2
      // 66: ifne 7c
      // 69: invokestatic x/ReflectionUtils.setItemInUse (Z)Z
      // 6c: pop
      // 6d: iload 1
      // 6e: ifeq bb
      // 71: goto 75
      // 74: athrow
      // 75: invokestatic org/lwjgl/input/Mouse.isCreated ()Z
      // 78: goto 7c
      // 7b: athrow
      // 7c: iload 2
      // 7d: ifne 8f
      // 80: ifeq bb
      // 83: goto 87
      // 86: athrow
      // 87: bipush 1
      // 88: invokestatic org/lwjgl/input/Mouse.isButtonDown (I)Z
      // 8b: goto 8f
      // 8e: athrow
      // 8f: ifeq bb
      // 92: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 95: iload 2
      // 96: ifne ae
      // 99: goto 9d
      // 9c: athrow
      // 9d: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // a0: ifnonnull bb
      // a3: goto a7
      // a6: athrow
      // a7: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // aa: goto ae
      // ad: athrow
      // ae: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // b1: getfield net/minecraft/client/settings/GameSettings.keyBindUseItem Lnet/minecraft/client/settings/KeyBinding;
      // b4: invokevirtual net/minecraft/client/settings/KeyBinding.getKeyCode ()I
      // b7: bipush 1
      // b8: invokestatic net/minecraft/client/settings/KeyBinding.setKeyBindState (IZ)V
      // bb: return
   }

   private void ŉ() {
      long var1 = System.currentTimeMillis();
      this.Ǳ = var1;
      this.ş = var1 - (-7590574256511982209L ^ -7590574256511982153L);
      this.ɍ = 0L;
      this.ʚ = 0L;
   }

   private void Ť(Packet<?> param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oc5e549848f3.İ I
      // 03: istore 2
      // 04: aload 0
      // 05: invokevirtual x/oce3cc81daa8.Ƴ ()Z
      // 08: iload 2
      // 09: ifne 33
      // 0c: ifne 27
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: invokevirtual x/oce3cc81daa8.t ()Z
      // 17: iload 2
      // 18: ifne 33
      // 1b: goto 1f
      // 1e: athrow
      // 1f: ifne 27
      // 22: goto 26
      // 25: athrow
      // 26: return
      // 27: aload 1
      // 28: iload 2
      // 29: ifne 3e
      // 2c: instanceof net/minecraft/network/play/client/C08PacketPlayerBlockPlacement
      // 2f: goto 33
      // 32: athrow
      // 33: ifeq 3d
      // 36: aload 0
      // 37: bipush 1
      // 38: putfield x/oce3cc81daa8.ӎ Z
      // 3b: return
      // 3c: athrow
      // 3d: aload 1
      // 3e: iload 2
      // 3f: ifne 51
      // 42: instanceof net/minecraft/network/play/client/C07PacketPlayerDigging
      // 45: ifeq 66
      // 48: goto 4c
      // 4b: athrow
      // 4c: aload 1
      // 4d: goto 51
      // 50: athrow
      // 51: checkcast net/minecraft/network/play/client/C07PacketPlayerDigging
      // 54: invokevirtual net/minecraft/network/play/client/C07PacketPlayerDigging.getStatus ()Lnet/minecraft/network/play/client/C07PacketPlayerDigging$Action;
      // 57: getstatic net/minecraft/network/play/client/C07PacketPlayerDigging$Action.RELEASE_USE_ITEM Lnet/minecraft/network/play/client/C07PacketPlayerDigging$Action;
      // 5a: if_acmpne 66
      // 5d: aload 0
      // 5e: bipush 0
      // 5f: putfield x/oce3cc81daa8.ӎ Z
      // 62: goto 66
      // 65: athrow
      // 66: return
   }

   static {
      String[] var10000 = new String[-182748645 ^ -182748648];
      var10000[0] = "Normal";
      var10000[1] = "Smart";
      var10000[-182748646 ^ -182748648] = "Vanilla";
      Ǐ = var10000;
   }
}
