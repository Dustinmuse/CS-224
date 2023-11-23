package Project_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestCompanies_SelectionSort
{
    //since it is a testing class you need a main to run the other classes
    public static void main(String[] args)
    {
        //read data from file
        String outputDirectory = "./outputs/";
        File directory = new File(outputDirectory);
        if(!directory.exists())
        {
            directory.mkdirs();
        }//close if

        List<String> companies = new ArrayList<>();
        companies.add("Company E:../company_e.csv");
        String inputFilePath = "C:\\Users\\DJmus\\Downloads\\company_e.csv";
        List<Employee> original_employees = new ArrayList<>();
        try
        {
            Scanner sc = new Scanner(new File(inputFilePath));
            String header = sc.nextLine();
            while(sc.hasNext())
            {
                String ss = sc.nextLine();
                String [] s = ss.split(",");
                Employee e = new Employee(Integer.parseInt(s[0]), s[1], s[2], Integer.parseInt(s[3])); // 0 = id, 1 = first name, 2 = last name, 3 = age
                original_employees.add(e); //adding each employee to a list
            }//close while
            sc.close();
            SortingAlgorithm algos = new SortingAlgorithm();
            long start = System.nanoTime();
            algos.selection_sort(original_employees);
            long end = System.nanoTime();
            System.out.println("Running time: " + (double)(end - start)/1_000_000 + "ms");
            /*
            for (Employee e: original_employees)
            {
                System.out.println(e.toString());
            }
             */
        }//close try
        catch(FileNotFoundException e)
        {
            System.out.println(e);
        }//close catch
        String fileName = "company_e_selection.csv";
        String outputDir = "./outputs/";
        File Dir = new File(outputDir);
        if (!Dir.exists())
        {
            Dir.mkdirs();
        }//ending if
        String outputPath = outputDir + "company_e";
        writeToFile(outputPath, fileName, original_employees);
    }//close main method
    public static void writeToFile(String outputPath, String filename, List<Employee> employees)
    {
        File dir = new File(outputPath);
        if (!dir.exists())
        {
            dir.mkdir(); //makes directory
        }//close if
        try (FileWriter writer = new FileWriter(outputPath + "/" + filename))
        {
            String s = "id, first_name, last_name\n";
            writer.write(s);
            for (Employee e : employees)
            {
                String line = Integer.toString(e.getId()) + "," + e.getFirst_Name() + "," + e.getLast_Name() + "," + Integer.toString(e.getAge()) + "\n";
                writer.write(line);
            }//close for loop
        }//close try
        catch(IOException e)
        {
            System.out.println(e);
        }
    }//close writeToFile method
}
