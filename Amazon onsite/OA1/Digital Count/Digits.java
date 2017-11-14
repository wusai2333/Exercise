public class Digits {
    public static int countDigits(int num) {
        int count = 0;
        int input = num; // num has been changed in the original code.
        while( num != 0) {
            num = num /10;
            count ++;
        }
        return (input % count);
    }

    public static void main(String[] args) {
        int num = 100;
        int res = Digits.countDigits(num);
        System.out.print(res);
    }
}