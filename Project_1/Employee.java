package Project_1;

public class Employee
{
    //Instance variables
    private int id;
    private String first_Name;
    private String last_Name;
    private int age;

    //Constructor
    public Employee(int id, String first_Name, String last_Name, int age)
    {
        this.id = id;
        this.first_Name = first_Name;
        this.last_Name = last_Name;
        this.age = age;
    }//Close constructor

    //Methods
    public int getId()
    {
        return this.id;
    }
    public String getFirst_Name()
    {
        return this.first_Name;
    }
    public String getLast_Name()
    {
        return this.last_Name;
    }
    public int getAge()
    {
        return this.age;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setFirst_Name(String first_Name)
    {
        this.first_Name = first_Name;
    }
    public void setLast_Name(String last_Name)
    {
        this.last_Name = last_Name;
    }
    public void setAge(int age)
    {
        this.age = age;
    }

    @Override
    public String toString()
    {
        return "Employee{" +
                "id=" + id +
                ", first_Name='" + first_Name + '\'' +
                ", last_Name='" + last_Name + '\'' +
                ", age=" + age +
                '}';
    }
}//Close class
