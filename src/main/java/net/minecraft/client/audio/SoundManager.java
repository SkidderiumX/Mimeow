/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.audio;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import io.netty.util.internal.ThreadLocalRandom;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.ITickableSound;
import net.minecraft.client.audio.SoundCategory;
import net.minecraft.client.audio.SoundEventAccessorComposite;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.audio.SoundPoolEntry;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import paulscode.sound.SoundSystem;
import paulscode.sound.SoundSystemConfig;
import paulscode.sound.SoundSystemException;
import paulscode.sound.SoundSystemLogger;
import paulscode.sound.Source;
import paulscode.sound.codecs.CodecJOrbis;
import paulscode.sound.libraries.LibraryLWJGLOpenAL;

public class SoundManager {
    private static final Marker LOG_MARKER = MarkerManager.getMarker("SOUNDS");
    private static final Logger logger = LogManager.getLogger();
    private final SoundHandler sndHandler;
    private final GameSettings options;
    private SoundSystemStarterThread sndSystem;
    private boolean loaded;
    private int playTime = 0;
    private final Map<String, ISound> playingSounds = HashBiMap.create();
    private final Map<ISound, String> invPlayingSounds = ((BiMap)this.playingSounds).inverse();
    private Map<ISound, SoundPoolEntry> playingSoundPoolEntries = Maps.newHashMap();
    private final Multimap<SoundCategory, String> categorySounds = HashMultimap.create();
    private final List<ITickableSound> tickableSounds = Lists.newArrayList();
    private final Map<ISound, Integer> delayedSounds = Maps.newHashMap();
    private final Map<String, Integer> playingSoundsStopTime = Maps.newHashMap();

    public SoundManager(SoundHandler soundHandler, GameSettings gameSettings) {
        this.sndHandler = soundHandler;
        this.options = gameSettings;
        try {
            SoundSystemConfig.addLibrary(LibraryLWJGLOpenAL.class);
            SoundSystemConfig.setCodec("ogg", CodecJOrbis.class);
        }
        catch (SoundSystemException soundSystemException) {
            logger.error(LOG_MARKER, "Error linking with the LibraryJavaSound plug-in", (Throwable)soundSystemException);
        }
    }

    public void reloadSoundSystem() {
        this.unloadSoundSystem();
        this.loadSoundSystem();
    }

    private synchronized void loadSoundSystem() {
        if (!this.loaded) {
            try {
                new Thread(new Runnable(){

                    @Override
                    public void run() {
                        SoundSystemConfig.setLogger(new SoundSystemLogger(){

                            @Override
                            public void message(String string, int n) {
                                if (!string.isEmpty()) {
                                    logger.info(string);
                                }
                            }

                            @Override
                            public void importantMessage(String string, int n) {
                                if (!string.isEmpty()) {
                                    logger.warn(string);
                                }
                            }

                            @Override
                            public void errorMessage(String string, String string2, int n) {
                                if (!string2.isEmpty()) {
                                    logger.error("Error in class '" + string + "'");
                                    logger.error(string2);
                                }
                            }
                        });
                        SoundManager.this.sndSystem = new SoundSystemStarterThread();
                        SoundManager.this.loaded = true;
                        SoundManager.this.sndSystem.setMasterVolume(SoundManager.this.options.getSoundLevel(SoundCategory.MASTER));
                        logger.info(LOG_MARKER, "Sound engine started");
                    }
                }, "Sound Library Loader").start();
            }
            catch (RuntimeException runtimeException) {
                logger.error(LOG_MARKER, "Error starting SoundSystem. Turning off sounds & music", (Throwable)runtimeException);
                this.options.setSoundLevel(SoundCategory.MASTER, 0.0f);
                this.options.saveOptions();
            }
        }
    }

    private float getSoundCategoryVolume(SoundCategory soundCategory) {
        return soundCategory != null && soundCategory != SoundCategory.MASTER ? this.options.getSoundLevel(soundCategory) : 1.0f;
    }

