package x;

public class oc738c750564 extends oc69da1aa7f5 {
   private final occ2f8dff8d8 ո;
   private final occ2f8dff8d8 ƚ;
   private float ō;
   private float Ɗ;
   public static int ǧ;

   public oc738c750564() {
      super("InstantStop", oce4cea752dd.ҕ, 0);
      this.ą("Stops horizontal movement when you release keys.");
      this.ʌ(this.ո = new occ2f8dff8d8("Only on ground", true));
      this.ʌ(this.ƚ = new occ2f8dff8d8("Disable when flying", true));
   }

   @Override
   public void onDisable() {
      this.ō = 0.0F;
      this.Ɗ = 0.0F;
   }

   @oc66fa4f2195
   public void Ѐ(oc70db705765 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: bipush 0
      // 001: istore 2
      // 002: aload 0
      // 003: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 006: iload 2
      // 007: ifne 014
      // 00a: ifeq 017
      // 00d: goto 011
      // 010: athrow
      // 011: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 014: ifne 018
      // 017: return
      // 018: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 01b: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 01e: ifnull 023
      // 021: return
      // 022: athrow
      // 023: aload 0
      // 024: iload 2
      // 025: ifne 060
      // 028: getfield x/oc738c750564.ո Lx/occ2f8dff8d8;
      // 02b: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 02e: ifeq 05f
      // 031: goto 035
      // 034: athrow
      // 035: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 038: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 03b: getfield net/minecraft/client/entity/EntityPlayerSP.onGround Z
      // 03e: iload 2
      // 03f: ifne 066
      // 042: goto 046
      // 045: athrow
      // 046: ifne 05f
      // 049: goto 04d
      // 04c: athrow
      // 04d: aload 0
      // 04e: aload 1
      // 04f: invokevirtual x/oc70db705765.ԉ ()F
      // 052: putfield x/oc738c750564.ō F
      // 055: aload 0
      // 056: aload 1
      // 057: invokevirtual x/oc70db705765.Ƕ ()F
      // 05a: putfield x/oc738c750564.Ɗ F
      // 05d: return
      // 05e: athrow
      // 05f: aload 0
      // 060: getfield x/oc738c750564.ƚ Lx/occ2f8dff8d8;
      // 063: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 066: iload 2
      // 067: ifne 081
      // 06a: ifeq 096
      // 06d: goto 071
      // 070: athrow
      // 071: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 074: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 077: getfield net/minecraft/client/entity/EntityPlayerSP.capabilities Lnet/minecraft/entity/player/PlayerCapabilities;
      // 07a: getfield net/minecraft/entity/player/PlayerCapabilities.isFlying Z
      // 07d: goto 081
      // 080: athrow
      // 081: ifeq 096
      // 084: aload 0
      // 085: aload 1
      // 086: invokevirtual x/oc70db705765.ԉ ()F
      // 089: putfield x/oc738c750564.ō F
      // 08c: aload 0
      // 08d: aload 1
      // 08e: invokevirtual x/oc70db705765.Ƕ ()F
      // 091: putfield x/oc738c750564.Ɗ F
      // 094: return
      // 095: athrow
      // 096: aload 1
      // 097: invokevirtual x/oc70db705765.ԉ ()F
      // 09a: fstore 3
      // 09b: iload 2
      // 09c: aload 1
      // 09d: invokevirtual x/oc70db705765.Ƕ ()F
      // 0a0: fstore 4
      // 0a2: ifne 113
      // 0a5: fload 3
      // 0a6: fconst_0
      // 0a7: fcmpl
      // 0a8: ifne 108
      // 0ab: goto 0af
      // 0ae: athrow
      // 0af: fload 4
      // 0b1: fconst_0
      // 0b2: iload 2
      // 0b3: ifne 0cb
      // 0b6: goto 0ba
      // 0b9: athrow
      // 0ba: fcmpl
      // 0bb: ifne 108
      // 0be: goto 0c2
      // 0c1: athrow
      // 0c2: aload 0
      // 0c3: getfield x/oc738c750564.ō F
      // 0c6: fconst_0
      // 0c7: goto 0cb
      // 0ca: athrow
      // 0cb: iload 2
      // 0cc: ifne 0e8
      // 0cf: fcmpl
      // 0d0: ifne 0ec
      // 0d3: goto 0d7
      // 0d6: athrow
      // 0d7: aload 0
      // 0d8: iload 2
      // 0d9: ifne 10e
      // 0dc: goto 0e0
      // 0df: athrow
      // 0e0: getfield x/oc738c750564.Ɗ F
      // 0e3: fconst_0
      // 0e4: goto 0e8
      // 0e7: athrow
      // 0e8: fcmpl
      // 0e9: ifeq 108
      // 0ec: aload 1
      // 0ed: aload 0
      // 0ee: getfield x/oc738c750564.ō F
      // 0f1: fneg
      // 0f2: invokestatic java/lang/Math.signum (F)F
      // 0f5: invokevirtual x/oc70db705765.ď (F)V
      // 0f8: aload 1
      // 0f9: aload 0
      // 0fa: getfield x/oc738c750564.Ɗ F
      // 0fd: fneg
      // 0fe: invokestatic java/lang/Math.signum (F)F
      // 101: invokevirtual x/oc70db705765.Ԥ (F)V
      // 104: goto 108
      // 107: athrow
      // 108: aload 0
      // 109: fload 3
      // 10a: putfield x/oc738c750564.ō F
      // 10d: aload 0
      // 10e: fload 4
      // 110: putfield x/oc738c750564.Ɗ F
      // 113: return
   }
}
