/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.macosx;

import java.nio.Buffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.CLongBuffer;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.Library;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.SharedLibrary;
import org.lwjgl.system.macosx.CGEventTapCallBackI;
import org.lwjgl.system.macosx.CGPoint;

public class CoreGraphics {
    private static final SharedLibrary COREGRAPHICS = Library.loadNative(CoreGraphics.class, "org.lwjgl", "/System/Library/Frameworks/CoreGraphics.framework");
    public static final int kCGErrorSuccess = 0;
    public static final int kCGErrorFailure = 1000;
    public static final int kCGErrorIllegalArgument = 1001;
    public static final int kCGErrorInvalidConnection = 1002;
    public static final int kCGErrorInvalidContext = 1003;
    public static final int kCGErrorCannotComplete = 1004;
    public static final int kCGErrorNotImplemented = 1006;
    public static final int kCGErrorRangeCheck = 1007;
    public static final int kCGErrorTypeCheck = 1008;
    public static final int kCGErrorInvalidOperation = 1010;
    public static final int kCGErrorNoneAvailable = 1011;
    public static final int kCGEventNull = 0;
    public static final int kCGEventLeftMouseDown = 1;
    public static final int kCGEventLeftMouseUp = 2;
    public static final int kCGEventRightMouseDown = 3;
    public static final int kCGEventRightMouseUp = 4;
    public static final int kCGEventMouseMoved = 5;
    public static final int kCGEventLeftMouseDragged = 6;
    public static final int kCGEventRightMouseDragged = 7;
    public static final int kCGEventKeyDown = 10;
    public static final int kCGEventKeyUp = 11;
    public static final int kCGEventFlagsChanged = 12;
    public static final int kCGEventScrollWheel = 22;
    public static final int kCGEventTabletPointer = 23;
    public static final int kCGEventTabletProximity = 24;
    public static final int kCGEventOtherMouseDown = 25;
    public static final int kCGEventOtherMouseUp = 26;
    public static final int kCGEventOtherMouseDragged = 27;
    public static final int kCGEventTapDisabledByTimeout = -2;
    public static final int kCGEventTapDisabledByUserInput = -1;
    public static final int kCGMouseButtonLeft = 0;
    public static final int kCGMouseButtonRight = 1;
    public static final int kCGMouseButtonCenter = 2;
    public static final int kCGHIDEventTap = 0;
    public static final int kCGSessionEventTap = 1;
    public static final int kCGAnnotatedSessionEventTap = 2;
    public static final int kCGScrollEventUnitPixel = 0;
    public static final int kCGScrollEventUnitLine = 1;
    public static final int kCGMouseEventNumber = 0;
    public static final int kCGMouseEventClickState = 1;
    public static final int kCGMouseEventPressure = 2;
    public static final int kCGMouseEventButtonNumber = 3;
    public static final int kCGMouseEventDeltaX = 4;
    public static final int kCGMouseEventDeltaY = 5;
    public static final int kCGMouseEventInstantMouser = 6;
    public static final int kCGMouseEventSubtype = 7;
    public static final int kCGKeyboardEventAutorepeat = 8;
    public static final int kCGKeyboardEventKeycode = 9;
    public static final int kCGKeyboardEventKeyboardType = 10;
    public static final int kCGScrollWheelEventDeltaAxis1 = 11;
    public static final int kCGScrollWheelEventDeltaAxis2 = 12;
    public static final int kCGScrollWheelEventDeltaAxis3 = 13;
    public static final int kCGScrollWheelEventFixedPtDeltaAxis1 = 93;
    public static final int kCGScrollWheelEventFixedPtDeltaAxis2 = 94;
    public static final int kCGScrollWheelEventFixedPtDeltaAxis3 = 95;
    public static final int kCGScrollWheelEventPointDeltaAxis1 = 96;
    public static final int kCGScrollWheelEventPointDeltaAxis2 = 97;
    public static final int kCGScrollWheelEventPointDeltaAxis3 = 98;
    public static final int kCGScrollWheelEventScrollPhase = 99;
    public static final int kCGScrollWheelEventScrollCount = 100;
    public static final int kCGScrollWheelEventMomentumPhase = 123;
    public static final int kCGScrollWheelEventInstantMouser = 14;
    public static final int kCGTabletEventPointX = 15;
    public static final int kCGTabletEventPointY = 16;
    public static final int kCGTabletEventPointZ = 17;
    public static final int kCGTabletEventPointButtons = 18;
    public static final int kCGTabletEventPointPressure = 19;
    public static final int kCGTabletEventTiltX = 20;
    public static final int kCGTabletEventTiltY = 21;
    public static final int kCGTabletEventRotation = 22;
    public static final int kCGTabletEventTangentialPressure = 23;
    public static final int kCGTabletEventDeviceID = 24;
    public static final int kCGTabletEventVendor1 = 25;
    public static final int kCGTabletEventVendor2 = 26;
    public static final int kCGTabletEventVendor3 = 27;
    public static final int kCGTabletProximityEventVendorID = 28;
    public static final int kCGTabletProximityEventTabletID = 29;
    public static final int kCGTabletProximityEventPointerID = 30;
    public static final int kCGTabletProximityEventDeviceID = 31;
    public static final int kCGTabletProximityEventSystemTabletID = 32;
    public static final int kCGTabletProximityEventVendorPointerType = 33;
    public static final int kCGTabletProximityEventVendorPointerSerialNumber = 34;
    public static final int kCGTabletProximityEventVendorUniqueID = 35;
    public static final int kCGTabletProximityEventCapabilityMask = 36;
    public static final int kCGTabletProximityEventPointerType = 37;
    public static final int kCGTabletProximityEventEnterProximity = 38;
    public static final int kCGEventTargetProcessSerialNumber = 39;
    public static final int kCGEventTargetUnixProcessID = 40;
    public static final int kCGEventSourceUnixProcessID = 41;
    public static final int kCGEventSourceUserData = 42;
    public static final int kCGEventSourceUserID = 43;
    public static final int kCGEventSourceGroupID = 44;
    public static final int kCGEventSourceStateID = 45;
    public static final int kCGScrollWheelEventIsContinuous = 88;
    public static final int kCGMouseEventWindowUnderMousePointer = 91;
    public static final int kCGMouseEventWindowUnderMousePointerThatCanHandleThisEvent = 92;
    public static final int kCGEventMouseSubtypeDefault = 0;
    public static final int kCGEventMouseSubtypeTabletPoint = 1;
    public static final int kCGEventMouseSubtypeTabletProximity = 2;

