import java.util.NoSuchElementException;

/******************************************************************************
 *  @author Nathanael Benichou
 *  https://github.com/Golem97
 *  Data Structures 2020 - CS Ariel university
 *  Exercise 7 - MyQueue implementation
 ******************************************************************************/
public class MyQueue<T> {
    
    private Object a[];
    private int first, last;
    private int size;

    public MyQueue(int capacity){
        a = new Object[capacity];
        size=0;
        first = 0;last = -1;
    }
 
    public T enQueue(T element){
        if(isfull()) return null;
        a[(++last)%a.length] = element;
        size++;
        return element;
    }

    public Object deQueue(){
        if(isEmpty()) return null;
       
       
        first = (first+1)%a.length;
        size--;
        return temp;
    }

    public boolean isEmpty() {
        return size==0;
    }

    public boolean isfull() {
        return size==a.length;
    }

    public int size(){
        return size;
    }

//______________________________________________________

    //Question 1: O(n)
    public String toString(){
        if(size==0) return "The Queue is empty";
        int k = first;
        String s="The queue: [";
        for(int i=0; i<size-1; i++){
            k = (first+i)%a.length;
            s+=a[k]+", ";
        }
        return s+""+a[last]+"]";
    }

    //Question 2: O(n)
    public boolean contains(T elem){
        for(int i=0; i<size ; i++)
            if(elem.equals(a[(first+i)%a.length]))
                return true;
        return false;
    }

    //Question 3: O(1)
    public Object elementAt(int i){
        if(i<0 || i>=size)
            throw new NoSuchElementException("Out of Queue boundary");
        return a[(first+i)%a.length];
    }



}