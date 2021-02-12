
import java.util.Stack;
/******************************************************************************
*  @author Nathanael Benichou
*  https://github.com/Golem97
*  Data Structures 2020 - CS Ariel university
*  Exercise 6 - Stack
******************************************************************************/
public class ex6 {
    public static void main(String[] args) {
    /* Testing question 1: */
        System.out.println(q1("{[2*(6+7)]+4}*(3+2)"));
        System.out.println(q1("{[2*(6+7)]+4})*(3+2)"));
        System.out.println(q1("{[2*(6+7)]+4)*(3+2)"));

    /* Testing question 2: */   
        System.out.println(q2("2435.5342"));
        System.out.println(q2("2435.534"));
        System.out.println(q2("1435.5341"));
        
    /* Testing question 3: */
        System.out.println(q3(new int[]{2,8,6,3,7,4,5,1}));

    /* Testing question 4: */
        TwoStack<Object> ts = new TwoStack<>(10);
        ts.printBoth();
        ts.addStack1("a");
        ts.addStack1("b");
        ts.addStack1("c");
        ts.addStack1("d");
        ts.addStack1("e");
        ts.printBoth();
        ts.addStack2(1);
        ts.addStack2(2);
        ts.addStack2(3);
        ts.addStack2(4);
        ts.addStack2(5);
        ts.addStack2(6);
        ts.printBoth();
        ts.addStack2(7);
        ts.popStack2();
        ts.popStack2();
        ts.printBoth();
        ts.printArray();
        System.out.println(ts.peekStack1()+"  "+ts.peekStack2());
    }
//______________________________________________________
    //Question 1
    private static boolean q1(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='(' || c=='{' || c=='[')
                stack.add(c);
            
            if(c==')' || c=='}' || c==']')
                if(stack.isEmpty() || Math.abs(c-stack.pop()) > 2)
                    return false;
        }
        return stack.isEmpty();
    }
//______________________________________________________
    //Question 2
    private static boolean q2(String s) {
        Stack<Character> stack = new Stack<>();
        boolean dot = false;
        for (int i = 0; i < s.length() ; i++) {
            char c = s.charAt(i);
            if(c == '.') 
                dot = true;
            else if(!dot) 
                stack.add(c);
            else if(stack.isEmpty() || c != stack.pop()) 
                return false;     
        }
        return stack.isEmpty();
    }
//______________________________________________________
    //Question 3
    public static Stack<Integer> q3(int a[]){
        Stack<Integer> s = new Stack<>();
        Stack<Integer> t = new Stack<>();
        for (int i = 0; i < a.length; i++) {
            while(!s.isEmpty() && s.peek()>a[i])
                t.add(s.pop());
            s.add(a[i]);
            while(!t.isEmpty())
                s.add(t.pop());
        }
        return s;
    }
//______________________________________________________
    //Question 4: TwoStack.java





}