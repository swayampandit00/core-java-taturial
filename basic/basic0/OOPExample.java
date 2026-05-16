class Student {
    String name = "Rahul";
    void display(){
        System.out.println(name);
    }
}
public class OOPExample {
    public static void main(String[] args) {
        Student s = new Student();
        s.display();
    }
}