    public static SharedLibrary getLibrary() {
        return COREGRAPHICS;
    }

    protected CoreGraphics() {
        throw new UnsupportedOperationException();
    }

    @NativeType(value="CFTypeID")
    public static long CGEventGetTypeID() {
        long l = Functions.EventGetTypeID;
        return JNI.invokeJ(l);
    }

    @NativeType(value="CGEventRef")
    public static long CGEventCreate(@NativeType(value="CGEventSourceRef") long l) {
        long l2 = Functions.EventCreate;
        return JNI.invokePP(l, l2);
    }

    @NativeType(value="CFDataRef")
    public static long CGEventCreateData(@NativeType(value="CFAllocatorRef") long l, @NativeType(value="CGEventRef") long l2) {
        long l3 = Functions.EventCreateData;
        return JNI.invokePPP(l, l2, l3);
    }

    @NativeType(value="CGEventRef")
    public static long CGEventCreateFromData(@NativeType(value="CFAllocatorRef") long l, @NativeType(value="CFDataRef") long l2) {
        long l3 = Functions.EventCreateFromData;
        return JNI.invokePPP(l, l2, l3);
    }

    public static native long nCGEventCreateMouseEvent(long var0, int var2, long var3, int var5, long var6);

    public static long nCGEventCreateMouseEvent(long l, int n, long l2, int n2) {
        long l3 = Functions.EventCreateMouseEvent;
        return CoreGraphics.nCGEventCreateMouseEvent(l, n, l2, n2, l3);
    }

