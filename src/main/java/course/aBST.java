package course;

import java.util.*;

class aBST
{
    public Integer Tree []; // keys array

    public aBST(int depth)
    {
        //calculating array size for depth tree "depth":
        int tree_size = (int) Math.pow(2, depth + 1) - 1;
        Tree = new Integer[ tree_size ];
        for(int i=0; i<tree_size; i++) Tree[i] = null;
    }

    public Integer FindKeyIndex(int key)
    {
        int currentIndex = 0;
        while (currentIndex < Tree.length && Tree[currentIndex] != null)
        {
            if (key == Tree[currentIndex])
            {
                return currentIndex;
            }
            else if (key < Tree[currentIndex])
            {
                currentIndex = 2 * currentIndex + 1; // go left
            }
            else
            {
                currentIndex = 2 * currentIndex + 2; // go right
            }
        }

        if (currentIndex >= Tree.length || Tree[currentIndex] != null)
        {
            // We reached the end of the tree and all nodes exist, so return null
            return null;
        }
        else
        {
            // We've found an empty slot for the key
            return -currentIndex;
        }
    }

    public int AddKey(int key)
    {
        int indexKeyAdded = 0;
        while (indexKeyAdded < Tree.length && Tree[indexKeyAdded] != null) {
            if (key == Tree[indexKeyAdded]) {
                return indexKeyAdded; // key already exists
            } else if (key < Tree[indexKeyAdded]) {
                indexKeyAdded = 2 * indexKeyAdded + 1; // move to the left child
            } else {
                indexKeyAdded = 2 * indexKeyAdded + 2; // move to the right child
            }
        }
        if (indexKeyAdded < Tree.length) {
            Tree[indexKeyAdded] = key;
            return -indexKeyAdded; // new key added
        } else {
            return -1; // array is full
        }
    }

}