
import java.util.Arrays;

/******************************************************************************
 *  @author Nathanael Benichou
 *  https://github.com/Golem97
 *  Data Structures 2020 - CS Ariel university
 *  Exercise 1 - Sorts algorithms
 ******************************************************************************/
public class ex1 {

    public static void main(String[] args) {
    /* Testing question 1: */
        int a1[] = {2,5,3,8,6,4,2,66,4,33,12};
        System.out.println(q1(a1,6));

    /* Testing question 2: */
        String words[] = {"be","be","not","or","to","to","to"};
        q2(words);

    /* Testing question 3: */
        int a3[] = {1,4,9,17,23,-1,14};
        q3(a3);

    /* Testing question 4: */
        int a4[] = {1,4,9,17,23,-1,14};
        q4(a4);

    /*Testing question 5: */
        int a5[] = {98,2,3,1,0,0,0,3,98,98,2,2,2,0,0,0,2};
        q5(a5);
        System.out.println(Arrays.toString(a5));

    /* Testing question 6: */
        int a6[] = {-2,-2,0,1,2,5,6,7,8,20};
        System.out.println(q6(a6));

    }
//______________________________________________________
    //O(2n+k)=O(n+k)
    private static int q1(int[] a, int n) {
        int max=a[0];
        for (int i = 0; i < a.length; i++)       //O(n)
            if(a[i]>max) max=a[i];

        int t[] = new int[max+1];
        for (int i = 0; i < a.length; i++)       //O(n)
            t[a[i]]++;

        for (int i = 0; i < t.length; i++) {     //O(k) k=max
            if(t[i]>0) n--;
            if(n==0) return i;
        }
        return -1111;

    }
//______________________________________________________
	//O(n)
    private static void q2(String[] a) {
        int count=1;
        for (int i = 1; i < a.length; i++) {    //O(n)
            String t = a[i-1];                  //O(1)
            if(!a[i].equals(t)){                //O(1)
                System.out.print(count+" ");    //O(1)
                count=0;                        //O(1)
            }
            count++;                            //O(1)
        }
        System.out.println(count);              //O(1)
    }
//______________________________________________________
    //O(n^2)
    public static void q3(int a[]){
        int a1=a[0], a2=a[1];
        int minAbs= Math.abs(a[1]-a[0]);
        for(int i=0; i<a.length-1; i++){            
            for(int j=i+1; j<a.length; j++){        
                int correntAbs=Math.abs(a[j]-a[i]);
                if(correntAbs<minAbs){
                    minAbs=correntAbs;
                    a1=a[j];
                    a2=a[i];
                }
            }
        }
        System.out.println("a1= "+a1+" a2= "+a2);
    }
//______________________________________________________    
    //O(n)
    private static void q4(int[] a) {
        int min=a[0], max=a[0];
        for(int i=0; i<a.length; i++){
            if(a[i]<min) min=a[i];
            if(a[i]>max) max=a[i];
        }
        System.out.println("a1= "+min+" a2= "+max);
	}
//______________________________________________________
    //T(n)=n+n=2n=O(n)
    public static void q5(int[] a){
        int t[] = new int[101];
        for(int i=0; i<a.length; i++)
            t[a[i]]++;
        for(int i=0,k=0; i<t.length; i++)
            for(int j=0; j<t[i]; j++)
                a[k++] = i;
    }
//______________________________________________________
    //Question 6: O(n)
    public static boolean q6(int a[]){
        int i=0, j=a.length-1;
        while(i<j) {
            if(a[i]+a[j] == 0)  return true;
            if(a[i]+a[j] < 0)   i++;
            else                j--;
        }
        return false;
    }
    
}