    @NativeType(value="CGEventRef")
    public static long CGEventCreateMouseEvent(@NativeType(value="CGEventSourceRef") long l, @NativeType(value="CGEventType") int n, CGPoint cGPoint, @NativeType(value="CGMouseButton") int n2) {
        return CoreGraphics.nCGEventCreateMouseEvent(l, n, cGPoint.address(), n2);
    }

    @NativeType(value="CGEventRef")
    public static long CGEventCreateKeyboardEvent(@NativeType(value="CGEventSourceRef") long l, @NativeType(value="CGKeyCode") short s, @NativeType(value="bool") boolean bl) {
        long l2 = Functions.EventCreateKeyboardEvent;
        return JNI.invokePCP(l, s, bl, l2);
    }

    @NativeType(value="CGEventRef")
    public static long CGEventCreateScrollWheelEvent(@NativeType(value="CGEventSourceRef") long l, @NativeType(value="CGScrollEventUnit") int n, @NativeType(value="uint32_t") int n2, @NativeType(value="int32_t") int n3) {
        long l2 = Functions.EventCreateScrollWheelEvent;
        return JNI.invokePP(l, n, n2, n3, l2);
    }

    @NativeType(value="CGEventRef")
    public static long CGEventCreateScrollWheelEvent(@NativeType(value="CGEventSourceRef") long l, @NativeType(value="CGScrollEventUnit") int n, @NativeType(value="int32_t") int n2) {
        long l2 = Functions.EventCreateScrollWheelEvent;
        return JNI.invokePP(l, n, 1, n2, l2);
    }

    @NativeType(value="CGEventRef")
    public static long CGEventCreateScrollWheelEvent2(@NativeType(value="CGEventSourceRef") long l, @NativeType(value="CGScrollEventUnit") int n, @NativeType(value="uint32_t") int n2, @NativeType(value="int32_t") int n3, @NativeType(value="int32_t") int n4, @NativeType(value="int32_t") int n5) {
        long l2 = Functions.EventCreateScrollWheelEvent2;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.invokePP(l, n, n2, n3, n4, n5, l2);
    }

    @NativeType(value="CGEventRef")
    public static long CGEventCreateCopy(@NativeType(value="CGEventRef") long l) {
        long l2 = Functions.EventCreateCopy;
        return JNI.invokePP(l, l2);
    }

    @NativeType(value="CGEventSourceRef")
    public static long CGEventCreateSourceFromEvent(@NativeType(value="CGEventRef") long l) {
        long l2 = Functions.EventCreateSourceFromEvent;
        return JNI.invokePP(l, l2);
    }

    public static void CGEventSetSource(@NativeType(value="CGEventRef") long l, @NativeType(value="CGEventSourceRef") long l2) {
        long l3 = Functions.EventSetSource;
        JNI.invokePPV(l, l2, l3);
    }

    @NativeType(value="CGEventType")
    public static int CGEventGetType(@NativeType(value="CGEventRef") long l) {
        long l2 = Functions.EventGetType;
        return JNI.invokePI(l, l2);
    }

    public static void CGEventSetType(@NativeType(value="CGEventRef") long l, @NativeType(value="CGEventType") int n) {
        long l2 = Functions.EventSetType;
        JNI.invokePV(l, n, l2);
    }

    @NativeType(value="CGEventTimestamp")
    public static long CGEventGetTimestamp(@NativeType(value="CGEventRef") long l) {
        long l2 = Functions.EventGetTimestamp;
        return JNI.invokePJ(l, l2);
    }

    public static void CGEventSetTimestamp(@NativeType(value="CGEventRef") long l, @NativeType(value="CGEventTimestamp") long l2) {
        long l3 = Functions.EventSetTimestamp;
        JNI.invokePJV(l, l2, l3);
    }

    public static native void nCGEventGetLocation(long var0, long var2, long var4);

    public static void nCGEventGetLocation(long l, long l2) {
        long l3 = Functions.EventGetLocation;
        CoreGraphics.nCGEventGetLocation(l, l3, l2);
    }

    public static CGPoint CGEventGetLocation(@NativeType(value="CGEventRef") long l, CGPoint cGPoint) {
        CoreGraphics.nCGEventGetLocation(l, cGPoint.address());
        return cGPoint;
    }

