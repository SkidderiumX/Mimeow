/*
 * Decompiled with CFR 0.152.
 */
package org.yaml.snakeyaml.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.yaml.snakeyaml.nodes.MappingNode;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.NodeTuple;
import org.yaml.snakeyaml.nodes.ScalarNode;
import org.yaml.snakeyaml.nodes.SequenceNode;
import org.yaml.snakeyaml.nodes.Tag;
import org.yaml.snakeyaml.util.Tuple;

public abstract class MergeUtils {
    public abstract MappingNode asMappingNode(Node var1);

    public List<NodeTuple> flatten(MappingNode mappingNode) {
        List<NodeTuple> list;
        List<NodeTuple> list2 = list = mappingNode.getValue();
        boolean bl = true;
        while (bl) {
            Node node;
            Node node2;
            bl = false;
            ArrayList<NodeTuple> arrayList = new ArrayList<NodeTuple>(list.size());
            HashSet<String> hashSet = new HashSet<String>(list.size());
            ArrayList<NodeTuple> arrayList2 = new ArrayList<NodeTuple>(2);
            for (NodeTuple nodeTuple : list) {
                node2 = nodeTuple.getKeyNode();
                if (node2.getTag().equals(Tag.MERGE)) {
                    arrayList2.add(nodeTuple);
                    continue;
                }
                arrayList.add(nodeTuple);
                if (!(node2 instanceof ScalarNode)) continue;
                node = (ScalarNode)node2;
                hashSet.add(((ScalarNode)node).getValue());
            }
            for (NodeTuple nodeTuple : arrayList2) {
                node2 = nodeTuple.getValueNode();
                if (node2 instanceof SequenceNode) {
                    node = (SequenceNode)node2;
                    for (Node node3 : ((SequenceNode)node).getValue()) {
                        MappingNode mappingNode2 = this.asMappingNode(node3);
                        bl = bl || mappingNode2.isMerged();
                        Tuple<List<NodeTuple>, Set<String>> tuple = this.filter(mappingNode2.getValue(), hashSet);
                        arrayList.addAll((Collection<NodeTuple>)tuple._1());
                        hashSet.addAll((Collection<String>)tuple._2());
                    }
                    continue;
                }
                node = this.asMappingNode(node2);
                bl = bl || ((MappingNode)node).isMerged();
                Tuple<List<NodeTuple>, Set<String>> tuple = this.filter(((MappingNode)node).getValue(), hashSet);
                arrayList.addAll((Collection)tuple._1());
                hashSet.addAll((Collection)tuple._2());
            }
            list2 = arrayList;
            if (!bl) continue;
            list = arrayList;
        }
        return list2;
    }

    private Tuple<List<NodeTuple>, Set<String>> filter(List<NodeTuple> list, Set<String> set) {
        int n = list.size();
        HashSet<String> hashSet = new HashSet<String>(n);
        ArrayList<NodeTuple> arrayList = new ArrayList<NodeTuple>(n);
        for (NodeTuple nodeTuple : list) {
            Node node = nodeTuple.getKeyNode();
            if (node instanceof ScalarNode) {
                ScalarNode scalarNode = (ScalarNode)node;
                String string = scalarNode.getValue();
                if (set.contains(string)) continue;
                arrayList.add(nodeTuple);
                hashSet.add(string);
                continue;
            }
            arrayList.add(nodeTuple);
        }
        return new Tuple<List<NodeTuple>, Set<String>>(arrayList, hashSet);
    }
}

