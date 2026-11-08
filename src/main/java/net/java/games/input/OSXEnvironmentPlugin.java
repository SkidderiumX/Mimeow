package net.java.games.input;

import java.io.IOException;
import java.security.AccessController;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import net.java.games.input.Component.Identifier;
import net.java.games.input.Component.Identifier.Button;
import net.java.games.input.Controller.Type;
import net.java.games.util.plugins.Plugin;

public class OSXEnvironmentPlugin extends ControllerEnvironment implements Plugin {
   private static boolean supported = false;
   private final Controller[] controllers;

   static void loadLibrary(String var0) {
      AccessController.doPrivileged(new OSXEnvironmentPlugin$1(var0));
   }

   static String getPrivilegedProperty(String var0) {
      return AccessController.doPrivileged(new OSXEnvironmentPlugin$2(var0));
   }

   static String getPrivilegedProperty(String var0, String var1) {
      return AccessController.doPrivileged(new OSXEnvironmentPlugin$3(var0, var1));
   }

   private static final boolean isMacOSXEqualsOrBetterThan(int var0, int var1) {
      String var2 = System.getProperty("os.version");
      StringTokenizer var3 = new StringTokenizer(var2, ".");

      int var4;
      int var5;
      try {
         String var6 = var3.nextToken();
         String var7 = var3.nextToken();
         var4 = Integer.parseInt(var6);
         var5 = Integer.parseInt(var7);
      } catch (Exception var8) {
         logln("Exception occurred while trying to determine OS version: " + var8);
         return false;
      }

      return var4 > var0 || var4 == var0 && var5 >= var1;
   }

   public OSXEnvironmentPlugin() {
      if (this.isSupported()) {
         this.controllers = enumerateControllers();
      } else {
         this.controllers = new Controller[0];
      }
   }

   public final Controller[] getControllers() {
      return this.controllers;
   }

   public boolean isSupported() {
      return supported;
   }

   private static final void addElements(OSXHIDQueue var0, List var1, List var2, boolean var3) throws IOException {
      for (OSXHIDElement var5 : var1) {
         Object var6 = var5.getIdentifier();
         if (var6 != null) {
            if (var3) {
               if (var6 == Button._0) {
                  var6 = Button.LEFT;
               } else if (var6 == Button._1) {
                  var6 = Button.RIGHT;
               } else if (var6 == Button._2) {
                  var6 = Button.MIDDLE;
               }
            }

            OSXComponent var7 = new OSXComponent((Identifier)var6, var5);
            var2.add(var7);
            var0.addElement(var5, var7);
         }
      }
   }

   private static final Keyboard createKeyboardFromDevice(OSXHIDDevice var0, List var1) throws IOException {
      ArrayList var2 = new ArrayList();
      OSXHIDQueue var3 = var0.createQueue(32);

      try {
         addElements(var3, var1, var2, false);
      } catch (IOException var6) {
         var3.release();
         throw var6;
      }

      Component[] var4 = new Component[var2.size()];
      var2.toArray(var4);
      return new OSXKeyboard(var0, var3, var4, new Controller[0], new Rumbler[0]);
   }

   private static final Mouse createMouseFromDevice(OSXHIDDevice var0, List var1) throws IOException {
      ArrayList var2 = new ArrayList();
      OSXHIDQueue var3 = var0.createQueue(32);

      try {
         addElements(var3, var1, var2, true);
      } catch (IOException var6) {
         var3.release();
         throw var6;
      }

      Component[] var4 = new Component[var2.size()];
      var2.toArray(var4);
      OSXMouse var5 = new OSXMouse(var0, var3, var4, new Controller[0], new Rumbler[0]);
      if (var5.getPrimaryButton() != null && var5.getX() != null && var5.getY() != null) {
         return var5;
      } else {
         var3.release();
         return null;
      }
   }

   private static final AbstractController createControllerFromDevice(OSXHIDDevice var0, List var1, Type var2) throws IOException {
      ArrayList var3 = new ArrayList();
      OSXHIDQueue var4 = var0.createQueue(32);

      try {
         addElements(var4, var1, var3, false);
      } catch (IOException var7) {
         var4.release();
         throw var7;
      }

      Component[] var5 = new Component[var3.size()];
      var3.toArray(var5);
      return new OSXAbstractController(var0, var4, var5, new Controller[0], new Rumbler[0], var2);
   }

   private static final void createControllersFromDevice(OSXHIDDevice var0, List var1) throws IOException {
      UsagePair var2 = var0.getUsagePair();
      if (var2 != null) {
         List var3 = var0.getElements();
         if (var2.getUsagePage() != UsagePage.GENERIC_DESKTOP || var2.getUsage() != GenericDesktopUsage.MOUSE && var2.getUsage() != GenericDesktopUsage.POINTER
            )
          {
            if (var2.getUsagePage() != UsagePage.GENERIC_DESKTOP
               || var2.getUsage() != GenericDesktopUsage.KEYBOARD && var2.getUsage() != GenericDesktopUsage.KEYPAD) {
               if (var2.getUsagePage() == UsagePage.GENERIC_DESKTOP && var2.getUsage() == GenericDesktopUsage.JOYSTICK) {
                  AbstractController var8 = createControllerFromDevice(var0, var3, Type.STICK);
                  if (var8 != null) {
                     var1.add(var8);
                  }
               } else if (var2.getUsagePage() == UsagePage.GENERIC_DESKTOP && var2.getUsage() == GenericDesktopUsage.MULTI_AXIS_CONTROLLER) {
                  AbstractController var7 = createControllerFromDevice(var0, var3, Type.STICK);
                  if (var7 != null) {
                     var1.add(var7);
                  }
               } else if (var2.getUsagePage() == UsagePage.GENERIC_DESKTOP && var2.getUsage() == GenericDesktopUsage.GAME_PAD) {
                  AbstractController var6 = createControllerFromDevice(var0, var3, Type.GAMEPAD);
                  if (var6 != null) {
                     var1.add(var6);
                  }
               }
            } else {
               Keyboard var5 = createKeyboardFromDevice(var0, var3);
               if (var5 != null) {
                  var1.add(var5);
               }
            }
         } else {
            Mouse var4 = createMouseFromDevice(var0, var3);
            if (var4 != null) {
               var1.add(var4);
            }
         }
      }
   }

   private static final Controller[] enumerateControllers() {
      ArrayList var0 = new ArrayList();

      try {
         OSXHIDDeviceIterator var1 = new OSXHIDDeviceIterator();

         try {
            while (true) {
               try {
                  OSXHIDDevice var2 = var1.next();
                  if (var2 == null) {
                     break;
                  }

                  boolean var3 = false;

                  try {
                     int var4 = var0.size();
                     createControllersFromDevice(var2, var0);
                     var3 = var4 != var0.size();
                  } catch (IOException var10) {
                     logln("Failed to create controllers from device: " + var2.getProductName());
                  }

                  if (!var3) {
                     var2.release();
                  }
               } catch (IOException var11) {
                  logln("Failed to enumerate device: " + var11.getMessage());
               }
            }
         } finally {
            var1.close();
         }
      } catch (IOException var13) {
         log("Failed to enumerate devices: " + var13.getMessage());
         return new Controller[0];
      }

      Controller[] var14 = new Controller[var0.size()];
      var0.toArray(var14);
      return var14;
   }

   static {
      String var0 = getPrivilegedProperty("os.name", "").trim();
      if (var0.equals("Mac OS X")) {
         supported = true;
         loadLibrary("jinput-osx");
      }
   }
}
