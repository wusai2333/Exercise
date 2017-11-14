import java.util.Arrays;
public class DaysChange {
    public static int[] Solution(int[] days, int n) {
        if (days == null || n <= 0) return days;
        int length = days.length;
        int[] result = new int[length + 2];
        int pre = result[0]; // memorize the value of yesterday
        for (int i = 1; i <= length; i++) {
            result[i] = days[i-1];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= length; j++) {
                int temp = result[j]; // yesterday's value
                result[j] = (pre == result[j+1]) ? 0 : 1;
                pre = temp;
            }
            System.out.println(Arrays.toString(Arrays.copyOfRange(result, 1, length+1)));
        }
        return Arrays.copyOfRange(result, 1, length+1);
    }

    public static int[] dayChange(int[] days, int n) {
        if (days == null || days.length == 0 || n <= 0)
            return days;
        int[] result = new int[days.length + 2];
        int pre = result[0];
        for (int i = 1; i < result.length - 1; i++) {
            result[i] = days[i-1];
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < result.length - 1; j++) {
                int temp = result[j];
                result[j] = (pre == result[j+1]) ? 0 : 1;
                pre = temp;
            }
        }
        
        return Arrays.copyOfRange(result, 1, days.length+1);
    }

    public static void main(String[] args) {
        int[] days = new int[]{0,1,2,1,3,2,3,1,1,2,2,2};
        System.out.print(Arrays.toString(DaysChange.Solution(days, 5)));
        System.out.print(Arrays.toString(DaysChange.dayChange(days, 5)));
    }
}