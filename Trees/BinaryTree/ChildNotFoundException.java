package Trees.BinaryTree;

public class ChildNotFoundException extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    public <T> ChildNotFoundException()  //<t> means it could be any type of variable (string, int, double, etc.) (generic)
    {
        super("Must use: \"left\" or \"right\" as childPosition");
    }
}
