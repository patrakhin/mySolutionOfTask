package course;

import java.io.*;
import java.util.*;


class BSTNode<T>
{
    public int NodeKey; // key of the node
    public T NodeValue; // value of the node
    public BSTNode<T> Parent; // parent node or null for root
    public BSTNode<T> LeftChild; // left child
    public BSTNode<T> RightChild; // right child

    public BSTNode(int key, T val, BSTNode<T> parent)
    {
        NodeKey = key;
        NodeValue = val;
        Parent = parent;
        LeftChild = null;
        RightChild = null;
    }
}

// intermediate search result
class BSTFind<T>
{
    // null if the tree is empty
    public BSTNode<T> Node;
    // true if the node was found
    public boolean NodeHasKey;
    // true if we should add a new node as a left child of the parent node
    public boolean ToLeft;

    public BSTFind() { Node = null;}
}

class BST<T> {
    BSTNode<T> Root; // root node or null

    public BST(BSTNode<T> node) {
        Root = node;
    }

    public BSTFind<T> FindNodeByKey(int key) {
        // create a new search result object
        BSTFind<T> result = new BSTFind<T>();
        // start searching from the root node
        BSTNode<T> currentNode = Root;
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
        BSTFind<T> findResult = FindNodeByKey(key);
        // if the node already exists, return false
        if (findResult.NodeHasKey) {
            return false;
        }
        // create a new node with the given key and value
        BSTNode<T> newNode = new BSTNode<T>(key, val, findResult.Node);
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

    public BSTNode<T> FinMinMax(BSTNode<T> FromNode, boolean FindMax) {
        // find the node with the minimum/maximum key in the subtree
        if (FromNode == null) {
            return null;
        }
        BSTNode<T> currentNode = FromNode;
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
        BSTFind<T> findResult = FindNodeByKey(key);
        // if the node doesn't exist, return false
        if (!findResult.NodeHasKey) {
            return false;
        }
        // get the node to be deleted
        BSTNode<T> nodeToDelete = findResult.Node;
        // if the node has two children, replace it with its successor
        if (nodeToDelete.LeftChild != null && nodeToDelete.RightChild != null) {
            // find the successor node
            BSTNode<T> successorNode = nodeToDelete.RightChild;
            while (successorNode.LeftChild != null) {
                successorNode = successorNode.LeftChild;
            }
            // replace the node to be deleted with its successor
            nodeToDelete.NodeKey = successorNode.NodeKey;
            nodeToDelete.NodeValue = successorNode.NodeValue;
            nodeToDelete = successorNode;
        }
        // get the parent node of the node to be deleted
        BSTNode<T> parentNode = nodeToDelete.Parent;
        // get the child node of the node to be deleted
        BSTNode<T> childNode = nodeToDelete.LeftChild != null ? nodeToDelete.LeftChild : nodeToDelete.RightChild;
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
    private int CountRecursive(BSTNode<T> node) {
        if (node == null) {
            return 0;
        }
        return 1 + CountRecursive(node.LeftChild) + CountRecursive(node.RightChild);
    }

    //tree width traverse
    public ArrayList<BSTNode> WideAllNodes() {
        ArrayList<BSTNode> result = new ArrayList<>();
        if (Root == null) {
            return result;
        }
        Queue<BSTNode> queue = new LinkedList<>();
        queue.add(Root);
        while (!queue.isEmpty()) {
            BSTNode node = queue.remove();
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
    public ArrayList<BSTNode> DeepAllNodes(int order) {
        ArrayList<BSTNode> nodeList = new ArrayList<BSTNode>();
        if (Root == null) {
            return nodeList;
        }
        deepAllNodesHelper(Root, nodeList, order);
        return nodeList;
    }

    private void deepAllNodesHelper(BSTNode node, ArrayList<BSTNode> nodeList, int order) {
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

