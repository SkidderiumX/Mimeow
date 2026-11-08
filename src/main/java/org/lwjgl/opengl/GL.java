package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.function.IntFunction;
import org.jspecify.annotations.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.PointerBuffer;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.Configuration;
import org.lwjgl.system.FunctionProvider;
import org.lwjgl.system.JNI;
import org.lwjgl.system.Library;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.Platform;
import org.lwjgl.system.SharedLibrary;
import org.lwjgl.system.ThreadLocalUtil;
import org.lwjgl.system.APIUtil.APIVersion;
import org.lwjgl.system.SharedLibrary.Delegate;
import org.lwjgl.system.linux.X11;
import org.lwjgl.system.windows.GDI32;
import org.lwjgl.system.windows.PIXELFORMATDESCRIPTOR;
import org.lwjgl.system.windows.User32;
import org.lwjgl.system.windows.WNDCLASSEX;
import org.lwjgl.system.windows.WindowsLibrary;
import org.lwjgl.system.windows.WindowsUtil;
import org.lwjgl.system.windows.User32.Functions;

public class GL {
   @Nullable
   private static final APIVersion MAX_VERSION = APIUtil.apiParseVersion(Configuration.OPENGL_MAXVERSION);
   @Nullable
   private static FunctionProvider functionProvider;
   private static final ThreadLocal<GLCapabilities> capabilitiesTLS = new ThreadLocal<>();
   private static GL.ICD icd = new GL.ICDStatic();
   @Nullable
   private static WGLCapabilities capabilitiesWGL;
   @Nullable
   private static GLXCapabilities capabilitiesGLXClient;
   @Nullable
   private static GLXCapabilities capabilitiesGLX;

   private GL() {
   }

   static void initialize() {
   }

   public static void create() {
      SharedLibrary var0 = null;
      String var1 = (String)Configuration.OPENGL_CONTEXT_API.get();
      boolean var2 = "EGL".equals(var1) || var1 == null && isWayland();
      if (var2) {
         var0 = loadEGL();
      } else if ("OSMesa".equals(var1)) {
         var0 = loadOSMesa();
      }

      if (var0 == null) {
         var0 = loadNative();
         if (var0 == null && !"native".equals(var1)) {
            if (!var2) {
               var0 = loadEGL();
            }

            if (var0 == null && !"OSMesa".equals(var1)) {
               var0 = loadOSMesa();
            }
         }
      }

      if (var0 == null) {
         throw new IllegalStateException("There is no OpenGL context management API available.");
      } else {
         create(var0);
      }
   }

   private static boolean isWayland() {
      switch (Platform.get()) {
         case FREEBSD:
         case LINUX:
            if ("wayland".equals(System.getenv("XDG_SESSION_TYPE")) && System.getenv("WAYLAND_DISPLAY") != null) {
               return true;
            }
         default:
            return false;
      }
   }

   @Nullable
   private static SharedLibrary loadNative() {
      try {
         return Library.loadNative(GL.class, "org.lwjgl.opengl", Configuration.OPENGL_LIBRARY_NAME, Configuration.OPENGL_LIBRARY_NAME_DEFAULTS());
      } catch (Throwable var1) {
         APIUtil.apiLog("[GL] Failed to initialize context management based on native OpenGL platform API");
         return null;
      }
   }

   @Nullable
   private static SharedLibrary loadEGL() {
      try {
         return Library.loadNative(GL.class, "org.lwjgl.opengl", Configuration.EGL_LIBRARY_NAME, Configuration.EGL_LIBRARY_NAME_DEFAULTS());
      } catch (Throwable var1) {
         APIUtil.apiLog("[GL] Failed to initialize context management based on EGL");
         return null;
      }
   }

   @Nullable
   private static SharedLibrary loadOSMesa() {
      try {
         return Library.loadNative(GL.class, "org.lwjgl.opengl", Configuration.OPENGL_OSMESA_LIBRARY_NAME, Configuration.OPENGL_OSMESA_LIBRARY_NAME_DEFAULTS());
      } catch (Throwable var1) {
         APIUtil.apiLog("[GL] Failed to initialize context management based on OSMesa");
         return null;
      }
   }

   public static void create(String var0) {
      create(Library.loadNative(GL.class, "org.lwjgl.opengl", var0));
   }

