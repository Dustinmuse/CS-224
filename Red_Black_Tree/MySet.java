package Red_Black_Tree;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class MySet<T> implements Set<T>
{
    private int count; // the current number of elements in the set
    private MyNode<T> contents;
    public MySet()
    {
        count = 0;
        contents = null;
    }
    public MySet(T obj)
    {
        count = 1;
        contents = new MyNode<T>(obj);
    }
    public MySet(Collection<T> c)
    {
        count = 0;
        T[] ary = (T[]) c.toArray();
        contents = null;
        for (int i = 0; i < ary.length; i++)
        {
            add(ary[i]);
        }
    }
    /*
     * Adds the specified element to this set if it is not already present (optional operation).
     */
    public boolean add(T element)
    {
        if (!(contains(element))||count == 0)
        {
            MyNode<T> node = new MyNode<T>(element);
            node.setNext(contents);
            contents = node;
            count++;
            return true;
        }
        return false;
    }
    /*
     * Returns true if this set contains the specified element.
     */
    public boolean contains(Object obj)
    {
        MyNode<T> current = contents;
        T target = (T) obj;
        for (int i = 0; i < count; i++)  //0(n)
        {
            if (current.element.equals(target))
            {
                return true;
            }
            else
            {
                current = current.next;
            }
        } // close for loop
        return false;
    }//close contains method
    /*
     * Returns an iterator over the elements in this set.
     */
    public boolean remove(Object o)
    {
        T target = (T) o;
        MyNode<T> previous = null;
        MyNode<T> current = contents;
        for (int i = 0; i < count; i++) //0(n)
        {
            if (current.element.equals(target))
            {
                previous.setNext(current.next);
                count--;
                return true;
            }
            else
            {
                previous = current;
                current = current.next;
            }
        } // close for loop
        return false;
    }//close remove method
    /*
     * Returns true if this set contains all of the elements of the specified collection.
     */
    public boolean containsAll(Collection<?> c)
    {
        for (Object element : c)
        {
            T target = (T) element;
            if (!contains(target))
                return false;
        }
        return true;
    }
    /*
     * Returns true if this set contains no elements.
     */
    public boolean isEmpty()
    {
        if (count == 0)
            return true;
        else
            return false;
    }
    @Override
    public Iterator<T> iterator()
    {
        LinkedIterator<T> iter = new LinkedIterator<T>(contents);
        return iter;
    }
    /*
     * Adds all of the elements in the specified collection to this set if they're not already
     * present (optional operation).
     */
    public boolean addAll(Collection<? extends T> c)
    {
        for (T element : c)
        {
            add(element);
        }
        return true;
    }
    /*
     * Removes all of the elements from this set (optional operation).
     * The set will be empty after this call returns.
     */
    public void clear()
    {
        contents = null;
        count = 0;
    }
    /*
     * Removes from this set all of its elements that are contained in the specified
     * collection (optional operation).
     */
    public boolean removeAll(Collection<?> c)
    {
        for (Object element : c)
        {
            T target = (T) element;
            remove(target);
        }
        return true;
    }
    /*
     * Retains only the elements in this set that are contained in the specified
     * collection (optional operation).
     */
    public boolean retainAll(Collection<?> c)
    {
        MyNode<T> temp = contents;
        for (int i = 0; i < count; i++)
        {
            if (!c.contains(temp.getElement()))
            {
                remove(temp.getElement());
            }
            temp = temp.next;
        }
        return true;
    }
    /*
     * Returns the number of elements in this set (its cardinality).
     */
    public int size()
    {
        return count;
    }
    /*
     * Returns an array containing all of the elements in this set.
     */
    public Object[] toArray()
    {
        Object[] result = new Object[count];
        MyNode <T>temp = contents;
        for (int i = 0; i < count; i++)
        {
            result[i] = temp.getElement();
            temp = temp.next;
        }
        return result;
    }
    @SuppressWarnings({ "unchecked", "hiding" })
    /*
     *Returns an array containing all of the elements in this set;
     *the runtime type of the returned array is that of the specified array.
     *
     */
    public <T> T[] toArray(T[] a)
    {
        T[] result = (T[]) new Object[count];
        MyNode<T> temp = (MyNode<T>) contents;
        for (int i = 0; i < count; i++)
        {
            result[i] = (T) temp.getElement();
            temp = temp.next;
        }
        return result;
    }
    /*
     * Returns a string representation of the object.
     */
    public String toString()
    {
        String result = "";
        MyNode <T>temp = contents;
        for (int i = 0; i < count; i++)
        {
            result += temp.getElement() + " ";
            temp = temp.next;
        }
        return result;
    }
}
