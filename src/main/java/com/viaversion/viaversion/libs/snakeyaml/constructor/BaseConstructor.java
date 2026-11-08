/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.snakeyaml.constructor;

import com.viaversion.viaversion.libs.snakeyaml.LoaderOptions;
import com.viaversion.viaversion.libs.snakeyaml.TypeDescription;
import com.viaversion.viaversion.libs.snakeyaml.composer.Composer;
import com.viaversion.viaversion.libs.snakeyaml.constructor.Construct;
import com.viaversion.viaversion.libs.snakeyaml.constructor.ConstructorException;
import com.viaversion.viaversion.libs.snakeyaml.error.YAMLException;
import com.viaversion.viaversion.libs.snakeyaml.introspector.PropertyUtils;
import com.viaversion.viaversion.libs.snakeyaml.nodes.CollectionNode;
import com.viaversion.viaversion.libs.snakeyaml.nodes.MappingNode;
import com.viaversion.viaversion.libs.snakeyaml.nodes.Node;
import com.viaversion.viaversion.libs.snakeyaml.nodes.NodeId;
import com.viaversion.viaversion.libs.snakeyaml.nodes.NodeTuple;
import com.viaversion.viaversion.libs.snakeyaml.nodes.ScalarNode;
import com.viaversion.viaversion.libs.snakeyaml.nodes.SequenceNode;
import com.viaversion.viaversion.libs.snakeyaml.nodes.Tag;
import com.viaversion.viaversion.libs.snakeyaml.util.Tuple;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public abstract class BaseConstructor {
    protected static final Object NOT_INSTANTIATED_OBJECT = new Object();
    protected final Map<NodeId, Construct> yamlClassConstructors = new EnumMap<NodeId, Construct>(NodeId.class);
    protected final Map<Tag, Construct> yamlConstructors = new HashMap<Tag, Construct>();
    protected final Map<String, Construct> yamlMultiConstructors = new HashMap<String, Construct>();
    protected Composer composer;
    final Map<Node, Object> constructedObjects;
    private final Set<Node> recursiveObjects;
    private final ArrayList<Tuple<Map<Object, Object>, Tuple<Object, Object>>> maps2fill;
    private final ArrayList<Tuple<Set<Object>, Object>> sets2fill;
    protected Tag rootTag;
    private PropertyUtils propertyUtils;
    private boolean explicitPropertyUtils;
    private boolean allowDuplicateKeys = true;
    private boolean warnOnDuplicateKeys = false;
    private boolean wrappedToRootException = false;
    private boolean enumCaseSensitive = false;
    protected final Map<Class<? extends Object>, TypeDescription> typeDefinitions;
    protected final Map<Tag, Class<? extends Object>> typeTags;
    protected LoaderOptions loadingConfig;

    public BaseConstructor(LoaderOptions loaderOptions) {
        if (loaderOptions == null) {
            throw new NullPointerException("LoaderOptions must be provided.");
        }
        this.constructedObjects = new HashMap<Node, Object>();
        this.recursiveObjects = new HashSet<Node>();
        this.maps2fill = new ArrayList();
        this.sets2fill = new ArrayList();
        this.typeDefinitions = new HashMap<Class<? extends Object>, TypeDescription>();
        this.typeTags = new HashMap<Tag, Class<? extends Object>>();
        this.rootTag = null;
        this.explicitPropertyUtils = false;
        this.typeDefinitions.put(SortedMap.class, new TypeDescription(SortedMap.class, Tag.OMAP, TreeMap.class));
        this.typeDefinitions.put(SortedSet.class, new TypeDescription(SortedSet.class, Tag.SET, TreeSet.class));
        this.loadingConfig = loaderOptions;
    }

    public void setComposer(Composer composer) {
        this.composer = composer;
    }

    public boolean checkData() {
        return this.composer.checkNode();
    }

    public Object getData() throws NoSuchElementException {
        if (!this.composer.checkNode()) {
            throw new NoSuchElementException("No document is available.");
        }
        Node node = this.composer.getNode();
        if (this.rootTag != null) {
            node.setTag(this.rootTag);
        }
        return this.constructDocument(node);
    }

    public Object getSingleData(Class<?> clazz) {
        Node node = this.composer.getSingleNode();
        if (node != null && !Tag.NULL.equals(node.getTag())) {
            if (Object.class != clazz) {
                node.setTag(new Tag(clazz));
            } else if (this.rootTag != null) {
                node.setTag(this.rootTag);
            }
            return this.constructDocument(node);
        }
        Construct construct = this.yamlConstructors.get(Tag.NULL);
        return construct.construct(node);
    }

    protected final Object constructDocument(Node node) {
        try {
            Object object = this.constructObject(node);
            this.fillRecursive();
            Object object2 = object;
            return object2;
        }
        catch (RuntimeException runtimeException) {
            if (this.wrappedToRootException && !(runtimeException instanceof YAMLException)) {
                throw new YAMLException(runtimeException);
            }
            throw runtimeException;
        }
        finally {
            this.constructedObjects.clear();
            this.recursiveObjects.clear();
        }
    }

    private void fillRecursive() {
        if (!this.maps2fill.isEmpty()) {
            for (Tuple<Map<Object, Object>, Tuple<Object, Object>> tuple : this.maps2fill) {
                Tuple<Object, Object> tuple2 = tuple._2();
                tuple._1().put(tuple2._1(), tuple2._2());
            }
            this.maps2fill.clear();
        }
        if (!this.sets2fill.isEmpty()) {
            for (Tuple<Object, Object> tuple : this.sets2fill) {
                ((Set)tuple._1()).add(tuple._2());
            }
            this.sets2fill.clear();
        }
    }

    protected Object constructObject(Node node) {
        if (this.constructedObjects.containsKey(node)) {
            return this.constructedObjects.get(node);
        }
        return this.constructObjectNoCheck(node);
    }

    protected Object constructObjectNoCheck(Node node) {
        if (this.recursiveObjects.contains(node)) {
            throw new ConstructorException(null, null, "found unconstructable recursive node", node.getStartMark());
        }
        this.recursiveObjects.add(node);
        Construct construct = this.getConstructor(node);
        Object object = this.constructedObjects.containsKey(node) ? this.constructedObjects.get(node) : construct.construct(node);
        object = this.finalizeConstruction(node, object);
        this.constructedObjects.put(node, object);
        this.recursiveObjects.remove(node);
        if (node.isTwoStepsConstruction()) {
            construct.construct2ndStep(node, object);
        }
        return object;
    }

    protected Construct getConstructor(Node node) {
        if (node.useClassConstructor()) {
            return this.yamlClassConstructors.get((Object)node.getNodeId());
        }
        Tag tag = node.getTag();
        Construct construct = this.yamlConstructors.get(tag);
        if (construct == null) {
            for (String string : this.yamlMultiConstructors.keySet()) {
                if (!tag.startsWith(string)) continue;
                return this.yamlMultiConstructors.get(string);
            }
            return this.yamlConstructors.get(null);
        }
        return construct;
    }

    protected String constructScalar(ScalarNode scalarNode) {
        return scalarNode.getValue();
    }

    protected List<Object> createDefaultList(int n) {
        return new ArrayList<Object>(n);
    }

    protected Set<Object> createDefaultSet(int n) {
        return new LinkedHashSet<Object>(n);
    }

    protected Map<Object, Object> createDefaultMap(int n) {
        return new LinkedHashMap<Object, Object>(n);
    }

    protected Object createArray(Class<?> clazz, int n) {
        return Array.newInstance(clazz.getComponentType(), n);
    }

    protected Object finalizeConstruction(Node node, Object object) {
        Class<? extends Object> clazz = node.getType();
        if (this.typeDefinitions.containsKey(clazz)) {
            return this.typeDefinitions.get(clazz).finalizeConstruction(object);
        }
        return object;
    }

    protected Object newInstance(Node node) {
        return this.newInstance(Object.class, node);
    }

    protected final Object newInstance(Class<?> clazz, Node node) {
        return this.newInstance(clazz, node, true);
    }

    protected Object newInstance(Class<?> clazz, Node node, boolean bl) {
        try {
            Object object;
            Object object2;
            Class<? extends Object> clazz2 = node.getType();
            if (this.typeDefinitions.containsKey(clazz2) && (object2 = ((TypeDescription)(object = this.typeDefinitions.get(clazz2))).newInstance(node)) != null) {
                return object2;
            }
            if (bl && clazz.isAssignableFrom(clazz2) && !Modifier.isAbstract(clazz2.getModifiers())) {
                object = clazz2.getDeclaredConstructor(new Class[0]);
                ((Constructor)object).setAccessible(true);
                return ((Constructor)object).newInstance(new Object[0]);
            }
        }
        catch (Exception exception) {
            throw new YAMLException(exception);
        }
        return NOT_INSTANTIATED_OBJECT;
    }

    protected Set<Object> newSet(CollectionNode<?> collectionNode) {
        Object object = this.newInstance(Set.class, collectionNode);
        if (object != NOT_INSTANTIATED_OBJECT) {
            return (Set)object;
        }
        return this.createDefaultSet(collectionNode.getValue().size());
    }

    protected List<Object> newList(SequenceNode sequenceNode) {
        Object object = this.newInstance(List.class, sequenceNode);
        if (object != NOT_INSTANTIATED_OBJECT) {
            return (List)object;
        }
        return this.createDefaultList(sequenceNode.getValue().size());
    }

    protected Map<Object, Object> newMap(MappingNode mappingNode) {
        Object object = this.newInstance(Map.class, mappingNode);
        if (object != NOT_INSTANTIATED_OBJECT) {
            return (Map)object;
        }
        return this.createDefaultMap(mappingNode.getValue().size());
    }

    protected List<? extends Object> constructSequence(SequenceNode sequenceNode) {
        List<Object> list = this.newList(sequenceNode);
        this.constructSequenceStep2(sequenceNode, list);
        return list;
    }

    protected Set<? extends Object> constructSet(SequenceNode sequenceNode) {
        Set<Object> set = this.newSet(sequenceNode);
        this.constructSequenceStep2(sequenceNode, set);
        return set;
    }

    protected Object constructArray(SequenceNode sequenceNode) {
        return this.constructArrayStep2(sequenceNode, this.createArray(sequenceNode.getType(), sequenceNode.getValue().size()));
    }

    protected void constructSequenceStep2(SequenceNode sequenceNode, Collection<Object> collection) {
        for (Node node : sequenceNode.getValue()) {
            collection.add(this.constructObject(node));
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    protected Object constructArrayStep2(SequenceNode sequenceNode, Object object) {
        Class<?> clazz = sequenceNode.getType().getComponentType();
        int n = 0;
        for (Node node : sequenceNode.getValue()) {
            if (node.getType() == Object.class) {
                node.setType(clazz);
            }
            Object object2 = this.constructObject(node);
            if (clazz.isPrimitive()) {
                if (object2 == null) {
                    throw new NullPointerException("Unable to construct element value for " + node);
                }
                if (Byte.TYPE.equals(clazz)) {
                    Array.setByte(object, n, ((Number)object2).byteValue());
                } else if (Short.TYPE.equals(clazz)) {
                    Array.setShort(object, n, ((Number)object2).shortValue());
                } else if (Integer.TYPE.equals(clazz)) {
                    Array.setInt(object, n, ((Number)object2).intValue());
                } else if (Long.TYPE.equals(clazz)) {
                    Array.setLong(object, n, ((Number)object2).longValue());
                } else if (Float.TYPE.equals(clazz)) {
                    Array.setFloat(object, n, ((Number)object2).floatValue());
                } else if (Double.TYPE.equals(clazz)) {
                    Array.setDouble(object, n, ((Number)object2).doubleValue());
                } else if (Character.TYPE.equals(clazz)) {
                    Array.setChar(object, n, ((Character)object2).charValue());
                } else {
                    if (!Boolean.TYPE.equals(clazz)) throw new YAMLException("unexpected primitive type");
                    Array.setBoolean(object, n, (Boolean)object2);
                }
            } else {
                Array.set(object, n, object2);
            }
            ++n;
        }
        return object;
    }

    protected Set<Object> constructSet(MappingNode mappingNode) {
        Set<Object> set = this.newSet(mappingNode);
        this.constructSet2ndStep(mappingNode, set);
        return set;
    }

    protected Map<Object, Object> constructMapping(MappingNode mappingNode) {
        Map<Object, Object> map = this.newMap(mappingNode);
        this.constructMapping2ndStep(mappingNode, map);
        return map;
    }

    protected void constructMapping2ndStep(MappingNode mappingNode, Map<Object, Object> map) {
        List<NodeTuple> list = mappingNode.getValue();
        for (NodeTuple nodeTuple : list) {
            Node node = nodeTuple.getKeyNode();
            Node node2 = nodeTuple.getValueNode();
            Object object = this.constructObject(node);
            if (object != null) {
                try {
                    object.hashCode();
                }
                catch (Exception exception) {
                    throw new ConstructorException("while constructing a mapping", mappingNode.getStartMark(), "found unacceptable key " + object, nodeTuple.getKeyNode().getStartMark(), exception);
                }
            }
            Object object2 = this.constructObject(node2);
            if (node.isTwoStepsConstruction()) {
                if (this.loadingConfig.getAllowRecursiveKeys()) {
                    this.postponeMapFilling(map, object, object2);
                    continue;
                }
                throw new YAMLException("Recursive key for mapping is detected but it is not configured to be allowed.");
            }
            map.put(object, object2);
        }
    }

    protected void postponeMapFilling(Map<Object, Object> map, Object object, Object object2) {
        this.maps2fill.add(0, new Tuple<Map<Object, Object>, Tuple<Object, Object>>(map, new Tuple<Object, Object>(object, object2)));
    }

    protected void constructSet2ndStep(MappingNode mappingNode, Set<Object> set) {
        List<NodeTuple> list = mappingNode.getValue();
        for (NodeTuple nodeTuple : list) {
            Node node = nodeTuple.getKeyNode();
            Object object = this.constructObject(node);
            if (object != null) {
                try {
                    object.hashCode();
                }
                catch (Exception exception) {
                    throw new ConstructorException("while constructing a Set", mappingNode.getStartMark(), "found unacceptable key " + object, nodeTuple.getKeyNode().getStartMark(), exception);
                }
            }
            if (node.isTwoStepsConstruction()) {
                this.postponeSetFilling(set, object);
                continue;
            }
            set.add(object);
        }
    }

    protected void postponeSetFilling(Set<Object> set, Object object) {
        this.sets2fill.add(0, new Tuple<Set<Object>, Object>(set, object));
    }

    public void setPropertyUtils(PropertyUtils propertyUtils) {
        this.propertyUtils = propertyUtils;
        this.explicitPropertyUtils = true;
        Collection<TypeDescription> collection = this.typeDefinitions.values();
        for (TypeDescription typeDescription : collection) {
            typeDescription.setPropertyUtils(propertyUtils);
        }
    }

    public final PropertyUtils getPropertyUtils() {
        if (this.propertyUtils == null) {
            this.propertyUtils = new PropertyUtils();
        }
        return this.propertyUtils;
    }

    public TypeDescription addTypeDescription(TypeDescription typeDescription) {
        if (typeDescription == null) {
            throw new NullPointerException("TypeDescription is required.");
        }
        Tag tag = typeDescription.getTag();
        this.typeTags.put(tag, typeDescription.getType());
        typeDescription.setPropertyUtils(this.getPropertyUtils());
        return this.typeDefinitions.put(typeDescription.getType(), typeDescription);
    }

    public final boolean isExplicitPropertyUtils() {
        return this.explicitPropertyUtils;
    }

    public boolean isAllowDuplicateKeys() {
        return this.allowDuplicateKeys;
    }

    public void setAllowDuplicateKeys(boolean bl) {
        this.allowDuplicateKeys = bl;
    }

    public boolean isWarnOnDuplicateKeys() {
        return this.warnOnDuplicateKeys;
    }

    public void setWarnOnDuplicateKeys(boolean bl) {
        this.warnOnDuplicateKeys = bl;
    }

    public boolean isWrappedToRootException() {
        return this.wrappedToRootException;
    }

    public void setWrappedToRootException(boolean bl) {
        this.wrappedToRootException = bl;
    }

    public boolean isEnumCaseSensitive() {
        return this.enumCaseSensitive;
    }

    public void setEnumCaseSensitive(boolean bl) {
        this.enumCaseSensitive = bl;
    }

    public LoaderOptions getLoadingConfig() {
        return this.loadingConfig;
    }
}

