import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = String.valueOf(n);
        int sign = 0;
        if (n < 0) sign = 1;
        int length = sign == 1 ? s.length() - 1: s.length();
        System.out.println(length);
       	if (sign == 1) System.out.print("-");
        for (int i = sign; i < s.length(); i++) {
            if (i < s.length() - 1)
                System.out.print(s.charAt(i)+ " ");
            else
                System.out.print(s.charAt(i));
        }
        System.out.println();
        if(sign == 1) System.out.print("-");
        for (int i = s.length() - 1; i >= s.length() - length; i--) {
            System.out.print(s.charAt(i));
        }
        
    }
}