   private static void create(SharedLibrary var0) {
      try {
         create(new Delegate(var0) {
            private final long GetProcAddress;

            {
               long var2x = 0L;
               switch (Platform.get()) {
                  case FREEBSD:
                  case LINUX:
                     var2x = this.library.getFunctionAddress("glXGetProcAddress");
                     if (var2x == 0L) {
                        var2x = this.library.getFunctionAddress("glXGetProcAddressARB");
                     }
                     break;
                  case WINDOWS:
                     var2x = this.library.getFunctionAddress("wglGetProcAddress");
               }

               if (var2x == 0L) {
                  var2x = this.library.getFunctionAddress("eglGetProcAddress");
               }

               if (var2x == 0L) {
                  var2x = this.library.getFunctionAddress("OSMesaGetProcAddress");
               }

               this.GetProcAddress = var2x;
            }

            public long getFunctionAddress(ByteBuffer var1) {
               long var2x = this.GetProcAddress == 0L ? 0L : JNI.callPP(MemoryUtil.memAddress(var1), this.GetProcAddress);
               if (var2x == 0L) {
                  var2x = this.library.getFunctionAddress(var1);
                  if (var2x == 0L && Checks.DEBUG_FUNCTIONS) {
                     APIUtil.apiLogMissing("GL", var1);
                  }
               }

               return var2x;
            }
         });
      } catch (RuntimeException var2) {
         var0.free();
         throw var2;
      }
   }

   public static void create(FunctionProvider var0) {
      if (functionProvider != null) {
         throw new IllegalStateException("OpenGL library has already been loaded.");
      } else {
         functionProvider = var0;
         ThreadLocalUtil.setFunctionMissingAddresses(2228);
      }
   }

   public static void destroy() {
      if (functionProvider != null) {
         ThreadLocalUtil.setFunctionMissingAddresses(0);
         capabilitiesWGL = null;
         capabilitiesGLX = null;
         if (functionProvider instanceof NativeResource) {
            ((NativeResource)functionProvider).free();
         }

         functionProvider = null;
      }
   }

   @Nullable
   public static FunctionProvider getFunctionProvider() {
      return functionProvider;
   }

   public static void setCapabilities(@Nullable GLCapabilities var0) {
      capabilitiesTLS.set(var0);
      ThreadLocalUtil.setCapabilities(var0 == null ? 0L : MemoryUtil.memAddress(var0.addresses));
      icd.set(var0);
   }

   public static GLCapabilities getCapabilities() {
      return checkCapabilities(capabilitiesTLS.get());
   }

   private static GLCapabilities checkCapabilities(@Nullable GLCapabilities var0) {
      if (Checks.CHECKS && var0 == null) {
         throw new IllegalStateException(
            "No GLCapabilities instance set for the current thread. Possible solutions:\n\ta) Call GL.createCapabilities() after making a context current in the current thread.\n\tb) Call GL.setCapabilities() if a GLCapabilities instance already exists for the current context."
         );
      } else {
         return var0;
      }
   }

   public static WGLCapabilities getCapabilitiesWGL() {
      if (capabilitiesWGL == null) {
         capabilitiesWGL = createCapabilitiesWGLDummy();
      }

      return capabilitiesWGL;
   }

   static GLXCapabilities getCapabilitiesGLXClient() {
      if (capabilitiesGLXClient == null) {
         capabilitiesGLXClient = initCapabilitiesGLX(true);
      }

      return capabilitiesGLXClient;
   }

   public static GLXCapabilities getCapabilitiesGLX() {
      if (capabilitiesGLX == null) {
         capabilitiesGLX = initCapabilitiesGLX(false);
      }

      return capabilitiesGLX;
   }

   private static GLXCapabilities initCapabilitiesGLX(boolean var0) {
      long var1 = X11.nXOpenDisplay(0L);

      GLXCapabilities var3;
      try {
         var3 = createCapabilitiesGLX(var1, var0 ? -1 : X11.XDefaultScreen(var1));
      } finally {
         X11.XCloseDisplay(var1);
      }

      return var3;
   }

   public static GLCapabilities createCapabilities() {
      return createCapabilities(null);
   }

   public static GLCapabilities createCapabilities(@Nullable IntFunction<PointerBuffer> var0) {
      return createCapabilities(false, var0);
   }

   public static GLCapabilities createCapabilities(boolean var0) {
      return createCapabilities(var0, null);
   }

