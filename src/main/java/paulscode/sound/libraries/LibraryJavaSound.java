package paulscode.sound.libraries;

import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Set;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.FloatControl.Type;
import javax.sound.sampled.Mixer.Info;
import paulscode.sound.Channel;
import paulscode.sound.FilenameURL;
import paulscode.sound.ICodec;
import paulscode.sound.Library;
import paulscode.sound.SoundBuffer;
import paulscode.sound.SoundSystem;
import paulscode.sound.SoundSystemConfig;
import paulscode.sound.SoundSystemException;
import paulscode.sound.Source;

public class LibraryJavaSound extends Library {
   private static final boolean GET = false;
   private static final boolean SET = true;
   private static final int XXX = 0;
   private final int maxClipSize = 1048576;
   private static Mixer myMixer = null;
   private static LibraryJavaSound.MixerRanking myMixerRanking = null;
   private static LibraryJavaSound instance = null;
   private static int minSampleRate = 4000;
   private static int maxSampleRate = 48000;
   private static int lineCount = 32;
   private static boolean useGainControl = true;
   private static boolean usePanControl = true;
   private static boolean useSampleRateControl = true;

   public LibraryJavaSound() throws SoundSystemException {
      instance = this;
   }

   public void init() throws SoundSystemException {
      LibraryJavaSound.MixerRanking var1 = null;
      if (myMixer == null) {
         for (Info var5 : AudioSystem.getMixerInfo()) {
            if (var5.getName().equals("Java Sound Audio Engine")) {
               var1 = new LibraryJavaSound.MixerRanking();

               try {
                  var1.rank(var5);
               } catch (LibraryJavaSound.Exception var10) {
                  break;
               }

               if (var1.rank >= 14) {
                  myMixer = AudioSystem.getMixer(var5);
                  mixerRanking(true, var1);
               }
               break;
            }
         }

         if (myMixer == null) {
            LibraryJavaSound.MixerRanking var12 = var1;

            for (Info var6 : AudioSystem.getMixerInfo()) {
               var1 = new LibraryJavaSound.MixerRanking();

               try {
                  var1.rank(var6);
               } catch (LibraryJavaSound.Exception var9) {
               }

               if (var12 == null || var1.rank > var12.rank) {
                  var12 = var1;
               }
            }

            if (var12 == null) {
               throw new LibraryJavaSound.Exception("No useable mixers found!", new LibraryJavaSound.MixerRanking());
            }

            try {
               myMixer = AudioSystem.getMixer(var12.mixerInfo);
               mixerRanking(true, var12);
            } catch (java.lang.Exception var8) {
               throw new LibraryJavaSound.Exception("No useable mixers available!", new LibraryJavaSound.MixerRanking());
            }
         }
      }

      this.setMasterVolume(1.0F);
      this.message("JavaSound initialized.");
      super.init();
   }

   public static boolean libraryCompatible() {
      for (Info var3 : AudioSystem.getMixerInfo()) {
         if (var3.getName().equals("Java Sound Audio Engine")) {
            return true;
         }
      }

      return false;
   }

   protected Channel createChannel(int var1) {
      return new ChannelJavaSound(var1, myMixer);
   }

   public void cleanup() {
      super.cleanup();
      instance = null;
      myMixer = null;
      myMixerRanking = null;
   }

