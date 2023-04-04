package course;

import java.util.*;


class BSTNode_12<T>
{
    public int NodeKey; // key of the node
    public T NodeValue; // value of the node
    public BSTNode_12<T> Parent; // parent node or null for root
    public BSTNode_12<T> LeftChild; // left child
    public BSTNode_12<T> RightChild; // right child

    public BSTNode_12(int key, T val, BSTNode_12<T> parent)
    {
        NodeKey = key;
        NodeValue = val;
        Parent = parent;
        LeftChild = null;
        RightChild = null;
    }
}

// intermediate search result
class BSTFind_12<T>
{
    // null if the tree is empty
    public BSTNode_12<T> Node;
    // true if the node was found
    public boolean NodeHasKey;
    // true if we should add a new node as a left child of the parent node
    public boolean ToLeft;

    public BSTFind_12() { Node = null;}
}

class BST_12<T> {
    BSTNode_12<T> Root; // root node or null

    public BST_12(BSTNode_12<T> node) {
        Root = node;
    }

    public BSTFind_12<T> FindNodeByKey(int key) {
        // create a new search result object
        BSTFind_12<T> result = new BSTFind_12<T>();
        // start searching from the root node
        BSTNode_12<T> currentNode = Root;
        // loop until we find the node or reach a leaf node
        while (currentNode != null) {
            // compare the key of the current node with the search key
            if (currentNode.NodeKey == key) {
                result.Node = currentNode;
                result.NodeHasKey = true;
                break;
            } else if (key < currentNode.NodeKey) {
                // the search key is less than the key of the current node, search in the left subtree
                if (currentNode.LeftChild == null) {
                    result.Node = currentNode;
                    result.NodeHasKey = false;
                    result.ToLeft = true;
                    break;
                }
                currentNode = currentNode.LeftChild;
            } else {
                // the search key is greater than the key of the current node, search in the right subtree
                if (currentNode.RightChild == null) {
                    result.Node = currentNode;
                    result.NodeHasKey = false;
                    result.ToLeft = false;
                    break;
                }
                currentNode = currentNode.RightChild;
            }
        }
        return result;
    }

    public boolean AddKeyValue(int key, T val) {
        // search for the node with the given key
        BSTFind_12<T> findResult = FindNodeByKey(key);
        // if the node already exists, return false
        if (findResult.NodeHasKey) {
            return false;
        }
        // create a new node with the given key and value
        BSTNode_12<T> newNode = new BSTNode_12<T>(key, val, findResult.Node);
        // add the new node to the tree
        if (findResult.Node == null) {
            // the tree is empty, make the new node the root node
            Root = newNode;
        } else if (findResult.ToLeft) {
            // add the new node as the left child of the parent node
            findResult.Node.LeftChild = newNode;
        } else {
            // add the new node as the right child of the parent node
            findResult.Node.RightChild = newNode;
        }
        return true;
    }

    public BSTNode_12<T> FinMinMax(BSTNode_12<T> FromNode, boolean FindMax) {
        // find the node with the minimum/maximum key in the subtree
        if (FromNode == null) {
            return null;
        }
        BSTNode_12<T> currentNode = FromNode;
        if (FindMax) {
            // find the node with the maximum key
            while (currentNode.RightChild != null) {
                currentNode = currentNode.RightChild;
            }
        } else {
            // find the node with the minimum key
            while (currentNode.LeftChild != null) {
                currentNode = currentNode.LeftChild;
            }
        }
        return currentNode;
    }

    public boolean DeleteNodeByKey(int key) {
        // search for the node with the given key
        BSTFind_12<T> findResult = FindNodeByKey(key);
        // if the node doesn't exist, return false
        if (!findResult.NodeHasKey) {
            return false;
        }
        // get the node to be deleted
        BSTNode_12<T> nodeToDelete = findResult.Node;
        // if the node has two children, replace it with its successor
        if (nodeToDelete.LeftChild != null && nodeToDelete.RightChild != null) {
            // find the successor node
            BSTNode_12<T> successorNode = nodeToDelete.RightChild;
            while (successorNode.LeftChild != null) {
                successorNode = successorNode.LeftChild;
            }
            // replace the node to be deleted with its successor
            nodeToDelete.NodeKey = successorNode.NodeKey;
            nodeToDelete.NodeValue = successorNode.NodeValue;
            nodeToDelete = successorNode;
        }
        // get the parent node of the node to be deleted
        BSTNode_12<T> parentNode = nodeToDelete.Parent;
        // get the child node of the node to be deleted
        BSTNode_12<T> childNode = nodeToDelete.LeftChild != null ? nodeToDelete.LeftChild : nodeToDelete.RightChild;
        // remove the node to be deleted from the tree
        if (childNode != null) {
            // the node to be deleted has a child node, replace it with the child node
            childNode.Parent = parentNode;
        }
        if (parentNode == null) {
            // the node to be deleted is the root node, update the root node
            Root = childNode;
        } else if (nodeToDelete == parentNode.LeftChild) {
            // the node to be deleted is the left child of the parent node
            parentNode.LeftChild = childNode;
        } else {
            // the node to be deleted is the right child of the parent node
            parentNode.RightChild = childNode;
        }
        return true;
    }


    public int Count() {
        // start counting from the root node
        return CountRecursive(Root);
    }

    // count nodes in the subtree rooted at the given node recursively
    private int CountRecursive(BSTNode_12<T> node) {
        if (node == null) {
            return 0;
        }
        return 1 + CountRecursive(node.LeftChild) + CountRecursive(node.RightChild);
    }

    //tree width traverse
    public ArrayList<BSTNode_12> WideAllNodes() {
        ArrayList<BSTNode_12> result = new ArrayList<>();
        if (Root == null) {
            return result;
        }
        Queue<BSTNode_12> queue = new LinkedList<>();
        queue.add(Root);
        while (!queue.isEmpty()) {
            BSTNode_12 node = queue.remove();
            result.add(node);
            if (node.LeftChild != null) {
                queue.add(node.LeftChild);
            }
            if (node.RightChild != null) {
                queue.add(node.RightChild);
            }
        }
        return result;
    }


    //tree depth traversal and receiving values 0 (in-order), 1 (post-order) and 2 (pre-order)
    public ArrayList<BSTNode_12> DeepAllNodes(int order) {
        ArrayList<BSTNode_12> nodeList = new ArrayList<BSTNode_12>();
        if (Root == null) {
            return nodeList;
        }
        deepAllNodesHelper(Root, nodeList, order);
        return nodeList;
    }

    private void deepAllNodesHelper(BSTNode_12 node, ArrayList<BSTNode_12> nodeList, int order) {
        if (node == null) {
            return;
        }
        if (order == 0) { // in-order
            deepAllNodesHelper(node.LeftChild, nodeList, order);
            nodeList.add(node);
            deepAllNodesHelper(node.RightChild, nodeList, order);
        } else if (order == 1) { // post-order
            deepAllNodesHelper(node.LeftChild, nodeList, order);
            deepAllNodesHelper(node.RightChild, nodeList, order);
            nodeList.add(node);
        } else if (order == 2) { // pre-order
            nodeList.add(node);
            deepAllNodesHelper(node.LeftChild, nodeList, order);
            deepAllNodesHelper(node.RightChild, nodeList, order);
        }
    }

}