   public static GLCapabilities createCapabilities(boolean var0, @Nullable IntFunction<PointerBuffer> var1) {
      FunctionProvider var2 = functionProvider;
      if (var2 == null) {
         throw new IllegalStateException("OpenGL library has not been loaded.");
      } else {
         long var3 = var2.getFunctionAddress("glGetError");
         long var5 = var2.getFunctionAddress("glGetString");
         long var7 = var2.getFunctionAddress("glGetIntegerv");
         if (var3 != 0L && var5 != 0L && var7 != 0L) {
            int var9 = JNI.callI(var3);
            if (var9 != 0) {
               APIUtil.apiLog(String.format("An OpenGL context was in an error state before the creation of its capabilities instance. Error: 0x%X", var9));
            }

            MemoryStack var12 = MemoryStack.stackPush();
            Throwable var13 = null;

            int var10;
            int var11;
            try {
               IntBuffer var14 = var12.ints(0);
               JNI.callPV(33307, MemoryUtil.memAddress(var14), var7);
               if (JNI.callI(var3) == 0 && 3 <= (var10 = var14.get(0))) {
                  JNI.callPV(33308, MemoryUtil.memAddress(var14), var7);
                  var11 = var14.get(0);
               } else {
                  String var15 = MemoryUtil.memUTF8Safe(JNI.callP(7938, var5));
                  if (var15 == null || JNI.callI(var3) != 0) {
                     throw new IllegalStateException("There is no OpenGL context current in the current thread.");
                  }

                  APIVersion var16 = APIUtil.apiParseVersion(var15);
                  var10 = var16.major;
                  var11 = var16.minor;
               }
            } catch (Throwable var43) {
               var13 = var43;
               throw var43;
            } finally {
               if (var12 != null) {
                  if (var13 != null) {
                     try {
                        var12.close();
                     } catch (Throwable var40) {
                        var13.addSuppressed(var40);
                     }
                  } else {
                     var12.close();
                  }
               }
            }

            if (var10 >= 1 && (var10 != 1 || var11 >= 1)) {
               int[] var45 = new int[]{5, 1, 3, 6};
               HashSet var46 = new HashSet(512);
               int var47 = Math.min(var10, var45.length);
               if (MAX_VERSION != null) {
                  var47 = Math.min(MAX_VERSION.major, var47);
               }

               for (int var48 = 1; var48 <= var47; var48++) {
                  int var52 = var45[var48 - 1];
                  if (var48 == var10) {
                     var52 = Math.min(var11, var52);
                  }

                  if (MAX_VERSION != null && var48 == MAX_VERSION.major) {
                     var52 = Math.min(MAX_VERSION.minor, var52);
                  }

                  for (int var17 = var48 == 1 ? 1 : 0; var17 <= var52; var17++) {
                     var46.add("OpenGL" + var48 + var17);
                  }
               }

               if (var10 < 3) {
                  String var49 = MemoryUtil.memASCIISafe(JNI.callP(7939, var5));
                  if (var49 != null) {
                     StringTokenizer var53 = new StringTokenizer(var49);

                     while (var53.hasMoreTokens()) {
                        var46.add(var53.nextToken());
                     }
                  }
               } else {
                  MemoryStack var50 = MemoryStack.stackPush();
                  Throwable var54 = null;

                  try {
                     IntBuffer var55 = var50.ints(0);
                     JNI.callPV(33309, MemoryUtil.memAddress(var55), var7);
                     int var18 = var55.get(0);
                     long var19 = APIUtil.apiGetFunctionAddress(var2, "glGetStringi");

                     for (int var21 = 0; var21 < var18; var21++) {
                        var46.add(MemoryUtil.memASCII(JNI.callP(7939, var21, var19)));
                     }

                     JNI.callPV(33310, MemoryUtil.memAddress(var55), var7);
                     if ((var55.get(0) & 1) != 0) {
                        var0 = true;
                     } else if (3 < var10 || 1 <= var11) {
                        if (3 >= var10 && 2 > var11) {
                           var0 = !var46.contains("GL_ARB_compatibility");
                        } else {
                           JNI.callPV(37158, MemoryUtil.memAddress(var55), var7);
                           if ((var55.get(0) & 1) != 0) {
                              var0 = true;
                           }
                        }
                     }
                  } catch (Throwable var41) {
                     var54 = var41;
                     throw var41;
                  } finally {
                     if (var50 != null) {
                        if (var54 != null) {
                           try {
                              var50.close();
                           } catch (Throwable var39) {
                              var54.addSuppressed(var39);
                           }
                        } else {
                           var50.close();
                        }
                     }
                  }
               }

               APIUtil.apiFilterExtensions(var46, Configuration.OPENGL_EXTENSION_FILTER);
               GLCapabilities var51 = new GLCapabilities(var2, var46, var0, var1 == null ? BufferUtils::createPointerBuffer : var1);
               setCapabilities(var51);
               return var51;
            } else {
               throw new IllegalStateException("OpenGL 1.1 is required.");
            }
         } else {
            throw new IllegalStateException("Core OpenGL functions could not be found. Make sure that the OpenGL library has been loaded correctly.");
         }
      }
   }

