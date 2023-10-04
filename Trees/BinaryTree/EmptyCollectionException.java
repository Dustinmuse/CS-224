package Trees.BinaryTree;

public class EmptyCollectionException extends RuntimeException
{
    /*
     * Sets up this exception with an appropriate message.
     * @param collection String representing the name of the collection (Family tree)
     */
    public EmptyCollectionException (String collection)
    {
        super ("The " + collection + " is empty.");
    }
}
