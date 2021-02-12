
/******************************************************************************
*  @author Nathanael Benichou
*  https://github.com/Golem97
*  Data Structures 2020 - CS Ariel university
*  Exercise - 
******************************************************************************/
public class ex10 {
    public static void main(String[] args) {
        MyHashTable map = new MyHashTable(4);
        map.insert(273945045, new Student("Eyal", 27));
        map.insert(285846919, new Student("Yossi", 23));
        map.insert(217893648, new Student("Dani", 21));
        map.insert(306352894, new Student("John", 25));
        map.insert(263894752, new Student("Fred", 22));
        map.insert(308284652, new Student("Tal", 28));
        map.insert(279365927, new Student("David", 21));
        map.insert(297356496, new Student("Tamar", 29));
        map.insert(209374864, new Student("Adi", 22));
        map.insert(497662478, new Student("Michal", 19));
        map.insert(317524017, new Student("Dora", 31));
        map.insert(278350148, new Student("Gil", 25));
        System.out.println(map);
        System.out.println("Removed: "+ map.remove("273945045"));
        System.out.println("Removed: "+ map.remove("209374864"));
        System.out.println("Removed: "+ map.remove("278350148"));
        System.out.println("Removed: "+ map.remove("279365927"));
        System.out.println("Removed: "+ map.remove("285846919"));
        System.out.println("\n"+map);

        System.out.println(map.get("297356496"));
        System.out.println(map.get("306352894"));
        System.out.println(map.get("308284652"));
    }
}