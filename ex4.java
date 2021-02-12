
import java.util.Arrays;
/******************************************************************************
*  @author Nathanael Benichou
*  https://github.com/Golem97
*  Data Structures 2020 - CS Ariel university
*  Exercise 4 - Sort, merge and search
******************************************************************************/
public class ex4 {
    public static void main(String[] args) {
    /* Testing question 1: */
        int a1_1[] = {1,8,15};
        int a1_2[] = {3,4,10,11};
        int a1_3[] = {5,7,9};
        System.out.println(Arrays.toString(q1(a1_1, a1_2, a1_3)));

    /* Testing question 2: */
        int a2[] = {1,2,3,4,5};
        System.out.println(Arrays.toString(a2));
        System.out.println(q2(a2));

    /* Testing question 3: */
        Point p[] = new Point[6];
        p[0] = new Point(9, 3);
        p[1] = new Point(-2, 8);
        p[3] = new Point(-5, 9);
        p[4] = new Point(-7, -4);
        p[2] = new Point(2, -8);
        p[5] = new Point(1, 0);
        System.out.println(q3(p));

    /* Testing question 4: */
        int arr[] = {2,4,6,7,8,9,11,23,44,45,67,67,89};
        System.out.println(q4(arr, 18));

    /* Testing question 5: */
        int a5_1[] = {6,8,33,2,4,1,0,44,5,9};
        int a5_2[] = {4,7,0,3,45,77,8,3,3,7};
        System.out.println(Arrays.toString(q5(a5_1 , a5_2)));
    }
//______________________________________________________
    //Question 1: O(n1+n2+n3)
    public static int[] q1(int a1[], int a2[], int a3[]){
        return merge(a1, merge(a2, a3));
    }
    private static int[] merge(int a1[], int a2[]){
        int b[] = new int[a1.length+a2.length];
        int i=0, j=0, k=0;
        for(k=0; i<a1.length && j<a2.length; k++){
            if(a1[i]<a2[j]) b[k] = a1[i++];
            else            b[k] = a2[j++];
        }
        while(i<a1.length) b[k++] = a1[i++];
        while(j<a2.length) b[k++] = a2[j++];
        return b;
    }
//______________________________________________________
    //Question 2: O(logn)
    public static boolean q2(int a[]){
        return bs(a, 0, a.length-1);
    }
    private static boolean bs(int[] a, int l, int h) {
        if(l>h) return false;
        int m = (h+l)/2;
        if(a[m] == m)   return true;
        if(a[m] > m)    return bs(a, l, m-1);
        else            return bs(a, m+1, h);
    }
//______________________________________________________
    //Question 3: O(nlogn)
    private static class Point {
        private int x,y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        public String toString(){
            return "("+x+","+y+")";
        }
    }
    public static boolean q3(Point a[]){
        mergeSort(a, 0, a.length-1);
        for (int i = 0; i < a.length-1; i++)
            if(a[i].x == -a[i+1].x && a[i].y == -a[i+1].y)
                return true;
        return false;
    }
    private static void mergeSort(Point[] a, int l, int h) {
        if(l>=h) return;
        int m = (l+h)/2;
        mergeSort(a, l, m);
        mergeSort(a, m+1, h);
        merge2(a,l,m,h);
    }
    private static void merge2(Point[] a, int l, int m, int h) {
        Point t[] = new Point[h-l+1];
        int i=l, j=m+1;
        int k=0;
        while(i<=m && j<=h){
            if(Math.abs(a[i].x)<Math.abs(a[j].x))
               t[k++]=a[i++];
            else            t[k++]=a[j++];
        }
        while(i<=m)     t[k++]=a[i++];
        while(j<=h)     t[k++]=a[j++];
        //copy from t to a
        for(i=0; i<t.length; i++)   
            a[l+i]=t[i];
    }
//______________________________________________________
    //Question 4: O(n)
    public static boolean q4(int arr[], int a){
        int i=0, j=arr.length-1;
        while(i<j) {
            if(arr[i]+arr[j] == a)  return true;
            if(arr[i]+arr[j] < a)   i++;
            else                    j--;
        }
        return false;
    }
//______________________________________________________
    //Question 5: O(nlogn)
    public static int[] q5(int a[], int b[]){
        mergeSort(a);               //O(nlogn)
        mergeSort(b);               //O(nlogn)
        int count = 0, n = a.length;
        int t[] = new int[n];
        for(int i=0; i<n; i++)      //O(nlogn)
            if(binarySearch(b, a[i]) != -1)
                t[count++] = a[i];
        return Arrays.copyOf(t, count); //O(n)
    }

    //************ Another Option ******************
    //Question 5: O(nlogn) 
    public static int[] q5_2(int a[], int b[]){
        mergeSort(a);               //O(nlogn)
        mergeSort(b);               //O(nlogn)
        int count = 0, i=0, j=0, n = a.length;
        int t[] = new int[n];
        while(i<n && j<n){          //O(n)
            if(a[i] == b[j]){
                t[count++] = a[i];
                i++;
                j++;
            }
            else if (a[i]<b[j]) i++;
            else if (a[i]>b[j]) j++;
        }
        return Arrays.copyOf(t, count); //O(n)
    }
//______________________________________________________
    //Merge-Sort and BinarySearch for question 5
    private static void mergeSort(int[] a) {
        mergeSort(a, 0, a.length-1);
    }
    private static void mergeSort(int[] a, int l, int h) {
        if(l>=h) return;
        int m = (l+h)/2;
        mergeSort(a, l, m);
        mergeSort(a, m+1, h);
        merge(a,l,m,h);
    }
    private static void merge(int[] a, int l, int m, int h) {
        int t[] = new int[h-l+1];
        int i=l, j=m+1;
        int k=0;
        while(i<=m && j<=h){
            if(a[i]<a[j])   t[k++]=a[i++];
            else            t[k++]=a[j++];
        }
        while(i<=m)     t[k++]=a[i++];
        while(j<=h)     t[k++]=a[j++];

        //copy from t to a
        for(i=0; i<t.length; i++)   
            a[l+i]=t[i];
    }
    public static int binarySearch(int[] a, int val){
        int l = 0;
        int h = a.length-1;
        while(l<=h){
            int m = (l+h)/2;
            if(val==a[m]) return m;
            if(val<a[m])    h=m-1;
            if(val>a[m])    l=m+1;
        }
        return -1;
    }
    

}