
import java.util.LinkedList;

/******************************************************************************
*  @author Nathanael Benichou
*  https://github.com/Golem97
*  Data Structures 2020 - CS Ariel university
*  Exercise 8 - Linked List 
******************************************************************************/
public class ex8 {
    public static void main(String[] args) {

/* Testing question 4: */
        GenericLinkedList<Integer> class1 = new GenericLinkedList<>();
        GenericLinkedList<Integer> class2 = new GenericLinkedList<>();
        class1.add(59);
        class1.add(83);
        class1.add(92);
        class1.add(26);
        class1.add(94);

        class2.add(34);
        class2.add(92);
        class2.add(100);
        class2.add(99);
        class2.add(76);
        MyLinkedList sortedGrades = q4(class1,class2);
        System.out.println(sortedGrades.toString());
        
    /* Testing question 5: */
        System.out.println(sortedGrades.size());

    /* Testing question 6: */
        LinkedList<Integer> t = new LinkedList<>();
        t.add(1);
        t.add(2);
        t.add(3);
        t.add(4);
        t.add(5);
        System.out.println("Before reverse: "+t.toString());
        q7(t);
        System.out.println("After reverse: "+t.toString());
        
    /* Testing question 8: */
        GenericLinkedList<String> l8 = new GenericLinkedList<>();
        l8.add("a");
        l8.add("b");
        l8.add("c");
        l8.add("b");
        l8.add("a");
        System.out.println(q8(l8));

    /* Testing question 9: */
        MyLinkedList a = new MyLinkedList();
        a.add(0);
        a.add(7);
        a.add(9);
        a.add(3);
        a.add(4);
        GenericLinkedList<Integer> b = new GenericLinkedList<>();
        b.add(6);
        b.add(3);
        b.add(7);
        b.add(12);
        b.add(1);
        System.out.println(q9_1(a,b));
        System.out.println(q9_2(a,b));

    }

//_____________________________________________________________________________
    //Question 4: 
    public static MyLinkedList q4(GenericLinkedList<Integer> c1, GenericLinkedList<Integer> c2) {
        MyLinkedList sorted = new MyLinkedList();
        for(int i=0; i<c1.size(); i++){
            int t = c1.get(i);
            if(c2.search(t) == null)
                sorted.add(t);
        }
        for(int i=0; i<c2.size(); i++){
            int t = c2.get(i);
            if(c1.search(t) == null)
                sorted.add(t);
        }
        return sorted;
    }
//_____________________________________________________________________________
    //Question 6:   O(n)
    public static <T> void q6(GenericLinkedList<T> l){
        MyQueue<T> q = new MyQueue<>(l.size());
        while(!l.isEmpty())
            q.enQueue(l.removeLast());
        while(!q.isEmpty())
            l.add((T)q.deQueue());
    }
//_____________________________________________________________________________
    //Question 7:   O(n)
    public static <T> void q7(LinkedList<T> l){
        LinkedList<T> t = new LinkedList<>();
        q7(l,t);
        l.addAll(t);
    }
    private static <T> void q7(LinkedList<T> l, LinkedList<T> t){
        if(l.isEmpty()) return;
        t.add(l.removeLast());
        q7(l, t);
    }
//_____________________________________________________________________________
//Question 8:   O(n)
    public static <T> boolean q8(GenericLinkedList<T> t){
        int h = t.size()-1, l=0;
        while(l<h){
            if(t.get(l++) != t.get(h--))
                return false;
        }
        return true;
    }
//_____________________________________________________________________________
//Question 9: part 1
    public static GenericLinkedList<Integer> q9_1(MyLinkedList a,GenericLinkedList<Integer> b){
        GenericLinkedList<Integer> c = new GenericLinkedList<>();
        for(int i=0; i<a.size(); i++){
            int t = a.get(i);
            for(int j=0; j<b.size(); j++)
                if(t == b.get(j))
                    c.add(t);
        }
        return c;
    }
//Question 9: part 2 (Better than part 1)
    public static GenericLinkedList<Integer> q9_2(MyLinkedList a,GenericLinkedList<Integer> b){
        GenericLinkedList<Integer> c = new GenericLinkedList<>();
        for(int i=0; i<b.size(); i++){
            int t = b.get(i);
            if(t>=a.peekFirst() || t<=a.peekLast()){
                for(int j=0; j<a.size(); j++)
                    if(t == a.get(j))
                        c.add(t);         
            }
        }
        return c;
    }
}