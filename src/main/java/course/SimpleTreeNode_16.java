package course;

import java.util.*;

public class SimpleTreeNode_16<T>
{
    public T NodeValue; // node value
    public SimpleTreeNode_16<T> Parent; // parent or null for root
    public List<SimpleTreeNode_16<T>> Children; // list of child nodes or null

    public int level; // node level

    public SimpleTreeNode_16(T val, SimpleTreeNode_16<T> parent)
    {
        NodeValue = val;
        Parent = parent;
        Children = null;
    }
}

 class SimpleTree<T>
 {
    public SimpleTreeNode_16<T> Root; //root, can be null

    public SimpleTree(SimpleTreeNode_16<T> root)
    {
        Root = root;
    }

     public SimpleTreeNode_16<T> getRoot() {
         return Root;
     }

     public void AddChild(SimpleTreeNode_16<T> ParentNode, SimpleTreeNode_16<T> NewChild)
    {
        if (ParentNode.Children == null) {
            ParentNode.Children = new ArrayList<>();
        }
        NewChild.level = NewChild.level + 1;
        ParentNode.Children.add(NewChild);
        NewChild.Parent = ParentNode;
        //New child node add code to existing ParentNode
    }

    public void DeleteNode(SimpleTreeNode_16<T> NodeToDelete)
    {
        if (NodeToDelete == Root) {
            Root = null;
        } else {
            NodeToDelete.Parent.Children.remove(NodeToDelete);
        }
        //delete code for an existing NodeToDelete node
    }

    public List<SimpleTreeNode_16<T>> GetAllNodes()
    {
        List<SimpleTreeNode_16<T>> nodes = new ArrayList<>();
        if (Root != null) {
            Queue<SimpleTreeNode_16<T>> queue = new LinkedList<>();
            queue.add(Root);
            while (!queue.isEmpty()) {
                SimpleTreeNode_16<T> node = queue.remove();
                nodes.add(node);
                if (node.Children != null) {
                    queue.addAll(node.Children);
                }
            }
        }
        return nodes;
        //code of all tree nodes in certain order
    }

    public List<SimpleTreeNode_16<T>> FindNodesByValue(T val)
    {
        List<SimpleTreeNode_16<T>> nodes = new ArrayList<>();
        if (Root != null) {
            Queue<SimpleTreeNode_16<T>> queue = new LinkedList<>();
            queue.add(Root);
            while (!queue.isEmpty()) {
                SimpleTreeNode_16<T> node = queue.remove();
                if (node.NodeValue.equals(val)) {
                    nodes.add(node);
                }
                if (node.Children != null) {
                    queue.addAll(node.Children);
                }
            }
        }
        return nodes;
        //node search code by value
    }

    public void MoveNode(SimpleTreeNode_16<T> OriginalNode, SimpleTreeNode_16<T> NewParent)
    {
        DeleteNode(OriginalNode);
        AddChild(NewParent, OriginalNode);
        // the node’s moving code together with its subtree --
        // as a child for the NewParent host
    }

    public int Count()
    {
        return GetAllNodes().size();
        // number of all nodes in the tree
    }

    public int LeafCount()
    {
        int count = 0;
        if (Root != null) {
            Queue<SimpleTreeNode_16<T>> queue = new LinkedList<>();
            queue.add(Root);
            while (!queue.isEmpty()) {
                SimpleTreeNode_16<T> node = queue.remove();
                if (node.Children == null || node.Children.isEmpty()) {
                    count++;
                } else {
                    queue.addAll(node.Children);
                }
            }
        }
        return count;
        // number of leaves in the tree
    }

    public void setLevels() {
        if (Root == null) return;
        Root.level = 0;
        Queue<SimpleTreeNode_16<T>> queue = new LinkedList<>();
        queue.add(Root);
        while (!queue.isEmpty()) {
            SimpleTreeNode_16<T> node = queue.remove();
            if (node.Children != null) {
                for (SimpleTreeNode_16<T> child : node.Children) {
                    child.level = node.level + 1;
                    queue.add(child);
                }
            }
        }
    }

     public ArrayList<T> EvenTrees() {

         ArrayList<T> candidatesForDelete = new ArrayList<>();
         SimpleTreeNode_16<T> node = Root;

         List<SimpleTreeNode_16<T>> storageTemp = new ArrayList<>();
         storageTemp.add(node);

         while (!storageTemp.isEmpty()) {
             node = storageTemp.remove(0);
             SimpleTree<T> subTree = new SimpleTree<>(node); // create a subtree starting from the root

             // work only with even trees
             if (subTree.Count() % 2 == 0) { // Count - method is here
                 if (node.Parent != null) { // if we are not on the first (root) node of the tree
                     candidatesForDelete.add(node.Parent.NodeValue);
                     candidatesForDelete.add(node.NodeValue);
                 }
                 storageTemp.addAll(node.Children);
             }
         }
         return candidatesForDelete;
     }

 }