   private static WGLCapabilities createCapabilitiesWGLDummy() {
      long var0 = WGL.wglGetCurrentDC();
      if (var0 != 0L) {
         return createCapabilitiesWGL(var0);
      } else {
         short var2 = 0;
         long var3 = 0L;
         long var5 = 0L;

         WGLCapabilities var13;
         try {
            MemoryStack var7 = MemoryStack.stackPush();
            Throwable var8 = null;

            try {
               IntBuffer var9 = var7.mallocInt(1);
               WNDCLASSEX var10 = WNDCLASSEX.calloc(var7)
                  .cbSize(WNDCLASSEX.SIZEOF)
                  .style(3)
                  .hInstance(WindowsLibrary.HINSTANCE)
                  .lpszClassName(var7.UTF16("WGL"));
               MemoryUtil.memPutAddress(var10.address() + WNDCLASSEX.LPFNWNDPROC, Functions.DefWindowProc);
               var2 = User32.RegisterClassEx(var9, var10);
               if (var2 == 0) {
                  WindowsUtil.windowsThrowException("Failed to register WGL window class", var9);
               }

               var3 = User32.nCreateWindowEx(MemoryUtil.memAddress(var9), 0, var2 & '\uffff', 0L, 114229248, 0, 0, 1, 1, 0L, 0L, 0L, 0L);
               if (var3 == 0L) {
                  WindowsUtil.windowsThrowException("Failed to create WGL window", var9);
               }

               var0 = Checks.check(User32.GetDC(var3));
               PIXELFORMATDESCRIPTOR var11 = PIXELFORMATDESCRIPTOR.calloc(var7).nSize((short)PIXELFORMATDESCRIPTOR.SIZEOF).nVersion((short)1).dwFlags(32);
               int var12 = GDI32.ChoosePixelFormat(var9, var0, var11);
               if (var12 == 0) {
                  WindowsUtil.windowsThrowException("Failed to choose an OpenGL-compatible pixel format", var9);
               }

               if (GDI32.DescribePixelFormat(var9, var0, var12, var11) == 0) {
                  WindowsUtil.windowsThrowException("Failed to obtain pixel format information", var9);
               }

               if (!GDI32.SetPixelFormat(var9, var0, var12, var11)) {
                  WindowsUtil.windowsThrowException("Failed to set the pixel format", var9);
               }

               var5 = Checks.check(WGL.wglCreateContext(null, var0));
               if (!WGL.wglMakeCurrent(var9, var0, var5)) {
                  WindowsUtil.windowsThrowException("Failed to make context current", var9);
               }

               var13 = createCapabilitiesWGL(var0);
            } catch (Throwable var29) {
               var8 = var29;
               throw var29;
            } finally {
               if (var7 != null) {
                  if (var8 != null) {
                     try {
                        var7.close();
                     } catch (Throwable var28) {
                        var8.addSuppressed(var28);
                     }
                  } else {
                     var7.close();
                  }
               }
            }
         } finally {
            if (var5 != 0L) {
               WGL.wglMakeCurrent(null, 0L, 0L);
               WGL.wglDeleteContext(null, var5);
            }

            if (var3 != 0L) {
               User32.DestroyWindow(null, var3);
            }

            if (var2 != 0) {
               User32.nUnregisterClass(0L, var2 & '\uffff', WindowsLibrary.HINSTANCE);
            }
         }

         return var13;
      }
   }

   public static WGLCapabilities createCapabilitiesWGL() {
      long var0 = WGL.wglGetCurrentDC();
      if (var0 == 0L) {
         throw new IllegalStateException("Failed to retrieve the device context of the current OpenGL context");
      } else {
         return createCapabilitiesWGL(var0);
      }
   }

   private static WGLCapabilities createCapabilitiesWGL(long var0) {
      FunctionProvider var2 = functionProvider;
      if (var2 == null) {
         throw new IllegalStateException("OpenGL library has not been loaded.");
      } else {
         String var3 = null;
         long var4 = var2.getFunctionAddress("wglGetExtensionsStringARB");
         if (var4 != 0L) {
            var3 = MemoryUtil.memASCII(JNI.callPP(var0, var4));
         } else {
            var4 = var2.getFunctionAddress("wglGetExtensionsStringEXT");
            if (var4 != 0L) {
               var3 = MemoryUtil.memASCII(JNI.callP(var4));
            }
         }

         HashSet var6 = new HashSet(32);
         if (var3 != null) {
            StringTokenizer var7 = new StringTokenizer(var3);

            while (var7.hasMoreTokens()) {
               var6.add(var7.nextToken());
            }
         }

         APIUtil.apiFilterExtensions(var6, Configuration.OPENGL_EXTENSION_FILTER);
         return new WGLCapabilities(var2, var6);
      }
   }

