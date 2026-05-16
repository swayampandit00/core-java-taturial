public class ArraySearchExample {
    public static void main(String[] args) {
        int[] arr = {5, 15, 25, 35};
        int target = 25;
        boolean found = false;

        for (int num : arr) {
            if (num == target) {
                found = true;
                break;
            }
        }

        System.out.println(found ? "Found" : "Not Found");
    }
}