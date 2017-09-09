class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        int len = s.length();
        for (int i = 1; i <= 3 && i < len - 2; i++) {
            if (len - i > 9) continue;
            for (int j = i + 1; j <= i + 3 && j < len - 1; j++) {
                if (len - j > 6) continue;
                for (int k = j + 1; k <= j + 3 && k < len; k++) {
                    String s1 = s.substring(0, i), s2 = s.substring(i, j), s3 = s.substring(j, k), s4 = s.substring(k, len);
                    if (valid(s1) && valid(s2) && valid(s3) && valid(s4)) {
                        res.add(s1+"."+s2+"."+s3+"."+s4);
                    }
                }
            }
        }
        return res;
    }

    boolean valid(String s) {
        if (s.length() > 3 || s.length() == 0 || (s.charAt(0) == '0' && s.length() > 1) || Integer.parseInt(s) > 255) {
            return false;
        }
        return true;
    }
}