   public static GLXCapabilities createCapabilitiesGLX(long var0) {
      return createCapabilitiesGLX(var0, X11.XDefaultScreen(var0));
   }

   public static GLXCapabilities createCapabilitiesGLX(long var0, int var2) {
      FunctionProvider var3 = functionProvider;
      if (var3 == null) {
         throw new IllegalStateException("OpenGL library has not been loaded.");
      } else {
         MemoryStack var6 = MemoryStack.stackPush();
         Throwable var7 = null;

         int var4;
         int var5;
         try {
            IntBuffer var8 = var6.ints(0);
            IntBuffer var9 = var6.ints(0);
            if (!GLX11.glXQueryVersion(var0, var8, var9)) {
               throw new IllegalStateException("Failed to query GLX version");
            }

            var4 = var8.get(0);
            var5 = var9.get(0);
            if (var4 != 1) {
               throw new IllegalStateException("Invalid GLX major version: " + var4);
            }
         } catch (Throwable var19) {
            var7 = var19;
            throw var19;
         } finally {
            if (var6 != null) {
               if (var7 != null) {
                  try {
                     var6.close();
                  } catch (Throwable var18) {
                     var7.addSuppressed(var18);
                  }
               } else {
                  var6.close();
               }
            }
         }

         HashSet var21 = new HashSet(32);
         int[][] var22 = new int[][]{{1, 2, 3, 4}};

         for (int var23 = 1; var23 <= var22.length; var23++) {
            int[] var25 = var22[var23 - 1];

            for (int var13 : var25) {
               if (var23 < var4 || var23 == var4 && var13 <= var5) {
                  var21.add("GLX" + var23 + var13);
               }
            }
         }

         if (1 <= var5) {
            String var24;
            if (var2 == -1) {
               long var26 = var3.getFunctionAddress("glXGetClientString");
               var24 = MemoryUtil.memASCIISafe(JNI.callPP(var0, 3, var26));
            } else {
               long var27 = var3.getFunctionAddress("glXQueryExtensionsString");
               var24 = MemoryUtil.memASCIISafe(JNI.callPP(var0, var2, var27));
            }

            if (var24 != null) {
               StringTokenizer var28 = new StringTokenizer(var24);

               while (var28.hasMoreTokens()) {
                  var21.add(var28.nextToken());
               }
            }
         }

         APIUtil.apiFilterExtensions(var21, Configuration.OPENGL_EXTENSION_FILTER);
         return new GLXCapabilities(var3, var21);
      }
   }

   static GLCapabilities getICD() {
      return checkCapabilities(icd.get());
   }

   static {
      Library.loadSystem(System::load, System::loadLibrary, GL.class, "org.lwjgl.opengl", Platform.mapLibraryNameBundled("lwjgl_opengl"));
      if (!(Boolean)Configuration.OPENGL_EXPLICIT_INIT.get(false)) {
         create();
      }
   }

   private interface ICD {
      default void set(@Nullable GLCapabilities var1) {
      }

      @Nullable
      GLCapabilities get();
   }

   private static class ICDStatic implements GL.ICD {
      @Nullable
      private static GLCapabilities tempCaps;

      private ICDStatic() {
      }

      @Override
      public void set(@Nullable GLCapabilities var1) {
         if (tempCaps == null) {
            tempCaps = var1;
         } else if (var1 != null && var1 != tempCaps && ThreadLocalUtil.areCapabilitiesDifferent(tempCaps.addresses, var1.addresses)) {
            APIUtil.apiLog("[WARNING] Incompatible context detected. Falling back to thread-local lookup for GL contexts.");
            GL.icd = GL::getCapabilities;
         }
      }

      @Override
      public GLCapabilities get() {
         return GL.ICDStatic.WriteOnce.caps;
      }

      private static final class WriteOnce {
         static final GLCapabilities caps;

         static {
            GLCapabilities var0 = GL.ICDStatic.tempCaps;
            if (var0 == null) {
               throw new IllegalStateException("No GLCapabilities instance has been set");
            } else {
               caps = var0;
            }
         }
      }
   }
}