   public boolean loadSound(FilenameURL var1) {
      if (this.bufferMap == null) {
         this.bufferMap = new HashMap();
         this.importantMessage("Buffer Map was null in method 'loadSound'");
      }

      if (this.errorCheck(var1 == null, "Filename/URL not specified in method 'loadSound'")) {
         return false;
      } else if (this.bufferMap.get(var1.getFilename()) != null) {
         return true;
      } else {
         ICodec var2 = SoundSystemConfig.getCodec(var1.getFilename());
         if (this.errorCheck(var2 == null, "No codec found for file '" + var1.getFilename() + "' in method 'loadSound'")) {
            return false;
         } else {
            URL var3 = var1.getURL();
            if (this.errorCheck(var3 == null, "Unable to open file '" + var1.getFilename() + "' in method 'loadSound'")) {
               return false;
            } else {
               var2.initialize(var3);
               SoundBuffer var4 = var2.readAll();
               var2.cleanup();
               Object var5 = null;
               if (var4 != null) {
                  this.bufferMap.put(var1.getFilename(), var4);
               } else {
                  this.errorMessage("Sound buffer null in method 'loadSound'");
               }

               return true;
            }
         }
      }
   }

   public boolean loadSound(SoundBuffer var1, String var2) {
      if (this.bufferMap == null) {
         this.bufferMap = new HashMap();
         this.importantMessage("Buffer Map was null in method 'loadSound'");
      }

      if (this.errorCheck(var2 == null, "Identifier not specified in method 'loadSound'")) {
         return false;
      } else if (this.bufferMap.get(var2) != null) {
         return true;
      } else {
         if (var1 != null) {
            this.bufferMap.put(var2, var1);
         } else {
            this.errorMessage("Sound buffer null in method 'loadSound'");
         }

         return true;
      }
   }

   public void setMasterVolume(float var1) {
      super.setMasterVolume(var1);

      for (String var4 : this.sourceMap.keySet()) {
         Source var5 = (Source)this.sourceMap.get(var4);
         if (var5 != null) {
            var5.positionChanged();
         }
      }
   }

   public void newSource(boolean var1, boolean var2, boolean var3, String var4, FilenameURL var5, float var6, float var7, float var8, int var9, float var10) {
      SoundBuffer var11 = null;
      if (!var2) {
         var11 = (SoundBuffer)this.bufferMap.get(var5.getFilename());
         if (var11 == null && !this.loadSound(var5)) {
            this.errorMessage("Source '" + var4 + "' was not created " + "because an error occurred while loading " + var5.getFilename());
            return;
         }

         var11 = (SoundBuffer)this.bufferMap.get(var5.getFilename());
         if (var11 == null) {
            this.errorMessage("Source '" + var4 + "' was not created " + "because audio data was not found for " + var5.getFilename());
            return;
         }
      }

      if (!var2 && var11 != null) {
         var11.trimData(1048576);
      }

      this.sourceMap.put(var4, new SourceJavaSound(this.listener, var1, var2, var3, var4, var5, var11, var6, var7, var8, var9, var10, false));
   }

   public void rawDataStream(AudioFormat var1, boolean var2, String var3, float var4, float var5, float var6, int var7, float var8) {
      this.sourceMap.put(var3, new SourceJavaSound(this.listener, var1, var2, var3, var4, var5, var6, var7, var8));
   }

   public void quickPlay(
      boolean var1, boolean var2, boolean var3, String var4, FilenameURL var5, float var6, float var7, float var8, int var9, float var10, boolean var11
   ) {
      SoundBuffer var12 = null;
      if (!var2) {
         var12 = (SoundBuffer)this.bufferMap.get(var5.getFilename());
         if (var12 == null && !this.loadSound(var5)) {
            this.errorMessage("Source '" + var4 + "' was not created " + "because an error occurred while loading " + var5.getFilename());
            return;
         }

         var12 = (SoundBuffer)this.bufferMap.get(var5.getFilename());
         if (var12 == null) {
            this.errorMessage("Source '" + var4 + "' was not created " + "because audio data was not found for " + var5.getFilename());
            return;
         }
      }

      if (!var2 && var12 != null) {
         var12.trimData(1048576);
      }

      this.sourceMap.put(var4, new SourceJavaSound(this.listener, var1, var2, var3, var4, var5, var12, var6, var7, var8, var9, var10, var11));
   }

