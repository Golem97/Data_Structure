
/******************************************************************************
*  @author Nathanael Benichou
*  https://github.com/Golem97
*  Data Structures 2020 - CS Ariel university
*  Exercise - 
******************************************************************************/
public class Student {
    private String name;
    private int age;
    public Student(String n, int a){
        name = n;
        age = a;
    }

    public void setName(String n){
        name = n;
    }

    public String getName(){
        return name;
    }
    public void setAge(int a){
        age = a;
    }

    public int getAge(){
        return age;
    }

    public String toString(){
        return name+"("+age+")";
    }
}