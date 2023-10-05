package Trees.BinaryTree;

import java.util.Iterator;

public class FamilyTree
{
    private ArrayBinaryTree <FamilyTreeObj> tree;
    public FamilyTree()
    {
        tree= new ArrayBinaryTree<FamilyTreeObj>();
    }
    public void addRoot(String rootName, String relationship)
    {
        if (tree.isEmpty())
        {
            FamilyTreeObj obj = new FamilyTreeObj(rootName, relationship);
            tree.add(0, obj);
            System.out.println("Added Root: " + tree.getRoot().toString() + ", tree size is: " + tree.size());
        }
    }//close add method
    public void add(String childRelationship, String childName, String childPosition, String parentRelationship, String parentName)
    {
// finds index of parent if exists; otherwise, throws Exception
        int parentNode = tree.findIndex(new FamilyTreeObj(parentName, parentRelationship));
        if (childPosition.equalsIgnoreCase("left"))
        {
            int childNode = 2 * parentNode + 1;
            tree.add(childNode, new FamilyTreeObj(childName, childRelationship));
            System.out.println("Added " + tree.get(childNode) + " as Left child to " + tree.get(parentNode) + ", tree size is: " + tree.size());
        }
        else if (childPosition.equalsIgnoreCase("right"))
        {
            int childNode = 2 * parentNode + 2;
            tree.add(childNode, new FamilyTreeObj(childName, childRelationship));
            System.out.println("Added " + tree.get(childNode) + " as Right child to " + tree.get(parentNode) + ", tree size is: " + tree.size());
        } else
            throw new ChildNotFoundException();
    }//close add method
    public void printPreOrder()
    {//Use Iterator
        Iterator<FamilyTreeObj> it = tree.iteratorPreOrder();
        System.out.print("Preorder Traversal: ");
        while (it.hasNext())
            System.out.print(it.next() + " ");
        System.out.println();
    }
    public void printInOrder()
    {//Use Iterator
        Iterator<FamilyTreeObj> it = tree.iteratorInOrder();
        System.out.print("Inorder Traversal: ");
        while (it.hasNext())
            System.out.print(it.next() + " ");
        System.out.println();
    }
    public void printPostOrder()
    {//Use Iterator
        Iterator<FamilyTreeObj> it = tree.iteratorPostOrder();
        System.out.print("Postorder Traversal: ");
        while (it.hasNext())
            System.out.print(it.next() + " ");
        System.out.println();
    }
    public FamilyTreeObj find(FamilyTreeObj obj)
    {
        return tree.find(obj);
    }
}
