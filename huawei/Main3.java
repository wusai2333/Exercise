import java.util.Scanner;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class Main3 {
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // String nums = sc.nextLine();
        String nums = "1223 22 3232 2016";
        int idx = 3;
        String[] ss = nums.split(" ");
        List<Integer> result = new ArrayList<Integer>();
        for (String s : ss) {
            result.add(Integer.parseInt(s));
        }
        Collections.sort(result, new IntegerComparator());
        System.out.println(Arrays.toString(result.toArray()));
        System.out.print(result.get(idx-1));
    }
    
    static class IntegerComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer a, Integer b) {
            int[] d = new int[]{1, 10, 100};
            int newA = 0;
            int newB = 0;
          	for (int i = 0; i < 3; i++) {
                int r = a % 10;
                a /= 10;
                newA = r * d[i] + newA;
            }
            for (int i = 0; i < 3; i++) {
                int r = b % 10;
                b /= 10;
                newB = r * d[i] + newB;
            }
            return newA - newB;
        }
    }
}