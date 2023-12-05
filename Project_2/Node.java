package Project_2;

public class Node
{
    //Step 1: Instance Variables
    private Node left;
    private Node right;
    private Employee e;

    //Step 2: Constructor
    public Node(Node left, Node right, Employee e)
    {
        this.left = left;
        this.right = right;
        this.e = e;
    }//close constructor

    //Step 3: Methods
    public Node getLeft()
    {
        return this.left;
    }
    public Node getRight()
    {
        return this.right;
    }
    public void setLeft(Node left)
    {
        this.left = left;
    }
    public void setRight(Node right)
    {
        this.right = right;
    }
    public Employee getEmployee()
    {
        return e;
    }
    public void setEmployee(Employee e)
    {
        this.e = e;
    }
}//close Node class
