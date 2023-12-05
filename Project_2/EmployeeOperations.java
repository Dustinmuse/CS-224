package Project_2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class EmployeeOperations
{
    //Methods
    //Method 1:
    public Node constructBalancedEmployeeBST(List<Employee> employees)
    {
        return constructHelper(employees, 0, employees.size() - 1);
    }//close Method 1 (constructBalancedEmployeeBS)
    //Method 2: constructHelper
    private Node constructHelper(List<Employee> employees, int start, int end)
    {
        if (start > end)
        {
            return null; // Base case
        }
        if (start == end)
        {
            return new Node(null, null, employees.get(start));
        }
        //create balanced BST (merge)
        int mid = start + (end - start) / 2;
        Node root = new Node(null, null, employees.get(mid));
        root.setLeft(constructHelper(employees, start, mid - 1));
        root.setRight(constructHelper(employees, mid + 1, end));
        return root;
    }//close Method 2 (constructHelper)
    //Method 3:
    public Node searchRetire(Node root)
    {
        //age > 65
// use preorder traversal to search the BST
        if (root == null)
        {//Base case
            return null;
        }
        if (root.getEmployee().getAge() > 65)
        {
            return root;
        }
//can not find, continue to search
//Search left tree; pre-order traversal
        Node retiredEmployeeNode = searchRetire(root.getLeft());
        if (retiredEmployeeNode != null)
        {
            return retiredEmployeeNode;
        }
//Search right tree
        return searchRetire(root.getRight());
    }//close Method 3
    //Method 4:
    public Node removeRetire(Node root, Employee e)
    {
        if (root == null)
        {
            return null;
        }

        if (e.getId() < root.getEmployee().getId())
        {
            root.setLeft(removeRetire(root.getLeft(), e));
        }
        else if (e.getId() > root.getEmployee().getId())
        {
            root.setRight(removeRetire(root.getRight(), e));
        }
        else
        {
            if (root.getLeft() == null)
            {//case 2: right
                return root.getRight();
            }
            else if (root.getRight() == null)
            {
                return root.getLeft();
            }
            else
            {//case 3: two children
                Node min = this.getMin(root.getRight());
                root.setEmployee(min.getEmployee());
                root.setRight(removeRetire(root.getRight(), min.getEmployee()));
            }
        }
        return root;
    }//close removeRetire method
    public void insertNewHire(Node root, Employee e)
    {
        if (root.getRight() == null)
        {
            root.setRight(new Node(null, null, e));
            return;
        }

        insertNewHire(root.getRight(), e);
    }//close insertNewHire method
    //Method 6
    public void insert(Node root, Employee e)
    {//insert
        if (root == null)
        {
            return;
        }
        if (e.getId() < root.getEmployee().getId())
        {
            if (root.getLeft() == null)
            {
                root.setLeft(new Node(null, null, e));
                return;
            }
            insert(root.getLeft(), e);
        } else
        {
            if (root.getRight() == null)
            {
                root.setRight(new Node(null, null, e));
                return;
            }
            insert(root.getRight(), e);
        }
    }//Close insert
    public void inorderTraversal(Node root)
    {
        if (root == null)
        {
            return;
        }
        //recursive call
        inorderTraversal(root.getLeft());
        System.out.println(root.getEmployee());
        inorderTraversal(root.getRight());
    }//close inorderTraversal method
    //Method 8:
//levelOrderTraversal is BFS
    public void levelOrderTraversal(Node root) {//levelOrderTraversal
//Deque -> Queue
//Data structure Queue(first in, first out)
        Deque<Node> dq = new ArrayDeque<>();
//Deque 1,2,3, can out or out 3
//head out, tail in
        dq.add(root);
//line 120 to 140 standard levelOrder
// Graphic BFS (Breadth first search)
        int level = 0;
        while (!dq.isEmpty())
        {
            int size = dq.size();//check how many
            System.out.println("Level: " + level + " has " + size);
            while (size-- > 0)
            {
                Node curr = dq.pollFirst();
                System.out.println(curr.getEmployee());
                Node left = curr.getLeft();
                Node right = curr.getRight();
                if (left != null)
                {
                    dq.add(left);
                }
                if (right != null)
                {
                    dq.add(right);
                }
            }
            ++level;
        }
    }//Close levelOrderTraversal
    //Method 9: search
    public Node search(Node root, int id)
    {//Search
        if (root == null)
        {
            return null;
        }
        if (root.getEmployee().getId() == id)
        {
            return root;
        }
        if (id < root.getEmployee().getId())
        {
            return search(root.getLeft(), id);
        }
        return search(root.getRight(), id);
    }//Close Search
    //Method: getMin
    private Node getMin(Node root)
    {//getMin
        if (root.getLeft() == null)
        {
            return root;
        }
        return getMin(root.getLeft());
    }//Close getMin
}//close EmployeeOperations class
