import java.util.Arrays;
import java.util.Scanner;
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       	String ip1 = "1.1.1.1";
        String ip2 = "1.1.1.1";
        String ip3 = "2.2.2.2";
        String ip4 = "3.3.3.3";
        
        boolean flag = helper(ip1, ip2, ip3, ip4);
        if (flag) {
            System.out.print("Overlap IP");
        } else {
            System.out.print("No Overlap IP");
        }
    }
    
    static boolean helper(String ip1, String ip2, String ip3, String ip4) {
        String[] s1 = ip1.split("\\.");
        String[] s2 = ip2.split("\\.");
    	String[] s3 = ip3.split("\\.");
        String[] s4 = ip4.split("\\.");
        System.out.println(s1[0]);
        for (int i = 0; i < s1.length; i++) {
            System.out.print(1);
            int a = Integer.parseInt(s1[i]);
            int b = Integer.parseInt(s2[i]);
            int c = Integer.parseInt(s3[i]);
            int d = Integer.parseInt(s4[i]);
            System.out.println(doOverlap(a, b, c, d));
            if (doOverlap(a, b, c, d) == -1) return false;
            else if (doOverlap(a, b, c, d) == 1) return true;
        }
        return true;
    }
    
    static int doOverlap(int a, int b, int c, int d) {
        if (a == c && a == b && a == d) return 0;
        if (a > c) {
            if (a < d) return 1;
            else if (a == d) return 0;
            else return -1;
        } else if (a < c) {
            if (b > c) return 1;
            else if (b == c) return 0;
            else return -1;
        } else {
            return 1;
        }
    }
}