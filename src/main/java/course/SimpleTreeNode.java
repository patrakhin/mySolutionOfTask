package course;

import java.util.*;

public class SimpleTreeNode<T>
{
    public T NodeValue; // node value
    public SimpleTreeNode<T> Parent; // parent or null for root
    public List<SimpleTreeNode<T>> Children; // list of child nodes or null

    public int level; // node level

    public SimpleTreeNode(T val, SimpleTreeNode<T> parent)
    {
        NodeValue = val;
        Parent = parent;
        Children = null;
    }
}

 class SimpleTree<T>
 {
    public SimpleTreeNode<T> Root; //root, can be null

    public SimpleTree(SimpleTreeNode<T> root)
    {
        Root = root;
    }

     public SimpleTreeNode<T> getRoot() {
         return Root;
     }

     public void AddChild(SimpleTreeNode<T> ParentNode, SimpleTreeNode<T> NewChild)
    {
        if (ParentNode.Children == null) {
            ParentNode.Children = new ArrayList<>();
        }
        NewChild.level = NewChild.level + 1;
        ParentNode.Children.add(NewChild);
        NewChild.Parent = ParentNode;
        //New child node add code to existing ParentNode
    }

    public void DeleteNode(SimpleTreeNode<T> NodeToDelete)
    {
        if (NodeToDelete == Root) {
            Root = null;
        } else {
            NodeToDelete.Parent.Children.remove(NodeToDelete);
        }
        //delete code for an existing NodeToDelete node
    }

    public List<SimpleTreeNode<T>> GetAllNodes()
    {
        List<SimpleTreeNode<T>> nodes = new ArrayList<>();
        if (Root != null) {
            Queue<SimpleTreeNode<T>> queue = new LinkedList<>();
            queue.add(Root);
            while (!queue.isEmpty()) {
                SimpleTreeNode<T> node = queue.remove();
                nodes.add(node);
                if (node.Children != null) {
                    queue.addAll(node.Children);
                }
            }
        }
        return nodes;
        //code of all tree nodes in certain order
    }

    public List<SimpleTreeNode<T>> FindNodesByValue(T val)
    {
        List<SimpleTreeNode<T>> nodes = new ArrayList<>();
        if (Root != null) {
            Queue<SimpleTreeNode<T>> queue = new LinkedList<>();
            queue.add(Root);
            while (!queue.isEmpty()) {
                SimpleTreeNode<T> node = queue.remove();
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

    public void MoveNode(SimpleTreeNode<T> OriginalNode, SimpleTreeNode<T> NewParent)
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
            Queue<SimpleTreeNode<T>> queue = new LinkedList<>();
            queue.add(Root);
            while (!queue.isEmpty()) {
                SimpleTreeNode<T> node = queue.remove();
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
        Queue<SimpleTreeNode<T>> queue = new LinkedList<>();
        queue.add(Root);
        while (!queue.isEmpty()) {
            SimpleTreeNode<T> node = queue.remove();
            if (node.Children != null) {
                for (SimpleTreeNode<T> child : node.Children) {
                    child.level = node.level + 1;
                    queue.add(child);
                }
            }
        }
    }

 }


