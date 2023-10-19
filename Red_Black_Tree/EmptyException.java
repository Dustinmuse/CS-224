package Red_Black_Tree;

public class EmptyException extends RuntimeException
{
    public EmptyException(String collection)
    {
        super ("The "+ collection + " is empty");
    }
}
