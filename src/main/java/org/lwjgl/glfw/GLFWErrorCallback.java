package org.lwjgl.glfw;

import java.io.PrintStream;
import java.util.Map;
import org.jspecify.annotations.Nullable;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Callback;
import org.lwjgl.system.MemoryUtil;

public abstract class GLFWErrorCallback extends Callback implements GLFWErrorCallbackI {
   public static GLFWErrorCallback create(long var0) {
      GLFWErrorCallbackI var2 = (GLFWErrorCallbackI)Callback.get(var0);
      return (GLFWErrorCallback)(var2 instanceof GLFWErrorCallback ? (GLFWErrorCallback)var2 : new GLFWErrorCallback.Container(var0, var2));
   }

   @Nullable
   public static GLFWErrorCallback createSafe(long var0) {
      return var0 == 0L ? null : create(var0);
   }

   public static GLFWErrorCallback create(GLFWErrorCallbackI var0) {
      return (GLFWErrorCallback)(var0 instanceof GLFWErrorCallback ? (GLFWErrorCallback)var0 : new GLFWErrorCallback.Container(var0.address(), var0));
   }

   protected GLFWErrorCallback() {
      super(CIF);
   }

   GLFWErrorCallback(long var1) {
      super(var1);
   }

   public static String getDescription(long var0) {
      return MemoryUtil.memUTF8(var0);
   }

   public static GLFWErrorCallback createPrint() {
      return createPrint(APIUtil.DEBUG_STREAM);
   }

   public static GLFWErrorCallback createPrint(final PrintStream var0) {
      return new GLFWErrorCallback() {
         private Map<Integer, String> ERROR_CODES = APIUtil.apiClassTokens((var0xx, var1x) -> 65536 < var1x && var1x < 131072, null, new Class[]{GLFW.class});

         public void invoke(int var1, long var2) {
            String var4 = getDescription(var2);
            StringBuilder var5 = new StringBuilder(512);
            var5.append("[LWJGL] ")
               .append(this.ERROR_CODES.get(var1))
               .append(" error\n")
               .append("\tDescription : ")
               .append(var4)
               .append("\n")
               .append("\tStacktrace  :\n");
            StackTraceElement[] var6 = Thread.currentThread().getStackTrace();

            for (int var7 = 4; var7 < var6.length; var7++) {
               var5.append("\t\t");
               var5.append(var6[var7]);
               var5.append("\n");
            }

            var0.print(var5);
         }
      };
   }

   public static GLFWErrorCallback createThrow() {
      return new GLFWErrorCallback() {
         public void invoke(int var1, long var2) {
            throw new IllegalStateException(String.format("GLFW error [0x%X]: %s", var1, getDescription(var2)));
         }
      };
   }

   public GLFWErrorCallback set() {
      GLFW.glfwSetErrorCallback(this);
      return this;
   }

   private static final class Container extends GLFWErrorCallback {
      private final GLFWErrorCallbackI delegate;

      Container(long var1, GLFWErrorCallbackI var3) {
         super(var1);
         this.delegate = var3;
      }

      public void invoke(int var1, long var2) {
         this.delegate.invoke(var1, var2);
      }
   }
}
