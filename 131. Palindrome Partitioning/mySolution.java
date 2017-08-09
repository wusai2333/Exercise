import java.util.ArrayList;

public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backTrack(s, new ArrayList<>(), res, 0);
        return res;
    }

    private void backTrack(String s, List<String> list, List<List<String>> res, int start) {
        if (start == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (isPalidrome(s, start, i)) {
                list.add(s.substring(start, i+1));
                backTrack(s, list, res, i+1);
                list.remove(list.size()-1);
            }
        }
    }

    private boolean isPalidrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) return false;
        }
        return true;
    }
}