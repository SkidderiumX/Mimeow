package x;

public abstract class ocff26c2f723 extends oc69da1aa7f5 {
   private final oca9cc61aada Ϗ;
   private final String[] ʚ;
   private final oca897d4a197[] ʠ;
   private int œ;
   public static boolean Ʉ;

   protected ocff26c2f723() {
      super("NoFall", oce4cea752dd.з);
      String[] var10001 = new String[2044426848 ^ 2044426851];
      var10001[0] = "Spoof";
      var10001[1] = "NoGround";
      var10001[2044426849 ^ 2044426851] = "MLG";
      this.ʚ = var10001;
      this.ą("Removes fall damage");
      this.ʌ(this.Ϗ = new oca9cc61aada("Mode", 0, this.ʚ));
      oca897d4a197[] var1 = new oca897d4a197[2044426848 ^ 2044426851];
      var1[0] = new oce0fd3902d1(this);
      var1[1] = new ocbcdd24e1ca(this);
      var1[2044426849 ^ 2044426851] = new ocebf5c047db(this);
      this.ʠ = var1;
      this.œ = this.Ţ();
      this.z$2u87utkr1isxg();
      this.ɮ = true;
   }

   public boolean ǹ(String var1) {
      return var1.equals(this.ʚ[this.Ţ()]);
   }

   @Override
   public String getInfo() {
      this.ǥ();
      return this.Ǳ().ο();
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
      // 00: getstatic x/oca897d4a197.Է Z
      // 03: aload 0
      // 04: invokevirtual x/ocff26c2f723.ǥ ()V
      // 07: aload 0
      // 08: getfield x/ocff26c2f723.ʠ [Lx/oca897d4a197;
      // 0b: astore 2
      // 0c: aload 2
      // 0d: arraylength
      // 0e: istore 3
      // 0f: istore 1
      // 10: bipush 0
      // 11: istore 4
      // 13: iload 4
      // 15: iload 3
      // 16: if_icmpge 2b
      // 19: aload 2
      // 1a: iload 4
      // 1c: aaload
      // 1d: astore 5
      // 1f: iload 1
      // 20: aload 5
      // 22: invokevirtual x/oca897d4a197.z$22mqk5pab06po ()V
      // 25: iinc 4 1
      // 28: ifeq 13
      // 2b: bipush 0
      // 2c: ifeq 40
      // 2f: iload 1
      // 30: ifeq 3c
      // 33: goto 37
      // 36: athrow
      // 37: bipush 0
      // 38: goto 3d
      // 3b: athrow
      // 3c: bipush 1
      // 3d: putstatic x/oca897d4a197.Է Z
      // 40: return
   }

   @Override
   public void z$1sehylui0i4ix(oca9cc61aada var1) {
      try {
         if (var1 == this.Ϗ) {
            this.ǥ();
         }
      } catch (ocbde1165e4e var2) {
         throw var2;
      }

      this.z$2u87utkr1isxg();
   }

   @Override
   public void z$3tl278wzjcayb(N var1) {
      this.ǥ();
      this.z$2u87utkr1isxg();
   }

   @Override
   public void onEnable() {
      this.œ = this.Ţ();
      this.Ǳ().z$v0pjcuscvgpm();
      this.z$2u87utkr1isxg();
   }

   @Override
   public void onDisable() {
      this.Ǳ().z$lhgkqjml0t90();
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.LOWEST
   )
   public void d(oc86de9e2892 var1) {
      this.ǥ();
      this.Ǳ().z$332enlh7knq4u(var1);
   }

   @oc66fa4f2195
   public void b(oc2f61de30bc var1) {
      this.ǥ();
      this.Ǳ().ջ(var1);
   }

   @oc66fa4f2195
   public void ψ(ocebec3dfd67 var1) {
      this.ǥ();
      this.Ǳ().Ð(var1);
   }

   @oc66fa4f2195(
      priority = oc8ce2882092.LOWEST
   )
   public void Τ(oc25aa89b91f var1) {
      this.ǥ();
      this.Ǳ().z$4fpyqyd5hjll(var1);
   }

