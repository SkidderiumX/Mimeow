/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.openal;

import java.util.Set;
import java.util.function.IntFunction;
import org.lwjgl.PointerBuffer;
import org.lwjgl.system.Checks;
import org.lwjgl.system.FunctionProvider;
import org.lwjgl.system.ThreadLocalUtil;

public class ALCapabilities {
    public final long alGetError;
    public final long alGetErrorDirect;
    public final long alEnable;
    public final long alEnableDirect;
    public final long alDisable;
    public final long alDisableDirect;
    public final long alIsEnabled;
    public final long alIsEnabledDirect;
    public final long alGetBoolean;
    public final long alGetBooleanDirect;
    public final long alGetInteger;
    public final long alGetIntegerDirect;
    public final long alGetFloat;
    public final long alGetFloatDirect;
    public final long alGetDouble;
    public final long alGetDoubleDirect;
    public final long alGetBooleanv;
    public final long alGetBooleanvDirect;
    public final long alGetIntegerv;
    public final long alGetIntegervDirect;
    public final long alGetFloatv;
    public final long alGetFloatvDirect;
    public final long alGetDoublev;
    public final long alGetDoublevDirect;
    public final long alGetString;
    public final long alGetStringDirect;
    public final long alDistanceModel;
    public final long alDistanceModelDirect;
    public final long alDopplerFactor;
    public final long alDopplerFactorDirect;
    public final long alDopplerVelocity;
    public final long alListenerf;
    public final long alListenerfDirect;
    public final long alListeneri;
    public final long alListeneriDirect;
    public final long alListener3f;
    public final long alListener3fDirect;
    public final long alListenerfv;
    public final long alListenerfvDirect;
    public final long alGetListenerf;
    public final long alGetListenerfDirect;
    public final long alGetListeneri;
    public final long alGetListeneriDirect;
    public final long alGetListener3f;
    public final long alGetListener3fDirect;
    public final long alGetListenerfv;
    public final long alGetListenerfvDirect;
    public final long alGenSources;
    public final long alGenSourcesDirect;
    public final long alDeleteSources;
    public final long alDeleteSourcesDirect;
    public final long alIsSource;
    public final long alIsSourceDirect;
    public final long alSourcef;
    public final long alSourcefDirect;
    public final long alSource3f;
    public final long alSource3fDirect;
    public final long alSourcefv;
    public final long alSourcefvDirect;
    public final long alSourcei;
    public final long alSourceiDirect;
    public final long alGetSourcef;
    public final long alGetSourcefDirect;
    public final long alGetSource3f;
    public final long alGetSource3fDirect;
    public final long alGetSourcefv;
    public final long alGetSourcefvDirect;
    public final long alGetSourcei;
    public final long alGetSourceiDirect;
    public final long alGetSourceiv;
    public final long alGetSourceivDirect;
    public final long alSourceQueueBuffers;
    public final long alSourceQueueBuffersDirect;
    public final long alSourceUnqueueBuffers;
    public final long alSourceUnqueueBuffersDirect;
    public final long alSourcePlay;
    public final long alSourcePlayDirect;
    public final long alSourcePause;
    public final long alSourcePauseDirect;
    public final long alSourceStop;
    public final long alSourceStopDirect;
    public final long alSourceRewind;
    public final long alSourceRewindDirect;
    public final long alSourcePlayv;
    public final long alSourcePlayvDirect;
    public final long alSourcePausev;
    public final long alSourcePausevDirect;
    public final long alSourceStopv;
    public final long alSourceStopvDirect;
    public final long alSourceRewindv;
    public final long alSourceRewindvDirect;
    public final long alGenBuffers;
    public final long alGenBuffersDirect;
    public final long alDeleteBuffers;
    public final long alDeleteBuffersDirect;
    public final long alIsBuffer;
    public final long alIsBufferDirect;
    public final long alGetBufferf;
    public final long alGetBufferfDirect;
    public final long alGetBufferi;
    public final long alGetBufferiDirect;
    public final long alBufferData;
    public final long alBufferDataDirect;
    public final long alGetEnumValue;
    public final long alGetEnumValueDirect;
    public final long alGetProcAddress;
    public final long alGetProcAddressDirect;
    public final long alIsExtensionPresent;
    public final long alIsExtensionPresentDirect;
    public final long alListener3i;
    public final long alListener3iDirect;
    public final long alGetListener3i;
    public final long alGetListener3iDirect;
    public final long alGetListeneriv;
    public final long alGetListenerivDirect;
    public final long alSource3i;
    public final long alSource3iDirect;
    public final long alGetSource3i;
    public final long alGetSource3iDirect;
    public final long alListeneriv;
    public final long alListenerivDirect;
    public final long alSourceiv;
    public final long alSourceivDirect;
    public final long alBufferf;
    public final long alBufferfDirect;
    public final long alBuffer3f;
    public final long alBuffer3fDirect;
    public final long alBufferfv;
    public final long alBufferfvDirect;
    public final long alBufferi;
    public final long alBufferiDirect;
    public final long alBuffer3i;
    public final long alBuffer3iDirect;
    public final long alBufferiv;
    public final long alBufferivDirect;
    public final long alGetBuffer3i;
    public final long alGetBuffer3iDirect;
    public final long alGetBufferiv;
    public final long alGetBufferivDirect;
    public final long alGetBuffer3f;
    public final long alGetBuffer3fDirect;
    public final long alGetBufferfv;
    public final long alGetBufferfvDirect;
    public final long alSpeedOfSound;
    public final long alSpeedOfSoundDirect;
    public final long alDebugMessageCallbackEXT;
    public final long alDebugMessageCallbackDirectEXT;
    public final long alDebugMessageInsertEXT;
    public final long alDebugMessageInsertDirectEXT;
    public final long alDebugMessageControlEXT;
    public final long alDebugMessageControlDirectEXT;
    public final long alPushDebugGroupEXT;
    public final long alPushDebugGroupDirectEXT;
    public final long alPopDebugGroupEXT;
    public final long alPopDebugGroupDirectEXT;
    public final long alGetDebugMessageLogEXT;
    public final long alGetDebugMessageLogDirectEXT;
    public final long alObjectLabelEXT;
    public final long alObjectLabelDirectEXT;
    public final long alGetObjectLabelEXT;
    public final long alGetObjectLabelDirectEXT;
    public final long alGetPointerEXT;
    public final long alGetPointerDirectEXT;
    public final long alGetPointervEXT;
    public final long alGetPointervDirectEXT;
    public final long alGenEffects;
    public final long alGenEffectsDirect;
    public final long alDeleteEffects;
    public final long alDeleteEffectsDirect;
    public final long alIsEffect;
    public final long alIsEffectDirect;
    public final long alEffecti;
    public final long alEffectiDirect;
    public final long alEffectiv;
    public final long alEffectivDirect;
    public final long alEffectf;
    public final long alEffectfDirect;
    public final long alEffectfv;
    public final long alEffectfvDirect;
    public final long alGetEffecti;
    public final long alGetEffectiDirect;
    public final long alGetEffectiv;
    public final long alGetEffectivDirect;
    public final long alGetEffectf;
    public final long alGetEffectfDirect;
    public final long alGetEffectfv;
    public final long alGetEffectfvDirect;
    public final long alGenFilters;
    public final long alGenFiltersDirect;
    public final long alDeleteFilters;
    public final long alDeleteFiltersDirect;
    public final long alIsFilter;
    public final long alIsFilterDirect;
    public final long alFilteri;
    public final long alFilteriDirect;
    public final long alFilteriv;
    public final long alFilterivDirect;
    public final long alFilterf;
    public final long alFilterfDirect;
    public final long alFilterfv;
    public final long alFilterfvDirect;
    public final long alGetFilteri;
    public final long alGetFilteriDirect;
    public final long alGetFilteriv;
    public final long alGetFilterivDirect;
    public final long alGetFilterf;
    public final long alGetFilterfDirect;
    public final long alGetFilterfv;
    public final long alGetFilterfvDirect;
    public final long alGenAuxiliaryEffectSlots;
    public final long alGenAuxiliaryEffectSlotsDirect;
    public final long alDeleteAuxiliaryEffectSlots;
    public final long alDeleteAuxiliaryEffectSlotsDirect;
    public final long alIsAuxiliaryEffectSlot;
    public final long alIsAuxiliaryEffectSlotDirect;
    public final long alAuxiliaryEffectSloti;
    public final long alAuxiliaryEffectSlotiDirect;
    public final long alAuxiliaryEffectSlotiv;
    public final long alAuxiliaryEffectSlotivDirect;
    public final long alAuxiliaryEffectSlotf;
    public final long alAuxiliaryEffectSlotfDirect;
    public final long alAuxiliaryEffectSlotfv;
    public final long alAuxiliaryEffectSlotfvDirect;
    public final long alGetAuxiliaryEffectSloti;
    public final long alGetAuxiliaryEffectSlotiDirect;
    public final long alGetAuxiliaryEffectSlotiv;
    public final long alGetAuxiliaryEffectSlotivDirect;
    public final long alGetAuxiliaryEffectSlotf;
    public final long alGetAuxiliaryEffectSlotfDirect;
    public final long alGetAuxiliaryEffectSlotfv;
    public final long alGetAuxiliaryEffectSlotfvDirect;
    public final long alBufferDataStatic;
    public final long alBufferDataStaticDirect;
    public final long alBufferSamplesSOFT;
    public final long alBufferSubSamplesSOFT;
    public final long alGetBufferSamplesSOFT;
    public final long alIsBufferFormatSupportedSOFT;
    public final long alBufferSubDataSOFT;
    public final long alBufferSubDataDirectSOFT;
    public final long alBufferCallbackSOFT;
    public final long alBufferCallbackDirectSOFT;
    public final long alGetBufferPtrSOFT;
    public final long alGetBufferPtrDirectSOFT;
    public final long alGetBuffer3PtrSOFT;
    public final long alGetBuffer3PtrDirectSOFT;
    public final long alGetBufferPtrvSOFT;
    public final long alGetBufferPtrvDirectSOFT;
    public final long alDeferUpdatesSOFT;
    public final long alDeferUpdatesDirectSOFT;
    public final long alProcessUpdatesSOFT;
    public final long alProcessUpdatesDirectSOFT;
    public final long alEventControlSOFT;
    public final long alEventControlDirectSOFT;
    public final long alEventCallbackSOFT;
    public final long alEventCallbackDirectSOFT;
    public final long alGetPointerSOFT;
    public final long alGetPointerDirectSOFT;
    public final long alGetPointervSOFT;
    public final long alGetPointervDirectSOFT;
    public final long alSourcedSOFT;
    public final long alSourcedDirectSOFT;
    public final long alSource3dSOFT;
    public final long alSource3dDirectSOFT;
    public final long alSourcedvSOFT;
    public final long alSourcedvDirectSOFT;
    public final long alGetSourcedSOFT;
    public final long alGetSourcedDirectSOFT;
    public final long alGetSource3dSOFT;
    public final long alGetSource3dDirectSOFT;
    public final long alGetSourcedvSOFT;
    public final long alGetSourcedvDirectSOFT;
    public final long alSourcei64SOFT;
    public final long alSourcei64DirectSOFT;
    public final long alSource3i64SOFT;
    public final long alSource3i64DirectSOFT;
    public final long alSourcei64vSOFT;
    public final long alSourcei64vDirectSOFT;
    public final long alGetSourcei64SOFT;
    public final long alGetSourcei64DirectSOFT;
    public final long alGetSource3i64SOFT;
    public final long alGetSource3i64DirectSOFT;
    public final long alGetSourcei64vSOFT;
    public final long alGetSourcei64vDirectSOFT;
    public final long alGetStringiSOFT;
    public final long alGetStringiDirectSOFT;
    public final long alSourcePlayAtTimeSOFT;
    public final long alSourcePlayAtTimeDirectSOFT;
    public final long alSourcePlayAtTimevSOFT;
    public final long alSourcePlayAtTimevDirectSOFT;
    public final boolean OpenAL10;
    public final boolean OpenAL11;
    public final boolean AL_EXT_ALAW;
    public final boolean AL_EXT_BFORMAT;
    public final boolean AL_EXT_debug;
    public final boolean AL_EXT_direct_context;
    public final boolean AL_EXT_DOUBLE;
    public final boolean ALC_EXT_EFX;
    public final boolean AL_EXT_EXPONENT_DISTANCE;
    public final boolean AL_EXT_FLOAT32;
    public final boolean AL_EXT_IMA4;
    public final boolean AL_EXT_LINEAR_DISTANCE;
    public final boolean AL_EXT_MCFORMATS;
    public final boolean AL_EXT_MULAW;
    public final boolean AL_EXT_MULAW_BFORMAT;
    public final boolean AL_EXT_MULAW_MCFORMATS;
    public final boolean AL_EXT_OFFSET;
    public final boolean AL_EXT_source_distance_model;
    public final boolean AL_EXT_SOURCE_RADIUS;
    public final boolean AL_EXT_STATIC_BUFFER;
    public final boolean AL_EXT_STEREO_ANGLES;
    public final boolean AL_EXT_vorbis;
    public final boolean AL_LOKI_IMA_ADPCM;
    public final boolean AL_LOKI_quadriphonic;
    public final boolean AL_LOKI_WAVE_format;
    public final boolean AL_SOFT_bformat_ex;
    public final boolean AL_SOFT_block_alignment;
    public final boolean AL_SOFT_buffer_length_query;
    public final boolean AL_SOFT_buffer_samples;
    public final boolean AL_SOFT_buffer_sub_data;
    public final boolean AL_SOFT_callback_buffer;
    public final boolean AL_SOFT_deferred_updates;
    public final boolean AL_SOFT_direct_channels;
    public final boolean AL_SOFT_direct_channels_remix;
    public final boolean AL_SOFT_effect_target;
    public final boolean AL_SOFT_events;
    public final boolean AL_SOFT_gain_clamp_ex;
    public final boolean AL_SOFT_loop_points;
    public final boolean AL_SOFT_MSADPCM;
    public final boolean AL_SOFT_source_latency;
    public final boolean AL_SOFT_source_length;
    public final boolean AL_SOFT_source_resampler;
    public final boolean AL_SOFT_source_spatialize;
    public final boolean AL_SOFT_source_start_delay;
    public final boolean AL_SOFT_UHJ;
    public final boolean AL_SOFT_UHJ_ex;
    public final boolean AL_SOFTX_hold_on_disconnect;
    final PointerBuffer addresses;

