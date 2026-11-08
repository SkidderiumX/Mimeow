package com.sun.jna.win32;

import com.sun.jna.DefaultTypeMapper;
import com.sun.jna.TypeMapper;

public class W32APITypeMapper extends DefaultTypeMapper {
   public static final TypeMapper UNICODE = new W32APITypeMapper(true);
   public static final TypeMapper ASCII = new W32APITypeMapper(false);

   protected W32APITypeMapper(boolean var1) {
      if (var1) {
         W32APITypeMapper$1 var2 = new W32APITypeMapper$1(this);
         this.addTypeConverter(String.class, var2);
         this.addToNativeConverter(String[].class, var2);
      }

      W32APITypeMapper$2 var3 = new W32APITypeMapper$2(this);
      this.addTypeConverter(Boolean.class, var3);
   }
}
