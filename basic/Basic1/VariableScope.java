public class VariableScope {

    static int globalVar = 100;

    public static void main(String[] args) {
        int localVar = 50;
        System.out.println("Global: " + globalVar);
        System.out.println("Local: " + localVar);
    }
}