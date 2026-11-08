package x;

public class oc932bfa839d {
   long ɇ = 0L;

   private oc932bfa839d() {
   }

   void І() {
      this.ɇ = System.currentTimeMillis();
   }

   boolean ƫ(long var1) {
      int var3 = oc5e549848f3.İ;

      try {
         long var5;
         int var10000 = (var5 = System.currentTimeMillis() - this.ɇ - var1) == 0L ? 0 : (var5 < 0L ? -1 : 1);
         if (var3 != 0) {
            return (boolean)var10000;
         }

         if (var10000 >= 0) {
            return (boolean)1;
         }
      } catch (ocbde1165e4e var4) {
         throw var4;
      }

      return (boolean)0;
   }
}