    ALCapabilities(FunctionProvider functionProvider, Set<String> set, IntFunction<PointerBuffer> intFunction) {
        PointerBuffer pointerBuffer = intFunction.apply(289);
        this.OpenAL10 = ALCapabilities.check_AL10(functionProvider, pointerBuffer, set);
        this.OpenAL11 = ALCapabilities.check_AL11(functionProvider, pointerBuffer, set);
        this.AL_EXT_ALAW = set.contains("AL_EXT_ALAW");
        this.AL_EXT_BFORMAT = set.contains("AL_EXT_BFORMAT");
        this.AL_EXT_debug = ALCapabilities.check_EXT_debug(functionProvider, pointerBuffer, set);
        this.AL_EXT_direct_context = set.contains("AL_EXT_direct_context");
        this.AL_EXT_DOUBLE = set.contains("AL_EXT_DOUBLE");
        this.ALC_EXT_EFX = ALCapabilities.check_EXT_EFX(functionProvider, pointerBuffer, set);
        this.AL_EXT_EXPONENT_DISTANCE = set.contains("AL_EXT_EXPONENT_DISTANCE");
        this.AL_EXT_FLOAT32 = set.contains("AL_EXT_FLOAT32");
        this.AL_EXT_IMA4 = set.contains("AL_EXT_IMA4");
        this.AL_EXT_LINEAR_DISTANCE = set.contains("AL_EXT_LINEAR_DISTANCE");
        this.AL_EXT_MCFORMATS = set.contains("AL_EXT_MCFORMATS");
        this.AL_EXT_MULAW = set.contains("AL_EXT_MULAW");
        this.AL_EXT_MULAW_BFORMAT = set.contains("AL_EXT_MULAW_BFORMAT");
        this.AL_EXT_MULAW_MCFORMATS = set.contains("AL_EXT_MULAW_MCFORMATS");
        this.AL_EXT_OFFSET = set.contains("AL_EXT_OFFSET");
        this.AL_EXT_source_distance_model = set.contains("AL_EXT_source_distance_model");
        this.AL_EXT_SOURCE_RADIUS = set.contains("AL_EXT_SOURCE_RADIUS");
        this.AL_EXT_STATIC_BUFFER = ALCapabilities.check_EXT_STATIC_BUFFER(functionProvider, pointerBuffer, set);
        this.AL_EXT_STEREO_ANGLES = set.contains("AL_EXT_STEREO_ANGLES");
        this.AL_EXT_vorbis = set.contains("AL_EXT_vorbis");
        this.AL_LOKI_IMA_ADPCM = set.contains("AL_LOKI_IMA_ADPCM");
        this.AL_LOKI_quadriphonic = set.contains("AL_LOKI_quadriphonic");
        this.AL_LOKI_WAVE_format = set.contains("AL_LOKI_WAVE_format");
        this.AL_SOFT_bformat_ex = set.contains("AL_SOFT_bformat_ex");
        this.AL_SOFT_block_alignment = set.contains("AL_SOFT_block_alignment");
        this.AL_SOFT_buffer_length_query = set.contains("AL_SOFT_buffer_length_query");
        this.AL_SOFT_buffer_samples = ALCapabilities.check_SOFT_buffer_samples(functionProvider, pointerBuffer, set);
        this.AL_SOFT_buffer_sub_data = ALCapabilities.check_SOFT_buffer_sub_data(functionProvider, pointerBuffer, set);
        this.AL_SOFT_callback_buffer = ALCapabilities.check_SOFT_callback_buffer(functionProvider, pointerBuffer, set);
        this.AL_SOFT_deferred_updates = ALCapabilities.check_SOFT_deferred_updates(functionProvider, pointerBuffer, set);
        this.AL_SOFT_direct_channels = set.contains("AL_SOFT_direct_channels");
        this.AL_SOFT_direct_channels_remix = set.contains("AL_SOFT_direct_channels_remix");
        this.AL_SOFT_effect_target = set.contains("AL_SOFT_effect_target");
        this.AL_SOFT_events = ALCapabilities.check_SOFT_events(functionProvider, pointerBuffer, set);
        this.AL_SOFT_gain_clamp_ex = set.contains("AL_SOFT_gain_clamp_ex");
        this.AL_SOFT_loop_points = set.contains("AL_SOFT_loop_points");
        this.AL_SOFT_MSADPCM = set.contains("AL_SOFT_MSADPCM");
        this.AL_SOFT_source_latency = ALCapabilities.check_SOFT_source_latency(functionProvider, pointerBuffer, set);
        this.AL_SOFT_source_length = set.contains("AL_SOFT_source_length");
        this.AL_SOFT_source_resampler = ALCapabilities.check_SOFT_source_resampler(functionProvider, pointerBuffer, set);
        this.AL_SOFT_source_spatialize = set.contains("AL_SOFT_source_spatialize");
        this.AL_SOFT_source_start_delay = ALCapabilities.check_SOFT_source_start_delay(functionProvider, pointerBuffer, set);
        this.AL_SOFT_UHJ = set.contains("AL_SOFT_UHJ");
        this.AL_SOFT_UHJ_ex = set.contains("AL_SOFT_UHJ_ex");
        this.AL_SOFTX_hold_on_disconnect = set.contains("AL_SOFTX_hold_on_disconnect");
        this.alGetError = pointerBuffer.get(0);
        this.alGetErrorDirect = pointerBuffer.get(1);
        this.alEnable = pointerBuffer.get(2);
        this.alEnableDirect = pointerBuffer.get(3);
        this.alDisable = pointerBuffer.get(4);
        this.alDisableDirect = pointerBuffer.get(5);
        this.alIsEnabled = pointerBuffer.get(6);
        this.alIsEnabledDirect = pointerBuffer.get(7);
        this.alGetBoolean = pointerBuffer.get(8);
        this.alGetBooleanDirect = pointerBuffer.get(9);
        this.alGetInteger = pointerBuffer.get(10);
        this.alGetIntegerDirect = pointerBuffer.get(11);
        this.alGetFloat = pointerBuffer.get(12);
        this.alGetFloatDirect = pointerBuffer.get(13);
        this.alGetDouble = pointerBuffer.get(14);
        this.alGetDoubleDirect = pointerBuffer.get(15);
        this.alGetBooleanv = pointerBuffer.get(16);
        this.alGetBooleanvDirect = pointerBuffer.get(17);
        this.alGetIntegerv = pointerBuffer.get(18);
        this.alGetIntegervDirect = pointerBuffer.get(19);
        this.alGetFloatv = pointerBuffer.get(20);
        this.alGetFloatvDirect = pointerBuffer.get(21);
        this.alGetDoublev = pointerBuffer.get(22);
        this.alGetDoublevDirect = pointerBuffer.get(23);
        this.alGetString = pointerBuffer.get(24);
        this.alGetStringDirect = pointerBuffer.get(25);
        this.alDistanceModel = pointerBuffer.get(26);
        this.alDistanceModelDirect = pointerBuffer.get(27);
        this.alDopplerFactor = pointerBuffer.get(28);
        this.alDopplerFactorDirect = pointerBuffer.get(29);
        this.alDopplerVelocity = pointerBuffer.get(30);
        this.alListenerf = pointerBuffer.get(31);
        this.alListenerfDirect = pointerBuffer.get(32);
        this.alListeneri = pointerBuffer.get(33);
        this.alListeneriDirect = pointerBuffer.get(34);
        this.alListener3f = pointerBuffer.get(35);
        this.alListener3fDirect = pointerBuffer.get(36);
        this.alListenerfv = pointerBuffer.get(37);
        this.alListenerfvDirect = pointerBuffer.get(38);
        this.alGetListenerf = pointerBuffer.get(39);
        this.alGetListenerfDirect = pointerBuffer.get(40);
        this.alGetListeneri = pointerBuffer.get(41);
        this.alGetListeneriDirect = pointerBuffer.get(42);
        this.alGetListener3f = pointerBuffer.get(43);
        this.alGetListener3fDirect = pointerBuffer.get(44);
        this.alGetListenerfv = pointerBuffer.get(45);
        this.alGetListenerfvDirect = pointerBuffer.get(46);
        this.alGenSources = pointerBuffer.get(47);
        this.alGenSourcesDirect = pointerBuffer.get(48);
        this.alDeleteSources = pointerBuffer.get(49);
        this.alDeleteSourcesDirect = pointerBuffer.get(50);
        this.alIsSource = pointerBuffer.get(51);
        this.alIsSourceDirect = pointerBuffer.get(52);
        this.alSourcef = pointerBuffer.get(53);
        this.alSourcefDirect = pointerBuffer.get(54);
        this.alSource3f = pointerBuffer.get(55);
        this.alSource3fDirect = pointerBuffer.get(56);
        this.alSourcefv = pointerBuffer.get(57);
        this.alSourcefvDirect = pointerBuffer.get(58);
        this.alSourcei = pointerBuffer.get(59);
        this.alSourceiDirect = pointerBuffer.get(60);
        this.alGetSourcef = pointerBuffer.get(61);
        this.alGetSourcefDirect = pointerBuffer.get(62);
        this.alGetSource3f = pointerBuffer.get(63);
        this.alGetSource3fDirect = pointerBuffer.get(64);
        this.alGetSourcefv = pointerBuffer.get(65);
        this.alGetSourcefvDirect = pointerBuffer.get(66);
        this.alGetSourcei = pointerBuffer.get(67);
        this.alGetSourceiDirect = pointerBuffer.get(68);
        this.alGetSourceiv = pointerBuffer.get(69);
        this.alGetSourceivDirect = pointerBuffer.get(70);
        this.alSourceQueueBuffers = pointerBuffer.get(71);
        this.alSourceQueueBuffersDirect = pointerBuffer.get(72);
        this.alSourceUnqueueBuffers = pointerBuffer.get(73);
        this.alSourceUnqueueBuffersDirect = pointerBuffer.get(74);
        this.alSourcePlay = pointerBuffer.get(75);
        this.alSourcePlayDirect = pointerBuffer.get(76);
        this.alSourcePause = pointerBuffer.get(77);
        this.alSourcePauseDirect = pointerBuffer.get(78);
        this.alSourceStop = pointerBuffer.get(79);
        this.alSourceStopDirect = pointerBuffer.get(80);
        this.alSourceRewind = pointerBuffer.get(81);
        this.alSourceRewindDirect = pointerBuffer.get(82);
        this.alSourcePlayv = pointerBuffer.get(83);
        this.alSourcePlayvDirect = pointerBuffer.get(84);
        this.alSourcePausev = pointerBuffer.get(85);
        this.alSourcePausevDirect = pointerBuffer.get(86);
        this.alSourceStopv = pointerBuffer.get(87);
        this.alSourceStopvDirect = pointerBuffer.get(88);
        this.alSourceRewindv = pointerBuffer.get(89);
        this.alSourceRewindvDirect = pointerBuffer.get(90);
        this.alGenBuffers = pointerBuffer.get(91);
        this.alGenBuffersDirect = pointerBuffer.get(92);
        this.alDeleteBuffers = pointerBuffer.get(93);
        this.alDeleteBuffersDirect = pointerBuffer.get(94);
        this.alIsBuffer = pointerBuffer.get(95);
        this.alIsBufferDirect = pointerBuffer.get(96);
        this.alGetBufferf = pointerBuffer.get(97);
        this.alGetBufferfDirect = pointerBuffer.get(98);
        this.alGetBufferi = pointerBuffer.get(99);
        this.alGetBufferiDirect = pointerBuffer.get(100);
        this.alBufferData = pointerBuffer.get(101);
        this.alBufferDataDirect = pointerBuffer.get(102);
        this.alGetEnumValue = pointerBuffer.get(103);
        this.alGetEnumValueDirect = pointerBuffer.get(104);
        this.alGetProcAddress = pointerBuffer.get(105);
        this.alGetProcAddressDirect = pointerBuffer.get(106);
        this.alIsExtensionPresent = pointerBuffer.get(107);
        this.alIsExtensionPresentDirect = pointerBuffer.get(108);
        this.alListener3i = pointerBuffer.get(109);
        this.alListener3iDirect = pointerBuffer.get(110);
        this.alGetListener3i = pointerBuffer.get(111);
        this.alGetListener3iDirect = pointerBuffer.get(112);
        this.alGetListeneriv = pointerBuffer.get(113);
        this.alGetListenerivDirect = pointerBuffer.get(114);
        this.alSource3i = pointerBuffer.get(115);
        this.alSource3iDirect = pointerBuffer.get(116);
        this.alGetSource3i = pointerBuffer.get(117);
        this.alGetSource3iDirect = pointerBuffer.get(118);
        this.alListeneriv = pointerBuffer.get(119);
        this.alListenerivDirect = pointerBuffer.get(120);
        this.alSourceiv = pointerBuffer.get(121);
        this.alSourceivDirect = pointerBuffer.get(122);
        this.alBufferf = pointerBuffer.get(123);
        this.alBufferfDirect = pointerBuffer.get(124);
        this.alBuffer3f = pointerBuffer.get(125);
        this.alBuffer3fDirect = pointerBuffer.get(126);
        this.alBufferfv = pointerBuffer.get(127);
        this.alBufferfvDirect = pointerBuffer.get(128);
        this.alBufferi = pointerBuffer.get(129);
        this.alBufferiDirect = pointerBuffer.get(130);
        this.alBuffer3i = pointerBuffer.get(131);
        this.alBuffer3iDirect = pointerBuffer.get(132);
        this.alBufferiv = pointerBuffer.get(133);
        this.alBufferivDirect = pointerBuffer.get(134);
        this.alGetBuffer3i = pointerBuffer.get(135);
        this.alGetBuffer3iDirect = pointerBuffer.get(136);
        this.alGetBufferiv = pointerBuffer.get(137);
        this.alGetBufferivDirect = pointerBuffer.get(138);
        this.alGetBuffer3f = pointerBuffer.get(139);
        this.alGetBuffer3fDirect = pointerBuffer.get(140);
        this.alGetBufferfv = pointerBuffer.get(141);
        this.alGetBufferfvDirect = pointerBuffer.get(142);
        this.alSpeedOfSound = pointerBuffer.get(143);
        this.alSpeedOfSoundDirect = pointerBuffer.get(144);
        this.alDebugMessageCallbackEXT = pointerBuffer.get(145);
        this.alDebugMessageCallbackDirectEXT = pointerBuffer.get(146);
        this.alDebugMessageInsertEXT = pointerBuffer.get(147);
        this.alDebugMessageInsertDirectEXT = pointerBuffer.get(148);
        this.alDebugMessageControlEXT = pointerBuffer.get(149);
        this.alDebugMessageControlDirectEXT = pointerBuffer.get(150);
        this.alPushDebugGroupEXT = pointerBuffer.get(151);
        this.alPushDebugGroupDirectEXT = pointerBuffer.get(152);
        this.alPopDebugGroupEXT = pointerBuffer.get(153);
        this.alPopDebugGroupDirectEXT = pointerBuffer.get(154);
        this.alGetDebugMessageLogEXT = pointerBuffer.get(155);
        this.alGetDebugMessageLogDirectEXT = pointerBuffer.get(156);
        this.alObjectLabelEXT = pointerBuffer.get(157);
        this.alObjectLabelDirectEXT = pointerBuffer.get(158);
        this.alGetObjectLabelEXT = pointerBuffer.get(159);
        this.alGetObjectLabelDirectEXT = pointerBuffer.get(160);
        this.alGetPointerEXT = pointerBuffer.get(161);
        this.alGetPointerDirectEXT = pointerBuffer.get(162);
        this.alGetPointervEXT = pointerBuffer.get(163);
        this.alGetPointervDirectEXT = pointerBuffer.get(164);
        this.alGenEffects = pointerBuffer.get(165);
        this.alGenEffectsDirect = pointerBuffer.get(166);
        this.alDeleteEffects = pointerBuffer.get(167);
        this.alDeleteEffectsDirect = pointerBuffer.get(168);
        this.alIsEffect = pointerBuffer.get(169);
        this.alIsEffectDirect = pointerBuffer.get(170);
        this.alEffecti = pointerBuffer.get(171);
        this.alEffectiDirect = pointerBuffer.get(172);
        this.alEffectiv = pointerBuffer.get(173);
        this.alEffectivDirect = pointerBuffer.get(174);
        this.alEffectf = pointerBuffer.get(175);
        this.alEffectfDirect = pointerBuffer.get(176);
        this.alEffectfv = pointerBuffer.get(177);
        this.alEffectfvDirect = pointerBuffer.get(178);
        this.alGetEffecti = pointerBuffer.get(179);
        this.alGetEffectiDirect = pointerBuffer.get(180);
        this.alGetEffectiv = pointerBuffer.get(181);
        this.alGetEffectivDirect = pointerBuffer.get(182);
        this.alGetEffectf = pointerBuffer.get(183);
        this.alGetEffectfDirect = pointerBuffer.get(184);
        this.alGetEffectfv = pointerBuffer.get(185);
        this.alGetEffectfvDirect = pointerBuffer.get(186);
        this.alGenFilters = pointerBuffer.get(187);
        this.alGenFiltersDirect = pointerBuffer.get(188);
        this.alDeleteFilters = pointerBuffer.get(189);
        this.alDeleteFiltersDirect = pointerBuffer.get(190);
        this.alIsFilter = pointerBuffer.get(191);
        this.alIsFilterDirect = pointerBuffer.get(192);
        this.alFilteri = pointerBuffer.get(193);
        this.alFilteriDirect = pointerBuffer.get(194);
        this.alFilteriv = pointerBuffer.get(195);
        this.alFilterivDirect = pointerBuffer.get(196);
        this.alFilterf = pointerBuffer.get(197);
        this.alFilterfDirect = pointerBuffer.get(198);
        this.alFilterfv = pointerBuffer.get(199);
        this.alFilterfvDirect = pointerBuffer.get(200);
        this.alGetFilteri = pointerBuffer.get(201);
        this.alGetFilteriDirect = pointerBuffer.get(202);
        this.alGetFilteriv = pointerBuffer.get(203);
        this.alGetFilterivDirect = pointerBuffer.get(204);
        this.alGetFilterf = pointerBuffer.get(205);
        this.alGetFilterfDirect = pointerBuffer.get(206);
        this.alGetFilterfv = pointerBuffer.get(207);
        this.alGetFilterfvDirect = pointerBuffer.get(208);
        this.alGenAuxiliaryEffectSlots = pointerBuffer.get(209);
        this.alGenAuxiliaryEffectSlotsDirect = pointerBuffer.get(210);
        this.alDeleteAuxiliaryEffectSlots = pointerBuffer.get(211);
        this.alDeleteAuxiliaryEffectSlotsDirect = pointerBuffer.get(212);
        this.alIsAuxiliaryEffectSlot = pointerBuffer.get(213);
        this.alIsAuxiliaryEffectSlotDirect = pointerBuffer.get(214);
        this.alAuxiliaryEffectSloti = pointerBuffer.get(215);
        this.alAuxiliaryEffectSlotiDirect = pointerBuffer.get(216);
        this.alAuxiliaryEffectSlotiv = pointerBuffer.get(217);
        this.alAuxiliaryEffectSlotivDirect = pointerBuffer.get(218);
        this.alAuxiliaryEffectSlotf = pointerBuffer.get(219);
        this.alAuxiliaryEffectSlotfDirect = pointerBuffer.get(220);
        this.alAuxiliaryEffectSlotfv = pointerBuffer.get(221);
        this.alAuxiliaryEffectSlotfvDirect = pointerBuffer.get(222);
        this.alGetAuxiliaryEffectSloti = pointerBuffer.get(223);
        this.alGetAuxiliaryEffectSlotiDirect = pointerBuffer.get(224);
        this.alGetAuxiliaryEffectSlotiv = pointerBuffer.get(225);
        this.alGetAuxiliaryEffectSlotivDirect = pointerBuffer.get(226);
        this.alGetAuxiliaryEffectSlotf = pointerBuffer.get(227);
        this.alGetAuxiliaryEffectSlotfDirect = pointerBuffer.get(228);
        this.alGetAuxiliaryEffectSlotfv = pointerBuffer.get(229);
        this.alGetAuxiliaryEffectSlotfvDirect = pointerBuffer.get(230);
        this.alBufferDataStatic = pointerBuffer.get(231);
        this.alBufferDataStaticDirect = pointerBuffer.get(232);
        this.alBufferSamplesSOFT = pointerBuffer.get(233);
        this.alBufferSubSamplesSOFT = pointerBuffer.get(234);
        this.alGetBufferSamplesSOFT = pointerBuffer.get(235);
        this.alIsBufferFormatSupportedSOFT = pointerBuffer.get(236);
        this.alBufferSubDataSOFT = pointerBuffer.get(237);
        this.alBufferSubDataDirectSOFT = pointerBuffer.get(238);
        this.alBufferCallbackSOFT = pointerBuffer.get(239);
        this.alBufferCallbackDirectSOFT = pointerBuffer.get(240);
        this.alGetBufferPtrSOFT = pointerBuffer.get(241);
        this.alGetBufferPtrDirectSOFT = pointerBuffer.get(242);
        this.alGetBuffer3PtrSOFT = pointerBuffer.get(243);
        this.alGetBuffer3PtrDirectSOFT = pointerBuffer.get(244);
        this.alGetBufferPtrvSOFT = pointerBuffer.get(245);
        this.alGetBufferPtrvDirectSOFT = pointerBuffer.get(246);
        this.alDeferUpdatesSOFT = pointerBuffer.get(247);
        this.alDeferUpdatesDirectSOFT = pointerBuffer.get(248);
        this.alProcessUpdatesSOFT = pointerBuffer.get(249);
        this.alProcessUpdatesDirectSOFT = pointerBuffer.get(250);
        this.alEventControlSOFT = pointerBuffer.get(251);
        this.alEventControlDirectSOFT = pointerBuffer.get(252);
        this.alEventCallbackSOFT = pointerBuffer.get(253);
        this.alEventCallbackDirectSOFT = pointerBuffer.get(254);
        this.alGetPointerSOFT = pointerBuffer.get(255);
        this.alGetPointerDirectSOFT = pointerBuffer.get(256);
        this.alGetPointervSOFT = pointerBuffer.get(257);
        this.alGetPointervDirectSOFT = pointerBuffer.get(258);
        this.alSourcedSOFT = pointerBuffer.get(259);
        this.alSourcedDirectSOFT = pointerBuffer.get(260);
        this.alSource3dSOFT = pointerBuffer.get(261);
        this.alSource3dDirectSOFT = pointerBuffer.get(262);
        this.alSourcedvSOFT = pointerBuffer.get(263);
        this.alSourcedvDirectSOFT = pointerBuffer.get(264);
        this.alGetSourcedSOFT = pointerBuffer.get(265);
        this.alGetSourcedDirectSOFT = pointerBuffer.get(266);
        this.alGetSource3dSOFT = pointerBuffer.get(267);
        this.alGetSource3dDirectSOFT = pointerBuffer.get(268);
        this.alGetSourcedvSOFT = pointerBuffer.get(269);
        this.alGetSourcedvDirectSOFT = pointerBuffer.get(270);
        this.alSourcei64SOFT = pointerBuffer.get(271);
        this.alSourcei64DirectSOFT = pointerBuffer.get(272);
        this.alSource3i64SOFT = pointerBuffer.get(273);
        this.alSource3i64DirectSOFT = pointerBuffer.get(274);
        this.alSourcei64vSOFT = pointerBuffer.get(275);
        this.alSourcei64vDirectSOFT = pointerBuffer.get(276);
        this.alGetSourcei64SOFT = pointerBuffer.get(277);
        this.alGetSourcei64DirectSOFT = pointerBuffer.get(278);
        this.alGetSource3i64SOFT = pointerBuffer.get(279);
        this.alGetSource3i64DirectSOFT = pointerBuffer.get(280);
        this.alGetSourcei64vSOFT = pointerBuffer.get(281);
        this.alGetSourcei64vDirectSOFT = pointerBuffer.get(282);
        this.alGetStringiSOFT = pointerBuffer.get(283);
        this.alGetStringiDirectSOFT = pointerBuffer.get(284);
        this.alSourcePlayAtTimeSOFT = pointerBuffer.get(285);
        this.alSourcePlayAtTimeDirectSOFT = pointerBuffer.get(286);
        this.alSourcePlayAtTimevSOFT = pointerBuffer.get(287);
        this.alSourcePlayAtTimevDirectSOFT = pointerBuffer.get(288);
        this.addresses = ThreadLocalUtil.setupAddressBuffer(pointerBuffer);
    }

