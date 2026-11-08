package x;

public abstract class oc72ee500c19 extends oc69da1aa7f5 {
   private final String[] Ǖ;
   private final ocada7dda290 Ŗ;
   private final oc49fb68d420[] ʝ;
   private final boolean[] Σ;
   private final long[] Ձ;
   private boolean Ź;
   private boolean ş;
   public static boolean Ț;

   protected oc72ee500c19() {
      super("Velocity", oce4cea752dd.ȁ, 0);
      String[] var10001 = new String[1962858152 ^ 1962858157];
      var10001[0] = "Standard";
      var10001[1] = "OldGrim";
      var10001[1962858159 ^ 1962858157] = "JumpReset";
      var10001[1962858158 ^ 1962858157] = "MMC";
      var10001[1962858153 ^ 1962858157] = "Intave";
      this.Ǖ = var10001;
      this.ą("Changes the knockback you receive from damage.");
      this.ʌ(this.Ŗ = new ocada7dda290("Mode", this.Ǖ, new String[]{"Standard"}));
      oc49fb68d420[] var1 = new oc49fb68d420[1962858152 ^ 1962858157];
      var1[0] = new oc0c1ea432b5(this);
      var1[1] = new ocef361a48dc(this);
      var1[1962858159 ^ 1962858157] = new oca011860186(this);
      var1[1962858158 ^ 1962858157] = new oc938442b206(this);
      var1[1962858153 ^ 1962858157] = new oc0cf407c945(this);
      this.ʝ = var1;
      this.Σ = new boolean[this.ʝ.length];
      this.Ձ = new long[this.ʝ.length];
      this.ϔ();
      this.z$2u87utkr1isxg();
      this.ɮ = true;
   }

   public boolean ӂ(String var1) {
      return this.Ŗ.ǩ(var1);
   }

