class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        if (num == null || num.length() == 0) return result;
        backTrace(num, result, "", target, 0, 0, 0);
        return result;
    }

    private void backTrace(String num, List<String> result, String path, int target, int pos, long eval, long multed) {
        if (pos == num.length()) {
            if (target == eval) {
                result.add(path);
            }
            return;
        }
        for (int i = pos; i < num.length(); i++) {
            if (i != pos && num.charAt(pos) == '0') break;
            long cur = Long.parseLong(num.substring(pos, i+1));
            if (pos == 0) {
                backTrace(num, result, path + cur, target, i + 1, cur, cur);
            } else {
                backTrace(num, result, path + "+" + cur, target, i + 1, eval + cur, cur);

                backTrace(num, result, path + "-" + cur, target, i + 1, eval - cur, -cur);

                backTrace(num, result, path + "*" + cur, target, i + 1, eval - multed + multed * cur, multed * cur);
            }
        }
    }
}