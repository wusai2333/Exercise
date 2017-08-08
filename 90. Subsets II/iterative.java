import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        Arrays.sort(nums);
        for(int i = 0; i < nums.length;) {
            int count = 0;
            while (i + count < nums.length && nums[count + i] == nums[i]) count++;
            int previousN = res.size();
            for (int k = 0; k < previousN; k++) {
                List<Integer> list = new ArrayList<Integer>(res.get(k));
                for(int j = 0; j < count; j++) {
                    list.add(nums[i]);
                    res.add(new ArrayList<Integer>(list));
                }
            }
            i += count;
        }
        return res;
    }
}