    public void setSoundCategoryVolume(SoundCategory soundCategory, float f) {
        if (this.loaded) {
            if (soundCategory == SoundCategory.MASTER) {
                this.sndSystem.setMasterVolume(f);
            } else {
                for (String string : this.categorySounds.get(soundCategory)) {
                    ISound iSound = this.playingSounds.get(string);
                    float f2 = this.getNormalizedVolume(iSound, this.playingSoundPoolEntries.get(iSound), soundCategory);
                    if (f2 <= 0.0f) {
                        this.stopSound(iSound);
                        continue;
                    }
                    this.sndSystem.setVolume(string, f2);
                }
            }
        }
    }

    public void unloadSoundSystem() {
        if (this.loaded) {
            this.stopAllSounds();
            this.sndSystem.cleanup();
            this.loaded = false;
        }
    }

    public void stopAllSounds() {
        if (this.loaded) {
            for (String string : this.playingSounds.keySet()) {
                this.sndSystem.stop(string);
            }
            this.playingSounds.clear();
            this.delayedSounds.clear();
            this.tickableSounds.clear();
            this.categorySounds.clear();
            this.playingSoundPoolEntries.clear();
            this.playingSoundsStopTime.clear();
        }
    }

    public void updateAllSounds() {
        ISound iSound;
        Map.Entry<ISound, Integer> entry;
        ++this.playTime;
        for (ITickableSound iterator22 : this.tickableSounds) {
            iterator22.update();
            if (iterator22.isDonePlaying()) {
                this.stopSound(iterator22);
                continue;
            }
            entry = this.invPlayingSounds.get(iterator22);
            this.sndSystem.setVolume((String)((Object)entry), this.getNormalizedVolume(iterator22, this.playingSoundPoolEntries.get(iterator22), this.sndHandler.getSound(iterator22.getSoundLocation()).getSoundCategory()));
            this.sndSystem.setPitch((String)((Object)entry), this.getNormalizedPitch(iterator22, this.playingSoundPoolEntries.get(iterator22)));
            this.sndSystem.setPosition((String)((Object)entry), iterator22.getXPosF(), iterator22.getYPosF(), iterator22.getZPosF());
        }
        Iterator<Object> iterator3 = this.playingSounds.entrySet().iterator();
        while (iterator3.hasNext()) {
            int n;
            Map.Entry entry2 = (Map.Entry)iterator3.next();
            entry = (String)entry2.getKey();
            iSound = (ISound)entry2.getValue();
            if (this.sndSystem.playing((String)((Object)entry)) || (n = this.playingSoundsStopTime.get(entry).intValue()) > this.playTime) continue;
            int n2 = iSound.getRepeatDelay();
            if (iSound.canRepeat() && n2 > 0) {
                this.delayedSounds.put(iSound, this.playTime + n2);
            }
            iterator3.remove();
            logger.debug(LOG_MARKER, "Removed channel {} because it's not playing anymore", entry);
            this.sndSystem.removeSource((String)((Object)entry));
            this.playingSoundsStopTime.remove(entry);
            this.playingSoundPoolEntries.remove(iSound);
            try {
                this.categorySounds.remove((Object)this.sndHandler.getSound(iSound.getSoundLocation()).getSoundCategory(), entry);
            }
            catch (RuntimeException runtimeException) {
                // empty catch block
            }
            if (!(iSound instanceof ITickableSound)) continue;
            this.tickableSounds.remove(iSound);
        }
        Iterator<Map.Entry<ISound, Integer>> iterator2 = this.delayedSounds.entrySet().iterator();
        while (iterator2.hasNext()) {
            entry = iterator2.next();
            if (this.playTime < (Integer)entry.getValue()) continue;
            iSound = (ISound)entry.getKey();
            if (iSound instanceof ITickableSound) {
                ((ITickableSound)iSound).update();
            }
            this.playSound(iSound);
            iterator2.remove();
        }
    }

