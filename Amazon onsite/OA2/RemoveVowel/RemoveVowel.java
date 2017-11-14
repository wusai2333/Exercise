public class RemoveVowel {
    public static String removeVowel(String s) {
        String vowels = "aeiouAEIOU";
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (vowels.indexOf(ch) == -1) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "HelloWorld";
        System.out.println(RemoveVowel.removeVowel(s));
    }
}