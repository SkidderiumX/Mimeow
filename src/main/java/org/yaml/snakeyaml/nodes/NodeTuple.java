/*
 * Decompiled with CFR 0.152.
 */
package org.yaml.snakeyaml.nodes;

import org.yaml.snakeyaml.nodes.Node;

public class NodeTuple {
    private final Node keyNode;
    private final Node valueNode;

    public NodeTuple(Node node, Node node2) {
        if (node == null || node2 == null) {
            throw new NullPointerException("Nodes must be provided.");
        }
        this.keyNode = node;
        this.valueNode = node2;
    }

    public Node getKeyNode() {
        return this.keyNode;
    }

    public Node getValueNode() {
        return this.valueNode;
    }

    public String toString() {
        return "<NodeTuple keyNode=" + this.keyNode + "; valueNode=" + this.valueNode + ">";
    }
}

