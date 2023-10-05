package Trees.BinaryTree;

import java.util.ArrayList;
/**
 * ArrayBinaryTree implements the BinaryTreeADT interface using an array
 */
import java.util.Iterator;

public class ArrayBinaryTree<T> implements BinaryTreeADT<T>
{
    protected int count;
    protected T[] tree;
    private final int capacity = 50;
    /**
     * Creates an empty binary tree
     *
     */
    @SuppressWarnings("unchecked")
    public ArrayBinaryTree()
    {
        count = 0;
        tree = (T[]) (new Object[capacity]);
    }
    public void add(int index, T element)
    {
        tree[index]=element;
        count++;
        if (count==tree.length)
        {
            expandCapacity();
        }
    }
    public T get(int index)
    {
        return tree[index];
    }
    /**
     * Private method to expand capacity if full.
     */
    protected void expandCapacity()
    {
        @SuppressWarnings("unchecked")
        T[] temp = (T[]) new Object[tree.length * 2];
        for (int ct = 0; ct < tree.length; ct++)
            temp[ct] = tree[ct];
        tree = temp;
    }
    /**
     * Returns the root element of the tree
     * @return element stored at the root
     * @throws EmptyCollectionException if the tree is empty
     */
    public T getRoot() throws EmptyCollectionException
    {
        if (isEmpty())
        {throw new EmptyCollectionException("binary tree");}
        return tree [0];
    }
    /**
     * Returns true if this binary tree is empty and false otherwise.
     *
     * @return true if this binary tree is empty
     */
    public boolean isEmpty()
    {
        return count==0;
    }
    /**
     * Returns the integer size of this binary tree.
     *
     * @return the integer size of this binary tree
     */
    public int size()
    {
        return count;
    }
    /**
     * Returns true if this tree contains an element that matches the specified
     * target element and false otherwise.
     *
     * @param targetElement: the element being sought in the tree
     * @return true if the element is in this tree
     */
    public boolean contains(T targetElement)
    {
        boolean found = false;
        for (T element : tree)
            if (targetElement.equals(element))
                found = true;
        return found;
    }
    /**
     * Returns a reference to the specified target element if it is found in
     * this binary tree. Throws a NoSuchElementException if the specified target
     * element is not found in the binary tree.
     *
     * @param targetElement
     * the element being sought in the tree
     * @return true if the element is in the tree
     * @throws ElementNotFoundException
     * if an element not found exception occurs
     */
    @SuppressWarnings("unused")
    public T find(T targetElement) throws ElementNotFoundException
    {
        T temp = null;
        boolean found = false;
        for (T element : tree)
            if (element!=null && targetElement.equals(element))
            {
                found = true;
                temp=element;
            }
        if (!found)
        {
            throw new ElementNotFoundException(" Not found");
        }
        return temp;
    }
    /**
     * @return index location of targetElement, if found
     * @throws exception if not found
     */
    public int findIndex(T targetElement)
    {
//DO LINEAR SEARCH. IF THE ELEMENT IS FOUND, RETURN THE INDEX LOCATION
//OTHERWISE THROW THE ElementNotFoundException
        int index=-1;
        boolean found=false;
        for (int i=0; i<tree.length && !found; i++)
        {
            if(tree[i]!=null)
            {
                if (targetElement.equals(tree[i]))
                {
                    found=true;
                    index=i;
                }
            }
        }//close for loop
        if (!found)
        {
            throw new ElementNotFoundException(" Not found");
        }
        return index;
    }
    /**
     * Returns a string representation of this binary tree.
     *
     * @return a string representation of this binary tree
     */
    public String toString()
    {
        ArrayList<T> templist = new ArrayList<T>();
        inorder(0, templist);
        return templist.toString();
    }
    /**
     * Performs an inorder traversal on this binary tree by calling an
     * overloaded, recursive inorder method that starts with the root.
     *
     * @return an iterator over the binary tree
     */
    public Iterator<T> iteratorInOrder()
    {
        ArrayList<T> templist = new ArrayList<T>();
        inorder(0, templist);
        return templist.iterator();
    }
    /**
     * Performs a recursive inorder traversal.
     *
     * @param node
     * the node used in the traversal
     * @param templist
     * the temporary list used in the traversal
     */
    protected void inorder(int node, ArrayList<T> templist)
    {//LTR
        if (node < tree.length)
            if (tree[node] != null)
            {
                inorder(node * 2 + 1, templist); //inorder traversal to left child
                templist.add(tree[node]); //visit Root
                inorder((node + 1) * 2, templist); //inorder traversal to right child
            }
    }
    /**
     * Performs a preorder traversal on this binary tree by calling an
     * overloaded, recursive preorder method that starts with the root.
     *
     * @return an iterator over the binary tree
     */
    public Iterator<T> iteratorPreOrder()
    {
        ArrayList<T> templist = new ArrayList<T>();
        preorder(0, templist);
        return templist.iterator();
    }
    /**
     * Performs a recursive preorder traversal.
     * @param node the node used in the traversal
     * @param templist the temporary list used in the traversal
     */
    protected void preorder(int node, ArrayList<T> templist)
    {//TLR
        if (node < tree.length)//base case
            if (tree[node] != null)
            {
                templist.add(tree[node]);
                preorder(node * 2 + 1, templist);
                preorder((node + 1) * 2, templist);
            }//close if
    }//close preorder method
    /**
     * Performs a postorder traversal on the binary tree by calling an
     * overloaded, recursive postorder method that starts with the root.
     *
     * @return an iterator over the binary tree
     */
    public Iterator<T> iteratorPostOrder()
    {
        ArrayList<T> templist = new ArrayList<T>();
        postorder(0, templist);
        return templist.iterator();
    }
    /**
     * Performs a recursive postorder traversal.
     *
     * @param node the node used in the traversal
     * @param templist the temporary list used in the traversal
     */
    protected void postorder(int node, ArrayList<T> templist) {//LRT
        if (node < tree.length)
            if (tree[node] != null) {
                postorder(2*node+1, templist);
                postorder(2*node+2, templist);
                templist.add(tree[node]);
            }
    }//postorder method
}