    public PointerBuffer getAddressBuffer() {
        return this.addresses;
    }

    private static boolean check_AL10(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("OpenAL10")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108}, "alGetError", "alGetErrorDirect", "alEnable", "alEnableDirect", "alDisable", "alDisableDirect", "alIsEnabled", "alIsEnabledDirect", "alGetBoolean", "alGetBooleanDirect", "alGetInteger", "alGetIntegerDirect", "alGetFloat", "alGetFloatDirect", "alGetDouble", "alGetDoubleDirect", "alGetBooleanv", "alGetBooleanvDirect", "alGetIntegerv", "alGetIntegervDirect", "alGetFloatv", "alGetFloatvDirect", "alGetDoublev", "alGetDoublevDirect", "alGetString", "alGetStringDirect", "alDistanceModel", "alDistanceModelDirect", "alDopplerFactor", "alDopplerFactorDirect", "alDopplerVelocity", "alListenerf", "alListenerfDirect", "alListeneri", "alListeneriDirect", "alListener3f", "alListener3fDirect", "alListenerfv", "alListenerfvDirect", "alGetListenerf", "alGetListenerfDirect", "alGetListeneri", "alGetListeneriDirect", "alGetListener3f", "alGetListener3fDirect", "alGetListenerfv", "alGetListenerfvDirect", "alGenSources", "alGenSourcesDirect", "alDeleteSources", "alDeleteSourcesDirect", "alIsSource", "alIsSourceDirect", "alSourcef", "alSourcefDirect", "alSource3f", "alSource3fDirect", "alSourcefv", "alSourcefvDirect", "alSourcei", "alSourceiDirect", "alGetSourcef", "alGetSourcefDirect", "alGetSource3f", "alGetSource3fDirect", "alGetSourcefv", "alGetSourcefvDirect", "alGetSourcei", "alGetSourceiDirect", "alGetSourceiv", "alGetSourceivDirect", "alSourceQueueBuffers", "alSourceQueueBuffersDirect", "alSourceUnqueueBuffers", "alSourceUnqueueBuffersDirect", "alSourcePlay", "alSourcePlayDirect", "alSourcePause", "alSourcePauseDirect", "alSourceStop", "alSourceStopDirect", "alSourceRewind", "alSourceRewindDirect", "alSourcePlayv", "alSourcePlayvDirect", "alSourcePausev", "alSourcePausevDirect", "alSourceStopv", "alSourceStopvDirect", "alSourceRewindv", "alSourceRewindvDirect", "alGenBuffers", "alGenBuffersDirect", "alDeleteBuffers", "alDeleteBuffersDirect", "alIsBuffer", "alIsBufferDirect", "alGetBufferf", "alGetBufferfDirect", "alGetBufferi", "alGetBufferiDirect", "alBufferData", "alBufferDataDirect", "alGetEnumValue", "alGetEnumValueDirect", "alGetProcAddress", "alGetProcAddressDirect", "alIsExtensionPresent", "alIsExtensionPresentDirect") || Checks.reportMissing("AL", "OpenAL10");
    }

    private static boolean check_AL11(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("OpenAL11")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144}, "alListener3i", "alListener3iDirect", "alGetListener3i", "alGetListener3iDirect", "alGetListeneriv", "alGetListenerivDirect", "alSource3i", "alSource3iDirect", "alGetSource3i", "alGetSource3iDirect", "alListeneriv", "alListenerivDirect", "alSourceiv", "alSourceivDirect", "alBufferf", "alBufferfDirect", "alBuffer3f", "alBuffer3fDirect", "alBufferfv", "alBufferfvDirect", "alBufferi", "alBufferiDirect", "alBuffer3i", "alBuffer3iDirect", "alBufferiv", "alBufferivDirect", "alGetBuffer3i", "alGetBuffer3iDirect", "alGetBufferiv", "alGetBufferivDirect", "alGetBuffer3f", "alGetBuffer3fDirect", "alGetBufferfv", "alGetBufferfvDirect", "alSpeedOfSound", "alSpeedOfSoundDirect") || Checks.reportMissing("AL", "OpenAL11");
    }

    private static boolean check_EXT_debug(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("AL_EXT_debug")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 164}, "alDebugMessageCallbackEXT", "alDebugMessageCallbackDirectEXT", "alDebugMessageInsertEXT", "alDebugMessageInsertDirectEXT", "alDebugMessageControlEXT", "alDebugMessageControlDirectEXT", "alPushDebugGroupEXT", "alPushDebugGroupDirectEXT", "alPopDebugGroupEXT", "alPopDebugGroupDirectEXT", "alGetDebugMessageLogEXT", "alGetDebugMessageLogDirectEXT", "alObjectLabelEXT", "alObjectLabelDirectEXT", "alGetObjectLabelEXT", "alGetObjectLabelDirectEXT", "alGetPointerEXT", "alGetPointerDirectEXT", "alGetPointervEXT", "alGetPointervDirectEXT") || Checks.reportMissing("AL", "AL_EXT_debug");
    }

    private static boolean check_EXT_EFX(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("ALC_EXT_EFX")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{165, 166, 167, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183, 184, 185, 186, 187, 188, 189, 190, 191, 192, 193, 194, 195, 196, 197, 198, 199, 200, 201, 202, 203, 204, 205, 206, 207, 208, 209, 210, 211, 212, 213, 214, 215, 216, 217, 218, 219, 220, 221, 222, 223, 224, 225, 226, 227, 228, 229, 230}, "alGenEffects", "alGenEffectsDirect", "alDeleteEffects", "alDeleteEffectsDirect", "alIsEffect", "alIsEffectDirect", "alEffecti", "alEffectiDirect", "alEffectiv", "alEffectivDirect", "alEffectf", "alEffectfDirect", "alEffectfv", "alEffectfvDirect", "alGetEffecti", "alGetEffectiDirect", "alGetEffectiv", "alGetEffectivDirect", "alGetEffectf", "alGetEffectfDirect", "alGetEffectfv", "alGetEffectfvDirect", "alGenFilters", "alGenFiltersDirect", "alDeleteFilters", "alDeleteFiltersDirect", "alIsFilter", "alIsFilterDirect", "alFilteri", "alFilteriDirect", "alFilteriv", "alFilterivDirect", "alFilterf", "alFilterfDirect", "alFilterfv", "alFilterfvDirect", "alGetFilteri", "alGetFilteriDirect", "alGetFilteriv", "alGetFilterivDirect", "alGetFilterf", "alGetFilterfDirect", "alGetFilterfv", "alGetFilterfvDirect", "alGenAuxiliaryEffectSlots", "alGenAuxiliaryEffectSlotsDirect", "alDeleteAuxiliaryEffectSlots", "alDeleteAuxiliaryEffectSlotsDirect", "alIsAuxiliaryEffectSlot", "alIsAuxiliaryEffectSlotDirect", "alAuxiliaryEffectSloti", "alAuxiliaryEffectSlotiDirect", "alAuxiliaryEffectSlotiv", "alAuxiliaryEffectSlotivDirect", "alAuxiliaryEffectSlotf", "alAuxiliaryEffectSlotfDirect", "alAuxiliaryEffectSlotfv", "alAuxiliaryEffectSlotfvDirect", "alGetAuxiliaryEffectSloti", "alGetAuxiliaryEffectSlotiDirect", "alGetAuxiliaryEffectSlotiv", "alGetAuxiliaryEffectSlotivDirect", "alGetAuxiliaryEffectSlotf", "alGetAuxiliaryEffectSlotfDirect", "alGetAuxiliaryEffectSlotfv", "alGetAuxiliaryEffectSlotfvDirect") || Checks.reportMissing("AL", "ALC_EXT_EFX");
    }

    private static boolean check_EXT_STATIC_BUFFER(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("AL_EXT_STATIC_BUFFER")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{231, 232}, "alBufferDataStatic", "alBufferDataStaticDirect") || Checks.reportMissing("AL", "AL_EXT_STATIC_BUFFER");
    }

    private static boolean check_SOFT_buffer_samples(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("AL_SOFT_buffer_samples")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{233, 234, 235, 236}, "alBufferSamplesSOFT", "alBufferSubSamplesSOFT", "alGetBufferSamplesSOFT", "alIsBufferFormatSupportedSOFT") || Checks.reportMissing("AL", "AL_SOFT_buffer_samples");
    }

    private static boolean check_SOFT_buffer_sub_data(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("AL_SOFT_buffer_sub_data")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{237, 238}, "alBufferSubDataSOFT", "alBufferSubDataDirectSOFT") || Checks.reportMissing("AL", "AL_SOFT_buffer_sub_data");
    }

    private static boolean check_SOFT_callback_buffer(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("AL_SOFT_callback_buffer")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{239, 240, 241, 242, 243, 244, 245, 246}, "alBufferCallbackSOFT", "alBufferCallbackDirectSOFT", "alGetBufferPtrSOFT", "alGetBufferPtrDirectSOFT", "alGetBuffer3PtrSOFT", "alGetBuffer3PtrDirectSOFT", "alGetBufferPtrvSOFT", "alGetBufferPtrvDirectSOFT") || Checks.reportMissing("AL", "AL_SOFT_callback_buffer");
    }

    private static boolean check_SOFT_deferred_updates(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("AL_SOFT_deferred_updates")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{247, 248, 249, 250}, "alDeferUpdatesSOFT", "alDeferUpdatesDirectSOFT", "alProcessUpdatesSOFT", "alProcessUpdatesDirectSOFT") || Checks.reportMissing("AL", "AL_SOFT_deferred_updates");
    }

    private static boolean check_SOFT_events(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("AL_SOFT_events")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{251, 252, 253, 254, 255, 256, 257, 258}, "alEventControlSOFT", "alEventControlDirectSOFT", "alEventCallbackSOFT", "alEventCallbackDirectSOFT", "alGetPointerSOFT", "alGetPointerDirectSOFT", "alGetPointervSOFT", "alGetPointervDirectSOFT") || Checks.reportMissing("AL", "AL_SOFT_events");
    }

    private static boolean check_SOFT_source_latency(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("AL_SOFT_source_latency")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{259, 260, 261, 262, 263, 264, 265, 266, 267, 268, 269, 270, 271, 272, 273, 274, 275, 276, 277, 278, 279, 280, 281, 282}, "alSourcedSOFT", "alSourcedDirectSOFT", "alSource3dSOFT", "alSource3dDirectSOFT", "alSourcedvSOFT", "alSourcedvDirectSOFT", "alGetSourcedSOFT", "alGetSourcedDirectSOFT", "alGetSource3dSOFT", "alGetSource3dDirectSOFT", "alGetSourcedvSOFT", "alGetSourcedvDirectSOFT", "alSourcei64SOFT", "alSourcei64DirectSOFT", "alSource3i64SOFT", "alSource3i64DirectSOFT", "alSourcei64vSOFT", "alSourcei64vDirectSOFT", "alGetSourcei64SOFT", "alGetSourcei64DirectSOFT", "alGetSource3i64SOFT", "alGetSource3i64DirectSOFT", "alGetSourcei64vSOFT", "alGetSourcei64vDirectSOFT") || Checks.reportMissing("AL", "AL_SOFT_source_latency");
    }

    private static boolean check_SOFT_source_resampler(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("AL_SOFT_source_resampler")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{283, 284}, "alGetStringiSOFT", "alGetStringiDirectSOFT") || Checks.reportMissing("AL", "AL_SOFT_source_resampler");
    }

    private static boolean check_SOFT_source_start_delay(FunctionProvider functionProvider, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("AL_SOFT_source_start_delay")) {
            return false;
        }
        return Checks.checkFunctions(functionProvider, pointerBuffer, new int[]{285, 286, 287, 288}, "alSourcePlayAtTimeSOFT", "alSourcePlayAtTimeDirectSOFT", "alSourcePlayAtTimevSOFT", "alSourcePlayAtTimevDirectSOFT") || Checks.reportMissing("AL", "AL_SOFT_source_start_delay");
    }
}

