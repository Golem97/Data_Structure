
import java.util.Arrays;
/******************************************************************************
*  @author Nathanael Benichou
*  https://github.com/Golem97
*  Data Structures 2020 - CS Ariel university
*  Exercise 6 - TwoStack implementation
******************************************************************************/

public class TwoStack<T>{
    private Object[] a;
    private int i,j;

    public TwoStack(int capacity){
        a = new Object[capacity];
        i = -1;
        j = a.length;
    }

    public boolean addStack1(T val){
        if((i+1)==j) return false;
        a[++i] = val;
        return true;
    }
    public boolean addStack2(T val){
        if((j-1)==i) return false;
        a[--j] = val;
        return true;
    }
    public Object popStack1(){
        if(i<0) return null;
        return a[i--];
    }
    public Object popStack2(){
        if(j>=a.length) return null;
        return a[j++];
    }
    public Object peekStack1(){
        if(i<0) return null;
        else return a[i];
    }
    public Object peekStack2(){
        if(j>=a.length) return null;
        else return a[j];
    }
    public int sizeStack1(){
        return i+1;
    }
    public int sizeStack2(){
        return a.length-j;
    }

    /* --------Printing methods for testing------- */

    public void printStack1(){
        if(sizeStack1()==0){
            System.out.print("Stack 1: []\tsize: 0");
            return;
        }
        System.out.print("Stack 1: [");
        for (int k = 0; k < i; k++)
            System.out.print(a[k]+",");
        System.out.print(a[i]+"]\tsize: "+sizeStack1());
    }
    public void printStack2(){
        if(sizeStack2()==0){
            System.out.print("Stack 2: []\tsize: 0");
            return;
        }
        System.out.print("Stack 2: [");
        for (int k = a.length-1; k > j; k--)
            System.out.print(a[k]+",");
        System.out.print(a[j]+"]\tsize: "+sizeStack2());
    }
    public void printBoth(){
        printStack1();
        System.out.println();
        printStack2();
        System.out.println("\n");
    }
    public void printArray(){
        System.out.println(Arrays.toString(a)+"\ti: "+i+" j: "+j);
    }
}