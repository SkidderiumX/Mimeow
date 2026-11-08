/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.protocol.version;

import com.google.common.collect.Range;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.Nullable;

public class ProtocolVersionRange {
    private List<Range<ProtocolVersion>> ranges;

    private ProtocolVersionRange(List<Range<ProtocolVersion>> list) {
        if (list != null) {
            this.ranges = new ArrayList<Range<ProtocolVersion>>(list);
        }
    }

    public static ProtocolVersionRange all() {
        return new ProtocolVersionRange(null);
    }

    public static ProtocolVersionRange of(ProtocolVersion protocolVersion, ProtocolVersion protocolVersion2) {
        return new ProtocolVersionRange(Collections.singletonList(Range.open(protocolVersion, protocolVersion2)));
    }

    public static ProtocolVersionRange of(Range<ProtocolVersion> range) {
        return new ProtocolVersionRange(Collections.singletonList(range));
    }

    public static ProtocolVersionRange of(List<Range<ProtocolVersion>> list) {
        return new ProtocolVersionRange(list);
    }

    public static ProtocolVersionRange singleton(ProtocolVersion protocolVersion) {
        return new ProtocolVersionRange(Collections.singletonList(Range.singleton(protocolVersion)));
    }

    public static ProtocolVersionRange andNewer(ProtocolVersion protocolVersion) {
        return new ProtocolVersionRange(Collections.singletonList(Range.atLeast(protocolVersion)));
    }

    public static ProtocolVersionRange andOlder(ProtocolVersion protocolVersion) {
        return new ProtocolVersionRange(Collections.singletonList(Range.atMost(protocolVersion)));
    }

    public ProtocolVersionRange add(Range<ProtocolVersion> range) {
        if (this.ranges == null) {
            throw new UnsupportedOperationException("Range already contains all versions. Cannot add a new range.");
        }
        this.ranges.add(range);
        return this;
    }

    public ProtocolVersionRange add(ProtocolVersionRange protocolVersionRange) {
        if (this.ranges == null) {
            throw new UnsupportedOperationException("Range already contains all versions. Cannot add a new range.");
        }
        if (protocolVersionRange.ranges != null) {
            this.ranges.addAll(protocolVersionRange.ranges);
        } else {
            this.ranges = null;
        }
        return this;
    }

    public boolean contains(ProtocolVersion protocolVersion) {
        if (this.ranges == null) {
            return true;
        }
        for (Range<ProtocolVersion> range : this.ranges) {
            if (!range.contains(protocolVersion)) continue;
            return true;
        }
        return false;
    }

    public @Nullable ProtocolVersion getMin() {
        ProtocolVersion protocolVersion = null;
        if (this.ranges != null) {
            for (Range<ProtocolVersion> range : this.ranges) {
                if (!range.hasLowerBound()) continue;
                ProtocolVersion protocolVersion2 = range.lowerEndpoint();
                if (protocolVersion != null && protocolVersion2.compareTo(protocolVersion) >= 0) continue;
                protocolVersion = protocolVersion2;
            }
        }
        return protocolVersion;
    }

    public @Nullable ProtocolVersion getMax() {
        ProtocolVersion protocolVersion = null;
        if (this.ranges != null) {
            for (Range<ProtocolVersion> range : this.ranges) {
                if (!range.hasUpperBound()) continue;
                ProtocolVersion protocolVersion2 = range.upperEndpoint();
                if (protocolVersion != null && protocolVersion2.compareTo(protocolVersion) <= 0) continue;
                protocolVersion = protocolVersion2;
            }
        }
        return protocolVersion;
    }

    public String toString() {
        if (this.ranges != null) {
            StringBuilder stringBuilder = new StringBuilder();
            int n = 0;
            for (Range<ProtocolVersion> range : this.ranges) {
                ProtocolVersion protocolVersion;
                ++n;
                ProtocolVersion protocolVersion2 = range.hasLowerBound() ? range.lowerEndpoint() : null;
                ProtocolVersion protocolVersion3 = protocolVersion = range.hasUpperBound() ? range.upperEndpoint() : null;
                if (protocolVersion2 == null) {
                    stringBuilder.append("<= ").append(protocolVersion.getName());
                } else if (protocolVersion == null) {
                    stringBuilder.append(">= ").append(protocolVersion2.getName());
                } else if (Objects.equals(protocolVersion2, protocolVersion)) {
                    stringBuilder.append(protocolVersion2.getName());
                } else {
                    stringBuilder.append(protocolVersion2.getName()).append(" - ").append(protocolVersion.getName());
                }
                if (n == this.ranges.size()) continue;
                stringBuilder.append(", ");
            }
            return stringBuilder.toString();
        }
        return "*";
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        ProtocolVersionRange protocolVersionRange = (ProtocolVersionRange)object;
        return Objects.equals(this.ranges, protocolVersionRange.ranges);
    }

    public int hashCode() {
        return Objects.hash(this.ranges);
    }

    public static ProtocolVersionRange fromString(String string) {
        if ("*".equals(string)) {
            return ProtocolVersionRange.all();
        }
        if (string.contains(",")) {
            String[] stringArray = string.split(", ");
            ProtocolVersionRange protocolVersionRange = null;
            for (String string2 : stringArray) {
                if (protocolVersionRange == null) {
                    protocolVersionRange = ProtocolVersionRange.of(ProtocolVersionRange.parseSinglePart(string2));
                    continue;
                }
                protocolVersionRange.add(ProtocolVersionRange.parseSinglePart(string2));
            }
            return protocolVersionRange;
        }
        return ProtocolVersionRange.of(ProtocolVersionRange.parseSinglePart(string));
    }

    private static Range<ProtocolVersion> parseSinglePart(String string) {
        if (string.startsWith("<= ")) {
            return Range.atMost(ProtocolVersion.getClosest(string.substring(3)));
        }
        if (string.startsWith(">= ")) {
            return Range.atLeast(ProtocolVersion.getClosest(string.substring(3)));
        }
        if (string.contains(" - ")) {
            String[] stringArray = string.split(" - ");
            ProtocolVersion protocolVersion = ProtocolVersion.getClosest(stringArray[0]);
            ProtocolVersion protocolVersion2 = ProtocolVersion.getClosest(stringArray[1]);
            return Range.open(protocolVersion, protocolVersion2);
        }
        return Range.singleton(ProtocolVersion.getClosest(string));
    }
}

