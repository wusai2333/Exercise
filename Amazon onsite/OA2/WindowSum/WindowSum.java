import java.util.*;
public class WindowSum {
    public static List<Integer> getSum(List<Integer> A, int k) {
        List<Integer> result = new ArrayList<Integer>();
        if (A == null || A.size() == 0 || k <= 0) return result;
        int count = 0;
        for (int i = 0; i < A.size(); i++) {
            count ++;
            if (count >= k) {
                int sum = 0;
                for (int j = i; j >= i - k + 1; j--) {
                    sum += A.get(j);
                }
                result.add(sum);
            }
        }
        return result;
    }

    public static List<Integer> getSum2(List<Integer> list, int k) {
        List<Integer> result = new ArrayList<>();
        if (list == null || list.size() == 0 || k <= 0) return result;
        int sum = 0;
        if (k >= list.size()) {
            for (int i : list) sum += i;
            result.add(sum);
            return result;
        }
        for (int i = 0; i < k; i++) {
            sum += list.get(i);
        }
        result.add(sum);
        for (int i = k; i < list.size(); i++) {
            sum = sum - list.get(i - k) + list.get(i);
            result.add(sum);
        }
        return result;
    }
    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        List<Integer> result = WindowSum.getSum(A, 3);
        List<Integer> result2 = WindowSum.getSum2(A, 3);
        System.out.print(Arrays.toString(result.toArray()));
        System.out.print(Arrays.toString(result2.toArray()));
    }
}