    public static native void nCGEventGetUnflippedLocation(long var0, long var2, long var4);

    public static void nCGEventGetUnflippedLocation(long l, long l2) {
        long l3 = Functions.EventGetUnflippedLocation;
        CoreGraphics.nCGEventGetUnflippedLocation(l, l3, l2);
    }

    public static CGPoint CGEventGetUnflippedLocation(@NativeType(value="CGEventRef") long l, CGPoint cGPoint) {
        CoreGraphics.nCGEventGetUnflippedLocation(l, cGPoint.address());
        return cGPoint;
    }

    public static native void nCGEventSetLocation(long var0, long var2, long var4);

    public static void nCGEventSetLocation(long l, long l2) {
        long l3 = Functions.EventSetLocation;
        CoreGraphics.nCGEventSetLocation(l, l2, l3);
    }

    public static void CGEventSetLocation(@NativeType(value="CGEventRef") long l, CGPoint cGPoint) {
        CoreGraphics.nCGEventSetLocation(l, cGPoint.address());
    }

    @NativeType(value="CGEventFlags")
    public static long CGEventGetFlags(@NativeType(value="CGEventRef") long l) {
        long l2 = Functions.EventGetFlags;
        return JNI.invokePJ(l, l2);
    }

    public static void CGEventSetFlags(@NativeType(value="CGEventRef") long l, @NativeType(value="CGEventFlags") long l2) {
        long l3 = Functions.EventSetFlags;
        JNI.invokePJV(l, l2, l3);
    }

    public static void nCGEventKeyboardGetUnicodeString(long l, long l2, long l3, long l4) {
        long l5 = Functions.EventKeyboardGetUnicodeString;
        JNI.invokePNPPV(l, l2, l3, l4, l5);
    }

    public static void CGEventKeyboardGetUnicodeString(@NativeType(value="CGEventRef") long l, @NativeType(value="UniCharCount *") @Nullable CLongBuffer cLongBuffer, @NativeType(value="UniChar *") @Nullable ShortBuffer shortBuffer) {
        if (Checks.CHECKS) {
            Checks.checkSafe(cLongBuffer, 1);
        }
        CoreGraphics.nCGEventKeyboardGetUnicodeString(l, Checks.remainingSafe(shortBuffer), MemoryUtil.memAddressSafe(cLongBuffer), MemoryUtil.memAddressSafe(shortBuffer));
    }

    public static void nCGEventKeyboardSetUnicodeString(long l, long l2, long l3) {
        long l4 = Functions.EventKeyboardSetUnicodeString;
        JNI.invokePNPV(l, l2, l3, l4);
    }

    public static void CGEventKeyboardSetUnicodeString(@NativeType(value="CGEventRef") long l, @NativeType(value="UniChar const *") ShortBuffer shortBuffer) {
        CoreGraphics.nCGEventKeyboardSetUnicodeString(l, shortBuffer.remaining(), MemoryUtil.memAddress(shortBuffer));
    }

    @NativeType(value="int64_t")
    public static long CGEventGetIntegerValueField(@NativeType(value="CGEventRef") long l, @NativeType(value="CGEventField") int n) {
        long l2 = Functions.EventGetIntegerValueField;
        return JNI.invokePJ(l, n, l2);
    }

    public static void CGEventSetIntegerValueField(@NativeType(value="CGEventRef") long l, @NativeType(value="CGEventField") int n, @NativeType(value="int64_t") long l2) {
        long l3 = Functions.EventSetIntegerValueField;
        JNI.invokePJV(l, n, l2, l3);
    }

    public static double CGEventGetDoubleValueField(@NativeType(value="CGEventRef") long l, @NativeType(value="CGEventField") int n) {
        long l2 = Functions.EventGetDoubleValueField;
        return JNI.invokePD(l, n, l2);
    }

    public static void CGEventSetDoubleValueField(@NativeType(value="CGEventRef") long l, @NativeType(value="CGEventField") int n, double d) {
        long l2 = Functions.EventSetDoubleValueField;
        JNI.invokePV(l, n, d, l2);
    }

