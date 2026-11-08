/*
 * Decompiled with CFR 0.152.
 */
package kotlin.time;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.ComparableTimeMark;
import kotlin.time.Duration;
import kotlin.time.ExperimentalTime;
import kotlin.time.MonotonicTimeSource;
import kotlin.time.TimeMark;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 9, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 \u00042\u00020\u0001:\u0003\u0004\u0005\u0006J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0007"}, d2={"Lkotlin/time/TimeSource;", "", "markNow", "Lkotlin/time/TimeMark;", "Companion", "Monotonic", "WithComparableMarks", "kotlin-stdlib"})
@SinceKotlin(version="1.9")
@WasExperimental(markerClass={ExperimentalTime.class})
public interface TimeSource {
    @NotNull
    public static final Companion Companion = kotlin.time.TimeSource$Companion.$$INSTANCE;

    @NotNull
    public TimeMark markNow();

    @Metadata(mv={1, 9, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2={"Lkotlin/time/TimeSource$Companion;", "", "()V", "kotlin-stdlib"})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE;

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
        }
    }

    @Metadata(mv={1, 9, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\tB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u0004H\u0016\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016\u0082\u0002\b\n\u0002\b!\n\u0002\b\u0019\u00a8\u0006\n"}, d2={"Lkotlin/time/TimeSource$Monotonic;", "Lkotlin/time/TimeSource$WithComparableMarks;", "()V", "markNow", "Lkotlin/time/TimeSource$Monotonic$ValueTimeMark;", "markNow-z9LOYto", "()J", "toString", "", "ValueTimeMark", "kotlin-stdlib"})
    public static final class Monotonic
    implements WithComparableMarks {
        @NotNull
        public static final Monotonic INSTANCE = new Monotonic();

        private Monotonic() {
        }

        public long m70202d1709() {
            return MonotonicTimeSource.INSTANCE.ma1f12454e4();
        }

        @NotNull
        public String toString() {
            return MonotonicTimeSource.INSTANCE.toString();
        }

        @JvmInline
        @Metadata(mv={1, 9, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0087@\u0018\u00002\u00020\u0001B\u0018\b\u0000\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0000H\u0086\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\f\u001a\u00020\rH\u0016\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u0006J\u001a\u0010\u000f\u001a\u00020\u00102\b\u0010\t\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0010H\u0016\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0010H\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0016J\u0010\u0010\u0019\u001a\u00020\bH\u00d6\u0001\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u001e\u0010\u001c\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0001H\u0096\u0002\u00f8\u0001\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u001b\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\rH\u0096\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b \u0010!J\u001b\u0010\u001c\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0000H\u0086\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\"\u0010!J\u001b\u0010#\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\rH\u0096\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b$\u0010!J\u0010\u0010%\u001a\u00020&H\u00d6\u0001\u00a2\u0006\u0004\b'\u0010(R\u0012\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X\u0080\u0004\u00a2\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00060\u0003j\u0002`\u0004\u00f8\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!\u00a8\u0006)"}, d2={"Lkotlin/time/TimeSource$Monotonic$ValueTimeMark;", "Lkotlin/time/ComparableTimeMark;", "reading", "", "Lkotlin/time/ValueTimeMarkReading;", "constructor-impl", "(J)J", "compareTo", "", "other", "compareTo-6eNON_k", "(JJ)I", "elapsedNow", "Lkotlin/time/Duration;", "elapsedNow-UwyO8pc", "equals", "", "", "equals-impl", "(JLjava/lang/Object;)Z", "hasNotPassedNow", "hasNotPassedNow-impl", "(J)Z", "hasPassedNow", "hasPassedNow-impl", "hashCode", "hashCode-impl", "(J)I", "minus", "minus-UwyO8pc", "(JLkotlin/time/ComparableTimeMark;)J", "duration", "minus-LRDsOJo", "(JJ)J", "minus-6eNON_k", "plus", "plus-LRDsOJo", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "kotlin-stdlib"})
        @SinceKotlin(version="1.9")
        @WasExperimental(markerClass={ExperimentalTime.class})
        public static final class ValueTimeMark
        implements ComparableTimeMark {
            private final long reading;

            public static long m36e7b25259(long l) {
                return MonotonicTimeSource.INSTANCE.m0421b8f6ba(l);
            }

            public long m496b00bd53() {
                return ValueTimeMark.m36e7b25259(this.reading);
            }

            public static long me1aeae5c14(long l, long l2) {
                return MonotonicTimeSource.INSTANCE.mc402745f7f(l, l2);
            }

            public long m52206d419b(long l) {
                return ValueTimeMark.me1aeae5c14(this.reading, l);
            }

            public static long m00acd9e39e(long l, long l2) {
                return MonotonicTimeSource.INSTANCE.mc402745f7f(l, Duration.m685dce2650(l2));
            }

            public long m2b55fb0bec(long l) {
                return ValueTimeMark.m00acd9e39e(this.reading, l);
            }

            public static boolean m020d066308(long l) {
                return !Duration.mf1d0e3de7e(ValueTimeMark.m36e7b25259(l));
            }

            @Override
            public boolean hasPassedNow() {
                return ValueTimeMark.m020d066308(this.reading);
            }

            public static boolean m8db43031f9(long l) {
                return Duration.mf1d0e3de7e(ValueTimeMark.m36e7b25259(l));
            }

            @Override
            public boolean hasNotPassedNow() {
                return ValueTimeMark.m8db43031f9(this.reading);
            }

            public static long m5d8019add5(long l, @NotNull ComparableTimeMark comparableTimeMark) {
                Intrinsics.checkNotNullParameter(comparableTimeMark, "other");
                if (!(comparableTimeMark instanceof ValueTimeMark)) {
                    throw new IllegalArgumentException("Subtracting or comparing time marks from different time sources is not possible: " + ValueTimeMark.m16bf61ea18(l) + " and " + comparableTimeMark);
                }
                return ValueTimeMark.m168b936496(l, ((ValueTimeMark)comparableTimeMark).m21e5f20348());
            }

            public long mfbff367c1f(@NotNull ComparableTimeMark comparableTimeMark) {
                Intrinsics.checkNotNullParameter(comparableTimeMark, "other");
                return ValueTimeMark.m5d8019add5(this.reading, comparableTimeMark);
            }

            public static final long m168b936496(long l, long l2) {
                return MonotonicTimeSource.INSTANCE.m5e512a0aac(l, l2);
            }

            public static final int m4fe5020435(long l, long l2) {
                return Duration.mbcf8f77d4d(ValueTimeMark.m168b936496(l, l2), Duration.Companion.m2938348b32());
            }

            public static int ma85efb904c(long l, @NotNull ComparableTimeMark comparableTimeMark) {
                Intrinsics.checkNotNullParameter(comparableTimeMark, "other");
                return ValueTimeMark.m114a6f8013(l).compareTo(comparableTimeMark);
            }

            @Override
            public int compareTo(@NotNull ComparableTimeMark comparableTimeMark) {
                return ComparableTimeMark.DefaultImpls.compareTo(this, comparableTimeMark);
            }

            public static String m16bf61ea18(long l) {
                return "ValueTimeMark(reading=" + l + ')';
            }

            public String toString() {
                return ValueTimeMark.m16bf61ea18(this.reading);
            }

            public static int mdd85a02603(long l) {
                return Long.hashCode(l);
            }

            @Override
            public int hashCode() {
                return ValueTimeMark.mdd85a02603(this.reading);
            }

            public static boolean maf915f4f7a(long l, Object object) {
                if (!(object instanceof ValueTimeMark)) {
                    return false;
                }
                long l2 = ((ValueTimeMark)object).m21e5f20348();
                return l == l2;
            }

            @Override
            public boolean equals(Object object) {
                return ValueTimeMark.maf915f4f7a(this.reading, object);
            }

            private /* synthetic */ ValueTimeMark(long l) {
                this.reading = l;
            }

            public static long m44ea958be4(long l) {
                return l;
            }

            public static final /* synthetic */ ValueTimeMark m114a6f8013(long l) {
                return new ValueTimeMark(l);
            }

            public final /* synthetic */ long m21e5f20348() {
                return this.reading;
            }

            public static final boolean m7c05e07e44(long l, long l2) {
                return l == l2;
            }
        }
    }

    @Metadata(mv={1, 9, 0}, k=1, xi=48, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2={"Lkotlin/time/TimeSource$WithComparableMarks;", "Lkotlin/time/TimeSource;", "markNow", "Lkotlin/time/ComparableTimeMark;", "kotlin-stdlib"})
    @SinceKotlin(version="1.9")
    @WasExperimental(markerClass={ExperimentalTime.class})
    public static interface WithComparableMarks
    extends TimeSource {
        @Override
        @NotNull
        public ComparableTimeMark markNow();
    }
}

