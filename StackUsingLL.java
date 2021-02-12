
import java.util.LinkedList;
/******************************************************************************
*  @author Nathanael Benichou
*  https://github.com/Golem97
*  Data Structures 2020 - CS Ariel university
*  Exercise 8 - implementation of Stack using LinkedList 
******************************************************************************/
public class StackUsingLL<T> {
    private LinkedList<T> stack;

    public StackUsingLL(){
        stack = new LinkedList<>();
    }
    public boolean push(T val){
        return stack.offerFirst(val);
    }
    public T pop(){
        return stack.removeFirst();
    }
    public T front(){
        return stack.peekFirst();
    } 
    public T tail(){
        return stack.peekLast();
    }
    public int size(){
        return stack.size();
    }
    public void empty(){
        stack.clear();
    }
}