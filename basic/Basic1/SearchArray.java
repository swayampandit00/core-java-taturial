public class SearchArray {
    public static void main(String[] args) {
        int[] arr = {5, 10, 15, 20};
        int target = 15;

        boolean found = false;
        for (int num : arr) {
            if (num == target) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Element found");
        } else {
            System.out.println("Element not found");
        }
    }
}