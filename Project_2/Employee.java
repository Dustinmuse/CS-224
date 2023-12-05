package Project_2;

public class Employee
{
    private int id;
    private String first_name;
    private String last_name;
    private int age;

    public Employee(int id, String first_name, String last_name, int age)
    {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
    }

    public int getId()
    {
        return id;
    }

    public String getFirst_name()
    {
        return first_name;
    }

    public String getLast_name()
    {
        return last_name;
    }

    public int getAge()
    {
        return age;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setFirst_name(String first_name)
    {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name)
    {
        this.last_name = last_name;
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
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", age=" + age +
                '}';
    }
}//close Employee class
