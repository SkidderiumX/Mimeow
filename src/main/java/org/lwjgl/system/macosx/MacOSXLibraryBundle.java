package org.lwjgl.system.macosx;

import java.nio.ByteBuffer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryStack;

public class MacOSXLibraryBundle extends MacOSXLibrary {
   public MacOSXLibraryBundle(String var1, long var2) {
      super(var1, var2);
   }

   public static MacOSXLibraryBundle getWithIdentifier(String var0) {
      long var1 = 0L;

      MacOSXLibraryBundle var7;
      try {
         MemoryStack var3 = MemoryStack.stackPush();
         Throwable var4 = null;

         try {
            var1 = CString2CFString(var3.UTF8(var0), 134217984);
            long var5 = CoreFoundation.CFBundleGetBundleWithIdentifier(var1);
            if (var5 == 0L) {
               throw new UnsatisfiedLinkError("Failed to retrieve bundle with identifier: " + var0);
            }

            CoreFoundation.CFRetain(var5);
            var7 = new MacOSXLibraryBundle(var0, var5);
         } catch (Throwable var23) {
            var4 = var23;
            throw var23;
         } finally {
            if (var3 != null) {
               if (var4 != null) {
                  try {
                     var3.close();
                  } catch (Throwable var22) {
                     var4.addSuppressed(var22);
                  }
               } else {
                  var3.close();
               }
            }
         }
      } finally {
         if (var1 != 0L) {
            CoreFoundation.CFRelease(var1);
         }
      }

      return var7;
   }

   public static MacOSXLibraryBundle create(String var0) {
      long var1 = 0L;
      long var3 = 0L;

      MacOSXLibraryBundle var9;
      try {
         MemoryStack var5 = MemoryStack.stackPush();
         Throwable var6 = null;

         try {
            var1 = CString2CFString(var5.UTF8(var0), 134217984);
            var3 = Checks.check(CoreFoundation.CFURLCreateWithFileSystemPath(0L, var1, 0L, true));
            long var7 = CoreFoundation.CFBundleCreate(0L, var3);
            if (var7 == 0L) {
               throw new UnsatisfiedLinkError("Failed to create bundle: " + var0);
            }

            var9 = new MacOSXLibraryBundle(var0, var7);
         } catch (Throwable var25) {
            var6 = var25;
            throw var25;
         } finally {
            if (var5 != null) {
               if (var6 != null) {
                  try {
                     var5.close();
                  } catch (Throwable var24) {
                     var6.addSuppressed(var24);
                  }
               } else {
                  var5.close();
               }
            }
         }
      } finally {
         if (var3 != 0L) {
            CoreFoundation.CFRelease(var3);
         }

         if (var1 != 0L) {
            CoreFoundation.CFRelease(var1);
         }
      }

      return var9;
   }

   @Nullable
   public String getPath() {
      return null;
   }

   public long getFunctionAddress(ByteBuffer var1) {
      long var2 = CString2CFString(var1, 1536);

      long var4;
      try {
         var4 = CoreFoundation.CFBundleGetFunctionPointerForName(this.address(), var2);
      } finally {
         CoreFoundation.CFRelease(var2);
      }

      return var4;
   }

   private static long CString2CFString(ByteBuffer var0, int var1) {
      return Checks.check(CoreFoundation.CFStringCreateWithCStringNoCopy(0L, var0, var1, CoreFoundation.kCFAllocatorNull));
   }

   public void free() {
      CoreFoundation.CFRelease(this.address());
   }
}
