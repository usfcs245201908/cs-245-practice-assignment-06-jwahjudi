import java.util.Arrays;
public class ArrayStack <T> implements Stack<T>{
    int top;
    T[] a;
    public ArrayStack()
    {
        a =  (T[]) new Object[10];
        top = -1;
    }
    public void push(T item)
    {
        if (top >= a.length-1)
            growArray();
        a[++top] = item;
    }
    public T pop() throws Exception
    {
        if (top < 0)
            throw new Exception();
        T item = a[top--];
        return item;
    }
    public T peek() throws Exception
    {
        if (top < 0)
            throw new Exception();
        T item = a[top];
        return item;
    }
    public boolean empty()
    {
        return (top < 0);
    }

    public void growArray()
    {
        T[] temp = (T[]) (new Object[a.length*2]);

        for (int index=0; index < a.length; index++)
            temp[index] = a[index];
        a =temp;
    }
}
