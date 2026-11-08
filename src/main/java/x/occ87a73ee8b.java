package x;

import java.awt.Color;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map.Entry;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;

public class occ87a73ee8b extends oc69da1aa7f5 {
   private final oca9cc61aada ҍ;
   private final oc321b4679dd Ւ;
   private final oc321b4679dd ˢ;
   private final oc321b4679dd Ƅ;
   private final oca9cc61aada ĉ;
   private final oca9cc61aada ր;
   private final oca9cc61aada Ł;
   private final occ2f8dff8d8 þ;
   private final occ2f8dff8d8 Ê;
   private final occ2f8dff8d8 ʕ;
   private final occ2f8dff8d8 Ώ;
   private final occ2f8dff8d8 a;
   private final occ2f8dff8d8 Б;
   private final occ2f8dff8d8 ŏ;
   private final occ2f8dff8d8 Ή;
   private final occ2f8dff8d8 ж;
   private final occ2f8dff8d8 ֆ;
   private final occ2f8dff8d8 հ;
   private final oc59544739c2 Ε;
   private final oc03bc465855 ƨ;
   private final LinkedHashMap<String, ResourceLocation> Տ;
   private oc2bb55dd668 ȸ;
   private oc43a44da81e ͻ;
   private String Җ;
   private ResourceLocation Ё;
   private ResourceLocation ӛ;
   private long Ƭ;
   private long ӗ;
   private volatile boolean Ы;
   private boolean ɝ;
   private double ȩ;
   private double ƪ;
   private double U;
   private double ȋ;
   public static boolean ϵ;

   public occ87a73ee8b() {
      super("Spotify", oce4cea752dd.Ŏ);
      String[] var10005 = new String[-148372884 ^ -148372881];
      var10005[0] = "Auto";
      var10005[1] = "Spotify";
      var10005[-148372883 ^ -148372881] = "Last.fm";
      this.ҍ = new oca9cc61aada("Provider", 0, var10005);
      this.Ւ = new oc321b4679dd("Last.fm user", "", "Username", -148372945 ^ -148372881);
      this.ˢ = new oc321b4679dd("Last.fm API key", "", "API key", -148372753 ^ -148372881).Ӂ(true);
      this.Ƅ = new oc321b4679dd("Spotify client ID", "", "Client ID", -148372753 ^ -148372881);
      this.ĉ = new oca9cc61aada("Position X", 0.02, 0.0, 1.0, 0.01);
      this.ր = new oca9cc61aada("Position Y", 0.25, 0.0, 1.0, 0.01);
      this.Ł = new oca9cc61aada("Volume", 50.0, 0.0, 100.0, 1.0);
      this.þ = new occ2f8dff8d8("Show lyrics", true);
      this.Ê = new occ2f8dff8d8("Connect", this::Ղ);
      this.ʕ = new occ2f8dff8d8("Reconnect", this::Ȑ);
      this.Ώ = new occ2f8dff8d8("Disconnect", this::ԁ);
      this.a = new occ2f8dff8d8("Clear authorization", this::Ǩ);
      this.Б = new occ2f8dff8d8("Clear credentials", this::ϛ);
      this.ŏ = new occ2f8dff8d8("Pause", () -> this.Ρ(oc35d65988b7.ɇ));
      this.Ή = new occ2f8dff8d8("Resume", () -> this.Ρ(oc35d65988b7.ʬ));
      this.ж = new occ2f8dff8d8("Next", () -> this.Ρ(oc35d65988b7.Ġ));
      this.ֆ = new occ2f8dff8d8("Previous", () -> this.Ρ(oc35d65988b7.Ϙ));
      this.հ = new occ2f8dff8d8("Open track", this::Ó);
      this.Ε = new oc59544739c2();
      this.ƨ = new oc03bc465855();
      this.Տ = new LinkedHashMap<>(-148372865 ^ -148372881, 0.75F, true);
      this.Җ = "";
      this.ą("Displays music playback.");
      this.ʌ(this.ҍ);
      this.ʌ(this.Ւ);
      this.ʌ(this.ˢ);
      this.ʌ(this.Ƅ);
      this.ʌ(this.ĉ);
      this.ʌ(this.ր);
      this.ʌ(this.þ);
      this.ʌ(this.Ł);
      this.ʌ(this.Ê);
      this.ʌ(this.ʕ);
      this.ʌ(this.Ώ);
      this.ʌ(this.a);
      this.ʌ(this.Б);
      this.ʌ(this.ŏ);
      this.ʌ(this.Ή);
      this.ʌ(this.ж);
      this.ʌ(this.ֆ);
      this.ʌ(this.հ);
      this.Ε.V();
      this.Ւ.z$1bnplyl2p7uqx(this.Ε.ç("lastfm_user"));
      this.ˢ.z$1bnplyl2p7uqx(this.Ε.ç("lastfm_key"));
      this.Ƅ.z$1bnplyl2p7uqx(this.Ε.ç("spotify_client_id"));
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
      // 04: invokevirtual x/occ87a73ee8b.P ()Lx/oce1f9789a12;
      // 07: astore 2
      // 08: istore 1
      // 09: aload 2
      // 0a: iload 1
      // 0b: ifne 1d
      // 0e: getstatic x/oce1f9789a12.Ԡ Lx/oce1f9789a12;
      // 11: if_acmpeq 23
      // 14: goto 18
      // 17: athrow
      // 18: aload 2
      // 19: goto 1d
      // 1c: athrow
      // 1d: getstatic x/oce1f9789a12.ɩ Lx/oce1f9789a12;
      // 20: if_acmpne 28
      // 23: bipush 1
      // 24: goto 29
      // 27: athrow
      // 28: bipush 0
      // 29: istore 3
      // 2a: aload 2
      // 2b: iload 1
      // 2c: ifne 3e
      // 2f: getstatic x/oce1f9789a12.Ԡ Lx/oce1f9789a12;
      // 32: if_acmpeq 44
      // 35: goto 39
      // 38: athrow
      // 39: aload 2
      // 3a: goto 3e
      // 3d: athrow
      // 3e: getstatic x/oce1f9789a12.Ń Lx/oce1f9789a12;
      // 41: if_acmpne 49
      // 44: bipush 1
      // 45: goto 4a
      // 48: athrow
      // 49: bipush 0
      // 4a: istore 4
      // 4c: aload 0
      // 4d: getfield x/occ87a73ee8b.Ւ Lx/oc321b4679dd;
      // 50: iload 3
      // 51: aload 0
      // 52: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 55: aload 0
      // 56: getfield x/occ87a73ee8b.ˢ Lx/oc321b4679dd;
      // 59: iload 3
      // 5a: aload 0
      // 5b: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 5e: aload 0
      // 5f: getfield x/occ87a73ee8b.Ƅ Lx/oc321b4679dd;
      // 62: iload 4
      // 64: aload 0
      // 65: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 68: aload 2
      // 69: getstatic x/oce1f9789a12.Ń Lx/oce1f9789a12;
      // 6c: if_acmpne 74
      // 6f: bipush 1
      // 70: goto 75
      // 73: athrow
      // 74: bipush 0
      // 75: istore 5
      // 77: aload 0
      // 78: getfield x/occ87a73ee8b.Ł Lx/oca9cc61aada;
      // 7b: iload 5
      // 7d: aload 0
      // 7e: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 81: aload 0
      // 82: getfield x/occ87a73ee8b.Ê Lx/occ2f8dff8d8;
      // 85: iload 5
      // 87: aload 0
      // 88: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 8b: aload 0
      // 8c: getfield x/occ87a73ee8b.ʕ Lx/occ2f8dff8d8;
      // 8f: iload 5
      // 91: aload 0
      // 92: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 95: aload 0
      // 96: getfield x/occ87a73ee8b.Ώ Lx/occ2f8dff8d8;
      // 99: iload 5
      // 9b: aload 0
      // 9c: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // 9f: aload 0
      // a0: getfield x/occ87a73ee8b.a Lx/occ2f8dff8d8;
      // a3: iload 5
      // a5: aload 0
      // a6: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // a9: aload 0
      // aa: getfield x/occ87a73ee8b.Б Lx/occ2f8dff8d8;
      // ad: iload 5
      // af: aload 0
      // b0: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // b3: aload 0
      // b4: getfield x/occ87a73ee8b.ŏ Lx/occ2f8dff8d8;
      // b7: iload 5
      // b9: aload 0
      // ba: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // bd: aload 0
      // be: getfield x/occ87a73ee8b.Ή Lx/occ2f8dff8d8;
      // c1: iload 5
      // c3: aload 0
      // c4: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // c7: aload 0
      // c8: getfield x/occ87a73ee8b.ж Lx/occ2f8dff8d8;
      // cb: iload 5
      // cd: aload 0
      // ce: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // d1: aload 0
      // d2: getfield x/occ87a73ee8b.ֆ Lx/occ2f8dff8d8;
      // d5: iload 5
      // d7: aload 0
      // d8: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // db: aload 0
      // dc: getfield x/occ87a73ee8b.հ Lx/occ2f8dff8d8;
      // df: iload 5
      // e1: aload 0
      // e2: invokevirtual x/N.ȉ (ZLx/oc69da1aa7f5;)V
      // e5: return
   }