    public boolean isSoundPlaying(ISound iSound) {
        if (!this.loaded) {
            return false;
        }
        String string = this.invPlayingSounds.get(iSound);
        return string == null ? false : this.sndSystem.playing(string) || this.playingSoundsStopTime.containsKey(string) && this.playingSoundsStopTime.get(string) <= this.playTime;
    }

    public void stopSound(ISound iSound) {
        String string;
        if (this.loaded && (string = this.invPlayingSounds.get(iSound)) != null) {
            this.sndSystem.stop(string);
        }
    }

    public void playSound(ISound iSound) {
        if (this.loaded) {
            if (this.sndSystem.getMasterVolume() <= 0.0f) {
                logger.debug(LOG_MARKER, "Skipped playing soundEvent: {}, master volume was zero", iSound.getSoundLocation());
            } else {
                SoundEventAccessorComposite soundEventAccessorComposite = this.sndHandler.getSound(iSound.getSoundLocation());
                if (soundEventAccessorComposite == null) {
                    logger.warn(LOG_MARKER, "Unable to play unknown soundEvent: {}", iSound.getSoundLocation());
                } else {
                    SoundPoolEntry soundPoolEntry = soundEventAccessorComposite.cloneEntry();
                    if (soundPoolEntry == SoundHandler.missing_sound) {
                        logger.warn(LOG_MARKER, "Unable to play empty soundEvent: {}", soundEventAccessorComposite.getSoundEventLocation());
                    } else {
                        float f = iSound.getVolume();
                        float f2 = 16.0f;
                        if (f > 1.0f) {
                            f2 *= f;
                        }
                        SoundCategory soundCategory = soundEventAccessorComposite.getSoundCategory();
                        float f3 = this.getNormalizedVolume(iSound, soundPoolEntry, soundCategory);
                        double d = this.getNormalizedPitch(iSound, soundPoolEntry);
                        ResourceLocation resourceLocation = soundPoolEntry.getSoundPoolEntryLocation();
                        if (f3 == 0.0f) {
                            logger.debug(LOG_MARKER, "Skipped playing sound {}, volume was zero.", resourceLocation);
                        } else {
                            boolean bl = iSound.canRepeat() && iSound.getRepeatDelay() == 0;
                            String string = MathHelper.getRandomUuid(ThreadLocalRandom.current()).toString();
                            if (soundPoolEntry.isStreamingSound()) {
                                this.sndSystem.newStreamingSource(false, string, SoundManager.getURLForSoundResource(resourceLocation), resourceLocation.toString(), bl, iSound.getXPosF(), iSound.getYPosF(), iSound.getZPosF(), iSound.getAttenuationType().getTypeInt(), f2);
                            } else {
                                this.sndSystem.newSource(false, string, SoundManager.getURLForSoundResource(resourceLocation), resourceLocation.toString(), bl, iSound.getXPosF(), iSound.getYPosF(), iSound.getZPosF(), iSound.getAttenuationType().getTypeInt(), f2);
                            }
                            logger.debug(LOG_MARKER, "Playing sound {} for event {} as channel {}", soundPoolEntry.getSoundPoolEntryLocation(), soundEventAccessorComposite.getSoundEventLocation(), string);
                            this.sndSystem.setPitch(string, (float)d);
                            this.sndSystem.setVolume(string, f3);
                            this.sndSystem.play(string);
                            this.playingSoundsStopTime.put(string, this.playTime + 20);
                            this.playingSounds.put(string, iSound);
                            this.playingSoundPoolEntries.put(iSound, soundPoolEntry);
                            if (soundCategory != SoundCategory.MASTER) {
                                this.categorySounds.put(soundCategory, string);
                            }
                            if (iSound instanceof ITickableSound) {
                                this.tickableSounds.add((ITickableSound)iSound);
                            }
                        }
                    }
                }
            }
        }
    }

    private float getNormalizedPitch(ISound iSound, SoundPoolEntry soundPoolEntry) {
        return (float)MathHelper.clamp_double((double)iSound.getPitch() * soundPoolEntry.getPitch(), 0.5, 2.0);
    }

