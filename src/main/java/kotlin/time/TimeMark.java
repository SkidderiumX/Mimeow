/*
 * Decompiled with CFR 0.152.
 */
package kotlin.time;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.time.AdjustedTimeMark;
import kotlin.time.Duration;
import kotlin.time.ExperimentalTime;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 9, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\u0015\u0010\u0002\u001a\u00020\u0003H&\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u001b\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0003H\u0096\u0002\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\r\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0003H\u0096\u0002\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u000e\u0010\f\u0082\u0002\b\n\u0002\b!\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2={"Lkotlin/time/TimeMark;", "", "elapsedNow", "Lkotlin/time/Duration;", "elapsedNow-UwyO8pc", "()J", "hasNotPassedNow", "", "hasPassedNow", "minus", "duration", "minus-LRDsOJo", "(J)Lkotlin/time/TimeMark;", "plus", "plus-LRDsOJo", "kotlin-stdlib"})
@SinceKotlin(version="1.9")
@WasExperimental(markerClass={ExperimentalTime.class})
public interface TimeMark {
    public long m9149ac32e0();

    @NotNull
    public TimeMark m4e97f239f0(long var1);

    @NotNull
    public TimeMark m316f6ba1fd(long var1);

    public boolean hasPassedNow();

    public boolean hasNotPassedNow();

    @Metadata(mv={1, 9, 0}, k=3, xi=48)
    public static final class DefaultImpls {
        @NotNull
        public static TimeMark mc27502b833(@NotNull TimeMark timeMark, long l) {
            return new AdjustedTimeMark(timeMark, l, null);
        }

        @NotNull
        public static TimeMark m6d19a8cf37(@NotNull TimeMark timeMark, long l) {
            return timeMark.m4e97f239f0(Duration.m685dce2650(l));
        }

        public static boolean hasPassedNow(@NotNull TimeMark timeMark) {
            return !Duration.mf1d0e3de7e(timeMark.m9149ac32e0());
        }

        public static boolean hasNotPassedNow(@NotNull TimeMark timeMark) {
            return Duration.mf1d0e3de7e(timeMark.m9149ac32e0());
        }
    }
}