   private oce1f9789a12 P() {
      return oce1f9789a12.ж((int)this.ҍ.Ӂ());
   }

   @Override
   public void onEnable() {
      try {
         if (!oc7ab2161b9f.Ð()) {
            this.z$1ca1cmv0s357();
            return;
         }
      } catch (ocbde1165e4e var1) {
         throw var1;
      }

      this.J();
      this.Ď();
   }

   private void Ď() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: aload 0
      // 01: invokevirtual x/occ87a73ee8b.Ɔ ()V
      // 04: aload 0
      // 05: invokevirtual x/occ87a73ee8b.P ()Lx/oce1f9789a12;
      // 08: astore 2
      // 09: getstatic x/oce6044968f8.ђ Z
      // 0c: aload 0
      // 0d: getfield x/occ87a73ee8b.Ƅ Lx/oc321b4679dd;
      // 10: invokevirtual x/oc321b4679dd.Ê ()Ljava/lang/String;
      // 13: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 16: astore 3
      // 17: aload 0
      // 18: getfield x/occ87a73ee8b.Ւ Lx/oc321b4679dd;
      // 1b: invokevirtual x/oc321b4679dd.Ê ()Ljava/lang/String;
      // 1e: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 21: astore 4
      // 23: aload 0
      // 24: getfield x/occ87a73ee8b.ˢ Lx/oc321b4679dd;
      // 27: invokevirtual x/oc321b4679dd.Ê ()Ljava/lang/String;
      // 2a: invokevirtual java/lang/String.trim ()Ljava/lang/String;
      // 2d: astore 5
      // 2f: istore 1
      // 30: aload 0
      // 31: iload 1
      // 32: ifne 4c
      // 35: aload 2
      // 36: aload 3
      // 37: aload 4
      // 39: aload 5
      // 3b: invokevirtual x/occ87a73ee8b.σ (Lx/oce1f9789a12;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
      // 3e: ifne 4b
      // 41: goto 45
      // 44: athrow
      // 45: aload 0
      // 46: invokevirtual x/oc69da1aa7f5.z$1ca1cmv0s357 ()V
      // 49: return
      // 4a: athrow
      // 4b: aload 0
      // 4c: aload 3
      // 4d: invokevirtual java/lang/String.isEmpty ()Z
      // 50: ifeq 58
      // 53: aconst_null
      // 54: goto 64
      // 57: athrow
      // 58: new x/oc43a44da81e
      // 5b: dup
      // 5c: aload 3
      // 5d: aload 0
      // 5e: getfield x/occ87a73ee8b.Ε Lx/oc59544739c2;
      // 61: invokespecial x/oc43a44da81e.<init> (Ljava/lang/String;Lx/oc59544739c2;)V
      // 64: putfield x/occ87a73ee8b.ͻ Lx/oc43a44da81e;
      // 67: aload 0
      // 68: aload 0
      // 69: aload 2
      // 6a: aload 4
      // 6c: aload 5
      // 6e: invokevirtual x/occ87a73ee8b.օ (Lx/oce1f9789a12;Ljava/lang/String;Ljava/lang/String;)Lx/oc2bb55dd668;
      // 71: putfield x/occ87a73ee8b.ȸ Lx/oc2bb55dd668;
      // 74: aload 0
      // 75: getfield x/occ87a73ee8b.ȸ Lx/oc2bb55dd668;
      // 78: invokeinterface x/oc2bb55dd668.z$2uy6urhda6qc2 ()V 1
      // 7d: return
   }

   private boolean σ(oce1f9789a12 param1, String param2, String param3, String param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: istore 5
      // 05: aload 1
      // 06: iload 5
      // 08: ifne 36
      // 0b: getstatic x/oce1f9789a12.Ń Lx/oce1f9789a12;
      // 0e: if_acmpne 35
      // 11: goto 15
      // 14: athrow
      // 15: aload 2
      // 16: iload 5
      // 18: ifne 30
      // 1b: goto 1f
      // 1e: athrow
      // 1f: invokevirtual java/lang/String.isEmpty ()Z
      // 22: ifeq 35
      // 25: goto 29
      // 28: athrow
      // 29: ldc_w "&cSpotify HUD: enter your Spotify client ID."
      // 2c: goto 30
      // 2f: athrow
      // 30: invokestatic x/oc7ab2161b9f.ý (Ljava/lang/String;)V
      // 33: bipush 0
      // 34: ireturn
      // 35: aload 1
      // 36: iload 5
      // 38: ifne 7b
      // 3b: getstatic x/oce1f9789a12.ɩ Lx/oce1f9789a12;
      // 3e: if_acmpne 7a
      // 41: goto 45
      // 44: athrow
      // 45: aload 3
      // 46: iload 5
      // 48: ifne 75
      // 4b: goto 4f
      // 4e: athrow
      // 4f: invokevirtual java/lang/String.isEmpty ()Z
      // 52: ifne 6e
      // 55: goto 59
      // 58: athrow
      // 59: aload 4
      // 5b: iload 5
      // 5d: ifne 75
      // 60: goto 64
      // 63: athrow
      // 64: invokevirtual java/lang/String.isEmpty ()Z
      // 67: ifeq 7a
      // 6a: goto 6e
      // 6d: athrow
      // 6e: ldc_w "&cSpotify HUD: enter Last.fm credentials."
      // 71: goto 75
      // 74: athrow
      // 75: invokestatic x/oc7ab2161b9f.ý (Ljava/lang/String;)V
      // 78: bipush 0
      // 79: ireturn
      // 7a: aload 1
      // 7b: getstatic x/oce1f9789a12.Ԡ Lx/oce1f9789a12;
      // 7e: if_acmpne c6
      // 81: aload 2
      // 82: iload 5
      // 84: ifne c1
      // 87: goto 8b
      // 8a: athrow
      // 8b: invokevirtual java/lang/String.isEmpty ()Z
      // 8e: ifne be
      // 91: goto 95
      // 94: athrow
      // 95: aload 3
      // 96: iload 5
      // 98: ifne c1
      // 9b: goto 9f
      // 9e: athrow
      // 9f: invokevirtual java/lang/String.isEmpty ()Z
      // a2: ifne be
      // a5: goto a9
      // a8: athrow
      // a9: aload 4
      // ab: invokevirtual java/lang/String.isEmpty ()Z
      // ae: iload 5
      // b0: ifne c7
      // b3: goto b7
      // b6: athrow
      // b7: ifeq c6
      // ba: goto be
      // bd: athrow
      // be: ldc_w "&cAuto provider needs Spotify Client ID and Last.fm credentials."
      // c1: invokestatic x/oc7ab2161b9f.ý (Ljava/lang/String;)V
      // c4: bipush 0
      // c5: ireturn
      // c6: bipush 1
      // c7: ireturn
   }

   // $VF: Unable to simplify switch on enum
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private oc2bb55dd668 օ(oce1f9789a12 var1, String var2, String var3) {
      try {
         switch (oc5c46aac8ae.Ν[var1.ordinal()]) {
            case 1:
               return new ocba9068df96(this.ͻ, new oc076cd42cc3(var2, var3));
            case 2:
               return this.ͻ;
            case 3:
         }
      } catch (ocbde1165e4e var4) {
         throw var4;
      }

      return new oc076cd42cc3(var2, var3);
   }

   @Override
   public void onDisable() {
      this.Ɔ();
      this.Ȍ();
   }

   @Override
   public void z$3tl278wzjcayb(N param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: istore 2
      // 04: aload 0
      // 05: iload 2
      // 06: ifne 37
      // 09: invokevirtual x/occ87a73ee8b.J ()V
      // 0c: aload 1
      // 0d: aload 0
      // 0e: getfield x/occ87a73ee8b.Ł Lx/oca9cc61aada;
      // 11: if_acmpne 36
      // 14: goto 18
      // 17: athrow
      // 18: aload 0
      // 19: invokevirtual x/occ87a73ee8b.ӕ ()Lx/oc43a44da81e;
      // 1c: astore 3
      // 1d: aload 3
      // 1e: iload 2
      // 1f: ifne 2a
      // 22: ifnull 35
      // 25: goto 29
      // 28: athrow
      // 29: aload 3
      // 2a: aload 0
      // 2b: getfield x/occ87a73ee8b.Ł Lx/oca9cc61aada;
      // 2e: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 31: d2i
      // 32: invokevirtual x/oc43a44da81e.Ƿ (I)V
      // 35: return
      // 36: aload 0
      // 37: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 3a: ifeq 8d
      // 3d: aload 1
      // 3e: iload 2
      // 3f: ifne 56
      // 42: goto 46
      // 45: athrow
      // 46: aload 0
      // 47: getfield x/occ87a73ee8b.ҍ Lx/oca9cc61aada;
      // 4a: if_acmpeq 85
      // 4d: goto 51
      // 50: athrow
      // 51: aload 1
      // 52: goto 56
      // 55: athrow
      // 56: aload 0
      // 57: iload 2
      // 58: ifne 73
      // 5b: getfield x/occ87a73ee8b.Ւ Lx/oc321b4679dd;
      // 5e: if_acmpeq 85
      // 61: goto 65
      // 64: athrow
      // 65: aload 1
      // 66: iload 2
      // 67: ifne 7e
      // 6a: goto 6e
      // 6d: athrow
      // 6e: aload 0
      // 6f: goto 73
      // 72: athrow
      // 73: getfield x/occ87a73ee8b.ˢ Lx/oc321b4679dd;
      // 76: if_acmpeq 85
      // 79: aload 1
      // 7a: goto 7e
      // 7d: athrow
      // 7e: aload 0
      // 7f: getfield x/occ87a73ee8b.Ƅ Lx/oc321b4679dd;
      // 82: if_acmpne 8d
      // 85: aload 0
      // 86: invokevirtual x/occ87a73ee8b.Ď ()V
      // 89: goto 8d
      // 8c: athrow
      // 8d: return
   }

   public void ԃ() {
      this.Ɔ();
      this.Ȍ();
      this.ƨ.Ȃ();
   }

   private synchronized void Ɔ() {
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
      // 06: ifne 40
      // 09: getfield x/occ87a73ee8b.ȸ Lx/oc2bb55dd668;
      // 0c: ifnull 20
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: getfield x/occ87a73ee8b.ȸ Lx/oc2bb55dd668;
      // 17: invokeinterface x/oc2bb55dd668.z$kdc1k1k7jgxc ()V 1
      // 1c: goto 20
      // 1f: athrow
      // 20: aload 0
      // 21: aconst_null
      // 22: putfield x/occ87a73ee8b.ȸ Lx/oc2bb55dd668;
      // 25: aload 0
      // 26: aconst_null
      // 27: putfield x/occ87a73ee8b.ͻ Lx/oc43a44da81e;
      // 2a: aload 0
      // 2b: bipush 0
      // 2c: putfield x/occ87a73ee8b.Ы Z
      // 2f: aload 0
      // 30: ldc ""
      // 32: putfield x/occ87a73ee8b.Җ Ljava/lang/String;
      // 35: aload 0
      // 36: dup
      // 37: getfield x/occ87a73ee8b.Ƭ J
      // 3a: lconst_1
      // 3b: ladd
      // 3c: putfield x/occ87a73ee8b.Ƭ J
      // 3f: aload 0
      // 40: getfield x/occ87a73ee8b.ƨ Lx/oc03bc465855;
      // 43: invokevirtual x/oc03bc465855.Ȃ ()V
      // 46: return
   }

   private void J() {
      this.Ε.Й("lastfm_user", this.Ւ.Ê().trim());
      this.Ε.Й("lastfm_key", this.ˢ.Ê().trim());
      this.Ε.Й("spotify_client_id", this.Ƅ.Ê().trim());

      try {
         this.Ε.ʡ();
      } catch (IOException var2) {
         oc7ab2161b9f.ý("&cCould not save music credentials.");
      }
   }

   private oc43a44da81e ӕ() {
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
      // 06: ifne 1b
      // 09: invokevirtual x/occ87a73ee8b.P ()Lx/oce1f9789a12;
      // 0c: getstatic x/oce1f9789a12.Ń Lx/oce1f9789a12;
      // 0f: if_acmpne 21
      // 12: goto 16
      // 15: athrow
      // 16: aload 0
      // 17: goto 1b
      // 1a: athrow
      // 1b: getfield x/occ87a73ee8b.ͻ Lx/oc43a44da81e;
      // 1e: goto 22
      // 21: aconst_null
      // 22: areturn
   }

   private void Ղ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: istore 1
      // 04: iload 1
      // 05: aload 0
      // 06: invokevirtual x/occ87a73ee8b.ӕ ()Lx/oc43a44da81e;
      // 09: astore 2
      // 0a: ifne 1d
      // 0d: aload 2
      // 0e: ifnull 21
      // 11: goto 15
      // 14: athrow
      // 15: aload 2
      // 16: invokevirtual x/oc43a44da81e.С ()V
      // 19: goto 1d
      // 1c: athrow
      // 1d: iload 1
      // 1e: ifeq 2b
      // 21: ldc_w "&cSpotify provider is not active."
      // 24: invokestatic x/oc7ab2161b9f.ý (Ljava/lang/String;)V
      // 27: goto 2b
      // 2a: athrow
      // 2b: return
   }

   private void Ȑ() {
      boolean var10000 = oce6044968f8.ђ;
      oc43a44da81e var2 = this.ӕ();
      boolean var1 = var10000;

      label20: {
         try {
            var4 = var2;
            if (var1) {
               break label20;
            }

            if (var2 == null) {
               return;
            }
         } catch (ocbde1165e4e var3) {
            throw var3;
         }

         var4 = var2;
      }

      var4.ϛ();
   }

   private void ԁ() {
      boolean var10000 = oce6044968f8.ђ;
      oc43a44da81e var2 = this.ӕ();
      boolean var1 = var10000;

      label20: {
         try {
            var4 = var2;
            if (var1) {
               break label20;
            }

            if (var2 == null) {
               return;
            }
         } catch (ocbde1165e4e var3) {
            throw var3;
         }

         var4 = var2;
      }

      var4.ƃ();
   }

   private void Ǩ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: istore 1
      // 04: iload 1
      // 05: aload 0
      // 06: invokevirtual x/occ87a73ee8b.ӕ ()Lx/oc43a44da81e;
      // 09: astore 2
      // 0a: ifne 28
      // 0d: aload 2
      // 0e: ifnull 21
      // 11: goto 15
      // 14: athrow
      // 15: aload 2
      // 16: invokevirtual x/oc43a44da81e.ϸ ()V
      // 19: iload 1
      // 1a: ifeq 2c
      // 1d: goto 21
      // 20: athrow
      // 21: aload 0
      // 22: getfield x/occ87a73ee8b.Ε Lx/oc59544739c2;
      // 25: invokevirtual x/oc59544739c2.ƀ ()V
      // 28: goto 2c
      // 2b: astore 3
      // 2c: return
   }

   private void ϛ() {
      try {
         this.Ε.ʭ();
         this.Ւ.z$1bnplyl2p7uqx("");
         this.ˢ.z$1bnplyl2p7uqx("");
         this.Ƅ.z$1bnplyl2p7uqx("");
         this.Ɔ();
         oc7ab2161b9f.ý("&aMusic credentials cleared.");
      } catch (IOException var2) {
         oc7ab2161b9f.ý("&cCould not clear credentials.");
      }
   }

   private void Ρ(oc35d65988b7 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: istore 2
      // 04: iload 2
      // 05: aload 0
      // 06: invokevirtual x/occ87a73ee8b.ӕ ()Lx/oc43a44da81e;
      // 09: astore 3
      // 0a: ifne 1f
      // 0d: aload 3
      // 0e: ifnonnull 20
      // 11: goto 15
      // 14: athrow
      // 15: ldc_w "&cSpotify controls are unavailable."
      // 18: invokestatic x/oc7ab2161b9f.ý (Ljava/lang/String;)V
      // 1b: goto 1f
      // 1e: athrow
      // 1f: return
      // 20: getstatic x/oc5c46aac8ae.Ԋ [I
      // 23: aload 1
      // 24: invokevirtual java/lang/Enum.ordinal ()I
      // 27: iaload
      // 28: tableswitch 76 1 4 32 44 56 68
      // 48: aload 3
      // 49: invokevirtual x/oc43a44da81e.ͻ ()V
      // 4c: iload 2
      // 4d: ifeq 74
      // 50: goto 54
      // 53: athrow
      // 54: aload 3
      // 55: invokevirtual x/oc43a44da81e.Ł ()V
      // 58: iload 2
      // 59: ifeq 74
      // 5c: goto 60
      // 5f: athrow
      // 60: aload 3
      // 61: invokevirtual x/oc43a44da81e.Č ()V
      // 64: iload 2
      // 65: ifeq 74
      // 68: goto 6c
      // 6b: athrow
      // 6c: aload 3
      // 6d: invokevirtual x/oc43a44da81e.Զ ()V
      // 70: goto 74
      // 73: athrow
      // 74: return
   }

   private void Ó() {
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
      // 06: ifne 1b
      // 09: getfield x/occ87a73ee8b.ȸ Lx/oc2bb55dd668;
      // 0c: ifnonnull 1a
      // 0f: goto 13
      // 12: athrow
      // 13: getstatic x/ocbb1bc27172.ä Lx/ocbb1bc27172;
      // 16: goto 23
      // 19: athrow
      // 1a: aload 0
      // 1b: getfield x/occ87a73ee8b.ȸ Lx/oc2bb55dd668;
      // 1e: invokeinterface x/oc2bb55dd668.z$26y7m47raszk ()Lx/ocbb1bc27172; 1
      // 23: astore 2
      // 24: aload 2
      // 25: invokevirtual x/ocbb1bc27172.f ()Ljava/lang/String;
      // 28: invokevirtual java/lang/String.isEmpty ()Z
      // 2b: iload 1
      // 2c: ifne 39
      // 2f: ifne 51
      // 32: goto 36
      // 35: athrow
      // 36: invokestatic java/awt/Desktop.isDesktopSupported ()Z
      // 39: ifeq 51
      // 3c: invokestatic java/awt/Desktop.getDesktop ()Ljava/awt/Desktop;
      // 3f: new java/net/URI
      // 42: dup
      // 43: aload 2
      // 44: invokevirtual x/ocbb1bc27172.f ()Ljava/lang/String;
      // 47: invokespecial java/net/URI.<init> (Ljava/lang/String;)V
      // 4a: invokevirtual java/awt/Desktop.browse (Ljava/net/URI;)V
      // 4d: goto 51
      // 50: athrow
      // 51: goto 5b
      // 54: astore 3
      // 55: ldc_w "&cCould not open the current track."
      // 58: invokestatic x/oc7ab2161b9f.ý (Ljava/lang/String;)V
      // 5b: return
   }

   @oc66fa4f2195
   public void ɪ(ocf923d5a814 param1) {
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
      // 05: getfield x/ocb508b4e274.Ұ Lx/oc110d7f376c;
      // 08: getstatic x/oc110d7f376c.END Lx/oc110d7f376c;
      // 0b: if_acmpne 38
      // 0e: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 11: iload 2
      // 12: ifne 35
      // 15: goto 19
      // 18: athrow
      // 19: ifeq 38
      // 1c: goto 20
      // 1f: athrow
      // 20: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 23: iload 2
      // 24: ifne 3c
      // 27: goto 2b
      // 2a: athrow
      // 2b: getfield net/minecraft/client/Minecraft.gameSettings Lnet/minecraft/client/settings/GameSettings;
      // 2e: getfield net/minecraft/client/settings/GameSettings.showDebugInfo Z
      // 31: goto 35
      // 34: athrow
      // 35: ifeq 39
      // 38: return
      // 39: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 3c: iload 2
      // 3d: ifne 51
      // 40: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 43: ifnull 5c
      // 46: goto 4a
      // 49: athrow
      // 4a: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 4d: goto 51
      // 50: athrow
      // 51: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 54: instanceof net/minecraft/client/gui/GuiChat
      // 57: ifne 5c
      // 5a: return
      // 5b: athrow
      // 5c: aload 0
      // 5d: getfield x/occ87a73ee8b.ȸ Lx/oc2bb55dd668;
      // 60: astore 3
      // 61: aload 3
      // 62: iload 2
      // 63: ifne 6f
      // 66: ifnonnull 6e
      // 69: goto 6d
      // 6c: athrow
      // 6d: return
      // 6e: aload 3
      // 6f: invokeinterface x/oc2bb55dd668.z$26y7m47raszk ()Lx/ocbb1bc27172; 1
      // 74: astore 4
      // 76: iload 2
      // 77: ifne 9e
      // 7a: aload 4
      // 7c: invokevirtual x/ocbb1bc27172.Ӝ ()Z
      // 7f: ifne 98
      // 82: goto 86
      // 85: athrow
      // 86: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 89: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 8c: instanceof net/minecraft/client/gui/GuiChat
      // 8f: ifne 98
      // 92: goto 96
      // 95: athrow
      // 96: return
      // 97: athrow
      // 98: aload 0
      // 99: aload 4
      // 9b: invokevirtual x/occ87a73ee8b.ĵ (Lx/ocbb1bc27172;)V
      // 9e: return
   }

   private void ĵ(ocbb1bc27172 var1) {
      ScaledResolution var3 = new ScaledResolution(oc69da1aa7f5.ő);
      boolean var10000 = oce6044968f8.ђ;
      int var4 = Math.max(1, var3.getScaledWidth());
      int var5 = Math.max(1, var3.getScaledHeight());
      float var6 = 235.0F * oce6044968f8.Ƽ();
      float var7 = 145.0F * oce6044968f8.Ƽ();
      boolean var2 = var10000;
      float var8 = ê((float)(this.ĉ.Ӂ() * var4), var4 - var6);
      float var9 = ê((float)(this.ր.Ӂ() * var5), var5 - var7);
      if (!var2) {
         this.Վ(var3, var4, var5, var8, var9, var6, var7);
         var8 = ê((float)(this.ĉ.Ӂ() * var4), var4 - var6);
         var9 = ê((float)(this.ր.Ӂ() * var5), var5 - var7);

         try {
            this.ƍ(var1);
            if (this.þ.ǭ()) {
               this.ƨ.ӻ(var1);
            }
         } catch (ocbde1165e4e var10) {
            throw var10;
         }

         this.ʑ(var8, var9, var6, var7, var1);
      }
   }

   private static float ҥ(ocbb1bc27172 param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: aload 0
      // 04: invokevirtual x/ocbb1bc27172.ʎ ()J
      // 07: lstore 2
      // 08: istore 1
      // 09: lload 2
      // 0a: iload 1
      // 0b: ifne 21
      // 0e: lconst_0
      // 0f: lcmp
      // 10: ifgt 1a
      // 13: goto 17
      // 16: athrow
      // 17: fconst_0
      // 18: freturn
      // 19: athrow
      // 1a: aload 0
      // 1b: invokestatic java/lang/System.currentTimeMillis ()J
      // 1e: invokevirtual x/ocbb1bc27172.ν (J)J
      // 21: lstore 4
      // 23: fconst_0
      // 24: fconst_1
      // 25: lload 4
      // 27: l2f
      // 28: lload 2
      // 29: l2f
      // 2a: fdiv
      // 2b: invokestatic java/lang/Math.min (FF)F
      // 2e: invokestatic java/lang/Math.max (FF)F
      // 31: freturn
   }

   private static float ê(float var0, float var1) {
      return Math.max(0.0F, Math.min(Math.max(0.0F, var1), var0));
   }

   private void Վ(ScaledResolution param1, int param2, int param3, float param4, float param5, float param6, float param7) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: getstatic x/oce6044968f8.ђ Z
      // 003: istore 8
      // 005: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 008: getfield net/minecraft/client/Minecraft.currentScreen Lnet/minecraft/client/gui/GuiScreen;
      // 00b: instanceof net/minecraft/client/gui/GuiChat
      // 00e: iload 8
      // 010: ifne 027
      // 013: ifne 01b
      // 016: goto 01a
      // 019: athrow
      // 01a: return
      // 01b: invokestatic org/lwjgl/input/Mouse.getX ()I
      // 01e: iload 2
      // 01f: imul
      // 020: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 023: getfield net/minecraft/client/Minecraft.displayWidth I
      // 026: idiv
      // 027: istore 9
      // 029: iload 3
      // 02a: invokestatic org/lwjgl/input/Mouse.getY ()I
      // 02d: iload 3
      // 02e: imul
      // 02f: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 032: getfield net/minecraft/client/Minecraft.displayHeight I
      // 035: idiv
      // 036: isub
      // 037: bipush 1
      // 038: isub
      // 039: istore 10
      // 03b: iload 9
      // 03d: i2f
      // 03e: fload 4
      // 040: iload 8
      // 042: ifne 062
      // 045: fcmpl
      // 046: iflt 099
      // 049: goto 04d
      // 04c: athrow
      // 04d: iload 9
      // 04f: i2f
      // 050: iload 8
      // 052: ifne 076
      // 055: goto 059
      // 058: athrow
      // 059: fload 4
      // 05b: fload 6
      // 05d: fadd
      // 05e: goto 062
      // 061: athrow
      // 062: fcmpg
      // 063: ifgt 099
      // 066: iload 10
      // 068: iload 8
      // 06a: ifne 092
      // 06d: goto 071
      // 070: athrow
      // 071: i2f
      // 072: goto 076
      // 075: athrow
      // 076: fload 5
      // 078: fcmpl
      // 079: iflt 099
      // 07c: iload 10
      // 07e: iload 8
      // 080: ifne 096
      // 083: goto 087
      // 086: athrow
      // 087: i2f
      // 088: fload 5
      // 08a: fload 7
      // 08c: fadd
      // 08d: fcmpg
      // 08e: goto 092
      // 091: athrow
      // 092: ifgt 099
      // 095: bipush 1
      // 096: goto 09a
      // 099: bipush 0
      // 09a: istore 11
      // 09c: dconst_1
      // 09d: aload 1
      // 09e: invokevirtual net/minecraft/client/gui/ScaledResolution.getScaleFactor ()I
      // 0a1: i2d
      // 0a2: ddiv
      // 0a3: dstore 12
      // 0a5: iload 11
      // 0a7: iload 8
      // 0a9: ifne 11b
      // 0ac: ifeq 117
      // 0af: goto 0b3
      // 0b2: athrow
      // 0b3: aload 0
      // 0b4: iload 8
      // 0b6: ifne 118
      // 0b9: goto 0bd
      // 0bc: athrow
      // 0bd: getfield x/occ87a73ee8b.ɝ Z
      // 0c0: ifne 117
      // 0c3: goto 0c7
      // 0c6: athrow
      // 0c7: bipush 0
      // 0c8: iload 8
      // 0ca: ifne 11b
      // 0cd: goto 0d1
      // 0d0: athrow
      // 0d1: invokestatic org/lwjgl/input/Mouse.isButtonDown (I)Z
      // 0d4: ifeq 117
      // 0d7: goto 0db
      // 0da: athrow
      // 0db: aload 0
      // 0dc: bipush 1
      // 0dd: putfield x/occ87a73ee8b.ɝ Z
      // 0e0: aload 0
      // 0e1: aload 0
      // 0e2: getfield x/occ87a73ee8b.ĉ Lx/oca9cc61aada;
      // 0e5: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0e8: putfield x/occ87a73ee8b.ȩ D
      // 0eb: aload 0
      // 0ec: aload 0
      // 0ed: getfield x/occ87a73ee8b.ր Lx/oca9cc61aada;
      // 0f0: invokevirtual x/oca9cc61aada.Ӂ ()D
      // 0f3: putfield x/occ87a73ee8b.ƪ D
      // 0f6: aload 0
      // 0f7: invokestatic org/lwjgl/input/Mouse.getX ()I
      // 0fa: i2d
      // 0fb: dload 12
      // 0fd: dmul
      // 0fe: putfield x/occ87a73ee8b.U D
      // 101: aload 0
      // 102: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 105: getfield net/minecraft/client/Minecraft.displayHeight I
      // 108: invokestatic org/lwjgl/input/Mouse.getY ()I
      // 10b: isub
      // 10c: i2d
      // 10d: dload 12
      // 10f: dmul
      // 110: putfield x/occ87a73ee8b.ȋ D
      // 113: goto 117
      // 116: athrow
      // 117: aload 0
      // 118: getfield x/occ87a73ee8b.ɝ Z
      // 11b: iload 8
      // 11d: ifne 12f
      // 120: ifeq 189
      // 123: goto 127
      // 126: athrow
      // 127: bipush 0
      // 128: invokestatic org/lwjgl/input/Mouse.isButtonDown (I)Z
      // 12b: goto 12f
      // 12e: athrow
      // 12f: ifne 140
      // 132: aload 0
      // 133: bipush 0
      // 134: putfield x/occ87a73ee8b.ɝ Z
      // 137: iload 8
      // 139: ifeq 189
      // 13c: goto 140
      // 13f: athrow
      // 140: aload 0
      // 141: getfield x/occ87a73ee8b.ĉ Lx/oca9cc61aada;
      // 144: aload 0
      // 145: getfield x/occ87a73ee8b.ȩ D
      // 148: invokestatic org/lwjgl/input/Mouse.getX ()I
      // 14b: i2d
      // 14c: dload 12
      // 14e: dmul
      // 14f: aload 0
      // 150: getfield x/occ87a73ee8b.U D
      // 153: dsub
      // 154: iload 2
      // 155: i2d
      // 156: ddiv
      // 157: dadd
      // 158: invokestatic x/occ87a73ee8b.ս (D)D
      // 15b: invokevirtual x/oca9cc61aada.Ȟ (D)D
      // 15e: pop2
      // 15f: aload 0
      // 160: getfield x/occ87a73ee8b.ր Lx/oca9cc61aada;
      // 163: aload 0
      // 164: getfield x/occ87a73ee8b.ƪ D
      // 167: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 16a: getfield net/minecraft/client/Minecraft.displayHeight I
      // 16d: invokestatic org/lwjgl/input/Mouse.getY ()I
      // 170: isub
      // 171: i2d
      // 172: dload 12
      // 174: dmul
      // 175: aload 0
      // 176: getfield x/occ87a73ee8b.ȋ D
      // 179: dsub
      // 17a: iload 3
      // 17b: i2d
      // 17c: ddiv
      // 17d: dadd
      // 17e: invokestatic x/occ87a73ee8b.ս (D)D
      // 181: invokevirtual x/oca9cc61aada.Ȟ (D)D
      // 184: pop2
      // 185: goto 189
      // 188: athrow
      // 189: return
   }

   private void ʑ(float var1, float var2, float var3, float var4, ocbb1bc27172 var5) {
      oce6044968f8.қ(var1, var2, var3, var4, () -> this.Ã(var1, var2, var3, var5));
      float var6 = oce6044968f8.Ƽ();
      this.Ƅ(var1 + 14.0F * var6, var2 + 14.0F * var6, 52.0F * var6);
      this.õ(var1 + 76.0F * var6, var2 + 56.0F * var6, var3 - 91.0F * var6, var5);
   }

   private void Ã(float param1, float param2, float param3, ocbb1bc27172 param4) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 000: invokestatic x/oce6044968f8.Ƽ ()F
      // 003: fstore 6
      // 005: invokestatic x/oce6044968f8.ԗ ()Lx/oc1378bc114d;
      // 008: astore 7
      // 00a: ldc_w 0.75
      // 00d: invokestatic x/oce6044968f8.Ƴ (F)Lx/oc1378bc114d;
      // 010: astore 8
      // 012: ldc_w 0.82
      // 015: invokestatic x/oce6044968f8.Ƴ (F)Lx/oc1378bc114d;
      // 018: astore 9
      // 01a: aload 7
      // 01c: aload 4
      // 01e: invokevirtual x/ocbb1bc27172.ԟ ()Ljava/lang/String;
      // 021: ldc_w 1660148319
      // 024: ldc_w 1660148294
      // 027: ixor
      // 028: ldc_w 1660148331
      // 02b: ldc_w 1660148294
      // 02e: ixor
      // 02f: invokestatic x/occ87a73ee8b.Ǆ (Ljava/lang/String;II)Ljava/lang/String;
      // 032: fload 1
      // 033: ldc_w 76.0
      // 036: fload 6
      // 038: fmul
      // 039: fadd
      // 03a: fload 2
      // 03b: ldc_w 15.0
      // 03e: fload 6
      // 040: fmul
      // 041: fadd
      // 042: bipush -1
      // 043: bipush 1
      // 044: invokeinterface x/oc1378bc114d.z$ao2ykh4tuw6w (Ljava/lang/String;FFIZ)I 6
      // 049: pop
      // 04a: aload 8
      // 04c: aload 4
      // 04e: invokevirtual x/ocbb1bc27172.ϧ ()Ljava/lang/String;
      // 051: ldc_w 1660148315
      // 054: ldc_w 1660148294
      // 057: ixor
      // 058: ldc_w 1660148334
      // 05b: ldc_w 1660148294
      // 05e: ixor
      // 05f: invokestatic x/occ87a73ee8b.Ǆ (Ljava/lang/String;II)Ljava/lang/String;
      // 062: fload 1
      // 063: ldc_w 76.0
      // 066: fload 6
      // 068: fmul
      // 069: fadd
      // 06a: fload 2
      // 06b: ldc_w 30.0
      // 06e: fload 6
      // 070: fmul
      // 071: fadd
      // 072: ldc_w -1658178889
      // 075: ldc_w 1660148294
      // 078: ixor
      // 079: bipush 1
      // 07a: invokeinterface x/oc1378bc114d.z$ao2ykh4tuw6w (Ljava/lang/String;FFIZ)I 6
      // 07f: pop
      // 080: getstatic x/oce6044968f8.ђ Z
      // 083: aload 4
      // 085: invokestatic java/lang/System.currentTimeMillis ()J
      // 088: invokevirtual x/ocbb1bc27172.ν (J)J
      // 08b: lstore 10
      // 08d: aload 8
      // 08f: lload 10
      // 091: invokestatic x/occ87a73ee8b.ɝ (J)Ljava/lang/String;
      // 094: aload 4
      // 096: invokevirtual x/ocbb1bc27172.ʎ ()J
      // 099: invokestatic x/occ87a73ee8b.ɝ (J)Ljava/lang/String;
      // 09c: ldc_w " / "
      // 09f: swap
      // 0a0: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001\u0001" ]
      // 0a5: fload 1
      // 0a6: fload 3
      // 0a7: fadd
      // 0a8: ldc_w 58.0
      // 0ab: fload 6
      // 0ad: fmul
      // 0ae: fsub
      // 0af: fload 2
      // 0b0: ldc_w 45.0
      // 0b3: fload 6
      // 0b5: fmul
      // 0b6: fadd
      // 0b7: ldc_w -1656091749
      // 0ba: ldc_w 1660148294
      // 0bd: ixor
      // 0be: bipush 1
      // 0bf: invokeinterface x/oc1378bc114d.z$ao2ykh4tuw6w (Ljava/lang/String;FFIZ)I 6
      // 0c4: pop
      // 0c5: aload 8
      // 0c7: ldc_w "Lyrics"
      // 0ca: fload 1
      // 0cb: ldc_w 14.0
      // 0ce: fload 6
      // 0d0: fmul
      // 0d1: fadd
      // 0d2: fload 2
      // 0d3: ldc_w 78.0
      // 0d6: fload 6
      // 0d8: fmul
      // 0d9: fadd
      // 0da: ldc_w -1656485735
      // 0dd: ldc_w 1660148294
      // 0e0: ixor
      // 0e1: bipush 1
      // 0e2: invokeinterface x/oc1378bc114d.z$ao2ykh4tuw6w (Ljava/lang/String;FFIZ)I 6
      // 0e7: pop
      // 0e8: aload 0
      // 0e9: getfield x/occ87a73ee8b.ƨ Lx/oc03bc465855;
      // 0ec: invokevirtual x/oc03bc465855.є ()Lx/oc142532d567;
      // 0ef: astore 12
      // 0f1: istore 5
      // 0f3: aload 0
      // 0f4: getfield x/occ87a73ee8b.þ Lx/occ2f8dff8d8;
      // 0f7: invokevirtual x/occ2f8dff8d8.ǭ ()Z
      // 0fa: iload 5
      // 0fc: ifne 139
      // 0ff: ifne 12b
      // 102: goto 106
      // 105: athrow
      // 106: aload 8
      // 108: ldc_w "Lyrics are disabled"
      // 10b: fload 1
      // 10c: ldc_w 14.0
      // 10f: fload 6
      // 111: fmul
      // 112: fadd
      // 113: fload 2
      // 114: ldc_w 94.0
      // 117: fload 6
      // 119: fmul
      // 11a: fadd
      // 11b: ldc_w -1656480632
      // 11e: ldc_w 1660148294
      // 121: ixor
      // 122: bipush 1
      // 123: invokeinterface x/oc1378bc114d.z$ao2ykh4tuw6w (Ljava/lang/String;FFIZ)I 6
      // 128: pop
      // 129: return
      // 12a: athrow
      // 12b: aload 12
      // 12d: iload 5
      // 12f: ifne 163
      // 132: invokevirtual x/oc142532d567.ď ()Z
      // 135: goto 139
      // 138: athrow
      // 139: ifeq 161
      // 13c: aload 8
      // 13e: ldc_w "Finding lyrics..."
      // 141: fload 1
      // 142: ldc_w 14.0
      // 145: fload 6
      // 147: fmul
      // 148: fadd
      // 149: fload 2
      // 14a: ldc_w 94.0
      // 14d: fload 6
      // 14f: fmul
      // 150: fadd
      // 151: ldc_w -1657851721
      // 154: ldc_w 1660148294
      // 157: ixor
      // 158: bipush 1
      // 159: invokeinterface x/oc1378bc114d.z$ao2ykh4tuw6w (Ljava/lang/String;FFIZ)I 6
      // 15e: pop
      // 15f: return
      // 160: athrow
      // 161: aload 12
      // 163: iload 5
      // 165: ifne 193
      // 168: invokevirtual x/oc142532d567.Ƙ ()Z
      // 16b: ifeq 191
      // 16e: goto 172
      // 171: athrow
      // 172: aload 9
      // 174: ldc_w "Instrumental"
      // 177: fload 1
      // 178: ldc_w 14.0
      // 17b: fload 6
      // 17d: fmul
      // 17e: fadd
      // 17f: fload 2
      // 180: ldc_w 94.0
      // 183: fload 6
      // 185: fmul
      // 186: fadd
      // 187: bipush -1
      // 188: bipush 1
      // 189: invokeinterface x/oc1378bc114d.z$ao2ykh4tuw6w (Ljava/lang/String;FFIZ)I 6
      // 18e: pop
      // 18f: return
      // 190: athrow
      // 191: aload 12
      // 193: invokevirtual x/oc142532d567.Î ()Ljava/util/List;
      // 196: astore 13
      // 198: aload 13
      // 19a: invokeinterface java/util/List.isEmpty ()Z 1
      // 19f: iload 5
      // 1a1: ifne 1d7
      // 1a4: ifeq 1d0
      // 1a7: goto 1ab
      // 1aa: athrow
      // 1ab: aload 8
      // 1ad: ldc_w "No lyrics found"
      // 1b0: fload 1
      // 1b1: ldc_w 14.0
      // 1b4: fload 6
      // 1b6: fmul
      // 1b7: fadd
      // 1b8: fload 2
      // 1b9: ldc_w 94.0
      // 1bc: fload 6
      // 1be: fmul
      // 1bf: fadd
      // 1c0: ldc_w -1656480632
      // 1c3: ldc_w 1660148294
      // 1c6: ixor
      // 1c7: bipush 1
      // 1c8: invokeinterface x/oc1378bc114d.z$ao2ykh4tuw6w (Ljava/lang/String;FFIZ)I 6
      // 1cd: pop
      // 1ce: return
      // 1cf: athrow
      // 1d0: aload 12
      // 1d2: lload 10
      // 1d4: invokevirtual x/oc142532d567.ǿ (J)I
      // 1d7: istore 14
      // 1d9: iload 14
      // 1db: iload 5
      // 1dd: ifne 1eb
      // 1e0: ifge 1ea
      // 1e3: goto 1e7
      // 1e6: athrow
      // 1e7: bipush 0
      // 1e8: istore 14
      // 1ea: bipush -1
      // 1eb: istore 15
      // 1ed: iload 15
      // 1ef: bipush 1
      // 1f0: if_icmpgt 29b
      // 1f3: bipush 0
      // 1f4: aload 13
      // 1f6: invokeinterface java/util/List.size ()I 1
      // 1fb: bipush 1
      // 1fc: isub
      // 1fd: iload 14
      // 1ff: iload 15
      // 201: iadd
      // 202: invokestatic java/lang/Math.min (II)I
      // 205: invokestatic java/lang/Math.max (II)I
      // 208: istore 16
      // 20a: aload 13
      // 20c: iload 16
      // 20e: invokeinterface java/util/List.get (I)Ljava/lang/Object; 2
      // 213: checkcast x/oc0ac184e19b
      // 216: invokevirtual x/oc0ac184e19b.Ө ()Ljava/lang/String;
      // 219: ldc_w 1660148330
      // 21c: ldc_w 1660148294
      // 21f: ixor
      // 220: invokestatic x/occ87a73ee8b.î (Ljava/lang/String;I)Ljava/lang/String;
      // 223: astore 17
      // 225: iload 15
      // 227: iload 5
      // 229: ifne 23a
      // 22c: ifne 238
      // 22f: goto 233
      // 232: athrow
      // 233: bipush -1
      // 234: goto 257
      // 237: athrow
      // 238: iload 15
      // 23a: iload 5
      // 23c: ifne 24d
      // 23f: ifge 250
      // 242: goto 246
      // 245: athrow
      // 246: ldc_w -1656090222
      // 249: ldc_w 1660148294
      // 24c: ixor
      // 24d: goto 257
      // 250: ldc_w -1654492173
      // 253: ldc_w 1660148294
      // 256: ixor
      // 257: istore 18
      // 259: iload 15
      // 25b: ifne 264
      // 25e: aload 9
      // 260: goto 266
      // 263: athrow
      // 264: aload 8
      // 266: aload 17
      // 268: fload 1
      // 269: ldc_w 14.0
      // 26c: fload 6
      // 26e: fmul
      // 26f: fadd
      // 270: fload 2
      // 271: ldc_w 1660148261
      // 274: ldc_w 1660148294
      // 277: ixor
      // 278: iload 15
      // 27a: bipush 1
      // 27b: iadd
      // 27c: ldc_w 1660148296
      // 27f: ldc_w 1660148294
      // 282: ixor
      // 283: imul
      // 284: iadd
      // 285: i2f
      // 286: fload 6
      // 288: fmul
      // 289: fadd
      // 28a: iload 18
      // 28c: bipush 1
      // 28d: invokeinterface x/oc1378bc114d.z$ao2ykh4tuw6w (Ljava/lang/String;FFIZ)I 6
      // 292: pop
      // 293: iload 5
      // 295: iinc 15 1
      // 298: ifeq 1ed
      // 29b: return
   }

   private void õ(float var1, float var2, float var3, ocbb1bc27172 var4) {
      float var5 = ҥ(var4);
      x.W.s(var1, var2, var3, 3.0F, 1.5F, new Color(-2021735488 ^ -2021735617, -2021735488 ^ -2021735617, -2021735488 ^ -2021735617, -2021735662 ^ -2021735617));
      this.ȁ(var1, var2, var3, 3.0F, var5);
   }

   private void ȁ(float param1, float param2, float param3, float param4, float param5) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: fconst_0
      // 04: fload 3
      // 05: fconst_0
      // 06: fconst_1
      // 07: fload 5
      // 09: invokestatic java/lang/Math.min (FF)F
      // 0c: invokestatic java/lang/Math.max (FF)F
      // 0f: fmul
      // 10: invokestatic java/lang/Math.max (FF)F
      // 13: fstore 7
      // 15: istore 6
      // 17: fload 7
      // 19: iload 6
      // 1b: ifne 2a
      // 1e: fconst_0
      // 1f: fcmpg
      // 20: ifgt 29
      // 23: goto 27
      // 26: athrow
      // 27: return
      // 28: athrow
      // 29: fload 1
      // 2a: f2d
      // 2b: invokestatic x/occ87a73ee8b.պ (D)Ljava/awt/Color;
      // 2e: astore 8
      // 30: fload 1
      // 31: fload 7
      // 33: fadd
      // 34: f2d
      // 35: invokestatic x/occ87a73ee8b.պ (D)Ljava/awt/Color;
      // 38: astore 9
      // 3a: fload 1
      // 3b: fload 2
      // 3c: fload 7
      // 3e: fload 4
      // 40: fload 4
      // 42: fconst_2
      // 43: fdiv
      // 44: aload 8
      // 46: aload 9
      // 48: invokestatic x/W.Ԧ (FFFFFLjava/awt/Color;Ljava/awt/Color;)V
      // 4b: return
   }

   private static Color պ(double var0) {
      return new Color(ocd2958dac48.ů(var0), true);
   }

   private void Ƅ(float param1, float param2, float param3) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: istore 4
      // 05: aload 0
      // 06: iload 4
      // 08: ifne 1a
      // 0b: getfield x/occ87a73ee8b.Ы Z
      // 0e: ifeq 20
      // 11: goto 15
      // 14: athrow
      // 15: aload 0
      // 16: goto 1a
      // 19: athrow
      // 1a: getfield x/occ87a73ee8b.Ё Lnet/minecraft/util/ResourceLocation;
      // 1d: ifnonnull 3f
      // 20: fload 1
      // 21: fload 2
      // 22: fload 3
      // 23: fload 3
      // 24: ldc_w 9.0
      // 27: invokestatic x/oce6044968f8.Ё ()F
      // 2a: invokestatic java/lang/Math.min (FF)F
      // 2d: new java/awt/Color
      // 30: dup
      // 31: fload 1
      // 32: fload 2
      // 33: invokestatic x/oce6044968f8.ȭ (FF)I
      // 36: bipush 1
      // 37: invokespecial java/awt/Color.<init> (IZ)V
      // 3a: invokestatic x/W.s (FFFFFLjava/awt/Color;)V
      // 3d: return
      // 3e: athrow
      // 3f: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 42: invokevirtual net/minecraft/client/Minecraft.getTextureManager ()Lnet/minecraft/client/renderer/texture/TextureManager;
      // 45: aload 0
      // 46: getfield x/occ87a73ee8b.Ё Lnet/minecraft/util/ResourceLocation;
      // 49: invokevirtual net/minecraft/client/renderer/texture/TextureManager.bindTexture (Lnet/minecraft/util/ResourceLocation;)V
      // 4c: fconst_1
      // 4d: fconst_1
      // 4e: fconst_1
      // 4f: fconst_1
      // 50: invokestatic net/minecraft/client/renderer/GlStateManager.color (FFFF)V
      // 53: ldc_w 1956449762
      // 56: ldc_w 1956447744
      // 59: ixor
      // 5a: invokestatic org/lwjgl/opengl/GL11.glEnable (I)V
      // 5d: fload 1
      // 5e: fload 2
      // 5f: fload 3
      // 60: fload 3
      // 61: ldc_w 9.0
      // 64: invokestatic x/oce6044968f8.Ё ()F
      // 67: invokestatic java/lang/Math.min (FF)F
      // 6a: fconst_1
      // 6b: invokestatic x/W.ԡ (FFFFFF)V
      // 6e: return
   }

   private void ƍ(ocbb1bc27172 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: aload 1
      // 04: invokevirtual x/ocbb1bc27172.B ()Ljava/lang/String;
      // 07: astore 3
      // 08: istore 2
      // 09: aload 3
      // 0a: iload 2
      // 0b: ifne 1d
      // 0e: invokevirtual java/lang/String.isEmpty ()Z
      // 11: ifne 27
      // 14: goto 18
      // 17: athrow
      // 18: aload 3
      // 19: goto 1d
      // 1c: athrow
      // 1d: aload 0
      // 1e: getfield x/occ87a73ee8b.Җ Ljava/lang/String;
      // 21: invokevirtual java/lang/String.equals (Ljava/lang/Object;)Z
      // 24: ifeq 29
      // 27: return
      // 28: athrow
      // 29: aload 0
      // 2a: aload 3
      // 2b: putfield x/occ87a73ee8b.Җ Ljava/lang/String;
      // 2e: iload 2
      // 2f: aload 0
      // 30: dup
      // 31: getfield x/occ87a73ee8b.Ƭ J
      // 34: lconst_1
      // 35: ladd
      // 36: dup2_x1
      // 37: putfield x/occ87a73ee8b.Ƭ J
      // 3a: lstore 4
      // 3c: aload 0
      // 3d: getfield x/occ87a73ee8b.Տ Ljava/util/LinkedHashMap;
      // 40: aload 3
      // 41: invokevirtual java/util/LinkedHashMap.get (Ljava/lang/Object;)Ljava/lang/Object;
      // 44: checkcast net/minecraft/util/ResourceLocation
      // 47: astore 6
      // 49: ifne 76
      // 4c: aload 6
      // 4e: ifnull 71
      // 51: goto 55
      // 54: athrow
      // 55: aload 0
      // 56: aload 0
      // 57: getfield x/occ87a73ee8b.Ё Lnet/minecraft/util/ResourceLocation;
      // 5a: putfield x/occ87a73ee8b.ӛ Lnet/minecraft/util/ResourceLocation;
      // 5d: aload 0
      // 5e: aload 6
      // 60: putfield x/occ87a73ee8b.Ё Lnet/minecraft/util/ResourceLocation;
      // 63: aload 0
      // 64: bipush 1
      // 65: putfield x/occ87a73ee8b.Ы Z
      // 68: aload 0
      // 69: invokestatic java/lang/System.currentTimeMillis ()J
      // 6c: putfield x/occ87a73ee8b.ӗ J
      // 6f: return
      // 70: athrow
      // 71: aload 0
      // 72: bipush 0
      // 73: putfield x/occ87a73ee8b.Ы Z
      // 76: aload 1
      // 77: invokevirtual x/ocbb1bc27172.ɺ ()Ljava/lang/String;
      // 7a: astore 7
      // 7c: aload 7
      // 7e: invokevirtual java/lang/String.isEmpty ()Z
      // 81: ifeq 86
      // 84: return
      // 85: athrow
      // 86: new net/minecraft/util/ResourceLocation
      // 89: dup
      // 8a: ldc_w "miau"
      // 8d: aload 3
      // 8e: invokevirtual java/lang/String.hashCode ()I
      // 91: invokestatic java/lang/Integer.toHexString (I)Ljava/lang/String;
      // 94: ldc_w "music/"
      // 97: swap
      // 98: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 9d: invokespecial net/minecraft/util/ResourceLocation.<init> (Ljava/lang/String;Ljava/lang/String;)V
      // a0: astore 8
      // a2: new net/minecraft/client/renderer/ThreadDownloadImageData
      // a5: dup
      // a6: aconst_null
      // a7: aload 7
      // a9: aconst_null
      // aa: new x/oc13d895a089
      // ad: dup
      // ae: aload 0
      // af: lload 4
      // b1: invokespecial x/oc13d895a089.<init> (Lx/occ87a73ee8b;J)V
      // b4: invokespecial net/minecraft/client/renderer/ThreadDownloadImageData.<init> (Ljava/io/File;Ljava/lang/String;Lnet/minecraft/util/ResourceLocation;Lnet/minecraft/client/renderer/IImageBuffer;)V
      // b7: astore 9
      // b9: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // bc: invokevirtual net/minecraft/client/Minecraft.getTextureManager ()Lnet/minecraft/client/renderer/texture/TextureManager;
      // bf: aload 8
      // c1: aload 9
      // c3: invokevirtual net/minecraft/client/renderer/texture/TextureManager.loadTexture (Lnet/minecraft/util/ResourceLocation;Lnet/minecraft/client/renderer/texture/ITextureObject;)Z
      // c6: pop
      // c7: aload 0
      // c8: aload 0
      // c9: getfield x/occ87a73ee8b.Ё Lnet/minecraft/util/ResourceLocation;
      // cc: putfield x/occ87a73ee8b.ӛ Lnet/minecraft/util/ResourceLocation;
      // cf: aload 0
      // d0: aload 8
      // d2: putfield x/occ87a73ee8b.Ё Lnet/minecraft/util/ResourceLocation;
      // d5: aload 0
      // d6: getfield x/occ87a73ee8b.Տ Ljava/util/LinkedHashMap;
      // d9: aload 3
      // da: aload 8
      // dc: invokevirtual java/util/LinkedHashMap.put (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      // df: pop
      // e0: aload 0
      // e1: invokevirtual x/occ87a73ee8b.Ǹ ()V
      // e4: aload 0
      // e5: invokestatic java/lang/System.currentTimeMillis ()J
      // e8: putfield x/occ87a73ee8b.ӗ J
      // eb: return
   }

   private void Ǹ() {
      boolean var1 = oce6044968f8.ђ;

      while (this.Տ.size() > (-1580388413 ^ -1580388401)) {
         Iterator var2 = this.Տ.entrySet().iterator();
         Entry var3 = (Entry)var2.next();

         try {
            var2.remove();
            if (!((ResourceLocation)var3.getValue()).equals(this.Ё)) {
               oc69da1aa7f5.ő.getTextureManager().deleteTexture((ResourceLocation)var3.getValue());
            }
         } catch (ocbde1165e4e var4) {
            throw var4;
         }

         if (var1) {
            break;
         }
      }
   }

   private void Ȍ() {
      boolean var10000 = oce6044968f8.ђ;
      Iterator var2 = this.Տ.values().iterator();
      boolean var1 = var10000;

      while (true) {
         if (var2.hasNext()) {
            ResourceLocation var3 = (ResourceLocation)var2.next();

            try {
               oc69da1aa7f5.ő.getTextureManager().deleteTexture(var3);
               if (var1) {
                  break;
               }

               if (!var1) {
                  continue;
               }
            } catch (ocbde1165e4e var4) {
               throw var4;
            }
         }

         this.Տ.clear();
         this.Ё = null;
         this.ӛ = null;
         break;
      }
   }

   private static String Ǆ(String param0, int param1, int param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: istore 3
      // 04: aload 0
      // 05: iload 3
      // 06: ifne 15
      // 09: ifnonnull 14
      // 0c: goto 10
      // 0f: athrow
      // 10: ldc ""
      // 12: areturn
      // 13: athrow
      // 14: aload 0
      // 15: iload 3
      // 16: ifne 30
      // 19: invokevirtual java/lang/String.length ()I
      // 1c: iload 1
      // 1d: if_icmpgt 27
      // 20: goto 24
      // 23: athrow
      // 24: aload 0
      // 25: areturn
      // 26: athrow
      // 27: aload 0
      // 28: ldc_w "   "
      // 2b: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 30: astore 4
      // 32: invokestatic java/lang/System.currentTimeMillis ()J
      // 35: bipush 1
      // 36: iload 2
      // 37: invokestatic java/lang/Math.max (II)I
      // 3a: i2l
      // 3b: ldiv
      // 3c: aload 4
      // 3e: invokevirtual java/lang/String.length ()I
      // 41: i2l
      // 42: lrem
      // 43: l2i
      // 44: istore 5
      // 46: aload 4
      // 48: aload 4
      // 4a: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 4f: astore 6
      // 51: aload 6
      // 53: iload 5
      // 55: iload 5
      // 57: iload 1
      // 58: iadd
      // 59: aload 6
      // 5b: invokevirtual java/lang/String.length ()I
      // 5e: invokestatic java/lang/Math.min (II)I
      // 61: invokevirtual java/lang/String.substring (II)Ljava/lang/String;
      // 64: areturn
   }

   private static String î(String param0, int param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oce6044968f8.ђ Z
      // 03: istore 2
      // 04: aload 0
      // 05: iload 2
      // 06: ifne 17
      // 09: ifnonnull 16
      // 0c: goto 10
      // 0f: athrow
      // 10: ldc ""
      // 12: goto 3c
      // 15: athrow
      // 16: aload 0
      // 17: iload 2
      // 18: ifne 37
      // 1b: invokevirtual java/lang/String.length ()I
      // 1e: iload 1
      // 1f: if_icmpgt 2b
      // 22: goto 26
      // 25: athrow
      // 26: aload 0
      // 27: goto 3c
      // 2a: athrow
      // 2b: aload 0
      // 2c: bipush 0
      // 2d: bipush 1
      // 2e: iload 1
      // 2f: bipush 1
      // 30: isub
      // 31: invokestatic java/lang/Math.max (II)I
      // 34: invokevirtual java/lang/String.substring (II)Ljava/lang/String;
      // 37: invokedynamic makeConcatWithConstants (Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001…" ]
      // 3c: areturn
   }

   private static String ɝ(long var0) {
      long var2 = Math.max(0L, var0 / (-8249189058873232851L ^ -8249189058873232955L));
      Locale var10000 = Locale.ROOT;
      Object[] var10002 = new Object[297682309 ^ 297682311];
      var10002[0] = var2 / (-8249189058873232903L ^ -8249189058873232955L);
      var10002[1] = var2 % (-8249189058873232903L ^ -8249189058873232955L);
      return String.format(var10000, "%d:%02d", var10002);
   }

   private static double ս(double var0) {
      return Math.max(0.0, Math.min(1.0, var0));
   }
}
