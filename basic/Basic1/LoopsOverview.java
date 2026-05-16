public class LoopsOverview {
    public static void main(String[] args) {

        System.out.println("For Loop:");
        for (int i = 1; i <= 3; i++) {
            System.out.println(i);
        }

        System.out.println("While Loop:");
        int j = 1;
        while (j <= 3) {
            System.out.println(j);
            j++;
        }

        System.out.println("Do While Loop:");
        int k = 1;
        do {
            System.out.println(k);
            k++;
        } while (k <= 3);
    }
}