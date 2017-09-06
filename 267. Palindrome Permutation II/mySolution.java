class Solution {
    public List<String> generatePalindromes(String s) {
        int odd = 0;
        List<String> res = new ArrayList<>();
        List<Character> list = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        String mid = "";
        // step 1. build count map and count the odds
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            odd += map.get(c) % 2 == 0? -1 : 1;
        }
        // can not form a palindromic string
        if (odd > 1) return res;

        // step 2. add half count of each character to list;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char key = entry.getKey();
            int val = entry.getValue();

            if (val % 2 != 0) mid += key;
            for (int i = 0; i < val / 2; i++) {
                list.add(key);
            }
        }

        // step 3. generate all the permutations
        getPerm(list, mid, new boolean[list.size()], new StringBuilder(), res);
        return res;
    }
    // backtrack get all permutaions:
    private void getPerm(List<Character> list, String mid, boolean[] used, StringBuilder sb, List<String> res) {
        if (sb.length() == list.size()) {
            // form the palindromic string
            res.add(sb.toString() + mid + sb.reverse().toString());
            sb.reverse();
            return;
        }
        
        for (int i = 0; i < list.size(); i++) {
            if (i > 0 && list.get(i) == list.get(i - 1) && !used[i - 1]) continue;

            if (!used[i]) {
                used[i] = true;
                sb.append(list.get(i));
                getPerm(list, mid, used, sb, res);
                sb.deleteCharAt(sb.length() - 1);
                used[i] = false;
            }
        }
    }
}