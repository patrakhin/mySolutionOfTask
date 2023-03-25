package course;

import java.util.*;

class BSTNode {
    public int NodeKey; // key of the node
    public BSTNode Parent; // parent or null for the root
    public BSTNode LeftChild; // left child
    public BSTNode RightChild; // right child
    public int Level; // node level

    public BSTNode(int key, BSTNode parent) {
        NodeKey = key;
        Parent = parent;
        LeftChild = null;
        RightChild = null;
    }
}

class BalancedBST {
    public BSTNode Root; // root of the tree

    public BalancedBST() {
        Root = null;
    }

    public void GenerateTree(int[] a) {
        // create a tree from the unsorted array a
        Arrays.sort(a);
        Root = BuildBalancedBST(a, null, 0, a.length - 1, 0);
    }

    private BSTNode BuildBalancedBST(int[] a, BSTNode parent, int left, int right, int level) {
        if (left > right) {
            return null;
        }

        int mid = (left + right) / 2;
        BSTNode node = new BSTNode(a[mid], parent);
        node.Level = level;

        node.LeftChild = BuildBalancedBST(a, node, left, mid - 1, level + 1);
        node.RightChild = BuildBalancedBST(a, node, mid + 1, right, level + 1);

        return node;
    }

    public boolean IsBalanced(BSTNode root_node) {
        if (root_node == null) {
            return true;
        }

        int left_height = GetHeight(root_node.LeftChild);
        int right_height = GetHeight(root_node.RightChild);

        if (Math.abs(left_height - right_height) <= 1 && IsBalanced(root_node.LeftChild) && IsBalanced(root_node.RightChild)) {
            return true;
        }

        return false;
    }

    private int GetHeight(BSTNode node) {
        if (node == null) {
            return -1;
        }

        return 1 + Math.max(GetHeight(node.LeftChild), GetHeight(node.RightChild));
    }
}