   public void copySources(HashMap<String, Source> var1) {
      if (var1 != null) {
         Set var2 = var1.keySet();
         Iterator var3 = var2.iterator();
         if (this.bufferMap == null) {
            this.bufferMap = new HashMap();
            this.importantMessage("Buffer Map was null in method 'copySources'");
         }

         this.sourceMap.clear();

         while (var3.hasNext()) {
            String var4 = (String)var3.next();
            Source var5 = (Source)var1.get(var4);
            if (var5 != null) {
               SoundBuffer var6 = null;
               if (!var5.toStream) {
                  this.loadSound(var5.filenameURL);
                  var6 = (SoundBuffer)this.bufferMap.get(var5.filenameURL.getFilename());
               }

               if (!var5.toStream && var6 != null) {
                  var6.trimData(1048576);
               }

               if (var5.toStream || var6 != null) {
                  this.sourceMap.put(var4, new SourceJavaSound(this.listener, var5, var6));
               }
            }
         }
      }
   }

   public void setListenerVelocity(float var1, float var2, float var3) {
      super.setListenerVelocity(var1, var2, var3);
      this.listenerMoved();
   }

   public void dopplerChanged() {
      super.dopplerChanged();
      this.listenerMoved();
   }

   public static Mixer getMixer() {
      return mixer(false, null);
   }

   public static void setMixer(Mixer var0) throws SoundSystemException {
      mixer(true, var0);
      SoundSystemException var1 = SoundSystem.getLastException();
      SoundSystem.setException(null);
      if (var1 != null) {
         throw var1;
      }
   }

   private static synchronized Mixer mixer(boolean var0, Mixer var1) {
      if (var0) {
         if (var1 == null) {
            return myMixer;
         }

         LibraryJavaSound.MixerRanking var2 = new LibraryJavaSound.MixerRanking();

         try {
            var2.rank(var1.getMixerInfo());
         } catch (LibraryJavaSound.Exception var5) {
            SoundSystemConfig.getLogger().printStackTrace(var5, 1);
            SoundSystem.setException(var5);
         }

         myMixer = var1;
         mixerRanking(true, var2);
         if (instance != null) {
            ListIterator var4 = instance.normalChannels.listIterator();
            SoundSystem.setException(null);

            while (var4.hasNext()) {
               ChannelJavaSound var3 = (ChannelJavaSound)var4.next();
               var3.newMixer(var1);
            }

            for (ChannelJavaSound var6 : instance.streamingChannels) {
               var6.newMixer(var1);
            }
         }
      }

      return myMixer;
   }

   public static LibraryJavaSound.MixerRanking getMixerRanking() {
      return mixerRanking(false, null);
   }

   private static synchronized LibraryJavaSound.MixerRanking mixerRanking(boolean var0, LibraryJavaSound.MixerRanking var1) {
      if (var0) {
         myMixerRanking = var1;
      }

      return myMixerRanking;
   }

   public static void setMinSampleRate(int var0) {
      minSampleRate(true, var0);
   }

   private static synchronized int minSampleRate(boolean var0, int var1) {
      if (var0) {
         minSampleRate = var1;
      }

      return minSampleRate;
   }

   public static void setMaxSampleRate(int var0) {
      maxSampleRate(true, var0);
   }

   private static synchronized int maxSampleRate(boolean var0, int var1) {
      if (var0) {
         maxSampleRate = var1;
      }

      return maxSampleRate;
   }

   public static void setLineCount(int var0) {
      lineCount(true, var0);
   }

   private static synchronized int lineCount(boolean var0, int var1) {
      if (var0) {
         lineCount = var1;
      }

      return lineCount;
   }

   public static void useGainControl(boolean var0) {
      useGainControl(true, var0);
   }

   private static synchronized boolean useGainControl(boolean var0, boolean var1) {
      if (var0) {
         useGainControl = var1;
      }

      return useGainControl;
   }

   public static void usePanControl(boolean var0) {
      usePanControl(true, var0);
   }

