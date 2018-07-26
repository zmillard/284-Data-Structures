/** Self-balancing binary search tree using the algorithm defined
 *  by Adelson-Velskii and Landis.
 *  @author Koffman and Wolfgang
 */

public class AVLTree<E extends Comparable<E>> extends BinarySearchTreeWithRotate<E>
{
    /** Flag to indicate that height of tree has increased. */
    private boolean increase;

    /** Flag to indicate that height of tree has decreased */
    private boolean decrease;

    /** Class to represent an AVL Node. It extends the
        BinaryTree.Node by adding the balance field. */
    private static class AVLNode<E> extends Node<E>
    {
        /** Constant to indicate left-heavy */
        public static final int LEFT_HEAVY = -1;

        /** Constant to indicate balanced */
        public static final int BALANCED = 0;

        /** Constant to indicate right-heavy */
        public static final int RIGHT_HEAVY = 1;

        /** balance is right subtree height – left subtree height */
        private int balance;

        // Methods
        /** Construct a node with the given item as the data field.
            @param item The data field
         */
        public AVLNode(E item)
        {
            super(item);
            balance = BALANCED;
        }

        /** Return a string representation of this object.
            The balance value is appended to the contents.
            @return String representation of this object
         */
        public String toString()
        {
            return balance + ": " + super.toString();
        }
    }

    /** add starter method.
        pre: the item to insert implements the Comparable interface.
        @param item The item being inserted.
        @return true if the object is inserted; false
                if the object already exists in the tree
        @throws ClassCastException if item is not Comparable
     */
    public boolean add(E item)
    {
        increase = false;
        root = add((AVLNode<E>)root, item);
        return addReturn;
    }

    /** Recursive add method. Inserts the given object into the tree.
        post: addReturn is set true if the item is inserted,
              false if the item is already in the tree.
        @param localRoot The local root of the subtree
        @param item The object to be inserted
        @return The new local root of the subtree with the item
                inserted
     */
    private AVLNode<E> add(AVLNode<E> localRoot, E item)
    {
        if (localRoot == null)
        {
            addReturn = true;
            increase = true;
            return new AVLNode<E>(item);
        }

        if (item.compareTo(localRoot.data) == 0)
        {
            // Item is already in the tree.
            increase = false;
            addReturn = false;
            return localRoot;
        }

        else if (item.compareTo(localRoot.data) < 0)
        {
            // item < data
            localRoot.left = add((AVLNode<E>)localRoot.left, item);

            if (increase)
            {
                decrementBalance(localRoot);
                if (localRoot.balance < AVLNode.LEFT_HEAVY)
                {
                    increase = false;
                    return rebalanceLeft(localRoot);
                }
            }
            return localRoot; // Rebalance not needed.
        }
        else
        {
            // item > data
            localRoot.right = add((AVLNode<E>)localRoot.right, item);
            if (increase)
            {
                incrementBalance(localRoot);
                if (localRoot.balance > AVLNode.RIGHT_HEAVY)
                {
                    return rebalanceRight(localRoot);
                }
                else
                {
                    return localRoot;
                }
            }
            else
            {
                return localRoot;
            }
        }
    }


    /** Method to rebalance left.
      pre: localRoot is the root of an AVL subtree that is
           critically left-heavy.
      post: Balance is restored.
      @param localRoot Root of the AVL subtree
             that needs rebalancing
      @return a new localRoot
     */
    private AVLNode<E> rebalanceLeft(AVLNode<E> localRoot)
    {
        // Obtain reference to left child.
        AVLNode<E> leftChild = (AVLNode<E>)localRoot.left;
        // See whether left-right heavy.
        if (leftChild.balance > AVLNode.BALANCED)
        {
            // Obtain reference to left-right child.
            AVLNode<E> leftRightChild = (AVLNode<E>)leftChild.right;
            /** Adjust the balances to be their new values after
                the rotations are performed.
             */
            if (leftRightChild.balance < AVLNode.BALANCED)
            {
                leftChild.balance = AVLNode.BALANCED;
                leftRightChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.RIGHT_HEAVY;
            }
            else
            {
                leftChild.balance = AVLNode.LEFT_HEAVY;
                leftRightChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.BALANCED;
            }
            // Perform left rotation.
            localRoot.left = rotateLeft(leftChild);
        }
        else
        { // Left-Left case
            /** In this case the leftChild (the new root)
                and the root (new right child) will both be balanced
                after the rotation.
             */
            leftChild.balance = AVLNode.BALANCED;
            localRoot.balance = AVLNode.BALANCED;
        }
        // Now rotate the local root right.
        return (AVLNode<E>)rotateRight(localRoot);
    }

    private AVLNode<E> rebalanceRight(AVLNode<E> localRoot)
    {
        // Obtain reference to left child.
        AVLNode<E> rightChild = (AVLNode<E>)localRoot.right;
        // See whether left-right heavy.
        if (rightChild.balance < AVLNode.BALANCED)
        {
            // Obtain reference to right-left child.
            AVLNode<E> rightRightChild = (AVLNode<E>)rightChild.left;
            /** Adjust the balances to be their new values after
                the rotations are performed.
             */
            if (rightLeftChild.balance < AVLNode.BALANCED)
            {
                rightChild.balance = AVLNode.BALANCED;
                rightLeftChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.LEFT_HEAVY;
            }
            else
            {
                rightChild.balance = AVLNode.RIGHT_HEAVY;
                rightLeftChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.BALANCED;
            }
            // Perform left rotation.
            localRoot.right = rotateLeft(rightChild);
        }
        else
        { // Left-Left case
            /** In this case the leftChild (the new root)
                and the root (new right child) will both be balanced
                after the rotation.
             */
            rightChild.balance = AVLNode.BALANCED;
            localRoot.balance = AVLNode.BALANCED;
        }
        // Now rotate the local root right.
        return (AVLNode<E>)rotateLeft(localRoot);
    }
    /**** TODO rebalanceRight ****/

    private void decrementBalance(AVLNode<E> node)
    {
        // Decrement the balance.
        node.balance--;
        if (node.balance == AVLNode.BALANCED)
        {
            /** If now balanced, overall height has not increased. */
            increase = false;
        }
    }

    /**** TODO incrementBalance ****/
    private void incrementBalance(AVLNode<E> node)
    {
        // Increment the balance.
        node.balance++;
        if (node.balance == AVLNode.BALANCED)
        {
            /** If now balanced, overall height has not increased. */
            increase = false;
        }
    }
    public static void main(String []args)
    {
        AVLTree<String> ourTree = new AVLTree<String>();
        ourTree.add("The");
        System.out.println(ourTree);
    }
}
