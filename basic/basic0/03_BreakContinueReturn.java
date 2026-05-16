public class BreakContinueReturn {
    public static void main(String[] args) {

        for (int i = 1; i <= 5; i++) {
            if (i == 3) continue;
            if (i == 5) break;
            System.out.println(i);
        }

        showMessage();
    }

    public static void showMessage() {
        System.out.println("Return example method executed.");
        return;
    }
}