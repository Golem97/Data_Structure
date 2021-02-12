
/******************************************************************************
*  @author Nathanael Benichou
*  https://github.com/Golem97
*  Data Structures 2020 - CS Ariel university
*  Exercise 2 - recursion
******************************************************************************/
public class ex2 {
    public static void main(String[] args) {
        System.out.println(sum(2, 7));
        System.out.println(substruct(9, 7));
        System.out.println(multiply(9, 7));
        System.out.println(division(14, 7));
        System.out.println(remainder(14, 8));
        System.out.println(q2(3));
        System.out.println(q3(12345));
        System.out.println(q4(12345));
        System.out.println(q5("abcde"));
    }
//______________________________________________________
    public static int sum(int a, int b){
        if(b==0) return a;
        return sum(a, b-1)+1;
    }
    public static int substruct(int a, int b){
        if(b==0) return a;
        return substruct(a, b-1)-1;
    }
    public static int multiply(int a, int b){
        if(b==1) return a;
        return multiply(a, b-1)+a;
    }
    public static int division(int a, int b){
        if(a<b) return 0;
            return division(a-b, b)+1;
    }
    public static int remainder(int a, int b){
        if(a<b) return a;
            return remainder(a-b, b);
    }
//______________________________________________________
    public static int q2(int n){
        if(n==0) return 1;
        return q2(n-1)+q2(n-1);
    }
//______________________________________________________
    public static int q3(int n){
        int t=0;
        while(n>0){
            t*=10;
            t+=n%10;
            n/=10;
        }
        return t;
    }
//______________________________________________________
    public static int q4(int n){
        if(n==0) return 0;
        int length = (int)Math.log10(n);
        return n%10*(int)Math.pow(10,length)+q4(n/10);
    }
//______________________________________________________
    public static String q5(String s){
        if(s.length()==1) return ""+s.charAt(0);
        return q5(s.substring(1)) + s.charAt(0);
    }

}