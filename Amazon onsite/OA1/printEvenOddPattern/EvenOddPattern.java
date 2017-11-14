public class EvenOddPattern {
    public static void printPattern (int num) {
        int i, print = 0;
        if (num % 2 == 0) {
            print = 0;
            for (i = 0; i < num; i++) {
                System.out.print(print + " ");
                print += 2;
            }
        } else {
            print = 1;
            for (i = 0; i < num; i++) {
                System.out.print(print + " ");
                print += 2;
            }
        }
    }

    public static void main(String[] args) {
        int num = 3;
        EvenOddPattern.printPattern(num);
    }
}