   private static synchronized boolean usePanControl(boolean var0, boolean var1) {
      if (var0) {
         usePanControl = var1;
      }

      return usePanControl;
   }

   public static void useSampleRateControl(boolean var0) {
      useSampleRateControl(true, var0);
   }

   private static synchronized boolean useSampleRateControl(boolean var0, boolean var1) {
      if (var0) {
         useSampleRateControl = var1;
      }

      return useSampleRateControl;
   }

   public static String getTitle() {
      return "Java Sound";
   }

   public static String getDescription() {
      return "The Java Sound API.  For more information, see http://java.sun.com/products/java-media/sound/";
   }

   public String getClassName() {
      return "LibraryJavaSound";
   }

   public static class Exception extends SoundSystemException {
      public static final int MIXER_PROBLEM = 101;
      public static LibraryJavaSound.MixerRanking mixerRanking = null;

      public Exception(String var1) {
         super(var1);
      }

      public Exception(String var1, int var2) {
         super(var1, var2);
      }

      public Exception(String var1, LibraryJavaSound.MixerRanking var2) {
         super(var1, 101);
         mixerRanking = var2;
      }
   }

   public static class MixerRanking {
      public static final int HIGH = 1;
      public static final int MEDIUM = 2;
      public static final int LOW = 3;
      public static final int NONE = 4;
      public static int MIXER_EXISTS_PRIORITY = 1;
      public static int MIN_SAMPLE_RATE_PRIORITY = 1;
      public static int MAX_SAMPLE_RATE_PRIORITY = 1;
      public static int LINE_COUNT_PRIORITY = 1;
      public static int GAIN_CONTROL_PRIORITY = 2;
      public static int PAN_CONTROL_PRIORITY = 2;
      public static int SAMPLE_RATE_CONTROL_PRIORITY = 3;
      public Info mixerInfo = null;
      public int rank = 0;
      public boolean mixerExists = false;
      public boolean minSampleRateOK = false;
      public boolean maxSampleRateOK = false;
      public boolean lineCountOK = false;
      public boolean gainControlOK = false;
      public boolean panControlOK = false;
      public boolean sampleRateControlOK = false;
      public int minSampleRatePossible = -1;
      public int maxSampleRatePossible = -1;
      public int maxLinesPossible = 0;

      public MixerRanking() {
      }

      public MixerRanking(Info var1, int var2, boolean var3, boolean var4, boolean var5, boolean var6, boolean var7, boolean var8, boolean var9) {
         this.mixerInfo = var1;
         this.rank = var2;
         this.mixerExists = var3;
         this.minSampleRateOK = var4;
         this.maxSampleRateOK = var5;
         this.lineCountOK = var6;
         this.gainControlOK = var7;
         this.panControlOK = var8;
         this.sampleRateControlOK = var9;
      }