    public static long nCGEventTapCreate(int n, int n2, int n3, long l, long l2, long l3) {
        long l4 = Functions.EventTapCreate;
        return JNI.invokeJPPP(n, n2, n3, l, l2, l3, l4);
    }

    @NativeType(value="CFMachPortRef")
    public static long CGEventTapCreate(@NativeType(value="CGEventTapLocation") int n, @NativeType(value="CGEventTapPlacement") int n2, @NativeType(value="CGEventTapOptions") int n3, @NativeType(value="CGEventMask") long l, @NativeType(value="CGEventRef (*) (CGEventTapProxy, CGEventType, CGEventRef, void *)") CGEventTapCallBackI cGEventTapCallBackI, @NativeType(value="void *") long l2) {
        return CoreGraphics.nCGEventTapCreate(n, n2, n3, l, cGEventTapCallBackI.address(), l2);
    }

    public static long nCGEventTapCreateForPid(long l, int n, int n2, long l2, long l3, long l4) {
        long l5 = Functions.EventTapCreateForPid;
        if (Checks.CHECKS) {
            Checks.check(l5);
            Checks.check(l);
        }
        return JNI.invokePJPPP(l, n, n2, l2, l3, l4, l5);
    }

    @NativeType(value="CFMachPortRef")
    public static long CGEventTapCreateForPid(@NativeType(value="pid_t") long l, @NativeType(value="CGEventTapPlacement") int n, @NativeType(value="CGEventTapOptions") int n2, @NativeType(value="CGEventMask") long l2, @NativeType(value="CGEventRef (*) (CGEventTapProxy, CGEventType, CGEventRef, void *)") CGEventTapCallBackI cGEventTapCallBackI, @NativeType(value="void *") long l3) {
        return CoreGraphics.nCGEventTapCreateForPid(l, n, n2, l2, cGEventTapCallBackI.address(), l3);
    }

    public static void CGEventTapEnable(@NativeType(value="CFMachPortRef") long l, @NativeType(value="bool") boolean bl) {
        long l2 = Functions.EventTapEnable;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        JNI.invokePV(l, bl, l2);
    }

    @NativeType(value="bool")
    public static boolean CGEventTapIsEnabled(@NativeType(value="CFMachPortRef") long l) {
        long l2 = Functions.EventTapIsEnabled;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        return JNI.invokePZ(l, l2);
    }

    public static void CGEventTapPostEvent(@NativeType(value="CGEventTapProxy") long l, @NativeType(value="CGEventRef") long l2) {
        long l3 = Functions.EventTapPostEvent;
        JNI.invokePPV(l, l2, l3);
    }

    public static void CGEventPost(@NativeType(value="CGEventTapLocation") int n, @NativeType(value="CGEventRef") long l) {
        long l2 = Functions.EventPost;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        JNI.invokePV(n, l, l2);
    }

    public static void CGEventPostToPid(@NativeType(value="pid_t") long l, @NativeType(value="CGEventRef") long l2) {
        long l3 = Functions.EventPostToPid;
        if (Checks.CHECKS) {
            Checks.check(l3);
            Checks.check(l);
        }
        JNI.invokePPV(l, l2, l3);
    }

    public static int nCGGetEventTapList(int n, long l, long l2) {
        long l3 = Functions.GetEventTapList;
        return JNI.invokePPI(n, l, l2, l3);
    }