   @oc66fa4f2195
   public void Ն(ocbab3c9954b var1) {
      oca897d4a197[] var3 = this.ʠ;
      int var4 = var3.length;
      boolean var2 = oca897d4a197.Է;
      int var5 = 0;

      while (var5 < var4) {
         oca897d4a197 var6 = var3[var5];
         var6.z$1ctfmdsr4zs0m(var1);
         var5++;
         if (var2) {
            break;
         }
      }
   }

   private int Ţ() {
      int var2 = 0;
      int var3 = 0;
      int var4 = 969798190 ^ 1551194199;
      boolean var1 = oca897d4a197.Է;

      while (true) {
         switch (var4) {
            case -678475015:
               var3 = this.ʠ.length - 1;
               var4 = -1695762497 ^ 1551194199;
               if (!var1) {
                  break;
               }
            case 1706601081:
               int var10000 = (int)this.Ϗ.Ӂ();
               if (!var1) {
                  var2 = var10000;
                  if (this.ʠ == null) {
                     var4 = -1537069662 ^ 1551194199;
                     if (!var1) {
                        break;
                     }
                  }

                  var10000 = -1946545490 ^ 1551194199;
               }

               var4 = var10000;
               if (!var1) {
                  break;
               }
            case -132680203:
               var3 = this.ʚ.length - 1;
               var4 = -1695762497 ^ 1551194199;
               if (!var1) {
                  break;
               }
            case -962990104:
               return Math.max(0, Math.min(var2, var3));
            default:
               throw null;
         }
      }
   }

   private void ǥ() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:166)
      //
      // Bytecode:
      // 00: getstatic x/oca897d4a197.Է Z
      // 03: istore 1
      // 04: aload 0
      // 05: iload 1
      // 06: ifne 18
      // 09: getfield x/ocff26c2f723.ʠ [Lx/oca897d4a197;
      // 0c: ifnull 27
      // 0f: goto 13
      // 12: athrow
      // 13: aload 0
      // 14: goto 18
      // 17: athrow
      // 18: iload 1
      // 19: ifne 2a
      // 1c: getfield x/ocff26c2f723.ʠ [Lx/oca897d4a197;
      // 1f: arraylength
      // 20: ifne 29
      // 23: goto 27
      // 26: athrow
      // 27: return
      // 28: athrow
      // 29: aload 0
      // 2a: invokevirtual x/ocff26c2f723.Ţ ()I
      // 2d: istore 2
      // 2e: iload 2
      // 2f: iload 1
      // 30: ifne 4c
      // 33: aload 0
      // 34: getfield x/ocff26c2f723.œ I
      // 37: if_icmpne 40
      // 3a: goto 3e
      // 3d: athrow
      // 3e: return
      // 3f: athrow
      // 40: aload 0
      // 41: iload 1
      // 42: ifne 68
      // 45: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 48: goto 4c
      // 4b: athrow
      // 4c: ifeq 5a
      // 4f: aload 0
      // 50: invokevirtual x/ocff26c2f723.Ǳ ()Lx/oca897d4a197;
      // 53: invokevirtual x/oca897d4a197.z$lhgkqjml0t90 ()V
      // 56: goto 5a
      // 59: athrow
      // 5a: aload 0
      // 5b: iload 1
      // 5c: ifne 73
      // 5f: iload 2
      // 60: putfield x/ocff26c2f723.œ I
      // 63: aload 0
      // 64: goto 68
      // 67: athrow
      // 68: invokevirtual x/oc69da1aa7f5.z$3rzb3dil7uydr ()Z
      // 6b: ifeq 79
      // 6e: aload 0
      // 6f: goto 73
      // 72: athrow
      // 73: invokevirtual x/ocff26c2f723.Ǳ ()Lx/oca897d4a197;
      // 76: invokevirtual x/oca897d4a197.z$v0pjcuscvgpm ()V
      // 79: return
   }

   private oca897d4a197 Ǳ() {
      return this.ʠ[this.œ];
   }
}
