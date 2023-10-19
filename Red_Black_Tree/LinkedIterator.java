package Red_Black_Tree;

import java.util.Iterator;

public class LinkedIterator<T> implements Iterator<T>
{
    private MyNode<T> current; // the current position
    private MyNode<T> head;
    //Sets up this iterator using the specified items.
    public LinkedIterator(MyNode<T> node)
    {
        current = node;
        head=node;
    }
    //Returns true if this iterator has at least one more element to deliver in the iteration.
    public boolean hasNext()
    {
        return (current != null);
    }
    /**
     * Returns the next element in the iteration. If there are no
     * more elements in this iteration, a NoSuchElementException is
     * thrown.
     */
    public T next()
    {
        if (!hasNext())
            throw new EmptyException(" Linked ");
        T result = current.getElement();
        current = current.getNext();
        return result;
    }
    //The remove operation is not used this time. But, you must have this due to ADT requirement.
    public void remove()
    {
        int i;
        if (!hasNext())
            throw new EmptyException(" Linked ");
        MyNode<T> cur,prio=null;
        prio=cur=head;
        while(cur!=current){
            prio=cur;
            cur=cur.getNext();
        }
        prio.setNext(cur.getNext());
        throw new UnsuportedOperationException ();
    }
}
