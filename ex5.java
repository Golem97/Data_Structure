
import java.util.Arrays;

/******************************************************************************
 *  @author Nathanael Benichou
 *  https://github.com/Golem97
 *  Data Structures 2020 - CS Ariel university
 *  Exercise 5 - QuickSort, Partition
 ******************************************************************************/
public class ex5 {
    public static void main(String[] args) {
    /* Testing question 1: */
        int a[] = {0,1,2,3,4,5,6,7,8,9};
        int a1[] = {-3,6,12,4,-7,45,-6,-3,-1,2,3,10,1,2,3,4,5};
        q1(a);
        q1(a1);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(a1));

    /* Testing question 2: */
        // int a2[] = {1,6,1,6,6,1,6,1,1,6,6};
        // q2_2(a2);
        // System.out.println(Arrays.toString(a2));

    /* Testing question 3: */
        // Interval i1 = new Interval(7, 8);
        // Interval i2 = new Interval(1, 2);
        // Interval i3 = new Interval(2, 4.5);
        // Interval i4 = new Interval(6, 9);
        // Interval intervals[] = {i1,i2,i3,i4};
        // System.out.println(q3(intervals));
    
    /* Testing question 4: */
        // int a4[] = {3,5,6,7,8,9,12,13,14,15};
        // System.out.println(q4(a4));

    /* Testing question 5: */
        // int a5[] = {1,2,5,33,55,63,42,65,234,65,124,113,51,241,7,2,34,1};
        // System.out.println(median(a5));

    /* Testing question 6: */
        // String a6[] = {"to","be","or","not","to","be"};
        // dedup(a6);
    }
//______________________________________________________
    //Question 1: O(n)
    public static void q1(int a[]){
        int l=0, h=a.length-1;
        while(l<h) {
            int low = Math.abs(a[l]%2);
            int high = Math.abs(a[h]%2);
            if      (low==0 && high==0)  l++;
            else if (low==1 && high==1)  h--;
            else if (low==1 && high==0)  swap(a,l++,h--);
            else { l++; h--; }
        }
    }
    private static void swap(int[] a, int l, int h) {
        int t = a[l];
        a[l] = a[h];
        a[h] = t;
    }
// ______________________________________________________
    //Question 2: O(n)
    public static void q2(int a[]){
        int l=0, h=a.length-1, max=a[0], min=a[0];
        for(int i=0; i<a.length; i++){
            if(a[i]>max) max = a[i];
            if(a[i]<min) min = a[i];
        }
        while(l<h) {
            if      (a[l]>a[h])                 swap(a,l++,h--);
            else if (a[l]==min && a[h]==min)    l++;
            else if (a[l]==max && a[h]==max)    h--;
            else                                { l++; h--; }
        }
    }
    //Question 2: O(n) #Another option#
    public static void q2_2(int a[]){
        int max=a[0], min=a[0], countMax=0, countMin=0;
        for(int i=0; i<a.length; i++){
            if(a[i]>max) max = a[i];
            if(a[i]<min) min = a[i]; 
        }
        for (int element : a) {
            if(element==max) countMax++;
            if(element==min) countMin++;
        }
        int k=0;
        while(countMin-->0) a[k++]=min;
        while(countMax-->0) a[k++]=max;
        
 
    }
//______________________________________________________
    //Question 3: O(nlogn)
    public static double q3(Interval a[]){
        quickSort_Intervals(a); //implementation below
        Interval current = new Interval(a[0].l,a[0].r);
        double total=0;
        for (int i=1; i<a.length ; i++){ 
            if (a[i].l >= current.r) { 
                total += current.r-current.l;
                current = new Interval(a[i]);
            } 
            else if(a[i].r > current.r)
                current.r = a[i].r;
        } 
        total += current.r-current.l;
        return total;
    }
//______________________________________________________
    //Question 4: O(logn)
    public static int q4(int a[]){
        int l=0, h=a.length-1;
        while(l<=h){
            int m = (l+h)/2;
            if(a[m] == m+3) return a[m];
            if(a[m] <  m+3) l=m+1;
            if(a[m] >  m+3) h=m-1;
        }
        return a[l]==l+1? a[l] : -1111;
    }
//______________________________________________________
    //Question 5: O(n) (Based on a formula to find a median)
    public static int median(int a[]){
        CountingSort(a,255);    //O(n)
        return a[a.length/2];
    }
    //Counting-Sort: O(n)
    private static void CountingSort(int a[], int bound) {
        int t[] = new int[bound+1];
        for(int i=0; i<a.length; i++)
            t[a[i]]++;
        for(int i=0,k=0; i<t.length; i++)
            for(int j=0; j<t[i]; j++)
                a[k++] = i;
    }
//______________________________________________________
    //Question 6: O(n^2)
    public static void dedup(String a[]){
        boolean b;
        for(int i=0; i<a.length; i++){
            b = true;
            for(int j=0; j<i; j++)
                if(a[i].equals(a[j]))
                   b = false;
            if(b) System.out.print(a[i]+" ");

        }
    }
// ______________________________________________________
    //Quick-sort intervals for question 3
    private static void quickSort_Intervals(Interval a[]) {
        quick_sort(a, 0, a.length-1);
    }
    private static void quick_sort(Interval a[], int l, int h) {
        if(l>=h) return;
        int p=partition(a,l,h);
        quick_sort(a, l, p-1);
        quick_sort(a, p+1, h);
    }
    public static int partition (Interval a[], int l, int h){
        if(l>=h) return l;
        int p=l, i=l+1, j=h;
        while(i<=j){
            if(a[i].l<=a[p].l)      i++;
            else if(a[j].l>a[p].l)  j--;
            else                swap(a,i,j);
        }
        swap(a,p,j);
        return j;
    }
    private static void swap(Interval a[], int i, int j) {
        Interval t = new Interval(a[i]);
        a[i] = new Interval(a[j]);
        a[j]= new Interval(t);
    }
    private static class Interval{
        private double l, r;
        public Interval(double l, double r){
            this.l = l;
            this.r = r;
        }
        public Interval(Interval i){
            this.l = i.l;
            this.r = i.r;
        }
    }
}