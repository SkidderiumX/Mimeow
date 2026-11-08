package com.sun.jna.win32;

import com.sun.jna.FromNativeContext;
import com.sun.jna.ToNativeContext;
import com.sun.jna.TypeConverter;
public class W32APITypeMapper$2 implements TypeConverter {
    static /* synthetic */ Class class$(String x0) {
        try {
            return Class.forName(x0);
        }
        catch (ClassNotFoundException x1) {
            throw new NoClassDefFoundError(x1.getMessage());
        }
    }
    static /* synthetic */ Class class$java$lang$Integer;

   W32APITypeMapper$2(W32APITypeMapper var1) {
      this.this$0 = var1;
   }

   public Object toNative(Object var1, ToNativeContext var2) {
      return new Integer(Boolean.TRUE.equals(var1) ? 1 : 0);
   }

   public Object fromNative(Object var1, FromNativeContext var2) {
      return (Integer)var1 != 0 ? Boolean.TRUE : Boolean.FALSE;
   }

   public Class nativeType() {
      return W32APITypeMapper.class$java$lang$Integer == null
         ? (W32APITypeMapper.class$java$lang$Integer = W32APITypeMapper.class$("java.lang.Integer"))
         : W32APITypeMapper.class$java$lang$Integer;
   }
}
