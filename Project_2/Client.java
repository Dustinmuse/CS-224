package Project_2;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.util.Scanner;

public class Client
{
    public static void main(String[] args)
    {
        String inputFile = "Project_2/company.csv";
        List<Employee> employees = new ArrayList<>();
        try
        {
            Scanner sc = new Scanner(new File(inputFile));
            String header = sc.nextLine();
            System.out.println(header);
            while (sc.hasNext())
            {
                String ss = sc.nextLine();
                String [] s = ss.split(",");
                Employee e = new Employee(Integer.parseInt(s[0]), s[1], s[2], Integer.parseInt(s[3]));
                employees.add(e);
            }//Close while
            sc.close();
            EmployeeOperations operation = new EmployeeOperations();
            Node root = operation.constructBalancedEmployeeBST(employees);
            Node retiredEmployeeNode = operation.searchRetire(root);//age > 65
            int retiredId = retiredEmployeeNode.getEmployee().getId();
            System.out.println(retiredEmployeeNode.getEmployee());
//Delete node
            operation.removeRetire(root, retiredEmployeeNode.getEmployee());
            Node node = operation.search(root, retiredId);
//Test if the employee was removed
            if (node == null)
            {
                System.out.println("Retired employee is removed");
            }
            else
            {
                System.out.println(node.getEmployee());
            }
            Employee newHire = new Employee(100001, "London", "Hodge", 27);
            operation.insertNewHire(root, newHire);
//To see and verify if the new hire wad added
            operation.levelOrderTraversal(root);
        }
        catch (FileNotFoundException e)
        {
            System.out.println(e);
        }//Close catch
    } //Close main
}//close Client class
