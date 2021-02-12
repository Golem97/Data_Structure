
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
/******************************************************************************
*  @author Nathanael Benichou
*  https://github.com/Golem97
*  Data Structures 2020- CS Ariel university
*  Exercise 7 - Queue
******************************************************************************/
public class ex7 {
    public static void main(String[] args) {
    /* Testing questions 1-3: */
        // MyQueue<Integer> q = new MyQueue<>(5);
        // System.out.println(q.contains(1));
        // System.out.println(q);
        // System.out.println("enQueue: "+q.enQueue(1));
        // System.out.println(q);
        // System.out.println(q.contains(1));
        // System.out.println("enQueue: "+q.enQueue(2));
        // System.out.println(q);
        // System.out.println("enQueue: "+q.enQueue(3));
        // System.out.println(q);
        // System.out.println("enQueue: "+q.enQueue(4));
        // System.out.println(q);
        // System.out.println("enQueue: "+q.enQueue(5));
        // System.out.println(q);
        // System.out.println("enQueue: "+q.enQueue(6));
        // System.out.println(q);
        // System.out.println(q.contains(1));
        // System.out.println(q.contains(2));
        // System.out.println(q.contains(2));
        // System.out.println(q.contains(4));
        // System.out.println(q.contains(5));
        // System.out.println(q.contains(6));
        // System.out.println("deQueue: "+q.deQueue());
        // System.out.println(q);
        // System.out.println("deQueue: "+q.deQueue());
        // System.out.println(q);
        // System.out.println("deQueue: "+q.deQueue());
        // System.out.println(q);
        // System.out.println(q.contains(1));
        // System.out.println("deQueue: "+q.deQueue());
        // System.out.println(q);
        // System.out.println("deQueue: "+q.deQueue());
        // System.out.println(q);
        // System.out.println("deQueue: "+q.deQueue());
        // System.out.println(q);
        // for(int i=0; i<10; i++)
        //     System.out.print(q.elementAt(i)+" ");

    /* Testing question 4:*/
        // String s1 = "abcdedcba"; 
        // String s2 = "abcddcba";
        // String s3 = "abdedcba";
        // String s4 = "";
        // System.out.println(palindrom(s1)); //true
        // System.out.println(palindrom(s2)); //true
        // System.out.println(palindrom(s3)); //false
        // System.out.println(palindrom(s4)); //tren
    /* Testing question 5: */
        // Queue<Integer> q = sortedQueue(20);
        // System.out.println(q);

    /* Testing question 6: */
        TwoQueue<Object> tq = new TwoQueue<>(10);
        tq.enQueue1(1);
        tq.enQueue1(2);
        tq.enQueue1(3);
        tq.enQueue1(4);
        tq.enQueue1(5);
        tq.enQueue2("a");
        tq.enQueue2("b");
        tq.enQueue2("c");
        tq.enQueue2("d");
        tq.enQueue2("e");
        int size1 = tq.size1();
        for(int i=0; i<size1; i++)
            System.out.println(tq.deQueue1());
        tq.printQueue1();
        tq.printQueue2();
        tq.printArray();

    }
//______________________________________________________
    //Questions 1,2,3: see MyQueue.java file
//______________________________________________________
    //Question 4: O(n)
    public static boolean palindrom(String str){
        Stack<Character> s = new Stack<>();
        Queue<Character> q = new LinkedList<>();
        for(int i=0; i<str.length(); i++){
            s.add(str.charAt(i));
            q.add(str.charAt(i));   
        }
        while(!s.isEmpty())
            if(!s.pop().equals(q.remove())) return false;
        return true;
    }
//______________________________________________________
    //Question 5:
    public static Queue<Integer> sortedQueue(int size){
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<size; i++){
            int r = (int)(Math.random()*100);
            while(q.contains(r)) r=(int)(Math.random()*100);
            
            q.add(r);
            while(q.element()<r) q.add(q.remove());
            q.add(r);
            while(q.element()>r) q.add(q.remove());
            q.remove();
        }
        return q;
    }
//______________________________________________________
    //Question 6: see TwoQueue.java file

}