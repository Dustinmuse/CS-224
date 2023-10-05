package Trees.BinaryTree;

public class MakeFamilyTree //Driver class
{
    public static void main(String args[])
    {
        FamilyTree myFamily = new FamilyTree();
        myFamily.addRoot("John", "Grandpa");// add root
        myFamily.add("Dad", "John", "left", "Grandpa", "John");
        myFamily.add("Aunt", "Becky", "right", "Grandpa", "John");
        myFamily.add("Me", "John", "Left", "Dad", "John");
        myFamily.add("Sister", "Jessie", "Right", "Dad", "John");
        myFamily.add("Cousin", "Donna", "Left", "Aunt", "Becky");
        myFamily.add("Cousin", "Jacob", "Right", "Aunt", "Becky");
        myFamily.add("Son", "John", "Left", "Me", "John");
        myFamily.add("Nephew", "Austin", "Right", "Sister", "Jessie");
        myFamily.add("Cousin", "Sally", "Left", "Cousin", "Jacob");
        System.out.println("\n-------------------------------------------------------------------\n");
        myFamily.printInOrder();
        myFamily.printPostOrder();
        myFamily.printPreOrder();
        System.out.println();
        System.out.println("1:"+myFamily.find(new FamilyTreeObj("John", "Grandpa")));
        System.out.println("2:"+myFamily.find(new FamilyTreeObj("Jacob", "Grandpa")));
    }
}