      public void rank(Info var1) throws LibraryJavaSound.Exception {
         if (var1 == null) {
            throw new LibraryJavaSound.Exception("No Mixer info specified in method 'MixerRanking.rank'", this);
         } else {
            this.mixerInfo = var1;

            Mixer var2;
            try {
               var2 = AudioSystem.getMixer(this.mixerInfo);
            } catch (java.lang.Exception var17) {
               throw new LibraryJavaSound.Exception("Unable to acquire the specified Mixer in method 'MixerRanking.rank'", this);
            }

            if (var2 == null) {
               throw new LibraryJavaSound.Exception("Unable to acquire the specified Mixer in method 'MixerRanking.rank'", this);
            } else {
               this.mixerExists = true;

               javax.sound.sampled.DataLine.Info var4;
               try {
                  AudioFormat var3 = new AudioFormat(LibraryJavaSound.minSampleRate(false, 0), 16, 2, true, false);
                  var4 = new javax.sound.sampled.DataLine.Info(SourceDataLine.class, var3);
               } catch (java.lang.Exception var16) {
                  throw new LibraryJavaSound.Exception("Invalid minimum sample-rate specified in method 'MixerRanking.rank'", this);
               }

               if (!AudioSystem.isLineSupported(var4)) {
                  if (MIN_SAMPLE_RATE_PRIORITY == 1) {
                     throw new LibraryJavaSound.Exception("Specified minimum sample-rate not possible for Mixer '" + this.mixerInfo.getName() + "'", this);
                  }
               } else {
                  this.minSampleRateOK = true;
               }

               try {
                  AudioFormat var20 = new AudioFormat(LibraryJavaSound.maxSampleRate(false, 0), 16, 2, true, false);
                  var4 = new javax.sound.sampled.DataLine.Info(SourceDataLine.class, var20);
               } catch (java.lang.Exception var15) {
                  throw new LibraryJavaSound.Exception("Invalid maximum sample-rate specified in method 'MixerRanking.rank'", this);
               }

               if (!AudioSystem.isLineSupported(var4)) {
                  if (MAX_SAMPLE_RATE_PRIORITY == 1) {
                     throw new LibraryJavaSound.Exception("Specified maximum sample-rate not possible for Mixer '" + this.mixerInfo.getName() + "'", this);
                  }
               } else {
                  this.maxSampleRateOK = true;
               }

               if (this.minSampleRateOK) {
                  this.minSampleRatePossible = LibraryJavaSound.minSampleRate(false, 0);
               } else {
                  int var5 = LibraryJavaSound.minSampleRate(false, 0);
                  int var6 = LibraryJavaSound.maxSampleRate(false, 0);

                  while (var6 - var5 > 1) {
                     int var7 = var5 + (var6 - var5) / 2;
                     AudioFormat var21 = new AudioFormat(var7, 16, 2, true, false);
                     var4 = new javax.sound.sampled.DataLine.Info(SourceDataLine.class, var21);
                     if (AudioSystem.isLineSupported(var4)) {
                        this.minSampleRatePossible = var7;
                        var6 = var7;
                     } else {
                        var5 = var7;
                     }
                  }
               }

               if (this.maxSampleRateOK) {
                  this.maxSampleRatePossible = LibraryJavaSound.maxSampleRate(false, 0);
               } else if (this.minSampleRatePossible != -1) {
                  int var31 = LibraryJavaSound.maxSampleRate(false, 0);
                  int var30 = this.minSampleRatePossible;

                  while (var31 - var30 > 1) {
                     int var32 = var30 + (var31 - var30) / 2;
                     AudioFormat var22 = new AudioFormat(var32, 16, 2, true, false);
                     var4 = new javax.sound.sampled.DataLine.Info(SourceDataLine.class, var22);
                     if (AudioSystem.isLineSupported(var4)) {
                        this.maxSampleRatePossible = var32;
                        var30 = var32;
                     } else {
                        var31 = var32;
                     }
                  }
               }

               if (this.minSampleRatePossible != -1 && this.maxSampleRatePossible != -1) {
                  AudioFormat var23 = new AudioFormat(this.minSampleRatePossible, 16, 2, true, false);
                  Clip var8 = null;

                  try {
                     javax.sound.sampled.DataLine.Info var9 = new javax.sound.sampled.DataLine.Info(Clip.class, var23);
                     var8 = (Clip)var2.getLine(var9);
                     byte[] var10 = new byte[10];
                     var8.open(var23, var10, 0, var10.length);
                  } catch (java.lang.Exception var14) {
                     throw new LibraryJavaSound.Exception(
                        "Unable to attach an actual audio buffer to an actual Clip... Mixer '" + this.mixerInfo.getName() + "' is unuseable.", this
                     );
                  }

                  this.maxLinesPossible = 1;
                  var4 = new javax.sound.sampled.DataLine.Info(SourceDataLine.class, var23);
                  SourceDataLine[] var35 = new SourceDataLine[LibraryJavaSound.lineCount(false, 0) - 1];
                  boolean var37 = false;

                  for (int var11 = 1; var11 < var35.length + 1; var11++) {
                     try {
                        var35[var11 - 1] = (SourceDataLine)var2.getLine(var4);
                     } catch (java.lang.Exception var18) {
                        if (var11 == 0) {
                           throw new LibraryJavaSound.Exception("No output lines possible for Mixer '" + this.mixerInfo.getName() + "'", this);
                        }

                        if (LINE_COUNT_PRIORITY == 1) {
                           throw new LibraryJavaSound.Exception(
                              "Specified maximum number of lines not possible for Mixer '" + this.mixerInfo.getName() + "'", this
                           );
                        }
                        break;
                     }

                     this.maxLinesPossible = var11 + 1;
                  }

                  try {
                     var8.close();
                  } catch (java.lang.Exception var13) {
                  }

                  var8 = null;
                  if (this.maxLinesPossible == LibraryJavaSound.lineCount(false, 0)) {
                     this.lineCountOK = true;
                  }

                  if (!LibraryJavaSound.useGainControl(false, false)) {
                     GAIN_CONTROL_PRIORITY = 4;
                  } else if (!var35[0].isControlSupported(Type.MASTER_GAIN)) {
                     if (GAIN_CONTROL_PRIORITY == 1) {
                        throw new LibraryJavaSound.Exception("Gain control not available for Mixer '" + this.mixerInfo.getName() + "'", this);
                     }
                  } else {
                     this.gainControlOK = true;
                  }

                  if (!LibraryJavaSound.usePanControl(false, false)) {
                     PAN_CONTROL_PRIORITY = 4;
                  } else if (!var35[0].isControlSupported(Type.PAN)) {
                     if (PAN_CONTROL_PRIORITY == 1) {
                        throw new LibraryJavaSound.Exception("Pan control not available for Mixer '" + this.mixerInfo.getName() + "'", this);
                     }
                  } else {
                     this.panControlOK = true;
                  }

                  if (!LibraryJavaSound.useSampleRateControl(false, false)) {
                     SAMPLE_RATE_CONTROL_PRIORITY = 4;
                  } else if (!var35[0].isControlSupported(Type.SAMPLE_RATE)) {
                     if (SAMPLE_RATE_CONTROL_PRIORITY == 1) {
                        throw new LibraryJavaSound.Exception("Sample-rate control not available for Mixer '" + this.mixerInfo.getName() + "'", this);
                     }
                  } else {
                     this.sampleRateControlOK = true;
                  }

                  this.rank = this.rank + this.getRankValue(this.mixerExists, MIXER_EXISTS_PRIORITY);
                  this.rank = this.rank + this.getRankValue(this.minSampleRateOK, MIN_SAMPLE_RATE_PRIORITY);
                  this.rank = this.rank + this.getRankValue(this.maxSampleRateOK, MAX_SAMPLE_RATE_PRIORITY);
                  this.rank = this.rank + this.getRankValue(this.lineCountOK, LINE_COUNT_PRIORITY);
                  this.rank = this.rank + this.getRankValue(this.gainControlOK, GAIN_CONTROL_PRIORITY);
                  this.rank = this.rank + this.getRankValue(this.panControlOK, PAN_CONTROL_PRIORITY);
                  this.rank = this.rank + this.getRankValue(this.sampleRateControlOK, SAMPLE_RATE_CONTROL_PRIORITY);
                  Object var19 = null;
                  var23 = null;
                  var4 = null;
                  var35 = null;
               } else {
                  throw new LibraryJavaSound.Exception("No possible sample-rate found for Mixer '" + this.mixerInfo.getName() + "'", this);
               }
            }
         }
      }

      private int getRankValue(boolean var1, int var2) {
         if (var1) {
            return 2;
         } else if (var2 == 4) {
            return 2;
         } else {
            return var2 == 3 ? 1 : 0;
         }
      }
   }
}
