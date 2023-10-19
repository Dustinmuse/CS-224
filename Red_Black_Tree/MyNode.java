package Red_Black_Tree;

public class MyNode<T>
{
    protected T element;
    protected MyNode<T> next;
    MyNode(T obj)
    {
        element = obj;
        next = null;
    }
    public void setNext(MyNode<T> obj)
    {
        next = obj;
    }
    public T getElement()
    {
        return element;
    }
    public MyNode<T> getNext()
    {
        return next;
    }
}