    @NativeType(value="CGError")
    public static int CGGetEventTapList(@NativeType(value="CGEventTapInformation *")  @Nullable CGEventTapInformation.Buffer buffer, @NativeType(value="uint32_t *") @Nullable IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)intBuffer, 1);
        }
        return CoreGraphics.nCGGetEventTapList(Checks.remainingSafe(buffer), MemoryUtil.memAddressSafe(buffer), MemoryUtil.memAddressSafe(intBuffer));
    }

    public static void CGEventKeyboardGetUnicodeString(@NativeType(value="CGEventRef") long l, @NativeType(value="UniCharCount *") @Nullable CLongBuffer cLongBuffer, @NativeType(value="UniChar *") short @Nullable [] sArray) {
        long l2 = Functions.EventKeyboardGetUnicodeString;
        if (Checks.CHECKS) {
            Checks.checkSafe(cLongBuffer, 1);
        }
        JNI.invokePNPPV(l, (long)Checks.lengthSafe(sArray), MemoryUtil.memAddressSafe(cLongBuffer), sArray, l2);
    }

    public static void CGEventKeyboardSetUnicodeString(@NativeType(value="CGEventRef") long l, @NativeType(value="UniChar const *") short[] sArray) {
        long l2 = Functions.EventKeyboardSetUnicodeString;
        JNI.invokePNPV(l, (long)sArray.length, sArray, l2);
    }

    @NativeType(value="CGError")
    public static int CGGetEventTapList(@NativeType(value="CGEventTapInformation *")  @Nullable CGEventTapInformation.Buffer buffer, @NativeType(value="uint32_t *") int @Nullable [] nArray) {
        long l = Functions.GetEventTapList;
        if (Checks.CHECKS) {
            Checks.checkSafe(nArray, 1);
        }
        return JNI.invokePPI(Checks.remainingSafe(buffer), MemoryUtil.memAddressSafe(buffer), nArray, l);
    }

    static /* synthetic */ SharedLibrary access$000() {
        return COREGRAPHICS;
    }

    public static final class Functions {
        public static final long EventGetTypeID = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventGetTypeID");
        public static final long EventCreate = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventCreate");
        public static final long EventCreateData = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventCreateData");
        public static final long EventCreateFromData = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventCreateFromData");
        public static final long EventCreateMouseEvent = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventCreateMouseEvent");
        public static final long EventCreateKeyboardEvent = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventCreateKeyboardEvent");
        public static final long EventCreateScrollWheelEvent = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventCreateScrollWheelEvent");
        public static final long EventCreateScrollWheelEvent2 = APIUtil.apiGetFunctionAddressOptional(CoreGraphics.access$000(), "CGEventCreateScrollWheelEvent2");
        public static final long EventCreateCopy = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventCreateCopy");
        public static final long EventCreateSourceFromEvent = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventCreateSourceFromEvent");
        public static final long EventSetSource = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventSetSource");
        public static final long EventGetType = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventGetType");
        public static final long EventSetType = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventSetType");
        public static final long EventGetTimestamp = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventGetTimestamp");
        public static final long EventSetTimestamp = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventSetTimestamp");
        public static final long EventGetLocation = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventGetLocation");
        public static final long EventGetUnflippedLocation = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventGetUnflippedLocation");
        public static final long EventSetLocation = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventSetLocation");
        public static final long EventGetFlags = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventGetFlags");
        public static final long EventSetFlags = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventSetFlags");
        public static final long EventKeyboardGetUnicodeString = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventKeyboardGetUnicodeString");
        public static final long EventKeyboardSetUnicodeString = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventKeyboardSetUnicodeString");
        public static final long EventGetIntegerValueField = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventGetIntegerValueField");
        public static final long EventSetIntegerValueField = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventSetIntegerValueField");
        public static final long EventGetDoubleValueField = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventGetDoubleValueField");
        public static final long EventSetDoubleValueField = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventSetDoubleValueField");
        public static final long EventTapCreate = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventTapCreate");
        public static final long EventTapCreateForPid = APIUtil.apiGetFunctionAddressOptional(CoreGraphics.access$000(), "CGEventTapCreateForPid");
        public static final long EventTapEnable = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventTapEnable");
        public static final long EventTapIsEnabled = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventTapIsEnabled");
        public static final long EventTapPostEvent = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventTapPostEvent");
        public static final long EventPost = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGEventPost");
        public static final long EventPostToPid = APIUtil.apiGetFunctionAddressOptional(CoreGraphics.access$000(), "CGEventPostToPid");
        public static final long GetEventTapList = APIUtil.apiGetFunctionAddress(CoreGraphics.access$000(), "CGGetEventTapList");

        private Functions() {
        }
    }
}