    private float getNormalizedVolume(ISound iSound, SoundPoolEntry soundPoolEntry, SoundCategory soundCategory) {
        return (float)MathHelper.clamp_double((double)iSound.getVolume() * soundPoolEntry.getVolume(), 0.0, 1.0) * this.getSoundCategoryVolume(soundCategory);
    }

    public void pauseAllSounds() {
        for (String string : this.playingSounds.keySet()) {
            logger.debug(LOG_MARKER, "Pausing channel {}", string);
            this.sndSystem.pause(string);
        }
    }

    public void resumeAllSounds() {
        for (String string : this.playingSounds.keySet()) {
            logger.debug(LOG_MARKER, "Resuming channel {}", string);
            this.sndSystem.play(string);
        }
    }

    public void playDelayedSound(ISound iSound, int n) {
        this.delayedSounds.put(iSound, this.playTime + n);
    }

    private static URL getURLForSoundResource(final ResourceLocation resourceLocation) {
        String string = String.format("%s:%s:%s", "mcsounddomain", resourceLocation.getResourceDomain(), resourceLocation.getResourcePath());
        URLStreamHandler uRLStreamHandler = new URLStreamHandler(){

            @Override
            protected URLConnection openConnection(URL uRL) {
                return new URLConnection(uRL){

                    @Override
                    public void connect() throws IOException {
                    }

                    @Override
                    public InputStream getInputStream() throws IOException {
                        return Minecraft.getMinecraft().getResourceManager().getResource(resourceLocation).getInputStream();
                    }
                };
            }
        };
        try {
            return new URL((URL)null, string, uRLStreamHandler);
        }
        catch (MalformedURLException malformedURLException) {
            throw new Error("Unable to handle sound URL exception");
        }
    }

    public void setListener(EntityPlayer entityPlayer, float f) {
        if (this.loaded && entityPlayer != null) {
            float f2 = entityPlayer.prevRotationPitch + (entityPlayer.rotationPitch - entityPlayer.prevRotationPitch) * f;
            float f3 = entityPlayer.prevRotationYaw + (entityPlayer.rotationYaw - entityPlayer.prevRotationYaw) * f;
            double d = entityPlayer.prevPosX + (entityPlayer.posX - entityPlayer.prevPosX) * (double)f;
            double d2 = entityPlayer.prevPosY + (entityPlayer.posY - entityPlayer.prevPosY) * (double)f + (double)entityPlayer.getEyeHeight();
            double d3 = entityPlayer.prevPosZ + (entityPlayer.posZ - entityPlayer.prevPosZ) * (double)f;
            float f4 = MathHelper.cos((f3 + 90.0f) * ((float)Math.PI / 180));
            float f5 = MathHelper.sin((f3 + 90.0f) * ((float)Math.PI / 180));
            float f6 = MathHelper.cos(-f2 * ((float)Math.PI / 180));
            float f7 = MathHelper.sin(-f2 * ((float)Math.PI / 180));
            float f8 = MathHelper.cos((-f2 + 90.0f) * ((float)Math.PI / 180));
            float f9 = MathHelper.sin((-f2 + 90.0f) * ((float)Math.PI / 180));
            float f10 = f4 * f6;
            float f11 = f5 * f6;
            float f12 = f4 * f8;
            float f13 = f5 * f8;
            this.sndSystem.setListenerPosition((float)d, (float)d2, (float)d3);
            this.sndSystem.setListenerOrientation(f10, f7, f11, f12, f9, f13);
        }
    }

    public class SoundSystemStarterThread
    extends SoundSystem {
        private SoundSystemStarterThread() {
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public boolean playing(String string) {
            Object object = SoundSystemConfig.THREAD_SYNC;
            synchronized (object) {
                if (this.soundLibrary == null) {
                    return false;
                }
                Source source2 = this.soundLibrary.getSources().get(string);
                boolean bl = source2 == null ? false : source2.playing() || source2.paused() || source2.preLoad;
                return bl;
            }
        }
    }
}

