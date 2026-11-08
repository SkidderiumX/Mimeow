/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.snakeyaml.representer;

import com.viaversion.viaversion.libs.snakeyaml.DumperOptions;
import com.viaversion.viaversion.libs.snakeyaml.error.YAMLException;
import com.viaversion.viaversion.libs.snakeyaml.nodes.Node;
import com.viaversion.viaversion.libs.snakeyaml.nodes.Tag;
import com.viaversion.viaversion.libs.snakeyaml.reader.StreamReader;
import com.viaversion.viaversion.libs.snakeyaml.representer.BaseRepresenter;
import com.viaversion.viaversion.libs.snakeyaml.representer.Represent;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Pattern;

public class SafeRepresenter
extends BaseRepresenter {
    protected Map<Class<? extends Object>, Tag> classTags;
    protected TimeZone timeZone = null;
    protected DumperOptions.NonPrintableStyle nonPrintableStyle;
    private static final Pattern MULTILINE_PATTERN = Pattern.compile("\n|\u0085|\u2028|\u2029");

    public SafeRepresenter(DumperOptions dumperOptions) {
        if (dumperOptions == null) {
            throw new NullPointerException("DumperOptions must be provided.");
        }
        this.nullRepresenter = new RepresentNull();
        this.representers.put(String.class, new RepresentString());
        this.representers.put(Boolean.class, new RepresentBoolean());
        this.representers.put(Character.class, new RepresentString());
        this.representers.put(UUID.class, new RepresentUuid());
        this.representers.put(byte[].class, new RepresentByteArray());
        RepresentPrimitiveArray representPrimitiveArray = new RepresentPrimitiveArray();
        this.representers.put(short[].class, representPrimitiveArray);
        this.representers.put(int[].class, representPrimitiveArray);
        this.representers.put(long[].class, representPrimitiveArray);
        this.representers.put(float[].class, representPrimitiveArray);
        this.representers.put(double[].class, representPrimitiveArray);
        this.representers.put(char[].class, representPrimitiveArray);
        this.representers.put(boolean[].class, representPrimitiveArray);
        this.multiRepresenters.put(Number.class, new RepresentNumber());
        this.multiRepresenters.put(List.class, new RepresentList());
        this.multiRepresenters.put(Map.class, new RepresentMap());
        this.multiRepresenters.put(Set.class, new RepresentSet());
        this.multiRepresenters.put(Iterator.class, new RepresentIterator());
        this.multiRepresenters.put(new Object[0].getClass(), new RepresentArray());
        this.multiRepresenters.put(Date.class, new RepresentDate());
        this.multiRepresenters.put(Enum.class, new RepresentEnum());
        this.multiRepresenters.put(Calendar.class, new RepresentDate());
        this.classTags = new HashMap<Class<? extends Object>, Tag>();
        this.nonPrintableStyle = dumperOptions.getNonPrintableStyle();
        this.setDefaultScalarStyle(dumperOptions.getDefaultScalarStyle());
        this.setDefaultFlowStyle(dumperOptions.getDefaultFlowStyle());
    }

    protected Tag getTag(Class<?> clazz, Tag tag) {
        if (this.classTags.containsKey(clazz)) {
            return this.classTags.get(clazz);
        }
        return tag;
    }

    public Tag addClassTag(Class<? extends Object> clazz, Tag tag) {
        if (tag == null) {
            throw new NullPointerException("Tag must be provided.");
        }
        return this.classTags.put(clazz, tag);
    }

    public TimeZone getTimeZone() {
        return this.timeZone;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }

    protected class RepresentUuid
    implements Represent {
        protected RepresentUuid() {
        }

        @Override
        public Node representData(Object object) {
            return SafeRepresenter.this.representScalar(SafeRepresenter.this.getTag(object.getClass(), new Tag(UUID.class)), object.toString());
        }
    }

    protected class RepresentByteArray
    implements Represent {
        protected RepresentByteArray() {
        }

        @Override
        public Node representData(Object object) {
            String string = Base64.getEncoder().encodeToString((byte[])object);
            return SafeRepresenter.this.representScalar(Tag.BINARY, String.valueOf(string), DumperOptions.ScalarStyle.LITERAL);
        }
    }

    protected class RepresentEnum
    implements Represent {
        protected RepresentEnum() {
        }

        @Override
        public Node representData(Object object) {
            Tag tag = new Tag(object.getClass());
            return SafeRepresenter.this.representScalar(SafeRepresenter.this.getTag(object.getClass(), tag), ((Enum)object).name());
        }
    }

    protected class RepresentDate
    implements Represent {
        protected RepresentDate() {
        }

        public Tag getDefaultTag() {
            return Tag.TIMESTAMP;
        }

        @Override
        public Node representData(Object object) {
            int n;
            Calendar calendar;
            if (object instanceof Calendar) {
                calendar = (Calendar)object;
            } else {
                calendar = Calendar.getInstance(SafeRepresenter.this.getTimeZone() == null ? TimeZone.getTimeZone("UTC") : SafeRepresenter.this.timeZone);
                calendar.setTime((Date)object);
            }
            int n2 = calendar.get(1);
            int n3 = calendar.get(2) + 1;
            int n4 = calendar.get(5);
            int n5 = calendar.get(11);
            int n6 = calendar.get(12);
            int n7 = calendar.get(13);
            int n8 = calendar.get(14);
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(n2));
            while (stringBuilder.length() < 4) {
                stringBuilder.insert(0, "0");
            }
            stringBuilder.append("-");
            if (n3 < 10) {
                stringBuilder.append("0");
            }
            stringBuilder.append(n3);
            stringBuilder.append("-");
            if (n4 < 10) {
                stringBuilder.append("0");
            }
            stringBuilder.append(n4);
            stringBuilder.append("T");
            if (n5 < 10) {
                stringBuilder.append("0");
            }
            stringBuilder.append(n5);
            stringBuilder.append(":");
            if (n6 < 10) {
                stringBuilder.append("0");
            }
            stringBuilder.append(n6);
            stringBuilder.append(":");
            if (n7 < 10) {
                stringBuilder.append("0");
            }
            stringBuilder.append(n7);
            if (n8 > 0) {
                if (n8 < 10) {
                    stringBuilder.append(".00");
                } else if (n8 < 100) {
                    stringBuilder.append(".0");
                } else {
                    stringBuilder.append(".");
                }
                stringBuilder.append(n8);
            }
            if ((n = calendar.getTimeZone().getOffset(calendar.getTime().getTime())) == 0) {
                stringBuilder.append('Z');
            } else {
                if (n < 0) {
                    stringBuilder.append('-');
                    n *= -1;
                } else {
                    stringBuilder.append('+');
                }
                int n9 = n / 60000;
                int n10 = n9 / 60;
                int n11 = n9 % 60;
                if (n10 < 10) {
                    stringBuilder.append('0');
                }
                stringBuilder.append(n10);
                stringBuilder.append(':');
                if (n11 < 10) {
                    stringBuilder.append('0');
                }
                stringBuilder.append(n11);
            }
            return SafeRepresenter.this.representScalar(SafeRepresenter.this.getTag(object.getClass(), this.getDefaultTag()), stringBuilder.toString());
        }
    }

    protected class RepresentSet
    implements Represent {
        protected RepresentSet() {
        }

        @Override
        public Node representData(Object object) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Set set = (Set)object;
            for (Object e : set) {
                linkedHashMap.put(e, null);
            }
            return SafeRepresenter.this.representMapping(SafeRepresenter.this.getTag(object.getClass(), Tag.SET), linkedHashMap, DumperOptions.FlowStyle.AUTO);
        }
    }

    protected class RepresentMap
    implements Represent {
        protected RepresentMap() {
        }

        @Override
        public Node representData(Object object) {
            return SafeRepresenter.this.representMapping(SafeRepresenter.this.getTag(object.getClass(), Tag.MAP), (Map)object, DumperOptions.FlowStyle.AUTO);
        }
    }

    protected class RepresentPrimitiveArray
    implements Represent {
        protected RepresentPrimitiveArray() {
        }

        @Override
        public Node representData(Object object) {
            Class<?> clazz = object.getClass().getComponentType();
            if (Byte.TYPE == clazz) {
                return SafeRepresenter.this.representSequence(Tag.SEQ, this.asByteList(object), DumperOptions.FlowStyle.AUTO);
            }
            if (Short.TYPE == clazz) {
                return SafeRepresenter.this.representSequence(Tag.SEQ, this.asShortList(object), DumperOptions.FlowStyle.AUTO);
            }
            if (Integer.TYPE == clazz) {
                return SafeRepresenter.this.representSequence(Tag.SEQ, this.asIntList(object), DumperOptions.FlowStyle.AUTO);
            }
            if (Long.TYPE == clazz) {
                return SafeRepresenter.this.representSequence(Tag.SEQ, this.asLongList(object), DumperOptions.FlowStyle.AUTO);
            }
            if (Float.TYPE == clazz) {
                return SafeRepresenter.this.representSequence(Tag.SEQ, this.asFloatList(object), DumperOptions.FlowStyle.AUTO);
            }
            if (Double.TYPE == clazz) {
                return SafeRepresenter.this.representSequence(Tag.SEQ, this.asDoubleList(object), DumperOptions.FlowStyle.AUTO);
            }
            if (Character.TYPE == clazz) {
                return SafeRepresenter.this.representSequence(Tag.SEQ, this.asCharList(object), DumperOptions.FlowStyle.AUTO);
            }
            if (Boolean.TYPE == clazz) {
                return SafeRepresenter.this.representSequence(Tag.SEQ, this.asBooleanList(object), DumperOptions.FlowStyle.AUTO);
            }
            throw new YAMLException("Unexpected primitive '" + clazz.getCanonicalName() + "'");
        }

        private List<Byte> asByteList(Object object) {
            byte[] byArray = (byte[])object;
            ArrayList<Byte> arrayList = new ArrayList<Byte>(byArray.length);
            for (int i = 0; i < byArray.length; ++i) {
                arrayList.add(byArray[i]);
            }
            return arrayList;
        }

        private List<Short> asShortList(Object object) {
            short[] sArray = (short[])object;
            ArrayList<Short> arrayList = new ArrayList<Short>(sArray.length);
            for (int i = 0; i < sArray.length; ++i) {
                arrayList.add(sArray[i]);
            }
            return arrayList;
        }

        private List<Integer> asIntList(Object object) {
            int[] nArray = (int[])object;
            ArrayList<Integer> arrayList = new ArrayList<Integer>(nArray.length);
            for (int i = 0; i < nArray.length; ++i) {
                arrayList.add(nArray[i]);
            }
            return arrayList;
        }

        private List<Long> asLongList(Object object) {
            long[] lArray = (long[])object;
            ArrayList<Long> arrayList = new ArrayList<Long>(lArray.length);
            for (int i = 0; i < lArray.length; ++i) {
                arrayList.add(lArray[i]);
            }
            return arrayList;
        }

        private List<Float> asFloatList(Object object) {
            float[] fArray = (float[])object;
            ArrayList<Float> arrayList = new ArrayList<Float>(fArray.length);
            for (int i = 0; i < fArray.length; ++i) {
                arrayList.add(Float.valueOf(fArray[i]));
            }
            return arrayList;
        }

        private List<Double> asDoubleList(Object object) {
            double[] dArray = (double[])object;
            ArrayList<Double> arrayList = new ArrayList<Double>(dArray.length);
            for (int i = 0; i < dArray.length; ++i) {
                arrayList.add(dArray[i]);
            }
            return arrayList;
        }

        private List<Character> asCharList(Object object) {
            char[] cArray = (char[])object;
            ArrayList<Character> arrayList = new ArrayList<Character>(cArray.length);
            for (int i = 0; i < cArray.length; ++i) {
                arrayList.add(Character.valueOf(cArray[i]));
            }
            return arrayList;
        }

        private List<Boolean> asBooleanList(Object object) {
            boolean[] blArray = (boolean[])object;
            ArrayList<Boolean> arrayList = new ArrayList<Boolean>(blArray.length);
            for (int i = 0; i < blArray.length; ++i) {
                arrayList.add(blArray[i]);
            }
            return arrayList;
        }
    }

    protected class RepresentArray
    implements Represent {
        protected RepresentArray() {
        }

        @Override
        public Node representData(Object object) {
            Object[] objectArray = (Object[])object;
            List<Object> list = Arrays.asList(objectArray);
            return SafeRepresenter.this.representSequence(Tag.SEQ, list, DumperOptions.FlowStyle.AUTO);
        }
    }

    private static class IteratorWrapper
    implements Iterable<Object> {
        private final Iterator<Object> iter;

        public IteratorWrapper(Iterator<Object> iterator2) {
            this.iter = iterator2;
        }

        @Override
        public Iterator<Object> iterator() {
            return this.iter;
        }
    }

    protected class RepresentIterator
    implements Represent {
        protected RepresentIterator() {
        }

        @Override
        public Node representData(Object object) {
            Iterator iterator2 = (Iterator)object;
            return SafeRepresenter.this.representSequence(SafeRepresenter.this.getTag(object.getClass(), Tag.SEQ), new IteratorWrapper(iterator2), DumperOptions.FlowStyle.AUTO);
        }
    }

    protected class RepresentList
    implements Represent {
        protected RepresentList() {
        }

        @Override
        public Node representData(Object object) {
            return SafeRepresenter.this.representSequence(SafeRepresenter.this.getTag(object.getClass(), Tag.SEQ), (List)object, DumperOptions.FlowStyle.AUTO);
        }
    }

    protected class RepresentNumber
    implements Represent {
        protected RepresentNumber() {
        }

        @Override
        public Node representData(Object object) {
            String string;
            Tag tag;
            if (object instanceof Byte || object instanceof Short || object instanceof Integer || object instanceof Long || object instanceof BigInteger) {
                tag = Tag.INT;
                string = object.toString();
            } else {
                Number number = (Number)object;
                tag = Tag.FLOAT;
                string = number.equals(Double.NaN) ? ".NaN" : (number.equals(Double.POSITIVE_INFINITY) ? ".inf" : (number.equals(Double.NEGATIVE_INFINITY) ? "-.inf" : number.toString()));
            }
            return SafeRepresenter.this.representScalar(SafeRepresenter.this.getTag(object.getClass(), tag), string);
        }
    }

    protected class RepresentBoolean
    implements Represent {
        protected RepresentBoolean() {
        }

        @Override
        public Node representData(Object object) {
            String string = Boolean.TRUE.equals(object) ? "true" : "false";
            return SafeRepresenter.this.representScalar(Tag.BOOL, string);
        }
    }

    protected class RepresentString
    implements Represent {
        protected RepresentString() {
        }

        @Override
        public Node representData(Object object) {
            Tag tag = Tag.STR;
            DumperOptions.ScalarStyle scalarStyle = SafeRepresenter.this.defaultScalarStyle;
            String string = object.toString();
            if (SafeRepresenter.this.nonPrintableStyle == DumperOptions.NonPrintableStyle.BINARY && !StreamReader.isPrintable(string)) {
                tag = Tag.BINARY;
                byte[] byArray = string.getBytes(StandardCharsets.UTF_8);
                String string2 = new String(byArray, StandardCharsets.UTF_8);
                if (!string2.equals(string)) {
                    throw new YAMLException("invalid string value has occurred");
                }
                string = Base64.getEncoder().encodeToString(byArray);
                scalarStyle = DumperOptions.ScalarStyle.LITERAL;
            }
            if (SafeRepresenter.this.defaultScalarStyle == DumperOptions.ScalarStyle.PLAIN && MULTILINE_PATTERN.matcher(string).find()) {
                scalarStyle = DumperOptions.ScalarStyle.LITERAL;
            }
            return SafeRepresenter.this.representScalar(tag, string, scalarStyle);
        }
    }

    protected class RepresentNull
    implements Represent {
        protected RepresentNull() {
        }

        @Override
        public Node representData(Object object) {
            return SafeRepresenter.this.representScalar(Tag.NULL, "null");
        }
    }
}

