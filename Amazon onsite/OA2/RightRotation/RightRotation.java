public class RightRotation {
    public static int rightRotaion(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0 || s1.length() != s2.length()) {
            return -1;
        }
        String s = s1 + s1;
        if (s.indexOf(s2) == -1) {
            return -1;
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        String s1 = "abcd", s2 = "dabc";
        System.out.print(RightRotation.rightRotaion(s1, s2));
    }
}