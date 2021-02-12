
import java.util.Arrays;
import java.util.Scanner;
/******************************************************************************
*  @author Nathanael Benichou
*  https://github.com/Golem97
*  Data Structures 2020 - CS Ariel university
*  Exercise 3 - Sort and search algorithms 
******************************************************************************/
public class ex3 {
    public static void main(String[] args) {
    /* Testing question 1: */
        int a1[]={1,2,3,4,5,6,7,8,9,11,13,22};
        System.out.println(binarySearch(a1,11));

    /* Testing question 2: */
        q2();
    
    /* Testing question 3: */
        String s[] = {"a","b","c","d","e","f","g"};
        String s1[] = {"a","c","d","e","f","m"};
        String s2[] = {"d","e","f","q"};
        System.out.println(Arrays.toString(q3(s, s1, s2)));;

    /* Testing question 4: */
        int a4[] = {-30,-20,-10,0,1,3,4,6,8,9};
        System.out.println(q4(a4));

    /* Testing question 5: */
        int a5[] = {0,1,1,1};
        q5(a5);

    /* Testing question 6: */
        int a6[] = {1,2,4,6,7,8,9,10,11,12};
        System.out.println(binarySearchBetween(a6, 5));
    }
//______________________________________________________
    //Question 1: O(logn)
    private static int binarySearch(int a[], int val) {
        int l = 0;
        int h = a.length-1;
        while(l<=h){
            int m = (l+h)/2;
            if(val==a[m]) return m;
            if(val<a[m])    h=m-1;
            if(a[m]<val)    l=m+1;
        }
        return -1;
    }
//______________________________________________________
    // Question 2:
    public static void q2(){
        Scanner in = new Scanner(System.in);
        System.out.println("Please guess a number 0-1000!");
        int l=0, h=1000;
        int count=0;
        while(l<=h){
            count++;
            int m = (h+l)/2;
            System.out.println("If your number = "+m+" - click 1");
            System.out.println("If your number > "+m+" - click 2");
            System.out.println("If your number < "+m+" - click 3");
            int c = in.nextInt();
            if(c==1){
                System.out.println("Win! number of runs: "+count);
                break;
            }
            else if(c==2)   l=m+1;
            else            h=m-1;
        }
        in.close();
    }
//______________________________________________________
    //Question 3: O(nlogn)
    public static String[] q3(String a[], String b[], String c[]){
        int count=0;
        String t[] = new String[a.length];
        for(int i=0; i<a.length; i++)
            if( binarySearchStrings(b, a[i]) != -1 && 
                binarySearchStrings(c, a[i]) != -1)
                    t[count++] = a[i];
        return Arrays.copyOf(t, count);
    }
    //O(logn)
    private static int binarySearchStrings(String a[], String val) {
        int l = 0;
        int h = a.length-1;
        while(l<=h){
            int m = (l+h)/2;
            if(val.equals(a[m]))         return m;
            if(val.compareTo(a[m])<1)    h=m-1;
            else                         l=m+1;
        }
        return -1;
    }
//______________________________________________________
    //Question 4: O(n)
    public static boolean q4(int a[]){
        int max = Math.max(Math.abs(a[0]), a[a.length-1]);
        int b[][] = new int[2][max+1];
        
        for (int i = 0; i < a.length; i++){
            if(a[i] > 0)    b[0][a[i]]++;
            else            b[1][-a[i]]++;
        }
        if(b[1][0]>1) return true; //if a[] has two zeroes return true
        for (int i = 0; i < b[0].length; i++)
            if(b[0][i]>0 && b[1][i]>0)
                return true;
        return false;
    }
    //Question 4 #Another Option#: O(n)
    public static boolean q4_2(int a[]){
        int i=0, j=a.length-1;
        while(i<j) {
            if(a[i]+a[j] == 0)  return true;
            if(a[i]+a[j] < 0)   i++;
            else                    j--;
        }
        return false;
    }
//______________________________________________________
    //Question 5: O(n)
    public static void q5(int a[]){
        int n = a.length;
        for(int i=0; i<n/2; i++)
            if(a[i] == a[i+n/2]){
                System.out.println(a[i]);
                return;
            }
        System.out.println("not found");              
    }
//______________________________________________________
    //Question 6: O(logn)
    public static int binarySearchBetween(int a[], int val){
        return binarySearchBetween(a, 0, a.length-1, val);
    }
    private static int binarySearchBetween(int[] a, int l, int h, int val) {
        int m = (l+h)/2;
        if(l>h) return -1;
        if((val == a[m]) || (val > a[m-1] && val < a[m])) return m;
        if(val > a[m]) return binarySearchBetween(a, m+1, h, val);
        else return binarySearchBetween(a, l, m-1, val); 
    }
    
}