   public boolean ˣ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: istore 1
      // 02: aload 0
      // 03: iload 1
      // 04: ifne 18
      // 07: ldc "Standard"
      // 09: invokevirtual x/oc72ee500c19.ӂ (Ljava/lang/String;)Z
      // 0c: ifeq 2f
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: goto 18
      // 17: athrow
      // 18: getfield x/oc72ee500c19.ʝ [Lx/oc49fb68d420;
      // 1b: bipush 0
      // 1c: aaload
      // 1d: invokevirtual x/oc49fb68d420.z$35cvjrtlfk6sk ()Z
      // 20: iload 1
      // 21: ifne 2c
      // 24: ifeq 2f
      // 27: goto 2b
      // 2a: athrow
      // 2b: bipush 1
      // 2c: goto 30
      // 2f: bipush 0
      // 30: ireturn
   }

   @oc66fa4f2195
   public void å(oce38b1b133f param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: aload 0
      // 01: invokevirtual x/oc72ee500c19.ϔ ()V
      // 04: bipush 0
      // 05: invokestatic java/lang/System.currentTimeMillis ()J
      // 08: lstore 3
      // 09: bipush 0
      // 0a: istore 5
      // 0c: istore 2
      // 0d: iload 5
      // 0f: aload 0
      // 10: getfield x/oc72ee500c19.ʝ [Lx/oc49fb68d420;
      // 13: arraylength
      // 14: if_icmpge 5a
      // 17: aload 0
      // 18: iload 2
      // 19: ifne 2e
      // 1c: iload 5
      // 1e: lload 3
      // 1f: invokevirtual x/oc72ee500c19.Ł (IJ)Z
      // 22: ifeq 53
      // 25: goto 29
      // 28: athrow
      // 29: aload 0
      // 2a: goto 2e
      // 2d: athrow
      // 2e: iload 2
      // 2f: ifne 47
      // 32: getfield x/oc72ee500c19.ʝ [Lx/oc49fb68d420;
      // 35: iload 5
      // 37: aaload
      // 38: instanceof x/oca011860186
      // 3b: ifeq 53
      // 3e: goto 42
      // 41: athrow
      // 42: aload 0
      // 43: goto 47
      // 46: athrow
      // 47: getfield x/oc72ee500c19.ʝ [Lx/oc49fb68d420;
      // 4a: iload 5
      // 4c: aaload
      // 4d: checkcast x/oca011860186
      // 50: invokevirtual x/oca011860186.ԕ ()V
      // 53: iinc 5 1
      // 56: iload 2
      // 57: ifeq 0d
      // 5a: return
   }

   public void Ĵ(boolean var1) {
      this.Ź = var1;
      oc49fb68d420[] var3 = this.ʝ;
      int var4 = var3.length;
      int var5 = 0;
      boolean var2 = false;

      while (var5 < var4) {
         oc49fb68d420 var6 = var3[var5];
         var6.Ƅ(var1);
         var5++;
         if (var2) {
            break;
         }
      }
   }

   public boolean g() {
      return this.Ź;
   }

   @Override
   public String getInfo() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: aload 0
      // 02: invokevirtual x/oc72ee500c19.ϔ ()V
      // 05: invokestatic java/lang/System.currentTimeMillis ()J
      // 08: lstore 2
      // 09: aload 0
      // 0a: lload 2
      // 0b: invokevirtual x/oc72ee500c19.ª (J)V
      // 0e: istore 1
      // 0f: new java/util/ArrayList
      // 12: dup
      // 13: invokespecial java/util/ArrayList.<init> ()V
      // 16: astore 4
      // 18: bipush 0
      // 19: istore 5
      // 1b: iload 5
      // 1d: aload 0
      // 1e: getfield x/oc72ee500c19.ʝ [Lx/oc49fb68d420;
      // 21: arraylength
      // 22: if_icmpge 9d
      // 25: iload 1
      // 26: ifne ad
      // 29: aload 0
      // 2a: iload 1
      // 2b: ifne 4c
      // 2e: goto 32
      // 31: athrow
      // 32: getfield x/oc72ee500c19.Σ [Z
      // 35: iload 5
      // 37: baload
      // 38: ifne 47
      // 3b: goto 3f
      // 3e: athrow
      // 3f: iload 1
      // 40: ifeq 96
      // 43: goto 47
      // 46: athrow
      // 47: aload 0
      // 48: goto 4c
      // 4b: athrow
      // 4c: getfield x/oc72ee500c19.Ձ [J
      // 4f: iload 5
      // 51: laload
      // 52: lload 2
      // 53: lcmp
      // 54: iload 1
      // 55: ifne 95
      // 58: ifle 80
      // 5b: goto 5f
      // 5e: athrow
      // 5f: aload 4
      // 61: aload 0
      // 62: getfield x/oc72ee500c19.ʝ [Lx/oc49fb68d420;
      // 65: iload 5
      // 67: aaload
      // 68: invokevirtual x/oc49fb68d420.Ɋ ()Ljava/lang/String;
      // 6b: ldc " Paused"
      // 6d: invokedynamic makeConcatWithConstants (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; bsm=java/lang/invoke/StringConcatFactory.makeConcatWithConstants (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; args=[ "\u0001\u0001" ]
      // 72: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 77: pop
      // 78: iload 1
      // 79: ifeq 96
      // 7c: goto 80
      // 7f: athrow
      // 80: aload 4
      // 82: aload 0
      // 83: getfield x/oc72ee500c19.ʝ [Lx/oc49fb68d420;
      // 86: iload 5
      // 88: aaload
      // 89: invokevirtual x/oc49fb68d420.z$1vjyi4gk9v6c9 ()Ljava/lang/String;
      // 8c: invokeinterface java/util/List.add (Ljava/lang/Object;)Z 2
      // 91: goto 95
      // 94: athrow
      // 95: pop
      // 96: iinc 5 1
      // 99: iload 1
      // 9a: ifeq 1b
      // 9d: aload 4
      // 9f: invokeinterface java/util/List.isEmpty ()Z 1
      // a4: ifeq ad
      // a7: ldc "None"
      // a9: goto b4
      // ac: athrow
      // ad: ldc " + "
      // af: aload 4
      // b1: invokestatic java/lang/String.join (Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;
      // b4: areturn
   }

   public int ơ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: aload 0
      // 02: invokevirtual x/oc72ee500c19.ϔ ()V
      // 05: istore 1
      // 06: bipush 0
      // 07: istore 2
      // 08: aload 0
      // 09: getfield x/oc72ee500c19.Σ [Z
      // 0c: astore 3
      // 0d: aload 3
      // 0e: arraylength
      // 0f: istore 4
      // 11: bipush 0
      // 12: istore 5
      // 14: iload 5
      // 16: iload 4
      // 18: if_icmpge 40
      // 1b: aload 3
      // 1c: iload 5
      // 1e: baload
      // 1f: iload 1
      // 20: ifne 41
      // 23: istore 6
      // 25: iload 1
      // 26: ifne 3c
      // 29: iload 6
      // 2b: ifeq 39
      // 2e: goto 32
      // 31: athrow
      // 32: iinc 2 1
      // 35: goto 39
      // 38: athrow
      // 39: iinc 5 1
      // 3c: iload 1
      // 3d: ifeq 14
      // 40: iload 2
      // 41: ireturn
   }

   @Override
   public void z$2u87utkr1isxg() {
      this.ϔ();
      oc49fb68d420[] var2 = this.ʝ;
      int var3 = var2.length;
      boolean var1 = false;
      int var4 = 0;

      while (var4 < var3) {
         oc49fb68d420 var5 = var2[var4];
         var5.z$fe4mfecqaowg();
         var4++;
         if (var1) {
            break;
         }
      }
   }

   @Override
   public void guiButtonToggled(occ2f8dff8d8 var1) {
      super.guiButtonToggled(var1);
      boolean var2 = false;
      this.ϔ();
      oc49fb68d420[] var3 = this.ʝ;
      int var4 = var3.length;
      int var5 = 0;

      while (true) {
         if (var5 < var4) {
            oc49fb68d420 var6 = var3[var5];

            try {
               if (var2) {
                  break;
               }

               var6.z$1k6rqjev9onbs(var1);
               var5++;
               if (!var2) {
                  continue;
               }
            } catch (ocbde1165e4e var7) {
               throw var7;
            }
         }

         this.z$2u87utkr1isxg();
         break;
      }
   }

   @Override
   public void z$1sehylui0i4ix(oca9cc61aada var1) {
      this.z$2u87utkr1isxg();
   }

   @Override
   public void z$3tl278wzjcayb(N var1) {
      this.ϔ();
      oc49fb68d420[] var3 = this.ʝ;
      int var4 = var3.length;
      boolean var2 = false;
      int var5 = 0;

      while (true) {
         if (var5 < var4) {
            oc49fb68d420 var6 = var3[var5];

            try {
               var6.X(var1);
               if (var2) {
                  break;
               }

               var5++;
               if (!var2) {
                  continue;
               }
            } catch (ocbde1165e4e var7) {
               throw var7;
            }
         }

         this.z$2u87utkr1isxg();
         break;
      }
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
      // 00: aload 0
      // 01: invokevirtual x/oc72ee500c19.ϔ ()V
      // 04: bipush 0
      // 05: aload 0
      // 06: bipush 1
      // 07: putfield x/oc72ee500c19.ş Z
      // 0a: istore 1
      // 0b: bipush 0
      // 0c: istore 2
      // 0d: iload 2
      // 0e: aload 0
      // 0f: getfield x/oc72ee500c19.ʝ [Lx/oc49fb68d420;
      // 12: arraylength
      // 13: if_icmpge 4a
      // 16: aload 0
      // 17: getfield x/oc72ee500c19.Ձ [J
      // 1a: iload 2
      // 1b: lconst_0
      // 1c: lastore
      // 1d: iload 1
      // 1e: ifne 46
      // 21: iload 1
      // 22: ifne 4e
      // 25: goto 29
      // 28: athrow
      // 29: aload 0
      // 2a: getfield x/oc72ee500c19.Σ [Z
      // 2d: iload 2
      // 2e: baload
      // 2f: ifeq 43
      // 32: goto 36
      // 35: athrow
      // 36: aload 0
      // 37: getfield x/oc72ee500c19.ʝ [Lx/oc49fb68d420;
      // 3a: iload 2
      // 3b: aaload
      // 3c: invokevirtual x/oc49fb68d420.z$24alrqiqeci48 ()V
      // 3f: goto 43
      // 42: athrow
      // 43: iinc 2 1
      // 46: iload 1
      // 47: ifeq 0d
      // 4a: aload 0
      // 4b: invokevirtual x/oc72ee500c19.z$2u87utkr1isxg ()V
      // 4e: return
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
      // 00: bipush 0
      // 01: bipush 0
      // 02: istore 2
      // 03: istore 1
      // 04: iload 2
      // 05: aload 0
      // 06: getfield x/oc72ee500c19.ʝ [Lx/oc49fb68d420;
      // 09: arraylength
      // 0a: if_icmpge 41
      // 0d: iload 1
      // 0e: ifne 46
      // 11: aload 0
      // 12: iload 1
      // 13: ifne 34
      // 16: goto 1a
      // 19: athrow
      // 1a: getfield x/oc72ee500c19.Σ [Z
      // 1d: iload 2
      // 1e: baload
      // 1f: ifeq 33
      // 22: goto 26
      // 25: athrow
      // 26: aload 0
      // 27: getfield x/oc72ee500c19.ʝ [Lx/oc49fb68d420;
      // 2a: iload 2
      // 2b: aaload
      // 2c: invokevirtual x/oc49fb68d420.z$1bjr376lv3ef3 ()V
      // 2f: goto 33
      // 32: athrow
      // 33: aload 0
      // 34: getfield x/oc72ee500c19.Ձ [J
      // 37: iload 2
      // 38: lconst_0
      // 39: lastore
      // 3a: iload 1
      // 3b: iinc 2 1
      // 3e: ifeq 04
      // 41: aload 0
      // 42: bipush 0
      // 43: putfield x/oc72ee500c19.ş Z
      // 46: return
   }

   private void ϔ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.NullPointerException: Cannot invoke "org.jetbrains.java.decompiler.code.cfg.ExceptionRangeCFG.isCircular()" because "range" is null
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.graphToStatement(DomHelper.java:84)
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:203)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: istore 1
      // 02: aload 0
      // 03: iload 1
      // 04: ifne 16
      // 07: getfield x/oc72ee500c19.ʝ [Lx/oc49fb68d420;
      // 0a: ifnull 1c
      // 0d: goto 11
      // 10: athrow
      // 11: aload 0
      // 12: goto 16
      // 15: athrow
      // 16: getfield x/oc72ee500c19.Σ [Z
      // 19: ifnonnull 1e
      // 1c: return
      // 1d: athrow
      // 1e: bipush 0
      // 1f: istore 2
      // 20: iload 2
      // 21: aload 0
      // 22: getfield x/oc72ee500c19.ʝ [Lx/oc49fb68d420;
      // 25: arraylength
      // 26: if_icmpge c7
      // 29: aload 0
      // 2a: getfield x/oc72ee500c19.Ŗ Lx/ocada7dda290;
      // 2d: aload 0
      // 2e: getfield x/oc72ee500c19.Ǖ [Ljava/lang/String;
      // 31: iload 2
      // 32: aaload
      // 33: invokevirtual x/ocada7dda290.ǩ (Ljava/lang/String;)Z
      // 36: istore 3
      // 37: iload 3
      // 38: iload 1
      // 39: ifne 63
      // 3c: aload 0
      // 3d: getfield x/oc72ee500c19.Σ [Z
      // 40: iload 2
      // 41: baload
      // 42: if_icmpne 51
      // 45: goto 49
      // 48: athrow
      // 49: iload 1
      // 4a: ifeq c0
      // 4d: goto 51
      // 50: athrow
      // 51: aload 0
      // 52: getfield x/oc72ee500c19.Σ [Z
      // 55: iload 2
      // 56: iload 1
      // 57: ifne 8b
      // 5a: goto 5e
      // 5d: athrow
      // 5e: baload
      // 5f: goto 63
      // 62: athrow
      // 63: ifeq 86
      // 66: aload 0
      // 67: iload 1
      // 68: ifne 96
      // 6b: goto 6f
      // 6e: athrow
      // 6f: getfield x/oc72ee500c19.ş Z
      // 72: ifeq 86
      // 75: goto 79
      // 78: athrow
      // 79: aload 0
      // 7a: getfield x/oc72ee500c19.ʝ [Lx/oc49fb68d420;
      // 7d: iload 2
      // 7e: aaload
      // 7f: invokevirtual x/oc49fb68d420.z$1bjr376lv3ef3 ()V
      // 82: goto 86
      // 85: athrow
      // 86: aload 0
      // 87: getfield x/oc72ee500c19.Σ [Z
      // 8a: iload 2
      // 8b: iload 3
      // 8c: bastore
      // 8d: iload 1
      // 8e: ifne c3
      // 91: aload 0
      // 92: goto 96
      // 95: athrow
      // 96: getfield x/oc72ee500c19.Ձ [J
      // 99: iload 2
      // 9a: lconst_0
      // 9b: lastore
      // 9c: iload 3
      // 9d: ifeq c0
      // a0: aload 0
      // a1: iload 1
      // a2: ifne b8
      // a5: goto a9
      // a8: athrow
      // a9: getfield x/oc72ee500c19.ş Z
      // ac: ifeq c0
      // af: goto b3
      // b2: athrow
      // b3: aload 0
      // b4: goto b8
      // b7: athrow
      // b8: getfield x/oc72ee500c19.ʝ [Lx/oc49fb68d420;
      // bb: iload 2
      // bc: aaload
      // bd: invokevirtual x/oc49fb68d420.z$24alrqiqeci48 ()V
      // c0: iinc 2 1
      // c3: iload 1
      // c4: ifeq 20
      // c7: return
   }

   private boolean Ł(int var1, long var2) {
      boolean var4 = false;
      int var5 = -1842801064 ^ 1113158205;

      while (true) {
         label151:
         while (true) {
            label149:
            while (true) {
               label145:
               while (true) {
                  switch (var5) {
                     case -1542436777:
                        int var15;
                        label88: {
                           label87: {
                              try {
                                 long var19;
                                 var15 = (var19 = this.Ձ[var1] - var2) == 0L ? 0 : (var19 < 0L ? -1 : 1);
                                 if (var4) {
                                    break label88;
                                 }

                                 if (var15 > 0) {
                                    break label87;
                                 }
                              } catch (ocbde1165e4e var7) {
                                 throw var7;
                              }

                              var5 = -1115160635 ^ 1113158205;
                              if (!var4) {
                                 continue;
                              }
                           }

                           var15 = -329082529 ^ 1113158205;
                        }

                        var5 = var15;
                        if (!var4) {
                           continue;
                        }
                     case -1371804830:
                        break label151;
                     case -797940635:
                        break label145;
                     case -765213543:
                        return false;
                     case -273495472:
                        break;
                     case -2191880:
                        break label149;
                     case 872917532:
                        return true;
                     case 1512334491:
                        int var10000;
                        label132: {
                           label131: {
                              try {
                                 long var17;
                                 var10000 = (var17 = this.Ձ[var1] - 0L) == 0L ? 0 : (var17 < 0L ? -1 : 1);
                                 if (var4) {
                                    break label132;
                                 }

                                 if (var10000 != 0) {
                                    break label131;
                                 }
                              } catch (ocbde1165e4e var11) {
                                 throw var11;
                              }

                              var5 = 1985927201 ^ 1113158205;
                              if (!var4) {
                                 continue;
                              }
                           }

                           var10000 = -1875200348 ^ 1113158205;
                        }

                        var5 = var10000;
                        if (!var4) {
                           continue;
                        }
                     case 886150725:
                        int var12;
                        label122: {
                           label121: {
                              try {
                                 var12 = this.ş;
                                 if (var4) {
                                    break label122;
                                 }

                                 if (!this.ş) {
                                    break label121;
                                 }
                              } catch (ocbde1165e4e var10) {
                                 throw var10;
                              }

                              var5 = -1377060755 ^ 1113158205;
                              if (!var4) {
                                 continue;
                              }
                           }

                           var12 = -329082529 ^ 1113158205;
                        }

                        var5 = var12;
                        if (!var4) {
                           continue;
                        }
                        break;
                     default:
                        throw null;
                  }

                  int var13;
                  label112: {
                     label111: {
                        try {
                           long var18;
                           var13 = (var18 = this.Ձ[var1] - 0L) == 0L ? 0 : (var18 < 0L ? -1 : 1);
                           if (var4) {
                              break label112;
                           }

                           if (var13 == 0) {
                              break label111;
                           }
                        } catch (ocbde1165e4e var9) {
                           throw var9;
                        }

                        var5 = -431408534 ^ 1113158205;
                        if (!var4) {
                           continue;
                        }
                     }

                     var13 = -329082529 ^ 1113158205;
                  }

                  var5 = var13;
                  if (var4) {
                     break;
                  }
               }

               int var14;
               label101: {
                  label100: {
                     try {
                        var14 = this.Σ[var1];
                        if (var4) {
                           break label101;
                        }

                        if (var14 == 0) {
                           break label100;
                        }
                     } catch (ocbde1165e4e var8) {
                        throw var8;
                     }

                     var5 = 1988682872 ^ 1113158205;
                     if (!var4) {
                        continue;
                     }
                  }

                  var14 = -329082529 ^ 1113158205;
               }

               var5 = var14;
               if (var4) {
                  break;
               }
            }

            this.Ձ[var1] = 0L;
            this.ʝ[var1].z$24alrqiqeci48();
            var5 = -329082529 ^ 1113158205;
            if (var4) {
               return true;
            }
         }

         int var16;
         label79: {
            label78: {
               try {
                  var16 = this.Σ[var1];
                  if (var4) {
                     break label79;
                  }

                  if (var16 == 0) {
                     break label78;
                  }
               } catch (ocbde1165e4e var6) {
                  throw var6;
               }

               var5 = 410850982 ^ 1113158205;
               if (!var4) {
                  continue;
               }
            }

            var16 = -1875200348 ^ 1113158205;
         }

         var5 = var16;
      }
   }

   private void Δ(int param1, long param2) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: istore 4
      // 03: aload 0
      // 04: iload 4
      // 06: ifne 1a
      // 09: getfield x/oc72ee500c19.Σ [Z
      // 0c: iload 1
      // 0d: baload
      // 0e: ifeq 2d
      // 11: goto 15
      // 14: athrow
      // 15: aload 0
      // 16: goto 1a
      // 19: athrow
      // 1a: getfield x/oc72ee500c19.Ձ [J
      // 1d: iload 4
      // 1f: ifne 3c
      // 22: iload 1
      // 23: laload
      // 24: lload 2
      // 25: lcmp
      // 26: ifle 2f
      // 29: goto 2d
      // 2c: athrow
      // 2d: return
      // 2e: athrow
      // 2f: aload 0
      // 30: getfield x/oc72ee500c19.ʝ [Lx/oc49fb68d420;
      // 33: iload 1
      // 34: aaload
      // 35: invokevirtual x/oc49fb68d420.z$1bjr376lv3ef3 ()V
      // 38: aload 0
      // 39: getfield x/oc72ee500c19.Ձ [J
      // 3c: iload 1
      // 3d: lload 2
      // 3e: lconst_0
      // 3f: aload 0
      // 40: getfield x/oc72ee500c19.ʝ [Lx/oc49fb68d420;
      // 43: iload 1
      // 44: aaload
      // 45: invokevirtual x/oc49fb68d420.z$hyas9yszrl5h ()J
      // 48: invokestatic java/lang/Math.max (JJ)J
      // 4b: ladd
      // 4c: lastore
      // 4d: return
   }

   private void ª(long param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: istore 3
      // 02: aload 0
      // 03: getfield x/oc72ee500c19.ş Z
      // 06: iload 3
      // 07: ifne 13
      // 0a: ifne 12
      // 0d: goto 11
      // 10: athrow
      // 11: return
      // 12: bipush 0
      // 13: istore 4
      // 15: iload 4
      // 17: aload 0
      // 18: getfield x/oc72ee500c19.ʝ [Lx/oc49fb68d420;
      // 1b: arraylength
      // 1c: if_icmpge 7e
      // 1f: aload 0
      // 20: iload 3
      // 21: ifne 36
      // 24: getfield x/oc72ee500c19.Σ [Z
      // 27: iload 4
      // 29: baload
      // 2a: ifeq 77
      // 2d: goto 31
      // 30: athrow
      // 31: aload 0
      // 32: goto 36
      // 35: athrow
      // 36: getfield x/oc72ee500c19.Ձ [J
      // 39: iload 4
      // 3b: laload
      // 3c: lconst_0
      // 3d: iload 3
      // 3e: ifne 5d
      // 41: lcmp
      // 42: ifeq 77
      // 45: goto 49
      // 48: athrow
      // 49: aload 0
      // 4a: getfield x/oc72ee500c19.Ձ [J
      // 4d: iload 3
      // 4e: ifne 69
      // 51: goto 55
      // 54: athrow
      // 55: iload 4
      // 57: laload
      // 58: lload 1
      // 59: goto 5d
      // 5c: athrow
      // 5d: lcmp
      // 5e: ifgt 77
      // 61: aload 0
      // 62: getfield x/oc72ee500c19.Ձ [J
      // 65: goto 69
      // 68: athrow
      // 69: iload 4
      // 6b: lconst_0
      // 6c: lastore
      // 6d: aload 0
      // 6e: getfield x/oc72ee500c19.ʝ [Lx/oc49fb68d420;
      // 71: iload 4
      // 73: aaload
      // 74: invokevirtual x/oc49fb68d420.z$24alrqiqeci48 ()V
      // 77: iinc 4 1
      // 7a: iload 3
      // 7b: ifeq 15
      // 7e: return
   }

   @oc66fa4f2195
   public void Һ(oc227cab88a2 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: aload 0
      // 02: invokevirtual x/oc72ee500c19.ϔ ()V
      // 05: invokestatic java/lang/System.currentTimeMillis ()J
      // 08: lstore 3
      // 09: istore 2
      // 0a: bipush 0
      // 0b: istore 5
      // 0d: iload 5
      // 0f: aload 0
      // 10: getfield x/oc72ee500c19.ʝ [Lx/oc49fb68d420;
      // 13: arraylength
      // 14: if_icmpge a4
      // 17: aload 0
      // 18: getfield x/oc72ee500c19.Σ [Z
      // 1b: iload 5
      // 1d: baload
      // 1e: iload 2
      // 1f: ifne 38
      // 22: ifne 31
      // 25: goto 29
      // 28: athrow
      // 29: iload 2
      // 2a: ifeq 9d
      // 2d: goto 31
      // 30: athrow
      // 31: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 34: goto 38
      // 37: athrow
      // 38: iload 2
      // 39: ifne 8f
      // 3c: ifeq 7c
      // 3f: goto 43
      // 42: athrow
      // 43: aload 1
      // 44: getfield x/oc227cab88a2.Ϡ Lnet/minecraft/entity/Entity;
      // 47: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 4a: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 4d: if_acmpne 7c
      // 50: goto 54
      // 53: athrow
      // 54: aload 0
      // 55: iload 2
      // 56: ifne 81
      // 59: goto 5d
      // 5c: athrow
      // 5d: getfield x/oc72ee500c19.ʝ [Lx/oc49fb68d420;
      // 60: iload 5
      // 62: aaload
      // 63: invokevirtual x/oc49fb68d420.z$23aflqwrtv1kr ()Z
      // 66: ifeq 7c
      // 69: goto 6d
      // 6c: athrow
      // 6d: aload 0
      // 6e: iload 5
      // 70: lload 3
      // 71: invokevirtual x/oc72ee500c19.Δ (IJ)V
      // 74: iload 2
      // 75: ifeq 9d
      // 78: goto 7c
      // 7b: athrow
      // 7c: aload 0
      // 7d: goto 81
      // 80: athrow
      // 81: iload 2
      // 82: ifne 93
      // 85: iload 5
      // 87: lload 3
      // 88: invokevirtual x/oc72ee500c19.Ł (IJ)Z
      // 8b: goto 8f
      // 8e: athrow
      // 8f: ifeq 9d
      // 92: aload 0
      // 93: getfield x/oc72ee500c19.ʝ [Lx/oc49fb68d420;
      // 96: iload 5
      // 98: aaload
      // 99: aload 1
      // 9a: invokevirtual x/oc49fb68d420.ը (Lx/oc227cab88a2;)V
      // 9d: iinc 5 1
      // a0: iload 2
      // a1: ifeq 0d
      // a4: return
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.HIGHEST
   )
   public void з(oce79181588d param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: aload 0
      // 02: invokevirtual x/oc72ee500c19.ϔ ()V
      // 05: istore 2
      // 06: invokestatic java/lang/System.currentTimeMillis ()J
      // 09: lstore 3
      // 0a: bipush 0
      // 0b: istore 5
      // 0d: iload 5
      // 0f: aload 0
      // 10: getfield x/oc72ee500c19.ʝ [Lx/oc49fb68d420;
      // 13: arraylength
      // 14: if_icmpge 5a
      // 17: aload 0
      // 18: iload 2
      // 19: ifne 2e
      // 1c: iload 5
      // 1e: lload 3
      // 1f: invokevirtual x/oc72ee500c19.Ł (IJ)Z
      // 22: ifeq 4f
      // 25: goto 29
      // 28: athrow
      // 29: aload 0
      // 2a: goto 2e
      // 2d: athrow
      // 2e: getfield x/oc72ee500c19.ʝ [Lx/oc49fb68d420;
      // 31: iload 5
      // 33: aaload
      // 34: aload 1
      // 35: invokevirtual x/oc49fb68d420.z$2az31g34zryyb (Lx/oce79181588d;)V
      // 38: iload 2
      // 39: ifne 56
      // 3c: aload 1
      // 3d: invokevirtual x/oc68d6b191af.isCanceled ()Z
      // 40: ifeq 4f
      // 43: goto 47
      // 46: athrow
      // 47: iload 2
      // 48: ifeq 5a
      // 4b: goto 4f
      // 4e: athrow
      // 4f: iinc 5 1
      // 52: goto 56
      // 55: athrow
      // 56: iload 2
      // 57: ifeq 0d
      // 5a: return
   }

   @oc66fa4f2195(
      receiveCanceled = true
   )
   public void Ѵ(oce79181588d param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: aload 0
      // 01: invokevirtual x/oc72ee500c19.ϔ ()V
      // 04: bipush 0
      // 05: invokestatic java/lang/System.currentTimeMillis ()J
      // 08: lstore 3
      // 09: istore 2
      // 0a: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 0d: iload 2
      // 0e: ifne a3
      // 11: ifeq 9f
      // 14: goto 18
      // 17: athrow
      // 18: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 1b: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 1e: getfield net/minecraft/client/entity/EntityPlayerSP.ticksExisted I
      // 21: iload 2
      // 22: ifne a3
      // 25: goto 29
      // 28: athrow
      // 29: ldc_w -1343383671
      // 2c: ldc_w -1343383651
      // 2f: ixor
      // 30: if_icmple 9f
      // 33: goto 37
      // 36: athrow
      // 37: aload 1
      // 38: iload 2
      // 39: ifne a0
      // 3c: goto 40
      // 3f: athrow
      // 40: invokevirtual x/oce79181588d.Ҡ ()Lnet/minecraft/network/Packet;
      // 43: instanceof net/minecraft/network/play/server/S08PacketPlayerPosLook
      // 46: ifeq 9f
      // 49: goto 4d
      // 4c: athrow
      // 4d: bipush 0
      // 4e: istore 5
      // 50: iload 5
      // 52: aload 0
      // 53: getfield x/oc72ee500c19.ʝ [Lx/oc49fb68d420;
      // 56: arraylength
      // 57: if_icmpge 9f
      // 5a: aload 0
      // 5b: iload 2
      // 5c: ifne bd
      // 5f: iload 2
      // 60: ifne 79
      // 63: goto 67
      // 66: athrow
      // 67: getfield x/oc72ee500c19.Σ [Z
      // 6a: iload 5
      // 6c: baload
      // 6d: ifeq 98
      // 70: goto 74
      // 73: athrow
      // 74: aload 0
      // 75: goto 79
      // 78: athrow
      // 79: iload 2
      // 7a: ifne 92
      // 7d: getfield x/oc72ee500c19.ʝ [Lx/oc49fb68d420;
      // 80: iload 5
      // 82: aaload
      // 83: invokevirtual x/oc49fb68d420.z$23aflqwrtv1kr ()Z
      // 86: ifeq 98
      // 89: goto 8d
      // 8c: athrow
      // 8d: aload 0
      // 8e: goto 92
      // 91: athrow
      // 92: iload 5
      // 94: lload 3
      // 95: invokevirtual x/oc72ee500c19.Δ (IJ)V
      // 98: iinc 5 1
      // 9b: iload 2
      // 9c: ifeq 50
      // 9f: aload 1
      // a0: invokevirtual x/oc68d6b191af.isCanceled ()Z
      // a3: iload 2
      // a4: ifne b0
      // a7: ifeq af
      // aa: goto ae
      // ad: athrow
      // ae: return
      // af: bipush 0
      // b0: istore 5
      // b2: iload 5
      // b4: aload 0
      // b5: getfield x/oc72ee500c19.ʝ [Lx/oc49fb68d420;
      // b8: arraylength
      // b9: if_icmpge ff
      // bc: aload 0
      // bd: iload 2
      // be: ifne d3
      // c1: iload 5
      // c3: lload 3
      // c4: invokevirtual x/oc72ee500c19.Ł (IJ)Z
      // c7: ifeq f4
      // ca: goto ce
      // cd: athrow
      // ce: aload 0
      // cf: goto d3
      // d2: athrow
      // d3: getfield x/oc72ee500c19.ʝ [Lx/oc49fb68d420;
      // d6: iload 5
      // d8: aaload
      // d9: aload 1
      // da: invokevirtual x/oc49fb68d420.z$3fnumkcg4fzh7 (Lx/oce79181588d;)V
      // dd: iload 2
      // de: ifne fb
      // e1: aload 1
      // e2: invokevirtual x/oc68d6b191af.isCanceled ()Z
      // e5: ifeq f4
      // e8: goto ec
      // eb: athrow
      // ec: iload 2
      // ed: ifeq ff
      // f0: goto f4
      // f3: athrow
      // f4: iinc 5 1
      // f7: goto fb
      // fa: athrow
      // fb: iload 2
      // fc: ifeq b2
      // ff: return
   }

   @oc66fa4f2195
   public void Ħ(oc9341368218 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: aload 0
      // 02: invokevirtual x/oc72ee500c19.ϔ ()V
      // 05: istore 2
      // 06: invokestatic x/oc7ab2161b9f.Ð ()Z
      // 09: iload 2
      // 0a: ifne 17
      // 0d: ifeq 2b
      // 10: goto 14
      // 13: athrow
      // 14: getstatic x/H.ԇ Z
      // 17: ifne 2b
      // 1a: aload 1
      // 1b: getfield x/oc63654a8391.Ӡ Lnet/minecraft/entity/EntityLivingBase;
      // 1e: getstatic x/oc69da1aa7f5.ő Lnet/minecraft/client/Minecraft;
      // 21: getfield net/minecraft/client/Minecraft.thePlayer Lnet/minecraft/client/entity/EntityPlayerSP;
      // 24: if_acmpeq 2d
      // 27: goto 2b
      // 2a: athrow
      // 2b: return
      // 2c: athrow
      // 2d: invokestatic java/lang/System.currentTimeMillis ()J
      // 30: lstore 3
      // 31: aload 0
      // 32: lload 3
      // 33: invokevirtual x/oc72ee500c19.ª (J)V
      // 36: bipush 0
      // 37: istore 5
      // 39: iload 5
      // 3b: aload 0
      // 3c: getfield x/oc72ee500c19.ʝ [Lx/oc49fb68d420;
      // 3f: arraylength
      // 40: if_icmpge 6b
      // 43: aload 0
      // 44: iload 2
      // 45: ifne 5a
      // 48: iload 5
      // 4a: lload 3
      // 4b: invokevirtual x/oc72ee500c19.Ł (IJ)Z
      // 4e: ifeq 64
      // 51: goto 55
      // 54: athrow
      // 55: aload 0
      // 56: goto 5a
      // 59: athrow
      // 5a: getfield x/oc72ee500c19.ʝ [Lx/oc49fb68d420;
      // 5d: iload 5
      // 5f: aaload
      // 60: aload 1
      // 61: invokevirtual x/oc49fb68d420.z$1hfnjryfrqybj (Lx/oc9341368218;)V
      // 64: iinc 5 1
      // 67: iload 2
      // 68: ifeq 39
      // 6b: return
   }

   @oc66fa4f2195
   public void ʮ(occ48acb5d22 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: aload 0
      // 02: invokevirtual x/oc72ee500c19.ϔ ()V
      // 05: invokestatic java/lang/System.currentTimeMillis ()J
      // 08: lstore 3
      // 09: bipush 0
      // 0a: istore 5
      // 0c: istore 2
      // 0d: iload 5
      // 0f: aload 0
      // 10: getfield x/oc72ee500c19.ʝ [Lx/oc49fb68d420;
      // 13: arraylength
      // 14: if_icmpge 3f
      // 17: aload 0
      // 18: iload 2
      // 19: ifne 2e
      // 1c: iload 5
      // 1e: lload 3
      // 1f: invokevirtual x/oc72ee500c19.Ł (IJ)Z
      // 22: ifeq 38
      // 25: goto 29
      // 28: athrow
      // 29: aload 0
      // 2a: goto 2e
      // 2d: athrow
      // 2e: getfield x/oc72ee500c19.ʝ [Lx/oc49fb68d420;
      // 31: iload 5
      // 33: aaload
      // 34: aload 1
      // 35: invokevirtual x/oc49fb68d420.z$3n62k5eunm8co (Lx/occ48acb5d22;)V
      // 38: iinc 5 1
      // 3b: iload 2
      // 3c: ifeq 0d
      // 3f: return
   }

   @oc66fa4f2195
   public void ƀ(oc3d09332f58 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: aload 0
      // 01: invokevirtual x/oc72ee500c19.ϔ ()V
      // 04: bipush 0
      // 05: invokestatic java/lang/System.currentTimeMillis ()J
      // 08: lstore 3
      // 09: bipush 0
      // 0a: istore 5
      // 0c: istore 2
      // 0d: iload 5
      // 0f: aload 0
      // 10: getfield x/oc72ee500c19.ʝ [Lx/oc49fb68d420;
      // 13: arraylength
      // 14: if_icmpge 3f
      // 17: aload 0
      // 18: iload 2
      // 19: ifne 2e
      // 1c: iload 5
      // 1e: lload 3
      // 1f: invokevirtual x/oc72ee500c19.Ł (IJ)Z
      // 22: ifeq 38
      // 25: goto 29
      // 28: athrow
      // 29: aload 0
      // 2a: goto 2e
      // 2d: athrow
      // 2e: getfield x/oc72ee500c19.ʝ [Lx/oc49fb68d420;
      // 31: iload 5
      // 33: aaload
      // 34: aload 1
      // 35: invokevirtual x/oc49fb68d420.z$1jqr9z9xe1cdc (Lx/oc3d09332f58;)V
      // 38: iinc 5 1
      // 3b: iload 2
      // 3c: ifeq 0d
      // 3f: return
   }

   @oc66fa4f2195
   public void ԕ(oc2f61de30bc param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: aload 0
      // 01: invokevirtual x/oc72ee500c19.ϔ ()V
      // 04: bipush 0
      // 05: invokestatic java/lang/System.currentTimeMillis ()J
      // 08: lstore 3
      // 09: istore 2
      // 0a: bipush 0
      // 0b: istore 5
      // 0d: iload 5
      // 0f: aload 0
      // 10: getfield x/oc72ee500c19.ʝ [Lx/oc49fb68d420;
      // 13: arraylength
      // 14: if_icmpge 3f
      // 17: aload 0
      // 18: iload 2
      // 19: ifne 2e
      // 1c: iload 5
      // 1e: lload 3
      // 1f: invokevirtual x/oc72ee500c19.Ł (IJ)Z
      // 22: ifeq 38
      // 25: goto 29
      // 28: athrow
      // 29: aload 0
      // 2a: goto 2e
      // 2d: athrow
      // 2e: getfield x/oc72ee500c19.ʝ [Lx/oc49fb68d420;
      // 31: iload 5
      // 33: aaload
      // 34: aload 1
      // 35: invokevirtual x/oc49fb68d420.ˀ (Lx/oc2f61de30bc;)V
      // 38: iinc 5 1
      // 3b: iload 2
      // 3c: ifeq 0d
      // 3f: return
   }

   @oc66fa4f2195
   public void Ͼ(oc70db705765 param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: aload 0
      // 01: invokevirtual x/oc72ee500c19.ϔ ()V
      // 04: bipush 0
      // 05: invokestatic java/lang/System.currentTimeMillis ()J
      // 08: lstore 3
      // 09: istore 2
      // 0a: bipush 0
      // 0b: istore 5
      // 0d: iload 5
      // 0f: aload 0
      // 10: getfield x/oc72ee500c19.ʝ [Lx/oc49fb68d420;
      // 13: arraylength
      // 14: if_icmpge 3f
      // 17: aload 0
      // 18: iload 2
      // 19: ifne 2e
      // 1c: iload 5
      // 1e: lload 3
      // 1f: invokevirtual x/oc72ee500c19.Ł (IJ)Z
      // 22: ifeq 38
      // 25: goto 29
      // 28: athrow
      // 29: aload 0
      // 2a: goto 2e
      // 2d: athrow
      // 2e: getfield x/oc72ee500c19.ʝ [Lx/oc49fb68d420;
      // 31: iload 5
      // 33: aaload
      // 34: aload 1
      // 35: invokevirtual x/oc49fb68d420.ԕ (Lx/oc70db705765;)V
      // 38: iinc 5 1
      // 3b: iload 2
      // 3c: ifeq 0d
      // 3f: return
   }

   @oc66fa4f2195
   public void Ҽ(oc0e4b758d9a param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: bipush 0
      // 01: aload 0
      // 02: invokevirtual x/oc72ee500c19.ϔ ()V
      // 05: istore 2
      // 06: invokestatic java/lang/System.currentTimeMillis ()J
      // 09: lstore 3
      // 0a: bipush 0
      // 0b: istore 5
      // 0d: iload 5
      // 0f: aload 0
      // 10: getfield x/oc72ee500c19.ʝ [Lx/oc49fb68d420;
      // 13: arraylength
      // 14: if_icmpge 3f
      // 17: aload 0
      // 18: iload 2
      // 19: ifne 2e
      // 1c: iload 5
      // 1e: lload 3
      // 1f: invokevirtual x/oc72ee500c19.Ł (IJ)Z
      // 22: ifeq 38
      // 25: goto 29
      // 28: athrow
      // 29: aload 0
      // 2a: goto 2e
      // 2d: athrow
      // 2e: getfield x/oc72ee500c19.ʝ [Lx/oc49fb68d420;
      // 31: iload 5
      // 33: aaload
      // 34: aload 1
      // 35: invokevirtual x/oc49fb68d420.λ (Lx/oc0e4b758d9a;)V
      // 38: iinc 5 1
      // 3b: iload 2
      // 3c: ifeq 0d
      // 3f: return
   }

   @oc66fa4f2195
   public void ќ(oc9d4393f3ce param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: aload 0
      // 01: invokevirtual x/oc72ee500c19.ϔ ()V
      // 04: invokestatic java/lang/System.currentTimeMillis ()J
      // 07: lstore 3
      // 08: bipush 0
      // 09: bipush 0
      // 0a: istore 5
      // 0c: istore 2
      // 0d: iload 5
      // 0f: aload 0
      // 10: getfield x/oc72ee500c19.ʝ [Lx/oc49fb68d420;
      // 13: arraylength
      // 14: if_icmpge 3f
      // 17: aload 0
      // 18: iload 2
      // 19: ifne 2e
      // 1c: iload 5
      // 1e: lload 3
      // 1f: invokevirtual x/oc72ee500c19.Ł (IJ)Z
      // 22: ifeq 38
      // 25: goto 29
      // 28: athrow
      // 29: aload 0
      // 2a: goto 2e
      // 2d: athrow
      // 2e: getfield x/oc72ee500c19.ʝ [Lx/oc49fb68d420;
      // 31: iload 5
      // 33: aaload
      // 34: aload 1
      // 35: invokevirtual x/oc49fb68d420.ъ (Lx/oc9d4393f3ce;)V
      // 38: iinc 5 1
      // 3b: iload 2
      // 3c: ifeq 0d
      // 3f: return
   }

   @oc66fa4f2195
   public void ß(ocbab3c9954b var1) {
      int var3 = 0;
      boolean var2 = false;

      while (var3 < this.ʝ.length) {
         this.Ձ[var3] = 0L;
         this.ʝ[var3].z$2cvyenog50sql(var1);
         var3++;
         if (var2) {
            break;
         }
      }
   }
}
