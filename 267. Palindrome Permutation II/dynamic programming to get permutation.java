// besides backtrack we can also use the dynamic programming
class Solution {
    public List<String> generatePalindromes(String s) {
        int odd = 0;
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        String mid = "";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.containsKey(c)? map.get(c) + 1 : 1);
            odd += map.get(c) % 2 == 0? -1 : 1;
        }

        if (odd > 1) return res;

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char c = entry.getKey();
            int count = entry.getValue();
            
            if (count % 2 != 0) mid += c;
            for (int i = 0; i < count / 2; i++) {
                sb.append(c);
            }
        }
        
        Set<String> permutations = getPerm(sb.toString());
        for (String perm : permutations) {
            res.add(perm + mid + new StringBuilder(perm).reverse());
        }
        return res;
    }

    Set<String> getPerm(String letters) {
        Set<String> result = new HashSet<>();
        if (letters.length() == 0) return result;
        if (letters.length() == 1) {
            result.add(letters);
            return result;
        }
        char c = letters.charAt(0);
        Set<String> subSet = getPerm(letters.substring(1));
        for (String str: subSet) {
            int len = str.length();
            for (int i = 0; i <= len; i++) {
                result.add(str.substring(0, i) + c + str.substring(i, len));
            }
        }
        return result;
    }
}