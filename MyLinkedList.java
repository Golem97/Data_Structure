
/******************************************************************************
*  @author Nathanel Benichou
*  https://github.com/Golem97
*  Data Structures 2020 - CS Ariel university
*  Exercise 8 - sorted Linked List
******************************************************************************/
public class MyLinkedList {
    
    class Node {
        private int key;
        private Node next;
    
        public Node(int key){
            this.key = key;
            this.next = null;
        }

    }

    private Node head, tail;
    private int size = 0;

    public MyLinkedList(){
        head = tail = null;
    }
 
//______________________________________________________
    //Question 1:
    public void add(int key){
        Node newNode = new Node(key);
        if(head == null)
            head = tail = newNode;
        else if(key < head.key){
            newNode.next = head;
            head = newNode;
        }
        else if(key > tail.key){
            tail.next = newNode;
            tail = newNode;
        }
        else{
            for(Node p=head; p.next!=null ; p=p.next){
                if(key<p.next.key){
                    newNode.next = p.next;
                    p.next = newNode;
                    break;
                }
            }
        }
        size++;
    }

//______________________________________________________
    //Question 5:
    public int size(){
        return size(head);
    }
    private int size(Node p) {
        if(p==null) return 0;
        return 1+size(p.next);
    }
    
    public int get(int i) {
        if(i<0 || i>=size) 
            throw new NullPointerException("index out of linked list boundary");
        for(Node p=head; p!=null; p=p.next, i--)
            if(i==0) return p.key;
        return 0;
    }

    public int peekFirst(){
        return head.key;
    }

    public int peekLast(){
        return tail.key;
    }

    public String toString() {
        if(head == null) return "Size: 0";
        String t = "";
        for(Node p = head; p!=null; p=p.next)
            t+= p.key+" -> ";
        return t+"null.   Size:"+size+"   Head: "+head.key+"  Tail: "+tail.key;
    }


}