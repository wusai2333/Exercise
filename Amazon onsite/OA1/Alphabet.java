public class Alphabet {
    public static void main(String[] args) {
        char ch = 'A';
        for (int i = 0; i < 26; i++) {
            System.out.print(ch++ + ", " + (i+1) + '|');
        }
    }
}