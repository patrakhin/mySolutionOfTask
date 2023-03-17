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
        BSTFind<T> findNode = FindNodeByKey(key);
        if (!findNode.NodeHasKey) {
            // if the node doesn't exist, return false
            return false;
        }
        // get the node to be deleted
        BSTNode<T> currentNode = findNode.Node;

        if (currentNode.LeftChild == null && currentNode.RightChild == null) {
            // case 1: remove a leaf
            if (currentNode.Parent == null) {
                // if this root
                Root = null;
            } else {
                if (currentNode.Parent.LeftChild == currentNode) {
                    // if the current node is the left child of its parent
                    currentNode.Parent.LeftChild = null;
                } else {
                    //if the current node is the right child of its parent
                    currentNode.Parent.RightChild = null;
                }
            }
        } else if (currentNode.LeftChild != null && currentNode.RightChild != null) {
            // case 2: deleting a node with two children
            BSTNode<T> minRight = FinMinMax(currentNode.RightChild, false);
            currentNode.NodeKey = minRight.NodeKey;
            currentNode.NodeValue = minRight.NodeValue;
            // remove the node that we took as a replacement
            currentNode = minRight;
        } else {
            //case 3: deleting a node with one child
            BSTNode<T> child = (currentNode.LeftChild != null) ? currentNode.LeftChild : currentNode.RightChild;

            if (currentNode.Parent == null) {
                // if this root
                Root = child;
            } else {
                if (currentNode.Parent.LeftChild == currentNode) {
                    // if the current node is the left child of its parent
                    currentNode.Parent.LeftChild = child;
                } else {
                    // if the current node is the right child of its parent
                    currentNode.Parent.RightChild = child;
                }
                child.Parent = currentNode.Parent;
            }
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

}
