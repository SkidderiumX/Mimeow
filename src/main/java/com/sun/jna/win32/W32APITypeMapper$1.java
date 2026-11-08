package com.sun.jna.win32;

import com.sun.jna.FromNativeContext;
import com.sun.jna.StringArray;
import com.sun.jna.ToNativeContext;
import com.sun.jna.TypeConverter;
import com.sun.jna.WString;
public class W32APITypeMapper$1 implements TypeConverter {
    static /* synthetic */ Class class$(String x0) {
        try {
            return Class.forName(x0);
        }
        catch (ClassNotFoundException x1) {
            throw new NoClassDefFoundError(x1.getMessage());
        }
    }
    static /* synthetic */ Class class$com$sun$jna$WString;

   W32APITypeMapper$1(W32APITypeMapper var1) {
      this.this$0 = var1;
   }

   public Object toNative(Object var1, ToNativeContext var2) {
      if (var1 == null) {
         return null;
      } else {
         return var1 instanceof String[] ? new StringArray((String[])var1, true) : new WString(var1.toString());
      }
   }

   public Object fromNative(Object var1, FromNativeContext var2) {
      return var1 == null ? null : var1.toString();
   }

   public Class nativeType() {
      return W32APITypeMapper.class$com$sun$jna$WString == null
         ? (W32APITypeMapper.class$com$sun$jna$WString = W32APITypeMapper.class$("com.sun.jna.WString"))
         : W32APITypeMapper.class$com$sun$jna$WString;
   }
}
