import java.lang.reflect.Array;
import java.util.Arrays;
public class ArrayQueue <T> implements Queue <T>
{
    int front, rear;
    int size;
    T[] a;
    public ArrayQueue()
    {
        a = (T[]) new Object[10];
        front = 0;
        rear = 0;
        size = 0;
    }
    public T dequeue() throws Exception
    {
        if (empty())
            throw new Exception();
        T item = a[front];
        size--;
        front = (front+1)% a.length;
        return item;
    }
    public void enqueue(T item)
    {
        if(rear ==(front+1)%a.length){
            growArray();
        }
        a[rear++]=item;
        rear=rear%a.length;
        size++;
    }
    public boolean empty()
    {
        return (front == rear);
    }
    public void growArray()
    {
        T[] larger = (T[]) new Object[a.length*2];

        for (int index=front; index <= rear; index++)
            larger[index-front] = a[index%a.length];

        a = larger;
        front = 0;
        rear = size;
    }
}
