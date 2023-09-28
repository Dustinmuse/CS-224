package Recursion;

public class PowerInterviewPractice
{
    public static void main(String[] args)
    {
        System.out.println(power(2, 8));
    }//close main method

    /*
    private static double power(int a, int b) // time complexity: Big O(n^2)
    {
        //base case:
        if(b == 0)
        {
            return 1;
        }
        else
        {
            return a * power(a, b - 1);
        }
    }//close power method

     */
    private static double power(int a, int b) // time complexity: Big O(b)
    {
        //base case:
        if(b == 0)
        {
            return 1;
        }
        double half_result = power(a, b / 2);
        if(b % 2 == 0)
        {
            return half_result * half_result;
        }
        else
        {
            return half_result * half_result * a;
        }
    }//close power method
}//close class