public class ArrayTraversal {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40};
        System.out.println("this is first method");

        for (int num : arr) {
            System.out.println(num);
        }

        System.out.println("this is second method");
        for(int i = 0; i<= arr.length;i++){

            System.out.println(arr[i]);

        }
    }
}


