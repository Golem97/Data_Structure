
import java.util.Arrays;

/******************************************************************************
 *  @author Nathanael Benichou
 *  https://github.com/Golem97
 *  Data Structures 2020 - CS Ariel university 
 *  Exercise 7 - TwoQueue implementation
 ******************************************************************************/
public class TwoQueue<T> {
    private Object[] a;
    private int i,j;

    public TwoQueue(int capacity){      //O(1)
        a = new Object[capacity];
        i = -1;
        j = a.length;
    }

    public boolean enQueue1(T val){     //O(1)
        if((i+1)==j) return false;
        a[++i] = val;
        return true;
    }
    public boolean enQueue2(T val){     //O(1)
        if((j-1)==i) return false;
        a[--j] = val;
        return true;
    }
    public Object deQueue1(){           //O(n1)
        if(size1()==0) return null;
        Object temp = a[0];
        for(int k=0; k<i; k++) 
            a[k] = a[k+1];
        i--;
        return temp;
    }
    public Object deQueue2(){       //O(n2)
        if(size2()==0) return null;
        Object temp = a[a.length-1];
        for(int k=a.length-1; k>j; k--)
            a[k] = a[k-1];
        j++;
        return temp;
    }
    public int size1(){                 //O(1)
        return i+1;
    }
    public int size2(){                 //O(1)
        return a.length-j;
    }


/* --------Printing methods for testing------- */
    public void printArray(){
        System.out.println(Arrays.toString(a)+"\ti: "+i+" j: "+j);
    }

    public void printQueue1(){
        if(size1()==0){
            System.out.println("Queue 1: []\tsize: 0");
            return;
        }
        System.out.print("Queue 1: [");
        for (int k=0; k<i ; k++)
            System.out.print(a[k]+",");
        System.out.println(a[i]+"]\tsize: "+size1());
    }
    public void printQueue2(){
        if(size2()==0){
            System.out.println("Queue 2: []\tsize: 0");
            return;
        }
        System.out.print("Queue 2: [");
        for (int k=a.length-1; k>j ; k--)
            System.out.print(a[k]+",");
        System.out.println(a[j]+"]\tsize: "+size2());
    }
}