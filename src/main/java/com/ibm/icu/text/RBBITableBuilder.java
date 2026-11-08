/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.text;

import com.ibm.icu.impl.Assert;
import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.text.RBBINode;
import com.ibm.icu.text.RBBIRuleBuilder;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class RBBITableBuilder {
    private RBBIRuleBuilder fRB;
    private int fRootIx;
    private List<RBBIStateDescriptor> fDStates;

    RBBITableBuilder(RBBIRuleBuilder rBBIRuleBuilder, int n) {
        this.fRootIx = n;
        this.fRB = rBBIRuleBuilder;
        this.fDStates = new ArrayList<RBBIStateDescriptor>();
    }

    void build() {
        RBBINode rBBINode;
        if (this.fRB.fTreeRoots[this.fRootIx] == null) {
            return;
        }
        this.fRB.fTreeRoots[this.fRootIx] = this.fRB.fTreeRoots[this.fRootIx].flattenVariables();
        if (this.fRB.fDebugEnv != null && this.fRB.fDebugEnv.indexOf("ftree") >= 0) {
            System.out.println("Parse tree after flattening variable references.");
            this.fRB.fTreeRoots[this.fRootIx].printTree(true);
        }
        if (this.fRB.fSetBuilder.sawBOF()) {
            RBBINode rBBINode2;
            rBBINode = new RBBINode(8);
            rBBINode.fLeftChild = rBBINode2 = new RBBINode(3);
            rBBINode.fRightChild = this.fRB.fTreeRoots[this.fRootIx];
            rBBINode2.fParent = rBBINode;
            rBBINode2.fVal = 2;
            this.fRB.fTreeRoots[this.fRootIx] = rBBINode;
        }
        rBBINode = new RBBINode(8);
        rBBINode.fLeftChild = this.fRB.fTreeRoots[this.fRootIx];
        this.fRB.fTreeRoots[this.fRootIx].fParent = rBBINode;
        rBBINode.fRightChild = new RBBINode(6);
        rBBINode.fRightChild.fParent = rBBINode;
        this.fRB.fTreeRoots[this.fRootIx] = rBBINode;
        this.fRB.fTreeRoots[this.fRootIx].flattenSets();
        if (this.fRB.fDebugEnv != null && this.fRB.fDebugEnv.indexOf("stree") >= 0) {
            System.out.println("Parse tree after flattening Unicode Set references.");
            this.fRB.fTreeRoots[this.fRootIx].printTree(true);
        }
        this.calcNullable(this.fRB.fTreeRoots[this.fRootIx]);
        this.calcFirstPos(this.fRB.fTreeRoots[this.fRootIx]);
        this.calcLastPos(this.fRB.fTreeRoots[this.fRootIx]);
        this.calcFollowPos(this.fRB.fTreeRoots[this.fRootIx]);
        if (this.fRB.fDebugEnv != null && this.fRB.fDebugEnv.indexOf("pos") >= 0) {
            System.out.print("\n");
            this.printPosSets(this.fRB.fTreeRoots[this.fRootIx]);
        }
        if (this.fRB.fChainRules) {
            this.calcChainedFollowPos(this.fRB.fTreeRoots[this.fRootIx]);
        }
        if (this.fRB.fSetBuilder.sawBOF()) {
            this.bofFixup();
        }
        this.buildStateTable();
        this.flagAcceptingStates();
        this.flagLookAheadStates();
        this.flagTaggedStates();
        this.mergeRuleStatusVals();
        if (this.fRB.fDebugEnv != null && this.fRB.fDebugEnv.indexOf("states") >= 0) {
            this.printStates();
        }
    }

    void calcNullable(RBBINode rBBINode) {
        if (rBBINode == null) {
            return;
        }
        if (rBBINode.fType == 0 || rBBINode.fType == 6) {
            rBBINode.fNullable = false;
            return;
        }
        if (rBBINode.fType == 4 || rBBINode.fType == 5) {
            rBBINode.fNullable = true;
            return;
        }
        this.calcNullable(rBBINode.fLeftChild);
        this.calcNullable(rBBINode.fRightChild);
        rBBINode.fNullable = rBBINode.fType == 9 ? rBBINode.fLeftChild.fNullable || rBBINode.fRightChild.fNullable : (rBBINode.fType == 8 ? rBBINode.fLeftChild.fNullable && rBBINode.fRightChild.fNullable : rBBINode.fType == 10 || rBBINode.fType == 12);
    }

    void calcFirstPos(RBBINode rBBINode) {
        if (rBBINode == null) {
            return;
        }
        if (rBBINode.fType == 3 || rBBINode.fType == 6 || rBBINode.fType == 4 || rBBINode.fType == 5) {
            rBBINode.fFirstPosSet.add(rBBINode);
            return;
        }
        this.calcFirstPos(rBBINode.fLeftChild);
        this.calcFirstPos(rBBINode.fRightChild);
        if (rBBINode.fType == 9) {
            rBBINode.fFirstPosSet.addAll(rBBINode.fLeftChild.fFirstPosSet);
            rBBINode.fFirstPosSet.addAll(rBBINode.fRightChild.fFirstPosSet);
        } else if (rBBINode.fType == 8) {
            rBBINode.fFirstPosSet.addAll(rBBINode.fLeftChild.fFirstPosSet);
            if (rBBINode.fLeftChild.fNullable) {
                rBBINode.fFirstPosSet.addAll(rBBINode.fRightChild.fFirstPosSet);
            }
        } else if (rBBINode.fType == 10 || rBBINode.fType == 12 || rBBINode.fType == 11) {
            rBBINode.fFirstPosSet.addAll(rBBINode.fLeftChild.fFirstPosSet);
        }
    }

    void calcLastPos(RBBINode rBBINode) {
        if (rBBINode == null) {
            return;
        }
        if (rBBINode.fType == 3 || rBBINode.fType == 6 || rBBINode.fType == 4 || rBBINode.fType == 5) {
            rBBINode.fLastPosSet.add(rBBINode);
            return;
        }
        this.calcLastPos(rBBINode.fLeftChild);
        this.calcLastPos(rBBINode.fRightChild);
        if (rBBINode.fType == 9) {
            rBBINode.fLastPosSet.addAll(rBBINode.fLeftChild.fLastPosSet);
            rBBINode.fLastPosSet.addAll(rBBINode.fRightChild.fLastPosSet);
        } else if (rBBINode.fType == 8) {
            rBBINode.fLastPosSet.addAll(rBBINode.fRightChild.fLastPosSet);
            if (rBBINode.fRightChild.fNullable) {
                rBBINode.fLastPosSet.addAll(rBBINode.fLeftChild.fLastPosSet);
            }
        } else if (rBBINode.fType == 10 || rBBINode.fType == 12 || rBBINode.fType == 11) {
            rBBINode.fLastPosSet.addAll(rBBINode.fLeftChild.fLastPosSet);
        }
    }

    void calcFollowPos(RBBINode rBBINode) {
        if (rBBINode == null || rBBINode.fType == 3 || rBBINode.fType == 6) {
            return;
        }
        this.calcFollowPos(rBBINode.fLeftChild);
        this.calcFollowPos(rBBINode.fRightChild);
        if (rBBINode.fType == 8) {
            for (RBBINode rBBINode2 : rBBINode.fLeftChild.fLastPosSet) {
                rBBINode2.fFollowPos.addAll(rBBINode.fRightChild.fFirstPosSet);
            }
        }
        if (rBBINode.fType == 10 || rBBINode.fType == 11) {
            for (RBBINode rBBINode2 : rBBINode.fLastPosSet) {
                rBBINode2.fFollowPos.addAll(rBBINode.fFirstPosSet);
            }
        }
    }

    void calcChainedFollowPos(RBBINode rBBINode) {
        ArrayList<RBBINode> arrayList = new ArrayList<RBBINode>();
        ArrayList<RBBINode> arrayList2 = new ArrayList<RBBINode>();
        rBBINode.findNodes(arrayList, 6);
        rBBINode.findNodes(arrayList2, 3);
        RBBINode rBBINode2 = rBBINode;
        if (this.fRB.fSetBuilder.sawBOF()) {
            rBBINode2 = rBBINode.fLeftChild.fRightChild;
        }
        Assert.assrt(rBBINode2 != null);
        Set<RBBINode> set = rBBINode2.fFirstPosSet;
        for (RBBINode rBBINode3 : arrayList2) {
            int n;
            int n2;
            RBBINode rBBINode4 = null;
            for (RBBINode rBBINode5 : arrayList) {
                if (!rBBINode3.fFollowPos.contains(rBBINode5)) continue;
                rBBINode4 = rBBINode3;
                break;
            }
            if (rBBINode4 == null || this.fRB.fLBCMNoChain && (n2 = this.fRB.fSetBuilder.getFirstChar(rBBINode4.fVal)) != -1 && (n = UCharacter.getIntPropertyValue(n2, 4104)) == 9) continue;
            for (RBBINode rBBINode5 : set) {
                if (rBBINode5.fType != 3 || rBBINode4.fVal != rBBINode5.fVal) continue;
                rBBINode4.fFollowPos.addAll(rBBINode5.fFollowPos);
            }
        }
    }

    void bofFixup() {
        RBBINode rBBINode = this.fRB.fTreeRoots[this.fRootIx].fLeftChild.fLeftChild;
        Assert.assrt(rBBINode.fType == 3);
        Assert.assrt(rBBINode.fVal == 2);
        Set<RBBINode> set = this.fRB.fTreeRoots[this.fRootIx].fLeftChild.fRightChild.fFirstPosSet;
        for (RBBINode rBBINode2 : set) {
            if (rBBINode2.fType != 3 || rBBINode2.fVal != rBBINode.fVal) continue;
            rBBINode.fFollowPos.addAll(rBBINode2.fFollowPos);
        }
    }

    void buildStateTable() {
        int n = this.fRB.fSetBuilder.getNumCharCategories() - 1;
        RBBIStateDescriptor rBBIStateDescriptor = new RBBIStateDescriptor(n);
        this.fDStates.add(rBBIStateDescriptor);
        RBBIStateDescriptor rBBIStateDescriptor2 = new RBBIStateDescriptor(n);
        rBBIStateDescriptor2.fPositions.addAll(this.fRB.fTreeRoots[this.fRootIx].fFirstPosSet);
        this.fDStates.add(rBBIStateDescriptor2);
        block0: while (true) {
            RBBIStateDescriptor rBBIStateDescriptor3 = null;
            for (int i = 1; i < this.fDStates.size(); ++i) {
                RBBIStateDescriptor rBBIStateDescriptor4 = this.fDStates.get(i);
                if (rBBIStateDescriptor4.fMarked) continue;
                rBBIStateDescriptor3 = rBBIStateDescriptor4;
                break;
            }
            if (rBBIStateDescriptor3 == null) break;
            rBBIStateDescriptor3.fMarked = true;
            int n2 = 1;
            while (true) {
                if (n2 > n) continue block0;
                Set<RBBINode> set = null;
                for (RBBINode rBBINode : rBBIStateDescriptor3.fPositions) {
                    if (rBBINode.fType != 3 || rBBINode.fVal != n2) continue;
                    if (set == null) {
                        set = new HashSet<RBBINode>();
                    }
                    set.addAll(rBBINode.fFollowPos);
                }
                int n3 = 0;
                boolean bl = false;
                if (set != null) {
                    RBBIStateDescriptor rBBIStateDescriptor5;
                    Assert.assrt(set.size() > 0);
                    for (int i = 0; i < this.fDStates.size(); ++i) {
                        rBBIStateDescriptor5 = this.fDStates.get(i);
                        if (!((Object)set).equals(rBBIStateDescriptor5.fPositions)) continue;
                        set = rBBIStateDescriptor5.fPositions;
                        n3 = i;
                        bl = true;
                        break;
                    }
                    if (!bl) {
                        rBBIStateDescriptor5 = new RBBIStateDescriptor(n);
                        rBBIStateDescriptor5.fPositions = set;
                        this.fDStates.add(rBBIStateDescriptor5);
                        n3 = this.fDStates.size() - 1;
                    }
                    rBBIStateDescriptor3.fDtran[n2] = n3;
                }
                ++n2;
            }
            break;
        }
    }

    void flagAcceptingStates() {
        ArrayList<RBBINode> arrayList = new ArrayList<RBBINode>();
        this.fRB.fTreeRoots[this.fRootIx].findNodes(arrayList, 6);
        for (int i = 0; i < arrayList.size(); ++i) {
            RBBINode rBBINode = (RBBINode)arrayList.get(i);
            for (int j = 0; j < this.fDStates.size(); ++j) {
                RBBIStateDescriptor rBBIStateDescriptor = this.fDStates.get(j);
                if (!rBBIStateDescriptor.fPositions.contains(rBBINode)) continue;
                if (rBBIStateDescriptor.fAccepting == 0) {
                    rBBIStateDescriptor.fAccepting = rBBINode.fVal;
                    if (rBBIStateDescriptor.fAccepting == 0) {
                        rBBIStateDescriptor.fAccepting = -1;
                    }
                }
                if (rBBIStateDescriptor.fAccepting == -1 && rBBINode.fVal != 0) {
                    rBBIStateDescriptor.fAccepting = rBBINode.fVal;
                }
                if (!rBBINode.fLookAheadEnd) continue;
                rBBIStateDescriptor.fLookAhead = rBBIStateDescriptor.fAccepting;
            }
        }
    }

    void flagLookAheadStates() {
        ArrayList<RBBINode> arrayList = new ArrayList<RBBINode>();
        this.fRB.fTreeRoots[this.fRootIx].findNodes(arrayList, 4);
        for (int i = 0; i < arrayList.size(); ++i) {
            RBBINode rBBINode = (RBBINode)arrayList.get(i);
            for (int j = 0; j < this.fDStates.size(); ++j) {
                RBBIStateDescriptor rBBIStateDescriptor = this.fDStates.get(j);
                if (!rBBIStateDescriptor.fPositions.contains(rBBINode)) continue;
                rBBIStateDescriptor.fLookAhead = rBBINode.fVal;
            }
        }
    }

    void flagTaggedStates() {
        ArrayList<RBBINode> arrayList = new ArrayList<RBBINode>();
        this.fRB.fTreeRoots[this.fRootIx].findNodes(arrayList, 5);
        for (int i = 0; i < arrayList.size(); ++i) {
            RBBINode rBBINode = (RBBINode)arrayList.get(i);
            for (int j = 0; j < this.fDStates.size(); ++j) {
                RBBIStateDescriptor rBBIStateDescriptor = this.fDStates.get(j);
                if (!rBBIStateDescriptor.fPositions.contains(rBBINode)) continue;
                rBBIStateDescriptor.fTagVals.add(rBBINode.fVal);
            }
        }
    }

    void mergeRuleStatusVals() {
        Serializable serializable;
        SortedSet<Integer> sortedSet;
        Object object;
        if (this.fRB.fRuleStatusVals.size() == 0) {
            this.fRB.fRuleStatusVals.add(1);
            this.fRB.fRuleStatusVals.add(0);
            object = new TreeSet();
            sortedSet = 0;
            this.fRB.fStatusSets.put((Set<Integer>)object, (Integer)((Object)sortedSet));
            serializable = new TreeSet();
            serializable.add(sortedSet);
            this.fRB.fStatusSets.put((Set<Integer>)object, (Integer)((Object)sortedSet));
        }
        for (int i = 0; i < this.fDStates.size(); ++i) {
            object = this.fDStates.get(i);
            sortedSet = ((RBBIStateDescriptor)object).fTagVals;
            serializable = this.fRB.fStatusSets.get(sortedSet);
            if (serializable == null) {
                serializable = Integer.valueOf(this.fRB.fRuleStatusVals.size());
                this.fRB.fStatusSets.put((Set<Integer>)sortedSet, (Integer)serializable);
                this.fRB.fRuleStatusVals.add(sortedSet.size());
                this.fRB.fRuleStatusVals.addAll((Collection<Integer>)sortedSet);
            }
            ((RBBIStateDescriptor)object).fTagsIdx = (Integer)serializable;
        }
    }

    void printPosSets(RBBINode rBBINode) {
        if (rBBINode == null) {
            return;
        }
        RBBINode.printNode(rBBINode);
        System.out.print("         Nullable:  " + rBBINode.fNullable);
        System.out.print("         firstpos:  ");
        this.printSet(rBBINode.fFirstPosSet);
        System.out.print("         lastpos:   ");
        this.printSet(rBBINode.fLastPosSet);
        System.out.print("         followpos: ");
        this.printSet(rBBINode.fFollowPos);
        this.printPosSets(rBBINode.fLeftChild);
        this.printPosSets(rBBINode.fRightChild);
    }

    int getTableSize() {
        int n = 0;
        if (this.fRB.fTreeRoots[this.fRootIx] == null) {
            return 0;
        }
        n = 16;
        int n2 = this.fDStates.size();
        int n3 = this.fRB.fSetBuilder.getNumCharCategories();
        int n4 = 8 + 2 * n3;
        n += n2 * n4;
        while (n % 8 > 0) {
            ++n;
        }
        return n;
    }

    short[] exportTable() {
        if (this.fRB.fTreeRoots[this.fRootIx] == null) {
            return new short[0];
        }
        Assert.assrt(this.fRB.fSetBuilder.getNumCharCategories() < Short.MAX_VALUE && this.fDStates.size() < Short.MAX_VALUE);
        int n = this.fDStates.size();
        int n2 = 4 + this.fRB.fSetBuilder.getNumCharCategories();
        int n3 = this.getTableSize() / 2;
        short[] sArray = new short[n3];
        sArray[0] = (short)(n >>> 16);
        sArray[1] = (short)(n & 0xFFFF);
        sArray[2] = (short)(n2 >>> 16);
        sArray[3] = (short)(n2 & 0xFFFF);
        int n4 = 0;
        if (this.fRB.fLookAheadHardBreak) {
            n4 |= 1;
        }
        if (this.fRB.fSetBuilder.sawBOF()) {
            n4 |= 2;
        }
        sArray[4] = (short)(n4 >>> 16);
        sArray[5] = (short)(n4 & 0xFFFF);
        int n5 = this.fRB.fSetBuilder.getNumCharCategories();
        for (int i = 0; i < n; ++i) {
            RBBIStateDescriptor rBBIStateDescriptor = this.fDStates.get(i);
            int n6 = 8 + i * n2;
            Assert.assrt(Short.MIN_VALUE < rBBIStateDescriptor.fAccepting && rBBIStateDescriptor.fAccepting <= Short.MAX_VALUE);
            Assert.assrt(Short.MIN_VALUE < rBBIStateDescriptor.fLookAhead && rBBIStateDescriptor.fLookAhead <= Short.MAX_VALUE);
            sArray[n6 + 0] = (short)rBBIStateDescriptor.fAccepting;
            sArray[n6 + 1] = (short)rBBIStateDescriptor.fLookAhead;
            sArray[n6 + 2] = (short)rBBIStateDescriptor.fTagsIdx;
            for (int j = 0; j < n5; ++j) {
                sArray[n6 + 4 + j] = (short)rBBIStateDescriptor.fDtran[j];
            }
        }
        return sArray;
    }

    void printSet(Collection<RBBINode> collection) {
        for (RBBINode rBBINode : collection) {
            RBBINode.printInt(rBBINode.fSerialNum, 8);
        }
        System.out.println();
    }

    void printStates() {
        int n;
        System.out.print("state |           i n p u t     s y m b o l s \n");
        System.out.print("      | Acc  LA    Tag");
        for (n = 0; n < this.fRB.fSetBuilder.getNumCharCategories(); ++n) {
            RBBINode.printInt(n, 3);
        }
        System.out.print("\n");
        System.out.print("      |---------------");
        for (n = 0; n < this.fRB.fSetBuilder.getNumCharCategories(); ++n) {
            System.out.print("---");
        }
        System.out.print("\n");
        for (int i = 0; i < this.fDStates.size(); ++i) {
            RBBIStateDescriptor rBBIStateDescriptor = this.fDStates.get(i);
            RBBINode.printInt(i, 5);
            System.out.print(" | ");
            RBBINode.printInt(rBBIStateDescriptor.fAccepting, 3);
            RBBINode.printInt(rBBIStateDescriptor.fLookAhead, 4);
            RBBINode.printInt(rBBIStateDescriptor.fTagsIdx, 6);
            System.out.print(" ");
            for (n = 0; n < this.fRB.fSetBuilder.getNumCharCategories(); ++n) {
                RBBINode.printInt(rBBIStateDescriptor.fDtran[n], 3);
            }
            System.out.print("\n");
        }
        System.out.print("\n\n");
    }

    void printRuleStatusTable() {
        int n = 0;
        int n2 = 0;
        List<Integer> list = this.fRB.fRuleStatusVals;
        System.out.print("index |  tags \n");
        System.out.print("-------------------\n");
        while (n2 < list.size()) {
            n = n2;
            n2 = n + list.get(n) + 1;
            RBBINode.printInt(n, 7);
            for (int i = n + 1; i < n2; ++i) {
                int n3 = list.get(i);
                RBBINode.printInt(n3, 7);
            }
            System.out.print("\n");
        }
        System.out.print("\n\n");
    }

    public static class RBBIStateDescriptor {
        boolean fMarked;
        int fAccepting;
        int fLookAhead;
        SortedSet<Integer> fTagVals = new TreeSet<Integer>();
        int fTagsIdx;
        Set<RBBINode> fPositions = new HashSet<RBBINode>();
        int[] fDtran;

        RBBIStateDescriptor(int n) {
            this.fDtran = new int[n + 1];
        }
    }
}

