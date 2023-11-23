package Project_1;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class SortingAlgorithm //domain class
{
    //private since it won't be needed to use outside of class
    private void swap(List<Employee> employees, int i, int j)
    {
        Employee temp = employees.get(i);
        employees.set(i, employees.get(j));
        employees.set(j, temp);
    }//close swap method

    //don't use main method
    //just sorting nothing returning
    //public, so it can be used in the tests/other classes

    //method: 1
    public void bubble_sort(List<Employee> employees) //passing a signature
    {
        for (int i = 0; i < employees.size(); i++) //gos through the whole list of ages
        {
            for (int j = employees.size() - 1; j > i; --j) //starting from the end working to the front swapping them if needed
            {
                if(employees.get(j).getAge() < employees.get(j - 1).getAge())
                {
                    swap(employees, j, j - 1);
                }
            }
        }
    }//close bubble_sort method

    //Method: 2 (find smallest and put it in the front)
    public void selection_sort(List<Employee> employees)
    {
        for (int i = 0; i < employees.size(); ++i) //gos through the whole list of ages
        {
            Employee min = employees.get(i);
            int pos = i;
            for (int j = i + 1; j < employees.size(); ++j) //starting from the end working to the front swapping them if needed
            {
                if(employees.get(j).getAge() < min.getAge())
                {
                    min = employees.get(j);
                    pos = j;
                }//close if
            }//close inner loop
            swap(employees, i, pos);
        }//close outer loop
    }//close selection_sort method

    //Method: 3
    public void insertion_sort(List<Employee> employees)
    {
        for (int i = 1; i < employees.size(); ++i)
        {
            for (int j = i; j > 0; --j)
            {
                if (employees.get(j).getAge() >= employees.get(j - 1).getAge())
                {
                    break;
                }//close if
                swap(employees, j, j - 1);
            }//close inner loop
        }//close outer loop
    }//close insertion_sort method

    //Method: 4
    public void merge_sort(List<Employee> employees)
    {
        List<Employee> res = merge_sort(employees, 0, employees.size() - 1);
        for (int i = 0; i < employees.size(); ++i)
        {
            employees.set(i, res.get(i));
        }//close loop
    }//close merge_sort method
    private List<Employee> merge_sort(List<Employee> employees, int lo, int hi)
    {
        if(lo == hi)
        {
            return Arrays.asList(employees.get(lo));
        }//close if

        int mid = (hi + lo) / 2;
        List<Employee> left = merge_sort(employees, lo, mid);
        List<Employee> right = merge_sort(employees, mid + 1, hi);

        return merge_sort_merge(left, right);
    }//close merge_sort sub method

    private List<Employee> merge_sort_merge(List<Employee> left, List<Employee> right)
    {
        List<Employee> res = new ArrayList<>();

        int i = 0, j = 0;
        while (i < left.size() && j < right.size())
        {
            if (left.get(i).getAge() <= right.get(j).getAge())
            {
                res.add(left.get(i++));
            }
            else
            {
                res.add(right.get(j++));
            }
        }

        // Add remaining elements from left and right lists
        res.addAll(left.subList(i, left.size()));
        res.addAll(right.subList(j, right.size()));

        return res;
    }//close merge_sort_merge

    //Method: 5
    public void quick_sort(List<Employee> employees)
    {
        quick_sort(employees, 0, employees.size() - 1);
    }//close quick_sort method
    private void quick_sort(List<Employee> employees, int lo, int hi)
    {
        if (lo >= hi)
        {
            return;
        }
        int pos = partition(employees, lo, hi);
        quick_sort(employees, lo, pos - 1);
        quick_sort(employees, pos + 1, hi);
    }//close quick_sort sub method
    private int partition(List<Employee> employees, int lo, int hi)
    {
        Employee p = employees.get(hi);
        int i = lo - 1;
        for (int j = lo; j < hi; ++j)
        {
            if (employees.get(j).getAge() < p.getAge())
            {
                i++;
                swap(employees, i, j);
            }//close if
        }//close inner loop
        swap(employees, i + 1, hi);
        return i + 1;
    }//close partition method
}//close class
